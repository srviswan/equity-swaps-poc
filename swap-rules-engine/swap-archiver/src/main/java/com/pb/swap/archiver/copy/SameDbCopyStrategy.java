package com.pb.swap.archiver.copy;

import org.springframework.stereotype.Component;

/**
 * Same database: archive table lives in the source DB. Copy + delete run as one local
 * transaction ({@code INSERT…SELECT} then {@code DELETE}), so a crash rolls back atomically and
 * restart simply re-runs the chunk.
 *
 * <p>Note: in the source's FULL recovery + AG, this logs and ships <em>both</em> the copy and the
 * delete (~2× volume). Prefer moving to a non-AG archive DB (CROSS_DB/CROSS_SERVER) for steady
 * state.
 */
@Component
public class SameDbCopyStrategy implements CopyStrategy {

    @Override
    public String topology() {
        return "SAME_DB";
    }

    @Override
    public CopyResult copy(CopyRequest request) {
        // TODO(phase 2): INSERT INTO target (cols, lineage) SELECT cols, lineage FROM source
        // WHERE basketKey IN (chunk keys); optionally CHECKSUM_AGG for verify. Caller wraps the
        // matching DELETE in the same transaction.
        throw new UnsupportedOperationException("scaffold: SAME_DB copy not yet implemented");
    }
}
