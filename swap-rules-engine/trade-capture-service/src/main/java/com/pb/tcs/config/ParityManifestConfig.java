package com.pb.tcs.config;

import java.math.BigDecimal;
import java.util.Map;

/**
 * FR-604 field manifest: drives legacy parity diff and (later) recon R2/R3 field comparison
 * (FR-703).
 */
public record ParityManifestConfig(Mode defaultMode, Map<String, FieldPolicy> fields) {

    public enum Mode {
        MUST_MATCH,
        TOLERANCE,
        IGNORE
    }

    public record FieldPolicy(Mode mode, BigDecimal absoluteTolerance) {

        public static FieldPolicy of(Mode mode) {
            return new FieldPolicy(mode, null);
        }

        public static FieldPolicy tolerance(BigDecimal absolute) {
            return new FieldPolicy(Mode.TOLERANCE, absolute);
        }
    }

    public FieldPolicy policyFor(String dottedPath) {
        return fields.getOrDefault(dottedPath, FieldPolicy.of(defaultMode));
    }
}
