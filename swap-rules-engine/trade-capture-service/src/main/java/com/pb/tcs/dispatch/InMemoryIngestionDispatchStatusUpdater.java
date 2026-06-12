package com.pb.tcs.dispatch;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** In-memory {@link IngestionDispatchStatusUpdater} for dispatch lifecycle tests. */
public final class InMemoryIngestionDispatchStatusUpdater implements IngestionDispatchStatusUpdater {

    private final Map<String, IngestionDispatchStatus> statuses = new ConcurrentHashMap<>();

    @Override
    public void update(String correlationId, IngestionDispatchStatus status) {
        statuses.put(correlationId, status);
    }

    @Override
    public IngestionDispatchStatus current(String correlationId) {
        return statuses.getOrDefault(correlationId, IngestionDispatchStatus.QUEUED);
    }
}
