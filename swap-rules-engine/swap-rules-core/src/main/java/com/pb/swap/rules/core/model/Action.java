package com.pb.swap.rules.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Action(
        String type,
        String targetPath,
        Object value,
        OverridePolicy overridePolicy,
        String templateId,
        Map<String, Object> parameters) {

    public Action {
        if (overridePolicy == null) {
            overridePolicy = OverridePolicy.NEVER;
        }
    }

    public static Action setField(String path, Object value, OverridePolicy policy) {
        return new Action("SET_FIELD", path, value, policy, null, null);
    }
}
