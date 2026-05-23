package com.pb.swap.rules.runtime.observability;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public final class EnrichmentMetrics {
    private final MeterRegistry registry;
    private final Timer enrichTimer;

    public EnrichmentMetrics(MeterRegistry registry) {
        this.registry = registry;
        this.enrichTimer = Timer.builder("rules.engine.enrich").register(registry);
    }

    public static EnrichmentMetrics noop() {
        return new EnrichmentMetrics(new SimpleMeterRegistry());
    }

    public Timer.Sample start() {
        return Timer.start(registry);
    }

    public Timer.Sample startPhase(String phase) {
        return Timer.start(registry);
    }

    public void stopPhase(Timer.Sample sample, String phase) {
        sample.stop(Timer.builder("rules.engine.phase").tag("phase", phase).register(registry));
    }

    public void recordSuccess(Timer.Sample sample) {
        sample.stop(enrichTimer);
    }

    public void recordFailure(Timer.Sample sample) {
        sample.stop(enrichTimer);
    }
}
