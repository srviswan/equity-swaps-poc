// This file is auto-generated from the ISDA Common Domain Model, do not edit.
//
// Version: 6.0.0
//
namespace Org.Isda.Cdm.Meta
{
    using System.Collections.Generic;

    using Rosetta.Lib;
    using Rosetta.Lib.Attributes;
    using Rosetta.Lib.Meta;
    using Rosetta.Lib.Validation;
    
    using Org.Isda.Cdm.Validation.DataRule;
    
    /// <summary>
    /// MetaData definition for Account
    /// </summary>
    [RosettaMeta(typeof(Account))]
    public class AccountMeta : IRosettaMetaData<Account>
    {
        public IEnumerable<IValidator<Account>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Account>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Account, ISet<string>> OnlyExistsValidator => new AccountOnlyExistsValidator();

        public IValidator<Account> Validator => new AccountValidator();
    }
    
    /// <summary>
    /// MetaData definition for AcctOwnr
    /// </summary>
    [RosettaMeta(typeof(AcctOwnr))]
    public class AcctOwnrMeta : IRosettaMetaData<AcctOwnr>
    {
        public IEnumerable<IValidator<AcctOwnr>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AcctOwnr>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AcctOwnr, ISet<string>> OnlyExistsValidator => new AcctOwnrOnlyExistsValidator();

        public IValidator<AcctOwnr> Validator => new AcctOwnrValidator();
    }
    
    /// <summary>
    /// MetaData definition for AdditionalDisruptionEvents
    /// </summary>
    [RosettaMeta(typeof(AdditionalDisruptionEvents))]
    public class AdditionalDisruptionEventsMeta : IRosettaMetaData<AdditionalDisruptionEvents>
    {
        public IEnumerable<IValidator<AdditionalDisruptionEvents>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AdditionalDisruptionEvents>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AdditionalDisruptionEvents, ISet<string>> OnlyExistsValidator => new AdditionalDisruptionEventsOnlyExistsValidator();

        public IValidator<AdditionalDisruptionEvents> Validator => new AdditionalDisruptionEventsValidator();
    }
    
    /// <summary>
    /// MetaData definition for AdditionalFixedPayments
    /// </summary>
    [RosettaMeta(typeof(AdditionalFixedPayments))]
    public class AdditionalFixedPaymentsMeta : IRosettaMetaData<AdditionalFixedPayments>
    {
        public IEnumerable<IValidator<AdditionalFixedPayments>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AdditionalFixedPayments>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AdditionalFixedPayments, ISet<string>> OnlyExistsValidator => new AdditionalFixedPaymentsOnlyExistsValidator();

        public IValidator<AdditionalFixedPayments> Validator => new AdditionalFixedPaymentsValidator();
    }
    
    /// <summary>
    /// MetaData definition for Address
    /// </summary>
    [RosettaMeta(typeof(Address))]
    public class AddressMeta : IRosettaMetaData<Address>
    {
        public IEnumerable<IValidator<Address>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Address>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Address, ISet<string>> OnlyExistsValidator => new AddressOnlyExistsValidator();

        public IValidator<Address> Validator => new AddressValidator();
    }
    
    /// <summary>
    /// MetaData definition for AddressForNotices
    /// </summary>
    [RosettaMeta(typeof(AddressForNotices))]
    public class AddressForNoticesMeta : IRosettaMetaData<AddressForNotices>
    {
        public IEnumerable<IValidator<AddressForNotices>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AddressForNotices>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AddressForNotices, ISet<string>> OnlyExistsValidator => new AddressForNoticesOnlyExistsValidator();

        public IValidator<AddressForNotices> Validator => new AddressForNoticesValidator();
    }
    
    /// <summary>
    /// MetaData definition for AddtlAttrbts
    /// </summary>
    [RosettaMeta(typeof(AddtlAttrbts))]
    public class AddtlAttrbtsMeta : IRosettaMetaData<AddtlAttrbts>
    {
        public IEnumerable<IValidator<AddtlAttrbts>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AddtlAttrbts>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AddtlAttrbts, ISet<string>> OnlyExistsValidator => new AddtlAttrbtsOnlyExistsValidator();

        public IValidator<AddtlAttrbts> Validator => new AddtlAttrbtsValidator();
    }
    
    /// <summary>
    /// MetaData definition for AdjustableDate
    /// </summary>
    [RosettaMeta(typeof(AdjustableDate))]
    public class AdjustableDateMeta : IRosettaMetaData<AdjustableDate>
    {
        public IEnumerable<IValidator<AdjustableDate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AdjustableDate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AdjustableDate, ISet<string>> OnlyExistsValidator => new AdjustableDateOnlyExistsValidator();

        public IValidator<AdjustableDate> Validator => new AdjustableDateValidator();
    }
    
    /// <summary>
    /// MetaData definition for AdjustableDates
    /// </summary>
    [RosettaMeta(typeof(AdjustableDates))]
    public class AdjustableDatesMeta : IRosettaMetaData<AdjustableDates>
    {
        public IEnumerable<IValidator<AdjustableDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AdjustableDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AdjustableDates, ISet<string>> OnlyExistsValidator => new AdjustableDatesOnlyExistsValidator();

        public IValidator<AdjustableDates> Validator => new AdjustableDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for AdjustableOrAdjustedDate
    /// </summary>
    [RosettaMeta(typeof(AdjustableOrAdjustedDate))]
    public class AdjustableOrAdjustedDateMeta : IRosettaMetaData<AdjustableOrAdjustedDate>
    {
        public IEnumerable<IValidator<AdjustableOrAdjustedDate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AdjustableOrAdjustedDate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AdjustableOrAdjustedDate, ISet<string>> OnlyExistsValidator => new AdjustableOrAdjustedDateOnlyExistsValidator();

        public IValidator<AdjustableOrAdjustedDate> Validator => new AdjustableOrAdjustedDateValidator();
    }
    
    /// <summary>
    /// MetaData definition for AdjustableOrAdjustedOrRelativeDate
    /// </summary>
    [RosettaMeta(typeof(AdjustableOrAdjustedOrRelativeDate))]
    public class AdjustableOrAdjustedOrRelativeDateMeta : IRosettaMetaData<AdjustableOrAdjustedOrRelativeDate>
    {
        public IEnumerable<IValidator<AdjustableOrAdjustedOrRelativeDate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AdjustableOrAdjustedOrRelativeDate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AdjustableOrAdjustedOrRelativeDate, ISet<string>> OnlyExistsValidator => new AdjustableOrAdjustedOrRelativeDateOnlyExistsValidator();

        public IValidator<AdjustableOrAdjustedOrRelativeDate> Validator => new AdjustableOrAdjustedOrRelativeDateValidator();
    }
    
    /// <summary>
    /// MetaData definition for AdjustableOrRelativeDate
    /// </summary>
    [RosettaMeta(typeof(AdjustableOrRelativeDate))]
    public class AdjustableOrRelativeDateMeta : IRosettaMetaData<AdjustableOrRelativeDate>
    {
        public IEnumerable<IValidator<AdjustableOrRelativeDate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AdjustableOrRelativeDate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AdjustableOrRelativeDate, ISet<string>> OnlyExistsValidator => new AdjustableOrRelativeDateOnlyExistsValidator();

        public IValidator<AdjustableOrRelativeDate> Validator => new AdjustableOrRelativeDateValidator();
    }
    
    /// <summary>
    /// MetaData definition for AdjustableOrRelativeDates
    /// </summary>
    [RosettaMeta(typeof(AdjustableOrRelativeDates))]
    public class AdjustableOrRelativeDatesMeta : IRosettaMetaData<AdjustableOrRelativeDates>
    {
        public IEnumerable<IValidator<AdjustableOrRelativeDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AdjustableOrRelativeDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AdjustableOrRelativeDates, ISet<string>> OnlyExistsValidator => new AdjustableOrRelativeDatesOnlyExistsValidator();

        public IValidator<AdjustableOrRelativeDates> Validator => new AdjustableOrRelativeDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for AdjustableRelativeOrPeriodicDates
    /// </summary>
    [RosettaMeta(typeof(AdjustableRelativeOrPeriodicDates))]
    public class AdjustableRelativeOrPeriodicDatesMeta : IRosettaMetaData<AdjustableRelativeOrPeriodicDates>
    {
        public IEnumerable<IValidator<AdjustableRelativeOrPeriodicDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AdjustableRelativeOrPeriodicDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AdjustableRelativeOrPeriodicDates, ISet<string>> OnlyExistsValidator => new AdjustableRelativeOrPeriodicDatesOnlyExistsValidator();

        public IValidator<AdjustableRelativeOrPeriodicDates> Validator => new AdjustableRelativeOrPeriodicDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for AdjustedRelativeDateOffset
    /// </summary>
    [RosettaMeta(typeof(AdjustedRelativeDateOffset))]
    public class AdjustedRelativeDateOffsetMeta : IRosettaMetaData<AdjustedRelativeDateOffset>
    {
        public IEnumerable<IValidator<AdjustedRelativeDateOffset>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AdjustedRelativeDateOffset>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AdjustedRelativeDateOffset, ISet<string>> OnlyExistsValidator => new AdjustedRelativeDateOffsetOnlyExistsValidator();

        public IValidator<AdjustedRelativeDateOffset> Validator => new AdjustedRelativeDateOffsetValidator();
    }
    
    /// <summary>
    /// MetaData definition for AgencyRatingCriteria
    /// </summary>
    [RosettaMeta(typeof(AgencyRatingCriteria))]
    public class AgencyRatingCriteriaMeta : IRosettaMetaData<AgencyRatingCriteria>
    {
        public IEnumerable<IValidator<AgencyRatingCriteria>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AgencyRatingCriteria>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AgencyRatingCriteria, ISet<string>> OnlyExistsValidator => new AgencyRatingCriteriaOnlyExistsValidator();

        public IValidator<AgencyRatingCriteria> Validator => new AgencyRatingCriteriaValidator();
    }
    
    /// <summary>
    /// MetaData definition for AggregationParameters
    /// </summary>
    [RosettaMeta(typeof(AggregationParameters))]
    public class AggregationParametersMeta : IRosettaMetaData<AggregationParameters>
    {
        public IEnumerable<IValidator<AggregationParameters>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AggregationParameters>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AggregationParameters, ISet<string>> OnlyExistsValidator => new AggregationParametersOnlyExistsValidator();

        public IValidator<AggregationParameters> Validator => new AggregationParametersValidator();
    }
    
    /// <summary>
    /// MetaData definition for Agreement
    /// </summary>
    [RosettaMeta(typeof(Agreement))]
    public class AgreementMeta : IRosettaMetaData<Agreement>
    {
        public IEnumerable<IValidator<Agreement>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Agreement>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Agreement, ISet<string>> OnlyExistsValidator => new AgreementOnlyExistsValidator();

        public IValidator<Agreement> Validator => new AgreementValidator();
    }
    
    /// <summary>
    /// MetaData definition for AgreementName
    /// </summary>
    [RosettaMeta(typeof(AgreementName))]
    public class AgreementNameMeta : IRosettaMetaData<AgreementName>
    {
        public IEnumerable<IValidator<AgreementName>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AgreementName>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AgreementName, ISet<string>> OnlyExistsValidator => new AgreementNameOnlyExistsValidator();

        public IValidator<AgreementName> Validator => new AgreementNameValidator();
    }
    
    /// <summary>
    /// MetaData definition for AgreementTerms
    /// </summary>
    [RosettaMeta(typeof(AgreementTerms))]
    public class AgreementTermsMeta : IRosettaMetaData<AgreementTerms>
    {
        public IEnumerable<IValidator<AgreementTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AgreementTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AgreementTerms, ISet<string>> OnlyExistsValidator => new AgreementTermsOnlyExistsValidator();

        public IValidator<AgreementTerms> Validator => new AgreementTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for AllCriteria
    /// </summary>
    [RosettaMeta(typeof(AllCriteria))]
    public class AllCriteriaMeta : IRosettaMetaData<AllCriteria>
    {
        public IEnumerable<IValidator<AllCriteria>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AllCriteria>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AllCriteria, ISet<string>> OnlyExistsValidator => new AllCriteriaOnlyExistsValidator();

        public IValidator<AllCriteria> Validator => new AllCriteriaValidator();
    }
    
    /// <summary>
    /// MetaData definition for AmountSchedule
    /// </summary>
    [RosettaMeta(typeof(AmountSchedule))]
    public class AmountScheduleMeta : IRosettaMetaData<AmountSchedule>
    {
        public IEnumerable<IValidator<AmountSchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AmountSchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AmountSchedule, ISet<string>> OnlyExistsValidator => new AmountScheduleOnlyExistsValidator();

        public IValidator<AmountSchedule> Validator => new AmountScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for AncillaryEntity
    /// </summary>
    [RosettaMeta(typeof(AncillaryEntity))]
    public class AncillaryEntityMeta : IRosettaMetaData<AncillaryEntity>
    {
        public IEnumerable<IValidator<AncillaryEntity>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AncillaryEntity>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AncillaryEntity, ISet<string>> OnlyExistsValidator => new AncillaryEntityOnlyExistsValidator();

        public IValidator<AncillaryEntity> Validator => new AncillaryEntityValidator();
    }
    
    /// <summary>
    /// MetaData definition for AncillaryParty
    /// </summary>
    [RosettaMeta(typeof(AncillaryParty))]
    public class AncillaryPartyMeta : IRosettaMetaData<AncillaryParty>
    {
        public IEnumerable<IValidator<AncillaryParty>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AncillaryParty>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AncillaryParty, ISet<string>> OnlyExistsValidator => new AncillaryPartyOnlyExistsValidator();

        public IValidator<AncillaryParty> Validator => new AncillaryPartyValidator();
    }
    
    /// <summary>
    /// MetaData definition for AnyCriteria
    /// </summary>
    [RosettaMeta(typeof(AnyCriteria))]
    public class AnyCriteriaMeta : IRosettaMetaData<AnyCriteria>
    {
        public IEnumerable<IValidator<AnyCriteria>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AnyCriteria>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AnyCriteria, ISet<string>> OnlyExistsValidator => new AnyCriteriaOnlyExistsValidator();

        public IValidator<AnyCriteria> Validator => new AnyCriteriaValidator();
    }
    
    /// <summary>
    /// MetaData definition for Asian
    /// </summary>
    [RosettaMeta(typeof(Asian))]
    public class AsianMeta : IRosettaMetaData<Asian>
    {
        public IEnumerable<IValidator<Asian>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Asian>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Asian, ISet<string>> OnlyExistsValidator => new AsianOnlyExistsValidator();

        public IValidator<Asian> Validator => new AsianValidator();
    }
    
    /// <summary>
    /// MetaData definition for Asset
    /// </summary>
    [RosettaMeta(typeof(Asset))]
    public class AssetMeta : IRosettaMetaData<Asset>
    {
        public IEnumerable<IValidator<Asset>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Asset>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Asset, ISet<string>> OnlyExistsValidator => new AssetOnlyExistsValidator();

        public IValidator<Asset> Validator => new AssetValidator();
    }
    
    /// <summary>
    /// MetaData definition for AssetAgencyRating
    /// </summary>
    [RosettaMeta(typeof(AssetAgencyRating))]
    public class AssetAgencyRatingMeta : IRosettaMetaData<AssetAgencyRating>
    {
        public IEnumerable<IValidator<AssetAgencyRating>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AssetAgencyRating>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AssetAgencyRating, ISet<string>> OnlyExistsValidator => new AssetAgencyRatingOnlyExistsValidator();

        public IValidator<AssetAgencyRating> Validator => new AssetAgencyRatingValidator();
    }
    
    /// <summary>
    /// MetaData definition for AssetBase
    /// </summary>
    [RosettaMeta(typeof(AssetBase))]
    public class AssetBaseMeta : IRosettaMetaData<AssetBase>
    {
        public IEnumerable<IValidator<AssetBase>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AssetBase>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AssetBase, ISet<string>> OnlyExistsValidator => new AssetBaseOnlyExistsValidator();

        public IValidator<AssetBase> Validator => new AssetBaseValidator();
    }
    
    /// <summary>
    /// MetaData definition for AssetCountryOfOrigin
    /// </summary>
    [RosettaMeta(typeof(AssetCountryOfOrigin))]
    public class AssetCountryOfOriginMeta : IRosettaMetaData<AssetCountryOfOrigin>
    {
        public IEnumerable<IValidator<AssetCountryOfOrigin>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AssetCountryOfOrigin>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AssetCountryOfOrigin, ISet<string>> OnlyExistsValidator => new AssetCountryOfOriginOnlyExistsValidator();

        public IValidator<AssetCountryOfOrigin> Validator => new AssetCountryOfOriginValidator();
    }
    
    /// <summary>
    /// MetaData definition for AssetDeliveryInformation
    /// </summary>
    [RosettaMeta(typeof(AssetDeliveryInformation))]
    public class AssetDeliveryInformationMeta : IRosettaMetaData<AssetDeliveryInformation>
    {
        public IEnumerable<IValidator<AssetDeliveryInformation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AssetDeliveryInformation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AssetDeliveryInformation, ISet<string>> OnlyExistsValidator => new AssetDeliveryInformationOnlyExistsValidator();

        public IValidator<AssetDeliveryInformation> Validator => new AssetDeliveryInformationValidator();
    }
    
    /// <summary>
    /// MetaData definition for AssetDeliveryPeriods
    /// </summary>
    [RosettaMeta(typeof(AssetDeliveryPeriods))]
    public class AssetDeliveryPeriodsMeta : IRosettaMetaData<AssetDeliveryPeriods>
    {
        public IEnumerable<IValidator<AssetDeliveryPeriods>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AssetDeliveryPeriods>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AssetDeliveryPeriods, ISet<string>> OnlyExistsValidator => new AssetDeliveryPeriodsOnlyExistsValidator();

        public IValidator<AssetDeliveryPeriods> Validator => new AssetDeliveryPeriodsValidator();
    }
    
    /// <summary>
    /// MetaData definition for AssetDeliveryProfile
    /// </summary>
    [RosettaMeta(typeof(AssetDeliveryProfile))]
    public class AssetDeliveryProfileMeta : IRosettaMetaData<AssetDeliveryProfile>
    {
        public IEnumerable<IValidator<AssetDeliveryProfile>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AssetDeliveryProfile>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AssetDeliveryProfile, ISet<string>> OnlyExistsValidator => new AssetDeliveryProfileOnlyExistsValidator();

        public IValidator<AssetDeliveryProfile> Validator => new AssetDeliveryProfileValidator();
    }
    
    /// <summary>
    /// MetaData definition for AssetDeliveryProfileBlock
    /// </summary>
    [RosettaMeta(typeof(AssetDeliveryProfileBlock))]
    public class AssetDeliveryProfileBlockMeta : IRosettaMetaData<AssetDeliveryProfileBlock>
    {
        public IEnumerable<IValidator<AssetDeliveryProfileBlock>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AssetDeliveryProfileBlock>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AssetDeliveryProfileBlock, ISet<string>> OnlyExistsValidator => new AssetDeliveryProfileBlockOnlyExistsValidator();

        public IValidator<AssetDeliveryProfileBlock> Validator => new AssetDeliveryProfileBlockValidator();
    }
    
    /// <summary>
    /// MetaData definition for AssetFlowBase
    /// </summary>
    [RosettaMeta(typeof(AssetFlowBase))]
    public class AssetFlowBaseMeta : IRosettaMetaData<AssetFlowBase>
    {
        public IEnumerable<IValidator<AssetFlowBase>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AssetFlowBase>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AssetFlowBase, ISet<string>> OnlyExistsValidator => new AssetFlowBaseOnlyExistsValidator();

        public IValidator<AssetFlowBase> Validator => new AssetFlowBaseValidator();
    }
    
    /// <summary>
    /// MetaData definition for AssetIdentifier
    /// </summary>
    [RosettaMeta(typeof(AssetIdentifier))]
    public class AssetIdentifierMeta : IRosettaMetaData<AssetIdentifier>
    {
        public IEnumerable<IValidator<AssetIdentifier>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AssetIdentifier>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AssetIdentifier, ISet<string>> OnlyExistsValidator => new AssetIdentifierOnlyExistsValidator();

        public IValidator<AssetIdentifier> Validator => new AssetIdentifierValidator();
    }
    
    /// <summary>
    /// MetaData definition for AssetLeg
    /// </summary>
    [RosettaMeta(typeof(AssetLeg))]
    public class AssetLegMeta : IRosettaMetaData<AssetLeg>
    {
        public IEnumerable<IValidator<AssetLeg>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AssetLeg>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AssetLeg, ISet<string>> OnlyExistsValidator => new AssetLegOnlyExistsValidator();

        public IValidator<AssetLeg> Validator => new AssetLegValidator();
    }
    
    /// <summary>
    /// MetaData definition for AssetMaturity
    /// </summary>
    [RosettaMeta(typeof(AssetMaturity))]
    public class AssetMaturityMeta : IRosettaMetaData<AssetMaturity>
    {
        public IEnumerable<IValidator<AssetMaturity>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AssetMaturity>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AssetMaturity, ISet<string>> OnlyExistsValidator => new AssetMaturityOnlyExistsValidator();

        public IValidator<AssetMaturity> Validator => new AssetMaturityValidator();
    }
    
    /// <summary>
    /// MetaData definition for AssetPayout
    /// </summary>
    [RosettaMeta(typeof(AssetPayout))]
    public class AssetPayoutMeta : IRosettaMetaData<AssetPayout>
    {
        public IEnumerable<IValidator<AssetPayout>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AssetPayout>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AssetPayout, ISet<string>> OnlyExistsValidator => new AssetPayoutOnlyExistsValidator();

        public IValidator<AssetPayout> Validator => new AssetPayoutValidator();
    }
    
    /// <summary>
    /// MetaData definition for AssetType
    /// </summary>
    [RosettaMeta(typeof(AssetType))]
    public class AssetTypeMeta : IRosettaMetaData<AssetType>
    {
        public IEnumerable<IValidator<AssetType>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AssetType>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AssetType, ISet<string>> OnlyExistsValidator => new AssetTypeOnlyExistsValidator();

        public IValidator<AssetType> Validator => new AssetTypeValidator();
    }
    
    /// <summary>
    /// MetaData definition for AssignedIdentifier
    /// </summary>
    [RosettaMeta(typeof(AssignedIdentifier))]
    public class AssignedIdentifierMeta : IRosettaMetaData<AssignedIdentifier>
    {
        public IEnumerable<IValidator<AssignedIdentifier>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AssignedIdentifier>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AssignedIdentifier, ISet<string>> OnlyExistsValidator => new AssignedIdentifierOnlyExistsValidator();

        public IValidator<AssignedIdentifier> Validator => new AssignedIdentifierValidator();
    }
    
    /// <summary>
    /// MetaData definition for AutomaticExercise
    /// </summary>
    [RosettaMeta(typeof(AutomaticExercise))]
    public class AutomaticExerciseMeta : IRosettaMetaData<AutomaticExercise>
    {
        public IEnumerable<IValidator<AutomaticExercise>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AutomaticExercise>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AutomaticExercise, ISet<string>> OnlyExistsValidator => new AutomaticExerciseOnlyExistsValidator();

        public IValidator<AutomaticExercise> Validator => new AutomaticExerciseValidator();
    }
    
    /// <summary>
    /// MetaData definition for AvailableInventory
    /// </summary>
    [RosettaMeta(typeof(AvailableInventory))]
    public class AvailableInventoryMeta : IRosettaMetaData<AvailableInventory>
    {
        public IEnumerable<IValidator<AvailableInventory>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AvailableInventory>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AvailableInventory, ISet<string>> OnlyExistsValidator => new AvailableInventoryOnlyExistsValidator();

        public IValidator<AvailableInventory> Validator => new AvailableInventoryValidator();
    }
    
    /// <summary>
    /// MetaData definition for AvailableInventoryRecord
    /// </summary>
    [RosettaMeta(typeof(AvailableInventoryRecord))]
    public class AvailableInventoryRecordMeta : IRosettaMetaData<AvailableInventoryRecord>
    {
        public IEnumerable<IValidator<AvailableInventoryRecord>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AvailableInventoryRecord>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AvailableInventoryRecord, ISet<string>> OnlyExistsValidator => new AvailableInventoryRecordOnlyExistsValidator();

        public IValidator<AvailableInventoryRecord> Validator => new AvailableInventoryRecordValidator();
    }
    
    /// <summary>
    /// MetaData definition for AverageTradingVolume
    /// </summary>
    [RosettaMeta(typeof(AverageTradingVolume))]
    public class AverageTradingVolumeMeta : IRosettaMetaData<AverageTradingVolume>
    {
        public IEnumerable<IValidator<AverageTradingVolume>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AverageTradingVolume>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AverageTradingVolume, ISet<string>> OnlyExistsValidator => new AverageTradingVolumeOnlyExistsValidator();

        public IValidator<AverageTradingVolume> Validator => new AverageTradingVolumeValidator();
    }
    
    /// <summary>
    /// MetaData definition for AveragingCalculation
    /// </summary>
    [RosettaMeta(typeof(AveragingCalculation))]
    public class AveragingCalculationMeta : IRosettaMetaData<AveragingCalculation>
    {
        public IEnumerable<IValidator<AveragingCalculation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AveragingCalculation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AveragingCalculation, ISet<string>> OnlyExistsValidator => new AveragingCalculationOnlyExistsValidator();

        public IValidator<AveragingCalculation> Validator => new AveragingCalculationValidator();
    }
    
    /// <summary>
    /// MetaData definition for AveragingCalculationMethod
    /// </summary>
    [RosettaMeta(typeof(AveragingCalculationMethod))]
    public class AveragingCalculationMethodMeta : IRosettaMetaData<AveragingCalculationMethod>
    {
        public IEnumerable<IValidator<AveragingCalculationMethod>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AveragingCalculationMethod>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AveragingCalculationMethod, ISet<string>> OnlyExistsValidator => new AveragingCalculationMethodOnlyExistsValidator();

        public IValidator<AveragingCalculationMethod> Validator => new AveragingCalculationMethodValidator();
    }
    
    /// <summary>
    /// MetaData definition for AveragingObservationList
    /// </summary>
    [RosettaMeta(typeof(AveragingObservationList))]
    public class AveragingObservationListMeta : IRosettaMetaData<AveragingObservationList>
    {
        public IEnumerable<IValidator<AveragingObservationList>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AveragingObservationList>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AveragingObservationList, ISet<string>> OnlyExistsValidator => new AveragingObservationListOnlyExistsValidator();

        public IValidator<AveragingObservationList> Validator => new AveragingObservationListValidator();
    }
    
    /// <summary>
    /// MetaData definition for AveragingPeriod
    /// </summary>
    [RosettaMeta(typeof(AveragingPeriod))]
    public class AveragingPeriodMeta : IRosettaMetaData<AveragingPeriod>
    {
        public IEnumerable<IValidator<AveragingPeriod>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AveragingPeriod>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AveragingPeriod, ISet<string>> OnlyExistsValidator => new AveragingPeriodOnlyExistsValidator();

        public IValidator<AveragingPeriod> Validator => new AveragingPeriodValidator();
    }
    
    /// <summary>
    /// MetaData definition for AveragingSchedule
    /// </summary>
    [RosettaMeta(typeof(AveragingSchedule))]
    public class AveragingScheduleMeta : IRosettaMetaData<AveragingSchedule>
    {
        public IEnumerable<IValidator<AveragingSchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AveragingSchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AveragingSchedule, ISet<string>> OnlyExistsValidator => new AveragingScheduleOnlyExistsValidator();

        public IValidator<AveragingSchedule> Validator => new AveragingScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for AveragingStrikeFeature
    /// </summary>
    [RosettaMeta(typeof(AveragingStrikeFeature))]
    public class AveragingStrikeFeatureMeta : IRosettaMetaData<AveragingStrikeFeature>
    {
        public IEnumerable<IValidator<AveragingStrikeFeature>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<AveragingStrikeFeature>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<AveragingStrikeFeature, ISet<string>> OnlyExistsValidator => new AveragingStrikeFeatureOnlyExistsValidator();

        public IValidator<AveragingStrikeFeature> Validator => new AveragingStrikeFeatureValidator();
    }
    
    /// <summary>
    /// MetaData definition for Barrier
    /// </summary>
    [RosettaMeta(typeof(Barrier))]
    public class BarrierMeta : IRosettaMetaData<Barrier>
    {
        public IEnumerable<IValidator<Barrier>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Barrier>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Barrier, ISet<string>> OnlyExistsValidator => new BarrierOnlyExistsValidator();

        public IValidator<Barrier> Validator => new BarrierValidator();
    }
    
    /// <summary>
    /// MetaData definition for Basket
    /// </summary>
    [RosettaMeta(typeof(Basket))]
    public class BasketMeta : IRosettaMetaData<Basket>
    {
        public IEnumerable<IValidator<Basket>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Basket>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Basket, ISet<string>> OnlyExistsValidator => new BasketOnlyExistsValidator();

        public IValidator<Basket> Validator => new BasketValidator();
    }
    
    /// <summary>
    /// MetaData definition for BasketConstituent
    /// </summary>
    [RosettaMeta(typeof(BasketConstituent))]
    public class BasketConstituentMeta : IRosettaMetaData<BasketConstituent>
    {
        public IEnumerable<IValidator<BasketConstituent>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BasketConstituent>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BasketConstituent, ISet<string>> OnlyExistsValidator => new BasketConstituentOnlyExistsValidator();

        public IValidator<BasketConstituent> Validator => new BasketConstituentValidator();
    }
    
    /// <summary>
    /// MetaData definition for BasketReferenceInformation
    /// </summary>
    [RosettaMeta(typeof(BasketReferenceInformation))]
    public class BasketReferenceInformationMeta : IRosettaMetaData<BasketReferenceInformation>
    {
        public IEnumerable<IValidator<BasketReferenceInformation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BasketReferenceInformation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BasketReferenceInformation, ISet<string>> OnlyExistsValidator => new BasketReferenceInformationOnlyExistsValidator();

        public IValidator<BasketReferenceInformation> Validator => new BasketReferenceInformationValidator();
    }
    
    /// <summary>
    /// MetaData definition for BillingInstruction
    /// </summary>
    [RosettaMeta(typeof(BillingInstruction))]
    public class BillingInstructionMeta : IRosettaMetaData<BillingInstruction>
    {
        public IEnumerable<IValidator<BillingInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BillingInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BillingInstruction, ISet<string>> OnlyExistsValidator => new BillingInstructionOnlyExistsValidator();

        public IValidator<BillingInstruction> Validator => new BillingInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for BillingRecord
    /// </summary>
    [RosettaMeta(typeof(BillingRecord))]
    public class BillingRecordMeta : IRosettaMetaData<BillingRecord>
    {
        public IEnumerable<IValidator<BillingRecord>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BillingRecord>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BillingRecord, ISet<string>> OnlyExistsValidator => new BillingRecordOnlyExistsValidator();

        public IValidator<BillingRecord> Validator => new BillingRecordValidator();
    }
    
    /// <summary>
    /// MetaData definition for BillingRecordInstruction
    /// </summary>
    [RosettaMeta(typeof(BillingRecordInstruction))]
    public class BillingRecordInstructionMeta : IRosettaMetaData<BillingRecordInstruction>
    {
        public IEnumerable<IValidator<BillingRecordInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BillingRecordInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BillingRecordInstruction, ISet<string>> OnlyExistsValidator => new BillingRecordInstructionOnlyExistsValidator();

        public IValidator<BillingRecordInstruction> Validator => new BillingRecordInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for BillingSummary
    /// </summary>
    [RosettaMeta(typeof(BillingSummary))]
    public class BillingSummaryMeta : IRosettaMetaData<BillingSummary>
    {
        public IEnumerable<IValidator<BillingSummary>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BillingSummary>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BillingSummary, ISet<string>> OnlyExistsValidator => new BillingSummaryOnlyExistsValidator();

        public IValidator<BillingSummary> Validator => new BillingSummaryValidator();
    }
    
    /// <summary>
    /// MetaData definition for BillingSummaryInstruction
    /// </summary>
    [RosettaMeta(typeof(BillingSummaryInstruction))]
    public class BillingSummaryInstructionMeta : IRosettaMetaData<BillingSummaryInstruction>
    {
        public IEnumerable<IValidator<BillingSummaryInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BillingSummaryInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BillingSummaryInstruction, ISet<string>> OnlyExistsValidator => new BillingSummaryInstructionOnlyExistsValidator();

        public IValidator<BillingSummaryInstruction> Validator => new BillingSummaryInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for BondReference
    /// </summary>
    [RosettaMeta(typeof(BondReference))]
    public class BondReferenceMeta : IRosettaMetaData<BondReference>
    {
        public IEnumerable<IValidator<BondReference>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BondReference>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BondReference, ISet<string>> OnlyExistsValidator => new BondReferenceOnlyExistsValidator();

        public IValidator<BondReference> Validator => new BondReferenceValidator();
    }
    
    /// <summary>
    /// MetaData definition for BoundedCorrelation
    /// </summary>
    [RosettaMeta(typeof(BoundedCorrelation))]
    public class BoundedCorrelationMeta : IRosettaMetaData<BoundedCorrelation>
    {
        public IEnumerable<IValidator<BoundedCorrelation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BoundedCorrelation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BoundedCorrelation, ISet<string>> OnlyExistsValidator => new BoundedCorrelationOnlyExistsValidator();

        public IValidator<BoundedCorrelation> Validator => new BoundedCorrelationValidator();
    }
    
    /// <summary>
    /// MetaData definition for BoundedVariance
    /// </summary>
    [RosettaMeta(typeof(BoundedVariance))]
    public class BoundedVarianceMeta : IRosettaMetaData<BoundedVariance>
    {
        public IEnumerable<IValidator<BoundedVariance>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BoundedVariance>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BoundedVariance, ISet<string>> OnlyExistsValidator => new BoundedVarianceOnlyExistsValidator();

        public IValidator<BoundedVariance> Validator => new BoundedVarianceValidator();
    }
    
    /// <summary>
    /// MetaData definition for BusinessCenterTime
    /// </summary>
    [RosettaMeta(typeof(BusinessCenterTime))]
    public class BusinessCenterTimeMeta : IRosettaMetaData<BusinessCenterTime>
    {
        public IEnumerable<IValidator<BusinessCenterTime>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BusinessCenterTime>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BusinessCenterTime, ISet<string>> OnlyExistsValidator => new BusinessCenterTimeOnlyExistsValidator();

        public IValidator<BusinessCenterTime> Validator => new BusinessCenterTimeValidator();
    }
    
    /// <summary>
    /// MetaData definition for BusinessCenters
    /// </summary>
    [RosettaMeta(typeof(BusinessCenters))]
    public class BusinessCentersMeta : IRosettaMetaData<BusinessCenters>
    {
        public IEnumerable<IValidator<BusinessCenters>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BusinessCenters>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BusinessCenters, ISet<string>> OnlyExistsValidator => new BusinessCentersOnlyExistsValidator();

        public IValidator<BusinessCenters> Validator => new BusinessCentersValidator();
    }
    
    /// <summary>
    /// MetaData definition for BusinessDateRange
    /// </summary>
    [RosettaMeta(typeof(BusinessDateRange))]
    public class BusinessDateRangeMeta : IRosettaMetaData<BusinessDateRange>
    {
        public IEnumerable<IValidator<BusinessDateRange>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BusinessDateRange>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BusinessDateRange, ISet<string>> OnlyExistsValidator => new BusinessDateRangeOnlyExistsValidator();

        public IValidator<BusinessDateRange> Validator => new BusinessDateRangeValidator();
    }
    
    /// <summary>
    /// MetaData definition for BusinessDayAdjustments
    /// </summary>
    [RosettaMeta(typeof(BusinessDayAdjustments))]
    public class BusinessDayAdjustmentsMeta : IRosettaMetaData<BusinessDayAdjustments>
    {
        public IEnumerable<IValidator<BusinessDayAdjustments>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BusinessDayAdjustments>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BusinessDayAdjustments, ISet<string>> OnlyExistsValidator => new BusinessDayAdjustmentsOnlyExistsValidator();

