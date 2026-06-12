package com.pb.tcs.lookup;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public final class InMemoryArchivedTradeIndex implements ArchivedTradeIndex {

    private final Map<UUID, TradeSummary> byId = new LinkedHashMap<>();

    @Override
    public void archive(TradeSummary summary) {
        byId.put(summary.ingestionId(), summary);
    }

    @Override
    public Optional<TradeSummary> findByIngestionId(UUID ingestionId) {
        return Optional.ofNullable(byId.get(ingestionId));
    }

    @Override
    public List<TradeSummary> search(TradeSearchQuery query) {
        return byId.values().stream().filter(s -> matches(s, query)).toList();
    }

    private static boolean matches(TradeSummary s, TradeSearchQuery q) {
        if (q.allocationId() != null && !q.allocationId().equals(s.allocationId())) {
            return false;
        }
        if (q.blockId() != null && !q.blockId().equals(s.blockId())) {
            return false;
        }
        return q.book() == null || q.book().equals(s.book());
    }
}
