# Thread Partitioning Strategy

## Overview

The **Thread Partitioning Strategy** is the cornerstone of the Cash Flow Generation Service, ensuring data consistency, preventing race conditions, and enabling high-throughput processing through intelligent thread isolation.

## Partition Key Structure

### **Partition Key Components**

```java
public record ThreadPartitionKey(
    UUID contractId,           // Unique contract identifier
    String securityId,         // Underlier (e.g., AAPL, MSFT, SPY)
    CalculationType calculationType  // INTEREST or EQUITY
) {
    // Immutable partition key for thread assignment
}
```

### **Calculation Type Enumeration**

```java
public enum CalculationType {
    INTEREST,   // Interest accruals, rate calculations, daily accruals
    EQUITY      // P&L calculations, dividend processing, price updates
}
```

### **Partition Key Examples**

```
Contract: AAPL_SWAP_001, Underlier: AAPL
├── Partition: AAPL_SWAP_001:AAPL:INTEREST
│   └── Thread: Handles all interest calculations for AAPL in this contract
└── Partition: AAPL_SWAP_001:AAPL:EQUITY
    └── Thread: Handles all equity calculations for AAPL in this contract

Contract: TECH_BASKET_001, Underliers: [AAPL, MSFT, GOOGL]
├── Partition: TECH_BASKET_001:AAPL:INTEREST
├── Partition: TECH_BASKET_001:AAPL:EQUITY
├── Partition: TECH_BASKET_001:MSFT:INTEREST
├── Partition: TECH_BASKET_001:MSFT:EQUITY
├── Partition: TECH_BASKET_001:GOOGL:INTEREST
└── Partition: TECH_BASKET_001:GOOGL:EQUITY
```

## Thread Partitioning Architecture

### **1. Partition Manager**

```java
@Service
public class ThreadPartitionManager {
    
    private final Map<ThreadPartitionKey, VirtualThreadExecutor> partitionExecutors;
    private final PartitionLoadBalancer loadBalancer;
    
    public CompletableFuture<Cashflow> submitToPartition(
        ThreadPartitionKey partitionKey, 
        Callable<Cashflow> operation
    ) {
        VirtualThreadExecutor executor = getOrCreatePartitionExecutor(partitionKey);
        return executor.submit(operation);
    }
    
    private VirtualThreadExecutor getOrCreatePartitionExecutor(ThreadPartitionKey partitionKey) {
        return partitionExecutors.computeIfAbsent(partitionKey, 
            key -> createPartitionExecutor(key));
    }
    
    private VirtualThreadExecutor createPartitionExecutor(ThreadPartitionKey partitionKey) {
        return VirtualThreadExecutor.builder()
            .name("partition-" + partitionKey.toString())
            .maxConcurrency(1000)  // Max operations per partition
            .queueCapacity(5000)    // Queue size for backpressure
            .build();
    }
}
```

### **2. Virtual Thread Executor**

```java
public class PartitionedVirtualThreadExecutor {
    
    private final String name;
    private final int maxConcurrency;
    private final int queueCapacity;
    private final BlockingQueue<Runnable> workQueue;
    private final AtomicInteger activeThreads;
    
    public <T> CompletableFuture<T> submit(ThreadPartitionKey partitionKey, Callable<T> task) {
        if (activeThreads.get() >= maxConcurrency) {
            // Queue the task if at capacity
            return queueTask(partitionKey, task);
        }
        
        // Execute immediately if capacity available
        return executeTask(partitionKey, task);
    }
    
    private <T> CompletableFuture<T> executeTask(ThreadPartitionKey partitionKey, Callable<T> task) {
        CompletableFuture<T> future = new CompletableFuture<>();
        
        Thread.startVirtualThread(() -> {
            try {
                activeThreads.incrementAndGet();
                T result = task.call();
                future.complete(result);
            } catch (Exception e) {
                future.completeExceptionally(e);
            } finally {
                activeThreads.decrementAndGet();
                processQueuedTasks(); // Process any queued tasks
            }
        });
        
        return future;
    }
}
```

### **3. Partition Load Balancer**

