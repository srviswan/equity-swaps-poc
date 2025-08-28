# Data Flow Diagrams

## Overview

This document provides comprehensive data flow diagrams for the Cash Flow Generation Service, illustrating the various processing workflows, thread partitioning strategies, and reactive processing patterns.

## Cashflow Generation Flow

### **1. High-Level Cashflow Generation Process**

```mermaid
flowchart TD
    A[Client Request] --> B[API Gateway]
    B --> C[Cashflow Controller]
    C --> D[Cashflow Generation Service]
    D --> E[Thread Partition Manager]
    E --> F[Interest Calculation Service]
    E --> G[Equity Calculation Service]
    
    F --> H[Interest Partition]
    G --> I[Equity Partition]
    
    H --> J[Database Operations]
    I --> J
    
    J --> K[Event Publishing]
    K --> L[Kafka Topics]
    L --> M[Downstream Services]
    
    J --> N[Response to Client]
    
    style A fill:#e1f5fe
    style N fill:#e8f5e8
    style H fill:#fff3e0
    style I fill:#fff3e0
    style L fill:#f3e5f5
```

### **2. Detailed Cashflow Generation Flow**

```mermaid
sequenceDiagram
    participant Client
    participant API
    participant Service
    participant Partition
    participant Interest
    participant Equity
    participant Database
    participant Kafka
    participant Cache
    
    Client->>API: POST /cashflows/generate
    API->>Service: Process Request
    
    Service->>Cache: Check Contract Data
    alt Cache Hit
        Cache-->>Service: Return Cached Data
    else Cache Miss
        Service->>Database: Fetch Contract Data
        Database-->>Service: Return Contract Data
        Service->>Cache: Store in Cache
    end
    
    Service->>Partition: Submit Interest Calculations
    Partition->>Interest: Process in Interest Partition
    
    Service->>Partition: Submit Equity Calculations
    Partition->>Equity: Process in Equity Partition
    
    Interest->>Database: Save Interest Cashflows
    Equity->>Database: Save Equity Cashflows
    
    Service->>Kafka: Publish Cashflow Events
    Service->>API: Return Generation Results
    API->>Client: HTTP 200 Response
```

## Thread Partitioning Flow

### **1. Partition Key Generation and Assignment**

```mermaid
flowchart TD
    A[Cashflow Operation] --> B[Extract Contract ID]
    A --> C[Extract Security ID]
    A --> D[Determine Calculation Type]
    
    B --> E[Thread Partition Key]
    C --> E
    D --> E
    
    E --> F{Partition Exists?}
    
    F -->|Yes| G[Use Existing Partition]
    F -->|No| H[Create New Partition]
    
    H --> I[Allocate Virtual Thread]
    I --> J[Initialize Partition Executor]
    J --> K[Register Partition]
    
    G --> L[Submit to Partition]
    K --> L
    
    L --> M[Execute in Partition Thread]
    M --> N[Return Result]
    
    style E fill:#fff3e0
    style F fill:#ffebee
    style L fill:#e8f5e8
```

### **2. Partition Execution Flow**

```mermaid
sequenceDiagram
    participant Request
    participant PartitionService
    participant ThreadExecutor
    participant VirtualThread
    participant Database
    participant Cache
    participant Metrics
    
    Request->>PartitionService: Submit Operation
    PartitionService->>PartitionService: Generate Partition Key
    PartitionService->>ThreadExecutor: Get/Create Partition
    
    alt New Partition
        ThreadExecutor->>ThreadExecutor: Create Virtual Thread
        ThreadExecutor->>ThreadExecutor: Initialize Executor
    end
    
    ThreadExecutor->>VirtualThread: Assign Operation
    VirtualThread->>Cache: Check Cache
    VirtualThread->>Database: Execute Operation
    
    Database-->>VirtualThread: Return Result
    VirtualThread->>Metrics: Update Metrics
    VirtualThread->>ThreadExecutor: Complete Operation
    
    ThreadExecutor->>PartitionService: Return Result
    PartitionService->>Request: Operation Complete
```

## Interest Calculation Flow

### **1. Daily Interest Accrual Process**

