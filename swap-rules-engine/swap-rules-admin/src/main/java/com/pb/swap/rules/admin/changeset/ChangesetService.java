package com.pb.swap.rules.admin.changeset;

import com.pb.swap.rules.admin.service.SimulationService;
import com.pb.swap.rules.core.model.ActionTemplate;
import com.pb.swap.rules.core.model.CriteriaFragment;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.store.mapper.RuleJsonMapper;
import com.pb.swap.rules.store.repo.ActionTemplateRepository;
import com.pb.swap.rules.store.repo.CriteriaFragmentRepository;
import com.pb.swap.rules.store.repo.RuleDefinitionRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/** Orchestrates changeset lifecycle (FR-507/508). */
@Service
public class ChangesetService {

    private final ChangesetStore store;
    private final BulkEditService bulkEditService;
    private final ChangesetImportExportService importExportService;
    private final ChangesetSimulationService simulationService;
    private final ChangesetPublishService publishService;
    private final RuleDefinitionRepository ruleRepo;
    private final ActionTemplateRepository templateRepo;
    private final CriteriaFragmentRepository fragmentRepo;
    private final RuleJsonMapper mapper = new RuleJsonMapper();

    public ChangesetService(
            ChangesetStore store,
            BulkEditService bulkEditService,
            ChangesetImportExportService importExportService,
            ChangesetSimulationService simulationService,
            ChangesetPublishService publishService,
            RuleDefinitionRepository ruleRepo,
            ActionTemplateRepository templateRepo,
            CriteriaFragmentRepository fragmentRepo) {
        this.store = store;
        this.bulkEditService = bulkEditService;
        this.importExportService = importExportService;
        this.simulationService = simulationService;
        this.publishService = publishService;
        this.ruleRepo = ruleRepo;
        this.templateRepo = templateRepo;
        this.fragmentRepo = fragmentRepo;
    }

    public RuleChangeset create(String name, String author) {
        return store.save(new RuleChangeset(name, author));
    }

    public RuleChangeset bulkEdit(String changesetId, BulkEditService.BulkEditRequest request) {
        RuleChangeset changeset = require(changesetId);
        bulkEditService.apply(changeset, request, loadAllRules());
        return store.save(changeset);
    }

    public ChangesetSimulationService.SimulationReport simulate(
            String changesetId, List<RawHedgeTrade> samples) {
        RuleChangeset changeset = require(changesetId);
        ChangesetSimulationService.SimulationReport report =
                simulationService.simulate(
                        changeset,
                        loadPublishedRules(),
                        loadTemplates(),
                        loadFragments(),
                        samples);
        store.save(changeset);
        return report;
    }

    public ChangesetPublishService.PublishResult publish(String changesetId, LocalDate asOf)
            throws Exception {
        RuleChangeset changeset = require(changesetId);
        ChangesetPublishService.PublishResult result =
                publishService.publish(
                        changeset,
                        loadPublishedRules(),
                        loadTemplates(),
                        loadFragments(),
                        asOf != null ? asOf : LocalDate.now());
        store.save(changeset);
        return result;
    }

    public RuleChangeset importYaml(String yaml, String author) throws Exception {
        RuleChangeset changeset = importExportService.importYaml(yaml, author);
        return store.save(changeset);
    }

    public String exportYaml(String changesetId) throws Exception {
        return importExportService.exportYaml(require(changesetId));
    }

    public RuleChangeset get(String changesetId) {
        return require(changesetId);
    }

    private RuleChangeset require(String id) {
        return store.findById(id).orElseThrow(() -> new IllegalArgumentException("unknown changeset " + id));
    }

    private List<RuleDefinition> loadPublishedRules() {
        List<RuleDefinition> rules = new ArrayList<>();
        for (var entity : ruleRepo.findPublished()) {
            try {
                rules.add(mapper.toRule(entity));
            } catch (Exception ignored) {
                // skip malformed
            }
        }
        return rules;
    }

    private List<RuleDefinition> loadAllRules() {
        List<RuleDefinition> rules = new ArrayList<>();
        for (var entity : ruleRepo.findAll()) {
            try {
                rules.add(mapper.toRule(entity));
            } catch (Exception ignored) {
                // skip malformed
            }
        }
        return rules;
    }

    private List<ActionTemplate> loadTemplates() {
        List<ActionTemplate> out = new ArrayList<>();
        for (var entity : templateRepo.findAll()) {
            try {
                out.add(mapper.toTemplate(entity));
            } catch (Exception ignored) {
                // skip
            }
        }
        return out;
    }

    private List<CriteriaFragment> loadFragments() {
        List<CriteriaFragment> out = new ArrayList<>();
        for (var entity : fragmentRepo.findAll()) {
            try {
                out.add(mapper.toFragment(entity));
            } catch (Exception ignored) {
                // skip
            }
        }
        return out;
    }
}
