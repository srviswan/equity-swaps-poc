package com.pb.swap.archiver.copy;

import org.springframework.stereotype.Component;

/**
 * Different server and database: streams a source {@code ResultSet} straight into the target via
 * {@code com.microsoft.sqlserver.jdbc.SQLServerBulkCopy} (needs only {@code INSERT}, no
 * {@code bulkadmin}, no MSDTC, no Kerberos delegation — two direct connections).
 *
 * <p>No cross-instance transaction is possible, so the {@code ChunkProcessor} drives
 * copy → verify (count + optional checksum) → delete, each step checkpointed for idempotent
 * restart. For columnstore targets, batch ≥ 102,400 rows to land compressed rowgroups.
 */
@Component
public class CrossServerBulkCopyStrategy implements CopyStrategy {

    @Override
    public String topology() {
        return "CROSS_SERVER";
    }

    @Override
    public MoveResult move(MoveContext ctx) {
        // TODO(phase 5): copy → verify → delete state machine. Open source ResultSet
        // (source JOIN #archive_keys on keyColumn); SQLServerBulkCopy into target with batch size +
        // bulkCopyTimeout; verify counts/checksums; only then DELETE source. Each step checkpointed.
        throw new UnsupportedOperationException("scaffold: CROSS_SERVER move not yet implemented (phase 5)");
    }
}
