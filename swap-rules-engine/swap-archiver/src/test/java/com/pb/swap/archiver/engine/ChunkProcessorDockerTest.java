package com.pb.swap.archiver.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import com.pb.swap.archiver.auth.ConnectionFactory;
import com.pb.swap.archiver.config.ArchiverProperties;
import com.pb.swap.archiver.config.ArchiverProperties.Credential;
import com.pb.swap.archiver.config.ArchiverProperties.Endpoint;
import com.pb.swap.archiver.config.ArchiverProperties.Env;
import com.pb.swap.archiver.copy.CopyStrategy;
import com.pb.swap.archiver.copy.CrossDbCopyStrategy;
import com.pb.swap.archiver.copy.CrossServerBulkCopyStrategy;
import com.pb.swap.archiver.copy.SameDbCopyStrategy;
import com.pb.swap.archiver.config.ArchiverProperties.Restore;
import com.pb.swap.archiver.restore.RestoreService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testcontainers.DockerClientFactory;
import org.testcontainers.containers.MSSQLServerContainer;

/**
 * End-to-end phase-2 SAME_DB archive against a real SQL Server (Testcontainers): copy eligible
 * baskets into the archive table, delete them from source in one transaction, mark baskets
 * archived, and prove restart idempotency (a second run does nothing) plus break-glass halt.
 */
class ChunkProcessorDockerTest {

    private static final String JOB = "basket-archive";
    private static MSSQLServerContainer<?> mssql;

    @BeforeAll
    static void startContainer() {
        assumeTrue(DockerClientFactory.instance().isDockerAvailable(), "Docker not available; skipping");
        mssql = new MSSQLServerContainer<>("mcr.microsoft.com/mssql/server:2022-latest").acceptLicense();
        mssql.start();
        exec("master", "IF DB_ID('archive_control') IS NULL CREATE DATABASE [archive_control]");
        exec("master", "IF DB_ID('dw') IS NULL CREATE DATABASE [dw]");
        exec("master", "IF DB_ID('archive') IS NULL CREATE DATABASE [archive]");
        exec("master", "IF DB_ID('archive_investigation') IS NULL CREATE DATABASE [archive_investigation]");
        Flyway.configure()
                .dataSource(url("archive_control"), mssql.getUsername(), mssql.getPassword())
                .schemas("dbo")
                .locations("classpath:db/archive")
                .load()
                .migrate();
    }

    @AfterAll
    static void stopContainer() {
        if (mssql != null) {
            mssql.stop();
        }
    }

    @BeforeEach
    void seed() {
        // Source + archive tables both in dw (SAME_DB). basket_key is the DIRECT join key.
        exec("dw", "DROP TABLE IF EXISTS dbo.Trades");
        exec("dw", "DROP TABLE IF EXISTS dbo.Trades_Archive");
        exec("dw", "CREATE TABLE dbo.Trades (trade_id INT NOT NULL PRIMARY KEY, basket_key BIGINT NOT NULL, amount INT)");
        exec("dw", "CREATE INDEX ix_trades_basket ON dbo.Trades (basket_key)");
        exec(
                "dw",
                "CREATE TABLE dbo.Trades_Archive (trade_id INT NOT NULL, basket_key BIGINT NOT NULL, amount INT,"
                        + " archive_batch_id BIGINT, archived_at_utc DATETIME2, archived_period_key INT)");
        exec("dw", "INSERT INTO dbo.Trades VALUES (1,100,10),(2,100,20),(3,101,30),(4,200,40)");

        // Archive-side copy of the target table in a separate DB, for CROSS_DB / CROSS_SERVER tests.
        exec("archive", "DROP TABLE IF EXISTS dbo.Trades_Archive");
        exec(
                "archive",
                "CREATE TABLE dbo.Trades_Archive (trade_id INT NOT NULL, basket_key BIGINT NOT NULL, amount INT,"
                        + " archive_batch_id BIGINT, archived_at_utc DATETIME2, archived_period_key INT)");

        // Fresh investigation table per test so restore round-trips start clean.
        exec("archive_investigation", "DROP TABLE IF EXISTS dbo.Trades_Archive");

        JdbcTemplate control = controlJdbc();
        control.update("DELETE FROM archive_chunk_log");
        control.update("DELETE FROM archive_worklist");
        control.update("DELETE FROM archive_restore_log");
        control.update("DELETE FROM archive_run");
        control.update("DELETE FROM archive_window");
        control.update("DELETE FROM archive_index_state");
        control.update("DELETE FROM archive_table");
        control.update("DELETE FROM basket_archive_state");
        control.update("DELETE FROM archive_job");
        control.update(
                "INSERT INTO archive_job (job_name, topology, retention_months) VALUES (?, 'SAME_DB', 13)", JOB);
        control.update(
                "INSERT INTO archive_table (job_name, source_schema, source_table, target_schema, target_table,"
                        + " dependency_level, join_columns, key_resolution, copy_strategy)"
                        + " VALUES (?, 'dbo','Trades','dbo','Trades_Archive', 0, 'basket_key', 'DIRECT', 'SAME_DB')",
                JOB);
        // Baskets 100 & 101 terminated long ago (eligible); 200 still active.
        control.update(
                "INSERT INTO basket_archive_state (basket_key, termination_date, status) VALUES"
                        + " (100, '2020-01-01', 'TERMINATED'), (101, '2020-02-01', 'TERMINATED'), (200, NULL, 'ACTIVE')");
    }

