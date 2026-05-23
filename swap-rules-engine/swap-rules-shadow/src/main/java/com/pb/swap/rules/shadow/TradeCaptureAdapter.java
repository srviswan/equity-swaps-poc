package com.pb.swap.rules.shadow;

import com.pb.swap.rules.core.model.EnrichedEquitySwap;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import java.util.Map;

/**
 * Adapter for integrating with pb-synth-tradecapture-svc: map TradeCaptureRequest + reference
 * data to RawHedgeTrade, and map EnrichedEquitySwap to swapDataProduct payload.
 */
public final class TradeCaptureAdapter {

    public RawHedgeTrade toRawHedgeTrade(
            String tradeId,
            String productType,
            String book,
            String currency,
            String clientTier,
            String source,
            Map<String, Object> gcamAttributes) {
        return new RawHedgeTrade(
                tradeId,
                productType,
                book,
                currency,
                clientTier,
                source,
                null,
                null,
                null,
                gcamAttributes);
    }

    /** Map enriched swap to a generic map for SwapBlotter.swapDataProduct merge. */
    public Map<String, Object> toSwapDataProduct(EnrichedEquitySwap swap) {
        return Map.of(
                "tradeId", swap.tradeId(),
                "swapContract", swap.swapContract(),
                "interestLeg", swap.interestLeg(),
                "equityLeg", swap.equityLeg(),
                "schedule", swap.schedule(),
                "divPassthrough", swap.divPassthrough(),
                "workflowStatus", swap.workflowStatus(),
                "routingDestination", swap.routingDestination());
    }
}
