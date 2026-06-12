package com.pb.tcs.rules;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.AllocationType;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class AllocationTradeMapperTest {

    @Test
    void mapsIdentityDimensionsAndAttributeBag() {
        RawHedgeTrade raw =
                AllocationTradeMapper.toRawHedgeTrade(
                        F3Fixtures.usNyseSwap("BLK-1", 3, "2026-06-10"));

        assertThat(raw.tradeId()).isEqualTo("BLK-1/ALL-1/3");
        assertThat(raw.productType()).isEqualTo("EQUITY_SWAP");
        assertThat(raw.book()).isEqualTo("EQ_US_HY");
        assertThat(raw.source()).isEqualTo("GCAM");
        assertThat(raw.securityId()).isEqualTo("SEC-AAPL");
        assertThat(raw.tradeDate()).isEqualTo(LocalDate.of(2026, 6, 10));
        assertThat(raw.notional()).isEqualByComparingTo(BigDecimal.valueOf(1000));
        assertThat(raw.attributes())
                .containsEntry("exchange", "NYSE")
                .containsEntry("location", "US")
                .containsEntry("assetType", "SINGLE_STOCK")
                .containsEntry("clientMasterNo", "H12456")
                .containsEntry("clientAccount", "CLI-9")
                .containsEntry("direction", "BUY")
                .containsEntry("allocationType", "SWAP")
                .containsEntry("b2bLeg", false);
    }

    @Test
    void extendedAttributesSupplyEngineDimensionsAndFlowThrough() {
        AllocationMessage alloc =
                F3Fixtures.usNyseSwap("BLK-2", 1, "2026-06-10").message().toBuilder()
                        .putExtendedAttributes("currency", "USD")
                        .putExtendedAttributes("clientTier", "PLATINUM")
                        .putExtendedAttributes("notional", "250000.50")
                        .putExtendedAttributes("gcamDesk", "DESK-7")
                        // collides with an explicit field: explicit must win
                        .putExtendedAttributes("exchange", "OVERRIDE-IGNORED")
                        .build();
        TcsIngressMessage env =
                F3Fixtures.usNyseSwap("BLK-2", 1, "2026-06-10").envelope().toBuilder()
                        .setAllocation(alloc)
                        .build();
        EnrichedAllocation enriched =
                new EnrichedAllocation(env, env.toByteArray(), "{}", "{}", "{}", null);

        RawHedgeTrade raw = AllocationTradeMapper.toRawHedgeTrade(enriched);

        assertThat(raw.currency()).isEqualTo("USD");
        assertThat(raw.clientTier()).isEqualTo("PLATINUM");
        assertThat(raw.notional()).isEqualByComparingTo(new BigDecimal("250000.50"));
        assertThat(raw.attributes())
                .containsEntry("gcamDesk", "DESK-7")
                .containsEntry("exchange", "NYSE");
    }

    @Test
    void blockAllocationWithoutOptionalFieldsMapsCleanly() {
        AllocationMessage alloc =
                AllocationMessage.newBuilder()
                        .setBlockId("BLK-3")
                        .setVersion(1)
                        .setGcamMessageId("GCAM-3")
                        .setType(AllocationType.BLOCK)
                        .setBook("EQ_US_HY")
                        .setSecurityId("SEC-MSFT")
                        .setTradeDate("2026-06-10")
                        .setQuantity(500)
                        .build();
        TcsIngressMessage env =
                TcsIngressMessage.newBuilder()
                        .setMessageId("M-3")
                        .setSource(SourceSystem.GCAM)
                        .setBook("EQ_US_HY")
                        .setAccountId("WASH-1")
                        .setSecurityId("SEC-MSFT")
                        .setAllocation(alloc)
                        .build();
        EnrichedAllocation enriched =
                new EnrichedAllocation(
                        env, env.toByteArray(), "{}", null, "{}", "{\"washBook\":\"WASH-1\"}");

        RawHedgeTrade raw = AllocationTradeMapper.toRawHedgeTrade(enriched);

        assertThat(raw.currency()).isNull();
        assertThat(raw.clientTier()).isNull();
        assertThat(raw.attributes())
                .containsEntry("allocationType", "BLOCK")
                .containsEntry("washBookRef", "{\"washBook\":\"WASH-1\"}")
                .doesNotContainKeys("clientAccount", "exchange", "location", "clientMasterNo");
    }
}
