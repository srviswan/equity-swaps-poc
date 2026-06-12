package com.pb.tcs.harness;

import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.AllocationType;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.util.List;
import java.util.stream.Stream;

/**
 * FR-606: synthesizes {@link TcsIngressMessage} payloads from legacy trade extracts and golden
 * fixture allocations for parity / soak / spike suites.
 */
public final class IngressHarnessPublisher {

    private IngressHarnessPublisher() {}

    public static TcsIngressMessage fromLegacyExtract(LegacyTradeExtract extract) {
        AllocationMessage allocation =
                AllocationMessage.newBuilder()
                        .setBlockId(extract.blockId())
                        .setAllocationId(extract.allocationId())
                        .setVersion(extract.version())
                        .setGcamMessageId(extract.gcamMessageId())
                        .setType(AllocationType.valueOf(extract.allocationType()))
                        .setSource(SourceSystem.GCAM)
                        .setBook(extract.book())
                        .setClientAccount(extract.clientAccount())
                        .setSecurityId(extract.securityId())
                        .setTradeDate(extract.tradeDate())
                        .setQuantity(extract.quantity())
                        .setDirection(extract.direction())
                        .setExchange(extract.exchange())
                        .setAssetType(extract.assetType())
                        .setLocation(extract.location())
                        .setClientMasterNo(extract.clientMasterNo())
                        .setSchemaVersion(1)
                        .build();
        return TcsIngressMessage.newBuilder()
                .setMessageId(extract.messageId())
                .setSource(SourceSystem.GCAM)
                .setBook(extract.book())
                .setAccountId(extract.clientAccount())
                .setSecurityId(extract.securityId())
                .setInitiatedBy(extract.initiatedBy())
                .setAllocation(allocation)
                .build();
    }

    public static EnrichedAllocation toEnrichedAllocation(LegacyTradeExtract extract) {
        TcsIngressMessage message = fromLegacyExtract(extract);
        return new EnrichedAllocation(
                message,
                message.toByteArray(),
                "{\"securityId\":\"" + extract.securityId() + "\"}",
                "{\"clientAccount\":\"" + extract.clientAccount() + "\"}",
                "{\"book\":\"" + extract.book() + "\"}",
                null);
    }

    public static TcsIngressMessage fromGoldenAllocation(EnrichedAllocation allocation) {
        return allocation.envelope();
    }

    public static Stream<TcsIngressMessage> fromLegacyExtracts(List<LegacyTradeExtract> extracts) {
        return extracts.stream().map(IngressHarnessPublisher::fromLegacyExtract);
    }
}
