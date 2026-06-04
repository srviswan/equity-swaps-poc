package com.pb.swap.archiver.engine;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

/**
 * Owns the run header and the eligible-basket worklist. Chunks are formed at <em>runtime</em> by
 * {@link #nextChunk}, so the {@link AdaptiveController} can resize them mid-run; a crash leaves
 * {@code IN_PROGRESS} rows that the next run reclaims first.
 *
 * <p>Eligibility ({@code status='TERMINATED' AND archived=0 AND termination_date < as_of -
 * retention_months}) is read from {@code basket_archive_state}, which {@link BasketStateRefresher}
 * populates from the source basket dimension (or an operator/ETL seeds directly).
 */
@Component
public class WorklistProvider {

    private static final Logger log = LoggerFactory.getLogger(WorklistProvider.class);

    private final JdbcTemplate controlJdbc;

    public WorklistProvider(JdbcTemplate controlJdbc) {
        this.controlJdbc = controlJdbc;
    }

    /** A chunk of eligible baskets to process across all in-scope tables. */
    public record Chunk(long runId, int chunkNo, List<Long> basketKeys) {}

    /** Pacing knobs read from {@code archive_job}. */
    public record JobConfig(
            int defaultBatchSize,
            int minBatchSize,
            int maxBatchSize,
            int logUsedPctPause,
            long agRedoQueuePause) {}

    public JobConfig loadJob(String jobName) {
        return controlJdbc.queryForObject(
                "SELECT default_batch_size, min_batch_size, max_batch_size, log_used_pct_pause, ag_redo_queue_pause"
                        + " FROM archive_job WHERE job_name = ?",
                (rs, i) ->
                        new JobConfig(
                                rs.getInt("default_batch_size"),
                                rs.getInt("min_batch_size"),
                                rs.getInt("max_batch_size"),
                                rs.getInt("log_used_pct_pause"),
                                rs.getLong("ag_redo_queue_pause")),
                jobName);
    }

    /**
     * Resume the newest still-RUNNING ARCHIVE run for the job (crash/pause recovery), or start a new
     * one. The same run id means {@link #buildWorklist} is a no-op and {@link #nextChunk} replays the
     * pending/in-progress baskets.
     */
    public long openRun(String jobName, String mode, LocalDate asOf) {
        List<Long> running =
                controlJdbc.queryForList(
                        "SELECT TOP 1 run_id FROM archive_run WHERE job_name = ? AND mode = ? AND status = 'RUNNING'"
                                + " ORDER BY run_id DESC",
                        Long.class,
                        jobName,
                        mode);
        if (!running.isEmpty()) {
            long runId = running.get(0);
            log.info("Resuming in-progress run {} for job {}", runId, jobName);
            return runId;
        }
        KeyHolder kh = new GeneratedKeyHolder();
        controlJdbc.update(
                con -> {
                    PreparedStatement ps =
                            con.prepareStatement(
                                    "INSERT INTO archive_run (job_name, as_of_date, mode, status)"
                                            + " VALUES (?, ?, ?, 'RUNNING')",
                                    new String[] {"run_id"});
                    ps.setString(1, jobName);
                    ps.setDate(2, Date.valueOf(asOf));
                    ps.setString(3, mode);
                    return ps;
                },
                kh);
        long runId = kh.getKey().longValue();
        log.info("Started run {} for job {} (as_of={})", runId, jobName, asOf);
        return runId;
    }

