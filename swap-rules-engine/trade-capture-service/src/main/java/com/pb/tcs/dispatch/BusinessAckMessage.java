package com.pb.tcs.dispatch;

import java.time.Instant;
import java.util.List;

/** Consumed from {@code Q.TCS.BUSINESSACK.{SYSTEM}} (arch §15.3 / FR-402). */
public record BusinessAckMessage(
        String blockId,
        String allocationId,
        int version,
        String systemId,
        String status, // BOOKED | REJECTED
        String swapRef,
        List<LotRef> lotRefs,
        String rejectReason,
        Instant ackedAt,
        String rawPayload) {

    public record LotRef(String lotId, String action, long qty) {}

    public String correlationId() {
        return blockId + "/" + allocationId + "/" + version;
    }
}
