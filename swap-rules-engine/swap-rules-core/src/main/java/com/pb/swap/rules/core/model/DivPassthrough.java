package com.pb.swap.rules.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pb.swap.rules.core.schema.SchemaField;
import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DivPassthrough(
        @SchemaField(description = "Passthrough percent (0-100)") BigDecimal percent,
        @SchemaField(enumRef = "DIV_TIMING", description = "When the passthrough cash flows") String timing) {}
