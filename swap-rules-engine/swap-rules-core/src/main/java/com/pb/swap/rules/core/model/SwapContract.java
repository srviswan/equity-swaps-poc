package com.pb.swap.rules.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pb.swap.rules.core.schema.SchemaField;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SwapContract(
        @SchemaField(description = "Generated contract identifier") String contractId,
        @SchemaField(enumRef = "PRODUCT_TYPE", description = "Effective product type") String productType,
        @SchemaField(description = "Contract start date") LocalDate startDate,
        @SchemaField(description = "Contract end date") LocalDate endDate) {}
