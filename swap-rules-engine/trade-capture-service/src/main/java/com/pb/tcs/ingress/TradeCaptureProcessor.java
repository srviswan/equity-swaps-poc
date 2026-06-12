package com.pb.tcs.ingress;

import com.pb.tcs.pipeline.TradeProcessingPipeline;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import com.pb.tcs.validation.ProtoStructuralValidator;

/**
 * Routes the three ingress payload kinds (FR-101 / D17): allocation → F1 enrich then stages
 * 4–5.5–6; manual_blotter → gate; approval_resume → stage 6 resume.
 */
public final class TradeCaptureProcessor implements MessageProcessor {

    private final IngressPipeline allocationPipeline;
    private final TradeProcessingPipeline tradePipeline;
    private final LifecycleIngestionStore lifecycleStore;

    public TradeCaptureProcessor(
            IngressPipeline allocationPipeline,
            TradeProcessingPipeline tradePipeline,
            LifecycleIngestionStore lifecycleStore) {
        this.allocationPipeline = allocationPipeline;
        this.tradePipeline = tradePipeline;
        this.lifecycleStore = lifecycleStore;
    }

    @Override
    public PipelineResult process(byte[] raw, int deliveryAttempt) {
        ProtoStructuralValidator.Result parse = new ProtoStructuralValidator(1).parse(raw);
        if (parse instanceof ProtoStructuralValidator.Malformed malformed) {
            lifecycleStore
                    .delegate()
                    .auditReject("STRUCTURAL", malformed.reason(), deliveryAttempt, raw, null);
            return PipelineResult.nack(PipelineResult.Disposition.REJECTED_STRUCTURAL, malformed.reason());
        }
        TcsIngressMessage envelope = ((ProtoStructuralValidator.Parsed) parse).message();
        return switch (envelope.getPayloadCase()) {
            case ALLOCATION -> {
                PipelineResult ingress = allocationPipeline.process(raw, deliveryAttempt);
                if (ingress.disposition() == PipelineResult.Disposition.ENRICHED
                        && lifecycleStore.lastEnriched() != null
                        && lifecycleStore.lastId() != null) {
                    yield tradePipeline.continueAfterEnrich(
                            lifecycleStore.lastEnriched(), lifecycleStore.lastId());
                }
                yield ingress;
            }
            case MANUAL_BLOTTER -> tradePipeline.processManualBlotter(envelope, raw);
            case APPROVAL_RESUME -> tradePipeline.processApprovalResume(envelope);
            default -> PipelineResult.nack(
                    PipelineResult.Disposition.UNSUPPORTED_PAYLOAD, "payload kind not set");
        };
    }

    /** Tracks the last enriched persist for post-F1 continuation. */
    public static final class LifecycleIngestionStore implements IngestionStore {
        private final IngestionLifecycleStore lifecycle;
        private final IngestionStore delegate;
        private EnrichedAllocation lastEnriched;
        private java.util.UUID lastId;

        public LifecycleIngestionStore(IngestionLifecycleStore lifecycle, IngestionStore delegate) {
            this.lifecycle = lifecycle;
            this.delegate = delegate;
        }

        public IngestionStore delegate() {
            return delegate;
        }

        public EnrichedAllocation lastEnriched() {
            return lastEnriched;
        }

        public java.util.UUID lastId() {
            return lastId;
        }

        @Override
        public boolean isEnriched(String blockId, String allocationId, int version) {
            return delegate.isEnriched(blockId, allocationId, version);
        }

        @Override
        public java.util.OptionalInt lastEnrichedVersion(String blockId, String allocationId) {
            return delegate.lastEnrichedVersion(blockId, allocationId);
        }

        @Override
        public void persistEnriched(EnrichedAllocation allocation) {
            lastEnriched = allocation;
            lastId = lifecycle.persistEnrichedAndReturnId(allocation);
            if (delegate != lifecycle) {
                delegate.persistEnriched(allocation);
            }
        }

        @Override
        public void auditReject(
                String stage, String reason, int attempt, byte[] rawProto, TcsIngressMessage parsed) {
            delegate.auditReject(stage, reason, attempt, rawProto, parsed);
        }

        @Override
        public void quarantine(String category, String detail, byte[] rawProto) {
            delegate.quarantine(category, detail, rawProto);
        }
    }
}
