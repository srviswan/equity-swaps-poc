package com.pb.tcs.validation;

import com.google.protobuf.InvalidProtocolBufferException;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;

/**
 * Stage-1 structural gate: proto parse + payload-kind presence + schema_version ceiling. A
 * {@link Malformed} outcome maps to NACK + {@code audit_reject(STRUCTURAL)} (spec §F1.2).
 */
public final class ProtoStructuralValidator {

    public sealed interface Result permits Parsed, Malformed {}

    public record Parsed(TcsIngressMessage message) implements Result {}

    public record Malformed(String reason) implements Result {}

    private final int maxSupportedSchemaVersion;

    public ProtoStructuralValidator(int maxSupportedSchemaVersion) {
        this.maxSupportedSchemaVersion = maxSupportedSchemaVersion;
    }

    public Result parse(byte[] raw) {
        TcsIngressMessage message;
        try {
            message = TcsIngressMessage.parseFrom(raw);
        } catch (InvalidProtocolBufferException e) {
            return new Malformed("proto parse failure: " + e.getMessage());
        }
        if (message.getPayloadCase() == TcsIngressMessage.PayloadCase.PAYLOAD_NOT_SET) {
            return new Malformed("payload kind not set (allocation | manual_blotter | approval_resume)");
        }
        int schemaVersion = schemaVersionOf(message);
        // 0 = field absent on pre-versioning publishers; treated as v1.
        if (schemaVersion > maxSupportedSchemaVersion) {
            return new Malformed(
                    "unsupported schema_version %d (max %d)"
                            .formatted(schemaVersion, maxSupportedSchemaVersion));
        }
        return new Parsed(message);
    }

    private static int schemaVersionOf(TcsIngressMessage message) {
        return switch (message.getPayloadCase()) {
            case ALLOCATION -> message.getAllocation().getSchemaVersion();
            case MANUAL_BLOTTER -> message.getManualBlotter().getSchemaVersion();
            case APPROVAL_RESUME, PAYLOAD_NOT_SET -> 0;
        };
    }
}
