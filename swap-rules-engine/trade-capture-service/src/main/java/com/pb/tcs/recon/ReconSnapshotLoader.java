package com.pb.tcs.recon;

import com.pb.tcs.crossref.CrossRefRecord;
import java.time.Instant;
import java.util.List;

/** Read-only snapshot access for reconciliation (FR-706 / E6). */
public interface ReconSnapshotLoader {

    List<ReconRecord> loadTcs(ReconScope scope, Instant asOf);

    List<ReconRecord> loadSystemA(ReconScope scope, Instant asOf);

    List<ReconRecord> loadSystemB(ReconScope scope, Instant asOf);

    List<ReconRecord> loadGcam(ReconScope scope, Instant asOf);

    List<CrossRefRecord> loadCrossRefs(ReconScope scope);
}