    /** Materialise eligible baskets for the run (idempotent: a populated worklist is left as-is). */
    public void buildWorklist(long runId, String jobName, LocalDate asOf) {
        boolean populated =
                !controlJdbc
                        .queryForList("SELECT TOP 1 basket_key FROM archive_worklist WHERE run_id = ?", Long.class, runId)
                        .isEmpty();
        if (populated) {
            log.info("Run {} already has a worklist; resuming.", runId);
            return;
        }
        int retentionMonths =
                controlJdbc.queryForObject(
                        "SELECT retention_months FROM archive_job WHERE job_name = ?", Integer.class, jobName);
        List<Long> eligible =
                controlJdbc.queryForList(
                        "SELECT basket_key FROM basket_archive_state"
                                + " WHERE status = 'TERMINATED' AND archived = 0 AND termination_date < DATEADD(MONTH, ?, ?)"
                                + " ORDER BY basket_key",
                        Long.class,
                        -retentionMonths,
                        Date.valueOf(asOf));
        controlJdbc.batchUpdate(
                "INSERT INTO archive_worklist (run_id, basket_key, status) VALUES (?, ?, 'PENDING')",
                eligible.stream().map(k -> new Object[] {runId, k}).toList());
        controlJdbc.update(
                "UPDATE archive_run SET baskets_selected = ? WHERE run_id = ?", eligible.size(), runId);
        log.info("Built worklist for run {}: {} eligible basket(s)", runId, eligible.size());
    }

    /**
     * Form the next chunk: reclaim an existing {@code IN_PROGRESS} chunk first (crash recovery), else
     * claim up to {@code batchBaskets} pending baskets into a new chunk. Returns {@code null} when no
     * work remains.
     */
    public Chunk nextChunk(long runId, int batchBaskets) {
        List<Integer> inProgress =
                controlJdbc.queryForList(
                        "SELECT DISTINCT chunk_no FROM archive_worklist WHERE run_id = ? AND status = 'IN_PROGRESS'"
                                + " ORDER BY chunk_no",
                        Integer.class,
                        runId);
        if (!inProgress.isEmpty()) {
            int chunkNo = inProgress.get(0);
            List<Long> keys =
                    controlJdbc.queryForList(
                            "SELECT basket_key FROM archive_worklist WHERE run_id = ? AND chunk_no = ?"
                                    + " AND status = 'IN_PROGRESS' ORDER BY basket_key",
                            Long.class,
                            runId,
                            chunkNo);
            log.info("Reclaiming in-progress chunk {} ({} basket(s)) for run {}", chunkNo, keys.size(), runId);
            return new Chunk(runId, chunkNo, keys);
        }

        int batch = Math.max(1, batchBaskets);
        int chunkNo =
                controlJdbc.queryForObject(
                        "SELECT ISNULL(MAX(chunk_no), -1) + 1 FROM archive_worklist WHERE run_id = ?",
                        Integer.class,
                        runId);
        List<Long> keys =
                controlJdbc.queryForList(
                        "WITH c AS (SELECT TOP (" + batch + ") basket_key, chunk_no, status FROM archive_worklist"
                                + " WHERE run_id = ? AND status = 'PENDING' ORDER BY basket_key)"
                                + " UPDATE c SET chunk_no = ?, status = 'IN_PROGRESS' OUTPUT inserted.basket_key",
                        Long.class,
                        runId,
                        chunkNo);
        if (keys.isEmpty()) {
            return null;
        }
        return new Chunk(runId, chunkNo, keys);
    }

    /** All tables for the chunk are moved: mark the worklist done and flag the baskets archived. */
    public void markChunkArchived(Chunk chunk) {
        controlJdbc.update(
                "UPDATE archive_worklist SET status = 'DONE' WHERE run_id = ? AND chunk_no = ?",
                chunk.runId(),
                chunk.chunkNo());
        controlJdbc.batchUpdate(
                "UPDATE basket_archive_state SET archived = 1, status = 'ARCHIVED', archive_batch_id = ?,"
                        + " archived_at_utc = SYSUTCDATETIME() WHERE basket_key = ?",
                chunk.basketKeys().stream().map(k -> new Object[] {chunk.runId(), k}).toList());
    }

    public void completeRun(long runId, String status, long rowsCopied, long rowsDeleted, String errorText) {
        controlJdbc.update(
                "UPDATE archive_run SET status = ?, ended_at_utc = SYSUTCDATETIME(), rows_copied = ?,"
                        + " rows_deleted = ?, error_text = ? WHERE run_id = ?",
                status,
                rowsCopied,
                rowsDeleted,
                errorText,
                runId);
    }
}
