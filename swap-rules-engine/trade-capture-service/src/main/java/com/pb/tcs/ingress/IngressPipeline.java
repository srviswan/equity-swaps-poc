package com.pb.tcs.ingress;

import com.google.protobuf.InvalidProtocolBufferException;
import com.pb.tcs.config.IngressConfig;
import com.pb.tcs.config.VersionGapConfig;
import com.pb.tcs.ingress.PipelineResult.Disposition;
import com.pb.tcs.ingress.PipelineResult.SolaceAction;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.AllocationType;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import com.pb.tcs.reference.ReferenceDataProxy;
import com.pb.tcs.validation.MandatoryFieldValidator;
import com.pb.tcs.validation.ProtoStructuralValidator;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;

/**
 * F1 ingress pipeline: stages 1–3 (structural → mandatory → idempotency → version-gap → ref-data
 * → enriched persist), implementing the authoritative ACK/NACK matrix (spec §F1.2). Runs
 * single-threaded per partition; per-key serialization is Solace's job (D2), never re-done here.
 *
 * <p>The returned {@link PipelineResult#solace()} is applied verbatim by the consumer — this class
 * is the single owner of ACK/NACK decisions.
 */
public final class IngressPipeline {

    private static final int SUPPORTED_SCHEMA_VERSION = 1;

    private final IngestionStore store;
    private final VersionGapHoldStore holds;
    private final ReferenceDataProxy refData;
    private final VersionGapConfig versionGapConfig;
    private final IngressConfig ingressConfig;
    private final Clock clock;
    private final ProtoStructuralValidator structuralValidator =
            new ProtoStructuralValidator(SUPPORTED_SCHEMA_VERSION);
    private final MandatoryFieldValidator mandatoryValidator = new MandatoryFieldValidator();

    public IngressPipeline(
            IngestionStore store,
            VersionGapHoldStore holds,
            ReferenceDataProxy refData,
            VersionGapConfig versionGapConfig,
            IngressConfig ingressConfig,
            Clock clock) {
        this.store = store;
        this.holds = holds;
        this.refData = refData;
        this.versionGapConfig = versionGapConfig;
        this.ingressConfig = ingressConfig;
        this.clock = clock;
    }

    /**
     * @param raw message bytes as delivered by Solace
     * @param deliveryAttempt 1-based redelivery count from the transport (drives D6/D22 ref-data
     *     retry policy)
     */
    public PipelineResult process(byte[] raw, int deliveryAttempt) {
        ProtoStructuralValidator.Result parse = structuralValidator.parse(raw);
        if (parse instanceof ProtoStructuralValidator.Malformed malformed) {
            store.auditReject("STRUCTURAL", malformed.reason(), deliveryAttempt, null);
            return PipelineResult.nack(Disposition.REJECTED_STRUCTURAL, malformed.reason());
        }
        TcsIngressMessage envelope = ((ProtoStructuralValidator.Parsed) parse).message();

        if (envelope.getPayloadCase() != TcsIngressMessage.PayloadCase.ALLOCATION) {
            // manual_blotter / approval_resume stages are wired in F8; NACK → DLQ after
            // max-redelivery keeps them visible instead of silently dropped.
            return PipelineResult.nack(
                    Disposition.UNSUPPORTED_PAYLOAD,
                    envelope.getPayloadCase() + " not wired until F8");
        }
        AllocationMessage allocation = envelope.getAllocation();

        List<String> violations = mandatoryValidator.validate(allocation);
        if (!violations.isEmpty()) {
            String reason = String.join("; ", violations);
            store.auditReject("MANDATORY", reason, deliveryAttempt, envelope);
            return PipelineResult.nack(Disposition.REJECTED_MANDATORY, reason);
        }

        String blockId = allocation.getBlockId();
        String allocationId = allocation.getAllocationId();
        int version = allocation.getVersion();

        if (store.isEnriched(blockId, allocationId, version)) {
            return PipelineResult.ack(Disposition.DUPLICATE, "idempotency key already enriched");
        }

        int lastProcessed = store.lastEnrichedVersion(blockId, allocationId).orElse(0);
        VersionGapEvaluator.Decision decision =
                VersionGapEvaluator.onArrival(lastProcessed, version);

        if (decision instanceof VersionGapEvaluator.Duplicate) {
            return PipelineResult.ack(
                    Disposition.DUPLICATE,
                    "stale version %d (last processed %d)".formatted(version, lastProcessed));
        }
        if (decision instanceof VersionGapEvaluator.Hold hold) {
            long timeoutMs = versionGapConfig.timeoutMsFor(allocation.getBook());
            holds.hold(
                    new VersionGapHoldStore.HoldRow(
                            blockId,
                            allocationId,
                            version,
                            hold.expectedVersion(),
                            allocation.getBook(),
                            clock.instant().plusMillis(timeoutMs),
                            raw));
            return PipelineResult.ack(
                    Disposition.HELD,
                    "version %d held, expecting %d".formatted(version, hold.expectedVersion()));
        }

        // In order — enrich + persist (stage 2/3).
        EnrichedAllocation enriched;
        try {
            enriched = enrich(allocation);
        } catch (MissingReferenceData missing) {
            if (deliveryAttempt >= ingressConfig.refdataRetry().maxAttempts()) {
                store.quarantine("REFDATA_EXHAUSTED", missing.getMessage(), raw);
                return PipelineResult.ack(Disposition.REFDATA_QUARANTINED, missing.getMessage());
            }
            store.auditReject("REFDATA", missing.getMessage(), deliveryAttempt, envelope);
            return PipelineResult.nack(Disposition.REFDATA_RETRY, missing.getMessage());
        }

        try {
            store.persistEnriched(enriched);
        } catch (IngestionStoreException e) {
            return PipelineResult.nack(Disposition.PERSIST_FAILED, e.getMessage());
        }

        List<Integer> drained = drainHolds(blockId, allocationId, version);
        return new PipelineResult(
                SolaceAction.ACK, Disposition.ENRICHED, "enriched + ACKed", drained);
    }

