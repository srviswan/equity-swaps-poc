package com.pb.tcs.routing;

import com.pb.tcs.config.RoutingRulesConfig;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * FR-304: matches {@code routing-rules.yml} rules top-down, first match wins. Criteria are
 * dimension → pattern pairs; patterns support {@code *} globs ({@code EQ_US*}). A rule with empty
 * criteria is the catch-all. Dimensions are open-ended — they resolve against the
 * {@link RoutingContext} map, so new dimensions need no code change.
 */
public final class RoutingEngine {

    /** The matched rule plus resolved per-target policies. */
    public record Route(String ruleName, List<String> targets) {}

    private final RoutingRulesConfig config;

    public RoutingEngine(RoutingRulesConfig config) {
        this.config = config;
    }

    /**
     * @throws IllegalStateException if no rule matches (config must end with a catch-all)
     */
    public Route route(RoutingContext context) {
        for (RoutingRulesConfig.Rule rule : config.rules()) {
            if (matches(rule.criteria(), context)) {
                return new Route(rule.name(), rule.targets());
            }
        }
        throw new IllegalStateException(
                "No routing rule matched and no catch-all configured: " + context.dimensions());
    }

    public RoutingRulesConfig.Target target(String targetId) {
        RoutingRulesConfig.Target target = config.targets().get(targetId);
        if (target == null) {
            throw new IllegalStateException("Routing target not configured: " + targetId);
        }
        return target;
    }

    private static boolean matches(Map<String, String> criteria, RoutingContext context) {
        for (var criterion : criteria.entrySet()) {
            String actual = context.get(criterion.getKey());
            if (actual == null || !globMatches(criterion.getValue(), actual)) {
                return false;
            }
        }
        return true;
    }

    static boolean globMatches(String pattern, String value) {
        if (!pattern.contains("*")) {
            return pattern.equals(value);
        }
        String regex = ("\\Q" + pattern.replace("*", "\\E.*\\Q") + "\\E");
        return Pattern.matches(regex, value);
    }
}
