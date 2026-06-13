package com.pb.tcs.reference;

import com.pb.tcs.config.CachePolicyConfig;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * F2 (FR-200/202, D16): {@link ReferenceDataProxy} backed by a {@link ReferenceDataSource} with
 * per-entity cache policies from {@code cache-policy.yml}.
 *
 * <p>Hard-correctness rule: security <em>status</em> is read-through on every lookup — an
 * inactive security is never accepted from a stale cache, regardless of what static fields are
 * cached. Negative lookups are never cached (a missing entity may appear before retry 3).
 */
public final class CachingReferenceDataProxy implements ReferenceDataProxy {

    private static final String ACTIVE = "ACTIVE";

    private final ReferenceDataSource source;
    private final ReferenceCache cache;
    private final CachePolicyConfig policy;

    public CachingReferenceDataProxy(
            ReferenceDataSource source, ReferenceCache cache, CachePolicyConfig policy) {
        this.source = source;
        this.cache = cache;
        this.policy = policy;
    }

    @Override
    public Optional<String> lookupSecurity(String securityId) {
        Optional<String> status =
                resolve("security", "statusFields", securityId,
                        () -> source.fetchSecurityStatus(securityId));
        if (status.isEmpty() || !ACTIVE.equals(status.get())) {
            return Optional.empty();
        }
        return resolve("security", "staticFields", securityId,
                () -> source.fetchSecurity(securityId));
    }

    @Override
    public Optional<String> lookupClientAccount(String clientAccount) {
        return resolve("clientAccount", "staticFields", clientAccount,
                () -> source.fetchClientAccount(clientAccount));
    }

    @Override
    public Optional<String> lookupBook(String book) {
        return resolve("book", CachePolicyConfig.DEFAULT_GROUP, book,
                () -> source.fetchBook(book));
    }

    @Override
    public Optional<String> lookupWashBook(String clientAccount, String exchange, boolean b2bLeg) {
        String key = clientAccount + "|" + exchange + "|" + b2bLeg;
        return resolve("washBook", CachePolicyConfig.DEFAULT_GROUP, key,
                () -> source.fetchWashBook(clientAccount, exchange, b2bLeg));
    }

    /** Invalidation-bus entry point (arch §9): Solace fan-out events land here per instance. */
    public void onInvalidation(CacheInvalidationEvent event) {
        Map<String, CachePolicyConfig.FieldPolicy> groups = policy.entities().get(event.entity());
        if (groups == null) {
            return;
        }
        groups.keySet()
                .forEach(
                        group -> {
                            String namespace = event.entity() + "." + group;
                            if (event.key() == null) {
                                cache.invalidateNamespace(namespace);
                            } else {
                                cache.invalidate(namespace, event.key());
                            }
                        });
    }

    private Optional<String> resolve(
            String entity, String fieldGroup, String key, Supplier<Optional<String>> loader) {
        CachePolicyConfig.FieldPolicy fieldPolicy = policy.policy(entity, fieldGroup);
        if (fieldPolicy.mode() == CachePolicyConfig.Mode.READ_THROUGH) {
            return loader.get();
        }
        String namespace = entity + "." + fieldGroup;
        Optional<String> cached = cache.get(namespace, key);
        if (cached.isPresent()) {
            return cached;
        }
        Optional<String> loaded = loader.get();
        loaded.ifPresent(value -> cache.put(namespace, key, value));
        return loaded;
    }
}
