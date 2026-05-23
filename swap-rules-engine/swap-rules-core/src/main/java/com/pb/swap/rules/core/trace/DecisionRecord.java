package com.pb.swap.rules.core.trace;

import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.EvaluationMode;
import com.pb.swap.rules.core.model.RuleCategory;
import java.util.List;

public record DecisionRecord(
        int seq,
        String ruleId,
        int ruleVersion,
        RuleCategory category,
        EnrichmentTarget target,
        EvaluationMode strategy,
        double specificity,
        List<String> matchedCriteria,
        List<String> actions,
        List<String> paths,
        String before,
        String after,
        String reason) {}
