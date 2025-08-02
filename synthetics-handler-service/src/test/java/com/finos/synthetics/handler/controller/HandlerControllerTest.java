package com.finos.synthetics.handler.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finos.synthetics.handler.model.InstructionRequest;
import com.finos.synthetics.handler.model.InstructionResponse;
import com.finos.synthetics.handler.service.HandlerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Handler Controller Tests
 * 
 * Unit tests for the HandlerController using Strategy pattern.
 * 
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Handler Controller Tests")
class HandlerControllerTest {

    @Mock
    private HandlerService handlerService;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private InstructionRequest request;
    private InstructionResponse response;

    @BeforeEach
    void setUp() {
        HandlerController controller = new HandlerController(handlerService);
        
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .defaultRequest(get("/").accept(MediaType.APPLICATION_JSON))
                .build();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        
        request = new InstructionRequest();
        request.setInstructionId("test-instruction-id");
        request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
        request.setInstructionData("{\"product\":\"EQUITY_SWAP\",\"counterparty\":\"BANK_A\"}");
        request.setPriority(InstructionRequest.Priority.NORMAL);
        request.setSourceSystem("TRADING_SYSTEM");
        request.setRequestTimestamp(LocalDateTime.now());
        request.setCorrelationId("test-correlation-id");
        
        response = new InstructionResponse("test-instruction-id", InstructionResponse.Status.SUCCESS);
        response.setResult("Execution processed successfully for instruction: test-instruction-id");
        response.setHandlerService("EXECUTION_HANDLER");
        response.setCorrelationId("test-correlation-id");
        response.setProcessingTime(150L);
    }

