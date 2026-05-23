package com.pb.swap.rules.admin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pb.swap.rules.admin.service.SimulationService;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.core.model.RuleDefinition;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rules")
public class SimulationController {
    private final SimulationService simulationService;
    private final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @PostMapping("/simulate")
    public ResponseEntity<List<SimulationService.SimulationDiff>> simulate(
            @RequestBody Map<String, Object> body) {
        RuleDefinition draft = mapper.convertValue(body.get("draft"), RuleDefinition.class);
        List<RawHedgeTrade> trades =
                ((List<?>) body.get("trades"))
                        .stream()
                        .map(t -> mapper.convertValue(t, RawHedgeTrade.class))
                        .toList();
        return ResponseEntity.ok(simulationService.simulate(draft, trades));
    }
}
