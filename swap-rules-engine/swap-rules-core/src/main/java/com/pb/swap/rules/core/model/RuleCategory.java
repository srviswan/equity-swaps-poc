package com.pb.swap.rules.core.model;

/** Drives default evaluation strategy selection. */
public enum RuleCategory {
    ECONOMIC,
    NON_ECONOMIC,
    BUSINESS,
    WORKFLOW,
    ROUTING,
    VALIDATION;

    public EvaluationMode defaultEvaluationMode() {
        return switch (this) {
            case ECONOMIC -> EvaluationMode.LAYERED;
            case VALIDATION -> EvaluationMode.ALL_MATCH;
            default -> EvaluationMode.FIRST_MATCH;
        };
    }
}
