package com.pb.tcs.crossref;

/** Exponential backoff for cross-ref delivery retries (mirrors dispatch). */
final class CrossRefBackoff {

    private CrossRefBackoff() {}

    static long secondsForAttempt(int attempt) {
        return Math.min(300, (long) Math.pow(2, Math.max(0, attempt - 1)) * 5);
    }
}
