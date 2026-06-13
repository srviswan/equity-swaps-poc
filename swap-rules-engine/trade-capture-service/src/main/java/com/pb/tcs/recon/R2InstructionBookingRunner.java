package com.pb.tcs.recon;

import com.pb.tcs.config.ReconPolicyConfig;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** FR-701 R2: instruction-vs-booking recon (TCS vs System A/B snapshots). */
public final class R2InstructionBookingRunner {

    private final ReconPolicyConfig policy;
    private final ReconFieldClassifier classifier;

    public R2InstructionBookingRunner(ReconPolicyConfig policy, ReconFieldClassifier classifier) {
        this.policy = policy;
        this.classifier = classifier;
    }

    public List<ReconBreak> detect(
            long runId,
            ReconSnapshotLoader loader,
            ReconScope scope,
            Instant asOf,
            Instant detectedAt) {
        List<ReconRecord> tcsRecords = filterEligible(loader.loadTcs(scope, asOf), asOf);
        Map<String, ReconRecord> systemA = ReconMatcher.index(filterEligible(loader.loadSystemA(scope, asOf), asOf));
        Map<String, ReconRecord> systemB = ReconMatcher.index(filterEligible(loader.loadSystemB(scope, asOf), asOf));

        List<ReconBreak> breaks = new ArrayList<>();
        Set<String> matchedA = new HashSet<>();
        Set<String> matchedB = new HashSet<>();

        for (ReconRecord tcs : tcsRecords) {
            ReconRecord a = systemA.get(tcs.matchKey());
            if (a == null && tcs.swapRef() != null) {
                a = findBySwap(systemA, tcs.swapRef());
            }
            ReconRecord b = systemB.get(tcs.matchKey());
            if (b == null && tcs.swapRef() != null) {
                b = findBySwap(systemB, tcs.swapRef());
            }

            if (a == null) {
                breaks.add(breakRow(runId, BreakType.MISSING_IN_A, tcs, null, detectedAt));
            } else {
                matchedA.add(a.matchKey());
                breaks.addAll(driftBreaks(runId, tcs, a, detectedAt));
            }
            if (b == null) {
                breaks.add(breakRow(runId, BreakType.MISSING_IN_B, tcs, null, detectedAt));
            } else {
                matchedB.add(b.matchKey());
                breaks.addAll(driftBreaks(runId, tcs, b, detectedAt));
            }
        }

        for (ReconRecord orphan : systemA.values()) {
            if (!matchedA.contains(orphan.matchKey())) {
                breaks.add(breakRow(runId, BreakType.MISSING_IN_TCS, null, orphan, detectedAt));
            }
        }
        for (ReconRecord orphan : systemB.values()) {
            if (!matchedB.contains(orphan.matchKey())) {
                breaks.add(breakRow(runId, BreakType.MISSING_IN_TCS, null, orphan, detectedAt));
            }
        }
        return breaks;
    }

    private List<ReconBreak> driftBreaks(long runId, ReconRecord tcs, ReconRecord peer, Instant detectedAt) {
        List<ReconBreak> breaks = new ArrayList<>();
        for (BreakType type : classifier.classifyDrift(tcs, peer)) {
            breaks.add(breakRow(runId, type, tcs, peer, detectedAt));
        }
        return breaks;
    }

    private ReconBreak breakRow(
            long runId, BreakType type, ReconRecord tcsSide, ReconRecord peerSide, Instant detectedAt) {
        ReconRecord primary = tcsSide != null ? tcsSide : peerSide;
        return ReconBreak.detected(
                0,
                runId,
                ReconType.R2,
                type,
                primary.allocationId(),
                primary.swapRef(),
                primary.lotRef(),
                summarize(tcsSide),
                summarize(peerSide),
                ReconFieldClassifier.autoHealEligible(type),
                detectedAt);
    }

    private List<ReconRecord> filterEligible(List<ReconRecord> records, Instant asOf) {
        return records.stream()
                .filter(r -> ReconMatcher.withinHorizon(r, asOf, policy.inFlightHorizonMinutes()))
                .toList();
    }

    private static ReconRecord findBySwap(Map<String, ReconRecord> index, String swapRef) {
        return index.values().stream().filter(r -> swapRef.equals(r.swapRef())).findFirst().orElse(null);
    }

    private static String summarize(ReconRecord record) {
        if (record == null) {
            return null;
        }
        return record.swapRef()
                + "|"
                + record.quantity()
                + "|"
                + record.direction()
                + "|"
                + record.securityId()
                + "|"
                + record.status();
    }
}
