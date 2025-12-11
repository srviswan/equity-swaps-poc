package com.lifecycle.cashflow.config;

import io.r2dbc.spi.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuator.health.Health;
import org.springframework.boot.actuator.health.ReactiveHealthIndicator;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * Health indicator for R2DBC database connectivity.
 */
@Component
public class DatabaseHealthIndicator implements ReactiveHealthIndicator {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseHealthIndicator.class);
    
    private final ConnectionFactory connectionFactory;

    public DatabaseHealthIndicator(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public Mono<Health> health() {
        return checkDatabaseHealth()
            .map(isHealthy -> isHealthy ? 
                Health.up().withDetail("database", "R2DBC connection successful").build() :
                Health.down().withDetail("database", "R2DBC connection failed").build())
            .onErrorReturn(Health.down().withDetail("database", "Health check failed").build())
            .timeout(Duration.ofSeconds(5))
            .doOnError(error -> logger.warn("Database health check failed", error));
    }

    private Mono<Boolean> checkDatabaseHealth() {
        return Mono.fromCallable(() -> {
            try {
                // Simple connection test
                connectionFactory.create()
                    .flatMap(connection -> {
                        logger.debug("Database connection test successful");
                        return connection.close();
                    })
                    .block(Duration.ofSeconds(3));
                return true;
            } catch (Exception e) {
                logger.warn("Database connection test failed: {}", e.getMessage());
                return false;
            }
        });
    }
}
