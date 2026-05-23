package com.pb.swap.rules.core.model;

public enum OverridePolicy {
    /** Only set when current value is null or absent. */
    NEVER,
    /** Always overwrite existing value. */
    ALWAYS
}
