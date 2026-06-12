package com.pb.tcs.approval;

import java.util.ArrayList;
import java.util.List;

/** Test double recording Approval Service submissions. */
public final class RecordingApprovalServiceClient implements ApprovalServiceClient {

    private final List<ApprovalRequest> trades = new ArrayList<>();
    private final List<BatchApprovalRequest> batches = new ArrayList<>();

    @Override
    public void submitTrade(ApprovalRequest request) {
        trades.add(request);
    }

    @Override
    public void submitBatch(BatchApprovalRequest request) {
        batches.add(request);
    }

    public List<ApprovalRequest> trades() {
        return List.copyOf(trades);
    }

    public List<BatchApprovalRequest> batches() {
        return List.copyOf(batches);
    }
}
