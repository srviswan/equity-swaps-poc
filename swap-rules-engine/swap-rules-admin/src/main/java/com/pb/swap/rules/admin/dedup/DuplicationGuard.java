package com.pb.swap.rules.admin.dedup;

import com.pb.swap.rules.admin.dedup.DuplicationReport.Finding;
import com.pb.swap.rules.admin.dedup.DuplicationReport.Severity;
import com.pb.swap.rules.core.model.Action;
import com.pb.swap.rules.core.model.ActionTemplate;
import com.pb.swap.rules.core.model.CriteriaFragment;
import com.pb.swap.rules.core.model.Criterion;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.store.entity.ActionTemplateEntity;
import com.pb.swap.rules.store.entity.CriteriaFragmentEntity;
import com.pb.swap.rules.store.entity.RuleDefinitionEntity;
import com.pb.swap.rules.store.mapper.RuleJsonMapper;
import com.pb.swap.rules.store.repo.ActionTemplateRepository;
import com.pb.swap.rules.store.repo.CriteriaFragmentRepository;
import com.pb.swap.rules.store.repo.RuleDefinitionRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.stereotype.Service;

/**
 * Multi-class duplication inspector for rules, fragments, and templates.
 *
 * <p>Findings fall into three buckets:
 *
 * <ul>
 *   <li>{@code INTRA_*} (ERROR) — two entries inside the same artifact collide on key.
 *   <li>{@code REDUNDANT_*} (WARNING) — an inline entry duplicates one supplied by a fragment /
 *       template the rule already composes.
 *   <li>{@code EXACT_TWIN} (ERROR) — another artifact with identical canonical form already
 *       exists in the database.
 * </ul>
 *
 * <p>The snapshot scan adds {@code SOFT_SHADOW} findings (WARNING) when one published rule fully
 * subsumes another within the same bucket.
 */
@Service
public class DuplicationGuard {

    private final RuleDefinitionRepository ruleRepo;
    private final CriteriaFragmentRepository fragmentRepo;
    private final ActionTemplateRepository templateRepo;
    private final RuleJsonMapper mapper = new RuleJsonMapper();

    public DuplicationGuard(
            RuleDefinitionRepository ruleRepo,
            CriteriaFragmentRepository fragmentRepo,
            ActionTemplateRepository templateRepo) {
        this.ruleRepo = ruleRepo;
        this.fragmentRepo = fragmentRepo;
        this.templateRepo = templateRepo;
    }

    // ====================== Public API ======================

    public DuplicationReport inspectRule(RuleDefinition draft) {
        Map<String, CriteriaFragment> fragments = loadFragments();
        Map<String, ActionTemplate> templates = loadTemplates();
        return inspectRule(draft, fragments, templates, loadAllRulesExcept(draft.id(), draft.version()));
    }

    public DuplicationReport inspectFragment(CriteriaFragment draft) {
        List<Finding> findings = new ArrayList<>();
        // intra-fragment duplicates
        Set<String> seen = new HashSet<>();
        List<Integer> dupes = new ArrayList<>();
        if (draft.criteria() != null) {
            for (int i = 0; i < draft.criteria().size(); i++) {
                String key = CanonicalForm.of(draft.criteria().get(i));
                if (!seen.add(key)) dupes.add(i);
            }
        }
        if (!dupes.isEmpty()) {
            findings.add(
                    new Finding(
                            "INTRA_FRAGMENT_DUPLICATE",
                            Severity.ERROR,
                            "Fragment has " + dupes.size() + " duplicate criterion row(s).",
                            "Remove the duplicate rows; each criterion should be unique within a fragment.",
                            dupes,
                            null,
                            null));
        }
        // exact twin
        String canonical = CanonicalForm.fragmentCanonical(draft);
        for (CriteriaFragment other : loadAllFragmentsExcept(draft.id(), draft.version())) {
            if (CanonicalForm.fragmentCanonical(other).equals(canonical)) {
                findings.add(
                        new Finding(
                                "EXACT_TWIN",
                                Severity.ERROR,
                                "Fragment is semantically identical to " + other.id() + " v" + other.version() + ".",
                                "Reuse " + other.id() + " in your rule's includes instead of creating a duplicate.",
                                null,
                                null,
                                other.id() + " v" + other.version()));
                break;
            }
        }
        return finalise(findings, CanonicalForm.shortHash(canonical));
    }

