package com.pb.swap.rules.admin.changeset;

import com.pb.swap.rules.admin.service.SimulationService;
import com.pb.swap.rules.admin.service.SnapshotConflictDetector;
import com.pb.swap.rules.core.compile.RuleCompiler;
import com.pb.swap.rules.core.model.ActionTemplate;
import com.pb.swap.rules.core.model.CriteriaFragment;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.core.model.RuleDefinition;
import java.time.LocalDate;
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
        List<RuleDefinition> projected =
                ChangesetRuleSupport.promoteToPublished(ChangesetMerger.merge(baseRules, changeset));
        Optional<String> conflict =
                SnapshotConflictDetector.detect(compiler, projected, templates, fragments);
        if (conflict.isPresent()) {
            changeset.markRejected();
            return SimulationReport.blocked(conflict.get());
        }
        List<SimulationService.SimulationDiff> diffs =
                simulationService.simulateProjectedRules(projected, samples);
        changeset.markSimulated();
        return SimulationReport.ok(diffs);
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
