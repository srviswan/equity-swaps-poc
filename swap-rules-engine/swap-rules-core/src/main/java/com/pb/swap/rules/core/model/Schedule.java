package com.pb.swap.rules.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pb.swap.rules.core.schema.SchemaField;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Schedule(
        @SchemaField(enumRef = "PAYMENT_FREQUENCY", description = "Coupon payment frequency")
                String paymentFrequency,
        @SchemaField(enumRef = "ROLL_CONVENTION", description = "Roll convention") String rollConvention) {}
