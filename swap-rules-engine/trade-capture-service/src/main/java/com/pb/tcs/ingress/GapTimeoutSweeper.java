package com.pb.tcs.ingress;

import java.time.Clock;
import java.util.List;

/**
 * Scheduled sweep (every 5s in production): holds past {@code deadline_at} move to
 * {@code repair_quarantine(VERSION_GAP)} with an ops alert (spec §F1.3, FR-104).
 */
public final class GapTimeoutSweeper {

    private final VersionGapHoldStore holds;
    private final IngestionStore store;
    private final IngressMetrics metrics;
    private final Clock clock;

    public GapTimeoutSweeper(
            VersionGapHoldStore holds, IngestionStore store, IngressMetrics metrics, Clock clock) {
        this.holds = holds;
        this.store = store;
        this.metrics = metrics;
        this.clock = clock;
    }

    /** @return number of holds quarantined in this sweep */
    public int sweep() {
        List<VersionGapHoldStore.HoldRow> expired = holds.expiredHolds(clock.instant());
        for (VersionGapHoldStore.HoldRow row : expired) {
            store.quarantine(
                    "VERSION_GAP",
                    "held version %d for %s/%s expired waiting for %d (book %s)"
                            .formatted(
                                    row.heldVersion(),
                                    row.blockId(),
                                    row.allocationId(),
                                    row.expectedVersion(),
                                    row.book()),
                    row.rawProto());
            holds.remove(row.blockId(), row.allocationId(), row.heldVersion());
            metrics.versionGapQuarantined(row.book());
        }
        return expired.size();
    }
}
