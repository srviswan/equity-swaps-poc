package com.pb.swap.rules.admin.changeset;

import com.pb.swap.rules.admin.service.SimulationService;
import com.pb.swap.rules.admin.service.SnapshotConflictDetector;
import com.pb.swap.rules.core.compile.RuleCompiler;
import com.pb.swap.rules.core.model.ActionTemplate;
import com.pb.swap.rules.core.model.CriteriaFragment;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.model.RuleStatus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/** FR-508 batch simulation for an entire changeset. */
@Service
public final class ChangesetSimulationService {

    private final RuleCompiler compiler;
    private final SimulationService simulationService;

    public ChangesetSimulationService(RuleCompiler compiler, SimulationService simulationService) {
        this.compiler = compiler;
        this.simulationService = simulationService;
    }

    public SimulationReport simulate(
            RuleChangeset changeset,
            List<RuleDefinition> baseRules,
            List<ActionTemplate> templates,
            List<CriteriaFragment> fragments,
            List<RawHedgeTrade> samples) {
        List<RuleDefinition> projected = promoteChanged(ChangesetMerger.merge(baseRules, changeset));
        Optional<String> conflict =
                SnapshotConflictDetector.detect(
                        compiler, projected, templates, fragments, LocalDate.now());
        if (conflict.isPresent()) {
            changeset.markRejected();
            return SimulationReport.blocked(conflict.get());
        }
        List<SimulationService.SimulationDiff> perRule = new ArrayList<>();
        for (RuleDefinition touched :
                projected.stream().filter(r -> isTouched(changeset, r)).toList()) {
            perRule.addAll(simulationService.simulate(touched, samples));
        }
        changeset.markSimulated();
        return SimulationReport.ok(perRule);
    }

    private static List<RuleDefinition> promoteChanged(List<RuleDefinition> projected) {
        return projected.stream().map(ChangesetSimulationService::asPublished).toList();
    }

    private static RuleDefinition asPublished(RuleDefinition rule) {
        if (rule.status() == RuleStatus.PUBLISHED) {
            return rule;
        }
        return new RuleDefinition(
                rule.id(),
                rule.version(),
                rule.name(),
                rule.category(),
                rule.target(),
                rule.priority(),
                rule.enabled(),
                rule.effectiveFrom(),
                rule.effectiveTo(),
                rule.evaluationMode(),
                rule.specificityBoost(),
                RuleStatus.PUBLISHED,
                rule.criteria(),
                rule.includes(),
                rule.apply(),
                rule.actions(),
                rule.overrides(),
                rule.metadata());
    }

    private static boolean isTouched(RuleChangeset changeset, RuleDefinition rule) {
        return changeset.changes().stream()
                .anyMatch(
                        c ->
                                (c.operation() == RuleChange.Operation.UPSERT_RULE
                                                && c.payload().rule() != null
                                                && c.payload().rule().id().equals(rule.id())
                                                && c.payload().rule().version() == rule.version())
                                        || (c.ruleId() != null
                                                && c.ruleId().equals(rule.id())
                                                && c.version() == rule.version())
                                        || (c.operation() == RuleChange.Operation.CLONE_RULE
                                                && c.payload().cloneTargetId() != null
                                                && c.payload().cloneTargetId().equals(rule.id())));
    }

    public record SimulationReport(
            boolean allowed, String blockReason, List<SimulationService.SimulationDiff> diffs) {

        static SimulationReport blocked(String reason) {
            return new SimulationReport(false, reason, List.of());
        }

        static SimulationReport ok(List<SimulationService.SimulationDiff> diffs) {
            return new SimulationReport(true, null, diffs);
        }
    }
}
