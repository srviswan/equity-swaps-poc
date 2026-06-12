package com.pb.tcs.lookup;

import com.pb.tcs.approval.ApprovalRecord;
import com.pb.tcs.approval.ApprovalStore;
import com.pb.tcs.crossref.CrossRefRecord;
import com.pb.tcs.crossref.CrossRefStore;
import com.pb.tcs.dispatch.BusinessAckStore;
import com.pb.tcs.dispatch.DispatchRecord;
import com.pb.tcs.dispatch.DispatchRecordStore;
import com.pb.tcs.ingress.IngestionLifecycleStore;
import com.pb.tcs.routing.RoutingDecision;
import com.pb.tcs.routing.RoutingDecisionStore;
import com.pb.tcs.rules.BlotterStore;
import com.pb.tcs.rules.RuleExplain;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/** FR-603 full trade journey assembly from persisted artifacts. */
public final class TradeJourneyService {

    private final IngestionLifecycleStore lifecycle;
    private final BlotterStore blotterStore;
    private final RoutingDecisionStore routingStore;
    private final DispatchRecordStore dispatchStore;
    private final BusinessAckStore ackStore;
    private final CrossRefStore crossRefStore;
    private final ApprovalStore approvalStore;

    public TradeJourneyService(
            IngestionLifecycleStore lifecycle,
            BlotterStore blotterStore,
            RoutingDecisionStore routingStore,
            DispatchRecordStore dispatchStore,
            BusinessAckStore ackStore,
            CrossRefStore crossRefStore,
            ApprovalStore approvalStore) {
        this.lifecycle = lifecycle;
        this.blotterStore = blotterStore;
        this.routingStore = routingStore;
        this.dispatchStore = dispatchStore;
        this.ackStore = ackStore;
        this.crossRefStore = crossRefStore;
        this.approvalStore = approvalStore;
    }

    public Optional<TradeJourney> journey(UUID ingestionId) {
        return lifecycle
                .findByIngestionId(ingestionId)
                .map(
                        snap -> {
                            String correlationId = snap.correlationId();
                            List<RuleExplain> explains = blotterStore.findExplains(correlationId);
                            String blotterJson = blotterStore.findBlotterJson(correlationId).orElse(null);
                            List<RoutingDecision> routing =
                                    routingStore.findByCorrelationId(correlationId);
                            List<DispatchRecord> dispatch = dispatchStore.findByIngestionId(ingestionId);
                            List<BusinessAckStore.BusinessAckRecord> acks =
                                    dispatch.stream()
                                            .map(d -> ackStore.findByDispatchId(d.dispatchId()))
                                            .flatMap(Optional::stream)
                                            .toList();
                            List<CrossRefRecord> crossRefs = crossRefStore.findByIngestionId(ingestionId);
                            List<ApprovalRecord> approvals =
                                    approvalStore.findByIngestionId(ingestionId);
                            return new TradeJourney(
                                    snap,
                                    blotterJson,
                                    explains,
                                    routing,
                                    dispatch,
                                    acks,
                                    crossRefs,
                                    approvals);
                        });
    }

    public record TradeJourney(
            IngestionLifecycleStore.IngestionSnapshot ingestion,
            String blotterJson,
            List<RuleExplain> explains,
            List<RoutingDecision> routing,
            List<DispatchRecord> dispatch,
            List<BusinessAckStore.BusinessAckRecord> businessAcks,
            List<CrossRefRecord> crossRefs,
            List<ApprovalRecord> approvals) {}
}
