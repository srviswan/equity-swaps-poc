package com.pb.swap.rules.core.snapshot;

import com.pb.swap.rules.core.compile.CompiledRule;
import com.pb.swap.rules.core.compile.EvaluationContextView;
import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.RuleCategory;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class RuleSnapshot {
    public static final String WILDCARD_KEY = "__WILDCARD__";
    private final String snapshotId;
    private final Instant publishedAt;
    private final String checksum;
    private final Map<BucketKey, TargetBucket> buckets;
    private final Map<String, List<CompiledRule>> indexByDimension;

    public RuleSnapshot(
            String snapshotId,
            Instant publishedAt,
            String checksum,
            Map<BucketKey, TargetBucket> buckets,
            Map<String, List<CompiledRule>> indexByDimension) {
        this.snapshotId = snapshotId;
        this.publishedAt = publishedAt;
        this.checksum = checksum;
        this.buckets = Map.copyOf(buckets);
        this.indexByDimension = Map.copyOf(indexByDimension);
    }

    public static RuleSnapshot empty() {
        return new RuleSnapshot(
                UUID.randomUUID().toString(),
                Instant.now(),
                "empty",
                Map.of(),
                Map.of());
    }

    public String snapshotId() {
        return snapshotId;
    }

    public Instant publishedAt() {
        return publishedAt;
    }

    public String checksum() {
        return checksum;
    }

    public String version() {
        return snapshotId + "@" + publishedAt;
    }

    public TargetBucket bucket(RuleCategory category, EnrichmentTarget target) {
        return buckets.get(new BucketKey(category, target));
    }

    public List<CompiledRule> bucketFor(
            RuleCategory category, EnrichmentTarget target, EvaluationContextView ctx) {
        TargetBucket bucket = bucket(category, target);
        if (bucket == null) {
            return List.of();
        }
        // FR-205/D7: full-range snapshots carry all rule versions; the trade date picks the
        // effective ones at evaluation time (back-dated trades hit historical rules).
        java.time.LocalDate tradeDate =
                ctx.rawTrade() != null ? ctx.rawTrade().tradeDate() : null;
        List<CompiledRule> candidates = resolveCandidates(ctx, bucket.rules());
        List<CompiledRule> matched = new ArrayList<>();
        for (CompiledRule rule : candidates) {
            if (rule.effectiveOn(tradeDate) && rule.matches(ctx)) {
                matched.add(rule);
            }
        }
        return matched;
    }

    private List<CompiledRule> resolveCandidates(
            EvaluationContextView ctx, List<CompiledRule> bucketRules) {
        if (bucketRules.isEmpty()) {
            return bucketRules;
        }
        String key =
                indexKey(
                        stringOrEmpty(ctx.resolveField("productType")),
                        stringOrEmpty(ctx.resolveField("book")),
                        stringOrEmpty(ctx.resolveField("currency")),
                        stringOrEmpty(ctx.resolveField("clientTier")));
        List<CompiledRule> exact = indexByDimension.get(key);
        List<CompiledRule> wildcard = indexByDimension.get(WILDCARD_KEY);
        if ((exact == null || exact.isEmpty()) && (wildcard == null || wildcard.isEmpty())) {
            return bucketRules;
        }
        // Intersect with the bucket so we only return rules in this (category,target).
        java.util.Set<String> bucketIds = new java.util.HashSet<>();
        for (CompiledRule r : bucketRules) bucketIds.add(r.ruleId() + "|" + r.ruleVersion());
        java.util.LinkedHashMap<String, CompiledRule> merged = new java.util.LinkedHashMap<>();
        if (exact != null) {
            for (CompiledRule r : exact) {
                String id = r.ruleId() + "|" + r.ruleVersion();
                if (bucketIds.contains(id)) merged.put(id, r);
            }
        }
        if (wildcard != null) {
            for (CompiledRule r : wildcard) {
                String id = r.ruleId() + "|" + r.ruleVersion();
                if (bucketIds.contains(id)) merged.putIfAbsent(id, r);
            }
        }
        return new ArrayList<>(merged.values());
    }

    public Map<BucketKey, TargetBucket> allBuckets() {
        return Collections.unmodifiableMap(buckets);
    }

    public static String indexKey(String productType, String book, String currency, String clientTier) {
        return productType + "|" + book + "|" + currency + "|" + clientTier;
    }

    private static String stringOrEmpty(Object v) {
        return v == null ? "" : v.toString();
    }

    public record BucketKey(RuleCategory category, EnrichmentTarget target) {}
}
