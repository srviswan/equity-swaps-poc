package com.pb.tcs.harness;

import com.pb.tcs.ingress.VersionGapHoldStore;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/** Thread-safe in-memory hold store for the load harness (keys are partition-confined). */
final class ConcurrentHoldStore implements VersionGapHoldStore {

    private final ConcurrentHashMap<String, HoldRow> rows = new ConcurrentHashMap<>();

    @Override
    public void hold(HoldRow row) {
        rows.put(key(row.blockId(), row.allocationId(), row.heldVersion()), row);
    }

    @Override
    public SortedSet<Integer> heldVersions(String blockId, String allocationId) {
        String prefix = blockId + "|" + allocationId + "|";
        SortedSet<Integer> versions = new TreeSet<>();
        rows.forEach(
                (key, row) -> {
                    if (key.startsWith(prefix)) {
                        versions.add(row.heldVersion());
                    }
                });
        return versions;
    }

    @Override
    public Optional<HoldRow> claim(String blockId, String allocationId, int version) {
        return Optional.ofNullable(rows.remove(key(blockId, allocationId, version)));
    }

    @Override
    public List<HoldRow> expiredHolds(Instant now) {
        List<HoldRow> expired = new ArrayList<>();
        rows.values().forEach(
                row -> {
                    if (!row.deadlineAt().isAfter(now)) {
                        expired.add(row);
                    }
                });
        return expired;
    }

    @Override
    public void remove(String blockId, String allocationId, int version) {
        rows.remove(key(blockId, allocationId, version));
    }

    int size() {
        return rows.size();
    }

    private static String key(String blockId, String allocationId, int version) {
        return blockId + "|" + allocationId + "|" + version;
    }
}
