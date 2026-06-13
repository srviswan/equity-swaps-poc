package com.pb.tcs.routing;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;

/**
 * One persisted row of stage-7 output (arch §5): which target receives the trade, on which
 * queue, typed with which business event, and — for lookup targets — the match key and snapshot
 * watermark that justified the type (audit: "why was this an UNWIND?").
 */
public record RoutingDecision(
        String correlationId,
        LocalDate tradeDate,
        String ruleName,
        String targetId,
        String queue,
        EventTypeDeriver.EventType eventType,
        Map<String, String> matchKey, // empty for no-lookup targets
        Instant positionAsOf) {} // null when no lookup performed
