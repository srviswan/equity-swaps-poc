package com.pb.tcs.routing;

import com.pb.tcs.config.PositionMatchKeyConfig;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * FR-306: builds the PositionService match key for a target system from its
 * {@code position-match-key.yml} template. Fields resolve against the {@link RoutingContext}
 * dimension map, so a key-template change (add/remove a field) requires no deploy.
 */
public final class MatchKeyBuilder {

    private final PositionMatchKeyConfig config;

    public MatchKeyBuilder(PositionMatchKeyConfig config) {
        this.config = config;
    }

    public PositionMatchKeyConfig.SystemPolicy policy(String systemId) {
        PositionMatchKeyConfig.SystemPolicy policy = config.systems().get(systemId);
        if (policy == null) {
            // Unlisted systems get the safe default: no lookup, implicit NEW (D11 semantics).
            return new PositionMatchKeyConfig.SystemPolicy(
                    false, PositionMatchKeyConfig.PositionLookup.NEVER, config.defaultFields());
        }
        return policy;
    }

    /** Field order follows the template; fields absent from the trade are omitted. */
    public Map<String, String> matchKey(String systemId, RoutingContext context) {
        Map<String, String> key = new LinkedHashMap<>();
        for (String field : policy(systemId).matchKeyFields()) {
            String value = context.get(field);
            if (value != null) {
                key.put(field, value);
            }
        }
        return key;
    }
}
