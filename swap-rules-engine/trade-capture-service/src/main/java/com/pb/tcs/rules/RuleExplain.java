package com.pb.tcs.rules;

/**
 * One persisted line of the FR-207 explain trail: which rule version fired, where it wrote, and a
 * plain-language narrative for ops/trader support. {@code ruleId} is {@code UNRESOLVED} for
 * targets no rule matched.
 */
public record RuleExplain(
        int seq,
        String ruleId,
        int ruleVersion,
        String category,
        String target,
        String narrative) {}
