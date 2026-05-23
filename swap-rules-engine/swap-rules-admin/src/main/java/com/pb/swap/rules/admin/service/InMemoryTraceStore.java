package com.pb.swap.rules.admin.service;

import com.pb.swap.rules.core.trace.DecisionTrace;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryTraceStore {
    private final Map<String, DecisionTrace> traces = new ConcurrentHashMap<>();

    public void store(DecisionTrace trace) {
        traces.put(trace.traceId(), trace);
    }

    public DecisionTrace get(String traceId) {
        return traces.get(traceId);
    }
}
