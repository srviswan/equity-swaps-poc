package com.pb.tcs.parity;

import com.pb.tcs.rules.BlotterAssembler;
import com.pb.tcs.rules.SwapBlotter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * FR-604 orchestrator: assemble TCS blotter for each legacy trade key, diff against the legacy
 * store, and roll up a batch report.
 */
public final class ParityHarnessService {

    private final LegacyBlotterStore legacyStore;
    private final BlotterAssembler assembler;
    private final ParityFieldComparator comparator;

    public ParityHarnessService(
            LegacyBlotterStore legacyStore,
            BlotterAssembler assembler,
            ParityFieldComparator comparator) {
        this.legacyStore = legacyStore;
        this.assembler = assembler;
        this.comparator = comparator;
    }

    public ParityRunReport run(ParityRunRequest request) {
        List<ParityMismatchReport> reports = new ArrayList<>();
        List<String> missingLegacy = new ArrayList<>();
        for (var allocation : request.allocations()) {
            String allocationId = allocation.message().getAllocationId();
            Optional<SwapBlotter> legacy = legacyStore.findByAllocationId(allocationId);
            if (legacy.isEmpty()) {
                missingLegacy.add(allocationId);
                continue;
            }
            SwapBlotter tcs = assembler.assemble(allocation).blotter();
            reports.add(comparator.compare(tcs, legacy.get()));
        }
        long matched =
                reports.stream().filter(ParityMismatchReport::match).count();
        return new ParityRunReport(
                reports.size(),
                matched,
                reports.size() - matched,
                missingLegacy.size(),
                reports,
                missingLegacy);
    }

    public ParityMismatchReport compareBlotters(SwapBlotter tcs, SwapBlotter legacy) {
        return comparator.compare(tcs, legacy);
    }

    public record ParityRunRequest(List<com.pb.tcs.ingress.EnrichedAllocation> allocations) {}

    public record ParityRunReport(
            int compared,
            long matched,
            long mismatched,
            int missingLegacy,
            List<ParityMismatchReport> tradeReports,
            List<String> missingLegacyKeys) {}
}
