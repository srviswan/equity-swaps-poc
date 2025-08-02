package com.finos.synthetics.handler.service;

import com.finos.synthetics.handler.model.InstructionRequest;
import com.finos.synthetics.handler.model.InstructionResponse;
import com.finos.synthetics.handler.strategy.HandlerStrategy;
import com.finos.synthetics.handler.strategy.ExecutionHandlerStrategy;
import com.finos.synthetics.handler.strategy.ContractFormationHandlerStrategy;
import com.finos.synthetics.handler.strategy.ExerciseHandlerStrategy;
import com.finos.synthetics.handler.strategy.ResetHandlerStrategy;
import com.finos.synthetics.handler.strategy.PartyChangeHandlerStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Fault-Tolerant Handler Service
 * 
 * Implements comprehensive fault tolerance patterns:
 * - Circuit Breaker Pattern
 * - Retry Logic with Exponential Backoff
 * - Timeout Handling
 * - Graceful Degradation
 * - Comprehensive Error Handling
 * - Health Monitoring
 * 
 * @version 2.0.0
 */
@Service
public class HandlerService {

    private static final Logger logger = LoggerFactory.getLogger(HandlerService.class);
    
    // Circuit Breaker Configuration
    private static final int CIRCUIT_BREAKER_THRESHOLD = 5;
    private static final long CIRCUIT_BREAKER_TIMEOUT_MS = 30000; // 30 seconds
    private static final long CIRCUIT_BREAKER_HALF_OPEN_TIMEOUT_MS = 60000; // 1 minute
    
    // Retry Configuration
    private static final int MAX_RETRY_ATTEMPTS = 3;
    private static final long RETRY_DELAY_MS = 1000; // 1 second
    private static final long MAX_RETRY_DELAY_MS = 10000; // 10 seconds
    
    // Timeout Configuration
    private static final long PROCESSING_TIMEOUT_MS = 30000; // 30 seconds
    
    private final Map<InstructionRequest.InstructionType, HandlerStrategy> strategies;
    private final Map<InstructionRequest.InstructionType, CircuitBreaker> circuitBreakers;
    private final ExecutorService executorService;
    private final AtomicLong totalRequests = new AtomicLong(0);
    private final AtomicLong successfulRequests = new AtomicLong(0);
    private final AtomicLong failedRequests = new AtomicLong(0);
    private final AtomicLong timeoutRequests = new AtomicLong(0);

    public HandlerService() {
        this.strategies = new HashMap<>();
        this.circuitBreakers = new HashMap<>();
        this.executorService = Executors.newFixedThreadPool(10);
        initializeStrategies();
        initializeCircuitBreakers();
    }

    /**
     * Initialize all handler strategies
     */
    private void initializeStrategies() {
        strategies.put(InstructionRequest.InstructionType.EXECUTION, new ExecutionHandlerStrategy());
        strategies.put(InstructionRequest.InstructionType.CONTRACT_FORMATION, new ContractFormationHandlerStrategy());
        strategies.put(InstructionRequest.InstructionType.EXERCISE, new ExerciseHandlerStrategy());
        strategies.put(InstructionRequest.InstructionType.RESET, new ResetHandlerStrategy());
        strategies.put(InstructionRequest.InstructionType.PARTY_CHANGE, new PartyChangeHandlerStrategy());
    }

    /**
     * Initialize circuit breakers for each strategy
     */
    private void initializeCircuitBreakers() {
        for (InstructionRequest.InstructionType type : strategies.keySet()) {
            circuitBreakers.put(type, new CircuitBreaker(CIRCUIT_BREAKER_THRESHOLD, 
                                                       CIRCUIT_BREAKER_TIMEOUT_MS,
                                                       CIRCUIT_BREAKER_HALF_OPEN_TIMEOUT_MS));
        }
    }

