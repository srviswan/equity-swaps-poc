package com.pb.swap.archiver.engine;

import com.pb.swap.archiver.config.ArchiverProperties;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Enforces the per-day-of-week run windows from {@code archive_window}. Before each chunk it checks
 * whether we are inside an open window and whether the estimated chunk time fits the remaining
 * window; if not, the engine stops cleanly at the last committed chunk boundary. Weekends typically
 * allow larger windows and bigger batch caps.
 *
 * <p>A window whose {@code end_time <= start_time} is treated as <b>crossing midnight</b> (e.g.
 * Sat 22:00 → 04:00): the segment after midnight is owned by the <em>start</em> day's row, so the
 * scheduler also considers the previous day's window when judging "now". {@code max_duration_mins},
 * when set, caps the effective close at {@code start + max_duration_mins} (whichever is earlier).
 *
 * <p>If no windows are configured for the job at all, the engine runs unrestricted (dev / continuous
 * mode). Once any window exists, time outside every configured window is a clean stop.
 */
@Component
public class WindowScheduler {

    private static final Logger log = LoggerFactory.getLogger(WindowScheduler.class);

    private final JdbcTemplate controlJdbc;
    private final ArchiverProperties props;

    public WindowScheduler(JdbcTemplate controlJdbc, ArchiverProperties props) {
        this.controlJdbc = controlJdbc;
        this.props = props;
    }

    /** Outcome of a window check: whether a chunk may start now, and a human-readable reason. */
    public record Decision(boolean allowed, String reason) {}

    /** @return whether a chunk estimated to take {@code estimatedMillis} may start at {@code now}. */
    public Decision canStartChunk(LocalDateTime now, long estimatedMillis) {
        int configured =
                controlJdbc.queryForObject(
                        "SELECT COUNT(*) FROM archive_window WHERE job_name = ?", Integer.class, props.jobName());
        if (configured == 0) {
            return new Decision(true, "no windows configured; running unrestricted");
        }
        // Two rows can cover "now": today's window, and yesterday's window if it crosses midnight.
        Decision todays = judge(now, estimatedMillis, now, false);
        if (todays.allowed()) {
            return todays;
        }
        Decision spill = judge(now, estimatedMillis, now.minusDays(1), true);
        if (spill.allowed()) {
            return spill;
        }
        // Prefer the more informative reason (today's, unless there was no window today at all).
        return todays.reason().contains("no window") ? spill : todays;
    }

    /**
     * Judge a single candidate window: the row for {@code rowDay}'s day-of-week, anchored on
     * {@code rowDay}. When {@code requireOvernight} is set, only an overnight (cross-midnight) row is
     * considered (used for yesterday's spillover into today).
     */
    private Decision judge(
            LocalDateTime now, long estimatedMillis, LocalDateTime rowDay, boolean requireOvernight) {
        int dow = sqlWeekday(rowDay.getDayOfWeek());
        List<Map<String, Object>> rows =
                controlJdbc.queryForList(
                        "SELECT start_time, end_time, max_duration_mins FROM archive_window"
                                + " WHERE job_name = ? AND day_of_week = ?",
                        props.jobName(),
                        dow);
        if (rows.isEmpty()) {
            return new Decision(false, "no window for day_of_week=" + dow);
        }
        LocalTime start = ((Time) rows.get(0).get("start_time")).toLocalTime();
        LocalTime end = ((Time) rows.get(0).get("end_time")).toLocalTime();
        boolean overnight = !end.isAfter(start);
        if (requireOvernight && !overnight) {
            return new Decision(false, "no overnight spillover for day_of_week=" + dow);
        }
        LocalDateTime open = rowDay.toLocalDate().atTime(start);
        LocalDateTime close = overnight ? rowDay.toLocalDate().plusDays(1).atTime(end) : rowDay.toLocalDate().atTime(end);
        Object maxMins = rows.get(0).get("max_duration_mins");
        if (maxMins != null) {
            LocalDateTime capped = open.plusMinutes(((Number) maxMins).longValue());
            if (capped.isBefore(close)) {
                close = capped;
            }
        }
        if (now.isBefore(open) || !now.isBefore(close)) {
            return new Decision(false, "outside window " + start + "-" + end + " (now " + now.toLocalTime() + ")");
        }
        long remainingMs = java.time.Duration.between(now, close).toMillis();
        if (estimatedMillis > remainingMs) {
            return new Decision(
                    false,
                    "estimated chunk " + estimatedMillis + "ms exceeds remaining window " + remainingMs + "ms");
        }
        return new Decision(true, "within window " + start + "-" + end);
    }

    /** Map {@link DayOfWeek} to SQL Server's default {@code DATEPART(weekday)} (1=Sun .. 7=Sat). */
    private static int sqlWeekday(DayOfWeek day) {
        return day == DayOfWeek.SUNDAY ? 1 : day.getValue() + 1;
    }
}
