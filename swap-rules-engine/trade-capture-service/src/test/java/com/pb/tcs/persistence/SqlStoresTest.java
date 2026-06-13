package com.pb.tcs.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.ingress.IngestionStoreException;
import com.pb.tcs.ingress.VersionGapHoldStore;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.AllocationType;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.DockerClientFactory;
import org.testcontainers.containers.MSSQLServerContainer;

/**
 * JDBC adapters against the real V001 schema (Testcontainers MSSQL). Verifies the F1.4
 * transaction boundaries: enriched persist is atomic (both rows or neither), constraint
 * violations surface as {@link IngestionStoreException}, holds are durable and claimable
 * exactly once.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SqlStoresTest {

    private static final Instant NOW = Instant.parse("2026-06-10T14:00:00Z");

    private MSSQLServerContainer<?> mssql;
    private DataSource dataSource;
    private SqlIngestionStore store;
    private SqlVersionGapHoldStore holds;

    @BeforeAll
    void startAndMigrate() throws Exception {
        assumeTrue(dockerAvailable(), "Docker unavailable — skipping SQL adapter tests");
        mssql =
                new MSSQLServerContainer<>("mcr.microsoft.com/mssql/server:2022-latest")
                        .acceptLicense();
        mssql.start();
        var sqlServerDataSource = new com.microsoft.sqlserver.jdbc.SQLServerDataSource();
        sqlServerDataSource.setURL(mssql.getJdbcUrl());
        sqlServerDataSource.setUser(mssql.getUsername());
        sqlServerDataSource.setPassword(mssql.getPassword());
        dataSource = sqlServerDataSource;
        try (Connection conn = dataSource.getConnection()) {
            for (String batch : ddlBatches()) {
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(batch);
                }
            }
        }
        store = new SqlIngestionStore(dataSource);
        holds = new SqlVersionGapHoldStore(dataSource);
    }

    @AfterAll
    void stop() {
        if (mssql != null) {
            mssql.stop();
        }
    }

    private static TcsIngressMessage envelope(String blockId, String allocId, int version) {
        return TcsIngressMessage.newBuilder()
                .setMessageId("M-" + blockId + "-" + version)
                .setSource(SourceSystem.GCAM)
                .setBook("EQ_US_HY")
                .setAccountId("CLI-9")
                .setSecurityId("SEC-AAPL")
                .setInitiatedBy("SYSTEM")
                .setAllocation(
                        AllocationMessage.newBuilder()
                                .setBlockId(blockId)
                                .setAllocationId(allocId)
                                .setVersion(version)
                                .setGcamMessageId("GCAM-" + blockId + "-" + version)
                                .setType(AllocationType.SWAP)
                                .setBook("EQ_US_HY")
                                .setClientAccount("CLI-9")
                                .setSecurityId("SEC-AAPL")
                                .setTradeDate("2026-06-10")
                                .setQuantity(1000)
                                .setDirection("BUY")
                                .setSchemaVersion(1))
                .build();
    }

    private static EnrichedAllocation enriched(String blockId, String allocId, int version) {
        TcsIngressMessage env = envelope(blockId, allocId, version);
        return new EnrichedAllocation(
                env,
                env.toByteArray(),
                "{\"securityId\":\"SEC-AAPL\"}",
                "{\"clientAccount\":\"CLI-9\"}",
                "{\"book\":\"EQ_US_HY\"}",
                null);
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class IngestionStoreBehavior {

        @Test
        void persistEnrichedWritesBothRowsAndIsIdempotencyVisible() throws Exception {
            store.persistEnriched(enriched("BLK-SQL1", "ALL-1", 1));

            assertThat(store.isEnriched("BLK-SQL1", "ALL-1", 1)).isTrue();
            assertThat(store.isEnriched("BLK-SQL1", "ALL-1", 2)).isFalse();
            assertThat(store.lastEnrichedVersion("BLK-SQL1", "ALL-1")).hasValue(1);
            assertThat(
                            count(
                                    "SELECT COUNT(*) FROM dbo.enriched_allocation ea"
                                        + " JOIN dbo.ingestion_record ir"
                                        + "   ON ir.ingestion_id = ea.ingestion_id"
                                        + " WHERE ir.block_id='BLK-SQL1'"))
                    .isEqualTo(1);
        }

        @Test
        void duplicateVersionRollsBackAtomically() throws Exception {
            store.persistEnriched(enriched("BLK-SQL2", "ALL-1", 1));
            int enrichedRowsBefore = count("SELECT COUNT(*) FROM dbo.enriched_allocation");

            assertThatThrownBy(() -> store.persistEnriched(enriched("BLK-SQL2", "ALL-1", 1)))
                    .isInstanceOf(IngestionStoreException.class)
                    .hasMessageContaining("uq_idem");

            assertThat(count("SELECT COUNT(*) FROM dbo.enriched_allocation"))
                    .isEqualTo(enrichedRowsBefore);
        }

        @Test
        void lastEnrichedVersionEmptyForUnknownAllocation() {
            assertThat(store.lastEnrichedVersion("BLK-NONE", "ALL-NONE")).isEmpty();
        }

        @Test
        void auditRejectPersistsParsedIdentity() throws Exception {
            TcsIngressMessage env = envelope("BLK-AUD", "ALL-1", 7);

            store.auditReject("MANDATORY", "direction is mandatory", 1, env.toByteArray(), env);

            try (Connection conn = dataSource.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs =
                            stmt.executeQuery(
                                    "SELECT stage, reason, attempt, block_id, version,"
                                            + " gcam_message_id FROM dbo.audit_reject"
                                            + " WHERE block_id='BLK-AUD'")) {
                assertThat(rs.next()).isTrue();
                assertThat(rs.getString("stage")).isEqualTo("MANDATORY");
                assertThat(rs.getString("reason")).contains("direction");
                assertThat(rs.getInt("attempt")).isEqualTo(1);
                assertThat(rs.getInt("version")).isEqualTo(7);
                assertThat(rs.getString("gcam_message_id")).isEqualTo("GCAM-BLK-AUD-7");
            }
        }

        @Test
        void auditRejectWithUnparseableBytesStillRecords() throws Exception {
            store.auditReject("STRUCTURAL", "proto parse failure", 1, new byte[] {1, 2, 3}, null);

            assertThat(
                            count(
                                    "SELECT COUNT(*) FROM dbo.audit_reject"
                                            + " WHERE stage='STRUCTURAL'"))
                    .isGreaterThanOrEqualTo(1);
        }

        @Test
        void quarantineExtractsGcamMessageIdFromRawProto() throws Exception {
            TcsIngressMessage env = envelope("BLK-Q", "ALL-1", 3);

            store.quarantine("REFDATA_EXHAUSTED", "security not found: SEC-X", env.toByteArray());

            try (Connection conn = dataSource.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs =
                            stmt.executeQuery(
                                    "SELECT gcam_message_id, category, status"
                                            + " FROM dbo.repair_quarantine"
                                            + " WHERE detail LIKE '%SEC-X%'")) {
                assertThat(rs.next()).isTrue();
                assertThat(rs.getString("gcam_message_id")).isEqualTo("GCAM-BLK-Q-3");
                assertThat(rs.getString("category")).isEqualTo("REFDATA_EXHAUSTED");
                assertThat(rs.getString("status")).isEqualTo("OPEN");
            }
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class HoldStoreBehavior {

        private static VersionGapHoldStore.HoldRow row(String blockId, int version, Instant deadline) {
            return new VersionGapHoldStore.HoldRow(
                    blockId,
                    "ALL-1",
                    version,
                    version - 1,
                    "EQ_US_HY",
                    deadline,
                    envelope(blockId, "ALL-1", version).toByteArray());
        }

        @Test
        void holdsAreDurableAndSorted() {
            holds.hold(row("BLK-H1", 5, NOW.plusSeconds(60)));
            holds.hold(row("BLK-H1", 3, NOW.plusSeconds(60)));

            assertThat(holds.heldVersions("BLK-H1", "ALL-1")).containsExactly(3, 5);
        }

        @Test
        void duplicateHeldVersionViolatesUqHold() {
            holds.hold(row("BLK-H2", 4, NOW.plusSeconds(60)));

            assertThatThrownBy(() -> holds.hold(row("BLK-H2", 4, NOW.plusSeconds(60))))
                    .isInstanceOf(IngestionStoreException.class);
        }

        @Test
        void claimIsExactlyOnce() {
            holds.hold(row("BLK-H3", 2, NOW.plusSeconds(60)));

            var first = holds.claim("BLK-H3", "ALL-1", 2);
            var second = holds.claim("BLK-H3", "ALL-1", 2);

            assertThat(first).isPresent();
            assertThat(first.get().expectedVersion()).isEqualTo(1);
            assertThat(first.get().rawProto()).isNotEmpty();
            assertThat(second).isEmpty();
            assertThat(holds.heldVersions("BLK-H3", "ALL-1")).isEmpty();
        }

        @Test
        void expiredHoldsFilteredByDeadline() {
            holds.hold(row("BLK-H4", 9, NOW.minusSeconds(10)));
            holds.hold(row("BLK-H4", 10, NOW.plusSeconds(3600)));

            List<VersionGapHoldStore.HoldRow> expired = holds.expiredHolds(NOW);

            assertThat(expired)
                    .extracting(VersionGapHoldStore.HoldRow::heldVersion)
                    .contains(9)
                    .doesNotContain(10);
            VersionGapHoldStore.HoldRow nine =
                    expired.stream().filter(h -> h.heldVersion() == 9).findFirst().orElseThrow();
            assertThat(nine.deadlineAt()).isEqualTo(NOW.minusSeconds(10));
            assertThat(nine.book()).isEqualTo("EQ_US_HY");
        }

        @Test
        void removeDeletesTheHold() {
            holds.hold(row("BLK-H5", 6, NOW.plusSeconds(60)));

            holds.remove("BLK-H5", "ALL-1", 6);

            assertThat(holds.heldVersions("BLK-H5", "ALL-1")).isEmpty();
        }
    }

    private int count(String sql) throws Exception {
        try (Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            rs.next();
            return rs.getInt(1);
        }
    }

    private static List<String> ddlBatches() throws Exception {
        String script;
        try (InputStream in =
                SqlStoresTest.class
                        .getClassLoader()
                        .getResourceAsStream("db/migration/V001__tcs_f0_schema.sql")) {
            assertThat(in).isNotNull();
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
