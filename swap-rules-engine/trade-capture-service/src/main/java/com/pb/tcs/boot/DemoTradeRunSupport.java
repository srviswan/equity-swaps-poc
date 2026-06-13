package com.pb.tcs.boot;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public final class DemoTradeRunSupport {

    private DemoTradeRunSupport() {}

    public static LocalDate parseTradeDate(String tradeDate) {
        try {
            return LocalDate.parse(tradeDate);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("invalid tradeDate (expected ISO-8601 date): " + tradeDate);
        }
    }
}
