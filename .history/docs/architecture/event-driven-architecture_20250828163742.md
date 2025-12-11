# Event-Driven Architecture

## Overview
The Equity Swaps Lifecycle Management System follows an event-driven architecture pattern where all business operations are represented as domain events. This document describes the event flows, routing patterns, and event sourcing implementation.

## Event Architecture Principles

### 1. Event Sourcing
- All state changes are captured as events
- Current state can be reconstructed from event history
- Complete audit trail for compliance and debugging
- Event replay capability for testing and analysis

### 2. Event-Driven Communication
- Services communicate asynchronously through events
- Loose coupling between bounded contexts
- Scalable and resilient architecture
- Event ordering and consistency guarantees

### 3. CQRS Pattern
- Separate read and write models
- Write model: Event store and command processing
- Read model: Optimized views for queries
- Event-driven updates to read models

## Event Flow Architecture

```
┌─────────────────────────────────────────────────────────────────────────────────┐
│                              EVENT FLOW ARCHITECTURE                          │
├─────────────────────────────────────────────────────────────────────────────────┤
│                                                                                 │
│  ┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐            │
│  │ Trade Capture  │───▶│ Event Router    │───▶│ Contract Mgmt   │            │
│  │ Service        │    │                 │    │ Service         │            │
│  └─────────────────┘    └─────────────────┘    └─────────────────┘            │
│           │                       │                       │                    │
│           ▼                       ▼                       ▼                    │
│  ┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐            │
│  │ Event Store     │    │ Event Bus       │    │ Event Store     │            │
│  │ (Write Model)   │    │ (Kafka)         │    │ (Write Model)   │            │
│  └─────────────────┘    └─────────────────┘    └─────────────────┘            │
│           │                       │                       │                    │
│           ▼                       ▼                       ▼                    │
│  ┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐            │
│  │ Read Model      │    │ Event           │    │ Read Model      │            │
│  │ (PostgreSQL)    │    │ Processors      │    │ (PostgreSQL)    │            │
│  └─────────────────┘    └─────────────────┘    └─────────────────┘            │
│                                                                                 │
└─────────────────────────────────────────────────────────────────────────────────┘
```

## Core Event Types

### 1. Trade Events
```java
@CDMEntity(type = "BusinessEvent")
public abstract class TradeEvent extends DomainEvent {
    @CDMField(name = "tradeId")
    private String tradeId;
    
    @CDMField(name = "eventDate")
    private LocalDateTime eventDate;
    
    @CDMField(name = "effectiveDate")
    private LocalDateTime effectiveDate;
}

public class TradeCapturedEvent extends TradeEvent {
    private SwapBlotter blotter;
    private EnrichmentStatus enrichmentStatus;
}

public class TradeEnrichedEvent extends TradeEvent {
    private EnrichedContract enrichedContract;
    private List<EnrichmentRule> appliedRules;
}
```

### 2. Contract Events
```java
public class ContractCreatedEvent extends ContractEvent {
    private Contract contract;
    private List<Lot> initialLots;
}

public class ContractModifiedEvent extends ContractEvent {
    private ContractModification modification;
    private List<Lot> affectedLots;
}

public class LotAddedEvent extends ContractEvent {
    private Lot newLot;
    private Contract contract;
}

public class LotClosedEvent extends ContractEvent {
    private Lot closedLot;
    private LotClosingMethod closingMethod;
}
```

### 3. Position Events
```java
public class PositionUpdatedEvent extends PositionEvent {
    private Position position;
    private PositionChange change;
    private String reason;
}

public class PositionReconciledEvent extends PositionEvent {
    private Position reconciledPosition;
    private ReconciliationResult result;
}
```

### 4. Cashflow Events
```java
public class CashflowGeneratedEvent extends CashflowEvent {
    private Cashflow cashflow;
    private PaymentSchedule schedule;
}

public class CashflowPaidEvent extends CashflowEvent {
    private Payment payment;
    private PaymentStatus status;
}
```

## Event Routing Patterns

### 1. Direct Routing
```java
@Service
public class EventRouter {
    
    @EventListener
    public void routeTradeCapturedEvent(TradeCapturedEvent event) {
        if (event.getEnrichmentStatus() == EnrichmentStatus.SUCCESS) {
            // Route to Contract Management Service
            contractManagementService.handleTradeCaptured(event);
        } else {
            // Route to Manual Review Queue
            manualReviewService.queueForReview(event);
        }
    }
}
```

