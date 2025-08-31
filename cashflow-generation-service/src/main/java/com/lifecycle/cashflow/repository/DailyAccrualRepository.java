package com.lifecycle.cashflow.repository;

import com.lifecycle.cashflow.model.DailyAccrual;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Mock implementation of DailyAccrualRepository with all required methods
 */
@Repository
public class DailyAccrualRepository {
    
    public Mono<DailyAccrual> save(DailyAccrual dailyAccrual) {
        return Mono.just(dailyAccrual);
    }
    
    public Flux<DailyAccrual> save() {
        return Flux.empty();
    }
    
    public Flux<DailyAccrual> findInterestAccruals(UUID contractId, LocalDate startDate, LocalDate endDate) {
        return Flux.empty();
    }
    
    public Flux<DailyAccrual> findDividendAccruals(UUID contractId, LocalDate startDate, LocalDate endDate) {
        return Flux.empty();
    }
    
    public Flux<DailyAccrual> findPerformanceAccruals(UUID contractId, LocalDate startDate, LocalDate endDate) {
        return Flux.empty();
    }
    
    public Mono<DailyAccrual> findById(UUID id) {
        return Mono.empty();
    }
    
    public Flux<DailyAccrual> findAll() {
        return Flux.empty();
    }
}