package com.pb.swap.rules.core.trace;

/** Async trace persistence (implemented in runtime/admin). */
public interface TraceSink {
    void publishAsync(DecisionTrace trace);

    /** No-op for tests and in-process use without Kafka. */
    TraceSink NOOP = trace -> {};
}
