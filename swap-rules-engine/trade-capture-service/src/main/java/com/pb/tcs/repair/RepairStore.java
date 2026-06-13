package com.pb.tcs.repair;

import java.util.List;
import java.util.Optional;

/**
 * Persistence port over {@code repair_quarantine} for the FR-209 workflow. F4 adds the editable
 * blotter payload (V003) on top of the F0 quarantine contract; the F1 ref-data path keeps using
 * {@code IngestionStore.quarantine} for raw-proto quarantines.
 */
public interface RepairStore {

    String STATUS_OPEN = "OPEN";
    String STATUS_REPROCESSED = "REPROCESSED";
    String STATUS_DISCARDED = "DISCARDED";

    /** Opens a quarantine item carrying an editable payload; returns the quarantine id. */
    long open(String category, String correlationId, String detail, String payloadJson);

    Optional<RepairItem> find(long quarantineId);

    List<RepairItem> openItems(String category);

    /** Persists an ops edit of the payload (FR-209); item must be OPEN. */
    void saveEdit(long quarantineId, String payloadJson, String editedBy);

    /** Terminal transition to REPROCESSED or DISCARDED with resolver audit. */
    void resolve(long quarantineId, String status, String resolvedBy);

    record RepairItem(
            long quarantineId,
            String category,
            String correlationId,
            String detail,
            String payloadJson,
            String status,
            String editedBy) {}
}
