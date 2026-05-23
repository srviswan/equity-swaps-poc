package com.pb.swap.rules.admin.dedup;

import com.pb.swap.rules.core.model.Action;
import com.pb.swap.rules.core.model.ActionTemplate;
import com.pb.swap.rules.core.model.CriteriaFragment;
import com.pb.swap.rules.core.model.Criterion;
import com.pb.swap.rules.core.model.RuleDefinition;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.function.Function;

/**
 * Pure semantic canonicalisation. Two artifacts with the same canonical form are equivalent for
 * runtime purposes regardless of id/version/effective dates/metadata.
 *
 * <p>Used by {@link DuplicationGuard} for twin detection and by the snapshot scan for shadow
 * detection.
 */
public final class CanonicalForm {

    private CanonicalForm() {}

    /** Canonical key for a single criterion. */
    public static String of(Criterion c) {
        return c.field() + "|" + c.operator().name() + "|" + normaliseValue(c.value());
    }

    /** Canonical key for a single action (target path + value + override policy). */
    public static String of(Action a) {
        return a.targetPath()
                + "|"
                + normaliseValue(a.value())
                + "|"
                + (a.overridePolicy() == null ? "NEVER" : a.overridePolicy().name());
    }

    /** Canonical key for a rule, with criteria and actions flattened through fragments/templates. */
    public static String ruleCanonical(
            RuleDefinition r,
            Function<String, CriteriaFragment> fragLookup,
            Function<String, ActionTemplate> tplLookup) {
        TreeSet<String> crits = new TreeSet<>();
        for (Criterion c : nullToEmpty(r.criteria())) crits.add(of(c));
        for (String id : nullToEmpty(r.includes())) {
            CriteriaFragment f = fragLookup.apply(id);
            if (f != null) {
                for (Criterion c : nullToEmpty(f.criteria())) crits.add(of(c));
            }
        }
        TreeSet<String> acts = new TreeSet<>();
        for (Action a : nullToEmpty(r.actions())) acts.add(of(a));
        for (String id : nullToEmpty(r.apply())) {
            ActionTemplate t = tplLookup.apply(id);
            if (t != null) {
                for (Action a : nullToEmpty(t.actions())) acts.add(of(a));
            }
        }
        return r.category().name()
                + "::"
                + r.target().name()
                + "::C["
                + String.join(",", crits)
                + "]::A["
                + String.join(",", acts)
                + "]";
    }

    /** Flattened criteria set (used for shadow / subset detection). */
    public static List<String> flattenedCriteriaKeys(
            RuleDefinition r, Function<String, CriteriaFragment> fragLookup) {
        TreeSet<String> crits = new TreeSet<>();
        for (Criterion c : nullToEmpty(r.criteria())) crits.add(of(c));
        for (String id : nullToEmpty(r.includes())) {
            CriteriaFragment f = fragLookup.apply(id);
            if (f != null) {
                for (Criterion c : nullToEmpty(f.criteria())) crits.add(of(c));
            }
        }
        return new ArrayList<>(crits);
    }

    /** Flattened action target paths (used for shadow overlap detection). */
    public static List<String> flattenedActionPaths(
            RuleDefinition r, Function<String, ActionTemplate> tplLookup) {
        TreeSet<String> out = new TreeSet<>();
        for (Action a : nullToEmpty(r.actions())) out.add(a.targetPath());
        for (String id : nullToEmpty(r.apply())) {
            ActionTemplate t = tplLookup.apply(id);
            if (t != null) {
                for (Action a : nullToEmpty(t.actions())) out.add(a.targetPath());
            }
        }
        return new ArrayList<>(out);
    }

    /** Short 16-char hex fingerprint of a canonical string, suitable for UI badges. */
    public static String shortHash(String canonical) {
        try {
            byte[] digest =
                    MessageDigest.getInstance("SHA-256")
                            .digest(canonical.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(64);
            for (byte b : digest) sb.append(String.format(Locale.ROOT, "%02x", b));
            return sb.substring(0, 16);
        } catch (Exception e) {
            throw new IllegalStateException("SHA-256 unavailable", e);
        }
    }

    /** Canonical key for a fragment (sorted set of criterion keys). */
    public static String fragmentCanonical(CriteriaFragment f) {
        TreeSet<String> crits = new TreeSet<>();
        for (Criterion c : nullToEmpty(f.criteria())) crits.add(of(c));
        return "FRAG::C[" + String.join(",", crits) + "]";
    }

    /** Canonical key for an action template (target + sorted action set). */
    public static String templateCanonical(ActionTemplate t) {
        TreeSet<String> acts = new TreeSet<>();
        for (Action a : nullToEmpty(t.actions())) acts.add(of(a));
        return "TMPL::" + t.target().name() + "::A[" + String.join(",", acts) + "]";
    }

    private static String normaliseValue(Object v) {
        if (v == null) return "";
        if (v instanceof Number n) return n.toString();
        return v.toString();
    }

    private static <T> List<T> nullToEmpty(List<T> in) {
        return in == null ? List.of() : in;
    }
}
