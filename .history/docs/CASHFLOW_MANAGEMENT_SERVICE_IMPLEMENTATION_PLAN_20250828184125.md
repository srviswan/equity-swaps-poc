# Cash Flow Management Service Implementation Plan

## Overview

The **Cash Flow Management Service** is a core microservice responsible for generating, managing, and tracking cashflows throughout their complete lifecycle. It handles multiple cashflow types (interest, dividends, performance) and manages state transitions from accrual through settlement.

## Service Architecture

### 1. **Service Responsibilities**

#### **Cashflow Generation**
- **Interest Accruals**: Daily interest accrual calculations with business day adjustments
- **Dividend Cashflows**: Dividend entitlement and payment calculations
- **Performance Cashflows**: Unrealized P&L calculations for equity returns
- **Fee Cashflows**: Management fees, performance fees, and other charges

#### **State Management**
- **Accrued**: Initial cashflow state with daily tracking
- **Realized Deferred**: Cashflows deferred due to business rules, regulatory requirements, or counterparty requests
- **Realized Unsettled**: Cashflows realized but not yet settled
- **Settled**: Cashflows fully settled and confirmed

#### **Lifecycle Management**
- **Daily Processing**: Generate accruals and update unrealized P&L
- **Event Processing**: Handle market events, corporate actions, and business rule changes
- **Status Transitions**: Manage cashflow state changes with audit trail
- **Settlement Coordination**: Interface with payment and settlement systems

### 2. **Service Components**

#### **Threading Strategy**
- **Partitioning Key**: `ContractId + SecurityId (Underlier)` combination
- **Calculation Separation**: Interest and equity calculations handled separately within each partition
- **Isolation Guarantee**: All operations for the same contract + underlier run in the same thread
- **Concurrency Model**: Virtual threads with partition-based isolation and calculation type separation
- **Data Consistency**: Prevents race conditions and ensures ACID operations within partitions
- **Scalability**: Scales horizontally while maintaining data integrity

#### **Core Services**
- `CashflowGenerationService`: Orchestrates cashflow generation using partitioned virtual threads
- `InterestCalculationService`: Handles interest accruals and calculations separately
- `EquityCalculationService`: Handles equity P&L and dividend calculations separately
- `AccrualCalculationService`: Handles daily accrual calculations with pattern matching
- `PerformanceCalculationService`: Manages unrealized P&L calculations
- `CashflowStateManagementService`: Handles state transitions with sealed classes
- `DeferralManagementService`: Manages cashflow deferrals
- `ThreadPartitioningService`: Manages contract + underlier based thread partitioning with calculation type separation

#### **Data Access Layer**
- `CashflowRepository`: CRUD operations for cashflows
- `DailyAccrualRepository`: Daily accrual data access
- `UnrealizedPnlRepository`: P&L time series data access
- `CashflowStatusHistoryRepository`: Status change history

#### **External Integrations**
- `MarketDataService`: Fetches market prices, rates, and dividend data
- `ContractService`: Retrieves contract and payout information
- `PaymentService`: Interfaces with payment processing systems
- `NotificationService`: Sends alerts and notifications

### 3. **Technology Stack**

#### **Framework & Runtime**
- **Java 21**: Latest LTS with virtual threads, pattern matching, and performance improvements
- **Spring Boot 3.3+**: Latest version with Java 21 support and reactive programming
- **Spring Data JPA**: Data access layer with PostgreSQL
- **Spring WebFlux**: Reactive web framework with Project Reactor
- **Project Reactor**: Reactive streams for high-throughput processing
- **Virtual Threads**: High-throughput concurrent processing for cashflow generation

#### **Database & Caching**
- **PostgreSQL**: Primary database with JSONB support
- **Redis**: Caching for market data and calculations
- **Connection Pooling**: HikariCP for database performance

#### **Messaging & Events**
- **Apache Kafka**: Event streaming for cashflow events
- **Spring Cloud Stream**: Stream processing framework with reactive support
- **Project Reactor**: Reactive streams for event processing
- **Event Sourcing**: Maintain complete audit trail

