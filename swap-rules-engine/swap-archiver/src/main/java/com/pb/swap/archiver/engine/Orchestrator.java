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

    public Orchestrator(
            ArchiverProperties props,
            PreflightValidator preflight,
            WorklistProvider worklist,
            ChunkProcessor chunkProcessor,
            WindowScheduler windows,
            LogAndAgMonitor monitor,
            AdaptiveController adaptive,
            RestoreService restore) {
        this.props = props;
        this.preflight = preflight;
        this.worklist = worklist;
        this.chunkProcessor = chunkProcessor;
        this.windows = windows;
        this.monitor = monitor;
        this.adaptive = adaptive;
        this.restore = restore;
    }

    /** @return process exit code (0 = success). */
    public int run() {
        String mode = props.mode() == null ? "ARCHIVE" : props.mode().toUpperCase();
        log.info("Orchestrator mode={}", mode);
        // TODO(phase 1+): wire the flow described in the class javadoc. Skeleton returns success so
        // the application context boots; real behaviour is implemented per phase.
        return switch (mode) {
            case "ARCHIVE", "DRY_RUN", "RESTORE" -> 0;
            default -> throw new IllegalArgumentException("Unknown mode: " + mode);
        };
    }
}
