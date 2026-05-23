package com.pb.swap.rules.runtime.context;

import com.pb.swap.rules.core.compile.EvaluationContextView;
import com.pb.swap.rules.core.field.FieldAccessorRegistry;
import com.pb.swap.rules.core.model.EnrichedEquitySwap;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.core.snapshot.RuleSnapshot;
import com.pb.swap.rules.runtime.builder.EquitySwapBuilder;

public final class EvaluationContext implements EvaluationContextView {
    private final FieldAccessorRegistry fieldRegistry;
    private RawHedgeTrade rawTrade;
    private EquitySwapBuilder builder;
    private RuleSnapshot snapshot;

    public EvaluationContext(FieldAccessorRegistry fieldRegistry) {
        this.fieldRegistry = fieldRegistry;
    }

    public EvaluationContext bind(RawHedgeTrade raw, RuleSnapshot snapshot, EquitySwapBuilder builder) {
        this.rawTrade = raw;
        this.snapshot = snapshot;
        this.builder = builder;
        return this;
    }

    public void clear() {
        this.rawTrade = null;
        this.snapshot = null;
        this.builder = null;
    }

    public EquitySwapBuilder builder() {
        return builder;
    }

    public RuleSnapshot snapshot() {
        return snapshot;
    }

    @Override
    public RawHedgeTrade rawTrade() {
        return rawTrade;
    }

    @Override
    public EnrichedEquitySwap partialSwap() {
        return builder != null ? builder.partial() : null;
    }

    @Override
    public Object resolveField(String fieldPath) {
        if (fieldRegistry != null) {
            Object v = fieldRegistry.resolve(this, fieldPath);
            if (v != null) {
                return v;
            }
        }
        return null;
    }
}
