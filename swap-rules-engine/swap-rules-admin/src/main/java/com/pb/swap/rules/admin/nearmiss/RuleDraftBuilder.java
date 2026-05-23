package com.pb.swap.rules.admin.nearmiss;

import com.pb.swap.rules.core.model.ComparisonOperator;
import com.pb.swap.rules.core.model.Criterion;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.model.RuleStatus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class RuleDraftBuilder {
    public RuleDefinition fromCandidate(RuleDefinition candidate, RawHedgeTrade trade, NearMissScorer.NearMissResult nearMiss) {
        List<Criterion> criteria = new ArrayList<>();
        if (candidate.criteria() != null) {
            criteria.addAll(candidate.criteria());
        }
        for (String missing : nearMiss.missingCriteria()) {
            String field = missing.split(" ")[0];
            Object value = tradeValue(trade, field);
            if (value != null) {
                criteria.add(new Criterion(field, ComparisonOperator.EQ, value, null));
            }
        }
        return new RuleDefinition(
                candidate.id() + "_DRAFT",
                candidate.version() + 1,
                candidate.name() + " (draft)",
                candidate.category(),
                candidate.target(),
                candidate.priority(),
                true,
                LocalDate.now().plusDays(1),
                null,
                candidate.evaluationMode(),
                candidate.specificityBoost(),
                RuleStatus.DRAFT,
                criteria,
                candidate.includes(),
                candidate.apply(),
                candidate.actions(),
                candidate.overrides(),
                candidate.metadata());
    }

    private Object tradeValue(RawHedgeTrade trade, String field) {
        return switch (field) {
            case "book" -> trade.book();
            case "currency" -> trade.currency();
            case "productType" -> trade.productType();
            case "clientTier" -> trade.clientTier();
            case "source" -> trade.source();
            default -> null;
        };
    }
}