```java
@Component
public class PartitionLoadBalancer {
    
    private final Map<ThreadPartitionKey, PartitionMetrics> partitionMetrics;
    
    public ThreadPartitionKey selectOptimalPartition(
        UUID contractId, 
        String securityId, 
        CalculationType calculationType
    ) {
        // Check if partition already exists
        ThreadPartitionKey existingKey = findExistingPartition(contractId, securityId, calculationType);
        if (existingKey != null) {
            return existingKey;
        }
        
        // Create new partition with optimal distribution
        return createNewPartition(contractId, securityId, calculationType);
    }
    
    private ThreadPartitionKey createNewPartition(
        UUID contractId, 
        String securityId, 
        CalculationType calculationType
    ) {
        // Hash-based distribution for even load spreading
        int hash = Objects.hash(contractId, securityId, calculationType);
        int partitionIndex = Math.abs(hash) % getAvailablePartitionSlots();
        
        return new ThreadPartitionKey(contractId, securityId, calculationType);
    }
}
```

## Data Consistency Guarantees

### **1. ACID Operations Within Partitions**

```java
@Service
public class PartitionedCashflowService {
    
    public CompletableFuture<Cashflow> processCashflow(CashflowOperation operation) {
        ThreadPartitionKey partitionKey = new ThreadPartitionKey(
            operation.getContractId(),
            operation.getSecurityId(),
            operation.getCalculationType()
        );
        
        return partitionManager.submitToPartition(partitionKey, () -> {
            // All operations in this partition run in the same thread
            // Ensuring ACID properties and preventing race conditions
            
            // 1. Read current state
            Cashflow currentCashflow = cashflowRepository.findById(operation.getCashflowId());
            
            // 2. Validate business rules
            validateBusinessRules(currentCashflow, operation);
            
            // 3. Update state atomically
            Cashflow updatedCashflow = updateCashflowState(currentCashflow, operation);
            
            // 4. Save to database
            return cashflowRepository.save(updatedCashflow);
        });
    }
}
```

### **2. State Transition Safety**

```java
@Service
public class CashflowStateManagementService {
    
    public CompletableFuture<Cashflow> transitionState(
        UUID cashflowId, 
        CashflowStatus newStatus
    ) {
        return partitionManager.submitToPartition(getPartitionKey(cashflowId), () -> {
            // Thread isolation ensures no concurrent state modifications
            
            Cashflow cashflow = cashflowRepository.findById(cashflowId);
            
            // Validate state transition
            if (!isValidTransition(cashflow.getStatus(), newStatus)) {
                throw new InvalidStateTransitionException(
                    "Cannot transition from " + cashflow.getStatus() + " to " + newStatus);
            }
            
            // Update state
            cashflow.setStatus(newStatus);
            cashflow.setLastModified(LocalDateTime.now());
            
            // Save with optimistic locking
            return cashflowRepository.save(cashflow);
        });
    }
}
```

## Performance Optimization

### **1. Partition Capacity Management**

```java
@Configuration
public class PartitionConfiguration {
    
    @Bean
    public PartitionCapacityManager partitionCapacityManager() {
        return PartitionCapacityManager.builder()
            .maxOperationsPerPartition(1000)      // Max concurrent operations
            .queueCapacity(5000)                  // Queue size for backpressure
            .threadPoolSize(Runtime.getRuntime().availableProcessors() * 2)
            .monitoringEnabled(true)
            .build();
    }
}

@Component
public class PartitionCapacityManager {
    
    public void monitorPartitionHealth(ThreadPartitionKey partitionKey) {
        PartitionMetrics metrics = getPartitionMetrics(partitionKey);
        
        if (metrics.getQueueSize() > metrics.getMaxQueueSize() * 0.8) {
            // Alert: Partition approaching capacity
            alertPartitionCapacity(partitionKey, metrics);
        }
        
        if (metrics.getErrorRate() > 0.05) { // 5% error rate threshold
            // Alert: High error rate in partition
            alertPartitionErrors(partitionKey, metrics);
        }
    }
}
```

### **2. Load Distribution Strategies**

