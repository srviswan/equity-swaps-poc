package com.finos.cashflow.model;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;

/**
 * Request for batch status updates on multiple cashflows.
 */
public class BatchStatusUpdateRequest {
    
    @NotEmpty(message = "Updates cannot be empty")
    private List<StatusUpdate> updates;
    
    // Constructors
    public BatchStatusUpdateRequest() {}
    
    public BatchStatusUpdateRequest(List<StatusUpdate> updates) {
        this.updates = updates;
    }
    
    // Getters and Setters
    public List<StatusUpdate> getUpdates() {
        return updates;
    }
    
    public void setUpdates(List<StatusUpdate> updates) {
        this.updates = updates;
    }
    
    // Supporting class
    public static class StatusUpdate {
        private UUID cashflowId;
        private CashflowStatus newStatus;
        private String reason;
        
        public StatusUpdate() {}
        
        public StatusUpdate(UUID cashflowId, CashflowStatus newStatus, String reason) {
            this.cashflowId = cashflowId;
            this.newStatus = newStatus;
            this.reason = reason;
        }
        
        public UUID getCashflowId() {
            return cashflowId;
        }
        
        public void setCashflowId(UUID cashflowId) {
            this.cashflowId = cashflowId;
        }
        
        public CashflowStatus getNewStatus() {
            return newStatus;
        }
        
        public void setNewStatus(CashflowStatus newStatus) {
            this.newStatus = newStatus;
        }
        
        public String getReason() {
            return reason;
        }
        
        public void setReason(String reason) {
            this.reason = reason;
        }
    }
}

