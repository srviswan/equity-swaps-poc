package com.pb.tcs.proto;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.AllocationType;
import com.pb.tcs.proto.allocation.v1.ApprovalResume;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.SwapBlotterPayload;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import com.google.protobuf.ByteString;
import org.junit.jupiter.api.Test;

/**
 * F0.1 contract: the {@code TcsIngressMessage} envelope round-trips on the wire and its field
 * numbers stay frozen (spec §F0.1 — "do not change field numbers").
 */
class ProtoContractTest {

    @Test
    void allocationPayloadRoundTripsOnTheWire() throws Exception {
        AllocationMessage allocation =
                AllocationMessage.newBuilder()
                        .setBlockId("BLK-1")
                        .setAllocationId("ALL-7")
                        .setVersion(3)
                        .setGcamMessageId("GCAM-MSG-42")
                        .setType(AllocationType.SWAP)
                        .setSource(SourceSystem.GCAM)
                        .setBook("EQ_US_HY")
                        .setClientAccount("CLI-9")
                        .setSecurityId("SEC-AAPL")
                        .setTradeDate("2026-06-10")
                        .setQuantity(125_000d)
                        .setDirection("LONG")
                        .setExchange("NYSE")
                        .setAssetType("SINGLE_STOCK")
                        .setB2BLeg(true)
                        .setClientMasterNo("H12456")
                        .setLocation("US")
                        .putExtendedAttributes("unmappedField", "value") // E8 overflow
                        .setSchemaVersion(1)
                        .build();

        TcsIngressMessage envelope =
                TcsIngressMessage.newBuilder()
                        .setMessageId("MSG-1")
                        .setSource(SourceSystem.GCAM)
                        .setBook("EQ_US_HY")
                        .setAccountId("CLI-9")
                        .setSecurityId("SEC-AAPL")
                        .setInitiatedBy("SYSTEM")
                        .setAllocation(allocation)
                        .build();

        TcsIngressMessage parsed = TcsIngressMessage.parseFrom(envelope.toByteArray());

        assertThat(parsed).isEqualTo(envelope);
        assertThat(parsed.getPayloadCase()).isEqualTo(TcsIngressMessage.PayloadCase.ALLOCATION);
        assertThat(parsed.getAllocation().getVersion()).isEqualTo(3);
        assertThat(parsed.getAllocation().getExtendedAttributesMap())
                .containsEntry("unmappedField", "value");
    }

    @Test
    void manualBlotterPayloadSelectsItsOneofKind() {
        TcsIngressMessage envelope =
                TcsIngressMessage.newBuilder()
                        .setMessageId("MSG-2")
                        .setSource(SourceSystem.MANUAL)
                        .setInitiatedBy("ta_jsmith")
                        .setManualBlotter(
                                SwapBlotterPayload.newBuilder()
                                        .setBlotterId("BLT-1")
                                        .setPreviewHash("abc123")
                                        .setBlotterJson(ByteString.copyFromUtf8("{}"))
                                        .setTradeDate("2026-06-10")
                                        .setSchemaVersion(1))
                        .build();

        assertThat(envelope.getPayloadCase())
                .isEqualTo(TcsIngressMessage.PayloadCase.MANUAL_BLOTTER);
        assertThat(envelope.getInitiatedBy()).isEqualTo("ta_jsmith");
    }

    @Test
    void approvalResumePayloadSelectsItsOneofKind() throws Exception {
        TcsIngressMessage envelope =
                TcsIngressMessage.newBuilder()
                        .setMessageId("MSG-3")
                        .setSource(SourceSystem.MANUAL)
                        .setApprovalResume(
                                ApprovalResume.newBuilder()
                                        .setIngestionId("ING-99")
                                        .setApprovalId("APR-5")
                                        .setApprovedBy("trader_1")
                                        .setApprovedAtUtc("2026-06-10T11:00:00Z"))
                        .build();

        TcsIngressMessage parsed = TcsIngressMessage.parseFrom(envelope.toByteArray());

        assertThat(parsed.getPayloadCase())
                .isEqualTo(TcsIngressMessage.PayloadCase.APPROVAL_RESUME);
        assertThat(parsed.getApprovalResume().getIngestionId()).isEqualTo("ING-99");
    }

    @Test
    void wireFieldNumbersAreFrozen() {
        var envelope = TcsIngressMessage.getDescriptor();
        assertThat(envelope.findFieldByName("message_id").getNumber()).isEqualTo(1);
        assertThat(envelope.findFieldByName("initiated_by").getNumber()).isEqualTo(6);
        assertThat(envelope.findFieldByName("allocation").getNumber()).isEqualTo(10);
        assertThat(envelope.findFieldByName("manual_blotter").getNumber()).isEqualTo(11);
        assertThat(envelope.findFieldByName("approval_resume").getNumber()).isEqualTo(12);

        var allocation = AllocationMessage.getDescriptor();
        assertThat(allocation.findFieldByName("version").getNumber()).isEqualTo(3);
        assertThat(allocation.findFieldByName("key_sequence").getNumber()).isEqualTo(5);
        assertThat(allocation.findFieldByName("extended_attributes").getNumber()).isEqualTo(40);
    }
}
