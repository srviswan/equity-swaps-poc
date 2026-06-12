package com.pb.tcs.boot;

import com.pb.tcs.approval.ApprovalGateStage;
import com.pb.tcs.crossref.CrossRefExecutor;
import com.pb.tcs.dispatch.BusinessAckHandler;
import com.pb.tcs.dispatch.BusinessAckMessage;
import com.pb.tcs.dispatch.DispatchExecutor;
import com.pb.tcs.dispatch.DispatchPlanner;
import com.pb.tcs.dispatch.DispatchRecord;
import com.pb.tcs.dispatch.DispatchStatus;
import com.pb.tcs.dispatch.InMemoryDispatchRecordStore;
import com.pb.tcs.dispatch.InMemoryIngestionDispatchStatusUpdater;
import com.pb.tcs.dispatch.InMemoryRoutingDecisionStore;
import com.pb.tcs.dispatch.StubDownstreamPublisher;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.ingress.IngressPipeline;
import com.pb.tcs.ingress.PipelineResult;
import com.pb.tcs.ingress.TradeCaptureProcessor;
import com.pb.tcs.lookup.InMemoryHotTradeIndex;
import com.pb.tcs.lookup.TradeSummary;
import com.pb.tcs.persistence.InMemoryIngestionLifecycleStore;
import com.pb.tcs.pipeline.TradeProcessingPipeline;
import com.pb.tcs.repair.InMemoryBlotterStore;
import com.pb.tcs.routing.RoutingStage;
import com.pb.tcs.rules.BlotterJson;
import com.pb.tcs.rules.F3Fixtures;
import com.pb.tcs.rules.SwapBlotter;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/** Runs a GCAM allocation through ingress → rules → gate → validation → route → dispatch → ACK. */
@Service
public class DemoTradeOrchestrator {

    private final DemoTradeStatusStore statusStore;
    private final TradeCaptureProcessor.LifecycleIngestionStore lifecycleBridge;
    private final IngressPipeline ingressPipeline;
    private final TradeProcessingPipeline tradePipeline;
    private final RoutingStage routingStage;
    private final InMemoryBlotterStore blotterStore;
    private final InMemoryRoutingDecisionStore routingStore;
    private final InMemoryDispatchRecordStore dispatchStore;
    private final InMemoryIngestionDispatchStatusUpdater ingestionStatus;
    private final StubDownstreamPublisher publisher;
    private final DispatchExecutor dispatchExecutor;
    private final DispatchPlanner dispatchPlanner;
    private final BusinessAckHandler ackHandler;
    private final CrossRefExecutor crossRefExecutor;
    private final InMemoryHotTradeIndex hotTradeIndex;

    DemoTradeOrchestrator(
            DemoTradeStatusStore statusStore,
            TradeCaptureProcessor.LifecycleIngestionStore lifecycleBridge,
            IngressPipeline ingressPipeline,
            TradeProcessingPipeline tradePipeline,
            RoutingStage routingStage,
            InMemoryBlotterStore blotterStore,
            InMemoryRoutingDecisionStore routingStore,
            InMemoryDispatchRecordStore dispatchStore,
            InMemoryIngestionDispatchStatusUpdater ingestionStatus,
            StubDownstreamPublisher publisher,
            DispatchExecutor demoRunDispatchExecutor,
            DispatchPlanner demoRunDispatchPlanner,
            BusinessAckHandler ackHandler,
            CrossRefExecutor crossRefExecutor,
            InMemoryHotTradeIndex hotTradeIndex) {
        this.statusStore = statusStore;
        this.lifecycleBridge = lifecycleBridge;
        this.ingressPipeline = ingressPipeline;
        this.tradePipeline = tradePipeline;
        this.routingStage = routingStage;
        this.blotterStore = blotterStore;
        this.routingStore = routingStore;
        this.dispatchStore = dispatchStore;
        this.ingestionStatus = ingestionStatus;
        this.publisher = publisher;
        this.dispatchExecutor = demoRunDispatchExecutor;
        this.dispatchPlanner = demoRunDispatchPlanner;
        this.ackHandler = ackHandler;
        this.crossRefExecutor = crossRefExecutor;
        this.hotTradeIndex = hotTradeIndex;
    }

