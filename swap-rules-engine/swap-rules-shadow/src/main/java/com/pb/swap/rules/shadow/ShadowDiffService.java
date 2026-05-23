package com.pb.swap.rules.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pb.swap.rules.core.api.EnrichmentResult;
import com.pb.swap.rules.core.model.EnrichedEquitySwap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/** Compares new engine output with legacy swap representation for cutover monitoring. */
public final class ShadowDiffService {
    private final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public ShadowDiff diff(EnrichedEquitySwap newSwap, Object legacySwap) {
        JsonNode left = mapper.valueToTree(newSwap);
        JsonNode right = mapper.valueToTree(legacySwap);
        List<FieldDiff> diffs = new ArrayList<>();
        compare("", left, right, diffs);
        return new ShadowDiff(newSwap.tradeId(), diffs, diffs.isEmpty());
    }

    public ShadowDiff diff(EnrichmentResult newResult, Object legacySwap) {
        return diff(newResult.swap(), legacySwap);
    }

    private void compare(String path, JsonNode left, JsonNode right, List<FieldDiff> diffs) {
        if (left.equals(right)) {
            return;
        }
        if (left.isObject() && right.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = left.fields();
            while (fields.hasNext()) {
                var e = fields.next();
                String childPath = path.isEmpty() ? e.getKey() : path + "." + e.getKey();
                JsonNode rChild = right.get(e.getKey());
                if (rChild == null) {
                    diffs.add(new FieldDiff(childPath, e.getValue().asText(), null));
                } else {
                    compare(childPath, e.getValue(), rChild, diffs);
                }
            }
            return;
        }
        diffs.add(new FieldDiff(path, left.asText(), right.asText()));
    }

    public record FieldDiff(String path, String newValue, String legacyValue) {}

    public record ShadowDiff(String tradeId, List<FieldDiff> diffs, boolean match) {}
}
