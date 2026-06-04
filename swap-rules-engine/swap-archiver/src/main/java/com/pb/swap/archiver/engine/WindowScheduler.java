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
 * whether we are inside the window and whether the estimated chunk time fits the remaining window;
 * if not, the engine stops cleanly at the last committed chunk boundary. Weekends typically allow
 * larger windows and bigger batch caps.
 *
 * <p>If no windows are configured for the job at all, the engine runs unrestricted (dev / continuous
 * mode). Once any window exists, time outside a configured window is a clean stop.
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
        int dow = sqlWeekday(now.getDayOfWeek());
        List<Map<String, Object>> rows =
                controlJdbc.queryForList(
                        "SELECT start_time, end_time, max_duration_mins FROM archive_window"
                                + " WHERE job_name = ? AND day_of_week = ?",
                        props.jobName(),
                        dow);
        if (rows.isEmpty()) {
            return new Decision(false, "outside window: no window for day_of_week=" + dow);
        }
        LocalTime start = ((Time) rows.get(0).get("start_time")).toLocalTime();
        LocalTime end = ((Time) rows.get(0).get("end_time")).toLocalTime();
        LocalTime current = now.toLocalTime();
        if (current.isBefore(start) || current.isAfter(end)) {
            return new Decision(false, "outside window " + start + "-" + end + " (now " + current + ")");
        }
        long remainingMs = (end.toSecondOfDay() - current.toSecondOfDay()) * 1000L;
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
