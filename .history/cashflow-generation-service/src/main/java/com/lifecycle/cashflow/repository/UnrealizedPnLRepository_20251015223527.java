package com.lifecycle.cashflow.repository;

import com.lifecycle.cashflow.model.UnrealizedPnL;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.UUID;

/**
 * R2DBC Repository for UnrealizedPnL entities with reactive database operations
 */
@Repository
public interface UnrealizedPnLRepository extends ReactiveCrudRepository<UnrealizedPnL, UUID> {
    
    // Custom query methods using Spring Data naming convention
    Flux<UnrealizedPnL> findByContractId(UUID contractId);
    
    Flux<UnrealizedPnL> findByContractIdAndSecurityId(UUID contractId, String securityId);
    
    Flux<UnrealizedPnL> findByContractIdAndCalculationDateBetween(UUID contractId, LocalDate startDate, LocalDate endDate);
    
    // Business-specific queries with custom SQL
    @Query("SELECT * FROM unrealized_pnl_timeseries WHERE contract_id = :contractId AND security_id = :securityId AND calculation_date BETWEEN :startDate AND :endDate ORDER BY calculation_date DESC")
    Flux<UnrealizedPnL> findUnrealizedPnLForPerformance(UUID contractId, String securityId, LocalDate startDate, LocalDate endDate);
    
    @Query("SELECT * FROM unrealized_pnl_timeseries WHERE security_id = :securityId ORDER BY calculation_date DESC LIMIT 1")
    Mono<UnrealizedPnL> findLatestUnrealizedPnLBySecurity(String securityId);
    
    @Query("SELECT * FROM unrealized_pnl_timeseries WHERE contract_id = :contractId ORDER BY calculation_date DESC LIMIT 1")
    Mono<UnrealizedPnL> findLatestUnrealizedPnLByContract(UUID contractId);
}