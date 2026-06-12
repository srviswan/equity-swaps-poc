package com.pb.tcs.dispatch;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.repair.InMemoryBlotterStore;
import com.pb.tcs.repair.InMemoryRepairStore;
import com.pb.tcs.rules.BlotterAssembler;
import com.pb.tcs.rules.F3Fixtures;
import com.pb.tcs.rules.RuleSetLoader;
import com.pb.tcs.routing.RoutingEngine;
import com.pb.tcs.routing.RoutingStage;
import com.pb.tcs.routing.StubPositionService;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * F6 exit criteria (FR-400–402):
 *
 * <ul>
 *   <li>Target-down isolation: System B failure does not block System A dispatch (D13).
 *   <li>{@code PARTIALLY_SENT} surfaced when A succeeds and B is retrying/down.
 *   <li>System A business ACK persisted with latency metric (D14 / FR-402).
 * </ul>
 */
class F6DispatchExitCriteriaTest {

    private static final Instant NOW = Instant.parse("2026-06-10T21:00:00Z");
    private static final UUID INGESTION_ID = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee");

    private BlotterAssembler assembler;
    private RoutingStage routingStage;
    private InMemoryBlotterStore blotterStore;
    private InMemoryRoutingDecisionStore routingStore;
    private InMemoryDispatchRecordStore dispatchStore;
    private InMemoryIngestionDispatchStatusUpdater ingestionStatus;
    private InMemoryBusinessAckStore ackStore;
    private InMemoryRepairStore repairStore;
    private StubDownstreamPublisher publisher;
    private DispatchExecutor executor;
    private DispatchPlanner planner;
    private BusinessAckHandler ackHandler;
    private SimpleMeterRegistry meterRegistry;

    @BeforeEach
    void setUp() {
        assembler =
                new BlotterAssembler(RuleSetLoader.fromClasspath("fixtures/rules/f3-golden-rules.yml"));
        routingStore = new InMemoryRoutingDecisionStore();
        blotterStore = new InMemoryBlotterStore();
        dispatchStore = new InMemoryDispatchRecordStore();
        ingestionStatus = new InMemoryIngestionDispatchStatusUpdater();
        ackStore = new InMemoryBusinessAckStore();
        repairStore = new InMemoryRepairStore();
        publisher = new StubDownstreamPublisher();
        meterRegistry = new SimpleMeterRegistry();

        routingStage =
                new RoutingStage(
                        new RoutingEngine(TcsConfigLoader.routingRules()),
                        new com.pb.tcs.routing.MatchKeyBuilder(TcsConfigLoader.positionMatchKey()),
                        new StubPositionService(),
                        routingStore,
                        repairStore);

        planner = new DispatchPlanner(dispatchStore, ingestionStatus);
        executor =
                new DispatchExecutor(
                        dispatchStore,
                        blotterStore,
                        routingStore,
                        publisher,
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
                        new BusinessAckMetrics(meterRegistry));
    }

