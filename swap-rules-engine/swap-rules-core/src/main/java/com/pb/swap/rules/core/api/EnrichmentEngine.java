package com.pb.swap.rules.core.api;

import com.pb.swap.rules.core.model.RawHedgeTrade;

public interface EnrichmentEngine {
  EnrichmentResult enrich(RawHedgeTrade rawTrade);
}
