package com.pb.swap.rules.core.strategy;

import com.pb.swap.rules.core.model.EvaluationMode;
import java.util.EnumMap;
import java.util.Map;

public final class StrategyRegistry {
  private final Map<EvaluationMode, EvaluationStrategy> strategies = new EnumMap<>(EvaluationMode.class);

  public StrategyRegistry() {
    strategies.put(EvaluationMode.LAYERED, new LayeredEnrichmentStrategy());
    strategies.put(EvaluationMode.FIRST_MATCH, new FirstMatchExclusiveStrategy());
    strategies.put(EvaluationMode.ALL_MATCH, new AllMatchCollectStrategy());
  }

  public EvaluationStrategy get(EvaluationMode mode) {
    return strategies.getOrDefault(mode, new FirstMatchExclusiveStrategy());
  }
}
