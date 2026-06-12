package com.pb.tcs.ingress;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;

/**
 * Port over {@code version_gap_hold} (spec §F0.3) — DB-backed so holds survive restart (NFR-6).
 */
public interface VersionGapHoldStore {

    record HoldRow(
            String blockId,
            String allocationId,
            int heldVersion,
            int expectedVersion,
            String book,
            Instant deadlineAt,
            byte[] rawProto) {}

    /** @throws IngestionStoreException on {@code uq_hold} violation (same version held twice) */
    void hold(HoldRow row);

    SortedSet<Integer> heldVersions(String blockId, String allocationId);

    /** Atomically remove and return the hold so a drained version is processed exactly once. */
    Optional<HoldRow> claim(String blockId, String allocationId, int version);

    /** Holds whose {@code deadline_at} has passed — sweeper input (spec §F1.3). */
    List<HoldRow> expiredHolds(Instant now);

    void remove(String blockId, String allocationId, int version);
}
