# Bounded Contexts - Domain-Driven Design

## Overview
This document defines the bounded contexts for the Equity Swaps Lifecycle Management System. Each bounded context represents a cohesive domain with clear boundaries and responsibilities.

## Bounded Context Map

```
┌─────────────────────────────────────────────────────────────────────────────────┐
│                              BOUNDED CONTEXTS                                  │
├─────────────────────────────────────────────────────────────────────────────────┤
│                                                                                 │
│  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────────┐                │
│  │ Trade Capture  │  │ Contract        │  │ Position       │                │
│  │ & Enrichment   │  │ Lifecycle       │  │ Management     │                │
│  │ Context        │  │ Management      │  │ Context        │                │
│  └─────────────────┘  └─────────────────┘  └─────────────────┘                │
│           │                     │                     │                        │
│           ▼                     ▼                     ▼                        │
│  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────────┐                │
│  │ Cashflow        │  │ Risk            │  │ Settlement     │                │
│  │ Management      │  │ Management      │  │ Management     │                │
│  │ Context         │  │ Context         │  │ Context        │                │
│  └─────────────────┘  └─────────────────┘  └─────────────────┘                │
│                                                                                 │
│  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────────┐                │
│  │ Reference Data  │  │ Market Data     │  │ Regulatory     │                │
│  │ Context         │  │ Context         │  │ Reporting      │                │
│  │                 │  │                 │  │ Context        │                │
│  └─────────────────┘  └─────────────────┘  └─────────────────┘                │
│                                                                                 │
└─────────────────────────────────────────────────────────────────────────────────┘
```

## 1. Trade Capture & Enrichment Context

### **Boundary**
- **Input**: Raw trade data from trading platforms
- **Output**: Enriched Swap Blotter with CDM-compliant structure
- **Responsibility**: Trade validation, enrichment, and transformation

### **Core Responsibilities**
- **Trade Ingestion**: Receive and validate raw trade data
- **Economic Rules Enrichment**: Apply margin, collateral, and pricing rules
- **Non-Economic Rules**: Apply compliance, regulatory, and legal rules
- **Reference Data Enrichment**: Enrich counterparty, instrument, and venue data
- **Cash-to-Derivative Transformation**: Transform cash trades to derivative structures
- **Swap Blotter Creation**: Generate CDM-compliant swap blotter

### **Key Entities**
- `RawTrade` - Incoming trade data
- `SwapBlotter` - Enriched trade representation
- `EnrichmentRule` - Business rules for enrichment
- `ReferenceData` - External reference information

### **Business Rules**
- All trades must pass economic and non-economic validation
- Reference data must be complete before enrichment
- Transformation rules must be configurable and auditable
- Failed enrichments must be flagged for manual review

## 2. Contract Lifecycle Management Context

### **Boundary**
- **Input**: Swap Blotter from Trade Capture
- **Output**: Active contracts with lifecycle state
- **Responsibility**: Contract creation, modification, and lifecycle management

### **Core Responsibilities**
- **Contract Formation**: Create new contracts from blotter data
- **Contract Operations**: Handle increases, decreases, and modifications
- **Lot Management**: Track individual trade lots within contracts
- **Lifecycle Events**: Manage contract state transitions
- **Amendment Processing**: Handle contract modifications and novations
- **Contract Termination**: Process maturity and early termination

### **Key Entities**
- `Contract` - Master contract entity
- `EquityLeg` - Equity component of the swap
- `InterestLeg` - Interest rate component
- `Lot` - Individual trade lot
- `Underlier` - Underlying equity instrument

### **Business Rules**
- Contracts must maintain lot-level granularity
- All modifications must preserve audit trail
- Basket contracts are modeled as multiple single-stock contracts
- Lifecycle events must trigger downstream notifications

## 3. Position Management Context

### **Boundary**
- **Input**: Contract events and lot changes
- **Output**: Real-time position data and analytics
- **Responsibility**: Position tracking, aggregation, and reporting

### **Core Responsibilities**
- **Position Tracking**: Real-time position updates
- **Position Aggregation**: Net positions across contracts and underliers
- **Position Reconciliation**: Ensure accuracy across systems
- **Position Reporting**: Regulatory and internal reporting
- **P&L Calculation**: Real-time profit/loss tracking

### **Key Entities**
- `Position` - Current position for an underlier
- `PositionHistory` - Historical position changes
- `PositionAggregation` - Aggregated position views
- `P&L` - Profit/loss calculations

### **Business Rules**
- Positions must be updated in real-time
- Aggregation must handle basket and index positions
- Historical positions must be preserved for audit
- P&L calculations must be accurate and timely

## 4. Cashflow Management Context

### **Boundary**
- **Input**: Contract events and market data
- **Output**: Scheduled and generated cashflows
- **Responsibility**: Cashflow generation, scheduling, and management

### **Core Responsibilities**
- **Cashflow Generation**: Generate cashflows based on contract terms
- **Payment Scheduling**: Schedule future payments
- **Cashflow Calculation**: Calculate amounts based on market data
- **Cashflow Adjustment**: Handle corporate actions and resets
- **Payment Processing**: Interface with settlement systems

### **Key Entities**
- `Cashflow` - Individual cashflow event
- `PaymentSchedule` - Scheduled payment timeline
- `CashflowRule` - Rules for cashflow generation
- `Payment` - Actual payment execution

