package com.pb.tcs.crossref;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.api.CrossRefApi;
import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.dispatch.BusinessAckHandler;
import com.pb.tcs.dispatch.BusinessAckMessage;
import com.pb.tcs.dispatch.BusinessAckMetrics;
import com.pb.tcs.dispatch.DispatchExecutor;
import com.pb.tcs.dispatch.DispatchMetrics;
import com.pb.tcs.dispatch.DispatchPlanner;
import com.pb.tcs.dispatch.DispatchStatus;
import com.pb.tcs.dispatch.InMemoryBusinessAckStore;
import com.pb.tcs.dispatch.InMemoryDispatchRecordStore;
import com.pb.tcs.dispatch.InMemoryIngestionDispatchStatusUpdater;
import com.pb.tcs.dispatch.InMemoryRoutingDecisionStore;
import com.pb.tcs.dispatch.StubDownstreamPublisher;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.repair.InMemoryBlotterStore;
import com.pb.tcs.repair.InMemoryRepairStore;
import com.pb.tcs.routing.EventTypeDeriver;
import com.pb.tcs.routing.MatchKeyBuilder;
import com.pb.tcs.routing.RoutingEngine;
import com.pb.tcs.routing.RoutingStage;
import com.pb.tcs.routing.StubPositionService;
import com.pb.tcs.rules.BlotterAssembler;
import com.pb.tcs.rules.F3Fixtures;
import com.pb.tcs.rules.RuleSetLoader;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * F7 exit criteria (FR-403–406):
 *
 * <ul>
 *   <li>End-to-end UNWIND: A's CLOSED lot IDs delivered to B via cross-ref push (FR-405).
 *   <li>Bidirectional cross-ref rows auditable; poll API returns both directions (FR-404).
 *   <li>Sync re-push is idempotent (FR-601).
 *   <li>Failed delivery retry via ops action (FR-406 backend).
 * </ul>
 */
class F7CrossRefExitCriteriaTest {

    private static final Instant NOW = Instant.parse("2026-06-10T21:00:00Z");
    private static final UUID INGESTION_ID = UUID.fromString("bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb");

    private BlotterAssembler assembler;
    private RoutingStage routingStage;
    private StubPositionService positionService;
    private InMemoryBlotterStore blotterStore;
    private InMemoryRoutingDecisionStore routingStore;
    private InMemoryDispatchRecordStore dispatchStore;
    private InMemoryIngestionDispatchStatusUpdater ingestionStatus;
    private InMemoryBusinessAckStore ackStore;
    private InMemoryRepairStore repairStore;
    private InMemoryCrossRefStore crossRefStore;
    private StubDownstreamPublisher dispatchPublisher;
    private StubCrossRefPublisher crossRefPublisher;
    private DispatchExecutor dispatchExecutor;
    private CrossRefExecutor crossRefExecutor;
    private BusinessAckHandler ackHandler;
    private CrossRefApi crossRefApi;
    private SimpleMeterRegistry meterRegistry;

    @BeforeEach
    void setUp() {
        assembler =
                new BlotterAssembler(F3Fixtures.goldenRules());
        positionService = new StubPositionService();
        routingStore = new InMemoryRoutingDecisionStore();
        blotterStore = new InMemoryBlotterStore();
        dispatchStore = new InMemoryDispatchRecordStore();
        ingestionStatus = new InMemoryIngestionDispatchStatusUpdater();
        ackStore = new InMemoryBusinessAckStore();
        repairStore = new InMemoryRepairStore();
        crossRefStore = new InMemoryCrossRefStore();
        dispatchPublisher = new StubDownstreamPublisher();
        crossRefPublisher = new StubCrossRefPublisher();
        meterRegistry = new SimpleMeterRegistry();

        routingStage =
                new RoutingStage(
                        new RoutingEngine(TcsConfigLoader.routingRules()),
                        new MatchKeyBuilder(TcsConfigLoader.positionMatchKey()),
                        positionService,
                        routingStore,
                        repairStore);

        CrossRefPlanner planner = new CrossRefPlanner(crossRefStore, routingStore);
        crossRefExecutor =
                new CrossRefExecutor(
                        crossRefStore,
                        crossRefPublisher,
                        new CrossRefMetrics(meterRegistry),
                        Clock.fixed(NOW, ZoneOffset.UTC));

        dispatchExecutor =
                new DispatchExecutor(
                        dispatchStore,
                        blotterStore,
                        routingStore,
                        dispatchPublisher,
                        TcsConfigLoader.routingRules(),
                        ingestionStatus,
                        new DispatchMetrics(meterRegistry),
                        Clock.fixed(NOW, ZoneOffset.UTC));

        ackHandler =
                new BusinessAckHandler(
                        dispatchStore,
                        ackStore,
                        blotterStore,
                        repairStore,
                        new BusinessAckMetrics(meterRegistry),
                        planner);

        CrossRefSyncService syncService =
                new CrossRefSyncService(
                        planner,
                        crossRefStore,
                        dispatchStore,
                        ackStore,
                        routingStore,
                        crossRefExecutor);
        CrossRefOpsService opsService = new CrossRefOpsService(crossRefStore, crossRefExecutor);
        crossRefApi =
                new CrossRefApi(new CrossRefQueryService(crossRefStore), syncService, opsService);
    }

