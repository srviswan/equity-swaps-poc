package com.pb.tcs.repair;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/** In-memory {@link RepairStore} mirroring the SQL adapter's OPEN-guarded transitions. */
final class InMemoryRepairStore implements RepairStore {

    private final Map<Long, RepairItem> items = new LinkedHashMap<>();
    private final AtomicLong ids = new AtomicLong();

    @Override
    public long open(String category, String correlationId, String detail, String payloadJson) {
        long id = ids.incrementAndGet();
        items.put(id, new RepairItem(id, category, correlationId, detail, payloadJson, STATUS_OPEN, null));
        return id;
    }

    @Override
    public Optional<RepairItem> find(long quarantineId) {
        return Optional.ofNullable(items.get(quarantineId));
    }

    @Override
    public List<RepairItem> openItems(String category) {
        List<RepairItem> open = new ArrayList<>();
        for (RepairItem item : items.values()) {
            if (STATUS_OPEN.equals(item.status()) && item.category().equals(category)) {
                open.add(item);
            }
        }
        return open;
    }

    @Override
    public void saveEdit(long quarantineId, String payloadJson, String editedBy) {
        RepairItem item = requireOpen(quarantineId);
        items.put(
                quarantineId,
                new RepairItem(
                        item.quarantineId(),
                        item.category(),
                        item.correlationId(),
                        item.detail(),
                        payloadJson,
                        item.status(),
                        editedBy));
    }

    @Override
    public void resolve(long quarantineId, String status, String resolvedBy) {
        RepairItem item = requireOpen(quarantineId);
        items.put(
                quarantineId,
                new RepairItem(
                        item.quarantineId(),
                        item.category(),
                        item.correlationId(),
                        item.detail(),
                        item.payloadJson(),
                        status,
                        item.editedBy()));
    }

    private RepairItem requireOpen(long quarantineId) {
        RepairItem item = items.get(quarantineId);
        if (item == null || !STATUS_OPEN.equals(item.status())) {
            throw new IllegalStateException("item %d not OPEN".formatted(quarantineId));
        }
        return item;
    }
}
