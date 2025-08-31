package com.lifecycle.cashflow.model;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Status information for thread partitioning
 */
public record ThreadPartitionStatus(
    int totalPartitions,
    int activePartitions,
    int idlePartitions,
    Map<String, Integer> partitionDistribution,
    LocalDateTime lastUpdateTime,
    String status
) {
    public static ThreadPartitionStatus defaultStatus() {
        return new ThreadPartitionStatus(
            8,
            5,
            3,
            Map.of("INTEREST", 3, "EQUITY", 2, "DIVIDEND", 3),
            LocalDateTime.now(),
            "HEALTHY"
        );
    }
}
