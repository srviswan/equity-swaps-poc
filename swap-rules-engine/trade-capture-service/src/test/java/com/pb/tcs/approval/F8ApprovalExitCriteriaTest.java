package com.pb.tcs.approval;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.approval.ApprovalGateStage;
import com.pb.tcs.config.ApprovalWorkflowConfig;
import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.ingress.PipelineResult;
import com.pb.tcs.manual.BulkUploadService;
import com.pb.tcs.persistence.InMemoryApprovalStore;
import com.pb.tcs.persistence.InMemoryBulkBatchStore;
import com.pb.tcs.persistence.InMemoryIngestionLifecycleStore;
import com.pb.tcs.pipeline.TradeProcessingPipeline;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.AllocationType;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import com.pb.tcs.repair.BusinessValidationStage;
import com.pb.tcs.repair.InMemoryBlotterStore;
import com.pb.tcs.repair.InMemoryRepairStore;
import com.pb.tcs.rules.BlotterAssembler;
import com.pb.tcs.rules.F3Fixtures;
import com.pb.tcs.rules.RuleSetLoader;
import com.pb.tcs.validation.BusinessValidator;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * F8 exit criteria (FR-301–303, FR-500–506):
 *
 * <ul>
 *   <li>STP initiators pass the gate; non-STP trades park with {@code PENDING_APPROVAL}.
 *   <li>Concurrent same-key: parked trade does not block STP processing (FR-302).
 *   <li>Approval resume continues at business validation (stage 6).
 *   <li>Bulk CSV validation handles large files; batch status rollup.
 *   <li>15-minute timeout escalation fires without auto-deny (FR-303).
 * </ul>
 */
class F8ApprovalExitCriteriaTest {

    private static final Instant NOW = Instant.parse("2026-06-10T21:00:00Z");

    private InMemoryIngestionLifecycleStore lifecycle;
    private InMemoryApprovalStore approvalStore;
    private RecordingApprovalServiceClient approvalClient;
    private TradeProcessingPipeline pipeline;
    private ApprovalTimeoutScheduler timeoutScheduler;
    private BulkUploadService bulkUpload;

    @BeforeEach
    void setUp() {
        lifecycle = new InMemoryIngestionLifecycleStore();
        approvalStore = new InMemoryApprovalStore();
        approvalStore.bindLifecycle(lifecycle);
        approvalClient = new RecordingApprovalServiceClient();
        ApprovalWorkflowConfig config = TcsConfigLoader.approvalWorkflow();
        ApprovalGate gate = new ApprovalGate(config);
        ApprovalGateStage gateStage =
                new ApprovalGateStage(
                        gate,
                        approvalStore,
                        approvalClient,
                        config,
                        new ApprovalMetrics(new SimpleMeterRegistry()),
                        Clock.fixed(NOW, ZoneOffset.UTC));
        BlotterAssembler assembler =
                new BlotterAssembler(RuleSetLoader.fromClasspath("fixtures/rules/f3-golden-rules.yml"));
        BusinessValidationStage businessValidation =
                new BusinessValidationStage(
                        new BusinessValidator(TcsConfigLoader.businessValidation()),
                        new InMemoryBlotterStore(),
                        new InMemoryRepairStore());
        pipeline =
                new TradeProcessingPipeline(
                        assembler, gateStage, businessValidation, lifecycle, approvalStore);
        timeoutScheduler =
                new ApprovalTimeoutScheduler(
                        approvalStore,
                        new ApprovalMetrics(new SimpleMeterRegistry()),
                        Clock.fixed(NOW.plusSeconds(16 * 60), ZoneOffset.UTC));
        bulkUpload = new BulkUploadService(new InMemoryBulkBatchStore(), config);
    }

    @Test
    void gcamStpPassesGateAndBusinessValidation() {
        EnrichedAllocation enriched = F3Fixtures.usNyseSwap("BLK-STP", 1, "2026-06-10");
        UUID ingestionId = lifecycle.persistEnrichedAndReturnId(enriched);

        PipelineResult result = pipeline.continueAfterEnrich(enriched, ingestionId);

        assertThat(result.disposition()).isEqualTo(PipelineResult.Disposition.BLOTTER_READY);
        assertThat(lifecycle.findByIngestionId(ingestionId).orElseThrow().status())
                .isEqualTo(ApprovalGateStage.STATUS_READY);
        assertThat(approvalClient.trades()).isEmpty();
    }

    @Test
    void nonStpInitiatorParksAndNotifiesApprovalService() {
        EnrichedAllocation enriched = manualEnriched("BLK-PARK", "ta_jsmith");
        UUID ingestionId = lifecycle.persistEnrichedAndReturnId(enriched);

        PipelineResult result = pipeline.continueAfterEnrich(enriched, ingestionId);

        assertThat(result.disposition()).isEqualTo(PipelineResult.Disposition.GATE_PARKED);
        assertThat(lifecycle.findByIngestionId(ingestionId).orElseThrow().status())
                .isEqualTo(ApprovalGateStage.STATUS_PENDING);
        assertThat(approvalClient.trades()).hasSize(1);
        assertThat(approvalClient.trades().get(0).initiatedBy()).isEqualTo("ta_jsmith");
    }

