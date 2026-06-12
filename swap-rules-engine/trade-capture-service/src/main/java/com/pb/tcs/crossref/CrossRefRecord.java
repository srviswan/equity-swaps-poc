package com.pb.tcs.crossref;

import com.pb.tcs.routing.EventTypeDeriver;
import java.time.Instant;
import java.util.UUID;

/** One row of {@code cross_ref}: refs from {@code fromSystem} delivered to {@code toSystem}. */
public record CrossRefRecord(
        long crossRefId,
        UUID ingestionId,
        String correlationId,
        String fromSystem,
        String toSystem,
        String swapRef,
        String lotRefsJson,
        EventTypeDeriver.EventType eventType,
        CrossRefStatus status,
        int attemptCount,
        Instant nextAttemptAt,
        String lastError,
        Instant deliveredAt) {}
