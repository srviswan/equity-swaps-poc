package com.pb.tcs.ingress;

import com.pb.tcs.proto.allocation.v1.AllocationMessage;

/**
 * Output of stage 2/3: the validated allocation plus resolved reference-data snapshots, persisted
 * as one transaction with the {@code ENRICHED_ACKED} ingestion row (D5).
 *
 * @param clientRef null for BLOCK allocations (wash book substitutes, D8)
 * @param washBookRef null for SWAP allocations without a B2B leg
 */
public record EnrichedAllocation(
        AllocationMessage message,
        String securityRef,
        String clientRef,
        String bookRef,
        String washBookRef) {}
