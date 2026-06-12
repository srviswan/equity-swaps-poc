package com.pb.tcs.routing;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** PositionService stub (E5): keyed positions, outage simulation, lookup capture. */
public final class StubPositionService implements PositionServiceClient {

    static final Instant AS_OF = Instant.parse("2026-06-10T20:00:00Z");

    private final Map<String, PositionSnapshot> positions = new LinkedHashMap<>();
    private final List<Map<String, String>> lookups = new ArrayList<>();
    private boolean down;

    void openPosition(String security, long openQty, String status) {
        positions.put(
                security,
                new PositionSnapshot(
                        BigDecimal.valueOf(openQty),
                        status,
                        Map.of("SYSTEM_A", "A-SWP-991", "SYSTEM_B", "B-77231"),
                        List.of(new LotRef("SYSTEM_A", "A-LOT-1", BigDecimal.valueOf(openQty), "2026-05-12")),
                        AS_OF));
    }

    void outage(boolean down) {
        this.down = down;
    }

    List<Map<String, String>> lookups() {
        return lookups;
    }

    @Override
    public Optional<PositionSnapshot> lookup(Map<String, String> matchKey) {
        if (down) {
            throw new PositionLookupException("PositionService timeout after 3 attempts");
        }
        lookups.add(matchKey);
        return Optional.ofNullable(positions.get(matchKey.get("security")));
    }
}
