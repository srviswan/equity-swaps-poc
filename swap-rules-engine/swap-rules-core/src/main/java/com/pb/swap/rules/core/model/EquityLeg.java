package com.pb.swap.rules.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pb.swap.rules.core.schema.SchemaField;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EquityLeg(
        @SchemaField(enumRef = "RETURN_TYPE", description = "Total / Price return") String returnType,
        @SchemaField(enumRef = "FEE_TYPE", description = "Borrow / financing fee model") String feeType) {}
