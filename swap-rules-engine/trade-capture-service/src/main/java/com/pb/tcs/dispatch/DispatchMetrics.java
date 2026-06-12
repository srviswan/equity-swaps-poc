package com.pb.tcs.dispatch;

import io.micrometer.core.instrument.MeterRegistry;

/** FR-400/401 dispatch metrics (arch §11). */
public final class DispatchMetrics {

    private final MeterRegistry registry;

    public DispatchMetrics(MeterRegistry registry) {
        this.registry = registry;
    }

    public void success(String destination) {
        registry.counter("trade.dispatch.success", "destination", destination).increment();
    }

    public void failure(String destination) {
        registry.counter("trade.dispatch.failure", "destination", destination).increment();
    }

    public void dlq(String destination) {
        registry.counter("trade.dispatch.dlq", "destination", destination).increment();
    }
}
