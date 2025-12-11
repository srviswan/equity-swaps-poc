package com.finos.cashflow.service;

import com.finos.cashflow.actor.ActorSystem;
import com.finos.cashflow.actor.CashflowGenerationActor;
import com.finos.cashflow.actor.CashflowGenerationActorState;
import com.finos.cashflow.model.Cashflow;
import com.finos.cashflow.model.CashflowGenerationRequest;
import com.finos.cashflow.model.CashflowGenerationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Actor-based cashflow generation service.
 * 
 * This service uses the Actor pattern with Project Reactor to provide:
 * - Better concurrency control
 * - Message-driven processing
 * - State isolation
 * - Backpressure handling
 * - Supervision and error handling
 */
@Service
public class ActorBasedCashflowService {
    
    private static final Logger logger = LoggerFactory.getLogger(ActorBasedCashflowService.class);
    
    private final ActorSystem actorSystem;
    private final ConcurrentMap<String, CashflowGenerationActor> contractActors;
    
    public ActorBasedCashflowService() {
        this.actorSystem = new ActorSystem("CashflowGenerationSystem");
        this.contractActors = new ConcurrentHashMap<>();
        
        logger.info("Actor-based cashflow service initialized");
    }
    
    @PostConstruct
    public void initialize() {
        logger.info("Initializing actor-based cashflow service");
        // The actor system is already created in the constructor
    }
    
    @PreDestroy
    public void cleanup() {
        logger.info("Shutting down actor-based cashflow service");
        actorSystem.shutdown().block();
    }
    
    /**
     * Generate cashflows using the Actor pattern.
     * 
     * @param request The cashflow generation request
     * @return Response with job tracking information
     */
    public Mono<CashflowGenerationResponse> generateCashflows(CashflowGenerationRequest request) {
        UUID jobId = UUID.randomUUID();
        
        logger.info("Generating cashflows for {} contracts using Actor pattern", 
                   request.getContractIds().size());
        
        // Process each contract using dedicated actors
        List<Mono<Void>> actorOperations = request.getContractIds().stream()
            .map(contractId -> processContractWithActor(contractId, request))
            .toList();
        
        // Wait for all actors to complete
        return Mono.when(actorOperations)
            .then(Mono.just(new CashflowGenerationResponse(
                jobId,
                request.getContractIds().size(),
                "Cashflow generation accepted for processing using Actor pattern"
            )));
    }
    
    /**
     * Generate cashflows reactively using the Actor pattern.
     * 
     * @param request The cashflow generation request
     * @return Stream of generated cashflows
     */
    public Flux<Cashflow> generateCashflowsReactive(CashflowGenerationRequest request) {
        logger.info("Generating cashflows reactively for {} contracts using Actor pattern", 
                   request.getContractIds().size());
        
        return Flux.fromIterable(request.getContractIds())
            .flatMap(contractId -> processContractReactive(contractId, request))
            .onBackpressureBuffer(1000);
    }
    
    /**
     * Generate daily accruals using the Actor pattern.
     * 
     * @param contractIds List of contract IDs
     * @param startDate Start date for accruals
     * @param endDate End date for accruals
     * @return Stream of daily accrual cashflows
     */
    public Flux<Cashflow> generateDailyAccruals(List<UUID> contractIds, 
                                               LocalDate startDate, 
                                               LocalDate endDate) {
        logger.info("Generating daily accruals for {} contracts using Actor pattern", 
                   contractIds.size());
        
        return Flux.fromIterable(contractIds)
            .flatMap(contractId -> generateDailyAccrualsForContract(contractId, startDate, endDate))
            .onBackpressureBuffer(1000);
    }
    
    /**
     * Process a single contract using a dedicated actor.
     * 
     * @param contractId Contract ID
     * @param request Generation request
     * @return Mono that completes when processing is done
     */
    private Mono<Void> processContractWithActor(UUID contractId, CashflowGenerationRequest request) {
        String actorName = "contract-" + contractId;
        
        // Get or create actor for this contract
        CashflowGenerationActor actor = getOrCreateContractActor(actorName);
        
        // Create message for the actor
        CashflowGenerationActor.CashflowGenerationMessage message = 
            new CashflowGenerationActor.CashflowGenerationMessage(
                CashflowGenerationActor.MessageType.GENERATE_CASHFLOWS, 
                request
            );
        
        // Send message to actor (tell pattern)
        return actor.tell(message);
    }
    
