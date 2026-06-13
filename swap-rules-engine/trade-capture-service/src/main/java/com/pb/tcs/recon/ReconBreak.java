package com.pb.tcs.recon;

import java.time.Instant;

public record ReconBreak(
        long breakId,
        long runId,
        ReconType breakClass,
        BreakType breakType,
        String allocationId,
        String swapRef,
        String lotRef,
        String tcsValueJson,
        String peerValueJson,
        BreakStatus status,
        boolean autoHealEligible,
        String resolutionNote,
        String resolvedBy,
        Instant detectedAt,
        Instant resolvedAt) {

    static ReconBreak detected(
            long breakId,
            long runId,
            ReconType breakClass,
            BreakType breakType,
            String allocationId,
            String swapRef,
            String lotRef,
            String tcsValue,
            String peerValue,
            boolean autoHealEligible,
            Instant detectedAt) {
        return new ReconBreak(
                breakId,
                runId,
                breakClass,
                breakType,
                allocationId,
                swapRef,
                lotRef,
                tcsValue,
                peerValue,
                BreakStatus.DETECTED,
                autoHealEligible,
                null,
                null,
                detectedAt,
                null);
    }

    ReconBreak withStatus(BreakStatus newStatus, String note, String resolvedBy, Instant resolvedAt) {
        return new ReconBreak(
                breakId,
                runId,
                breakClass,
                breakType,
                allocationId,
                swapRef,
                lotRef,
                tcsValueJson,
                peerValueJson,
                newStatus,
                autoHealEligible,
                note,
                resolvedBy,
                detectedAt,
                resolvedAt);
    }
}
