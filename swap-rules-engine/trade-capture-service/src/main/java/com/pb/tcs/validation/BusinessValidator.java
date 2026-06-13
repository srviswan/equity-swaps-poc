package com.pb.tcs.validation;

import com.fasterxml.jackson.databind.JsonNode;
import com.pb.tcs.config.BusinessValidationConfig;
import com.pb.tcs.rules.BlotterJson;
import com.pb.tcs.rules.SwapBlotter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Stage-6 business validation (FR-300): the integrity gate between defaulting and routing. By
 * this point the trade is ACK'd to GCAM, so failures are internal — they quarantine into the
 * repair workflow (FR-209), never NACK.
 *
 * <p>Mandatory-field checks are config-driven ({@code business-validation.yml}) and evaluated
 * over the blotter's JSON shape, so the ops-owned list extends to any blotter path without code
 * change. Structural checks are typed invariants of the contract economics.
 */
public final class BusinessValidator {

    /** One validation failure; {@code field} is the dotted blotter path. */
    public record Violation(String field, String code, String message) {}

    private final BusinessValidationConfig config;

    public BusinessValidator(BusinessValidationConfig config) {
        this.config = config;
    }

    /** Empty list = blotter is contract-complete and may proceed to routing. */
    public List<Violation> validate(SwapBlotter blotter) {
        List<Violation> violations = new ArrayList<>();
        JsonNode tree = BlotterJson.toTree(blotter);
        for (String path : config.mandatoryFields()) {
            JsonNode node = tree.at(pointer(path));
            if (node.isMissingNode() || node.isNull() || (node.isTextual() && node.asText().isBlank())) {
                violations.add(
                        new Violation(
                                path,
                                "MANDATORY_FIELD_MISSING",
                                "Mandatory contract field '%s' is missing".formatted(path)));
            }
        }
        structural(blotter, violations);
        return violations;
    }

    private void structural(SwapBlotter blotter, List<Violation> violations) {
        var swap = blotter.swap();
        if (config.structural().spreadBpsNonNegative()
                && swap.interestLeg() != null
                && swap.interestLeg().spreadBps() != null
                && swap.interestLeg().spreadBps().signum() < 0) {
            violations.add(
                    new Violation(
                            "swap.interestLeg.spreadBps",
                            "SPREAD_NEGATIVE",
                            "interestLeg.spreadBps must be >= 0, was "
                                    + swap.interestLeg().spreadBps()));
        }
        if (config.structural().divPassthroughPercentRange()
                && swap.divPassthrough() != null
                && swap.divPassthrough().percent() != null) {
            BigDecimal pct = swap.divPassthrough().percent();
            if (pct.signum() < 0 || pct.compareTo(BigDecimal.valueOf(100)) > 0) {
                violations.add(
                        new Violation(
                                "swap.divPassthrough.percent",
                                "DIV_PERCENT_OUT_OF_RANGE",
                                "divPassthrough.percent must be in [0,100], was " + pct));
            }
        }
        if (blotter.tradeDate() == null) {
            violations.add(
                    new Violation(
                            "tradeDate", "TRADE_DATE_MISSING", "Blotter is missing its trade date"));
        }
    }

    private static String pointer(String dottedPath) {
        return "/" + dottedPath.replace('.', '/');
    }
}
