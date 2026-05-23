package com.pb.swap.rules.core.schema;

import java.util.List;

/**
 * Flat description of a single addressable field on either side of the rules engine domain (raw
 * trade or enriched swap). Paths are dot-delimited (e.g. {@code interestLeg.dayCount}).
 */
public record FieldDescriptor(
        String path,
        String type,
        String enumRef,
        boolean nullable,
        boolean writable,
        String description,
        List<String> operators) {}
