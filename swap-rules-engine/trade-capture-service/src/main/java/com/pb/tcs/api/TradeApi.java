package com.pb.tcs.api;

import com.pb.tcs.archive.ArchivePartitionService;
import com.pb.tcs.lookup.TradeJourneyService;
import com.pb.tcs.lookup.TradeLookupService;
import com.pb.tcs.lookup.TradeResendService;
import com.pb.tcs.lookup.TradeSearchQuery;
import com.pb.tcs.lookup.TradeSummary;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * FR-600–603 / FR-605 REST contract surface. Transport-agnostic — wired to HTTP in a later phase.
 */
public final class TradeApi {

    private final TradeLookupService lookupService;
    private final TradeJourneyService journeyService;
    private final TradeResendService resendService;
    private final ArchivePartitionService archiveService;

    public TradeApi(
            TradeLookupService lookupService,
            TradeJourneyService journeyService,
            TradeResendService resendService,
            ArchivePartitionService archiveService) {
        this.lookupService = lookupService;
        this.journeyService = journeyService;
        this.resendService = resendService;
        this.archiveService = archiveService;
    }

    public Optional<TradeSummaryView> getTrade(UUID ingestionId) {
        return lookupService.findByIngestionId(ingestionId).map(TradeSummaryView::from);
    }

    public List<TradeSummaryView> search(
            String allocationId,
            String blockId,
            String swapRef,
            String lotRef,
            String clientAccount,
            String book,
            LocalDate tradeDate) {
        return lookupService
                .search(
                        new TradeSearchQuery(
                                allocationId, blockId, swapRef, lotRef, clientAccount, book, tradeDate))
                .stream()
                .map(TradeSummaryView::from)
                .toList();
    }

    public Optional<TradeJourneyView> journey(UUID ingestionId) {
        return journeyService.journey(ingestionId).map(TradeJourneyView::from);
    }

    public TradeResendView resend(UUID ingestionId, String correlationId, String book, String targetId) {
        return TradeResendView.from(resendService.resend(ingestionId, correlationId, book, targetId));
    }

    public ArchiveRunView archivePartition(LocalDate partitionMonth) {
        ArchivePartitionService.ArchiveResult result = archiveService.archivePartition(partitionMonth);
        return ArchiveRunView.from(result);
    }

    public record TradeSummaryView(
            UUID ingestionId,
            String correlationId,
            String blockId,
            String allocationId,
            int version,
            String book,
            String clientAccount,
            String swapRef,
            String tradeDate,
            String status,
            String tier) {

        static TradeSummaryView from(TradeSummary summary) {
            return new TradeSummaryView(
                    summary.ingestionId(),
                    summary.correlationId(),
                    summary.blockId(),
                    summary.allocationId(),
                    summary.version(),
                    summary.book(),
                    summary.clientAccount(),
                    summary.swapRef(),
                    summary.tradeDate() == null ? null : summary.tradeDate().toString(),
                    summary.status(),
                    summary.tier().name());
        }
    }

    public record TradeJourneyView(
            UUID ingestionId,
            String correlationId,
            String status,
            String blotterJson,
            int explainCount,
            int routingCount,
            int dispatchCount,
            int ackCount,
            int crossRefCount,
            int approvalCount) {

        static TradeJourneyView from(TradeJourneyService.TradeJourney journey) {
            var snap = journey.ingestion();
            return new TradeJourneyView(
                    snap.ingestionId(),
                    snap.correlationId(),
                    snap.status(),
                    journey.blotterJson(),
                    journey.explains().size(),
                    journey.routing().size(),
                    journey.dispatch().size(),
                    journey.businessAcks().size(),
                    journey.crossRefs().size(),
                    journey.approvals().size());
        }
    }

    public record TradeResendView(String outcome, long dispatchId, String envelopeHash, String detail) {

        static TradeResendView from(TradeResendService.ResendResult result) {
            return new TradeResendView(
                    result.outcome(), result.dispatchId(), result.envelopeHash(), result.detail());
        }
    }

    public record ArchiveRunView(
            boolean success, long runId, String partitionMonth, long rowsArchived, String detail) {

        static ArchiveRunView from(ArchivePartitionService.ArchiveResult result) {
            return new ArchiveRunView(
                    result.success(),
                    result.runId(),
                    result.partitionMonth() == null ? null : result.partitionMonth().toString(),
                    result.rowsArchived(),
                    result.detail());
        }
    }
}
