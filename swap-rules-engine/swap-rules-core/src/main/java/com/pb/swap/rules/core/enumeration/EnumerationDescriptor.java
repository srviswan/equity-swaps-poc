package com.pb.swap.rules.core.enumeration;

import java.time.Instant;
import java.util.List;

/** Materialised enumeration: definition metadata plus its resolved values. */
public record EnumerationDescriptor(
        String code,
        String displayName,
        String description,
        String providerType,
        int version,
        Instant updatedAt,
        List<EnumerationValue> values) {}
