package com.finos.cashflow.repository;

import com.finos.cashflow.model.Cashflow;
import com.finos.cashflow.model.CashflowStatus;
import com.finos.cashflow.model.CashflowType;
import org.springframework.data.domain.Pageable;
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
    
    // Find cashflows by contract ID and type
    Flux<Cashflow> findByContractIdAndCashflowType(UUID contractId, CashflowType cashflowType);
    
    // Find cashflows by status
    Flux<Cashflow> findByStatus(CashflowStatus status);
    
    // Find cashflows by type
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
    @Query("SELECT * FROM cashflows WHERE contract_id = :contractId AND type = :type AND status = 'ACCRUED' AND settlement_date BETWEEN :startDate AND :endDate")
    Flux<Cashflow> findDailyAccruals(UUID contractId, CashflowType type, LocalDate startDate, LocalDate endDate);
    
    // Find cashflows for performance calculations
    @Query("SELECT * FROM cashflows WHERE contract_id = :contractId AND type = 'PERFORMANCE' AND status IN ('ACCRUED', 'REALIZED_DEFERRED')")
    Flux<Cashflow> findPerformanceCashflows(UUID contractId);
    
    // Find cashflows for interest calculations
    @Query("SELECT * FROM cashflows WHERE contract_id = :contractId AND type = 'INTEREST' AND status IN ('ACCRUED', 'REALIZED_DEFERRED')")
    Flux<Cashflow> findInterestCashflows(UUID contractId);
    
    // Find cashflows for dividend calculations
    @Query("SELECT * FROM cashflows WHERE contract_id = :contractId AND type = 'DIVIDEND' AND status IN ('ACCRUED', 'REALIZED_DEFERRED')")
    Flux<Cashflow> findDividendCashflows(UUID contractId);
    
    // Find cashflows by multiple contract IDs
    Flux<Cashflow> findByContractIdIn(List<UUID> contractIds);
    
    // Find cashflows by multiple contract IDs and status
    Flux<Cashflow> findByContractIdInAndStatus(List<UUID> contractIds, CashflowStatus status);
    
    // Find cashflows by multiple contract IDs and type
    Flux<Cashflow> findByContractIdInAndCashflowType(List<UUID> contractIds, CashflowType cashflowType);
    
    // Find cashflows for settlement processing
    @Query("SELECT * FROM cashflows WHERE status = 'REALIZED_UNSETTLED' AND settlement_date <= :settlementDate ORDER BY settlement_date ASC")
    Flux<Cashflow> findCashflowsForSettlement(LocalDate settlementDate);
    
    // Find cashflows for accrual processing
    @Query("SELECT * FROM cashflows WHERE status = 'ACCRUED' AND type IN ('INTEREST', 'DIVIDEND') AND settlement_date = :accrualDate")
    Flux<Cashflow> findCashflowsForAccrual(LocalDate accrualDate);
    
    // Find cashflows for performance calculation
    @Query("SELECT * FROM cashflows WHERE status = 'ACCRUED' AND type = 'PERFORMANCE' AND contract_id = :contractId AND security_id = :securityId")
    Flux<Cashflow> findCashflowsForPerformanceCalculation(UUID contractId, String securityId);
    
    // ===== Advanced Query Methods for API Support =====
    
    // Find cashflows with filters and pagination support
    @Query("SELECT * FROM cashflows WHERE " +
           "(:contractId IS NULL OR contract_id = :contractId) AND " +
           "(:legId IS NULL OR leg_id = :legId) AND " +
           "(:cashflowType IS NULL OR cashflow_type = :cashflowType) AND " +
           "(:status IS NULL OR status = :status) AND " +
           "(:currency IS NULL OR currency = :currency) AND " +
           "(:startDate IS NULL OR calculation_date >= :startDate) AND " +
           "(:endDate IS NULL OR calculation_date <= :endDate) " +
           "ORDER BY created_at DESC LIMIT :limit OFFSET :offset")
    Flux<Cashflow> findCashflowsWithFilters(UUID contractId, UUID legId, String cashflowType, 
                                           String status, String currency, LocalDate startDate, 
                                           LocalDate endDate, int limit, int offset);
    
    // Count cashflows with filters
    @Query("SELECT COUNT(*) FROM cashflows WHERE " +
           "(:contractId IS NULL OR contract_id = :contractId) AND " +
           "(:legId IS NULL OR leg_id = :legId) AND " +
           "(:cashflowType IS NULL OR cashflow_type = :cashflowType) AND " +
           "(:status IS NULL OR status = :status) AND " +
           "(:currency IS NULL OR currency = :currency) AND " +
           "(:startDate IS NULL OR calculation_date >= :startDate) AND " +
           "(:endDate IS NULL OR calculation_date <= :endDate)")
    Mono<Long> countCashflowsWithFilters(UUID contractId, UUID legId, String cashflowType, 
                                        String status, String currency, LocalDate startDate, 
                                        LocalDate endDate);
    
    // Find cashflows by currency
    Flux<Cashflow> findByCurrency(String currency);
    
    // Find cashflows by leg ID
    Flux<Cashflow> findByLegId(UUID legId);
    
    // Find cashflows by calculation date range
    Flux<Cashflow> findByCalculationDateBetween(LocalDate startDate, LocalDate endDate);
    
    // Find cashflows for reporting - summary by contract
    @Query("SELECT contract_id, cashflow_type, status, currency, COUNT(*) as count, SUM(amount) as total_amount " +
           "FROM cashflows WHERE calculation_date BETWEEN :startDate AND :endDate " +
           "GROUP BY contract_id, cashflow_type, status, currency")
    Flux<Object[]> findCashflowSummaryByContract(LocalDate startDate, LocalDate endDate);
    
    // Find deferred cashflows for aging analysis
    @Query("SELECT * FROM cashflows WHERE status = 'REALIZED_DEFERRED' AND " +
           "expected_realization_date BETWEEN :startDate AND :endDate " +
           "ORDER BY expected_realization_date ASC")
    Flux<Cashflow> findDeferredCashflows(LocalDate startDate, LocalDate endDate);
    
    // Find overdue deferred cashflows
    @Query("SELECT * FROM cashflows WHERE status = 'REALIZED_DEFERRED' AND " +
           "expected_realization_date < :currentDate " +
           "ORDER BY expected_realization_date ASC")
    Flux<Cashflow> findOverdueDeferredCashflows(LocalDate currentDate);
}
