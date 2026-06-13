package com.pb.tcs.boot;

import com.pb.tcs.api.CrossRefApi;
import com.pb.tcs.api.ManualTradeApi;
import com.pb.tcs.api.ParityApi;
import com.pb.tcs.api.ReconApi;
import com.pb.tcs.api.TradeApi;
import com.pb.tcs.approval.ApprovalCallbackHandler;
import com.pb.tcs.approval.ApprovalGate;
import com.pb.tcs.approval.ApprovalGateStage;
import com.pb.tcs.approval.ApprovalMetrics;
import com.pb.tcs.approval.ApprovalServiceClient;
import com.pb.tcs.approval.ApprovalStore;
import com.pb.tcs.archive.ArchivePartitionService;
import com.pb.tcs.archive.InMemoryArchiveRunStore;
import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.crossref.CrossRefExecutor;
import com.pb.tcs.crossref.CrossRefMetrics;
import com.pb.tcs.crossref.CrossRefOpsService;
import com.pb.tcs.crossref.CrossRefPlanner;
import com.pb.tcs.crossref.CrossRefQueryService;
import com.pb.tcs.crossref.CrossRefStore;
import com.pb.tcs.crossref.CrossRefSyncService;
import com.pb.tcs.crossref.InMemoryCrossRefStore;
import com.pb.tcs.crossref.StubCrossRefPublisher;
import com.pb.tcs.cutover.CutoverPolicy;
import com.pb.tcs.dispatch.BusinessAckHandler;
import com.pb.tcs.dispatch.BusinessAckMetrics;
import com.pb.tcs.dispatch.DispatchExecutor;
import com.pb.tcs.dispatch.DispatchMetrics;
import com.pb.tcs.dispatch.DispatchPlanner;
import com.pb.tcs.dispatch.InMemoryBusinessAckStore;
import com.pb.tcs.dispatch.InMemoryDispatchRecordStore;
import com.pb.tcs.dispatch.InMemoryIngestionDispatchStatusUpdater;
import com.pb.tcs.dispatch.InMemoryRoutingDecisionStore;
import com.pb.tcs.dispatch.StubDownstreamPublisher;
import com.pb.tcs.ingress.IngestionLifecycleStore;
import com.pb.tcs.ingress.IngressPublisher;
import com.pb.tcs.ingress.InMemoryHoldStore;
import com.pb.tcs.ingress.RecordingIngressPublisher;
import com.pb.tcs.lookup.InMemoryArchivedTradeIndex;
import com.pb.tcs.lookup.InMemoryHotTradeIndex;
import com.pb.tcs.lookup.StubSystemAFallbackClient;
import com.pb.tcs.lookup.TradeJourneyService;
import com.pb.tcs.lookup.TradeLookupService;
import com.pb.tcs.lookup.TradeResendService;
import com.pb.tcs.manual.BulkUploadService;
import com.pb.tcs.manual.ManualTradePreviewService;
import com.pb.tcs.manual.ManualTradeSubmitService;
import com.pb.tcs.parity.InMemoryLegacyBlotterStore;
import com.pb.tcs.parity.ParityFieldComparator;
import com.pb.tcs.parity.ParityHarnessService;
import com.pb.tcs.persistence.InMemoryApprovalStore;
import com.pb.tcs.persistence.InMemoryBulkBatchStore;
import com.pb.tcs.persistence.InMemoryIngestionLifecycleStore;
import com.pb.tcs.pipeline.TradeProcessingPipeline;
import com.pb.tcs.recon.AutoHealDispatcher;
import com.pb.tcs.recon.BreakWorkflowService;
import com.pb.tcs.recon.InMemoryReconSnapshotLoader;
import com.pb.tcs.recon.InMemoryReconStore;
import com.pb.tcs.recon.ReconMetrics;
import com.pb.tcs.recon.ReconService;
import com.pb.tcs.reference.DemoReferenceData;
import com.pb.tcs.repair.BusinessValidationStage;
import com.pb.tcs.repair.InMemoryBlotterStore;
import com.pb.tcs.repair.InMemoryRepairStore;
import com.pb.tcs.routing.MatchKeyBuilder;
import com.pb.tcs.routing.RoutingEngine;
import com.pb.tcs.routing.RoutingStage;
import com.pb.tcs.routing.StubPositionService;
import com.pb.tcs.rules.BlotterAssembler;
import com.pb.tcs.rules.RuleSetLoader;
import com.pb.tcs.validation.BusinessValidator;
import io.micrometer.core.instrument.MeterRegistry;
import java.time.Clock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/** In-memory demo wiring for local ops UI and REST APIs (zero Docker). */
@Configuration
@Profile("demo")
class TcsDemoConfiguration {

