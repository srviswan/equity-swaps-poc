package com.finos.cashflow.model;

import java.util.Objects;
import java.util.UUID;

/**
 * Record representing a thread partition key for cashflow processing.
 * 
 * This key ensures that all operations for the same contract + underlier + calculation type
 * run in the same thread, providing data consistency and preventing race conditions.
 * 
 * @param contractId Unique contract identifier
 * @param securityId Underlier (e.g., AAPL, MSFT, SPY)
 * @param calculationType Type of calculation (INTEREST or EQUITY)
 */
public record ThreadPartitionKey(
    UUID contractId,
    String securityId,
    CalculationType calculationType
) {
    
    /**
     * Create a partition key from the given parameters.
     * 
     * @param contractId Contract ID
     * @param securityId Security ID
     * @param calculationType Calculation type
     * @return ThreadPartitionKey instance
     */
    public ThreadPartitionKey(UUID contractId, String securityId, CalculationType calculationType) {
        Objects.requireNonNull(contractId, "Contract ID cannot be null");
        Objects.requireNonNull(securityId, "Security ID cannot be null");
        Objects.requireNonNull(calculationType, "Calculation type cannot be null");
        
        if (securityId.trim().isEmpty()) {
            throw new IllegalArgumentException("Security ID cannot be empty");
        }
        
        this.contractId = contractId;
        this.securityId = securityId;
        this.calculationType = calculationType;
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
     * Get the hash code for this partition key.
     * 
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(contractId, securityId, calculationType);
    }
    
    /**
     * Check if this partition key equals another object.
     * 
     * @param obj Object to compare
     * @return true if equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ThreadPartitionKey that = (ThreadPartitionKey) obj;
        return Objects.equals(contractId, that.contractId) &&
               Objects.equals(securityId, that.securityId) &&
               calculationType == that.calculationType;
    }
    
    /**
     * Get the string representation of this partition key.
     * 
     * @return String representation
     */
    @Override
    public String toString() {
        return getPartitionString();
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
        return switch (calculationType) {
            case INTEREST -> "Interest calculations for " + securityId + " in contract " + contractId;
            case EQUITY -> "Equity calculations for " + securityId + " in contract " + contractId;
        };
    }
}
