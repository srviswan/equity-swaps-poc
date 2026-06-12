package com.pb.tcs.dispatch;

import com.pb.tcs.config.RoutingRulesConfig;
import com.pb.tcs.cutover.CutoverPolicy;
import com.pb.tcs.routing.RoutingDecision;
import com.pb.tcs.routing.RoutingDecisionStore;
import com.pb.tcs.rules.BlotterStore;
import com.pb.tcs.rules.SwapBlotter;
import io.micrometer.core.instrument.MeterRegistry;
import java.time.Clock;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Stage-10 dispatch executor (FR-400/401): claim-batch short txn → concurrent per-destination
 * publish (no network I/O inside DB txns) → small txns for results → recompute ingestion status.
 */
public final class DispatchExecutor {

    private final DispatchRecordStore dispatchStore;
    private final BlotterStore blotterStore;
    private final RoutingDecisionStore routingStore;
    private final DownstreamPublisher publisher;
    private final RoutingRulesConfig routingConfig;
    private final IngestionDispatchStatusUpdater ingestionStatus;
    private final DispatchMetrics metrics;
    private final CutoverPolicy cutoverPolicy;
    private final Clock clock;
    private final Map<String, ExecutorService> destinationPools = new HashMap<>();
    private volatile CountDownLatch completionLatch = new CountDownLatch(0);

    public DispatchExecutor(
            DispatchRecordStore dispatchStore,
            BlotterStore blotterStore,
            RoutingDecisionStore routingStore,
            DownstreamPublisher publisher,
            RoutingRulesConfig routingConfig,
            IngestionDispatchStatusUpdater ingestionStatus,
            DispatchMetrics metrics,
            Clock clock) {
        this(
                dispatchStore,
                blotterStore,
                routingStore,
                publisher,
                routingConfig,
                ingestionStatus,
                metrics,
                clock,
                CutoverPolicy.liveAll());
    }

    public DispatchExecutor(
            DispatchRecordStore dispatchStore,
            BlotterStore blotterStore,
            RoutingDecisionStore routingStore,
            DownstreamPublisher publisher,
            RoutingRulesConfig routingConfig,
            IngestionDispatchStatusUpdater ingestionStatus,
            DispatchMetrics metrics,
            Clock clock,
            CutoverPolicy cutoverPolicy) {
        this.dispatchStore = dispatchStore;
        this.blotterStore = blotterStore;
        this.routingStore = routingStore;
        this.publisher = publisher;
        this.routingConfig = routingConfig;
        this.ingestionStatus = ingestionStatus;
        this.metrics = metrics;
        this.clock = clock;
        this.cutoverPolicy = cutoverPolicy;
    }

    /** One poll cycle: claim, fan out concurrently by destination, aggregate status. */
    public void poll(int batchSize) {
        Instant now = clock.instant();
        List<DispatchRecord> claimed = dispatchStore.claimBatch(batchSize, now);
        if (claimed.isEmpty()) {
            return;
        }
        claimed.stream()
                .map(DispatchRecord::correlationId)
                .distinct()
                .forEach(c -> ingestionStatus.update(c, IngestionDispatchStatus.DISPATCHING));

        Map<String, List<DispatchRecord>> byDestination =
                claimed.stream().collect(Collectors.groupingBy(DispatchRecord::destinationId));

        CountDownLatch latch = new CountDownLatch(claimed.size());
        completionLatch = latch;
        for (var entry : byDestination.entrySet()) {
            poolFor(entry.getKey())
                    .submit(
                            () -> {
                                for (DispatchRecord record : entry.getValue()) {
                                    try {
                                        dispatchOne(record);
                                    } finally {
                                        latch.countDown();
                                    }
                                }
                            });
        }
    }

    /** Test/production drain hook: wait for the in-flight poll cycle to finish. */
    public void awaitCompletion() throws InterruptedException {
        completionLatch.await(30, TimeUnit.SECONDS);
    }

