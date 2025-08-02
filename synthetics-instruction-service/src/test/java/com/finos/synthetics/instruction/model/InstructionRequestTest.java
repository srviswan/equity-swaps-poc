package com.finos.synthetics.instruction.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Instruction Request Model Tests
 * 
 * Unit tests for the InstructionRequest model.
 * 
 * @version 1.0.0
 */
@DisplayName("Instruction Request Model Tests")
class InstructionRequestTest {

    private Validator validator;
    private InstructionRequest request;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        
        request = new InstructionRequest();
        request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
        request.setInstructionData("{\"product\":\"EQUITY_SWAP\",\"counterparty\":\"BANK_A\"}");
        request.setPriority(InstructionRequest.Priority.NORMAL);
        request.setSourceSystem("TRADING_SYSTEM");
        request.setRequestTimestamp(LocalDateTime.now());
        request.setCorrelationId("test-correlation-id");
    }

    @Test
    @DisplayName("Should create valid instruction request")
    void shouldCreateValidInstructionRequest() {
        Set<ConstraintViolation<InstructionRequest>> violations = validator.validate(request);
        assertTrue(violations.isEmpty(), "Should have no validation violations");
    }

    @Test
    @DisplayName("Should fail validation when instruction type is null")
    void shouldFailValidationWhenInstructionTypeIsNull() {
        request.setInstructionType(null);
        Set<ConstraintViolation<InstructionRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty(), "Should have validation violations");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("instructionType")));
    }

    @Test
    @DisplayName("Should fail validation when instruction data is null")
    void shouldFailValidationWhenInstructionDataIsNull() {
        request.setInstructionData(null);
        Set<ConstraintViolation<InstructionRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty(), "Should have validation violations");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("instructionData")));
    }

    @Test
    @DisplayName("Should fail validation when instruction data is empty")
    void shouldFailValidationWhenInstructionDataIsEmpty() {
        request.setInstructionData("");
        Set<ConstraintViolation<InstructionRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty(), "Should have validation violations");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("instructionData")));
    }

    @Test
    @DisplayName("Should create instruction request with constructor")
    void shouldCreateInstructionRequestWithConstructor() {
        InstructionRequest newRequest = new InstructionRequest(
            InstructionRequest.InstructionType.EXECUTION,
            "{\"product\":\"EQUITY_SWAP\"}"
        );
        
        assertNotNull(newRequest.getInstructionId());
        assertEquals(InstructionRequest.InstructionType.EXECUTION, newRequest.getInstructionType());
        assertEquals("{\"product\":\"EQUITY_SWAP\"}", newRequest.getInstructionData());
        assertEquals(InstructionRequest.Priority.NORMAL, newRequest.getPriority());
        assertNotNull(newRequest.getRequestTimestamp());
    }

    @Test
    @DisplayName("Should convert to JSON")
    void shouldConvertToJson() {
        String json = request.toJson();
        assertNotNull(json);
        assertTrue(json.contains("EXECUTION"));
        assertTrue(json.contains("EQUITY_SWAP"));
    }

    @Test
    @DisplayName("Should create from JSON")
    void shouldCreateFromJson() {
        String json = request.toJson();
        InstructionRequest fromJson = InstructionRequest.fromJson(json);
        
        assertEquals(request.getInstructionType(), fromJson.getInstructionType());
        assertEquals(request.getInstructionData(), fromJson.getInstructionData());
        assertEquals(request.getPriority(), fromJson.getPriority());
        assertEquals(request.getSourceSystem(), fromJson.getSourceSystem());
        assertEquals(request.getCorrelationId(), fromJson.getCorrelationId());
    }

    @Test
    @DisplayName("Should have correct instruction type display names")
    void shouldHaveCorrectInstructionTypeDisplayNames() {
        assertEquals("Contract Formation", InstructionRequest.InstructionType.CONTRACT_FORMATION.getDisplayName());
        assertEquals("Execution", InstructionRequest.InstructionType.EXECUTION.getDisplayName());
        assertEquals("Exercise", InstructionRequest.InstructionType.EXERCISE.getDisplayName());
        assertEquals("Reset", InstructionRequest.InstructionType.RESET.getDisplayName());
        assertEquals("Party Change", InstructionRequest.InstructionType.PARTY_CHANGE.getDisplayName());
        assertEquals("Split", InstructionRequest.InstructionType.SPLIT.getDisplayName());
        assertEquals("Quantity Change", InstructionRequest.InstructionType.QUANTITY_CHANGE.getDisplayName());
        assertEquals("Terms Change", InstructionRequest.InstructionType.TERMS_CHANGE.getDisplayName());
        assertEquals("Transfer", InstructionRequest.InstructionType.TRANSFER.getDisplayName());
        assertEquals("Index Transition", InstructionRequest.InstructionType.INDEX_TRANSITION.getDisplayName());
        assertEquals("Stock Split", InstructionRequest.InstructionType.STOCK_SPLIT.getDisplayName());
        assertEquals("Observation", InstructionRequest.InstructionType.OBSERVATION.getDisplayName());
        assertEquals("Valuation", InstructionRequest.InstructionType.VALUATION.getDisplayName());
    }

    @Test
    @DisplayName("Should have correct priority levels")
    void shouldHaveCorrectPriorityLevels() {
        assertEquals(1, InstructionRequest.Priority.LOW.getLevel());
        assertEquals(2, InstructionRequest.Priority.NORMAL.getLevel());
        assertEquals(3, InstructionRequest.Priority.HIGH.getLevel());
        assertEquals(4, InstructionRequest.Priority.CRITICAL.getLevel());
    }

    @Test
    @DisplayName("Should generate UUID for instruction ID")
    void shouldGenerateUuidForInstructionId() {
        InstructionRequest newRequest = new InstructionRequest();
        assertNotNull(newRequest.getInstructionId());
        assertTrue(newRequest.getInstructionId().length() > 0);
    }

    @Test
    @DisplayName("Should set default values in constructor")
    void shouldSetDefaultValuesInConstructor() {
        InstructionRequest newRequest = new InstructionRequest();
        assertNotNull(newRequest.getInstructionId());
        assertNotNull(newRequest.getRequestTimestamp());
        assertEquals(InstructionRequest.Priority.NORMAL, newRequest.getPriority());
    }

    @Test
    @DisplayName("Should have correct toString representation")
    void shouldHaveCorrectToStringRepresentation() {
        String toString = request.toString();
        assertTrue(toString.contains("InstructionRequest"));
        assertTrue(toString.contains("EXECUTION"));
        assertTrue(toString.contains("NORMAL"));
        assertTrue(toString.contains("TRADING_SYSTEM"));
    }
} 