#### **Monitoring & Observability**
- **Spring Boot Actuator**: Health checks and metrics
- **Prometheus**: Metrics collection
- **Grafana**: Dashboards and visualization
- **ELK Stack**: Logging and analysis

### 4. **Java 21 + Spring Boot 3.3+ Benefits for Cash Flow Management**

#### **Performance Improvements**
- **Virtual Threads**: Handle 100,000+ concurrent cashflow operations without thread pool exhaustion
- **Partitioned Threading**: Contract + Underlier (securityId) based partitioning for thread safety
- **Pattern Matching**: Clean, readable code for complex cashflow type handling and state transitions
- **Sealed Classes**: Type-safe cashflow status and type hierarchies
- **Record Classes**: Immutable data transfer objects for cashflow requests/responses
- **Text Blocks**: Readable SQL queries and complex business rule definitions

#### **Reactive Programming with Project Reactor**
- **Reactive Streams**: Non-blocking, backpressure-aware processing
- **Flux/Mono**: Reactive types for handling multiple and single cashflow operations
- **Schedulers**: Efficient thread pool management for different calculation types
- **Operators**: Rich set of operators for transforming and combining cashflow streams

#### **Concurrency Enhancements**
- **Structured Concurrency**: Coordinated lifecycle management for related cashflow operations
- **Partitioned Execution**: Contract + Underlier based thread partitioning for data consistency
- **Scoped Values**: Efficient data sharing across virtual threads
- **Foreign Function & Memory API**: High-performance integration with external systems
- **Vector API**: SIMD operations for bulk cashflow calculations

#### **Developer Experience**
- **Switch Expressions**: Clean state machine implementations
- **Enhanced Switch**: Pattern matching in switch statements for cashflow routing
- **String Templates**: Dynamic SQL query generation and logging
- **Unnamed Patterns**: Simplified data extraction from complex objects

## Implementation Phases

### **Phase 1: Core Infrastructure (Weeks 1-2)**
1. **Project Setup**: Spring Boot 3.2+ application with Java 21 and dependencies
2. **Database Schema**: Implement PostgreSQL tables and indexes
3. **Basic CRUD**: Repository and service layer for cashflows
4. **Health Checks**: Basic monitoring and health endpoints
5. **Virtual Thread Configuration**: Configure partitioned virtual threads for high-throughput processing
6. **Thread Partitioning Strategy**: Implement contract + underlier based partitioning

### **Phase 2: Cashflow Generation (Weeks 3-4)**
1. **Interest Calculation Engine**: Daily interest accruals with rate management
2. **Equity Calculation Engine**: Unrealized P&L and dividend calculations
3. **Calculation Framework**: Pluggable calculation engines with type separation
4. **Market Data Integration**: External market data feeds for equity calculations
5. **Rate Management**: Interest rate feeds and curve management for interest calculations

### **Phase 3: State Management (Weeks 5-6)**
1. **State Machine**: Cashflow lifecycle state transitions
2. **Deferral Logic**: Business rules for cashflow deferrals
3. **Audit Trail**: Complete history of all changes
4. **Validation Rules**: Business rule validation

### **Phase 4: Advanced Features (Weeks 7-8)**
1. **Batch Processing**: High-volume cashflow generation using partitioned virtual threads
2. **Real-time Updates**: Live cashflow status updates with reactive streams
3. **Reporting APIs**: Comprehensive reporting endpoints
4. **Performance Optimization**: Caching, query optimization, and partitioned thread tuning

### **Phase 5: Integration & Testing (Weeks 9-10)**
1. **External Integrations**: Payment and settlement systems
2. **Event Publishing**: Kafka event streaming
3. **Integration Testing**: End-to-end testing
4. **Performance Testing**: Load and stress testing

## API Design Principles

### 1. **RESTful Design**
- **Resource-based URLs**: `/cashflows`, `/cashflows/{id}`, `/cashflows/{id}/status`
- **HTTP Methods**: GET, POST, PUT, PATCH for different operations
- **Status Codes**: Proper HTTP status codes for responses
- **Pagination**: Support for large result sets