    /**
     * Process instruction with comprehensive fault tolerance
     * 
     * @param request the instruction request
     * @return processed response
     */
    public InstructionResponse processInstruction(InstructionRequest request) {
        totalRequests.incrementAndGet();
        long startTime = System.currentTimeMillis();
        
        if (request == null) {
            logger.error("Received null request in handler service");
            failedRequests.incrementAndGet();
            return createErrorResponse(null, "Request cannot be null");
        }
        
        logger.info("Processing instruction: {} with type: {}", request.getInstructionId(), request.getInstructionType());
        
        try {
            // Check circuit breaker status
            CircuitBreaker circuitBreaker = circuitBreakers.get(request.getInstructionType());
            if (circuitBreaker != null && circuitBreaker.isOpen()) {
                logger.warn("Circuit breaker is OPEN for instruction type: {}", request.getInstructionType());
                return createDegradedResponse(request, "Service temporarily unavailable - circuit breaker open");
            }
            
            // Execute with timeout and retry logic
            InstructionResponse response = executeWithFaultTolerance(request, startTime);
            
            if (response.getStatus() == InstructionResponse.Status.SUCCESS) {
                successfulRequests.incrementAndGet();
                if (circuitBreaker != null) {
                    circuitBreaker.recordSuccess();
                }
            } else {
                failedRequests.incrementAndGet();
                if (circuitBreaker != null) {
                    circuitBreaker.recordFailure();
                }
            }
            
            return response;
            
        } catch (Exception e) {
            logger.error("Critical error processing instruction: {}", request.getInstructionId(), e);
            failedRequests.incrementAndGet();
            
            // Record failure in circuit breaker
            CircuitBreaker circuitBreaker = circuitBreakers.get(request.getInstructionType());
            if (circuitBreaker != null) {
                circuitBreaker.recordFailure();
            }
            
            return createErrorResponse(request, "Critical processing error: " + e.getMessage());
        }
    }

    /**
     * Execute instruction with comprehensive fault tolerance
     */
    private InstructionResponse executeWithFaultTolerance(InstructionRequest request, long startTime) {
        HandlerStrategy strategy = strategies.get(request.getInstructionType());
        
        if (strategy == null) {
            logger.error("No handler strategy found for instruction type: {}", request.getInstructionType());
            return createErrorResponse(request, "Unsupported instruction type: " + request.getInstructionType());
        }
        
        // Execute with timeout
        Future<InstructionResponse> future = executorService.submit(() -> {
            return executeWithRetry(strategy, request);
        });
        
        try {
            InstructionResponse response = future.get(PROCESSING_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            response.setProcessingTime(System.currentTimeMillis() - startTime);
            return response;
            
        } catch (TimeoutException e) {
            logger.error("Processing timeout for instruction: {}", request.getInstructionId());
            timeoutRequests.incrementAndGet();
            future.cancel(true);
            return createErrorResponse(request, "Processing timeout - request took too long to complete");
            
        } catch (InterruptedException e) {
            logger.error("Processing interrupted for instruction: {}", request.getInstructionId());
            Thread.currentThread().interrupt();
            return createErrorResponse(request, "Processing interrupted");
            
        } catch (ExecutionException e) {
            logger.error("Execution error for instruction: {}", request.getInstructionId(), e);
            return createErrorResponse(request, "Execution error: " + e.getCause().getMessage());
        }
    }

    /**
     * Execute strategy with retry logic and exponential backoff
     */
    private InstructionResponse executeWithRetry(HandlerStrategy strategy, InstructionRequest request) {
        int attempts = 0;
        long delay = RETRY_DELAY_MS;
        
        while (attempts < MAX_RETRY_ATTEMPTS) {
            try {
                attempts++;
                logger.debug("Attempt {} for instruction: {}", attempts, request.getInstructionId());
                
                return strategy.handle(request);
                
            } catch (Exception e) {
                logger.warn("Attempt {} failed for instruction: {} - {}", attempts, request.getInstructionId(), e.getMessage());
                
                if (attempts >= MAX_RETRY_ATTEMPTS) {
                    logger.error("All retry attempts failed for instruction: {}", request.getInstructionId());
                    throw e;
                }
                
                // Exponential backoff with jitter
                try {
                    long jitter = (long) (Math.random() * delay * 0.1);
                    Thread.sleep(delay + jitter);
                    delay = Math.min(delay * 2, MAX_RETRY_DELAY_MS);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Retry interrupted", ie);
                }
            }
        }
        
        throw new RuntimeException("All retry attempts exhausted");
    }

    /**
     * Create error response with enhanced error information
     */
    private InstructionResponse createErrorResponse(InstructionRequest request, String errorMessage) {
        String instructionId = request != null ? request.getInstructionId() : "unknown";
        InstructionResponse response = new InstructionResponse(instructionId, InstructionResponse.Status.FAILED);
        response.setErrorMessage(errorMessage);
        response.setResponseTimestamp(LocalDateTime.now());
        return response;
    }

    /**
     * Create degraded response for circuit breaker scenarios
     */
    private InstructionResponse createDegradedResponse(InstructionRequest request, String message) {
        InstructionResponse response = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
        response.setErrorMessage(message);
        response.setResponseTimestamp(LocalDateTime.now());
        response.setHandlerService("DEGRADED_HANDLER");
        return response;
    }

    /**
     * Get available strategies for monitoring/debugging
     */
    public Map<InstructionRequest.InstructionType, String> getAvailableStrategies() {
        Map<InstructionRequest.InstructionType, String> available = new HashMap<>();
        strategies.forEach((type, strategy) -> 
            available.put(type, strategy.getClass().getSimpleName()));
        return available;
    }

    /**
     * Get health status and metrics
     */
    public Map<String, Object> getHealthStatus() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "HEALTHY");
        health.put("totalRequests", totalRequests.get());
        health.put("successfulRequests", successfulRequests.get());
        health.put("failedRequests", failedRequests.get());
        health.put("timeoutRequests", timeoutRequests.get());
        health.put("successRate", totalRequests.get() > 0 ? 
                   (double) successfulRequests.get() / totalRequests.get() : 0.0);
        
