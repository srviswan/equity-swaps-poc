package com.pb.tcs.recon;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.pb.tcs.api.ReconApi;
import com.pb.tcs.config.ReconPolicyConfig;
import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.crossref.CrossRefRecord;
import com.pb.tcs.crossref.CrossRefStatus;
import com.pb.tcs.parity.ParityFieldComparator;
import com.pb.tcs.routing.EventTypeDeriver;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * F12 exit criteria (FR-700–708):
 *
 * <ul>
 *   <li>R3 cross-system sync detects missing peer refs and lot drift.
 *   <li>R2 instruction-vs-booking detects qty drift (never auto-healed).
 *   <li>R1 ingestion completeness flags GCAM-only allocations.
 *   <li>In-flight horizon suppresses false breaks (FR-706).
 *   <li>Re-runs are idempotent per (type, scope, as-of) (FR-707).
 *   <li>Auto-healed breaks close as RESOLVED_AUTO when absent on re-run (FR-705).
 *   <li>Aging escalation alerts fire on stale breaks (FR-707).
 * </ul>
 */
class F12ReconExitCriteriaTest {

    private static final Instant AS_OF = Instant.parse("2026-06-10T21:00:00Z");
    private static final LocalDate TRADE_DATE = LocalDate.parse("2026-06-10");
    private static final ReconScope SCOPE = new ReconScope("EQ_US_HY", TRADE_DATE);
    private static final UUID INGESTION_ID = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-ffffffffffff");

    private ReconPolicyConfig policy;
    private InMemoryReconStore store;
    private InMemoryReconSnapshotLoader loader;
    private ReconService reconService;
    private ReconApi api;
    private Clock clock;

    @BeforeEach
    void setUp() {
        policy = TcsConfigLoader.reconPolicy();
        store = new InMemoryReconStore();
        loader = new InMemoryReconSnapshotLoader();
        clock = Clock.fixed(AS_OF, ZoneOffset.UTC);
        reconService =
                new ReconService(
                        store,
                        loader,
                        policy,
                        new ParityFieldComparator(TcsConfigLoader.parityManifest()),
                        new ReconMetrics(new SimpleMeterRegistry()),
                        clock);
        api =
                new ReconApi(
                        reconService,
                        new BreakWorkflowService(
                                store,
                                policy,
                                new NoOpAutoHealDispatcher(),
                                clock));
    }

    @Test
    void r3DetectsMissingPeerRefAsAutoHealEligible() {
        seedCrossRef("SYSTEM_A", "SYSTEM_B", "SWAP-R3-1", "[\"LOT-1\"]");
        loader.addSystemA(record(ReconRecord.ReconSource.SYSTEM_A, "ALL-R3-1", "SWAP-R3-1", "LOT-1", 1000L));

        ReconApi.ReconRunResponse run =
                api.startRun(new ReconApi.ReconRunRequest(ReconType.R3, "EQ_US_HY", TRADE_DATE, AS_OF));

        assertThat(run.breaksDetected()).isEqualTo(1);
        ReconApi.ReconBreakView breakRow = api.getBreaks(run.runId()).getFirst();
        assertThat(breakRow.breakType()).isEqualTo("MISSING_IN_B");
        assertThat(breakRow.autoHealEligible()).isTrue();
    }

    @Test
    void r3DetectsLotMismatchAfterUnwind() {
        seedCrossRef("SYSTEM_A", "SYSTEM_B", "SWAP-R3-2", "[\"LOT-A\"]");
        loader.addSystemA(record(ReconRecord.ReconSource.SYSTEM_A, "ALL-R3-2", "SWAP-R3-2", "LOT-A", 500L));
        loader.addSystemB(record(ReconRecord.ReconSource.SYSTEM_B, "ALL-R3-2", "SWAP-R3-2", "LOT-B", 500L));

        ReconApi.ReconRunResponse run =
                api.startRun(new ReconApi.ReconRunRequest(ReconType.R3, "EQ_US_HY", TRADE_DATE, AS_OF));

        assertThat(api.getBreaks(run.runId()))
                .anySatisfy(b -> assertThat(b.breakType()).isEqualTo("LOT_MISMATCH"));
    }