### 2. **Event-Driven Architecture**
- **Async Processing**: Non-blocking cashflow generation
- **Event Publishing**: Publish cashflow events to Kafka
- **Webhooks**: Real-time notifications for status changes
- **Event Sourcing**: Maintain complete audit trail

### 3. **Data Consistency**
- **ACID Transactions**: Ensure data consistency
- **Optimistic Locking**: Handle concurrent updates
- **Idempotency**: Safe retry mechanisms
- **Validation**: Comprehensive input validation

### 4. **Performance & Scalability**
- **Caching**: Redis caching for frequently accessed data
- **Virtual Threads**: High-throughput concurrent processing for cashflow generation
- **Thread Partitioning**: Contract + Underlier based isolation for data consistency
- **Async Processing**: Background job processing with structured concurrency
- **Batch Operations**: Bulk cashflow operations with parallel streams
- **Connection Pooling**: Efficient database connections

## Database Design Considerations

### 1. **Performance Optimization**
- **Partitioning**: Partition large tables by date or contract
- **Indexing**: Strategic indexes for common query patterns
- **Materialized Views**: Pre-computed summaries for reporting
- **Query Optimization**: Efficient SQL queries and execution plans

### 2. **Data Retention**
- **Archiving Strategy**: Move old data to archive tables
- **Data Lifecycle**: Define retention periods for different data types
- **Backup Strategy**: Regular backups and point-in-time recovery
- **Compliance**: Meet regulatory data retention requirements

### 3. **Scalability**
- **Horizontal Scaling**: Read replicas for reporting queries
- **Sharding**: Distribute data across multiple database instances
- **Virtual Threads**: Scale to handle 100,000+ concurrent cashflow operations
- **Partitioned Threading**: Contract + Underlier based isolation for data consistency
- **Connection Pooling**: Efficient connection management
- **Query Optimization**: Minimize database load

## Security & Compliance

### 1. **Authentication & Authorization**
- **OAuth 2.0**: Secure API authentication
- **JWT Tokens**: Stateless authentication
- **Role-Based Access Control**: Fine-grained permissions
- **API Keys**: Service-to-service authentication

### 2. **Data Protection**
- **Encryption**: Encrypt sensitive data at rest and in transit
- **Audit Logging**: Complete audit trail for compliance
- **Data Masking**: Mask sensitive data in logs
- **Access Controls**: Restrict data access by role

### 3. **Compliance**
- **SOX Compliance**: Financial reporting compliance
- **GDPR Compliance**: Data privacy requirements
- **Regulatory Reporting**: Generate required reports
- **Audit Support**: Support external and internal audits

## Monitoring & Observability

### 1. **Health Monitoring**
- **Service Health**: Overall service health status
- **Database Health**: Database connection and performance
- **External Dependencies**: Market data and payment system health
- **Business Metrics**: Cashflow generation and processing metrics

### 2. **Performance Metrics**
- **Response Times**: API endpoint performance
- **Throughput**: Cashflow processing rates
- **Error Rates**: Success and failure rates
- **Resource Utilization**: CPU, memory, and database usage

### 3. **Business Metrics**
- **Cashflow Volumes**: Daily, weekly, monthly cashflow volumes
- **Processing Times**: Time to generate and process cashflows
- **Status Distribution**: Distribution of cashflow states
- **Deferral Metrics**: Deferral reasons and aging analysis

## Testing Strategy

### 1. **Unit Testing**
- **Service Layer**: Test business logic in isolation
- **Repository Layer**: Test data access operations
- **Validation**: Test input validation and business rules
- **Mocking**: Mock external dependencies

### 2. **Integration Testing**
- **Database Integration**: Test with real database
- **External Services**: Test market data and payment integrations
- **Event Publishing**: Test Kafka event publishing
- **End-to-End**: Test complete cashflow workflows

### 3. **Performance Testing**
- **Load Testing**: Test under expected load
- **Stress Testing**: Test beyond expected capacity
- **Endurance Testing**: Test over extended periods
- **Scalability Testing**: Test horizontal scaling

## Deployment & DevOps

