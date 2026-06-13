package com.pb.tcs.crossref;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/** Persistence port over {@code cross_ref} (FR-403 / D15). */
public interface CrossRefStore {

    /** Upsert one direction; idempotent on (ingestionId, fromSystem, toSystem). */
    void upsertPending(CrossRefRecord record);

    List<CrossRefRecord> claimPending(int limit, Instant now);

    void markDelivered(long crossRefId, Instant deliveredAt);

    void scheduleRetry(long crossRefId, int attemptCount, Instant nextAttemptAt, String lastError);

    void markFailed(long crossRefId, String lastError);

    void resetToPending(long crossRefId);

    List<CrossRefRecord> findByIngestionId(UUID ingestionId);

    Optional<CrossRefRecord> findDirection(UUID ingestionId, String fromSystem, String toSystem);

    List<CrossRefRecord> query(CrossRefQuery query);

    record CrossRefQuery(String allocationId, String swapRef, String fromSystem, String toSystem) {}
}
