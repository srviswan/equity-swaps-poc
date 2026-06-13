package com.pb.tcs.dispatch;

/** Updates {@code ingestion_record.status} for the dispatch lifecycle (FR-401). */
public interface IngestionDispatchStatusUpdater {

    void update(String correlationId, IngestionDispatchStatus status);

    IngestionDispatchStatus current(String correlationId);
}
