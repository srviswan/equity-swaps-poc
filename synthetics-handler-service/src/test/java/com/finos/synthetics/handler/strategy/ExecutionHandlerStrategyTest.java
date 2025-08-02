package com.finos.synthetics.handler.strategy;

import com.finos.synthetics.handler.model.InstructionRequest;
import com.finos.synthetics.handler.model.InstructionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Execution Handler Strategy Tests
 * 
 * Unit tests for the ExecutionHandlerStrategy.
 * 
 * @version 1.0.0
 */
@DisplayName("Execution Handler Strategy Tests")
class ExecutionHandlerStrategyTest {

    private ExecutionHandlerStrategy strategy;
    private InstructionRequest request;

    @BeforeEach
    void setUp() {
        strategy = new ExecutionHandlerStrategy();
        
        request = new InstructionRequest();
        request.setInstructionId("test-execution-id");
        request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
        request.setInstructionData("{\"product\":\"EQUITY_SWAP\",\"counterparty\":\"BANK_A\",\"quantity\":1000}");
        request.setPriority(InstructionRequest.Priority.NORMAL);
        request.setSourceSystem("TRADING_SYSTEM");
        request.setRequestTimestamp(LocalDateTime.now());
        request.setCorrelationId("test-correlation-id");
    }

    @Test
    @DisplayName("Should process execution instruction successfully")
    void shouldProcessExecutionInstructionSuccessfully() {
        InstructionResponse response = strategy.handle(request);
        
        assertEquals("test-execution-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertNotNull(response.getResult());
        assertTrue(response.getResult().contains("test-execution-id"));
        assertTrue(response.getResult().contains("EQUITY_SWAP"));
        assertTrue(response.getResult().contains("BANK_A"));
        assertEquals("EXECUTION_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        assertNotNull(response.getResponseTimestamp());
    }

    @Test
    @DisplayName("Should handle execution with different instruction data")
    void shouldHandleExecutionWithDifferentInstructionData() {
        request.setInstructionData("{\"product\":\"INTEREST_RATE_SWAP\",\"counterparty\":\"BANK_B\",\"notional\":5000000}");
        
        InstructionResponse response = strategy.handle(request);
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("INTEREST_RATE_SWAP"));
        assertTrue(response.getResult().contains("BANK_B"));
        assertTrue(response.getResult().contains("5000000"));
    }

    @Test
    @DisplayName("Should handle execution with null instruction data")
    void shouldHandleExecutionWithNullInstructionData() {
        request.setInstructionData(null);
        
        InstructionResponse response = strategy.handle(request);
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("null"));
    }

    @Test
    @DisplayName("Should handle execution with empty instruction data")
    void shouldHandleExecutionWithEmptyInstructionData() {
        request.setInstructionData("");
        
        InstructionResponse response = strategy.handle(request);
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains(""));
    }

    @Test
    @DisplayName("Should preserve instruction ID in response")
    void shouldPreserveInstructionIdInResponse() {
        request.setInstructionId("custom-execution-id");
        
        InstructionResponse response = strategy.handle(request);
        
        assertEquals("custom-execution-id", response.getInstructionId());
    }

    @Test
    @DisplayName("Should preserve correlation ID in response")
    void shouldPreserveCorrelationIdInResponse() {
        request.setCorrelationId("custom-correlation-id");
        
        InstructionResponse response = strategy.handle(request);
        
        assertEquals("custom-correlation-id", response.getCorrelationId());
    }

    @Test
    @DisplayName("Should measure processing time accurately")
    void shouldMeasureProcessingTimeAccurately() {
        long startTime = System.currentTimeMillis();
        
        InstructionResponse response = strategy.handle(request);
        
        long endTime = System.currentTimeMillis();
        long actualProcessingTime = endTime - startTime;
        
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() >= 0);
        assertTrue(response.getProcessingTime() <= actualProcessingTime + 100); // Allow some tolerance
    }

    @Test
    @DisplayName("Should return correct strategy name")
    void shouldReturnCorrectStrategyName() {
        assertEquals("ExecutionHandlerStrategy", strategy.getStrategyName());
    }

    @Test
    @DisplayName("Should handle null request gracefully")
    void shouldHandleNullRequestGracefully() {
        InstructionResponse response = strategy.handle(null);
        
        assertEquals("unknown", response.getInstructionId());
        assertEquals(InstructionResponse.Status.FAILED, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Request cannot be null"));
        assertNotNull(response.getResponseTimestamp());
    }

    @Test
    @DisplayName("Should handle request with null instruction ID")
    void shouldHandleRequestWithNullInstructionId() {
        request.setInstructionId(null);
        
        InstructionResponse response = strategy.handle(request);
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("null"));
    }

    @Test
    @DisplayName("Should handle request with different priority levels")
    void shouldHandleRequestWithDifferentPriorityLevels() {
        request.setPriority(InstructionRequest.Priority.HIGH);
        
        InstructionResponse response = strategy.handle(request);
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        // Priority doesn't affect execution logic in this implementation
    }

    @Test
    @DisplayName("Should handle request with different source systems")
    void shouldHandleRequestWithDifferentSourceSystems() {
        request.setSourceSystem("RISK_SYSTEM");
        
        InstructionResponse response = strategy.handle(request);
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        // Source system doesn't affect execution logic in this implementation
    }
} 