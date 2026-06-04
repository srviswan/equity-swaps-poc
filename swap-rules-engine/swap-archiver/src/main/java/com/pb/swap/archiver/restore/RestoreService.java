package com.pb.swap.archiver.restore;

import com.pb.swap.archiver.auth.ConnectionFactory;
import com.pb.swap.archiver.config.ArchiverProperties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Investigative restore: the reverse pipeline. Pulls archived rows back out of the archive tables
 * into a <em>separate investigation DB</em> (never the live source by default — a dead surrogate
 * would confuse BAU), located by lineage ({@code archive_batch_id}, which is the archive
 * {@code run_id} stamped on every archived row, optionally resolved from a basket key).
 *
 * <p>Rows are restored in <b>parent → child</b> order ({@code dependency_level} ascending), the
 * reverse of the delete order, so a restored hierarchy is logically consistent. The investigation
 * table is created from the archive table's shape on first use, and each restore is idempotent
 * (prior rows for the same batch are cleared first) and audited in {@code archive_restore_log}.
 */
@Component
public class RestoreService {

    private static final Logger log = LoggerFactory.getLogger(RestoreService.class);

    private final ConnectionFactory connections;
    private final ArchiverProperties props;
    private final JdbcTemplate controlJdbc;

    public RestoreService(ConnectionFactory connections, ArchiverProperties props, JdbcTemplate controlJdbc) {
        this.connections = connections;
        this.props = props;
        this.controlJdbc = controlJdbc;
    }

    /** Outcome of a restore run. */
    public record RestoreSummary(List<Long> batchIds, int tables, long rowsRestored, String targetDb) {}

    /**
     * Restore the configured scope ({@code archiver.restore.baskets} and/or
     * {@code archiver.restore.batchIds}) into the investigation DB.
     */
    public RestoreSummary restore(String jobName) {
        ArchiverProperties.Restore cfg = props.restore();
        if (cfg == null) {
            throw new IllegalStateException("restore configuration missing (archiver.restore.*)");
        }
        String investigationDb = cfg.targetDb();
        guardNotLiveSource(cfg, investigationDb);

        List<Long> batchIds = resolveBatchIds(cfg);
        if (batchIds.isEmpty()) {
            throw new IllegalArgumentException(
                    "no restore scope: set archiver.restore.batchIds and/or archiver.restore.baskets");
        }
        String inList = batchIds.stream().map(String::valueOf).collect(Collectors.joining(","));

        List<Table> tables = loadTables(jobName);
        long restoreId = openRestoreLog(batchIds, investigationDb);
        long total = 0;
        try (Connection conn = connections.open(props.target())) {
            for (Table t : tables) {
                total += restoreTable(conn, t, investigationDb, inList);
            }
            completeRestoreLog(restoreId, "DONE", total);
            log.info(
                    "RESTORE_SUMMARY restore_id={} batches=[{}] tables={} rows={} target_db={}",
                    restoreId, inList, tables.size(), total, investigationDb);
            return new RestoreSummary(batchIds, tables.size(), total, investigationDb);
        } catch (SQLException | RuntimeException e) {
            completeRestoreLog(restoreId, "FAILED", total);
            log.error("ALERT restore_id={} RESTORE FAILED after {} row(s): {}", restoreId, total, e.getMessage());
            throw new IllegalStateException("restore failed: " + e.getMessage(), e);
        }
    }

    /**
     * Restore one table's archived rows for the in-scope batches. Creates the investigation table
     * from the archive table's shape on first use, clears any prior rows for these batches
     * (idempotent re-run), then copies the rows across by lineage. Returns rows restored.
     */
    private long restoreTable(Connection conn, Table t, String investigationDb, String inList) throws SQLException {
        String archive = qName(t.schema(), t.table());
        String investigation = qName(investigationDb, t.schema(), t.table());

        Set<String> archiveCols = columns(conn, null, t.schema(), t.table());
        if (!containsIgnoreCase(archiveCols, "archive_batch_id")) {
            throw new SQLException(
                    "archive table " + t.schema() + "." + t.table()
                            + " has no archive_batch_id column — cannot restore by lineage");
        }
        ensureInvestigationTable(conn, investigationDb, t, archive, investigation);

        String cols = archiveCols.stream().map(RestoreService::q).collect(Collectors.joining(", "));
        try (Statement st = conn.createStatement()) {
            st.execute("DELETE FROM " + investigation + " WHERE archive_batch_id IN (" + inList + ")");
        }
        long rows;
        try (Statement st = conn.createStatement()) {
            rows =
                    st.executeUpdate(
                            "INSERT INTO " + investigation + " (" + cols + ") SELECT " + cols + " FROM " + archive
                                    + " WHERE archive_batch_id IN (" + inList + ")");
        }
        log.info("Restored {} row(s) for {} → {}", rows, t.schema() + "." + t.table(), investigationDb);
        return rows;
    }