### 1. **Containerization**
- **Docker**: Containerize the application
- **Multi-stage Builds**: Optimize container images
- **Health Checks**: Container health monitoring
- **Resource Limits**: Set CPU and memory limits

### 2. **Orchestration**
- **Kubernetes**: Container orchestration
- **Helm Charts**: Kubernetes deployment templates
- **Service Mesh**: Istio for service-to-service communication
- **Auto-scaling**: Horizontal pod auto-scaling

### 3. **CI/CD Pipeline**
- **GitHub Actions**: Automated build and testing
- **Docker Registry**: Store container images
- **ArgoCD**: GitOps deployment
- **Rolling Updates**: Zero-downtime deployments

## Risk Mitigation

### 1. **Technical Risks**
- **Performance Issues**: Monitor and optimize performance
- **Data Consistency**: Implement proper transaction management
- **External Dependencies**: Implement circuit breakers and fallbacks
- **Scalability Limits**: Plan for horizontal scaling

### 2. **Business Risks**
- **Regulatory Changes**: Flexible business rule engine
- **Market Data Issues**: Implement fallback data sources
- **Payment System Failures**: Graceful degradation
- **Compliance Violations**: Comprehensive audit trail

### 3. **Operational Risks**
- **Data Loss**: Regular backups and disaster recovery
- **Service Outages**: High availability and redundancy
- **Security Breaches**: Regular security audits
- **Performance Degradation**: Proactive monitoring

## Success Metrics

### 1. **Technical Metrics**
- **Availability**: 99.9% uptime target
- **Performance**: <100ms API response time
- **Throughput**: 50,000+ cashflows per minute (with partitioned virtual threads)
- **Error Rate**: <0.1% error rate
- **Concurrency**: 100,000+ virtual threads with contract + underlier partitioning
- **Data Consistency**: 100% thread isolation per contract + underlier combination

### 2. **Business Metrics**
- **Processing Efficiency**: 95%+ cashflows processed within SLA
- **Data Accuracy**: 99.99% data accuracy
- **Compliance**: 100% regulatory compliance
- **User Satisfaction**: High user satisfaction scores

### 3. **Operational Metrics**
- **Deployment Frequency**: Daily deployments
- **Lead Time**: <1 hour from commit to production
- **Mean Time to Recovery**: <15 minutes for critical issues
- **Change Failure Rate**: <5% failed deployments

## Java 21 Implementation Considerations

### 1. **Thread Partitioning Strategy**

#### **Partitioning Key: Contract + Underlier (SecurityId) + Calculation Type**
```java
// Thread partitioning key for cashflow operations with calculation type separation
public record ThreadPartitionKey(
    UUID contractId,
    String securityId,  // Underlier identifier
    CalculationType calculationType  // INTEREST or EQUITY
) {
    // Ensures thread isolation per contract + underlier + calculation type combination
}

public enum CalculationType {
    INTEREST,   // Interest accruals and calculations
    EQUITY      // Equity P&L and dividend calculations
}
```

#### **Partitioned Virtual Thread Executor with Calculation Type Separation**
```java
@Configuration
public class PartitionedThreadConfig {
    
    @Bean
    public PartitionedVirtualThreadExecutor partitionedExecutor() {
        return new PartitionedVirtualThreadExecutor(
            "cashflow-partitioned-",
            this::getPartitionKey,
            Runtime.getRuntime().availableProcessors() * 2
        );
    }
    
    private ThreadPartitionKey getPartitionKey(CashflowOperation operation) {
        return new ThreadPartitionKey(
            operation.getContractId(),
            operation.getSecurityId(),
            operation.getCalculationType()
        );
    }
}
```

#### **Thread-Safe Cashflow Processing with Calculation Type Separation**
```java
@Service
public class PartitionedCashflowService {
    
    private final PartitionedVirtualThreadExecutor executor;
    private final InterestCalculationService interestService;
    private final EquityCalculationService equityService;
    
    public CompletableFuture<Cashflow> processCashflow(CashflowOperation operation) {
        ThreadPartitionKey partitionKey = new ThreadPartitionKey(
            operation.getContractId(), 
            operation.getSecurityId(),
            operation.getCalculationType()
        );
        
        return executor.submit(partitionKey, () -> {
            // This operation runs in isolation for this contract + underlier + calculation type
            return switch (operation.getCalculationType()) {
                case INTEREST -> interestService.processInterestCalculation(operation);
                case EQUITY -> equityService.processEquityCalculation(operation);
            };
        });
    }
}
```

