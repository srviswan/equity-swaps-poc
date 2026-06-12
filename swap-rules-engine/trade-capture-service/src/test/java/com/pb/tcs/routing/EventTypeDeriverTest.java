package com.pb.tcs.routing;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class EventTypeDeriverTest {

    private static Optional<PositionServiceClient.PositionSnapshot> position(
            long openQty, String status) {
        return Optional.of(
                new PositionServiceClient.PositionSnapshot(
                        BigDecimal.valueOf(openQty), status, Map.of(), List.of(), Instant.now()));
    }

    @Test
    void noPositionIsNew() {
        assertThat(EventTypeDeriver.derive(Optional.empty(), BigDecimal.valueOf(1000), "BUY"))
                .isEqualTo(EventTypeDeriver.EventType.NEW);
    }

    @Test
    void closedOrSettledOrFlatPositionIsNew() {
        assertThat(EventTypeDeriver.derive(position(50_000, "CLOSED"), BigDecimal.valueOf(1000), "BUY"))
                .isEqualTo(EventTypeDeriver.EventType.NEW);
        assertThat(EventTypeDeriver.derive(position(50_000, "SETTLED"), BigDecimal.valueOf(1000), "BUY"))
                .isEqualTo(EventTypeDeriver.EventType.NEW);
        assertThat(EventTypeDeriver.derive(position(0, "OPEN"), BigDecimal.valueOf(1000), "BUY"))
                .isEqualTo(EventTypeDeriver.EventType.NEW);
    }

    @Test
    void sameDirectionExtendsPosition() {
        assertThat(EventTypeDeriver.derive(position(50_000, "OPEN"), BigDecimal.valueOf(1000), "BUY"))
                .isEqualTo(EventTypeDeriver.EventType.TOP_UP);
        assertThat(EventTypeDeriver.derive(position(-50_000, "OPEN"), BigDecimal.valueOf(1000), "SELL"))
                .isEqualTo(EventTypeDeriver.EventType.TOP_UP);
    }

    @Test
    void oppositeDirectionUnwinds() {
        assertThat(EventTypeDeriver.derive(position(50_000, "OPEN"), BigDecimal.valueOf(1000), "SELL"))
                .isEqualTo(EventTypeDeriver.EventType.UNWIND);
        assertThat(EventTypeDeriver.derive(position(-50_000, "OPEN"), BigDecimal.valueOf(1000), "BUY"))
                .isEqualTo(EventTypeDeriver.EventType.UNWIND);
    }
}
