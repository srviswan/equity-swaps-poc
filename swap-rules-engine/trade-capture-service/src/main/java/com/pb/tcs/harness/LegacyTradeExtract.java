package com.pb.tcs.harness;

/**
 * Row from a legacy trade DB extract used to synthesize ingress messages (FR-606).
 */
public record LegacyTradeExtract(
        String messageId,
        String blockId,
        String allocationId,
        int version,
        String gcamMessageId,
        String allocationType,
        String book,
        String clientAccount,
        String securityId,
        String tradeDate,
        long quantity,
        String direction,
        String exchange,
        String assetType,
        String location,
        String clientMasterNo,
        String initiatedBy) {

    public static LegacyTradeExtract goldenUsNyse(String blockId, int version, String tradeDate) {
        return goldenUsNyse(blockId, version, tradeDate, "H12456");
    }

    public static LegacyTradeExtract goldenUsNyse(
            String blockId, int version, String tradeDate, String clientMasterNo) {
        return new LegacyTradeExtract(
                "M-" + blockId + "-" + version,
                blockId,
                "ALL-1",
                version,
                "GCAM-" + blockId + "-" + version,
                "SWAP",
                "EQ_US_HY",
                "CLI-9",
                "SEC-AAPL",
                tradeDate,
                1000,
                "BUY",
                "NYSE",
                "SINGLE_STOCK",
                "US",
                clientMasterNo,
                "SYSTEM");
    }
}
