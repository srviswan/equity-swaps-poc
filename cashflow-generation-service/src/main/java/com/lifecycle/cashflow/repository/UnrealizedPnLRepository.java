package com.lifecycle.cashflow.repository;

import com.lifecycle.cashflow.model.UnrealizedPnL;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Mock implementation of UnrealizedPnLRepository with all required methods
 */
@Repository
public class UnrealizedPnLRepository {
    
    public Mono<UnrealizedPnL> save(UnrealizedPnL unrealizedPnL) {
        return Mono.just(unrealizedPnL);
    }
    
    public Flux<UnrealizedPnL> findUnrealizedPnLForPerformance(UUID contractId, String securityId, LocalDate startDate, LocalDate endDate) {
        return Flux.empty();
    }
    
    public Mono<UnrealizedPnL> findLatestUnrealizedPnLBySecurity(UUID contractId, String securityId) {
        return Mono.empty();
    }
    
    public Mono<UnrealizedPnL> findById(UUID id) {
        return Mono.empty();
    }
    
    public Flux<UnrealizedPnL> findAll() {
        return Flux.empty();
    }
}