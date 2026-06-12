package com.pb.tcs.parity;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.api.ParityApi;
import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.harness.IngressHarnessPublisher;
import com.pb.tcs.harness.LegacyTradeExtract;
import com.pb.tcs.rules.BlotterAssembler;
import com.pb.tcs.rules.F3Fixtures;
import com.pb.tcs.rules.RuleSetLoader;
import com.pb.tcs.rules.SwapBlotter;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * F9 exit criteria (FR-604/606):
 *
 * <ul>
 *   <li>Legacy extract → ingress synthesis → assemble → diff against legacy blotter store.
 *   <li>Configurable manifest drives must-match / tolerance / ignore without code change.
 *   <li>Batch run produces per-field mismatch report via {@link ParityApi}.
 * </ul>
 */
class F9ParityExitCriteriaTest {

    private InMemoryLegacyBlotterStore legacyStore;
    private ParityHarnessService harness;
    private ParityApi api;
    private BlotterAssembler assembler;

    @BeforeEach
    void setUp() {
        legacyStore = new InMemoryLegacyBlotterStore();
        assembler = new BlotterAssembler(RuleSetLoader.fromClasspath("fixtures/rules/f3-golden-rules.yml"));
        harness =
                new ParityHarnessService(
                        legacyStore,
                        assembler,
                        new ParityFieldComparator(TcsConfigLoader.parityManifest()));
        api = new ParityApi(harness);
    }

    @Test
    void goldenLegacyExtractMatchesWhenLegacyBlotterStored() {
        LegacyTradeExtract extract = LegacyTradeExtract.goldenUsNyse("BLK-F9", 1, "2026-06-10");
        SwapBlotter expected = assembler.assemble(IngressHarnessPublisher.toEnrichedAllocation(extract)).blotter();
        legacyStore.put(expected);

        ParityApi.ParityRunResponse response =
                api.run(new ParityApi.ParityRunRequest(List.of(extract)));

        assertThat(response.compared()).isEqualTo(1);
        assertThat(response.matched()).isEqualTo(1);
        assertThat(response.mismatched()).isZero();
        assertThat(response.trades()).singleElement().satisfies(t -> assertThat(t.match()).isTrue());
    }

    @Test
    void spreadDriftWithinToleranceStillMatches() {
        LegacyTradeExtract extract = LegacyTradeExtract.goldenUsNyse("BLK-TOL", 1, "2026-06-10");
        SwapBlotter tcs = assembler.assemble(IngressHarnessPublisher.toEnrichedAllocation(extract)).blotter();
        legacyStore.put(withSpread(tcs, BigDecimal.valueOf(250.005)));

        ParityApi.ParityRunResponse response =
                api.run(new ParityApi.ParityRunRequest(List.of(extract)));

        assertThat(response.matched()).isEqualTo(1);
    }

    @Test
    void economicMismatchSurfacesPerFieldInReport() {
        LegacyTradeExtract extract = LegacyTradeExtract.goldenUsNyse("BLK-MIS", 1, "2026-06-10");
        SwapBlotter tcs = assembler.assemble(IngressHarnessPublisher.toEnrichedAllocation(extract)).blotter();
        legacyStore.put(withSpread(tcs, BigDecimal.valueOf(999)));

        ParityApi.ParityRunResponse response =
                api.run(new ParityApi.ParityRunRequest(List.of(extract)));

        assertThat(response.mismatched()).isEqualTo(1);
        assertThat(response.trades())
                .singleElement()
                .satisfies(
                        t -> {
                            assertThat(t.match()).isFalse();
                            assertThat(t.mismatches())
                                    .anySatisfy(
                                            m ->
                                                    assertThat(m.fieldPath())
                                                            .isEqualTo("swap.interestLeg.spreadBps"));
                        });
    }

    @Test
    void missingLegacyKeyIsReportedWithoutFailingBatch() {
        LegacyTradeExtract extract = LegacyTradeExtract.goldenUsNyse("BLK-MISS", 1, "2026-06-10");

        ParityApi.ParityRunResponse response =
                api.run(new ParityApi.ParityRunRequest(List.of(extract)));

        assertThat(response.compared()).isZero();
        assertThat(response.missingLegacy()).isEqualTo(1);
        assertThat(response.missingLegacyKeys()).containsExactly("ALL-1");
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
