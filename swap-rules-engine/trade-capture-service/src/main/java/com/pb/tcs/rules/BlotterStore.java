package com.pb.tcs.rules;

import java.util.List;
import java.util.Optional;

/**
 * Persistence port for stage-4 output: the assembled blotter and its FR-207 explain trail are
 * written in one transaction (a blotter without its explains is not auditable). Keyed by the D4
 * correlation id, so reassembly of the same allocation version is rejected, not duplicated.
 */
public interface BlotterStore {

    /**
     * Atomically persists the blotter row (serialized JSON payload) and all explain rows.
     *
     * @throws com.pb.tcs.ingress.IngestionStoreException on constraint violation (duplicate
     *     correlation id) or connectivity failure — caller NACKs for redelivery
     */
    void save(SwapBlotter blotter, List<RuleExplain> explains);

    /** Serialized blotter payload for the correlation id, if assembled. */
    Optional<String> findBlotterJson(String correlationId);

    /** Persisted explains in seq order; empty if the blotter was never assembled. */
    List<RuleExplain> findExplains(String correlationId);
}
