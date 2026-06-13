package com.pb.tcs.api;

import com.pb.tcs.harness.IngressHarnessPublisher;
import com.pb.tcs.harness.LegacyTradeExtract;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.parity.ParityHarnessService;
import com.pb.tcs.parity.ParityMismatchReport;
import com.pb.tcs.config.ParityManifestConfig;
import com.pb.tcs.rules.SwapBlotter;
import java.util.List;

/**
 * FR-604 REST contract surface ({@code POST /api/v1/parity/runs}). Transport-agnostic — wired to
 * HTTP in a later phase.
 */
public final class ParityApi {

    private final ParityHarnessService harnessService;

    public ParityApi(ParityHarnessService harnessService) {
        this.harnessService = harnessService;
    }

    public ParityRunResponse run(ParityRunRequest request) {
        List<EnrichedAllocation> allocations =
                request.extracts().stream().map(IngressHarnessPublisher::toEnrichedAllocation).toList();
        ParityHarnessService.ParityRunReport report =
                harnessService.run(new ParityHarnessService.ParityRunRequest(allocations));
        return ParityRunResponse.from(report);
    }

    public ParityCompareResponse compare(SwapBlotter tcs, SwapBlotter legacy) {
        return ParityCompareResponse.from(harnessService.compareBlotters(tcs, legacy));
    }

    public record ParityRunRequest(List<LegacyTradeExtract> extracts) {}

    public record ParityRunResponse(
            int compared,
            long matched,
            long mismatched,
            int missingLegacy,
            List<ParityTradeReportView> trades,
            List<String> missingLegacyKeys) {

        static ParityRunResponse from(ParityHarnessService.ParityRunReport report) {
            return new ParityRunResponse(
                    report.compared(),
                    report.matched(),
                    report.mismatched(),
                    report.missingLegacy(),
                    report.tradeReports().stream().map(ParityTradeReportView::from).toList(),
                    report.missingLegacyKeys());
        }
    }

    public record ParityCompareResponse(
            String tradeKey, boolean match, long mismatchCount, List<ParityFieldMismatchView> mismatches) {

        static ParityCompareResponse from(ParityMismatchReport report) {
            return new ParityCompareResponse(
                    report.tradeKey(),
                    report.match(),
                    report.mismatchCount(),
                    report.mismatches().stream().map(ParityFieldMismatchView::from).toList());
        }
    }

    public record ParityTradeReportView(
            String tradeKey, boolean match, long mismatchCount, List<ParityFieldMismatchView> mismatches) {

        static ParityTradeReportView from(ParityMismatchReport report) {
            return new ParityTradeReportView(
                    report.tradeKey(),
                    report.match(),
                    report.mismatchCount(),
                    report.mismatches().stream().map(ParityFieldMismatchView::from).toList());
        }
    }

    public record ParityFieldMismatchView(
            String fieldPath,
            ParityManifestConfig.Mode policy,
            String tcsValue,
            String legacyValue,
            String reason) {

        static ParityFieldMismatchView from(com.pb.tcs.parity.ParityFieldMismatch mismatch) {
            return new ParityFieldMismatchView(
                    mismatch.fieldPath(),
                    mismatch.policy(),
                    mismatch.tcsValue(),
                    mismatch.legacyValue(),
                    mismatch.reason());
        }
    }
}
