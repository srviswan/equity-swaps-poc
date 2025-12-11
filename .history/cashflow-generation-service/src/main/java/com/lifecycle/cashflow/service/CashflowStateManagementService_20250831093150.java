package com.lifecycle.cashflow.service;

import com.lifecycle.cashflow.exception.InvalidStateTransitionException;
import com.lifecycle.cashflow.model.Cashflow;
import com.lifecycle.cashflow.model.CashflowStatus;
import com.lifecycle.cashflow.repository.CashflowRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CashflowStateManagementService {
    
    private static final Logger logger = LoggerFactory.getLogger(CashflowStateManagementService.class);
    
    private final CashflowRepository cashflowRepository;
    
    @Autowired
    public CashflowStateManagementService(CashflowRepository cashflowRepository) {
        this.cashflowRepository = cashflowRepository;
    }
    
    /**
     * Transition cashflow to ACCRUED state
     */
    public Mono<Cashflow> transitionToAccrued(Cashflow cashflow) {
        logger.info("Transitioning cashflow {} to ACCRUED state", cashflow.getId());
        
        if (cashflow.getStatus() != CashflowStatus.ACCRUED) {
            cashflow.setStatus(CashflowStatus.ACCRUED);
            cashflow.setUpdatedAt(LocalDateTime.now());
            return cashflowRepository.save(cashflow);
        }
        
        return Mono.just(cashflow);
    }
    
    /**
     * Transition cashflow to REALIZED_DEFERRED state
     */
    public Mono<Cashflow> transitionToRealizedDeferred(Cashflow cashflow, String reason) {
        logger.info("Transitioning cashflow {} to REALIZED_DEFERRED state, reason: {}", cashflow.getId(), reason);
        
        if (canTransitionTo(cashflow.getStatus(), CashflowStatus.REALIZED_DEFERRED)) {
            cashflow.setStatus(CashflowStatus.REALIZED_DEFERRED);
            cashflow.setUpdatedAt(LocalDateTime.now());
            cashflow.setNotes(reason);
            return cashflowRepository.save(cashflow);
        } else {
            return Mono.error(new InvalidStateTransitionException(
                "Cannot transition from " + cashflow.getStatus() + " to REALIZED_DEFERRED"));
        }
    }
    
    /**
     * Transition cashflow to REALIZED_UNSETTLED state
     */
    public Mono<Cashflow> transitionToRealizedUnsettled(Cashflow cashflow) {
        logger.info("Transitioning cashflow {} to REALIZED_UNSETTLED state", cashflow.getId());
        
        if (canTransitionTo(cashflow.getStatus(), CashflowStatus.REALIZED_UNSETTLED)) {
            cashflow.setStatus(CashflowStatus.REALIZED_UNSETTLED);
            cashflow.setUpdatedAt(LocalDateTime.now());
            return cashflowRepository.save(cashflow);
        } else {
            return Mono.error(new InvalidStateTransitionException(
                "Cannot transition from " + cashflow.getStatus() + " to REALIZED_UNSETTLED"));
        }
    }
    
    /**
     * Transition cashflow to REALIZED_SETTLED state
     */
    public Mono<Cashflow> transitionToRealizedSettled(Cashflow cashflow, LocalDate settlementDate) {
        logger.info("Transitioning cashflow {} to REALIZED_SETTLED state, settlement date: {}", 
                   cashflow.getId(), settlementDate);
        
        if (canTransitionTo(cashflow.getStatus(), CashflowStatus.REALIZED_SETTLED)) {
            cashflow.setStatus(CashflowStatus.REALIZED_SETTLED);
            cashflow.setSettlementDate(settlementDate);
            cashflow.setUpdatedAt(LocalDateTime.now());
            return cashflowRepository.save(cashflow);
        } else {
            return Mono.error(new InvalidStateTransitionException(
                "Cannot transition from " + cashflow.getStatus() + " to REALIZED_SETTLED"));
        }
    }
    
    /**
     * Transition cashflow to CANCELLED state
     */
    public Mono<Cashflow> transitionToCancelled(Cashflow cashflow, String reason) {
        logger.info("Transitioning cashflow {} to CANCELLED state, reason: {}", cashflow.getId(), reason);
        
        if (canTransitionTo(cashflow.getStatus(), CashflowStatus.CANCELLED)) {
            cashflow.setStatus(CashflowStatus.CANCELLED);
            cashflow.setUpdatedAt(LocalDateTime.now());
            cashflow.setNotes(reason);
            return cashflowRepository.save(cashflow);
        } else {
            return Mono.error(new InvalidStateTransitionException(
                "Cannot transition from " + cashflow.getStatus() + " to CANCELLED"));
        }
    }
    
    /**
     * Transition cashflow to ADJUSTED state
     */
    public Mono<Cashflow> transitionToAdjusted(Cashflow cashflow, String reason) {
        logger.info("Transitioning cashflow {} to ADJUSTED state, reason: {}", cashflow.getId(), reason);
        
        if (canTransitionTo(cashflow.getStatus(), CashflowStatus.ADJUSTED)) {
            cashflow.setStatus(CashflowStatus.ADJUSTED);
            cashflow.setUpdatedAt(LocalDateTime.now());
            cashflow.setNotes(reason);
            return cashflowRepository.save(cashflow);
        } else {
            return Mono.error(new InvalidStateTransitionException(
                "Cannot transition from " + cashflow.getStatus() + " to ADJUSTED"));
        }
    }
    
    /**
     * Batch transition multiple cashflows to a new state
     */
    public Flux<Cashflow> batchTransition(List<UUID> cashflowIds, CashflowStatus newStatus, String reason) {
        logger.info("Batch transitioning {} cashflows to {} state", cashflowIds.size(), newStatus);
        
        return Flux.fromIterable(cashflowIds)
                .flatMap(id -> cashflowRepository.findById(id))
                .flatMap(cashflow -> {
                    switch (newStatus) {
                        case REALIZED_DEFERRED:
                            return transitionToRealizedDeferred(cashflow, reason);
                        case REALIZED_UNSETTLED:
                            return transitionToRealizedUnsettled(cashflow);
                        case REALIZED_SETTLED:
                            return transitionToRealizedSettled(cashflow, LocalDate.now());
                        case CANCELLED:
                            return transitionToCancelled(cashflow, reason);
                        case ADJUSTED:
                            return transitionToAdjusted(cashflow, reason);
                        default:
                            return Mono.just(cashflow);
                    }
                });
    }
    
    /**
     * Process settlement for cashflows
     */
    public Flux<Cashflow> processSettlement(LocalDate settlementDate) {
        logger.info("Processing settlement for date: {}", settlementDate);
        
        return cashflowRepository.findCashflowsForSettlement(settlementDate)
                .flatMap(cashflow -> transitionToRealizedSettled(cashflow, settlementDate));
    }
    
    /**
     * Process accruals for a specific date
     */
    public Flux<Cashflow> processAccruals(LocalDate accrualDate) {
        logger.info("Processing accruals for date: {}", accrualDate);
        
        return cashflowRepository.findCashflowsForAccrual(accrualDate)
                .flatMap(this::transitionToAccrued);
    }
    
    /**
     * Check if a state transition is valid
     */
    private boolean canTransitionTo(CashflowStatus currentStatus, CashflowStatus newStatus) {
        return switch (currentStatus) {
            case ACCRUED -> newStatus == CashflowStatus.REALIZED_DEFERRED || 
                           newStatus == CashflowStatus.REALIZED_UNSETTLED || 
                           newStatus == CashflowStatus.CANCELLED || 
                           newStatus == CashflowStatus.ADJUSTED;
            
            case REALIZED_DEFERRED -> newStatus == CashflowStatus.REALIZED_UNSETTLED || 
                                    newStatus == CashflowStatus.CANCELLED || 
                                    newStatus == CashflowStatus.ADJUSTED;
            
            case REALIZED_UNSETTLED -> newStatus == CashflowStatus.REALIZED_SETTLED || 
                                     newStatus == CashflowStatus.CANCELLED || 
                                     newStatus == CashflowStatus.ADJUSTED;
            
            case REALIZED_SETTLED -> newStatus == CashflowStatus.ADJUSTED;
            
            case CANCELLED, ADJUSTED -> false; // Terminal states
            
            default -> false;
        };
    }
    
    /**
     * Get cashflows by status
     */
    public Flux<Cashflow> getCashflowsByStatus(CashflowStatus status) {
        return cashflowRepository.findByStatus(status);
    }
    
    /**
     * Get cashflows by contract and status
     */
    public Flux<Cashflow> getCashflowsByContractAndStatus(UUID contractId, CashflowStatus status) {
        return cashflowRepository.findByContractIdAndStatus(contractId, status);
    }
    
    /**
     * Get cashflows for settlement processing
     */
    public Flux<Cashflow> getCashflowsForSettlement(LocalDate settlementDate) {
        return cashflowRepository.findCashflowsForSettlement(settlementDate);
    }
    
    /**
     * Get cashflows for accrual processing
     */
    public Flux<Cashflow> getCashflowsForAccrual(LocalDate accrualDate) {
        return cashflowRepository.findCashflowsForAccrual(accrualDate);
    }
    
    /**
     * Count cashflows by status
     */
    public Mono<Long> countCashflowsByStatus(CashflowStatus status) {
        return cashflowRepository.findByStatus(status).count();
    }
    
    /**
     * Count cashflows by contract and status
     */
    public Mono<Long> countCashflowsByContractAndStatus(UUID contractId, CashflowStatus status) {
        return cashflowRepository.countByContractIdAndStatus(contractId, status);
    }
    
    // ===== High-level API Methods =====
    
    /**
     * Transition cashflow status with validation and audit trail.
     */
    public Mono<Cashflow> transitionStatus(Cashflow cashflow, CashflowStatus newStatus, String reason, String updatedBy) {
        logger.info("Transitioning cashflow {} from {} to {}, reason: {}", 
                   cashflow.getId(), cashflow.getStatus(), newStatus, reason);
        
        if (!canTransitionTo(cashflow.getStatus(), newStatus)) {
            return Mono.error(new InvalidStateTransitionException(
                String.format("Cannot transition from %s to %s", cashflow.getStatus(), newStatus)));
        }
        
        cashflow.setStatus(newStatus);
        cashflow.setUpdatedAt(LocalDateTime.now());
        cashflow.setUpdatedBy(updatedBy);
        cashflow.setNotes(reason);
        
        return cashflowRepository.save(cashflow);
    }
    
    /**
     * Defer a cashflow with business justification.
     */
    public Mono<Cashflow> deferCashflow(Cashflow cashflow, String deferralReason, LocalDate expectedRealizationDate,
                                       Integer deferralPeriodDays, String businessJustification, String updatedBy) {
        logger.info("Deferring cashflow {} until {}, reason: {}", 
                   cashflow.getId(), expectedRealizationDate, deferralReason);
        
        if (!canTransitionTo(cashflow.getStatus(), CashflowStatus.REALIZED_DEFERRED)) {
            return Mono.error(new InvalidStateTransitionException(
                String.format("Cannot defer cashflow in status %s", cashflow.getStatus())));
        }
        
        cashflow.setStatus(CashflowStatus.REALIZED_DEFERRED);
        cashflow.setDeferralDate(LocalDate.now());
        cashflow.setExpectedRealizationDate(expectedRealizationDate);
        cashflow.setDeferralPeriodDays(deferralPeriodDays);
        cashflow.setNotes(businessJustification);
        cashflow.setUpdatedAt(LocalDateTime.now());
        cashflow.setUpdatedBy(updatedBy);
        
        return cashflowRepository.save(cashflow);
    }
    
    /**
     * Realize a cashflow with specified amount and date.
     */
    public Mono<Cashflow> realizeCashflow(Cashflow cashflow, LocalDate realizationDate, 
                                         BigDecimal realizationAmount, String updatedBy) {
        logger.info("Realizing cashflow {} on {} with amount {}", 
                   cashflow.getId(), realizationDate, realizationAmount);
        
        if (!canTransitionTo(cashflow.getStatus(), CashflowStatus.REALIZED_UNSETTLED)) {
            return Mono.error(new InvalidStateTransitionException(
                String.format("Cannot realize cashflow in status %s", cashflow.getStatus())));
        }
        
        cashflow.setStatus(CashflowStatus.REALIZED_UNSETTLED);
        cashflow.setExpectedRealizationDate(realizationDate);
        if (realizationAmount != null) {
            cashflow.setAmount(realizationAmount);
        }
        cashflow.setUpdatedAt(LocalDateTime.now());
        cashflow.setUpdatedBy(updatedBy);
        
        return cashflowRepository.save(cashflow);
    }
    
    /**
     * Settle a cashflow with payment details.
     */
    public Mono<Cashflow> settleCashflow(Cashflow cashflow, LocalDate settlementDate, 
                                        BigDecimal settlementAmount, String paymentReference, String updatedBy) {
        logger.info("Settling cashflow {} on {} with amount {}, payment ref: {}", 
                   cashflow.getId(), settlementDate, settlementAmount, paymentReference);
        
        if (!canTransitionTo(cashflow.getStatus(), CashflowStatus.REALIZED_SETTLED)) {
            return Mono.error(new InvalidStateTransitionException(
                String.format("Cannot settle cashflow in status %s", cashflow.getStatus())));
        }
        
        cashflow.setStatus(CashflowStatus.REALIZED_SETTLED);
        cashflow.setSettlementDate(settlementDate);
        if (settlementAmount != null) {
            cashflow.setAmount(settlementAmount);
        }
        cashflow.setNotes(paymentReference != null ? "Payment Reference: " + paymentReference : null);
        cashflow.setUpdatedAt(LocalDateTime.now());
        cashflow.setUpdatedBy(updatedBy);
        
        return cashflowRepository.save(cashflow);
    }
    
    /**
     * Update cashflow status
     */
    public Mono<Cashflow> updateCashflowStatus(UUID cashflowId, CashflowStatus status) {
        // Mock implementation - create a simple cashflow with the new status
        Cashflow mockCashflow = new Cashflow(
            UUID.randomUUID(), // contractId
            cashflowId,
            "MOCK_SECURITY",
            com.lifecycle.cashflow.model.CalculationType.INTEREST,
            com.lifecycle.cashflow.model.CashflowType.INTEREST,
            BigDecimal.valueOf(1000.00),
            "USD",
            LocalDate.now(),
            "SYSTEM"
        );
        mockCashflow.setStatus(status);
        return Mono.just(mockCashflow);
    }
}
