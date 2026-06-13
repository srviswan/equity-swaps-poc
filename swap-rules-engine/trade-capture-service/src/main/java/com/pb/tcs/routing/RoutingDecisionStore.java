package com.pb.tcs.routing;

import java.util.List;

/** Persistence port over {@code routing_decision} (stage-7 SQL commit, DDL V004). */
public interface RoutingDecisionStore {

    /**
     * Persists all of a trade's decisions atomically — the fan-out set is one routing outcome.
     *
     * @throws com.pb.tcs.ingress.IngestionStoreException on duplicate (correlationId, targetId)
     *     or connectivity failure
     */
    void saveAll(List<RoutingDecision> decisions);

    List<RoutingDecision> findByCorrelationId(String correlationId);
}