        // Circuit breaker status
        Map<String, String> circuitBreakerStatus = new HashMap<>();
        circuitBreakers.forEach((type, breaker) -> 
            circuitBreakerStatus.put(type.name(), breaker.getState().name()));
        health.put("circuitBreakers", circuitBreakerStatus);
        
        return health;
    }

    /**
     * Circuit Breaker Implementation
     */
    private static class CircuitBreaker {
        private final int failureThreshold;
        private final long timeoutMs;
        private final long halfOpenTimeoutMs;
        
        private CircuitState state = CircuitState.CLOSED;
        private AtomicInteger failureCount = new AtomicInteger(0);
        private AtomicLong lastFailureTime = new AtomicLong(0);
        private AtomicLong lastStateChangeTime = new AtomicLong(0);

        public CircuitBreaker(int failureThreshold, long timeoutMs, long halfOpenTimeoutMs) {
            this.failureThreshold = failureThreshold;
            this.timeoutMs = timeoutMs;
            this.halfOpenTimeoutMs = halfOpenTimeoutMs;
        }

        public boolean isOpen() {
            long now = System.currentTimeMillis();
            
            switch (state) {
                case CLOSED:
                    return false;
                    
                case OPEN:
                    if (now - lastStateChangeTime.get() > timeoutMs) {
                        state = CircuitState.HALF_OPEN;
                        lastStateChangeTime.set(now);
                        logger.info("Circuit breaker transitioning to HALF_OPEN");
                    }
                    return true;
                    
                case HALF_OPEN:
                    if (now - lastStateChangeTime.get() > halfOpenTimeoutMs) {
                        state = CircuitState.CLOSED;
                        failureCount.set(0);
                        lastStateChangeTime.set(now);
                        logger.info("Circuit breaker transitioning to CLOSED");
                    }
                    return false;
                    
                default:
                    return false;
            }
        }

        public void recordSuccess() {
            if (state == CircuitState.HALF_OPEN) {
                state = CircuitState.CLOSED;
                failureCount.set(0);
                lastStateChangeTime.set(System.currentTimeMillis());
                logger.info("Circuit breaker transitioning to CLOSED after success");
            }
        }

        public void recordFailure() {
            long now = System.currentTimeMillis();
            lastFailureTime.set(now);
            
            if (state == CircuitState.CLOSED) {
                int failures = failureCount.incrementAndGet();
                if (failures >= failureThreshold) {
                    state = CircuitState.OPEN;
                    lastStateChangeTime.set(now);
                    logger.warn("Circuit breaker transitioning to OPEN after {} failures", failures);
                }
            } else if (state == CircuitState.HALF_OPEN) {
                state = CircuitState.OPEN;
                lastStateChangeTime.set(now);
                logger.warn("Circuit breaker transitioning to OPEN from HALF_OPEN");
            }
        }

        public CircuitState getState() {
            return state;
        }

        private enum CircuitState {
            CLOSED, OPEN, HALF_OPEN
        }
    }

    /**
     * Shutdown executor service gracefully
     */
    public void shutdown() {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
} 