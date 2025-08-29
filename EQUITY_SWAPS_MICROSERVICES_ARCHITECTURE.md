# Equity Swaps Microservices Architecture

## Table of Contents
1. [Overview](#overview)
2. [Architecture Principles](#architecture-principles)
3. [Bounded Contexts](#bounded-contexts)
4. [CDM Alignment](#cdm-alignment)
5. [Entity Hierarchy](#entity-hierarchy)
6. [Event-Driven Architecture](#event-driven-architecture)
7. [Microservices Design](#microservices-design)
8. [Technology Stack](#technology-stack)
9. [Implementation Guidelines](#implementation-guidelines)
10. [Event Flow Diagrams](#event-flow-diagrams)
11. [Data Models](#data-models)
12. [API Specifications](#api-specifications)
13. [Deployment Strategy](#deployment-strategy)

## Overview

This document defines the comprehensive microservices architecture for an equity swaps platform that transforms cash trades into derivative contracts, manages positions, generates cashflows, and handles settlements while maintaining CDM (Common Domain Model) compliance.

### Key Architectural Decisions

1. **Trade Capture Transformation**: Cash trades are transformed into derivative contracts in the Trade Capture context
2. **Event-Driven Architecture**: All inter-service communication is event-based
3. **CDM Compliance**: All entities and events follow CDM primitives
4. **High-Volume Position Management**: Optimized for 800K positions from 80K contracts
5. **Basket Contract Modeling**: Basket contracts are modeled as multiple single stock contracts

## Architecture Principles

### 1. Domain-Driven Design (DDD)
- Clear bounded contexts with well-defined boundaries
- Ubiquitous language within each context
- Domain events for inter-context communication

### 2. Event-Driven Architecture
- Asynchronous communication between services
- Event sourcing for audit trails
- Loose coupling between contexts

### 3. CDM Compliance
- All entities map to CDM primitives
- Standardized event formats
- Regulatory compliance built-in

### 4. Scalability
- Independent scaling of services
- High-performance position management
- Event streaming for high throughput

## Bounded Contexts

### 1. Trade Capture & Enrichment Context
**Purpose**: Transform cash trades into derivative contracts

**Responsibilities**:
  - Raw trade ingestion and validation
  - Reference data enrichment
  - Economic rules application
  - Non-economic rules validation
  - Cash trade → Derivative trade transformation
  - Swap blotter creation

**Key Entities**:
- `SwapBlotter` (CDM Trade primitive)
- `RawTrade`
- `EnrichedTrade`
- `EconomicRulesResult`
- `NonEconomicRulesResult`

**Events**:
- `TradeCaptured`
- `SwapBlotterCreated`

### 2. Contract & Position Management Context
**Purpose**: Manage contracts, lots, and positions

**Responsibilities**:
- Contract creation from swap blotters
- Lot management and adjustment
- Position aggregation and reconciliation
- High-volume position storage (800K positions)
- Contract lifecycle management

**Key Entities**:
- `Contract` (CDM Contract primitive)
- `Leg` (CDM Leg primitive)
- `Underlier` (CDM Underlier primitive)
- `Lot` (CDM Lot primitive)
- `Position` (CDM Position primitive)

**Events**:
- `ContractCreated`
- `ContractUpdated`
- `LotAdjusted`
- `PositionUpdated`

### 3. Cashflow Generation Context
**Purpose**: Generate and manage cashflows

**Responsibilities**:
- Equity dividend cashflow generation
- Interest payment cashflow generation
- Margin call cashflow generation
- Payment schedule management
- Cashflow regeneration on contract changes

**Key Entities**:
- `Cashflow` (CDM Cashflow primitive)
- `PaymentSchedule` (CDM Schedule primitive)
- `DividendSchedule`
- `RateSchedule`

**Events**:
- `CashflowGenerated`
- `CashflowRegenerated`
- `PaymentScheduled`

### 4. Settlement Context
**Purpose**: Handle settlement and payment processing

**Responsibilities**:
- Settlement instruction generation
- Settlement confirmation processing
- Payment execution
- Settlement reconciliation
- Settlement reporting

**Key Entities**:
- `Settlement` (CDM Settlement primitive)
- `SettlementInstructions`
- `Payment`
- `SettlementConfirmation`

**Events**:
- `SettlementCreated`
- `SettlementConfirmed`
- `PaymentExecuted`

### 5. Risk Management Context
**Purpose**: Calculate and monitor risk metrics

**Responsibilities**:
- Exposure calculation
- VaR calculation
- Stress testing
- Risk limit monitoring
- Risk reporting

**Key Entities**:
- `RiskExposure`
- `VaRCalculation`
- `StressTestResult`
- `RiskLimit`

**Events**:
- `RiskCalculated`
- `RiskLimitBreached`
- `StressTestCompleted`

### 6. Pricing Context
**Purpose**: Handle valuations and pricing

**Responsibilities**:
- Mark-to-market calculations
- Present value calculations
- Valuation adjustments (CVA, DVA, FVA)
- Pricing model management

**Key Entities**:
- `Valuation`
- `PricingModel`
- `MarketData`
- `ValuationAdjustment`

**Events**:
- `ValuationUpdated`
- `PricingModelUpdated`
- `MarketDataUpdated`

### 7. Reference Data Context
**Purpose**: Manage reference data

**Responsibilities**:
- Instrument reference data
- Counterparty reference data
- Venue and market data
- Regulatory reference data

**Key Entities**:
- `Instrument`
- `Counterparty`
- `Venue`
- `ReferenceData`

**Events**:
- `ReferenceDataUpdated`
- `InstrumentCreated`
- `CounterpartyUpdated`

### 8. Event Routing & Orchestration Service
**Purpose**: Route events between contexts

**Responsibilities**:
- Event routing rules
- Event transformation and enrichment
- Event correlation and sequencing
- Dead letter queue management

**Key Entities**:
- `EventRoute`
- `EventTransformation`
- `EventCorrelation`

**Events**:
- `EventRouted`
- `EventTransformed`

### 9. Execution Management Service
**Purpose**: Manage trade execution

**Responsibilities**:
- Execution orchestration
- Execution state management
- Execution failure handling
- Execution monitoring

**Key Entities**:
- `Execution`
- `ExecutionState`
- `ExecutionResult`

**Events**:
- `ExecutionStarted`
- `ExecutionCompleted`
- `ExecutionFailed`

## CDM Alignment

### Entity Mapping to CDM Primitives

| Our Entity | CDM Primitive | Description |
|------------|---------------|-------------|
| SwapBlotter | Trade | Trade representation |
| Contract | Contract | Contract representation |
| Leg | Leg | Contract leg |
| Underlier | Underlier | Underlying instrument |
| Lot | Lot | Trade lot |
| Position | Position | Position representation |
| Cashflow | Cashflow | Cashflow representation |
| Settlement | Settlement | Settlement representation |
| Event | Event | All events |

### CDM Event Types

```java
@CDMEntity(type = "Event")
public abstract class CDMEvent {
    @CDMField(name = "eventId")
    private String eventId;
    
    @CDMField(name = "eventType")
    private String eventType;
    
    @CDMField(name = "eventTimestamp")
    private LocalDateTime timestamp;
    
    @CDMField(name = "correlationId")
    private String correlationId;
    
    @CDMField(name = "eventData")
    private Map<String, Object> eventData;
}
```

## Entity Hierarchy

### Contract Hierarchy
```
Contract
├── EquityLeg
│   ├── Underlier (Single Stock/Index/Basket)
│   │   ├── Single Stock
│   │   │   └── Lots (Trades: New/Increase/Decrease/Close)
│   │   ├── Index
│   │   └── Basket
│   │       └── Multiple Single Stock Contracts
├── InterestLeg
└── Contract Terms
```

### Basket Contract Modeling
```
Basket Contract = Multiple Single Stock Contracts
├── Contract A: AAPL (1000 shares)
├── Contract B: MSFT (2000 shares)
├── Contract C: GOOGL (1500 shares)
└── Contract D: AMZN (3000 shares)
```

## Event-Driven Architecture

### Event Flow Overview
```
Trade Capture → Contract Management → Cashflow Generation → Settlement → Downstream Contexts
     ↓              ↓                    ↓                    ↓              ↓
Trade Event → Contract Event → Cashflow Event → Settlement Event → Risk/Regulatory Events
```

### Event Types by Context

#### Trade Capture Events
- `TradeCaptured`: Raw trade received
- `SwapBlotterCreated`: Derivative blotter created

#### Contract Management Events
- `ContractCreated`: New contract created
- `ContractUpdated`: Contract updated
- `LotAdjusted`: Lots adjusted
- `PositionUpdated`: Position updated

#### Cashflow Events
- `CashflowGenerated`: New cashflow generated
- `CashflowRegenerated`: Cashflow regenerated
- `PaymentScheduled`: Payment scheduled

#### Settlement Events
- `SettlementCreated`: Settlement created
- `SettlementConfirmed`: Settlement confirmed
- `PaymentExecuted`: Payment executed

#### Scheduled Events
- `MarketPriceEvent`: Market price update
- `ResetEvent`: Rate reset
- `EODValuationEvent`: End-of-day valuation

### Event Routing Rules

```yaml
Event Routing Configuration:
  TradeCaptured:
    - route_to: ContractManagement
    - route_to: RiskManagement
  
  ContractCreated:
    - route_to: CashflowGeneration
    - route_to: RiskManagement
    - route_to: PricingContext
  
  PositionUpdated:
    - route_to: RiskManagement
    - route_to: PricingContext
    - route_to: RegulatoryReporting
  
  CashflowGenerated:
    - route_to: SettlementContext
    - route_to: RiskManagement
  
  MarketPriceEvent:
    - route_to: PricingContext
    - route_to: RiskManagement
  
  ResetEvent:
    - route_to: CashflowGeneration
    - route_to: PricingContext
    - route_to: RiskManagement
```

## Microservices Design

### Service Architecture Pattern

Each bounded context is implemented as a separate microservice with the following components:

1. **API Gateway**: External interface
2. **Service Layer**: Business logic
3. **Data Layer**: Data persistence
4. **Event Layer**: Event publishing/consuming
5. **Integration Layer**: External system integration

### Service Communication

#### Synchronous Communication
- REST APIs for external clients
- gRPC for inter-service communication
- GraphQL for complex queries

#### Asynchronous Communication
- Apache Kafka for event streaming
- Event sourcing for audit trails
- CQRS for read/write separation

### Data Management

#### Database Strategy
- **Contract Management**: PostgreSQL with event sourcing
- **Position Management**: TimescaleDB for time-series data
- **Cashflow Management**: PostgreSQL with scheduling
- **Risk Management**: ClickHouse for analytics
- **Reference Data**: Redis for caching, PostgreSQL for persistence

#### Event Store
- Apache Kafka for event streaming
- Event sourcing for audit trails
- CQRS for read/write separation

## Technology Stack

### Core Technologies
- **Language**: Java 17 with Spring Boot 3.x
- **Database**: PostgreSQL, TimescaleDB, ClickHouse, Redis
- **Message Broker**: Apache Kafka
- **API Gateway**: Spring Cloud Gateway
- **Service Discovery**: Consul
- **Configuration**: Spring Cloud Config
- **Monitoring**: Prometheus + Grafana
- **Logging**: ELK Stack (Elasticsearch, Logstash, Kibana)

### CDM Implementation
- **CDM Library**: FpML CDM Java library
- **Validation**: CDM schema validation
- **Serialization**: JSON/XML serialization

### High-Performance Components
- **Position Storage**: TimescaleDB for time-series
- **Caching**: Redis for hot data
- **Streaming**: Apache Kafka for events
- **Analytics**: ClickHouse for risk analytics

## Implementation Guidelines

### 1. Service Implementation Pattern

```java
@SpringBootApplication
@EnableEventSourcing
@EnableCQRS
public class TradeCaptureServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TradeCaptureServiceApplication.class, args);
    }
}

@Service
@Transactional
public class TradeCaptureService {
    
    private final EventPublisher eventPublisher;
    private final TradeRepository tradeRepository;
    private final EnrichmentService enrichmentService;
    
    public SwapBlotterCreatedEvent processCashTrade(RawTrade rawTrade) {
        // 1. Validate trade
        TradeDetails validatedTrade = validateTrade(rawTrade);
        
        // 2. Enrich with reference data
        EnrichedTrade enrichedTrade = enrichmentService.enrich(validatedTrade);
        
        // 3. Apply economic rules
        EconomicRulesResult economicResult = applyEconomicRules(enrichedTrade);
        
        // 4. Apply non-economic rules
        NonEconomicRulesResult nonEconomicResult = applyNonEconomicRules(enrichedTrade);
        
        // 5. Transform to derivative
        SwapBlotter derivativeBlotter = transformToDerivative(
            enrichedTrade, economicResult, nonEconomicResult);
        
        // 6. Save and publish event
        tradeRepository.save(derivativeBlotter);
        eventPublisher.publish(new SwapBlotterCreatedEvent(derivativeBlotter));
        
        return new SwapBlotterCreatedEvent(derivativeBlotter);
    }
}
```

### 2. Event Handling Pattern

```java
@Component
public class ContractEventHandler {
    
    private final ContractService contractService;
    private final PositionService positionService;
    
    @EventListener
    public void handleSwapBlotterCreated(SwapBlotterCreatedEvent event) {
        // Create contract from blotter
        Contract contract = contractService.createContract(event.getBlotter());
        
        // Create initial lots
        List<Lot> lots = createInitialLots(contract);
        
        // Update position
        Position position = positionService.updatePosition(contract, lots);
        
        // Publish events
        eventPublisher.publish(new ContractCreatedEvent(contract));
        eventPublisher.publish(new PositionUpdatedEvent(position));
    }
}
```

### 3. CDM Compliance Pattern

```java
@CDMEntity(type = "Trade")
public class SwapBlotter {
    @CDMField(name = "tradeId")
    private String blotterId;
    
    @CDMField(name = "tradeDate")
    private LocalDateTime tradeDate;
    
    @CDMField(name = "tradeState")
    private TradeState state;
    
    @CDMField(name = "economicTerms")
    private EconomicTerms economicTerms;
    
    // CDM validation
    @PostConstruct
    public void validateCDM() {
        CDMValidator.validate(this);
    }
}
```

### 4. High-Performance Position Management

```java
@Service
public class PositionService {
    
    private final PositionRepository positionRepository;
    private final CacheManager cacheManager;
    
    public Position updatePosition(String contractId, List<Lot> lots) {
        // Update in high-performance database
        Position position = positionRepository.updatePosition(contractId, lots);
        
        // Update cache for hot positions
        cacheManager.put("position:" + contractId, position);
        
        return position;
    }
    
    public Position getPosition(String contractId) {
        // Check cache first
        Position cached = cacheManager.get("position:" + contractId);
        if (cached != null) {
            return cached;
        }
        
        // Query database
        Position position = positionRepository.findByContractId(contractId);
        
        // Cache result
        cacheManager.put("position:" + contractId, position);
        
        return position;
    }
}
```

## Event Flow Diagrams

### 1. Trade Processing Flow
```
Raw Trade → Validation → Enrichment → Economic Rules → Non-Economic Rules → Transformation → Swap Blotter
     ↓           ↓           ↓              ↓              ↓              ↓              ↓
Trade Event → Validated → Enriched → Economic Applied → Non-Economic Applied → Transformed → Blotter Created
```

### 2. Contract Creation Flow
```
Swap Blotter → Contract Creation → Lot Creation → Position Update → Cashflow Generation
     ↓              ↓                ↓              ↓                ↓
Blotter Event → Contract Created → Lots Created → Position Updated → Cashflows Generated
```

### 3. Scheduled Event Flow
```
Market Price → Pricing Update → Position Update → Risk Recalculation → Regulatory Update
     ↓              ↓              ↓                ↓                    ↓
Price Event → Valuation Updated → Position Updated → Risk Calculated → Regulatory Reported
```

## Data Models

### Core CDM Entities

#### SwapBlotter (CDM Trade)
```java
@CDMEntity(type = "Trade")
public class SwapBlotter {
    private String blotterId;
    private LocalDateTime tradeDate;
    private TradeState state;
    private TradeType type;
    private Counterparty counterparty;
    private EconomicTerms economicTerms;
    private ValidationStatus validationStatus;
    private EnrichmentStatus enrichmentStatus;
    private List<AppliedRule> appliedRules;
}
```

#### Contract (CDM Contract)
```java
@CDMEntity(type = "Contract")
public class Contract {
    private String contractId;
    private String blotterId;
    private ContractState state;
    private ContractType type;
    private LegalAgreement legalAgreement;
    private EconomicTerms economicTerms;
    private List<Leg> legs;
    private ContractLifecycle lifecycle;
}
```

#### Position (CDM Position)
```java
@CDMEntity(type = "Position")
public class Position {
    private String positionId;
    private String contractId;
    private String underlierId;
    private double netQuantity;
    private BigDecimal averagePrice;
    private BigDecimal marketValue;
    private BigDecimal unrealizedPnL;
    private PositionState state;
    private LocalDateTime lastUpdateTime;
}
```

#### Cashflow (CDM Cashflow)
```java
@CDMEntity(type = "Cashflow")
public class Cashflow {
    private String cashflowId;
    private String contractId;
    private String legId;
    private CashflowType type;
    private PaymentDirection direction;
    private BigDecimal amount;
    private String currency;
    private LocalDate paymentDate;
    private LocalDate calculationDate;
    private CashflowState state;
    private Underlier underlier;
    private CalculationMethod calculationMethod;
}
```

## API Specifications

### Trade Capture API
```yaml
POST /api/v1/trades
Content-Type: application/json

{
  "tradeId": "string",
  "tradeDate": "2024-01-15T10:30:00Z",
  "counterparty": "string",
  "underlier": "string",
  "quantity": 1000,
  "price": 150.50,
  "tradeType": "CASH_TRADE"
}

Response:
{
  "blotterId": "string",
  "status": "CREATED",
  "validationStatus": "VALIDATED",
  "enrichmentStatus": "COMPLETED"
}
```

### Contract Management API
```yaml
GET /api/v1/contracts/{contractId}
Response:
{
  "contractId": "string",
  "state": "ACTIVE",
  "type": "EQUITY_SWAP",
  "legs": [...],
  "position": {...}
}

POST /api/v1/contracts/{contractId}/lots
{
  "operation": "INCREASE",
  "quantity": 500,
  "price": 155.00
}
```

### Position API
```yaml
GET /api/v1/positions/{contractId}
Response:
{
  "contractId": "string",
  "underlierId": "string",
  "netQuantity": 1500,
  "averagePrice": 152.75,
  "marketValue": 229125.00,
  "unrealizedPnL": 4125.00
}
```

## Deployment Strategy

### 1. Containerization
- Docker containers for each service
- Kubernetes for orchestration
- Helm charts for deployment

### 2. Service Mesh
- Istio for service-to-service communication
- Circuit breakers and retry policies
- Traffic management and load balancing

### 3. Monitoring & Observability
- Distributed tracing with Jaeger
- Metrics collection with Prometheus
- Log aggregation with ELK Stack
- Health checks and alerting

### 4. Security
- OAuth2/JWT for authentication
- mTLS for service-to-service communication
- Secrets management with HashiCorp Vault
- Network policies and RBAC

### 5. Scalability
- Horizontal scaling with Kubernetes
- Auto-scaling based on metrics
- Database sharding for high volume
- Caching strategies for performance

## Implementation Roadmap

### Phase 1: Core Services
1. Trade Capture Service
2. Contract Management Service
3. Event Routing Service
4. Basic event flow

### Phase 2: Business Services
1. Cashflow Generation Service
2. Settlement Service
3. Position Management Service
4. Reference Data Service

### Phase 3: Analytics Services
1. Risk Management Service
2. Pricing Service
3. Regulatory Reporting Service
4. Advanced monitoring

### Phase 4: Optimization
1. Performance optimization
2. High availability setup
3. Disaster recovery
4. Advanced analytics

This comprehensive architecture provides a solid foundation for building a scalable, maintainable, and CDM-compliant equity swaps platform. 