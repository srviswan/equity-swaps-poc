package com.pb.tcs.crossref;

import com.pb.tcs.routing.EventTypeDeriver;
import java.time.Instant;
import java.util.List;

/** Published to {@code tcs/crossref/out/{system}/v1} (arch §15.4). */
public record CrossRefPushMessage(
        String blockId,
        String allocationId,
        int version,
        String toSystem,
        String fromSystem,
        String swapRef,
        List<LotRef> lotRefs,
        EventTypeDeriver.EventType eventType,
        Instant sentAt) {

    public record LotRef(String lotId, String action, long qty) {}

    public String correlationId() {
        return blockId + "/" + allocationId + "/" + version;
    }
}
