package com.pb.swap.rules.jmh;

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
import com.pb.swap.rules.runtime.engine.EnrichmentEngineImpl;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
public class EnrichmentBench {

    @State(Scope.Benchmark)
    public static class BenchState {
        EnrichmentEngineImpl engine;
        RawHedgeTrade trade;

        @Setup
        public void setup() {
            List<RuleDefinition> rules = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                rules.add(
                        new RuleDefinition(
                                "R" + i,
                                1,
                                "rule" + i,
                                RuleCategory.ECONOMIC,
                                EnrichmentTarget.INTEREST_LEG,
                                100 + i,
                                true,
                                LocalDate.of(2020, 1, 1),
                                null,
                                null,
                                null,
                                RuleStatus.PUBLISHED,
                                List.of(
                                        new Criterion(
                                                "currency",
                                                ComparisonOperator.EQ,
                                                i % 2 == 0 ? "USD" : "EUR",
                                                null)),
                                null,
                                null,
                                List.of(
                                        Action.setField(
                                                "interestLeg.dayCount",
                                                "ACT/360",
                                                OverridePolicy.NEVER)),
                                null,
                                null));
            }
            RuleSnapshot snap =
                    new RuleCompiler().compile(rules, List.of(), List.of(), LocalDate.now());
            engine =
                    new EnrichmentEngineImpl(
                            new AtomicReference<>(snap),
                            DefaultPipelineFactory.equitySwapPipeline(),
                            TraceSink.NOOP,
                            null);
            trade =
                    new RawHedgeTrade(
                            "T-BENCH",
                            "EQUITY_SWAP",
                            "EQ_SWAP",
                            "USD",
                            "TIER_1",
                            "AUTO",
                            BigDecimal.ONE,
                            LocalDate.now(),
                            "SEC",
                            null);
        }
    }

    @Benchmark
    public void enrich(BenchState state) {
        state.engine.enrich(state.trade);
    }
}
