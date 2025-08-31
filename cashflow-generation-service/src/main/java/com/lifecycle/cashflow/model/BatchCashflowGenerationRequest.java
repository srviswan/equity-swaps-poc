package com.lifecycle.cashflow.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Request model for batch cashflow generation
 */
public record BatchCashflowGenerationRequest(
    @NotEmpty
    @Valid
    List<CashflowGenerationRequest> requests
) {
}
