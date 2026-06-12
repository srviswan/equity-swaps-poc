package com.pb.tcs.approval;

import java.time.Instant;
import java.util.UUID;

/** One row of {@code approval_request}. */
public record ApprovalRecord(
        long approvalRequestId,
        String approvalId,
        UUID ingestionId,
        String correlationId,
        String batchId,
        ApprovalKind kind,
        ApprovalStatus status,
        String initiatedBy,
        String publishMode,
        String blotterJson,
        String editedFieldsDiffJson,
        Instant respondBy,
        String decidedBy,
        Instant decidedAt) {}
