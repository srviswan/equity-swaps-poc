package com.pb.swap.rules.core.compile;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.swap.rules.core.model.ComparisonOperator;
import com.pb.swap.rules.core.model.Criterion;
import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.RuleCategory;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.model.RuleStatus;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class SpecificityScorerTest {
    @Test
    void moreCriteriaScoresHigher() {
        SpecificityScorer scorer = new SpecificityScorer();
        RuleDefinition narrow =
                new RuleDefinition(
                        "R1",
                        1,
                        "narrow",
                        RuleCategory.ECONOMIC,
                        EnrichmentTarget.INTEREST_LEG,
                        100,
                        true,
                        LocalDate.of(2020, 1, 1),
                        null,
                        null,
                        null,
                        RuleStatus.PUBLISHED,
                        List.of(
                                new Criterion("book", ComparisonOperator.EQ, "EQ_SWAP", null),
                                new Criterion("currency", ComparisonOperator.EQ, "USD", null)),
                        null,
                        null,
                        null,
                        null,
                        null);
        RuleDefinition broad =
                new RuleDefinition(
                        "R2",
                        1,
                        "broad",
                        RuleCategory.ECONOMIC,
                        EnrichmentTarget.INTEREST_LEG,
                        100,
                        true,
                        LocalDate.of(2020, 1, 1),
                        null,
                        null,
                        null,
                        RuleStatus.PUBLISHED,
                        List.of(new Criterion("currency", ComparisonOperator.EQ, "USD", null)),
                        null,
                        null,
                        null,
                        null,
                        null);
        double narrowScore = scorer.score(narrow, narrow.criteria());
        double broadScore = scorer.score(broad, broad.criteria());
        assertThat(narrowScore).isGreaterThan(broadScore);
    }
}
