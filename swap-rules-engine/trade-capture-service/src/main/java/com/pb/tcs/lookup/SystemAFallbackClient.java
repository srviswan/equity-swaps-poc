package com.pb.tcs.lookup;

import java.util.List;
import java.util.Optional;

/** System A fallback when trade is not in hot or archive tiers (FR-600 / D19). */
public interface SystemAFallbackClient {

    Optional<TradeSummary> lookup(TradeSearchQuery query);
}
