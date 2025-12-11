package com.finos.cashflow.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response for batch cashflow generation operations.
 */
public class BatchCashflowGenerationResponse {
    
    private UUID jobId;
    private int totalRequests;
    private int acceptedRequests;
    private int rejectedRequests;
    private List<ErrorDetail> errors;
    private LocalDateTime estimatedCompletionTime;
    
    // Constructors
    public BatchCashflowGenerationResponse() {}
    
    public BatchCashflowGenerationResponse(UUID jobId, int totalRequests, int acceptedRequests, int rejectedRequests) {
        this.jobId = jobId;
        this.totalRequests = totalRequests;
        this.acceptedRequests = acceptedRequests;
        this.rejectedRequests = rejectedRequests;
        this.estimatedCompletionTime = LocalDateTime.now().plusMinutes(totalRequests * 2); // 2 minutes per request estimate
    }
    
    // Getters and Setters
    public UUID getJobId() {
        return jobId;
    }
    
    public void setJobId(UUID jobId) {
        this.jobId = jobId;
    }
    
    public int getTotalRequests() {
        return totalRequests;
    }
    
    public void setTotalRequests(int totalRequests) {
        this.totalRequests = totalRequests;
    }
    
    public int getAcceptedRequests() {
        return acceptedRequests;
    }
    
    public void setAcceptedRequests(int acceptedRequests) {
        this.acceptedRequests = acceptedRequests;
    }
    
    public int getRejectedRequests() {
        return rejectedRequests;
    }
    
    public void setRejectedRequests(int rejectedRequests) {
        this.rejectedRequests = rejectedRequests;
    }
    
    public List<ErrorDetail> getErrors() {
        return errors;
    }
    
    public void setErrors(List<ErrorDetail> errors) {
        this.errors = errors;
    }
    
    public LocalDateTime getEstimatedCompletionTime() {
        return estimatedCompletionTime;
    }
    
    public void setEstimatedCompletionTime(LocalDateTime estimatedCompletionTime) {
        this.estimatedCompletionTime = estimatedCompletionTime;
    }
    
    // Supporting class
    public static class ErrorDetail {
        private int requestIndex;
        private String errorMessage;
        private String errorCode;
        
        public ErrorDetail() {}
        
        public ErrorDetail(int requestIndex, String errorMessage, String errorCode) {
            this.requestIndex = requestIndex;
            this.errorMessage = errorMessage;
            this.errorCode = errorCode;
        }
        
        public int getRequestIndex() {
            return requestIndex;
        }
        
        public void setRequestIndex(int requestIndex) {
            this.requestIndex = requestIndex;
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
