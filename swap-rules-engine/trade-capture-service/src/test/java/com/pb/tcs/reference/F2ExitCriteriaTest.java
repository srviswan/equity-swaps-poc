package com.pb.tcs.reference;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.benmanes.caffeine.cache.Ticker;
import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.ingress.IngestionStore;
import com.pb.tcs.ingress.IngressPipeline;
import com.pb.tcs.ingress.PipelineResult;
import com.pb.tcs.ingress.VersionGapHoldStore;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.AllocationType;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.Test;

/**
 * F2 exit criteria (PRD §10):
 *
 * <ol>
 *   <li>Invalidation-bus drill — an upstream change becomes visible to <em>all</em> instances
 *       immediately on the fan-out event, and never later than the fallback TTL without it.
 *   <li>An inactive security is rejected by the real ingress pipeline even while its static
 *       fields sit warm in the cache.
 * </ol>
 */
class F2ExitCriteriaTest {

    @Test
    void invalidationBusDrill_changeVisibleToAllInstancesAtMostFallbackTtl() {
        MutableSource source = new MutableSource();
        FakeTicker ticker1 = new FakeTicker();
        FakeTicker ticker2 = new FakeTicker();
        // two service instances: separate local caches, same upstream
        CachingReferenceDataProxy instance1 = proxy(source, ticker1);
        CachingReferenceDataProxy instance2 = proxy(source, ticker2);
        List<CachingReferenceDataProxy> allInstances = List.of(instance1, instance2);

        instance1.lookupClientAccount("CLI-1");
        instance2.lookupClientAccount("CLI-1");
        source.clientAccounts.put("CLI-1", "{\"clientAccount\":\"CLI-1\",\"limit\":999}");

        // both instances still serve the cached value (inside the staleness window)
        assertThat(instance1.lookupClientAccount("CLI-1")).contains("{\"clientAccount\":\"CLI-1\"}");
        assertThat(instance2.lookupClientAccount("CLI-1")).contains("{\"clientAccount\":\"CLI-1\"}");

        // Solace invalidation event fans to every instance → change visible immediately
        CacheInvalidationEvent event = new CacheInvalidationEvent("clientAccount", "CLI-1");
        allInstances.forEach(i -> i.onInvalidation(event));
        assertThat(instance1.lookupClientAccount("CLI-1"))
                .contains("{\"clientAccount\":\"CLI-1\",\"limit\":999}");
        assertThat(instance2.lookupClientAccount("CLI-1"))
                .contains("{\"clientAccount\":\"CLI-1\",\"limit\":999}");

        // and even with a LOST event, the fallback TTL (1h) bounds the window
        source.clientAccounts.put("CLI-1", "{\"clientAccount\":\"CLI-1\",\"limit\":1}");
        ticker1.advance(Duration.ofHours(1).plusSeconds(1));
        assertThat(instance1.lookupClientAccount("CLI-1"))
                .contains("{\"clientAccount\":\"CLI-1\",\"limit\":1}");
    }

    @Test
    void inactiveSecurityTradeRejectedByPipelineDespiteWarmCache() {
        MutableSource source = new MutableSource();
        CachingReferenceDataProxy refData = proxy(source, new FakeTicker());
        MapIngestionStore store = new MapIngestionStore();
        IngressPipeline pipeline =
                new IngressPipeline(
                        store,
                        new MapHoldStore(),
                        refData,
                        TcsConfigLoader.versionGap(),
                        TcsConfigLoader.ingress(),
                        Clock.systemUTC());

        // version 1 trades while ACTIVE — warms the static-field cache
        PipelineResult v1 = pipeline.process(swap(1).toByteArray(), 1);
        assertThat(v1.disposition()).isEqualTo(PipelineResult.Disposition.ENRICHED);

        // security goes INACTIVE upstream; static fields are still cached
        source.statuses.put("SEC-1", "INACTIVE");

        PipelineResult v2 = pipeline.process(swap(2).toByteArray(), 1);
        assertThat(v2.solace()).isEqualTo(PipelineResult.SolaceAction.NACK);
        assertThat(v2.disposition()).isEqualTo(PipelineResult.Disposition.REFDATA_RETRY);

        // 3rd attempt → quarantine, never booked (FR-105 path)
        PipelineResult v2Final = pipeline.process(swap(2).toByteArray(), 3);
        assertThat(v2Final.disposition())
                .isEqualTo(PipelineResult.Disposition.REFDATA_QUARANTINED);
        assertThat(store.enriched).containsExactly("BLK-1|ALL-1|1");
    }

    // --- fixtures ---------------------------------------------------------------------

    private static CachingReferenceDataProxy proxy(MutableSource source, Ticker ticker) {
        return new CachingReferenceDataProxy(
                source,
                new CaffeineReferenceCache(TcsConfigLoader.cachePolicy(), ticker),
                TcsConfigLoader.cachePolicy());
    }

