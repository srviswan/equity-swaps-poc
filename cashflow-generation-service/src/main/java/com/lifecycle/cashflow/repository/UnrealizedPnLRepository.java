package com.lifecycle.cashflow.repository;

import com.lifecycle.cashflow.model.UnrealizedPnL;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface UnrealizedPnLRepository extends ReactiveCrudRepository<UnrealizedPnL, UUID> {
    
    // Find unrealized P&L by contract ID
    Flux<UnrealizedPnL> findByContractId(UUID contractId);
    
    // Find unrealized P&L by contract ID and date range
    Flux<UnrealizedPnL> findByContractIdAndCalculationDateBetween(UUID contractId, LocalDate startDate, LocalDate endDate);
    
    // Find unrealized P&L by contract ID and security ID
    Flux<UnrealizedPnL> findByContractIdAndSecurityId(UUID contractId, String securityId);
    
    // Find unrealized P&L by contract ID, security ID and date range
    Flux<UnrealizedPnL> findByContractIdAndSecurityIdAndCalculationDateBetween(
        UUID contractId, String securityId, LocalDate startDate, LocalDate endDate);
    
    // Find unrealized P&L by calculation date
    Flux<UnrealizedPnL> findByCalculationDate(LocalDate calculationDate);
    
    // Find unrealized P&L by calculation date range
    Flux<UnrealizedPnL> findByCalculationDateBetween(LocalDate startDate, LocalDate endDate);
    
    // Find unrealized P&L by security ID
    Flux<UnrealizedPnL> findBySecurityId(String securityId);
    
    // Find unrealized P&L by security ID and date range
    Flux<UnrealizedPnL> findBySecurityIdAndCalculationDateBetween(String securityId, LocalDate startDate, LocalDate endDate);
    
    // Count unrealized P&L by contract ID
    Mono<Long> countByContractId(UUID contractId);
    
    // Count unrealized P&L by contract ID and date range
    Mono<Long> countByContractIdAndCalculationDateBetween(UUID contractId, LocalDate startDate, LocalDate endDate);
    
    // Find the latest unrealized P&L for a contract
    @Query("SELECT * FROM unrealized_pnl_timeseries WHERE contract_id = :contractId ORDER BY calculation_date DESC LIMIT 1")
    Mono<UnrealizedPnL> findLatestUnrealizedPnL(UUID contractId);
    
    // Find the latest unrealized P&L for a contract and security
    @Query("SELECT * FROM unrealized_pnl_timeseries WHERE contract_id = :contractId AND security_id = :securityId ORDER BY calculation_date DESC LIMIT 1")
    Mono<UnrealizedPnL> findLatestUnrealizedPnLBySecurity(UUID contractId, String securityId);
    
    // Find unrealized P&L for performance calculations
    @Query("SELECT * FROM unrealized_pnl_timeseries WHERE contract_id = :contractId AND security_id = :securityId AND calculation_date BETWEEN :startDate AND :endDate ORDER BY calculation_date ASC")
    Flux<UnrealizedPnL> findUnrealizedPnLForPerformance(UUID contractId, String securityId, LocalDate startDate, LocalDate endDate);
    
    // Find unrealized P&L for a specific date
    @Query("SELECT * FROM unrealized_pnl_timeseries WHERE calculation_date = :calculationDate")
    Flux<UnrealizedPnL> findByCalculationDateExact(LocalDate calculationDate);
    
    // Find unrealized P&L for multiple contracts on a specific date
    @Query("SELECT * FROM unrealized_pnl_timeseries WHERE contract_id IN (:contractIds) AND calculation_date = :calculationDate")
    Flux<UnrealizedPnL> findByContractIdsAndCalculationDate(java.util.List<UUID> contractIds, LocalDate calculationDate);
    
    // Find unrealized P&L for multiple contracts and date range
    @Query("SELECT * FROM unrealized_pnl_timeseries WHERE contract_id IN (:contractIds) AND calculation_date BETWEEN :startDate AND :endDate ORDER BY contract_id, calculation_date")
    Flux<UnrealizedPnL> findByContractIdsAndCalculationDateBetween(java.util.List<UUID> contractIds, LocalDate startDate, LocalDate endDate);
    
    // Find unrealized P&L for a specific security on a specific date
    @Query("SELECT * FROM unrealized_pnl_timeseries WHERE security_id = :securityId AND calculation_date = :calculationDate")
    Flux<UnrealizedPnL> findBySecurityIdAndCalculationDate(String securityId, LocalDate calculationDate);
    
    // Find unrealized P&L for a specific security and date range
    @Query("SELECT * FROM unrealized_pnl_timeseries WHERE security_id = :securityId AND calculation_date BETWEEN :startDate AND :endDate ORDER BY calculation_date ASC")
    Flux<UnrealizedPnL> findBySecurityIdAndCalculationDateRange(String securityId, LocalDate startDate, LocalDate endDate);
}
