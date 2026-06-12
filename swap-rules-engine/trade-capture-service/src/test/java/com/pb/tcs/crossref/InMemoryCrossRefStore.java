package com.pb.tcs.crossref;

import com.pb.tcs.ingress.IngestionStoreException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/** In-memory {@link CrossRefStore} for F7 exit-criteria tests. */
public final class InMemoryCrossRefStore implements CrossRefStore {

    private final Map<Long, CrossRefRecord> rows = new LinkedHashMap<>();
    private final AtomicLong ids = new AtomicLong();

    @Override
    public void upsertPending(CrossRefRecord record) {
        Optional<CrossRefRecord> existing =
                rows.values().stream()
                        .filter(
                                r ->
                                        r.ingestionId().equals(record.ingestionId())
                                                && r.fromSystem().equals(record.fromSystem())
                                                && r.toSystem().equals(record.toSystem()))
                        .findFirst();
        if (existing.isPresent()) {
            CrossRefRecord prior = existing.get();
            rows.put(
                    prior.crossRefId(),
                    new CrossRefRecord(
                            prior.crossRefId(),
                            record.ingestionId(),
                            record.correlationId(),
                            record.fromSystem(),
                            record.toSystem(),
                            record.swapRef(),
                            record.lotRefsJson(),
                            record.eventType(),
                            CrossRefStatus.PENDING,
                            0,
                            Instant.EPOCH,
                            null,
                            null));
        } else {
            long id = ids.incrementAndGet();
            rows.put(
                    id,
                    new CrossRefRecord(
                            id,
                            record.ingestionId(),
                            record.correlationId(),
                            record.fromSystem(),
                            record.toSystem(),
                            record.swapRef(),
                            record.lotRefsJson(),
                            record.eventType(),
                            CrossRefStatus.PENDING,
                            0,
                            Instant.EPOCH,
                            null,
                            null));
        }
    }

    @Override
    public List<CrossRefRecord> claimPending(int limit, Instant now) {
        List<CrossRefRecord> claimed = new ArrayList<>();
        for (var entry : rows.entrySet()) {
            if (claimed.size() >= limit) {
                break;
            }
            CrossRefRecord r = entry.getValue();
            if (r.status() == CrossRefStatus.PENDING && !r.nextAttemptAt().isAfter(now)) {
                claimed.add(r);
            }
        }
        return claimed;
    }

    @Override
    public void markDelivered(long crossRefId, Instant deliveredAt) {
        update(crossRefId, r -> new CrossRefRecord(
                r.crossRefId(), r.ingestionId(), r.correlationId(), r.fromSystem(), r.toSystem(),
                r.swapRef(), r.lotRefsJson(), r.eventType(), CrossRefStatus.DELIVERED,
                r.attemptCount(), r.nextAttemptAt(), null, deliveredAt));
    }

    @Override
    public void scheduleRetry(long crossRefId, int attemptCount, Instant nextAttemptAt, String lastError) {
        update(crossRefId, r -> new CrossRefRecord(
                r.crossRefId(), r.ingestionId(), r.correlationId(), r.fromSystem(), r.toSystem(),
                r.swapRef(), r.lotRefsJson(), r.eventType(), CrossRefStatus.PENDING, attemptCount,
                nextAttemptAt, lastError, r.deliveredAt()));
    }

    @Override
    public void markFailed(long crossRefId, String lastError) {
        update(crossRefId, r -> new CrossRefRecord(
                r.crossRefId(), r.ingestionId(), r.correlationId(), r.fromSystem(), r.toSystem(),
                r.swapRef(), r.lotRefsJson(), r.eventType(), CrossRefStatus.FAILED, r.attemptCount(),
                r.nextAttemptAt(), lastError, r.deliveredAt()));
    }

    @Override
    public void resetToPending(long crossRefId) {
        update(crossRefId, r -> new CrossRefRecord(
                r.crossRefId(), r.ingestionId(), r.correlationId(), r.fromSystem(), r.toSystem(),
                r.swapRef(), r.lotRefsJson(), r.eventType(), CrossRefStatus.PENDING, 0,
                Instant.EPOCH, null, null));
    }

    @Override
    public List<CrossRefRecord> findByIngestionId(UUID ingestionId) {
        return rows.values().stream().filter(r -> r.ingestionId().equals(ingestionId)).toList();
    }

    @Override
    public Optional<CrossRefRecord> findDirection(UUID ingestionId, String fromSystem, String toSystem) {
        return rows.values().stream()
                .filter(r -> r.ingestionId().equals(ingestionId)
                        && r.fromSystem().equals(fromSystem)
                        && r.toSystem().equals(toSystem))
                .findFirst();
    }

    @Override
    public List<CrossRefRecord> query(CrossRefQuery query) {
        return rows.values().stream()
                .filter(r -> query.swapRef() == null || query.swapRef().isBlank() || query.swapRef().equals(r.swapRef()))
                .filter(r -> query.fromSystem() == null || query.fromSystem().isBlank()
                        || query.fromSystem().equals(r.fromSystem()))
                .filter(r -> query.toSystem() == null || query.toSystem().isBlank()
                        || query.toSystem().equals(r.toSystem()))
                .filter(r -> {
                    if (query.allocationId() == null || query.allocationId().isBlank()) {
                        return true;
                    }
                    String[] parts = r.correlationId().split("/", 3);
                    return parts.length >= 2 && query.allocationId().equals(parts[1]);
                })
                .toList();
    }

    private void update(long crossRefId, java.util.function.Function<CrossRefRecord, CrossRefRecord> fn) {
        CrossRefRecord r = rows.get(crossRefId);
        if (r == null) {
            throw new IngestionStoreException("unknown cross_ref " + crossRefId);
        }
        rows.put(crossRefId, fn.apply(r));
    }
}
