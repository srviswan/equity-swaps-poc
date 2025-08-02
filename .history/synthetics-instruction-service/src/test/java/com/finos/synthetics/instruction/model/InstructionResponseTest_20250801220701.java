package com.finos.synthetics.instruction.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Instruction Response Model Tests
 * 
 * Unit tests for the InstructionResponse model.
 * 
 * @version 1.0.0
 */
@DisplayName("Instruction Response Model Tests")
class InstructionResponseTest {

    private InstructionResponse response;

    @BeforeEach
    void setUp() {
        response = new InstructionResponse();
        response.setInstructionId("test-instruction-id");
        response.setStatus(InstructionResponse.Status.SUCCESS);
        response.setResult("Processing completed successfully");
        response.setErrorMessage(null);
        response.setProcessingTime(150L);
        response.setHandlerService("EXECUTION_HANDLER");
        response.setResponseTimestamp(LocalDateTime.now());
        response.setCorrelationId("test-correlation-id");
        response.setValidationErrors(null);
    }

    @Test
    @DisplayName("Should create valid instruction response")
    void shouldCreateValidInstructionResponse() {
        assertNotNull(response);
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertEquals("Processing completed successfully", response.getResult());
        assertNull(response.getErrorMessage());
        assertEquals(150L, response.getProcessingTime());
        assertEquals("EXECUTION_HANDLER", response.getHandlerService());
        assertNotNull(response.getResponseTimestamp());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertNull(response.getValidationErrors());
    }

    @Test
    @DisplayName("Should create instruction response with constructor")
    void shouldCreateInstructionResponseWithConstructor() {
        InstructionResponse newResponse = new InstructionResponse("new-instruction-id", InstructionResponse.Status.FAILED);
        
        assertEquals("new-instruction-id", newResponse.getInstructionId());
        assertEquals(InstructionResponse.Status.FAILED, newResponse.getStatus());
        assertNotNull(newResponse.getResponseTimestamp());
    }

    @Test
    @DisplayName("Should convert to JSON")
    void shouldConvertToJson() {
        String json = response.toJson();
        assertNotNull(json);
        assertTrue(json.contains("test-instruction-id"));
        assertTrue(json.contains("SUCCESS"));
        assertTrue(json.contains("Processing completed successfully"));
        assertTrue(json.contains("EXECUTION_HANDLER"));
    }

    @Test
    @DisplayName("Should create from JSON")
    void shouldCreateFromJson() {
        String json = response.toJson();
        InstructionResponse fromJson = InstructionResponse.fromJson(json);
        
        assertEquals(response.getInstructionId(), fromJson.getInstructionId());
        assertEquals(response.getStatus(), fromJson.getStatus());
        assertEquals(response.getResult(), fromJson.getResult());
        assertEquals(response.getProcessingTime(), fromJson.getProcessingTime());
        assertEquals(response.getHandlerService(), fromJson.getHandlerService());
        assertEquals(response.getCorrelationId(), fromJson.getCorrelationId());
    }

    @Test
    @DisplayName("Should handle error response")
    void shouldHandleErrorResponse() {
        response.setStatus(InstructionResponse.Status.FAILED);
        response.setErrorMessage("Processing failed due to invalid data");
        response.setValidationErrors(Arrays.asList("Invalid product", "Missing counterparty"));
        
        assertEquals(InstructionResponse.Status.FAILED, response.getStatus());
        assertEquals("Processing failed due to invalid data", response.getErrorMessage());
        assertNotNull(response.getValidationErrors());
        assertEquals(2, response.getValidationErrors().size());
        assertTrue(response.getValidationErrors().contains("Invalid product"));
        assertTrue(response.getValidationErrors().contains("Missing counterparty"));
    }

