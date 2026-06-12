package com.pb.tcs.harness;

import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.AllocationType;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * FR-606: synthesizes valid ingress messages for the soak/spike/parity suites. Deterministic by
 * seed; per-key version order is ascending in emission order (GCAM publish order), while keys are
 * interleaved randomly — exactly the stream shape Solace partition FIFO preserves per key.
 */
final class SyntheticAllocationGenerator {

    private static final String[] BOOKS = {"EQ_US_HY", "EQ_US_IG", "EQ_EU", "EQ_APAC"};

    private SyntheticAllocationGenerator() {}

    /** {@code keys} distinct sequence keys, {@code versionsPerKey} ascending versions each. */
    static Stream<TcsIngressMessage> uniform(int keys, int versionsPerKey, long seed) {
        return uniform(keys, versionsPerKey, seed, 0);
    }

    /** As {@link #uniform(int, int, long)} with a key offset for disjoint keyspaces per test. */
    static Stream<TcsIngressMessage> uniform(int keys, int versionsPerKey, long seed, int keyOffset) {
        int[] perKey = new int[keys];
        java.util.Arrays.fill(perKey, versionsPerKey);
        return interleave(perKey, seed, keyOffset);
    }

    /** Spike shape (NFR-2): {@code messages} concentrated on {@code hotKeyCount} keys. */
    static Stream<TcsIngressMessage> hotKeys(int hotKeyCount, int messages, long seed) {
        return hotKeys(hotKeyCount, messages, seed, 0);
    }

    static Stream<TcsIngressMessage> hotKeys(
            int hotKeyCount, int messages, long seed, int keyOffset) {
        int base = messages / hotKeyCount;
        int remainder = messages % hotKeyCount;
        int[] perKey = new int[hotKeyCount];
        for (int i = 0; i < hotKeyCount; i++) {
            perKey[i] = base + (i < remainder ? 1 : 0);
        }
        return interleave(perKey, seed, keyOffset);
    }

    /**
     * Random interleave across keys with per-key ascending versions: repeatedly pick a random
     * not-yet-exhausted key (swap-remove) and emit its next version.
     */
    private static Stream<TcsIngressMessage> interleave(
            int[] versionsPerKey, long seed, int keyOffset) {
        int keys = versionsPerKey.length;
        Random random = new Random(seed);
        int[] alive = new int[keys];
        int[] nextVersion = new int[keys];
        for (int i = 0; i < keys; i++) {
            alive[i] = i;
            nextVersion[i] = 1;
        }
        List<TcsIngressMessage> out = new ArrayList<>();
        int aliveCount = keys;
        while (aliveCount > 0) {
            int pick = random.nextInt(aliveCount);
            int key = alive[pick];
            out.add(message(keyOffset + key, nextVersion[key]++));
            if (nextVersion[key] > versionsPerKey[key]) {
                alive[pick] = alive[--aliveCount];
            }
        }
        return out.stream();
    }

    static TcsIngressMessage message(int key, int version) {
        String book = BOOKS[key % BOOKS.length];
        String account = "CLI-%05d".formatted(key);
        String security = "SEC-%05d".formatted(key % 997);
        String blockId = "BLK-%06d".formatted(key);
        String allocationId = "ALL-%06d".formatted(key);
        return TcsIngressMessage.newBuilder()
                .setMessageId("M-%d-%d".formatted(key, version))
                .setSource(SourceSystem.GCAM)
                .setBook(book)
                .setAccountId(account)
                .setSecurityId(security)
                .setInitiatedBy("SYNTH")
                .setAllocation(
                        AllocationMessage.newBuilder()
                                .setBlockId(blockId)
                                .setAllocationId(allocationId)
                                .setVersion(version)
                                .setGcamMessageId("GCAM-%d-%d".formatted(key, version))
                                .setType(AllocationType.SWAP)
                                .setBook(book)
                                .setClientAccount(account)
                                .setSecurityId(security)
                                .setTradeDate("2026-06-10")
                                .setQuantity(100 + (key % 900))
                                .setDirection(key % 2 == 0 ? "BUY" : "SELL")
                                .setSchemaVersion(1))
                .build();
    }
}
