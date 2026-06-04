package com.pb.swap.archiver.engine;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.pb.swap.archiver.engine.LogAndAgMonitor.Reading;
import org.junit.jupiter.api.Test;

/**
 * Pure decision logic for {@link LogAndAgMonitor#shouldPause} — no database needed. Verifies that
 * each pressure source independently trips a pause, including the AG <em>send</em> queue (the direct
 * RPO signal) and that an unknown log reading ({@code -1}) does not pause.
 */
class LogAndAgMonitorTest {

    private static final int LOG_PAUSE_PCT = 70;
    private static final long AG_PAUSE_KB = 5_000_000L;

    private final LogAndAgMonitor monitor = new LogAndAgMonitor(null, null);

    @Test
    void healthyReadingDoesNotPause() {
        assertFalse(monitor.shouldPause(new Reading(10, "NOTHING", 0L, 0L), LOG_PAUSE_PCT, AG_PAUSE_KB));
    }

    @Test
    void highLogUsagePauses() {
        assertTrue(monitor.shouldPause(new Reading(80, "NOTHING", 0L, 0L), LOG_PAUSE_PCT, AG_PAUSE_KB));
    }

    @Test
    void unknownLogUsageDoesNotPause() {
        assertFalse(monitor.shouldPause(new Reading(-1, null, 0L, 0L), LOG_PAUSE_PCT, AG_PAUSE_KB));
    }

    @Test
    void logBackupWaitPauses() {
        assertTrue(monitor.shouldPause(new Reading(10, "LOG_BACKUP", 0L, 0L), LOG_PAUSE_PCT, AG_PAUSE_KB));
    }

    @Test
    void highRedoQueuePauses() {
        assertTrue(monitor.shouldPause(new Reading(10, "NOTHING", 6_000_000L, 0L), LOG_PAUSE_PCT, AG_PAUSE_KB));
    }

    @Test
    void highSendQueuePauses() {
        // Send queue = primary log not yet shipped → direct RPO exposure; must pause even when redo is fine.
        assertTrue(monitor.shouldPause(new Reading(10, "NOTHING", 0L, 6_000_000L), LOG_PAUSE_PCT, AG_PAUSE_KB));
    }
}