    @Test
    void archivesEligibleBasketsAndIsIdempotentOnRestart() {
        JdbcTemplate control = controlJdbc();
        WorklistProvider worklist = new WorklistProvider(control);
        ChunkProcessor processor = newProcessor(control);

        long copied = runOnce(worklist, processor, control);
        assertEquals(3, copied, "3 trades belong to eligible baskets 100/101");

        assertEquals(3, count("dw", "SELECT COUNT(*) FROM dbo.Trades_Archive"), "archived rows");
        assertEquals(1, count("dw", "SELECT COUNT(*) FROM dbo.Trades"), "only basket 200 remains in source");
        assertEquals(
                0,
                count("dw", "SELECT COUNT(*) FROM dbo.Trades_Archive WHERE archive_batch_id IS NULL"),
                "lineage batch id populated");
        assertEquals(
                2,
                count("archive_control", "SELECT COUNT(*) FROM basket_archive_state WHERE archived = 1"),
                "eligible baskets flagged archived");
        assertEquals(
                1, count("archive_control", "SELECT COUNT(*) FROM archive_run WHERE status = 'DONE'"), "run done");
        assertEquals(
                0,
                count(
                        "archive_control",
                        "SELECT COUNT(*) FROM archive_chunk_log WHERE state = 'DONE'"
                                + " AND (source_checksum IS NULL OR target_checksum IS NULL)"),
                "checksums recorded for verified copy");
        assertEquals(
                0,
                count(
                        "archive_control",
                        "SELECT COUNT(*) FROM archive_chunk_log WHERE source_checksum <> target_checksum"),
                "source and target checksums match");

        // Restart: nothing eligible now → a new run finds zero rows, no duplicates.
        long copiedAgain = runOnce(worklist, processor, control);
        assertEquals(0, copiedAgain, "restart archives nothing");
        assertEquals(3, count("dw", "SELECT COUNT(*) FROM dbo.Trades_Archive"), "no duplicate rows");
    }

    @Test
    void reclaimsInProgressChunkOnRestart() {
        JdbcTemplate control = controlJdbc();
        WorklistProvider worklist = new WorklistProvider(control);
        ChunkProcessor processor = newProcessor(control);

        long runId = worklist.openRun(JOB, "ARCHIVE", LocalDate.now());
        worklist.buildWorklist(runId, JOB, LocalDate.now());

        // Claim one chunk (1 basket) but "crash" before processing it.
        WorklistProvider.Chunk claimed = worklist.nextChunk(runId, 1);
        assertEquals(1, claimed.basketKeys().size(), "1 basket per chunk");

        // Restart: same RUNNING run, and nextChunk reclaims the IN_PROGRESS chunk before any new work.
        long resumed = worklist.openRun(JOB, "ARCHIVE", LocalDate.now());
        assertEquals(runId, resumed, "resumes the in-progress run");
        WorklistProvider.Chunk reclaimed = worklist.nextChunk(resumed, 1);
        assertEquals(claimed.chunkNo(), reclaimed.chunkNo(), "reclaims the same chunk");
        assertEquals(claimed.basketKeys(), reclaimed.basketKeys(), "same baskets");

        processor.process(JOB, reclaimed);
        worklist.markChunkArchived(reclaimed);
        WorklistProvider.Chunk next = worklist.nextChunk(resumed, 1);
        processor.process(JOB, next);
        worklist.markChunkArchived(next);
        assertNull(worklist.nextChunk(resumed, 1), "no work left");

        assertEquals(3, count("dw", "SELECT COUNT(*) FROM dbo.Trades_Archive"), "all eligible rows archived");
        assertEquals(1, count("dw", "SELECT COUNT(*) FROM dbo.Trades"), "only basket 200 remains");
    }