    @Test
    void concurrentSameKey_stpProceedsWhileOtherTradeParked() {
        EnrichedAllocation parked = manualEnriched("BLK-A", "ta_jsmith");
        UUID parkedId = lifecycle.persistEnrichedAndReturnId(parked);
        assertThat(pipeline.continueAfterEnrich(parked, parkedId).disposition())
                .isEqualTo(PipelineResult.Disposition.GATE_PARKED);

        EnrichedAllocation stp = F3Fixtures.usNyseSwap("BLK-B", 1, "2026-06-10");
        UUID stpId = lifecycle.persistEnrichedAndReturnId(stp);
        PipelineResult stpResult = pipeline.continueAfterEnrich(stp, stpId);

        assertThat(stpResult.disposition()).isEqualTo(PipelineResult.Disposition.BLOTTER_READY);
        assertThat(lifecycle.findByIngestionId(parkedId).orElseThrow().status())
                .isEqualTo(ApprovalGateStage.STATUS_PENDING);
    }

    @Test
    void approvalResumeContinuesAtStageSix() {
        EnrichedAllocation enriched = manualEnriched("BLK-RES", "ta_jsmith");
        UUID ingestionId = lifecycle.persistEnrichedAndReturnId(enriched);
        pipeline.continueAfterEnrich(enriched, ingestionId);
        String approvalId = approvalClient.trades().get(0).approvalId();

        var resume =
                TcsIngressMessage.newBuilder()
                        .setMessageId("resume")
                        .setSource(SourceSystem.MANUAL)
                        .setInitiatedBy("trader_1")
                        .setApprovalResume(
                                com.pb.tcs.proto.allocation.v1.ApprovalResume.newBuilder()
                                        .setIngestionId(ingestionId.toString())
                                        .setApprovalId(approvalId)
                                        .setApprovedBy("trader_1")
                                        .setApprovedAtUtc(NOW.toString())
                                        .build())
                        .build();

        PipelineResult result = pipeline.processApprovalResume(resume);

        assertThat(result.disposition()).isEqualTo(PipelineResult.Disposition.BLOTTER_READY);
        assertThat(lifecycle.findByIngestionId(ingestionId).orElseThrow().status())
                .isEqualTo(ApprovalGateStage.STATUS_READY);
    }

    @Test
    void bulkUpload_validatesTenThousandRows() {
        String header =
                "block_id,allocation_id,book,client_account,security_id,trade_date,quantity,direction,exchange,asset_type,type";
        String row = "MAN-B1-1,ALL-1,EQ_US_HY,CLI-9,SEC-AAPL,2026-06-10,1000,BUY,XNYS,SINGLE_STOCK,SWAP";
        String csv =
                header
                        + "\n"
                        + IntStream.rangeClosed(1, 10_000)
                                .mapToObj(i -> row.replace("MAN-B1-1", "MAN-B1-" + i))
                                .collect(Collectors.joining("\n"));

        BulkUploadService.UploadReport report = bulkUpload.validateUpload(csv, "ta_jsmith");

        assertThat(report.validCount()).isEqualTo(10_000);
        assertThat(report.invalidCount()).isZero();
        assertThat(bulkUpload.status(report.batchId()).totalRows()).isEqualTo(10_000);
    }

    @Test
    void approvalTimeoutEscalatesWithoutAutoDeny() {
        EnrichedAllocation enriched = manualEnriched("BLK-TMO", "ta_jsmith");
        UUID ingestionId = lifecycle.persistEnrichedAndReturnId(enriched);
        pipeline.continueAfterEnrich(enriched, ingestionId);

        var expired = timeoutScheduler.sweep();

        assertThat(expired).hasSize(1);
        assertThat(lifecycle.findByIngestionId(ingestionId).orElseThrow().status())
                .isEqualTo(ApprovalGateStage.STATUS_PENDING);
    }

    private static EnrichedAllocation manualEnriched(String blockId, String initiatedBy) {
        AllocationMessage alloc =
                AllocationMessage.newBuilder()
                        .setBlockId(blockId)
                        .setAllocationId("ALL-1")
                        .setVersion(1)
                        .setGcamMessageId("MAN-" + blockId)
                        .setType(AllocationType.SWAP)
                        .setSource(SourceSystem.MANUAL)
                        .setBook("EQ_US_HY")
                        .setClientAccount("CLI-9")
                        .setSecurityId("SEC-AAPL")
                        .setTradeDate("2026-06-10")
                        .setQuantity(1000)
                        .setDirection("BUY")
                        .setExchange("NYSE")
                        .setAssetType("SINGLE_STOCK")
                        .setClientMasterNo("H12456")
                        .setLocation("US")
                        .setSchemaVersion(1)
                        .build();
        TcsIngressMessage env =
                TcsIngressMessage.newBuilder()
                        .setMessageId("M-" + blockId)
                        .setSource(SourceSystem.MANUAL)
                        .setBook("EQ_US_HY")
                        .setAccountId("CLI-9")
                        .setSecurityId("SEC-AAPL")
                        .setInitiatedBy(initiatedBy)
                        .setAllocation(alloc)
                        .build();
        return new EnrichedAllocation(
                env, env.toByteArray(), "{}", "{}", "{}", null);
    }
}
