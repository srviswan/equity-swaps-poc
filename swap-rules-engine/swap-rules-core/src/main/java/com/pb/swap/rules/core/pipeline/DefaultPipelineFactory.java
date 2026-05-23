package com.pb.swap.rules.core.pipeline;

import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.EvaluationMode;
import com.pb.swap.rules.core.model.RuleCategory;
import java.util.List;

public final class DefaultPipelineFactory {
  private DefaultPipelineFactory() {}

  public static List<PhaseDescriptor> equitySwapPipeline() {
    return List.of(
        new PhaseDescriptor(RuleCategory.ECONOMIC, EnrichmentTarget.SWAP_CONTRACT, EvaluationMode.LAYERED),
        new PhaseDescriptor(RuleCategory.ECONOMIC, EnrichmentTarget.INTEREST_LEG, EvaluationMode.LAYERED),
        new PhaseDescriptor(RuleCategory.ECONOMIC, EnrichmentTarget.EQUITY_LEG, EvaluationMode.LAYERED),
        new PhaseDescriptor(RuleCategory.ECONOMIC, EnrichmentTarget.SCHEDULE, EvaluationMode.LAYERED),
        new PhaseDescriptor(RuleCategory.ECONOMIC, EnrichmentTarget.DIV_PASSTHROUGH, EvaluationMode.LAYERED),
        new PhaseDescriptor(RuleCategory.NON_ECONOMIC, EnrichmentTarget.LEGAL_ENTITY, EvaluationMode.FIRST_MATCH),
        new PhaseDescriptor(RuleCategory.BUSINESS, EnrichmentTarget.DOCUMENTATION, EvaluationMode.FIRST_MATCH),
        new PhaseDescriptor(RuleCategory.WORKFLOW, EnrichmentTarget.WORKFLOW, EvaluationMode.FIRST_MATCH),
        new PhaseDescriptor(RuleCategory.ROUTING, EnrichmentTarget.ROUTING, EvaluationMode.FIRST_MATCH),
        new PhaseDescriptor(RuleCategory.VALIDATION, EnrichmentTarget.SWAP_CONTRACT, EvaluationMode.ALL_MATCH));
  }
}
