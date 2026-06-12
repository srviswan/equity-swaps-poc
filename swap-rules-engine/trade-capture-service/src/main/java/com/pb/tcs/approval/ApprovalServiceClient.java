package com.pb.tcs.approval;

import java.util.List;

/** Outbound port to the Approval Service (arch §15.1 / E4). */
public interface ApprovalServiceClient {

    void submitTrade(ApprovalRequest request);

    void submitBatch(BatchApprovalRequest request);

    record ApprovalRequest(
            String approvalId,
            String ingestionId,
            String initiatedBy,
            String publishMode,
            String blotterJson,
            List<EditedFieldDiff> editedFieldsDiff,
            String respondByUtc) {}

    record BatchApprovalRequest(
            String approvalId,
            String batchId,
            String initiatedBy,
            int rowCount,
            List<String> books,
            String grossNotional,
            String respondByUtc) {}

    record EditedFieldDiff(String field, String ruleDefault, String edited) {}
}