### 2. **Virtual Thread Configuration**
```java
// Configure virtual threads for high-throughput cashflow processing
@Configuration
public class VirtualThreadConfig {
    
    @Bean
    public TaskExecutor virtualThreadTaskExecutor() {
        return new VirtualThreadTaskExecutor("cashflow-");
    }
    
    @Bean
    public AsyncTaskExecutor asyncTaskExecutor() {
        return new SimpleAsyncTaskExecutor("cashflow-async-");
    }
}
```

### 2. **Pattern Matching for Cashflow Types**
```java
// Clean cashflow type handling with pattern matching
public BigDecimal calculateAmount(Cashflow cashflow) {
    return switch (cashflow) {
        case InterestCashflow i -> calculateInterestAmount(i);
        case DividendCashflow d -> calculateDividendAmount(d);
        case PerformanceCashflow p -> calculatePerformanceAmount(p);
        case FeeCashflow f -> calculateFeeAmount(f);
    };
}
```

### 3. **Sealed Classes for Cashflow States**
```java
// Type-safe cashflow state hierarchy
public sealed abstract class CashflowState 
    permits AccruedState, RealizedDeferredState, RealizedUnsettledState, RealizedSettledState {
    
    public abstract boolean canTransitionTo(CashflowState newState);
    public abstract String getDescription();
}
```

### 4. **Record Classes for DTOs**
```java
// Immutable data transfer objects
public record CashflowGenerationRequest(
    List<UUID> contractIds,
    LocalDate calculationDate,
    List<CashflowType> cashflowTypes,
    MarketDataOverride marketDataOverride
) {
    // Validation logic
    public CashflowGenerationRequest {
        Objects.requireNonNull(contractIds, "contractIds cannot be null");
        Objects.requireNonNull(calculationDate, "calculationDate cannot be null");
        Objects.requireNonNull(cashflowTypes, "cashflowTypes cannot be null");
    }
}
```

### 5. **Structured Concurrency for Batch Operations**
```java
// Coordinated batch cashflow processing with partitioning
public CompletableFuture<List<Cashflow>> generateBatchCashflows(
    List<CashflowOperation> operations
) {
    // Group operations by partition key for efficient processing
    Map<ThreadPartitionKey, List<CashflowOperation>> partitionedOperations = 
        operations.stream()
            .collect(Collectors.groupingBy(this::getPartitionKey));
    
    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
        var futures = partitionedOperations.entrySet().stream()
            .map(entry -> scope.fork(() -> 
                processPartitionedOperations(entry.getKey(), entry.getValue())))
            .toList();
        
        scope.join();
        scope.throwIfFailed();
        
        return futures.stream()
            .map(StructuredFuture::resultNow)
            .flatMap(List::stream)
            .toList();
    }
}

private List<Cashflow> processPartitionedOperations(
    ThreadPartitionKey partitionKey, 
    List<CashflowOperation> operations
) {
    // All operations for this contract + underlier run in the same thread
    // ensuring data consistency and preventing race conditions
    return operations.stream()
        .map(this::processCashflowInIsolation)
        .toList();
}
```

### 6. **Spring Boot 3.3+ Reactive Implementation**

