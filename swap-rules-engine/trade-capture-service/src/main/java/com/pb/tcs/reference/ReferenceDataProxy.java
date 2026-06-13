package com.pb.tcs.reference;

import java.util.Optional;

/**
 * Reference data behind one interface (FR-200). F1 ships a direct (read-through) implementation;
 * the F2 cache implementations slot in behind this boundary without touching the pipeline (D16,
 * FR-203). Returned values are JSON snapshots persisted into {@code enriched_allocation}.
 */
public interface ReferenceDataProxy {

    Optional<String> lookupSecurity(String securityId);

    Optional<String> lookupClientAccount(String clientAccount);

    Optional<String> lookupBook(String book);

    /** WashBook is derived, never supplied by GCAM (FR-201). */
    Optional<String> lookupWashBook(String clientAccount, String exchange, boolean b2bLeg);
}
