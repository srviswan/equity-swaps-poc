package com.pb.tcs.parity;

import com.pb.tcs.rules.SwapBlotter;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryLegacyBlotterStore implements LegacyBlotterStore {

    private final Map<String, SwapBlotter> byAllocationId = new ConcurrentHashMap<>();

    public void put(SwapBlotter blotter) {
        byAllocationId.put(blotter.allocationId(), blotter);
    }

    @Override
    public Optional<SwapBlotter> findByAllocationId(String allocationId) {
        return Optional.ofNullable(byAllocationId.get(allocationId));
    }
}
