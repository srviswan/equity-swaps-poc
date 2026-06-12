package com.pb.tcs.dispatch;

import com.pb.tcs.cutover.CutoverPolicy;
import com.pb.tcs.routing.RoutingDecision;
import java.util.List;
import java.util.UUID;

/** Stage 9 (arch §5): creates one PENDING {@code dispatch_record} per routed target. */
public final class DispatchPlanner {

    private final DispatchRecordStore dispatchStore;
    private final IngestionDispatchStatusUpdater ingestionStatus;
    private final CutoverPolicy cutoverPolicy;

    public DispatchPlanner(
            DispatchRecordStore dispatchStore, IngestionDispatchStatusUpdater ingestionStatus) {
        this(dispatchStore, ingestionStatus, CutoverPolicy.liveAll());
    }

    public DispatchPlanner(
            DispatchRecordStore dispatchStore,
            IngestionDispatchStatusUpdater ingestionStatus,
            CutoverPolicy cutoverPolicy) {
        this.dispatchStore = dispatchStore;
        this.ingestionStatus = ingestionStatus;
        this.cutoverPolicy = cutoverPolicy;
    }

    public void plan(UUID ingestionId, String correlationId, String book, List<RoutingDecision> decisions) {
        List<String> targets =
                decisions.stream()
                        .map(RoutingDecision::targetId)
                        .filter(t -> cutoverPolicy.shouldPlanDispatch(book, t))
                        .distinct()
                        .toList();
        if (targets.isEmpty()) {
            return;
        }
        dispatchStore.createPending(ingestionId, correlationId, targets);
        ingestionStatus.update(correlationId, IngestionDispatchStatus.QUEUED);
    }
}
