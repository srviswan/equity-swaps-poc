package com.pb.swap.rules.admin.changeset;

import com.pb.swap.rules.core.model.RuleDefinition;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

/** FR-507 multi-select bulk edit operations. */
@Service
public final class BulkEditService {

    public RuleChangeset apply(RuleChangeset changeset, BulkEditRequest request, List<RuleDefinition> baseRules) {
        for (String ruleId : request.ruleIds()) {
            RuleDefinition rule =
                    baseRules.stream()
                            .filter(r -> r.id().equals(ruleId))
                            .filter(r -> request.version() == null || r.version() == request.version())
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("unknown rule " + ruleId));
            switch (request.operation()) {
                case DISABLE ->
                        changeset.addChange(
                                new RuleChange(
                                        RuleChange.Operation.SET_ENABLED,
                                        rule.id(),
                                        rule.version(),
                                        new RuleChange.Payload(null, false, null, null, null, null)));
                case ENABLE ->
                        changeset.addChange(
                                new RuleChange(
                                        RuleChange.Operation.SET_ENABLED,
                                        rule.id(),
                                        rule.version(),
                                        new RuleChange.Payload(null, true, null, null, null, null)));
                case SET_PRIORITY ->
                        changeset.addChange(
                                new RuleChange(
                                        RuleChange.Operation.SET_PRIORITY,
                                        rule.id(),
                                        rule.version(),
                                        new RuleChange.Payload(
                                                null, null, request.priority(), null, null, null)));
                case SET_EFFECTIVE_FROM ->
                        changeset.addChange(
                                new RuleChange(
                                        RuleChange.Operation.SET_EFFECTIVE_DATES,
                                        rule.id(),
                                        rule.version(),
                                        new RuleChange.Payload(
                                                null,
                                                null,
                                                null,
                                                request.effectiveFrom(),
                                                rule.effectiveTo(),
                                                null)));
                case CLONE_TO ->
                        changeset.addChange(
                                new RuleChange(
                                        RuleChange.Operation.CLONE_RULE,
                                        rule.id(),
                                        rule.version(),
                                        new RuleChange.Payload(
                                                null, null, null, null, null, request.cloneTargetId())));
            }
        }
        return changeset;
    }

    public record BulkEditRequest(
            List<String> ruleIds,
            Integer version,
            Operation operation,
            Integer priority,
            LocalDate effectiveFrom,
            String cloneTargetId) {

        public enum Operation {
            ENABLE,
            DISABLE,
            SET_PRIORITY,
            SET_EFFECTIVE_FROM,
            CLONE_TO
        }
    }
}
