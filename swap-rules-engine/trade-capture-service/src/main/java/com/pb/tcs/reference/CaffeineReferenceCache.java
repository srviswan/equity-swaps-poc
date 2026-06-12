package com.pb.tcs.reference;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Ticker;
import com.pb.tcs.config.CachePolicyConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Per-namespace Caffeine caches sized by the cache-policy TTLs (D16). One cache per
 * {@code entity.fieldGroup} so each group expires on its own clock. READ_THROUGH groups get no
 * cache — {@link #get} on an unknown namespace is always empty.
 */
public final class CaffeineReferenceCache implements ReferenceCache {

    private final Map<String, Cache<String, String>> caches = new LinkedHashMap<>();

    public CaffeineReferenceCache(CachePolicyConfig policy) {
        this(policy, Ticker.systemTicker());
    }

    public CaffeineReferenceCache(CachePolicyConfig policy, Ticker ticker) {
        policy.entities()
                .forEach(
                        (entity, groups) ->
                                groups.forEach(
                                        (group, fieldPolicy) -> {
                                            if (fieldPolicy.mode()
                                                    == CachePolicyConfig.Mode.CACHE) {
                                                caches.put(
                                                        entity + "." + group,
                                                        Caffeine.newBuilder()
                                                                .expireAfterWrite(
                                                                        fieldPolicy.ttl())
                                                                .ticker(ticker)
                                                                .build());
                                            }
                                        }));
    }

    @Override
    public Optional<String> get(String namespace, String key) {
        Cache<String, String> cache = caches.get(namespace);
        return cache == null ? Optional.empty() : Optional.ofNullable(cache.getIfPresent(key));
    }

    @Override
    public void put(String namespace, String key, String value) {
        Cache<String, String> cache = caches.get(namespace);
        if (cache != null) {
            cache.put(key, value);
        }
    }

    @Override
    public void invalidate(String namespace, String key) {
        Cache<String, String> cache = caches.get(namespace);
        if (cache != null) {
            cache.invalidate(key);
        }
    }

    @Override
    public void invalidateNamespace(String namespace) {
        Cache<String, String> cache = caches.get(namespace);
        if (cache != null) {
            cache.invalidateAll();
        }
    }
}