#### **Reactive Cashflow Processing with Project Reactor**
```java
@Service
public class ReactiveCashflowService {
    
    private final PartitionedVirtualThreadExecutor executor;
    private final InterestCalculationService interestService;
    private final EquityCalculationService equityService;
    
    public Flux<Cashflow> generateCashflowsReactive(List<UUID> contractIds, LocalDate calculationDate) {
        return Flux.fromIterable(contractIds)
            .flatMap(contractId -> processContractCashflows(contractId, calculationDate), 100)
            .onBackpressureBuffer(10000)
            .doOnNext(cashflow -> log.info("Generated cashflow: {}", cashflow.getId()))
            .doOnError(error -> log.error("Error generating cashflows: {}", error.getMessage()));
    }
    
    private Mono<List<Cashflow>> processContractCashflows(UUID contractId, LocalDate calculationDate) {
        return Mono.fromCallable(() -> {
            // Get contract details
            Contract contract = contractService.getContract(contractId);
            
            // Process interest and equity calculations separately
            List<Cashflow> interestCashflows = processInterestCalculations(contract, calculationDate);
            List<Cashflow> equityCashflows = processEquityCalculations(contract, calculationDate);
            
            return Stream.concat(interestCashflows.stream(), equityCashflows.stream())
                .collect(Collectors.toList());
        }).subscribeOn(Schedulers.boundedElastic());
    }
    
    private List<Cashflow> processInterestCalculations(Contract contract, LocalDate calculationDate) {
        ThreadPartitionKey partitionKey = new ThreadPartitionKey(
            contract.getId(), 
            contract.getSecurityId(), 
            CalculationType.INTEREST
        );
        
        return executor.submit(partitionKey, () -> 
            interestService.calculateInterestCashflows(contract, calculationDate)
        ).join();
    }
    
    private List<Cashflow> processEquityCalculations(Contract contract, LocalDate calculationDate) {
        ThreadPartitionKey partitionKey = new ThreadPartitionKey(
            contract.getId(), 
            contract.getSecurityId(), 
            CalculationType.EQUITY
        );
        
        return executor.submit(partitionKey, () -> 
            equityService.calculateEquityCashflows(contract, calculationDate)
        ).join();
    }
}
```

#### **Reactive Controller with WebFlux**
```java
@RestController
@RequestMapping("/api/v1/cashflows")
public class ReactiveCashflowController {
    
    private final ReactiveCashflowService cashflowService;
    
    @PostMapping("/generate")
    public Flux<Cashflow> generateCashflows(@RequestBody CashflowGenerationRequest request) {
        return cashflowService.generateCashflowsReactive(
            request.getContractIds(), 
            request.getCalculationDate()
        );
    }
    
    @PostMapping("/generate/stream")
    public Flux<ServerSentEvent<Cashflow>> generateCashflowsStream(@RequestBody CashflowGenerationRequest request) {
        return cashflowService.generateCashflowsReactive(
            request.getContractIds(), 
            request.getCalculationDate()
        ).map(cashflow -> ServerSentEvent.builder(cashflow).build());
    }
    
    @GetMapping("/{cashflowId}")
    public Mono<Cashflow> getCashflow(@PathVariable UUID cashflowId) {
        return cashflowService.getCashflowById(cashflowId);
    }
}
```

#### **Reactive Repository with R2DBC**
```java
@Repository
public class ReactiveCashflowRepository {
    
    private final DatabaseClient databaseClient;
    
    public Flux<Cashflow> findByContractId(UUID contractId) {
        return databaseClient.sql("SELECT * FROM cashflows WHERE contract_id = :contractId")
            .bind("contractId", contractId)
            .map(this::mapToCashflow)
            .all();
    }
    
    public Mono<Cashflow> save(Cashflow cashflow) {
        if (cashflow.getId() == null) {
            return databaseClient.sql("INSERT INTO cashflows (contract_id, leg_id, amount, currency, status) VALUES (:contractId, :legId, :amount, :currency, :status)")
                .bind("contractId", cashflow.getContractId())
                .bind("legId", cashflow.getLegId())
                .bind("amount", cashflow.getAmount())
                .bind("currency", cashflow.getCurrency())
                .bind("status", cashflow.getStatus().name())
                .fetch()
                .rowsUpdated()
                .thenReturn(cashflow);
        } else {
            return databaseClient.sql("UPDATE cashflows SET amount = :amount, status = :status WHERE id = :id")
                .bind("amount", cashflow.getAmount())
                .bind("status", cashflow.getStatus().name())
                .bind("id", cashflow.getId())
                .fetch()
                .rowsUpdated()
                .thenReturn(cashflow);
        }
    }
}
```

### 7. **Calculation Type Separation Strategy**

