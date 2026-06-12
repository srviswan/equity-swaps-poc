package com.pb.tcs.recon;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** FR-703 keyed matcher: allocationId → swapRef → lotRef with composite fallback. */
public final class ReconMatcher {

    private ReconMatcher() {}

    public static Map<String, ReconRecord> index(List<ReconRecord> records) {
        return records.stream()
                .collect(Collectors.toMap(ReconRecord::matchKey, r -> r, (a, b) -> b, LinkedHashMap::new));
    }

    public static boolean withinHorizon(ReconRecord record, Instant asOf, int inFlightHorizonMinutes) {
        if (record.observedAt() == null) {
            return true;
        }
        Instant cutoff = asOf.minusSeconds(inFlightHorizonMinutes * 60L);
        return !record.observedAt().isAfter(cutoff);
    }
}
