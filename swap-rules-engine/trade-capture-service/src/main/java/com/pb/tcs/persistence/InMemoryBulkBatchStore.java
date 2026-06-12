package com.pb.tcs.persistence;

import com.pb.tcs.manual.BulkBatchStore;
import com.pb.tcs.manual.BulkUploadService;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/** In-memory {@link BulkBatchStore} for F8 tests. */
public final class InMemoryBulkBatchStore implements BulkBatchStore {

    private record Batch(
            String batchId,
            String uploadedBy,
            Instant uploadedAt,
            int totalRows,
            int validRows,
            int invalidRows,
            int submittedRows) {}

    private record Row(String batchId, int rowNo, String blockId, String status, String error) {}

    private final Map<String, Batch> batches = new LinkedHashMap<>();
    private final Map<String, Row> rows = new LinkedHashMap<>();

    @Override
    public void createBatch(
            String batchId, String uploadedBy, int totalRows, int validRows, int invalidRows) {
        batches.put(
                batchId,
                new Batch(batchId, uploadedBy, Instant.now(), totalRows, validRows, invalidRows, 0));
    }

    @Override
    public void recordRow(String batchId, int rowNo, String blockId, boolean valid, String error) {
        rows.put(
                key(batchId, rowNo),
                new Row(batchId, rowNo, blockId, valid ? "VALIDATED" : "INVALID", error));
    }

    @Override
    public void markSubmitted(String batchId, int rowNo) {
        Row row = rows.get(key(batchId, rowNo));
        if (row != null) {
            rows.put(key(batchId, rowNo), new Row(batchId, rowNo, row.blockId(), "SUBMITTED", row.error()));
        }
        Batch batch = batches.get(batchId);
        if (batch != null) {
            batches.put(
                    batchId,
                    new Batch(
                            batch.batchId(),
                            batch.uploadedBy(),
                            batch.uploadedAt(),
                            batch.totalRows(),
                            batch.validRows(),
                            batch.invalidRows(),
                            batch.submittedRows() + 1));
        }
    }

    @Override
    public void updateRowStatus(String batchId, int rowNo, String status) {
        Row row = rows.get(key(batchId, rowNo));
        if (row != null) {
            rows.put(key(batchId, rowNo), new Row(batchId, rowNo, row.blockId(), status, row.error()));
        }
    }

    @Override
    public Optional<String> blockIdForRow(String batchId, int rowNo) {
        Row row = rows.get(key(batchId, rowNo));
        return row == null ? Optional.empty() : Optional.ofNullable(row.blockId());
    }

    @Override
    public List<Integer> submittedRowNumbers(String batchId) {
        return rows.values().stream()
                .filter(r -> r.batchId().equals(batchId))
                .map(Row::rowNo)
                .sorted()
                .toList();
    }

    @Override
    public BulkUploadService.BatchStatus status(String batchId) {
        Batch batch = batches.get(batchId);
        if (batch == null) {
            throw new IllegalArgumentException("unknown batch " + batchId);
        }
        Map<String, Long> rollup =
                rows.values().stream()
                        .filter(r -> r.batchId().equals(batchId))
                        .collect(Collectors.groupingBy(Row::status, Collectors.counting()));
        return new BulkUploadService.BatchStatus(
                batchId,
                batch.totalRows(),
                batch.validRows(),
                batch.invalidRows(),
                batch.submittedRows(),
                rollup);
    }

    private static String key(String batchId, int rowNo) {
        return batchId + "|" + rowNo;
    }
}
