package com.lifecycle.cashflow.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response for batch status update operations.
 */
public class BatchStatusUpdateResponse {
    
    private UUID jobId;
    private int totalUpdates;
    private int successfulUpdates;
    private int failedUpdates;
    private List<UpdateError> errors;
    private LocalDateTime completionTime;
    
    // Constructors
    public BatchStatusUpdateResponse() {}
    
    public BatchStatusUpdateResponse(UUID jobId, int totalUpdates, int successfulUpdates, int failedUpdates) {
        this.jobId = jobId;
        this.totalUpdates = totalUpdates;
        this.successfulUpdates = successfulUpdates;
        this.failedUpdates = failedUpdates;
        this.completionTime = LocalDateTime.now();
    }
    
    // Getters and Setters
    public UUID getJobId() {
        return jobId;
    }
    
    public void setJobId(UUID jobId) {
        this.jobId = jobId;
    }
    
    public int getTotalUpdates() {
        return totalUpdates;
    }
    
    public void setTotalUpdates(int totalUpdates) {
        this.totalUpdates = totalUpdates;
    }
    
    public int getSuccessfulUpdates() {
        return successfulUpdates;
    }
    
    public void setSuccessfulUpdates(int successfulUpdates) {
        this.successfulUpdates = successfulUpdates;
    }
    
    public int getFailedUpdates() {
        return failedUpdates;
    }
    
    public void setFailedUpdates(int failedUpdates) {
        this.failedUpdates = failedUpdates;
    }
    
    public List<UpdateError> getErrors() {
        return errors;
    }
    
    public void setErrors(List<UpdateError> errors) {
        this.errors = errors;
    }
    
    public LocalDateTime getCompletionTime() {
        return completionTime;
    }
    
    public void setCompletionTime(LocalDateTime completionTime) {
        this.completionTime = completionTime;
    }
    
    // Supporting class
    public static class UpdateError {
        private UUID cashflowId;
        private String errorMessage;
        private String errorCode;
        
        public UpdateError() {}
        
        public UpdateError(UUID cashflowId, String errorMessage, String errorCode) {
            this.cashflowId = cashflowId;
            this.errorMessage = errorMessage;
            this.errorCode = errorCode;
        }
        
        public UUID getCashflowId() {
            return cashflowId;
        }
        
        public void setCashflowId(UUID cashflowId) {
            this.cashflowId = cashflowId;
        }
        
        public String getErrorMessage() {
            return errorMessage;
        }
        
        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
        
        public String getErrorCode() {
            return errorCode;
        }
        
        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }
    }
}

