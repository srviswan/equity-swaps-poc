package com.pb.swap.rules.admin.changeset;

import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.model.RuleStatus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Applies a changeset onto a base rule list (FR-508 projection). */
public final class ChangesetMerger {

    private ChangesetMerger() {}

    public static List<RuleDefinition> merge(List<RuleDefinition> base, RuleChangeset changeset) {
        Map<String, RuleDefinition> byKey = new LinkedHashMap<>();
        for (RuleDefinition rule : base) {
            byKey.put(key(rule.id(), rule.version()), rule);
        }
        for (RuleChange change : changeset.changes()) {
            switch (change.operation()) {
                case UPSERT_RULE -> {
                    RuleDefinition draft = change.payload().rule();
                    byKey.put(key(draft.id(), draft.version()), draft);
                }
                case SET_ENABLED -> {
                    RuleDefinition prior = require(byKey, change.ruleId(), change.version());
                    byKey.put(
                            key(prior.id(), prior.version()),
                            copy(
                                    prior,
                                    change.payload().enabled(),
                                    null,
                                    null,
                                    null,
                                    null));
                }
                case SET_PRIORITY -> {
                    RuleDefinition prior = require(byKey, change.ruleId(), change.version());
                    byKey.put(
                            key(prior.id(), prior.version()),
                            copy(
                                    prior,
                                    null,
                                    change.payload().priority(),
                                    null,
                                    null,
                                    null));
                }
                case SET_EFFECTIVE_DATES -> {
                    RuleDefinition prior = require(byKey, change.ruleId(), change.version());
                    byKey.put(
                            key(prior.id(), prior.version()),
                            copy(
                                    prior,
                                    null,
                                    null,
                                    change.payload().effectiveFrom(),
                                    change.payload().effectiveTo(),
                                    null));
                }
                case CLONE_RULE -> {
                    RuleDefinition source = require(byKey, change.ruleId(), change.version());
                    String newId = change.payload().cloneTargetId();
                    RuleDefinition clone =
                            new RuleDefinition(
                                    newId,
                                    1,
                                    source.name() + " (clone)",
                                    source.category(),
                                    source.target(),
                                    source.priority(),
                                    source.enabled(),
                                    source.effectiveFrom(),
                                    source.effectiveTo(),
                                    source.evaluationMode(),
                                    source.specificityBoost(),
                                    RuleStatus.DRAFT,
                                    source.criteria(),
                                    source.includes(),
                                    source.apply(),
                                    source.actions(),
                                    source.overrides(),
                                    source.metadata());
                    byKey.put(key(clone.id(), clone.version()), clone);
                }
            }
        }
        return new ArrayList<>(byKey.values());
    }

    private static RuleDefinition require(Map<String, RuleDefinition> byKey, String id, int version) {
        RuleDefinition rule = byKey.get(key(id, version));
        if (rule == null) {
            throw new IllegalArgumentException("unknown rule " + id + " v" + version);
        }
        return rule;
    }

    private static String key(String id, int version) {
        return id + "|" + version;
    }

    private static RuleDefinition copy(
            RuleDefinition source,
            Boolean enabled,
            Integer priority,
            LocalDate effectiveFrom,
            LocalDate effectiveTo,
            RuleStatus status) {
        return new RuleDefinition(
                source.id(),
                source.version(),
                source.name(),
                source.category(),
                source.target(),
                priority != null ? priority : source.priority(),
                enabled != null ? enabled : source.enabled(),
                effectiveFrom != null ? effectiveFrom : source.effectiveFrom(),
                effectiveTo != null ? effectiveTo : source.effectiveTo(),
                source.evaluationMode(),
                source.specificityBoost(),
                status != null ? status : source.status(),
                source.criteria(),
                source.includes(),
                source.apply(),
                source.actions(),
                source.overrides(),
                source.metadata());
    }
}