    @Test
    void breakGlassHaltsBeforeNextChunk() {
        JdbcTemplate control = controlJdbc();
        WorklistProvider worklist = new WorklistProvider(control);
        StopController stop = new StopController(control, props());
        ChunkProcessor processor =
                new ChunkProcessor(
                        List.<CopyStrategy>of(new SameDbCopyStrategy()),
                        connectionFactory(),
                        props(),
                        stop,
                        new LogAndAgMonitor(connectionFactory(), props()),
                        control);

        long runId = worklist.openRun(JOB, "ARCHIVE", LocalDate.now());
        worklist.buildWorklist(runId, JOB, LocalDate.now());

        long copied = 0;
        boolean halted = false;
        while (true) {
            if (stop.shouldHalt()) {
                halted = true;
                break;
            }
            WorklistProvider.Chunk chunk = worklist.nextChunk(runId, 1);
            if (chunk == null) {
                break;
            }
            copied += processor.process(JOB, chunk).rowsCopied();
            worklist.markChunkArchived(chunk);
            stop.requestLocalStop("drill after first chunk"); // trip the brake for the next boundary
        }

        assertTrue(halted, "should halt before processing all chunks");
        assertTrue(
                count("dw", "SELECT COUNT(*) FROM dbo.Trades") > 1,
                "halt leaves some eligible rows un-archived (resumable)");
        assertTrue(copied > 0, "first chunk still committed before halt");
    }

    @Test
    void schedulingWindowGatesChunks() {
        JdbcTemplate control = controlJdbc();
        WindowScheduler scheduler = new WindowScheduler(control, props());

        // No windows configured → run unrestricted.
        assertTrue(scheduler.canStartChunk(LocalDateTime.of(2026, 6, 6, 3, 0), 1000).allowed());

        // Saturday (2026-06-06) window 01:00–05:00 (SQL DATEPART weekday: Sat = 7).
        control.update(
                "INSERT INTO archive_window (job_name, day_of_week, start_time, end_time) VALUES (?, 7, '01:00', '05:00')",
                JOB);
        assertTrue(scheduler.canStartChunk(LocalDateTime.of(2026, 6, 6, 3, 0), 1000).allowed(), "inside Sat window");
        assertFalse(scheduler.canStartChunk(LocalDateTime.of(2026, 6, 6, 6, 0), 1000).allowed(), "after window end");
        assertFalse(scheduler.canStartChunk(LocalDateTime.of(2026, 6, 5, 3, 0), 1000).allowed(), "Friday has no window");
        assertFalse(
                scheduler.canStartChunk(LocalDateTime.of(2026, 6, 6, 4, 59, 30), 60_000).allowed(),
                "estimated chunk exceeds remaining window");
    }

    @Test
    void schedulingWindowHandlesOvernightWindow() {
        JdbcTemplate control = controlJdbc();
        WindowScheduler scheduler = new WindowScheduler(control, props());
        // Saturday 22:00 → 04:00 (crosses midnight): the after-midnight segment belongs to Saturday.
        control.update(
                "INSERT INTO archive_window (job_name, day_of_week, start_time, end_time) VALUES (?, 7, '22:00', '04:00')",
                JOB);
        assertTrue(
                scheduler.canStartChunk(LocalDateTime.of(2026, 6, 6, 23, 0), 1000).allowed(),
                "Saturday night, before midnight");
        assertTrue(
                scheduler.canStartChunk(LocalDateTime.of(2026, 6, 7, 2, 0), 1000).allowed(),
                "spills into Sunday morning via Saturday's overnight window");
        assertFalse(
                scheduler.canStartChunk(LocalDateTime.of(2026, 6, 7, 5, 0), 1000).allowed(),
                "after the overnight window closes");
        assertFalse(
                scheduler.canStartChunk(LocalDateTime.of(2026, 6, 6, 21, 0), 1000).allowed(),
                "before the window opens");
    }

