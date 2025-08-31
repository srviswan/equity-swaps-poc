package com.lifecycle.cashflow.repository;

import com.lifecycle.cashflow.model.DailyAccrual;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface DailyAccrualRepository extends ReactiveCrudRepository<DailyAccrual, UUID> {
    
    // Find daily accruals by contract ID
    Flux<DailyAccrual> findByContractId(UUID contractId);
    
    // Find daily accruals by contract ID and date range
    Flux<DailyAccrual> findByContractIdAndAccrualDateBetween(UUID contractId, LocalDate startDate, LocalDate endDate);
    
    // Find daily accruals by contract ID and security ID
    Flux<DailyAccrual> findByContractIdAndSecurityId(UUID contractId, String securityId);
    
    // Find daily accruals by contract ID, security ID and date range
    Flux<DailyAccrual> findByContractIdAndSecurityIdAndAccrualDateBetween(
        UUID contractId, String securityId, LocalDate startDate, LocalDate endDate);
    
    // Find daily accruals by date
    Flux<DailyAccrual> findByAccrualDate(LocalDate accrualDate);
    
    // Find daily accruals by date range
    Flux<DailyAccrual> findByAccrualDateBetween(LocalDate startDate, LocalDate endDate);
    
    // Find daily accruals by type
    Flux<DailyAccrual> findByType(String type);
    
    // Find daily accruals by contract ID and type
    Flux<DailyAccrual> findByContractIdAndType(UUID contractId, String type);
    
    // Find daily accruals by contract ID, type and date range
    Flux<DailyAccrual> findByContractIdAndTypeAndAccrualDateBetween(
        UUID contractId, String type, LocalDate startDate, LocalDate endDate);
    
    // Count daily accruals by contract ID
    Mono<Long> countByContractId(UUID contractId);
    
    // Count daily accruals by contract ID and date range
    Mono<Long> countByContractIdAndAccrualDateBetween(UUID contractId, LocalDate startDate, LocalDate endDate);
    
    // Find daily accruals for interest calculations
    @Query("SELECT * FROM daily_accruals WHERE contract_id = :contractId AND type = 'INTEREST' AND accrual_date BETWEEN :startDate AND :endDate ORDER BY accrual_date ASC")
    Flux<DailyAccrual> findInterestAccruals(UUID contractId, LocalDate startDate, LocalDate endDate);
    
    // Find daily accruals for dividend calculations
    @Query("SELECT * FROM daily_accruals WHERE contract_id = :contractId AND type = 'DIVIDEND' AND accrual_date BETWEEN :startDate AND :endDate ORDER BY accrual_date ASC")
    Flux<DailyAccrual> findDividendAccruals(UUID contractId, LocalDate startDate, LocalDate endDate);
    
    // Find daily accruals for performance calculations
    @Query("SELECT * FROM daily_accruals WHERE contract_id = :contractId AND type = 'PERFORMANCE' AND accrual_date BETWEEN :startDate AND :endDate ORDER BY accrual_date ASC")
    Flux<DailyAccrual> findPerformanceAccruals(UUID contractId, LocalDate startDate, LocalDate endDate);
    
    // Find daily accruals for a specific security
    @Query("SELECT * FROM daily_accruals WHERE contract_id = :contractId AND security_id = :securityId AND accrual_date BETWEEN :startDate AND :endDate ORDER BY accrual_date ASC")
    Flux<DailyAccrual> findAccrualsBySecurity(UUID contractId, String securityId, LocalDate startDate, LocalDate endDate);
    
    // Find the latest daily accrual for a contract
    @Query("SELECT * FROM daily_accruals WHERE contract_id = :contractId ORDER BY accrual_date DESC LIMIT 1")
    Mono<DailyAccrual> findLatestAccrual(UUID contractId);
    
    // Find the latest daily accrual for a contract and security
    @Query("SELECT * FROM daily_accruals WHERE contract_id = :contractId AND security_id = :securityId ORDER BY accrual_date DESC LIMIT 1")
    Mono<DailyAccrual> findLatestAccrualBySecurity(UUID contractId, String securityId);
}
