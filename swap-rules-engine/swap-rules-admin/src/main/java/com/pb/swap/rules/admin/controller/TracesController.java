package com.pb.swap.rules.admin.controller;

import com.pb.swap.rules.admin.narrative.TraceNarrator;
import com.pb.swap.rules.admin.service.InMemoryTraceStore;
import com.pb.swap.rules.core.trace.DecisionTrace;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/traces")
public class TracesController {
    private final InMemoryTraceStore store;
    private final TraceNarrator narrator = new TraceNarrator();

    public TracesController(InMemoryTraceStore store) {
        this.store = store;
    }

    @GetMapping("/{traceId}")
    public ResponseEntity<Map<String, Object>> get(@PathVariable String traceId) {
        DecisionTrace trace = store.get(traceId);
        if (trace == null) {
            return ResponseEntity.notFound().build();
        }
        TraceNarrator.TraceNarrative narrative = narrator.narrate(trace);
        return ResponseEntity.ok(
                Map.of("traceId", traceId, "raw", trace, "narrative", narrative.lines()));
    }
}
