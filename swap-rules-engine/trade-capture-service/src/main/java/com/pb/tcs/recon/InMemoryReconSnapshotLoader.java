package com.pb.tcs.recon;

import com.pb.tcs.crossref.CrossRefRecord;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/** Mutable snapshot fixture for F12 tests. */
public final class InMemoryReconSnapshotLoader implements ReconSnapshotLoader {

    private final List<ReconRecord> tcs = new ArrayList<>();
    private final List<ReconRecord> systemA = new ArrayList<>();
    private final List<ReconRecord> systemB = new ArrayList<>();
    private final List<ReconRecord> gcam = new ArrayList<>();
    private final List<CrossRefRecord> crossRefs = new ArrayList<>();

    public void addTcs(ReconRecord record) {
        tcs.add(record);
    }

    public void addSystemA(ReconRecord record) {
        systemA.add(record);
    }

    public void addSystemB(ReconRecord record) {
        systemB.add(record);
    }

    public void addGcam(ReconRecord record) {
        gcam.add(record);
    }

    public void addCrossRef(CrossRefRecord record) {
        crossRefs.add(record);
    }

    @Override
    public List<ReconRecord> loadTcs(ReconScope scope, Instant asOf) {
        return filterScope(tcs, scope);
    }

    @Override
    public List<ReconRecord> loadSystemA(ReconScope scope, Instant asOf) {
        return filterScope(systemA, scope);
    }

    @Override
    public List<ReconRecord> loadSystemB(ReconScope scope, Instant asOf) {
        return filterScope(systemB, scope);
    }

    @Override
    public List<ReconRecord> loadGcam(ReconScope scope, Instant asOf) {
        return filterScope(gcam, scope);
    }

    @Override
    public List<CrossRefRecord> loadCrossRefs(ReconScope scope) {
        return crossRefs;
    }

    private static List<ReconRecord> filterScope(List<ReconRecord> records, ReconScope scope) {
        return records.stream()
                .filter(r -> scope.book() == null || scope.book().equals(r.book()))
                .filter(r -> scope.tradeDate() == null || scope.tradeDate().equals(r.tradeDate()))
                .toList();
    }
}
