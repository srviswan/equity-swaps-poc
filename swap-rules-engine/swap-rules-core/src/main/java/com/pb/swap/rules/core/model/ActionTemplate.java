package com.pb.swap.rules.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ActionTemplate(
        String id,
        int version,
        EnrichmentTarget target,
        RuleStatus status,
        List<Action> actions,
        Map<String, Object> metadata) {}
