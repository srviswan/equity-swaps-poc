package com.pb.swap.rules.admin.controller;

import com.pb.swap.rules.admin.dedup.DuplicationGuard;
import com.pb.swap.rules.admin.dedup.DuplicationReport;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.store.entity.RuleDefinitionEntity;
import com.pb.swap.rules.store.entity.RuleDefinitionId;
import com.pb.swap.rules.store.mapper.RuleJsonMapper;
import com.pb.swap.rules.store.repo.RuleDefinitionRepository;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rules")
public class RulesController {
    private final RuleDefinitionRepository repository;
    private final DuplicationGuard guard;
    private final RuleJsonMapper mapper = new RuleJsonMapper();

    public RulesController(RuleDefinitionRepository repository, DuplicationGuard guard) {
        this.repository = repository;
        this.guard = guard;
    }

    @GetMapping
    public ResponseEntity<List<RuleDefinition>> list() {
        List<RuleDefinition> out = new ArrayList<>();
        for (RuleDefinitionEntity e : repository.findAll()) {
            try {
                out.add(mapper.toRule(e));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return ResponseEntity.ok(out);
    }

    /** Pure inspection: returns a {@link DuplicationReport} without persisting anything. */
    @PostMapping("/inspect")
    public DuplicationReport inspect(@RequestBody RuleDefinition rule) {
        return guard.inspectRule(rule);
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody RuleDefinition rule,
            @RequestParam(name = "force", defaultValue = "false") boolean force)
            throws Exception {
        DuplicationReport report = guard.inspectRule(rule);
        if (report.hasErrors() && !force) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(report);
        }
        RuleDefinitionEntity entity = toEntity(rule);
        repository.save(entity);
        return ResponseEntity.ok(rule);
    }

    @PutMapping("/{id}/versions/{version}")
    public ResponseEntity<RuleDefinition> update(
            @PathVariable String id, @PathVariable int version, @RequestBody RuleDefinition rule)
            throws Exception {
        RuleDefinitionEntity entity = toEntity(rule);
        entity.setId(new RuleDefinitionId(id, version));
        repository.save(entity);
        return ResponseEntity.ok(rule);
    }

    @GetMapping("/{id}/versions/{version}")
    public ResponseEntity<RuleDefinition> get(@PathVariable String id, @PathVariable int version)
            throws Exception {
        return repository
                .findById(new RuleDefinitionId(id, version))
                .map(
                        e -> {
                            try {
                                return ResponseEntity.ok(mapper.toRule(e));
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                .orElse(ResponseEntity.notFound().build());
    }

    private RuleDefinitionEntity toEntity(RuleDefinition rule) throws Exception {
        RuleDefinitionEntity entity = new RuleDefinitionEntity();
        entity.setId(new RuleDefinitionId(rule.id(), rule.version()));
        entity.setCategory(rule.category().name());
        entity.setTarget(rule.target().name());
        entity.setEffectiveFrom(
                rule.effectiveFrom() != null ? rule.effectiveFrom() : java.time.LocalDate.now());
        entity.setEffectiveTo(rule.effectiveTo());
        entity.setEnabled(rule.enabled());
        entity.setEvaluationMode(
                rule.evaluationMode() != null ? rule.evaluationMode().name() : null);
        entity.setSpecificityBoost(
                rule.specificityBoost() != null
                        ? java.math.BigDecimal.valueOf(rule.specificityBoost())
                        : null);
        entity.setBody(mapper.toJson(rule));
        entity.setStatus(rule.status() != null ? rule.status().name() : "DRAFT");
        entity.setCreatedAt(Instant.now());
        return entity;
    }
}
