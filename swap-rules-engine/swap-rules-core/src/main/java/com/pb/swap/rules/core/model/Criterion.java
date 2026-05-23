package com.pb.swap.rules.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Criterion(
        String field,
        ComparisonOperator operator,
        Object value,
        String fragmentId) {}
