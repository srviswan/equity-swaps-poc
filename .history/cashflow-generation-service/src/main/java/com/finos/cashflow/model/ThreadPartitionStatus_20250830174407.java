package com.finos.cashflow.model;

/**
 * Status information about thread partitions.
 */
public class ThreadPartitionStatus {
    
    private int totalPartitions;
    private int activePartitions;
    private int availablePartitions;
    private int queueSize;
    
    // Constructors
    public ThreadPartitionStatus() {}
    
    public ThreadPartitionStatus(int totalPartitions, int activePartitions, int availablePartitions, int queueSize) {
        this.totalPartitions = totalPartitions;
        this.activePartitions = activePartitions;
        this.availablePartitions = availablePartitions;
        this.queueSize = queueSize;
    }
    
    // Getters and Setters
    public int getTotalPartitions() {
        return totalPartitions;
    }
    
    public void setTotalPartitions(int totalPartitions) {
        this.totalPartitions = totalPartitions;
    }
    
    public int getActivePartitions() {
        return activePartitions;
    }
    
    public void setActivePartitions(int activePartitions) {
        this.activePartitions = activePartitions;
    }
    
    public int getAvailablePartitions() {
        return availablePartitions;
    }
    
    public void setAvailablePartitions(int availablePartitions) {
        this.availablePartitions = availablePartitions;
    }
    
    public int getQueueSize() {
        return queueSize;
    }
    
    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }
    
    @Override
    public String toString() {
        return "ThreadPartitionStatus{" +
                "totalPartitions=" + totalPartitions +
                ", activePartitions=" + activePartitions +
                ", availablePartitions=" + availablePartitions +
                ", queueSize=" + queueSize +
                '}';
    }
}

