package com.pb.tcs.ingress;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

/** Test fake for the {@code version_gap_hold}-backed store (restart-safe in production). */
public final class InMemoryHoldStore implements VersionGapHoldStore {

    private final Map<String, Map<Integer, HoldRow>> holds = new LinkedHashMap<>();

    @Override
    public void hold(HoldRow row) {
        Map<Integer, HoldRow> perAlloc =
                holds.computeIfAbsent(
                        key(row.blockId(), row.allocationId()), k -> new LinkedHashMap<>());
        if (perAlloc.putIfAbsent(row.heldVersion(), row) != null) {
            throw new IngestionStoreException("uq_hold violation: " + row.heldVersion());
        }
    }

    @Override
    public SortedSet<Integer> heldVersions(String blockId, String allocationId) {
        return new TreeSet<>(
                holds.getOrDefault(key(blockId, allocationId), Map.of()).keySet());
    }

    @Override
    public Optional<HoldRow> claim(String blockId, String allocationId, int version) {
        Map<Integer, HoldRow> perAlloc = holds.get(key(blockId, allocationId));
        return perAlloc == null
                ? Optional.empty()
                : Optional.ofNullable(perAlloc.remove(version));
    }

    @Override
    public List<HoldRow> expiredHolds(Instant now) {
        List<HoldRow> expired = new ArrayList<>();
        holds.values()
                .forEach(
                        perAlloc ->
                                perAlloc.values().stream()
                                        .filter(h -> h.deadlineAt().isBefore(now))
                                        .forEach(expired::add));
        return expired;
    }

    @Override
    public void remove(String blockId, String allocationId, int version) {
        Map<Integer, HoldRow> perAlloc = holds.get(key(blockId, allocationId));
        if (perAlloc != null) {
            perAlloc.remove(version);
        }
    }

    Instant deadlineOf(String blockId, String allocationId, int version) {
        return holds.get(key(blockId, allocationId)).get(version).deadlineAt();
    }

    private static String key(String blockId, String allocationId) {
        return blockId + "|" + allocationId;
    }
}
