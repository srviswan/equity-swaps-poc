package com.pb.tcs.approval;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.ingress.RecordingIngressPublisher;
import com.pb.tcs.persistence.InMemoryApprovalStore;
import com.pb.tcs.persistence.InMemoryBulkBatchStore;
import com.pb.tcs.persistence.InMemoryIngestionLifecycleStore;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import com.pb.tcs.rules.BlotterJson;
import com.pb.tcs.rules.F3Fixtures;
import com.pb.tcs.rules.SwapBlotter;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApprovalCallbackHandlerTest {

    private InMemoryIngestionLifecycleStore lifecycle;
    private InMemoryApprovalStore approvalStore;
    private InMemoryBulkBatchStore batchStore;
    private RecordingIngressPublisher publisher;
    private ApprovalCallbackHandler handler;

    @BeforeEach
    void setUp() {
        lifecycle = new InMemoryIngestionLifecycleStore();
        approvalStore = new InMemoryApprovalStore();
        approvalStore.bindLifecycle(lifecycle);
        batchStore = new InMemoryBulkBatchStore();
        publisher = new RecordingIngressPublisher();
        handler =
                new ApprovalCallbackHandler(
                        approvalStore,
                        lifecycle,
                        publisher,
                        new ApprovalMetrics(new SimpleMeterRegistry()),
                        batchStore);
    }

    @Test
    void publishResumeUsesBlotterSequenceKey() {
        EnrichedAllocation enriched = F3Fixtures.usNyseSwap("BLK-RESUME", 1, "2026-06-10");
        UUID ingestionId = lifecycle.persistEnrichedAndReturnId(enriched);
        String approvalId =
                approvalStore.park(
                        new ApprovalStore.ParkCommand(
                                ingestionId,
                                enriched.correlationId(),
                                null,
                                ApprovalKind.TRADE,
                                "ta_jsmith",
                                "LIVE",
                                BlotterJson.toJson(sampleBlotter(enriched.correlationId(), "BLK-RESUME")),
                                null,
                                Instant.now().plusSeconds(900)));

        handler.handle(
                new ApprovalCallbackHandler.ApprovalCallback(
                        approvalId,
                        ingestionId.toString(),
                        "APPROVED",
                        "ALL",
                        List.of(),
                        "approver_1",
                        Instant.now()));

        TcsIngressMessage resume = publisher.published().getLast();
        assertThat(resume.getBook()).isEqualTo("EQ_US_HY");
        assertThat(resume.getAccountId()).isEqualTo("CLI-9");
        assertThat(resume.getSecurityId()).isEqualTo("SEC-AAPL");
    }

    @Test
    void rowsScopeDeniesCarvedOutRowsAndResumesApprovedOnes() {
        batchStore.createBatch("BATCH-1", "uploader", 2, 2, 0);
        batchStore.recordRow("BATCH-1", 1, "MAN-B1-1", true, null);
        batchStore.recordRow("BATCH-1", 2, "MAN-B1-2", true, null);
        batchStore.markSubmitted("BATCH-1", 1);
        batchStore.markSubmitted("BATCH-1", 2);

        EnrichedAllocation row1 = F3Fixtures.usNyseSwap("MAN-B1-1", 1, "2026-06-10");
        EnrichedAllocation row2 = F3Fixtures.usNyseSwap("MAN-B1-2", 1, "2026-06-10");
        UUID ingestion1 = lifecycle.persistEnrichedAndReturnId(row1);
        UUID ingestion2 = lifecycle.persistEnrichedAndReturnId(row2);

        String approvalId =
                approvalStore.park(
                        new ApprovalStore.ParkCommand(
                                ingestion1,
                                row1.correlationId(),
                                "BATCH-1",
                                ApprovalKind.BATCH,
                                "uploader",
                                "LIVE",
                                BlotterJson.toJson(sampleBlotter(row1.correlationId(), "MAN-B1-1")),
                                null,
                                Instant.now().plusSeconds(900)));

        var result =
                handler.handle(
                        new ApprovalCallbackHandler.ApprovalCallback(
                                approvalId,
                                ingestion1.toString(),
                                "APPROVED",
                                "ROWS",
                                List.of(2),
                                "approver_1",
                                Instant.now()));

        assertThat(result.status()).isEqualTo("PARTIAL");
        assertThat(result.carvedOutRows()).containsExactly(2);
        assertThat(batchStore.status("BATCH-1").statusRollup()).containsEntry("DENIED", 1L);
        assertThat(publisher.published()).hasSize(1);
        assertThat(publisher.published().getLast().getApprovalResume().getIngestionId())
                .isEqualTo(ingestion1.toString());
        assertThat(lifecycle.findByIngestionId(ingestion2).orElseThrow().status())
                .isEqualTo("APPROVAL_DENIED");
    }

    private static SwapBlotter sampleBlotter(String correlationId, String blockId) {
        return new SwapBlotter(
                correlationId,
                blockId,
                "ALL-1",
                1,
                "SWAP",
                "EQ_US_HY",
                "CLI-9",
                "SEC-AAPL",
                LocalDate.parse("2026-06-10"),
                "snap-1",
                null);
    }
}
