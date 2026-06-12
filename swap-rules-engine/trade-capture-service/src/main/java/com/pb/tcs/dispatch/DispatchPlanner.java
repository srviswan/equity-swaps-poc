package com.pb.tcs.dispatch;

import com.pb.tcs.routing.RoutingDecision;
import java.util.List;
import java.util.UUID;

/** Stage 9 (arch §5): creates one PENDING {@code dispatch_record} per routed target. */
public final class DispatchPlanner {

    private final DispatchRecordStore dispatchStore;
    private final IngestionDispatchStatusUpdater ingestionStatus;

    public DispatchPlanner(
            DispatchRecordStore dispatchStore, IngestionDispatchStatusUpdater ingestionStatus) {
        this.dispatchStore = dispatchStore;
        this.ingestionStatus = ingestionStatus;
    }

    public void plan(UUID ingestionId, String correlationId, List<RoutingDecision> decisions) {
        List<String> targets = decisions.stream().map(RoutingDecision::targetId).distinct().toList();
        dispatchStore.createPending(ingestionId, correlationId, targets);
        ingestionStatus.update(correlationId, IngestionDispatchStatus.QUEUED);
    }
}
