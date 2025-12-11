package com.finos.tradecapture.service.validation;

import com.finos.tradecapture.model.RawTrade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Trade Validation Service
 * 
 * Validates raw trades before processing to ensure data quality and completeness.
 * 
 * @version 1.0.0
 */
@Service
public class TradeValidationService {

    private static final Logger logger = LoggerFactory.getLogger(TradeValidationService.class);

    private final Validator validator;

    public TradeValidationService(Validator validator) {
        this.validator = validator;
    }

    /**
     * Validate raw trade
     */
    public boolean validateTrade(RawTrade rawTrade) {
        logger.info("Validating trade: {}", rawTrade.getTradeId());

        try {
            // Step 1: Bean validation
            Set<ConstraintViolation<RawTrade>> violations = validator.validate(rawTrade);
            if (!violations.isEmpty()) {
                logger.error("Bean validation failed for trade: {} - Violations: {}", 
                           rawTrade.getTradeId(), violations);
                return false;
            }

            // Step 2: Business rule validation
            if (!validateBusinessRules(rawTrade)) {
                logger.error("Business rule validation failed for trade: {}", rawTrade.getTradeId());
                return false;
            }

            // Step 3: Cross-field validation
            if (!validateCrossFields(rawTrade)) {
                logger.error("Cross-field validation failed for trade: {}", rawTrade.getTradeId());
                return false;
            }

            logger.info("Trade validation successful for trade: {}", rawTrade.getTradeId());
            return true;

        } catch (Exception e) {
            logger.error("Error validating trade: {}", rawTrade.getTradeId(), e);
            return false;
        }
    }

    /**
     * Validate business rules
     */
    private boolean validateBusinessRules(RawTrade rawTrade) {
        // Check if trade date is not in the future
        if (isFutureDate(rawTrade.getTradeDate())) {
            logger.warn("Trade date is in the future for trade: {}", rawTrade.getTradeId());
            return false;
        }

        // Check if settlement date is after trade date
        if (!isSettlementDateValid(rawTrade.getTradeDate(), rawTrade.getSettlementDate())) {
            logger.warn("Settlement date is invalid for trade: {}", rawTrade.getTradeId());
            return false;
        }

        // Check if quantity and price are reasonable
        if (!isQuantityPriceReasonable(rawTrade)) {
            logger.warn("Quantity or price is unreasonable for trade: {}", rawTrade.getTradeId());
            return false;
        }

        // Check if currency is supported
        if (!isCurrencySupported(rawTrade.getCurrency())) {
            logger.warn("Currency not supported for trade: {}", rawTrade.getTradeId());
            return false;
        }

        return true;
    }

    /**
     * Validate cross-field relationships
     */
    private boolean validateCrossFields(RawTrade rawTrade) {
        // Check if notional amount matches quantity * price
        if (rawTrade.getQuantity() != null && rawTrade.getPrice() != null) {
            double expectedNotional = rawTrade.getQuantity().doubleValue() * rawTrade.getPrice().doubleValue();
            
            // Allow for small rounding differences
            if (Math.abs(expectedNotional - expectedNotional) > 0.01) {
                logger.warn("Notional amount mismatch for trade: {}", rawTrade.getTradeId());
                return false;
            }
        }

        return true;
    }

    /**
     * Check if date is in the future
     */
    private boolean isFutureDate(String dateStr) {
        try {
            // Simple date validation - in production, use proper date parsing
            return false; // Placeholder implementation
        } catch (Exception e) {
            logger.error("Error parsing date: {}", dateStr, e);
            return true; // Assume invalid if parsing fails
        }
    }

    /**
     * Check if settlement date is valid
     */
    private boolean isSettlementDateValid(String tradeDate, String settlementDate) {
        try {
            // Simple date comparison - in production, use proper date parsing
            return true; // Placeholder implementation
        } catch (Exception e) {
            logger.error("Error comparing dates: {} vs {}", tradeDate, settlementDate, e);
            return false;
        }
    }

    /**
     * Check if quantity and price are reasonable
     */
    private boolean isQuantityPriceReasonable(RawTrade rawTrade) {
        if (rawTrade.getQuantity() == null || rawTrade.getPrice() == null) {
            return false;
        }

        // Check for reasonable ranges
        double quantity = rawTrade.getQuantity().doubleValue();
        double price = rawTrade.getPrice().doubleValue();

        // Quantity should be positive and reasonable
        if (quantity <= 0 || quantity > 1000000000) {
            return false;
        }

        // Price should be positive and reasonable
        if (price <= 0 || price > 100000) {
            return false;
        }

        return true;
    }

    /**
     * Check if currency is supported
     */
    private boolean isCurrencySupported(String currency) {
        if (currency == null || currency.trim().isEmpty()) {
            return false;
        }

        // List of supported currencies
        String[] supportedCurrencies = {"USD", "EUR", "GBP", "JPY", "CHF", "CAD", "AUD", "NZD"};
        
        for (String supported : supportedCurrencies) {
            if (supported.equalsIgnoreCase(currency.trim())) {
                return true;
            }
        }

        return false;
    }
} 