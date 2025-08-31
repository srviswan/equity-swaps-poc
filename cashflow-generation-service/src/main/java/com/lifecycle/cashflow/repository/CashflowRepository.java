package com.lifecycle.cashflow.repository;

import com.lifecycle.cashflow.model.Cashflow;
import com.lifecycle.cashflow.model.CashflowStatus;
import com.lifecycle.cashflow.model.CashflowType;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface CashflowRepository extends ReactiveCrudRepository<Cashflow, UUID> {
    
    // Find cashflows by contract ID
    Flux<Cashflow> findByContractId(UUID contractId);
    
    // Find cashflows by contract ID and status
    Flux<Cashflow> findByContractIdAndStatus(UUID contractId, CashflowStatus status);
    
    // Find cashflows by contract ID and cashflow type
    Flux<Cashflow> findByContractIdAndCashflowType(UUID contractId, CashflowType cashflowType);
    
    // Find cashflows by status
    Flux<Cashflow> findByStatus(CashflowStatus status);
    
    // Find cashflows by cashflow type
    Flux<Cashflow> findByCashflowType(CashflowType cashflowType);
    
    // Find cashflows by settlement date range
    Flux<Cashflow> findBySettlementDateBetween(LocalDate startDate, LocalDate endDate);
    
    // Find cashflows by contract ID and settlement date range
    Flux<Cashflow> findByContractIdAndSettlementDateBetween(UUID contractId, LocalDate startDate, LocalDate endDate);
    
    // Find cashflows by underlier (security ID)
    Flux<Cashflow> findBySecurityId(String securityId);
    
    // Find cashflows by contract ID and underlier
    Flux<Cashflow> findByContractIdAndSecurityId(UUID contractId, String securityId);
    
    // Count cashflows by contract ID
    Mono<Long> countByContractId(UUID contractId);
    
    // Count cashflows by contract ID and status
    Mono<Long> countByContractIdAndStatus(UUID contractId, CashflowStatus status);
    
    // Find cashflows for daily accruals
    @Query("SELECT * FROM cashflows WHERE contract_id = :contractId AND cashflow_type = :cashflowType AND status = 'ACCRUED' AND settlement_date BETWEEN :startDate AND :endDate")
    Flux<Cashflow> findDailyAccruals(UUID contractId, CashflowType cashflowType, LocalDate startDate, LocalDate endDate);
    
    // Find cashflows for performance calculations
    @Query("SELECT * FROM cashflows WHERE contract_id = :contractId AND cashflow_type = 'PERFORMANCE' AND status IN ('ACCRUED', 'REALIZED_DEFERRED')")
    Flux<Cashflow> findPerformanceCashflows(UUID contractId);
    
    // Find cashflows for interest calculations
    @Query("SELECT * FROM cashflows WHERE contract_id = :contractId AND cashflow_type = 'INTEREST' AND status IN ('ACCRUED', 'REALIZED_DEFERRED')")
    Flux<Cashflow> findInterestCashflows(UUID contractId);
    
    // Find cashflows for dividend calculations
    @Query("SELECT * FROM cashflows WHERE contract_id = :contractId AND cashflow_type = 'DIVIDEND' AND status IN ('ACCRUED', 'REALIZED_DEFERRED')")
    Flux<Cashflow> findDividendCashflows(UUID contractId);
    
    // Find cashflows by multiple contract IDs
    Flux<Cashflow> findByContractIdIn(List<UUID> contractIds);
    
    // Find cashflows by multiple contract IDs and status
    Flux<Cashflow> findByContractIdInAndStatus(List<UUID> contractIds, CashflowStatus status);
    
    // Find cashflows by multiple contract IDs and cashflow type
    Flux<Cashflow> findByContractIdInAndCashflowType(List<UUID> contractIds, CashflowType cashflowType);
    
    // Find cashflows for settlement processing
    @Query("SELECT * FROM cashflows WHERE status = 'REALIZED_UNSETTLED' AND settlement_date <= :settlementDate ORDER BY settlement_date ASC")
    Flux<Cashflow> findCashflowsForSettlement(LocalDate settlementDate);
    
    // Find cashflows for accrual processing
    @Query("SELECT * FROM cashflows WHERE status = 'ACCRUED' AND cashflow_type IN ('INTEREST', 'DIVIDEND') AND settlement_date = :accrualDate")
    Flux<Cashflow> findCashflowsForAccrual(LocalDate accrualDate);
    
    // Find cashflows for performance calculation
    @Query("SELECT * FROM cashflows WHERE status = 'ACCRUED' AND cashflow_type = 'PERFORMANCE' AND contract_id = :contractId AND security_id = :securityId")
    Flux<Cashflow> findCashflowsForPerformanceCalculation(UUID contractId, String securityId);
}
