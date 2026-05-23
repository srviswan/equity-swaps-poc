package com.pb.swap.rules.core.strategy;

import com.pb.swap.rules.core.action.SwapWriter;
import com.pb.swap.rules.core.compile.CompiledRule;
import com.pb.swap.rules.core.compile.EvaluationContextView;
import com.pb.swap.rules.core.model.Action;
import com.pb.swap.rules.core.trace.BoundedTraceBuffer;
import com.pb.swap.rules.core.trace.DecisionRecord;
import java.util.ArrayList;
import java.util.List;

/** Pick single highest-specificity matching rule (list pre-sorted) and apply all its actions. */
public final class FirstMatchExclusiveStrategy implements EvaluationStrategy {
  @Override
  public void apply(
      List<CompiledRule> matchedRules,
      EvaluationContextView ctx,
      SwapWriter writer,
      BoundedTraceBuffer trace) {
    if (matchedRules.isEmpty()) {
      return;
    }
    CompiledRule winner = matchedRules.get(0);
    List<String> paths = new ArrayList<>();
    for (Action action : winner.actions()) {
      SwapWriter.MutationResult result = SwapWriter.apply(writer, action);
      if (action.targetPath() != null) {
        paths.add(action.targetPath());
      }
      if (result.applied()) {
        trace.record(
            new DecisionRecord(
                trace.nextSeq(),
                winner.ruleId(),
                winner.ruleVersion(),
                winner.category(),
                winner.target(),
                winner.evaluationMode(),
                winner.specificity(),
                winner.fragmentIds(),
                winner.templateIds(),
                List.copyOf(paths),
                result.before(),
                result.after(),
                "First-match exclusive rule applied"));
      }
    }
  }
}