    /** Create the investigation table from the archive table's shape if it does not yet exist. */
    private void ensureInvestigationTable(
            Connection conn, String investigationDb, Table t, String archive, String investigation)
            throws SQLException {
        String objId = investigationDb + "." + t.schema() + "." + t.table();
        try (Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT OBJECT_ID('" + objId + "')")) {
            if (rs.next() && rs.getObject(1) != null) {
                return;
            }
        }
        try (Statement st = conn.createStatement()) {
            st.execute("SELECT * INTO " + investigation + " FROM " + archive + " WHERE 1 = 0");
            log.info("Created investigation table {} from archive shape", investigation);
        }
    }

    /** Merge batchIds from config with the batch(es) that archived the requested baskets. */
    private List<Long> resolveBatchIds(ArchiverProperties.Restore cfg) {
        Set<Long> ids = new LinkedHashSet<>(parseLongs(cfg.batchIds()));
        List<Long> baskets = parseLongs(cfg.baskets());
        if (!baskets.isEmpty()) {
            String inList = baskets.stream().map(String::valueOf).collect(Collectors.joining(","));
            List<Long> resolved =
                    controlJdbc.queryForList(
                            "SELECT DISTINCT archive_batch_id FROM basket_archive_state"
                                    + " WHERE archive_batch_id IS NOT NULL AND basket_key IN (" + inList + ")",
                            Long.class);
            if (resolved.isEmpty()) {
                log.warn("No archived batch found for baskets [{}] — were they archived?", inList);
            }
            ids.addAll(resolved);
        }
        return new ArrayList<>(ids);
    }

    private void guardNotLiveSource(ArchiverProperties.Restore cfg, String investigationDb) {
        String sourceDb = props.source() == null ? null : props.source().databaseName();
        if (!cfg.allowRestoreToSource()
                && sourceDb != null
                && sourceDb.equalsIgnoreCase(investigationDb)) {
            throw new IllegalStateException(
                    "refusing to restore into the live source DB '" + investigationDb
                            + "' (set archiver.restore.allow-restore-to-source=true to override)");
        }
    }

    private long openRestoreLog(List<Long> batchIds, String investigationDb) {
        Long firstBatch = batchIds.isEmpty() ? null : batchIds.get(0);
        return controlJdbc
                .queryForObject(
                        "INSERT INTO archive_restore_log (archive_batch_id, target_db, status)"
                                + " OUTPUT inserted.restore_id VALUES (?, ?, 'RUNNING')",
                        Long.class,
                        firstBatch,
                        investigationDb);
    }

    private void completeRestoreLog(long restoreId, String status, long rows) {
        controlJdbc.update(
                "UPDATE archive_restore_log SET status = ?, rows_restored = ?, ended_at_utc = SYSUTCDATETIME()"
                        + " WHERE restore_id = ?",
                status,
                rows,
                restoreId);
    }

    private List<Table> loadTables(String jobName) {
        return controlJdbc.query(
                "SELECT target_schema, target_table FROM archive_table WHERE job_name = ? AND enabled = 1"
                        + " AND restorable = 1 ORDER BY dependency_level ASC",
                (rs, i) -> new Table(rs.getString("target_schema"), rs.getString("target_table")),
                jobName);
    }

    private static List<Long> parseLongs(String csv) {
        if (csv == null || csv.isBlank()) {
            return List.of();
        }
        return Arrays.stream(csv.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Long::parseLong)
                .toList();
    }

    private static Set<String> columns(Connection conn, String db, String schema, String table) throws SQLException {
        Set<String> cols = new LinkedHashSet<>();
        String infoSchema = (db == null ? "" : q(db) + ".") + "INFORMATION_SCHEMA.COLUMNS";
        String sql =
                "SELECT COLUMN_NAME FROM " + infoSchema
                        + " WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ? ORDER BY ORDINAL_POSITION";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, schema);
            ps.setString(2, table);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cols.add(rs.getString(1));
                }
            }
        }
        return cols;
    }

    private static boolean containsIgnoreCase(Set<String> cols, String name) {
        return cols.stream().anyMatch(c -> c.equalsIgnoreCase(name));
    }

    private static String qName(String schema, String table) {
        return q(schema) + "." + q(table);
    }

    private static String qName(String db, String schema, String table) {
        return q(db) + "." + q(schema) + "." + q(table);
    }

    private static String q(String identifier) {
        return "[" + identifier.replace("]", "]]") + "]";
    }

    private record Table(String schema, String table) {}
}
