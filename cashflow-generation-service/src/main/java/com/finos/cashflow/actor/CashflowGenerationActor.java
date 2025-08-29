package com.finos.cashflow.actor;

import com.finos.cashflow.model.Cashflow;
import com.finos.cashflow.model.CashflowGenerationRequest;
import com.finos.cashflow.model.CalculationType;
import com.finos.cashflow.model.CashflowType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Actor responsible for generating cashflows for specific contracts.
 * 
 * This actor maintains state about:
 * - Processing statistics
 * - Current generation jobs
 * - Performance metrics
 * 
 * It processes messages asynchronously and can handle backpressure.
 */
public class CashflowGenerationActor extends BaseActor<CashflowGenerationActor.CashflowGenerationMessage, CashflowGenerationActorState> {
    
    private static final Logger logger = LoggerFactory.getLogger(CashflowGenerationActor.class);
    
    // Processing statistics
    private final AtomicLong totalMessagesProcessed;
    private final AtomicLong totalCashflowsGenerated;
    private final ConcurrentMap<UUID, GenerationJob> activeJobs;
    
    public CashflowGenerationActor(String name) {
        super(name);
        this.totalMessagesProcessed = new AtomicLong(0);
        this.totalCashflowsGenerated = new AtomicLong(0);
        this.activeJobs = new ConcurrentHashMap<>();
        
        // Initialize state
        updateState(new CashflowGenerationActorState(
            name, 0L, 0L, 0, "IDLE"
        ));
    }
    
    @Override
    protected void processMessage(CashflowGenerationMessage message) {
        try {
            logger.debug("Processing message in actor {}: {}", getName(), message.getType());
            
            switch (message.getType()) {
                case GENERATE_CASHFLOWS:
                    handleGenerateCashflows(message.getGenerationRequest());
                    break;
                case GENERATE_DAILY_ACCRUALS:
                    handleGenerateDailyAccruals(message.getAccrualRequest());
                    break;
                case GET_STATISTICS:
                    handleGetStatistics(message);
                    break;
                case STOP_JOB:
                    handleStopJob(message.getJobId());
                    break;
                default:
                    logger.warn("Unknown message type: {}", message.getType());
            }
            
            // Update statistics
            totalMessagesProcessed.incrementAndGet();
            updateState();
            
        } catch (Exception e) {
            logger.error("Error processing message in actor {}", getName(), e);
            // Send error response if this was an ask
            if (message.requiresResponse()) {
                sendResponse(new CashflowGenerationError(e.getMessage()));
            }
        }
    }
    
    private void handleGenerateCashflows(CashflowGenerationRequest request) {
        logger.info("Generating cashflows for {} contracts", request.getContractIds().size());
        
        // Create generation job
        UUID jobId = UUID.randomUUID();
        GenerationJob job = new GenerationJob(jobId, request, "RUNNING");
        activeJobs.put(jobId, job);
        
        // Update state
        updateState();
        
        // Process each contract
        List<Cashflow> cashflows = request.getContractIds().stream()
            .map(contractId -> generateCashflowForContract(contractId, request))
            .toList();
        
        // Update job status
        job.setStatus("COMPLETED");
        job.setGeneratedCashflows(cashflows);
        totalCashflowsGenerated.addAndGet(cashflows.size());
        
        logger.info("Generated {} cashflows for job {}", cashflows.size(), jobId);
        
        // Send response if this was an ask
        sendResponse(new CashflowGenerationResult(jobId, cashflows));
    }
    
    private void handleGenerateDailyAccruals(DailyAccrualRequest request) {
        logger.info("Generating daily accruals for {} contracts from {} to {}", 
                   request.getContractIds().size(), request.getStartDate(), request.getEndDate());
        
        // Generate daily accruals for each contract
        List<Cashflow> accruals = request.getContractIds().stream()
            .flatMap(contractId -> generateDailyAccrualsForContract(contractId, request).stream())
            .toList();
        
        totalCashflowsGenerated.addAndGet(accruals.size());
        updateState();
        
        // Send response if this was an ask
        sendResponse(new DailyAccrualResult(accruals));
    }
    
