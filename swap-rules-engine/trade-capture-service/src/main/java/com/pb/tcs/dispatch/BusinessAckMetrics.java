package com.pb.tcs.dispatch;

import io.micrometer.core.instrument.MeterRegistry;
import java.time.Duration;

/** FR-402 business-ACK observability (arch §11). */
public final class BusinessAckMetrics {

    private final MeterRegistry registry;

    public BusinessAckMetrics(MeterRegistry registry) {
        this.registry = registry;
    }

    /** Time from dispatch {@code sent_at} to business ACK (FR-402 histogram). */
    public void recordLatency(String destination, Duration latency) {
        registry.timer("tc.business_ack.latency", "destination", destination).record(latency);
    }

    public void pending(String destination) {
        registry.counter("tc.business_ack.pending", "destination", destination).increment();
    }

    public void received(String destination, String status) {
        registry.counter("tc.business_ack.received", "destination", destination, "status", status)
                .increment();
    }
}