        public IValidator<BusinessDayAdjustments> Validator => new BusinessDayAdjustmentsValidator();
    }
    
    /// <summary>
    /// MetaData definition for BusinessEvent
    /// </summary>
    [RosettaMeta(typeof(BusinessEvent))]
    public class BusinessEventMeta : IRosettaMetaData<BusinessEvent>
    {
        public IEnumerable<IValidator<BusinessEvent>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BusinessEvent>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BusinessEvent, ISet<string>> OnlyExistsValidator => new BusinessEventOnlyExistsValidator();

        public IValidator<BusinessEvent> Validator => new BusinessEventValidator();
    }
    
    /// <summary>
    /// MetaData definition for BusinessUnit
    /// </summary>
    [RosettaMeta(typeof(BusinessUnit))]
    public class BusinessUnitMeta : IRosettaMetaData<BusinessUnit>
    {
        public IEnumerable<IValidator<BusinessUnit>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BusinessUnit>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BusinessUnit, ISet<string>> OnlyExistsValidator => new BusinessUnitOnlyExistsValidator();

        public IValidator<BusinessUnit> Validator => new BusinessUnitValidator();
    }
    
    /// <summary>
    /// MetaData definition for BuyerSeller
    /// </summary>
    [RosettaMeta(typeof(BuyerSeller))]
    public class BuyerSellerMeta : IRosettaMetaData<BuyerSeller>
    {
        public IEnumerable<IValidator<BuyerSeller>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<BuyerSeller>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<BuyerSeller, ISet<string>> OnlyExistsValidator => new BuyerSellerOnlyExistsValidator();

        public IValidator<BuyerSeller> Validator => new BuyerSellerValidator();
    }
    
    /// <summary>
    /// MetaData definition for Buyr
    /// </summary>
    [RosettaMeta(typeof(Buyr))]
    public class BuyrMeta : IRosettaMetaData<Buyr>
    {
        public IEnumerable<IValidator<Buyr>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Buyr>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Buyr, ISet<string>> OnlyExistsValidator => new BuyrOnlyExistsValidator();

        public IValidator<Buyr> Validator => new BuyrValidator();
    }
    
    /// <summary>
    /// MetaData definition for CalculateTransferInstruction
    /// </summary>
    [RosettaMeta(typeof(CalculateTransferInstruction))]
    public class CalculateTransferInstructionMeta : IRosettaMetaData<CalculateTransferInstruction>
    {
        public IEnumerable<IValidator<CalculateTransferInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CalculateTransferInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CalculateTransferInstruction, ISet<string>> OnlyExistsValidator => new CalculateTransferInstructionOnlyExistsValidator();

        public IValidator<CalculateTransferInstruction> Validator => new CalculateTransferInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for CalculatedRateDetails
    /// </summary>
    [RosettaMeta(typeof(CalculatedRateDetails))]
    public class CalculatedRateDetailsMeta : IRosettaMetaData<CalculatedRateDetails>
    {
        public IEnumerable<IValidator<CalculatedRateDetails>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CalculatedRateDetails>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CalculatedRateDetails, ISet<string>> OnlyExistsValidator => new CalculatedRateDetailsOnlyExistsValidator();

        public IValidator<CalculatedRateDetails> Validator => new CalculatedRateDetailsValidator();
    }
    
    /// <summary>
    /// MetaData definition for CalculatedRateObservationDatesAndWeights
    /// </summary>
    [RosettaMeta(typeof(CalculatedRateObservationDatesAndWeights))]
    public class CalculatedRateObservationDatesAndWeightsMeta : IRosettaMetaData<CalculatedRateObservationDatesAndWeights>
    {
        public IEnumerable<IValidator<CalculatedRateObservationDatesAndWeights>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CalculatedRateObservationDatesAndWeights>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CalculatedRateObservationDatesAndWeights, ISet<string>> OnlyExistsValidator => new CalculatedRateObservationDatesAndWeightsOnlyExistsValidator();

        public IValidator<CalculatedRateObservationDatesAndWeights> Validator => new CalculatedRateObservationDatesAndWeightsValidator();
    }
    
    /// <summary>
    /// MetaData definition for CalculatedRateObservations
    /// </summary>
    [RosettaMeta(typeof(CalculatedRateObservations))]
    public class CalculatedRateObservationsMeta : IRosettaMetaData<CalculatedRateObservations>
    {
        public IEnumerable<IValidator<CalculatedRateObservations>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CalculatedRateObservations>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CalculatedRateObservations, ISet<string>> OnlyExistsValidator => new CalculatedRateObservationsOnlyExistsValidator();

        public IValidator<CalculatedRateObservations> Validator => new CalculatedRateObservationsValidator();
    }
    
    /// <summary>
    /// MetaData definition for CalculationAgent
    /// </summary>
    [RosettaMeta(typeof(CalculationAgent))]
    public class CalculationAgentMeta : IRosettaMetaData<CalculationAgent>
    {
        public IEnumerable<IValidator<CalculationAgent>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CalculationAgent>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CalculationAgent, ISet<string>> OnlyExistsValidator => new CalculationAgentOnlyExistsValidator();

        public IValidator<CalculationAgent> Validator => new CalculationAgentValidator();
    }
    
    /// <summary>
    /// MetaData definition for CalculationFrequency
    /// </summary>
    [RosettaMeta(typeof(CalculationFrequency))]
    public class CalculationFrequencyMeta : IRosettaMetaData<CalculationFrequency>
    {
        public IEnumerable<IValidator<CalculationFrequency>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CalculationFrequency>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CalculationFrequency, ISet<string>> OnlyExistsValidator => new CalculationFrequencyOnlyExistsValidator();

        public IValidator<CalculationFrequency> Validator => new CalculationFrequencyValidator();
    }
    
    /// <summary>
    /// MetaData definition for CalculationPeriod
    /// </summary>
    [RosettaMeta(typeof(CalculationPeriod))]
    public class CalculationPeriodMeta : IRosettaMetaData<CalculationPeriod>
    {
        public IEnumerable<IValidator<CalculationPeriod>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CalculationPeriod>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CalculationPeriod, ISet<string>> OnlyExistsValidator => new CalculationPeriodOnlyExistsValidator();

        public IValidator<CalculationPeriod> Validator => new CalculationPeriodValidator();
    }
    
    /// <summary>
    /// MetaData definition for CalculationPeriodBase
    /// </summary>
    [RosettaMeta(typeof(CalculationPeriodBase))]
    public class CalculationPeriodBaseMeta : IRosettaMetaData<CalculationPeriodBase>
    {
        public IEnumerable<IValidator<CalculationPeriodBase>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CalculationPeriodBase>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CalculationPeriodBase, ISet<string>> OnlyExistsValidator => new CalculationPeriodBaseOnlyExistsValidator();

        public IValidator<CalculationPeriodBase> Validator => new CalculationPeriodBaseValidator();
    }
    
    /// <summary>
    /// MetaData definition for CalculationPeriodData
    /// </summary>
    [RosettaMeta(typeof(CalculationPeriodData))]
    public class CalculationPeriodDataMeta : IRosettaMetaData<CalculationPeriodData>
    {
        public IEnumerable<IValidator<CalculationPeriodData>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CalculationPeriodData>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CalculationPeriodData, ISet<string>> OnlyExistsValidator => new CalculationPeriodDataOnlyExistsValidator();

        public IValidator<CalculationPeriodData> Validator => new CalculationPeriodDataValidator();
    }
    
    /// <summary>
    /// MetaData definition for CalculationPeriodDates
    /// </summary>
    [RosettaMeta(typeof(CalculationPeriodDates))]
    public class CalculationPeriodDatesMeta : IRosettaMetaData<CalculationPeriodDates>
    {
        public IEnumerable<IValidator<CalculationPeriodDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CalculationPeriodDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CalculationPeriodDates, ISet<string>> OnlyExistsValidator => new CalculationPeriodDatesOnlyExistsValidator();

        public IValidator<CalculationPeriodDates> Validator => new CalculationPeriodDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for CalculationPeriodFrequency
    /// </summary>
    [RosettaMeta(typeof(CalculationPeriodFrequency))]
    public class CalculationPeriodFrequencyMeta : IRosettaMetaData<CalculationPeriodFrequency>
    {
        public IEnumerable<IValidator<CalculationPeriodFrequency>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CalculationPeriodFrequency>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CalculationPeriodFrequency, ISet<string>> OnlyExistsValidator => new CalculationPeriodFrequencyOnlyExistsValidator();

        public IValidator<CalculationPeriodFrequency> Validator => new CalculationPeriodFrequencyValidator();
    }
    
    /// <summary>
    /// MetaData definition for CalculationSchedule
    /// </summary>
    [RosettaMeta(typeof(CalculationSchedule))]
    public class CalculationScheduleMeta : IRosettaMetaData<CalculationSchedule>
    {
        public IEnumerable<IValidator<CalculationSchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CalculationSchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CalculationSchedule, ISet<string>> OnlyExistsValidator => new CalculationScheduleOnlyExistsValidator();

        public IValidator<CalculationSchedule> Validator => new CalculationScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for CalculationScheduleDeliveryPeriods
    /// </summary>
    [RosettaMeta(typeof(CalculationScheduleDeliveryPeriods))]
    public class CalculationScheduleDeliveryPeriodsMeta : IRosettaMetaData<CalculationScheduleDeliveryPeriods>
    {
        public IEnumerable<IValidator<CalculationScheduleDeliveryPeriods>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CalculationScheduleDeliveryPeriods>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CalculationScheduleDeliveryPeriods, ISet<string>> OnlyExistsValidator => new CalculationScheduleDeliveryPeriodsOnlyExistsValidator();

        public IValidator<CalculationScheduleDeliveryPeriods> Validator => new CalculationScheduleDeliveryPeriodsValidator();
    }
    
    /// <summary>
    /// MetaData definition for CalendarSpread
    /// </summary>
    [RosettaMeta(typeof(CalendarSpread))]
    public class CalendarSpreadMeta : IRosettaMetaData<CalendarSpread>
    {
        public IEnumerable<IValidator<CalendarSpread>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CalendarSpread>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CalendarSpread, ISet<string>> OnlyExistsValidator => new CalendarSpreadOnlyExistsValidator();

        public IValidator<CalendarSpread> Validator => new CalendarSpreadValidator();
    }
    
    /// <summary>
    /// MetaData definition for CancelableProvision
    /// </summary>
    [RosettaMeta(typeof(CancelableProvision))]
    public class CancelableProvisionMeta : IRosettaMetaData<CancelableProvision>
    {
        public IEnumerable<IValidator<CancelableProvision>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CancelableProvision>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CancelableProvision, ISet<string>> OnlyExistsValidator => new CancelableProvisionOnlyExistsValidator();

        public IValidator<CancelableProvision> Validator => new CancelableProvisionValidator();
    }
    
    /// <summary>
    /// MetaData definition for CancelableProvisionAdjustedDates
    /// </summary>
    [RosettaMeta(typeof(CancelableProvisionAdjustedDates))]
    public class CancelableProvisionAdjustedDatesMeta : IRosettaMetaData<CancelableProvisionAdjustedDates>
    {
        public IEnumerable<IValidator<CancelableProvisionAdjustedDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CancelableProvisionAdjustedDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CancelableProvisionAdjustedDates, ISet<string>> OnlyExistsValidator => new CancelableProvisionAdjustedDatesOnlyExistsValidator();

        public IValidator<CancelableProvisionAdjustedDates> Validator => new CancelableProvisionAdjustedDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for CancellationEvent
    /// </summary>
    [RosettaMeta(typeof(CancellationEvent))]
    public class CancellationEventMeta : IRosettaMetaData<CancellationEvent>
    {
        public IEnumerable<IValidator<CancellationEvent>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CancellationEvent>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CancellationEvent, ISet<string>> OnlyExistsValidator => new CancellationEventOnlyExistsValidator();

        public IValidator<CancellationEvent> Validator => new CancellationEventValidator();
    }
    
    /// <summary>
    /// MetaData definition for Cash
    /// </summary>
    [RosettaMeta(typeof(Cash))]
    public class CashMeta : IRosettaMetaData<Cash>
    {
        public IEnumerable<IValidator<Cash>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Cash>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Cash, ISet<string>> OnlyExistsValidator => new CashOnlyExistsValidator();

        public IValidator<Cash> Validator => new CashValidator();
    }
    
    /// <summary>
    /// MetaData definition for CashCollateralValuationMethod
    /// </summary>
    [RosettaMeta(typeof(CashCollateralValuationMethod))]
    public class CashCollateralValuationMethodMeta : IRosettaMetaData<CashCollateralValuationMethod>
    {
        public IEnumerable<IValidator<CashCollateralValuationMethod>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CashCollateralValuationMethod>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CashCollateralValuationMethod, ISet<string>> OnlyExistsValidator => new CashCollateralValuationMethodOnlyExistsValidator();

        public IValidator<CashCollateralValuationMethod> Validator => new CashCollateralValuationMethodValidator();
    }
    
    /// <summary>
    /// MetaData definition for CashPrice
    /// </summary>
    [RosettaMeta(typeof(CashPrice))]
    public class CashPriceMeta : IRosettaMetaData<CashPrice>
    {
        public IEnumerable<IValidator<CashPrice>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CashPrice>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CashPrice, ISet<string>> OnlyExistsValidator => new CashPriceOnlyExistsValidator();

        public IValidator<CashPrice> Validator => new CashPriceValidator();
    }
    
    /// <summary>
    /// MetaData definition for CashSettlementTerms
    /// </summary>
    [RosettaMeta(typeof(CashSettlementTerms))]
    public class CashSettlementTermsMeta : IRosettaMetaData<CashSettlementTerms>
    {
        public IEnumerable<IValidator<CashSettlementTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CashSettlementTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CashSettlementTerms, ISet<string>> OnlyExistsValidator => new CashSettlementTermsOnlyExistsValidator();

        public IValidator<CashSettlementTerms> Validator => new CashSettlementTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for Cashflow
    /// </summary>
    [RosettaMeta(typeof(Cashflow))]
    public class CashflowMeta : IRosettaMetaData<Cashflow>
    {
        public IEnumerable<IValidator<Cashflow>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Cashflow>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Cashflow, ISet<string>> OnlyExistsValidator => new CashflowOnlyExistsValidator();

        public IValidator<Cashflow> Validator => new CashflowValidator();
    }
    
    /// <summary>
    /// MetaData definition for CashflowRepresentation
    /// </summary>
    [RosettaMeta(typeof(CashflowRepresentation))]
    public class CashflowRepresentationMeta : IRosettaMetaData<CashflowRepresentation>
    {
        public IEnumerable<IValidator<CashflowRepresentation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CashflowRepresentation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CashflowRepresentation, ISet<string>> OnlyExistsValidator => new CashflowRepresentationOnlyExistsValidator();

        public IValidator<CashflowRepresentation> Validator => new CashflowRepresentationValidator();
    }
    
    /// <summary>
    /// MetaData definition for CashflowType
    /// </summary>
    [RosettaMeta(typeof(CashflowType))]
    public class CashflowTypeMeta : IRosettaMetaData<CashflowType>
    {
        public IEnumerable<IValidator<CashflowType>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CashflowType>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CashflowType, ISet<string>> OnlyExistsValidator => new CashflowTypeOnlyExistsValidator();

        public IValidator<CashflowType> Validator => new CashflowTypeValidator();
    }
    
    /// <summary>
    /// MetaData definition for CheckEligibilityResult
    /// </summary>
    [RosettaMeta(typeof(CheckEligibilityResult))]
    public class CheckEligibilityResultMeta : IRosettaMetaData<CheckEligibilityResult>
    {
        public IEnumerable<IValidator<CheckEligibilityResult>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CheckEligibilityResult>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CheckEligibilityResult, ISet<string>> OnlyExistsValidator => new CheckEligibilityResultOnlyExistsValidator();

        public IValidator<CheckEligibilityResult> Validator => new CheckEligibilityResultValidator();
    }
    
    /// <summary>
    /// MetaData definition for Clause
    /// </summary>
    [RosettaMeta(typeof(Clause))]
    public class ClauseMeta : IRosettaMetaData<Clause>
    {
        public IEnumerable<IValidator<Clause>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Clause>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Clause, ISet<string>> OnlyExistsValidator => new ClauseOnlyExistsValidator();

        public IValidator<Clause> Validator => new ClauseValidator();
    }
    
    /// <summary>
    /// MetaData definition for ClearingInstruction
    /// </summary>
    [RosettaMeta(typeof(ClearingInstruction))]
    public class ClearingInstructionMeta : IRosettaMetaData<ClearingInstruction>
    {
        public IEnumerable<IValidator<ClearingInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ClearingInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ClearingInstruction, ISet<string>> OnlyExistsValidator => new ClearingInstructionOnlyExistsValidator();

        public IValidator<ClearingInstruction> Validator => new ClearingInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for ClosedState
    /// </summary>
    [RosettaMeta(typeof(ClosedState))]
    public class ClosedStateMeta : IRosettaMetaData<ClosedState>
    {
        public IEnumerable<IValidator<ClosedState>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ClosedState>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ClosedState, ISet<string>> OnlyExistsValidator => new ClosedStateOnlyExistsValidator();

        public IValidator<ClosedState> Validator => new ClosedStateValidator();
    }
    
    /// <summary>
    /// MetaData definition for Collateral
    /// </summary>
    [RosettaMeta(typeof(Collateral))]
    public class CollateralMeta : IRosettaMetaData<Collateral>
    {
        public IEnumerable<IValidator<Collateral>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Collateral>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Collateral, ISet<string>> OnlyExistsValidator => new CollateralOnlyExistsValidator();

        public IValidator<Collateral> Validator => new CollateralValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralAgreementFloatingRate
    /// </summary>
    [RosettaMeta(typeof(CollateralAgreementFloatingRate))]
    public class CollateralAgreementFloatingRateMeta : IRosettaMetaData<CollateralAgreementFloatingRate>
    {
        public IEnumerable<IValidator<CollateralAgreementFloatingRate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralAgreementFloatingRate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralAgreementFloatingRate, ISet<string>> OnlyExistsValidator => new CollateralAgreementFloatingRateOnlyExistsValidator();

        public IValidator<CollateralAgreementFloatingRate> Validator => new CollateralAgreementFloatingRateValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralBalance
    /// </summary>
    [RosettaMeta(typeof(CollateralBalance))]
    public class CollateralBalanceMeta : IRosettaMetaData<CollateralBalance>
    {
        public IEnumerable<IValidator<CollateralBalance>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralBalance>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralBalance, ISet<string>> OnlyExistsValidator => new CollateralBalanceOnlyExistsValidator();

        public IValidator<CollateralBalance> Validator => new CollateralBalanceValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralCriteria
    /// </summary>
    [RosettaMeta(typeof(CollateralCriteria))]
    public class CollateralCriteriaMeta : IRosettaMetaData<CollateralCriteria>
    {
        public IEnumerable<IValidator<CollateralCriteria>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralCriteria>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralCriteria, ISet<string>> OnlyExistsValidator => new CollateralCriteriaOnlyExistsValidator();

        public IValidator<CollateralCriteria> Validator => new CollateralCriteriaValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralCriteriaBase
    /// </summary>
    [RosettaMeta(typeof(CollateralCriteriaBase))]
    public class CollateralCriteriaBaseMeta : IRosettaMetaData<CollateralCriteriaBase>
    {
        public IEnumerable<IValidator<CollateralCriteriaBase>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralCriteriaBase>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralCriteriaBase, ISet<string>> OnlyExistsValidator => new CollateralCriteriaBaseOnlyExistsValidator();

        public IValidator<CollateralCriteriaBase> Validator => new CollateralCriteriaBaseValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralInterestCalculationParameters
    /// </summary>
    [RosettaMeta(typeof(CollateralInterestCalculationParameters))]
    public class CollateralInterestCalculationParametersMeta : IRosettaMetaData<CollateralInterestCalculationParameters>
    {
        public IEnumerable<IValidator<CollateralInterestCalculationParameters>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralInterestCalculationParameters>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralInterestCalculationParameters, ISet<string>> OnlyExistsValidator => new CollateralInterestCalculationParametersOnlyExistsValidator();

        public IValidator<CollateralInterestCalculationParameters> Validator => new CollateralInterestCalculationParametersValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralInterestHandlingParameters
    /// </summary>
    [RosettaMeta(typeof(CollateralInterestHandlingParameters))]
    public class CollateralInterestHandlingParametersMeta : IRosettaMetaData<CollateralInterestHandlingParameters>
    {
        public IEnumerable<IValidator<CollateralInterestHandlingParameters>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralInterestHandlingParameters>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralInterestHandlingParameters, ISet<string>> OnlyExistsValidator => new CollateralInterestHandlingParametersOnlyExistsValidator();

        public IValidator<CollateralInterestHandlingParameters> Validator => new CollateralInterestHandlingParametersValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralInterestNotification
    /// </summary>
    [RosettaMeta(typeof(CollateralInterestNotification))]
    public class CollateralInterestNotificationMeta : IRosettaMetaData<CollateralInterestNotification>
    {
        public IEnumerable<IValidator<CollateralInterestNotification>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralInterestNotification>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralInterestNotification, ISet<string>> OnlyExistsValidator => new CollateralInterestNotificationOnlyExistsValidator();

        public IValidator<CollateralInterestNotification> Validator => new CollateralInterestNotificationValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralInterestParameters
    /// </summary>
    [RosettaMeta(typeof(CollateralInterestParameters))]
    public class CollateralInterestParametersMeta : IRosettaMetaData<CollateralInterestParameters>
    {
        public IEnumerable<IValidator<CollateralInterestParameters>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralInterestParameters>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralInterestParameters, ISet<string>> OnlyExistsValidator => new CollateralInterestParametersOnlyExistsValidator();

        public IValidator<CollateralInterestParameters> Validator => new CollateralInterestParametersValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralIssuerType
    /// </summary>
    [RosettaMeta(typeof(CollateralIssuerType))]
    public class CollateralIssuerTypeMeta : IRosettaMetaData<CollateralIssuerType>
    {
        public IEnumerable<IValidator<CollateralIssuerType>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralIssuerType>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralIssuerType, ISet<string>> OnlyExistsValidator => new CollateralIssuerTypeOnlyExistsValidator();

        public IValidator<CollateralIssuerType> Validator => new CollateralIssuerTypeValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralPortfolio
    /// </summary>
    [RosettaMeta(typeof(CollateralPortfolio))]
    public class CollateralPortfolioMeta : IRosettaMetaData<CollateralPortfolio>
    {
        public IEnumerable<IValidator<CollateralPortfolio>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralPortfolio>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralPortfolio, ISet<string>> OnlyExistsValidator => new CollateralPortfolioOnlyExistsValidator();

        public IValidator<CollateralPortfolio> Validator => new CollateralPortfolioValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralPosition
    /// </summary>
    [RosettaMeta(typeof(CollateralPosition))]
    public class CollateralPositionMeta : IRosettaMetaData<CollateralPosition>
    {
        public IEnumerable<IValidator<CollateralPosition>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralPosition>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralPosition, ISet<string>> OnlyExistsValidator => new CollateralPositionOnlyExistsValidator();

        public IValidator<CollateralPosition> Validator => new CollateralPositionValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralProvisions
    /// </summary>
    [RosettaMeta(typeof(CollateralProvisions))]
    public class CollateralProvisionsMeta : IRosettaMetaData<CollateralProvisions>
    {
        public IEnumerable<IValidator<CollateralProvisions>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralProvisions>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralProvisions, ISet<string>> OnlyExistsValidator => new CollateralProvisionsOnlyExistsValidator();

        public IValidator<CollateralProvisions> Validator => new CollateralProvisionsValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralTaxonomy
    /// </summary>
    [RosettaMeta(typeof(CollateralTaxonomy))]
    public class CollateralTaxonomyMeta : IRosettaMetaData<CollateralTaxonomy>
    {
        public IEnumerable<IValidator<CollateralTaxonomy>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralTaxonomy>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralTaxonomy, ISet<string>> OnlyExistsValidator => new CollateralTaxonomyOnlyExistsValidator();

        public IValidator<CollateralTaxonomy> Validator => new CollateralTaxonomyValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralTaxonomyValue
    /// </summary>
    [RosettaMeta(typeof(CollateralTaxonomyValue))]
    public class CollateralTaxonomyValueMeta : IRosettaMetaData<CollateralTaxonomyValue>
    {
        public IEnumerable<IValidator<CollateralTaxonomyValue>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralTaxonomyValue>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralTaxonomyValue, ISet<string>> OnlyExistsValidator => new CollateralTaxonomyValueOnlyExistsValidator();

        public IValidator<CollateralTaxonomyValue> Validator => new CollateralTaxonomyValueValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralTransferAgreementElections
    /// </summary>
    [RosettaMeta(typeof(CollateralTransferAgreementElections))]
    public class CollateralTransferAgreementElectionsMeta : IRosettaMetaData<CollateralTransferAgreementElections>
    {
        public IEnumerable<IValidator<CollateralTransferAgreementElections>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralTransferAgreementElections>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralTransferAgreementElections, ISet<string>> OnlyExistsValidator => new CollateralTransferAgreementElectionsOnlyExistsValidator();

        public IValidator<CollateralTransferAgreementElections> Validator => new CollateralTransferAgreementElectionsValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralTreatment
    /// </summary>
    [RosettaMeta(typeof(CollateralTreatment))]
    public class CollateralTreatmentMeta : IRosettaMetaData<CollateralTreatment>
    {
        public IEnumerable<IValidator<CollateralTreatment>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralTreatment>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralTreatment, ISet<string>> OnlyExistsValidator => new CollateralTreatmentOnlyExistsValidator();

        public IValidator<CollateralTreatment> Validator => new CollateralTreatmentValidator();
    }
    
    /// <summary>
    /// MetaData definition for CollateralValuationTreatment
    /// </summary>
    [RosettaMeta(typeof(CollateralValuationTreatment))]
    public class CollateralValuationTreatmentMeta : IRosettaMetaData<CollateralValuationTreatment>
    {
        public IEnumerable<IValidator<CollateralValuationTreatment>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CollateralValuationTreatment>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CollateralValuationTreatment, ISet<string>> OnlyExistsValidator => new CollateralValuationTreatmentOnlyExistsValidator();

        public IValidator<CollateralValuationTreatment> Validator => new CollateralValuationTreatmentValidator();
    }
    
    /// <summary>
    /// MetaData definition for Commodity
    /// </summary>
    [RosettaMeta(typeof(Commodity))]
    public class CommodityMeta : IRosettaMetaData<Commodity>
    {
        public IEnumerable<IValidator<Commodity>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Commodity>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Commodity, ISet<string>> OnlyExistsValidator => new CommodityOnlyExistsValidator();

        public IValidator<Commodity> Validator => new CommodityValidator();
    }
    
    /// <summary>
    /// MetaData definition for CommodityPayout
    /// </summary>
    [RosettaMeta(typeof(CommodityPayout))]
    public class CommodityPayoutMeta : IRosettaMetaData<CommodityPayout>
    {
        public IEnumerable<IValidator<CommodityPayout>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CommodityPayout>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CommodityPayout, ISet<string>> OnlyExistsValidator => new CommodityPayoutOnlyExistsValidator();

        public IValidator<CommodityPayout> Validator => new CommodityPayoutValidator();
    }
    
    /// <summary>
    /// MetaData definition for CommodityPriceReturnTerms
    /// </summary>
    [RosettaMeta(typeof(CommodityPriceReturnTerms))]
    public class CommodityPriceReturnTermsMeta : IRosettaMetaData<CommodityPriceReturnTerms>
    {
        public IEnumerable<IValidator<CommodityPriceReturnTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CommodityPriceReturnTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CommodityPriceReturnTerms, ISet<string>> OnlyExistsValidator => new CommodityPriceReturnTermsOnlyExistsValidator();

        public IValidator<CommodityPriceReturnTerms> Validator => new CommodityPriceReturnTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for CommodityProductDefinition
    /// </summary>
    [RosettaMeta(typeof(CommodityProductDefinition))]
    public class CommodityProductDefinitionMeta : IRosettaMetaData<CommodityProductDefinition>
    {
        public IEnumerable<IValidator<CommodityProductDefinition>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CommodityProductDefinition>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CommodityProductDefinition, ISet<string>> OnlyExistsValidator => new CommodityProductDefinitionOnlyExistsValidator();

        public IValidator<CommodityProductDefinition> Validator => new CommodityProductDefinitionValidator();
    }
    
    /// <summary>
    /// MetaData definition for CommodityReferenceFramework
    /// </summary>
    [RosettaMeta(typeof(CommodityReferenceFramework))]
    public class CommodityReferenceFrameworkMeta : IRosettaMetaData<CommodityReferenceFramework>
    {
        public IEnumerable<IValidator<CommodityReferenceFramework>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CommodityReferenceFramework>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CommodityReferenceFramework, ISet<string>> OnlyExistsValidator => new CommodityReferenceFrameworkOnlyExistsValidator();

        public IValidator<CommodityReferenceFramework> Validator => new CommodityReferenceFrameworkValidator();
    }
    
    /// <summary>
    /// MetaData definition for Composite
    /// </summary>
    [RosettaMeta(typeof(Composite))]
    public class CompositeMeta : IRosettaMetaData<Composite>
    {
        public IEnumerable<IValidator<Composite>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Composite>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Composite, ISet<string>> OnlyExistsValidator => new CompositeOnlyExistsValidator();

        public IValidator<Composite> Validator => new CompositeValidator();
    }
    
    /// <summary>
    /// MetaData definition for ComputedAmount
    /// </summary>
    [RosettaMeta(typeof(ComputedAmount))]
    public class ComputedAmountMeta : IRosettaMetaData<ComputedAmount>
    {
        public IEnumerable<IValidator<ComputedAmount>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ComputedAmount>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ComputedAmount, ISet<string>> OnlyExistsValidator => new ComputedAmountOnlyExistsValidator();

        public IValidator<ComputedAmount> Validator => new ComputedAmountValidator();
    }
    
    /// <summary>
    /// MetaData definition for ConcentrationLimit
    /// </summary>
    [RosettaMeta(typeof(ConcentrationLimit))]
    public class ConcentrationLimitMeta : IRosettaMetaData<ConcentrationLimit>
    {
        public IEnumerable<IValidator<ConcentrationLimit>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ConcentrationLimit>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ConcentrationLimit, ISet<string>> OnlyExistsValidator => new ConcentrationLimitOnlyExistsValidator();

        public IValidator<ConcentrationLimit> Validator => new ConcentrationLimitValidator();
    }
    
    /// <summary>
    /// MetaData definition for ConcentrationLimitCriteria
    /// </summary>
    [RosettaMeta(typeof(ConcentrationLimitCriteria))]
    public class ConcentrationLimitCriteriaMeta : IRosettaMetaData<ConcentrationLimitCriteria>
    {
        public IEnumerable<IValidator<ConcentrationLimitCriteria>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ConcentrationLimitCriteria>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ConcentrationLimitCriteria, ISet<string>> OnlyExistsValidator => new ConcentrationLimitCriteriaOnlyExistsValidator();

        public IValidator<ConcentrationLimitCriteria> Validator => new ConcentrationLimitCriteriaValidator();
    }
    
    /// <summary>
    /// MetaData definition for ConstituentWeight
    /// </summary>
    [RosettaMeta(typeof(ConstituentWeight))]
    public class ConstituentWeightMeta : IRosettaMetaData<ConstituentWeight>
    {
        public IEnumerable<IValidator<ConstituentWeight>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ConstituentWeight>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ConstituentWeight, ISet<string>> OnlyExistsValidator => new ConstituentWeightOnlyExistsValidator();

        public IValidator<ConstituentWeight> Validator => new ConstituentWeightValidator();
    }
    
    /// <summary>
    /// MetaData definition for ContactElection
    /// </summary>
    [RosettaMeta(typeof(ContactElection))]
    public class ContactElectionMeta : IRosettaMetaData<ContactElection>
    {
        public IEnumerable<IValidator<ContactElection>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ContactElection>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ContactElection, ISet<string>> OnlyExistsValidator => new ContactElectionOnlyExistsValidator();

        public IValidator<ContactElection> Validator => new ContactElectionValidator();
    }
    
    /// <summary>
    /// MetaData definition for ContactInformation
    /// </summary>
    [RosettaMeta(typeof(ContactInformation))]
    public class ContactInformationMeta : IRosettaMetaData<ContactInformation>
    {
        public IEnumerable<IValidator<ContactInformation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ContactInformation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ContactInformation, ISet<string>> OnlyExistsValidator => new ContactInformationOnlyExistsValidator();

        public IValidator<ContactInformation> Validator => new ContactInformationValidator();
    }
    
    /// <summary>
    /// MetaData definition for ContractBase
    /// </summary>
    [RosettaMeta(typeof(ContractBase))]
    public class ContractBaseMeta : IRosettaMetaData<ContractBase>
    {
        public IEnumerable<IValidator<ContractBase>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ContractBase>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ContractBase, ISet<string>> OnlyExistsValidator => new ContractBaseOnlyExistsValidator();

        public IValidator<ContractBase> Validator => new ContractBaseValidator();
    }
    
    /// <summary>
    /// MetaData definition for ContractDetails
    /// </summary>
    [RosettaMeta(typeof(ContractDetails))]
    public class ContractDetailsMeta : IRosettaMetaData<ContractDetails>
    {
        public IEnumerable<IValidator<ContractDetails>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ContractDetails>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ContractDetails, ISet<string>> OnlyExistsValidator => new ContractDetailsOnlyExistsValidator();

        public IValidator<ContractDetails> Validator => new ContractDetailsValidator();
    }
    
    /// <summary>
    /// MetaData definition for ContractFormationInstruction
    /// </summary>
    [RosettaMeta(typeof(ContractFormationInstruction))]
    public class ContractFormationInstructionMeta : IRosettaMetaData<ContractFormationInstruction>
    {
        public IEnumerable<IValidator<ContractFormationInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ContractFormationInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ContractFormationInstruction, ISet<string>> OnlyExistsValidator => new ContractFormationInstructionOnlyExistsValidator();

        public IValidator<ContractFormationInstruction> Validator => new ContractFormationInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for ContractualMatrix
    /// </summary>
    [RosettaMeta(typeof(ContractualMatrix))]
    public class ContractualMatrixMeta : IRosettaMetaData<ContractualMatrix>
    {
        public IEnumerable<IValidator<ContractualMatrix>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ContractualMatrix>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ContractualMatrix, ISet<string>> OnlyExistsValidator => new ContractualMatrixOnlyExistsValidator();

        public IValidator<ContractualMatrix> Validator => new ContractualMatrixValidator();
    }
    
    /// <summary>
    /// MetaData definition for ContractualTermsSupplement
    /// </summary>
    [RosettaMeta(typeof(ContractualTermsSupplement))]
    public class ContractualTermsSupplementMeta : IRosettaMetaData<ContractualTermsSupplement>
    {
        public IEnumerable<IValidator<ContractualTermsSupplement>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ContractualTermsSupplement>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ContractualTermsSupplement, ISet<string>> OnlyExistsValidator => new ContractualTermsSupplementOnlyExistsValidator();

        public IValidator<ContractualTermsSupplement> Validator => new ContractualTermsSupplementValidator();
    }
    
    /// <summary>
    /// MetaData definition for CorporateAction
    /// </summary>
    [RosettaMeta(typeof(CorporateAction))]
    public class CorporateActionMeta : IRosettaMetaData<CorporateAction>
    {
        public IEnumerable<IValidator<CorporateAction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CorporateAction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CorporateAction, ISet<string>> OnlyExistsValidator => new CorporateActionOnlyExistsValidator();

        public IValidator<CorporateAction> Validator => new CorporateActionValidator();
    }
    
