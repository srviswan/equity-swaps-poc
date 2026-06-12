package com.pb.swap.rules.admin.changeset;

import com.pb.swap.rules.admin.service.PublishService;
import com.pb.swap.rules.admin.service.SnapshotConflictDetector;
import com.pb.swap.rules.core.compile.RuleCompiler;
import com.pb.swap.rules.core.model.ActionTemplate;
import com.pb.swap.rules.core.model.CriteriaFragment;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.model.RuleStatus;
import com.pb.swap.rules.core.snapshot.RuleSnapshot;
import com.pb.swap.rules.store.entity.RuleDefinitionEntity;
import com.pb.swap.rules.store.entity.RuleDefinitionId;
import com.pb.swap.rules.store.mapper.RuleJsonMapper;
import com.pb.swap.rules.store.repo.RuleDefinitionRepository;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** FR-508 atomic changeset publish: persist all edits then one snapshot (D24). */
@Service
public class ChangesetPublishService {

    private final RuleDefinitionRepository ruleRepo;
    private final PublishService publishService;
    private final RuleCompiler compiler;
    private final RuleJsonMapper mapper = new RuleJsonMapper();

    public ChangesetPublishService(
            RuleDefinitionRepository ruleRepo, PublishService publishService, RuleCompiler compiler) {
        this.ruleRepo = ruleRepo;
        this.publishService = publishService;
        this.compiler = compiler;
    }

    @Transactional
    public PublishResult publish(
            RuleChangeset changeset,
            List<RuleDefinition> baseRules,
            List<ActionTemplate> templates,
            List<CriteriaFragment> fragments,
            LocalDate asOf)
            throws Exception {
        List<RuleDefinition> projected = ChangesetMerger.merge(baseRules, changeset);
        Optional<String> conflict =
                SnapshotConflictDetector.detect(compiler, projected, templates, fragments, asOf);
        if (conflict.isPresent()) {
            changeset.markRejected();
            return PublishResult.blocked(conflict.get());
        }
        for (RuleDefinition rule : projected) {
            if (isTouched(changeset, rule)) {
                persistRule(asPublished(rule));
            }
        }
        RuleSnapshot snapshot = publishService.publish(asOf);
        changeset.markPublished();
        return PublishResult.success(snapshot.snapshotId(), snapshot.version(), projected.size());
    }

    private void persistRule(RuleDefinition rule) throws Exception {
        RuleDefinitionEntity entity = new RuleDefinitionEntity();
        entity.setId(new RuleDefinitionId(rule.id(), rule.version()));
        entity.setCategory(rule.category().name());
        entity.setTarget(rule.target().name());
        entity.setEffectiveFrom(
                rule.effectiveFrom() != null ? rule.effectiveFrom() : LocalDate.now());
        entity.setEffectiveTo(rule.effectiveTo());
        entity.setEnabled(rule.enabled());
        entity.setEvaluationMode(
                rule.evaluationMode() != null ? rule.evaluationMode().name() : null);
        entity.setSpecificityBoost(
                rule.specificityBoost() != null
                        ? java.math.BigDecimal.valueOf(rule.specificityBoost())
                        : null);
        entity.setBody(mapper.toJson(rule));
        entity.setStatus(RuleStatus.PUBLISHED.name());
        entity.setCreatedAt(Instant.now());
        ruleRepo.save(entity);
    }

    private static RuleDefinition asPublished(RuleDefinition rule) {
        return new RuleDefinition(
                rule.id(),
                rule.version(),
                rule.name(),
                rule.category(),
                rule.target(),
                rule.priority(),
                rule.enabled(),
                rule.effectiveFrom(),
                rule.effectiveTo(),
                rule.evaluationMode(),
                rule.specificityBoost(),
                RuleStatus.PUBLISHED,
                rule.criteria(),
                rule.includes(),
                rule.apply(),
                rule.actions(),
                rule.overrides(),
                rule.metadata());
    }

    private static boolean isTouched(RuleChangeset changeset, RuleDefinition rule) {
        return changeset.changes().stream()
                .anyMatch(
                        c ->
                                (c.operation() == RuleChange.Operation.CLONE_RULE
                                                && rule.id().equals(c.payload().cloneTargetId()))
                                        || (c.ruleId() != null
                                                && c.ruleId().equals(rule.id())
                                                && c.version() == rule.version())
                                        || (c.operation() == RuleChange.Operation.UPSERT_RULE
                                                && c.payload().rule() != null
                                                && c.payload().rule().id().equals(rule.id())
                                                && c.payload().rule().version() == rule.version()));
    }

    public record PublishResult(
            boolean success, String snapshotId, String snapshotVersion, int rulesTouched, String reason) {

        static PublishResult success(String snapshotId, String version, int rulesTouched) {
            return new PublishResult(true, snapshotId, version, rulesTouched, null);
        }

        static PublishResult blocked(String reason) {
            return new PublishResult(false, null, null, 0, reason);
        }
    }
}
