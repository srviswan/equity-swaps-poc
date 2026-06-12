package com.pb.tcs.approval;

import com.pb.tcs.config.ApprovalWorkflowConfig;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.rules.RuleExplain;
import com.pb.tcs.rules.SwapBlotter;
import io.micrometer.core.instrument.MeterRegistry;
import java.time.Clock;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * Stage-5.5 gate (FR-301): STP initiators continue; non-STP trades park with {@code
 * PENDING_APPROVAL} and an Approval Service request (FR-302 releases the partition).
 */
public final class ApprovalGateStage {

    public static final String STATUS_PENDING = "PENDING_APPROVAL";
    public static final String STATUS_READY = "BLOTTER_READY";
    public static final String STATUS_DENIED = "APPROVAL_DENIED";
    public static final String STATUS_VALIDATED = "BLOTTER_VALIDATED";

    private final ApprovalGate gate;
    private final ApprovalStore store;
    private final ApprovalServiceClient approvalClient;
    private final ApprovalWorkflowConfig config;
    private final ApprovalMetrics metrics;
    private final Clock clock;

    public ApprovalGateStage(
            ApprovalGate gate,
            ApprovalStore store,
            ApprovalServiceClient approvalClient,
            ApprovalWorkflowConfig config,
            ApprovalMetrics metrics,
            Clock clock) {
        this.gate = gate;
        this.store = store;
        this.approvalClient = approvalClient;
        this.config = config;
        this.metrics = metrics;
        this.clock = clock;
    }

    public sealed interface Outcome {
        record Passed(SwapBlotter blotter, List<RuleExplain> explains) implements Outcome {}

        record Parked(String approvalId, UUID ingestionId) implements Outcome {}
    }

    public Outcome evaluate(
            UUID ingestionId,
            SourceSystem source,
            String initiatedBy,
            String publishMode,
            String batchId,
            ApprovalKind kind,
            SwapBlotter blotter,
            List<RuleExplain> explains,
            String editedFieldsDiffJson) {
        if (!gate.requiresApproval(source, initiatedBy)) {
            metrics.gateOutcome("STP_PASS");
            return new Outcome.Passed(blotter, explains);
        }
        Instant respondBy = clock.instant().plus(config.approvalTimeout());
        String approvalId =
                store.park(
                        new ApprovalStore.ParkCommand(
                                ingestionId,
                                blotter.correlationId(),
                                batchId,
                                kind,
                                initiatedBy,
                                publishMode,
                                com.pb.tcs.rules.BlotterJson.toJson(blotter),
                                editedFieldsDiffJson,
                                respondBy));
        approvalClient.submitTrade(
                new ApprovalServiceClient.ApprovalRequest(
                        approvalId,
                        ingestionId.toString(),
                        initiatedBy,
                        publishMode,
                        com.pb.tcs.rules.BlotterJson.toJson(blotter),
                        List.of(),
                        respondBy.toString()));
        metrics.gateOutcome("PARKED");
        metrics.pending();
        return new Outcome.Parked(approvalId, ingestionId);
    }
}