    /// <summary>
    /// MetaData definition for CorrelationReturnTerms
    /// </summary>
    [RosettaMeta(typeof(CorrelationReturnTerms))]
    public class CorrelationReturnTermsMeta : IRosettaMetaData<CorrelationReturnTerms>
    {
        public IEnumerable<IValidator<CorrelationReturnTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CorrelationReturnTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CorrelationReturnTerms, ISet<string>> OnlyExistsValidator => new CorrelationReturnTermsOnlyExistsValidator();

        public IValidator<CorrelationReturnTerms> Validator => new CorrelationReturnTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for Counterparty
    /// </summary>
    [RosettaMeta(typeof(Counterparty))]
    public class CounterpartyMeta : IRosettaMetaData<Counterparty>
    {
        public IEnumerable<IValidator<Counterparty>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Counterparty>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Counterparty, ISet<string>> OnlyExistsValidator => new CounterpartyOnlyExistsValidator();

        public IValidator<Counterparty> Validator => new CounterpartyValidator();
    }
    
    /// <summary>
    /// MetaData definition for CounterpartyOwnIssuePermitted
    /// </summary>
    [RosettaMeta(typeof(CounterpartyOwnIssuePermitted))]
    public class CounterpartyOwnIssuePermittedMeta : IRosettaMetaData<CounterpartyOwnIssuePermitted>
    {
        public IEnumerable<IValidator<CounterpartyOwnIssuePermitted>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CounterpartyOwnIssuePermitted>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CounterpartyOwnIssuePermitted, ISet<string>> OnlyExistsValidator => new CounterpartyOwnIssuePermittedOnlyExistsValidator();

        public IValidator<CounterpartyOwnIssuePermitted> Validator => new CounterpartyOwnIssuePermittedValidator();
    }
    
    /// <summary>
    /// MetaData definition for CounterpartyPosition
    /// </summary>
    [RosettaMeta(typeof(CounterpartyPosition))]
    public class CounterpartyPositionMeta : IRosettaMetaData<CounterpartyPosition>
    {
        public IEnumerable<IValidator<CounterpartyPosition>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CounterpartyPosition>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CounterpartyPosition, ISet<string>> OnlyExistsValidator => new CounterpartyPositionOnlyExistsValidator();

        public IValidator<CounterpartyPosition> Validator => new CounterpartyPositionValidator();
    }
    
    /// <summary>
    /// MetaData definition for CounterpartyPositionBusinessEvent
    /// </summary>
    [RosettaMeta(typeof(CounterpartyPositionBusinessEvent))]
    public class CounterpartyPositionBusinessEventMeta : IRosettaMetaData<CounterpartyPositionBusinessEvent>
    {
        public IEnumerable<IValidator<CounterpartyPositionBusinessEvent>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CounterpartyPositionBusinessEvent>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CounterpartyPositionBusinessEvent, ISet<string>> OnlyExistsValidator => new CounterpartyPositionBusinessEventOnlyExistsValidator();

        public IValidator<CounterpartyPositionBusinessEvent> Validator => new CounterpartyPositionBusinessEventValidator();
    }
    
    /// <summary>
    /// MetaData definition for CounterpartyPositionState
    /// </summary>
    [RosettaMeta(typeof(CounterpartyPositionState))]
    public class CounterpartyPositionStateMeta : IRosettaMetaData<CounterpartyPositionState>
    {
        public IEnumerable<IValidator<CounterpartyPositionState>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CounterpartyPositionState>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CounterpartyPositionState, ISet<string>> OnlyExistsValidator => new CounterpartyPositionStateOnlyExistsValidator();

        public IValidator<CounterpartyPositionState> Validator => new CounterpartyPositionStateValidator();
    }
    
    /// <summary>
    /// MetaData definition for CreditDefaultPayout
    /// </summary>
    [RosettaMeta(typeof(CreditDefaultPayout))]
    public class CreditDefaultPayoutMeta : IRosettaMetaData<CreditDefaultPayout>
    {
        public IEnumerable<IValidator<CreditDefaultPayout>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CreditDefaultPayout>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CreditDefaultPayout, ISet<string>> OnlyExistsValidator => new CreditDefaultPayoutOnlyExistsValidator();

        public IValidator<CreditDefaultPayout> Validator => new CreditDefaultPayoutValidator();
    }
    
    /// <summary>
    /// MetaData definition for CreditEvent
    /// </summary>
    [RosettaMeta(typeof(CreditEvent))]
    public class CreditEventMeta : IRosettaMetaData<CreditEvent>
    {
        public IEnumerable<IValidator<CreditEvent>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CreditEvent>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CreditEvent, ISet<string>> OnlyExistsValidator => new CreditEventOnlyExistsValidator();

        public IValidator<CreditEvent> Validator => new CreditEventValidator();
    }
    
    /// <summary>
    /// MetaData definition for CreditEventNotice
    /// </summary>
    [RosettaMeta(typeof(CreditEventNotice))]
    public class CreditEventNoticeMeta : IRosettaMetaData<CreditEventNotice>
    {
        public IEnumerable<IValidator<CreditEventNotice>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CreditEventNotice>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CreditEventNotice, ISet<string>> OnlyExistsValidator => new CreditEventNoticeOnlyExistsValidator();

        public IValidator<CreditEventNotice> Validator => new CreditEventNoticeValidator();
    }
    
    /// <summary>
    /// MetaData definition for CreditEvents
    /// </summary>
    [RosettaMeta(typeof(CreditEvents))]
    public class CreditEventsMeta : IRosettaMetaData<CreditEvents>
    {
        public IEnumerable<IValidator<CreditEvents>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CreditEvents>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CreditEvents, ISet<string>> OnlyExistsValidator => new CreditEventsOnlyExistsValidator();

        public IValidator<CreditEvents> Validator => new CreditEventsValidator();
    }
    
    /// <summary>
    /// MetaData definition for CreditIndex
    /// </summary>
    [RosettaMeta(typeof(CreditIndex))]
    public class CreditIndexMeta : IRosettaMetaData<CreditIndex>
    {
        public IEnumerable<IValidator<CreditIndex>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CreditIndex>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CreditIndex, ISet<string>> OnlyExistsValidator => new CreditIndexOnlyExistsValidator();

        public IValidator<CreditIndex> Validator => new CreditIndexValidator();
    }
    
    /// <summary>
    /// MetaData definition for CreditLimitInformation
    /// </summary>
    [RosettaMeta(typeof(CreditLimitInformation))]
    public class CreditLimitInformationMeta : IRosettaMetaData<CreditLimitInformation>
    {
        public IEnumerable<IValidator<CreditLimitInformation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CreditLimitInformation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CreditLimitInformation, ISet<string>> OnlyExistsValidator => new CreditLimitInformationOnlyExistsValidator();

        public IValidator<CreditLimitInformation> Validator => new CreditLimitInformationValidator();
    }
    
    /// <summary>
    /// MetaData definition for CreditLimitUtilisation
    /// </summary>
    [RosettaMeta(typeof(CreditLimitUtilisation))]
    public class CreditLimitUtilisationMeta : IRosettaMetaData<CreditLimitUtilisation>
    {
        public IEnumerable<IValidator<CreditLimitUtilisation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CreditLimitUtilisation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CreditLimitUtilisation, ISet<string>> OnlyExistsValidator => new CreditLimitUtilisationOnlyExistsValidator();

        public IValidator<CreditLimitUtilisation> Validator => new CreditLimitUtilisationValidator();
    }
    
    /// <summary>
    /// MetaData definition for CreditLimitUtilisationPosition
    /// </summary>
    [RosettaMeta(typeof(CreditLimitUtilisationPosition))]
    public class CreditLimitUtilisationPositionMeta : IRosettaMetaData<CreditLimitUtilisationPosition>
    {
        public IEnumerable<IValidator<CreditLimitUtilisationPosition>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CreditLimitUtilisationPosition>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CreditLimitUtilisationPosition, ISet<string>> OnlyExistsValidator => new CreditLimitUtilisationPositionOnlyExistsValidator();

        public IValidator<CreditLimitUtilisationPosition> Validator => new CreditLimitUtilisationPositionValidator();
    }
    
    /// <summary>
    /// MetaData definition for CreditNotation
    /// </summary>
    [RosettaMeta(typeof(CreditNotation))]
    public class CreditNotationMeta : IRosettaMetaData<CreditNotation>
    {
        public IEnumerable<IValidator<CreditNotation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CreditNotation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CreditNotation, ISet<string>> OnlyExistsValidator => new CreditNotationOnlyExistsValidator();

        public IValidator<CreditNotation> Validator => new CreditNotationValidator();
    }
    
    /// <summary>
    /// MetaData definition for CreditNotations
    /// </summary>
    [RosettaMeta(typeof(CreditNotations))]
    public class CreditNotationsMeta : IRosettaMetaData<CreditNotations>
    {
        public IEnumerable<IValidator<CreditNotations>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CreditNotations>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CreditNotations, ISet<string>> OnlyExistsValidator => new CreditNotationsOnlyExistsValidator();

        public IValidator<CreditNotations> Validator => new CreditNotationsValidator();
    }
    
    /// <summary>
    /// MetaData definition for CreditRatingDebt
    /// </summary>
    [RosettaMeta(typeof(CreditRatingDebt))]
    public class CreditRatingDebtMeta : IRosettaMetaData<CreditRatingDebt>
    {
        public IEnumerable<IValidator<CreditRatingDebt>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CreditRatingDebt>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CreditRatingDebt, ISet<string>> OnlyExistsValidator => new CreditRatingDebtOnlyExistsValidator();

        public IValidator<CreditRatingDebt> Validator => new CreditRatingDebtValidator();
    }
    
    /// <summary>
    /// MetaData definition for CreditSupportAgreementElections
    /// </summary>
    [RosettaMeta(typeof(CreditSupportAgreementElections))]
    public class CreditSupportAgreementElectionsMeta : IRosettaMetaData<CreditSupportAgreementElections>
    {
        public IEnumerable<IValidator<CreditSupportAgreementElections>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CreditSupportAgreementElections>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CreditSupportAgreementElections, ISet<string>> OnlyExistsValidator => new CreditSupportAgreementElectionsOnlyExistsValidator();

        public IValidator<CreditSupportAgreementElections> Validator => new CreditSupportAgreementElectionsValidator();
    }
    
    /// <summary>
    /// MetaData definition for Curve
    /// </summary>
    [RosettaMeta(typeof(Curve))]
    public class CurveMeta : IRosettaMetaData<Curve>
    {
        public IEnumerable<IValidator<Curve>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Curve>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Curve, ISet<string>> OnlyExistsValidator => new CurveOnlyExistsValidator();

        public IValidator<Curve> Validator => new CurveValidator();
    }
    
    /// <summary>
    /// MetaData definition for CustomisableOffset
    /// </summary>
    [RosettaMeta(typeof(CustomisableOffset))]
    public class CustomisableOffsetMeta : IRosettaMetaData<CustomisableOffset>
    {
        public IEnumerable<IValidator<CustomisableOffset>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CustomisableOffset>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CustomisableOffset, ISet<string>> OnlyExistsValidator => new CustomisableOffsetOnlyExistsValidator();

        public IValidator<CustomisableOffset> Validator => new CustomisableOffsetValidator();
    }
    
    /// <summary>
    /// MetaData definition for CustomisedWorkflow
    /// </summary>
    [RosettaMeta(typeof(CustomisedWorkflow))]
    public class CustomisedWorkflowMeta : IRosettaMetaData<CustomisedWorkflow>
    {
        public IEnumerable<IValidator<CustomisedWorkflow>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<CustomisedWorkflow>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<CustomisedWorkflow, ISet<string>> OnlyExistsValidator => new CustomisedWorkflowOnlyExistsValidator();

        public IValidator<CustomisedWorkflow> Validator => new CustomisedWorkflowValidator();
    }
    
    /// <summary>
    /// MetaData definition for DateList
    /// </summary>
    [RosettaMeta(typeof(DateList))]
    public class DateListMeta : IRosettaMetaData<DateList>
    {
        public IEnumerable<IValidator<DateList>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DateList>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DateList, ISet<string>> OnlyExistsValidator => new DateListOnlyExistsValidator();

        public IValidator<DateList> Validator => new DateListValidator();
    }
    
    /// <summary>
    /// MetaData definition for DateRange
    /// </summary>
    [RosettaMeta(typeof(DateRange))]
    public class DateRangeMeta : IRosettaMetaData<DateRange>
    {
        public IEnumerable<IValidator<DateRange>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DateRange>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DateRange, ISet<string>> OnlyExistsValidator => new DateRangeOnlyExistsValidator();

        public IValidator<DateRange> Validator => new DateRangeValidator();
    }
    
    /// <summary>
    /// MetaData definition for DateRelativeToCalculationPeriodDates
    /// </summary>
    [RosettaMeta(typeof(DateRelativeToCalculationPeriodDates))]
    public class DateRelativeToCalculationPeriodDatesMeta : IRosettaMetaData<DateRelativeToCalculationPeriodDates>
    {
        public IEnumerable<IValidator<DateRelativeToCalculationPeriodDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DateRelativeToCalculationPeriodDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DateRelativeToCalculationPeriodDates, ISet<string>> OnlyExistsValidator => new DateRelativeToCalculationPeriodDatesOnlyExistsValidator();

        public IValidator<DateRelativeToCalculationPeriodDates> Validator => new DateRelativeToCalculationPeriodDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for DateRelativeToPaymentDates
    /// </summary>
    [RosettaMeta(typeof(DateRelativeToPaymentDates))]
    public class DateRelativeToPaymentDatesMeta : IRosettaMetaData<DateRelativeToPaymentDates>
    {
        public IEnumerable<IValidator<DateRelativeToPaymentDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DateRelativeToPaymentDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DateRelativeToPaymentDates, ISet<string>> OnlyExistsValidator => new DateRelativeToPaymentDatesOnlyExistsValidator();

        public IValidator<DateRelativeToPaymentDates> Validator => new DateRelativeToPaymentDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for DateRelativeToValuationDates
    /// </summary>
    [RosettaMeta(typeof(DateRelativeToValuationDates))]
    public class DateRelativeToValuationDatesMeta : IRosettaMetaData<DateRelativeToValuationDates>
    {
        public IEnumerable<IValidator<DateRelativeToValuationDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DateRelativeToValuationDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DateRelativeToValuationDates, ISet<string>> OnlyExistsValidator => new DateRelativeToValuationDatesOnlyExistsValidator();

        public IValidator<DateRelativeToValuationDates> Validator => new DateRelativeToValuationDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for DateTimeList
    /// </summary>
    [RosettaMeta(typeof(DateTimeList))]
    public class DateTimeListMeta : IRosettaMetaData<DateTimeList>
    {
        public IEnumerable<IValidator<DateTimeList>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DateTimeList>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DateTimeList, ISet<string>> OnlyExistsValidator => new DateTimeListOnlyExistsValidator();

        public IValidator<DateTimeList> Validator => new DateTimeListValidator();
    }
    
    /// <summary>
    /// MetaData definition for DatedValue
    /// </summary>
    [RosettaMeta(typeof(DatedValue))]
    public class DatedValueMeta : IRosettaMetaData<DatedValue>
    {
        public IEnumerable<IValidator<DatedValue>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DatedValue>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DatedValue, ISet<string>> OnlyExistsValidator => new DatedValueOnlyExistsValidator();

        public IValidator<DatedValue> Validator => new DatedValueValidator();
    }
    
    /// <summary>
    /// MetaData definition for DebtEconomics
    /// </summary>
    [RosettaMeta(typeof(DebtEconomics))]
    public class DebtEconomicsMeta : IRosettaMetaData<DebtEconomics>
    {
        public IEnumerable<IValidator<DebtEconomics>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DebtEconomics>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DebtEconomics, ISet<string>> OnlyExistsValidator => new DebtEconomicsOnlyExistsValidator();

        public IValidator<DebtEconomics> Validator => new DebtEconomicsValidator();
    }
    
    /// <summary>
    /// MetaData definition for DebtType
    /// </summary>
    [RosettaMeta(typeof(DebtType))]
    public class DebtTypeMeta : IRosettaMetaData<DebtType>
    {
        public IEnumerable<IValidator<DebtType>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DebtType>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DebtType, ISet<string>> OnlyExistsValidator => new DebtTypeOnlyExistsValidator();

        public IValidator<DebtType> Validator => new DebtTypeValidator();
    }
    
    /// <summary>
    /// MetaData definition for DeliverableObligations
    /// </summary>
    [RosettaMeta(typeof(DeliverableObligations))]
    public class DeliverableObligationsMeta : IRosettaMetaData<DeliverableObligations>
    {
        public IEnumerable<IValidator<DeliverableObligations>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DeliverableObligations>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DeliverableObligations, ISet<string>> OnlyExistsValidator => new DeliverableObligationsOnlyExistsValidator();

        public IValidator<DeliverableObligations> Validator => new DeliverableObligationsValidator();
    }
    
    /// <summary>
    /// MetaData definition for DeliveryAmount
    /// </summary>
    [RosettaMeta(typeof(DeliveryAmount))]
    public class DeliveryAmountMeta : IRosettaMetaData<DeliveryAmount>
    {
        public IEnumerable<IValidator<DeliveryAmount>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DeliveryAmount>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DeliveryAmount, ISet<string>> OnlyExistsValidator => new DeliveryAmountOnlyExistsValidator();

        public IValidator<DeliveryAmount> Validator => new DeliveryAmountValidator();
    }
    
    /// <summary>
    /// MetaData definition for DeliveryDateParameters
    /// </summary>
    [RosettaMeta(typeof(DeliveryDateParameters))]
    public class DeliveryDateParametersMeta : IRosettaMetaData<DeliveryDateParameters>
    {
        public IEnumerable<IValidator<DeliveryDateParameters>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DeliveryDateParameters>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DeliveryDateParameters, ISet<string>> OnlyExistsValidator => new DeliveryDateParametersOnlyExistsValidator();

        public IValidator<DeliveryDateParameters> Validator => new DeliveryDateParametersValidator();
    }
    
    /// <summary>
    /// MetaData definition for DerivInstrmAttrbts
    /// </summary>
    [RosettaMeta(typeof(DerivInstrmAttrbts))]
    public class DerivInstrmAttrbtsMeta : IRosettaMetaData<DerivInstrmAttrbts>
    {
        public IEnumerable<IValidator<DerivInstrmAttrbts>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DerivInstrmAttrbts>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DerivInstrmAttrbts, ISet<string>> OnlyExistsValidator => new DerivInstrmAttrbtsOnlyExistsValidator();

        public IValidator<DerivInstrmAttrbts> Validator => new DerivInstrmAttrbtsValidator();
    }
    
    /// <summary>
    /// MetaData definition for DeterminationMethodology
    /// </summary>
    [RosettaMeta(typeof(DeterminationMethodology))]
    public class DeterminationMethodologyMeta : IRosettaMetaData<DeterminationMethodology>
    {
        public IEnumerable<IValidator<DeterminationMethodology>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DeterminationMethodology>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DeterminationMethodology, ISet<string>> OnlyExistsValidator => new DeterminationMethodologyOnlyExistsValidator();

        public IValidator<DeterminationMethodology> Validator => new DeterminationMethodologyValidator();
    }
    
    /// <summary>
    /// MetaData definition for DeterminationRolesAndTerms
    /// </summary>
    [RosettaMeta(typeof(DeterminationRolesAndTerms))]
    public class DeterminationRolesAndTermsMeta : IRosettaMetaData<DeterminationRolesAndTerms>
    {
        public IEnumerable<IValidator<DeterminationRolesAndTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DeterminationRolesAndTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DeterminationRolesAndTerms, ISet<string>> OnlyExistsValidator => new DeterminationRolesAndTermsOnlyExistsValidator();

        public IValidator<DeterminationRolesAndTerms> Validator => new DeterminationRolesAndTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for DigitalAsset
    /// </summary>
    [RosettaMeta(typeof(DigitalAsset))]
    public class DigitalAssetMeta : IRosettaMetaData<DigitalAsset>
    {
        public IEnumerable<IValidator<DigitalAsset>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DigitalAsset>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DigitalAsset, ISet<string>> OnlyExistsValidator => new DigitalAssetOnlyExistsValidator();

        public IValidator<DigitalAsset> Validator => new DigitalAssetValidator();
    }
    
    /// <summary>
    /// MetaData definition for DiscountingMethod
    /// </summary>
    [RosettaMeta(typeof(DiscountingMethod))]
    public class DiscountingMethodMeta : IRosettaMetaData<DiscountingMethod>
    {
        public IEnumerable<IValidator<DiscountingMethod>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DiscountingMethod>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DiscountingMethod, ISet<string>> OnlyExistsValidator => new DiscountingMethodOnlyExistsValidator();

        public IValidator<DiscountingMethod> Validator => new DiscountingMethodValidator();
    }
    
    /// <summary>
    /// MetaData definition for DistributionAndInterestPayment
    /// </summary>
    [RosettaMeta(typeof(DistributionAndInterestPayment))]
    public class DistributionAndInterestPaymentMeta : IRosettaMetaData<DistributionAndInterestPayment>
    {
        public IEnumerable<IValidator<DistributionAndInterestPayment>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DistributionAndInterestPayment>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DistributionAndInterestPayment, ISet<string>> OnlyExistsValidator => new DistributionAndInterestPaymentOnlyExistsValidator();

        public IValidator<DistributionAndInterestPayment> Validator => new DistributionAndInterestPaymentValidator();
    }
    
    /// <summary>
    /// MetaData definition for DividendApplicability
    /// </summary>
    [RosettaMeta(typeof(DividendApplicability))]
    public class DividendApplicabilityMeta : IRosettaMetaData<DividendApplicability>
    {
        public IEnumerable<IValidator<DividendApplicability>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DividendApplicability>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DividendApplicability, ISet<string>> OnlyExistsValidator => new DividendApplicabilityOnlyExistsValidator();

        public IValidator<DividendApplicability> Validator => new DividendApplicabilityValidator();
    }
    
    /// <summary>
    /// MetaData definition for DividendCurrency
    /// </summary>
    [RosettaMeta(typeof(DividendCurrency))]
    public class DividendCurrencyMeta : IRosettaMetaData<DividendCurrency>
    {
        public IEnumerable<IValidator<DividendCurrency>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DividendCurrency>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DividendCurrency, ISet<string>> OnlyExistsValidator => new DividendCurrencyOnlyExistsValidator();

        public IValidator<DividendCurrency> Validator => new DividendCurrencyValidator();
    }
    
    /// <summary>
    /// MetaData definition for DividendDateReference
    /// </summary>
    [RosettaMeta(typeof(DividendDateReference))]
    public class DividendDateReferenceMeta : IRosettaMetaData<DividendDateReference>
    {
        public IEnumerable<IValidator<DividendDateReference>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DividendDateReference>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DividendDateReference, ISet<string>> OnlyExistsValidator => new DividendDateReferenceOnlyExistsValidator();

        public IValidator<DividendDateReference> Validator => new DividendDateReferenceValidator();
    }
    
    /// <summary>
    /// MetaData definition for DividendPaymentDate
    /// </summary>
    [RosettaMeta(typeof(DividendPaymentDate))]
    public class DividendPaymentDateMeta : IRosettaMetaData<DividendPaymentDate>
    {
        public IEnumerable<IValidator<DividendPaymentDate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DividendPaymentDate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DividendPaymentDate, ISet<string>> OnlyExistsValidator => new DividendPaymentDateOnlyExistsValidator();

        public IValidator<DividendPaymentDate> Validator => new DividendPaymentDateValidator();
    }
    
    /// <summary>
    /// MetaData definition for DividendPayoutRatio
    /// </summary>
    [RosettaMeta(typeof(DividendPayoutRatio))]
    public class DividendPayoutRatioMeta : IRosettaMetaData<DividendPayoutRatio>
    {
        public IEnumerable<IValidator<DividendPayoutRatio>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DividendPayoutRatio>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DividendPayoutRatio, ISet<string>> OnlyExistsValidator => new DividendPayoutRatioOnlyExistsValidator();

        public IValidator<DividendPayoutRatio> Validator => new DividendPayoutRatioValidator();
    }
    
    /// <summary>
    /// MetaData definition for DividendPeriod
    /// </summary>
    [RosettaMeta(typeof(DividendPeriod))]
    public class DividendPeriodMeta : IRosettaMetaData<DividendPeriod>
    {
        public IEnumerable<IValidator<DividendPeriod>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DividendPeriod>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DividendPeriod, ISet<string>> OnlyExistsValidator => new DividendPeriodOnlyExistsValidator();

        public IValidator<DividendPeriod> Validator => new DividendPeriodValidator();
    }
    
    /// <summary>
    /// MetaData definition for DividendReturnTerms
    /// </summary>
    [RosettaMeta(typeof(DividendReturnTerms))]
    public class DividendReturnTermsMeta : IRosettaMetaData<DividendReturnTerms>
    {
        public IEnumerable<IValidator<DividendReturnTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DividendReturnTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DividendReturnTerms, ISet<string>> OnlyExistsValidator => new DividendReturnTermsOnlyExistsValidator();

        public IValidator<DividendReturnTerms> Validator => new DividendReturnTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for DividendTerms
    /// </summary>
    [RosettaMeta(typeof(DividendTerms))]
    public class DividendTermsMeta : IRosettaMetaData<DividendTerms>
    {
        public IEnumerable<IValidator<DividendTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DividendTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DividendTerms, ISet<string>> OnlyExistsValidator => new DividendTermsOnlyExistsValidator();

        public IValidator<DividendTerms> Validator => new DividendTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for Document
    /// </summary>
    [RosettaMeta(typeof(Document))]
    public class DocumentMeta : IRosettaMetaData<Document>
    {
        public IEnumerable<IValidator<Document>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Document>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Document, ISet<string>> OnlyExistsValidator => new DocumentOnlyExistsValidator();

        public IValidator<Document> Validator => new DocumentValidator();
    }
    
    /// <summary>
    /// MetaData definition for DomesticCurrencyIssued
    /// </summary>
    [RosettaMeta(typeof(DomesticCurrencyIssued))]
    public class DomesticCurrencyIssuedMeta : IRosettaMetaData<DomesticCurrencyIssued>
    {
        public IEnumerable<IValidator<DomesticCurrencyIssued>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<DomesticCurrencyIssued>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<DomesticCurrencyIssued, ISet<string>> OnlyExistsValidator => new DomesticCurrencyIssuedOnlyExistsValidator();

        public IValidator<DomesticCurrencyIssued> Validator => new DomesticCurrencyIssuedValidator();
    }
    
    /// <summary>
    /// MetaData definition for EarlyTerminationEvent
    /// </summary>
    [RosettaMeta(typeof(EarlyTerminationEvent))]
    public class EarlyTerminationEventMeta : IRosettaMetaData<EarlyTerminationEvent>
    {
        public IEnumerable<IValidator<EarlyTerminationEvent>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EarlyTerminationEvent>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EarlyTerminationEvent, ISet<string>> OnlyExistsValidator => new EarlyTerminationEventOnlyExistsValidator();

        public IValidator<EarlyTerminationEvent> Validator => new EarlyTerminationEventValidator();
    }
    
    /// <summary>
    /// MetaData definition for EarlyTerminationProvision
    /// </summary>
    [RosettaMeta(typeof(EarlyTerminationProvision))]
    public class EarlyTerminationProvisionMeta : IRosettaMetaData<EarlyTerminationProvision>
    {
        public IEnumerable<IValidator<EarlyTerminationProvision>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EarlyTerminationProvision>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EarlyTerminationProvision, ISet<string>> OnlyExistsValidator => new EarlyTerminationProvisionOnlyExistsValidator();

        public IValidator<EarlyTerminationProvision> Validator => new EarlyTerminationProvisionValidator();
    }
    
    /// <summary>
    /// MetaData definition for EconomicTerms
    /// </summary>
    [RosettaMeta(typeof(EconomicTerms))]
    public class EconomicTermsMeta : IRosettaMetaData<EconomicTerms>
    {
        public IEnumerable<IValidator<EconomicTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EconomicTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EconomicTerms, ISet<string>> OnlyExistsValidator => new EconomicTermsOnlyExistsValidator();

        public IValidator<EconomicTerms> Validator => new EconomicTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for EligibilityQuery
    /// </summary>
    [RosettaMeta(typeof(EligibilityQuery))]
    public class EligibilityQueryMeta : IRosettaMetaData<EligibilityQuery>
    {
        public IEnumerable<IValidator<EligibilityQuery>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EligibilityQuery>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EligibilityQuery, ISet<string>> OnlyExistsValidator => new EligibilityQueryOnlyExistsValidator();

        public IValidator<EligibilityQuery> Validator => new EligibilityQueryValidator();
    }
    
    /// <summary>
    /// MetaData definition for EligibleCollateralCriteria
    /// </summary>
    [RosettaMeta(typeof(EligibleCollateralCriteria))]
    public class EligibleCollateralCriteriaMeta : IRosettaMetaData<EligibleCollateralCriteria>
    {
        public IEnumerable<IValidator<EligibleCollateralCriteria>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EligibleCollateralCriteria>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EligibleCollateralCriteria, ISet<string>> OnlyExistsValidator => new EligibleCollateralCriteriaOnlyExistsValidator();

        public IValidator<EligibleCollateralCriteria> Validator => new EligibleCollateralCriteriaValidator();
    }
    
    /// <summary>
    /// MetaData definition for EligibleCollateralSpecification
    /// </summary>
    [RosettaMeta(typeof(EligibleCollateralSpecification))]
    public class EligibleCollateralSpecificationMeta : IRosettaMetaData<EligibleCollateralSpecification>
    {
        public IEnumerable<IValidator<EligibleCollateralSpecification>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EligibleCollateralSpecification>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EligibleCollateralSpecification, ISet<string>> OnlyExistsValidator => new EligibleCollateralSpecificationOnlyExistsValidator();

        public IValidator<EligibleCollateralSpecification> Validator => new EligibleCollateralSpecificationValidator();
    }
    
    /// <summary>
    /// MetaData definition for EligibleCollateralSpecificationInstruction
    /// </summary>
    [RosettaMeta(typeof(EligibleCollateralSpecificationInstruction))]
    public class EligibleCollateralSpecificationInstructionMeta : IRosettaMetaData<EligibleCollateralSpecificationInstruction>
    {
        public IEnumerable<IValidator<EligibleCollateralSpecificationInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EligibleCollateralSpecificationInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EligibleCollateralSpecificationInstruction, ISet<string>> OnlyExistsValidator => new EligibleCollateralSpecificationInstructionOnlyExistsValidator();

        public IValidator<EligibleCollateralSpecificationInstruction> Validator => new EligibleCollateralSpecificationInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for EquityAdditionalTerms
    /// </summary>
    [RosettaMeta(typeof(EquityAdditionalTerms))]
    public class EquityAdditionalTermsMeta : IRosettaMetaData<EquityAdditionalTerms>
    {
        public IEnumerable<IValidator<EquityAdditionalTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EquityAdditionalTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EquityAdditionalTerms, ISet<string>> OnlyExistsValidator => new EquityAdditionalTermsOnlyExistsValidator();

        public IValidator<EquityAdditionalTerms> Validator => new EquityAdditionalTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for EquityCorporateEvents
    /// </summary>
    [RosettaMeta(typeof(EquityCorporateEvents))]
    public class EquityCorporateEventsMeta : IRosettaMetaData<EquityCorporateEvents>
    {
        public IEnumerable<IValidator<EquityCorporateEvents>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EquityCorporateEvents>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EquityCorporateEvents, ISet<string>> OnlyExistsValidator => new EquityCorporateEventsOnlyExistsValidator();

        public IValidator<EquityCorporateEvents> Validator => new EquityCorporateEventsValidator();
    }
    
    /// <summary>
    /// MetaData definition for EquityIndex
    /// </summary>
    [RosettaMeta(typeof(EquityIndex))]
    public class EquityIndexMeta : IRosettaMetaData<EquityIndex>
    {
        public IEnumerable<IValidator<EquityIndex>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EquityIndex>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EquityIndex, ISet<string>> OnlyExistsValidator => new EquityIndexOnlyExistsValidator();

        public IValidator<EquityIndex> Validator => new EquityIndexValidator();
    }
    
    /// <summary>
    /// MetaData definition for EquityMasterConfirmation
    /// </summary>
    [RosettaMeta(typeof(EquityMasterConfirmation))]
    public class EquityMasterConfirmationMeta : IRosettaMetaData<EquityMasterConfirmation>
    {
        public IEnumerable<IValidator<EquityMasterConfirmation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EquityMasterConfirmation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EquityMasterConfirmation, ISet<string>> OnlyExistsValidator => new EquityMasterConfirmationOnlyExistsValidator();

        public IValidator<EquityMasterConfirmation> Validator => new EquityMasterConfirmationValidator();
    }
    
    /// <summary>
    /// MetaData definition for EquitySwapMasterConfirmation2018
    /// </summary>
    [RosettaMeta(typeof(EquitySwapMasterConfirmation2018))]
    public class EquitySwapMasterConfirmation2018Meta : IRosettaMetaData<EquitySwapMasterConfirmation2018>
    {
        public IEnumerable<IValidator<EquitySwapMasterConfirmation2018>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EquitySwapMasterConfirmation2018>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EquitySwapMasterConfirmation2018, ISet<string>> OnlyExistsValidator => new EquitySwapMasterConfirmation2018OnlyExistsValidator();

        public IValidator<EquitySwapMasterConfirmation2018> Validator => new EquitySwapMasterConfirmation2018Validator();
    }
    
    /// <summary>
    /// MetaData definition for EquityUnderlierProvisions
    /// </summary>
    [RosettaMeta(typeof(EquityUnderlierProvisions))]
    public class EquityUnderlierProvisionsMeta : IRosettaMetaData<EquityUnderlierProvisions>
    {
        public IEnumerable<IValidator<EquityUnderlierProvisions>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EquityUnderlierProvisions>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EquityUnderlierProvisions, ISet<string>> OnlyExistsValidator => new EquityUnderlierProvisionsOnlyExistsValidator();

        public IValidator<EquityUnderlierProvisions> Validator => new EquityUnderlierProvisionsValidator();
    }
    
    /// <summary>
    /// MetaData definition for EventInstruction
    /// </summary>
    [RosettaMeta(typeof(EventInstruction))]
    public class EventInstructionMeta : IRosettaMetaData<EventInstruction>
    {
        public IEnumerable<IValidator<EventInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EventInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EventInstruction, ISet<string>> OnlyExistsValidator => new EventInstructionOnlyExistsValidator();

        public IValidator<EventInstruction> Validator => new EventInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for EventTimestamp
    /// </summary>
    [RosettaMeta(typeof(EventTimestamp))]
    public class EventTimestampMeta : IRosettaMetaData<EventTimestamp>
    {
        public IEnumerable<IValidator<EventTimestamp>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EventTimestamp>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EventTimestamp, ISet<string>> OnlyExistsValidator => new EventTimestampOnlyExistsValidator();

        public IValidator<EventTimestamp> Validator => new EventTimestampValidator();
    }
    
    /// <summary>
    /// MetaData definition for EvergreenProvision
    /// </summary>
    [RosettaMeta(typeof(EvergreenProvision))]
    public class EvergreenProvisionMeta : IRosettaMetaData<EvergreenProvision>
    {
        public IEnumerable<IValidator<EvergreenProvision>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<EvergreenProvision>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<EvergreenProvision, ISet<string>> OnlyExistsValidator => new EvergreenProvisionOnlyExistsValidator();

        public IValidator<EvergreenProvision> Validator => new EvergreenProvisionValidator();
    }
    
    /// <summary>
    /// MetaData definition for ExctgPrsn
    /// </summary>
    [RosettaMeta(typeof(ExctgPrsn))]
    public class ExctgPrsnMeta : IRosettaMetaData<ExctgPrsn>
    {
        public IEnumerable<IValidator<ExctgPrsn>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ExctgPrsn>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ExctgPrsn, ISet<string>> OnlyExistsValidator => new ExctgPrsnOnlyExistsValidator();

        public IValidator<ExctgPrsn> Validator => new ExctgPrsnValidator();
    }
    
