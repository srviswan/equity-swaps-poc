package com.finos.cashflow.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Request for generating performance cashflows based on equity valuation.
 */
public class PerformanceCashflowGenerationRequest {
    
    @NotEmpty(message = "Contract IDs cannot be empty")
    private List<UUID> contractIds;
    
    @NotNull(message = "Valuation date is required")
    private LocalDate valuationDate;
    
    private MarketData marketData;
    private CalculationMethod calculationMethod = CalculationMethod.MARK_TO_MARKET;
    private boolean includeComponents = true;
    
    // Constructors
    public PerformanceCashflowGenerationRequest() {}
    
    public PerformanceCashflowGenerationRequest(List<UUID> contractIds, LocalDate valuationDate) {
        this.contractIds = contractIds;
        this.valuationDate = valuationDate;
    }
    
    // Getters and Setters
    public List<UUID> getContractIds() {
        return contractIds;
    }
    
    public void setContractIds(List<UUID> contractIds) {
        this.contractIds = contractIds;
    }
    
    public LocalDate getValuationDate() {
        return valuationDate;
    }
    
    public void setValuationDate(LocalDate valuationDate) {
        this.valuationDate = valuationDate;
    }
    
    public MarketData getMarketData() {
        return marketData;
    }
    
    public void setMarketData(MarketData marketData) {
        this.marketData = marketData;
    }
    
    public CalculationMethod getCalculationMethod() {
        return calculationMethod;
    }
    
    public void setCalculationMethod(CalculationMethod calculationMethod) {
        this.calculationMethod = calculationMethod;
    }
    
    public boolean isIncludeComponents() {
        return includeComponents;
    }
    
    public void setIncludeComponents(boolean includeComponents) {
        this.includeComponents = includeComponents;
    }
    
    // Supporting classes
    public static class MarketData {
        private Map<String, Double> prices;
        private Map<String, Double> interestRates;
        private Map<String, Double> fxRates;
        private Map<String, Object> dividendData;
        
        // Constructors
        public MarketData() {}
        
        // Getters and Setters
        public Map<String, Double> getPrices() {
            return prices;
        }
        
        public void setPrices(Map<String, Double> prices) {
            this.prices = prices;
        }
        
        public Map<String, Double> getInterestRates() {
            return interestRates;
        }
        
        public void setInterestRates(Map<String, Double> interestRates) {
            this.interestRates = interestRates;
        }
        
        public Map<String, Double> getFxRates() {
            return fxRates;
        }
        
        public void setFxRates(Map<String, Double> fxRates) {
            this.fxRates = fxRates;
        }
        
        public Map<String, Object> getDividendData() {
            return dividendData;
        }
        
        public void setDividendData(Map<String, Object> dividendData) {
            this.dividendData = dividendData;
        }
    }
    
    // Enum
    public enum CalculationMethod {
        MARK_TO_MARKET, MODEL_VALUATION, EXTERNAL_PRICE, INTERNAL_MODEL
    }
}
