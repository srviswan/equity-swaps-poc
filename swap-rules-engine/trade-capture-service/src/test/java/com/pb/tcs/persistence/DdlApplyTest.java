package com.pb.tcs.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.DockerClientFactory;
import org.testcontainers.containers.MSSQLServerContainer;

/**
 * F0 exit criterion: "DDL applies cleanly" — applies V001 to a real SQL Server and verifies the
 * contract behaviors a developer depends on (idempotency constraint, partition infra). Skips when
 * Docker is unavailable.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DdlApplyTest {

    private static final List<String> F0_TABLES =
            List.of(
                    "ingestion_record",
                    "enriched_allocation",
                    "audit_reject",
                    "repair_quarantine",
                    "version_gap_hold",
                    "dispatch_record",
                    "business_ack",
                    "cross_ref");

    private MSSQLServerContainer<?> mssql;
    private Connection connection;

    @BeforeAll
    void applyDdl() throws Exception {
        assumeTrue(dockerAvailable(), "Docker unavailable — skipping DDL apply test");
        mssql =
                new MSSQLServerContainer<>(
                                "mcr.microsoft.com/mssql/server:2022-latest")
                        .acceptLicense();
        mssql.start();
        connection =
                DriverManager.getConnection(
                        mssql.getJdbcUrl(), mssql.getUsername(), mssql.getPassword());
        for (String batch : ddlBatches()) {
            try (Statement stmt = connection.createStatement()) {
                stmt.execute(batch);
            }
        }
    }

    @AfterAll
    void tearDown() throws Exception {
        if (connection != null) {
            connection.close();
        }
        if (mssql != null) {
            mssql.stop();
        }
    }

    @Test
    void allF0ContractTablesExist() throws Exception {
        try (PreparedStatement ps =
                connection.prepareStatement(
                        "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES "
                                + "WHERE TABLE_SCHEMA='dbo' AND TABLE_NAME=?")) {
            for (String table : F0_TABLES) {
                ps.setString(1, table);
                try (ResultSet rs = ps.executeQuery()) {
                    rs.next();
                    assertThat(rs.getInt(1)).as("table %s", table).isEqualTo(1);
                }
            }
        }
    }

    @Test
    void monthlyPartitionInfrastructureExists() throws Exception {
        try (Statement stmt = connection.createStatement();
                ResultSet rs =
                        stmt.executeQuery(
                                "SELECT COUNT(*) FROM sys.partition_functions "
                                        + "WHERE name='pf_trade_month'")) {
            rs.next();
            assertThat(rs.getInt(1)).isEqualTo(1);
        }
    }

    @Test
    void idempotencyConstraintRejectsDuplicateBlockAllocationVersion() throws Exception {
        insertIngestion("BLK-DUP", "ALL-1", 1);
        assertThatThrownBy(() -> insertIngestion("BLK-DUP", "ALL-1", 1))
                .isInstanceOf(SQLException.class)
                .hasMessageContaining("uq_idem");
        insertIngestion("BLK-DUP", "ALL-1", 2); // next version is fine
    }

    @Test
    void versionGapHoldRejectsDuplicateHeldVersion() throws Exception {
        insertHold("BLK-H", "ALL-9", 5);
        assertThatThrownBy(() -> insertHold("BLK-H", "ALL-9", 5))
                .isInstanceOf(SQLException.class)
                .hasMessageContaining("uq_hold");
    }

    private void insertIngestion(String blockId, String allocationId, int version)
            throws SQLException {
        try (PreparedStatement ps =
                connection.prepareStatement(
                        "INSERT INTO dbo.ingestion_record (block_id, allocation_id, version,"
                            + " gcam_message_id, allocation_type, source_system,"
                            + " sequence_key_hash, book, account_id, security_id, trade_date,"
                            + " status, raw_proto, correlation_id) VALUES"
                            + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
            ps.setString(1, blockId);
            ps.setString(2, allocationId);
            ps.setInt(3, version);
            ps.setString(4, "GCAM-" + blockId + "-" + version);
            ps.setString(5, "SWAP");
            ps.setString(6, "GCAM");
            ps.setLong(7, 42L);
            ps.setString(8, "EQ_US_HY");
            ps.setString(9, "CLI-9");
            ps.setString(10, "SEC-AAPL");
            ps.setDate(11, java.sql.Date.valueOf("2026-06-10"));
            ps.setString(12, "RECEIVED");
            ps.setBytes(13, new byte[] {1});
            ps.setString(14, blockId + "/" + allocationId + "/" + version);
            ps.executeUpdate();
        }
    }

    private void insertHold(String blockId, String allocationId, int heldVersion)
            throws SQLException {
        try (PreparedStatement ps =
                connection.prepareStatement(
                        "INSERT INTO dbo.version_gap_hold (block_id, allocation_id,"
                                + " held_version, expected_version, book, deadline_at,"
                                + " raw_proto) VALUES (?,?,?,?,?,SYSUTCDATETIME(),?)")) {
            ps.setString(1, blockId);
            ps.setString(2, allocationId);
            ps.setInt(3, heldVersion);
            ps.setInt(4, heldVersion - 1);
            ps.setString(5, "EQ_US_HY");
            ps.setBytes(6, new byte[] {1});
            ps.executeUpdate();
        }
    }

    private static List<String> ddlBatches() throws Exception {
        String script;
        try (var in =
                DdlApplyTest.class
                        .getClassLoader()
                        .getResourceAsStream("db/migration/V001__tcs_f0_schema.sql")) {
            assertThat(in).as("V001 script on classpath").isNotNull();
            script = new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
        List<String> batches = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        for (String line : script.split("\n")) {
            if (line.trim().equalsIgnoreCase("GO")) {
                if (!current.toString().isBlank()) {
                    batches.add(current.toString());
                }
                current.setLength(0);
            } else {
                current.append(line).append('\n');
            }
        }
        if (!current.toString().isBlank()) {
            batches.add(current.toString());
        }
        return batches;
    }

    private static boolean dockerAvailable() {
        try {
            return DockerClientFactory.instance().isDockerAvailable();
        } catch (Throwable t) {
            return false;
        }
    }
}
