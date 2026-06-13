package com.pb.tcs.repair;

import com.pb.tcs.ingress.IngestionStoreException;
import com.pb.tcs.rules.BlotterJson;
import com.pb.tcs.rules.BlotterStore;
import com.pb.tcs.rules.RuleExplain;
import com.pb.tcs.rules.SwapBlotter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** In-memory {@link BlotterStore} with the SQL adapter's duplicate-correlation semantics. */
public final class InMemoryBlotterStore implements BlotterStore {

    private final Map<String, String> blotters = new LinkedHashMap<>();
    private final Map<String, List<RuleExplain>> explains = new LinkedHashMap<>();

    @Override
    public void save(SwapBlotter blotter, List<RuleExplain> explainRows) {
        if (blotters.containsKey(blotter.correlationId())) {
            throw new IngestionStoreException("uq_blotter: " + blotter.correlationId());
        }
        blotters.put(blotter.correlationId(), BlotterJson.toJson(blotter));
        explains.put(blotter.correlationId(), List.copyOf(explainRows));
    }

    @Override
    public Optional<String> findBlotterJson(String correlationId) {
        return Optional.ofNullable(blotters.get(correlationId));
    }

    @Override
    public List<RuleExplain> findExplains(String correlationId) {
        return explains.getOrDefault(correlationId, List.of());
    }
}
