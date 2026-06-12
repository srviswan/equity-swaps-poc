package com.pb.tcs.recon;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pb.tcs.parity.ParityFieldComparator;
import com.pb.tcs.parity.ParityFieldMismatch;
import com.pb.tcs.parity.ParityMismatchReport;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** FR-703 / FR-704 field drift classification using the parity manifest. */
public final class ReconFieldClassifier {

    private final ParityFieldComparator comparator;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public ReconFieldClassifier(ParityFieldComparator comparator) {
        this.comparator = comparator;
    }

    public List<BreakType> classifyDrift(ReconRecord tcs, ReconRecord peer) {
        Set<BreakType> breaks = new LinkedHashSet<>();
        ParityMismatchReport report =
                comparator.compareJson(
                        tcs.allocationId() != null ? tcs.allocationId() : tcs.matchKey(),
                        toJson(tcs),
                        toJson(peer));
        for (ParityFieldMismatch mismatch : report.mismatches()) {
            breaks.add(mapField(mismatch.fieldPath()));
        }
        if (tcs.swapRef() != null
                && peer.swapRef() != null
                && !tcs.swapRef().equals(peer.swapRef())) {
            breaks.add(BreakType.REF_MISMATCH);
        }
        if (tcs.lotRef() != null && peer.lotRef() != null && !tcs.lotRef().equals(peer.lotRef())) {
            breaks.add(BreakType.LOT_MISMATCH);
        }
        if (tcs.quantity() != null && peer.quantity() != null && !tcs.quantity().equals(peer.quantity())) {
            breaks.add(BreakType.QTY_MISMATCH);
        }
        if (tcs.status() != null && peer.status() != null && !tcs.status().equals(peer.status())) {
            breaks.add(BreakType.STATUS_MISMATCH);
        }
        return new ArrayList<>(breaks);
    }

    public static boolean autoHealEligible(BreakType type) {
        return switch (type) {
            case REF_MISMATCH, MISSING_IN_A, MISSING_IN_B -> true;
            case QTY_MISMATCH, STATUS_MISMATCH, LOT_MISMATCH, MISSING_IN_TCS, DUPLICATE -> false;
        };
    }

    private static BreakType mapField(String path) {
        if (path == null) {
            return BreakType.REF_MISMATCH;
        }
        if (path.contains("quantity") || path.endsWith("qty")) {
            return BreakType.QTY_MISMATCH;
        }
        if (path.contains("status")) {
            return BreakType.STATUS_MISMATCH;
        }
        if (path.contains("lot")) {
            return BreakType.LOT_MISMATCH;
        }
        if (path.contains("swapRef") || path.contains("swap")) {
            return BreakType.REF_MISMATCH;
        }
        return BreakType.REF_MISMATCH;
    }

    private static JsonNode toJson(ReconRecord record) {
        ObjectNode node = MAPPER.createObjectNode();
        if (record.allocationId() != null) {
            node.put("allocationId", record.allocationId());
        }
        if (record.swapRef() != null) {
            node.put("swapRef", record.swapRef());
        }
        if (record.lotRef() != null) {
            node.put("lotRef", record.lotRef());
        }
        if (record.quantity() != null) {
            node.put("quantity", record.quantity());
        }
        if (record.status() != null) {
            node.put("status", record.status());
        }
        if (record.direction() != null) {
            node.put("direction", record.direction());
        }
        if (record.securityId() != null) {
            node.put("securityId", record.securityId());
        }
        if (record.compareFields() != null) {
            record.compareFields().forEach(node::put);
        }
        return node;
    }
}
