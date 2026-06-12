package com.pb.swap.rules.admin.service;

import com.pb.swap.rules.core.compile.CompiledRule;
import com.pb.swap.rules.core.compile.RuleCompiler;
import com.pb.swap.rules.core.model.ActionTemplate;
import com.pb.swap.rules.core.model.CriteriaFragment;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.snapshot.RuleSnapshot;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/** Shared compile-time conflict detection for publish and changeset flows (FR-206/508). */
public final class SnapshotConflictDetector {

    private SnapshotConflictDetector() {}

    public static Optional<String> detect(
            RuleCompiler compiler,
            List<RuleDefinition> rules,
            List<ActionTemplate> templates,
            List<CriteriaFragment> fragments,
            LocalDate asOf) {
        try {
            RuleSnapshot snap = compiler.compile(rules, templates, fragments, asOf);
            Set<String> seen = new HashSet<>();
            for (var bucket : snap.allBuckets().values()) {
                for (CompiledRule r : bucket.rules()) {
                    String key =
                            r.category()
                                    + "|"
                                    + r.target()
                                    + "|"
                                    + r.specificity()
                                    + "|"
                                    + r.fragmentIds();
                    if (!seen.add(key)) {
                        return Optional.of(
                                "Conflict: duplicate specificity and fragments for rule "
                                        + r.ruleId());
                    }
                }
            }
            return Optional.empty();
        } catch (RuntimeException e) {
            return Optional.of(e.getMessage());
        }
    }
}
