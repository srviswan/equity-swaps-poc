package com.pb.swap.rules.core.action;

import com.pb.swap.rules.core.model.Action;
import com.pb.swap.rules.core.model.OverridePolicy;

/** Mutable swap surface used by evaluation strategies. */
public interface SwapWriter {
    String readAsString(String path);

    void set(String path, Object value);

    record MutationResult(boolean applied, String before, String after) {
        public static MutationResult skipped(String before, String after) {
            return new MutationResult(false, before, after);
        }

        public static MutationResult applied(String before, String after) {
            return new MutationResult(true, before, after);
        }
    }

    static MutationResult apply(SwapWriter writer, Action action) {
        String path = action.targetPath();
        if (path == null) {
            return MutationResult.skipped(null, null);
        }
        String before = writer.readAsString(path);
        if (action.overridePolicy() == OverridePolicy.NEVER && before != null && !before.isBlank()) {
            return MutationResult.skipped(before, before);
        }
        writer.set(path, action.value());
        String after = writer.readAsString(path);
        return MutationResult.applied(before, after);
    }
}
