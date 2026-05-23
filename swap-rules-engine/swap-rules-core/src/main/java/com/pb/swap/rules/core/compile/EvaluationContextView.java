package com.pb.swap.rules.core.compile;

import com.pb.swap.rules.core.model.EnrichedEquitySwap;
import com.pb.swap.rules.core.model.RawHedgeTrade;

/** Read-only view used by compiled predicates. */
public interface EvaluationContextView {
    RawHedgeTrade rawTrade();

    EnrichedEquitySwap partialSwap();

    Object resolveField(String fieldPath);
}
