package com.pb.tcs.parity;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.config.ParityManifestConfig;
import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.rules.BlotterAssembler;
import com.pb.tcs.rules.F3Fixtures;
import com.pb.tcs.rules.RuleSetLoader;
import com.pb.tcs.rules.SwapBlotter;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ParityFieldComparatorTest {

    private ParityFieldComparator comparator;
    private SwapBlotter baseline;

    @BeforeAll
    void setUp() {
        comparator = new ParityFieldComparator(TcsConfigLoader.parityManifest());
        baseline =
                new BlotterAssembler(RuleSetLoader.fromClasspath("fixtures/rules/f3-golden-rules.yml"))
                        .assemble(F3Fixtures.usNyseSwap("BLK-PAR", 1, "2026-06-10"))
                        .blotter();
    }

    @Test
    void identicalBlottersMatch() {
        ParityMismatchReport report = comparator.compare(baseline, baseline);

        assertThat(report.match()).isTrue();
        assertThat(report.mismatches()).isEmpty();
    }

    @Test
    void spreadWithinToleranceMatches() {
        SwapBlotter legacy = withSpread(baseline, BigDecimal.valueOf(250.005));

        ParityMismatchReport report = comparator.compare(baseline, legacy);

        assertThat(report.match()).isTrue();
    }

    @Test
    void spreadOutsideToleranceReportsMismatch() {
        SwapBlotter legacy = withSpread(baseline, BigDecimal.valueOf(251));

        ParityMismatchReport report = comparator.compare(baseline, legacy);

        assertThat(report.match()).isFalse();
        assertThat(report.mismatches())
                .anySatisfy(
                        m -> {
                            assertThat(m.fieldPath()).isEqualTo("swap.interestLeg.spreadBps");
                            assertThat(m.policy()).isEqualTo(ParityManifestConfig.Mode.TOLERANCE);
                        });
    }

    @Test
    void ignoredFieldsDoNotSurfaceAsMismatches() {
        SwapBlotter legacy =
                new SwapBlotter(
                        baseline.correlationId(),
                        baseline.blockId(),
                        baseline.allocationId(),
                        baseline.version(),
                        baseline.allocationType(),
                        baseline.book(),
                        baseline.accountId(),
                        baseline.securityId(),
                        baseline.tradeDate(),
                        "LEGACY-SNAPSHOT",
                        baseline.swap());

        ParityMismatchReport report = comparator.compare(baseline, legacy);

        assertThat(report.match()).isTrue();
        assertThat(report.mismatches()).noneMatch(m -> m.fieldPath().equals("snapshotVersion"));
    }

    @Test
    void manifestChangeWithoutCodeReloadsPolicy() {
        ParityManifestConfig strict =
                new ParityManifestConfig(
                        ParityManifestConfig.Mode.MUST_MATCH,
                        java.util.Map.of(
                                "snapshotVersion",
                                ParityManifestConfig.FieldPolicy.of(ParityManifestConfig.Mode.MUST_MATCH)));
        ParityFieldComparator strictComparator = new ParityFieldComparator(strict);
        SwapBlotter legacy =
                new SwapBlotter(
                        baseline.correlationId(),
                        baseline.blockId(),
                        baseline.allocationId(),
                        baseline.version(),
                        baseline.allocationType(),
                        baseline.book(),
                        baseline.accountId(),
                        baseline.securityId(),
                        baseline.tradeDate(),
                        "LEGACY-SNAPSHOT",
                        baseline.swap());

        ParityMismatchReport report = strictComparator.compare(baseline, legacy);

        assertThat(report.match()).isFalse();
        assertThat(report.mismatches())
                .anySatisfy(m -> assertThat(m.fieldPath()).isEqualTo("snapshotVersion"));
    }

    private static SwapBlotter withSpread(SwapBlotter source, BigDecimal spreadBps) {
        var swap = source.swap();
        var leg = swap.interestLeg();
        var updatedLeg =
                new com.pb.swap.rules.core.model.InterestLeg(
                        leg.dayCount(),
                        leg.rateType(),
                        leg.index(),
                        spreadBps,
                        leg.fixedRate());
        var updated =
                new com.pb.swap.rules.core.model.EnrichedEquitySwap(
                        swap.tradeId(),
                        swap.swapContract(),
                        updatedLeg,
                        swap.equityLeg(),
                        swap.schedule(),
                        swap.divPassthrough(),
                        swap.legalEntity(),
                        swap.workflowStatus(),
                        swap.routingDestination());
        return new SwapBlotter(
                source.correlationId(),
                source.blockId(),
                source.allocationId(),
                source.version(),
                source.allocationType(),
                source.book(),
                source.accountId(),
                source.securityId(),
                source.tradeDate(),
                source.snapshotVersion(),
                updated);
    }
}