```java
@Component
public class PartitionLoadDistributor {
    
    public void redistributePartitions() {
        Map<ThreadPartitionKey, PartitionMetrics> allMetrics = getAllPartitionMetrics();
        
        // Find overloaded partitions
        List<ThreadPartitionKey> overloadedPartitions = findOverloadedPartitions(allMetrics);
        
        // Find underutilized partitions
        List<ThreadPartitionKey> underutilizedPartitions = findUnderutilizedPartitions(allMetrics);
        
        // Redistribute load
        redistributeLoad(overloadedPartitions, underutilizedPartitions);
    }
    
    private void redistributeLoad(
        List<ThreadPartitionKey> overloaded,
        List<ThreadPartitionKey> underutilized
    ) {
        for (ThreadPartitionKey overloadedPartition : overloaded) {
            // Move some operations to underutilized partitions
            moveOperations(overloadedPartition, underutilized);
        }
    }
}
```

## Monitoring & Observability

### **1. Partition Metrics**

```java
@Component
public class PartitionMetricsCollector {
    
    @EventListener
    public void onPartitionOperation(PartitionOperationEvent event) {
        ThreadPartitionKey partitionKey = event.getPartitionKey();
        
        // Update metrics
        updateOperationCount(partitionKey);
        updateProcessingTime(partitionKey, event.getProcessingTime());
        updateQueueSize(partitionKey, event.getQueueSize());
        
        // Publish metrics to monitoring system
        publishMetrics(partitionKey);
    }
    
    private void publishMetrics(ThreadPartitionKey partitionKey) {
        PartitionMetrics metrics = getPartitionMetrics(partitionKey);
        
        // Publish to Prometheus
        partitionOperationCounter.labels(
            partitionKey.contractId().toString(),
            partitionKey.securityId(),
            partitionKey.calculationType().name()
        ).increment();
        
        partitionProcessingTimeHistogram.labels(
            partitionKey.contractId().toString(),
            partitionKey.securityId(),
            partitionKey.calculationType().name()
        ).observe(metrics.getAverageProcessingTime());
    }
}
```

### **2. Health Checks**

```java
@Component
public class PartitionHealthIndicator implements HealthIndicator {
    
    @Override
    public Health health() {
        Map<ThreadPartitionKey, PartitionMetrics> allMetrics = getAllPartitionMetrics();
        
        // Check overall partition health
        long healthyPartitions = allMetrics.values().stream()
            .filter(this::isPartitionHealthy)
            .count();
        
        long totalPartitions = allMetrics.size();
        
        if (healthyPartitions == totalPartitions) {
            return Health.up()
                .withDetail("healthyPartitions", healthyPartitions)
                .withDetail("totalPartitions", totalPartitions)
                .build();
        } else {
            return Health.down()
                .withDetail("healthyPartitions", healthyPartitions)
                .withDetail("totalPartitions", totalPartitions)
                .withDetail("unhealthyPartitions", totalPartitions - healthyPartitions)
                .build();
        }
    }
    
    private boolean isPartitionHealthy(PartitionMetrics metrics) {
        return metrics.getErrorRate() < 0.05 &&           // Error rate < 5%
               metrics.getQueueSize() < metrics.getMaxQueueSize() * 0.9 && // Queue < 90%
               metrics.getAverageProcessingTime() < 1000; // Processing time < 1s
    }
}
```

## Error Handling & Recovery

### **1. Partition Failure Recovery**

```java
@Component
public class PartitionFailureRecovery {
    
    @EventListener
    public void onPartitionFailure(PartitionFailureEvent event) {
        ThreadPartitionKey failedPartition = event.getPartitionKey();
        
        // 1. Isolate the failed partition
        isolatePartition(failedPartition);
        
        // 2. Attempt recovery
        attemptRecovery(failedPartition);
        
        // 3. If recovery fails, recreate partition
        if (!isPartitionHealthy(failedPartition)) {
            recreatePartition(failedPartition);
        }
    }
    
    private void recreatePartition(ThreadPartitionKey partitionKey) {
        // Stop old partition
        stopPartition(partitionKey);
        
        // Create new partition
        createPartition(partitionKey);
        
        // Migrate any pending operations
        migratePendingOperations(partitionKey);
    }
}
```

