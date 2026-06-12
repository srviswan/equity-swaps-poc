package com.pb.tcs.archive;

import com.pb.tcs.config.CutoverPolicyConfig;
import com.pb.tcs.cutover.CutoverPolicy;
import com.pb.tcs.lookup.ArchivedTradeIndex;
import com.pb.tcs.lookup.HotTradeIndex;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;

/**
 * FR-602 partition-switch archival orchestrator (preflight → switch registry). Data movement reuses
 * swap-archiver copy strategies in production; tests use an in-memory trade index handoff.
 */
public final class ArchivePartitionService {

    private final ArchiveRunStore runStore;
    private final ArchivedTradeIndex archivedIndex;
    private final HotTradeIndex hotIndex;
    private final CutoverPolicyConfig.ArchivePolicy policy;
    private final Clock clock;

    public ArchivePartitionService(
            ArchiveRunStore runStore,
            ArchivedTradeIndex archivedIndex,
            HotTradeIndex hotIndex,
            CutoverPolicy cutoverPolicy,
            Clock clock) {
        this.runStore = runStore;
        this.archivedIndex = archivedIndex;
        this.hotIndex = hotIndex;
        this.policy = cutoverPolicy.config().archive();
        this.clock = clock;
    }

    public ArchiveResult archivePartition(LocalDate partitionMonth) {
        long eligible = hotIndex.countEligibleForArchive(partitionMonth, policy.eligibilityDaysPastLifecycle());
        PreflightReport preflight = ArchivePreflight.validate(partitionMonth, eligible, policy.hotWindowMonths());
        if (!preflight.ok()) {
            return ArchiveResult.failed(preflight.render());
        }
        long runId = runStore.startRun(partitionMonth, preflight.render());
        try {
            long moved = hotIndex.movePartitionToArchive(partitionMonth, archivedIndex);
            Instant switchedAt = clock.instant();
            runStore.registerSwitchedPartition(partitionMonth, runId, switchedAt);
            runStore.completeRun(runId, moved);
            return ArchiveResult.success(runId, partitionMonth, moved, preflight.render());
        } catch (RuntimeException e) {
            runStore.failRun(runId, e.getMessage());
            throw e;
        }
    }

    public record ArchiveResult(
            boolean success, long runId, LocalDate partitionMonth, long rowsArchived, String detail) {

        static ArchiveResult success(long runId, LocalDate month, long rows, String detail) {
            return new ArchiveResult(true, runId, month, rows, detail);
        }

        static ArchiveResult failed(String detail) {
            return new ArchiveResult(false, 0, null, 0, detail);
        }
    }
}
