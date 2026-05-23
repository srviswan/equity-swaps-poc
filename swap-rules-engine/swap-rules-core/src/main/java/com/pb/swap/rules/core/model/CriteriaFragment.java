package com.pb.swap.rules.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CriteriaFragment(
        String id, int version, RuleStatus status, List<Criterion> criteria, Map<String, Object> metadata) {}