    @Test
    void targetDownIsolation_partiallySentAndBusinessAck() throws Exception {
        EnrichedAllocation allocation = F3Fixtures.usNyseSwap("BLK-F6", 1, "2026-06-10");
        String correlationId = "BLK-F6/ALL-1/1";

        // stages 4–6: blotter assembled + persisted
        BlotterAssembler.Assembly assembly = assembler.assemble(allocation);
        blotterStore.save(assembly.blotter(), assembly.explains());

        // stage 7: route to A + B
        var routed = (RoutingStage.Outcome.Routed) routingStage.process(allocation, assembly.blotter());
        routingStore.saveAll(routed.decisions());

        // stage 9: plan dispatch records
        planner.plan(INGESTION_ID, correlationId, assembly.blotter().book(), routed.decisions());
        assertThat(ingestionStatus.current(correlationId)).isEqualTo(IngestionDispatchStatus.QUEUED);

        // stage 10: B is down — A must still dispatch (target-down isolation)
        publisher.markDown("SYSTEM_B");
        CountDownLatch bBarrier = new CountDownLatch(1);
        publisher.blockUntil(bBarrier);

        executor.poll(10);
        // while B is blocked on the latch, A should already have published
        Thread.sleep(100);
        assertThat(publisher.aPublished()).isTrue();
        bBarrier.countDown();
        executor.awaitCompletion();

        DispatchRecord a = dispatchStore.findByDestination(correlationId, "SYSTEM_A").orElseThrow();
        DispatchRecord b = dispatchStore.findByDestination(correlationId, "SYSTEM_B").orElseThrow();
        assertThat(a.status()).isEqualTo(DispatchStatus.SENT);
        assertThat(a.envelopeHash()).isNotBlank();
        assertThat(b.status()).isEqualTo(DispatchStatus.PENDING); // retry scheduled
        assertThat(b.attemptCount()).isEqualTo(1);
        assertThat(ingestionStatus.current(correlationId)).isEqualTo(IngestionDispatchStatus.PARTIALLY_SENT);
        assertThat(meterRegistry.get("trade.dispatch.success").tag("destination", "SYSTEM_A").counter().count())
                .isEqualTo(1.0);
        assertThat(meterRegistry.get("trade.dispatch.failure").tag("destination", "SYSTEM_B").counter().count())
                .isEqualTo(1.0);

        // stage 11: System A business ACK (D14 — separate business_ack row)
        ackHandler.handle(
                new BusinessAckMessage(
                        "BLK-F6",
                        "ALL-1",
                        1,
                        "SYSTEM_A",
                        "BOOKED",
                        "A-SWP-991",
                        List.of(new BusinessAckMessage.LotRef("A-LOT-1", "OPENED", 1000)),
                        null,
                        NOW.plusSeconds(30),
                        "{\"status\":\"BOOKED\"}"));

        BusinessAckStore.BusinessAckRecord ack =
                ackStore.findByDispatchId(a.dispatchId()).orElseThrow();
        assertThat(ack.swapRef()).isEqualTo("A-SWP-991");
        assertThat(meterRegistry.get("tc.business_ack.latency").tag("destination", "SYSTEM_A").timer().count())
                .isEqualTo(1);
    }

    @Test
    void businessAckRejected_quarantinesWithoutBlindRetry() {
        String correlationId = prepareSentDispatch("BLK-REJ");

        ackHandler.handle(
                new BusinessAckMessage(
                        "BLK-REJ",
                        "ALL-1",
                        1,
                        "SYSTEM_A",
                        "REJECTED",
                        null,
                        List.of(),
                        "invalid economics",
                        NOW.plusSeconds(5),
                        "{\"status\":\"REJECTED\"}"));

        DispatchRecord record = dispatchStore.findByDestination(correlationId, "SYSTEM_A").orElseThrow();
        assertThat(record.status()).isEqualTo(DispatchStatus.FAILED);
        assertThat(repairStore.openItems("BUSINESS_VALIDATION"))
                .extracting(com.pb.tcs.repair.RepairStore.RepairItem::detail)
                .anyMatch(d -> d.contains("BUSINESS_ACK_REJECTED"));
    }

    @Test
    void allTargetsSent_aggregatesToSent() throws Exception {
        String correlationId = preparePlannedDispatch("BLK-ALL");
        executor.poll(10);
        executor.awaitCompletion();

        assertThat(dispatchStore.findByCorrelationId(correlationId))
                .allMatch(r -> r.status() == DispatchStatus.SENT);
        assertThat(ingestionStatus.current(correlationId)).isEqualTo(IngestionDispatchStatus.SENT);
    }

    private String prepareSentDispatch(String blockId) {
        String correlationId = preparePlannedDispatch(blockId);
        try {
            executor.poll(10);
            executor.awaitCompletion();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return correlationId;
    }

    private String preparePlannedDispatch(String blockId) {
        EnrichedAllocation allocation = F3Fixtures.usNyseSwap(blockId, 1, "2026-06-10");
        BlotterAssembler.Assembly assembly = assembler.assemble(allocation);
        blotterStore.save(assembly.blotter(), assembly.explains());
        var routed = (RoutingStage.Outcome.Routed) routingStage.process(allocation, assembly.blotter());
        routingStore.saveAll(routed.decisions());
        planner.plan(INGESTION_ID, assembly.blotter().correlationId(), assembly.blotter().book(), routed.decisions());
        return assembly.blotter().correlationId();
    }
}
