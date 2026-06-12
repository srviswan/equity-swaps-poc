package com.pb.tcs.config;

import java.time.Duration;
import java.util.Map;

/**
 * Typed view of {@code tcs-config/cache-policy.yml} (D16). An entity either declares named field
 * groups ({@code security.staticFields}) or a single flat policy ({@code book}) which applies to
 * every field group.
 */
public record CachePolicyConfig(Map<String, Map<String, FieldPolicy>> entities) {

    /** Field-group key used when an entity declares one flat policy. */
    public static final String DEFAULT_GROUP = "default";

    public enum Mode {
        CACHE,
        READ_THROUGH
    }

    public enum Invalidation {
        EVENT,
        NONE
    }

    public record FieldPolicy(Mode mode, Duration ttl, Invalidation invalidation) {}

    /**
     * Policy for an entity's field group; a flat entity declaration answers for any group.
     *
     * @throws IllegalArgumentException for an unknown entity or group
     */
    public FieldPolicy policy(String entity, String fieldGroup) {
        Map<String, FieldPolicy> groups = entities.get(entity);
        if (groups == null) {
            throw new IllegalArgumentException("No cache policy for entity: " + entity);
        }
        FieldPolicy policy = groups.get(fieldGroup);
        if (policy == null) {
            policy = groups.get(DEFAULT_GROUP);
        }
        if (policy == null) {
            throw new IllegalArgumentException(
                    "No cache policy for " + entity + "." + fieldGroup);
        }
        return policy;
    }
}