```mermaid
flowchart TD
    A[Scheduled Job] --> B[Get Active Contracts]
    B --> C[Group by Contract + Security]
    C --> D[Create Interest Partitions]
    
    D --> E[Process Each Partition]
    E --> F[Calculate Daily Accrual]
    F --> G[Apply Business Rules]
    G --> H[Validate Calculations]
    
    H --> I{Validation Pass?}
    I -->|Yes| J[Save Accrual]
    I -->|No| K[Log Error & Skip]
    
    J --> L[Update Cumulative Amount]
    L --> M[Publish Accrual Event]
    M --> N[Update Metrics]
    
    style A fill:#e1f5fe
    style J fill:#e8f5e8
    style K fill:#ffebee
    style M fill:#f3e5f5
```

### **2. Interest Rate Reset Process**

```mermaid
sequenceDiagram
    participant Scheduler
    participant InterestService
    participant Partition
    participant RateService
    participant Database
    participant Kafka
    
    Scheduler->>InterestService: Rate Reset Trigger
    InterestService->>RateService: Get New Rates
    RateService-->>InterestService: Return Rates
    
    InterestService->>Partition: Submit Rate Updates
    Partition->>Database: Update Contract Rates
    Database-->>Partition: Confirmation
    
    Partition->>Database: Recalculate Accruals
    Database-->>Partition: Updated Accruals
    
    Partition->>Kafka: Publish Rate Reset Event
    InterestService->>Scheduler: Reset Complete
```

## Equity Calculation Flow

### **1. Market Data Update Process**

```mermaid
flowchart TD
    A[Market Data Feed] --> B[Market Data Service]
    B --> C[Identify Affected Contracts]
    C --> D[Group by Security ID]
    
    D --> E[Create Equity Partitions]
    E --> F[Process Price Updates]
    F --> G[Calculate P&L Changes]
    
    G --> H[Apply Corporate Actions]
    H --> I[Update Dividend Calculations]
    I --> J[Validate Results]
    
    J --> K{Validation Pass?}
    K -->|Yes| L[Save P&L Updates]
    K -->|No| M[Log Error & Alert]
    
    L --> N[Publish P&L Event]
    N --> O[Update Risk Metrics]
    
    style A fill:#e1f5fe
    style L fill:#e8f5e8
    style M fill:#ffebee
    style N fill:#f3e5f5
```

### **2. End-of-Day Valuation Process**

```mermaid
sequenceDiagram
    participant MarketClose
    participant ValuationService
    participant Partition
    participant MarketData
    participant Database
    participant RiskService
    
    MarketClose->>ValuationService: EOD Trigger
    ValuationService->>MarketData: Get Closing Prices
    MarketData-->>ValuationService: Return Prices
    
    ValuationService->>Partition: Submit EOD Valuations
    Partition->>Database: Calculate Final P&L
    Database-->>Partition: P&L Results
    
    Partition->>Database: Update Cashflow Status
    Database-->>Partition: Status Updated
    
    Partition->>RiskService: Send Risk Data
    ValuationService->>MarketClose: EOD Complete
```

## Reactive Processing Flow

### **1. High-Volume Batch Processing**

```mermaid
flowchart TD
    A[Batch Request] --> B[Reactive Controller]
    B --> C[Backpressure Buffer]
    C --> D[Group by Partition]
    
    D --> E[Process Partitions]
    E --> F[Interest Calculations]
    E --> G[Equity Calculations]
    
    F --> H[Database Operations]
    G --> H
    
    H --> I[Event Publishing]
    I --> J[Kafka Topics]
    
    H --> K[Response Stream]
    K --> L[Client]
    
    style A fill:#e1f5fe
    style C fill:#fff3e0
    style H fill:#e8f5e8
    style K fill:#f3e5f5
```

### **2. Real-Time Stream Processing**

```mermaid
sequenceDiagram
    participant MarketData
    participant StreamProcessor
    participant Partition
    participant Database
    participant EventStream
    participant Client
    
    MarketData->>StreamProcessor: Price Update
    StreamProcessor->>StreamProcessor: Filter Relevant Updates
    StreamProcessor->>Partition: Submit to Partition
    
    Partition->>Database: Process Update
    Database-->>Partition: Return Result
    
    Partition->>EventStream: Publish Event
    EventStream->>Client: Stream Update
    
    StreamProcessor->>MarketData: Processing Complete
```

