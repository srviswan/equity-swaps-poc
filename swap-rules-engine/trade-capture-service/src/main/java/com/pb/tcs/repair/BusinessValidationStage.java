package com.pb.tcs.repair;

import com.pb.tcs.rules.BlotterAssembler;
import com.pb.tcs.rules.BlotterJson;
import com.pb.tcs.rules.BlotterStore;
import com.pb.tcs.rules.SwapBlotter;
import com.pb.tcs.validation.BusinessValidator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Pipeline stage 6 (FR-300): business-validates the assembled blotter. Valid blotters persist
 * (with their FR-207 explain trail) and proceed to routing; invalid blotters quarantine with the
 * full editable payload so ops can repair without re-entering the pipeline from ingress. The
 * trade is already ACK'd — this stage never signals GCAM.
 */
public final class BusinessValidationStage {

    public static final String CATEGORY = "BUSINESS_VALIDATION";

    private final BusinessValidator validator;
    private final BlotterStore blotterStore;
    private final RepairStore repairStore;

    public BusinessValidationStage(
            BusinessValidator validator, BlotterStore blotterStore, RepairStore repairStore) {
        this.validator = validator;
        this.blotterStore = blotterStore;
        this.repairStore = repairStore;
    }

    public sealed interface Outcome {
        record Passed(SwapBlotter blotter) implements Outcome {}

        record Quarantined(long quarantineId, List<BusinessValidator.Violation> violations)
                implements Outcome {}
    }

    public Outcome process(BlotterAssembler.Assembly assembly) {
        SwapBlotter blotter = assembly.blotter();
        List<BusinessValidator.Violation> violations = validator.validate(blotter);
        if (violations.isEmpty()) {
            blotterStore.save(blotter, assembly.explains());
            return new Outcome.Passed(blotter);
        }
        long quarantineId =
                repairStore.open(
                        CATEGORY,
                        blotter.correlationId(),
                        detailOf(violations),
                        BlotterJson.toJson(blotter));
        return new Outcome.Quarantined(quarantineId, violations);
    }

    static String detailOf(List<BusinessValidator.Violation> violations) {
        return violations.stream()
                .map(v -> v.code() + " " + v.field() + ": " + v.message())
                .collect(Collectors.joining("; "));
    }
}
