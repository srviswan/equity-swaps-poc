package com.pb.tcs.recon;

import com.pb.tcs.config.ReconPolicyConfig;
import com.pb.tcs.crossref.CrossRefRecord;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** FR-702 R3: cross-system sync recon via TCS {@code cross_ref} (A ↔ B). */
public final class R3CrossSystemRunner {

    private final ReconPolicyConfig policy;
    private final ReconFieldClassifier classifier;

    public R3CrossSystemRunner(ReconPolicyConfig policy, ReconFieldClassifier classifier) {
        this.policy = policy;
        this.classifier = classifier;
    }

    public List<ReconBreak> detect(
            long runId,
            ReconSnapshotLoader loader,
            ReconScope scope,
            Instant asOf,
            Instant detectedAt) {
        Map<String, ReconRecord> systemA = ReconMatcher.index(filterEligible(loader.loadSystemA(scope, asOf), asOf));
        Map<String, ReconRecord> systemB = ReconMatcher.index(filterEligible(loader.loadSystemB(scope, asOf), asOf));
        List<CrossRefRecord> crossRefs = loader.loadCrossRefs(scope);

        List<ReconBreak> breaks = new ArrayList<>();
        Set<String> matchedA = new HashSet<>();
        Set<String> matchedB = new HashSet<>();

        for (CrossRefRecord xref : crossRefs) {
            ReconRecord expected =
                    new ReconRecord(
                            ReconRecord.ReconSource.TCS,
                            extractAllocation(xref.correlationId()),
                            xref.swapRef(),
                            firstLot(xref.lotRefsJson()),
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            xref.status().name(),
                            Map.of(),
                            detectedAt);

            if ("SYSTEM_A".equals(xref.fromSystem()) && "SYSTEM_B".equals(xref.toSystem())) {
                ReconRecord source = findBySwap(systemA, xref.swapRef());
                if (source != null) {
                    matchedA.add(source.matchKey());
                }
                ReconRecord peer = findBySwap(systemB, xref.swapRef());
                breaks.addAll(comparePeer(runId, expected, peer, BreakType.MISSING_IN_B, detectedAt));
                if (peer != null) {
                    matchedB.add(peer.matchKey());
                }
            } else if ("SYSTEM_B".equals(xref.fromSystem()) && "SYSTEM_A".equals(xref.toSystem())) {
                ReconRecord source = findBySwap(systemB, xref.swapRef());
                if (source != null) {
                    matchedB.add(source.matchKey());
                }
                ReconRecord peer = findBySwap(systemA, xref.swapRef());
                breaks.addAll(comparePeer(runId, expected, peer, BreakType.MISSING_IN_A, detectedAt));
                if (peer != null) {
                    matchedA.add(peer.matchKey());
                }
            }
        }

        for (ReconRecord orphan : systemA.values()) {
            if (!matchedA.contains(orphan.matchKey())) {
                breaks.add(
                        breakRow(
                                runId,
                                BreakType.MISSING_IN_TCS,
                                orphan,
                                null,
                                detectedAt));
            }
        }
        for (ReconRecord orphan : systemB.values()) {
            if (!matchedB.contains(orphan.matchKey())) {
                breaks.add(
                        breakRow(
                                runId,
                                BreakType.MISSING_IN_TCS,
                                orphan,
                                null,
                                detectedAt));
            }
        }
        return breaks;
    }

    private List<ReconBreak> comparePeer(
            long runId,
            ReconRecord expected,
            ReconRecord peer,
            BreakType missingType,
            Instant detectedAt) {
        List<ReconBreak> breaks = new ArrayList<>();
        if (peer == null) {
            breaks.add(breakRow(runId, missingType, expected, null, detectedAt));
            return breaks;
        }
        for (BreakType drift : classifier.classifyDrift(expected, peer)) {
            breaks.add(breakRow(runId, drift, expected, peer, detectedAt));
        }
        return breaks;
    }

    private ReconBreak breakRow(
            long runId, BreakType type, ReconRecord tcsSide, ReconRecord peerSide, Instant detectedAt) {
        boolean autoHeal = ReconFieldClassifier.autoHealEligible(type);
        return ReconBreak.detected(
                0,
                runId,
                ReconType.R3,
                type,
                tcsSide.allocationId(),
                tcsSide.swapRef() != null ? tcsSide.swapRef() : peerSide != null ? peerSide.swapRef() : null,
                tcsSide.lotRef() != null ? tcsSide.lotRef() : peerSide != null ? peerSide.lotRef() : null,
                summarize(tcsSide),
                summarize(peerSide),
                autoHeal,
                detectedAt);
    }

    private List<ReconRecord> filterEligible(List<ReconRecord> records, Instant asOf) {
        return records.stream()
                .filter(r -> ReconMatcher.withinHorizon(r, asOf, policy.inFlightHorizonMinutes()))
                .toList();
    }

    private static ReconRecord findBySwap(Map<String, ReconRecord> index, String swapRef) {
        if (swapRef == null) {
            return null;
        }
        return index.values().stream().filter(r -> swapRef.equals(r.swapRef())).findFirst().orElse(null);
    }

    private static String extractAllocation(String correlationId) {
        if (correlationId == null) {
            return null;
        }
        String[] parts = correlationId.split("/", 3);
        return parts.length >= 2 ? parts[1] : null;
    }

    private static String firstLot(String lotRefsJson) {
        if (lotRefsJson == null || lotRefsJson.isBlank()) {
            return null;
        }
        String trimmed = lotRefsJson.replace("[", "").replace("]", "").replace("\"", "");
        int comma = trimmed.indexOf(',');
        return comma >= 0 ? trimmed.substring(0, comma).trim() : trimmed.trim();
    }

    private static String summarize(ReconRecord record) {
        if (record == null) {
            return null;
        }
        return record.swapRef()
                + "|"
                + record.lotRef()
                + "|"
                + record.quantity()
                + "|"
                + record.status();
    }
}
