package com.lifecycle.cashflow.model;

import java.util.List;

/**
 * Paginated response for daily accrual queries
 */
public record DailyAccrualPageResponse(
    List<DailyAccrualGenerationResponse.DailyAccrual> content,
    int page,
    int size,
    long totalElements,
    int totalPages,
    boolean hasNext,
    boolean hasPrevious
) {
    public static DailyAccrualPageResponse of(
        List<DailyAccrualGenerationResponse.DailyAccrual> content, 
        int page, 
        int size, 
        long totalElements
    ) {
        int totalPages = (int) Math.ceil((double) totalElements / size);
        boolean hasNext = page < totalPages - 1;
        boolean hasPrevious = page > 0;
        
        return new DailyAccrualPageResponse(
            content,
            page,
            size,
            totalElements,
            totalPages,
            hasNext,
            hasPrevious
        );
    }
}
