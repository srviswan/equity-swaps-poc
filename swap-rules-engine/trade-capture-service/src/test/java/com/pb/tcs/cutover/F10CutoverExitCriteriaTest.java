package com.pb.tcs.cutover;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.api.TradeApi;
import com.pb.tcs.archive.ArchivePartitionService;
import com.pb.tcs.archive.InMemoryArchiveRunStore;
import com.pb.tcs.config.CutoverPolicyConfig;
import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.dispatch.DispatchExecutor;
import com.pb.tcs.dispatch.DispatchMetrics;
import com.pb.tcs.dispatch.DispatchPlanner;
import com.pb.tcs.dispatch.DispatchStatus;
import com.pb.tcs.dispatch.IngestionDispatchStatus;
import com.pb.tcs.dispatch.StubDownstreamPublisher;
import com.pb.tcs.dispatch.InMemoryDispatchRecordStore;
import com.pb.tcs.dispatch.InMemoryIngestionDispatchStatusUpdater;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.lookup.InMemoryArchivedTradeIndex;
import com.pb.tcs.lookup.InMemoryHotTradeIndex;
import com.pb.tcs.lookup.StubSystemAFallbackClient;
import com.pb.tcs.lookup.TradeJourneyService;
import com.pb.tcs.lookup.TradeLookupService;
import com.pb.tcs.lookup.TradeResendService;
import com.pb.tcs.lookup.TradeSearchQuery;
import com.pb.tcs.lookup.TradeSummary;
import com.pb.tcs.persistence.InMemoryApprovalStore;
import com.pb.tcs.persistence.InMemoryIngestionLifecycleStore;
import com.pb.tcs.repair.InMemoryBlotterStore;
import com.pb.tcs.repair.InMemoryRepairStore;
import com.pb.tcs.rules.BlotterAssembler;
import com.pb.tcs.rules.F3Fixtures;
import com.pb.tcs.rules.RuleSetLoader;
import com.pb.tcs.routing.RoutingEngine;
import com.pb.tcs.routing.RoutingStage;
import com.pb.tcs.routing.StubPositionService;
import com.pb.tcs.crossref.InMemoryCrossRefStore;
import com.pb.tcs.dispatch.InMemoryBusinessAckStore;
import com.pb.tcs.dispatch.InMemoryRoutingDecisionStore;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * F10 exit criteria (FR-600–603 / FR-605):
 *
 * <ul>
 *   <li>Shadow mode: full pipeline, no downstream publish, {@code SHADOW_COMPLETE} status.
 *   <li>Dual-publish flags per book/target when shadow is off.
 *   <li>Lookup fall-through hot → archive → System A.
 *   <li>Trade journey reconstructs persisted artifacts (FR-603).
 *   <li>Resend is idempotent when envelope unchanged (FR-601).
 *   <li>Archive partition switch moves rows out of hot index (FR-602).
 * </ul>
 */
class F10CutoverExitCriteriaTest {

    private static final Instant NOW = Instant.parse("2026-06-10T21:00:00Z");
    private static final UUID INGESTION_ID = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-ffffffffffff");

    private CutoverPolicy shadowPolicy;
    private CutoverPolicy liveUsDualPolicy;
    private InMemoryDispatchRecordStore dispatchStore;
    private InMemoryBlotterStore blotterStore;
    private InMemoryRoutingDecisionStore routingStore;
    private InMemoryIngestionDispatchStatusUpdater ingestionStatus;
    private StubDownstreamPublisher publisher;
    private DispatchExecutor shadowExecutor;
    private DispatchPlanner shadowPlanner;
    private InMemoryIngestionLifecycleStore lifecycle;
    private InMemoryHotTradeIndex hotIndex;
    private InMemoryArchivedTradeIndex archiveIndex;
    private StubSystemAFallbackClient systemA;
    private TradeApi tradeApi;

    @BeforeEach
    void setUp() {
        shadowPolicy = new CutoverPolicy(TcsConfigLoader.cutoverPolicy());
        liveUsDualPolicy =
                new CutoverPolicy(
                        new CutoverPolicyConfig(
                                false,
                                java.util.Map.of(
                                        "EQ_US_HY",
                                        java.util.Map.of("SYSTEM_A", true, "SYSTEM_B", true)),
                                TcsConfigLoader.cutoverPolicy().dualPublishDefault(),
                                TcsConfigLoader.cutoverPolicy().archive()));

        dispatchStore = new InMemoryDispatchRecordStore();
        blotterStore = new InMemoryBlotterStore();
        routingStore = new InMemoryRoutingDecisionStore();
        ingestionStatus = new InMemoryIngestionDispatchStatusUpdater();
        publisher = new StubDownstreamPublisher();
        lifecycle = new InMemoryIngestionLifecycleStore();
        hotIndex = new InMemoryHotTradeIndex();
        archiveIndex = new InMemoryArchivedTradeIndex();
        systemA = new StubSystemAFallbackClient();

        shadowExecutor =
                new DispatchExecutor(
                        dispatchStore,
                        blotterStore,
                        routingStore,
                        publisher,
                        TcsConfigLoader.routingRules(),
                        ingestionStatus,
                        new DispatchMetrics(new SimpleMeterRegistry()),
                        Clock.fixed(NOW, ZoneOffset.UTC),
                        shadowPolicy);
        shadowPlanner = new DispatchPlanner(dispatchStore, ingestionStatus, shadowPolicy);

        var lookupService = new TradeLookupService(hotIndex, archiveIndex, systemA);
        var journeyService =
                new TradeJourneyService(
                        lifecycle,
                        blotterStore,
                        routingStore,
                        dispatchStore,
                        new InMemoryBusinessAckStore(),
                        new InMemoryCrossRefStore(),
                        new InMemoryApprovalStore());
        var resendService =
                new TradeResendService(
                        dispatchStore,
                        blotterStore,
                        routingStore,
                        publisher,
                        CutoverPolicy.liveAll(),
                        Clock.fixed(NOW, ZoneOffset.UTC));
        var archiveService =
                new ArchivePartitionService(
                        new InMemoryArchiveRunStore(),
                        archiveIndex,
                        hotIndex,
                        shadowPolicy,
                        Clock.fixed(NOW, ZoneOffset.UTC));
        tradeApi = new TradeApi(lookupService, journeyService, resendService, archiveService);
    }

