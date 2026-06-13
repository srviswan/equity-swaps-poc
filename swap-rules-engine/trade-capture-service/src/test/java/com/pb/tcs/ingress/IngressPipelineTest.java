package com.pb.tcs.ingress;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.ingress.PipelineResult.Disposition;
import com.pb.tcs.ingress.PipelineResult.SolaceAction;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.AllocationType;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.SwapBlotterPayload;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * F1 ingress pipeline against the authoritative ACK/NACK matrix (spec §F1.2). Every matrix row is
 * a test. Ports are in-memory fakes — no Solace, no SQL.
 */
class IngressPipelineTest {

    private static final Instant NOW = Instant.parse("2026-06-10T14:00:00Z");

    private InMemoryIngestionStore store;
    private InMemoryHoldStore holds;
    private FakeReferenceData refData;
    private IngressPipeline pipeline;

    @BeforeEach
    void setUp() {
        store = new InMemoryIngestionStore();
        holds = new InMemoryHoldStore();
        refData = new FakeReferenceData();
        pipeline =
                new IngressPipeline(
                        store,
                        holds,
                        refData,
                        TcsConfigLoader.versionGap(),
                        TcsConfigLoader.ingress(),
                        Clock.fixed(NOW, ZoneOffset.UTC));
    }

    // --- builders -----------------------------------------------------------------

    private static TcsIngressMessage swap(String blockId, String allocId, int version) {
        return TcsIngressMessage.newBuilder()
                .setMessageId("M-" + blockId + "-" + version)
                .setSource(SourceSystem.GCAM)
                .setBook("EQ_US_HY")
                .setAccountId("CLI-9")
                .setSecurityId("SEC-AAPL")
                .setAllocation(
                        AllocationMessage.newBuilder()
                                .setBlockId(blockId)
                                .setAllocationId(allocId)
                                .setVersion(version)
                                .setGcamMessageId("GCAM-" + blockId + "-" + version)
                                .setType(AllocationType.SWAP)
                                .setBook("EQ_US_HY")
                                .setClientAccount("CLI-9")
                                .setSecurityId("SEC-AAPL")
                                .setTradeDate("2026-06-10")
                                .setQuantity(1000)
                                .setDirection("BUY")
                                .setExchange("NYSE")
                                .setSchemaVersion(1))
                .build();
    }

    // --- matrix rows --------------------------------------------------------------

    @Test
    void enrichedPersistSuccess_acksAfterCommit() {
        PipelineResult result = pipeline.process(swap("BLK-1", "ALL-1", 1).toByteArray(), 1);

        assertThat(result.solace()).isEqualTo(SolaceAction.ACK);
        assertThat(result.disposition()).isEqualTo(Disposition.ENRICHED);
        assertThat(store.enrichedVersions("BLK-1", "ALL-1")).containsExactly(1);
    }

    @Test
    void duplicateIdempotencyKey_ackNoSideEffects() {
        pipeline.process(swap("BLK-1", "ALL-1", 1).toByteArray(), 1);
        int persistsBefore = store.persistCount();

        PipelineResult result = pipeline.process(swap("BLK-1", "ALL-1", 1).toByteArray(), 1);

        assertThat(result.solace()).isEqualTo(SolaceAction.ACK);
        assertThat(result.disposition()).isEqualTo(Disposition.DUPLICATE);
        assertThat(store.persistCount()).isEqualTo(persistsBefore);
        assertThat(store.auditRejects()).isEmpty();
    }

    @Test
    void unparseableProto_nackWithStructuralAudit() {
        PipelineResult result = pipeline.process(new byte[] {(byte) 0xFF, 0x13, 0x37}, 1);

        assertThat(result.solace()).isEqualTo(SolaceAction.NACK);
        assertThat(result.disposition()).isEqualTo(Disposition.REJECTED_STRUCTURAL);
        assertThat(store.auditRejects()).singleElement().satisfies(r -> {
            assertThat(r.stage()).isEqualTo("STRUCTURAL");
        });
    }