    /**
     * Process a single contract reactively using an actor.
     * 
     * @param contractId Contract ID
     * @param request Generation request
     * @return Mono with generated cashflows
     */
    private Mono<Cashflow> processContractReactive(UUID contractId, CashflowGenerationRequest request) {
        String actorName = "contract-" + contractId;
        
        // Get or create actor for this contract
        CashflowGenerationActor actor = getOrCreateContractActor(actorName);
        
        // Create message for the actor
        CashflowGenerationActor.CashflowGenerationMessage message = 
            new CashflowGenerationActor.CashflowGenerationMessage(
                CashflowGenerationActor.MessageType.GENERATE_CASHFLOWS, 
                request
            );
        
        // Send message to actor and get response (ask pattern)
        return actor.ask(message, CashflowGenerationActor.CashflowGenerationResult.class)
            .flatMap(result -> {
                if (result.getCashflows().isEmpty()) {
                    return Mono.empty();
                }
                return Mono.just(result.getCashflows().get(0));
            });
    }
    
    /**
     * Generate daily accruals for a specific contract using an actor.
     * 
     * @param contractId Contract ID
     * @param startDate Start date
     * @param endDate End date
     * @return Flux of daily accrual cashflows
     */
    private Flux<Cashflow> generateDailyAccrualsForContract(UUID contractId, 
                                                           LocalDate startDate, 
                                                           LocalDate endDate) {
        String actorName = "contract-" + contractId;
        
        // Get or create actor for this contract
        CashflowGenerationActor actor = getOrCreateContractActor(actorName);
        
        // Create daily accrual request
        CashflowGenerationActor.DailyAccrualRequest accrualRequest = 
            new CashflowGenerationActor.DailyAccrualRequest(List.of(contractId), startDate, endDate);
        
        // Create message for the actor
        CashflowGenerationActor.CashflowGenerationMessage message = 
            new CashflowGenerationActor.CashflowGenerationMessage(
                CashflowGenerationActor.MessageType.GENERATE_DAILY_ACCRUALS, 
                accrualRequest
            );
        
        // Send message to actor and get response (ask pattern)
        return actor.ask(message, CashflowGenerationActor.DailyAccrualResult.class)
            .flatMapMany(result -> Flux.fromIterable(result.getAccruals()));
    }
    
    /**
     * Get or create an actor for a specific contract.
     * 
     * @param actorName Actor name
     * @return The contract actor
     */
    private CashflowGenerationActor getOrCreateContractActor(String actorName) {
        return contractActors.computeIfAbsent(actorName, name -> {
            logger.debug("Creating new actor for contract: {}", name);
            CashflowGenerationActor actor = new CashflowGenerationActor(name);
            actorSystem.createActor(name, actor);
            return actor;
        });
    }
    
    /**
     * Get actor statistics.
     * 
     * @param actorName Actor name
     * @return Actor state
     */
    public Mono<CashflowGenerationActorState> getActorStatistics(String actorName) {
        CashflowGenerationActor actor = contractActors.get(actorName);
        if (actor == null) {
            return Mono.error(new IllegalArgumentException("Actor '" + actorName + "' not found"));
        }
        
        return actor.getState();
    }
    
    /**
     * Get all actor names in the system.
     * 
     * @return Array of actor names
     */
    public String[] getActorNames() {
        return actorSystem.getActorNames();
    }
    
    /**
     * Get the total number of actors.
     * 
     * @return Number of actors
     */
    public int getActorCount() {
        return actorSystem.getActorCount();
    }
    
    /**
     * Stop a specific actor.
     * 
     * @param actorName Actor name
     * @return Mono that completes when the actor is stopped
     */
    public Mono<Void> stopActor(String actorName) {
        CashflowGenerationActor actor = contractActors.remove(actorName);
        if (actor == null) {
            return Mono.error(new IllegalArgumentException("Actor '" + actorName + "' not found"));
        }
        
        return actorSystem.stopActor(actorName);
    }
    
    /**
     * Check if the actor system is running.
     * 
     * @return true if the system is running
     */
    public boolean isActorSystemRunning() {
        return actorSystem.isRunning();
    }
}
