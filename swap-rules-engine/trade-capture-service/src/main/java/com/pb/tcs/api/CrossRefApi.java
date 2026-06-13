package com.pb.tcs.api;

import com.pb.tcs.crossref.CrossRefOpsService;
import com.pb.tcs.crossref.CrossRefQueryService;
import com.pb.tcs.crossref.CrossRefRecord;
import com.pb.tcs.crossref.CrossRefSyncService;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * FR-404 / FR-601 REST contract surface ({@code GET /api/v1/cross-refs},
 * {@code POST /api/v1/cross-refs/{ingestionId}/sync}). Transport-agnostic — wired to HTTP in a
 * later phase.
 */
public final class CrossRefApi {

    private final CrossRefQueryService queryService;
    private final CrossRefSyncService syncService;
    private final CrossRefOpsService opsService;

    public CrossRefApi(
            CrossRefQueryService queryService,
            CrossRefSyncService syncService,
            CrossRefOpsService opsService) {
        this.queryService = queryService;
        this.syncService = syncService;
        this.opsService = opsService;
    }

    public CrossRefPollResponse poll(CrossRefPollRequest request) {
        List<CrossRefRecord> rows =
                queryService.poll(request.allocationId(), request.swapRef(), request.direction());
        return new CrossRefPollResponse(rows.stream().map(CrossRefView::from).toList());
    }

    public CrossRefSyncResponse sync(UUID ingestionId, String correlationId) {
        CrossRefSyncService.SyncResult result = syncService.sync(ingestionId, correlationId);
        return new CrossRefSyncResponse(
                result.directionsReset(),
                result.crossRefs().stream().map(CrossRefView::from).toList());
    }

    public void retryDelivery(long crossRefId) {
        opsService.retry(crossRefId);
    }

    public void manualReconcile(long crossRefId) {
        opsService.manualReconcile(crossRefId, Instant.now());
    }

    public record CrossRefPollRequest(String allocationId, String swapRef, String direction) {}

    public record CrossRefPollResponse(List<CrossRefView> crossRefs) {}

    public record CrossRefSyncResponse(int directionsReset, List<CrossRefView> crossRefs) {}

    public record CrossRefView(
            long crossRefId,
            UUID ingestionId,
            String correlationId,
            String fromSystem,
            String toSystem,
            String swapRef,
            String lotRefsJson,
            String eventType,
            String status,
            Instant deliveredAt) {

        static CrossRefView from(CrossRefRecord record) {
            return new CrossRefView(
                    record.crossRefId(),
                    record.ingestionId(),
                    record.correlationId(),
                    record.fromSystem(),
                    record.toSystem(),
                    record.swapRef(),
                    record.lotRefsJson(),
                    record.eventType() == null ? null : record.eventType().name(),
                    record.status().name(),
                    record.deliveredAt());
        }
    }
}
