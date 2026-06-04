package com.pb.swap.archiver.engine;

import com.pb.swap.archiver.config.ArchiverProperties;
import com.pb.swap.archiver.restore.RestoreService;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    /**
     * Initial rows-per-basket guess used to convert the row-based adaptive batch target into a basket
     * count for the first chunk. It is then continuously refined from observed chunks (EMA), so the
     * seed only matters until the first chunk completes.
     */
    private static final double INITIAL_ROWS_PER_BASKET = 1_000.0;

    private static final double ROWS_PER_BASKET_EMA_ALPHA = 0.3;

    private final ArchiverProperties props;
    private final PreflightValidator preflight;
    private final WorklistProvider worklist;
    private final ChunkProcessor chunkProcessor;
    private final WindowScheduler windows;
    private final LogAndAgMonitor monitor;
    private final AdaptiveController adaptive;
    private final IndexManager indexManager;
    private final BasketStateRefresher basketState;
    private final StatsMaintainer statsMaintainer;
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
            IndexManager indexManager,
            BasketStateRefresher basketState,
            StatsMaintainer statsMaintainer,
            RestoreService restore,
            StopController stop) {
        this.props = props;
        this.preflight = preflight;
        this.worklist = worklist;
        this.chunkProcessor = chunkProcessor;
        this.windows = windows;
        this.monitor = monitor;
        this.adaptive = adaptive;
        this.indexManager = indexManager;
        this.basketState = basketState;
        this.statsMaintainer = statsMaintainer;
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
            case "ARCHIVE" -> archive();
            case "RESTORE" -> restore();
            default -> throw new IllegalArgumentException("Unknown mode: " + mode);
        };
    }

    /**
     * Phase 3 archive loop: open (or resume) a run, materialise the worklist, then repeatedly form a
     * chunk (sized adaptively), gate it on the scheduling window and log/AG pressure, move its tables
     * (copy → delete, checkpointed), mark baskets archived, and adapt the next batch size. Honours the
     * break-glass stop and a closing window by stopping cleanly at the last committed boundary —
     * always leaving a restartable, consistent state.
     */
    private int archive() {
        StopController.Signal signal = stop.current();
        if (signal != StopController.Signal.RUN) {
            log.warn("Break-glass active (run_signal={}); not starting. Set run_signal=RUN to resume.", signal);
            return 3;
        }

        LocalDate asOf =
                (props.asOfDate() == null || props.asOfDate().isBlank())
                        ? LocalDate.now()
                        : LocalDate.parse(props.asOfDate());
        // Refresh basket lifecycle from the source dimension before selecting eligible baskets
        // (no-op when the job has no basket source configured — basket_archive_state is seeded).
        basketState.refresh(props.jobName());

        long runId = worklist.openRun(props.jobName(), "ARCHIVE", asOf);
        worklist.buildWorklist(runId, props.jobName(), asOf);

        WorklistProvider.JobConfig job = worklist.loadJob(props.jobName());
        long targetChunkMillis = props.throttle().targetChunkMillis();
        long pollPauseMillis = props.throttle().pollPauseMillis();
        int targetRows = job.defaultBatchSize();
        double rowsPerBasket = INITIAL_ROWS_PER_BASKET;
        long lastChunkMillis = targetChunkMillis;

        stop.markRunning(true);
        long copied = 0;
        long deleted = 0;
        int chunks = 0;
        long runStart = System.currentTimeMillis();
        boolean indexesDisabled = false;
        String haltReason = null;
        try {
            while (true) {
                if (stop.shouldHalt()) {
                    haltReason = "break-glass stop signalled";
                    break;
                }
                WindowScheduler.Decision window = windows.canStartChunk(LocalDateTime.now(), lastChunkMillis);
                if (!window.allowed()) {
                    haltReason = "scheduling window: " + window.reason();
                    break;
                }
                if (pressurePauseExceedsBoundary(job, pollPauseMillis, lastChunkMillis)) {
                    haltReason = "halted while waiting on log/AG pressure";
                    break;
                }

                int batchBaskets = Math.max(1, (int) Math.round(targetRows / Math.max(1.0, rowsPerBasket)));
                WorklistProvider.Chunk chunk = worklist.nextChunk(runId, batchBaskets);
                if (chunk == null) {
                    break; // no work left → DONE
                }

                // Disable target indexes once, only when there is actually work to load.
                if (!indexesDisabled) {
                    indexManager.disableForJob(props.jobName());
                    indexesDisabled = true;
                }

                long start = System.currentTimeMillis();
                ChunkProcessor.ChunkResult result = chunkProcessor.process(props.jobName(), chunk);
                lastChunkMillis = System.currentTimeMillis() - start;
                worklist.markChunkArchived(chunk);
                copied += result.rowsCopied();
                deleted += result.rowsDeleted();
                chunks++;

                rowsPerBasket = updateRowsPerBasket(rowsPerBasket, result.rowsCopied(), chunk.basketKeys().size());
                boolean pressure =
                        monitor.shouldPause(monitor.sample(), job.logUsedPctPause(), job.agRedoQueuePause());
                int prevTarget = targetRows;
                targetRows =
                        adaptive.nextBatchSize(
                                targetRows, lastChunkMillis, targetChunkMillis, pressure, job.minBatchSize(),
                                job.maxBatchSize());
                log.info(
                        "chunk {} done in {}ms: {} baskets, +{} / -{} rows; batch target {}→{} rows{}",
                        chunk.chunkNo(),
                        lastChunkMillis,
                        chunk.basketKeys().size(),
                        result.rowsCopied(),
                        result.rowsDeleted(),
                        prevTarget,
                        targetRows,
                        pressure ? " (pressure)" : "");
            }

            String status = haltReason == null ? "DONE" : "PAUSED";
            worklist.completeRun(runId, status, copied, deleted, haltReason);
            long durationMs = System.currentTimeMillis() - runStart;
            // Single structured line for log-based dashboards/alerts (Prometheus via log exporter or
            // a textfile collector can scrape these key=value pairs without an in-process HTTP server).
            log.info(
                    "ARCHIVE_SUMMARY run={} status={} chunks={} copied={} deleted={} duration_ms={} halt={}",
                    runId, status, chunks, copied, deleted, durationMs, haltReason == null ? "-" : haltReason);
            if (haltReason == null) {
                log.info("ARCHIVE run {} DONE: copied {} / deleted {} row(s)", runId, copied, deleted);
                runStatsMaintenance();
            } else {
                log.warn(
                        "ALERT ARCHIVE run {} PAUSED ({}): copied {} / deleted {} so far; resumable on restart.",
                        runId, haltReason, copied, deleted);
            }
            return 0;
        } catch (RuntimeException e) {
            worklist.completeRun(runId, "FAILED", copied, deleted, e.getMessage());
            log.error(
                    "ALERT ARCHIVE run {} FAILED after copying {} / deleting {}; resumable on restart.",
                    runId, copied, deleted, e);
            return 4;
        } finally {
            // Rebuild on every path (success, halt, failure) and clean up any indexes a prior crashed
            // run left disabled. Never let an exception here mask the run outcome.
            try {
                indexManager.rebuildForJob(props.jobName());
            } catch (RuntimeException e) {
                log.error("Failed to rebuild target indexes; check archive_index_state for leftovers.", e);
            }
            stop.markRunning(false);
        }
    }

    /** Refresh source statistics after a successful run; never let it fail the archive outcome. */
    private void runStatsMaintenance() {
        try {
            int refreshed = statsMaintainer.updateStatsAfterArchive(props.jobName());
            if (refreshed > 0) {
                log.info("Post-archive stats maintenance refreshed {} source table(s)", refreshed);
            }
        } catch (RuntimeException e) {
            log.warn("Post-archive stats maintenance failed; continuing: {}", e.getMessage());
        }
    }

    /** RESTORE mode: pull the configured baskets/batches back into the investigation DB. */
    private int restore() {
        try {
            RestoreService.RestoreSummary summary = restore.restore(props.jobName());
            log.info(
                    "RESTORE DONE: {} row(s) across {} table(s) for batches {} → {}",
                    summary.rowsRestored(), summary.tables(), summary.batchIds(), summary.targetDb());
            return 0;
        } catch (RuntimeException e) {
            log.error("ALERT RESTORE failed: {}", e.getMessage(), e);
            return 5;
        }
    }

    /**
     * Wait while log/AG pressure is high, re-sampling each poll interval. Returns true if we must
     * stop before the next chunk (break-glass tripped or the window closed during the wait).
     */
    private boolean pressurePauseExceedsBoundary(
            WorklistProvider.JobConfig job, long pollPauseMillis, long estimatedChunkMillis) {
        while (monitor.shouldPause(monitor.sample(), job.logUsedPctPause(), job.agRedoQueuePause())) {
            if (stop.shouldHalt()) {
                return true;
            }
            if (!windows.canStartChunk(LocalDateTime.now(), estimatedChunkMillis).allowed()) {
                return true;
            }
            log.info("Log/AG pressure high; pausing {}ms before re-checking.", pollPauseMillis);
            try {
                Thread.sleep(pollPauseMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return true;
            }
        }
        return false;
    }

    private static double updateRowsPerBasket(double current, long rowsCopied, int baskets) {
        if (baskets <= 0 || rowsCopied <= 0) {
            return current;
        }
        double observed = (double) rowsCopied / baskets;
        return ROWS_PER_BASKET_EMA_ALPHA * observed + (1 - ROWS_PER_BASKET_EMA_ALPHA) * current;
    }
}
