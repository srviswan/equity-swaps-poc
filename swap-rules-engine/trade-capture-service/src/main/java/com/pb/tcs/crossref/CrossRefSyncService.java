package com.pb.tcs.crossref;

import com.pb.tcs.dispatch.BusinessAckStore;
import com.pb.tcs.dispatch.DispatchRecord;
import com.pb.tcs.dispatch.DispatchRecordStore;
import com.pb.tcs.routing.RoutingDecision;
import com.pb.tcs.routing.RoutingDecisionStore;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** FR-601 idempotent cross-ref re-push for one ingestion. */
public final class CrossRefSyncService {

    private final CrossRefPlanner planner;
    private final CrossRefStore crossRefStore;
    private final DispatchRecordStore dispatchStore;
    private final BusinessAckStore ackStore;
    private final RoutingDecisionStore routingStore;
    private final CrossRefExecutor executor;

    public CrossRefSyncService(
            CrossRefPlanner planner,
            CrossRefStore crossRefStore,
            DispatchRecordStore dispatchStore,
            BusinessAckStore ackStore,
            RoutingDecisionStore routingStore,
            CrossRefExecutor executor) {
        this.planner = planner;
        this.crossRefStore = crossRefStore;
        this.dispatchStore = dispatchStore;
        this.ackStore = ackStore;
        this.routingStore = routingStore;
        this.executor = executor;
    }

    public SyncResult sync(UUID ingestionId, String correlationId) {
        List<CrossRefPlanner.AckSnapshot> acks = new ArrayList<>();
        for (DispatchRecord dispatch : dispatchStore.findByCorrelationId(correlationId)) {
            ackStore.findByDispatchId(dispatch.dispatchId())
                    .filter(a -> "BOOKED".equalsIgnoreCase(a.status()))
                    .ifPresent(
                            a ->
                                    acks.add(
                                            new CrossRefPlanner.AckSnapshot(
                                                    correlationId,
                                                    a.systemId(),
                                                    a.swapRef(),
                                                    CrossRefEnvelopeBuilder.parseLotRefsJson(
                                                            a.lotRefsJson()))));
        }
        List<RoutingDecision> routing = routingStore.findByCorrelationId(correlationId);
        int rebuilt = planner.syncFromAcks(ingestionId, acks, routing);
        executor.poll(Math.max(10, rebuilt * 2));
        try {
            executor.awaitCompletion();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("cross-ref sync interrupted", e);
        }
        return new SyncResult(rebuilt, crossRefStore.findByIngestionId(ingestionId));
    }

    public record SyncResult(int directionsReset, List<CrossRefRecord> crossRefs) {}
}
