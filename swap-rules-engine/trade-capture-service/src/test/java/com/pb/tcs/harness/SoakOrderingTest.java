package com.pb.tcs.harness;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.ingress.IngressConsumer;
import com.pb.tcs.ingress.IngressMetrics;
import com.pb.tcs.ingress.IngressPipeline;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.time.Clock;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * F1.6 exit criterion 1 — soak: 2M/day profile, zero per-key ordering violations (NFR-5).
 *
 * <p>Default run is scaled to 200K messages (seconds, in-memory); the full certification run is
 * {@code mvn test -Pperf -Dtcs.soak.messages=2000000}. Per-key ordering is asserted inline by
 * {@link ConcurrentRecordingStore} on every persist — a violation anywhere in the run fails.
 */
@Tag("perf")
class SoakOrderingTest {

    private static final int PARTITIONS = 16;

    @Test
    void soakProducesZeroOrderingViolationsAndExactlyOnePersistPerVersion() throws Exception {
        int messages = Integer.getInteger("tcs.soak.messages", 200_000);
        int versionsPerKey = 8;
        int keys = messages / versionsPerKey;

        ConcurrentRecordingStore store = new ConcurrentRecordingStore();
        ConcurrentHoldStore holds = new ConcurrentHoldStore();
        IngressConsumer consumer =
                new IngressConsumer(
                        new IngressPipeline(
                                store,
                                holds,
                                new UniversalReferenceData(),
                                TcsConfigLoader.versionGap(),
                                TcsConfigLoader.ingress(),
                                Clock.systemUTC()),
                        new IngressMetrics(new SimpleMeterRegistry()));

        try (PartitionedReplayer replayer = new PartitionedReplayer(PARTITIONS, consumer, 3)) {
            replayer.start();
            SyntheticAllocationGenerator.uniform(keys, versionsPerKey, 20260610L)
                    .forEach(replayer::publish);
            assertThat(replayer.awaitDrained(300_000)).as("drained within 5 min").isTrue();

            assertThat(store.orderingViolations()).isEmpty();
            assertThat(store.duplicatePersists()).isEmpty();
            assertThat(store.totalPersists()).isEqualTo(keys * versionsPerKey);
            assertThat(store.distinctKeys()).isEqualTo(keys);
            assertThat(store.quarantines()).isEmpty();
            assertThat(holds.size()).as("no stuck version-gap holds").isZero();
            assertThat(replayer.dlqSize()).isZero();
        }
    }
}
