package com.finos.synthetics.handler.service;

import com.finos.synthetics.handler.model.InstructionRequest;
import com.finos.synthetics.handler.model.InstructionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Handler Service Tests
 * 
 * Unit tests for the HandlerService using Strategy pattern.
 * 
 * @version 1.0.0
 */
@DisplayName("Handler Service Tests")
class HandlerServiceTest {

    private HandlerService handlerService;
    private InstructionRequest request;

    @BeforeEach
    void setUp() {
        handlerService = new HandlerService();
        
        request = new InstructionRequest();
        request.setInstructionId("test-instruction-id");
        request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
        request.setInstructionData("{\"product\":\"EQUITY_SWAP\",\"counterparty\":\"BANK_A\"}");
        request.setPriority(InstructionRequest.Priority.NORMAL);
        request.setSourceSystem("TRADING_SYSTEM");
        request.setRequestTimestamp(LocalDateTime.now());
        request.setCorrelationId("test-correlation-id");
    }

    @Test
    @DisplayName("Should process execution instruction using strategy")
    void shouldProcessExecutionInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
        
        InstructionResponse response = handlerService.processInstruction(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertNotNull(response.getResult());
        assertEquals("EXECUTION_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
    }

    @Test
    @DisplayName("Should process contract formation instruction using strategy")
    void shouldProcessContractFormationInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.CONTRACT_FORMATION);
        
        InstructionResponse response = handlerService.processInstruction(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertNotNull(response.getResult());
        assertEquals("CONTRACT_FORMATION_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
    }

    @Test
    @DisplayName("Should process exercise instruction using strategy")
    void shouldProcessExerciseInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.EXERCISE);
        
        InstructionResponse response = handlerService.processInstruction(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertNotNull(response.getResult());
        assertEquals("EXERCISE_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
    }

    @Test
    @DisplayName("Should process reset instruction using strategy")
    void shouldProcessResetInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.RESET);
        
        InstructionResponse response = handlerService.processInstruction(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertNotNull(response.getResult());
        assertEquals("RESET_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
    }

    @Test
    @DisplayName("Should process party change instruction using strategy")
    void shouldProcessPartyChangeInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.PARTY_CHANGE);
        