    /// <summary>
    /// MetaData definition for ExecutionDetails
    /// </summary>
    [RosettaMeta(typeof(ExecutionDetails))]
    public class ExecutionDetailsMeta : IRosettaMetaData<ExecutionDetails>
    {
        public IEnumerable<IValidator<ExecutionDetails>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ExecutionDetails>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ExecutionDetails, ISet<string>> OnlyExistsValidator => new ExecutionDetailsOnlyExistsValidator();

        public IValidator<ExecutionDetails> Validator => new ExecutionDetailsValidator();
    }
    
    /// <summary>
    /// MetaData definition for ExecutionInstruction
    /// </summary>
    [RosettaMeta(typeof(ExecutionInstruction))]
    public class ExecutionInstructionMeta : IRosettaMetaData<ExecutionInstruction>
    {
        public IEnumerable<IValidator<ExecutionInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ExecutionInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ExecutionInstruction, ISet<string>> OnlyExistsValidator => new ExecutionInstructionOnlyExistsValidator();

        public IValidator<ExecutionInstruction> Validator => new ExecutionInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for ExerciseEvent
    /// </summary>
    [RosettaMeta(typeof(ExerciseEvent))]
    public class ExerciseEventMeta : IRosettaMetaData<ExerciseEvent>
    {
        public IEnumerable<IValidator<ExerciseEvent>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ExerciseEvent>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ExerciseEvent, ISet<string>> OnlyExistsValidator => new ExerciseEventOnlyExistsValidator();

        public IValidator<ExerciseEvent> Validator => new ExerciseEventValidator();
    }
    
    /// <summary>
    /// MetaData definition for ExerciseFee
    /// </summary>
    [RosettaMeta(typeof(ExerciseFee))]
    public class ExerciseFeeMeta : IRosettaMetaData<ExerciseFee>
    {
        public IEnumerable<IValidator<ExerciseFee>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ExerciseFee>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ExerciseFee, ISet<string>> OnlyExistsValidator => new ExerciseFeeOnlyExistsValidator();

        public IValidator<ExerciseFee> Validator => new ExerciseFeeValidator();
    }
    
    /// <summary>
    /// MetaData definition for ExerciseFeeSchedule
    /// </summary>
    [RosettaMeta(typeof(ExerciseFeeSchedule))]
    public class ExerciseFeeScheduleMeta : IRosettaMetaData<ExerciseFeeSchedule>
    {
        public IEnumerable<IValidator<ExerciseFeeSchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ExerciseFeeSchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ExerciseFeeSchedule, ISet<string>> OnlyExistsValidator => new ExerciseFeeScheduleOnlyExistsValidator();

        public IValidator<ExerciseFeeSchedule> Validator => new ExerciseFeeScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for ExerciseInstruction
    /// </summary>
    [RosettaMeta(typeof(ExerciseInstruction))]
    public class ExerciseInstructionMeta : IRosettaMetaData<ExerciseInstruction>
    {
        public IEnumerable<IValidator<ExerciseInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ExerciseInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ExerciseInstruction, ISet<string>> OnlyExistsValidator => new ExerciseInstructionOnlyExistsValidator();

        public IValidator<ExerciseInstruction> Validator => new ExerciseInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for ExerciseNotice
    /// </summary>
    [RosettaMeta(typeof(ExerciseNotice))]
    public class ExerciseNoticeMeta : IRosettaMetaData<ExerciseNotice>
    {
        public IEnumerable<IValidator<ExerciseNotice>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ExerciseNotice>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ExerciseNotice, ISet<string>> OnlyExistsValidator => new ExerciseNoticeOnlyExistsValidator();

        public IValidator<ExerciseNotice> Validator => new ExerciseNoticeValidator();
    }
    
    /// <summary>
    /// MetaData definition for ExercisePeriod
    /// </summary>
    [RosettaMeta(typeof(ExercisePeriod))]
    public class ExercisePeriodMeta : IRosettaMetaData<ExercisePeriod>
    {
        public IEnumerable<IValidator<ExercisePeriod>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ExercisePeriod>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ExercisePeriod, ISet<string>> OnlyExistsValidator => new ExercisePeriodOnlyExistsValidator();

        public IValidator<ExercisePeriod> Validator => new ExercisePeriodValidator();
    }
    
    /// <summary>
    /// MetaData definition for ExerciseProcedure
    /// </summary>
    [RosettaMeta(typeof(ExerciseProcedure))]
    public class ExerciseProcedureMeta : IRosettaMetaData<ExerciseProcedure>
    {
        public IEnumerable<IValidator<ExerciseProcedure>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ExerciseProcedure>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ExerciseProcedure, ISet<string>> OnlyExistsValidator => new ExerciseProcedureOnlyExistsValidator();

        public IValidator<ExerciseProcedure> Validator => new ExerciseProcedureValidator();
    }
    
    /// <summary>
    /// MetaData definition for ExerciseTerms
    /// </summary>
    [RosettaMeta(typeof(ExerciseTerms))]
    public class ExerciseTermsMeta : IRosettaMetaData<ExerciseTerms>
    {
        public IEnumerable<IValidator<ExerciseTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ExerciseTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ExerciseTerms, ISet<string>> OnlyExistsValidator => new ExerciseTermsOnlyExistsValidator();

        public IValidator<ExerciseTerms> Validator => new ExerciseTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for Exposure
    /// </summary>
    [RosettaMeta(typeof(Exposure))]
    public class ExposureMeta : IRosettaMetaData<Exposure>
    {
        public IEnumerable<IValidator<Exposure>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Exposure>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Exposure, ISet<string>> OnlyExistsValidator => new ExposureOnlyExistsValidator();

        public IValidator<Exposure> Validator => new ExposureValidator();
    }
    
    /// <summary>
    /// MetaData definition for ExtendibleProvision
    /// </summary>
    [RosettaMeta(typeof(ExtendibleProvision))]
    public class ExtendibleProvisionMeta : IRosettaMetaData<ExtendibleProvision>
    {
        public IEnumerable<IValidator<ExtendibleProvision>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ExtendibleProvision>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ExtendibleProvision, ISet<string>> OnlyExistsValidator => new ExtendibleProvisionOnlyExistsValidator();

        public IValidator<ExtendibleProvision> Validator => new ExtendibleProvisionValidator();
    }
    
    /// <summary>
    /// MetaData definition for ExtendibleProvisionAdjustedDates
    /// </summary>
    [RosettaMeta(typeof(ExtendibleProvisionAdjustedDates))]
    public class ExtendibleProvisionAdjustedDatesMeta : IRosettaMetaData<ExtendibleProvisionAdjustedDates>
    {
        public IEnumerable<IValidator<ExtendibleProvisionAdjustedDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ExtendibleProvisionAdjustedDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ExtendibleProvisionAdjustedDates, ISet<string>> OnlyExistsValidator => new ExtendibleProvisionAdjustedDatesOnlyExistsValidator();

        public IValidator<ExtendibleProvisionAdjustedDates> Validator => new ExtendibleProvisionAdjustedDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for ExtensionEvent
    /// </summary>
    [RosettaMeta(typeof(ExtensionEvent))]
    public class ExtensionEventMeta : IRosettaMetaData<ExtensionEvent>
    {
        public IEnumerable<IValidator<ExtensionEvent>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ExtensionEvent>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ExtensionEvent, ISet<string>> OnlyExistsValidator => new ExtensionEventOnlyExistsValidator();

        public IValidator<ExtensionEvent> Validator => new ExtensionEventValidator();
    }
    
    /// <summary>
    /// MetaData definition for ExtraordinaryEvents
    /// </summary>
    [RosettaMeta(typeof(ExtraordinaryEvents))]
    public class ExtraordinaryEventsMeta : IRosettaMetaData<ExtraordinaryEvents>
    {
        public IEnumerable<IValidator<ExtraordinaryEvents>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ExtraordinaryEvents>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ExtraordinaryEvents, ISet<string>> OnlyExistsValidator => new ExtraordinaryEventsOnlyExistsValidator();

        public IValidator<ExtraordinaryEvents> Validator => new ExtraordinaryEventsValidator();
    }
    
    /// <summary>
    /// MetaData definition for FailureToPay
    /// </summary>
    [RosettaMeta(typeof(FailureToPay))]
    public class FailureToPayMeta : IRosettaMetaData<FailureToPay>
    {
        public IEnumerable<IValidator<FailureToPay>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FailureToPay>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FailureToPay, ISet<string>> OnlyExistsValidator => new FailureToPayOnlyExistsValidator();

        public IValidator<FailureToPay> Validator => new FailureToPayValidator();
    }
    
    /// <summary>
    /// MetaData definition for FallbackRateParameters
    /// </summary>
    [RosettaMeta(typeof(FallbackRateParameters))]
    public class FallbackRateParametersMeta : IRosettaMetaData<FallbackRateParameters>
    {
        public IEnumerable<IValidator<FallbackRateParameters>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FallbackRateParameters>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FallbackRateParameters, ISet<string>> OnlyExistsValidator => new FallbackRateParametersOnlyExistsValidator();

        public IValidator<FallbackRateParameters> Validator => new FallbackRateParametersValidator();
    }
    
    /// <summary>
    /// MetaData definition for FallbackReferencePrice
    /// </summary>
    [RosettaMeta(typeof(FallbackReferencePrice))]
    public class FallbackReferencePriceMeta : IRosettaMetaData<FallbackReferencePrice>
    {
        public IEnumerable<IValidator<FallbackReferencePrice>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FallbackReferencePrice>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FallbackReferencePrice, ISet<string>> OnlyExistsValidator => new FallbackReferencePriceOnlyExistsValidator();

        public IValidator<FallbackReferencePrice> Validator => new FallbackReferencePriceValidator();
    }
    
    /// <summary>
    /// MetaData definition for FeaturePayment
    /// </summary>
    [RosettaMeta(typeof(FeaturePayment))]
    public class FeaturePaymentMeta : IRosettaMetaData<FeaturePayment>
    {
        public IEnumerable<IValidator<FeaturePayment>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FeaturePayment>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FeaturePayment, ISet<string>> OnlyExistsValidator => new FeaturePaymentOnlyExistsValidator();

        public IValidator<FeaturePayment> Validator => new FeaturePaymentValidator();
    }
    
    /// <summary>
    /// MetaData definition for FinInstrm
    /// </summary>
    [RosettaMeta(typeof(FinInstrm))]
    public class FinInstrmMeta : IRosettaMetaData<FinInstrm>
    {
        public IEnumerable<IValidator<FinInstrm>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FinInstrm>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FinInstrm, ISet<string>> OnlyExistsValidator => new FinInstrmOnlyExistsValidator();

        public IValidator<FinInstrm> Validator => new FinInstrmValidator();
    }
    
    /// <summary>
    /// MetaData definition for FinInstrmGnlAttrbts
    /// </summary>
    [RosettaMeta(typeof(FinInstrmGnlAttrbts))]
    public class FinInstrmGnlAttrbtsMeta : IRosettaMetaData<FinInstrmGnlAttrbts>
    {
        public IEnumerable<IValidator<FinInstrmGnlAttrbts>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FinInstrmGnlAttrbts>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FinInstrmGnlAttrbts, ISet<string>> OnlyExistsValidator => new FinInstrmGnlAttrbtsOnlyExistsValidator();

        public IValidator<FinInstrmGnlAttrbts> Validator => new FinInstrmGnlAttrbtsValidator();
    }
    
    /// <summary>
    /// MetaData definition for FinInstrmRptgTxRpt
    /// </summary>
    [RosettaMeta(typeof(FinInstrmRptgTxRpt))]
    public class FinInstrmRptgTxRptMeta : IRosettaMetaData<FinInstrmRptgTxRpt>
    {
        public IEnumerable<IValidator<FinInstrmRptgTxRpt>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FinInstrmRptgTxRpt>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FinInstrmRptgTxRpt, ISet<string>> OnlyExistsValidator => new FinInstrmRptgTxRptOnlyExistsValidator();

        public IValidator<FinInstrmRptgTxRpt> Validator => new FinInstrmRptgTxRptValidator();
    }
    
    /// <summary>
    /// MetaData definition for FinalCalculationPeriodDateAdjustment
    /// </summary>
    [RosettaMeta(typeof(FinalCalculationPeriodDateAdjustment))]
    public class FinalCalculationPeriodDateAdjustmentMeta : IRosettaMetaData<FinalCalculationPeriodDateAdjustment>
    {
        public IEnumerable<IValidator<FinalCalculationPeriodDateAdjustment>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FinalCalculationPeriodDateAdjustment>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FinalCalculationPeriodDateAdjustment, ISet<string>> OnlyExistsValidator => new FinalCalculationPeriodDateAdjustmentOnlyExistsValidator();

        public IValidator<FinalCalculationPeriodDateAdjustment> Validator => new FinalCalculationPeriodDateAdjustmentValidator();
    }
    
    /// <summary>
    /// MetaData definition for FixedAmountCalculationDetails
    /// </summary>
    [RosettaMeta(typeof(FixedAmountCalculationDetails))]
    public class FixedAmountCalculationDetailsMeta : IRosettaMetaData<FixedAmountCalculationDetails>
    {
        public IEnumerable<IValidator<FixedAmountCalculationDetails>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FixedAmountCalculationDetails>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FixedAmountCalculationDetails, ISet<string>> OnlyExistsValidator => new FixedAmountCalculationDetailsOnlyExistsValidator();

        public IValidator<FixedAmountCalculationDetails> Validator => new FixedAmountCalculationDetailsValidator();
    }
    
    /// <summary>
    /// MetaData definition for FixedPrice
    /// </summary>
    [RosettaMeta(typeof(FixedPrice))]
    public class FixedPriceMeta : IRosettaMetaData<FixedPrice>
    {
        public IEnumerable<IValidator<FixedPrice>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FixedPrice>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FixedPrice, ISet<string>> OnlyExistsValidator => new FixedPriceOnlyExistsValidator();

        public IValidator<FixedPrice> Validator => new FixedPriceValidator();
    }
    
    /// <summary>
    /// MetaData definition for FixedPricePayout
    /// </summary>
    [RosettaMeta(typeof(FixedPricePayout))]
    public class FixedPricePayoutMeta : IRosettaMetaData<FixedPricePayout>
    {
        public IEnumerable<IValidator<FixedPricePayout>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FixedPricePayout>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FixedPricePayout, ISet<string>> OnlyExistsValidator => new FixedPricePayoutOnlyExistsValidator();

        public IValidator<FixedPricePayout> Validator => new FixedPricePayoutValidator();
    }
    
    /// <summary>
    /// MetaData definition for FixedRateSpecification
    /// </summary>
    [RosettaMeta(typeof(FixedRateSpecification))]
    public class FixedRateSpecificationMeta : IRosettaMetaData<FixedRateSpecification>
    {
        public IEnumerable<IValidator<FixedRateSpecification>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FixedRateSpecification>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FixedRateSpecification, ISet<string>> OnlyExistsValidator => new FixedRateSpecificationOnlyExistsValidator();

        public IValidator<FixedRateSpecification> Validator => new FixedRateSpecificationValidator();
    }
    
    /// <summary>
    /// MetaData definition for FloatingAmountCalculationDetails
    /// </summary>
    [RosettaMeta(typeof(FloatingAmountCalculationDetails))]
    public class FloatingAmountCalculationDetailsMeta : IRosettaMetaData<FloatingAmountCalculationDetails>
    {
        public IEnumerable<IValidator<FloatingAmountCalculationDetails>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FloatingAmountCalculationDetails>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FloatingAmountCalculationDetails, ISet<string>> OnlyExistsValidator => new FloatingAmountCalculationDetailsOnlyExistsValidator();

        public IValidator<FloatingAmountCalculationDetails> Validator => new FloatingAmountCalculationDetailsValidator();
    }
    
    /// <summary>
    /// MetaData definition for FloatingAmountEvents
    /// </summary>
    [RosettaMeta(typeof(FloatingAmountEvents))]
    public class FloatingAmountEventsMeta : IRosettaMetaData<FloatingAmountEvents>
    {
        public IEnumerable<IValidator<FloatingAmountEvents>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FloatingAmountEvents>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FloatingAmountEvents, ISet<string>> OnlyExistsValidator => new FloatingAmountEventsOnlyExistsValidator();

        public IValidator<FloatingAmountEvents> Validator => new FloatingAmountEventsValidator();
    }
    
    /// <summary>
    /// MetaData definition for FloatingAmountProvisions
    /// </summary>
    [RosettaMeta(typeof(FloatingAmountProvisions))]
    public class FloatingAmountProvisionsMeta : IRosettaMetaData<FloatingAmountProvisions>
    {
        public IEnumerable<IValidator<FloatingAmountProvisions>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FloatingAmountProvisions>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FloatingAmountProvisions, ISet<string>> OnlyExistsValidator => new FloatingAmountProvisionsOnlyExistsValidator();

        public IValidator<FloatingAmountProvisions> Validator => new FloatingAmountProvisionsValidator();
    }
    
    /// <summary>
    /// MetaData definition for FloatingRate
    /// </summary>
    [RosettaMeta(typeof(FloatingRate))]
    public class FloatingRateMeta : IRosettaMetaData<FloatingRate>
    {
        public IEnumerable<IValidator<FloatingRate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FloatingRate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FloatingRate, ISet<string>> OnlyExistsValidator => new FloatingRateOnlyExistsValidator();

        public IValidator<FloatingRate> Validator => new FloatingRateValidator();
    }
    
    /// <summary>
    /// MetaData definition for FloatingRateBase
    /// </summary>
    [RosettaMeta(typeof(FloatingRateBase))]
    public class FloatingRateBaseMeta : IRosettaMetaData<FloatingRateBase>
    {
        public IEnumerable<IValidator<FloatingRateBase>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FloatingRateBase>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FloatingRateBase, ISet<string>> OnlyExistsValidator => new FloatingRateBaseOnlyExistsValidator();

        public IValidator<FloatingRateBase> Validator => new FloatingRateBaseValidator();
    }
    
    /// <summary>
    /// MetaData definition for FloatingRateCalculationParameters
    /// </summary>
    [RosettaMeta(typeof(FloatingRateCalculationParameters))]
    public class FloatingRateCalculationParametersMeta : IRosettaMetaData<FloatingRateCalculationParameters>
    {
        public IEnumerable<IValidator<FloatingRateCalculationParameters>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FloatingRateCalculationParameters>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FloatingRateCalculationParameters, ISet<string>> OnlyExistsValidator => new FloatingRateCalculationParametersOnlyExistsValidator();

        public IValidator<FloatingRateCalculationParameters> Validator => new FloatingRateCalculationParametersValidator();
    }
    
    /// <summary>
    /// MetaData definition for FloatingRateDefinition
    /// </summary>
    [RosettaMeta(typeof(FloatingRateDefinition))]
    public class FloatingRateDefinitionMeta : IRosettaMetaData<FloatingRateDefinition>
    {
        public IEnumerable<IValidator<FloatingRateDefinition>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FloatingRateDefinition>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FloatingRateDefinition, ISet<string>> OnlyExistsValidator => new FloatingRateDefinitionOnlyExistsValidator();

        public IValidator<FloatingRateDefinition> Validator => new FloatingRateDefinitionValidator();
    }
    
    /// <summary>
    /// MetaData definition for FloatingRateIndex
    /// </summary>
    [RosettaMeta(typeof(FloatingRateIndex))]
    public class FloatingRateIndexMeta : IRosettaMetaData<FloatingRateIndex>
    {
        public IEnumerable<IValidator<FloatingRateIndex>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FloatingRateIndex>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FloatingRateIndex, ISet<string>> OnlyExistsValidator => new FloatingRateIndexOnlyExistsValidator();

        public IValidator<FloatingRateIndex> Validator => new FloatingRateIndexValidator();
    }
    
    /// <summary>
    /// MetaData definition for FloatingRateIndexCalculationDefaults
    /// </summary>
    [RosettaMeta(typeof(FloatingRateIndexCalculationDefaults))]
    public class FloatingRateIndexCalculationDefaultsMeta : IRosettaMetaData<FloatingRateIndexCalculationDefaults>
    {
        public IEnumerable<IValidator<FloatingRateIndexCalculationDefaults>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FloatingRateIndexCalculationDefaults>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FloatingRateIndexCalculationDefaults, ISet<string>> OnlyExistsValidator => new FloatingRateIndexCalculationDefaultsOnlyExistsValidator();

        public IValidator<FloatingRateIndexCalculationDefaults> Validator => new FloatingRateIndexCalculationDefaultsValidator();
    }
    
    /// <summary>
    /// MetaData definition for FloatingRateIndexDefinition
    /// </summary>
    [RosettaMeta(typeof(FloatingRateIndexDefinition))]
    public class FloatingRateIndexDefinitionMeta : IRosettaMetaData<FloatingRateIndexDefinition>
    {
        public IEnumerable<IValidator<FloatingRateIndexDefinition>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FloatingRateIndexDefinition>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FloatingRateIndexDefinition, ISet<string>> OnlyExistsValidator => new FloatingRateIndexDefinitionOnlyExistsValidator();

        public IValidator<FloatingRateIndexDefinition> Validator => new FloatingRateIndexDefinitionValidator();
    }
    
    /// <summary>
    /// MetaData definition for FloatingRateIndexIdentification
    /// </summary>
    [RosettaMeta(typeof(FloatingRateIndexIdentification))]
    public class FloatingRateIndexIdentificationMeta : IRosettaMetaData<FloatingRateIndexIdentification>
    {
        public IEnumerable<IValidator<FloatingRateIndexIdentification>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FloatingRateIndexIdentification>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FloatingRateIndexIdentification, ISet<string>> OnlyExistsValidator => new FloatingRateIndexIdentificationOnlyExistsValidator();

        public IValidator<FloatingRateIndexIdentification> Validator => new FloatingRateIndexIdentificationValidator();
    }
    
    /// <summary>
    /// MetaData definition for FloatingRateProcessingDetails
    /// </summary>
    [RosettaMeta(typeof(FloatingRateProcessingDetails))]
    public class FloatingRateProcessingDetailsMeta : IRosettaMetaData<FloatingRateProcessingDetails>
    {
        public IEnumerable<IValidator<FloatingRateProcessingDetails>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FloatingRateProcessingDetails>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FloatingRateProcessingDetails, ISet<string>> OnlyExistsValidator => new FloatingRateProcessingDetailsOnlyExistsValidator();

        public IValidator<FloatingRateProcessingDetails> Validator => new FloatingRateProcessingDetailsValidator();
    }
    
    /// <summary>
    /// MetaData definition for FloatingRateProcessingParameters
    /// </summary>
    [RosettaMeta(typeof(FloatingRateProcessingParameters))]
    public class FloatingRateProcessingParametersMeta : IRosettaMetaData<FloatingRateProcessingParameters>
    {
        public IEnumerable<IValidator<FloatingRateProcessingParameters>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FloatingRateProcessingParameters>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FloatingRateProcessingParameters, ISet<string>> OnlyExistsValidator => new FloatingRateProcessingParametersOnlyExistsValidator();

        public IValidator<FloatingRateProcessingParameters> Validator => new FloatingRateProcessingParametersValidator();
    }
    
    /// <summary>
    /// MetaData definition for FloatingRateSettingDetails
    /// </summary>
    [RosettaMeta(typeof(FloatingRateSettingDetails))]
    public class FloatingRateSettingDetailsMeta : IRosettaMetaData<FloatingRateSettingDetails>
    {
        public IEnumerable<IValidator<FloatingRateSettingDetails>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FloatingRateSettingDetails>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FloatingRateSettingDetails, ISet<string>> OnlyExistsValidator => new FloatingRateSettingDetailsOnlyExistsValidator();

        public IValidator<FloatingRateSettingDetails> Validator => new FloatingRateSettingDetailsValidator();
    }
    
    /// <summary>
    /// MetaData definition for FloatingRateSpecification
    /// </summary>
    [RosettaMeta(typeof(FloatingRateSpecification))]
    public class FloatingRateSpecificationMeta : IRosettaMetaData<FloatingRateSpecification>
    {
        public IEnumerable<IValidator<FloatingRateSpecification>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FloatingRateSpecification>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FloatingRateSpecification, ISet<string>> OnlyExistsValidator => new FloatingRateSpecificationOnlyExistsValidator();

        public IValidator<FloatingRateSpecification> Validator => new FloatingRateSpecificationValidator();
    }
    
    /// <summary>
    /// MetaData definition for ForeignExchange
    /// </summary>
    [RosettaMeta(typeof(ForeignExchange))]
    public class ForeignExchangeMeta : IRosettaMetaData<ForeignExchange>
    {
        public IEnumerable<IValidator<ForeignExchange>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ForeignExchange>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ForeignExchange, ISet<string>> OnlyExistsValidator => new ForeignExchangeOnlyExistsValidator();

        public IValidator<ForeignExchange> Validator => new ForeignExchangeValidator();
    }
    
    /// <summary>
    /// MetaData definition for ForeignExchangeRateIndex
    /// </summary>
    [RosettaMeta(typeof(ForeignExchangeRateIndex))]
    public class ForeignExchangeRateIndexMeta : IRosettaMetaData<ForeignExchangeRateIndex>
    {
        public IEnumerable<IValidator<ForeignExchangeRateIndex>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ForeignExchangeRateIndex>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ForeignExchangeRateIndex, ISet<string>> OnlyExistsValidator => new ForeignExchangeRateIndexOnlyExistsValidator();

        public IValidator<ForeignExchangeRateIndex> Validator => new ForeignExchangeRateIndexValidator();
    }
    
    /// <summary>
    /// MetaData definition for Frequency
    /// </summary>
    [RosettaMeta(typeof(Frequency))]
    public class FrequencyMeta : IRosettaMetaData<Frequency>
    {
        public IEnumerable<IValidator<Frequency>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Frequency>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Frequency, ISet<string>> OnlyExistsValidator => new FrequencyOnlyExistsValidator();

        public IValidator<Frequency> Validator => new FrequencyValidator();
    }
    
    /// <summary>
    /// MetaData definition for FutureValueAmount
    /// </summary>
    [RosettaMeta(typeof(FutureValueAmount))]
    public class FutureValueAmountMeta : IRosettaMetaData<FutureValueAmount>
    {
        public IEnumerable<IValidator<FutureValueAmount>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FutureValueAmount>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FutureValueAmount, ISet<string>> OnlyExistsValidator => new FutureValueAmountOnlyExistsValidator();

        public IValidator<FutureValueAmount> Validator => new FutureValueAmountValidator();
    }
    
    /// <summary>
    /// MetaData definition for FxAdditionalTerms
    /// </summary>
    [RosettaMeta(typeof(FxAdditionalTerms))]
    public class FxAdditionalTermsMeta : IRosettaMetaData<FxAdditionalTerms>
    {
        public IEnumerable<IValidator<FxAdditionalTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FxAdditionalTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FxAdditionalTerms, ISet<string>> OnlyExistsValidator => new FxAdditionalTermsOnlyExistsValidator();

        public IValidator<FxAdditionalTerms> Validator => new FxAdditionalTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for FxFeature
    /// </summary>
    [RosettaMeta(typeof(FxFeature))]
    public class FxFeatureMeta : IRosettaMetaData<FxFeature>
    {
        public IEnumerable<IValidator<FxFeature>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FxFeature>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FxFeature, ISet<string>> OnlyExistsValidator => new FxFeatureOnlyExistsValidator();

        public IValidator<FxFeature> Validator => new FxFeatureValidator();
    }
    
    /// <summary>
    /// MetaData definition for FxFixingDate
    /// </summary>
    [RosettaMeta(typeof(FxFixingDate))]
    public class FxFixingDateMeta : IRosettaMetaData<FxFixingDate>
    {
        public IEnumerable<IValidator<FxFixingDate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FxFixingDate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FxFixingDate, ISet<string>> OnlyExistsValidator => new FxFixingDateOnlyExistsValidator();

        public IValidator<FxFixingDate> Validator => new FxFixingDateValidator();
    }
    
    /// <summary>
    /// MetaData definition for FxInformationSource
    /// </summary>
    [RosettaMeta(typeof(FxInformationSource))]
    public class FxInformationSourceMeta : IRosettaMetaData<FxInformationSource>
    {
        public IEnumerable<IValidator<FxInformationSource>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FxInformationSource>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FxInformationSource, ISet<string>> OnlyExistsValidator => new FxInformationSourceOnlyExistsValidator();

        public IValidator<FxInformationSource> Validator => new FxInformationSourceValidator();
    }
    
    /// <summary>
    /// MetaData definition for FxLinkedNotionalAmount
    /// </summary>
    [RosettaMeta(typeof(FxLinkedNotionalAmount))]
    public class FxLinkedNotionalAmountMeta : IRosettaMetaData<FxLinkedNotionalAmount>
    {
        public IEnumerable<IValidator<FxLinkedNotionalAmount>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FxLinkedNotionalAmount>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FxLinkedNotionalAmount, ISet<string>> OnlyExistsValidator => new FxLinkedNotionalAmountOnlyExistsValidator();

        public IValidator<FxLinkedNotionalAmount> Validator => new FxLinkedNotionalAmountValidator();
    }
    
    /// <summary>
    /// MetaData definition for FxLinkedNotionalSchedule
    /// </summary>
    [RosettaMeta(typeof(FxLinkedNotionalSchedule))]
    public class FxLinkedNotionalScheduleMeta : IRosettaMetaData<FxLinkedNotionalSchedule>
    {
        public IEnumerable<IValidator<FxLinkedNotionalSchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FxLinkedNotionalSchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FxLinkedNotionalSchedule, ISet<string>> OnlyExistsValidator => new FxLinkedNotionalScheduleOnlyExistsValidator();

        public IValidator<FxLinkedNotionalSchedule> Validator => new FxLinkedNotionalScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for FxRate
    /// </summary>
    [RosettaMeta(typeof(FxRate))]
    public class FxRateMeta : IRosettaMetaData<FxRate>
    {
        public IEnumerable<IValidator<FxRate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FxRate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FxRate, ISet<string>> OnlyExistsValidator => new FxRateOnlyExistsValidator();

        public IValidator<FxRate> Validator => new FxRateValidator();
    }
    
    /// <summary>
    /// MetaData definition for FxRateSourceFixing
    /// </summary>
    [RosettaMeta(typeof(FxRateSourceFixing))]
    public class FxRateSourceFixingMeta : IRosettaMetaData<FxRateSourceFixing>
    {
        public IEnumerable<IValidator<FxRateSourceFixing>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FxRateSourceFixing>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FxRateSourceFixing, ISet<string>> OnlyExistsValidator => new FxRateSourceFixingOnlyExistsValidator();

        public IValidator<FxRateSourceFixing> Validator => new FxRateSourceFixingValidator();
    }
    
    /// <summary>
    /// MetaData definition for FxSettlementRateSource
    /// </summary>
    [RosettaMeta(typeof(FxSettlementRateSource))]
    public class FxSettlementRateSourceMeta : IRosettaMetaData<FxSettlementRateSource>
    {
        public IEnumerable<IValidator<FxSettlementRateSource>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FxSettlementRateSource>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FxSettlementRateSource, ISet<string>> OnlyExistsValidator => new FxSettlementRateSourceOnlyExistsValidator();

        public IValidator<FxSettlementRateSource> Validator => new FxSettlementRateSourceValidator();
    }
    
    /// <summary>
    /// MetaData definition for FxSpotRateSource
    /// </summary>
    [RosettaMeta(typeof(FxSpotRateSource))]
    public class FxSpotRateSourceMeta : IRosettaMetaData<FxSpotRateSource>
    {
        public IEnumerable<IValidator<FxSpotRateSource>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<FxSpotRateSource>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<FxSpotRateSource, ISet<string>> OnlyExistsValidator => new FxSpotRateSourceOnlyExistsValidator();

        public IValidator<FxSpotRateSource> Validator => new FxSpotRateSourceValidator();
    }
    
    /// <summary>
    /// MetaData definition for GeneralTerms
    /// </summary>
    [RosettaMeta(typeof(GeneralTerms))]
    public class GeneralTermsMeta : IRosettaMetaData<GeneralTerms>
    {
        public IEnumerable<IValidator<GeneralTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<GeneralTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<GeneralTerms, ISet<string>> OnlyExistsValidator => new GeneralTermsOnlyExistsValidator();

        public IValidator<GeneralTerms> Validator => new GeneralTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for GracePeriodExtension
    /// </summary>
    [RosettaMeta(typeof(GracePeriodExtension))]
    public class GracePeriodExtensionMeta : IRosettaMetaData<GracePeriodExtension>
    {
        public IEnumerable<IValidator<GracePeriodExtension>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<GracePeriodExtension>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<GracePeriodExtension, ISet<string>> OnlyExistsValidator => new GracePeriodExtensionOnlyExistsValidator();

        public IValidator<GracePeriodExtension> Validator => new GracePeriodExtensionValidator();
    }
    
    /// <summary>
    /// MetaData definition for Id
    /// </summary>
    [RosettaMeta(typeof(Id))]
    public class IdMeta : IRosettaMetaData<Id>
    {
        public IEnumerable<IValidator<Id>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Id>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Id, ISet<string>> OnlyExistsValidator => new IdOnlyExistsValidator();

        public IValidator<Id> Validator => new IdValidator();
    }
    
    /// <summary>
    /// MetaData definition for IdentifiedList
    /// </summary>
    [RosettaMeta(typeof(IdentifiedList))]
    public class IdentifiedListMeta : IRosettaMetaData<IdentifiedList>
    {
        public IEnumerable<IValidator<IdentifiedList>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<IdentifiedList>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<IdentifiedList, ISet<string>> OnlyExistsValidator => new IdentifiedListOnlyExistsValidator();

        public IValidator<IdentifiedList> Validator => new IdentifiedListValidator();
    }
    
    /// <summary>
    /// MetaData definition for Identifier
    /// </summary>
    [RosettaMeta(typeof(Identifier))]
    public class IdentifierMeta : IRosettaMetaData<Identifier>
    {
        public IEnumerable<IValidator<Identifier>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Identifier>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Identifier, ISet<string>> OnlyExistsValidator => new IdentifierOnlyExistsValidator();

        public IValidator<Identifier> Validator => new IdentifierValidator();
    }
    
    /// <summary>
    /// MetaData definition for IndependentAmount
    /// </summary>
    [RosettaMeta(typeof(IndependentAmount))]
    public class IndependentAmountMeta : IRosettaMetaData<IndependentAmount>
    {
        public IEnumerable<IValidator<IndependentAmount>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<IndependentAmount>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<IndependentAmount, ISet<string>> OnlyExistsValidator => new IndependentAmountOnlyExistsValidator();

        public IValidator<IndependentAmount> Validator => new IndependentAmountValidator();
    }
    
    /// <summary>
    /// MetaData definition for Index
    /// </summary>
    [RosettaMeta(typeof(Index))]
    public class IndexMeta : IRosettaMetaData<Index>
    {
        public IEnumerable<IValidator<Index>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Index>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Index, ISet<string>> OnlyExistsValidator => new IndexOnlyExistsValidator();

        public IValidator<Index> Validator => new IndexValidator();
    }
    
    /// <summary>
    /// MetaData definition for IndexAdjustmentEvents
    /// </summary>
    [RosettaMeta(typeof(IndexAdjustmentEvents))]
    public class IndexAdjustmentEventsMeta : IRosettaMetaData<IndexAdjustmentEvents>
    {
        public IEnumerable<IValidator<IndexAdjustmentEvents>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<IndexAdjustmentEvents>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<IndexAdjustmentEvents, ISet<string>> OnlyExistsValidator => new IndexAdjustmentEventsOnlyExistsValidator();

        public IValidator<IndexAdjustmentEvents> Validator => new IndexAdjustmentEventsValidator();
    }
    
    /// <summary>
    /// MetaData definition for IndexBase
    /// </summary>
    [RosettaMeta(typeof(IndexBase))]
    public class IndexBaseMeta : IRosettaMetaData<IndexBase>
    {
        public IEnumerable<IValidator<IndexBase>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<IndexBase>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<IndexBase, ISet<string>> OnlyExistsValidator => new IndexBaseOnlyExistsValidator();

        public IValidator<IndexBase> Validator => new IndexBaseValidator();
    }
    
