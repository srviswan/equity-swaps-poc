package com.pb.tcs.repair;

import com.pb.tcs.rules.BlotterJson;
import com.pb.tcs.rules.BlotterStore;
import com.pb.tcs.rules.RuleExplain;
import com.pb.tcs.rules.SwapBlotter;
import com.pb.tcs.validation.BusinessValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * FR-209 repair workflow over BUSINESS_VALIDATION quarantines: ops edit blotter fields, re-run
 * <b>business validation only</b> (defaulting is never re-applied — the edited values are the
 * override), and continue the trade into the normal persist-then-route path. Every continued
 * field edit is appended to the FR-207 explain trail as an {@code OPS-OVERRIDE} entry so the
 * auditor sees what was overridden and by whom.
 */
public final class RepairService {

    public static final String OVERRIDE_RULE_ID = "OPS-OVERRIDE";

    private final RepairStore repairStore;
    private final BusinessValidator validator;
    private final BlotterStore blotterStore;

    public RepairService(
            RepairStore repairStore, BusinessValidator validator, BlotterStore blotterStore) {
        this.repairStore = repairStore;
        this.validator = validator;
        this.blotterStore = blotterStore;
    }

    public sealed interface RevalidationResult {
        record Clean(SwapBlotter blotter) implements RevalidationResult {}

        record StillInvalid(List<BusinessValidator.Violation> violations)
                implements RevalidationResult {}
    }

    public List<RepairStore.RepairItem> openRepairs() {
        return repairStore.openItems(BusinessValidationStage.CATEGORY);
    }

    /**
     * Applies dotted-path field edits to the quarantined blotter and re-runs business validation
     * only. The edited payload is persisted either way so ops work is never lost.
     */
    public RevalidationResult editAndRevalidate(
            long quarantineId, Map<String, Object> edits, String editedBy) {
        RepairStore.RepairItem item = openItem(quarantineId);
        String patched = BlotterJson.applyEdits(item.payloadJson(), edits);
        repairStore.saveEdit(quarantineId, patched, editedBy);
        SwapBlotter blotter = BlotterJson.fromJson(patched);
        List<BusinessValidator.Violation> violations = validator.validate(blotter);
        return violations.isEmpty()
                ? new RevalidationResult.Clean(blotter)
                : new RevalidationResult.StillInvalid(violations);
    }

    /**
     * Continues a repaired trade: final revalidation, persist blotter + override explains in the
     * standard blotter transaction, mark the quarantine REPROCESSED.
     *
     * @throws IllegalStateException if the payload still fails validation
     */
    public SwapBlotter continueTrade(long quarantineId, Map<String, Object> edits, String user) {
        RevalidationResult result = editAndRevalidate(quarantineId, edits, user);
        if (result instanceof RevalidationResult.StillInvalid invalid) {
            throw new IllegalStateException(
                    "Repair %d still invalid: %s"
                            .formatted(
                                    quarantineId,
                                    BusinessValidationStage.detailOf(invalid.violations())));
        }
        SwapBlotter blotter = ((RevalidationResult.Clean) result).blotter();
        blotterStore.save(blotter, overrideExplains(edits, user));
        repairStore.resolve(quarantineId, RepairStore.STATUS_REPROCESSED, user);
        return blotter;
    }

    /** Terminal discard with resolver audit; the trade never dispatches. */
    public void discard(long quarantineId, String user) {
        openItem(quarantineId);
        repairStore.resolve(quarantineId, RepairStore.STATUS_DISCARDED, user);
    }

    private RepairStore.RepairItem openItem(long quarantineId) {
        RepairStore.RepairItem item =
                repairStore
                        .find(quarantineId)
                        .orElseThrow(
                                () ->
                                        new IllegalArgumentException(
                                                "Unknown repair item: " + quarantineId));
        if (!RepairStore.STATUS_OPEN.equals(item.status())) {
            throw new IllegalStateException(
                    "Repair %d is %s, not OPEN".formatted(quarantineId, item.status()));
        }
        if (!BusinessValidationStage.CATEGORY.equals(item.category())) {
            throw new IllegalStateException(
                    "Repair %d is category %s — blotter repair applies to %s only"
                            .formatted(quarantineId, item.category(), BusinessValidationStage.CATEGORY));
        }
        return item;
    }

    private static List<RuleExplain> overrideExplains(Map<String, Object> edits, String user) {
        List<RuleExplain> explains = new ArrayList<>();
        int seq = 1;
        for (var entry : edits.entrySet()) {
            explains.add(
                    new RuleExplain(
                            seq++,
                            OVERRIDE_RULE_ID,
                            0,
                            "REPAIR",
                            "BLOTTER",
                            "Ops override: %s set to %s by %s in repair (FR-209); defaulting not re-run."
                                    .formatted(entry.getKey(), entry.getValue(), user)));
        }
        return explains;
    }
}
