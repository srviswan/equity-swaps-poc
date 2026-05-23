package com.pb.swap.rules.core.pipeline;

import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.EvaluationMode;
import com.pb.swap.rules.core.model.RuleCategory;

public record PhaseDescriptor(RuleCategory category, EnrichmentTarget target, EvaluationMode mode) {}
