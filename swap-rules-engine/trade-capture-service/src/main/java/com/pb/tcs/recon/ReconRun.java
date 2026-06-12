package com.pb.tcs.recon;

import java.time.Instant;

public record ReconRun(
        long runId,
        ReconType reconType,
        ReconScope scope,
        Instant asOf,
        String status,
        Instant tcsWatermark,
        Instant downstreamWatermark,
        int breaksDetected,
        Instant startedAt,
        Instant completedAt,
        String idempotencyKey) {

    static ReconRun started(long runId, ReconType type, ReconScope scope, Instant asOf, String idempotencyKey) {
        return new ReconRun(
                runId,
                type,
                scope,
                asOf,
                "RUNNING",
                null,
                null,
                0,
                Instant.now(),
                null,
                idempotencyKey);
    }

    ReconRun complete(int breaks, Instant tcsWatermark, Instant downstreamWatermark) {
        return new ReconRun(
                runId,
                reconType,
                scope,
                asOf,
                "COMPLETE",
                tcsWatermark,
                downstreamWatermark,
                breaks,
                startedAt,
                Instant.now(),
                idempotencyKey);
    }
}
