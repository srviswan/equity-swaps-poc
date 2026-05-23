package com.pb.swap.rules.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pb.swap.rules.core.schema.SchemaField;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EnrichedEquitySwap(
        @SchemaField(description = "Originating trade id", writable = false) String tradeId,
        @SchemaField(description = "Contract-level attributes") SwapContract swapContract,
        @SchemaField(description = "Interest (financing) leg") InterestLeg interestLeg,
        @SchemaField(description = "Equity (performance) leg") EquityLeg equityLeg,
        @SchemaField(description = "Payment & roll schedule") Schedule schedule,
        @SchemaField(description = "Dividend passthrough terms") DivPassthrough divPassthrough,
        @SchemaField(enumRef = "LEGAL_ENTITY", description = "Booking legal entity") String legalEntity,
        @SchemaField(enumRef = "WORKFLOW_STATUS", description = "Workflow state") String workflowStatus,
        @SchemaField(enumRef = "ROUTING_DESTINATION", description = "Downstream destination")
                String routingDestination) {}
