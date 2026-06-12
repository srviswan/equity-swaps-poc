package com.pb.swap.rules.admin.changeset;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.swap.rules.admin.service.SnapshotConflictDetector;
import com.pb.swap.rules.core.compile.RuleCompiler;
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

class SnapshotConflictDetectorTest {

    private final RuleCompiler compiler = new RuleCompiler();

    @Test
    void detectsDuplicateSpecificityAndFragments() {
        RuleDefinition a = twin("ECON-A", 1);
        RuleDefinition b = twin("ECON-B", 1);
        assertThat(
                        SnapshotConflictDetector.detect(
                                compiler, List.of(a, b), List.of(), List.of(), LocalDate.now()))
                .isPresent();
    }

    @Test
    void passesDistinctRules() {
        RuleDefinition a = twin("ECON-A", 1);
        RuleDefinition b =
                new RuleDefinition(
                        "ECON-B",
                        1,
                        "other",
                        RuleCategory.ECONOMIC,
                        EnrichmentTarget.SCHEDULE,
                        10,
                        true,
                        LocalDate.of(2026, 1, 1),
                        null,
                        null,
                        null,
                        RuleStatus.PUBLISHED,
                        List.of(new Criterion("currency", ComparisonOperator.EQ, "EUR", null)),
                        null,
                        null,
                        List.of(Action.setField("schedule.paymentFrequency", "MONTHLY", OverridePolicy.ALWAYS)),
                        null,
                        null);
        assertThat(
                        SnapshotConflictDetector.detect(
                                compiler, List.of(a, b), List.of(), List.of(), LocalDate.now()))
                .isEmpty();
    }

    private static RuleDefinition twin(String id, int version) {
        return new RuleDefinition(
                id,
                version,
                id,
                RuleCategory.ECONOMIC,
                EnrichmentTarget.INTEREST_LEG,
                10,
                true,
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
