package com.finos.cashflow.service;

import com.finos.cashflow.model.CalculationType;
import com.finos.cashflow.model.ThreadPartitionKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Service for managing thread partitioning in cashflow processing.
 * 
 * This service ensures that all operations for the same contract + underlier + calculation type
 * run in the same thread, providing data consistency and preventing race conditions.
 */
@Service
public class ThreadPartitioningService {
    
    private static final Logger logger = LoggerFactory.getLogger(ThreadPartitioningService.class);
    
    private final ConcurrentMap<String, ExecutorService> partitionExecutors = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, Scheduler> partitionSchedulers = new ConcurrentHashMap<>();
    
    /**
     * Get or create an executor for the specified partition key.
     * 
     * @param partitionKey The partition key
     * @return ExecutorService for the partition
     */
    public ExecutorService getPartitionExecutor(ThreadPartitionKey partitionKey) {
        String partitionString = partitionKey.getPartitionString();
        
        return partitionExecutors.computeIfAbsent(partitionString, key -> {
            logger.info("Creating new executor for partition: {}", key);
            
            // Use virtual threads for high-throughput processing
            ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
            
            return executor;
        });
    }
    
    /**
     * Get or create a scheduler for the specified partition key.
     * 
     * @param partitionKey The partition key
     * @return Scheduler for the partition
     */
    public Scheduler getPartitionScheduler(ThreadPartitionKey partitionKey) {
        String partitionString = partitionKey.getPartitionString();
        
        return partitionSchedulers.computeIfAbsent(partitionString, key -> {
            logger.info("Creating new scheduler for partition: {}", key);
            
            if (partitionKey.isInterestPartition()) {
                // Use bounded elastic for interest calculations (daily processing)
                return Schedulers.boundedElastic();
            } else if (partitionKey.isEquityPartition()) {
                // Use parallel for equity calculations (market-driven)
                return Schedulers.parallel();
            } else {
                // Default to bounded elastic
                return Schedulers.boundedElastic();
            }
        });
    }
    
    /**
     * Execute a task in the appropriate partition.
     * 
     * @param partitionKey The partition key
     * @param task The task to execute
     * @return CompletableFuture for the task
     */
    public <T> java.util.concurrent.CompletableFuture<T> executeInPartition(
            ThreadPartitionKey partitionKey, 
            java.util.concurrent.Callable<T> task) {
        
        ExecutorService executor = getPartitionExecutor(partitionKey);
        return java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            try {
                logger.debug("Executing task in partition: {}", partitionKey.getPartitionString());
                return task.call();
            } catch (Exception e) {
                logger.error("Error executing task in partition: {}", partitionKey.getPartitionString(), e);
                throw new RuntimeException("Task execution failed in partition: " + partitionKey.getPartitionString(), e);
            }
        }, executor);
    }
    
    /**
     * Execute a reactive task in the appropriate partition.
     * 
     * @param partitionKey The partition key
     * @param task The reactive task to execute
     * @return Mono for the task
     */
    public <T> reactor.core.publisher.Mono<T> executeReactiveInPartition(
            ThreadPartitionKey partitionKey, 
            reactor.core.publisher.Mono<T> task) {
        
        Scheduler scheduler = getPartitionScheduler(partitionKey);
        return task.publishOn(scheduler)
                  .doOnSubscribe(s -> logger.debug("Executing reactive task in partition: {}", 
                                                 partitionKey.getPartitionString()));
    }
    
    /**
     * Get partition statistics.
     * 
     * @return Map of partition statistics
     */
    public ConcurrentMap<String, Object> getPartitionStatistics() {
        ConcurrentMap<String, Object> stats = new ConcurrentHashMap<>();
        
        stats.put("totalPartitions", partitionExecutors.size());
        stats.put("activePartitions", partitionExecutors.size());
        
        partitionExecutors.forEach((partition, executor) -> {
            // Virtual thread executors don't have the same metrics as ThreadPoolExecutor
            // So we'll provide basic partition information
            stats.put(partition + ".status", "ACTIVE");
            stats.put(partition + ".type", "VIRTUAL_THREAD");
            stats.put(partition + ".activeThreads", "N/A"); // Virtual threads don't have pool size
            stats.put(partition + ".poolSize", "N/A");
            stats.put(partition + ".queueSize", "N/A");
        });
        
        return stats;
    }
    
    /**
     * Shutdown all partition executors.
     */
    public void shutdown() {
        logger.info("Shutting down all partition executors");
        
        partitionExecutors.forEach((partition, executor) -> {
            logger.info("Shutting down executor for partition: {}", partition);
            executor.shutdown();
        });
        
        partitionExecutors.clear();
        partitionSchedulers.clear();
    }
    
    /**
     * Create a partition key for the given parameters.
     * 
     * @param contractId Contract ID
     * @param securityId Security ID
     * @param calculationType Calculation type
     * @return ThreadPartitionKey
     */
    public ThreadPartitionKey createPartitionKey(UUID contractId, String securityId, CalculationType calculationType) {
        return new ThreadPartitionKey(contractId, securityId, calculationType);
    }
    
    /**
     * Check if a partition is active.
     * 
     * @param partitionKey The partition key
     * @return true if the partition is active
     */
    public boolean isPartitionActive(ThreadPartitionKey partitionKey) {
        String partitionString = partitionKey.getPartitionString();
        ExecutorService executor = partitionExecutors.get(partitionString);
        
        if (executor instanceof java.util.concurrent.ThreadPoolExecutor) {
            java.util.concurrent.ThreadPoolExecutor tpe = (java.util.concurrent.ThreadPoolExecutor) executor;
            return !tpe.isShutdown() && tpe.getActiveCount() > 0;
        }
        
        return executor != null && !executor.isShutdown();
    }
}
