package com.pb.swap.rules.admin.controller;

import com.pb.swap.rules.core.api.EnrichmentResult;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.runtime.engine.EnrichmentEngineImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/enrich")
public class EnrichController {
    private final EnrichmentEngineImpl engine;

    public EnrichController(EnrichmentEngineImpl engine) {
        this.engine = engine;
    }

    @PostMapping
    public ResponseEntity<EnrichmentResult> enrich(@RequestBody RawHedgeTrade trade) {
        return ResponseEntity.ok(engine.enrich(trade));
    }
}