    private void handleGetStatistics(CashflowGenerationMessage message) {
        CashflowGenerationActorState currentState = getCurrentState();
        sendResponse(currentState);
    }
    
    private void handleStopJob(UUID jobId) {
        GenerationJob job = activeJobs.get(jobId);
        if (job != null) {
            job.setStatus("STOPPED");
            logger.info("Stopped job: {}", jobId);
            sendResponse(new JobStoppedResult(jobId));
        } else {
            sendResponse(new JobStoppedResult(jobId, "Job not found"));
        }
    }
    
    private Cashflow generateCashflowForContract(UUID contractId, CashflowGenerationRequest request) {
        // Determine calculation type based on request
        CalculationType calculationType = request.getPrimaryCalculationType();
        CashflowType cashflowType = request.getCashflowTypes().get(0); // Simplified
        
        // Generate cashflow based on type
        BigDecimal amount;
        if (cashflowType == CashflowType.INTEREST) {
            amount = BigDecimal.valueOf(100.00); // Placeholder interest calculation
        } else if (cashflowType == CashflowType.PERFORMANCE) {
            amount = BigDecimal.valueOf(250.00); // Placeholder performance calculation
        } else {
            amount = BigDecimal.valueOf(50.00); // Default
        }
        
        return new Cashflow(
            contractId,
            UUID.randomUUID(), // Placeholder leg ID
            "DEFAULT", // Placeholder security ID
            calculationType,
            cashflowType,
            amount,
            "USD",
            request.getCalculationDate(),
            request.getCreatedBy() != null ? request.getCreatedBy() : "SYSTEM"
        );
    }
    
    private List<Cashflow> generateDailyAccrualsForContract(UUID contractId, DailyAccrualRequest request) {
        // Generate daily accruals for the date range
        return request.getStartDate().datesUntil(request.getEndDate().plusDays(1))
            .map(date -> new Cashflow(
                contractId,
                UUID.randomUUID(), // Placeholder leg ID
                "DEFAULT", // Placeholder security ID
                CalculationType.INTEREST,
                CashflowType.INTEREST,
                BigDecimal.valueOf(10.00), // Placeholder daily accrual
                "USD",
                date,
                "SYSTEM"
            ))
            .toList();
    }
    
    private void updateState() {
        CashflowGenerationActorState newState = new CashflowGenerationActorState(
            getName(),
            totalMessagesProcessed.get(),
            totalCashflowsGenerated.get(),
            activeJobs.size(),
            getCurrentStatus()
        );
        updateState(newState);
    }
    
    private String getCurrentStatus() {
        long runningJobs = activeJobs.values().stream()
            .filter(job -> "RUNNING".equals(job.getStatus()))
            .count();
        
        if (runningJobs > 0) {
            return "PROCESSING";
        } else if (activeJobs.isEmpty()) {
            return "IDLE";
        } else {
            return "COMPLETED";
        }
    }
    
    private CashflowGenerationActorState getCurrentState() {
        return new CashflowGenerationActorState(
            getName(),
            totalMessagesProcessed.get(),
            totalCashflowsGenerated.get(),
            activeJobs.size(),
            getCurrentStatus()
        );
    }
    
    @Override
    protected void cleanup() {
        // Cancel all active jobs
        activeJobs.values().forEach(job -> job.setStatus("CANCELLED"));
        activeJobs.clear();
        
        logger.info("Actor {} cleanup completed", getName());
    }
    
    // Inner classes for messages and responses
    public static class CashflowGenerationMessage {
        private final MessageType type;
        private final CashflowGenerationRequest generationRequest;
        private final DailyAccrualRequest accrualRequest;
        private final UUID jobId;
        private final boolean requiresResponse;
        
