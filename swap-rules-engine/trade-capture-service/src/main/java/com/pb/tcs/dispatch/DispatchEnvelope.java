package com.pb.tcs.dispatch;

import com.pb.tcs.routing.EventTypeDeriver;
import com.pb.tcs.rules.SwapBlotter;

/**
 * Provisional outbound envelope (E10 / arch §15 — working assumption until System A/B confirm).
 * Published to the target queue named in the routing decision.
 */
public record DispatchEnvelope(
        String correlationId,
        String blockId,
        String allocationId,
        int version,
        String destinationId,
        String queue,
        EventTypeDeriver.EventType eventType,
        SwapBlotter blotter,
        String payloadJson) {}
