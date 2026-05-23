package com.pb.swap.rules.core.compile;

import com.pb.swap.rules.core.model.Action;
import com.pb.swap.rules.core.model.Criterion;
import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.EvaluationMode;
import com.pb.swap.rules.core.model.RuleCategory;
import com.pb.swap.rules.core.model.RuleDefinition;
import java.util.List;
import java.util.function.Predicate;

/** Runtime-optimized rule after compilation. */
public final class CompiledRule {
    private final String ruleId;
    private final int ruleVersion;
    private final String name;
    private final RuleCategory category;
    private final EnrichmentTarget target;
    private final EvaluationMode evaluationMode;
    private final int priority;
    private final double specificity;
    private final List<Action> actions;
    private final List<Criterion> flattenedCriteria;
    private final List<String> fragmentIds;
    private final List<String> templateIds;
    private final Predicate<EvaluationContextView> matchPredicate;
    private final RuleDefinition source;

    public CompiledRule(
            String ruleId,
            int ruleVersion,
            String name,
            RuleCategory category,
            EnrichmentTarget target,
            EvaluationMode evaluationMode,
            int priority,
            double specificity,
            List<Action> actions,
            List<Criterion> flattenedCriteria,
            List<String> fragmentIds,
            List<String> templateIds,
            Predicate<EvaluationContextView> matchPredicate,
            RuleDefinition source) {
        this.ruleId = ruleId;
        this.ruleVersion = ruleVersion;
        this.name = name;
        this.category = category;
        this.target = target;
        this.evaluationMode = evaluationMode;
        this.priority = priority;
        this.specificity = specificity;
        this.actions = List.copyOf(actions);
        this.flattenedCriteria = List.copyOf(flattenedCriteria);
        this.fragmentIds = List.copyOf(fragmentIds);
        this.templateIds = List.copyOf(templateIds);
        this.matchPredicate = matchPredicate;
        this.source = source;
    }

    public boolean matches(EvaluationContextView ctx) {
        return matchPredicate.test(ctx);
    }

    public String ruleId() {
        return ruleId;
    }

    public int ruleVersion() {
        return ruleVersion;
    }

    public String name() {
        return name;
    }

    public RuleCategory category() {
        return category;
    }

    public EnrichmentTarget target() {
        return target;
    }

    public EvaluationMode evaluationMode() {
        return evaluationMode;
    }

    public int priority() {
        return priority;
    }

    public double specificity() {
        return specificity;
    }

    public List<Action> actions() {
        return actions;
    }

    public List<Criterion> flattenedCriteria() {
        return flattenedCriteria;
    }

    public List<String> fragmentIds() {
        return fragmentIds;
    }

    public List<String> templateIds() {
        return templateIds;
    }

    public RuleDefinition source() {
        return source;
    }
}
