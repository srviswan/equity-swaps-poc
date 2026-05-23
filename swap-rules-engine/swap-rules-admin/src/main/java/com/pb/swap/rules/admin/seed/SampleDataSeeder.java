package com.pb.swap.rules.admin.seed;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pb.swap.rules.admin.service.PublishService;
import com.pb.swap.rules.core.model.Action;
import com.pb.swap.rules.core.model.ActionTemplate;
import com.pb.swap.rules.core.model.ComparisonOperator;
import com.pb.swap.rules.core.model.CriteriaFragment;
import com.pb.swap.rules.core.model.Criterion;
import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.OverridePolicy;
import com.pb.swap.rules.core.model.RuleCategory;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.model.RuleStatus;
import com.pb.swap.rules.store.entity.ActionTemplateEntity;
import com.pb.swap.rules.store.entity.CriteriaFragmentEntity;
import com.pb.swap.rules.store.entity.RuleDefinitionEntity;
import com.pb.swap.rules.store.entity.RuleDefinitionId;
import com.pb.swap.rules.store.entity.TemplateId;
import com.pb.swap.rules.store.mapper.RuleJsonMapper;
import com.pb.swap.rules.store.repo.ActionTemplateRepository;
import com.pb.swap.rules.store.repo.CriteriaFragmentRepository;
import com.pb.swap.rules.store.repo.RuleDefinitionRepository;
import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/** Seeds a realistic equity-swap rule set on startup for demo. */
@Component
@ConditionalOnProperty(name = "swap-rules.seed.enabled", havingValue = "true", matchIfMissing = true)
public class SampleDataSeeder {
    private static final Logger log = LoggerFactory.getLogger(SampleDataSeeder.class);

    private final RuleDefinitionRepository ruleRepo;
    private final ActionTemplateRepository templateRepo;
    private final CriteriaFragmentRepository fragmentRepo;
    private final PublishService publishService;
    private final RuleJsonMapper mapper = new RuleJsonMapper();
    private final ObjectMapper json = new ObjectMapper();

    public SampleDataSeeder(
            RuleDefinitionRepository ruleRepo,
            ActionTemplateRepository templateRepo,
            CriteriaFragmentRepository fragmentRepo,
            PublishService publishService) {
        this.ruleRepo = ruleRepo;
        this.templateRepo = templateRepo;
        this.fragmentRepo = fragmentRepo;
        this.publishService = publishService;
    }

    @PostConstruct
    public void seed() throws Exception {
        if (ruleRepo.count() > 0) {
            log.info("Sample data already present (rules={}); skipping seed", ruleRepo.count());
            return;
        }
        log.info("Seeding sample equity-swap rules, templates, and fragments");
        seedFragments();
        seedTemplates();
        seedRules();
        publishService.publish(LocalDate.now());
        log.info("Seed complete; snapshot published");
    }

    private void seedFragments() throws Exception {
        saveFragment(
                "FRAG_EQ_SWAP_BOOK",
                List.of(new Criterion("book", ComparisonOperator.EQ, "EQ_SWAP", null)),
                Map.of("desc", "Equity swap book"));
        saveFragment(
                "FRAG_CCY_USD",
                List.of(new Criterion("currency", ComparisonOperator.EQ, "USD", null)),
                Map.of("desc", "USD currency"));
        saveFragment(
                "FRAG_CCY_EUR",
                List.of(new Criterion("currency", ComparisonOperator.EQ, "EUR", null)),
                Map.of("desc", "EUR currency"));
        saveFragment(
                "FRAG_TIER_1",
                List.of(new Criterion("clientTier", ComparisonOperator.EQ, "TIER_1", null)),
                Map.of("desc", "Tier-1 client"));
        saveFragment(
                "FRAG_MANUAL_SOURCE",
                List.of(new Criterion("source", ComparisonOperator.EQ, "MANUAL", null)),
                Map.of("desc", "Manual capture source"));
    }