    @Bean
    Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    BlotterAssembler blotterAssembler(@Value("${tcs.demo.rules-fixture}") String rulesFixture) {
        return new BlotterAssembler(RuleSetLoader.fromClasspath(rulesFixture));
    }

    @Bean
    InMemoryBlotterStore blotterStore() {
        return new InMemoryBlotterStore();
    }

    @Bean
    InMemoryDispatchRecordStore dispatchStore() {
        return new InMemoryDispatchRecordStore();
    }

    @Bean
    InMemoryRoutingDecisionStore routingStore() {
        return new InMemoryRoutingDecisionStore();
    }

    @Bean
    InMemoryIngestionDispatchStatusUpdater ingestionDispatchStatus() {
        return new InMemoryIngestionDispatchStatusUpdater();
    }

    @Bean
    InMemoryBusinessAckStore businessAckStore() {
        return new InMemoryBusinessAckStore();
    }

    @Bean
    InMemoryCrossRefStore crossRefStore() {
        return new InMemoryCrossRefStore();
    }

    @Bean
    InMemoryIngestionLifecycleStore lifecycleStore() {
        return new InMemoryIngestionLifecycleStore();
    }

    @Bean
    InMemoryApprovalStore approvalStore(InMemoryIngestionLifecycleStore lifecycleStore) {
        InMemoryApprovalStore store = new InMemoryApprovalStore();
        store.bindLifecycle(lifecycleStore);
        return store;
    }

    @Bean
    InMemoryRepairStore repairStore() {
        return new InMemoryRepairStore();
    }

    @Bean
    InMemoryHotTradeIndex hotTradeIndex() {
        return new InMemoryHotTradeIndex();
    }

    @Bean
    InMemoryArchivedTradeIndex archivedTradeIndex() {
        return new InMemoryArchivedTradeIndex();
    }

    @Bean
    InMemoryArchiveRunStore archiveRunStore() {
        return new InMemoryArchiveRunStore();
    }

    @Bean
    InMemoryBulkBatchStore bulkBatchStore() {
        return new InMemoryBulkBatchStore();
    }

    @Bean
    InMemoryReconStore reconStore() {
        return new InMemoryReconStore();
    }

    @Bean
    InMemoryReconSnapshotLoader reconSnapshotLoader() {
        return new InMemoryReconSnapshotLoader();
    }

    @Bean
    InMemoryLegacyBlotterStore legacyBlotterStore() {
        return new InMemoryLegacyBlotterStore();
    }

    @Bean
    StubDownstreamPublisher downstreamPublisher() {
        return new StubDownstreamPublisher();
    }

    @Bean
    StubCrossRefPublisher crossRefPublisher() {
        return new StubCrossRefPublisher();
    }

    @Bean
    StubPositionService positionService() {
        return new StubPositionService();
    }

    @Bean
    StubSystemAFallbackClient systemAFallbackClient() {
        return new StubSystemAFallbackClient();
    }

    @Bean
    RecordingIngressPublisher ingressPublisher() {
        return new RecordingIngressPublisher();
    }

    @Bean
    CutoverPolicy cutoverPolicy() {
        return CutoverPolicy.liveAll();
    }

    @Bean
    ApprovalServiceClient approvalServiceClient() {
        return new NoOpApprovalServiceClient();
    }

    @Bean
    CrossRefExecutor crossRefExecutor(
            CrossRefStore crossRefStore,
            StubCrossRefPublisher crossRefPublisher,
            MeterRegistry meterRegistry,
            Clock clock) {
        return new CrossRefExecutor(
                crossRefStore, crossRefPublisher, new CrossRefMetrics(meterRegistry), clock);
    }

    @Bean
    CrossRefSyncService crossRefSyncService(
            CrossRefStore crossRefStore,
            InMemoryDispatchRecordStore dispatchStore,
            InMemoryBusinessAckStore ackStore,
            InMemoryRoutingDecisionStore routingStore,
            CrossRefExecutor crossRefExecutor) {
        CrossRefPlanner planner = new CrossRefPlanner(crossRefStore, routingStore);
        return new CrossRefSyncService(
                planner, crossRefStore, dispatchStore, ackStore, routingStore, crossRefExecutor);
    }

    @Bean
    CrossRefApi crossRefApi(
            CrossRefStore crossRefStore,
            CrossRefSyncService syncService,
            CrossRefExecutor crossRefExecutor) {
        return new CrossRefApi(
                new CrossRefQueryService(crossRefStore),
                syncService,
                new CrossRefOpsService(crossRefStore, crossRefExecutor));
    }

