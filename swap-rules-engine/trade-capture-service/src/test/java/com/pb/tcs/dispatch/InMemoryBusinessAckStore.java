package com.pb.tcs.dispatch;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/** In-memory {@link BusinessAckStore}. */
final class InMemoryBusinessAckStore implements BusinessAckStore {

    private final Map<Long, BusinessAckRecord> rows = new LinkedHashMap<>();
    private final AtomicLong ids = new AtomicLong();

    @Override
    public void save(BusinessAckRecord ack) {
        long id = ids.incrementAndGet();
        rows.put(
                ack.dispatchId(),
                new BusinessAckRecord(
                        id,
                        ack.dispatchId(),
                        ack.systemId(),
                        ack.status(),
                        ack.swapRef(),
                        ack.lotRefsJson(),
                        ack.rejectReason(),
                        ack.ackPayload(),
                        ack.ackedAt()));
    }

    @Override
    public Optional<BusinessAckRecord> findByDispatchId(long dispatchId) {
        return Optional.ofNullable(rows.get(dispatchId));
    }
}
