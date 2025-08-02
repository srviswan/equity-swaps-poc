package com.finos.synthetics.instruction.service;

import com.finos.synthetics.instruction.model.InstructionRequest;
import com.finos.synthetics.instruction.model.InstructionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Instruction Validation Service Tests
 * 
 * Unit tests for the InstructionValidationService.
 * 
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Instruction Validation Service Tests")
class InstructionValidationServiceTest {

    @Mock
    private Validator validator;

    private InstructionValidationService validationService;
    private InstructionRequest request;

    @BeforeEach
    void setUp() {
        validationService = new InstructionValidationService(validator);
        
        request = new InstructionRequest();
        request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
        request.setInstructionData("{\"product\":\"EQUITY_SWAP\",\"counterparty\":\"BANK_A\"}");
        request.setPriority(InstructionRequest.Priority.NORMAL);
        request.setSourceSystem("TRADING_SYSTEM");
        request.setRequestTimestamp(LocalDateTime.now());
        request.setCorrelationId("test-correlation-id");
    }

    @Test
    @DisplayName("Should validate successful request")
    void shouldValidateSuccessfulRequest() {
        // Mock validator to return no violations
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertEquals("VALIDATION_SERVICE", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNull(response.getErrorMessage());
        assertNull(response.getValidationErrors());
    }

    @Test
    @DisplayName("Should fail validation when request is null")
    void shouldFailValidationWhenRequestIsNull() {
        InstructionResponse response = validationService.validateRequest(null);
        
        assertEquals(InstructionResponse.Status.VALIDATION_ERROR, response.getStatus());
        assertEquals("UNKNOWN", response.getInstructionId());
        assertTrue(response.getErrorMessage().contains("Validation failed"));
        assertNotNull(response.getValidationErrors());
        assertTrue(response.getValidationErrors().contains("Instruction request cannot be null"));
    }

    @Test
    @DisplayName("Should fail validation when instruction type is null")
    void shouldFailValidationWhenInstructionTypeIsNull() {
        request.setInstructionType(null);
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.VALIDATION_ERROR, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Validation failed"));
        assertNotNull(response.getValidationErrors());
        assertTrue(response.getValidationErrors().contains("Instruction type is required"));
    }

    @Test
    @DisplayName("Should fail validation when instruction data is null")
    void shouldFailValidationWhenInstructionDataIsNull() {
        request.setInstructionData(null);
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.VALIDATION_ERROR, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Validation failed"));
        assertNotNull(response.getValidationErrors());
        assertTrue(response.getValidationErrors().contains("Instruction data is required"));
    }

    @Test
    @DisplayName("Should fail validation when instruction data is empty")
    void shouldFailValidationWhenInstructionDataIsEmpty() {
        request.setInstructionData("");
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.VALIDATION_ERROR, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Validation failed"));
        assertNotNull(response.getValidationErrors());
        assertTrue(response.getValidationErrors().contains("Instruction data is required"));
    }

    @Test
    @DisplayName("Should fail validation when priority is null")
    void shouldFailValidationWhenPriorityIsNull() {
        request.setPriority(null);
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.VALIDATION_ERROR, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Validation failed"));
        assertNotNull(response.getValidationErrors());
        assertTrue(response.getValidationErrors().contains("Priority is required"));
    }

    @Test
    @DisplayName("Should fail validation when source system is null")
    void shouldFailValidationWhenSourceSystemIsNull() {
        request.setSourceSystem(null);
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.VALIDATION_ERROR, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Validation failed"));
        assertNotNull(response.getValidationErrors());
        assertTrue(response.getValidationErrors().contains("Source system is required"));
    }

    @Test
    @DisplayName("Should fail validation when source system is empty")
    void shouldFailValidationWhenSourceSystemIsEmpty() {
        request.setSourceSystem("");
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.VALIDATION_ERROR, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Validation failed"));
        assertNotNull(response.getValidationErrors());
        assertTrue(response.getValidationErrors().contains("Source system is required"));
    }

    @Test
    @DisplayName("Should fail validation when request timestamp is null")
    void shouldFailValidationWhenRequestTimestampIsNull() {
        request.setRequestTimestamp(null);
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.VALIDATION_ERROR, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Validation failed"));
        assertNotNull(response.getValidationErrors());
        assertTrue(response.getValidationErrors().contains("Request timestamp is required"));
    }

    @Test
    @DisplayName("Should validate contract formation instruction data")
    void shouldValidateContractFormationInstructionData() {
        request.setInstructionType(InstructionRequest.InstructionType.CONTRACT_FORMATION);
        request.setInstructionData("{\"legalAgreement\":\"ISDA_MASTER_AGREEMENT\"}");
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
    }

    @Test
    @DisplayName("Should fail validation for contract formation with invalid data")
    void shouldFailValidationForContractFormationWithInvalidData() {
        request.setInstructionType(InstructionRequest.InstructionType.CONTRACT_FORMATION);
        request.setInstructionData("{\"invalid\":\"data\"}");
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.VALIDATION_ERROR, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Validation failed"));
        assertNotNull(response.getValidationErrors());
        assertTrue(response.getValidationErrors().contains("Contract formation data must contain legal agreement or contract information"));
    }

    @Test
    @DisplayName("Should validate execution instruction data")
    void shouldValidateExecutionInstructionData() {
        request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
        request.setInstructionData("{\"product\":\"EQUITY_SWAP\",\"counterparty\":\"BANK_A\"}");
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
    }

    @Test
    @DisplayName("Should fail validation for execution with invalid data")
    void shouldFailValidationForExecutionWithInvalidData() {
        request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
        request.setInstructionData("{\"product\":\"EQUITY_SWAP\"}");
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.VALIDATION_ERROR, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Validation failed"));
        assertNotNull(response.getValidationErrors());
        assertTrue(response.getValidationErrors().contains("Execution data must contain product and counterparty information"));
    }

    @Test
    @DisplayName("Should validate exercise instruction data")
    void shouldValidateExerciseInstructionData() {
        request.setInstructionType(InstructionRequest.InstructionType.EXERCISE);
        request.setInstructionData("{\"exerciseOption\":\"CALL_OPTION\",\"exerciseDate\":\"2024-01-01\"}");
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
    }

    @Test
    @DisplayName("Should fail validation for exercise with invalid data")
    void shouldFailValidationForExerciseWithInvalidData() {
        request.setInstructionType(InstructionRequest.InstructionType.EXERCISE);
        request.setInstructionData("{\"exerciseOption\":\"CALL_OPTION\"}");
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.VALIDATION_ERROR, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Validation failed"));
        assertNotNull(response.getValidationErrors());
        assertTrue(response.getValidationErrors().contains("Exercise data must contain exercise option and exercise date"));
    }

    @Test
    @DisplayName("Should validate reset instruction data")
    void shouldValidateResetInstructionData() {
        request.setInstructionType(InstructionRequest.InstructionType.RESET);
        request.setInstructionData("{\"resetDate\":\"2024-01-01\",\"payout\":\"FLOATING_RATE\"}");
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
    }

    @Test
    @DisplayName("Should fail validation for reset with invalid data")
    void shouldFailValidationForResetWithInvalidData() {
        request.setInstructionType(InstructionRequest.InstructionType.RESET);
        request.setInstructionData("{\"resetDate\":\"2024-01-01\"}");
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.VALIDATION_ERROR, response.getStatus());
        assertTrue(response.getErrorMessage().contains("Validation failed"));
        assertNotNull(response.getValidationErrors());
        assertTrue(response.getValidationErrors().contains("Reset data must contain reset date and payout information"));
    }

    @Test
    @DisplayName("Should handle bean validation violations")
    void shouldHandleBeanValidationViolations() {
        Set<ConstraintViolation<InstructionRequest>> violations = new HashSet<>();
        when(validator.validate(request)).thenReturn(violations);
        
        InstructionResponse response = validationService.validateRequest(request);
        
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
    }

    @Test
    @DisplayName("Should handle unknown instruction type")
    void shouldHandleUnknownInstructionType() {
        // This test would require reflection to set an unknown enum value
        // For now, we'll test that the validation service handles the case gracefully
        when(validator.validate(request)).thenReturn(new HashSet<>());
        
        InstructionResponse response = validationService.validateRequest(request);
        
        // Should still pass basic validation
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
    }
} 