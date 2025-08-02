package com.finos.synthetics.instruction.service;

import com.finos.synthetics.instruction.model.InstructionRequest;
import com.finos.synthetics.instruction.model.InstructionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Instruction Validation Service
 * 
 * Service for validating instruction requests before processing.
 * 
 * @version 1.0.0
 */
@Service
public class InstructionValidationService {

    private static final Logger logger = LoggerFactory.getLogger(InstructionValidationService.class);

    private final Validator validator;

    public InstructionValidationService(Validator validator) {
        this.validator = validator;
    }

    /**
     * Validate an instruction request
     */
    public InstructionResponse validateRequest(InstructionRequest request) {
        List<String> errors = new ArrayList<>();

        // Basic validation
        if (request == null) {
            errors.add("Instruction request cannot be null");
            return createValidationErrorResponse(request, errors);
        }

        // Bean validation
        Set<ConstraintViolation<InstructionRequest>> violations = validator.validate(request);
        for (ConstraintViolation<InstructionRequest> violation : violations) {
            errors.add(violation.getPropertyPath() + ": " + violation.getMessage());
        }

        // Business logic validation
        validateBusinessRules(request, errors);

        if (!errors.isEmpty()) {
            logger.warn("Instruction validation failed for {}: {}", 
                request.getInstructionId(), errors);
            return createValidationErrorResponse(request, errors);
        }

        // Create success response
        InstructionResponse response = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.SUCCESS);
        response.setHandlerService("VALIDATION_SERVICE");
        response.setCorrelationId(request.getCorrelationId());
        
