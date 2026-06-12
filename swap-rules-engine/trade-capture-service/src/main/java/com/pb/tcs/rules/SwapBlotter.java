package com.pb.tcs.rules;

import com.pb.swap.rules.core.model.EnrichedEquitySwap;
import java.time.LocalDate;

/**
 * Stage-4 output (FR-204): the holder object that hardens into a SwapContract as it moves through
 * the pipeline. Provisional schema until E9 (SwapBlotter field dictionary) lands — identity and
 * sequencing fields are final (they mirror the F0 ingestion contract); the {@code swap} payload
 * shape tracks the engine's {@link EnrichedEquitySwap} model.
 *
 * @param correlationId D4 correlation id: {@code blockId/allocationId/version}
 * @param snapshotVersion rule snapshot the blotter was assembled under (audit / replay)
 */
public record SwapBlotter(
        String correlationId,
        String blockId,
        String allocationId,
        int version,
        String allocationType,
        String book,
        String accountId,
        String securityId,
        LocalDate tradeDate,
        String snapshotVersion,
        EnrichedEquitySwap swap) {}
