package com.lifecycle.cashflow.model;

import java.util.List;

/**
 * Paginated response for cashflow queries
 */
public record CashflowPageResponse(
    List<Cashflow> content,
    int page,
    int size,
    long totalElements,
    int totalPages,
    boolean hasNext,
    boolean hasPrevious
) {
    public static CashflowPageResponse of(List<Cashflow> content, int page, int size, long totalElements) {
        int totalPages = (int) Math.ceil((double) totalElements / size);
        boolean hasNext = page < totalPages - 1;
        boolean hasPrevious = page > 0;
        
        return new CashflowPageResponse(
            content,
            page,
            size,
            totalElements,
            totalPages,
            hasNext,
            hasPrevious
        );
    }
    
    public static CashflowPageResponse empty(int page, int size) {
        return new CashflowPageResponse(
            List.of(),
            page,
            size,
            0,
            0,
            false,
            false
        );
    }
}
