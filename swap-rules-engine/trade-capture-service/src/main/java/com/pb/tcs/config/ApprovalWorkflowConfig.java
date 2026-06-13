package com.pb.tcs.config;

import java.time.Duration;
import java.util.List;
import java.util.Set;

/** Stage-5.5 approval gate policy (FR-301 / D17). */
public record ApprovalWorkflowConfig(
        Duration approvalTimeout,
        int bulkMaxRows,
        StpPolicy stp) {

    public record StpPolicy(Set<String> sources, Set<String> initiators) {}

    public boolean isStp(String sourceSystem, String initiatedBy) {
        if (stp.sources().contains(sourceSystem)) {
            return true;
        }
        return stp.initiators().contains(initiatedBy);
    }
}
