package com.pb.swap.archiver.engine;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

/**
 * Enforces the per-day-of-week run windows from {@code archive_window}. Before each chunk it checks
 * whether we are inside the window and whether the estimated chunk time fits the remaining window
 * (or duration budget); if not, the engine stops cleanly at the last committed chunk boundary.
 * Weekends typically allow larger windows and bigger batch caps.
 */
@Component
public class WindowScheduler {

    /** @return true if a chunk estimated to take {@code estimatedMillis} may start now. */
    public boolean canStartChunk(LocalDateTime now, long estimatedMillis) {
        // TODO(phase 3): load today's window, check now in [start,end] and estimate fits remaining.
        throw new UnsupportedOperationException("scaffold: window scheduling not yet implemented");
    }
}
