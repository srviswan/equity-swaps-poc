package com.pb.tcs.dispatch;

import com.pb.tcs.routing.RoutingDecision;
import com.pb.tcs.routing.RoutingDecisionStore;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class InMemoryRoutingDecisionStore implements RoutingDecisionStore {

    private final Map<String, List<RoutingDecision>> byCorrelation = new LinkedHashMap<>();

    @Override
    public void saveAll(List<RoutingDecision> decisions) {
        if (decisions.isEmpty()) {
            return;
        }
        String key = decisions.get(0).correlationId();
        byCorrelation.put(key, new ArrayList<>(decisions));
    }

    @Override
    public List<RoutingDecision> findByCorrelationId(String correlationId) {
        return byCorrelation.getOrDefault(correlationId, List.of());
    }
}
