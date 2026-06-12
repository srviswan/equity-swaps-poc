package com.pb.tcs.ingress;

import static org.assertj.core.api.Assertions.assertThat;

import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** The F1.5 metric set, names and tags pinned (NFR-9: Micrometer → ESaaS/Observe). */
class IngressMetricsTest {

    private SimpleMeterRegistry registry;
    private IngressMetrics metrics;

    @BeforeEach
    void setUp() {
        registry = new SimpleMeterRegistry();
        metrics = new IngressMetrics(registry);
    }

    @Test
    void ingressRateTaggedByTypeSourceBook() {
        metrics.ingress("SWAP", "GCAM", "EQ_US_HY");
        metrics.ingress("SWAP", "GCAM", "EQ_US_HY");
        metrics.ingress("BLOCK", "MANUAL", "EQ_EU");

        assertThat(
                        registry.counter(
                                        "tc.ingress.rate",
                                        "type", "SWAP", "source", "GCAM", "book", "EQ_US_HY")
                                .count())
                .isEqualTo(2);
        assertThat(
                        registry.counter(
                                        "tc.ingress.rate",
                                        "type", "BLOCK", "source", "MANUAL", "book", "EQ_EU")
                                .count())
                .isEqualTo(1);
    }

    @Test
    void gcamAckLatencyTimerRecords() {
        metrics.ackLatency(Duration.ofMillis(42));

        var timer = registry.timer("tc.gcam.ack.latency");
        assertThat(timer.count()).isEqualTo(1);
        assertThat(timer.totalTime(java.util.concurrent.TimeUnit.MILLISECONDS)).isEqualTo(42);
    }

    @Test
    void validationFailuresTaggedByStage() {
        metrics.validationFail("STRUCTURAL");
        metrics.validationFail("MANDATORY");
        metrics.validationFail("MANDATORY");

        assertThat(registry.counter("tc.validation.fail", "stage", "MANDATORY").count())
                .isEqualTo(2);
    }

    @Test
    void refdataMissTaggedByEntityAndAttempt() {
        metrics.refdataMiss("security", 3);

        assertThat(
                        registry.counter("tc.refdata.miss", "entity", "security", "attempt", "3")
                                .count())
                .isEqualTo(1);
    }

    @Test
    void versionGapHeldIsALiveGauge() {
        AtomicInteger held = new AtomicInteger(0);
        metrics.registerHeldGauge("EQ_US_HY", held::get);
        held.set(7);

        assertThat(registry.get("tc.version_gap.held").tag("book", "EQ_US_HY").gauge().value())
                .isEqualTo(7);
    }

    @Test
    void versionGapQuarantinedCountsPerBook() {
        metrics.versionGapQuarantined("EQ_US_HY");

        assertThat(
                        registry.counter("tc.version_gap.quarantined", "book", "EQ_US_HY")
                                .count())
                .isEqualTo(1);
    }

    @Test
    void idempotencyDuplicatesTaggedBySource() {
        metrics.duplicate("GCAM");

        assertThat(registry.counter("tc.idempotency.duplicate", "source", "GCAM").count())
                .isEqualTo(1);
    }

    @Test
    void quarantineInflowCountsPerCategory() {
        metrics.quarantined("REFDATA_EXHAUSTED");

        assertThat(
                        registry.counter("tc.quarantine.inflow", "category", "REFDATA_EXHAUSTED")
                                .count())
                .isEqualTo(1);
    }
}
