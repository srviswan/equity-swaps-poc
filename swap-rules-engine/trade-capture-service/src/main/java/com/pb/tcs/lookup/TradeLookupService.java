package com.pb.tcs.lookup;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/** FR-600 hot → archive → System A fall-through lookup. */
public final class TradeLookupService {

    private final HotTradeIndex hotIndex;
    private final ArchivedTradeIndex archiveIndex;
    private final SystemAFallbackClient systemA;

    public TradeLookupService(
            HotTradeIndex hotIndex, ArchivedTradeIndex archiveIndex, SystemAFallbackClient systemA) {
        this.hotIndex = hotIndex;
        this.archiveIndex = archiveIndex;
        this.systemA = systemA;
    }

    public Optional<TradeSummary> findByIngestionId(UUID ingestionId) {
        return hotIndex
                .findByIngestionId(ingestionId)
                .or(() -> archiveIndex.findByIngestionId(ingestionId));
    }

    public List<TradeSummary> search(TradeSearchQuery query) {
        List<TradeSummary> hot = hotIndex.search(query);
        if (!hot.isEmpty()) {
            return hot;
        }
        List<TradeSummary> archived = archiveIndex.search(query);
        if (!archived.isEmpty()) {
            return archived;
        }
        return systemA.lookup(query).stream().toList();
    }
}
