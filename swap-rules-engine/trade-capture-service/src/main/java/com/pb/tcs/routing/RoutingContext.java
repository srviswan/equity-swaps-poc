package com.pb.tcs.routing;

import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.rules.SwapBlotter;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Flat dimension map for routing-rule criteria and match-key templates (FR-304/306). Built from
 * the blotter identity plus allocation economics and extended attributes, so a new routing
 * dimension or match-key field is a config change only — any key present here (including
 * forward-compat GCAM fields) is immediately usable in {@code routing-rules.yml} and
 * {@code position-match-key.yml}.
 */
public final class RoutingContext {

    private final Map<String, String> dimensions;

    private RoutingContext(Map<String, String> dimensions) {
        this.dimensions = Collections.unmodifiableMap(dimensions);
    }

    public static RoutingContext of(EnrichedAllocation allocation, SwapBlotter blotter) {
        AllocationMessage m = allocation.message();
        Map<String, String> d = new LinkedHashMap<>();
        put(d, "book", blotter.book());
        put(d, "assetType", m.getAssetType());
        put(d, "exchange", m.getExchange());
        put(d, "location", m.getLocation());
        put(d, "direction", m.getDirection());
        put(d, "allocationType", blotter.allocationType());
        put(d, "security", blotter.securityId());
        put(d, "securityId", blotter.securityId());
        // clientAccount = AccountId: ClientAccount (SWAP) or WashBook (BLOCK), per D8
        put(d, "clientAccount", blotter.accountId());
        put(d, "clientMasterNo", m.getClientMasterNo());
        m.getExtendedAttributesMap().forEach((k, v) -> d.putIfAbsent(k, v));
        return new RoutingContext(d);
    }

    public String get(String dimension) {
        return dimensions.get(dimension);
    }

    public Map<String, String> dimensions() {
        return dimensions;
    }

    private static void put(Map<String, String> map, String key, String value) {
        if (value != null && !value.isEmpty()) {
            map.put(key, value);
        }
    }
}
