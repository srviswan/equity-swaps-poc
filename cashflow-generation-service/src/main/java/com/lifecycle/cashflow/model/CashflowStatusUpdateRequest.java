package com.lifecycle.cashflow.model;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Request model for updating cashflow status
 */
public record CashflowStatusUpdateRequest(
    @NotNull
    UUID cashflowId,
    
    @NotNull
    CashflowStatus newStatus,
    
    String reason,
    String updatedBy
) {
}