    public DuplicationReport inspectTemplate(ActionTemplate draft) {
        List<Finding> findings = new ArrayList<>();
        // intra-template duplicates (by target path)
        Set<String> seen = new HashSet<>();
        List<Integer> dupes = new ArrayList<>();
        if (draft.actions() != null) {
            for (int i = 0; i < draft.actions().size(); i++) {
                String key = draft.actions().get(i).targetPath();
                if (!seen.add(key)) dupes.add(i);
            }
        }
        if (!dupes.isEmpty()) {
            findings.add(
                    new Finding(
                            "INTRA_TEMPLATE_DUPLICATE",
                            Severity.ERROR,
                            "Template assigns the same target path twice (" + dupes.size() + " collision(s)).",
                            "Each target path should be set at most once per template.",
                            null,
                            dupes,
                            null));
        }
        // exact twin
        String canonical = CanonicalForm.templateCanonical(draft);
        for (ActionTemplate other : loadAllTemplatesExcept(draft.id(), draft.version())) {
            if (CanonicalForm.templateCanonical(other).equals(canonical)) {
                findings.add(
                        new Finding(
                                "EXACT_TWIN",
                                Severity.ERROR,
                                "Template is semantically identical to " + other.id() + " v" + other.version() + ".",
                                "Apply " + other.id() + " from your rule instead.",
                                null,
                                null,
                                other.id() + " v" + other.version()));
                break;
            }
        }
        return finalise(findings, CanonicalForm.shortHash(canonical));
    }

    /** Snapshot-wide scan: returns soft-shadow findings + twin pairs across all published rules. */
    public List<Finding> scanSnapshot(List<RuleDefinition> rules) {
        Map<String, CriteriaFragment> fragments = loadFragments();
        Map<String, ActionTemplate> templates = loadTemplates();
        List<Finding> findings = new ArrayList<>();

        // bucket by category+target
        Map<String, List<RuleDefinition>> buckets = new HashMap<>();
        for (RuleDefinition r : rules) {
            String key = r.category().name() + "::" + r.target().name();
            buckets.computeIfAbsent(key, k -> new ArrayList<>()).add(r);
        }

        // twin detection (across buckets technically possible, but only within same canonical matters)
        Map<String, RuleDefinition> seen = new HashMap<>();
        for (RuleDefinition r : rules) {
            String canon = CanonicalForm.ruleCanonical(r, fragments::get, templates::get);
            RuleDefinition prior = seen.put(canon, r);
            if (prior != null) {
                findings.add(
                        new Finding(
                                "EXACT_TWIN",
                                Severity.ERROR,
                                "Rule " + r.id() + " v" + r.version()
                                        + " is semantically identical to " + prior.id() + " v" + prior.version()
                                        + ".",
                                "Retire one of them; runtime behaviour will be identical.",
                                null,
                                null,
                                prior.id() + " v" + prior.version()));
            }
        }

        // soft-shadow: same bucket, A's criteria ⊃ B's criteria and action paths overlap
        for (List<RuleDefinition> bucket : buckets.values()) {
            for (RuleDefinition a : bucket) {
                Set<String> aCrits =
                        new TreeSet<>(CanonicalForm.flattenedCriteriaKeys(a, fragments::get));
                Set<String> aActs =
                        new TreeSet<>(CanonicalForm.flattenedActionPaths(a, templates::get));
                for (RuleDefinition b : bucket) {
                    if (a == b || a.id().equals(b.id())) continue;
                    Set<String> bCrits =
                            new TreeSet<>(CanonicalForm.flattenedCriteriaKeys(b, fragments::get));
                    Set<String> bActs =
                            new TreeSet<>(CanonicalForm.flattenedActionPaths(b, templates::get));
                    if (bCrits.isEmpty() || aCrits.equals(bCrits)) continue;
                    if (aCrits.containsAll(bCrits) && !java.util.Collections.disjoint(aActs, bActs)) {
                        findings.add(
                                new Finding(
                                        "SOFT_SHADOW",
                                        Severity.WARNING,
                                        "Rule " + a.id() + " is a strict superset of " + b.id()
                                                + " and overlaps its action targets.",
                                        "Within "
                                                + a.category().name()
                                                + "/"
                                                + a.target().name()
                                                + ", "
                                                + a.id()
                                                + " effectively shadows "
                                                + b.id()
                                                + ". Confirm both are intended.",
                                        null,
                                        null,
                                        b.id() + " v" + b.version()));
                    }
                }
            }
        }
        return findings;
    }

