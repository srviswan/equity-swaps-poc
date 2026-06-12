package com.pb.tcs.reference;

import java.util.Optional;

/**
 * Cache SPI behind the proxy (FR-203): Caffeine now, Redis later — application code is written
 * against this interface only. Namespace = {@code entity.fieldGroup} (TTL boundary).
 */
public interface ReferenceCache {

    Optional<String> get(String namespace, String key);

    void put(String namespace, String key, String value);

    void invalidate(String namespace, String key);

    void invalidateNamespace(String namespace);
}
