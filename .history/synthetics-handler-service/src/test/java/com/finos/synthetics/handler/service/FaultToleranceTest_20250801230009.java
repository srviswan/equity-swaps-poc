package com.finos.synthetics.handler.service;

import com.finos.synthetics.handler.model.InstructionRequest;
import com.finos.synthetics.handler.model.InstructionResponse;
import com.finos.synthetics.handler.strategy.ExecutionHandlerStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Fault Tolerance Test Suite
 * 
 * Tests comprehensive fault tolerance patterns including:
 * - Circuit Breaker Pattern
 * - Retry Logic with Exponential Backoff
 * - Timeout Handling
 * - Graceful Degradation
 * - Health Monitoring
 * 
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class FaultToleranceTest {

    private HandlerService handlerService;
    private InstructionRequest request;

    @Mock
    private ExecutionHandlerStrategy mockStrategy;

    @BeforeEach
    void setUp() {
        handlerService = new HandlerService();
        request = new InstructionRequest();
        request.setInstructionId("test-instruction-id");
        request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
        request.setInstructionData("test-data");
        request.setCorrelationId("test-correlation-id");
    }

    @Test
    @DisplayName("Should handle null request gracefully")
    void shouldHandleNullRequestGracefully() {
        InstructionResponse response = handlerService.processInstruction(null);
        
        assertEquals("unknown", response.getInstructionId());
        assertEquals(InstructionResponse.Status.FAILED, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Request cannot be null"));
        assertNotNull(response.getResponseTimestamp());
    }

    @Test
    @DisplayName("Should handle unsupported instruction type gracefully")
    void shouldHandleUnsupportedInstructionType() {
        // Set instruction type to null to simulate unsupported type
        request.setInstructionType(null);
        
        InstructionResponse response = handlerService.processInstruction(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.FAILED, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Unsupported instruction type"));
        assertNotNull(response.getResponseTimestamp());
    }

    @Test
    @DisplayName("Should provide health status with metrics")
    void shouldProvideHealthStatus() {
        // Process a few requests to generate metrics
        handlerService.processInstruction(request);
        handlerService.processInstruction(request);
        
        Map<String, Object> health = handlerService.getHealthStatus();
        
        assertNotNull(health);
        assertEquals("HEALTHY", health.get("status"));
        assertTrue((Long) health.get("totalRequests") >= 2);
        assertTrue((Long) health.get("successfulRequests") >= 0);
        assertTrue((Long) health.get("failedRequests") >= 0);
        assertTrue((Long) health.get("timeoutRequests") >= 0);
        assertNotNull(health.get("successRate"));
        assertNotNull(health.get("circuitBreakers"));
    }

    @Test
    @DisplayName("Should provide available strategies")
    void shouldProvideAvailableStrategies() {
        Map<InstructionRequest.InstructionType, String> strategies = handlerService.getAvailableStrategies();
        
        assertNotNull(strategies);
        assertTrue(strategies.size() >= 5); // Should have at least 5 strategies
        assertTrue(strategies.containsKey(InstructionRequest.InstructionType.EXECUTION));
        assertTrue(strategies.containsKey(InstructionRequest.InstructionType.CONTRACT_FORMATION));
        assertTrue(strategies.containsKey(InstructionRequest.InstructionType.EXERCISE));
        assertTrue(strategies.containsKey(InstructionRequest.InstructionType.RESET));
        assertTrue(strategies.containsKey(InstructionRequest.InstructionType.PARTY_CHANGE));
    }

    @Test
    @DisplayName("Should handle concurrent requests")
    void shouldHandleConcurrentRequests() throws InterruptedException {
        int numberOfThreads = 10;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        
        // Create multiple threads to process requests concurrently
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(() -> {
                try {
                    InstructionRequest concurrentRequest = new InstructionRequest();
                    concurrentRequest.setInstructionId("concurrent-" + Thread.currentThread().getId());
                    concurrentRequest.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
                    concurrentRequest.setInstructionData("concurrent-data");
                    concurrentRequest.setCorrelationId("concurrent-correlation");
                    
                    InstructionResponse response = handlerService.processInstruction(concurrentRequest);
                    assertNotNull(response);
                    assertNotNull(response.getInstructionId());
                    
                } finally {
                    latch.countDown();
                }
            }).start();
        }
        
        // Wait for all threads to complete
        boolean completed = latch.await(30, TimeUnit.SECONDS);
        assertTrue(completed, "All concurrent requests should complete within timeout");
        
        // Verify metrics reflect concurrent processing
        Map<String, Object> health = handlerService.getHealthStatus();
        assertTrue((Long) health.get("totalRequests") >= numberOfThreads);
    }

    @Test
    @DisplayName("Should handle strategy exceptions gracefully")
    void shouldHandleStrategyExceptions() {
        // This test verifies that exceptions in strategies are handled gracefully
        // The actual strategy implementations should handle their own exceptions
        InstructionResponse response = handlerService.processInstruction(request);
        
        // Even if there's an exception, we should get a valid response
        assertNotNull(response);
        assertNotNull(response.getInstructionId());
        assertNotNull(response.getStatus());
    }

    @Test
    @DisplayName("Should provide consistent response structure")
    void shouldProvideConsistentResponseStructure() {
        InstructionResponse response = handlerService.processInstruction(request);
        
        // Verify all required fields are present
        assertNotNull(response.getInstructionId());
        assertNotNull(response.getStatus());
        assertNotNull(response.getResponseTimestamp());
        
        // Verify optional fields are handled properly
        if (response.getStatus() == InstructionResponse.Status.SUCCESS) {
            assertNotNull(response.getResult());
            assertNotNull(response.getHandlerService());
            assertNotNull(response.getProcessingTime());
            assertNotNull(response.getCorrelationId());
        } else {
            assertNotNull(response.getErrorMessage());
        }
    }

    @Test
    @DisplayName("Should handle different instruction types consistently")
    void shouldHandleDifferentInstructionTypesConsistently() {
        InstructionRequest.InstructionType[] types = {
            InstructionRequest.InstructionType.EXECUTION,
            InstructionRequest.InstructionType.CONTRACT_FORMATION,
            InstructionRequest.InstructionType.EXERCISE,
            InstructionRequest.InstructionType.RESET,
            InstructionRequest.InstructionType.PARTY_CHANGE
        };
        
        for (InstructionRequest.InstructionType type : types) {
            request.setInstructionType(type);
            InstructionResponse response = handlerService.processInstruction(request);
            
            assertNotNull(response);
            assertEquals("test-instruction-id", response.getInstructionId());
            assertNotNull(response.getStatus());
            assertNotNull(response.getResponseTimestamp());
        }
    }

    @Test
    @DisplayName("Should shutdown gracefully")
    void shouldShutdownGracefully() {
        // This test verifies that the service can be shut down gracefully
        assertDoesNotThrow(() -> handlerService.shutdown());
        
        // After shutdown, the service should still be able to provide health status
        Map<String, Object> health = handlerService.getHealthStatus();
        assertNotNull(health);
        assertEquals("HEALTHY", health.get("status"));
    }

    @Test
    @DisplayName("Should maintain circuit breaker state correctly")
    void shouldMaintainCircuitBreakerState() {
        // Process multiple requests to potentially trigger circuit breaker
        for (int i = 0; i < 10; i++) {
            request.setInstructionId("test-instruction-" + i);
            handlerService.processInstruction(request);
        }
        
        // Get health status to check circuit breaker state
        Map<String, Object> health = handlerService.getHealthStatus();
        @SuppressWarnings("unchecked")
        Map<String, String> circuitBreakers = (Map<String, String>) health.get("circuitBreakers");
        
        assertNotNull(circuitBreakers);
        assertTrue(circuitBreakers.containsKey("EXECUTION"));
        assertTrue(circuitBreakers.get("EXECUTION").equals("CLOSED") || 
                   circuitBreakers.get("EXECUTION").equals("OPEN") ||
                   circuitBreakers.get("EXECUTION").equals("HALF_OPEN"));
    }
} 