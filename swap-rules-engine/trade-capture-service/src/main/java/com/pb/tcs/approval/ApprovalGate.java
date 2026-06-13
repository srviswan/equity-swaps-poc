package com.pb.tcs.approval;

import com.pb.tcs.config.ApprovalWorkflowConfig;
import com.pb.tcs.proto.allocation.v1.SourceSystem;

/** Stage-5.5 STP evaluation (FR-301). */
public final class ApprovalGate {

    private final ApprovalWorkflowConfig config;

    public ApprovalGate(ApprovalWorkflowConfig config) {
        this.config = config;
    }

    public boolean requiresApproval(SourceSystem source, String initiatedBy) {
        return !config.isStp(source.name(), initiatedBy);
    }
}
