package com.pb.tcs.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Loads the F0.4 contract files from {@code classpath:tcs-config/}. Mapping is hand-rolled
 * (rather than annotation-driven) because two of the files are polymorphic: cache-policy entities
 * are either flat or grouped, and position-match-key {@code matchKey} is either the string
 * {@code default} or an inline field list.
 */
public final class TcsConfigLoader {

    private static final ObjectMapper YAML = new ObjectMapper(new YAMLFactory());
    private static final Pattern TTL = Pattern.compile("(\\d+)(ms|s|m|h|d)");

    private TcsConfigLoader() {}

    public static VersionGapConfig versionGap() {
        JsonNode root = read("tcs-config/version-gap.yml");
        JsonNode d = root.required("defaults");
        var defaults =
                new VersionGapConfig.Defaults(
                        d.required("versionGapTimeoutMs").asLong(),
                        d.required("maxHeldPerAllocation").asInt(),
                        VersionGapConfig.TimeoutAction.valueOf(d.required("onTimeout").asText()));
        Map<String, VersionGapConfig.BookOverride> books = new LinkedHashMap<>();
        root.path("books")
                .properties()
                .forEach(
                        e ->
                                books.put(
                                        e.getKey(),
                                        new VersionGapConfig.BookOverride(
                                                e.getValue().hasNonNull("versionGapTimeoutMs")
                                                        ? e.getValue()
                                                                .get("versionGapTimeoutMs")
                                                                .asLong()
                                                        : null)));
        return new VersionGapConfig(defaults, books);
    }

    public static IngressConfig ingress() {
        JsonNode root = read("tcs-config/ingress.yml");
        JsonNode s = root.required("solace");
        JsonNode r = root.required("refdataRetry");
        List<Long> backoff = new ArrayList<>();
        r.required("backoffMs").forEach(n -> backoff.add(n.asLong()));
        return new IngressConfig(
                new IngressConfig.Solace(
                        s.required("queue").asText(),
                        s.required("partitions").asInt(),
                        s.required("prefetch").asInt()),
                new IngressConfig.RefdataRetry(r.required("maxAttempts").asInt(), backoff),
                new IngressConfig.GapDetection(
                        root.required("gapDetection").required("useKeySequence").asBoolean()));
    }

    public static BusinessValidationConfig businessValidation() {
        JsonNode root = read("tcs-config/business-validation.yml");
        JsonNode s = root.required("structural");
        return new BusinessValidationConfig(
                stringList(root.required("mandatoryFields")),
                new BusinessValidationConfig.Structural(
                        s.path("spreadBpsNonNegative").asBoolean(true),
                        s.path("divPassthroughPercentRange").asBoolean(true)));
    }

    public static CachePolicyConfig cachePolicy() {
        JsonNode root = read("tcs-config/cache-policy.yml");
        Map<String, Map<String, CachePolicyConfig.FieldPolicy>> entities = new LinkedHashMap<>();
        root.required("entities")
                .properties()
                .forEach(
                        e -> {
                            JsonNode node = e.getValue();
                            Map<String, CachePolicyConfig.FieldPolicy> groups =
                                    new LinkedHashMap<>();
                            if (node.has("mode")) { // flat entity declaration
                                groups.put(CachePolicyConfig.DEFAULT_GROUP, fieldPolicy(node));
                            } else {
                                node.properties()
                                        .forEach(
                                                g ->
                                                        groups.put(
                                                                g.getKey(),
                                                                fieldPolicy(g.getValue())));
                            }
                            entities.put(e.getKey(), groups);
                        });
        return new CachePolicyConfig(entities);
    }

    public static PositionMatchKeyConfig positionMatchKey() {
        JsonNode root = read("tcs-config/position-match-key.yml");
        List<String> defaultFields = stringList(root.required("default").required("fields"));
        Map<String, PositionMatchKeyConfig.SystemPolicy> systems = new LinkedHashMap<>();
        root.required("systems")
                .properties()
                .forEach(
                        e -> {
                            JsonNode sys = e.getValue();
                            JsonNode matchKey = sys.required("matchKey");
                            List<String> fields =
                                    matchKey.isTextual() // "default" reference
                                            ? defaultFields
                                            : stringList(matchKey.required("fields"));
                            systems.put(
                                    e.getKey(),
                                    new PositionMatchKeyConfig.SystemPolicy(
                                            sys.required("explicitEventType").asBoolean(),
                                            PositionMatchKeyConfig.PositionLookup.valueOf(
                                                    sys.required("positionLookup").asText()),
                                            fields));
                        });
        return new PositionMatchKeyConfig(defaultFields, systems);
    }

    public static ParityManifestConfig parityManifest() {
        JsonNode root = read("tcs-config/parity-manifest.yml");
        ParityManifestConfig.Mode defaultMode =
                ParityManifestConfig.Mode.valueOf(root.required("defaults").required("mode").asText());
        Map<String, ParityManifestConfig.FieldPolicy> fields = new LinkedHashMap<>();
        root.path("fields")
                .properties()
                .forEach(
                        e -> {
                            JsonNode node = e.getValue();
                            ParityManifestConfig.Mode mode =
                                    ParityManifestConfig.Mode.valueOf(node.required("mode").asText());
                            BigDecimal absolute =
                                    node.hasNonNull("absolute")
                                            ? new BigDecimal(node.get("absolute").asText())
                                            : null;
                            fields.put(e.getKey(), new ParityManifestConfig.FieldPolicy(mode, absolute));
                        });
        return new ParityManifestConfig(defaultMode, fields);
    }

