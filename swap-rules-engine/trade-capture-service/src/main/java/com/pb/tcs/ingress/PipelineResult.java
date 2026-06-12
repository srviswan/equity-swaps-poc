package com.pb.tcs.ingress;

import java.util.List;

/**
 * Outcome of one ingress message. The consumer applies {@link #solace()} verbatim — the pipeline
 * is the single owner of ACK/NACK decisions (spec §F1.1 AckNackController).
 *
 * @param drainedVersions held versions processed after this message filled a gap (spec §F1.3)
 */
public record PipelineResult(
        SolaceAction solace, Disposition disposition, String detail, List<Integer> drainedVersions) {

    public enum SolaceAction {
        ACK,
        NACK
    }

    public enum Disposition {
        ENRICHED,
        DUPLICATE,
        HELD,
        REJECTED_STRUCTURAL,
        REJECTED_MANDATORY,
        REFDATA_RETRY,
        REFDATA_QUARANTINED,
        PERSIST_FAILED,
        UNSUPPORTED_PAYLOAD
    }

    static PipelineResult ack(Disposition disposition, String detail) {
        return new PipelineResult(SolaceAction.ACK, disposition, detail, List.of());
    }

    static PipelineResult nack(Disposition disposition, String detail) {
        return new PipelineResult(SolaceAction.NACK, disposition, detail, List.of());
    }
}
