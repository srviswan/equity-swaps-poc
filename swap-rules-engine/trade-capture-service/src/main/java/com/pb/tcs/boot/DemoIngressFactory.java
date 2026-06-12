package com.pb.tcs.boot;

import com.pb.tcs.config.TcsConfigLoader;
import com.pb.tcs.ingress.IngressPipeline;
import com.pb.tcs.ingress.InMemoryHoldStore;
import com.pb.tcs.ingress.TradeCaptureProcessor;
import com.pb.tcs.persistence.InMemoryIngestionLifecycleStore;
import com.pb.tcs.reference.DemoReferenceData;
import java.time.Clock;
import org.springframework.stereotype.Component;

/** Builds a per-run ingress pipeline so lifecycle tracking is isolated between demo runs. */
@Component
class DemoIngressFactory {

    private final InMemoryIngestionLifecycleStore lifecycleStore;
    private final InMemoryHoldStore holdStore;
    private final DemoReferenceData referenceData;
    private final Clock clock;

    DemoIngressFactory(
            InMemoryIngestionLifecycleStore lifecycleStore,
            InMemoryHoldStore holdStore,
            DemoReferenceData referenceData,
            Clock clock) {
        this.lifecycleStore = lifecycleStore;
        this.holdStore = holdStore;
        this.referenceData = referenceData;
        this.clock = clock;
    }

    RunIngress openRun() {
        TradeCaptureProcessor.LifecycleIngestionStore bridge =
                new TradeCaptureProcessor.LifecycleIngestionStore(lifecycleStore, lifecycleStore);
        IngressPipeline pipeline =
                new IngressPipeline(
                        bridge,
                        holdStore,
                        referenceData,
                        TcsConfigLoader.versionGap(),
                        TcsConfigLoader.ingress(),
                        clock);
        return new RunIngress(bridge, pipeline);
    }

    record RunIngress(
            TradeCaptureProcessor.LifecycleIngestionStore bridge, IngressPipeline pipeline) {}
}
