package com.pb.tcs.harness;

import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.ingress.IngestionStore;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thread-safe ingestion store for the load harness. Detects the NFR-5 hard-correctness failure
 * inline: a persist whose version is not strictly greater than the last persisted version for
 * its key is recorded as an ordering violation.
 */
final class ConcurrentRecordingStore implements IngestionStore {

    private final ConcurrentHashMap<String, Integer> lastVersion = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Integer> persistedCount = new ConcurrentHashMap<>();
    private final List<String> orderingViolations = new CopyOnWriteArrayList<>();
    private final List<String> quarantines = new CopyOnWriteArrayList<>();
    private final AtomicInteger persists = new AtomicInteger();

    @Override
    public boolean isEnriched(String blockId, String allocationId, int version) {
        return persistedCount.containsKey(key(blockId, allocationId) + "|" + version);
    }

    @Override
    public OptionalInt lastEnrichedVersion(String blockId, String allocationId) {
        Integer last = lastVersion.get(key(blockId, allocationId));
        return last == null ? OptionalInt.empty() : OptionalInt.of(last);
    }

    @Override
    public void persistEnriched(EnrichedAllocation allocation) {
        AllocationMessage m = allocation.message();
        String key = key(m.getBlockId(), m.getAllocationId());
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
        persistedCount.merge(key + "|" + m.getVersion(), 1, Integer::sum);
        persists.incrementAndGet();
    }

    @Override
    public void auditReject(
            String stage, String reason, int attempt, byte[] rawProto, TcsIngressMessage parsed) {}

    @Override
    public void quarantine(String category, String detail, byte[] rawProto) {
        quarantines.add(category + ": " + detail);
    }

    private static String key(String blockId, String allocationId) {
        return blockId + "|" + allocationId;
    }

    List<String> orderingViolations() {
        return orderingViolations;
    }

    List<String> quarantines() {
        return quarantines;
    }

    int totalPersists() {
        return persists.get();
    }

    /** Keys persisted at least once. */
    int distinctKeys() {
        return lastVersion.size();
    }

    List<String> duplicatePersists() {
        return persistedCount.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }
}