    /// <summary>
    /// MetaData definition for IndexTransitionInstruction
    /// </summary>
    [RosettaMeta(typeof(IndexTransitionInstruction))]
    public class IndexTransitionInstructionMeta : IRosettaMetaData<IndexTransitionInstruction>
    {
        public IEnumerable<IValidator<IndexTransitionInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<IndexTransitionInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<IndexTransitionInstruction, ISet<string>> OnlyExistsValidator => new IndexTransitionInstructionOnlyExistsValidator();

        public IValidator<IndexTransitionInstruction> Validator => new IndexTransitionInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for Indx
    /// </summary>
    [RosettaMeta(typeof(Indx))]
    public class IndxMeta : IRosettaMetaData<Indx>
    {
        public IEnumerable<IValidator<Indx>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Indx>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Indx, ISet<string>> OnlyExistsValidator => new IndxOnlyExistsValidator();

        public IValidator<Indx> Validator => new IndxValidator();
    }
    
    /// <summary>
    /// MetaData definition for InflationIndex
    /// </summary>
    [RosettaMeta(typeof(InflationIndex))]
    public class InflationIndexMeta : IRosettaMetaData<InflationIndex>
    {
        public IEnumerable<IValidator<InflationIndex>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<InflationIndex>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<InflationIndex, ISet<string>> OnlyExistsValidator => new InflationIndexOnlyExistsValidator();

        public IValidator<InflationIndex> Validator => new InflationIndexValidator();
    }
    
    /// <summary>
    /// MetaData definition for InflationRateSpecification
    /// </summary>
    [RosettaMeta(typeof(InflationRateSpecification))]
    public class InflationRateSpecificationMeta : IRosettaMetaData<InflationRateSpecification>
    {
        public IEnumerable<IValidator<InflationRateSpecification>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<InflationRateSpecification>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<InflationRateSpecification, ISet<string>> OnlyExistsValidator => new InflationRateSpecificationOnlyExistsValidator();

        public IValidator<InflationRateSpecification> Validator => new InflationRateSpecificationValidator();
    }
    
    /// <summary>
    /// MetaData definition for InformationSource
    /// </summary>
    [RosettaMeta(typeof(InformationSource))]
    public class InformationSourceMeta : IRosettaMetaData<InformationSource>
    {
        public IEnumerable<IValidator<InformationSource>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<InformationSource>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<InformationSource, ISet<string>> OnlyExistsValidator => new InformationSourceOnlyExistsValidator();

        public IValidator<InformationSource> Validator => new InformationSourceValidator();
    }
    
    /// <summary>
    /// MetaData definition for InitialFixingDate
    /// </summary>
    [RosettaMeta(typeof(InitialFixingDate))]
    public class InitialFixingDateMeta : IRosettaMetaData<InitialFixingDate>
    {
        public IEnumerable<IValidator<InitialFixingDate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<InitialFixingDate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<InitialFixingDate, ISet<string>> OnlyExistsValidator => new InitialFixingDateOnlyExistsValidator();

        public IValidator<InitialFixingDate> Validator => new InitialFixingDateValidator();
    }
    
    /// <summary>
    /// MetaData definition for Instruction
    /// </summary>
    [RosettaMeta(typeof(Instruction))]
    public class InstructionMeta : IRosettaMetaData<Instruction>
    {
        public IEnumerable<IValidator<Instruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Instruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Instruction, ISet<string>> OnlyExistsValidator => new InstructionOnlyExistsValidator();

        public IValidator<Instruction> Validator => new InstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for Instrument
    /// </summary>
    [RosettaMeta(typeof(Instrument))]
    public class InstrumentMeta : IRosettaMetaData<Instrument>
    {
        public IEnumerable<IValidator<Instrument>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Instrument>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Instrument, ISet<string>> OnlyExistsValidator => new InstrumentOnlyExistsValidator();

        public IValidator<Instrument> Validator => new InstrumentValidator();
    }
    
    /// <summary>
    /// MetaData definition for InstrumentBase
    /// </summary>
    [RosettaMeta(typeof(InstrumentBase))]
    public class InstrumentBaseMeta : IRosettaMetaData<InstrumentBase>
    {
        public IEnumerable<IValidator<InstrumentBase>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<InstrumentBase>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<InstrumentBase, ISet<string>> OnlyExistsValidator => new InstrumentBaseOnlyExistsValidator();

        public IValidator<InstrumentBase> Validator => new InstrumentBaseValidator();
    }
    
    /// <summary>
    /// MetaData definition for InterestAmountApplication
    /// </summary>
    [RosettaMeta(typeof(InterestAmountApplication))]
    public class InterestAmountApplicationMeta : IRosettaMetaData<InterestAmountApplication>
    {
        public IEnumerable<IValidator<InterestAmountApplication>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<InterestAmountApplication>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<InterestAmountApplication, ISet<string>> OnlyExistsValidator => new InterestAmountApplicationOnlyExistsValidator();

        public IValidator<InterestAmountApplication> Validator => new InterestAmountApplicationValidator();
    }
    
    /// <summary>
    /// MetaData definition for InterestRateCurve
    /// </summary>
    [RosettaMeta(typeof(InterestRateCurve))]
    public class InterestRateCurveMeta : IRosettaMetaData<InterestRateCurve>
    {
        public IEnumerable<IValidator<InterestRateCurve>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<InterestRateCurve>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<InterestRateCurve, ISet<string>> OnlyExistsValidator => new InterestRateCurveOnlyExistsValidator();

        public IValidator<InterestRateCurve> Validator => new InterestRateCurveValidator();
    }
    
    /// <summary>
    /// MetaData definition for InterestRateIndex
    /// </summary>
    [RosettaMeta(typeof(InterestRateIndex))]
    public class InterestRateIndexMeta : IRosettaMetaData<InterestRateIndex>
    {
        public IEnumerable<IValidator<InterestRateIndex>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<InterestRateIndex>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<InterestRateIndex, ISet<string>> OnlyExistsValidator => new InterestRateIndexOnlyExistsValidator();

        public IValidator<InterestRateIndex> Validator => new InterestRateIndexValidator();
    }
    
    /// <summary>
    /// MetaData definition for InterestRatePayout
    /// </summary>
    [RosettaMeta(typeof(InterestRatePayout))]
    public class InterestRatePayoutMeta : IRosettaMetaData<InterestRatePayout>
    {
        public IEnumerable<IValidator<InterestRatePayout>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<InterestRatePayout>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<InterestRatePayout, ISet<string>> OnlyExistsValidator => new InterestRatePayoutOnlyExistsValidator();

        public IValidator<InterestRatePayout> Validator => new InterestRatePayoutValidator();
    }
    
    /// <summary>
    /// MetaData definition for InterestShortFall
    /// </summary>
    [RosettaMeta(typeof(InterestShortFall))]
    public class InterestShortFallMeta : IRosettaMetaData<InterestShortFall>
    {
        public IEnumerable<IValidator<InterestShortFall>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<InterestShortFall>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<InterestShortFall, ISet<string>> OnlyExistsValidator => new InterestShortFallOnlyExistsValidator();

        public IValidator<InterestShortFall> Validator => new InterestShortFallValidator();
    }
    
    /// <summary>
    /// MetaData definition for Inventory
    /// </summary>
    [RosettaMeta(typeof(Inventory))]
    public class InventoryMeta : IRosettaMetaData<Inventory>
    {
        public IEnumerable<IValidator<Inventory>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Inventory>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Inventory, ISet<string>> OnlyExistsValidator => new InventoryOnlyExistsValidator();

        public IValidator<Inventory> Validator => new InventoryValidator();
    }
    
    /// <summary>
    /// MetaData definition for InventoryRecord
    /// </summary>
    [RosettaMeta(typeof(InventoryRecord))]
    public class InventoryRecordMeta : IRosettaMetaData<InventoryRecord>
    {
        public IEnumerable<IValidator<InventoryRecord>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<InventoryRecord>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<InventoryRecord, ISet<string>> OnlyExistsValidator => new InventoryRecordOnlyExistsValidator();

        public IValidator<InventoryRecord> Validator => new InventoryRecordValidator();
    }
    
    /// <summary>
    /// MetaData definition for InvstmtDcsnPrsn
    /// </summary>
    [RosettaMeta(typeof(InvstmtDcsnPrsn))]
    public class InvstmtDcsnPrsnMeta : IRosettaMetaData<InvstmtDcsnPrsn>
    {
        public IEnumerable<IValidator<InvstmtDcsnPrsn>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<InvstmtDcsnPrsn>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<InvstmtDcsnPrsn, ISet<string>> OnlyExistsValidator => new InvstmtDcsnPrsnOnlyExistsValidator();

        public IValidator<InvstmtDcsnPrsn> Validator => new InvstmtDcsnPrsnValidator();
    }
    
    /// <summary>
    /// MetaData definition for IssuerAgencyRating
    /// </summary>
    [RosettaMeta(typeof(IssuerAgencyRating))]
    public class IssuerAgencyRatingMeta : IRosettaMetaData<IssuerAgencyRating>
    {
        public IEnumerable<IValidator<IssuerAgencyRating>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<IssuerAgencyRating>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<IssuerAgencyRating, ISet<string>> OnlyExistsValidator => new IssuerAgencyRatingOnlyExistsValidator();

        public IValidator<IssuerAgencyRating> Validator => new IssuerAgencyRatingValidator();
    }
    
    /// <summary>
    /// MetaData definition for IssuerCountryOfOrigin
    /// </summary>
    [RosettaMeta(typeof(IssuerCountryOfOrigin))]
    public class IssuerCountryOfOriginMeta : IRosettaMetaData<IssuerCountryOfOrigin>
    {
        public IEnumerable<IValidator<IssuerCountryOfOrigin>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<IssuerCountryOfOrigin>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<IssuerCountryOfOrigin, ISet<string>> OnlyExistsValidator => new IssuerCountryOfOriginOnlyExistsValidator();

        public IValidator<IssuerCountryOfOrigin> Validator => new IssuerCountryOfOriginValidator();
    }
    
    /// <summary>
    /// MetaData definition for IssuerName
    /// </summary>
    [RosettaMeta(typeof(IssuerName))]
    public class IssuerNameMeta : IRosettaMetaData<IssuerName>
    {
        public IEnumerable<IValidator<IssuerName>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<IssuerName>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<IssuerName, ISet<string>> OnlyExistsValidator => new IssuerNameOnlyExistsValidator();

        public IValidator<IssuerName> Validator => new IssuerNameValidator();
    }
    
    /// <summary>
    /// MetaData definition for Knock
    /// </summary>
    [RosettaMeta(typeof(Knock))]
    public class KnockMeta : IRosettaMetaData<Knock>
    {
        public IEnumerable<IValidator<Knock>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Knock>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Knock, ISet<string>> OnlyExistsValidator => new KnockOnlyExistsValidator();

        public IValidator<Knock> Validator => new KnockValidator();
    }
    
    /// <summary>
    /// MetaData definition for Lag
    /// </summary>
    [RosettaMeta(typeof(Lag))]
    public class LagMeta : IRosettaMetaData<Lag>
    {
        public IEnumerable<IValidator<Lag>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Lag>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Lag, ISet<string>> OnlyExistsValidator => new LagOnlyExistsValidator();

        public IValidator<Lag> Validator => new LagValidator();
    }
    
    /// <summary>
    /// MetaData definition for LegalAgreement
    /// </summary>
    [RosettaMeta(typeof(LegalAgreement))]
    public class LegalAgreementMeta : IRosettaMetaData<LegalAgreement>
    {
        public IEnumerable<IValidator<LegalAgreement>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<LegalAgreement>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<LegalAgreement, ISet<string>> OnlyExistsValidator => new LegalAgreementOnlyExistsValidator();

        public IValidator<LegalAgreement> Validator => new LegalAgreementValidator();
    }
    
    /// <summary>
    /// MetaData definition for LegalAgreementBase
    /// </summary>
    [RosettaMeta(typeof(LegalAgreementBase))]
    public class LegalAgreementBaseMeta : IRosettaMetaData<LegalAgreementBase>
    {
        public IEnumerable<IValidator<LegalAgreementBase>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<LegalAgreementBase>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<LegalAgreementBase, ISet<string>> OnlyExistsValidator => new LegalAgreementBaseOnlyExistsValidator();

        public IValidator<LegalAgreementBase> Validator => new LegalAgreementBaseValidator();
    }
    
    /// <summary>
    /// MetaData definition for LegalAgreementIdentification
    /// </summary>
    [RosettaMeta(typeof(LegalAgreementIdentification))]
    public class LegalAgreementIdentificationMeta : IRosettaMetaData<LegalAgreementIdentification>
    {
        public IEnumerable<IValidator<LegalAgreementIdentification>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<LegalAgreementIdentification>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<LegalAgreementIdentification, ISet<string>> OnlyExistsValidator => new LegalAgreementIdentificationOnlyExistsValidator();

        public IValidator<LegalAgreementIdentification> Validator => new LegalAgreementIdentificationValidator();
    }
    
    /// <summary>
    /// MetaData definition for LegalEntity
    /// </summary>
    [RosettaMeta(typeof(LegalEntity))]
    public class LegalEntityMeta : IRosettaMetaData<LegalEntity>
    {
        public IEnumerable<IValidator<LegalEntity>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<LegalEntity>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<LegalEntity, ISet<string>> OnlyExistsValidator => new LegalEntityOnlyExistsValidator();

        public IValidator<LegalEntity> Validator => new LegalEntityValidator();
    }
    
    /// <summary>
    /// MetaData definition for LimitApplicable
    /// </summary>
    [RosettaMeta(typeof(LimitApplicable))]
    public class LimitApplicableMeta : IRosettaMetaData<LimitApplicable>
    {
        public IEnumerable<IValidator<LimitApplicable>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<LimitApplicable>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<LimitApplicable, ISet<string>> OnlyExistsValidator => new LimitApplicableOnlyExistsValidator();

        public IValidator<LimitApplicable> Validator => new LimitApplicableValidator();
    }
    
    /// <summary>
    /// MetaData definition for LimitApplicableExtended
    /// </summary>
    [RosettaMeta(typeof(LimitApplicableExtended))]
    public class LimitApplicableExtendedMeta : IRosettaMetaData<LimitApplicableExtended>
    {
        public IEnumerable<IValidator<LimitApplicableExtended>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<LimitApplicableExtended>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<LimitApplicableExtended, ISet<string>> OnlyExistsValidator => new LimitApplicableExtendedOnlyExistsValidator();

        public IValidator<LimitApplicableExtended> Validator => new LimitApplicableExtendedValidator();
    }
    
    /// <summary>
    /// MetaData definition for Lineage
    /// </summary>
    [RosettaMeta(typeof(Lineage))]
    public class LineageMeta : IRosettaMetaData<Lineage>
    {
        public IEnumerable<IValidator<Lineage>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Lineage>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Lineage, ISet<string>> OnlyExistsValidator => new LineageOnlyExistsValidator();

        public IValidator<Lineage> Validator => new LineageValidator();
    }
    
    /// <summary>
    /// MetaData definition for ListedDerivative
    /// </summary>
    [RosettaMeta(typeof(ListedDerivative))]
    public class ListedDerivativeMeta : IRosettaMetaData<ListedDerivative>
    {
        public IEnumerable<IValidator<ListedDerivative>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ListedDerivative>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ListedDerivative, ISet<string>> OnlyExistsValidator => new ListedDerivativeOnlyExistsValidator();

        public IValidator<ListedDerivative> Validator => new ListedDerivativeValidator();
    }
    
    /// <summary>
    /// MetaData definition for ListingExchange
    /// </summary>
    [RosettaMeta(typeof(ListingExchange))]
    public class ListingExchangeMeta : IRosettaMetaData<ListingExchange>
    {
        public IEnumerable<IValidator<ListingExchange>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ListingExchange>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ListingExchange, ISet<string>> OnlyExistsValidator => new ListingExchangeOnlyExistsValidator();

        public IValidator<ListingExchange> Validator => new ListingExchangeValidator();
    }
    
    /// <summary>
    /// MetaData definition for ListingSector
    /// </summary>
    [RosettaMeta(typeof(ListingSector))]
    public class ListingSectorMeta : IRosettaMetaData<ListingSector>
    {
        public IEnumerable<IValidator<ListingSector>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ListingSector>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ListingSector, ISet<string>> OnlyExistsValidator => new ListingSectorOnlyExistsValidator();

        public IValidator<ListingSector> Validator => new ListingSectorValidator();
    }
    
    /// <summary>
    /// MetaData definition for Loan
    /// </summary>
    [RosettaMeta(typeof(Loan))]
    public class LoanMeta : IRosettaMetaData<Loan>
    {
        public IEnumerable<IValidator<Loan>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Loan>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Loan, ISet<string>> OnlyExistsValidator => new LoanOnlyExistsValidator();

        public IValidator<Loan> Validator => new LoanValidator();
    }
    
    /// <summary>
    /// MetaData definition for LoanParticipation
    /// </summary>
    [RosettaMeta(typeof(LoanParticipation))]
    public class LoanParticipationMeta : IRosettaMetaData<LoanParticipation>
    {
        public IEnumerable<IValidator<LoanParticipation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<LoanParticipation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<LoanParticipation, ISet<string>> OnlyExistsValidator => new LoanParticipationOnlyExistsValidator();

        public IValidator<LoanParticipation> Validator => new LoanParticipationValidator();
    }
    
    /// <summary>
    /// MetaData definition for LocationIdentifier
    /// </summary>
    [RosettaMeta(typeof(LocationIdentifier))]
    public class LocationIdentifierMeta : IRosettaMetaData<LocationIdentifier>
    {
        public IEnumerable<IValidator<LocationIdentifier>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<LocationIdentifier>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<LocationIdentifier, ISet<string>> OnlyExistsValidator => new LocationIdentifierOnlyExistsValidator();

        public IValidator<LocationIdentifier> Validator => new LocationIdentifierValidator();
    }
    
    /// <summary>
    /// MetaData definition for MakeWholeAmount
    /// </summary>
    [RosettaMeta(typeof(MakeWholeAmount))]
    public class MakeWholeAmountMeta : IRosettaMetaData<MakeWholeAmount>
    {
        public IEnumerable<IValidator<MakeWholeAmount>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MakeWholeAmount>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MakeWholeAmount, ISet<string>> OnlyExistsValidator => new MakeWholeAmountOnlyExistsValidator();

        public IValidator<MakeWholeAmount> Validator => new MakeWholeAmountValidator();
    }
    
    /// <summary>
    /// MetaData definition for MandatoryEarlyTermination
    /// </summary>
    [RosettaMeta(typeof(MandatoryEarlyTermination))]
    public class MandatoryEarlyTerminationMeta : IRosettaMetaData<MandatoryEarlyTermination>
    {
        public IEnumerable<IValidator<MandatoryEarlyTermination>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MandatoryEarlyTermination>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MandatoryEarlyTermination, ISet<string>> OnlyExistsValidator => new MandatoryEarlyTerminationOnlyExistsValidator();

        public IValidator<MandatoryEarlyTermination> Validator => new MandatoryEarlyTerminationValidator();
    }
    
    /// <summary>
    /// MetaData definition for MandatoryEarlyTerminationAdjustedDates
    /// </summary>
    [RosettaMeta(typeof(MandatoryEarlyTerminationAdjustedDates))]
    public class MandatoryEarlyTerminationAdjustedDatesMeta : IRosettaMetaData<MandatoryEarlyTerminationAdjustedDates>
    {
        public IEnumerable<IValidator<MandatoryEarlyTerminationAdjustedDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MandatoryEarlyTerminationAdjustedDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MandatoryEarlyTerminationAdjustedDates, ISet<string>> OnlyExistsValidator => new MandatoryEarlyTerminationAdjustedDatesOnlyExistsValidator();

        public IValidator<MandatoryEarlyTerminationAdjustedDates> Validator => new MandatoryEarlyTerminationAdjustedDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for ManualExercise
    /// </summary>
    [RosettaMeta(typeof(ManualExercise))]
    public class ManualExerciseMeta : IRosettaMetaData<ManualExercise>
    {
        public IEnumerable<IValidator<ManualExercise>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ManualExercise>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ManualExercise, ISet<string>> OnlyExistsValidator => new ManualExerciseOnlyExistsValidator();

        public IValidator<ManualExercise> Validator => new ManualExerciseValidator();
    }
    
    /// <summary>
    /// MetaData definition for MarginCallBase
    /// </summary>
    [RosettaMeta(typeof(MarginCallBase))]
    public class MarginCallBaseMeta : IRosettaMetaData<MarginCallBase>
    {
        public IEnumerable<IValidator<MarginCallBase>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MarginCallBase>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MarginCallBase, ISet<string>> OnlyExistsValidator => new MarginCallBaseOnlyExistsValidator();

        public IValidator<MarginCallBase> Validator => new MarginCallBaseValidator();
    }
    
    /// <summary>
    /// MetaData definition for MarginCallExposure
    /// </summary>
    [RosettaMeta(typeof(MarginCallExposure))]
    public class MarginCallExposureMeta : IRosettaMetaData<MarginCallExposure>
    {
        public IEnumerable<IValidator<MarginCallExposure>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MarginCallExposure>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MarginCallExposure, ISet<string>> OnlyExistsValidator => new MarginCallExposureOnlyExistsValidator();

        public IValidator<MarginCallExposure> Validator => new MarginCallExposureValidator();
    }
    
    /// <summary>
    /// MetaData definition for MarginCallInstructionType
    /// </summary>
    [RosettaMeta(typeof(MarginCallInstructionType))]
    public class MarginCallInstructionTypeMeta : IRosettaMetaData<MarginCallInstructionType>
    {
        public IEnumerable<IValidator<MarginCallInstructionType>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MarginCallInstructionType>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MarginCallInstructionType, ISet<string>> OnlyExistsValidator => new MarginCallInstructionTypeOnlyExistsValidator();

        public IValidator<MarginCallInstructionType> Validator => new MarginCallInstructionTypeValidator();
    }
    
    /// <summary>
    /// MetaData definition for MarginCallIssuance
    /// </summary>
    [RosettaMeta(typeof(MarginCallIssuance))]
    public class MarginCallIssuanceMeta : IRosettaMetaData<MarginCallIssuance>
    {
        public IEnumerable<IValidator<MarginCallIssuance>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MarginCallIssuance>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MarginCallIssuance, ISet<string>> OnlyExistsValidator => new MarginCallIssuanceOnlyExistsValidator();

        public IValidator<MarginCallIssuance> Validator => new MarginCallIssuanceValidator();
    }
    
    /// <summary>
    /// MetaData definition for MarginCallResponse
    /// </summary>
    [RosettaMeta(typeof(MarginCallResponse))]
    public class MarginCallResponseMeta : IRosettaMetaData<MarginCallResponse>
    {
        public IEnumerable<IValidator<MarginCallResponse>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MarginCallResponse>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MarginCallResponse, ISet<string>> OnlyExistsValidator => new MarginCallResponseOnlyExistsValidator();

        public IValidator<MarginCallResponse> Validator => new MarginCallResponseValidator();
    }
    
    /// <summary>
    /// MetaData definition for MarginCallResponseAction
    /// </summary>
    [RosettaMeta(typeof(MarginCallResponseAction))]
    public class MarginCallResponseActionMeta : IRosettaMetaData<MarginCallResponseAction>
    {
        public IEnumerable<IValidator<MarginCallResponseAction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MarginCallResponseAction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MarginCallResponseAction, ISet<string>> OnlyExistsValidator => new MarginCallResponseActionOnlyExistsValidator();

        public IValidator<MarginCallResponseAction> Validator => new MarginCallResponseActionValidator();
    }
    
    /// <summary>
    /// MetaData definition for MasterAgreementClause
    /// </summary>
    [RosettaMeta(typeof(MasterAgreementClause))]
    public class MasterAgreementClauseMeta : IRosettaMetaData<MasterAgreementClause>
    {
        public IEnumerable<IValidator<MasterAgreementClause>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MasterAgreementClause>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MasterAgreementClause, ISet<string>> OnlyExistsValidator => new MasterAgreementClauseOnlyExistsValidator();

        public IValidator<MasterAgreementClause> Validator => new MasterAgreementClauseValidator();
    }
    
    /// <summary>
    /// MetaData definition for MasterAgreementClauseVariant
    /// </summary>
    [RosettaMeta(typeof(MasterAgreementClauseVariant))]
    public class MasterAgreementClauseVariantMeta : IRosettaMetaData<MasterAgreementClauseVariant>
    {
        public IEnumerable<IValidator<MasterAgreementClauseVariant>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MasterAgreementClauseVariant>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MasterAgreementClauseVariant, ISet<string>> OnlyExistsValidator => new MasterAgreementClauseVariantOnlyExistsValidator();

        public IValidator<MasterAgreementClauseVariant> Validator => new MasterAgreementClauseVariantValidator();
    }
    
    /// <summary>
    /// MetaData definition for MasterAgreementSchedule
    /// </summary>
    [RosettaMeta(typeof(MasterAgreementSchedule))]
    public class MasterAgreementScheduleMeta : IRosettaMetaData<MasterAgreementSchedule>
    {
        public IEnumerable<IValidator<MasterAgreementSchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MasterAgreementSchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MasterAgreementSchedule, ISet<string>> OnlyExistsValidator => new MasterAgreementScheduleOnlyExistsValidator();

        public IValidator<MasterAgreementSchedule> Validator => new MasterAgreementScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for MasterAgreementVariableSet
    /// </summary>
    [RosettaMeta(typeof(MasterAgreementVariableSet))]
    public class MasterAgreementVariableSetMeta : IRosettaMetaData<MasterAgreementVariableSet>
    {
        public IEnumerable<IValidator<MasterAgreementVariableSet>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MasterAgreementVariableSet>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MasterAgreementVariableSet, ISet<string>> OnlyExistsValidator => new MasterAgreementVariableSetOnlyExistsValidator();

        public IValidator<MasterAgreementVariableSet> Validator => new MasterAgreementVariableSetValidator();
    }
    
    /// <summary>
    /// MetaData definition for MasterConfirmationBase
    /// </summary>
    [RosettaMeta(typeof(MasterConfirmationBase))]
    public class MasterConfirmationBaseMeta : IRosettaMetaData<MasterConfirmationBase>
    {
        public IEnumerable<IValidator<MasterConfirmationBase>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MasterConfirmationBase>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MasterConfirmationBase, ISet<string>> OnlyExistsValidator => new MasterConfirmationBaseOnlyExistsValidator();

        public IValidator<MasterConfirmationBase> Validator => new MasterConfirmationBaseValidator();
    }
    
    /// <summary>
    /// MetaData definition for Measure
    /// </summary>
    [RosettaMeta(typeof(Measure))]
    public class MeasureMeta : IRosettaMetaData<Measure>
    {
        public IEnumerable<IValidator<Measure>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Measure>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Measure, ISet<string>> OnlyExistsValidator => new MeasureOnlyExistsValidator();

        public IValidator<Measure> Validator => new MeasureValidator();
    }
    
    /// <summary>
    /// MetaData definition for MeasureBase
    /// </summary>
    [RosettaMeta(typeof(MeasureBase))]
    public class MeasureBaseMeta : IRosettaMetaData<MeasureBase>
    {
        public IEnumerable<IValidator<MeasureBase>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MeasureBase>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MeasureBase, ISet<string>> OnlyExistsValidator => new MeasureBaseOnlyExistsValidator();

        public IValidator<MeasureBase> Validator => new MeasureBaseValidator();
    }
    
    /// <summary>
    /// MetaData definition for MeasureSchedule
    /// </summary>
    [RosettaMeta(typeof(MeasureSchedule))]
    public class MeasureScheduleMeta : IRosettaMetaData<MeasureSchedule>
    {
        public IEnumerable<IValidator<MeasureSchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MeasureSchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MeasureSchedule, ISet<string>> OnlyExistsValidator => new MeasureScheduleOnlyExistsValidator();

        public IValidator<MeasureSchedule> Validator => new MeasureScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for MessageInformation
    /// </summary>
    [RosettaMeta(typeof(MessageInformation))]
    public class MessageInformationMeta : IRosettaMetaData<MessageInformation>
    {
        public IEnumerable<IValidator<MessageInformation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MessageInformation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MessageInformation, ISet<string>> OnlyExistsValidator => new MessageInformationOnlyExistsValidator();

        public IValidator<MessageInformation> Validator => new MessageInformationValidator();
    }
    
    /// <summary>
    /// MetaData definition for Money
    /// </summary>
    [RosettaMeta(typeof(Money))]
    public class MoneyMeta : IRosettaMetaData<Money>
    {
        public IEnumerable<IValidator<Money>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Money>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Money, ISet<string>> OnlyExistsValidator => new MoneyOnlyExistsValidator();

        public IValidator<Money> Validator => new MoneyValidator();
    }
    
    /// <summary>
    /// MetaData definition for MoneyBound
    /// </summary>
    [RosettaMeta(typeof(MoneyBound))]
    public class MoneyBoundMeta : IRosettaMetaData<MoneyBound>
    {
        public IEnumerable<IValidator<MoneyBound>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MoneyBound>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MoneyBound, ISet<string>> OnlyExistsValidator => new MoneyBoundOnlyExistsValidator();

        public IValidator<MoneyBound> Validator => new MoneyBoundValidator();
    }
    
    /// <summary>
    /// MetaData definition for MoneyRange
    /// </summary>
    [RosettaMeta(typeof(MoneyRange))]
    public class MoneyRangeMeta : IRosettaMetaData<MoneyRange>
    {
        public IEnumerable<IValidator<MoneyRange>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MoneyRange>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MoneyRange, ISet<string>> OnlyExistsValidator => new MoneyRangeOnlyExistsValidator();

        public IValidator<MoneyRange> Validator => new MoneyRangeValidator();
    }
    
    /// <summary>
    /// MetaData definition for MultipleCreditNotations
    /// </summary>
    [RosettaMeta(typeof(MultipleCreditNotations))]
    public class MultipleCreditNotationsMeta : IRosettaMetaData<MultipleCreditNotations>
    {
        public IEnumerable<IValidator<MultipleCreditNotations>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MultipleCreditNotations>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MultipleCreditNotations, ISet<string>> OnlyExistsValidator => new MultipleCreditNotationsOnlyExistsValidator();

        public IValidator<MultipleCreditNotations> Validator => new MultipleCreditNotationsValidator();
    }
    
    /// <summary>
    /// MetaData definition for MultipleDebtTypes
    /// </summary>
    [RosettaMeta(typeof(MultipleDebtTypes))]
    public class MultipleDebtTypesMeta : IRosettaMetaData<MultipleDebtTypes>
    {
        public IEnumerable<IValidator<MultipleDebtTypes>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MultipleDebtTypes>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MultipleDebtTypes, ISet<string>> OnlyExistsValidator => new MultipleDebtTypesOnlyExistsValidator();

        public IValidator<MultipleDebtTypes> Validator => new MultipleDebtTypesValidator();
    }
    
    /// <summary>
    /// MetaData definition for MultipleExercise
    /// </summary>
    [RosettaMeta(typeof(MultipleExercise))]
    public class MultipleExerciseMeta : IRosettaMetaData<MultipleExercise>
    {
        public IEnumerable<IValidator<MultipleExercise>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MultipleExercise>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MultipleExercise, ISet<string>> OnlyExistsValidator => new MultipleExerciseOnlyExistsValidator();

        public IValidator<MultipleExercise> Validator => new MultipleExerciseValidator();
    }
    
    /// <summary>
    /// MetaData definition for MultipleValuationDates
    /// </summary>
    [RosettaMeta(typeof(MultipleValuationDates))]
    public class MultipleValuationDatesMeta : IRosettaMetaData<MultipleValuationDates>
    {
        public IEnumerable<IValidator<MultipleValuationDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<MultipleValuationDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<MultipleValuationDates, ISet<string>> OnlyExistsValidator => new MultipleValuationDatesOnlyExistsValidator();

        public IValidator<MultipleValuationDates> Validator => new MultipleValuationDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for NaturalPerson
    /// </summary>
    [RosettaMeta(typeof(NaturalPerson))]
    public class NaturalPersonMeta : IRosettaMetaData<NaturalPerson>
    {
        public IEnumerable<IValidator<NaturalPerson>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<NaturalPerson>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<NaturalPerson, ISet<string>> OnlyExistsValidator => new NaturalPersonOnlyExistsValidator();

        public IValidator<NaturalPerson> Validator => new NaturalPersonValidator();
    }
    
    /// <summary>
    /// MetaData definition for NaturalPersonRole
    /// </summary>
    [RosettaMeta(typeof(NaturalPersonRole))]
    public class NaturalPersonRoleMeta : IRosettaMetaData<NaturalPersonRole>
    {
        public IEnumerable<IValidator<NaturalPersonRole>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<NaturalPersonRole>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<NaturalPersonRole, ISet<string>> OnlyExistsValidator => new NaturalPersonRoleOnlyExistsValidator();

        public IValidator<NaturalPersonRole> Validator => new NaturalPersonRoleValidator();
    }
    
    /// <summary>
    /// MetaData definition for NegativeCriteria
    /// </summary>
    [RosettaMeta(typeof(NegativeCriteria))]
    public class NegativeCriteriaMeta : IRosettaMetaData<NegativeCriteria>
    {
        public IEnumerable<IValidator<NegativeCriteria>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<NegativeCriteria>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<NegativeCriteria, ISet<string>> OnlyExistsValidator => new NegativeCriteriaOnlyExistsValidator();

        public IValidator<NegativeCriteria> Validator => new NegativeCriteriaValidator();
    }
    
    /// <summary>
    /// MetaData definition for New
    /// </summary>
    [RosettaMeta(typeof(New))]
    public class NewMeta : IRosettaMetaData<New>
    {
        public IEnumerable<IValidator<New>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<New>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<New, ISet<string>> OnlyExistsValidator => new NewOnlyExistsValidator();

        public IValidator<New> Validator => new NewValidator();
    }
    
    /// <summary>
    /// MetaData definition for Nm
    /// </summary>
    [RosettaMeta(typeof(Nm))]
    public class NmMeta : IRosettaMetaData<Nm>
    {
        public IEnumerable<IValidator<Nm>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Nm>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Nm, ISet<string>> OnlyExistsValidator => new NmOnlyExistsValidator();

        public IValidator<Nm> Validator => new NmValidator();
    }
    
    /// <summary>
    /// MetaData definition for NonNegativeQuantity
    /// </summary>
    [RosettaMeta(typeof(NonNegativeQuantity))]
    public class NonNegativeQuantityMeta : IRosettaMetaData<NonNegativeQuantity>
    {
        public IEnumerable<IValidator<NonNegativeQuantity>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<NonNegativeQuantity>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<NonNegativeQuantity, ISet<string>> OnlyExistsValidator => new NonNegativeQuantityOnlyExistsValidator();

        public IValidator<NonNegativeQuantity> Validator => new NonNegativeQuantityValidator();
    }
    
    /// <summary>
    /// MetaData definition for NonNegativeQuantitySchedule
    /// </summary>
    [RosettaMeta(typeof(NonNegativeQuantitySchedule))]
    public class NonNegativeQuantityScheduleMeta : IRosettaMetaData<NonNegativeQuantitySchedule>
    {
        public IEnumerable<IValidator<NonNegativeQuantitySchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<NonNegativeQuantitySchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<NonNegativeQuantitySchedule, ISet<string>> OnlyExistsValidator => new NonNegativeQuantityScheduleOnlyExistsValidator();

        public IValidator<NonNegativeQuantitySchedule> Validator => new NonNegativeQuantityScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for NonNegativeStep
    /// </summary>
    [RosettaMeta(typeof(NonNegativeStep))]
    public class NonNegativeStepMeta : IRosettaMetaData<NonNegativeStep>
    {
        public IEnumerable<IValidator<NonNegativeStep>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<NonNegativeStep>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<NonNegativeStep, ISet<string>> OnlyExistsValidator => new NonNegativeStepOnlyExistsValidator();

        public IValidator<NonNegativeStep> Validator => new NonNegativeStepValidator();
    }
    
