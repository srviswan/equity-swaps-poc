package com.pb.tcs.rules;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Canonical JSON codec for {@link SwapBlotter}: one mapper configuration for persistence, the
 * repair workflow, and (later) dispatch envelopes, so payloads round-trip byte-stable.
 */
public final class BlotterJson {

    private static final ObjectMapper MAPPER =
            new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    private BlotterJson() {}

    public static String toJson(SwapBlotter blotter) {
        try {
            return MAPPER.writeValueAsString(blotter);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("blotter serialization failed", e);
        }
    }

    public static SwapBlotter fromJson(String json) {
        try {
            return MAPPER.readValue(json, SwapBlotter.class);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("blotter deserialization failed", e);
        }
    }

    public static JsonNode toTree(SwapBlotter blotter) {
        return MAPPER.valueToTree(blotter);
    }

    /** Generic JSON serialization sharing the blotter mapper config (dispatch envelopes). */
    public static String toJsonMap(Object value) {
        try {
            return MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("json serialization failed", e);
        }
    }

    /**
     * Applies dotted-path field edits (e.g. {@code swap.interestLeg.rateType}) to a serialized
     * blotter, creating intermediate objects where the source omitted null fields. Used by the
     * FR-209 repair workflow.
     */
    public static String applyEdits(String json, Map<String, Object> edits) {
        try {
            ObjectNode root = (ObjectNode) MAPPER.readTree(json);
            for (var entry : edits.entrySet()) {
                String[] parts = entry.getKey().split("\\.");
                ObjectNode node = root;
                for (int i = 0; i < parts.length - 1; i++) {
                    JsonNode child = node.get(parts[i]);
                    if (child == null || !child.isObject()) {
                        child = node.putObject(parts[i]);
                    }
                    node = (ObjectNode) child;
                }
                node.set(parts[parts.length - 1], MAPPER.valueToTree(scalarOf(entry.getValue())));
            }
            return MAPPER.writeValueAsString(root);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("blotter edit failed", e);
        }
    }

    private static Object scalarOf(Object value) {
        // Normalize numerics so edited payloads deserialize like engine-produced ones.
        if (value instanceof Double d) {
            return BigDecimal.valueOf(d);
        }
        return value;
    }
}
