package com.pb.tcs.harness;

import com.pb.tcs.ingress.IngressConsumer;
import com.pb.tcs.ingress.SequenceKeys;
import com.pb.tcs.ingress.TransportMessage;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Loopback stand-in for the Solace partitioned queue (broker correctness itself is proven in
 * {@code SolaceIngressTest}): partition = {@code SequenceKeys.partition(hash, n)}, one
 * single-threaded worker per partition (per-key FIFO), NACK re-enqueues with attempt+1 until
 * max-redelivery then DLQs — the same redelivery shape the broker produces.
 */
final class PartitionedReplayer implements AutoCloseable {

    record Delivery(byte[] raw, int attempt) {}

    private final LinkedBlockingQueue<Delivery>[] partitions;
    private final List<Thread> workers = new ArrayList<>();
    private final IngressConsumer consumer;
    private final int maxRedelivery;
    private final AtomicBoolean running = new AtomicBoolean(true);
    private final AtomicInteger inFlight = new AtomicInteger();
    private final ConcurrentLinkedQueue<Delivery> dlq = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<Long> ackLatenciesNanos = new ConcurrentLinkedQueue<>();

    @SuppressWarnings("unchecked")
    PartitionedReplayer(int partitionCount, IngressConsumer consumer, int maxRedelivery) {
        this.consumer = consumer;
        this.maxRedelivery = maxRedelivery;
        this.partitions = new LinkedBlockingQueue[partitionCount];
        for (int i = 0; i < partitionCount; i++) {
            partitions[i] = new LinkedBlockingQueue<>();
        }
    }

    void publish(TcsIngressMessage message) {
        long hash =
                SequenceKeys.hash(
                        message.getBook(), message.getAccountId(), message.getSecurityId());
        partitions[SequenceKeys.partition(hash, partitions.length)]
                .add(new Delivery(message.toByteArray(), 1));
    }

    void start() {
        for (int p = 0; p < partitions.length; p++) {
            LinkedBlockingQueue<Delivery> queue = partitions[p];
            Thread worker =
                    new Thread(
                            () -> {
                                while (running.get()) {
                                    Delivery delivery;
                                    try {
                                        // blocking poll: idle partitions must not burn CPU the
                                        // SQL container needs (a spin loop here starves it)
                                        delivery = queue.poll(50, TimeUnit.MILLISECONDS);
                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                        return;
                                    }
                                    if (delivery == null) {
                                        continue;
                                    }
                                    inFlight.incrementAndGet();
                                    try {
                                        deliver(queue, delivery);
                                    } finally {
                                        inFlight.decrementAndGet();
                                    }
                                }
                            },
                            "replayer-partition-" + p);
            worker.setDaemon(true);
            workers.add(worker);
            worker.start();
        }
    }

    private void deliver(LinkedBlockingQueue<Delivery> queue, Delivery delivery) {
        long start = System.nanoTime();
        AtomicBoolean nacked = new AtomicBoolean();
        consumer.onMessage(
                new TransportMessage() {
                    @Override
                    public byte[] payload() {
                        return delivery.raw();
                    }

                    @Override
                    public int deliveryAttempt() {
                        return delivery.attempt();
                    }

                    @Override
                    public void ack() {
                        ackLatenciesNanos.add(System.nanoTime() - start);
                    }

                    @Override
                    public void nack() {
                        nacked.set(true);
                    }
                });
        if (nacked.get()) {
            if (delivery.attempt() >= maxRedelivery) {
                dlq.add(delivery);
            } else {
                queue.add(new Delivery(delivery.raw(), delivery.attempt() + 1));
            }
        }
    }

    /** Waits until every partition queue is empty and no message is being processed. */
    boolean awaitDrained(long timeoutMs) throws InterruptedException {
        long deadline = System.currentTimeMillis() + timeoutMs;
        while (System.currentTimeMillis() < deadline) {
            boolean empty = true;
            for (LinkedBlockingQueue<Delivery> queue : partitions) {
                if (!queue.isEmpty()) {
                    empty = false;
                    break;
                }
            }
            if (empty && inFlight.get() == 0) {
                return true;
            }
            Thread.sleep(20);
        }
        return false;
    }

    /**
     * Crash simulation (NFR-6): stop all workers immediately and hand back what the broker would
     * redeliver — every queued message, attempt bumped as if the unACKed delivery were returned.
     */
    List<Delivery> crash() throws InterruptedException {
        running.set(false);
        for (Thread worker : workers) {
            worker.join(5_000);
        }
        List<Delivery> redeliveries = new ArrayList<>();
        for (LinkedBlockingQueue<Delivery> queue : partitions) {
            List<Delivery> drained = new ArrayList<>();
            queue.drainTo(drained);
            drained.forEach(d -> redeliveries.add(new Delivery(d.raw(), d.attempt() + 1)));
        }
        return redeliveries;
    }

    List<Long> ackLatenciesNanos() {
        return new ArrayList<>(ackLatenciesNanos);
    }

    int dlqSize() {
        return dlq.size();
    }

    @Override
    public void close() {
        running.set(false);
    }
}