    public static CutoverPolicyConfig cutoverPolicy() {
        JsonNode root = read("tcs-config/cutover-policy.yml");
        boolean shadowMode = root.required("defaults").required("shadowMode").asBoolean();
        JsonNode dual = root.required("dualPublish");
        Map<String, Boolean> dualDefault = readTargetFlags(dual.required("default"));
        Map<String, Map<String, Boolean>> dualBooks = new LinkedHashMap<>();
        dual.path("books")
                .properties()
                .forEach(e -> dualBooks.put(e.getKey(), readTargetFlags(e.getValue())));
        JsonNode archive = root.required("archive");
        return new CutoverPolicyConfig(
                shadowMode,
                dualBooks,
                dualDefault,
                new CutoverPolicyConfig.ArchivePolicy(
                        archive.required("hotWindowMonths").asInt(),
                        archive.required("eligibilityDaysPastLifecycle").asInt()));
    }

    public static ApprovalWorkflowConfig approvalWorkflow() {
        JsonNode root = read("tcs-config/approval-workflow.yml");
        JsonNode stp = root.required("stp");
        return new ApprovalWorkflowConfig(
                Duration.ofMinutes(root.required("approvalTimeoutMinutes").asLong()),
                root.required("bulkMaxRows").asInt(),
                new ApprovalWorkflowConfig.StpPolicy(
                        Set.copyOf(stringList(stp.required("sources"))),
                        Set.copyOf(stringList(stp.required("initiators")))));
    }

    public static RoutingRulesConfig routingRules() {
        JsonNode root = read("tcs-config/routing-rules.yml");
        List<RoutingRulesConfig.Rule> rules = new ArrayList<>();
        root.required("rules")
                .forEach(
                        r -> {
                            Map<String, String> criteria = new LinkedHashMap<>();
                            r.path("criteria")
                                    .properties()
                                    .forEach(c -> criteria.put(c.getKey(), c.getValue().asText()));
                            rules.add(
                                    new RoutingRulesConfig.Rule(
                                            r.required("name").asText(),
                                            criteria,
                                            stringList(r.required("targets"))));
                        });
        Map<String, RoutingRulesConfig.Target> targets = new LinkedHashMap<>();
        root.required("targets")
                .properties()
                .forEach(
                        e -> {
                            JsonNode t = e.getValue();
                            targets.put(
                                    e.getKey(),
                                    new RoutingRulesConfig.Target(
                                            t.required("queue").asText(),
                                            t.required("awaitBusinessAck").asBoolean(),
                                            t.required("businessAckTimeoutMs").asLong(),
                                            t.required("maxAttempts").asInt(),
                                            t.path("requiresCrossRef").asBoolean(false)));
                        });
        return new RoutingRulesConfig(rules, targets);
    }

    private static CachePolicyConfig.FieldPolicy fieldPolicy(JsonNode node) {
        var mode = CachePolicyConfig.Mode.valueOf(node.required("mode").asText());
        Duration ttl = node.hasNonNull("ttl") ? parseTtl(node.get("ttl").asText()) : null;
        var invalidation =
                node.hasNonNull("invalidation")
                        ? CachePolicyConfig.Invalidation.valueOf(
                                node.get("invalidation").asText().toUpperCase(Locale.ROOT))
                        : CachePolicyConfig.Invalidation.NONE;
        return new CachePolicyConfig.FieldPolicy(mode, ttl, invalidation);
    }

    /** Parses spec-style TTLs: {@code 30s}, {@code 4h}, {@code 500ms}. */
    static Duration parseTtl(String text) {
        Matcher m = TTL.matcher(text.trim());
        if (!m.matches()) {
            throw new IllegalArgumentException("Unparseable ttl: " + text);
        }
        long amount = Long.parseLong(m.group(1));
        return switch (m.group(2)) {
            case "ms" -> Duration.ofMillis(amount);
            case "s" -> Duration.ofSeconds(amount);
            case "m" -> Duration.ofMinutes(amount);
            case "h" -> Duration.ofHours(amount);
            case "d" -> Duration.ofDays(amount);
            default -> throw new IllegalArgumentException("Unparseable ttl: " + text);
        };
    }

    private static Map<String, Boolean> readTargetFlags(JsonNode node) {
        Map<String, Boolean> flags = new LinkedHashMap<>();
        node.properties().forEach(e -> flags.put(e.getKey(), e.getValue().asBoolean()));
        return flags;
    }

    private static List<String> stringList(JsonNode array) {
        List<String> values = new ArrayList<>();
        array.forEach(n -> values.add(n.asText()));
        return values;
    }

    private static JsonNode read(String classpathResource) {
        try (InputStream in =
                TcsConfigLoader.class.getClassLoader().getResourceAsStream(classpathResource)) {
            if (in == null) {
                throw new IllegalStateException("Missing config resource: " + classpathResource);
            }
            return YAML.readTree(in);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read " + classpathResource, e);
        }
    }
}
