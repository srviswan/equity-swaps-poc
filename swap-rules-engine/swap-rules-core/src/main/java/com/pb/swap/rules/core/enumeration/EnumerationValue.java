package com.pb.swap.rules.core.enumeration;

import java.time.LocalDate;
import java.util.Map;

/** A single value (code + label) belonging to an enumeration. */
public record EnumerationValue(
        String code,
        String label,
        int sortOrder,
        boolean active,
        Map<String, Object> metadata,
        LocalDate validFrom,
        LocalDate validTo) {

    public static EnumerationValue of(String code, String label) {
        return new EnumerationValue(code, label, 0, true, Map.of(), null, null);
    }
}
