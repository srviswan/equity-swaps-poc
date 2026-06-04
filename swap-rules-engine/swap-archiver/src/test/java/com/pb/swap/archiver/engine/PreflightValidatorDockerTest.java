package com.pb.swap.archiver.engine;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import com.pb.swap.archiver.auth.ConnectionFactory;
import com.pb.swap.archiver.config.ArchiverProperties;
import com.pb.swap.archiver.config.ArchiverProperties.Credential;
import com.pb.swap.archiver.config.ArchiverProperties.Endpoint;
import com.pb.swap.archiver.config.ArchiverProperties.Env;
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
 * End-to-end pre-flight against a real SQL Server (Testcontainers). Also proves the Flyway control
 * migration applies cleanly on SQL Server. Skipped automatically when Docker is unavailable.
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
    }

    @AfterAll
    static void stopContainer() {
        if (mssql != null) {
            mssql.stop();
        }
    }

    @Test
    void migrationAppliesAndPreflightPasses() {
        // Flyway creates the archive.* control tables in archive_control on real SQL Server.
        Flyway.configure()
                .dataSource(url("archive_control"), mssql.getUsername(), mssql.getPassword())
                .schemas("dbo")
                .locations("classpath:db/archive")
                .load()
                .migrate();

        ArchiverProperties props =
                new ArchiverProperties(
                        "basket-archive",
                        "DRY_RUN",
                        null,
                        null,
                        sqlEndpoint("dw"),
                        sqlEndpoint("archive"),
                        null,
                        null);

        JdbcTemplate controlJdbc =
                new JdbcTemplate(
                        new DriverManagerDataSource(
                                url("archive_control"), mssql.getUsername(), mssql.getPassword()));

        PreflightValidator validator =
                new PreflightValidator(new ConnectionFactory(props), props, controlJdbc);

        PreflightReport report = validator.validate();

        assertTrue(report.ok(), () -> "pre-flight should pass:\n" + report.render());
        assertTrue(
                report.checks().stream()
                        .anyMatch(
                                c ->
                                        c.name().equals("source.connectivity")
                                                && c.status() == PreflightReport.Status.PASS),
                () -> report.render());
        assertTrue(
                report.checks().stream().anyMatch(c -> c.name().equals("source.recovery_model")),
                () -> report.render());
        assertTrue(
                report.checks().stream()
                        .anyMatch(
                                c ->
                                        c.name().equals("control.config")
                                                && c.status() == PreflightReport.Status.PASS),
                () -> report.render());
    }

    private static void createDatabases() {
        try (Connection c =
                        DriverManager.getConnection(
                                url("master"), mssql.getUsername(), mssql.getPassword());
                Statement st = c.createStatement()) {
            for (String db : new String[] {"archive_control", "dw", "archive"}) {
                st.execute("IF DB_ID('" + db + "') IS NULL CREATE DATABASE [" + db + "]");
            }
        } catch (Exception e) {
            throw new IllegalStateException("failed to create test databases", e);
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
