package com.lifecycle.cashflow.model;

/**
 * Enum representing the type of calculation for thread partitioning.
 * 
 * This enum is used to separate different types of calculations
 * into different thread partitions for optimal performance.
 */
public enum CalculationType {
    
    INTEREST("Interest", "Interest accruals and rate calculations"),
    EQUITY("Equity", "Equity P&L and dividend calculations");
    
    private final String displayName;
    private final String description;
    
    CalculationType(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }
    
    /**
     * Check if this calculation type is for interest calculations.
     * 
     * @return true if this is an interest calculation
     */
    public boolean isInterest() {
        return this == INTEREST;
    }
    
    /**
     * Check if this calculation type is for equity calculations.
     * 
     * @return true if this is an equity calculation
     */
    public boolean isEquity() {
        return this == EQUITY;
    }
    
    /**
     * Get the processing frequency for this calculation type.
     * 
     * @return Processing frequency description
     */
    public String getProcessingFrequency() {
        return switch (this) {
            case INTEREST -> "Daily processing for accruals";
            case EQUITY -> "Market-driven processing for P&L";
        };
    }
    
    /**
     * Get the default scheduler for this calculation type.
     * 
     * @return Scheduler type
     */
    public String getDefaultScheduler() {
        return switch (this) {
            case INTEREST -> "BOUNDED_ELASTIC";
            case EQUITY -> "PARALLEL";
        };
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
