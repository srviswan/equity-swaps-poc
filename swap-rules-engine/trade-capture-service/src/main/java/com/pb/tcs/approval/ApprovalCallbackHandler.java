package com.pb.tcs.approval;

import com.pb.tcs.ingress.IngestionLifecycleStore;
import com.pb.tcs.ingress.IngressPublisher;
import com.pb.tcs.manual.BulkBatchStore;
import com.pb.tcs.proto.allocation.v1.ApprovalResume;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import com.pb.tcs.rules.BlotterJson;
import com.pb.tcs.rules.SwapBlotter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** Handles Approval Service callbacks (FR-303 / arch §15.1). */
public final class ApprovalCallbackHandler {

    private final ApprovalStore store;
    private final IngestionLifecycleStore lifecycle;
    private final IngressPublisher publisher;
    private final ApprovalMetrics metrics;
    private final BulkBatchStore batchStore;

    public ApprovalCallbackHandler(
            ApprovalStore store,
            IngestionLifecycleStore lifecycle,
            IngressPublisher publisher,
            ApprovalMetrics metrics) {
        this(store, lifecycle, publisher, metrics, null);
    }

    public ApprovalCallbackHandler(
            ApprovalStore store,
            IngestionLifecycleStore lifecycle,
            IngressPublisher publisher,
            ApprovalMetrics metrics,
            BulkBatchStore batchStore) {
        this.store = store;
        this.lifecycle = lifecycle;
        this.publisher = publisher;
        this.metrics = metrics;
        this.batchStore = batchStore;
    }

    public CallbackResult handle(ApprovalCallback callback) {
        if ("DENIED".equalsIgnoreCase(callback.outcome())) {
            boolean denied =
                    store.denyIfPending(
                            UUID.fromString(callback.ingestionId()),
                            callback.approvalId(),
                            callback.decidedBy());
            if (denied) {
                metrics.denied();
            }
            return new CallbackResult(denied ? "DENIED" : "NOOP", List.of());
        }
        if ("ALL".equalsIgnoreCase(callback.scope()) || callback.scope() == null) {
            boolean resumed =
                    store.resumeIfPending(
                            UUID.fromString(callback.ingestionId()),
                            callback.approvalId(),
                            callback.decidedBy());
            if (resumed) {
                publishResume(callback);
                metrics.resumed();
            }
            return new CallbackResult(resumed ? "RESUMED" : "NOOP", List.of());
        }
        if ("ROWS".equalsIgnoreCase(callback.scope())) {
            return handleRowsCarveOut(callback);
        }
        return new CallbackResult("NOOP", List.of());
    }

    private CallbackResult handleRowsCarveOut(ApprovalCallback callback) {
        List<Integer> deniedRows =
                callback.rowCarveOut() == null ? List.of() : List.copyOf(callback.rowCarveOut());
        ApprovalRecord approval =
                store.findByApprovalId(callback.approvalId())
                        .orElseThrow(
                                () ->
                                        new IllegalArgumentException(
                                                "unknown approval " + callback.approvalId()));

        if (approval.batchId() != null && batchStore != null) {
            store.resumeIfPending(
                    UUID.fromString(callback.ingestionId()),
                    callback.approvalId(),
                    callback.decidedBy());
            List<Integer> resumedRows = new ArrayList<>();
            for (int rowNo : batchStore.submittedRowNumbers(approval.batchId())) {
                if (deniedRows.contains(rowNo)) {
                    batchStore.updateRowStatus(approval.batchId(), rowNo, "DENIED");
                    denyIngestionForRow(approval.batchId(), rowNo, callback);
                } else {
                    publishResumeForRow(approval.batchId(), rowNo, callback);
                    resumedRows.add(rowNo);
                }
            }
            if (!resumedRows.isEmpty()) {
                metrics.resumed();
            }
            if (!deniedRows.isEmpty()) {
                metrics.denied();
            }
            return new CallbackResult("PARTIAL", deniedRows);
        }

        if (!deniedRows.isEmpty()) {
            boolean denied =
                    store.denyIfPending(
                            UUID.fromString(callback.ingestionId()),
                            callback.approvalId(),
                            callback.decidedBy());
            if (denied) {
                metrics.denied();
            }
            return new CallbackResult(denied ? "DENIED" : "NOOP", deniedRows);
        }

        boolean resumed =
                store.resumeIfPending(
                        UUID.fromString(callback.ingestionId()),
                        callback.approvalId(),
                        callback.decidedBy());
        if (resumed) {
            publishResume(callback);
            metrics.resumed();
        }
        return new CallbackResult(resumed ? "RESUMED" : "NOOP", List.of());
    }

