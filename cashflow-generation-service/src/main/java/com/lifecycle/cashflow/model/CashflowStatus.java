package com.lifecycle.cashflow.model;

import java.util.Set;

/**
 * Enum representing the lifecycle status of a cashflow.
 * 
 * This enum defines the valid state transitions and business rules
 * for cashflow lifecycle management.
 */
public enum CashflowStatus {
    
    ACCRUED("Accrued", "Initial state with daily accrual tracking"),
    REALIZED_DEFERRED("Realized Deferred", "Deferred due to business rules or regulatory requirements"),
    REALIZED_UNSETTLED("Realized Unsettled", "Realized but not yet settled"),
    REALIZED_SETTLED("Realized Settled", "Fully settled and confirmed"),
    CANCELLED("Cancelled", "Cancelled cashflow"),
    ADJUSTED("Adjusted", "Adjusted due to corrections or changes");
    
    private final String displayName;
    private final String description;
    
    CashflowStatus(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }
    
    /**
     * Get the valid transitions from the current status.
     * 
     * @return Set of valid target statuses
     */
    public Set<CashflowStatus> getValidTransitions() {
        return switch (this) {
            case ACCRUED -> Set.of(REALIZED_DEFERRED, REALIZED_UNSETTLED, CANCELLED, ADJUSTED);
            case REALIZED_DEFERRED -> Set.of(REALIZED_UNSETTLED, ACCRUED, CANCELLED);
            case REALIZED_UNSETTLED -> Set.of(REALIZED_SETTLED, ACCRUED, CANCELLED);
            case REALIZED_SETTLED -> Set.of(ADJUSTED);
            case CANCELLED -> Set.of(ACCRUED);
            case ADJUSTED -> Set.of(REALIZED_UNSETTLED, CANCELLED);
        };
    }
    
    /**
     * Check if this status represents a final state.
     * 
     * @return true if this is a final status
     */
    public boolean isFinal() {
        return this == REALIZED_SETTLED || this == CANCELLED;
    }
    
    /**
     * Check if this status represents an active state.
     * 
     * @return true if this is an active status
     */
    public boolean isActive() {
        return this == ACCRUED || this == REALIZED_DEFERRED || this == REALIZED_UNSETTLED;
    }
    
    /**
     * Check if this status allows further processing.
     * 
     * @return true if further processing is allowed
     */
    public boolean allowsProcessing() {
        return this == ACCRUED || this == REALIZED_DEFERRED;
    }
    
    /**
     * Check if this status allows settlement.
     * 
     * @return true if settlement is allowed
     */
    public boolean allowsSettlement() {
        return this == REALIZED_UNSETTLED;
    }
    
    /**
     * Check if this status allows deferral.
     * 
     * @return true if deferral is allowed
     */
    public boolean allowsDeferral() {
        return this == ACCRUED;
    }
    
    /**
     * Check if this status allows realization.
     * 
     * @return true if realization is allowed
     */
    public boolean allowsRealization() {
        return this == ACCRUED || this == REALIZED_DEFERRED;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return displayName;
    }
}
