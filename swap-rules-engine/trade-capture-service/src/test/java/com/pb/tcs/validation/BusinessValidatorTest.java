package com.pb.tcs.validation;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.swap.rules.core.model.DivPassthrough;
import com.pb.swap.rules.core.model.EnrichedEquitySwap;
import com.pb.swap.rules.core.model.EquityLeg;
import com.pb.swap.rules.core.model.InterestLeg;
import com.pb.swap.rules.core.model.Schedule;
import com.pb.swap.rules.core.model.SwapContract;
import com.pb.tcs.config.BusinessValidationConfig;
import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.rules.SwapBlotter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class BusinessValidatorTest {

    private final BusinessValidator validator =
            new BusinessValidator(TcsConfigLoader.businessValidation());

    private static SwapBlotter blotter(InterestLeg leg, DivPassthrough div, String legalEntity) {
        EnrichedEquitySwap swap =
                new EnrichedEquitySwap(
                        "BLK-V/ALL-1/1",
                        new SwapContract("BLK-V/ALL-1/1", "EQUITY_SWAP", LocalDate.of(2026, 6, 10), null),
                        leg,
                        new EquityLeg("TOTAL_RETURN", null),
                        new Schedule("MONTHLY", null),
                        div,
                        legalEntity,
                        "PENDING_VALIDATION",
                        null);
        return new SwapBlotter(
                "BLK-V/ALL-1/1",
                "BLK-V",
                "ALL-1",
                1,
                "SWAP",
                "EQ_US_HY",
                "CLI-9",
                "SEC-AAPL",
                LocalDate.of(2026, 6, 10),
                "snap@test",
                swap);
    }

    private static InterestLeg completeLeg() {
        return new InterestLeg("ACT/360", "FLOATING", "SOFR", BigDecimal.valueOf(250), null);
    }

    @Test
    void contractCompleteBlotterPasses() {
        assertThat(validator.validate(blotter(completeLeg(), null, "PB_ENTITY_US"))).isEmpty();
    }

    @Test
    void missingMandatoryFieldsReportedPerPath() {
        InterestLeg holey = new InterestLeg("ACT/360", null, null, null, null);

        List<BusinessValidator.Violation> violations =
                validator.validate(blotter(holey, null, null));

        assertThat(violations)
                .extracting(BusinessValidator.Violation::field)
                .containsExactlyInAnyOrder("swap.interestLeg.rateType", "swap.legalEntity");
        assertThat(violations)
                .allSatisfy(v -> assertThat(v.code()).isEqualTo("MANDATORY_FIELD_MISSING"));
    }

    @Test
    void negativeSpreadIsStructuralViolation() {
        InterestLeg negative =
                new InterestLeg("ACT/360", "FLOATING", "SOFR", BigDecimal.valueOf(-5), null);

        assertThat(validator.validate(blotter(negative, null, "PB_ENTITY_US")))
                .extracting(BusinessValidator.Violation::code)
                .containsExactly("SPREAD_NEGATIVE");
    }

    @Test
    void divPassthroughPercentBoundsChecked() {
        DivPassthrough overflow = new DivPassthrough(BigDecimal.valueOf(120), "PAY_DATE");

        assertThat(validator.validate(blotter(completeLeg(), overflow, "PB_ENTITY_US")))
                .extracting(BusinessValidator.Violation::code)
                .containsExactly("DIV_PERCENT_OUT_OF_RANGE");

        DivPassthrough inRange = new DivPassthrough(BigDecimal.valueOf(100), "PAY_DATE");
        assertThat(validator.validate(blotter(completeLeg(), inRange, "PB_ENTITY_US"))).isEmpty();
    }

    @Test
    void mandatoryListIsConfigDriven() {
        BusinessValidator custom =
                new BusinessValidator(
                        new BusinessValidationConfig(
                                List.of("swap.equityLeg.feeType"),
                                new BusinessValidationConfig.Structural(true, true)));

        assertThat(custom.validate(blotter(completeLeg(), null, null)))
                .extracting(BusinessValidator.Violation::field)
                .containsExactly("swap.equityLeg.feeType");
    }
}
