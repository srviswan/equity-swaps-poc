package com.lifecycle.cashflow.service;

import com.lifecycle.cashflow.model.ThreadPartitionStatus;
import org.springframework.stereotype.Service;

/**
 * Mock implementation of ThreadPartitioningService with all required methods
 */
@Service
public class ThreadPartitioningService {
    
    public ThreadPartitionStatus getPartitionStatus() {
        // Mock implementation
        return createMockPartitionStatus();
    }
    
    public Object createPartitionKey(Object contractId, Object securityId, Object calculationType) {
        // Mock implementation
        return "mock-partition-key";
    }
    
    public Object executeInPartition(Object partitionKey, Object task) {
        // Mock implementation
        return "mock-result";
    }
    
    private ThreadPartitionStatus createMockPartitionStatus() {
        return new ThreadPartitionStatus(
            10,
            5,
            5,
            java.util.Map.of("partition1", 2, "partition2", 3),
            java.time.LocalDateTime.now(),
            "ACTIVE"
        );
    }
}