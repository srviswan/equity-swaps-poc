package com.pb.tcs.recon;

import com.pb.tcs.api.CrossRefApi;
import com.pb.tcs.lookup.TradeResendService;
import java.util.UUID;

/** FR-705 auto-heal dispatcher — idempotent TCS-side actions only. */
public class AutoHealDispatcher {

    private final CrossRefApi crossRefApi;
    private final TradeResendService resendService;

    public AutoHealDispatcher(CrossRefApi crossRefApi, TradeResendService resendService) {
        this.crossRefApi = crossRefApi;
        this.resendService = resendService;
    }

    public HealResult heal(ReconBreak breakRow, UUID ingestionId, String correlationId, String book) {
        if (!breakRow.autoHealEligible()) {
            return HealResult.rejected("not_auto_heal_eligible");
        }
        return switch (breakRow.breakType()) {
            case REF_MISMATCH, MISSING_IN_A, MISSING_IN_B -> {
                crossRefApi.sync(ingestionId, correlationId);
                yield HealResult.started("cross_ref_sync");
            }
            case MISSING_IN_TCS -> {
                if (book != null) {
                    resendService.resend(ingestionId, correlationId, book, "SYSTEM_A");
                }
                yield HealResult.started("envelope_resend");
            }
            default -> HealResult.rejected("human_required");
        };
    }

    public record HealResult(String outcome, String action) {
        static HealResult started(String action) {
            return new HealResult("HEALING", action);
        }

        static HealResult rejected(String reason) {
            return new HealResult("REJECTED", reason);
        }
    }
}
