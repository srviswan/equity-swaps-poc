package com.pb.tcs.dispatch;

import java.time.Duration;

/** Exponential backoff for per-target dispatch retries (FR-401). */
public final class DispatchBackoff {

    private static final Duration BASE = Duration.ofSeconds(2);
    private static final Duration MAX = Duration.ofMinutes(5);

    private DispatchBackoff() {}

    /** attemptCount is 1-based after the failed attempt. */
    public static Duration nextDelay(int attemptCount) {
        long seconds = (long) Math.min(MAX.getSeconds(), BASE.getSeconds() * Math.pow(2, attemptCount - 1));
        return Duration.ofSeconds(Math.max(1, seconds));
    }
}
