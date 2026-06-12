package com.pb.tcs.ingress;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;

/**
 * Spec §F1.3: scheduled sweeper moves holds past {@code deadline_at} to
 * {@code repair_quarantine(VERSION_GAP)} and alerts. Drives off a fake clock.
 */
class GapTimeoutSweeperTest {

    private static final Instant NOW = Instant.parse("2026-06-10T14:00:00Z");

    private final InMemoryIngestionStore store = new InMemoryIngestionStore();
    private final InMemoryHoldStore holds = new InMemoryHoldStore();

    private static VersionGapHoldStore.HoldRow holdDueAt(int version, Instant deadline) {
        return new VersionGapHoldStore.HoldRow(
                "BLK-1", "ALL-1", version, version - 1, "EQ_US_HY", deadline, new byte[] {1});
    }

    @Test
    void expiredHoldsAreQuarantinedAndRemoved() {
        holds.hold(holdDueAt(3, NOW.minusSeconds(1)));   // expired
        holds.hold(holdDueAt(4, NOW.plusSeconds(60)));   // still waiting

        GapTimeoutSweeper sweeper =
                new GapTimeoutSweeper(holds, store, Clock.fixed(NOW, ZoneOffset.UTC));
        int swept = sweeper.sweep();

        assertThat(swept).isEqualTo(1);
        assertThat(store.quarantines()).singleElement().satisfies(q -> {
            assertThat(q.category()).isEqualTo("VERSION_GAP");
            assertThat(q.detail()).contains("BLK-1").contains("3");
        });
        assertThat(holds.heldVersions("BLK-1", "ALL-1")).containsExactly(4);
    }

    @Test
    void noExpiredHoldsIsANoOp() {
        holds.hold(holdDueAt(3, NOW.plusSeconds(30)));

        GapTimeoutSweeper sweeper =
                new GapTimeoutSweeper(holds, store, Clock.fixed(NOW, ZoneOffset.UTC));

        assertThat(sweeper.sweep()).isZero();
        assertThat(store.quarantines()).isEmpty();
    }
}
