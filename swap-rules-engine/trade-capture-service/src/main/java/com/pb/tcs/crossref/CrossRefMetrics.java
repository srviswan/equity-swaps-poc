package com.pb.tcs.crossref;

import io.micrometer.core.instrument.MeterRegistry;
import java.time.Duration;

/** Micrometer hooks for cross-ref delivery (arch §11). */
public final class CrossRefMetrics {

    private final MeterRegistry registry;

    public CrossRefMetrics(MeterRegistry registry) {
        this.registry = registry;
    }

    void delivered(String toSystem, String fromSystem) {
        registry.counter("tc.crossref.delivered", "to", toSystem, "from", fromSystem).increment();
    }

    void failed(String toSystem, String fromSystem) {
        registry.counter("tc.crossref.failed", "to", toSystem, "from", fromSystem).increment();
    }

    void retryScheduled(String toSystem) {
        registry.counter("tc.crossref.retry", "to", toSystem).increment();
    }

    void recordLotDeliveryLatency(String toSystem, Duration latency) {
        registry.timer("tc.crossref.lot_delivery.latency", "to", toSystem).record(latency);
    }

    void partialCrossRefPending() {
        registry.counter("tc.partial.success", "kind", "cross_ref").increment();
    }
}
