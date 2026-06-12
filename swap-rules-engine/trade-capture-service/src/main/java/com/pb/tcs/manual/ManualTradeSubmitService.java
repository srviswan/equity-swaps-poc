package com.pb.tcs.manual;

import com.pb.tcs.ingress.IngressPublisher;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.SwapBlotterPayload;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import com.pb.tcs.rules.BlotterJson;
import com.pb.tcs.rules.SwapBlotter;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/** FR-501 dual publish mode to the partitioned ingress topic. */
public final class ManualTradeSubmitService {

    public enum PublishMode {
        RAW_ALLOCATION,
        SWAP_BLOTTER
    }

    private final IngressPublisher publisher;

    public ManualTradeSubmitService(IngressPublisher publisher) {
        this.publisher = publisher;
    }

    public SubmitResult submitRawAllocation(
            AllocationMessage allocation, String initiatedBy, String batchId) {
        TcsIngressMessage envelope =
                TcsIngressMessage.newBuilder()
                        .setMessageId("MAN-" + UUID.randomUUID())
                        .setSource(SourceSystem.MANUAL)
                        .setBook(allocation.getBook())
                        .setAccountId(
                                allocation.getClientAccount().isBlank()
                                        ? allocation.getBook()
                                        : allocation.getClientAccount())
                        .setSecurityId(allocation.getSecurityId())
                        .setInitiatedBy(initiatedBy)
                        .setAllocation(allocation)
                        .build();
        publisher.publish(envelope, envelope.toByteArray());
        return new SubmitResult(envelope.getMessageId(), PublishMode.RAW_ALLOCATION.name());
    }

    public SubmitResult submitSwapBlotter(SwapBlotter blotter, String initiatedBy, String previewHash) {
        TcsIngressMessage envelope =
                TcsIngressMessage.newBuilder()
                        .setMessageId("MAN-BLT-" + UUID.randomUUID())
                        .setSource(SourceSystem.MANUAL)
                        .setBook(blotter.book())
                        .setAccountId(blotter.accountId())
                        .setSecurityId(blotter.securityId())
                        .setInitiatedBy(initiatedBy)
                        .setManualBlotter(
                                SwapBlotterPayload.newBuilder()
                                        .setBlotterId(blotter.correlationId())
                                        .setPreviewHash(previewHash)
                                        .setBlotterJson(
                                                com.google.protobuf.ByteString.copyFrom(
                                                        BlotterJson.toJson(blotter),
                                                        StandardCharsets.UTF_8))
                                        .setTradeDate(blotter.tradeDate().toString())
                                        .setSchemaVersion(1)
                                        .build())
                        .build();
        publisher.publish(envelope, envelope.toByteArray());
        return new SubmitResult(envelope.getMessageId(), PublishMode.SWAP_BLOTTER.name());
    }

    public record SubmitResult(String messageId, String publishMode) {}
}
