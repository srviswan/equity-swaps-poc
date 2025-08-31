package com.lifecycle.cashflow.model;

import java.util.List;
import java.util.UUID;

/**
 * Response model for batch cashflow generation
 */
public record BatchCashflowGenerationResponse(
    List<CashflowGenerationResponse> responses,
    int totalRequests,
    int successfulRequests,
    int failedRequests,
    String batchId
) {
    public static BatchCashflowGenerationResponse success(List<CashflowGenerationResponse> responses) {
        int successful = (int) responses.stream().filter(r -> "COMPLETED".equals(r.getStatus())).count();
        int failed = responses.size() - successful;
        
        return new BatchCashflowGenerationResponse(
            responses,
            responses.size(),
            successful,
            failed,
            UUID.randomUUID().toString()
        );
    }
}
