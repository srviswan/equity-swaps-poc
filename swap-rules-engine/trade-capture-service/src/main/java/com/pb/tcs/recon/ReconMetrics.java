package com.pb.tcs.recon;

import com.pb.tcs.config.ReconPolicyConfig;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.concurrent.atomic.AtomicLong;

/** FR-708 recon metrics (arch §11). */
public final class ReconMetrics {

    private final MeterRegistry registry;
    private final AtomicLong openBreaks = new AtomicLong();

    public ReconMetrics(MeterRegistry registry) {
        this.registry = registry;
        registry.gauge("trade.recon.breaks.open", openBreaks);
    }

    public void runCompleted(ReconType type, int breaksDetected) {
        registry.counter("trade.recon.runs", "type", type.name()).increment();
        registry.counter("trade.recon.breaks.detected", "type", type.name()).increment(breaksDetected);
        openBreaks.addAndGet(breaksDetected);
    }

    public void breakResolved(BreakStatus status) {
        openBreaks.decrementAndGet();
        registry.counter("trade.recon.breaks.resolved", "status", status.name()).increment();
    }

    public void autoHealAttempt(BreakType type, String outcome) {
        registry.counter("trade.recon.auto_heal", "type", type.name(), "outcome", outcome).increment();
    }

    public void agingEscalation(int hours) {
        registry.counter("trade.recon.aging_escalation", "hours", String.valueOf(hours)).increment();
    }
}
