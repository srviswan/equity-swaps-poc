package com.pb.tcs.boot.web;

import com.pb.tcs.boot.DemoTradeOrchestrator;
import com.pb.tcs.boot.DemoTradeRunSupport;
import com.pb.tcs.boot.DemoTradeStatusStore;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo/trades")
class DemoTradeRestController {

    private final DemoTradeOrchestrator orchestrator;
    private final DemoTradeStatusStore statusStore;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    DemoTradeRestController(DemoTradeOrchestrator orchestrator, DemoTradeStatusStore statusStore) {
        this.orchestrator = orchestrator;
        this.statusStore = statusStore;
    }

    @PostMapping("/run")
    RunStartResponse startRun(
            @RequestParam(required = false) String blockId,
            @RequestParam(defaultValue = "2026-06-10") String tradeDate) {
        DemoTradeRunSupport.parseTradeDate(tradeDate);
        String runKey = blockId != null ? blockId : "BLK-" + System.currentTimeMillis();
        executor.submit(
                () -> {
                    try {
                        orchestrator.run(runKey, tradeDate);
                    } catch (RuntimeException e) {
                        statusStore.emitTerminal(
                                runKey, "FAILED", e.getClass().getSimpleName() + ": " + e.getMessage());
                    }
                });
        return new RunStartResponse(runKey, tradeDate, "/api/v1/demo/trades/" + runKey + "/timeline");
    }

    @PostMapping("/run-sync")
    DemoTradeOrchestrator.RunResult runSync(
            @RequestParam(required = false) String blockId,
            @RequestParam(defaultValue = "2026-06-10") String tradeDate) {
        String runKey = blockId != null ? blockId : "BLK-" + System.currentTimeMillis();
        return orchestrator.run(runKey, tradeDate);
    }

    @GetMapping("/{blockId}/timeline")
    TimelineResponse timeline(@PathVariable String blockId) {
        List<DemoTradeStatusStore.StatusEvent> events = statusStore.timeline(blockId);
        return new TimelineResponse(blockId, statusStore.isComplete(blockId), events);
    }

    record RunStartResponse(String blockId, String tradeDate, String timelineUrl) {}

    record TimelineResponse(
            String blockId, boolean complete, List<DemoTradeStatusStore.StatusEvent> events) {}
}
