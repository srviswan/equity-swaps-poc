package com.pb.tcs.validation;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.AllocationType;
import org.junit.jupiter.api.Test;

/**
 * Stage-1 mandatory-field gate (spec §F1.1 MandatoryFieldValidator): per-allocation-type field
 * sets. Failures map to the NACK row {@code audit_reject(MANDATORY)} in F1.2.
 */
class MandatoryFieldValidatorTest {

    private final MandatoryFieldValidator validator = new MandatoryFieldValidator();

    private static AllocationMessage.Builder validSwap() {
        return AllocationMessage.newBuilder()
                .setBlockId("BLK-1")
                .setAllocationId("ALL-1")
                .setVersion(1)
                .setGcamMessageId("GCAM-77")
                .setType(AllocationType.SWAP)
                .setBook("EQ_US_HY")
                .setClientAccount("CLI-9")
                .setSecurityId("SEC-AAPL")
                .setTradeDate("2026-06-10")
                .setQuantity(1000)
                .setDirection("BUY");
    }

    @Test
    void validSwapAllocationPasses() {
        assertThat(validator.validate(validSwap().build())).isEmpty();
    }

    @Test
    void validBlockAllocationPassesWithoutClientAccountOrAllocationId() {
        AllocationMessage block =
                validSwap()
                        .setType(AllocationType.BLOCK)
                        .clearClientAccount()
                        .clearAllocationId()
                        .build();

        assertThat(validator.validate(block)).isEmpty();
    }

    @Test
    void swapAllocationRequiresClientAccountAndAllocationId() {
        AllocationMessage swap = validSwap().clearClientAccount().clearAllocationId().build();

        assertThat(validator.validate(swap))
                .anySatisfy(reason -> assertThat(reason).contains("client_account"))
                .anySatisfy(reason -> assertThat(reason).contains("allocation_id"));
    }

    @Test
    void commonMandatoryFieldsReportedTogether() {
        AllocationMessage empty = AllocationMessage.newBuilder().build();

        java.util.List<String> reasons = validator.validate(empty);

        assertThat(String.join(";", reasons))
                .contains("block_id")
                .contains("version")
                .contains("gcam_message_id")
                .contains("type")
                .contains("book")
                .contains("security_id")
                .contains("trade_date")
                .contains("quantity")
                .contains("direction");
    }

    @Test
    void tradeDateMustBeIsoDate() {
        AllocationMessage bad = validSwap().setTradeDate("06/10/2026").build();

        assertThat(validator.validate(bad))
                .singleElement()
                .satisfies(reason -> assertThat(reason).contains("trade_date"));
    }

    @Test
    void versionMustBePositive() {
        AllocationMessage bad = validSwap().setVersion(0).build();

        assertThat(validator.validate(bad))
                .singleElement()
                .satisfies(reason -> assertThat(reason).contains("version"));
    }

    @Test
    void quantityMustBeNonZero() {
        AllocationMessage bad = validSwap().setQuantity(0).build();

        assertThat(validator.validate(bad))
                .singleElement()
                .satisfies(reason -> assertThat(reason).contains("quantity"));
    }
}
