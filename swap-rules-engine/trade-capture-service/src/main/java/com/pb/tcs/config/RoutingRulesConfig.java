package com.pb.tcs.config;

import java.util.List;
import java.util.Map;

/** Typed view of {@code tcs-config/routing-rules.yml} (D10): first match wins, top-down. */
public record RoutingRulesConfig(List<Rule> rules, Map<String, Target> targets) {

    public record Rule(String name, Map<String, String> criteria, List<String> targets) {}

    public record Target(
            String queue,
            boolean awaitBusinessAck,
            long businessAckTimeoutMs,
            int maxAttempts,
            boolean requiresCrossRef) {}
}
