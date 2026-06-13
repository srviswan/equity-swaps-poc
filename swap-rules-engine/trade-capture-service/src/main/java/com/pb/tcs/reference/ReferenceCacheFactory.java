package com.pb.tcs.reference;

import com.pb.tcs.config.CachePolicyConfig;
import java.util.Locale;

/** FR-203: implementation chosen by config value, not code. Redis lands as a new case here. */
public final class ReferenceCacheFactory {

    private ReferenceCacheFactory() {}

    public static ReferenceCache create(String implementation, CachePolicyConfig policy) {
        return switch (implementation.toLowerCase(Locale.ROOT)) {
            case "caffeine" -> new CaffeineReferenceCache(policy);
            default ->
                    throw new IllegalArgumentException(
                            "Unknown cache implementation: " + implementation);
        };
    }
}
