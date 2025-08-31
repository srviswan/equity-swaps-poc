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

/**
 * R2DBC Repository for Cashflow entities with reactive database operations
 */
@Repository
public interface CashflowRepository extends ReactiveCrudRepository<Cashflow, UUID> {
    
    // Basic query methods are automatically provided by Spring Data R2DBC
    // findAll(), findById(), save(), delete(), etc. are inherited from ReactiveCrudRepository
    
    // Custom query methods using Spring Data naming convention
    Flux<Cashflow> findByContractId(UUID contractId);
    
    Mono<Long> countByContractId(UUID contractId);
    
    Flux<Cashflow> findByContractIdAndCashflowType(UUID contractId, CashflowType cashflowType);
    
    Flux<Cashflow> findByContractIdAndStatus(UUID contractId, CashflowStatus status);
    
    Flux<Cashflow> findByContractIdIn(List<UUID> contractIds);
    
    Flux<Cashflow> findByContractIdInAndCashflowType(List<UUID> contractIds, CashflowType cashflowType);
    
    Flux<Cashflow> findByContractIdInAndStatus(List<UUID> contractIds, CashflowStatus status);
    
    Flux<Cashflow> findByContractIdAndSecurityId(UUID contractId, String securityId);
    
    // Date-based queries
    Flux<Cashflow> findBySettlementDateBetween(LocalDate startDate, LocalDate endDate);
    
    Flux<Cashflow> findByContractIdAndSettlementDateBetween(UUID contractId, LocalDate startDate, LocalDate endDate);
    
    // Security-based queries
    Flux<Cashflow> findBySecurityId(String securityId);
    
    // Status-based queries
    Flux<Cashflow> findByStatus(CashflowStatus status);
    
    // Type-based queries
    Flux<Cashflow> findByCashflowType(CashflowType cashflowType);
    
    // Custom SQL queries for complex operations
    @Query("SELECT * FROM cashflows WHERE cashflow_type = :cashflowType AND status = :status ORDER BY calculation_date DESC LIMIT :limit OFFSET :offset")
    Flux<Cashflow> findByCashflowTypeAndStatusWithPagination(CashflowType cashflowType, CashflowStatus status, int limit, int offset);
    
    @Query("SELECT COUNT(*) FROM cashflows WHERE cashflow_type = :cashflowType AND status = :status")
    Mono<Long> countByCashflowTypeAndStatus(CashflowType cashflowType, CashflowStatus status);
    
    // Specialized business queries
    @Query("SELECT * FROM cashflows WHERE settlement_date = :settlementDate AND status = 'APPROVED'")
    Flux<Cashflow> findCashflowsForSettlement(LocalDate settlementDate);
    
    @Query("SELECT * FROM cashflows WHERE calculation_date = :accrualDate AND cashflow_type = 'INTEREST'")
    Flux<Cashflow> findCashflowsForAccrual(LocalDate accrualDate);
    
    @Query("SELECT * FROM cashflows WHERE contract_id = :contractId AND cashflow_type = 'PERFORMANCE'")
    Flux<Cashflow> findPerformanceCashflows(UUID contractId);
    
    @Query("SELECT * FROM cashflows WHERE contract_id = :contractId AND cashflow_type = 'INTEREST'")
    Flux<Cashflow> findInterestCashflows(UUID contractId);
    
    @Query("SELECT * FROM cashflows WHERE contract_id = :contractId AND cashflow_type = 'DIVIDEND'")
    Flux<Cashflow> findDividendCashflows(UUID contractId);
    
    // Count queries
    Mono<Long> countByContractIdAndStatus(UUID contractId, CashflowStatus status);
}