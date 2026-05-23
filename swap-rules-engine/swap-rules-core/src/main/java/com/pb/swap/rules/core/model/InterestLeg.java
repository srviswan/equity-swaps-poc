package com.pb.swap.rules.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pb.swap.rules.core.schema.SchemaField;
import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record InterestLeg(
        @SchemaField(enumRef = "DAY_COUNT", description = "Day count convention") String dayCount,
        @SchemaField(enumRef = "RATE_TYPE", description = "Fixed or floating") String rateType,
        @SchemaField(enumRef = "RATE_INDEX", description = "Reference rate index") String index,
        @SchemaField(description = "Spread over reference rate in basis points") BigDecimal spreadBps,
        @SchemaField(description = "Fixed rate (when rateType=FIXED)") BigDecimal fixedRate) {}
