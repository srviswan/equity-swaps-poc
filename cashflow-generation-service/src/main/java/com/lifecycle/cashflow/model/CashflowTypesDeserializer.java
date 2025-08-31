package com.lifecycle.cashflow.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom JSON deserializer for CashflowType list that provides default values.
 */
public class CashflowTypesDeserializer extends JsonDeserializer<List<CashflowType>> {

    @Override
    public List<CashflowType> deserialize(JsonParser p, DeserializationContext ctxt) 
            throws IOException, JsonProcessingException {
        
        JsonNode node = p.getCodec().readTree(p);
        
        if (node == null || node.isNull() || node.isMissingNode()) {
            // Return default INTEREST type if null or missing
            return List.of(CashflowType.INTEREST);
        }
        
        if (node.isArray()) {
            List<CashflowType> types = new ArrayList<>();
            for (JsonNode element : node) {
                try {
                    types.add(CashflowType.valueOf(element.asText().toUpperCase()));
                } catch (IllegalArgumentException e) {
                    // Skip invalid values, or could add logging here
                }
            }
            return types.isEmpty() ? List.of(CashflowType.INTEREST) : types;
        }
        
        // If it's a single string value
        if (node.isTextual()) {
            try {
                return List.of(CashflowType.valueOf(node.asText().toUpperCase()));
            } catch (IllegalArgumentException e) {
                return List.of(CashflowType.INTEREST);
            }
        }
        
        // Default fallback
        return List.of(CashflowType.INTEREST);
    }

    @Override
    public List<CashflowType> getNullValue(DeserializationContext ctxt) {
        // This handles explicit null values in JSON
        return List.of(CashflowType.INTEREST);
    }
}
