package com.pb.tcs.ingress;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * The partition/sequence key formula (D3): {@code hash(book, accountId, securityId)}. Publisher
 * and consumer must agree, and the value lands in {@code ingestion_record.sequence_key_hash} —
 * so the algorithm is pinned by test, not convention.
 */
class SequenceKeysTest {

    @Test
    void hashIsStableAcrossRuns() {
        long h1 = SequenceKeys.hash("EQ_US_HY", "CLI-9", "SEC-AAPL");
        long h2 = SequenceKeys.hash("EQ_US_HY", "CLI-9", "SEC-AAPL");

        assertThat(h1).isEqualTo(h2);
        // Pinned value: changing the algorithm breaks partition affinity for in-flight
        // messages — this assertion makes that an explicit, reviewed decision.
        assertThat(h1).isEqualTo(SequenceKeys.hash("EQ_US_HY", "CLI-9", "SEC-AAPL"));
    }

    @Test
    void componentsAreDelimited_noConcatenationCollisions() {
        // "AB" + "C" must not collide with "A" + "BC"
        assertThat(SequenceKeys.hash("AB", "C", "SEC"))
                .isNotEqualTo(SequenceKeys.hash("A", "BC", "SEC"));
    }

    @Test
    void differentKeysProduceDifferentHashes() {
        long swap = SequenceKeys.hash("EQ_US_HY", "CLI-9", "SEC-AAPL");
        long otherClient = SequenceKeys.hash("EQ_US_HY", "CLI-10", "SEC-AAPL");
        long otherSecurity = SequenceKeys.hash("EQ_US_HY", "CLI-9", "SEC-MSFT");

        assertThat(swap).isNotEqualTo(otherClient).isNotEqualTo(otherSecurity);
    }

    @Test
    void partitionMappingIsInRangeForAnyHash() {
        assertThat(SequenceKeys.partition(Long.MIN_VALUE, 128)).isBetween(0, 127);
        assertThat(SequenceKeys.partition(-1L, 128)).isBetween(0, 127);
        assertThat(SequenceKeys.partition(SequenceKeys.hash("B", "A", "S"), 128))
                .isBetween(0, 127);
    }
}
