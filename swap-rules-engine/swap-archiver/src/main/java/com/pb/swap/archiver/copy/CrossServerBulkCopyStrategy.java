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
    public CopyResult copy(CopyRequest request) {
        // TODO(phase 5): open source ResultSet (source JOIN keyStagingTable on joinColumns);
        // SQLServerBulkCopy into target with batch size + bulkCopyTimeout; return rows + checksums.
        throw new UnsupportedOperationException("scaffold: CROSS_SERVER bulk copy not yet implemented");
    }
}
