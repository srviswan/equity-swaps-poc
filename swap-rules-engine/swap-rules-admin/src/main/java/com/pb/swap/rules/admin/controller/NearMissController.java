package com.pb.swap.rules.admin.controller;

import com.pb.swap.rules.admin.dto.NearMissResponse;
import com.pb.swap.rules.admin.nearmiss.NearMissScorer;
import com.pb.swap.rules.admin.nearmiss.RuleDraftBuilder;
import com.pb.swap.rules.admin.service.SnapshotHolder;
import com.pb.swap.rules.core.compile.RuleCompiler;
import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.store.entity.RuleDefinitionEntity;
import com.pb.swap.rules.store.entity.RuleDefinitionId;
import com.pb.swap.rules.store.mapper.RuleJsonMapper;
import com.pb.swap.rules.store.repo.RuleDefinitionRepository;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rules")
public class NearMissController {
    private final SnapshotHolder snapshotHolder;
    private final RuleCompiler compiler;
    private final RuleDefinitionRepository ruleRepo;
    private final RuleJsonMapper mapper = new RuleJsonMapper();

    public NearMissController(
            SnapshotHolder snapshotHolder, RuleCompiler compiler, RuleDefinitionRepository ruleRepo) {
        this.snapshotHolder = snapshotHolder;
        this.compiler = compiler;
        this.ruleRepo = ruleRepo;
    }

    @PostMapping("/near-miss")
    public ResponseEntity<List<NearMissResponse>> nearMiss(
            @RequestBody RawHedgeTrade trade,
            @RequestParam EnrichmentTarget target,
            @RequestParam(defaultValue = "5") int top) {
        NearMissScorer scorer = new NearMissScorer(snapshotHolder.get(), compiler);
        List<NearMissResponse> responses =
                scorer.score(trade, target, top).stream()
                        .map(
                                r ->
                                        new NearMissResponse(
                                                r.ruleId(),
                                                r.ruleVersion(),
                                                r.score(),
                                                r.missingCriteria()))
                        .toList();
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/from-candidate")
    public ResponseEntity<RuleDefinition> fromCandidate(
            @RequestBody Map<String, Object> body) throws Exception {
        String ruleId = (String) body.get("ruleId");
        int version = ((Number) body.get("version")).intValue();
        RawHedgeTrade trade = mapper.readTrade(body.get("trade"));
        RuleDefinitionEntity entity =
                ruleRepo
                        .findById(new RuleDefinitionId(ruleId, version))
                        .orElseThrow();
        RuleDefinition candidate = mapper.toRule(entity);
        NearMissScorer scorer = new NearMissScorer(snapshotHolder.get(), compiler);
        var nearMisses = scorer.score(trade, candidate.target(), 1);
        NearMissScorer.NearMissResult best = nearMisses.isEmpty() ? null : nearMisses.get(0);
        RuleDefinition draft =
                new RuleDraftBuilder()
                        .fromCandidate(
                                candidate,
                                trade,
                                best != null
                                        ? best
                                        : new NearMissScorer.NearMissResult(
                                                ruleId, version, 0, List.of(), null));
        return ResponseEntity.ok(draft);
    }
}
