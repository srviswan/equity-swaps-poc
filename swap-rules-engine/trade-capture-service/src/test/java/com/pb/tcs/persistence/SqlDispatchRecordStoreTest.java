package com.pb.tcs.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import com.pb.tcs.dispatch.DispatchStatus;
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
class SqlDispatchRecordStoreTest {

    private MSSQLServerContainer<?> mssql;
    private SqlDispatchRecordStore store;

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
                            "db/migration/V005__tcs_f6_dispatch_correlation.sql")) {
                for (String batch : ddlBatches(migration)) {
                    try (Statement stmt = conn.createStatement()) {
                        stmt.execute(batch);
                    }
                }
            }
        }
        store = new SqlDispatchRecordStore(dataSource);
    }

    @AfterAll
    void stop() {
        if (mssql != null) {
            mssql.stop();
        }
    }

    @Test
    void claimMarkSentRoundTrip() {
        UUID ingestionId = UUID.randomUUID();
        store.createPending(ingestionId, "BLK-SQL/ALL-1/1", List.of("SYSTEM_A", "SYSTEM_B"));
        assertThat(store.findByCorrelationId("BLK-SQL/ALL-1/1")).hasSize(2);

        var claimed = store.claimBatch(10, Instant.parse("2099-01-01T00:00:00Z"));
        assertThat(claimed).hasSize(2);

        store.markSent(claimed.get(0).dispatchId(), "hash-a", Instant.now());
        store.scheduleRetry(claimed.get(1).dispatchId(), 1, Instant.now().plusSeconds(120), "down");

        assertThat(store.findByCorrelationId("BLK-SQL/ALL-1/1"))
                .extracting(r -> r.destinationId() + ":" + r.status())
                .containsExactlyInAnyOrder("SYSTEM_A:SENT", "SYSTEM_B:PENDING");
    }

    private static List<String> ddlBatches(String resource) throws Exception {
        String script;
        try (InputStream in =
                SqlDispatchRecordStoreTest.class.getClassLoader().getResourceAsStream(resource)) {
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
