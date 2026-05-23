package com.pb.swap.rules.core.enumeration;

/** Lightweight pointer + config used by providers; stripped of resolved values. */
public record EnumerationDefinition(
        String code,
        String displayName,
        String description,
        String providerType,
        String sourceConfig,
        String refreshPolicy,
        Integer refreshIntervalSeconds,
        int version) {}
