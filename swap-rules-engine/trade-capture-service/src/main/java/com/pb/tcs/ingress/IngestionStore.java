package com.pb.tcs.ingress;

import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.util.OptionalInt;

/**
 * SQL-backed ingestion persistence port. Implementations own the F1.4 transaction boundaries; the
 * pipeline owns the decision of what to write and the resulting Solace action.
 */
public interface IngestionStore {

    /** Idempotency probe (D4): does an {@code ENRICHED_ACKED}+ row exist for this version? */
    boolean isEnriched(String blockId, String allocationId, int version);

    /** Max enriched version for the allocation (spec §F1.3 {@code lastProcessed}). */
    OptionalInt lastEnrichedVersion(String blockId, String allocationId);

    /**
     * Single transaction: upsert {@code ingestion_record(ENRICHED_ACKED)} + insert
     * {@code enriched_allocation}. Solace ACK happens only after this commits (D5).
     *
     * @throws IngestionStoreException on SQL failure — caller NACKs, retry-safe via idempotency
     */
    void persistEnriched(EnrichedAllocation allocation);

    /**
     * Insert {@code audit_reject} row; stage = STRUCTURAL | MANDATORY | REFDATA.
     *
     * @param parsed null when the bytes never parsed (STRUCTURAL failures)
     */
    void auditReject(
            String stage, String reason, int attempt, byte[] rawProto, TcsIngressMessage parsed);

    /** Insert {@code repair_quarantine} row (category per spec §F0.3). */
    void quarantine(String category, String detail, byte[] rawProto);
}
