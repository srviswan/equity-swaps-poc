package com.pb.swap.rules.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pb.swap.rules.core.schema.SchemaField;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RawHedgeTrade(
        @SchemaField(description = "Unique trade identifier", writable = false) String tradeId,
        @SchemaField(enumRef = "PRODUCT_TYPE", description = "Trade product family", writable = false)
                String productType,
        @SchemaField(enumRef = "BOOK", description = "Trading book", writable = false) String book,
        @SchemaField(enumRef = "CURRENCY", description = "Trade currency (ISO 4217)", writable = false)
                String currency,
        @SchemaField(enumRef = "CLIENT_TIER", description = "Client tier classification", writable = false)
                String clientTier,
        @SchemaField(enumRef = "TRADE_SOURCE", description = "Capture source", writable = false)
                String source,
        @SchemaField(description = "Trade notional in trade currency", writable = false)
                BigDecimal notional,
        @SchemaField(description = "Trade date", writable = false) LocalDate tradeDate,
        @SchemaField(description = "Underlying security identifier", writable = false)
                String securityId,
        @SchemaField(description = "Open-ended attribute bag", writable = false)
                Map<String, Object> attributes) {}
