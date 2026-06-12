package com.pb.tcs.rules;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.swap.rules.core.model.EnrichedEquitySwap;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * F3 exit criteria (FR-204/205/207) against the golden fixture rule set:
 *
 * <ol>
 *   <li>Golden fixtures produce the expected blotter (layered economic defaulting, first-match
 *       non-economic, disabled rules never fire).
 *   <li>A back-dated trade is enriched under the rule versions effective on its trade date —
 *       same snapshot, no recompile (FR-205/D7).
 *   <li>Every assembled blotter carries a persistable plain-language explain trail (FR-207).
 * </ol>
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class F3GoldenFixtureTest {

    private BlotterAssembler assembler;

    @BeforeAll
    void load() {
        assembler =
                new BlotterAssembler(F3Fixtures.goldenRules());
    }

    @Test
    void goldenTradeProducesExpectedBlotter() {
        BlotterAssembler.Assembly assembly =
                assembler.assemble(F3Fixtures.usNyseSwap("BLK-GOLD", 3, "2026-06-10"));

        SwapBlotter blotter = assembly.blotter();
        assertThat(blotter.correlationId()).isEqualTo("BLK-GOLD/ALL-1/3");
        assertThat(blotter.allocationType()).isEqualTo("SWAP");
        assertThat(blotter.tradeDate()).isEqualTo(LocalDate.of(2026, 6, 10));
        assertThat(blotter.snapshotVersion()).isEqualTo(assembler.snapshotVersion());

        EnrichedEquitySwap swap = blotter.swap();
        // ECON-US-SS-NYSE v2 (effective from 2026-06-01): SOFR-era spread
        assertThat(swap.interestLeg().spreadBps()).isEqualByComparingTo(BigDecimal.valueOf(250));
        assertThat(swap.interestLeg().rateType()).isEqualTo("FLOATING");
        // ECON-BASE layers in dayCount but must NOT overwrite the specific rule's spread
        assertThat(swap.interestLeg().dayCount()).isEqualTo("ACT/360");
        assertThat(swap.schedule().paymentFrequency()).isEqualTo("MONTHLY");
        // NON_ECONOMIC first-match: client-master rule beats the fallback
        assertThat(swap.legalEntity()).isEqualTo("PB_ENTITY_US");
        assertThat(swap.workflowStatus()).isEqualTo("PENDING_VALIDATION");
    }

    @Test
    void backDatedTradeUsesHistoricalRuleVersion() {
        BlotterAssembler.Assembly backDated =
                assembler.assemble(F3Fixtures.usNyseSwap("BLK-BACK", 1, "2026-05-15"));

        // ECON-US-SS-NYSE v1 (effective 2026-01-01..2026-05-31): LIBOR-era spread
        assertThat(backDated.blotter().swap().interestLeg().spreadBps())
                .isEqualByComparingTo(BigDecimal.valueOf(300));
        assertThat(backDated.explains())
                .anySatisfy(
                        e -> {
                            assertThat(e.ruleId()).isEqualTo("ECON-US-SS-NYSE");
                            assertThat(e.ruleVersion()).isEqualTo(1);
                        })
                .noneSatisfy(
                        e -> {
                            assertThat(e.ruleId()).isEqualTo("ECON-US-SS-NYSE");
                            assertThat(e.ruleVersion()).isEqualTo(2);
                        });
    }

    @Test
    void currentTradeUsesCurrentRuleVersion() {
        BlotterAssembler.Assembly current =
                assembler.assemble(F3Fixtures.usNyseSwap("BLK-CUR", 1, "2026-06-10"));

        assertThat(current.explains())
                .anySatisfy(
                        e -> {
                            assertThat(e.ruleId()).isEqualTo("ECON-US-SS-NYSE");
                            assertThat(e.ruleVersion()).isEqualTo(2);
                        });
    }

    @Test
    void firstMatchFallbackAppliesWhenSpecificRuleMisses() {
        BlotterAssembler.Assembly assembly =
                assembler.assemble(F3Fixtures.usNyseSwap("BLK-OTHER", 1, "2026-06-10", "Z9999"));

        assertThat(assembly.blotter().swap().legalEntity()).isEqualTo("PB_ENTITY_GLOBAL");
    }

    @Test
    void disabledRulesNeverFire() {
        BlotterAssembler.Assembly assembly =
                assembler.assemble(F3Fixtures.usNyseSwap("BLK-DIS", 1, "2026-06-10"));

        assertThat(assembly.blotter().swap().interestLeg().spreadBps())
                .isNotEqualByComparingTo(BigDecimal.valueOf(999));
        assertThat(assembly.explains()).noneMatch(e -> e.ruleId().equals("ECON-DISABLED"));
    }

    @Test
    void explainTrailCoversAppliedRulesAndUnresolvedTargets() {
        BlotterAssembler.Assembly assembly =
                assembler.assemble(F3Fixtures.usNyseSwap("BLK-EXP", 1, "2026-06-10"));

        assertThat(assembly.explains())
                .extracting(RuleExplain::ruleId)
                .contains("ECON-US-SS-NYSE", "ECON-BASE", "NONECON-CM-H12456", "WF-DEFAULT");
        // No ROUTING rules in the fixture: must surface as a diagnosable unresolved row
        assertThat(assembly.explains())
                .anySatisfy(
                        e -> {
                            assertThat(e.ruleId()).isEqualTo(RuleExplainNarrator.UNRESOLVED_RULE_ID);
                            assertThat(e.target()).isEqualTo("ROUTING");
                        });
        assertThat(assembly.explains())
                .allSatisfy(e -> assertThat(e.narrative()).isNotBlank());
    }

    @Test
    void reloadSwapsSnapshotAtomically() {
        String before = assembler.snapshotVersion();

        assembler.reload(F3Fixtures.goldenRules());

        assertThat(assembler.snapshotVersion()).isNotEqualTo(before);
        // engine still functional on the new snapshot
        assertThat(
                        assembler
                                .assemble(F3Fixtures.usNyseSwap("BLK-RELOAD", 1, "2026-06-10"))
                                .blotter()
                                .swap()
                                .interestLeg()
                                .spreadBps())
                .isEqualByComparingTo(BigDecimal.valueOf(250));
    }
}