### 2. Topic-Based Routing
```java
@Component
public class KafkaEventRouter {
    
    @KafkaListener(topics = "trade.events")
    public void handleTradeEvents(TradeEvent event) {
        switch (event.getEventType()) {
            case TRADE_CAPTURED:
                routeToContractManagement(event);
                break;
            case TRADE_ENRICHED:
                routeToPositionManagement(event);
                break;
            case TRADE_VALIDATED:
                routeToCashflowManagement(event);
                break;
        }
    }
}
```

### 3. Event Sourcing Implementation
```java
@Service
public class EventSourcedContractService {
    
    private final EventStore eventStore;
    private final EventPublisher eventPublisher;
    
    public Contract createContract(CreateContractCommand command) {
        // Create contract aggregate
        Contract contract = Contract.create(command);
        
        // Store the event
        ContractCreatedEvent event = new ContractCreatedEvent(contract);
        eventStore.append(contract.getId(), event);
        
        // Publish the event
        eventPublisher.publish(event);
        
        return contract;
    }
    
    public Contract getContract(String contractId) {
        // Reconstruct from events
        List<DomainEvent> events = eventStore.getEvents(contractId);
        return Contract.reconstruct(events);
    }
}
```

## Event Flow Examples

### 1. New Trade Flow
```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│ Trade Capture  │───▶│ Event Router    │───▶│ Contract Mgmt   │
│ Service        │    │                 │    │ Service         │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         ▼                       ▼                       ▼
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│ TradeCaptured   │    │ Route to        │    │ ContractCreated │
│ Event           │    │ Contract Mgmt   │    │ Event           │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         ▼                       ▼                       ▼
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│ Event Store     │    │ Event Bus       │    │ Event Store     │
│ (Write Model)   │    │ (Kafka)         │    │ (Write Model)   │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         ▼                       ▼                       ▼
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│ Read Model      │    │ Event           │    │ Read Model      │
│ Update          │    │ Processors      │    │ Update          │
└─────────────────┘    └─────────────────┘    └─────────────────┘
```

### 2. Position Update Flow
```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│ Contract Mgmt   │───▶│ Event Bus       │───▶│ Position Mgmt   │
│ Service         │    │                 │    │ Service         │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         ▼                       ▼                       ▼
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│ LotAdded        │    │ Position        │    │ PositionUpdated │
│ Event           │    │ Topic           │    │ Event           │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         ▼                       ▼                       ▼
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│ Event Store     │    │ Event           │    │ Event Store     │
│ (Write Model)   │    │ Processors      │    │ (Write Model)   │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         ▼                       ▼                       ▼
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│ Read Model      │    │ Event           │    │ Read Model      │
│ Update          │    │ Processors      │    │ Update          │
└─────────────────┘    └─────────────────┘    └─────────────────┘
```

## Event Store Implementation

### 1. Event Store Interface
```java
public interface EventStore {
    void append(String aggregateId, DomainEvent event);
    List<DomainEvent> getEvents(String aggregateId);
    List<DomainEvent> getEvents(String aggregateId, long fromVersion);
    List<DomainEvent> getAllEvents();
    List<DomainEvent> getEventsByType(Class<?> eventType);
}
```

### 2. PostgreSQL Event Store
```java
@Service
public class PostgreSQLEventStore implements EventStore {
    
    private final JdbcTemplate jdbcTemplate;
    
    @Override
    public void append(String aggregateId, DomainEvent event) {
        String sql = """
            INSERT INTO events (aggregate_id, event_type, event_data, version, timestamp)
            VALUES (?, ?, ?, ?, ?)
            """;
        
        jdbcTemplate.update(sql,
            aggregateId,
            event.getClass().getSimpleName(),
            serializeEvent(event),
            event.getVersion(),
            event.getTimestamp()
        );
    }
    
    @Override
    public List<DomainEvent> getEvents(String aggregateId) {
        String sql = """
            SELECT event_type, event_data, version, timestamp
            FROM events
            WHERE aggregate_id = ?
            ORDER BY version
            """;
        
        return jdbcTemplate.query(sql, new EventRowMapper(), aggregateId);
    }
}
```

