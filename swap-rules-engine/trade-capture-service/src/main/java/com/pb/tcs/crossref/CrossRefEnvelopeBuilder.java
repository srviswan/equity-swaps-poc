package com.pb.tcs.crossref;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pb.tcs.dispatch.BusinessAckMessage;
import com.pb.tcs.rules.BlotterJson;
import java.util.List;
import java.util.stream.Collectors;

/** Builds {@link CrossRefPushMessage} payloads from persisted cross-ref rows (arch §15.4). */
public final class CrossRefEnvelopeBuilder {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private CrossRefEnvelopeBuilder() {}

    public static CrossRefPushMessage build(CrossRefRecord record) {
        String[] parts = record.correlationId().split("/", 3);
        if (parts.length != 3) {
            throw new IllegalStateException("invalid correlationId: " + record.correlationId());
        }
        return new CrossRefPushMessage(
                parts[0],
                parts[1],
                Integer.parseInt(parts[2]),
                record.toSystem(),
                record.fromSystem(),
                record.swapRef(),
                lotRefs(record.lotRefsJson()),
                record.eventType(),
                java.time.Instant.now());
    }

    static List<CrossRefPushMessage.LotRef> lotRefsFromAck(BusinessAckMessage message) {
        if (message.lotRefs() == null || message.lotRefs().isEmpty()) {
            return List.of();
        }
        return message.lotRefs().stream()
                .map(l -> new CrossRefPushMessage.LotRef(l.lotId(), l.action(), l.qty()))
                .toList();
    }

    static List<CrossRefPushMessage.LotRef> closedLotsForUnwind(
            List<CrossRefPushMessage.LotRef> lots, com.pb.tcs.routing.EventTypeDeriver.EventType eventType) {
        if (eventType != com.pb.tcs.routing.EventTypeDeriver.EventType.UNWIND) {
            return lots;
        }
        return lots.stream().filter(l -> "CLOSED".equalsIgnoreCase(l.action())).collect(Collectors.toList());
    }

    static String lotRefsJson(List<CrossRefPushMessage.LotRef> lots) {
        if (lots == null || lots.isEmpty()) {
            return null;
        }
        return BlotterJson.toJsonMap(lots);
    }

    static List<CrossRefPushMessage.LotRef> parseLotRefsJson(String json) {
        return lotRefs(json);
    }

    private static List<CrossRefPushMessage.LotRef> lotRefs(String json) {
        if (json == null || json.isBlank()) {
            return List.of();
        }
        try {
            return MAPPER.readValue(json, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("cross-ref lot_refs parse failed", e);
        }
    }
}
