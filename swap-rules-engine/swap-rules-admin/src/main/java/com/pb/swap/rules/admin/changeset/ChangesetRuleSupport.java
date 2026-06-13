package com.pb.swap.rules.admin.changeset;

import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.model.RuleStatus;
import java.util.List;

/** Shared changeset rule projection helpers. */
final class ChangesetRuleSupport {

    private ChangesetRuleSupport() {}

    static List<RuleDefinition> promoteToPublished(List<RuleDefinition> projected) {
        return projected.stream().map(ChangesetRuleSupport::asPublished).toList();
    }

    static RuleDefinition asPublished(RuleDefinition rule) {
        if (rule.status() == RuleStatus.PUBLISHED) {
            return rule;
        }
        return new RuleDefinition(
                rule.id(),
                rule.version(),
                rule.name(),
                rule.category(),
                rule.target(),
                rule.priority(),
                rule.enabled(),
                rule.effectiveFrom(),
                rule.effectiveTo(),
                rule.evaluationMode(),
                rule.specificityBoost(),
                RuleStatus.PUBLISHED,
                rule.criteria(),
                rule.includes(),
                rule.apply(),
                rule.actions(),
                rule.overrides(),
                rule.metadata());
    }
}
