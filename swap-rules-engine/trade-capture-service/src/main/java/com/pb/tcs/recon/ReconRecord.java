package com.pb.tcs.recon;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;

/** Normalized snapshot row from any recon source (FR-706 / E6). */
public record ReconRecord(
        ReconSource source,
        String allocationId,
        String swapRef,
        String lotRef,
        String book,
        String clientAccount,
        String securityId,
        LocalDate tradeDate,
        String direction,
        Long quantity,
        String status,
        Map<String, String> compareFields,
        Instant observedAt) {

    public enum ReconSource {
        TCS,
        SYSTEM_A,
        SYSTEM_B,
        GCAM
    }

    public String matchKey() {
        if (allocationId != null && !allocationId.isBlank()) {
            return "A:" + allocationId;
        }
        if (swapRef != null && !swapRef.isBlank()) {
            return "S:" + swapRef;
        }
        if (lotRef != null && !lotRef.isBlank()) {
            return "L:" + lotRef;
        }
        return "C:" + book + "|" + clientAccount + "|" + securityId + "|" + tradeDate + "|" + quantity;
    }
}
