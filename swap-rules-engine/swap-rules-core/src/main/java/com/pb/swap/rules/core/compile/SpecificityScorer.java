package com.pb.swap.rules.core.compile;

import com.pb.swap.rules.core.model.ComparisonOperator;
import com.pb.swap.rules.core.model.Criterion;
import com.pb.swap.rules.core.model.RuleDefinition;
import java.util.List;

public final class SpecificityScorer {
    private static final double W_CRITERIA = 10.0;
    private static final double W_OPERATOR = 5.0;
    private static final double W_CARDINALITY = 3.0;

    public double score(RuleDefinition rule, List<Criterion> flattenedCriteria) {
        double score = 0;
        if (rule.specificityBoost() != null) {
            score += rule.specificityBoost();
        }
        score += W_CRITERIA * flattenedCriteria.size();
        for (Criterion c : flattenedCriteria) {
            score += W_OPERATOR * operatorWeight(c.operator());
            if (c.fragmentId() != null) {
                score += 2.0;
            }
        }
        if (rule.metadata() != null && rule.metadata().get("estimatedMatchRate") instanceof Number n) {
            double rate = n.doubleValue();
            if (rate > 0 && rate < 1) {
                score += W_CARDINALITY * (1.0 / rate);
            }
        }
        return score;
    }

    private double operatorWeight(ComparisonOperator op) {
        return switch (op) {
            case EQ -> 5.0;
            case NE, IN, NOT_IN -> 4.0;
            case GT, LT, GTE, LTE -> 3.5;
            case STARTS_WITH, CONTAINS -> 2.5;
            case REGEX -> 2.0;
            case EXISTS, NOT_EXISTS -> 1.0;
        };
    }
}
