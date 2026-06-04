package com.pb.swap.archiver.engine;

import com.pb.swap.archiver.auth.ConnectionFactory;
import com.pb.swap.archiver.config.ArchiverProperties;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Watches transaction-log pressure and Availability-Group lag on the source, and decides when the
 * engine must pause so the log can clear / secondaries can catch up.
 *
 * <ul>
 *   <li>Log: {@code sys.dm_db_log_space_usage} + {@code log_reuse_wait_desc}. In FULL recovery the
 *       log only truncates on a log backup, so we wait for the backup job (or issue {@code BACKUP
 *       LOG} when permitted).
 *   <li>AG: {@code sys.dm_hadr_database_replica_states.log_send_queue_size / redo_queue_size} — pause
 *       when a secondary falls behind the configured threshold (protects RPO and readable-secondary
 *       BAU).
 * </ul>
 *
 * <p>Readings fail soft: if a DMV is unreadable (e.g. missing {@code VIEW SERVER STATE}, or no AG),
 * the corresponding metric is reported as "unknown" ({@code logUsedPct = -1}, queues {@code 0}) and
 * pacing degrades to the fixed poll interval rather than erroring — pre-flight already warns when
 * VIEW SERVER STATE is absent.
 */
@Component
public class LogAndAgMonitor {

    private static final Logger log = LoggerFactory.getLogger(LogAndAgMonitor.class);

    private final ConnectionFactory connections;
    private final ArchiverProperties props;

    public LogAndAgMonitor(ConnectionFactory connections, ArchiverProperties props) {
        this.connections = connections;
        this.props = props;
    }

    /** A point-in-time reading used both for pacing decisions and chunk-log auditing. */
    public record Reading(int logUsedPct, String logReuseWait, long agRedoQueueKb, long agSendQueueKb) {}

    public Reading sample() {
        try (Connection conn = connections.open(props.source())) {
            int logUsedPct = scalarInt(conn, "SELECT CAST(used_log_space_in_percent AS INT) FROM sys.dm_db_log_space_usage", -1);
            String reuseWait =
                    scalarString(
                            conn,
                            "SELECT log_reuse_wait_desc FROM sys.databases WHERE database_id = DB_ID()");
            long redoKb = scalarLong(conn, agQueueSql("redo_queue_size"), 0L);
            long sendKb = scalarLong(conn, agQueueSql("log_send_queue_size"), 0L);
            return new Reading(logUsedPct, reuseWait, redoKb, sendKb);
        } catch (SQLException e) {
            log.warn("log/AG sample failed; degrading to fixed pacing this cycle: {}", e.getMessage());
            return new Reading(-1, null, 0L, 0L);
        }
    }

    /**
     * @return true when log/AG pressure requires pausing before the next chunk. The same KB
     *     threshold gates <em>both</em> AG queues: the <b>redo</b> queue (secondary behind applying →
     *     stale readable secondary) and the <b>send</b> queue (primary log not yet shipped → direct
     *     RPO exposure). Either breaching the threshold pauses the engine.
     */
    public boolean shouldPause(Reading reading, int logUsedPctPause, long agQueuePauseKb) {
        return (reading.logUsedPct() >= 0 && reading.logUsedPct() >= logUsedPctPause)
                || "LOG_BACKUP".equalsIgnoreCase(reading.logReuseWait())
                || reading.agRedoQueueKb() >= agQueuePauseKb
                || reading.agSendQueueKb() >= agQueuePauseKb;
    }

    private static String agQueueSql(String column) {
        // Max over secondary replicas for this DB; returns 0 rows (→ default) when not in an AG.
        return "SELECT ISNULL(MAX(" + column + "), 0) FROM sys.dm_hadr_database_replica_states"
                + " WHERE database_id = DB_ID() AND is_local = 0";
    }

    private static int scalarInt(Connection conn, String sql, int fallback) {
        Long v = tryScalar(conn, sql);
        return v == null ? fallback : v.intValue();
    }

    private static long scalarLong(Connection conn, String sql, long fallback) {
        Long v = tryScalar(conn, sql);
        return v == null ? fallback : v;
    }

    private static Long tryScalar(Connection conn, String sql) {
        try (Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                long v = rs.getLong(1);
                return rs.wasNull() ? null : v;
            }
            return null;
        } catch (SQLException e) {
            log.debug("DMV read failed ({}): {}", sql, e.getMessage());
            return null;
        }
    }

    private static String scalarString(Connection conn, String sql) {
        try (Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            return rs.next() ? rs.getString(1) : null;
        } catch (SQLException e) {
            log.debug("DMV read failed ({}): {}", sql, e.getMessage());
            return null;
        }
    }
}
