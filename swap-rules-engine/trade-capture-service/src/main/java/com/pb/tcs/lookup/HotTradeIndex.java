package com.pb.tcs.lookup;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/** Hot-tier trade index for lookup (FR-600). */
public interface HotTradeIndex {

    Optional<TradeSummary> findByIngestionId(UUID ingestionId);

    List<TradeSummary> search(TradeSearchQuery query);

    long countEligibleForArchive(LocalDate partitionMonth, int eligibilityDaysPastLifecycle);

    long movePartitionToArchive(LocalDate partitionMonth, ArchivedTradeIndex archiveIndex);
}
