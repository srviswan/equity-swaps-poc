package com.pb.tcs.approval;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/** Persistence port over {@code approval_request} + ingestion status transitions (FR-301/303). */
public interface ApprovalStore {

    String park(ParkCommand command);

    Optional<ApprovalRecord> findByApprovalId(String approvalId);

    Optional<ApprovalRecord> findPendingByIngestionId(UUID ingestionId);

    boolean resumeIfPending(UUID ingestionId, String approvalId, String approvedBy);

    boolean denyIfPending(UUID ingestionId, String approvalId, String decidedBy);

    List<ApprovalRecord> findExpiredPending(Instant now);

    void markEscalated(String approvalId);

    record ParkCommand(
            UUID ingestionId,
            String correlationId,
            String batchId,
            ApprovalKind kind,
            String initiatedBy,
            String publishMode,
            String blotterJson,
            String editedFieldsDiffJson,
            Instant respondBy) {}
}
