package com.pb.tcs.recon;

import com.pb.tcs.config.ReconPolicyConfig;
import com.pb.tcs.parity.ParityFieldComparator;
import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/** FR-707 orchestration: idempotent runs, break persistence, auto-resolve on re-run. */
public final class ReconService {

    private final ReconStore store;
    private final ReconSnapshotLoader loader;
    private final ReconPolicyConfig policy;
    private final ReconFieldClassifier classifier;
    private final ReconMetrics metrics;
    private final Clock clock;
    private final AtomicLong runIds = new AtomicLong();

    private final R3CrossSystemRunner r3;
    private final R2InstructionBookingRunner r2;
    private final R1IngestionCompletenessRunner r1;

    public ReconService(
            ReconStore store,
            ReconSnapshotLoader loader,
            ReconPolicyConfig policy,
            ParityFieldComparator parityComparator,
            ReconMetrics metrics,
            Clock clock) {
        this.store = store;
        this.loader = loader;
        this.policy = policy;
        this.classifier = new ReconFieldClassifier(parityComparator);
        this.metrics = metrics;
        this.clock = clock;
        this.r3 = new R3CrossSystemRunner(policy, classifier);
        this.r2 = new R2InstructionBookingRunner(policy, classifier);
        this.r1 = new R1IngestionCompletenessRunner();
    }

    public ReconRun startRun(ReconType type, ReconScope scope, Instant asOf) {
        String idempotencyKey = scope.idempotencyKey(type, asOf);
        Optional<ReconRun> existing = store.findRunByIdempotencyKey(idempotencyKey);
        if (existing.isPresent() && "COMPLETE".equals(existing.get().status())) {
            return existing.get();
        }

        long runId = runIds.incrementAndGet();
        ReconRun running = ReconRun.started(runId, type, scope, asOf, idempotencyKey);
        store.saveRun(running);

        Instant detectedAt = clock.instant();
        List<ReconBreak> detected =
                switch (type) {
                    case R3 -> r3.detect(runId, loader, scope, asOf, detectedAt);
                    case R2 -> r2.detect(runId, loader, scope, asOf, detectedAt);
                    case R1 -> r1.detect(runId, loader, scope, asOf, detectedAt);
                };

        confirmAutoResolved(type, detected);
        List<ReconBreak> persisted = new ArrayList<>();
        for (ReconBreak row : detected) {
            persisted.add(store.saveBreak(row));
        }

        Instant tcsWatermark = watermark(loader.loadTcs(scope, asOf));
        Instant downstreamWatermark =
                maxWatermark(
                        watermark(loader.loadSystemA(scope, asOf)),
                        watermark(loader.loadSystemB(scope, asOf)));
        ReconRun complete = running.complete(persisted.size(), tcsWatermark, downstreamWatermark);
        store.saveRun(complete);
        metrics.runCompleted(type, persisted.size());
        return complete;
    }

    public Optional<ReconRun> getRun(long runId) {
        return store.findRunById(runId);
    }

    public List<ReconBreak> getBreaks(long runId) {
        return store.findBreaksByRunId(runId);
    }

    private void confirmAutoResolved(ReconType type, List<ReconBreak> detected) {
        for (ReconBreak open : store.findOpenBreaks()) {
            if (open.breakClass() != type) {
                continue;
            }
            boolean stillPresent =
                    detected.stream()
                            .anyMatch(
                                    d ->
                                            d.breakType() == open.breakType()
                                                    && sameKeys(d, open));
            if (!stillPresent && open.status() == BreakStatus.HEALING) {
                ReconBreak resolved =
                        open.withStatus(
                                BreakStatus.RESOLVED_AUTO,
                                "confirmed on re-run",
                                "recon-engine",
                                clock.instant());
                store.updateBreak(resolved);
                metrics.breakResolved(BreakStatus.RESOLVED_AUTO);
            }
        }
    }

    private static boolean sameKeys(ReconBreak left, ReconBreak right) {
        if (left.allocationId() != null && left.allocationId().equals(right.allocationId())) {
            return true;
        }
        return left.swapRef() != null && left.swapRef().equals(right.swapRef());
    }

    private static Instant watermark(List<ReconRecord> records) {
        return records.stream()
                .map(ReconRecord::observedAt)
                .filter(t -> t != null)
                .max(Instant::compareTo)
                .orElse(null);
    }

    private static Instant maxWatermark(Instant a, Instant b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        return a.isAfter(b) ? a : b;
    }
}
