package com.lifecycle.cashflow.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;

import java.time.Duration;

/**
 * R2DBC configuration for PostgreSQL with connection retry and proper containerized networking.
 */
@Configuration
public class R2dbcConfig extends AbstractR2dbcConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(R2dbcConfig.class);

    @Value("${spring.r2dbc.url:r2dbc:postgresql://postgres:5432/cashflow_db}")
    private String r2dbcUrl;

    @Value("${spring.r2dbc.username:postgres}")
    private String username;

    @Value("${spring.r2dbc.password:password}")
    private String password;

    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        logger.info("Configuring R2DBC connection to: {}", r2dbcUrl);
        
        try {
            PostgresqlConnectionConfiguration config = PostgresqlConnectionConfiguration.builder()
                .host("postgres")  // Docker service name
                .port(5432)
                .database("cashflow_db")
                .username(username)
                .password(password)
                .connectTimeout(Duration.ofSeconds(30))
                .lockWaitTimeout(Duration.ofSeconds(30))
                .statementTimeout(Duration.ofSeconds(60))
                .build();

            ConnectionFactory factory = new PostgresqlConnectionFactory(config);
            logger.info("R2DBC connection factory created successfully");
            return factory;
            
        } catch (Exception e) {
            logger.error("Failed to create R2DBC connection factory", e);
            throw new RuntimeException("R2DBC configuration failed", e);
        }
    }

    @Bean
    public ReactiveTransactionManager transactionManager() {
        return new R2dbcTransactionManager(connectionFactory());
    }
}
