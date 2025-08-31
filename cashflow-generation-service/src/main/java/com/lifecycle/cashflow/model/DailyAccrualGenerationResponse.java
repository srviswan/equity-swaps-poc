package com.lifecycle.cashflow.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Response model for daily accrual generation
 */
public record DailyAccrualGenerationResponse(
    UUID requestId,
    List<DailyAccrual> accruals,
    LocalDate startDate,
    LocalDate endDate,
    int totalDays,
    String status,
    String message
) {
    public record DailyAccrual(
        UUID contractId,
        LocalDate accrualDate,
        DailyAccrualGenerationRequest.AccrualType accrualType,
        double amount,
        String currency
    ) {}
    
    public static DailyAccrualGenerationResponse success(
        UUID requestId,
        List<DailyAccrual> accruals,
        LocalDate startDate,
        LocalDate endDate
    ) {
        return new DailyAccrualGenerationResponse(
            requestId,
            accruals,
            startDate,
            endDate,
            accruals.size(),
            "COMPLETED",
            "Daily accruals generated successfully"
        );
    }
}
