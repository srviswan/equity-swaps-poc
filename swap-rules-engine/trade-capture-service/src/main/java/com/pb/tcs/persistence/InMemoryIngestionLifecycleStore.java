package com.pb.tcs.persistence;

import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.ingress.IngestionLifecycleStore;
import com.pb.tcs.ingress.IngestionStore;
import com.pb.tcs.ingress.IngestionStoreException;
import com.pb.tcs.ingress.SequenceKeys;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import com.pb.tcs.rules.SwapBlotter;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/** In-memory lifecycle + ingestion store for F8 integration tests. */
public final class InMemoryIngestionLifecycleStore implements IngestionLifecycleStore, IngestionStore {

    private final Map<UUID, IngestionLifecycleStore.IngestionSnapshot> byId = new LinkedHashMap<>();
    private final Map<String, IngestionLifecycleStore.IngestionSnapshot> byCorrelation = new LinkedHashMap<>();
    private final AtomicLong versions = new AtomicLong();
    private EnrichedAllocation lastEnriched;
    private UUID lastId;

    public EnrichedAllocation lastEnriched() {
        return lastEnriched;
    }

    public UUID lastId() {
        return lastId;
    }

    @Override
    public UUID persistEnrichedAndReturnId(EnrichedAllocation enriched) {
        lastEnriched = enriched;
        UUID id = UUID.randomUUID();
        lastId = id;
        AllocationMessage msg = enriched.message();
        TcsIngressMessage envelope = enriched.envelope();
        IngestionLifecycleStore.IngestionSnapshot snap =
                new IngestionLifecycleStore.IngestionSnapshot(
                        id,
                        enriched.correlationId(),
                        msg.getBlockId(),
                        msg.getAllocationId(),
                        msg.getVersion(),
                        "ENRICHED_ACKED",
                        null,
                        envelope.getInitiatedBy().isBlank() ? "SYSTEM" : envelope.getInitiatedBy(),
                        envelope.getSource().name(),
                        "ALLOCATION",
                        null);
        index(snap);
        return id;
    }

    @Override
    public UUID persistManualBlotter(
            TcsIngressMessage envelope,
            byte[] rawProto,
            SwapBlotter blotter,
            String previewHash,
            String initiatedBy) {
        UUID id = UUID.randomUUID();
        IngestionLifecycleStore.IngestionSnapshot snap =
                new IngestionLifecycleStore.IngestionSnapshot(
                        id,
                        blotter.correlationId(),
                        blotter.blockId(),
                        blotter.allocationId(),
                        blotter.version(),
                        "RECEIVED",
                        null,
                        initiatedBy,
                        envelope.getSource().name(),
                        "MANUAL_BLOTTER",
                        null);
        index(snap);
        return id;
    }

    @Override
    public void updateStatus(UUID ingestionId, String status, String approvalId) {
        IngestionLifecycleStore.IngestionSnapshot prior = byId.get(ingestionId);
        if (prior == null) {
            throw new IngestionStoreException("unknown ingestion " + ingestionId);
        }
        IngestionLifecycleStore.IngestionSnapshot updated =
                new IngestionLifecycleStore.IngestionSnapshot(
                        prior.ingestionId(),
                        prior.correlationId(),
                        prior.blockId(),
                        prior.allocationId(),
                        prior.version(),
                        status,
                        approvalId,
                        prior.initiatedBy(),
                        prior.sourceSystem(),
                        prior.entryMode(),
                        prior.batchId());
        index(updated);
    }

    @Override
    public Optional<IngestionLifecycleStore.IngestionSnapshot> findByIngestionId(UUID ingestionId) {
        return Optional.ofNullable(byId.get(ingestionId));
    }

    @Override
    public Optional<IngestionLifecycleStore.IngestionSnapshot> findByCorrelationId(String correlationId) {
        return Optional.ofNullable(byCorrelation.get(correlationId));
    }

    @Override
    public boolean isEnriched(String blockId, String allocationId, int version) {
        return byCorrelation.values().stream()
                .anyMatch(
                        s ->
                                s.blockId().equals(blockId)
                                        && s.allocationId().equals(allocationId)
                                        && s.version() == version
                                        && "ENRICHED_ACKED".equals(s.status()));
    }

    @Override
    public java.util.OptionalInt lastEnrichedVersion(String blockId, String allocationId) {
        int max =
                byCorrelation.values().stream()
                        .filter(
                                s ->
                                        s.blockId().equals(blockId)
                                                && s.allocationId().equals(allocationId)
                                                && "ENRICHED_ACKED".equals(s.status()))
                        .mapToInt(IngestionLifecycleStore.IngestionSnapshot::version)
                        .max()
                        .orElse(0);
        return max == 0 ? java.util.OptionalInt.empty() : java.util.OptionalInt.of(max);
    }

    @Override
    public void persistEnriched(EnrichedAllocation allocation) {
        persistEnrichedAndReturnId(allocation);
    }

    @Override
    public void auditReject(
            String stage, String reason, int attempt, byte[] rawProto, TcsIngressMessage parsed) {}

    @Override
    public void quarantine(String category, String detail, byte[] rawProto) {}

    private void index(IngestionLifecycleStore.IngestionSnapshot snap) {
        byId.put(snap.ingestionId(), snap);
        byCorrelation.put(snap.correlationId(), snap);
    }
}
