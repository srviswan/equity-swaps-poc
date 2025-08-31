package com.lifecycle.cashflow.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for cashflow generation responses.
 * 
 * This class represents the response to a cashflow generation request,
 * including job tracking information.
 */
public class CashflowGenerationResponse {
    
    private UUID jobId;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime estimatedCompletionTime;
    
    private Integer contractsProcessed;
    
    private String message;
    
    private String status;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    
    // Default constructor
    public CashflowGenerationResponse() {
        this.createdAt = LocalDateTime.now();
    }
    
    // Constructor with required fields
    public CashflowGenerationResponse(UUID jobId, Integer contractsProcessed, String message) {
        this();
        this.jobId = jobId;
        this.contractsProcessed = contractsProcessed;
        this.message = message;
        this.status = "ACCEPTED";
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
    
    public Integer getContractsProcessed() {
        return contractsProcessed;
    }
    
    public void setContractsProcessed(Integer contractsProcessed) {
        this.contractsProcessed = contractsProcessed;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    /**
     * Check if the job is accepted.
     * 
     * @return true if the job is accepted
     */
    public boolean isAccepted() {
        return "ACCEPTED".equals(status);
    }
    
    /**
     * Check if the job is processing.
     * 
     * @return true if the job is processing
     */
    public boolean isProcessing() {
        return "PROCESSING".equals(status);
    }
    
    /**
     * Check if the job is completed.
     * 
     * @return true if the job is completed
     */
    public boolean isCompleted() {
        return "COMPLETED".equals(status);
    }
    
    /**
     * Check if the job has failed.
     * 
     * @return true if the job has failed
     */
    public boolean isFailed() {
        return "FAILED".equals(status);
    }
    
    @Override
    public String toString() {
        return "CashflowGenerationResponse{" +
                "jobId=" + jobId +
                ", estimatedCompletionTime=" + estimatedCompletionTime +
                ", contractsProcessed=" + contractsProcessed +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
