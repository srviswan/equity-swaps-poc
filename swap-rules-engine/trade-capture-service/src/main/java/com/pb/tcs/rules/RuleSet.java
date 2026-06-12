package com.pb.tcs.rules;

import com.pb.swap.rules.core.model.ActionTemplate;
import com.pb.swap.rules.core.model.CriteriaFragment;
import com.pb.swap.rules.core.model.RuleDefinition;
import java.util.List;

/** Everything the compiler needs for one full-range snapshot (FR-204/D7). */
public record RuleSet(
        List<RuleDefinition> rules,
        List<ActionTemplate> templates,
        List<CriteriaFragment> fragments) {

    public RuleSet {
        rules = List.copyOf(rules);
        templates = List.copyOf(templates);
        fragments = List.copyOf(fragments);
    }
}
