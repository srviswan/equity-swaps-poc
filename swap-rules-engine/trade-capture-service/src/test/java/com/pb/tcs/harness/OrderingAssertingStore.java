package com.pb.tcs.harness;

import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.ingress.IngestionStore;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.util.List;
import java.util.OptionalInt;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Delegating store that checks NFR-5 inline against the real SQL adapter: every persist must
 * carry a version strictly greater than the last one this process persisted for the key.
 */
final class OrderingAssertingStore implements IngestionStore {

    private final IngestionStore delegate;
    private final ConcurrentHashMap<String, Integer> lastVersion = new ConcurrentHashMap<>();
    private final List<String> orderingViolations = new CopyOnWriteArrayList<>();
    private final AtomicInteger persists = new AtomicInteger();

    OrderingAssertingStore(IngestionStore delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean isEnriched(String blockId, String allocationId, int version) {
        return delegate.isEnriched(blockId, allocationId, version);
    }

    @Override
    public OptionalInt lastEnrichedVersion(String blockId, String allocationId) {
        return delegate.lastEnrichedVersion(blockId, allocationId);
    }

    @Override
    public void persistEnriched(EnrichedAllocation allocation) {
        delegate.persistEnriched(allocation);
        AllocationMessage m = allocation.message();
        String key = m.getBlockId() + "|" + m.getAllocationId();
        lastVersion.merge(
                key,
                m.getVersion(),
                (last, version) -> {
                    if (version <= last) {
                        orderingViolations.add(
                                "%s: version %d after %d".formatted(key, version, last));
                    }
                    return Math.max(last, version);
                });
        persists.incrementAndGet();
    }

    @Override
    public void auditReject(
            String stage, String reason, int attempt, byte[] rawProto, TcsIngressMessage parsed) {
        delegate.auditReject(stage, reason, attempt, rawProto, parsed);
    }

    @Override
    public void quarantine(String category, String detail, byte[] rawProto) {
        delegate.quarantine(category, detail, rawProto);
    }

    List<String> orderingViolations() {
        return orderingViolations;
    }

    int totalPersists() {
        return persists.get();
    }
}
