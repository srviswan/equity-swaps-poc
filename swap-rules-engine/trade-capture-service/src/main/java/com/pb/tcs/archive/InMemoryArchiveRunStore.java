package com.pb.tcs.archive;

import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public final class InMemoryArchiveRunStore implements ArchiveRunStore {

    private final Map<Long, ArchiveRun> runs = new LinkedHashMap<>();
    private final Map<LocalDate, Long> switched = new LinkedHashMap<>();
    private final AtomicLong ids = new AtomicLong();

    @Override
    public long startRun(LocalDate partitionMonth, String preflightJson) {
        long id = ids.incrementAndGet();
        runs.put(
                id,
                new ArchiveRun(
                        id,
                        partitionMonth,
                        "RUNNING",
                        null,
                        Instant.now(),
                        null,
                        preflightJson));
        return id;
    }

    @Override
    public void completeRun(long runId, long rowsArchived) {
        ArchiveRun prior = runs.get(runId);
        runs.put(
                runId,
                new ArchiveRun(
                        runId,
                        prior.partitionMonth(),
                        "COMPLETE",
                        rowsArchived,
                        prior.startedAt(),
                        Instant.now(),
                        prior.preflightJson()));
    }

    @Override
    public void failRun(long runId, String reason) {
        ArchiveRun prior = runs.get(runId);
        runs.put(
                runId,
                new ArchiveRun(
                        runId,
                        prior.partitionMonth(),
                        "FAILED",
                        null,
                        prior.startedAt(),
                        Instant.now(),
                        reason));
    }

    @Override
    public void registerSwitchedPartition(LocalDate partitionMonth, long runId, Instant switchedAt) {
        switched.put(partitionMonth, runId);
    }

    @Override
    public boolean isPartitionArchived(LocalDate partitionMonth) {
        return switched.containsKey(partitionMonth);
    }

    @Override
    public Optional<ArchiveRun> findLatestRun(LocalDate partitionMonth) {
        return runs.values().stream()
                .filter(r -> r.partitionMonth().equals(partitionMonth))
                .reduce((a, b) -> b.runId() >= a.runId() ? b : a);
    }
}
