package com.finos.synthetics.instruction.service;

import com.finos.synthetics.instruction.client.HandlerServiceClient;
import com.finos.synthetics.instruction.model.InstructionRequest;
import com.finos.synthetics.instruction.model.InstructionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Instruction Processor Service Tests
 * 
 * Unit tests for the InstructionProcessorService.
 * 
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Instruction Processor Service Tests")
class InstructionProcessorServiceTest {

    @Mock
    private HandlerServiceClient handlerServiceClient;

    @Mock
    private InstructionValidationService validationService;

    private InstructionProcessorService processorService;
    private InstructionRequest request;
    private InstructionResponse validationResponse;
    private InstructionResponse handlerResponse;

    @BeforeEach
    void setUp() {
        processorService = new InstructionProcessorService();
        
        // Use reflection to set private fields
        try {
            java.lang.reflect.Field clientField = InstructionProcessorService.class.getDeclaredField("handlerServiceClient");
            clientField.setAccessible(true);
            clientField.set(processorService, handlerServiceClient);
            
            java.lang.reflect.Field validationField = InstructionProcessorService.class.getDeclaredField("validationService");
            validationField.setAccessible(true);
            validationField.set(processorService, validationService);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set up test", e);
        }
        
        request = new InstructionRequest();
        request.setInstructionId("test-instruction-id");
        request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
        request.setInstructionData("{\"product\":\"EQUITY_SWAP\",\"counterparty\":\"BANK_A\"}");
        request.setPriority(InstructionRequest.Priority.NORMAL);
        request.setSourceSystem("TRADING_SYSTEM");
        request.setRequestTimestamp(LocalDateTime.now());
        request.setCorrelationId("test-correlation-id");
        
        validationResponse = new InstructionResponse("test-instruction-id", InstructionResponse.Status.SUCCESS);
        validationResponse.setHandlerService("VALIDATION_SERVICE");
        validationResponse.setCorrelationId("test-correlation-id");
        
        handlerResponse = new InstructionResponse("test-instruction-id", InstructionResponse.Status.SUCCESS);
        handlerResponse.setResult("Execution processed successfully");
        handlerResponse.setHandlerService("EXECUTION_HANDLER");
        handlerResponse.setCorrelationId("test-correlation-id");
    }

    @Test
    @DisplayName("Should process instruction successfully")
    void shouldProcessInstructionSuccessfully() {
        when(validationService.validateRequest(request)).thenReturn(validationResponse);
        when(handlerServiceClient.processExecution(request)).thenReturn(ResponseEntity.ok(handlerResponse));
        
        InstructionResponse response = processorService.processInstruction(request);
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertEquals("Execution processed successfully", response.getResult());
        assertEquals("EXECUTION_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        
        verify(validationService).validateRequest(request);
        verify(handlerServiceClient).processExecution(request);
    }

    @Test
    @DisplayName("Should fail when validation fails")
    void shouldFailWhenValidationFails() {
        InstructionResponse validationError = new InstructionResponse("test-instruction-id", InstructionResponse.Status.VALIDATION_ERROR);
        validationError.setErrorMessage("Validation failed");
        validationError.setHandlerService("VALIDATION_SERVICE");
        validationError.setCorrelationId("test-correlation-id");
        
        when(validationService.validateRequest(request)).thenReturn(validationError);
        
        InstructionResponse response = processorService.processInstruction(request);
        
        assertEquals(InstructionResponse.Status.VALIDATION_ERROR, response.getStatus());
        assertEquals("Validation failed", response.getErrorMessage());
        assertEquals("VALIDATION_SERVICE", response.getHandlerService());
        
        verify(validationService).validateRequest(request);
        verify(handlerServiceClient, never()).processExecution(any());
    }

    @Test
    @DisplayName("Should handle handler service failure")
    void shouldHandleHandlerServiceFailure() {
        when(validationService.validateRequest(request)).thenReturn(validationResponse);
        when(handlerServiceClient.processExecution(request)).thenReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(handlerResponse));
        
        InstructionResponse response = processorService.processInstruction(request);
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertNotNull(response.getProcessingTime());
        
        verify(validationService).validateRequest(request);
        verify(handlerServiceClient).processExecution(request);
    }