    @Test
    void missingMandatoryField_nackWithMandatoryAudit() {
        TcsIngressMessage noDirection =
                swap("BLK-1", "ALL-1", 1).toBuilder()
                        .setAllocation(
                                swap("BLK-1", "ALL-1", 1).getAllocation().toBuilder()
                                        .clearDirection())
                        .build();

        PipelineResult result = pipeline.process(noDirection.toByteArray(), 1);

        assertThat(result.solace()).isEqualTo(SolaceAction.NACK);
        assertThat(result.disposition()).isEqualTo(Disposition.REJECTED_MANDATORY);
        assertThat(store.auditRejects()).singleElement().satisfies(r -> {
            assertThat(r.stage()).isEqualTo("MANDATORY");
            assertThat(r.reason()).contains("direction");
        });
    }

    @Test
    void refDataMissAttemptsOneAndTwo_nackForRedelivery() {
        refData.removeSecurity("SEC-AAPL");

        PipelineResult first = pipeline.process(swap("BLK-1", "ALL-1", 1).toByteArray(), 1);
        PipelineResult second = pipeline.process(swap("BLK-1", "ALL-1", 1).toByteArray(), 2);

        assertThat(first.solace()).isEqualTo(SolaceAction.NACK);
        assertThat(first.disposition()).isEqualTo(Disposition.REFDATA_RETRY);
        assertThat(second.solace()).isEqualTo(SolaceAction.NACK);
        assertThat(store.auditRejects())
                .hasSize(2)
                .allSatisfy(r -> assertThat(r.stage()).isEqualTo("REFDATA"));
        assertThat(store.auditRejects().get(1).attempt()).isEqualTo(2);
    }

    @Test
    void refDataMissThirdAttempt_ackAndQuarantine() {
        refData.removeSecurity("SEC-AAPL");

        PipelineResult result = pipeline.process(swap("BLK-1", "ALL-1", 1).toByteArray(), 3);

        assertThat(result.solace()).isEqualTo(SolaceAction.ACK);
        assertThat(result.disposition()).isEqualTo(Disposition.REFDATA_QUARANTINED);
        assertThat(store.quarantines()).singleElement().satisfies(q -> {
            assertThat(q.category()).isEqualTo("REFDATA_EXHAUSTED");
        });
        assertThat(store.enrichedVersions("BLK-1", "ALL-1")).isEmpty();
    }

    @Test
    void versionGap_ackAndDurableHoldWithBookDeadline() {
        pipeline.process(swap("BLK-1", "ALL-1", 1).toByteArray(), 1);

        PipelineResult result = pipeline.process(swap("BLK-1", "ALL-1", 3).toByteArray(), 1);

        assertThat(result.solace()).isEqualTo(SolaceAction.ACK);
        assertThat(result.disposition()).isEqualTo(Disposition.HELD);
        assertThat(holds.heldVersions("BLK-1", "ALL-1")).containsExactly(3);
        // EQ_US_HY has a 90s book override in version-gap.yml
        assertThat(holds.deadlineOf("BLK-1", "ALL-1", 3)).isEqualTo(NOW.plusMillis(90000));
    }

    @Test
    void redeliveredWhileAlreadyHeld_ackIdempotently() {
        // crash between hold-commit and Solace ACK: the broker redelivers a version that is
        // already in version_gap_hold — must ACK as already-held, never hit uq_hold and NACK-loop
        pipeline.process(swap("BLK-1", "ALL-1", 1).toByteArray(), 1);
        pipeline.process(swap("BLK-1", "ALL-1", 3).toByteArray(), 1); // held

        PipelineResult redelivered = pipeline.process(swap("BLK-1", "ALL-1", 3).toByteArray(), 2);

        assertThat(redelivered.solace()).isEqualTo(SolaceAction.ACK);
        assertThat(redelivered.disposition()).isEqualTo(Disposition.HELD);
        assertThat(holds.heldVersions("BLK-1", "ALL-1")).containsExactly(3);
    }

