package com.finos.synthetics.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example demonstrating the use of CDM (Common Domain Model) classes
 * for equity swaps. This shows how to work with the latest CDM Java
 * dependency version 7.0.0-dev.14.
 */
public class EquitySwapExample {
    
    private static final Logger logger = LoggerFactory.getLogger(EquitySwapExample.class);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    /**
     * Demonstrates basic CDM usage for equity swaps
     */
    public void demonstrateCDMUsage() {
        logger.info("Starting CDM Equity Swap Example");
        
        try {
            // Note: The actual CDM classes would be imported from the CDM package
            // For demonstration purposes, we'll show the structure
            
            // Example of how CDM classes would be used:
            // Trade trade = new Trade();
            // Product product = new Product();
            // Party party = new Party();
            
            logger.info("CDM classes are available from org.finos.cdm package");
            logger.info("Version: 7.0.0-dev.14");
            
            // Show available CDM artifacts
            showCDMArtifacts();
            
        } catch (Exception e) {
            logger.error("Error demonstrating CDM usage", e);
        }
    }
    
    /**
     * Shows information about the available CDM artifacts
     */
    private void showCDMArtifacts() {
        logger.info("=== CDM Artifacts Information ===");
        logger.info("Group ID: org.finos.cdm");
        logger.info("Artifact ID: cdm-java");
        logger.info("Version: 7.0.0-dev.14");
        logger.info("License: Community Specification License 1.0");
        logger.info("Source: https://central.sonatype.com/artifact/org.finos.cdm/cdm-java/7.0.0-dev.14/overview");
        
        logger.info("\n=== CDM Key Components ===");
        logger.info("1. Trade Classes - Represent financial transactions");
        logger.info("2. Product Classes - Define financial instruments");
        logger.info("3. Party Classes - Represent counterparties");
        logger.info("4. Event Classes - Handle trade lifecycle events");
        logger.info("5. Reference Data - Currencies, countries, business days");
        
        logger.info("\n=== Equity Swap Specific Classes ===");
        logger.info("1. EquitySwap - Main product class for equity swaps");
        logger.info("2. EquityLeg - Represents equity leg of the swap");
        logger.info("3. FixedLeg - Represents fixed rate leg of the swap");
        logger.info("4. FloatingLeg - Represents floating rate leg of the swap");
        logger.info("5. Payment - Represents cash flows");
        logger.info("6. Schedule - Represents payment schedules");
    }
    
    /**
     * Example of creating a JSON representation of an equity swap
     */
    public String createEquitySwapJSON() {
        // This would be the actual CDM object structure
        // For now, we'll create a sample JSON structure
        
        EquitySwapData sampleSwap = new EquitySwapData();
        sampleSwap.setTradeId("EQSWAP-001");
        sampleSwap.setProductType("EquitySwap");
        sampleSwap.setNotional(1000000.0);
        sampleSwap.setCurrency("USD");
        sampleSwap.setEffectiveDate("2024-01-15");
        sampleSwap.setMaturityDate("2025-01-15");
        
        return gson.toJson(sampleSwap);
    }
    
    /**
     * Sample data class for demonstration
     */
    public static class EquitySwapData {
        private String tradeId;
        private String productType;
        private double notional;
        private String currency;
        private String effectiveDate;
        private String maturityDate;
        
        // Getters and setters
        public String getTradeId() { return tradeId; }
        public void setTradeId(String tradeId) { this.tradeId = tradeId; }
        
        public String getProductType() { return productType; }
        public void setProductType(String productType) { this.productType = productType; }
        
        public double getNotional() { return notional; }
        public void setNotional(double notional) { this.notional = notional; }
        
        public String getCurrency() { return currency; }
        public void setCurrency(String currency) { this.currency = currency; }
        
        public String getEffectiveDate() { return effectiveDate; }
        public void setEffectiveDate(String effectiveDate) { this.effectiveDate = effectiveDate; }
        
        public String getMaturityDate() { return maturityDate; }
        public void setMaturityDate(String maturityDate) { this.maturityDate = maturityDate; }
    }
    
    /**
     * Main method for demonstration
     */
    public static void main(String[] args) {
        EquitySwapExample example = new EquitySwapExample();
        example.demonstrateCDMUsage();
        
        System.out.println("\n=== Sample Equity Swap JSON ===");
        System.out.println(example.createEquitySwapJSON());
    }
} 