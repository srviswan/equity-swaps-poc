package com.pb.tcs.config;

import java.util.List;

/** Parsed {@code business-validation.yml} (F4 / FR-300). */
public record BusinessValidationConfig(List<String> mandatoryFields, Structural structural) {

    public BusinessValidationConfig {
        mandatoryFields = List.copyOf(mandatoryFields);
    }

    public record Structural(boolean spreadBpsNonNegative, boolean divPassthroughPercentRange) {}
}
