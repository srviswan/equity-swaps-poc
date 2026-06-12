package com.pb.tcs.ingress;

import com.google.protobuf.InvalidProtocolBufferException;
import com.pb.tcs.ingress.PipelineResult.Disposition;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.time.Duration;

/**
 * Transport binding (spec §F1.1 AckNackController): applies the pipeline verdict to the message
 * verbatim and emits the F1.5 metrics. An unexpected pipeline exception is contained: the message
 * is NACKed for redelivery — never lost, never poison-ACKed.
 */
public final class IngressConsumer {

    private final MessageProcessor processor;
    private final IngressMetrics metrics;

    public IngressConsumer(MessageProcessor processor, IngressMetrics metrics) {
        this.processor = processor;
        this.metrics = metrics;
    }

    public PipelineResult onMessage(TransportMessage message) {
        long startNanos = System.nanoTime();
        PipelineResult result;
        try {
            result = processor.process(message.payload(), message.deliveryAttempt());
        } catch (RuntimeException e) {
            metrics.error();
            message.nack();
            return PipelineResult.nack(
                    Disposition.PERSIST_FAILED, "unexpected pipeline error: " + e.getMessage());
        }

        switch (result.solace()) {
            case ACK -> message.ack();
            case NACK -> message.nack();
        }
        emit(message, result, Duration.ofNanos(System.nanoTime() - startNanos));
        return result;
    }

    private void emit(TransportMessage message, PipelineResult result, Duration elapsed) {
        Tags tags = Tags.of(message.payload());
        metrics.ingress(tags.type, tags.source, tags.book);
        switch (result.disposition()) {
            case ENRICHED -> metrics.ackLatency(elapsed);
            case DUPLICATE -> {
                metrics.ackLatency(elapsed);
                metrics.duplicate(tags.source);
            }
            case REJECTED_STRUCTURAL -> metrics.validationFail("STRUCTURAL");
            case REJECTED_MANDATORY -> metrics.validationFail("MANDATORY");
            case REFDATA_RETRY ->
                    metrics.refdataMiss(entityOf(result.detail()), message.deliveryAttempt());
            case REFDATA_QUARANTINED -> {
                metrics.refdataMiss(entityOf(result.detail()), message.deliveryAttempt());
                metrics.quarantined("REFDATA_EXHAUSTED");
            }
            case HELD, PERSIST_FAILED, UNSUPPORTED_PAYLOAD -> {
                // HELD is observed via the held gauge; the others via error/DLQ alerting
            }
        }
    }

    /** Detail format is "{entity} not found: {key}" (pipeline-owned). */
    private static String entityOf(String detail) {
        int space = detail.indexOf(' ');
        return space > 0 ? detail.substring(0, space) : "unknown";
    }

    private record Tags(String type, String source, String book) {
        static Tags of(byte[] payload) {
            try {
                TcsIngressMessage envelope = TcsIngressMessage.parseFrom(payload);
                String type =
                        envelope.hasAllocation()
                                ? envelope.getAllocation().getType().name()
                                : envelope.getPayloadCase().name();
                return new Tags(type, envelope.getSource().name(), envelope.getBook());
            } catch (InvalidProtocolBufferException e) {
                return new Tags("UNPARSEABLE", "UNKNOWN", "UNKNOWN");
            }
        }
    }
}
