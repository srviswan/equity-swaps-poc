package com.pb.swap.archiver.engine;

import com.pb.swap.archiver.config.ArchiverProperties;
import jakarta.annotation.PostConstruct;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.atomic.AtomicReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Emergency "break-glass" stop. The engine is already crash-safe (every chunk is transactional), so
 * halting is always safe and restartable. Three layers, fastest first:
 *
 * <ol>
 *   <li><b>DB flag</b> — a DBA flips {@code archive_job.run_signal} to PAUSE/STOP from any SQL
 *       client; the engine checks it at every committed boundary and halts cleanly.
 *   <li><b>In-process cancel</b> — the active {@link Statement} is registered; a stop cancels the
 *       in-flight SQL, rolling back the current chunk (re-run on restart).
 *   <li><b>OS signal / KILL</b> — SIGTERM/Ctrl-C trigger a graceful stop; a hard kill or SQL Server
 *       {@code KILL spid} is still safe because the in-flight transaction rolls back.
 * </ol>
 */
@Component
public class StopController {

    private static final Logger log = LoggerFactory.getLogger(StopController.class);

    /** RUN = proceed; PAUSE = halt now, resume next window; STOP = halt and stay down until reset. */
    public enum Signal {
        RUN,
        PAUSE,
        STOP
    }

    private final JdbcTemplate controlJdbc;
    private final ArchiverProperties props;
    private final AtomicReference<Statement> active = new AtomicReference<>();
    private volatile boolean localStop = false;
    private volatile boolean running = false;
    private volatile String reason;

    public StopController(JdbcTemplate controlJdbc, ArchiverProperties props) {
        this.controlJdbc = controlJdbc;
        this.props = props;
    }

    @PostConstruct
    void registerShutdownHook() {
        Runtime.getRuntime()
                .addShutdownHook(
                        new Thread(
                                () -> {
                                    if (running) {
                                        requestLocalStop("JVM shutdown signal (SIGTERM/Ctrl-C)");
                                    }
                                },
                                "archiver-stop-hook"));
    }

    /** Mark the archival loop active so the shutdown hook knows to interrupt it. */
    public void markRunning(boolean value) {
        this.running = value;
    }

    /** Register the statement currently executing so a stop can cancel it. */
    public void register(Statement statement) {
        active.set(statement);
    }

    /** Clear the registered statement once it completes. */
    public void clear(Statement statement) {
        active.compareAndSet(statement, null);
    }

    /** Current effective signal: a local stop wins; otherwise read the control flag (fail-open). */
    public Signal current() {
        if (localStop) {
            return Signal.STOP;
        }
        try {
            String value =
                    controlJdbc.queryForObject(
                            "SELECT run_signal FROM archive_job WHERE job_name = ?",
                            String.class,
                            props.jobName());
            return parse(value);
        } catch (RuntimeException e) {
            log.debug("could not read run_signal (fail-open to RUN): {}", e.toString());
            return Signal.RUN;
        }
    }

    /** True at a safe boundary when the run should halt now (PAUSE or STOP). */
    public boolean shouldHalt() {
        return current() != Signal.RUN;
    }

    /** Break-glass from inside the process: set the local flag and cancel any in-flight statement. */
    public void requestLocalStop(String reason) {
        this.localStop = true;
        this.reason = reason;
        Statement st = active.get();
        if (st != null) {
            try {
                st.cancel();
            } catch (SQLException e) {
                log.debug("statement cancel failed (will stop at next boundary)", e);
            }
        }
        log.warn("Break-glass STOP requested: {}", reason);
    }

    /** Persist a signal to the control table (used by the ad-hoc STOP CLI mode). */
    public void writeSignal(Signal signal, String reason) {
        controlJdbc.update(
                "UPDATE archive_job SET run_signal = ?, signal_reason = ?, signal_by = SUSER_SNAME(),"
                        + " signal_at = SYSUTCDATETIME() WHERE job_name = ?",
                signal.name(),
                reason,
                props.jobName());
        log.warn("Wrote run_signal={} reason='{}' for job {}", signal, reason, props.jobName());
    }

    public String reason() {
        return reason;
    }

    private static Signal parse(String value) {
        if (value == null) {
            return Signal.RUN;
        }
        try {
            return Signal.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return Signal.RUN;
        }
    }
}