    /// <summary>
    /// MetaData definition for NonTransferableProduct
    /// </summary>
    [RosettaMeta(typeof(NonTransferableProduct))]
    public class NonTransferableProductMeta : IRosettaMetaData<NonTransferableProduct>
    {
        public IEnumerable<IValidator<NonTransferableProduct>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<NonTransferableProduct>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<NonTransferableProduct, ISet<string>> OnlyExistsValidator => new NonTransferableProductOnlyExistsValidator();

        public IValidator<NonTransferableProduct> Validator => new NonTransferableProductValidator();
    }
    
    /// <summary>
    /// MetaData definition for NotDomesticCurrency
    /// </summary>
    [RosettaMeta(typeof(NotDomesticCurrency))]
    public class NotDomesticCurrencyMeta : IRosettaMetaData<NotDomesticCurrency>
    {
        public IEnumerable<IValidator<NotDomesticCurrency>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<NotDomesticCurrency>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<NotDomesticCurrency, ISet<string>> OnlyExistsValidator => new NotDomesticCurrencyOnlyExistsValidator();

        public IValidator<NotDomesticCurrency> Validator => new NotDomesticCurrencyValidator();
    }
    
    /// <summary>
    /// MetaData definition for NumberBound
    /// </summary>
    [RosettaMeta(typeof(NumberBound))]
    public class NumberBoundMeta : IRosettaMetaData<NumberBound>
    {
        public IEnumerable<IValidator<NumberBound>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<NumberBound>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<NumberBound, ISet<string>> OnlyExistsValidator => new NumberBoundOnlyExistsValidator();

        public IValidator<NumberBound> Validator => new NumberBoundValidator();
    }
    
    /// <summary>
    /// MetaData definition for NumberRange
    /// </summary>
    [RosettaMeta(typeof(NumberRange))]
    public class NumberRangeMeta : IRosettaMetaData<NumberRange>
    {
        public IEnumerable<IValidator<NumberRange>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<NumberRange>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<NumberRange, ISet<string>> OnlyExistsValidator => new NumberRangeOnlyExistsValidator();

        public IValidator<NumberRange> Validator => new NumberRangeValidator();
    }
    
    /// <summary>
    /// MetaData definition for Obligations
    /// </summary>
    [RosettaMeta(typeof(Obligations))]
    public class ObligationsMeta : IRosettaMetaData<Obligations>
    {
        public IEnumerable<IValidator<Obligations>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Obligations>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Obligations, ISet<string>> OnlyExistsValidator => new ObligationsOnlyExistsValidator();

        public IValidator<Obligations> Validator => new ObligationsValidator();
    }
    
    /// <summary>
    /// MetaData definition for Observable
    /// </summary>
    [RosettaMeta(typeof(Observable))]
    public class ObservableMeta : IRosettaMetaData<Observable>
    {
        public IEnumerable<IValidator<Observable>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Observable>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Observable, ISet<string>> OnlyExistsValidator => new ObservableOnlyExistsValidator();

        public IValidator<Observable> Validator => new ObservableValidator();
    }
    
    /// <summary>
    /// MetaData definition for Observation
    /// </summary>
    [RosettaMeta(typeof(Observation))]
    public class ObservationMeta : IRosettaMetaData<Observation>
    {
        public IEnumerable<IValidator<Observation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Observation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Observation, ISet<string>> OnlyExistsValidator => new ObservationOnlyExistsValidator();

        public IValidator<Observation> Validator => new ObservationValidator();
    }
    
    /// <summary>
    /// MetaData definition for ObservationDate
    /// </summary>
    [RosettaMeta(typeof(ObservationDate))]
    public class ObservationDateMeta : IRosettaMetaData<ObservationDate>
    {
        public IEnumerable<IValidator<ObservationDate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ObservationDate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ObservationDate, ISet<string>> OnlyExistsValidator => new ObservationDateOnlyExistsValidator();

        public IValidator<ObservationDate> Validator => new ObservationDateValidator();
    }
    
    /// <summary>
    /// MetaData definition for ObservationDates
    /// </summary>
    [RosettaMeta(typeof(ObservationDates))]
    public class ObservationDatesMeta : IRosettaMetaData<ObservationDates>
    {
        public IEnumerable<IValidator<ObservationDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ObservationDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ObservationDates, ISet<string>> OnlyExistsValidator => new ObservationDatesOnlyExistsValidator();

        public IValidator<ObservationDates> Validator => new ObservationDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for ObservationEvent
    /// </summary>
    [RosettaMeta(typeof(ObservationEvent))]
    public class ObservationEventMeta : IRosettaMetaData<ObservationEvent>
    {
        public IEnumerable<IValidator<ObservationEvent>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ObservationEvent>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ObservationEvent, ISet<string>> OnlyExistsValidator => new ObservationEventOnlyExistsValidator();

        public IValidator<ObservationEvent> Validator => new ObservationEventValidator();
    }
    
    /// <summary>
    /// MetaData definition for ObservationIdentifier
    /// </summary>
    [RosettaMeta(typeof(ObservationIdentifier))]
    public class ObservationIdentifierMeta : IRosettaMetaData<ObservationIdentifier>
    {
        public IEnumerable<IValidator<ObservationIdentifier>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ObservationIdentifier>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ObservationIdentifier, ISet<string>> OnlyExistsValidator => new ObservationIdentifierOnlyExistsValidator();

        public IValidator<ObservationIdentifier> Validator => new ObservationIdentifierValidator();
    }
    
    /// <summary>
    /// MetaData definition for ObservationInstruction
    /// </summary>
    [RosettaMeta(typeof(ObservationInstruction))]
    public class ObservationInstructionMeta : IRosettaMetaData<ObservationInstruction>
    {
        public IEnumerable<IValidator<ObservationInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ObservationInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ObservationInstruction, ISet<string>> OnlyExistsValidator => new ObservationInstructionOnlyExistsValidator();

        public IValidator<ObservationInstruction> Validator => new ObservationInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for ObservationParameters
    /// </summary>
    [RosettaMeta(typeof(ObservationParameters))]
    public class ObservationParametersMeta : IRosettaMetaData<ObservationParameters>
    {
        public IEnumerable<IValidator<ObservationParameters>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ObservationParameters>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ObservationParameters, ISet<string>> OnlyExistsValidator => new ObservationParametersOnlyExistsValidator();

        public IValidator<ObservationParameters> Validator => new ObservationParametersValidator();
    }
    
    /// <summary>
    /// MetaData definition for ObservationSchedule
    /// </summary>
    [RosettaMeta(typeof(ObservationSchedule))]
    public class ObservationScheduleMeta : IRosettaMetaData<ObservationSchedule>
    {
        public IEnumerable<IValidator<ObservationSchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ObservationSchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ObservationSchedule, ISet<string>> OnlyExistsValidator => new ObservationScheduleOnlyExistsValidator();

        public IValidator<ObservationSchedule> Validator => new ObservationScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for ObservationShiftCalculation
    /// </summary>
    [RosettaMeta(typeof(ObservationShiftCalculation))]
    public class ObservationShiftCalculationMeta : IRosettaMetaData<ObservationShiftCalculation>
    {
        public IEnumerable<IValidator<ObservationShiftCalculation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ObservationShiftCalculation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ObservationShiftCalculation, ISet<string>> OnlyExistsValidator => new ObservationShiftCalculationOnlyExistsValidator();

        public IValidator<ObservationShiftCalculation> Validator => new ObservationShiftCalculationValidator();
    }
    
    /// <summary>
    /// MetaData definition for ObservationTerms
    /// </summary>
    [RosettaMeta(typeof(ObservationTerms))]
    public class ObservationTermsMeta : IRosettaMetaData<ObservationTerms>
    {
        public IEnumerable<IValidator<ObservationTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ObservationTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ObservationTerms, ISet<string>> OnlyExistsValidator => new ObservationTermsOnlyExistsValidator();

        public IValidator<ObservationTerms> Validator => new ObservationTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for Offset
    /// </summary>
    [RosettaMeta(typeof(Offset))]
    public class OffsetMeta : IRosettaMetaData<Offset>
    {
        public IEnumerable<IValidator<Offset>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Offset>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Offset, ISet<string>> OnlyExistsValidator => new OffsetOnlyExistsValidator();

        public IValidator<Offset> Validator => new OffsetValidator();
    }
    
    /// <summary>
    /// MetaData definition for OffsetCalculation
    /// </summary>
    [RosettaMeta(typeof(OffsetCalculation))]
    public class OffsetCalculationMeta : IRosettaMetaData<OffsetCalculation>
    {
        public IEnumerable<IValidator<OffsetCalculation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<OffsetCalculation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<OffsetCalculation, ISet<string>> OnlyExistsValidator => new OffsetCalculationOnlyExistsValidator();

        public IValidator<OffsetCalculation> Validator => new OffsetCalculationValidator();
    }
    
    /// <summary>
    /// MetaData definition for OptionFeature
    /// </summary>
    [RosettaMeta(typeof(OptionFeature))]
    public class OptionFeatureMeta : IRosettaMetaData<OptionFeature>
    {
        public IEnumerable<IValidator<OptionFeature>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<OptionFeature>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<OptionFeature, ISet<string>> OnlyExistsValidator => new OptionFeatureOnlyExistsValidator();

        public IValidator<OptionFeature> Validator => new OptionFeatureValidator();
    }
    
    /// <summary>
    /// MetaData definition for OptionPayout
    /// </summary>
    [RosettaMeta(typeof(OptionPayout))]
    public class OptionPayoutMeta : IRosettaMetaData<OptionPayout>
    {
        public IEnumerable<IValidator<OptionPayout>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<OptionPayout>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<OptionPayout, ISet<string>> OnlyExistsValidator => new OptionPayoutOnlyExistsValidator();

        public IValidator<OptionPayout> Validator => new OptionPayoutValidator();
    }
    
    /// <summary>
    /// MetaData definition for OptionStrike
    /// </summary>
    [RosettaMeta(typeof(OptionStrike))]
    public class OptionStrikeMeta : IRosettaMetaData<OptionStrike>
    {
        public IEnumerable<IValidator<OptionStrike>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<OptionStrike>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<OptionStrike, ISet<string>> OnlyExistsValidator => new OptionStrikeOnlyExistsValidator();

        public IValidator<OptionStrike> Validator => new OptionStrikeValidator();
    }
    
    /// <summary>
    /// MetaData definition for OptionalEarlyTermination
    /// </summary>
    [RosettaMeta(typeof(OptionalEarlyTermination))]
    public class OptionalEarlyTerminationMeta : IRosettaMetaData<OptionalEarlyTermination>
    {
        public IEnumerable<IValidator<OptionalEarlyTermination>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<OptionalEarlyTermination>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<OptionalEarlyTermination, ISet<string>> OnlyExistsValidator => new OptionalEarlyTerminationOnlyExistsValidator();

        public IValidator<OptionalEarlyTermination> Validator => new OptionalEarlyTerminationValidator();
    }
    
    /// <summary>
    /// MetaData definition for OptionalEarlyTerminationAdjustedDates
    /// </summary>
    [RosettaMeta(typeof(OptionalEarlyTerminationAdjustedDates))]
    public class OptionalEarlyTerminationAdjustedDatesMeta : IRosettaMetaData<OptionalEarlyTerminationAdjustedDates>
    {
        public IEnumerable<IValidator<OptionalEarlyTerminationAdjustedDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<OptionalEarlyTerminationAdjustedDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<OptionalEarlyTerminationAdjustedDates, ISet<string>> OnlyExistsValidator => new OptionalEarlyTerminationAdjustedDatesOnlyExistsValidator();

        public IValidator<OptionalEarlyTerminationAdjustedDates> Validator => new OptionalEarlyTerminationAdjustedDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for OrdrTrnsmssn
    /// </summary>
    [RosettaMeta(typeof(OrdrTrnsmssn))]
    public class OrdrTrnsmssnMeta : IRosettaMetaData<OrdrTrnsmssn>
    {
        public IEnumerable<IValidator<OrdrTrnsmssn>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<OrdrTrnsmssn>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<OrdrTrnsmssn, ISet<string>> OnlyExistsValidator => new OrdrTrnsmssnOnlyExistsValidator();

        public IValidator<OrdrTrnsmssn> Validator => new OrdrTrnsmssnValidator();
    }
    
    /// <summary>
    /// MetaData definition for OtherAgreement
    /// </summary>
    [RosettaMeta(typeof(OtherAgreement))]
    public class OtherAgreementMeta : IRosettaMetaData<OtherAgreement>
    {
        public IEnumerable<IValidator<OtherAgreement>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<OtherAgreement>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<OtherAgreement, ISet<string>> OnlyExistsValidator => new OtherAgreementOnlyExistsValidator();

        public IValidator<OtherAgreement> Validator => new OtherAgreementValidator();
    }
    
    /// <summary>
    /// MetaData definition for OtherAgreementTerms
    /// </summary>
    [RosettaMeta(typeof(OtherAgreementTerms))]
    public class OtherAgreementTermsMeta : IRosettaMetaData<OtherAgreementTerms>
    {
        public IEnumerable<IValidator<OtherAgreementTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<OtherAgreementTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<OtherAgreementTerms, ISet<string>> OnlyExistsValidator => new OtherAgreementTermsOnlyExistsValidator();

        public IValidator<OtherAgreementTerms> Validator => new OtherAgreementTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for OtherIndex
    /// </summary>
    [RosettaMeta(typeof(OtherIndex))]
    public class OtherIndexMeta : IRosettaMetaData<OtherIndex>
    {
        public IEnumerable<IValidator<OtherIndex>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<OtherIndex>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<OtherIndex, ISet<string>> OnlyExistsValidator => new OtherIndexOnlyExistsValidator();

        public IValidator<OtherIndex> Validator => new OtherIndexValidator();
    }
    
    /// <summary>
    /// MetaData definition for Othr
    /// </summary>
    [RosettaMeta(typeof(Othr))]
    public class OthrMeta : IRosettaMetaData<Othr>
    {
        public IEnumerable<IValidator<Othr>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Othr>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Othr, ISet<string>> OnlyExistsValidator => new OthrOnlyExistsValidator();

        public IValidator<Othr> Validator => new OthrValidator();
    }
    
    /// <summary>
    /// MetaData definition for PCDeliverableObligationCharac
    /// </summary>
    [RosettaMeta(typeof(PCDeliverableObligationCharac))]
    public class PCDeliverableObligationCharacMeta : IRosettaMetaData<PCDeliverableObligationCharac>
    {
        public IEnumerable<IValidator<PCDeliverableObligationCharac>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PCDeliverableObligationCharac>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PCDeliverableObligationCharac, ISet<string>> OnlyExistsValidator => new PCDeliverableObligationCharacOnlyExistsValidator();

        public IValidator<PCDeliverableObligationCharac> Validator => new PCDeliverableObligationCharacValidator();
    }
    
    /// <summary>
    /// MetaData definition for ParametricDates
    /// </summary>
    [RosettaMeta(typeof(ParametricDates))]
    public class ParametricDatesMeta : IRosettaMetaData<ParametricDates>
    {
        public IEnumerable<IValidator<ParametricDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ParametricDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ParametricDates, ISet<string>> OnlyExistsValidator => new ParametricDatesOnlyExistsValidator();

        public IValidator<ParametricDates> Validator => new ParametricDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for PartialExercise
    /// </summary>
    [RosettaMeta(typeof(PartialExercise))]
    public class PartialExerciseMeta : IRosettaMetaData<PartialExercise>
    {
        public IEnumerable<IValidator<PartialExercise>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PartialExercise>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PartialExercise, ISet<string>> OnlyExistsValidator => new PartialExerciseOnlyExistsValidator();

        public IValidator<PartialExercise> Validator => new PartialExerciseValidator();
    }
    
    /// <summary>
    /// MetaData definition for Party
    /// </summary>
    [RosettaMeta(typeof(Party))]
    public class PartyMeta : IRosettaMetaData<Party>
    {
        public IEnumerable<IValidator<Party>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Party>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Party, ISet<string>> OnlyExistsValidator => new PartyOnlyExistsValidator();

        public IValidator<Party> Validator => new PartyValidator();
    }
    
    /// <summary>
    /// MetaData definition for PartyChangeInstruction
    /// </summary>
    [RosettaMeta(typeof(PartyChangeInstruction))]
    public class PartyChangeInstructionMeta : IRosettaMetaData<PartyChangeInstruction>
    {
        public IEnumerable<IValidator<PartyChangeInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PartyChangeInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PartyChangeInstruction, ISet<string>> OnlyExistsValidator => new PartyChangeInstructionOnlyExistsValidator();

        public IValidator<PartyChangeInstruction> Validator => new PartyChangeInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for PartyContactInformation
    /// </summary>
    [RosettaMeta(typeof(PartyContactInformation))]
    public class PartyContactInformationMeta : IRosettaMetaData<PartyContactInformation>
    {
        public IEnumerable<IValidator<PartyContactInformation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PartyContactInformation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PartyContactInformation, ISet<string>> OnlyExistsValidator => new PartyContactInformationOnlyExistsValidator();

        public IValidator<PartyContactInformation> Validator => new PartyContactInformationValidator();
    }
    
    /// <summary>
    /// MetaData definition for PartyCustomisedWorkflow
    /// </summary>
    [RosettaMeta(typeof(PartyCustomisedWorkflow))]
    public class PartyCustomisedWorkflowMeta : IRosettaMetaData<PartyCustomisedWorkflow>
    {
        public IEnumerable<IValidator<PartyCustomisedWorkflow>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PartyCustomisedWorkflow>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PartyCustomisedWorkflow, ISet<string>> OnlyExistsValidator => new PartyCustomisedWorkflowOnlyExistsValidator();

        public IValidator<PartyCustomisedWorkflow> Validator => new PartyCustomisedWorkflowValidator();
    }
    
    /// <summary>
    /// MetaData definition for PartyIdentifier
    /// </summary>
    [RosettaMeta(typeof(PartyIdentifier))]
    public class PartyIdentifierMeta : IRosettaMetaData<PartyIdentifier>
    {
        public IEnumerable<IValidator<PartyIdentifier>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PartyIdentifier>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PartyIdentifier, ISet<string>> OnlyExistsValidator => new PartyIdentifierOnlyExistsValidator();

        public IValidator<PartyIdentifier> Validator => new PartyIdentifierValidator();
    }
    
    /// <summary>
    /// MetaData definition for PartyReferencePayerReceiver
    /// </summary>
    [RosettaMeta(typeof(PartyReferencePayerReceiver))]
    public class PartyReferencePayerReceiverMeta : IRosettaMetaData<PartyReferencePayerReceiver>
    {
        public IEnumerable<IValidator<PartyReferencePayerReceiver>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PartyReferencePayerReceiver>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PartyReferencePayerReceiver, ISet<string>> OnlyExistsValidator => new PartyReferencePayerReceiverOnlyExistsValidator();

        public IValidator<PartyReferencePayerReceiver> Validator => new PartyReferencePayerReceiverValidator();
    }
    
    /// <summary>
    /// MetaData definition for PartyRole
    /// </summary>
    [RosettaMeta(typeof(PartyRole))]
    public class PartyRoleMeta : IRosettaMetaData<PartyRole>
    {
        public IEnumerable<IValidator<PartyRole>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PartyRole>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PartyRole, ISet<string>> OnlyExistsValidator => new PartyRoleOnlyExistsValidator();

        public IValidator<PartyRole> Validator => new PartyRoleValidator();
    }
    
    /// <summary>
    /// MetaData definition for PassThrough
    /// </summary>
    [RosettaMeta(typeof(PassThrough))]
    public class PassThroughMeta : IRosettaMetaData<PassThrough>
    {
        public IEnumerable<IValidator<PassThrough>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PassThrough>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PassThrough, ISet<string>> OnlyExistsValidator => new PassThroughOnlyExistsValidator();

        public IValidator<PassThrough> Validator => new PassThroughValidator();
    }
    
    /// <summary>
    /// MetaData definition for PassThroughItem
    /// </summary>
    [RosettaMeta(typeof(PassThroughItem))]
    public class PassThroughItemMeta : IRosettaMetaData<PassThroughItem>
    {
        public IEnumerable<IValidator<PassThroughItem>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PassThroughItem>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PassThroughItem, ISet<string>> OnlyExistsValidator => new PassThroughItemOnlyExistsValidator();

        public IValidator<PassThroughItem> Validator => new PassThroughItemValidator();
    }
    
    /// <summary>
    /// MetaData definition for PayerReceiver
    /// </summary>
    [RosettaMeta(typeof(PayerReceiver))]
    public class PayerReceiverMeta : IRosettaMetaData<PayerReceiver>
    {
        public IEnumerable<IValidator<PayerReceiver>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PayerReceiver>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PayerReceiver, ISet<string>> OnlyExistsValidator => new PayerReceiverOnlyExistsValidator();

        public IValidator<PayerReceiver> Validator => new PayerReceiverValidator();
    }
    
    /// <summary>
    /// MetaData definition for PaymentCalculationPeriod
    /// </summary>
    [RosettaMeta(typeof(PaymentCalculationPeriod))]
    public class PaymentCalculationPeriodMeta : IRosettaMetaData<PaymentCalculationPeriod>
    {
        public IEnumerable<IValidator<PaymentCalculationPeriod>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PaymentCalculationPeriod>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PaymentCalculationPeriod, ISet<string>> OnlyExistsValidator => new PaymentCalculationPeriodOnlyExistsValidator();

        public IValidator<PaymentCalculationPeriod> Validator => new PaymentCalculationPeriodValidator();
    }
    
    /// <summary>
    /// MetaData definition for PaymentDateSchedule
    /// </summary>
    [RosettaMeta(typeof(PaymentDateSchedule))]
    public class PaymentDateScheduleMeta : IRosettaMetaData<PaymentDateSchedule>
    {
        public IEnumerable<IValidator<PaymentDateSchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PaymentDateSchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PaymentDateSchedule, ISet<string>> OnlyExistsValidator => new PaymentDateScheduleOnlyExistsValidator();

        public IValidator<PaymentDateSchedule> Validator => new PaymentDateScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for PaymentDates
    /// </summary>
    [RosettaMeta(typeof(PaymentDates))]
    public class PaymentDatesMeta : IRosettaMetaData<PaymentDates>
    {
        public IEnumerable<IValidator<PaymentDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PaymentDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PaymentDates, ISet<string>> OnlyExistsValidator => new PaymentDatesOnlyExistsValidator();

        public IValidator<PaymentDates> Validator => new PaymentDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for PaymentDetail
    /// </summary>
    [RosettaMeta(typeof(PaymentDetail))]
    public class PaymentDetailMeta : IRosettaMetaData<PaymentDetail>
    {
        public IEnumerable<IValidator<PaymentDetail>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PaymentDetail>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PaymentDetail, ISet<string>> OnlyExistsValidator => new PaymentDetailOnlyExistsValidator();

        public IValidator<PaymentDetail> Validator => new PaymentDetailValidator();
    }
    
    /// <summary>
    /// MetaData definition for PaymentDiscounting
    /// </summary>
    [RosettaMeta(typeof(PaymentDiscounting))]
    public class PaymentDiscountingMeta : IRosettaMetaData<PaymentDiscounting>
    {
        public IEnumerable<IValidator<PaymentDiscounting>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PaymentDiscounting>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PaymentDiscounting, ISet<string>> OnlyExistsValidator => new PaymentDiscountingOnlyExistsValidator();

        public IValidator<PaymentDiscounting> Validator => new PaymentDiscountingValidator();
    }
    
    /// <summary>
    /// MetaData definition for PaymentRule
    /// </summary>
    [RosettaMeta(typeof(PaymentRule))]
    public class PaymentRuleMeta : IRosettaMetaData<PaymentRule>
    {
        public IEnumerable<IValidator<PaymentRule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PaymentRule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PaymentRule, ISet<string>> OnlyExistsValidator => new PaymentRuleOnlyExistsValidator();

        public IValidator<PaymentRule> Validator => new PaymentRuleValidator();
    }
    
    /// <summary>
    /// MetaData definition for Payout
    /// </summary>
    [RosettaMeta(typeof(Payout))]
    public class PayoutMeta : IRosettaMetaData<Payout>
    {
        public IEnumerable<IValidator<Payout>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Payout>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Payout, ISet<string>> OnlyExistsValidator => new PayoutOnlyExistsValidator();

        public IValidator<Payout> Validator => new PayoutValidator();
    }
    
    /// <summary>
    /// MetaData definition for PayoutBase
    /// </summary>
    [RosettaMeta(typeof(PayoutBase))]
    public class PayoutBaseMeta : IRosettaMetaData<PayoutBase>
    {
        public IEnumerable<IValidator<PayoutBase>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PayoutBase>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PayoutBase, ISet<string>> OnlyExistsValidator => new PayoutBaseOnlyExistsValidator();

        public IValidator<PayoutBase> Validator => new PayoutBaseValidator();
    }
    
    /// <summary>
    /// MetaData definition for PercentageRule
    /// </summary>
    [RosettaMeta(typeof(PercentageRule))]
    public class PercentageRuleMeta : IRosettaMetaData<PercentageRule>
    {
        public IEnumerable<IValidator<PercentageRule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PercentageRule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PercentageRule, ISet<string>> OnlyExistsValidator => new PercentageRuleOnlyExistsValidator();

        public IValidator<PercentageRule> Validator => new PercentageRuleValidator();
    }
    
    /// <summary>
    /// MetaData definition for PerformancePayout
    /// </summary>
    [RosettaMeta(typeof(PerformancePayout))]
    public class PerformancePayoutMeta : IRosettaMetaData<PerformancePayout>
    {
        public IEnumerable<IValidator<PerformancePayout>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PerformancePayout>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PerformancePayout, ISet<string>> OnlyExistsValidator => new PerformancePayoutOnlyExistsValidator();

        public IValidator<PerformancePayout> Validator => new PerformancePayoutValidator();
    }
    
    /// <summary>
    /// MetaData definition for PerformanceValuationDates
    /// </summary>
    [RosettaMeta(typeof(PerformanceValuationDates))]
    public class PerformanceValuationDatesMeta : IRosettaMetaData<PerformanceValuationDates>
    {
        public IEnumerable<IValidator<PerformanceValuationDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PerformanceValuationDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PerformanceValuationDates, ISet<string>> OnlyExistsValidator => new PerformanceValuationDatesOnlyExistsValidator();

        public IValidator<PerformanceValuationDates> Validator => new PerformanceValuationDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for Period
    /// </summary>
    [RosettaMeta(typeof(Period))]
    public class PeriodMeta : IRosettaMetaData<Period>
    {
        public IEnumerable<IValidator<Period>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Period>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Period, ISet<string>> OnlyExistsValidator => new PeriodOnlyExistsValidator();

        public IValidator<Period> Validator => new PeriodValidator();
    }
    
    /// <summary>
    /// MetaData definition for PeriodBound
    /// </summary>
    [RosettaMeta(typeof(PeriodBound))]
    public class PeriodBoundMeta : IRosettaMetaData<PeriodBound>
    {
        public IEnumerable<IValidator<PeriodBound>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PeriodBound>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PeriodBound, ISet<string>> OnlyExistsValidator => new PeriodBoundOnlyExistsValidator();

        public IValidator<PeriodBound> Validator => new PeriodBoundValidator();
    }
    
    /// <summary>
    /// MetaData definition for PeriodRange
    /// </summary>
    [RosettaMeta(typeof(PeriodRange))]
    public class PeriodRangeMeta : IRosettaMetaData<PeriodRange>
    {
        public IEnumerable<IValidator<PeriodRange>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PeriodRange>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PeriodRange, ISet<string>> OnlyExistsValidator => new PeriodRangeOnlyExistsValidator();

        public IValidator<PeriodRange> Validator => new PeriodRangeValidator();
    }
    
    /// <summary>
    /// MetaData definition for PeriodicDates
    /// </summary>
    [RosettaMeta(typeof(PeriodicDates))]
    public class PeriodicDatesMeta : IRosettaMetaData<PeriodicDates>
    {
        public IEnumerable<IValidator<PeriodicDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PeriodicDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PeriodicDates, ISet<string>> OnlyExistsValidator => new PeriodicDatesOnlyExistsValidator();

        public IValidator<PeriodicDates> Validator => new PeriodicDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for PersonIdentifier
    /// </summary>
    [RosettaMeta(typeof(PersonIdentifier))]
    public class PersonIdentifierMeta : IRosettaMetaData<PersonIdentifier>
    {
        public IEnumerable<IValidator<PersonIdentifier>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PersonIdentifier>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PersonIdentifier, ISet<string>> OnlyExistsValidator => new PersonIdentifierOnlyExistsValidator();

        public IValidator<PersonIdentifier> Validator => new PersonIdentifierValidator();
    }
    
    /// <summary>
    /// MetaData definition for PhysicalSettlementPeriod
    /// </summary>
    [RosettaMeta(typeof(PhysicalSettlementPeriod))]
    public class PhysicalSettlementPeriodMeta : IRosettaMetaData<PhysicalSettlementPeriod>
    {
        public IEnumerable<IValidator<PhysicalSettlementPeriod>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PhysicalSettlementPeriod>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PhysicalSettlementPeriod, ISet<string>> OnlyExistsValidator => new PhysicalSettlementPeriodOnlyExistsValidator();

        public IValidator<PhysicalSettlementPeriod> Validator => new PhysicalSettlementPeriodValidator();
    }
    
    /// <summary>
    /// MetaData definition for PhysicalSettlementTerms
    /// </summary>
    [RosettaMeta(typeof(PhysicalSettlementTerms))]
    public class PhysicalSettlementTermsMeta : IRosettaMetaData<PhysicalSettlementTerms>
    {
        public IEnumerable<IValidator<PhysicalSettlementTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PhysicalSettlementTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PhysicalSettlementTerms, ISet<string>> OnlyExistsValidator => new PhysicalSettlementTermsOnlyExistsValidator();

        public IValidator<PhysicalSettlementTerms> Validator => new PhysicalSettlementTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for Portfolio
    /// </summary>
    [RosettaMeta(typeof(Portfolio))]
    public class PortfolioMeta : IRosettaMetaData<Portfolio>
    {
        public IEnumerable<IValidator<Portfolio>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Portfolio>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Portfolio, ISet<string>> OnlyExistsValidator => new PortfolioOnlyExistsValidator();

        public IValidator<Portfolio> Validator => new PortfolioValidator();
    }
    
    /// <summary>
    /// MetaData definition for PortfolioReturnTerms
    /// </summary>
    [RosettaMeta(typeof(PortfolioReturnTerms))]
    public class PortfolioReturnTermsMeta : IRosettaMetaData<PortfolioReturnTerms>
    {
        public IEnumerable<IValidator<PortfolioReturnTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PortfolioReturnTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PortfolioReturnTerms, ISet<string>> OnlyExistsValidator => new PortfolioReturnTermsOnlyExistsValidator();

        public IValidator<PortfolioReturnTerms> Validator => new PortfolioReturnTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for PortfolioState
    /// </summary>
    [RosettaMeta(typeof(PortfolioState))]
    public class PortfolioStateMeta : IRosettaMetaData<PortfolioState>
    {
        public IEnumerable<IValidator<PortfolioState>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PortfolioState>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PortfolioState, ISet<string>> OnlyExistsValidator => new PortfolioStateOnlyExistsValidator();

        public IValidator<PortfolioState> Validator => new PortfolioStateValidator();
    }
    
    /// <summary>
    /// MetaData definition for Position
    /// </summary>
    [RosettaMeta(typeof(Position))]
    public class PositionMeta : IRosettaMetaData<Position>
    {
        public IEnumerable<IValidator<Position>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Position>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Position, ISet<string>> OnlyExistsValidator => new PositionOnlyExistsValidator();

        public IValidator<Position> Validator => new PositionValidator();
    }
    
    /// <summary>
    /// MetaData definition for PositionIdentifier
    /// </summary>
    [RosettaMeta(typeof(PositionIdentifier))]
    public class PositionIdentifierMeta : IRosettaMetaData<PositionIdentifier>
    {
        public IEnumerable<IValidator<PositionIdentifier>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PositionIdentifier>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PositionIdentifier, ISet<string>> OnlyExistsValidator => new PositionIdentifierOnlyExistsValidator();

        public IValidator<PositionIdentifier> Validator => new PositionIdentifierValidator();
    }
    
    /// <summary>
    /// MetaData definition for PremiumExpression
    /// </summary>
    [RosettaMeta(typeof(PremiumExpression))]
    public class PremiumExpressionMeta : IRosettaMetaData<PremiumExpression>
    {
        public IEnumerable<IValidator<PremiumExpression>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PremiumExpression>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PremiumExpression, ISet<string>> OnlyExistsValidator => new PremiumExpressionOnlyExistsValidator();

        public IValidator<PremiumExpression> Validator => new PremiumExpressionValidator();
    }
    
    /// <summary>
    /// MetaData definition for Pric
    /// </summary>
    [RosettaMeta(typeof(Pric))]
    public class PricMeta : IRosettaMetaData<Pric>
    {
        public IEnumerable<IValidator<Pric>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Pric>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Pric, ISet<string>> OnlyExistsValidator => new PricOnlyExistsValidator();

        public IValidator<Pric> Validator => new PricValidator();
    }
    
    /// <summary>
    /// MetaData definition for Price
    /// </summary>
    [RosettaMeta(typeof(Price))]
    public class PriceMeta : IRosettaMetaData<Price>
    {
        public IEnumerable<IValidator<Price>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Price>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Price, ISet<string>> OnlyExistsValidator => new PriceOnlyExistsValidator();

        public IValidator<Price> Validator => new PriceValidator();
    }
    
    /// <summary>
    /// MetaData definition for PriceComposite
    /// </summary>
    [RosettaMeta(typeof(PriceComposite))]
    public class PriceCompositeMeta : IRosettaMetaData<PriceComposite>
    {
        public IEnumerable<IValidator<PriceComposite>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PriceComposite>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PriceComposite, ISet<string>> OnlyExistsValidator => new PriceCompositeOnlyExistsValidator();

        public IValidator<PriceComposite> Validator => new PriceCompositeValidator();
    }
    
    /// <summary>
    /// MetaData definition for PriceQuantity
    /// </summary>
    [RosettaMeta(typeof(PriceQuantity))]
    public class PriceQuantityMeta : IRosettaMetaData<PriceQuantity>
    {
        public IEnumerable<IValidator<PriceQuantity>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PriceQuantity>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PriceQuantity, ISet<string>> OnlyExistsValidator => new PriceQuantityOnlyExistsValidator();

        public IValidator<PriceQuantity> Validator => new PriceQuantityValidator();
    }
    
    /// <summary>
    /// MetaData definition for PriceReturnTerms
    /// </summary>
    [RosettaMeta(typeof(PriceReturnTerms))]
    public class PriceReturnTermsMeta : IRosettaMetaData<PriceReturnTerms>
    {
        public IEnumerable<IValidator<PriceReturnTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PriceReturnTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PriceReturnTerms, ISet<string>> OnlyExistsValidator => new PriceReturnTermsOnlyExistsValidator();

        public IValidator<PriceReturnTerms> Validator => new PriceReturnTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for PriceSchedule
    /// </summary>
    [RosettaMeta(typeof(PriceSchedule))]
    public class PriceScheduleMeta : IRosettaMetaData<PriceSchedule>
    {
        public IEnumerable<IValidator<PriceSchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PriceSchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PriceSchedule, ISet<string>> OnlyExistsValidator => new PriceScheduleOnlyExistsValidator();

        public IValidator<PriceSchedule> Validator => new PriceScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for PriceSource
    /// </summary>
    [RosettaMeta(typeof(PriceSource))]
    public class PriceSourceMeta : IRosettaMetaData<PriceSource>
    {
        public IEnumerable<IValidator<PriceSource>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PriceSource>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PriceSource, ISet<string>> OnlyExistsValidator => new PriceSourceOnlyExistsValidator();

        public IValidator<PriceSource> Validator => new PriceSourceValidator();
    }
    
