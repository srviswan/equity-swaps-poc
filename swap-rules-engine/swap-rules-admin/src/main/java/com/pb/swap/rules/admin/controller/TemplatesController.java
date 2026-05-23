package com.pb.swap.rules.admin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pb.swap.rules.admin.dedup.DuplicationGuard;
import com.pb.swap.rules.admin.dedup.DuplicationReport;
import com.pb.swap.rules.core.model.ActionTemplate;
import com.pb.swap.rules.store.entity.ActionTemplateEntity;
import com.pb.swap.rules.store.entity.TemplateId;
import com.pb.swap.rules.store.mapper.RuleJsonMapper;
import com.pb.swap.rules.store.repo.ActionTemplateRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/templates")
public class TemplatesController {
    private final ActionTemplateRepository repository;
    private final DuplicationGuard guard;
    private final ObjectMapper mapper = new ObjectMapper();
    private final RuleJsonMapper jsonMapper = new RuleJsonMapper();

    public TemplatesController(ActionTemplateRepository repository, DuplicationGuard guard) {
        this.repository = repository;
        this.guard = guard;
    }

    @GetMapping
    public ResponseEntity<List<ActionTemplate>> list() {
        List<ActionTemplate> out = new ArrayList<>();
        for (ActionTemplateEntity e : repository.findAll()) {
            try {
                out.add(jsonMapper.toTemplate(e));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return ResponseEntity.ok(out);
    }

    @PostMapping("/inspect")
    public DuplicationReport inspect(@RequestBody ActionTemplate template) {
        return guard.inspectTemplate(template);
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody ActionTemplate template,
            @RequestParam(name = "force", defaultValue = "false") boolean force)
            throws Exception {
        DuplicationReport report = guard.inspectTemplate(template);
        if (report.hasErrors() && !force) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(report);
        }
        ActionTemplateEntity entity = new ActionTemplateEntity();
        entity.setId(new TemplateId(template.id(), template.version()));
        entity.setTarget(template.target().name());
        entity.setStatus(template.status().name());
        entity.setBody(
                mapper.writeValueAsString(
                        new RuleJsonMapper.TemplateBody(template.actions(), template.metadata())));
        repository.save(entity);
        return ResponseEntity.ok(template);
    }
}
