package com.pb.tcs.routing;

import com.pb.tcs.config.PositionMatchKeyConfig;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.repair.RepairStore;
import com.pb.tcs.rules.BlotterJson;
import com.pb.tcs.rules.SwapBlotter;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Pipeline stage 7 (FR-304/305): routes the validated blotter and types the business event per
 * target.
 *
 * <p>D11: no-lookup targets (System A) always receive {@code NEW} — the target derives the event
 * internally. D12: explicit-event-type targets (System B) get a PositionService lookup with the
 * system's match key (FR-306) and a derived NEW/TOP_UP/UNWIND; the decision is persisted
 * immediately with no dependency on any other target (D13). On lookup failure the whole trade
 * quarantines (BUSINESS_VALIDATION) — the event type is never guessed (arch §15.2).
 */
public final class RoutingStage {

    private final RoutingEngine engine;
    private final MatchKeyBuilder matchKeys;
    private final PositionServiceClient positionService;
    private final RoutingDecisionStore decisionStore;
    private final RepairStore repairStore;

    public RoutingStage(
            RoutingEngine engine,
            MatchKeyBuilder matchKeys,
            PositionServiceClient positionService,
            RoutingDecisionStore decisionStore,
            RepairStore repairStore) {
        this.engine = engine;
        this.matchKeys = matchKeys;
        this.positionService = positionService;
        this.decisionStore = decisionStore;
        this.repairStore = repairStore;
    }

    public sealed interface Outcome {
        record Routed(List<RoutingDecision> decisions) implements Outcome {}

        record Quarantined(long quarantineId, String reason) implements Outcome {}
    }

    public Outcome process(EnrichedAllocation allocation, SwapBlotter blotter) {
        RoutingContext context = RoutingContext.of(allocation, blotter);
        RoutingEngine.Route route = engine.route(context);
        List<RoutingDecision> decisions = new ArrayList<>();
        for (String targetId : route.targets()) {
            try {
                decisions.add(decide(route.ruleName(), targetId, allocation, blotter, context));
            } catch (PositionServiceClient.PositionLookupException e) {
                long quarantineId =
                        repairStore.open(
                                "BUSINESS_VALIDATION",
                                blotter.correlationId(),
                                "POSITION_LOOKUP_FAILED %s: %s — event type not guessed (D12)"
                                        .formatted(targetId, e.getMessage()),
                                BlotterJson.toJson(blotter));
                return new Outcome.Quarantined(quarantineId, e.getMessage());
            }
        }
        decisionStore.saveAll(decisions);
        return new Outcome.Routed(decisions);
    }

    private RoutingDecision decide(
            String ruleName,
            String targetId,
            EnrichedAllocation allocation,
            SwapBlotter blotter,
            RoutingContext context) {
        PositionMatchKeyConfig.SystemPolicy policy = matchKeys.policy(targetId);
        String queue = engine.target(targetId).queue();
        if (policy.positionLookup() == PositionMatchKeyConfig.PositionLookup.NEVER) {
            // D11: optimistic NEW; the target distinguishes the event internally.
            return new RoutingDecision(
                    blotter.correlationId(),
                    blotter.tradeDate(),
                    ruleName,
                    targetId,
                    queue,
                    EventTypeDeriver.EventType.NEW,
                    Map.of(),
                    null);
        }
        Map<String, String> matchKey = matchKeys.matchKey(targetId, context);
        Optional<PositionServiceClient.PositionSnapshot> snapshot =
                positionService.lookup(matchKey);
        EventTypeDeriver.EventType eventType =
                EventTypeDeriver.derive(
                        snapshot,
                        BigDecimal.valueOf(allocation.message().getQuantity()),
                        allocation.message().getDirection());
        Instant asOf = snapshot.map(PositionServiceClient.PositionSnapshot::asOf).orElse(null);
        return new RoutingDecision(
                blotter.correlationId(),
                blotter.tradeDate(),
                ruleName,
                targetId,
                queue,
                eventType,
                matchKey,
                asOf);
    }
}
