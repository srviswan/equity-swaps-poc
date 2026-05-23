package com.pb.swap.rules.runtime.engine;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.swap.rules.core.api.EnrichmentResult;
import com.pb.swap.rules.core.compile.RuleCompiler;
import com.pb.swap.rules.core.model.Action;
import com.pb.swap.rules.core.model.ComparisonOperator;
import com.pb.swap.rules.core.model.Criterion;
import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.OverridePolicy;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.core.model.RuleCategory;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.model.RuleStatus;
import com.pb.swap.rules.core.pipeline.DefaultPipelineFactory;
import com.pb.swap.rules.core.snapshot.RuleSnapshot;
import com.pb.swap.rules.core.trace.TraceSink;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

class EnrichmentEngineImplTest {
    @Test
    void enrichesUsdSwapWithLayeredAndWorkflowRules() {
        RuleDefinition economic =
                new RuleDefinition(
                        "ECON_SWAP_USD_INTEREST",
                        1,
                        "USD interest",
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
                        List.of(
                                Action.setField("interestLeg.dayCount", "ACT/365", OverridePolicy.ALWAYS),
                                Action.setField("interestLeg.rateType", "FLOAT", OverridePolicy.NEVER)),
                        null,
                        null);
        RuleDefinition workflow =
                new RuleDefinition(
                        "WF_MANUAL",
                        1,
                        "Manual approval",
                        RuleCategory.WORKFLOW,
                        EnrichmentTarget.WORKFLOW,
                        50,
                        true,
                        LocalDate.of(2020, 1, 1),
                        null,
                        null,
                        null,
                        RuleStatus.PUBLISHED,
                        List.of(new Criterion("source", ComparisonOperator.EQ, "MANUAL", null)),
                        null,
                        null,
                        List.of(Action.setField("workflowStatus", "PENDING_APPROVAL", OverridePolicy.ALWAYS)),
                        null,
                        null);
        RuleCompiler compiler = new RuleCompiler();
        RuleSnapshot snapshot =
                compiler.compile(
                        List.of(economic, workflow),
                        List.of(),
                        List.of(),
                        LocalDate.of(2026, 5, 23));
        EnrichmentEngineImpl engine =
                new EnrichmentEngineImpl(
                        new AtomicReference<>(snapshot),
                        DefaultPipelineFactory.equitySwapPipeline(),
                        TraceSink.NOOP,
                        null);
        RawHedgeTrade raw =
                new RawHedgeTrade(
                        "T-001",
                        "EQUITY_SWAP",
                        "EQ_SWAP",
                        "USD",
                        "TIER_1",
                        "MANUAL",
                        new BigDecimal("1000000"),
                        LocalDate.of(2026, 5, 23),
                        "US0378331005",
                        null);
        long start = System.nanoTime();
        EnrichmentResult result = engine.enrich(raw);
        long elapsedMs = (System.nanoTime() - start) / 1_000_000;
        assertThat(result.swap().interestLeg().dayCount()).isEqualTo("ACT/365");
        assertThat(result.swap().interestLeg().rateType()).isEqualTo("FLOAT");
        assertThat(result.swap().workflowStatus()).isEqualTo("PENDING_APPROVAL");
        assertThat(result.trace().decisions()).isNotEmpty();
        assertThat(result.trace().decisions().stream().anyMatch(d -> "ACT/365".equals(d.after()))).isTrue();
        assertThat(elapsedMs).isLessThan(50);
    }
}