    @Test
    void schedulingWindowHonorsMaxDuration() {
        JdbcTemplate control = controlJdbc();
        WindowScheduler scheduler = new WindowScheduler(control, props());
        // Sunday 01:00–08:00 but capped to 120 minutes → effective close 03:00.
        control.update(
                "INSERT INTO archive_window (job_name, day_of_week, start_time, end_time, max_duration_mins)"
                        + " VALUES (?, 1, '01:00', '08:00', 120)",
                JOB);
        assertTrue(
                scheduler.canStartChunk(LocalDateTime.of(2026, 6, 7, 2, 0), 1000).allowed(),
                "within the capped window");
        assertFalse(
                scheduler.canStartChunk(LocalDateTime.of(2026, 6, 7, 4, 0), 1000).allowed(),
                "past max_duration_mins cap (01:00 + 120m = 03:00) even though before end_time");
    }

    @Test
    void chunkLogRecordsPressureReadings() {
        JdbcTemplate control = controlJdbc();
        runOnce(new WorklistProvider(control), newProcessor(control), control);
        assertEquals(
                0,
                count(
                        "archive_control",
                        "SELECT COUNT(*) FROM archive_chunk_log WHERE state = 'DONE' AND log_used_pct IS NULL"),
                "per-chunk log-space reading recorded on the source (sa can read the DMV)");
        assertEquals(
                0,
                count(
                        "archive_control",
                        "SELECT COUNT(*) FROM archive_chunk_log WHERE state = 'DONE' AND ag_redo_queue_kb IS NULL"),
                "per-chunk AG redo-queue reading recorded (0 on a non-AG instance)");
    }

    @Test
    void indexManagerDisablesThenRebuildsTargetIndexes() {
        JdbcTemplate control = controlJdbc();
        exec("dw", "CREATE INDEX ix_arch_basket ON dbo.Trades_Archive (basket_key)");
        control.update(
                "UPDATE archive_table SET disable_target_indexes = 1 WHERE job_name = ? AND source_table = 'Trades'",
                JOB);
        IndexManager indexManager = new IndexManager(control, connectionFactory(), props());

        indexManager.disableForJob(JOB);
        assertEquals(
                1,
                count(
                        "dw",
                        "SELECT COUNT(*) FROM sys.indexes WHERE object_id = OBJECT_ID('dbo.Trades_Archive')"
                                + " AND name = 'ix_arch_basket' AND is_disabled = 1"),
                "non-clustered index disabled before load");
        assertEquals(
                1,
                count("archive_control", "SELECT COUNT(*) FROM archive_index_state WHERE index_name = 'ix_arch_basket'"),
                "disabled index checkpointed");

        indexManager.rebuildForJob(JOB);
        assertEquals(
                0,
                count(
                        "dw",
                        "SELECT COUNT(*) FROM sys.indexes WHERE object_id = OBJECT_ID('dbo.Trades_Archive')"
                                + " AND name = 'ix_arch_basket' AND is_disabled = 1"),
                "index rebuilt (re-enabled)");
        assertEquals(
                0,
                count("archive_control", "SELECT COUNT(*) FROM archive_index_state"),
                "index-state checkpoint cleared after rebuild");
    }

    @Test
    void crossDbMovesAcrossDatabasesOnSameInstance() {
        JdbcTemplate control = controlJdbc();
        control.update(
                "UPDATE archive_table SET copy_strategy = 'CROSS_DB' WHERE job_name = ? AND source_table = 'Trades'",
                JOB);
        ArchiverProperties cross = props("dw", "archive");
        WorklistProvider worklist = new WorklistProvider(control);
        ChunkProcessor processor =
                new ChunkProcessor(
                        List.<CopyStrategy>of(new CrossDbCopyStrategy()),
                        new ConnectionFactory(cross),
                        cross,
                        new StopController(control, cross),
                        new LogAndAgMonitor(new ConnectionFactory(cross), cross),
                        control);

        long copied = runOnce(worklist, processor, control);
        assertEquals(3, copied, "3 trades moved to the archive DB");
        assertEquals(3, count("archive", "SELECT COUNT(*) FROM dbo.Trades_Archive"), "rows landed in archive DB");
        assertEquals(1, count("dw", "SELECT COUNT(*) FROM dbo.Trades"), "deleted from source DB");
        assertEquals(
                0,
                count("archive", "SELECT COUNT(*) FROM dbo.Trades_Archive WHERE archive_batch_id IS NULL"),
                "lineage populated cross-DB");
    }

