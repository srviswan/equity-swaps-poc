package com.pb.tcs.validation;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.AllocationType;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import org.junit.jupiter.api.Test;

/**
 * Stage-1 structural gate (spec §F1.1 ProtoStructuralValidator): parse + payload-kind presence +
 * schema_version gate. Failures map to the NACK row {@code audit_reject(STRUCTURAL)} in F1.2.
 */
class ProtoStructuralValidatorTest {

    private final ProtoStructuralValidator validator = new ProtoStructuralValidator(1);

    @Test
    void parsesWellFormedAllocationEnvelope() {
        TcsIngressMessage msg =
                TcsIngressMessage.newBuilder()
                        .setMessageId("M-1")
                        .setSource(SourceSystem.GCAM)
                        .setBook("EQ_US_HY")
                        .setAccountId("CLI-9")
                        .setSecurityId("SEC-AAPL")
                        .setAllocation(
                                AllocationMessage.newBuilder()
                                        .setBlockId("BLK-1")
                                        .setVersion(1)
                                        .setType(AllocationType.SWAP)
                                        .setSchemaVersion(1))
                        .build();

        ProtoStructuralValidator.Result result = validator.parse(msg.toByteArray());

        assertThat(result).isInstanceOf(ProtoStructuralValidator.Parsed.class);
        TcsIngressMessage parsed = ((ProtoStructuralValidator.Parsed) result).message();
        assertThat(parsed.getAllocation().getBlockId()).isEqualTo("BLK-1");
    }

    @Test
    void garbageBytesAreMalformed() {
        ProtoStructuralValidator.Result result =
                validator.parse(new byte[] {(byte) 0xFF, 0x00, 0x13, 0x37});

        assertThat(result).isInstanceOf(ProtoStructuralValidator.Malformed.class);
        assertThat(((ProtoStructuralValidator.Malformed) result).reason()).contains("parse");
    }

    @Test
    void missingPayloadKindIsMalformed() {
        TcsIngressMessage noPayload =
                TcsIngressMessage.newBuilder().setMessageId("M-2").setBook("EQ_US_HY").build();

        ProtoStructuralValidator.Result result = validator.parse(noPayload.toByteArray());

        assertThat(result).isInstanceOf(ProtoStructuralValidator.Malformed.class);
        assertThat(((ProtoStructuralValidator.Malformed) result).reason()).contains("payload");
    }

    @Test
    void unsupportedSchemaVersionIsMalformed() {
        TcsIngressMessage future =
                TcsIngressMessage.newBuilder()
                        .setMessageId("M-3")
                        .setAllocation(
                                AllocationMessage.newBuilder()
                                        .setBlockId("BLK-1")
                                        .setVersion(1)
                                        .setType(AllocationType.SWAP)
                                        .setSchemaVersion(99))
                        .build();

        ProtoStructuralValidator.Result result = validator.parse(future.toByteArray());

        assertThat(result).isInstanceOf(ProtoStructuralValidator.Malformed.class);
        assertThat(((ProtoStructuralValidator.Malformed) result).reason())
                .contains("schema_version");
    }

    @Test
    void schemaVersionZeroIsTreatedAsVersionOneForBackCompat() {
        // GCAM messages published before the field existed carry the proto3 default (0).
        TcsIngressMessage legacy =
                TcsIngressMessage.newBuilder()
                        .setMessageId("M-4")
                        .setAllocation(
                                AllocationMessage.newBuilder()
                                        .setBlockId("BLK-1")
                                        .setVersion(1)
                                        .setType(AllocationType.SWAP))
                        .build();

        assertThat(validator.parse(legacy.toByteArray()))
                .isInstanceOf(ProtoStructuralValidator.Parsed.class);
    }
}
