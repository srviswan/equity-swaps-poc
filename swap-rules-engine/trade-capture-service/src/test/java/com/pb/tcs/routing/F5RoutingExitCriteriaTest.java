package com.pb.tcs.routing;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.ingress.IngestionStoreException;
import com.pb.tcs.repair.InMemoryRepairStore;
import com.pb.tcs.repair.RepairStore;
import com.pb.tcs.rules.BlotterAssembler;
import com.pb.tcs.rules.F3Fixtures;
import com.pb.tcs.rules.RuleSetLoader;
import com.pb.tcs.rules.SwapBlotter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * F5 exit criteria (FR-304/305/306): the A/B routing matrix against a PositionService stub.
 *
 * <ul>
 *   <li>D11 — System A: everything NEW, PositionService never consulted.
 *   <li>D12 — System B: lookup with the system's match key → NEW / TOP_UP / UNWIND before send.
 *   <li>D13 — no inter-target dependency: A's decision exists regardless of B's lookup result.
 *   <li>FR-306 — B's match key carries the config template fields (incl. swapStructure).
 *   <li>Outage — lookup failure quarantines; the event type is never guessed.
 * </ul>
 */
class F5RoutingExitCriteriaTest {

    private BlotterAssembler assembler;
    private StubPositionService positionService;
    private InMemoryRoutingDecisionStore decisionStore;
    private InMemoryRepairStore repairStore;
    private RoutingStage stage;

    @BeforeEach
    void setUp() {
        assembler =
                new BlotterAssembler(RuleSetLoader.fromClasspath("fixtures/rules/f3-golden-rules.yml"));
        positionService = new StubPositionService();
        decisionStore = new InMemoryRoutingDecisionStore();
        repairStore = new InMemoryRepairStore();
        stage =
                new RoutingStage(
                        new RoutingEngine(TcsConfigLoader.routingRules()),
                        new MatchKeyBuilder(TcsConfigLoader.positionMatchKey()),
                        positionService,
                        decisionStore,
                        repairStore);
    }

    private RoutingStage.Outcome route(EnrichedAllocation allocation) {
        SwapBlotter blotter = assembler.assemble(allocation).blotter();
        return stage.process(allocation, blotter);
    }

    @Test
    void usSingleStockFansOutToAandB_systemAAlwaysNewWithoutLookup() {
        var outcome = (RoutingStage.Outcome.Routed) route(F3Fixtures.usNyseSwap("BLK-AB", 1, "2026-06-10"));

        assertThat(outcome.decisions()).extracting(RoutingDecision::targetId)
                .containsExactlyInAnyOrder("SYSTEM_A", "SYSTEM_B");
        RoutingDecision a = decision(outcome, "SYSTEM_A");
        assertThat(a.eventType()).isEqualTo(EventTypeDeriver.EventType.NEW);
        assertThat(a.matchKey()).isEmpty();
        assertThat(a.positionAsOf()).isNull();
        assertThat(a.queue()).isEqualTo("tcs/booking/out/system-a/v1");
        // D11: PS consulted exactly once — for B only
        assertThat(positionService.lookups()).hasSize(1);
        // persisted atomically
        assertThat(decisionStore.findByCorrelationId("BLK-AB/ALL-1/1")).hasSize(2);
    }

    @Test
    void systemBNoPositionIsNew() {
        var outcome = (RoutingStage.Outcome.Routed) route(F3Fixtures.usNyseSwap("BLK-NEW", 1, "2026-06-10"));

        assertThat(decision(outcome, "SYSTEM_B").eventType())
                .isEqualTo(EventTypeDeriver.EventType.NEW);
    }

    @Test
    void systemBSameDirectionIsTopUp() {
        positionService.openPosition("SEC-AAPL", 50_000, "OPEN"); // golden trade is BUY

        var outcome = (RoutingStage.Outcome.Routed) route(F3Fixtures.usNyseSwap("BLK-TOP", 1, "2026-06-10"));

        RoutingDecision b = decision(outcome, "SYSTEM_B");
        assertThat(b.eventType()).isEqualTo(EventTypeDeriver.EventType.TOP_UP);
        assertThat(b.positionAsOf()).isEqualTo(StubPositionService.AS_OF);
    }