    @Test
    void crossServerCopiesVerifiesThenDeletes() {
        JdbcTemplate control = controlJdbc();
        control.update(
                "UPDATE archive_table SET copy_strategy = 'CROSS_SERVER' WHERE job_name = ? AND source_table = 'Trades'",
                JOB);
        ArchiverProperties cross = props("dw", "archive");
        WorklistProvider worklist = new WorklistProvider(control);
        ChunkProcessor processor =
                new ChunkProcessor(
                        List.<CopyStrategy>of(new CrossServerBulkCopyStrategy(control)),
                        new ConnectionFactory(cross),
                        cross,
                        new StopController(control, cross),
                        new LogAndAgMonitor(new ConnectionFactory(cross), cross),
                        control);

        long copied = runOnce(worklist, processor, control);
        assertEquals(3, copied, "3 trades bulk-copied to the archive server");
        assertEquals(3, count("archive", "SELECT COUNT(*) FROM dbo.Trades_Archive"), "rows streamed to archive");
        assertEquals(1, count("dw", "SELECT COUNT(*) FROM dbo.Trades"), "source deleted only after verify");
        assertEquals(
                0,
                count(
                        "archive_control",
                        "SELECT COUNT(*) FROM archive_chunk_log WHERE state = 'DONE'"
                                + " AND (source_checksum IS NULL OR target_checksum IS NULL)"),
                "checksums recorded for cross-server copy");
        assertEquals(
                0,
                count(
                        "archive_control",
                        "SELECT COUNT(*) FROM archive_chunk_log WHERE source_checksum <> target_checksum"),
                "cross-server source/target checksums match");
    }

    @Test
    void crossServerResumesFromCopiedWithoutDuplicating() {
        JdbcTemplate control = controlJdbc();
        control.update(
                "UPDATE archive_table SET copy_strategy = 'CROSS_SERVER' WHERE job_name = ? AND source_table = 'Trades'",
                JOB);
        ArchiverProperties cross = props("dw", "archive");
        WorklistProvider worklist = new WorklistProvider(control);
        ChunkProcessor processor =
                new ChunkProcessor(
                        List.<CopyStrategy>of(new CrossServerBulkCopyStrategy(control)),
                        new ConnectionFactory(cross),
                        cross,
                        new StopController(control, cross),
                        new LogAndAgMonitor(new ConnectionFactory(cross), cross),
                        control);

        long runId = worklist.openRun(JOB, "ARCHIVE", LocalDate.now());
        worklist.buildWorklist(runId, JOB, LocalDate.now());
        WorklistProvider.Chunk chunk = worklist.nextChunk(runId, 1000);

        // Simulate a crash after copy+verify but before the source delete: the target already holds
        // the verified rows (with this run's batch id) and the checkpoint is COPIED.
        exec(
                "archive",
                "INSERT INTO dbo.Trades_Archive (trade_id, basket_key, amount, archive_batch_id)"
                        + " SELECT trade_id, basket_key, amount, " + runId
                        + " FROM dw.dbo.Trades WHERE basket_key IN (100, 101)");
        control.update(
                "INSERT INTO archive_chunk_log (run_id, chunk_no, source_table, state, rows_copied)"
                        + " VALUES (?, ?, 'dbo.Trades', 'COPIED', 3)",
                runId,
                chunk.chunkNo());

        ChunkProcessor.ChunkResult result = processor.process(JOB, chunk);

        assertEquals(3, result.rowsDeleted(), "resume deletes the source rows");
        assertEquals(1, count("dw", "SELECT COUNT(*) FROM dbo.Trades"), "source emptied of eligible baskets");
        assertEquals(
                3,
                count("archive", "SELECT COUNT(*) FROM dbo.Trades_Archive"),
                "target untouched on resume — no duplicate rows");
        assertEquals(
                1,
                count(
                        "archive_control",
                        "SELECT COUNT(*) FROM archive_chunk_log WHERE state = 'DONE' AND source_table = 'dbo.Trades'"),
                "chunk completes after delete-only resume");
    }

