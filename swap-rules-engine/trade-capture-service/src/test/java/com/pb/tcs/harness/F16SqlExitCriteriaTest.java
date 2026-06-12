package com.pb.tcs.harness;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.ingress.IngressConsumer;
import com.pb.tcs.ingress.IngressMetrics;
import com.pb.tcs.ingress.IngressPipeline;
import com.pb.tcs.persistence.SqlIngestionStore;
import com.pb.tcs.persistence.SqlVersionGapHoldStore;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.DockerClientFactory;
import org.testcontainers.containers.MSSQLServerContainer;

/**
 * F1.6 exit criteria 2–4 against the real V001 schema:
 *
 * <ol>
 *   <li>(criterion 2) Spike — 15K messages on 10 hot keys: full drain &lt; 2 min, ACK P99 &lt;
 *       500 ms (NFR-2/NFR-4).
 *   <li>(criterion 3) Crash — consumer killed mid-spike, full stream redelivered at-least-once:
 *       no loss, no duplicate ENRICHED_ACKED, version-gap holds recovered from SQL (NFR-6).
 *   <li>(criterion 4) Ref-data outage drill — 3 attempts → quarantine → repair reprocess →
 *       enriched end-to-end (D6/D22, FR-300).
 * </ol>
 */
@Tag("perf")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class F16SqlExitCriteriaTest {

    private static final int PARTITIONS = 16;
    private static final int SPIKE_MESSAGES = 15_000;
    private static final int SPIKE_HOT_KEYS = 10;
    private static final int CRASH_KEY_OFFSET = 100_000;
    private static final int OUTAGE_KEY_OFFSET = 200_000;

    private MSSQLServerContainer<?> mssql;
    private DataSource dataSource;

    @BeforeAll
    void startAndMigrate() throws Exception {
        assumeTrue(dockerAvailable(), "Docker unavailable — skipping F1.6 SQL exit criteria");
        mssql =
                new MSSQLServerContainer<>("mcr.microsoft.com/mssql/server:2022-latest")
                        .acceptLicense();
        mssql.start();
        // pooled, as in production — a raw SQLServerDataSource opens a fresh connection per
        // JDBC call (3 per message) and cannot meet the spike numbers
        var hikari = new com.zaxxer.hikari.HikariConfig();
        hikari.setJdbcUrl(mssql.getJdbcUrl());
        hikari.setUsername(mssql.getUsername());
        hikari.setPassword(mssql.getPassword());
        hikari.setMaximumPoolSize(PARTITIONS + 4);
        dataSource = new com.zaxxer.hikari.HikariDataSource(hikari);
        try (Connection conn = dataSource.getConnection()) {
            for (String batch : ddlBatches()) {
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(batch);
                }
            }
        }
    }

    @AfterAll
    void stop() {
        if (dataSource instanceof com.zaxxer.hikari.HikariDataSource hikari) {
            hikari.close();
        }
        if (mssql != null) {
            mssql.stop();
        }
    }

    private IngressConsumer consumer(OrderingAssertingStore store, UniversalReferenceData refData) {
        return new IngressConsumer(
                new IngressPipeline(
                        store,
                        new SqlVersionGapHoldStore(dataSource),
                        refData,
                        TcsConfigLoader.versionGap(),
                        TcsConfigLoader.ingress(),
                        Clock.systemUTC()),
                new IngressMetrics(new SimpleMeterRegistry()));
    }

    /**
     * The 15K/10-min spike is published as an instantaneous burst, so drain time is a sustained
     * throughput measurement. NFR-2's real inflow is 25 msg/s; the certification bar (lag
     * recovery &lt; 2 min ⇒ ≥125 msg/s) is asserted with {@code -Dtcs.spike.drainBudgetMs=120000}
     * on representative hardware. The default local budget is wider because the MSSQL container
     * runs under amd64 emulation on Apple Silicon (every commit fsyncs through qemu).
     */
    @Test
    void criterion2_spikeDrainsWithinBudgetWithAckP99Under500ms() throws Exception {
        long drainBudgetMs = Long.getLong("tcs.spike.drainBudgetMs", 240_000L);
        OrderingAssertingStore store =
                new OrderingAssertingStore(new SqlIngestionStore(dataSource));

        long startMs = System.currentTimeMillis();
        List<Long> latencies;
        try (PartitionedReplayer replayer =
                new PartitionedReplayer(PARTITIONS, consumer(store, new UniversalReferenceData()), 3)) {
            replayer.start();
            SyntheticAllocationGenerator.hotKeys(SPIKE_HOT_KEYS, SPIKE_MESSAGES, 99L)
                    .forEach(replayer::publish);
            assertThat(replayer.awaitDrained(drainBudgetMs))
                    .as("partition lag recovered within %d ms (NFR-2)", drainBudgetMs)
                    .isTrue();
            latencies = replayer.ackLatenciesNanos();
            assertThat(replayer.dlqSize()).isZero();
        }
        long drainMs = System.currentTimeMillis() - startMs;
        double throughput = SPIKE_MESSAGES / (drainMs / 1000.0);

        assertThat(store.orderingViolations()).isEmpty();
        assertThat(store.totalPersists()).isEqualTo(SPIKE_MESSAGES);
        assertThat(countEnriched("BLK-0000%")).isEqualTo(SPIKE_MESSAGES);

        latencies.sort(Long::compare);
        long p99Nanos = latencies.get((int) (latencies.size() * 0.99) - 1);
        System.out.printf(
                "spike: %d msgs drained in %.1fs (%.0f msg/s), ACK P99 = %.1f ms%n",
                SPIKE_MESSAGES, drainMs / 1000.0, throughput, p99Nanos / 1_000_000.0);
        assertThat(throughput)
                .as("sustained throughput beats the 25 msg/s spike inflow with headroom")
                .isGreaterThan(50.0);
        assertThat(p99Nanos)
                .as("GCAM ACK P99 < 500 ms under spike (NFR-4)")
                .isLessThan(500_000_000L);
    }

    @Test
    void criterion3_crashMidSpikeLosesNothingDuplicatesNothingRecoversHolds() throws Exception {
        int keys = 200;
        int versionsPerKey = 20;
        UniversalReferenceData refData = new UniversalReferenceData();

        List<TcsIngressMessage> stream =
                SyntheticAllocationGenerator.uniform(keys, versionsPerKey, 7L, CRASH_KEY_OFFSET)
                        .toList();
        // gap scenario: key with v1 + v3 published pre-crash; v2 arrives only after restart
        TcsIngressMessage gapV1 = SyntheticAllocationGenerator.message(CRASH_KEY_OFFSET + 9999, 1);
        TcsIngressMessage gapV2 = SyntheticAllocationGenerator.message(CRASH_KEY_OFFSET + 9999, 2);
        TcsIngressMessage gapV3 = SyntheticAllocationGenerator.message(CRASH_KEY_OFFSET + 9999, 3);

        // phase 1: process until ~half persisted, then crash
        OrderingAssertingStore store1 =
                new OrderingAssertingStore(new SqlIngestionStore(dataSource));
        PartitionedReplayer phase1 = new PartitionedReplayer(PARTITIONS, consumer(store1, refData), 3);
        phase1.start();
        phase1.publish(gapV1);
        phase1.publish(gapV3); // v2 unseen → held in SQL
        stream.forEach(phase1::publish);
        long deadline = System.currentTimeMillis() + 60_000;
        while (store1.totalPersists() < (keys * versionsPerKey) / 2
                && System.currentTimeMillis() < deadline) {
            Thread.sleep(10);
        }
        phase1.crash();
        int persistedBeforeCrash = store1.totalPersists();
        assertThat(persistedBeforeCrash).isLessThan(keys * versionsPerKey);

        // phase 2: fresh consumer (same DB) + broker redelivers the WHOLE stream at-least-once
        OrderingAssertingStore store2 =
                new OrderingAssertingStore(new SqlIngestionStore(dataSource));
        try (PartitionedReplayer phase2 = new PartitionedReplayer(PARTITIONS, consumer(store2, refData), 3)) {
            phase2.start();
            stream.forEach(phase2::publish);
            phase2.publish(gapV1);
            phase2.publish(gapV3);
            phase2.publish(gapV2); // closes the gap; v3 must drain from the SQL-backed hold
            assertThat(phase2.awaitDrained(120_000)).isTrue();
            assertThat(phase2.dlqSize()).isZero();
        }

        assertThat(store2.orderingViolations()).isEmpty();
        // no loss, no duplicates: SQL is the arbiter (uq_idem would also reject dupes)
        int expected = keys * versionsPerKey + 3;
        assertThat(countEnriched("BLK-1%")).isEqualTo(expected);
        assertThat(count(
                        "SELECT COUNT(*) FROM (SELECT block_id, allocation_id, version"
                                + " FROM dbo.ingestion_record WHERE block_id LIKE 'BLK-1%'"
                                + " GROUP BY block_id, allocation_id, version"
                                + " HAVING COUNT(*) > 1) dupes"))
                .as("zero duplicate ENRICHED_ACKED rows")
                .isZero();
        assertThat(count("SELECT COUNT(*) FROM dbo.version_gap_hold WHERE block_id LIKE 'BLK-1%'"))
                .as("gap hold drained after recovery")
                .isZero();
    }

    @Test
    void criterion4_refdataOutageQuarantinesThenRepairReprocessSucceeds() throws Exception {
        UniversalReferenceData refData = new UniversalReferenceData();
        refData.outage();
        OrderingAssertingStore store =
                new OrderingAssertingStore(new SqlIngestionStore(dataSource));
        TcsIngressMessage trade = SyntheticAllocationGenerator.message(OUTAGE_KEY_OFFSET, 1);

        try (PartitionedReplayer replayer = new PartitionedReplayer(PARTITIONS, consumer(store, refData), 3)) {
            replayer.start();
            replayer.publish(trade);
            // attempts 1,2 NACK → redeliver; attempt 3 ACK + quarantine
            long deadline = System.currentTimeMillis() + 30_000;
            while (countQuarantined() == 0 && System.currentTimeMillis() < deadline) {
                Thread.sleep(50);
            }
        }
        assertThat(countQuarantined()).isEqualTo(1);
        assertThat(countEnriched("BLK-200000")).isZero();

        // repair-UI reprocess: ref data recovered, raw proto re-submitted from quarantine
        refData.recover();
        byte[] rawFromQuarantine = quarantinedRawProto();
        var result =
                new IngressPipeline(
                                store,
                                new SqlVersionGapHoldStore(dataSource),
                                refData,
                                TcsConfigLoader.versionGap(),
                                TcsConfigLoader.ingress(),
                                Clock.systemUTC())
                        .process(rawFromQuarantine, 1);

        assertThat(result.disposition())
                .isEqualTo(com.pb.tcs.ingress.PipelineResult.Disposition.ENRICHED);
        assertThat(countEnriched("BLK-200000")).isEqualTo(1);
    }

    // --- SQL helpers -----------------------------------------------------------------

    private int countEnriched(String blockIdPattern) throws Exception {
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(
                                "SELECT COUNT(*) FROM dbo.ingestion_record"
                                        + " WHERE block_id LIKE ? AND status = 'ENRICHED_ACKED'")) {
            ps.setString(1, blockIdPattern);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        }
    }

    private int countQuarantined() throws Exception {
        return count(
                "SELECT COUNT(*) FROM dbo.repair_quarantine"
                        + " WHERE category = 'REFDATA_EXHAUSTED'"
                        + " AND gcam_message_id LIKE 'GCAM-200000-%'");
    }

    private byte[] quarantinedRawProto() throws Exception {
        try (Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs =
                        stmt.executeQuery(
                                "SELECT raw_proto FROM dbo.repair_quarantine"
                                        + " WHERE gcam_message_id LIKE 'GCAM-200000-%'")) {
            assertThat(rs.next()).isTrue();
            return rs.getBytes(1);
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
                F16SqlExitCriteriaTest.class
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
