package com.pb.tcs.boot;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class DemoTradeStatusStore {

    private final Map<String, List<StatusEvent>> events = new ConcurrentHashMap<>();

    public void emit(String runKey, String stage, String detail) {
        events.computeIfAbsent(runKey, k -> new ArrayList<>())
                .add(new StatusEvent(Instant.now(), stage, detail));
    }

    public List<StatusEvent> timeline(String runKey) {
        return List.copyOf(events.getOrDefault(runKey, List.of()));
    }

    public boolean isComplete(String runKey) {
        return timeline(runKey).stream().anyMatch(e -> "COMPLETE".equals(e.stage()));
    }

    public record StatusEvent(Instant at, String stage, String detail) {}
}
