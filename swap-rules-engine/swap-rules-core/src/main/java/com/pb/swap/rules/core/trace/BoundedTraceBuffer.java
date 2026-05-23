package com.pb.swap.rules.core.trace;

import com.pb.swap.rules.core.model.EnrichmentTarget;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public final class BoundedTraceBuffer {
    public static final int DEFAULT_MAX = 64;

    private final String traceId;
    private final String tradeId;
    private final String snapshotVersion;
    private final int maxEntries;
    private final List<DecisionRecord> decisions = new ArrayList<>();
    private final List<UnresolvedTarget> unresolved = new ArrayList<>();
    private final AtomicInteger seq = new AtomicInteger();
    private boolean overflow;

    public BoundedTraceBuffer(String tradeId, String snapshotVersion) {
        this(UUID.randomUUID().toString(), tradeId, snapshotVersion, DEFAULT_MAX);
    }

    public BoundedTraceBuffer(String traceId, String tradeId, String snapshotVersion, int maxEntries) {
        this.traceId = traceId;
        this.tradeId = tradeId;
        this.snapshotVersion = snapshotVersion;
        this.maxEntries = maxEntries;
    }

    public void record(DecisionRecord record) {
        if (decisions.size() >= maxEntries) {
            overflow = true;
            return;
        }
        decisions.add(record);
    }

    public void recordUnresolved(EnrichmentTarget target, String path, String status) {
        unresolved.add(new UnresolvedTarget(target, path, status));
    }

    public int nextSeq() {
        return seq.incrementAndGet();
    }

    public DecisionTrace toTrace() {
        return new DecisionTrace(
                traceId, tradeId, snapshotVersion, List.copyOf(decisions), List.copyOf(unresolved), overflow);
    }

    public String traceId() {
        return traceId;
    }
}
