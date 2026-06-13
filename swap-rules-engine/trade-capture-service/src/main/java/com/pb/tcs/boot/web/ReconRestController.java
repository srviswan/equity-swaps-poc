package com.pb.tcs.boot.web;

import com.pb.tcs.api.ReconApi;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recon")
class ReconRestController {

    private final ReconApi reconApi;

    ReconRestController(ReconApi reconApi) {
        this.reconApi = reconApi;
    }

    @PostMapping("/runs")
    ReconApi.ReconRunResponse startRun(@RequestBody ReconApi.ReconRunRequest request) {
        return reconApi.startRun(request);
    }

    @GetMapping("/runs/{runId}")
    ReconApi.ReconRunResponse getRun(@PathVariable long runId) {
        return reconApi.getRun(runId);
    }

    @GetMapping("/runs/{runId}/breaks")
    List<ReconApi.ReconBreakView> breaks(@PathVariable long runId) {
        return reconApi.getBreaks(runId);
    }

    @PostMapping("/breaks/{breakId}/ack")
    ReconApi.ReconBreakView ack(@PathVariable long breakId, @RequestParam(defaultValue = "ops") String actor) {
        return reconApi.acknowledge(breakId, actor);
    }

    @PostMapping("/breaks/{breakId}/heal")
    ReconApi.ReconBreakView heal(@PathVariable long breakId, @RequestBody ReconApi.AutoHealRequest request) {
        return reconApi.heal(breakId, request);
    }

    @PostMapping("/breaks/{breakId}/resolve")
    ReconApi.ReconBreakView resolve(
            @PathVariable long breakId,
            @RequestParam String note,
            @RequestParam(defaultValue = "ops") String actor) {
        return reconApi.resolve(breakId, note, actor);
    }

    @PostMapping("/breaks/{breakId}/write-off")
    ReconApi.ReconBreakView writeOff(
            @PathVariable long breakId,
            @RequestParam String reason,
            @RequestParam String approver) {
        return reconApi.writeOff(breakId, reason, approver);
    }

    @GetMapping("/aging-alerts")
    List<ReconApi.AgingAlertView> agingAlerts() {
        return reconApi.agingAlerts();
    }
}
