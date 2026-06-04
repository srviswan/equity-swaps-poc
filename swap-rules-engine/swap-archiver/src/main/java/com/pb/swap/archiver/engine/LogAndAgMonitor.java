package com.pb.swap.archiver.engine;

import org.springframework.stereotype.Component;

/**
 * Watches transaction-log pressure and Availability-Group lag, and decides when the engine must
 * pause so the log can clear / secondaries can catch up.
 *
 * <ul>
 *   <li>Log: {@code sys.dm_db_log_space_usage} + {@code log_reuse_wait_desc}. In FULL recovery the
 *       log only truncates on a log backup, so we wait for the backup job (or issue {@code BACKUP
 *       LOG} when permitted).
 *   <li>AG: {@code sys.dm_hadr_database_replica_states.log_send_queue_size / redo_queue_size} — pause
 *       when a secondary falls behind the configured threshold (protects RPO and readable-secondary
 *       BAU).
 * </ul>
 */
@Component
public class LogAndAgMonitor {

    /** A point-in-time reading used both for pacing decisions and chunk-log auditing. */
    public record Reading(int logUsedPct, String logReuseWait, long agRedoQueueKb, long agSendQueueKb) {}

    public Reading sample() {
        // TODO(phase 3): query the DMVs above on the source endpoint.
        throw new UnsupportedOperationException("scaffold: DMV sampling not yet implemented");
    }

    /** @return true when log/AG pressure requires pausing before the next chunk. */
    public boolean shouldPause(Reading reading, int logUsedPctPause, long agRedoQueuePause) {
        return reading.logUsedPct() >= logUsedPctPause
                || "LOG_BACKUP".equalsIgnoreCase(reading.logReuseWait())
                || reading.agRedoQueueKb() >= agRedoQueuePause;
    }
}
