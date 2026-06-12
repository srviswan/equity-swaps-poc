package com.pb.tcs.recon;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** FR-700 R1: ingestion completeness recon (GCAM vs TCS ingestion). */
public final class R1IngestionCompletenessRunner {

    public List<ReconBreak> detect(
            long runId,
            ReconSnapshotLoader loader,
            ReconScope scope,
            Instant asOf,
            Instant detectedAt) {
        List<ReconRecord> gcam = loader.loadGcam(scope, asOf);
        List<ReconRecord> tcs = loader.loadTcs(scope, asOf);

        Map<String, Integer> tcsCounts = new HashMap<>();
        for (ReconRecord record : tcs) {
            if (record.allocationId() != null) {
                tcsCounts.merge(record.allocationId(), 1, Integer::sum);
            }
        }

        List<ReconBreak> breaks = new ArrayList<>();
        for (ReconRecord gcamRow : gcam) {
            String allocationId = gcamRow.allocationId();
            Integer count = tcsCounts.get(allocationId);
            if (count == null) {
                breaks.add(
                        ReconBreak.detected(
                                0,
                                runId,
                                ReconType.R1,
                                BreakType.MISSING_IN_TCS,
                                allocationId,
                                null,
                                null,
                                null,
                                summarize(gcamRow),
                                false,
                                detectedAt));
            } else if (count > 1) {
                breaks.add(
                        ReconBreak.detected(
                                0,
                                runId,
                                ReconType.R1,
                                BreakType.DUPLICATE,
                                allocationId,
                                null,
                                null,
                                "count=" + count,
                                summarize(gcamRow),
                                false,
                                detectedAt));
            }
        }
        return breaks;
    }

    private static String summarize(ReconRecord record) {
        return record.allocationId()
                + "|"
                + record.book()
                + "|"
                + record.tradeDate()
                + "|"
                + record.quantity();
    }
}
