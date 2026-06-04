package com.pb.swap.archiver.copy;

import org.springframework.stereotype.Component;

/**
 * Same server, different database: 3-part name {@code db.schema.table}. Still a single local
 * transaction because both databases are on the same instance. Recommended steady-state target
 * (archive DB in SIMPLE recovery, outside the AG) to avoid shipping the copy across the AG.
 */
@Component
public class CrossDbCopyStrategy implements CopyStrategy {

    @Override
    public String topology() {
        return "CROSS_DB";
    }

    @Override
    public MoveResult move(MoveContext ctx) {
        // TODO(phase 5): INSERT INTO archiveDb.schema.target SELECT ... FROM sourceDb.schema.source
        // (3-part names, single local transaction), then DELETE — same shape as SAME_DB.
        throw new UnsupportedOperationException("scaffold: CROSS_DB move not yet implemented (phase 5)");
    }
}
