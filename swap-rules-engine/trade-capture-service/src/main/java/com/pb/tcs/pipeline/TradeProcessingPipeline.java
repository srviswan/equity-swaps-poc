package com.pb.tcs.pipeline;

import com.pb.tcs.approval.ApprovalGateStage;
import com.pb.tcs.approval.ApprovalKind;
import com.pb.tcs.approval.ApprovalRecord;
import com.pb.tcs.approval.ApprovalStore;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.ingress.IngestionLifecycleStore;
import com.pb.tcs.ingress.PipelineResult;
import com.pb.tcs.proto.allocation.v1.ApprovalResume;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.SwapBlotterPayload;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import com.pb.tcs.repair.BusinessValidationStage;
import com.pb.tcs.rules.BlotterAssembler;
import com.pb.tcs.rules.BlotterJson;
import com.pb.tcs.rules.SwapBlotter;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * Stages 4 → 5.5 → 6 orchestration (F3 + F8). Parked trades release the partition (FR-302);
 * resumes continue at business validation (stage 6).
 */
public final class TradeProcessingPipeline {

    private final BlotterAssembler assembler;
    private final ApprovalGateStage gateStage;
    private final BusinessValidationStage businessValidation;
    private final IngestionLifecycleStore lifecycle;
    private final ApprovalStore approvalStore;

    public TradeProcessingPipeline(
            BlotterAssembler assembler,
            ApprovalGateStage gateStage,
            BusinessValidationStage businessValidation,
            IngestionLifecycleStore lifecycle,
            ApprovalStore approvalStore) {
        this.assembler = assembler;
        this.gateStage = gateStage;
        this.businessValidation = businessValidation;
        this.lifecycle = lifecycle;
        this.approvalStore = approvalStore;
    }

    public PipelineResult continueAfterEnrich(EnrichedAllocation enriched, UUID ingestionId) {
        BlotterAssembler.Assembly assembly = assembler.assemble(enriched);
        return applyGate(
                ingestionId,
                enriched.envelope().getSource(),
                enriched.envelope().getInitiatedBy(),
                "RAW_ALLOCATION",
                null,
                ApprovalKind.TRADE,
                assembly);
    }

    public PipelineResult processManualBlotter(TcsIngressMessage envelope, byte[] raw) {
        SwapBlotterPayload payload = envelope.getManualBlotter();
        SwapBlotter blotter = BlotterJson.fromJson(payload.getBlotterJson().toString(StandardCharsets.UTF_8));
        UUID ingestionId =
                lifecycle.persistManualBlotter(
                        envelope, raw, blotter, payload.getPreviewHash(), envelope.getInitiatedBy());
        var assembly =
                new BlotterAssembler.Assembly(
                        blotter,
                        null,
                        java.util.List.of(
                                new com.pb.tcs.rules.RuleExplain(
                                        0,
                                        "MANUAL_BLOTTER",
                                        0,
                                        "WORKFLOW",
                                        "MANUAL_BLOTTER",
                                        "rules frozen at preview "
                                                + payload.getPreviewHash())));
        return applyGate(
                ingestionId,
                envelope.getSource(),
                envelope.getInitiatedBy(),
                "SWAP_BLOTTER",
                null,
                ApprovalKind.TRADE,
                assembly);
    }

    public PipelineResult processApprovalResume(TcsIngressMessage envelope) {
        ApprovalResume resume = envelope.getApprovalResume();
        UUID ingestionId = UUID.fromString(resume.getIngestionId());
        var snapshot = lifecycle.findByIngestionId(ingestionId).orElseThrow();
        if (ApprovalGateStage.STATUS_DENIED.equals(snapshot.status())) {
            return PipelineResult.ack(
                    PipelineResult.Disposition.DUPLICATE, "already denied");
        }
        if (ApprovalGateStage.STATUS_READY.equals(snapshot.status())
                || "QUEUED".equals(snapshot.status())) {
            return PipelineResult.ack(PipelineResult.Disposition.DUPLICATE, "already resumed");
        }
        boolean applied =
                approvalStore.resumeIfPending(
                        ingestionId, resume.getApprovalId(), resume.getApprovedBy());
        if (!applied) {
            return PipelineResult.ack(PipelineResult.Disposition.DUPLICATE, "stale resume");
        }
        ApprovalRecord approval =
                approvalStore.findByApprovalId(resume.getApprovalId()).orElseThrow();
        SwapBlotter blotter = BlotterJson.fromJson(approval.blotterJson());
        lifecycle.updateStatus(ingestionId, ApprovalGateStage.STATUS_READY, resume.getApprovalId());
        return runBusinessValidation(blotter, null);
    }

    private PipelineResult applyGate(
            UUID ingestionId,
            SourceSystem source,
            String initiatedBy,
            String publishMode,
            String batchId,
            ApprovalKind kind,
            BlotterAssembler.Assembly assembly) {
        var gateOutcome =
                gateStage.evaluate(
                        ingestionId,
                        source,
                        initiatedBy,
                        publishMode,
                        batchId,
                        kind,
                        assembly.blotter(),
                        assembly.explains(),
                        null);
        if (gateOutcome instanceof ApprovalGateStage.Outcome.Parked parked) {
            lifecycle.updateStatus(
                    ingestionId, ApprovalGateStage.STATUS_PENDING, parked.approvalId());
            return PipelineResult.ack(
                    PipelineResult.Disposition.GATE_PARKED,
                    "parked " + parked.approvalId());
        }
        lifecycle.updateStatus(ingestionId, ApprovalGateStage.STATUS_VALIDATED, null);
        return runBusinessValidation(assembly.blotter(), assembly.explains());
    }

    private PipelineResult runBusinessValidation(
            SwapBlotter blotter, java.util.List<com.pb.tcs.rules.RuleExplain> explains) {
        var assembly = new BlotterAssembler.Assembly(blotter, null, explains == null ? java.util.List.of() : explains);
        var outcome = businessValidation.process(assembly);
        if (outcome instanceof BusinessValidationStage.Outcome.Quarantined q) {
            return PipelineResult.ack(
                    PipelineResult.Disposition.BUSINESS_QUARANTINED,
                    "quarantine " + q.quarantineId());
        }
        lifecycle.updateStatus(
                lifecycle.findByCorrelationId(blotter.correlationId()).orElseThrow().ingestionId(),
                ApprovalGateStage.STATUS_READY,
                null);
        return PipelineResult.ack(
                PipelineResult.Disposition.BLOTTER_READY, "business validation passed");
    }
}
