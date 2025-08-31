package com.lifecycle.cashflow.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;

@Configuration
@EnableR2dbcRepositories(basePackages = "com.lifecycle.cashflow.repository")
public class DatabaseConfig extends AbstractR2dbcConfiguration {
    
    @Value("${spring.r2dbc.host:localhost}")
    private String host;
    
    @Value("${spring.r2dbc.port:5432}")
    private int port;
    
    @Value("${spring.r2dbc.database:cashflow_db}")
    private String database;
    
    @Value("${spring.r2dbc.username:postgres}")
    private String username;
    
    @Value("${spring.r2dbc.password:password}")
    private String password;
    
    @Value("${spring.r2dbc.pool.initial-size:5}")
    private int initialSize;
    
    @Value("${spring.r2dbc.pool.max-size:20}")
    private int maxSize;
    
    @Value("${spring.r2dbc.pool.max-idle-time:30}")
    private int maxIdleTime;
    
    @Bean
    @Override
    public ConnectionFactory connectionFactory() {
        PostgresqlConnectionConfiguration config = PostgresqlConnectionConfiguration.builder()
                .host(host)
                .port(port)
                .database(database)
                .username(username)
                .password(password)
                .build();
        
        return new PostgresqlConnectionFactory(config);
    }
    
    @Bean
    public ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return new R2dbcTransactionManager(connectionFactory);
    }
}