        public CashflowGenerationMessage(MessageType type, CashflowGenerationRequest generationRequest) {
            this.type = type;
            this.generationRequest = generationRequest;
            this.accrualRequest = null;
            this.jobId = null;
            this.requiresResponse = false;
        }
        
        public CashflowGenerationMessage(MessageType type, DailyAccrualRequest accrualRequest) {
            this.type = type;
            this.generationRequest = null;
            this.accrualRequest = accrualRequest;
            this.jobId = null;
            this.requiresResponse = false;
        }
        
        public CashflowGenerationMessage(MessageType type, UUID jobId) {
            this.type = type;
            this.generationRequest = null;
            this.accrualRequest = null;
            this.jobId = jobId;
            this.requiresResponse = false;
        }
        
        // Getters
        public MessageType getType() { return type; }
        public CashflowGenerationRequest getGenerationRequest() { return generationRequest; }
        public DailyAccrualRequest getAccrualRequest() { return accrualRequest; }
        public UUID getJobId() { return jobId; }
        public boolean requiresResponse() { return requiresResponse; }
    }
    
    public enum MessageType {
        GENERATE_CASHFLOWS,
        GENERATE_DAILY_ACCRUALS,
        GET_STATISTICS,
        STOP_JOB
    }
    
    public static class DailyAccrualRequest {
        private final List<UUID> contractIds;
        private final LocalDate startDate;
        private final LocalDate endDate;
        
        public DailyAccrualRequest(List<UUID> contractIds, LocalDate startDate, LocalDate endDate) {
            this.contractIds = contractIds;
            this.startDate = startDate;
            this.endDate = endDate;
        }
        
        // Getters
        public List<UUID> getContractIds() { return contractIds; }
        public LocalDate getStartDate() { return startDate; }
        public LocalDate getEndDate() { return endDate; }
    }
    
    public static class GenerationJob {
        private final UUID jobId;
        private final CashflowGenerationRequest request;
        private String status;
        private List<Cashflow> generatedCashflows;
        
        public GenerationJob(UUID jobId, CashflowGenerationRequest request, String status) {
            this.jobId = jobId;
            this.request = request;
            this.status = status;
        }
        
        // Getters and setters
        public UUID getJobId() { return jobId; }
        public CashflowGenerationRequest getRequest() { return request; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
        public List<Cashflow> getGeneratedCashflows() { return generatedCashflows; }
        public void setGeneratedCashflows(List<Cashflow> generatedCashflows) { this.generatedCashflows = generatedCashflows; }
    }
    
    // Response classes
    public static class CashflowGenerationResult {
        private final UUID jobId;
        private final List<Cashflow> cashflows;
        
        public CashflowGenerationResult(UUID jobId, List<Cashflow> cashflows) {
            this.jobId = jobId;
            this.cashflows = cashflows;
        }
        
        // Getters
        public UUID getJobId() { return jobId; }
        public List<Cashflow> getCashflows() { return cashflows; }
    }
    
    public static class DailyAccrualResult {
        private final List<Cashflow> accruals;
        
        public DailyAccrualResult(List<Cashflow> accruals) {
            this.accruals = accruals;
        }
        
        // Getters
        public List<Cashflow> getAccruals() { return accruals; }
    }
    
    public static class JobStoppedResult {
        private final UUID jobId;
        private final String message;
        
        public JobStoppedResult(UUID jobId) {
            this.jobId = jobId;
            this.message = "Job stopped successfully";
        }
        
        public JobStoppedResult(UUID jobId, String message) {
            this.jobId = jobId;
            this.message = message;
        }
        
        // Getters
        public UUID getJobId() { return jobId; }
        public String getMessage() { return message; }
    }
    
    public static class CashflowGenerationError {
        private final String error;
        
        public CashflowGenerationError(String error) {
            this.error = error;
        }
        
        // Getters
        public String getError() { return error; }
    }
}
