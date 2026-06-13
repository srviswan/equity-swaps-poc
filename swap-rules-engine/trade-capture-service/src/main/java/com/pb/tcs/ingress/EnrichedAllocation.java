package com.pb.tcs.ingress;

import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;

/**
 * Output of stage 2/3: the validated envelope plus resolved reference-data snapshots, persisted
 * as one transaction with the {@code ENRICHED_ACKED} ingestion row (D5).
 *
 * @param rawProto original wire bytes, persisted to {@code ingestion_record.raw_proto}
 * @param clientRef null for BLOCK allocations (wash book substitutes, D8)
 * @param washBookRef null for SWAP allocations without a B2B leg
 */
public record EnrichedAllocation(
        TcsIngressMessage envelope,
        byte[] rawProto,
        String securityRef,
        String clientRef,
        String bookRef,
        String washBookRef) {

    public AllocationMessage message() {
        return envelope.getAllocation();
    }

    /** Correlation id (D4): {@code blockId/allocationId/version}. */
    public String correlationId() {
        AllocationMessage m = message();
        return m.getBlockId() + "/" + m.getAllocationId() + "/" + m.getVersion();
    }

    public long sequenceKeyHash() {
        return SequenceKeys.hash(
                envelope.getBook(), envelope.getAccountId(), envelope.getSecurityId());
    }
}