#### **Why Separate Interest and Equity Calculations?**

##### **Interest Calculations**
- **Time-based Processing**: Daily accruals based on business days
- **Rate Dependencies**: Interest rate curves and spreads
- **Day Count Conventions**: ACT/365, ACT/360, 30/360
- **Business Day Adjustments**: Following, Preceding, Modified Following
- **Frequency**: Daily accruals, periodic resets

##### **Equity Calculations**
- **Market-driven Processing**: Real-time price updates and corporate actions
- **Price Dependencies**: Market prices, dividend announcements
- **Corporate Actions**: Stock splits, mergers, spin-offs
- **Frequency**: Market events, end-of-day valuations

#### **Partitioning Benefits with Calculation Type Separation**

##### **1. Independent Processing**
```java
// Interest calculations run independently of equity calculations
@Service
public class InterestCalculationService {
    
    public CompletableFuture<InterestCashflow> calculateInterestAccrual(
        UUID contractId, 
        String securityId, 
        LocalDate calculationDate
    ) {
        ThreadPartitionKey partitionKey = new ThreadPartitionKey(
            contractId, securityId, CalculationType.INTEREST
        );
        
        return executor.submit(partitionKey, () -> {
            // Interest calculation logic isolated from equity calculations
            return processInterestAccrual(contractId, securityId, calculationDate);
        });
    }
}

// Equity calculations run independently of interest calculations
@Service
public class EquityCalculationService {
    
    public CompletableFuture<EquityCashflow> calculateEquityPnl(
        UUID contractId, 
        String securityId, 
        LocalDate valuationDate
    ) {
        ThreadPartitionKey partitionKey = new ThreadPartitionKey(
            contractId, securityId, CalculationType.EQUITY
        );
        
        return executor.submit(partitionKey, () -> {
            // Equity calculation logic isolated from interest calculations
            return processEquityPnl(contractId, securityId, valuationDate);
        });
    }
}
```

##### **2. Different Processing Frequencies**
```java
// Interest calculations - daily batch processing
@Scheduled(cron = "0 1 * * *") // 1 AM daily
public void processDailyInterestAccruals() {
    List<Contract> contracts = contractService.getActiveContracts();
    
    contracts.parallelStream()
        .forEach(contract -> {
            ThreadPartitionKey partitionKey = new ThreadPartitionKey(
                contract.getId(), 
                contract.getSecurityId(), 
                CalculationType.INTEREST
            );
            
            executor.submit(partitionKey, () -> 
                calculateDailyInterestAccrual(contract, LocalDate.now())
            );
        });
}

// Equity calculations - market-driven processing
@EventListener
public void handleMarketDataUpdate(MarketDataUpdateEvent event) {
    List<Contract> affectedContracts = contractService.getContractsBySecurityId(
        event.getSecurityId()
    );
    
    affectedContracts.forEach(contract -> {
        ThreadPartitionKey partitionKey = new ThreadPartitionKey(
            contract.getId(), 
            contract.getSecurityId(), 
            CalculationType.EQUITY
        );
        
        executor.submit(partitionKey, () -> 
            recalculateEquityPnl(contract, event.getMarketData())
        );
    });
}
```

### 7. **Partitioning Benefits and Considerations**

#### **Data Consistency Guarantees**
```java
// Thread isolation ensures no race conditions within the same contract + underlier
@Service
public class CashflowStateManagementService {
    
    public void updateCashflowStatus(UUID cashflowId, CashflowStatus newStatus) {
        Cashflow cashflow = cashflowRepository.findById(cashflowId);
        ThreadPartitionKey partitionKey = new ThreadPartitionKey(
            cashflow.getContractId(), 
            cashflow.getSecurityId()
        );
        
        // This operation runs in isolation, preventing concurrent modifications
        executor.submit(partitionKey, () -> {
            cashflow.setStatus(newStatus);
            cashflowRepository.save(cashflow);
            return cashflow;
        });
    }
}
```

