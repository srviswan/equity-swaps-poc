package com.pb.tcs.persistence;

import com.pb.tcs.approval.ApprovalKind;
import com.pb.tcs.approval.ApprovalRecord;
import com.pb.tcs.approval.ApprovalStatus;
import com.pb.tcs.approval.ApprovalStore;
import com.pb.tcs.approval.SequentialApprovalIdGenerator;
import com.pb.tcs.ingress.IngestionLifecycleStore;
import com.pb.tcs.ingress.IngestionStoreException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/** In-memory {@link ApprovalStore} for F8 tests. */
public final class InMemoryApprovalStore implements ApprovalStore {

    private final Map<String, ApprovalRecord> byApprovalId = new LinkedHashMap<>();
    private final Map<UUID, ApprovalRecord> pendingByIngestion = new LinkedHashMap<>();
    private final AtomicLong ids = new AtomicLong();
    private final SequentialApprovalIdGenerator idGen = new SequentialApprovalIdGenerator();
    private IngestionLifecycleStore lifecycle;

    public void bindLifecycle(IngestionLifecycleStore lifecycle) {
        this.lifecycle = lifecycle;
    }

    @Override
    public String park(ParkCommand command) {
        String approvalId = idGen.next();
        long rowId = ids.incrementAndGet();
        ApprovalRecord record =
                new ApprovalRecord(
                        rowId,
                        approvalId,
                        command.ingestionId(),
                        command.correlationId(),
                        command.batchId(),
                        command.kind(),
                        ApprovalStatus.PENDING,
                        command.initiatedBy(),
                        command.publishMode(),
                        command.blotterJson(),
                        command.editedFieldsDiffJson(),
                        command.respondBy(),
                        null,
                        null);
        byApprovalId.put(approvalId, record);
        pendingByIngestion.put(command.ingestionId(), record);
        return approvalId;
    }

    @Override
    public Optional<ApprovalRecord> findByApprovalId(String approvalId) {
        return Optional.ofNullable(byApprovalId.get(approvalId));
    }

    @Override
    public Optional<ApprovalRecord> findPendingByIngestionId(UUID ingestionId) {
        ApprovalRecord record = pendingByIngestion.get(ingestionId);
        if (record != null && record.status() == ApprovalStatus.PENDING) {
            return Optional.of(record);
        }
        return Optional.empty();
    }

    @Override
    public boolean resumeIfPending(UUID ingestionId, String approvalId, String approvedBy) {
        ApprovalRecord record = byApprovalId.get(approvalId);
        if (record == null
                || !record.ingestionId().equals(ingestionId)
                || record.status() != ApprovalStatus.PENDING) {
            return false;
        }
        ApprovalRecord updated = approved(record, approvedBy);
        byApprovalId.put(approvalId, updated);
        pendingByIngestion.put(ingestionId, updated);
        return true;
    }

    @Override
    public boolean denyIfPending(UUID ingestionId, String approvalId, String decidedBy) {
        ApprovalRecord record = byApprovalId.get(approvalId);
        if (record == null
                || !record.ingestionId().equals(ingestionId)
                || record.status() != ApprovalStatus.PENDING) {
            return false;
        }
        ApprovalRecord updated = denied(record, decidedBy);
        byApprovalId.put(approvalId, updated);
        pendingByIngestion.remove(ingestionId);
        if (lifecycle != null) {
            lifecycle.updateStatus(ingestionId, "APPROVAL_DENIED", approvalId);
        }
        return true;
    }

    @Override
    public List<ApprovalRecord> findExpiredPending(Instant now) {
        List<ApprovalRecord> expired = new ArrayList<>();
        for (ApprovalRecord record : byApprovalId.values()) {
            if (record.status() == ApprovalStatus.PENDING && record.respondBy().isBefore(now)) {
                expired.add(record);
            }
        }
        return expired;
    }

    @Override
    public List<ApprovalRecord> findByIngestionId(UUID ingestionId) {
        return byApprovalId.values().stream()
                .filter(r -> r.ingestionId().equals(ingestionId))
                .toList();
    }

    @Override
    public void markEscalated(String approvalId) {
        // status remains PENDING per FR-303 escalation-only semantics
    }

    private static ApprovalRecord approved(ApprovalRecord record, String approvedBy) {
        return new ApprovalRecord(
                record.approvalRequestId(),
                record.approvalId(),
                record.ingestionId(),
                record.correlationId(),
                record.batchId(),
                record.kind(),
                ApprovalStatus.APPROVED,
                record.initiatedBy(),
                record.publishMode(),
                record.blotterJson(),
                record.editedFieldsDiffJson(),
                record.respondBy(),
                approvedBy,
                Instant.now());
    }

    private static ApprovalRecord denied(ApprovalRecord record, String decidedBy) {
        return new ApprovalRecord(
                record.approvalRequestId(),
                record.approvalId(),
                record.ingestionId(),
                record.correlationId(),
                record.batchId(),
                record.kind(),
                ApprovalStatus.DENIED,
                record.initiatedBy(),
                record.publishMode(),
                record.blotterJson(),
                record.editedFieldsDiffJson(),
                record.respondBy(),
                decidedBy,
                Instant.now());
    }
}