    // ====================== Internals ======================

    DuplicationReport inspectRule(
            RuleDefinition draft,
            Map<String, CriteriaFragment> fragments,
            Map<String, ActionTemplate> templates,
            List<RuleDefinition> others) {
        List<Finding> findings = new ArrayList<>();

        // INTRA inline criterion dupes
        Set<String> seenC = new HashSet<>();
        List<Integer> dupeC = new ArrayList<>();
        if (draft.criteria() != null) {
            for (int i = 0; i < draft.criteria().size(); i++) {
                Criterion c = draft.criteria().get(i);
                if (c.field() == null || c.operator() == null) continue;
                String key = c.field() + "|" + c.operator().name();
                if (!seenC.add(key)) dupeC.add(i);
            }
        }
        if (!dupeC.isEmpty()) {
            findings.add(
                    new Finding(
                            "INTRA_RULE_DUPLICATE_CRITERION",
                            Severity.ERROR,
                            "Two inline criteria target the same (field, operator) pair.",
                            "Merge or remove the duplicate row(s); ambiguous criteria are rejected.",
                            dupeC,
                            null,
                            null));
        }

        // INTRA inline action dupes (by target path)
        Set<String> seenA = new HashSet<>();
        List<Integer> dupeA = new ArrayList<>();
        if (draft.actions() != null) {
            for (int i = 0; i < draft.actions().size(); i++) {
                Action a = draft.actions().get(i);
                if (a.targetPath() == null) continue;
                if (!seenA.add(a.targetPath())) dupeA.add(i);
            }
        }
        if (!dupeA.isEmpty()) {
            findings.add(
                    new Finding(
                            "INTRA_RULE_DUPLICATE_ACTION",
                            Severity.ERROR,
                            "Two inline actions target the same path.",
                            "Each target path should be set at most once per rule.",
                            null,
                            dupeA,
                            null));
        }

        // REDUNDANT inline criterion vs included fragments
        Set<String> fragCritKeys = new HashSet<>();
        if (draft.includes() != null) {
            for (String fid : draft.includes()) {
                CriteriaFragment f = fragments.get(fid);
                if (f == null || f.criteria() == null) continue;
                for (Criterion c : f.criteria()) fragCritKeys.add(CanonicalForm.of(c));
            }
        }
        List<Integer> redundantC = new ArrayList<>();
        if (draft.criteria() != null) {
            for (int i = 0; i < draft.criteria().size(); i++) {
                Criterion c = draft.criteria().get(i);
                if (c.field() == null || c.operator() == null) continue;
                if (fragCritKeys.contains(CanonicalForm.of(c))) redundantC.add(i);
            }
        }
        if (!redundantC.isEmpty()) {
            findings.add(
                    new Finding(
                            "REDUNDANT_CRITERION",
                            Severity.WARNING,
                            "Inline criterion already provided by an included fragment.",
                            "Delete the inline row; the fragment already enforces it.",
                            redundantC,
                            null,
                            null));
        }

        // REDUNDANT inline action vs applied templates
        Set<String> tmplPaths = new HashSet<>();
        if (draft.apply() != null) {
            for (String tid : draft.apply()) {
                ActionTemplate t = templates.get(tid);
                if (t == null || t.actions() == null) continue;
                for (Action a : t.actions()) tmplPaths.add(a.targetPath());
            }
        }
        List<Integer> redundantA = new ArrayList<>();
        if (draft.actions() != null) {
            for (int i = 0; i < draft.actions().size(); i++) {
                Action a = draft.actions().get(i);
                if (a.targetPath() != null && tmplPaths.contains(a.targetPath())) {
                    redundantA.add(i);
                }
            }
        }
        if (!redundantA.isEmpty()) {
            findings.add(
                    new Finding(
                            "REDUNDANT_ACTION",
                            Severity.WARNING,
                            "Inline action sets a target path already written by an applied template.",
                            "Either drop the inline action or remove the template from apply[].",
                            null,
                            redundantA,
                            null));
        }

        // EXACT TWIN vs other rules
        String canonical = CanonicalForm.ruleCanonical(draft, fragments::get, templates::get);
        for (RuleDefinition other : others) {
            String otherCanon = CanonicalForm.ruleCanonical(other, fragments::get, templates::get);
            if (otherCanon.equals(canonical)) {
                findings.add(
                        new Finding(
                                "EXACT_TWIN",
                                Severity.ERROR,
                                "Rule is semantically identical to " + other.id() + " v" + other.version() + ".",
                                "Change category, target, criteria, or actions — or retire the other rule.",
                                null,
                                null,
                                other.id() + " v" + other.version()));
                break;
            }
        }

        return finalise(findings, CanonicalForm.shortHash(canonical));
    }

