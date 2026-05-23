package com.pb.swap.rules.admin.controller;

import com.pb.swap.rules.admin.dedup.DuplicationGuard;
import com.pb.swap.rules.admin.dedup.DuplicationReport;
import com.pb.swap.rules.admin.service.SnapshotHolder;
import com.pb.swap.rules.core.compile.CompiledRule;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.snapshot.RuleSnapshot;
import com.pb.swap.rules.core.snapshot.TargetBucket;
import com.pb.swap.rules.store.entity.RuleDefinitionEntity;
import com.pb.swap.rules.store.mapper.RuleJsonMapper;
import com.pb.swap.rules.store.repo.RuleDefinitionRepository;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/snapshot")
public class SnapshotController {
    private final SnapshotHolder holder;
    private final DuplicationGuard guard;
    private final RuleDefinitionRepository ruleRepo;
    private final RuleJsonMapper mapper = new RuleJsonMapper();

    public SnapshotController(
            SnapshotHolder holder, DuplicationGuard guard, RuleDefinitionRepository ruleRepo) {
        this.holder = holder;
        this.guard = guard;
        this.ruleRepo = ruleRepo;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> current() {
        RuleSnapshot snap = holder.get();
        List<Map<String, Object>> bucketSummaries = new ArrayList<>();
        int totalRules = 0;
        for (TargetBucket bucket : snap.allBuckets().values()) {
            totalRules += bucket.rules().size();
            List<Map<String, Object>> rulesSummary = new ArrayList<>();
            for (CompiledRule r : bucket.rules()) {
                Map<String, Object> rule = new LinkedHashMap<>();
                rule.put("ruleId", r.ruleId());
                rule.put("name", r.name() != null ? r.name() : "");
                rule.put("specificity", r.specificity());
                rule.put("priority", r.priority());
                rule.put("evaluationMode", r.evaluationMode().name());
                rule.put("fragmentIds", r.fragmentIds());
                rule.put("templateIds", r.templateIds());
                rulesSummary.add(rule);
            }
            Map<String, Object> b = new LinkedHashMap<>();
            b.put("category", bucket.category().name());
            b.put("target", bucket.target().name());
            b.put("evaluationMode", bucket.evaluationMode().name());
            b.put("ruleCount", bucket.rules().size());
            b.put("rules", rulesSummary);
            bucketSummaries.add(b);
        }

        // Snapshot-wide duplication advisory (twins + soft shadows). Computed on demand against
        // every PUBLISHED rule the DB knows about, since the runtime snapshot drops bookkeeping
        // (includes/apply IDs are kept, but full criteria/action semantics live in the DB row).
        List<RuleDefinition> published = new ArrayList<>();
        for (RuleDefinitionEntity e : ruleRepo.findAll()) {
            if (!"PUBLISHED".equals(e.getStatus())) continue;
            try {
                published.add(mapper.toRule(e));
            } catch (Exception ignored) {
                // skip malformed; not a deal-breaker for the snapshot endpoint
            }
        }
        List<DuplicationReport.Finding> findings = guard.scanSnapshot(published);

        Map<String, Object> resp = new LinkedHashMap<>();
        resp.put("snapshotId", snap.snapshotId());
        resp.put("publishedAt", snap.publishedAt().toString());
        resp.put("checksum", snap.checksum());
        resp.put("version", snap.version());
        resp.put("totalRules", totalRules);
        resp.put("buckets", bucketSummaries);
        resp.put("duplicationFindings", findings);
        return ResponseEntity.ok(resp);
    }
}
