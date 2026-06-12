package com.pb.tcs.ingress;

import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.SortedSet;
import java.util.TreeSet;

/** Test fake for the SQL-backed ingestion store (F1.4 transaction boundaries). */
final class InMemoryIngestionStore implements IngestionStore {

    record AuditRow(String stage, String reason, int attempt) {}

    record QuarantineRow(String category, String detail) {}

    private final Map<String, SortedSet<Integer>> enriched = new LinkedHashMap<>();
    private final List<AuditRow> auditRejects = new ArrayList<>();
    private final List<QuarantineRow> quarantines = new ArrayList<>();
    private EnrichedAllocation lastEnriched;
    private int persistCount;
    private boolean failNextPersist;

    @Override
    public boolean isEnriched(String blockId, String allocationId, int version) {
        return versions(blockId, allocationId).contains(version);
    }

    @Override
    public OptionalInt lastEnrichedVersion(String blockId, String allocationId) {
        SortedSet<Integer> versions = versions(blockId, allocationId);
        return versions.isEmpty() ? OptionalInt.empty() : OptionalInt.of(versions.last());
    }

    @Override
    public void persistEnriched(EnrichedAllocation allocation) {
        if (failNextPersist) {
            failNextPersist = false;
            throw new IngestionStoreException("simulated SQL failure");
        }
        versions(allocation.message().getBlockId(), allocation.message().getAllocationId())
                .add(allocation.message().getVersion());
        lastEnriched = allocation;
        persistCount++;
    }

    @Override
    public void auditReject(String stage, String reason, int attempt, TcsIngressMessage raw) {
        auditRejects.add(new AuditRow(stage, reason, attempt));
    }

    @Override
    public void quarantine(String category, String detail, byte[] rawProto) {
        quarantines.add(new QuarantineRow(category, detail));
    }

    private SortedSet<Integer> versions(String blockId, String allocationId) {
        return enriched.computeIfAbsent(blockId + "|" + allocationId, k -> new TreeSet<>());
    }

    // --- assertions ---------------------------------------------------------------

    SortedSet<Integer> enrichedVersions(String blockId, String allocationId) {
        return versions(blockId, allocationId);
    }

    List<AuditRow> auditRejects() {
        return auditRejects;
    }

    List<QuarantineRow> quarantines() {
        return quarantines;
    }

    EnrichedAllocation lastEnriched() {
        return lastEnriched;
    }

    int persistCount() {
        return persistCount;
    }

    void failNextPersist() {
        this.failNextPersist = true;
    }
}