    @Test
    void unwindLotDelivery_bidirectionalCrossRefAuditAndPollApi() throws Exception {
        // B sees opposite-direction position → UNWIND (D12)
        positionService.openPosition("SEC-AAPL", -50_000, "OPEN");
        String correlationId = runThroughDispatch("BLK-UNW");

        assertThat(routingStore.findByCorrelationId(correlationId).stream()
                        .filter(d -> "SYSTEM_B".equals(d.targetId()))
                        .findFirst()
                        .orElseThrow()
                        .eventType())
                .isEqualTo(EventTypeDeriver.EventType.UNWIND);

        // A business ACK carries exact CLOSED lot IDs for B's custom-lot unwind (FR-405)
        ackHandler.handle(
                businessAck("BLK-UNW", "SYSTEM_A", "A-SWP-991", List.of(closedLot("A-LOT-1", 25_000))));
        // B business ACK
        ackHandler.handle(
                businessAck("BLK-UNW", "SYSTEM_B", "B-SWP-442", List.of(openedLot("B-LOT-9", 25_000))));

        assertThat(crossRefStore.findByIngestionId(INGESTION_ID)).hasSize(2);

        crossRefExecutor.poll(10);
        crossRefExecutor.awaitCompletion();

        CrossRefPushMessage toB =
                crossRefPublisher.toSystem("SYSTEM_B").stream()
                        .filter(m -> "SYSTEM_A".equals(m.fromSystem()))
                        .findFirst()
                        .orElseThrow();
        assertThat(toB.swapRef()).isEqualTo("A-SWP-991");
        assertThat(toB.eventType()).isEqualTo(EventTypeDeriver.EventType.UNWIND);
        assertThat(toB.lotRefs())
                .singleElement()
                .satisfies(l -> {
                    assertThat(l.lotId()).isEqualTo("A-LOT-1");
                    assertThat(l.action()).isEqualTo("CLOSED");
                    assertThat(l.qty()).isEqualTo(25_000);
                });

        CrossRefPushMessage toA =
                crossRefPublisher.toSystem("SYSTEM_A").stream()
                        .filter(m -> "SYSTEM_B".equals(m.fromSystem()))
                        .findFirst()
                        .orElseThrow();
        assertThat(toA.swapRef()).isEqualTo("B-SWP-442");

        assertThat(crossRefStore.findByIngestionId(INGESTION_ID))
                .allMatch(r -> r.status() == CrossRefStatus.DELIVERED);

        CrossRefApi.CrossRefPollResponse poll =
                crossRefApi.poll(new CrossRefApi.CrossRefPollRequest("ALL-1", null, null));
        assertThat(poll.crossRefs()).hasSize(2);
        assertThat(poll.crossRefs())
                .extracting(CrossRefApi.CrossRefView::fromSystem)
                .containsExactlyInAnyOrder("SYSTEM_A", "SYSTEM_B");

        assertThat(meterRegistry.get("tc.crossref.delivered").tag("to", "SYSTEM_B").counter().count())
                .isEqualTo(1.0);
    }

    @Test
    void singleTargetTradeProducesNoCrossRefRows() throws Exception {
        EnrichedAllocation base = F3Fixtures.usNyseSwap("BLK-EU", 1, "2026-06-10");
        var alloc = base.message().toBuilder().setBook("EQ_EU_HY").build();
        var env = base.envelope().toBuilder().setBook("EQ_EU_HY").setAllocation(alloc).build();
        EnrichedAllocation allocation =
                new EnrichedAllocation(env, env.toByteArray(), "{}", "{}", "{}", null);

        BlotterAssembler.Assembly assembly = assembler.assemble(allocation);
        blotterStore.save(assembly.blotter(), assembly.explains());
        var routed = (RoutingStage.Outcome.Routed) routingStage.process(allocation, assembly.blotter());
        routingStore.saveAll(routed.decisions());
        new DispatchPlanner(dispatchStore, ingestionStatus)
                .plan(INGESTION_ID, assembly.blotter().correlationId(), assembly.blotter().book(), routed.decisions());
        dispatchExecutor.poll(10);
        dispatchExecutor.awaitCompletion();

        ackHandler.handle(
                businessAck("BLK-EU", "SYSTEM_A", "A-SWP-EU", List.of(openedLot("A-LOT-EU", 1000))));
        crossRefExecutor.poll(10);

        assertThat(crossRefStore.findByIngestionId(INGESTION_ID)).isEmpty();
        assertThat(crossRefPublisher.published()).isEmpty();
    }