## State Transition Flow

### **1. Cashflow Lifecycle State Machine**

```mermaid
stateDiagram-v2
    [*] --> ACCRUED: Generate Cashflow
    
    ACCRUED --> REALIZED_DEFERRED: Defer
    ACCRUED --> REALIZED_UNSETTLED: Realize
    
    REALIZED_DEFERRED --> REALIZED_UNSETTLED: Realize
    REALIZED_DEFERRED --> ACCRUED: Cancel Deferral
    
    REALIZED_UNSETTLED --> REALIZED_SETTLED: Settle
    REALIZED_UNSETTLED --> ACCRUED: Cancel Realization
    
    REALIZED_SETTLED --> [*]: Complete
    
    note right of ACCRUED
        Initial state with daily
        accrual tracking
    end note
    
    note right of REALIZED_DEFERRED
        Deferred due to business
        rules or regulatory
    end note
    
    note right of REALIZED_UNSETTLED
        Realized but not yet
        settled
    end note
    
    note right of REALIZED_SETTLED
        Fully settled and
        confirmed
    end note
```

### **2. State Transition Process**

```mermaid
sequenceDiagram
    participant Client
    participant StateService
    participant Partition
    participant Validator
    participant Database
    participant EventPublisher
    
    Client->>StateService: Request State Change
    StateService->>Validator: Validate Transition
    Validator-->>StateService: Validation Result
    
    alt Valid Transition
        StateService->>Partition: Submit State Change
        Partition->>Database: Update State
        Database-->>Partition: Confirmation
        
        Partition->>EventPublisher: Publish State Event
        Partition->>StateService: Change Complete
        
        StateService->>Client: Success Response
    else Invalid Transition
        StateService->>Client: Error Response
    end
```

## Error Handling Flow

### **1. Partition Error Recovery**

```mermaid
flowchart TD
    A[Operation Error] --> B[Error Handler]
    B --> C{Error Type?}
    
    C -->|Validation Error| D[Return Error Response]
    C -->|Database Error| E[Retry Operation]
    C -->|System Error| F[Circuit Breaker]
    
    E --> G{Retry Count < Max?}
    G -->|Yes| H[Retry with Backoff]
    G -->|No| I[Mark as Failed]
    
    H --> J{Retry Success?}
    J -->|Yes| K[Continue Processing]
    J -->|No| E
    
    F --> L{Circuit Open?}
    L -->|Yes| M[Return Fallback]
    L -->|No| N[Attempt Operation]
    
    N --> O{Operation Success?}
    O -->|Yes| P[Close Circuit]
    O -->|No| Q[Open Circuit]
    
    style D fill:#ffebee
    style I fill:#ffebee
    style M fill:#fff3e0
    style P fill:#e8f5e8
```

### **2. Error Notification Flow**

```mermaid
sequenceDiagram
    participant ErrorHandler
    participant AlertService
    participant Monitoring
    participant Support
    participant Logging
    
    ErrorHandler->>Logging: Log Error Details
    ErrorHandler->>Monitoring: Update Error Metrics
    
    alt Critical Error
        ErrorHandler->>AlertService: Send Critical Alert
        AlertService->>Support: Notify Support Team
        AlertService->>Monitoring: Update Alert Status
    else Warning
        ErrorHandler->>Monitoring: Log Warning
        Monitoring->>AlertService: Check Thresholds
    end
    
    Monitoring->>Logging: Store Metrics
    Support->>Logging: Review Error Logs
```

## Performance Monitoring Flow

### **1. Metrics Collection Process**

```mermaid
flowchart TD
    A[Operation Execution] --> B[Metrics Collector]
    B --> C[Performance Metrics]
    B --> D[Business Metrics]
    B --> E[Partition Metrics]
    
    C --> F[Response Time]
    C --> G[Throughput]
    C --> H[Error Rate]
    
    D --> I[Cashflow Volume]
    D --> J[Calculation Types]
    D --> K[Status Distribution]
    
    E --> L[Partition Utilization]
    E --> M[Queue Length]
    E --> N[Thread Count]
    
    F --> O[Prometheus]
    G --> O
    H --> O
    I --> O
    J --> O
    K --> O
    L --> O
    M --> O
    N --> O
    
    O --> P[Grafana Dashboards]
    O --> Q[Alerting Rules]
    
    style O fill:#f3e5f5
    style P fill:#e8f5e8
    style Q fill:#fff3e0
```

