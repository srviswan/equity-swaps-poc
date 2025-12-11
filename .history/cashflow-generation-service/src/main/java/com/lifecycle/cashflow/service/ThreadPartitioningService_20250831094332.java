package com.lifecycle.cashflow.service;

import com.lifecycle.cashflow.model.ThreadPartitionStatus;
import com.lifecycle.cashflow.model.CalculationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.Map;

/**
 * Thread Partitioning Service for Cash Flow Generation
 * 
 * This service implements thread partitioning strategy for cashflow calculations.
 * It ensures that cashflows for the same contract+security+calculation type
 * are processed in the same thread partition to maintain consistency and ordering.
 * 
 * Key Features:
 * - Thread isolation by partition key (ContractId + SecurityId + CalculationType)
 * - Configurable number of partitions 
 * - Load balancing across partitions
 * - Monitoring and statistics
 * 
 * @version 1.0.0
 */
@Service
public class ThreadPartitioningService {
    
    private static final Logger logger = LoggerFactory.getLogger(ThreadPartitioningService.class);
    
    private static final int DEFAULT_PARTITION_COUNT = 10;
    private final int partitionCount;
    private final Map<Integer, Executor> partitionExecutors;
    private final Map<Integer, Integer> partitionLoadCounts;
    private final LocalDateTime serviceStartTime;
    
    public ThreadPartitioningService() {
        this.partitionCount = DEFAULT_PARTITION_COUNT;
        this.partitionExecutors = new ConcurrentHashMap<>();
        this.partitionLoadCounts = new ConcurrentHashMap<>();
        this.serviceStartTime = LocalDateTime.now();
        
        // Initialize partition executors
        for (int i = 0; i < partitionCount; i++) {
            final int partitionIndex = i;
            partitionExecutors.put(i, Executors.newSingleThreadExecutor(r -> 
                new Thread(r, "cashflow-partition-" + partitionIndex)));
            partitionLoadCounts.put(i, 0);
        }
        
        logger.info("ThreadPartitioningService initialized with {} partitions", partitionCount);
    }
    
    /**
     * Create a partition key from contract, security, and calculation type
     */
    public String createPartitionKey(Object contractId, Object securityId, Object calculationType) {
        return String.format("partition-%s-%s-%s",
            contractId != null ? contractId.toString() : "default",
            securityId != null ? securityId.toString() : "default", 
            calculationType != null ? calculationType.toString() : CalculationType.INTEREST.toString()
        );
    }
    
    /**
     * Execute a task in the appropriate partition based on the partition key
     */
    @SuppressWarnings("unchecked")
    public <T> T executeInPartition(Object partitionKey, Callable<T> task) {
        try {
            int partition = getPartitionIndex(partitionKey);
            Executor executor = partitionExecutors.get(partition);
            
            // Increment load count for this partition
            partitionLoadCounts.merge(partition, 1, Integer::sum);
            
            logger.debug("Executing task in partition {} for key {}", partition, partitionKey);
            
            // Submit task to the partition executor
            Future<T> future = ((java.util.concurrent.ExecutorService) executor).submit(task);
            return future.get(); // Block and wait for result
            
        } catch (Exception e) {
            logger.error("Error executing task in partition for key {}", partitionKey, e);
            throw new RuntimeException("Partition execution failed", e);
        }
    }
    
    /**
     * Get partition index for a given key using consistent hashing
     */
    private int getPartitionIndex(Object key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode()) % partitionCount;
    }
    
    /**
     * Get current partition status and statistics
     */
    public ThreadPartitionStatus getPartitionStatus() {
        int totalPartitions = partitionCount;
        int activePartitions = (int) partitionLoadCounts.values().stream()
            .filter(count -> count > 0)
            .count();
        int availablePartitions = totalPartitions - activePartitions;
        
        Map<String, Integer> partitionDetails = new ConcurrentHashMap<>();
        for (Map.Entry<Integer, Integer> entry : partitionLoadCounts.entrySet()) {
            partitionDetails.put("partition-" + entry.getKey(), entry.getValue());
        }
        
        return new ThreadPartitionStatus(
            totalPartitions,
            activePartitions, 
            availablePartitions,
            partitionDetails,
            serviceStartTime,
            "ACTIVE"
        );
    }
    
    /**
     * Get partition statistics for monitoring
     */
    public ThreadPartitionStatus getPartitionStatistics() {
        return getPartitionStatus();
    }
    
    /**
     * Reset partition load counters (useful for testing)
     */
    public void resetPartitionCounters() {
        partitionLoadCounts.replaceAll((k, v) -> 0);
        logger.info("Partition load counters reset");
    }
    
    /**
     * Shutdown all partition executors
     */
    public void shutdown() {
        logger.info("Shutting down ThreadPartitioningService");
        for (Executor executor : partitionExecutors.values()) {
            if (executor instanceof java.util.concurrent.ExecutorService) {
                ((java.util.concurrent.ExecutorService) executor).shutdown();
            }
        }
    }
}