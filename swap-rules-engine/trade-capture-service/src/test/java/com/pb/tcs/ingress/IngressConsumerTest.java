package com.pb.tcs.ingress;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.AllocationType;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Transport binding (spec §F1.1 AckNackController): the consumer applies the pipeline's verdict
 * to the transport message verbatim, emits F1.5 metrics, and never lets an unexpected exception
 * lose a message (NACK → redelivery).
 */
class IngressConsumerTest {

    private InMemoryIngestionStore store;
    private FakeReferenceData refData;
    private SimpleMeterRegistry registry;
    private IngressConsumer consumer;

    @BeforeEach
    void setUp() {
        store = new InMemoryIngestionStore();
        refData = new FakeReferenceData();
        registry = new SimpleMeterRegistry();
        IngressPipeline pipeline =
                new IngressPipeline(
                        store,
                        new InMemoryHoldStore(),
                        refData,
                        TcsConfigLoader.versionGap(),
                        TcsConfigLoader.ingress(),
                        Clock.fixed(Instant.parse("2026-06-10T14:00:00Z"), ZoneOffset.UTC));
        consumer = new IngressConsumer(pipeline, new IngressMetrics(registry));
    }

    private static TcsIngressMessage swap(int version) {
        return TcsIngressMessage.newBuilder()
                .setMessageId("M-" + version)
                .setSource(SourceSystem.GCAM)
                .setBook("EQ_US_HY")
                .setAccountId("CLI-9")
                .setSecurityId("SEC-AAPL")
                .setAllocation(
                        AllocationMessage.newBuilder()
                                .setBlockId("BLK-1")
                                .setAllocationId("ALL-1")
                                .setVersion(version)
                                .setGcamMessageId("GCAM-" + version)
                                .setType(AllocationType.SWAP)
                                .setBook("EQ_US_HY")
                                .setClientAccount("CLI-9")
                                .setSecurityId("SEC-AAPL")
                                .setTradeDate("2026-06-10")
                                .setQuantity(1000)
                                .setDirection("BUY")
                                .setSchemaVersion(1))
                .build();
    }

    @Test
    void ackVerdictAcksTheTransportMessage() {
        FakeTransportMessage msg = new FakeTransportMessage(swap(1).toByteArray(), 1);

        consumer.onMessage(msg);

        assertThat(msg.acked).isTrue();
        assertThat(msg.nacked).isFalse();
        assertThat(store.enrichedVersions("BLK-1", "ALL-1")).containsExactly(1);
    }

    @Test
    void nackVerdictNacksTheTransportMessage() {
        FakeTransportMessage garbage = new FakeTransportMessage(new byte[] {(byte) 0xFF}, 1);

        consumer.onMessage(garbage);

        assertThat(garbage.nacked).isTrue();
        assertThat(garbage.acked).isFalse();
    }

    @Test
    void unexpectedPipelineExceptionNacksForRedelivery() {
        store.failNextPersist(); // surfaces as PERSIST_FAILED → NACK, not thrown
        // also verify a *thrown* runtime error is contained:
        IngressConsumer throwing =
                new IngressConsumer(
                        (raw, attempt) -> {
                            throw new IllegalStateException("boom");
                        },
                        new IngressMetrics(registry));
        FakeTransportMessage msg = new FakeTransportMessage(swap(1).toByteArray(), 1);

        PipelineResult result = throwing.onMessage(msg);

        assertThat(msg.nacked).isTrue();
        assertThat(result.disposition()).isEqualTo(PipelineResult.Disposition.PERSIST_FAILED);
        assertThat(registry.counter("tc.ingress.error").count()).isEqualTo(1);
    }

    @Test
    void metricsEmittedPerOutcome() {
        consumer.onMessage(new FakeTransportMessage(swap(1).toByteArray(), 1)); // enriched
        consumer.onMessage(new FakeTransportMessage(swap(1).toByteArray(), 1)); // duplicate
        consumer.onMessage(new FakeTransportMessage(swap(3).toByteArray(), 1)); // held
        refData.removeSecurity("SEC-AAPL");
        consumer.onMessage(new FakeTransportMessage(swap(2).toByteArray(), 3)); // quarantined

        assertThat(
                        registry.counter(
                                        "tc.ingress.rate",
                                        "type", "SWAP", "source", "GCAM", "book", "EQ_US_HY")
                                .count())
                .isEqualTo(4);
        assertThat(registry.counter("tc.idempotency.duplicate", "source", "GCAM").count())
                .isEqualTo(1);
        assertThat(registry.timer("tc.gcam.ack.latency").count()).isEqualTo(2); // enriched+dup
        assertThat(
                        registry.counter("tc.quarantine.inflow", "category", "REFDATA_EXHAUSTED")
                                .count())
                .isEqualTo(1);
    }

    private static final class FakeTransportMessage implements TransportMessage {
        private final byte[] payload;
        private final int attempt;
        boolean acked;
        boolean nacked;

        FakeTransportMessage(byte[] payload, int attempt) {
            this.payload = payload;
            this.attempt = attempt;
        }

        @Override
        public byte[] payload() {
            return payload;
        }

        @Override
        public int deliveryAttempt() {
            return attempt;
        }

        @Override
        public void ack() {
            acked = true;
        }

        @Override
        public void nack() {
            nacked = true;
        }
    }
}
