package com.pb.tcs.cutover;

import com.pb.tcs.config.CutoverPolicyConfig;
import java.util.Map;

/** Runtime cutover decisions for dispatch (FR-605 / D20). */
public final class CutoverPolicy {

    private final CutoverPolicyConfig config;

    public CutoverPolicy(CutoverPolicyConfig config) {
        this.config = config;
    }

    public static CutoverPolicy liveAll() {
        return new CutoverPolicy(
                new CutoverPolicyConfig(
                        false,
                        Map.of(),
                        Map.of("SYSTEM_A", true, "SYSTEM_B", true),
                        new CutoverPolicyConfig.ArchivePolicy(3, 90)));
    }

    public boolean shadowMode() {
        return config.shadowMode();
    }

    /** When shadow mode is on, dispatch records are created but publish is skipped. */
    public boolean shouldPublish(String book, String targetId) {
        if (config.shadowMode()) {
            return false;
        }
        return config.dualPublishEnabled(book, targetId);
    }

    /** Stage 9: which routed targets get a {@code dispatch_record}. */
    public boolean shouldPlanDispatch(String book, String targetId) {
        if (config.shadowMode()) {
            return true;
        }
        return config.dualPublishEnabled(book, targetId);
    }

    public CutoverPolicyConfig config() {
        return config;
    }
}
