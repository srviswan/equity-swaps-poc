package com.pb.tcs.boot;

import com.pb.tcs.lookup.InMemoryHotTradeIndex;
import com.pb.tcs.lookup.TradeSummary;
import com.pb.tcs.persistence.InMemoryIngestionLifecycleStore;
import com.pb.tcs.repair.InMemoryBlotterStore;
import com.pb.tcs.rules.BlotterAssembler;
import com.pb.tcs.rules.F3Fixtures;
import java.time.LocalDate;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/** Seeds a sample trade so the ops UI has data on first load. */
@Component
@Profile("demo")
class DemoDataSeeder implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(DemoDataSeeder.class);

    private final boolean seedSampleTrade;
    private final BlotterAssembler assembler;
    private final InMemoryIngestionLifecycleStore lifecycleStore;
    private final InMemoryBlotterStore blotterStore;
    private final InMemoryHotTradeIndex hotTradeIndex;

    DemoDataSeeder(
            @Value("${tcs.demo.seed-sample-trade:true}") boolean seedSampleTrade,
            BlotterAssembler assembler,
            InMemoryIngestionLifecycleStore lifecycleStore,
            InMemoryBlotterStore blotterStore,
            InMemoryHotTradeIndex hotTradeIndex) {
        this.seedSampleTrade = seedSampleTrade;
        this.assembler = assembler;
        this.lifecycleStore = lifecycleStore;
        this.blotterStore = blotterStore;
        this.hotTradeIndex = hotTradeIndex;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (!seedSampleTrade) {
            return;
        }
        var allocation = F3Fixtures.usNyseSwap("BLK-DEMO", 1, "2026-06-10");
        UUID ingestionId = lifecycleStore.persistEnrichedAndReturnId(allocation);
        var assembly = assembler.assemble(allocation);
        blotterStore.save(assembly.blotter(), assembly.explains());

        hotTradeIndex.put(
                new TradeSummary(
                        ingestionId,
                        assembly.blotter().correlationId(),
                        "BLK-DEMO",
                        "ALL-1",
                        1,
                        "EQ_US_HY",
                        "CLIENT-DEMO",
                        null,
                        LocalDate.parse("2026-06-10"),
                        "READY",
                        TradeSummary.LookupTier.HOT));

        log.info("demo trade seeded ingestionId={} correlationId={}", ingestionId, assembly.blotter().correlationId());
    }
}
