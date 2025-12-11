package com.lifecycle.cashflow.service;

import com.lifecycle.cashflow.model.Cashflow;
import com.lifecycle.cashflow.model.CashflowStatus;
import com.lifecycle.cashflow.model.CashflowType;
import com.lifecycle.cashflow.model.CalculationType;
import com.lifecycle.cashflow.model.DailyAccrual;
import com.lifecycle.cashflow.model.UnrealizedPnL;
import com.lifecycle.cashflow.repository.CashflowRepository;
import com.lifecycle.cashflow.repository.DailyAccrualRepository;
import com.lifecycle.cashflow.repository.UnrealizedPnLRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class EquityPerformanceService {
    
    private static final Logger logger = LoggerFactory.getLogger(EquityPerformanceService.class);
    
    private final DailyAccrualRepository dailyAccrualRepository;
    private final UnrealizedPnLRepository unrealizedPnLRepository;
    private final CashflowRepository cashflowRepository;
    
    @Autowired
    public EquityPerformanceService(DailyAccrualRepository dailyAccrualRepository,
                                  UnrealizedPnLRepository unrealizedPnLRepository,
                                  CashflowRepository cashflowRepository) {
        this.dailyAccrualRepository = dailyAccrualRepository;
        this.unrealizedPnLRepository = unrealizedPnLRepository;
        this.cashflowRepository = cashflowRepository;
    }
    
    /**
     * Calculate daily performance accruals for equity positions
     */
    public Flux<DailyAccrual> calculateDailyPerformanceAccruals(UUID contractId, String securityId,
                                                              BigDecimal quantity, BigDecimal currentPrice,
                                                              BigDecimal bookPrice, String currency,
                                                              LocalDate startDate, LocalDate endDate) {
        logger.info("Calculating daily performance accruals for contract: {}, security: {}, period: {} to {}",
                   contractId, securityId, startDate, endDate);
        
        return Flux.fromStream(startDate.datesUntil(endDate.plusDays(1)))
                .map(date -> calculatePerformanceAccrual(contractId, securityId, quantity, currentPrice, bookPrice, currency, date))
                .flatMap(dailyAccrualRepository::save);
    }
    
    /**
     * Calculate performance accrual for a specific date
     */
    public DailyAccrual calculatePerformanceAccrual(UUID contractId, String securityId, BigDecimal quantity,
                                                  BigDecimal currentPrice, BigDecimal bookPrice, String currency, LocalDate date) {
        BigDecimal marketValue = quantity.multiply(currentPrice);
        BigDecimal bookValue = quantity.multiply(bookPrice);
        BigDecimal unrealizedPnL = marketValue.subtract(bookValue);
        
        return new DailyAccrual(contractId, securityId, date, unrealizedPnL, currentPrice, currency);
    }
    
    /**
     * Calculate unrealized P&L for equity positions
     */
    public Mono<UnrealizedPnL> calculateUnrealizedPnL(UUID contractId, String securityId, BigDecimal quantity,
                                                     BigDecimal currentPrice, BigDecimal bookPrice, String currency,
                                                     LocalDate calculationDate) {
        logger.info("Calculating unrealized P&L for contract: {}, security: {}, date: {}", contractId, securityId, calculationDate);
        
        BigDecimal marketValue = quantity.multiply(currentPrice);
        BigDecimal bookValue = quantity.multiply(bookPrice);
        BigDecimal unrealizedPnL = marketValue.subtract(bookValue);
        
        UnrealizedPnL pnl = new UnrealizedPnL(contractId, securityId, calculationDate, unrealizedPnL, marketValue, bookValue,
                                              quantity, currentPrice, bookPrice, currency);
        
        return unrealizedPnLRepository.save(pnl);
    }
    
    /**
     * Generate performance cashflows from unrealized P&L
     */
    public Flux<Cashflow> generatePerformanceCashflows(UUID contractId, String securityId, LocalDate startDate, LocalDate endDate) {
        logger.info("Generating performance cashflows for contract: {}, security: {}, period: {} to {}",
                   contractId, securityId, startDate, endDate);
        
        return unrealizedPnLRepository.findUnrealizedPnLForPerformance(contractId, securityId, startDate, endDate)
                .collectList()
                .flatMapMany(pnlList -> {
                    if (pnlList.isEmpty()) {
                        return Flux.empty();
                    }
                    
                    // Calculate total performance for the period
                    BigDecimal totalPerformance = pnlList.stream()
                            .map(UnrealizedPnL::getUnrealizedPnL)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    
                    // Create cashflow for the total performance
                    Cashflow cashflow = new Cashflow();
                    cashflow.setContractId(contractId);
                    cashflow.setLegId(UUID.randomUUID()); // Default leg ID for now
                    cashflow.setSecurityId(securityId);
                    cashflow.setCashflowType(CashflowType.PERFORMANCE);
                    cashflow.setAmount(totalPerformance);
                    cashflow.setCurrency(pnlList.get(0).getCurrency());
                    cashflow.setStatus(CashflowStatus.ACCRUED);
                    cashflow.setSettlementDate(endDate);
                    cashflow.setCalculationType(CalculationType.EQUITY);
                    cashflow.setCalculationDate(endDate);
                    cashflow.setCreatedBy("SYSTEM");
                    cashflow.setUpdatedBy("SYSTEM");
                    
                    return cashflowRepository.save(cashflow).thenMany(Flux.just(cashflow));
                });
    }
    
    /**
     * Calculate dividend accruals for equity positions
     */
    public Flux<DailyAccrual> calculateDividendAccruals(UUID contractId, String securityId, BigDecimal quantity,
                                                       BigDecimal dividendRate, String currency, LocalDate exDate) {
        logger.info("Calculating dividend accruals for contract: {}, security: {}, ex-date: {}", contractId, securityId, exDate);
        
        BigDecimal dividendAmount = quantity.multiply(dividendRate);
        
        DailyAccrual accrual = new DailyAccrual(contractId, securityId, exDate, dividendAmount, quantity, dividendRate, currency);
        
        return dailyAccrualRepository.save(accrual).thenMany(Flux.just(accrual));
    }
    
    /**
     * Generate dividend cashflows
     */
    public Flux<Cashflow> generateDividendCashflows(UUID contractId, String securityId, LocalDate startDate, LocalDate endDate) {
        logger.info("Generating dividend cashflows for contract: {}, security: {}, period: {} to {}",
                   contractId, securityId, startDate, endDate);
        
        return dailyAccrualRepository.findDividendAccruals(contractId, startDate, endDate)
                .collectList()
                .flatMapMany(accruals -> {
                    if (accruals.isEmpty()) {
                        return Flux.empty();
                    }
                    
                    // Sum up all dividend accruals for the period
                    BigDecimal totalDividend = accruals.stream()
                            .map(DailyAccrual::getAccrualAmount)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    
                    // Create cashflow for the total dividend
                    Cashflow cashflow = new Cashflow();
                    cashflow.setContractId(contractId);
                    cashflow.setLegId(UUID.randomUUID()); // Default leg ID for now
                    cashflow.setSecurityId(securityId);
                    cashflow.setCashflowType(CashflowType.DIVIDEND);
                    cashflow.setAmount(totalDividend);
                    cashflow.setCurrency(accruals.get(0).getCurrency());
                    cashflow.setStatus(CashflowStatus.ACCRUED);
                    cashflow.setSettlementDate(endDate);
                    cashflow.setCalculationType(CalculationType.EQUITY);
                    cashflow.setCalculationDate(endDate);
                    cashflow.setCreatedBy("SYSTEM");
                    cashflow.setUpdatedBy("SYSTEM");
                    
                    return cashflowRepository.save(cashflow).thenMany(Flux.just(cashflow));
                });
    }
    
    /**
     * Calculate total return (price + dividend)
     */
    public BigDecimal calculateTotalReturn(BigDecimal priceReturn, BigDecimal dividendYield) {
        return priceReturn.add(dividendYield);
    }
    
    /**
     * Calculate price return percentage
     */
    public BigDecimal calculatePriceReturnPercentage(BigDecimal currentPrice, BigDecimal bookPrice) {
        if (bookPrice.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        
        return currentPrice.subtract(bookPrice)
                .divide(bookPrice, 4, RoundingMode.HALF_UP)
                .multiply(new BigDecimal("100"));
    }
    
    /**
     * Calculate dividend yield
     */
    public BigDecimal calculateDividendYield(BigDecimal dividendAmount, BigDecimal currentPrice) {
        if (currentPrice.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        
        return dividendAmount.divide(currentPrice, 4, RoundingMode.HALF_UP)
                .multiply(new BigDecimal("100"));
    }
    
    /**
     * Update market prices and recalculate P&L
     */
    public Mono<Void> updateMarketPrice(UUID contractId, String securityId, BigDecimal newPrice, LocalDate effectiveDate) {
        logger.info("Updating market price for contract: {}, security: {}, new price: {}, effective: {}",
                   contractId, securityId, newPrice, effectiveDate);
        
        return unrealizedPnLRepository.findLatestUnrealizedPnLBySecurity(securityId)
                .flatMap(pnl -> {
                    pnl.updateMarketPrice(newPrice);
                    return unrealizedPnLRepository.save(pnl);
                })
                .then();
    }
    
    /**
     * Get performance metrics for a contract
     */
    public Mono<PerformanceMetrics> getPerformanceMetrics(UUID contractId, String securityId, LocalDate startDate, LocalDate endDate) {
        return Mono.zip(
                unrealizedPnLRepository.findUnrealizedPnLForPerformance(contractId, securityId, startDate, endDate).collectList(),
                dailyAccrualRepository.findDividendAccruals(contractId, startDate, endDate).collectList()
        ).map(tuple -> {
            var pnlList = tuple.getT1();
            var dividendList = tuple.getT2();
            
            BigDecimal totalPnL = pnlList.stream()
                    .map(UnrealizedPnL::getUnrealizedPnL)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            
            BigDecimal totalDividend = dividendList.stream()
                    .map(DailyAccrual::getAccrualAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            
            BigDecimal totalReturn = totalPnL.add(totalDividend);
            
            return new PerformanceMetrics(contractId, securityId, startDate, endDate, totalPnL, totalDividend, totalReturn);
        });
    }
    
    /**
     * Performance metrics data class
     */
    public static class PerformanceMetrics {
        private final UUID contractId;
        private final String securityId;
        private final LocalDate startDate;
        private final LocalDate endDate;
        private final BigDecimal totalPnL;
        private final BigDecimal totalDividend;
        private final BigDecimal totalReturn;
        
        public PerformanceMetrics(UUID contractId, String securityId, LocalDate startDate, LocalDate endDate,
                                BigDecimal totalPnL, BigDecimal totalDividend, BigDecimal totalReturn) {
            this.contractId = contractId;
            this.securityId = securityId;
            this.startDate = startDate;
            this.endDate = endDate;
            this.totalPnL = totalPnL;
            this.totalDividend = totalDividend;
            this.totalReturn = totalReturn;
        }
        
        // Getters
        public UUID getContractId() { return contractId; }
        public String getSecurityId() { return securityId; }
        public LocalDate getStartDate() { return startDate; }
        public LocalDate getEndDate() { return endDate; }
        public BigDecimal getTotalPnL() { return totalPnL; }
        public BigDecimal getTotalDividend() { return totalDividend; }
        public BigDecimal getTotalReturn() { return totalReturn; }
        
        @Override
        public String toString() {
            return "PerformanceMetrics{" +
                    "contractId=" + contractId +
                    ", securityId='" + securityId + '\'' +
                    ", startDate=" + startDate +
                    ", endDate=" + endDate +
                    ", totalPnL=" + totalPnL +
                    ", totalDividend=" + totalDividend +
                    ", totalReturn=" + totalReturn +
                    '}';
        }
    }
}
