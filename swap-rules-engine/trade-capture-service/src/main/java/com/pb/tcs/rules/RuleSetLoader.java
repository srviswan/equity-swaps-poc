package com.pb.tcs.rules;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.pb.swap.rules.core.model.Action;
import com.pb.swap.rules.core.model.ActionTemplate;
import com.pb.swap.rules.core.model.ComparisonOperator;
import com.pb.swap.rules.core.model.CriteriaFragment;
import com.pb.swap.rules.core.model.Criterion;
import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.EvaluationMode;
import com.pb.swap.rules.core.model.OverridePolicy;
import com.pb.swap.rules.core.model.RuleCategory;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.model.RuleStatus;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Loads a {@link RuleSet} from YAML (interim rule distribution until the Rules Admin snapshot
 * feed lands — E-item). Mapping is hand-rolled in the {@code TcsConfigLoader} style so the file
 * format stays explicit and Jackson modules aren't needed for the core model's enums/dates.
 */
public final class RuleSetLoader {

    private static final ObjectMapper YAML = new ObjectMapper(new YAMLFactory());

    private RuleSetLoader() {}

    public static RuleSet fromClasspath(String resource) {
        try (InputStream in = RuleSetLoader.class.getClassLoader().getResourceAsStream(resource)) {
            if (in == null) {
                throw new IllegalStateException("Missing rule-set resource: " + resource);
            }
            return parse(YAML.readTree(in));
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read rule set " + resource, e);
        }
    }

    static RuleSet parse(JsonNode root) {
        List<RuleDefinition> rules = new ArrayList<>();
        root.path("rules").forEach(n -> rules.add(rule(n)));
        List<ActionTemplate> templates = new ArrayList<>();
        root.path("templates").forEach(n -> templates.add(template(n)));
        List<CriteriaFragment> fragments = new ArrayList<>();
        root.path("fragments").forEach(n -> fragments.add(fragment(n)));
        return new RuleSet(rules, templates, fragments);
    }

    private static RuleDefinition rule(JsonNode n) {
        List<Criterion> criteria = new ArrayList<>();
        n.path("criteria").forEach(c -> criteria.add(criterion(c)));
        List<Action> actions = new ArrayList<>();
        n.path("actions").forEach(a -> actions.add(action(a)));
        return new RuleDefinition(
                n.required("id").asText(),
                n.path("version").asInt(1),
                n.path("name").asText(n.required("id").asText()),
                RuleCategory.valueOf(n.required("category").asText()),
                EnrichmentTarget.valueOf(n.required("target").asText()),
                n.hasNonNull("priority") ? n.get("priority").asInt() : null,
                n.path("enabled").asBoolean(true),
                date(n, "effectiveFrom"),
                date(n, "effectiveTo"),
                n.hasNonNull("evaluationMode")
                        ? EvaluationMode.valueOf(n.get("evaluationMode").asText())
                        : null,
                n.hasNonNull("specificityBoost") ? n.get("specificityBoost").asDouble() : null,
                n.hasNonNull("status")
                        ? RuleStatus.valueOf(n.get("status").asText())
                        : RuleStatus.PUBLISHED,
                criteria,
                stringList(n.path("includes")),
                stringList(n.path("apply")),
                actions,
                objectMap(n.path("overrides")),
                objectMap(n.path("metadata")));
    }

    private static ActionTemplate template(JsonNode n) {
        List<Action> actions = new ArrayList<>();
        n.path("actions").forEach(a -> actions.add(action(a)));
        return new ActionTemplate(
                n.required("id").asText(),
                n.path("version").asInt(1),
                EnrichmentTarget.valueOf(n.required("target").asText()),
                n.hasNonNull("status")
                        ? RuleStatus.valueOf(n.get("status").asText())
                        : RuleStatus.PUBLISHED,
                actions,
                objectMap(n.path("metadata")));
    }

    private static CriteriaFragment fragment(JsonNode n) {
        List<Criterion> criteria = new ArrayList<>();
        n.path("criteria").forEach(c -> criteria.add(criterion(c)));
        return new CriteriaFragment(
                n.required("id").asText(),
                n.path("version").asInt(1),
                n.hasNonNull("status")
                        ? RuleStatus.valueOf(n.get("status").asText())
                        : RuleStatus.PUBLISHED,
                criteria,
                objectMap(n.path("metadata")));
    }

    private static Criterion criterion(JsonNode n) {
        return new Criterion(
                n.required("field").asText(),
                ComparisonOperator.valueOf(n.path("operator").asText("EQ")),
                scalar(n.get("value")),
                null);
    }

    private static Action action(JsonNode n) {
        return new Action(
                n.path("type").asText("SET_FIELD"),
                n.hasNonNull("targetPath") ? n.get("targetPath").asText() : null,
                scalar(n.get("value")),
                n.hasNonNull("overridePolicy")
                        ? OverridePolicy.valueOf(n.get("overridePolicy").asText())
                        : OverridePolicy.NEVER,
                n.hasNonNull("templateId") ? n.get("templateId").asText() : null,
                objectMap(n.path("parameters")));
    }

    private static LocalDate date(JsonNode n, String field) {
        return n.hasNonNull(field) ? LocalDate.parse(n.get(field).asText()) : null;
    }

    private static Object scalar(JsonNode n) {
        if (n == null || n.isNull()) {
            return null;
        }
        if (n.isArray()) {
            List<Object> values = new ArrayList<>();
            n.forEach(v -> values.add(scalar(v)));
            return values;
        }
        if (n.isBoolean()) {
            return n.asBoolean();
        }
        if (n.isIntegralNumber()) {
            return n.asLong();
        }
        if (n.isNumber()) {
            return n.decimalValue();
        }
        return n.asText();
    }

    private static List<String> stringList(JsonNode array) {
        if (array.isMissingNode() || array.isNull()) {
            return List.of();
        }
        List<String> values = new ArrayList<>();
        array.forEach(n -> values.add(n.asText()));
        return values;
    }

    private static Map<String, Object> objectMap(JsonNode node) {
        Map<String, Object> map = new LinkedHashMap<>();
        if (!node.isMissingNode() && !node.isNull()) {
            node.properties().forEach(e -> map.put(e.getKey(), scalar(e.getValue())));
        }
        return map;
    }
}
