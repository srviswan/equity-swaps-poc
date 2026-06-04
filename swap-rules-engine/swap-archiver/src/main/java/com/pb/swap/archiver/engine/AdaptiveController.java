package com.pb.swap.archiver.engine;

import org.springframework.stereotype.Component;

/**
 * AIMD-style batch-size controller. Grows the batch additively while chunks finish under the
 * target duration with healthy log/AG pressure, and shrinks it multiplicatively when a chunk runs
 * long or pressure is high — keeping the batch within {@code [min, max]} (and any weekend cap).
 */
@Component
public class AdaptiveController {

    public int nextBatchSize(
            int current, long lastChunkMillis, long targetMillis, boolean pressure, int min, int max) {
        int next;
        if (pressure || lastChunkMillis > targetMillis) {
            next = Math.max(min, current / 2); // multiplicative decrease
        } else {
            next = Math.min(max, current + Math.max(1, min / 2)); // additive increase
        }
        return next;
    }
}
