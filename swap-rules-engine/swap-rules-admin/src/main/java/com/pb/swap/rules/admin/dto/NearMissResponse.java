package com.pb.swap.rules.admin.dto;

import java.util.List;

public record NearMissResponse(
        String ruleId, int ruleVersion, double score, List<String> missingCriteria) {}
