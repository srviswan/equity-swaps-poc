package com.pb.tcs.ingress;

import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.util.Optional;
import java.util.UUID;

/** Ingestion status transitions for the approval gate and resume path (FR-301/302). */
public interface IngestionLifecycleStore {

    UUID persistEnrichedAndReturnId(EnrichedAllocation enriched);

    UUID persistManualBlotter(
            TcsIngressMessage envelope,
            byte[] rawProto,
            com.pb.tcs.rules.SwapBlotter blotter,
            String previewHash,
            String initiatedBy);

    void updateStatus(UUID ingestionId, String status, String approvalId);

    Optional<IngestionSnapshot> findByIngestionId(UUID ingestionId);

    Optional<IngestionSnapshot> findByCorrelationId(String correlationId);

    record IngestionSnapshot(
            UUID ingestionId,
            String correlationId,
            String blockId,
            String allocationId,
            int version,
            String status,
            String approvalId,
            String initiatedBy,
            String sourceSystem,
            String entryMode,
            String batchId) {}
}
