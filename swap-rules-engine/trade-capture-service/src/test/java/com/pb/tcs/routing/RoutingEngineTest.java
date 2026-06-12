package com.pb.tcs.routing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.pb.tcs.config.RoutingRulesConfig;
import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.rules.F3Fixtures;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class RoutingEngineTest {

    private static RoutingContext context(String book, String assetType) {
        var base = F3Fixtures.usNyseSwap("BLK-RT", 1, "2026-06-10");
        var alloc = base.message().toBuilder().setBook(book).setAssetType(assetType).build();
        var env = base.envelope().toBuilder().setBook(book).setAllocation(alloc).build();
        var enriched =
                new com.pb.tcs.ingress.EnrichedAllocation(
                        env, env.toByteArray(), "{}", "{}", "{}", null);
        var blotter =
                new com.pb.tcs.rules.SwapBlotter(
                        "BLK-RT/ALL-1/1",
                        "BLK-RT",
                        "ALL-1",
                        1,
                        "SWAP",
                        book,
                        "CLI-9",
                        "SEC-AAPL",
                        java.time.LocalDate.of(2026, 6, 10),
                        "snap@test",
                        null);
        return RoutingContext.of(enriched, blotter);
    }

    @Test
    void firstMatchWinsTopDown() {
        RoutingEngine engine = new RoutingEngine(TcsConfigLoader.routingRules());

        RoutingEngine.Route route = engine.route(context("EQ_US_HY", "SINGLE_STOCK"));

        assertThat(route.ruleName()).isEqualTo("us-single-stock");
        assertThat(route.targets()).containsExactly("SYSTEM_A", "SYSTEM_B");
    }

    @Test
    void globMatchesBookPrefix() {
        assertThat(RoutingEngine.globMatches("EQ_US*", "EQ_US_HY")).isTrue();
        assertThat(RoutingEngine.globMatches("EQ_US*", "EQ_EU_HY")).isFalse();
        assertThat(RoutingEngine.globMatches("EQ_*_HY", "EQ_US_HY")).isTrue();
        assertThat(RoutingEngine.globMatches("SINGLE_STOCK", "SINGLE_STOCK")).isTrue();
        // glob special chars in values must not be treated as regex
        assertThat(RoutingEngine.globMatches("A.B*", "A.B-1")).isTrue();
        assertThat(RoutingEngine.globMatches("A.B*", "AXB-1")).isFalse();
    }

    @Test
    void unmatchedDimensionsFallToCatchAll() {
        RoutingEngine engine = new RoutingEngine(TcsConfigLoader.routingRules());

        RoutingEngine.Route route = engine.route(context("EQ_EU_HY", "INDEX"));

        assertThat(route.ruleName()).isEqualTo("default");
        assertThat(route.targets()).containsExactly("SYSTEM_A");
    }

    /** FR-304 acceptance: a new routing dimension is added by config only — no code change. */
    @Test
    void newDimensionAddedByConfigOnly() {
        RoutingRulesConfig config =
                new RoutingRulesConfig(
                        List.of(
                                new RoutingRulesConfig.Rule(
                                        "nyse-exchange-special",
                                        Map.of("exchange", "NYSE", "location", "US"),
                                        List.of("SYSTEM_B")),
                                new RoutingRulesConfig.Rule("default", Map.of(), List.of("SYSTEM_A"))),
                        Map.of(
                                "SYSTEM_A",
                                new RoutingRulesConfig.Target("q/a", true, 1000, 3, false),
                                "SYSTEM_B",
                                new RoutingRulesConfig.Target("q/b", true, 1000, 3, true)));
        RoutingEngine engine = new RoutingEngine(config);

        // exchange/location were never routing dimensions before — resolved via RoutingContext
        assertThat(engine.route(context("EQ_US_HY", "SINGLE_STOCK")).ruleName())
                .isEqualTo("nyse-exchange-special");
    }

    @Test
    void missingCatchAllFailsLoudly() {
        RoutingRulesConfig config =
                new RoutingRulesConfig(
                        List.of(
                                new RoutingRulesConfig.Rule(
                                        "narrow", Map.of("book", "NOPE*"), List.of("SYSTEM_A"))),
                        Map.of());

        assertThatThrownBy(() -> new RoutingEngine(config).route(context("EQ_US_HY", "SINGLE_STOCK")))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("No routing rule matched");
    }
}
