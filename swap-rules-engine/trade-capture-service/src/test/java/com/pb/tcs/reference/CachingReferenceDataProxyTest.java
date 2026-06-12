package com.pb.tcs.reference;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.benmanes.caffeine.cache.Ticker;
import com.pb.tcs.config.TcsConfigLoader;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * F2 (FR-202, D16): per-entity cache policy over a swappable cache. The non-negotiable row:
 * an inactive security is NEVER accepted from a stale cache — status is read-through.
 */
class CachingReferenceDataProxyTest {

    private CountingSource source;
    private FakeTicker ticker;
    private CachingReferenceDataProxy proxy;

    @BeforeEach
    void setUp() {
        source = new CountingSource();
        ticker = new FakeTicker();
        proxy =
                new CachingReferenceDataProxy(
                        source,
                        new CaffeineReferenceCache(TcsConfigLoader.cachePolicy(), ticker),
                        TcsConfigLoader.cachePolicy());
    }

    // --- static fields cached -------------------------------------------------------

    @Test
    void staticSecurityFieldsServedFromCacheAfterFirstLookup() {
        proxy.lookupSecurity("SEC-1");
        proxy.lookupSecurity("SEC-1");
        proxy.lookupSecurity("SEC-1");

        assertThat(source.securityLoads).hasValue(1);
    }

    @Test
    void cacheExpiresAfterConfiguredTtl() {
        proxy.lookupSecurity("SEC-1"); // security.staticFields ttl = 4h
        ticker.advance(Duration.ofHours(4).plusSeconds(1));
        proxy.lookupSecurity("SEC-1");

        assertThat(source.securityLoads).hasValue(2);
    }

    @Test
    void missingEntityIsNotNegativelyCached() {
        assertThat(proxy.lookupSecurity("SEC-UNKNOWN")).isEmpty();
        source.securities.put("SEC-UNKNOWN", "{\"securityId\":\"SEC-UNKNOWN\"}");
        source.statuses.put("SEC-UNKNOWN", "ACTIVE");

        assertThat(proxy.lookupSecurity("SEC-UNKNOWN")).isPresent();
    }

    // --- security status: read-through, hard correctness ----------------------------

    @Test
    void securityStatusIsReadThroughOnEveryLookup() {
        proxy.lookupSecurity("SEC-1");
        proxy.lookupSecurity("SEC-1");
        proxy.lookupSecurity("SEC-1");

        assertThat(source.statusLoads).hasValue(3);
        assertThat(source.securityLoads).hasValue(1);
    }

    @Test
    void inactiveSecurityIsRejectedEvenWhenStaticFieldsAreCached() {
        assertThat(proxy.lookupSecurity("SEC-1")).isPresent();

        source.statuses.put("SEC-1", "INACTIVE"); // status flips upstream — no event, no TTL wait

        assertThat(proxy.lookupSecurity("SEC-1"))
                .as("inactive security never accepted from stale cache (FR-202)")
                .isEmpty();
    }

    @Test
    void securityWithoutStatusIsRejected() {
        source.securities.put("SEC-NOSTATUS", "{}");

        assertThat(proxy.lookupSecurity("SEC-NOSTATUS")).isEmpty();
    }

    // --- event invalidation (the F2 invalidation-bus drill) --------------------------

    @Test
    void invalidationEventMakesUpstreamChangeVisibleImmediately() {
        proxy.lookupClientAccount("CLI-1");
        source.clientAccounts.put("CLI-1", "{\"clientAccount\":\"CLI-1\",\"v\":2}");

        // without event: stale until TTL
        assertThat(proxy.lookupClientAccount("CLI-1")).contains("{\"clientAccount\":\"CLI-1\"}");

        proxy.onInvalidation(new CacheInvalidationEvent("clientAccount", "CLI-1"));

        assertThat(proxy.lookupClientAccount("CLI-1"))
                .contains("{\"clientAccount\":\"CLI-1\",\"v\":2}");
    }

    @Test
    void entityWideInvalidationFlushesAllKeys() {
        proxy.lookupBook("EQ_US_HY");
        proxy.lookupBook("EQ_EU");

        proxy.onInvalidation(new CacheInvalidationEvent("book", null));
        proxy.lookupBook("EQ_US_HY");
        proxy.lookupBook("EQ_EU");

        assertThat(source.bookLoads).hasValue(4);
    }