    // ====================== Loaders ======================

    private Map<String, CriteriaFragment> loadFragments() {
        Map<String, CriteriaFragment> out = new HashMap<>();
        for (CriteriaFragmentEntity e : fragmentRepo.findAll()) {
            try {
                CriteriaFragment f = mapper.toFragment(e);
                out.put(f.id(), f);
            } catch (Exception ignored) {
                // skip malformed
            }
        }
        return out;
    }

    private Map<String, ActionTemplate> loadTemplates() {
        Map<String, ActionTemplate> out = new HashMap<>();
        for (ActionTemplateEntity e : templateRepo.findAll()) {
            try {
                ActionTemplate t = mapper.toTemplate(e);
                out.put(t.id(), t);
            } catch (Exception ignored) {
                // skip malformed
            }
        }
        return out;
    }

    private List<RuleDefinition> loadAllRulesExcept(String id, int version) {
        List<RuleDefinition> out = new ArrayList<>();
        for (RuleDefinitionEntity e : ruleRepo.findAll()) {
            if (e.getId().getId().equals(id) && e.getId().getVersion() == version) continue;
            try {
                out.add(mapper.toRule(e));
            } catch (Exception ignored) {
                // skip malformed
            }
        }
        return out;
    }

    private List<CriteriaFragment> loadAllFragmentsExcept(String id, int version) {
        List<CriteriaFragment> out = new ArrayList<>();
        for (CriteriaFragmentEntity e : fragmentRepo.findAll()) {
            if (e.getId().getId().equals(id) && e.getId().getVersion() == version) continue;
            try {
                out.add(mapper.toFragment(e));
            } catch (Exception ignored) {
                // skip malformed
            }
        }
        return out;
    }

    private List<ActionTemplate> loadAllTemplatesExcept(String id, int version) {
        List<ActionTemplate> out = new ArrayList<>();
        for (ActionTemplateEntity e : templateRepo.findAll()) {
            if (e.getId().getId().equals(id) && e.getId().getVersion() == version) continue;
            try {
                out.add(mapper.toTemplate(e));
            } catch (Exception ignored) {
                // skip malformed
            }
        }
        return out;
    }

    private static DuplicationReport finalise(List<Finding> findings, String hash) {
        Severity level = Severity.OK;
        for (Finding f : findings) {
            if (f.severity() == Severity.ERROR) {
                level = Severity.ERROR;
                break;
            }
            if (f.severity() == Severity.WARNING) level = Severity.WARNING;
        }
        return new DuplicationReport(level, hash, findings);
    }
}
