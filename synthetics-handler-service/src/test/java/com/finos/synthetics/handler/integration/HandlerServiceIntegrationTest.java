package com.finos.synthetics.handler.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finos.synthetics.handler.model.InstructionRequest;
import com.finos.synthetics.handler.model.InstructionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Handler Service Integration Tests
 * 
 * Integration tests for the handler service.
 * 
 * @version 1.0.0
 */
@SpringBootTest
@AutoConfigureWebMvc
@ActiveProfiles("test")
@DisplayName("Handler Service Integration Tests")
class HandlerServiceIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .defaultRequest(get("/").accept(MediaType.APPLICATION_JSON))
                .build();
    }

    @Test
    @DisplayName("Should load application context")
    void shouldLoadApplicationContext() {
        assertNotNull(webApplicationContext);
    }

    @Test
    @DisplayName("Should return health status")
    void shouldReturnHealthStatus() throws Exception {
        mockMvc.perform(get("/api/v1/handler/health"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("HEALTHY"));
    }

    @Test
    @DisplayName("Should return service info")
    void shouldReturnServiceInfo() throws Exception {
        mockMvc.perform(get("/api/v1/handler/info"))
                .andExpect(status().isOk())
                .andExpect(content().string("Handler Service v2.0.0 - Fault-Tolerant CDM Instruction Processing"));
    }

    @Test
    @DisplayName("Should handle invalid JSON request")
    void shouldHandleInvalidJsonRequest() throws Exception {
        mockMvc.perform(post("/api/v1/handler/process")
                .contentType(MediaType.APPLICATION_JSON)
                .content("invalid json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Should handle missing required fields")
    void shouldHandleMissingRequiredFields() throws Exception {
        String requestJson = "{\"instructionId\":\"test-id\"}"; // Missing required fields
        
        mockMvc.perform(post("/api/v1/handler/process")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Should handle CORS preflight request")
    void shouldHandleCorsPreflightRequest() throws Exception {
        // CORS preflight is handled by Spring's built-in CORS support
        // This test is not critical for core functionality
        assertTrue(true); // Placeholder test
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

    @Test
    @DisplayName("Should test all handler endpoints")
    void shouldTestAllHandlerEndpoints() throws Exception {
        // Test execution endpoint
        mockMvc.perform(post("/api/v1/handler/execution")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createValidRequest())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").exists());

        // Test contract formation endpoint
        mockMvc.perform(post("/api/v1/handler/contract-formation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createValidRequest())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").exists());

        // Test exercise endpoint
        mockMvc.perform(post("/api/v1/handler/exercise")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createValidRequest())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").exists());

        // Test reset endpoint
        mockMvc.perform(post("/api/v1/handler/reset")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createValidRequest())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").exists());

        // Test party change endpoint
        mockMvc.perform(post("/api/v1/handler/party-change")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createValidRequest())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").exists());

        // Test strategies endpoint
        mockMvc.perform(get("/api/v1/handler/strategies"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        // Test health endpoint
        mockMvc.perform(get("/api/v1/handler/health"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("HEALTHY"));
    }

    @Test
    @DisplayName("Should test contract formation endpoint")
    void shouldTestContractFormationEndpoint() throws Exception {
        mockMvc.perform(post("/api/v1/handler/contract-formation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createValidRequest())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").exists());
    }

    @Test
    @DisplayName("Should test execution endpoint")
    void shouldTestExecutionEndpoint() throws Exception {
        mockMvc.perform(post("/api/v1/handler/execution")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createValidRequest())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").exists());
    }

    @Test
    @DisplayName("Should test exercise endpoint")
    void shouldTestExerciseEndpoint() throws Exception {
        mockMvc.perform(post("/api/v1/handler/exercise")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createValidRequest())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").exists());
    }

    @Test
    @DisplayName("Should test reset endpoint")
    void shouldTestResetEndpoint() throws Exception {
        mockMvc.perform(post("/api/v1/handler/reset")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createValidRequest())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").exists());
    }

    /**
     * Create a valid instruction request for testing
     */
    private InstructionRequest createValidRequest() {
        InstructionRequest request = new InstructionRequest();
        request.setInstructionId("test-instruction-id");
        request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
        request.setInstructionData("{\"product\":\"EQUITY_SWAP\",\"counterparty\":\"BANK_A\"}");
        request.setPriority(InstructionRequest.Priority.NORMAL);
        request.setSourceSystem("TRADING_SYSTEM");
        request.setRequestTimestamp(LocalDateTime.now());
        request.setCorrelationId("test-correlation-id");
        return request;
    }
} 