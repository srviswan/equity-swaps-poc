package com.pb.tcs.approval;

import io.micrometer.core.instrument.MeterRegistry;

/** Micrometer hooks for the approval gate (arch §11). */
public final class ApprovalMetrics {

    private final MeterRegistry registry;

    public ApprovalMetrics(MeterRegistry registry) {
        this.registry = registry;
    }

    void gateOutcome(String outcome) {
        registry.counter("tc.approval.gate", "outcome", outcome).increment();
    }

    void pending() {
        registry.counter("tc.approval.pending").increment();
    }

    void timeout() {
        registry.counter("tc.approval.timeout").increment();
    }

    void denied() {
        registry.counter("tc.approval.gate", "outcome", "DENIED").increment();
    }

    void resumed() {
        registry.counter("tc.approval.gate", "outcome", "RESUMED").increment();
    }
}