    @Bean
    TradeLookupService tradeLookupService(
            InMemoryHotTradeIndex hotTradeIndex,
            InMemoryArchivedTradeIndex archivedTradeIndex,
            StubSystemAFallbackClient systemAFallbackClient) {
        return new TradeLookupService(hotTradeIndex, archivedTradeIndex, systemAFallbackClient);
    }

    @Bean
    TradeJourneyService tradeJourneyService(
            IngestionLifecycleStore lifecycleStore,
            InMemoryBlotterStore blotterStore,
            InMemoryRoutingDecisionStore routingStore,
            InMemoryDispatchRecordStore dispatchStore,
            InMemoryBusinessAckStore businessAckStore,
            CrossRefStore crossRefStore,
            ApprovalStore approvalStore) {
        return new TradeJourneyService(
                lifecycleStore,
                blotterStore,
                routingStore,
                dispatchStore,
                businessAckStore,
                crossRefStore,
                approvalStore);
    }

    @Bean
    TradeResendService tradeResendService(
            InMemoryDispatchRecordStore dispatchStore,
            InMemoryBlotterStore blotterStore,
            InMemoryRoutingDecisionStore routingStore,
            StubDownstreamPublisher downstreamPublisher,
            CutoverPolicy cutoverPolicy,
            Clock clock) {
        return new TradeResendService(
                dispatchStore, blotterStore, routingStore, downstreamPublisher, cutoverPolicy, clock);
    }

    @Bean
    ArchivePartitionService archivePartitionService(
            InMemoryArchiveRunStore archiveRunStore,
            InMemoryArchivedTradeIndex archivedTradeIndex,
            InMemoryHotTradeIndex hotTradeIndex,
            CutoverPolicy cutoverPolicy,
            Clock clock) {
        return new ArchivePartitionService(
                archiveRunStore, archivedTradeIndex, hotTradeIndex, cutoverPolicy, clock);
    }

    @Bean
    TradeApi tradeApi(
            TradeLookupService tradeLookupService,
            TradeJourneyService tradeJourneyService,
            TradeResendService tradeResendService,
            ArchivePartitionService archivePartitionService) {
        return new TradeApi(
                tradeLookupService, tradeJourneyService, tradeResendService, archivePartitionService);
    }

    @Bean
    ManualTradePreviewService manualTradePreviewService(BlotterAssembler assembler) {
        return new ManualTradePreviewService(assembler, new ApprovalGate(TcsConfigLoader.approvalWorkflow()));
    }

    @Bean
    ManualTradeSubmitService manualTradeSubmitService(IngressPublisher ingressPublisher) {
        return new ManualTradeSubmitService(ingressPublisher);
    }

    @Bean
    BulkUploadService bulkUploadService(InMemoryBulkBatchStore bulkBatchStore) {
        return new BulkUploadService(bulkBatchStore, TcsConfigLoader.approvalWorkflow());
    }

    @Bean
    ApprovalCallbackHandler approvalCallbackHandler(
            ApprovalStore approvalStore,
            IngestionLifecycleStore lifecycleStore,
            IngressPublisher ingressPublisher,
            InMemoryBulkBatchStore bulkBatchStore,
            MeterRegistry meterRegistry) {
        return new ApprovalCallbackHandler(
                approvalStore,
                lifecycleStore,
                ingressPublisher,
                new ApprovalMetrics(meterRegistry),
                bulkBatchStore);
    }

    @Bean
    ManualTradeApi manualTradeApi(
            ManualTradePreviewService previewService,
            ManualTradeSubmitService submitService,
            BulkUploadService bulkUploadService,
            ApprovalCallbackHandler approvalCallbackHandler) {
        return new ManualTradeApi(previewService, submitService, bulkUploadService, approvalCallbackHandler);
    }

    @Bean
    ParityHarnessService parityHarnessService(
            InMemoryLegacyBlotterStore legacyBlotterStore, BlotterAssembler assembler) {
        return new ParityHarnessService(
                legacyBlotterStore, assembler, new ParityFieldComparator(TcsConfigLoader.parityManifest()));
    }

    @Bean
    ParityApi parityApi(ParityHarnessService parityHarnessService) {
        return new ParityApi(parityHarnessService);
    }

    @Bean
    ReconService reconService(
            InMemoryReconStore reconStore,
            InMemoryReconSnapshotLoader reconSnapshotLoader,
            MeterRegistry meterRegistry,
            Clock clock) {
        return new ReconService(
                reconStore,
                reconSnapshotLoader,
                TcsConfigLoader.reconPolicy(),
                new ParityFieldComparator(TcsConfigLoader.parityManifest()),
                new ReconMetrics(meterRegistry),
                clock);
    }

