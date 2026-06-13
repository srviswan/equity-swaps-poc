package com.pb.tcs.crossref;

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
 * Stage-12 delivery executor (FR-403): claim PENDING cross-ref rows, publish out-of-band from DB
 * txns, mark DELIVERED / retry / FAILED. Per-destination pools mirror dispatch isolation (D13).
 */
public final class CrossRefExecutor {

    private static final int MAX_ATTEMPTS = 5;

    private final CrossRefStore store;
    private final CrossRefPublisher publisher;
    private final CrossRefMetrics metrics;
    private final Clock clock;
    private final Map<String, ExecutorService> destinationPools = new HashMap<>();
    private volatile CountDownLatch completionLatch = new CountDownLatch(0);

    public CrossRefExecutor(
            CrossRefStore store, CrossRefPublisher publisher, CrossRefMetrics metrics, Clock clock) {
        this.store = store;
        this.publisher = publisher;
        this.metrics = metrics;
        this.clock = clock;
    }

    public void poll(int batchSize) {
        Instant now = clock.instant();
        List<CrossRefRecord> pending = store.claimPending(batchSize, now);
        if (pending.isEmpty()) {
            return;
        }
        Map<String, List<CrossRefRecord>> byDestination =
                pending.stream().collect(Collectors.groupingBy(CrossRefRecord::toSystem));

        CountDownLatch latch = new CountDownLatch(pending.size());
        completionLatch = latch;
        for (var entry : byDestination.entrySet()) {
            poolFor(entry.getKey())
                    .submit(
                            () -> {
                                for (CrossRefRecord record : entry.getValue()) {
                                    try {
                                        deliverOne(record);
                                    } finally {
                                        latch.countDown();
                                    }
                                }
                            });
        }
    }

    public void awaitCompletion() throws InterruptedException {
        completionLatch.await(30, TimeUnit.SECONDS);
    }

    private void deliverOne(CrossRefRecord record) {
        CrossRefPushMessage message = CrossRefEnvelopeBuilder.build(record);
        try {
            publisher.publish(message);
            store.markDelivered(record.crossRefId(), clock.instant());
            metrics.delivered(record.toSystem(), record.fromSystem());
        } catch (CrossRefPublisher.PublishException e) {
            int nextAttempt = record.attemptCount() + 1;
            if (nextAttempt >= MAX_ATTEMPTS) {
                store.markFailed(record.crossRefId(), e.getMessage());
                metrics.failed(record.toSystem(), record.fromSystem());
            } else {
                Instant nextAt = clock.instant().plusSeconds(CrossRefBackoff.secondsForAttempt(nextAttempt));
                store.scheduleRetry(record.crossRefId(), nextAttempt, nextAt, e.getMessage());
                metrics.retryScheduled(record.toSystem());
            }
        }
    }

    private ExecutorService poolFor(String destination) {
        return destinationPools.computeIfAbsent(destination, d -> Executors.newSingleThreadExecutor());
    }
}
