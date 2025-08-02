// This file is auto-generated from the ISDA Common Domain Model, do not edit.
//
// Version: 6.0.0
//

#nullable enable // Allow nullable reference types

namespace Org.Isda.Cdm.Validation.DataRule
{
    using System.Collections.Generic;
    using System.Linq;
    
    using Org.Isda.Cdm;
    
    using Rosetta.Lib.Functions;
    using Rosetta.Lib.Validation;
    
    public class AccountValidator : AbstractValidator<Account>
    {
    
        public AccountValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Account obj)
        {
            yield return CheckCardinality(Name, "PartyReference", obj.PartyReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AccountName", obj.AccountName?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AccountType", obj.AccountType?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AccountBeneficiary", obj.AccountBeneficiary?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ServicingParty", obj.ServicingParty?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AccountOnlyExistsValidator : AbstractOnlyExistsValidator<Account> {
    
        protected override IDictionary<string, bool> GetFields(Account obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PartyReference", IsSet(obj.PartyReference!) },
                { "AccountNumber", IsSet(obj.AccountNumber!) },
                { "AccountName", IsSet(obj.AccountName!) },
                { "AccountType", IsSet(obj.AccountType!) },
                { "AccountBeneficiary", IsSet(obj.AccountBeneficiary!) },
                { "ServicingParty", IsSet(obj.ServicingParty!) }
            };
        }
    }
    
    public class AcctOwnrValidator : AbstractValidator<AcctOwnr>
    {
    
        public AcctOwnrValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AcctOwnr obj)
        {
            yield break;
        }
    }
    
    public class AcctOwnrOnlyExistsValidator : AbstractOnlyExistsValidator<AcctOwnr> {
    
        protected override IDictionary<string, bool> GetFields(AcctOwnr obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Id", IsSet(obj.Id!) }
            };
        }
    }
    
    public class AdditionalDisruptionEventsValidator : AbstractValidator<AdditionalDisruptionEvents>
    {
    
        public AdditionalDisruptionEventsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AdditionalDisruptionEvents obj)
        {
            yield return CheckCardinality(Name, "ChangeInLaw", obj.ChangeInLaw != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FailureToDeliver", obj.FailureToDeliver != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InsolvencyFiling", obj.InsolvencyFiling != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "HedgingDisruption", obj.HedgingDisruption != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IncreasedCostOfHedging", obj.IncreasedCostOfHedging != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ForeignOwnershipEvent", obj.ForeignOwnershipEvent != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LossOfStockBorrow", obj.LossOfStockBorrow != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MaximumStockLoanRate", obj.MaximumStockLoanRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IncreasedCostOfStockBorrow", obj.IncreasedCostOfStockBorrow != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InitialStockLoanRate", obj.InitialStockLoanRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DeterminingParty", obj.DeterminingParty != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdditionalBespokeTerms", obj.AdditionalBespokeTerms.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class AdditionalDisruptionEventsOnlyExistsValidator : AbstractOnlyExistsValidator<AdditionalDisruptionEvents> {
    
        protected override IDictionary<string, bool> GetFields(AdditionalDisruptionEvents obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ChangeInLaw", IsSet(obj.ChangeInLaw!) },
                { "FailureToDeliver", IsSet(obj.FailureToDeliver!) },
                { "InsolvencyFiling", IsSet(obj.InsolvencyFiling!) },
                { "HedgingDisruption", IsSet(obj.HedgingDisruption!) },
                { "IncreasedCostOfHedging", IsSet(obj.IncreasedCostOfHedging!) },
                { "ForeignOwnershipEvent", IsSet(obj.ForeignOwnershipEvent!) },
                { "LossOfStockBorrow", IsSet(obj.LossOfStockBorrow!) },
                { "MaximumStockLoanRate", IsSet(obj.MaximumStockLoanRate!) },
                { "IncreasedCostOfStockBorrow", IsSet(obj.IncreasedCostOfStockBorrow!) },
                { "InitialStockLoanRate", IsSet(obj.InitialStockLoanRate!) },
                { "DeterminingParty", IsSet(obj.DeterminingParty!) },
                { "AdditionalBespokeTerms", IsSet(obj.AdditionalBespokeTerms!) }
            };
        }
    }
    
    public class AdditionalFixedPaymentsValidator : AbstractValidator<AdditionalFixedPayments>
    {
    
        public AdditionalFixedPaymentsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AdditionalFixedPayments obj)
        {
            yield return CheckCardinality(Name, "InterestShortfallReimbursement", obj.InterestShortfallReimbursement != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PrincipalShortfallReimbursement", obj.PrincipalShortfallReimbursement != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "WritedownReimbursement", obj.WritedownReimbursement != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AdditionalFixedPaymentsOnlyExistsValidator : AbstractOnlyExistsValidator<AdditionalFixedPayments> {
    
        protected override IDictionary<string, bool> GetFields(AdditionalFixedPayments obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InterestShortfallReimbursement", IsSet(obj.InterestShortfallReimbursement!) },
                { "PrincipalShortfallReimbursement", IsSet(obj.PrincipalShortfallReimbursement!) },
                { "WritedownReimbursement", IsSet(obj.WritedownReimbursement!) }
            };
        }
    }
    
    public class AddressValidator : AbstractValidator<Address>
    {
    
        public AddressValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Address obj)
        {
            yield return CheckCardinality(Name, "Street", obj.Street.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "City", obj.City != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "State", obj.State != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Country", obj.Country?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PostalCode", obj.PostalCode != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AddressOnlyExistsValidator : AbstractOnlyExistsValidator<Address> {
    
        protected override IDictionary<string, bool> GetFields(Address obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Street", IsSet(obj.Street!) },
                { "City", IsSet(obj.City!) },
                { "State", IsSet(obj.State!) },
                { "Country", IsSet(obj.Country!) },
                { "PostalCode", IsSet(obj.PostalCode!) }
            };
        }
    }
    
    public class AddressForNoticesValidator : AbstractValidator<AddressForNotices>
    {
    
        public AddressForNoticesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AddressForNotices obj)
        {
            yield return CheckCardinality(Name, "AdditionalNotices", obj.AdditionalNotices.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class AddressForNoticesOnlyExistsValidator : AbstractOnlyExistsValidator<AddressForNotices> {
    
        protected override IDictionary<string, bool> GetFields(AddressForNotices obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PrimaryNotices", IsSet(obj.PrimaryNotices!) },
                { "AdditionalNotices", IsSet(obj.AdditionalNotices!) }
            };
        }
    }
    
    public class AddtlAttrbtsValidator : AbstractValidator<AddtlAttrbts>
    {
    
        public AddtlAttrbtsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AddtlAttrbts obj)
        {
            yield break;
        }
    }
    
    public class AddtlAttrbtsOnlyExistsValidator : AbstractOnlyExistsValidator<AddtlAttrbts> {
    
        protected override IDictionary<string, bool> GetFields(AddtlAttrbts obj)
        {
            return new Dictionary<string, bool>()
            {
                { "RskRdcgTx", IsSet(obj.RskRdcgTx!) },
                { "SctiesFincgTxInd", IsSet(obj.SctiesFincgTxInd!) }
            };
        }
    }
    
    public class AdjustableDateValidator : AbstractValidator<AdjustableDate>
    {
    
        public AdjustableDateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AdjustableDate obj)
        {
            yield return CheckCardinality(Name, "UnadjustedDate", obj.UnadjustedDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DateAdjustments", obj.DateAdjustments != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DateAdjustmentsReference", obj.DateAdjustmentsReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdjustedDate", obj.AdjustedDate?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AdjustableDateOnlyExistsValidator : AbstractOnlyExistsValidator<AdjustableDate> {
    
        protected override IDictionary<string, bool> GetFields(AdjustableDate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "UnadjustedDate", IsSet(obj.UnadjustedDate!) },
                { "DateAdjustments", IsSet(obj.DateAdjustments!) },
                { "DateAdjustmentsReference", IsSet(obj.DateAdjustmentsReference!) },
                { "AdjustedDate", IsSet(obj.AdjustedDate!) }
            };
        }
    }
    
    public class AdjustableDatesValidator : AbstractValidator<AdjustableDates>
    {
    
        public AdjustableDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AdjustableDates obj)
        {
            yield return CheckCardinality(Name, "UnadjustedDate", obj.UnadjustedDate.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "DateAdjustments", obj.DateAdjustments != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdjustedDate", obj.AdjustedDate.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AdjustableDatesOnlyExistsValidator : AbstractOnlyExistsValidator<AdjustableDates> {
    
        protected override IDictionary<string, bool> GetFields(AdjustableDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "UnadjustedDate", IsSet(obj.UnadjustedDate!) },
                { "DateAdjustments", IsSet(obj.DateAdjustments!) },
                { "AdjustedDate", IsSet(obj.AdjustedDate!) }
            };
        }
    }
    
    public class AdjustableOrAdjustedDateValidator : AbstractValidator<AdjustableOrAdjustedDate>
    {
    
        public AdjustableOrAdjustedDateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AdjustableOrAdjustedDate obj)
        {
            yield return CheckCardinality(Name, "UnadjustedDate", obj.UnadjustedDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DateAdjustments", obj.DateAdjustments != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdjustedDate", obj.AdjustedDate?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AdjustableOrAdjustedDateOnlyExistsValidator : AbstractOnlyExistsValidator<AdjustableOrAdjustedDate> {
    
        protected override IDictionary<string, bool> GetFields(AdjustableOrAdjustedDate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "UnadjustedDate", IsSet(obj.UnadjustedDate!) },
                { "DateAdjustments", IsSet(obj.DateAdjustments!) },
                { "AdjustedDate", IsSet(obj.AdjustedDate!) }
            };
        }
    }
    
    public class AdjustableOrAdjustedOrRelativeDateValidator : AbstractValidator<AdjustableOrAdjustedOrRelativeDate>
    {
    
        public AdjustableOrAdjustedOrRelativeDateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AdjustableOrAdjustedOrRelativeDate obj)
        {
            yield return CheckCardinality(Name, "UnadjustedDate", obj.UnadjustedDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DateAdjustments", obj.DateAdjustments != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdjustedDate", obj.AdjustedDate?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RelativeDate", obj.RelativeDate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AdjustableOrAdjustedOrRelativeDateOnlyExistsValidator : AbstractOnlyExistsValidator<AdjustableOrAdjustedOrRelativeDate> {
    
        protected override IDictionary<string, bool> GetFields(AdjustableOrAdjustedOrRelativeDate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "UnadjustedDate", IsSet(obj.UnadjustedDate!) },
                { "DateAdjustments", IsSet(obj.DateAdjustments!) },
                { "AdjustedDate", IsSet(obj.AdjustedDate!) },
                { "RelativeDate", IsSet(obj.RelativeDate!) }
            };
        }
    }
    
    public class AdjustableOrRelativeDateValidator : AbstractValidator<AdjustableOrRelativeDate>
    {
    
        public AdjustableOrRelativeDateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AdjustableOrRelativeDate obj)
        {
            yield return CheckCardinality(Name, "AdjustableDate", obj.AdjustableDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RelativeDate", obj.RelativeDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AdjustableOrRelativeDateOnlyExistsValidator : AbstractOnlyExistsValidator<AdjustableOrRelativeDate> {
    
        protected override IDictionary<string, bool> GetFields(AdjustableOrRelativeDate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AdjustableDate", IsSet(obj.AdjustableDate!) },
                { "RelativeDate", IsSet(obj.RelativeDate!) }
            };
        }
    }
    
    public class AdjustableOrRelativeDatesValidator : AbstractValidator<AdjustableOrRelativeDates>
    {
    
        public AdjustableOrRelativeDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AdjustableOrRelativeDates obj)
        {
            yield return CheckCardinality(Name, "AdjustableDates", obj.AdjustableDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RelativeDates", obj.RelativeDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AdjustableOrRelativeDatesOnlyExistsValidator : AbstractOnlyExistsValidator<AdjustableOrRelativeDates> {
    
        protected override IDictionary<string, bool> GetFields(AdjustableOrRelativeDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AdjustableDates", IsSet(obj.AdjustableDates!) },
                { "RelativeDates", IsSet(obj.RelativeDates!) }
            };
        }
    }
    
    public class AdjustableRelativeOrPeriodicDatesValidator : AbstractValidator<AdjustableRelativeOrPeriodicDates>
    {
    
        public AdjustableRelativeOrPeriodicDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AdjustableRelativeOrPeriodicDates obj)
        {
            yield return CheckCardinality(Name, "AdjustableDates", obj.AdjustableDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RelativeDates", obj.RelativeDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PeriodicDates", obj.PeriodicDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AdjustableRelativeOrPeriodicDatesOnlyExistsValidator : AbstractOnlyExistsValidator<AdjustableRelativeOrPeriodicDates> {
    
        protected override IDictionary<string, bool> GetFields(AdjustableRelativeOrPeriodicDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AdjustableDates", IsSet(obj.AdjustableDates!) },
                { "RelativeDates", IsSet(obj.RelativeDates!) },
                { "PeriodicDates", IsSet(obj.PeriodicDates!) }
            };
        }
    }
    
    public class AdjustedRelativeDateOffsetValidator : AbstractValidator<AdjustedRelativeDateOffset>
    {
    
        public AdjustedRelativeDateOffsetValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AdjustedRelativeDateOffset obj)
        {
            yield return CheckCardinality(Name, "RelativeDateAdjustments", obj.RelativeDateAdjustments != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AdjustedRelativeDateOffsetOnlyExistsValidator : AbstractOnlyExistsValidator<AdjustedRelativeDateOffset> {
    
        protected override IDictionary<string, bool> GetFields(AdjustedRelativeDateOffset obj)
        {
            return new Dictionary<string, bool>()
            {
                { "RelativeDateAdjustments", IsSet(obj.RelativeDateAdjustments!) }
            };
        }
    }
    
    public class AgencyRatingCriteriaValidator : AbstractValidator<AgencyRatingCriteria>
    {
    
        public AgencyRatingCriteriaValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AgencyRatingCriteria obj)
        {
            yield return CheckCardinality(Name, "MismatchResolution", obj.MismatchResolution != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ReferenceAgency", obj.ReferenceAgency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Boundary", obj.Boundary != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AgencyRatingCriteriaOnlyExistsValidator : AbstractOnlyExistsValidator<AgencyRatingCriteria> {
    
        protected override IDictionary<string, bool> GetFields(AgencyRatingCriteria obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CreditNotation", IsSet(obj.CreditNotation!) },
                { "MismatchResolution", IsSet(obj.MismatchResolution!) },
                { "ReferenceAgency", IsSet(obj.ReferenceAgency!) },
                { "Boundary", IsSet(obj.Boundary!) }
            };
        }
    }
    
    public class AggregationParametersValidator : AbstractValidator<AggregationParameters>
    {
    
        public AggregationParametersValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AggregationParameters obj)
        {
            yield return CheckCardinality(Name, "TotalPosition", obj.TotalPosition != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PositionStatus", obj.PositionStatus != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Party", obj.Party.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Product", obj.Product.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "ProductQualifier", obj.ProductQualifier.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "TradeReference", obj.TradeReference.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class AggregationParametersOnlyExistsValidator : AbstractOnlyExistsValidator<AggregationParameters> {
    
        protected override IDictionary<string, bool> GetFields(AggregationParameters obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DateTime", IsSet(obj.DateTime!) },
                { "TotalPosition", IsSet(obj.TotalPosition!) },
                { "PositionStatus", IsSet(obj.PositionStatus!) },
                { "Party", IsSet(obj.Party!) },
                { "Product", IsSet(obj.Product!) },
                { "ProductQualifier", IsSet(obj.ProductQualifier!) },
                { "TradeReference", IsSet(obj.TradeReference!) }
            };
        }
    }
    
    public class AgreementValidator : AbstractValidator<Agreement>
    {
    
        public AgreementValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Agreement obj)
        {
            yield return CheckCardinality(Name, "CreditSupportAgreementElections", obj.CreditSupportAgreementElections != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CollateralTransferAgreementElections", obj.CollateralTransferAgreementElections != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SecurityAgreementElections", obj.SecurityAgreementElections != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MasterAgreementSchedule", obj.MasterAgreementSchedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "TransactionAdditionalTerms", obj.TransactionAdditionalTerms != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AgreementOnlyExistsValidator : AbstractOnlyExistsValidator<Agreement> {
    
        protected override IDictionary<string, bool> GetFields(Agreement obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CreditSupportAgreementElections", IsSet(obj.CreditSupportAgreementElections!) },
                { "CollateralTransferAgreementElections", IsSet(obj.CollateralTransferAgreementElections!) },
                { "SecurityAgreementElections", IsSet(obj.SecurityAgreementElections!) },
                { "MasterAgreementSchedule", IsSet(obj.MasterAgreementSchedule!) },
                { "TransactionAdditionalTerms", IsSet(obj.TransactionAdditionalTerms!) }
            };
        }
    }
    
    public class AgreementNameValidator : AbstractValidator<AgreementName>
    {
    
        public AgreementNameValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AgreementName obj)
        {
            yield return CheckCardinality(Name, "CreditSupportAgreementType", obj.CreditSupportAgreementType?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CreditSupportAgreementMarginType", obj.CreditSupportAgreementMarginType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ContractualDefinitionsType", obj.ContractualDefinitionsType.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "ContractualTermsSupplement", obj.ContractualTermsSupplement.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "ContractualMatrix", obj.ContractualMatrix.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "MasterAgreementType", obj.MasterAgreementType?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MasterConfirmationType", obj.MasterConfirmationType?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MasterConfirmationAnnexType", obj.MasterConfirmationAnnexType?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "OtherAgreement", obj.OtherAgreement != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AgreementNameOnlyExistsValidator : AbstractOnlyExistsValidator<AgreementName> {
    
        protected override IDictionary<string, bool> GetFields(AgreementName obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AgreementType", IsSet(obj.AgreementType!) },
                { "CreditSupportAgreementType", IsSet(obj.CreditSupportAgreementType!) },
                { "CreditSupportAgreementMarginType", IsSet(obj.CreditSupportAgreementMarginType!) },
                { "ContractualDefinitionsType", IsSet(obj.ContractualDefinitionsType!) },
                { "ContractualTermsSupplement", IsSet(obj.ContractualTermsSupplement!) },
                { "ContractualMatrix", IsSet(obj.ContractualMatrix!) },
                { "MasterAgreementType", IsSet(obj.MasterAgreementType!) },
                { "MasterConfirmationType", IsSet(obj.MasterConfirmationType!) },
                { "MasterConfirmationAnnexType", IsSet(obj.MasterConfirmationAnnexType!) },
                { "OtherAgreement", IsSet(obj.OtherAgreement!) }
            };
        }
    }
    
    public class AgreementTermsValidator : AbstractValidator<AgreementTerms>
    {
    
        public AgreementTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AgreementTerms obj)
        {
            yield return CheckCardinality(Name, "ClauseLibrary", obj.ClauseLibrary != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Counterparty", obj.Counterparty.EmptyIfNull().Count(), 2, 2);
            yield break;
        }
    }
    
    public class AgreementTermsOnlyExistsValidator : AbstractOnlyExistsValidator<AgreementTerms> {
    
        protected override IDictionary<string, bool> GetFields(AgreementTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Agreement", IsSet(obj.Agreement!) },
                { "ClauseLibrary", IsSet(obj.ClauseLibrary!) },
                { "Counterparty", IsSet(obj.Counterparty!) }
            };
        }
    }
    
    public class AllCriteriaValidator : AbstractValidator<AllCriteria>
    {
    
        public AllCriteriaValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AllCriteria obj)
        {
            yield return CheckCardinality(Name, "AllCriteriaValue", obj.AllCriteriaValue.EmptyIfNull().Count(), 2, 0);
            yield break;
        }
    }
    
    public class AllCriteriaOnlyExistsValidator : AbstractOnlyExistsValidator<AllCriteria> {
    
        protected override IDictionary<string, bool> GetFields(AllCriteria obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AllCriteriaValue", IsSet(obj.AllCriteriaValue!) }
            };
        }
    }
    
    public class AmountScheduleValidator : AbstractValidator<AmountSchedule>
    {
    
        public AmountScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AmountSchedule obj)
        {
            yield return CheckCardinality(Name, "Currency", obj.Currency.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class AmountScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<AmountSchedule> {
    
        protected override IDictionary<string, bool> GetFields(AmountSchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Currency", IsSet(obj.Currency!) }
            };
        }
    }
    
    public class AncillaryEntityValidator : AbstractValidator<AncillaryEntity>
    {
    
        public AncillaryEntityValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AncillaryEntity obj)
        {
            yield return CheckCardinality(Name, "AncillaryParty", obj.AncillaryParty != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LegalEntity", obj.LegalEntity != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AncillaryEntityOnlyExistsValidator : AbstractOnlyExistsValidator<AncillaryEntity> {
    
        protected override IDictionary<string, bool> GetFields(AncillaryEntity obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AncillaryParty", IsSet(obj.AncillaryParty!) },
                { "LegalEntity", IsSet(obj.LegalEntity!) }
            };
        }
    }
    
    public class AncillaryPartyValidator : AbstractValidator<AncillaryParty>
    {
    
        public AncillaryPartyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AncillaryParty obj)
        {
            yield return CheckCardinality(Name, "PartyReference", obj.PartyReference.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "OnBehalfOf", obj.OnBehalfOf != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AncillaryPartyOnlyExistsValidator : AbstractOnlyExistsValidator<AncillaryParty> {
    
        protected override IDictionary<string, bool> GetFields(AncillaryParty obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Role", IsSet(obj.Role!) },
                { "PartyReference", IsSet(obj.PartyReference!) },
                { "OnBehalfOf", IsSet(obj.OnBehalfOf!) }
            };
        }
    }
    
    public class AnyCriteriaValidator : AbstractValidator<AnyCriteria>
    {
    
        public AnyCriteriaValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AnyCriteria obj)
        {
            yield return CheckCardinality(Name, "AnyCriteriaValue", obj.AnyCriteriaValue.EmptyIfNull().Count(), 2, 0);
            yield break;
        }
    }
    
    public class AnyCriteriaOnlyExistsValidator : AbstractOnlyExistsValidator<AnyCriteria> {
    
        protected override IDictionary<string, bool> GetFields(AnyCriteria obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AnyCriteriaValue", IsSet(obj.AnyCriteriaValue!) }
            };
        }
    }
    
    public class AsianValidator : AbstractValidator<Asian>
    {
    
        public AsianValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Asian obj)
        {
            yield return CheckCardinality(Name, "StrikeFactor", obj.StrikeFactor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AveragingPeriodIn", obj.AveragingPeriodIn != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AveragingPeriodOut", obj.AveragingPeriodOut != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AsianOnlyExistsValidator : AbstractOnlyExistsValidator<Asian> {
    
        protected override IDictionary<string, bool> GetFields(Asian obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AveragingInOut", IsSet(obj.AveragingInOut!) },
                { "StrikeFactor", IsSet(obj.StrikeFactor!) },
                { "AveragingPeriodIn", IsSet(obj.AveragingPeriodIn!) },
                { "AveragingPeriodOut", IsSet(obj.AveragingPeriodOut!) }
            };
        }
    }
    
    public class AssetValidator : AbstractValidator<Asset>
    {
    
        public AssetValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Asset obj)
        {
            yield return CheckCardinality(Name, "Cash", obj.Cash != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Commodity", obj.Commodity != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DigitalAsset", obj.DigitalAsset != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Instrument", obj.Instrument != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AssetOnlyExistsValidator : AbstractOnlyExistsValidator<Asset> {
    
        protected override IDictionary<string, bool> GetFields(Asset obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Cash", IsSet(obj.Cash!) },
                { "Commodity", IsSet(obj.Commodity!) },
                { "DigitalAsset", IsSet(obj.DigitalAsset!) },
                { "Instrument", IsSet(obj.Instrument!) }
            };
        }
    }
    
    public class AssetAgencyRatingValidator : AbstractValidator<AssetAgencyRating>
    {
    
        public AssetAgencyRatingValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AssetAgencyRating obj)
        {
            yield break;
        }
    }
    
    public class AssetAgencyRatingOnlyExistsValidator : AbstractOnlyExistsValidator<AssetAgencyRating> {
    
        protected override IDictionary<string, bool> GetFields(AssetAgencyRating obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AssetAgencyRatingValue", IsSet(obj.AssetAgencyRatingValue!) }
            };
        }
    }
    
    public class AssetBaseValidator : AbstractValidator<AssetBase>
    {
    
        public AssetBaseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AssetBase obj)
        {
            yield return CheckCardinality(Name, "Identifier", obj.Identifier.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "Taxonomy", obj.Taxonomy.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "IsExchangeListed", obj.IsExchangeListed != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Exchange", obj.Exchange != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RelatedExchange", obj.RelatedExchange.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class AssetBaseOnlyExistsValidator : AbstractOnlyExistsValidator<AssetBase> {
    
        protected override IDictionary<string, bool> GetFields(AssetBase obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Identifier", IsSet(obj.Identifier!) },
                { "Taxonomy", IsSet(obj.Taxonomy!) },
                { "IsExchangeListed", IsSet(obj.IsExchangeListed!) },
                { "Exchange", IsSet(obj.Exchange!) },
                { "RelatedExchange", IsSet(obj.RelatedExchange!) }
            };
        }
    }
    
    public class AssetCountryOfOriginValidator : AbstractValidator<AssetCountryOfOrigin>
    {
    
        public AssetCountryOfOriginValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AssetCountryOfOrigin obj)
        {
            yield break;
        }
    }
    
    public class AssetCountryOfOriginOnlyExistsValidator : AbstractOnlyExistsValidator<AssetCountryOfOrigin> {
    
        protected override IDictionary<string, bool> GetFields(AssetCountryOfOrigin obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AssetCountryOfOriginValue", IsSet(obj.AssetCountryOfOriginValue!) }
            };
        }
    }
    
    public class AssetDeliveryInformationValidator : AbstractValidator<AssetDeliveryInformation>
    {
    
        public AssetDeliveryInformationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AssetDeliveryInformation obj)
        {
            yield return CheckCardinality(Name, "Periods", obj.Periods != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Location", obj.Location.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "DeliveryCapacity", obj.DeliveryCapacity != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AssetDeliveryInformationOnlyExistsValidator : AbstractOnlyExistsValidator<AssetDeliveryInformation> {
    
        protected override IDictionary<string, bool> GetFields(AssetDeliveryInformation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Periods", IsSet(obj.Periods!) },
                { "Location", IsSet(obj.Location!) },
                { "DeliveryCapacity", IsSet(obj.DeliveryCapacity!) }
            };
        }
    }
    
    public class AssetDeliveryPeriodsValidator : AbstractValidator<AssetDeliveryPeriods>
    {
    
        public AssetDeliveryPeriodsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AssetDeliveryPeriods obj)
        {
            yield return CheckCardinality(Name, "Profile", obj.Profile.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "StartDate", obj.StartDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EndDate", obj.EndDate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AssetDeliveryPeriodsOnlyExistsValidator : AbstractOnlyExistsValidator<AssetDeliveryPeriods> {
    
        protected override IDictionary<string, bool> GetFields(AssetDeliveryPeriods obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Profile", IsSet(obj.Profile!) },
                { "StartDate", IsSet(obj.StartDate!) },
                { "EndDate", IsSet(obj.EndDate!) }
            };
        }
    }
    
    public class AssetDeliveryProfileValidator : AbstractValidator<AssetDeliveryProfile>
    {
    
        public AssetDeliveryProfileValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AssetDeliveryProfile obj)
        {
            yield return CheckCardinality(Name, "LoadType", obj.LoadType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Block", obj.Block.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "BankHolidaysTreatment", obj.BankHolidaysTreatment != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AssetDeliveryProfileOnlyExistsValidator : AbstractOnlyExistsValidator<AssetDeliveryProfile> {
    
        protected override IDictionary<string, bool> GetFields(AssetDeliveryProfile obj)
        {
            return new Dictionary<string, bool>()
            {
                { "LoadType", IsSet(obj.LoadType!) },
                { "Block", IsSet(obj.Block!) },
                { "BankHolidaysTreatment", IsSet(obj.BankHolidaysTreatment!) }
            };
        }
    }
    
    public class AssetDeliveryProfileBlockValidator : AbstractValidator<AssetDeliveryProfileBlock>
    {
    
        public AssetDeliveryProfileBlockValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AssetDeliveryProfileBlock obj)
        {
            yield return CheckCardinality(Name, "StartTime", obj.StartTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EndTime", obj.EndTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DayOfWeek", obj.DayOfWeek.EmptyIfNull().Count(), 0, 7);
            yield return CheckCardinality(Name, "DeliveryCapacity", obj.DeliveryCapacity != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PriceTimeIntervalQuantity", obj.PriceTimeIntervalQuantity != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AssetDeliveryProfileBlockOnlyExistsValidator : AbstractOnlyExistsValidator<AssetDeliveryProfileBlock> {
    
        protected override IDictionary<string, bool> GetFields(AssetDeliveryProfileBlock obj)
        {
            return new Dictionary<string, bool>()
            {
                { "StartTime", IsSet(obj.StartTime!) },
                { "EndTime", IsSet(obj.EndTime!) },
                { "DayOfWeek", IsSet(obj.DayOfWeek!) },
                { "DeliveryCapacity", IsSet(obj.DeliveryCapacity!) },
                { "PriceTimeIntervalQuantity", IsSet(obj.PriceTimeIntervalQuantity!) }
            };
        }
    }
    
    public class AssetFlowBaseValidator : AbstractValidator<AssetFlowBase>
    {
    
        public AssetFlowBaseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AssetFlowBase obj)
        {
            yield break;
        }
    }
    
    public class AssetFlowBaseOnlyExistsValidator : AbstractOnlyExistsValidator<AssetFlowBase> {
    
        protected override IDictionary<string, bool> GetFields(AssetFlowBase obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Quantity", IsSet(obj.Quantity!) },
                { "Asset", IsSet(obj.Asset!) },
                { "SettlementDate", IsSet(obj.SettlementDate!) }
            };
        }
    }
    
    public class AssetIdentifierValidator : AbstractValidator<AssetIdentifier>
    {
    
        public AssetIdentifierValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AssetIdentifier obj)
        {
            yield break;
        }
    }
    
    public class AssetIdentifierOnlyExistsValidator : AbstractOnlyExistsValidator<AssetIdentifier> {
    
        protected override IDictionary<string, bool> GetFields(AssetIdentifier obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Identifier", IsSet(obj.Identifier!) },
                { "IdentifierType", IsSet(obj.IdentifierType!) }
            };
        }
    }
    
    public class AssetLegValidator : AbstractValidator<AssetLeg>
    {
    
        public AssetLegValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AssetLeg obj)
        {
            yield break;
        }
    }
    
    public class AssetLegOnlyExistsValidator : AbstractOnlyExistsValidator<AssetLeg> {
    
        protected override IDictionary<string, bool> GetFields(AssetLeg obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SettlementDate", IsSet(obj.SettlementDate!) },
                { "DeliveryMethod", IsSet(obj.DeliveryMethod!) }
            };
        }
    }
    
    public class AssetMaturityValidator : AbstractValidator<AssetMaturity>
    {
    
        public AssetMaturityValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AssetMaturity obj)
        {
            yield break;
        }
    }
    
    public class AssetMaturityOnlyExistsValidator : AbstractOnlyExistsValidator<AssetMaturity> {
    
        protected override IDictionary<string, bool> GetFields(AssetMaturity obj)
        {
            return new Dictionary<string, bool>()
            {
                { "MaturityType", IsSet(obj.MaturityType!) },
                { "MaturityRange", IsSet(obj.MaturityRange!) }
            };
        }
    }
    
    public class AssetPayoutValidator : AbstractValidator<AssetPayout>
    {
    
        public AssetPayoutValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AssetPayout obj)
        {
            yield return CheckCardinality(Name, "AssetLeg", obj.AssetLeg.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "MinimumFee", obj.MinimumFee != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DividendTerms", obj.DividendTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "TradeType", obj.TradeType != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AssetPayoutOnlyExistsValidator : AbstractOnlyExistsValidator<AssetPayout> {
    
        protected override IDictionary<string, bool> GetFields(AssetPayout obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AssetLeg", IsSet(obj.AssetLeg!) },
                { "Underlier", IsSet(obj.Underlier!) },
                { "MinimumFee", IsSet(obj.MinimumFee!) },
                { "DividendTerms", IsSet(obj.DividendTerms!) },
                { "TradeType", IsSet(obj.TradeType!) }
            };
        }
    }
    
    public class AssetTypeValidator : AbstractValidator<AssetType>
    {
    
        public AssetTypeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AssetType obj)
        {
            yield return CheckCardinality(Name, "SecurityType", obj.SecurityType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DebtType", obj.DebtType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EquityType", obj.EquityType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FundType", obj.FundType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "OtherAssetType", obj.OtherAssetType.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class AssetTypeOnlyExistsValidator : AbstractOnlyExistsValidator<AssetType> {
    
        protected override IDictionary<string, bool> GetFields(AssetType obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AssetTypeValue", IsSet(obj.AssetTypeValue!) },
                { "SecurityType", IsSet(obj.SecurityType!) },
                { "DebtType", IsSet(obj.DebtType!) },
                { "EquityType", IsSet(obj.EquityType!) },
                { "FundType", IsSet(obj.FundType!) },
                { "OtherAssetType", IsSet(obj.OtherAssetType!) }
            };
        }
    }
    
    public class AssignedIdentifierValidator : AbstractValidator<AssignedIdentifier>
    {
    
        public AssignedIdentifierValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AssignedIdentifier obj)
        {
            yield return CheckCardinality(Name, "Version", obj.Version != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AssignedIdentifierOnlyExistsValidator : AbstractOnlyExistsValidator<AssignedIdentifier> {
    
        protected override IDictionary<string, bool> GetFields(AssignedIdentifier obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Identifier", IsSet(obj.Identifier!) },
                { "Version", IsSet(obj.Version!) }
            };
        }
    }
    
    public class AutomaticExerciseValidator : AbstractValidator<AutomaticExercise>
    {
    
        public AutomaticExerciseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AutomaticExercise obj)
        {
            yield return CheckCardinality(Name, "ThresholdRate", obj.ThresholdRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IsApplicable", obj.IsApplicable != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AutomaticExerciseOnlyExistsValidator : AbstractOnlyExistsValidator<AutomaticExercise> {
    
        protected override IDictionary<string, bool> GetFields(AutomaticExercise obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ThresholdRate", IsSet(obj.ThresholdRate!) },
                { "IsApplicable", IsSet(obj.IsApplicable!) }
            };
        }
    }
    
    public class AvailableInventoryValidator : AbstractValidator<AvailableInventory>
    {
    
        public AvailableInventoryValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AvailableInventory obj)
        {
            yield return CheckCardinality(Name, "MessageInformation", obj.MessageInformation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Party", obj.Party.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "PartyRole", obj.PartyRole.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "AvailableInventoryRecord", obj.AvailableInventoryRecord.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class AvailableInventoryOnlyExistsValidator : AbstractOnlyExistsValidator<AvailableInventory> {
    
        protected override IDictionary<string, bool> GetFields(AvailableInventory obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AvailableInventoryType", IsSet(obj.AvailableInventoryType!) },
                { "MessageInformation", IsSet(obj.MessageInformation!) },
                { "Party", IsSet(obj.Party!) },
                { "PartyRole", IsSet(obj.PartyRole!) },
                { "AvailableInventoryRecord", IsSet(obj.AvailableInventoryRecord!) }
            };
        }
    }
    
    public class AvailableInventoryRecordValidator : AbstractValidator<AvailableInventoryRecord>
    {
    
        public AvailableInventoryRecordValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AvailableInventoryRecord obj)
        {
            yield return CheckCardinality(Name, "ExpirationDateTime", obj.ExpirationDateTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Collateral", obj.Collateral.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "PartyRole", obj.PartyRole.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Quantity", obj.Quantity != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InterestRate", obj.InterestRate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AvailableInventoryRecordOnlyExistsValidator : AbstractOnlyExistsValidator<AvailableInventoryRecord> {
    
        protected override IDictionary<string, bool> GetFields(AvailableInventoryRecord obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ExpirationDateTime", IsSet(obj.ExpirationDateTime!) },
                { "Collateral", IsSet(obj.Collateral!) },
                { "PartyRole", IsSet(obj.PartyRole!) },
                { "Quantity", IsSet(obj.Quantity!) },
                { "InterestRate", IsSet(obj.InterestRate!) }
            };
        }
    }
    
    public class AverageTradingVolumeValidator : AbstractValidator<AverageTradingVolume>
    {
    
        public AverageTradingVolumeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AverageTradingVolume obj)
        {
            yield break;
        }
    }
    
    public class AverageTradingVolumeOnlyExistsValidator : AbstractOnlyExistsValidator<AverageTradingVolume> {
    
        protected override IDictionary<string, bool> GetFields(AverageTradingVolume obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Period", IsSet(obj.Period!) },
                { "Methodology", IsSet(obj.Methodology!) }
            };
        }
    }
    
    public class AveragingCalculationValidator : AbstractValidator<AveragingCalculation>
    {
    
        public AveragingCalculationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AveragingCalculation obj)
        {
            yield break;
        }
    }
    
    public class AveragingCalculationOnlyExistsValidator : AbstractOnlyExistsValidator<AveragingCalculation> {
    
        protected override IDictionary<string, bool> GetFields(AveragingCalculation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AveragingMethod", IsSet(obj.AveragingMethod!) },
                { "Precision", IsSet(obj.Precision!) }
            };
        }
    }
    
    public class AveragingCalculationMethodValidator : AbstractValidator<AveragingCalculationMethod>
    {
    
        public AveragingCalculationMethodValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AveragingCalculationMethod obj)
        {
            yield break;
        }
    }
    
    public class AveragingCalculationMethodOnlyExistsValidator : AbstractOnlyExistsValidator<AveragingCalculationMethod> {
    
        protected override IDictionary<string, bool> GetFields(AveragingCalculationMethod obj)
        {
            return new Dictionary<string, bool>()
            {
                { "IsWeighted", IsSet(obj.IsWeighted!) },
                { "CalculationMethod", IsSet(obj.CalculationMethod!) }
            };
        }
    }
    
    public class AveragingObservationListValidator : AbstractValidator<AveragingObservationList>
    {
    
        public AveragingObservationListValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AveragingObservationList obj)
        {
            yield return CheckCardinality(Name, "AveragingObservation", obj.AveragingObservation.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class AveragingObservationListOnlyExistsValidator : AbstractOnlyExistsValidator<AveragingObservationList> {
    
        protected override IDictionary<string, bool> GetFields(AveragingObservationList obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AveragingObservation", IsSet(obj.AveragingObservation!) }
            };
        }
    }
    
    public class AveragingPeriodValidator : AbstractValidator<AveragingPeriod>
    {
    
        public AveragingPeriodValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AveragingPeriod obj)
        {
            yield return CheckCardinality(Name, "Schedule", obj.Schedule.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "AveragingDateTimes", obj.AveragingDateTimes != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AveragingObservations", obj.AveragingObservations != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MarketDisruption", obj.MarketDisruption?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class AveragingPeriodOnlyExistsValidator : AbstractOnlyExistsValidator<AveragingPeriod> {
    
        protected override IDictionary<string, bool> GetFields(AveragingPeriod obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Schedule", IsSet(obj.Schedule!) },
                { "AveragingDateTimes", IsSet(obj.AveragingDateTimes!) },
                { "AveragingObservations", IsSet(obj.AveragingObservations!) },
                { "MarketDisruption", IsSet(obj.MarketDisruption!) }
            };
        }
    }
    
    public class AveragingScheduleValidator : AbstractValidator<AveragingSchedule>
    {
    
        public AveragingScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AveragingSchedule obj)
        {
            yield break;
        }
    }
    
    public class AveragingScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<AveragingSchedule> {
    
        protected override IDictionary<string, bool> GetFields(AveragingSchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "StartDate", IsSet(obj.StartDate!) },
                { "EndDate", IsSet(obj.EndDate!) },
                { "AveragingPeriodFrequency", IsSet(obj.AveragingPeriodFrequency!) }
            };
        }
    }
    
    public class AveragingStrikeFeatureValidator : AbstractValidator<AveragingStrikeFeature>
    {
    
        public AveragingStrikeFeatureValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(AveragingStrikeFeature obj)
        {
            yield break;
        }
    }
    
    public class AveragingStrikeFeatureOnlyExistsValidator : AbstractOnlyExistsValidator<AveragingStrikeFeature> {
    
        protected override IDictionary<string, bool> GetFields(AveragingStrikeFeature obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AveragingCalculation", IsSet(obj.AveragingCalculation!) },
                { "ObservationTerms", IsSet(obj.ObservationTerms!) }
            };
        }
    }
    
    public class BarrierValidator : AbstractValidator<Barrier>
    {
    
        public BarrierValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Barrier obj)
        {
            yield return CheckCardinality(Name, "BarrierCap", obj.BarrierCap != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BarrierFloor", obj.BarrierFloor != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class BarrierOnlyExistsValidator : AbstractOnlyExistsValidator<Barrier> {
    
        protected override IDictionary<string, bool> GetFields(Barrier obj)
        {
            return new Dictionary<string, bool>()
            {
                { "BarrierCap", IsSet(obj.BarrierCap!) },
                { "BarrierFloor", IsSet(obj.BarrierFloor!) }
            };
        }
    }
    
    public class BasketValidator : AbstractValidator<Basket>
    {
    
        public BasketValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Basket obj)
        {
            yield return CheckCardinality(Name, "BasketConstituent", obj.BasketConstituent.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class BasketOnlyExistsValidator : AbstractOnlyExistsValidator<Basket> {
    
        protected override IDictionary<string, bool> GetFields(Basket obj)
        {
            return new Dictionary<string, bool>()
            {
                { "BasketConstituent", IsSet(obj.BasketConstituent!) }
            };
        }
    }
    
    public class BasketConstituentValidator : AbstractValidator<BasketConstituent>
    {
    
        public BasketConstituentValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BasketConstituent obj)
        {
            yield return CheckCardinality(Name, "Quantity", obj.Quantity.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "InitialValuationPrice", obj.InitialValuationPrice.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "InterimValuationPrice", obj.InterimValuationPrice.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "FinalValuationPrice", obj.FinalValuationPrice.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class BasketConstituentOnlyExistsValidator : AbstractOnlyExistsValidator<BasketConstituent> {
    
        protected override IDictionary<string, bool> GetFields(BasketConstituent obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Quantity", IsSet(obj.Quantity!) },
                { "InitialValuationPrice", IsSet(obj.InitialValuationPrice!) },
                { "InterimValuationPrice", IsSet(obj.InterimValuationPrice!) },
                { "FinalValuationPrice", IsSet(obj.FinalValuationPrice!) }
            };
        }
    }
    
    public class BasketReferenceInformationValidator : AbstractValidator<BasketReferenceInformation>
    {
    
        public BasketReferenceInformationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BasketReferenceInformation obj)
        {
            yield return CheckCardinality(Name, "BasketName", obj.BasketName?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BasketId", obj.BasketId.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "NthToDefault", obj.NthToDefault != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MthToDefault", obj.MthToDefault != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Tranche", obj.Tranche != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class BasketReferenceInformationOnlyExistsValidator : AbstractOnlyExistsValidator<BasketReferenceInformation> {
    
        protected override IDictionary<string, bool> GetFields(BasketReferenceInformation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "BasketName", IsSet(obj.BasketName!) },
                { "BasketId", IsSet(obj.BasketId!) },
                { "ReferencePool", IsSet(obj.ReferencePool!) },
                { "NthToDefault", IsSet(obj.NthToDefault!) },
                { "MthToDefault", IsSet(obj.MthToDefault!) },
                { "Tranche", IsSet(obj.Tranche!) }
            };
        }
    }
    
    public class BillingInstructionValidator : AbstractValidator<BillingInstruction>
    {
    
        public BillingInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BillingInstruction obj)
        {
            yield return CheckCardinality(Name, "BillingRecordInstruction", obj.BillingRecordInstruction.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "BillingSummary", obj.BillingSummary.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class BillingInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<BillingInstruction> {
    
        protected override IDictionary<string, bool> GetFields(BillingInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SendingParty", IsSet(obj.SendingParty!) },
                { "ReceivingParty", IsSet(obj.ReceivingParty!) },
                { "BillingStartDate", IsSet(obj.BillingStartDate!) },
                { "BillingEndDate", IsSet(obj.BillingEndDate!) },
                { "BillingRecordInstruction", IsSet(obj.BillingRecordInstruction!) },
                { "BillingSummary", IsSet(obj.BillingSummary!) }
            };
        }
    }
    
    public class BillingRecordValidator : AbstractValidator<BillingRecord>
    {
    
        public BillingRecordValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BillingRecord obj)
        {
            yield return CheckCardinality(Name, "TradeState", obj.TradeState.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "MinimumFee", obj.MinimumFee != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class BillingRecordOnlyExistsValidator : AbstractOnlyExistsValidator<BillingRecord> {
    
        protected override IDictionary<string, bool> GetFields(BillingRecord obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TradeState", IsSet(obj.TradeState!) },
                { "RecordTransfer", IsSet(obj.RecordTransfer!) },
                { "RecordStartDate", IsSet(obj.RecordStartDate!) },
                { "RecordEndDate", IsSet(obj.RecordEndDate!) },
                { "MinimumFee", IsSet(obj.MinimumFee!) }
            };
        }
    }
    
    public class BillingRecordInstructionValidator : AbstractValidator<BillingRecordInstruction>
    {
    
        public BillingRecordInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BillingRecordInstruction obj)
        {
            yield return CheckCardinality(Name, "TradeState", obj.TradeState.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "Observation", obj.Observation.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class BillingRecordInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<BillingRecordInstruction> {
    
        protected override IDictionary<string, bool> GetFields(BillingRecordInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TradeState", IsSet(obj.TradeState!) },
                { "Observation", IsSet(obj.Observation!) },
                { "RecordStartDate", IsSet(obj.RecordStartDate!) },
                { "RecordEndDate", IsSet(obj.RecordEndDate!) },
                { "SettlementDate", IsSet(obj.SettlementDate!) }
            };
        }
    }
    
    public class BillingSummaryValidator : AbstractValidator<BillingSummary>
    {
    
        public BillingSummaryValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BillingSummary obj)
        {
            yield return CheckCardinality(Name, "SummaryTransfer", obj.SummaryTransfer != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class BillingSummaryOnlyExistsValidator : AbstractOnlyExistsValidator<BillingSummary> {
    
        protected override IDictionary<string, bool> GetFields(BillingSummary obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SummaryTransfer", IsSet(obj.SummaryTransfer!) },
                { "SummaryAmountType", IsSet(obj.SummaryAmountType!) }
            };
        }
    }
    
    public class BillingSummaryInstructionValidator : AbstractValidator<BillingSummaryInstruction>
    {
    
        public BillingSummaryInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BillingSummaryInstruction obj)
        {
            yield break;
        }
    }
    
    public class BillingSummaryInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<BillingSummaryInstruction> {
    
        protected override IDictionary<string, bool> GetFields(BillingSummaryInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SummaryAmountType", IsSet(obj.SummaryAmountType!) }
            };
        }
    }
    
    public class BondReferenceValidator : AbstractValidator<BondReference>
    {
    
        public BondReferenceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BondReference obj)
        {
            yield return CheckCardinality(Name, "DiscrepancyClause", obj.DiscrepancyClause != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CouponRate", obj.CouponRate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class BondReferenceOnlyExistsValidator : AbstractOnlyExistsValidator<BondReference> {
    
        protected override IDictionary<string, bool> GetFields(BondReference obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Bond", IsSet(obj.Bond!) },
                { "ConditionPrecedentBond", IsSet(obj.ConditionPrecedentBond!) },
                { "DiscrepancyClause", IsSet(obj.DiscrepancyClause!) },
                { "CouponRate", IsSet(obj.CouponRate!) }
            };
        }
    }
    
    public class BoundedCorrelationValidator : AbstractValidator<BoundedCorrelation>
    {
    
        public BoundedCorrelationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BoundedCorrelation obj)
        {
            yield return CheckCardinality(Name, "MinimumBoundaryPercent", obj.MinimumBoundaryPercent != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MaximumBoundaryPercent", obj.MaximumBoundaryPercent != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class BoundedCorrelationOnlyExistsValidator : AbstractOnlyExistsValidator<BoundedCorrelation> {
    
        protected override IDictionary<string, bool> GetFields(BoundedCorrelation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "MinimumBoundaryPercent", IsSet(obj.MinimumBoundaryPercent!) },
                { "MaximumBoundaryPercent", IsSet(obj.MaximumBoundaryPercent!) }
            };
        }
    }
    
    public class BoundedVarianceValidator : AbstractValidator<BoundedVariance>
    {
    
        public BoundedVarianceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BoundedVariance obj)
        {
            yield return CheckCardinality(Name, "UpperBarrier", obj.UpperBarrier != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LowerBarrier", obj.LowerBarrier != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class BoundedVarianceOnlyExistsValidator : AbstractOnlyExistsValidator<BoundedVariance> {
    
        protected override IDictionary<string, bool> GetFields(BoundedVariance obj)
        {
            return new Dictionary<string, bool>()
            {
                { "RealisedVarianceMethod", IsSet(obj.RealisedVarianceMethod!) },
                { "DaysInRangeAdjustment", IsSet(obj.DaysInRangeAdjustment!) },
                { "UpperBarrier", IsSet(obj.UpperBarrier!) },
                { "LowerBarrier", IsSet(obj.LowerBarrier!) }
            };
        }
    }
    
    public class BusinessCenterTimeValidator : AbstractValidator<BusinessCenterTime>
    {
    
        public BusinessCenterTimeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BusinessCenterTime obj)
        {
            yield break;
        }
    }
    
    public class BusinessCenterTimeOnlyExistsValidator : AbstractOnlyExistsValidator<BusinessCenterTime> {
    
        protected override IDictionary<string, bool> GetFields(BusinessCenterTime obj)
        {
            return new Dictionary<string, bool>()
            {
                { "HourMinuteTime", IsSet(obj.HourMinuteTime!) },
                { "BusinessCenter", IsSet(obj.BusinessCenter!) }
            };
        }
    }
    
    public class BusinessCentersValidator : AbstractValidator<BusinessCenters>
    {
    
        public BusinessCentersValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BusinessCenters obj)
        {
            yield return CheckCardinality(Name, "BusinessCenter", obj.BusinessCenter.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "CommodityBusinessCalendar", obj.CommodityBusinessCalendar.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "BusinessCentersReference", obj.BusinessCentersReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class BusinessCentersOnlyExistsValidator : AbstractOnlyExistsValidator<BusinessCenters> {
    
        protected override IDictionary<string, bool> GetFields(BusinessCenters obj)
        {
            return new Dictionary<string, bool>()
            {
                { "BusinessCenter", IsSet(obj.BusinessCenter!) },
                { "CommodityBusinessCalendar", IsSet(obj.CommodityBusinessCalendar!) },
                { "BusinessCentersReference", IsSet(obj.BusinessCentersReference!) }
            };
        }
    }
    
    public class BusinessDateRangeValidator : AbstractValidator<BusinessDateRange>
    {
    
        public BusinessDateRangeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BusinessDateRange obj)
        {
            yield return CheckCardinality(Name, "BusinessCenters", obj.BusinessCenters != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class BusinessDateRangeOnlyExistsValidator : AbstractOnlyExistsValidator<BusinessDateRange> {
    
        protected override IDictionary<string, bool> GetFields(BusinessDateRange obj)
        {
            return new Dictionary<string, bool>()
            {
                { "BusinessDayConvention", IsSet(obj.BusinessDayConvention!) },
                { "BusinessCenters", IsSet(obj.BusinessCenters!) }
            };
        }
    }
    
    public class BusinessDayAdjustmentsValidator : AbstractValidator<BusinessDayAdjustments>
    {
    
        public BusinessDayAdjustmentsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BusinessDayAdjustments obj)
        {
            yield return CheckCardinality(Name, "BusinessCenters", obj.BusinessCenters != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class BusinessDayAdjustmentsOnlyExistsValidator : AbstractOnlyExistsValidator<BusinessDayAdjustments> {
    
        protected override IDictionary<string, bool> GetFields(BusinessDayAdjustments obj)
        {
            return new Dictionary<string, bool>()
            {
                { "BusinessDayConvention", IsSet(obj.BusinessDayConvention!) },
                { "BusinessCenters", IsSet(obj.BusinessCenters!) }
            };
        }
    }
    
    public class BusinessEventValidator : AbstractValidator<BusinessEvent>
    {
    
        public BusinessEventValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BusinessEvent obj)
        {
            yield return CheckCardinality(Name, "EventQualifier", obj.EventQualifier != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "After", obj.After.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class BusinessEventOnlyExistsValidator : AbstractOnlyExistsValidator<BusinessEvent> {
    
        protected override IDictionary<string, bool> GetFields(BusinessEvent obj)
        {
            return new Dictionary<string, bool>()
            {
                { "EventQualifier", IsSet(obj.EventQualifier!) },
                { "After", IsSet(obj.After!) }
            };
        }
    }
    
    public class BusinessUnitValidator : AbstractValidator<BusinessUnit>
    {
    
        public BusinessUnitValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BusinessUnit obj)
        {
            yield return CheckCardinality(Name, "Identifier", obj.Identifier != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ContactInformation", obj.ContactInformation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class BusinessUnitOnlyExistsValidator : AbstractOnlyExistsValidator<BusinessUnit> {
    
        protected override IDictionary<string, bool> GetFields(BusinessUnit obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Name", IsSet(obj.Name!) },
                { "Identifier", IsSet(obj.Identifier!) },
                { "ContactInformation", IsSet(obj.ContactInformation!) }
            };
        }
    }
    
    public class BuyerSellerValidator : AbstractValidator<BuyerSeller>
    {
    
        public BuyerSellerValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(BuyerSeller obj)
        {
            yield break;
        }
    }
    
    public class BuyerSellerOnlyExistsValidator : AbstractOnlyExistsValidator<BuyerSeller> {
    
        protected override IDictionary<string, bool> GetFields(BuyerSeller obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Buyer", IsSet(obj.Buyer!) },
                { "Seller", IsSet(obj.Seller!) }
            };
        }
    }
    
    public class BuyrValidator : AbstractValidator<Buyr>
    {
    
        public BuyrValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Buyr obj)
        {
            yield break;
        }
    }
    
    public class BuyrOnlyExistsValidator : AbstractOnlyExistsValidator<Buyr> {
    
        protected override IDictionary<string, bool> GetFields(Buyr obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AcctOwnr", IsSet(obj.AcctOwnr!) }
            };
        }
    }
    
    public class CalculateTransferInstructionValidator : AbstractValidator<CalculateTransferInstruction>
    {
    
        public CalculateTransferInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CalculateTransferInstruction obj)
        {
            yield return CheckCardinality(Name, "Payout", obj.Payout.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "Resets", obj.Resets.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "PayerReceiver", obj.PayerReceiver != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Quantity", obj.Quantity != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Date", obj.Date != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CalculateTransferInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<CalculateTransferInstruction> {
    
        protected override IDictionary<string, bool> GetFields(CalculateTransferInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TradeState", IsSet(obj.TradeState!) },
                { "Payout", IsSet(obj.Payout!) },
                { "Resets", IsSet(obj.Resets!) },
                { "PayerReceiver", IsSet(obj.PayerReceiver!) },
                { "Quantity", IsSet(obj.Quantity!) },
                { "Date", IsSet(obj.Date!) }
            };
        }
    }
    
    public class CalculatedRateDetailsValidator : AbstractValidator<CalculatedRateDetails>
    {
    
        public CalculatedRateDetailsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CalculatedRateDetails obj)
        {
            yield return CheckCardinality(Name, "Observations", obj.Observations != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "WeightedRates", obj.WeightedRates.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "GrowthFactor", obj.GrowthFactor.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "CompoundedGrowth", obj.CompoundedGrowth.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "AggregateValue", obj.AggregateValue != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AggregateWeight", obj.AggregateWeight != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculatedRate", obj.CalculatedRate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CalculatedRateDetailsOnlyExistsValidator : AbstractOnlyExistsValidator<CalculatedRateDetails> {
    
        protected override IDictionary<string, bool> GetFields(CalculatedRateDetails obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Observations", IsSet(obj.Observations!) },
                { "WeightedRates", IsSet(obj.WeightedRates!) },
                { "GrowthFactor", IsSet(obj.GrowthFactor!) },
                { "CompoundedGrowth", IsSet(obj.CompoundedGrowth!) },
                { "AggregateValue", IsSet(obj.AggregateValue!) },
                { "AggregateWeight", IsSet(obj.AggregateWeight!) },
                { "CalculatedRate", IsSet(obj.CalculatedRate!) }
            };
        }
    }
    
    public class CalculatedRateObservationDatesAndWeightsValidator : AbstractValidator<CalculatedRateObservationDatesAndWeights>
    {
    
        public CalculatedRateObservationDatesAndWeightsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CalculatedRateObservationDatesAndWeights obj)
        {
            yield return CheckCardinality(Name, "ObservationDates", obj.ObservationDates.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Weights", obj.Weights.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class CalculatedRateObservationDatesAndWeightsOnlyExistsValidator : AbstractOnlyExistsValidator<CalculatedRateObservationDatesAndWeights> {
    
        protected override IDictionary<string, bool> GetFields(CalculatedRateObservationDatesAndWeights obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ObservationDates", IsSet(obj.ObservationDates!) },
                { "Weights", IsSet(obj.Weights!) }
            };
        }
    }
    
    public class CalculatedRateObservationsValidator : AbstractValidator<CalculatedRateObservations>
    {
    
        public CalculatedRateObservationsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CalculatedRateObservations obj)
        {
            yield return CheckCardinality(Name, "ObservationDates", obj.ObservationDates.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Weights", obj.Weights.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "ObservedRates", obj.ObservedRates.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "ProcessedRates", obj.ProcessedRates.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class CalculatedRateObservationsOnlyExistsValidator : AbstractOnlyExistsValidator<CalculatedRateObservations> {
    
        protected override IDictionary<string, bool> GetFields(CalculatedRateObservations obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ObservationDates", IsSet(obj.ObservationDates!) },
                { "Weights", IsSet(obj.Weights!) },
                { "ObservedRates", IsSet(obj.ObservedRates!) },
                { "ProcessedRates", IsSet(obj.ProcessedRates!) }
            };
        }
    }
    
    public class CalculationAgentValidator : AbstractValidator<CalculationAgent>
    {
    
        public CalculationAgentValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CalculationAgent obj)
        {
            yield return CheckCardinality(Name, "CalculationAgentParty", obj.CalculationAgentParty != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationAgentPartyEnum", obj.CalculationAgentPartyEnum != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationAgentBusinessCenter", obj.CalculationAgentBusinessCenter?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CalculationAgentOnlyExistsValidator : AbstractOnlyExistsValidator<CalculationAgent> {
    
        protected override IDictionary<string, bool> GetFields(CalculationAgent obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CalculationAgentParty", IsSet(obj.CalculationAgentParty!) },
                { "CalculationAgentPartyEnum", IsSet(obj.CalculationAgentPartyEnum!) },
                { "CalculationAgentBusinessCenter", IsSet(obj.CalculationAgentBusinessCenter!) }
            };
        }
    }
    
    public class CalculationFrequencyValidator : AbstractValidator<CalculationFrequency>
    {
    
        public CalculationFrequencyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CalculationFrequency obj)
        {
            yield return CheckCardinality(Name, "MonthOfYear", obj.MonthOfYear != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DayOfMonth", obj.DayOfMonth != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DayOfWeek", obj.DayOfWeek != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "WeekOfMonth", obj.WeekOfMonth != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BusinessCenter", obj.BusinessCenter.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class CalculationFrequencyOnlyExistsValidator : AbstractOnlyExistsValidator<CalculationFrequency> {
    
        protected override IDictionary<string, bool> GetFields(CalculationFrequency obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Period", IsSet(obj.Period!) },
                { "MonthOfYear", IsSet(obj.MonthOfYear!) },
                { "DayOfMonth", IsSet(obj.DayOfMonth!) },
                { "DayOfWeek", IsSet(obj.DayOfWeek!) },
                { "WeekOfMonth", IsSet(obj.WeekOfMonth!) },
                { "OffsetDays", IsSet(obj.OffsetDays!) },
                { "DateLocation", IsSet(obj.DateLocation!) },
                { "BusinessCenter", IsSet(obj.BusinessCenter!) }
            };
        }
    }
    
    public class CalculationPeriodValidator : AbstractValidator<CalculationPeriod>
    {
    
        public CalculationPeriodValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CalculationPeriod obj)
        {
            yield return CheckCardinality(Name, "UnadjustedStartDate", obj.UnadjustedStartDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "UnadjustedEndDate", obj.UnadjustedEndDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationPeriodNumberOfDays", obj.CalculationPeriodNumberOfDays != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NotionalAmount", obj.NotionalAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FxLinkedNotionalAmount", obj.FxLinkedNotionalAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FloatingRateDefinition", obj.FloatingRateDefinition != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FixedRate", obj.FixedRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DayCountYearFraction", obj.DayCountYearFraction != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ForecastAmount", obj.ForecastAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ForecastRate", obj.ForecastRate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CalculationPeriodOnlyExistsValidator : AbstractOnlyExistsValidator<CalculationPeriod> {
    
        protected override IDictionary<string, bool> GetFields(CalculationPeriod obj)
        {
            return new Dictionary<string, bool>()
            {
                { "UnadjustedStartDate", IsSet(obj.UnadjustedStartDate!) },
                { "UnadjustedEndDate", IsSet(obj.UnadjustedEndDate!) },
                { "CalculationPeriodNumberOfDays", IsSet(obj.CalculationPeriodNumberOfDays!) },
                { "NotionalAmount", IsSet(obj.NotionalAmount!) },
                { "FxLinkedNotionalAmount", IsSet(obj.FxLinkedNotionalAmount!) },
                { "FloatingRateDefinition", IsSet(obj.FloatingRateDefinition!) },
                { "FixedRate", IsSet(obj.FixedRate!) },
                { "DayCountYearFraction", IsSet(obj.DayCountYearFraction!) },
                { "ForecastAmount", IsSet(obj.ForecastAmount!) },
                { "ForecastRate", IsSet(obj.ForecastRate!) }
            };
        }
    }
    
    public class CalculationPeriodBaseValidator : AbstractValidator<CalculationPeriodBase>
    {
    
        public CalculationPeriodBaseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CalculationPeriodBase obj)
        {
            yield return CheckCardinality(Name, "AdjustedStartDate", obj.AdjustedStartDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdjustedEndDate", obj.AdjustedEndDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CalculationPeriodBaseOnlyExistsValidator : AbstractOnlyExistsValidator<CalculationPeriodBase> {
    
        protected override IDictionary<string, bool> GetFields(CalculationPeriodBase obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AdjustedStartDate", IsSet(obj.AdjustedStartDate!) },
                { "AdjustedEndDate", IsSet(obj.AdjustedEndDate!) }
            };
        }
    }
    
    public class CalculationPeriodDataValidator : AbstractValidator<CalculationPeriodData>
    {
    
        public CalculationPeriodDataValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CalculationPeriodData obj)
        {
            yield break;
        }
    }
    
    public class CalculationPeriodDataOnlyExistsValidator : AbstractOnlyExistsValidator<CalculationPeriodData> {
    
        protected override IDictionary<string, bool> GetFields(CalculationPeriodData obj)
        {
            return new Dictionary<string, bool>()
            {
                { "StartDate", IsSet(obj.StartDate!) },
                { "EndDate", IsSet(obj.EndDate!) },
                { "DaysInPeriod", IsSet(obj.DaysInPeriod!) },
                { "DaysInLeapYearPeriod", IsSet(obj.DaysInLeapYearPeriod!) },
                { "IsFirstPeriod", IsSet(obj.IsFirstPeriod!) },
                { "IsLastPeriod", IsSet(obj.IsLastPeriod!) }
            };
        }
    }
    
    public class CalculationPeriodDatesValidator : AbstractValidator<CalculationPeriodDates>
    {
    
        public CalculationPeriodDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CalculationPeriodDates obj)
        {
            yield return CheckCardinality(Name, "EffectiveDate", obj.EffectiveDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "TerminationDate", obj.TerminationDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationPeriodDatesAdjustments", obj.CalculationPeriodDatesAdjustments != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FirstPeriodStartDate", obj.FirstPeriodStartDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FirstRegularPeriodStartDate", obj.FirstRegularPeriodStartDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FirstCompoundingPeriodEndDate", obj.FirstCompoundingPeriodEndDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LastRegularPeriodEndDate", obj.LastRegularPeriodEndDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "StubPeriodType", obj.StubPeriodType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationPeriodFrequency", obj.CalculationPeriodFrequency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CalculationPeriodDatesOnlyExistsValidator : AbstractOnlyExistsValidator<CalculationPeriodDates> {
    
        protected override IDictionary<string, bool> GetFields(CalculationPeriodDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "EffectiveDate", IsSet(obj.EffectiveDate!) },
                { "TerminationDate", IsSet(obj.TerminationDate!) },
                { "CalculationPeriodDatesAdjustments", IsSet(obj.CalculationPeriodDatesAdjustments!) },
                { "FirstPeriodStartDate", IsSet(obj.FirstPeriodStartDate!) },
                { "FirstRegularPeriodStartDate", IsSet(obj.FirstRegularPeriodStartDate!) },
                { "FirstCompoundingPeriodEndDate", IsSet(obj.FirstCompoundingPeriodEndDate!) },
                { "LastRegularPeriodEndDate", IsSet(obj.LastRegularPeriodEndDate!) },
                { "StubPeriodType", IsSet(obj.StubPeriodType!) },
                { "CalculationPeriodFrequency", IsSet(obj.CalculationPeriodFrequency!) }
            };
        }
    }
    
    public class CalculationPeriodFrequencyValidator : AbstractValidator<CalculationPeriodFrequency>
    {
    
        public CalculationPeriodFrequencyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CalculationPeriodFrequency obj)
        {
            yield return CheckCardinality(Name, "BalanceOfFirstPeriod", obj.BalanceOfFirstPeriod != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CalculationPeriodFrequencyOnlyExistsValidator : AbstractOnlyExistsValidator<CalculationPeriodFrequency> {
    
        protected override IDictionary<string, bool> GetFields(CalculationPeriodFrequency obj)
        {
            return new Dictionary<string, bool>()
            {
                { "RollConvention", IsSet(obj.RollConvention!) },
                { "BalanceOfFirstPeriod", IsSet(obj.BalanceOfFirstPeriod!) }
            };
        }
    }
    
    public class CalculationScheduleValidator : AbstractValidator<CalculationSchedule>
    {
    
        public CalculationScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CalculationSchedule obj)
        {
            yield return CheckCardinality(Name, "SchedulePeriod", obj.SchedulePeriod.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class CalculationScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<CalculationSchedule> {
    
        protected override IDictionary<string, bool> GetFields(CalculationSchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SchedulePeriod", IsSet(obj.SchedulePeriod!) }
            };
        }
    }
    
    public class CalculationScheduleDeliveryPeriodsValidator : AbstractValidator<CalculationScheduleDeliveryPeriods>
    {
    
        public CalculationScheduleDeliveryPeriodsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CalculationScheduleDeliveryPeriods obj)
        {
            yield return CheckCardinality(Name, "DeliveryCapacity", obj.DeliveryCapacity != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PriceTimeIntervalQuantity", obj.PriceTimeIntervalQuantity != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CalculationScheduleDeliveryPeriodsOnlyExistsValidator : AbstractOnlyExistsValidator<CalculationScheduleDeliveryPeriods> {
    
        protected override IDictionary<string, bool> GetFields(CalculationScheduleDeliveryPeriods obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DeliveryCapacity", IsSet(obj.DeliveryCapacity!) },
                { "PriceTimeIntervalQuantity", IsSet(obj.PriceTimeIntervalQuantity!) }
            };
        }
    }
    
    public class CalendarSpreadValidator : AbstractValidator<CalendarSpread>
    {
    
        public CalendarSpreadValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CalendarSpread obj)
        {
            yield break;
        }
    }
    
    public class CalendarSpreadOnlyExistsValidator : AbstractOnlyExistsValidator<CalendarSpread> {
    
        protected override IDictionary<string, bool> GetFields(CalendarSpread obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ExpirationDateTwo", IsSet(obj.ExpirationDateTwo!) }
            };
        }
    }
    
    public class CancelableProvisionValidator : AbstractValidator<CancelableProvision>
    {
    
        public CancelableProvisionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CancelableProvision obj)
        {
            yield return CheckCardinality(Name, "ExerciseNotice", obj.ExerciseNotice != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CancelableProvisionAdjustedDates", obj.CancelableProvisionAdjustedDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FinalCalculationPeriodDateAdjustment", obj.FinalCalculationPeriodDateAdjustment.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "InitialFee", obj.InitialFee != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CallingParty", obj.CallingParty != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EarliestDate", obj.EarliestDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExpirationDate", obj.ExpirationDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EffectiveDate", obj.EffectiveDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EffectivePeriod", obj.EffectivePeriod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EarliestCancellationTime", obj.EarliestCancellationTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LatestCancelationTime", obj.LatestCancelationTime != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CancelableProvisionOnlyExistsValidator : AbstractOnlyExistsValidator<CancelableProvision> {
    
        protected override IDictionary<string, bool> GetFields(CancelableProvision obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ExerciseNotice", IsSet(obj.ExerciseNotice!) },
                { "FollowUpConfirmation", IsSet(obj.FollowUpConfirmation!) },
                { "CancelableProvisionAdjustedDates", IsSet(obj.CancelableProvisionAdjustedDates!) },
                { "FinalCalculationPeriodDateAdjustment", IsSet(obj.FinalCalculationPeriodDateAdjustment!) },
                { "InitialFee", IsSet(obj.InitialFee!) },
                { "CallingParty", IsSet(obj.CallingParty!) },
                { "EarliestDate", IsSet(obj.EarliestDate!) },
                { "ExpirationDate", IsSet(obj.ExpirationDate!) },
                { "EffectiveDate", IsSet(obj.EffectiveDate!) },
                { "EffectivePeriod", IsSet(obj.EffectivePeriod!) },
                { "EarliestCancellationTime", IsSet(obj.EarliestCancellationTime!) },
                { "LatestCancelationTime", IsSet(obj.LatestCancelationTime!) },
                { "ExerciseTerms", IsSet(obj.ExerciseTerms!) }
            };
        }
    }
    
    public class CancelableProvisionAdjustedDatesValidator : AbstractValidator<CancelableProvisionAdjustedDates>
    {
    
        public CancelableProvisionAdjustedDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CancelableProvisionAdjustedDates obj)
        {
            yield return CheckCardinality(Name, "CancellationEvent", obj.CancellationEvent.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class CancelableProvisionAdjustedDatesOnlyExistsValidator : AbstractOnlyExistsValidator<CancelableProvisionAdjustedDates> {
    
        protected override IDictionary<string, bool> GetFields(CancelableProvisionAdjustedDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CancellationEvent", IsSet(obj.CancellationEvent!) }
            };
        }
    }
    
    public class CancellationEventValidator : AbstractValidator<CancellationEvent>
    {
    
        public CancellationEventValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CancellationEvent obj)
        {
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CancellationEventOnlyExistsValidator : AbstractOnlyExistsValidator<CancellationEvent> {
    
        protected override IDictionary<string, bool> GetFields(CancellationEvent obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AdjustedExerciseDate", IsSet(obj.AdjustedExerciseDate!) },
                { "AdjustedEarlyTerminationDate", IsSet(obj.AdjustedEarlyTerminationDate!) }
            };
        }
    }
    
    public class CashValidator : AbstractValidator<Cash>
    {
    
        public CashValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Cash obj)
        {
            yield break;
        }
    }
    
    public class CashOnlyExistsValidator : AbstractOnlyExistsValidator<Cash> {
    
        protected override IDictionary<string, bool> GetFields(Cash obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class CashCollateralValuationMethodValidator : AbstractValidator<CashCollateralValuationMethod>
    {
    
        public CashCollateralValuationMethodValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CashCollateralValuationMethod obj)
        {
            yield return CheckCardinality(Name, "ApplicableCsa", obj.ApplicableCsa != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CashCollateralCurrency", obj.CashCollateralCurrency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CashCollateralInterestRate", obj.CashCollateralInterestRate?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AgreedDiscountRate", obj.AgreedDiscountRate?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ProtectedParty", obj.ProtectedParty.EmptyIfNull().Count(), 0, 2);
            yield return CheckCardinality(Name, "PrescribedDocumentationAdjustment", obj.PrescribedDocumentationAdjustment != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CashCollateralValuationMethodOnlyExistsValidator : AbstractOnlyExistsValidator<CashCollateralValuationMethod> {
    
        protected override IDictionary<string, bool> GetFields(CashCollateralValuationMethod obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ApplicableCsa", IsSet(obj.ApplicableCsa!) },
                { "CashCollateralCurrency", IsSet(obj.CashCollateralCurrency!) },
                { "CashCollateralInterestRate", IsSet(obj.CashCollateralInterestRate!) },
                { "AgreedDiscountRate", IsSet(obj.AgreedDiscountRate!) },
                { "ProtectedParty", IsSet(obj.ProtectedParty!) },
                { "PrescribedDocumentationAdjustment", IsSet(obj.PrescribedDocumentationAdjustment!) }
            };
        }
    }
    
    public class CashPriceValidator : AbstractValidator<CashPrice>
    {
    
        public CashPriceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CashPrice obj)
        {
            yield return CheckCardinality(Name, "PremiumExpression", obj.PremiumExpression != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FeeType", obj.FeeType != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CashPriceOnlyExistsValidator : AbstractOnlyExistsValidator<CashPrice> {
    
        protected override IDictionary<string, bool> GetFields(CashPrice obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CashPriceType", IsSet(obj.CashPriceType!) },
                { "PremiumExpression", IsSet(obj.PremiumExpression!) },
                { "FeeType", IsSet(obj.FeeType!) }
            };
        }
    }
    
    public class CashSettlementTermsValidator : AbstractValidator<CashSettlementTerms>
    {
    
        public CashSettlementTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CashSettlementTerms obj)
        {
            yield return CheckCardinality(Name, "CashSettlementMethod", obj.CashSettlementMethod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ValuationMethod", obj.ValuationMethod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ValuationDate", obj.ValuationDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ValuationTime", obj.ValuationTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CashSettlementAmount", obj.CashSettlementAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RecoveryFactor", obj.RecoveryFactor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FixedSettlement", obj.FixedSettlement != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AccruedInterest", obj.AccruedInterest != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CashSettlementTermsOnlyExistsValidator : AbstractOnlyExistsValidator<CashSettlementTerms> {
    
        protected override IDictionary<string, bool> GetFields(CashSettlementTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CashSettlementMethod", IsSet(obj.CashSettlementMethod!) },
                { "ValuationMethod", IsSet(obj.ValuationMethod!) },
                { "ValuationDate", IsSet(obj.ValuationDate!) },
                { "ValuationTime", IsSet(obj.ValuationTime!) },
                { "CashSettlementAmount", IsSet(obj.CashSettlementAmount!) },
                { "RecoveryFactor", IsSet(obj.RecoveryFactor!) },
                { "FixedSettlement", IsSet(obj.FixedSettlement!) },
                { "AccruedInterest", IsSet(obj.AccruedInterest!) }
            };
        }
    }
    
    public class CashflowValidator : AbstractValidator<Cashflow>
    {
    
        public CashflowValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Cashflow obj)
        {
            yield return CheckCardinality(Name, "PaymentDiscounting", obj.PaymentDiscounting != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CashflowOnlyExistsValidator : AbstractOnlyExistsValidator<Cashflow> {
    
        protected override IDictionary<string, bool> GetFields(Cashflow obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PayerReceiver", IsSet(obj.PayerReceiver!) },
                { "CashflowType", IsSet(obj.CashflowType!) },
                { "PaymentDiscounting", IsSet(obj.PaymentDiscounting!) }
            };
        }
    }
    
    public class CashflowRepresentationValidator : AbstractValidator<CashflowRepresentation>
    {
    
        public CashflowRepresentationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CashflowRepresentation obj)
        {
            yield return CheckCardinality(Name, "PaymentCalculationPeriod", obj.PaymentCalculationPeriod.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class CashflowRepresentationOnlyExistsValidator : AbstractOnlyExistsValidator<CashflowRepresentation> {
    
        protected override IDictionary<string, bool> GetFields(CashflowRepresentation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CashflowsMatchParameters", IsSet(obj.CashflowsMatchParameters!) },
                { "PaymentCalculationPeriod", IsSet(obj.PaymentCalculationPeriod!) }
            };
        }
    }
    
    public class CashflowTypeValidator : AbstractValidator<CashflowType>
    {
    
        public CashflowTypeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CashflowType obj)
        {
            yield return CheckCardinality(Name, "CashflowTypeValue", obj.CashflowTypeValue != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CashPrice", obj.CashPrice != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PriceExpression", obj.PriceExpression != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CashflowTypeOnlyExistsValidator : AbstractOnlyExistsValidator<CashflowType> {
    
        protected override IDictionary<string, bool> GetFields(CashflowType obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CashflowTypeValue", IsSet(obj.CashflowTypeValue!) },
                { "CashPrice", IsSet(obj.CashPrice!) },
                { "PriceExpression", IsSet(obj.PriceExpression!) }
            };
        }
    }
    
    public class CheckEligibilityResultValidator : AbstractValidator<CheckEligibilityResult>
    {
    
        public CheckEligibilityResultValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CheckEligibilityResult obj)
        {
            yield return CheckCardinality(Name, "MatchingEligibleCriteria", obj.MatchingEligibleCriteria.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class CheckEligibilityResultOnlyExistsValidator : AbstractOnlyExistsValidator<CheckEligibilityResult> {
    
        protected override IDictionary<string, bool> GetFields(CheckEligibilityResult obj)
        {
            return new Dictionary<string, bool>()
            {
                { "IsEligible", IsSet(obj.IsEligible!) },
                { "MatchingEligibleCriteria", IsSet(obj.MatchingEligibleCriteria!) },
                { "EligibilityQuery", IsSet(obj.EligibilityQuery!) },
                { "Specification", IsSet(obj.Specification!) }
            };
        }
    }
    
    public class ClauseValidator : AbstractValidator<Clause>
    {
    
        public ClauseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Clause obj)
        {
            yield return CheckCardinality(Name, "Identifier", obj.Identifier != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Terms", obj.Terms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Subcomponents", obj.Subcomponents.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class ClauseOnlyExistsValidator : AbstractOnlyExistsValidator<Clause> {
    
        protected override IDictionary<string, bool> GetFields(Clause obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Identifier", IsSet(obj.Identifier!) },
                { "Terms", IsSet(obj.Terms!) },
                { "Subcomponents", IsSet(obj.Subcomponents!) }
            };
        }
    }
    
    public class ClearingInstructionValidator : AbstractValidator<ClearingInstruction>
    {
    
        public ClearingInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ClearingInstruction obj)
        {
            yield return CheckCardinality(Name, "ClearerParty1", obj.ClearerParty1 != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ClearerParty2", obj.ClearerParty2 != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IsOpenOffer", obj.IsOpenOffer != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ClearingInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<ClearingInstruction> {
    
        protected override IDictionary<string, bool> GetFields(ClearingInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AlphaContract", IsSet(obj.AlphaContract!) },
                { "ClearingParty", IsSet(obj.ClearingParty!) },
                { "Party1", IsSet(obj.Party1!) },
                { "Party2", IsSet(obj.Party2!) },
                { "ClearerParty1", IsSet(obj.ClearerParty1!) },
                { "ClearerParty2", IsSet(obj.ClearerParty2!) },
                { "IsOpenOffer", IsSet(obj.IsOpenOffer!) }
            };
        }
    }
    
    public class ClosedStateValidator : AbstractValidator<ClosedState>
    {
    
        public ClosedStateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ClosedState obj)
        {
            yield return CheckCardinality(Name, "EffectiveDate", obj.EffectiveDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LastPaymentDate", obj.LastPaymentDate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ClosedStateOnlyExistsValidator : AbstractOnlyExistsValidator<ClosedState> {
    
        protected override IDictionary<string, bool> GetFields(ClosedState obj)
        {
            return new Dictionary<string, bool>()
            {
                { "State", IsSet(obj.State!) },
                { "ActivityDate", IsSet(obj.ActivityDate!) },
                { "EffectiveDate", IsSet(obj.EffectiveDate!) },
                { "LastPaymentDate", IsSet(obj.LastPaymentDate!) }
            };
        }
    }
    
    public class CollateralValidator : AbstractValidator<Collateral>
    {
    
        public CollateralValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Collateral obj)
        {
            yield return CheckCardinality(Name, "IndependentAmount", obj.IndependentAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PortfolioIdentifier", obj.PortfolioIdentifier.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "CollateralPortfolio", obj.CollateralPortfolio.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "CollateralProvisions", obj.CollateralProvisions != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CollateralOnlyExistsValidator : AbstractOnlyExistsValidator<Collateral> {
    
        protected override IDictionary<string, bool> GetFields(Collateral obj)
        {
            return new Dictionary<string, bool>()
            {
                { "IndependentAmount", IsSet(obj.IndependentAmount!) },
                { "PortfolioIdentifier", IsSet(obj.PortfolioIdentifier!) },
                { "CollateralPortfolio", IsSet(obj.CollateralPortfolio!) },
                { "CollateralProvisions", IsSet(obj.CollateralProvisions!) }
            };
        }
    }
    
    public class CollateralAgreementFloatingRateValidator : AbstractValidator<CollateralAgreementFloatingRate>
    {
    
        public CollateralAgreementFloatingRateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralAgreementFloatingRate obj)
        {
            yield break;
        }
    }
    
    public class CollateralAgreementFloatingRateOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralAgreementFloatingRate> {
    
        protected override IDictionary<string, bool> GetFields(CollateralAgreementFloatingRate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "NegativeInterest", IsSet(obj.NegativeInterest!) },
                { "CompressibleSpread", IsSet(obj.CompressibleSpread!) }
            };
        }
    }
    
    public class CollateralBalanceValidator : AbstractValidator<CollateralBalance>
    {
    
        public CollateralBalanceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralBalance obj)
        {
            yield return CheckCardinality(Name, "CollateralBalanceStatus", obj.CollateralBalanceStatus != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "HaircutIndicator", obj.HaircutIndicator != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CollateralBalanceOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralBalance> {
    
        protected override IDictionary<string, bool> GetFields(CollateralBalance obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CollateralBalanceStatus", IsSet(obj.CollateralBalanceStatus!) },
                { "HaircutIndicator", IsSet(obj.HaircutIndicator!) },
                { "AmountBaseCurrency", IsSet(obj.AmountBaseCurrency!) },
                { "PayerReceiver", IsSet(obj.PayerReceiver!) }
            };
        }
    }
    
    public class CollateralCriteriaValidator : AbstractValidator<CollateralCriteria>
    {
    
        public CollateralCriteriaValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralCriteria obj)
        {
            yield return CheckCardinality(Name, "AllCriteria", obj.AllCriteria != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AnyCriteria", obj.AnyCriteria != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NegativeCriteria", obj.NegativeCriteria != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CollateralIssuerType", obj.CollateralIssuerType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AssetType", obj.AssetType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IssuerCountryOfOrigin", obj.IssuerCountryOfOrigin != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AssetCountryOfOrigin", obj.AssetCountryOfOrigin != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CurrencyCodeEnum", obj.CurrencyCodeEnum != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IssuerName", obj.IssuerName != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IssuerAgencyRating", obj.IssuerAgencyRating != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SovereignAgencyRating", obj.SovereignAgencyRating != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AssetAgencyRating", obj.AssetAgencyRating != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AssetMaturity", obj.AssetMaturity != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SpecificAsset", obj.SpecificAsset != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CollateralTaxonomy", obj.CollateralTaxonomy != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ListingExchange", obj.ListingExchange != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ListingSector", obj.ListingSector != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Index", obj.Index != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CounterpartyOwnIssuePermitted", obj.CounterpartyOwnIssuePermitted != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DomesticCurrencyIssued", obj.DomesticCurrencyIssued != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CollateralCriteriaOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralCriteria> {
    
        protected override IDictionary<string, bool> GetFields(CollateralCriteria obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AllCriteria", IsSet(obj.AllCriteria!) },
                { "AnyCriteria", IsSet(obj.AnyCriteria!) },
                { "NegativeCriteria", IsSet(obj.NegativeCriteria!) },
                { "CollateralIssuerType", IsSet(obj.CollateralIssuerType!) },
                { "AssetType", IsSet(obj.AssetType!) },
                { "IssuerCountryOfOrigin", IsSet(obj.IssuerCountryOfOrigin!) },
                { "AssetCountryOfOrigin", IsSet(obj.AssetCountryOfOrigin!) },
                { "CurrencyCodeEnum", IsSet(obj.CurrencyCodeEnum!) },
                { "IssuerName", IsSet(obj.IssuerName!) },
                { "IssuerAgencyRating", IsSet(obj.IssuerAgencyRating!) },
                { "SovereignAgencyRating", IsSet(obj.SovereignAgencyRating!) },
                { "AssetAgencyRating", IsSet(obj.AssetAgencyRating!) },
                { "AssetMaturity", IsSet(obj.AssetMaturity!) },
                { "SpecificAsset", IsSet(obj.SpecificAsset!) },
                { "CollateralTaxonomy", IsSet(obj.CollateralTaxonomy!) },
                { "ListingExchange", IsSet(obj.ListingExchange!) },
                { "ListingSector", IsSet(obj.ListingSector!) },
                { "Index", IsSet(obj.Index!) },
                { "CounterpartyOwnIssuePermitted", IsSet(obj.CounterpartyOwnIssuePermitted!) },
                { "DomesticCurrencyIssued", IsSet(obj.DomesticCurrencyIssued!) }
            };
        }
    }
    
    public class CollateralCriteriaBaseValidator : AbstractValidator<CollateralCriteriaBase>
    {
    
        public CollateralCriteriaBaseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralCriteriaBase obj)
        {
            yield return CheckCardinality(Name, "AppliesTo", obj.AppliesTo.EmptyIfNull().Count(), 0, 2);
            yield return CheckCardinality(Name, "RestrictTo", obj.RestrictTo != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RatingPriorityResolution", obj.RatingPriorityResolution != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CollateralCriteriaBaseOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralCriteriaBase> {
    
        protected override IDictionary<string, bool> GetFields(CollateralCriteriaBase obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CollateralCriteria", IsSet(obj.CollateralCriteria!) },
                { "AppliesTo", IsSet(obj.AppliesTo!) },
                { "RestrictTo", IsSet(obj.RestrictTo!) },
                { "RatingPriorityResolution", IsSet(obj.RatingPriorityResolution!) }
            };
        }
    }
    
    public class CollateralInterestCalculationParametersValidator : AbstractValidator<CollateralInterestCalculationParameters>
    {
    
        public CollateralInterestCalculationParametersValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralInterestCalculationParameters obj)
        {
            yield return CheckCardinality(Name, "FixedRate", obj.FixedRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FloatingRate", obj.FloatingRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CompoundingType", obj.CompoundingType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CompoundingBusinessCenter", obj.CompoundingBusinessCenter.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Rounding", obj.Rounding != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RoundingFrequency", obj.RoundingFrequency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "WithholdingTaxRate", obj.WithholdingTaxRate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CollateralInterestCalculationParametersOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralInterestCalculationParameters> {
    
        protected override IDictionary<string, bool> GetFields(CollateralInterestCalculationParameters obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FixedRate", IsSet(obj.FixedRate!) },
                { "FloatingRate", IsSet(obj.FloatingRate!) },
                { "InBaseCurrency", IsSet(obj.InBaseCurrency!) },
                { "CompoundingType", IsSet(obj.CompoundingType!) },
                { "CompoundingBusinessCenter", IsSet(obj.CompoundingBusinessCenter!) },
                { "DayCountFraction", IsSet(obj.DayCountFraction!) },
                { "Rounding", IsSet(obj.Rounding!) },
                { "RoundingFrequency", IsSet(obj.RoundingFrequency!) },
                { "WithholdingTaxRate", IsSet(obj.WithholdingTaxRate!) }
            };
        }
    }
    
    public class CollateralInterestHandlingParametersValidator : AbstractValidator<CollateralInterestHandlingParameters>
    {
    
        public CollateralInterestHandlingParametersValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralInterestHandlingParameters obj)
        {
            yield return CheckCardinality(Name, "PaymentBusinessCenter", obj.PaymentBusinessCenter.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "AccrueInterestOnUnsettledInterest", obj.AccrueInterestOnUnsettledInterest != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InterestAmountApplication", obj.InterestAmountApplication != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InterestRolloverLimit", obj.InterestRolloverLimit != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "WriteoffLimit", obj.WriteoffLimit != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AlternativeToInterestAmount", obj.AlternativeToInterestAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AlternativeProvision", obj.AlternativeProvision != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CutoffTime", obj.CutoffTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Notification", obj.Notification != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CollateralInterestHandlingParametersOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralInterestHandlingParameters> {
    
        protected override IDictionary<string, bool> GetFields(CollateralInterestHandlingParameters obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InterestPaymentHandling", IsSet(obj.InterestPaymentHandling!) },
                { "PaymentBusinessCenter", IsSet(obj.PaymentBusinessCenter!) },
                { "NetPostedAndHeldInterest", IsSet(obj.NetPostedAndHeldInterest!) },
                { "NetInterestWithMarginCalls", IsSet(obj.NetInterestWithMarginCalls!) },
                { "IncludeAccrualInMarginCalc", IsSet(obj.IncludeAccrualInMarginCalc!) },
                { "AccrueInterestOnUnsettledInterest", IsSet(obj.AccrueInterestOnUnsettledInterest!) },
                { "OnFullReturn", IsSet(obj.OnFullReturn!) },
                { "OnPartialReturn", IsSet(obj.OnPartialReturn!) },
                { "InterestAmountApplication", IsSet(obj.InterestAmountApplication!) },
                { "InterestRolloverLimit", IsSet(obj.InterestRolloverLimit!) },
                { "WriteoffLimit", IsSet(obj.WriteoffLimit!) },
                { "AlternativeToInterestAmount", IsSet(obj.AlternativeToInterestAmount!) },
                { "AlternativeProvision", IsSet(obj.AlternativeProvision!) },
                { "CutoffTime", IsSet(obj.CutoffTime!) },
                { "Notification", IsSet(obj.Notification!) }
            };
        }
    }
    
    public class CollateralInterestNotificationValidator : AbstractValidator<CollateralInterestNotification>
    {
    
        public CollateralInterestNotificationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralInterestNotification obj)
        {
            yield break;
        }
    }
    
    public class CollateralInterestNotificationOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralInterestNotification> {
    
        protected override IDictionary<string, bool> GetFields(CollateralInterestNotification obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Trigger", IsSet(obj.Trigger!) },
                { "Offset", IsSet(obj.Offset!) },
                { "NotificationTime", IsSet(obj.NotificationTime!) },
                { "NotificationDayType", IsSet(obj.NotificationDayType!) }
            };
        }
    }
    
    public class CollateralInterestParametersValidator : AbstractValidator<CollateralInterestParameters>
    {
    
        public CollateralInterestParametersValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralInterestParameters obj)
        {
            yield return CheckCardinality(Name, "PostingParty", obj.PostingParty != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MarginType", obj.MarginType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Currency", obj.Currency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InterestCalculationParameters", obj.InterestCalculationParameters != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InterestCalculationFrequency", obj.InterestCalculationFrequency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InterestHandlingParameters", obj.InterestHandlingParameters != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CollateralInterestParametersOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralInterestParameters> {
    
        protected override IDictionary<string, bool> GetFields(CollateralInterestParameters obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PostingParty", IsSet(obj.PostingParty!) },
                { "MarginType", IsSet(obj.MarginType!) },
                { "Currency", IsSet(obj.Currency!) },
                { "InterestCalculationParameters", IsSet(obj.InterestCalculationParameters!) },
                { "InterestCalculationFrequency", IsSet(obj.InterestCalculationFrequency!) },
                { "InterestHandlingParameters", IsSet(obj.InterestHandlingParameters!) }
            };
        }
    }
    
    public class CollateralIssuerTypeValidator : AbstractValidator<CollateralIssuerType>
    {
    
        public CollateralIssuerTypeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralIssuerType obj)
        {
            yield return CheckCardinality(Name, "SupraNationalType", obj.SupraNationalType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "QuasiGovernmentType", obj.QuasiGovernmentType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RegionalGovernmentType", obj.RegionalGovernmentType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SpecialPurposeVehicleType", obj.SpecialPurposeVehicleType != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CollateralIssuerTypeOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralIssuerType> {
    
        protected override IDictionary<string, bool> GetFields(CollateralIssuerType obj)
        {
            return new Dictionary<string, bool>()
            {
                { "IssuerType", IsSet(obj.IssuerType!) },
                { "SupraNationalType", IsSet(obj.SupraNationalType!) },
                { "QuasiGovernmentType", IsSet(obj.QuasiGovernmentType!) },
                { "RegionalGovernmentType", IsSet(obj.RegionalGovernmentType!) },
                { "SpecialPurposeVehicleType", IsSet(obj.SpecialPurposeVehicleType!) }
            };
        }
    }
    
    public class CollateralPortfolioValidator : AbstractValidator<CollateralPortfolio>
    {
    
        public CollateralPortfolioValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralPortfolio obj)
        {
            yield return CheckCardinality(Name, "PortfolioIdentifier", obj.PortfolioIdentifier != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CollateralPosition", obj.CollateralPosition.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "CollateralBalance", obj.CollateralBalance.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "LegalAgreement", obj.LegalAgreement?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CollateralPortfolioOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralPortfolio> {
    
        protected override IDictionary<string, bool> GetFields(CollateralPortfolio obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PortfolioIdentifier", IsSet(obj.PortfolioIdentifier!) },
                { "CollateralPosition", IsSet(obj.CollateralPosition!) },
                { "CollateralBalance", IsSet(obj.CollateralBalance!) },
                { "LegalAgreement", IsSet(obj.LegalAgreement!) }
            };
        }
    }
    
    public class CollateralPositionValidator : AbstractValidator<CollateralPosition>
    {
    
        public CollateralPositionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralPosition obj)
        {
            yield return CheckCardinality(Name, "Treatment", obj.Treatment != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CollateralPositionStatus", obj.CollateralPositionStatus != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CollateralPositionOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralPosition> {
    
        protected override IDictionary<string, bool> GetFields(CollateralPosition obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Treatment", IsSet(obj.Treatment!) },
                { "CollateralPositionStatus", IsSet(obj.CollateralPositionStatus!) }
            };
        }
    }
    
    public class CollateralProvisionsValidator : AbstractValidator<CollateralProvisions>
    {
    
        public CollateralProvisionsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralProvisions obj)
        {
            yield return CheckCardinality(Name, "EligibleCollateral", obj.EligibleCollateral.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "SubstitutionProvisions", obj.SubstitutionProvisions != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CollateralProvisionsOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralProvisions> {
    
        protected override IDictionary<string, bool> GetFields(CollateralProvisions obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CollateralType", IsSet(obj.CollateralType!) },
                { "EligibleCollateral", IsSet(obj.EligibleCollateral!) },
                { "SubstitutionProvisions", IsSet(obj.SubstitutionProvisions!) }
            };
        }
    }
    
    public class CollateralTaxonomyValidator : AbstractValidator<CollateralTaxonomy>
    {
    
        public CollateralTaxonomyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralTaxonomy obj)
        {
            yield break;
        }
    }
    
    public class CollateralTaxonomyOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralTaxonomy> {
    
        protected override IDictionary<string, bool> GetFields(CollateralTaxonomy obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TaxonomyValue", IsSet(obj.TaxonomyValue!) },
                { "TaxonomySource", IsSet(obj.TaxonomySource!) }
            };
        }
    }
    
    public class CollateralTaxonomyValueValidator : AbstractValidator<CollateralTaxonomyValue>
    {
    
        public CollateralTaxonomyValueValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralTaxonomyValue obj)
        {
            yield return CheckCardinality(Name, "Eu_EMIR_EligibleCollateral", obj.Eu_EMIR_EligibleCollateral.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Uk_EMIR_EligibleCollateral", obj.Uk_EMIR_EligibleCollateral.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Us_CFTC_PR_EligibleCollateral", obj.Us_CFTC_PR_EligibleCollateral.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "NonEnumeratedTaxonomyValue", obj.NonEnumeratedTaxonomyValue.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class CollateralTaxonomyValueOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralTaxonomyValue> {
    
        protected override IDictionary<string, bool> GetFields(CollateralTaxonomyValue obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Eu_EMIR_EligibleCollateral", IsSet(obj.Eu_EMIR_EligibleCollateral!) },
                { "Uk_EMIR_EligibleCollateral", IsSet(obj.Uk_EMIR_EligibleCollateral!) },
                { "Us_CFTC_PR_EligibleCollateral", IsSet(obj.Us_CFTC_PR_EligibleCollateral!) },
                { "NonEnumeratedTaxonomyValue", IsSet(obj.NonEnumeratedTaxonomyValue!) }
            };
        }
    }
    
    public class CollateralTransferAgreementElectionsValidator : AbstractValidator<CollateralTransferAgreementElections>
    {
    
        public CollateralTransferAgreementElectionsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralTransferAgreementElections obj)
        {
            yield break;
        }
    }
    
    public class CollateralTransferAgreementElectionsOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralTransferAgreementElections> {
    
        protected override IDictionary<string, bool> GetFields(CollateralTransferAgreementElections obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class CollateralTreatmentValidator : AbstractValidator<CollateralTreatment>
    {
    
        public CollateralTreatmentValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralTreatment obj)
        {
            yield return CheckCardinality(Name, "ValuationTreatment", obj.ValuationTreatment != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ConcentrationLimit", obj.ConcentrationLimit.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class CollateralTreatmentOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralTreatment> {
    
        protected override IDictionary<string, bool> GetFields(CollateralTreatment obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ValuationTreatment", IsSet(obj.ValuationTreatment!) },
                { "ConcentrationLimit", IsSet(obj.ConcentrationLimit!) },
                { "IsIncluded", IsSet(obj.IsIncluded!) }
            };
        }
    }
    
    public class CollateralValuationTreatmentValidator : AbstractValidator<CollateralValuationTreatment>
    {
    
        public CollateralValuationTreatmentValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CollateralValuationTreatment obj)
        {
            yield return CheckCardinality(Name, "HaircutPercentage", obj.HaircutPercentage != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MarginPercentage", obj.MarginPercentage != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FxHaircutPercentage", obj.FxHaircutPercentage != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdditionalHaircutPercentage", obj.AdditionalHaircutPercentage != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CollateralValuationTreatmentOnlyExistsValidator : AbstractOnlyExistsValidator<CollateralValuationTreatment> {
    
        protected override IDictionary<string, bool> GetFields(CollateralValuationTreatment obj)
        {
            return new Dictionary<string, bool>()
            {
                { "HaircutPercentage", IsSet(obj.HaircutPercentage!) },
                { "MarginPercentage", IsSet(obj.MarginPercentage!) },
                { "FxHaircutPercentage", IsSet(obj.FxHaircutPercentage!) },
                { "AdditionalHaircutPercentage", IsSet(obj.AdditionalHaircutPercentage!) }
            };
        }
    }
    
    public class CommodityValidator : AbstractValidator<Commodity>
    {
    
        public CommodityValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Commodity obj)
        {
            yield return CheckCardinality(Name, "CommodityProductDefinition", obj.CommodityProductDefinition != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DeliveryDateReference", obj.DeliveryDateReference != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Description", obj.Description != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CommodityOnlyExistsValidator : AbstractOnlyExistsValidator<Commodity> {
    
        protected override IDictionary<string, bool> GetFields(Commodity obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CommodityProductDefinition", IsSet(obj.CommodityProductDefinition!) },
                { "PriceQuoteType", IsSet(obj.PriceQuoteType!) },
                { "DeliveryDateReference", IsSet(obj.DeliveryDateReference!) },
                { "Description", IsSet(obj.Description!) }
            };
        }
    }
    
    public class CommodityPayoutValidator : AbstractValidator<CommodityPayout>
    {
    
        public CommodityPayoutValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CommodityPayout obj)
        {
            yield return CheckCardinality(Name, "AveragingFeature", obj.AveragingFeature != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CommodityPriceReturnTerms", obj.CommodityPriceReturnTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Schedule", obj.Schedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationPeriodDates", obj.CalculationPeriodDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FxFeature", obj.FxFeature != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Delivery", obj.Delivery != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CommodityPayoutOnlyExistsValidator : AbstractOnlyExistsValidator<CommodityPayout> {
    
        protected override IDictionary<string, bool> GetFields(CommodityPayout obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AveragingFeature", IsSet(obj.AveragingFeature!) },
                { "CommodityPriceReturnTerms", IsSet(obj.CommodityPriceReturnTerms!) },
                { "PricingDates", IsSet(obj.PricingDates!) },
                { "Schedule", IsSet(obj.Schedule!) },
                { "CalculationPeriodDates", IsSet(obj.CalculationPeriodDates!) },
                { "PaymentDates", IsSet(obj.PaymentDates!) },
                { "Underlier", IsSet(obj.Underlier!) },
                { "FxFeature", IsSet(obj.FxFeature!) },
                { "Delivery", IsSet(obj.Delivery!) }
            };
        }
    }
    
    public class CommodityPriceReturnTermsValidator : AbstractValidator<CommodityPriceReturnTerms>
    {
    
        public CommodityPriceReturnTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CommodityPriceReturnTerms obj)
        {
            yield return CheckCardinality(Name, "Rounding", obj.Rounding != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Spread", obj.Spread != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RollFeature", obj.RollFeature != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ConversionFactor", obj.ConversionFactor != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CommodityPriceReturnTermsOnlyExistsValidator : AbstractOnlyExistsValidator<CommodityPriceReturnTerms> {
    
        protected override IDictionary<string, bool> GetFields(CommodityPriceReturnTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Rounding", IsSet(obj.Rounding!) },
                { "Spread", IsSet(obj.Spread!) },
                { "RollFeature", IsSet(obj.RollFeature!) },
                { "ConversionFactor", IsSet(obj.ConversionFactor!) }
            };
        }
    }
    
    public class CommodityProductDefinitionValidator : AbstractValidator<CommodityProductDefinition>
    {
    
        public CommodityProductDefinitionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CommodityProductDefinition obj)
        {
            yield return CheckCardinality(Name, "PriceSource", obj.PriceSource != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CommodityInfoPublisher", obj.CommodityInfoPublisher != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CommodityProductDefinitionOnlyExistsValidator : AbstractOnlyExistsValidator<CommodityProductDefinition> {
    
        protected override IDictionary<string, bool> GetFields(CommodityProductDefinition obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ReferenceFramework", IsSet(obj.ReferenceFramework!) },
                { "PriceSource", IsSet(obj.PriceSource!) },
                { "CommodityInfoPublisher", IsSet(obj.CommodityInfoPublisher!) },
                { "ExchangeId", IsSet(obj.ExchangeId!) }
            };
        }
    }
    
    public class CommodityReferenceFrameworkValidator : AbstractValidator<CommodityReferenceFramework>
    {
    
        public CommodityReferenceFrameworkValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CommodityReferenceFramework obj)
        {
            yield return CheckCardinality(Name, "CapacityUnit", obj.CapacityUnit != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "WeatherUnit", obj.WeatherUnit != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CommodityReferenceFrameworkOnlyExistsValidator : AbstractOnlyExistsValidator<CommodityReferenceFramework> {
    
        protected override IDictionary<string, bool> GetFields(CommodityReferenceFramework obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CommodityName", IsSet(obj.CommodityName!) },
                { "CapacityUnit", IsSet(obj.CapacityUnit!) },
                { "WeatherUnit", IsSet(obj.WeatherUnit!) },
                { "Currency", IsSet(obj.Currency!) }
            };
        }
    }
    
    public class CompositeValidator : AbstractValidator<Composite>
    {
    
        public CompositeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Composite obj)
        {
            yield return CheckCardinality(Name, "DeterminationMethod", obj.DeterminationMethod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RelativeDate", obj.RelativeDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FxSpotRateSource", obj.FxSpotRateSource != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FixingTime", obj.FixingTime != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CompositeOnlyExistsValidator : AbstractOnlyExistsValidator<Composite> {
    
        protected override IDictionary<string, bool> GetFields(Composite obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DeterminationMethod", IsSet(obj.DeterminationMethod!) },
                { "RelativeDate", IsSet(obj.RelativeDate!) },
                { "FxSpotRateSource", IsSet(obj.FxSpotRateSource!) },
                { "FixingTime", IsSet(obj.FixingTime!) }
            };
        }
    }
    
    public class ComputedAmountValidator : AbstractValidator<ComputedAmount>
    {
    
        public ComputedAmountValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ComputedAmount obj)
        {
            yield return CheckCardinality(Name, "Currency", obj.Currency?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ComputedAmountOnlyExistsValidator : AbstractOnlyExistsValidator<ComputedAmount> {
    
        protected override IDictionary<string, bool> GetFields(ComputedAmount obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CallFunction", IsSet(obj.CallFunction!) },
                { "Amount", IsSet(obj.Amount!) },
                { "Currency", IsSet(obj.Currency!) }
            };
        }
    }
    
    public class ConcentrationLimitValidator : AbstractValidator<ConcentrationLimit>
    {
    
        public ConcentrationLimitValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ConcentrationLimit obj)
        {
            yield return CheckCardinality(Name, "ConcentrationLimitCriteria", obj.ConcentrationLimitCriteria != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ValueLimit", obj.ValueLimit != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PercentageLimit", obj.PercentageLimit != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ConcentrationLimitOnlyExistsValidator : AbstractOnlyExistsValidator<ConcentrationLimit> {
    
        protected override IDictionary<string, bool> GetFields(ConcentrationLimit obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ConcentrationLimitCriteria", IsSet(obj.ConcentrationLimitCriteria!) },
                { "ValueLimit", IsSet(obj.ValueLimit!) },
                { "PercentageLimit", IsSet(obj.PercentageLimit!) }
            };
        }
    }
    
    public class ConcentrationLimitCriteriaValidator : AbstractValidator<ConcentrationLimitCriteria>
    {
    
        public ConcentrationLimitCriteriaValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ConcentrationLimitCriteria obj)
        {
            yield return CheckCardinality(Name, "ConcentrationLimitType", obj.ConcentrationLimitType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AverageTradingVolume", obj.AverageTradingVolume != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ConcentrationLimitCriteriaOnlyExistsValidator : AbstractOnlyExistsValidator<ConcentrationLimitCriteria> {
    
        protected override IDictionary<string, bool> GetFields(ConcentrationLimitCriteria obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ConcentrationLimitType", IsSet(obj.ConcentrationLimitType!) },
                { "AverageTradingVolume", IsSet(obj.AverageTradingVolume!) }
            };
        }
    }
    
    public class ConstituentWeightValidator : AbstractValidator<ConstituentWeight>
    {
    
        public ConstituentWeightValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ConstituentWeight obj)
        {
            yield return CheckCardinality(Name, "OpenUnits", obj.OpenUnits != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BasketPercentage", obj.BasketPercentage != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ConstituentWeightOnlyExistsValidator : AbstractOnlyExistsValidator<ConstituentWeight> {
    
        protected override IDictionary<string, bool> GetFields(ConstituentWeight obj)
        {
            return new Dictionary<string, bool>()
            {
                { "OpenUnits", IsSet(obj.OpenUnits!) },
                { "BasketPercentage", IsSet(obj.BasketPercentage!) }
            };
        }
    }
    
    public class ContactElectionValidator : AbstractValidator<ContactElection>
    {
    
        public ContactElectionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ContactElection obj)
        {
            yield return CheckCardinality(Name, "PartyElection", obj.PartyElection.EmptyIfNull().Count(), 2, 2);
            yield break;
        }
    }
    
    public class ContactElectionOnlyExistsValidator : AbstractOnlyExistsValidator<ContactElection> {
    
        protected override IDictionary<string, bool> GetFields(ContactElection obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PartyElection", IsSet(obj.PartyElection!) }
            };
        }
    }
    
    public class ContactInformationValidator : AbstractValidator<ContactInformation>
    {
    
        public ContactInformationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ContactInformation obj)
        {
            yield return CheckCardinality(Name, "Telephone", obj.Telephone.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Address", obj.Address.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Email", obj.Email.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "WebPage", obj.WebPage.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class ContactInformationOnlyExistsValidator : AbstractOnlyExistsValidator<ContactInformation> {
    
        protected override IDictionary<string, bool> GetFields(ContactInformation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Telephone", IsSet(obj.Telephone!) },
                { "Address", IsSet(obj.Address!) },
                { "Email", IsSet(obj.Email!) },
                { "WebPage", IsSet(obj.WebPage!) }
            };
        }
    }
    
    public class ContractBaseValidator : AbstractValidator<ContractBase>
    {
    
        public ContractBaseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ContractBase obj)
        {
            yield return CheckCardinality(Name, "ContractDetails", obj.ContractDetails?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExecutionDetails", obj.ExecutionDetails?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Collateral", obj.Collateral?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ContractBaseOnlyExistsValidator : AbstractOnlyExistsValidator<ContractBase> {
    
        protected override IDictionary<string, bool> GetFields(ContractBase obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ContractDetails", IsSet(obj.ContractDetails!) },
                { "ExecutionDetails", IsSet(obj.ExecutionDetails!) },
                { "Collateral", IsSet(obj.Collateral!) }
            };
        }
    }
    
    public class ContractDetailsValidator : AbstractValidator<ContractDetails>
    {
    
        public ContractDetailsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ContractDetails obj)
        {
            yield return CheckCardinality(Name, "Documentation", obj.Documentation.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "GoverningLaw", obj.GoverningLaw?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ContractDetailsOnlyExistsValidator : AbstractOnlyExistsValidator<ContractDetails> {
    
        protected override IDictionary<string, bool> GetFields(ContractDetails obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Documentation", IsSet(obj.Documentation!) },
                { "GoverningLaw", IsSet(obj.GoverningLaw!) }
            };
        }
    }
    
    public class ContractFormationInstructionValidator : AbstractValidator<ContractFormationInstruction>
    {
    
        public ContractFormationInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ContractFormationInstruction obj)
        {
            yield return CheckCardinality(Name, "LegalAgreement", obj.LegalAgreement.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class ContractFormationInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<ContractFormationInstruction> {
    
        protected override IDictionary<string, bool> GetFields(ContractFormationInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "LegalAgreement", IsSet(obj.LegalAgreement!) }
            };
        }
    }
    
    public class ContractualMatrixValidator : AbstractValidator<ContractualMatrix>
    {
    
        public ContractualMatrixValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ContractualMatrix obj)
        {
            yield return CheckCardinality(Name, "MatrixTerm", obj.MatrixTerm?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ContractualMatrixOnlyExistsValidator : AbstractOnlyExistsValidator<ContractualMatrix> {
    
        protected override IDictionary<string, bool> GetFields(ContractualMatrix obj)
        {
            return new Dictionary<string, bool>()
            {
                { "MatrixType", IsSet(obj.MatrixType!) },
                { "MatrixTerm", IsSet(obj.MatrixTerm!) }
            };
        }
    }
    
    public class ContractualTermsSupplementValidator : AbstractValidator<ContractualTermsSupplement>
    {
    
        public ContractualTermsSupplementValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ContractualTermsSupplement obj)
        {
            yield return CheckCardinality(Name, "PublicationDate", obj.PublicationDate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ContractualTermsSupplementOnlyExistsValidator : AbstractOnlyExistsValidator<ContractualTermsSupplement> {
    
        protected override IDictionary<string, bool> GetFields(ContractualTermsSupplement obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ContractualTermsSupplementType", IsSet(obj.ContractualTermsSupplementType!) },
                { "PublicationDate", IsSet(obj.PublicationDate!) }
            };
        }
    }
    
    public class CorporateActionValidator : AbstractValidator<CorporateAction>
    {
    
        public CorporateActionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CorporateAction obj)
        {
            yield break;
        }
    }
    
    public class CorporateActionOnlyExistsValidator : AbstractOnlyExistsValidator<CorporateAction> {
    
        protected override IDictionary<string, bool> GetFields(CorporateAction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CorporateActionType", IsSet(obj.CorporateActionType!) },
                { "ExDate", IsSet(obj.ExDate!) },
                { "PayDate", IsSet(obj.PayDate!) },
                { "Underlier", IsSet(obj.Underlier!) }
            };
        }
    }
    
    public class CorrelationReturnTermsValidator : AbstractValidator<CorrelationReturnTerms>
    {
    
        public CorrelationReturnTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CorrelationReturnTerms obj)
        {
            yield return CheckCardinality(Name, "BoundedCorrelation", obj.BoundedCorrelation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NumberOfDataSeries", obj.NumberOfDataSeries != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CorrelationReturnTermsOnlyExistsValidator : AbstractOnlyExistsValidator<CorrelationReturnTerms> {
    
        protected override IDictionary<string, bool> GetFields(CorrelationReturnTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CorrelationStrikePrice", IsSet(obj.CorrelationStrikePrice!) },
                { "BoundedCorrelation", IsSet(obj.BoundedCorrelation!) },
                { "NumberOfDataSeries", IsSet(obj.NumberOfDataSeries!) }
            };
        }
    }
    
    public class CounterpartyValidator : AbstractValidator<Counterparty>
    {
    
        public CounterpartyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Counterparty obj)
        {
            yield return CheckCardinality(Name, "PartyReference", obj.PartyReference.Value != null ? 1 : 0, 1, 1);
            yield break;
        }
    }
    
    public class CounterpartyOnlyExistsValidator : AbstractOnlyExistsValidator<Counterparty> {
    
        protected override IDictionary<string, bool> GetFields(Counterparty obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Role", IsSet(obj.Role!) },
                { "PartyReference", IsSet(obj.PartyReference!) }
            };
        }
    }
    
    public class CounterpartyOwnIssuePermittedValidator : AbstractValidator<CounterpartyOwnIssuePermitted>
    {
    
        public CounterpartyOwnIssuePermittedValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CounterpartyOwnIssuePermitted obj)
        {
            yield break;
        }
    }
    
    public class CounterpartyOwnIssuePermittedOnlyExistsValidator : AbstractOnlyExistsValidator<CounterpartyOwnIssuePermitted> {
    
        protected override IDictionary<string, bool> GetFields(CounterpartyOwnIssuePermitted obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CounterpartyOwnIssuePermittedValue", IsSet(obj.CounterpartyOwnIssuePermittedValue!) }
            };
        }
    }
    
    public class CounterpartyPositionValidator : AbstractValidator<CounterpartyPosition>
    {
    
        public CounterpartyPositionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CounterpartyPosition obj)
        {
            yield return CheckCardinality(Name, "PositionIdentifier", obj.PositionIdentifier.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "OpenDateTime", obj.OpenDateTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "TradeReference", obj.TradeReference.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Party", obj.Party.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "PartyRole", obj.PartyRole.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class CounterpartyPositionOnlyExistsValidator : AbstractOnlyExistsValidator<CounterpartyPosition> {
    
        protected override IDictionary<string, bool> GetFields(CounterpartyPosition obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PositionIdentifier", IsSet(obj.PositionIdentifier!) },
                { "OpenDateTime", IsSet(obj.OpenDateTime!) },
                { "TradeReference", IsSet(obj.TradeReference!) },
                { "Party", IsSet(obj.Party!) },
                { "PartyRole", IsSet(obj.PartyRole!) },
                { "PositionBase", IsSet(obj.PositionBase!) }
            };
        }
    }
    
    public class CounterpartyPositionBusinessEventValidator : AbstractValidator<CounterpartyPositionBusinessEvent>
    {
    
        public CounterpartyPositionBusinessEventValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CounterpartyPositionBusinessEvent obj)
        {
            yield return CheckCardinality(Name, "CorporateActionIntent", obj.CorporateActionIntent != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EventDate", obj.EventDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EffectiveDate", obj.EffectiveDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PackageInformation", obj.PackageInformation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "After", obj.After.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class CounterpartyPositionBusinessEventOnlyExistsValidator : AbstractOnlyExistsValidator<CounterpartyPositionBusinessEvent> {
    
        protected override IDictionary<string, bool> GetFields(CounterpartyPositionBusinessEvent obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Intent", IsSet(obj.Intent!) },
                { "CorporateActionIntent", IsSet(obj.CorporateActionIntent!) },
                { "EventDate", IsSet(obj.EventDate!) },
                { "EffectiveDate", IsSet(obj.EffectiveDate!) },
                { "PackageInformation", IsSet(obj.PackageInformation!) },
                { "After", IsSet(obj.After!) }
            };
        }
    }
    
    public class CounterpartyPositionStateValidator : AbstractValidator<CounterpartyPositionState>
    {
    
        public CounterpartyPositionStateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CounterpartyPositionState obj)
        {
            yield return CheckCardinality(Name, "State", obj.State != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ObservationHistory", obj.ObservationHistory.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "ValuationHistory", obj.ValuationHistory.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CounterpartyPositionStateOnlyExistsValidator : AbstractOnlyExistsValidator<CounterpartyPositionState> {
    
        protected override IDictionary<string, bool> GetFields(CounterpartyPositionState obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CounterpartyPosition", IsSet(obj.CounterpartyPosition!) },
                { "State", IsSet(obj.State!) },
                { "ObservationHistory", IsSet(obj.ObservationHistory!) },
                { "ValuationHistory", IsSet(obj.ValuationHistory!) }
            };
        }
    }
    
    public class CreditDefaultPayoutValidator : AbstractValidator<CreditDefaultPayout>
    {
    
        public CreditDefaultPayoutValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CreditDefaultPayout obj)
        {
            yield return CheckCardinality(Name, "ProtectionTerms", obj.ProtectionTerms.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "TransactedPrice", obj.TransactedPrice != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CreditDefaultPayoutOnlyExistsValidator : AbstractOnlyExistsValidator<CreditDefaultPayout> {
    
        protected override IDictionary<string, bool> GetFields(CreditDefaultPayout obj)
        {
            return new Dictionary<string, bool>()
            {
                { "GeneralTerms", IsSet(obj.GeneralTerms!) },
                { "ProtectionTerms", IsSet(obj.ProtectionTerms!) },
                { "TransactedPrice", IsSet(obj.TransactedPrice!) }
            };
        }
    }
    
    public class CreditEventValidator : AbstractValidator<CreditEvent>
    {
    
        public CreditEventValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CreditEvent obj)
        {
            yield return CheckCardinality(Name, "AuctionDate", obj.AuctionDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FinalPrice", obj.FinalPrice != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RecoveryPercent", obj.RecoveryPercent != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PubliclyAvailableInformation", obj.PubliclyAvailableInformation.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class CreditEventOnlyExistsValidator : AbstractOnlyExistsValidator<CreditEvent> {
    
        protected override IDictionary<string, bool> GetFields(CreditEvent obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CreditEventType", IsSet(obj.CreditEventType!) },
                { "EventDeterminationDate", IsSet(obj.EventDeterminationDate!) },
                { "AuctionDate", IsSet(obj.AuctionDate!) },
                { "FinalPrice", IsSet(obj.FinalPrice!) },
                { "RecoveryPercent", IsSet(obj.RecoveryPercent!) },
                { "PubliclyAvailableInformation", IsSet(obj.PubliclyAvailableInformation!) },
                { "ReferenceInformation", IsSet(obj.ReferenceInformation!) }
            };
        }
    }
    
    public class CreditEventNoticeValidator : AbstractValidator<CreditEventNotice>
    {
    
        public CreditEventNoticeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CreditEventNotice obj)
        {
            yield return CheckCardinality(Name, "NotifyingParty", obj.NotifyingParty.EmptyIfNull().Count(), 1, 2);
            yield return CheckCardinality(Name, "BusinessCenter", obj.BusinessCenter != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PubliclyAvailableInformation", obj.PubliclyAvailableInformation != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CreditEventNoticeOnlyExistsValidator : AbstractOnlyExistsValidator<CreditEventNotice> {
    
        protected override IDictionary<string, bool> GetFields(CreditEventNotice obj)
        {
            return new Dictionary<string, bool>()
            {
                { "NotifyingParty", IsSet(obj.NotifyingParty!) },
                { "BusinessCenter", IsSet(obj.BusinessCenter!) },
                { "PubliclyAvailableInformation", IsSet(obj.PubliclyAvailableInformation!) }
            };
        }
    }
    
    public class CreditEventsValidator : AbstractValidator<CreditEvents>
    {
    
        public CreditEventsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CreditEvents obj)
        {
            yield return CheckCardinality(Name, "Bankruptcy", obj.Bankruptcy != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FailureToPay", obj.FailureToPay != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FailureToPayPrincipal", obj.FailureToPayPrincipal != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FailureToPayInterest", obj.FailureToPayInterest != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ObligationDefault", obj.ObligationDefault != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ObligationAcceleration", obj.ObligationAcceleration != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RepudiationMoratorium", obj.RepudiationMoratorium != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Restructuring", obj.Restructuring != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "GovernmentalIntervention", obj.GovernmentalIntervention != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DistressedRatingsDowngrade", obj.DistressedRatingsDowngrade != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MaturityExtension", obj.MaturityExtension != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Writedown", obj.Writedown != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ImpliedWritedown", obj.ImpliedWritedown != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DefaultRequirement", obj.DefaultRequirement != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CreditEventNotice", obj.CreditEventNotice != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CreditEventsOnlyExistsValidator : AbstractOnlyExistsValidator<CreditEvents> {
    
        protected override IDictionary<string, bool> GetFields(CreditEvents obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Bankruptcy", IsSet(obj.Bankruptcy!) },
                { "FailureToPay", IsSet(obj.FailureToPay!) },
                { "FailureToPayPrincipal", IsSet(obj.FailureToPayPrincipal!) },
                { "FailureToPayInterest", IsSet(obj.FailureToPayInterest!) },
                { "ObligationDefault", IsSet(obj.ObligationDefault!) },
                { "ObligationAcceleration", IsSet(obj.ObligationAcceleration!) },
                { "RepudiationMoratorium", IsSet(obj.RepudiationMoratorium!) },
                { "Restructuring", IsSet(obj.Restructuring!) },
                { "GovernmentalIntervention", IsSet(obj.GovernmentalIntervention!) },
                { "DistressedRatingsDowngrade", IsSet(obj.DistressedRatingsDowngrade!) },
                { "MaturityExtension", IsSet(obj.MaturityExtension!) },
                { "Writedown", IsSet(obj.Writedown!) },
                { "ImpliedWritedown", IsSet(obj.ImpliedWritedown!) },
                { "DefaultRequirement", IsSet(obj.DefaultRequirement!) },
                { "CreditEventNotice", IsSet(obj.CreditEventNotice!) }
            };
        }
    }
    
    public class CreditIndexValidator : AbstractValidator<CreditIndex>
    {
    
        public CreditIndexValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CreditIndex obj)
        {
            yield return CheckCardinality(Name, "IndexSeries", obj.IndexSeries != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IndexAnnexVersion", obj.IndexAnnexVersion != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IndexAnnexDate", obj.IndexAnnexDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IndexAnnexSource", obj.IndexAnnexSource?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExcludedReferenceEntity", obj.ExcludedReferenceEntity.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Tranche", obj.Tranche != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SettledEntityMatrix", obj.SettledEntityMatrix != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IndexFactor", obj.IndexFactor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Seniority", obj.Seniority != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CreditIndexOnlyExistsValidator : AbstractOnlyExistsValidator<CreditIndex> {
    
        protected override IDictionary<string, bool> GetFields(CreditIndex obj)
        {
            return new Dictionary<string, bool>()
            {
                { "IndexSeries", IsSet(obj.IndexSeries!) },
                { "IndexAnnexVersion", IsSet(obj.IndexAnnexVersion!) },
                { "IndexAnnexDate", IsSet(obj.IndexAnnexDate!) },
                { "IndexAnnexSource", IsSet(obj.IndexAnnexSource!) },
                { "ExcludedReferenceEntity", IsSet(obj.ExcludedReferenceEntity!) },
                { "Tranche", IsSet(obj.Tranche!) },
                { "SettledEntityMatrix", IsSet(obj.SettledEntityMatrix!) },
                { "IndexFactor", IsSet(obj.IndexFactor!) },
                { "Seniority", IsSet(obj.Seniority!) }
            };
        }
    }
    
    public class CreditLimitInformationValidator : AbstractValidator<CreditLimitInformation>
    {
    
        public CreditLimitInformationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CreditLimitInformation obj)
        {
            yield return CheckCardinality(Name, "LimitApplicable", obj.LimitApplicable.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class CreditLimitInformationOnlyExistsValidator : AbstractOnlyExistsValidator<CreditLimitInformation> {
    
        protected override IDictionary<string, bool> GetFields(CreditLimitInformation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "LimitApplicable", IsSet(obj.LimitApplicable!) }
            };
        }
    }
    
    public class CreditLimitUtilisationValidator : AbstractValidator<CreditLimitUtilisation>
    {
    
        public CreditLimitUtilisationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CreditLimitUtilisation obj)
        {
            yield return CheckCardinality(Name, "Executed", obj.Executed != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Pending", obj.Pending != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CreditLimitUtilisationOnlyExistsValidator : AbstractOnlyExistsValidator<CreditLimitUtilisation> {
    
        protected override IDictionary<string, bool> GetFields(CreditLimitUtilisation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Executed", IsSet(obj.Executed!) },
                { "Pending", IsSet(obj.Pending!) }
            };
        }
    }
    
    public class CreditLimitUtilisationPositionValidator : AbstractValidator<CreditLimitUtilisationPosition>
    {
    
        public CreditLimitUtilisationPositionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CreditLimitUtilisationPosition obj)
        {
            yield return CheckCardinality(Name, "ShortPosition", obj.ShortPosition != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LongPosition", obj.LongPosition != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Global", obj.Global != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CreditLimitUtilisationPositionOnlyExistsValidator : AbstractOnlyExistsValidator<CreditLimitUtilisationPosition> {
    
        protected override IDictionary<string, bool> GetFields(CreditLimitUtilisationPosition obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ShortPosition", IsSet(obj.ShortPosition!) },
                { "LongPosition", IsSet(obj.LongPosition!) },
                { "Global", IsSet(obj.Global!) }
            };
        }
    }
    
    public class CreditNotationValidator : AbstractValidator<CreditNotation>
    {
    
        public CreditNotationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CreditNotation obj)
        {
            yield return CheckCardinality(Name, "Scale", obj.Scale?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Debt", obj.Debt != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Outlook", obj.Outlook != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CreditWatch", obj.CreditWatch != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CreditNotationOnlyExistsValidator : AbstractOnlyExistsValidator<CreditNotation> {
    
        protected override IDictionary<string, bool> GetFields(CreditNotation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Agency", IsSet(obj.Agency!) },
                { "Notation", IsSet(obj.Notation!) },
                { "Scale", IsSet(obj.Scale!) },
                { "Debt", IsSet(obj.Debt!) },
                { "Outlook", IsSet(obj.Outlook!) },
                { "CreditWatch", IsSet(obj.CreditWatch!) }
            };
        }
    }
    
    public class CreditNotationsValidator : AbstractValidator<CreditNotations>
    {
    
        public CreditNotationsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CreditNotations obj)
        {
            yield return CheckCardinality(Name, "CreditNotation", obj.CreditNotation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CreditNotationsValue", obj.CreditNotationsValue != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CreditNotationsOnlyExistsValidator : AbstractOnlyExistsValidator<CreditNotations> {
    
        protected override IDictionary<string, bool> GetFields(CreditNotations obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CreditNotation", IsSet(obj.CreditNotation!) },
                { "CreditNotationsValue", IsSet(obj.CreditNotationsValue!) }
            };
        }
    }
    
    public class CreditRatingDebtValidator : AbstractValidator<CreditRatingDebt>
    {
    
        public CreditRatingDebtValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CreditRatingDebt obj)
        {
            yield return CheckCardinality(Name, "DebtType", obj.DebtType?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DebtTypes", obj.DebtTypes != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CreditRatingDebtOnlyExistsValidator : AbstractOnlyExistsValidator<CreditRatingDebt> {
    
        protected override IDictionary<string, bool> GetFields(CreditRatingDebt obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DebtType", IsSet(obj.DebtType!) },
                { "DebtTypes", IsSet(obj.DebtTypes!) }
            };
        }
    }
    
    public class CreditSupportAgreementElectionsValidator : AbstractValidator<CreditSupportAgreementElections>
    {
    
        public CreditSupportAgreementElectionsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CreditSupportAgreementElections obj)
        {
            yield break;
        }
    }
    
    public class CreditSupportAgreementElectionsOnlyExistsValidator : AbstractOnlyExistsValidator<CreditSupportAgreementElections> {
    
        protected override IDictionary<string, bool> GetFields(CreditSupportAgreementElections obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class CurveValidator : AbstractValidator<Curve>
    {
    
        public CurveValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Curve obj)
        {
            yield return CheckCardinality(Name, "InterestRateCurve", obj.InterestRateCurve != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CommodityCurve", obj.CommodityCurve?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CurveOnlyExistsValidator : AbstractOnlyExistsValidator<Curve> {
    
        protected override IDictionary<string, bool> GetFields(Curve obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InterestRateCurve", IsSet(obj.InterestRateCurve!) },
                { "CommodityCurve", IsSet(obj.CommodityCurve!) }
            };
        }
    }
    
    public class CustomisableOffsetValidator : AbstractValidator<CustomisableOffset>
    {
    
        public CustomisableOffsetValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CustomisableOffset obj)
        {
            yield return CheckCardinality(Name, "Offset", obj.Offset != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CustomProvision", obj.CustomProvision != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class CustomisableOffsetOnlyExistsValidator : AbstractOnlyExistsValidator<CustomisableOffset> {
    
        protected override IDictionary<string, bool> GetFields(CustomisableOffset obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Offset", IsSet(obj.Offset!) },
                { "CustomProvision", IsSet(obj.CustomProvision!) }
            };
        }
    }
    
    public class CustomisedWorkflowValidator : AbstractValidator<CustomisedWorkflow>
    {
    
        public CustomisedWorkflowValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(CustomisedWorkflow obj)
        {
            yield break;
        }
    }
    
    public class CustomisedWorkflowOnlyExistsValidator : AbstractOnlyExistsValidator<CustomisedWorkflow> {
    
        protected override IDictionary<string, bool> GetFields(CustomisedWorkflow obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ItemName", IsSet(obj.ItemName!) },
                { "ItemValue", IsSet(obj.ItemValue!) }
            };
        }
    }
    
    public class DateListValidator : AbstractValidator<DateList>
    {
    
        public DateListValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DateList obj)
        {
            yield return CheckCardinality(Name, "Date", obj.Date.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class DateListOnlyExistsValidator : AbstractOnlyExistsValidator<DateList> {
    
        protected override IDictionary<string, bool> GetFields(DateList obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Date", IsSet(obj.Date!) }
            };
        }
    }
    
    public class DateRangeValidator : AbstractValidator<DateRange>
    {
    
        public DateRangeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DateRange obj)
        {
            yield break;
        }
    }
    
    public class DateRangeOnlyExistsValidator : AbstractOnlyExistsValidator<DateRange> {
    
        protected override IDictionary<string, bool> GetFields(DateRange obj)
        {
            return new Dictionary<string, bool>()
            {
                { "StartDate", IsSet(obj.StartDate!) },
                { "EndDate", IsSet(obj.EndDate!) }
            };
        }
    }
    
    public class DateRelativeToCalculationPeriodDatesValidator : AbstractValidator<DateRelativeToCalculationPeriodDates>
    {
    
        public DateRelativeToCalculationPeriodDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DateRelativeToCalculationPeriodDates obj)
        {
            yield return CheckCardinality(Name, "CalculationPeriodDatesReference", obj.CalculationPeriodDatesReference.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class DateRelativeToCalculationPeriodDatesOnlyExistsValidator : AbstractOnlyExistsValidator<DateRelativeToCalculationPeriodDates> {
    
        protected override IDictionary<string, bool> GetFields(DateRelativeToCalculationPeriodDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CalculationPeriodDatesReference", IsSet(obj.CalculationPeriodDatesReference!) }
            };
        }
    }
    
    public class DateRelativeToPaymentDatesValidator : AbstractValidator<DateRelativeToPaymentDates>
    {
    
        public DateRelativeToPaymentDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DateRelativeToPaymentDates obj)
        {
            yield return CheckCardinality(Name, "PaymentDatesReference", obj.PaymentDatesReference.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class DateRelativeToPaymentDatesOnlyExistsValidator : AbstractOnlyExistsValidator<DateRelativeToPaymentDates> {
    
        protected override IDictionary<string, bool> GetFields(DateRelativeToPaymentDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PaymentDatesReference", IsSet(obj.PaymentDatesReference!) }
            };
        }
    }
    
    public class DateRelativeToValuationDatesValidator : AbstractValidator<DateRelativeToValuationDates>
    {
    
        public DateRelativeToValuationDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DateRelativeToValuationDates obj)
        {
            yield return CheckCardinality(Name, "ValuationDatesReference", obj.ValuationDatesReference.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class DateRelativeToValuationDatesOnlyExistsValidator : AbstractOnlyExistsValidator<DateRelativeToValuationDates> {
    
        protected override IDictionary<string, bool> GetFields(DateRelativeToValuationDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ValuationDatesReference", IsSet(obj.ValuationDatesReference!) }
            };
        }
    }
    
    public class DateTimeListValidator : AbstractValidator<DateTimeList>
    {
    
        public DateTimeListValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DateTimeList obj)
        {
            yield return CheckCardinality(Name, "DateTime", obj.DateTime.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class DateTimeListOnlyExistsValidator : AbstractOnlyExistsValidator<DateTimeList> {
    
        protected override IDictionary<string, bool> GetFields(DateTimeList obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DateTime", IsSet(obj.DateTime!) }
            };
        }
    }
    
    public class DatedValueValidator : AbstractValidator<DatedValue>
    {
    
        public DatedValueValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DatedValue obj)
        {
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class DatedValueOnlyExistsValidator : AbstractOnlyExistsValidator<DatedValue> {
    
        protected override IDictionary<string, bool> GetFields(DatedValue obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Date", IsSet(obj.Date!) },
                { "Value", IsSet(obj.Value!) }
            };
        }
    }
    
    public class DebtEconomicsValidator : AbstractValidator<DebtEconomics>
    {
    
        public DebtEconomicsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DebtEconomics obj)
        {
            yield return CheckCardinality(Name, "DebtSeniority", obj.DebtSeniority != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DebtInterest", obj.DebtInterest != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DebtPrincipal", obj.DebtPrincipal != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class DebtEconomicsOnlyExistsValidator : AbstractOnlyExistsValidator<DebtEconomics> {
    
        protected override IDictionary<string, bool> GetFields(DebtEconomics obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DebtSeniority", IsSet(obj.DebtSeniority!) },
                { "DebtInterest", IsSet(obj.DebtInterest!) },
                { "DebtPrincipal", IsSet(obj.DebtPrincipal!) }
            };
        }
    }
    
    public class DebtTypeValidator : AbstractValidator<DebtType>
    {
    
        public DebtTypeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DebtType obj)
        {
            yield return CheckCardinality(Name, "DebtClass", obj.DebtClass != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DebtEconomics", obj.DebtEconomics.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class DebtTypeOnlyExistsValidator : AbstractOnlyExistsValidator<DebtType> {
    
        protected override IDictionary<string, bool> GetFields(DebtType obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DebtClass", IsSet(obj.DebtClass!) },
                { "DebtEconomics", IsSet(obj.DebtEconomics!) }
            };
        }
    }
    
    public class DeliverableObligationsValidator : AbstractValidator<DeliverableObligations>
    {
    
        public DeliverableObligationsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DeliverableObligations obj)
        {
            yield return CheckCardinality(Name, "AccruedInterest", obj.AccruedInterest != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Category", obj.Category != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NotSubordinated", obj.NotSubordinated != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SpecifiedCurrency", obj.SpecifiedCurrency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NotSovereignLender", obj.NotSovereignLender != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NotDomesticCurrency", obj.NotDomesticCurrency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NotDomesticLaw", obj.NotDomesticLaw != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Listed", obj.Listed != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NotContingent", obj.NotContingent != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NotDomesticIssuance", obj.NotDomesticIssuance != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AssignableLoan", obj.AssignableLoan != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ConsentRequiredLoan", obj.ConsentRequiredLoan != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DirectLoanParticipation", obj.DirectLoanParticipation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Transferable", obj.Transferable != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MaximumMaturity", obj.MaximumMaturity != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AcceleratedOrMatured", obj.AcceleratedOrMatured != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NotBearer", obj.NotBearer != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FullFaithAndCreditObLiability", obj.FullFaithAndCreditObLiability != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "GeneralFundObligationLiability", obj.GeneralFundObligationLiability != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RevenueObligationLiability", obj.RevenueObligationLiability != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IndirectLoanParticipation", obj.IndirectLoanParticipation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Excluded", obj.Excluded != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "OthReferenceEntityObligations", obj.OthReferenceEntityObligations != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class DeliverableObligationsOnlyExistsValidator : AbstractOnlyExistsValidator<DeliverableObligations> {
    
        protected override IDictionary<string, bool> GetFields(DeliverableObligations obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AccruedInterest", IsSet(obj.AccruedInterest!) },
                { "Category", IsSet(obj.Category!) },
                { "NotSubordinated", IsSet(obj.NotSubordinated!) },
                { "SpecifiedCurrency", IsSet(obj.SpecifiedCurrency!) },
                { "NotSovereignLender", IsSet(obj.NotSovereignLender!) },
                { "NotDomesticCurrency", IsSet(obj.NotDomesticCurrency!) },
                { "NotDomesticLaw", IsSet(obj.NotDomesticLaw!) },
                { "Listed", IsSet(obj.Listed!) },
                { "NotContingent", IsSet(obj.NotContingent!) },
                { "NotDomesticIssuance", IsSet(obj.NotDomesticIssuance!) },
                { "AssignableLoan", IsSet(obj.AssignableLoan!) },
                { "ConsentRequiredLoan", IsSet(obj.ConsentRequiredLoan!) },
                { "DirectLoanParticipation", IsSet(obj.DirectLoanParticipation!) },
                { "Transferable", IsSet(obj.Transferable!) },
                { "MaximumMaturity", IsSet(obj.MaximumMaturity!) },
                { "AcceleratedOrMatured", IsSet(obj.AcceleratedOrMatured!) },
                { "NotBearer", IsSet(obj.NotBearer!) },
                { "FullFaithAndCreditObLiability", IsSet(obj.FullFaithAndCreditObLiability!) },
                { "GeneralFundObligationLiability", IsSet(obj.GeneralFundObligationLiability!) },
                { "RevenueObligationLiability", IsSet(obj.RevenueObligationLiability!) },
                { "IndirectLoanParticipation", IsSet(obj.IndirectLoanParticipation!) },
                { "Excluded", IsSet(obj.Excluded!) },
                { "OthReferenceEntityObligations", IsSet(obj.OthReferenceEntityObligations!) }
            };
        }
    }
    
    public class DeliveryAmountValidator : AbstractValidator<DeliveryAmount>
    {
    
        public DeliveryAmountValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DeliveryAmount obj)
        {
            yield return CheckCardinality(Name, "StandardElection", obj.StandardElection != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CustomElection", obj.CustomElection != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class DeliveryAmountOnlyExistsValidator : AbstractOnlyExistsValidator<DeliveryAmount> {
    
        protected override IDictionary<string, bool> GetFields(DeliveryAmount obj)
        {
            return new Dictionary<string, bool>()
            {
                { "StandardElection", IsSet(obj.StandardElection!) },
                { "CustomElection", IsSet(obj.CustomElection!) }
            };
        }
    }
    
    public class DeliveryDateParametersValidator : AbstractValidator<DeliveryDateParameters>
    {
    
        public DeliveryDateParametersValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DeliveryDateParameters obj)
        {
            yield return CheckCardinality(Name, "DeliveryNearby", obj.DeliveryNearby != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DeliveryDate", obj.DeliveryDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DeliveryDateRollConvention", obj.DeliveryDateRollConvention != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DeliveryDateExpirationConvention", obj.DeliveryDateExpirationConvention != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class DeliveryDateParametersOnlyExistsValidator : AbstractOnlyExistsValidator<DeliveryDateParameters> {
    
        protected override IDictionary<string, bool> GetFields(DeliveryDateParameters obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DeliveryNearby", IsSet(obj.DeliveryNearby!) },
                { "DeliveryDate", IsSet(obj.DeliveryDate!) },
                { "DeliveryDateRollConvention", IsSet(obj.DeliveryDateRollConvention!) },
                { "DeliveryDateExpirationConvention", IsSet(obj.DeliveryDateExpirationConvention!) }
            };
        }
    }
    
    public class DerivInstrmAttrbtsValidator : AbstractValidator<DerivInstrmAttrbts>
    {
    
        public DerivInstrmAttrbtsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DerivInstrmAttrbts obj)
        {
            yield break;
        }
    }
    
    public class DerivInstrmAttrbtsOnlyExistsValidator : AbstractOnlyExistsValidator<DerivInstrmAttrbts> {
    
        protected override IDictionary<string, bool> GetFields(DerivInstrmAttrbts obj)
        {
            return new Dictionary<string, bool>()
            {
                { "XpryDt", IsSet(obj.XpryDt!) },
                { "PricMltplr", IsSet(obj.PricMltplr!) },
                { "UndrlygInstrm", IsSet(obj.UndrlygInstrm!) },
                { "DlvryTp", IsSet(obj.DlvryTp!) }
            };
        }
    }
    
    public class DeterminationMethodologyValidator : AbstractValidator<DeterminationMethodology>
    {
    
        public DeterminationMethodologyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DeterminationMethodology obj)
        {
            yield return CheckCardinality(Name, "DeterminationMethod", obj.DeterminationMethod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AveragingMethod", obj.AveragingMethod != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class DeterminationMethodologyOnlyExistsValidator : AbstractOnlyExistsValidator<DeterminationMethodology> {
    
        protected override IDictionary<string, bool> GetFields(DeterminationMethodology obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DeterminationMethod", IsSet(obj.DeterminationMethod!) },
                { "AveragingMethod", IsSet(obj.AveragingMethod!) }
            };
        }
    }
    
    public class DeterminationRolesAndTermsValidator : AbstractValidator<DeterminationRolesAndTerms>
    {
    
        public DeterminationRolesAndTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DeterminationRolesAndTerms obj)
        {
            yield break;
        }
    }
    
    public class DeterminationRolesAndTermsOnlyExistsValidator : AbstractOnlyExistsValidator<DeterminationRolesAndTerms> {
    
        protected override IDictionary<string, bool> GetFields(DeterminationRolesAndTerms obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class DigitalAssetValidator : AbstractValidator<DigitalAsset>
    {
    
        public DigitalAssetValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DigitalAsset obj)
        {
            yield break;
        }
    }
    
    public class DigitalAssetOnlyExistsValidator : AbstractOnlyExistsValidator<DigitalAsset> {
    
        protected override IDictionary<string, bool> GetFields(DigitalAsset obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class DiscountingMethodValidator : AbstractValidator<DiscountingMethod>
    {
    
        public DiscountingMethodValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DiscountingMethod obj)
        {
            yield return CheckCardinality(Name, "DiscountRate", obj.DiscountRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DiscountRateDayCountFraction", obj.DiscountRateDayCountFraction?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class DiscountingMethodOnlyExistsValidator : AbstractOnlyExistsValidator<DiscountingMethod> {
    
        protected override IDictionary<string, bool> GetFields(DiscountingMethod obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DiscountingType", IsSet(obj.DiscountingType!) },
                { "DiscountRate", IsSet(obj.DiscountRate!) },
                { "DiscountRateDayCountFraction", IsSet(obj.DiscountRateDayCountFraction!) }
            };
        }
    }
    
    public class DistributionAndInterestPaymentValidator : AbstractValidator<DistributionAndInterestPayment>
    {
    
        public DistributionAndInterestPaymentValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DistributionAndInterestPayment obj)
        {
            yield return CheckCardinality(Name, "InterestParameters", obj.InterestParameters.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class DistributionAndInterestPaymentOnlyExistsValidator : AbstractOnlyExistsValidator<DistributionAndInterestPayment> {
    
        protected override IDictionary<string, bool> GetFields(DistributionAndInterestPayment obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InterestParameters", IsSet(obj.InterestParameters!) }
            };
        }
    }
    
    public class DividendApplicabilityValidator : AbstractValidator<DividendApplicability>
    {
    
        public DividendApplicabilityValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DividendApplicability obj)
        {
            yield return CheckCardinality(Name, "OptionsExchangeDividends", obj.OptionsExchangeDividends != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdditionalDividends", obj.AdditionalDividends != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AllDividends", obj.AllDividends != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class DividendApplicabilityOnlyExistsValidator : AbstractOnlyExistsValidator<DividendApplicability> {
    
        protected override IDictionary<string, bool> GetFields(DividendApplicability obj)
        {
            return new Dictionary<string, bool>()
            {
                { "OptionsExchangeDividends", IsSet(obj.OptionsExchangeDividends!) },
                { "AdditionalDividends", IsSet(obj.AdditionalDividends!) },
                { "AllDividends", IsSet(obj.AllDividends!) }
            };
        }
    }
    
    public class DividendCurrencyValidator : AbstractValidator<DividendCurrency>
    {
    
        public DividendCurrencyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DividendCurrency obj)
        {
            yield return CheckCardinality(Name, "Currency", obj.Currency?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DeterminationMethod", obj.DeterminationMethod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CurrencyReference", obj.CurrencyReference?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class DividendCurrencyOnlyExistsValidator : AbstractOnlyExistsValidator<DividendCurrency> {
    
        protected override IDictionary<string, bool> GetFields(DividendCurrency obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Currency", IsSet(obj.Currency!) },
                { "DeterminationMethod", IsSet(obj.DeterminationMethod!) },
                { "CurrencyReference", IsSet(obj.CurrencyReference!) }
            };
        }
    }
    
    public class DividendDateReferenceValidator : AbstractValidator<DividendDateReference>
    {
    
        public DividendDateReferenceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DividendDateReference obj)
        {
            yield return CheckCardinality(Name, "PaymentDateOffset", obj.PaymentDateOffset != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class DividendDateReferenceOnlyExistsValidator : AbstractOnlyExistsValidator<DividendDateReference> {
    
        protected override IDictionary<string, bool> GetFields(DividendDateReference obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DateReference", IsSet(obj.DateReference!) },
                { "PaymentDateOffset", IsSet(obj.PaymentDateOffset!) }
            };
        }
    }
    
    public class DividendPaymentDateValidator : AbstractValidator<DividendPaymentDate>
    {
    
        public DividendPaymentDateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DividendPaymentDate obj)
        {
            yield return CheckCardinality(Name, "DividendDateReference", obj.DividendDateReference != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DividendDate", obj.DividendDate?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class DividendPaymentDateOnlyExistsValidator : AbstractOnlyExistsValidator<DividendPaymentDate> {
    
        protected override IDictionary<string, bool> GetFields(DividendPaymentDate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DividendDateReference", IsSet(obj.DividendDateReference!) },
                { "DividendDate", IsSet(obj.DividendDate!) }
            };
        }
    }
    
    public class DividendPayoutRatioValidator : AbstractValidator<DividendPayoutRatio>
    {
    
        public DividendPayoutRatioValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DividendPayoutRatio obj)
        {
            yield return CheckCardinality(Name, "CashRatio", obj.CashRatio != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NonCashRatio", obj.NonCashRatio != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BasketConstituent", obj.BasketConstituent?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class DividendPayoutRatioOnlyExistsValidator : AbstractOnlyExistsValidator<DividendPayoutRatio> {
    
        protected override IDictionary<string, bool> GetFields(DividendPayoutRatio obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TotalRatio", IsSet(obj.TotalRatio!) },
                { "CashRatio", IsSet(obj.CashRatio!) },
                { "NonCashRatio", IsSet(obj.NonCashRatio!) },
                { "BasketConstituent", IsSet(obj.BasketConstituent!) }
            };
        }
    }
    
    public class DividendPeriodValidator : AbstractValidator<DividendPeriod>
    {
    
        public DividendPeriodValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DividendPeriod obj)
        {
            yield return CheckCardinality(Name, "StartDate", obj.StartDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EndDate", obj.EndDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BasketConstituent", obj.BasketConstituent?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DividendValuationDate", obj.DividendValuationDate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class DividendPeriodOnlyExistsValidator : AbstractOnlyExistsValidator<DividendPeriod> {
    
        protected override IDictionary<string, bool> GetFields(DividendPeriod obj)
        {
            return new Dictionary<string, bool>()
            {
                { "StartDate", IsSet(obj.StartDate!) },
                { "EndDate", IsSet(obj.EndDate!) },
                { "DateAdjustments", IsSet(obj.DateAdjustments!) },
                { "BasketConstituent", IsSet(obj.BasketConstituent!) },
                { "DividendPaymentDate", IsSet(obj.DividendPaymentDate!) },
                { "DividendValuationDate", IsSet(obj.DividendValuationDate!) }
            };
        }
    }
    
    public class DividendReturnTermsValidator : AbstractValidator<DividendReturnTerms>
    {
    
        public DividendReturnTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DividendReturnTerms obj)
        {
            yield return CheckCardinality(Name, "DividendPayoutRatio", obj.DividendPayoutRatio.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "DividendReinvestment", obj.DividendReinvestment != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DividendEntitlement", obj.DividendEntitlement != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DividendAmountType", obj.DividendAmountType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Performance", obj.Performance != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FirstOrSecondPeriod", obj.FirstOrSecondPeriod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExtraordinaryDividendsParty", obj.ExtraordinaryDividendsParty != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExcessDividendAmount", obj.ExcessDividendAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DividendCurrency", obj.DividendCurrency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NonCashDividendTreatment", obj.NonCashDividendTreatment != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DividendComposition", obj.DividendComposition != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SpecialDividends", obj.SpecialDividends != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MaterialDividend", obj.MaterialDividend != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DividendPeriod", obj.DividendPeriod.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class DividendReturnTermsOnlyExistsValidator : AbstractOnlyExistsValidator<DividendReturnTerms> {
    
        protected override IDictionary<string, bool> GetFields(DividendReturnTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DividendPayoutRatio", IsSet(obj.DividendPayoutRatio!) },
                { "DividendReinvestment", IsSet(obj.DividendReinvestment!) },
                { "DividendEntitlement", IsSet(obj.DividendEntitlement!) },
                { "DividendAmountType", IsSet(obj.DividendAmountType!) },
                { "Performance", IsSet(obj.Performance!) },
                { "FirstOrSecondPeriod", IsSet(obj.FirstOrSecondPeriod!) },
                { "ExtraordinaryDividendsParty", IsSet(obj.ExtraordinaryDividendsParty!) },
                { "ExcessDividendAmount", IsSet(obj.ExcessDividendAmount!) },
                { "DividendCurrency", IsSet(obj.DividendCurrency!) },
                { "NonCashDividendTreatment", IsSet(obj.NonCashDividendTreatment!) },
                { "DividendComposition", IsSet(obj.DividendComposition!) },
                { "SpecialDividends", IsSet(obj.SpecialDividends!) },
                { "MaterialDividend", IsSet(obj.MaterialDividend!) },
                { "DividendPeriod", IsSet(obj.DividendPeriod!) }
            };
        }
    }
    
    public class DividendTermsValidator : AbstractValidator<DividendTerms>
    {
    
        public DividendTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DividendTerms obj)
        {
            yield return CheckCardinality(Name, "DividendEntitlement", obj.DividendEntitlement != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MinimumBillingAmount", obj.MinimumBillingAmount != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class DividendTermsOnlyExistsValidator : AbstractOnlyExistsValidator<DividendTerms> {
    
        protected override IDictionary<string, bool> GetFields(DividendTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ManufacturedIncomeRequirement", IsSet(obj.ManufacturedIncomeRequirement!) },
                { "DividendEntitlement", IsSet(obj.DividendEntitlement!) },
                { "MinimumBillingAmount", IsSet(obj.MinimumBillingAmount!) }
            };
        }
    }
    
    public class DocumentValidator : AbstractValidator<Document>
    {
    
        public DocumentValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Document obj)
        {
            yield break;
        }
    }
    
    public class DocumentOnlyExistsValidator : AbstractOnlyExistsValidator<Document> {
    
        protected override IDictionary<string, bool> GetFields(Document obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FinInstrmRptgTxRpt", IsSet(obj.FinInstrmRptgTxRpt!) }
            };
        }
    }
    
    public class DomesticCurrencyIssuedValidator : AbstractValidator<DomesticCurrencyIssued>
    {
    
        public DomesticCurrencyIssuedValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(DomesticCurrencyIssued obj)
        {
            yield break;
        }
    }
    
    public class DomesticCurrencyIssuedOnlyExistsValidator : AbstractOnlyExistsValidator<DomesticCurrencyIssued> {
    
        protected override IDictionary<string, bool> GetFields(DomesticCurrencyIssued obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DomesticCurrencyIssuedValue", IsSet(obj.DomesticCurrencyIssuedValue!) }
            };
        }
    }
    
    public class EarlyTerminationEventValidator : AbstractValidator<EarlyTerminationEvent>
    {
    
        public EarlyTerminationEventValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EarlyTerminationEvent obj)
        {
            yield return CheckCardinality(Name, "AdjustedExerciseFeePaymentDate", obj.AdjustedExerciseFeePaymentDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class EarlyTerminationEventOnlyExistsValidator : AbstractOnlyExistsValidator<EarlyTerminationEvent> {
    
        protected override IDictionary<string, bool> GetFields(EarlyTerminationEvent obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AdjustedExerciseDate", IsSet(obj.AdjustedExerciseDate!) },
                { "AdjustedEarlyTerminationDate", IsSet(obj.AdjustedEarlyTerminationDate!) },
                { "AdjustedCashSettlementValuationDate", IsSet(obj.AdjustedCashSettlementValuationDate!) },
                { "AdjustedCashSettlementPaymentDate", IsSet(obj.AdjustedCashSettlementPaymentDate!) },
                { "AdjustedExerciseFeePaymentDate", IsSet(obj.AdjustedExerciseFeePaymentDate!) }
            };
        }
    }
    
    public class EarlyTerminationProvisionValidator : AbstractValidator<EarlyTerminationProvision>
    {
    
        public EarlyTerminationProvisionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EarlyTerminationProvision obj)
        {
            yield return CheckCardinality(Name, "MandatoryEarlyTermination", obj.MandatoryEarlyTermination != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MandatoryEarlyTerminationDateTenor", obj.MandatoryEarlyTerminationDateTenor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "OptionalEarlyTermination", obj.OptionalEarlyTermination != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "OptionalEarlyTerminationParameters", obj.OptionalEarlyTerminationParameters != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class EarlyTerminationProvisionOnlyExistsValidator : AbstractOnlyExistsValidator<EarlyTerminationProvision> {
    
        protected override IDictionary<string, bool> GetFields(EarlyTerminationProvision obj)
        {
            return new Dictionary<string, bool>()
            {
                { "MandatoryEarlyTermination", IsSet(obj.MandatoryEarlyTermination!) },
                { "MandatoryEarlyTerminationDateTenor", IsSet(obj.MandatoryEarlyTerminationDateTenor!) },
                { "OptionalEarlyTermination", IsSet(obj.OptionalEarlyTermination!) },
                { "OptionalEarlyTerminationParameters", IsSet(obj.OptionalEarlyTerminationParameters!) }
            };
        }
    }
    
    public class EconomicTermsValidator : AbstractValidator<EconomicTerms>
    {
    
        public EconomicTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EconomicTerms obj)
        {
            yield return CheckCardinality(Name, "EffectiveDate", obj.EffectiveDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "TerminationDate", obj.TerminationDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DateAdjustments", obj.DateAdjustments != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Payout", obj.Payout.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "TerminationProvision", obj.TerminationProvision != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationAgent", obj.CalculationAgent != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NonStandardisedTerms", obj.NonStandardisedTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Collateral", obj.Collateral != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class EconomicTermsOnlyExistsValidator : AbstractOnlyExistsValidator<EconomicTerms> {
    
        protected override IDictionary<string, bool> GetFields(EconomicTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "EffectiveDate", IsSet(obj.EffectiveDate!) },
                { "TerminationDate", IsSet(obj.TerminationDate!) },
                { "DateAdjustments", IsSet(obj.DateAdjustments!) },
                { "Payout", IsSet(obj.Payout!) },
                { "TerminationProvision", IsSet(obj.TerminationProvision!) },
                { "CalculationAgent", IsSet(obj.CalculationAgent!) },
                { "NonStandardisedTerms", IsSet(obj.NonStandardisedTerms!) },
                { "Collateral", IsSet(obj.Collateral!) }
            };
        }
    }
    
    public class EligibilityQueryValidator : AbstractValidator<EligibilityQuery>
    {
    
        public EligibilityQueryValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EligibilityQuery obj)
        {
            yield break;
        }
    }
    
    public class EligibilityQueryOnlyExistsValidator : AbstractOnlyExistsValidator<EligibilityQuery> {
    
        protected override IDictionary<string, bool> GetFields(EligibilityQuery obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Maturity", IsSet(obj.Maturity!) },
                { "CollateralAssetType", IsSet(obj.CollateralAssetType!) },
                { "AssetCountryOfOrigin", IsSet(obj.AssetCountryOfOrigin!) },
                { "DenominatedCurrency", IsSet(obj.DenominatedCurrency!) },
                { "AgencyRating", IsSet(obj.AgencyRating!) },
                { "IssuerType", IsSet(obj.IssuerType!) },
                { "IssuerName", IsSet(obj.IssuerName!) }
            };
        }
    }
    
    public class EligibleCollateralCriteriaValidator : AbstractValidator<EligibleCollateralCriteria>
    {
    
        public EligibleCollateralCriteriaValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EligibleCollateralCriteria obj)
        {
            yield break;
        }
    }
    
    public class EligibleCollateralCriteriaOnlyExistsValidator : AbstractOnlyExistsValidator<EligibleCollateralCriteria> {
    
        protected override IDictionary<string, bool> GetFields(EligibleCollateralCriteria obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Treatment", IsSet(obj.Treatment!) }
            };
        }
    }
    
    public class EligibleCollateralSpecificationValidator : AbstractValidator<EligibleCollateralSpecification>
    {
    
        public EligibleCollateralSpecificationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EligibleCollateralSpecification obj)
        {
            yield return CheckCardinality(Name, "Identifier", obj.Identifier.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Party", obj.Party.EmptyIfNull().Count(), 0, 2);
            yield return CheckCardinality(Name, "Counterparty", obj.Counterparty.EmptyIfNull().Count(), 0, 2);
            yield return CheckCardinality(Name, "Criteria", obj.Criteria.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "PartyRole", obj.PartyRole.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class EligibleCollateralSpecificationOnlyExistsValidator : AbstractOnlyExistsValidator<EligibleCollateralSpecification> {
    
        protected override IDictionary<string, bool> GetFields(EligibleCollateralSpecification obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Identifier", IsSet(obj.Identifier!) },
                { "Party", IsSet(obj.Party!) },
                { "Counterparty", IsSet(obj.Counterparty!) },
                { "Criteria", IsSet(obj.Criteria!) },
                { "PartyRole", IsSet(obj.PartyRole!) }
            };
        }
    }
    
    public class EligibleCollateralSpecificationInstructionValidator : AbstractValidator<EligibleCollateralSpecificationInstruction>
    {
    
        public EligibleCollateralSpecificationInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EligibleCollateralSpecificationInstruction obj)
        {
            yield return CheckCardinality(Name, "Variable", obj.Variable.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class EligibleCollateralSpecificationInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<EligibleCollateralSpecificationInstruction> {
    
        protected override IDictionary<string, bool> GetFields(EligibleCollateralSpecificationInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Common", IsSet(obj.Common!) },
                { "Variable", IsSet(obj.Variable!) }
            };
        }
    }
    
    public class EquityAdditionalTermsValidator : AbstractValidator<EquityAdditionalTerms>
    {
    
        public EquityAdditionalTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EquityAdditionalTerms obj)
        {
            yield return CheckCardinality(Name, "ExtraordinaryEvents", obj.ExtraordinaryEvents != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DeterminationTerms", obj.DeterminationTerms.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "SubstitutionProvision", obj.SubstitutionProvision != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class EquityAdditionalTermsOnlyExistsValidator : AbstractOnlyExistsValidator<EquityAdditionalTerms> {
    
        protected override IDictionary<string, bool> GetFields(EquityAdditionalTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ExtraordinaryEvents", IsSet(obj.ExtraordinaryEvents!) },
                { "DeterminationTerms", IsSet(obj.DeterminationTerms!) },
                { "SubstitutionProvision", IsSet(obj.SubstitutionProvision!) }
            };
        }
    }
    
    public class EquityCorporateEventsValidator : AbstractValidator<EquityCorporateEvents>
    {
    
        public EquityCorporateEventsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EquityCorporateEvents obj)
        {
            yield break;
        }
    }
    
    public class EquityCorporateEventsOnlyExistsValidator : AbstractOnlyExistsValidator<EquityCorporateEvents> {
    
        protected override IDictionary<string, bool> GetFields(EquityCorporateEvents obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class EquityIndexValidator : AbstractValidator<EquityIndex>
    {
    
        public EquityIndexValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EquityIndex obj)
        {
            yield break;
        }
    }
    
    public class EquityIndexOnlyExistsValidator : AbstractOnlyExistsValidator<EquityIndex> {
    
        protected override IDictionary<string, bool> GetFields(EquityIndex obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class EquityMasterConfirmationValidator : AbstractValidator<EquityMasterConfirmation>
    {
    
        public EquityMasterConfirmationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EquityMasterConfirmation obj)
        {
            yield break;
        }
    }
    
    public class EquityMasterConfirmationOnlyExistsValidator : AbstractOnlyExistsValidator<EquityMasterConfirmation> {
    
        protected override IDictionary<string, bool> GetFields(EquityMasterConfirmation obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class EquitySwapMasterConfirmation2018Validator : AbstractValidator<EquitySwapMasterConfirmation2018>
    {
    
        public EquitySwapMasterConfirmation2018Validator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EquitySwapMasterConfirmation2018 obj)
        {
            yield break;
        }
    }
    
    public class EquitySwapMasterConfirmation2018OnlyExistsValidator : AbstractOnlyExistsValidator<EquitySwapMasterConfirmation2018> {
    
        protected override IDictionary<string, bool> GetFields(EquitySwapMasterConfirmation2018 obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TypeOfSwapElection", IsSet(obj.TypeOfSwapElection!) },
                { "PricingMethodElection", IsSet(obj.PricingMethodElection!) },
                { "LinearInterpolationElection", IsSet(obj.LinearInterpolationElection!) },
                { "SettlementTerms", IsSet(obj.SettlementTerms!) },
                { "ValuationDates", IsSet(obj.ValuationDates!) },
                { "EquityCashSettlementDates", IsSet(obj.EquityCashSettlementDates!) }
            };
        }
    }
    
    public class EquityUnderlierProvisionsValidator : AbstractValidator<EquityUnderlierProvisions>
    {
    
        public EquityUnderlierProvisionsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EquityUnderlierProvisions obj)
        {
            yield return CheckCardinality(Name, "MultipleExchangeIndexAnnexFallback", obj.MultipleExchangeIndexAnnexFallback != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ComponentSecurityIndexAnnexFallback", obj.ComponentSecurityIndexAnnexFallback != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LocalJurisdiction", obj.LocalJurisdiction?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RelevantJurisdiction", obj.RelevantJurisdiction?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class EquityUnderlierProvisionsOnlyExistsValidator : AbstractOnlyExistsValidator<EquityUnderlierProvisions> {
    
        protected override IDictionary<string, bool> GetFields(EquityUnderlierProvisions obj)
        {
            return new Dictionary<string, bool>()
            {
                { "MultipleExchangeIndexAnnexFallback", IsSet(obj.MultipleExchangeIndexAnnexFallback!) },
                { "ComponentSecurityIndexAnnexFallback", IsSet(obj.ComponentSecurityIndexAnnexFallback!) },
                { "LocalJurisdiction", IsSet(obj.LocalJurisdiction!) },
                { "RelevantJurisdiction", IsSet(obj.RelevantJurisdiction!) }
            };
        }
    }
    
    public class EventInstructionValidator : AbstractValidator<EventInstruction>
    {
    
        public EventInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EventInstruction obj)
        {
            yield return CheckCardinality(Name, "Intent", obj.Intent != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CorporateActionIntent", obj.CorporateActionIntent != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EventDate", obj.EventDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EffectiveDate", obj.EffectiveDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PackageInformation", obj.PackageInformation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Instruction", obj.Instruction.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class EventInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<EventInstruction> {
    
        protected override IDictionary<string, bool> GetFields(EventInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Intent", IsSet(obj.Intent!) },
                { "CorporateActionIntent", IsSet(obj.CorporateActionIntent!) },
                { "EventDate", IsSet(obj.EventDate!) },
                { "EffectiveDate", IsSet(obj.EffectiveDate!) },
                { "PackageInformation", IsSet(obj.PackageInformation!) },
                { "Instruction", IsSet(obj.Instruction!) }
            };
        }
    }
    
    public class EventTimestampValidator : AbstractValidator<EventTimestamp>
    {
    
        public EventTimestampValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EventTimestamp obj)
        {
            yield break;
        }
    }
    
    public class EventTimestampOnlyExistsValidator : AbstractOnlyExistsValidator<EventTimestamp> {
    
        protected override IDictionary<string, bool> GetFields(EventTimestamp obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DateTime", IsSet(obj.DateTime!) },
                { "Qualification", IsSet(obj.Qualification!) }
            };
        }
    }
    
    public class EvergreenProvisionValidator : AbstractValidator<EvergreenProvision>
    {
    
        public EvergreenProvisionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(EvergreenProvision obj)
        {
            yield return CheckCardinality(Name, "SinglePartyOption", obj.SinglePartyOption != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NoticeDeadlinePeriod", obj.NoticeDeadlinePeriod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NoticeDeadlineDateTime", obj.NoticeDeadlineDateTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FinalPeriodFeeAdjustment", obj.FinalPeriodFeeAdjustment != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class EvergreenProvisionOnlyExistsValidator : AbstractOnlyExistsValidator<EvergreenProvision> {
    
        protected override IDictionary<string, bool> GetFields(EvergreenProvision obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SinglePartyOption", IsSet(obj.SinglePartyOption!) },
                { "NoticePeriod", IsSet(obj.NoticePeriod!) },
                { "NoticeDeadlinePeriod", IsSet(obj.NoticeDeadlinePeriod!) },
                { "NoticeDeadlineDateTime", IsSet(obj.NoticeDeadlineDateTime!) },
                { "ExtensionFrequency", IsSet(obj.ExtensionFrequency!) },
                { "FinalPeriodFeeAdjustment", IsSet(obj.FinalPeriodFeeAdjustment!) }
            };
        }
    }
    
    public class ExctgPrsnValidator : AbstractValidator<ExctgPrsn>
    {
    
        public ExctgPrsnValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ExctgPrsn obj)
        {
            yield break;
        }
    }
    
    public class ExctgPrsnOnlyExistsValidator : AbstractOnlyExistsValidator<ExctgPrsn> {
    
        protected override IDictionary<string, bool> GetFields(ExctgPrsn obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Prsn", IsSet(obj.Prsn!) }
            };
        }
    }
    
    public class ExecutionDetailsValidator : AbstractValidator<ExecutionDetails>
    {
    
        public ExecutionDetailsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ExecutionDetails obj)
        {
            yield return CheckCardinality(Name, "ExecutionVenue", obj.ExecutionVenue != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PackageReference", obj.PackageReference != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ExecutionDetailsOnlyExistsValidator : AbstractOnlyExistsValidator<ExecutionDetails> {
    
        protected override IDictionary<string, bool> GetFields(ExecutionDetails obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ExecutionType", IsSet(obj.ExecutionType!) },
                { "ExecutionVenue", IsSet(obj.ExecutionVenue!) },
                { "PackageReference", IsSet(obj.PackageReference!) }
            };
        }
    }
    
    public class ExecutionInstructionValidator : AbstractValidator<ExecutionInstruction>
    {
    
        public ExecutionInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ExecutionInstruction obj)
        {
            yield return CheckCardinality(Name, "PriceQuantity", obj.PriceQuantity.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "Counterparty", obj.Counterparty.EmptyIfNull().Count(), 2, 2);
            yield return CheckCardinality(Name, "AncillaryParty", obj.AncillaryParty.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Parties", obj.Parties.EmptyIfNull().Count(), 2, 0);
            yield return CheckCardinality(Name, "PartyRoles", obj.PartyRoles.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "TradeTime", obj.TradeTime?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "TradeIdentifier", obj.TradeIdentifier.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "Collateral", obj.Collateral != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LotIdentifier", obj.LotIdentifier != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ExecutionInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<ExecutionInstruction> {
    
        protected override IDictionary<string, bool> GetFields(ExecutionInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Product", IsSet(obj.Product!) },
                { "PriceQuantity", IsSet(obj.PriceQuantity!) },
                { "Counterparty", IsSet(obj.Counterparty!) },
                { "AncillaryParty", IsSet(obj.AncillaryParty!) },
                { "Parties", IsSet(obj.Parties!) },
                { "PartyRoles", IsSet(obj.PartyRoles!) },
                { "ExecutionDetails", IsSet(obj.ExecutionDetails!) },
                { "TradeDate", IsSet(obj.TradeDate!) },
                { "TradeTime", IsSet(obj.TradeTime!) },
                { "TradeIdentifier", IsSet(obj.TradeIdentifier!) },
                { "Collateral", IsSet(obj.Collateral!) },
                { "LotIdentifier", IsSet(obj.LotIdentifier!) }
            };
        }
    }
    
    public class ExerciseEventValidator : AbstractValidator<ExerciseEvent>
    {
    
        public ExerciseEventValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ExerciseEvent obj)
        {
            yield return CheckCardinality(Name, "AdjustedCashSettlementValuationDate", obj.AdjustedCashSettlementValuationDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdjustedCashSettlementPaymentDate", obj.AdjustedCashSettlementPaymentDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdjustedExerciseFeePaymentDate", obj.AdjustedExerciseFeePaymentDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ExerciseEventOnlyExistsValidator : AbstractOnlyExistsValidator<ExerciseEvent> {
    
        protected override IDictionary<string, bool> GetFields(ExerciseEvent obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AdjustedExerciseDate", IsSet(obj.AdjustedExerciseDate!) },
                { "AdjustedRelevantSwapEffectiveDate", IsSet(obj.AdjustedRelevantSwapEffectiveDate!) },
                { "AdjustedCashSettlementValuationDate", IsSet(obj.AdjustedCashSettlementValuationDate!) },
                { "AdjustedCashSettlementPaymentDate", IsSet(obj.AdjustedCashSettlementPaymentDate!) },
                { "AdjustedExerciseFeePaymentDate", IsSet(obj.AdjustedExerciseFeePaymentDate!) }
            };
        }
    }
    
    public class ExerciseFeeValidator : AbstractValidator<ExerciseFee>
    {
    
        public ExerciseFeeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ExerciseFee obj)
        {
            yield return CheckCardinality(Name, "NotionalReference", obj.NotionalReference.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "FeeAmount", obj.FeeAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FeeRate", obj.FeeRate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ExerciseFeeOnlyExistsValidator : AbstractOnlyExistsValidator<ExerciseFee> {
    
        protected override IDictionary<string, bool> GetFields(ExerciseFee obj)
        {
            return new Dictionary<string, bool>()
            {
                { "NotionalReference", IsSet(obj.NotionalReference!) },
                { "FeeAmount", IsSet(obj.FeeAmount!) },
                { "FeeRate", IsSet(obj.FeeRate!) },
                { "FeePaymentDate", IsSet(obj.FeePaymentDate!) }
            };
        }
    }
    
    public class ExerciseFeeScheduleValidator : AbstractValidator<ExerciseFeeSchedule>
    {
    
        public ExerciseFeeScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ExerciseFeeSchedule obj)
        {
            yield return CheckCardinality(Name, "NotionalReference", obj.NotionalReference.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "FeeAmountSchedule", obj.FeeAmountSchedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FeeRateSchedule", obj.FeeRateSchedule != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ExerciseFeeScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<ExerciseFeeSchedule> {
    
        protected override IDictionary<string, bool> GetFields(ExerciseFeeSchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "NotionalReference", IsSet(obj.NotionalReference!) },
                { "FeeAmountSchedule", IsSet(obj.FeeAmountSchedule!) },
                { "FeeRateSchedule", IsSet(obj.FeeRateSchedule!) },
                { "FeePaymentDate", IsSet(obj.FeePaymentDate!) }
            };
        }
    }
    
    public class ExerciseInstructionValidator : AbstractValidator<ExerciseInstruction>
    {
    
        public ExerciseInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ExerciseInstruction obj)
        {
            yield return CheckCardinality(Name, "ExerciseOption", obj.ExerciseOption?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExerciseDate", obj.ExerciseDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExerciseTime", obj.ExerciseTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ReplacementTradeIdentifier", obj.ReplacementTradeIdentifier.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class ExerciseInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<ExerciseInstruction> {
    
        protected override IDictionary<string, bool> GetFields(ExerciseInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ExerciseQuantity", IsSet(obj.ExerciseQuantity!) },
                { "ExerciseOption", IsSet(obj.ExerciseOption!) },
                { "ExerciseDate", IsSet(obj.ExerciseDate!) },
                { "ExerciseTime", IsSet(obj.ExerciseTime!) },
                { "ReplacementTradeIdentifier", IsSet(obj.ReplacementTradeIdentifier!) }
            };
        }
    }
    
    public class ExerciseNoticeValidator : AbstractValidator<ExerciseNotice>
    {
    
        public ExerciseNoticeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ExerciseNotice obj)
        {
            yield return CheckCardinality(Name, "ExerciseNoticeReceiver", obj.ExerciseNoticeReceiver != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ExerciseNoticeOnlyExistsValidator : AbstractOnlyExistsValidator<ExerciseNotice> {
    
        protected override IDictionary<string, bool> GetFields(ExerciseNotice obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ExerciseNoticeGiver", IsSet(obj.ExerciseNoticeGiver!) },
                { "ExerciseNoticeReceiver", IsSet(obj.ExerciseNoticeReceiver!) },
                { "BusinessCenter", IsSet(obj.BusinessCenter!) }
            };
        }
    }
    
    public class ExercisePeriodValidator : AbstractValidator<ExercisePeriod>
    {
    
        public ExercisePeriodValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ExercisePeriod obj)
        {
            yield return CheckCardinality(Name, "ExerciseFrequency", obj.ExerciseFrequency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ExercisePeriodOnlyExistsValidator : AbstractOnlyExistsValidator<ExercisePeriod> {
    
        protected override IDictionary<string, bool> GetFields(ExercisePeriod obj)
        {
            return new Dictionary<string, bool>()
            {
                { "EarliestExerciseDateTenor", IsSet(obj.EarliestExerciseDateTenor!) },
                { "ExerciseFrequency", IsSet(obj.ExerciseFrequency!) }
            };
        }
    }
    
    public class ExerciseProcedureValidator : AbstractValidator<ExerciseProcedure>
    {
    
        public ExerciseProcedureValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ExerciseProcedure obj)
        {
            yield return CheckCardinality(Name, "ManualExercise", obj.ManualExercise != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AutomaticExercise", obj.AutomaticExercise != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LimitedRightToConfirm", obj.LimitedRightToConfirm != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SplitTicket", obj.SplitTicket != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ExerciseProcedureOnlyExistsValidator : AbstractOnlyExistsValidator<ExerciseProcedure> {
    
        protected override IDictionary<string, bool> GetFields(ExerciseProcedure obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ManualExercise", IsSet(obj.ManualExercise!) },
                { "AutomaticExercise", IsSet(obj.AutomaticExercise!) },
                { "FollowUpConfirmation", IsSet(obj.FollowUpConfirmation!) },
                { "LimitedRightToConfirm", IsSet(obj.LimitedRightToConfirm!) },
                { "SplitTicket", IsSet(obj.SplitTicket!) }
            };
        }
    }
    
    public class ExerciseTermsValidator : AbstractValidator<ExerciseTerms>
    {
    
        public ExerciseTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ExerciseTerms obj)
        {
            yield return CheckCardinality(Name, "Style", obj.Style != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CommencementDate", obj.CommencementDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExerciseDates", obj.ExerciseDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExpirationDate", obj.ExpirationDate.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "RelevantUnderlyingDate", obj.RelevantUnderlyingDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EarliestExerciseTime", obj.EarliestExerciseTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LatestExerciseTime", obj.LatestExerciseTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExpirationTime", obj.ExpirationTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MultipleExercise", obj.MultipleExercise != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExerciseFeeSchedule", obj.ExerciseFeeSchedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExerciseProcedure", obj.ExerciseProcedure != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExerciseFee", obj.ExerciseFee != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PartialExercise", obj.PartialExercise != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ExerciseTermsOnlyExistsValidator : AbstractOnlyExistsValidator<ExerciseTerms> {
    
        protected override IDictionary<string, bool> GetFields(ExerciseTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Style", IsSet(obj.Style!) },
                { "CommencementDate", IsSet(obj.CommencementDate!) },
                { "ExerciseDates", IsSet(obj.ExerciseDates!) },
                { "ExpirationDate", IsSet(obj.ExpirationDate!) },
                { "RelevantUnderlyingDate", IsSet(obj.RelevantUnderlyingDate!) },
                { "EarliestExerciseTime", IsSet(obj.EarliestExerciseTime!) },
                { "LatestExerciseTime", IsSet(obj.LatestExerciseTime!) },
                { "ExpirationTime", IsSet(obj.ExpirationTime!) },
                { "ExpirationTimeType", IsSet(obj.ExpirationTimeType!) },
                { "MultipleExercise", IsSet(obj.MultipleExercise!) },
                { "ExerciseFeeSchedule", IsSet(obj.ExerciseFeeSchedule!) },
                { "ExerciseProcedure", IsSet(obj.ExerciseProcedure!) },
                { "ExerciseFee", IsSet(obj.ExerciseFee!) },
                { "PartialExercise", IsSet(obj.PartialExercise!) }
            };
        }
    }
    
    public class ExposureValidator : AbstractValidator<Exposure>
    {
    
        public ExposureValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Exposure obj)
        {
            yield return CheckCardinality(Name, "TradePortfolio", obj.TradePortfolio.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "CalculationDateTime", obj.CalculationDateTime != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ExposureOnlyExistsValidator : AbstractOnlyExistsValidator<Exposure> {
    
        protected override IDictionary<string, bool> GetFields(Exposure obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TradePortfolio", IsSet(obj.TradePortfolio!) },
                { "AggregateValue", IsSet(obj.AggregateValue!) },
                { "CalculationDateTime", IsSet(obj.CalculationDateTime!) },
                { "ValuationDateTime", IsSet(obj.ValuationDateTime!) }
            };
        }
    }
    
    public class ExtendibleProvisionValidator : AbstractValidator<ExtendibleProvision>
    {
    
        public ExtendibleProvisionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ExtendibleProvision obj)
        {
            yield return CheckCardinality(Name, "ExerciseNotice", obj.ExerciseNotice != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FollowUpConfirmation", obj.FollowUpConfirmation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExtendibleProvisionAdjustedDates", obj.ExtendibleProvisionAdjustedDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CallingParty", obj.CallingParty != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SinglePartyOption", obj.SinglePartyOption != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NoticeDeadlinePeriod", obj.NoticeDeadlinePeriod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NoticeDeadlineDateTime", obj.NoticeDeadlineDateTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExtensionTerm", obj.ExtensionTerm != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExtensionPeriod", obj.ExtensionPeriod != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ExtendibleProvisionOnlyExistsValidator : AbstractOnlyExistsValidator<ExtendibleProvision> {
    
        protected override IDictionary<string, bool> GetFields(ExtendibleProvision obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ExerciseNotice", IsSet(obj.ExerciseNotice!) },
                { "FollowUpConfirmation", IsSet(obj.FollowUpConfirmation!) },
                { "ExtendibleProvisionAdjustedDates", IsSet(obj.ExtendibleProvisionAdjustedDates!) },
                { "CallingParty", IsSet(obj.CallingParty!) },
                { "SinglePartyOption", IsSet(obj.SinglePartyOption!) },
                { "NoticeDeadlinePeriod", IsSet(obj.NoticeDeadlinePeriod!) },
                { "NoticeDeadlineDateTime", IsSet(obj.NoticeDeadlineDateTime!) },
                { "ExtensionTerm", IsSet(obj.ExtensionTerm!) },
                { "ExtensionPeriod", IsSet(obj.ExtensionPeriod!) },
                { "ExerciseTerms", IsSet(obj.ExerciseTerms!) }
            };
        }
    }
    
    public class ExtendibleProvisionAdjustedDatesValidator : AbstractValidator<ExtendibleProvisionAdjustedDates>
    {
    
        public ExtendibleProvisionAdjustedDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ExtendibleProvisionAdjustedDates obj)
        {
            yield return CheckCardinality(Name, "ExtensionEvent", obj.ExtensionEvent.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class ExtendibleProvisionAdjustedDatesOnlyExistsValidator : AbstractOnlyExistsValidator<ExtendibleProvisionAdjustedDates> {
    
        protected override IDictionary<string, bool> GetFields(ExtendibleProvisionAdjustedDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ExtensionEvent", IsSet(obj.ExtensionEvent!) }
            };
        }
    }
    
    public class ExtensionEventValidator : AbstractValidator<ExtensionEvent>
    {
    
        public ExtensionEventValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ExtensionEvent obj)
        {
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ExtensionEventOnlyExistsValidator : AbstractOnlyExistsValidator<ExtensionEvent> {
    
        protected override IDictionary<string, bool> GetFields(ExtensionEvent obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AdjustedExerciseDate", IsSet(obj.AdjustedExerciseDate!) },
                { "AdjustedExtendedTerminationDate", IsSet(obj.AdjustedExtendedTerminationDate!) }
            };
        }
    }
    
    public class ExtraordinaryEventsValidator : AbstractValidator<ExtraordinaryEvents>
    {
    
        public ExtraordinaryEventsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ExtraordinaryEvents obj)
        {
            yield return CheckCardinality(Name, "AdditionalBespokeTerms", obj.AdditionalBespokeTerms.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "MergerEvents", obj.MergerEvents != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "TenderOfferEvents", obj.TenderOfferEvents != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CompositionOfCombinedConsideration", obj.CompositionOfCombinedConsideration != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IndexAdjustmentEvents", obj.IndexAdjustmentEvents != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdditionalDisruptionEvents", obj.AdditionalDisruptionEvents != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FailureToDeliver", obj.FailureToDeliver != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Representations", obj.Representations != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NationalizationOrInsolvency", obj.NationalizationOrInsolvency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Delisting", obj.Delisting != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ExtraordinaryEventsOnlyExistsValidator : AbstractOnlyExistsValidator<ExtraordinaryEvents> {
    
        protected override IDictionary<string, bool> GetFields(ExtraordinaryEvents obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AdditionalBespokeTerms", IsSet(obj.AdditionalBespokeTerms!) },
                { "MergerEvents", IsSet(obj.MergerEvents!) },
                { "TenderOfferEvents", IsSet(obj.TenderOfferEvents!) },
                { "CompositionOfCombinedConsideration", IsSet(obj.CompositionOfCombinedConsideration!) },
                { "IndexAdjustmentEvents", IsSet(obj.IndexAdjustmentEvents!) },
                { "AdditionalDisruptionEvents", IsSet(obj.AdditionalDisruptionEvents!) },
                { "FailureToDeliver", IsSet(obj.FailureToDeliver!) },
                { "Representations", IsSet(obj.Representations!) },
                { "NationalizationOrInsolvency", IsSet(obj.NationalizationOrInsolvency!) },
                { "Delisting", IsSet(obj.Delisting!) }
            };
        }
    }
    
    public class FailureToPayValidator : AbstractValidator<FailureToPay>
    {
    
        public FailureToPayValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FailureToPay obj)
        {
            yield return CheckCardinality(Name, "GracePeriodExtension", obj.GracePeriodExtension != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PaymentRequirement", obj.PaymentRequirement != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FailureToPayOnlyExistsValidator : AbstractOnlyExistsValidator<FailureToPay> {
    
        protected override IDictionary<string, bool> GetFields(FailureToPay obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Applicable", IsSet(obj.Applicable!) },
                { "GracePeriodExtension", IsSet(obj.GracePeriodExtension!) },
                { "PaymentRequirement", IsSet(obj.PaymentRequirement!) }
            };
        }
    }
    
    public class FallbackRateParametersValidator : AbstractValidator<FallbackRateParameters>
    {
    
        public FallbackRateParametersValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FallbackRateParameters obj)
        {
            yield return CheckCardinality(Name, "EffectiveDate", obj.EffectiveDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationParameters", obj.CalculationParameters != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SpreadAdjustment", obj.SpreadAdjustment != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FallbackRateParametersOnlyExistsValidator : AbstractOnlyExistsValidator<FallbackRateParameters> {
    
        protected override IDictionary<string, bool> GetFields(FallbackRateParameters obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FloatingRateIndex", IsSet(obj.FloatingRateIndex!) },
                { "EffectiveDate", IsSet(obj.EffectiveDate!) },
                { "CalculationParameters", IsSet(obj.CalculationParameters!) },
                { "SpreadAdjustment", IsSet(obj.SpreadAdjustment!) }
            };
        }
    }
    
    public class FallbackReferencePriceValidator : AbstractValidator<FallbackReferencePrice>
    {
    
        public FallbackReferencePriceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FallbackReferencePrice obj)
        {
            yield return CheckCardinality(Name, "ValuationPostponement", obj.ValuationPostponement != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FallBackSettlementRateOption", obj.FallBackSettlementRateOption.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "FallbackSurveyValuationPostponement", obj.FallbackSurveyValuationPostponement != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationAgentDetermination", obj.CalculationAgentDetermination != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FallbackReferencePriceOnlyExistsValidator : AbstractOnlyExistsValidator<FallbackReferencePrice> {
    
        protected override IDictionary<string, bool> GetFields(FallbackReferencePrice obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ValuationPostponement", IsSet(obj.ValuationPostponement!) },
                { "FallBackSettlementRateOption", IsSet(obj.FallBackSettlementRateOption!) },
                { "FallbackSurveyValuationPostponement", IsSet(obj.FallbackSurveyValuationPostponement!) },
                { "CalculationAgentDetermination", IsSet(obj.CalculationAgentDetermination!) }
            };
        }
    }
    
    public class FeaturePaymentValidator : AbstractValidator<FeaturePayment>
    {
    
        public FeaturePaymentValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FeaturePayment obj)
        {
            yield return CheckCardinality(Name, "LevelPercentage", obj.LevelPercentage != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Amount", obj.Amount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Time", obj.Time != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Currency", obj.Currency?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PaymentDate", obj.PaymentDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FeaturePaymentOnlyExistsValidator : AbstractOnlyExistsValidator<FeaturePayment> {
    
        protected override IDictionary<string, bool> GetFields(FeaturePayment obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PayerReceiver", IsSet(obj.PayerReceiver!) },
                { "LevelPercentage", IsSet(obj.LevelPercentage!) },
                { "Amount", IsSet(obj.Amount!) },
                { "Time", IsSet(obj.Time!) },
                { "Currency", IsSet(obj.Currency!) },
                { "PaymentDate", IsSet(obj.PaymentDate!) }
            };
        }
    }
    
    public class FinInstrmValidator : AbstractValidator<FinInstrm>
    {
    
        public FinInstrmValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FinInstrm obj)
        {
            yield break;
        }
    }
    
    public class FinInstrmOnlyExistsValidator : AbstractOnlyExistsValidator<FinInstrm> {
    
        protected override IDictionary<string, bool> GetFields(FinInstrm obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Othr", IsSet(obj.Othr!) }
            };
        }
    }
    
    public class FinInstrmGnlAttrbtsValidator : AbstractValidator<FinInstrmGnlAttrbts>
    {
    
        public FinInstrmGnlAttrbtsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FinInstrmGnlAttrbts obj)
        {
            yield break;
        }
    }
    
    public class FinInstrmGnlAttrbtsOnlyExistsValidator : AbstractOnlyExistsValidator<FinInstrmGnlAttrbts> {
    
        protected override IDictionary<string, bool> GetFields(FinInstrmGnlAttrbts obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FullNm", IsSet(obj.FullNm!) },
                { "ClssfctnTp", IsSet(obj.ClssfctnTp!) },
                { "NtnlCcy", IsSet(obj.NtnlCcy!) }
            };
        }
    }
    
    public class FinInstrmRptgTxRptValidator : AbstractValidator<FinInstrmRptgTxRpt>
    {
    
        public FinInstrmRptgTxRptValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FinInstrmRptgTxRpt obj)
        {
            yield break;
        }
    }
    
    public class FinInstrmRptgTxRptOnlyExistsValidator : AbstractOnlyExistsValidator<FinInstrmRptgTxRpt> {
    
        protected override IDictionary<string, bool> GetFields(FinInstrmRptgTxRpt obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Tx", IsSet(obj.Tx!) }
            };
        }
    }
    
    public class FinalCalculationPeriodDateAdjustmentValidator : AbstractValidator<FinalCalculationPeriodDateAdjustment>
    {
    
        public FinalCalculationPeriodDateAdjustmentValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FinalCalculationPeriodDateAdjustment obj)
        {
            yield return CheckCardinality(Name, "RelevantUnderlyingDateReference", obj.RelevantUnderlyingDateReference.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "SwapStreamReference", obj.SwapStreamReference.Value != null ? 1 : 0, 1, 1);
            yield break;
        }
    }
    
    public class FinalCalculationPeriodDateAdjustmentOnlyExistsValidator : AbstractOnlyExistsValidator<FinalCalculationPeriodDateAdjustment> {
    
        protected override IDictionary<string, bool> GetFields(FinalCalculationPeriodDateAdjustment obj)
        {
            return new Dictionary<string, bool>()
            {
                { "RelevantUnderlyingDateReference", IsSet(obj.RelevantUnderlyingDateReference!) },
                { "SwapStreamReference", IsSet(obj.SwapStreamReference!) },
                { "BusinessDayConvention", IsSet(obj.BusinessDayConvention!) }
            };
        }
    }
    
    public class FixedAmountCalculationDetailsValidator : AbstractValidator<FixedAmountCalculationDetails>
    {
    
        public FixedAmountCalculationDetailsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FixedAmountCalculationDetails obj)
        {
            yield break;
        }
    }
    
    public class FixedAmountCalculationDetailsOnlyExistsValidator : AbstractOnlyExistsValidator<FixedAmountCalculationDetails> {
    
        protected override IDictionary<string, bool> GetFields(FixedAmountCalculationDetails obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CalculationPeriod", IsSet(obj.CalculationPeriod!) },
                { "CalculationPeriodNotionalAmount", IsSet(obj.CalculationPeriodNotionalAmount!) },
                { "FixedRate", IsSet(obj.FixedRate!) },
                { "YearFraction", IsSet(obj.YearFraction!) },
                { "CalculatedAmount", IsSet(obj.CalculatedAmount!) }
            };
        }
    }
    
    public class FixedPriceValidator : AbstractValidator<FixedPrice>
    {
    
        public FixedPriceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FixedPrice obj)
        {
            yield return CheckCardinality(Name, "Price", obj.Price?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FixedPriceOnlyExistsValidator : AbstractOnlyExistsValidator<FixedPrice> {
    
        protected override IDictionary<string, bool> GetFields(FixedPrice obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Price", IsSet(obj.Price!) }
            };
        }
    }
    
    public class FixedPricePayoutValidator : AbstractValidator<FixedPricePayout>
    {
    
        public FixedPricePayoutValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FixedPricePayout obj)
        {
            yield return CheckCardinality(Name, "Schedule", obj.Schedule != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FixedPricePayoutOnlyExistsValidator : AbstractOnlyExistsValidator<FixedPricePayout> {
    
        protected override IDictionary<string, bool> GetFields(FixedPricePayout obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PaymentDates", IsSet(obj.PaymentDates!) },
                { "FixedPrice", IsSet(obj.FixedPrice!) },
                { "Schedule", IsSet(obj.Schedule!) }
            };
        }
    }
    
    public class FixedRateSpecificationValidator : AbstractValidator<FixedRateSpecification>
    {
    
        public FixedRateSpecificationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FixedRateSpecification obj)
        {
            yield return CheckCardinality(Name, "RateSchedule", obj.RateSchedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FixedRateSpecificationOnlyExistsValidator : AbstractOnlyExistsValidator<FixedRateSpecification> {
    
        protected override IDictionary<string, bool> GetFields(FixedRateSpecification obj)
        {
            return new Dictionary<string, bool>()
            {
                { "RateSchedule", IsSet(obj.RateSchedule!) }
            };
        }
    }
    
    public class FloatingAmountCalculationDetailsValidator : AbstractValidator<FloatingAmountCalculationDetails>
    {
    
        public FloatingAmountCalculationDetailsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FloatingAmountCalculationDetails obj)
        {
            yield return CheckCardinality(Name, "FloatingRate", obj.FloatingRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ProcessingDetails", obj.ProcessingDetails != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FloatingAmountCalculationDetailsOnlyExistsValidator : AbstractOnlyExistsValidator<FloatingAmountCalculationDetails> {
    
        protected override IDictionary<string, bool> GetFields(FloatingAmountCalculationDetails obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CalculationPeriod", IsSet(obj.CalculationPeriod!) },
                { "CalculationPeriodNotionalAmount", IsSet(obj.CalculationPeriodNotionalAmount!) },
                { "FloatingRate", IsSet(obj.FloatingRate!) },
                { "ProcessingDetails", IsSet(obj.ProcessingDetails!) },
                { "AppliedRate", IsSet(obj.AppliedRate!) },
                { "YearFraction", IsSet(obj.YearFraction!) },
                { "CalculatedAmount", IsSet(obj.CalculatedAmount!) },
                { "SpreadExclusiveCalculatedAMount", IsSet(obj.SpreadExclusiveCalculatedAMount!) }
            };
        }
    }
    
    public class FloatingAmountEventsValidator : AbstractValidator<FloatingAmountEvents>
    {
    
        public FloatingAmountEventsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FloatingAmountEvents obj)
        {
            yield return CheckCardinality(Name, "FailureToPayPrincipal", obj.FailureToPayPrincipal != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InterestShortfall", obj.InterestShortfall != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Writedown", obj.Writedown != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ImpliedWritedown", obj.ImpliedWritedown != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FloatingAmountProvisions", obj.FloatingAmountProvisions != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdditionalFixedPayments", obj.AdditionalFixedPayments != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FloatingAmountEventsOnlyExistsValidator : AbstractOnlyExistsValidator<FloatingAmountEvents> {
    
        protected override IDictionary<string, bool> GetFields(FloatingAmountEvents obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FailureToPayPrincipal", IsSet(obj.FailureToPayPrincipal!) },
                { "InterestShortfall", IsSet(obj.InterestShortfall!) },
                { "Writedown", IsSet(obj.Writedown!) },
                { "ImpliedWritedown", IsSet(obj.ImpliedWritedown!) },
                { "FloatingAmountProvisions", IsSet(obj.FloatingAmountProvisions!) },
                { "AdditionalFixedPayments", IsSet(obj.AdditionalFixedPayments!) }
            };
        }
    }
    
    public class FloatingAmountProvisionsValidator : AbstractValidator<FloatingAmountProvisions>
    {
    
        public FloatingAmountProvisionsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FloatingAmountProvisions obj)
        {
            yield return CheckCardinality(Name, "WacCapInterestProvision", obj.WacCapInterestProvision != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "StepUpProvision", obj.StepUpProvision != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FloatingAmountProvisionsOnlyExistsValidator : AbstractOnlyExistsValidator<FloatingAmountProvisions> {
    
        protected override IDictionary<string, bool> GetFields(FloatingAmountProvisions obj)
        {
            return new Dictionary<string, bool>()
            {
                { "WacCapInterestProvision", IsSet(obj.WacCapInterestProvision!) },
                { "StepUpProvision", IsSet(obj.StepUpProvision!) }
            };
        }
    }
    
    public class FloatingRateValidator : AbstractValidator<FloatingRate>
    {
    
        public FloatingRateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FloatingRate obj)
        {
            yield return CheckCardinality(Name, "FloatingRateMultiplierSchedule", obj.FloatingRateMultiplierSchedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RateTreatment", obj.RateTreatment != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationParameters", obj.CalculationParameters != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FallbackRate", obj.FallbackRate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FloatingRateOnlyExistsValidator : AbstractOnlyExistsValidator<FloatingRate> {
    
        protected override IDictionary<string, bool> GetFields(FloatingRate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FloatingRateMultiplierSchedule", IsSet(obj.FloatingRateMultiplierSchedule!) },
                { "RateTreatment", IsSet(obj.RateTreatment!) },
                { "CalculationParameters", IsSet(obj.CalculationParameters!) },
                { "FallbackRate", IsSet(obj.FallbackRate!) }
            };
        }
    }
    
    public class FloatingRateBaseValidator : AbstractValidator<FloatingRateBase>
    {
    
        public FloatingRateBaseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FloatingRateBase obj)
        {
            yield return CheckCardinality(Name, "RateOption", obj.RateOption?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SpreadSchedule", obj.SpreadSchedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CapRateSchedule", obj.CapRateSchedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FloorRateSchedule", obj.FloorRateSchedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FloatingRateBaseOnlyExistsValidator : AbstractOnlyExistsValidator<FloatingRateBase> {
    
        protected override IDictionary<string, bool> GetFields(FloatingRateBase obj)
        {
            return new Dictionary<string, bool>()
            {
                { "RateOption", IsSet(obj.RateOption!) },
                { "SpreadSchedule", IsSet(obj.SpreadSchedule!) },
                { "CapRateSchedule", IsSet(obj.CapRateSchedule!) },
                { "FloorRateSchedule", IsSet(obj.FloorRateSchedule!) }
            };
        }
    }
    
    public class FloatingRateCalculationParametersValidator : AbstractValidator<FloatingRateCalculationParameters>
    {
    
        public FloatingRateCalculationParametersValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FloatingRateCalculationParameters obj)
        {
            yield return CheckCardinality(Name, "ObservationShiftCalculation", obj.ObservationShiftCalculation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LookbackCalculation", obj.LookbackCalculation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LockoutCalculation", obj.LockoutCalculation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ApplicableBusinessDays", obj.ApplicableBusinessDays != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ObservationParameters", obj.ObservationParameters != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FloatingRateCalculationParametersOnlyExistsValidator : AbstractOnlyExistsValidator<FloatingRateCalculationParameters> {
    
        protected override IDictionary<string, bool> GetFields(FloatingRateCalculationParameters obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CalculationMethod", IsSet(obj.CalculationMethod!) },
                { "ObservationShiftCalculation", IsSet(obj.ObservationShiftCalculation!) },
                { "LookbackCalculation", IsSet(obj.LookbackCalculation!) },
                { "LockoutCalculation", IsSet(obj.LockoutCalculation!) },
                { "ApplicableBusinessDays", IsSet(obj.ApplicableBusinessDays!) },
                { "ObservationParameters", IsSet(obj.ObservationParameters!) }
            };
        }
    }
    
    public class FloatingRateDefinitionValidator : AbstractValidator<FloatingRateDefinition>
    {
    
        public FloatingRateDefinitionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FloatingRateDefinition obj)
        {
            yield return CheckCardinality(Name, "CalculatedRate", obj.CalculatedRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RateObservation", obj.RateObservation.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "FloatingRateMultiplier", obj.FloatingRateMultiplier != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Spread", obj.Spread != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CapRate", obj.CapRate.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "FloorRate", obj.FloorRate.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class FloatingRateDefinitionOnlyExistsValidator : AbstractOnlyExistsValidator<FloatingRateDefinition> {
    
        protected override IDictionary<string, bool> GetFields(FloatingRateDefinition obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CalculatedRate", IsSet(obj.CalculatedRate!) },
                { "RateObservation", IsSet(obj.RateObservation!) },
                { "FloatingRateMultiplier", IsSet(obj.FloatingRateMultiplier!) },
                { "Spread", IsSet(obj.Spread!) },
                { "CapRate", IsSet(obj.CapRate!) },
                { "FloorRate", IsSet(obj.FloorRate!) }
            };
        }
    }
    
    public class FloatingRateIndexValidator : AbstractValidator<FloatingRateIndex>
    {
    
        public FloatingRateIndexValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FloatingRateIndex obj)
        {
            yield return CheckCardinality(Name, "IndexTenor", obj.IndexTenor != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FloatingRateIndexOnlyExistsValidator : AbstractOnlyExistsValidator<FloatingRateIndex> {
    
        protected override IDictionary<string, bool> GetFields(FloatingRateIndex obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FloatingRateIndexValue", IsSet(obj.FloatingRateIndexValue!) },
                { "IndexTenor", IsSet(obj.IndexTenor!) }
            };
        }
    }
    
    public class FloatingRateIndexCalculationDefaultsValidator : AbstractValidator<FloatingRateIndexCalculationDefaults>
    {
    
        public FloatingRateIndexCalculationDefaultsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FloatingRateIndexCalculationDefaults obj)
        {
            yield return CheckCardinality(Name, "Category", obj.Category != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IndexStyle", obj.IndexStyle != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Method", obj.Method != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FloatingRateIndexCalculationDefaultsOnlyExistsValidator : AbstractOnlyExistsValidator<FloatingRateIndexCalculationDefaults> {
    
        protected override IDictionary<string, bool> GetFields(FloatingRateIndexCalculationDefaults obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Category", IsSet(obj.Category!) },
                { "IndexStyle", IsSet(obj.IndexStyle!) },
                { "Method", IsSet(obj.Method!) }
            };
        }
    }
    
    public class FloatingRateIndexDefinitionValidator : AbstractValidator<FloatingRateIndexDefinition>
    {
    
        public FloatingRateIndexDefinitionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FloatingRateIndexDefinition obj)
        {
            yield return CheckCardinality(Name, "CalculationDefaults", obj.CalculationDefaults != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FloatingRateIndexDefinitionOnlyExistsValidator : AbstractOnlyExistsValidator<FloatingRateIndexDefinition> {
    
        protected override IDictionary<string, bool> GetFields(FloatingRateIndexDefinition obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Fro", IsSet(obj.Fro!) },
                { "CalculationDefaults", IsSet(obj.CalculationDefaults!) }
            };
        }
    }
    
    public class FloatingRateIndexIdentificationValidator : AbstractValidator<FloatingRateIndexIdentification>
    {
    
        public FloatingRateIndexIdentificationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FloatingRateIndexIdentification obj)
        {
            yield return CheckCardinality(Name, "FloatingRateIndex", obj.FloatingRateIndex?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Currency", obj.Currency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FroType", obj.FroType != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FloatingRateIndexIdentificationOnlyExistsValidator : AbstractOnlyExistsValidator<FloatingRateIndexIdentification> {
    
        protected override IDictionary<string, bool> GetFields(FloatingRateIndexIdentification obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FloatingRateIndex", IsSet(obj.FloatingRateIndex!) },
                { "Currency", IsSet(obj.Currency!) },
                { "FroType", IsSet(obj.FroType!) }
            };
        }
    }
    
    public class FloatingRateProcessingDetailsValidator : AbstractValidator<FloatingRateProcessingDetails>
    {
    
        public FloatingRateProcessingDetailsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FloatingRateProcessingDetails obj)
        {
            yield return CheckCardinality(Name, "ProcessingParameters", obj.ProcessingParameters != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FloatingRateProcessingDetailsOnlyExistsValidator : AbstractOnlyExistsValidator<FloatingRateProcessingDetails> {
    
        protected override IDictionary<string, bool> GetFields(FloatingRateProcessingDetails obj)
        {
            return new Dictionary<string, bool>()
            {
                { "RawRate", IsSet(obj.RawRate!) },
                { "ProcessingParameters", IsSet(obj.ProcessingParameters!) },
                { "ProcessedRate", IsSet(obj.ProcessedRate!) },
                { "SpreadExclusiveRate", IsSet(obj.SpreadExclusiveRate!) }
            };
        }
    }
    
    public class FloatingRateProcessingParametersValidator : AbstractValidator<FloatingRateProcessingParameters>
    {
    
        public FloatingRateProcessingParametersValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FloatingRateProcessingParameters obj)
        {
            yield return CheckCardinality(Name, "InitialRate", obj.InitialRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Multiplier", obj.Multiplier != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Spread", obj.Spread != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Treatment", obj.Treatment != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CapRate", obj.CapRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FloorRate", obj.FloorRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Rounding", obj.Rounding != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NegativeTreatment", obj.NegativeTreatment != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FloatingRateProcessingParametersOnlyExistsValidator : AbstractOnlyExistsValidator<FloatingRateProcessingParameters> {
    
        protected override IDictionary<string, bool> GetFields(FloatingRateProcessingParameters obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InitialRate", IsSet(obj.InitialRate!) },
                { "Multiplier", IsSet(obj.Multiplier!) },
                { "Spread", IsSet(obj.Spread!) },
                { "Treatment", IsSet(obj.Treatment!) },
                { "CapRate", IsSet(obj.CapRate!) },
                { "FloorRate", IsSet(obj.FloorRate!) },
                { "Rounding", IsSet(obj.Rounding!) },
                { "NegativeTreatment", IsSet(obj.NegativeTreatment!) }
            };
        }
    }
    
    public class FloatingRateSettingDetailsValidator : AbstractValidator<FloatingRateSettingDetails>
    {
    
        public FloatingRateSettingDetailsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FloatingRateSettingDetails obj)
        {
            yield return CheckCardinality(Name, "CalculationDetails", obj.CalculationDetails != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ObservationDate", obj.ObservationDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ResetDate", obj.ResetDate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FloatingRateSettingDetailsOnlyExistsValidator : AbstractOnlyExistsValidator<FloatingRateSettingDetails> {
    
        protected override IDictionary<string, bool> GetFields(FloatingRateSettingDetails obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CalculationDetails", IsSet(obj.CalculationDetails!) },
                { "ObservationDate", IsSet(obj.ObservationDate!) },
                { "ResetDate", IsSet(obj.ResetDate!) },
                { "FloatingRate", IsSet(obj.FloatingRate!) }
            };
        }
    }
    
    public class FloatingRateSpecificationValidator : AbstractValidator<FloatingRateSpecification>
    {
    
        public FloatingRateSpecificationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FloatingRateSpecification obj)
        {
            yield return CheckCardinality(Name, "InitialRate", obj.InitialRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FinalRateRounding", obj.FinalRateRounding != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AveragingMethod", obj.AveragingMethod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NegativeInterestRateTreatment", obj.NegativeInterestRateTreatment != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FloatingRateSpecificationOnlyExistsValidator : AbstractOnlyExistsValidator<FloatingRateSpecification> {
    
        protected override IDictionary<string, bool> GetFields(FloatingRateSpecification obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InitialRate", IsSet(obj.InitialRate!) },
                { "FinalRateRounding", IsSet(obj.FinalRateRounding!) },
                { "AveragingMethod", IsSet(obj.AveragingMethod!) },
                { "NegativeInterestRateTreatment", IsSet(obj.NegativeInterestRateTreatment!) }
            };
        }
    }
    
    public class ForeignExchangeValidator : AbstractValidator<ForeignExchange>
    {
    
        public ForeignExchangeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ForeignExchange obj)
        {
            yield return CheckCardinality(Name, "TenorPeriod", obj.TenorPeriod != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ForeignExchangeOnlyExistsValidator : AbstractOnlyExistsValidator<ForeignExchange> {
    
        protected override IDictionary<string, bool> GetFields(ForeignExchange obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ExchangedCurrency1", IsSet(obj.ExchangedCurrency1!) },
                { "ExchangedCurrency2", IsSet(obj.ExchangedCurrency2!) },
                { "TenorPeriod", IsSet(obj.TenorPeriod!) }
            };
        }
    }
    
    public class ForeignExchangeRateIndexValidator : AbstractValidator<ForeignExchangeRateIndex>
    {
    
        public ForeignExchangeRateIndexValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ForeignExchangeRateIndex obj)
        {
            yield return CheckCardinality(Name, "SecondaryFxSpotRateSource", obj.SecondaryFxSpotRateSource != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ForeignExchangeRateIndexOnlyExistsValidator : AbstractOnlyExistsValidator<ForeignExchangeRateIndex> {
    
        protected override IDictionary<string, bool> GetFields(ForeignExchangeRateIndex obj)
        {
            return new Dictionary<string, bool>()
            {
                { "QuotedCurrencyPair", IsSet(obj.QuotedCurrencyPair!) },
                { "PrimaryFxSpotRateSource", IsSet(obj.PrimaryFxSpotRateSource!) },
                { "SecondaryFxSpotRateSource", IsSet(obj.SecondaryFxSpotRateSource!) }
            };
        }
    }
    
    public class FrequencyValidator : AbstractValidator<Frequency>
    {
    
        public FrequencyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Frequency obj)
        {
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FrequencyOnlyExistsValidator : AbstractOnlyExistsValidator<Frequency> {
    
        protected override IDictionary<string, bool> GetFields(Frequency obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PeriodMultiplier", IsSet(obj.PeriodMultiplier!) },
                { "Period", IsSet(obj.Period!) }
            };
        }
    }
    
    public class FutureValueAmountValidator : AbstractValidator<FutureValueAmount>
    {
    
        public FutureValueAmountValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FutureValueAmount obj)
        {
            yield return CheckCardinality(Name, "Quantity", obj.Quantity?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FutureValueAmountOnlyExistsValidator : AbstractOnlyExistsValidator<FutureValueAmount> {
    
        protected override IDictionary<string, bool> GetFields(FutureValueAmount obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Quantity", IsSet(obj.Quantity!) },
                { "Currency", IsSet(obj.Currency!) },
                { "CalculationPeriodNumberOfDays", IsSet(obj.CalculationPeriodNumberOfDays!) },
                { "ValueDate", IsSet(obj.ValueDate!) }
            };
        }
    }
    
    public class FxAdditionalTermsValidator : AbstractValidator<FxAdditionalTerms>
    {
    
        public FxAdditionalTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FxAdditionalTerms obj)
        {
            yield break;
        }
    }
    
    public class FxAdditionalTermsOnlyExistsValidator : AbstractOnlyExistsValidator<FxAdditionalTerms> {
    
        protected override IDictionary<string, bool> GetFields(FxAdditionalTerms obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class FxFeatureValidator : AbstractValidator<FxFeature>
    {
    
        public FxFeatureValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FxFeature obj)
        {
            yield return CheckCardinality(Name, "Composite", obj.Composite != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Quanto", obj.Quanto != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CrossCurrency", obj.CrossCurrency != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FxFeatureOnlyExistsValidator : AbstractOnlyExistsValidator<FxFeature> {
    
        protected override IDictionary<string, bool> GetFields(FxFeature obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ReferenceCurrency", IsSet(obj.ReferenceCurrency!) },
                { "Composite", IsSet(obj.Composite!) },
                { "Quanto", IsSet(obj.Quanto!) },
                { "CrossCurrency", IsSet(obj.CrossCurrency!) }
            };
        }
    }
    
    public class FxFixingDateValidator : AbstractValidator<FxFixingDate>
    {
    
        public FxFixingDateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FxFixingDate obj)
        {
            yield return CheckCardinality(Name, "BusinessDayConvention", obj.BusinessDayConvention != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BusinessCenters", obj.BusinessCenters != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BusinessCentersReference", obj.BusinessCentersReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DateRelativeToPaymentDates", obj.DateRelativeToPaymentDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DateRelativeToCalculationPeriodDates", obj.DateRelativeToCalculationPeriodDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DateRelativeToValuationDates", obj.DateRelativeToValuationDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FxFixingDateValue", obj.FxFixingDateValue != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FxFixingDateOnlyExistsValidator : AbstractOnlyExistsValidator<FxFixingDate> {
    
        protected override IDictionary<string, bool> GetFields(FxFixingDate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "BusinessDayConvention", IsSet(obj.BusinessDayConvention!) },
                { "BusinessCenters", IsSet(obj.BusinessCenters!) },
                { "BusinessCentersReference", IsSet(obj.BusinessCentersReference!) },
                { "DateRelativeToPaymentDates", IsSet(obj.DateRelativeToPaymentDates!) },
                { "DateRelativeToCalculationPeriodDates", IsSet(obj.DateRelativeToCalculationPeriodDates!) },
                { "DateRelativeToValuationDates", IsSet(obj.DateRelativeToValuationDates!) },
                { "FxFixingDateValue", IsSet(obj.FxFixingDateValue!) }
            };
        }
    }
    
    public class FxInformationSourceValidator : AbstractValidator<FxInformationSource>
    {
    
        public FxInformationSourceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FxInformationSource obj)
        {
            yield return CheckCardinality(Name, "FixingTime", obj.FixingTime != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FxInformationSourceOnlyExistsValidator : AbstractOnlyExistsValidator<FxInformationSource> {
    
        protected override IDictionary<string, bool> GetFields(FxInformationSource obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FixingTime", IsSet(obj.FixingTime!) }
            };
        }
    }
    
    public class FxLinkedNotionalAmountValidator : AbstractValidator<FxLinkedNotionalAmount>
    {
    
        public FxLinkedNotionalAmountValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FxLinkedNotionalAmount obj)
        {
            yield return CheckCardinality(Name, "ResetDate", obj.ResetDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdjustedFxSpotFixingDate", obj.AdjustedFxSpotFixingDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ObservedFxSpotRate", obj.ObservedFxSpotRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NotionalAmount", obj.NotionalAmount != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FxLinkedNotionalAmountOnlyExistsValidator : AbstractOnlyExistsValidator<FxLinkedNotionalAmount> {
    
        protected override IDictionary<string, bool> GetFields(FxLinkedNotionalAmount obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ResetDate", IsSet(obj.ResetDate!) },
                { "AdjustedFxSpotFixingDate", IsSet(obj.AdjustedFxSpotFixingDate!) },
                { "ObservedFxSpotRate", IsSet(obj.ObservedFxSpotRate!) },
                { "NotionalAmount", IsSet(obj.NotionalAmount!) }
            };
        }
    }
    
    public class FxLinkedNotionalScheduleValidator : AbstractValidator<FxLinkedNotionalSchedule>
    {
    
        public FxLinkedNotionalScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FxLinkedNotionalSchedule obj)
        {
            yield return CheckCardinality(Name, "FixingTime", obj.FixingTime != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FxLinkedNotionalScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<FxLinkedNotionalSchedule> {
    
        protected override IDictionary<string, bool> GetFields(FxLinkedNotionalSchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "VaryingNotionalCurrency", IsSet(obj.VaryingNotionalCurrency!) },
                { "VaryingNotionalFixingDates", IsSet(obj.VaryingNotionalFixingDates!) },
                { "FxSpotRateSource", IsSet(obj.FxSpotRateSource!) },
                { "FixingTime", IsSet(obj.FixingTime!) },
                { "VaryingNotionalInterimExchangePaymentDates", IsSet(obj.VaryingNotionalInterimExchangePaymentDates!) }
            };
        }
    }
    
    public class FxRateValidator : AbstractValidator<FxRate>
    {
    
        public FxRateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FxRate obj)
        {
            yield return CheckCardinality(Name, "Rate", obj.Rate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FxRateOnlyExistsValidator : AbstractOnlyExistsValidator<FxRate> {
    
        protected override IDictionary<string, bool> GetFields(FxRate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "QuotedCurrencyPair", IsSet(obj.QuotedCurrencyPair!) },
                { "Rate", IsSet(obj.Rate!) }
            };
        }
    }
    
    public class FxRateSourceFixingValidator : AbstractValidator<FxRateSourceFixing>
    {
    
        public FxRateSourceFixingValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FxRateSourceFixing obj)
        {
            yield break;
        }
    }
    
    public class FxRateSourceFixingOnlyExistsValidator : AbstractOnlyExistsValidator<FxRateSourceFixing> {
    
        protected override IDictionary<string, bool> GetFields(FxRateSourceFixing obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SettlementRateSource", IsSet(obj.SettlementRateSource!) },
                { "FixingDate", IsSet(obj.FixingDate!) }
            };
        }
    }
    
    public class FxSettlementRateSourceValidator : AbstractValidator<FxSettlementRateSource>
    {
    
        public FxSettlementRateSourceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FxSettlementRateSource obj)
        {
            yield return CheckCardinality(Name, "SettlementRateOption", obj.SettlementRateOption?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NonstandardSettlementRate", obj.NonstandardSettlementRate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FxSettlementRateSourceOnlyExistsValidator : AbstractOnlyExistsValidator<FxSettlementRateSource> {
    
        protected override IDictionary<string, bool> GetFields(FxSettlementRateSource obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SettlementRateOption", IsSet(obj.SettlementRateOption!) },
                { "NonstandardSettlementRate", IsSet(obj.NonstandardSettlementRate!) }
            };
        }
    }
    
    public class FxSpotRateSourceValidator : AbstractValidator<FxSpotRateSource>
    {
    
        public FxSpotRateSourceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(FxSpotRateSource obj)
        {
            yield return CheckCardinality(Name, "SecondarySource", obj.SecondarySource != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class FxSpotRateSourceOnlyExistsValidator : AbstractOnlyExistsValidator<FxSpotRateSource> {
    
        protected override IDictionary<string, bool> GetFields(FxSpotRateSource obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PrimarySource", IsSet(obj.PrimarySource!) },
                { "SecondarySource", IsSet(obj.SecondarySource!) }
            };
        }
    }
    
    public class GeneralTermsValidator : AbstractValidator<GeneralTerms>
    {
    
        public GeneralTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(GeneralTerms obj)
        {
            yield return CheckCardinality(Name, "ReferenceInformation", obj.ReferenceInformation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IndexReferenceInformation", obj.IndexReferenceInformation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BasketReferenceInformation", obj.BasketReferenceInformation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdditionalTerm", obj.AdditionalTerm.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Substitution", obj.Substitution != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ModifiedEquityDelivery", obj.ModifiedEquityDelivery != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class GeneralTermsOnlyExistsValidator : AbstractOnlyExistsValidator<GeneralTerms> {
    
        protected override IDictionary<string, bool> GetFields(GeneralTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ReferenceInformation", IsSet(obj.ReferenceInformation!) },
                { "IndexReferenceInformation", IsSet(obj.IndexReferenceInformation!) },
                { "BasketReferenceInformation", IsSet(obj.BasketReferenceInformation!) },
                { "AdditionalTerm", IsSet(obj.AdditionalTerm!) },
                { "Substitution", IsSet(obj.Substitution!) },
                { "ModifiedEquityDelivery", IsSet(obj.ModifiedEquityDelivery!) }
            };
        }
    }
    
    public class GracePeriodExtensionValidator : AbstractValidator<GracePeriodExtension>
    {
    
        public GracePeriodExtensionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(GracePeriodExtension obj)
        {
            yield return CheckCardinality(Name, "GracePeriod", obj.GracePeriod != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class GracePeriodExtensionOnlyExistsValidator : AbstractOnlyExistsValidator<GracePeriodExtension> {
    
        protected override IDictionary<string, bool> GetFields(GracePeriodExtension obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Applicable", IsSet(obj.Applicable!) },
                { "GracePeriod", IsSet(obj.GracePeriod!) }
            };
        }
    }
    
    public class IdValidator : AbstractValidator<Id>
    {
    
        public IdValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Id obj)
        {
            yield break;
        }
    }
    
    public class IdOnlyExistsValidator : AbstractOnlyExistsValidator<Id> {
    
        protected override IDictionary<string, bool> GetFields(Id obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Lei", IsSet(obj.Lei!) }
            };
        }
    }
    
    public class IdentifiedListValidator : AbstractValidator<IdentifiedList>
    {
    
        public IdentifiedListValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(IdentifiedList obj)
        {
            yield return CheckCardinality(Name, "ComponentId", obj.ComponentId.EmptyIfNull().Count(), 2, 0);
            yield return CheckCardinality(Name, "Price", obj.Price != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class IdentifiedListOnlyExistsValidator : AbstractOnlyExistsValidator<IdentifiedList> {
    
        protected override IDictionary<string, bool> GetFields(IdentifiedList obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ListId", IsSet(obj.ListId!) },
                { "ComponentId", IsSet(obj.ComponentId!) },
                { "Price", IsSet(obj.Price!) }
            };
        }
    }
    
    public class IdentifierValidator : AbstractValidator<Identifier>
    {
    
        public IdentifierValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Identifier obj)
        {
            yield return CheckCardinality(Name, "IssuerReference", obj.IssuerReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Issuer", obj.Issuer?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AssignedIdentifier", obj.AssignedIdentifier.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class IdentifierOnlyExistsValidator : AbstractOnlyExistsValidator<Identifier> {
    
        protected override IDictionary<string, bool> GetFields(Identifier obj)
        {
            return new Dictionary<string, bool>()
            {
                { "IssuerReference", IsSet(obj.IssuerReference!) },
                { "Issuer", IsSet(obj.Issuer!) },
                { "AssignedIdentifier", IsSet(obj.AssignedIdentifier!) }
            };
        }
    }
    
    public class IndependentAmountValidator : AbstractValidator<IndependentAmount>
    {
    
        public IndependentAmountValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(IndependentAmount obj)
        {
            yield return CheckCardinality(Name, "PaymentDetail", obj.PaymentDetail.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class IndependentAmountOnlyExistsValidator : AbstractOnlyExistsValidator<IndependentAmount> {
    
        protected override IDictionary<string, bool> GetFields(IndependentAmount obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PaymentDetail", IsSet(obj.PaymentDetail!) }
            };
        }
    }
    
    public class IndexValidator : AbstractValidator<Index>
    {
    
        public IndexValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Index obj)
        {
            yield return CheckCardinality(Name, "CreditIndex", obj.CreditIndex != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EquityIndex", obj.EquityIndex != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InterestRateIndex", obj.InterestRateIndex?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ForeignExchangeRateIndex", obj.ForeignExchangeRateIndex != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "OtherIndex", obj.OtherIndex != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class IndexOnlyExistsValidator : AbstractOnlyExistsValidator<Index> {
    
        protected override IDictionary<string, bool> GetFields(Index obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CreditIndex", IsSet(obj.CreditIndex!) },
                { "EquityIndex", IsSet(obj.EquityIndex!) },
                { "InterestRateIndex", IsSet(obj.InterestRateIndex!) },
                { "ForeignExchangeRateIndex", IsSet(obj.ForeignExchangeRateIndex!) },
                { "OtherIndex", IsSet(obj.OtherIndex!) }
            };
        }
    }
    
    public class IndexAdjustmentEventsValidator : AbstractValidator<IndexAdjustmentEvents>
    {
    
        public IndexAdjustmentEventsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(IndexAdjustmentEvents obj)
        {
            yield break;
        }
    }
    
    public class IndexAdjustmentEventsOnlyExistsValidator : AbstractOnlyExistsValidator<IndexAdjustmentEvents> {
    
        protected override IDictionary<string, bool> GetFields(IndexAdjustmentEvents obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class IndexBaseValidator : AbstractValidator<IndexBase>
    {
    
        public IndexBaseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(IndexBase obj)
        {
            yield return CheckCardinality(Name, "Name", obj.Name?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Provider", obj.Provider != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AssetClass", obj.AssetClass != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class IndexBaseOnlyExistsValidator : AbstractOnlyExistsValidator<IndexBase> {
    
        protected override IDictionary<string, bool> GetFields(IndexBase obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Name", IsSet(obj.Name!) },
                { "Provider", IsSet(obj.Provider!) },
                { "AssetClass", IsSet(obj.AssetClass!) }
            };
        }
    }
    
    public class IndexTransitionInstructionValidator : AbstractValidator<IndexTransitionInstruction>
    {
    
        public IndexTransitionInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(IndexTransitionInstruction obj)
        {
            yield return CheckCardinality(Name, "PriceQuantity", obj.PriceQuantity.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "CashTransfer", obj.CashTransfer != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class IndexTransitionInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<IndexTransitionInstruction> {
    
        protected override IDictionary<string, bool> GetFields(IndexTransitionInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PriceQuantity", IsSet(obj.PriceQuantity!) },
                { "EffectiveDate", IsSet(obj.EffectiveDate!) },
                { "CashTransfer", IsSet(obj.CashTransfer!) }
            };
        }
    }
    
    public class IndxValidator : AbstractValidator<Indx>
    {
    
        public IndxValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Indx obj)
        {
            yield break;
        }
    }
    
    public class IndxOnlyExistsValidator : AbstractOnlyExistsValidator<Indx> {
    
        protected override IDictionary<string, bool> GetFields(Indx obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Nm", IsSet(obj.Nm!) }
            };
        }
    }
    
    public class InflationIndexValidator : AbstractValidator<InflationIndex>
    {
    
        public InflationIndexValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(InflationIndex obj)
        {
            yield return CheckCardinality(Name, "IndexTenor", obj.IndexTenor != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class InflationIndexOnlyExistsValidator : AbstractOnlyExistsValidator<InflationIndex> {
    
        protected override IDictionary<string, bool> GetFields(InflationIndex obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InflationRateIndex", IsSet(obj.InflationRateIndex!) },
                { "IndexTenor", IsSet(obj.IndexTenor!) }
            };
        }
    }
    
    public class InflationRateSpecificationValidator : AbstractValidator<InflationRateSpecification>
    {
    
        public InflationRateSpecificationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(InflationRateSpecification obj)
        {
            yield return CheckCardinality(Name, "InitialIndexLevel", obj.InitialIndexLevel != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationMethod", obj.CalculationMethod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationStyle", obj.CalculationStyle != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FinalPrincipalExchangeCalculation", obj.FinalPrincipalExchangeCalculation != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class InflationRateSpecificationOnlyExistsValidator : AbstractOnlyExistsValidator<InflationRateSpecification> {
    
        protected override IDictionary<string, bool> GetFields(InflationRateSpecification obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InflationLag", IsSet(obj.InflationLag!) },
                { "IndexSource", IsSet(obj.IndexSource!) },
                { "MainPublication", IsSet(obj.MainPublication!) },
                { "InterpolationMethod", IsSet(obj.InterpolationMethod!) },
                { "InitialIndexLevel", IsSet(obj.InitialIndexLevel!) },
                { "FallbackBondApplicable", IsSet(obj.FallbackBondApplicable!) },
                { "CalculationMethod", IsSet(obj.CalculationMethod!) },
                { "CalculationStyle", IsSet(obj.CalculationStyle!) },
                { "FinalPrincipalExchangeCalculation", IsSet(obj.FinalPrincipalExchangeCalculation!) }
            };
        }
    }
    
    public class InformationSourceValidator : AbstractValidator<InformationSource>
    {
    
        public InformationSourceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(InformationSource obj)
        {
            yield return CheckCardinality(Name, "SourcePage", obj.SourcePage?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SourcePageHeading", obj.SourcePageHeading != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class InformationSourceOnlyExistsValidator : AbstractOnlyExistsValidator<InformationSource> {
    
        protected override IDictionary<string, bool> GetFields(InformationSource obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SourceProvider", IsSet(obj.SourceProvider!) },
                { "SourcePage", IsSet(obj.SourcePage!) },
                { "SourcePageHeading", IsSet(obj.SourcePageHeading!) }
            };
        }
    }
    
    public class InitialFixingDateValidator : AbstractValidator<InitialFixingDate>
    {
    
        public InitialFixingDateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(InitialFixingDate obj)
        {
            yield return CheckCardinality(Name, "RelativeDateOffset", obj.RelativeDateOffset != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InitialFixingDateValue", obj.InitialFixingDateValue != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class InitialFixingDateOnlyExistsValidator : AbstractOnlyExistsValidator<InitialFixingDate> {
    
        protected override IDictionary<string, bool> GetFields(InitialFixingDate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "RelativeDateOffset", IsSet(obj.RelativeDateOffset!) },
                { "InitialFixingDateValue", IsSet(obj.InitialFixingDateValue!) }
            };
        }
    }
    
    public class InstructionValidator : AbstractValidator<Instruction>
    {
    
        public InstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Instruction obj)
        {
            yield return CheckCardinality(Name, "PrimitiveInstruction", obj.PrimitiveInstruction != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Before", obj.Before?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class InstructionOnlyExistsValidator : AbstractOnlyExistsValidator<Instruction> {
    
        protected override IDictionary<string, bool> GetFields(Instruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PrimitiveInstruction", IsSet(obj.PrimitiveInstruction!) },
                { "Before", IsSet(obj.Before!) }
            };
        }
    }
    
    public class InstrumentValidator : AbstractValidator<Instrument>
    {
    
        public InstrumentValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Instrument obj)
        {
            yield return CheckCardinality(Name, "ListedDerivative", obj.ListedDerivative != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Loan", obj.Loan != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Security", obj.Security != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class InstrumentOnlyExistsValidator : AbstractOnlyExistsValidator<Instrument> {
    
        protected override IDictionary<string, bool> GetFields(Instrument obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ListedDerivative", IsSet(obj.ListedDerivative!) },
                { "Loan", IsSet(obj.Loan!) },
                { "Security", IsSet(obj.Security!) }
            };
        }
    }
    
    public class InstrumentBaseValidator : AbstractValidator<InstrumentBase>
    {
    
        public InstrumentBaseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(InstrumentBase obj)
        {
            yield break;
        }
    }
    
    public class InstrumentBaseOnlyExistsValidator : AbstractOnlyExistsValidator<InstrumentBase> {
    
        protected override IDictionary<string, bool> GetFields(InstrumentBase obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InstrumentType", IsSet(obj.InstrumentType!) }
            };
        }
    }
    
    public class InterestAmountApplicationValidator : AbstractValidator<InterestAmountApplication>
    {
    
        public InterestAmountApplicationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(InterestAmountApplication obj)
        {
            yield break;
        }
    }
    
    public class InterestAmountApplicationOnlyExistsValidator : AbstractOnlyExistsValidator<InterestAmountApplication> {
    
        protected override IDictionary<string, bool> GetFields(InterestAmountApplication obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ReturnAmount", IsSet(obj.ReturnAmount!) },
                { "DeliveryAmount", IsSet(obj.DeliveryAmount!) }
            };
        }
    }
    
    public class InterestRateCurveValidator : AbstractValidator<InterestRateCurve>
    {
    
        public InterestRateCurveValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(InterestRateCurve obj)
        {
            yield break;
        }
    }
    
    public class InterestRateCurveOnlyExistsValidator : AbstractOnlyExistsValidator<InterestRateCurve> {
    
        protected override IDictionary<string, bool> GetFields(InterestRateCurve obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FloatingRateIndex", IsSet(obj.FloatingRateIndex!) },
                { "Tenor", IsSet(obj.Tenor!) }
            };
        }
    }
    
    public class InterestRateIndexValidator : AbstractValidator<InterestRateIndex>
    {
    
        public InterestRateIndexValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(InterestRateIndex obj)
        {
            yield return CheckCardinality(Name, "FloatingRateIndex", obj.FloatingRateIndex != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InflationIndex", obj.InflationIndex != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class InterestRateIndexOnlyExistsValidator : AbstractOnlyExistsValidator<InterestRateIndex> {
    
        protected override IDictionary<string, bool> GetFields(InterestRateIndex obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FloatingRateIndex", IsSet(obj.FloatingRateIndex!) },
                { "InflationIndex", IsSet(obj.InflationIndex!) }
            };
        }
    }
    
    public class InterestRatePayoutValidator : AbstractValidator<InterestRatePayout>
    {
    
        public InterestRatePayoutValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(InterestRatePayout obj)
        {
            yield return CheckCardinality(Name, "RateSpecification", obj.RateSpecification != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DayCountFraction", obj.DayCountFraction?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationPeriodDates", obj.CalculationPeriodDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PaymentDates", obj.PaymentDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PaymentDate", obj.PaymentDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PaymentDelay", obj.PaymentDelay != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ResetDates", obj.ResetDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DiscountingMethod", obj.DiscountingMethod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CompoundingMethod", obj.CompoundingMethod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CashflowRepresentation", obj.CashflowRepresentation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "StubPeriod", obj.StubPeriod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BondReference", obj.BondReference != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FixedAmount", obj.FixedAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FloatingAmount", obj.FloatingAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SpreadCalculationMethod", obj.SpreadCalculationMethod != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class InterestRatePayoutOnlyExistsValidator : AbstractOnlyExistsValidator<InterestRatePayout> {
    
        protected override IDictionary<string, bool> GetFields(InterestRatePayout obj)
        {
            return new Dictionary<string, bool>()
            {
                { "RateSpecification", IsSet(obj.RateSpecification!) },
                { "DayCountFraction", IsSet(obj.DayCountFraction!) },
                { "CalculationPeriodDates", IsSet(obj.CalculationPeriodDates!) },
                { "PaymentDates", IsSet(obj.PaymentDates!) },
                { "PaymentDate", IsSet(obj.PaymentDate!) },
                { "PaymentDelay", IsSet(obj.PaymentDelay!) },
                { "ResetDates", IsSet(obj.ResetDates!) },
                { "DiscountingMethod", IsSet(obj.DiscountingMethod!) },
                { "CompoundingMethod", IsSet(obj.CompoundingMethod!) },
                { "CashflowRepresentation", IsSet(obj.CashflowRepresentation!) },
                { "StubPeriod", IsSet(obj.StubPeriod!) },
                { "BondReference", IsSet(obj.BondReference!) },
                { "FixedAmount", IsSet(obj.FixedAmount!) },
                { "FloatingAmount", IsSet(obj.FloatingAmount!) },
                { "SpreadCalculationMethod", IsSet(obj.SpreadCalculationMethod!) }
            };
        }
    }
    
    public class InterestShortFallValidator : AbstractValidator<InterestShortFall>
    {
    
        public InterestShortFallValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(InterestShortFall obj)
        {
            yield return CheckCardinality(Name, "RateSource", obj.RateSource?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class InterestShortFallOnlyExistsValidator : AbstractOnlyExistsValidator<InterestShortFall> {
    
        protected override IDictionary<string, bool> GetFields(InterestShortFall obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InterestShortfallCap", IsSet(obj.InterestShortfallCap!) },
                { "Compounding", IsSet(obj.Compounding!) },
                { "RateSource", IsSet(obj.RateSource!) }
            };
        }
    }
    
    public class InventoryValidator : AbstractValidator<Inventory>
    {
    
        public InventoryValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Inventory obj)
        {
            yield return CheckCardinality(Name, "InventoryRecord", obj.InventoryRecord.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class InventoryOnlyExistsValidator : AbstractOnlyExistsValidator<Inventory> {
    
        protected override IDictionary<string, bool> GetFields(Inventory obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InventoryRecord", IsSet(obj.InventoryRecord!) }
            };
        }
    }
    
    public class InventoryRecordValidator : AbstractValidator<InventoryRecord>
    {
    
        public InventoryRecordValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(InventoryRecord obj)
        {
            yield break;
        }
    }
    
    public class InventoryRecordOnlyExistsValidator : AbstractOnlyExistsValidator<InventoryRecord> {
    
        protected override IDictionary<string, bool> GetFields(InventoryRecord obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Identifer", IsSet(obj.Identifer!) },
                { "Security", IsSet(obj.Security!) }
            };
        }
    }
    
    public class InvstmtDcsnPrsnValidator : AbstractValidator<InvstmtDcsnPrsn>
    {
    
        public InvstmtDcsnPrsnValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(InvstmtDcsnPrsn obj)
        {
            yield break;
        }
    }
    
    public class InvstmtDcsnPrsnOnlyExistsValidator : AbstractOnlyExistsValidator<InvstmtDcsnPrsn> {
    
        protected override IDictionary<string, bool> GetFields(InvstmtDcsnPrsn obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Prsn", IsSet(obj.Prsn!) }
            };
        }
    }
    
    public class IssuerAgencyRatingValidator : AbstractValidator<IssuerAgencyRating>
    {
    
        public IssuerAgencyRatingValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(IssuerAgencyRating obj)
        {
            yield break;
        }
    }
    
    public class IssuerAgencyRatingOnlyExistsValidator : AbstractOnlyExistsValidator<IssuerAgencyRating> {
    
        protected override IDictionary<string, bool> GetFields(IssuerAgencyRating obj)
        {
            return new Dictionary<string, bool>()
            {
                { "IssuerAgencyRatingValue", IsSet(obj.IssuerAgencyRatingValue!) }
            };
        }
    }
    
    public class IssuerCountryOfOriginValidator : AbstractValidator<IssuerCountryOfOrigin>
    {
    
        public IssuerCountryOfOriginValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(IssuerCountryOfOrigin obj)
        {
            yield break;
        }
    }
    
    public class IssuerCountryOfOriginOnlyExistsValidator : AbstractOnlyExistsValidator<IssuerCountryOfOrigin> {
    
        protected override IDictionary<string, bool> GetFields(IssuerCountryOfOrigin obj)
        {
            return new Dictionary<string, bool>()
            {
                { "IssuerCountryOfOriginValue", IsSet(obj.IssuerCountryOfOriginValue!) }
            };
        }
    }
    
    public class IssuerNameValidator : AbstractValidator<IssuerName>
    {
    
        public IssuerNameValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(IssuerName obj)
        {
            yield break;
        }
    }
    
    public class IssuerNameOnlyExistsValidator : AbstractOnlyExistsValidator<IssuerName> {
    
        protected override IDictionary<string, bool> GetFields(IssuerName obj)
        {
            return new Dictionary<string, bool>()
            {
                { "IssuerNameValue", IsSet(obj.IssuerNameValue!) }
            };
        }
    }
    
    public class KnockValidator : AbstractValidator<Knock>
    {
    
        public KnockValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Knock obj)
        {
            yield return CheckCardinality(Name, "KnockIn", obj.KnockIn != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "KnockOut", obj.KnockOut != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class KnockOnlyExistsValidator : AbstractOnlyExistsValidator<Knock> {
    
        protected override IDictionary<string, bool> GetFields(Knock obj)
        {
            return new Dictionary<string, bool>()
            {
                { "KnockIn", IsSet(obj.KnockIn!) },
                { "KnockOut", IsSet(obj.KnockOut!) }
            };
        }
    }
    
    public class LagValidator : AbstractValidator<Lag>
    {
    
        public LagValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Lag obj)
        {
            yield return CheckCardinality(Name, "FirstObservationDateOffset", obj.FirstObservationDateOffset != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class LagOnlyExistsValidator : AbstractOnlyExistsValidator<Lag> {
    
        protected override IDictionary<string, bool> GetFields(Lag obj)
        {
            return new Dictionary<string, bool>()
            {
                { "LagDuration", IsSet(obj.LagDuration!) },
                { "FirstObservationDateOffset", IsSet(obj.FirstObservationDateOffset!) }
            };
        }
    }
    
    public class LegalAgreementValidator : AbstractValidator<LegalAgreement>
    {
    
        public LegalAgreementValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(LegalAgreement obj)
        {
            yield return CheckCardinality(Name, "AgreementTerms", obj.AgreementTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RelatedAgreements", obj.RelatedAgreements.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "UmbrellaAgreement", obj.UmbrellaAgreement != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class LegalAgreementOnlyExistsValidator : AbstractOnlyExistsValidator<LegalAgreement> {
    
        protected override IDictionary<string, bool> GetFields(LegalAgreement obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AgreementTerms", IsSet(obj.AgreementTerms!) },
                { "RelatedAgreements", IsSet(obj.RelatedAgreements!) },
                { "UmbrellaAgreement", IsSet(obj.UmbrellaAgreement!) }
            };
        }
    }
    
    public class LegalAgreementBaseValidator : AbstractValidator<LegalAgreementBase>
    {
    
        public LegalAgreementBaseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(LegalAgreementBase obj)
        {
            yield return CheckCardinality(Name, "AgreementDate", obj.AgreementDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EffectiveDate", obj.EffectiveDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Identifier", obj.Identifier.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "ContractualParty", obj.ContractualParty.EmptyIfNull().Count(), 2, 2);
            yield return CheckCardinality(Name, "OtherParty", obj.OtherParty.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Attachment", obj.Attachment.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class LegalAgreementBaseOnlyExistsValidator : AbstractOnlyExistsValidator<LegalAgreementBase> {
    
        protected override IDictionary<string, bool> GetFields(LegalAgreementBase obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AgreementDate", IsSet(obj.AgreementDate!) },
                { "EffectiveDate", IsSet(obj.EffectiveDate!) },
                { "Identifier", IsSet(obj.Identifier!) },
                { "LegalAgreementIdentification", IsSet(obj.LegalAgreementIdentification!) },
                { "ContractualParty", IsSet(obj.ContractualParty!) },
                { "OtherParty", IsSet(obj.OtherParty!) },
                { "Attachment", IsSet(obj.Attachment!) }
            };
        }
    }
    
    public class LegalAgreementIdentificationValidator : AbstractValidator<LegalAgreementIdentification>
    {
    
        public LegalAgreementIdentificationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(LegalAgreementIdentification obj)
        {
            yield return CheckCardinality(Name, "GoverningLaw", obj.GoverningLaw != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Publisher", obj.Publisher != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Vintage", obj.Vintage != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class LegalAgreementIdentificationOnlyExistsValidator : AbstractOnlyExistsValidator<LegalAgreementIdentification> {
    
        protected override IDictionary<string, bool> GetFields(LegalAgreementIdentification obj)
        {
            return new Dictionary<string, bool>()
            {
                { "GoverningLaw", IsSet(obj.GoverningLaw!) },
                { "AgreementName", IsSet(obj.AgreementName!) },
                { "Publisher", IsSet(obj.Publisher!) },
                { "Vintage", IsSet(obj.Vintage!) }
            };
        }
    }
    
    public class LegalEntityValidator : AbstractValidator<LegalEntity>
    {
    
        public LegalEntityValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(LegalEntity obj)
        {
            yield return CheckCardinality(Name, "EntityId", obj.EntityId.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class LegalEntityOnlyExistsValidator : AbstractOnlyExistsValidator<LegalEntity> {
    
        protected override IDictionary<string, bool> GetFields(LegalEntity obj)
        {
            return new Dictionary<string, bool>()
            {
                { "EntityId", IsSet(obj.EntityId!) },
                { "Name", IsSet(obj.Name!) }
            };
        }
    }
    
    public class LimitApplicableValidator : AbstractValidator<LimitApplicable>
    {
    
        public LimitApplicableValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(LimitApplicable obj)
        {
            yield return CheckCardinality(Name, "LimitType", obj.LimitType?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ClipSize", obj.ClipSize != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AmountUtilized", obj.AmountUtilized != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Utilization", obj.Utilization != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AmountRemaining", obj.AmountRemaining != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Currency", obj.Currency?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Velocity", obj.Velocity != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class LimitApplicableOnlyExistsValidator : AbstractOnlyExistsValidator<LimitApplicable> {
    
        protected override IDictionary<string, bool> GetFields(LimitApplicable obj)
        {
            return new Dictionary<string, bool>()
            {
                { "LimitType", IsSet(obj.LimitType!) },
                { "ClipSize", IsSet(obj.ClipSize!) },
                { "AmountUtilized", IsSet(obj.AmountUtilized!) },
                { "Utilization", IsSet(obj.Utilization!) },
                { "AmountRemaining", IsSet(obj.AmountRemaining!) },
                { "Currency", IsSet(obj.Currency!) },
                { "Velocity", IsSet(obj.Velocity!) }
            };
        }
    }
    
    public class LimitApplicableExtendedValidator : AbstractValidator<LimitApplicableExtended>
    {
    
        public LimitApplicableExtendedValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(LimitApplicableExtended obj)
        {
            yield return CheckCardinality(Name, "LimitLevel", obj.LimitLevel?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LimitAmount", obj.LimitAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LimitImpactDueToTrade", obj.LimitImpactDueToTrade != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class LimitApplicableExtendedOnlyExistsValidator : AbstractOnlyExistsValidator<LimitApplicableExtended> {
    
        protected override IDictionary<string, bool> GetFields(LimitApplicableExtended obj)
        {
            return new Dictionary<string, bool>()
            {
                { "LimitLevel", IsSet(obj.LimitLevel!) },
                { "LimitAmount", IsSet(obj.LimitAmount!) },
                { "LimitImpactDueToTrade", IsSet(obj.LimitImpactDueToTrade!) }
            };
        }
    }
    
    public class LineageValidator : AbstractValidator<Lineage>
    {
    
        public LineageValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Lineage obj)
        {
            yield return CheckCardinality(Name, "TradeReference", obj.TradeReference.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "EventReference", obj.EventReference.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "PortfolioStateReference", obj.PortfolioStateReference.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class LineageOnlyExistsValidator : AbstractOnlyExistsValidator<Lineage> {
    
        protected override IDictionary<string, bool> GetFields(Lineage obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TradeReference", IsSet(obj.TradeReference!) },
                { "EventReference", IsSet(obj.EventReference!) },
                { "PortfolioStateReference", IsSet(obj.PortfolioStateReference!) }
            };
        }
    }
    
    public class ListedDerivativeValidator : AbstractValidator<ListedDerivative>
    {
    
        public ListedDerivativeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ListedDerivative obj)
        {
            yield return CheckCardinality(Name, "DeliveryTerm", obj.DeliveryTerm != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "OptionType", obj.OptionType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Strike", obj.Strike != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ListedDerivativeOnlyExistsValidator : AbstractOnlyExistsValidator<ListedDerivative> {
    
        protected override IDictionary<string, bool> GetFields(ListedDerivative obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DeliveryTerm", IsSet(obj.DeliveryTerm!) },
                { "OptionType", IsSet(obj.OptionType!) },
                { "Strike", IsSet(obj.Strike!) }
            };
        }
    }
    
    public class ListingExchangeValidator : AbstractValidator<ListingExchange>
    {
    
        public ListingExchangeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ListingExchange obj)
        {
            yield return CheckCardinality(Name, "Exchange", obj.Exchange.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class ListingExchangeOnlyExistsValidator : AbstractOnlyExistsValidator<ListingExchange> {
    
        protected override IDictionary<string, bool> GetFields(ListingExchange obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Exchange", IsSet(obj.Exchange!) }
            };
        }
    }
    
    public class ListingSectorValidator : AbstractValidator<ListingSector>
    {
    
        public ListingSectorValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ListingSector obj)
        {
            yield return CheckCardinality(Name, "Sector", obj.Sector.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class ListingSectorOnlyExistsValidator : AbstractOnlyExistsValidator<ListingSector> {
    
        protected override IDictionary<string, bool> GetFields(ListingSector obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Sector", IsSet(obj.Sector!) }
            };
        }
    }
    
    public class LoanValidator : AbstractValidator<Loan>
    {
    
        public LoanValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Loan obj)
        {
            yield return CheckCardinality(Name, "Borrower", obj.Borrower.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Lien", obj.Lien?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FacilityType", obj.FacilityType?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CreditAgreementDate", obj.CreditAgreementDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Tranche", obj.Tranche?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class LoanOnlyExistsValidator : AbstractOnlyExistsValidator<Loan> {
    
        protected override IDictionary<string, bool> GetFields(Loan obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Borrower", IsSet(obj.Borrower!) },
                { "Lien", IsSet(obj.Lien!) },
                { "FacilityType", IsSet(obj.FacilityType!) },
                { "CreditAgreementDate", IsSet(obj.CreditAgreementDate!) },
                { "Tranche", IsSet(obj.Tranche!) }
            };
        }
    }
    
    public class LoanParticipationValidator : AbstractValidator<LoanParticipation>
    {
    
        public LoanParticipationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(LoanParticipation obj)
        {
            yield return CheckCardinality(Name, "QualifyingParticipationSeller", obj.QualifyingParticipationSeller != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class LoanParticipationOnlyExistsValidator : AbstractOnlyExistsValidator<LoanParticipation> {
    
        protected override IDictionary<string, bool> GetFields(LoanParticipation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "QualifyingParticipationSeller", IsSet(obj.QualifyingParticipationSeller!) }
            };
        }
    }
    
    public class LocationIdentifierValidator : AbstractValidator<LocationIdentifier>
    {
    
        public LocationIdentifierValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(LocationIdentifier obj)
        {
            yield return CheckCardinality(Name, "LocationIdentifierType", obj.LocationIdentifierType != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class LocationIdentifierOnlyExistsValidator : AbstractOnlyExistsValidator<LocationIdentifier> {
    
        protected override IDictionary<string, bool> GetFields(LocationIdentifier obj)
        {
            return new Dictionary<string, bool>()
            {
                { "LocationIdentifierType", IsSet(obj.LocationIdentifierType!) }
            };
        }
    }
    
    public class MakeWholeAmountValidator : AbstractValidator<MakeWholeAmount>
    {
    
        public MakeWholeAmountValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MakeWholeAmount obj)
        {
            yield return CheckCardinality(Name, "InterpolationMethod", obj.InterpolationMethod != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class MakeWholeAmountOnlyExistsValidator : AbstractOnlyExistsValidator<MakeWholeAmount> {
    
        protected override IDictionary<string, bool> GetFields(MakeWholeAmount obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InterpolationMethod", IsSet(obj.InterpolationMethod!) },
                { "EarlyCallDate", IsSet(obj.EarlyCallDate!) }
            };
        }
    }
    
    public class MandatoryEarlyTerminationValidator : AbstractValidator<MandatoryEarlyTermination>
    {
    
        public MandatoryEarlyTerminationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MandatoryEarlyTermination obj)
        {
            yield return CheckCardinality(Name, "MandatoryEarlyTerminationAdjustedDates", obj.MandatoryEarlyTerminationAdjustedDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class MandatoryEarlyTerminationOnlyExistsValidator : AbstractOnlyExistsValidator<MandatoryEarlyTermination> {
    
        protected override IDictionary<string, bool> GetFields(MandatoryEarlyTermination obj)
        {
            return new Dictionary<string, bool>()
            {
                { "MandatoryEarlyTerminationDate", IsSet(obj.MandatoryEarlyTerminationDate!) },
                { "CalculationAgent", IsSet(obj.CalculationAgent!) },
                { "CashSettlement", IsSet(obj.CashSettlement!) },
                { "MandatoryEarlyTerminationAdjustedDates", IsSet(obj.MandatoryEarlyTerminationAdjustedDates!) }
            };
        }
    }
    
    public class MandatoryEarlyTerminationAdjustedDatesValidator : AbstractValidator<MandatoryEarlyTerminationAdjustedDates>
    {
    
        public MandatoryEarlyTerminationAdjustedDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MandatoryEarlyTerminationAdjustedDates obj)
        {
            yield break;
        }
    }
    
    public class MandatoryEarlyTerminationAdjustedDatesOnlyExistsValidator : AbstractOnlyExistsValidator<MandatoryEarlyTerminationAdjustedDates> {
    
        protected override IDictionary<string, bool> GetFields(MandatoryEarlyTerminationAdjustedDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AdjustedEarlyTerminationDate", IsSet(obj.AdjustedEarlyTerminationDate!) },
                { "AdjustedCashSettlementValuationDate", IsSet(obj.AdjustedCashSettlementValuationDate!) },
                { "AdjustedCashSettlementPaymentDate", IsSet(obj.AdjustedCashSettlementPaymentDate!) }
            };
        }
    }
    
    public class ManualExerciseValidator : AbstractValidator<ManualExercise>
    {
    
        public ManualExerciseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ManualExercise obj)
        {
            yield return CheckCardinality(Name, "ExerciseNotice", obj.ExerciseNotice != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FallbackExercise", obj.FallbackExercise != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ManualExerciseOnlyExistsValidator : AbstractOnlyExistsValidator<ManualExercise> {
    
        protected override IDictionary<string, bool> GetFields(ManualExercise obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ExerciseNotice", IsSet(obj.ExerciseNotice!) },
                { "FallbackExercise", IsSet(obj.FallbackExercise!) }
            };
        }
    }
    
    public class MarginCallBaseValidator : AbstractValidator<MarginCallBase>
    {
    
        public MarginCallBaseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MarginCallBase obj)
        {
            yield return CheckCardinality(Name, "Party", obj.Party.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "PartyRole", obj.PartyRole.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "ClearingBroker", obj.ClearingBroker != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CallIdentifier", obj.CallIdentifier != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AgreementMinimumTransferAmount", obj.AgreementMinimumTransferAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AgreementThreshold", obj.AgreementThreshold != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AgreementRounding", obj.AgreementRounding != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RegIMRole", obj.RegIMRole != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BaseCurrencyExposure", obj.BaseCurrencyExposure != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CollateralPortfolio", obj.CollateralPortfolio?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IndependentAmountBalance", obj.IndependentAmountBalance != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class MarginCallBaseOnlyExistsValidator : AbstractOnlyExistsValidator<MarginCallBase> {
    
        protected override IDictionary<string, bool> GetFields(MarginCallBase obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InstructionType", IsSet(obj.InstructionType!) },
                { "Party", IsSet(obj.Party!) },
                { "PartyRole", IsSet(obj.PartyRole!) },
                { "ClearingBroker", IsSet(obj.ClearingBroker!) },
                { "CallIdentifier", IsSet(obj.CallIdentifier!) },
                { "CallAgreementType", IsSet(obj.CallAgreementType!) },
                { "AgreementMinimumTransferAmount", IsSet(obj.AgreementMinimumTransferAmount!) },
                { "AgreementThreshold", IsSet(obj.AgreementThreshold!) },
                { "AgreementRounding", IsSet(obj.AgreementRounding!) },
                { "RegMarginType", IsSet(obj.RegMarginType!) },
                { "RegIMRole", IsSet(obj.RegIMRole!) },
                { "BaseCurrencyExposure", IsSet(obj.BaseCurrencyExposure!) },
                { "CollateralPortfolio", IsSet(obj.CollateralPortfolio!) },
                { "IndependentAmountBalance", IsSet(obj.IndependentAmountBalance!) }
            };
        }
    }
    
    public class MarginCallExposureValidator : AbstractValidator<MarginCallExposure>
    {
    
        public MarginCallExposureValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MarginCallExposure obj)
        {
            yield return CheckCardinality(Name, "SimmIMExposure", obj.SimmIMExposure != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ScheduleGridIMExposure", obj.ScheduleGridIMExposure != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class MarginCallExposureOnlyExistsValidator : AbstractOnlyExistsValidator<MarginCallExposure> {
    
        protected override IDictionary<string, bool> GetFields(MarginCallExposure obj)
        {
            return new Dictionary<string, bool>()
            {
                { "OverallExposure", IsSet(obj.OverallExposure!) },
                { "SimmIMExposure", IsSet(obj.SimmIMExposure!) },
                { "ScheduleGridIMExposure", IsSet(obj.ScheduleGridIMExposure!) }
            };
        }
    }
    
    public class MarginCallInstructionTypeValidator : AbstractValidator<MarginCallInstructionType>
    {
    
        public MarginCallInstructionTypeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MarginCallInstructionType obj)
        {
            yield return CheckCardinality(Name, "VisibilityIndicator", obj.VisibilityIndicator != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class MarginCallInstructionTypeOnlyExistsValidator : AbstractOnlyExistsValidator<MarginCallInstructionType> {
    
        protected override IDictionary<string, bool> GetFields(MarginCallInstructionType obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CallType", IsSet(obj.CallType!) },
                { "VisibilityIndicator", IsSet(obj.VisibilityIndicator!) }
            };
        }
    }
    
    public class MarginCallIssuanceValidator : AbstractValidator<MarginCallIssuance>
    {
    
        public MarginCallIssuanceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MarginCallIssuance obj)
        {
            yield return CheckCardinality(Name, "RecallNonCashCollateralDescription", obj.RecallNonCashCollateralDescription.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class MarginCallIssuanceOnlyExistsValidator : AbstractOnlyExistsValidator<MarginCallIssuance> {
    
        protected override IDictionary<string, bool> GetFields(MarginCallIssuance obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CallAmountInBaseCurrency", IsSet(obj.CallAmountInBaseCurrency!) },
                { "RecallNonCashCollateralDescription", IsSet(obj.RecallNonCashCollateralDescription!) }
            };
        }
    }
    
    public class MarginCallResponseValidator : AbstractValidator<MarginCallResponse>
    {
    
        public MarginCallResponseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MarginCallResponse obj)
        {
            yield return CheckCardinality(Name, "MarginCallResponseAction", obj.MarginCallResponseAction.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class MarginCallResponseOnlyExistsValidator : AbstractOnlyExistsValidator<MarginCallResponse> {
    
        protected override IDictionary<string, bool> GetFields(MarginCallResponse obj)
        {
            return new Dictionary<string, bool>()
            {
                { "MarginCallResponseAction", IsSet(obj.MarginCallResponseAction!) },
                { "MarginResponseType", IsSet(obj.MarginResponseType!) },
                { "AgreedAmountBaseCurrency", IsSet(obj.AgreedAmountBaseCurrency!) }
            };
        }
    }
    
    public class MarginCallResponseActionValidator : AbstractValidator<MarginCallResponseAction>
    {
    
        public MarginCallResponseActionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MarginCallResponseAction obj)
        {
            yield return CheckCardinality(Name, "CollateralPositionComponent", obj.CollateralPositionComponent.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class MarginCallResponseActionOnlyExistsValidator : AbstractOnlyExistsValidator<MarginCallResponseAction> {
    
        protected override IDictionary<string, bool> GetFields(MarginCallResponseAction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CollateralPositionComponent", IsSet(obj.CollateralPositionComponent!) },
                { "MarginCallAction", IsSet(obj.MarginCallAction!) }
            };
        }
    }
    
    public class MasterAgreementClauseValidator : AbstractValidator<MasterAgreementClause>
    {
    
        public MasterAgreementClauseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MasterAgreementClause obj)
        {
            yield return CheckCardinality(Name, "Name", obj.Name != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Counterparty", obj.Counterparty.EmptyIfNull().Count(), 0, 2);
            yield return CheckCardinality(Name, "OtherParty", obj.OtherParty.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Variant", obj.Variant.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class MasterAgreementClauseOnlyExistsValidator : AbstractOnlyExistsValidator<MasterAgreementClause> {
    
        protected override IDictionary<string, bool> GetFields(MasterAgreementClause obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Identifer", IsSet(obj.Identifer!) },
                { "Name", IsSet(obj.Name!) },
                { "Counterparty", IsSet(obj.Counterparty!) },
                { "OtherParty", IsSet(obj.OtherParty!) },
                { "Variant", IsSet(obj.Variant!) }
            };
        }
    }
    
    public class MasterAgreementClauseVariantValidator : AbstractValidator<MasterAgreementClauseVariant>
    {
    
        public MasterAgreementClauseVariantValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MasterAgreementClauseVariant obj)
        {
            yield return CheckCardinality(Name, "Name", obj.Name != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Counterparty", obj.Counterparty.EmptyIfNull().Count(), 0, 2);
            yield return CheckCardinality(Name, "OtherParty", obj.OtherParty.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "VariableSet", obj.VariableSet.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class MasterAgreementClauseVariantOnlyExistsValidator : AbstractOnlyExistsValidator<MasterAgreementClauseVariant> {
    
        protected override IDictionary<string, bool> GetFields(MasterAgreementClauseVariant obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Identifier", IsSet(obj.Identifier!) },
                { "Name", IsSet(obj.Name!) },
                { "Counterparty", IsSet(obj.Counterparty!) },
                { "OtherParty", IsSet(obj.OtherParty!) },
                { "VariableSet", IsSet(obj.VariableSet!) }
            };
        }
    }
    
    public class MasterAgreementScheduleValidator : AbstractValidator<MasterAgreementSchedule>
    {
    
        public MasterAgreementScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MasterAgreementSchedule obj)
        {
            yield return CheckCardinality(Name, "Clause", obj.Clause.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class MasterAgreementScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<MasterAgreementSchedule> {
    
        protected override IDictionary<string, bool> GetFields(MasterAgreementSchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Clause", IsSet(obj.Clause!) }
            };
        }
    }
    
    public class MasterAgreementVariableSetValidator : AbstractValidator<MasterAgreementVariableSet>
    {
    
        public MasterAgreementVariableSetValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MasterAgreementVariableSet obj)
        {
            yield return CheckCardinality(Name, "VariableSet", obj.VariableSet.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Name", obj.Name != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Value", obj.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class MasterAgreementVariableSetOnlyExistsValidator : AbstractOnlyExistsValidator<MasterAgreementVariableSet> {
    
        protected override IDictionary<string, bool> GetFields(MasterAgreementVariableSet obj)
        {
            return new Dictionary<string, bool>()
            {
                { "VariableSet", IsSet(obj.VariableSet!) },
                { "Name", IsSet(obj.Name!) },
                { "Value", IsSet(obj.Value!) }
            };
        }
    }
    
    public class MasterConfirmationBaseValidator : AbstractValidator<MasterConfirmationBase>
    {
    
        public MasterConfirmationBaseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MasterConfirmationBase obj)
        {
            yield break;
        }
    }
    
    public class MasterConfirmationBaseOnlyExistsValidator : AbstractOnlyExistsValidator<MasterConfirmationBase> {
    
        protected override IDictionary<string, bool> GetFields(MasterConfirmationBase obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class MeasureValidator : AbstractValidator<Measure>
    {
    
        public MeasureValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Measure obj)
        {
            yield break;
        }
    }
    
    public class MeasureOnlyExistsValidator : AbstractOnlyExistsValidator<Measure> {
    
        protected override IDictionary<string, bool> GetFields(Measure obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class MeasureBaseValidator : AbstractValidator<MeasureBase>
    {
    
        public MeasureBaseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MeasureBase obj)
        {
            yield return CheckCardinality(Name, "Value", obj.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Unit", obj.Unit != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class MeasureBaseOnlyExistsValidator : AbstractOnlyExistsValidator<MeasureBase> {
    
        protected override IDictionary<string, bool> GetFields(MeasureBase obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Value", IsSet(obj.Value!) },
                { "Unit", IsSet(obj.Unit!) }
            };
        }
    }
    
    public class MeasureScheduleValidator : AbstractValidator<MeasureSchedule>
    {
    
        public MeasureScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MeasureSchedule obj)
        {
            yield return CheckCardinality(Name, "DatedValue", obj.DatedValue.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class MeasureScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<MeasureSchedule> {
    
        protected override IDictionary<string, bool> GetFields(MeasureSchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DatedValue", IsSet(obj.DatedValue!) }
            };
        }
    }
    
    public class MessageInformationValidator : AbstractValidator<MessageInformation>
    {
    
        public MessageInformationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MessageInformation obj)
        {
            yield return CheckCardinality(Name, "SentBy", obj.SentBy?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SentTo", obj.SentTo.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "CopyTo", obj.CopyTo.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class MessageInformationOnlyExistsValidator : AbstractOnlyExistsValidator<MessageInformation> {
    
        protected override IDictionary<string, bool> GetFields(MessageInformation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "MessageId", IsSet(obj.MessageId!) },
                { "SentBy", IsSet(obj.SentBy!) },
                { "SentTo", IsSet(obj.SentTo!) },
                { "CopyTo", IsSet(obj.CopyTo!) }
            };
        }
    }
    
    public class MoneyValidator : AbstractValidator<Money>
    {
    
        public MoneyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Money obj)
        {
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class MoneyOnlyExistsValidator : AbstractOnlyExistsValidator<Money> {
    
        protected override IDictionary<string, bool> GetFields(Money obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class MoneyBoundValidator : AbstractValidator<MoneyBound>
    {
    
        public MoneyBoundValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MoneyBound obj)
        {
            yield break;
        }
    }
    
    public class MoneyBoundOnlyExistsValidator : AbstractOnlyExistsValidator<MoneyBound> {
    
        protected override IDictionary<string, bool> GetFields(MoneyBound obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Money", IsSet(obj.Money!) },
                { "Inclusive", IsSet(obj.Inclusive!) }
            };
        }
    }
    
    public class MoneyRangeValidator : AbstractValidator<MoneyRange>
    {
    
        public MoneyRangeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MoneyRange obj)
        {
            yield return CheckCardinality(Name, "LowerBound", obj.LowerBound != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "UpperBound", obj.UpperBound != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class MoneyRangeOnlyExistsValidator : AbstractOnlyExistsValidator<MoneyRange> {
    
        protected override IDictionary<string, bool> GetFields(MoneyRange obj)
        {
            return new Dictionary<string, bool>()
            {
                { "LowerBound", IsSet(obj.LowerBound!) },
                { "UpperBound", IsSet(obj.UpperBound!) }
            };
        }
    }
    
    public class MultipleCreditNotationsValidator : AbstractValidator<MultipleCreditNotations>
    {
    
        public MultipleCreditNotationsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MultipleCreditNotations obj)
        {
            yield return CheckCardinality(Name, "CreditNotation", obj.CreditNotation.EmptyIfNull().Count(), 2, 0);
            yield return CheckCardinality(Name, "MismatchResolution", obj.MismatchResolution != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ReferenceAgency", obj.ReferenceAgency != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class MultipleCreditNotationsOnlyExistsValidator : AbstractOnlyExistsValidator<MultipleCreditNotations> {
    
        protected override IDictionary<string, bool> GetFields(MultipleCreditNotations obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Condition", IsSet(obj.Condition!) },
                { "CreditNotation", IsSet(obj.CreditNotation!) },
                { "MismatchResolution", IsSet(obj.MismatchResolution!) },
                { "ReferenceAgency", IsSet(obj.ReferenceAgency!) }
            };
        }
    }
    
    public class MultipleDebtTypesValidator : AbstractValidator<MultipleDebtTypes>
    {
    
        public MultipleDebtTypesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MultipleDebtTypes obj)
        {
            yield return CheckCardinality(Name, "DebtType", obj.DebtType.EmptyIfNull().Count(), 2, 0);
            yield break;
        }
    }
    
    public class MultipleDebtTypesOnlyExistsValidator : AbstractOnlyExistsValidator<MultipleDebtTypes> {
    
        protected override IDictionary<string, bool> GetFields(MultipleDebtTypes obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Condition", IsSet(obj.Condition!) },
                { "DebtType", IsSet(obj.DebtType!) }
            };
        }
    }
    
    public class MultipleExerciseValidator : AbstractValidator<MultipleExercise>
    {
    
        public MultipleExerciseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MultipleExercise obj)
        {
            yield return CheckCardinality(Name, "MaximumNotionalAmount", obj.MaximumNotionalAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MaximumNumberOfOptions", obj.MaximumNumberOfOptions != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class MultipleExerciseOnlyExistsValidator : AbstractOnlyExistsValidator<MultipleExercise> {
    
        protected override IDictionary<string, bool> GetFields(MultipleExercise obj)
        {
            return new Dictionary<string, bool>()
            {
                { "MaximumNotionalAmount", IsSet(obj.MaximumNotionalAmount!) },
                { "MaximumNumberOfOptions", IsSet(obj.MaximumNumberOfOptions!) }
            };
        }
    }
    
    public class MultipleValuationDatesValidator : AbstractValidator<MultipleValuationDates>
    {
    
        public MultipleValuationDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(MultipleValuationDates obj)
        {
            yield return CheckCardinality(Name, "BusinessDaysThereafter", obj.BusinessDaysThereafter != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NumberValuationDates", obj.NumberValuationDates != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class MultipleValuationDatesOnlyExistsValidator : AbstractOnlyExistsValidator<MultipleValuationDates> {
    
        protected override IDictionary<string, bool> GetFields(MultipleValuationDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "BusinessDaysThereafter", IsSet(obj.BusinessDaysThereafter!) },
                { "NumberValuationDates", IsSet(obj.NumberValuationDates!) }
            };
        }
    }
    
    public class NaturalPersonValidator : AbstractValidator<NaturalPerson>
    {
    
        public NaturalPersonValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(NaturalPerson obj)
        {
            yield return CheckCardinality(Name, "PersonId", obj.PersonId.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Honorific", obj.Honorific != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FirstName", obj.FirstName != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MiddleName", obj.MiddleName.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Initial", obj.Initial.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Surname", obj.Surname != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Suffix", obj.Suffix != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DateOfBirth", obj.DateOfBirth != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ContactInformation", obj.ContactInformation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class NaturalPersonOnlyExistsValidator : AbstractOnlyExistsValidator<NaturalPerson> {
    
        protected override IDictionary<string, bool> GetFields(NaturalPerson obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PersonId", IsSet(obj.PersonId!) },
                { "Honorific", IsSet(obj.Honorific!) },
                { "FirstName", IsSet(obj.FirstName!) },
                { "MiddleName", IsSet(obj.MiddleName!) },
                { "Initial", IsSet(obj.Initial!) },
                { "Surname", IsSet(obj.Surname!) },
                { "Suffix", IsSet(obj.Suffix!) },
                { "DateOfBirth", IsSet(obj.DateOfBirth!) },
                { "ContactInformation", IsSet(obj.ContactInformation!) }
            };
        }
    }
    
    public class NaturalPersonRoleValidator : AbstractValidator<NaturalPersonRole>
    {
    
        public NaturalPersonRoleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(NaturalPersonRole obj)
        {
            yield return CheckCardinality(Name, "PersonReference", obj.PersonReference.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "Role", obj.Role.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class NaturalPersonRoleOnlyExistsValidator : AbstractOnlyExistsValidator<NaturalPersonRole> {
    
        protected override IDictionary<string, bool> GetFields(NaturalPersonRole obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PersonReference", IsSet(obj.PersonReference!) },
                { "Role", IsSet(obj.Role!) }
            };
        }
    }
    
    public class NegativeCriteriaValidator : AbstractValidator<NegativeCriteria>
    {
    
        public NegativeCriteriaValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(NegativeCriteria obj)
        {
            yield break;
        }
    }
    
    public class NegativeCriteriaOnlyExistsValidator : AbstractOnlyExistsValidator<NegativeCriteria> {
    
        protected override IDictionary<string, bool> GetFields(NegativeCriteria obj)
        {
            return new Dictionary<string, bool>()
            {
                { "NegativeCriteriaValue", IsSet(obj.NegativeCriteriaValue!) }
            };
        }
    }
    
    public class NewValidator : AbstractValidator<New>
    {
    
        public NewValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(New obj)
        {
            yield break;
        }
    }
    
    public class NewOnlyExistsValidator : AbstractOnlyExistsValidator<New> {
    
        protected override IDictionary<string, bool> GetFields(New obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TxId", IsSet(obj.TxId!) },
                { "ExctgPty", IsSet(obj.ExctgPty!) },
                { "InvstmtPtyInd", IsSet(obj.InvstmtPtyInd!) },
                { "SubmitgPty", IsSet(obj.SubmitgPty!) },
                { "Buyr", IsSet(obj.Buyr!) },
                { "Sellr", IsSet(obj.Sellr!) },
                { "OrdrTrnsmssn", IsSet(obj.OrdrTrnsmssn!) },
                { "Tx", IsSet(obj.Tx!) },
                { "FinInstrm", IsSet(obj.FinInstrm!) },
                { "InvstmtDcsnPrsn", IsSet(obj.InvstmtDcsnPrsn!) },
                { "ExctgPrsn", IsSet(obj.ExctgPrsn!) },
                { "AddtlAttrbts", IsSet(obj.AddtlAttrbts!) }
            };
        }
    }
    
    public class NmValidator : AbstractValidator<Nm>
    {
    
        public NmValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Nm obj)
        {
            yield break;
        }
    }
    
    public class NmOnlyExistsValidator : AbstractOnlyExistsValidator<Nm> {
    
        protected override IDictionary<string, bool> GetFields(Nm obj)
        {
            return new Dictionary<string, bool>()
            {
                { "RefRate", IsSet(obj.RefRate!) },
                { "Term", IsSet(obj.Term!) }
            };
        }
    }
    
    public class NonNegativeQuantityValidator : AbstractValidator<NonNegativeQuantity>
    {
    
        public NonNegativeQuantityValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(NonNegativeQuantity obj)
        {
            yield break;
        }
    }
    
    public class NonNegativeQuantityOnlyExistsValidator : AbstractOnlyExistsValidator<NonNegativeQuantity> {
    
        protected override IDictionary<string, bool> GetFields(NonNegativeQuantity obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class NonNegativeQuantityScheduleValidator : AbstractValidator<NonNegativeQuantitySchedule>
    {
    
        public NonNegativeQuantityScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(NonNegativeQuantitySchedule obj)
        {
            yield break;
        }
    }
    
    public class NonNegativeQuantityScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<NonNegativeQuantitySchedule> {
    
        protected override IDictionary<string, bool> GetFields(NonNegativeQuantitySchedule obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class NonNegativeStepValidator : AbstractValidator<NonNegativeStep>
    {
    
        public NonNegativeStepValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(NonNegativeStep obj)
        {
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class NonNegativeStepOnlyExistsValidator : AbstractOnlyExistsValidator<NonNegativeStep> {
    
        protected override IDictionary<string, bool> GetFields(NonNegativeStep obj)
        {
            return new Dictionary<string, bool>()
            {
                { "StepDate", IsSet(obj.StepDate!) },
                { "StepValue", IsSet(obj.StepValue!) }
            };
        }
    }
    
    public class NonTransferableProductValidator : AbstractValidator<NonTransferableProduct>
    {
    
        public NonTransferableProductValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(NonTransferableProduct obj)
        {
            yield return CheckCardinality(Name, "Identifier", obj.Identifier.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Taxonomy", obj.Taxonomy.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class NonTransferableProductOnlyExistsValidator : AbstractOnlyExistsValidator<NonTransferableProduct> {
    
        protected override IDictionary<string, bool> GetFields(NonTransferableProduct obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Identifier", IsSet(obj.Identifier!) },
                { "Taxonomy", IsSet(obj.Taxonomy!) },
                { "EconomicTerms", IsSet(obj.EconomicTerms!) }
            };
        }
    }
    
    public class NotDomesticCurrencyValidator : AbstractValidator<NotDomesticCurrency>
    {
    
        public NotDomesticCurrencyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(NotDomesticCurrency obj)
        {
            yield return CheckCardinality(Name, "Currency", obj.Currency?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class NotDomesticCurrencyOnlyExistsValidator : AbstractOnlyExistsValidator<NotDomesticCurrency> {
    
        protected override IDictionary<string, bool> GetFields(NotDomesticCurrency obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Applicable", IsSet(obj.Applicable!) },
                { "Currency", IsSet(obj.Currency!) }
            };
        }
    }
    
    public class NumberBoundValidator : AbstractValidator<NumberBound>
    {
    
        public NumberBoundValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(NumberBound obj)
        {
            yield break;
        }
    }
    
    public class NumberBoundOnlyExistsValidator : AbstractOnlyExistsValidator<NumberBound> {
    
        protected override IDictionary<string, bool> GetFields(NumberBound obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Number", IsSet(obj.Number!) },
                { "Inclusive", IsSet(obj.Inclusive!) }
            };
        }
    }
    
    public class NumberRangeValidator : AbstractValidator<NumberRange>
    {
    
        public NumberRangeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(NumberRange obj)
        {
            yield return CheckCardinality(Name, "LowerBound", obj.LowerBound != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "UpperBound", obj.UpperBound != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class NumberRangeOnlyExistsValidator : AbstractOnlyExistsValidator<NumberRange> {
    
        protected override IDictionary<string, bool> GetFields(NumberRange obj)
        {
            return new Dictionary<string, bool>()
            {
                { "LowerBound", IsSet(obj.LowerBound!) },
                { "UpperBound", IsSet(obj.UpperBound!) }
            };
        }
    }
    
    public class ObligationsValidator : AbstractValidator<Obligations>
    {
    
        public ObligationsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Obligations obj)
        {
            yield return CheckCardinality(Name, "NotSubordinated", obj.NotSubordinated != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SpecifiedCurrency", obj.SpecifiedCurrency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NotSovereignLender", obj.NotSovereignLender != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NotDomesticCurrency", obj.NotDomesticCurrency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NotDomesticLaw", obj.NotDomesticLaw != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Listed", obj.Listed != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NotDomesticIssuance", obj.NotDomesticIssuance != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FullFaithAndCreditObLiability", obj.FullFaithAndCreditObLiability != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "GeneralFundObligationLiability", obj.GeneralFundObligationLiability != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RevenueObligationLiability", obj.RevenueObligationLiability != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NotContingent", obj.NotContingent != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Excluded", obj.Excluded != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "OthReferenceEntityObligations", obj.OthReferenceEntityObligations != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DesignatedPriority", obj.DesignatedPriority?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CashSettlementOnly", obj.CashSettlementOnly != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DeliveryOfCommitments", obj.DeliveryOfCommitments != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Continuity", obj.Continuity != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ObligationsOnlyExistsValidator : AbstractOnlyExistsValidator<Obligations> {
    
        protected override IDictionary<string, bool> GetFields(Obligations obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Category", IsSet(obj.Category!) },
                { "NotSubordinated", IsSet(obj.NotSubordinated!) },
                { "SpecifiedCurrency", IsSet(obj.SpecifiedCurrency!) },
                { "NotSovereignLender", IsSet(obj.NotSovereignLender!) },
                { "NotDomesticCurrency", IsSet(obj.NotDomesticCurrency!) },
                { "NotDomesticLaw", IsSet(obj.NotDomesticLaw!) },
                { "Listed", IsSet(obj.Listed!) },
                { "NotDomesticIssuance", IsSet(obj.NotDomesticIssuance!) },
                { "FullFaithAndCreditObLiability", IsSet(obj.FullFaithAndCreditObLiability!) },
                { "GeneralFundObligationLiability", IsSet(obj.GeneralFundObligationLiability!) },
                { "RevenueObligationLiability", IsSet(obj.RevenueObligationLiability!) },
                { "NotContingent", IsSet(obj.NotContingent!) },
                { "Excluded", IsSet(obj.Excluded!) },
                { "OthReferenceEntityObligations", IsSet(obj.OthReferenceEntityObligations!) },
                { "DesignatedPriority", IsSet(obj.DesignatedPriority!) },
                { "CashSettlementOnly", IsSet(obj.CashSettlementOnly!) },
                { "DeliveryOfCommitments", IsSet(obj.DeliveryOfCommitments!) },
                { "Continuity", IsSet(obj.Continuity!) }
            };
        }
    }
    
    public class ObservableValidator : AbstractValidator<Observable>
    {
    
        public ObservableValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Observable obj)
        {
            yield return CheckCardinality(Name, "Asset", obj.Asset != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Basket", obj.Basket != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Index", obj.Index != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ObservableOnlyExistsValidator : AbstractOnlyExistsValidator<Observable> {
    
        protected override IDictionary<string, bool> GetFields(Observable obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Asset", IsSet(obj.Asset!) },
                { "Basket", IsSet(obj.Basket!) },
                { "Index", IsSet(obj.Index!) }
            };
        }
    }
    
    public class ObservationValidator : AbstractValidator<Observation>
    {
    
        public ObservationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Observation obj)
        {
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ObservationOnlyExistsValidator : AbstractOnlyExistsValidator<Observation> {
    
        protected override IDictionary<string, bool> GetFields(Observation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ObservedValue", IsSet(obj.ObservedValue!) },
                { "ObservationIdentifier", IsSet(obj.ObservationIdentifier!) }
            };
        }
    }
    
    public class ObservationDateValidator : AbstractValidator<ObservationDate>
    {
    
        public ObservationDateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ObservationDate obj)
        {
            yield return CheckCardinality(Name, "UnadjustedDate", obj.UnadjustedDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdjustedDate", obj.AdjustedDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Weight", obj.Weight != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ObservationReference", obj.ObservationReference != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ObservationDateOnlyExistsValidator : AbstractOnlyExistsValidator<ObservationDate> {
    
        protected override IDictionary<string, bool> GetFields(ObservationDate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "UnadjustedDate", IsSet(obj.UnadjustedDate!) },
                { "AdjustedDate", IsSet(obj.AdjustedDate!) },
                { "Weight", IsSet(obj.Weight!) },
                { "ObservationReference", IsSet(obj.ObservationReference!) }
            };
        }
    }
    
    public class ObservationDatesValidator : AbstractValidator<ObservationDates>
    {
    
        public ObservationDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ObservationDates obj)
        {
            yield return CheckCardinality(Name, "ObservationSchedule", obj.ObservationSchedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PeriodicSchedule", obj.PeriodicSchedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ParametricDates", obj.ParametricDates != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ObservationDatesOnlyExistsValidator : AbstractOnlyExistsValidator<ObservationDates> {
    
        protected override IDictionary<string, bool> GetFields(ObservationDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ObservationSchedule", IsSet(obj.ObservationSchedule!) },
                { "PeriodicSchedule", IsSet(obj.PeriodicSchedule!) },
                { "ParametricDates", IsSet(obj.ParametricDates!) }
            };
        }
    }
    
    public class ObservationEventValidator : AbstractValidator<ObservationEvent>
    {
    
        public ObservationEventValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ObservationEvent obj)
        {
            yield return CheckCardinality(Name, "CreditEvent", obj.CreditEvent != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CorporateAction", obj.CorporateAction != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ObservationEventOnlyExistsValidator : AbstractOnlyExistsValidator<ObservationEvent> {
    
        protected override IDictionary<string, bool> GetFields(ObservationEvent obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CreditEvent", IsSet(obj.CreditEvent!) },
                { "CorporateAction", IsSet(obj.CorporateAction!) }
            };
        }
    }
    
    public class ObservationIdentifierValidator : AbstractValidator<ObservationIdentifier>
    {
    
        public ObservationIdentifierValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ObservationIdentifier obj)
        {
            yield return CheckCardinality(Name, "ObservationTime", obj.ObservationTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InformationSource", obj.InformationSource != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DeterminationMethodology", obj.DeterminationMethodology != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ObservationIdentifierOnlyExistsValidator : AbstractOnlyExistsValidator<ObservationIdentifier> {
    
        protected override IDictionary<string, bool> GetFields(ObservationIdentifier obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Observable", IsSet(obj.Observable!) },
                { "ObservationDate", IsSet(obj.ObservationDate!) },
                { "ObservationTime", IsSet(obj.ObservationTime!) },
                { "InformationSource", IsSet(obj.InformationSource!) },
                { "DeterminationMethodology", IsSet(obj.DeterminationMethodology!) }
            };
        }
    }
    
    public class ObservationInstructionValidator : AbstractValidator<ObservationInstruction>
    {
    
        public ObservationInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ObservationInstruction obj)
        {
            yield break;
        }
    }
    
    public class ObservationInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<ObservationInstruction> {
    
        protected override IDictionary<string, bool> GetFields(ObservationInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ObservationEvent", IsSet(obj.ObservationEvent!) }
            };
        }
    }
    
    public class ObservationParametersValidator : AbstractValidator<ObservationParameters>
    {
    
        public ObservationParametersValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ObservationParameters obj)
        {
            yield return CheckCardinality(Name, "ObservationCapRate", obj.ObservationCapRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ObservationFloorRate", obj.ObservationFloorRate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ObservationParametersOnlyExistsValidator : AbstractOnlyExistsValidator<ObservationParameters> {
    
        protected override IDictionary<string, bool> GetFields(ObservationParameters obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ObservationCapRate", IsSet(obj.ObservationCapRate!) },
                { "ObservationFloorRate", IsSet(obj.ObservationFloorRate!) }
            };
        }
    }
    
    public class ObservationScheduleValidator : AbstractValidator<ObservationSchedule>
    {
    
        public ObservationScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ObservationSchedule obj)
        {
            yield return CheckCardinality(Name, "ObservationDate", obj.ObservationDate.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "DateAdjustments", obj.DateAdjustments != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ObservationScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<ObservationSchedule> {
    
        protected override IDictionary<string, bool> GetFields(ObservationSchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ObservationDate", IsSet(obj.ObservationDate!) },
                { "DateAdjustments", IsSet(obj.DateAdjustments!) }
            };
        }
    }
    
    public class ObservationShiftCalculationValidator : AbstractValidator<ObservationShiftCalculation>
    {
    
        public ObservationShiftCalculationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ObservationShiftCalculation obj)
        {
            yield return CheckCardinality(Name, "OffsetDays", obj.OffsetDays != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationBase", obj.CalculationBase != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdditionalBusinessDays", obj.AdditionalBusinessDays != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ObservationShiftCalculationOnlyExistsValidator : AbstractOnlyExistsValidator<ObservationShiftCalculation> {
    
        protected override IDictionary<string, bool> GetFields(ObservationShiftCalculation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "OffsetDays", IsSet(obj.OffsetDays!) },
                { "CalculationBase", IsSet(obj.CalculationBase!) },
                { "AdditionalBusinessDays", IsSet(obj.AdditionalBusinessDays!) }
            };
        }
    }
    
    public class ObservationTermsValidator : AbstractValidator<ObservationTerms>
    {
    
        public ObservationTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ObservationTerms obj)
        {
            yield return CheckCardinality(Name, "ObservationTime", obj.ObservationTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ObservationTimeType", obj.ObservationTimeType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InformationSource", obj.InformationSource != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Precision", obj.Precision != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationPeriodDates", obj.CalculationPeriodDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NumberOfObservationDates", obj.NumberOfObservationDates != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ObservationTermsOnlyExistsValidator : AbstractOnlyExistsValidator<ObservationTerms> {
    
        protected override IDictionary<string, bool> GetFields(ObservationTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ObservationTime", IsSet(obj.ObservationTime!) },
                { "ObservationTimeType", IsSet(obj.ObservationTimeType!) },
                { "InformationSource", IsSet(obj.InformationSource!) },
                { "Precision", IsSet(obj.Precision!) },
                { "CalculationPeriodDates", IsSet(obj.CalculationPeriodDates!) },
                { "ObservationDates", IsSet(obj.ObservationDates!) },
                { "NumberOfObservationDates", IsSet(obj.NumberOfObservationDates!) }
            };
        }
    }
    
    public class OffsetValidator : AbstractValidator<Offset>
    {
    
        public OffsetValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Offset obj)
        {
            yield return CheckCardinality(Name, "DayType", obj.DayType != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class OffsetOnlyExistsValidator : AbstractOnlyExistsValidator<Offset> {
    
        protected override IDictionary<string, bool> GetFields(Offset obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DayType", IsSet(obj.DayType!) }
            };
        }
    }
    
    public class OffsetCalculationValidator : AbstractValidator<OffsetCalculation>
    {
    
        public OffsetCalculationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(OffsetCalculation obj)
        {
            yield return CheckCardinality(Name, "OffsetDays", obj.OffsetDays != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class OffsetCalculationOnlyExistsValidator : AbstractOnlyExistsValidator<OffsetCalculation> {
    
        protected override IDictionary<string, bool> GetFields(OffsetCalculation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "OffsetDays", IsSet(obj.OffsetDays!) }
            };
        }
    }
    
    public class OptionFeatureValidator : AbstractValidator<OptionFeature>
    {
    
        public OptionFeatureValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(OptionFeature obj)
        {
            yield return CheckCardinality(Name, "FxFeature", obj.FxFeature.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "StrategyFeature", obj.StrategyFeature != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AveragingFeature", obj.AveragingFeature != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Barrier", obj.Barrier != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Knock", obj.Knock != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PassThrough", obj.PassThrough != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class OptionFeatureOnlyExistsValidator : AbstractOnlyExistsValidator<OptionFeature> {
    
        protected override IDictionary<string, bool> GetFields(OptionFeature obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FxFeature", IsSet(obj.FxFeature!) },
                { "StrategyFeature", IsSet(obj.StrategyFeature!) },
                { "AveragingFeature", IsSet(obj.AveragingFeature!) },
                { "Barrier", IsSet(obj.Barrier!) },
                { "Knock", IsSet(obj.Knock!) },
                { "PassThrough", IsSet(obj.PassThrough!) }
            };
        }
    }
    
    public class OptionPayoutValidator : AbstractValidator<OptionPayout>
    {
    
        public OptionPayoutValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(OptionPayout obj)
        {
            yield return CheckCardinality(Name, "Feature", obj.Feature != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ObservationTerms", obj.ObservationTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Schedule", obj.Schedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Delivery", obj.Delivery != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "OptionType", obj.OptionType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Strike", obj.Strike != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class OptionPayoutOnlyExistsValidator : AbstractOnlyExistsValidator<OptionPayout> {
    
        protected override IDictionary<string, bool> GetFields(OptionPayout obj)
        {
            return new Dictionary<string, bool>()
            {
                { "BuyerSeller", IsSet(obj.BuyerSeller!) },
                { "Feature", IsSet(obj.Feature!) },
                { "ObservationTerms", IsSet(obj.ObservationTerms!) },
                { "Schedule", IsSet(obj.Schedule!) },
                { "Delivery", IsSet(obj.Delivery!) },
                { "Underlier", IsSet(obj.Underlier!) },
                { "OptionType", IsSet(obj.OptionType!) },
                { "ExerciseTerms", IsSet(obj.ExerciseTerms!) },
                { "Strike", IsSet(obj.Strike!) }
            };
        }
    }
    
    public class OptionStrikeValidator : AbstractValidator<OptionStrike>
    {
    
        public OptionStrikeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(OptionStrike obj)
        {
            yield return CheckCardinality(Name, "StrikePrice", obj.StrikePrice != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "StrikeReference", obj.StrikeReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ReferenceSwapCurve", obj.ReferenceSwapCurve != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AveragingStrikeFeature", obj.AveragingStrikeFeature != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class OptionStrikeOnlyExistsValidator : AbstractOnlyExistsValidator<OptionStrike> {
    
        protected override IDictionary<string, bool> GetFields(OptionStrike obj)
        {
            return new Dictionary<string, bool>()
            {
                { "StrikePrice", IsSet(obj.StrikePrice!) },
                { "StrikeReference", IsSet(obj.StrikeReference!) },
                { "ReferenceSwapCurve", IsSet(obj.ReferenceSwapCurve!) },
                { "AveragingStrikeFeature", IsSet(obj.AveragingStrikeFeature!) }
            };
        }
    }
    
    public class OptionalEarlyTerminationValidator : AbstractValidator<OptionalEarlyTermination>
    {
    
        public OptionalEarlyTerminationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(OptionalEarlyTermination obj)
        {
            yield return CheckCardinality(Name, "SinglePartyOption", obj.SinglePartyOption != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MutualEarlyTermination", obj.MutualEarlyTermination != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExerciseNotice", obj.ExerciseNotice.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "FollowUpConfirmation", obj.FollowUpConfirmation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationAgent", obj.CalculationAgent != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CashSettlement", obj.CashSettlement != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "OptionalEarlyTerminationAdjustedDates", obj.OptionalEarlyTerminationAdjustedDates != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class OptionalEarlyTerminationOnlyExistsValidator : AbstractOnlyExistsValidator<OptionalEarlyTermination> {
    
        protected override IDictionary<string, bool> GetFields(OptionalEarlyTermination obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SinglePartyOption", IsSet(obj.SinglePartyOption!) },
                { "MutualEarlyTermination", IsSet(obj.MutualEarlyTermination!) },
                { "ExerciseNotice", IsSet(obj.ExerciseNotice!) },
                { "FollowUpConfirmation", IsSet(obj.FollowUpConfirmation!) },
                { "CalculationAgent", IsSet(obj.CalculationAgent!) },
                { "CashSettlement", IsSet(obj.CashSettlement!) },
                { "OptionalEarlyTerminationAdjustedDates", IsSet(obj.OptionalEarlyTerminationAdjustedDates!) },
                { "ExerciseTerms", IsSet(obj.ExerciseTerms!) }
            };
        }
    }
    
    public class OptionalEarlyTerminationAdjustedDatesValidator : AbstractValidator<OptionalEarlyTerminationAdjustedDates>
    {
    
        public OptionalEarlyTerminationAdjustedDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(OptionalEarlyTerminationAdjustedDates obj)
        {
            yield return CheckCardinality(Name, "EarlyTerminationEvent", obj.EarlyTerminationEvent.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class OptionalEarlyTerminationAdjustedDatesOnlyExistsValidator : AbstractOnlyExistsValidator<OptionalEarlyTerminationAdjustedDates> {
    
        protected override IDictionary<string, bool> GetFields(OptionalEarlyTerminationAdjustedDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "EarlyTerminationEvent", IsSet(obj.EarlyTerminationEvent!) }
            };
        }
    }
    
    public class OrdrTrnsmssnValidator : AbstractValidator<OrdrTrnsmssn>
    {
    
        public OrdrTrnsmssnValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(OrdrTrnsmssn obj)
        {
            yield break;
        }
    }
    
    public class OrdrTrnsmssnOnlyExistsValidator : AbstractOnlyExistsValidator<OrdrTrnsmssn> {
    
        protected override IDictionary<string, bool> GetFields(OrdrTrnsmssn obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TrnsmssnInd", IsSet(obj.TrnsmssnInd!) }
            };
        }
    }
    
    public class OtherAgreementValidator : AbstractValidator<OtherAgreement>
    {
    
        public OtherAgreementValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(OtherAgreement obj)
        {
            yield return CheckCardinality(Name, "Identifier", obj.Identifier?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Version", obj.Version?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Date", obj.Date != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class OtherAgreementOnlyExistsValidator : AbstractOnlyExistsValidator<OtherAgreement> {
    
        protected override IDictionary<string, bool> GetFields(OtherAgreement obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Identifier", IsSet(obj.Identifier!) },
                { "OtherAgreementType", IsSet(obj.OtherAgreementType!) },
                { "Version", IsSet(obj.Version!) },
                { "Date", IsSet(obj.Date!) }
            };
        }
    }
    
    public class OtherAgreementTermsValidator : AbstractValidator<OtherAgreementTerms>
    {
    
        public OtherAgreementTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(OtherAgreementTerms obj)
        {
            yield return CheckCardinality(Name, "LegalDocument", obj.LegalDocument != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class OtherAgreementTermsOnlyExistsValidator : AbstractOnlyExistsValidator<OtherAgreementTerms> {
    
        protected override IDictionary<string, bool> GetFields(OtherAgreementTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "IsSpecified", IsSet(obj.IsSpecified!) },
                { "LegalDocument", IsSet(obj.LegalDocument!) }
            };
        }
    }
    
    public class OtherIndexValidator : AbstractValidator<OtherIndex>
    {
    
        public OtherIndexValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(OtherIndex obj)
        {
            yield return CheckCardinality(Name, "Description", obj.Description != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class OtherIndexOnlyExistsValidator : AbstractOnlyExistsValidator<OtherIndex> {
    
        protected override IDictionary<string, bool> GetFields(OtherIndex obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Description", IsSet(obj.Description!) }
            };
        }
    }
    
    public class OthrValidator : AbstractValidator<Othr>
    {
    
        public OthrValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Othr obj)
        {
            yield break;
        }
    }
    
    public class OthrOnlyExistsValidator : AbstractOnlyExistsValidator<Othr> {
    
        protected override IDictionary<string, bool> GetFields(Othr obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FinInstrmGnlAttrbts", IsSet(obj.FinInstrmGnlAttrbts!) },
                { "DerivInstrmAttrbts", IsSet(obj.DerivInstrmAttrbts!) },
                { "Id", IsSet(obj.Id!) },
                { "SchmeNm", IsSet(obj.SchmeNm!) }
            };
        }
    }
    
    public class PCDeliverableObligationCharacValidator : AbstractValidator<PCDeliverableObligationCharac>
    {
    
        public PCDeliverableObligationCharacValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PCDeliverableObligationCharac obj)
        {
            yield return CheckCardinality(Name, "PartialCashSettlement", obj.PartialCashSettlement != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PCDeliverableObligationCharacOnlyExistsValidator : AbstractOnlyExistsValidator<PCDeliverableObligationCharac> {
    
        protected override IDictionary<string, bool> GetFields(PCDeliverableObligationCharac obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Applicable", IsSet(obj.Applicable!) },
                { "PartialCashSettlement", IsSet(obj.PartialCashSettlement!) }
            };
        }
    }
    
    public class ParametricDatesValidator : AbstractValidator<ParametricDates>
    {
    
        public ParametricDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ParametricDates obj)
        {
            yield return CheckCardinality(Name, "DayDistribution", obj.DayDistribution != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DayOfWeek", obj.DayOfWeek.EmptyIfNull().Count(), 0, 7);
            yield return CheckCardinality(Name, "DayFrequency", obj.DayFrequency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Lag", obj.Lag != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ParametricDatesOnlyExistsValidator : AbstractOnlyExistsValidator<ParametricDates> {
    
        protected override IDictionary<string, bool> GetFields(ParametricDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DayType", IsSet(obj.DayType!) },
                { "DayDistribution", IsSet(obj.DayDistribution!) },
                { "DayOfWeek", IsSet(obj.DayOfWeek!) },
                { "DayFrequency", IsSet(obj.DayFrequency!) },
                { "Lag", IsSet(obj.Lag!) },
                { "BusinessCenters", IsSet(obj.BusinessCenters!) }
            };
        }
    }
    
    public class PartialExerciseValidator : AbstractValidator<PartialExercise>
    {
    
        public PartialExerciseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PartialExercise obj)
        {
            yield return CheckCardinality(Name, "NotionaReference", obj.NotionaReference.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "IntegralMultipleAmount", obj.IntegralMultipleAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MinimumNotionalAmount", obj.MinimumNotionalAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MinimumNumberOfOptions", obj.MinimumNumberOfOptions != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PartialExerciseOnlyExistsValidator : AbstractOnlyExistsValidator<PartialExercise> {
    
        protected override IDictionary<string, bool> GetFields(PartialExercise obj)
        {
            return new Dictionary<string, bool>()
            {
                { "NotionaReference", IsSet(obj.NotionaReference!) },
                { "IntegralMultipleAmount", IsSet(obj.IntegralMultipleAmount!) },
                { "MinimumNotionalAmount", IsSet(obj.MinimumNotionalAmount!) },
                { "MinimumNumberOfOptions", IsSet(obj.MinimumNumberOfOptions!) }
            };
        }
    }
    
    public class PartyValidator : AbstractValidator<Party>
    {
    
        public PartyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Party obj)
        {
            yield return CheckCardinality(Name, "PartyId", obj.PartyId.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "Name", obj.Name?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BusinessUnit", obj.BusinessUnit.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Person", obj.Person.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "PersonRole", obj.PersonRole.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Account", obj.Account != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ContactInformation", obj.ContactInformation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PartyOnlyExistsValidator : AbstractOnlyExistsValidator<Party> {
    
        protected override IDictionary<string, bool> GetFields(Party obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PartyId", IsSet(obj.PartyId!) },
                { "Name", IsSet(obj.Name!) },
                { "BusinessUnit", IsSet(obj.BusinessUnit!) },
                { "Person", IsSet(obj.Person!) },
                { "PersonRole", IsSet(obj.PersonRole!) },
                { "Account", IsSet(obj.Account!) },
                { "ContactInformation", IsSet(obj.ContactInformation!) }
            };
        }
    }
    
    public class PartyChangeInstructionValidator : AbstractValidator<PartyChangeInstruction>
    {
    
        public PartyChangeInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PartyChangeInstruction obj)
        {
            yield return CheckCardinality(Name, "AncillaryParty", obj.AncillaryParty != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PartyRole", obj.PartyRole != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "TradeId", obj.TradeId.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class PartyChangeInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<PartyChangeInstruction> {
    
        protected override IDictionary<string, bool> GetFields(PartyChangeInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Counterparty", IsSet(obj.Counterparty!) },
                { "AncillaryParty", IsSet(obj.AncillaryParty!) },
                { "PartyRole", IsSet(obj.PartyRole!) },
                { "TradeId", IsSet(obj.TradeId!) }
            };
        }
    }
    
    public class PartyContactInformationValidator : AbstractValidator<PartyContactInformation>
    {
    
        public PartyContactInformationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PartyContactInformation obj)
        {
            yield return CheckCardinality(Name, "PartyReference", obj.PartyReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ContactInformation", obj.ContactInformation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BusinessUnit", obj.BusinessUnit.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Person", obj.Person.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "AdditionalInformation", obj.AdditionalInformation != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PartyContactInformationOnlyExistsValidator : AbstractOnlyExistsValidator<PartyContactInformation> {
    
        protected override IDictionary<string, bool> GetFields(PartyContactInformation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PartyReference", IsSet(obj.PartyReference!) },
                { "ContactInformation", IsSet(obj.ContactInformation!) },
                { "BusinessUnit", IsSet(obj.BusinessUnit!) },
                { "Person", IsSet(obj.Person!) },
                { "AdditionalInformation", IsSet(obj.AdditionalInformation!) }
            };
        }
    }
    
    public class PartyCustomisedWorkflowValidator : AbstractValidator<PartyCustomisedWorkflow>
    {
    
        public PartyCustomisedWorkflowValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PartyCustomisedWorkflow obj)
        {
            yield return CheckCardinality(Name, "PartyReference", obj.PartyReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PartyName", obj.PartyName != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CustomisedWorkflow", obj.CustomisedWorkflow.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class PartyCustomisedWorkflowOnlyExistsValidator : AbstractOnlyExistsValidator<PartyCustomisedWorkflow> {
    
        protected override IDictionary<string, bool> GetFields(PartyCustomisedWorkflow obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PartyReference", IsSet(obj.PartyReference!) },
                { "PartyName", IsSet(obj.PartyName!) },
                { "CustomisedWorkflow", IsSet(obj.CustomisedWorkflow!) }
            };
        }
    }
    
    public class PartyIdentifierValidator : AbstractValidator<PartyIdentifier>
    {
    
        public PartyIdentifierValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PartyIdentifier obj)
        {
            yield return CheckCardinality(Name, "IdentifierType", obj.IdentifierType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PartyIdentifierOnlyExistsValidator : AbstractOnlyExistsValidator<PartyIdentifier> {
    
        protected override IDictionary<string, bool> GetFields(PartyIdentifier obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Identifier", IsSet(obj.Identifier!) },
                { "IdentifierType", IsSet(obj.IdentifierType!) }
            };
        }
    }
    
    public class PartyReferencePayerReceiverValidator : AbstractValidator<PartyReferencePayerReceiver>
    {
    
        public PartyReferencePayerReceiverValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PartyReferencePayerReceiver obj)
        {
            yield return CheckCardinality(Name, "PayerPartyReference", obj.PayerPartyReference.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "PayerAccountReference", obj.PayerAccountReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ReceiverPartyReference", obj.ReceiverPartyReference.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "ReceiverAccountReference", obj.ReceiverAccountReference?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PartyReferencePayerReceiverOnlyExistsValidator : AbstractOnlyExistsValidator<PartyReferencePayerReceiver> {
    
        protected override IDictionary<string, bool> GetFields(PartyReferencePayerReceiver obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PayerPartyReference", IsSet(obj.PayerPartyReference!) },
                { "PayerAccountReference", IsSet(obj.PayerAccountReference!) },
                { "ReceiverPartyReference", IsSet(obj.ReceiverPartyReference!) },
                { "ReceiverAccountReference", IsSet(obj.ReceiverAccountReference!) }
            };
        }
    }
    
    public class PartyRoleValidator : AbstractValidator<PartyRole>
    {
    
        public PartyRoleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PartyRole obj)
        {
            yield return CheckCardinality(Name, "PartyReference", obj.PartyReference.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "OwnershipPartyReference", obj.OwnershipPartyReference?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PartyRoleOnlyExistsValidator : AbstractOnlyExistsValidator<PartyRole> {
    
        protected override IDictionary<string, bool> GetFields(PartyRole obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PartyReference", IsSet(obj.PartyReference!) },
                { "Role", IsSet(obj.Role!) },
                { "OwnershipPartyReference", IsSet(obj.OwnershipPartyReference!) }
            };
        }
    }
    
    public class PassThroughValidator : AbstractValidator<PassThrough>
    {
    
        public PassThroughValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PassThrough obj)
        {
            yield return CheckCardinality(Name, "PassThroughItem", obj.PassThroughItem.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class PassThroughOnlyExistsValidator : AbstractOnlyExistsValidator<PassThrough> {
    
        protected override IDictionary<string, bool> GetFields(PassThrough obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PassThroughItem", IsSet(obj.PassThroughItem!) }
            };
        }
    }
    
    public class PassThroughItemValidator : AbstractValidator<PassThroughItem>
    {
    
        public PassThroughItemValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PassThroughItem obj)
        {
            yield break;
        }
    }
    
    public class PassThroughItemOnlyExistsValidator : AbstractOnlyExistsValidator<PassThroughItem> {
    
        protected override IDictionary<string, bool> GetFields(PassThroughItem obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PayerReceiver", IsSet(obj.PayerReceiver!) },
                { "PassThroughPercentage", IsSet(obj.PassThroughPercentage!) }
            };
        }
    }
    
    public class PayerReceiverValidator : AbstractValidator<PayerReceiver>
    {
    
        public PayerReceiverValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PayerReceiver obj)
        {
            yield break;
        }
    }
    
    public class PayerReceiverOnlyExistsValidator : AbstractOnlyExistsValidator<PayerReceiver> {
    
        protected override IDictionary<string, bool> GetFields(PayerReceiver obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Payer", IsSet(obj.Payer!) },
                { "Receiver", IsSet(obj.Receiver!) }
            };
        }
    }
    
    public class PaymentCalculationPeriodValidator : AbstractValidator<PaymentCalculationPeriod>
    {
    
        public PaymentCalculationPeriodValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PaymentCalculationPeriod obj)
        {
            yield return CheckCardinality(Name, "UnadjustedPaymentDate", obj.UnadjustedPaymentDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdjustedPaymentDate", obj.AdjustedPaymentDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalculationPeriod", obj.CalculationPeriod.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "FixedPaymentAmount", obj.FixedPaymentAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DiscountFactor", obj.DiscountFactor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ForecastPaymentAmount", obj.ForecastPaymentAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PresentValueAmount", obj.PresentValueAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PaymentCalculationPeriodOnlyExistsValidator : AbstractOnlyExistsValidator<PaymentCalculationPeriod> {
    
        protected override IDictionary<string, bool> GetFields(PaymentCalculationPeriod obj)
        {
            return new Dictionary<string, bool>()
            {
                { "UnadjustedPaymentDate", IsSet(obj.UnadjustedPaymentDate!) },
                { "AdjustedPaymentDate", IsSet(obj.AdjustedPaymentDate!) },
                { "CalculationPeriod", IsSet(obj.CalculationPeriod!) },
                { "FixedPaymentAmount", IsSet(obj.FixedPaymentAmount!) },
                { "DiscountFactor", IsSet(obj.DiscountFactor!) },
                { "ForecastPaymentAmount", IsSet(obj.ForecastPaymentAmount!) },
                { "PresentValueAmount", IsSet(obj.PresentValueAmount!) }
            };
        }
    }
    
    public class PaymentDateScheduleValidator : AbstractValidator<PaymentDateSchedule>
    {
    
        public PaymentDateScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PaymentDateSchedule obj)
        {
            yield return CheckCardinality(Name, "InterimPaymentDates", obj.InterimPaymentDates.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "FinalPaymentDate", obj.FinalPaymentDate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PaymentDateScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<PaymentDateSchedule> {
    
        protected override IDictionary<string, bool> GetFields(PaymentDateSchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InterimPaymentDates", IsSet(obj.InterimPaymentDates!) },
                { "FinalPaymentDate", IsSet(obj.FinalPaymentDate!) }
            };
        }
    }
    
    public class PaymentDatesValidator : AbstractValidator<PaymentDates>
    {
    
        public PaymentDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PaymentDates obj)
        {
            yield return CheckCardinality(Name, "PaymentFrequency", obj.PaymentFrequency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FirstPaymentDate", obj.FirstPaymentDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "LastRegularPaymentDate", obj.LastRegularPaymentDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PaymentDateSchedule", obj.PaymentDateSchedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PayRelativeTo", obj.PayRelativeTo != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PaymentDaysOffset", obj.PaymentDaysOffset != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PaymentDatesAdjustments", obj.PaymentDatesAdjustments != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PaymentDatesOnlyExistsValidator : AbstractOnlyExistsValidator<PaymentDates> {
    
        protected override IDictionary<string, bool> GetFields(PaymentDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PaymentFrequency", IsSet(obj.PaymentFrequency!) },
                { "FirstPaymentDate", IsSet(obj.FirstPaymentDate!) },
                { "LastRegularPaymentDate", IsSet(obj.LastRegularPaymentDate!) },
                { "PaymentDateSchedule", IsSet(obj.PaymentDateSchedule!) },
                { "PayRelativeTo", IsSet(obj.PayRelativeTo!) },
                { "PaymentDaysOffset", IsSet(obj.PaymentDaysOffset!) },
                { "PaymentDatesAdjustments", IsSet(obj.PaymentDatesAdjustments!) }
            };
        }
    }
    
    public class PaymentDetailValidator : AbstractValidator<PaymentDetail>
    {
    
        public PaymentDetailValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PaymentDetail obj)
        {
            yield return CheckCardinality(Name, "PaymentDate", obj.PaymentDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PaymentAmount", obj.PaymentAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PaymentDetailOnlyExistsValidator : AbstractOnlyExistsValidator<PaymentDetail> {
    
        protected override IDictionary<string, bool> GetFields(PaymentDetail obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PaymentDate", IsSet(obj.PaymentDate!) },
                { "PaymentRule", IsSet(obj.PaymentRule!) },
                { "PaymentAmount", IsSet(obj.PaymentAmount!) }
            };
        }
    }
    
    public class PaymentDiscountingValidator : AbstractValidator<PaymentDiscounting>
    {
    
        public PaymentDiscountingValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PaymentDiscounting obj)
        {
            yield return CheckCardinality(Name, "DiscountFactor", obj.DiscountFactor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PresentValueAmount", obj.PresentValueAmount != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PaymentDiscountingOnlyExistsValidator : AbstractOnlyExistsValidator<PaymentDiscounting> {
    
        protected override IDictionary<string, bool> GetFields(PaymentDiscounting obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DiscountFactor", IsSet(obj.DiscountFactor!) },
                { "PresentValueAmount", IsSet(obj.PresentValueAmount!) }
            };
        }
    }
    
    public class PaymentRuleValidator : AbstractValidator<PaymentRule>
    {
    
        public PaymentRuleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PaymentRule obj)
        {
            yield return CheckCardinality(Name, "PercentageRule", obj.PercentageRule != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PaymentRuleOnlyExistsValidator : AbstractOnlyExistsValidator<PaymentRule> {
    
        protected override IDictionary<string, bool> GetFields(PaymentRule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PercentageRule", IsSet(obj.PercentageRule!) }
            };
        }
    }
    
    public class PayoutValidator : AbstractValidator<Payout>
    {
    
        public PayoutValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Payout obj)
        {
            yield return CheckCardinality(Name, "AssetPayout", obj.AssetPayout != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CommodityPayout", obj.CommodityPayout != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CreditDefaultPayout", obj.CreditDefaultPayout != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FixedPricePayout", obj.FixedPricePayout != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InterestRatePayout", obj.InterestRatePayout != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "OptionPayout", obj.OptionPayout != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PerformancePayout", obj.PerformancePayout != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SettlementPayout", obj.SettlementPayout != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PayoutOnlyExistsValidator : AbstractOnlyExistsValidator<Payout> {
    
        protected override IDictionary<string, bool> GetFields(Payout obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AssetPayout", IsSet(obj.AssetPayout!) },
                { "CommodityPayout", IsSet(obj.CommodityPayout!) },
                { "CreditDefaultPayout", IsSet(obj.CreditDefaultPayout!) },
                { "FixedPricePayout", IsSet(obj.FixedPricePayout!) },
                { "InterestRatePayout", IsSet(obj.InterestRatePayout!) },
                { "OptionPayout", IsSet(obj.OptionPayout!) },
                { "PerformancePayout", IsSet(obj.PerformancePayout!) },
                { "SettlementPayout", IsSet(obj.SettlementPayout!) }
            };
        }
    }
    
    public class PayoutBaseValidator : AbstractValidator<PayoutBase>
    {
    
        public PayoutBaseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PayoutBase obj)
        {
            yield return CheckCardinality(Name, "PriceQuantity", obj.PriceQuantity != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PrincipalPayment", obj.PrincipalPayment != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SettlementTerms", obj.SettlementTerms != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PayoutBaseOnlyExistsValidator : AbstractOnlyExistsValidator<PayoutBase> {
    
        protected override IDictionary<string, bool> GetFields(PayoutBase obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PayerReceiver", IsSet(obj.PayerReceiver!) },
                { "PriceQuantity", IsSet(obj.PriceQuantity!) },
                { "PrincipalPayment", IsSet(obj.PrincipalPayment!) },
                { "SettlementTerms", IsSet(obj.SettlementTerms!) }
            };
        }
    }
    
    public class PercentageRuleValidator : AbstractValidator<PercentageRule>
    {
    
        public PercentageRuleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PercentageRule obj)
        {
            yield return CheckCardinality(Name, "NotionalAmountReference", obj.NotionalAmountReference.Value != null ? 1 : 0, 1, 1);
            yield break;
        }
    }
    
    public class PercentageRuleOnlyExistsValidator : AbstractOnlyExistsValidator<PercentageRule> {
    
        protected override IDictionary<string, bool> GetFields(PercentageRule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PaymentPercent", IsSet(obj.PaymentPercent!) },
                { "NotionalAmountReference", IsSet(obj.NotionalAmountReference!) }
            };
        }
    }
    
    public class PerformancePayoutValidator : AbstractValidator<PerformancePayout>
    {
    
        public PerformancePayoutValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PerformancePayout obj)
        {
            yield return CheckCardinality(Name, "ObservationTerms", obj.ObservationTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Underlier", obj.Underlier != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FxFeature", obj.FxFeature.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "ReturnTerms", obj.ReturnTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PortfolioReturnTerms", obj.PortfolioReturnTerms.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "InitialValuationPrice", obj.InitialValuationPrice.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "InterimValuationPrice", obj.InterimValuationPrice.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "FinalValuationPrice", obj.FinalValuationPrice.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class PerformancePayoutOnlyExistsValidator : AbstractOnlyExistsValidator<PerformancePayout> {
    
        protected override IDictionary<string, bool> GetFields(PerformancePayout obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ObservationTerms", IsSet(obj.ObservationTerms!) },
                { "ValuationDates", IsSet(obj.ValuationDates!) },
                { "PaymentDates", IsSet(obj.PaymentDates!) },
                { "Underlier", IsSet(obj.Underlier!) },
                { "FxFeature", IsSet(obj.FxFeature!) },
                { "ReturnTerms", IsSet(obj.ReturnTerms!) },
                { "PortfolioReturnTerms", IsSet(obj.PortfolioReturnTerms!) },
                { "InitialValuationPrice", IsSet(obj.InitialValuationPrice!) },
                { "InterimValuationPrice", IsSet(obj.InterimValuationPrice!) },
                { "FinalValuationPrice", IsSet(obj.FinalValuationPrice!) }
            };
        }
    }
    
    public class PerformanceValuationDatesValidator : AbstractValidator<PerformanceValuationDates>
    {
    
        public PerformanceValuationDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PerformanceValuationDates obj)
        {
            yield return CheckCardinality(Name, "ValuationDates", obj.ValuationDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ValuationDate", obj.ValuationDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ValuationTime", obj.ValuationTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ValuationTimeType", obj.ValuationTimeType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PerformanceValuationDatesOnlyExistsValidator : AbstractOnlyExistsValidator<PerformanceValuationDates> {
    
        protected override IDictionary<string, bool> GetFields(PerformanceValuationDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DeterminationMethod", IsSet(obj.DeterminationMethod!) },
                { "ValuationDates", IsSet(obj.ValuationDates!) },
                { "ValuationDate", IsSet(obj.ValuationDate!) },
                { "ValuationTime", IsSet(obj.ValuationTime!) },
                { "ValuationTimeType", IsSet(obj.ValuationTimeType!) }
            };
        }
    }
    
    public class PeriodValidator : AbstractValidator<Period>
    {
    
        public PeriodValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Period obj)
        {
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PeriodOnlyExistsValidator : AbstractOnlyExistsValidator<Period> {
    
        protected override IDictionary<string, bool> GetFields(Period obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PeriodMultiplier", IsSet(obj.PeriodMultiplier!) },
                { "PeriodValue", IsSet(obj.PeriodValue!) }
            };
        }
    }
    
    public class PeriodBoundValidator : AbstractValidator<PeriodBound>
    {
    
        public PeriodBoundValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PeriodBound obj)
        {
            yield break;
        }
    }
    
    public class PeriodBoundOnlyExistsValidator : AbstractOnlyExistsValidator<PeriodBound> {
    
        protected override IDictionary<string, bool> GetFields(PeriodBound obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Period", IsSet(obj.Period!) },
                { "Inclusive", IsSet(obj.Inclusive!) }
            };
        }
    }
    
    public class PeriodRangeValidator : AbstractValidator<PeriodRange>
    {
    
        public PeriodRangeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PeriodRange obj)
        {
            yield return CheckCardinality(Name, "LowerBound", obj.LowerBound != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "UpperBound", obj.UpperBound != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PeriodRangeOnlyExistsValidator : AbstractOnlyExistsValidator<PeriodRange> {
    
        protected override IDictionary<string, bool> GetFields(PeriodRange obj)
        {
            return new Dictionary<string, bool>()
            {
                { "LowerBound", IsSet(obj.LowerBound!) },
                { "UpperBound", IsSet(obj.UpperBound!) }
            };
        }
    }
    
    public class PeriodicDatesValidator : AbstractValidator<PeriodicDates>
    {
    
        public PeriodicDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PeriodicDates obj)
        {
            yield return CheckCardinality(Name, "StartDate", obj.StartDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EndDate", obj.EndDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PeriodFrequency", obj.PeriodFrequency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PeriodDatesAdjustments", obj.PeriodDatesAdjustments != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DayType", obj.DayType != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PeriodicDatesOnlyExistsValidator : AbstractOnlyExistsValidator<PeriodicDates> {
    
        protected override IDictionary<string, bool> GetFields(PeriodicDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "StartDate", IsSet(obj.StartDate!) },
                { "EndDate", IsSet(obj.EndDate!) },
                { "PeriodFrequency", IsSet(obj.PeriodFrequency!) },
                { "PeriodDatesAdjustments", IsSet(obj.PeriodDatesAdjustments!) },
                { "DayType", IsSet(obj.DayType!) }
            };
        }
    }
    
    public class PersonIdentifierValidator : AbstractValidator<PersonIdentifier>
    {
    
        public PersonIdentifierValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PersonIdentifier obj)
        {
            yield return CheckCardinality(Name, "IdentifierType", obj.IdentifierType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Country", obj.Country?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PersonIdentifierOnlyExistsValidator : AbstractOnlyExistsValidator<PersonIdentifier> {
    
        protected override IDictionary<string, bool> GetFields(PersonIdentifier obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Identifier", IsSet(obj.Identifier!) },
                { "IdentifierType", IsSet(obj.IdentifierType!) },
                { "Country", IsSet(obj.Country!) }
            };
        }
    }
    
    public class PhysicalSettlementPeriodValidator : AbstractValidator<PhysicalSettlementPeriod>
    {
    
        public PhysicalSettlementPeriodValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PhysicalSettlementPeriod obj)
        {
            yield return CheckCardinality(Name, "BusinessDaysNotSpecified", obj.BusinessDaysNotSpecified != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BusinessDays", obj.BusinessDays != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MaximumBusinessDays", obj.MaximumBusinessDays != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PhysicalSettlementPeriodOnlyExistsValidator : AbstractOnlyExistsValidator<PhysicalSettlementPeriod> {
    
        protected override IDictionary<string, bool> GetFields(PhysicalSettlementPeriod obj)
        {
            return new Dictionary<string, bool>()
            {
                { "BusinessDaysNotSpecified", IsSet(obj.BusinessDaysNotSpecified!) },
                { "BusinessDays", IsSet(obj.BusinessDays!) },
                { "MaximumBusinessDays", IsSet(obj.MaximumBusinessDays!) }
            };
        }
    }
    
    public class PhysicalSettlementTermsValidator : AbstractValidator<PhysicalSettlementTerms>
    {
    
        public PhysicalSettlementTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PhysicalSettlementTerms obj)
        {
            yield return CheckCardinality(Name, "ClearedPhysicalSettlement", obj.ClearedPhysicalSettlement != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PredeterminedClearingOrganizationParty", obj.PredeterminedClearingOrganizationParty != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PhysicalSettlementPeriod", obj.PhysicalSettlementPeriod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DeliverableObligations", obj.DeliverableObligations != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Escrow", obj.Escrow != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SixtyBusinessDaySettlementCap", obj.SixtyBusinessDaySettlementCap != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PhysicalSettlementTermsOnlyExistsValidator : AbstractOnlyExistsValidator<PhysicalSettlementTerms> {
    
        protected override IDictionary<string, bool> GetFields(PhysicalSettlementTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ClearedPhysicalSettlement", IsSet(obj.ClearedPhysicalSettlement!) },
                { "PredeterminedClearingOrganizationParty", IsSet(obj.PredeterminedClearingOrganizationParty!) },
                { "PhysicalSettlementPeriod", IsSet(obj.PhysicalSettlementPeriod!) },
                { "DeliverableObligations", IsSet(obj.DeliverableObligations!) },
                { "Escrow", IsSet(obj.Escrow!) },
                { "SixtyBusinessDaySettlementCap", IsSet(obj.SixtyBusinessDaySettlementCap!) }
            };
        }
    }
    
    public class PortfolioValidator : AbstractValidator<Portfolio>
    {
    
        public PortfolioValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Portfolio obj)
        {
            yield break;
        }
    }
    
    public class PortfolioOnlyExistsValidator : AbstractOnlyExistsValidator<Portfolio> {
    
        protected override IDictionary<string, bool> GetFields(Portfolio obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AggregationParameters", IsSet(obj.AggregationParameters!) },
                { "PortfolioState", IsSet(obj.PortfolioState!) }
            };
        }
    }
    
    public class PortfolioReturnTermsValidator : AbstractValidator<PortfolioReturnTerms>
    {
    
        public PortfolioReturnTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PortfolioReturnTerms obj)
        {
            yield return CheckCardinality(Name, "Underlier", obj.Underlier.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "Quantity", obj.Quantity?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InitialValuationPrice", obj.InitialValuationPrice.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "InterimValuationPrice", obj.InterimValuationPrice.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "FinalValuationPrice", obj.FinalValuationPrice.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PortfolioReturnTermsOnlyExistsValidator : AbstractOnlyExistsValidator<PortfolioReturnTerms> {
    
        protected override IDictionary<string, bool> GetFields(PortfolioReturnTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PayerReceiver", IsSet(obj.PayerReceiver!) },
                { "Underlier", IsSet(obj.Underlier!) },
                { "Quantity", IsSet(obj.Quantity!) },
                { "InitialValuationPrice", IsSet(obj.InitialValuationPrice!) },
                { "InterimValuationPrice", IsSet(obj.InterimValuationPrice!) },
                { "FinalValuationPrice", IsSet(obj.FinalValuationPrice!) }
            };
        }
    }
    
    public class PortfolioStateValidator : AbstractValidator<PortfolioState>
    {
    
        public PortfolioStateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PortfolioState obj)
        {
            yield return CheckCardinality(Name, "Positions", obj.Positions.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PortfolioStateOnlyExistsValidator : AbstractOnlyExistsValidator<PortfolioState> {
    
        protected override IDictionary<string, bool> GetFields(PortfolioState obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Positions", IsSet(obj.Positions!) },
                { "Lineage", IsSet(obj.Lineage!) }
            };
        }
    }
    
    public class PositionValidator : AbstractValidator<Position>
    {
    
        public PositionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Position obj)
        {
            yield return CheckCardinality(Name, "PriceQuantity", obj.PriceQuantity.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "CashBalance", obj.CashBalance != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "TradeReference", obj.TradeReference?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PositionOnlyExistsValidator : AbstractOnlyExistsValidator<Position> {
    
        protected override IDictionary<string, bool> GetFields(Position obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PriceQuantity", IsSet(obj.PriceQuantity!) },
                { "Product", IsSet(obj.Product!) },
                { "CashBalance", IsSet(obj.CashBalance!) },
                { "TradeReference", IsSet(obj.TradeReference!) }
            };
        }
    }
    
    public class PositionIdentifierValidator : AbstractValidator<PositionIdentifier>
    {
    
        public PositionIdentifierValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PositionIdentifier obj)
        {
            yield return CheckCardinality(Name, "IdentifierType", obj.IdentifierType != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PositionIdentifierOnlyExistsValidator : AbstractOnlyExistsValidator<PositionIdentifier> {
    
        protected override IDictionary<string, bool> GetFields(PositionIdentifier obj)
        {
            return new Dictionary<string, bool>()
            {
                { "IdentifierType", IsSet(obj.IdentifierType!) }
            };
        }
    }
    
    public class PremiumExpressionValidator : AbstractValidator<PremiumExpression>
    {
    
        public PremiumExpressionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PremiumExpression obj)
        {
            yield return CheckCardinality(Name, "PremiumType", obj.PremiumType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PricePerOption", obj.PricePerOption != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PercentageOfNotional", obj.PercentageOfNotional != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PremiumExpressionOnlyExistsValidator : AbstractOnlyExistsValidator<PremiumExpression> {
    
        protected override IDictionary<string, bool> GetFields(PremiumExpression obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PremiumType", IsSet(obj.PremiumType!) },
                { "PricePerOption", IsSet(obj.PricePerOption!) },
                { "PercentageOfNotional", IsSet(obj.PercentageOfNotional!) }
            };
        }
    }
    
    public class PricValidator : AbstractValidator<Pric>
    {
    
        public PricValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Pric obj)
        {
            yield break;
        }
    }
    
    public class PricOnlyExistsValidator : AbstractOnlyExistsValidator<Pric> {
    
        protected override IDictionary<string, bool> GetFields(Pric obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PricValue", IsSet(obj.PricValue!) },
                { "BsisPts", IsSet(obj.BsisPts!) }
            };
        }
    }
    
    public class PriceValidator : AbstractValidator<Price>
    {
    
        public PriceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Price obj)
        {
            yield break;
        }
    }
    
    public class PriceOnlyExistsValidator : AbstractOnlyExistsValidator<Price> {
    
        protected override IDictionary<string, bool> GetFields(Price obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class PriceCompositeValidator : AbstractValidator<PriceComposite>
    {
    
        public PriceCompositeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PriceComposite obj)
        {
            yield return CheckCardinality(Name, "OperandType", obj.OperandType != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PriceCompositeOnlyExistsValidator : AbstractOnlyExistsValidator<PriceComposite> {
    
        protected override IDictionary<string, bool> GetFields(PriceComposite obj)
        {
            return new Dictionary<string, bool>()
            {
                { "BaseValue", IsSet(obj.BaseValue!) },
                { "Operand", IsSet(obj.Operand!) },
                { "ArithmeticOperator", IsSet(obj.ArithmeticOperator!) },
                { "OperandType", IsSet(obj.OperandType!) }
            };
        }
    }
    
    public class PriceQuantityValidator : AbstractValidator<PriceQuantity>
    {
    
        public PriceQuantityValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PriceQuantity obj)
        {
            yield return CheckCardinality(Name, "Price", obj.Price.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Quantity", obj.Quantity.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Observable", obj.Observable?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EffectiveDate", obj.EffectiveDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PriceQuantityOnlyExistsValidator : AbstractOnlyExistsValidator<PriceQuantity> {
    
        protected override IDictionary<string, bool> GetFields(PriceQuantity obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Price", IsSet(obj.Price!) },
                { "Quantity", IsSet(obj.Quantity!) },
                { "Observable", IsSet(obj.Observable!) },
                { "EffectiveDate", IsSet(obj.EffectiveDate!) }
            };
        }
    }
    
    public class PriceReturnTermsValidator : AbstractValidator<PriceReturnTerms>
    {
    
        public PriceReturnTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PriceReturnTerms obj)
        {
            yield return CheckCardinality(Name, "ConversionFactor", obj.ConversionFactor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Performance", obj.Performance != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PriceReturnTermsOnlyExistsValidator : AbstractOnlyExistsValidator<PriceReturnTerms> {
    
        protected override IDictionary<string, bool> GetFields(PriceReturnTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ReturnType", IsSet(obj.ReturnType!) },
                { "ConversionFactor", IsSet(obj.ConversionFactor!) },
                { "Performance", IsSet(obj.Performance!) }
            };
        }
    }
    
    public class PriceScheduleValidator : AbstractValidator<PriceSchedule>
    {
    
        public PriceScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PriceSchedule obj)
        {
            yield return CheckCardinality(Name, "PerUnitOf", obj.PerUnitOf != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PriceExpression", obj.PriceExpression != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Composite", obj.Composite != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ArithmeticOperator", obj.ArithmeticOperator != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CashPrice", obj.CashPrice != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PriceScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<PriceSchedule> {
    
        protected override IDictionary<string, bool> GetFields(PriceSchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PerUnitOf", IsSet(obj.PerUnitOf!) },
                { "PriceType", IsSet(obj.PriceType!) },
                { "PriceExpression", IsSet(obj.PriceExpression!) },
                { "Composite", IsSet(obj.Composite!) },
                { "ArithmeticOperator", IsSet(obj.ArithmeticOperator!) },
                { "CashPrice", IsSet(obj.CashPrice!) }
            };
        }
    }
    
    public class PriceSourceValidator : AbstractValidator<PriceSource>
    {
    
        public PriceSourceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PriceSource obj)
        {
            yield return CheckCardinality(Name, "PriceSourceLocation", obj.PriceSourceLocation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PriceSourceHeading", obj.PriceSourceHeading != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PriceSourceTime", obj.PriceSourceTime != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PriceSourceOnlyExistsValidator : AbstractOnlyExistsValidator<PriceSource> {
    
        protected override IDictionary<string, bool> GetFields(PriceSource obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PricePublisher", IsSet(obj.PricePublisher!) },
                { "PriceSourceLocation", IsSet(obj.PriceSourceLocation!) },
                { "PriceSourceHeading", IsSet(obj.PriceSourceHeading!) },
                { "PriceSourceTime", IsSet(obj.PriceSourceTime!) }
            };
        }
    }
    
    public class PriceSourceDisruptionValidator : AbstractValidator<PriceSourceDisruption>
    {
    
        public PriceSourceDisruptionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PriceSourceDisruption obj)
        {
            yield break;
        }
    }
    
    public class PriceSourceDisruptionOnlyExistsValidator : AbstractOnlyExistsValidator<PriceSourceDisruption> {
    
        protected override IDictionary<string, bool> GetFields(PriceSourceDisruption obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FallbackReferencePrice", IsSet(obj.FallbackReferencePrice!) }
            };
        }
    }
    
    public class PricingDatesValidator : AbstractValidator<PricingDates>
    {
    
        public PricingDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PricingDates obj)
        {
            yield return CheckCardinality(Name, "SpecifiedDates", obj.SpecifiedDates.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "ParametricDates", obj.ParametricDates != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PricingDatesOnlyExistsValidator : AbstractOnlyExistsValidator<PricingDates> {
    
        protected override IDictionary<string, bool> GetFields(PricingDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SpecifiedDates", IsSet(obj.SpecifiedDates!) },
                { "ParametricDates", IsSet(obj.ParametricDates!) }
            };
        }
    }
    
    public class PrimitiveInstructionValidator : AbstractValidator<PrimitiveInstruction>
    {
    
        public PrimitiveInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PrimitiveInstruction obj)
        {
            yield return CheckCardinality(Name, "ContractFormation", obj.ContractFormation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Execution", obj.Execution != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Exercise", obj.Exercise != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PartyChange", obj.PartyChange != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "QuantityChange", obj.QuantityChange != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Reset", obj.Reset != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Split", obj.Split != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "TermsChange", obj.TermsChange != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Transfer", obj.Transfer != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IndexTransition", obj.IndexTransition != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "StockSplit", obj.StockSplit != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Observation", obj.Observation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Valuation", obj.Valuation != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PrimitiveInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<PrimitiveInstruction> {
    
        protected override IDictionary<string, bool> GetFields(PrimitiveInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ContractFormation", IsSet(obj.ContractFormation!) },
                { "Execution", IsSet(obj.Execution!) },
                { "Exercise", IsSet(obj.Exercise!) },
                { "PartyChange", IsSet(obj.PartyChange!) },
                { "QuantityChange", IsSet(obj.QuantityChange!) },
                { "Reset", IsSet(obj.Reset!) },
                { "Split", IsSet(obj.Split!) },
                { "TermsChange", IsSet(obj.TermsChange!) },
                { "Transfer", IsSet(obj.Transfer!) },
                { "IndexTransition", IsSet(obj.IndexTransition!) },
                { "StockSplit", IsSet(obj.StockSplit!) },
                { "Observation", IsSet(obj.Observation!) },
                { "Valuation", IsSet(obj.Valuation!) }
            };
        }
    }
    
    public class PrincipalPaymentValidator : AbstractValidator<PrincipalPayment>
    {
    
        public PrincipalPaymentValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PrincipalPayment obj)
        {
            yield return CheckCardinality(Name, "PrincipalPaymentDate", obj.PrincipalPaymentDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PayerReceiver", obj.PayerReceiver != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PrincipalAmount", obj.PrincipalAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DiscountFactor", obj.DiscountFactor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PresentValuePrincipalAmount", obj.PresentValuePrincipalAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PrincipalPaymentOnlyExistsValidator : AbstractOnlyExistsValidator<PrincipalPayment> {
    
        protected override IDictionary<string, bool> GetFields(PrincipalPayment obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PrincipalPaymentDate", IsSet(obj.PrincipalPaymentDate!) },
                { "PayerReceiver", IsSet(obj.PayerReceiver!) },
                { "PrincipalAmount", IsSet(obj.PrincipalAmount!) },
                { "DiscountFactor", IsSet(obj.DiscountFactor!) },
                { "PresentValuePrincipalAmount", IsSet(obj.PresentValuePrincipalAmount!) }
            };
        }
    }
    
    public class PrincipalPaymentScheduleValidator : AbstractValidator<PrincipalPaymentSchedule>
    {
    
        public PrincipalPaymentScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PrincipalPaymentSchedule obj)
        {
            yield return CheckCardinality(Name, "InitialPrincipalPayment", obj.InitialPrincipalPayment != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "IntermediatePrincipalPayment", obj.IntermediatePrincipalPayment != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FinalPrincipalPayment", obj.FinalPrincipalPayment != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PrincipalPaymentScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<PrincipalPaymentSchedule> {
    
        protected override IDictionary<string, bool> GetFields(PrincipalPaymentSchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InitialPrincipalPayment", IsSet(obj.InitialPrincipalPayment!) },
                { "IntermediatePrincipalPayment", IsSet(obj.IntermediatePrincipalPayment!) },
                { "FinalPrincipalPayment", IsSet(obj.FinalPrincipalPayment!) }
            };
        }
    }
    
    public class PrincipalPaymentsValidator : AbstractValidator<PrincipalPayments>
    {
    
        public PrincipalPaymentsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PrincipalPayments obj)
        {
            yield return CheckCardinality(Name, "VaryingLegNotionalCurrency", obj.VaryingLegNotionalCurrency.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "PrincipalPaymentSchedule", obj.PrincipalPaymentSchedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PrincipalPaymentsOnlyExistsValidator : AbstractOnlyExistsValidator<PrincipalPayments> {
    
        protected override IDictionary<string, bool> GetFields(PrincipalPayments obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InitialPayment", IsSet(obj.InitialPayment!) },
                { "FinalPayment", IsSet(obj.FinalPayment!) },
                { "IntermediatePayment", IsSet(obj.IntermediatePayment!) },
                { "VaryingLegNotionalCurrency", IsSet(obj.VaryingLegNotionalCurrency!) },
                { "PrincipalPaymentSchedule", IsSet(obj.PrincipalPaymentSchedule!) }
            };
        }
    }
    
    public class ProductValidator : AbstractValidator<Product>
    {
    
        public ProductValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Product obj)
        {
            yield return CheckCardinality(Name, "TransferableProduct", obj.TransferableProduct != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NonTransferableProduct", obj.NonTransferableProduct != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ProductOnlyExistsValidator : AbstractOnlyExistsValidator<Product> {
    
        protected override IDictionary<string, bool> GetFields(Product obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TransferableProduct", IsSet(obj.TransferableProduct!) },
                { "NonTransferableProduct", IsSet(obj.NonTransferableProduct!) }
            };
        }
    }
    
    public class ProductIdentifierValidator : AbstractValidator<ProductIdentifier>
    {
    
        public ProductIdentifierValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ProductIdentifier obj)
        {
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ProductIdentifierOnlyExistsValidator : AbstractOnlyExistsValidator<ProductIdentifier> {
    
        protected override IDictionary<string, bool> GetFields(ProductIdentifier obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Identifier", IsSet(obj.Identifier!) },
                { "Source", IsSet(obj.Source!) }
            };
        }
    }
    
    public class ProductTaxonomyValidator : AbstractValidator<ProductTaxonomy>
    {
    
        public ProductTaxonomyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ProductTaxonomy obj)
        {
            yield return CheckCardinality(Name, "PrimaryAssetClass", obj.PrimaryAssetClass?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SecondaryAssetClass", obj.SecondaryAssetClass.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "ProductQualifier", obj.ProductQualifier != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ProductTaxonomyOnlyExistsValidator : AbstractOnlyExistsValidator<ProductTaxonomy> {
    
        protected override IDictionary<string, bool> GetFields(ProductTaxonomy obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PrimaryAssetClass", IsSet(obj.PrimaryAssetClass!) },
                { "SecondaryAssetClass", IsSet(obj.SecondaryAssetClass!) },
                { "ProductQualifier", IsSet(obj.ProductQualifier!) }
            };
        }
    }
    
    public class ProtectionTermsValidator : AbstractValidator<ProtectionTerms>
    {
    
        public ProtectionTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ProtectionTerms obj)
        {
            yield return CheckCardinality(Name, "CreditEvents", obj.CreditEvents != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Obligations", obj.Obligations != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FloatingAmountEvents", obj.FloatingAmountEvents != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ProtectionTermsOnlyExistsValidator : AbstractOnlyExistsValidator<ProtectionTerms> {
    
        protected override IDictionary<string, bool> GetFields(ProtectionTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CreditEvents", IsSet(obj.CreditEvents!) },
                { "Obligations", IsSet(obj.Obligations!) },
                { "FloatingAmountEvents", IsSet(obj.FloatingAmountEvents!) }
            };
        }
    }
    
    public class PrsnValidator : AbstractValidator<Prsn>
    {
    
        public PrsnValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Prsn obj)
        {
            yield break;
        }
    }
    
    public class PrsnOnlyExistsValidator : AbstractOnlyExistsValidator<Prsn> {
    
        protected override IDictionary<string, bool> GetFields(Prsn obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CtryOfBrnch", IsSet(obj.CtryOfBrnch!) },
                { "Othr", IsSet(obj.Othr!) }
            };
        }
    }
    
    public class PubliclyAvailableInformationValidator : AbstractValidator<PubliclyAvailableInformation>
    {
    
        public PubliclyAvailableInformationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(PubliclyAvailableInformation obj)
        {
            yield return CheckCardinality(Name, "StandardPublicSources", obj.StandardPublicSources != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PublicSource", obj.PublicSource.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "SpecifiedNumber", obj.SpecifiedNumber != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class PubliclyAvailableInformationOnlyExistsValidator : AbstractOnlyExistsValidator<PubliclyAvailableInformation> {
    
        protected override IDictionary<string, bool> GetFields(PubliclyAvailableInformation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "StandardPublicSources", IsSet(obj.StandardPublicSources!) },
                { "PublicSource", IsSet(obj.PublicSource!) },
                { "SpecifiedNumber", IsSet(obj.SpecifiedNumber!) }
            };
        }
    }
    
    public class QtyValidator : AbstractValidator<Qty>
    {
    
        public QtyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Qty obj)
        {
            yield break;
        }
    }
    
    public class QtyOnlyExistsValidator : AbstractOnlyExistsValidator<Qty> {
    
        protected override IDictionary<string, bool> GetFields(Qty obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Unit", IsSet(obj.Unit!) }
            };
        }
    }
    
    public class QuantityValidator : AbstractValidator<Quantity>
    {
    
        public QuantityValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Quantity obj)
        {
            yield break;
        }
    }
    
    public class QuantityOnlyExistsValidator : AbstractOnlyExistsValidator<Quantity> {
    
        protected override IDictionary<string, bool> GetFields(Quantity obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class QuantityChangeInstructionValidator : AbstractValidator<QuantityChangeInstruction>
    {
    
        public QuantityChangeInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(QuantityChangeInstruction obj)
        {
            yield return CheckCardinality(Name, "Change", obj.Change.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "LotIdentifier", obj.LotIdentifier.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class QuantityChangeInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<QuantityChangeInstruction> {
    
        protected override IDictionary<string, bool> GetFields(QuantityChangeInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Change", IsSet(obj.Change!) },
                { "Direction", IsSet(obj.Direction!) },
                { "LotIdentifier", IsSet(obj.LotIdentifier!) }
            };
        }
    }
    
    public class QuantityMultiplierValidator : AbstractValidator<QuantityMultiplier>
    {
    
        public QuantityMultiplierValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(QuantityMultiplier obj)
        {
            yield return CheckCardinality(Name, "FxLinkedNotionalSchedule", obj.FxLinkedNotionalSchedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MultiplierValue", obj.MultiplierValue != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class QuantityMultiplierOnlyExistsValidator : AbstractOnlyExistsValidator<QuantityMultiplier> {
    
        protected override IDictionary<string, bool> GetFields(QuantityMultiplier obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FxLinkedNotionalSchedule", IsSet(obj.FxLinkedNotionalSchedule!) },
                { "MultiplierValue", IsSet(obj.MultiplierValue!) }
            };
        }
    }
    
    public class QuantityScheduleValidator : AbstractValidator<QuantitySchedule>
    {
    
        public QuantityScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(QuantitySchedule obj)
        {
            yield return CheckCardinality(Name, "Multiplier", obj.Multiplier != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Frequency", obj.Frequency != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class QuantityScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<QuantitySchedule> {
    
        protected override IDictionary<string, bool> GetFields(QuantitySchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Multiplier", IsSet(obj.Multiplier!) },
                { "Frequency", IsSet(obj.Frequency!) }
            };
        }
    }
    
    public class QuantoValidator : AbstractValidator<Quanto>
    {
    
        public QuantoValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Quanto obj)
        {
            yield return CheckCardinality(Name, "FxRate", obj.FxRate.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "FxSpotRateSource", obj.FxSpotRateSource != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FixingTime", obj.FixingTime != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class QuantoOnlyExistsValidator : AbstractOnlyExistsValidator<Quanto> {
    
        protected override IDictionary<string, bool> GetFields(Quanto obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FxRate", IsSet(obj.FxRate!) },
                { "FxSpotRateSource", IsSet(obj.FxSpotRateSource!) },
                { "FixingTime", IsSet(obj.FixingTime!) }
            };
        }
    }
    
    public class QuasiGovernmentIssuerTypeValidator : AbstractValidator<QuasiGovernmentIssuerType>
    {
    
        public QuasiGovernmentIssuerTypeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(QuasiGovernmentIssuerType obj)
        {
            yield return CheckCardinality(Name, "SovereignRecourse", obj.SovereignRecourse != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class QuasiGovernmentIssuerTypeOnlyExistsValidator : AbstractOnlyExistsValidator<QuasiGovernmentIssuerType> {
    
        protected override IDictionary<string, bool> GetFields(QuasiGovernmentIssuerType obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SovereignEntity", IsSet(obj.SovereignEntity!) },
                { "SovereignRecourse", IsSet(obj.SovereignRecourse!) }
            };
        }
    }
    
    public class QuotedCurrencyPairValidator : AbstractValidator<QuotedCurrencyPair>
    {
    
        public QuotedCurrencyPairValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(QuotedCurrencyPair obj)
        {
            yield break;
        }
    }
    
    public class QuotedCurrencyPairOnlyExistsValidator : AbstractOnlyExistsValidator<QuotedCurrencyPair> {
    
        protected override IDictionary<string, bool> GetFields(QuotedCurrencyPair obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Currency1", IsSet(obj.Currency1!) },
                { "Currency2", IsSet(obj.Currency2!) },
                { "QuoteBasis", IsSet(obj.QuoteBasis!) }
            };
        }
    }
    
    public class RateObservationValidator : AbstractValidator<RateObservation>
    {
    
        public RateObservationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(RateObservation obj)
        {
            yield return CheckCardinality(Name, "ResetDate", obj.ResetDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdjustedFixingDate", obj.AdjustedFixingDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ObservedRate", obj.ObservedRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "TreatedRate", obj.TreatedRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ObservationWeight", obj.ObservationWeight != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RateReference", obj.RateReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ForecastRate", obj.ForecastRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "TreatedForecastRate", obj.TreatedForecastRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class RateObservationOnlyExistsValidator : AbstractOnlyExistsValidator<RateObservation> {
    
        protected override IDictionary<string, bool> GetFields(RateObservation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ResetDate", IsSet(obj.ResetDate!) },
                { "AdjustedFixingDate", IsSet(obj.AdjustedFixingDate!) },
                { "ObservedRate", IsSet(obj.ObservedRate!) },
                { "TreatedRate", IsSet(obj.TreatedRate!) },
                { "ObservationWeight", IsSet(obj.ObservationWeight!) },
                { "RateReference", IsSet(obj.RateReference!) },
                { "ForecastRate", IsSet(obj.ForecastRate!) },
                { "TreatedForecastRate", IsSet(obj.TreatedForecastRate!) }
            };
        }
    }
    
    public class RateScheduleValidator : AbstractValidator<RateSchedule>
    {
    
        public RateScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(RateSchedule obj)
        {
            yield return CheckCardinality(Name, "Price", obj.Price.Value != null ? 1 : 0, 1, 1);
            yield break;
        }
    }
    
    public class RateScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<RateSchedule> {
    
        protected override IDictionary<string, bool> GetFields(RateSchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Price", IsSet(obj.Price!) }
            };
        }
    }
    
    public class RateSpecificationValidator : AbstractValidator<RateSpecification>
    {
    
        public RateSpecificationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(RateSpecification obj)
        {
            yield return CheckCardinality(Name, "FixedRateSpecification", obj.FixedRateSpecification != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FloatingRateSpecification", obj.FloatingRateSpecification != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InflationRateSpecification", obj.InflationRateSpecification != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class RateSpecificationOnlyExistsValidator : AbstractOnlyExistsValidator<RateSpecification> {
    
        protected override IDictionary<string, bool> GetFields(RateSpecification obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FixedRateSpecification", IsSet(obj.FixedRateSpecification!) },
                { "FloatingRateSpecification", IsSet(obj.FloatingRateSpecification!) },
                { "InflationRateSpecification", IsSet(obj.InflationRateSpecification!) }
            };
        }
    }
    
    public class RefRateValidator : AbstractValidator<RefRate>
    {
    
        public RefRateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(RefRate obj)
        {
            yield break;
        }
    }
    
    public class RefRateOnlyExistsValidator : AbstractOnlyExistsValidator<RefRate> {
    
        protected override IDictionary<string, bool> GetFields(RefRate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Indx", IsSet(obj.Indx!) },
                { "Nm", IsSet(obj.Nm!) }
            };
        }
    }
    
    public class ReferenceBankValidator : AbstractValidator<ReferenceBank>
    {
    
        public ReferenceBankValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ReferenceBank obj)
        {
            yield return CheckCardinality(Name, "ReferenceBankName", obj.ReferenceBankName != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ReferenceBankOnlyExistsValidator : AbstractOnlyExistsValidator<ReferenceBank> {
    
        protected override IDictionary<string, bool> GetFields(ReferenceBank obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ReferenceBankId", IsSet(obj.ReferenceBankId!) },
                { "ReferenceBankName", IsSet(obj.ReferenceBankName!) }
            };
        }
    }
    
    public class ReferenceBanksValidator : AbstractValidator<ReferenceBanks>
    {
    
        public ReferenceBanksValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ReferenceBanks obj)
        {
            yield return CheckCardinality(Name, "ReferenceBank", obj.ReferenceBank.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class ReferenceBanksOnlyExistsValidator : AbstractOnlyExistsValidator<ReferenceBanks> {
    
        protected override IDictionary<string, bool> GetFields(ReferenceBanks obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ReferenceBank", IsSet(obj.ReferenceBank!) }
            };
        }
    }
    
    public class ReferenceInformationValidator : AbstractValidator<ReferenceInformation>
    {
    
        public ReferenceInformationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ReferenceInformation obj)
        {
            yield return CheckCardinality(Name, "ReferenceObligation", obj.ReferenceObligation.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "NoReferenceObligation", obj.NoReferenceObligation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "UnknownReferenceObligation", obj.UnknownReferenceObligation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AllGuarantees", obj.AllGuarantees != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ReferencePrice", obj.ReferencePrice != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ReferencePolicy", obj.ReferencePolicy != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SecuredList", obj.SecuredList != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ReferenceInformationOnlyExistsValidator : AbstractOnlyExistsValidator<ReferenceInformation> {
    
        protected override IDictionary<string, bool> GetFields(ReferenceInformation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ReferenceEntity", IsSet(obj.ReferenceEntity!) },
                { "ReferenceObligation", IsSet(obj.ReferenceObligation!) },
                { "NoReferenceObligation", IsSet(obj.NoReferenceObligation!) },
                { "UnknownReferenceObligation", IsSet(obj.UnknownReferenceObligation!) },
                { "AllGuarantees", IsSet(obj.AllGuarantees!) },
                { "ReferencePrice", IsSet(obj.ReferencePrice!) },
                { "ReferencePolicy", IsSet(obj.ReferencePolicy!) },
                { "SecuredList", IsSet(obj.SecuredList!) }
            };
        }
    }
    
    public class ReferenceObligationValidator : AbstractValidator<ReferenceObligation>
    {
    
        public ReferenceObligationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ReferenceObligation obj)
        {
            yield return CheckCardinality(Name, "Security", obj.Security != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Loan", obj.Loan != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PrimaryObligor", obj.PrimaryObligor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PrimaryObligorReference", obj.PrimaryObligorReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Guarantor", obj.Guarantor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "GuarantorReference", obj.GuarantorReference != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "StandardReferenceObligation", obj.StandardReferenceObligation != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ReferenceObligationOnlyExistsValidator : AbstractOnlyExistsValidator<ReferenceObligation> {
    
        protected override IDictionary<string, bool> GetFields(ReferenceObligation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Security", IsSet(obj.Security!) },
                { "Loan", IsSet(obj.Loan!) },
                { "PrimaryObligor", IsSet(obj.PrimaryObligor!) },
                { "PrimaryObligorReference", IsSet(obj.PrimaryObligorReference!) },
                { "Guarantor", IsSet(obj.Guarantor!) },
                { "GuarantorReference", IsSet(obj.GuarantorReference!) },
                { "StandardReferenceObligation", IsSet(obj.StandardReferenceObligation!) }
            };
        }
    }
    
    public class ReferencePairValidator : AbstractValidator<ReferencePair>
    {
    
        public ReferencePairValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ReferencePair obj)
        {
            yield return CheckCardinality(Name, "ReferenceObligation", obj.ReferenceObligation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NoReferenceObligation", obj.NoReferenceObligation != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ReferencePairOnlyExistsValidator : AbstractOnlyExistsValidator<ReferencePair> {
    
        protected override IDictionary<string, bool> GetFields(ReferencePair obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ReferenceEntity", IsSet(obj.ReferenceEntity!) },
                { "ReferenceObligation", IsSet(obj.ReferenceObligation!) },
                { "NoReferenceObligation", IsSet(obj.NoReferenceObligation!) },
                { "EntityType", IsSet(obj.EntityType!) }
            };
        }
    }
    
    public class ReferencePoolValidator : AbstractValidator<ReferencePool>
    {
    
        public ReferencePoolValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ReferencePool obj)
        {
            yield return CheckCardinality(Name, "ReferencePoolItem", obj.ReferencePoolItem.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class ReferencePoolOnlyExistsValidator : AbstractOnlyExistsValidator<ReferencePool> {
    
        protected override IDictionary<string, bool> GetFields(ReferencePool obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ReferencePoolItem", IsSet(obj.ReferencePoolItem!) }
            };
        }
    }
    
    public class ReferencePoolItemValidator : AbstractValidator<ReferencePoolItem>
    {
    
        public ReferencePoolItemValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ReferencePoolItem obj)
        {
            yield return CheckCardinality(Name, "ConstituentWeight", obj.ConstituentWeight != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ProtectionTermsReference", obj.ProtectionTermsReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CashSettlementTermsReference", obj.CashSettlementTermsReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PhysicalSettlementTermsReference", obj.PhysicalSettlementTermsReference?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ReferencePoolItemOnlyExistsValidator : AbstractOnlyExistsValidator<ReferencePoolItem> {
    
        protected override IDictionary<string, bool> GetFields(ReferencePoolItem obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ConstituentWeight", IsSet(obj.ConstituentWeight!) },
                { "ReferencePair", IsSet(obj.ReferencePair!) },
                { "ProtectionTermsReference", IsSet(obj.ProtectionTermsReference!) },
                { "CashSettlementTermsReference", IsSet(obj.CashSettlementTermsReference!) },
                { "PhysicalSettlementTermsReference", IsSet(obj.PhysicalSettlementTermsReference!) }
            };
        }
    }
    
    public class ReferenceSwapCurveValidator : AbstractValidator<ReferenceSwapCurve>
    {
    
        public ReferenceSwapCurveValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ReferenceSwapCurve obj)
        {
            yield return CheckCardinality(Name, "MakeWholeAmount", obj.MakeWholeAmount != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ReferenceSwapCurveOnlyExistsValidator : AbstractOnlyExistsValidator<ReferenceSwapCurve> {
    
        protected override IDictionary<string, bool> GetFields(ReferenceSwapCurve obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SwapUnwindValue", IsSet(obj.SwapUnwindValue!) },
                { "MakeWholeAmount", IsSet(obj.MakeWholeAmount!) }
            };
        }
    }
    
    public class RegionalGovernmentIssuerTypeValidator : AbstractValidator<RegionalGovernmentIssuerType>
    {
    
        public RegionalGovernmentIssuerTypeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(RegionalGovernmentIssuerType obj)
        {
            yield break;
        }
    }
    
    public class RegionalGovernmentIssuerTypeOnlyExistsValidator : AbstractOnlyExistsValidator<RegionalGovernmentIssuerType> {
    
        protected override IDictionary<string, bool> GetFields(RegionalGovernmentIssuerType obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SovereignRecourse", IsSet(obj.SovereignRecourse!) }
            };
        }
    }
    
    public class RelatedPartyValidator : AbstractValidator<RelatedParty>
    {
    
        public RelatedPartyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(RelatedParty obj)
        {
            yield return CheckCardinality(Name, "PartyReference", obj.PartyReference.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "AccountReference", obj.AccountReference?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class RelatedPartyOnlyExistsValidator : AbstractOnlyExistsValidator<RelatedParty> {
    
        protected override IDictionary<string, bool> GetFields(RelatedParty obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PartyReference", IsSet(obj.PartyReference!) },
                { "AccountReference", IsSet(obj.AccountReference!) },
                { "Role", IsSet(obj.Role!) }
            };
        }
    }
    
    public class RelativeDateOffsetValidator : AbstractValidator<RelativeDateOffset>
    {
    
        public RelativeDateOffsetValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(RelativeDateOffset obj)
        {
            yield return CheckCardinality(Name, "BusinessCenters", obj.BusinessCenters != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BusinessCentersReference", obj.BusinessCentersReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DateRelativeTo", obj.DateRelativeTo?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdjustedDate", obj.AdjustedDate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class RelativeDateOffsetOnlyExistsValidator : AbstractOnlyExistsValidator<RelativeDateOffset> {
    
        protected override IDictionary<string, bool> GetFields(RelativeDateOffset obj)
        {
            return new Dictionary<string, bool>()
            {
                { "BusinessDayConvention", IsSet(obj.BusinessDayConvention!) },
                { "BusinessCenters", IsSet(obj.BusinessCenters!) },
                { "BusinessCentersReference", IsSet(obj.BusinessCentersReference!) },
                { "DateRelativeTo", IsSet(obj.DateRelativeTo!) },
                { "AdjustedDate", IsSet(obj.AdjustedDate!) }
            };
        }
    }
    
    public class RelativeDatesValidator : AbstractValidator<RelativeDates>
    {
    
        public RelativeDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(RelativeDates obj)
        {
            yield return CheckCardinality(Name, "PeriodSkip", obj.PeriodSkip != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ScheduleBounds", obj.ScheduleBounds != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class RelativeDatesOnlyExistsValidator : AbstractOnlyExistsValidator<RelativeDates> {
    
        protected override IDictionary<string, bool> GetFields(RelativeDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PeriodSkip", IsSet(obj.PeriodSkip!) },
                { "ScheduleBounds", IsSet(obj.ScheduleBounds!) }
            };
        }
    }
    
    public class RepresentationsValidator : AbstractValidator<Representations>
    {
    
        public RepresentationsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Representations obj)
        {
            yield break;
        }
    }
    
    public class RepresentationsOnlyExistsValidator : AbstractOnlyExistsValidator<Representations> {
    
        protected override IDictionary<string, bool> GetFields(Representations obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class ResetValidator : AbstractValidator<Reset>
    {
    
        public ResetValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Reset obj)
        {
            yield return CheckCardinality(Name, "RateRecordDate", obj.RateRecordDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Observations", obj.Observations.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "AveragingMethodology", obj.AveragingMethodology != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ResetOnlyExistsValidator : AbstractOnlyExistsValidator<Reset> {
    
        protected override IDictionary<string, bool> GetFields(Reset obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ResetValue", IsSet(obj.ResetValue!) },
                { "ResetDate", IsSet(obj.ResetDate!) },
                { "RateRecordDate", IsSet(obj.RateRecordDate!) },
                { "Observations", IsSet(obj.Observations!) },
                { "AveragingMethodology", IsSet(obj.AveragingMethodology!) }
            };
        }
    }
    
    public class ResetDatesValidator : AbstractValidator<ResetDates>
    {
    
        public ResetDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ResetDates obj)
        {
            yield return CheckCardinality(Name, "CalculationPeriodDatesReference", obj.CalculationPeriodDatesReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ResetRelativeTo", obj.ResetRelativeTo != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InitialFixingDate", obj.InitialFixingDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FixingDates", obj.FixingDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FinalFixingDate", obj.FinalFixingDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "RateCutOffDaysOffset", obj.RateCutOffDaysOffset != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ResetFrequency", obj.ResetFrequency != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ResetDatesAdjustments", obj.ResetDatesAdjustments != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ResetDatesOnlyExistsValidator : AbstractOnlyExistsValidator<ResetDates> {
    
        protected override IDictionary<string, bool> GetFields(ResetDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CalculationPeriodDatesReference", IsSet(obj.CalculationPeriodDatesReference!) },
                { "ResetRelativeTo", IsSet(obj.ResetRelativeTo!) },
                { "InitialFixingDate", IsSet(obj.InitialFixingDate!) },
                { "FixingDates", IsSet(obj.FixingDates!) },
                { "FinalFixingDate", IsSet(obj.FinalFixingDate!) },
                { "RateCutOffDaysOffset", IsSet(obj.RateCutOffDaysOffset!) },
                { "ResetFrequency", IsSet(obj.ResetFrequency!) },
                { "ResetDatesAdjustments", IsSet(obj.ResetDatesAdjustments!) }
            };
        }
    }
    
    public class ResetFrequencyValidator : AbstractValidator<ResetFrequency>
    {
    
        public ResetFrequencyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ResetFrequency obj)
        {
            yield return CheckCardinality(Name, "WeeklyRollConvention", obj.WeeklyRollConvention != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ResetFrequencyOnlyExistsValidator : AbstractOnlyExistsValidator<ResetFrequency> {
    
        protected override IDictionary<string, bool> GetFields(ResetFrequency obj)
        {
            return new Dictionary<string, bool>()
            {
                { "WeeklyRollConvention", IsSet(obj.WeeklyRollConvention!) }
            };
        }
    }
    
    public class ResetInstructionValidator : AbstractValidator<ResetInstruction>
    {
    
        public ResetInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ResetInstruction obj)
        {
            yield return CheckCardinality(Name, "Payout", obj.Payout.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "RateRecordDate", obj.RateRecordDate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ResetInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<ResetInstruction> {
    
        protected override IDictionary<string, bool> GetFields(ResetInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Payout", IsSet(obj.Payout!) },
                { "RateRecordDate", IsSet(obj.RateRecordDate!) },
                { "ResetDate", IsSet(obj.ResetDate!) }
            };
        }
    }
    
    public class ResolvablePriceQuantityValidator : AbstractValidator<ResolvablePriceQuantity>
    {
    
        public ResolvablePriceQuantityValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ResolvablePriceQuantity obj)
        {
            yield return CheckCardinality(Name, "ResolvedQuantity", obj.ResolvedQuantity != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "QuantitySchedule", obj.QuantitySchedule?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "QuantityReference", obj.QuantityReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "QuantityMultiplier", obj.QuantityMultiplier != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Reset", obj.Reset != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FutureValueNotional", obj.FutureValueNotional != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PriceSchedule", obj.PriceSchedule.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ResolvablePriceQuantityOnlyExistsValidator : AbstractOnlyExistsValidator<ResolvablePriceQuantity> {
    
        protected override IDictionary<string, bool> GetFields(ResolvablePriceQuantity obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ResolvedQuantity", IsSet(obj.ResolvedQuantity!) },
                { "QuantitySchedule", IsSet(obj.QuantitySchedule!) },
                { "QuantityReference", IsSet(obj.QuantityReference!) },
                { "QuantityMultiplier", IsSet(obj.QuantityMultiplier!) },
                { "Reset", IsSet(obj.Reset!) },
                { "FutureValueNotional", IsSet(obj.FutureValueNotional!) },
                { "PriceSchedule", IsSet(obj.PriceSchedule!) }
            };
        }
    }
    
    public class ResourceValidator : AbstractValidator<Resource>
    {
    
        public ResourceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Resource obj)
        {
            yield return CheckCardinality(Name, "ResourceType", obj.ResourceType?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Language", obj.Language?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SizeInBytes", obj.SizeInBytes != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Length", obj.Length != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MimeType", obj.MimeType?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Name", obj.Name != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Comments", obj.Comments != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "String", obj.String != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Url", obj.Url != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ResourceOnlyExistsValidator : AbstractOnlyExistsValidator<Resource> {
    
        protected override IDictionary<string, bool> GetFields(Resource obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ResourceId", IsSet(obj.ResourceId!) },
                { "ResourceType", IsSet(obj.ResourceType!) },
                { "Language", IsSet(obj.Language!) },
                { "SizeInBytes", IsSet(obj.SizeInBytes!) },
                { "Length", IsSet(obj.Length!) },
                { "MimeType", IsSet(obj.MimeType!) },
                { "Name", IsSet(obj.Name!) },
                { "Comments", IsSet(obj.Comments!) },
                { "String", IsSet(obj.String!) },
                { "Url", IsSet(obj.Url!) }
            };
        }
    }
    
    public class ResourceLengthValidator : AbstractValidator<ResourceLength>
    {
    
        public ResourceLengthValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ResourceLength obj)
        {
            yield break;
        }
    }
    
    public class ResourceLengthOnlyExistsValidator : AbstractOnlyExistsValidator<ResourceLength> {
    
        protected override IDictionary<string, bool> GetFields(ResourceLength obj)
        {
            return new Dictionary<string, bool>()
            {
                { "LengthUnit", IsSet(obj.LengthUnit!) },
                { "LengthValue", IsSet(obj.LengthValue!) }
            };
        }
    }
    
    public class RestructuringValidator : AbstractValidator<Restructuring>
    {
    
        public RestructuringValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Restructuring obj)
        {
            yield return CheckCardinality(Name, "RestructuringType", obj.RestructuringType?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MultipleHolderObligation", obj.MultipleHolderObligation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MultipleCreditEventNotices", obj.MultipleCreditEventNotices != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class RestructuringOnlyExistsValidator : AbstractOnlyExistsValidator<Restructuring> {
    
        protected override IDictionary<string, bool> GetFields(Restructuring obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Applicable", IsSet(obj.Applicable!) },
                { "RestructuringType", IsSet(obj.RestructuringType!) },
                { "MultipleHolderObligation", IsSet(obj.MultipleHolderObligation!) },
                { "MultipleCreditEventNotices", IsSet(obj.MultipleCreditEventNotices!) }
            };
        }
    }
    
    public class ReturnAmountValidator : AbstractValidator<ReturnAmount>
    {
    
        public ReturnAmountValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ReturnAmount obj)
        {
            yield return CheckCardinality(Name, "IncludesDefaultLanguage", obj.IncludesDefaultLanguage != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CustomElection", obj.CustomElection != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ReturnAmountOnlyExistsValidator : AbstractOnlyExistsValidator<ReturnAmount> {
    
        protected override IDictionary<string, bool> GetFields(ReturnAmount obj)
        {
            return new Dictionary<string, bool>()
            {
                { "IncludesDefaultLanguage", IsSet(obj.IncludesDefaultLanguage!) },
                { "CustomElection", IsSet(obj.CustomElection!) }
            };
        }
    }
    
    public class ReturnInstructionValidator : AbstractValidator<ReturnInstruction>
    {
    
        public ReturnInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ReturnInstruction obj)
        {
            yield return CheckCardinality(Name, "Quantity", obj.Quantity.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class ReturnInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<ReturnInstruction> {
    
        protected override IDictionary<string, bool> GetFields(ReturnInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Quantity", IsSet(obj.Quantity!) }
            };
        }
    }
    
    public class ReturnTermsValidator : AbstractValidator<ReturnTerms>
    {
    
        public ReturnTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ReturnTerms obj)
        {
            yield return CheckCardinality(Name, "PriceReturnTerms", obj.PriceReturnTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DividendReturnTerms", obj.DividendReturnTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "VarianceReturnTerms", obj.VarianceReturnTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "VolatilityReturnTerms", obj.VolatilityReturnTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CorrelationReturnTerms", obj.CorrelationReturnTerms != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ReturnTermsOnlyExistsValidator : AbstractOnlyExistsValidator<ReturnTerms> {
    
        protected override IDictionary<string, bool> GetFields(ReturnTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PriceReturnTerms", IsSet(obj.PriceReturnTerms!) },
                { "DividendReturnTerms", IsSet(obj.DividendReturnTerms!) },
                { "VarianceReturnTerms", IsSet(obj.VarianceReturnTerms!) },
                { "VolatilityReturnTerms", IsSet(obj.VolatilityReturnTerms!) },
                { "CorrelationReturnTerms", IsSet(obj.CorrelationReturnTerms!) }
            };
        }
    }
    
    public class ReturnTermsBaseValidator : AbstractValidator<ReturnTermsBase>
    {
    
        public ReturnTermsBaseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ReturnTermsBase obj)
        {
            yield return CheckCardinality(Name, "AnnualizationFactor", obj.AnnualizationFactor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DividendApplicability", obj.DividendApplicability != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EquityUnderlierProvisions", obj.EquityUnderlierProvisions != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SharePriceDividendAdjustment", obj.SharePriceDividendAdjustment != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InitialLevel", obj.InitialLevel != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InitialLevelSource", obj.InitialLevelSource != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MeanAdjustment", obj.MeanAdjustment != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Performance", obj.Performance != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ReturnTermsBaseOnlyExistsValidator : AbstractOnlyExistsValidator<ReturnTermsBase> {
    
        protected override IDictionary<string, bool> GetFields(ReturnTermsBase obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ValuationTerms", IsSet(obj.ValuationTerms!) },
                { "AnnualizationFactor", IsSet(obj.AnnualizationFactor!) },
                { "DividendApplicability", IsSet(obj.DividendApplicability!) },
                { "EquityUnderlierProvisions", IsSet(obj.EquityUnderlierProvisions!) },
                { "SharePriceDividendAdjustment", IsSet(obj.SharePriceDividendAdjustment!) },
                { "ExpectedN", IsSet(obj.ExpectedN!) },
                { "InitialLevel", IsSet(obj.InitialLevel!) },
                { "InitialLevelSource", IsSet(obj.InitialLevelSource!) },
                { "MeanAdjustment", IsSet(obj.MeanAdjustment!) },
                { "Performance", IsSet(obj.Performance!) }
            };
        }
    }
    
    public class RollFeatureValidator : AbstractValidator<RollFeature>
    {
    
        public RollFeatureValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(RollFeature obj)
        {
            yield return CheckCardinality(Name, "RollSourceCalendar", obj.RollSourceCalendar != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DeliveryDateRollConvention", obj.DeliveryDateRollConvention != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class RollFeatureOnlyExistsValidator : AbstractOnlyExistsValidator<RollFeature> {
    
        protected override IDictionary<string, bool> GetFields(RollFeature obj)
        {
            return new Dictionary<string, bool>()
            {
                { "RollSourceCalendar", IsSet(obj.RollSourceCalendar!) },
                { "DeliveryDateRollConvention", IsSet(obj.DeliveryDateRollConvention!) }
            };
        }
    }
    
    public class RoundingValidator : AbstractValidator<Rounding>
    {
    
        public RoundingValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Rounding obj)
        {
            yield return CheckCardinality(Name, "Precision", obj.Precision != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class RoundingOnlyExistsValidator : AbstractOnlyExistsValidator<Rounding> {
    
        protected override IDictionary<string, bool> GetFields(Rounding obj)
        {
            return new Dictionary<string, bool>()
            {
                { "RoundingDirection", IsSet(obj.RoundingDirection!) },
                { "Precision", IsSet(obj.Precision!) }
            };
        }
    }
    
    public class ScheduleValidator : AbstractValidator<Schedule>
    {
    
        public ScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Schedule obj)
        {
            yield return CheckCardinality(Name, "DatedValue", obj.DatedValue.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class ScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<Schedule> {
    
        protected override IDictionary<string, bool> GetFields(Schedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Value", IsSet(obj.Value!) },
                { "DatedValue", IsSet(obj.DatedValue!) }
            };
        }
    }
    
    public class SchedulePeriodValidator : AbstractValidator<SchedulePeriod>
    {
    
        public SchedulePeriodValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SchedulePeriod obj)
        {
            yield return CheckCardinality(Name, "DeliveryPeriod", obj.DeliveryPeriod != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SchedulePeriodOnlyExistsValidator : AbstractOnlyExistsValidator<SchedulePeriod> {
    
        protected override IDictionary<string, bool> GetFields(SchedulePeriod obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CalculationPeriod", IsSet(obj.CalculationPeriod!) },
                { "PaymentDate", IsSet(obj.PaymentDate!) },
                { "FixingPeriod", IsSet(obj.FixingPeriod!) },
                { "DeliveryPeriod", IsSet(obj.DeliveryPeriod!) }
            };
        }
    }
    
    public class ScheduledTransferValidator : AbstractValidator<ScheduledTransfer>
    {
    
        public ScheduledTransferValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ScheduledTransfer obj)
        {
            yield return CheckCardinality(Name, "CorporateActionTransferType", obj.CorporateActionTransferType != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ScheduledTransferOnlyExistsValidator : AbstractOnlyExistsValidator<ScheduledTransfer> {
    
        protected override IDictionary<string, bool> GetFields(ScheduledTransfer obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TransferType", IsSet(obj.TransferType!) },
                { "CorporateActionTransferType", IsSet(obj.CorporateActionTransferType!) }
            };
        }
    }
    
    public class SchmeNmValidator : AbstractValidator<SchmeNm>
    {
    
        public SchmeNmValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SchmeNm obj)
        {
            yield break;
        }
    }
    
    public class SchmeNmOnlyExistsValidator : AbstractOnlyExistsValidator<SchmeNm> {
    
        protected override IDictionary<string, bool> GetFields(SchmeNm obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Prtry", IsSet(obj.Prtry!) }
            };
        }
    }
    
    public class SecurityValidator : AbstractValidator<Security>
    {
    
        public SecurityValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Security obj)
        {
            yield return CheckCardinality(Name, "DebtType", obj.DebtType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EquityType", obj.EquityType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FundType", obj.FundType != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SecurityOnlyExistsValidator : AbstractOnlyExistsValidator<Security> {
    
        protected override IDictionary<string, bool> GetFields(Security obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DebtType", IsSet(obj.DebtType!) },
                { "EquityType", IsSet(obj.EquityType!) },
                { "FundType", IsSet(obj.FundType!) }
            };
        }
    }
    
    public class SecurityAgreementElectionsValidator : AbstractValidator<SecurityAgreementElections>
    {
    
        public SecurityAgreementElectionsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SecurityAgreementElections obj)
        {
            yield break;
        }
    }
    
    public class SecurityAgreementElectionsOnlyExistsValidator : AbstractOnlyExistsValidator<SecurityAgreementElections> {
    
        protected override IDictionary<string, bool> GetFields(SecurityAgreementElections obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class SecurityLendingInvoiceValidator : AbstractValidator<SecurityLendingInvoice>
    {
    
        public SecurityLendingInvoiceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SecurityLendingInvoice obj)
        {
            yield return CheckCardinality(Name, "BillingRecord", obj.BillingRecord.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "BillingSummary", obj.BillingSummary.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SecurityLendingInvoiceOnlyExistsValidator : AbstractOnlyExistsValidator<SecurityLendingInvoice> {
    
        protected override IDictionary<string, bool> GetFields(SecurityLendingInvoice obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SendingParty", IsSet(obj.SendingParty!) },
                { "ReceivingParty", IsSet(obj.ReceivingParty!) },
                { "BillingStartDate", IsSet(obj.BillingStartDate!) },
                { "BillingEndDate", IsSet(obj.BillingEndDate!) },
                { "BillingRecord", IsSet(obj.BillingRecord!) },
                { "BillingSummary", IsSet(obj.BillingSummary!) }
            };
        }
    }
    
    public class SecurityLocateValidator : AbstractValidator<SecurityLocate>
    {
    
        public SecurityLocateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SecurityLocate obj)
        {
            yield break;
        }
    }
    
    public class SecurityLocateOnlyExistsValidator : AbstractOnlyExistsValidator<SecurityLocate> {
    
        protected override IDictionary<string, bool> GetFields(SecurityLocate obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class SellrValidator : AbstractValidator<Sellr>
    {
    
        public SellrValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Sellr obj)
        {
            yield break;
        }
    }
    
    public class SellrOnlyExistsValidator : AbstractOnlyExistsValidator<Sellr> {
    
        protected override IDictionary<string, bool> GetFields(Sellr obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AcctOwnr", IsSet(obj.AcctOwnr!) }
            };
        }
    }
    
    public class SettledEntityMatrixValidator : AbstractValidator<SettledEntityMatrix>
    {
    
        public SettledEntityMatrixValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SettledEntityMatrix obj)
        {
            yield return CheckCardinality(Name, "PublicationDate", obj.PublicationDate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SettledEntityMatrixOnlyExistsValidator : AbstractOnlyExistsValidator<SettledEntityMatrix> {
    
        protected override IDictionary<string, bool> GetFields(SettledEntityMatrix obj)
        {
            return new Dictionary<string, bool>()
            {
                { "MatrixSource", IsSet(obj.MatrixSource!) },
                { "PublicationDate", IsSet(obj.PublicationDate!) }
            };
        }
    }
    
    public class SettlementBaseValidator : AbstractValidator<SettlementBase>
    {
    
        public SettlementBaseValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SettlementBase obj)
        {
            yield return CheckCardinality(Name, "TransferSettlementType", obj.TransferSettlementType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SettlementCurrency", obj.SettlementCurrency?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SettlementDate", obj.SettlementDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SettlementCentre", obj.SettlementCentre != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SettlementProvision", obj.SettlementProvision != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "StandardSettlementStyle", obj.StandardSettlementStyle != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SettlementBaseOnlyExistsValidator : AbstractOnlyExistsValidator<SettlementBase> {
    
        protected override IDictionary<string, bool> GetFields(SettlementBase obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SettlementType", IsSet(obj.SettlementType!) },
                { "TransferSettlementType", IsSet(obj.TransferSettlementType!) },
                { "SettlementCurrency", IsSet(obj.SettlementCurrency!) },
                { "SettlementDate", IsSet(obj.SettlementDate!) },
                { "SettlementCentre", IsSet(obj.SettlementCentre!) },
                { "SettlementProvision", IsSet(obj.SettlementProvision!) },
                { "StandardSettlementStyle", IsSet(obj.StandardSettlementStyle!) }
            };
        }
    }
    
    public class SettlementDateValidator : AbstractValidator<SettlementDate>
    {
    
        public SettlementDateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SettlementDate obj)
        {
            yield return CheckCardinality(Name, "AdjustableOrRelativeDate", obj.AdjustableOrRelativeDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ValueDate", obj.ValueDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AdjustableDates", obj.AdjustableDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BusinessDateRange", obj.BusinessDateRange != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CashSettlementBusinessDays", obj.CashSettlementBusinessDays != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PaymentDelay", obj.PaymentDelay != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SettlementDateOnlyExistsValidator : AbstractOnlyExistsValidator<SettlementDate> {
    
        protected override IDictionary<string, bool> GetFields(SettlementDate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AdjustableOrRelativeDate", IsSet(obj.AdjustableOrRelativeDate!) },
                { "ValueDate", IsSet(obj.ValueDate!) },
                { "AdjustableDates", IsSet(obj.AdjustableDates!) },
                { "BusinessDateRange", IsSet(obj.BusinessDateRange!) },
                { "CashSettlementBusinessDays", IsSet(obj.CashSettlementBusinessDays!) },
                { "PaymentDelay", IsSet(obj.PaymentDelay!) }
            };
        }
    }
    
    public class SettlementPayoutValidator : AbstractValidator<SettlementPayout>
    {
    
        public SettlementPayoutValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SettlementPayout obj)
        {
            yield return CheckCardinality(Name, "DeliveryTerm", obj.DeliveryTerm != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Delivery", obj.Delivery != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Schedule", obj.Schedule != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SettlementPayoutOnlyExistsValidator : AbstractOnlyExistsValidator<SettlementPayout> {
    
        protected override IDictionary<string, bool> GetFields(SettlementPayout obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Underlier", IsSet(obj.Underlier!) },
                { "DeliveryTerm", IsSet(obj.DeliveryTerm!) },
                { "Delivery", IsSet(obj.Delivery!) },
                { "Schedule", IsSet(obj.Schedule!) }
            };
        }
    }
    
    public class SettlementProvisionValidator : AbstractValidator<SettlementProvision>
    {
    
        public SettlementProvisionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SettlementProvision obj)
        {
            yield return CheckCardinality(Name, "ShapingProvisions", obj.ShapingProvisions != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SettlementProvisionOnlyExistsValidator : AbstractOnlyExistsValidator<SettlementProvision> {
    
        protected override IDictionary<string, bool> GetFields(SettlementProvision obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ShapingProvisions", IsSet(obj.ShapingProvisions!) }
            };
        }
    }
    
    public class SettlementRateOptionValidator : AbstractValidator<SettlementRateOption>
    {
    
        public SettlementRateOptionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SettlementRateOption obj)
        {
            yield return CheckCardinality(Name, "PriceSourceDisruption", obj.PriceSourceDisruption != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SettlementRateOptionOnlyExistsValidator : AbstractOnlyExistsValidator<SettlementRateOption> {
    
        protected override IDictionary<string, bool> GetFields(SettlementRateOption obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SettlementRateOptionValue", IsSet(obj.SettlementRateOptionValue!) },
                { "PriceSourceDisruption", IsSet(obj.PriceSourceDisruption!) }
            };
        }
    }
    
    public class SettlementTermsValidator : AbstractValidator<SettlementTerms>
    {
    
        public SettlementTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SettlementTerms obj)
        {
            yield return CheckCardinality(Name, "CashSettlementTerms", obj.CashSettlementTerms.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "PhysicalSettlementTerms", obj.PhysicalSettlementTerms != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SettlementTermsOnlyExistsValidator : AbstractOnlyExistsValidator<SettlementTerms> {
    
        protected override IDictionary<string, bool> GetFields(SettlementTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CashSettlementTerms", IsSet(obj.CashSettlementTerms!) },
                { "PhysicalSettlementTerms", IsSet(obj.PhysicalSettlementTerms!) }
            };
        }
    }
    
    public class ShapingProvisionValidator : AbstractValidator<ShapingProvision>
    {
    
        public ShapingProvisionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ShapingProvision obj)
        {
            yield return CheckCardinality(Name, "ShapeSchedule", obj.ShapeSchedule.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class ShapingProvisionOnlyExistsValidator : AbstractOnlyExistsValidator<ShapingProvision> {
    
        protected override IDictionary<string, bool> GetFields(ShapingProvision obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ShapeSchedule", IsSet(obj.ShapeSchedule!) }
            };
        }
    }
    
    public class SingleValuationDateValidator : AbstractValidator<SingleValuationDate>
    {
    
        public SingleValuationDateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SingleValuationDate obj)
        {
            yield return CheckCardinality(Name, "BusinessDays", obj.BusinessDays != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SingleValuationDateOnlyExistsValidator : AbstractOnlyExistsValidator<SingleValuationDate> {
    
        protected override IDictionary<string, bool> GetFields(SingleValuationDate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "BusinessDays", IsSet(obj.BusinessDays!) }
            };
        }
    }
    
    public class SnglValidator : AbstractValidator<Sngl>
    {
    
        public SnglValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Sngl obj)
        {
            yield break;
        }
    }
    
    public class SnglOnlyExistsValidator : AbstractOnlyExistsValidator<Sngl> {
    
        protected override IDictionary<string, bool> GetFields(Sngl obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Isin", IsSet(obj.Isin!) },
                { "Indx", IsSet(obj.Indx!) }
            };
        }
    }
    
    public class SovereignAgencyRatingValidator : AbstractValidator<SovereignAgencyRating>
    {
    
        public SovereignAgencyRatingValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SovereignAgencyRating obj)
        {
            yield break;
        }
    }
    
    public class SovereignAgencyRatingOnlyExistsValidator : AbstractOnlyExistsValidator<SovereignAgencyRating> {
    
        protected override IDictionary<string, bool> GetFields(SovereignAgencyRating obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SovereignAgencyRatingValue", IsSet(obj.SovereignAgencyRatingValue!) }
            };
        }
    }
    
    public class SpecialPurposeVehicleIssuerTypeValidator : AbstractValidator<SpecialPurposeVehicleIssuerType>
    {
    
        public SpecialPurposeVehicleIssuerTypeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SpecialPurposeVehicleIssuerType obj)
        {
            yield return CheckCardinality(Name, "CreditRisk", obj.CreditRisk != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SpecialPurposeVehicleIssuerTypeOnlyExistsValidator : AbstractOnlyExistsValidator<SpecialPurposeVehicleIssuerType> {
    
        protected override IDictionary<string, bool> GetFields(SpecialPurposeVehicleIssuerType obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CreditRisk", IsSet(obj.CreditRisk!) }
            };
        }
    }
    
    public class SpecificAssetValidator : AbstractValidator<SpecificAsset>
    {
    
        public SpecificAssetValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SpecificAsset obj)
        {
            yield break;
        }
    }
    
    public class SpecificAssetOnlyExistsValidator : AbstractOnlyExistsValidator<SpecificAsset> {
    
        protected override IDictionary<string, bool> GetFields(SpecificAsset obj)
        {
            return new Dictionary<string, bool>()
            {
            };
        }
    }
    
    public class SpecifiedCurrencyValidator : AbstractValidator<SpecifiedCurrency>
    {
    
        public SpecifiedCurrencyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SpecifiedCurrency obj)
        {
            yield return CheckCardinality(Name, "Currency", obj.Currency?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SpecifiedCurrencyOnlyExistsValidator : AbstractOnlyExistsValidator<SpecifiedCurrency> {
    
        protected override IDictionary<string, bool> GetFields(SpecifiedCurrency obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Applicable", IsSet(obj.Applicable!) },
                { "Currency", IsSet(obj.Currency!) }
            };
        }
    }
    
    public class SplitInstructionValidator : AbstractValidator<SplitInstruction>
    {
    
        public SplitInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SplitInstruction obj)
        {
            yield return CheckCardinality(Name, "Breakdown", obj.Breakdown.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class SplitInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<SplitInstruction> {
    
        protected override IDictionary<string, bool> GetFields(SplitInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Breakdown", IsSet(obj.Breakdown!) }
            };
        }
    }
    
    public class SpreadScheduleValidator : AbstractValidator<SpreadSchedule>
    {
    
        public SpreadScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SpreadSchedule obj)
        {
            yield return CheckCardinality(Name, "SpreadScheduleType", obj.SpreadScheduleType?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SpreadScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<SpreadSchedule> {
    
        protected override IDictionary<string, bool> GetFields(SpreadSchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SpreadScheduleType", IsSet(obj.SpreadScheduleType!) }
            };
        }
    }
    
    public class StandardizedScheduleValidator : AbstractValidator<StandardizedSchedule>
    {
    
        public StandardizedScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(StandardizedSchedule obj)
        {
            yield return CheckCardinality(Name, "DurationInYears", obj.DurationInYears != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class StandardizedScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<StandardizedSchedule> {
    
        protected override IDictionary<string, bool> GetFields(StandardizedSchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AssetClass", IsSet(obj.AssetClass!) },
                { "ProductClass", IsSet(obj.ProductClass!) },
                { "Notional", IsSet(obj.Notional!) },
                { "NotionalCurrency", IsSet(obj.NotionalCurrency!) },
                { "DurationInYears", IsSet(obj.DurationInYears!) }
            };
        }
    }
    
    public class StandardizedScheduleInitialMarginValidator : AbstractValidator<StandardizedScheduleInitialMargin>
    {
    
        public StandardizedScheduleInitialMarginValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(StandardizedScheduleInitialMargin obj)
        {
            yield return CheckCardinality(Name, "TradeInfo", obj.TradeInfo.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class StandardizedScheduleInitialMarginOnlyExistsValidator : AbstractOnlyExistsValidator<StandardizedScheduleInitialMargin> {
    
        protected override IDictionary<string, bool> GetFields(StandardizedScheduleInitialMargin obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TradeInfo", IsSet(obj.TradeInfo!) },
                { "NetInitialMargin", IsSet(obj.NetInitialMargin!) }
            };
        }
    }
    
    public class StandardizedScheduleTradeInfoValidator : AbstractValidator<StandardizedScheduleTradeInfo>
    {
    
        public StandardizedScheduleTradeInfoValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(StandardizedScheduleTradeInfo obj)
        {
            yield return CheckCardinality(Name, "AssetClass", obj.AssetClass != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ProductClass", obj.ProductClass != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "GrossInitialMargin", obj.GrossInitialMargin != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MarkToMarketValue", obj.MarkToMarketValue != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class StandardizedScheduleTradeInfoOnlyExistsValidator : AbstractOnlyExistsValidator<StandardizedScheduleTradeInfo> {
    
        protected override IDictionary<string, bool> GetFields(StandardizedScheduleTradeInfo obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AssetClass", IsSet(obj.AssetClass!) },
                { "ProductClass", IsSet(obj.ProductClass!) },
                { "GrossInitialMargin", IsSet(obj.GrossInitialMargin!) },
                { "MarkToMarketValue", IsSet(obj.MarkToMarketValue!) }
            };
        }
    }
    
    public class StateValidator : AbstractValidator<State>
    {
    
        public StateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(State obj)
        {
            yield return CheckCardinality(Name, "ClosedState", obj.ClosedState != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PositionState", obj.PositionState != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class StateOnlyExistsValidator : AbstractOnlyExistsValidator<State> {
    
        protected override IDictionary<string, bool> GetFields(State obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ClosedState", IsSet(obj.ClosedState!) },
                { "PositionState", IsSet(obj.PositionState!) }
            };
        }
    }
    
    public class StockSplitInstructionValidator : AbstractValidator<StockSplitInstruction>
    {
    
        public StockSplitInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(StockSplitInstruction obj)
        {
            yield break;
        }
    }
    
    public class StockSplitInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<StockSplitInstruction> {
    
        protected override IDictionary<string, bool> GetFields(StockSplitInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AdjustmentRatio", IsSet(obj.AdjustmentRatio!) },
                { "EffectiveDate", IsSet(obj.EffectiveDate!) }
            };
        }
    }
    
    public class StrategyFeatureValidator : AbstractValidator<StrategyFeature>
    {
    
        public StrategyFeatureValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(StrategyFeature obj)
        {
            yield return CheckCardinality(Name, "StrikeSpread", obj.StrikeSpread != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CalendarSpread", obj.CalendarSpread != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class StrategyFeatureOnlyExistsValidator : AbstractOnlyExistsValidator<StrategyFeature> {
    
        protected override IDictionary<string, bool> GetFields(StrategyFeature obj)
        {
            return new Dictionary<string, bool>()
            {
                { "StrikeSpread", IsSet(obj.StrikeSpread!) },
                { "CalendarSpread", IsSet(obj.CalendarSpread!) }
            };
        }
    }
    
    public class StrikeValidator : AbstractValidator<Strike>
    {
    
        public StrikeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Strike obj)
        {
            yield return CheckCardinality(Name, "Buyer", obj.Buyer != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Seller", obj.Seller != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class StrikeOnlyExistsValidator : AbstractOnlyExistsValidator<Strike> {
    
        protected override IDictionary<string, bool> GetFields(Strike obj)
        {
            return new Dictionary<string, bool>()
            {
                { "StrikeRate", IsSet(obj.StrikeRate!) },
                { "Buyer", IsSet(obj.Buyer!) },
                { "Seller", IsSet(obj.Seller!) }
            };
        }
    }
    
    public class StrikeScheduleValidator : AbstractValidator<StrikeSchedule>
    {
    
        public StrikeScheduleValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(StrikeSchedule obj)
        {
            yield return CheckCardinality(Name, "Buyer", obj.Buyer != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Seller", obj.Seller != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class StrikeScheduleOnlyExistsValidator : AbstractOnlyExistsValidator<StrikeSchedule> {
    
        protected override IDictionary<string, bool> GetFields(StrikeSchedule obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Buyer", IsSet(obj.Buyer!) },
                { "Seller", IsSet(obj.Seller!) }
            };
        }
    }
    
    public class StrikeSpreadValidator : AbstractValidator<StrikeSpread>
    {
    
        public StrikeSpreadValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(StrikeSpread obj)
        {
            yield break;
        }
    }
    
    public class StrikeSpreadOnlyExistsValidator : AbstractOnlyExistsValidator<StrikeSpread> {
    
        protected override IDictionary<string, bool> GetFields(StrikeSpread obj)
        {
            return new Dictionary<string, bool>()
            {
                { "UpperStrike", IsSet(obj.UpperStrike!) },
                { "UpperStrikeNumberOfOptions", IsSet(obj.UpperStrikeNumberOfOptions!) }
            };
        }
    }
    
    public class StubCalculationPeriodAmountValidator : AbstractValidator<StubCalculationPeriodAmount>
    {
    
        public StubCalculationPeriodAmountValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(StubCalculationPeriodAmount obj)
        {
            yield return CheckCardinality(Name, "CalculationPeriodDatesReference", obj.CalculationPeriodDatesReference.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "InitialStub", obj.InitialStub != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FinalStub", obj.FinalStub != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class StubCalculationPeriodAmountOnlyExistsValidator : AbstractOnlyExistsValidator<StubCalculationPeriodAmount> {
    
        protected override IDictionary<string, bool> GetFields(StubCalculationPeriodAmount obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CalculationPeriodDatesReference", IsSet(obj.CalculationPeriodDatesReference!) },
                { "InitialStub", IsSet(obj.InitialStub!) },
                { "FinalStub", IsSet(obj.FinalStub!) }
            };
        }
    }
    
    public class StubFloatingRateValidator : AbstractValidator<StubFloatingRate>
    {
    
        public StubFloatingRateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(StubFloatingRate obj)
        {
            yield return CheckCardinality(Name, "IndexTenor", obj.IndexTenor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FloatingRateMultiplierSchedule", obj.FloatingRateMultiplierSchedule != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SpreadSchedule", obj.SpreadSchedule.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "RateTreatment", obj.RateTreatment != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CapRateSchedule", obj.CapRateSchedule.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "FloorRateSchedule", obj.FloorRateSchedule.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class StubFloatingRateOnlyExistsValidator : AbstractOnlyExistsValidator<StubFloatingRate> {
    
        protected override IDictionary<string, bool> GetFields(StubFloatingRate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FloatingRateIndex", IsSet(obj.FloatingRateIndex!) },
                { "IndexTenor", IsSet(obj.IndexTenor!) },
                { "FloatingRateMultiplierSchedule", IsSet(obj.FloatingRateMultiplierSchedule!) },
                { "SpreadSchedule", IsSet(obj.SpreadSchedule!) },
                { "RateTreatment", IsSet(obj.RateTreatment!) },
                { "CapRateSchedule", IsSet(obj.CapRateSchedule!) },
                { "FloorRateSchedule", IsSet(obj.FloorRateSchedule!) }
            };
        }
    }
    
    public class StubPeriodValidator : AbstractValidator<StubPeriod>
    {
    
        public StubPeriodValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(StubPeriod obj)
        {
            yield return CheckCardinality(Name, "CalculationPeriodDatesReference", obj.CalculationPeriodDatesReference.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "InitialStub", obj.InitialStub != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FinalStub", obj.FinalStub != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class StubPeriodOnlyExistsValidator : AbstractOnlyExistsValidator<StubPeriod> {
    
        protected override IDictionary<string, bool> GetFields(StubPeriod obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CalculationPeriodDatesReference", IsSet(obj.CalculationPeriodDatesReference!) },
                { "InitialStub", IsSet(obj.InitialStub!) },
                { "FinalStub", IsSet(obj.FinalStub!) }
            };
        }
    }
    
    public class StubValueValidator : AbstractValidator<StubValue>
    {
    
        public StubValueValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(StubValue obj)
        {
            yield return CheckCardinality(Name, "FloatingRate", obj.FloatingRate.EmptyIfNull().Count(), 0, 2);
            yield return CheckCardinality(Name, "StubRate", obj.StubRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "StubAmount", obj.StubAmount != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class StubValueOnlyExistsValidator : AbstractOnlyExistsValidator<StubValue> {
    
        protected override IDictionary<string, bool> GetFields(StubValue obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FloatingRate", IsSet(obj.FloatingRate!) },
                { "StubRate", IsSet(obj.StubRate!) },
                { "StubAmount", IsSet(obj.StubAmount!) }
            };
        }
    }
    
    public class SubstitutionProvisionsValidator : AbstractValidator<SubstitutionProvisions>
    {
    
        public SubstitutionProvisionsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SubstitutionProvisions obj)
        {
            yield return CheckCardinality(Name, "NumberOfSubstitutionsAllowed", obj.NumberOfSubstitutionsAllowed != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NoticeDeadlinePeriod", obj.NoticeDeadlinePeriod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NoticeDeadlineDateTime", obj.NoticeDeadlineDateTime != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SubstitutionProvisionsOnlyExistsValidator : AbstractOnlyExistsValidator<SubstitutionProvisions> {
    
        protected override IDictionary<string, bool> GetFields(SubstitutionProvisions obj)
        {
            return new Dictionary<string, bool>()
            {
                { "NumberOfSubstitutionsAllowed", IsSet(obj.NumberOfSubstitutionsAllowed!) },
                { "NoticeDeadlinePeriod", IsSet(obj.NoticeDeadlinePeriod!) },
                { "NoticeDeadlineDateTime", IsSet(obj.NoticeDeadlineDateTime!) }
            };
        }
    }
    
    public class SwapCurveValuationValidator : AbstractValidator<SwapCurveValuation>
    {
    
        public SwapCurveValuationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SwapCurveValuation obj)
        {
            yield return CheckCardinality(Name, "IndexTenor", obj.IndexTenor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Side", obj.Side != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class SwapCurveValuationOnlyExistsValidator : AbstractOnlyExistsValidator<SwapCurveValuation> {
    
        protected override IDictionary<string, bool> GetFields(SwapCurveValuation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FloatingRateIndex", IsSet(obj.FloatingRateIndex!) },
                { "IndexTenor", IsSet(obj.IndexTenor!) },
                { "Spread", IsSet(obj.Spread!) },
                { "Side", IsSet(obj.Side!) }
            };
        }
    }
    
    public class SwpValidator : AbstractValidator<Swp>
    {
    
        public SwpValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Swp obj)
        {
            yield break;
        }
    }
    
    public class SwpOnlyExistsValidator : AbstractOnlyExistsValidator<Swp> {
    
        protected override IDictionary<string, bool> GetFields(Swp obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SwpIn", IsSet(obj.SwpIn!) },
                { "SwpOut", IsSet(obj.SwpOut!) }
            };
        }
    }
    
    public class SwpInValidator : AbstractValidator<SwpIn>
    {
    
        public SwpInValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SwpIn obj)
        {
            yield break;
        }
    }
    
    public class SwpInOnlyExistsValidator : AbstractOnlyExistsValidator<SwpIn> {
    
        protected override IDictionary<string, bool> GetFields(SwpIn obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Sngl", IsSet(obj.Sngl!) }
            };
        }
    }
    
    public class SwpOutValidator : AbstractValidator<SwpOut>
    {
    
        public SwpOutValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(SwpOut obj)
        {
            yield break;
        }
    }
    
    public class SwpOutOnlyExistsValidator : AbstractOnlyExistsValidator<SwpOut> {
    
        protected override IDictionary<string, bool> GetFields(SwpOut obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Sngl", IsSet(obj.Sngl!) }
            };
        }
    }
    
    public class TaxonomyValidator : AbstractValidator<Taxonomy>
    {
    
        public TaxonomyValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Taxonomy obj)
        {
            yield return CheckCardinality(Name, "Source", obj.Source != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Value", obj.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TaxonomyOnlyExistsValidator : AbstractOnlyExistsValidator<Taxonomy> {
    
        protected override IDictionary<string, bool> GetFields(Taxonomy obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Source", IsSet(obj.Source!) },
                { "Value", IsSet(obj.Value!) }
            };
        }
    }
    
    public class TaxonomyClassificationValidator : AbstractValidator<TaxonomyClassification>
    {
    
        public TaxonomyClassificationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TaxonomyClassification obj)
        {
            yield return CheckCardinality(Name, "ClassName", obj.ClassName != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Description", obj.Description != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Ordinal", obj.Ordinal != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TaxonomyClassificationOnlyExistsValidator : AbstractOnlyExistsValidator<TaxonomyClassification> {
    
        protected override IDictionary<string, bool> GetFields(TaxonomyClassification obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ClassName", IsSet(obj.ClassName!) },
                { "Value", IsSet(obj.Value!) },
                { "Description", IsSet(obj.Description!) },
                { "Ordinal", IsSet(obj.Ordinal!) }
            };
        }
    }
    
    public class TaxonomyValueValidator : AbstractValidator<TaxonomyValue>
    {
    
        public TaxonomyValueValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TaxonomyValue obj)
        {
            yield return CheckCardinality(Name, "Name", obj.Name?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Classification", obj.Classification.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class TaxonomyValueOnlyExistsValidator : AbstractOnlyExistsValidator<TaxonomyValue> {
    
        protected override IDictionary<string, bool> GetFields(TaxonomyValue obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Name", IsSet(obj.Name!) },
                { "Classification", IsSet(obj.Classification!) }
            };
        }
    }
    
    public class TelephoneNumberValidator : AbstractValidator<TelephoneNumber>
    {
    
        public TelephoneNumberValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TelephoneNumber obj)
        {
            yield return CheckCardinality(Name, "TelephoneNumberType", obj.TelephoneNumberType != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TelephoneNumberOnlyExistsValidator : AbstractOnlyExistsValidator<TelephoneNumber> {
    
        protected override IDictionary<string, bool> GetFields(TelephoneNumber obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TelephoneNumberType", IsSet(obj.TelephoneNumberType!) },
                { "Number", IsSet(obj.Number!) }
            };
        }
    }
    
    public class TermValidator : AbstractValidator<Term>
    {
    
        public TermValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Term obj)
        {
            yield break;
        }
    }
    
    public class TermOnlyExistsValidator : AbstractOnlyExistsValidator<Term> {
    
        protected override IDictionary<string, bool> GetFields(Term obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Unit", IsSet(obj.Unit!) },
                { "Val", IsSet(obj.Val!) }
            };
        }
    }
    
    public class TerminationProvisionValidator : AbstractValidator<TerminationProvision>
    {
    
        public TerminationProvisionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TerminationProvision obj)
        {
            yield return CheckCardinality(Name, "CancelableProvision", obj.CancelableProvision != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EarlyTerminationProvision", obj.EarlyTerminationProvision != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "EvergreenProvision", obj.EvergreenProvision != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExtendibleProvision", obj.ExtendibleProvision != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TerminationProvisionOnlyExistsValidator : AbstractOnlyExistsValidator<TerminationProvision> {
    
        protected override IDictionary<string, bool> GetFields(TerminationProvision obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CancelableProvision", IsSet(obj.CancelableProvision!) },
                { "EarlyTerminationProvision", IsSet(obj.EarlyTerminationProvision!) },
                { "EvergreenProvision", IsSet(obj.EvergreenProvision!) },
                { "ExtendibleProvision", IsSet(obj.ExtendibleProvision!) }
            };
        }
    }
    
    public class TermsChangeInstructionValidator : AbstractValidator<TermsChangeInstruction>
    {
    
        public TermsChangeInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TermsChangeInstruction obj)
        {
            yield return CheckCardinality(Name, "Product", obj.Product != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "AncillaryParty", obj.AncillaryParty.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Adjustment", obj.Adjustment != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TermsChangeInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<TermsChangeInstruction> {
    
        protected override IDictionary<string, bool> GetFields(TermsChangeInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Product", IsSet(obj.Product!) },
                { "AncillaryParty", IsSet(obj.AncillaryParty!) },
                { "Adjustment", IsSet(obj.Adjustment!) }
            };
        }
    }
    
    public class TimeZoneValidator : AbstractValidator<TimeZone>
    {
    
        public TimeZoneValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TimeZone obj)
        {
            yield return CheckCardinality(Name, "Location", obj.Location?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TimeZoneOnlyExistsValidator : AbstractOnlyExistsValidator<TimeZone> {
    
        protected override IDictionary<string, bool> GetFields(TimeZone obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Time", IsSet(obj.Time!) },
                { "Location", IsSet(obj.Location!) }
            };
        }
    }
    
    public class TradableProductValidator : AbstractValidator<TradableProduct>
    {
    
        public TradableProductValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TradableProduct obj)
        {
            yield return CheckCardinality(Name, "TradeLot", obj.TradeLot.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "Counterparty", obj.Counterparty.EmptyIfNull().Count(), 2, 2);
            yield return CheckCardinality(Name, "AncillaryParty", obj.AncillaryParty.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Adjustment", obj.Adjustment != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TradableProductOnlyExistsValidator : AbstractOnlyExistsValidator<TradableProduct> {
    
        protected override IDictionary<string, bool> GetFields(TradableProduct obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Product", IsSet(obj.Product!) },
                { "TradeLot", IsSet(obj.TradeLot!) },
                { "Counterparty", IsSet(obj.Counterparty!) },
                { "AncillaryParty", IsSet(obj.AncillaryParty!) },
                { "Adjustment", IsSet(obj.Adjustment!) }
            };
        }
    }
    
    public class TradeValidator : AbstractValidator<Trade>
    {
    
        public TradeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Trade obj)
        {
            yield return CheckCardinality(Name, "TradeIdentifier", obj.TradeIdentifier.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "TradeTime", obj.TradeTime?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Party", obj.Party.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "PartyRole", obj.PartyRole.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "ExecutionDetails", obj.ExecutionDetails != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ContractDetails", obj.ContractDetails != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ClearedDate", obj.ClearedDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Collateral", obj.Collateral != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Account", obj.Account.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TradeOnlyExistsValidator : AbstractOnlyExistsValidator<Trade> {
    
        protected override IDictionary<string, bool> GetFields(Trade obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TradeIdentifier", IsSet(obj.TradeIdentifier!) },
                { "TradeDate", IsSet(obj.TradeDate!) },
                { "TradeTime", IsSet(obj.TradeTime!) },
                { "Party", IsSet(obj.Party!) },
                { "PartyRole", IsSet(obj.PartyRole!) },
                { "ExecutionDetails", IsSet(obj.ExecutionDetails!) },
                { "ContractDetails", IsSet(obj.ContractDetails!) },
                { "ClearedDate", IsSet(obj.ClearedDate!) },
                { "Collateral", IsSet(obj.Collateral!) },
                { "Account", IsSet(obj.Account!) }
            };
        }
    }
    
    public class TradeIdentifierValidator : AbstractValidator<TradeIdentifier>
    {
    
        public TradeIdentifierValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TradeIdentifier obj)
        {
            yield return CheckCardinality(Name, "IdentifierType", obj.IdentifierType != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TradeIdentifierOnlyExistsValidator : AbstractOnlyExistsValidator<TradeIdentifier> {
    
        protected override IDictionary<string, bool> GetFields(TradeIdentifier obj)
        {
            return new Dictionary<string, bool>()
            {
                { "IdentifierType", IsSet(obj.IdentifierType!) }
            };
        }
    }
    
    public class TradeLotValidator : AbstractValidator<TradeLot>
    {
    
        public TradeLotValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TradeLot obj)
        {
            yield return CheckCardinality(Name, "LotIdentifier", obj.LotIdentifier.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "PriceQuantity", obj.PriceQuantity.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class TradeLotOnlyExistsValidator : AbstractOnlyExistsValidator<TradeLot> {
    
        protected override IDictionary<string, bool> GetFields(TradeLot obj)
        {
            return new Dictionary<string, bool>()
            {
                { "LotIdentifier", IsSet(obj.LotIdentifier!) },
                { "PriceQuantity", IsSet(obj.PriceQuantity!) }
            };
        }
    }
    
    public class TradePricingReportValidator : AbstractValidator<TradePricingReport>
    {
    
        public TradePricingReportValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TradePricingReport obj)
        {
            yield return CheckCardinality(Name, "DiscountingIndex", obj.DiscountingIndex != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TradePricingReportOnlyExistsValidator : AbstractOnlyExistsValidator<TradePricingReport> {
    
        protected override IDictionary<string, bool> GetFields(TradePricingReport obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Trade", IsSet(obj.Trade!) },
                { "PricingTime", IsSet(obj.PricingTime!) },
                { "DiscountingIndex", IsSet(obj.DiscountingIndex!) }
            };
        }
    }
    
    public class TradeStateValidator : AbstractValidator<TradeState>
    {
    
        public TradeStateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TradeState obj)
        {
            yield return CheckCardinality(Name, "State", obj.State != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ResetHistory", obj.ResetHistory.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "TransferHistory", obj.TransferHistory.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "ObservationHistory", obj.ObservationHistory.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "ValuationHistory", obj.ValuationHistory.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TradeStateOnlyExistsValidator : AbstractOnlyExistsValidator<TradeState> {
    
        protected override IDictionary<string, bool> GetFields(TradeState obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Trade", IsSet(obj.Trade!) },
                { "State", IsSet(obj.State!) },
                { "ResetHistory", IsSet(obj.ResetHistory!) },
                { "TransferHistory", IsSet(obj.TransferHistory!) },
                { "ObservationHistory", IsSet(obj.ObservationHistory!) },
                { "ValuationHistory", IsSet(obj.ValuationHistory!) }
            };
        }
    }
    
    public class TrancheValidator : AbstractValidator<Tranche>
    {
    
        public TrancheValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Tranche obj)
        {
            yield return CheckCardinality(Name, "IncurredRecoveryApplicable", obj.IncurredRecoveryApplicable != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TrancheOnlyExistsValidator : AbstractOnlyExistsValidator<Tranche> {
    
        protected override IDictionary<string, bool> GetFields(Tranche obj)
        {
            return new Dictionary<string, bool>()
            {
                { "AttachmentPoint", IsSet(obj.AttachmentPoint!) },
                { "ExhaustionPoint", IsSet(obj.ExhaustionPoint!) },
                { "IncurredRecoveryApplicable", IsSet(obj.IncurredRecoveryApplicable!) }
            };
        }
    }
    
    public class TransactedPriceValidator : AbstractValidator<TransactedPrice>
    {
    
        public TransactedPriceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TransactedPrice obj)
        {
            yield return CheckCardinality(Name, "MarketFixedRate", obj.MarketFixedRate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InitialPoints", obj.InitialPoints != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MarketPrice", obj.MarketPrice != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "QuotationStyle", obj.QuotationStyle != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TransactedPriceOnlyExistsValidator : AbstractOnlyExistsValidator<TransactedPrice> {
    
        protected override IDictionary<string, bool> GetFields(TransactedPrice obj)
        {
            return new Dictionary<string, bool>()
            {
                { "MarketFixedRate", IsSet(obj.MarketFixedRate!) },
                { "InitialPoints", IsSet(obj.InitialPoints!) },
                { "MarketPrice", IsSet(obj.MarketPrice!) },
                { "QuotationStyle", IsSet(obj.QuotationStyle!) }
            };
        }
    }
    
    public class TransactionAdditionalTermsValidator : AbstractValidator<TransactionAdditionalTerms>
    {
    
        public TransactionAdditionalTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TransactionAdditionalTerms obj)
        {
            yield return CheckCardinality(Name, "EquityAdditionalTerms", obj.EquityAdditionalTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ForeignExchangeAdditionalTerms", obj.ForeignExchangeAdditionalTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CommoditiesAdditionalTerms", obj.CommoditiesAdditionalTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CreditAdditionalTerms", obj.CreditAdditionalTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InterestRateAdditionalTerms", obj.InterestRateAdditionalTerms != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DigitalAssetAdditionalTerms", obj.DigitalAssetAdditionalTerms != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TransactionAdditionalTermsOnlyExistsValidator : AbstractOnlyExistsValidator<TransactionAdditionalTerms> {
    
        protected override IDictionary<string, bool> GetFields(TransactionAdditionalTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "EquityAdditionalTerms", IsSet(obj.EquityAdditionalTerms!) },
                { "ForeignExchangeAdditionalTerms", IsSet(obj.ForeignExchangeAdditionalTerms!) },
                { "CommoditiesAdditionalTerms", IsSet(obj.CommoditiesAdditionalTerms!) },
                { "CreditAdditionalTerms", IsSet(obj.CreditAdditionalTerms!) },
                { "InterestRateAdditionalTerms", IsSet(obj.InterestRateAdditionalTerms!) },
                { "DigitalAssetAdditionalTerms", IsSet(obj.DigitalAssetAdditionalTerms!) }
            };
        }
    }
    
    public class TransferValidator : AbstractValidator<Transfer>
    {
    
        public TransferValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Transfer obj)
        {
            yield return CheckCardinality(Name, "Identifier", obj.Identifier.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "SettlementOrigin", obj.SettlementOrigin?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ResetOrigin", obj.ResetOrigin != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TransferOnlyExistsValidator : AbstractOnlyExistsValidator<Transfer> {
    
        protected override IDictionary<string, bool> GetFields(Transfer obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Identifier", IsSet(obj.Identifier!) },
                { "PayerReceiver", IsSet(obj.PayerReceiver!) },
                { "SettlementOrigin", IsSet(obj.SettlementOrigin!) },
                { "ResetOrigin", IsSet(obj.ResetOrigin!) },
                { "TransferExpression", IsSet(obj.TransferExpression!) }
            };
        }
    }
    
    public class TransferExpressionValidator : AbstractValidator<TransferExpression>
    {
    
        public TransferExpressionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TransferExpression obj)
        {
            yield return CheckCardinality(Name, "PriceTransfer", obj.PriceTransfer != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ScheduledTransfer", obj.ScheduledTransfer != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TransferExpressionOnlyExistsValidator : AbstractOnlyExistsValidator<TransferExpression> {
    
        protected override IDictionary<string, bool> GetFields(TransferExpression obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PriceTransfer", IsSet(obj.PriceTransfer!) },
                { "ScheduledTransfer", IsSet(obj.ScheduledTransfer!) }
            };
        }
    }
    
    public class TransferInstructionValidator : AbstractValidator<TransferInstruction>
    {
    
        public TransferInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TransferInstruction obj)
        {
            yield return CheckCardinality(Name, "TransferState", obj.TransferState.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class TransferInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<TransferInstruction> {
    
        protected override IDictionary<string, bool> GetFields(TransferInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "TransferState", IsSet(obj.TransferState!) }
            };
        }
    }
    
    public class TransferStateValidator : AbstractValidator<TransferState>
    {
    
        public TransferStateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TransferState obj)
        {
            yield return CheckCardinality(Name, "TransferStatus", obj.TransferStatus != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TransferStateOnlyExistsValidator : AbstractOnlyExistsValidator<TransferState> {
    
        protected override IDictionary<string, bool> GetFields(TransferState obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Transfer", IsSet(obj.Transfer!) },
                { "TransferStatus", IsSet(obj.TransferStatus!) }
            };
        }
    }
    
    public class TransferableProductValidator : AbstractValidator<TransferableProduct>
    {
    
        public TransferableProductValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TransferableProduct obj)
        {
            yield break;
        }
    }
    
    public class TransferableProductOnlyExistsValidator : AbstractOnlyExistsValidator<TransferableProduct> {
    
        protected override IDictionary<string, bool> GetFields(TransferableProduct obj)
        {
            return new Dictionary<string, bool>()
            {
                { "EconomicTerms", IsSet(obj.EconomicTerms!) }
            };
        }
    }
    
    public class TriggerValidator : AbstractValidator<Trigger>
    {
    
        public TriggerValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Trigger obj)
        {
            yield return CheckCardinality(Name, "Level", obj.Level.EmptyIfNull().Count(), 0, 2);
            yield return CheckCardinality(Name, "CreditEvents", obj.CreditEvents != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CreditEventsReference", obj.CreditEventsReference?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "TriggerType", obj.TriggerType != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "TriggerTimeType", obj.TriggerTimeType != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TriggerOnlyExistsValidator : AbstractOnlyExistsValidator<Trigger> {
    
        protected override IDictionary<string, bool> GetFields(Trigger obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Level", IsSet(obj.Level!) },
                { "CreditEvents", IsSet(obj.CreditEvents!) },
                { "CreditEventsReference", IsSet(obj.CreditEventsReference!) },
                { "TriggerType", IsSet(obj.TriggerType!) },
                { "TriggerTimeType", IsSet(obj.TriggerTimeType!) }
            };
        }
    }
    
    public class TriggerEventValidator : AbstractValidator<TriggerEvent>
    {
    
        public TriggerEventValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(TriggerEvent obj)
        {
            yield return CheckCardinality(Name, "Schedule", obj.Schedule.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "TriggerDates", obj.TriggerDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FeaturePayment", obj.FeaturePayment != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class TriggerEventOnlyExistsValidator : AbstractOnlyExistsValidator<TriggerEvent> {
    
        protected override IDictionary<string, bool> GetFields(TriggerEvent obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Schedule", IsSet(obj.Schedule!) },
                { "TriggerDates", IsSet(obj.TriggerDates!) },
                { "Trigger", IsSet(obj.Trigger!) },
                { "FeaturePayment", IsSet(obj.FeaturePayment!) }
            };
        }
    }
    
    public class TxValidator : AbstractValidator<Tx>
    {
    
        public TxValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Tx obj)
        {
            yield break;
        }
    }
    
    public class TxOnlyExistsValidator : AbstractOnlyExistsValidator<Tx> {
    
        protected override IDictionary<string, bool> GetFields(Tx obj)
        {
            return new Dictionary<string, bool>()
            {
                { "NewTx", IsSet(obj.NewTx!) },
                { "TradDt", IsSet(obj.TradDt!) },
                { "TradgCpcty", IsSet(obj.TradgCpcty!) },
                { "Qty", IsSet(obj.Qty!) },
                { "Pric", IsSet(obj.Pric!) },
                { "TradVn", IsSet(obj.TradVn!) },
                { "CtryOfBrnch", IsSet(obj.CtryOfBrnch!) }
            };
        }
    }
    
    public class UmbrellaAgreementValidator : AbstractValidator<UmbrellaAgreement>
    {
    
        public UmbrellaAgreementValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(UmbrellaAgreement obj)
        {
            yield return CheckCardinality(Name, "Language", obj.Language != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Parties", obj.Parties.EmptyIfNull().Count(), 0, 0);
            yield break;
        }
    }
    
    public class UmbrellaAgreementOnlyExistsValidator : AbstractOnlyExistsValidator<UmbrellaAgreement> {
    
        protected override IDictionary<string, bool> GetFields(UmbrellaAgreement obj)
        {
            return new Dictionary<string, bool>()
            {
                { "IsApplicable", IsSet(obj.IsApplicable!) },
                { "Language", IsSet(obj.Language!) },
                { "Parties", IsSet(obj.Parties!) }
            };
        }
    }
    
    public class UmbrellaAgreementEntityValidator : AbstractValidator<UmbrellaAgreementEntity>
    {
    
        public UmbrellaAgreementEntityValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(UmbrellaAgreementEntity obj)
        {
            yield return CheckCardinality(Name, "Terms", obj.Terms != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class UmbrellaAgreementEntityOnlyExistsValidator : AbstractOnlyExistsValidator<UmbrellaAgreementEntity> {
    
        protected override IDictionary<string, bool> GetFields(UmbrellaAgreementEntity obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Terms", IsSet(obj.Terms!) }
            };
        }
    }
    
    public class UnderlierValidator : AbstractValidator<Underlier>
    {
    
        public UnderlierValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Underlier obj)
        {
            yield return CheckCardinality(Name, "Observable", obj.Observable?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Product", obj.Product != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class UnderlierOnlyExistsValidator : AbstractOnlyExistsValidator<Underlier> {
    
        protected override IDictionary<string, bool> GetFields(Underlier obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Observable", IsSet(obj.Observable!) },
                { "Product", IsSet(obj.Product!) }
            };
        }
    }
    
    public class UnderlierSubstitutionProvisionValidator : AbstractValidator<UnderlierSubstitutionProvision>
    {
    
        public UnderlierSubstitutionProvisionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(UnderlierSubstitutionProvision obj)
        {
            yield return CheckCardinality(Name, "WhoMaySubstitute", obj.WhoMaySubstitute.EmptyIfNull().Count(), 1, 2);
            yield return CheckCardinality(Name, "SubstitutionBeSpokeTerms", obj.SubstitutionBeSpokeTerms.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "SubstitutionTriggerEvents", obj.SubstitutionTriggerEvents.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "DisputingParty", obj.DisputingParty != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class UnderlierSubstitutionProvisionOnlyExistsValidator : AbstractOnlyExistsValidator<UnderlierSubstitutionProvision> {
    
        protected override IDictionary<string, bool> GetFields(UnderlierSubstitutionProvision obj)
        {
            return new Dictionary<string, bool>()
            {
                { "WhoMaySubstitute", IsSet(obj.WhoMaySubstitute!) },
                { "SubstitutionBeSpokeTerms", IsSet(obj.SubstitutionBeSpokeTerms!) },
                { "SubstitutionTriggerEvents", IsSet(obj.SubstitutionTriggerEvents!) },
                { "DisputingParty", IsSet(obj.DisputingParty!) }
            };
        }
    }
    
    public class UndrlygInstrmValidator : AbstractValidator<UndrlygInstrm>
    {
    
        public UndrlygInstrmValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(UndrlygInstrm obj)
        {
            yield break;
        }
    }
    
    public class UndrlygInstrmOnlyExistsValidator : AbstractOnlyExistsValidator<UndrlygInstrm> {
    
        protected override IDictionary<string, bool> GetFields(UndrlygInstrm obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Swp", IsSet(obj.Swp!) }
            };
        }
    }
    
    public class UnitTypeValidator : AbstractValidator<UnitType>
    {
    
        public UnitTypeValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(UnitType obj)
        {
            yield return CheckCardinality(Name, "CapacityUnit", obj.CapacityUnit != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "WeatherUnit", obj.WeatherUnit != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FinancialUnit", obj.FinancialUnit != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Currency", obj.Currency?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class UnitTypeOnlyExistsValidator : AbstractOnlyExistsValidator<UnitType> {
    
        protected override IDictionary<string, bool> GetFields(UnitType obj)
        {
            return new Dictionary<string, bool>()
            {
                { "CapacityUnit", IsSet(obj.CapacityUnit!) },
                { "WeatherUnit", IsSet(obj.WeatherUnit!) },
                { "FinancialUnit", IsSet(obj.FinancialUnit!) },
                { "Currency", IsSet(obj.Currency!) }
            };
        }
    }
    
    public class ValuationValidator : AbstractValidator<Valuation>
    {
    
        public ValuationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Valuation obj)
        {
            yield return CheckCardinality(Name, "Method", obj.Method != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Source", obj.Source != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Delta", obj.Delta != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ValuationTiming", obj.ValuationTiming != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PriceComponent", obj.PriceComponent != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ValuationOnlyExistsValidator : AbstractOnlyExistsValidator<Valuation> {
    
        protected override IDictionary<string, bool> GetFields(Valuation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Amount", IsSet(obj.Amount!) },
                { "Timestamp", IsSet(obj.Timestamp!) },
                { "Method", IsSet(obj.Method!) },
                { "Source", IsSet(obj.Source!) },
                { "Delta", IsSet(obj.Delta!) },
                { "ValuationTiming", IsSet(obj.ValuationTiming!) },
                { "PriceComponent", IsSet(obj.PriceComponent!) }
            };
        }
    }
    
    public class ValuationDateValidator : AbstractValidator<ValuationDate>
    {
    
        public ValuationDateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ValuationDate obj)
        {
            yield return CheckCardinality(Name, "SingleValuationDate", obj.SingleValuationDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MultipleValuationDates", obj.MultipleValuationDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ValuationDateValue", obj.ValuationDateValue != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FxFixingDate", obj.FxFixingDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FxFixingSchedule", obj.FxFixingSchedule != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ValuationDateOnlyExistsValidator : AbstractOnlyExistsValidator<ValuationDate> {
    
        protected override IDictionary<string, bool> GetFields(ValuationDate obj)
        {
            return new Dictionary<string, bool>()
            {
                { "SingleValuationDate", IsSet(obj.SingleValuationDate!) },
                { "MultipleValuationDates", IsSet(obj.MultipleValuationDates!) },
                { "ValuationDateValue", IsSet(obj.ValuationDateValue!) },
                { "FxFixingDate", IsSet(obj.FxFixingDate!) },
                { "FxFixingSchedule", IsSet(obj.FxFixingSchedule!) }
            };
        }
    }
    
    public class ValuationDatesValidator : AbstractValidator<ValuationDates>
    {
    
        public ValuationDatesValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ValuationDates obj)
        {
            yield return CheckCardinality(Name, "InitialValuationDate", obj.InitialValuationDate != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InterimValuationDate", obj.InterimValuationDate != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ValuationDatesOnlyExistsValidator : AbstractOnlyExistsValidator<ValuationDates> {
    
        protected override IDictionary<string, bool> GetFields(ValuationDates obj)
        {
            return new Dictionary<string, bool>()
            {
                { "InitialValuationDate", IsSet(obj.InitialValuationDate!) },
                { "InterimValuationDate", IsSet(obj.InterimValuationDate!) },
                { "FinalValuationDate", IsSet(obj.FinalValuationDate!) }
            };
        }
    }
    
    public class ValuationInstructionValidator : AbstractValidator<ValuationInstruction>
    {
    
        public ValuationInstructionValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ValuationInstruction obj)
        {
            yield return CheckCardinality(Name, "Valuation", obj.Valuation.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class ValuationInstructionOnlyExistsValidator : AbstractOnlyExistsValidator<ValuationInstruction> {
    
        protected override IDictionary<string, bool> GetFields(ValuationInstruction obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Valuation", IsSet(obj.Valuation!) },
                { "Replace", IsSet(obj.Replace!) }
            };
        }
    }
    
    public class ValuationMethodValidator : AbstractValidator<ValuationMethod>
    {
    
        public ValuationMethodValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ValuationMethod obj)
        {
            yield return CheckCardinality(Name, "QuotationMethod", obj.QuotationMethod != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ValuationMethodValue", obj.ValuationMethodValue != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "QuotationAmount", obj.QuotationAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MinimumQuotationAmount", obj.MinimumQuotationAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CashCollateralValuationMethod", obj.CashCollateralValuationMethod != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ValuationMethodOnlyExistsValidator : AbstractOnlyExistsValidator<ValuationMethod> {
    
        protected override IDictionary<string, bool> GetFields(ValuationMethod obj)
        {
            return new Dictionary<string, bool>()
            {
                { "ValuationSource", IsSet(obj.ValuationSource!) },
                { "QuotationMethod", IsSet(obj.QuotationMethod!) },
                { "ValuationMethodValue", IsSet(obj.ValuationMethodValue!) },
                { "QuotationAmount", IsSet(obj.QuotationAmount!) },
                { "MinimumQuotationAmount", IsSet(obj.MinimumQuotationAmount!) },
                { "CashCollateralValuationMethod", IsSet(obj.CashCollateralValuationMethod!) }
            };
        }
    }
    
    public class ValuationPostponementValidator : AbstractValidator<ValuationPostponement>
    {
    
        public ValuationPostponementValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ValuationPostponement obj)
        {
            yield break;
        }
    }
    
    public class ValuationPostponementOnlyExistsValidator : AbstractOnlyExistsValidator<ValuationPostponement> {
    
        protected override IDictionary<string, bool> GetFields(ValuationPostponement obj)
        {
            return new Dictionary<string, bool>()
            {
                { "MaximumDaysOfPostponement", IsSet(obj.MaximumDaysOfPostponement!) }
            };
        }
    }
    
    public class ValuationSourceValidator : AbstractValidator<ValuationSource>
    {
    
        public ValuationSourceValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ValuationSource obj)
        {
            yield return CheckCardinality(Name, "QuotedCurrencyPair", obj.QuotedCurrencyPair?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "InformationSource", obj.InformationSource != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "SettlementRateOption", obj.SettlementRateOption != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ReferenceBanks", obj.ReferenceBanks != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DealerOrCCP", obj.DealerOrCCP != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ValuationSourceOnlyExistsValidator : AbstractOnlyExistsValidator<ValuationSource> {
    
        protected override IDictionary<string, bool> GetFields(ValuationSource obj)
        {
            return new Dictionary<string, bool>()
            {
                { "QuotedCurrencyPair", IsSet(obj.QuotedCurrencyPair!) },
                { "InformationSource", IsSet(obj.InformationSource!) },
                { "SettlementRateOption", IsSet(obj.SettlementRateOption!) },
                { "ReferenceBanks", IsSet(obj.ReferenceBanks!) },
                { "DealerOrCCP", IsSet(obj.DealerOrCCP!) }
            };
        }
    }
    
    public class ValuationTermsValidator : AbstractValidator<ValuationTerms>
    {
    
        public ValuationTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(ValuationTerms obj)
        {
            yield return CheckCardinality(Name, "FuturesPriceValuation", obj.FuturesPriceValuation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "OptionsPriceValuation", obj.OptionsPriceValuation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NumberOfValuationDates", obj.NumberOfValuationDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "DividendValuationDates", obj.DividendValuationDates != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "FPVFinalPriceElectionFallback", obj.FPVFinalPriceElectionFallback != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MultipleExchangeIndexAnnexFallback", obj.MultipleExchangeIndexAnnexFallback != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ComponentSecurityIndexAnnexFallback", obj.ComponentSecurityIndexAnnexFallback != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class ValuationTermsOnlyExistsValidator : AbstractOnlyExistsValidator<ValuationTerms> {
    
        protected override IDictionary<string, bool> GetFields(ValuationTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "FuturesPriceValuation", IsSet(obj.FuturesPriceValuation!) },
                { "OptionsPriceValuation", IsSet(obj.OptionsPriceValuation!) },
                { "NumberOfValuationDates", IsSet(obj.NumberOfValuationDates!) },
                { "DividendValuationDates", IsSet(obj.DividendValuationDates!) },
                { "FPVFinalPriceElectionFallback", IsSet(obj.FPVFinalPriceElectionFallback!) },
                { "MultipleExchangeIndexAnnexFallback", IsSet(obj.MultipleExchangeIndexAnnexFallback!) },
                { "ComponentSecurityIndexAnnexFallback", IsSet(obj.ComponentSecurityIndexAnnexFallback!) }
            };
        }
    }
    
    public class VarianceCapFloorValidator : AbstractValidator<VarianceCapFloor>
    {
    
        public VarianceCapFloorValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(VarianceCapFloor obj)
        {
            yield return CheckCardinality(Name, "UnadjustedVarianceCap", obj.UnadjustedVarianceCap != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "BoundedVariance", obj.BoundedVariance != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class VarianceCapFloorOnlyExistsValidator : AbstractOnlyExistsValidator<VarianceCapFloor> {
    
        protected override IDictionary<string, bool> GetFields(VarianceCapFloor obj)
        {
            return new Dictionary<string, bool>()
            {
                { "VarianceCap", IsSet(obj.VarianceCap!) },
                { "UnadjustedVarianceCap", IsSet(obj.UnadjustedVarianceCap!) },
                { "BoundedVariance", IsSet(obj.BoundedVariance!) }
            };
        }
    }
    
    public class VarianceReturnTermsValidator : AbstractValidator<VarianceReturnTerms>
    {
    
        public VarianceReturnTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(VarianceReturnTerms obj)
        {
            yield return CheckCardinality(Name, "VarianceStrikePrice", obj.VarianceStrikePrice != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "VolatilityStrikePrice", obj.VolatilityStrikePrice != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "VarianceCapFloor", obj.VarianceCapFloor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "VolatilityCapFloor", obj.VolatilityCapFloor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "VegaNotionalAmount", obj.VegaNotionalAmount != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExchangeTradedContractNearest", obj.ExchangeTradedContractNearest?.Value != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class VarianceReturnTermsOnlyExistsValidator : AbstractOnlyExistsValidator<VarianceReturnTerms> {
    
        protected override IDictionary<string, bool> GetFields(VarianceReturnTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "VarianceStrikePrice", IsSet(obj.VarianceStrikePrice!) },
                { "VolatilityStrikePrice", IsSet(obj.VolatilityStrikePrice!) },
                { "VarianceCapFloor", IsSet(obj.VarianceCapFloor!) },
                { "VolatilityCapFloor", IsSet(obj.VolatilityCapFloor!) },
                { "VegaNotionalAmount", IsSet(obj.VegaNotionalAmount!) },
                { "ExchangeTradedContractNearest", IsSet(obj.ExchangeTradedContractNearest!) }
            };
        }
    }
    
    public class VelocityValidator : AbstractValidator<Velocity>
    {
    
        public VelocityValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Velocity obj)
        {
            yield return CheckCardinality(Name, "PeriodMultiplier", obj.PeriodMultiplier != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Period", obj.Period != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class VelocityOnlyExistsValidator : AbstractOnlyExistsValidator<Velocity> {
    
        protected override IDictionary<string, bool> GetFields(Velocity obj)
        {
            return new Dictionary<string, bool>()
            {
                { "PeriodMultiplier", IsSet(obj.PeriodMultiplier!) },
                { "Period", IsSet(obj.Period!) }
            };
        }
    }
    
    public class VolatilityCapFloorValidator : AbstractValidator<VolatilityCapFloor>
    {
    
        public VolatilityCapFloorValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(VolatilityCapFloor obj)
        {
            yield return CheckCardinality(Name, "TotalVolatilityCap", obj.TotalVolatilityCap != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "VolatilityCapFactor", obj.VolatilityCapFactor != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class VolatilityCapFloorOnlyExistsValidator : AbstractOnlyExistsValidator<VolatilityCapFloor> {
    
        protected override IDictionary<string, bool> GetFields(VolatilityCapFloor obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Applicable", IsSet(obj.Applicable!) },
                { "TotalVolatilityCap", IsSet(obj.TotalVolatilityCap!) },
                { "VolatilityCapFactor", IsSet(obj.VolatilityCapFactor!) }
            };
        }
    }
    
    public class VolatilityReturnTermsValidator : AbstractValidator<VolatilityReturnTerms>
    {
    
        public VolatilityReturnTermsValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(VolatilityReturnTerms obj)
        {
            yield return CheckCardinality(Name, "VolatilityCapFloor", obj.VolatilityCapFloor != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ExchangeTradedContractNearest", obj.ExchangeTradedContractNearest != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class VolatilityReturnTermsOnlyExistsValidator : AbstractOnlyExistsValidator<VolatilityReturnTerms> {
    
        protected override IDictionary<string, bool> GetFields(VolatilityReturnTerms obj)
        {
            return new Dictionary<string, bool>()
            {
                { "VolatilityStrikePrice", IsSet(obj.VolatilityStrikePrice!) },
                { "VolatilityCapFloor", IsSet(obj.VolatilityCapFloor!) },
                { "ExchangeTradedContractNearest", IsSet(obj.ExchangeTradedContractNearest!) }
            };
        }
    }
    
    public class WeightedAveragingObservationValidator : AbstractValidator<WeightedAveragingObservation>
    {
    
        public WeightedAveragingObservationValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(WeightedAveragingObservation obj)
        {
            yield return CheckCardinality(Name, "DateTime", obj.DateTime != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ObservationNumber", obj.ObservationNumber != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class WeightedAveragingObservationOnlyExistsValidator : AbstractOnlyExistsValidator<WeightedAveragingObservation> {
    
        protected override IDictionary<string, bool> GetFields(WeightedAveragingObservation obj)
        {
            return new Dictionary<string, bool>()
            {
                { "DateTime", IsSet(obj.DateTime!) },
                { "ObservationNumber", IsSet(obj.ObservationNumber!) },
                { "Weight", IsSet(obj.Weight!) }
            };
        }
    }
    
    public class WorkflowValidator : AbstractValidator<Workflow>
    {
    
        public WorkflowValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(Workflow obj)
        {
            yield return CheckCardinality(Name, "Steps", obj.Steps.EmptyIfNull().Count(), 1, 0);
            yield break;
        }
    }
    
    public class WorkflowOnlyExistsValidator : AbstractOnlyExistsValidator<Workflow> {
    
        protected override IDictionary<string, bool> GetFields(Workflow obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Steps", IsSet(obj.Steps!) }
            };
        }
    }
    
    public class WorkflowStateValidator : AbstractValidator<WorkflowState>
    {
    
        public WorkflowStateValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(WorkflowState obj)
        {
            yield return CheckCardinality(Name, "Comment", obj.Comment != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "PartyCustomisedWorkflow", obj.PartyCustomisedWorkflow.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "WarehouseIdentity", obj.WarehouseIdentity != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class WorkflowStateOnlyExistsValidator : AbstractOnlyExistsValidator<WorkflowState> {
    
        protected override IDictionary<string, bool> GetFields(WorkflowState obj)
        {
            return new Dictionary<string, bool>()
            {
                { "WorkflowStatus", IsSet(obj.WorkflowStatus!) },
                { "Comment", IsSet(obj.Comment!) },
                { "PartyCustomisedWorkflow", IsSet(obj.PartyCustomisedWorkflow!) },
                { "WarehouseIdentity", IsSet(obj.WarehouseIdentity!) }
            };
        }
    }
    
    public class WorkflowStepValidator : AbstractValidator<WorkflowStep>
    {
    
        public WorkflowStepValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(WorkflowStep obj)
        {
            yield return CheckCardinality(Name, "BusinessEvent", obj.BusinessEvent != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CounterpartyPositionBusinessEvent", obj.CounterpartyPositionBusinessEvent != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "ProposedEvent", obj.ProposedEvent != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Rejected", obj.Rejected != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Approval", obj.Approval.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "PreviousWorkflowStep", obj.PreviousWorkflowStep?.Value != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "NextEvent", obj.NextEvent != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "MessageInformation", obj.MessageInformation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Timestamp", obj.Timestamp.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "EventIdentifier", obj.EventIdentifier.EmptyIfNull().Count(), 1, 0);
            yield return CheckCardinality(Name, "Action", obj.Action != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Party", obj.Party.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Account", obj.Account.EmptyIfNull().Count(), 0, 0);
            yield return CheckCardinality(Name, "Lineage", obj.Lineage != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "CreditLimitInformation", obj.CreditLimitInformation != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "WorkflowState", obj.WorkflowState != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class WorkflowStepOnlyExistsValidator : AbstractOnlyExistsValidator<WorkflowStep> {
    
        protected override IDictionary<string, bool> GetFields(WorkflowStep obj)
        {
            return new Dictionary<string, bool>()
            {
                { "BusinessEvent", IsSet(obj.BusinessEvent!) },
                { "CounterpartyPositionBusinessEvent", IsSet(obj.CounterpartyPositionBusinessEvent!) },
                { "ProposedEvent", IsSet(obj.ProposedEvent!) },
                { "Rejected", IsSet(obj.Rejected!) },
                { "Approval", IsSet(obj.Approval!) },
                { "PreviousWorkflowStep", IsSet(obj.PreviousWorkflowStep!) },
                { "NextEvent", IsSet(obj.NextEvent!) },
                { "MessageInformation", IsSet(obj.MessageInformation!) },
                { "Timestamp", IsSet(obj.Timestamp!) },
                { "EventIdentifier", IsSet(obj.EventIdentifier!) },
                { "Action", IsSet(obj.Action!) },
                { "Party", IsSet(obj.Party!) },
                { "Account", IsSet(obj.Account!) },
                { "Lineage", IsSet(obj.Lineage!) },
                { "CreditLimitInformation", IsSet(obj.CreditLimitInformation!) },
                { "WorkflowState", IsSet(obj.WorkflowState!) }
            };
        }
    }
    
    public class WorkflowStepApprovalValidator : AbstractValidator<WorkflowStepApproval>
    {
    
        public WorkflowStepApprovalValidator() {}
    
        protected override IEnumerable<IComparisonResult> GetResults(WorkflowStepApproval obj)
        {
            yield return CheckCardinality(Name, "Party", obj.Party.Value != null ? 1 : 0, 1, 1);
            yield return CheckCardinality(Name, "RejectedReason", obj.RejectedReason != null ? 1 : 0, 0, 1);
            yield return CheckCardinality(Name, "Meta", obj.Meta != null ? 1 : 0, 0, 1);
            yield break;
        }
    }
    
    public class WorkflowStepApprovalOnlyExistsValidator : AbstractOnlyExistsValidator<WorkflowStepApproval> {
    
        protected override IDictionary<string, bool> GetFields(WorkflowStepApproval obj)
        {
            return new Dictionary<string, bool>()
            {
                { "Approved", IsSet(obj.Approved!) },
                { "Party", IsSet(obj.Party!) },
                { "RejectedReason", IsSet(obj.RejectedReason!) },
                { "Timestamp", IsSet(obj.Timestamp!) }
            };
        }
    }
    
}