    @Bean
    AutoHealDispatcher autoHealDispatcher(CrossRefApi crossRefApi, TradeResendService tradeResendService) {
        return new AutoHealDispatcher(crossRefApi, tradeResendService);
    }

    @Bean
    BreakWorkflowService breakWorkflowService(
            InMemoryReconStore reconStore, AutoHealDispatcher autoHealDispatcher, Clock clock) {
        return new BreakWorkflowService(
                reconStore, TcsConfigLoader.reconPolicy(), autoHealDispatcher, clock);
    }

    @Bean
    ReconApi reconApi(ReconService reconService, BreakWorkflowService breakWorkflowService) {
        return new ReconApi(reconService, breakWorkflowService);
    }

    @Bean
    BusinessValidationStage businessValidationStage(
            InMemoryBlotterStore blotterStore, InMemoryRepairStore repairStore) {
        return new BusinessValidationStage(
                new BusinessValidator(TcsConfigLoader.businessValidation()), blotterStore, repairStore);
    }

    @Bean
    ApprovalGateStage approvalGateStage(
            ApprovalStore approvalStore,
            ApprovalServiceClient approvalServiceClient,
            MeterRegistry meterRegistry,
            Clock clock) {
        var config = TcsConfigLoader.approvalWorkflow();
        return new ApprovalGateStage(
                new ApprovalGate(config),
                approvalStore,
                approvalServiceClient,
                config,
                new ApprovalMetrics(meterRegistry),
                clock);
    }

    @Bean
    DispatchMetrics dispatchMetrics(MeterRegistry meterRegistry) {
        return new DispatchMetrics(meterRegistry);
    }

    @Bean
    DemoReferenceData demoReferenceData() {
        return new DemoReferenceData();
    }

    @Bean
    InMemoryHoldStore versionGapHoldStore() {
        return new InMemoryHoldStore();
    }

    @Bean
    TradeProcessingPipeline tradeProcessingPipeline(
            BlotterAssembler assembler,
            ApprovalGateStage approvalGateStage,
            BusinessValidationStage businessValidationStage,
            InMemoryIngestionLifecycleStore lifecycleStore,
            InMemoryApprovalStore approvalStore) {
        return new TradeProcessingPipeline(
                assembler, approvalGateStage, businessValidationStage, lifecycleStore, approvalStore);
    }

    @Bean
    RoutingStage routingStage(
            InMemoryRoutingDecisionStore routingStore, InMemoryRepairStore repairStore) {
        return new RoutingStage(
                new RoutingEngine(TcsConfigLoader.routingRules()),
                new MatchKeyBuilder(TcsConfigLoader.positionMatchKey()),
                new StubPositionService(),
                routingStore,
                repairStore);
    }

    @Bean
    BusinessAckHandler businessAckHandler(
            InMemoryDispatchRecordStore dispatchStore,
            InMemoryBusinessAckStore ackStore,
            InMemoryBlotterStore blotterStore,
            InMemoryRepairStore repairStore,
            MeterRegistry meterRegistry,
            CrossRefStore crossRefStore,
            InMemoryRoutingDecisionStore routingStore) {
        CrossRefPlanner planner = new CrossRefPlanner(crossRefStore, routingStore);
        return new BusinessAckHandler(
                dispatchStore,
                ackStore,
                blotterStore,
                repairStore,
                new BusinessAckMetrics(meterRegistry),
                planner);
    }

    /** Live dispatch for demo E2E runs (shadow mode skips downstream publish). */
    @Bean
    DispatchPlanner demoRunDispatchPlanner(
            InMemoryDispatchRecordStore dispatchStore,
            InMemoryIngestionDispatchStatusUpdater ingestionStatus) {
        return new DispatchPlanner(dispatchStore, ingestionStatus, CutoverPolicy.liveAll());
    }

    @Bean
    DispatchExecutor demoRunDispatchExecutor(
            InMemoryDispatchRecordStore dispatchStore,
            InMemoryBlotterStore blotterStore,
            InMemoryRoutingDecisionStore routingStore,
            StubDownstreamPublisher publisher,
            InMemoryIngestionDispatchStatusUpdater ingestionStatus,
            DispatchMetrics dispatchMetrics,
            Clock clock) {
        return new DispatchExecutor(
                dispatchStore,
                blotterStore,
                routingStore,
                publisher,
                TcsConfigLoader.routingRules(),
                ingestionStatus,
                dispatchMetrics,
                clock,
                CutoverPolicy.liveAll());
    }
}