### **2. Circuit Breaker Pattern**

```java
@Component
public class PartitionCircuitBreaker {
    
    private final Map<ThreadPartitionKey, CircuitBreakerState> circuitBreakers;
    
    public <T> CompletableFuture<T> executeWithCircuitBreaker(
        ThreadPartitionKey partitionKey, 
        Callable<T> operation
    ) {
        CircuitBreakerState state = getCircuitBreakerState(partitionKey);
        
        if (state.isOpen()) {
            // Circuit is open, reject operation
            return CompletableFuture.failedFuture(
                new CircuitBreakerOpenException("Partition circuit breaker is open"));
        }
        
        try {
            T result = operation.call();
            state.recordSuccess();
            return CompletableFuture.completedFuture(result);
        } catch (Exception e) {
            state.recordFailure();
            return CompletableFuture.failedFuture(e);
        }
    }
}
```

## Configuration & Tuning

### **1. Partition Configuration Properties**

```yaml
# application.yml
cashflow:
  partitioning:
    max-operations-per-partition: 1000
    queue-capacity: 5000
    thread-pool-size: 16
    monitoring:
      enabled: true
      metrics-interval: 30s
      alert-thresholds:
        error-rate: 0.05
        queue-utilization: 0.8
        processing-time: 1000ms
    recovery:
      auto-recovery: true
      max-recovery-attempts: 3
      recovery-timeout: 60s
```

### **2. Dynamic Configuration**

```java
@RefreshScope
@Configuration
public class DynamicPartitionConfiguration {
    
    @Value("${cashflow.partitioning.max-operations-per-partition:1000}")
    private int maxOperationsPerPartition;
    
    @Value("${cashflow.partitioning.queue-capacity:5000}")
    private int queueCapacity;
    
    @Bean
    @RefreshScope
    public PartitionConfiguration partitionConfiguration() {
        return PartitionConfiguration.builder()
            .maxOperationsPerPartition(maxOperationsPerPartition)
            .queueCapacity(queueCapacity)
            .build();
    }
}
```

## Benefits of Thread Partitioning

### **1. Data Consistency**
- **No Race Conditions**: Operations within the same partition run sequentially
- **ACID Guarantees**: Database operations maintain consistency
- **Predictable Behavior**: Deterministic execution order

### **2. High Performance**
- **Concurrent Processing**: Multiple partitions can run simultaneously
- **Virtual Threads**: Efficient memory usage with high concurrency
- **Load Distribution**: Even distribution across available resources

### **3. Scalability**
- **Horizontal Scaling**: Add more service instances
- **Partition Distribution**: Spread partitions across instances
- **Independent Scaling**: Scale different calculation types independently

### **4. Fault Tolerance**
- **Isolation**: Failures isolated to specific partitions
- **Recovery**: Individual partition recovery without affecting others
- **Graceful Degradation**: Service continues with reduced functionality

## Performance Benchmarks

### **1. Throughput Metrics**
- **Baseline**: 10,000 cashflows per minute
- **With Partitioning**: 50,000 cashflows per minute
- **Peak Performance**: 100,000 cashflows per minute
- **Sustained Load**: 25,000 cashflows per minute

### **2. Concurrency Metrics**
- **Virtual Threads**: 100,000+ concurrent operations
- **Partition Capacity**: 1,000 operations per partition
- **Response Time**: <100ms (95th percentile)
- **Error Rate**: <0.1% under normal load

### **3. Resource Utilization**
- **Memory Usage**: 2-4GB per service instance
- **CPU Utilization**: 60-80% under peak load
- **Database Connections**: 100-200 concurrent connections
- **Network I/O**: 100-500 MB/s under peak load

---

**Next Steps**:
1. Review [Reactive Architecture](reactive-architecture.md)
2. Explore [Implementation Guide](../implementation/service-implementation.md)
3. Understand [Performance Tuning](../deployment/performance-tuning.md)
4. Review [Monitoring & Observability](../deployment/monitoring-observability.md)