    private void denyIngestionForRow(String batchId, int rowNo, ApprovalCallback callback) {
        batchStore
                .blockIdForRow(batchId, rowNo)
                .flatMap(this::findIngestionIdForBlock)
                .ifPresent(
                        ingestionId -> {
                            if (!store.denyIfPending(
                                    ingestionId, callback.approvalId(), callback.decidedBy())) {
                                lifecycle.updateStatus(
                                        ingestionId,
                                        ApprovalGateStage.STATUS_DENIED,
                                        callback.approvalId());
                            }
                        });
    }

    private void publishResumeForRow(String batchId, int rowNo, ApprovalCallback callback) {
        batchStore
                .blockIdForRow(batchId, rowNo)
                .flatMap(this::findIngestionIdForBlock)
                .ifPresent(
                        ingestionId ->
                                publishResume(
                                        callback,
                                        ingestionId,
                                        store.findByApprovalId(callback.approvalId()).orElseThrow()));
    }

    private java.util.Optional<UUID> findIngestionIdForBlock(String blockId) {
        return lifecycle.findByCorrelationId(blockId + "/ALL-1/1").map(IngestionLifecycleStore.IngestionSnapshot::ingestionId);
    }

    private void publishResume(ApprovalCallback callback) {
        ApprovalRecord approval =
                store.findByApprovalId(callback.approvalId())
                        .orElseThrow(
                                () ->
                                        new IllegalArgumentException(
                                                "unknown approval " + callback.approvalId()));
        publishResume(callback, UUID.fromString(callback.ingestionId()), approval);
    }

    private void publishResume(ApprovalCallback callback, UUID ingestionId, ApprovalRecord approval) {
        SwapBlotter sequence = sequenceBlotter(approval);
        TcsIngressMessage envelope =
                TcsIngressMessage.newBuilder()
                        .setMessageId("resume-" + callback.approvalId() + "-" + ingestionId)
                        .setSource(SourceSystem.MANUAL)
                        .setBook(sequence.book())
                        .setAccountId(sequence.accountId())
                        .setSecurityId(sequence.securityId())
                        .setInitiatedBy(callback.decidedBy())
                        .setApprovalResume(
                                ApprovalResume.newBuilder()
                                        .setIngestionId(ingestionId.toString())
                                        .setApprovalId(callback.approvalId())
                                        .setApprovedBy(callback.decidedBy())
                                        .setApprovedAtUtc(Instant.now().toString())
                                        .build())
                        .build();
        publisher.publish(envelope, envelope.toByteArray());
    }

    private static SwapBlotter sequenceBlotter(ApprovalRecord approval) {
        if (approval.blotterJson() == null || approval.blotterJson().isBlank()) {
            throw new IllegalStateException(
                    "missing blotterJson on approval " + approval.approvalId());
        }
        return BlotterJson.fromJson(approval.blotterJson());
    }

    public record ApprovalCallback(
            String approvalId,
            String ingestionId,
            String outcome,
            String scope,
            List<Integer> rowCarveOut,
            String decidedBy,
            Instant decidedAt) {}

    public record CallbackResult(String status, List<Integer> carvedOutRows) {}
}
