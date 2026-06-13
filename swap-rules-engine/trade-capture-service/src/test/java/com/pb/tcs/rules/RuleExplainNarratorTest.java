package com.pb.tcs.rules;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.EvaluationMode;
import com.pb.swap.rules.core.model.RuleCategory;
import com.pb.swap.rules.core.trace.DecisionRecord;
import com.pb.swap.rules.core.trace.DecisionTrace;
import com.pb.swap.rules.core.trace.UnresolvedTarget;
import java.util.List;
import org.junit.jupiter.api.Test;

class RuleExplainNarratorTest {

    private final RuleExplainNarrator narrator = new RuleExplainNarrator();

    @Test
    void narratesAppliedDecisionsInPlainLanguage() {
        DecisionRecord applied =
                new DecisionRecord(
                        0,
                        "ECON-US-SS-NYSE",
                        2,
                        RuleCategory.ECONOMIC,
                        EnrichmentTarget.INTEREST_LEG,
                        EvaluationMode.LAYERED,
                        3.5,
                        List.of(),
                        List.of(),
                        List.of("interestLeg.spreadBps"),
                        null,
                        "250",
                        "Layered enrichment applied");
        DecisionTrace trace =
                new DecisionTrace("T-1", "BLK-1/ALL-1/3", "snap@now", List.of(applied), List.of(), false);

        List<RuleExplain> explains = narrator.narrate(trace);

        assertThat(explains).hasSize(1);
        RuleExplain e = explains.get(0);
        assertThat(e.ruleId()).isEqualTo("ECON-US-SS-NYSE");
        assertThat(e.ruleVersion()).isEqualTo(2);
        assertThat(e.category()).isEqualTo("ECONOMIC");
        assertThat(e.target()).isEqualTo("INTEREST_LEG");
        assertThat(e.narrative())
                .contains("ECON-US-SS-NYSE")
                .contains("v2")
                .contains("interestLeg.spreadBps")
                .contains("250")
                .contains("specificity 3.5");
    }

    @Test
    void overwrittenValueShowsBefore() {
        DecisionRecord applied =
                new DecisionRecord(
                        0,
                        "R",
                        1,
                        RuleCategory.ECONOMIC,
                        EnrichmentTarget.INTEREST_LEG,
                        EvaluationMode.LAYERED,
                        0,
                        List.of(),
                        List.of(),
                        List.of("interestLeg.rateType"),
                        "FIXED",
                        "FLOATING",
                        "Layered enrichment applied");
        DecisionTrace trace = new DecisionTrace("T", "ID", "v", List.of(applied), List.of(), false);

        assertThat(narrator.narrate(trace).get(0).narrative()).contains("(was FIXED)");
    }

    @Test
    void unresolvedTargetsBecomeDiagnosableRows() {
        DecisionTrace trace =
                new DecisionTrace(
                        "T-2",
                        "BLK-2/ALL-1/1",
                        "snap@now",
                        List.of(),
                        List.of(new UnresolvedTarget(EnrichmentTarget.ROUTING, "routing", "NO_MATCH")),
                        false);

        List<RuleExplain> explains = narrator.narrate(trace);

        assertThat(explains).hasSize(1);
        assertThat(explains.get(0).ruleId()).isEqualTo(RuleExplainNarrator.UNRESOLVED_RULE_ID);
        assertThat(explains.get(0).target()).isEqualTo("ROUTING");
        assertThat(explains.get(0).narrative()).contains("No ROUTING rule matched").contains("NO_MATCH");
    }
}
