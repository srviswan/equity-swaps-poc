package com.finos.synthetics.handler.service;

import com.finos.synthetics.handler.model.InstructionRequest;
import com.finos.synthetics.handler.model.InstructionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Handler Service Tests
 * 
 * Unit tests for the HandlerService.
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
    @DisplayName("Should process contract formation instruction")
    void shouldProcessContractFormationInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.CONTRACT_FORMATION);
        
        InstructionResponse response = handlerService.processContractFormation(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("Contract formation processed successfully"));
        assertEquals("CONTRACT_FORMATION_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() > 0);
    }

    @Test
    @DisplayName("Should process execution instruction")
    void shouldProcessExecutionInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
        
        InstructionResponse response = handlerService.processExecution(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("Execution processed successfully"));
        assertEquals("EXECUTION_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() > 0);
    }

    @Test
    @DisplayName("Should process exercise instruction")
    void shouldProcessExerciseInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.EXERCISE);
        
        InstructionResponse response = handlerService.processExercise(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("Exercise processed successfully"));
        assertEquals("EXERCISE_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() > 0);
    }

    @Test
    @DisplayName("Should process reset instruction")
    void shouldProcessResetInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.RESET);
        
        InstructionResponse response = handlerService.processReset(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("Reset processed successfully"));
        assertEquals("RESET_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() > 0);
    }

    @Test
    @DisplayName("Should process party change instruction")
    void shouldProcessPartyChangeInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.PARTY_CHANGE);
        
        InstructionResponse response = handlerService.processPartyChange(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("Party change processed successfully"));
        assertEquals("PARTY_CHANGE_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() > 0);
    }

    @Test
    @DisplayName("Should process split instruction")
    void shouldProcessSplitInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.SPLIT);
        
        InstructionResponse response = handlerService.processSplit(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("Split processed successfully"));
        assertEquals("SPLIT_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() > 0);
    }

    @Test
    @DisplayName("Should process quantity change instruction")
    void shouldProcessQuantityChangeInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.QUANTITY_CHANGE);
        
        InstructionResponse response = handlerService.processQuantityChange(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("Quantity change processed successfully"));
        assertEquals("QUANTITY_CHANGE_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() > 0);
    }

    @Test
    @DisplayName("Should process terms change instruction")
    void shouldProcessTermsChangeInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.TERMS_CHANGE);
        
        InstructionResponse response = handlerService.processTermsChange(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("Terms change processed successfully"));
        assertEquals("TERMS_CHANGE_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() > 0);
    }

    @Test
    @DisplayName("Should process transfer instruction")
    void shouldProcessTransferInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.TRANSFER);
        
        InstructionResponse response = handlerService.processTransfer(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("Transfer processed successfully"));
        assertEquals("TRANSFER_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() > 0);
    }

    @Test
    @DisplayName("Should process index transition instruction")
    void shouldProcessIndexTransitionInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.INDEX_TRANSITION);
        
        InstructionResponse response = handlerService.processIndexTransition(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("Index transition processed successfully"));
        assertEquals("INDEX_TRANSITION_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() > 0);
    }

    @Test
    @DisplayName("Should process stock split instruction")
    void shouldProcessStockSplitInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.STOCK_SPLIT);
        
        InstructionResponse response = handlerService.processStockSplit(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("Stock split processed successfully"));
        assertEquals("STOCK_SPLIT_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() > 0);
    }

    @Test
    @DisplayName("Should process observation instruction")
    void shouldProcessObservationInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.OBSERVATION);
        
        InstructionResponse response = handlerService.processObservation(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("Observation processed successfully"));
        assertEquals("OBSERVATION_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() > 0);
    }

    @Test
    @DisplayName("Should process valuation instruction")
    void shouldProcessValuationInstruction() {
        request.setInstructionType(InstructionRequest.InstructionType.VALUATION);
        
        InstructionResponse response = handlerService.processValuation(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertTrue(response.getResult().contains("Valuation processed successfully"));
        assertEquals("VALUATION_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() > 0);
    }

    @Test
    @DisplayName("Should handle processing exception")
    void shouldHandleProcessingException() {
        // Create a request that will cause an exception
        request.setInstructionData(null);
        
        InstructionResponse response = handlerService.processExecution(request);
        
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.FAILED, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Execution processing error"));
        assertEquals("HANDLER_SERVICE", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
    }

    @Test
    @DisplayName("Should measure processing time accurately")
    void shouldMeasureProcessingTimeAccurately() {
        long startTime = System.currentTimeMillis();
        
        InstructionResponse response = handlerService.processExecution(request);
        
        long endTime = System.currentTimeMillis();
        long actualProcessingTime = endTime - startTime;
        
        assertNotNull(response.getProcessingTime());
        assertTrue(response.getProcessingTime() >= 0);
        assertTrue(response.getProcessingTime() <= actualProcessingTime + 100); // Allow some tolerance
    }

    @Test
    @DisplayName("Should handle null request gracefully")
    void shouldHandleNullRequestGracefully() {
        InstructionResponse response = handlerService.processExecution(null);
        
        assertNotNull(response);
        assertEquals(InstructionResponse.Status.FAILED, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Execution processing error"));
        assertEquals("HANDLER_SERVICE", response.getHandlerService());
    }

    @Test
    @DisplayName("Should preserve instruction ID in response")
    void shouldPreserveInstructionIdInResponse() {
        request.setInstructionId("custom-instruction-id");
        
        InstructionResponse response = handlerService.processExecution(request);
        
        assertEquals("custom-instruction-id", response.getInstructionId());
    }

    @Test
    @DisplayName("Should preserve correlation ID in response")
    void shouldPreserveCorrelationIdInResponse() {
        request.setCorrelationId("custom-correlation-id");
        
        InstructionResponse response = handlerService.processExecution(request);
        
        assertEquals("custom-correlation-id", response.getCorrelationId());
    }

    @Test
    @DisplayName("Should handle all instruction types")
    void shouldHandleAllInstructionTypes() {
        InstructionRequest.InstructionType[] types = InstructionRequest.InstructionType.values();
        
        for (InstructionRequest.InstructionType type : types) {
            request.setInstructionType(type);
            
            InstructionResponse response = null;
            switch (type) {
                case CONTRACT_FORMATION:
                    response = handlerService.processContractFormation(request);
                    break;
                case EXECUTION:
                    response = handlerService.processExecution(request);
                    break;
                case EXERCISE:
                    response = handlerService.processExercise(request);
                    break;
                case RESET:
                    response = handlerService.processReset(request);
                    break;
                case PARTY_CHANGE:
                    response = handlerService.processPartyChange(request);
                    break;
                case SPLIT:
                    response = handlerService.processSplit(request);
                    break;
                case QUANTITY_CHANGE:
                    response = handlerService.processQuantityChange(request);
                    break;
                case TERMS_CHANGE:
                    response = handlerService.processTermsChange(request);
                    break;
                case TRANSFER:
                    response = handlerService.processTransfer(request);
                    break;
                case INDEX_TRANSITION:
                    response = handlerService.processIndexTransition(request);
                    break;
                case STOCK_SPLIT:
                    response = handlerService.processStockSplit(request);
                    break;
                case OBSERVATION:
                    response = handlerService.processObservation(request);
                    break;
                case VALUATION:
                    response = handlerService.processValuation(request);
                    break;
            }
            
            assertNotNull(response, "Response should not be null for type: " + type);
            assertEquals("test-instruction-id", response.getInstructionId());
            assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
            assertNotNull(response.getProcessingTime());
        }
    }
} 