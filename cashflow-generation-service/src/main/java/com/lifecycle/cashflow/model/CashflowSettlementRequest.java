package com.lifecycle.cashflow.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Request model for cashflow settlement
 */
public record CashflowSettlementRequest(
    @NotNull
    UUID cashflowId,
    
    @NotNull
    @Positive
    BigDecimal settlementAmount,
    
    @NotNull
    LocalDate settlementDate,
    
    String settlementReference,
    String counterparty,
    String settlementMethod
) {
}
