package com.pb.swap.rules.admin.controller;

import com.pb.swap.rules.admin.service.PublishService;
import com.pb.swap.rules.core.snapshot.RuleSnapshot;
import java.time.LocalDate;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/snapshots")
public class PublishController {
    private final PublishService publishService;

    public PublishController(PublishService publishService) {
        this.publishService = publishService;
    }

    @PostMapping("/publish")
    public ResponseEntity<Map<String, Object>> publish(
            @RequestParam(required = false) LocalDate asOf) throws Exception {
        LocalDate effective = asOf != null ? asOf : LocalDate.now();
        RuleSnapshot snapshot = publishService.publish(effective);
        return ResponseEntity.ok(
                Map.of(
                        "snapshotId", snapshot.snapshotId(),
                        "checksum", snapshot.checksum(),
                        "version", snapshot.version()));
    }
}
