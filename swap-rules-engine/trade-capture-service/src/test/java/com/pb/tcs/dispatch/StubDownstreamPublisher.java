package com.pb.tcs.dispatch;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/** Test double: per-destination failures and optional publish barrier (target-down isolation). */
final class StubDownstreamPublisher implements DownstreamPublisher {

    private final Set<String> down = ConcurrentHashMap.newKeySet();
    private volatile CountDownLatch blockUntil;
    private final AtomicBoolean aPublished = new AtomicBoolean(false);

    void markDown(String destinationId) {
        down.add(destinationId);
    }

    void blockUntil(CountDownLatch latch) {
        this.blockUntil = latch;
    }

    boolean aPublished() {
        return aPublished.get();
    }

    @Override
    public void publish(DispatchEnvelope envelope) {
        if ("SYSTEM_A".equals(envelope.destinationId())) {
            aPublished.set(true);
        }
        CountDownLatch latch = blockUntil;
        if (latch != null && "SYSTEM_B".equals(envelope.destinationId())) {
            try {
                latch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new PublishException("interrupted waiting on B barrier");
            }
        }
        if (down.contains(envelope.destinationId())) {
            throw new PublishException(envelope.destinationId() + " unavailable");
        }
    }
}