    private void seedTemplates() throws Exception {
        saveTemplate(
                "TMPL_USD_FLOAT_ACT360",
                EnrichmentTarget.INTEREST_LEG,
                List.of(
                        Action.setField("interestLeg.dayCount", "ACT/360", OverridePolicy.NEVER),
                        Action.setField("interestLeg.rateType", "FLOAT", OverridePolicy.NEVER),
                        Action.setField(
                                "interestLeg.spreadBps", new BigDecimal("25"), OverridePolicy.NEVER)));
        saveTemplate(
                "TMPL_USD_FLOAT_ACT365",
                EnrichmentTarget.INTEREST_LEG,
                List.of(
                        Action.setField("interestLeg.dayCount", "ACT/365", OverridePolicy.ALWAYS),
                        Action.setField("interestLeg.rateType", "FLOAT", OverridePolicy.NEVER)));
        saveTemplate(
                "TMPL_EQUITY_TOTAL_RETURN",
                EnrichmentTarget.EQUITY_LEG,
                List.of(Action.setField("equityLeg.returnType", "TOTAL_RETURN", OverridePolicy.NEVER)));
        saveTemplate(
                "TMPL_SCHEDULE_MONTHLY",
                EnrichmentTarget.SCHEDULE,
                List.of(
                        Action.setField("schedule.paymentFrequency", "MONTHLY", OverridePolicy.NEVER)));
        saveTemplate(
                "TMPL_DIV_PASSTHROUGH_85",
                EnrichmentTarget.DIV_PASSTHROUGH,
                List.of(
                        Action.setField(
                                "divPassthrough.percent",
                                new BigDecimal("85"),
                                OverridePolicy.NEVER),
                        Action.setField("divPassthrough.timing", "PAYMENT_DATE", OverridePolicy.NEVER)));
        saveTemplate(
                "TMPL_WORKFLOW_MANUAL",
                EnrichmentTarget.WORKFLOW,
                List.of(
                        Action.setField(
                                "workflowStatus", "PENDING_APPROVAL", OverridePolicy.ALWAYS)));
        saveTemplate(
                "TMPL_WORKFLOW_AUTO",
                EnrichmentTarget.WORKFLOW,
                List.of(Action.setField("workflowStatus", "APPROVED", OverridePolicy.ALWAYS)));
        saveTemplate(
                "TMPL_ROUTE_DOWNSTREAM",
                EnrichmentTarget.ROUTING,
                List.of(
                        Action.setField(
                                "routingDestination", "PB_DOWNSTREAM", OverridePolicy.ALWAYS)));
    }

