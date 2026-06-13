package com.pb.tcs.manual;

import com.pb.tcs.config.ApprovalWorkflowConfig;
import com.pb.tcs.validation.MandatoryFieldValidator;
import com.pb.tcs.validation.ProtoStructuralValidator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/** FR-504 synchronous bulk CSV validation + batch tracking. */
public final class BulkUploadService {

    private static final List<String> HEADERS =
            List.of(
                    "block_id",
                    "allocation_id",
                    "book",
                    "client_account",
                    "security_id",
                    "trade_date",
                    "quantity",
                    "direction",
                    "exchange",
                    "asset_type",
                    "type");

    private final MandatoryFieldValidator mandatory = new MandatoryFieldValidator();
    private final BulkBatchStore batchStore;
    private final ApprovalWorkflowConfig config;

    public BulkUploadService(BulkBatchStore batchStore, ApprovalWorkflowConfig config) {
        this.batchStore = batchStore;
        this.config = config;
    }

    public UploadReport validateUpload(String csv, String uploadedBy) {
        if (csv.lines().count() - 1 > config.bulkMaxRows()) {
            throw new IllegalArgumentException("bulk upload exceeds max rows " + config.bulkMaxRows());
        }
        String batchId = "BATCH-" + UUID.randomUUID();
        List<String> lines = csv.lines().toList();
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("empty upload");
        }
        String[] header = lines.get(0).split(",");
        Map<String, Integer> idx = index(header);
        List<RowResult> rows = new ArrayList<>();
        int valid = 0;
        int invalid = 0;
        for (int i = 1; i < lines.size(); i++) {
            String[] cols = lines.get(i).split(",", -1);
            var builder =
                    com.pb.tcs.proto.allocation.v1.AllocationMessage.newBuilder()
                            .setBlockId(value(cols, idx, "block_id", "MAN-" + batchId + "-" + i))
                            .setAllocationId(value(cols, idx, "allocation_id", "ALL-" + i))
                            .setVersion(1)
                            .setGcamMessageId("MAN-" + batchId + "-" + i)
                            .setBook(value(cols, idx, "book", "EQ_US_HY"))
                            .setClientAccount(value(cols, idx, "client_account", "CLI-9"))
                            .setSecurityId(value(cols, idx, "security_id", "SEC-AAPL"))
                            .setTradeDate(value(cols, idx, "trade_date", "2026-06-10"))
                            .setQuantity(parseDouble(value(cols, idx, "quantity", "1000")))
                            .setDirection(value(cols, idx, "direction", "BUY"))
                            .setExchange(value(cols, idx, "exchange", "XNYS"))
                            .setAssetType(value(cols, idx, "asset_type", "SINGLE_STOCK"))
                            .setType(
                                    com.pb.tcs.proto.allocation.v1.AllocationType.valueOf(
                                            value(cols, idx, "type", "SWAP")))
                            .setSource(com.pb.tcs.proto.allocation.v1.SourceSystem.MANUAL);
            var allocation = builder.build();
            List<String> violations = mandatory.validate(allocation);
            ProtoStructuralValidator.Result parsed =
                    new ProtoStructuralValidator(1).parse(buildEnvelope(allocation).toByteArray());
            if (parsed instanceof ProtoStructuralValidator.Malformed m) {
                violations = List.of(m.reason());
            }
            boolean ok = violations.isEmpty();
            if (ok) {
                valid++;
            } else {
                invalid++;
            }
            rows.add(new RowResult(i, allocation.getBlockId(), ok, String.join("; ", violations)));
            batchStore.recordRow(batchId, i, allocation.getBlockId(), ok, ok ? null : violations.get(0));
        }
        batchStore.createBatch(batchId, uploadedBy, rows.size(), valid, invalid);
        return new UploadReport(batchId, rows, valid, invalid);
    }

    public BatchStatus status(String batchId) {
        return batchStore.status(batchId);
    }

    private static com.pb.tcs.proto.allocation.v1.TcsIngressMessage buildEnvelope(
            com.pb.tcs.proto.allocation.v1.AllocationMessage allocation) {
        return com.pb.tcs.proto.allocation.v1.TcsIngressMessage.newBuilder()
                .setMessageId("validate")
                .setSource(com.pb.tcs.proto.allocation.v1.SourceSystem.MANUAL)
                .setBook(allocation.getBook())
                .setAccountId(allocation.getClientAccount())
                .setSecurityId(allocation.getSecurityId())
                .setAllocation(allocation)
                .build();
    }

    private static Map<String, Integer> index(String[] header) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < header.length; i++) {
            map.put(header[i].trim().toLowerCase(), i);
        }
        return map;
    }

    private static String value(String[] cols, Map<String, Integer> idx, String key, String fallback) {
        Integer i = idx.get(key);
        if (i == null || i >= cols.length || cols[i].isBlank()) {
            return fallback;
        }
        return cols[i].trim();
    }

    private static double parseDouble(String text) {
        return Double.parseDouble(text);
    }

    public record RowResult(int rowNo, String blockId, boolean valid, String error) {}

    public record UploadReport(String batchId, List<RowResult> rows, int validCount, int invalidCount) {}

    public record BatchStatus(
            String batchId,
            int totalRows,
            int validRows,
            int invalidRows,
            int submittedRows,
            Map<String, Long> statusRollup) {}
}
