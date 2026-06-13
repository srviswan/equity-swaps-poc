package com.pb.tcs.crossref;

import com.pb.tcs.dispatch.BusinessAckMessage;
import com.pb.tcs.dispatch.DispatchRecord;
import com.pb.tcs.routing.EventTypeDeriver;
import com.pb.tcs.routing.RoutingDecision;
import com.pb.tcs.routing.RoutingDecisionStore;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Stage-12 planner (FR-403): on each BOOKED business ACK, upsert the peer-direction cross-ref row
 * when the trade was multi-target. Single-target trades produce no rows (D15).
 */
public final class CrossRefPlanner {

    private final CrossRefStore crossRefStore;
    private final RoutingDecisionStore routingStore;

    public CrossRefPlanner(CrossRefStore crossRefStore, RoutingDecisionStore routingStore) {
        this.crossRefStore = crossRefStore;
        this.routingStore = routingStore;
    }

    public void onBusinessAck(DispatchRecord dispatch, BusinessAckMessage message) {
        List<RoutingDecision> routing = routingStore.findByCorrelationId(message.correlationId());
        if (routing.size() < 2) {
            return;
        }
        Set<String> targets =
                routing.stream().map(RoutingDecision::targetId).collect(Collectors.toSet());
        if (!targets.contains("SYSTEM_A") || !targets.contains("SYSTEM_B")) {
            return;
        }

        String peer = peerOf(message.systemId());
        if (peer == null || !targets.contains(peer)) {
            return;
        }

        EventTypeDeriver.EventType peerEventType =
                routing.stream()
                        .filter(d -> d.targetId().equals(peer))
                        .findFirst()
                        .map(RoutingDecision::eventType)
                        .orElseThrow();

        List<CrossRefPushMessage.LotRef> lots =
                CrossRefEnvelopeBuilder.closedLotsForUnwind(
                        CrossRefEnvelopeBuilder.lotRefsFromAck(message), peerEventType);

        crossRefStore.upsertPending(
                new CrossRefRecord(
                        0,
                        dispatch.ingestionId(),
                        message.correlationId(),
                        message.systemId(),
                        peer,
                        message.swapRef(),
                        CrossRefEnvelopeBuilder.lotRefsJson(lots),
                        peerEventType,
                        CrossRefStatus.PENDING,
                        0,
                        Instant.EPOCH,
                        null,
                        null));
    }

    private static String peerOf(String systemId) {
        if ("SYSTEM_A".equals(systemId)) {
            return "SYSTEM_B";
        }
        if ("SYSTEM_B".equals(systemId)) {
            return "SYSTEM_A";
        }
        return null;
    }

    /** Rebuild both directions from persisted business ACKs (FR-601 idempotent sync). */
    public int syncFromAcks(UUID ingestionId, List<AckSnapshot> acks, List<RoutingDecision> routing) {
        if (routing.size() < 2) {
            return 0;
        }
        int updated = 0;
        for (AckSnapshot ack : acks) {
            Optional<RoutingDecision> peerDecision =
                    routing.stream()
                            .filter(d -> peerOf(ack.systemId()) != null && d.targetId().equals(peerOf(ack.systemId())))
                            .findFirst();
            if (peerDecision.isEmpty()) {
                continue;
            }
            String peer = peerOf(ack.systemId());
            List<CrossRefPushMessage.LotRef> lots =
                    CrossRefEnvelopeBuilder.closedLotsForUnwind(ack.lotRefs(), peerDecision.get().eventType());
            crossRefStore.upsertPending(
                    new CrossRefRecord(
                            0,
                            ingestionId,
                            ack.correlationId(),
                            ack.systemId(),
                            peer,
                            ack.swapRef(),
                            CrossRefEnvelopeBuilder.lotRefsJson(lots),
                            peerDecision.get().eventType(),
                            CrossRefStatus.PENDING,
                            0,
                            Instant.EPOCH,
                            null,
                            null));
            updated++;
        }
        return updated;
    }

    public record AckSnapshot(
            String correlationId, String systemId, String swapRef, List<CrossRefPushMessage.LotRef> lotRefs) {}
}
