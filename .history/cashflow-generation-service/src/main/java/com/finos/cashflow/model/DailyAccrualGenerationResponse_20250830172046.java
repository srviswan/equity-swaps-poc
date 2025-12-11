package com.finos.cashflow.model;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response for daily accrual generation requests.
 */
public class DailyAccrualGenerationResponse {
    
    private UUID jobId;
    private LocalDateTime estimatedCompletionTime;
    private int contractsProcessed;
    private int accrualsGenerated;
    private String message;
    
    // Constructors
    public DailyAccrualGenerationResponse() {}
    
    public DailyAccrualGenerationResponse(UUID jobId, int contractsProcessed, int accrualsGenerated, String message) {
        this.jobId = jobId;
        this.contractsProcessed = contractsProcessed;
        this.accrualsGenerated = accrualsGenerated;
        this.message = message;
        this.estimatedCompletionTime = LocalDateTime.now().plusMinutes(5); // Default estimate
    }
    
    // Getters and Setters
    public UUID getJobId() {
        return jobId;
    }
    
    public void setJobId(UUID jobId) {
        this.jobId = jobId;
    }
    
    public LocalDateTime getEstimatedCompletionTime() {
        return estimatedCompletionTime;
    }
    
    public void setEstimatedCompletionTime(LocalDateTime estimatedCompletionTime) {
        this.estimatedCompletionTime = estimatedCompletionTime;
    }
    
    public int getContractsProcessed() {
        return contractsProcessed;
    }
    
    public void setContractsProcessed(int contractsProcessed) {
        this.contractsProcessed = contractsProcessed;
    }
    
    public int getAccrualsGenerated() {
        return accrualsGenerated;
    }
    
    public void setAccrualsGenerated(int accrualsGenerated) {
        this.accrualsGenerated = accrualsGenerated;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
