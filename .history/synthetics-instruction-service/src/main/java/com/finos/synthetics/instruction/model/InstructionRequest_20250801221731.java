package com.finos.synthetics.instruction.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Instruction Request Model
 * 
 * Represents a request to process a CDM primitive instruction.
 * 
 * @version 1.0.0
 */
public class InstructionRequest {

    private static final Logger logger = LoggerFactory.getLogger(InstructionRequest.class);
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
                @Override
                public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
                    return new JsonPrimitive(src.toString());
                }
            })
            .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                @Override
                public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
                    return LocalDateTime.parse(json.getAsString());
                }
            })
            .create();

    @NotNull
    @JsonProperty("instructionId")
    private String instructionId;

    @NotNull
    @JsonProperty("instructionType")
    private InstructionType instructionType;

    @NotNull
    @JsonProperty("instructionData")
    private String instructionData;

    @JsonProperty("priority")
    private Priority priority;

    @JsonProperty("sourceSystem")
    private String sourceSystem;

    @JsonProperty("requestTimestamp")
    private LocalDateTime requestTimestamp;

    @JsonProperty("correlationId")
    private String correlationId;

    public InstructionRequest() {
        this.instructionId = UUID.randomUUID().toString();
        this.requestTimestamp = LocalDateTime.now();
        this.priority = Priority.NORMAL;
    }

    public InstructionRequest(InstructionType instructionType, String instructionData) {
        this();
        this.instructionType = instructionType;
        this.instructionData = instructionData;
    }

    // Getters and Setters
    public String getInstructionId() { return instructionId; }
    public void setInstructionId(String instructionId) { this.instructionId = instructionId; }

    public InstructionType getInstructionType() { return instructionType; }
    public void setInstructionType(InstructionType instructionType) { this.instructionType = instructionType; }

    public String getInstructionData() { return instructionData; }
    public void setInstructionData(String instructionData) { this.instructionData = instructionData; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public String getSourceSystem() { return sourceSystem; }
    public void setSourceSystem(String sourceSystem) { this.sourceSystem = sourceSystem; }

    public LocalDateTime getRequestTimestamp() { return requestTimestamp; }
    public void setRequestTimestamp(LocalDateTime requestTimestamp) { this.requestTimestamp = requestTimestamp; }

    public String getCorrelationId() { return correlationId; }
    public void setCorrelationId(String correlationId) { this.correlationId = correlationId; }

    public String toJson() {
        return gson.toJson(this);
    }

    public static InstructionRequest fromJson(String json) {
        return gson.fromJson(json, InstructionRequest.class);
    }

    @Override
    public String toString() {
        return "InstructionRequest{" +
                "instructionId='" + instructionId + '\'' +
                ", instructionType=" + instructionType +
                ", priority=" + priority +
                ", sourceSystem='" + sourceSystem + '\'' +
                ", requestTimestamp=" + requestTimestamp +
                ", correlationId='" + correlationId + '\'' +
                '}';
    }

    /**
     * Instruction Types Enum
     */
    public enum InstructionType {
        CONTRACT_FORMATION("Contract Formation"),
        EXECUTION("Execution"),
        EXERCISE("Exercise"),
        RESET("Reset"),
        PARTY_CHANGE("Party Change"),
        SPLIT("Split"),
        QUANTITY_CHANGE("Quantity Change"),
        TERMS_CHANGE("Terms Change"),
        TRANSFER("Transfer"),
        INDEX_TRANSITION("Index Transition"),
        STOCK_SPLIT("Stock Split"),
        OBSERVATION("Observation"),
        VALUATION("Valuation");

        private final String displayName;

        InstructionType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    /**
     * Priority Levels Enum
     */
    public enum Priority {
        LOW(1),
        NORMAL(2),
        HIGH(3),
        CRITICAL(4);

        private final int level;

        Priority(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }
} 