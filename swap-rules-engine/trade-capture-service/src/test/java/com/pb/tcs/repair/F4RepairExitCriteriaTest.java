package com.pb.tcs.repair;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import com.pb.tcs.rules.BlotterAssembler;
import com.pb.tcs.rules.F3Fixtures;
import com.pb.tcs.rules.RuleExplain;
import com.pb.tcs.rules.RuleSetLoader;
import com.pb.tcs.rules.SwapBlotter;
import com.pb.tcs.validation.BusinessValidator;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * F4 exit criteria (FR-209/300): the repair → edit → revalidate → continue demo.
 *
 * <p>An LSE trade misses the NYSE-only economic rule, leaving {@code interestLeg.rateType}
 * unset. Business validation quarantines it post-ACK (FR-300); ops repair the field, business
 * validation re-runs <b>alone</b> (defaulting untouched, FR-209), and the trade continues into
 * the standard blotter persist with an OPS-OVERRIDE explain entry.
 */
class F4RepairExitCriteriaTest {

    private BlotterAssembler assembler;
    private BusinessValidator validator;
    private InMemoryRepairStore repairStore;
    private InMemoryBlotterStore blotterStore;
    private BusinessValidationStage stage;
    private RepairService repairService;

    @BeforeEach
    void setUp() {
        assembler =
                new BlotterAssembler(F3Fixtures.goldenRules());
        validator = new BusinessValidator(TcsConfigLoader.businessValidation());
        repairStore = new InMemoryRepairStore();
        blotterStore = new InMemoryBlotterStore();
        stage = new BusinessValidationStage(validator, blotterStore, repairStore);
        repairService = new RepairService(repairStore, validator, blotterStore);
    }

    /** Golden NYSE trade: fully defaulted, passes the gate, persists with its explain trail. */
    @Test
    void validBlotterPassesAndPersists() {
        var outcome = stage.process(assembler.assemble(F3Fixtures.usNyseSwap("BLK-OK", 1, "2026-06-10")));

        assertThat(outcome).isInstanceOf(BusinessValidationStage.Outcome.Passed.class);
        assertThat(blotterStore.findBlotterJson("BLK-OK/ALL-1/1")).isPresent();
        assertThat(blotterStore.findExplains("BLK-OK/ALL-1/1")).isNotEmpty();
        assertThat(repairStore.openItems(BusinessValidationStage.CATEGORY)).isEmpty();
    }

    @Test
    void repairEditRevalidateContinue() {
        // 1. LSE trade fails business validation → quarantined, NOT persisted (FR-300)
        var outcome = stage.process(assembler.assemble(lseSwap("BLK-FIX")));
        var quarantined = (BusinessValidationStage.Outcome.Quarantined) outcome;
        assertThat(quarantined.violations())
                .extracting(BusinessValidator.Violation::field)
                .contains("swap.interestLeg.rateType");
        assertThat(blotterStore.findBlotterJson("BLK-FIX/ALL-1/1")).isEmpty();

        // visible in the repair queue with reason (PRD: "failure lands in repair UI with reason")
        var open = repairService.openRepairs();
        assertThat(open).hasSize(1);
        assertThat(open.get(0).detail()).contains("MANDATORY_FIELD_MISSING");
        assertThat(open.get(0).correlationId()).isEqualTo("BLK-FIX/ALL-1/1");

        // 2. partial edit → still invalid (revalidation reports remaining holes, edit retained)
        var still =
                repairService.editAndRevalidate(
                        quarantined.quarantineId(), Map.of(), "ops.jane");
        assertThat(still).isInstanceOf(RepairService.RevalidationResult.StillInvalid.class);

        // 3. fix the field → clean
        var clean =
                repairService.editAndRevalidate(
                        quarantined.quarantineId(),
                        Map.of("swap.interestLeg.rateType", "FLOATING"),
                        "ops.jane");
        assertThat(clean).isInstanceOf(RepairService.RevalidationResult.Clean.class);

        // 4. continue → blotter persisted, quarantine REPROCESSED, override audited
        SwapBlotter continued =
                repairService.continueTrade(
                        quarantined.quarantineId(),
                        Map.of("swap.interestLeg.rateType", "FLOATING"),
                        "ops.jane");

        assertThat(continued.swap().interestLeg().rateType()).isEqualTo("FLOATING");
        // defaulting was NOT re-run: values produced at assembly time survive untouched
        assertThat(continued.swap().interestLeg().dayCount()).isEqualTo("ACT/360");
        assertThat(continued.swap().legalEntity()).isEqualTo("PB_ENTITY_US");
        assertThat(blotterStore.findBlotterJson("BLK-FIX/ALL-1/1")).isPresent();
        assertThat(repairStore.find(quarantined.quarantineId()).orElseThrow().status())
                .isEqualTo(RepairStore.STATUS_REPROCESSED);
        assertThat(blotterStore.findExplains("BLK-FIX/ALL-1/1"))
                .anySatisfy(
                        e -> {
                            assertThat(e.ruleId()).isEqualTo(RepairService.OVERRIDE_RULE_ID);
                            assertThat(e.narrative())
                                    .contains("swap.interestLeg.rateType")
                                    .contains("ops.jane");
                        });
    }

