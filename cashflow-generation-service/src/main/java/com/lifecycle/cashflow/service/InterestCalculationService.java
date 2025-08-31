package com.lifecycle.cashflow.service;

import com.lifecycle.cashflow.model.Cashflow;
import com.lifecycle.cashflow.model.CashflowStatus;
import com.lifecycle.cashflow.model.CashflowType;
import com.lifecycle.cashflow.model.CalculationType;
import com.lifecycle.cashflow.model.DailyAccrual;
import com.lifecycle.cashflow.repository.CashflowRepository;
import com.lifecycle.cashflow.repository.DailyAccrualRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class InterestCalculationService {
    
    private static final Logger logger = LoggerFactory.getLogger(InterestCalculationService.class);
    
    private final DailyAccrualRepository dailyAccrualRepository;
    private final CashflowRepository cashflowRepository;
    
    @Autowired
    public InterestCalculationService(DailyAccrualRepository dailyAccrualRepository, 
                                   CashflowRepository cashflowRepository) {
        this.dailyAccrualRepository = dailyAccrualRepository;
        this.cashflowRepository = cashflowRepository;
    }
    
    /**
     * Calculate daily interest accruals for a contract
     */
    public Flux<DailyAccrual> calculateDailyInterestAccruals(UUID contractId, String securityId, 
                                                           BigDecimal principal, BigDecimal annualRate, 
                                                           String currency, LocalDate startDate, LocalDate endDate) {
        logger.info("Calculating daily interest accruals for contract: {}, security: {}, period: {} to {}", 
                   contractId, securityId, startDate, endDate);
        
        return Flux.fromStream(startDate.datesUntil(endDate.plusDays(1)))
                .filter(this::isBusinessDay)
                .map(date -> calculateInterestAccrual(contractId, securityId, principal, annualRate, currency, date))
                .flatMap(dailyAccrualRepository::save);
    }
    
    /**
     * Calculate interest accrual for a specific date
     */
    public DailyAccrual calculateInterestAccrual(UUID contractId, String securityId, BigDecimal principal, 
                                               BigDecimal annualRate, String currency, LocalDate date) {
        BigDecimal dailyRate = annualRate.divide(new BigDecimal("365"), 8, RoundingMode.HALF_UP);
        BigDecimal accrualAmount = principal.multiply(dailyRate);
        
        return new DailyAccrual(contractId, securityId, date, accrualAmount, annualRate, currency, 1, 1);
    }
    
    /**
     * Generate interest cashflows from daily accruals
     */
    public Flux<Cashflow> generateInterestCashflows(UUID contractId, String securityId, 
                                                   LocalDate startDate, LocalDate endDate) {
        logger.info("Generating interest cashflows for contract: {}, security: {}, period: {} to {}", 
                   contractId, securityId, startDate, endDate);
        
        return dailyAccrualRepository.findInterestAccruals(contractId, startDate, endDate)
                .collectList()
                .flatMapMany(accruals -> {
                    if (accruals.isEmpty()) {
                        return Flux.empty();
                    }
                    
                    // Sum up all accruals for the period
                    BigDecimal totalAccrual = accruals.stream()
                            .map(DailyAccrual::getAccrualAmount)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    
                    // Create cashflow for the total accrued amount
                    Cashflow cashflow = new Cashflow();
                    cashflow.setContractId(contractId);
                    cashflow.setLegId(UUID.randomUUID()); // Default leg ID for now
                    cashflow.setSecurityId(securityId);
                    cashflow.setCashflowType(CashflowType.INTEREST);
                    cashflow.setAmount(totalAccrual);
                    cashflow.setCurrency(accruals.get(0).getCurrency());
                    cashflow.setStatus(CashflowStatus.ACCRUED);
                    cashflow.setSettlementDate(endDate);
                    cashflow.setCalculationType(CalculationType.INTEREST);
                    cashflow.setCalculationDate(endDate);
                    cashflow.setCreatedBy("SYSTEM");
                    cashflow.setUpdatedBy("SYSTEM");
                    
                    return cashflowRepository.save(cashflow).thenMany(Flux.just(cashflow));
                });
    }
    
    /**
     * Calculate compound interest for a period
     */
    public BigDecimal calculateCompoundInterest(BigDecimal principal, BigDecimal annualRate, 
                                             LocalDate startDate, LocalDate endDate) {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        BigDecimal dailyRate = annualRate.divide(new BigDecimal("365"), 8, RoundingMode.HALF_UP);
        
        // Simple interest calculation (can be enhanced for compound interest)
        return principal.multiply(dailyRate).multiply(new BigDecimal(days));
    }
    
    /**
     * Calculate interest with business day adjustments
     */
    public BigDecimal calculateBusinessDayInterest(BigDecimal principal, BigDecimal annualRate, 
                                                LocalDate startDate, LocalDate endDate) {
        long businessDays = startDate.datesUntil(endDate.plusDays(1))
                .filter(this::isBusinessDay)
                .count();
        
        BigDecimal dailyRate = annualRate.divide(new BigDecimal("365"), 8, RoundingMode.HALF_UP);
        return principal.multiply(dailyRate).multiply(new BigDecimal(businessDays));
    }
    
    /**
     * Update interest rates and recalculate accruals
     */
    public Mono<Void> updateInterestRate(UUID contractId, String securityId, BigDecimal newRate, LocalDate effectiveDate) {
        logger.info("Updating interest rate for contract: {}, security: {}, new rate: {}, effective: {}", 
                   contractId, securityId, newRate, effectiveDate);
        
        return dailyAccrualRepository.findInterestAccruals(contractId, effectiveDate, LocalDate.now())
                .flatMap(accrual -> {
                    // Recalculate accrual amount with new rate
                    BigDecimal newAccrualAmount = accrual.getAccrualAmount()
                            .multiply(newRate)
                            .divide(accrual.getRate(), 2, RoundingMode.HALF_UP);
                    
                    accrual.updateAccrualAmount(newAccrualAmount);
                    accrual.updateRate(newRate);
                    
                    return dailyAccrualRepository.save(accrual);
                })
                .then();
    }
    
    /**
     * Get interest accruals for a specific period
     */
    public Flux<DailyAccrual> getInterestAccruals(UUID contractId, LocalDate startDate, LocalDate endDate) {
        return dailyAccrualRepository.findInterestAccruals(contractId, startDate, endDate);
    }
    
    /**
     * Get total interest accrued for a contract
     */
    public Mono<BigDecimal> getTotalInterestAccrued(UUID contractId, LocalDate startDate, LocalDate endDate) {
        return dailyAccrualRepository.findInterestAccruals(contractId, startDate, endDate)
                .map(DailyAccrual::getAccrualAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    /**
     * Check if a date is a business day (simplified - can be enhanced with holiday calendar)
     */
    private boolean isBusinessDay(LocalDate date) {
        // Monday = 1, Sunday = 7
        int dayOfWeek = date.getDayOfWeek().getValue();
        return dayOfWeek >= 1 && dayOfWeek <= 5; // Monday to Friday
    }
    
    /**
     * Calculate interest for floating rate instruments
     */
    public BigDecimal calculateFloatingRateInterest(BigDecimal principal, BigDecimal baseRate, 
                                                  BigDecimal spread, LocalDate startDate, LocalDate endDate) {
        BigDecimal totalRate = baseRate.add(spread);
        return calculateBusinessDayInterest(principal, totalRate, startDate, endDate);
    }
    
    /**
     * Calculate interest with day count conventions
     */
    public BigDecimal calculateInterestWithDayCount(BigDecimal principal, BigDecimal annualRate, 
                                                  LocalDate startDate, LocalDate endDate, String dayCountConvention) {
        long days;
        
        switch (dayCountConvention.toUpperCase()) {
            case "ACT/365":
                days = ChronoUnit.DAYS.between(startDate, endDate);
                break;
            case "30/360":
                days = calculate30_360Days(startDate, endDate);
                break;
            case "ACT/360":
                days = ChronoUnit.DAYS.between(startDate, endDate);
                return principal.multiply(annualRate).multiply(new BigDecimal(days))
                        .divide(new BigDecimal("360"), 2, RoundingMode.HALF_UP);
            default:
                days = ChronoUnit.DAYS.between(startDate, endDate);
        }
        
        return principal.multiply(annualRate).multiply(new BigDecimal(days))
                .divide(new BigDecimal("365"), 2, RoundingMode.HALF_UP);
    }
    
    /**
     * Calculate days using 30/360 day count convention
     */
    private long calculate30_360Days(LocalDate startDate, LocalDate endDate) {
        int startDay = Math.min(startDate.getDayOfMonth(), 30);
        int endDay = Math.min(endDate.getDayOfMonth(), 30);
        
        int startMonth = startDate.getMonthValue();
        int endMonth = endDate.getMonthValue();
        
        int startYear = startDate.getYear();
        int endYear = endDate.getYear();
        
        return (endYear - startYear) * 360 + (endMonth - startMonth) * 30 + (endDay - startDay);
    }
}
