package com.pb.tcs.lookup;

import com.pb.tcs.cutover.CutoverPolicy;
import com.pb.tcs.dispatch.DispatchEnvelopeBuilder;
import com.pb.tcs.dispatch.DispatchRecord;
import com.pb.tcs.dispatch.DispatchRecordStore;
import com.pb.tcs.dispatch.DispatchStatus;
import com.pb.tcs.dispatch.DownstreamPublisher;
import com.pb.tcs.routing.RoutingDecision;
import com.pb.tcs.routing.RoutingDecisionStore;
import com.pb.tcs.rules.BlotterJson;
import com.pb.tcs.rules.BlotterStore;
import com.pb.tcs.rules.SwapBlotter;
import java.time.Clock;
import java.util.UUID;

/** FR-601 idempotent envelope re-dispatch to a single target. */
public final class TradeResendService {

    private final DispatchRecordStore dispatchStore;
    private final BlotterStore blotterStore;
    private final RoutingDecisionStore routingStore;
    private final DownstreamPublisher publisher;
    private final CutoverPolicy cutoverPolicy;
    private final Clock clock;

    public TradeResendService(
            DispatchRecordStore dispatchStore,
            BlotterStore blotterStore,
            RoutingDecisionStore routingStore,
            DownstreamPublisher publisher,
            CutoverPolicy cutoverPolicy,
            Clock clock) {
        this.dispatchStore = dispatchStore;
        this.blotterStore = blotterStore;
        this.routingStore = routingStore;
        this.publisher = publisher;
        this.cutoverPolicy = cutoverPolicy;
        this.clock = clock;
    }

    public ResendResult resend(UUID ingestionId, String correlationId, String book, String targetId) {
        if (cutoverPolicy.shadowMode()) {
            return ResendResult.skipped("shadow_mode");
        }
        if (!cutoverPolicy.shouldPublish(book, targetId)) {
            return ResendResult.skipped("dual_publish_disabled");
        }
        DispatchRecord existing =
                dispatchStore.findByIngestionId(ingestionId).stream()
                        .filter(r -> r.destinationId().equals(targetId))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("no dispatch for " + targetId));

        SwapBlotter blotter =
                blotterStore
                        .findBlotterJson(correlationId)
                        .map(BlotterJson::fromJson)
                        .orElseThrow(() -> new IllegalStateException("missing blotter"));
        RoutingDecision decision =
                routingStore.findByCorrelationId(correlationId).stream()
                        .filter(d -> d.targetId().equals(targetId))
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException("missing routing"));
        var envelope = DispatchEnvelopeBuilder.build(blotter, decision);
        String hash = DispatchEnvelopeBuilder.hash(envelope);

        if (existing.status() == DispatchStatus.SENT && hash.equals(existing.envelopeHash())) {
            return ResendResult.idempotent(existing.dispatchId(), hash);
        }

        publisher.publish(envelope);
        dispatchStore.markSent(existing.dispatchId(), hash, clock.instant());
        return ResendResult.resent(existing.dispatchId(), hash);
    }

    public record ResendResult(String outcome, long dispatchId, String envelopeHash, String detail) {

        static ResendResult idempotent(long dispatchId, String hash) {
            return new ResendResult("IDEMPOTENT", dispatchId, hash, "already sent with same envelope");
        }

        static ResendResult resent(long dispatchId, String hash) {
            return new ResendResult("RESENT", dispatchId, hash, "republished");
        }

        static ResendResult skipped(String reason) {
            return new ResendResult("SKIPPED", 0, null, reason);
        }
    }
}
