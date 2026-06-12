package com.pb.tcs.reference;

/**
 * Invalidation event fanned to all instances via a Solace topic (arch §9). {@code key == null}
 * flushes the whole entity.
 */
public record CacheInvalidationEvent(String entity, String key) {}
