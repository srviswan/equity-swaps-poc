package com.pb.swap.archiver.copy;

import java.util.List;

/**
 * Moves a chunk's rows for one table from source to archive. Selected per table by topology.
 *
 * <ul>
 *   <li><b>SAME_DB / CROSS_DB</b> — set-based {@code INSERT…SELECT}; copy+delete run in one local
 *       transaction (same instance), so a crash rolls back cleanly.
 *   <li><b>CROSS_SERVER</b> — streams via {@code SQLServerBulkCopy}; copy and delete cannot share a
 *       transaction, so the engine drives a copy→verify→delete state machine instead.
 * </ul>
 */
public interface CopyStrategy {

    /** Topology this strategy handles: {@code SAME_DB}, {@code CROSS_DB}, or {@code CROSS_SERVER}. */
    String topology();

    /** Copy the chunk's rows for one table into the archive target. */
    CopyResult copy(CopyRequest request);

    /** Everything needed to copy one table's slice of one chunk. */
    record CopyRequest(
            long runId,
            int chunkNo,
            String sourceTable,
            String targetTable,
            String basketKeyColumn,
            List<Long> basketKeys,
            boolean checksumVerify) {}

    /** Outcome of a copy, used to drive verification before deletion. */
    record CopyResult(long rowsCopied, Long sourceChecksum, Long targetChecksum) {}
}
