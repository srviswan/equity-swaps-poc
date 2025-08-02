// This file is auto-generated from the ISDA Common Domain Model, do not edit.
//
// Version: 6.0.0
//

#nullable enable // Allow nullable reference types

namespace Org.Isda.Cdm.MetaFields
{
    using System.Collections.Generic;

    using Newtonsoft.Json;
    using Newtonsoft.Json.Converters;

    using NodaTime;

    using Rosetta.Lib.Meta;


public class Key
{
    [JsonConstructor]
    public Key(string keyValue, string? scope)
    {
        Scope = scope;
        KeyValue = keyValue;
    }
    
    [JsonProperty("value")]
    public string KeyValue { get; }
    public string? Scope { get; }
}

public class Reference
{
    [JsonConstructor]
    public Reference(string? reference, string? scope)
    {
        Scope = scope;
        ReferenceValue = reference;
    }
    [JsonProperty("value")]
    public string? ReferenceValue { get; }
    public string? Scope { get; }
}

    public class ReferenceWithMetaParty : IReferenceWithMeta<Party>
    {
        [JsonConstructor]
        public ReferenceWithMetaParty(Party? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public Party? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaBusinessDayAdjustments : IReferenceWithMeta<BusinessDayAdjustments>
    {
        [JsonConstructor]
        public ReferenceWithMetaBusinessDayAdjustments(BusinessDayAdjustments? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public BusinessDayAdjustments? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaTrade : IReferenceWithMeta<Trade>
    {
        [JsonConstructor]
        public ReferenceWithMetaTrade(Trade? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public Trade? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaNonNegativeQuantitySchedule : IReferenceWithMeta<NonNegativeQuantitySchedule>
    {
        [JsonConstructor]
        public ReferenceWithMetaNonNegativeQuantitySchedule(NonNegativeQuantitySchedule? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public NonNegativeQuantitySchedule? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaPriceSchedule : IReferenceWithMeta<PriceSchedule>
    {
        [JsonConstructor]
        public ReferenceWithMetaPriceSchedule(PriceSchedule? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public PriceSchedule? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaTradeState : IReferenceWithMeta<TradeState>
    {
        [JsonConstructor]
        public ReferenceWithMetaTradeState(TradeState? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public TradeState? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaBusinessCenters : IReferenceWithMeta<BusinessCenters>
    {
        [JsonConstructor]
        public ReferenceWithMetaBusinessCenters(BusinessCenters? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public BusinessCenters? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaPayout : IReferenceWithMeta<Payout>
    {
        [JsonConstructor]
        public ReferenceWithMetaPayout(Payout? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public Payout? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaCollateralPortfolio : IReferenceWithMeta<CollateralPortfolio>
    {
        [JsonConstructor]
        public ReferenceWithMetaCollateralPortfolio(CollateralPortfolio? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public CollateralPortfolio? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaLegalAgreement : IReferenceWithMeta<LegalAgreement>
    {
        [JsonConstructor]
        public ReferenceWithMetaLegalAgreement(LegalAgreement? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public LegalAgreement? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaContractDetails : IReferenceWithMeta<ContractDetails>
    {
        [JsonConstructor]
        public ReferenceWithMetaContractDetails(ContractDetails? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public ContractDetails? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaExecutionDetails : IReferenceWithMeta<ExecutionDetails>
    {
        [JsonConstructor]
        public ReferenceWithMetaExecutionDetails(ExecutionDetails? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public ExecutionDetails? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaCollateral : IReferenceWithMeta<Collateral>
    {
        [JsonConstructor]
        public ReferenceWithMetaCollateral(Collateral? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public Collateral? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaCalculationPeriodDates : IReferenceWithMeta<CalculationPeriodDates>
    {
        [JsonConstructor]
        public ReferenceWithMetaCalculationPeriodDates(CalculationPeriodDates? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public CalculationPeriodDates? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaPaymentDates : IReferenceWithMeta<PaymentDates>
    {
        [JsonConstructor]
        public ReferenceWithMetaPaymentDates(PaymentDates? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public PaymentDates? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaPerformanceValuationDates : IReferenceWithMeta<PerformanceValuationDates>
    {
        [JsonConstructor]
        public ReferenceWithMetaPerformanceValuationDates(PerformanceValuationDates? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public PerformanceValuationDates? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class BasicReferenceWithMetaString : IReferenceWithMeta<string>
    {
        [JsonConstructor]
        public BasicReferenceWithMetaString(string? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public string? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaAdjustableOrRelativeDate : IReferenceWithMeta<AdjustableOrRelativeDate>
    {
        [JsonConstructor]
        public ReferenceWithMetaAdjustableOrRelativeDate(AdjustableOrRelativeDate? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public AdjustableOrRelativeDate? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaBasketConstituent : IReferenceWithMeta<BasketConstituent>
    {
        [JsonConstructor]
        public ReferenceWithMetaBasketConstituent(BasketConstituent? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public BasketConstituent? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaMoney : IReferenceWithMeta<Money>
    {
        [JsonConstructor]
        public ReferenceWithMetaMoney(Money? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public Money? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaOptionPayout : IReferenceWithMeta<OptionPayout>
    {
        [JsonConstructor]
        public ReferenceWithMetaOptionPayout(OptionPayout? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public OptionPayout? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaPortfolioState : IReferenceWithMeta<PortfolioState>
    {
        [JsonConstructor]
        public ReferenceWithMetaPortfolioState(PortfolioState? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public PortfolioState? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaAdjustableOrRelativeDates : IReferenceWithMeta<AdjustableOrRelativeDates>
    {
        [JsonConstructor]
        public ReferenceWithMetaAdjustableOrRelativeDates(AdjustableOrRelativeDates? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public AdjustableOrRelativeDates? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaInterestRatePayout : IReferenceWithMeta<InterestRatePayout>
    {
        [JsonConstructor]
        public ReferenceWithMetaInterestRatePayout(InterestRatePayout? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public InterestRatePayout? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaInterestRateIndex : IReferenceWithMeta<InterestRateIndex>
    {
        [JsonConstructor]
        public ReferenceWithMetaInterestRateIndex(InterestRateIndex? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public InterestRateIndex? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaWorkflowStep : IReferenceWithMeta<WorkflowStep>
    {
        [JsonConstructor]
        public ReferenceWithMetaWorkflowStep(WorkflowStep? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public WorkflowStep? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaNaturalPerson : IReferenceWithMeta<NaturalPerson>
    {
        [JsonConstructor]
        public ReferenceWithMetaNaturalPerson(NaturalPerson? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public NaturalPerson? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaFixedRateSpecification : IReferenceWithMeta<FixedRateSpecification>
    {
        [JsonConstructor]
        public ReferenceWithMetaFixedRateSpecification(FixedRateSpecification? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public FixedRateSpecification? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaAccount : IReferenceWithMeta<Account>
    {
        [JsonConstructor]
        public ReferenceWithMetaAccount(Account? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public Account? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaObservable : IReferenceWithMeta<Observable>
    {
        [JsonConstructor]
        public ReferenceWithMetaObservable(Observable? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public Observable? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaRateObservation : IReferenceWithMeta<RateObservation>
    {
        [JsonConstructor]
        public ReferenceWithMetaRateObservation(RateObservation? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public RateObservation? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaLegalEntity : IReferenceWithMeta<LegalEntity>
    {
        [JsonConstructor]
        public ReferenceWithMetaLegalEntity(LegalEntity? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public LegalEntity? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaProtectionTerms : IReferenceWithMeta<ProtectionTerms>
    {
        [JsonConstructor]
        public ReferenceWithMetaProtectionTerms(ProtectionTerms? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public ProtectionTerms? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaCashSettlementTerms : IReferenceWithMeta<CashSettlementTerms>
    {
        [JsonConstructor]
        public ReferenceWithMetaCashSettlementTerms(CashSettlementTerms? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public CashSettlementTerms? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaPhysicalSettlementTerms : IReferenceWithMeta<PhysicalSettlementTerms>
    {
        [JsonConstructor]
        public ReferenceWithMetaPhysicalSettlementTerms(PhysicalSettlementTerms? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public PhysicalSettlementTerms? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class BasicReferenceWithMetaLocalDate : IValueReferenceWithMeta<NodaTime.LocalDate>
    {
        [JsonConstructor]
        public BasicReferenceWithMetaLocalDate(NodaTime.LocalDate? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        [JsonConverter(typeof(Rosetta.Lib.LocalDateConverter))]
        public NodaTime.LocalDate? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaObservation : IReferenceWithMeta<Observation>
    {
        [JsonConstructor]
        public ReferenceWithMetaObservation(Observation? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public Observation? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaResolvablePriceQuantity : IReferenceWithMeta<ResolvablePriceQuantity>
    {
        [JsonConstructor]
        public ReferenceWithMetaResolvablePriceQuantity(ResolvablePriceQuantity? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public ResolvablePriceQuantity? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaCreditEvents : IReferenceWithMeta<CreditEvents>
    {
        [JsonConstructor]
        public ReferenceWithMetaCreditEvents(CreditEvents? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public CreditEvents? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class ReferenceWithMetaQuotedCurrencyPair : IReferenceWithMeta<QuotedCurrencyPair>
    {
        [JsonConstructor]
        public ReferenceWithMetaQuotedCurrencyPair(QuotedCurrencyPair? value, string? globalReference, string? externalReference, Reference? address)
        {
            Value = value;
            GlobalReference = globalReference;
            ExternalReference = externalReference;
            Address = address;
        }
        
        public QuotedCurrencyPair? Value { get; }
        
        public string? GlobalReference { get; }
        
        public string? ExternalReference { get; }
        
        public Reference? Address { get; }
    }
    
    public class FieldWithMetaString : IFieldWithMeta<string>
    {
        [JsonConstructor]
        public FieldWithMetaString(string value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        public string Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaAccountTypeEnum : IEnumFieldWithMeta<Enums.AccountType>
    {
        [JsonConstructor]
        public FieldWithMetaAccountTypeEnum(Enums.AccountType value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.AccountType Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaLocalDate : IValueFieldWithMeta<NodaTime.LocalDate>
    {
        [JsonConstructor]
        public FieldWithMetaLocalDate(NodaTime.LocalDate value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(Rosetta.Lib.LocalDateConverter))]
        public NodaTime.LocalDate Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaCreditSupportAgreementTypeEnum : IEnumFieldWithMeta<Enums.CreditSupportAgreementType>
    {
        [JsonConstructor]
        public FieldWithMetaCreditSupportAgreementTypeEnum(Enums.CreditSupportAgreementType value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.CreditSupportAgreementType Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaContractualDefinitionsEnum : IEnumFieldWithMeta<Enums.ContractualDefinitions>
    {
        [JsonConstructor]
        public FieldWithMetaContractualDefinitionsEnum(Enums.ContractualDefinitions value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.ContractualDefinitions Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaMasterAgreementTypeEnum : IEnumFieldWithMeta<Enums.MasterAgreementType>
    {
        [JsonConstructor]
        public FieldWithMetaMasterAgreementTypeEnum(Enums.MasterAgreementType value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.MasterAgreementType Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaMasterConfirmationTypeEnum : IEnumFieldWithMeta<Enums.MasterConfirmationType>
    {
        [JsonConstructor]
        public FieldWithMetaMasterConfirmationTypeEnum(Enums.MasterConfirmationType value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.MasterConfirmationType Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaMasterConfirmationAnnexTypeEnum : IEnumFieldWithMeta<Enums.MasterConfirmationAnnexType>
    {
        [JsonConstructor]
        public FieldWithMetaMasterConfirmationAnnexTypeEnum(Enums.MasterConfirmationAnnexType value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.MasterConfirmationAnnexType Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaMarketDisruptionEnum : IEnumFieldWithMeta<Enums.MarketDisruption>
    {
        [JsonConstructor]
        public FieldWithMetaMarketDisruptionEnum(Enums.MarketDisruption value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.MarketDisruption Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaBasketConstituent : IFieldWithMeta<BasketConstituent>
    {
        [JsonConstructor]
        public FieldWithMetaBasketConstituent(BasketConstituent value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        public BasketConstituent Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaBusinessCenterEnum : IEnumFieldWithMeta<Enums.BusinessCenter>
    {
        [JsonConstructor]
        public FieldWithMetaBusinessCenterEnum(Enums.BusinessCenter value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.BusinessCenter Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaCommodityBusinessCalendarEnum : IEnumFieldWithMeta<Enums.CommodityBusinessCalendar>
    {
        [JsonConstructor]
        public FieldWithMetaCommodityBusinessCalendarEnum(Enums.CommodityBusinessCalendar value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.CommodityBusinessCalendar Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaGoverningLawEnum : IEnumFieldWithMeta<Enums.GoverningLaw>
    {
        [JsonConstructor]
        public FieldWithMetaGoverningLawEnum(Enums.GoverningLaw value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.GoverningLaw Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaMatrixTypeEnum : IEnumFieldWithMeta<Enums.MatrixType>
    {
        [JsonConstructor]
        public FieldWithMetaMatrixTypeEnum(Enums.MatrixType value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.MatrixType Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaMatrixTermEnum : IEnumFieldWithMeta<Enums.MatrixTerm>
    {
        [JsonConstructor]
        public FieldWithMetaMatrixTermEnum(Enums.MatrixTerm value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.MatrixTerm Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaContractualSupplementTypeEnum : IEnumFieldWithMeta<Enums.ContractualSupplementType>
    {
        [JsonConstructor]
        public FieldWithMetaContractualSupplementTypeEnum(Enums.ContractualSupplementType value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.ContractualSupplementType Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaIndexAnnexSourceEnum : IEnumFieldWithMeta<Enums.IndexAnnexSource>
    {
        [JsonConstructor]
        public FieldWithMetaIndexAnnexSourceEnum(Enums.IndexAnnexSource value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.IndexAnnexSource Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaCommodityReferencePriceEnum : IEnumFieldWithMeta<Enums.CommodityReferencePrice>
    {
        [JsonConstructor]
        public FieldWithMetaCommodityReferencePriceEnum(Enums.CommodityReferencePrice value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.CommodityReferencePrice Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaDayCountFractionEnum : IEnumFieldWithMeta<Enums.DayCountFraction>
    {
        [JsonConstructor]
        public FieldWithMetaDayCountFractionEnum(Enums.DayCountFraction value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.DayCountFraction Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaTimeZone : IFieldWithMeta<TimeZone>
    {
        [JsonConstructor]
        public FieldWithMetaTimeZone(TimeZone value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        public TimeZone Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaSettlementRateOptionEnum : IEnumFieldWithMeta<Enums.SettlementRateOption>
    {
        [JsonConstructor]
        public FieldWithMetaSettlementRateOptionEnum(Enums.SettlementRateOption value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.SettlementRateOption Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaFloatingRateIndexEnum : IEnumFieldWithMeta<Enums.FloatingRateIndex>
    {
        [JsonConstructor]
        public FieldWithMetaFloatingRateIndexEnum(Enums.FloatingRateIndex value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.FloatingRateIndex Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaQuotedCurrencyPair : IFieldWithMeta<QuotedCurrencyPair>
    {
        [JsonConstructor]
        public FieldWithMetaQuotedCurrencyPair(QuotedCurrencyPair value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        public QuotedCurrencyPair Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaInterestRateIndex : IFieldWithMeta<InterestRateIndex>
    {
        [JsonConstructor]
        public FieldWithMetaInterestRateIndex(InterestRateIndex value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        public InterestRateIndex Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaInflationRateIndexEnum : IEnumFieldWithMeta<Enums.InflationRateIndex>
    {
        [JsonConstructor]
        public FieldWithMetaInflationRateIndexEnum(Enums.InflationRateIndex value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.InflationRateIndex Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaInterpolationMethodEnum : IEnumFieldWithMeta<Enums.InterpolationMethod>
    {
        [JsonConstructor]
        public FieldWithMetaInterpolationMethodEnum(Enums.InterpolationMethod value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.InterpolationMethod Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaInformationProviderEnum : IEnumFieldWithMeta<Enums.InformationProvider>
    {
        [JsonConstructor]
        public FieldWithMetaInformationProviderEnum(Enums.InformationProvider value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.InformationProvider Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaCreditLimitTypeEnum : IEnumFieldWithMeta<Enums.CreditLimitType>
    {
        [JsonConstructor]
        public FieldWithMetaCreditLimitTypeEnum(Enums.CreditLimitType value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.CreditLimitType Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaLimitLevelEnum : IEnumFieldWithMeta<Enums.LimitLevel>
    {
        [JsonConstructor]
        public FieldWithMetaLimitLevelEnum(Enums.LimitLevel value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.LimitLevel Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaCreditNotation : IFieldWithMeta<CreditNotation>
    {
        [JsonConstructor]
        public FieldWithMetaCreditNotation(CreditNotation value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        public CreditNotation Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaPersonIdentifier : IFieldWithMeta<PersonIdentifier>
    {
        [JsonConstructor]
        public FieldWithMetaPersonIdentifier(PersonIdentifier value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        public PersonIdentifier Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaNaturalPersonRoleEnum : IEnumFieldWithMeta<Enums.NaturalPersonRole>
    {
        [JsonConstructor]
        public FieldWithMetaNaturalPersonRoleEnum(Enums.NaturalPersonRole value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.NaturalPersonRole Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaPriceSchedule : IFieldWithMeta<PriceSchedule>
    {
        [JsonConstructor]
        public FieldWithMetaPriceSchedule(PriceSchedule value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        public PriceSchedule Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaNonNegativeQuantitySchedule : IFieldWithMeta<NonNegativeQuantitySchedule>
    {
        [JsonConstructor]
        public FieldWithMetaNonNegativeQuantitySchedule(NonNegativeQuantitySchedule value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        public NonNegativeQuantitySchedule Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaObservable : IFieldWithMeta<Observable>
    {
        [JsonConstructor]
        public FieldWithMetaObservable(Observable value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        public Observable Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaAssetClassEnum : IEnumFieldWithMeta<Enums.AssetClass>
    {
        [JsonConstructor]
        public FieldWithMetaAssetClassEnum(Enums.AssetClass value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.AssetClass Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaEntityTypeEnum : IEnumFieldWithMeta<Enums.EntityType>
    {
        [JsonConstructor]
        public FieldWithMetaEntityTypeEnum(Enums.EntityType value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.EntityType Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaResourceTypeEnum : IEnumFieldWithMeta<Enums.ResourceType>
    {
        [JsonConstructor]
        public FieldWithMetaResourceTypeEnum(Enums.ResourceType value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.ResourceType Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaRestructuringEnum : IEnumFieldWithMeta<Enums.Restructuring>
    {
        [JsonConstructor]
        public FieldWithMetaRestructuringEnum(Enums.Restructuring value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.Restructuring Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaSettledEntityMatrixSourceEnum : IEnumFieldWithMeta<Enums.SettledEntityMatrixSource>
    {
        [JsonConstructor]
        public FieldWithMetaSettledEntityMatrixSourceEnum(Enums.SettledEntityMatrixSource value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.SettledEntityMatrixSource Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaSpreadScheduleTypeEnum : IEnumFieldWithMeta<Enums.SpreadScheduleType>
    {
        [JsonConstructor]
        public FieldWithMetaSpreadScheduleTypeEnum(Enums.SpreadScheduleType value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        [JsonConverter(typeof(StringEnumConverter))]
        public Enums.SpreadScheduleType Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class FieldWithMetaIdentifier : IFieldWithMeta<Identifier>
    {
        [JsonConstructor]
        public FieldWithMetaIdentifier(Identifier value, MetaFields? meta)
        {
            Value = value;
            Meta = meta;
        }
        
        public Identifier Value { get; }
        
        public MetaFields? Meta { get; }
    }
    
    public class MetaFields
    {
        [JsonConstructor]
        public MetaFields(string? scheme, string? globalKey, string? externalKey, IEnumerable<Key> location)
        {
            Scheme = scheme;
            GlobalKey = globalKey;
            ExternalKey = externalKey;
            Location = location;
        }
        
        public string? Scheme { get; }
        
        public string? GlobalKey { get; }
        
        public string? ExternalKey { get; }
        
        public IEnumerable<Key> Location { get; }
    }
    
    public class MetaAndTemplateFields
    {
        [JsonConstructor]
        public MetaAndTemplateFields(string? scheme, string? globalKey, string? externalKey, string? templateGlobalReference, IEnumerable<Key> location)
        {
            Scheme = scheme;
            GlobalKey = globalKey;
            ExternalKey = externalKey;
            TemplateGlobalReference = templateGlobalReference;
            Location = location;
        }
        
        public string? Scheme { get; }
        
        public string? GlobalKey { get; }
        
        public string? ExternalKey { get; }
        
        public string? TemplateGlobalReference { get; }
        
        public IEnumerable<Key> Location { get; }
    }
    
}