    @Test
    void shadowModeSkipsPublishAndMarksShadowComplete() throws Exception {
        routeAndPlan(F3Fixtures.usNyseSwap("BLK-SH", 1, "2026-06-10"), INGESTION_ID);

        shadowExecutor.poll(10);
        shadowExecutor.awaitCompletion();

        assertThat(publisher.published()).isEmpty();
        assertThat(dispatchStore.findByIngestionId(INGESTION_ID))
                .allMatch(r -> r.status() == DispatchStatus.SHADOW_SKIPPED);
        assertThat(ingestionStatus.current("BLK-SH/ALL-1/1"))
                .isEqualTo(IngestionDispatchStatus.SHADOW_COMPLETE);
    }

    @Test
    void dualPublishLiveModeFansOutEnabledTargets() throws Exception {
        EnrichedAllocation allocation = F3Fixtures.usNyseSwap("BLK-AP", 1, "2026-06-10");
        routeAndPlan(allocation, INGESTION_ID, liveUsDualPolicy);

        DispatchExecutor liveExecutor =
                new DispatchExecutor(
                        dispatchStore,
                        blotterStore,
                        routingStore,
                        publisher,
                        TcsConfigLoader.routingRules(),
                        ingestionStatus,
                        new DispatchMetrics(new SimpleMeterRegistry()),
                        Clock.fixed(NOW, ZoneOffset.UTC),
                        liveUsDualPolicy);
        liveExecutor.poll(10);
        liveExecutor.awaitCompletion();

        assertThat(publisher.publishedDestinations()).containsExactlyInAnyOrder("SYSTEM_A", "SYSTEM_B");
        assertThat(dispatchStore.findByIngestionId(INGESTION_ID)).hasSize(2);
    }

    @Test
    void dualPublishUsHyCreatesNoDispatchWhenBothDisabled() {
        var cfg = TcsConfigLoader.cutoverPolicy();
        CutoverPolicy liveDefault =
                new CutoverPolicy(
                        new CutoverPolicyConfig(
                                false, cfg.dualPublishByBook(), cfg.dualPublishDefault(), cfg.archive()));
        routeAndPlan(
                F3Fixtures.usNyseSwap("BLK-US", 1, "2026-06-10"), INGESTION_ID, liveDefault);

        assertThat(dispatchStore.findByIngestionId(INGESTION_ID)).isEmpty();
    }

    @Test
    void lookupFallsThroughHotArchiveThenSystemA() {
        UUID hotId = UUID.randomUUID();
        hotIndex.put(
                summary(hotId, "ALL-HOT", "BLK-HOT", LocalDate.of(2026, 6, 10), TradeSummary.LookupTier.HOT));

        UUID archivedId = UUID.randomUUID();
        archiveIndex.archive(
                summary(
                        archivedId,
                        "ALL-ARC",
                        "BLK-ARC",
                        LocalDate.of(2026, 3, 1),
                        TradeSummary.LookupTier.ARCHIVE));

        systemA.seed(
                summary(
                        UUID.randomUUID(),
                        "ALL-SA",
                        "BLK-SA",
                        LocalDate.of(2025, 1, 1),
                        TradeSummary.LookupTier.SYSTEM_A));

        assertThat(tradeApi.search("ALL-HOT", null, null, null, null, null, null))
                .extracting(TradeApi.TradeSummaryView::allocationId)
                .containsExactly("ALL-HOT");
        assertThat(tradeApi.search("ALL-ARC", null, null, null, null, null, null))
                .extracting(TradeApi.TradeSummaryView::tier)
                .containsExactly("ARCHIVE");
        assertThat(tradeApi.search("ALL-SA", null, null, null, null, null, null))
                .extracting(TradeApi.TradeSummaryView::tier)
                .containsExactly("SYSTEM_A");
    }

