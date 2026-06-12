package com.pb.tcs.routing;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * D12: derives the explicit business event for typed targets from the PositionService snapshot
 * and the signed allocation quantity (BUY = +, SELL = −). Derivation only — on lookup failure the
 * trade quarantines upstream; this class never guesses.
 *
 * <ul>
 *   <li>No position / CLOSED / SETTLED / zero open qty → {@code NEW}
 *   <li>Allocation extends the open position (same sign) → {@code TOP_UP}
 *   <li>Allocation reduces or reverses it (opposite sign) → {@code UNWIND}
 * </ul>
 */
public final class EventTypeDeriver {

    public enum EventType {
        NEW,
        TOP_UP,
        UNWIND
    }

    private EventTypeDeriver() {}

    public static EventType derive(
            Optional<PositionServiceClient.PositionSnapshot> snapshot,
            BigDecimal quantity,
            String direction) {
        if (snapshot.isEmpty()) {
            return EventType.NEW;
        }
        PositionServiceClient.PositionSnapshot position = snapshot.get();
        if (!"OPEN".equals(position.positionStatus())
                || position.openQuantity() == null
                || position.openQuantity().signum() == 0) {
            return EventType.NEW;
        }
        BigDecimal signed = "SELL".equalsIgnoreCase(direction) ? quantity.negate() : quantity;
        return position.openQuantity().signum() == signed.signum()
                ? EventType.TOP_UP
                : EventType.UNWIND;
    }
}