    @Test
    void gapFilled_drainsHeldVersionsInOrder() {
        pipeline.process(swap("BLK-1", "ALL-1", 1).toByteArray(), 1);
        pipeline.process(swap("BLK-1", "ALL-1", 3).toByteArray(), 1); // held
        pipeline.process(swap("BLK-1", "ALL-1", 4).toByteArray(), 1); // held

        PipelineResult result = pipeline.process(swap("BLK-1", "ALL-1", 2).toByteArray(), 1);

        assertThat(result.solace()).isEqualTo(SolaceAction.ACK);
        assertThat(result.drainedVersions()).containsExactly(3, 4);
        assertThat(store.enrichedVersions("BLK-1", "ALL-1")).containsExactly(1, 2, 3, 4);
        assertThat(holds.heldVersions("BLK-1", "ALL-1")).isEmpty();
    }

    @Test
    void staleVersion_ackAndAudited() {
        pipeline.process(swap("BLK-1", "ALL-1", 1).toByteArray(), 1);
        pipeline.process(swap("BLK-1", "ALL-1", 2).toByteArray(), 1);

        // a different (late) message for an already-superseded version
        TcsIngressMessage stale =
                swap("BLK-1", "ALL-1", 1).toBuilder()
                        .setAllocation(
                                swap("BLK-1", "ALL-1", 1).getAllocation().toBuilder()
                                        .setGcamMessageId("GCAM-LATE-REPLAY"))
                        .build();
        PipelineResult result = pipeline.process(stale.toByteArray(), 1);

        assertThat(result.solace()).isEqualTo(SolaceAction.ACK);
        assertThat(result.disposition()).isEqualTo(Disposition.DUPLICATE);
        assertThat(store.enrichedVersions("BLK-1", "ALL-1")).containsExactly(1, 2);
    }

    @Test
    void sqlFailureOnPersist_nackRetrySafe() {
        store.failNextPersist();

        PipelineResult result = pipeline.process(swap("BLK-1", "ALL-1", 1).toByteArray(), 1);

        assertThat(result.solace()).isEqualTo(SolaceAction.NACK);
        assertThat(result.disposition()).isEqualTo(Disposition.PERSIST_FAILED);
        assertThat(store.enrichedVersions("BLK-1", "ALL-1")).isEmpty();

        // redelivery succeeds (idempotency-safe)
        PipelineResult retry = pipeline.process(swap("BLK-1", "ALL-1", 1).toByteArray(), 2);
        assertThat(retry.disposition()).isEqualTo(Disposition.ENRICHED);
    }

    @Test
    void blockAllocation_enrichesViaWashBookInsteadOfClientAccount() {
        TcsIngressMessage block =
                TcsIngressMessage.newBuilder()
                        .setMessageId("M-B1")
                        .setSource(SourceSystem.GCAM)
                        .setBook("EQ_US_HY")
                        .setAccountId("WASH-NYSE")
                        .setSecurityId("SEC-AAPL")
                        .setAllocation(
                                AllocationMessage.newBuilder()
                                        .setBlockId("BLK-9")
                                        .setVersion(1)
                                        .setGcamMessageId("GCAM-B9-1")
                                        .setType(AllocationType.BLOCK)
                                        .setBook("EQ_US_HY")
                                        .setSecurityId("SEC-AAPL")
                                        .setTradeDate("2026-06-10")
                                        .setQuantity(5000)
                                        .setDirection("BUY")
                                        .setExchange("NYSE")
                                        .setB2BLeg(true)
                                        .setSchemaVersion(1))
                        .build();

        PipelineResult result = pipeline.process(block.toByteArray(), 1);

        assertThat(result.disposition()).isEqualTo(Disposition.ENRICHED);
        assertThat(store.lastEnriched().washBookRef()).isNotNull();
        assertThat(store.lastEnriched().clientRef()).isNull();
    }

    @Test
    void manualBlotterPayload_notWiredInF1_nacksTowardDlq() {
        TcsIngressMessage manual =
                TcsIngressMessage.newBuilder()
                        .setMessageId("M-MAN")
                        .setSource(SourceSystem.MANUAL)
                        .setManualBlotter(
                                SwapBlotterPayload.newBuilder()
                                        .setBlotterId("BL-1")
                                        .setSchemaVersion(1))
                        .build();

        PipelineResult result = pipeline.process(manual.toByteArray(), 1);

        assertThat(result.solace()).isEqualTo(SolaceAction.NACK);
        assertThat(result.disposition()).isEqualTo(Disposition.UNSUPPORTED_PAYLOAD);
    }
}