    private static TcsIngressMessage swap(int version) {
        return TcsIngressMessage.newBuilder()
                .setMessageId("M-" + version)
                .setSource(SourceSystem.GCAM)
                .setBook("EQ_US_HY")
                .setAccountId("CLI-1")
                .setSecurityId("SEC-1")
                .setAllocation(
                        AllocationMessage.newBuilder()
                                .setBlockId("BLK-1")
                                .setAllocationId("ALL-1")
                                .setVersion(version)
                                .setGcamMessageId("GCAM-" + version)
                                .setType(AllocationType.SWAP)
                                .setBook("EQ_US_HY")
                                .setClientAccount("CLI-1")
                                .setSecurityId("SEC-1")
                                .setTradeDate("2026-06-10")
                                .setQuantity(500)
                                .setDirection("BUY")
                                .setSchemaVersion(1))
                .build();
    }

    private static final class MutableSource implements ReferenceDataSource {
        final Map<String, String> securities = new HashMap<>();
        final Map<String, String> statuses = new HashMap<>();
        final Map<String, String> clientAccounts = new HashMap<>();
        final AtomicLong statusLoads = new AtomicLong();

        MutableSource() {
            securities.put("SEC-1", "{\"securityId\":\"SEC-1\"}");
            statuses.put("SEC-1", "ACTIVE");
            clientAccounts.put("CLI-1", "{\"clientAccount\":\"CLI-1\"}");
        }

        @Override
        public Optional<String> fetchSecurity(String securityId) {
            return Optional.ofNullable(securities.get(securityId));
        }

        @Override
        public Optional<String> fetchSecurityStatus(String securityId) {
            statusLoads.incrementAndGet();
            return Optional.ofNullable(statuses.get(securityId));
        }

        @Override
        public Optional<String> fetchClientAccount(String clientAccount) {
            return Optional.ofNullable(clientAccounts.get(clientAccount));
        }

        @Override
        public Optional<String> fetchBook(String book) {
            return Optional.of("{\"book\":\"" + book + "\"}");
        }

        @Override
        public Optional<String> fetchWashBook(
                String clientAccount, String exchange, boolean b2bLeg) {
            return Optional.of("{\"washBook\":\"WASH\"}");
        }
    }

    private static final class FakeTicker implements Ticker {
        private final AtomicLong nanos = new AtomicLong();

        void advance(Duration duration) {
            nanos.addAndGet(duration.toNanos());
        }

        @Override
        public long read() {
            return nanos.get();
        }
    }

    private static final class MapIngestionStore implements IngestionStore {
        final List<String> enriched = new ArrayList<>();

        @Override
        public boolean isEnriched(String blockId, String allocationId, int version) {
            return enriched.contains(blockId + "|" + allocationId + "|" + version);
        }

        @Override
        public OptionalInt lastEnrichedVersion(String blockId, String allocationId) {
            return enriched.stream()
                    .filter(k -> k.startsWith(blockId + "|" + allocationId + "|"))
                    .mapToInt(k -> Integer.parseInt(k.substring(k.lastIndexOf('|') + 1)))
                    .max();
        }

        @Override
        public void persistEnriched(EnrichedAllocation allocation) {
            AllocationMessage m = allocation.message();
            enriched.add(m.getBlockId() + "|" + m.getAllocationId() + "|" + m.getVersion());
        }

        @Override
        public void auditReject(
                String stage, String reason, int attempt, byte[] raw, TcsIngressMessage parsed) {}

        @Override
        public void quarantine(String category, String detail, byte[] rawProto) {}
    }

    private static final class MapHoldStore implements VersionGapHoldStore {
        private final Map<String, HoldRow> rows = new HashMap<>();

        @Override
        public void hold(HoldRow row) {
            rows.put(row.blockId() + "|" + row.allocationId() + "|" + row.heldVersion(), row);
        }

        @Override
        public SortedSet<Integer> heldVersions(String blockId, String allocationId) {
            SortedSet<Integer> versions = new TreeSet<>();
            rows.values().stream()
                    .filter(
                            r ->
                                    r.blockId().equals(blockId)
                                            && r.allocationId().equals(allocationId))
                    .forEach(r -> versions.add(r.heldVersion()));
            return versions;
        }

        @Override
        public Optional<HoldRow> claim(String blockId, String allocationId, int version) {
            return Optional.ofNullable(rows.remove(blockId + "|" + allocationId + "|" + version));
        }

        @Override
        public List<HoldRow> expiredHolds(Instant now) {
            return List.of();
        }

        @Override
        public void remove(String blockId, String allocationId, int version) {
            rows.remove(blockId + "|" + allocationId + "|" + version);
        }
    }
}
