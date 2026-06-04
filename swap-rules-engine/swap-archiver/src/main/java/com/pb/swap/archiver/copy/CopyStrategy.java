package com.pb.swap.archiver.copy;

import com.pb.swap.archiver.auth.ConnectionFactory;
import com.pb.swap.archiver.config.ArchiverProperties;
import com.pb.swap.archiver.engine.StopController;
import java.sql.SQLException;
import java.util.List;

/**
 * Moves a chunk's rows for one table from source to archive. Selected per table by topology.
 *
 * <ul>
 *   <li><b>SAME_DB / CROSS_DB</b> — set-based {@code INSERT…SELECT} then {@code DELETE} in one local
 *       transaction (same instance), so a crash rolls back cleanly and restart re-runs the chunk.
 *   <li><b>CROSS_SERVER</b> — streams via {@code SQLServerBulkCopy}; copy and delete cannot share a
 *       transaction, so the engine drives a copy→verify→delete state machine instead.
 * </ul>
 */
public interface CopyStrategy {

    /** Topology this strategy handles: {@code SAME_DB}, {@code CROSS_DB}, or {@code CROSS_SERVER}. */
    String topology();

    /** Move one table's slice of one chunk (copy then delete) according to this topology. */
    MoveResult move(MoveContext ctx) throws SQLException;

    /**
     * Everything a strategy needs to move one table's slice of one chunk. The eligible basket keys
     * for the chunk are passed in {@code basketKeys}; the strategy stages them into an indexed temp
     * table so the (possibly 1 TB) source joins on {@code table.keyColumn} via a seek, never a scan.
     */
    record MoveContext(
            ConnectionFactory connections,
            ArchiverProperties props,
            StopController stop,
            TableConfig table,
            long runId,
            int chunkNo,
            int archivedPeriodKey,
            List<Long> basketKeys) {}

    /** Per-table archival configuration resolved from {@code archive_table}. */
    record TableConfig(
            String sourceSchema,
            String sourceTable,
            String targetSchema,
            String targetTable,
            String keyColumn,
            String keyResolution,
            String topology,
            int dependencyLevel,
            boolean checksumVerify) {

        public String sourceName() {
            return sourceSchema + "." + sourceTable;
        }

        public String targetName() {
            return targetSchema + "." + targetTable;
        }
    }

    /** Outcome of a move; rows copied to the archive and rows deleted from source for the chunk. */
    record MoveResult(long rowsCopied, long rowsDeleted) {}
}
