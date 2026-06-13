package com.pb.tcs.config;

import java.util.List;

/** Typed view of {@code tcs-config/ingress.yml}. */
public record IngressConfig(
        Solace solace, RefdataRetry refdataRetry, GapDetection gapDetection) {

    public record Solace(String queue, int partitions, int prefetch) {}

    /** D6/D22: 3 attempts, backoff 1s / 5s / 15s. */
    public record RefdataRetry(int maxAttempts, List<Long> backoffMs) {}

    /** E1: flips on when GCAM delivers {@code key_sequence}. */
    public record GapDetection(boolean useKeySequence) {}
}
