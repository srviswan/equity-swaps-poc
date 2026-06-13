package com.pb.tcs.validation;

import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.AllocationType;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Stage-1 mandatory-field gate, per allocation type (D8: same schema, different required fields).
 * A non-empty result maps to NACK + {@code audit_reject(MANDATORY)} (spec §F1.2).
 */
public final class MandatoryFieldValidator {

    /** @return empty when valid; otherwise one human-readable reason per violation */
    public List<String> validate(AllocationMessage msg) {
        List<String> reasons = new ArrayList<>();

        requireText(reasons, msg.getBlockId(), "block_id");
        if (msg.getVersion() < 1) {
            reasons.add("version must be >= 1, was " + msg.getVersion());
        }
        requireText(reasons, msg.getGcamMessageId(), "gcam_message_id");
        if (msg.getType() == AllocationType.ALLOCATION_TYPE_UNSPECIFIED) {
            reasons.add("type must be BLOCK or SWAP");
        }
        requireText(reasons, msg.getBook(), "book");
        requireText(reasons, msg.getSecurityId(), "security_id");
        validateTradeDate(reasons, msg.getTradeDate());
        if (msg.getQuantity() == 0) {
            reasons.add("quantity must be non-zero");
        }
        requireText(reasons, msg.getDirection(), "direction");

        if (msg.getType() == AllocationType.SWAP) {
            requireText(reasons, msg.getClientAccount(), "client_account");
            requireText(reasons, msg.getAllocationId(), "allocation_id");
        }
        return reasons;
    }

    private static void validateTradeDate(List<String> reasons, String tradeDate) {
        if (tradeDate.isBlank()) {
            reasons.add("trade_date is mandatory");
            return;
        }
        try {
            LocalDate.parse(tradeDate);
        } catch (DateTimeParseException e) {
            reasons.add("trade_date must be ISO-8601 (yyyy-MM-dd), was '" + tradeDate + "'");
        }
    }

    private static void requireText(List<String> reasons, String value, String field) {
        if (value.isBlank()) {
            reasons.add(field + " is mandatory");
        }
    }
}
