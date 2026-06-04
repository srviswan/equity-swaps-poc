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
     *
     * <p>{@code priorState} is this table+chunk's last {@code archive_chunk_log} state (or {@code
     * null} if never started). The cross-server state machine uses it to resume: {@code COPIED}
     * means the target is already verified and only the source delete remains.
     */
    record MoveContext(
            ConnectionFactory connections,
            ArchiverProperties props,
            StopController stop,
            TableConfig table,
            long runId,
            int chunkNo,
            int archivedPeriodKey,
            List<Long> basketKeys,
            String priorState) {}

    /**
     * Per-table archival configuration resolved from {@code archive_table}.
     *
     * <p>{@code joinColumns} are the source columns this table matches against the per-chunk key set.
     * For {@code DIRECT} the fact carries the basket key (one column, any name). For {@code BRIDGE}
     * the fact is keyed by something else (e.g. {@code swap_key}); eligible baskets are resolved to
     * this fact's keys through {@code bridgeTable(bridgeBasketColumn → bridgeJoinColumns)} and then
     * the fact joins on its own {@code joinColumns} (arity must match {@code bridgeJoinColumns}).
     */
    record TableConfig(
            String sourceSchema,
            String sourceTable,
            String targetSchema,
            String targetTable,
            List<String> joinColumns,
            String keyResolution,
            String bridgeTable,
            String bridgeBasketColumn,
            List<String> bridgeJoinColumns,
            String topology,
            int dependencyLevel,
            boolean checksumVerify) {

        public String sourceName() {
            return sourceSchema + "." + sourceTable;
        }

        public String targetName() {
            return targetSchema + "." + targetTable;
        }

        public boolean isBridge() {
            return "BRIDGE".equalsIgnoreCase(keyResolution);
        }
    }

    /**
     * Outcome of a move. {@code sourceChecksum}/{@code targetChecksum} are the {@code CHECKSUM_AGG}
     * over the copied data columns when {@code checksumVerify} is on (else {@code null}); they are
     * recorded for audit and were compared <em>before</em> the delete was allowed.
     */
    record MoveResult(long rowsCopied, long rowsDeleted, Long sourceChecksum, Long targetChecksum) {}
}
