package com.lifecycle.cashflow.service;

import com.lifecycle.cashflow.model.Cashflow;
import com.lifecycle.cashflow.model.CashflowPageResponse;
import com.lifecycle.cashflow.model.CashflowStatus;
import com.lifecycle.cashflow.model.CashflowType;
import com.lifecycle.cashflow.model.DailyAccrualPageResponse;
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
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CashflowQueryService {
    
    private static final Logger logger = LoggerFactory.getLogger(CashflowQueryService.class);
    
    private final CashflowRepository cashflowRepository;
    private final DailyAccrualRepository dailyAccrualRepository;
    private final UnrealizedPnLRepository unrealizedPnLRepository;
    
    @Autowired
    public CashflowQueryService(CashflowRepository cashflowRepository,
                               DailyAccrualRepository dailyAccrualRepository,
                               UnrealizedPnLRepository unrealizedPnLRepository) {
        this.cashflowRepository = cashflowRepository;
        this.dailyAccrualRepository = dailyAccrualRepository;
        this.unrealizedPnLRepository = unrealizedPnLRepository;
    }
    
    /**
     * Get cashflows by contract ID
     */
    public Flux<Cashflow> getCashflowsByContract(UUID contractId) {
        return cashflowRepository.findByContractId(contractId);
    }
    
    /**
     * Get cashflows by contract ID and type
     */
    public Flux<Cashflow> getCashflowsByContractAndType(UUID contractId, CashflowType type) {
        return cashflowRepository.findByContractIdAndCashflowType(contractId, type);
    }
    
    /**
     * Get cashflows by contract ID and status
     */
    public Flux<Cashflow> getCashflowsByContractAndStatus(UUID contractId, CashflowStatus status) {
        return cashflowRepository.findByContractIdAndStatus(contractId, status);
    }
    
    /**
     * Get cashflows by multiple contract IDs
     */
    public Flux<Cashflow> getCashflowsByContracts(List<UUID> contractIds) {
        return cashflowRepository.findByContractIdIn(contractIds);
    }
    
    /**
     * Get cashflows by multiple contract IDs and type
     */
    public Flux<Cashflow> getCashflowsByContractsAndType(List<UUID> contractIds, CashflowType type) {
        return cashflowRepository.findByContractIdInAndCashflowType(contractIds, type);
    }
    
    /**
     * Get cashflows by multiple contract IDs and status
     */
    public Flux<Cashflow> getCashflowsByContractsAndStatus(List<UUID> contractIds, CashflowStatus status) {
        return cashflowRepository.findByContractIdInAndStatus(contractIds, status);
    }
    
    /**
     * Get cashflows by settlement date range
     */
    public Flux<Cashflow> getCashflowsBySettlementDateRange(LocalDate startDate, LocalDate endDate) {
        return cashflowRepository.findBySettlementDateBetween(startDate, endDate);
    }
    
    /**
     * Get cashflows by contract and settlement date range
     */
    public Flux<Cashflow> getCashflowsByContractAndSettlementDateRange(UUID contractId, LocalDate startDate, LocalDate endDate) {
        return cashflowRepository.findByContractIdAndSettlementDateBetween(contractId, startDate, endDate);
    }
    
    /**
     * Get cashflows by underlier (security ID)
     */
    public Flux<Cashflow> getCashflowsBySecurity(String securityId) {
        return cashflowRepository.findBySecurityId(securityId);
    }
    
    /**
     * Get cashflows by contract and underlier
     */
    public Flux<Cashflow> getCashflowsByContractAndSecurity(UUID contractId, String securityId) {
        return cashflowRepository.findByContractIdAndSecurityId(contractId, securityId);
    }
    
    /**
     * Get cashflows by status
     */
    public Flux<Cashflow> getCashflowsByStatus(CashflowStatus status) {
        return cashflowRepository.findByStatus(status);
    }
    
    /**
     * Get cashflows by type
     */
    public Flux<Cashflow> getCashflowsByType(CashflowType type) {
        return cashflowRepository.findByCashflowType(type);
    }
    
    /**
     * Get cashflows for settlement processing
     */
    public Flux<Cashflow> getCashflowsForSettlement(LocalDate settlementDate) {
        return cashflowRepository.findCashflowsForSettlement(settlementDate);
    }
    
    /**
     * Get cashflows for accrual processing
     */
    public Flux<Cashflow> getCashflowsForAccrual(LocalDate accrualDate) {
        return cashflowRepository.findCashflowsForAccrual(accrualDate);
    }
    
    /**
     * Get performance cashflows for a contract
     */
    public Flux<Cashflow> getPerformanceCashflows(UUID contractId) {
        return cashflowRepository.findPerformanceCashflows(contractId);
    }
    
    /**
     * Get interest cashflows for a contract
     */
    public Flux<Cashflow> getInterestCashflows(UUID contractId) {
        return cashflowRepository.findInterestCashflows(contractId);
    }
    
    /**
     * Get dividend cashflows for a contract
     */
    public Flux<Cashflow> getDividendCashflows(UUID contractId) {
        return cashflowRepository.findDividendCashflows(contractId);
    }
    
    /**
     * Get daily accruals for interest calculations
     */
    public Flux<com.lifecycle.cashflow.model.DailyAccrual> getInterestAccruals(UUID contractId, LocalDate startDate, LocalDate endDate) {
        return dailyAccrualRepository.findInterestAccruals(contractId, startDate, endDate);
    }
    
    /**
     * Get daily accruals for dividend calculations
     */
    public Flux<com.lifecycle.cashflow.model.DailyAccrual> getDividendAccruals(UUID contractId, LocalDate startDate, LocalDate endDate) {
        return dailyAccrualRepository.findDividendAccruals(contractId, startDate, endDate);
    }
    
    /**
     * Get daily accruals for performance calculations
     */
    public Flux<com.lifecycle.cashflow.model.DailyAccrual> getPerformanceAccruals(UUID contractId, LocalDate startDate, LocalDate endDate) {
        return dailyAccrualRepository.findPerformanceAccruals(contractId, startDate, endDate);
    }
    
    /**
     * Get unrealized P&L for performance calculations
     */
    public Flux<com.lifecycle.cashflow.model.UnrealizedPnL> getUnrealizedPnLForPerformance(UUID contractId, String securityId, LocalDate startDate, LocalDate endDate) {
        return unrealizedPnLRepository.findUnrealizedPnLForPerformance(contractId, securityId, startDate, endDate);
    }
    
    /**
     * Count cashflows by contract ID
     */
    public Mono<Long> countCashflowsByContract(UUID contractId) {
        return cashflowRepository.countByContractId(contractId);
    }
    
    /**
     * Count cashflows by contract ID and status
     */
    public Mono<Long> countCashflowsByContractAndStatus(UUID contractId, CashflowStatus status) {
        return cashflowRepository.countByContractIdAndStatus(contractId, status);
    }
    
    /**
     * Count cashflows by contract ID and type
     */
    public Mono<Long> countCashflowsByContractAndType(UUID contractId, CashflowType type) {
        return cashflowRepository.findByContractIdAndCashflowType(contractId, type).count();
    }
    
    /**
     * Get total amount by contract ID
     */
    public Mono<BigDecimal> getTotalAmountByContract(UUID contractId) {
        return cashflowRepository.findByContractId(contractId)
                .map(Cashflow::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    /**
     * Get total amount by contract ID and type
     */
    public Mono<BigDecimal> getTotalAmountByContractAndType(UUID contractId, CashflowType type) {
        return cashflowRepository.findByContractIdAndCashflowType(contractId, type)
                .map(Cashflow::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    /**
     * Get total amount by contract ID and status
     */
    public Mono<BigDecimal> getTotalAmountByContractAndStatus(UUID contractId, CashflowStatus status) {
        return cashflowRepository.findByContractIdAndStatus(contractId, status)
                .map(Cashflow::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    /**
     * Get total amount by multiple contract IDs
     */
    public Mono<BigDecimal> getTotalAmountByContracts(List<UUID> contractIds) {
        return cashflowRepository.findByContractIdIn(contractIds)
                .map(Cashflow::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    /**
     * Get total amount by multiple contract IDs and type
     */
    public Mono<BigDecimal> getTotalAmountByContractsAndType(List<UUID> contractIds, CashflowType type) {
        return cashflowRepository.findByContractIdInAndCashflowType(contractIds, type)
                .map(Cashflow::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    /**
     * Get total amount by multiple contract IDs and status
     */
    public Mono<BigDecimal> getTotalAmountByContractsAndStatus(List<UUID> contractIds, CashflowStatus status) {
        return cashflowRepository.findByContractIdInAndStatus(contractIds, status)
                .map(Cashflow::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    /**
     * Get total amount by settlement date range
     */
    public Mono<BigDecimal> getTotalAmountBySettlementDateRange(LocalDate startDate, LocalDate endDate) {
        return cashflowRepository.findBySettlementDateBetween(startDate, endDate)
                .map(Cashflow::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    /**
     * Get total amount by underlier
     */
    public Mono<BigDecimal> getTotalAmountBySecurity(String securityId) {
        return cashflowRepository.findBySecurityId(securityId)
                .map(Cashflow::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    /**
     * Get total amount by status
     */
    public Mono<BigDecimal> getTotalAmountByStatus(CashflowStatus status) {
        return cashflowRepository.findByStatus(status)
                .map(Cashflow::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    /**
     * Get total amount by type
     */
    public Mono<BigDecimal> getTotalAmountByType(CashflowType type) {
        return cashflowRepository.findByCashflowType(type)
                .map(Cashflow::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    /**
     * Search cashflows with pagination
     */
    public Mono<CashflowPageResponse> searchCashflows(
            UUID contractId,
            UUID securityId,
            CashflowType cashflowType,
            CashflowStatus status,
            String currency,
            LocalDate startDate,
            LocalDate endDate,
            int page,
            int size
    ) {
        // Simple implementation - in real app would use proper pagination
        Flux<Cashflow> query = cashflowRepository.findAll();
        
        if (contractId != null) {
            query = query.filter(cf -> cf.getContractId().equals(contractId));
        }
        if (cashflowType != null) {
            query = query.filter(cf -> cf.getCashflowType().equals(cashflowType));
        }
        if (status != null) {
            query = query.filter(cf -> cf.getStatus().equals(status));
        }
        if (currency != null) {
            query = query.filter(cf -> cf.getCurrency().equals(currency));
        }
        if (startDate != null && endDate != null) {
            query = query.filter(cf -> 
                cf.getSettlementDate().isAfter(startDate.minusDays(1)) && 
                cf.getSettlementDate().isBefore(endDate.plusDays(1))
            );
        }
        
        return query
            .skip((long) page * size)
            .take(size)
            .collectList()
            .map(cashflows -> CashflowPageResponse.of(cashflows, page, size, cashflows.size()));
    }
    
    /**
     * Get cashflow by ID
     */
    public Mono<Cashflow> getCashflowById(UUID cashflowId) {
        return cashflowRepository.findById(cashflowId);
    }
    
    /**
     * Get daily accruals with pagination
     */
    public Mono<DailyAccrualPageResponse> getDailyAccruals(
            UUID contractId,
            LocalDate startDate,
            LocalDate endDate,
            int page,
            int size
    ) {
        // Simple implementation
        return dailyAccrualRepository.findInterestAccruals(contractId, startDate, endDate)
            .map(accrual -> new com.lifecycle.cashflow.model.DailyAccrualGenerationResponse.DailyAccrual(
                accrual.getContractId(),
                accrual.getAccrualDate(),
                com.lifecycle.cashflow.model.DailyAccrualGenerationRequest.AccrualType.INTEREST,
                accrual.getAccrualAmount().doubleValue(),
                accrual.getCurrency()
            ))
            .skip((long) page * size)
            .take(size)
            .collectList()
            .map(accruals -> DailyAccrualPageResponse.of(accruals, page, size, accruals.size()));
    }
}
