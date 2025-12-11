# CDM Alignment - Common Domain Model Compliance

## Overview
This document describes how the Equity Swaps Lifecycle Management System aligns with the FINOS Common Domain Model (CDM) standards. The system implements CDM primitives, event models, and data structures to ensure interoperability and compliance.

## CDM Compliance Principles

### 1. Standardization
- All data models follow CDM specifications
- Event structures align with CDM Event Model
- Product definitions use CDM Product Model
- Legal agreements follow CDM Legal Agreements Model

### 2. Interoperability
- Standardized data formats for external integration
- CDM-compliant APIs for third-party consumption
- Consistent event schemas across all services
- Standardized reference data models

### 3. Extensibility
- CDM primitives as building blocks
- Custom extensions for equity swap specifics
- Version management for schema evolution
- Backward compatibility guarantees

## CDM Primitives Mapping

### Core CDM Entities

#### 1. Trade Primitive
```java
@CDMEntity(type = "Trade")
public class SwapBlotter {
    @CDMField(name = "tradeIdentifier")
    private List<TradeIdentifier> tradeIdentifiers;
    
    @CDMField(name = "tradeDate")
    private LocalDate tradeDate;
    
    @CDMField(name = "party")
    private List<Party> parties;
    
    @CDMField(name = "partyRole")
    private List<PartyRole> partyRoles;
    
    @CDMField(name = "executionDetails")
    private ExecutionDetails executionDetails;
    
    @CDMField(name = "contractDetails")
    private ContractDetails contractDetails;
    
    // Equity swap specific fields
    private EquitySwapProduct equitySwapProduct;
    private EnrichmentStatus enrichmentStatus;
}
```

#### 2. Contract Primitive
```java
@CDMEntity(type = "Contract")
public class EquitySwapContract {
    @CDMField(name = "contractIdentifier")
    private List<ContractIdentifier> contractIdentifiers;
    
    @CDMField(name = "contractualProduct")
    private EquitySwapProduct contractualProduct;
    
    @CDMField(name = "trade")
    private List<Trade> trades;
    
    @CDMField(name = "state")
    private ContractState state;
    
    // Equity swap specific fields
    private List<EquityLeg> equityLegs;
    private List<InterestLeg> interestLegs;
    private List<Lot> lots;
}
```

#### 3. Product Primitive
```java
@CDMEntity(type = "TradableProduct")
public class EquitySwapProduct {
    @CDMField(name = "productIdentifier")
    private List<ProductIdentifier> productIdentifiers;
    
    @CDMField(name = "productType")
    private ProductTypeEnum productType;
    
    @CDMField(name = "economicTerms")
    private EquitySwapEconomicTerms economicTerms;
    
    @CDMField(name = "legalAgreement")
    private List<LegalAgreement> legalAgreements;
    
    // Equity swap specific fields
    private List<EquityLeg> equityLegs;
    private List<InterestLeg> interestLegs;
    private PricingModel pricingModel;
}
```

#### 4. Event Primitive
```java
@CDMEntity(type = "BusinessEvent")
public abstract class EquitySwapBusinessEvent {
    @CDMField(name = "before")
    private List<TradeState> beforeTradeStates;
    
    @CDMField(name = "after")
    private List<TradeState> afterTradeStates;
    
    @CDMField(name = "primitiveInstruction")
    private List<PrimitiveInstruction> primitiveInstructions;
    
    @CDMField(name = "eventDate")
    private LocalDate eventDate;
    
    @CDMField(name = "effectiveDate")
    private LocalDate effectiveDate;
    
    @CDMField(name = "eventIdentifier")
    private List<Identifier> eventIdentifiers;
}
```

## CDM Event Model Alignment

### Event Structure Compliance

#### 1. Trade State Representation
```java
@CDMEntity(type = "TradeState")
public class EquitySwapTradeState {
    @CDMField(name = "trade")
    private Trade trade;
    
    @CDMField(name = "state")
    private State state;
    
    @CDMField(name = "resetHistory")
    private List<Reset> resetHistory;
    
    @CDMField(name = "transferHistory")
    private List<TransferState> transferHistory;
    
    // Equity swap specific state
    private SwapState swapState;
    private PositionState positionState;
    private CashflowState cashflowState;
}
```

#### 2. State Transitions
```java
@CDMEntity(type = "State")
public class EquitySwapState {
    @CDMField(name = "closedState")
    private ClosedState closedState;
    
    @CDMField(name = "positionState")
    private PositionStatusEnum positionState;
    
    // Equity swap specific states
    private SwapStatusEnum swapStatus;
    private LotStatusEnum lotStatus;
    private CashflowStatusEnum cashflowStatus;
}
```

### Primitive Instructions

