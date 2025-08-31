package com.lifecycle.cashflow.repository;

import com.lifecycle.cashflow.model.DailyAccrual;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.UUID;

/**
 * R2DBC Repository for DailyAccrual entities with reactive database operations
 */
@Repository
public interface DailyAccrualRepository extends ReactiveCrudRepository<DailyAccrual, UUID> {
    
    // Custom query methods using Spring Data naming convention
    Flux<DailyAccrual> findByContractId(UUID contractId);
    
    Flux<DailyAccrual> findByContractIdAndAccrualDateBetween(UUID contractId, LocalDate startDate, LocalDate endDate);
    
    // Business-specific queries with custom SQL
    @Query("SELECT * FROM daily_accruals WHERE contract_id = :contractId AND type = 'INTEREST' AND accrual_date BETWEEN :startDate AND :endDate ORDER BY accrual_date")
    Flux<DailyAccrual> findInterestAccruals(UUID contractId, LocalDate startDate, LocalDate endDate);
    
    @Query("SELECT * FROM daily_accruals WHERE contract_id = :contractId AND type = 'DIVIDEND' AND accrual_date BETWEEN :startDate AND :endDate ORDER BY accrual_date")
    Flux<DailyAccrual> findDividendAccruals(UUID contractId, LocalDate startDate, LocalDate endDate);
    
    @Query("SELECT * FROM daily_accruals WHERE contract_id = :contractId AND type = 'PERFORMANCE' AND accrual_date BETWEEN :startDate AND :endDate ORDER BY accrual_date")
    Flux<DailyAccrual> findPerformanceAccruals(UUID contractId, LocalDate startDate, LocalDate endDate);
}