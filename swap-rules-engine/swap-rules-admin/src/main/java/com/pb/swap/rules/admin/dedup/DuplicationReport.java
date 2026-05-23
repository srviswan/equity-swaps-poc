package com.pb.swap.rules.admin.dedup;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Structured outcome of a duplication inspection. {@link Severity#OK} means safe to save, {@code
 * WARNING} is acceptable but worth surfacing, {@code ERROR} blocks the save.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record DuplicationReport(
        Severity level, String canonicalHash, List<Finding> findings) {

    public boolean hasErrors() {
        return level == Severity.ERROR;
    }

    public boolean hasWarnings() {
        return level == Severity.WARNING || level == Severity.ERROR;
    }

    public enum Severity {
        OK,
        WARNING,
        ERROR
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Finding(
            String code,
            Severity severity,
            String message,
            String hint,
            List<Integer> inlineCriteriaIndices,
            List<Integer> inlineActionIndices,
            String conflictId) {

        public static Finding error(String code, String message, String hint) {
            return new Finding(code, Severity.ERROR, message, hint, null, null, null);
        }

        public static Finding warning(String code, String message, String hint) {
            return new Finding(code, Severity.WARNING, message, hint, null, null, null);
        }
    }
}
