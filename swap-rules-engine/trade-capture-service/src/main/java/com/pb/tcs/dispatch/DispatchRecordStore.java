package com.pb.tcs.dispatch;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/** Persistence port over {@code dispatch_record} (FR-400 claim-batch executor). */
public interface DispatchRecordStore {

    /** Stage 9: one PENDING row per routed target. Idempotent on (ingestionId, destinationId). */
    void createPending(UUID ingestionId, String correlationId, List<String> destinationIds);

    /**
     * Short txn: row-lock eligible PENDING rows → CLAIMED. No network I/O inside this call
     * (arch §7 dispatch executor step 1).
     */
    List<DispatchRecord> claimBatch(int limit, Instant now);

    void markSent(long dispatchId, String envelopeHash, Instant sentAt);

    void scheduleRetry(long dispatchId, int attemptCount, Instant nextAttemptAt, String lastError);

    void markFailed(long dispatchId, String lastError);

    List<DispatchRecord> findByCorrelationId(String correlationId);

    Optional<DispatchRecord> findByDestination(String correlationId, String destinationId);
}
