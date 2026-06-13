package com.pb.swap.rules.admin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pb.swap.rules.admin.changeset.BulkEditService;
import com.pb.swap.rules.admin.changeset.ChangesetPublishService;
import com.pb.swap.rules.admin.changeset.ChangesetService;
import com.pb.swap.rules.admin.changeset.ChangesetSimulationService;
import com.pb.swap.rules.admin.changeset.RuleChangeset;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/changesets")
public class ChangesetController {

    private static final ObjectMapper JSON = new ObjectMapper().registerModule(new JavaTimeModule());

    private final ChangesetService changesetService;

    public ChangesetController(ChangesetService changesetService) {
        this.changesetService = changesetService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> create(@RequestBody Map<String, String> body) {
        RuleChangeset cs = changesetService.create(body.getOrDefault("name", "changeset"), body.get("author"));
        return ResponseEntity.ok(Map.of("changesetId", cs.id(), "status", cs.status().name()));
    }

    @PostMapping("/{id}/bulk-edit")
    public ResponseEntity<?> bulkEdit(
            @PathVariable String id, @RequestBody BulkEditService.BulkEditRequest request) {
        RuleChangeset cs = changesetService.bulkEdit(id, request);
        return ResponseEntity.ok(
                Map.of("changesetId", cs.id(), "changeCount", cs.changes().size(), "status", cs.status().name()));
    }

    @PostMapping("/{id}/simulate")
    public ResponseEntity<?> simulate(@PathVariable String id, @RequestBody Map<String, Object> body) {
        @SuppressWarnings("unchecked")
        List<RawHedgeTrade> trades =
                ((List<?>) body.getOrDefault("trades", List.of()))
                        .stream()
                        .map(
                                t -> JSON.convertValue(t, RawHedgeTrade.class))
                        .toList();
        ChangesetSimulationService.SimulationReport report = changesetService.simulate(id, trades);
        if (!report.allowed()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("blocked", true, "reason", report.blockReason()));
        }
        return ResponseEntity.ok(
                Map.of("allowed", true, "diffCount", report.diffs().size(), "diffs", report.diffs()));
    }

    @PostMapping("/{id}/publish")
    public ResponseEntity<?> publish(
            @PathVariable String id, @RequestParam(required = false) LocalDate asOf) throws Exception {
        ChangesetPublishService.PublishResult result = changesetService.publish(id, asOf);
        if (!result.success()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("published", false, "reason", result.reason()));
        }
        return ResponseEntity.ok(
                Map.of(
                        "published",
                        true,
                        "snapshotId",
                        result.snapshotId(),
                        "snapshotVersion",
                        result.snapshotVersion(),
                        "rulesTouched",
                        result.rulesTouched()));
    }

    @PostMapping("/import")
    public ResponseEntity<Map<String, String>> importYaml(@RequestBody Map<String, String> body)
            throws Exception {
        RuleChangeset cs = changesetService.importYaml(body.get("yaml"), body.get("author"));
        return ResponseEntity.ok(Map.of("changesetId", cs.id(), "changeCount", String.valueOf(cs.changes().size())));
    }

    @GetMapping("/{id}/export")
    public ResponseEntity<String> exportYaml(@PathVariable String id) throws Exception {
        return ResponseEntity.ok(changesetService.exportYaml(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        RuleChangeset cs = changesetService.get(id);
        return ResponseEntity.ok(
                Map.of(
                        "id",
                        cs.id(),
                        "name",
                        cs.name(),
                        "status",
                        cs.status().name(),
                        "changeCount",
                        cs.changes().size()));
    }
}
