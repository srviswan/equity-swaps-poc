package com.pb.swap.rules.admin.changeset;

import com.pb.swap.rules.core.model.RuleDefinition;
import java.time.LocalDate;

/** One atomic edit within a changeset (FR-507/508). */
public record RuleChange(Operation operation, String ruleId, int version, Payload payload) {

    public enum Operation {
        UPSERT_RULE,
        SET_ENABLED,
        SET_PRIORITY,
        SET_EFFECTIVE_DATES,
        CLONE_RULE
    }

    public record Payload(
            RuleDefinition rule,
            Boolean enabled,
            Integer priority,
            LocalDate effectiveFrom,
            LocalDate effectiveTo,
            String cloneTargetId) {}
}
