package com.pb.tcs.dispatch;

import com.pb.tcs.ingress.IngestionStoreException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/** In-memory {@link DispatchRecordStore} with claim-batch semantics. */
public final class InMemoryDispatchRecordStore implements DispatchRecordStore {

    private final Map<Long, DispatchRecord> rows = new LinkedHashMap<>();
    private final AtomicLong ids = new AtomicLong();

    @Override
    public void createPending(UUID ingestionId, String correlationId, List<String> destinationIds) {
        Instant eligible = Instant.EPOCH;
        for (String dest : destinationIds) {
            long id = ids.incrementAndGet();
            if (rows.values().stream().anyMatch(r -> r.ingestionId().equals(ingestionId) && r.destinationId().equals(dest))) {
                continue;
            }
            rows.put(
                    id,
                    new DispatchRecord(
                            id,
                            ingestionId,
                            correlationId,
                            dest,
                            DispatchStatus.PENDING,
                            0,
                            eligible,
                            null,
                            null,
                            null));
        }
    }

    @Override
    public List<DispatchRecord> claimBatch(int limit, Instant now) {
        List<DispatchRecord> claimed = new ArrayList<>();
        for (var entry : rows.entrySet()) {
            if (claimed.size() >= limit) {
                break;
            }
            DispatchRecord r = entry.getValue();
            if (r.status() == DispatchStatus.PENDING && !r.nextAttemptAt().isAfter(now)) {
                DispatchRecord claimedRow =
                        new DispatchRecord(
                                r.dispatchId(),
                                r.ingestionId(),
                                r.correlationId(),
                                r.destinationId(),
                                DispatchStatus.CLAIMED,
                                r.attemptCount(),
                                r.nextAttemptAt(),
                                r.lastError(),
                                r.envelopeHash(),
                                r.sentAt());
                rows.put(entry.getKey(), claimedRow);
                claimed.add(claimedRow);
            }
        }
        return claimed;
    }

    @Override
    public void markSent(long dispatchId, String envelopeHash, Instant sentAt) {
        update(dispatchId, r -> new DispatchRecord(
                r.dispatchId(), r.ingestionId(), r.correlationId(), r.destinationId(),
                DispatchStatus.SENT, r.attemptCount(), r.nextAttemptAt(), r.lastError(),
                envelopeHash, sentAt));
    }

    @Override
    public void scheduleRetry(long dispatchId, int attemptCount, Instant nextAttemptAt, String lastError) {
        update(dispatchId, r -> new DispatchRecord(
                r.dispatchId(), r.ingestionId(), r.correlationId(), r.destinationId(),
                DispatchStatus.PENDING, attemptCount, nextAttemptAt, lastError,
                r.envelopeHash(), r.sentAt()));
    }

    @Override
    public void markFailed(long dispatchId, String lastError) {
        update(dispatchId, r -> new DispatchRecord(
                r.dispatchId(), r.ingestionId(), r.correlationId(), r.destinationId(),
                DispatchStatus.FAILED, r.attemptCount(), r.nextAttemptAt(), lastError,
                r.envelopeHash(), r.sentAt()));
    }

    @Override
    public List<DispatchRecord> findByCorrelationId(String correlationId) {
        return rows.values().stream().filter(r -> r.correlationId().equals(correlationId)).toList();
    }

    @Override
    public Optional<DispatchRecord> findByDestination(String correlationId, String destinationId) {
        return rows.values().stream()
                .filter(r -> r.correlationId().equals(correlationId) && r.destinationId().equals(destinationId))
                .findFirst();
    }

    private void update(long dispatchId, java.util.function.Function<DispatchRecord, DispatchRecord> fn) {
        DispatchRecord r = rows.get(dispatchId);
        if (r == null) {
            throw new IngestionStoreException("unknown dispatch " + dispatchId);
        }
        rows.put(dispatchId, fn.apply(r));
    }
}
