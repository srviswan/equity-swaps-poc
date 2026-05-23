package com.pb.swap.rules.admin.config;

import com.pb.swap.rules.admin.service.InMemoryTraceStore;
import com.pb.swap.rules.admin.service.SnapshotHolder;
import com.pb.swap.rules.core.compile.RuleCompiler;
import com.pb.swap.rules.core.pipeline.DefaultPipelineFactory;
import com.pb.swap.rules.core.snapshot.RuleSnapshot;
import com.pb.swap.rules.core.trace.TraceSink;
import com.pb.swap.rules.runtime.engine.EnrichmentEngineImpl;
import com.pb.swap.rules.runtime.observability.EnrichmentMetrics;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RulesEngineConfig {

    @Bean
    RuleCompiler ruleCompiler() {
        return new RuleCompiler();
    }

    @Bean
    SnapshotHolder snapshotHolder() {
        return new SnapshotHolder(RuleSnapshot.empty());
    }

    @Bean
    AtomicReference<com.pb.swap.rules.core.snapshot.RuleSnapshot> snapshotRef(SnapshotHolder holder) {
        return holder.reference();
    }

    @Bean
    InMemoryTraceStore inMemoryTraceStore() {
        return new InMemoryTraceStore();
    }

    @Bean
    TraceSink compositeTraceSink(InMemoryTraceStore store) {
        return store::store;
    }

    @Bean
    EnrichmentEngineImpl enrichmentEngine(
            AtomicReference<RuleSnapshot> snapshotRef,
            TraceSink traceSink,
            MeterRegistry meterRegistry) {
        return new EnrichmentEngineImpl(
                snapshotRef,
                DefaultPipelineFactory.equitySwapPipeline(),
                traceSink,
                new EnrichmentMetrics(meterRegistry));
    }
}