    @Test
    void multiTableDirectAndBridgeArchive() {
        JdbcTemplate control = controlJdbc();
        // Parent fact carries the basket key (DIRECT); child fact is keyed by swap_key and resolves
        // eligible baskets through a DimSwap bridge (BRIDGE). Both move the same basket set per chunk.
        exec("dw", "DROP TABLE IF EXISTS dbo.Swaps");
        exec("dw", "DROP TABLE IF EXISTS dbo.Swaps_Archive");
        exec("dw", "DROP TABLE IF EXISTS dbo.Positions");
        exec("dw", "DROP TABLE IF EXISTS dbo.Positions_Archive");
        exec("dw", "DROP TABLE IF EXISTS dbo.DimSwap");
        exec("dw", "CREATE TABLE dbo.Swaps (swap_id INT PRIMARY KEY, basket_key BIGINT NOT NULL, notional INT)");
        exec("dw", "CREATE INDEX ix_swaps_basket ON dbo.Swaps (basket_key)");
        exec(
                "dw",
                "CREATE TABLE dbo.Swaps_Archive (swap_id INT, basket_key BIGINT, notional INT,"
                        + " archive_batch_id BIGINT, archived_at_utc DATETIME2, archived_period_key INT)");
        exec("dw", "CREATE TABLE dbo.Positions (position_id INT PRIMARY KEY, swap_key BIGINT NOT NULL, qty INT)");
        exec("dw", "CREATE INDEX ix_pos_swap ON dbo.Positions (swap_key)");
        exec(
                "dw",
                "CREATE TABLE dbo.Positions_Archive (position_id INT, swap_key BIGINT, qty INT,"
                        + " archive_batch_id BIGINT, archived_at_utc DATETIME2, archived_period_key INT)");
        exec("dw", "CREATE TABLE dbo.DimSwap (swap_key BIGINT PRIMARY KEY, basket_key BIGINT NOT NULL)");
        exec("dw", "CREATE INDEX ix_dimswap_basket ON dbo.DimSwap (basket_key)");
        exec("dw", "INSERT INTO dbo.Swaps VALUES (1,100,10),(2,100,20),(3,101,30),(4,200,40)");
        exec("dw", "INSERT INTO dbo.DimSwap VALUES (1000,100),(1001,100),(1002,101),(1003,200)");
        exec("dw", "INSERT INTO dbo.Positions VALUES (1,1000,5),(2,1001,6),(3,1002,7),(4,1003,8)");

        control.update("DELETE FROM archive_table WHERE job_name = ?", JOB);
        control.update(
                "INSERT INTO archive_table (job_name, source_schema, source_table, target_schema, target_table,"
                        + " dependency_level, join_columns, key_resolution, copy_strategy)"
                        + " VALUES (?, 'dbo','Swaps','dbo','Swaps_Archive', 0, 'basket_key', 'DIRECT', 'SAME_DB')",
                JOB);
        control.update(
                "INSERT INTO archive_table (job_name, source_schema, source_table, target_schema, target_table,"
                        + " dependency_level, join_columns, key_resolution, bridge_table, bridge_basket_column,"
                        + " bridge_join_columns, copy_strategy)"
                        + " VALUES (?, 'dbo','Positions','dbo','Positions_Archive', 1, 'swap_key', 'BRIDGE',"
                        + " 'dbo.DimSwap', 'basket_key', 'swap_key', 'SAME_DB')",
                JOB);

        long copied = runOnce(new WorklistProvider(control), newProcessor(control), control);

        assertEquals(6, copied, "3 swaps (DIRECT) + 3 positions (BRIDGE) for eligible baskets 100/101");
        assertEquals(3, count("dw", "SELECT COUNT(*) FROM dbo.Swaps_Archive"), "parent rows archived");
        assertEquals(1, count("dw", "SELECT COUNT(*) FROM dbo.Swaps WHERE basket_key = 200"), "active basket stays");
        assertEquals(3, count("dw", "SELECT COUNT(*) FROM dbo.Positions_Archive"), "child rows resolved via bridge");
        assertEquals(
                1,
                count("dw", "SELECT COUNT(*) FROM dbo.Positions WHERE swap_key = 1003"),
                "position for active basket's swap stays");
        assertEquals(
                0,
                count("dw", "SELECT COUNT(*) FROM dbo.Positions_Archive WHERE archive_batch_id IS NULL"),
                "bridge-resolved rows carry lineage");
    }