    private void dispatchOne(DispatchRecord record) {
        try {
            SwapBlotter blotter =
                    blotterStore
                            .findBlotterJson(record.correlationId())
                            .map(com.pb.tcs.rules.BlotterJson::fromJson)
                            .orElseThrow(
                                    () ->
                                            new IllegalStateException(
                                                    "missing blotter for "
                                                            + record.correlationId()));
            RoutingDecision decision =
                    routingStore.findByCorrelationId(record.correlationId()).stream()
                            .filter(d -> d.targetId().equals(record.destinationId()))
                            .findFirst()
                            .orElseThrow(
                                    () ->
                                            new IllegalStateException(
                                                    "missing routing for "
                                                            + record.destinationId()));
            DispatchEnvelope envelope = DispatchEnvelopeBuilder.build(blotter, decision);
            if (!cutoverPolicy.shouldPublish(blotter.book(), record.destinationId())) {
                dispatchStore.markShadowSkipped(record.dispatchId(), clock.instant());
                metrics.shadowSkipped(record.destinationId());
                return;
            }
            publisher.publish(envelope);
            String hash = DispatchEnvelopeBuilder.hash(envelope);
            Instant sentAt = clock.instant();
            dispatchStore.markSent(record.dispatchId(), hash, sentAt);
            metrics.success(record.destinationId());
        } catch (DownstreamPublisher.PublishException e) {
            handleFailure(record, e.getMessage());
        } catch (RuntimeException e) {
            handleFailure(record, e.getMessage());
        } finally {
            recomputeStatus(record.correlationId());
        }
    }

    private void handleFailure(DispatchRecord record, String error) {
        int nextAttempt = record.attemptCount() + 1;
        int maxAttempts = maxAttempts(record.destinationId());
        if (nextAttempt >= maxAttempts) {
            dispatchStore.markFailed(record.dispatchId(), error);
            metrics.dlq(record.destinationId());
        } else {
            Instant nextAt = clock.instant().plus(DispatchBackoff.nextDelay(nextAttempt));
            dispatchStore.scheduleRetry(record.dispatchId(), nextAttempt, nextAt, error);
            metrics.failure(record.destinationId());
        }
    }

    private void recomputeStatus(String correlationId) {
        List<DispatchRecord> records = dispatchStore.findByCorrelationId(correlationId);
        long sent = records.stream().filter(r -> r.status() == DispatchStatus.SENT).count();
        long shadow =
                records.stream().filter(r -> r.status() == DispatchStatus.SHADOW_SKIPPED).count();
        long failed = records.stream().filter(r -> r.status() == DispatchStatus.FAILED).count();
        long pending =
                records.stream()
                        .filter(
                                r ->
                                        r.status() == DispatchStatus.PENDING
                                                || r.status() == DispatchStatus.CLAIMED)
                        .count();
        long completed = sent + shadow;

        IngestionDispatchStatus status;
        if (completed == records.size()) {
            status = sent == records.size() ? IngestionDispatchStatus.SENT : IngestionDispatchStatus.SHADOW_COMPLETE;
        } else if (failed == records.size()) {
            status = IngestionDispatchStatus.FAILED;
        } else if (sent > 0 && (failed > 0 || pending > 0)) {
            status = IngestionDispatchStatus.PARTIALLY_SENT;
        } else if (pending > 0) {
            status = IngestionDispatchStatus.DISPATCHING;
        } else {
            status = IngestionDispatchStatus.FAILED;
        }
        ingestionStatus.update(correlationId, status);
    }

    private int maxAttempts(String destinationId) {
        RoutingRulesConfig.Target target = routingConfig.targets().get(destinationId);
        return target != null ? target.maxAttempts() : 3;
    }

    private ExecutorService poolFor(String destinationId) {
        return destinationPools.computeIfAbsent(
                destinationId, d -> Executors.newSingleThreadExecutor(r -> new Thread(r, "dispatch-" + d)));
    }
}
