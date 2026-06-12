package com.pb.tcs.ingress;

import java.util.List;
import java.util.SortedSet;

/**
 * Version-gap decisions for versions of ONE allocation (spec §F1.3). Cross-allocation ordering on
 * a key is Solace partition FIFO (D2) — never re-implemented here.
 */
public final class VersionGapEvaluator {

    private VersionGapEvaluator() {}

    /** Outcome of an arrival decision. */
    public sealed interface Decision permits Process, Hold, Duplicate {}

    /** In order — run the pipeline, then drain holds. */
    public record Process() implements Decision {}

    /** Gap — persist a hold row, ACK, start/extend the book deadline. */
    public record Hold(int expectedVersion) implements Decision {}

    /** Stale or replayed — ACK and audit, no side effects. */
    public record Duplicate(int lastProcessedVersion) implements Decision {}

    /**
     * @param lastProcessedVersion max processed version for (block, alloc); 0 if none
     * @param incomingVersion version on the arriving message
     */
    public static Decision onArrival(int lastProcessedVersion, int incomingVersion) {
        if (incomingVersion <= lastProcessedVersion) {
            return new Duplicate(lastProcessedVersion);
        }
        if (incomingVersion == lastProcessedVersion + 1) {
            return new Process();
        }
        return new Hold(lastProcessedVersion + 1);
    }

    /**
     * Consecutive held versions releasable after {@code processedVersion} committed, in order.
     */
    public static List<Integer> drainable(int processedVersion, SortedSet<Integer> heldVersions) {
        List<Integer> releasable = new java.util.ArrayList<>();
        int next = processedVersion + 1;
        for (int held : heldVersions) {
            if (held != next) {
                break;
            }
            releasable.add(held);
            next++;
        }
        return releasable;
    }
}
