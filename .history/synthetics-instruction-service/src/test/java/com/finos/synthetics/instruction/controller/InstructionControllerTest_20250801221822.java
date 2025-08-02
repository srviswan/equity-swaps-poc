package com.finos.synthetics.instruction.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finos.synthetics.instruction.model.InstructionRequest;
import com.finos.synthetics.instruction.model.InstructionResponse;
import com.finos.synthetics.instruction.service.InstructionProcessorService;
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
import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Instruction Controller Tests
 * 
 * Unit tests for the InstructionController.
 * 
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Instruction Controller Tests")
class InstructionControllerTest {

    @Mock
    private InstructionProcessorService processorService;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private InstructionRequest request;
    private InstructionResponse response;

    @BeforeEach
    void setUp() {
        InstructionController controller = new InstructionController();
        
        // Use reflection to set private field
        try {
            java.lang.reflect.Field serviceField = InstructionController.class.getDeclaredField("instructionProcessorService");
            serviceField.setAccessible(true);
            serviceField.set(controller, processorService);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set up test", e);
        }
        
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
        response.setResult("Execution processed successfully");
        response.setHandlerService("EXECUTION_HANDLER");
        response.setCorrelationId("test-correlation-id");
        response.setProcessingTime(150L);
    }

    @Test
    @DisplayName("Should process instruction successfully")
    void shouldProcessInstructionSuccessfully() throws Exception {
        when(processorService.processInstruction(any(InstructionRequest.class))).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/instructions/process")
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
        
        verify(processorService).processInstruction(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should handle processing error")
    void shouldHandleProcessingError() throws Exception {
        when(processorService.processInstruction(any(InstructionRequest.class)))
                .thenThrow(new RuntimeException("Processing error"));
        
        mockMvc.perform(post("/api/v1/instructions/process")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isInternalServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("FAILED"))
                .andExpect(jsonPath("$.errorMessage").value("Processing error: Processing error"));
        
        verify(processorService).processInstruction(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process instruction asynchronously")
    void shouldProcessInstructionAsynchronously() throws Exception {
        CompletableFuture<InstructionResponse> future = CompletableFuture.completedFuture(response);
        when(processorService.processInstructionAsync(any(InstructionRequest.class))).thenReturn(future);
        
        mockMvc.perform(post("/api/v1/instructions/process/async")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isAccepted());
        
        verify(processorService).processInstructionAsync(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should handle async processing error")
    void shouldHandleAsyncProcessingError() throws Exception {
        when(processorService.processInstructionAsync(any(InstructionRequest.class)))
                .thenThrow(new RuntimeException("Async processing error"));
        
        mockMvc.perform(post("/api/v1/instructions/process/async")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isInternalServerError());
        
        verify(processorService).processInstructionAsync(any(InstructionRequest.class));
    }

    @Test
    @DisplayName("Should process instruction with timeout")
    void shouldProcessInstructionWithTimeout() throws Exception {
        when(processorService.processInstructionWithTimeout(any(InstructionRequest.class), anyLong())).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/instructions/process/timeout")
                .param("timeoutSeconds", "30")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.instructionId").value("test-instruction-id"))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.result").value("Execution processed successfully"));
        
        verify(processorService).processInstructionWithTimeout(any(InstructionRequest.class), eq(30L));
    }

    @Test
    @DisplayName("Should handle timeout processing error")
    void shouldHandleTimeoutProcessingError() throws Exception {
        when(processorService.processInstructionWithTimeout(any(InstructionRequest.class), anyLong()))
                .thenThrow(new RuntimeException("Timeout processing error"));
        
        mockMvc.perform(post("/api/v1/instructions/process/timeout")
                .param("timeoutSeconds", "30")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isRequestTimeout());
        
        verify(processorService).processInstructionWithTimeout(any(InstructionRequest.class), eq(30L));
    }

    @Test
    @DisplayName("Should use default timeout when not specified")
    void shouldUseDefaultTimeoutWhenNotSpecified() throws Exception {
        when(processorService.processInstructionWithTimeout(any(InstructionRequest.class), anyLong())).thenReturn(response);
        
        mockMvc.perform(post("/api/v1/instructions/process/timeout")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
        
        verify(processorService).processInstructionWithTimeout(any(InstructionRequest.class), eq(30L));
    }

    @Test
    @DisplayName("Should return health status")
    void shouldReturnHealthStatus() throws Exception {
        when(processorService.isHandlerServiceHealthy()).thenReturn(true);
        
        mockMvc.perform(get("/api/v1/instructions/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("Instruction Service Status: HEALTHY"));
        
        verify(processorService).isHandlerServiceHealthy();
    }

    @Test
    @DisplayName("Should return unhealthy status")
    void shouldReturnUnhealthyStatus() throws Exception {
        when(processorService.isHandlerServiceHealthy()).thenReturn(false);
        
        mockMvc.perform(get("/api/v1/instructions/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("Instruction Service Status: UNHEALTHY"));
        
        verify(processorService).isHandlerServiceHealthy();
    }

    @Test
    @DisplayName("Should return service info")
    void shouldReturnServiceInfo() throws Exception {
        when(processorService.getHandlerServiceInfo()).thenReturn("Handler Service v1.0.0");
        
        mockMvc.perform(get("/api/v1/instructions/info"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Instruction Service v1.0.0")));
        
        verify(processorService).getHandlerServiceInfo();
    }

    @Test
    @DisplayName("Should return supported instruction types")
    void shouldReturnSupportedInstructionTypes() throws Exception {
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
        mockMvc.perform(post("/api/v1/instructions/process")
                .contentType(MediaType.APPLICATION_JSON)
                .content("invalid json"))
                .andExpect(status().isBadRequest());
        
        verify(processorService, never()).processInstruction(any());
    }

    @Test
    @DisplayName("Should handle missing required fields")
    void shouldHandleMissingRequiredFields() throws Exception {
        InstructionRequest invalidRequest = new InstructionRequest();
        // Don't set required fields
        
        mockMvc.perform(post("/api/v1/instructions/process")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest());
        
        verify(processorService, never()).processInstruction(any());
    }

    @Test
    @DisplayName("Should handle CORS preflight request")
    void shouldHandleCorsPreflightRequest() throws Exception {
        mockMvc.perform(options("/api/v1/instructions/process")
                .header("Origin", "http://localhost:3000")
                .header("Access-Control-Request-Method", "POST")
                .header("Access-Control-Request-Headers", "Content-Type"))
                .andExpect(status().isOk());
    }
} 