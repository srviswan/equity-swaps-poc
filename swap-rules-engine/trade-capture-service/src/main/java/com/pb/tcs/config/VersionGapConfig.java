package com.pb.tcs.config;

import java.util.Map;

/** Typed view of {@code tcs-config/version-gap.yml} (D2/D18). */
public record VersionGapConfig(Defaults defaults, Map<String, BookOverride> books) {

    public enum TimeoutAction {
        QUARANTINE
    }

    public record Defaults(
            long versionGapTimeoutMs, int maxHeldPerAllocation, TimeoutAction onTimeout) {}

    public record BookOverride(Long versionGapTimeoutMs) {}

    /** Book-specific timeout, falling back to the default (D18). */
    public long timeoutMsFor(String book) {
        BookOverride override = books.get(book);
        if (override != null && override.versionGapTimeoutMs() != null) {
            return override.versionGapTimeoutMs();
        }
        return defaults.versionGapTimeoutMs();
    }
}
