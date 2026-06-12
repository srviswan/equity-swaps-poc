package com.pb.tcs.archive;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/** FR-602 archive run persistence (swap-archiver pattern). */
public interface ArchiveRunStore {

    long startRun(LocalDate partitionMonth, String preflightJson);

    void completeRun(long runId, long rowsArchived);

    void failRun(long runId, String reason);

    void registerSwitchedPartition(LocalDate partitionMonth, long runId, Instant switchedAt);

    boolean isPartitionArchived(LocalDate partitionMonth);

    Optional<ArchiveRun> findLatestRun(LocalDate partitionMonth);

    record ArchiveRun(
            long runId,
            LocalDate partitionMonth,
            String status,
            Long rowsArchived,
            Instant startedAt,
            Instant completedAt,
            String preflightJson) {}
}
