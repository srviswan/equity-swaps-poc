package com.pb.swap.archiver.engine;

import com.pb.swap.archiver.auth.ConnectionFactory;
import com.pb.swap.archiver.config.ArchiverProperties;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Builds/refreshes {@code basket_archive_state} from a source basket dimension (e.g. {@code
 * DimBasket}) so eligibility is computed from lifecycle data rather than a per-row flag on the fact
 * tables. Classification:
 *
 * <ul>
 *   <li><b>TERMINATED</b> — terminated with a known termination date (becomes eligible once dormant
 *       past {@code retention_months});
 *   <li><b>NEEDS_REVIEW</b> — terminated but the termination date is missing (quarantined, never
 *       auto-archived);
 *   <li><b>ACTIVE</b> — still live.
 * </ul>
 *
 * <p>Already-archived baskets ({@code archived = 1}) are never overwritten. When the job has no
 * basket source configured the refresh is skipped (an operator/ETL seeds the table directly).
 */
@Component
public class BasketStateRefresher {

    private static final Logger log = LoggerFactory.getLogger(BasketStateRefresher.class);
    private static final int BATCH = 1000;

    private final JdbcTemplate controlJdbc;
    private final ConnectionFactory connections;
    private final ArchiverProperties props;

    public BasketStateRefresher(
            JdbcTemplate controlJdbc, ConnectionFactory connections, ArchiverProperties props) {
        this.controlJdbc = controlJdbc;
        this.connections = connections;
        this.props = props;
    }

    /** @return number of basket rows upserted, or 0 when no source is configured. */
    public int refresh(String jobName) {
        Map<String, Object> cfg;
        try {
            cfg =
                    controlJdbc.queryForMap(
                            "SELECT basket_source_table, basket_key_column, basket_status_column,"
                                    + " basket_termination_column, basket_terminated_value FROM archive_job"
                                    + " WHERE job_name = ?",
                            jobName);
        } catch (RuntimeException e) {
            log.warn("Cannot read basket-source config for job {}; skipping refresh: {}", jobName, e.getMessage());
            return 0;
        }
        String sourceTable = (String) cfg.get("basket_source_table");
        if (sourceTable == null || sourceTable.isBlank()) {
            log.info("No basket source configured for job {}; assuming basket_archive_state is seeded.", jobName);
            return 0;
        }
        String keyCol = orDefault((String) cfg.get("basket_key_column"), "basket_key");
        String statusCol = (String) cfg.get("basket_status_column");
        String termCol = (String) cfg.get("basket_termination_column");
        String terminatedValue = (String) cfg.get("basket_terminated_value");

        List<Object[]> upserts = new ArrayList<>();
        int total = 0;
        StringBuilder select = new StringBuilder("SELECT " + q(keyCol) + " AS basket_key");
        select.append(termCol == null ? ", CAST(NULL AS DATE) AS term_date" : ", " + q(termCol) + " AS term_date");
        select.append(statusCol == null ? ", CAST(NULL AS VARCHAR(64)) AS status" : ", " + q(statusCol) + " AS status");
        select.append(" FROM ").append(qName(sourceTable));

        try (Connection src = connections.open(props.source());
                Statement st = src.createStatement();
                ResultSet rs = st.executeQuery(select.toString())) {
            while (rs.next()) {
                long basketKey = rs.getLong("basket_key");
                Date termDate = rs.getDate("term_date");
                String status = rs.getString("status");
                String archiveStatus = classify(status, terminatedValue, termDate);
                upserts.add(new Object[] {basketKey, termDate, archiveStatus});
                if (upserts.size() >= BATCH) {
                    total += flush(upserts);
                    upserts.clear();
                }
            }
            total += flush(upserts);
        } catch (SQLException e) {
            throw new IllegalStateException("basket-state refresh failed reading " + sourceTable + ": " + e.getMessage(), e);
        }
        log.info("Refreshed basket_archive_state for job {} from {}: {} basket(s)", jobName, sourceTable, total);
        return total;
    }

    /** Terminated + dated → TERMINATED; terminated + undated → NEEDS_REVIEW; else ACTIVE. */
    private static String classify(String sourceStatus, String terminatedValue, Date termDate) {
        boolean terminated;
        if (terminatedValue != null) {
            terminated = terminatedValue.equalsIgnoreCase(sourceStatus);
        } else {
            terminated = termDate != null;
        }
        if (!terminated) {
            return "ACTIVE";
        }
        return termDate != null ? "TERMINATED" : "NEEDS_REVIEW";
    }

    private int flush(List<Object[]> rows) {
        if (rows.isEmpty()) {
            return 0;
        }
        // MERGE keeps the engine-owned archived state intact (only refreshes non-archived rows).
        int[] counts =
                controlJdbc.batchUpdate(
                        "MERGE basket_archive_state AS tgt"
                                + " USING (VALUES (?, ?, ?)) AS src(basket_key, termination_date, status)"
                                + " ON tgt.basket_key = src.basket_key"
                                + " WHEN MATCHED AND tgt.archived = 0 THEN UPDATE SET"
                                + " termination_date = src.termination_date, status = src.status,"
                                + " last_refreshed_at = SYSUTCDATETIME()"
                                + " WHEN NOT MATCHED THEN INSERT (basket_key, termination_date, status)"
                                + " VALUES (src.basket_key, src.termination_date, src.status);",
                        rows);
        return counts.length;
    }

    private static String orDefault(String v, String def) {
        return v == null || v.isBlank() ? def : v;
    }

    private static String qName(String schemaDotTable) {
        String[] parts = schemaDotTable.split("\\.", 2);
        return parts.length == 2 ? q(parts[0]) + "." + q(parts[1]) : q(parts[0]);
    }

    private static String q(String identifier) {
        return "[" + identifier.replace("]", "]]") + "]";
    }
}
