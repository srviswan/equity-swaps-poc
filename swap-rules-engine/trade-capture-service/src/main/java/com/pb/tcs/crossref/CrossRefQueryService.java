package com.pb.tcs.crossref;

import java.util.List;
import java.util.UUID;

/** FR-404 poll API service layer — query by allocationId / swapRef / direction. */
public final class CrossRefQueryService {

    private final CrossRefStore store;

    public CrossRefQueryService(CrossRefStore store) {
        this.store = store;
    }

    public List<CrossRefRecord> poll(String allocationId, String swapRef, String direction) {
        String from = null;
        String to = null;
        if (direction != null && !direction.isBlank()) {
            String[] parts = direction.split("_TO_", 2);
            if (parts.length == 2) {
                from = parts[0];
                to = parts[1];
            }
        }
        return store.query(new CrossRefStore.CrossRefQuery(allocationId, swapRef, from, to));
    }

    public List<CrossRefRecord> byIngestionId(UUID ingestionId) {
        return store.findByIngestionId(ingestionId);
    }
}