    @Test
    void r2DetectsQtyDriftWithoutAutoHeal() {
        loader.addTcs(record(ReconRecord.ReconSource.TCS, "ALL-R2-1", "SWAP-R2-1", null, 1000L));
        loader.addSystemA(record(ReconRecord.ReconSource.SYSTEM_A, "ALL-R2-1", "SWAP-R2-1", null, 900L));
        loader.addSystemB(record(ReconRecord.ReconSource.SYSTEM_B, "ALL-R2-1", "SWAP-R2-1", null, 1000L));

        ReconApi.ReconRunResponse run =
                api.startRun(new ReconApi.ReconRunRequest(ReconType.R2, "EQ_US_HY", TRADE_DATE, AS_OF));

        assertThat(api.getBreaks(run.runId()))
                .anySatisfy(
                        b -> {
                            assertThat(b.breakType()).isEqualTo("QTY_MISMATCH");
                            assertThat(b.autoHealEligible()).isFalse();
                        });
        ReconApi.ReconBreakView qtyBreak =
                api.getBreaks(run.runId()).stream()
                        .filter(b -> "QTY_MISMATCH".equals(b.breakType()))
                        .findFirst()
                        .orElseThrow();
        assertThatThrownBy(
                        () ->
                                api.heal(
                                        qtyBreak.breakId(),
                                        new ReconApi.AutoHealRequest(
                                                INGESTION_ID, "corr/ALL-R2-1/1", "EQ_US_HY")))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void r1FlagsGcamAllocationMissingInTcs() {
        loader.addGcam(record(ReconRecord.ReconSource.GCAM, "ALL-R1-MISS", null, null, 250L));

        ReconApi.ReconRunResponse run =
                api.startRun(new ReconApi.ReconRunRequest(ReconType.R1, "EQ_US_HY", TRADE_DATE, AS_OF));

        assertThat(api.getBreaks(run.runId()))
                .singleElement()
                .satisfies(
                        b -> {
                            assertThat(b.breakType()).isEqualTo("MISSING_IN_TCS");
                            assertThat(b.allocationId()).isEqualTo("ALL-R1-MISS");
                        });
    }

    @Test
    void inFlightTradeWithinHorizonProducesNoBreak() {
        Instant recent = AS_OF.minusSeconds(60);
        loader.addTcs(
                new ReconRecord(
                        ReconRecord.ReconSource.TCS,
                        "ALL-INFLIGHT",
                        "SWAP-IF",
                        null,
                        "EQ_US_HY",
                        null,
                        null,
                        TRADE_DATE,
                        null,
                        100L,
                        "BOOKED",
                        Map.of(),
                        recent));
        loader.addSystemA(
                new ReconRecord(
                        ReconRecord.ReconSource.SYSTEM_A,
                        "ALL-INFLIGHT",
                        "SWAP-IF",
                        null,
                        "EQ_US_HY",
                        null,
                        null,
                        TRADE_DATE,
                        null,
                        100L,
                        "BOOKED",
                        Map.of(),
                        recent));

        ReconApi.ReconRunResponse run =
                api.startRun(new ReconApi.ReconRunRequest(ReconType.R2, "EQ_US_HY", TRADE_DATE, AS_OF));

        assertThat(run.breaksDetected()).isZero();
        assertThat(run.tcsWatermark()).isEqualTo(recent);
    }

    @Test
    void completedRunIsIdempotentForSameTypeScopeAndAsOf() {
        loader.addGcam(record(ReconRecord.ReconSource.GCAM, "ALL-R1-IDEM", null, null, 100L));

        ReconApi.ReconRunRequest request =
                new ReconApi.ReconRunRequest(ReconType.R1, "EQ_US_HY", TRADE_DATE, AS_OF);
        ReconApi.ReconRunResponse first = api.startRun(request);
        ReconApi.ReconRunResponse second = api.startRun(request);

        assertThat(second.runId()).isEqualTo(first.runId());
        assertThat(second.breaksDetected()).isEqualTo(first.breaksDetected());
    }

    @Test
    void healingBreakAutoResolvesWhenNextRunNoLongerDetectsIt() {
        ReconBreak healing =
                store.saveBreak(
                        ReconBreak.detected(
                                0,
                                99,
                                ReconType.R3,
                                BreakType.MISSING_IN_B,
                                "ALL-HEAL",
                                "SWAP-HEAL",
                                "LOT-1",
                                "expected",
                                null,
                                true,
                                AS_OF.minusSeconds(3600)));
        store.updateBreak(healing.withStatus(BreakStatus.HEALING, "cross_ref_sync", "auto-heal", AS_OF));

        seedCrossRef("SYSTEM_A", "SYSTEM_B", "SWAP-HEAL", "[\"LOT-1\"]");
        loader.addSystemA(record(ReconRecord.ReconSource.SYSTEM_A, "ALL-HEAL", "SWAP-HEAL", "LOT-1", 100L, "DELIVERED"));
        loader.addSystemB(record(ReconRecord.ReconSource.SYSTEM_B, "ALL-HEAL", "SWAP-HEAL", "LOT-1", 100L, "DELIVERED"));

        api.startRun(new ReconApi.ReconRunRequest(ReconType.R3, "EQ_US_HY", TRADE_DATE, AS_OF));

        assertThat(store.findBreakById(healing.breakId()).orElseThrow().status())
                .isEqualTo(BreakStatus.RESOLVED_AUTO);
    }

    @Test
    void agingAlertFiresWhenBreakOlderThanEscalationThreshold() {
        ReconBreak stale =
                store.saveBreak(
                        ReconBreak.detected(
                                0,
                                1,
                                ReconType.R2,
                                BreakType.QTY_MISMATCH,
                                "ALL-AGE",
                                "SWAP-AGE",
                                null,
                                "1000",
                                "900",
                                false,
                                AS_OF.minusSeconds(49 * 3600L)));

        List<ReconApi.AgingAlertView> alerts = api.agingAlerts();

        assertThat(alerts).anySatisfy(a -> assertThat(a.breakId()).isEqualTo(stale.breakId()));
        assertThat(alerts).anySatisfy(a -> assertThat(a.escalationHours()).isEqualTo(24));
    }

    private void seedCrossRef(String from, String to, String swapRef, String lotRefsJson) {
        String allocationId = swapRef.replace("SWAP-", "ALL-");
        loader.addCrossRef(
                new CrossRefRecord(
                        1,
                        INGESTION_ID,
                        "corr/" + allocationId + "/1",
                        from,
                        to,
                        swapRef,
                        lotRefsJson,
                        EventTypeDeriver.EventType.NEW,
                        CrossRefStatus.DELIVERED,
                        0,
                        Instant.EPOCH,
                        null,
                        AS_OF.minusSeconds(7200)));
    }

    private static ReconRecord record(
            ReconRecord.ReconSource source,
            String allocationId,
            String swapRef,
            String lotRef,
            Long quantity) {
        return record(source, allocationId, swapRef, lotRef, quantity, "BOOKED");
    }

    private static ReconRecord record(
            ReconRecord.ReconSource source,
            String allocationId,
            String swapRef,
            String lotRef,
            Long quantity,
            String status) {
        return new ReconRecord(
                source,
                allocationId,
                swapRef,
                lotRef,
                "EQ_US_HY",
                null,
                "SEC-1",
                TRADE_DATE,
                "BUY",
                quantity,
                status,
                Map.of("quantity", String.valueOf(quantity)),
                AS_OF.minusSeconds(7200));
    }

    /** Test double — records heal intent without wiring full cross-ref stack. */
    private static final class NoOpAutoHealDispatcher extends AutoHealDispatcher {
        NoOpAutoHealDispatcher() {
            super(null, null);
        }

        @Override
        public HealResult heal(ReconBreak breakRow, UUID ingestionId, String correlationId, String book) {
            if (!breakRow.autoHealEligible()) {
                return HealResult.rejected("not_auto_heal_eligible");
            }
            return HealResult.started("test-heal");
        }
    }
}
