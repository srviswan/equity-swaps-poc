package com.pb.tcs.api;

import com.pb.tcs.recon.BreakWorkflowService;
import com.pb.tcs.recon.ReconBreak;
import com.pb.tcs.recon.ReconRun;
import com.pb.tcs.recon.ReconScope;
import com.pb.tcs.recon.ReconService;
import com.pb.tcs.recon.ReconType;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * FR-707 / FR-704 REST contract surface ({@code POST /api/v1/recon/runs},
 * {@code POST /api/v1/recon/breaks/{breakId}/...}). Transport-agnostic.
 */
public final class ReconApi {

    private final ReconService reconService;
    private final BreakWorkflowService workflowService;

    public ReconApi(ReconService reconService, BreakWorkflowService workflowService) {
        this.reconService = reconService;
        this.workflowService = workflowService;
    }

    public ReconRunResponse startRun(ReconRunRequest request) {
        ReconRun run =
                reconService.startRun(
                        request.type(),
                        new ReconScope(request.book(), request.tradeDate()),
                        request.asOf());
        return ReconRunResponse.from(run);
    }

    public ReconRunResponse getRun(long runId) {
        return reconService
                .getRun(runId)
                .map(ReconRunResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("unknown run " + runId));
    }

    public List<ReconBreakView> getBreaks(long runId) {
        return reconService.getBreaks(runId).stream().map(ReconBreakView::from).toList();
    }

    public ReconBreakView acknowledge(long breakId, String actor) {
        return ReconBreakView.from(workflowService.acknowledge(breakId, actor));
    }

    public ReconBreakView heal(long breakId, AutoHealRequest request) {
        return ReconBreakView.from(
                workflowService.heal(
                        breakId,
                        new BreakWorkflowService.AutoHealContext(
                                request.ingestionId(), request.correlationId(), request.book())));
    }

    public ReconBreakView resolve(long breakId, String note, String actor) {
        return ReconBreakView.from(workflowService.resolveManual(breakId, note, actor));
    }

    public ReconBreakView writeOff(long breakId, String reason, String approver) {
        return ReconBreakView.from(workflowService.writeOff(breakId, reason, approver));
    }

    public List<AgingAlertView> agingAlerts() {
        return workflowService.agingAlerts().stream().map(AgingAlertView::from).toList();
    }

    public record ReconRunRequest(ReconType type, String book, LocalDate tradeDate, Instant asOf) {}

    public record ReconRunResponse(
            long runId,
            String type,
            String book,
            LocalDate tradeDate,
            Instant asOf,
            String status,
            int breaksDetected,
            Instant tcsWatermark,
            Instant downstreamWatermark) {

        static ReconRunResponse from(ReconRun run) {
            return new ReconRunResponse(
                    run.runId(),
                    run.reconType().name(),
                    run.scope().book(),
                    run.scope().tradeDate(),
                    run.asOf(),
                    run.status(),
                    run.breaksDetected(),
                    run.tcsWatermark(),
                    run.downstreamWatermark());
        }
    }

    public record ReconBreakView(
            long breakId,
            long runId,
            String breakClass,
            String breakType,
            String allocationId,
            String swapRef,
            String lotRef,
            String status,
            boolean autoHealEligible,
            String tcsValueJson,
            String peerValueJson) {

        static ReconBreakView from(ReconBreak row) {
            return new ReconBreakView(
                    row.breakId(),
                    row.runId(),
                    row.breakClass().name(),
                    row.breakType().name(),
                    row.allocationId(),
                    row.swapRef(),
                    row.lotRef(),
                    row.status().name(),
                    row.autoHealEligible(),
                    row.tcsValueJson(),
                    row.peerValueJson());
        }
    }

    public record AutoHealRequest(UUID ingestionId, String correlationId, String book) {}

    public record AgingAlertView(long breakId, int escalationHours, String breakType, String status) {
        static AgingAlertView from(BreakWorkflowService.AgingAlert alert) {
            return new AgingAlertView(
                    alert.breakId(),
                    alert.escalationHours(),
                    alert.breakType().name(),
                    alert.status().name());
        }
    }
}
