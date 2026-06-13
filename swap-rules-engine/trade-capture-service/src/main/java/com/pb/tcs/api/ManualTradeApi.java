package com.pb.tcs.api;

import com.pb.tcs.approval.ApprovalCallbackHandler;
import com.pb.tcs.manual.BulkUploadService;
import com.pb.tcs.manual.ManualTradePreviewService;
import com.pb.tcs.manual.ManualTradeSubmitService;

/** FR-500–506 / FR-303 REST contract surface (transport wired in a later phase). */
public final class ManualTradeApi {

    private final ManualTradePreviewService previewService;
    private final ManualTradeSubmitService submitService;
    private final BulkUploadService bulkUploadService;
    private final ApprovalCallbackHandler approvalCallbackHandler;

    public ManualTradeApi(
            ManualTradePreviewService previewService,
            ManualTradeSubmitService submitService,
            BulkUploadService bulkUploadService,
            ApprovalCallbackHandler approvalCallbackHandler) {
        this.previewService = previewService;
        this.submitService = submitService;
        this.bulkUploadService = bulkUploadService;
        this.approvalCallbackHandler = approvalCallbackHandler;
    }

    public ManualTradePreviewService.PreviewResult preview(
            com.pb.tcs.ingress.EnrichedAllocation allocation, String initiatedBy) {
        return previewService.preview(allocation, initiatedBy);
    }

    public ManualTradeSubmitService.SubmitResult submitRaw(
            com.pb.tcs.proto.allocation.v1.AllocationMessage allocation, String initiatedBy, String batchId) {
        return submitService.submitRawAllocation(allocation, initiatedBy, batchId);
    }

    public BulkUploadService.UploadReport bulkUpload(String csv, String uploadedBy) {
        return bulkUploadService.validateUpload(csv, uploadedBy);
    }

    public BulkUploadService.BatchStatus bulkStatus(String batchId) {
        return bulkUploadService.status(batchId);
    }

    public ApprovalCallbackHandler.CallbackResult approvalCallback(
            ApprovalCallbackHandler.ApprovalCallback callback) {
        return approvalCallbackHandler.handle(callback);
    }
}
