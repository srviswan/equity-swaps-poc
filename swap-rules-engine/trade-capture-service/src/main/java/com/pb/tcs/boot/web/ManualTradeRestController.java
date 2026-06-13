package com.pb.tcs.boot.web;

import com.pb.tcs.api.ManualTradeApi;
import com.pb.tcs.approval.ApprovalCallbackHandler;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
class ManualTradeRestController {

    private final ManualTradeApi manualTradeApi;

    ManualTradeRestController(ManualTradeApi manualTradeApi) {
        this.manualTradeApi = manualTradeApi;
    }

    @PostMapping("/manual-trades/preview")
    com.pb.tcs.manual.ManualTradePreviewService.PreviewResult preview(
            @RequestBody PreviewRequest request) {
        return manualTradeApi.preview(request.allocation(), request.initiatedBy());
    }

    @PostMapping("/manual-trades")
    com.pb.tcs.manual.ManualTradeSubmitService.SubmitResult submit(
            @RequestBody SubmitRequest request) {
        return manualTradeApi.submitRaw(request.allocation(), request.initiatedBy(), request.batchId());
    }

    @PostMapping("/manual-trades/bulk")
    com.pb.tcs.manual.BulkUploadService.UploadReport bulkUpload(
            @RequestBody BulkRequest request) {
        return manualTradeApi.bulkUpload(request.csv(), request.uploadedBy());
    }

    @GetMapping("/manual-trades/bulk/{batchId}")
    com.pb.tcs.manual.BulkUploadService.BatchStatus bulkStatus(@PathVariable String batchId) {
        return manualTradeApi.bulkStatus(batchId);
    }

    @PostMapping("/approvals/callback")
    ApprovalCallbackHandler.CallbackResult approvalCallback(
            @RequestBody ApprovalCallbackHandler.ApprovalCallback callback) {
        return manualTradeApi.approvalCallback(callback);
    }

    record PreviewRequest(EnrichedAllocation allocation, String initiatedBy) {}

    record SubmitRequest(AllocationMessage allocation, String initiatedBy, String batchId) {}

    record BulkRequest(String csv, String uploadedBy) {}
}
