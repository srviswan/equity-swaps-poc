package com.pb.swap.archiver.engine;

import com.pb.swap.archiver.config.ArchiverProperties;
import com.pb.swap.archiver.restore.RestoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Top-level run loop. Depending on {@code archiver.mode} it runs ARCHIVE, RESTORE, or DRY_RUN.
 *
 * <p>ARCHIVE flow: preflight → refresh basket state → build/resume worklist → for each chunk,
 * respect the scheduling window, wait while log/AG pressure is high, size the batch adaptively,
 * process the chunk (copy → verify → delete, FK-ordered, checkpointed), then mark baskets archived.
 * On restart it resumes from the last {@code DONE} chunk.
 */
@Component
public class Orchestrator {

    private static final Logger log = LoggerFactory.getLogger(Orchestrator.class);

    private final ArchiverProperties props;
    private final PreflightValidator preflight;
    private final WorklistProvider worklist;
    private final ChunkProcessor chunkProcessor;
    private final WindowScheduler windows;
    private final LogAndAgMonitor monitor;
    private final AdaptiveController adaptive;
    private final RestoreService restore;
    private final StopController stop;

    public Orchestrator(
            ArchiverProperties props,
            PreflightValidator preflight,
            WorklistProvider worklist,
            ChunkProcessor chunkProcessor,
            WindowScheduler windows,
            LogAndAgMonitor monitor,
            AdaptiveController adaptive,
            RestoreService restore,
            StopController stop) {
        this.props = props;
        this.preflight = preflight;
        this.worklist = worklist;
        this.chunkProcessor = chunkProcessor;
        this.windows = windows;
        this.monitor = monitor;
        this.adaptive = adaptive;
        this.restore = restore;
        this.stop = stop;
    }

    /** @return process exit code (0 = success). */
    public int run() {
        String mode = props.mode() == null ? "ARCHIVE" : props.mode().toUpperCase();
        log.info("Orchestrator mode={}", mode);

        // Break-glass: requesting a stop never touches data, so it runs before pre-flight.
        if ("STOP".equals(mode) || "PAUSE".equals(mode)) {
            stop.writeSignal(StopController.Signal.valueOf(mode), "ad-hoc " + mode + " via CLI");
            log.warn("Signalled {} for job {}; running engine will halt at the next safe boundary.",
                    mode, props.jobName());
            return 0;
        }

        // Phase 1: always run pre-flight first. It gates every mode.
        PreflightReport report = preflight.validate();
        log.info("\n{}", report.render());
        if (!report.ok()) {
            log.error("Pre-flight failed; aborting before any data operation.");
            return 2;
        }

        return switch (mode) {
            case "DRY_RUN" -> {
                log.info("DRY_RUN: pre-flight passed; no data changes performed.");
                yield 0;
            }
            case "ARCHIVE" -> {
                StopController.Signal signal = stop.current();
                if (signal != StopController.Signal.RUN) {
                    log.warn(
                            "Break-glass active (run_signal={}); not starting. Set run_signal=RUN to resume.",
                            signal);
                    yield 3;
                }
                // TODO(phase 2+): markRunning(true); refresh basket state; for each chunk, before work
                // check stop.shouldHalt() and register the active Statement so a STOP cancels it.
                log.info("ARCHIVE: pre-flight passed; archival loop not yet implemented (phase 2+).");
                yield 0;
            }
            case "RESTORE" -> {
                // TODO(phase 7): reverse pipeline into the investigation DB.
                log.info("RESTORE: pre-flight passed; restore not yet implemented (phase 7).");
                yield 0;
            }
            default -> throw new IllegalArgumentException("Unknown mode: " + mode);
        };
    }
}