#### 1. Contract Formation
```java
@CDMEntity(type = "PrimitiveInstruction")
public class CreateContractInstruction extends PrimitiveInstruction {
    @CDMField(name = "primitiveOperator")
    private PrimitiveOperator primitiveOperator;
    
    @CDMField(name = "primitiveFunction")
    private CreateContractFunction primitiveFunction;
    
    @CDMField(name = "before")
    private List<TradeState> beforeTradeStates;
    
    @CDMField(name = "after")
    private List<TradeState> afterTradeStates;
}
```

#### 2. Position Update
```java
public class UpdatePositionInstruction extends PrimitiveInstruction {
    private UpdatePositionFunction updatePositionFunction;
    private PositionChange positionChange;
    private Lot lot;
}
```

## CDM Product Model Alignment

### Equity Swap Product Structure

#### 1. Economic Terms
```java
@CDMEntity(type = "EconomicTerms")
public class EquitySwapEconomicTerms {
    @CDMField(name = "paymentCalculation")
    private List<PaymentCalculation> paymentCalculations;
    
    @CDMField(name = "schedule")
    private List<Schedule> schedules;
    
    @CDMField(name = "pricing")
    private Pricing pricing;
    
    // Equity swap specific terms
    private List<EquityLegTerms> equityLegTerms;
    private List<InterestLegTerms> interestLegTerms;
    private DividendHandling dividendHandling;
}
```

#### 2. Equity Leg Terms
```java
public class EquityLegTerms {
    @CDMField(name = "underlier")
    private List<Underlier> underliers;
    
    @CDMField(name = "quantity")
    private Quantity quantity;
    
    @CDMField(name = "price")
    private Price price;
    
    @CDMField(name = "currency")
    private Currency currency;
    
    // Equity swap specific
    private DividendReinvestment dividendReinvestment;
    private CorporateActionHandling corporateActionHandling;
    private BasketWeighting basketWeighting;
}
```

#### 3. Interest Leg Terms
```java
public class InterestLegTerms {
    @CDMField(name = "interestRate")
    private InterestRate interestRate;
    
    @CDMField(name = "dayCountFraction")
    private DayCountFraction dayCountFraction;
    
    @CDMField(name = "paymentFrequency")
    private PaymentFrequency paymentFrequency;
    
    @CDMField(name = "currency")
    private Currency currency;
    
    // Equity swap specific
    private InterestCalculationMethod calculationMethod;
    private Spread spread;
    private CapFloor capFloor;
}
```

## CDM Legal Agreements Model

### Master Agreement Structure
```java
@CDMEntity(type = "LegalAgreement")
public class ISDAEquitySwapAgreement extends LegalAgreement {
    @CDMField(name = "agreementIdentifier")
    private List<AgreementIdentifier> agreementIdentifiers;
    
    @CDMField(name = "agreementType")
    private AgreementTypeEnum agreementType;
    
    @CDMField(name = "governingLaw")
    private GoverningLawEnum governingLaw;
    
    @CDMField(name = "effectiveDate")
    private LocalDate effectiveDate;
    
    // ISDA specific fields
    private ISDASchedule schedule;
    private CreditSupportAnnex csa;
    private List<Annex> annexes;
}
```

### Contractual Terms
```java
public class ContractualTerms {
    @CDMField(name = "documentation")
    private List<LegalAgreement> documentation;
    
    @CDMField(name = "governingLaw")
    private GoverningLawEnum governingLaw;
    
    @CDMField(name = "jurisdiction")
    private Jurisdiction jurisdiction;
    
    // Equity swap specific
    private EarlyTerminationTerms earlyTermination;
    private DisputeResolution disputeResolution;
    private ForceMajeure forceMajeure;
}
```

## CDM Process Model Alignment

### Workflow Implementation
```java
@CDMEntity(type = "WorkflowStep")
public class EquitySwapWorkflowStep {
    @CDMField(name = "businessEvent")
    private BusinessEvent businessEvent;
    
    @CDMField(name = "proposedEvent")
    private EventInstruction proposedEvent;
    
    @CDMField(name = "action")
    private ActionEnum action;
    
    @CDMField(name = "timestamp")
    private List<EventTimestamp> timestamps;
    
    @CDMField(name = "eventIdentifier")
    private List<Identifier> eventIdentifiers;
    
    // Workflow specific
    private WorkflowState workflowState;
    private List<Approval> approvals;
    private String nextStep;
}
```

### Process Orchestration
```java
@Component
public class CDMCompliantWorkflowOrchestrator {
    
    public WorkflowStep executeWorkflowStep(WorkflowStep step) {
        // Validate CDM compliance
        validateCDMCompliance(step);
        
        // Execute business logic
        BusinessEvent result = executeBusinessEvent(step);
        
        // Create next workflow step
        return createNextWorkflowStep(step, result);
    }
    
    private void validateCDMCompliance(WorkflowStep step) {
        // Validate required CDM fields
        validateRequiredFields(step);
        
        // Validate CDM data types
        validateDataTypes(step);
        
        // Validate CDM business rules
        validateBusinessRules(step);
    }
}
```

