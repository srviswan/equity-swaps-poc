package com.pb.swap.rules.store.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pb.swap.rules.core.model.ActionTemplate;
import com.pb.swap.rules.core.model.CriteriaFragment;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.store.entity.ActionTemplateEntity;
import com.pb.swap.rules.store.entity.CriteriaFragmentEntity;
import com.pb.swap.rules.store.entity.RuleDefinitionEntity;
import java.math.BigDecimal;

public final class RuleJsonMapper {
    private final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public RuleDefinition toRule(RuleDefinitionEntity entity) throws JsonProcessingException {
        RuleDefinitionBody body = mapper.readValue(entity.getBody(), RuleDefinitionBody.class);
        return new RuleDefinition(
                entity.getId().getId(),
                entity.getId().getVersion(),
                body.name(),
                com.pb.swap.rules.core.model.RuleCategory.valueOf(entity.getCategory()),
                com.pb.swap.rules.core.model.EnrichmentTarget.valueOf(entity.getTarget()),
                body.priority(),
                entity.isEnabled(),
                entity.getEffectiveFrom(),
                entity.getEffectiveTo(),
                body.evaluationMode() != null
                        ? com.pb.swap.rules.core.model.EvaluationMode.valueOf(body.evaluationMode())
                        : null,
                entity.getSpecificityBoost() != null ? entity.getSpecificityBoost().doubleValue() : null,
                com.pb.swap.rules.core.model.RuleStatus.valueOf(entity.getStatus()),
                body.criteria(),
                body.includes(),
                body.apply(),
                body.actions(),
                body.overrides(),
                body.metadata());
    }

    public ActionTemplate toTemplate(ActionTemplateEntity entity) throws JsonProcessingException {
        TemplateBody body = mapper.readValue(entity.getBody(), TemplateBody.class);
        return new ActionTemplate(
                entity.getId().getId(),
                entity.getId().getVersion(),
                com.pb.swap.rules.core.model.EnrichmentTarget.valueOf(entity.getTarget()),
                com.pb.swap.rules.core.model.RuleStatus.valueOf(entity.getStatus()),
                body.actions(),
                body.metadata());
    }

    public CriteriaFragment toFragment(CriteriaFragmentEntity entity) throws JsonProcessingException {
        FragmentBody body = mapper.readValue(entity.getBody(), FragmentBody.class);
        return new CriteriaFragment(
                entity.getId().getId(),
                entity.getId().getVersion(),
                com.pb.swap.rules.core.model.RuleStatus.valueOf(entity.getStatus()),
                body.criteria(),
                body.metadata());
    }

    public String toJson(RuleDefinition rule) throws JsonProcessingException {
        RuleDefinitionBody body =
                new RuleDefinitionBody(
                        rule.name(),
                        rule.priority(),
                        rule.evaluationMode() != null ? rule.evaluationMode().name() : null,
                        rule.criteria(),
                        rule.includes(),
                        rule.apply(),
                        rule.actions(),
                        rule.overrides(),
                        rule.metadata());
        return mapper.writeValueAsString(body);
    }

    public record RuleDefinitionBody(
            String name,
            Integer priority,
            String evaluationMode,
            java.util.List<com.pb.swap.rules.core.model.Criterion> criteria,
            java.util.List<String> includes,
            java.util.List<String> apply,
            java.util.List<com.pb.swap.rules.core.model.Action> actions,
            java.util.Map<String, Object> overrides,
            java.util.Map<String, Object> metadata) {}

    public record TemplateBody(
            java.util.List<com.pb.swap.rules.core.model.Action> actions,
            java.util.Map<String, Object> metadata) {}

    public record FragmentBody(
            java.util.List<com.pb.swap.rules.core.model.Criterion> criteria,
            java.util.Map<String, Object> metadata) {}

    public com.pb.swap.rules.core.model.RawHedgeTrade readTrade(Object tradeObj)
            throws JsonProcessingException {
        return mapper.convertValue(tradeObj, com.pb.swap.rules.core.model.RawHedgeTrade.class);
    }
}
