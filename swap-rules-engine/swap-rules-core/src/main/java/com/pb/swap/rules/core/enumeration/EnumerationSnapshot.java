package com.pb.swap.rules.core.enumeration;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Immutable, versioned bundle of all enumerations known to the runtime at a point in time. The
 * registry swaps the active snapshot atomically.
 */
public final class EnumerationSnapshot {

    private final String snapshotId;
    private final Instant publishedAt;
    private final Map<String, EnumerationDescriptor> byCode;

    public EnumerationSnapshot(
            String snapshotId,
            Instant publishedAt,
            Map<String, EnumerationDescriptor> byCode) {
        this.snapshotId = snapshotId;
        this.publishedAt = publishedAt;
        this.byCode = Map.copyOf(byCode);
    }

    public static EnumerationSnapshot empty() {
        return new EnumerationSnapshot("EMPTY", Instant.EPOCH, new LinkedHashMap<>());
    }

    public String snapshotId() {
        return snapshotId;
    }

    public Instant publishedAt() {
        return publishedAt;
    }

    public Optional<EnumerationDescriptor> get(String code) {
        return Optional.ofNullable(byCode.get(code));
    }

    public List<EnumerationDescriptor> all() {
        return List.copyOf(byCode.values());
    }

    public int size() {
        return byCode.size();
    }
}