    @Test
    @DisplayName("Should handle validation error response")
    void shouldHandleValidationErrorResponse() {
        response.setStatus(InstructionResponse.Status.VALIDATION_ERROR);
        response.setErrorMessage("Validation failed");
        List<String> errors = Arrays.asList("Instruction type is required", "Instruction data is required");
        response.setValidationErrors(errors);
        
        assertEquals(InstructionResponse.Status.VALIDATION_ERROR, response.getStatus());
        assertEquals("Validation failed", response.getErrorMessage());
        assertEquals(errors, response.getValidationErrors());
    }

    @Test
    @DisplayName("Should handle timeout response")
    void shouldHandleTimeoutResponse() {
        response.setStatus(InstructionResponse.Status.TIMEOUT);
        response.setErrorMessage("Request timed out after 30 seconds");
        
        assertEquals(InstructionResponse.Status.TIMEOUT, response.getStatus());
        assertEquals("Request timed out after 30 seconds", response.getErrorMessage());
    }

    @Test
    @DisplayName("Should handle handler not found response")
    void shouldHandleHandlerNotFoundResponse() {
        response.setStatus(InstructionResponse.Status.HANDLER_NOT_FOUND);
        response.setErrorMessage("Handler service not found for instruction type: UNKNOWN_TYPE");
        
        assertEquals(InstructionResponse.Status.HANDLER_NOT_FOUND, response.getStatus());
        assertEquals("Handler service not found for instruction type: UNKNOWN_TYPE", response.getErrorMessage());
    }

    @Test
    @DisplayName("Should handle processing response")
    void shouldHandleProcessingResponse() {
        response.setStatus(InstructionResponse.Status.PROCESSING);
        response.setErrorMessage(null);
        
        assertEquals(InstructionResponse.Status.PROCESSING, response.getStatus());
        assertNull(response.getErrorMessage());
    }

    @Test
    @DisplayName("Should have correct status display names")
    void shouldHaveCorrectStatusDisplayNames() {
        assertEquals("Success", InstructionResponse.Status.SUCCESS.getDisplayName());
        assertEquals("Failed", InstructionResponse.Status.FAILED.getDisplayName());
        assertEquals("Validation Error", InstructionResponse.Status.VALIDATION_ERROR.getDisplayName());
        assertEquals("Timeout", InstructionResponse.Status.TIMEOUT.getDisplayName());
        assertEquals("Handler Not Found", InstructionResponse.Status.HANDLER_NOT_FOUND.getDisplayName());
        assertEquals("Processing", InstructionResponse.Status.PROCESSING.getDisplayName());
    }

    @Test
    @DisplayName("Should set default response timestamp")
    void shouldSetDefaultResponseTimestamp() {
        InstructionResponse newResponse = new InstructionResponse();
        assertNotNull(newResponse.getResponseTimestamp());
    }

    @Test
    @DisplayName("Should have correct toString representation")
    void shouldHaveCorrectToStringRepresentation() {
        String toString = response.toString();
        assertTrue(toString.contains("InstructionResponse"));
        assertTrue(toString.contains("test-instruction-id"));
        assertTrue(toString.contains("SUCCESS"));
        assertTrue(toString.contains("150"));
        assertTrue(toString.contains("EXECUTION_HANDLER"));
        assertTrue(toString.contains("test-correlation-id"));
    }

    @Test
    @DisplayName("Should handle null values in JSON conversion")
    void shouldHandleNullValuesInJsonConversion() {
        response.setErrorMessage(null);
        response.setValidationErrors(null);
        
        String json = response.toJson();
        assertNotNull(json);
        InstructionResponse fromJson = InstructionResponse.fromJson(json);
        
        assertNull(fromJson.getErrorMessage());
        assertNull(fromJson.getValidationErrors());
    }

    @Test
    @DisplayName("Should handle empty validation errors")
    void shouldHandleEmptyValidationErrors() {
        response.setValidationErrors(Arrays.asList());
        
        assertNotNull(response.getValidationErrors());
        assertTrue(response.getValidationErrors().isEmpty());
    }
} 