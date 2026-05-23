package com.pb.swap.rules.runtime.engine;

import com.pb.swap.rules.core.api.EnrichmentEngine;
import com.pb.swap.rules.core.api.EnrichmentResult;
import com.pb.swap.rules.core.compile.RuleCompiler;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.core.pipeline.PhaseDescriptor;
import com.pb.swap.rules.core.snapshot.RuleSnapshot;
import com.pb.swap.rules.core.strategy.EvaluationStrategy;
import com.pb.swap.rules.core.strategy.StrategyRegistry;
import com.pb.swap.rules.core.trace.BoundedTraceBuffer;
import com.pb.swap.rules.core.trace.TraceSink;
import com.pb.swap.rules.runtime.builder.EquitySwapBuilder;
import com.pb.swap.rules.runtime.context.ContextPool;
import com.pb.swap.rules.runtime.context.EvaluationContext;
import com.pb.swap.rules.runtime.observability.EnrichmentMetrics;
import io.micrometer.core.instrument.Timer;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class EnrichmentEngineImpl implements EnrichmentEngine {
    private final AtomicReference<RuleSnapshot> snapshotRef;
    private final List<PhaseDescriptor> pipeline;
    private final ContextPool contextPool;
    private final StrategyRegistry strategyRegistry;
    private final TraceSink traceSink;
    private final EnrichmentMetrics metrics;

    public EnrichmentEngineImpl(
            AtomicReference<RuleSnapshot> snapshotRef,
            List<PhaseDescriptor> pipeline,
            TraceSink traceSink,
            EnrichmentMetrics metrics) {
        this.snapshotRef = snapshotRef;
        this.pipeline = List.copyOf(pipeline);
        this.contextPool = new ContextPool();
        this.strategyRegistry = new StrategyRegistry();
        this.traceSink = traceSink != null ? traceSink : TraceSink.NOOP;
        this.metrics = metrics != null ? metrics : EnrichmentMetrics.noop();
    }

    @Override
    public EnrichmentResult enrich(RawHedgeTrade rawTrade) {
        Timer.Sample sample = metrics.start();
        RuleSnapshot snapshot = snapshotRef.get();
        EvaluationContext ctx = contextPool.acquire();
        EquitySwapBuilder builder = EquitySwapBuilder.startFrom(rawTrade);
        BoundedTraceBuffer trace =
                new BoundedTraceBuffer(rawTrade.tradeId(), snapshot.version());
        try {
            ctx.bind(rawTrade, snapshot, builder);
            for (PhaseDescriptor phase : pipeline) {
                Timer.Sample phaseSample = metrics.startPhase(phase.category().name());
                try {
                    var matched =
                            snapshot.bucketFor(phase.category(), phase.target(), ctx);
                    if (matched.isEmpty()) {
                        trace.recordUnresolved(phase.target(), phase.target().name(), "NO_MATCH");
                    } else {
                        EvaluationStrategy strategy = strategyRegistry.get(phase.mode());
                        strategy.apply(matched, ctx, builder, trace);
                    }
                } finally {
                    metrics.stopPhase(phaseSample, phase.category().name());
                }
            }
            var result = new EnrichmentResult(builder.build(), trace.toTrace());
            traceSink.publishAsync(result.trace());
            metrics.recordSuccess(sample);
            return result;
        } catch (RuntimeException ex) {
            metrics.recordFailure(sample);
            throw ex;
        } finally {
            contextPool.release(ctx);
        }
    }

    public void updateSnapshot(RuleSnapshot snapshot) {
        snapshotRef.set(snapshot);
    }
}
