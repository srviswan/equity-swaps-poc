package com.pb.tcs.rules;

import com.pb.swap.rules.core.trace.DecisionRecord;
import com.pb.swap.rules.core.trace.DecisionTrace;
import com.pb.swap.rules.core.trace.UnresolvedTarget;
import java.util.ArrayList;
import java.util.List;

/**
 * FR-207: renders the engine's {@link DecisionTrace} into plain-language {@link RuleExplain} rows
 * for persistence. One row per applied mutation, plus one row per target the snapshot could not
 * resolve (so a blotter with defaulting holes is diagnosable from the explain trail alone).
 */
public final class RuleExplainNarrator {

    public static final String UNRESOLVED_RULE_ID = "UNRESOLVED";

    public List<RuleExplain> narrate(DecisionTrace trace) {
        List<RuleExplain> explains = new ArrayList<>();
        for (DecisionRecord d : trace.decisions()) {
            explains.add(
                    new RuleExplain(
                            d.seq(),
                            d.ruleId(),
                            d.ruleVersion(),
                            d.category().name(),
                            d.target().name(),
                            narrative(d)));
        }
        // Engine seqs start at 1; continue past the max so (correlationId, seq) stays unique.
        int seq = trace.decisions().stream().mapToInt(DecisionRecord::seq).max().orElse(0) + 1;
        for (UnresolvedTarget u : trace.unresolved()) {
            explains.add(
                    new RuleExplain(
                            seq++,
                            UNRESOLVED_RULE_ID,
                            0,
                            "",
                            u.target().name(),
                            "No %s rule matched (%s); target left for downstream validation."
                                    .formatted(u.target().name(), u.status())));
        }
        return explains;
    }

    private static String narrative(DecisionRecord d) {
        StringBuilder sb =
                new StringBuilder()
                        .append("Rule ")
                        .append(d.ruleId())
                        .append(" v")
                        .append(d.ruleVersion())
                        .append(" (")
                        .append(d.category().name())
                        .append('/')
                        .append(d.strategy().name())
                        .append(") set ")
                        .append(String.join(", ", d.paths()))
                        .append(" = ")
                        .append(d.after() == null ? "<null>" : d.after());
        if (d.before() != null) {
            sb.append(" (was ").append(d.before()).append(')');
        }
        if (d.specificity() > 0) {
            sb.append("; specificity ").append(d.specificity());
        }
        return sb.toString();
    }
}
