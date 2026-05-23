package com.pb.swap.rules.runtime.context;

import com.pb.swap.rules.core.field.FieldAccessorRegistry;

public final class ContextPool {
    private static final int MAX_POOL = 32;
    private final ThreadLocal<EvaluationContext> pool =
            ThreadLocal.withInitial(() -> new EvaluationContext(new FieldAccessorRegistry()));

    public EvaluationContext acquire() {
        return pool.get();
    }

    public void release(EvaluationContext ctx) {
        ctx.clear();
    }
}
