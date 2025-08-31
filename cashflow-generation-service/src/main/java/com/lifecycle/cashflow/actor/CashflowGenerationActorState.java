package com.lifecycle.cashflow.actor;

/**
 * State representation for the CashflowGenerationActor.
 * 
 * This immutable class captures the current state of the actor including:
 * - Processing statistics
 * - Current job status
 * - Performance metrics
 */
public class CashflowGenerationActorState {
    
    private final String actorName;
    private final long totalMessagesProcessed;
    private final long totalCashflowsGenerated;
    private final int activeJobsCount;
    private final String currentStatus;
    private final long timestamp;
    
    public CashflowGenerationActorState(String actorName, 
                                       long totalMessagesProcessed, 
                                       long totalCashflowsGenerated, 
                                       int activeJobsCount, 
                                       String currentStatus) {
        this.actorName = actorName;
        this.totalMessagesProcessed = totalMessagesProcessed;
        this.totalCashflowsGenerated = totalCashflowsGenerated;
        this.activeJobsCount = activeJobsCount;
        this.currentStatus = currentStatus;
        this.timestamp = System.currentTimeMillis();
    }
    
    // Getters
    public String getActorName() { return actorName; }
    public long getTotalMessagesProcessed() { return totalMessagesProcessed; }
    public long getTotalCashflowsGenerated() { return totalCashflowsGenerated; }
    public int getActiveJobsCount() { return activeJobsCount; }
    public String getCurrentStatus() { return currentStatus; }
    public long getTimestamp() { return timestamp; }
    
    @Override
    public String toString() {
        return String.format("CashflowGenerationActorState{actorName='%s', messages=%d, cashflows=%d, jobs=%d, status='%s', timestamp=%d}",
                           actorName, totalMessagesProcessed, totalCashflowsGenerated, activeJobsCount, currentStatus, timestamp);
    }
}
