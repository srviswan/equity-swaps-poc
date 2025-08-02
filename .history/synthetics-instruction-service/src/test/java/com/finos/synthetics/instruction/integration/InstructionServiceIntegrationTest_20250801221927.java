package com.finos.synthetics.instruction.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finos.synthetics.instruction.model.InstructionRequest;
import com.finos.synthetics.instruction.model.InstructionResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Instruction Service Integration Tests
 * 
 * Integration tests for the instruction service.
 * 
 * @version 1.0.0
 */
@WebMvcTest(InstructionController.class)
@ContextConfiguration(classes = {com.finos.synthetics.instruction.config.TestConfig.class})
@DisplayName("Instruction Service Integration Tests")
class InstructionServiceIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @Test
    @DisplayName("Should load application context")
    void shouldLoadApplicationContext() {
        assertNotNull(webApplicationContext);
    }

    @Test
    @DisplayName("Should return health status")
    void shouldReturnHealthStatus() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        
        mockMvc.perform(get("/api/v1/instructions/health"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Instruction Service Status")));
    }

    @Test
    @DisplayName("Should return service info")
    void shouldReturnServiceInfo() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        
        mockMvc.perform(get("/api/v1/instructions/info"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Instruction Service v1.0.0")));
    }

    @Test
    @DisplayName("Should return supported instruction types")
    void shouldReturnSupportedInstructionTypes() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        
        mockMvc.perform(get("/api/v1/instructions/types"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").value("CONTRACT_FORMATION"))
                .andExpect(jsonPath("$[1]").value("EXECUTION"))
                .andExpect(jsonPath("$[2]").value("EXERCISE"))
                .andExpect(jsonPath("$[3]").value("RESET"))
                .andExpect(jsonPath("$[4]").value("PARTY_CHANGE"))
                .andExpect(jsonPath("$[5]").value("SPLIT"))
                .andExpect(jsonPath("$[6]").value("QUANTITY_CHANGE"))
                .andExpect(jsonPath("$[7]").value("TERMS_CHANGE"))
                .andExpect(jsonPath("$[8]").value("TRANSFER"))
                .andExpect(jsonPath("$[9]").value("INDEX_TRANSITION"))
                .andExpect(jsonPath("$[10]").value("STOCK_SPLIT"))
                .andExpect(jsonPath("$[11]").value("OBSERVATION"))
                .andExpect(jsonPath("$[12]").value("VALUATION"));
    }

    @Test
    @DisplayName("Should return instruction priorities")
    void shouldReturnInstructionPriorities() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        
        mockMvc.perform(get("/api/v1/instructions/priorities"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").value("LOW"))
                .andExpect(jsonPath("$[1]").value("NORMAL"))
                .andExpect(jsonPath("$[2]").value("HIGH"))
                .andExpect(jsonPath("$[3]").value("CRITICAL"));
    }

    @Test
    @DisplayName("Should handle invalid JSON request")
    void shouldHandleInvalidJsonRequest() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        
        mockMvc.perform(post("/api/v1/instructions/process")
                .contentType(MediaType.APPLICATION_JSON)
                .content("invalid json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Should handle missing required fields")
    void shouldHandleMissingRequiredFields() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        
        InstructionRequest invalidRequest = new InstructionRequest();
        // Don't set required fields
        
        mockMvc.perform(post("/api/v1/instructions/process")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Should handle CORS preflight request")
    void shouldHandleCorsPreflightRequest() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        
        mockMvc.perform(options("/api/v1/instructions/process")
                .header("Origin", "http://localhost:3000")
                .header("Access-Control-Request-Method", "POST")
                .header("Access-Control-Request-Headers", "Content-Type"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should validate instruction request model")
    void shouldValidateInstructionRequestModel() {
        InstructionRequest request = new InstructionRequest();
        request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
        request.setInstructionData("{\"product\":\"EQUITY_SWAP\",\"counterparty\":\"BANK_A\"}");
        request.setPriority(InstructionRequest.Priority.NORMAL);
        request.setSourceSystem("TRADING_SYSTEM");
        request.setRequestTimestamp(LocalDateTime.now());
        request.setCorrelationId("test-correlation-id");
        
        assertNotNull(request);
        assertEquals(InstructionRequest.InstructionType.EXECUTION, request.getInstructionType());
        assertEquals("{\"product\":\"EQUITY_SWAP\",\"counterparty\":\"BANK_A\"}", request.getInstructionData());
        assertEquals(InstructionRequest.Priority.NORMAL, request.getPriority());
        assertEquals("TRADING_SYSTEM", request.getSourceSystem());
        assertEquals("test-correlation-id", request.getCorrelationId());
        assertNotNull(request.getRequestTimestamp());
    }

    @Test
    @DisplayName("Should validate instruction response model")
    void shouldValidateInstructionResponseModel() {
        InstructionResponse response = new InstructionResponse("test-instruction-id", InstructionResponse.Status.SUCCESS);
        response.setResult("Processing completed successfully");
        response.setHandlerService("EXECUTION_HANDLER");
        response.setCorrelationId("test-correlation-id");
        response.setProcessingTime(150L);
        
        assertNotNull(response);
        assertEquals("test-instruction-id", response.getInstructionId());
        assertEquals(InstructionResponse.Status.SUCCESS, response.getStatus());
        assertEquals("Processing completed successfully", response.getResult());
        assertEquals("EXECUTION_HANDLER", response.getHandlerService());
        assertEquals("test-correlation-id", response.getCorrelationId());
        assertEquals(150L, response.getProcessingTime());
    }

    @Test
    @DisplayName("Should handle all instruction types")
    void shouldHandleAllInstructionTypes() {
        InstructionRequest.InstructionType[] types = InstructionRequest.InstructionType.values();
        
        for (InstructionRequest.InstructionType type : types) {
            InstructionRequest request = new InstructionRequest();
            request.setInstructionType(type);
            request.setInstructionData("{\"test\":\"data\"}");
            request.setPriority(InstructionRequest.Priority.NORMAL);
            request.setSourceSystem("TEST_SYSTEM");
            request.setRequestTimestamp(LocalDateTime.now());
            request.setCorrelationId("test-correlation-id");
            
            assertNotNull(request);
            assertEquals(type, request.getInstructionType());
            assertNotNull(request.getInstructionId());
            assertNotNull(request.getRequestTimestamp());
        }
    }

    @Test
    @DisplayName("Should handle all priority levels")
    void shouldHandleAllPriorityLevels() {
        InstructionRequest.Priority[] priorities = InstructionRequest.Priority.values();
        
        for (InstructionRequest.Priority priority : priorities) {
            InstructionRequest request = new InstructionRequest();
            request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
            request.setInstructionData("{\"test\":\"data\"}");
            request.setPriority(priority);
            request.setSourceSystem("TEST_SYSTEM");
            request.setRequestTimestamp(LocalDateTime.now());
            request.setCorrelationId("test-correlation-id");
            
            assertNotNull(request);
            assertEquals(priority, request.getPriority());
            assertTrue(priority.getLevel() > 0);
        }
    }

    @Test
    @DisplayName("Should handle all response statuses")
    void shouldHandleAllResponseStatuses() {
        InstructionResponse.Status[] statuses = InstructionResponse.Status.values();
        
        for (InstructionResponse.Status status : statuses) {
            InstructionResponse response = new InstructionResponse("test-instruction-id", status);
            
            assertNotNull(response);
            assertEquals("test-instruction-id", response.getInstructionId());
            assertEquals(status, response.getStatus());
            assertNotNull(response.getResponseTimestamp());
        }
    }
} 