package com.finos.synthetics.handler.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Fault Tolerance Configuration
 * 
 * Configurable parameters for fault tolerance patterns including circuit breaker,
 * retry logic, and timeout settings.
 * 
 * @version 1.0.0
 */
@Configuration
@ConfigurationProperties(prefix = "handler.fault-tolerance")
public class FaultToleranceConfig {

    // Circuit Breaker Configuration
    private int circuitBreakerThreshold = 5;
    private long circuitBreakerTimeoutMs = 30000; // 30 seconds
    private long circuitBreakerHalfOpenTimeoutMs = 60000; // 1 minute

    // Retry Configuration
    private int maxRetryAttempts = 3;
    private long retryDelayMs = 1000; // 1 second
    private long maxRetryDelayMs = 10000; // 10 seconds

    // Timeout Configuration
    private long processingTimeoutMs = 30000; // 30 seconds

    // Thread Pool Configuration
    private int threadPoolSize = 10;
    private long threadPoolShutdownTimeoutMs = 60000; // 1 minute

    // Getters and Setters
    public int getCircuitBreakerThreshold() {
        return circuitBreakerThreshold;
    }

    public void setCircuitBreakerThreshold(int circuitBreakerThreshold) {
        this.circuitBreakerThreshold = circuitBreakerThreshold;
    }

    public long getCircuitBreakerTimeoutMs() {
        return circuitBreakerTimeoutMs;
    }

    public void setCircuitBreakerTimeoutMs(long circuitBreakerTimeoutMs) {
        this.circuitBreakerTimeoutMs = circuitBreakerTimeoutMs;
    }

    public long getCircuitBreakerHalfOpenTimeoutMs() {
        return circuitBreakerHalfOpenTimeoutMs;
    }

    public void setCircuitBreakerHalfOpenTimeoutMs(long circuitBreakerHalfOpenTimeoutMs) {
        this.circuitBreakerHalfOpenTimeoutMs = circuitBreakerHalfOpenTimeoutMs;
    }

    public int getMaxRetryAttempts() {
        return maxRetryAttempts;
    }

    public void setMaxRetryAttempts(int maxRetryAttempts) {
        this.maxRetryAttempts = maxRetryAttempts;
    }

    public long getRetryDelayMs() {
        return retryDelayMs;
    }

    public void setRetryDelayMs(long retryDelayMs) {
        this.retryDelayMs = retryDelayMs;
    }

    public long getMaxRetryDelayMs() {
        return maxRetryDelayMs;
    }

    public void setMaxRetryDelayMs(long maxRetryDelayMs) {
        this.maxRetryDelayMs = maxRetryDelayMs;
    }

    public long getProcessingTimeoutMs() {
        return processingTimeoutMs;
    }

    public void setProcessingTimeoutMs(long processingTimeoutMs) {
        this.processingTimeoutMs = processingTimeoutMs;
    }

    public int getThreadPoolSize() {
        return threadPoolSize;
    }

    public void setThreadPoolSize(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }

    public long getThreadPoolShutdownTimeoutMs() {
        return threadPoolShutdownTimeoutMs;
    }

    public void setThreadPoolShutdownTimeoutMs(long threadPoolShutdownTimeoutMs) {
        this.threadPoolShutdownTimeoutMs = threadPoolShutdownTimeoutMs;
    }
} 