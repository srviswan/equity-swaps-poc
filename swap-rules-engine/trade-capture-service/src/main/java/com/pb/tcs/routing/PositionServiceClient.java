package com.pb.tcs.routing;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Port over the PositionService lookup (provisional contract arch §15.2, E5). The real client
 * lands when the Position team confirms the contract; F5 integration-tests against a stub.
 */
public interface PositionServiceClient {

    /**
     * Looks up the open position for a match key built per {@code position-match-key.yml}.
     *
     * @return empty when no position exists for the key (a NEW trade)
     * @throws PositionLookupException on timeout / outage — the caller quarantines, never guesses
     *     the event type (D12)
     */
    Optional<PositionSnapshot> lookup(Map<String, String> matchKey);

    record PositionSnapshot(
            BigDecimal openQuantity,
            String positionStatus, // OPEN | CLOSED | SETTLED
            Map<String, String> swapRefs, // systemId -> swapRef
            List<LotRef> lotRefs,
            Instant asOf) {}

    record LotRef(String systemId, String lotId, BigDecimal openQty, String openDate) {}

    class PositionLookupException extends RuntimeException {
        public PositionLookupException(String message, Throwable cause) {
            super(message, cause);
        }

        public PositionLookupException(String message) {
            super(message);
        }
    }
}
