package com.pb.tcs.ingress;

import java.nio.charset.StandardCharsets;

/**
 * Sequence/partition key formula (D3): FNV-1a 64-bit over {@code book|accountId|securityId}.
 * Shared by publishers (Solace partition key header) and the consumer
 * ({@code ingestion_record.sequence_key_hash}). Changing the algorithm re-shuffles partition
 * affinity — never change it while messages are in flight.
 */
public final class SequenceKeys {

    private static final long FNV_OFFSET = 0xcbf29ce484222325L;
    private static final long FNV_PRIME = 0x100000001b3L;
    private static final byte DELIMITER = '|';

    private SequenceKeys() {}

    public static long hash(String book, String accountId, String securityId) {
        long h = FNV_OFFSET;
        h = mix(h, book);
        h = h * FNV_PRIME ^ (DELIMITER & 0xffL);
        h = mix(h, accountId);
        h = h * FNV_PRIME ^ (DELIMITER & 0xffL);
        h = mix(h, securityId);
        return h;
    }

    /** Maps a hash to a partition index in {@code [0, partitions)}. */
    public static int partition(long hash, int partitions) {
        return (int) Math.floorMod(hash, partitions);
    }

    private static long mix(long h, String value) {
        for (byte b : value.getBytes(StandardCharsets.UTF_8)) {
            h ^= (b & 0xffL);
            h *= FNV_PRIME;
        }
        return h;
    }
}
