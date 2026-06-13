package com.pb.tcs.approval;

import java.time.Clock;
import java.time.Instant;
import java.util.List;

/** Escalates approval requests past the 15-minute SLA (FR-303). */
public final class ApprovalTimeoutScheduler {

    private final ApprovalStore store;
    private final ApprovalMetrics metrics;
    private final Clock clock;

    public ApprovalTimeoutScheduler(ApprovalStore store, ApprovalMetrics metrics, Clock clock) {
        this.store = store;
        this.metrics = metrics;
        this.clock = clock;
    }

    public List<ApprovalRecord> sweep() {
        Instant now = clock.instant();
        List<ApprovalRecord> expired = store.findExpiredPending(now);
        for (ApprovalRecord record : expired) {
            store.markEscalated(record.approvalId());
            metrics.timeout();
        }
        return expired;
    }
}
