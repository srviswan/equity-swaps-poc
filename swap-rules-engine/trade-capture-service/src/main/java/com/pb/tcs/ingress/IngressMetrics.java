package com.pb.tcs.ingress;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import java.time.Duration;
import java.util.function.Supplier;

/** The F1.5 metric set (NFR-9). Names/tags are contract — dashboards key off them. */
public final class IngressMetrics {

    private final MeterRegistry registry;

    public IngressMetrics(MeterRegistry registry) {
        this.registry = registry;
    }

    public void ingress(String type, String source, String book) {
        registry.counter("tc.ingress.rate", "type", type, "source", source, "book", book)
                .increment();
    }

    /** received → ACK for the enriched/duplicate path (NFR-4: P99 < 500 ms under spike). */
    public void ackLatency(Duration elapsed) {
        registry.timer("tc.gcam.ack.latency").record(elapsed);
    }

    public void validationFail(String stage) {
        registry.counter("tc.validation.fail", "stage", stage).increment();
    }

    public void refdataMiss(String entity, int attempt) {
        registry.counter("tc.refdata.miss", "entity", entity, "attempt", String.valueOf(attempt))
                .increment();
    }

    public void registerHeldGauge(String book, Supplier<Number> heldCount) {
        Gauge.builder("tc.version_gap.held", heldCount)
                .tag("book", book)
                .register(registry);
    }

    public void registerPartitionLagGauge(int partition, Supplier<Number> lag) {
        Gauge.builder("tc.partition.lag", lag)
                .tag("partition", String.valueOf(partition))
                .register(registry);
    }

    public void versionGapQuarantined(String book) {
        registry.counter("tc.version_gap.quarantined", "book", book).increment();
    }

    public void duplicate(String source) {
        registry.counter("tc.idempotency.duplicate", "source", source).increment();
    }

    public void quarantined(String category) {
        registry.counter("tc.quarantine.inflow", "category", category).increment();
    }

    /** Unexpected pipeline exception — contained by the consumer, message NACKed. */
    public void error() {
        registry.counter("tc.ingress.error").increment();
    }
}
