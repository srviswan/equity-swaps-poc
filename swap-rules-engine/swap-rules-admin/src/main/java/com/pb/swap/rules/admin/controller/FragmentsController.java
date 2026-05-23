package com.pb.swap.rules.admin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pb.swap.rules.admin.dedup.DuplicationGuard;
import com.pb.swap.rules.admin.dedup.DuplicationReport;
import com.pb.swap.rules.core.model.CriteriaFragment;
import com.pb.swap.rules.store.entity.CriteriaFragmentEntity;
import com.pb.swap.rules.store.entity.TemplateId;
import com.pb.swap.rules.store.mapper.RuleJsonMapper;
import com.pb.swap.rules.store.repo.CriteriaFragmentRepository;
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
@RequestMapping("/api/v1/fragments")
public class FragmentsController {
    private final CriteriaFragmentRepository repository;
    private final DuplicationGuard guard;
    private final ObjectMapper mapper = new ObjectMapper();
    private final RuleJsonMapper jsonMapper = new RuleJsonMapper();

    public FragmentsController(CriteriaFragmentRepository repository, DuplicationGuard guard) {
        this.repository = repository;
        this.guard = guard;
    }

    @GetMapping
    public ResponseEntity<List<CriteriaFragment>> list() {
        List<CriteriaFragment> out = new ArrayList<>();
        for (CriteriaFragmentEntity e : repository.findAll()) {
            try {
                out.add(jsonMapper.toFragment(e));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return ResponseEntity.ok(out);
    }

    @PostMapping("/inspect")
    public DuplicationReport inspect(@RequestBody CriteriaFragment fragment) {
        return guard.inspectFragment(fragment);
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody CriteriaFragment fragment,
            @RequestParam(name = "force", defaultValue = "false") boolean force)
            throws Exception {
        DuplicationReport report = guard.inspectFragment(fragment);
        if (report.hasErrors() && !force) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(report);
        }
        CriteriaFragmentEntity entity = new CriteriaFragmentEntity();
        entity.setId(new TemplateId(fragment.id(), fragment.version()));
        entity.setStatus(fragment.status().name());
        entity.setBody(
                mapper.writeValueAsString(
                        new RuleJsonMapper.FragmentBody(fragment.criteria(), fragment.metadata())));
        repository.save(entity);
        return ResponseEntity.ok(fragment);
    }
}
