package com.finos.synthetics.instruction.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Instruction Response Model
 * 
 * Represents the response from processing a CDM primitive instruction.
 * 
 * @version 1.0.0
 */
public class InstructionResponse {

    private static final Logger logger = LoggerFactory.getLogger(InstructionResponse.class);
    private static final Gson gson = new Gson();

    @JsonProperty("instructionId")
    private String instructionId;

    @JsonProperty("status")
    private Status status;

    @JsonProperty("result")
    private String result;

    @JsonProperty("errorMessage")
    private String errorMessage;

    @JsonProperty("processingTime")
    private Long processingTime;

    @JsonProperty("handlerService")
    private String handlerService;

    @JsonProperty("responseTimestamp")
    private LocalDateTime responseTimestamp;

    @JsonProperty("correlationId")
    private String correlationId;

    @JsonProperty("validationErrors")
    private List<String> validationErrors;

    public InstructionResponse() {
        this.responseTimestamp = LocalDateTime.now();
    }

    public InstructionResponse(String instructionId, Status status) {
        this();
        this.instructionId = instructionId;
        this.status = status;
    }

    // Getters and Setters
    public String getInstructionId() { return instructionId; }
    public void setInstructionId(String instructionId) { this.instructionId = instructionId; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    public Long getProcessingTime() { return processingTime; }
    public void setProcessingTime(Long processingTime) { this.processingTime = processingTime; }

    public String getHandlerService() { return handlerService; }
    public void setHandlerService(String handlerService) { this.handlerService = handlerService; }

    public LocalDateTime getResponseTimestamp() { return responseTimestamp; }
    public void setResponseTimestamp(LocalDateTime responseTimestamp) { this.responseTimestamp = responseTimestamp; }

    public String getCorrelationId() { return correlationId; }
    public void setCorrelationId(String correlationId) { this.correlationId = correlationId; }

    public List<String> getValidationErrors() { return validationErrors; }
    public void setValidationErrors(List<String> validationErrors) { this.validationErrors = validationErrors; }

    public String toJson() {
        return gson.toJson(this);
    }

    public static InstructionResponse fromJson(String json) {
        return gson.fromJson(json, InstructionResponse.class);
    }

    @Override
    public String toString() {
        return "InstructionResponse{" +
                "instructionId='" + instructionId + '\'' +
                ", status=" + status +
                ", processingTime=" + processingTime +
                ", handlerService='" + handlerService + '\'' +
                ", responseTimestamp=" + responseTimestamp +
                ", correlationId='" + correlationId + '\'' +
                '}';
    }

    /**
     * Response Status Enum
     */
    public enum Status {
        SUCCESS("Success"),
        FAILED("Failed"),
        VALIDATION_ERROR("Validation Error"),
        TIMEOUT("Timeout"),
        HANDLER_NOT_FOUND("Handler Not Found"),
        PROCESSING("Processing");

        private final String displayName;

        Status(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
} 