    /// <summary>
    /// MetaData definition for PriceSourceDisruption
    /// </summary>
    [RosettaMeta(typeof(PriceSourceDisruption))]
    public class PriceSourceDisruptionMeta : IRosettaMetaData<PriceSourceDisruption>
    {
        public IEnumerable<IValidator<PriceSourceDisruption>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PriceSourceDisruption>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PriceSourceDisruption, ISet<string>> OnlyExistsValidator => new PriceSourceDisruptionOnlyExistsValidator();

        public IValidator<PriceSourceDisruption> Validator => new PriceSourceDisruptionValidator();
    }
    
    /// <summary>
    /// MetaData definition for PricingDates
    /// </summary>
    [RosettaMeta(typeof(PricingDates))]
    public class PricingDatesMeta : IRosettaMetaData<PricingDates>
    {
        public IEnumerable<IValidator<PricingDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PricingDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PricingDates, ISet<string>> OnlyExistsValidator => new PricingDatesOnlyExistsValidator();

        public IValidator<PricingDates> Validator => new PricingDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for PrimitiveInstruction
    /// </summary>
    [RosettaMeta(typeof(PrimitiveInstruction))]
    public class PrimitiveInstructionMeta : IRosettaMetaData<PrimitiveInstruction>
    {
        public IEnumerable<IValidator<PrimitiveInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PrimitiveInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PrimitiveInstruction, ISet<string>> OnlyExistsValidator => new PrimitiveInstructionOnlyExistsValidator();

        public IValidator<PrimitiveInstruction> Validator => new PrimitiveInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for PrincipalPayment
    /// </summary>
    [RosettaMeta(typeof(PrincipalPayment))]
    public class PrincipalPaymentMeta : IRosettaMetaData<PrincipalPayment>
    {
        public IEnumerable<IValidator<PrincipalPayment>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PrincipalPayment>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PrincipalPayment, ISet<string>> OnlyExistsValidator => new PrincipalPaymentOnlyExistsValidator();

        public IValidator<PrincipalPayment> Validator => new PrincipalPaymentValidator();
    }
    
    /// <summary>
    /// MetaData definition for PrincipalPaymentSchedule
    /// </summary>
    [RosettaMeta(typeof(PrincipalPaymentSchedule))]
    public class PrincipalPaymentScheduleMeta : IRosettaMetaData<PrincipalPaymentSchedule>
    {
        public IEnumerable<IValidator<PrincipalPaymentSchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PrincipalPaymentSchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PrincipalPaymentSchedule, ISet<string>> OnlyExistsValidator => new PrincipalPaymentScheduleOnlyExistsValidator();

        public IValidator<PrincipalPaymentSchedule> Validator => new PrincipalPaymentScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for PrincipalPayments
    /// </summary>
    [RosettaMeta(typeof(PrincipalPayments))]
    public class PrincipalPaymentsMeta : IRosettaMetaData<PrincipalPayments>
    {
        public IEnumerable<IValidator<PrincipalPayments>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PrincipalPayments>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PrincipalPayments, ISet<string>> OnlyExistsValidator => new PrincipalPaymentsOnlyExistsValidator();

        public IValidator<PrincipalPayments> Validator => new PrincipalPaymentsValidator();
    }
    
    /// <summary>
    /// MetaData definition for Product
    /// </summary>
    [RosettaMeta(typeof(Product))]
    public class ProductMeta : IRosettaMetaData<Product>
    {
        public IEnumerable<IValidator<Product>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Product>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Product, ISet<string>> OnlyExistsValidator => new ProductOnlyExistsValidator();

        public IValidator<Product> Validator => new ProductValidator();
    }
    
    /// <summary>
    /// MetaData definition for ProductIdentifier
    /// </summary>
    [RosettaMeta(typeof(ProductIdentifier))]
    public class ProductIdentifierMeta : IRosettaMetaData<ProductIdentifier>
    {
        public IEnumerable<IValidator<ProductIdentifier>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ProductIdentifier>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ProductIdentifier, ISet<string>> OnlyExistsValidator => new ProductIdentifierOnlyExistsValidator();

        public IValidator<ProductIdentifier> Validator => new ProductIdentifierValidator();
    }
    
    /// <summary>
    /// MetaData definition for ProductTaxonomy
    /// </summary>
    [RosettaMeta(typeof(ProductTaxonomy))]
    public class ProductTaxonomyMeta : IRosettaMetaData<ProductTaxonomy>
    {
        public IEnumerable<IValidator<ProductTaxonomy>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ProductTaxonomy>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ProductTaxonomy, ISet<string>> OnlyExistsValidator => new ProductTaxonomyOnlyExistsValidator();

        public IValidator<ProductTaxonomy> Validator => new ProductTaxonomyValidator();
    }
    
    /// <summary>
    /// MetaData definition for ProtectionTerms
    /// </summary>
    [RosettaMeta(typeof(ProtectionTerms))]
    public class ProtectionTermsMeta : IRosettaMetaData<ProtectionTerms>
    {
        public IEnumerable<IValidator<ProtectionTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ProtectionTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ProtectionTerms, ISet<string>> OnlyExistsValidator => new ProtectionTermsOnlyExistsValidator();

        public IValidator<ProtectionTerms> Validator => new ProtectionTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for Prsn
    /// </summary>
    [RosettaMeta(typeof(Prsn))]
    public class PrsnMeta : IRosettaMetaData<Prsn>
    {
        public IEnumerable<IValidator<Prsn>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Prsn>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Prsn, ISet<string>> OnlyExistsValidator => new PrsnOnlyExistsValidator();

        public IValidator<Prsn> Validator => new PrsnValidator();
    }
    
    /// <summary>
    /// MetaData definition for PubliclyAvailableInformation
    /// </summary>
    [RosettaMeta(typeof(PubliclyAvailableInformation))]
    public class PubliclyAvailableInformationMeta : IRosettaMetaData<PubliclyAvailableInformation>
    {
        public IEnumerable<IValidator<PubliclyAvailableInformation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<PubliclyAvailableInformation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<PubliclyAvailableInformation, ISet<string>> OnlyExistsValidator => new PubliclyAvailableInformationOnlyExistsValidator();

        public IValidator<PubliclyAvailableInformation> Validator => new PubliclyAvailableInformationValidator();
    }
    
    /// <summary>
    /// MetaData definition for Qty
    /// </summary>
    [RosettaMeta(typeof(Qty))]
    public class QtyMeta : IRosettaMetaData<Qty>
    {
        public IEnumerable<IValidator<Qty>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Qty>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Qty, ISet<string>> OnlyExistsValidator => new QtyOnlyExistsValidator();

        public IValidator<Qty> Validator => new QtyValidator();
    }
    
    /// <summary>
    /// MetaData definition for Quantity
    /// </summary>
    [RosettaMeta(typeof(Quantity))]
    public class QuantityMeta : IRosettaMetaData<Quantity>
    {
        public IEnumerable<IValidator<Quantity>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Quantity>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Quantity, ISet<string>> OnlyExistsValidator => new QuantityOnlyExistsValidator();

        public IValidator<Quantity> Validator => new QuantityValidator();
    }
    
    /// <summary>
    /// MetaData definition for QuantityChangeInstruction
    /// </summary>
    [RosettaMeta(typeof(QuantityChangeInstruction))]
    public class QuantityChangeInstructionMeta : IRosettaMetaData<QuantityChangeInstruction>
    {
        public IEnumerable<IValidator<QuantityChangeInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<QuantityChangeInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<QuantityChangeInstruction, ISet<string>> OnlyExistsValidator => new QuantityChangeInstructionOnlyExistsValidator();

        public IValidator<QuantityChangeInstruction> Validator => new QuantityChangeInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for QuantityMultiplier
    /// </summary>
    [RosettaMeta(typeof(QuantityMultiplier))]
    public class QuantityMultiplierMeta : IRosettaMetaData<QuantityMultiplier>
    {
        public IEnumerable<IValidator<QuantityMultiplier>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<QuantityMultiplier>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<QuantityMultiplier, ISet<string>> OnlyExistsValidator => new QuantityMultiplierOnlyExistsValidator();

        public IValidator<QuantityMultiplier> Validator => new QuantityMultiplierValidator();
    }
    
    /// <summary>
    /// MetaData definition for QuantitySchedule
    /// </summary>
    [RosettaMeta(typeof(QuantitySchedule))]
    public class QuantityScheduleMeta : IRosettaMetaData<QuantitySchedule>
    {
        public IEnumerable<IValidator<QuantitySchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<QuantitySchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<QuantitySchedule, ISet<string>> OnlyExistsValidator => new QuantityScheduleOnlyExistsValidator();

        public IValidator<QuantitySchedule> Validator => new QuantityScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for Quanto
    /// </summary>
    [RosettaMeta(typeof(Quanto))]
    public class QuantoMeta : IRosettaMetaData<Quanto>
    {
        public IEnumerable<IValidator<Quanto>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Quanto>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Quanto, ISet<string>> OnlyExistsValidator => new QuantoOnlyExistsValidator();

        public IValidator<Quanto> Validator => new QuantoValidator();
    }
    
    /// <summary>
    /// MetaData definition for QuasiGovernmentIssuerType
    /// </summary>
    [RosettaMeta(typeof(QuasiGovernmentIssuerType))]
    public class QuasiGovernmentIssuerTypeMeta : IRosettaMetaData<QuasiGovernmentIssuerType>
    {
        public IEnumerable<IValidator<QuasiGovernmentIssuerType>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<QuasiGovernmentIssuerType>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<QuasiGovernmentIssuerType, ISet<string>> OnlyExistsValidator => new QuasiGovernmentIssuerTypeOnlyExistsValidator();

        public IValidator<QuasiGovernmentIssuerType> Validator => new QuasiGovernmentIssuerTypeValidator();
    }
    
    /// <summary>
    /// MetaData definition for QuotedCurrencyPair
    /// </summary>
    [RosettaMeta(typeof(QuotedCurrencyPair))]
    public class QuotedCurrencyPairMeta : IRosettaMetaData<QuotedCurrencyPair>
    {
        public IEnumerable<IValidator<QuotedCurrencyPair>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<QuotedCurrencyPair>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<QuotedCurrencyPair, ISet<string>> OnlyExistsValidator => new QuotedCurrencyPairOnlyExistsValidator();

        public IValidator<QuotedCurrencyPair> Validator => new QuotedCurrencyPairValidator();
    }
    
    /// <summary>
    /// MetaData definition for RateObservation
    /// </summary>
    [RosettaMeta(typeof(RateObservation))]
    public class RateObservationMeta : IRosettaMetaData<RateObservation>
    {
        public IEnumerable<IValidator<RateObservation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<RateObservation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<RateObservation, ISet<string>> OnlyExistsValidator => new RateObservationOnlyExistsValidator();

        public IValidator<RateObservation> Validator => new RateObservationValidator();
    }
    
    /// <summary>
    /// MetaData definition for RateSchedule
    /// </summary>
    [RosettaMeta(typeof(RateSchedule))]
    public class RateScheduleMeta : IRosettaMetaData<RateSchedule>
    {
        public IEnumerable<IValidator<RateSchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<RateSchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<RateSchedule, ISet<string>> OnlyExistsValidator => new RateScheduleOnlyExistsValidator();

        public IValidator<RateSchedule> Validator => new RateScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for RateSpecification
    /// </summary>
    [RosettaMeta(typeof(RateSpecification))]
    public class RateSpecificationMeta : IRosettaMetaData<RateSpecification>
    {
        public IEnumerable<IValidator<RateSpecification>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<RateSpecification>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<RateSpecification, ISet<string>> OnlyExistsValidator => new RateSpecificationOnlyExistsValidator();

        public IValidator<RateSpecification> Validator => new RateSpecificationValidator();
    }
    
    /// <summary>
    /// MetaData definition for RefRate
    /// </summary>
    [RosettaMeta(typeof(RefRate))]
    public class RefRateMeta : IRosettaMetaData<RefRate>
    {
        public IEnumerable<IValidator<RefRate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<RefRate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<RefRate, ISet<string>> OnlyExistsValidator => new RefRateOnlyExistsValidator();

        public IValidator<RefRate> Validator => new RefRateValidator();
    }
    
    /// <summary>
    /// MetaData definition for ReferenceBank
    /// </summary>
    [RosettaMeta(typeof(ReferenceBank))]
    public class ReferenceBankMeta : IRosettaMetaData<ReferenceBank>
    {
        public IEnumerable<IValidator<ReferenceBank>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ReferenceBank>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ReferenceBank, ISet<string>> OnlyExistsValidator => new ReferenceBankOnlyExistsValidator();

        public IValidator<ReferenceBank> Validator => new ReferenceBankValidator();
    }
    
    /// <summary>
    /// MetaData definition for ReferenceBanks
    /// </summary>
    [RosettaMeta(typeof(ReferenceBanks))]
    public class ReferenceBanksMeta : IRosettaMetaData<ReferenceBanks>
    {
        public IEnumerable<IValidator<ReferenceBanks>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ReferenceBanks>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ReferenceBanks, ISet<string>> OnlyExistsValidator => new ReferenceBanksOnlyExistsValidator();

        public IValidator<ReferenceBanks> Validator => new ReferenceBanksValidator();
    }
    
    /// <summary>
    /// MetaData definition for ReferenceInformation
    /// </summary>
    [RosettaMeta(typeof(ReferenceInformation))]
    public class ReferenceInformationMeta : IRosettaMetaData<ReferenceInformation>
    {
        public IEnumerable<IValidator<ReferenceInformation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ReferenceInformation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ReferenceInformation, ISet<string>> OnlyExistsValidator => new ReferenceInformationOnlyExistsValidator();

        public IValidator<ReferenceInformation> Validator => new ReferenceInformationValidator();
    }
    
    /// <summary>
    /// MetaData definition for ReferenceObligation
    /// </summary>
    [RosettaMeta(typeof(ReferenceObligation))]
    public class ReferenceObligationMeta : IRosettaMetaData<ReferenceObligation>
    {
        public IEnumerable<IValidator<ReferenceObligation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ReferenceObligation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ReferenceObligation, ISet<string>> OnlyExistsValidator => new ReferenceObligationOnlyExistsValidator();

        public IValidator<ReferenceObligation> Validator => new ReferenceObligationValidator();
    }
    
    /// <summary>
    /// MetaData definition for ReferencePair
    /// </summary>
    [RosettaMeta(typeof(ReferencePair))]
    public class ReferencePairMeta : IRosettaMetaData<ReferencePair>
    {
        public IEnumerable<IValidator<ReferencePair>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ReferencePair>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ReferencePair, ISet<string>> OnlyExistsValidator => new ReferencePairOnlyExistsValidator();

        public IValidator<ReferencePair> Validator => new ReferencePairValidator();
    }
    
    /// <summary>
    /// MetaData definition for ReferencePool
    /// </summary>
    [RosettaMeta(typeof(ReferencePool))]
    public class ReferencePoolMeta : IRosettaMetaData<ReferencePool>
    {
        public IEnumerable<IValidator<ReferencePool>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ReferencePool>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ReferencePool, ISet<string>> OnlyExistsValidator => new ReferencePoolOnlyExistsValidator();

        public IValidator<ReferencePool> Validator => new ReferencePoolValidator();
    }
    
    /// <summary>
    /// MetaData definition for ReferencePoolItem
    /// </summary>
    [RosettaMeta(typeof(ReferencePoolItem))]
    public class ReferencePoolItemMeta : IRosettaMetaData<ReferencePoolItem>
    {
        public IEnumerable<IValidator<ReferencePoolItem>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ReferencePoolItem>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ReferencePoolItem, ISet<string>> OnlyExistsValidator => new ReferencePoolItemOnlyExistsValidator();

        public IValidator<ReferencePoolItem> Validator => new ReferencePoolItemValidator();
    }
    
    /// <summary>
    /// MetaData definition for ReferenceSwapCurve
    /// </summary>
    [RosettaMeta(typeof(ReferenceSwapCurve))]
    public class ReferenceSwapCurveMeta : IRosettaMetaData<ReferenceSwapCurve>
    {
        public IEnumerable<IValidator<ReferenceSwapCurve>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ReferenceSwapCurve>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ReferenceSwapCurve, ISet<string>> OnlyExistsValidator => new ReferenceSwapCurveOnlyExistsValidator();

        public IValidator<ReferenceSwapCurve> Validator => new ReferenceSwapCurveValidator();
    }
    
    /// <summary>
    /// MetaData definition for RegionalGovernmentIssuerType
    /// </summary>
    [RosettaMeta(typeof(RegionalGovernmentIssuerType))]
    public class RegionalGovernmentIssuerTypeMeta : IRosettaMetaData<RegionalGovernmentIssuerType>
    {
        public IEnumerable<IValidator<RegionalGovernmentIssuerType>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<RegionalGovernmentIssuerType>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<RegionalGovernmentIssuerType, ISet<string>> OnlyExistsValidator => new RegionalGovernmentIssuerTypeOnlyExistsValidator();

        public IValidator<RegionalGovernmentIssuerType> Validator => new RegionalGovernmentIssuerTypeValidator();
    }
    
    /// <summary>
    /// MetaData definition for RelatedParty
    /// </summary>
    [RosettaMeta(typeof(RelatedParty))]
    public class RelatedPartyMeta : IRosettaMetaData<RelatedParty>
    {
        public IEnumerable<IValidator<RelatedParty>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<RelatedParty>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<RelatedParty, ISet<string>> OnlyExistsValidator => new RelatedPartyOnlyExistsValidator();

        public IValidator<RelatedParty> Validator => new RelatedPartyValidator();
    }
    
    /// <summary>
    /// MetaData definition for RelativeDateOffset
    /// </summary>
    [RosettaMeta(typeof(RelativeDateOffset))]
    public class RelativeDateOffsetMeta : IRosettaMetaData<RelativeDateOffset>
    {
        public IEnumerable<IValidator<RelativeDateOffset>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<RelativeDateOffset>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<RelativeDateOffset, ISet<string>> OnlyExistsValidator => new RelativeDateOffsetOnlyExistsValidator();

        public IValidator<RelativeDateOffset> Validator => new RelativeDateOffsetValidator();
    }
    
    /// <summary>
    /// MetaData definition for RelativeDates
    /// </summary>
    [RosettaMeta(typeof(RelativeDates))]
    public class RelativeDatesMeta : IRosettaMetaData<RelativeDates>
    {
        public IEnumerable<IValidator<RelativeDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<RelativeDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<RelativeDates, ISet<string>> OnlyExistsValidator => new RelativeDatesOnlyExistsValidator();

        public IValidator<RelativeDates> Validator => new RelativeDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for Representations
    /// </summary>
    [RosettaMeta(typeof(Representations))]
    public class RepresentationsMeta : IRosettaMetaData<Representations>
    {
        public IEnumerable<IValidator<Representations>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Representations>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Representations, ISet<string>> OnlyExistsValidator => new RepresentationsOnlyExistsValidator();

        public IValidator<Representations> Validator => new RepresentationsValidator();
    }
    
    /// <summary>
    /// MetaData definition for Reset
    /// </summary>
    [RosettaMeta(typeof(Reset))]
    public class ResetMeta : IRosettaMetaData<Reset>
    {
        public IEnumerable<IValidator<Reset>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Reset>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Reset, ISet<string>> OnlyExistsValidator => new ResetOnlyExistsValidator();

        public IValidator<Reset> Validator => new ResetValidator();
    }
    
    /// <summary>
    /// MetaData definition for ResetDates
    /// </summary>
    [RosettaMeta(typeof(ResetDates))]
    public class ResetDatesMeta : IRosettaMetaData<ResetDates>
    {
        public IEnumerable<IValidator<ResetDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ResetDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ResetDates, ISet<string>> OnlyExistsValidator => new ResetDatesOnlyExistsValidator();

        public IValidator<ResetDates> Validator => new ResetDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for ResetFrequency
    /// </summary>
    [RosettaMeta(typeof(ResetFrequency))]
    public class ResetFrequencyMeta : IRosettaMetaData<ResetFrequency>
    {
        public IEnumerable<IValidator<ResetFrequency>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ResetFrequency>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ResetFrequency, ISet<string>> OnlyExistsValidator => new ResetFrequencyOnlyExistsValidator();

        public IValidator<ResetFrequency> Validator => new ResetFrequencyValidator();
    }
    
    /// <summary>
    /// MetaData definition for ResetInstruction
    /// </summary>
    [RosettaMeta(typeof(ResetInstruction))]
    public class ResetInstructionMeta : IRosettaMetaData<ResetInstruction>
    {
        public IEnumerable<IValidator<ResetInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ResetInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ResetInstruction, ISet<string>> OnlyExistsValidator => new ResetInstructionOnlyExistsValidator();

        public IValidator<ResetInstruction> Validator => new ResetInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for ResolvablePriceQuantity
    /// </summary>
    [RosettaMeta(typeof(ResolvablePriceQuantity))]
    public class ResolvablePriceQuantityMeta : IRosettaMetaData<ResolvablePriceQuantity>
    {
        public IEnumerable<IValidator<ResolvablePriceQuantity>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ResolvablePriceQuantity>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ResolvablePriceQuantity, ISet<string>> OnlyExistsValidator => new ResolvablePriceQuantityOnlyExistsValidator();

        public IValidator<ResolvablePriceQuantity> Validator => new ResolvablePriceQuantityValidator();
    }
    
    /// <summary>
    /// MetaData definition for Resource
    /// </summary>
    [RosettaMeta(typeof(Resource))]
    public class ResourceMeta : IRosettaMetaData<Resource>
    {
        public IEnumerable<IValidator<Resource>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Resource>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Resource, ISet<string>> OnlyExistsValidator => new ResourceOnlyExistsValidator();

        public IValidator<Resource> Validator => new ResourceValidator();
    }
    
    /// <summary>
    /// MetaData definition for ResourceLength
    /// </summary>
    [RosettaMeta(typeof(ResourceLength))]
    public class ResourceLengthMeta : IRosettaMetaData<ResourceLength>
    {
        public IEnumerable<IValidator<ResourceLength>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ResourceLength>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ResourceLength, ISet<string>> OnlyExistsValidator => new ResourceLengthOnlyExistsValidator();

        public IValidator<ResourceLength> Validator => new ResourceLengthValidator();
    }
    
    /// <summary>
    /// MetaData definition for Restructuring
    /// </summary>
    [RosettaMeta(typeof(Restructuring))]
    public class RestructuringMeta : IRosettaMetaData<Restructuring>
    {
        public IEnumerable<IValidator<Restructuring>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Restructuring>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Restructuring, ISet<string>> OnlyExistsValidator => new RestructuringOnlyExistsValidator();

        public IValidator<Restructuring> Validator => new RestructuringValidator();
    }
    
    /// <summary>
    /// MetaData definition for ReturnAmount
    /// </summary>
    [RosettaMeta(typeof(ReturnAmount))]
    public class ReturnAmountMeta : IRosettaMetaData<ReturnAmount>
    {
        public IEnumerable<IValidator<ReturnAmount>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ReturnAmount>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ReturnAmount, ISet<string>> OnlyExistsValidator => new ReturnAmountOnlyExistsValidator();

        public IValidator<ReturnAmount> Validator => new ReturnAmountValidator();
    }
    
    /// <summary>
    /// MetaData definition for ReturnInstruction
    /// </summary>
    [RosettaMeta(typeof(ReturnInstruction))]
    public class ReturnInstructionMeta : IRosettaMetaData<ReturnInstruction>
    {
        public IEnumerable<IValidator<ReturnInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ReturnInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ReturnInstruction, ISet<string>> OnlyExistsValidator => new ReturnInstructionOnlyExistsValidator();

        public IValidator<ReturnInstruction> Validator => new ReturnInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for ReturnTerms
    /// </summary>
    [RosettaMeta(typeof(ReturnTerms))]
    public class ReturnTermsMeta : IRosettaMetaData<ReturnTerms>
    {
        public IEnumerable<IValidator<ReturnTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ReturnTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ReturnTerms, ISet<string>> OnlyExistsValidator => new ReturnTermsOnlyExistsValidator();

        public IValidator<ReturnTerms> Validator => new ReturnTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for ReturnTermsBase
    /// </summary>
    [RosettaMeta(typeof(ReturnTermsBase))]
    public class ReturnTermsBaseMeta : IRosettaMetaData<ReturnTermsBase>
    {
        public IEnumerable<IValidator<ReturnTermsBase>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ReturnTermsBase>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ReturnTermsBase, ISet<string>> OnlyExistsValidator => new ReturnTermsBaseOnlyExistsValidator();

        public IValidator<ReturnTermsBase> Validator => new ReturnTermsBaseValidator();
    }
    
    /// <summary>
    /// MetaData definition for RollFeature
    /// </summary>
    [RosettaMeta(typeof(RollFeature))]
    public class RollFeatureMeta : IRosettaMetaData<RollFeature>
    {
        public IEnumerable<IValidator<RollFeature>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<RollFeature>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<RollFeature, ISet<string>> OnlyExistsValidator => new RollFeatureOnlyExistsValidator();

        public IValidator<RollFeature> Validator => new RollFeatureValidator();
    }
    
    /// <summary>
    /// MetaData definition for Rounding
    /// </summary>
    [RosettaMeta(typeof(Rounding))]
    public class RoundingMeta : IRosettaMetaData<Rounding>
    {
        public IEnumerable<IValidator<Rounding>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Rounding>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Rounding, ISet<string>> OnlyExistsValidator => new RoundingOnlyExistsValidator();

        public IValidator<Rounding> Validator => new RoundingValidator();
    }
    
    /// <summary>
    /// MetaData definition for Schedule
    /// </summary>
    [RosettaMeta(typeof(Schedule))]
    public class ScheduleMeta : IRosettaMetaData<Schedule>
    {
        public IEnumerable<IValidator<Schedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Schedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Schedule, ISet<string>> OnlyExistsValidator => new ScheduleOnlyExistsValidator();

        public IValidator<Schedule> Validator => new ScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for SchedulePeriod
    /// </summary>
    [RosettaMeta(typeof(SchedulePeriod))]
    public class SchedulePeriodMeta : IRosettaMetaData<SchedulePeriod>
    {
        public IEnumerable<IValidator<SchedulePeriod>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SchedulePeriod>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SchedulePeriod, ISet<string>> OnlyExistsValidator => new SchedulePeriodOnlyExistsValidator();

        public IValidator<SchedulePeriod> Validator => new SchedulePeriodValidator();
    }
    
    /// <summary>
    /// MetaData definition for ScheduledTransfer
    /// </summary>
    [RosettaMeta(typeof(ScheduledTransfer))]
    public class ScheduledTransferMeta : IRosettaMetaData<ScheduledTransfer>
    {
        public IEnumerable<IValidator<ScheduledTransfer>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ScheduledTransfer>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ScheduledTransfer, ISet<string>> OnlyExistsValidator => new ScheduledTransferOnlyExistsValidator();

        public IValidator<ScheduledTransfer> Validator => new ScheduledTransferValidator();
    }
    
    /// <summary>
    /// MetaData definition for SchmeNm
    /// </summary>
    [RosettaMeta(typeof(SchmeNm))]
    public class SchmeNmMeta : IRosettaMetaData<SchmeNm>
    {
        public IEnumerable<IValidator<SchmeNm>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SchmeNm>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SchmeNm, ISet<string>> OnlyExistsValidator => new SchmeNmOnlyExistsValidator();

        public IValidator<SchmeNm> Validator => new SchmeNmValidator();
    }
    
    /// <summary>
    /// MetaData definition for Security
    /// </summary>
    [RosettaMeta(typeof(Security))]
    public class SecurityMeta : IRosettaMetaData<Security>
    {
        public IEnumerable<IValidator<Security>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Security>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Security, ISet<string>> OnlyExistsValidator => new SecurityOnlyExistsValidator();

        public IValidator<Security> Validator => new SecurityValidator();
    }
    
    /// <summary>
    /// MetaData definition for SecurityAgreementElections
    /// </summary>
    [RosettaMeta(typeof(SecurityAgreementElections))]
    public class SecurityAgreementElectionsMeta : IRosettaMetaData<SecurityAgreementElections>
    {
        public IEnumerable<IValidator<SecurityAgreementElections>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SecurityAgreementElections>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SecurityAgreementElections, ISet<string>> OnlyExistsValidator => new SecurityAgreementElectionsOnlyExistsValidator();

        public IValidator<SecurityAgreementElections> Validator => new SecurityAgreementElectionsValidator();
    }
    
    /// <summary>
    /// MetaData definition for SecurityLendingInvoice
    /// </summary>
    [RosettaMeta(typeof(SecurityLendingInvoice))]
    public class SecurityLendingInvoiceMeta : IRosettaMetaData<SecurityLendingInvoice>
    {
        public IEnumerable<IValidator<SecurityLendingInvoice>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SecurityLendingInvoice>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SecurityLendingInvoice, ISet<string>> OnlyExistsValidator => new SecurityLendingInvoiceOnlyExistsValidator();

        public IValidator<SecurityLendingInvoice> Validator => new SecurityLendingInvoiceValidator();
    }
    
    /// <summary>
    /// MetaData definition for SecurityLocate
    /// </summary>
    [RosettaMeta(typeof(SecurityLocate))]
    public class SecurityLocateMeta : IRosettaMetaData<SecurityLocate>
    {
        public IEnumerable<IValidator<SecurityLocate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SecurityLocate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SecurityLocate, ISet<string>> OnlyExistsValidator => new SecurityLocateOnlyExistsValidator();

        public IValidator<SecurityLocate> Validator => new SecurityLocateValidator();
    }
    
    /// <summary>
    /// MetaData definition for Sellr
    /// </summary>
    [RosettaMeta(typeof(Sellr))]
    public class SellrMeta : IRosettaMetaData<Sellr>
    {
        public IEnumerable<IValidator<Sellr>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Sellr>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Sellr, ISet<string>> OnlyExistsValidator => new SellrOnlyExistsValidator();

        public IValidator<Sellr> Validator => new SellrValidator();
    }
    
    /// <summary>
    /// MetaData definition for SettledEntityMatrix
    /// </summary>
    [RosettaMeta(typeof(SettledEntityMatrix))]
    public class SettledEntityMatrixMeta : IRosettaMetaData<SettledEntityMatrix>
    {
        public IEnumerable<IValidator<SettledEntityMatrix>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SettledEntityMatrix>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SettledEntityMatrix, ISet<string>> OnlyExistsValidator => new SettledEntityMatrixOnlyExistsValidator();

        public IValidator<SettledEntityMatrix> Validator => new SettledEntityMatrixValidator();
    }
    
    /// <summary>
    /// MetaData definition for SettlementBase
    /// </summary>
    [RosettaMeta(typeof(SettlementBase))]
    public class SettlementBaseMeta : IRosettaMetaData<SettlementBase>
    {
        public IEnumerable<IValidator<SettlementBase>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SettlementBase>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SettlementBase, ISet<string>> OnlyExistsValidator => new SettlementBaseOnlyExistsValidator();

        public IValidator<SettlementBase> Validator => new SettlementBaseValidator();
    }
    
    /// <summary>
    /// MetaData definition for SettlementDate
    /// </summary>
    [RosettaMeta(typeof(SettlementDate))]
    public class SettlementDateMeta : IRosettaMetaData<SettlementDate>
    {
        public IEnumerable<IValidator<SettlementDate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SettlementDate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SettlementDate, ISet<string>> OnlyExistsValidator => new SettlementDateOnlyExistsValidator();

        public IValidator<SettlementDate> Validator => new SettlementDateValidator();
    }
    
    /// <summary>
    /// MetaData definition for SettlementPayout
    /// </summary>
    [RosettaMeta(typeof(SettlementPayout))]
    public class SettlementPayoutMeta : IRosettaMetaData<SettlementPayout>
    {
        public IEnumerable<IValidator<SettlementPayout>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SettlementPayout>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SettlementPayout, ISet<string>> OnlyExistsValidator => new SettlementPayoutOnlyExistsValidator();

        public IValidator<SettlementPayout> Validator => new SettlementPayoutValidator();
    }
    
    /// <summary>
    /// MetaData definition for SettlementProvision
    /// </summary>
    [RosettaMeta(typeof(SettlementProvision))]
    public class SettlementProvisionMeta : IRosettaMetaData<SettlementProvision>
    {
        public IEnumerable<IValidator<SettlementProvision>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SettlementProvision>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SettlementProvision, ISet<string>> OnlyExistsValidator => new SettlementProvisionOnlyExistsValidator();

        public IValidator<SettlementProvision> Validator => new SettlementProvisionValidator();
    }
    
    /// <summary>
    /// MetaData definition for SettlementRateOption
    /// </summary>
    [RosettaMeta(typeof(SettlementRateOption))]
    public class SettlementRateOptionMeta : IRosettaMetaData<SettlementRateOption>
    {
        public IEnumerable<IValidator<SettlementRateOption>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SettlementRateOption>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SettlementRateOption, ISet<string>> OnlyExistsValidator => new SettlementRateOptionOnlyExistsValidator();

        public IValidator<SettlementRateOption> Validator => new SettlementRateOptionValidator();
    }
    
    /// <summary>
    /// MetaData definition for SettlementTerms
    /// </summary>
    [RosettaMeta(typeof(SettlementTerms))]
    public class SettlementTermsMeta : IRosettaMetaData<SettlementTerms>
    {
        public IEnumerable<IValidator<SettlementTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SettlementTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SettlementTerms, ISet<string>> OnlyExistsValidator => new SettlementTermsOnlyExistsValidator();

        public IValidator<SettlementTerms> Validator => new SettlementTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for ShapingProvision
    /// </summary>
    [RosettaMeta(typeof(ShapingProvision))]
    public class ShapingProvisionMeta : IRosettaMetaData<ShapingProvision>
    {
        public IEnumerable<IValidator<ShapingProvision>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ShapingProvision>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ShapingProvision, ISet<string>> OnlyExistsValidator => new ShapingProvisionOnlyExistsValidator();

        public IValidator<ShapingProvision> Validator => new ShapingProvisionValidator();
    }
    
    /// <summary>
    /// MetaData definition for SingleValuationDate
    /// </summary>
    [RosettaMeta(typeof(SingleValuationDate))]
    public class SingleValuationDateMeta : IRosettaMetaData<SingleValuationDate>
    {
        public IEnumerable<IValidator<SingleValuationDate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SingleValuationDate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SingleValuationDate, ISet<string>> OnlyExistsValidator => new SingleValuationDateOnlyExistsValidator();

        public IValidator<SingleValuationDate> Validator => new SingleValuationDateValidator();
    }
    
    /// <summary>
    /// MetaData definition for Sngl
    /// </summary>
    [RosettaMeta(typeof(Sngl))]
    public class SnglMeta : IRosettaMetaData<Sngl>
    {
        public IEnumerable<IValidator<Sngl>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Sngl>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Sngl, ISet<string>> OnlyExistsValidator => new SnglOnlyExistsValidator();

        public IValidator<Sngl> Validator => new SnglValidator();
    }
    
    /// <summary>
    /// MetaData definition for SovereignAgencyRating
    /// </summary>
    [RosettaMeta(typeof(SovereignAgencyRating))]
    public class SovereignAgencyRatingMeta : IRosettaMetaData<SovereignAgencyRating>
    {
        public IEnumerable<IValidator<SovereignAgencyRating>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SovereignAgencyRating>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SovereignAgencyRating, ISet<string>> OnlyExistsValidator => new SovereignAgencyRatingOnlyExistsValidator();

        public IValidator<SovereignAgencyRating> Validator => new SovereignAgencyRatingValidator();
    }
    
    /// <summary>
    /// MetaData definition for SpecialPurposeVehicleIssuerType
    /// </summary>
    [RosettaMeta(typeof(SpecialPurposeVehicleIssuerType))]
    public class SpecialPurposeVehicleIssuerTypeMeta : IRosettaMetaData<SpecialPurposeVehicleIssuerType>
    {
        public IEnumerable<IValidator<SpecialPurposeVehicleIssuerType>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SpecialPurposeVehicleIssuerType>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SpecialPurposeVehicleIssuerType, ISet<string>> OnlyExistsValidator => new SpecialPurposeVehicleIssuerTypeOnlyExistsValidator();

        public IValidator<SpecialPurposeVehicleIssuerType> Validator => new SpecialPurposeVehicleIssuerTypeValidator();
    }
    
