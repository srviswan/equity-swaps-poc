package com.pb.swap.rules.shadow;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.swap.rules.core.model.EnrichedEquitySwap;
import com.pb.swap.rules.core.model.InterestLeg;
import com.pb.swap.rules.core.model.SwapContract;
import java.time.LocalDate;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ShadowDiffServiceTest {
    @Test
    void detectsFieldDiff() {
        EnrichedEquitySwap newer =
                new EnrichedEquitySwap(
                        "T1",
                        new SwapContract("C1", "EQUITY_SWAP", LocalDate.now(), null),
                        new InterestLeg("ACT/365", null, null, null, null),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
        Map<String, Object> legacy =
                Map.of(
                        "tradeId",
                        "T1",
                        "interestLeg",
                        Map.of("dayCount", "ACT/360"));
        ShadowDiffService.ShadowDiff diff = new ShadowDiffService().diff(newer, legacy);
        assertThat(diff.match()).isFalse();
        assertThat(diff.diffs()).isNotEmpty();
    }
}
