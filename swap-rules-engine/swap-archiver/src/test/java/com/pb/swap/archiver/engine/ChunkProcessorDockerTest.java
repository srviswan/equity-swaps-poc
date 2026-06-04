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
import com.pb.swap.archiver.copy.SameDbCopyStrategy;
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

        JdbcTemplate control = controlJdbc();
        control.update("DELETE FROM archive_chunk_log");
        control.update("DELETE FROM archive_worklist");
        control.update("DELETE FROM archive_run");
        control.update("DELETE FROM archive_window");
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
                        List.<CopyStrategy>of(new SameDbCopyStrategy()), connectionFactory(), props(), stop, control);

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
                control);
    }

    private static ConnectionFactory connectionFactory() {
        return new ConnectionFactory(props());
    }

    private static ArchiverProperties props() {
        // SAME_DB: source and archive table both live in dw; target endpoint unused by the strategy.
        return new ArchiverProperties(JOB, "ARCHIVE", null, null, sqlEndpoint("dw"), sqlEndpoint("dw"), null, null);
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
