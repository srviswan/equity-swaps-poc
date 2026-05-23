package com.pb.swap.rules.core.strategy;

import com.pb.swap.rules.core.action.SwapWriter;
import com.pb.swap.rules.core.compile.CompiledRule;
import com.pb.swap.rules.core.compile.EvaluationContextView;
import com.pb.swap.rules.core.trace.BoundedTraceBuffer;
import java.util.List;

public sealed interface EvaluationStrategy
        permits LayeredEnrichmentStrategy, FirstMatchExclusiveStrategy, AllMatchCollectStrategy {
    void apply(
            List<CompiledRule> matchedRules,
            EvaluationContextView ctx,
            SwapWriter writer,
            BoundedTraceBuffer trace);
}