#### **Performance Optimization with Calculation Type Separation**
```java
// Batch operations within the same partition and calculation type for efficiency
public class PartitionedBatchProcessor {
    
    public void processBatchByPartition(List<CashflowOperation> operations) {
        Map<ThreadPartitionKey, List<CashflowOperation>> partitioned = 
            operations.stream()
                .collect(Collectors.groupingBy(this::getPartitionKey));
        
        // Process each partition in parallel while maintaining isolation
        partitioned.entrySet().parallelStream()
            .forEach(entry -> processPartition(entry.getKey(), entry.getValue()));
    }
    
    public void processInterestCalculations(List<InterestCalculationRequest> requests) {
        // Group by contract + securityId for interest calculations
        Map<ContractSecurityKey, List<InterestCalculationRequest>> grouped = 
            requests.stream()
                .collect(Collectors.groupingBy(this::getContractSecurityKey));
        
        grouped.entrySet().parallelStream()
            .forEach(entry -> processInterestBatch(entry.getKey(), entry.getValue()));
    }
    
    public void processEquityCalculations(List<EquityCalculationRequest> requests) {
        // Group by contract + securityId for equity calculations
        Map<ContractSecurityKey, List<EquityCalculationRequest>> grouped = 
            requests.stream()
                .collect(Collectors.groupingBy(this::getContractSecurityKey));
        
        grouped.entrySet().parallelStream()
            .forEach(entry -> processEquityBatch(entry.getKey(), entry.getValue()));
    }
}

// Separate keys for different calculation types
public record ContractSecurityKey(UUID contractId, String securityId) {}
```

## **Spring Boot 3.3+ Reactive Benefits**

### **1. Non-Blocking Processing**
- **Reactive Streams**: Handle backpressure automatically with `onBackpressureBuffer()`
- **Efficient Resource Usage**: No thread blocking, better CPU utilization
- **Scalability**: Scale to handle 100K+ concurrent operations with minimal resources

### **2. Rich Operator Support**
- **Transformation**: `map()`, `flatMap()`, `filter()` for cashflow processing
- **Combination**: `zip()`, `merge()`, `concat()` for combining different calculation types
- **Error Handling**: `onErrorResume()`, `onErrorReturn()` for graceful degradation

### **3. Scheduler Management**
- **Bounded Elastic**: For I/O operations (database, external services)
- **Parallel**: For CPU-intensive calculations
- **Virtual Threads**: For high-throughput processing with partitioning

### **4. Backpressure Handling**
- **Automatic Flow Control**: Prevents memory issues with high-volume processing
- **Configurable Buffers**: `onBackpressureBuffer(10000)` for large batches
- **Reactive Streams**: Standard-compliant backpressure management

## **Calculation Type Separation Benefits**

### **1. Independent Scaling**
- **Interest Calculations**: Scale based on number of contracts and accrual frequency
- **Equity Calculations**: Scale based on market events and price update frequency
- **Resource Allocation**: Allocate different resources for different calculation types

### **2. Different Processing Patterns**
- **Interest**: Batch processing at end-of-day with predictable timing
- **Equity**: Event-driven processing with real-time market updates
- **Scheduling**: Different cron schedules and event listeners

### **3. Data Source Isolation**
- **Interest**: Rate curves, day count conventions, business calendars
- **Equity**: Market prices, dividend feeds, corporate action announcements
- **Caching**: Different cache strategies for different data types

### **4. Error Handling and Recovery**
- **Interest**: Failures don't affect equity calculations
- **Equity**: Market data issues don't impact interest accruals
- **Circuit Breakers**: Separate circuit breakers per calculation type

### **5. Regulatory and Compliance**
- **Interest**: SOFR/LIBOR transition, rate curve management
- **Equity**: Market data validation, corporate action processing
- **Reporting**: Separate reporting cycles for different cashflow types

## Next Steps

1. **Detailed Design**: Create detailed technical specifications
2. **API Specification**: Develop OpenAPI specification
3. **Database Schema**: Finalize database design
4. **Prototype**: Build proof-of-concept
5. **Team Setup**: Assemble development team
6. **Development**: Begin iterative development

This implementation plan provides a comprehensive roadmap for building the Cash Flow Management Service with proper architecture, security, monitoring, and scalability considerations.
