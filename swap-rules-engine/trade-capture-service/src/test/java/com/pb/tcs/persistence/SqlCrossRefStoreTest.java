package com.pb.tcs.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import com.pb.tcs.crossref.CrossRefRecord;
import com.pb.tcs.crossref.CrossRefStatus;
import com.pb.tcs.routing.EventTypeDeriver;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.DockerClientFactory;
import org.testcontainers.containers.MSSQLServerContainer;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SqlCrossRefStoreTest {

    private MSSQLServerContainer<?> mssql;
    private SqlCrossRefStore store;

    @BeforeAll
    void startAndMigrate() throws Exception {
        assumeTrue(dockerAvailable(), "Docker unavailable");
        mssql =
                new MSSQLServerContainer<>("mcr.microsoft.com/mssql/server:2022-latest")
                        .acceptLicense();
        mssql.start();
        var ds = new com.microsoft.sqlserver.jdbc.SQLServerDataSource();
        ds.setURL(mssql.getJdbcUrl());
        ds.setUser(mssql.getUsername());
        ds.setPassword(mssql.getPassword());
        DataSource dataSource = ds;
        try (Connection conn = dataSource.getConnection()) {
            for (String migration :
                    List.of(
                            "db/migration/V001__tcs_f0_schema.sql",
                            "db/migration/V005__tcs_f6_dispatch_correlation.sql",
                            "db/migration/V006__tcs_f7_cross_ref_delivery.sql")) {
                for (String batch : ddlBatches(migration)) {
                    try (Statement stmt = conn.createStatement()) {
                        stmt.execute(batch);
                    }
                }
            }
        }
        store = new SqlCrossRefStore(dataSource);
    }

    @AfterAll
    void stop() {
        if (mssql != null) {
            mssql.stop();
        }
    }

    @Test
    void upsertClaimDeliverRoundTrip() {
        UUID ingestionId = UUID.randomUUID();
        store.upsertPending(
                new CrossRefRecord(
                        0,
                        ingestionId,
                        "BLK-X/ALL-1/1",
                        "SYSTEM_A",
                        "SYSTEM_B",
                        "A-SWP-1",
                        "[{\"lotId\":\"A-LOT-1\",\"action\":\"CLOSED\",\"qty\":1000}]",
                        EventTypeDeriver.EventType.UNWIND,
                        CrossRefStatus.PENDING,
                        0,
                        Instant.EPOCH,
                        null,
                        null));

        var pending = store.claimPending(10, Instant.parse("2099-01-01T00:00:00Z"));
        assertThat(pending).hasSize(1);
        store.markDelivered(pending.get(0).crossRefId(), Instant.now());

        assertThat(store.findByIngestionId(ingestionId))
                .singleElement()
                .extracting(CrossRefRecord::status)
                .isEqualTo(CrossRefStatus.DELIVERED);
    }

    private static List<String> ddlBatches(String resource) throws Exception {
        String script;
        try (InputStream in = SqlCrossRefStoreTest.class.getClassLoader().getResourceAsStream(resource)) {
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
