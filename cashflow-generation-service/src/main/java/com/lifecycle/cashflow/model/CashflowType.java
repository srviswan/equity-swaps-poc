package com.lifecycle.cashflow.model;

/**
 * Enum representing the type of cashflow.
 * 
 * This enum defines the different categories of cashflows
 * that can be generated and processed by the service.
 */
public enum CashflowType {
    
    INTEREST("Interest", "Interest rate accruals and payments"),
    DIVIDEND("Dividend", "Dividend entitlements and payments"),
    PERFORMANCE("Performance", "Equity return and unrealized P&L"),
    FEES("Fees", "Management fees, performance fees, and other charges");
    
    private final String displayName;
    private final String description;
    
    CashflowType(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }
    
    /**
     * Check if this cashflow type is interest-related.
     * 
     * @return true if this is an interest cashflow
     */
    public boolean isInterest() {
        return this == INTEREST;
    }
    
    /**
     * Check if this cashflow type is dividend-related.
     * 
     * @return true if this is a dividend cashflow
     */
    public boolean isDividend() {
        return this == DIVIDEND;
    }
    
    /**
     * Check if this cashflow type is performance-related.
     * 
     * @return true if this is a performance cashflow
     */
    public boolean isPerformance() {
        return this == PERFORMANCE;
    }
    
    /**
     * Check if this cashflow type is fee-related.
     * 
     * @return true if this is a fee cashflow
     */
    public boolean isFees() {
        return this == FEES;
    }
    
    /**
     * Get the calculation type associated with this cashflow type.
     * 
     * @return Associated calculation type
     */
    public CalculationType getAssociatedCalculationType() {
        return switch (this) {
            case INTEREST -> CalculationType.INTEREST;
            case DIVIDEND, PERFORMANCE -> CalculationType.EQUITY;
            case FEES -> CalculationType.INTEREST; // Fees typically processed with interest
        };
    }
    
    /**
     * Check if this cashflow type requires market data.
     * 
     * @return true if market data is required
     */
    public boolean requiresMarketData() {
        return this == PERFORMANCE || this == DIVIDEND;
    }
    
    /**
     * Check if this cashflow type is processed daily.
     * 
     * @return true if processed daily
     */
    public boolean isProcessedDaily() {
        return this == INTEREST;
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
