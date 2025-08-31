package com.lifecycle.cashflow.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Request model for daily accrual generation
 */
public record DailyAccrualGenerationRequest(
    @NotEmpty
    List<UUID> contractIds,
    
    @NotNull
    LocalDate startDate,
    
    @NotNull
    LocalDate endDate,
    
    List<AccrualType> accrualTypes,
    String businessDayAdjustment
) {
    public enum AccrualType {
        INTEREST,
        EQUITY,
        DIVIDEND,
        FEE
    }
}
