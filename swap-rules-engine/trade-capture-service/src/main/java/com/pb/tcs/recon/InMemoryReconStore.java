package com.pb.tcs.recon;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/** In-memory {@link ReconStore} for F12 exit-criteria tests. */
public final class InMemoryReconStore implements ReconStore {

    private final Map<Long, ReconRun> runs = new LinkedHashMap<>();
    private final Map<String, ReconRun> runsByIdempotency = new LinkedHashMap<>();
    private final Map<Long, ReconBreak> breaks = new LinkedHashMap<>();
    private final AtomicLong runIds = new AtomicLong();
    private final AtomicLong breakIds = new AtomicLong();

    @Override
    public ReconRun saveRun(ReconRun run) {
        long id = run.runId() > 0 ? run.runId() : runIds.incrementAndGet();
        ReconRun saved =
                new ReconRun(
                        id,
                        run.reconType(),
                        run.scope(),
                        run.asOf(),
                        run.status(),
                        run.tcsWatermark(),
                        run.downstreamWatermark(),
                        run.breaksDetected(),
                        run.startedAt(),
                        run.completedAt(),
                        run.idempotencyKey());
        runs.put(id, saved);
        runsByIdempotency.put(saved.idempotencyKey(), saved);
        return saved;
    }

    @Override
    public Optional<ReconRun> findRunByIdempotencyKey(String idempotencyKey) {
        return Optional.ofNullable(runsByIdempotency.get(idempotencyKey));
    }

    @Override
    public Optional<ReconRun> findRunById(long runId) {
        return Optional.ofNullable(runs.get(runId));
    }

    @Override
    public ReconBreak saveBreak(ReconBreak breakRow) {
        long id = breakRow.breakId() > 0 ? breakRow.breakId() : breakIds.incrementAndGet();
        ReconBreak saved =
                new ReconBreak(
                        id,
                        breakRow.runId(),
                        breakRow.breakClass(),
                        breakRow.breakType(),
                        breakRow.allocationId(),
                        breakRow.swapRef(),
                        breakRow.lotRef(),
                        breakRow.tcsValueJson(),
                        breakRow.peerValueJson(),
                        breakRow.status(),
                        breakRow.autoHealEligible(),
                        breakRow.resolutionNote(),
                        breakRow.resolvedBy(),
                        breakRow.detectedAt(),
                        breakRow.resolvedAt());
        breaks.put(id, saved);
        return saved;
    }

    @Override
    public List<ReconBreak> findBreaksByRunId(long runId) {
        return breaks.values().stream().filter(b -> b.runId() == runId).toList();
    }

    @Override
    public Optional<ReconBreak> findBreakById(long breakId) {
        return Optional.ofNullable(breaks.get(breakId));
    }

    @Override
    public List<ReconBreak> findOpenBreaks(ReconType type, String allocationId, String swapRef) {
        return findOpenBreaks().stream()
                .filter(b -> b.breakClass() == type)
                .filter(b -> allocationId == null || allocationId.equals(b.allocationId()))
                .filter(b -> swapRef == null || swapRef.equals(b.swapRef()))
                .toList();
    }

    @Override
    public List<ReconBreak> findOpenBreaks() {
        List<ReconBreak> open = new ArrayList<>();
        for (ReconBreak row : breaks.values()) {
            if (row.status() == BreakStatus.DETECTED
                    || row.status() == BreakStatus.HEALING
                    || row.status() == BreakStatus.ACKNOWLEDGED) {
                open.add(row);
            }
        }
        return open;
    }

    @Override
    public void updateBreak(ReconBreak breakRow) {
        if (!breaks.containsKey(breakRow.breakId())) {
            throw new IllegalArgumentException("unknown break " + breakRow.breakId());
        }
        breaks.put(breakRow.breakId(), breakRow);
    }
}
