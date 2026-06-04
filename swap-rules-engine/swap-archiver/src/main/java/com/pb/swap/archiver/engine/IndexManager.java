package com.pb.swap.archiver.engine;

import org.springframework.stereotype.Component;

/**
 * Optionally disables non-clustered indexes on the archive <em>target</em> before a bulk load and
 * rebuilds them afterwards. The disabled/enabled state is checkpointed so rebuild happens on both
 * success and failure paths and survives a restart.
 *
 * <p>Default scope is target tables only — disabling source (live DW) indexes would break BAU, and
 * a clustered index cannot be disabled without making the table unreadable. Source index changes
 * are gated behind a separate explicit flag.
 */
@Component
public class IndexManager {

    public void disableTargetNonClustered(String targetTable) {
        // TODO(phase 4): ALTER INDEX ... ON target DISABLE for non-clustered indexes; record state.
        throw new UnsupportedOperationException("scaffold: index disable not yet implemented");
    }

    public void rebuildTargetIndexes(String targetTable) {
        // TODO(phase 4): ALTER INDEX ALL ON target REBUILD; clear recorded disabled state.
        throw new UnsupportedOperationException("scaffold: index rebuild not yet implemented");
    }
}
