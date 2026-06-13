package com.pb.tcs.dispatch;

import com.pb.tcs.routing.RoutingDecision;
import com.pb.tcs.rules.BlotterJson;
import com.pb.tcs.rules.SwapBlotter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HexFormat;
import java.util.LinkedHashMap;
import java.util.Map;

/** Builds the provisional downstream envelope from blotter + routing decision (stage 10 input). */
public final class DispatchEnvelopeBuilder {

    private DispatchEnvelopeBuilder() {}

    public static DispatchEnvelope build(SwapBlotter blotter, RoutingDecision decision) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(
                "correlation",
                Map.of(
                        "blockId", blotter.blockId(),
                        "allocationId", blotter.allocationId(),
                        "version", blotter.version()));
        body.put("systemId", decision.targetId());
        body.put("eventType", decision.eventType().name());
        body.put("queue", decision.queue());
        body.put("blotter", blotter);
        String json = BlotterJson.toJsonMap(body);
        return new DispatchEnvelope(
                blotter.correlationId(),
                blotter.blockId(),
                blotter.allocationId(),
                blotter.version(),
                decision.targetId(),
                decision.queue(),
                decision.eventType(),
                blotter,
                json);
    }

    public static String hash(DispatchEnvelope envelope) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(envelope.payloadJson().getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(md.digest()).substring(0, 16);
        } catch (Exception e) {
            return "unknown";
        }
    }
}
