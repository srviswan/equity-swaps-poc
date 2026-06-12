package com.pb.tcs.rules;

import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.AllocationType;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;

/** Shared builders for F3 tests: a US single-stock NYSE swap allocation. */
public final class F3Fixtures {

    private F3Fixtures() {}

    public static EnrichedAllocation usNyseSwap(String blockId, int version, String tradeDate) {
        return usNyseSwap(blockId, version, tradeDate, "H12456");
    }

    public static EnrichedAllocation usNyseSwap(
            String blockId, int version, String tradeDate, String clientMasterNo) {
        AllocationMessage.Builder alloc =
                AllocationMessage.newBuilder()
                        .setBlockId(blockId)
                        .setAllocationId("ALL-1")
                        .setVersion(version)
                        .setGcamMessageId("GCAM-" + blockId + "-" + version)
                        .setType(AllocationType.SWAP)
                        .setSource(SourceSystem.GCAM)
                        .setBook("EQ_US_HY")
                        .setClientAccount("CLI-9")
                        .setSecurityId("SEC-AAPL")
                        .setTradeDate(tradeDate)
                        .setQuantity(1000)
                        .setDirection("BUY")
                        .setExchange("NYSE")
                        .setAssetType("SINGLE_STOCK")
                        .setLocation("US")
                        .setSchemaVersion(1);
        if (clientMasterNo != null) {
            alloc.setClientMasterNo(clientMasterNo);
        }
        TcsIngressMessage env =
                TcsIngressMessage.newBuilder()
                        .setMessageId("M-" + blockId + "-" + version)
                        .setSource(SourceSystem.GCAM)
                        .setBook("EQ_US_HY")
                        .setAccountId("CLI-9")
                        .setSecurityId("SEC-AAPL")
                        .setInitiatedBy("SYSTEM")
                        .setAllocation(alloc)
                        .build();
        return new EnrichedAllocation(
                env,
                env.toByteArray(),
                "{\"securityId\":\"SEC-AAPL\"}",
                "{\"clientAccount\":\"CLI-9\"}",
                "{\"book\":\"EQ_US_HY\"}",
                null);
    }
}
