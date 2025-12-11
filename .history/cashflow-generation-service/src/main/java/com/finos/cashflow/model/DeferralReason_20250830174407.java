package com.finos.cashflow.model;

/**
 * Enumeration of possible reasons for deferring a cashflow.
 */
public enum DeferralReason {
    BUSINESS_RULE("Business rule violation"),
    REGULATORY("Regulatory requirement"),
    COUNTERPARTY_REQUEST("Counterparty request"),
    MARKET_CONDITIONS("Market conditions"),
    TECHNICAL_ISSUE("Technical issue"),
    CREDIT_LIMIT("Credit limit exceeded"),
    COMPLIANCE("Compliance review required"),
    SETTLEMENT_FAILURE("Settlement failure"),
    MANUAL_REVIEW("Manual review required");
    
    private final String description;
    
    DeferralReason(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return this.name() + " (" + description + ")";
    }
}