    @Test
    void syncRepushIsIdempotent() throws Exception {
        positionService.openPosition("SEC-AAPL", -50_000, "OPEN");
        String correlationId = runThroughDispatch("BLK-SYNC");
        ackHandler.handle(
                businessAck("BLK-SYNC", "SYSTEM_A", "A-SWP-1", List.of(closedLot("A-LOT-1", 10_000))));
        ackHandler.handle(
                businessAck("BLK-SYNC", "SYSTEM_B", "B-SWP-1", List.of(openedLot("B-LOT-1", 10_000))));
        crossRefExecutor.poll(10);
        crossRefExecutor.awaitCompletion();
        int firstPublishCount = crossRefPublisher.published().size();

        CrossRefApi.CrossRefSyncResponse first =
                crossRefApi.sync(INGESTION_ID, correlationId);
        CrossRefApi.CrossRefSyncResponse second =
                crossRefApi.sync(INGESTION_ID, correlationId);

        assertThat(first.directionsReset()).isEqualTo(2);
        assertThat(second.directionsReset()).isEqualTo(2);
        assertThat(crossRefPublisher.published()).hasSizeGreaterThan(firstPublishCount);
        assertThat(crossRefStore.findByIngestionId(INGESTION_ID))
                .allMatch(r -> r.status() == CrossRefStatus.DELIVERED);
    }

    @Test
    void failedDelivery_opsManualReconcile() throws Exception {
        positionService.openPosition("SEC-AAPL", -50_000, "OPEN");
        runThroughDispatch("BLK-RETRY");
        crossRefPublisher.markDown("SYSTEM_B");

        ackHandler.handle(
                businessAck("BLK-RETRY", "SYSTEM_A", "A-SWP-R", List.of(closedLot("A-LOT-R", 5_000))));
        ackHandler.handle(
                businessAck("BLK-RETRY", "SYSTEM_B", "B-SWP-R", List.of(openedLot("B-LOT-R", 5_000))));

        crossRefExecutor.poll(10);
        crossRefExecutor.awaitCompletion();

        CrossRefRecord aToB =
                crossRefStore.findDirection(INGESTION_ID, "SYSTEM_A", "SYSTEM_B").orElseThrow();
        assertThat(aToB.status()).isEqualTo(CrossRefStatus.PENDING);
        assertThat(aToB.lastError()).contains("SYSTEM_B unavailable");
        assertThat(crossRefStore.findDirection(INGESTION_ID, "SYSTEM_B", "SYSTEM_A").orElseThrow().status())
                .isEqualTo(CrossRefStatus.DELIVERED);

        crossRefApi.manualReconcile(aToB.crossRefId());
        assertThat(crossRefStore.findDirection(INGESTION_ID, "SYSTEM_A", "SYSTEM_B").orElseThrow().status())
                .isEqualTo(CrossRefStatus.DELIVERED);
    }

    private String runThroughDispatch(String blockId) throws Exception {
        EnrichedAllocation allocation = F3Fixtures.usNyseSwap(blockId, 1, "2026-06-10");
        BlotterAssembler.Assembly assembly = assembler.assemble(allocation);
        blotterStore.save(assembly.blotter(), assembly.explains());
        var routed = (RoutingStage.Outcome.Routed) routingStage.process(allocation, assembly.blotter());
        routingStore.saveAll(routed.decisions());
        new DispatchPlanner(dispatchStore, ingestionStatus)
                .plan(INGESTION_ID, assembly.blotter().correlationId(), assembly.blotter().book(), routed.decisions());
        dispatchExecutor.poll(10);
        dispatchExecutor.awaitCompletion();
        assertThat(dispatchStore.findByCorrelationId(assembly.blotter().correlationId()))
                .allMatch(r -> r.status() == DispatchStatus.SENT);
        return assembly.blotter().correlationId();
    }

    private static BusinessAckMessage businessAck(
            String blockId, String systemId, String swapRef, List<BusinessAckMessage.LotRef> lots) {
        return new BusinessAckMessage(
                blockId, "ALL-1", 1, systemId, "BOOKED", swapRef, lots, null, NOW.plusSeconds(30), "{}");
    }

    private static BusinessAckMessage.LotRef closedLot(String lotId, long qty) {
        return new BusinessAckMessage.LotRef(lotId, "CLOSED", qty);
    }

    private static BusinessAckMessage.LotRef openedLot(String lotId, long qty) {
        return new BusinessAckMessage.LotRef(lotId, "OPENED", qty);
    }
}