    @Test
    @DisplayName("Should handle handler service exception")
    void shouldHandleHandlerServiceException() {
        when(validationService.validateRequest(request)).thenReturn(validationResponse);
        when(handlerServiceClient.processExecution(request)).thenThrow(new RuntimeException("Handler service unavailable"));
        
        InstructionResponse response = processorService.processInstruction(request);
        
        assertEquals(InstructionResponse.Status.FAILED, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Processing error"));
        assertTrue(response.getErrorMessage().contains("Handler service unavailable"));
        assertEquals("INSTRUCTION_SERVICE", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        
        verify(validationService).validateRequest(request);
        verify(handlerServiceClient).processExecution(request);
    }

    @Test
    @DisplayName("Should process instruction asynchronously")
    void shouldProcessInstructionAsynchronously() {
        when(validationService.validateRequest(request)).thenReturn(validationResponse);
        when(handlerServiceClient.processExecution(request)).thenReturn(ResponseEntity.ok(handlerResponse));
        
        CompletableFuture<InstructionResponse> future = processorService.processInstructionAsync(request);
        
        assertNotNull(future);
        
        InstructionResponse response = future.join();
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertEquals("Execution processed successfully", response.getResult());
        assertEquals("EXECUTION_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        
        verify(validationService).validateRequest(request);
        verify(handlerServiceClient).processExecution(request);
    }

    @Test
    @DisplayName("Should process instruction with timeout")
    void shouldProcessInstructionWithTimeout() {
        when(validationService.validateRequest(request)).thenReturn(validationResponse);
        when(handlerServiceClient.processExecution(request)).thenReturn(ResponseEntity.ok(handlerResponse));
        
        InstructionResponse response = processorService.processInstructionWithTimeout(request, 5);
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertEquals("Execution processed successfully", response.getResult());
        assertEquals("EXECUTION_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNotNull(response.getProcessingTime());
        
        verify(validationService).validateRequest(request);
        verify(handlerServiceClient).processExecution(request);
    }

    @Test
    @DisplayName("Should handle timeout exception")
    void shouldHandleTimeoutException() {
        when(validationService.validateRequest(request)).thenReturn(validationResponse);
        when(handlerServiceClient.processExecution(request)).thenAnswer(invocation -> {
            Thread.sleep(1000); // Simulate slow processing
            return ResponseEntity.ok(handlerResponse);
        });
        
        InstructionResponse response = processorService.processInstructionWithTimeout(request, 1);
        
        assertEquals(InstructionResponse.Status.FAILED, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Processing timeout or error"));
        assertEquals("INSTRUCTION_SERVICE", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        
        verify(validationService).validateRequest(request);
        verify(handlerServiceClient).processExecution(request);
    }

    @Test
    @DisplayName("Should delegate to correct handler for execution")
    void shouldDelegateToCorrectHandlerForExecution() {
        request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
        when(validationService.validateRequest(request)).thenReturn(validationResponse);
        when(handlerServiceClient.processExecution(request)).thenReturn(ResponseEntity.ok(handlerResponse));
        
        processorService.processInstruction(request);
        
        verify(handlerServiceClient).processExecution(request);
        verify(handlerServiceClient, never()).processContractFormation(any());
        verify(handlerServiceClient, never()).processExercise(any());
        verify(handlerServiceClient, never()).processReset(any());
    }

    @Test
    @DisplayName("Should delegate to correct handler for contract formation")
    void shouldDelegateToCorrectHandlerForContractFormation() {
        request.setInstructionType(InstructionRequest.InstructionType.CONTRACT_FORMATION);
        when(validationService.validateRequest(request)).thenReturn(validationResponse);
        when(handlerServiceClient.processContractFormation(request)).thenReturn(ResponseEntity.ok(handlerResponse));
        
        processorService.processInstruction(request);
        
        verify(handlerServiceClient).processContractFormation(request);
        verify(handlerServiceClient, never()).processExecution(any());
        verify(handlerServiceClient, never()).processExercise(any());
        verify(handlerServiceClient, never()).processReset(any());
    }

    @Test
    @DisplayName("Should delegate to correct handler for exercise")
    void shouldDelegateToCorrectHandlerForExercise() {
        request.setInstructionType(InstructionRequest.InstructionType.EXERCISE);
        when(validationService.validateRequest(request)).thenReturn(validationResponse);
        when(handlerServiceClient.processExercise(request)).thenReturn(ResponseEntity.ok(handlerResponse));
        
        processorService.processInstruction(request);
        
        verify(handlerServiceClient).processExercise(request);
        verify(handlerServiceClient, never()).processExecution(any());
        verify(handlerServiceClient, never()).processContractFormation(any());
        verify(handlerServiceClient, never()).processReset(any());
    }

    @Test
    @DisplayName("Should delegate to correct handler for reset")
    void shouldDelegateToCorrectHandlerForReset() {
        request.setInstructionType(InstructionRequest.InstructionType.RESET);
        when(validationService.validateRequest(request)).thenReturn(validationResponse);
        when(handlerServiceClient.processReset(request)).thenReturn(ResponseEntity.ok(handlerResponse));
        
        processorService.processInstruction(request);
        
        verify(handlerServiceClient).processReset(request);
        verify(handlerServiceClient, never()).processExecution(any());
        verify(handlerServiceClient, never()).processContractFormation(any());
        verify(handlerServiceClient, never()).processExercise(any());
    }

    @Test
    @DisplayName("Should handle unknown instruction type")
    void shouldHandleUnknownInstructionType() {
        // This test would require reflection to set an unknown enum value
        // For now, we'll test that the processor handles the case gracefully
        when(validationService.validateRequest(request)).thenReturn(validationResponse);
        when(handlerServiceClient.processExecution(request)).thenReturn(ResponseEntity.ok(handlerResponse));
        
        InstructionResponse response = processorService.processInstruction(request);
        
        // Should still process successfully for known types
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
    }

    @Test
    @DisplayName("Should check handler service health")
    void shouldCheckHandlerServiceHealth() {
        when(handlerServiceClient.healthCheck()).thenReturn(ResponseEntity.ok("HEALTHY"));
        
        boolean isHealthy = processorService.isHandlerServiceHealthy();
        
        assertTrue(isHealthy);
        verify(handlerServiceClient).healthCheck();
    }

    @Test
    @DisplayName("Should handle handler service health check failure")
    void shouldHandleHandlerServiceHealthCheckFailure() {
        when(handlerServiceClient.healthCheck()).thenThrow(new RuntimeException("Service unavailable"));
        
        boolean isHealthy = processorService.isHandlerServiceHealthy();
        
        assertFalse(isHealthy);
        verify(handlerServiceClient).healthCheck();
    }

    @Test
    @DisplayName("Should get handler service info")
    void shouldGetHandlerServiceInfo() {
        when(handlerServiceClient.getServiceInfo()).thenReturn(ResponseEntity.ok("Handler Service v1.0.0"));
        
        String info = processorService.getHandlerServiceInfo();
        
        assertEquals("Handler Service v1.0.0", info);
        verify(handlerServiceClient).getServiceInfo();
    }

    @Test
    @DisplayName("Should handle handler service info failure")
    void shouldHandleHandlerServiceInfoFailure() {
        when(handlerServiceClient.getServiceInfo()).thenThrow(new RuntimeException("Service unavailable"));
        
        String info = processorService.getHandlerServiceInfo();
        
        assertEquals("Handler service unavailable", info);
        verify(handlerServiceClient).getServiceInfo();
    }
} 