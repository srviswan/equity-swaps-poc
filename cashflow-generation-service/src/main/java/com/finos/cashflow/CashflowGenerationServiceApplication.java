package com.finos.cashflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Main application class for the Cash Flow Generation Service.
 * 
 * This service provides high-performance cashflow generation capabilities using:
 * - Java 21 Virtual Threads for high-throughput processing
 * - Thread partitioning for data consistency
 * - Reactive programming with Project Reactor
 * - Spring WebFlux for non-blocking I/O
 */
@SpringBootApplication
@EnableR2dbcRepositories
@EnableCaching
@EnableAsync
public class CashflowGenerationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CashflowGenerationServiceApplication.class, args);
    }
}
