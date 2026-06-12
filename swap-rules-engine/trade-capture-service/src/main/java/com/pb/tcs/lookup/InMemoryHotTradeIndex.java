package com.pb.tcs.lookup;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public final class InMemoryHotTradeIndex implements HotTradeIndex {

    private final Map<UUID, TradeSummary> byId = new LinkedHashMap<>();

    public void put(TradeSummary summary) {
        byId.put(summary.ingestionId(), summary);
    }

    @Override
    public Optional<TradeSummary> findByIngestionId(UUID ingestionId) {
        return Optional.ofNullable(byId.get(ingestionId));
    }

    @Override
    public List<TradeSummary> search(TradeSearchQuery query) {
        return byId.values().stream().filter(s -> matches(s, query)).toList();
    }

    @Override
    public long countEligibleForArchive(LocalDate partitionMonth, int eligibilityDaysPastLifecycle) {
        return byId.values().stream()
                .filter(s -> partitionMonth.equals(s.tradeDate().withDayOfMonth(1)))
                .filter(s -> "SENT".equals(s.status()) || "SHADOW_COMPLETE".equals(s.status()))
                .count();
    }

    @Override
    public long movePartitionToArchive(LocalDate partitionMonth, ArchivedTradeIndex archiveIndex) {
        List<UUID> toMove = new ArrayList<>();
        for (var entry : byId.entrySet()) {
            TradeSummary s = entry.getValue();
            if (partitionMonth.equals(s.tradeDate().withDayOfMonth(1))) {
                archiveIndex.archive(
                        new TradeSummary(
                                s.ingestionId(),
                                s.correlationId(),
                                s.blockId(),
                                s.allocationId(),
                                s.version(),
                                s.book(),
                                s.clientAccount(),
                                s.swapRef(),
                                s.tradeDate(),
                                s.status(),
                                TradeSummary.LookupTier.ARCHIVE));
                toMove.add(entry.getKey());
            }
        }
        toMove.forEach(byId::remove);
        return toMove.size();
    }

    private static boolean matches(TradeSummary s, TradeSearchQuery q) {
        if (q.allocationId() != null && !q.allocationId().equals(s.allocationId())) {
            return false;
        }
        if (q.blockId() != null && !q.blockId().equals(s.blockId())) {
            return false;
        }
        if (q.book() != null && !q.book().equals(s.book())) {
            return false;
        }
        if (q.clientAccount() != null && !q.clientAccount().equals(s.clientAccount())) {
            return false;
        }
        if (q.tradeDate() != null && !q.tradeDate().equals(s.tradeDate())) {
            return false;
        }
        if (q.swapRef() != null && (s.swapRef() == null || !q.swapRef().equals(s.swapRef()))) {
            return false;
        }
        return q.lotRef() == null;
    }
}