### 3. Event Schema
```sql
CREATE TABLE events (
    id BIGSERIAL PRIMARY KEY,
    aggregate_id VARCHAR(255) NOT NULL,
    event_type VARCHAR(255) NOT NULL,
    event_data JSONB NOT NULL,
    version BIGINT NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_events_aggregate_id ON events(aggregate_id);
CREATE INDEX idx_events_event_type ON events(event_type);
CREATE INDEX idx_events_timestamp ON events(timestamp);
```

## Event Processing Patterns

### 1. Event Handlers
```java
@Component
public class ContractEventHandler {
    
    @EventListener
    public void handleContractCreated(ContractCreatedEvent event) {
        // Update read model
        contractReadModel.updateContract(event.getContract());
        
        // Trigger downstream processes
        positionService.initializePosition(event.getContract());
        cashflowService.scheduleCashflows(event.getContract());
    }
    
    @EventListener
    public void handleLotAdded(LotAddedEvent event) {
        // Update position
        positionService.addLot(event.getLot());
        
        // Regenerate cashflows if needed
        if (event.getLot().requiresCashflowRegeneration()) {
            cashflowService.regenerateCashflows(event.getContract());
        }
    }
}
```

### 2. Saga Pattern Implementation
```java
@Component
public class TradeProcessingSaga {
    
    @EventListener
    public void startSaga(TradeCapturedEvent event) {
        // Step 1: Enrich trade
        enrichmentService.enrichTrade(event.getTradeId());
    }
    
    @EventListener
    public void handleTradeEnriched(TradeEnrichedEvent event) {
        // Step 2: Create contract
        contractService.createContract(event.getEnrichedContract());
    }
    
    @EventListener
    public void handleContractCreated(ContractCreatedEvent event) {
        // Step 3: Initialize position
        positionService.initializePosition(event.getContract());
        
        // Saga completed
        sagaCompleted(event.getContract().getId());
    }
    
    @EventListener
    public void handleEnrichmentFailed(TradeEnrichmentFailedEvent event) {
        // Compensate: Mark trade as failed
        tradeService.markTradeAsFailed(event.getTradeId(), event.getReason());
    }
}
```

## Event Monitoring and Observability

### 1. Event Metrics
```java
@Component
public class EventMetrics {
    
    private final MeterRegistry meterRegistry;
    
    @EventListener
    public void recordEvent(DomainEvent event) {
        Counter.builder("events.total")
            .tag("event.type", event.getClass().getSimpleName())
            .tag("event.source", event.getSource())
            .register(meterRegistry)
            .increment();
    }
    
    @EventListener
    public void recordEventProcessingTime(EventProcessingCompletedEvent event) {
        Timer.builder("events.processing.time")
            .tag("event.type", event.getEventType())
            .register(meterRegistry)
            .record(event.getProcessingTime());
    }
}
```

### 2. Event Tracing
```java
@Component
public class EventTracing {
    
    @EventListener
    public void traceEvent(DomainEvent event) {
        String traceId = MDC.get("traceId");
        if (traceId != null) {
            event.setTraceId(traceId);
        }
        
        log.info("Event traced: {} with traceId: {}", 
            event.getClass().getSimpleName(), event.getTraceId());
    }
}
```

## Event Versioning and Evolution

### 1. Event Versioning Strategy
```java
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "eventType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = TradeCapturedEventV1.class, name = "TradeCapturedEventV1"),
    @JsonSubTypes.Type(value = TradeCapturedEventV2.class, name = "TradeCapturedEventV2")
})
public abstract class VersionedEvent extends DomainEvent {
    private int eventVersion;
    private String eventSchema;
}
```

### 2. Event Migration
```java
@Component
public class EventMigrator {
    
    public DomainEvent migrateEvent(DomainEvent oldEvent, int targetVersion) {
        if (oldEvent.getEventVersion() == targetVersion) {
            return oldEvent;
        }
        
        // Apply migration logic
        return migrationRegistry.migrate(oldEvent, targetVersion);
    }
}
```

## Next Steps
1. Review [Entity Models](../domain/entity-models.md) for data structures
2. Examine [Service Architecture](../microservices/service-architecture.md) for implementation
3. Review [Trade Lifecycle](../business/trade-lifecycle.md) for business understanding
4. Begin with [Technology Stack](../implementation/technology-stack.md) for implementation details