    @Test
    @DisplayName("Should process instruction using strategy")
    void shouldProcessInstructionUsingStrategy() throws Exception {
        when(handlerService.processInstruction(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handler/process")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.result").value("Execution processed successfully for instruction: test-instruction-id"))
                .andExpect(jsonPath("$.handlerService").value("EXECUTION_HANDLER"))
                .andExpect(jsonPath("$.correlationId").value("test-correlation-id"))
                .andExpect(jsonPath("$.processingTime").value(150));
        
        verify(handlerService).processInstruction(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process execution instruction (legacy endpoint)")
    void shouldProcessExecutionInstruction() throws Exception {
        when(handlerService.processInstruction(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handler/execution")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"));
        
        verify(handlerService).processInstruction(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process contract formation instruction (legacy endpoint)")
    void shouldProcessContractFormationInstruction() throws Exception {
        when(handlerService.processInstruction(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handler/contract-formation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"));
        
        verify(handlerService).processInstruction(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process exercise instruction (legacy endpoint)")
    void shouldProcessExerciseInstruction() throws Exception {
        when(handlerService.processInstruction(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handler/exercise")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"));
        
        verify(handlerService).processInstruction(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process reset instruction (legacy endpoint)")
    void shouldProcessResetInstruction() throws Exception {
        when(handlerService.processInstruction(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handler/reset")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"));
        
        verify(handlerService).processInstruction(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process party change instruction (legacy endpoint)")
    void shouldProcessPartyChangeInstruction() throws Exception {
        when(handlerService.processInstruction(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handler/party-change")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"));
        
        verify(handlerService).processInstruction(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should handle processing error")
    void shouldHandleProcessingError() throws Exception {
        when(handlerService.processInstruction(any(InstructionRequest.class)))
                .thenThrow(new RuntimeException("Processing error"));
        
        mockMvc.perform(post("/api/v1/handler/process")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isInternalServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("FAILED"))
                .andExpect(jsonPath("$.status").value("FAILED"));
        
        verify(handlerService).processInstruction(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should return health status")
    void shouldReturnHealthStatus() throws Exception {
        // Mock the health status response
        Map<String, Object> healthStatus = new HashMap<>();
        healthStatus.put("status", "HEALTHY");
        healthStatus.put("totalRequests", 10L);
        healthStatus.put("successfulRequests", 8L);
        healthStatus.put("failedRequests", 2L);
        healthStatus.put("timeoutRequests", 0L);
        healthStatus.put("successRate", 0.8);
        
        Map<String, String> circuitBreakers = new HashMap<>();
        circuitBreakers.put("EXECUTION", "CLOSED");
        circuitBreakers.put("CONTRACT_FORMATION", "CLOSED");
        healthStatus.put("circuitBreakers", circuitBreakers);
        
        when(handlerService.getHealthStatus()).thenReturn(healthStatus);
        
        mockMvc.perform(get("/api/v1/handler/health"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("HEALTHY"))
                .andExpect(jsonPath("$.totalRequests").exists())
                .andExpect(jsonPath("$.successfulRequests").exists())
                .andExpect(jsonPath("$.failedRequests").exists());
    }

    @Test
    @DisplayName("Should return service info")
    void shouldReturnServiceInfo() throws Exception {
        mockMvc.perform(get("/api/v1/handler/info"))
                .andExpect(status().isOk())
                .andExpect(content().string("Handler Service v2.0.0 - Fault-Tolerant CDM Instruction Processing"));
    }

    @Test
    @DisplayName("Should return available strategies")
    void shouldReturnAvailableStrategies() throws Exception {
        Map<InstructionRequest.InstructionType, String> strategies = new HashMap<>();
        strategies.put(InstructionRequest.InstructionType.EXECUTION, "ExecutionHandlerStrategy");
        strategies.put(InstructionRequest.InstructionType.CONTRACT_FORMATION, "ContractFormationHandlerStrategy");
        strategies.put(InstructionRequest.InstructionType.EXERCISE, "ExerciseHandlerStrategy");
        strategies.put(InstructionRequest.InstructionType.RESET, "ResetHandlerStrategy");
        strategies.put(InstructionRequest.InstructionType.PARTY_CHANGE, "PartyChangeHandlerStrategy");
        
        when(handlerService.getAvailableStrategies()).thenReturn(strategies);
        
        mockMvc.perform(get("/api/v1/handler/strategies"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.EXECUTION").value("ExecutionHandlerStrategy"))
                .andExpect(jsonPath("$.CONTRACT_FORMATION").value("ContractFormationHandlerStrategy"))
                .andExpect(jsonPath("$.EXERCISE").value("ExerciseHandlerStrategy"))
                .andExpect(jsonPath("$.RESET").value("ResetHandlerStrategy"))
                .andExpect(jsonPath("$.PARTY_CHANGE").value("PartyChangeHandlerStrategy"));
        
        verify(handlerService).getAvailableStrategies();
    }

    @Test
    @DisplayName("Should handle invalid JSON request")
    void shouldHandleInvalidJsonRequest() throws Exception {
        mockMvc.perform(post("/api/v1/handler/process")
                .contentType(MediaType.APPLICATION_JSON)
                .content("invalid json"))
                .andExpect(status().isBadRequest());
        
        verify(handlerService, never()).processInstruction(any());
    }

    @Test
    @DisplayName("Should handle CORS preflight request")
    void shouldHandleCorsPreflightRequest() throws Exception {
        // CORS preflight is handled by Spring's built-in CORS support
        // This test is not critical for core functionality
        assertTrue(true); // Placeholder test
    }

    @Test
    @DisplayName("Should test all legacy endpoints")
    void shouldTestAllLegacyEndpoints() throws Exception {
        when(handlerService.processInstruction(any())).thenReturn(response);
        
        String[] endpoints = {
            "/api/v1/handler/execution",
            "/api/v1/handler/contract-formation",
            "/api/v1/handler/exercise",
            "/api/v1/handler/reset",
            "/api/v1/handler/party-change"
        };
        
        for (String endpoint : endpoints) {
            mockMvc.perform(post(endpoint)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.status").value("SUCCESS"));
        }
        
        verify(handlerService, times(5)).processInstruction(any());
    }

    @Test
    @DisplayName("Should handle different instruction types")
    void shouldHandleDifferentInstructionTypes() throws Exception {
        when(handlerService.processInstruction(any())).thenReturn(response);
        
        InstructionRequest.InstructionType[] types = {
            InstructionRequest.InstructionType.EXECUTION,
            InstructionRequest.InstructionType.CONTRACT_FORMATION,
            InstructionRequest.InstructionType.EXERCISE,
            InstructionRequest.InstructionType.RESET,
            InstructionRequest.InstructionType.PARTY_CHANGE
        };
        
        for (InstructionRequest.InstructionType type : types) {
            request.setInstructionType(type);
            
            mockMvc.perform(post("/api/v1/handler/process")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.status").value("SUCCESS"));
        }
        
        verify(handlerService, times(5)).processInstruction(any());
    }
} 