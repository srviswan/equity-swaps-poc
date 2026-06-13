package com.pb.swap.rules.admin.changeset;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.pb.swap.rules.core.model.Action;
import com.pb.swap.rules.core.model.ComparisonOperator;
import com.pb.swap.rules.core.model.Criterion;
import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.OverridePolicy;
import com.pb.swap.rules.core.model.RuleCategory;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.model.RuleStatus;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * F11 exit criteria (FR-507/508):
 *
 * <ul>
 *   <li>Bulk edit adds disable/priority/effective-date/clone operations to a draft changeset.
 *   <li>Changeset merger projects edits onto the base rule list.
 *   <li>YAML import/export round-trips draft rules.
 *   <li>Conflicting changesets are rejected before simulation/publish.
 * </ul>
 */
class F11ChangesetExitCriteriaTest {

    private final BulkEditService bulkEdit = new BulkEditService();
    private final ChangesetImportExportService importExport = new ChangesetImportExportService();

    @Test
    void bulkDisableAddsOneChangePerSelectedRule() {
        RuleChangeset cs = new RuleChangeset("bulk-disable", "ops");
        List<RuleDefinition> base = List.of(rule("R1", 1, true, 10), rule("R2", 1, true, 20));

        bulkEdit.apply(
                cs,
                new BulkEditService.BulkEditRequest(
                        List.of("R1", "R2"),
                        null,
                        BulkEditService.BulkEditRequest.Operation.DISABLE,
                        null,
                        null,
                        null),
                base);

        assertThat(cs.changes()).hasSize(2);
        assertThat(ChangesetMerger.merge(base, cs))
                .allSatisfy(r -> assertThat(r.enabled()).isFalse());
    }

    @Test
    void bulkPriorityAndEffectiveFromMergeOntoBase() {
        RuleChangeset cs = new RuleChangeset("bulk-edit", "ops");
        List<RuleDefinition> base = List.of(rule("R1", 1, true, 10));
        bulkEdit.apply(
                cs,
                new BulkEditService.BulkEditRequest(
                        List.of("R1"),
                        1,
                        BulkEditService.BulkEditRequest.Operation.SET_PRIORITY,
                        5,
                        null,
                        null),
                base);
        bulkEdit.apply(
                cs,
                new BulkEditService.BulkEditRequest(
                        List.of("R1"),
                        1,
                        BulkEditService.BulkEditRequest.Operation.SET_EFFECTIVE_FROM,
                        null,
                        LocalDate.of(2027, 1, 1),
                        null),
                base);

        RuleDefinition merged =
                ChangesetMerger.merge(base, cs).stream()
                        .filter(r -> r.id().equals("R1"))
                        .findFirst()
                        .orElseThrow();
        assertThat(merged.priority()).isEqualTo(5);
        assertThat(merged.effectiveFrom()).isEqualTo(LocalDate.of(2027, 1, 1));
    }

    @Test
    void cloneToAddsDraftRuleWithNewId() {
        RuleChangeset cs = new RuleChangeset("clone", "ops");
        List<RuleDefinition> base = List.of(rule("R1", 1, true, 10));
        bulkEdit.apply(
                cs,
                new BulkEditService.BulkEditRequest(
                        List.of("R1"),
                        1,
                        BulkEditService.BulkEditRequest.Operation.CLONE_TO,
                        null,
                        null,
                        "R1-CLONE"),
                base);

        assertThat(ChangesetMerger.merge(base, cs))
                .anySatisfy(
                        r -> {
                            assertThat(r.id()).isEqualTo("R1-CLONE");
                            assertThat(r.status()).isEqualTo(RuleStatus.DRAFT);
                        });
    }

    @Test
    void yamlImportExportRoundTripsDraftRules() throws Exception {
        String yaml =
                """
                name: imported
                rules:
                  - id: IMP-1
                    version: 1
                    name: imported rule
                    category: ECONOMIC
                    target: INTEREST_LEG
                    priority: 50
                    enabled: true
                    status: DRAFT
                    criteria:
                      - { field: currency, operator: EQ, value: USD }
                    actions:
                      - { targetPath: interestLeg.dayCount, value: ACT/360 }
                """;
        RuleChangeset imported = importExport.importYaml(yaml, "ba");
        assertThat(imported.changes()).hasSize(1);
        String exported = importExport.exportYaml(imported);
        assertThat(exported).contains("IMP-1").contains("imported");
    }

    @Test
    void publishedChangesetIsNotEditable() {
        RuleChangeset cs = new RuleChangeset("locked", "ops");
        cs.markPublished();
        assertThatThrownBy(
                        () ->
                                cs.addChange(
                                        new RuleChange(
                                                RuleChange.Operation.SET_ENABLED,
                                                "R1",
                                                1,
                                                new RuleChange.Payload(null, false, null, null, null, null))))
                .isInstanceOf(IllegalStateException.class);
    }

    private static RuleDefinition rule(String id, int version, boolean enabled, int priority) {
        return new RuleDefinition(
                id,
                version,
                id,
                RuleCategory.ECONOMIC,
                EnrichmentTarget.INTEREST_LEG,
                priority,
                enabled,
                LocalDate.of(2026, 1, 1),
                null,
                null,
                null,
                RuleStatus.PUBLISHED,
                List.of(new Criterion("currency", ComparisonOperator.EQ, "USD", null)),
                null,
                null,
                List.of(Action.setField("interestLeg.dayCount", "ACT/360", OverridePolicy.ALWAYS)),
                null,
                null);
    }
}