    private void seedRules() throws Exception {
        // ECONOMIC layered: more restrictive USD-tier1 wins over USD-broad
        saveRule(
                "ECON_USD_INTEREST_BROAD",
                "Default USD float interest",
                RuleCategory.ECONOMIC,
                EnrichmentTarget.INTEREST_LEG,
                100,
                List.of(),
                List.of("FRAG_EQ_SWAP_BOOK", "FRAG_CCY_USD"),
                List.of("TMPL_USD_FLOAT_ACT360"));
        saveRule(
                "ECON_USD_INTEREST_TIER1",
                "USD float interest - tier 1 override",
                RuleCategory.ECONOMIC,
                EnrichmentTarget.INTEREST_LEG,
                90,
                List.of(),
                List.of("FRAG_EQ_SWAP_BOOK", "FRAG_CCY_USD", "FRAG_TIER_1"),
                List.of("TMPL_USD_FLOAT_ACT365"));
        saveRule(
                "ECON_EUR_INTEREST",
                "EUR float interest",
                RuleCategory.ECONOMIC,
                EnrichmentTarget.INTEREST_LEG,
                100,
                List.of(),
                List.of("FRAG_EQ_SWAP_BOOK", "FRAG_CCY_EUR"),
                List.of("TMPL_USD_FLOAT_ACT365"));

        saveRule(
                "ECON_EQUITY_LEG",
                "Equity leg total return",
                RuleCategory.ECONOMIC,
                EnrichmentTarget.EQUITY_LEG,
                100,
                List.of(),
                List.of("FRAG_EQ_SWAP_BOOK"),
                List.of("TMPL_EQUITY_TOTAL_RETURN"));

        saveRule(
                "ECON_SCHEDULE_DEFAULT",
                "Monthly schedule",
                RuleCategory.ECONOMIC,
                EnrichmentTarget.SCHEDULE,
                100,
                List.of(),
                List.of("FRAG_EQ_SWAP_BOOK"),
                List.of("TMPL_SCHEDULE_MONTHLY"));

        saveRule(
                "ECON_DIV_PASSTHROUGH_USD",
                "USD dividend passthrough 85%",
                RuleCategory.ECONOMIC,
                EnrichmentTarget.DIV_PASSTHROUGH,
                100,
                List.of(),
                List.of("FRAG_EQ_SWAP_BOOK", "FRAG_CCY_USD"),
                List.of("TMPL_DIV_PASSTHROUGH_85"));

        // WORKFLOW first-match: manual source needs approval, otherwise auto
        saveRule(
                "WF_MANUAL_APPROVAL",
                "Manual capture requires approval",
                RuleCategory.WORKFLOW,
                EnrichmentTarget.WORKFLOW,
                50,
                List.of(),
                List.of("FRAG_MANUAL_SOURCE"),
                List.of("TMPL_WORKFLOW_MANUAL"));
        saveRule(
                "WF_AUTO_APPROVAL",
                "Auto-approve all other equity swaps",
                RuleCategory.WORKFLOW,
                EnrichmentTarget.WORKFLOW,
                100,
                List.of(),
                List.of("FRAG_EQ_SWAP_BOOK"),
                List.of("TMPL_WORKFLOW_AUTO"));

        // ROUTING first-match: send all equity swaps downstream
        saveRule(
                "ROUTE_DEFAULT",
                "Route to downstream",
                RuleCategory.ROUTING,
                EnrichmentTarget.ROUTING,
                100,
                List.of(),
                List.of("FRAG_EQ_SWAP_BOOK"),
                List.of("TMPL_ROUTE_DOWNSTREAM"));
    }

    private void saveFragment(String id, List<Criterion> criteria, Map<String, Object> metadata)
            throws Exception {
        if (fragmentRepo.findById(new TemplateId(id, 1)).isPresent()) return;
        CriteriaFragmentEntity e = new CriteriaFragmentEntity();
        e.setId(new TemplateId(id, 1));
        e.setStatus(RuleStatus.PUBLISHED.name());
        e.setBody(
                json.writeValueAsString(
                        new RuleJsonMapper.FragmentBody(criteria, metadata)));
        fragmentRepo.save(e);
    }

    private void saveTemplate(String id, EnrichmentTarget target, List<Action> actions) throws Exception {
        if (templateRepo.findById(new TemplateId(id, 1)).isPresent()) return;
        ActionTemplateEntity e = new ActionTemplateEntity();
        e.setId(new TemplateId(id, 1));
        e.setTarget(target.name());
        e.setStatus(RuleStatus.PUBLISHED.name());
        e.setBody(json.writeValueAsString(new RuleJsonMapper.TemplateBody(actions, Map.of())));
        templateRepo.save(e);
    }

    private void saveRule(
            String id,
            String name,
            RuleCategory category,
            EnrichmentTarget target,
            int priority,
            List<Criterion> inlineCriteria,
            List<String> includes,
            List<String> apply)
            throws Exception {
        RuleDefinition def =
                new RuleDefinition(
                        id,
                        1,
                        name,
                        category,
                        target,
                        priority,
                        true,
                        LocalDate.of(2020, 1, 1),
                        null,
                        null,
                        null,
                        RuleStatus.PUBLISHED,
                        inlineCriteria,
                        includes,
                        apply,
                        List.of(),
                        Map.of(),
                        Map.of());
        RuleDefinitionEntity entity = new RuleDefinitionEntity();
        entity.setId(new RuleDefinitionId(def.id(), def.version()));
        entity.setCategory(def.category().name());
        entity.setTarget(def.target().name());
        entity.setEffectiveFrom(def.effectiveFrom());
        entity.setEnabled(true);
        entity.setStatus(def.status().name());
        entity.setBody(mapper.toJson(def));
        entity.setCreatedAt(Instant.now());
        ruleRepo.save(entity);
    }
}
