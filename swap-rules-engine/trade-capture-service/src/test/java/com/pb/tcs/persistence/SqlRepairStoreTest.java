package com.pb.tcs.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import com.pb.tcs.ingress.IngestionStoreException;
import com.pb.tcs.repair.RepairStore;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.DockerClientFactory;
import org.testcontainers.containers.MSSQLServerContainer;

/**
 * {@link SqlRepairStore} against the real V001+V002+V003 schema: payload round-trip, edit audit,
 * and SQL-guarded status transitions (no double-resolve, no edit after resolve).
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SqlRepairStoreTest {

    private MSSQLServerContainer<?> mssql;
    private DataSource dataSource;
    private SqlRepairStore store;

    @BeforeAll
    void startAndMigrate() throws Exception {
        assumeTrue(dockerAvailable(), "Docker unavailable — skipping SQL repair tests");
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
                            "db/migration/V002__tcs_f3_blotter.sql",
                            "db/migration/V003__tcs_f4_repair.sql")) {
                for (String batch : ddlBatches(migration)) {
                    try (Statement stmt = conn.createStatement()) {
                        stmt.execute(batch);
                    }
                }
            }
        }
        store = new SqlRepairStore(dataSource);
    }

    @AfterAll
    void stop() {
        if (mssql != null) {
            mssql.stop();
        }
    }

    @Test
    void openFindEditResolveRoundTrip() {
        long id =
                store.open(
                        "BUSINESS_VALIDATION",
                        "BLK-R1/ALL-1/1",
                        "MANDATORY_FIELD_MISSING swap.interestLeg.rateType",
                        "{\"correlationId\":\"BLK-R1/ALL-1/1\"}");

        RepairStore.RepairItem item = store.find(id).orElseThrow();
        assertThat(item.category()).isEqualTo("BUSINESS_VALIDATION");
        assertThat(item.correlationId()).isEqualTo("BLK-R1/ALL-1/1");
        assertThat(item.status()).isEqualTo(RepairStore.STATUS_OPEN);
        assertThat(item.payloadJson()).contains("BLK-R1");
        assertThat(store.openItems("BUSINESS_VALIDATION"))
                .extracting(RepairStore.RepairItem::quarantineId)
                .contains(id);

        store.saveEdit(id, "{\"edited\":true}", "ops.jane");
        RepairStore.RepairItem edited = store.find(id).orElseThrow();
        assertThat(edited.payloadJson()).isEqualTo("{\"edited\":true}");
        assertThat(edited.editedBy()).isEqualTo("ops.jane");

        store.resolve(id, RepairStore.STATUS_REPROCESSED, "ops.jane");
        assertThat(store.find(id).orElseThrow().status()).isEqualTo(RepairStore.STATUS_REPROCESSED);
        assertThat(store.openItems("BUSINESS_VALIDATION"))
                .extracting(RepairStore.RepairItem::quarantineId)
                .doesNotContain(id);
    }

    @Test
    void resolvedItemsRejectFurtherTransitions() {
        long id = store.open("BUSINESS_VALIDATION", "BLK-R2/ALL-1/1", "detail", "{}");
        store.resolve(id, RepairStore.STATUS_DISCARDED, "ops.kim");

        assertThatThrownBy(() -> store.resolve(id, RepairStore.STATUS_REPROCESSED, "ops.kim"))
                .isInstanceOf(IngestionStoreException.class)
                .hasMessageContaining("not OPEN");
        assertThatThrownBy(() -> store.saveEdit(id, "{}", "ops.kim"))
                .isInstanceOf(IngestionStoreException.class)
                .hasMessageContaining("not OPEN");
    }

    @Test
    void openItemsFiltersByCategory() {
        store.open("REFDATA_EXHAUSTED", "BLK-R3/ALL-1/1", "security not found", null);

        assertThat(store.openItems("BUSINESS_VALIDATION"))
                .extracting(RepairStore.RepairItem::correlationId)
                .doesNotContain("BLK-R3/ALL-1/1");
        assertThat(store.openItems("REFDATA_EXHAUSTED"))
                .extracting(RepairStore.RepairItem::correlationId)
                .contains("BLK-R3/ALL-1/1");
    }

    private static List<String> ddlBatches(String resource) throws Exception {
        String script;
        try (InputStream in =
                SqlRepairStoreTest.class.getClassLoader().getResourceAsStream(resource)) {
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
