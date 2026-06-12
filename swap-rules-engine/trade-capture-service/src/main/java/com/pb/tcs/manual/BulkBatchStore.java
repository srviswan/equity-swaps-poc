package com.pb.tcs.manual;

import java.util.Map;

/** Persistence port for bulk upload batches (FR-504/506). */
public interface BulkBatchStore {

    void createBatch(String batchId, String uploadedBy, int totalRows, int validRows, int invalidRows);

    void recordRow(String batchId, int rowNo, String blockId, boolean valid, String error);

    void markSubmitted(String batchId, int rowNo);

    void updateRowStatus(String batchId, int rowNo, String status);

    BulkUploadService.BatchStatus status(String batchId);
}
