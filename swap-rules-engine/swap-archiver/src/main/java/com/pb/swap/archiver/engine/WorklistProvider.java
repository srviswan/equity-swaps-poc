package com.pb.swap.archiver.engine;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

/**
 * Owns the run header and the eligible-basket worklist that drives chunking and restart.
 *
 * <p>Eligibility ({@code status='TERMINATED' AND archived=0 AND termination_date < as_of -
 * retention_months}) is read from {@code basket_archive_state}, which an operator/test seeds for now
 * (the automatic {@code DimBasket} refresh is phase 6). Eligible baskets are grouped into chunks and
 * persisted to {@code archive_worklist}; on restart we resume the chunks not yet {@code DONE}.
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

    public void refreshBasketState() {
        // TODO(phase 6): light upsert from DimBasket -> basket_archive_state.
        throw new UnsupportedOperationException("scaffold: basket-state refresh not yet implemented (phase 6)");
    }

    /**
     * Resume the newest still-RUNNING ARCHIVE run for the job (crash/pause recovery), or start a new
     * one. Returning the same run id means {@link #buildOrResume} will replay its pending chunks.
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

    /** Build a fresh worklist for the run, or return the pending chunks of an existing one. */
    public List<Chunk> buildOrResume(long runId, String jobName, LocalDate asOf, int basketsPerChunk) {
        boolean hasWorklist =
                !controlJdbc
                        .queryForList("SELECT TOP 1 chunk_no FROM archive_worklist WHERE run_id = ?", Integer.class, runId)
                        .isEmpty();
        if (hasWorklist) {
            return resumePendingChunks(runId);
        }
        return buildFresh(runId, jobName, asOf, basketsPerChunk);
    }

    private List<Chunk> resumePendingChunks(long runId) {
        List<Integer> chunkNos =
                controlJdbc.queryForList(
                        "SELECT DISTINCT chunk_no FROM archive_worklist WHERE run_id = ? AND status <> 'DONE'"
                                + " ORDER BY chunk_no",
                        Integer.class,
                        runId);
        List<Chunk> chunks = new ArrayList<>();
        for (int chunkNo : chunkNos) {
            List<Long> keys =
                    controlJdbc.queryForList(
                            "SELECT basket_key FROM archive_worklist WHERE run_id = ? AND chunk_no = ? AND status <> 'DONE'"
                                    + " ORDER BY basket_key",
                            Long.class,
                            runId,
                            chunkNo);
            chunks.add(new Chunk(runId, chunkNo, keys));
        }
        log.info("Resumed run {} with {} pending chunk(s)", runId, chunks.size());
        return chunks;
    }

    private List<Chunk> buildFresh(long runId, String jobName, LocalDate asOf, int basketsPerChunk) {
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

        List<Chunk> chunks = new ArrayList<>();
        int chunkNo = 0;
        for (int i = 0; i < eligible.size(); i += basketsPerChunk) {
            List<Long> slice = eligible.subList(i, Math.min(i + basketsPerChunk, eligible.size()));
            persistChunk(runId, chunkNo, slice);
            chunks.add(new Chunk(runId, chunkNo, new ArrayList<>(slice)));
            chunkNo++;
        }
        controlJdbc.update(
                "UPDATE archive_run SET baskets_selected = ? WHERE run_id = ?", eligible.size(), runId);
        log.info("Built worklist for run {}: {} eligible basket(s) in {} chunk(s)", runId, eligible.size(), chunks.size());
        return chunks;
    }

    private void persistChunk(long runId, int chunkNo, List<Long> basketKeys) {
        controlJdbc.batchUpdate(
                "INSERT INTO archive_worklist (run_id, chunk_no, basket_key, status) VALUES (?, ?, ?, 'PENDING')",
                basketKeys.stream().map(k -> new Object[] {runId, chunkNo, k}).toList());
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