    @Test
    void continueWithUnfixedPayloadIsRejected() {
        var quarantined =
                (BusinessValidationStage.Outcome.Quarantined)
                        stage.process(assembler.assemble(lseSwap("BLK-BAD")));

        assertThatThrownBy(
                        () -> repairService.continueTrade(quarantined.quarantineId(), Map.of(), "ops.jane"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("still invalid");

        assertThat(repairStore.find(quarantined.quarantineId()).orElseThrow().status())
                .isEqualTo(RepairStore.STATUS_OPEN);
        assertThat(blotterStore.findBlotterJson("BLK-BAD/ALL-1/1")).isEmpty();
    }

    @Test
    void discardIsTerminalAndAudited() {
        var quarantined =
                (BusinessValidationStage.Outcome.Quarantined)
                        stage.process(assembler.assemble(lseSwap("BLK-DROP")));

        repairService.discard(quarantined.quarantineId(), "ops.jane");

        assertThat(repairStore.find(quarantined.quarantineId()).orElseThrow().status())
                .isEqualTo(RepairStore.STATUS_DISCARDED);
        assertThatThrownBy(
                        () ->
                                repairService.editAndRevalidate(
                                        quarantined.quarantineId(), Map.of(), "ops.jane"))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void editedFieldsCarryNoStaleExplainFromEngine() {
        var quarantined =
                (BusinessValidationStage.Outcome.Quarantined)
                        stage.process(assembler.assemble(lseSwap("BLK-EXP")));

        repairService.continueTrade(
                quarantined.quarantineId(),
                Map.of("swap.interestLeg.rateType", "FIXED"),
                "ops.kim");

        // the persisted trail for a repaired trade is the override trail (frozen-rules
        // provenance for engine-set fields remains queryable from the quarantine payload)
        var explains = blotterStore.findExplains("BLK-EXP/ALL-1/1");
        assertThat(explains).extracting(RuleExplain::ruleId).containsOnly(RepairService.OVERRIDE_RULE_ID);
    }

    /** LSE variant of the golden trade: no NYSE economic rule match → rateType never defaulted. */
    private static EnrichedAllocation lseSwap(String blockId) {
        EnrichedAllocation base = F3Fixtures.usNyseSwap(blockId, 1, "2026-06-10");
        AllocationMessage lse = base.message().toBuilder().setExchange("LSE").build();
        TcsIngressMessage env = base.envelope().toBuilder().setAllocation(lse).build();
        return new EnrichedAllocation(
                env, env.toByteArray(), base.securityRef(), base.clientRef(), base.bookRef(), null);
    }
}
