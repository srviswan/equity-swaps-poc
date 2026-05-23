package com.pb.swap.rules.admin.service;

import com.pb.swap.rules.core.snapshot.RuleSnapshot;
import java.util.concurrent.atomic.AtomicReference;

public final class SnapshotHolder {
    private final AtomicReference<RuleSnapshot> ref;

    public SnapshotHolder(RuleSnapshot initial) {
        this.ref = new AtomicReference<>(initial);
    }

    public AtomicReference<RuleSnapshot> reference() {
        return ref;
    }

    public RuleSnapshot get() {
        return ref.get();
    }

    public void set(RuleSnapshot snapshot) {
        ref.set(snapshot);
    }
}