    @Test
    void basketStateRefreshClassifiesFromSourceDimension() {
        JdbcTemplate control = controlJdbc();
        exec("dw", "DROP TABLE IF EXISTS dbo.DimBasket");
        exec(
                "dw",
                "CREATE TABLE dbo.DimBasket (basket_key BIGINT PRIMARY KEY, status VARCHAR(16), termination_date DATE)");
        exec(
                "dw",
                "INSERT INTO dbo.DimBasket VALUES (300,'TERMINATED','2021-01-01'),(301,'TERMINATED',NULL),"
                        + "(302,'ACTIVE',NULL)");
        control.update(
                "UPDATE archive_job SET basket_source_table = 'dbo.DimBasket', basket_key_column = 'basket_key',"
                        + " basket_status_column = 'status', basket_termination_column = 'termination_date',"
                        + " basket_terminated_value = 'TERMINATED' WHERE job_name = ?",
                JOB);
        control.update("DELETE FROM basket_archive_state");

        BasketStateRefresher refresher = new BasketStateRefresher(control, connectionFactory(), props());
        int n = refresher.refresh(JOB);

        assertEquals(3, n, "all DimBasket rows upserted");
        assertEquals(
                "TERMINATED",
                control.queryForObject("SELECT status FROM basket_archive_state WHERE basket_key = 300", String.class),
                "terminated with date");
        assertEquals(
                "NEEDS_REVIEW",
                control.queryForObject("SELECT status FROM basket_archive_state WHERE basket_key = 301", String.class),
                "terminated but undated is quarantined");
        assertEquals(
                "ACTIVE",
                control.queryForObject("SELECT status FROM basket_archive_state WHERE basket_key = 302", String.class),
                "still live");
    }

    @Test
    void restoreRoundTripsArchivedRowsIntoInvestigationDb() {
        JdbcTemplate control = controlJdbc();
        // Archive eligible baskets first; markChunkArchived stamps archive_batch_id = runId.
        runOnce(new WorklistProvider(control), newProcessor(control), control);
        assertEquals(3, count("dw", "SELECT COUNT(*) FROM dbo.Trades_Archive"), "rows archived");

        // Restore by basket key — RestoreService resolves the batch(es) that archived 100/101.
        ArchiverProperties p =
                propsWithRestore("dw", "dw", new Restore("archive_investigation", false, "100,101", null));
        RestoreService restore = new RestoreService(new ConnectionFactory(p), p, control);
        RestoreService.RestoreSummary summary = restore.restore(JOB);

        assertEquals(1, summary.tables(), "one restorable table");
        assertEquals(3, summary.rowsRestored(), "all archived rows for the baskets restored");
        assertEquals(
                3,
                count("archive_investigation", "SELECT COUNT(*) FROM dbo.Trades_Archive"),
                "rows landed in the investigation DB");
        assertEquals(
                1,
                count("archive_control", "SELECT COUNT(*) FROM archive_restore_log WHERE status = 'DONE'"),
                "restore audited");

        // Idempotent: a second restore of the same scope does not duplicate rows.
        restore.restore(JOB);
        assertEquals(
                3,
                count("archive_investigation", "SELECT COUNT(*) FROM dbo.Trades_Archive"),
                "re-running restore is idempotent");
    }

    @Test
    void restoreRefusesToTargetLiveSourceUnlessOverridden() {
        JdbcTemplate control = controlJdbc();
        runOnce(new WorklistProvider(control), newProcessor(control), control);

        // Investigation DB == source DB (dw) with the override off → must refuse.
        ArchiverProperties p = propsWithRestore("dw", "dw", new Restore("dw", false, "100,101", null));
        RestoreService restore = new RestoreService(new ConnectionFactory(p), p, control);
        try {
            restore.restore(JOB);
            org.junit.jupiter.api.Assertions.fail("expected restore-to-source guard to trip");
        } catch (IllegalStateException expected) {
            assertTrue(expected.getMessage().contains("live source"), "guard explains the refusal");
        }
    }

