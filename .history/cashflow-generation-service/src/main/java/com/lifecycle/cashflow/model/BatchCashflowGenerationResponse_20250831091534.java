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
    int acceptedRequests,
    String batchId,
    String jobId
) {
    public static BatchCashflowGenerationResponse success(List<CashflowGenerationResponse> responses) {
        int successful = (int) responses.stream().filter(r -> "COMPLETED".equals(r.getStatus())).count();
        int failed = responses.size() - successful;
        String jobIdValue = UUID.randomUUID().toString();
        
        return new BatchCashflowGenerationResponse(
            responses,
            responses.size(),
            successful,
            failed,
            responses.size(), // acceptedRequests = all requests are accepted
            jobIdValue, // batchId
            jobIdValue  // jobId (same as batchId for simplicity)
        );
    }
}
