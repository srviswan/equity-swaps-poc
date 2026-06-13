package com.pb.swap.rules.admin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pb.swap.rules.core.api.EnrichmentResult;
import com.pb.swap.rules.core.compile.RuleCompiler;
import com.pb.swap.rules.core.model.ActionTemplate;
import com.pb.swap.rules.core.model.CriteriaFragment;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.model.RuleStatus;
import com.pb.swap.rules.core.pipeline.DefaultPipelineFactory;
import com.pb.swap.rules.core.snapshot.RuleSnapshot;
import com.pb.swap.rules.core.trace.DecisionRecord;
import com.pb.swap.rules.core.trace.DecisionTrace;
import com.pb.swap.rules.core.trace.TraceSink;
import com.pb.swap.rules.runtime.engine.EnrichmentEngineImpl;
import com.pb.swap.rules.runtime.observability.EnrichmentMetrics;
import com.pb.swap.rules.store.entity.ActionTemplateEntity;
import com.pb.swap.rules.store.entity.CriteriaFragmentEntity;
import com.pb.swap.rules.store.mapper.RuleJsonMapper;
import com.pb.swap.rules.store.repo.ActionTemplateRepository;
import com.pb.swap.rules.store.repo.CriteriaFragmentRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.stereotype.Service;

@Service
public class SimulationService {
    private final SnapshotHolder snapshotHolder;
    private final RuleCompiler compiler;
    private final ActionTemplateRepository templateRepo;
    private final CriteriaFragmentRepository fragmentRepo;
    private final RuleJsonMapper mapper = new RuleJsonMapper();
    private final ObjectMapper json =
            new ObjectMapper().registerModule(new JavaTimeModule());

    public SimulationService(
            SnapshotHolder snapshotHolder,
            RuleCompiler compiler,
            ActionTemplateRepository templateRepo,
            CriteriaFragmentRepository fragmentRepo) {
        this.snapshotHolder = snapshotHolder;
        this.compiler = compiler;
        this.templateRepo = templateRepo;
        this.fragmentRepo = fragmentRepo;
    }

    public List<SimulationDiff> simulate(RuleDefinition draft, List<RawHedgeTrade> samples) {
        RuleSnapshot base = snapshotHolder.get();
        List<RuleDefinition> rules = new ArrayList<>();
        base.allBuckets()
                .values()
                .forEach(
                        b ->
                                b.rules()
                                        .forEach(
                                                r -> {
                                                    if (r.source() != null
                                                            && !r.source().id().equals(draft.id())) {
                                                        rules.add(r.source());
                                                    }
                                                }));
        // Compiler skips non-PUBLISHED rules — promote draft temporarily for simulation only.
        RuleDefinition draftForSim =
                new RuleDefinition(
                        draft.id(),
                        draft.version(),
                        draft.name(),
                        draft.category(),
                        draft.target(),
                        draft.priority(),
                        draft.enabled(),
                        draft.effectiveFrom() != null ? draft.effectiveFrom() : LocalDate.now().minusDays(1),
                        draft.effectiveTo(),
                        draft.evaluationMode(),
                        draft.specificityBoost(),
                        RuleStatus.PUBLISHED,
                        draft.criteria(),
                        draft.includes(),
                        draft.apply(),
                        draft.actions(),
                        draft.overrides(),
                        draft.metadata());
        rules.add(draftForSim);
        List<ActionTemplate> templates = loadTemplates();
        List<CriteriaFragment> fragments = loadFragments();
        RuleSnapshot simSnap = compiler.compileFullRange(rules, templates, fragments);
        return compareSnapshots(base, simSnap, samples, draft.id());
    }

    /** Simulates the fully merged projected rule set in one pass (FR-508). */
    public List<SimulationDiff> simulateProjectedRules(
            List<RuleDefinition> projectedPublishedRules, List<RawHedgeTrade> samples) {
        RuleSnapshot base = snapshotHolder.get();
        RuleSnapshot simSnap =
                compiler.compileFullRange(
                        projectedPublishedRules, loadTemplates(), loadFragments());
        return compareSnapshots(base, simSnap, samples, null);
    }

    private List<SimulationDiff> compareSnapshots(
            RuleSnapshot base,
            RuleSnapshot simSnap,
            List<RawHedgeTrade> samples,
            String touchedRuleId) {
        EnrichmentEngineImpl simEngine =
                new EnrichmentEngineImpl(
                        new AtomicReference<>(simSnap),
                        DefaultPipelineFactory.equitySwapPipeline(),
                        TraceSink.NOOP,
                        EnrichmentMetrics.noop());
        EnrichmentEngineImpl baseEngine =
                new EnrichmentEngineImpl(
                        new AtomicReference<>(base),
                        DefaultPipelineFactory.equitySwapPipeline(),
                        TraceSink.NOOP,
                        EnrichmentMetrics.noop());
        List<SimulationDiff> out = new ArrayList<>();
        for (RawHedgeTrade trade : samples) {
            EnrichmentResult before = baseEngine.enrich(trade);
            EnrichmentResult after = simEngine.enrich(trade);
            Map<String, Map<String, Object>> diffs = computePathDiffs(before.trace(), after.trace());
            long draftApplications =
                    touchedRuleId == null
                            ? 0
                            : after.trace().decisions().stream()
                                    .filter(d -> d.ruleId().equals(touchedRuleId))
                                    .count();
            out.add(
                    new SimulationDiff(
                            trade.tradeId(),
                            json.convertValue(after.swap(), Map.class),
                            after.trace().traceId(),
                            diffs,
                            draftApplications));
        }
        return out;
    }

    private List<ActionTemplate> loadTemplates() {
        List<ActionTemplate> templates = new ArrayList<>();
        for (ActionTemplateEntity e : templateRepo.findAll()) {
            try {
                templates.add(mapper.toTemplate(e));
            } catch (Exception ex) {
                /* skip */
            }
        }
        return templates;
    }

    private List<CriteriaFragment> loadFragments() {
        List<CriteriaFragment> fragments = new ArrayList<>();
        for (CriteriaFragmentEntity e : fragmentRepo.findAll()) {
            try {
                fragments.add(mapper.toFragment(e));
            } catch (Exception ex) {
                /* skip */
            }
        }
        return fragments;
    }

    private Map<String, Map<String, Object>> computePathDiffs(DecisionTrace before, DecisionTrace after) {
        Map<String, Object> beforeMap = new LinkedHashMap<>();
        for (DecisionRecord d : before.decisions()) {
            for (String p : d.paths()) beforeMap.put(p, d.after());
        }
        Map<String, Object> afterMap = new LinkedHashMap<>();
        for (DecisionRecord d : after.decisions()) {
            for (String p : d.paths()) afterMap.put(p, d.after());
        }
        Map<String, Map<String, Object>> diffs = new LinkedHashMap<>();
        for (String path : afterMap.keySet()) {
            Object b = beforeMap.get(path);
            Object a = afterMap.get(path);
            if (!java.util.Objects.equals(b, a)) {
                Map<String, Object> entry = new LinkedHashMap<>();
                entry.put("before", b);
                entry.put("after", a);
                diffs.put(path, entry);
            }
        }
        for (String path : beforeMap.keySet()) {
            if (!afterMap.containsKey(path)) {
                Map<String, Object> entry = new LinkedHashMap<>();
                entry.put("before", beforeMap.get(path));
                entry.put("after", null);
                diffs.put(path, entry);
            }
        }
        return diffs;
    }

    public record SimulationDiff(
            String tradeId,
            Object swap,
            String traceId,
            Map<String, Map<String, Object>> diffs,
            long draftApplications) {}
}