    /**
     * After version {@code processedVersion} commits, release consecutive held versions in order
     * (spec §F1.3). Drained messages were ACKed at hold time, so failures here quarantine rather
     * than NACK.
     */
    private List<Integer> drainHolds(String blockId, String allocationId, int processedVersion) {
        SortedSet<Integer> held = holds.heldVersions(blockId, allocationId);
        List<Integer> releasable = VersionGapEvaluator.drainable(processedVersion, held);
        List<Integer> drained = new ArrayList<>();
        for (int version : releasable) {
            Optional<VersionGapHoldStore.HoldRow> claimed =
                    holds.claim(blockId, allocationId, version);
            if (claimed.isEmpty()) {
                break; // concurrent sweeper expired it; stop the run
            }
            VersionGapHoldStore.HoldRow row = claimed.get();
            try {
                store.persistEnriched(enrich(parseHeld(row).getAllocation()));
                drained.add(version);
            } catch (MissingReferenceData missing) {
                store.quarantine("REFDATA_EXHAUSTED", missing.getMessage(), row.rawProto());
                break; // later versions stay held until this one is repaired
            } catch (IngestionStoreException e) {
                holds.hold(row); // put back; next arrival or sweeper retries
                break;
            }
        }
        return drained;
    }

    private static TcsIngressMessage parseHeld(VersionGapHoldStore.HoldRow row) {
        try {
            return TcsIngressMessage.parseFrom(row.rawProto());
        } catch (InvalidProtocolBufferException e) {
            // held bytes already passed structural validation on arrival
            throw new IllegalStateException("corrupt hold row " + row.heldVersion(), e);
        }
    }

    private EnrichedAllocation enrich(AllocationMessage allocation) {
        String securityRef =
                refData.lookupSecurity(allocation.getSecurityId())
                        .orElseThrow(() -> missing("security", allocation.getSecurityId()));
        String bookRef =
                refData.lookupBook(allocation.getBook())
                        .orElseThrow(() -> missing("book", allocation.getBook()));
        String clientRef = null;
        String washBookRef = null;
        if (allocation.getType() == AllocationType.SWAP) {
            clientRef =
                    refData.lookupClientAccount(allocation.getClientAccount())
                            .orElseThrow(
                                    () ->
                                            missing(
                                                    "clientAccount",
                                                    allocation.getClientAccount()));
            if (allocation.getB2BLeg()) {
                washBookRef = lookupWashBook(allocation);
            }
        } else {
            // BLOCK: wash book substitutes the client account in the sequence key (D8)
            washBookRef = lookupWashBook(allocation);
        }
        return new EnrichedAllocation(allocation, securityRef, clientRef, bookRef, washBookRef);
    }

    private String lookupWashBook(AllocationMessage allocation) {
        return refData.lookupWashBook(
                        allocation.getClientAccount(),
                        allocation.getExchange(),
                        allocation.getB2BLeg())
                .orElseThrow(
                        () ->
                                missing(
                                        "washBook",
                                        allocation.getClientAccount()
                                                + "/"
                                                + allocation.getExchange()));
    }

    private static MissingReferenceData missing(String entity, String key) {
        return new MissingReferenceData(entity + " not found: " + key);
    }

    private static final class MissingReferenceData extends RuntimeException {
        MissingReferenceData(String message) {
            super(message);
        }
    }
}
