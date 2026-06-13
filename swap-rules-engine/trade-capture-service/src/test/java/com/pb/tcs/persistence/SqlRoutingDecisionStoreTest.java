package com.pb.tcs.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import com.pb.tcs.ingress.IngestionStoreException;
import com.pb.tcs.routing.EventTypeDeriver;
import com.pb.tcs.routing.RoutingDecision;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.DockerClientFactory;
import org.testcontainers.containers.MSSQLServerContainer;

/**
 * {@link SqlRoutingDecisionStore} against the real V001+V004 schema: the fan-out set commits
 * atomically (duplicate target rolls back the whole batch) and match-key/as-of round-trip.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SqlRoutingDecisionStoreTest {

    private static final LocalDate TRADE_DATE = LocalDate.of(2026, 6, 10);
    private static final Instant AS_OF = Instant.parse("2026-06-10T20:00:00Z");

    private MSSQLServerContainer<?> mssql;
    private DataSource dataSource;
    private SqlRoutingDecisionStore store;

    @BeforeAll
    void startAndMigrate() throws Exception {
        assumeTrue(dockerAvailable(), "Docker unavailable — skipping SQL routing tests");
        mssql =
                new MSSQLServerContainer<>("mcr.microsoft.com/mssql/server:2022-latest")
                        .acceptLicense();
        mssql.start();
        var ds = new com.microsoft.sqlserver.jdbc.SQLServerDataSource();
        ds.setURL(mssql.getJdbcUrl());
        ds.setUser(mssql.getUsername());
        ds.setPassword(mssql.getPassword());
        dataSource = ds;
        try (Connection conn = dataSource.getConnection()) {
            for (String migration :
                    List.of(
                            "db/migration/V001__tcs_f0_schema.sql",
                            "db/migration/V004__tcs_f5_routing.sql")) {
                for (String batch : ddlBatches(migration)) {
                    try (Statement stmt = conn.createStatement()) {
                        stmt.execute(batch);
                    }
                }
            }
        }
        store = new SqlRoutingDecisionStore(dataSource);
    }

    @AfterAll
    void stop() {
        if (mssql != null) {
            mssql.stop();
        }
    }

    private static RoutingDecision decision(
            String correlationId, String targetId, EventTypeDeriver.EventType eventType) {
        boolean lookup = eventType != EventTypeDeriver.EventType.NEW;
        return new RoutingDecision(
                correlationId,
                TRADE_DATE,
                "us-single-stock",
                targetId,
                "tcs/booking/out/" + targetId.toLowerCase() + "/v1",
                eventType,
                lookup
                        ? Map.of("book", "EQ_US_HY", "security", "SEC-AAPL", "direction", "BUY")
                        : Map.of(),
                lookup ? AS_OF : null);
    }

    @Test
    void fanOutSetRoundTrips() {
        store.saveAll(
                List.of(
                        decision("BLK-RD1/ALL-1/1", "SYSTEM_A", EventTypeDeriver.EventType.NEW),
                        decision("BLK-RD1/ALL-1/1", "SYSTEM_B", EventTypeDeriver.EventType.TOP_UP)));

        List<RoutingDecision> found = store.findByCorrelationId("BLK-RD1/ALL-1/1");
        assertThat(found).hasSize(2);
        RoutingDecision a = found.stream().filter(d -> d.targetId().equals("SYSTEM_A")).findFirst().orElseThrow();
        assertThat(a.eventType()).isEqualTo(EventTypeDeriver.EventType.NEW);
        assertThat(a.matchKey()).isEmpty();
        assertThat(a.positionAsOf()).isNull();
        RoutingDecision b = found.stream().filter(d -> d.targetId().equals("SYSTEM_B")).findFirst().orElseThrow();
        assertThat(b.eventType()).isEqualTo(EventTypeDeriver.EventType.TOP_UP);
        assertThat(b.matchKey())
                .containsEntry("book", "EQ_US_HY")
                .containsEntry("security", "SEC-AAPL");
        assertThat(b.positionAsOf()).isEqualTo(AS_OF);
        assertThat(b.ruleName()).isEqualTo("us-single-stock");
    }

    @Test
    void duplicateTargetRollsBackWholeBatch() {
        store.saveAll(List.of(decision("BLK-RD2/ALL-1/1", "SYSTEM_A", EventTypeDeriver.EventType.NEW)));

        assertThatThrownBy(
                        () ->
                                store.saveAll(
                                        List.of(
                                                decision("BLK-RD2/ALL-1/1", "SYSTEM_B", EventTypeDeriver.EventType.NEW),
                                                decision("BLK-RD2/ALL-1/1", "SYSTEM_A", EventTypeDeriver.EventType.NEW))))
                .isInstanceOf(IngestionStoreException.class);

        // the batch rolled back as one: B must not have been persisted alone
        assertThat(store.findByCorrelationId("BLK-RD2/ALL-1/1"))
                .extracting(RoutingDecision::targetId)
                .containsExactly("SYSTEM_A");
    }

    @Test
    void unknownCorrelationIdIsEmpty() {
        assertThat(store.findByCorrelationId("NOPE/1/1")).isEmpty();
    }

    private static List<String> ddlBatches(String resource) throws Exception {
        String script;
        try (InputStream in =
                SqlRoutingDecisionStoreTest.class.getClassLoader().getResourceAsStream(resource)) {
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
