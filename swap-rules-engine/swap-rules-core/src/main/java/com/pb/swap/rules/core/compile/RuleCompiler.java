package com.pb.swap.rules.core.compile;

import com.pb.swap.rules.core.field.FieldAccessorRegistry;
import com.pb.swap.rules.core.model.Action;
import com.pb.swap.rules.core.model.ActionTemplate;
import com.pb.swap.rules.core.model.CriteriaFragment;
import com.pb.swap.rules.core.model.Criterion;
import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.RuleCategory;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.model.RuleStatus;
import com.pb.swap.rules.core.snapshot.RuleSnapshot;
import com.pb.swap.rules.core.snapshot.TargetBucket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HexFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class RuleCompiler {
    private final FieldAccessorRegistry fieldRegistry = new FieldAccessorRegistry();
    private final SpecificityScorer specificityScorer = new SpecificityScorer();

    public RuleSnapshot compile(
            List<RuleDefinition> rules,
            List<ActionTemplate> templates,
            List<CriteriaFragment> fragments,
            LocalDate asOf) {
        return compileInternal(rules, templates, fragments, r -> isEffective(r, asOf));
    }

    /**
     * FR-205/D7: compiles every enabled+published rule version regardless of effective dates into
     * one snapshot. Date selection moves to evaluation time — {@code RuleSnapshot.bucketFor}
     * filters by the trade date, so back-dated trades hit the rule versions effective on their
     * trade date without recompiling.
     */
    public RuleSnapshot compileFullRange(
            List<RuleDefinition> rules,
            List<ActionTemplate> templates,
            List<CriteriaFragment> fragments) {
        return compileInternal(rules, templates, fragments, r -> true);
    }

    private RuleSnapshot compileInternal(
            List<RuleDefinition> rules,
            List<ActionTemplate> templates,
            List<CriteriaFragment> fragments,
            Predicate<RuleDefinition> effectiveFilter) {
        Map<String, ActionTemplate> templateById =
                templates.stream().collect(Collectors.toMap(ActionTemplate::id, t -> t, (a, b) -> b));
        Map<String, CriteriaFragment> fragmentById =
                fragments.stream().collect(Collectors.toMap(CriteriaFragment::id, f -> f, (a, b) -> b));

        List<CompiledRule> compiled = new ArrayList<>();
        for (RuleDefinition rule : rules) {
            if (!rule.enabled() || !effectiveFilter.test(rule)) {
                continue;
            }
            if (rule.status() != null && rule.status() != RuleStatus.PUBLISHED && rule.status() != RuleStatus.APPROVED) {
                continue;
            }
            CompiledRule cr = compileOne(rule, templateById, fragmentById);
            if (cr != null) {
                compiled.add(cr);
            }
        }

        Map<RuleSnapshot.BucketKey, List<CompiledRule>> grouped = new HashMap<>();
        for (CompiledRule rule : compiled) {
            RuleSnapshot.BucketKey key = new RuleSnapshot.BucketKey(rule.category(), rule.target());
            grouped.computeIfAbsent(key, k -> new ArrayList<>()).add(rule);
        }

        Map<RuleSnapshot.BucketKey, TargetBucket> buckets = new LinkedHashMap<>();
        for (var entry : grouped.entrySet()) {
            List<CompiledRule> sorted = new ArrayList<>(entry.getValue());
            sorted.sort(
                    Comparator.comparingDouble(CompiledRule::specificity)
                            .reversed()
                            .thenComparingInt(CompiledRule::priority)
                            .thenComparing(CompiledRule::ruleId));
            CompiledRule first = sorted.get(0);
            buckets.put(
                    entry.getKey(),
                    new TargetBucket(
                            first.category(),
                            first.target(),
                            first.evaluationMode(),
                            sorted));
        }

        Map<String, List<CompiledRule>> index = buildInvertedIndex(compiled);
        String checksum = checksum(compiled);
        return new RuleSnapshot(UUID.randomUUID().toString(), Instant.now(), checksum, buckets, index);
    }

    /**
     * Builds the inverted index over leading trade dimensions. Uses the rule's pre-flattened
     * criteria (which already include criteria from referenced fragments). For any dimension a
     * rule does not constrain, it is registered under the {@link RuleSnapshot#WILDCARD_KEY} so the
     * runtime can union it with the exact-key match.
     */
    private Map<String, List<CompiledRule>> buildInvertedIndex(List<CompiledRule> compiled) {
        Map<String, List<CompiledRule>> index = new HashMap<>();
        for (CompiledRule rule : compiled) {
            String productType = "";
            String book = "";
            String currency = "";
            String clientTier = "";
            for (Criterion c : rule.flattenedCriteria()) {
                if (c.value() == null) continue;
                String v = c.value().toString();
                switch (c.field()) {
                    case "productType" -> productType = v;
                    case "book" -> book = v;
                    case "currency" -> currency = v;
                    case "clientTier" -> clientTier = v;
                    default -> {}
                }
            }
            String key = RuleSnapshot.indexKey(productType, book, currency, clientTier);
            index.computeIfAbsent(key, k -> new ArrayList<>()).add(rule);
            boolean hasUnspecified =
                    productType.isEmpty() || book.isEmpty() || currency.isEmpty() || clientTier.isEmpty();
            if (hasUnspecified) {
                index.computeIfAbsent(RuleSnapshot.WILDCARD_KEY, k -> new ArrayList<>()).add(rule);
            }
        }
        return index;
    }

    private CompiledRule compileOne(
            RuleDefinition rule,
            Map<String, ActionTemplate> templates,
            Map<String, CriteriaFragment> fragments) {
        List<Criterion> flatCriteria = flattenCriteria(rule, fragments);
        List<Action> flatActions = flattenActions(rule, templates);
        List<String> fragIds = new ArrayList<>();
        if (rule.includes() != null) {
            fragIds.addAll(rule.includes());
        }
        List<String> tmplIds = new ArrayList<>();
        if (rule.apply() != null) {
            tmplIds.addAll(rule.apply());
        }
        double specificity = specificityScorer.score(rule, flatCriteria);
        Predicate<EvaluationContextView> predicate = compilePredicate(flatCriteria);
        return new CompiledRule(
                rule.id(),
                rule.version(),
                rule.name(),
                rule.category(),
                rule.target(),
                rule.resolvedEvaluationMode(),
                rule.resolvedPriority(),
                specificity,
                flatActions,
                flatCriteria,
                fragIds,
                tmplIds,
                predicate,
                rule);
    }

    private List<Criterion> flattenCriteria(RuleDefinition rule, Map<String, CriteriaFragment> fragments) {
        List<Criterion> result = new ArrayList<>();
        if (rule.criteria() != null) {
            result.addAll(rule.criteria());
        }
        if (rule.includes() != null) {
            for (String fragId : rule.includes()) {
                CriteriaFragment frag = fragments.get(fragId);
                if (frag != null && frag.criteria() != null) {
                    for (Criterion c : frag.criteria()) {
                        result.add(new Criterion(c.field(), c.operator(), c.value(), fragId));
                    }
                }
            }
        }
        return result;
    }

    private List<Action> flattenActions(RuleDefinition rule, Map<String, ActionTemplate> templates) {
        List<Action> result = new ArrayList<>();
        if (rule.actions() != null) {
            result.addAll(rule.actions());
        }
        if (rule.apply() != null) {
            for (String tmplId : rule.apply()) {
                ActionTemplate tmpl = templates.get(tmplId);
                if (tmpl != null && tmpl.actions() != null) {
                    for (Action a : tmpl.actions()) {
                        result.add(applyOverrides(a, rule.overrides()));
                    }
                }
            }
        }
        return result;
    }

    private Action applyOverrides(Action action, Map<String, Object> overrides) {
        if (overrides == null || overrides.isEmpty()) {
            return action;
        }
        Object path = action.targetPath();
        if (path != null && overrides.containsKey(simpleKey(path.toString()))) {
            return new Action(
                    action.type(),
                    action.targetPath(),
                    overrides.get(simpleKey(path.toString())),
                    action.overridePolicy(),
                    action.templateId(),
                    action.parameters());
        }
        return action;
    }

    private String simpleKey(String path) {
        int idx = path.lastIndexOf('.');
        return idx >= 0 ? path.substring(idx + 1) : path;
    }

    private Predicate<EvaluationContextView> compilePredicate(List<Criterion> criteria) {
        if (criteria.isEmpty()) {
            return ctx -> true;
        }
        List<Predicate<EvaluationContextView>> parts = new ArrayList<>();
        for (Criterion c : criteria) {
            parts.add(
                    ctx -> {
                        Object actual = fieldRegistry.resolve(ctx, c.field());
                        return OperatorPredicates.evaluate(c, actual);
                    });
        }
        return ctx -> {
            for (Predicate<EvaluationContextView> p : parts) {
                if (!p.test(ctx)) {
                    return false;
                }
            }
            return true;
        };
    }

    private boolean isEffective(RuleDefinition rule, LocalDate asOf) {
        if (asOf == null) {
            asOf = LocalDate.now();
        }
        if (rule.effectiveFrom() != null && asOf.isBefore(rule.effectiveFrom())) {
            return false;
        }
        return rule.effectiveTo() == null || !asOf.isAfter(rule.effectiveTo());
    }

    private String checksum(List<CompiledRule> rules) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            for (CompiledRule r : rules) {
                md.update((r.ruleId() + r.ruleVersion()).getBytes(StandardCharsets.UTF_8));
            }
            return HexFormat.of().formatHex(md.digest()).substring(0, 16);
        } catch (Exception e) {
            return "unknown";
        }
    }

    public FieldAccessorRegistry fieldRegistry() {
        return fieldRegistry;
    }
}
