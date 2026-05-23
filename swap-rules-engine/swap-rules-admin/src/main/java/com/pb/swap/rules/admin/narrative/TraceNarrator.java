package com.pb.swap.rules.admin.narrative;

import com.pb.swap.rules.core.trace.DecisionRecord;
import com.pb.swap.rules.core.trace.DecisionTrace;
import java.util.ArrayList;
import java.util.List;

public final class TraceNarrator {
    public TraceNarrative narrate(DecisionTrace trace) {
        List<String> lines = new ArrayList<>();
        lines.add("Trade " + trace.tradeId() + " enriched using snapshot " + trace.snapshotVersion());
        for (DecisionRecord d : trace.decisions()) {
            lines.add(
                    String.format(
                            "[%d] Rule %s v%d (%s/%s, specificity=%.1f): set %s from '%s' to '%s' — %s",
                            d.seq(),
                            d.ruleId(),
                            d.ruleVersion(),
                            d.category(),
                            d.target(),
                            d.specificity(),
                            d.paths().isEmpty() ? "n/a" : String.join(",", d.paths()),
                            d.before(),
                            d.after(),
                            d.reason()));
        }
        for (var u : trace.unresolved()) {
            lines.add("Unresolved " + u.target() + " at " + u.path() + ": " + u.status());
        }
        if (trace.overflow()) {
            lines.add("(Trace truncated — additional decisions omitted)");
        }
        return new TraceNarrative(trace.traceId(), lines);
    }

    public record TraceNarrative(String traceId, List<String> lines) {}
}
