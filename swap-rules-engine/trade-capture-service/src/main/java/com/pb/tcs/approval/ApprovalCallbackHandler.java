package com.pb.tcs.approval;

import com.pb.tcs.ingress.IngestionLifecycleStore;
import com.pb.tcs.ingress.IngressPublisher;
import com.pb.tcs.proto.allocation.v1.ApprovalResume;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

/** Handles Approval Service callbacks (FR-303 / arch §15.1). */
public final class ApprovalCallbackHandler {

    private final ApprovalStore store;
    private final IngestionLifecycleStore lifecycle;
    private final IngressPublisher publisher;
    private final ApprovalMetrics metrics;

    public ApprovalCallbackHandler(
            ApprovalStore store,
            IngestionLifecycleStore lifecycle,
            IngressPublisher publisher,
            ApprovalMetrics metrics) {
        this.store = store;
        this.lifecycle = lifecycle;
        this.publisher = publisher;
        this.metrics = metrics;
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
        // ROWS carve-out: deny listed rows, approve the rest (batch FR-505)
        List<Integer> deniedRows = callback.rowCarveOut();
        return new CallbackResult("PARTIAL", deniedRows);
    }

    private void publishResume(ApprovalCallback callback) {
        IngestionLifecycleStore.IngestionSnapshot snapshot =
                lifecycle.findByIngestionId(UUID.fromString(callback.ingestionId())).orElseThrow();
        TcsIngressMessage envelope =
                TcsIngressMessage.newBuilder()
                        .setMessageId("resume-" + callback.approvalId())
                        .setSource(SourceSystem.MANUAL)
                        .setBook(snapshot.blockId().startsWith("MAN-") ? "EQ_US_HY" : "EQ_US_HY")
                        .setAccountId("CLI-9")
                        .setSecurityId("SEC-AAPL")
                        .setInitiatedBy(callback.decidedBy())
                        .setApprovalResume(
                                ApprovalResume.newBuilder()
                                        .setIngestionId(callback.ingestionId())
                                        .setApprovalId(callback.approvalId())
                                        .setApprovedBy(callback.decidedBy())
                                        .setApprovedAtUtc(Instant.now().toString())
                                        .build())
                        .build();
        publisher.publish(envelope, envelope.toByteArray());
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
