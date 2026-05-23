package com.pb.swap.rules.core.field;

import com.pb.swap.rules.core.compile.EvaluationContextView;
import com.pb.swap.rules.core.model.EnrichedEquitySwap;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/** Pre-compiled field accessors for hot-path evaluation (no reflection at runtime). */
public final class FieldAccessorRegistry {
    private final Map<String, Function<EvaluationContextView, Object>> accessors = new HashMap<>();

    public FieldAccessorRegistry() {
        registerDefaults();
    }

    private void registerDefaults() {
        register("tradeId", ctx -> ctx.rawTrade().tradeId());
        register("productType", ctx -> ctx.rawTrade().productType());
        register("book", ctx -> ctx.rawTrade().book());
        register("currency", ctx -> ctx.rawTrade().currency());
        register("clientTier", ctx -> ctx.rawTrade().clientTier());
        register("source", ctx -> ctx.rawTrade().source());
        register("notional", ctx -> ctx.rawTrade().notional());
        register("tradeDate", ctx -> ctx.rawTrade().tradeDate());
        register("securityId", ctx -> ctx.rawTrade().securityId());
        register(
                "interestLeg.dayCount",
                ctx -> {
                    var s = ctx.partialSwap();
                    return s != null && s.interestLeg() != null ? s.interestLeg().dayCount() : null;
                });
        register(
                "interestLeg.spreadBps",
                ctx -> {
                    var s = ctx.partialSwap();
                    return s != null && s.interestLeg() != null ? s.interestLeg().spreadBps() : null;
                });
        register(
                "interestLeg.rateType",
                ctx -> {
                    var s = ctx.partialSwap();
                    return s != null && s.interestLeg() != null ? s.interestLeg().rateType() : null;
                });
        register(
                "equityLeg.returnType",
                ctx -> {
                    var s = ctx.partialSwap();
                    return s != null && s.equityLeg() != null ? s.equityLeg().returnType() : null;
                });
        register(
                "schedule.paymentFrequency",
                ctx -> {
                    var s = ctx.partialSwap();
                    return s != null && s.schedule() != null ? s.schedule().paymentFrequency() : null;
                });
        register(
                "divPassthrough.percent",
                ctx -> {
                    var s = ctx.partialSwap();
                    return s != null && s.divPassthrough() != null ? s.divPassthrough().percent() : null;
                });
        register("workflowStatus", ctx -> ctx.partialSwap().workflowStatus());
        register("routingDestination", ctx -> ctx.partialSwap().routingDestination());
        register("legalEntity", ctx -> ctx.partialSwap().legalEntity());
        register(
                "swapContract.productType",
                ctx -> {
                    var s = ctx.partialSwap();
                    return s != null && s.swapContract() != null ? s.swapContract().productType() : null;
                });
    }

    public void register(String path, Function<EvaluationContextView, Object> accessor) {
        accessors.put(path, accessor);
    }

    public Object resolve(EvaluationContextView ctx, String fieldPath) {
        Function<EvaluationContextView, Object> fn = accessors.get(fieldPath);
        if (fn != null) {
            return fn.apply(ctx);
        }
        if (fieldPath != null && fieldPath.startsWith("attributes.")) {
            String key = fieldPath.substring("attributes.".length());
            Map<String, Object> attrs = ctx.rawTrade().attributes();
            return attrs != null ? attrs.get(key) : null;
        }
        return null;
    }

    /** Optional MethodHandle-based registration for extension. */
    public void registerHandle(String path, MethodHandle handle, Class<?> receiverType) {
        accessors.put(
                path,
                ctx -> {
                    try {
                        Object receiver =
                                receiverType == RawHedgeTrade.class
                                        ? ctx.rawTrade()
                                        : ctx.partialSwap();
                        return handle.invoke(receiver);
                    } catch (Throwable t) {
                        throw new IllegalStateException("Field access failed: " + path, t);
                    }
                });
    }

    public static MethodHandles.Lookup lookup() {
        return MethodHandles.lookup();
    }
}
