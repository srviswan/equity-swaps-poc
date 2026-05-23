package com.pb.swap.rules.admin.nearmiss;

import com.pb.swap.rules.core.compile.CompiledRule;
import com.pb.swap.rules.core.compile.EvaluationContextView;
import com.pb.swap.rules.core.compile.RuleCompiler;
import com.pb.swap.rules.core.field.FieldAccessorRegistry;
import com.pb.swap.rules.core.model.Criterion;
import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.core.snapshot.RuleSnapshot;
import com.pb.swap.rules.runtime.builder.EquitySwapBuilder;
import com.pb.swap.rules.runtime.context.EvaluationContext;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class NearMissScorer {
    private final RuleSnapshot snapshot;
    private final FieldAccessorRegistry fields;

    public NearMissScorer(RuleSnapshot snapshot, RuleCompiler compiler) {
        this.snapshot = snapshot;
        this.fields = compiler.fieldRegistry();
    }

    public List<NearMissResult> score(RawHedgeTrade trade, EnrichmentTarget target, int topN) {
        EvaluationContext ctx = new EvaluationContext(fields);
        ctx.bind(trade, snapshot, EquitySwapBuilder.startFrom(trade));
        List<NearMissResult> results = new ArrayList<>();
        for (var bucket : snapshot.allBuckets().values()) {
            if (bucket.target() != target) {
                continue;
            }
            for (CompiledRule rule : bucket.rules()) {
                if (rule.matches(ctx)) {
                    continue;
                }
                List<Criterion> criteria = rule.flattenedCriteria();
                int matched = 0;
                List<String> missing = new ArrayList<>();
                for (Criterion c : criteria) {
                    Object actual = fields.resolve(ctx, c.field());
                    if (com.pb.swap.rules.core.compile.OperatorPredicates.evaluate(c, actual)) {
                        matched++;
                    } else {
                        missing.add(c.field() + " " + c.operator() + " " + c.value());
                    }
                }
                int total = Math.max(criteria.size(), 1);
                double score = (double) matched / total;
                results.add(new NearMissResult(rule.ruleId(), rule.ruleVersion(), score, missing, rule));
            }
        }
        results.sort(Comparator.comparingDouble(NearMissResult::score).reversed());
        return results.stream().limit(topN).toList();
    }

    public record NearMissResult(
            String ruleId,
            int ruleVersion,
            double score,
            List<String> missingCriteria,
            CompiledRule rule) {}
}
