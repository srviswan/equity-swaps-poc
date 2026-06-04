package com.pb.swap.archiver.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AdaptiveControllerTest {

    private static final int MIN = 5_000;
    private static final int MAX = 200_000;
    private static final long TARGET = 30_000;

    private final AdaptiveController controller = new AdaptiveController();

    @Test
    void growsWhenFastAndHealthy() {
        int next = controller.nextBatchSize(10_000, 1_000, TARGET, false, MIN, MAX);
        assertTrue(next > 10_000, "additive increase when under target with no pressure");
        assertTrue(next <= MAX);
    }

    @Test
    void halvesUnderPressure() {
        assertEquals(10_000, controller.nextBatchSize(20_000, 1_000, TARGET, true, MIN, MAX));
    }

    @Test
    void halvesWhenChunkRunsLong() {
        assertEquals(20_000, controller.nextBatchSize(40_000, 60_000, TARGET, false, MIN, MAX));
    }

    @Test
    void respectsMaxCeiling() {
        assertEquals(MAX, controller.nextBatchSize(199_999, 1, TARGET, false, MIN, MAX));
    }

    @Test
    void respectsMinFloorEvenUnderPressure() {
        assertEquals(MIN, controller.nextBatchSize(6_000, 1, TARGET, true, MIN, MAX));
    }
}
