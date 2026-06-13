package com.pb.tcs.config;

import java.util.List;
import java.util.Map;

/**
 * Typed view of {@code tcs-config/position-match-key.yml} (D10/D11/D12). A system's
 * {@code matchKey: default} reference is resolved at load time, so consumers always see concrete
 * fields.
 */
public record PositionMatchKeyConfig(
        List<String> defaultFields, Map<String, SystemPolicy> systems) {

    public enum PositionLookup {
        NEVER,
        BEFORE_ROUTE
    }

    public record SystemPolicy(
            boolean explicitEventType, PositionLookup positionLookup, List<String> matchKeyFields) {}
}
