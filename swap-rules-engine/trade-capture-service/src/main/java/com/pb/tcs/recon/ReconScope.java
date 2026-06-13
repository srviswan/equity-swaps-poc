package com.pb.tcs.recon;

import java.time.Instant;
import java.time.LocalDate;

public record ReconScope(String book, LocalDate tradeDate) {

    public String idempotencyKey(ReconType type, Instant asOf) {
        return type
                + "|"
                + (book == null ? "*" : book)
                + "|"
                + (tradeDate == null ? "*" : tradeDate)
                + "|"
                + asOf;
    }
}
