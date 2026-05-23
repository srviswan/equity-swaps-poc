package com.pb.swap.rules.core.trace;

import com.pb.swap.rules.core.model.EnrichmentTarget;

public record UnresolvedTarget(EnrichmentTarget target, String path, String status) {}