    @Test
    void staleValueServedAtMostUntilTtlWithoutEvent() {
        proxy.lookupClientAccount("CLI-1"); // clientAccount.staticFields ttl = 1h
        source.clientAccounts.put("CLI-1", "{\"clientAccount\":\"CLI-1\",\"v\":2}");

        ticker.advance(Duration.ofHours(1).plusSeconds(1));

        assertThat(proxy.lookupClientAccount("CLI-1"))
                .as("fallback TTL bounds the staleness window")
                .contains("{\"clientAccount\":\"CLI-1\",\"v\":2}");
    }

    // --- wash book composite key ----------------------------------------------------

    @Test
    void washBookCachedByCompositeKey() {
        proxy.lookupWashBook("CLI-1", "NYSE", true);
        proxy.lookupWashBook("CLI-1", "NYSE", true);
        proxy.lookupWashBook("CLI-1", "LSE", true); // different exchange = different entry

        assertThat(source.washBookLoads).hasValue(2);
    }

    // --- FR-203: cache implementation swap, no application-code change ---------------

    @Test
    void mapBackedCacheBehavesIdentically_swapIsConfigOnly() {
        CachingReferenceDataProxy redisLike =
                new CachingReferenceDataProxy(
                        source, new MapReferenceCache(), TcsConfigLoader.cachePolicy());

        redisLike.lookupSecurity("SEC-1");
        long loadsAfterFirst = source.securityLoads.get();
        redisLike.lookupSecurity("SEC-1");

        assertThat(source.securityLoads).hasValue(loadsAfterFirst);
        source.statuses.put("SEC-1", "INACTIVE");
        assertThat(redisLike.lookupSecurity("SEC-1")).isEmpty();
    }

    @Test
    void factoryResolvesImplementationFromConfig() {
        assertThat(ReferenceCacheFactory.create("caffeine", TcsConfigLoader.cachePolicy()))
                .isInstanceOf(CaffeineReferenceCache.class);
    }

    // --- fakes ------------------------------------------------------------------------

    /** Map-backed stand-in for a Redis-style cache: proves the interface boundary (FR-203). */
    private static final class MapReferenceCache implements ReferenceCache {
        private final Map<String, String> map = new HashMap<>();

        @Override
        public Optional<String> get(String namespace, String key) {
            return Optional.ofNullable(map.get(namespace + "|" + key));
        }

        @Override
        public void put(String namespace, String key, String value) {
            map.put(namespace + "|" + key, value);
        }

        @Override
        public void invalidate(String namespace, String key) {
            map.remove(namespace + "|" + key);
        }

        @Override
        public void invalidateNamespace(String namespace) {
            map.keySet().removeIf(k -> k.startsWith(namespace + "|"));
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

    private static final class CountingSource implements ReferenceDataSource {
        final Map<String, String> securities = new HashMap<>();
        final Map<String, String> statuses = new HashMap<>();
        final Map<String, String> clientAccounts = new HashMap<>();
        final Map<String, String> books = new HashMap<>();
        final AtomicLong securityLoads = new AtomicLong();
        final AtomicLong statusLoads = new AtomicLong();
        final AtomicLong clientLoads = new AtomicLong();
        final AtomicLong bookLoads = new AtomicLong();
        final AtomicLong washBookLoads = new AtomicLong();

        CountingSource() {
            securities.put("SEC-1", "{\"securityId\":\"SEC-1\"}");
            statuses.put("SEC-1", "ACTIVE");
            clientAccounts.put("CLI-1", "{\"clientAccount\":\"CLI-1\"}");
            books.put("EQ_US_HY", "{\"book\":\"EQ_US_HY\"}");
            books.put("EQ_EU", "{\"book\":\"EQ_EU\"}");
        }

        @Override
        public Optional<String> fetchSecurity(String securityId) {
            securityLoads.incrementAndGet();
            return Optional.ofNullable(securities.get(securityId));
        }

        @Override
        public Optional<String> fetchSecurityStatus(String securityId) {
            statusLoads.incrementAndGet();
            return Optional.ofNullable(statuses.get(securityId));
        }

        @Override
        public Optional<String> fetchClientAccount(String clientAccount) {
            clientLoads.incrementAndGet();
            return Optional.ofNullable(clientAccounts.get(clientAccount));
        }

        @Override
        public Optional<String> fetchBook(String book) {
            bookLoads.incrementAndGet();
            return Optional.ofNullable(books.get(book));
        }

        @Override
        public Optional<String> fetchWashBook(
                String clientAccount, String exchange, boolean b2bLeg) {
            washBookLoads.incrementAndGet();
            return Optional.of("{\"washBook\":\"WASH-" + exchange + "\"}");
        }
    }
}
