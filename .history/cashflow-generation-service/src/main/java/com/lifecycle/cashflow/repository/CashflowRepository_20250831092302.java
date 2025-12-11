package com.lifecycle.cashflow.repository;

import com.lifecycle.cashflow.model.Cashflow;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Mock implementation of CashflowRepository for testing
 */
@Repository
public class CashflowRepository {
    
    public Flux<Cashflow> findAll() {
        return Flux.empty();
    }
    
    public Mono<Cashflow> findById(UUID id) {
        return Mono.empty();
    }
    
    public Mono<Cashflow> save(Cashflow cashflow) {
        return Mono.just(cashflow);
    }
}