        return response;
    }

    /**
     * Validate business rules for instruction requests
     */
    private void validateBusinessRules(InstructionRequest request, List<String> errors) {
        
        // Validate instruction type
        if (request.getInstructionType() == null) {
            errors.add("Instruction type is required");
        }

        // Validate instruction data
        if (request.getInstructionData() == null || request.getInstructionData().trim().isEmpty()) {
            errors.add("Instruction data is required");
        }

        // Validate instruction data format based on type
        if (request.getInstructionType() != null && request.getInstructionData() != null) {
            validateInstructionDataFormat(request, errors);
        }

        // Validate priority
        if (request.getPriority() == null) {
            errors.add("Priority is required");
        }

        // Validate source system
        if (request.getSourceSystem() == null || request.getSourceSystem().trim().isEmpty()) {
            errors.add("Source system is required");
        }

        // Validate request timestamp
        if (request.getRequestTimestamp() == null) {
            errors.add("Request timestamp is required");
        }
    }

    /**
     * Validate instruction data format based on instruction type
     */
    private void validateInstructionDataFormat(InstructionRequest request, List<String> errors) {
        try {
            String instructionData = request.getInstructionData();
            
            switch (request.getInstructionType()) {
                case CONTRACT_FORMATION:
                    validateContractFormationData(instructionData, errors);
                    break;
                    
                case EXECUTION:
                    validateExecutionData(instructionData, errors);
                    break;
                    
                case EXERCISE:
                    validateExerciseData(instructionData, errors);
                    break;
                    
                case RESET:
                    validateResetData(instructionData, errors);
                    break;
                    
                case PARTY_CHANGE:
                    validatePartyChangeData(instructionData, errors);
                    break;
                    
                case SPLIT:
                    validateSplitData(instructionData, errors);
                    break;
                    
                case QUANTITY_CHANGE:
                    validateQuantityChangeData(instructionData, errors);
                    break;
                    
                case TERMS_CHANGE:
                    validateTermsChangeData(instructionData, errors);
                    break;
                    
                case TRANSFER:
                    validateTransferData(instructionData, errors);
                    break;
                    
                case INDEX_TRANSITION:
                    validateIndexTransitionData(instructionData, errors);
                    break;
                    
                case STOCK_SPLIT:
                    validateStockSplitData(instructionData, errors);
                    break;
                    
                case OBSERVATION:
                    validateObservationData(instructionData, errors);
                    break;
                    
                case VALUATION:
                    validateValuationData(instructionData, errors);
                    break;
                    
                default:
                    errors.add("Unknown instruction type: " + request.getInstructionType());
                    break;
            }
            
        } catch (Exception e) {
            errors.add("Error validating instruction data format: " + e.getMessage());
        }
    }

    /**
     * Validate contract formation instruction data
     */
    private void validateContractFormationData(String instructionData, List<String> errors) {
        if (!instructionData.contains("legalAgreement") && !instructionData.contains("contract")) {
            errors.add("Contract formation data must contain legal agreement or contract information");
        }
    }

    /**
     * Validate execution instruction data
     */
    private void validateExecutionData(String instructionData, List<String> errors) {
        if (!instructionData.contains("product") || !instructionData.contains("counterparty")) {
            errors.add("Execution data must contain product and counterparty information");
        }
    }

    /**
     * Validate exercise instruction data
     */
    private void validateExerciseData(String instructionData, List<String> errors) {
        if (!instructionData.contains("exerciseOption") || !instructionData.contains("exerciseDate")) {
            errors.add("Exercise data must contain exercise option and exercise date");
        }
    }

    /**
     * Validate reset instruction data
     */
    private void validateResetData(String instructionData, List<String> errors) {
        if (!instructionData.contains("resetDate") || !instructionData.contains("payout")) {
            errors.add("Reset data must contain reset date and payout information");
        }
    }

    /**
     * Validate party change instruction data
     */
    private void validatePartyChangeData(String instructionData, List<String> errors) {
        if (!instructionData.contains("counterparty") || !instructionData.contains("tradeId")) {
            errors.add("Party change data must contain counterparty and trade ID information");
        }
    }

    /**
     * Validate split instruction data
     */
    private void validateSplitData(String instructionData, List<String> errors) {
        if (!instructionData.contains("breakdown")) {
            errors.add("Split data must contain breakdown information");
        }
    }

    /**
     * Validate quantity change instruction data
     */
    private void validateQuantityChangeData(String instructionData, List<String> errors) {
        if (!instructionData.contains("quantity")) {
            errors.add("Quantity change data must contain quantity information");
        }
    }

    /**
     * Validate terms change instruction data
     */
    private void validateTermsChangeData(String instructionData, List<String> errors) {
        if (!instructionData.contains("newTerms")) {
            errors.add("Terms change data must contain new terms information");
        }
    }

    /**
     * Validate transfer instruction data
     */
    private void validateTransferData(String instructionData, List<String> errors) {
        if (!instructionData.contains("fromParty") || !instructionData.contains("toParty")) {
            errors.add("Transfer data must contain from and to party information");
        }
    }

    /**
     * Validate index transition instruction data
     */
    private void validateIndexTransitionData(String instructionData, List<String> errors) {
        if (!instructionData.contains("oldIndex") || !instructionData.contains("newIndex")) {
            errors.add("Index transition data must contain old and new index information");
        }
    }

    /**
     * Validate stock split instruction data
     */
    private void validateStockSplitData(String instructionData, List<String> errors) {
        if (!instructionData.contains("splitRatio")) {
            errors.add("Stock split data must contain split ratio information");
        }
    }

    /**
     * Validate observation instruction data
     */
    private void validateObservationData(String instructionData, List<String> errors) {
        if (!instructionData.contains("observationDate")) {
            errors.add("Observation data must contain observation date information");
        }
    }

    /**
     * Validate valuation instruction data
     */
    private void validateValuationData(String instructionData, List<String> errors) {
        if (!instructionData.contains("valuationDate")) {
            errors.add("Valuation data must contain valuation date information");
        }
    }

    /**
     * Create validation error response
     */
    private InstructionResponse createValidationErrorResponse(InstructionRequest request, List<String> errors) {
        InstructionResponse response = new InstructionResponse(
            request != null ? request.getInstructionId() : "UNKNOWN", 
            InstructionResponse.Status.VALIDATION_ERROR
        );
        response.setErrorMessage("Validation failed: " + String.join(", ", errors));
        response.setValidationErrors(errors);
        response.setHandlerService("VALIDATION_SERVICE");
        if (request != null) {
            response.setCorrelationId(request.getCorrelationId());
        }
        return response;
    }
} 