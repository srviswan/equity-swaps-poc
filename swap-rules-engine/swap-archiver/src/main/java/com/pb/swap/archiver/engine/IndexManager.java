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
 * Optionally disables non-clustered indexes on the archive <em>target</em> before a bulk load and
 * rebuilds them afterwards (faster load, less index-maintenance logging). The disabled set is
 * checkpointed in {@code archive_index_state}, so {@link #rebuildForJob} re-enables them on both the
 * success and failure paths and on a restart (any leftover rows = indexes still to rebuild).
 *
 * <p>Scope is target tables only — disabling source (live DW) indexes would break BAU, and a
 * clustered index cannot be disabled without making the table unreadable. Only plain non-clustered
 * indexes are touched (PK / unique-constraint indexes are left intact).
 */
@Component
public class IndexManager {

    private static final Logger log = LoggerFactory.getLogger(IndexManager.class);

    private final JdbcTemplate controlJdbc;
    private final ConnectionFactory connections;
    private final ArchiverProperties props;

    public IndexManager(JdbcTemplate controlJdbc, ConnectionFactory connections, ArchiverProperties props) {
        this.controlJdbc = controlJdbc;
        this.connections = connections;
        this.props = props;
    }

    /** Disable non-clustered indexes on every target flagged {@code disable_target_indexes}. */
    public void disableForJob(String jobName) {
        List<Map<String, Object>> targets =
                controlJdbc.queryForList(
                        "SELECT target_schema, target_table FROM archive_table"
                                + " WHERE job_name = ? AND enabled = 1 AND disable_target_indexes = 1",
                        jobName);
        if (targets.isEmpty()) {
            return;
        }
        try (Connection conn = connections.open(props.target())) {
            for (Map<String, Object> t : targets) {
                String schema = String.valueOf(t.get("target_schema"));
                String table = String.valueOf(t.get("target_table"));
                disableTable(conn, schema, table);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("failed disabling target indexes: " + e.getMessage(), e);
        }
    }

    private void disableTable(Connection conn, String schema, String table) throws SQLException {
        String qualified = schema + "." + table;
        List<String> indexes =
                indexNames(
                        conn,
                        "SELECT i.name FROM sys.indexes i WHERE i.object_id = OBJECT_ID('" + qualified + "')"
                                + " AND i.type = 2 AND i.is_disabled = 0 AND i.is_primary_key = 0"
                                + " AND i.is_unique_constraint = 0 AND i.name IS NOT NULL");
        for (String index : indexes) {
            try (Statement st = conn.createStatement()) {
                st.execute("ALTER INDEX " + q(index) + " ON " + q(schema) + "." + q(table) + " DISABLE");
            }
            controlJdbc.update(
                    "IF NOT EXISTS (SELECT 1 FROM archive_index_state WHERE target_table = ? AND index_name = ?)"
                            + " INSERT INTO archive_index_state (target_table, index_name) VALUES (?, ?)",
                    qualified,
                    index,
                    qualified,
                    index);
            log.info("Disabled index {} on {}", index, qualified);
        }
    }

    /** Rebuild (re-enable) every index recorded in {@code archive_index_state} and clear the record. */
    public void rebuildForJob(String jobName) {
        List<Map<String, Object>> rows =
                controlJdbc.queryForList("SELECT target_table, index_name FROM archive_index_state");
        if (rows.isEmpty()) {
            return;
        }
        try (Connection conn = connections.open(props.target())) {
            for (Map<String, Object> r : rows) {
                String qualified = String.valueOf(r.get("target_table"));
                String index = String.valueOf(r.get("index_name"));
                String schema = qualified.substring(0, qualified.indexOf('.'));
                String table = qualified.substring(qualified.indexOf('.') + 1);
                try (Statement st = conn.createStatement()) {
                    st.execute("ALTER INDEX " + q(index) + " ON " + q(schema) + "." + q(table) + " REBUILD");
                }
                controlJdbc.update(
                        "DELETE FROM archive_index_state WHERE target_table = ? AND index_name = ?", qualified, index);
                log.info("Rebuilt index {} on {}", index, qualified);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("failed rebuilding target indexes: " + e.getMessage(), e);
        }
    }

    private static List<String> indexNames(Connection conn, String sql) throws SQLException {
        try (Statement st = conn.createStatement();
                var rs = st.executeQuery(sql)) {
            List<String> names = new java.util.ArrayList<>();
            while (rs.next()) {
                names.add(rs.getString(1));
            }
            return names;
        }
    }

    private static String q(String identifier) {
        return "[" + identifier.replace("]", "]]") + "]";
    }
}
