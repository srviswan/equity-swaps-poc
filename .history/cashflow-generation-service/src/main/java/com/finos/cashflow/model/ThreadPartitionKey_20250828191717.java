package com.finos.cashflow.model;

import java.util.Objects;
import java.util.UUID;

/**
 * Record representing a thread partition key for cashflow processing.
 * 
 * This key ensures that all operations for the same contract + underlier + calculation type
 * run in the same thread, providing data consistency and preventing race conditions.
 */
public record ThreadPartitionKey(
    UUID contractId,
    String securityId,
    CalculationType calculationType
) {
    
    /**
     * Create a partition key from the given parameters.
     */
    public ThreadPartitionKey {
        Objects.requireNonNull(contractId, "Contract ID cannot be null");
        Objects.requireNonNull(securityId, "Security ID cannot be null");
        Objects.requireNonNull(calculationType, "Calculation type cannot be null");
        
        if (securityId.trim().isEmpty()) {
            throw new IllegalArgumentException("Security ID cannot be empty");
        }
    }
    
    /**
     * Get the string representation of this partition key.
     * 
     * @return String representation in format contractId:securityId:calculationType
     */
    public String getPartitionString() {
        return contractId + ":" + securityId + ":" + calculationType.name();
    }
    
    /**
     * Check if this partition is for interest calculations.
     * 
     * @return true if this is an interest partition
     */
    public boolean isInterestPartition() {
        return calculationType == CalculationType.INTEREST;
    }
    
    /**
     * Check if this partition is for equity calculations.
     * 
     * @return true if this is an equity partition
     */
    public boolean isEquityPartition() {
        return calculationType == CalculationType.EQUITY;
    }
    
    /**
     * Get the partition type description.
     * 
     * @return Partition type description
     */
    public String getPartitionTypeDescription() {
        if (calculationType == CalculationType.INTEREST) {
            return "Interest calculations for " + securityId + " in contract " + contractId;
        } else {
            return "Equity calculations for " + securityId + " in contract " + contractId;
        }
    }
}