## CDM Reference Data Model

### Standardized Reference Data
```java
@CDMEntity(type = "ReferenceData")
public class CDMCompliantReferenceData {
    @CDMField(name = "identifier")
    private List<Identifier> identifiers;
    
    @CDMField(name = "issuer")
    private Party issuer;
    
    @CDMField(name = "validity")
    private Validity validity;
    
    // Reference data specific
    private ReferenceDataType dataType;
    private String dataSource;
    private LocalDateTime lastUpdated;
}
```

### Counterparty Data
```java
@CDMEntity(type = "Party")
public class CDMCompliantCounterparty extends Party {
    @CDMField(name = "partyIdentifier")
    private List<PartyIdentifier> partyIdentifiers;
    
    @CDMField(name = "partyName")
    private List<PartyName> partyNames;
    
    @CDMField(name = "address")
    private List<Address> addresses;
    
    // Counterparty specific
    private CounterpartyType counterpartyType;
    private List<RegulatoryIdentifier> regulatoryIdentifiers;
    private CreditRating creditRating;
}
```

## CDM Validation and Compliance

### Validation Framework
```java
@Component
public class CDMValidationService {
    
    public ValidationResult validateCDMCompliance(Object entity) {
        ValidationResult result = new ValidationResult();
        
        // Validate CDM annotations
        validateCDMAnnotations(entity, result);
        
        // Validate required fields
        validateRequiredFields(entity, result);
        
        // Validate data types
        validateDataTypes(entity, result);
        
        // Validate business rules
        validateBusinessRules(entity, result);
        
        return result;
    }
    
    private void validateCDMAnnotations(Object entity, ValidationResult result) {
        Class<?> entityClass = entity.getClass();
        
        if (!entityClass.isAnnotationPresent(CDMEntity.class)) {
            result.addError("Entity must be annotated with @CDMEntity");
        }
        
        // Validate field annotations
        validateFieldAnnotations(entityClass, result);
    }
}
```

### Compliance Monitoring
```java
@Component
public class CDMComplianceMonitor {
    
    @EventListener
    public void monitorCDMCompliance(DomainEvent event) {
        // Check CDM compliance
        ValidationResult result = cdmValidationService.validateCDMCompliance(event);
        
        if (!result.isValid()) {
            // Log compliance violations
            logCDMComplianceViolation(event, result);
            
            // Trigger compliance alerts
            triggerComplianceAlert(event, result);
        }
        
        // Record compliance metrics
        recordComplianceMetrics(event, result);
    }
}
```

## CDM Schema Evolution

### Version Management
```java
@Component
public class CDMSchemaVersionManager {
    
    public void migrateToNewCDMVersion(String targetVersion) {
        // Check current version
        String currentVersion = getCurrentCDMVersion();
        
        if (!currentVersion.equals(targetVersion)) {
            // Perform schema migration
            performSchemaMigration(currentVersion, targetVersion);
            
            // Update version metadata
            updateCDMVersionMetadata(targetVersion);
            
            // Notify stakeholders
            notifyCDMVersionChange(targetVersion);
        }
    }
    
    private void performSchemaMigration(String fromVersion, String toVersion) {
        // Load migration scripts
        List<MigrationScript> scripts = loadMigrationScripts(fromVersion, toVersion);
        
        // Execute migrations
        for (MigrationScript script : scripts) {
            executeMigrationScript(script);
        }
    }
}
```

## CDM Integration Patterns

### External System Integration
```java
@Component
public class CDMIntegrationService {
    
    public <T> T convertToCDMFormat(Object internalEntity, Class<T> cdmType) {
        // Convert internal entity to CDM format
        T cdmEntity = cdmConverter.convert(internalEntity, cdmType);
        
        // Validate CDM compliance
        ValidationResult result = cdmValidationService.validateCDMCompliance(cdmEntity);
        
        if (!result.isValid()) {
            throw new CDMComplianceException("Entity not CDM compliant: " + result.getErrors());
        }
        
        return cdmEntity;
    }
    
    public <T> T convertFromCDMFormat(Object cdmEntity, Class<T> internalType) {
        // Validate incoming CDM entity
        ValidationResult result = cdmValidationService.validateCDMCompliance(cdmEntity);
        
        if (!result.isValid()) {
            throw new CDMComplianceException("Incoming entity not CDM compliant: " + result.getErrors());
        }
        
        // Convert to internal format
        return cdmConverter.convert(cdmEntity, internalType);
    }
}
```

## Next Steps
1. Review [Entity Models](../domain/entity-models.md) for detailed CDM implementations
2. Examine [Service Architecture](../microservices/service-architecture.md) for CDM-compliant services
3. Review [Trade Lifecycle](../business/trade-lifecycle.md) for CDM-aligned business processes
4. Begin with [Technology Stack](../implementation/technology-stack.md) for CDM implementation details
