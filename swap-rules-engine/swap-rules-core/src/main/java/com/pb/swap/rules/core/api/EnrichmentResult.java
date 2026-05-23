package com.pb.swap.rules.core.api;

import com.pb.swap.rules.core.model.EnrichedEquitySwap;
import com.pb.swap.rules.core.trace.DecisionTrace;

public record EnrichmentResult(EnrichedEquitySwap swap, DecisionTrace trace) {}
