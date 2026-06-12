package com.pb.tcs.lookup;

import java.time.LocalDate;
import java.util.UUID;

public record TradeSummary(
        UUID ingestionId,
        String correlationId,
        String blockId,
        String allocationId,
        int version,
        String book,
        String clientAccount,
        String swapRef,
        LocalDate tradeDate,
        String status,
        LookupTier tier) {

    public enum LookupTier {
        HOT,
        ARCHIVE,
        SYSTEM_A
    }
}
