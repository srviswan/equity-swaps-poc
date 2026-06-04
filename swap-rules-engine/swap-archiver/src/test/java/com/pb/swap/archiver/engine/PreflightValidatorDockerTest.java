package com.pb.swap.archiver.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import com.pb.swap.archiver.auth.ConnectionFactory;
import com.pb.swap.archiver.config.ArchiverProperties;
import com.pb.swap.archiver.config.ArchiverProperties.Credential;
import com.pb.swap.archiver.config.ArchiverProperties.Endpoint;
import com.pb.swap.archiver.config.ArchiverProperties.Env;
import com.pb.swap.archiver.engine.PreflightReport.Status;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testcontainers.DockerClientFactory;
import org.testcontainers.containers.MSSQLServerContainer;

/**
 * End-to-end pre-flight against a real SQL Server (Testcontainers). Proves the Flyway control
 * migration applies, pre-flight passes, and the generic-join supporting-index safeguard works.
 * Skipped automatically when Docker is unavailable.
 */
class PreflightValidatorDockerTest {

    private static MSSQLServerContainer<?> mssql;

    @BeforeAll
    static void startContainer() {
        assumeTrue(
                DockerClientFactory.instance().isDockerAvailable(), "Docker not available; skipping");
        mssql =
                new MSSQLServerContainer<>("mcr.microsoft.com/mssql/server:2022-latest").acceptLicense();
        mssql.start();
        createDatabases();
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

    @Test
    void migrationAppliesAndPreflightPasses() {
        PreflightReport report = newValidator().validate();
        assertTrue(report.ok(), () -> "pre-flight should pass:\n" + report.render());
        assertTrue(hasStatus(report, "source.connectivity", Status.PASS), report::render);
        assertTrue(hasStatus(report, "control.config", Status.PASS), report::render);
    }

    @Test
    void supportingIndexCheckPassesWithIndexAndFailsWithout() {
        exec("dw", "IF OBJECT_ID('dbo.Positions') IS NULL CREATE TABLE dbo.Positions"
                + " (swap_key INT NOT NULL, basket_key INT NULL, val INT NULL)");
        exec("dw", "IF INDEXPROPERTY(OBJECT_ID('dbo.Positions'),'ix_pos_swap','IndexID') IS NULL"
                + " CREATE INDEX ix_pos_swap ON dbo.Positions (swap_key)");
        exec("dw", "IF OBJECT_ID('dbo.PositionsNoIdx') IS NULL CREATE TABLE dbo.PositionsNoIdx"
                + " (swap_key INT NOT NULL, val INT NULL)");

        JdbcTemplate control = controlJdbc();
        control.update(
                "IF NOT EXISTS (SELECT 1 FROM archive_job WHERE job_name='basket-archive')"
                        + " INSERT INTO archive_job (job_name, topology) VALUES ('basket-archive','SAME_DB')");
        control.update("DELETE FROM archive_table WHERE job_name='basket-archive'");
        insertTableConfig(control, "Positions", "swap_key");
        insertTableConfig(control, "PositionsNoIdx", "swap_key");

        try {
            PreflightReport report = newValidator().validate();
            assertTrue(
                    hasStatus(report, "source.index(dbo.Positions)", Status.PASS),
                    () -> "indexed table should pass:\n" + report.render());
            assertTrue(
                    hasStatus(report, "source.index(dbo.PositionsNoIdx)", Status.FAIL),
                    () -> "heap table should fail the index safeguard:\n" + report.render());
        } finally {
            control.update("DELETE FROM archive_table WHERE job_name='basket-archive'");
            exec("dw", "DROP TABLE IF EXISTS dbo.Positions");
            exec("dw", "DROP TABLE IF EXISTS dbo.PositionsNoIdx");
        }
    }

    private static void insertTableConfig(JdbcTemplate control, String table, String joinColumns) {
        control.update(
                "INSERT INTO archive_table"
                    + " (job_name, source_schema, source_table, target_schema, target_table,"
                    + " dependency_level, join_columns, copy_strategy)"
                    + " VALUES ('basket-archive','dbo',?,'dbo',?,0,?, 'SAME_DB')",
                table,
                table,
                joinColumns);
    }

    @Test
    void breakGlassSignalIsReadFromControlTable() {
        JdbcTemplate control = controlJdbc();
        control.update(
                "IF NOT EXISTS (SELECT 1 FROM archive_job WHERE job_name='basket-archive')"
                        + " INSERT INTO archive_job (job_name, topology) VALUES ('basket-archive','SAME_DB')");
        StopController stop = new StopController(control, props());
        try {
            control.update(
                    "UPDATE archive_job SET run_signal='STOP' WHERE job_name='basket-archive'");
            assertEquals(StopController.Signal.STOP, stop.current());
            assertTrue(stop.shouldHalt());
        } finally {
            control.update(
                    "UPDATE archive_job SET run_signal='RUN' WHERE job_name='basket-archive'");
        }
        assertEquals(StopController.Signal.RUN, stop.current());
    }

    private static PreflightValidator newValidator() {
        ArchiverProperties props = props();
        return new PreflightValidator(new ConnectionFactory(props), props, controlJdbc());
    }

    private static ArchiverProperties props() {
        return new ArchiverProperties(
                "basket-archive", "DRY_RUN", null, null, sqlEndpoint("dw"), sqlEndpoint("archive"), null, null);
    }

    private static boolean hasStatus(PreflightReport report, String name, Status status) {
        return report.checks().stream()
                .anyMatch(c -> c.name().equals(name) && c.status() == status);
    }

    private static JdbcTemplate controlJdbc() {
        return new JdbcTemplate(
                new DriverManagerDataSource(
                        url("archive_control"), mssql.getUsername(), mssql.getPassword()));
    }

    private static void createDatabases() {
        for (String db : new String[] {"archive_control", "dw", "archive"}) {
            exec("master", "IF DB_ID('" + db + "') IS NULL CREATE DATABASE [" + db + "]");
        }
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
                url(db),
                "sql",
                new Credential("env", null, null, new Env(mssql.getUsername(), mssql.getPassword())));
    }
}
