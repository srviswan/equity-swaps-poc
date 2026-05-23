package com.pb.swap.rules.core.strategy;

import com.pb.swap.rules.core.action.SwapWriter;
import com.pb.swap.rules.core.compile.CompiledRule;
import com.pb.swap.rules.core.compile.EvaluationContextView;
import com.pb.swap.rules.core.model.Action;
import com.pb.swap.rules.core.trace.BoundedTraceBuffer;
import com.pb.swap.rules.core.trace.DecisionRecord;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Per attribute-path: apply all matching rules most-restrictive first; NEVER only fills nulls. */
public final class LayeredEnrichmentStrategy implements EvaluationStrategy {
  @Override
  public void apply(
      List<CompiledRule> matchedRules,
      EvaluationContextView ctx,
      SwapWriter writer,
      BoundedTraceBuffer trace) {
    Map<String, List<CompiledRule>> byPath = new LinkedHashMap<>();
    for (CompiledRule rule : matchedRules) {
      for (Action action : rule.actions()) {
        if (action.targetPath() != null) {
          byPath.computeIfAbsent(action.targetPath(), p -> new ArrayList<>()).add(rule);
        }
      }
    }
    for (var entry : byPath.entrySet()) {
      String path = entry.getKey();
      List<CompiledRule> rulesForPath = entry.getValue();
      for (CompiledRule rule : rulesForPath) {
        for (Action action : rule.actions()) {
          if (!path.equals(action.targetPath())) {
            continue;
          }
          SwapWriter.MutationResult result = SwapWriter.apply(writer, action);
          if (result.applied()) {
            trace.record(
                new DecisionRecord(
                    trace.nextSeq(),
                    rule.ruleId(),
                    rule.ruleVersion(),
                    rule.category(),
                    rule.target(),
                    rule.evaluationMode(),
                    rule.specificity(),
                    rule.fragmentIds(),
                    rule.templateIds(),
                    List.of(path),
                    result.before(),
                    result.after(),
                    "Layered enrichment applied"));
          }
        }
      }
    }
  }
}
