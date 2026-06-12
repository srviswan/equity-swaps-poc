package com.pb.tcs.solace;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.ingress.IngestionStore;
import com.pb.tcs.ingress.IngressConsumer;
import com.pb.tcs.ingress.IngressMetrics;
import com.pb.tcs.ingress.IngressPipeline;
import com.pb.tcs.ingress.VersionGapHoldStore;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.AllocationType;
import com.pb.tcs.proto.allocation.v1.SourceSystem;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import com.pb.tcs.reference.ReferenceDataProxy;
import com.solacesystems.jcsmp.BytesMessage;
import com.solacesystems.jcsmp.DeliveryMode;
import com.solacesystems.jcsmp.JCSMPFactory;
import com.solacesystems.jcsmp.JCSMPProperties;
import com.solacesystems.jcsmp.JCSMPSession;
import com.solacesystems.jcsmp.JCSMPStreamingPublishCorrelatingEventHandler;
import com.solacesystems.jcsmp.Queue;
import com.solacesystems.jcsmp.XMLMessageProducer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.DockerClientFactory;
import org.testcontainers.solace.Service;
import org.testcontainers.solace.SolaceContainer;
import org.testcontainers.utility.DockerImageName;

/**
 * End-to-end transport proof against a real Solace broker (Testcontainers): publish →
 * partitioned-queue consume → pipeline → client-ACK, and NACK (settle FAILED) → broker
 * redelivery. Skips when Docker is unavailable.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SolaceIngressTest {

    private static final String QUEUE = "Q.TCS.ALLOCATION.IN";

    private SolaceContainer solace;
    private JCSMPSession publisherSession;
    private XMLMessageProducer producer;
    private SolacePartitionConsumer consumer;
    private final RecordingStore store = new RecordingStore();

    @BeforeAll
    void startBrokerAndConsumer() throws Exception {
        assumeTrue(dockerAvailable(), "Docker unavailable — skipping Solace tests");
        solace =
                new SolaceContainer(
                                DockerImageName.parse("solace/solace-pubsub-standard:latest"))
                        .withCredentials("tcs", "tcs")
                        .withExposedPorts(8080, Service.SMF.getPort())
                        // amd64-only image: boots in ~2.5 min under emulation on Apple Silicon
                        .withStartupTimeout(java.time.Duration.ofMinutes(6))
                        // SolaceContainer pins nofile=2448:6592 which crashes broker 10.25
                        // (exit 2 in pre-startup checks); raise it — applied after the
                        // class's own modifier, so this wins
                        .withCreateContainerCmdModifier(
                                cmd ->
                                        cmd.getHostConfig()
                                                .withUlimits(
                                                        new com.github.dockerjava.api.model
                                                                        .Ulimit[] {
                                                            new com.github.dockerjava.api.model
                                                                    .Ulimit(
                                                                    "nofile", 65536L, 1048576L)
                                                        }));
        solace.start();
        provisionQueue();

        // publisher
        JCSMPProperties props = new JCSMPProperties();
        props.setProperty(JCSMPProperties.HOST, solace.getOrigin(Service.SMF));
        props.setProperty(JCSMPProperties.VPN_NAME, solace.getVpn());
        props.setProperty(JCSMPProperties.USERNAME, solace.getUsername());
        props.setProperty(JCSMPProperties.PASSWORD, solace.getPassword());
        publisherSession = JCSMPFactory.onlyInstance().createSession(props);
        publisherSession.connect();
        producer =
                publisherSession.getMessageProducer(
                        new JCSMPStreamingPublishCorrelatingEventHandler() {
                            @Override
                            public void responseReceivedEx(Object key) {}

                            @Override
                            public void handleErrorEx(Object key, com.solacesystems.jcsmp.JCSMPException e, long ts) {}
                        });

        // consumer under test
        IngressPipeline pipeline =
                new IngressPipeline(
                        store,
                        new MapHoldStore(),
                        new StaticRefData(),
                        TcsConfigLoader.versionGap(),
                        TcsConfigLoader.ingress(),
                        Clock.systemUTC());
        consumer =
                SolacePartitionConsumer.connect(
                        new SolaceConnectionConfig(
                                solace.getOrigin(Service.SMF),
                                solace.getVpn(),
                                solace.getUsername(),
                                solace.getPassword(),
                                QUEUE,
                                50),
                        new IngressConsumer(
                                pipeline, new IngressMetrics(new SimpleMeterRegistry())));
    }

    @AfterAll
    void stop() {
        if (consumer != null) {
            consumer.close();
        }
        if (publisherSession != null) {
            publisherSession.closeSession();
        }
        if (solace != null) {
            solace.stop();
        }
    }

    @Test
    void publishedAllocationIsConsumedEnrichedAndAcked() throws Exception {
        publish(swap("BLK-SOL", 1).toByteArray());

        awaitTrue(
                () -> store.enrichedVersions("BLK-SOL", "ALL-1").contains(1),
                30_000,
                "allocation enriched via real broker");
        // ACKed: broker does not redeliver after consumer restart-free quiet period;
        // implicit via no duplicate persist below
        Thread.sleep(1000);
        assertThat(store.persistCount("BLK-SOL", "ALL-1", 1)).isEqualTo(1);
    }

    @Test
    void garbageIsNackedAndRedeliveredByBroker() throws Exception {
        publish(new byte[] {(byte) 0xFF, 0x13, 0x37});

        // settle(FAILED) → broker redelivery → at least 2 structural audit entries
        awaitTrue(
                () -> store.structuralRejects() >= 2,
                30_000,
                "NACK redelivery produced repeat structural rejects");
    }

    // --- helpers --------------------------------------------------------------------

    private void publish(byte[] payload) throws Exception {
        BytesMessage message = JCSMPFactory.onlyInstance().createMessage(BytesMessage.class);
        message.setData(payload);
        message.setDeliveryMode(DeliveryMode.PERSISTENT);
        Queue queue = JCSMPFactory.onlyInstance().createQueue(QUEUE);
        producer.send(message, queue);
    }

    private void provisionQueue() throws Exception {
        String semp = "http://" + solace.getHost() + ":" + solace.getMappedPort(8080);
        String body =
                """
                {"queueName":"%s","accessType":"exclusive","permission":"consume",
                 "ingressEnabled":true,"egressEnabled":true,"maxRedeliveryCount":3}"""
                        .formatted(QUEUE);
        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(
                                URI.create(
                                        semp
                                                + "/SEMP/v2/config/msgVpns/"
                                                + solace.getVpn()
                                                + "/queues"))
                        .header(
                                "Authorization",
                                "Basic "
                                        + Base64.getEncoder()
                                                .encodeToString(
                                                        "admin:admin"
                                                                .getBytes(
                                                                        StandardCharsets.UTF_8)))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(body))
                        .build();
        HttpResponse<String> response =
                HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        assertThat(response.statusCode()).as(response.body()).isEqualTo(200);
    }

    private static void awaitTrue(Supplier<Boolean> condition, long timeoutMs, String what)
            throws InterruptedException {
        long deadline = System.currentTimeMillis() + timeoutMs;
        while (System.currentTimeMillis() < deadline) {
            if (condition.get()) {
                return;
            }
            Thread.sleep(200);
        }
        throw new AssertionError("Timed out waiting for: " + what);
    }

    private static TcsIngressMessage swap(String blockId, int version) {
        return TcsIngressMessage.newBuilder()
                .setMessageId("M-" + blockId + "-" + version)
                .setSource(SourceSystem.GCAM)
                .setBook("EQ_US_HY")
                .setAccountId("CLI-9")
                .setSecurityId("SEC-AAPL")
                .setAllocation(
                        AllocationMessage.newBuilder()
                                .setBlockId(blockId)
                                .setAllocationId("ALL-1")
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

    /** Thread-safe minimal store: the listener thread writes, the test thread polls. */
    private static final class RecordingStore implements IngestionStore {
        private final ConcurrentHashMap<String, SortedSet<Integer>> enriched =
                new ConcurrentHashMap<>();
        private final ConcurrentHashMap<String, Integer> persists = new ConcurrentHashMap<>();
        private final List<String> structural = new CopyOnWriteArrayList<>();

        @Override
        public boolean isEnriched(String blockId, String allocationId, int version) {
            return enrichedVersions(blockId, allocationId).contains(version);
        }

        @Override
        public OptionalInt lastEnrichedVersion(String blockId, String allocationId) {
            SortedSet<Integer> versions = enrichedVersions(blockId, allocationId);
            return versions.isEmpty() ? OptionalInt.empty() : OptionalInt.of(versions.last());
        }

        @Override
        public void persistEnriched(EnrichedAllocation allocation) {
            AllocationMessage m = allocation.message();
            enriched.computeIfAbsent(
                            m.getBlockId() + "|" + m.getAllocationId(),
                            k -> new TreeSet<>())
                    .add(m.getVersion());
            persists.merge(
                    m.getBlockId() + "|" + m.getAllocationId() + "|" + m.getVersion(),
                    1,
                    Integer::sum);
        }

        @Override
        public void auditReject(
                String stage, String reason, int attempt, byte[] raw, TcsIngressMessage parsed) {
            if ("STRUCTURAL".equals(stage)) {
                structural.add(reason);
            }
        }

        @Override
        public void quarantine(String category, String detail, byte[] rawProto) {}

        SortedSet<Integer> enrichedVersions(String blockId, String allocationId) {
            return enriched.getOrDefault(blockId + "|" + allocationId, new TreeSet<>());
        }

        int persistCount(String blockId, String allocationId, int version) {
            return persists.getOrDefault(blockId + "|" + allocationId + "|" + version, 0);
        }

        int structuralRejects() {
            return structural.size();
        }
    }

    private static final class MapHoldStore implements VersionGapHoldStore {
        private final ConcurrentHashMap<String, HoldRow> rows = new ConcurrentHashMap<>();

        @Override
        public void hold(HoldRow row) {
            rows.put(row.blockId() + "|" + row.allocationId() + "|" + row.heldVersion(), row);
        }

        @Override
        public SortedSet<Integer> heldVersions(String blockId, String allocationId) {
            SortedSet<Integer> versions = new TreeSet<>();
            rows.values().stream()
                    .filter(
                            r ->
                                    r.blockId().equals(blockId)
                                            && r.allocationId().equals(allocationId))
                    .forEach(r -> versions.add(r.heldVersion()));
            return versions;
        }

        @Override
        public Optional<HoldRow> claim(String blockId, String allocationId, int version) {
            return Optional.ofNullable(rows.remove(blockId + "|" + allocationId + "|" + version));
        }

        @Override
        public List<HoldRow> expiredHolds(Instant now) {
            return new ArrayList<>();
        }

        @Override
        public void remove(String blockId, String allocationId, int version) {
            rows.remove(blockId + "|" + allocationId + "|" + version);
        }
    }

    private static final class StaticRefData implements ReferenceDataProxy {
        @Override
        public Optional<String> lookupSecurity(String securityId) {
            return Optional.of("{\"securityId\":\"" + securityId + "\"}");
        }

        @Override
        public Optional<String> lookupClientAccount(String clientAccount) {
            return Optional.of("{\"clientAccount\":\"" + clientAccount + "\"}");
        }

        @Override
        public Optional<String> lookupBook(String book) {
            return Optional.of("{\"book\":\"" + book + "\"}");
        }

        @Override
        public Optional<String> lookupWashBook(
                String clientAccount, String exchange, boolean b2bLeg) {
            return Optional.of("{\"washBook\":\"WASH-" + exchange + "\"}");
        }
    }

    private static boolean dockerAvailable() {
        try {
            return DockerClientFactory.instance().isDockerAvailable();
        } catch (Throwable t) {
            return false;
        }
    }
}
