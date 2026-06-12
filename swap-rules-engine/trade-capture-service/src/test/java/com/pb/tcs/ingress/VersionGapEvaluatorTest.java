package com.pb.tcs.ingress;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.TreeSet;
import org.junit.jupiter.api.Test;

/**
 * F1.3 semantics (spec): version-gap decisions for versions of ONE allocation. Cross-allocation
 * order is Solace partition FIFO and is out of scope here (D2).
 *
 * <pre>
 * v <= lastProcessed      → DUPLICATE (ACK + audit)
 * v == lastProcessed + 1  → PROCESS, then drain consecutive holds
 * v >  lastProcessed + 1  → HOLD (persist, ACK, deadline)
 * </pre>
 */
class VersionGapEvaluatorTest {

    @Test
    void firstVersionProcessesImmediately() {
        assertThat(VersionGapEvaluator.onArrival(0, 1))
                .isEqualTo(new VersionGapEvaluator.Process());
    }

    @Test
    void nextConsecutiveVersionProcesses() {
        assertThat(VersionGapEvaluator.onArrival(3, 4))
                .isEqualTo(new VersionGapEvaluator.Process());
    }

    @Test
    void sameVersionIsDuplicate() {
        assertThat(VersionGapEvaluator.onArrival(3, 3))
                .isEqualTo(new VersionGapEvaluator.Duplicate(3));
    }

    @Test
    void staleEarlierVersionIsDuplicate() {
        assertThat(VersionGapEvaluator.onArrival(3, 2))
                .isEqualTo(new VersionGapEvaluator.Duplicate(3));
    }

    @Test
    void versionGapHoldsAndReportsExpectedVersion() {
        assertThat(VersionGapEvaluator.onArrival(3, 5))
                .isEqualTo(new VersionGapEvaluator.Hold(4));
        assertThat(VersionGapEvaluator.onArrival(0, 2))
                .isEqualTo(new VersionGapEvaluator.Hold(1));
    }

    @Test
    void drainReleasesOnlyConsecutiveHeldVersionsInOrder() {
        var held = new TreeSet<>(java.util.List.of(5, 6, 8));
        assertThat(VersionGapEvaluator.drainable(4, held)).containsExactly(5, 6);
    }

    @Test
    void drainReleasesNothingWhenGapPersists() {
        var held = new TreeSet<>(java.util.List.of(6, 8));
        assertThat(VersionGapEvaluator.drainable(4, held)).isEmpty();
    }

    @Test
    void drainOfEmptyHoldsIsEmpty() {
        assertThat(VersionGapEvaluator.drainable(4, new TreeSet<>())).isEmpty();
    }
}
