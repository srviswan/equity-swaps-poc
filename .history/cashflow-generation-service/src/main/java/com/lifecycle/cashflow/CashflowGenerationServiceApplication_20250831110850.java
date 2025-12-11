package com.lifecycle.cashflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Main application class for the Cash Flow Generation Service.
 * 
 * This service provides high-performance cashflow generation capabilities using:
 * - Java 21 Virtual Threads for high-throughput processing
 * - Thread partitioning for data consistency
 * - Reactive programming with Project Reactor
 * - Spring WebFlux for non-blocking I/O
 */
@SpringBootApplication(scanBasePackages = "com.lifecycle.cashflow")
@EnableCaching
@EnableAsync
public class CashflowGenerationServiceApplication {

    private static final Logger logger = LoggerFactory.getLogger(CashflowGenerationServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CashflowGenerationServiceApplication.class, args);
    }
    
    @Bean
    public ConnectionFactoryInitializer initializer() {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        // Note: Database schema is already initialized via Docker
        return initializer;
    }
    
    @EventListener(ApplicationReadyEvent.class)
    public void logApplicationReady() {
        logger.info("=== CASHFLOW GENERATION SERVICE STARTED ===");
        logger.info("Component scanning: com.lifecycle.cashflow");
        logger.info("R2DBC repositories enabled");
        logger.info("Controllers should be registered");
    }
}
