package com.pb.swap.rules.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RuleDefinition(
        String id,
        int version,
        String name,
        RuleCategory category,
        EnrichmentTarget target,
        Integer priority,
        boolean enabled,
        LocalDate effectiveFrom,
        LocalDate effectiveTo,
        EvaluationMode evaluationMode,
        Double specificityBoost,
        RuleStatus status,
        List<Criterion> criteria,
        List<String> includes,
        List<String> apply,
        List<Action> actions,
        Map<String, Object> overrides,
        Map<String, Object> metadata) {

    public EvaluationMode resolvedEvaluationMode() {
        return evaluationMode != null ? evaluationMode : category.defaultEvaluationMode();
    }

    public int resolvedPriority() {
        return priority != null ? priority : 100;
    }
}
