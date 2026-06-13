package com.pb.tcs.harness;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.rules.F3Fixtures;
import com.pb.tcs.validation.MandatoryFieldValidator;
import org.junit.jupiter.api.Test;

class IngressHarnessPublisherTest {

    @Test
    void legacyExtractMatchesGoldenFixtureShape() {
        LegacyTradeExtract extract = LegacyTradeExtract.goldenUsNyse("BLK-LEG", 2, "2026-06-10");
        var fromExtract = IngressHarnessPublisher.fromLegacyExtract(extract);
        var fromFixture = F3Fixtures.usNyseSwap("BLK-LEG", 2, "2026-06-10").message();

        assertThat(fromExtract.getAllocation()).isEqualTo(fromFixture);
        assertThat(fromExtract.getBook()).isEqualTo(fromFixture.getBook());
    }

    @Test
    void synthesizedMessagesPassMandatoryValidation() {
        LegacyTradeExtract extract = LegacyTradeExtract.goldenUsNyse("BLK-VAL", 1, "2026-06-10");
        var message = IngressHarnessPublisher.fromLegacyExtract(extract);

        assertThat(new MandatoryFieldValidator().validate(message.getAllocation())).isEmpty();
    }

    @Test
    void goldenAllocationRoundTripsThroughPublisher() {
        var allocation = F3Fixtures.usNyseSwap("BLK-RT", 1, "2026-06-10");
        assertThat(IngressHarnessPublisher.fromGoldenAllocation(allocation))
                .isEqualTo(allocation.envelope());
    }
}