    @Test
    void statsMaintainerRefreshesSourceTablesWhenEnabled() {
        JdbcTemplate control = controlJdbc();
        StatsMaintainer stats = new StatsMaintainer(control, connectionFactory(), props());

        // V003 defaults update_stats_after = 1, one in-scope source table (dbo.Trades).
        assertEquals(1, stats.updateStatsAfterArchive(JOB), "stats refreshed on the one source table");

        control.update("UPDATE archive_job SET update_stats_after = 0 WHERE job_name = ?", JOB);
        assertEquals(0, stats.updateStatsAfterArchive(JOB), "no-op when the flag is off");
    }

    @Test
    void monitorSampleReadsDmvs() {
        LogAndAgMonitor monitor = new LogAndAgMonitor(connectionFactory(), props());
        LogAndAgMonitor.Reading reading = monitor.sample();
        assertTrue(reading.logUsedPct() >= 0, "sa can read log space usage");
        assertEquals(0L, reading.agRedoQueueKb(), "non-AG container reports no redo queue");
        assertFalse(monitor.shouldPause(reading, 70, 5_000_000L), "healthy single-node should not pause");
    }

    private long runOnce(WorklistProvider worklist, ChunkProcessor processor, JdbcTemplate control) {
        long runId = worklist.openRun(JOB, "ARCHIVE", LocalDate.now());
        worklist.buildWorklist(runId, JOB, LocalDate.now());
        long copied = 0;
        WorklistProvider.Chunk chunk;
        while ((chunk = worklist.nextChunk(runId, 1000)) != null) {
            copied += processor.process(JOB, chunk).rowsCopied();
            worklist.markChunkArchived(chunk);
        }
        worklist.completeRun(runId, "DONE", copied, copied, null);
        return copied;
    }

    private ChunkProcessor newProcessor(JdbcTemplate control) {
        return new ChunkProcessor(
                List.<CopyStrategy>of(new SameDbCopyStrategy()),
                connectionFactory(),
                props(),
                new StopController(control, props()),
                new LogAndAgMonitor(connectionFactory(), props()),
                control);
    }

    private static ConnectionFactory connectionFactory() {
        return new ConnectionFactory(props());
    }

    private static ArchiverProperties props() {
        // SAME_DB: source and archive table both live in dw; target endpoint unused by the strategy.
        return props("dw", "dw");
    }

    private static ArchiverProperties props(String srcDb, String tgtDb) {
        return new ArchiverProperties(
                JOB, "ARCHIVE", null, null, sqlEndpoint(srcDb), sqlEndpoint(tgtDb), null, null);
    }

    private static ArchiverProperties propsWithRestore(String srcDb, String tgtDb, Restore restore) {
        return new ArchiverProperties(
                JOB, "RESTORE", null, null, sqlEndpoint(srcDb), sqlEndpoint(tgtDb), restore, null);
    }

    private static long count(String db, String sql) {
        try (Connection c = DriverManager.getConnection(url(db), mssql.getUsername(), mssql.getPassword());
                Statement st = c.createStatement();
                var rs = st.executeQuery(sql)) {
            rs.next();
            return rs.getLong(1);
        } catch (Exception e) {
            throw new IllegalStateException("count failed on " + db + ": " + sql, e);
        }
    }

    private static JdbcTemplate controlJdbc() {
        return new JdbcTemplate(
                new DriverManagerDataSource(url("archive_control"), mssql.getUsername(), mssql.getPassword()));
    }

    private static void exec(String db, String sql) {
        try (Connection c = DriverManager.getConnection(url(db), mssql.getUsername(), mssql.getPassword());
                Statement st = c.createStatement()) {
            st.execute(sql);
        } catch (Exception e) {
            throw new IllegalStateException("failed on " + db + ": " + sql, e);
        }
    }

    private static String url(String db) {
        return "jdbc:sqlserver://"
                + mssql.getHost()
                + ":"
                + mssql.getFirstMappedPort()
                + ";databaseName="
                + db
                + ";encrypt=false;trustServerCertificate=true";
    }

    private static Endpoint sqlEndpoint(String db) {
        return new Endpoint(
                url(db), "sql", new Credential("env", null, null, new Env(mssql.getUsername(), mssql.getPassword())));
    }
}
