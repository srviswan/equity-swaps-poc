package com.pb.tcs.parity;

import java.util.List;

/** Per-trade parity outcome with field-level mismatch detail (FR-604). */
public record ParityMismatchReport(
        String tradeKey, List<ParityFieldMismatch> mismatches, boolean match) {

    public long mismatchCount() {
        return mismatches.size();
    }
}
