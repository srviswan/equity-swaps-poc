package com.pb.swap.rules.admin.changeset;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.model.RuleStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/** FR-507 CSV/YAML import/export for draft changesets. */
@Service
public final class ChangesetImportExportService {

    private static final ObjectMapper YAML =
            new ObjectMapper(new YAMLFactory()).registerModule(new JavaTimeModule());

    public RuleChangeset importYaml(String yaml, String author) throws IOException {
        JsonNode root = YAML.readTree(yaml);
        String name = root.path("name").asText("imported-changeset");
        RuleChangeset changeset = new RuleChangeset(name, author);
        if (root.has("changes")) {
            for (JsonNode n : root.get("changes")) {
                changeset.addChange(parseChange(n));
            }
        }
        if (root.has("rules")) {
            for (JsonNode n : root.get("rules")) {
                RuleDefinition rule = YAML.treeToValue(n, RuleDefinition.class);
                changeset.addChange(
                        new RuleChange(
                                RuleChange.Operation.UPSERT_RULE,
                                rule.id(),
                                rule.version(),
                                new RuleChange.Payload(rule, null, null, null, null, null)));
            }
        }
        return changeset;
    }

    public String exportYaml(RuleChangeset changeset) throws IOException {
        List<RuleDefinition> rules = new ArrayList<>();
        for (RuleChange change : changeset.changes()) {
            if (change.operation() == RuleChange.Operation.UPSERT_RULE
                    && change.payload().rule() != null) {
                rules.add(change.payload().rule());
            }
        }
        var doc =
                new java.util.LinkedHashMap<String, Object>();
        doc.put("name", changeset.name());
        doc.put("id", changeset.id());
        doc.put("status", changeset.status().name());
        doc.put("rules", rules);
        return YAML.writerWithDefaultPrettyPrinter().writeValueAsString(doc);
    }

    private static RuleChange parseChange(JsonNode n) throws IOException {
        RuleChange.Operation op = RuleChange.Operation.valueOf(n.required("operation").asText());
        String ruleId = n.path("ruleId").asText(null);
        int version = n.path("version").asInt(1);
        RuleDefinition rule =
                n.has("rule") ? YAML.treeToValue(n.get("rule"), RuleDefinition.class) : null;
        return new RuleChange(
                op,
                ruleId,
                version,
                new RuleChange.Payload(
                        rule,
                        n.has("enabled") ? n.get("enabled").asBoolean() : null,
                        n.has("priority") ? n.get("priority").asInt() : null,
                        n.has("effectiveFrom")
                                ? java.time.LocalDate.parse(n.get("effectiveFrom").asText())
                                : null,
                        n.has("effectiveTo")
                                ? java.time.LocalDate.parse(n.get("effectiveTo").asText())
                                : null,
                        n.path("cloneTargetId").asText(null)));
    }
}
