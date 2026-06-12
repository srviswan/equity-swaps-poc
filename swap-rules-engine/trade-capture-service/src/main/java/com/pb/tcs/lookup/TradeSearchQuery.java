package com.pb.tcs.lookup;

import java.time.LocalDate;
import java.util.UUID;

/** Dimensional trade search (FR-600). */
public record TradeSearchQuery(
        String allocationId,
        String blockId,
        String swapRef,
        String lotRef,
        String clientAccount,
        String book,
        LocalDate tradeDate) {

    public static TradeSearchQuery byAllocationId(String allocationId) {
        return new TradeSearchQuery(allocationId, null, null, null, null, null, null);
    }
}
