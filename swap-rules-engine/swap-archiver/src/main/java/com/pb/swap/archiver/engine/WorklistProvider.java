package com.pb.swap.archiver.engine;

import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Refreshes {@code basket_archive_state} from {@code DimBasket}, computes eligibility
 * ({@code status='TERMINATED' AND termination_date < as_of - retention_months AND archived=0}),
 * quarantines baskets without a reliable termination date ({@code NEEDS_REVIEW}), and materialises
 * the eligible baskets into {@code archive_worklist}, grouped into chunks sized to a target row
 * count. On restart it returns only chunks not yet {@code DONE}.
 */
@Component
public class WorklistProvider {

    /** A chunk of eligible baskets to process across all in-scope tables. */
    public record Chunk(int chunkNo, List<Long> basketKeys) {}

    public void refreshBasketState() {
        // TODO(phase 6): light upsert from DimBasket -> basket_archive_state.
        throw new UnsupportedOperationException("scaffold: basket-state refresh not yet implemented");
    }

    public List<Chunk> buildOrResume(long runId, int targetBatchSize) {
        // TODO(phase 2/6): compute eligibility, persist worklist, return pending chunks.
        throw new UnsupportedOperationException("scaffold: worklist build not yet implemented");
    }
}
