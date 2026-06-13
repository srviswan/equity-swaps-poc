package com.pb.tcs.config;

import java.util.Map;

/** FR-605 / D20 cutover policy loaded from {@code cutover-policy.yml}. */
public record CutoverPolicyConfig(
        boolean shadowMode,
        Map<String, Map<String, Boolean>> dualPublishByBook,
        Map<String, Boolean> dualPublishDefault,
        ArchivePolicy archive) {

    public record ArchivePolicy(int hotWindowMonths, int eligibilityDaysPastLifecycle) {}

    public boolean dualPublishEnabled(String book, String targetId) {
        Map<String, Boolean> bookPolicy = dualPublishByBook.get(book);
        if (bookPolicy != null && bookPolicy.containsKey(targetId)) {
            return bookPolicy.get(targetId);
        }
        return dualPublishDefault.getOrDefault(targetId, false);
    }
}