    @Test
    void journeyReconstructsTradeArtifacts() {
        EnrichedAllocation allocation = F3Fixtures.usNyseSwap("BLK-JR", 1, "2026-06-10");
        lifecycle.persistEnrichedAndReturnId(allocation);
        BlotterAssembler assembler =
                new BlotterAssembler(F3Fixtures.goldenRules());
        var assembly = assembler.assemble(allocation);
        blotterStore.save(assembly.blotter(), assembly.explains());
        RoutingStage routingStage =
                new RoutingStage(
                        new RoutingEngine(TcsConfigLoader.routingRules()),
                        new com.pb.tcs.routing.MatchKeyBuilder(TcsConfigLoader.positionMatchKey()),
                        new StubPositionService(),
                        routingStore,
                        new InMemoryRepairStore());
        var routed = (RoutingStage.Outcome.Routed) routingStage.process(allocation, assembly.blotter());
        routingStore.saveAll(routed.decisions());
        UUID ingestionId = lifecycle.lastId();
        dispatchStore.createPending(
                ingestionId, assembly.blotter().correlationId(), List.of("SYSTEM_A"));

        var journey = tradeApi.journey(ingestionId).orElseThrow();
        assertThat(journey.explainCount()).isPositive();
        assertThat(journey.routingCount()).isEqualTo(2);
        assertThat(journey.dispatchCount()).isEqualTo(1);
        assertThat(journey.blotterJson()).isNotBlank();
    }

    @Test
    void resendIsIdempotentForUnchangedEnvelope() throws Exception {
        EnrichedAllocation allocation = F3Fixtures.usNyseSwap("BLK-RS", 1, "2026-06-10");
        UUID id = UUID.randomUUID();
        routeAndPlan(allocation, id, CutoverPolicy.liveAll());

        DispatchExecutor liveExecutor =
                new DispatchExecutor(
                        dispatchStore,
                        blotterStore,
                        routingStore,
                        publisher,
                        TcsConfigLoader.routingRules(),
                        ingestionStatus,
                        new DispatchMetrics(new SimpleMeterRegistry()),
                        Clock.fixed(NOW, ZoneOffset.UTC),
                        CutoverPolicy.liveAll());
        liveExecutor.poll(10);
        liveExecutor.awaitCompletion();

        int publishedBefore = publisher.published().size();
        TradeApi.TradeResendView first =
                tradeApi.resend(id, "BLK-RS/ALL-1/1", "EQ_US_HY", "SYSTEM_A");
        TradeApi.TradeResendView second =
                tradeApi.resend(id, "BLK-RS/ALL-1/1", "EQ_US_HY", "SYSTEM_A");

        assertThat(first.outcome()).isEqualTo("IDEMPOTENT");
        assertThat(second.outcome()).isEqualTo("IDEMPOTENT");
        assertThat(publisher.published()).hasSize(publishedBefore);
    }

    @Test
    void archivePartitionSwitchMovesHotRows() {
        UUID id = UUID.randomUUID();
        hotIndex.put(
                summary(id, "ALL-OLD", "BLK-OLD", LocalDate.of(2026, 3, 15), TradeSummary.LookupTier.HOT));

        TradeApi.ArchiveRunView result = tradeApi.archivePartition(LocalDate.of(2026, 3, 1));

        assertThat(result.success()).isTrue();
        assertThat(result.rowsArchived()).isEqualTo(1);
        assertThat(hotIndex.findByIngestionId(id)).isEmpty();
        assertThat(archiveIndex.findByIngestionId(id)).isPresent();
    }

    private void routeAndPlan(EnrichedAllocation allocation, UUID ingestionId) {
        routeAndPlan(allocation, ingestionId, shadowPolicy);
    }

    private void routeAndPlan(EnrichedAllocation allocation, UUID ingestionId, CutoverPolicy policy) {
        BlotterAssembler assembler =
                new BlotterAssembler(F3Fixtures.goldenRules());
        var assembly = assembler.assemble(allocation);
        blotterStore.save(assembly.blotter(), assembly.explains());
        RoutingStage routingStage =
                new RoutingStage(
                        new RoutingEngine(TcsConfigLoader.routingRules()),
                        new com.pb.tcs.routing.MatchKeyBuilder(TcsConfigLoader.positionMatchKey()),
                        new StubPositionService(),
                        routingStore,
                        new InMemoryRepairStore());
        var routed = (RoutingStage.Outcome.Routed) routingStage.process(allocation, assembly.blotter());
        routingStore.saveAll(routed.decisions());
        new DispatchPlanner(dispatchStore, ingestionStatus, policy)
                .plan(ingestionId, assembly.blotter().correlationId(), assembly.blotter().book(), routed.decisions());
    }

    private static TradeSummary summary(
            UUID id, String allocationId, String blockId, LocalDate tradeDate, TradeSummary.LookupTier tier) {
        return new TradeSummary(
                id,
                blockId + "/" + allocationId + "/1",
                blockId,
                allocationId,
                1,
                tier == TradeSummary.LookupTier.SYSTEM_A ? "EQ_EU" : "EQ_US_HY",
                "CLI-9",
                null,
                tradeDate,
                "SENT",
                tier);
    }
}
