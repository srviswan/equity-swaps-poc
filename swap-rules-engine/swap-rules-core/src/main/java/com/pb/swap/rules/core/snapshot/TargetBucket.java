package com.pb.swap.rules.core.snapshot;

import com.pb.swap.rules.core.compile.CompiledRule;
import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.EvaluationMode;
import com.pb.swap.rules.core.model.RuleCategory;
import java.util.List;

public record TargetBucket(
        RuleCategory category,
        EnrichmentTarget target,
        EvaluationMode evaluationMode,
        List<CompiledRule> rules) {

    public TargetBucket {
        rules = List.copyOf(rules);
    }
}
