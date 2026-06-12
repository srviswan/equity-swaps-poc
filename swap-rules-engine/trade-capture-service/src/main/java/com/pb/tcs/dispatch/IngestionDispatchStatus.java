package com.pb.tcs.dispatch;

/** Aggregate ingestion status after dispatch fan-out (FR-401). */
public enum IngestionDispatchStatus {
    QUEUED,
    DISPATCHING,
    SENT,
    PARTIALLY_SENT,
    FAILED
}