### **Business Rules**
- Cashflows must be generated automatically
- All cashflows must be auditable
- Adjustments must preserve payment history
- Failed payments must be flagged for investigation

## 5. Risk Management Context

### **Boundary**
- **Input**: Position data, market data, and contract terms
- **Output**: Risk metrics and limits monitoring
- **Responsibility**: Risk calculation, monitoring, and reporting

### **Core Responsibilities**
- **Risk Calculation**: Calculate VaR, stress tests, and other metrics
- **Limit Monitoring**: Monitor risk limits and breaches
- **Collateral Management**: Track collateral requirements
- **Exposure Calculation**: Calculate counterparty exposures
- **Risk Reporting**: Generate risk reports for stakeholders

### **Key Entities**
- `RiskMetric` - Calculated risk measures
- `RiskLimit` - Risk limits and thresholds
- `Collateral` - Collateral requirements and postings
- `Exposure` - Counterparty exposure calculations

### **Business Rules**
- Risk calculations must be real-time
- Limit breaches must trigger immediate alerts
- All risk metrics must be auditable
- Risk models must be validated and back-tested

## 6. Settlement Management Context

### **Boundary**
- **Input**: Cashflows and payment instructions
- **Output**: Settlement confirmations and status
- **Responsibility**: Payment execution and settlement processing

### **Core Responsibilities**
- **Payment Execution**: Execute payments through settlement systems
- **Settlement Confirmation**: Confirm successful settlements
- **Failed Payment Handling**: Process failed payments and retries
- **Settlement Reporting**: Generate settlement reports
- **Reconciliation**: Reconcile with external settlement systems

### **Key Entities**
- `Settlement` - Settlement transaction
- `PaymentInstruction` - Payment instruction details
- `SettlementStatus` - Current settlement status
- `Reconciliation` - Settlement reconciliation data

### **Business Rules**
- All payments must be confirmed
- Failed payments must be investigated promptly
- Settlement reports must be generated daily
- Reconciliation must be performed automatically

## 7. Reference Data Context

### **Boundary**
- **Input**: External reference data sources
- **Output**: Standardized reference data
- **Responsibility**: Reference data management and distribution

### **Core Responsibilities**
- **Data Ingestion**: Ingest data from external sources
- **Data Standardization**: Standardize data formats
- **Data Validation**: Validate data quality and completeness
- **Data Distribution**: Distribute data to consuming services
- **Data Maintenance**: Maintain data accuracy and timeliness

### **Key Entities**
- `Counterparty` - Trading counterparty information
- `Instrument` - Financial instrument details
- `Venue` - Trading venue information
- `Currency` - Currency and exchange rate data

### **Business Rules**
- All reference data must be validated
- Data updates must be distributed in real-time
- Historical data must be preserved
- Data quality metrics must be monitored

## 8. Market Data Context

### **Boundary**
- **Input**: External market data feeds
- **Output**: Processed market data for internal use
- **Responsibility**: Market data processing and distribution

### **Core Responsibilities**
- **Data Ingestion**: Receive market data from providers
- **Data Processing**: Process and normalize market data
- **Data Distribution**: Distribute data to consuming services
- **Data Quality**: Monitor data quality and availability
- **Historical Data**: Maintain historical market data

### **Key Entities**
- `MarketPrice` - Current market prices
- `MarketData` - Processed market data
- `DataFeed` - Market data feed configuration
- `DataQuality` - Data quality metrics

### **Business Rules**
- Market data must be real-time
- Data quality must be continuously monitored
- Historical data must be preserved
- Failed feeds must be handled gracefully

## 9. Regulatory Reporting Context

### **Boundary**
- **Input**: Trade, position, and cashflow data
- **Output**: Regulatory reports and submissions
- **Responsibility**: Regulatory compliance and reporting

### **Core Responsibilities**
- **Report Generation**: Generate required regulatory reports
- **Data Validation**: Validate data for regulatory compliance
- **Report Submission**: Submit reports to regulatory bodies
- **Compliance Monitoring**: Monitor compliance with regulations
- **Audit Support**: Support regulatory audits and inquiries

### **Key Entities**
- `RegulatoryReport` - Generated regulatory report
- `ComplianceRule` - Regulatory compliance rules
- `Submission` - Report submission details
- `AuditTrail` - Compliance audit trail

### **Business Rules**
- All reports must be generated on time
- Data must be validated before submission
- Submissions must be confirmed
- Audit trails must be complete

## Context Integration Patterns

### 1. Event-Driven Communication
- Services communicate through domain events
- Loose coupling between contexts
- Asynchronous processing for scalability

### 2. Shared Kernel
- Common CDM models shared across contexts
- Standardized event structures
- Consistent data formats

### 3. Anti-Corruption Layer
- External system integration
- Data transformation and validation
- Protocol translation

### 4. Open Host Service
- Standardized APIs for external consumption
- Version management and backward compatibility
- Documentation and testing support

## Next Steps
1. Review [Event-Driven Architecture](event-driven-architecture.md) for event flows
2. Examine [Entity Models](../domain/entity-models.md) for data structures
3. Review [Service Architecture](../microservices/service-architecture.md) for implementation
4. Begin with [Trade Lifecycle](../business/trade-lifecycle.md) for business understanding
