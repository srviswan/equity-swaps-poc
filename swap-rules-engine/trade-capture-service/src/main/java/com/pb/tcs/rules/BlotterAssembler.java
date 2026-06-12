package com.pb.tcs.rules;

import com.pb.swap.rules.core.api.EnrichmentResult;
import com.pb.swap.rules.core.compile.RuleCompiler;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.core.pipeline.DefaultPipelineFactory;
import com.pb.swap.rules.core.snapshot.RuleSnapshot;
import com.pb.swap.rules.core.trace.DecisionTrace;
import com.pb.swap.rules.core.trace.TraceSink;
import com.pb.swap.rules.runtime.engine.EnrichmentEngineImpl;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Stage 4 (F3): runs the embedded rules engine over an {@link EnrichedAllocation} and assembles
 * the {@link SwapBlotter} plus its FR-207 explain trail.
 *
 * <p>Snapshots are compiled full-range (FR-205/D7): every published rule version goes into one
 * snapshot and the engine selects effective versions by trade date at evaluation time, so
 * back-dated trades are enriched under the rules in force on their trade date. {@link #reload}
 * swaps the snapshot atomically between trades — never mid-trade.
 */
public final class BlotterAssembler {

    private final AtomicReference<RuleSnapshot> snapshotRef = new AtomicReference<>();
    private final EnrichmentEngineImpl engine;
    private final RuleCompiler compiler = new RuleCompiler();
    private final RuleExplainNarrator narrator = new RuleExplainNarrator();

    public BlotterAssembler(RuleSet ruleSet) {
        snapshotRef.set(compile(ruleSet));
        this.engine =
                new EnrichmentEngineImpl(
                        snapshotRef,
                        DefaultPipelineFactory.equitySwapPipeline(),
                        TraceSink.NOOP,
                        null);
    }

    /** Result of one assembly: blotter + raw trace + persistable explains. */
    public record Assembly(SwapBlotter blotter, DecisionTrace trace, List<RuleExplain> explains) {}

    public Assembly assemble(EnrichedAllocation allocation) {
        RawHedgeTrade raw = AllocationTradeMapper.toRawHedgeTrade(allocation);
        EnrichmentResult result = engine.enrich(raw);
        AllocationMessage m = allocation.message();
        SwapBlotter blotter =
                new SwapBlotter(
                        allocation.correlationId(),
                        m.getBlockId(),
                        m.getAllocationId(),
                        m.getVersion(),
                        m.getType().name(),
                        allocation.envelope().getBook(),
                        allocation.envelope().getAccountId(),
                        allocation.envelope().getSecurityId(),
                        raw.tradeDate(),
                        snapshotRef.get().version(),
                        result.swap());
        return new Assembly(blotter, result.trace(), narrator.narrate(result.trace()));
    }

    /** Atomic snapshot swap on rule publication; in-flight trades keep their snapshot. */
    public void reload(RuleSet ruleSet) {
        snapshotRef.set(compile(ruleSet));
    }

    public String snapshotVersion() {
        return snapshotRef.get().version();
    }

    private RuleSnapshot compile(RuleSet ruleSet) {
        return compiler.compileFullRange(
                ruleSet.rules(), ruleSet.templates(), ruleSet.fragments());
    }
}
