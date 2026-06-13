package com.pb.tcs.boot;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Component;

@Component
public class DemoTradeStatusStore {

    static final Set<String> TERMINAL_STAGES = Set.of("COMPLETE", "FAILED", "QUARANTINED");

    private final Map<String, List<StatusEvent>> events = new ConcurrentHashMap<>();

    public void reset(String runKey) {
        events.remove(runKey);
    }

    public void emit(String runKey, String stage, String detail) {
        events.computeIfAbsent(runKey, k -> new CopyOnWriteArrayList<>())
                .add(new StatusEvent(Instant.now(), stage, detail));
    }

    public void emitTerminal(String runKey, String stage, String detail) {
        emit(runKey, stage, detail);
    }

    public List<StatusEvent> timeline(String runKey) {
        return List.copyOf(events.getOrDefault(runKey, List.of()));
    }

    public boolean isComplete(String runKey) {
        return timeline(runKey).stream().anyMatch(e -> TERMINAL_STAGES.contains(e.stage()));
    }

    public record StatusEvent(Instant at, String stage, String detail) {}
}
