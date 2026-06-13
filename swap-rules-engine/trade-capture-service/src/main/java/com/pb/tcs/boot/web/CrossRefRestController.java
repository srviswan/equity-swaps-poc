package com.pb.tcs.boot.web;

import com.pb.tcs.api.CrossRefApi;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cross-refs")
class CrossRefRestController {

    private final CrossRefApi crossRefApi;

    CrossRefRestController(CrossRefApi crossRefApi) {
        this.crossRefApi = crossRefApi;
    }

    @GetMapping
    CrossRefApi.CrossRefPollResponse poll(
            @RequestParam(required = false) String allocationId,
            @RequestParam(required = false) String swapRef,
            @RequestParam(required = false) String direction) {
        return crossRefApi.poll(new CrossRefApi.CrossRefPollRequest(allocationId, swapRef, direction));
    }

    @PostMapping("/{ingestionId}/sync")
    CrossRefApi.CrossRefSyncResponse sync(
            @PathVariable UUID ingestionId, @RequestParam String correlationId) {
        return crossRefApi.sync(ingestionId, correlationId);
    }

    @PostMapping("/{crossRefId}/retry")
    void retry(@PathVariable long crossRefId) {
        crossRefApi.retryDelivery(crossRefId);
    }
}