    public RunResult run(String blockId, String tradeDate) {
        statusStore.emit(blockId, "INGRESS", "GCAM allocation received — block " + blockId);

        EnrichedAllocation allocation = F3Fixtures.usNyseSwap(blockId, 1, tradeDate);
        byte[] raw = allocation.envelope().toByteArray();
        TradeCaptureProcessor processor =
                new TradeCaptureProcessor(ingressPipeline, tradePipeline, lifecycleBridge);

        PipelineResult ingress = processor.process(raw, 1);
        UUID ingestionId = lifecycleBridge.lastId();
        if (ingestionId == null) {
            statusStore.emit(blockId, "FAILED", ingress.disposition().name() + " — " + ingress.detail());
            throw new IllegalStateException("ingress failed: " + ingress.disposition());
        }

        statusStore.emit(
                blockId, "ENRICH", ingress.disposition().name() + " — ingestionId " + ingestionId);

        if (ingress.disposition() != PipelineResult.Disposition.BLOTTER_READY) {
            return finished(blockId, ingestionId, ingress.disposition().name(), false);
        }

        SwapBlotter blotter =
                blotterStore
                        .findBlotterJson(allocation.correlationId())
                        .map(BlotterJson::fromJson)
                        .orElseThrow();
        statusStore.emit(blockId, "RULES", "blotter ready — " + blotter.correlationId());

        RoutingStage.Outcome outcome = routingStage.process(allocation, blotter);
        if (outcome instanceof RoutingStage.Outcome.Quarantined q) {
            statusStore.emit(blockId, "FAILED", "routing quarantine " + q.quarantineId() + ": " + q.reason());
            return finished(blockId, ingestionId, "QUARANTINED", false);
        }
        var routed = (RoutingStage.Outcome.Routed) outcome;
        routingStore.saveAll(routed.decisions());
        statusStore.emit(
                blockId,
                "ROUTING",
                routed.decisions().stream()
                        .map(d -> d.targetId() + " / " + d.eventType())
                        .reduce((a, b) -> a + ", " + b)
                        .orElse("none"));

        dispatchPlanner.plan(ingestionId, blotter.correlationId(), blotter.book(), routed.decisions());
        statusStore.emit(
                blockId, "DISPATCH", "planned — queue status " + ingestionStatus.current(blotter.correlationId()).name());

        try {
            dispatchExecutor.poll(20);
            dispatchExecutor.awaitCompletion();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("dispatch interrupted", e);
        }

        for (DispatchRecord record : dispatchStore.findByIngestionId(ingestionId)) {
            statusStore.emit(
                    blockId,
                    "DISPATCH",
                    record.destinationId() + " → " + record.status());
            if (record.status() == DispatchStatus.SENT) {
                ackHandler.handle(
                        new BusinessAckMessage(
                                blotter.blockId(),
                                blotter.allocationId(),
                                blotter.version(),
                                record.destinationId(),
                                "BOOKED",
                                "SWAP-" + blockId + "-" + record.destinationId(),
                                List.of(new BusinessAckMessage.LotRef("LOT-1", "OPENED", 1000L)),
                                null,
                                Instant.now(),
                                "{\"status\":\"BOOKED\"}"));
                statusStore.emit(blockId, "BUSINESS_ACK", record.destinationId() + " BOOKED");
            }
        }

        crossRefExecutor.poll(10);
        statusStore.emit(blockId, "CROSS_REF", "cross-ref delivery polled");

        String dispatchStatus = ingestionStatus.current(blotter.correlationId()).name();
        hotTradeIndex.put(
                new TradeSummary(
                        ingestionId,
                        blotter.correlationId(),
                        blotter.blockId(),
                        blotter.allocationId(),
                        blotter.version(),
                        blotter.book(),
                        blotter.accountId(),
                        null,
                        LocalDate.parse(tradeDate),
                        dispatchStatus,
                        TradeSummary.LookupTier.HOT));

        statusStore.emit(blockId, "COMPLETE", "final status " + dispatchStatus);
        return finished(blockId, ingestionId, dispatchStatus, !publisher.published().isEmpty());
    }

    private RunResult finished(
            String blockId, UUID ingestionId, String finalStatus, boolean published) {
        return new RunResult(
                blockId,
                ingestionId,
                finalStatus,
                published,
                publisher.publishedDestinations(),
                statusStore.timeline(blockId));
    }

    public record RunResult(
            String blockId,
            UUID ingestionId,
            String finalStatus,
            boolean downstreamPublished,
            List<String> publishedTargets,
            List<DemoTradeStatusStore.StatusEvent> timeline) {}
}
