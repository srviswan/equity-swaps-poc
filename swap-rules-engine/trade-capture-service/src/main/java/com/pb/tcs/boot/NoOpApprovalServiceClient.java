package com.pb.tcs.boot;

import com.pb.tcs.approval.ApprovalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Demo stub — logs approval submissions without an external Approval Service. */
final class NoOpApprovalServiceClient implements ApprovalServiceClient {

    private static final Logger log = LoggerFactory.getLogger(NoOpApprovalServiceClient.class);

    @Override
    public void submitTrade(ApprovalRequest request) {
        log.info("demo approval trade submitted: {}", request.approvalId());
    }

    @Override
    public void submitBatch(BatchApprovalRequest request) {
        log.info("demo approval batch submitted: {} rows={}", request.approvalId(), request.rowCount());
    }
}
