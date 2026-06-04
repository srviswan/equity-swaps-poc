package com.pb.swap.archiver.engine;

import com.pb.swap.archiver.auth.ConnectionFactory;
import com.pb.swap.archiver.config.ArchiverProperties;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Post-archive statistics maintenance. Deleting large slices from a source table leaves its
 * statistics stale, which is the classic cause of plan regressions after an archive run (the
 * original risk called out in the design). When {@code archive_job.update_stats_after} is set, the
 * engine runs {@code UPDATE STATISTICS} on every in-scope source table at the end of a successful
 * run so the optimiser sees fresh row counts and histograms on the now-smaller tables.
 *
 * <p>This is best-effort: a stats failure is logged but never fails an otherwise-successful archive
 * (the data move already committed). Jobs that prefer a dedicated maintenance window (full-scan
 * stats on a 1 TB table are expensive) can turn the flag off.
 */
@Component
public class StatsMaintainer {

    private static final Logger log = LoggerFactory.getLogger(StatsMaintainer.class);

    private final JdbcTemplate controlJdbc;
    private final ConnectionFactory connections;
    private final ArchiverProperties props;

    public StatsMaintainer(JdbcTemplate controlJdbc, ConnectionFactory connections, ArchiverProperties props) {
        this.controlJdbc = controlJdbc;
        this.connections = connections;
        this.props = props;
    }

    /**
     * Refresh statistics on every in-scope source table when the job opts in. Returns the number of
     * tables refreshed (0 when disabled or nothing in scope).
     */
    public int updateStatsAfterArchive(String jobName) {
        Boolean enabled =
                controlJdbc.queryForObject(
                        "SELECT update_stats_after FROM archive_job WHERE job_name = ?", Boolean.class, jobName);
        if (enabled == null || !enabled) {
            log.debug("Stats maintenance disabled for job {}", jobName);
            return 0;
        }
        List<Map<String, Object>> tables =
                controlJdbc.queryForList(
                        "SELECT source_schema, source_table FROM archive_table WHERE job_name = ? AND enabled = 1",
                        jobName);
        if (tables.isEmpty()) {
            return 0;
        }
        int refreshed = 0;
        try (Connection conn = connections.open(props.source())) {
            for (Map<String, Object> t : tables) {
                String schema = String.valueOf(t.get("source_schema"));
                String table = String.valueOf(t.get("source_table"));
                String qualified = q(schema) + "." + q(table);
                try (Statement st = conn.createStatement()) {
                    st.execute("UPDATE STATISTICS " + qualified);
                    refreshed++;
                    log.info("Refreshed statistics on source table {}", schema + "." + table);
                } catch (SQLException e) {
                    log.warn("Stats refresh failed on {}; continuing: {}", schema + "." + table, e.getMessage());
                }
            }
        } catch (SQLException e) {
            log.warn("Could not open source connection for stats maintenance; skipping: {}", e.getMessage());
        }
        return refreshed;
    }

    private static String q(String identifier) {
        return "[" + identifier.replace("]", "]]") + "]";
    }
}
