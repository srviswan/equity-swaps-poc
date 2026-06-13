package com.pb.tcs.boot.web;

import com.pb.tcs.api.TradeApi;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/trades")
class TradeRestController {

    private final TradeApi tradeApi;

    TradeRestController(TradeApi tradeApi) {
        this.tradeApi = tradeApi;
    }

    @GetMapping("/{ingestionId}")
    ResponseEntity<TradeApi.TradeSummaryView> getTrade(@PathVariable UUID ingestionId) {
        return tradeApi.getTrade(ingestionId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    List<TradeApi.TradeSummaryView> search(
            @RequestParam(required = false) String allocationId,
            @RequestParam(required = false) String blockId,
            @RequestParam(required = false) String swapRef,
            @RequestParam(required = false) String lotRef,
            @RequestParam(required = false) String clientAccount,
            @RequestParam(required = false) String book,
            @RequestParam(required = false) LocalDate tradeDate) {
        return tradeApi.search(
                allocationId, blockId, swapRef, lotRef, clientAccount, book, tradeDate);
    }

    @GetMapping("/{ingestionId}/journey")
    ResponseEntity<TradeApi.TradeJourneyView> journey(@PathVariable UUID ingestionId) {
        return tradeApi.journey(ingestionId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{ingestionId}/resend")
    TradeApi.TradeResendView resend(
            @PathVariable UUID ingestionId,
            @RequestParam String correlationId,
            @RequestParam String book,
            @RequestParam String target) {
        return tradeApi.resend(ingestionId, correlationId, book, target);
    }

    @PostMapping("/archive")
    TradeApi.ArchiveRunView archive(@RequestParam LocalDate partitionMonth) {
        return tradeApi.archivePartition(partitionMonth);
    }
}
