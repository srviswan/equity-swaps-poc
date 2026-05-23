package com.pb.swap.rules.core.model;

/** Logical slice of the enriched equity swap. */
public enum EnrichmentTarget {
    SWAP_CONTRACT,
    INTEREST_LEG,
    EQUITY_LEG,
    SCHEDULE,
    DIV_PASSTHROUGH,
    LEGAL_ENTITY,
    DOCUMENTATION,
    WORKFLOW,
    ROUTING
}
