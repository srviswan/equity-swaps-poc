package com.pb.tcs.dispatch;

import java.time.Instant;
import java.util.Optional;

/** Persistence port over {@code business_ack} (D14 — separate from dispatch status). */
public interface BusinessAckStore {

    void save(BusinessAckRecord ack);

    Optional<BusinessAckRecord> findByDispatchId(long dispatchId);

    record BusinessAckRecord(
            long businessAckId,
            long dispatchId,
            String systemId,
            String status,
            String swapRef,
            String lotRefsJson,
            String rejectReason,
            String ackPayload,
            Instant ackedAt) {}
}