    @Test
    void systemBOppositeDirectionIsUnwind() {
        positionService.openPosition("SEC-AAPL", -50_000, "OPEN"); // short vs BUY allocation

        var outcome = (RoutingStage.Outcome.Routed) route(F3Fixtures.usNyseSwap("BLK-UNW", 1, "2026-06-10"));

        assertThat(decision(outcome, "SYSTEM_B").eventType())
                .isEqualTo(EventTypeDeriver.EventType.UNWIND);
    }

    /** FR-306: B's match key follows its config template, including the extra swapStructure field. */
    @Test
    void systemBMatchKeyFollowsConfigTemplate() {
        EnrichedAllocation base = F3Fixtures.usNyseSwap("BLK-KEY", 1, "2026-06-10");
        var alloc = base.message().toBuilder()
                .putExtendedAttributes("swapStructure", "TRS")
                .build();
        var env = base.envelope().toBuilder().setAllocation(alloc).build();
        route(new EnrichedAllocation(env, env.toByteArray(), "{}", "{}", "{}", null));

        Map<String, String> key = positionService.lookups().get(0);
        assertThat(key)
                .containsEntry("book", "EQ_US_HY")
                .containsEntry("clientAccount", "CLI-9")
                .containsEntry("security", "SEC-AAPL")
                .containsEntry("direction", "BUY")
                .containsEntry("swapStructure", "TRS");
    }

    @Test
    void nonUsBookRoutesToSystemAOnly() {
        EnrichedAllocation base = F3Fixtures.usNyseSwap("BLK-EU", 1, "2026-06-10");
        var alloc = base.message().toBuilder().setBook("EQ_EU_HY").build();
        var env = base.envelope().toBuilder().setBook("EQ_EU_HY").setAllocation(alloc).build();

        var outcome =
                (RoutingStage.Outcome.Routed)
                        route(new EnrichedAllocation(env, env.toByteArray(), "{}", "{}", "{}", null));

        assertThat(outcome.decisions()).extracting(RoutingDecision::targetId)
                .containsExactly("SYSTEM_A");
        assertThat(positionService.lookups()).isEmpty();
    }

    /** Outage: B's lookup fails → whole trade quarantined; event type never guessed (D12). */
    @Test
    void positionOutageQuarantinesInsteadOfGuessing() {
        positionService.outage(true);

        var outcome = route(F3Fixtures.usNyseSwap("BLK-OUT", 1, "2026-06-10"));

        assertThat(outcome).isInstanceOf(RoutingStage.Outcome.Quarantined.class);
        var quarantined = (RoutingStage.Outcome.Quarantined) outcome;
        RepairStore.RepairItem item = repairStore.find(quarantined.quarantineId()).orElseThrow();
        assertThat(item.detail()).contains("POSITION_LOOKUP_FAILED").contains("not guessed");
        assertThat(item.correlationId()).isEqualTo("BLK-OUT/ALL-1/1");
        // nothing persisted: no partial routing outcome visible
        assertThat(decisionStore.findByCorrelationId("BLK-OUT/ALL-1/1")).isEmpty();
    }

    private static RoutingDecision decision(RoutingStage.Outcome.Routed outcome, String targetId) {
        return outcome.decisions().stream()
                .filter(d -> d.targetId().equals(targetId))
                .findFirst()
                .orElseThrow();
    }

    /** In-memory store with the SQL adapter's atomic-batch and uniqueness semantics. */
    static final class InMemoryRoutingDecisionStore implements RoutingDecisionStore {
        private final Map<String, RoutingDecision> rows = new LinkedHashMap<>();

        @Override
        public void saveAll(List<RoutingDecision> decisions) {
            for (RoutingDecision d : decisions) {
                if (rows.containsKey(d.correlationId() + "|" + d.targetId())) {
                    throw new IngestionStoreException("uq_routing: " + d.correlationId());
                }
            }
            decisions.forEach(d -> rows.put(d.correlationId() + "|" + d.targetId(), d));
        }

        @Override
        public List<RoutingDecision> findByCorrelationId(String correlationId) {
            List<RoutingDecision> found = new ArrayList<>();
            rows.values().forEach(d -> {
                if (d.correlationId().equals(correlationId)) {
                    found.add(d);
                }
            });
            return found;
        }
    }
}
