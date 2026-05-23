package com.pb.swap.rules.admin.controller;

import com.pb.swap.rules.core.model.EnrichedEquitySwap;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.core.schema.SchemaDescriptor;
import com.pb.swap.rules.core.schema.SchemaService;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes the dynamic schema for both ends of the rules engine domain so the studio UI can drive
 * its dropdowns purely from server-side metadata.
 */
@RestController
@RequestMapping("/api/v1/schema")
public class SchemaController {

    private final SchemaService schemaService;

    public SchemaController(SchemaService schemaService) {
        this.schemaService = schemaService;
    }

    @GetMapping("/trade")
    public SchemaDescriptor trade() {
        return schemaService.describe("trade", RawHedgeTrade.class);
    }

    @GetMapping("/swap")
    public SchemaDescriptor swap() {
        return schemaService.describe("swap", EnrichedEquitySwap.class);
    }

    @GetMapping
    public Map<String, List<SchemaDescriptor>> all() {
        return Map.of("schemas", List.of(trade(), swap()));
    }
}