    /// <summary>
    /// MetaData definition for SpecificAsset
    /// </summary>
    [RosettaMeta(typeof(SpecificAsset))]
    public class SpecificAssetMeta : IRosettaMetaData<SpecificAsset>
    {
        public IEnumerable<IValidator<SpecificAsset>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SpecificAsset>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SpecificAsset, ISet<string>> OnlyExistsValidator => new SpecificAssetOnlyExistsValidator();

        public IValidator<SpecificAsset> Validator => new SpecificAssetValidator();
    }
    
    /// <summary>
    /// MetaData definition for SpecifiedCurrency
    /// </summary>
    [RosettaMeta(typeof(SpecifiedCurrency))]
    public class SpecifiedCurrencyMeta : IRosettaMetaData<SpecifiedCurrency>
    {
        public IEnumerable<IValidator<SpecifiedCurrency>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SpecifiedCurrency>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SpecifiedCurrency, ISet<string>> OnlyExistsValidator => new SpecifiedCurrencyOnlyExistsValidator();

        public IValidator<SpecifiedCurrency> Validator => new SpecifiedCurrencyValidator();
    }
    
    /// <summary>
    /// MetaData definition for SplitInstruction
    /// </summary>
    [RosettaMeta(typeof(SplitInstruction))]
    public class SplitInstructionMeta : IRosettaMetaData<SplitInstruction>
    {
        public IEnumerable<IValidator<SplitInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SplitInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SplitInstruction, ISet<string>> OnlyExistsValidator => new SplitInstructionOnlyExistsValidator();

        public IValidator<SplitInstruction> Validator => new SplitInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for SpreadSchedule
    /// </summary>
    [RosettaMeta(typeof(SpreadSchedule))]
    public class SpreadScheduleMeta : IRosettaMetaData<SpreadSchedule>
    {
        public IEnumerable<IValidator<SpreadSchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SpreadSchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SpreadSchedule, ISet<string>> OnlyExistsValidator => new SpreadScheduleOnlyExistsValidator();

        public IValidator<SpreadSchedule> Validator => new SpreadScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for StandardizedSchedule
    /// </summary>
    [RosettaMeta(typeof(StandardizedSchedule))]
    public class StandardizedScheduleMeta : IRosettaMetaData<StandardizedSchedule>
    {
        public IEnumerable<IValidator<StandardizedSchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<StandardizedSchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<StandardizedSchedule, ISet<string>> OnlyExistsValidator => new StandardizedScheduleOnlyExistsValidator();

        public IValidator<StandardizedSchedule> Validator => new StandardizedScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for StandardizedScheduleInitialMargin
    /// </summary>
    [RosettaMeta(typeof(StandardizedScheduleInitialMargin))]
    public class StandardizedScheduleInitialMarginMeta : IRosettaMetaData<StandardizedScheduleInitialMargin>
    {
        public IEnumerable<IValidator<StandardizedScheduleInitialMargin>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<StandardizedScheduleInitialMargin>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<StandardizedScheduleInitialMargin, ISet<string>> OnlyExistsValidator => new StandardizedScheduleInitialMarginOnlyExistsValidator();

        public IValidator<StandardizedScheduleInitialMargin> Validator => new StandardizedScheduleInitialMarginValidator();
    }
    
    /// <summary>
    /// MetaData definition for StandardizedScheduleTradeInfo
    /// </summary>
    [RosettaMeta(typeof(StandardizedScheduleTradeInfo))]
    public class StandardizedScheduleTradeInfoMeta : IRosettaMetaData<StandardizedScheduleTradeInfo>
    {
        public IEnumerable<IValidator<StandardizedScheduleTradeInfo>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<StandardizedScheduleTradeInfo>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<StandardizedScheduleTradeInfo, ISet<string>> OnlyExistsValidator => new StandardizedScheduleTradeInfoOnlyExistsValidator();

        public IValidator<StandardizedScheduleTradeInfo> Validator => new StandardizedScheduleTradeInfoValidator();
    }
    
    /// <summary>
    /// MetaData definition for State
    /// </summary>
    [RosettaMeta(typeof(State))]
    public class StateMeta : IRosettaMetaData<State>
    {
        public IEnumerable<IValidator<State>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<State>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<State, ISet<string>> OnlyExistsValidator => new StateOnlyExistsValidator();

        public IValidator<State> Validator => new StateValidator();
    }
    
    /// <summary>
    /// MetaData definition for StockSplitInstruction
    /// </summary>
    [RosettaMeta(typeof(StockSplitInstruction))]
    public class StockSplitInstructionMeta : IRosettaMetaData<StockSplitInstruction>
    {
        public IEnumerable<IValidator<StockSplitInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<StockSplitInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<StockSplitInstruction, ISet<string>> OnlyExistsValidator => new StockSplitInstructionOnlyExistsValidator();

        public IValidator<StockSplitInstruction> Validator => new StockSplitInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for StrategyFeature
    /// </summary>
    [RosettaMeta(typeof(StrategyFeature))]
    public class StrategyFeatureMeta : IRosettaMetaData<StrategyFeature>
    {
        public IEnumerable<IValidator<StrategyFeature>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<StrategyFeature>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<StrategyFeature, ISet<string>> OnlyExistsValidator => new StrategyFeatureOnlyExistsValidator();

        public IValidator<StrategyFeature> Validator => new StrategyFeatureValidator();
    }
    
    /// <summary>
    /// MetaData definition for Strike
    /// </summary>
    [RosettaMeta(typeof(Strike))]
    public class StrikeMeta : IRosettaMetaData<Strike>
    {
        public IEnumerable<IValidator<Strike>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Strike>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Strike, ISet<string>> OnlyExistsValidator => new StrikeOnlyExistsValidator();

        public IValidator<Strike> Validator => new StrikeValidator();
    }
    
    /// <summary>
    /// MetaData definition for StrikeSchedule
    /// </summary>
    [RosettaMeta(typeof(StrikeSchedule))]
    public class StrikeScheduleMeta : IRosettaMetaData<StrikeSchedule>
    {
        public IEnumerable<IValidator<StrikeSchedule>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<StrikeSchedule>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<StrikeSchedule, ISet<string>> OnlyExistsValidator => new StrikeScheduleOnlyExistsValidator();

        public IValidator<StrikeSchedule> Validator => new StrikeScheduleValidator();
    }
    
    /// <summary>
    /// MetaData definition for StrikeSpread
    /// </summary>
    [RosettaMeta(typeof(StrikeSpread))]
    public class StrikeSpreadMeta : IRosettaMetaData<StrikeSpread>
    {
        public IEnumerable<IValidator<StrikeSpread>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<StrikeSpread>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<StrikeSpread, ISet<string>> OnlyExistsValidator => new StrikeSpreadOnlyExistsValidator();

        public IValidator<StrikeSpread> Validator => new StrikeSpreadValidator();
    }
    
    /// <summary>
    /// MetaData definition for StubCalculationPeriodAmount
    /// </summary>
    [RosettaMeta(typeof(StubCalculationPeriodAmount))]
    public class StubCalculationPeriodAmountMeta : IRosettaMetaData<StubCalculationPeriodAmount>
    {
        public IEnumerable<IValidator<StubCalculationPeriodAmount>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<StubCalculationPeriodAmount>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<StubCalculationPeriodAmount, ISet<string>> OnlyExistsValidator => new StubCalculationPeriodAmountOnlyExistsValidator();

        public IValidator<StubCalculationPeriodAmount> Validator => new StubCalculationPeriodAmountValidator();
    }
    
    /// <summary>
    /// MetaData definition for StubFloatingRate
    /// </summary>
    [RosettaMeta(typeof(StubFloatingRate))]
    public class StubFloatingRateMeta : IRosettaMetaData<StubFloatingRate>
    {
        public IEnumerable<IValidator<StubFloatingRate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<StubFloatingRate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<StubFloatingRate, ISet<string>> OnlyExistsValidator => new StubFloatingRateOnlyExistsValidator();

        public IValidator<StubFloatingRate> Validator => new StubFloatingRateValidator();
    }
    
    /// <summary>
    /// MetaData definition for StubPeriod
    /// </summary>
    [RosettaMeta(typeof(StubPeriod))]
    public class StubPeriodMeta : IRosettaMetaData<StubPeriod>
    {
        public IEnumerable<IValidator<StubPeriod>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<StubPeriod>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<StubPeriod, ISet<string>> OnlyExistsValidator => new StubPeriodOnlyExistsValidator();

        public IValidator<StubPeriod> Validator => new StubPeriodValidator();
    }
    
    /// <summary>
    /// MetaData definition for StubValue
    /// </summary>
    [RosettaMeta(typeof(StubValue))]
    public class StubValueMeta : IRosettaMetaData<StubValue>
    {
        public IEnumerable<IValidator<StubValue>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<StubValue>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<StubValue, ISet<string>> OnlyExistsValidator => new StubValueOnlyExistsValidator();

        public IValidator<StubValue> Validator => new StubValueValidator();
    }
    
    /// <summary>
    /// MetaData definition for SubstitutionProvisions
    /// </summary>
    [RosettaMeta(typeof(SubstitutionProvisions))]
    public class SubstitutionProvisionsMeta : IRosettaMetaData<SubstitutionProvisions>
    {
        public IEnumerable<IValidator<SubstitutionProvisions>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SubstitutionProvisions>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SubstitutionProvisions, ISet<string>> OnlyExistsValidator => new SubstitutionProvisionsOnlyExistsValidator();

        public IValidator<SubstitutionProvisions> Validator => new SubstitutionProvisionsValidator();
    }
    
    /// <summary>
    /// MetaData definition for SwapCurveValuation
    /// </summary>
    [RosettaMeta(typeof(SwapCurveValuation))]
    public class SwapCurveValuationMeta : IRosettaMetaData<SwapCurveValuation>
    {
        public IEnumerable<IValidator<SwapCurveValuation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SwapCurveValuation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SwapCurveValuation, ISet<string>> OnlyExistsValidator => new SwapCurveValuationOnlyExistsValidator();

        public IValidator<SwapCurveValuation> Validator => new SwapCurveValuationValidator();
    }
    
    /// <summary>
    /// MetaData definition for Swp
    /// </summary>
    [RosettaMeta(typeof(Swp))]
    public class SwpMeta : IRosettaMetaData<Swp>
    {
        public IEnumerable<IValidator<Swp>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Swp>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Swp, ISet<string>> OnlyExistsValidator => new SwpOnlyExistsValidator();

        public IValidator<Swp> Validator => new SwpValidator();
    }
    
    /// <summary>
    /// MetaData definition for SwpIn
    /// </summary>
    [RosettaMeta(typeof(SwpIn))]
    public class SwpInMeta : IRosettaMetaData<SwpIn>
    {
        public IEnumerable<IValidator<SwpIn>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SwpIn>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SwpIn, ISet<string>> OnlyExistsValidator => new SwpInOnlyExistsValidator();

        public IValidator<SwpIn> Validator => new SwpInValidator();
    }
    
    /// <summary>
    /// MetaData definition for SwpOut
    /// </summary>
    [RosettaMeta(typeof(SwpOut))]
    public class SwpOutMeta : IRosettaMetaData<SwpOut>
    {
        public IEnumerable<IValidator<SwpOut>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<SwpOut>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<SwpOut, ISet<string>> OnlyExistsValidator => new SwpOutOnlyExistsValidator();

        public IValidator<SwpOut> Validator => new SwpOutValidator();
    }
    
    /// <summary>
    /// MetaData definition for Taxonomy
    /// </summary>
    [RosettaMeta(typeof(Taxonomy))]
    public class TaxonomyMeta : IRosettaMetaData<Taxonomy>
    {
        public IEnumerable<IValidator<Taxonomy>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Taxonomy>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Taxonomy, ISet<string>> OnlyExistsValidator => new TaxonomyOnlyExistsValidator();

        public IValidator<Taxonomy> Validator => new TaxonomyValidator();
    }
    
    /// <summary>
    /// MetaData definition for TaxonomyClassification
    /// </summary>
    [RosettaMeta(typeof(TaxonomyClassification))]
    public class TaxonomyClassificationMeta : IRosettaMetaData<TaxonomyClassification>
    {
        public IEnumerable<IValidator<TaxonomyClassification>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TaxonomyClassification>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TaxonomyClassification, ISet<string>> OnlyExistsValidator => new TaxonomyClassificationOnlyExistsValidator();

        public IValidator<TaxonomyClassification> Validator => new TaxonomyClassificationValidator();
    }
    
    /// <summary>
    /// MetaData definition for TaxonomyValue
    /// </summary>
    [RosettaMeta(typeof(TaxonomyValue))]
    public class TaxonomyValueMeta : IRosettaMetaData<TaxonomyValue>
    {
        public IEnumerable<IValidator<TaxonomyValue>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TaxonomyValue>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TaxonomyValue, ISet<string>> OnlyExistsValidator => new TaxonomyValueOnlyExistsValidator();

        public IValidator<TaxonomyValue> Validator => new TaxonomyValueValidator();
    }
    
    /// <summary>
    /// MetaData definition for TelephoneNumber
    /// </summary>
    [RosettaMeta(typeof(TelephoneNumber))]
    public class TelephoneNumberMeta : IRosettaMetaData<TelephoneNumber>
    {
        public IEnumerable<IValidator<TelephoneNumber>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TelephoneNumber>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TelephoneNumber, ISet<string>> OnlyExistsValidator => new TelephoneNumberOnlyExistsValidator();

        public IValidator<TelephoneNumber> Validator => new TelephoneNumberValidator();
    }
    
    /// <summary>
    /// MetaData definition for Term
    /// </summary>
    [RosettaMeta(typeof(Term))]
    public class TermMeta : IRosettaMetaData<Term>
    {
        public IEnumerable<IValidator<Term>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Term>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Term, ISet<string>> OnlyExistsValidator => new TermOnlyExistsValidator();

        public IValidator<Term> Validator => new TermValidator();
    }
    
    /// <summary>
    /// MetaData definition for TerminationProvision
    /// </summary>
    [RosettaMeta(typeof(TerminationProvision))]
    public class TerminationProvisionMeta : IRosettaMetaData<TerminationProvision>
    {
        public IEnumerable<IValidator<TerminationProvision>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TerminationProvision>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TerminationProvision, ISet<string>> OnlyExistsValidator => new TerminationProvisionOnlyExistsValidator();

        public IValidator<TerminationProvision> Validator => new TerminationProvisionValidator();
    }
    
    /// <summary>
    /// MetaData definition for TermsChangeInstruction
    /// </summary>
    [RosettaMeta(typeof(TermsChangeInstruction))]
    public class TermsChangeInstructionMeta : IRosettaMetaData<TermsChangeInstruction>
    {
        public IEnumerable<IValidator<TermsChangeInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TermsChangeInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TermsChangeInstruction, ISet<string>> OnlyExistsValidator => new TermsChangeInstructionOnlyExistsValidator();

        public IValidator<TermsChangeInstruction> Validator => new TermsChangeInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for TimeZone
    /// </summary>
    [RosettaMeta(typeof(TimeZone))]
    public class TimeZoneMeta : IRosettaMetaData<TimeZone>
    {
        public IEnumerable<IValidator<TimeZone>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TimeZone>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TimeZone, ISet<string>> OnlyExistsValidator => new TimeZoneOnlyExistsValidator();

        public IValidator<TimeZone> Validator => new TimeZoneValidator();
    }
    
    /// <summary>
    /// MetaData definition for TradableProduct
    /// </summary>
    [RosettaMeta(typeof(TradableProduct))]
    public class TradableProductMeta : IRosettaMetaData<TradableProduct>
    {
        public IEnumerable<IValidator<TradableProduct>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TradableProduct>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TradableProduct, ISet<string>> OnlyExistsValidator => new TradableProductOnlyExistsValidator();

        public IValidator<TradableProduct> Validator => new TradableProductValidator();
    }
    
    /// <summary>
    /// MetaData definition for Trade
    /// </summary>
    [RosettaMeta(typeof(Trade))]
    public class TradeMeta : IRosettaMetaData<Trade>
    {
        public IEnumerable<IValidator<Trade>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Trade>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Trade, ISet<string>> OnlyExistsValidator => new TradeOnlyExistsValidator();

        public IValidator<Trade> Validator => new TradeValidator();
    }
    
    /// <summary>
    /// MetaData definition for TradeIdentifier
    /// </summary>
    [RosettaMeta(typeof(TradeIdentifier))]
    public class TradeIdentifierMeta : IRosettaMetaData<TradeIdentifier>
    {
        public IEnumerable<IValidator<TradeIdentifier>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TradeIdentifier>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TradeIdentifier, ISet<string>> OnlyExistsValidator => new TradeIdentifierOnlyExistsValidator();

        public IValidator<TradeIdentifier> Validator => new TradeIdentifierValidator();
    }
    
    /// <summary>
    /// MetaData definition for TradeLot
    /// </summary>
    [RosettaMeta(typeof(TradeLot))]
    public class TradeLotMeta : IRosettaMetaData<TradeLot>
    {
        public IEnumerable<IValidator<TradeLot>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TradeLot>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TradeLot, ISet<string>> OnlyExistsValidator => new TradeLotOnlyExistsValidator();

        public IValidator<TradeLot> Validator => new TradeLotValidator();
    }
    
    /// <summary>
    /// MetaData definition for TradePricingReport
    /// </summary>
    [RosettaMeta(typeof(TradePricingReport))]
    public class TradePricingReportMeta : IRosettaMetaData<TradePricingReport>
    {
        public IEnumerable<IValidator<TradePricingReport>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TradePricingReport>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TradePricingReport, ISet<string>> OnlyExistsValidator => new TradePricingReportOnlyExistsValidator();

        public IValidator<TradePricingReport> Validator => new TradePricingReportValidator();
    }
    
    /// <summary>
    /// MetaData definition for TradeState
    /// </summary>
    [RosettaMeta(typeof(TradeState))]
    public class TradeStateMeta : IRosettaMetaData<TradeState>
    {
        public IEnumerable<IValidator<TradeState>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TradeState>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TradeState, ISet<string>> OnlyExistsValidator => new TradeStateOnlyExistsValidator();

        public IValidator<TradeState> Validator => new TradeStateValidator();
    }
    
    /// <summary>
    /// MetaData definition for Tranche
    /// </summary>
    [RosettaMeta(typeof(Tranche))]
    public class TrancheMeta : IRosettaMetaData<Tranche>
    {
        public IEnumerable<IValidator<Tranche>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Tranche>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Tranche, ISet<string>> OnlyExistsValidator => new TrancheOnlyExistsValidator();

        public IValidator<Tranche> Validator => new TrancheValidator();
    }
    
    /// <summary>
    /// MetaData definition for TransactedPrice
    /// </summary>
    [RosettaMeta(typeof(TransactedPrice))]
    public class TransactedPriceMeta : IRosettaMetaData<TransactedPrice>
    {
        public IEnumerable<IValidator<TransactedPrice>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TransactedPrice>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TransactedPrice, ISet<string>> OnlyExistsValidator => new TransactedPriceOnlyExistsValidator();

        public IValidator<TransactedPrice> Validator => new TransactedPriceValidator();
    }
    
    /// <summary>
    /// MetaData definition for TransactionAdditionalTerms
    /// </summary>
    [RosettaMeta(typeof(TransactionAdditionalTerms))]
    public class TransactionAdditionalTermsMeta : IRosettaMetaData<TransactionAdditionalTerms>
    {
        public IEnumerable<IValidator<TransactionAdditionalTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TransactionAdditionalTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TransactionAdditionalTerms, ISet<string>> OnlyExistsValidator => new TransactionAdditionalTermsOnlyExistsValidator();

        public IValidator<TransactionAdditionalTerms> Validator => new TransactionAdditionalTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for Transfer
    /// </summary>
    [RosettaMeta(typeof(Transfer))]
    public class TransferMeta : IRosettaMetaData<Transfer>
    {
        public IEnumerable<IValidator<Transfer>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Transfer>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Transfer, ISet<string>> OnlyExistsValidator => new TransferOnlyExistsValidator();

        public IValidator<Transfer> Validator => new TransferValidator();
    }
    
    /// <summary>
    /// MetaData definition for TransferExpression
    /// </summary>
    [RosettaMeta(typeof(TransferExpression))]
    public class TransferExpressionMeta : IRosettaMetaData<TransferExpression>
    {
        public IEnumerable<IValidator<TransferExpression>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TransferExpression>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TransferExpression, ISet<string>> OnlyExistsValidator => new TransferExpressionOnlyExistsValidator();

        public IValidator<TransferExpression> Validator => new TransferExpressionValidator();
    }
    
    /// <summary>
    /// MetaData definition for TransferInstruction
    /// </summary>
    [RosettaMeta(typeof(TransferInstruction))]
    public class TransferInstructionMeta : IRosettaMetaData<TransferInstruction>
    {
        public IEnumerable<IValidator<TransferInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TransferInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TransferInstruction, ISet<string>> OnlyExistsValidator => new TransferInstructionOnlyExistsValidator();

        public IValidator<TransferInstruction> Validator => new TransferInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for TransferState
    /// </summary>
    [RosettaMeta(typeof(TransferState))]
    public class TransferStateMeta : IRosettaMetaData<TransferState>
    {
        public IEnumerable<IValidator<TransferState>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TransferState>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TransferState, ISet<string>> OnlyExistsValidator => new TransferStateOnlyExistsValidator();

        public IValidator<TransferState> Validator => new TransferStateValidator();
    }
    
    /// <summary>
    /// MetaData definition for TransferableProduct
    /// </summary>
    [RosettaMeta(typeof(TransferableProduct))]
    public class TransferableProductMeta : IRosettaMetaData<TransferableProduct>
    {
        public IEnumerable<IValidator<TransferableProduct>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TransferableProduct>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TransferableProduct, ISet<string>> OnlyExistsValidator => new TransferableProductOnlyExistsValidator();

        public IValidator<TransferableProduct> Validator => new TransferableProductValidator();
    }
    
    /// <summary>
    /// MetaData definition for Trigger
    /// </summary>
    [RosettaMeta(typeof(Trigger))]
    public class TriggerMeta : IRosettaMetaData<Trigger>
    {
        public IEnumerable<IValidator<Trigger>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Trigger>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Trigger, ISet<string>> OnlyExistsValidator => new TriggerOnlyExistsValidator();

        public IValidator<Trigger> Validator => new TriggerValidator();
    }
    
    /// <summary>
    /// MetaData definition for TriggerEvent
    /// </summary>
    [RosettaMeta(typeof(TriggerEvent))]
    public class TriggerEventMeta : IRosettaMetaData<TriggerEvent>
    {
        public IEnumerable<IValidator<TriggerEvent>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<TriggerEvent>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<TriggerEvent, ISet<string>> OnlyExistsValidator => new TriggerEventOnlyExistsValidator();

        public IValidator<TriggerEvent> Validator => new TriggerEventValidator();
    }
    
    /// <summary>
    /// MetaData definition for Tx
    /// </summary>
    [RosettaMeta(typeof(Tx))]
    public class TxMeta : IRosettaMetaData<Tx>
    {
        public IEnumerable<IValidator<Tx>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Tx>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Tx, ISet<string>> OnlyExistsValidator => new TxOnlyExistsValidator();

        public IValidator<Tx> Validator => new TxValidator();
    }
    
    /// <summary>
    /// MetaData definition for UmbrellaAgreement
    /// </summary>
    [RosettaMeta(typeof(UmbrellaAgreement))]
    public class UmbrellaAgreementMeta : IRosettaMetaData<UmbrellaAgreement>
    {
        public IEnumerable<IValidator<UmbrellaAgreement>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<UmbrellaAgreement>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<UmbrellaAgreement, ISet<string>> OnlyExistsValidator => new UmbrellaAgreementOnlyExistsValidator();

        public IValidator<UmbrellaAgreement> Validator => new UmbrellaAgreementValidator();
    }
    
    /// <summary>
    /// MetaData definition for UmbrellaAgreementEntity
    /// </summary>
    [RosettaMeta(typeof(UmbrellaAgreementEntity))]
    public class UmbrellaAgreementEntityMeta : IRosettaMetaData<UmbrellaAgreementEntity>
    {
        public IEnumerable<IValidator<UmbrellaAgreementEntity>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<UmbrellaAgreementEntity>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<UmbrellaAgreementEntity, ISet<string>> OnlyExistsValidator => new UmbrellaAgreementEntityOnlyExistsValidator();

        public IValidator<UmbrellaAgreementEntity> Validator => new UmbrellaAgreementEntityValidator();
    }
    
    /// <summary>
    /// MetaData definition for Underlier
    /// </summary>
    [RosettaMeta(typeof(Underlier))]
    public class UnderlierMeta : IRosettaMetaData<Underlier>
    {
        public IEnumerable<IValidator<Underlier>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Underlier>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Underlier, ISet<string>> OnlyExistsValidator => new UnderlierOnlyExistsValidator();

        public IValidator<Underlier> Validator => new UnderlierValidator();
    }
    
    /// <summary>
    /// MetaData definition for UnderlierSubstitutionProvision
    /// </summary>
    [RosettaMeta(typeof(UnderlierSubstitutionProvision))]
    public class UnderlierSubstitutionProvisionMeta : IRosettaMetaData<UnderlierSubstitutionProvision>
    {
        public IEnumerable<IValidator<UnderlierSubstitutionProvision>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<UnderlierSubstitutionProvision>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<UnderlierSubstitutionProvision, ISet<string>> OnlyExistsValidator => new UnderlierSubstitutionProvisionOnlyExistsValidator();

        public IValidator<UnderlierSubstitutionProvision> Validator => new UnderlierSubstitutionProvisionValidator();
    }
    
    /// <summary>
    /// MetaData definition for UndrlygInstrm
    /// </summary>
    [RosettaMeta(typeof(UndrlygInstrm))]
    public class UndrlygInstrmMeta : IRosettaMetaData<UndrlygInstrm>
    {
        public IEnumerable<IValidator<UndrlygInstrm>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<UndrlygInstrm>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<UndrlygInstrm, ISet<string>> OnlyExistsValidator => new UndrlygInstrmOnlyExistsValidator();

        public IValidator<UndrlygInstrm> Validator => new UndrlygInstrmValidator();
    }
    
    /// <summary>
    /// MetaData definition for UnitType
    /// </summary>
    [RosettaMeta(typeof(UnitType))]
    public class UnitTypeMeta : IRosettaMetaData<UnitType>
    {
        public IEnumerable<IValidator<UnitType>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<UnitType>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<UnitType, ISet<string>> OnlyExistsValidator => new UnitTypeOnlyExistsValidator();

        public IValidator<UnitType> Validator => new UnitTypeValidator();
    }
    
    /// <summary>
    /// MetaData definition for Valuation
    /// </summary>
    [RosettaMeta(typeof(Valuation))]
    public class ValuationMeta : IRosettaMetaData<Valuation>
    {
        public IEnumerable<IValidator<Valuation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Valuation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Valuation, ISet<string>> OnlyExistsValidator => new ValuationOnlyExistsValidator();

        public IValidator<Valuation> Validator => new ValuationValidator();
    }
    
    /// <summary>
    /// MetaData definition for ValuationDate
    /// </summary>
    [RosettaMeta(typeof(ValuationDate))]
    public class ValuationDateMeta : IRosettaMetaData<ValuationDate>
    {
        public IEnumerable<IValidator<ValuationDate>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ValuationDate>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ValuationDate, ISet<string>> OnlyExistsValidator => new ValuationDateOnlyExistsValidator();

        public IValidator<ValuationDate> Validator => new ValuationDateValidator();
    }
    
    /// <summary>
    /// MetaData definition for ValuationDates
    /// </summary>
    [RosettaMeta(typeof(ValuationDates))]
    public class ValuationDatesMeta : IRosettaMetaData<ValuationDates>
    {
        public IEnumerable<IValidator<ValuationDates>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ValuationDates>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ValuationDates, ISet<string>> OnlyExistsValidator => new ValuationDatesOnlyExistsValidator();

        public IValidator<ValuationDates> Validator => new ValuationDatesValidator();
    }
    
    /// <summary>
    /// MetaData definition for ValuationInstruction
    /// </summary>
    [RosettaMeta(typeof(ValuationInstruction))]
    public class ValuationInstructionMeta : IRosettaMetaData<ValuationInstruction>
    {
        public IEnumerable<IValidator<ValuationInstruction>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ValuationInstruction>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ValuationInstruction, ISet<string>> OnlyExistsValidator => new ValuationInstructionOnlyExistsValidator();

        public IValidator<ValuationInstruction> Validator => new ValuationInstructionValidator();
    }
    
    /// <summary>
    /// MetaData definition for ValuationMethod
    /// </summary>
    [RosettaMeta(typeof(ValuationMethod))]
    public class ValuationMethodMeta : IRosettaMetaData<ValuationMethod>
    {
        public IEnumerable<IValidator<ValuationMethod>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ValuationMethod>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ValuationMethod, ISet<string>> OnlyExistsValidator => new ValuationMethodOnlyExistsValidator();

        public IValidator<ValuationMethod> Validator => new ValuationMethodValidator();
    }
    
    /// <summary>
    /// MetaData definition for ValuationPostponement
    /// </summary>
    [RosettaMeta(typeof(ValuationPostponement))]
    public class ValuationPostponementMeta : IRosettaMetaData<ValuationPostponement>
    {
        public IEnumerable<IValidator<ValuationPostponement>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ValuationPostponement>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ValuationPostponement, ISet<string>> OnlyExistsValidator => new ValuationPostponementOnlyExistsValidator();

        public IValidator<ValuationPostponement> Validator => new ValuationPostponementValidator();
    }
    
    /// <summary>
    /// MetaData definition for ValuationSource
    /// </summary>
    [RosettaMeta(typeof(ValuationSource))]
    public class ValuationSourceMeta : IRosettaMetaData<ValuationSource>
    {
        public IEnumerable<IValidator<ValuationSource>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ValuationSource>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ValuationSource, ISet<string>> OnlyExistsValidator => new ValuationSourceOnlyExistsValidator();

        public IValidator<ValuationSource> Validator => new ValuationSourceValidator();
    }
    
    /// <summary>
    /// MetaData definition for ValuationTerms
    /// </summary>
    [RosettaMeta(typeof(ValuationTerms))]
    public class ValuationTermsMeta : IRosettaMetaData<ValuationTerms>
    {
        public IEnumerable<IValidator<ValuationTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<ValuationTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<ValuationTerms, ISet<string>> OnlyExistsValidator => new ValuationTermsOnlyExistsValidator();

        public IValidator<ValuationTerms> Validator => new ValuationTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for VarianceCapFloor
    /// </summary>
    [RosettaMeta(typeof(VarianceCapFloor))]
    public class VarianceCapFloorMeta : IRosettaMetaData<VarianceCapFloor>
    {
        public IEnumerable<IValidator<VarianceCapFloor>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<VarianceCapFloor>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<VarianceCapFloor, ISet<string>> OnlyExistsValidator => new VarianceCapFloorOnlyExistsValidator();

        public IValidator<VarianceCapFloor> Validator => new VarianceCapFloorValidator();
    }
    
    /// <summary>
    /// MetaData definition for VarianceReturnTerms
    /// </summary>
    [RosettaMeta(typeof(VarianceReturnTerms))]
    public class VarianceReturnTermsMeta : IRosettaMetaData<VarianceReturnTerms>
    {
        public IEnumerable<IValidator<VarianceReturnTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<VarianceReturnTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<VarianceReturnTerms, ISet<string>> OnlyExistsValidator => new VarianceReturnTermsOnlyExistsValidator();

        public IValidator<VarianceReturnTerms> Validator => new VarianceReturnTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for Velocity
    /// </summary>
    [RosettaMeta(typeof(Velocity))]
    public class VelocityMeta : IRosettaMetaData<Velocity>
    {
        public IEnumerable<IValidator<Velocity>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Velocity>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Velocity, ISet<string>> OnlyExistsValidator => new VelocityOnlyExistsValidator();

        public IValidator<Velocity> Validator => new VelocityValidator();
    }
    
    /// <summary>
    /// MetaData definition for VolatilityCapFloor
    /// </summary>
    [RosettaMeta(typeof(VolatilityCapFloor))]
    public class VolatilityCapFloorMeta : IRosettaMetaData<VolatilityCapFloor>
    {
        public IEnumerable<IValidator<VolatilityCapFloor>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<VolatilityCapFloor>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<VolatilityCapFloor, ISet<string>> OnlyExistsValidator => new VolatilityCapFloorOnlyExistsValidator();

        public IValidator<VolatilityCapFloor> Validator => new VolatilityCapFloorValidator();
    }
    
    /// <summary>
    /// MetaData definition for VolatilityReturnTerms
    /// </summary>
    [RosettaMeta(typeof(VolatilityReturnTerms))]
    public class VolatilityReturnTermsMeta : IRosettaMetaData<VolatilityReturnTerms>
    {
        public IEnumerable<IValidator<VolatilityReturnTerms>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<VolatilityReturnTerms>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<VolatilityReturnTerms, ISet<string>> OnlyExistsValidator => new VolatilityReturnTermsOnlyExistsValidator();

        public IValidator<VolatilityReturnTerms> Validator => new VolatilityReturnTermsValidator();
    }
    
    /// <summary>
    /// MetaData definition for WeightedAveragingObservation
    /// </summary>
    [RosettaMeta(typeof(WeightedAveragingObservation))]
    public class WeightedAveragingObservationMeta : IRosettaMetaData<WeightedAveragingObservation>
    {
        public IEnumerable<IValidator<WeightedAveragingObservation>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<WeightedAveragingObservation>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<WeightedAveragingObservation, ISet<string>> OnlyExistsValidator => new WeightedAveragingObservationOnlyExistsValidator();

        public IValidator<WeightedAveragingObservation> Validator => new WeightedAveragingObservationValidator();
    }
    
    /// <summary>
    /// MetaData definition for Workflow
    /// </summary>
    [RosettaMeta(typeof(Workflow))]
    public class WorkflowMeta : IRosettaMetaData<Workflow>
    {
        public IEnumerable<IValidator<Workflow>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<Workflow>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<Workflow, ISet<string>> OnlyExistsValidator => new WorkflowOnlyExistsValidator();

        public IValidator<Workflow> Validator => new WorkflowValidator();
    }
    
    /// <summary>
    /// MetaData definition for WorkflowState
    /// </summary>
    [RosettaMeta(typeof(WorkflowState))]
    public class WorkflowStateMeta : IRosettaMetaData<WorkflowState>
    {
        public IEnumerable<IValidator<WorkflowState>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<WorkflowState>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<WorkflowState, ISet<string>> OnlyExistsValidator => new WorkflowStateOnlyExistsValidator();

        public IValidator<WorkflowState> Validator => new WorkflowStateValidator();
    }
    
    /// <summary>
    /// MetaData definition for WorkflowStep
    /// </summary>
    [RosettaMeta(typeof(WorkflowStep))]
    public class WorkflowStepMeta : IRosettaMetaData<WorkflowStep>
    {
        public IEnumerable<IValidator<WorkflowStep>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<WorkflowStep>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<WorkflowStep, ISet<string>> OnlyExistsValidator => new WorkflowStepOnlyExistsValidator();

        public IValidator<WorkflowStep> Validator => new WorkflowStepValidator();
    }
    
    /// <summary>
    /// MetaData definition for WorkflowStepApproval
    /// </summary>
    [RosettaMeta(typeof(WorkflowStepApproval))]
    public class WorkflowStepApprovalMeta : IRosettaMetaData<WorkflowStepApproval>
    {
        public IEnumerable<IValidator<WorkflowStepApproval>> DataRules {
            get {
                yield break;
            }
        }
    
        public IEnumerable<IValidator<WorkflowStepApproval>> ChoiceRuleValidators {
            get {
                yield break;
            }
        }
        
        public IValidatorWithArg<WorkflowStepApproval, ISet<string>> OnlyExistsValidator => new WorkflowStepApprovalOnlyExistsValidator();

        public IValidator<WorkflowStepApproval> Validator => new WorkflowStepApprovalValidator();
    }
}
