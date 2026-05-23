package com.pb.swap.rules.core.trace;

import java.util.List;

public record DecisionTrace(
        String traceId,
        String tradeId,
        String snapshotVersion,
        List<DecisionRecord> decisions,
        List<UnresolvedTarget> unresolved,
        boolean overflow) {}
