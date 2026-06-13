package com.pb.tcs.manual;

import com.pb.tcs.approval.ApprovalGate;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.rules.BlotterAssembler;
import com.pb.tcs.rules.RuleExplain;
import com.pb.tcs.rules.SwapBlotter;
import java.util.List;

/** FR-500 dry-run preview: rules + gate outcome without persist/publish. */
public final class ManualTradePreviewService {

    private final BlotterAssembler assembler;
    private final ApprovalGate gate;

    public ManualTradePreviewService(BlotterAssembler assembler, ApprovalGate gate) {
        this.assembler = assembler;
        this.gate = gate;
    }

    public PreviewResult preview(EnrichedAllocation allocation, String initiatedBy) {
        BlotterAssembler.Assembly assembly = assembler.assemble(allocation);
        boolean requiresApproval =
                gate.requiresApproval(allocation.envelope().getSource(), initiatedBy);
        return new PreviewResult(
                assembly.blotter(),
                assembly.explains(),
                requiresApproval ? "APPROVAL_REQUIRED" : "STP_PASS");
    }

    public record PreviewResult(
            SwapBlotter blotter, List<RuleExplain> explains, String gateOutcome) {}
}