### **2. Health Check Flow**

```mermaid
sequenceDiagram
    participant HealthCheck
    participant Service
    participant Database
    participant Cache
    participant Kafka
    participant Metrics
    
    HealthCheck->>Service: Check Service Health
    Service-->>HealthCheck: Service Status
    
    HealthCheck->>Database: Check Database
    Database-->>HealthCheck: Database Status
    
    HealthCheck->>Cache: Check Cache
    Cache-->>HealthCheck: Cache Status
    
    HealthCheck->>Kafka: Check Kafka
    Kafka-->>HealthCheck: Kafka Status
    
    HealthCheck->>Metrics: Check Metrics
    Metrics-->>HealthCheck: Metrics Status
    
    HealthCheck->>HealthCheck: Aggregate Health
    HealthCheck->>HealthCheck: Return Overall Status
```

## Data Integration Flow

### **1. External Service Integration**

```mermaid
flowchart TD
    A[Cashflow Service] --> B[Market Data Client]
    A --> C[Payment System Client]
    A --> D[Risk Management Client]
    
    B --> E[Market Data Service]
    C --> F[Payment System]
    D --> G[Risk Management]
    
    E --> H[Price Feeds]
    E --> I[Rate Curves]
    E --> J[Dividend Data]
    
    F --> K[Payment Instructions]
    F --> L[Settlement Confirmations]
    
    G --> M[Risk Calculations]
    G --> N[Limit Checks]
    
    H --> O[Cashflow Calculations]
    I --> O
    J --> O
    K --> P[Payment Processing]
    L --> P
    M --> Q[Risk Monitoring]
    N --> Q
    
    style O fill:#e8f5e8
    style P fill:#e8f5e8
    style Q fill:#e8f5e8
```

### **2. Event Publishing Flow**

```mermaid
sequenceDiagram
    participant CashflowService
    participant EventPublisher
    participant Kafka
    participant DownstreamServices
    
    CashflowService->>EventPublisher: Publish Event
    EventPublisher->>EventPublisher: Validate Event
    EventPublisher->>EventPublisher: Add Metadata
    
    EventPublisher->>Kafka: Send to Topic
    Kafka-->>EventPublisher: Confirmation
    
    alt Event Type: Cashflow Generated
        Kafka->>DownstreamServices: Risk Management
        Kafka->>DownstreamServices: Regulatory Reporting
        Kafka->>DownstreamServices: Settlement
    else Event Type: Status Changed
        Kafka->>DownstreamServices: Notification Service
        Kafka->>DownstreamServices: Audit Service
    end
    
    EventPublisher->>CashflowService: Event Published
```

## Summary of Data Flows

### **1. Primary Processing Flows**
- **Cashflow Generation**: Client request → Partition assignment → Calculation → Storage → Event publishing
- **Interest Accrual**: Scheduled job → Partition creation → Daily calculation → Cumulative updates
- **Equity Valuation**: Market data → Partition processing → P&L calculation → Status updates
- **State Transitions**: State change request → Validation → Partition execution → Event publishing

### **2. Reactive Processing Patterns**
- **Batch Processing**: High-volume operations with backpressure handling
- **Stream Processing**: Real-time updates with reactive streams
- **Error Handling**: Comprehensive error handling with circuit breakers
- **Performance Monitoring**: Real-time metrics collection and health checks

### **3. Thread Partitioning Benefits**
- **Data Consistency**: ACID operations within partitions
- **High Concurrency**: Multiple partitions processing simultaneously
- **Fault Isolation**: Errors contained within partitions
- **Scalability**: Easy horizontal scaling across instances

---

**Next Steps**:
1. Review [Implementation Guide](../implementation/service-implementation.md)
2. Explore [Business Logic](../business/calculation-engines.md)
3. Understand [Deployment Strategy](../deployment/deployment-architecture.md)
4. Review [Performance Tuning](../deployment/performance-tuning.md)
