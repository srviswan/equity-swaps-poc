package com.pb.tcs.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import com.pb.tcs.ingress.IngestionStoreException;
import com.pb.tcs.rules.RuleExplain;
import com.pb.tcs.rules.SwapBlotter;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
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
 * {@link SqlBlotterStore} against the real V001+V002 schema: blotter + explains commit
 * atomically, duplicate correlation ids are rejected without leaking explain rows, and the
 * round-tripped JSON payload carries the enriched swap.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SqlBlotterStoreTest {

    private MSSQLServerContainer<?> mssql;
    private DataSource dataSource;
    private SqlBlotterStore store;

    @BeforeAll
    void startAndMigrate() throws Exception {
        assumeTrue(dockerAvailable(), "Docker unavailable — skipping SQL blotter tests");
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
                            "db/migration/V002__tcs_f3_blotter.sql")) {
                for (String batch : ddlBatches(migration)) {
                    try (Statement stmt = conn.createStatement()) {
                        stmt.execute(batch);
                    }
                }
            }
        }
        store = new SqlBlotterStore(dataSource);
    }

    @AfterAll
    void stop() {
        if (mssql != null) {
            mssql.stop();
        }
    }

    private static com.pb.tcs.rules.BlotterAssembler.Assembly assembly(String blockId) {
        var assembler =
                new com.pb.tcs.rules.BlotterAssembler(
                        com.pb.tcs.rules.RuleSetLoader.fromClasspath(
                                "fixtures/rules/f3-golden-rules.yml"));
        return assembler.assemble(
                com.pb.tcs.rules.F3Fixtures.usNyseSwap(blockId, 1, "2026-06-10"));
    }

    @Test
    void savePersistsBlotterAndExplainTrailAtomically() throws Exception {
        var assembly = assembly("BLK-BS1");

        store.save(assembly.blotter(), assembly.explains());

        String json = store.findBlotterJson("BLK-BS1/ALL-1/1").orElseThrow();
        assertThat(json)
                .contains("\"spreadBps\":250")
                .contains("\"legalEntity\":\"PB_ENTITY_US\"")
                .contains("\"tradeDate\":\"2026-06-10\"");

        List<RuleExplain> explains = store.findExplains("BLK-BS1/ALL-1/1");
        assertThat(explains).hasSameSizeAs(assembly.explains());
        assertThat(explains)
                .extracting(RuleExplain::ruleId)
                .contains("ECON-US-SS-NYSE", "ECON-BASE");
        assertThat(explains).isSortedAccordingTo(java.util.Comparator.comparingInt(RuleExplain::seq));
    }

    @Test
    void duplicateCorrelationIdRollsBackExplains() throws Exception {
        var assembly = assembly("BLK-BS2");
        store.save(assembly.blotter(), assembly.explains());
        int explainsBefore = count("SELECT COUNT(*) FROM dbo.rule_explain");

        assertThatThrownBy(() -> store.save(assembly.blotter(), assembly.explains()))
                .isInstanceOf(IngestionStoreException.class)
                .hasMessageContaining("uq_blotter");

        assertThat(count("SELECT COUNT(*) FROM dbo.rule_explain")).isEqualTo(explainsBefore);
    }

    @Test
    void unknownCorrelationIdIsEmpty() {
        assertThat(store.findBlotterJson("NOPE/1/1")).isEmpty();
        assertThat(store.findExplains("NOPE/1/1")).isEmpty();
    }

    private int count(String sql) throws Exception {
        try (Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            rs.next();
            return rs.getInt(1);
        }
    }

    private static List<String> ddlBatches(String resource) throws Exception {
        String script;
        try (InputStream in =
                SqlBlotterStoreTest.class.getClassLoader().getResourceAsStream(resource)) {
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
