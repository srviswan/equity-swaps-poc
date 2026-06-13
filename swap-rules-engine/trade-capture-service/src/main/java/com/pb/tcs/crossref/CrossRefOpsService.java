package com.pb.tcs.crossref;

import java.time.Instant;

/** FR-406 ops actions on failed/pending cross-ref delivery (backend for ops UI). */
public final class CrossRefOpsService {

    private final CrossRefStore store;
    private final CrossRefExecutor executor;

    public CrossRefOpsService(CrossRefStore store, CrossRefExecutor executor) {
        this.store = store;
        this.executor = executor;
    }

    public void retry(long crossRefId) {
        store.resetToPending(crossRefId);
        executor.poll(10);
    }

    public void manualReconcile(long crossRefId, Instant reconciledAt) {
        store.markDelivered(crossRefId, reconciledAt);
    }
}
