package com.pb.tcs.lookup;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/** Archive-tier trade index after partition switch (FR-600 / FR-602). */
public interface ArchivedTradeIndex {

    void archive(TradeSummary summary);

    Optional<TradeSummary> findByIngestionId(UUID ingestionId);

    List<TradeSummary> search(TradeSearchQuery query);
}
