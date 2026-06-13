package com.pb.tcs.lookup;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class StubSystemAFallbackClient implements SystemAFallbackClient {

    private final Map<String, TradeSummary> byAllocationId = new ConcurrentHashMap<>();

    public void seed(TradeSummary summary) {
        byAllocationId.put(summary.allocationId(), summary);
    }

    @Override
    public Optional<TradeSummary> lookup(TradeSearchQuery query) {
        if (query.allocationId() == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(byAllocationId.get(query.allocationId()));
    }
}
