package com.pb.tcs.dispatch;

import java.time.Instant;
import java.util.UUID;

/** One row of {@code dispatch_record}: per (ingestion, destination) fan-out unit (FR-400). */
public record DispatchRecord(
        long dispatchId,
        UUID ingestionId,
        String correlationId,
        String destinationId,
        DispatchStatus status,
        int attemptCount,
        Instant nextAttemptAt,
        String lastError,
        String envelopeHash,
        Instant sentAt) {}
