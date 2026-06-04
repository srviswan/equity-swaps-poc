package com.pb.swap.archiver.engine;

import com.pb.swap.archiver.auth.ConnectionFactory;
import com.pb.swap.archiver.config.ArchiverProperties;
import com.pb.swap.archiver.copy.CopyStrategy;
import com.pb.swap.archiver.copy.CopyStrategy.MoveContext;
import com.pb.swap.archiver.copy.CopyStrategy.MoveResult;
import com.pb.swap.archiver.copy.CopyStrategy.TableConfig;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Processes one chunk across all in-scope tables in FK order (children → parents for delete),
 * driving each table's topology-specific {@link CopyStrategy} and checkpointing every step to
 * {@code archive_chunk_log} for idempotent restart: a table already {@code DONE} for the chunk is
 * skipped, and a failure marks it {@code FAILED} (rolled back) so a rerun retries cleanly.
 */
@Component
public class ChunkProcessor {

    private static final Logger log = LoggerFactory.getLogger(ChunkProcessor.class);

    private final Map<String, CopyStrategy> strategiesByTopology;
    private final ConnectionFactory connections;
    private final ArchiverProperties props;
    private final StopController stop;
    private final JdbcTemplate controlJdbc;

    public ChunkProcessor(
            List<CopyStrategy> strategies,
            ConnectionFactory connections,
            ArchiverProperties props,
            StopController stop,
            JdbcTemplate controlJdbc) {
        this.strategiesByTopology =
                strategies.stream().collect(Collectors.toMap(CopyStrategy::topology, Function.identity()));
        this.connections = connections;
        this.props = props;
        this.stop = stop;
        this.controlJdbc = controlJdbc;
    }

    /** Rows copied/deleted while processing one chunk across all its tables. */
    public record ChunkResult(long rowsCopied, long rowsDeleted) {}

    public ChunkResult process(String jobName, WorklistProvider.Chunk chunk) {
        int periodKey = archivedPeriodKey();
        long copied = 0;
        long deleted = 0;
        for (TableConfig table : loadTables(jobName)) {
            String tableName = table.sourceName();
            String state = stateOf(chunk.runId(), chunk.chunkNo(), tableName);
            if ("DONE".equals(state)) {
                log.debug("chunk {} table {} already DONE; skipping", chunk.chunkNo(), tableName);
                continue;
            }
            checkpointStart(chunk.runId(), chunk.chunkNo(), tableName, state);
            long started = System.currentTimeMillis();
            try {
                CopyStrategy strategy = strategyFor(table.topology());
                MoveResult result =
                        strategy.move(
                                new MoveContext(
                                        connections,
                                        props,
                                        stop,
                                        table,
                                        chunk.runId(),
                                        chunk.chunkNo(),
                                        periodKey,
                                        chunk.basketKeys(),
                                        state));
                checkpointDone(
                        chunk.runId(),
                        chunk.chunkNo(),
                        tableName,
                        result,
                        System.currentTimeMillis() - started);
                copied += result.rowsCopied();
                deleted += result.rowsDeleted();
            } catch (Exception e) {
                checkpointFailed(chunk.runId(), chunk.chunkNo(), tableName, e);
                throw new IllegalStateException(
                        "chunk " + chunk.chunkNo() + " failed on " + tableName + ": " + e.getMessage(), e);
            }
        }
        return new ChunkResult(copied, deleted);
    }

    private List<TableConfig> loadTables(String jobName) {
        return controlJdbc.query(
                "SELECT source_schema, source_table, target_schema, target_table, join_columns, key_resolution,"
                        + " copy_strategy, dependency_level, checksum_verify FROM archive_table"
                        + " WHERE job_name = ? AND enabled = 1 ORDER BY dependency_level DESC",
                (rs, i) -> {
                    String joinColumns = rs.getString("join_columns");
                    String keyResolution = rs.getString("key_resolution");
                    List<String> cols =
                            Arrays.stream(joinColumns.split(",")).map(String::trim).filter(s -> !s.isEmpty()).toList();
                    if (!"DIRECT".equalsIgnoreCase(keyResolution) || cols.size() != 1) {
                        throw new UnsupportedOperationException(
                                "only DIRECT single-column join is supported so far; got "
                                        + keyResolution + " " + cols + " on " + rs.getString("source_table")
                                        + " (BRIDGE/composite is phase 6)");
                    }
                    return new TableConfig(
                            rs.getString("source_schema"),
                            rs.getString("source_table"),
                            rs.getString("target_schema"),
                            rs.getString("target_table"),
                            cols.get(0),
                            keyResolution,
                            rs.getString("copy_strategy"),
                            rs.getInt("dependency_level"),
                            rs.getBoolean("checksum_verify"));
                },
                jobName);
    }

    /** Last recorded state for this table+chunk, or {@code null} if it has never started. */
    private String stateOf(long runId, int chunkNo, String table) {
        List<String> states =
                controlJdbc.queryForList(
                        "SELECT state FROM archive_chunk_log WHERE run_id = ? AND chunk_no = ? AND source_table = ?",
                        String.class,
                        runId,
                        chunkNo,
                        table);
        return states.isEmpty() ? null : states.get(0);
    }

    /**
     * Mark the table+chunk as started. A {@code COPIED} checkpoint (cross-server: target verified,
     * source not yet deleted) is preserved untouched so its delete-only resume path survives restart;
     * any other state is (re)set to {@code PENDING}.
     */
    private void checkpointStart(long runId, int chunkNo, String table, String state) {
        if (state == null) {
            controlJdbc.update(
                    "INSERT INTO archive_chunk_log (run_id, chunk_no, source_table, state) VALUES (?, ?, ?, 'PENDING')",
                    runId,
                    chunkNo,
                    table);
        } else if (!"COPIED".equals(state)) {
            controlJdbc.update(
                    "UPDATE archive_chunk_log SET state = 'PENDING', error_text = NULL, updated_at_utc = SYSUTCDATETIME()"
                            + " WHERE run_id = ? AND chunk_no = ? AND source_table = ?",
                    runId,
                    chunkNo,
                    table);
        }
    }

    private void checkpointDone(long runId, int chunkNo, String table, MoveResult result, long durationMs) {
        controlJdbc.update(
                "UPDATE archive_chunk_log SET state = 'DONE', rows_copied = ?, rows_deleted = ?,"
                        + " source_checksum = ?, target_checksum = ?, duration_ms = ?, updated_at_utc = SYSUTCDATETIME()"
                        + " WHERE run_id = ? AND chunk_no = ? AND source_table = ?",
                result.rowsCopied(),
                result.rowsDeleted(),
                result.sourceChecksum(),
                result.targetChecksum(),
                durationMs,
                runId,
                chunkNo,
                table);
    }

    private void checkpointFailed(long runId, int chunkNo, String table, Exception e) {
        controlJdbc.update(
                "UPDATE archive_chunk_log SET state = 'FAILED', error_text = ?, retry_count = retry_count + 1,"
                        + " updated_at_utc = SYSUTCDATETIME() WHERE run_id = ? AND chunk_no = ? AND source_table = ?",
                e.getClass().getSimpleName() + ": " + e.getMessage(),
                runId,
                chunkNo,
                table);
    }

    private static int archivedPeriodKey() {
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        return now.getYear() * 100 + now.getMonthValue();
    }

    CopyStrategy strategyFor(String topology) {
        CopyStrategy s = strategiesByTopology.get(topology);
        if (s == null) {
            throw new IllegalArgumentException("No copy strategy for topology: " + topology);
        }
        return s;
    }
}
