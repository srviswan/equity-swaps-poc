package com.pb.swap.rules.core.strategy;

import com.pb.swap.rules.core.action.SwapWriter;
import com.pb.swap.rules.core.compile.CompiledRule;
import com.pb.swap.rules.core.compile.EvaluationContextView;
import com.pb.swap.rules.core.trace.BoundedTraceBuffer;
import com.pb.swap.rules.core.trace.DecisionRecord;
import java.util.List;

/** Validation: record all matches without mutating swap. */
public final class AllMatchCollectStrategy implements EvaluationStrategy {
  @Override
  public void apply(
      List<CompiledRule> matchedRules,
      EvaluationContextView ctx,
      SwapWriter writer,
      BoundedTraceBuffer trace) {
    for (CompiledRule rule : matchedRules) {
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
              List.of(),
              null,
              null,
              "Validation rule matched"));
    }
  }
}
