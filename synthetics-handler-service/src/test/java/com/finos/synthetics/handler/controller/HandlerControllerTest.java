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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Handler Controller Tests
 * 
 * Unit tests for the HandlerController.
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
        HandlerController controller = new HandlerController();
        
        // Use reflection to set private field
        try {
            java.lang.reflect.Field serviceField = HandlerController.class.getDeclaredField("handlerService");
            serviceField.setAccessible(true);
            serviceField.set(controller, handlerService);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set up test", e);
        }
        
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
        
        request = new InstructionRequest();
        request.setInstructionId("test-instruction-id");
        request.setInstructionType(InstructionRequest.InstructionType.EXECUTION);
        request.setInstructionData("{\"product\":\"EQUITY_SWAP\",\"counterparty\":\"BANK_A\"}");
        request.setPriority(InstructionRequest.Priority.NORMAL);
        request.setSourceSystem("TRADING_SYSTEM");
        request.setRequestTimestamp(LocalDateTime.now());
        request.setCorrelationId("test-correlation-id");
        
        response = new InstructionResponse("test-instruction-id", InstructionResponse.Status.SUCCESS);
        response.setResult("Execution processed successfully");
        response.setHandlerService("EXECUTION_HANDLER");
        response.setCorrelationId("test-correlation-id");
        response.setProcessingTime(150L);
    }

    @Test
    @DisplayName("Should process contract formation instruction")
    void shouldProcessContractFormationInstruction() throws Exception {
        when(handlerService.processContractFormation(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handlers/contract-formation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.result").value("Execution processed successfully"))
                .andExpect(jsonPath("$.handlerService").value("EXECUTION_HANDLER"))
                .andExpect(jsonPath("$.correlationId").value("test-correlation-id"))
                .andExpect(jsonPath("$.processingTime").value(150));
        
        verify(handlerService).processContractFormation(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process execution instruction")
    void shouldProcessExecutionInstruction() throws Exception {
        when(handlerService.processExecution(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handlers/execution")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.result").value("Execution processed successfully"))
                .andExpect(jsonPath("$.handlerService").value("EXECUTION_HANDLER"))
                .andExpect(jsonPath("$.correlationId").value("test-correlation-id"))
                .andExpect(jsonPath("$.processingTime").value(150));
        
        verify(handlerService).processExecution(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process exercise instruction")
    void shouldProcessExerciseInstruction() throws Exception {
        when(handlerService.processExercise(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handlers/exercise")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.result").value("Execution processed successfully"))
                .andExpect(jsonPath("$.handlerService").value("EXECUTION_HANDLER"))
                .andExpect(jsonPath("$.correlationId").value("test-correlation-id"))
                .andExpect(jsonPath("$.processingTime").value(150));
        
        verify(handlerService).processExercise(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process reset instruction")
    void shouldProcessResetInstruction() throws Exception {
        when(handlerService.processReset(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handlers/reset")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.result").value("Execution processed successfully"))
                .andExpect(jsonPath("$.handlerService").value("EXECUTION_HANDLER"))
                .andExpect(jsonPath("$.correlationId").value("test-correlation-id"))
                .andExpect(jsonPath("$.processingTime").value(150));
        
        verify(handlerService).processReset(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process party change instruction")
    void shouldProcessPartyChangeInstruction() throws Exception {
        when(handlerService.processPartyChange(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handlers/party-change")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.result").value("Execution processed successfully"))
                .andExpect(jsonPath("$.handlerService").value("EXECUTION_HANDLER"))
                .andExpect(jsonPath("$.correlationId").value("test-correlation-id"))
                .andExpect(jsonPath("$.processingTime").value(150));
        
        verify(handlerService).processPartyChange(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process split instruction")
    void shouldProcessSplitInstruction() throws Exception {
        when(handlerService.processSplit(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handlers/split")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.result").value("Execution processed successfully"))
                .andExpect(jsonPath("$.handlerService").value("EXECUTION_HANDLER"))
                .andExpect(jsonPath("$.correlationId").value("test-correlation-id"))
                .andExpect(jsonPath("$.processingTime").value(150));
        
        verify(handlerService).processSplit(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process quantity change instruction")
    void shouldProcessQuantityChangeInstruction() throws Exception {
        when(handlerService.processQuantityChange(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handlers/quantity-change")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.result").value("Execution processed successfully"))
                .andExpect(jsonPath("$.handlerService").value("EXECUTION_HANDLER"))
                .andExpect(jsonPath("$.correlationId").value("test-correlation-id"))
                .andExpect(jsonPath("$.processingTime").value(150));
        
        verify(handlerService).processQuantityChange(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process terms change instruction")
    void shouldProcessTermsChangeInstruction() throws Exception {
        when(handlerService.processTermsChange(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handlers/terms-change")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.result").value("Execution processed successfully"))
                .andExpect(jsonPath("$.handlerService").value("EXECUTION_HANDLER"))
                .andExpect(jsonPath("$.correlationId").value("test-correlation-id"))
                .andExpect(jsonPath("$.processingTime").value(150));
        
        verify(handlerService).processTermsChange(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process transfer instruction")
    void shouldProcessTransferInstruction() throws Exception {
        when(handlerService.processTransfer(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handlers/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.result").value("Execution processed successfully"))
                .andExpect(jsonPath("$.handlerService").value("EXECUTION_HANDLER"))
                .andExpect(jsonPath("$.correlationId").value("test-correlation-id"))
                .andExpect(jsonPath("$.processingTime").value(150));
        
        verify(handlerService).processTransfer(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process index transition instruction")
    void shouldProcessIndexTransitionInstruction() throws Exception {
        when(handlerService.processIndexTransition(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handlers/index-transition")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.result").value("Execution processed successfully"))
                .andExpect(jsonPath("$.handlerService").value("EXECUTION_HANDLER"))
                .andExpect(jsonPath("$.correlationId").value("test-correlation-id"))
                .andExpect(jsonPath("$.processingTime").value(150));
        
        verify(handlerService).processIndexTransition(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process stock split instruction")
    void shouldProcessStockSplitInstruction() throws Exception {
        when(handlerService.processStockSplit(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handlers/stock-split")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.result").value("Execution processed successfully"))
                .andExpect(jsonPath("$.handlerService").value("EXECUTION_HANDLER"))
                .andExpect(jsonPath("$.correlationId").value("test-correlation-id"))
                .andExpect(jsonPath("$.processingTime").value(150));
        
        verify(handlerService).processStockSplit(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process observation instruction")
    void shouldProcessObservationInstruction() throws Exception {
        when(handlerService.processObservation(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handlers/observation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.result").value("Execution processed successfully"))
                .andExpect(jsonPath("$.handlerService").value("EXECUTION_HANDLER"))
                .andExpect(jsonPath("$.correlationId").value("test-correlation-id"))
                .andExpect(jsonPath("$.processingTime").value(150));
        
        verify(handlerService).processObservation(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process valuation instruction")
    void shouldProcessValuationInstruction() throws Exception {
        when(handlerService.processValuation(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/handlers/valuation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.result").value("Execution processed successfully"))
                .andExpect(jsonPath("$.handlerService").value("EXECUTION_HANDLER"))
                .andExpect(jsonPath("$.correlationId").value("test-correlation-id"))
                .andExpect(jsonPath("$.processingTime").value(150));
        
        verify(handlerService).processValuation(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should handle processing error")
    void shouldHandleProcessingError() throws Exception {
        when(handlerService.processExecution(any(InstructionRequest.class)))
                .thenThrow(new RuntimeException("Processing error"));
        
        mockMvc.perform(post("/api/v1/handlers/execution")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isInternalServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("FAILED"))
                .andExpect(jsonPath("$.errorMessage").value("Execution processing error: Processing error"));
        
        verify(handlerService).processExecution(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should return health status")
    void shouldReturnHealthStatus() throws Exception {
        mockMvc.perform(get("/api/v1/handlers/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("Handler Service Status: HEALTHY"));
    }

    @Test
    @DisplayName("Should return service info")
    void shouldReturnServiceInfo() throws Exception {
        mockMvc.perform(get("/api/v1/handlers/info"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Handler Service v1.0.0")));
    }

    @Test
    @DisplayName("Should handle invalid JSON request")
    void shouldHandleInvalidJsonRequest() throws Exception {
        mockMvc.perform(post("/api/v1/handlers/execution")
                .contentType(MediaType.APPLICATION_JSON)
                .content("invalid json"))
                .andExpect(status().isBadRequest());
        
        verify(handlerService, never()).processExecution(any());
    }

    @Test
    @DisplayName("Should handle missing required fields")
    void shouldHandleMissingRequiredFields() throws Exception {
        InstructionRequest invalidRequest = new InstructionRequest();
        // Don't set required fields
        
        mockMvc.perform(post("/api/v1/handlers/execution")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest());
        
        verify(handlerService, never()).processExecution(any());
    }

    @Test
    @DisplayName("Should handle CORS preflight request")
    void shouldHandleCorsPreflightRequest() throws Exception {
        mockMvc.perform(options("/api/v1/handlers/execution")
                .header("Origin", "http://localhost:3000")
                .header("Access-Control-Request-Method", "POST")
                .header("Access-Control-Request-Headers", "Content-Type"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should test all handler endpoints")
    void shouldTestAllHandlerEndpoints() throws Exception {
        // Test all handler endpoints with the same response
        when(handlerService.processContractFormation(any())).thenReturn(response);
        when(handlerService.processExecution(any())).thenReturn(response);
        when(handlerService.processExercise(any())).thenReturn(response);
        when(handlerService.processReset(any())).thenReturn(response);
        when(handlerService.processPartyChange(any())).thenReturn(response);
        when(handlerService.processSplit(any())).thenReturn(response);
        when(handlerService.processQuantityChange(any())).thenReturn(response);
        when(handlerService.processTermsChange(any())).thenReturn(response);
        when(handlerService.processTransfer(any())).thenReturn(response);
        when(handlerService.processIndexTransition(any())).thenReturn(response);
        when(handlerService.processStockSplit(any())).thenReturn(response);
        when(handlerService.processObservation(any())).thenReturn(response);
        when(handlerService.processValuation(any())).thenReturn(response);
        
        String[] endpoints = {
            "/api/v1/handlers/contract-formation",
            "/api/v1/handlers/execution",
            "/api/v1/handlers/exercise",
            "/api/v1/handlers/reset",
            "/api/v1/handlers/party-change",
            "/api/v1/handlers/split",
            "/api/v1/handlers/quantity-change",
            "/api/v1/handlers/terms-change",
            "/api/v1/handlers/transfer",
            "/api/v1/handlers/index-transition",
            "/api/v1/handlers/stock-split",
            "/api/v1/handlers/observation",
            "/api/v1/handlers/valuation"
        };
        
        for (String endpoint : endpoints) {
            mockMvc.perform(post(endpoint)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.status").value("SUCCESS"));
        }
    }
} 