        InstructionResponse response = handlerService.processInstruction(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertNotNull(response.getResult());
        assertEquals("PARTY_CHANGE_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
    }

    @Test
    @DisplayName("Should handle unsupported instruction type gracefully")
    void shouldHandleUnsupportedInstructionType() {
        request.setInstructionType(null); // Set to null to simulate unsupported type
        
        InstructionResponse response = handlerService.processInstruction(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.FAILED, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Unsupported instruction type"));
        assertNotNull(response.getResponseTimestamp());
    }

    @Test
    @DisplayName("Should handle processing exception")
    void shouldHandleProcessingException() {
        // Create a request that will cause an exception by using an unsupported type
        request.setInstructionType(null);
        
        InstructionResponse response = handlerService.processInstruction(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.FAILED, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Unsupported instruction type"));
        assertNotNull(response.getResponseTimestamp());
    }

    @Test
    @DisplayName("Should measure processing time accurately")
    void shouldMeasureProcessingTimeAccurately() {
        long startTime = System.currentTimeMillis();
        
        InstructionResponse response = handlerService.processInstruction(request);
        
        long endTime = System.currentTimeMillis();
        long actualProcessingTime = endTime - startTime;
        
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() >= 0);
        assertTrue(response.getProcessingTime() <= actualProcessingTime + 100); // Allow some tolerance
    }

    @Test
    @DisplayName("Should handle null request gracefully")
    void shouldHandleNullRequestGracefully() {
        InstructionResponse response = handlerService.processInstruction(null);
        
        assertNotNull(response);
        assertEquals(InstructionResponse.Status.FAILED, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Request cannot be null"));
    }

    @Test
    @DisplayName("Should preserve instruction ID in response")
    void shouldPreserveInstructionIdInResponse() {
        request.setInstructionId("custom-instruction-id");
        
        InstructionResponse response = handlerService.processInstruction(request);
        
        assertEquals("custom-instruction-id", response.getInstructionId());
    }

    @Test
    @DisplayName("Should preserve correlation ID in response")
    void shouldPreserveCorrelationIdInResponse() {
        request.setCorrelationId("custom-correlation-id");
        
        InstructionResponse response = handlerService.processInstruction(request);
        
        assertEquals("custom-correlation-id", response.getCorrelationId());
    }

    @Test
    @DisplayName("Should get available strategies")
    void shouldGetAvailableStrategies() {
        Map<InstructionRequest.InstructionType, String> strategies = handlerService.getAvailableStrategies();
        
        assertNotNull(strategies);
        assertTrue(strategies.size() > 0);
        
        // Check that implemented strategies are available
        assertTrue(strategies.containsKey(InstructionRequest.InstructionType.EXECUTION));
        assertTrue(strategies.containsKey(InstructionRequest.InstructionType.CONTRACT_FORMATION));
        assertTrue(strategies.containsKey(InstructionRequest.InstructionType.EXERCISE));
        assertTrue(strategies.containsKey(InstructionRequest.InstructionType.RESET));
        assertTrue(strategies.containsKey(InstructionRequest.InstructionType.PARTY_CHANGE));
        
        // Check strategy class names
        assertEquals("ExecutionHandlerStrategy", strategies.get(InstructionRequest.InstructionType.EXECUTION));
        assertEquals("ContractFormationHandlerStrategy", strategies.get(InstructionRequest.InstructionType.CONTRACT_FORMATION));
        assertEquals("ExerciseHandlerStrategy", strategies.get(InstructionRequest.InstructionType.EXERCISE));
        assertEquals("ResetHandlerStrategy", strategies.get(InstructionRequest.InstructionType.RESET));
        assertEquals("PartyChangeHandlerStrategy", strategies.get(InstructionRequest.InstructionType.PARTY_CHANGE));
    }

    @Test
    @DisplayName("Should handle all supported instruction types")
    void shouldHandleAllSupportedInstructionTypes() {
        // Test all implemented strategies
        InstructionRequest.InstructionType[] supportedTypes = {
            InstructionRequest.InstructionType.EXECUTION,
            InstructionRequest.InstructionType.CONTRACT_FORMATION,
            InstructionRequest.InstructionType.EXERCISE,
            InstructionRequest.InstructionType.RESET,
            InstructionRequest.InstructionType.PARTY_CHANGE
        };
        
        for (InstructionRequest.InstructionType type : supportedTypes) {
            request.setInstructionType(type);
            
            InstructionResponse response = handlerService.processInstruction(request);
            
            assertNotNull(response, "Response should not be null for type: " + type);
            assertEquals("test-instruction-id", response.getInstructionId());
            assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
            assertNotNull(response.getProcessingTime());
            assertNotNull(response.getResponseTimestamp());
        }
    }

    @Test
    @DisplayName("Should handle unsupported instruction types gracefully")
    void shouldHandleUnsupportedInstructionTypesGracefully() {
        // Test unsupported types
        InstructionRequest.InstructionType[] unsupportedTypes = {
            InstructionRequest.InstructionType.SPLIT,
            InstructionRequest.InstructionType.QUANTITY_CHANGE,
            InstructionRequest.InstructionType.TERMS_CHANGE,
            InstructionRequest.InstructionType.TRANSFER,
            InstructionRequest.InstructionType.INDEX_TRANSITION,
            InstructionRequest.InstructionType.STOCK_SPLIT,
            InstructionRequest.InstructionType.OBSERVATION,
            InstructionRequest.InstructionType.VALUATION
        };
        
        for (InstructionRequest.InstructionType type : unsupportedTypes) {
            request.setInstructionType(type);
            
            InstructionResponse response = handlerService.processInstruction(request);
            
            assertNotNull(response, "Response should not be null for type: " + type);
            assertEquals("test-instruction-id", response.getInstructionId());
            assertEquals(InstructionResponse.Status.FAILED, response.getStatus());
            assertTrue(response.getErrorMessage().contains("Unsupported instruction type"));
            assertNotNull(response.getResponseTimestamp());
        }
    }
} 