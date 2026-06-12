package com.pb.tcs.dispatch;

import com.pb.tcs.repair.RepairStore;
import com.pb.tcs.rules.BlotterJson;
import com.pb.tcs.rules.BlotterStore;
import com.pb.tcs.crossref.CrossRefPlanner;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * Stage-11 business ACK consumer (FR-402 / D14): persists {@code business_ack} rows (FK to
 * {@code dispatch_record}, never a dispatch status). {@code BOOKED} records latency from
 * {@code sent_at}; {@code REJECTED} marks dispatch FAILED and opens repair quarantine (arch
 * §15.3 — not retried blindly).
 */
public final class BusinessAckHandler {

    private final DispatchRecordStore dispatchStore;
    private final BusinessAckStore ackStore;
    private final BlotterStore blotterStore;
    private final RepairStore repairStore;
    private final BusinessAckMetrics metrics;
    private final CrossRefPlanner crossRefPlanner;

    public BusinessAckHandler(
            DispatchRecordStore dispatchStore,
            BusinessAckStore ackStore,
            BlotterStore blotterStore,
            RepairStore repairStore,
            BusinessAckMetrics metrics) {
        this(dispatchStore, ackStore, blotterStore, repairStore, metrics, null);
    }

    public BusinessAckHandler(
            DispatchRecordStore dispatchStore,
            BusinessAckStore ackStore,
            BlotterStore blotterStore,
            RepairStore repairStore,
            BusinessAckMetrics metrics,
            CrossRefPlanner crossRefPlanner) {
        this.dispatchStore = dispatchStore;
        this.ackStore = ackStore;
        this.blotterStore = blotterStore;
        this.repairStore = repairStore;
        this.metrics = metrics;
        this.crossRefPlanner = crossRefPlanner;
    }

    public void handle(BusinessAckMessage message) {
        DispatchRecord dispatch =
                dispatchStore
                        .findByDestination(message.correlationId(), message.systemId())
                        .orElseThrow(
                                () ->
                                        new IllegalStateException(
                                                "no dispatch for "
                                                        + message.correlationId()
                                                        + " / "
                                                        + message.systemId()));

        if (dispatch.status() != DispatchStatus.SENT) {
            throw new IllegalStateException(
                    "business ACK for dispatch %d in status %s"
                            .formatted(dispatch.dispatchId(), dispatch.status()));
        }

        if ("REJECTED".equalsIgnoreCase(message.status())) {
            dispatchStore.markFailed(
                    dispatch.dispatchId(),
                    "business reject: " + message.rejectReason());
            String blotterJson =
                    blotterStore
                            .findBlotterJson(message.correlationId())
                            .orElse("{}");
            repairStore.open(
                    "BUSINESS_VALIDATION",
                    message.correlationId(),
                    "BUSINESS_ACK_REJECTED %s: %s"
                            .formatted(message.systemId(), message.rejectReason()),
                    blotterJson);
            metrics.received(message.systemId(), "REJECTED");
            return;
        }

        if (dispatch.sentAt() != null && message.ackedAt() != null) {
            Duration latency = Duration.between(dispatch.sentAt(), message.ackedAt());
            metrics.recordLatency(message.systemId(), latency);
        }
        metrics.received(message.systemId(), "BOOKED");

        ackStore.save(
                new BusinessAckStore.BusinessAckRecord(
                        0,
                        dispatch.dispatchId(),
                        message.systemId(),
                        message.status(),
                        message.swapRef(),
                        lotRefsJson(message),
                        message.rejectReason(),
                        message.rawPayload(),
                        message.ackedAt()));

        if (crossRefPlanner != null) {
            crossRefPlanner.onBusinessAck(dispatch, message);
        }
    }

    private static String lotRefsJson(BusinessAckMessage message) {
        if (message.lotRefs() == null || message.lotRefs().isEmpty()) {
            return null;
        }
        return BlotterJson.toJsonMap(message.lotRefs());
    }
}
