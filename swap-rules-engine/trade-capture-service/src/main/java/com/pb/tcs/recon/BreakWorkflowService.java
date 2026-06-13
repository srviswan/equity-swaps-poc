package com.pb.tcs.recon;

import com.pb.tcs.config.ReconPolicyConfig;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/** FR-704 break workflow + FR-707 aging escalation. */
public final class BreakWorkflowService {

    private final ReconStore store;
    private final ReconPolicyConfig policy;
    private final AutoHealDispatcher autoHealDispatcher;
    private final Clock clock;

    public BreakWorkflowService(
            ReconStore store,
            ReconPolicyConfig policy,
            AutoHealDispatcher autoHealDispatcher,
            Clock clock) {
        this.store = store;
        this.policy = policy;
        this.autoHealDispatcher = autoHealDispatcher;
        this.clock = clock;
    }

    public ReconBreak acknowledge(long breakId, String actor) {
        ReconBreak row = requireBreak(breakId);
        ReconBreak updated =
                row.withStatus(BreakStatus.ACKNOWLEDGED, "ack by " + actor, actor, clock.instant());
        store.updateBreak(updated);
        return updated;
    }

    public ReconBreak heal(long breakId, AutoHealContext context) {
        ReconBreak row = requireBreak(breakId);
        AutoHealDispatcher.HealResult result = autoHealDispatcher.heal(row, context.ingestionId(), context.correlationId(), context.book());
        if ("REJECTED".equals(result.outcome())) {
            throw new IllegalStateException("auto-heal rejected: " + result.action());
        }
        ReconBreak updated = row.withStatus(BreakStatus.HEALING, result.action(), "auto-heal", clock.instant());
        store.updateBreak(updated);
        return updated;
    }

    public ReconBreak resolveManual(long breakId, String note, String actor) {
        ReconBreak row = requireBreak(breakId);
        ReconBreak updated =
                row.withStatus(BreakStatus.RESOLVED_MANUAL, note, actor, clock.instant());
        store.updateBreak(updated);
        return updated;
    }

    public ReconBreak writeOff(long breakId, String reason, String approver) {
        if (reason == null || reason.isBlank()) {
            throw new IllegalArgumentException("write-off requires reason");
        }
        if (approver == null || approver.isBlank()) {
            throw new IllegalArgumentException("write-off requires approver");
        }
        ReconBreak row = requireBreak(breakId);
        ReconBreak updated =
                row.withStatus(BreakStatus.WRITTEN_OFF, reason, approver, clock.instant());
        store.updateBreak(updated);
        return updated;
    }

    public List<AgingAlert> agingAlerts() {
        Instant now = clock.instant();
        List<AgingAlert> alerts = new ArrayList<>();
        for (ReconBreak open : store.findOpenBreaks()) {
            Duration age = Duration.between(open.detectedAt(), now);
            for (int hours : policy.escalationHours()) {
                if (age.toHours() >= hours) {
                    alerts.add(new AgingAlert(open.breakId(), hours, open.breakType(), open.status()));
                }
            }
        }
        return alerts;
    }

    private ReconBreak requireBreak(long breakId) {
        return store.findBreakById(breakId).orElseThrow(() -> new IllegalArgumentException("unknown break " + breakId));
    }

    public record AutoHealContext(java.util.UUID ingestionId, String correlationId, String book) {}

    public record AgingAlert(long breakId, int escalationHours, BreakType breakType, BreakStatus status) {}
}
