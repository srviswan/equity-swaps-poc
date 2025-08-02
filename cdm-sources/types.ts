/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */

import { ReferenceWithMeta, FieldWithMeta, MetaFields } from './metatypes';
import {
  PeriodEnum, DayTypeEnum, BusinessDayConventionEnum, BusinessCenterEnum, CommodityBusinessCalendarEnum, PeriodExtendedEnum, RollConventionEnum, DayOfWeekEnum, CapacityUnitEnum, WeatherUnitEnum,
  FinancialUnitEnum, RoundingDirectionEnum, AveragingCalculationMethodEnum, AssetIdTypeEnum, InstrumentTypeEnum, ProductIdTypeEnum, TaxonomySourceEnum, AssetClassEnum, QuotationSideEnum, CommodityInformationPublisherEnum,
  PutCallEnum, EU_EMIR_EligibleCollateralEnum, UK_EMIR_EligibleCollateralEnum, US_CFTC_PR_EligibleCollateralEnum, EquityTypeEnum, FundProductTypeEnum, DebtClassEnum, DebtSeniorityEnum, DebtInterestEnum, DebtPrincipalEnum,
  IssuerTypeEnum, SupraNationalIssuerTypeEnum, CreditRiskEnum, AssetTypeEnum, ObligationCategoryEnum, CommodityLocationIdentifierTypeEnum, CounterpartyRoleEnum, AncillaryRoleEnum, PartyRoleEnum, AccountTypeEnum,
  NaturalPersonRoleEnum, PartyIdentifierTypeEnum, PersonIdentifierTypeEnum, TelephoneTypeEnum, EventIntentEnum, CorporateActionTypeEnum, PositionEventIntentEnum, QuantityChangeDirectionEnum, NotionalAdjustmentEnum, PositionStatusEnum,
  TransferStatusEnum, FeeTypeEnum, ScheduledTransferEnum, TradeIdentifierTypeEnum, ValuationTypeEnum, ValuationSourceEnum, PriceTimingEnum, ExecutionTypeEnum, GoverningLawEnum, CreditEventTypeEnum,
  RecordAmountTypeEnum, FloatingRateIndexEnum, RegMarginTypeEnum, RegIMRoleEnum, CollateralStatusEnum, HaircutIndicatorEnum, CallTypeEnum, MarginCallActionEnum, MarginCallResponseTypeEnum, AvailableInventoryTypeEnum,
  ActionEnum, EventTimestampQualificationEnum, WorkflowStatusEnum, WarehouseIdentityEnum, CreditLimitTypeEnum, LimitLevelEnum, PeriodTimeEnum, MatrixTypeEnum, MatrixTermEnum, ContractualSupplementTypeEnum,
  ResourceTypeEnum, LengthUnitEnum, LegalAgreementPublisherEnum, LegalAgreementTypeEnum, CreditSupportAgreementTypeEnum, CollateralMarginTypeEnum, ContractualDefinitionsEnum, MasterAgreementTypeEnum, MasterConfirmationTypeEnum, MasterConfirmationAnnexTypeEnum,
  ClosedStateEnum, MasterAgreementClauseIdentifierEnum, MasterAgreementVariantIdentifierEnum, ReturnTypeEnum, InterpolationMethodEnum, NationalizationOrInsolvencyOrDelistingEventEnum, StandardizedScheduleAssetClassEnum, StandardizedScheduleProductClassEnum, CalculationMethodEnum, ObservationPeriodDatesEnum,
  ISOCurrencyCodeEnum, FloatingRateIndexCategoryEnum, FloatingRateIndexStyleEnum, FloatingRateIndexCalculationMethodEnum, InflationRateIndexEnum, IndexAnnexSourceEnum, CreditSeniorityEnum, PremiumTypeEnum, CashPriceTypeEnum, ArithmeticOperationEnum,
  PriceOperandEnum, PriceTypeEnum, PriceExpressionEnum, InformationProviderEnum, QuoteBasisEnum, CommodityReferencePriceEnum, QuotationStyleEnum, DeterminationMethodEnum, TimeTypeEnum, SettlementRateOptionEnum,
  CreditRatingAgencyEnum, CreditRatingOutlookEnum, CreditRatingCreditWatchEnum, QuantifierEnum, CreditNotationMismatchResolutionEnum, PartyDeterminationEnum, QuotationRateTypeEnum, ValuationMethodEnum, CsaTypeEnum, TriggerTypeEnum,
  TriggerTimeTypeEnum, RestructuringEnum, RateTreatmentEnum, NegativeInterestRateTreatmentEnum, LoadTypeEnum, BankHolidayTreatmentEnum, DayCountFractionEnum, CompoundingMethodEnum, SpreadCalculationMethodEnum, InterestShortfallCapEnum,
  EntityTypeEnum, SettledEntityMatrixSourceEnum, DividendDateReferenceEnum, DividendEntitlementEnum, DividendAmountTypeEnum, DividendPeriodEnum, NonCashDividendTreatmentEnum, DividendCompositionEnum, FPVFinalPriceElectionFallbackEnum, RealisedVarianceMethodEnum,
  DiscountingTypeEnum, AveragingWeightingMethodEnum, InflationCalculationMethodEnum, InflationCalculationStyleEnum, FinalPrincipalExchangeCalculationEnum, SpreadScheduleTypeEnum, ISOCountryCodeEnum, CurrencyCodeEnum, CollateralTypeEnum, CreditNotationBoundaryEnum,
  RatingPriorityResolutionEnum, ConcentrationLimitTypeEnum, AverageTradingVolumeMethodologyEnum, MaturityTypeEnum, CompoundingTypeEnum, RoundingFrequencyEnum, CollateralInterestHandlingEnum, AlternativeToInterestAmountEnum, DeliveryAmountElectionEnum, StubPeriodTypeEnum,
  DayDistributionEnum, ResetRelativeToEnum, MarketDisruptionEnum, PayRelativeToEnum, WeeklyRollConventionEnum, RollSourceCalendarEnum, CashSettlementMethodEnum, SettlementTypeEnum, TransferSettlementEnum, SettlementCentreEnum,
  StandardSettlementStyleEnum, OptionTypeEnum, CallingPartyEnum, AveragingInOutEnum, OptionExerciseStyleEnum, ExpirationTimeTypeEnum, ExerciseNoticeGiverEnum, PayerReceiverEnum, AssetPayoutTradeTypeEnum, DeliveryMethodEnum
    } from './enums';

/**
 * A class to specify an account as an account number alongside, optionally. an account name, an account type, an account beneficiary and a servicing party.
 */
export interface Account {
  /**
   * A reference to the party to which the account refers to.
   */
  partyReference?: ReferenceWithMeta<Party>;
  /**
   * The account number.
   */
  accountNumber?: FieldWithMeta<String>;
  /**
   * The name by which the account is known.
   */
  accountName?: FieldWithMeta<String>;
  /**
   * The type of account, e.g. client, house.
   */
  accountType?: FieldWithMeta<AccountTypeEnum>;
  /**
   * A reference to the party beneficiary of the account.
   */
  accountBeneficiary?: ReferenceWithMeta<Party>;
  /**
   * The reference to the legal entity that services the account, i.e. in the books of which the account is held.
   */
  servicingParty?: ReferenceWithMeta<Party>;
  meta?: MetaFields;
}
  
export interface AcctOwnr {
  id?: Id;
}
  
/**
 * A type for defining the Additional Disruption Events.
 */
export interface AdditionalDisruptionEvents {
  /**
   * Per 2002 ISDA Equity Derivatives Definitions: 
   */
  changeInLaw?: boolean;
  /**
   * Per 2002 ISDA Equity Derivatives Definitions
   */
  failureToDeliver?: boolean;
  /**
   * Per 2002 ISDA Equity Derivatives Definitions
   */
  insolvencyFiling?: boolean;
  /**
   * Per 2002 ISDA Equity Derivatives Definitions
   */
  hedgingDisruption?: boolean;
  /**
   * Per 2002 ISDA Equity Derivatives Definitions
   */
  increasedCostOfHedging?: boolean;
  /**
   * Per ISDA Def 
   */
  foreignOwnershipEvent?: boolean;
  /**
   * Per 2002 ISDA Equity Derivatives Definitions:
   */
  lossOfStockBorrow?: boolean;
  /**
   * Specifies the maximum stock loan rate for Loss of Stock Borrow. A percentage of 5% is represented as 0.05.
   */
  maximumStockLoanRate?: number;
  /**
   * Per 2002 ISDA Equity Derivatives Definitions
   */
  increasedCostOfStockBorrow?: boolean;
  /**
   * Specifies the initial stock loan per ISDA Def. A percentage of 5% is represented as 0.05.
   */
  initialStockLoanRate?: number;
  /**
   * Specifies the party which determines additional disruption events.
   */
  determiningParty?: AncillaryRoleEnum;
  /**
   * Where parties may optionnaly describe any extra bespoke agreements, in regards of the standardized Extraordinary Events.
   */
  additionalBespokeTerms?: Clause[];
}
  
/**
 * A class to specify the events that will give rise to the payment additional fixed payments.
 */
export interface AdditionalFixedPayments {
  /**
   * An additional Fixed Payment Event. Corresponds to the payment by or on behalf of the Issuer of an actual interest amount in respect to the reference obligation that is greater than the expected interest amount. ISDA 2003 Term: Interest Shortfall Reimbursement.
   */
  interestShortfallReimbursement?: boolean;
  /**
   * An additional Fixed Payment Event. Corresponds to the payment by or on behalf of the Issuer of an actual principal amount in respect to the reference obligation that is greater than the expected principal amount. ISDA 2003 Term: Principal Shortfall Reimbursement.
   */
  principalShortfallReimbursement?: boolean;
  /**
   * An Additional Fixed Payment. Corresponds to the payment by or on behalf of the issuer of an amount in respect to the reference obligation in reduction of the prior writedowns. ISDA 2003 Term: Writedown Reimbursement.
   */
  writedownReimbursement?: boolean;
}
  
/**
 * A class to specify a post or street address.
 */
export interface Address {
  /**
   * The set of street and building number information that identifies a postal address within a city.
   */
  street?: string[];
  /**
   * The city component of the postal address.
   */
  city?: string;
  /**
   * A country subdivision used in postal addresses in some countries. For example, US states, Canadian provinces, Swiss cantons, ...
   */
  state?: string;
  /**
   * The ISO 3166 standard code for the country within which the postal address is located.
   */
  country?: FieldWithMeta<String>;
  /**
   * The code, required for computerized mail sorting systems, that is allocated to a physical address by a national postal authority.
   */
  postalCode?: string;
}
  
/**
 * Specification of the address and other details for notices.
 */
export interface AddressForNotices {
  /**
   * Specification of primary notice details
   */
  primaryNotices?: ContactElection;
  /**
   * The optional specification of additional information when a party requires notices to be delivered to more than one address.
   */
  additionalNotices?: PartyContactInformation[];
}
  
export interface AddtlAttrbts {
  rskRdcgTx?: string;
  sctiesFincgTxInd?: string;
}
  
/**
 * A class for defining a date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
 */
export interface AdjustableDate {
  /**
   * A date subject to adjustment. While in FpML this date is required, this cardinality constraint has been relaxed as part of the CDM in order to support the FRA representation, which effective and termination dates are specified in FpML as adjusted dates.
   */
  unadjustedDate?: Date;
  /**
   * The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
   */
  dateAdjustments?: BusinessDayAdjustments;
  /**
   * A pointer style reference to date adjustments defined elsewhere in the document.
   */
  dateAdjustmentsReference?: ReferenceWithMeta<BusinessDayAdjustments>;
  /**
   * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
   */
  adjustedDate?: FieldWithMeta<Date>;
  meta?: MetaFields;
}
  
/**
 * A class for defining a series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the dates.
 */
export interface AdjustableDates {
  /**
   * A date subject to adjustment.
   */
  unadjustedDate?: Date[];
  /**
   * The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
   */
  dateAdjustments?: BusinessDayAdjustments;
  /**
   * The date(s) once the adjustment has been performed. (Note that this date may change if the business center holidays change).
   */
  adjustedDate?: FieldWithMeta<Date>[];
  meta?: MetaFields;
}
  
/**
 * A class for defining a date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
 */
export interface AdjustableOrAdjustedDate {
  /**
   * A date subject to adjustment.
   */
  unadjustedDate?: Date;
  /**
   * The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
   */
  dateAdjustments?: BusinessDayAdjustments;
  /**
   * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
   */
  adjustedDate?: FieldWithMeta<Date>;
  meta?: MetaFields;
}
  
/**
 * This Rosetta class specifies the date as either an unadjusted, adjusted or relative date. It supplements the features of the AdjustableOrAdjustedDate to support the credit default swap option premium, which uses the relative date construct.
 */
export interface AdjustableOrAdjustedOrRelativeDate {
  /**
   * A date subject to adjustment.
   */
  unadjustedDate?: Date;
  /**
   * The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
   */
  dateAdjustments?: BusinessDayAdjustments;
  /**
   * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
   */
  adjustedDate?: FieldWithMeta<Date>;
  /**
   * A date specified as some offset to another date (the anchor date).
   */
  relativeDate?: RelativeDateOffset;
}
  
/**
 * A class giving the choice between defining a date as an explicit date together with applicable adjustments or as relative to some other (anchor) date.
 */
export interface AdjustableOrRelativeDate {
  /**
   * A date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
   */
  adjustableDate?: AdjustableDate;
  /**
   * A date specified as some offset to another date (the anchor date).
   */
  relativeDate?: AdjustedRelativeDateOffset;
  meta?: MetaFields;
}
  
/**
 * A class giving the choice between defining a series of dates as an explicit list of dates together with applicable adjustments or as relative to some other series of (anchor) dates.
 */
export interface AdjustableOrRelativeDates {
  /**
   * A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
   */
  adjustableDates?: AdjustableDates;
  /**
   * A series of dates specified as some offset to another series of dates (the anchor dates).
   */
  relativeDates?: RelativeDates;
  meta?: MetaFields;
}
  
/**
 * A class giving the choice between defining a series of dates as an explicit list of dates together with applicable adjustments or as relative to some other series of (anchor) dates, or as a calculation period schedule.
 */
export interface AdjustableRelativeOrPeriodicDates {
  /**
   * A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
   */
  adjustableDates?: AdjustableDates;
  /**
   * A series of dates specified as some offset to another series of dates (the anchor dates).
   */
  relativeDates?: RelativeDates;
  /**
   * A calculation period schedule.
   */
  periodicDates?: PeriodicDates;
  meta?: MetaFields;
}
  
/**
 * A type defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date) plus optional date adjustments.
 */
export interface AdjustedRelativeDateOffset extends RelativeDateOffset {
  /**
   * A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
   */
  periodMultiplier?: number;
  /**
   * A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
   */
  period?: PeriodEnum;
  meta?: MetaFields;
  /**
   * In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
   */
  dayType?: DayTypeEnum;
  /**
   * The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
   */
  businessDayConvention?: BusinessDayConventionEnum;
  businessCenters?: BusinessCenters;
  /**
   * A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
   */
  businessCentersReference?: ReferenceWithMeta<BusinessCenters>;
  /**
   * Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
   */
  dateRelativeTo?: ReferenceWithMeta<Date>;
  /**
   * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
   */
  adjustedDate?: Date;
  /**
   * The business day convention and financial business centers used for adjusting the relative date if it would otherwise fall on a day that is not a business date in the specified business centers.
   */
  relativeDateAdjustments?: BusinessDayAdjustments;
}
  
/**
 * Represents a class to specify a credit notation.
 */
export interface AgencyRatingCriteria {
  /**
   * Indicates the agency rating criteria specified for the asset or issuer.
   */
  creditNotation?: CreditNotation;
  /**
   * Indicator for options to be used if several agency ratings (>1) are specified and its necessary to identify specific charateristics. i.e (lowest or highest).
   */
  mismatchResolution?: CreditNotationMismatchResolutionEnum;
  /**
   * identifies the dominant reference agency if there is a missmatch and several reference agencies exsist.
   */
  referenceAgency?: CreditRatingAgencyEnum;
  /**
   * Indicates the boundary of a credit agency rating i.e minimum or maximum.
   */
  boundary?: CreditNotationBoundaryEnum;
}
  
/**
 *  Parameters to be used to filter events that are relevant to a given portfolio in order to calculate the state of this portfolio. The attributes correspond to all the possible aggregation criteria that can be used and these criteria can be combined. All the attributes are optional.
 */
export interface AggregationParameters {
  /**
   * To aggregate as of a particular date
   */
  dateTime?: Date;
  /**
   * Specifies whether to calculate total position to given date, or only daily position for the given date.
   */
  totalPosition?: boolean;
  /**
   * To aggregate based on position status (EXECUTED, SETTLED etc)
   */
  positionStatus?: PositionStatusEnum;
  /**
   * To aggregate based on a selection of party(ies) / legal entity(ies).
   */
  party?: ReferenceWithMeta<Party>[];
  /**
   * To aggregate based on a selection of products.
   */
  product?: NonTransferableProduct[];
  /**
   * To aggregate based on a selection of product type(s).
   */
  productQualifier?: string[];
  tradeReference?: ReferenceWithMeta<Trade>[];
}
  
/**
 * Specification of the standard set of terms that define a legal agreement.
 */
export interface Agreement {
  /**
   * Elections to specify a Credit Support Annex or Credit Support Deed for Intial or Variation Margin.
   */
  creditSupportAgreementElections?: CreditSupportAgreementElections;
  /**
   * Elections to specify a Collateral Transfer Agreement.
   */
  collateralTransferAgreementElections?: CollateralTransferAgreementElections;
  /**
   * Elections to specify a Security agreement.
   */
  securityAgreementElections?: SecurityAgreementElections;
  /**
   * Elections to specify a Master Agreement Schedule.
   */
  masterAgreementSchedule?: MasterAgreementSchedule;
  /**
   * Any additional terms which mainly intend to specify the extraordinary events that may affect a trade and the related contractual rights and obligation of the parties when this happens
   */
  transactionAdditionalTerms?: TransactionAdditionalTerms;
}
  
/**
 * Specifies the agreement name through an agreement type and optional detailed sub agreement type.
 */
export interface AgreementName {
  /**
   * Specification of the legal agreement type.
   */
  agreementType?: LegalAgreementTypeEnum;
  /**
   * Specification of the credit support agreement type.
   */
  creditSupportAgreementType?: FieldWithMeta<CreditSupportAgreementTypeEnum>;
  /**
   * specifies the type of margin for which a legal agreement is named.
   */
  creditSupportAgreementMarginType?: CollateralMarginTypeEnum;
  /**
   * The definitions such as those published by ISDA that will define the terms of the trade.
   */
  contractualDefinitionsType?: FieldWithMeta<ContractualDefinitionsEnum>[];
  /**
   * A contractual supplement (such as those published by ISDA) that will apply to the trade.
   */
  contractualTermsSupplement?: ContractualTermsSupplement[];
  /**
   * A reference to a contractual matrix of elected terms/values (such as those published by ISDA) that shall be deemed to apply to the trade. The applicable matrix is identified by reference to a name and optionally a publication date. Depending on the structure of the matrix, an additional term (specified in the matrixTerm element) may be required to further identify a subset of applicable terms/values within the matrix.
   */
  contractualMatrix?: ContractualMatrix[];
  /**
   * Specification of the master agreement type.
   */
  masterAgreementType?: FieldWithMeta<MasterAgreementTypeEnum>;
  /**
   * The type of master confirmation executed between the parties.
   */
  masterConfirmationType?: FieldWithMeta<MasterConfirmationTypeEnum>;
  /**
   * The type of master confirmation annex executed between the parties.
   */
  masterConfirmationAnnexType?: FieldWithMeta<MasterConfirmationAnnexTypeEnum>;
  /**
   * Definition of an agreement that is not enumerated in the CDM.
   */
  otherAgreement?: string;
}
  
/**
 * Specification of the content of a legal agreement.
 */
export interface AgreementTerms {
  /**
   * Specification of the standard set of terms that define a legal agreement.
   */
  agreement?: Agreement;
  /**
   * Specification of whether the agreement terms have been negotiated using the clause library methodology.
   */
  clauseLibrary?: boolean;
  /**
   * Specification of the roles of the counterparties to the agreement.
   */
  counterparty?: Counterparty[];
}
  
/**
 * Used to combine two or more Collateral Criteria using AND logic.
 */
export interface AllCriteria {
  allCriteria?: CollateralCriteria[];
}
  
/**
 * A class to specify a currency amount or a currency amount schedule.
 */
export interface AmountSchedule extends Schedule {
  /**
   * The initial rate or amount, as the case may be. An initial rate of 5% would be represented as 0.05.
   */
  value?: number;
  /**
   * The schedule of step date and value pairs. On each step date the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
   */
  datedValue?: DatedValue[];
  /**
   * The currency in which the amount schedule is denominated. The currency is specified outside of the actual schedule in order to be applied uniformly to it. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
   */
  currency?: FieldWithMeta<String>[];
}
  
/**
 * Holds an identifier for an ancillary entity, either identified directly via its ancillary role or directly as a legal entity.
 */
export interface AncillaryEntity {
  /**
   * Identifies a party via its ancillary role on a transaction (e.g. CCP or DCO through which the trade should be cleared.)
   */
  ancillaryParty?: AncillaryRoleEnum;
  legalEntity?: LegalEntity;
}
  
/**
 * Defines an ancillary role enumerated value with an associated party reference. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and this AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
 */
export interface AncillaryParty {
  /**
   * Specifies the AncillaryRoleEnum that is associated to the party reference. An ancillary party is any involved party that is not one of the two principal parties to the transaction.
   */
  role?: AncillaryRoleEnum;
  /**
   * Specifies the party, or parties, associated to the ancillary role.
   */
  partyReference?: ReferenceWithMeta<Party>[];
  /**
   * Optionally specifies the counterparty that the ancillary party is acting on behalf of.
   */
  onBehalfOf?: CounterpartyRoleEnum;
}
  
/**
 * Used to combine two or more Collateral Criteria using OR logic.
 */
export interface AnyCriteria {
  anyCriteria?: CollateralCriteria[];
}
  
/**
 * As per ISDA 2002 Definitions.
 */
export interface Asian {
  averagingInOut?: AveragingInOutEnum;
  /**
   * The factor of strike.
   */
  strikeFactor?: number;
  /**
   * The averaging in period.
   */
  averagingPeriodIn?: AveragingPeriod;
  /**
   * The averaging out period.
   */
  averagingPeriodOut?: AveragingPeriod;
}
  
/**
 * An Asset is defined as something that can be owned and transferred in the financial markets. As a choice data type, one and only one of the attributes must be used.
 */
export interface Asset {
  /**
   * An Asset that consists solely of a monetary holding in a currency.
   */
  cash?: Cash;
  /**
   * An Asset comprised of raw or refined materials or agricultural products, eg gold, oil or wheat.
   */
  commodity?: Commodity;
  /**
   * An Asset that exists only in digital form, eg Bitcoin or Ethereum; excludes the digital representation of other Assets.
   */
  digitalAsset?: DigitalAsset;
  /**
   * An asset that is issued by one party to one or more others; Instrument is also a choice data type.
   */
  instrument?: Instrument;
}
  
export interface AssetAgencyRating {
  /**
   * Represents an agency rating based on default risk and creditors claim in event of default associated with specific instrument.
   */
  assetAgencyRating?: AgencyRatingCriteria;
}
  
/**
 * The base data type to specify common attributes for all Assets.
 */
export interface AssetBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
}
  
export interface AssetCountryOfOrigin {
  /**
   * Represents a filter on the asset country of origin based on the ISO Standard 3166.
   */
  assetCountryOfOrigin?: ISOCountryCodeEnum;
}
  
/**
 * Contains the information relative to the delivery of the asset.
 */
export interface AssetDeliveryInformation {
  /**
   * Defines the periods of delivery, including the delivery profile.
   */
  periods?: AssetDeliveryPeriods;
  /**
   * Defines the location of the delivery of the commodity.
   */
  location?: LocationIdentifier[];
  /**
   * The number of units included in the transaction for each delivery interval
   */
  deliveryCapacity?: Quantity;
}
  
/**
 * Defines the periods of delivery, including the delivery profile.
 */
export interface AssetDeliveryPeriods {
  /**
   * Defines the delivery profile of the asset, including the load type and the delivery intervals.
   */
  profile?: AssetDeliveryProfile[];
  /**
   * Delivery start date
   */
  startDate?: Date;
  /**
   * Delivery end date
   */
  endDate?: Date;
}
  
/**
 * Defines the delivery profile of the asset, including the load type and the delivery intervals.
 */
export interface AssetDeliveryProfile {
  /**
   * Identification of the delivery profile.
   */
  loadType?: LoadTypeEnum;
  /**
   * Defines a delivery profile block, including start and end time, days of the week, duration, delivery capacity and price time interval quantity.
   */
  block?: AssetDeliveryProfileBlock[];
  /**
   * Specifies whether the dates defined include holidays or not.
   */
  bankHolidaysTreatment?: BankHolidayTreatmentEnum;
}
  
/**
 * Defines a delivery profile block, including start and end time, days of the week, duration, delivery capacity and price time interval quantity.
 */
export interface AssetDeliveryProfileBlock {
  /**
   * The start time of the delivery interval for each block or shape.
   */
  startTime?: string;
  /**
   * The end time of the delivery interval for each block or shape.
   */
  endTime?: string;
  /**
   * The days of the week of the delivery.
   */
  dayOfWeek?: DayOfWeekEnum[];
  /**
   * The number of units included in the transaction for each delivery interval
   */
  deliveryCapacity?: Quantity;
  /**
   * Price per quantity per delivery time interval.
   */
  priceTimeIntervalQuantity?: Price;
}
  
/**
 * Defines the basic parameters of an asset transfer, e.g. a cashflow: what (the asset), how much (the quantity) and when (the settlement date).
 */
export interface AssetFlowBase {
  /**
   * Represents the amount of the asset to be transferred. The cashflow amount is always a positive number, as the cashflow direction is implied by the payer/receiver attribute.
   */
  quantity?: NonNegativeQuantity;
  /**
   * Represents the object that is subject to the transfer, it could be an asset or a reference.
   */
  asset?: Asset;
  /**
   * Represents the date on which the transfer to due.
   */
  settlementDate?: AdjustableOrAdjustedOrRelativeDate;
}
  
/**
 * The unique identifier for an Asset, specified using an Asset Identifier Type enumerator.
 */
export interface AssetIdentifier {
  /**
   * The identifier value.
   */
  identifier?: FieldWithMeta<String>;
  /**
   * Defines the symbology source of the Asset Identifier, eg CUSIP, ISIN, etc.
   */
  identifierType?: AssetIdTypeEnum;
}
  
/**
 * Defines each asset movement of an asset payout.
 */
export interface AssetLeg {
  /**
   * Specifies the settlement date of securities.  In a repo transaction the purchase date would always be the effective date as specified under Economic Terms, the repurchase date would always be the termination date as specified under Economic Terms.
   */
  settlementDate?: AdjustableOrRelativeDate;
  /**
   * Specifies a delivery method for the security transaction.
   */
  deliveryMethod?: DeliveryMethodEnum;
}
  
export interface AssetMaturity {
  /**
   * Specifies whether the maturity range is the remaining or original maturity.
   */
  maturityType?: MaturityTypeEnum;
  /**
   * Represents a filter based on the underlying asset maturity.
   */
  maturityRange?: PeriodRange;
}
  
/**
 * Security finance payout specification in case the product payout involves some form of security collateral, as in a securities financing transaction. Plus additional description for ICMA.
 */
export interface AssetPayout extends PayoutBase {
  /**
   * Canonical representation of the payer and receiver parties applicable to each payout leg.
   */
  payerReceiver?: PayerReceiver;
  /**
   * Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
   */
  priceQuantity?: ResolvablePriceQuantity;
  /**
   * The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
   */
  principalPayment?: PrincipalPayments;
  /**
   * Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
   */
  settlementTerms?: SettlementTerms;
  /**
   * Defines each asset movement as a buy/sell at different dates, typically 1 near leg and 1 far leg in a securities financing transaction.
   */
  assetLeg?: AssetLeg[];
  /**
   * Specifies the Purchased Asset, usually a Security.
   */
  underlier?: Asset;
  /**
   * A contractual minimum amount which the borrower will pay, regardless of the duration of the loan. A mechanism for making sure that a trade generates enough income.
   */
  minimumFee?: Money;
  /**
   * Specifies the terms under which dividends received by the borrower are passed through to the lender.
   */
  dividendTerms?: DividendTerms;
  /**
   * The trade type, eg repurchase transaction or buy/sell-back.
   */
  tradeType?: AssetPayoutTradeTypeEnum;
}
  
/**
 * Represents a class to allow specification of the asset product type.
 */
export interface AssetType {
  /**
   * Represents a filter based on the type of collateral asset.
   */
  assetType?: AssetTypeEnum;
  /**
   * Represents a filter based on the type of security.
   */
  securityType?: InstrumentTypeEnum;
  /**
   * Represents a filter based on the type of bond.
   */
  debtType?: DebtType;
  /**
   * Represents a filter based on the type of equity.
   */
  equityType?: EquityTypeEnum;
  /**
   * Represents a filter based on the type of fund.
   */
  fundType?: FundProductTypeEnum;
  /**
   * Specifies the eligible asset type when not enumerated.
   */
  otherAssetType?: string[];
}
  
/**
 * A class to specify the identifier value and its associated version.
 */
export interface AssignedIdentifier {
  /**
   * The identifier value.
   */
  identifier?: FieldWithMeta<String>;
  /**
   * The identifier version, which is specified as an integer and is meant to be incremented each time the transaction terms (whether contract or event) change. This version is made option to support the use case where the identifier is referenced without the version. The constraint that a contract and a lifecycle event need to have an associated version is enforced through data rules.
   */
  version?: number;
}
  
/**
 * A type to define automatic exercise of a swaption. With automatic exercise the option is deemed to have exercised if it is in the money by more than the threshold amount on the exercise date.
 */
export interface AutomaticExercise {
  /**
   * A threshold rate. The threshold of 0.10% would be represented as 0.001
   */
  thresholdRate?: number;
  /**
   * Boolean that indicates if it has an automaticExercise
   */
  isApplicable?: boolean;
}
  
/**
 * A data type that can be used to describe the inventory of securities that a party holds. The securities are held in the AvailableInventoryRecord, with each item in the array being an individual security and its associated criteria. Criteria can include the quantity available, the rate at which the security is available to borrow at, as well as other details that can affect the decision as to whether a party wants to utilise the securities listed.
 */
export interface AvailableInventory {
  /**
   * Defines the purpose of this inventory.
   */
  availableInventoryType?: AvailableInventoryTypeEnum;
  /**
   * Allows details related to the availability messaging use case to be defined
   */
  messageInformation?: MessageInformation;
  /**
   * Defines all parties involved for the list of inventory records in this set of inventory. For example, when used to describe securities lending availability, this could hold the sender of the availability, the intended recipient, the beneficial owner(s), the lender (which may differ from the sender as the lender may have the same piece of availability going through multiple agents), an agent or a venue.
   */
  party?: Party[];
  /**
   * Defines the role(s) that party(ies) may have in relation to the inventory.
   */
  partyRole?: PartyRole[];
  /**
   * An array holding the list of inventory being described. Each element in the inventoryRecord array represents an individual piece of inventory i.e. a security.
   */
  availableInventoryRecord?: AvailableInventoryRecord[];
}
  
/**
 * An individual piece of available inventory. This represents a single security and its associated criteria. The criteria are used to describe any restrictions on the securities.
 */
export interface AvailableInventoryRecord extends InventoryRecord {
  /**
   * Unique identifier for this record. This can be used to uniquely identify a specific piece of inventory.
   */
  identifer?: AssignedIdentifier;
  /**
   * The security details.
   */
  security?: Security;
  /**
   * There may be a set period/time restriction associated to the security.
   */
  expirationDateTime?: Date;
  /**
   * The type of collateral can often be required when determining if the piece of availability being described is suitable for a party.
   */
  collateral?: CollateralProvisions[];
  /**
   * An individual security may be held by several agents. Including the party role at this level allows us to reference the party holding this specific item.
   */
  partyRole?: PartyRole[];
  /**
   * The quantity of the security
   */
  quantity?: Quantity;
  /**
   * An optional element which can be used to hold a rate associated to this piece of availability.
   */
  interestRate?: Price;
}
  
/**
 * Represents the average trading volume of an Equity product upon an exchange or set of exchanges.
 */
export interface AverageTradingVolume {
  /**
   * Represents the period of the equities average trading volume on the exchange/s.
   */
  period?: Period;
  /**
   * Indicates the type of equity average trading volume being stated (single) the highest amount on one exchange, or (consolidated) volumes across multiple exchanges.
   */
  methodology?: AverageTradingVolumeMethodologyEnum;
}
  
/**
 * Defines parameters for use in cases when a valuation or other term is based on an average of market observations.
 */
export interface AveragingCalculation {
  /**
   * Specifies enumerations for the type of averaging calculation.
   */
  averagingMethod?: AveragingCalculationMethod;
  /**
   * Rounding applied to the average calculation. 
   */
  precision?: Rounding;
}
  
/**
 * Defines the ways in which multiple values can be aggregated into a single value.
 */
export interface AveragingCalculationMethod {
  /**
   * Identifies whether the average values will be weighted or unweighted.
   */
  isWeighted?: boolean;
  /**
   * Identifies which of the Pythagorean means is being used to compute an average value.
   */
  calculationMethod?: AveragingCalculationMethodEnum;
}
  
/**
 * An unordered list of weighted averaging observations.
 */
export interface AveragingObservationList {
  /**
   * A single weighted averaging observation.
   */
  averagingObservation?: WeightedAveragingObservation[];
}
  
/**
 * Period over which an average value is taken.
 */
export interface AveragingPeriod {
  /**
   * A schedule for generating averaging observation dates.
   */
  schedule?: AveragingSchedule[];
  /**
   * An unweighted list of averaging observation date and times.
   */
  averagingDateTimes?: DateTimeList;
  /**
   * A weighted list of averaging observation date and times.
   */
  averagingObservations?: AveragingObservationList;
  /**
   * The market disruption event as defined by ISDA 2002 Definitions.
   */
  marketDisruption?: FieldWithMeta<MarketDisruptionEnum>;
}
  
/**
 * Class to representing a method for generating a series of dates.
 */
export interface AveragingSchedule {
  /**
   * Date on which this period begins.
   */
  startDate?: Date;
  /**
   * Date on which this period ends.
   */
  endDate?: Date;
  /**
   * The frequency at which averaging period occurs with the regular part of the valuation schedule and their roll date convention.
   */
  averagingPeriodFrequency?: CalculationPeriodFrequency;
}
  
/**
 * Defines the terms required to calculate the average observations associated with an averaging strike.
 */
export interface AveragingStrikeFeature {
  /**
   * Defines parameters for use in cases when a valuation or other term is based on an average of market observations.
   */
  averagingCalculation?: AveragingCalculation;
  /**
   * Class containing terms that are associated with observing a price/benchmark/index across either single or multple observations. 
   */
  observationTerms?: ObservationTerms;
}
  
/**
 * As per ISDA 2002 Definitions.
 */
export interface Barrier {
  /**
   * A trigger level approached from beneath.
   */
  barrierCap?: TriggerEvent;
  /**
   * A trigger level approached from above.
   */
  barrierFloor?: TriggerEvent;
}
  
/**
 * Defines a custom basket by referencing an identifier and its constituents.
 */
export interface Basket extends AssetBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
  /**
   * Identifies the constituents of the basket
   */
  basketConstituent?: FieldWithMeta<BasketConstituent>[];
}
  
/**
 * Identifies the constituents of the basket
 */
export interface BasketConstituent extends Observable {
  /**
   * The object to be observed is an Asset, ie something that can be owned and transferred in the financial markets.
   */
  asset?: Asset;
  /**
   * The object to be observed is a Basket, ie a collection of Observables with an identifier and optional weightings.
   */
  basket?: Basket;
  /**
   * The object to be observed is an Index, ie an observable computed on the prices, rates or valuations of a number of assets.
   */
  index?: Index;
  /**
   * Specifies a quantity schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->quantity that this quantity is referencing.
   */
  quantity?: ReferenceWithMeta<NonNegativeQuantitySchedule>[];
  /**
   * Specifies an initial price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->price that this price is referencing.
   */
  initialValuationPrice?: ReferenceWithMeta<PriceSchedule>[];
  /**
   * Specifies an interim price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->price that this price is referencing.
   */
  interimValuationPrice?: ReferenceWithMeta<PriceSchedule>[];
  /**
   * Specifies a final price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->price that this price is referencing.
   */
  finalValuationPrice?: ReferenceWithMeta<PriceSchedule>[];
}
  
/**
 * CDS Basket Reference Information.
 */
export interface BasketReferenceInformation {
  /**
   * The name of the basket expressed as a free format string. FpML does not define usage rules for this element.
   */
  basketName?: FieldWithMeta<String>;
  /**
   * A CDS basket identifier.
   */
  basketId?: FieldWithMeta<String>[];
  /**
   * This element contains all the reference pool items to define the reference entity and reference obligation(s) in the basket.
   */
  referencePool?: ReferencePool;
  /**
   * N th reference obligation to default triggers payout.
   */
  nthToDefault?: number;
  /**
   * M th reference obligation to default to allow representation of N th to M th defaults.
   */
  mthToDefault?: number;
  /**
   * This element contains CDS tranche terms.
   */
  tranche?: Tranche;
}
  
/**
 * Specifies the instructions for creation of a Security Lending billing invoice.
 */
export interface BillingInstruction {
  /**
   * The party issuing the invoice
   */
  sendingParty?: Party;
  /**
   * The party receiving the invoice
   */
  receivingParty?: Party;
  /**
   * The starting date of the period described by this invoice
   */
  billingStartDate?: Date;
  /**
   * The ending date of the period described by this invoice
   */
  billingEndDate?: Date;
  /**
   * Instructions for creating the billing records contained within the invoice
   */
  billingRecordInstruction?: BillingRecordInstruction[];
  /**
   * The billing summaries contained within the invoice
   */
  billingSummary?: BillingSummaryInstruction[];
}
  
/**
 * Specifies individual records within a billing invoice.
 */
export interface BillingRecord {
  /**
   * The trade for the individual billing record.
   */
  tradeState?: ReferenceWithMeta<TradeState>;
  /**
   * The settlement terms for the billing record
   */
  recordTransfer?: Transfer;
  /**
   * The starting date of the period described by this record
   */
  recordStartDate?: Date;
  /**
   * The ending date of the period described by this record
   */
  recordEndDate?: Date;
  /**
   * Indicates the minimum fee amount applied to the billing record, if any.
   */
  minimumFee?: Money;
}
  
/**
 * Specifies the instructions for creation of a billing record.
 */
export interface BillingRecordInstruction {
  /**
   * The trade for the individual billing record.
   */
  tradeState?: ReferenceWithMeta<TradeState>;
  /**
   * The observations used to calculate the billing amount.
   */
  observation?: Observation[];
  /**
   * The starting date of the period described by this record
   */
  recordStartDate?: Date;
  /**
   * The ending date of the period described by this record
   */
  recordEndDate?: Date;
  /**
   * The date for settlement of the transfer.
   */
  settlementDate?: Date;
}
  
/**
 * Specifies individual summaries within a billing invoice.
 */
export interface BillingSummary {
  /**
   * The settlement terms for the billing summary
   */
  summaryTransfer?: Transfer;
  /**
   * The account level for the billing summary.
   */
  summaryAmountType?: RecordAmountTypeEnum;
}
  
/**
 * Specifies the instructions for creation of a billing summary.
 */
export interface BillingSummaryInstruction {
  /**
   * The account level for the billing summary.
   */
  summaryAmountType?: RecordAmountTypeEnum;
}
  
/**
 * Reference to a bond underlier to represent an asset swap or Condition Precedent Bond.
 */
export interface BondReference {
  /**
   * Reference to a bond underlier.
   */
  bond?: Security;
  /**
   * To indicate whether the Condition Precedent Bond is applicable. The swap contract is only valid if the bond is issued and if there is any dispute over the terms of fixed stream then the bond terms would be used.
   */
  conditionPrecedentBond?: boolean;
  /**
   * To indicate whether the Discrepancy Clause is applicable.
   */
  discrepancyClause?: boolean;
  /**
   * Specifies the coupon rate (expressed in percentage) of a fixed income security or convertible bond.
   */
  couponRate?: FixedRateSpecification;
}
  
/**
 * Describes correlation bounds, which form a cap and a floor on the realized correlation.
 */
export interface BoundedCorrelation {
  /**
   * Minimum Boundary as a percentage of the Strike Price.
   */
  minimumBoundaryPercent?: number;
  /**
   * Maximum Boundary as a percentage of the Strike Price.
   */
  maximumBoundaryPercent?: number;
}
  
export interface BoundedVariance {
  /**
   * The contract specifies which price must satisfy the boundary condition.
   */
  realisedVarianceMethod?: RealisedVarianceMethodEnum;
  /**
   * The contract specifies whether the notional should be scaled by the Number of Days in Range divided by the Expected N. The number of Days in Ranges refers to the number of returns that contribute to the realized volatility.
   */
  daysInRangeAdjustment?: boolean;
  /**
   * All observations above this price level will be excluded from the variance calculation.
   */
  upperBarrier?: number;
  /**
   * All observations below this price level will be excluded from the variance calculation.
   */
  lowerBarrier?: number;
}
  
/**
 * A class for defining a time with respect to a business day calendar location. For example, 11:00:00 GBLO.
 */
export interface BusinessCenterTime {
  /**
   * A time specified in hh:mm:ss format where the second component must be '00', e.g. 11am would be represented as 11:00:00.
   */
  hourMinuteTime?: string;
  /**
   * A code identifying a business day calendar location. A business day calendar location is drawn from the list identified by the business day calendar location enumeration.
   */
  businessCenter?: FieldWithMeta<BusinessCenterEnum>;
}
  
/**
 * A class for specifying the business day calendar location used in determining whether a day is a business day or not, either by specifying this business center by reference to an enumerated list that is maintained by the FpML standard, or by reference to such specification when it exists elsewhere as part of the instance document. This class corresponds to the FpML BusinessCentersOrReference.model.
 */
export interface BusinessCenters {
  /**
   * A code identifying one or several business day calendar location(s). The set of business day calendar locations are specified by the business day calendar location enumeration which is maintained by the FpML standard.
   */
  businessCenter?: FieldWithMeta<BusinessCenterEnum>[];
  commodityBusinessCalendar?: FieldWithMeta<CommodityBusinessCalendarEnum>[];
  /**
   * A reference to a financial business center location specified elsewhere in the instance document.
   */
  businessCentersReference?: ReferenceWithMeta<BusinessCenters>;
  meta?: MetaFields;
}
  
/**
 * A class defining a range of contiguous business days by defining an unadjusted first date, an unadjusted last date and a business day convention and business centers for adjusting the first and last dates if they would otherwise fall on a non business day in the specified business centers. The days between the first and last date must also be good business days in the specified centers to be counted in the range.
 */
export interface BusinessDateRange extends DateRange {
  /**
   * The first date of a date range.
   */
  startDate?: Date;
  /**
   * The last date of a date range.
   */
  endDate?: Date;
  /**
   * The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
   */
  businessDayConvention?: BusinessDayConventionEnum;
  /**
   * The business center(s), specified either explicitly or by reference to those specified somewhere else in the instance document.
   */
  businessCenters?: BusinessCenters;
}
  
/**
 * A class defining the business day convention and financial business centers used for adjusting any relevant date if it would otherwise fall on a day that is not a business day in the specified business center.
 */
export interface BusinessDayAdjustments {
  /**
   * The convention for adjusting a date if it would otherwise fall on a day that is not a business day.
   */
  businessDayConvention?: BusinessDayConventionEnum;
  /**
   * The business center(s), specified either explicitly or by reference to those specified somewhere else in the instance document.
   */
  businessCenters?: BusinessCenters;
  meta?: MetaFields;
}
  
/**
 * A business event represents a life cycle event of a trade. The combination of the state changes results in a qualifiable life cycle event. An example of a Business Event is a PartialTermination which is a defined by a quantity change primitive event.
 */
export interface BusinessEvent extends EventInstruction {
  /**
   * The intent attribute is meant to be specified when the event qualification cannot be programmatically inferred from the event features. As a result it is only associated with those primitives that can give way to such ambiguity, the quantityChange being one of those. An example of such is a reduction in the trade notional, which could be interpreted as either a trade correction (unless a maximum period of time post-event is specified as part of the qualification), a partial termination or a portfolio rebalancing in the case of an equity swap. On the other hand, an event such as the exercise is not expected to have an associated intent as there should not be ambiguity.
   */
  intent?: EventIntentEnum;
  corporateActionIntent?: CorporateActionTypeEnum;
  /**
   * Specifies the date on which the event is taking place. This date is equal to the trade date in the case of a simple execution.  However it can be different from the trade date, for example in the case of a partial termination.
   */
  eventDate?: Date;
  /**
   * The date on which the event contractually takes effect, when different from the event date.
   */
  effectiveDate?: Date;
  /**
   * Specifies the package information in case the business event represents several trades executed as a package (hence this attribute is optional). The package information is only instantiated once at the business event level to preserve referential integrity, whereas individual trades make reference to it to identify that they are part of a package.
   */
  packageInformation?: IdentifiedList;
  /**
   * Specifies the instructions to create the Business Event.
   */
  instruction?: Instruction[];
  /**
   * The CDM event qualifier, which corresponds to the outcome of the isEvent qualification logic which qualifies the lifecycle event as a function of its features (e.g. PartialTermination, ClearingSubmission, Novation, ...).
   */
  eventQualifier?: string;
  /**
   * Specifies the after trade state(s) created.
   */
  after?: TradeState[];
  meta?: MetaFields;
}
  
/**
 * A class to specify an organizational unit.
 */
export interface BusinessUnit {
  /**
   * A name used to describe the organizational unit
   */
  name?: string;
  /**
   * An identifier used to uniquely identify the organizational unit
   */
  identifier?: Identifier;
  /**
   * The contact information for such business unit, when different from the contact information associated with the party.
   */
  contactInformation?: ContactInformation;
  meta?: MetaFields;
}
  
/**
 * This class corresponds to the FpML BuyerSeller.model construct.
 */
export interface BuyerSeller {
  /**
   * Buyer party that can be resolved as one of the two principal parties to the transaction. The party that buys this instrument, i.e. pays for this instrument and receives the rights defined by it. ISDA 2002 Equity Definitions section 1.18: `Buyer` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (b)(i) relating to a Swaption: 'Buyer' means the party that will, on each Premium Payment Date, pay to Seller the Premium | ISDA 2006 Definitions article 12.1 (b)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such in the related Confirmation, or the Exercising Party if neither party is specified | ISDA 2006 Definitions article 12.1 (b)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Buyer` means the Fixed Rate Payer.
   */
  buyer?: CounterpartyRoleEnum;
  /**
   * Seller party that can be resolved as one of the two principal parties to the transaction. The party that sells ('writes') this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. ISDA 2002 Equity Definitions section 1.19: `Seller` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (a)(i) relating to a Swaption: 'Seller' means the party the party specified as such or as writer in the related Confirmation | ISDA 2006 Definitions article 12.1 (a)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such or as writer in the related Confirmation or, if neither party is specified as such, the Non-exercising Party | ISDA 2006 Definitions article 12.1 (a)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Seller` means the Floating Rate Payer.
   */
  seller?: CounterpartyRoleEnum;
}
  
export interface Buyr {
  acctOwnr?: AcctOwnr;
}
  
/**
 * Defines the tradeState or payout on which to create a Transfer along with all necessary resets.
 */
export interface CalculateTransferInstruction {
  tradeState?: TradeState;
  payout?: ReferenceWithMeta<Payout>;
  resets?: Reset[];
  payerReceiver?: PayerReceiver;
  /**
   * Specifies quantity amount returned if not the full amount from the TradeState, e.g. partial return
   */
  quantity?: Quantity;
  date?: Date;
}
  
/**
 * Type for reporting details of calculated rates, including the observations that went into the final reported rate.
 */
export interface CalculatedRateDetails {
  /**
   * The observation dates and weights for each observation date.
   */
  observations?: CalculatedRateObservations;
  /**
   * The weighted value of each observation.
   */
  weightedRates?: number[];
  /**
   * The daily growth factors, showing the weighted rates divided by the day count basis plus one, giving how much the value grows for each step in the calculation.
   */
  growthFactor?: number[];
  /**
   * The compounding curve, showing how the initial value grew during the calculation period.
   */
  compoundedGrowth?: number[];
  /**
   * The total sum or product of all the individual terms that went into the calculated rate.
   */
  aggregateValue?: number;
  /**
   * The total weight of all the terms that went into the calculated rate.
   */
  aggregateWeight?: number;
  /**
   * The resulting calculated weight.
   */
  calculatedRate?: number;
}
  
/**
 * Type for reporting the observations dates and the corresponding weights going into a daily calculated rate
 */
export interface CalculatedRateObservationDatesAndWeights {
  /**
   * The observation date upon which the rate is observed.
   */
  observationDates?: Date[];
  /**
   * The corresponding weight for each date.
   */
  weights?: number[];
}
  
/**
 * Type for reporting observations that went into the final reported rate.
 */
export interface CalculatedRateObservations {
  /**
   * The observation date upon which the rate is observed.
   */
  observationDates?: Date[];
  /**
   * The corresponding weight for each date.
   */
  weights?: number[];
  /**
   * The value observed for that date
   */
  observedRates?: number[];
  /**
   * The value after any processing, such as application of caps or floors.
   */
  processedRates?: number[];
}
  
/**
 * A class defining the ISDA calculation agent responsible for performing duties as defined in the applicable product definitions.
 */
export interface CalculationAgent {
  /**
   * Specifies the party which is the ISDA Calculation Agent for the trade. If more than one party is referenced then the parties are assumed to be co-calculation agents, i.e. they have joint responsibility.
   */
  calculationAgentParty?: AncillaryRoleEnum;
  /**
   * Specifies the ISDA calculation agent responsible for performing duties as defined in the applicable product definitions. For example, the Calculation Agent may be defined as being the Non-exercising Party.
   */
  calculationAgentPartyEnum?: PartyDeterminationEnum;
  /**
   * The city in which the office through which ISDA Calculation Agent is acting for purposes of the transaction is located The short-form confirm for a trade that is executed under a Sovereign or Asia Pacific Master Confirmation Agreement ( MCA ), does not need to specify the Calculation Agent. However, the confirm does need to specify the Calculation Agent City. This is due to the fact that the MCA sets the value for Calculation Agent but does not set the value for Calculation Agent City.
   */
  calculationAgentBusinessCenter?: FieldWithMeta<BusinessCenterEnum>;
}
  
/**
 * Represents the parameters for describing how often something (such as collateral interest) is to be calculated.
 */
export interface CalculationFrequency {
  /**
   * Specifies the time period at which calculation is performed, e.g. 1 month.
   */
  period?: Period;
  /**
   * Specifies the month of the year if used.
   */
  monthOfYear?: number;
  /**
   * Specifies the day of the month if used.
   */
  dayOfMonth?: number;
  /**
   * Specifies the day of the week if used.
   */
  dayOfWeek?: DayOfWeekEnum;
  /**
   * Specifies the week of the month if used.
   */
  weekOfMonth?: number;
  /**
   * Specifies how many days from the trigger event should the payment occur.
   */
  offsetDays?: number;
  /**
   * Specifies where is the time measured.
   */
  dateLocation?: BusinessCenterTime;
  /**
   * Specifies the business center for adjustment of calculation period.
   */
  businessCenter?: BusinessCenterEnum[];
}
  
/**
 * A data defining:  the parameters used in the calculation of a fixed or floating rate calculation period amount. This data forms:  part of cashflows representation of a swap stream.
 */
export interface CalculationPeriod extends CalculationPeriodBase {
  /**
   * The calculation period start date, adjusted according to any relevant business day convention.
   */
  adjustedStartDate?: Date;
  /**
   * The calculation period end date, adjusted according to any relevant business day convention.
   */
  adjustedEndDate?: Date;
  meta?: MetaFields;
  /**
   * The calculation start date, unadjusted.
   */
  unadjustedStartDate?: Date;
  /**
   * The calculation end date, unadjusted.
   */
  unadjustedEndDate?: Date;
  /**
   * The number of days from the adjusted effective / start date to the adjusted termination / end date calculated in accordance with the applicable day count fraction.
   */
  calculationPeriodNumberOfDays?: number;
  /**
   * The amount that a cashflow will accrue interest on.
   */
  notionalAmount?: number;
  /**
   * The amount that a cashflow will accrue interest on. This is the calculated amount of the FX linked - i.e. the other currency notional amount multiplied by the appropriate FX spot rate.
   */
  fxLinkedNotionalAmount?: FxLinkedNotionalAmount;
  /**
   * The floating rate reset information for the calculation period.
   */
  floatingRateDefinition?: FloatingRateDefinition;
  /**
   * The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
   */
  fixedRate?: number;
  /**
   * The year fraction value of the calculation period, result of applying the ISDA rules for day count fraction defined in the ISDA Annex.
   */
  dayCountYearFraction?: number;
  /**
   * The amount representing the forecast of the accrued value of the calculation period. An intermediate value used to generate the forecastPaymentAmount in the PaymentCalculationPeriod.
   */
  forecastAmount?: Money;
  /**
   * A value representing the forecast rate used to calculate the forecast future value of the accrual period. This is a calculated rate determined based on averaging the rates in the rateObservation elements, and incorporates all of the rate treatment and averaging rules. A value of 1% should be represented as 0.01.
   */
  forecastRate?: number;
}
  
/**
 * The calculation period adjusted start and end dates, which are the baseline arguments needed to compute an interest accrual calculation.
 */
export interface CalculationPeriodBase {
  /**
   * The calculation period start date, adjusted according to any relevant business day convention.
   */
  adjustedStartDate?: Date;
  /**
   * The calculation period end date, adjusted according to any relevant business day convention.
   */
  adjustedEndDate?: Date;
  meta?: MetaFields;
}
  
export interface CalculationPeriodData {
  startDate?: Date;
  endDate?: Date;
  daysInPeriod?: number;
  daysInLeapYearPeriod?: number;
  isFirstPeriod?: boolean;
  isLastPeriod?: boolean;
}
  
/**
 * A data for:  defining the parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods. A calculation period schedule consists of an optional initial stub calculation period, one or more regular calculation periods and an optional final stub calculation period. In the absence of any initial or final stub calculation periods, the regular part of the calculation period schedule is assumed to be between the effective date and the termination date. No implicit stubs are allowed, i.e. stubs must be explicitly specified using an appropriate combination of firstPeriodStartDate, firstRegularPeriodStartDate and lastRegularPeriodEndDate.
 */
export interface CalculationPeriodDates {
  /**
   * The first day of the terms of the trade. This day may be subject to adjustment in accordance with a business day convention.
   */
  effectiveDate?: AdjustableOrRelativeDate;
  /**
   * The last day of the terms of the trade. This date may be subject to adjustments in accordance with the business day convention. It can also be specified in relation to another scheduled date (e.g. the last payment date).
   */
  terminationDate?: AdjustableOrRelativeDate;
  /**
   * The specification of the business day convention and financial business centers used for adjusting any calculation period date if it would otherwise fall on a day that is not a business day in the specified business center.
   */
  calculationPeriodDatesAdjustments?: BusinessDayAdjustments;
  /**
   * The start date of the calculation period. FpML specifies that for interest rate swaps this date must only be specified if it is not equal to the effective date. It is always specified in the case of equity swaps and credit default swaps with periodic payments. This date may be subject to adjustment in accordance with a business day convention.
   */
  firstPeriodStartDate?: AdjustableOrRelativeDate;
  /**
   * The start date of the regular part of the calculation period schedule. It must only be specified if there is an initial stub calculation period. This day may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
   */
  firstRegularPeriodStartDate?: Date;
  /**
   * The end date of the initial compounding period when compounding is applicable. It must only be specified when the compoundingMethod element is present and not equal to a value of None. This date may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
   */
  firstCompoundingPeriodEndDate?: Date;
  /**
   * The end date of the regular part of the calculation period schedule. It must only be specified if there is a final stub calculation period. This day may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
   */
  lastRegularPeriodEndDate?: Date;
  /**
   * Method to allocate any irregular period remaining after regular periods have been allocated between the effective and termination date.
   */
  stubPeriodType?: StubPeriodTypeEnum;
  /**
   * The frequency at which calculation period end dates occur with the regular part of the calculation period schedule and their roll date convention.
   */
  calculationPeriodFrequency?: CalculationPeriodFrequency;
  meta?: MetaFields;
}
  
/**
 * A class to specify the frequency at which calculation period end dates occur within the regular part of the calculation period schedule and their roll date convention.
 */
export interface CalculationPeriodFrequency extends Frequency {
  /**
   * A time period multiplier, e.g. 1, 2, or 3. If the period value is T (Term) then period multiplier must contain the value 1.
   */
  periodMultiplier?: number;
  /**
   * A time period, e.g. a day, week, month, year or term of the stream.
   */
  period?: PeriodExtendedEnum;
  meta?: MetaFields;
  /**
   * The roll convention specifies the period term as part of a periodic schedule, i.e. the calculation period end date within the regular part of the calculation period. The value could be a rule, e.g. IMM Settlement Dates, which is the 3rd Wednesday of the month, or it could be a specific day of the month, such as the first day of the applicable month. It is used in conjunction with a frequency and the regular period start date of a calculation period.
   */
  rollConvention?: RollConventionEnum;
  /**
   * Indicates, when true, that that the first Calculation Period should run from the Effective Date to the end of the calendar period in which the Effective Date falls, e.g. Jan 15 - Jan 31 if the calculation periods are one month long and Effective Date is Jan 15. If false, the first Calculation Period should run from the Effective Date for one whole period, e.g. Jan 15 to Feb 14 if the calculation periods are one month long and Effective Date is Jan 15. Mostly used in Commmodity Swaps.
   */
  balanceOfFirstPeriod?: boolean;
}
  
/**
 * A class that allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
 */
export interface CalculationSchedule {
  /**
   * Defines a period of a calculation schedule structure.
   */
  schedulePeriod?: SchedulePeriod[];
}
  
/**
 * Period and time profile over which the delivery takes place.
 */
export interface CalculationScheduleDeliveryPeriods extends AssetDeliveryPeriods {
  /**
   * Defines the delivery profile of the asset, including the load type and the delivery intervals.
   */
  profile?: AssetDeliveryProfile[];
  /**
   * Delivery start date
   */
  startDate?: Date;
  /**
   * Delivery end date
   */
  endDate?: Date;
  /**
   * The number of units included in the transaction for each delivery interval
   */
  deliveryCapacity?: Quantity;
  /**
   * Price per quantity per delivery time interval.
   */
  priceTimeIntervalQuantity?: Price;
}
  
/**
 * A type for defining a calendar spread feature.
 */
export interface CalendarSpread {
  expirationDateTwo?: AdjustableOrRelativeDate;
}
  
/**
 * A data defining:  the right of a party to cancel a swap transaction on the specified exercise dates. The provision is for 'walk-away' cancellation (i.e. the fair value of the swap is not paid). A fee payable on exercise can be specified. As a difference from the FpML construct, the canonical model extends the BuyerSeller class.
 */
export interface CancelableProvision extends BuyerSeller {
  /**
   * Buyer party that can be resolved as one of the two principal parties to the transaction. The party that buys this instrument, i.e. pays for this instrument and receives the rights defined by it. ISDA 2002 Equity Definitions section 1.18: `Buyer` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (b)(i) relating to a Swaption: 'Buyer' means the party that will, on each Premium Payment Date, pay to Seller the Premium | ISDA 2006 Definitions article 12.1 (b)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such in the related Confirmation, or the Exercising Party if neither party is specified | ISDA 2006 Definitions article 12.1 (b)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Buyer` means the Fixed Rate Payer.
   */
  buyer?: CounterpartyRoleEnum;
  /**
   * Seller party that can be resolved as one of the two principal parties to the transaction. The party that sells ('writes') this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. ISDA 2002 Equity Definitions section 1.19: `Seller` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (a)(i) relating to a Swaption: 'Seller' means the party the party specified as such or as writer in the related Confirmation | ISDA 2006 Definitions article 12.1 (a)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such or as writer in the related Confirmation or, if neither party is specified as such, the Non-exercising Party | ISDA 2006 Definitions article 12.1 (a)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Seller` means the Floating Rate Payer.
   */
  seller?: CounterpartyRoleEnum;
  /**
   * Definition of the party to whom notice of exercise should be given.
   */
  exerciseNotice?: ExerciseNotice;
  /**
   * A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller's agent.
   */
  followUpConfirmation?: boolean;
  /**
   * The adjusted dates associated with a cancelable provision. These dates have been adjusted for any applicable business day convention.
   */
  cancelableProvisionAdjustedDates?: CancelableProvisionAdjustedDates;
  /**
   * Business date convention adjustment to final payment period per leg (swapStream) upon exercise event. The adjustments can be made in-line with leg level BDC's or they can be specified separately.
   */
  finalCalculationPeriodDateAdjustment?: FinalCalculationPeriodDateAdjustment[];
  /**
   * An initial fee for the cancelable option.
   */
  initialFee?: Transfer;
  /**
   * The party with right to exercise a cancellation. Allows for buyer, seller or either.
   */
  callingParty?: CallingPartyEnum;
  /**
   * The first day when cancelation is permitted to take effect. A party may give notice prior to this date and taken together with the effective period would be necessary to cancel on this date.
   */
  earliestDate?: AdjustableOrRelativeDate;
  /**
   * The last day within the term of the contract that cancelation is allowed.
   */
  expirationDate?: AdjustableOrRelativeDate;
  /**
   * The effective date if cancelation is invoked otherwise the cancellation period defines the cancellation date.
   */
  effectiveDate?: AdjustableOrRelativeDates;
  /**
   * Effective period for cancelation when notice is given. This is the period after notice is given that cancellation becomes effecticve.
   */
  effectivePeriod?: Period;
  /**
   * The earliest time in a business day that notice of cancelation can be given.
   */
  earliestCancellationTime?: BusinessCenterTime;
  /**
   * The latest time at which notice of cancelation can be given.
   */
  latestCancelationTime?: BusinessCenterTime;
  /**
   * The exercise terms associated with the cancelable provision, including details such as exercise style, exercise fees, and any other relevant conditions or terms governing the cancellation of the swap transaction.
   */
  exerciseTerms?: ExerciseTerms;
}
  
/**
 * A data to:  define the adjusted dates for a cancelable provision on a swap transaction.
 */
export interface CancelableProvisionAdjustedDates {
  /**
   * The adjusted dates for an individual cancellation date.
   */
  cancellationEvent?: CancellationEvent[];
}
  
/**
 * The adjusted dates for a specific cancellation date, including the adjusted exercise date and adjusted termination date.
 */
export interface CancellationEvent {
  /**
   * The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
   */
  adjustedExerciseDate?: Date;
  /**
   * The early termination date that is applicable if an early termination provision is exercised. This date should already be adjusted for any applicable business day convention.
   */
  adjustedEarlyTerminationDate?: Date;
  meta?: MetaFields;
}
  
/**
 * An Asset that consists solely of a monetary holding in a currency. The currency of the Cash asset is held in the string Identifier (from AssetBase) and the AssetIdTypeEnum must be set to define that a CurrencyCode is set.  The function SetCashCurrency can be used to create (or update) a Cash object and the function GetCashCurrency can be used to retrieve the currency of a Cash object.
 */
export interface Cash extends AssetBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
}
  
/**
 * This type is a generic structure that can represent the parameters of several mid-market valuation and replacement value methods described in the 2021 ISDA Definitions.
 */
export interface CashCollateralValuationMethod {
  /**
   * This may be used to specify what type of CSA (credit support annex/agreement) is to be used for cash settlement purposes.
   */
  applicableCsa?: CsaTypeEnum;
  /**
   * This may be used to indicate the currency of cash collateral for cash settlement purposes.
   */
  cashCollateralCurrency?: string;
  /**
   * This may be used to indicate the interest rate to be used for cash collateral for cash settlement purposes.
   */
  cashCollateralInterestRate?: FieldWithMeta<String>;
  /**
   * This may be used to indicate the discount rate to be used for cash collateral for cash settlement purposes.
   */
  agreedDiscountRate?: FieldWithMeta<String>;
  /**
   * This may be used to specify which party is protected (e.g. under Replacement Value cash settlement methods).
   */
  protectedParty?: PartyDeterminationEnum[];
  /**
   * This may be used to indicate that 'prescribed documentation adjustment' is applicable.
   */
  prescribedDocumentationAdjustment?: boolean;
}
  
/**
 * Specifies the nature of a cash price either as a fee type, cash price type, or premium expression.
 */
export interface CashPrice {
  /**
   * Specifies the type of Cash Price.
   */
  cashPriceType?: CashPriceTypeEnum;
  /**
   * Specifies a premium when expressed in a way other than an amount, and any required forward starting price definition.
   */
  premiumExpression?: PremiumExpression;
  /**
   * Specifies the event type associated with a fee.
   */
  feeType?: FeeTypeEnum;
}
  
/**
 * Defines the terms required to compute and settle a cash settlement amount according to a fixing value, including the fixing source, fixing method and fixing date. In FpML, PhysicalSettlementTerms and CashSettlementTerms extend SettlementTerms. In the CDM, this extension paradigm has not been used because SettlementTerms class has been used for purposes related to securities transactions, while it is not used as such in the FpML standard (i.e. only as an abstract construct.
 */
export interface CashSettlementTerms {
  /**
   * Specifies the type of cash settlement method: cash price, yield curve etc.
   */
  cashSettlementMethod?: CashSettlementMethodEnum;
  /**
   * Specifies the parameters required to obtain a valuation, including the source, quotation method (bid, mid etc.) and any applicable quotation amount.
   */
  valuationMethod?: ValuationMethod;
  /**
   * Defines the different methods to specify a valuation date, as used for cash settlement. The Single / Multiple ValuationDate is used for the determination of recovery in a credit event, the RelativeDateOffset is used for cash-settled option, and FxFixingDate is used for cross-currency settlement.
   */
  valuationDate?: ValuationDate;
  /**
   * The time of the cash settlement valuation date when the cash settlement amount will be determined according to the cash settlement method, if the parties have not otherwise been able to agree the cash settlement amount. When using quations, this is the time of day in the specified business center when the calculation agent seeks quotations for an amount of the reference obligation for purposes of cash settlement. ISDA 2003 Term: Valuation Time.
   */
  valuationTime?: BusinessCenterTime;
  /**
   * The amount paid by the seller to the buyer for cash settlement on the cash settlement date. If not otherwise specified, would typically be calculated as 100 (or the Reference Price) minus the price of the Reference Obligation (all expressed as a percentage) times Floating Rate Payer Calculation Amount. ISDA 2003 Term: Cash Settlement Amount.
   */
  cashSettlementAmount?: Money;
  /**
   * Used for fixed recovery, specifies the recovery level, determined at contract formation, to be applied on a default. Used to calculate the amount paid by the seller to the buyer for cash settlement on the cash settlement date. Amount calculation is (1 minus the Recovery Factor) multiplied by the Floating Rate Payer Calculation Amount. The currency will be derived from the Floating Rate Payer Calculation Amount.
   */
  recoveryFactor?: number;
  /**
   * Used for Recovery Lock, to indicate whether fixed Settlement is Applicable or Not Applicable. If Buyer fails to deliver an effective Notice of Physical Settlement on or before the Buyer NOPS Cut-off Date, and if Seller fails to deliver an effective Seller NOPS on or before the Seller NOPS Cut-off Date, then either: (a) if Fixed Settlement is specified in the related Confirmation as not applicable, then the Seller NOPS Cut-off Date shall be the Termination Date; or (b) if Fixed Settlement is specified in the related Confirmation as applicable, then: (i) if the Fixed Settlement Amount is a positive number, Seller shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the Fixed Settlement Amount to Buyer on the Fixed Settlement Payment Date; and (ii) if the Fixed Settlement Amount is a negative number, Buyer shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the absolute value of the Fixed Settlement Amount to Seller on the Fixed Settlement Payment Date.
   */
  fixedSettlement?: boolean;
  /**
   * Indicates whether accrued interest is included (true) or not (false). For cash settlement this specifies whether quotations should be obtained inclusive or not of accrued interest. For physical settlement this specifies whether the buyer should deliver the obligation with an outstanding principal balance that includes or excludes accrued interest. ISDA 2003 Term: Include/Exclude Accrued Interest.
   */
  accruedInterest?: boolean;
  meta?: MetaFields;
}
  
/**
 * Class to specify a cashflow, i.e. the outcome of either of computation (e.g. interest accrual) or an assessment of some sort (e.g. a fee). The cashflow can then be turned into a cash transfer, artefact to be used as the input to a payment system or the outcome of it. The associated globalKey denotes the ability to associate a hash value to the Cashflow instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 */
export interface Cashflow extends AssetFlowBase {
  /**
   * Represents the amount of the asset to be transferred. The cashflow amount is always a positive number, as the cashflow direction is implied by the payer/receiver attribute.
   */
  quantity?: NonNegativeQuantity;
  /**
   * Represents the object that is subject to the transfer, it could be an asset or a reference.
   */
  asset?: Asset;
  /**
   * Represents the date on which the transfer to due.
   */
  settlementDate?: AdjustableOrAdjustedOrRelativeDate;
  /**
   * Specifies who pays / receives the cashflow, though a normalised Party1 / Party2 enumerator.
   */
  payerReceiver?: PayerReceiver;
  /**
   * The qualification of the type of cashflow, e.g. brokerage fee, premium, upfront fee etc. Particularly relevant when it cannot be inferred directly through lineage.
   */
  cashflowType?: CashflowType;
  /**
   * FpML specifies the FpML PaymentDiscounting.model group for representing the discounting elements that can be associated with a payment.
   */
  paymentDiscounting?: PaymentDiscounting;
}
  
/**
 * A data defining:  the cashflow representation of a swap trade.
 */
export interface CashflowRepresentation {
  /**
   * A true/false flag to indicate whether the cashflows match the parametric definition of the stream, i.e. whether the cashflows could be regenerated from the parameters without loss of information.
   */
  cashflowsMatchParameters?: boolean;
  /**
   * The adjusted payment date and associated calculation period parameters required to calculate the actual or projected payment amount. A list of payment calculation period elements may be ordered in the document by ascending adjusted payment date. An FpML document containing an unordered list of payment calculation periods is still regarded as a conformant document.
   */
  paymentCalculationPeriod?: PaymentCalculationPeriod[];
}
  
/**
 * Characterises the type of cashflow, which can result from either a scheduled or a non-scheduled lifecycle event.
 */
export interface CashflowType {
  /**
   * Type of cashflow corresponding to a scheduled event.
   */
  cashflowType?: ScheduledTransferEnum;
  /**
   * Type of cashflow corresponding to a non-scheduled event, where a price must be agreed between the parties.
   */
  cashPrice?: CashPrice;
  priceExpression?: PriceExpressionEnum;
}
  
/**
 * Result for the CheckEligibilityByDetails and CheckEligibilityForProduct functions
 */
export interface CheckEligibilityResult {
  /**
   * a simple boolean which is set to true if the asset described in the EligibilityQuery input is eligible
   */
  isEligible?: boolean;
  /**
   * if there was a match, this will be the one or more criteria that were supplied in the EligbilityCollateralSpecification which matched with the query input
   */
  matchingEligibleCriteria?: EligibleCollateralCriteria[];
  /**
   * a copy of the input query that was checked against the eligible collateral specification
   */
  eligibilityQuery?: EligibilityQuery;
  /**
   * a copy of the input EligbilityCollateralSpecification that was checked against the query
   */
  specification?: EligibleCollateralSpecification;
}
  
/**
 * A type for documenting additional clause that cannot yet be represented with the model and yet needed for a digital representation of the agreement
 */
export interface Clause {
  /**
   * The  name or identifier associated to this clause 
   */
  identifier?: string;
  /**
   * Content of this bespoke clause
   */
  terms?: string;
  /**
   * Additional hierarchichal components of the clause if relevant
   */
  subcomponents?: Clause[];
}
  
/**
 * All information required to perform the clear life cycle event; the clearing party (CCP), the two parties facing each other on the alpha contract, and optionally the parties acting as clearing members.
 */
export interface ClearingInstruction {
  /**
   * The contract that will be submitted to the clearing house for clearing. The contract should indicate that it should be cleared by assigning a clearing organisation as a party role.
   */
  alphaContract?: TradeState;
  /**
   * The Central Counter party (CCP) that the contract will be submitted to for clearing.
   */
  clearingParty?: Party;
  /**
   * First party facing the CCP if it is clearing for its own account.
   */
  party1?: Party;
  /**
   * Second party facing the CCP if it is clearing for its own account.
   */
  party2?: Party;
  /**
   * Optional party facing the CCP, acting as clearing member for party1.
   */
  clearerParty1?: Party;
  /**
   * Optional party facing the CCP, acting as clearing member for party2.
   */
  clearerParty2?: Party;
  /**
   * Open Offer
   */
  isOpenOffer?: boolean;
}
  
/**
 *  A class to qualify the closed state of an execution or a contract through the combination or a state (e.g. terminated, novated) and a set of dates: activity date, effective date and, when relevant, last payment date.
 */
export interface ClosedState {
  /**
   * The qualification of what gave way to the contract or execution closure, e.g. allocation, termination, ...
   */
  state?: ClosedStateEnum;
  /**
   * The activity date on which the closing state took place, i.e. either the event date of the closing event (e.g. option exercise, contract early termination) or the contractual termination date.
   */
  activityDate?: Date;
  /**
   * The date on which the closing event contractually takes effect, when different from the activity date. When an explicit event effective date attribute is associated with the closing event, it will be that date. In the case of a cancellation event, it will be the date on which the cancelled event took place.
   */
  effectiveDate?: Date;
  /**
   * The date associated with the last payment in relation to the artefact (e.g. contract) to which this closed state applies. As an example, in the case of an early termination event, it would be the settlement date of the associated fee, if applicable.
   */
  lastPaymentDate?: Date;
}
  
/**
 * A type for defining the obligations of the counterparty subject to credit support requirements.
 */
export interface Collateral {
  /**
   * Independent Amount is an amount that usually less creditworthy counterparties are asked to provide. It can either be a fixed amount or a percentage of the Transaction's value. The Independent Amount can be: (i) transferred before any trading between the parties occurs (as a deposit at a third party's account or with the counterparty) or (ii) callable after trading has occurred (typically because a downgrade has occurred). In situation (i), the Independent Amount is not included in the calculation of Exposure, but in situation (ii), it is included in the calculation of Exposure. Thus, for situation (ii), the Independent Amount may be transferred along with any collateral call. Independent Amount is a defined term in the ISDA Credit Support Annex. ('with respect to a party, the amount specified as such for that party in Paragraph 13; if no amount is specified, zero').
   */
  independentAmount?: IndependentAmount;
  /**
   * A list of identifiers pointing to the collateral portfolios which contain the collateral which covers a trade.
   */
  portfolioIdentifier?: Identifier[];
  /**
   * The collateral portfolios which contain the collateral which covers a trade. (NB: this can be provided by reference to a global key for each CollateralPortfolio object)
   */
  collateralPortfolio?: ReferenceWithMeta<CollateralPortfolio>[];
  /**
   * specifies the collateral provisions of the product.
   */
  collateralProvisions?: CollateralProvisions;
  meta?: MetaFields;
}
  
/**
 * Represents the parameters needed to calculate the floating rate paid on collateral holdings.
 */
export interface CollateralAgreementFloatingRate extends FloatingRateBase {
  rateOption?: ReferenceWithMeta<InterestRateIndex>;
  /**
   * The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
   */
  spreadSchedule?: SpreadSchedule;
  /**
   * The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
   */
  capRateSchedule?: StrikeSchedule;
  /**
   * The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
   */
  floorRateSchedule?: StrikeSchedule;
  meta?: MetaFields;
  /**
   * Specifies how negative rates should be applied.  If rates go negative, should the payment be reversed (true) or zeroed out (false)?
   */
  negativeInterest?: boolean;
  /**
   * Specifies how spreads should be applied in a low/negative rate environment.  If true, spread is applied only if rate is positive.
   */
  compressibleSpread?: boolean;
}
  
/**
 * Represents common attributes to define a collateral balance recorded by the principal as held or posted.
 */
export interface CollateralBalance {
  /**
   * Defines the collateral balance breakdown of settlement status.
   */
  collateralBalanceStatus?: CollateralStatusEnum;
  /**
   * Indicates if the collateral balance amount is based on pre or post haircut, if a haircut is associated with the collateral asset
   */
  haircutIndicator?: HaircutIndicatorEnum;
  /**
   * Specifies the collateral balance amount in base currency determined within a collateral legal agreement, or defined for reporting purposes.
   */
  amountBaseCurrency?: Money;
  /**
   * Specifies each of the parties in the collateral balance and its perspective with regards to the direction of the collateral balance, posted or received.
   */
  payerReceiver?: PartyReferencePayerReceiver;
}
  
/**
 * The possible different terms that can be combined, using AND, OR and NOT logic, to define the issuers and/or assets that meet a given criteria for collateral.
 */
export interface CollateralCriteria {
  /**
   * Enables two or more Collateral Criteria to be combined using AND logic.
   */
  allCriteria?: AllCriteria;
  /**
   * Enables two or more Collateral Criteria to be combined using OR logic.
   */
  anyCriteria?: AnyCriteria;
  /**
   * Enables a single Collateral Criteria to be excluded using NOT logic.
   */
  negativeCriteria?: NegativeCriteria;
  /**
   * Criteria is the type of entity issuing the asset.
   */
  collateralIssuerType?: CollateralIssuerType;
  /**
   * Criteria is the asset type of the collateral.
   */
  assetType?: AssetType;
  /**
   * Criteria is the issuing entity country of origin.
   */
  issuerCountryOfOrigin?: IssuerCountryOfOrigin;
  /**
   * Criteria is the collateral asset country of origin.
   */
  assetCountryOfOrigin?: AssetCountryOfOrigin;
  /**
   * Criteria is the denominated currency of the collateral.
   */
  currencyCodeEnum?: CurrencyCodeEnum;
  /**
   * Criteria is a specific named issuer entity.
   */
  issuerName?: IssuerName;
  /**
   * Criteria is the agency rating(s) of the issuer.
   */
  issuerAgencyRating?: IssuerAgencyRating;
  /**
   * Criteria is the agency rating(s) of the country of the issuer.
   */
  sovereignAgencyRating?: SovereignAgencyRating;
  /**
   * Criteria is the agency rating(s) of the collateral asset.
   */
  assetAgencyRating?: AssetAgencyRating;
  /**
   * Criteria is the maturity characteristics of the collateral asset.
   */
  assetMaturity?: AssetMaturity;
  /**
   * Criteria is a specifically identified asset
   */
  specificAsset?: SpecificAsset;
  /**
   * Criteria is the taxonomy characteristics of an collateral.
   */
  collateralTaxonomy?: CollateralTaxonomy;
  /**
   * Criteria is that the collateral is listed on a specific exchange.
   */
  listingExchange?: ListingExchange;
  /**
   * Criteria is the industry sector of the collateral asset.
   */
  listingSector?: ListingSector;
  /**
   * Criteria is that the collateral is a constituent of a specific index.
   */
  index?: Index;
  /**
   * Criteria includes collateral issued by the counterparty.
   */
  counterpartyOwnIssuePermitted?: CounterpartyOwnIssuePermitted;
  /**
   * Criteria is that collateral must be denominated in the domestic currency of the issuer.
   */
  domesticCurrencyIssued?: DomesticCurrencyIssued;
}
  
/**
 * Represents a set of criteria used to specify and describe collateral.
 */
export interface CollateralCriteriaBase {
  /**
   * The specific criteria that applies. It can be created using AND, OR and NOT logic, and both asset and issuer characteristics.
   */
  collateralCriteria?: CollateralCriteria;
  /**
   * Specifies which of the two counterparties the criteria applies to (either one or both counterparties). This attribute is optional, in case the applicable party is already specified elsewhere within a party election.
   */
  appliesTo?: CounterpartyRoleEnum[];
  /**
   * Restrict the criteria to only apply to a specific type of margin, ie IM or VM.
   */
  restrictTo?: CollateralMarginTypeEnum;
  /**
   * Denotes which Criteria has priority if more than one agency rating applies.
   */
  ratingPriorityResolution?: RatingPriorityResolutionEnum;
}
  
/**
 * Represents parameters for calculating the amount the floating interest calculation, e.g.  for a single currency or defaults for all currencies.
 */
export interface CollateralInterestCalculationParameters {
  /**
   * Specifies the applicable fixed rate  if used.
   */
  fixedRate?: number;
  /**
   * Specifies the floating interest rate to be used.
   */
  floatingRate?: CollateralAgreementFloatingRate;
  /**
   * If True, specifies that the interest transfers should be converted to base currency equivalent, or if False specifies that the transfer should be in the currency of the collateral.
   */
  inBaseCurrency?: boolean;
  /**
   * Specifies the type of compounding to be applied (None, Business, Calendar).
   */
  compoundingType?: CompoundingTypeEnum;
  /**
   * Specifies the applicable business centers for compounding.
   */
  compoundingBusinessCenter?: BusinessCenterEnum[];
  /**
   * Specifies the day count fraction to use for that currency.
   */
  dayCountFraction?: DayCountFractionEnum;
  /**
   * Specifies the rounding rules for settling in that currency.
   */
  rounding?: Rounding;
  /**
   * Specifies when/how often is rounding applied?
   */
  roundingFrequency?: RoundingFrequencyEnum;
  /**
   * Specifies the withholding tax rate if a withholding tax is applicable.
   */
  withholdingTaxRate?: number;
}
  
/**
 * Represents parameters that describe how calculated interest amounts are handled, i.e. are they transferred/distributed, or is the collateral balance adjusted, is netting done, and any other special handling.
 */
export interface CollateralInterestHandlingParameters {
  /**
   * Specifies how the collateral interest is to be handled.
   */
  interestPaymentHandling?: CollateralInterestHandlingEnum;
  /**
   * Specifies applicable business centers for payments.
   */
  paymentBusinessCenter?: BusinessCenterEnum[];
  /**
   * Indicates whether to net Held and Posted Interest Payments (i.e. whether interest payable for a period can be netted with interest receivable).
   */
  netPostedAndHeldInterest?: boolean;
  /**
   * Indicates whether the interest amount may be offset against any margin call deliver or return amounts?   (aka 'net payments' indicator).
   */
  netInterestWithMarginCalls?: boolean;
  /**
   * Indicates whether or not to include the open interest accrual in the margin calculation.
   */
  includeAccrualInMarginCalc?: boolean;
  /**
   * Indicates whether interest accruing on unsettled interest amount is included (continues to be accrued) in the following period.
   */
  accrueInterestOnUnsettledInterest?: boolean;
  /**
   * Indicates the option that accrued interest should be calculated and distributed when a full return of collateral occurs.
   */
  onFullReturn?: boolean;
  /**
   * Indicates the option that accrued interest should be calculated and distributed when a partial return collateral occurs.
   */
  onPartialReturn?: boolean;
  /**
   * The application of Interest Amount with respect to the Delivery Amount and the Return Amount.
   */
  interestAmountApplication?: InterestAmountApplication;
  /**
   * Specifies the level below which the interest will be rolled over.
   */
  interestRolloverLimit?: NumberBound;
  /**
   * Specifies the level below which the interest will be written off; if omitted write-off is not applicable.
   */
  writeoffLimit?: NumberBound;
  /**
   * Specifies the alternative to interest amounts.
   */
  alternativeToInterestAmount?: AlternativeToInterestAmountEnum;
  /**
   * Specifies an alternative to interest amount, when the alternative provision clause is specified.
   */
  alternativeProvision?: string;
  /**
   * Specifies the time of day that interest needs to be confirmed by.
   */
  cutoffTime?: string;
  /**
   * Specifies the terms describing notification requirements.
   */
  notification?: CollateralInterestNotification;
}
  
/**
 * Represents the parameters describing when notifications should be made for required collateral interest transfers.
 */
export interface CollateralInterestNotification {
  /**
   * Specifies what triggers notification (should be enum) Interest Statement Frequency, Period End Date.
   */
  trigger?: string;
  /**
   * Specifies the number of days before (negative) or after (positive) the trigger event.
   */
  offset?: number;
  /**
   * Specifies the time of day that the notification should occur.
   */
  notificationTime?: string;
  /**
   * The type of days on which notification should occur.
   */
  notificationDayType?: DayTypeEnum;
}
  
/**
 * Represents the floating interest calculation and distribution parameters for a single currency.
 */
export interface CollateralInterestParameters {
  /**
   * Represents the party to which these parameters apply (the applicable party).  In other words, if the parameters are different depending on which party is posting/holding the collateral, for which party to the Collateral Agreement (Party 1 or Party 2) that is posting the collateral do these parameters apply?
   */
  postingParty?: CounterpartyRoleEnum;
  /**
   * Specifies the type of margin for which interest is being calculated, if the parameters are different depending on type of margin (initial or variation).
   */
  marginType?: CollateralMarginTypeEnum;
  /**
   * Specifies the currency for which the parameters are captured.
   */
  currency?: string;
  /**
   * Represents the basic interest calculation parameters.
   */
  interestCalculationParameters?: CollateralInterestCalculationParameters;
  /**
   * Represents how often and when interest is calculated.
   */
  interestCalculationFrequency?: CalculationFrequency;
  /**
   * Represents the parameters describing how and when interest transfer occurs.
   */
  interestHandlingParameters?: CollateralInterestHandlingParameters;
}
  
/**
 * Represents a class to allow specification of the type of entity issuing the collateral.
 */
export interface CollateralIssuerType {
  /**
   * Specifies the origin of entity issuing the collateral.
   */
  issuerType?: IssuerTypeEnum;
  /**
   * Specifies debt issued by international organisations and multilateral banks.
   */
  supraNationalType?: SupraNationalIssuerTypeEnum;
  /**
   * Specifies debt issues by institutions or bodies, typically constituted by statute, with a function mandated by the government and subject to government supervision inclusive of profit- and non-profit making bodies. Includes the US Agencies and GSEs and the EU concept of public sector entities. Excluding any entities which are also Regional Government.
   */
  quasiGovernmentType?: QuasiGovernmentIssuerType;
  /**
   * Specifies Regional government, local authority or municipal.
   */
  regionalGovernmentType?: RegionalGovernmentIssuerType;
  /**
   * Specifies a subsidiary company that is formed to undertake a specific business purpose of acquisition and financing of specific assets on a potentially limited recourse basis dependent of how it is designed. E.g. asset backed securities, including securitisations.
   */
  specialPurposeVehicleType?: SpecialPurposeVehicleIssuerType;
}
  
/**
 * Represents common attributes to define the details of collateral assets, to be used in margin call messaging and contribute to collateral balances e.g securities in a collateral account.
 */
export interface CollateralPortfolio {
  /**
   * Specifies a unique identifier for a set of collateral positions in a portfolio.
   */
  portfolioIdentifier?: Identifier;
  /**
   * Specifies the individual components of the collateral positions in the collateral portfolio.
   */
  collateralPosition?: CollateralPosition[];
  /**
   * Represents the populated or calculated collateral aggregate balance amount for the collateral portfolio.
   */
  collateralBalance?: CollateralBalance[];
  /**
   *  The specification of a legal agreement between two parties governing the collateral relationship such as Credit Support Agreement or Collateral Transfer Agreement etc. (NB: this can be provided by reference to a global key for each LegalAgreement object).
   */
  legalAgreement?: ReferenceWithMeta<LegalAgreement>;
  meta?: MetaFields;
}
  
/**
 * Specifies the individual components of collateral positions.
 */
export interface CollateralPosition extends Position {
  /**
   * Position with many price quantities.
   */
  priceQuantity?: PriceQuantity[];
  /**
   * The product underlying the position.
   */
  product?: Product;
  /**
   * The aggregate cost of proceeds
   */
  cashBalance?: Money;
  /**
   * Reference to the Contract, in case product is contractual and the contract has been formed
   */
  tradeReference?: ReferenceWithMeta<TradeState>;
  /**
   * Specifies if there is any treatment to be applied to collateral, such as percentage discount which will impact collateral value.
   */
  treatment?: CollateralTreatment;
  /**
   * Indicates the collateral positions settlement status.
   */
  collateralPositionStatus?: CollateralStatusEnum;
}
  
/**
 * Contains collateral attributes which can also inherit information from a GMRA
 */
export interface CollateralProvisions {
  /**
   * Enumerates the collateral types which are accepted by the Seller.
   */
  collateralType?: CollateralTypeEnum;
  /**
   * The eligible collateral as specified in relation to the transaction.
   */
  eligibleCollateral?: EligibleCollateralCriteria[];
  /**
   * The provisions for collateral substitutions such as how many and when they are allowed.
   */
  substitutionProvisions?: SubstitutionProvisions;
}
  
/**
 * Specifies the collateral taxonomy, which is composed of a taxonomy value and a taxonomy source.
 */
export interface CollateralTaxonomy {
  /**
   * Specifies the taxonomy value.
   */
  taxonomyValue?: CollateralTaxonomyValue;
  /**
   * Specifies the taxonomy source.
   */
  taxonomySource?: TaxonomySourceEnum;
}
  
/**
 * Specifies the collateral taxonomy value, either as a specified enumeration or as a string.
 */
export interface CollateralTaxonomyValue {
  /**
   * Identifies European Union Eligible Collateral Assets classification categories based on EMIR Uncleared Margin Rules. Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM
   */
  eu_EMIR_EligibleCollateral?: EU_EMIR_EligibleCollateralEnum[];
  /**
   * Identifies United Kingdom Eligible Collateral Assets classification categories based on UK Onshored EMIR Uncleared Margin Rules Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: UK EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.
   */
  uk_EMIR_EligibleCollateral?: UK_EMIR_EligibleCollateralEnum[];
  /**
   * Identifies US Eligible Collateral Assets classification categories based on Uncleared Margin Rules published by the CFTC and the US Prudential Regulator. Note: While the same basic categories exist in the CFTC and US Prudential Regulators’ margin rules, the precise definitions or application of those rules could differ between the two rules.
   */
  us_CFTC_PR_EligibleCollateral?: US_CFTC_PR_EligibleCollateralEnum[];
  /**
   * Identifies the taxonomy value when not specified as an enumeration.
   */
  nonEnumeratedTaxonomyValue?: FieldWithMeta<String>[];
}
  
/**
 * The set of elections which specify a Collateral Transfer Agreement
 */
export interface CollateralTransferAgreementElections {
}
  
/**
 * Specifies the treatment terms for the eligible collateral criteria specified.
 */
export interface CollateralTreatment {
  /**
   * Specification of the valuation treatment for the specified collateral.
   */
  valuationTreatment?: CollateralValuationTreatment;
  /**
   * Specification of concentration limits applicable to the collateral criteria.
   */
  concentrationLimit?: ConcentrationLimit[];
  /**
   * A boolean attribute to specify whether collateral critieria are inclusion (True) or exclusion (False) criteria.
   */
  isIncluded?: boolean;
}
  
/**
 * Specification of the valuation treatment for the specified collateral.
 */
export interface CollateralValuationTreatment {
  /**
   * Specifies a haircut percentage to be applied to the value of asset and used as a discount factor to the value of the collateral asset,expressed as a percentage in decimal terms. As an example a 0.5% haircut would be represented as a decimal number 0.005.
   */
  haircutPercentage?: number;
  /**
   * Specifies a percentage value of transaction needing to be posted as collateral expressed as a valuation. As an example a 104% requirement would be represented as a decimal number 1.04.
   */
  marginPercentage?: number;
  /**
   * Specifies an FX haircut applied to a specific asset which is agreed between the parties (for example, if pledgor eligible collateral is not denominated in the termination currency or under other specified cases in collateral support documents both for initial margin and variation margin).The percentage value is expressed as the discount haircut to the value of the collateral- as an example an 8% FX haircut would be expressed as 0.08.
   */
  fxHaircutPercentage?: number;
  /**
   * Specifies a percentage value of any additional haircut to be applied to a collateral asset,the percentage value is expressed as the discount haircut to the value of the collateral- as an example a 5% haircut would be expressed as 0.05. 
   */
  additionalHaircutPercentage?: number;
}
  
/**
 * Identifies a specific commodity by referencing a product identifier or by a product definition.
 */
export interface Commodity extends AssetBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
  /**
   * Specifies the commodity underlier in the event that no ISDA Commodity Reference Benchmark exists.
   */
  commodityProductDefinition?: CommodityProductDefinition;
  /**
   * Describes the required quote type of the underlying price that will be observed. Example values include 'Bid, 'Ask', 'Settlement' (for a futures contract) and 'WeightedAverage' (for some published prices and indices).
   */
  priceQuoteType?: QuotationSideEnum;
  /**
   * Specifies the parameters for identifying the relevant contract date when the commodity reference price is a futures contract.
   */
  deliveryDateReference?: DeliveryDateParameters;
  /**
   * Provides additional information about the commodity underlier.
   */
  description?: string;
}
  
/**
 * Payout based on the averaged price of a referenced underlier. (e.g. Commodities). Can represent both average (average of many) & bullet (average of 1) pricing
 */
export interface CommodityPayout extends PayoutBase {
  /**
   * Canonical representation of the payer and receiver parties applicable to each payout leg.
   */
  payerReceiver?: PayerReceiver;
  /**
   * Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
   */
  priceQuantity?: ResolvablePriceQuantity;
  /**
   * The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
   */
  principalPayment?: PrincipalPayments;
  /**
   * Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
   */
  settlementTerms?: SettlementTerms;
  /**
   * Indicates if the averaging calculation, when applicable, is weighted or unweighted.
   */
  averagingFeature?: AveragingCalculation;
  /**
   * Defines parameters in which the commodity price is assessed.
   */
  commodityPriceReturnTerms?: CommodityPriceReturnTerms;
  /**
   * Specifies specific dates or parametric rules for the dates on which the price will be determined.
   */
  pricingDates?: PricingDates;
  /**
   * Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
   */
  schedule?: CalculationSchedule;
  /**
   * Defines the calculation period dates schedule.
   */
  calculationPeriodDates?: CalculationPeriodDates;
  /**
   * Defines the payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the valuation dates).
   */
  paymentDates?: PaymentDates;
  /**
   * Identifies the underlying product that is referenced for pricing of the applicable leg in a swap. Referenced in the '2018 ISDA CDM Equity Confirmation for Security Equity Swap' as Security.
   */
  underlier?: Underlier;
  /**
   * Defines quanto or composite FX features that are included in the swap leg.
   */
  fxFeature?: FxFeature;
  /**
   * Contains the information relative to the delivery of the asset.
   */
  delivery?: AssetDeliveryInformation;
}
  
/**
 * Defines parameters in which the commodity price is assessed.
 */
export interface CommodityPriceReturnTerms {
  /**
   * Defines rounding rules and precision to be used in the rounding of a number.
   */
  rounding?: Rounding;
  /**
   * Defines a spread value for one or more defined dates.
   */
  spread?: SpreadSchedule;
  /**
   * Used in conjunction with an exchange-based pricing source. Identifies a way in which the futures contracts referenced will roll between periods. 
   */
  rollFeature?: RollFeature;
  /**
   * Defines the conversion applied if the quantity unit on contract is different from unit on referenced underlier.
   */
  conversionFactor?: number;
}
  
/**
 * Specifies the commodity underlier in the event that no ISDA Commodity Reference Price exists.
 */
export interface CommodityProductDefinition {
  /**
   * Specifies the type of commodity.
   */
  referenceFramework?: CommodityReferenceFramework;
  /**
   * Specifies a publication that provides the commodity price, including, where applicable the details of where in the publication the price is published.  Applicable when the commodity reference price is not a futures contract
   */
  priceSource?: PriceSource;
  /**
   * Specifies the publication where the commodity prices can be found.
   */
  commodityInfoPublisher?: CommodityInformationPublisherEnum;
  /**
   *  Identifies the exchange from which the reference price should be sourced, using the scheme at the following url: http://www.fpml.org/coding-scheme/external/exchange-id-MIC-1-0
   */
  exchangeId?: FieldWithMeta<String>;
}
  
/**
 * Specifies the type of commodity.
 */
export interface CommodityReferenceFramework {
  /**
   * Identifies the commodity more specifically. Where possible, this should follow the naming convention used in the 2005 ISDA Commodity Definitions SubAnnex A, including the subCommodity and additional qualifiers, but should be limited to 256 characters or less.
   */
  commodityName?: string;
  /**
   * Provides an enumerated value for a capacity unit, generally used in the context of defining quantities for commodities.
   */
  capacityUnit?: CapacityUnitEnum;
  /**
   * Provides an enumerated values for a weather unit, generally used in the context of defining quantities for commodities.
   */
  weatherUnit?: WeatherUnitEnum;
  /**
   * Defines the currency in which the commodity is priced.
   */
  currency?: FieldWithMeta<String>;
}
  
/**
 * Specifies the conditions to be applied for converting into a reference currency when the actual currency rate is not determined upfront.
 */
export interface Composite {
  /**
   * Specifies the method according to which an amount or a date is determined.
   */
  determinationMethod?: DeterminationMethodEnum;
  /**
   * A date specified as some offset to another date (the anchor date).
   */
  relativeDate?: RelativeDateOffset;
  /**
   * Specifies the methodology (reference source and, optionally, fixing time) to be used for determining a currency conversion rate.
   */
  fxSpotRateSource?: FxSpotRateSource;
  /**
   * The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
   */
  fixingTime?: BusinessCenterTime;
}
  
/**
 * A class to specify the outcome of a computed amount, for testing purposes.
 */
export interface ComputedAmount {
  callFunction?: string;
  amount?: number;
  /**
   * The currency in which the computed amount is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
   */
  currency?: FieldWithMeta<String>;
}
  
/**
 * Represents a class to describe concentration limits that may be applicable to eligible collateral criteria.
 */
export interface ConcentrationLimit {
  /**
   * Specifies a set of criteria to describe the assets that the concentration limits apply to.
   */
  concentrationLimitCriteria?: ConcentrationLimitCriteria;
  /**
   * Specifies the value of collateral limit represented as a range.
   */
  valueLimit?: MoneyRange;
  /**
   * Specifies the perecentage of collateral limit represented as a decimal number - example 25% is 0.25.
   */
  percentageLimit?: NumberRange;
}
  
/**
 * Respresents a class to describe a set of criteria to describe specific assets that the concentration limits apply to.
 */
export interface ConcentrationLimitCriteria extends CollateralCriteriaBase {
  /**
   * The specific criteria that applies. It can be created using AND, OR and NOT logic, and both asset and issuer characteristics.
   */
  collateralCriteria?: CollateralCriteria;
  /**
   * Specifies which of the two counterparties the criteria applies to (either one or both counterparties). This attribute is optional, in case the applicable party is already specified elsewhere within a party election.
   */
  appliesTo?: CounterpartyRoleEnum[];
  /**
   * Restrict the criteria to only apply to a specific type of margin, ie IM or VM.
   */
  restrictTo?: CollateralMarginTypeEnum;
  /**
   * Denotes which Criteria has priority if more than one agency rating applies.
   */
  ratingPriorityResolution?: RatingPriorityResolutionEnum;
  /**
   * Specifies the type of concentration limit to be applied.
   */
  concentrationLimitType?: ConcentrationLimitTypeEnum;
  /**
   * Specifies an average trading volume on an exchange in relation to Equity products.
   */
  averageTradingVolume?: AverageTradingVolume;
}
  
/**
 * A class describing the weight of each of the underlier constituent within the basket, either in absolute or relative terms.
 */
export interface ConstituentWeight {
  /**
   * The number of units (index or securities) that constitute the underlier of the swap. In the case of a basket swap, this element is used to reference both the number of basket units, and the number of each asset components of the basket when these are expressed in absolute terms.
   */
  openUnits?: number;
  /**
   * The relative weight of each respective basket constituent, expressed in percentage. A basket percentage of 5% would be represented as 0.05.
   */
  basketPercentage?: number;
}
  
/**
 * A class to specify the parties' election to specify contact information, in relation to elections such as the Addresses for Transfer or the Demand and Notices as specified in the ISDA Credit Support Annex agreement.
 */
export interface ContactElection {
  /**
   * The parties' contact information election.
   */
  partyElection?: PartyContactInformation[];
}
  
/**
 * A class to specify contact information associated with a party: telephone, postal/street address, email and web page.
 */
export interface ContactInformation {
  /**
   * The telephone number.
   */
  telephone?: TelephoneNumber[];
  /**
   * The street/postal address.
   */
  address?: Address[];
  /**
   * The email address.
   */
  email?: string[];
  /**
   * The web page. This attribute is not specified as part of the FpML ContactInformation complex type.
   */
  webPage?: string[];
}
  
/**
 * Encapsulates data features common to trade and position.
 */
export interface ContractBase {
  /**
   * Represents information specific to trades or positions involving contractual products.
   */
  contractDetails?: ReferenceWithMeta<ContractDetails>;
  /**
   * Defines specific attributes that relate to trade or position executions.
   */
  executionDetails?: ReferenceWithMeta<ExecutionDetails>;
  /**
   * Represents the collateral obligations of a party.
   */
  collateral?: ReferenceWithMeta<Collateral>;
}
  
/**
 * Defines specific attributes that relate to contractual details of trades.
 */
export interface ContractDetails {
  /**
   * Represents the legal document(s) that governs a trade and associated contractual product terms, either as a reference to such documents when specified as part of the CDM, or through identification of some of the key terms of those documents, such as the type of document, the document identifier, the publisher, the document vintage and the agreement date.
   */
  documentation?: LegalAgreement[];
  /**
   * Represents the law governing the trade and associated contractual product terms.
   */
  governingLaw?: FieldWithMeta<GoverningLawEnum>;
  meta?: MetaFields;
}
  
/**
 * Specifies instructions to create a fully formed contract, with optional legal agreements.
 */
export interface ContractFormationInstruction {
  /**
   * Optional legal agreements associated to the contract being formed, for instance a master agreement.
   */
  legalAgreement?: LegalAgreement[];
}
  
export interface ContractualMatrix {
  /**
   * Identifies the form of applicable matrix.
   */
  matrixType?: FieldWithMeta<MatrixTypeEnum>;
  /**
   * Defines any applicable key into the relevant matrix. For example, the Transaction Type would be the single term required for the Credit Derivatives Physical Settlement Matrix. This element should be omitted in the case of the 2000 ISDA Definitions Settlement Matrix for Early Termination and Swaptions.
   */
  matrixTerm?: FieldWithMeta<MatrixTermEnum>;
}
  
/**
 * A contractual supplement (such as those published by ISDA) and its publication date that will apply to the trade.
 */
export interface ContractualTermsSupplement {
  /**
   * Identifies the form of applicable contractual supplement.
   */
  contractualTermsSupplementType?: FieldWithMeta<ContractualSupplementTypeEnum>;
  /**
   * Specifies the publication date of the applicable version of the contractual supplement.
   */
  publicationDate?: Date;
}
  
/**
 * Specifies the relevant data regarding a corporate action.
 */
export interface CorporateAction {
  /**
   * The type of corporate action taking place.
   */
  corporateActionType?: CorporateActionTypeEnum;
  /**
   * The date on which the corporate action is known to have taken place.
   */
  exDate?: Date;
  /**
   * The date on which resulting from the corporate action are delivered.
   */
  payDate?: Date;
  /**
   * The underlier impacted by the corporate action.
   */
  underlier?: Underlier;
}
  
export interface CorrelationReturnTerms extends ReturnTermsBase {
  /**
   * Contains all non-date valuation information.
   */
  valuationTerms?: ValuationTerms;
  /**
   * This specifies the numerator of an annualization factor. Frequently this number is equal to the number of observations of prices in a year e.g. 252.
   */
  annualizationFactor?: number;
  /**
   * The parameters which define whether dividends are applicable
   */
  dividendApplicability?: DividendApplicability;
  /**
   * Contains Equity Underlyer provisions regarding jurisdiction and fallbacks.
   */
  equityUnderlierProvisions?: EquityUnderlierProvisions;
  /**
   * Indicates whether the price of shares is adjusted for dividends or not.
   */
  sharePriceDividendAdjustment?: boolean;
  /**
   * Expected number of trading days.
   */
  expectedN?: number;
  /**
   * Contract will strike off this initial level. Providing just the initialLevel without initialLevelSource, infers that this is AgreedInitialPrice - a specified Initial Index Level.
   */
  initialLevel?: number;
  /**
   * In this context, this is AgreedInitialPrice - a specified Initial Index Level.
   */
  initialLevelSource?: DeterminationMethodEnum;
  /**
   * Specifies whether Mean Adjustment is applicable or not in the calculation of the Realized Volatility, Variance or Correlation
   */
  meanAdjustment?: boolean;
  /**
   * Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.
   */
  performance?: string;
  /**
   * Correlation Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.
   */
  correlationStrikePrice?: Price;
  /**
   * Describes correlation bounds, which form a cap and a floor on the realized correlation.
   */
  boundedCorrelation?: NumberRange;
  /**
   * Number of data series, normal market practice is that correlation data sets are drawn from geographic market areas, such as America, Europe and Asia Pacific, each of these geographic areas will have its own data series to avoid contagion.
   */
  numberOfDataSeries?: number;
}
  
/**
 * Defines a counterparty enumerated value, e.g. Party1 or Party2, with an associated party reference. The product is agnostic to the actual parties to the transaction, with the party references abstracted away from the product definition and replaced by the CounterpartyEnum (e.g. values Party1 or Party2). The CounterpartyEnum can then be positioned in the product (e.g. to specify which counterparty is the payer, receiver etc) and this Counterparty type, which is positioned outside of the product definition, allows the CounterpartyEnum to be associated with an actual party reference.
 */
export interface Counterparty {
  /**
   * Specifies the CounterpartyEnum, e.g. either Party1 or Party2, that is associated to the partyReference.
   */
  role?: CounterpartyRoleEnum;
  /**
   * Specifies the party that is associated to the counterparty.
   */
  partyReference?: ReferenceWithMeta<Party>;
}
  
export interface CounterpartyOwnIssuePermitted {
  /**
   * Represents a filter based on whether it is permitted for the underlying asset to be issued by the posting entity or part of their corporate family.
   */
  counterpartyOwnIssuePermitted?: boolean;
}
  
/**
 * A Position describes the accumulated effect of a set of securities or financial transactions.
 */
export interface CounterpartyPosition extends ContractBase {
  /**
   * Represents information specific to trades or positions involving contractual products.
   */
  contractDetails?: ReferenceWithMeta<ContractDetails>;
  /**
   * Defines specific attributes that relate to trade or position executions.
   */
  executionDetails?: ReferenceWithMeta<ExecutionDetails>;
  /**
   * Represents the collateral obligations of a party.
   */
  collateral?: ReferenceWithMeta<Collateral>;
  /**
   * Represents the identifier(s) that uniquely identify a position for an identity issuer. A position can include multiple identifiers, for example an internal position identifer and a UTI (Unique Trade Identifier).
   */
  positionIdentifier?: PositionIdentifier[];
  /**
   * The date and time when the position was opened.
   */
  openDateTime?: dateTime;
  /**
   * Reference to all the trades that constitute the position.
   */
  tradeReference?: ReferenceWithMeta<TradeState>[];
  /**
   * The parties involved in the position, including the Clearing Organization.
   */
  party?: Party[];
  /**
   * Represents the role each specified party takes in the position.
   */
  partyRole?: PartyRole[];
  /**
   * Encapsulates the core constituents that characterize a position.
   */
  positionBase?: TradableProduct;
}
  
/**
 * A business event represents a life cycle event of a position. The combination of the state changes results in a qualifiable life cycle event.
 */
export interface CounterpartyPositionBusinessEvent {
  /**
   * The intent attribute is meant to be specified when the event qualification cannot be programmatically inferred from the event features. As a result it is only associated with those primitives that can give way to such ambiguity, the quantityChange being one of those.
   */
  intent?: PositionEventIntentEnum;
  /**
   * The intent of a corporate action on the position.
   */
  corporateActionIntent?: CorporateActionTypeEnum;
  /**
   * Specifies the date on which the event is taking place. This date is equal to the trade date in the case of a simple execution.  However it can be different from the trade date, for example in the case of a partial termination.
   */
  eventDate?: Date;
  /**
   * The date on which the event contractually takes effect, when different from the event date.
   */
  effectiveDate?: Date;
  /**
   * Specifies the package information in case the business event represents several trades executed as a package (hence this attribute is optional). The package information is only instantiated once at the business event level to preserve referential integrity, whereas individual trades make reference to it to identify that they are part of a package.
   */
  packageInformation?: IdentifiedList;
  /**
   * Specifies the after position state(s) created.
   */
  after?: CounterpartyPositionState[];
}
  
/**
 * Defines the fundamental financial information that can be changed by a Primitive Event and by extension any business or life-cycle event. Each PositionState specifies where a Position is in its life-cycle. PositionState is a root type and as such, can be created independently to any other CDM data type, but can also be used as part of the CDM Event Model.
 */
export interface CounterpartyPositionState {
  /**
   * Represents the Position that has been effected by a business or life-cycle event.
   */
  counterpartyPosition?: CounterpartyPosition;
  /**
   * Represents the State of the Position through its life-cycle.
   */
  state?: State;
  /**
   * Represents the observed events related to a particular product or process, such as credit events or corporate actions.
   */
  observationHistory?: ObservationEvent[];
  valuationHistory?: Valuation[];
  meta?: MetaFields;
}
  
/**
 *  The credit default payout specification provides the details necessary for determining when a credit payout will be triggered as well as the parameters for calculating the payout and the settlement terms. The associated globalKey denotes the ability to associate a hash value to the CreditDefaultPayout instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 */
export interface CreditDefaultPayout extends PayoutBase {
  /**
   * Canonical representation of the payer and receiver parties applicable to each payout leg.
   */
  payerReceiver?: PayerReceiver;
  /**
   * Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
   */
  priceQuantity?: ResolvablePriceQuantity;
  /**
   * The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
   */
  principalPayment?: PrincipalPayments;
  /**
   * Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
   */
  settlementTerms?: SettlementTerms;
  /**
   * The specification of the non-monetary terms for the Credit Derivative Transaction, including the buyer and seller and selected items from the ISDA 2014 Credit Definition article II, such as the reference obligation and related terms.
   */
  generalTerms?: GeneralTerms;
  /**
   * Specifies the terms for calculating a payout to protect the buyer of the swap in the case of a qualified credit event. These terms include the applicable credit events, the reference obligation, and in the case of a CDS on mortgage-backed securities, the floatingAmountEvents.
   */
  protectionTerms?: ProtectionTerms[];
  /**
   * The qualification of the price at which the contract has been transacted, in terms of market fixed rate, initial points, market price and/or quotation style. In FpML, those attributes are positioned as part of the fee leg.
   */
  transactedPrice?: TransactedPrice;
}
  
/**
 * Specifies the relevant data regarding a credit event.
 */
export interface CreditEvent {
  /**
   * The type of credit event taking place.
   */
  creditEventType?: CreditEventTypeEnum;
  /**
   * The date in which the credit event is determined by the Credit Derivatives Determinations Comitee.
   */
  eventDeterminationDate?: Date;
  /**
   * The date on which the auction is scheduled to occur.
   */
  auctionDate?: Date;
  /**
   * The final price resulting from the auction.
   */
  finalPrice?: Price;
  /**
   * The percentage of the original value of the asset affected by the credit event that can be recovered.
   */
  recoveryPercent?: number;
  /**
   * A public information source, e.g. a particular newspaper or electronic news service, that may publish relevant information used in the determination of whether or not a credit event has occurred.
   */
  publiclyAvailableInformation?: Resource[];
  /**
   * The reference entity, part of a credit basket, impacted by the credit event.
   */
  referenceInformation?: ReferenceInformation;
}
  
export interface CreditEventNotice {
  /**
   * The notifying party is the party that notifies the other party when a credit event has occurred by means of a credit event notice. If more than one party is referenced as being the notifying party then either party may notify the other of a credit event occurring. ISDA 2003 Term: Notifying Party.
   */
  notifyingParty?: CounterpartyRoleEnum[];
  /**
   * Inclusion of this business center element implies that Greenwich Mean Time in Section 3.3 of the 2003 ISDA Credit Derivatives Definitions is replaced by the local time of the city indicated by the businessCenter element value.
   */
  businessCenter?: BusinessCenterEnum;
  /**
   * A specified condition to settlement. Publicly available information means information that reasonably confirms any of the facts relevant to determining that a credit event or potential repudiation/moratorium, as applicable, has occurred. The ISDA defined list (2003) is the market standard and is considered comprehensive, and a minimum of two differing public sources must have published the relevant information, to declare a Credit Event. ISDA 2003 Term: Notice of Publicly Available Information Applicable.
   */
  publiclyAvailableInformation?: PubliclyAvailableInformation;
}
  
/**
 * A class to specify the applicable Credit Events that would trigger a settlement, as specified in the related Confirmation and defined in the ISDA 2014 Credit Definition article IV section 4.1.
 */
export interface CreditEvents {
  /**
   * A credit event. The reference entity has been dissolved or has become insolvent. It also covers events that may be a precursor to insolvency such as instigation of bankruptcy or insolvency proceedings. Sovereign trades are not subject to Bankruptcy as 'technically' a Sovereign cannot become bankrupt. ISDA 2003 Term: Bankruptcy.
   */
  bankruptcy?: boolean;
  /**
   * A credit event. This credit event triggers, after the expiration of any applicable grace period, if the reference entity fails to make due payments in an aggregate amount of not less than the payment requirement on one or more obligations (e.g. a missed coupon payment). ISDA 2003 Term: Failure to Pay.
   */
  failureToPay?: FailureToPay;
  /**
   * A credit event. Corresponds to the failure by the Reference Entity to pay an expected principal amount or the payment of an actual principal amount that is less than the expected principal amount. ISDA 2003 Term: Failure to Pay Principal.
   */
  failureToPayPrincipal?: boolean;
  /**
   * A credit event. Corresponds to the failure by the Reference Entity to pay an expected interest amount or the payment of an actual interest amount that is less than the expected interest amount. ISDA 2003 Term: Failure to Pay Interest.
   */
  failureToPayInterest?: boolean;
  /**
   * A credit event. One or more of the obligations have become capable of being declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay. ISDA 2003 Term: Obligation Default.
   */
  obligationDefault?: boolean;
  /**
   * A credit event. One or more of the obligations have been declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay (preferred by the market over Obligation Default, because more definitive and encompasses the definition of Obligation Default - this is more favorable to the Seller). Subject to the default requirement amount. ISDA 2003 Term: Obligation Acceleration.
   */
  obligationAcceleration?: boolean;
  /**
   * A credit event. The reference entity, or a governmental authority, either refuses to recognise or challenges the validity of one or more obligations of the reference entity, or imposes a moratorium thereby postponing payments on one or more of the obligations of the reference entity. Subject to the default requirement amount. ISDA 2003 Term: Repudiation/Moratorium.
   */
  repudiationMoratorium?: boolean;
  /**
   * A credit event. A restructuring is an event that materially impacts the reference entity's obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2003 Term: Restructuring.
   */
  restructuring?: Restructuring;
  /**
   * A credit event. A governmental intervention is an event resulting from an action by a governmental authority that materially impacts the reference entity's obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2014 Term: Governmental Intervention.
   */
  governmentalIntervention?: boolean;
  /**
   * A credit event. Results from the fact that the rating of the reference obligation is down-graded to a distressed rating level. From a usage standpoint, this credit event is typically not applicable in case of RMBS trades.
   */
  distressedRatingsDowngrade?: boolean;
  /**
   * A credit event. Results from the fact that the underlier fails to make principal payments as expected.
   */
  maturityExtension?: boolean;
  /**
   * A credit event. Results from the fact that the underlier writes down its outstanding principal amount.
   */
  writedown?: boolean;
  /**
   * A credit event. Results from the fact that losses occur to the underlying instruments that do not result in reductions of the outstanding principal of the reference obligation.
   */
  impliedWritedown?: boolean;
  /**
   * In relation to certain credit events, serves as a threshold for Obligation Acceleration, Obligation Default, Repudiation/Moratorium and Restructuring. Market standard is USD 10,000,000 (JPY 1,000,000,000 for all Japanese Yen trades). This is applied on an aggregate or total basis across all Obligations of the Reference Entity. Used to prevent technical/operational errors from triggering credit events. ISDA 2003 Term: Default Requirement.
   */
  defaultRequirement?: Money;
  /**
   * A specified condition to settlement. An irrevocable written or verbal notice that describes a credit event that has occurred. The notice is sent from the notifying party (either the buyer or the seller) to the counterparty. It provides information relevant to determining that a credit event has occurred. This is typically accompanied by Publicly Available Information. ISDA 2003 Term: Credit Event Notice.
   */
  creditEventNotice?: CreditEventNotice;
  meta?: MetaFields;
}
  
/**
 * Specification of an index based on credit risk, typically composed using corporate debt instruments in a region or industry sector, e.g. the iTraxx indices.
 */
export interface CreditIndex extends IndexBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
  /**
   * A description of the Index.
   */
  name?: FieldWithMeta<String>;
  /**
   * The organisation that creates or maintains the Index.
   */
  provider?: LegalEntity;
  /**
   * The Asset Class of the Index.
   */
  assetClass?: AssetClassEnum;
  /**
   * A CDS index series identifier, e.g. 1, 2, 3 etc.
   */
  indexSeries?: number;
  /**
   * A CDS index series version identifier, e.g. 1, 2, 3 etc.
   */
  indexAnnexVersion?: number;
  /**
   * A CDS index series annex date.
   */
  indexAnnexDate?: Date;
  /**
   * A CDS index series annex source.
   */
  indexAnnexSource?: FieldWithMeta<IndexAnnexSourceEnum>;
  /**
   * Excluded reference entity.
   */
  excludedReferenceEntity?: ReferenceInformation[];
  /**
   * This element contains CDS tranche terms.
   */
  tranche?: Tranche;
  /**
   * Used to specify the Relevant Settled Entity Matrix when there are settled entities at the time of the trade.
   */
  settledEntityMatrix?: SettledEntityMatrix;
  /**
   * Index Factor is the index version factor or percent, expressed as an absolute decimal value between 0 and 1, that multiplied by the original notional amount yields the notional amount covered by the seller of protection.
   */
  indexFactor?: number;
  /**
   * Seniority of debt instruments comprising the index.
   */
  seniority?: CreditSeniorityEnum;
  meta?: MetaFields;
}
  
/**
 * A class to represent the credit limit utilisation information.
 */
export interface CreditLimitInformation {
  limitApplicable?: LimitApplicableExtended[];
}
  
/**
 * Credit limit utilisation breakdown by executed trades and pending orders.
 */
export interface CreditLimitUtilisation {
  /**
   * Credit limit utilisation attributable to executed trades.
   */
  executed?: CreditLimitUtilisationPosition;
  /**
   * Credit limit utilisation attributable to pending unexecuted orders.
   */
  pending?: CreditLimitUtilisationPosition;
}
  
export interface CreditLimitUtilisationPosition {
  /**
   * Credit limit utilisation attributable to short positions.
   */
  shortPosition?: number;
  /**
   * Credit limit utilisation attributable to long positions.
   */
  longPosition?: number;
  /**
   * Global credit limit utilisation amount, agnostic of long/short position direction.
   */
  global?: number;
}
  
/**
 * Represents a class to specify the credit notation as the combination of agency, notation, scale and debt type qualifications.
 */
export interface CreditNotation {
  /**
   * Specifies The credit agency to which the other variables (notation, scale, debt type) refer to.
   */
  agency?: CreditRatingAgencyEnum;
  /**
   * Specifies The credit rating notation. As it varies among credit rating agencies, FpML doesn't specify a default scheme.
   */
  notation?: FieldWithMeta<String>;
  /**
   * Specifies the credit rating scale, with a typical distinction between short term, long term. FpML doesn't specify a default scheme, which is hence not specified as an enumeration as part of the CDM.
   */
  scale?: FieldWithMeta<String>;
  /**
   * Specifies the credit rating debt type (e.g. long term, high yield, deposits, ...) associated with the credit rating notation and scale.
   */
  debt?: CreditRatingDebt;
  /**
   * Assesses the potential direction of a long-term credit rating over the intermediate term, which is generally up to two years for investment grade and generally up to one year for speculative grade.
   */
  outlook?: CreditRatingOutlookEnum;
  /**
   * Indicates the potential direction of a short-term or long-term rating. It focuses on identifiable events and short-term trends that cause ratings to be placed under special surveillance.
   */
  creditWatch?: CreditRatingCreditWatchEnum;
}
  
/**
 * Represents the credit rating notation higher level construct, which provides the ability to specify multiple rating notations.
 */
export interface CreditNotations {
  /**
   * Specifies only one credit notation is determined.
   */
  creditNotation?: CreditNotation;
  /**
   * Specifies if several credit notations exist, alongside an 'any' or 'all' or all condition.
   */
  creditNotations?: MultipleCreditNotations;
}
  
/**
 * Specifies the credit rating debt type(s) associated with the credit rating notation and scale. When several debt types are specified, they must be qualified through an 'any' or 'all'.
 */
export interface CreditRatingDebt {
  /**
   * Specifies when there is only one debt type. FpML doesn't specify values in relation to the associated scheme, which is hence not specified as an enumeration as part of the CDM.
   */
  debtType?: FieldWithMeta<String>;
  /**
   * Specifies if there are several debt types, alongside an 'any' or 'all' or all condition. As an example, Baa1 rating is required for any long term debt and deposit.
   */
  debtTypes?: MultipleDebtTypes;
}
  
/**
 * The set of elections which specify a Credit Support Annex or Deed.
 */
export interface CreditSupportAgreementElections {
}
  
export interface Curve {
  interestRateCurve?: InterestRateCurve;
  commodityCurve?: FieldWithMeta<CommodityReferencePriceEnum>;
}
  
/**
 * A class to specify an offset either as a normalized [multiplier, period, dayType] or as a custom provision of type string.
 */
export interface CustomisableOffset {
  offset?: Offset;
  customProvision?: string;
}
  
/**
 * In its initial iteration, this class is meant to support the DTCC TIW workflow information.
 */
export interface CustomisedWorkflow {
  /**
   * In this initial iteration, this corresponds to the DTCC TIW element name.
   */
  itemName?: string;
  /**
   * In this initial iteration, this corresponds to the DTCC value.
   */
  itemValue?: string;
}
  
/**
 * List of dates.
 */
export interface DateList {
  date?: Date[];
}
  
/**
 * A class defining a contiguous series of calendar dates. The date range is defined as all the dates between and including the start and the end date. The start date must fall on or before the end date.
 */
export interface DateRange {
  /**
   * The first date of a date range.
   */
  startDate?: Date;
  /**
   * The last date of a date range.
   */
  endDate?: Date;
}
  
/**
 * A data to:  provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
 */
export interface DateRelativeToCalculationPeriodDates {
  /**
   * A set of href pointers to calculation period dates defined somewhere else in the document.
   */
  calculationPeriodDatesReference?: ReferenceWithMeta<CalculationPeriodDates>[];
}
  
/**
 * A data to:  provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
 */
export interface DateRelativeToPaymentDates {
  /**
   * A set of href pointers to payment dates defined somewhere else in the document.
   */
  paymentDatesReference?: ReferenceWithMeta<PaymentDates>[];
}
  
/**
 * A data to:  provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
 */
export interface DateRelativeToValuationDates {
  /**
   * A set of href pointers to valuation period dates defined somewhere else in the document.
   */
  valuationDatesReference?: ReferenceWithMeta<PerformanceValuationDates>[];
}
  
/**
 * List of dateTimes.
 */
export interface DateTimeList {
  /**
   * The CDM specifies that the zoned date time is to be expressed in accordance with ISO 8601, either as UTC as an offset to UTC.
   */
  dateTime?: Date[];
}
  
/**
 * Defines a date and value pair. This definition is used for varying rate or amount schedules, e.g. a notional amortisation or a step-up coupon schedule.
 */
export interface DatedValue {
  /**
   * The date on which the associated step value becomes effective. This day may be subject to adjustment in accordance with a business day convention.
   */
  date?: Date;
  /**
   * The rate of amount which becomes effective on the associated step date. A rate of 5% would be represented as 0.05.
   */
  value?: number;
  meta?: MetaFields;
}
  
/**
 * Specifies selected economics of a debt instrument.
 */
export interface DebtEconomics {
  /**
   * Specifies the order of repayment in the event of a sale or bankruptcy of the issuer or a related party (eg guarantor).
   */
  debtSeniority?: DebtSeniorityEnum;
  /**
   * Specifies the general rule for periodic interest rate payment.
   */
  debtInterest?: DebtInterestEnum;
  /**
   * Specifies the general rule for repayment of principal.
   */
  debtPrincipal?: DebtPrincipalEnum;
}
  
/**
 * Specifies the type of debt instrument.
 */
export interface DebtType {
  /**
   * Specifies the characteristics of a debt instrument.
   */
  debtClass?: DebtClassEnum;
  /**
   * Specifies selected financial terms of a debt instrument.
   */
  debtEconomics?: DebtEconomics[];
}
  
/**
 * A class to specify all the ISDA terms relevant to defining the deliverable obligations.
 */
export interface DeliverableObligations {
  /**
   * Indicates whether accrued interest is included (true) or not (false). For cash settlement this specifies whether quotations should be obtained inclusive or not of accrued interest. For physical settlement this specifies whether the buyer should deliver the obligation with an outstanding principal balance that includes or excludes accrued interest. ISDA 2003 Term: Include/Exclude Accrued Interest.
   */
  accruedInterest?: boolean;
  /**
   * Used in both obligations and deliverable obligations to represent a class or type of securities which apply. ISDA 2003 Term: Obligation Category/Deliverable Obligation Category.
   */
  category?: ObligationCategoryEnum;
  /**
   * An obligation and deliverable obligation characteristic. An obligation that ranks at least equal with the most senior Reference Obligation in priority of payment or, if no Reference Obligation is specified in the related Confirmation, the obligations of the Reference Entity that are senior. ISDA 2003 Term: Not Subordinated.
   */
  notSubordinated?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. The currency or currencies in which an obligation or deliverable obligation must be payable. ISDA 2003 Term: Specified Currency.
   */
  specifiedCurrency?: SpecifiedCurrency;
  /**
   * An obligation and deliverable obligation characteristic. Any obligation that is not primarily (majority) owed to a Sovereign or Supranational Organisation. ISDA 2003 Term: Not Sovereign Lender.
   */
  notSovereignLender?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. Any obligation that is payable in any currency other than the domestic currency. Domestic currency is either the currency so specified or, if no currency is specified, the currency of (a) the reference entity, if the reference entity is a sovereign, or (b) the jurisdiction in which the relevant reference entity is organised, if the reference entity is not a sovereign. ISDA 2003 Term: Not Domestic Currency.
   */
  notDomesticCurrency?: NotDomesticCurrency;
  /**
   * An obligation and deliverable obligation characteristic. If the reference entity is a Sovereign, this means any obligation that is not subject to the laws of the reference entity. If the reference entity is not a sovereign, this means any obligation that is not subject to the laws of the jurisdiction of the reference entity. ISDA 2003 Term: Not Domestic Law.
   */
  notDomesticLaw?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. Indicates whether or not the obligation is quoted, listed or ordinarily purchased and sold on an exchange. ISDA 2003 Term: Listed.
   */
  listed?: boolean;
  /**
   * A deliverable obligation characteristic. In essence Not Contingent means the repayment of principal cannot be dependant on a formula/index, i.e. to prevent the risk of being delivered an instrument that may never pay any element of principal, and to ensure that the obligation is interest bearing (on a regular schedule). ISDA 2003 Term: Not Contingent.
   */
  notContingent?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. Any obligation other than an obligation that was intended to be offered for sale primarily in the domestic market of the relevant Reference Entity. This specifies that the obligation must be an internationally recognised bond. ISDA 2003 Term: Not Domestic Issuance.
   */
  notDomesticIssuance?: boolean;
  /**
   * A deliverable obligation characteristic. A loan that is freely assignable to a bank or financial institution without the consent of the Reference Entity or the guarantor, if any, of the loan (or the consent of the applicable borrower if a Reference Entity is guaranteeing the loan) or any agent. ISDA 2003 Term: Assignable Loan.
   */
  assignableLoan?: PCDeliverableObligationCharac;
  /**
   * A deliverable obligation characteristic. A loan that is capable of being assigned with the consent of the Reference Entity or the guarantor, if any, of the loan or any agent. ISDA 2003 Term: Consent Required Loan.
   */
  consentRequiredLoan?: PCDeliverableObligationCharac;
  /**
   * A deliverable obligation characteristic. A loan with a participation agreement whereby the buyer is capable of creating, or procuring the creation of, a contractual right in favour of the seller that provides the seller with recourse to the participation seller for a specified share in any payments due under the relevant loan which are received by the participation seller. ISDA 2003 Term: Direct Loan Participation.
   */
  directLoanParticipation?: LoanParticipation;
  /**
   * A deliverable obligation characteristic. An obligation that is transferable to institutional investors without any contractual, statutory or regulatory restrictions. ISDA 2003 Term: Transferable.
   */
  transferable?: boolean;
  /**
   * A deliverable obligation characteristic. An obligation that has a remaining maturity from the Physical Settlement Date of not greater than the period specified. ISDA 2003 Term: Maximum Maturity.
   */
  maximumMaturity?: Period;
  /**
   * A deliverable obligation characteristic. An obligation at time of default is due to mature and due to be repaid, or as a result of downgrade/bankruptcy is due to be repaid as a result of an acceleration clause. ISDA 2003 Term: Accelerated or Matured.
   */
  acceleratedOrMatured?: boolean;
  /**
   * A deliverable obligation characteristic. Any obligation that is not a bearer instrument. This applies to Bonds only and is meant to avoid tax, fraud and security/delivery provisions that can potentially be associated with Bearer Bonds. ISDA 2003 Term: Not Bearer.
   */
  notBearer?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: Full Faith and Credit Obligation Liability.
   */
  fullFaithAndCreditObLiability?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: General Fund Obligation Liability.
   */
  generalFundObligationLiability?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: Revenue Obligation Liability.
   */
  revenueObligationLiability?: boolean;
  /**
   * ISDA 1999 Term: Indirect Loan Participation. NOTE: Only applicable as a deliverable obligation under ISDA Credit 1999.
   */
  indirectLoanParticipation?: LoanParticipation;
  /**
   * A free format string to specify any excluded obligations or deliverable obligations, as the case may be, of the reference entity or excluded types of obligations or deliverable obligations. ISDA 2003 Term: Excluded Obligations/Excluded Deliverable Obligations.
   */
  excluded?: string;
  /**
   * This element is used to specify any other obligations of a reference entity in both obligations and deliverable obligations. The obligations can be specified free-form. ISDA 2003 Term: Other Obligations of a Reference Entity.
   */
  othReferenceEntityObligations?: string;
}
  
/**
 * A class to specify the application of Interest Amount with respect the Delivery Amount.
 */
export interface DeliveryAmount {
  /**
   * The standard election as specified by an enumeration.
   */
  standardElection?: DeliveryAmountElectionEnum;
  /**
   * The custom election that might be specified by the parties to the agreement.
   */
  customElection?: string;
}
  
/**
 * Specifies a specific date or the parameters for identifying the relevant contract date when the commodity reference price is a futures contract.
 */
export interface DeliveryDateParameters {
  /**
   * Provides a container for the parametric representation that specifies which nearby contract date would be used as a refrence for a price.
   */
  deliveryNearby?: Offset;
  /**
   * Specifies the specific contract date for the contract that should be referenced for a price.
   */
  deliveryDate?: AdjustableDate;
  /**
   * Specifies, for a Commodity Transaction that references a listed future, the day on which the specified future will roll to the next nearby month prior to the expiration of the referenced future. If the future will not roll at all - i.e. the price will be taken from the expiring contract, 0 days should be specified here. If the future will roll to the next nearby on the last trading day - i.e. the price will be taken from the next nearby on the last trading day, then 1 business day should be specified and so on.
   */
  deliveryDateRollConvention?: Offset;
  /**
   * Specifies, for a Commodity Transaction that references a listed future, the day on which the specified future will expire ahead of the actual expiration of the referenced future. For example: Z21 Contract expires on 19Nov21, with an adjust of 2D the 'expire' will be 16Nov21. DeliveryDateRollConvention takes precedence. Example: Pricing on the Z21 Contract with NearbyContractDay and a deliveryDateRoll of 10D, Sampling of the F22 Contract will occur on 8Nov21 through the last Date of the Z21 Contract. With an ExpConvention of 5D, the last sampling date on the F22 contract will be 12Nov21.
   */
  deliveryDateExpirationConvention?: Offset;
}
  
export interface DerivInstrmAttrbts {
  xpryDt?: string;
  pricMltplr?: string;
  undrlygInstrm?: UndrlygInstrm;
  dlvryTp?: string;
}
  
/**
 * Specifies the method according to which an amount or a date is determined.
 */
export interface DeterminationMethodology {
  /**
   * Represents a more granular dimention of observation. Typically relevent for resolving a unique equity price, which can be expressed as trade-weighted or volume-weighted averages.
   */
  determinationMethod?: DeterminationMethodEnum;
  /**
   * Specifies enumerations for the type of averaging calculation.
   */
  averagingMethod?: AveragingCalculationMethodEnum;
}
  
/**
 * Defines the roles and related terms which document the agreement of parties about any determination requirements ; mostly about Extraordinary Events, without being necessarily restricted to such scope, as further specified in the particular product at stake e.g. for instance when Calculation Agent is mentioned as the Price Determination Method enumarated value, etc.
 */
export interface DeterminationRolesAndTerms {
}
  
/**
 * An Asset that exists only in digital form, eg Bitcoin or Ethereum, that is not backed by other Assets; excludes the digital representation of other Assets, eg coins or Tokenised assets.
 */
export interface DigitalAsset extends AssetBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
}
  
/**
 * A data defining:  discounting information. The 2000 ISDA definitions, section 8.4. discounting (related to the calculation of a discounted fixed amount or floating amount) apply. This type must only be included if discounting applies.
 */
export interface DiscountingMethod {
  /**
   * The discounting method that is applicable.
   */
  discountingType?: DiscountingTypeEnum;
  /**
   * A discount rate, expressed as a decimal, to be used in the calculation of a discounted amount. A discount amount of 5% would be represented as 0.05.
   */
  discountRate?: number;
  /**
   * A discount day count fraction to be used in the calculation of a discounted amount.
   */
  discountRateDayCountFraction?: FieldWithMeta<DayCountFractionEnum>;
}
  
/**
 * A class to specify the Distributions and Interest Payment provisions applicable to the collateral agreement.
 */
export interface DistributionAndInterestPayment {
  /**
   * Represents the interest parameters for the various currencies, margin types, posting parties.
   */
  interestParameters?: CollateralInterestParameters[];
}
  
/**
 * The parameters which define whether dividends are applicable
 */
export interface DividendApplicability {
  /**
   * If present and true, then options exchange dividends are applicable.
   */
  optionsExchangeDividends?: boolean;
  /**
   * If present and true, then additional dividends are applicable.
   */
  additionalDividends?: boolean;
  /**
   * Represents the European Master Confirmation value of 'All Dividends' which, when applicable, signifies that, for a given Ex-Date, the daily observed Share Price for that day is adjusted (reduced) by the cash dividend and/or the cash value of any non cash dividend per Share (including Extraordinary Dividends) declared by the Issuer. All Dividends in accordance with the ISDA 2002 Equity Derivatives Definitions.
   */
  allDividends?: boolean;
}
  
/**
 * A class to specify the currency in which the dividends will be denominated, i.e. either in the dividend currency or in a currency specified as part of the contract.
 */
export interface DividendCurrency {
  /**
   * The currency in which the dividend is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
   */
  currency?: FieldWithMeta<String>;
  /**
   * Specifies the method according to which the dividend is determined, e.g. the dividend currency.
   */
  determinationMethod?: DeterminationMethodEnum;
  /**
   * Reference to a currency specified elsewhere in the document
   */
  currencyReference?: ReferenceWithMeta<String>;
}
  
/**
 * A class to specify the dividend date by reference to another date, with the ability to apply and offset. This class doesn't exist in FpML and is meant to simplify the choice constraint associated with the DividendPaymentDate class.
 */
export interface DividendDateReference {
  /**
   * Specification of the dividend date using an enumeration, with values such as the pay date, the ex-date or the record date.
   */
  dateReference?: DividendDateReferenceEnum;
  /**
   * Only to be used when SharePayment has been specified in the dividendDateReference element. The number of Currency Business Days following the day on which the Issuer of the Shares pays the relevant dividend to holders of record of the Shares.
   */
  paymentDateOffset?: Offset;
}
  
/**
 * A class describing the date on which the dividend will be paid/received. This class is also used to specify the date on which the FX rate will be determined, when applicable.
 */
export interface DividendPaymentDate {
  dividendDateReference?: DividendDateReference;
  dividendDate?: ReferenceWithMeta<AdjustableOrRelativeDate>;
}
  
/**
 * A class describing the dividend payout ratio associated with an equity underlier. In certain cases the actual ratio is not known on trade inception, and only general conditions are then specified.
 */
export interface DividendPayoutRatio {
  /**
   * Specifies the total actual dividend payout ratio associated with the equity underlier. A ratio of 90% should be expressed at 0.90.
   */
  totalRatio?: number;
  /**
   * Specifies the cash actual dividend payout ratio associated with the equity underlier. A ratio of 90% should be expressed at 0.90.
   */
  cashRatio?: number;
  /**
   * Specifies the non cash actual dividend payout ratio associated with the equity underlier. A ratio of 90% should be expressed at 0.90.
   */
  nonCashRatio?: number;
  /**
   * In the case of a basket underlier, specifies to which component of the basket this particular set of dividend payout ratios correspond.
   */
  basketConstituent?: ReferenceWithMeta<BasketConstituent>;
}
  
/**
 * Time bounded dividend payment periods, each with a dividend payment date per period.
 */
export interface DividendPeriod {
  /**
   * Dividend period start date.
   */
  startDate?: DividendPaymentDate;
  /**
   * Dividend period end date.
   */
  endDate?: DividendPaymentDate;
  /**
   * Date adjustments for all unadjusted dates in this dividend period.
   */
  dateAdjustments?: BusinessDayAdjustments;
  /**
   * For basket underliers, reference to the basket component which is paying dividends in the specified period.
   */
  basketConstituent?: ReferenceWithMeta<BasketConstituent>;
  /**
   * Specifies when the dividend will be paid to the receiver of the equity return. Has the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. Is not applicable in the case of a dividend reinvestment election.
   */
  dividendPaymentDate?: DividendPaymentDate;
  /**
   * Specifies the dividend valuation dates of the swap.
   */
  dividendValuationDate?: AdjustableOrRelativeDate;
}
  
/**
 * A class describing the conditions governing the payment of dividends to the receiver of the equity return, with the exception of the dividend payout ratio, which is defined for each of the underlying components.
 */
export interface DividendReturnTerms {
  /**
   * Specifies the dividend payout ratio associated with each underlier. In FpML 5.10 the payout is positioned at the underlier level, although there is an intent to reconsider this approach and position it at the leg level. This is approach adopted by the CDM.
   */
  dividendPayoutRatio?: DividendPayoutRatio[];
  /**
   * Boolean element that defines whether the dividend will be reinvested or not.
   */
  dividendReinvestment?: boolean;
  /**
   * Defines the date on which the receiver of the equity return is entitled to the dividend.
   */
  dividendEntitlement?: DividendEntitlementEnum;
  /**
   * Specifies whether the dividend is paid with respect to the Dividend Period.
   */
  dividendAmountType?: DividendAmountTypeEnum;
  /**
   * Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.
   */
  performance?: string;
  /**
   * 2002 ISDA Equity Derivatives Definitions: Dividend Period as either the First Period or the Second Period. | 
   */
  firstOrSecondPeriod?: DividendPeriodEnum;
  /**
   * Specifies the party which determines if dividends are extraordinary in relation to normal levels.
   */
  extraordinaryDividendsParty?: AncillaryRoleEnum;
  /**
   * Determination of Gross Cash Dividend per Share.
   */
  excessDividendAmount?: DividendAmountTypeEnum;
  /**
   * Specifies the currency in which the dividend will be denominated, e.g. the dividend currency, or a specified currency. This class is not specified as such in FpML, which makes use of the CurrencyAndDeterminationMethod.model to specify such terms.
   */
  dividendCurrency?: DividendCurrency;
  /**
   * Specifies the treatment of Non-Cash Dividends.
   */
  nonCashDividendTreatment?: NonCashDividendTreatmentEnum;
  /**
   * Specifies how the composition of Dividends is to be determined.
   */
  dividendComposition?: DividendCompositionEnum;
  /**
   * Specifies the method according to which special dividends are determined.
   */
  specialDividends?: boolean;
  /**
   * If present and true, then material non cash dividends are applicable.
   */
  materialDividend?: boolean;
  /**
   * One to many time bounded dividend payment periods, each with a dividend payment date per period.
   */
  dividendPeriod?: DividendPeriod[];
}
  
/**
 * Information related to dividends and payments.
 */
export interface DividendTerms {
  /**
   * Specifies the proportion of the value of the dividend on the borrowed shares that the borrower is legally obligated to return to the lender.
   */
  manufacturedIncomeRequirement?: DividendPayoutRatio;
  /**
   * Defines the date on which the receiver of the equity return is entitled to the dividend.
   */
  dividendEntitlement?: DividendEntitlementEnum;
  /**
   * daily fee increments accrue until a threshold is crossed, at which point payment becomes due)
   */
  minimumBillingAmount?: Money;
}
  
export interface Document {
  finInstrmRptgTxRpt?: FinInstrmRptgTxRpt;
}
  
export interface DomesticCurrencyIssued {
  /**
   * Identifies that the Security must be denominated in the domestic currency of the issuer.
   */
  domesticCurrencyIssued?: boolean;
}
  
/**
 * A data to:  define the adjusted dates associated with an early termination provision.
 */
export interface EarlyTerminationEvent {
  /**
   * The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
   */
  adjustedExerciseDate?: Date;
  /**
   * The early termination date that is applicable if an early termination provision is exercised. This date should already be adjusted for any applicable business day convention.
   */
  adjustedEarlyTerminationDate?: Date;
  /**
   * The date by which the cash settlement amount must be agreed. This date should already be adjusted for any applicable business day convention.
   */
  adjustedCashSettlementValuationDate?: Date;
  /**
   * The date on which the cash settlement amount is paid. This date should already be adjusted for any applicable business date convention.
   */
  adjustedCashSettlementPaymentDate?: Date;
  /**
   * The date on which the exercise fee amount is paid. This date should already be adjusted for any applicable business day convention.
   */
  adjustedExerciseFeePaymentDate?: Date;
  meta?: MetaFields;
}
  
/**
 * A data defining:  an early termination provision for a swap. This early termination is at fair value, i.e. on termination the fair value of the product must be settled between the parties.
 */
export interface EarlyTerminationProvision {
  /**
   * A mandatory early termination provision to terminate the swap at fair value.
   */
  mandatoryEarlyTermination?: MandatoryEarlyTermination;
  /**
   * Period after trade date of the mandatory early termination date.
   */
  mandatoryEarlyTerminationDateTenor?: Period;
  /**
   * An option for either or both parties to terminate the swap at fair value.
   */
  optionalEarlyTermination?: OptionalEarlyTermination;
  /**
   * Definition of the first early termination date and the frequency of the termination dates subsequent to that. American exercise is defined by having a frequency of one day.
   */
  optionalEarlyTerminationParameters?: ExercisePeriod;
  meta?: MetaFields;
}
  
/**
 *  This class represents the full set of price-forming features associated with a contractual product: the payout component, the notional/quantity, the effective and termination date and the date adjustment provisions when applying uniformily across the payout components. This class also includes the legal provisions which have valuation implications: cancelable provision, extendible provision, early termination provision and extraordinary events specification.
 */
export interface EconomicTerms {
  /**
   * The first day of the terms of the trade. This day may be subject to adjustment in accordance with a business day convention.
   */
  effectiveDate?: AdjustableOrRelativeDate;
  /**
   * The last day of the terms of the trade. This date may be subject to adjustments in accordance with the business day convention. It can also be specified in relation to another scheduled date (e.g. the last payment date).
   */
  terminationDate?: AdjustableOrRelativeDate;
  /**
   * The business day adjustment convention when it applies across all the payout components. This specification of the business day convention and financial business centers is used for adjusting any calculation period date if it would otherwise fall on a day that is not a business day in the specified business center.
   */
  dateAdjustments?: BusinessDayAdjustments;
  /**
   * The payout specifies the future cashflow computation methodology which characterizes a financial product.
   */
  payout?: Payout[];
  /**
   * Contains optional provisions pertaining to the termination characteristics of a contract.
   */
  terminationProvision?: TerminationProvision;
  /**
   * The ISDA calculation agent responsible for performing duties as defined in the applicable product definitions.
   */
  calculationAgent?: CalculationAgent;
  /**
   * Specifies, when boolean value is True, that additional economic terms exist that have not been included in the product representation.
   */
  nonStandardisedTerms?: boolean;
  /**
   * Represents the collateral obligations of a party.
   */
  collateral?: Collateral;
}
  
/**
 * Query to check against an EligibleCollateralSpecification
 */
export interface EligibilityQuery {
  /**
   * Maturity in years
   */
  maturity?: number;
  /**
   * The asset product type.
   */
  collateralAssetType?: AssetType;
  /**
   * The asset country of origin.
   */
  assetCountryOfOrigin?: ISOCountryCodeEnum;
  /**
   * The underlying asset denominated currency.
   */
  denominatedCurrency?: CurrencyCodeEnum;
  /**
   * The agency rating based on default risk and creditors claim in event of default associated with specific instrument.
   */
  agencyRating?: AgencyRatingCriteria;
  /**
   * Represents a filter based on the type of entity issuing the asset.
   */
  issuerType?: CollateralIssuerType;
  /**
   * Specifies the issuing entity name or LEI.
   */
  issuerName?: LegalEntity;
}
  
/**
 * Represents a set of criteria used to specify eligible collateral.
 */
export interface EligibleCollateralCriteria extends CollateralCriteriaBase {
  /**
   * The specific criteria that applies. It can be created using AND, OR and NOT logic, and both asset and issuer characteristics.
   */
  collateralCriteria?: CollateralCriteria;
  /**
   * Specifies which of the two counterparties the criteria applies to (either one or both counterparties). This attribute is optional, in case the applicable party is already specified elsewhere within a party election.
   */
  appliesTo?: CounterpartyRoleEnum[];
  /**
   * Restrict the criteria to only apply to a specific type of margin, ie IM or VM.
   */
  restrictTo?: CollateralMarginTypeEnum;
  /**
   * Denotes which Criteria has priority if more than one agency rating applies.
   */
  ratingPriorityResolution?: RatingPriorityResolutionEnum;
  /**
   * Identifies the treatment of specified collateral, e.g., haircuts,holding limits or exclusions.
   */
  treatment?: CollateralTreatment;
}
  
/**
 * Represents a set of criteria used to specify eligible collateral.
 */
export interface EligibleCollateralSpecification {
  /**
   * Specifies the identifier(s) to uniquely identify eligible collateral or a set of eligible collateral, such as a schedule or equivalant for an identity issuer.
   */
  identifier?: Identifier[];
  /**
   * The parties associated with the specification.
   */
  party?: Party[];
  /**
   * Specification of the roles of the counterparties to the specification.
   */
  counterparty?: Counterparty[];
  /**
   * Represents a set of criteria used to specify eligible collateral.
   */
  criteria?: EligibleCollateralCriteria[];
  /**
   * Specifies the role(s) that each of the party(s) is playing in the context of the specification, eg Payor or Receiver.
   */
  partyRole?: PartyRole[];
  meta?: MetaFields;
}
  
export interface EligibleCollateralSpecificationInstruction {
  common?: EligibleCollateralCriteria;
  variable?: EligibleCollateralCriteria[];
}
  
/**
 * Transaction AdditionalTerms that apply to Equity asset class.
 */
export interface EquityAdditionalTerms {
  extraordinaryEvents?: ExtraordinaryEvents;
  determinationTerms?: DeterminationRolesAndTerms[];
  substitutionProvision?: UnderlierSubstitutionProvision;
}
  
/**
 * A class for defining the merger events and their treatment.
 */
export interface EquityCorporateEvents {
}
  
/**
 * Specification of an index based on equity securities, e.g. the S&P 500..
 */
export interface EquityIndex extends IndexBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
  /**
   * A description of the Index.
   */
  name?: FieldWithMeta<String>;
  /**
   * The organisation that creates or maintains the Index.
   */
  provider?: LegalEntity;
  /**
   * The Asset Class of the Index.
   */
  assetClass?: AssetClassEnum;
}
  
/**
 * Specification for General Terms and Elections of an Equity Master Confirmation that is applicable across multiple Equity confirmations and is referenced by each of these confirmations, an example of which being the 2018 ISDA CDM Equity Confirmation for Security Equity Swap.
 */
export interface EquityMasterConfirmation extends MasterConfirmationBase {
}
  
/**
 * Specification for the General Terms and Relationship Supplement Elections as provided in the 2018 ISDA CDM Equity Confirmation for Security Equity Swap.
 */
export interface EquitySwapMasterConfirmation2018 extends EquityMasterConfirmation {
  /**
   * Per Part 1 Section 4, 'Dividend Obligations', of the 2018 ISDA CDM Equity Confirmation, Para 4.2 'Dividend Returns'
   */
  typeOfSwapElection?: ReturnTypeEnum;
  /**
   * Per Part 1 Section 5, 'Pricing', of the 2018 ISDA CDM Equity Confirmation, Para 5.1
   */
  pricingMethodElection?: PriceReturnTerms;
  /**
   * Per Part 1 Section 3, 'Floating Obligations', of the 2018 ISDA CDM Equity Confirmation. Para 3.3
   */
  linearInterpolationElection?: InterpolationMethodEnum;
  /**
   * Per Part 1 Section 8, 'Settlement', of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap
   */
  settlementTerms?: SettlementTerms;
  /**
   * The parameters used to generate the 'Equity Valuation Dates' schedule, including the Effective Date and Termination Date for the Swap.
   */
  valuationDates?: ValuationDates;
  /**
   * The parameters used to generate the payment date schedule, relative to the equityCalculationPeriod. Per Part 1 Section 12, 'Definitions', of the 2018 ISDA CDM Equity Confirmation. Para 73
   */
  equityCashSettlementDates?: PaymentDates;
}
  
export interface EquityUnderlierProvisions {
  /**
   * For an index option or swap transaction, a flag to indicate whether a relevant Multiple Exchange Index Annex is applicable to the transaction. This annex defines additional provisions which are applicable where an index is comprised of component securities that are traded on multiple exchanges.
   */
  multipleExchangeIndexAnnexFallback?: boolean;
  /**
   * For an index option or swap transaction, a flag to indicate whether a relevant Component Security Index Annex is applicable to the transaction.
   */
  componentSecurityIndexAnnexFallback?: boolean;
  /**
   * The ISO 3166 standard code for the country within which the postal address is located.
   */
  localJurisdiction?: FieldWithMeta<String>;
  /**
   * The ISO 3166 standard code for the country within which the postal address is located.
   */
  relevantJurisdiction?: FieldWithMeta<String>;
}
  
/**
 * Specifies instructions to create a BusinessEvent.
 */
export interface EventInstruction {
  /**
   * The intent attribute is meant to be specified when the event qualification cannot be programmatically inferred from the event features. As a result it is only associated with those primitives that can give way to such ambiguity, the quantityChange being one of those. An example of such is a reduction in the trade notional, which could be interpreted as either a trade correction (unless a maximum period of time post-event is specified as part of the qualification), a partial termination or a portfolio rebalancing in the case of an equity swap. On the other hand, an event such as the exercise is not expected to have an associated intent as there should not be ambiguity.
   */
  intent?: EventIntentEnum;
  corporateActionIntent?: CorporateActionTypeEnum;
  /**
   * Specifies the date on which the event is taking place. This date is equal to the trade date in the case of a simple execution.  However it can be different from the trade date, for example in the case of a partial termination.
   */
  eventDate?: Date;
  /**
   * The date on which the event contractually takes effect, when different from the event date.
   */
  effectiveDate?: Date;
  /**
   * Specifies the package information in case the business event represents several trades executed as a package (hence this attribute is optional). The package information is only instantiated once at the business event level to preserve referential integrity, whereas individual trades make reference to it to identify that they are part of a package.
   */
  packageInformation?: IdentifiedList;
  /**
   * Specifies the instructions to create the Business Event.
   */
  instruction?: Instruction[];
}
  
/**
 * A class to represent the various set of timestamps that can be associated with lifecycle events, as a collection of [dateTime, qualifier].
 */
export interface EventTimestamp {
  /**
   * The CDM specifies that the zoned date time is to be expressed in accordance with ISO 8601, either as UTC as an offset to UTC.
   */
  dateTime?: Date;
  /**
   * The timestamp qualifier is specified through an enumeration because the experience of integrating the DTCC and CME data representations suggests that a wide set of timestamps are currently utilized among service providers, while there is not at present an objective set of criteria that could help suggest a defined set of timestamps as part of the CDM. At some future point, one possible baseline could be developed from the review of the set of timestamps specified across regulatory regimes and regulations (incl. regulations such as high frequency trading). Also, the integration with a further set of implementations and the specification of business workflows such as clearing as part of the CDM development should help confirm the implementation approach in this respect.
   */
  qualification?: EventTimestampQualificationEnum;
}
  
/**
 * Specifies a transaction which automatically extends for a specified timeframe until the exercise of an embedded option.
 */
export interface EvergreenProvision {
  /**
   * If evergreen termination is not available to both parties then this component specifies the buyer and seller of the option.
   */
  singlePartyOption?: PartyRole;
  /**
   * The length of each evergreen extension period relative to the effective date of the preceding contract.
   */
  noticePeriod?: RelativeDateOffset;
  /**
   * Defines the minimum period before an evergreen is scheduled to terminate that notice can be given that it will terminate beyond the scheduled termination date.
   */
  noticeDeadlinePeriod?: RelativeDateOffset;
  /**
   * A specific date and time for the notice deadline
   */
  noticeDeadlineDateTime?: Date;
  /**
   * The frequency with which the evergreen contract will be extended if notice is not given.
   */
  extensionFrequency?: AdjustableRelativeOrPeriodicDates;
  /**
   * An optional adjustment to the rate for the last period of the evergreen i.e. the period from when notice is given to stop rolling the contract through to the termination date.
   */
  finalPeriodFeeAdjustment?: Price;
}
  
export interface ExctgPrsn {
  prsn?: Prsn;
}
  
/**
 * Defines specific attributes that relate to trade executions.
 */
export interface ExecutionDetails {
  /**
   * Identifies the type of execution, e.g. via voice, electronically...
   */
  executionType?: ExecutionTypeEnum;
  /**
   * Represents the venue on which a trade was executed.
   */
  executionVenue?: LegalEntity;
  /**
   * A reference to the package linking the trade with other trades, in case the trade was executed as part of a package (hence this attribute is optional).
   */
  packageReference?: IdentifiedList;
  meta?: MetaFields;
}
  
/**
 * Specifies instructions for execution of a transaction, consisting of a product, price, quantity, parties, trade identifier, execution details, and settlement terms.
 */
export interface ExecutionInstruction {
  /**
   * Defines the financial product to be executed and contract formed.
   */
  product?: NonTransferableProduct;
  /**
   * Defines the prices (e.g. spread, equity price, FX rate), quantities (e.g. currency amount, no. shares) and settlement terms (e.g. initial fee, broker fee, up-front cds payment or option premium settlement) associated with the constituents of the transacted product.
   */
  priceQuantity?: PriceQuantity[];
  /**
   * Maps two defined parties to counterparty enums for the transacted product.
   */
  counterparty?: Counterparty[];
  /**
   * Maps any ancillary parties, e.g. parties involved in the transaction that are not one of the two principal parties.
   */
  ancillaryParty?: AncillaryParty[];
  /**
   * Defines all parties to that execution, including agents and brokers.
   */
  parties?: Party[];
  /**
   * Defines the role(s) that party(ies) may have in relation to the execution.
   */
  partyRoles?: PartyRole[];
  /**
   * Specifies the type and venue of execution, e.g. via voice, or electronically.
   */
  executionDetails?: ExecutionDetails;
  /**
   * Denotes the trade/execution date.
   */
  tradeDate?: FieldWithMeta<Date>;
  /**
   * Denotes the trade time and timezone as agreed by the parties to the trade.
   */
  tradeTime?: FieldWithMeta<TimeZone>;
  /**
   * Denotes one or more identifiers associated with the transaction.
   */
  tradeIdentifier?: TradeIdentifier[];
  /**
   * Detail the collateral requirement anticipated with the transaction.
   */
  collateral?: Collateral;
  /**
   * Lot Identifier associated with the transaction.
   */
  lotIdentifier?: Identifier;
}
  
/**
 * A data defining:  the adjusted dates associated with a particular exercise event.
 */
export interface ExerciseEvent {
  /**
   * The date on which the option exercise takes place. This date should already be adjusted for any applicable business day convention.
   */
  adjustedExerciseDate?: Date;
  /**
   * The effective date of the underlying swap associated with a given exercise date. This date should already be adjusted for any applicable business day convention.
   */
  adjustedRelevantSwapEffectiveDate?: Date;
  /**
   * The date by which the cash settlement amount must be agreed. This date should already be adjusted for any applicable business day convention.
   */
  adjustedCashSettlementValuationDate?: Date;
  /**
   * The date on which the cash settlement amount is paid. This date should already be adjusted for any applicable business day convention.
   */
  adjustedCashSettlementPaymentDate?: Date;
  /**
   * The date on which the exercise fee amount is paid. This date should already be adjusted for any applicable business day convention.
   */
  adjustedExerciseFeePaymentDate?: Date;
  meta?: MetaFields;
}
  
/**
 * A class defining the fee payable on exercise of an option. This fee may be defined as an amount or a percentage of the notional exercised. As a difference with FpML, it extends the BuyerSeller class.
 */
export interface ExerciseFee extends PayerReceiver {
  /**
   * Specifies the counterparty responsible for making the payments defined by this structure.  The party is one of the two principal parties to the transaction.
   */
  payer?: CounterpartyRoleEnum;
  /**
   * Specifies the party that receives the payments corresponding to this structure.  The party is one of the two counterparties to the transaction.
   */
  receiver?: CounterpartyRoleEnum;
  /**
   * A pointer style reference to the associated notional schedule defined elsewhere in the document.
   */
  notionalReference?: ReferenceWithMeta<Money>;
  /**
   * The amount of fee to be paid on exercise. The fee currency is that of the referenced notional.
   */
  feeAmount?: number;
  /**
   * A fee represented as a percentage of some referenced notional. A percentage of 5% would be represented as 0.05.
   */
  feeRate?: number;
  /**
   * The date on which exercise fee(s) will be paid. It is specified as a relative date.
   */
  feePaymentDate?: RelativeDateOffset;
}
  
/**
 * A class to define a fee or schedule of fees to be payable on the exercise of an option. This fee may be defined as an amount or a percentage of the notional exercised. As a difference with FpML, it extends the BuyerSeller class.
 */
export interface ExerciseFeeSchedule extends PayerReceiver {
  /**
   * Specifies the counterparty responsible for making the payments defined by this structure.  The party is one of the two principal parties to the transaction.
   */
  payer?: CounterpartyRoleEnum;
  /**
   * Specifies the party that receives the payments corresponding to this structure.  The party is one of the two counterparties to the transaction.
   */
  receiver?: CounterpartyRoleEnum;
  /**
   * A pointer style reference to the associated notional schedule defined elsewhere in the document.
   */
  notionalReference?: ReferenceWithMeta<Money>;
  /**
   * The exercise fee amount schedule. The fees are expressed as currency amounts. The currency of the fee is assumed to be that of the notional schedule referenced.
   */
  feeAmountSchedule?: AmountSchedule;
  /**
   * The exercise free rate schedule. The fees are expressed as percentage rates of the notional being exercised. The currency of the fee is assumed to be that of the notional schedule referenced.
   */
  feeRateSchedule?: Schedule;
  /**
   * The date on which exercise fee(s) will be paid. It is specified as a relative date.
   */
  feePaymentDate?: RelativeDateOffset;
}
  
/**
 * Specifies the information required to communicate the choices made by the exercising party, in a financial product endowing the party with at least one option.
 */
export interface ExerciseInstruction {
  /**
   * Contains instructions for exercising the option including a quantity change, and optionally a transfer.
   */
  exerciseQuantity?: PrimitiveInstruction;
  /**
   * Specifies the Option Payout being exercised on the trade.
   */
  exerciseOption?: ReferenceWithMeta<OptionPayout>;
  /**
   * Specifies the date on which an option contained within the financial product would be exercised. The date may be omitted if the contractual product allows for only a single date of exercise (European exercise).
   */
  exerciseDate?: AdjustableOrAdjustedDate;
  /**
   * Specifies the time at which an option contained within the financial product woulld be exercised. The time may be omitted if the contractual product allows for only a single time of exercise (European exercise). 
   */
  exerciseTime?: BusinessCenterTime;
  /**
   * Specifies the trade identifier to apply to the replacement trade for physical exercise.
   */
  replacementTradeIdentifier?: TradeIdentifier[];
}
  
/**
 * Defines to whom and where notice of execution should be given. The exerciseNoticeGiver refers to one or both of the principal parties of the trade. If present the exerciseNoticeReceiver refers to a party, other than the principal party, to whom notice should be given.
 */
export interface ExerciseNotice {
  /**
   * Specifies the principal party of the trade that has the right to exercise.
   */
  exerciseNoticeGiver?: ExerciseNoticeGiverEnum;
  /**
   * Specifies the party to which notice of exercise should be given, e.g. by the buyer of the option. Although in many cases it is the buyer of the option who sends the exercise notice to the seller of the option, this component is reused, e.g. in case of OptionEarlyTermination, either or both parties have the right to exercise.
   */
  exerciseNoticeReceiver?: AncillaryRoleEnum;
  /**
   * Specifies the location where the exercise must be reported, e.g. where the exercise notice receiver is based.
   */
  businessCenter?: FieldWithMeta<BusinessCenterEnum>;
}
  
/**
 * This defines the time interval to the start of the exercise period, i.e. the earliest exercise date, and the frequency of subsequent exercise dates (if any).
 */
export interface ExercisePeriod {
  /**
   * The time interval to the first (and possibly only) exercise date in the exercise period.
   */
  earliestExerciseDateTenor?: Period;
  /**
   * The frequency of subsequent exercise dates in the exercise period following the earliest exercise date. An interval of 1 day should be used to indicate an American style exercise period.
   */
  exerciseFrequency?: Period;
  meta?: MetaFields;
}
  
/**
 * A class describing how notice of exercise should be given. This can be either manual or automatic.
 */
export interface ExerciseProcedure {
  /**
   * Specifies that the notice of exercise must be given by the buyer to the seller or seller's agent.
   */
  manualExercise?: ManualExercise;
  /**
   * If automatic is specified, then the notional amount of the underlying swap not previously exercised under the swaption will be automatically exercised at the expiration time on the expiration date if at such time the buyer is in-the-money, provided that the difference between the settlement rate and the fixed rate under the relevant underlying swap is not less than the specified threshold rate. The term in-the-money is assumed to have the meaning defining in the 2000 ISDA Definitions, Section 17.4 In-the-money.
   */
  automaticExercise?: AutomaticExercise;
  /**
   * A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller's agent.
   */
  followUpConfirmation?: boolean;
  /**
   * Has the meaning defined as part of the 1997 ISDA Government Bond Option Definitions, section 4.5 Limited Right to Confirm Exercise. If present, (i) the Seller may request the Buyer to confirm its intent if not done on or before the expiration time on the Expiration date (ii) specific rules will apply in relation to the settlement mode.
   */
  limitedRightToConfirm?: boolean;
  /**
   * Typically applicable to the physical settlement of bond and convertible bond options. If present, means that the party required to deliver the bonds will divide those to be delivered as notifying party desires to facilitate delivery obligations.
   */
  splitTicket?: boolean;
}
  
/**
 * A class defining the exercise period for an option together with any rules governing the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fees.
 */
export interface ExerciseTerms {
  /**
   * Whether the option has a single exercise (european), multiple exercise dates (bermuda), or a continuous range of exercise (american).
   */
  style?: OptionExerciseStyleEnum;
  /**
   * The first day of the exercise period for an American style option.
   */
  commencementDate?: AdjustableOrRelativeDate;
  /**
   * The dates that define the Bermuda option exercise dates and the expiration date. The last specified date is assumed to be the expiration date. The dates can either be specified as a series of explicit dates and associated adjustments or as a series of dates defined relative to another schedule of dates, for example, the calculation period start dates. Where a relative series of dates are defined the first and last possible exercise dates can be separately specified.
   */
  exerciseDates?: AdjustableOrRelativeDates;
  /**
   * The last day within an exercise period for an American style option. For a European style option it is the only day within the exercise period.
   */
  expirationDate?: AdjustableOrRelativeDate[];
  /**
   * The effective date on the underlying product if the option is exercised.  For example, for a swaption it is the swap effective date, for an option on an FX spot or forward it is the value date for settlement, and in an extendible/cancelable provision it is the swap termination date, which is the date on which the termination is effective.'
   */
  relevantUnderlyingDate?: AdjustableOrRelativeDates;
  /**
   * The earliest time at which notice of exercise can be given by the buyer to the seller (or seller's agent) to, and including, the expiration date.
   */
  earliestExerciseTime?: BusinessCenterTime;
  /**
   * For a Bermuda or American style option, the latest time on an exercise business day (excluding the expiration date) within the exercise period that notice can be given by the buyer to the seller or seller's agent. Notice of exercise given after this time will be deemed to have been given on the next exercise business day.
   */
  latestExerciseTime?: BusinessCenterTime;
  /**
   * The latest time for exercise on expirationDate. It is made mandatory given that for all option styles, this field is required.
   */
  expirationTime?: BusinessCenterTime;
  /**
   * The time of day at which the equity option expires, for example the official closing time of the exchange.
   */
  expirationTimeType?: ExpirationTimeTypeEnum;
  /**
   * As defined in the 2000 ISDA Definitions, Section 12.4. Multiple Exercise, the buyer of the option has the right to exercise all or less than all the unexercised notional amount of the underlying swap on one or more days in the exercise period, but on any such day may not exercise less than the minimum notional amount or more that the maximum notional amount, and if an integral multiple amount is specified, the notional amount exercised must be equal to, or be an integral multiple of, the integral multiple amount.
   */
  multipleExercise?: MultipleExercise;
  /**
   * The fees associated with an exercise date. The fees are conditional on the exercise occurring. The fees can be specified as actual currency amounts or as percentages of the notional amount being exercised.
   */
  exerciseFeeSchedule?: ExerciseFeeSchedule;
  /**
   * The set of parameters defining the procedure associated with the exercise, e.g. manual exercise.
   */
  exerciseProcedure?: ExerciseProcedure;
  /**
   * A fee to be paid on exercise. This could be represented as an amount or a rate and notional reference on which to apply the rate.
   */
  exerciseFee?: ExerciseFee;
  /**
   * As defined in the 2000 ISDA Definitions, Section 12.3. Partial Exercise, the buyer of the option has the right to exercise all or less than all the notional amount of the underlying swap on the expiration date, but may not exercise less than the minimum notional amount, and if an integral multiple amount is specified, the notional amount exercised must be equal to, or be an integral multiple of, the integral multiple amount.
   */
  partialExercise?: PartialExercise;
  meta?: MetaFields;
}
  
/**
 * Represents the current mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency).
 */
export interface Exposure {
  /**
   * Represents a Portfolio that describes all the positions held at a given time, in various states which can be either traded, settled, etc., with lineage information to the previous state.
   */
  tradePortfolio?: ReferenceWithMeta<PortfolioState>;
  /**
   * Represents the aggregate value of the portfolio in base currency.
   */
  aggregateValue?: Money;
  /**
   * Indicates the date when the exposure is calculated if different from valuation date.
   */
  calculationDateTime?: Date;
  /**
   * Indicates the valuation date of the exposure underlying the calculation.
   */
  valuationDateTime?: Date;
}
  
/**
 * A data defining:  an option to extend an existing swap transaction on the specified exercise dates for a term ending on the specified new termination date. As a difference from FpML, it extends the BuyerSeller class, which represents the BuyerSeller.model.
 */
export interface ExtendibleProvision extends BuyerSeller {
  /**
   * Buyer party that can be resolved as one of the two principal parties to the transaction. The party that buys this instrument, i.e. pays for this instrument and receives the rights defined by it. ISDA 2002 Equity Definitions section 1.18: `Buyer` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (b)(i) relating to a Swaption: 'Buyer' means the party that will, on each Premium Payment Date, pay to Seller the Premium | ISDA 2006 Definitions article 12.1 (b)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such in the related Confirmation, or the Exercising Party if neither party is specified | ISDA 2006 Definitions article 12.1 (b)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Buyer` means the Fixed Rate Payer.
   */
  buyer?: CounterpartyRoleEnum;
  /**
   * Seller party that can be resolved as one of the two principal parties to the transaction. The party that sells ('writes') this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. ISDA 2002 Equity Definitions section 1.19: `Seller` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (a)(i) relating to a Swaption: 'Seller' means the party the party specified as such or as writer in the related Confirmation | ISDA 2006 Definitions article 12.1 (a)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such or as writer in the related Confirmation or, if neither party is specified as such, the Non-exercising Party | ISDA 2006 Definitions article 12.1 (a)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Seller` means the Floating Rate Payer.
   */
  seller?: CounterpartyRoleEnum;
  /**
   * Definition of the party to whom notice of exercise should be given.
   */
  exerciseNotice?: ExerciseNotice;
  /**
   * A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller's agent.
   */
  followUpConfirmation?: boolean;
  /**
   * The adjusted dates associated with an extendible provision. These dates have been adjusted for any applicable business day convention.
   */
  extendibleProvisionAdjustedDates?: ExtendibleProvisionAdjustedDates;
  callingParty?: CallingPartyEnum;
  /**
   * If the ability to extend the contract is not available to both parties then this component specifies the buyer and seller of the option.
   */
  singlePartyOption?: PartyRole;
  /**
   * Defines the minimum period before a contract is scheduled to terminate that notice can be given that it will terminate beyond the scheduled termination date.
   */
  noticeDeadlinePeriod?: RelativeDateOffset;
  /**
   * A specific date and time for the notice deadline
   */
  noticeDeadlineDateTime?: Date;
  /**
   * The length of each extension period relative to the effective date of the preceding contract.
   */
  extensionTerm?: RelativeDateOffset;
  /**
   * The period within which notice can be given that the contract will be extended.
   */
  extensionPeriod?: AdjustableRelativeOrPeriodicDates;
  /**
   * The exercise terms associated with the extendible provision, including details such as exercise style, exercise fees, and any other relevant conditions or terms governing the extension of the swap transaction.
   */
  exerciseTerms?: ExerciseTerms;
}
  
/**
 * A data defining:  the adjusted dates associated with a provision to extend a swap.
 */
export interface ExtendibleProvisionAdjustedDates {
  /**
   * The adjusted dates associated with a single extendible exercise date.
   */
  extensionEvent?: ExtensionEvent[];
}
  
/**
 * A data to:  define the adjusted dates associated with an individual extension event.
 */
export interface ExtensionEvent {
  /**
   * The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
   */
  adjustedExerciseDate?: Date;
  /**
   * The termination date if an extendible provision is exercised. This date should already be adjusted for any applicable business day convention.
   */
  adjustedExtendedTerminationDate?: Date;
  meta?: MetaFields;
}
  
/**
 * Where the underlying is shares, defines market events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
 */
export interface ExtraordinaryEvents {
  /**
   * Where parties may optionnaly describe any extra bespoke agreements, in regards of the standardized Extraordinary Events.
   */
  additionalBespokeTerms?: Clause[];
  /**
   * Per the 2018 ISDA CDM Equity Confirmation for Security Equity Swap
   */
  mergerEvents?: EquityCorporateEvents;
  /**
   * Per the 2002 ISDA Equity Derivatives Definitions: 
   */
  tenderOfferEvents?: EquityCorporateEvents;
  /**
   * Per the 2002 ISDA Equity Derivatives Definitions: 
   */
  compositionOfCombinedConsideration?: boolean;
  /**
   * Per the 2002 ISDA Equity Derivatives Definitions: Adjustments to Indices 
   */
  indexAdjustmentEvents?: IndexAdjustmentEvents;
  /**
   * Per the 2002 ISDA Equity Derivatives Definitions | 2018 ISDA CDM Equity Confirmation for Security Equity Swaps
   */
  additionalDisruptionEvents?: AdditionalDisruptionEvents;
  /**
   * If true, failure to deliver is applicable.
   */
  failureToDeliver?: boolean;
  representations?: Representations;
  /**
   * Per the 2002 ISDA Equity Derivatives Definitions | 2018 ISDA CDM Equity Confirmation for Security Equity Swap
   */
  nationalizationOrInsolvency?: NationalizationOrInsolvencyOrDelistingEventEnum;
  /**
   * Per the 2002 ISDA Equity Derivatives Definitions | 2018 ISDA CDM Equity Confirmation for Security Equity Swap:
   */
  delisting?: NationalizationOrInsolvencyOrDelistingEventEnum;
}
  
export interface FailureToPay {
  /**
   * Indicates whether the failure to pay provision is applicable.
   */
  applicable?: boolean;
  /**
   * If this element is specified, indicates whether or not a grace period extension is applicable. ISDA 2003 Term: Grace Period Extension Applicable.
   */
  gracePeriodExtension?: GracePeriodExtension;
  /**
   * Specifies a threshold for the failure to pay credit event. Market standard is USD 1,000,000 (JPY 100,000,000 for Japanese Yen trades) or its equivalent in the relevant obligation currency. This is applied on an aggregate basis across all Obligations of the Reference Entity. Intended to prevent technical/operational errors from triggering credit events. ISDA 2003 Term: Payment Requirement
   */
  paymentRequirement?: Money;
}
  
/**
 * Defines the structure needed to represent fallback rate parameters. This type is used to represent modular computed rates in interestRatePayouts.
 */
export interface FallbackRateParameters {
  /**
   * The floating rate index that is used as the basis of the fallback rate.
   */
  floatingRateIndex?: FloatingRateIndexEnum;
  /**
   * The date the fallback rate takes effect.
   */
  effectiveDate?: Date;
  /**
   * Support for modular calculated rates, such such as lockout compound calculations.
   */
  calculationParameters?: FloatingRateCalculationParameters;
  /**
   * The economic spread applied to the underlying fallback rate to replicate the original risky rate.
   */
  spreadAdjustment?: number;
}
  
/**
 * The method, prioritised by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
 */
export interface FallbackReferencePrice {
  /**
   * Specifies how long to wait to get a quote from a settlement rate option upon a price source disruption.
   */
  valuationPostponement?: ValuationPostponement;
  /**
   * This settlement rate option will be used in its place.
   */
  fallBackSettlementRateOption?: FieldWithMeta<SettlementRateOptionEnum>[];
  /**
   * Request rate quotes from the market. This element is set as type Empty in FpML. When present, the FpML synonym is mapped to a value True in the CDM.
   */
  fallbackSurveyValuationPostponement?: boolean;
  /**
   * The calculation agent will decide the rate.
   */
  calculationAgentDetermination?: CalculationAgent;
}
  
/**
 * Payment made following trigger occurrence.
 */
export interface FeaturePayment {
  /**
   * This attribute doesn't exist as part of the FpML construct, which makes use of the PayerReceiver.model group.
   */
  payerReceiver?: PartyReferencePayerReceiver;
  /**
   * The trigger level percentage.
   */
  levelPercentage?: number;
  /**
   * The monetary quantity in currency units.
   */
  amount?: number;
  /**
   * The feature payment time.
   */
  time?: TimeTypeEnum;
  /**
   * The currency in which an amount is denominated.
   */
  currency?: FieldWithMeta<String>;
  /**
   * The feature payment date.
   */
  paymentDate?: AdjustableOrRelativeDate;
  meta?: MetaFields;
}
  
export interface FinInstrm {
  othr?: Othr;
}
  
export interface FinInstrmGnlAttrbts {
  fullNm?: string;
  clssfctnTp?: string;
  ntnlCcy?: string;
}
  
export interface FinInstrmRptgTxRpt {
  tx?: Tx;
}
  
/**
 * A data to:  define business date convention adjustment to final payment period per leg.
 */
export interface FinalCalculationPeriodDateAdjustment {
  /**
   * Reference to the unadjusted cancellation effective dates.
   */
  relevantUnderlyingDateReference?: ReferenceWithMeta<AdjustableOrRelativeDates>;
  /**
   * Reference to the leg, where date adjustments may apply.
   */
  swapStreamReference?: ReferenceWithMeta<InterestRatePayout>;
  /**
   * Override business date convention. This takes precedence over leg level information.
   */
  businessDayConvention?: BusinessDayConventionEnum;
}
  
/**
 * Type for reporting the detailed results of calculating a cash flow for a calculation period.  This is enhanced relative to the FpML-based cashflows structure to allow more information to be returned about daily compounded rates.
 */
export interface FixedAmountCalculationDetails {
  /**
   * The calculation period for which the floating calculation was performed.
   */
  calculationPeriod?: CalculationPeriodBase;
  /**
   * The notional in effect during the calculation period.
   */
  calculationPeriodNotionalAmount?: Money;
  /**
   * The value of the fixed rate that was used.
   */
  fixedRate?: number;
  /**
   * The fraction of a year that this calculation represents, according to the day count fraction method.
   */
  yearFraction?: number;
  /**
   * The amount of the cash flow that was computed, including any spreads and other processing.
   */
  calculatedAmount?: number;
}
  
/**
 * A predefined price accorded by the counterparties.
 */
export interface FixedPrice {
  /**
   * Fixed price step schedule, including an initial price specified as an absolute number.
   */
  price?: ReferenceWithMeta<PriceSchedule>;
}
  
/**
 * Represents a fixed price payout. There is no underlier associated with this payout type and is based on fixed pricing per a given unit (e.g. in commodities price per barrel)
 */
export interface FixedPricePayout extends PayoutBase {
  /**
   * Canonical representation of the payer and receiver parties applicable to each payout leg.
   */
  payerReceiver?: PayerReceiver;
  /**
   * Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
   */
  priceQuantity?: ResolvablePriceQuantity;
  /**
   * The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
   */
  principalPayment?: PrincipalPayments;
  /**
   * Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
   */
  settlementTerms?: SettlementTerms;
  /**
   * Specifies the parameters to generate the payment date schedule, either through a parametric representation or by reference to specified dates.
   */
  paymentDates?: PaymentDates;
  /**
   * Specifies the fixed price on which fixed forward payments are based.
   */
  fixedPrice?: FixedPrice;
  /**
   * Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
   */
  schedule?: CalculationSchedule;
}
  
/**
 * Type defining the specification for a fixed rate.
 */
export interface FixedRateSpecification {
  /**
   * The fixed rate or fixed rate schedule expressed as explicit fixed rates and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
   */
  rateSchedule?: RateSchedule;
  meta?: MetaFields;
}
  
/**
 * Type for reporting the detailed results of calculating a cash flow for a calculation period.  This is enhanced relative to the FpML-based cashflows structure to allow more information to be returned about daily compounded rates.
 */
export interface FloatingAmountCalculationDetails {
  /**
   * The calculation period for which the floating calculation was performed.
   */
  calculationPeriod?: CalculationPeriodBase;
  /**
   * The notional in effect during the calculation period.
   */
  calculationPeriodNotionalAmount?: Money;
  /**
   * The details of the floating rate setting.  (If it is a calculated rate, details of that calculation will be inside that.
   */
  floatingRate?: FloatingRateSettingDetails;
  /**
   * Details fo the floating rate treatment after the rate is observed or calculated.  This will include details of things like multipliers, spreads, caps and floors, and the raw and treated rates.
   */
  processingDetails?: FloatingRateProcessingDetails;
  /**
   * The rate that was actually applied, after all calculations and treatments.
   */
  appliedRate?: number;
  /**
   * The fraction of a year that this calculation represents, according to the day count fraction method.
   */
  yearFraction?: number;
  /**
   * The amount of the cash flow that was computed, including any spreads and other processing.
   */
  calculatedAmount?: number;
  /**
   * The amount of the cash flow excluding any spread, for subsequent processing.
   */
  spreadExclusiveCalculatedAMount?: number;
}
  
/**
 * A class to specify the ISDA terms relating to the floating rate payment events and the implied additional fixed payments, applicable to the credit derivatives transactions on mortgage-backed securities with pay-as-you-go or physical settlement.
 */
export interface FloatingAmountEvents {
  /**
   * A floating rate payment event. Corresponds to the failure by the Reference Entity to pay an expected principal amount or the payment of an actual principal amount that is less than the expected principal amount. ISDA 2003 Term: Failure to Pay Principal.
   */
  failureToPayPrincipal?: boolean;
  /**
   * A floating rate payment event. With respect to any Reference Obligation Payment Date, either (a) the non-payment of an Expected Interest Amount or (b) the payment of an Actual Interest Amount that is less than the Expected Interest Amount. ISDA 2003 Term: Interest Shortfall.
   */
  interestShortfall?: InterestShortFall;
  /**
   * A floating rate payment event. Results from the fact that the underlier writes down its outstanding principal amount. ISDA 2003 Term: Writedown.
   */
  writedown?: boolean;
  /**
   * A floating rate payment event. Results from the fact that losses occur to the underlying instruments that do not result in reductions of the outstanding principal of the reference obligation.
   */
  impliedWritedown?: boolean;
  /**
   * Specifies the floating amount provisions associated with the floatingAmountEvents.
   */
  floatingAmountProvisions?: FloatingAmountProvisions;
  /**
   * Specifies the events that will give rise to the payment additional fixed payments.
   */
  additionalFixedPayments?: AdditionalFixedPayments;
}
  
export interface FloatingAmountProvisions {
  /**
   * As specified by the ISDA Supplement for use with trades on mortgage-backed securities, 'WAC Cap' means a weighted average coupon or weighted average rate cap provision (however defined in the Underlying Instruments) of the Underlying Instruments that limits, increases or decreases the interest rate or interest entitlement, as set out in the Underlying Instruments on the Effective Date without regard to any subsequent amendment The presence of the element with value set to 'true' signifies that the provision is applicable. From a usage standpoint, this provision is typically applicable in the case of CMBS and not applicable in case of RMBS trades.
   */
  wacCapInterestProvision?: boolean;
  /**
   * As specified by the ISDA Standard Terms Supplement for use with trades on mortgage-backed securities. The presence of the element with value set to 'true' signifies that the provision is applicable. If applicable, the applicable step-up terms are specified as part of that ISDA Standard Terms Supplement. From a usage standpoint, this provision is typically applicable in the case of RMBS and not applicable in case of CMBS trades.
   */
  stepUpProvision?: boolean;
}
  
export interface FloatingRate extends FloatingRateBase {
  rateOption?: ReferenceWithMeta<InterestRateIndex>;
  /**
   * The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
   */
  spreadSchedule?: SpreadSchedule;
  /**
   * The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
   */
  capRateSchedule?: StrikeSchedule;
  /**
   * The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
   */
  floorRateSchedule?: StrikeSchedule;
  meta?: MetaFields;
  /**
   * A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
   */
  floatingRateMultiplierSchedule?: RateSchedule;
  /**
   * The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
   */
  rateTreatment?: RateTreatmentEnum;
  /**
   * Support for modular calculated rates, such such as lockout compound calculations.
   */
  calculationParameters?: FloatingRateCalculationParameters;
  /**
   * Definition of any fallback rate that may be applicable.
   */
  fallbackRate?: FallbackRateParameters;
}
  
/**
 * A class defining a floating interest rate through the specification of the floating rate index, the tenor, the multiplier schedule, the spread, the qualification of whether a specific rate treatment and/or a cap or floor apply.
 */
export interface FloatingRateBase {
  rateOption?: ReferenceWithMeta<InterestRateIndex>;
  /**
   * The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
   */
  spreadSchedule?: SpreadSchedule;
  /**
   * The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
   */
  capRateSchedule?: StrikeSchedule;
  /**
   * The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
   */
  floorRateSchedule?: StrikeSchedule;
  meta?: MetaFields;
}
  
/**
 * Defines the structures needed to represent the calculation parameters for daily averaged and compounded modular rates as defined in the 2021 ISDA Definitions in Section 7. This type is used to represent modular computed rates in interestRatePayouts.
 */
export interface FloatingRateCalculationParameters {
  /**
   * calculation type (averaging or compounding).
   */
  calculationMethod?: CalculationMethodEnum;
  /**
   * any obervation shift parameters if applicable.
   */
  observationShiftCalculation?: ObservationShiftCalculation;
  /**
   * any lookback  parameters if applicable.
   */
  lookbackCalculation?: OffsetCalculation;
  /**
   * any lockout  parameters if applicable.
   */
  lockoutCalculation?: OffsetCalculation;
  /**
   * the business days that are applicable for the calculation.
   */
  applicableBusinessDays?: BusinessCenters;
  /**
   *  any applicable observation parameters, such as daily caps or floors.
   */
  observationParameters?: ObservationParameters;
}
  
/**
 * A data defining:  parameters associated with a floating rate reset. This data forms:  part of the cashflows representation of a stream.
 */
export interface FloatingRateDefinition {
  /**
   * The final calculated rate for a calculation period after any required averaging of rates A calculated rate of 5% would be represented as 0.05.
   */
  calculatedRate?: number;
  /**
   * The details of a particular rate observation, including the fixing date and observed rate. A list of rate observation elements may be ordered in the document by ascending adjusted fixing date. An FpML document containing an unordered list of rate observations is still regarded as a conformant document.
   */
  rateObservation?: RateObservation[];
  /**
   * A rate multiplier to apply to the floating rate. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one).
   */
  floatingRateMultiplier?: number;
  /**
   * The ISDA Spread, if any, which applies for the calculation period. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
   */
  spread?: number;
  /**
   * The cap rate, if any, which applies to the floating rate for the calculation period. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain strike level. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
   */
  capRate?: Strike[];
  /**
   * The floor rate, if any, which applies to the floating rate for the calculation period. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. The floor rate of 5% would be represented as 0.05.
   */
  floorRate?: Strike[];
}
  
/**
 * Specification of an interest rate index which can change over time, e.g. the SONIA (Sterling Overnight Index Average) in the UK.
 */
export interface FloatingRateIndex extends IndexBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
  /**
   * A description of the Index.
   */
  name?: FieldWithMeta<String>;
  /**
   * The organisation that creates or maintains the Index.
   */
  provider?: LegalEntity;
  /**
   * The Asset Class of the Index.
   */
  assetClass?: AssetClassEnum;
  /**
   * The reference index that is used to specify the floating interest rate.
   */
  floatingRateIndex?: FieldWithMeta<FloatingRateIndexEnum>;
  /**
   * The ISDA Designated Maturity, i.e. the floating rate tenor.
   */
  indexTenor?: Period;
}
  
/**
 * This holds the rate calculation defaults applicable for a floating rate index.
 */
export interface FloatingRateIndexCalculationDefaults {
  /**
   * The ISDA FRO category (e.g. screen rate or calculated rate).
   */
  category?: FloatingRateIndexCategoryEnum;
  /**
   * The ISDA FRO style (e.g. term rate, swap rate, etc).
   */
  indexStyle?: FloatingRateIndexStyleEnum;
  /**
   * The ISDA FRO calculation method (e.g. OIS Compounding).
   */
  method?: FloatingRateIndexCalculationMethodEnum;
}
  
export interface FloatingRateIndexDefinition {
  /**
   * The underlying FRO name and designated maturity.
   */
  fro?: FloatingRateIndexIdentification;
  /**
   * Any calculation default values.
   */
  calculationDefaults?: FloatingRateIndexCalculationDefaults;
}
  
export interface FloatingRateIndexIdentification {
  /**
   * The reference index that is used to specify the floating interest rate. The FpML standard maintains the list of such indices, which are positioned as enumeration values as part of the CDM.
   */
  floatingRateIndex?: FieldWithMeta<FloatingRateIndexEnum>;
  /**
   * FRO currency - 3 character ISO currrency code
   */
  currency?: ISOCurrencyCodeEnum;
  /**
   * FRO type (e.g. OIS)
   */
  froType?: string;
}
  
/**
 * Type for reporting the details of the rate treatment.  This could potentially be replaced by the existing FloatingRateDefinition type , but this is slightly more detailed.
 */
export interface FloatingRateProcessingDetails {
  /**
   * The raw or untreated rate, prior to any of the rate treatments.
   */
  rawRate?: number;
  processingParameters?: FloatingRateProcessingParameters;
  /**
   * The value of the rate after processing.
   */
  processedRate?: number;
  /**
   * The value of the processed rate without the spread applied, for subsequent compounding, etc.
   */
  spreadExclusiveRate?: number;
}
  
/**
 * Type to hold the processing parameters that should be or were used to calculate a floating amount.  These parameters can vary over a schedule so this type holds the acutal values applicable to this calculation.
 */
export interface FloatingRateProcessingParameters {
  /**
   * The rate to be applied for the initial period.
   */
  initialRate?: Price;
  /**
   * floating rate multiplier.
   */
  multiplier?: number;
  /**
   * spread to be added to the floating rate.
   */
  spread?: number;
  /**
   * US rate treatment (Bond Equivalent Yield or Money Market Yield, if applicable.
   */
  treatment?: RateTreatmentEnum;
  /**
   * capt to be applied to the floating rate.
   */
  capRate?: number;
  /**
   * floor to be applied to the floating rate.
   */
  floorRate?: number;
  /**
   * THe final rate rounding to be applied.
   */
  rounding?: Rounding;
  /**
   * How to handle negative interest rates.
   */
  negativeTreatment?: NegativeInterestRateTreatmentEnum;
}
  
/**
 * Type for reporting the raw (untreated) observed or calculated rate for a calculation period.  If this is a calculated rate, it allows details of the observations and the resulting rate to be returned.
 */
export interface FloatingRateSettingDetails {
  /**
   * Calculated rate details (observation dates, values, and weights).
   */
  calculationDetails?: CalculatedRateDetails;
  /**
   * The day upon which the rate was observed (for term rates).
   */
  observationDate?: Date;
  /**
   * The day for which the rate is needed (e.g. period beginning or end date).
   */
  resetDate?: Date;
  /**
   * The resulting rate that was observed or calculated.
   */
  floatingRate?: number;
}
  
/**
 * A class to specify the floating interest rate by extending the floating rate definition with a set of attributes that specify such rate: the initial value specified as part of the trade, the rounding convention, the averaging method and the negative interest rate treatment.
 */
export interface FloatingRateSpecification extends FloatingRate {
  rateOption?: ReferenceWithMeta<InterestRateIndex>;
  /**
   * The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
   */
  spreadSchedule?: SpreadSchedule;
  /**
   * The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
   */
  capRateSchedule?: StrikeSchedule;
  /**
   * The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
   */
  floorRateSchedule?: StrikeSchedule;
  meta?: MetaFields;
  /**
   * A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
   */
  floatingRateMultiplierSchedule?: RateSchedule;
  /**
   * The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
   */
  rateTreatment?: RateTreatmentEnum;
  /**
   * Support for modular calculated rates, such such as lockout compound calculations.
   */
  calculationParameters?: FloatingRateCalculationParameters;
  /**
   * Definition of any fallback rate that may be applicable.
   */
  fallbackRate?: FallbackRateParameters;
  /**
   * The initial floating rate reset agreed between the principal parties involved in the trade. This is assumed to be the first required reset rate for the first regular calculation period. It should only be included when the rate is not equal to the rate published on the source implied by the floating rate index. An initial rate of 5% would be represented as 0.05.
   */
  initialRate?: Price;
  /**
   * The rounding convention to apply to the final rate used in determination of a calculation period amount.
   */
  finalRateRounding?: Rounding;
  /**
   * If averaging is applicable, this component specifies whether a weighted or unweighted average method of calculation is to be used. The component must only be included when averaging applies.
   */
  averagingMethod?: AveragingWeightingMethodEnum;
  /**
   * The specification of any provisions for calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
   */
  negativeInterestRateTreatment?: NegativeInterestRateTreatmentEnum;
}
  
/**
 * From FpML: A type defining either a spot or forward FX transactions.
 */
export interface ForeignExchange {
  /**
   * This is the first of the two currency flows that define a single leg of a standard foreign exchange transaction.
   */
  exchangedCurrency1?: Cashflow;
  /**
   * This is the second of the two currency flows that define a single leg of a standard foreign exchange transaction.
   */
  exchangedCurrency2?: Cashflow;
  /**
   * A tenor expressed as a period type and multiplier (e.g. 1D, 1Y, etc.)
   */
  tenorPeriod?: Period;
}
  
/**
 * Specification of a rate based on the exchange of a pair of cash assets in specific currencies, e.g. USD versus GBP.
 */
export interface ForeignExchangeRateIndex extends IndexBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
  /**
   * A description of the Index.
   */
  name?: FieldWithMeta<String>;
  /**
   * The organisation that creates or maintains the Index.
   */
  provider?: LegalEntity;
  /**
   * The Asset Class of the Index.
   */
  assetClass?: AssetClassEnum;
  /**
   * Describes the composition of a rate that has been quoted or is to be quoted.
   */
  quotedCurrencyPair?: FieldWithMeta<QuotedCurrencyPair>;
  /**
   * Specifies the primary source from which a rate should be observed.
   */
  primaryFxSpotRateSource?: InformationSource;
  /**
   * Specifies an alternative, or secondary, source from which a rate should be observed.
   */
  secondaryFxSpotRateSource?: InformationSource;
}
  
/**
 * A class for defining a date frequency, e.g. one day, three months, through the combination of an integer value and a standardized period value that is specified as part of an enumeration.
 */
export interface Frequency {
  /**
   * A time period multiplier, e.g. 1, 2, or 3. If the period value is T (Term) then period multiplier must contain the value 1.
   */
  periodMultiplier?: number;
  /**
   * A time period, e.g. a day, week, month, year or term of the stream.
   */
  period?: PeriodExtendedEnum;
  meta?: MetaFields;
}
  
/**
 * A class defining a currency and a future value date.
 */
export interface FutureValueAmount {
  quantity?: ReferenceWithMeta<NonNegativeQuantitySchedule>;
  /**
   * The currency in which the an amount is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
   */
  currency?: FieldWithMeta<String>;
  /**
   * The number of days from the adjusted calculation period start date to the adjusted value date, calculated in accordance with the applicable day count fraction.
   */
  calculationPeriodNumberOfDays?: number;
  /**
   * Adjusted value date of the future value amount.
   */
  valueDate?: Date;
}
  
/**
 * TransactionAdditionalTerms which apply to the CurrencyPair asset class.
 */
export interface FxAdditionalTerms {
}
  
/**
 * A type for defining FX Features.
 */
export interface FxFeature {
  /**
   * Specifies the reference currency of the trade.
   */
  referenceCurrency?: FieldWithMeta<String>;
  /**
   * If 'Composite' is specified as the Settlement Type in the relevant Transaction Supplement, an amount in the Settlement Currency, determined by the Calculation Agent as being equal to the number of Options exercised or deemed exercised, multiplied by: (Settlement Price – Strike Price) / (Strike Price – Settlement Price) x Multiplier provided that if the above is equal to a negative amount the Option Cash Settlement Amount shall be deemed to be zero.
   */
  composite?: Composite;
  /**
   * If 'Quanto' is specified as the Settlement Type in the relevant Transaction Supplement, an amount, as determined by the Calculation Agent in accordance with the Section 8.2 of the Equity Definitions.
   */
  quanto?: Quanto;
  /**
   * If 'Cross-Currency' is specified as the Settlement Type in the relevant Transaction Supplement, an amount in the Settlement Currency, determined by the Calculation Agent as being equal to the number of Options exercised or deemed exercised, multiplied by: (Settlement Price – Strike Price) / (Strike Price – Settlement Price) x Multiplier x one unit of the Reference Currency converted into an amount in the Settlement Currency using the rate of exchange of the Settlement Currency as quoted on the Reference Price Source on the Valuation Date, provided that if the above is equal to a negative amount the Option Cash Settlement Amount shall be deemed to be zero.
   */
  crossCurrency?: Composite;
}
  
/**
 * Extends the Offset structure to specify an FX fixing date as an offset to dates specified somewhere else in the document.
 */
export interface FxFixingDate extends Offset {
  /**
   * A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
   */
  periodMultiplier?: number;
  /**
   * A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
   */
  period?: PeriodEnum;
  meta?: MetaFields;
  /**
   * In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
   */
  dayType?: DayTypeEnum;
  /**
   * The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
   */
  businessDayConvention?: BusinessDayConventionEnum;
  businessCenters?: BusinessCenters;
  /**
   * A reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
   */
  businessCentersReference?: ReferenceWithMeta<BusinessCenters>;
  /**
   * The payment date references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure.
   */
  dateRelativeToPaymentDates?: DateRelativeToPaymentDates;
  /**
   * The calculation period references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure. Implemented for Brazilian-CDI swaps where it will refer to the termination date of the appropriate leg.
   */
  dateRelativeToCalculationPeriodDates?: DateRelativeToCalculationPeriodDates;
  /**
   * The calculation period references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure. Implemented for Brazilian-CDI swaps where it will refer to the termination date of the appropriate leg.
   */
  dateRelativeToValuationDates?: DateRelativeToValuationDates;
  /**
   * Describes the specific date when a non-deliverable forward or cash-settled option will 'fix' against a particular rate, which will be used to compute the ultimate cash settlement. This element should be omitted where a single, discrete fixing date cannot be identified e.g. on an american option, where fixing may occur at any date on a continuous range.  This attribute was formerly part of 'fxSettlementTerms', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
   */
  fxFixingDate?: AdjustableOrRelativeDate;
}
  
/**
 * Information source specific to Foreign Exchange products.
 */
export interface FxInformationSource extends InformationSource {
  /**
   * An information source for obtaining a market data point. For example Bloomberg, Reuters, Telerate, etc.
   */
  sourceProvider?: FieldWithMeta<InformationProviderEnum>;
  /**
   * A specific page for the source for obtaining a market data point. In FpML, this is specified as a scheme, rateSourcePageScheme, for which no coding Scheme or URI is specified.
   */
  sourcePage?: FieldWithMeta<String>;
  /**
   * The heading for the source on a given source page.
   */
  sourcePageHeading?: string;
  /**
   * The time that the fixing will be taken along with a business center to define the time zone.
   */
  fixingTime?: BusinessCenterTime;
}
  
/**
 * A data to:  describe the cashflow representation for FX linked notionals.
 */
export interface FxLinkedNotionalAmount {
  /**
   * The reset date.
   */
  resetDate?: Date;
  /**
   * The date on which the FX spot rate is observed. This date should already be adjusted for any applicable business day convention.
   */
  adjustedFxSpotFixingDate?: Date;
  /**
   * The actual observed FX spot rate.
   */
  observedFxSpotRate?: number;
  /**
   * The calculation period notional amount.
   */
  notionalAmount?: number;
}
  
/**
 * A data to:  describe a notional schedule where each notional that applies to a calculation period is calculated with reference to a notional amount or notional amount schedule in a different currency by means of a spot currency exchange rate which is normally observed at the beginning of each period.
 */
export interface FxLinkedNotionalSchedule {
  /**
   * The currency of the varying notional amount, i.e. the notional amount being determined periodically based on observation of a spot currency exchange rate. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
   */
  varyingNotionalCurrency?: FieldWithMeta<String>;
  /**
   * The dates on which spot currency exchange rates are observed for purposes of determining the varying notional currency amount that will apply to a calculation period.
   */
  varyingNotionalFixingDates?: RelativeDateOffset;
  /**
   * The information source and time at which the spot currency exchange rate will be observed.
   */
  fxSpotRateSource?: FxSpotRateSource;
  /**
   * The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
   */
  fixingTime?: BusinessCenterTime;
  /**
   * The dates on which interim exchanges of notional are paid. Interim exchanges will arise as a result of changes in the spot currency exchange amount or changes in the constant notional schedule (e.g. amortisation).
   */
  varyingNotionalInterimExchangePaymentDates?: RelativeDateOffset;
}
  
/**
 * A class describing the rate of a currency conversion: pair of currency, quotation mode and exchange rate.
 */
export interface FxRate {
  /**
   * Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
   */
  quotedCurrencyPair?: QuotedCurrencyPair;
  /**
   * The rate of exchange between the two currencies of the leg of a deal. Must be specified with a quote basis.
   */
  rate?: number;
}
  
/**
 * Describes a rate source to be fixed and the date the fixing occurs
 */
export interface FxRateSourceFixing {
  settlementRateSource?: FxSettlementRateSource;
  /**
   * The date on which the fixing is scheduled to occur.
   */
  fixingDate?: AdjustableDate;
}
  
/**
 * The source of the Foreign Exchange settlement rate.
 */
export interface FxSettlementRateSource {
  /**
   * Indicates that an officially defined rate settlement rate option will be the used for the fixing.
   */
  settlementRateOption?: FieldWithMeta<String>;
  /**
   * Indicates that a non-standard rate source will be used for the fixing.
   */
  nonstandardSettlementRate?: FxInformationSource;
}
  
/**
 * A class defining the rate source and fixing time for an FX rate.
 */
export interface FxSpotRateSource {
  /**
   * The primary source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
   */
  primarySource?: InformationSource;
  /**
   * An alternative, or secondary, source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
   */
  secondarySource?: InformationSource;
}
  
/**
 *  A class specifying a set of non-monetary terms for the Credit Derivative Transaction, including the buyer and seller and selected items from the ISDA 2014 Credit Definition article II, such as the reference obligation and related terms. The CDM GeneralTerms class corresponds to the FpML GeneralTerms complex type, except that the effectiveDate and scheduledTerminationDate have been positioned as part of the InterestRatePayout class in the CDM instead of in GeneralTerms.
 */
export interface GeneralTerms {
  /**
   * This attribute contains all the terms relevant to defining the reference entity and reference obligation(s).
   */
  referenceInformation?: ReferenceInformation;
  /**
   * This attribute contains all the terms relevant to the underlying Index.
   */
  indexReferenceInformation?: CreditIndex;
  /**
   * This attribute contains all the terms relevant to defining the Credit Default Swap Basket.
   */
  basketReferenceInformation?: BasketReferenceInformation;
  /**
   * This attribute is used for representing information contained in the Additional Terms field of the 2003 Master Credit Derivatives confirm.
   */
  additionalTerm?: FieldWithMeta<String>[];
  /**
   * Value of this attribute set to 'true' indicates that substitution is applicable.
   */
  substitution?: boolean;
  /**
   * Value of this attribute set to 'true' indicates that modified equity delivery is applicable.
   */
  modifiedEquityDelivery?: boolean;
}
  
export interface GracePeriodExtension {
  /**
   * Indicates whether the grace period extension provision is applicable.
   */
  applicable?: boolean;
  /**
   * The number of calendar or business days after any due date that the reference entity has to fulfil its obligations before a failure to pay credit event is deemed to have occurred. ISDA 2003 Term: Grace Period.
   */
  gracePeriod?: Offset;
}
  
export interface Id {
  lei?: string;
}
  
/**
 * Attaches an identifier to a collection of objects, when those objects themselves can each be represented by an identifier. One use case is the representation of package transactions, where each component is a separate trade with its own identifier, and those trades are linked together as a package with its own identifier. The data type has been named generically rather than referring to 'packages' as it may have a number of other uses.
 */
export interface IdentifiedList {
  /**
   * The identifier for the list. In the case of a package transaction, this would be the package identifier. This attribute is mandatory to allow the list itself to be identified.
   */
  listId?: Identifier;
  /**
   * Identifiers for each component of the list. Since the data type is used to link multiple identified objects together, at least 2 components are required in the list. Creating an identified list with only 1 identified component has been deemed unnecessary, because it would just create a redundant identifier.
   */
  componentId?: Identifier[];
  /**
   * The price of the package.
   */
  price?: Price;
  meta?: MetaFields;
}
  
/**
 * A class to specify a generic identifier, applicable to CDM artefacts such as executions, contracts, lifecycle events and legal documents. An issuer can be associated with the actual identifier value as a way to properly qualify it.
 */
export interface Identifier {
  /**
   * The identifier issuer, when specified by reference to a party specified as part of the transaction.
   */
  issuerReference?: ReferenceWithMeta<Party>;
  /**
   * The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).
   */
  issuer?: FieldWithMeta<String>;
  /**
   * The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.
   */
  assignedIdentifier?: AssignedIdentifier[];
  meta?: MetaFields;
}
  
/**
 * A class specifying the Independent Amount as the combination of a payer/receiver, a payment amount, a payment date and an associated payment calculation rule.
 */
export interface IndependentAmount extends PartyReferencePayerReceiver {
  /**
   * The party responsible for making the payments defined by this structure.
   */
  payerPartyReference?: ReferenceWithMeta<Party>;
  /**
   * A reference to the account responsible for making the payments defined by this structure.
   */
  payerAccountReference?: ReferenceWithMeta<Account>;
  /**
   * The party that receives the payments corresponding to this structure.
   */
  receiverPartyReference?: ReferenceWithMeta<Party>;
  /**
   * A reference to the account that receives the payments corresponding to this structure.
   */
  receiverAccountReference?: ReferenceWithMeta<Account>;
  /**
   * An attribute that specifies a payment as the combination of a payment amount, a payment date and an associated payment calculation rule.
   */
  paymentDetail?: PaymentDetail[];
}
  
/**
 * An Index is an Observable which is computed based on the prices, rates or valuations of a number of assets that are tracked in a standardized way.  Examples include equity market indices as well as indices on interest rates, inflation and credit instruments.
 */
export interface Index {
  /**
   * An index based on credit risk, typically composed using corporate debt instruments in a region or industry sector, e.g. the iTraxx indices.
   */
  creditIndex?: CreditIndex;
  /**
   * An index based on equity securities, e.g. the S&P 500.
   */
  equityIndex?: EquityIndex;
  /**
   * An index based in interest rates or inflation rates in a certain market.
   */
  interestRateIndex?: FieldWithMeta<InterestRateIndex>;
  /**
   * A rate based on the exchange of a pair of cash assets in specific currencies, e.g. USD versus GBP.
   */
  foreignExchangeRateIndex?: ForeignExchangeRateIndex;
  /**
   * An index created by a market participant which doesn't align with the other index types.
   */
  otherIndex?: OtherIndex;
}
  
/**
 * Defines the specification of the consequences of Index Events as defined by the 2002 ISDA Equity Derivatives Definitions.
 */
export interface IndexAdjustmentEvents {
}
  
/**
 * Identifies an index by referencing an identifier.
 */
export interface IndexBase extends AssetBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
  /**
   * A description of the Index.
   */
  name?: FieldWithMeta<String>;
  /**
   * The organisation that creates or maintains the Index.
   */
  provider?: LegalEntity;
  /**
   * The Asset Class of the Index.
   */
  assetClass?: AssetClassEnum;
}
  
/**
 * Defines the information needed to create a Index Transition Business Event.
 */
export interface IndexTransitionInstruction {
  /**
   * Specifies both new floating rate index and spread adjustment for each leg to be updated.  The spread adjustment accounts for the difference between the old floating rate index relative to the new one. This spread amount is added to the existing spread to determine the new spread, which is applied from the specified effective date forward. In the case of the IBOR Fallback Rate Adjustments, the adjustment spread (also known as the Fallback Adjustment) accounts for two distinctions: i) the fact that the replacement Risk-Free Rate is an overnight rate while IBORs have term structures (e.g., 1, 3, 6-month LIBOR); and (ii) the historical spread differential between IBORs and their term equivalent Overnight Risk-Free Rate compounded rates.
   */
  priceQuantity?: PriceQuantity[];
  /**
   * Specifies the effective date of the index transition event. This is first date on which the floating rate calculation will use the new floating rate index and adjusted spread in the floating rate calculation.
   */
  effectiveDate?: Date;
  /**
   * Specifies the cash transfer that can optionally be tied to an index transition event.
   */
  cashTransfer?: Transfer;
}
  
export interface Indx {
  nm?: Nm;
}
  
/**
 * Specification of an index that measures inflation in a specific market, e.g. the US Consumer Price Index.
 */
export interface InflationIndex extends IndexBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
  /**
   * A description of the Index.
   */
  name?: FieldWithMeta<String>;
  /**
   * The organisation that creates or maintains the Index.
   */
  provider?: LegalEntity;
  /**
   * The Asset Class of the Index.
   */
  assetClass?: AssetClassEnum;
  /**
   * The reference index that is used to specify the inflation interest rate.
   */
  inflationRateIndex?: FieldWithMeta<InflationRateIndexEnum>;
  /**
   * The ISDA Designated Maturity, i.e. the floating rate tenor.
   */
  indexTenor?: Period;
}
  
/**
 * A data to:  specify the inflation rate.
 */
export interface InflationRateSpecification extends FloatingRateSpecification {
  rateOption?: ReferenceWithMeta<InterestRateIndex>;
  /**
   * The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
   */
  spreadSchedule?: SpreadSchedule;
  /**
   * The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
   */
  capRateSchedule?: StrikeSchedule;
  /**
   * The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
   */
  floorRateSchedule?: StrikeSchedule;
  meta?: MetaFields;
  /**
   * A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
   */
  floatingRateMultiplierSchedule?: RateSchedule;
  /**
   * The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
   */
  rateTreatment?: RateTreatmentEnum;
  /**
   * Support for modular calculated rates, such such as lockout compound calculations.
   */
  calculationParameters?: FloatingRateCalculationParameters;
  /**
   * Definition of any fallback rate that may be applicable.
   */
  fallbackRate?: FallbackRateParameters;
  /**
   * The initial floating rate reset agreed between the principal parties involved in the trade. This is assumed to be the first required reset rate for the first regular calculation period. It should only be included when the rate is not equal to the rate published on the source implied by the floating rate index. An initial rate of 5% would be represented as 0.05.
   */
  initialRate?: Price;
  /**
   * The rounding convention to apply to the final rate used in determination of a calculation period amount.
   */
  finalRateRounding?: Rounding;
  /**
   * If averaging is applicable, this component specifies whether a weighted or unweighted average method of calculation is to be used. The component must only be included when averaging applies.
   */
  averagingMethod?: AveragingWeightingMethodEnum;
  /**
   * The specification of any provisions for calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
   */
  negativeInterestRateTreatment?: NegativeInterestRateTreatmentEnum;
  /**
   * An off-setting period from the payment date which determines the reference period for which the inflation index is observed.
   */
  inflationLag?: Offset;
  /**
   * The reference source such as Reuters or Bloomberg. FpML specifies indexSource to be of type rateSourcePageScheme, but without specifying actual values.
   */
  indexSource?: FieldWithMeta<String>;
  /**
   * The current main publication source such as relevant web site or a government body. FpML specifies mainPublication to be of type mainPublicationSource, but without specifying actual values.
   */
  mainPublication?: FieldWithMeta<String>;
  /**
   * The method used when calculating the Inflation Index Level from multiple points. The most common is Linear.
   */
  interpolationMethod?: FieldWithMeta<InterpolationMethodEnum>;
  /**
   * Initial known index level for the first calculation period.
   */
  initialIndexLevel?: number;
  /**
   * The applicability of a fallback bond as defined in the 2006 ISDA Inflation Derivatives Definitions, sections 1.3 and 1.8.
   */
  fallbackBondApplicable?: boolean;
  /**
   * Indicates how to use the inflation index to calculate the payment (e.g. Ratio, Return, Spread). Added for Inflation Asset Swap
   */
  calculationMethod?: InflationCalculationMethodEnum;
  /**
   * Indicates the style of how the inflation index calculates the payment (e.g. YearOnYear, ZeroCoupon).
   */
  calculationStyle?: InflationCalculationStyleEnum;
  /**
   * To be specified only for products that embed a redemption payment.
   */
  finalPrincipalExchangeCalculation?: FinalPrincipalExchangeCalculationEnum;
}
  
/**
 * A class defining the source for a piece of information (e.g. a rate fix or an FX fixing). The attribute names have been adjusted from FpML to address the fact that the information is not limited to rates.
 */
export interface InformationSource {
  /**
   * An information source for obtaining a market data point. For example Bloomberg, Reuters, Telerate, etc.
   */
  sourceProvider?: FieldWithMeta<InformationProviderEnum>;
  /**
   * A specific page for the source for obtaining a market data point. In FpML, this is specified as a scheme, rateSourcePageScheme, for which no coding Scheme or URI is specified.
   */
  sourcePage?: FieldWithMeta<String>;
  /**
   * The heading for the source on a given source page.
   */
  sourcePageHeading?: string;
}
  
/**
 * A CDM class which purpose is to specify the initial fixing date either alongside the FpML interest rate specification as an offset of another date, or alongside the credit derivative specification as an unadjusted date.
 */
export interface InitialFixingDate {
  relativeDateOffset?: RelativeDateOffset;
  initialFixingDate?: Date;
}
  
/**
 * Instruction to a function that will be used to perform a business event
 */
export interface Instruction {
  /**
   * Specifies the primitive instructions that will be used to call primitive event functions.
   */
  primitiveInstruction?: PrimitiveInstruction;
  /**
   * Specifies the trade state that will be acted on by the primitive event functions.
   */
  before?: ReferenceWithMeta<TradeState>;
}
  
/**
 * A type of Asset that is issued by one party to one or more others.
 */
export interface Instrument {
  /**
   * A securitized derivative on another asset that is created by an exchange.
   */
  listedDerivative?: ListedDerivative;
  /**
   * An Asset that represents a loan or borrow obligation.
   */
  loan?: Loan;
  /**
   * An Asset that is issued by a party to be held by or transferred to others.
   */
  security?: Security;
}
  
/**
 * Defines the common attributes for all Instrument data types.
 */
export interface InstrumentBase extends AssetBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
  /**
   * Identifies the type of an instrument using an enumerated list.
   */
  instrumentType?: InstrumentTypeEnum;
}
  
/**
 * A class to specify the application of Interest Amount with respect to the Delivery Amount and the Return Amount.
 */
export interface InterestAmountApplication {
  /**
   * The application of Interest Amount with respect the Return Amount.
   */
  returnAmount?: ReturnAmount;
  /**
   * The application of Interest Amount with respect the Delivery Amount.
   */
  deliveryAmount?: DeliveryAmount;
}
  
export interface InterestRateCurve {
  floatingRateIndex?: FieldWithMeta<FloatingRateIndexEnum>;
  tenor?: Period;
}
  
/**
 * An index based in interest rates or inflation rates in a certain market.
 */
export interface InterestRateIndex {
  /**
   * An interest rate index which can change over time, e.g. the SONIA (Sterling Overnight Index Average) in the UK.
   */
  floatingRateIndex?: FloatingRateIndex;
  /**
   * An index that measures inflation in a specific market, e.g. the US Consumer Price Index.
   */
  inflationIndex?: InflationIndex;
}
  
/**
 *  A class to specify all of the terms necessary to define and calculate a cash flow based on a fixed, a floating or an inflation index rate. The interest rate payout can be applied to interest rate swaps and FRA (which both have two associated interest rate payouts), credit default swaps (to represent the fee leg when subject to periodic payments) and equity swaps (to represent the funding leg). The associated globalKey denotes the ability to associate a hash value to the InterestRatePayout instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 */
export interface InterestRatePayout extends PayoutBase {
  /**
   * Canonical representation of the payer and receiver parties applicable to each payout leg.
   */
  payerReceiver?: PayerReceiver;
  /**
   * Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
   */
  priceQuantity?: ResolvablePriceQuantity;
  /**
   * The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
   */
  principalPayment?: PrincipalPayments;
  /**
   * Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
   */
  settlementTerms?: SettlementTerms;
  /**
   * The specification of the rate value(s) applicable to the contract using either a floating rate calculation, a single fixed rate, a fixed rate schedule, or an inflation rate calculation.
   */
  rateSpecification?: RateSpecification;
  /**
   * The day count fraction. The cardinality has been relaxed when compared with the FpML interest rate swap for the purpose of accommodating standardized credit default swaps which DCF is not explicitly stated as part of the economic terms. The data rule InterestRatePayout_dayCountFraction requires that the DCF be stated for interest rate products.
   */
  dayCountFraction?: FieldWithMeta<DayCountFractionEnum>;
  /**
   * The parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods.
   */
  calculationPeriodDates?: CalculationPeriodDates;
  /**
   * The payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the reset dates).
   */
  paymentDates?: PaymentDates;
  /**
   * The payment date, where only one date is specified, as for the FRA product.
   */
  paymentDate?: AdjustableDate;
  /**
   * Applicable to CDS on MBS to specify whether payment delays are applicable to the fixed Amount. RMBS typically have a payment delay of 5 days between the coupon date of the reference obligation and the payment date of the synthetic swap. CMBS do not, on the other hand, with both payment dates being on the 25th of each month.
   */
  paymentDelay?: boolean;
  /**
   * The reset dates schedule, i.e. the dates on which the new observed index value is applied for each period and the interest rate hence begins to accrue.
   */
  resetDates?: ResetDates;
  /**
   * The parameters specifying any discounting conventions that may apply. This element must only be included if discounting applies.
   */
  discountingMethod?: DiscountingMethod;
  /**
   * If one or more calculation period contributes to a single payment amount this element specifies whether compounding is applicable and, if so, what compounding method is to be used. This element must only be included when more than one calculation period contributes to a single payment amount.
   */
  compoundingMethod?: CompoundingMethodEnum;
  /**
   * The cashflow representation of the swap stream.
   */
  cashflowRepresentation?: CashflowRepresentation;
  /**
   * The stub calculation period amount parameters. This element must only be included if there is an initial or final stub calculation period. Even then, it must only be included if either the stub references a different floating rate tenor to the regular calculation periods, or if the stub is calculated as a linear interpolation of two different floating rate tenors, or if a specific stub rate or stub amount has been negotiated.
   */
  stubPeriod?: StubPeriod;
  /**
   * Reference to a bond underlier to represent an asset swap or Condition Precedent Bond.
   */
  bondReference?: BondReference;
  /**
   * Fixed Amount Calculation
   */
  fixedAmount?: string;
  /**
   * Floating Amount Calculation
   */
  floatingAmount?: string;
  /**
   * Method by which spread is calculated. For example on an asset swap: 'ParPar' or 'Proceeds' may be the method indicated.
   */
  spreadCalculationMethod?: SpreadCalculationMethodEnum;
}
  
/**
 * A class to specify the interest shortfall floating rate payment event.
 */
export interface InterestShortFall {
  /**
   * Specifies the nature of the interest Shortfall cap (i.e. Fixed Cap or Variable Cap) in the case where it is applicable. ISDA 2003 Term: Interest Shortfall Cap.
   */
  interestShortfallCap?: InterestShortfallCapEnum;
  compounding?: boolean;
  /**
   * The rate source in the case of a variable cap.
   */
  rateSource?: FieldWithMeta<FloatingRateIndexEnum>;
}
  
/**
 * A data type that can be used to describe an inventory of securities.
 */
export interface Inventory {
  /**
   * An array holding the list of inventory being described. Each element in the inventoryRecord array represents an individual piece of inventory i.e. a security.
   */
  inventoryRecord?: InventoryRecord[];
}
  
/**
 * An individual piece of inventory. This represents a single security.
 */
export interface InventoryRecord {
  /**
   * Unique identifier for this record. This can be used to uniquely identify a specific piece of inventory.
   */
  identifer?: AssignedIdentifier;
  /**
   * The security details.
   */
  security?: Security;
}
  
export interface InvstmtDcsnPrsn {
  prsn?: Prsn;
}
  
export interface IssuerAgencyRating {
  /**
   * Represents an agency rating based on default risk and creditors claim in event of default associated with asset issuer.
   */
  issuerAgencyRating?: AgencyRatingCriteria;
}
  
export interface IssuerCountryOfOrigin {
  /**
   * Represents a filter on the issuing entity country of origin based on the ISO Standard 3166, which is the same as filtering by eligible Sovereigns.
   */
  issuerCountryOfOrigin?: ISOCountryCodeEnum;
}
  
export interface IssuerName {
  /**
   * Specifies the issuing entity name or LEI.
   */
  issuerName?: LegalEntity;
}
  
/**
 * Knock In means option to exercise comes into existence. Knock Out means option to exercise goes out of existence.
 */
export interface Knock {
  /**
   * The knock in.
   */
  knockIn?: TriggerEvent;
  /**
   * The knock out.
   */
  knockOut?: TriggerEvent;
}
  
/**
 * The pricing period per calculation period if the pricing days do not wholly fall within the respective calculation period.
 */
export interface Lag {
  /**
   * Defines the offset of the series of pricing dates relative to the calculation period.
   */
  lagDuration?: Offset;
  /**
   * Defines the offset of the series of pricing dates relative to the calculation period.
   */
  firstObservationDateOffset?: Offset;
}
  
/**
 * The specification of a legal agreement between two parties, being negotiated or having been executed. This includes the baseline information and the optional specialised elections
 */
export interface LegalAgreement extends LegalAgreementBase {
  /**
   * The date on which the legal agreement has been agreed between the parties. This corresponds to the Date of Deed in an English Law document.
   */
  agreementDate?: Date;
  /**
   * The date on which, or as of which, the agreement is effective, if different from the agreement date. It is expected that it will most often correspond to the agreement date, although there could be situations where the parties will explicitly agree on a distinct effective date.
   */
  effectiveDate?: Date;
  /**
   * The legal agreement identifier. Several identifiers can be specified.
   */
  identifier?: Identifier[];
  /**
   * The type of legal agreement, identified via a set of composable attributes: agreementName, publisher, governing law and version, e.g. ISDA 2013 Standard Credit Support Annex English Law.
   */
  legalAgreementIdentification?: LegalAgreementIdentification;
  /**
   * The two contractual parties to the legal agreement, which reference information is positioned as part of the partyInformation attribute.
   */
  contractualParty?: ReferenceWithMeta<Party>[];
  /**
   * The role(s) that other party(ies) may have in relation to the legal agreement, further to the contractual parties.
   */
  otherParty?: PartyRole[];
  /**
   * A human readable document, for example a confirmation.
   */
  attachment?: Resource[];
  /**
   * Specification of the content of the legal agreement.
   */
  agreementTerms?: AgreementTerms;
  /**
   * Specifies the agreement(s) that govern the agreement, either as a reference to such agreements when specified as part of the CDM, or through identification of some of the key terms of those agreements, such as the type of agreement, the publisher, the vintage, the agreement identifier and the agreement date.
   */
  relatedAgreements?: LegalAgreement[];
  /**
   * The determination of whether Umbrella Agreement terms are applicable (True) or Not Applicable (False).
   */
  umbrellaAgreement?: UmbrellaAgreement;
  meta?: MetaFields;
}
  
/**
 * Specifies the legal agreement baseline information, being negotiated or having been executed. It excludes specialized elections
 */
export interface LegalAgreementBase {
  /**
   * The date on which the legal agreement has been agreed between the parties. This corresponds to the Date of Deed in an English Law document.
   */
  agreementDate?: Date;
  /**
   * The date on which, or as of which, the agreement is effective, if different from the agreement date. It is expected that it will most often correspond to the agreement date, although there could be situations where the parties will explicitly agree on a distinct effective date.
   */
  effectiveDate?: Date;
  /**
   * The legal agreement identifier. Several identifiers can be specified.
   */
  identifier?: Identifier[];
  /**
   * The type of legal agreement, identified via a set of composable attributes: agreementName, publisher, governing law and version, e.g. ISDA 2013 Standard Credit Support Annex English Law.
   */
  legalAgreementIdentification?: LegalAgreementIdentification;
  /**
   * The two contractual parties to the legal agreement, which reference information is positioned as part of the partyInformation attribute.
   */
  contractualParty?: ReferenceWithMeta<Party>[];
  /**
   * The role(s) that other party(ies) may have in relation to the legal agreement, further to the contractual parties.
   */
  otherParty?: PartyRole[];
  /**
   * A human readable document, for example a confirmation.
   */
  attachment?: Resource[];
}
  
/**
 * Specifies the type of legal agreement, identified via a set of composable attributes: agreementName, publisher, governing law and version, e.g. ISDA 2013 Standard Credit Support Annex English Law.
 */
export interface LegalAgreementIdentification {
  /**
   * The law governing the legal agreement, e.g. English Law, New York Law or Japanese Law.
   */
  governingLaw?: GoverningLawEnum;
  /**
   * The legal agreement name, e.g. Credit Support Annex for Variation Margin.
   */
  agreementName?: AgreementName;
  /**
   * The legal agreement publisher, e.g. ISDA.
   */
  publisher?: LegalAgreementPublisherEnum;
  /**
   * In the case where successive definitions of the legal agreement have been developed, the vintage identification. This is typically (but not necessarily) done by referencing the year, e.g. 2013 in the case of the ISDA 2013 Standard Credit Support Annex.
   */
  vintage?: number;
}
  
/**
 * A class to specify a legal entity, with a required name and an optional entity identifier (such as the LEI).
 */
export interface LegalEntity {
  /**
   * A legal entity identifier (e.g. RED entity code).
   */
  entityId?: FieldWithMeta<String>[];
  /**
   * The legal entity name.
   */
  name?: FieldWithMeta<String>;
  meta?: MetaFields;
}
  
export interface LimitApplicable {
  /**
   * Standard code to indicate which type of credit line is being referred to - i.e. IM, DV01, PV01, CS01, Notional, Clip Size, Notional, maximumOrderQuantity.
   */
  limitType?: FieldWithMeta<CreditLimitTypeEnum>;
  /**
   * This element is required in FpML, optional in CDM for the purpose of accommodating the CME data representation while making reference to the FpML one.
   */
  clipSize?: number;
  /**
   * The limit utilised by all the cleared trades for the limit level and limit type. While the attribute is of type integer in FpML and the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
   */
  amountUtilized?: number;
  utilization?: CreditLimitUtilisation;
  /**
   * The limit remaining for the limit level and limit type. This does not take into account any pending trades. While the attribute is of type integer in FpML and the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
   */
  amountRemaining?: number;
  /**
   * The currency in which the applicable limit is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
   */
  currency?: FieldWithMeta<String>;
  velocity?: Velocity;
}
  
/**
 * A class to represent the CDM attributes that are not part of the FpML standard. Once broader usage is confirmed, it is expected that those two classes can be collapsed.
 */
export interface LimitApplicableExtended extends LimitApplicable {
  /**
   * Standard code to indicate which type of credit line is being referred to - i.e. IM, DV01, PV01, CS01, Notional, Clip Size, Notional, maximumOrderQuantity.
   */
  limitType?: FieldWithMeta<CreditLimitTypeEnum>;
  /**
   * This element is required in FpML, optional in CDM for the purpose of accommodating the CME data representation while making reference to the FpML one.
   */
  clipSize?: number;
  /**
   * The limit utilised by all the cleared trades for the limit level and limit type. While the attribute is of type integer in FpML and the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
   */
  amountUtilized?: number;
  utilization?: CreditLimitUtilisation;
  /**
   * The limit remaining for the limit level and limit type. This does not take into account any pending trades. While the attribute is of type integer in FpML and the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
   */
  amountRemaining?: number;
  /**
   * The currency in which the applicable limit is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
   */
  currency?: FieldWithMeta<String>;
  velocity?: Velocity;
  /**
   * The level at which the limit is set: customer business, proprietary business or account level. This attribute is specified as a string as part of the CME clearing confirmation specification.
   */
  limitLevel?: FieldWithMeta<LimitLevelEnum>;
  /**
   * The total limit available for the limit level and limit type. While the attribute is of type integer in the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
   */
  limitAmount?: number;
  /**
   * The limit utilized by this specific trade. While the attribute is of type integer in the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
   */
  limitImpactDueToTrade?: number;
}
  
/**
 * A class to provide lineage information across lifecycle events through a pointer or set of pointers into the event(s), contract(s) and, possibly, payout components that the event is dependent on or relates to. As an example, if an contractFormation event is corrected, the correction event will have a lineage into the initial event, which takes the form of a globalKey into that initial contract formation event. Two referencing mechanisms are provided as part of the CDM: either the globalKey, which corresponds to the hash value of the CDM class which is referred to, or a reference qualifier which is meant to provide support for the ingestion of xml documents with id/href mechanisms. The CDM recommends the use of the globalKey and provides a default implementation which is accessible in the generated code through org.isda.cdm.globalKey.GlobalKeyHashCalculator. If implementers want to use an alternative hashing mechanism, the API in which they need to plug it is com.rosetta.model.lib.HashFunction.
 */
export interface Lineage {
  tradeReference?: ReferenceWithMeta<Trade>[];
  /**
   * The reference to the instantiation of an Event object, either through a globalKey or an xml-derived id/href mechanism. The definition associated to the Lineage class provides more details with respect to those referencing approaches, their expected usage and available implementation.
   */
  eventReference?: ReferenceWithMeta<WorkflowStep>[];
  /**
   * The reference to the previous state of a Portfolio, in a chain of Events leading up to a build of that Portfolio as the holding of Product(s) in specific Quantity(ies). As part of the PortfolioState object, a pointer to the previous PortfolioState is provided through a Lineage object, together with pointer(s) to the Event or set of Events leading up to the current (new) state.
   */
  portfolioStateReference?: ReferenceWithMeta<PortfolioState>[];
}
  
/**
 * A securitized derivative on another asset.
 */
export interface ListedDerivative extends InstrumentBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
  /**
   * Identifies the type of an instrument using an enumerated list.
   */
  instrumentType?: InstrumentTypeEnum;
  /**
   * Also called contract month or delivery month. However, it's not always a month. It is usually expressed using a code, e.g. Z23 would be the Dec 2023 contract, (Z = December). For crude oil, the corresponding contract might be called CLZ23. Optional as this can be uniquely identified in the identifier.
   */
  deliveryTerm?: string;
  /**
   * The type of option, ie Put or Call. Left empty if it is a Future.
   */
  optionType?: PutCallEnum;
  /**
   * Specifies the strike of the option.
   */
  strike?: number;
}
  
/**
 * Specifies a filter based on a stock exchange.
 */
export interface ListingExchange {
  /**
   * Represents a filter based on the Primary Stock Exchange facilitating the listing of companies, exchange of Stocks, Exchange traded Derivatives, Bonds, and other Securities expressed in ISO standard 10383.
   */
  exchange?: FieldWithMeta<String>[];
}
  
/**
 * Specifies a filter based on an industry sector.
 */
export interface ListingSector {
  /**
   * Represents a filter based on an industry sector defined under a system for classifying industry types such as Global Industry Classification Standard (GICS) and North American Industry Classification System (NAICS)
   */
  sector?: FieldWithMeta<String>[];
}
  
/**
 * Identifies a loan by referencing an asset identifier and through an optional set of attributes.
 */
export interface Loan extends InstrumentBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
  /**
   * Identifies the type of an instrument using an enumerated list.
   */
  instrumentType?: InstrumentTypeEnum;
  /**
   * Specifies the borrower. There can be more than one borrower. It is meant to be used in the event that there is no Bloomberg Id or the Secured List isn't applicable.
   */
  borrower?: LegalEntity[];
  /**
   * Specifies the seniority level of the lien.
   */
  lien?: FieldWithMeta<String>;
  /**
   * Specifies the type of loan facility (letter of credit, revolving, ...).
   */
  facilityType?: FieldWithMeta<String>;
  /**
   * Specifies the credit agreement date is the closing date (the date where the agreement has been signed) for the loans in the credit agreement. Funding of the facilities occurs on (or sometimes a little after) the Credit Agreement date. This underlier attribute is used to help identify which of the company's outstanding loans are being referenced by knowing to which credit agreement it belongs. ISDA Standards Terms Supplement term: Date of Original Credit Agreement.
   */
  creditAgreementDate?: Date;
  /**
   * Denotes the loan tranche that is subject to the derivative transaction. It will typically be referenced as the Bloomberg tranche number. ISDA Standards Terms Supplement term: Bloomberg Tranche Number.
   */
  tranche?: FieldWithMeta<String>;
}
  
/**
 * A class to specify loan with a participation agreement whereby the buyer is capable of creating, or procuring the creation of, a contractual right in favour of the seller that provides the seller with recourse to the participation seller for a specified share in any payments due under the relevant loan which are received by the participation seller. ISDA 2003 Term: Direct Loan Participation.
 */
export interface LoanParticipation extends PCDeliverableObligationCharac {
  /**
   * Indicates whether the provision is applicable.
   */
  applicable?: boolean;
  /**
   * Specifies whether either 'Partial Cash Settlement of Assignable Loans', 'Partial Cash Settlement of Consent Required Loans' or 'Partial Cash Settlement of Participations' is applicable. If this element is specified and Assignable Loan is a Deliverable Obligation Characteristic, any Assignable Loan that is deliverable, but where a non-receipt of Consent by the Physical Settlement Date has occurred, the Loan can be cash settled rather than physically delivered. If this element is specified and Consent Required Loan is a Deliverable Obligation Characteristic, any Consent Required Loan that is deliverable, but where a non-receipt of Consent by the Physical Settlement Date has occurred, the Loan can be cash settled rather than physically delivered. If this element is specified and Direct Loan Participation is a Deliverable Obligation Characteristic, any Participation that is deliverable, but where this participation has not been effected (has not come into effect) by the Physical Settlement Date, the participation can be cash settled rather than physically delivered.
   */
  partialCashSettlement?: boolean;
  /**
   * If Direct Loan Participation is specified as a deliverable obligation characteristic, this specifies any requirements for the Qualifying Participation Seller. The requirements may be listed free-form. ISDA 2003 Term: Qualifying Participation Seller.
   */
  qualifyingParticipationSeller?: string;
}
  
/**
 * Specifies a location identifier. An issuer and an identifier type can be associated with the actual identifier value as a way to properly qualify it.
 */
export interface LocationIdentifier extends Identifier {
  /**
   * The identifier issuer, when specified by reference to a party specified as part of the transaction.
   */
  issuerReference?: ReferenceWithMeta<Party>;
  /**
   * The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).
   */
  issuer?: FieldWithMeta<String>;
  /**
   * The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.
   */
  assignedIdentifier?: AssignedIdentifier[];
  meta?: MetaFields;
  /**
   * Specifies the nature of a location identifier.
   */
  locationIdentifierType?: CommodityLocationIdentifierTypeEnum;
}
  
/**
 * A class to specify the amount to be paid by the buyer of the option if the option is exercised prior to the Early Call Date (typically applicable to the convertible bond options).
 */
export interface MakeWholeAmount extends SwapCurveValuation {
  floatingRateIndex?: FloatingRateIndexEnum;
  /**
   * The ISDA Designated Maturity, i.e. the tenor of the floating rate.
   */
  indexTenor?: Period;
  /**
   * Spread in basis points over the floating rate index.
   */
  spread?: number;
  /**
   * The side (bid/mid/ask) of the measure.
   */
  side?: QuotationSideEnum;
  /**
   * The type of interpolation method that the calculation agent reserves the right to use.
   */
  interpolationMethod?: InterpolationMethodEnum;
  /**
   * Date prior to which the option buyer will have to pay a Make Whole Amount to the option seller if he/she exercises the option.
   */
  earlyCallDate?: FieldWithMeta<Date>;
}
  
/**
 * A data to:  define an early termination provision for which exercise is mandatory.
 */
export interface MandatoryEarlyTermination {
  /**
   * The early termination date associated with a mandatory early termination of a swap.
   */
  mandatoryEarlyTerminationDate?: AdjustableDate;
  /**
   * The ISDA Calculation Agent responsible for performing duties associated with an optional early termination.
   */
  calculationAgent?: CalculationAgent;
  /**
   * If specified, this means that cash settlement is applicable to the transaction and defines the parameters associated with the cash settlement procedure. If not specified, then physical settlement is applicable.
   */
  cashSettlement?: SettlementTerms;
  /**
   * The adjusted dates associated with a mandatory early termination provision. These dates have been adjusted for any applicable business day convention.
   */
  mandatoryEarlyTerminationAdjustedDates?: MandatoryEarlyTerminationAdjustedDates;
  meta?: MetaFields;
}
  
/**
 * A data defining:  the adjusted dates associated with a mandatory early termination provision.
 */
export interface MandatoryEarlyTerminationAdjustedDates {
  /**
   * The early termination date that is applicable if an early termination provision is exercised. This date should already be adjusted for any applicable business day convention.
   */
  adjustedEarlyTerminationDate?: Date;
  /**
   * The date by which the cash settlement amount must be agreed. This date should already be adjusted for any applicable business day convention.
   */
  adjustedCashSettlementValuationDate?: Date;
  /**
   * The date on which the cash settlement amount is paid. This date should already be adjusted for any applicable business date convention.
   */
  adjustedCashSettlementPaymentDate?: Date;
}
  
/**
 * A class defining manual exercise, i.e. that the option buyer counterparty must give notice to the option seller of exercise.
 */
export interface ManualExercise {
  /**
   * Definition of the party to whom notice of exercise should be given.
   */
  exerciseNotice?: ExerciseNotice;
  /**
   * If fallback exercise is specified then the notional amount of the underlying swap, not previously exercised under the swaption, will be automatically exercised at the expiration time on the expiration date if at such time the buyer is in-the-money, provided that the difference between the settlement rate and the fixed rate under the relevant underlying swap is not less than one tenth of a percentage point (0.10% or 0.001). The term in-the-money is assumed to have the meaning defined in the 2000 ISDA Definitions, Section 17.4. In-the-money.
   */
  fallbackExercise?: boolean;
}
  
/**
 * Represents common attributes required for Issuance and Response to a Margin Call action as a result of a demand for delivery or return of collateral determined under a legal agreement such as a credit support document or equivalent.
 */
export interface MarginCallBase {
  /**
   * Identifies the enumeration values to specify the call notification type, direction, specific action type.
   */
  instructionType?: MarginCallInstructionType;
  /**
   * Represents the parties to the margin call. The cardinality is optional to address the case where both parties of the event are specified and a third party if applicable.
   */
  party?: Party[];
  /**
   * Represents the role each specified party takes in the margin call. further to the principal roles, payer and receiver.
   */
  partyRole?: PartyRole[];
  /**
   * Indicates the name of the Clearing Broker FCM/DCM.
   */
  clearingBroker?: Party;
  /**
   * Represents a unique Identifier for a margin call message, that can be referenced throughout all points of the process.
   */
  callIdentifier?: Identifier;
  /**
   * Specifies the legal agreement type the margin call is generated from and governed by.
   */
  callAgreementType?: AgreementName;
  /**
   * Specifies the collateral legal agreement minimum transfer amount in base currency.
   */
  agreementMinimumTransferAmount?: Money;
  /**
   * Specifies the collateral legal agreement threshold amount in base currency.
   */
  agreementThreshold?: Money;
  /**
   * Specifies the collateral legal agreement rounding in base currency.
   */
  agreementRounding?: Money;
  /**
   * Identifies margin type and if related regulatory mandate
   */
  regMarginType?: RegMarginTypeEnum;
  /**
   * Indicates the role of the party in an regulatory initial margin call instruction (i.e Pledgor party or Secured party).
   */
  regIMRole?: RegIMRoleEnum;
  /**
   * Represents the current mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency), to be referenced in a margin call.
   */
  baseCurrencyExposure?: MarginCallExposure;
  /**
   * Represents attributes to define the details of collateral assets within a collateral portfolio to be used in margin call messaging and contribute to collateral balances e.g securities in a collateral account recorded by the principal as held or posted.
   */
  collateralPortfolio?: ReferenceWithMeta<CollateralPortfolio>;
  /**
   * Represents additional credit support amount over and above mark to market value.
   */
  independentAmountBalance?: CollateralBalance;
}
  
/**
 * Represents attributes required for mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency).
 */
export interface MarginCallExposure extends MarginCallBase {
  /**
   * Identifies the enumeration values to specify the call notification type, direction, specific action type.
   */
  instructionType?: MarginCallInstructionType;
  /**
   * Represents the parties to the margin call. The cardinality is optional to address the case where both parties of the event are specified and a third party if applicable.
   */
  party?: Party[];
  /**
   * Represents the role each specified party takes in the margin call. further to the principal roles, payer and receiver.
   */
  partyRole?: PartyRole[];
  /**
   * Indicates the name of the Clearing Broker FCM/DCM.
   */
  clearingBroker?: Party;
  /**
   * Represents a unique Identifier for a margin call message, that can be referenced throughout all points of the process.
   */
  callIdentifier?: Identifier;
  /**
   * Specifies the legal agreement type the margin call is generated from and governed by.
   */
  callAgreementType?: AgreementName;
  /**
   * Specifies the collateral legal agreement minimum transfer amount in base currency.
   */
  agreementMinimumTransferAmount?: Money;
  /**
   * Specifies the collateral legal agreement threshold amount in base currency.
   */
  agreementThreshold?: Money;
  /**
   * Specifies the collateral legal agreement rounding in base currency.
   */
  agreementRounding?: Money;
  /**
   * Identifies margin type and if related regulatory mandate
   */
  regMarginType?: RegMarginTypeEnum;
  /**
   * Indicates the role of the party in an regulatory initial margin call instruction (i.e Pledgor party or Secured party).
   */
  regIMRole?: RegIMRoleEnum;
  /**
   * Represents the current mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency), to be referenced in a margin call.
   */
  baseCurrencyExposure?: MarginCallExposure;
  /**
   * Represents attributes to define the details of collateral assets within a collateral portfolio to be used in margin call messaging and contribute to collateral balances e.g securities in a collateral account recorded by the principal as held or posted.
   */
  collateralPortfolio?: ReferenceWithMeta<CollateralPortfolio>;
  /**
   * Represents additional credit support amount over and above mark to market value.
   */
  independentAmountBalance?: CollateralBalance;
  /**
   * Represents the whole overall mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency).
   */
  overallExposure?: Exposure;
  /**
   * Represents Initial Margin (IM) exposure derived from ISDA SIMM calculation.
   */
  simmIMExposure?: Exposure;
  /**
   * Represents Initial Margin (IM) exposure derived from schedule or Grid calculation.
   */
  scheduleGridIMExposure?: Exposure;
}
  
/**
 * Represents enumeration values to specify the call notification type, direction, specific action type.
 */
export interface MarginCallInstructionType {
  /**
   * Indicates the status of the call message type, such as expected call, notification of a call or an actionable margin call.
   */
  callType?: CallTypeEnum;
  /**
   * Indicates the choice if the call instruction is visible or not to the other party.
   */
  visibilityIndicator?: boolean;
}
  
/**
 * Represents common attributes required for a Margin Call Issuance under a legal agreement such as a credit support document or equivalent.
 */
export interface MarginCallIssuance extends MarginCallBase {
  /**
   * Identifies the enumeration values to specify the call notification type, direction, specific action type.
   */
  instructionType?: MarginCallInstructionType;
  /**
   * Represents the parties to the margin call. The cardinality is optional to address the case where both parties of the event are specified and a third party if applicable.
   */
  party?: Party[];
  /**
   * Represents the role each specified party takes in the margin call. further to the principal roles, payer and receiver.
   */
  partyRole?: PartyRole[];
  /**
   * Indicates the name of the Clearing Broker FCM/DCM.
   */
  clearingBroker?: Party;
  /**
   * Represents a unique Identifier for a margin call message, that can be referenced throughout all points of the process.
   */
  callIdentifier?: Identifier;
  /**
   * Specifies the legal agreement type the margin call is generated from and governed by.
   */
  callAgreementType?: AgreementName;
  /**
   * Specifies the collateral legal agreement minimum transfer amount in base currency.
   */
  agreementMinimumTransferAmount?: Money;
  /**
   * Specifies the collateral legal agreement threshold amount in base currency.
   */
  agreementThreshold?: Money;
  /**
   * Specifies the collateral legal agreement rounding in base currency.
   */
  agreementRounding?: Money;
  /**
   * Identifies margin type and if related regulatory mandate
   */
  regMarginType?: RegMarginTypeEnum;
  /**
   * Indicates the role of the party in an regulatory initial margin call instruction (i.e Pledgor party or Secured party).
   */
  regIMRole?: RegIMRoleEnum;
  /**
   * Represents the current mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency), to be referenced in a margin call.
   */
  baseCurrencyExposure?: MarginCallExposure;
  /**
   * Represents attributes to define the details of collateral assets within a collateral portfolio to be used in margin call messaging and contribute to collateral balances e.g securities in a collateral account recorded by the principal as held or posted.
   */
  collateralPortfolio?: ReferenceWithMeta<CollateralPortfolio>;
  /**
   * Represents additional credit support amount over and above mark to market value.
   */
  independentAmountBalance?: CollateralBalance;
  /**
   * Specifies the amount of margin being called for which accounts for margin calculation inclusive of exposure, independent amount,threshold,collateral balance, MTA, rounding increments (in base currency detailed in supporting collateral agreement).
   */
  callAmountInBaseCurrency?: Money;
  /**
   * Specifies the details to describe or identify non-cash collateral eligible assets for recall purposes.
   */
  recallNonCashCollateralDescription?: EligibleCollateralCriteria[];
}
  
/**
 * Represents common attributes required for a Margin Call Response under a legal agreement such as a credit support document or equivalent.
 */
export interface MarginCallResponse extends MarginCallBase {
  /**
   * Identifies the enumeration values to specify the call notification type, direction, specific action type.
   */
  instructionType?: MarginCallInstructionType;
  /**
   * Represents the parties to the margin call. The cardinality is optional to address the case where both parties of the event are specified and a third party if applicable.
   */
  party?: Party[];
  /**
   * Represents the role each specified party takes in the margin call. further to the principal roles, payer and receiver.
   */
  partyRole?: PartyRole[];
  /**
   * Indicates the name of the Clearing Broker FCM/DCM.
   */
  clearingBroker?: Party;
  /**
   * Represents a unique Identifier for a margin call message, that can be referenced throughout all points of the process.
   */
  callIdentifier?: Identifier;
  /**
   * Specifies the legal agreement type the margin call is generated from and governed by.
   */
  callAgreementType?: AgreementName;
  /**
   * Specifies the collateral legal agreement minimum transfer amount in base currency.
   */
  agreementMinimumTransferAmount?: Money;
  /**
   * Specifies the collateral legal agreement threshold amount in base currency.
   */
  agreementThreshold?: Money;
  /**
   * Specifies the collateral legal agreement rounding in base currency.
   */
  agreementRounding?: Money;
  /**
   * Identifies margin type and if related regulatory mandate
   */
  regMarginType?: RegMarginTypeEnum;
  /**
   * Indicates the role of the party in an regulatory initial margin call instruction (i.e Pledgor party or Secured party).
   */
  regIMRole?: RegIMRoleEnum;
  /**
   * Represents the current mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency), to be referenced in a margin call.
   */
  baseCurrencyExposure?: MarginCallExposure;
  /**
   * Represents attributes to define the details of collateral assets within a collateral portfolio to be used in margin call messaging and contribute to collateral balances e.g securities in a collateral account recorded by the principal as held or posted.
   */
  collateralPortfolio?: ReferenceWithMeta<CollateralPortfolio>;
  /**
   * Represents additional credit support amount over and above mark to market value.
   */
  independentAmountBalance?: CollateralBalance;
  /**
   * Specifies the margin call action details, including collateral to be moved and direction.
   */
  marginCallResponseAction?: MarginCallResponseAction[];
  /**
   * Indicates the response type, such as, is the margin call response a 'full' 'part' agreement or 'dispute'.
   */
  marginResponseType?: MarginCallResponseTypeEnum;
  /**
   * Indicates the amount that posting entity agrees to remit in response to margin call (in base currency).
   */
  agreedAmountBaseCurrency?: Money;
}
  
/**
 * Specifies the margin call action details, including collateral to be moved and its direction.
 */
export interface MarginCallResponseAction {
  /**
   * Specifies the collateral to be moved and its direction.
   */
  collateralPositionComponent?: CollateralPosition[];
  /**
   * Specifies the margin call action details, specified as either Delivery or Return.
   */
  marginCallAction?: MarginCallActionEnum;
}
  
/**
 * Defines clauses that make up a Master Agreement
 */
export interface MasterAgreementClause {
  /**
   * Unique identifier for the clause
   */
  identifer?: MasterAgreementClauseIdentifierEnum;
  /**
   * Optional textual description of the clause.
   */
  name?: string;
  /**
   * Optional counterparty role. This can be used where a clause needs to be assigned to a specific party on the agreement based upon their role i.e. Party A or Party B.
   */
  counterparty?: CounterpartyRoleEnum[];
  /**
   * Optional party. This can be required for umbrella agreements where a clause may need to be assigned to a specific party who may or may not be on the agreement.
   */
  otherParty?: PartyRoleEnum[];
  /**
   * Allows multiple variants to be defined for a clause. This needs to be an array as some clauses can specify different variants for different parties. At least one variant must be specified for a clause.
   */
  variant?: MasterAgreementClauseVariant[];
}
  
/**
 * Sets the details for a specific variant associated to a clause in a Master Agreement
 */
export interface MasterAgreementClauseVariant {
  /**
   * Unique identifier for this variant
   */
  identifier?: MasterAgreementVariantIdentifierEnum;
  /**
   * Optional textual description of the variant.
   */
  name?: string;
  /**
   * Optional counterparty role. This can be used where a clause needs to assign a different variant to the different parties on the agreement based upon their role i.e. Party A or Party B.
   */
  counterparty?: CounterpartyRoleEnum[];
  /**
   * Optional party. This can be used where a clause needs to assign different variants to different parties who may or may not be on the agreement.
   */
  otherParty?: PartyRoleEnum[];
  /**
   * For some variants of some clauses additional details are required to work out what has been elected. This array can be used to define the name and value of these variables. Please refer to the agreement documentation for more details of the variables that are available for any clause.
   */
  variableSet?: MasterAgreementVariableSet[];
}
  
/**
 * The set of elections which specify a Master Agreement.
 */
export interface MasterAgreementSchedule {
  /**
   * Clauses that have had elections made against them in this Master Agreement. There must be at least one clause defined in the agreement.
   */
  clause?: MasterAgreementClause[];
}
  
/**
 * Defines a type where additional variables associated to clauses and their variants can be described.
 */
export interface MasterAgreementVariableSet {
  /**
   * For some variants a table of variables is required. To support this use case we need to be able to specify variables within variables. Including a variable set here gives us infinite nesting opportunities - realistically we are only ever expecting that a table would need to be defined for any particular clause, so we would expect two levels of nesting as a maximum i.e. variableSet->variableSet->name/value.
   */
  variableSet?: MasterAgreementVariableSet[];
  /**
   * The name of the variable
   */
  name?: string;
  /**
   * The value for this variable
   */
  value?: string;
}
  
/**
 * Legal agreement specification for General Terms and Elections that are applicable across multiple confirmations and are referenced by these confirmations.
 */
export interface MasterConfirmationBase {
}
  
/**
 * Defines a concrete measure as a number associated to a unit. It extends MeasureBase by requiring the value attribute to be present. A measure may be unit-less so the unit attribute is still optional.
 */
export interface Measure extends MeasureBase {
  /**
   * Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
   */
  value?: number;
  /**
   * Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
   */
  unit?: UnitType;
}
  
/**
 * Provides an abstract type to define a measure as a number associated to a unit. This type is abstract because all its attributes are optional. The types that extend it can specify further existence constraints.
 */
export interface MeasureBase {
  /**
   * Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
   */
  value?: number;
  /**
   * Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
   */
  unit?: UnitType;
}
  
/**
 * A set of measures, all in the same unit, where the values are defined through a schedule of steps. The initial value may be defined either as part of the steps, or using the single amount attribute.
 */
export interface MeasureSchedule extends MeasureBase {
  /**
   * Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
   */
  value?: number;
  /**
   * Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
   */
  unit?: UnitType;
  /**
   * A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
   */
  datedValue?: DatedValue[];
}
  
/**
 * This class corresponds to the components of the FpML MessageHeader.model.
 */
export interface MessageInformation {
  /**
   * A unique identifier assigned to the message.
   */
  messageId?: FieldWithMeta<String>;
  /**
   * The identifier for the originator of a message instance.
   */
  sentBy?: FieldWithMeta<String>;
  /**
   * The identifier(s) for the recipient(s) of a message instance.
   */
  sentTo?: FieldWithMeta<String>[];
  /**
   * A unique identifier (within the specified coding scheme) giving the details of some party to whom a copy of this message will be sent for reference.
   */
  copyTo?: FieldWithMeta<String>[];
}
  
/**
 * Defines a monetary amount in a specified currency.
 */
export interface Money extends Quantity {
  /**
   * Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
   */
  value?: number;
  /**
   * Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
   */
  unit?: UnitType;
  /**
   * A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
   */
  datedValue?: DatedValue[];
  /**
   * Defines an optional number that the quantity should be multiplied by to derive a total quantity. This number is associated to a unit. For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unit would be contracts, the multiplier value would 1,000 and the mulitiplier unit would be 1,000 MT (Metric Tons).
   */
  multiplier?: Measure;
  /**
   * Defines the frequency to be used when defining a quantity. For example a quantity may be specified as a number of barrels of oil per day, which needs multiplying by the number of days in the relevant period to get the total quantity as a number of barrels.
   */
  frequency?: Frequency;
  meta?: MetaFields;
}
  
/**
 * The money bound is defined as a money amount and whether the bound is inclusive.
 */
export interface MoneyBound {
  /**
   * The money amount to be used as the bound, e.g. 1,000 USD.
   */
  money?: Money;
  /**
   * Whether the money amount bound is inclusive, e.g. for a lower bound, false would indicate greater than, whereas true would indicate greater than or equal to.
   */
  inclusive?: boolean;
}
  
/**
 * The money range defined as either a lower and upper money bound, or both.
 */
export interface MoneyRange {
  /**
   * The lower bound of a money range, e.g. greater than or equal to 1,000 USD.
   */
  lowerBound?: MoneyBound;
  /**
   * The upper bound of a money range, e.g. less than 10,000 USD.
   */
  upperBound?: MoneyBound;
}
  
/**
 * Represetns a class to specify multiple credit notations alongside a conditional 'any' or 'all' qualifier.
 */
export interface MultipleCreditNotations {
  /**
   * An enumerated element, to qualify whether All or Any credit notation applies.
   */
  condition?: QuantifierEnum;
  /**
   * At least two credit notations much be specified.
   */
  creditNotation?: FieldWithMeta<CreditNotation>[];
  mismatchResolution?: CreditNotationMismatchResolutionEnum;
  referenceAgency?: CreditRatingAgencyEnum;
}
  
/**
 * Represents a class to specify multiple credit debt types alongside a conditional 'any' or 'all' qualifier.
 */
export interface MultipleDebtTypes {
  /**
   * An enumerated attribute, to qualify whether All or Any debt type applies.
   */
  condition?: QuantifierEnum;
  /**
   * The type of debt, e.g. long term debt, deposit, ... FpML doesn't specific a scheme value, hence no enumeration is specified as part of the CDM. At least two debt types much be specified.
   */
  debtType?: FieldWithMeta<String>[];
}
  
/**
 * A class defining multiple exercises. As defined in the 2000 ISDA Definitions, Section 12.4. Multiple Exercise, the buyer of the option has the right to exercise all or less than all the unexercised notional amount of the underlying swap on one or more days in the exercise period, but on any such day may not exercise less than the minimum notional amount or more than the maximum notional amount, and if an integral multiple amount is specified, the notional exercised must be equal to or, be an integral multiple of, the integral multiple amount. In FpML, MultipleExercise is built upon the PartialExercise.model.
 */
export interface MultipleExercise extends PartialExercise {
  /**
   * A pointer style reference to the associated notional schedule defined elsewhere in the document. This element has been made optional as part of its integration in the OptionBaseExtended, because not required for the options on securities.
   */
  notionaReference?: ReferenceWithMeta<Money>;
  /**
   * A notional amount which restricts the amount of notional that can be exercised when partial exercise or multiple exercise is applicable. The integral multiple amount defines a lower limit of notional that can be exercised and also defines a unit multiple of notional that can be exercised, i.e. only integer multiples of this amount can be exercised.
   */
  integralMultipleAmount?: number;
  /**
   * The minimum notional amount that can be exercised on a given exercise date. See multipleExercise.
   */
  minimumNotionalAmount?: number;
  /**
   * The minimum number of options that can be exercised on a given exercise date.
   */
  minimumNumberOfOptions?: number;
  /**
   * The maximum notional amount that can be exercised on a given exercise date.
   */
  maximumNotionalAmount?: number;
  /**
   * The maximum number of options that can be exercised on a given exercise date. If the number is not specified, it means that the maximum number of options corresponds to the remaining unexercised options.
   */
  maximumNumberOfOptions?: number;
}
  
export interface MultipleValuationDates extends SingleValuationDate {
  /**
   * A number of business days. Its precise meaning is dependant on the context in which this element is used. ISDA 2003 Term: Business Day.
   */
  businessDays?: number;
  /**
   * The number of business days between successive valuation dates when multiple valuation dates are applicable for cash settlement. ISDA 2003 Term: Business Days thereafter.
   */
  businessDaysThereafter?: number;
  /**
   * Where multiple valuation dates are specified as being applicable for cash settlement, this element specifies (a) the number of applicable valuation dates, and (b) the number of business days after satisfaction of all conditions to settlement when the first such valuation date occurs, and (c) the number of business days thereafter of each successive valuation date. ISDA 2003 Term: Multiple Valuation Dates.
   */
  numberValuationDates?: number;
}
  
/**
 * A class to represent the attributes that are specific to a natural person.
 */
export interface NaturalPerson {
  /**
   * The identifier associated with a person, e.g. the internal identification code.
   */
  personId?: FieldWithMeta<PersonIdentifier>[];
  /**
   * An honorific title, such as Mr., Ms., Dr. etc.
   */
  honorific?: string;
  /**
   * The natural person's first name. It is optional in FpML.
   */
  firstName?: string;
  /**
   * The natural person's middle name(s). If a middle name is provided then an initial should be absent.
   */
  middleName?: string[];
  /**
   * The natural person's middle initial(s). If a middle initial is provided then a name should be absent.
   */
  initial?: string[];
  /**
   * The natural person's surname.
   */
  surname?: string;
  /**
   * Name suffix, such as Jr., III, etc.
   */
  suffix?: string;
  /**
   * The natural person's date of birth.
   */
  dateOfBirth?: Date;
  /**
   * The contact information for such person, when different from the contact information associated with the party.
   */
  contactInformation?: ContactInformation;
  meta?: MetaFields;
}
  
/**
 * A class to specify the role(s) that natural person(s) may have in relation to the contract.
 */
export interface NaturalPersonRole {
  /**
   * A reference to the natural person to whom the role refers to.
   */
  personReference?: ReferenceWithMeta<NaturalPerson>;
  /**
   * FpML specifies a person role that is distinct from the party role.
   */
  role?: FieldWithMeta<NaturalPersonRoleEnum>[];
}
  
/**
 * Used to apply a NOT logic condition to a single Collateral Criteria.
 */
export interface NegativeCriteria {
  negativeCriteria?: CollateralCriteria;
}
  
export interface New {
  txId?: string;
  exctgPty?: string;
  invstmtPtyInd?: string;
  submitgPty?: string;
  buyr?: Buyr;
  sellr?: Sellr;
  ordrTrnsmssn?: OrdrTrnsmssn;
  tx?: Tx;
  finInstrm?: FinInstrm;
  invstmtDcsnPrsn?: InvstmtDcsnPrsn;
  exctgPrsn?: ExctgPrsn;
  addtlAttrbts?: AddtlAttrbts;
}
  
export interface Nm {
  refRate?: RefRate;
  term?: Term;
}
  
/**
 * Specifies a quantity as a non-negative number, which condition is enforced through a data rule that only applies to the extending class.
 */
export interface NonNegativeQuantity extends Quantity {
  /**
   * Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
   */
  value?: number;
  /**
   * Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
   */
  unit?: UnitType;
  /**
   * A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
   */
  datedValue?: DatedValue[];
  /**
   * Defines an optional number that the quantity should be multiplied by to derive a total quantity. This number is associated to a unit. For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unit would be contracts, the multiplier value would 1,000 and the mulitiplier unit would be 1,000 MT (Metric Tons).
   */
  multiplier?: Measure;
  /**
   * Defines the frequency to be used when defining a quantity. For example a quantity may be specified as a number of barrels of oil per day, which needs multiplying by the number of days in the relevant period to get the total quantity as a number of barrels.
   */
  frequency?: Frequency;
}
  
export interface NonNegativeQuantitySchedule extends QuantitySchedule {
  /**
   * Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
   */
  value?: number;
  /**
   * Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
   */
  unit?: UnitType;
  /**
   * A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
   */
  datedValue?: DatedValue[];
  /**
   * Defines an optional number that the quantity should be multiplied by to derive a total quantity. This number is associated to a unit. For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unit would be contracts, the multiplier value would 1,000 and the mulitiplier unit would be 1,000 MT (Metric Tons).
   */
  multiplier?: Measure;
  /**
   * Defines the frequency to be used when defining a quantity. For example a quantity may be specified as a number of barrels of oil per day, which needs multiplying by the number of days in the relevant period to get the total quantity as a number of barrels.
   */
  frequency?: Frequency;
}
  
/**
 * A class defining a step date and non-negative step value pair. This step definitions are used to define varying rate or amount schedules, e.g. a notional amortisation or a step-up coupon schedule.
 */
export interface NonNegativeStep {
  /**
   * The date on which the associated stepValue becomes effective. This day may be subject to adjustment in accordance with a business day convention.
   */
  stepDate?: Date;
  /**
   * The non-negative rate or amount which becomes effective on the associated stepDate. A rate of 5% would be represented as 0.05.
   */
  stepValue?: number;
  meta?: MetaFields;
}
  
/**
 * A data type to specify the financial product's economic terms, alongside the product identification and product taxonomy. The non-transferable product data type represents a product that can be traded (as part of a TradableProduct) but cannot be transferred to others.  It is meant to be used across the pre-execution, execution and (as part of the Contract) post-execution lifecycle contexts.
 */
export interface NonTransferableProduct {
  /**
   * Comprises a identifier and a source to uniquely identify the nonTransferableProduct. 
   */
  identifier?: ProductIdentifier[];
  /**
   * Specifies the product taxonomy, which is composed of a taxonomy value and a taxonomy source.
   */
  taxonomy?: ProductTaxonomy[];
  /**
   * The price forming features, including payouts and provisions.
   */
  economicTerms?: EconomicTerms;
  meta?: MetaFields;
}
  
/**
 * A class to specify the ISDA 2003 Term: Not Domestic Currency.
 */
export interface NotDomesticCurrency {
  /**
   * Indicates whether the Not Domestic Currency provision is applicable.
   */
  applicable?: boolean;
  /**
   * An explicit specification of the domestic currency. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
   */
  currency?: FieldWithMeta<String>;
}
  
/**
 * The number bound is defined as a number and whether the bound is inclusive.
 */
export interface NumberBound {
  /**
   * The number to be used as the bound, e.g. 5.
   */
  number?: number;
  /**
   * Whether the number bound is inclusive, e.g. for a lower bound, false would indicate greater than, whereas true would indicate greater than or equal to.
   */
  inclusive?: boolean;
}
  
/**
 * The number range defined as either a lower and upper number bound, or both.
 */
export interface NumberRange {
  /**
   * The lower bound of a number range, e.g. greater than or equal to 5.
   */
  lowerBound?: NumberBound;
  /**
   * The upper bound of a number range, e.g. less than 10.
   */
  upperBound?: NumberBound;
}
  
/**
 * A class to specify the underlying obligations of the reference entity on which protection is purchased or sold through the Credit Default Swap.
 */
export interface Obligations {
  /**
   * Used in both obligations and deliverable obligations to represent a class or type of securities which apply. ISDA 2003 Term: Obligation Category/Deliverable Obligation Category.
   */
  category?: ObligationCategoryEnum;
  /**
   * An obligation and deliverable obligation characteristic. An obligation that ranks at least equal with the most senior Reference Obligation in priority of payment or, if no Reference Obligation is specified in the related Confirmation, the obligations of the Reference Entity that are senior. ISDA 2003 Term: Not Subordinated.
   */
  notSubordinated?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. The currency or currencies in which an obligation or deliverable obligation must be payable. ISDA 2003 Term: Specified Currency.
   */
  specifiedCurrency?: SpecifiedCurrency;
  /**
   * An obligation and deliverable obligation characteristic. Any obligation that is not primarily (majority) owed to a Sovereign or Supranational Organisation. ISDA 2003 Term: Not Sovereign Lender.
   */
  notSovereignLender?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. Any obligation that is payable in any currency other than the domestic currency. Domestic currency is either the currency so specified or, if no currency is specified, the currency of (a) the reference entity, if the reference entity is a sovereign, or (b) the jurisdiction in which the relevant reference entity is organised, if the reference entity is not a sovereign. ISDA 2003 Term: Not Domestic Currency.
   */
  notDomesticCurrency?: NotDomesticCurrency;
  /**
   * An obligation and deliverable obligation characteristic. If the reference entity is a Sovereign, this means any obligation that is not subject to the laws of the reference entity. If the reference entity is not a sovereign, this means any obligation that is not subject to the laws of the jurisdiction of the reference entity. ISDA 2003 Term: Not Domestic Law.
   */
  notDomesticLaw?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. Indicates whether or not the obligation is quoted, listed or ordinarily purchased and sold on an exchange. ISDA 2003 Term: Listed.
   */
  listed?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. Any obligation other than an obligation that was intended to be offered for sale primarily in the domestic market of the relevant Reference Entity. This specifies that the obligation must be an internationally recognised bond. ISDA 2003 Term: Not Domestic Issuance.
   */
  notDomesticIssuance?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: Full Faith and Credit Obligation Liability.
   */
  fullFaithAndCreditObLiability?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: General Fund Obligation Liability.
   */
  generalFundObligationLiability?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: Revenue Obligation Liability.
   */
  revenueObligationLiability?: boolean;
  /**
   * OTE: Only allowed as an obligation characteristic under ISDA Credit 1999. In essence Not Contingent means the repayment of principal cannot be dependent on a formula/index, i.e. to prevent the risk of being delivered an instrument that may never pay any element of principal, and to ensure that the obligation is interest bearing (on a regular schedule). ISDA 2003 Term: Not Contingent.
   */
  notContingent?: boolean;
  /**
   * A free format string to specify any excluded obligations or deliverable obligations, as the case may be, of the reference entity or excluded types of obligations or deliverable obligations. ISDA 2003 Term: Excluded Obligations/Excluded Deliverable Obligations.
   */
  excluded?: string;
  /**
   * This element is used to specify any other obligations of a reference entity in both obligations and deliverable obligations. The obligations can be specified free-form. ISDA 2003 Term: Other Obligations of a Reference Entity.
   */
  othReferenceEntityObligations?: string;
  /**
   * Applies to Loan CDS, to indicate what lien level is appropriate for a deliverable obligation. Applies to European Loan CDS, to indicate the Ranking of the obligation. Example: a 2nd lien Loan CDS would imply that the deliverable obligations are 1st or 2nd lien loans.
   */
  designatedPriority?: FieldWithMeta<String>;
  /**
   * An obligation and deliverable obligation characteristic. Defined in the ISDA published Standard Terms Supplement for use with CDS Transactions on Leveraged Loans. ISDA 2003 Term: Cash Settlement Only.
   */
  cashSettlementOnly?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. Defined in the ISDA published Standard Terms Supplement for use with CDS Transactions on Leveraged Loans. ISDA 2003 Term: Delivery of Commitments.
   */
  deliveryOfCommitments?: boolean;
  /**
   * An obligation and deliverable obligation characteristic. Defined in the ISDA published Standard Terms Supplement for use with CDS Transactions on Leveraged Loans. ISDA 2003 Term: Continuity.
   */
  continuity?: boolean;
}
  
/**
 * Specifies the object to be observed for a price, it could be an asset or a reference.
 */
export interface Observable {
  /**
   * The object to be observed is an Asset, ie something that can be owned and transferred in the financial markets.
   */
  asset?: Asset;
  /**
   * The object to be observed is a Basket, ie a collection of Observables with an identifier and optional weightings.
   */
  basket?: Basket;
  /**
   * The object to be observed is an Index, ie an observable computed on the prices, rates or valuations of a number of assets.
   */
  index?: Index;
}
  
/**
 * Defines a single, numerical value that was observed in the marketplace. Observations of market data are made independently to business events or trade life-cycle events, so data instances of Observation can be created independently of any other model type, hence it is annotated as a root type. Observations will be broadly reused in many situations, so references to Observation are supported via the 'key' annotation.
 */
export interface Observation {
  /**
   * Specifies the observed value as a number.
   */
  observedValue?: Price;
  /**
   * Represents the observation was made i.e. how to uniquely identify the observed value among the population of all available market data.
   */
  observationIdentifier?: ObservationIdentifier;
  meta?: MetaFields;
}
  
/**
 * Specifies a single date on which market observations take place and specifies optional associated weighting.
 */
export interface ObservationDate {
  /**
   * A date subject to adjustment.
   */
  unadjustedDate?: Date;
  /**
   * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
   */
  adjustedDate?: Date;
  /**
   * Specifies the degree of importance of the observation.
   */
  weight?: number;
  /**
   * Specifies an identification key for the market observation. This attribute can be used as a reference to assign weights to a series of dates defined in a parametricSchedule.
   */
  observationReference?: string;
  meta?: MetaFields;
}
  
/**
 * Describes date details for a set of observation dates in parametric or non-parametric form.
 */
export interface ObservationDates {
  /**
   * Specifies a schedule of dates (non-parametric) on which market observations take place, and allows for the optional definition of weights where applicable.  When no weight is specified, then weight of each date is assumed to be 1.0
   */
  observationSchedule?: ObservationSchedule;
  /**
   * Specifies the date range and frequency on which market observations take place.  Weights can be assigned to dates in the schedule by assigning the weight and corresponding observationReference in the observationSchedule.
   */
  periodicSchedule?: PeriodicDates;
  /**
   * Specifies parametric terms to determine which days within a given calculation period the price would be observed. Typically associated with Commodities. 
   */
  parametricDates?: ParametricDates;
}
  
/**
 * Specifies the necessary information to create any observation event.
 */
export interface ObservationEvent {
  /**
   * Specifies the necessary information to create a credit event.
   */
  creditEvent?: CreditEvent;
  /**
   * Specifies the necessary information to create a corporate action.
   */
  corporateAction?: CorporateAction;
}
  
/**
 * Defines the parameters needed to uniquely identify a piece of data among the population of all available market data.
 */
export interface ObservationIdentifier {
  /**
   * Represents the asset or rate to which the observation relates.
   */
  observable?: Observable;
  /**
   * Specifies the date value to use when resolving the market data.
   */
  observationDate?: Date;
  /**
   * Represents the time and time-zone.
   */
  observationTime?: TimeZone;
  /**
   * Represents where the market data published and should be observed.
   */
  informationSource?: InformationSource;
  /**
   * Specifies the method according to which an amount or a date is determined.
   */
  determinationMethodology?: DeterminationMethodology;
}
  
/**
 * Specifies inputs needed to process an observation.
 */
export interface ObservationInstruction {
  /**
   * Contains all information related to an observation.
   */
  observationEvent?: ObservationEvent;
}
  
/**
 * Parameters on daily observed computed rates, specifically daily caps and floors. This type is used to represent modular computed rates in interestRatePayouts.
 */
export interface ObservationParameters {
  /**
   * A daily observation cap rate.
   */
  observationCapRate?: number;
  /**
   * A daily observation floor rate.
   */
  observationFloorRate?: number;
}
  
/**
 * Specifies a single date on which market observations take place and specifies optional associated weighting.
 */
export interface ObservationSchedule {
  /**
   * Specifies an adjusted or unadjusted date for a market observation.
   */
  observationDate?: ObservationDate[];
  /**
   * The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
   */
  dateAdjustments?: BusinessDayAdjustments;
}
  
/**
 * Parameters to describe the observation shift for a daily compounded or averaged floating rate. This type is used to represent modular computed rates in interestRatePayouts.
 */
export interface ObservationShiftCalculation {
  /**
   * The number of days of observation shift.
   */
  offsetDays?: number;
  /**
   * Whether the rate is calculated in advance, in arrears, or relative to a reset date.
   */
  calculationBase?: ObservationPeriodDatesEnum;
  /**
   * Any additional business days that be applicable.
   */
  additionalBusinessDays?: BusinessCenters;
}
  
/**
 * Class containing terms that are associated with observing a price/benchmark/index across either single or multiple observations. 
 */
export interface ObservationTerms {
  /**
   * Defines time in respect to a business calendar location that the price/benchmark/index is observed
   */
  observationTime?: BusinessCenterTime;
  /**
   * The enumerated values to specify points in the day when option exercise and valuation can occur.
   */
  observationTimeType?: TimeTypeEnum;
  /**
   * The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
   */
  informationSource?: FxSpotRateSource;
  /**
   * Defines rounding rules and precision to be used in the rounding of observations.
   */
  precision?: Rounding;
  /**
   * Defines parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods. A calculation period schedule consists of an optional initial stub calculation period, one or more regular calculation periods and an optional final stub calculation period. In the absence of any initial or final stub calculation periods, the regular part of the calculation period schedule is assumed to be between the effective date and the termination date. No implicit stubs are allowed, i.e. stubs must be explicitly specified using an appropriate combination of firstPeriodStartDate, firstRegularPeriodStartDate and lastRegularPeriodEndDate.
   */
  calculationPeriodDates?: CalculationPeriodDates;
  /**
   * Describes date details for a set of observation dates in parametric or non-parametric form.
   */
  observationDates?: ObservationDates;
  /**
   * The number of observation dates between observation start date and observation end date.
   */
  numberOfObservationDates?: number;
}
  
/**
 * A class defining an offset used in calculating a new date relative to a reference date, e.g. calendar days, business days, commodity Business days, etc.
 */
export interface Offset extends Period {
  /**
   * A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
   */
  periodMultiplier?: number;
  /**
   * A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
   */
  period?: PeriodEnum;
  meta?: MetaFields;
  /**
   * In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
   */
  dayType?: DayTypeEnum;
}
  
/**
 * Defines business day shifts for daily componded or averaged rates.  This type is used for lookback and lockout rates. This type is used to represent modular computed rates in interestRatePayouts.
 */
export interface OffsetCalculation {
  /**
   * The number of business days offset.
   */
  offsetDays?: number;
}
  
/**
 * Defines additional optional features that can be included in an option contract.
 */
export interface OptionFeature {
  /**
   * Describes a quanto or composite FX feature.
   */
  fxFeature?: FxFeature[];
  /**
   * Defines a simple strategy feature.
   */
  strategyFeature?: StrategyFeature;
  /**
   * Defines an option feature in which an average market observation price is determined on valuation and compared to the strike to determine a settlement amount.
   */
  averagingFeature?: AveragingCalculation;
  /**
   * Specifies a barrier feature.
   */
  barrier?: Barrier;
  /**
   * Specifies a knock in or knock out feature.
   */
  knock?: Knock;
  /**
   * Specifies the rules for pass-through payments from the underlier, such as dividends.
   */
  passThrough?: PassThrough;
}
  
/**
 *  The option payout specification terms. The associated globalKey denotes the ability to associate a hash value to the respective OptionPayout instantiation for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 */
export interface OptionPayout extends PayoutBase {
  /**
   * Canonical representation of the payer and receiver parties applicable to each payout leg.
   */
  payerReceiver?: PayerReceiver;
  /**
   * Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
   */
  priceQuantity?: ResolvablePriceQuantity;
  /**
   * The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
   */
  principalPayment?: PrincipalPayments;
  /**
   * Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
   */
  settlementTerms?: SettlementTerms;
  buyerSeller?: BuyerSeller;
  /**
   * The option feature, such as quanto, Asian, barrier, knock.
   */
  feature?: OptionFeature;
  /**
   * Class containing terms that are associated with observing a price/benchmark/index across either single or multple observations. To be used for option contracts that reference a benchmark price.
   */
  observationTerms?: ObservationTerms;
  /**
   * Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
   */
  schedule?: CalculationSchedule;
  /**
   * Contains the information relative to the delivery of the asset.
   */
  delivery?: AssetDeliveryInformation;
  /**
   * The financial product underlying the option, which can be of any type including an Asset, Basket, Index or a NonTransferableProduct.
   */
  underlier?: Underlier;
  /**
   * The type of option transaction. From a usage standpoint, put/call is the default option type, while payer/receiver indicator is used for options on index credit default swaps, consistently with the industry practice. Straddle is used for the case of straddle strategy, that combine a call and a put with the same strike.
   */
  optionType?: OptionTypeEnum;
  /**
   * The terms for exercising the option, which include the option style (e.g. American style option), the exercise procedure (e.g. manual exercise) and the settlement terms (e.g. physical vs. cash).
   */
  exerciseTerms?: ExerciseTerms;
  /**
   * Specifies the strike of the option
   */
  strike?: OptionStrike;
}
  
/**
 * Defines the strike price of an option.
 */
export interface OptionStrike {
  /**
   * Defines the strike of an option in the form of a price that could be a cash price, interestRate, or other types.
   */
  strikePrice?: Price;
  /**
   * Defines the strike of an option in reference to the spread of the underlying swap (typical practice in the case of an option on a credit single name swaps).
   */
  strikeReference?: ReferenceWithMeta<FixedRateSpecification>;
  /**
   * Defines the strike of an option when expressed by reference to a swap curve (Typically the case for a convertible bond option).
   */
  referenceSwapCurve?: ReferenceSwapCurve;
  /**
   * Defines an  option strike that is calculated from an average of observed market prices.
   */
  averagingStrikeFeature?: AveragingStrikeFeature;
}
  
/**
 * A data defining:  an early termination provision where either or both parties have the right to exercise.
 */
export interface OptionalEarlyTermination {
  /**
   * If optional early termination is not available to both parties then this component specifies the buyer and seller of the option. In FpML, this attribute is of type SinglePsrtyOption, which actually consists of the BuyerSeller.model.
   */
  singlePartyOption?: BuyerSeller;
  /**
   * Used for specifying whether the Mutual Early Termination Right that is detailed in the Master Confirmation will apply.
   */
  mutualEarlyTermination?: boolean;
  /**
   * Definition of the party to whom notice of exercise should be given.
   */
  exerciseNotice?: ExerciseNotice[];
  /**
   * A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller's agent.
   */
  followUpConfirmation?: boolean;
  /**
   * The ISDA Calculation Agent responsible for performing duties associated with an optional early termination.
   */
  calculationAgent?: CalculationAgent;
  /**
   * If specified, this means that cash settlement is applicable to the transaction and defines the parameters associated with the cash settlement procedure. If not specified, then physical settlement is applicable.
   */
  cashSettlement?: SettlementTerms;
  /**
   * An early termination provision to terminate the trade at fair value where one or both parties have the right to decide on termination.
   */
  optionalEarlyTerminationAdjustedDates?: OptionalEarlyTerminationAdjustedDates;
  /**
   * The exercise terms associated with the optional early termination, including details such as exercise style, exercise fees, and any other relevant conditions or terms.
   */
  exerciseTerms?: ExerciseTerms;
}
  
/**
 * A data defining:  the adjusted dates associated with an optional early termination provision.
 */
export interface OptionalEarlyTerminationAdjustedDates {
  /**
   * The adjusted dates associated with an individual early termination date.
   */
  earlyTerminationEvent?: EarlyTerminationEvent[];
}
  
export interface OrdrTrnsmssn {
  trnsmssnInd?: string;
}
  
/**
 * A class for defining an agreement executed between parties.
 */
export interface OtherAgreement {
  /**
   * An identifier that has been created to identify the agreement.
   */
  identifier?: FieldWithMeta<String>;
  /**
   * The agreement executed between the parties and intended to govern product-specific derivatives transactions between those parties.
   */
  otherAgreementType?: FieldWithMeta<String>;
  /**
   * The version of the agreement.
   */
  version?: FieldWithMeta<String>;
  /**
   * The date on which the agreement was signed.
   */
  date?: Date;
}
  
/**
 * A class to specify a related legal agreement. For example, ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (s): Other CSA and Japanese Law CSA (VM). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (o): Other CSA.
 */
export interface OtherAgreementTerms {
  /**
   * The qualification of whether some other related agreement is specified (True) or not (False).
   */
  isSpecified?: boolean;
  /**
   * The specification of this other agreement, when the qualification is True.
   */
  legalDocument?: string;
}
  
/**
 * Specification of a user-defined index that does not meet the criteria of other Index data types.
 */
export interface OtherIndex extends IndexBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
  /**
   * A description of the Index.
   */
  name?: FieldWithMeta<String>;
  /**
   * The organisation that creates or maintains the Index.
   */
  provider?: LegalEntity;
  /**
   * The Asset Class of the Index.
   */
  assetClass?: AssetClassEnum;
  /**
   * A description that defines the OtherIndex.
   */
  description?: string;
}
  
export interface Othr {
  finInstrmGnlAttrbts?: FinInstrmGnlAttrbts;
  derivInstrmAttrbts?: DerivInstrmAttrbts;
  id?: string;
  schmeNm?: SchmeNm;
}
  
/**
 * A class to specify the Partial Cash Deliverable Obligation Characteristic.
 */
export interface PCDeliverableObligationCharac {
  /**
   * Indicates whether the provision is applicable.
   */
  applicable?: boolean;
  /**
   * Specifies whether either 'Partial Cash Settlement of Assignable Loans', 'Partial Cash Settlement of Consent Required Loans' or 'Partial Cash Settlement of Participations' is applicable. If this element is specified and Assignable Loan is a Deliverable Obligation Characteristic, any Assignable Loan that is deliverable, but where a non-receipt of Consent by the Physical Settlement Date has occurred, the Loan can be cash settled rather than physically delivered. If this element is specified and Consent Required Loan is a Deliverable Obligation Characteristic, any Consent Required Loan that is deliverable, but where a non-receipt of Consent by the Physical Settlement Date has occurred, the Loan can be cash settled rather than physically delivered. If this element is specified and Direct Loan Participation is a Deliverable Obligation Characteristic, any Participation that is deliverable, but where this participation has not been effected (has not come into effect) by the Physical Settlement Date, the participation can be cash settled rather than physically delivered.
   */
  partialCashSettlement?: boolean;
}
  
/**
 * Defines rules for the dates on which the price will be determined.
 */
export interface ParametricDates {
  /**
   * Denotes the enumerated values to specify the day type classification used in counting the number of days between two dates.
   */
  dayType?: DayTypeEnum;
  /**
   * Denotes the method by which the pricing days are distributed across the pricing period.
   */
  dayDistribution?: DayDistributionEnum;
  /**
   * Indicates the days of the week on which the price will be determined.
   */
  dayOfWeek?: DayOfWeekEnum[];
  /**
   * Defines the occurrence of the dayOfWeek within the pricing period on which pricing will take place, e.g. the 3rd Friday within each Calculation Period. If omitted, every dayOfWeek will be a pricing day.
   */
  dayFrequency?: number;
  /**
   * The pricing period per calculation period if the pricing days do not wholly fall within the respective calculation period.
   */
  lag?: Lag;
  /**
   * The enumerated values to specify the business centers.
   */
  businessCenters?: BusinessCenters;
}
  
/**
 * A class defining partial exercise. As defined in the 2000 ISDA Definitions, Section 12.3 Partial Exercise, the buyer of the option may exercise all or less than all the notional amount of the underlying swap but may not be less than the minimum notional amount (if specified) and must be an integral multiple of the integral multiple amount if specified.
 */
export interface PartialExercise {
  /**
   * A pointer style reference to the associated notional schedule defined elsewhere in the document. This element has been made optional as part of its integration in the OptionBaseExtended, because not required for the options on securities.
   */
  notionaReference?: ReferenceWithMeta<Money>;
  /**
   * A notional amount which restricts the amount of notional that can be exercised when partial exercise or multiple exercise is applicable. The integral multiple amount defines a lower limit of notional that can be exercised and also defines a unit multiple of notional that can be exercised, i.e. only integer multiples of this amount can be exercised.
   */
  integralMultipleAmount?: number;
  /**
   * The minimum notional amount that can be exercised on a given exercise date. See multipleExercise.
   */
  minimumNotionalAmount?: number;
  /**
   * The minimum number of options that can be exercised on a given exercise date.
   */
  minimumNumberOfOptions?: number;
}
  
/**
 * A class to specify a party, without a qualification as to whether this party is a legal entity or a natural person, although the model provides the ability to associate a person (or set of persons) to a party, which use case would imply that such party would be a legal entity (even if not formally specified as such). 
 */
export interface Party {
  /**
   * The identifier associated with a party, e.g. the 20 digits LEI code.
   */
  partyId?: PartyIdentifier[];
  /**
   * The party name.
   */
  name?: FieldWithMeta<String>;
  /**
   * Optional organization unit information used to describe the organization units (e.g. trading desks) involved in a transaction or business process, incl. the contact information (when relevant).
   */
  businessUnit?: BusinessUnit[];
  /**
   * The person(s) who might be associated with the party as part of the execution, contract or legal document.
   */
  person?: NaturalPerson[];
  /**
   * The role of the person(s) 
   */
  personRole?: NaturalPersonRole[];
  /**
   * The account that might be associated with the party. At most one account can be specified, as it is expected that this information is used in the context of a contract or legal document where only one account per party can be associated with such object.
   */
  account?: Account;
  /**
   * The postal/street address, telephone number, email address and/or web page. If the contact information is specific to the associated business unit(s) or person (s), it should be associated with those.
   */
  contactInformation?: ContactInformation;
  meta?: MetaFields;
}
  
/**
 * Specifies instruction to change the party on a trade. This primitive instruction is used in a number of scenarios including: clearing, allocation and novation. The instrution must include a trade identifier, because a change of party effectively results in a different trade.
 */
export interface PartyChangeInstruction {
  /**
   * The new counterparty who is stepping into the trade. The stepping out counterparty is inferred based on the counterparty role that is being updated.
   */
  counterparty?: Counterparty;
  /**
   * Specifies an ancillary party to be added onto the new transaction, e.g. the original executing party in an allocation.
   */
  ancillaryParty?: AncillaryParty;
  /**
   * Specifies an additional party roles to be added on to the new transaction.
   */
  partyRole?: PartyRole;
  /**
   * The identifier to be assigned to the new trade post change of party.
   */
  tradeId?: TradeIdentifier[];
}
  
/**
 * A class to specify contact information within a party: address and, optionally, associated business unit and person. This class also supports the ISDA CSA representation as a single string, through the address attribute.
 */
export interface PartyContactInformation {
  /**
   * The reference to the party to which the contact information refers to.
   */
  partyReference?: ReferenceWithMeta<Party>;
  /**
   * The postal/street address, telephone number, email address and/or web page. If the contact information is specific to the associated business unit(s), it should be associated with those.
   */
  contactInformation?: ContactInformation;
  /**
   * Optional organization unit information used to describe the organization units (e.g. trading desks) involved in a transaction or business process, incl. the contact information (when relevant).
   */
  businessUnit?: BusinessUnit[];
  /**
   * Optional information about people involved in a transaction or business process. (These are employees of the party.)
   */
  person?: NaturalPerson[];
  /**
   * Specification of special instructions of the relevant party.
   */
  additionalInformation?: string;
}
  
/**
 * A class to specify a party-related, non-standardized data in a generic form.
 */
export interface PartyCustomisedWorkflow {
  /**
   * Reference to the party to which the workflow pertains to.
   */
  partyReference?: ReferenceWithMeta<Party>;
  /**
   * The party name to which the workflow pertains to.
   */
  partyName?: string;
  /**
   * Non-standardized data in a generic form.
   */
  customisedWorkflow?: CustomisedWorkflow[];
}
  
/**
 * Comprises an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the PartyIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 */
export interface PartyIdentifier {
  /**
   * Provides an identifier associated with a party. The identifier is unique within the public source specified in the source attribute.
   */
  identifier?: FieldWithMeta<String>;
  /**
   * Defines the source of the identifier.
   */
  identifierType?: PartyIdentifierTypeEnum;
  meta?: MetaFields;
}
  
/**
 * Specifies the parties responsible for making and receiving payments defined by this structure.
 */
export interface PartyReferencePayerReceiver {
  /**
   * The party responsible for making the payments defined by this structure.
   */
  payerPartyReference?: ReferenceWithMeta<Party>;
  /**
   * A reference to the account responsible for making the payments defined by this structure.
   */
  payerAccountReference?: ReferenceWithMeta<Account>;
  /**
   * The party that receives the payments corresponding to this structure.
   */
  receiverPartyReference?: ReferenceWithMeta<Party>;
  /**
   * A reference to the account that receives the payments corresponding to this structure.
   */
  receiverAccountReference?: ReferenceWithMeta<Account>;
}
  
/**
 * A class to specify the role(s) that party(ies) may have in relation to the execution, contract or other legal agreement.
 */
export interface PartyRole {
  /**
   * A reference to the party to which the role refers to.
   */
  partyReference?: ReferenceWithMeta<Party>;
  /**
   * The party role.
   */
  role?: PartyRoleEnum;
  /**
   * A reference to the party that has ownership of this party role information. FpML specifies that For shared trade information, this attribute will reference the originator of the data (for example, an execution facility or clearing house).
   */
  ownershipPartyReference?: ReferenceWithMeta<Party>;
}
  
/**
 * Type which contains pass through payments.
 */
export interface PassThrough {
  /**
   * One to many pass through payment items.
   */
  passThroughItem?: PassThroughItem[];
}
  
/**
 * Class to represent a single pass through payment.
 */
export interface PassThroughItem {
  /**
   * This attribute doesn't exists in the FpML construct, which makes use of the PayerReceiver.model group.
   */
  payerReceiver?: PayerReceiver;
  /**
   * Percentage of payments from the underlier which are passed through.
   */
  passThroughPercentage?: number;
}
  
/**
 * Specifies the parties responsible for making and receiving payments defined by this structure.
 */
export interface PayerReceiver {
  /**
   * Specifies the counterparty responsible for making the payments defined by this structure.  The party is one of the two principal parties to the transaction.
   */
  payer?: CounterpartyRoleEnum;
  /**
   * Specifies the party that receives the payments corresponding to this structure.  The party is one of the two counterparties to the transaction.
   */
  receiver?: CounterpartyRoleEnum;
}
  
/**
 * A data defining:  the adjusted payment date and associated calculation period parameters required to calculate the actual or projected payment amount. This data forms:  part of the cashflow representation of a swap stream.
 */
export interface PaymentCalculationPeriod {
  /**
   * The unadjusted payment date.
   */
  unadjustedPaymentDate?: Date;
  /**
   * The adjusted payment date. This date should already be adjusted for any applicable business day convention. This component is not intended for use in trade confirmation but may be specified to allow the fee structure to also serve as a cashflow type component.
   */
  adjustedPaymentDate?: Date;
  /**
   * The parameters used in the calculation of a fixed or floating rate calculation period amount. A list of calculation period elements may be ordered in the document by ascending start date. An FpML document which contains an unordered list of calculation periods is still regarded as a conformant document.
   */
  calculationPeriod?: CalculationPeriod[];
  /**
   * A known fixed payment amount.
   */
  fixedPaymentAmount?: Money;
  /**
   * A decimal value representing the discount factor used to calculate the present value of cash flow.
   */
  discountFactor?: number;
  /**
   * A monetary amount representing the forecast of the future value of the payment.
   */
  forecastPaymentAmount?: Money;
  /**
   * A monetary amount representing the present value of the forecast payment.
   */
  presentValueAmount?: Money;
  meta?: MetaFields;
}
  
/**
 * The payment dates when specified as relative to a set of dates specified somewhere else in the instance document/transaction, e.g. the valuation dates as typically the case for equity swaps, or when specified as a calculation period schedule.
 */
export interface PaymentDateSchedule {
  interimPaymentDates?: AdjustableRelativeOrPeriodicDates[];
  /**
   * The last payment when specified as an adjustable or relative date, as in the FpML total return construct.
   */
  finalPaymentDate?: AdjustableOrRelativeDate;
}
  
/**
 * Specifies the parameters to generate the payment date schedule, either through a parametric representation or by reference to specified dates.
 */
export interface PaymentDates {
  /**
   * The frequency at which regular payment dates occur. If the payment frequency is equal to the frequency defined in the calculation period dates component then one calculation period contributes to each payment amount. If the payment frequency is less frequent than the frequency defined in the calculation period dates component then more than one calculation period will contribute to the payment amount. A payment frequency more frequent than the calculation period frequency or one that is not a multiple of the calculation period frequency is invalid. If the payment frequency is of value T (term), the period is defined by the effectiveDate and the terminationDate.
   */
  paymentFrequency?: Frequency;
  /**
   * The first unadjusted payment date. This day may be subject to adjustment in accordance with any business day convention specified in paymentDatesAdjustments. This element must only be included if there is an initial stub. This date will normally correspond to an unadjusted calculation period start or end date. This is true even if early or delayed payment is specified to be applicable since the actual first payment date will be the specified number of days before or after the applicable adjusted calculation period start or end date with the resulting payment date then being adjusted in accordance with any business day convention specified in paymentDatesAdjustments.
   */
  firstPaymentDate?: Date;
  /**
   * The last regular payment date when specified as a date, as in the FpML interest rate construct. FpML specifies that this date may be subject to adjustment in accordance with any business day convention specified in the paymentDatesAdjustments attribute.
   */
  lastRegularPaymentDate?: Date;
  /**
   * The payment dates when specified as relative to a set of dates specified somewhere else in the instance document/transaction, e.g. the valuation dates as typically the case for equity swaps, or when specified as a calculation period schedule.
   */
  paymentDateSchedule?: PaymentDateSchedule;
  /**
   * Specifies whether the payments occur relative to each adjusted calculation period start date or end date, each reset date, valuation date or the last pricing date. Calculation period start date means relative to the start of the first calculation period contributing to a given payment. Similarly, calculation period end date means the end of the last calculation period contributing to a given payment. The valuation date is applicable for Brazilian-CDI and equity swaps.
   */
  payRelativeTo?: PayRelativeToEnum;
  /**
   * If early payment or delayed payment is required, specifies the number of days offset that the payment occurs relative to what would otherwise be the unadjusted payment date. The offset can be specified in terms of either calendar or business days. Even in the case of a calendar days offset, the resulting payment date, adjusted for the specified calendar days offset, will still be adjusted in accordance with the specified payment dates adjustments. This element should only be included if early or delayed payment is applicable, i.e. if the periodMultiplier element value is not equal to zero. An early payment would be indicated by a negative periodMultiplier element value and a delayed payment (or payment lag) would be indicated by a positive periodMultiplier element value.
   */
  paymentDaysOffset?: Offset;
  /**
   * The definition of the business day convention and financial business centers used for adjusting the payment date if it would otherwise fall on a day that is not a business day in the specified business center.
   */
  paymentDatesAdjustments?: BusinessDayAdjustments;
  meta?: MetaFields;
}
  
export interface PaymentDetail {
  paymentDate?: AdjustableOrRelativeDate;
  /**
   * The calculation rule.
   */
  paymentRule?: PaymentRule;
  /**
   * A fixed payment amount.
   */
  paymentAmount?: Money;
  meta?: MetaFields;
}
  
/**
 * This class corresponds to the FpML PaymentDiscounting.model group for representing the discounting elements that can be associated with a payment.
 */
export interface PaymentDiscounting {
  /**
   * The value representing the discount factor used to calculate the present value of the cash flow.
   */
  discountFactor?: number;
  /**
   * The amount representing the present value of the forecast payment.
   */
  presentValueAmount?: Money;
}
  
/**
 * A class defining the payment calculation rule. As of FpML 5.10, percentage rule is the only calculation rule that has been specified as part of the standard.
 */
export interface PaymentRule {
  /**
   * This attribute is not present as part of the FpML construct, as the payment rule is specialised by means of runtime type extension through the xsi:type.
   */
  percentageRule?: PercentageRule;
}
  
/**
 * Represents the set of future cashflow methodologies in the form of specific payout data type(s) which result from the financial product.  Examples: a trade in a cash asset will use only a settlement payout; for derivatives, two interest rate payouts can be combined to specify an interest rate swap; one interest rate payout can be combined with a credit default payout to specify a credit default swap.
 */
export interface Payout {
  /**
   * Defines the assets and movements in a security financing transaction.
   */
  assetPayout?: AssetPayout;
  /**
   * Defines the payout for the floating leg of a Commodity Swap.
   */
  commodityPayout?: CommodityPayout;
  /**
   * The credit default payout, which provides the details necessary for determining when a credit payout will be triggered as well as the parameters for calculating the payout and the settlement terms.
   */
  creditDefaultPayout?: CreditDefaultPayout;
  /**
   * Defines a payout in which one or more payouts are defined as a fixed price.
   */
  fixedPricePayout?: FixedPricePayout;
  /**
   * All of the terms necessary to define and calculate a cash flow based on a fixed, a floating or an inflation index rate. The interest rate payout can be applied to interest rate swaps and FRA (which both have two associated interest rate payouts), credit default swaps (to represent the fee leg when subject to periodic payments) and equity swaps (to represent the funding leg).
   */
  interestRatePayout?: InterestRatePayout;
  /**
   * The option payout.
   */
  optionPayout?: OptionPayout;
  /**
   * The performance payout, which encompasses the equity price returns, dividend returns, volatility return, variance return and correlation provisions.
   */
  performancePayout?: PerformancePayout;
  /**
   * Represents a forward settling payout. The 'Underlier' attribute captures the underlying payout, which is settled according to the 'SettlementTerms' attribute. Both FX Spot and FX Forward should use this component.
   */
  settlementPayout?: SettlementPayout;
  meta?: MetaFields;
}
  
/**
 * A data type that contains the common attributes (e.g. payer and receiver parties) and validation conditions that apply across all payout types
 */
export interface PayoutBase {
  /**
   * Canonical representation of the payer and receiver parties applicable to each payout leg.
   */
  payerReceiver?: PayerReceiver;
  /**
   * Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
   */
  priceQuantity?: ResolvablePriceQuantity;
  /**
   * The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
   */
  principalPayment?: PrincipalPayments;
  /**
   * Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
   */
  settlementTerms?: SettlementTerms;
}
  
/**
 * A class defining a content model for a calculation rule defined as percentage of the notional amount.
 */
export interface PercentageRule {
  /**
   * A percentage of the notional amount.
   */
  paymentPercent?: number;
  /**
   * A reference to the notional amount.
   */
  notionalAmountReference?: ReferenceWithMeta<Money>;
}
  
/**
 * Contains the necessary specifications for all performance payouts, encompassing equity return, dividend, variance, volatility and correlation products.
 */
export interface PerformancePayout extends PayoutBase {
  /**
   * Canonical representation of the payer and receiver parties applicable to each payout leg.
   */
  payerReceiver?: PayerReceiver;
  /**
   * Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
   */
  priceQuantity?: ResolvablePriceQuantity;
  /**
   * The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
   */
  principalPayment?: PrincipalPayments;
  /**
   * Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
   */
  settlementTerms?: SettlementTerms;
  /**
   * Defines how and when a performance type option or performance type swap is to be observed.
   */
  observationTerms?: ObservationTerms;
  /**
   * Defines how and when a performance type option or performance type swap is to be valued, including both interim and final valuation.
   */
  valuationDates?: ValuationDates;
  /**
   * Defines the payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the valuation dates).
   */
  paymentDates?: PaymentDates;
  /**
   * Identifies the underlying product that is referenced for pricing of the applicable leg in a swap.  Referenced in the '2018 ISDA CDM Equity Confirmation for Security Equity Swap' as Security.
   */
  underlier?: Underlier;
  /**
   * Defines quanto or composite FX features that are included in the swap leg.
   */
  fxFeature?: FxFeature[];
  /**
   * Specifies the type of return of a performance payout.
   */
  returnTerms?: ReturnTerms;
  /**
   * Specifies an individual type of return of a Performance Payout, when such individual return is part of an aggregation of multiple similar returns, at Performance Payout level
   */
  portfolioReturnTerms?: PortfolioReturnTerms[];
  /**
   * Specifies the net initial valuation price(s) of the underlier at Performance Payout level. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
   */
  initialValuationPrice?: ReferenceWithMeta<PriceSchedule>[];
  /**
   * Specifies the net initial valuation price(s) of the underlier at Performance Payout level. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
   */
  interimValuationPrice?: ReferenceWithMeta<PriceSchedule>[];
  /**
   * Specifies the net final valuation price(s) of the underlier at Performance Payout level. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
   */
  finalValuationPrice?: ReferenceWithMeta<PriceSchedule>[];
}
  
/**
 * Defines how and when a performance type option or performance type swap is to be valued.
 */
export interface PerformanceValuationDates {
  /**
   * Specifies the method according to which an amount or a date is determined.
   */
  determinationMethod?: DeterminationMethodEnum;
  /**
   * 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Pricing Date
   */
  valuationDates?: AdjustableRelativeOrPeriodicDates;
  /**
   * 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Pricing Date
   */
  valuationDate?: AdjustableOrRelativeDate;
  /**
   * The specific time of day at which the calculation agent values the underlying. The SpecificTime is the only case when the valuationTime (time + business center location  e.g. 10:00:00 USNY) should be provided. You should be able to provide just the valuationTime without valuationTimeType, which infer that this is a specific time.
   */
  valuationTime?: BusinessCenterTime;
  /**
   * The time of day at which the calculation agent values the underlying, for example the official closing time of the exchange.
   */
  valuationTimeType?: TimeTypeEnum;
  meta?: MetaFields;
}
  
/**
 * A class to define recurring periods or time offsets.
 */
export interface Period {
  /**
   * A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
   */
  periodMultiplier?: number;
  /**
   * A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
   */
  period?: PeriodEnum;
  meta?: MetaFields;
}
  
/**
 * Indicator to specify if the period bound is defined as a period and whether the bound is inclusive.
 */
export interface PeriodBound {
  /**
   * Specifies the period is to be used as the bound, e.g. 5Y.
   */
  period?: Period;
  /**
   * Specifies whether the period bound is inclusive, e.g. for a lower bound, false would indicate greater than, whereas true would indicate greater than or equal to.
   */
  inclusive?: boolean;
}
  
/**
 * Indicates The period range defined as either a lower and upper period bound, or both.
 */
export interface PeriodRange {
  /**
   * Specifies the lower bound of a period range, e.g. greater than or equal to 5Y.
   */
  lowerBound?: PeriodBound;
  /**
   * Specifies the upper bound of a period range, e.g. less than to 10Y.
   */
  upperBound?: PeriodBound;
}
  
/**
 * A class for specifying a calculation period schedule.
 */
export interface PeriodicDates {
  /**
   * The start date of the calculation period. FpML specifies that for interest rate swaps this date must only be specified if it is not equal to the effective date. It is always specified in the case of equity swaps and credit default swaps with periodic payments. This date may be subject to adjustment in accordance with a business day convention.
   */
  startDate?: AdjustableOrRelativeDate;
  /**
   * The end date of the calculation period. FpML specifies that for interest rate swaps this date must only be specified if it is not equal to the termination date. It is always specified in the case of equity swaps with periodic payments. This date may be subject to adjustment in accordance with a business day convention.
   */
  endDate?: AdjustableOrRelativeDate;
  /**
   * The frequency at which calculation period end dates occur with the regular part of the calculation period schedule and their roll date convention.
   */
  periodFrequency?: CalculationPeriodFrequency;
  /**
   * The specification of the business day convention and financial business centers used for adjusting any calculation period date if it would otherwise fall on a day that is not a business day in the specified business center.
   */
  periodDatesAdjustments?: BusinessDayAdjustments;
  /**
   * Denotes the enumerated values to specify the day type classification used in counting the number of days between two dates.
   */
  dayType?: DayTypeEnum;
}
  
/**
 * Comprises an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the PersonIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 */
export interface PersonIdentifier {
  /**
   * Provides an identifier associated with a person. The identifier is unique within the public source specified in the source attribute.
   */
  identifier?: FieldWithMeta<String>;
  /**
   * Defines the source of the identifier.
   */
  identifierType?: PersonIdentifierTypeEnum;
  /**
   * The ISO 3166 standard code for the country issuing the identifier.
   */
  country?: FieldWithMeta<String>;
  meta?: MetaFields;
}
  
export interface PhysicalSettlementPeriod {
  /**
   * An explicit indication that a number of business days are not specified and therefore ISDA fallback provisions should apply.
   */
  businessDaysNotSpecified?: boolean;
  /**
   * A number of business days. Its precise meaning is dependant on the context in which this element is used. ISDA 2003 Term: Business Day.
   */
  businessDays?: number;
  /**
   * A maximum number of business days. Its precise meaning is dependant on the context in which this element is used. Intended to be used to limit a particular ISDA fallback provision.
   */
  maximumBusinessDays?: number;
}
  
/**
 * Specifies Physical Settlement Terms characteristics for the settlement of a Credit Default Swap or Option.
 */
export interface PhysicalSettlementTerms {
  /**
   * Specifies whether the swap resulting from physical settlement of the swaption transaction will clear through a clearing house. The meaning of Cleared Physical Settlement is defined in the 2006 ISDA Definitions, Section 15.2 (published in Supplement number 28).
   */
  clearedPhysicalSettlement?: boolean;
  /**
   * Specifies the clearing organization (CCP, DCO) to which the trade should be cleared.
   */
  predeterminedClearingOrganizationParty?: AncillaryRoleEnum;
  /**
   * The number of business days used in the determination of the physical settlement date. The physical settlement date is this number of business days after all applicable conditions to settlement are satisfied. If a number of business days is not specified fallback provisions apply for determining the number of business days. If Section 8.5/8.6 of the 1999/2003 ISDA Definitions are to apply the businessDaysNotSpecified element should be included. If a specified number of business days are to apply these should be specified in the businessDays element. If Section 8.5/8.6 of the 1999/2003 ISDA Definitions are to apply but capped at a maximum number of business days then the maximum number should be specified in the maximumBusinessDays element. ISDA 2003 Term: Physical Settlement Period.
   */
  physicalSettlementPeriod?: PhysicalSettlementPeriod;
  /**
   * This element contains all the ISDA terms relevant to defining the deliverable obligations.
   */
  deliverableObligations?: DeliverableObligations;
  /**
   * If this element is specified and set to 'true', indicates that physical settlement must take place through the use of an escrow agent. (For Canadian counterparties this is always 'Not Applicable'. ISDA 2003 Term: Escrow.
   */
  escrow?: boolean;
  /**
   * If this element is specified and set to 'true', for a transaction documented under the 2003 ISDA Credit Derivatives Definitions, has the effect of incorporating the language set forth below into the confirmation. The section references are to the 2003 ISDA Credit Derivatives Definitions. Notwithstanding Section 1.7 or any provisions of Sections 9.9 or 9.10 to the contrary, but without prejudice to Section 9.3 and (where applicable) Sections 9.4, 9.5 and 9.6, if the Termination Date has not occurred on or prior to the date that is 60 Business Days following the Physical Settlement Date, such 60th Business Day shall be deemed to be the Termination Date with respect to this Transaction except in relation to any portion of the Transaction (an 'Affected Portion') in respect of which: (1) a valid notice of Buy-in Price has been delivered that is effective fewer than three Business Days prior to such 60th Business Day, in which case the Termination Date for that Affected Portion shall be the third Business Day following the date on which such notice is effective; or (2) Buyer has purchased but not Delivered Deliverable Obligations validly specified by Seller pursuant to Section 9.10(b), in which case the Termination Date for that Affected Portion shall be the tenth Business Day following the date on which Seller validly specified such Deliverable Obligations to Buyer.
   */
  sixtyBusinessDaySettlementCap?: boolean;
  meta?: MetaFields;
}
  
/**
 *  A Portfolio represents an aggregation of multiple Positions, by describing the parameters that this Portfolio should be aggregated based on. The resulting PortfolioState is calculated using these aggregation parameters as inputs, by aggregating all the Events that are relevant to this Portfolio. The concept of Portfolio works at all levels in the model: from the highest for a given LegalEntity for instance, to the lowest to account for security substitutions in a secutity financing transaction. As such, Portfolio can be used either above or below the Contract level.
 */
export interface Portfolio {
  /**
   * Describes the portfolio by describing how to aggregate all its relevant Events.
   */
  aggregationParameters?: AggregationParameters;
  /**
   * Describes the state of the Portfolio as a list of Positions resulting from the aggregation.
   */
  portfolioState?: PortfolioState;
}
  
/**
 * Specifies an individual type of return of a Performance Payout, when such individual return is part of an aggregation of multiple similar returns, at Performance Payout level.
 */
export interface PortfolioReturnTerms extends ReturnTerms {
  /**
   * Return terms based upon the underlier's observed price.
   */
  priceReturnTerms?: PriceReturnTerms;
  /**
   * Return terms based upon dividend payments associated to the underlier.
   */
  dividendReturnTerms?: DividendReturnTerms;
  /**
   * Return terms based upon the observed variance of the underlier's price.
   */
  varianceReturnTerms?: VarianceReturnTerms;
  /**
   * Return terms based upon the observed volatility of the underlier's price.
   */
  volatilityReturnTerms?: VolatilityReturnTerms;
  /**
   * Return terms based upon the observed correlation between the components of the underlying basket.
   */
  correlationReturnTerms?: CorrelationReturnTerms;
  /**
   * Canonical representation of the payer and receiver parties applicable to each individual return leg.
   */
  payerReceiver?: PayerReceiver;
  /**
   * Defines the product that is the subject of a tradable product definition, an underlying product definition, a physical exercise, a position, or other purposes.
   */
  underlier?: ReferenceWithMeta<Observable>;
  /**
   * Specifies a quantity schedule for the underlier, which applies to each individual return leg.
   */
  quantity?: ReferenceWithMeta<NonNegativeQuantitySchedule>;
  /**
   * Specifies the initial valuation price(s) of the underlier. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
   */
  initialValuationPrice?: ReferenceWithMeta<PriceSchedule>[];
  /**
   * Specifies the initial valuation price(s) of the underlier. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
   */
  interimValuationPrice?: ReferenceWithMeta<PriceSchedule>[];
  /**
   * 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Final Price | Specifies the final valuation price of the underlier. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
   */
  finalValuationPrice?: ReferenceWithMeta<PriceSchedule>[];
  meta?: MetaFields;
}
  
/**
 * State-full representation of a Portfolio that describes all the positions held at a given time, in various states which can be either traded, settled, etc., with lineage information to the previous state
 */
export interface PortfolioState {
  /**
   * The list of positions, each containing a Quantity and a Product.
   */
  positions?: Position[];
  /**
   * Pointer to the previous PortfolioState and new Event(s) leading to the current (new) state. Previous PortfolioState in the Lineage can be Null in case this is the start of the chain of Events.
   */
  lineage?: Lineage;
  meta?: MetaFields;
}
  
/**
 * A Position describes how much of a given Product is being held and constitutes the atomic element of a Portfolio.
 */
export interface Position {
  /**
   * Position with many price quantities.
   */
  priceQuantity?: PriceQuantity[];
  /**
   * The product underlying the position.
   */
  product?: Product;
  /**
   * The aggregate cost of proceeds
   */
  cashBalance?: Money;
  /**
   * Reference to the Contract, in case product is contractual and the contract has been formed
   */
  tradeReference?: ReferenceWithMeta<TradeState>;
}
  
/**
 * Defines a position identifier as a special case of the generic identifier type, that also includes the position identifier class.
 */
export interface PositionIdentifier extends Identifier {
  /**
   * The identifier issuer, when specified by reference to a party specified as part of the transaction.
   */
  issuerReference?: ReferenceWithMeta<Party>;
  /**
   * The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).
   */
  issuer?: FieldWithMeta<String>;
  /**
   * The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.
   */
  assignedIdentifier?: AssignedIdentifier[];
  meta?: MetaFields;
  /**
   * The enumerated classification of the identifier. Optional as a position identifier may be party-specific, in which case it may not correspond to any established classification.
   */
  identifierType?: TradeIdentifierTypeEnum;
}
  
/**
 * This class corresponds to the FpML Premium.model group for representing the option premium when expressed in a way other than an amount.
 */
export interface PremiumExpression {
  /**
   * Forward start premium type
   */
  premiumType?: PremiumTypeEnum;
  /**
   * The amount of premium to be paid expressed as a function of the number of options.
   */
  pricePerOption?: Money;
  /**
   * The amount of premium to be paid expressed as a percentage of the notional value of the transaction. A percentage of 5% would be expressed as 0.05.
   */
  percentageOfNotional?: number;
}
  
export interface Pric {
  pric?: Pric;
  bsisPts?: string;
}
  
/**
 * Specifies a price as a single value to be associated to a financial product. This data type extends PriceSchedule and requires that only the amount value exists.
 */
export interface Price extends PriceSchedule {
  /**
   * Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
   */
  value?: number;
  /**
   * Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
   */
  unit?: UnitType;
  /**
   * A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
   */
  datedValue?: DatedValue[];
  /**
   * Provides an attribute to define the unit of the thing being priced. For example, {amount, unitOfAmount, PerUnitOfAmount} = [10, EUR, Shares] = (10.00 EUR/SHARE) * (300,000 SHARES) = EUR 3,000,000.00 (Shares cancel out in the calculation).
   */
  perUnitOf?: UnitType;
  /**
   * Specifies the price type as an enumeration: interest rate, exchange rate, asset price etc. This attribute is mandatory so that prices can always be clasiffied according to their type. The price type implies some constraints on the price's units.
   */
  priceType?: PriceTypeEnum;
  /**
   * (Optionally) Specifies whether the price is expressed in absolute or percentage terms.
   */
  priceExpression?: PriceExpressionEnum;
  /**
   * (Optionally) Specifies the underlying price components if the price can be expressed as a composite: e.g. dirty price = clean price + accrued.
   */
  composite?: PriceComposite;
  /**
   * (Optionally) When the price is to be understood as an operator to apply to an observable, i.e. a spread, multiplier or min/max.
   */
  arithmeticOperator?: ArithmeticOperationEnum;
  /**
   * (Optionally when the price type is cash) Additional attributes that further define a cash price, e.g. what type of fee it is.
   */
  cashPrice?: CashPrice;
}
  
/**
 * Defines the inputs required to calculate a price as a simple composite of 2 other values. The inputs consist of 2 numbers and a simple arithmetic operator. This generic data type applies to a variety of use cases where a price is obtained by simple composition, e.g. dirty = clean + accrued (Bond), forward rate = spot rate + forward point (FX) etc.
 */
export interface PriceComposite {
  /**
   * The 1st value in the arithmetic operation, which may be non-commutative in some cases: Subtract, Divide). This 1st operand is called 'baseValue' as it refers to the price anchor in the arithmetic operation: e.g. the clean price (Bond) or the spot rate (FX).
   */
  baseValue?: number;
  /**
   * The 2nd value in the arithmetic operation, which may be non-commutative in some cases: Subtract, Divide). The 2nd operand is called 'operand' to distinguish it from the 1st one which is the price anchor.
   */
  operand?: number;
  /**
   * Specifies the arithmetic operator via an enumeration.
   */
  arithmeticOperator?: ArithmeticOperationEnum;
  /**
   * Optionally qualifies the type of operand: e.g. accrued or forward point.
   */
  operandType?: PriceOperandEnum;
}
  
/**
 * Defines a settlement as an exchange between two parties of a specified quantity of an asset (the quantity) against a specified quantity of another asset (the price). The settlement is optional and can be either cash or physical. The quantity can additionally be specified in terms of one or more currency amounts. In the case of non-cash products, the settlement of the price/quantity would not be specified here and instead would be delegated to the product mechanics, as parameterised by the price/quantity values.
 */
export interface PriceQuantity {
  /**
   * Specifies a price to be used for trade amounts and other purposes.
   */
  price?: FieldWithMeta<PriceSchedule>[];
  /**
   * Specifies a quantity to be associated with an event, for example a trade amount.
   */
  quantity?: FieldWithMeta<NonNegativeQuantitySchedule>[];
  /**
   * Specifies the object to be observed for a price, it could be an asset or an index. The cardinality is optional as some quantity / price cases have no observable (e.g. a fixed rate in a given currency).
   */
  observable?: FieldWithMeta<Observable>;
  /**
   * Specifies the date at which the price and quantity become effective. This day may be subject to adjustment in accordance with a business day convention, or could be specified as relative to a trade date, for instance. Optional cardinality, as the effective date is usually specified in the product definition, so it may only need to be specified as part of the PriceQuantity in an increase/decrease scenario for an existing trade.
   */
  effectiveDate?: AdjustableOrRelativeDate;
  meta?: MetaFields;
}
  
export interface PriceReturnTerms {
  /**
   * The type of return associated with the equity swap.
   */
  returnType?: ReturnTypeEnum;
  /**
   * Defines the conversion applied if the quantity unit on contract is different from unit on referenced underlier.
   */
  conversionFactor?: number;
  /**
   * Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.
   */
  performance?: string;
}
  
/**
 * Specifies the price of a financial instrument in a trade as a schedule of measures. A price generically expresses the value of an exchange as a ratio: it measures the amount of one thing needed to be exchanged for 1 unit of another thing (e.g. cash in a specific currency in exchange for a bond or share). This generic representation can be used to support any type of financial price beyond just cash price: e.g. an interest rate, a foreign exchange rate, etc. This data type is generically based on a schedule and can also be used to represent a price as a single value.
 */
export interface PriceSchedule extends MeasureSchedule {
  /**
   * Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
   */
  value?: number;
  /**
   * Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
   */
  unit?: UnitType;
  /**
   * A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
   */
  datedValue?: DatedValue[];
  /**
   * Provides an attribute to define the unit of the thing being priced. For example, {amount, unitOfAmount, PerUnitOfAmount} = [10, EUR, Shares] = (10.00 EUR/SHARE) * (300,000 SHARES) = EUR 3,000,000.00 (Shares cancel out in the calculation).
   */
  perUnitOf?: UnitType;
  /**
   * Specifies the price type as an enumeration: interest rate, exchange rate, asset price etc. This attribute is mandatory so that prices can always be clasiffied according to their type. The price type implies some constraints on the price's units.
   */
  priceType?: PriceTypeEnum;
  /**
   * (Optionally) Specifies whether the price is expressed in absolute or percentage terms.
   */
  priceExpression?: PriceExpressionEnum;
  /**
   * (Optionally) Specifies the underlying price components if the price can be expressed as a composite: e.g. dirty price = clean price + accrued.
   */
  composite?: PriceComposite;
  /**
   * (Optionally) When the price is to be understood as an operator to apply to an observable, i.e. a spread, multiplier or min/max.
   */
  arithmeticOperator?: ArithmeticOperationEnum;
  /**
   * (Optionally when the price type is cash) Additional attributes that further define a cash price, e.g. what type of fee it is.
   */
  cashPrice?: CashPrice;
}
  
/**
 * Specifies a publication that provides the commodity price, including, where applicable, the details of where in the publication the price is published.
 */
export interface PriceSource {
  /**
   * Defines a publication in which the price can be found. (e.g Gas Daily, Platts Bloomberg. Commodity publishers can be found at this URL:  http://www.fpml.org/coding-scheme/commodity-information-provider>
   */
  pricePublisher?: FieldWithMeta<String>;
  /**
   * Specifies the location of the price which may be a specific page, electornic screen name, or a code (e.g. a RIC code) where the price can be found.
   */
  priceSourceLocation?: string;
  /**
   * Specifies the heading or field name for the price  on a given page or screen, where applicable.
   */
  priceSourceHeading?: string;
  /**
   * Specifies the time at which the price should be observed.
   */
  priceSourceTime?: string;
}
  
/**
 * A data defining:  the parameters used to get a price quote to replace the settlement rate option that is disrupted.
 */
export interface PriceSourceDisruption {
  /**
   * The method, prioritised by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
   */
  fallbackReferencePrice?: FallbackReferencePrice;
}
  
/**
 * Specifies specific dates or parametric rules for the dates on which the price will be determined
 */
export interface PricingDates {
  /**
   * Defines specified dates on which the price will be determined.
   */
  specifiedDates?: AdjustableDates[];
  /**
   * Defines rules for the dates on which the price will be determined.
   */
  parametricDates?: ParametricDates;
}
  
/**
 * A Primitive Instruction describes the inputs required to pass into the corresponding PrimitiveEvent function.
 */
export interface PrimitiveInstruction {
  /**
   * Specifies instructions describing an contract formation primitive event.
   */
  contractFormation?: ContractFormationInstruction;
  /**
   * Specifies instructions describing an execution primitive event.
   */
  execution?: ExecutionInstruction;
  /**
   * Specifies instructions describing an exercise primitive event.
   */
  exercise?: ExerciseInstruction;
  /**
   * Specifies instructions describing a party change primitive event.
   */
  partyChange?: PartyChangeInstruction;
  /**
   * Specifies instructions describing an quantity change primitive event.
   */
  quantityChange?: QuantityChangeInstruction;
  /**
   * Specifies instructions describing a reset event.
   */
  reset?: ResetInstruction;
  /**
   * Specifies instructions to split a trade into multiple branches.
   */
  split?: SplitInstruction;
  /**
   * Specifies instructions describing a terms change primitive event.
   */
  termsChange?: TermsChangeInstruction;
  /**
   * Specifies instructions describing a transfer primitive event.
   */
  transfer?: TransferInstruction;
  /**
   * Specifies inputs needed to process a Index Transition business event.
   */
  indexTransition?: IndexTransitionInstruction;
  /**
   * Specifies inputs needed to process a Stock Split business event.
   */
  stockSplit?: StockSplitInstruction;
  /**
   * Specifies inputs needed to process an observation.
   */
  observation?: ObservationInstruction;
  /**
   * Specifies inputs needed to process an update of a valuation.
   */
  valuation?: ValuationInstruction;
}
  
/**
 * Any kind of principal payments when the amount is known and thus fixed.
 */
export interface PrincipalPayment {
  /**
   * The date where the PrincipalPayment shall be settled.
   */
  principalPaymentDate?: AdjustableDate;
  /**
   * Specifies the parties responsible for making and receiving payments defined by this structure.
   */
  payerReceiver?: PayerReceiver;
  /**
   * When known at the time the transaction is made, the cash amount to be paid.
   */
  principalAmount?: Money;
  /**
   * The value representing the discount factor used to calculate the present value of the principal payment amount.
   */
  discountFactor?: number;
  /**
   * The amount representing the present value of the principal payment.
   */
  presentValuePrincipalAmount?: Money;
  meta?: MetaFields;
}
  
/**
 * Describe dates schedules for Principal Exchanges and related role of the parties when known.
 */
export interface PrincipalPaymentSchedule {
  /**
   * Principal Payment made at Trade inception.
   */
  initialPrincipalPayment?: PrincipalPayment;
  /**
   * Principal Payment as part of the Trade lifecycle e.g. as part of notional reset adjustements in a Cross Currency Swap with a varying notional leg.
   */
  intermediatePrincipalPayment?: AdjustableRelativeOrPeriodicDates;
  /**
   * Principal Payment at Trade maturity
   */
  finalPrincipalPayment?: PrincipalPayment;
}
  
/**
 * A class defining which principal exchanges occur for the stream.
 */
export interface PrincipalPayments {
  /**
   * A true/false flag to indicate whether there is an initial exchange of principal on the effective date.
   */
  initialPayment?: boolean;
  /**
   * A true/false flag to indicate whether there is a final exchange of principal on the termination date.
   */
  finalPayment?: boolean;
  /**
   * A true/false flag to indicate whether there are intermediate or interim exchanges of principal during the term of the swap.
   */
  intermediatePayment?: boolean;
  /**
   * Indicate the Payout legs which nominal amount may vary in regards of FX Fixing dates as determined in the product terms.
   */
  varyingLegNotionalCurrency?: string[];
  /**
   * Describe dates schedules for Principal Exchanges and related role of the parties when known.
   */
  principalPaymentSchedule?: PrincipalPaymentSchedule;
  meta?: MetaFields;
}
  
/**
 * Enables either a TransferableProduct or a NonTransferableProduct to be used in an underlier.
 */
export interface Product {
  /**
   * A TransferableProduct is a type of financial product which can be held or transferred, represented as an Asset with the addition of specific EconomicTerms.
   */
  transferableProduct?: TransferableProduct;
  /**
   * The non-transferable product data type represents a product that can be traded (as part of a TradableProduct) but cannot be transferred to others.
   */
  nonTransferableProduct?: NonTransferableProduct;
}
  
/**
 * Comprises an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the ProductIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 */
export interface ProductIdentifier {
  /**
   * Provides an identifier associated with a specific product.  The identifier is unique within the public source specified in the source attribute.
   */
  identifier?: FieldWithMeta<String>;
  /**
   * Defines the source of the identifier.
   */
  source?: ProductIdTypeEnum;
  meta?: MetaFields;
}
  
/**
 * Specifies the product taxonomy, which is composed of a taxonomy value and a taxonomy source.
 */
export interface ProductTaxonomy extends Taxonomy {
  /**
   * The source of the taxonomy that defines the rules for classifying the object. The taxonomy source is taken from a enumerated list of taxonomy names. Optional as the taxonomy source may not be provided.
   */
  source?: TaxonomySourceEnum;
  /**
   * The value according to that taxonomy. Optional as it may not be possible to classify the object in that taxonomy.
   */
  value?: TaxonomyValue;
  /**
   * Classifies the most important risk class of the trade.
   */
  primaryAssetClass?: FieldWithMeta<AssetClassEnum>;
  /**
   *  Classifies additional risk classes of the trade, if any.
   */
  secondaryAssetClass?: FieldWithMeta<AssetClassEnum>[];
  /**
   * Derived from the product payout features using a CDM product qualification function that determines the product type based on the product payout features.
   */
  productQualifier?: string;
}
  
/**
 * A class to specify the terms for calculating a payout to protect the buyer of the swap in the case of a qualified credit event. These terms include the applicable credit events, the reference obligation, and in the case of a CDS on mortgage-backed securities, the floatingAmountEvents.
 */
export interface ProtectionTerms {
  /**
   * Specifies the applicable Credit Events that would trigger a settlement, as specified in the related Confirmation and defined in the ISDA 2014 Credit Definition article IV section 4.1.
   */
  creditEvents?: CreditEvents;
  /**
   * The underlying obligations of the reference entity on which you are buying or selling protection. The credit events Failure to Pay, Obligation Acceleration, Obligation Default, Restructuring, Repudiation/Moratorium are defined with respect to these obligations.
   */
  obligations?: Obligations;
  /**
   * This element contains the ISDA terms relating to the floating rate payment events and the implied additional fixed payments, applicable to the credit derivatives transactions on mortgage-backed securities with pay-as-you-go or physical settlement.
   */
  floatingAmountEvents?: FloatingAmountEvents;
  meta?: MetaFields;
}
  
export interface Prsn {
  ctryOfBrnch?: string;
  othr?: Othr;
}
  
export interface PubliclyAvailableInformation {
  /**
   * If this element is specified and set to 'true', indicates that ISDA defined Standard Public Sources are applicable.
   */
  standardPublicSources?: boolean;
  /**
   * A public information source, e.g. a particular newspaper or electronic news service, that may publish relevant information used in the determination of whether or not a credit event has occurred. ISDA 2003 Term: Public Source.
   */
  publicSource?: string[];
  /**
   * The minimum number of the specified public information sources that must publish information that reasonably confirms that a credit event has occurred. The market convention is two. ISDA 2003 Term: Specified Number.
   */
  specifiedNumber?: number;
}
  
export interface Qty {
  unit?: string;
}
  
/**
 * Specifies a quantity as a single value to be associated to a financial product, for example a transfer amount resulting from a trade. This data type extends QuantitySchedule and requires that only the single amount value exists.
 */
export interface Quantity extends QuantitySchedule {
  /**
   * Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
   */
  value?: number;
  /**
   * Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
   */
  unit?: UnitType;
  /**
   * A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
   */
  datedValue?: DatedValue[];
  /**
   * Defines an optional number that the quantity should be multiplied by to derive a total quantity. This number is associated to a unit. For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unit would be contracts, the multiplier value would 1,000 and the mulitiplier unit would be 1,000 MT (Metric Tons).
   */
  multiplier?: Measure;
  /**
   * Defines the frequency to be used when defining a quantity. For example a quantity may be specified as a number of barrels of oil per day, which needs multiplying by the number of days in the relevant period to get the total quantity as a number of barrels.
   */
  frequency?: Frequency;
}
  
/**
 * Instructions required to create a Quantity Change Primitive Event, which can be either an increase, a decrease or a replacement. An increase adds a new trade lot to the original trade, whereas a decrease subtracts from an existing trade lot's quantity. A replacement updates the quantity of an existing trade lot to the new value.
 */
export interface QuantityChangeInstruction {
  /**
   * Quantity by which the trade is being increased, decreased or replaced, and the price at which such quantity change is agreed. The quantity change should always be specified as a positive number, with the direction (increase/decrease/replacement) being specified by the direction enumeration. A fee can also be associated to the quantity change by specifying a Price component of type CashPrice, including the corresponding settlement date and direction.
   */
  change?: PriceQuantity[];
  /**
   * Direction of the quantity change specified as either an increase, decrease or replacement.
   */
  direction?: QuantityChangeDirectionEnum;
  /**
   * Identifier for the new lot (in case of increase) or for the existing lot to be changed(in case of decrease or replacement). This optional attribute is mandatory in case of a decrease or replacement if the initial trade state contains multiple trade lots.
   */
  lotIdentifier?: Identifier[];
}
  
/**
 *  Class to specify a mechanism for a quantity to be set as a multiplier to another (reference) quantity, based on a price observation. At the moment this class only supports FX or Equity-linked notional and re-uses existing building blocks for those 2 cases, until such time when component can be made more generic. This captures the case of resetting cross-currency swaps and resetting equity swaps.
 */
export interface QuantityMultiplier {
  /**
   * Multiplier specified as an FX-linked schedule, e.g. for a resetting cross-currency swap..
   */
  fxLinkedNotionalSchedule?: FxLinkedNotionalSchedule;
  multiplierValue?: number;
}
  
/**
 * Specifies a quantity schedule to be associated to a financial product to represent a trade amount. This data type extends MeasureSchedule with several unit or multiplier attributes that are used to define financial quantities. This data type is generically based on a schedule and can also be used to represent a quantity as a single value.
 */
export interface QuantitySchedule extends MeasureSchedule {
  /**
   * Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
   */
  value?: number;
  /**
   * Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
   */
  unit?: UnitType;
  /**
   * A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
   */
  datedValue?: DatedValue[];
  /**
   * Defines an optional number that the quantity should be multiplied by to derive a total quantity. This number is associated to a unit. For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unit would be contracts, the multiplier value would 1,000 and the mulitiplier unit would be 1,000 MT (Metric Tons).
   */
  multiplier?: Measure;
  /**
   * Defines the frequency to be used when defining a quantity. For example a quantity may be specified as a number of barrels of oil per day, which needs multiplying by the number of days in the relevant period to get the total quantity as a number of barrels.
   */
  frequency?: Frequency;
}
  
/**
 * Determines the currency rate that the seller of the equity amounts will apply at each valuation date for converting the respective amounts into a currency that is different from the currency denomination of the underlier.
 */
export interface Quanto {
  /**
   * Specifies a currency conversion rate.
   */
  fxRate?: FxRate[];
  /**
   * Specifies the methodology (reference source and, optionally, fixing time) to be used for determining a currency conversion rate.
   */
  fxSpotRateSource?: FxSpotRateSource;
  /**
   * The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
   */
  fixingTime?: BusinessCenterTime;
}
  
/**
 * Represents a class to allow specification of different types of Quasi Government collateral.
 */
export interface QuasiGovernmentIssuerType {
  /**
   * True if sovereign entity (e.g. not separate legal personality from sovereign) or false if non-sovereign entity (e.g. separate legal personality from sovereign).
   */
  sovereignEntity?: boolean;
  /**
   * Applies to non-sovereign entity (e.g. separate legal personality from sovereign).  True if entity has recourse to sovereign (e.g. debt guaranteed by government).  False if entity does not have recourse to sovereign.
   */
  sovereignRecourse?: boolean;
}
  
/**
 * A class that describes the composition of a rate that has been quoted or is to be quoted. This includes the two currencies and the quotation relationship between the two currencies and is used as a building block throughout the FX specification.
 */
export interface QuotedCurrencyPair {
  /**
   * The first currency specified when a pair of currencies is to be evaluated.
   */
  currency1?: FieldWithMeta<String>;
  /**
   * The second currency specified when a pair of currencies is to be evaluated.
   */
  currency2?: FieldWithMeta<String>;
  /**
   * The method by which the exchange rate is quoted.
   */
  quoteBasis?: QuoteBasisEnum;
}
  
/**
 * A class defining parameters associated with an individual observation or fixing. This class forms part of the cashflow representation of a stream.
 */
export interface RateObservation {
  /**
   * The reset date.
   */
  resetDate?: Date;
  /**
   * The adjusted fixing date, i.e. the actual date the rate is observed. The date should already be adjusted for any applicable business day convention.
   */
  adjustedFixingDate?: Date;
  /**
   * The actual observed rate before any required rate treatment is applied, e.g. before converting a rate quoted on a discount basis to an equivalent yield. An observed rate of 5% would be represented as 0.05.
   */
  observedRate?: number;
  /**
   * The observed rate after any required rate treatment is applied. A treated rate of 5% would be represented as 0.05.
   */
  treatedRate?: number;
  /**
   * The number of days weighting to be associated with the rate observation, i.e. the number of days such rate is in effect. This is applicable in the case of a weighted average method of calculation where more than one reset date is established for a single calculation period.
   */
  observationWeight?: number;
  /**
   * A pointer style reference to a floating rate component defined as part of a stub calculation period amount component. It is only required when it is necessary to distinguish two rate observations for the same fixing date which could occur when linear interpolation of two different rates occurs for a stub calculation period.
   */
  rateReference?: ReferenceWithMeta<RateObservation>;
  /**
   * The value representing the forecast rate used to calculate the forecast future value of the accrual period.A value of 1% should be represented as 0.01.
   */
  forecastRate?: number;
  /**
   * The value representing the forecast rate after applying rate treatment rules. A value of 1% should be represented as 0.01.
   */
  treatedForecastRate?: number;
  meta?: MetaFields;
}
  
/**
 * A class defining a schedule of rates or amounts in terms of an initial value and then a series of step date and value pairs. On each step date the rate or amount changes to the new step value. The series of step date and value pairs are optional. If not specified, this implies that the initial value remains unchanged over time.
 */
export interface RateSchedule {
  /**
   * The initial rate. An initial rate of 5% would be represented as 0.05.
   */
  price?: ReferenceWithMeta<PriceSchedule>;
}
  
/**
 *  A data type to specify the fixed interest rate, floating interest rate or inflation rate.
 */
export interface RateSpecification {
  /**
   * The fixed rate or fixed rate specification expressed as explicit fixed rates and dates.
   */
  fixedRateSpecification?: FixedRateSpecification;
  /**
   * The floating interest rate specification, which includes the definition of the floating rate index. the tenor, the initial value, and, when applicable, the spread, the rounding convention, the averaging method and the negative interest rate treatment.
   */
  floatingRateSpecification?: FloatingRateSpecification;
  /**
   * An inflation rate calculation definition.
   */
  inflationRateSpecification?: InflationRateSpecification;
}
  
export interface RefRate {
  indx?: string;
  nm?: string;
}
  
/**
 * A class to describe an institution (party) identified by means of a coding scheme and an optional name.
 */
export interface ReferenceBank {
  /**
   * An institution (party) identifier, e.g. a bank identifier code (BIC). FpML specifies a referenceBankIdScheme.
   */
  referenceBankId?: FieldWithMeta<String>;
  /**
   * The name of the institution (party). A free format string. FpML does not define usage rules for the element.
   */
  referenceBankName?: string;
}
  
/**
 * A class defining the list of reference institutions polled for relevant rates or prices when determining the cash settlement amount for a product where cash settlement is applicable.
 */
export interface ReferenceBanks {
  /**
   * An institution (party) identified by means of a coding scheme and an optional name.
   */
  referenceBank?: ReferenceBank[];
}
  
/**
 * A class specifying the Credit Default Swap Reference Information.
 */
export interface ReferenceInformation {
  /**
   * The corporate or sovereign entity which is subject to the swap transaction and any successor that assumes all or substantially all of its contractual and other obligations. Reference Entities cannot be senior or subordinated. It is the obligations of the Reference Entities that can be senior or subordinated. ISDA 2014 Credit definitions article II section 2.1: `Reference Entity` means the entity specified as such in the related Confirmation.
   */
  referenceEntity?: LegalEntity;
  /**
   * The Reference Obligation is a financial instrument that is either issued or guaranteed by the reference entity. It serves to clarify the precise reference entity protection is being offered upon, and its legal position with regard to other related firms (parents/subsidiaries). Furthermore the Reference Obligation is ALWAYS deliverable and establishes the Pari Passu ranking (as the deliverable bonds must rank equal to the reference obligation). ISDA 2003 Term: Reference Obligation.
   */
  referenceObligation?: ReferenceObligation[];
  /**
   * Used to indicate that there is no Reference Obligation associated with this Credit Default Swap and that there will never be one.
   */
  noReferenceObligation?: boolean;
  /**
   * Used to indicate that the Reference obligation associated with the Credit Default Swap is currently not known. This is not valid for Legal Confirmation purposes, but is valid for earlier stages in the trade life cycle (e.g. Broker Confirmation).
   */
  unknownReferenceObligation?: boolean;
  /**
   * Indicates whether an obligation of the Reference Entity, guaranteed by the Reference Entity on behalf of a non-Affiliate, is to be considered an Obligation for the purpose of the transaction. It will be considered an obligation if allGuarantees is applicable (true) and not if allGuarantees is inapplicable (false). ISDA 2003 Term: All Guarantees.
   */
  allGuarantees?: boolean;
  /**
   * Used to determine (a) for physically settled trades, the Physical Settlement Amount, which equals the Floating Rate Payer Calculation Amount times the Reference Price and (b) for cash settled trades, the Cash Settlement Amount, which equals the greater of (i) the difference between the Reference Price and the Final Price and (ii) zero. ISDA 2003 Term: Reference Price.
   */
  referencePrice?: Price;
  /**
   * Applicable to the transactions on mortgage-backed security, which can make use of a reference policy. Presence of the element with value set to 'true' indicates that the reference policy is applicable; absence implies that it is not.
   */
  referencePolicy?: boolean;
  /**
   * With respect to any day, the list of Syndicated Secured Obligations of the Designated Priority of the Reference Entity published by Markit Group Limited or any successor thereto appointed by the Specified Dealers (the 'Secured List Publisher') on or most recently before such day, which list is currently available at [http://www.markit.com]. ISDA 2003 Term: Relevant Secured List.
   */
  securedList?: boolean;
}
  
/**
 * A class to specify the reference obligation that is associated with a credit derivative instrument.
 */
export interface ReferenceObligation {
  /**
   * Identifies the underlying asset when it is a security, such as a bond or convertible bond. The security data type requires one or more productIdentifiers, specificaiton of the security type (e.g. debt), and includes optional attributes to specify a debt class, such as asset-backed, as well as seniority.
   */
  security?: Security;
  /**
   * Identifies the underlying asset when it is a loan.
   */
  loan?: Loan;
  /**
   * The entity primarily responsible for repaying debt to a creditor as a result of borrowing or issuing bonds. ISDA 2003 Term: Primary Obligor.
   */
  primaryObligor?: LegalEntity;
  /**
   * A pointer style reference to a reference entity defined elsewhere in the document. Used when the reference entity is the primary obligor.
   */
  primaryObligorReference?: ReferenceWithMeta<LegalEntity>;
  /**
   * The party that guarantees by way of a contractual arrangement to pay the debts of an obligor if the obligor is unable to make the required payments itself. ISDA 2003 Term: Guarantor.
   */
  guarantor?: LegalEntity;
  /**
   * A pointer style reference to a reference entity defined elsewhere in the document. Used when the reference entity is the guarantor.
   */
  guarantorReference?: string;
  /**
   * Indicates if the reference obligation is a Standard Reference Obligation. ISDA 2014 Term: Standard Reference Obligation.
   */
  standardReferenceObligation?: boolean;
}
  
export interface ReferencePair {
  /**
   * The corporate or sovereign entity on which you are buying or selling protection and any successor that assumes all or substantially all of its contractual and other obligations. It is vital to use the correct legal name of the entity and to be careful not to choose a subsidiary if you really want to trade protection on a parent company. Please note, Reference Entities cannot be senior or subordinated. It is the obligations of the Reference Entities that can be senior or subordinated. ISDA 2003 Term: Reference Entity.
   */
  referenceEntity?: LegalEntity;
  /**
   * The Reference Obligation is a financial instrument that is either issued or guaranteed by the reference entity. It serves to clarify the precise reference entity protection is being offered upon, and its legal position with regard to other related firms (parents/subsidiaries). Furthermore the Reference Obligation is ALWAYS deliverable and establishes the Pari Passu ranking (as the deliverable bonds must rank equal to the reference obligation). ISDA 2003 Term: Reference Obligation.
   */
  referenceObligation?: ReferenceObligation;
  /**
   * Used to indicate that there is no Reference Obligation associated with this Credit Default Swap and that there will never be one.
   */
  noReferenceObligation?: boolean;
  /**
   * Defines the reference entity types corresponding to a list of types in the ISDA First to Default documentation.
   */
  entityType?: FieldWithMeta<EntityTypeEnum>;
}
  
/**
 * This type contains all the reference pool items to define the reference entity and reference obligation(s) in the basket.
 */
export interface ReferencePool {
  /**
   * This type contains all the constituent weight and reference information.
   */
  referencePoolItem?: ReferencePoolItem[];
}
  
/**
 * This type contains all the constituent weight and reference information.
 */
export interface ReferencePoolItem {
  /**
   * Describes the weight of each of the constituents within the basket. If not provided, it is assumed to be equal weighted.
   */
  constituentWeight?: ConstituentWeight;
  referencePair?: ReferencePair;
  /**
   * Reference to the documentation terms applicable to this item.
   */
  protectionTermsReference?: ReferenceWithMeta<ProtectionTerms>;
  /**
   * Reference to the cash settlement terms applicable to this item.
   */
  cashSettlementTermsReference?: ReferenceWithMeta<CashSettlementTerms>;
  /**
   * Reference to the physical settlement terms applicable to this item.
   */
  physicalSettlementTermsReference?: ReferenceWithMeta<PhysicalSettlementTerms>;
}
  
/**
 * A complex type used to specify the option and convertible bond option strike when expressed in reference to a swap curve.
 */
export interface ReferenceSwapCurve {
  swapUnwindValue?: SwapCurveValuation;
  /**
   * Amount to be paid by the buyer of the option if the option is exercised prior to the Early Call Date. (The market practice in the convertible bond option space being that the buyer should be penalised if he/she exercises the option early on.)
   */
  makeWholeAmount?: MakeWholeAmount;
}
  
/**
 * Represents a class to allow specification of different type of Regional government collateral.
 */
export interface RegionalGovernmentIssuerType {
  /**
   * Applies to regional governments, local authorities or municipals.  True if entity has recourse to sovereign (e.g. debt guaranteed by government).  False if entity does not have recourse to sovereign.
   */
  sovereignRecourse?: boolean;
}
  
export interface RelatedParty {
  /**
   * Reference to a party.
   */
  partyReference?: ReferenceWithMeta<Party>;
  /**
   * Reference to an account.
   */
  accountReference?: ReferenceWithMeta<Account>;
  /**
   * The category of the relationship. The related party performs the role specified in this field for the base party. For example, if the role is ,Guarantor, the related party acts as a guarantor for the base party.
   */
  role?: PartyRoleEnum;
}
  
/**
 * A class defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date). If the anchor date is itself an adjustable date then the offset is assumed to be calculated from the adjusted anchor date. A number of different scenarios can be supported, namely; 1) the derived date may simply be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date; 2) the unadjusted derived date may be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date with the resulting unadjusted derived date subject to adjustment in accordance with a specified business day convention, i.e. the derived date must fall on a good business day; 3) the derived date may be a number of business days preceding or following the anchor date. Note that the businessDayConvention specifies any required adjustment to the unadjusted derived date. A negative or positive value in the periodMultiplier indicates whether the unadjusted derived precedes or follows the anchor date. The businessDayConvention should contain a value NONE if the day type element contains a value of Business (since specifying a negative or positive business days offset would already guarantee that the derived date would fall on a good business day in the specified business centers).
 */
export interface RelativeDateOffset extends Offset {
  /**
   * A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
   */
  periodMultiplier?: number;
  /**
   * A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
   */
  period?: PeriodEnum;
  meta?: MetaFields;
  /**
   * In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
   */
  dayType?: DayTypeEnum;
  /**
   * The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
   */
  businessDayConvention?: BusinessDayConventionEnum;
  businessCenters?: BusinessCenters;
  /**
   * A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
   */
  businessCentersReference?: ReferenceWithMeta<BusinessCenters>;
  /**
   * Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
   */
  dateRelativeTo?: ReferenceWithMeta<Date>;
  /**
   * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
   */
  adjustedDate?: Date;
}
  
/**
 * A class describing a set of dates defined as relative to another set of dates.
 */
export interface RelativeDates extends RelativeDateOffset {
  /**
   * A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
   */
  periodMultiplier?: number;
  /**
   * A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
   */
  period?: PeriodEnum;
  meta?: MetaFields;
  /**
   * In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
   */
  dayType?: DayTypeEnum;
  /**
   * The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
   */
  businessDayConvention?: BusinessDayConventionEnum;
  businessCenters?: BusinessCenters;
  /**
   * A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
   */
  businessCentersReference?: ReferenceWithMeta<BusinessCenters>;
  /**
   * Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
   */
  dateRelativeTo?: ReferenceWithMeta<Date>;
  /**
   * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
   */
  adjustedDate?: Date;
  /**
   * The number of periods in the referenced date schedule that are between each date in the relative date schedule. Thus a skip of 2 would mean that dates are relative to every second date in the referenced schedule. If present this should have a value greater than 1.
   */
  periodSkip?: number;
  /**
   * The first and last dates of a schedule. This can be used to restrict the range of values in a reference series of dates.
   */
  scheduleBounds?: DateRange;
}
  
export interface Representations {
}
  
/**
 * Defines the reset value or fixing value produced in cashflow calculations, during the life-cycle of a financial instrument. The reset process defined in Create_Reset function joins product definition details with observations to compute the reset value.
 */
export interface Reset {
  /**
   * Specifies the reset or fixing value. The fixing value could be a cash price, interest rate, or other value.
   */
  resetValue?: Price;
  /**
   * Specifies the date on which the reset occurred.
   */
  resetDate?: Date;
  /**
   * Specifies the 'Rate Record Day' for a Fallback rate.  Fallback rate fixing processes typically set the fixing rate in arrears, i.e., the Fallback Rate corresponding to a Rate Record Date is set at the end of the interest accural period.  When this applies, Reset->resetDate occurs at the end of the interest period, and the Reset->rateRecordDate occurs near the start of the interest period.  The Reset->rateRecordDate and Reset->observations->observationIdentifier->observationDate will differ if a Fallback rate is unavailable on the Rate Record Date, and the latest previous available rate is used as the observation.
   */
  rateRecordDate?: Date;
  /**
   * Represents an audit of the observations used to produce the reset value. If multiple observations were necessary to produce the reset value, the aggregation method should be defined on the payout.
   */
  observations?: ReferenceWithMeta<Observation>[];
  /**
   * Identifies the aggregation method to use in the case where multiple observations are used to compute the reset value and the method is not defined in a payout.
   */
  averagingMethodology?: AveragingCalculation;
  meta?: MetaFields;
}
  
/**
 * A data defining:  the parameters used to generate the reset dates schedule and associated fixing dates. The reset dates are the dates on which the new index value (which is observed on the fixing date) is applied for each period and on which the interest rate hence begins to accrue.
 */
export interface ResetDates {
  /**
   * A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
   */
  calculationPeriodDatesReference?: ReferenceWithMeta<CalculationPeriodDates>;
  /**
   * Specifies whether the reset dates are determined with respect to each adjusted calculation period start date or adjusted calculation period end date. If the reset frequency is specified as daily this element must not be included.
   */
  resetRelativeTo?: ResetRelativeToEnum;
  /**
   * The initial fixing date.
   */
  initialFixingDate?: InitialFixingDate;
  /**
   * The fixing dates are the dates on which the index values are observed. The fixing dates are specified by reference to the reset date through business days offset and an associated set of financial business centers. Normally these offset calculation rules will be those specified in the ISDA definition for the relevant floating rate index (ISDA's Floating Rate Option). However, non-standard offset calculation rules may apply for a trade if mutually agreed by the principal parties to the transaction.
   */
  fixingDates?: RelativeDateOffset;
  /**
   * This attribute is not part of the FpML ResetDate, and has been added as part of the CDM to support the credit derivatives final fixing date.
   */
  finalFixingDate?: AdjustableDate;
  /**
   * Specifies the number of business days before the period end date when the rate cut-off date is assumed to apply. The financial business centers associated with determining the rate cut-off date are those specified in the reset dates adjustments. The rate cut-off number of days must be a negative integer (a value of zero would imply no rate cut off applies in which case the rateCutOffDaysOffset element should not be included). The relevant rate for each reset date in the period from, and including, a rate cut-off date to, but excluding, the next applicable period end date (or, in the case of the last calculation period, the termination date) will (solely for purposes of calculating the floating amount payable on the next applicable payment date) be deemed to be the relevant rate in effect on that rate cut-off date. For example, if rate cut-off days for a daily averaging deal is -2 business days, then the refix rate applied on (period end date - 2 days) will also be applied as the reset on (period end date - 1 day), i.e. the actual number of reset dates remains the same but from the rate cut-off date until the period end date, the same refix rate is applied. Note that in the case of several calculation periods contributing to a single payment, the rate cut-off is assumed only to apply to the final calculation period contributing to that payment. The day type associated with the offset must imply a business days offset.
   */
  rateCutOffDaysOffset?: Offset;
  /**
   * The frequency at which the reset dates occur. In the case of a weekly reset frequency, also specifies the day of the week that the reset occurs. If the reset frequency is greater than the calculation period frequency then this implies that more than one reset is established for each calculation period and some form of rate averaging is applicable.
   */
  resetFrequency?: ResetFrequency;
  /**
   * The definition of the business day convention and financial business centers used for adjusting the reset date if it would otherwise fall on a day that is not a business day in the specified business center.
   */
  resetDatesAdjustments?: BusinessDayAdjustments;
  meta?: MetaFields;
}
  
/**
 * A class defining the reset frequency. In the case of a weekly reset, also specifies the day of the week that the reset occurs. If the reset frequency is greater than the calculation period frequency the this implies that more or more reset dates is established for each calculation period and some form of rate averaging is applicable. The specific averaging method of calculation is specified in FloatingRateCalculation. In case the reset frequency is of value T (term), the period is defined by the swap/swapStream/calculationPerioDates/effectiveDate and the swap/swapStream/calculationPerioDates/terminationDate.
 */
export interface ResetFrequency extends Frequency {
  /**
   * A time period multiplier, e.g. 1, 2, or 3. If the period value is T (Term) then period multiplier must contain the value 1.
   */
  periodMultiplier?: number;
  /**
   * A time period, e.g. a day, week, month, year or term of the stream.
   */
  period?: PeriodExtendedEnum;
  meta?: MetaFields;
  /**
   * The day of the week on which a weekly reset date occurs. This element must be included if the reset frequency is defined as weekly and not otherwise.
   */
  weeklyRollConvention?: WeeklyRollConventionEnum;
}
  
/**
 * Defines the information needed to create a Reset Business Event. 
 */
export interface ResetInstruction {
  payout?: ReferenceWithMeta<Payout>[];
  /**
   * Specifies the 'Rate Record Day' for a Fallback rate.  Fallback rate fixing processes typically set the fixing rate in arrears, i.e., the Fallback Rate corresponding to a Rate Record Date is set at the end of the interest accural period.  When this applies, Reset->resetDate occurs at the end of the interest period, and the Reset->rateRecordDate occurs near the start of the interest period.  The Reset->rateRecordDate and Reset->observations->observationIdentifier->observationDate will differ if a Fallback rate is unavailable on the Rate Record Date, and the latest previous available rate is used as the observation.
   */
  rateRecordDate?: Date;
  /**
   * Specifies the date on which the reset is occuring.
   */
  resetDate?: Date;
}
  
/**
 * Generic class to specify the quantity for different payout legs in a contractual product, when that quantity can vary across payout legs or across time. A resolvable quantity can always be resolved into a single quantity from the quantity notation which has a corresponding asset identifier. In addition to the base case, where quantity is directly specified as a number as part of the quantity notation, the other use cases are: (i) quantity based on some pre-defined schedule (eg amortising notional), (ii) quantity based on some pre-defined events (eg resetting cross-currency notional), or quantity set as reference to another quantity (eg equity notional as no. securities x price).
 */
export interface ResolvablePriceQuantity {
  /**
   * A product's quantity as a single, non-negative amount.  When specified as part of a product definition, this quantity attribute would not be set.  Instead it is specified on the quantity notation along with an asset identifier matching this payout's asset identifier.  This allows the quantity to be resolved for a payout leg, which can then be specified here for convenience during data processing.  There needs to be at least one resolvable quantity across payout legs of a product to define an anchor that other payout quantities can refer to.  This attribute is ignored when mapping existing FpML messages.
   */
  resolvedQuantity?: Quantity;
  /**
   * A payout's quantity specified as a schedule, which may also contain a single value if that quantity is constant. There can only be a single quantity schedule applicable to a payout: e.g. the notional for an interest rate leg. The quantity must be specified outside of the payout in a PriceQuantity object and only referenced inside the payout using an address.
   */
  quantitySchedule?: ReferenceWithMeta<NonNegativeQuantitySchedule>;
  /**
   * Reference quantity when resolvable quantity is defined as relative to another (resolvable) quantity. A resolvable quantity needs to contain either an absolute quantity or a reference to another (resolvable) quantity. This requirement is captured by a choice rule on the class.
   */
  quantityReference?: ReferenceWithMeta<ResolvablePriceQuantity>;
  /**
   * Quantity multiplier is specified on top of a reference quantity and is used as a multiplying factor when resolving the quantity. A quantity multiplier can only exist when the resolvable quantity specifies a reference quantity.
   */
  quantityMultiplier?: QuantityMultiplier;
  /**
   * Whether the quantity is resettable
   */
  reset?: boolean;
  /**
   * The future value notional is specific to BRL CDI swaps, and is specified alongside the notional amount. The value is calculated as follows: Future Value Notional = Notional Amount * (1 + Fixed Rate) ^ (Fixed Rate Day Count Fraction). The currency should always match that expressed in the notional schedule. The value date should match the adjusted termination date.
   */
  futureValueNotional?: FutureValueAmount;
  /**
   * A payout's price specified as a schedule, which may also contain a single value if that price is constant. There may be multiple prices specified for a single payout: e.g. a floating interest rate leg may specify a spread, a cap and/or floor and a multiplier. The price must be specified outside of the payout in a PriceQuantity object and only referenced inside the payout using an address.
   */
  priceSchedule?: ReferenceWithMeta<PriceSchedule>[];
  meta?: MetaFields;
}
  
/**
 * Describes the resource that contains the media representation of a business event (i.e used for stating the Publicly Available Information). For example, can describe a file or a URL that represents the event. This type is an extended version of a type defined by RIXML (www.rixml.org).  Rosetta restricts the FpML implementation by not providing the ability to associated a document in hexadecimalBinary or base64Binary until such time that actual use cases will come up.
 */
export interface Resource {
  /**
   * The unique identifier of the resource within the event. FpML specifies this element of type resourceIdScheme but with no specified value.
   */
  resourceId?: FieldWithMeta<String>;
  /**
   * A description of the type of the resource, e.g. a confirmation.
   */
  resourceType?: FieldWithMeta<ResourceTypeEnum>;
  /**
   * Indicates the language of the resource, described using the ISO 639-2/T Code.
   */
  language?: FieldWithMeta<String>;
  /**
   * Indicates the size of the resource in bytes. It could be used by the end user to estimate the download time and storage needs.
   */
  sizeInBytes?: number;
  /**
   * Indicates the length of the resource. For example, if the resource were a PDF file, the length would be in pages.
   */
  length?: ResourceLength;
  /**
   * Indicates the type of media used to store the content. mimeType is used to determine the software product(s) that can read the content. MIME Types are described in RFC 2046.
   */
  mimeType?: FieldWithMeta<String>;
  /**
   * The name of the resource.  It is specified as a NormalizedString in FpML.
   */
  name?: string;
  /**
   * Any additional comments that are deemed necessary. For example, which software version is required to open the document? Or, how does this resource relate to the others for this event?
   */
  comments?: string;
  /**
   * Provides extra information as string. In case the extra information is in XML format, a CDATA section must be placed around the source message to prevent its interpretation as XML content.
   */
  string?: string;
  /**
   * Indicates where the resource can be found, as a URL that references the information on a web server accessible to the message recipient.
   */
  url?: string;
}
  
/**
 * A class to indicate the length of the resource.
 */
export interface ResourceLength {
  /**
   * The length unit of the resource. For example, pages (pdf, text documents) or time (audio, video files).
   */
  lengthUnit?: LengthUnitEnum;
  /**
   * The length value of the resource.
   */
  lengthValue?: number;
}
  
export interface Restructuring {
  /**
   * Indicates whether the restructuring provision is applicable.
   */
  applicable?: boolean;
  /**
   * Specifies the type of restructuring that is applicable.
   */
  restructuringType?: FieldWithMeta<RestructuringEnum>;
  /**
   * In relation to a restructuring credit event, unless multiple holder obligation is not specified restructurings are limited to multiple holder obligations. A multiple holder obligation means an obligation that is held by more than three holders that are not affiliates of each other and where at least two thirds of the holders must agree to the event that constitutes the restructuring credit event. ISDA 2003 Term: Multiple Holder Obligation.
   */
  multipleHolderObligation?: boolean;
  /**
   * Presence of this element and value set to 'true' indicates that Section 3.9 of the 2003 Credit Derivatives Definitions shall apply. Absence of this element indicates that Section 3.9 shall not apply. NOTE: Not allowed under ISDA Credit 1999.
   */
  multipleCreditEventNotices?: boolean;
}
  
/**
 * A class to specify the application of Interest Amount with respect the Return Amount.
 */
export interface ReturnAmount {
  /**
   * Default language is included when True, and excluded when False.
   */
  includesDefaultLanguage?: boolean;
  /**
   * Custom election that might be specified by the parties to the agreement.
   */
  customElection?: string;
}
  
/**
 * Specifies the information required to create the return of a Security Finance Transaction.
 */
export interface ReturnInstruction {
  /**
   * Specifies the quantity of shares and cash to be returned in a partial return event.
   */
  quantity?: Quantity[];
}
  
/**
 * Specifies the type of return of a performance payout.
 */
export interface ReturnTerms {
  /**
   * Return terms based upon the underlier's observed price.
   */
  priceReturnTerms?: PriceReturnTerms;
  /**
   * Return terms based upon dividend payments associated to the underlier.
   */
  dividendReturnTerms?: DividendReturnTerms;
  /**
   * Return terms based upon the observed variance of the underlier's price.
   */
  varianceReturnTerms?: VarianceReturnTerms;
  /**
   * Return terms based upon the observed volatility of the underlier's price.
   */
  volatilityReturnTerms?: VolatilityReturnTerms;
  /**
   * Return terms based upon the observed correlation between the components of the underlying basket.
   */
  correlationReturnTerms?: CorrelationReturnTerms;
}
  
/**
 * Contains all common elements in variance, volatility and correlation return Terms.
 */
export interface ReturnTermsBase {
  /**
   * Contains all non-date valuation information.
   */
  valuationTerms?: ValuationTerms;
  /**
   * This specifies the numerator of an annualization factor. Frequently this number is equal to the number of observations of prices in a year e.g. 252.
   */
  annualizationFactor?: number;
  /**
   * The parameters which define whether dividends are applicable
   */
  dividendApplicability?: DividendApplicability;
  /**
   * Contains Equity Underlyer provisions regarding jurisdiction and fallbacks.
   */
  equityUnderlierProvisions?: EquityUnderlierProvisions;
  /**
   * Indicates whether the price of shares is adjusted for dividends or not.
   */
  sharePriceDividendAdjustment?: boolean;
  /**
   * Expected number of trading days.
   */
  expectedN?: number;
  /**
   * Contract will strike off this initial level. Providing just the initialLevel without initialLevelSource, infers that this is AgreedInitialPrice - a specified Initial Index Level.
   */
  initialLevel?: number;
  /**
   * In this context, this is AgreedInitialPrice - a specified Initial Index Level.
   */
  initialLevelSource?: DeterminationMethodEnum;
  /**
   * Specifies whether Mean Adjustment is applicable or not in the calculation of the Realized Volatility, Variance or Correlation
   */
  meanAdjustment?: boolean;
  /**
   * Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.
   */
  performance?: string;
}
  
/**
 * Used in conjunction with an exchange-based pricing source. Identifies a way in which the futures contracts referenced will roll between periods. 
 */
export interface RollFeature {
  /**
   * Used in conjunction with an exchange-based pricing source. Identifies a date source calendar from which the pricing dates and thus roll to the next contract will be based off (e.g. pricing is based on the NYMEX WTI First Nearby Futures Contract, if Future is chosen, the pricing will roll to the next futures contract on expiration, if ListedOption is chosen, the pricing will roll to the next futures contract on the Option expiration date which is three business days before the expiration of the NYMEX WTI futures contract.) Omitting this element will result in the default behavior expected with the pricing source described within the commodity element.
   */
  rollSourceCalendar?: RollSourceCalendarEnum;
  /**
   * Specifies, for a Commodity Transaction that references a delivery date for a listed future, the day on which the specified future will roll to the next nearby month prior to the expiration of the referenced future. If the future will not roll at all - i.e. the price will be taken from the expiring contract, 0 should be specified here. If the future will roll to the next nearby on the last trading day - i.e. the price will be taken from the next nearby on the last trading day, then 1 should be specified and so on.
   */
  deliveryDateRollConvention?: Offset;
}
  
/**
 * Defines rounding rules and precision to be used in the rounding of a number.
 */
export interface Rounding {
  /**
   * Specifies the rounding rounding rule as up, down, or nearest.
   */
  roundingDirection?: RoundingDirectionEnum;
  /**
   * Specifies the rounding precision in terms of a number of decimal places when the number is evaluated in decimal form (not percentage), e.g. 0.09876543 rounded to the nearest 5 decimal places is  0.0987654.
   */
  precision?: number;
}
  
/**
 * A class defining a schedule of rates or amounts in terms of an initial value and then a series of step date and value pairs. On each step date the rate or amount changes to the new step value. The series of step date and value pairs are optional. If not specified, this implies that the initial value remains unchanged over time.
 */
export interface Schedule {
  /**
   * The initial rate or amount, as the case may be. An initial rate of 5% would be represented as 0.05.
   */
  value?: number;
  /**
   * The schedule of step date and value pairs. On each step date the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
   */
  datedValue?: DatedValue[];
}
  
/**
 * A class that defines the period of a schedule. The period contains a set of start and end dates, quantities, fixing, and pricing data.
 */
export interface SchedulePeriod {
  /**
   * Period for which the payment is generated.
   */
  calculationPeriod?: DateRange;
  /**
   * Adjusted payment date.
   */
  paymentDate?: Date;
  /**
   * Period over which the underlying price is observed.
   */
  fixingPeriod?: DateRange;
  /**
   * Period and time profile over which the delivery takes place.
   */
  deliveryPeriod?: CalculationScheduleDeliveryPeriods;
}
  
export interface ScheduledTransfer {
  /**
   * Specifies a transfer created from a scheduled or contingent event on a contract, e.g. Exercise, Performance, Credit Event
   */
  transferType?: ScheduledTransferEnum;
  corporateActionTransferType?: CorporateActionTypeEnum;
}
  
export interface SchmeNm {
  prtry?: string;
}
  
/**
 * Identifies a security by referencing an identifier and by specifying the sector.
 */
export interface Security extends InstrumentBase {
  /**
   * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
   */
  identifier?: AssetIdentifier[];
  /**
   * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
   */
  taxonomy?: Taxonomy[];
  /**
   * Defines whether the Asset is listed on a public exchange.
   */
  isExchangeListed?: boolean;
  /**
   * If the Asset is listed, defines the public exchange of the listing.
   */
  exchange?: LegalEntity;
  /**
   * Provides the related Exchanges, if applicable.
   */
  relatedExchange?: LegalEntity[];
  /**
   * Identifies the type of an instrument using an enumerated list.
   */
  instrumentType?: InstrumentTypeEnum;
  /**
   * Identifies the type of debt and selected debt economics.
   */
  debtType?: DebtType;
  /**
   * Identifies the type of equity.
   */
  equityType?: EquityTypeEnum;
  /**
   * Identifies the type of fund.
   */
  fundType?: FundProductTypeEnum;
}
  
/**
 * The set of elections which specify a Security Agremeent
 */
export interface SecurityAgreementElections {
}
  
/**
 * Specifies the information required for inclusion in a securities lending billing invoice.
 */
export interface SecurityLendingInvoice {
  /**
   * The party issuing the invoice
   */
  sendingParty?: Party;
  /**
   * The party receiving the invoice
   */
  receivingParty?: Party;
  /**
   * The starting date of the period described by this invoice
   */
  billingStartDate?: Date;
  /**
   * The ending date of the period described by this invoice
   */
  billingEndDate?: Date;
  /**
   * The billing records contained within the invoice
   */
  billingRecord?: BillingRecord[];
  /**
   * The billing summaries contained within the invoice
   */
  billingSummary?: BillingSummary[];
  meta?: MetaFields;
}
  
/**
 * A locate is an approval from a broker that needs to be obtained prior to effecting a short sale in an equity security. Similar to security availability, a borrower can request a single or multiple securities, but at least one must be requested.
 */
export interface SecurityLocate extends AvailableInventory {
  /**
   * Defines the purpose of this inventory.
   */
  availableInventoryType?: AvailableInventoryTypeEnum;
  /**
   * Allows details related to the availability messaging use case to be defined
   */
  messageInformation?: MessageInformation;
  /**
   * Defines all parties involved for the list of inventory records in this set of inventory. For example, when used to describe securities lending availability, this could hold the sender of the availability, the intended recipient, the beneficial owner(s), the lender (which may differ from the sender as the lender may have the same piece of availability going through multiple agents), an agent or a venue.
   */
  party?: Party[];
  /**
   * Defines the role(s) that party(ies) may have in relation to the inventory.
   */
  partyRole?: PartyRole[];
  /**
   * An array holding the list of inventory being described. Each element in the inventoryRecord array represents an individual piece of inventory i.e. a security.
   */
  availableInventoryRecord?: AvailableInventoryRecord[];
}
  
export interface Sellr {
  acctOwnr?: AcctOwnr;
}
  
/**
 * A class to specify the Relevant Settled Entity Matrix.
 */
export interface SettledEntityMatrix {
  /**
   * Relevant settled entity matrix source.
   */
  matrixSource?: FieldWithMeta<SettledEntityMatrixSourceEnum>;
  /**
   * Specifies the publication date of the applicable version of the matrix. When this element is omitted, the Standard Terms Supplement defines rules for which version of the matrix is applicable.
   */
  publicationDate?: Date;
}
  
/**
 * A base class to be extended by the SettlementTerms class.
 */
export interface SettlementBase {
  /**
   * Whether the settlement will be cash, physical, by election, ...
   */
  settlementType?: SettlementTypeEnum;
  /**
   * The qualification as to how the transfer will settle, e.g. a DvP settlement.
   */
  transferSettlementType?: TransferSettlementEnum;
  /**
   * The settlement currency is to be specified when the Settlement Amount cannot be known in advance. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
   */
  settlementCurrency?: FieldWithMeta<String>;
  /**
   * The date on which the settlement amount will be paid, subject to adjustment in accordance with any applicable business day convention. This component would not be present for a mandatory early termination provision where the cash settlement payment date is the mandatory early termination date.
   */
  settlementDate?: SettlementDate;
  /**
   * Optional settlement centre as an enumerated list: Euroclear, Clearstream.
   */
  settlementCentre?: SettlementCentreEnum;
  /**
   * Optionally defines the parameters that regulate a settlement.
   */
  settlementProvision?: SettlementProvision;
  /**
   * Settlement Style.
   */
  standardSettlementStyle?: StandardSettlementStyleEnum;
  meta?: MetaFields;
}
  
/**
 * A data defining the settlement date(s) for cash or physical settlement as either a set of explicit dates, together with applicable adjustments, or as a date relative to some other (anchor) date, or as any date in a range of contiguous business days. This data type provides a level of abstraction on top of the different legacy methods used to specify a settlement / payment date, which vary across product types, asset classes and delivery types.
 */
export interface SettlementDate {
  /**
   * A single settlement date subject to adjustment or specified as relative to another date (e.g. the trade date). This attribute was formerly part of 'SettlementTerms', which is now being harmonised to include a common 'SettlementDate', as inherited from 'SettlementBase'.
   */
  adjustableOrRelativeDate?: AdjustableOrAdjustedOrRelativeDate;
  /**
   * The settlement date for a forward settling product. For Foreign Exchange contracts, this represents a common settlement date between both currency legs. To specify different settlement dates for each currency leg, see the ForeignExchange class. This attribute was formerly part of 'SettlementTerms', which is now being harmonised to include a common 'SettlementDate', as inherited from 'SettlementBase'.
   */
  valueDate?: Date;
  /**
   * A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date. This attributes was formerly part of 'CashSettlementPaymentDate' as included into 'OptionCashSettlement' (which is now merged into a unique 'CashSettlementTerms' data type.
   */
  adjustableDates?: AdjustableDates;
  /**
   * A range of contiguous business days. This attribute is meant to be merged with the 'settlementDate' at some future point once we refactor 'Date' to use a single complex type across the model. This attributes was formerly part of 'CashSettlementPaymentDate', as included into 'OptionCashSettlement' (which is now merged into a unique 'CashSettlementTerms' data type.
   */
  businessDateRange?: BusinessDateRange;
  /**
   * The number of business days used in the determination of the cash settlement payment date. If a cash settlement amount is specified, the cash settlement payment date will be this number of business days following the calculation of the final price. If a cash settlement amount is not specified, the cash settlement payment date will be this number of business days after all conditions to settlement are satisfied. ISDA 2003 Term: Cash Settlement Date. This attribute was formerly part of 'CashSettlementTerms' as used for credit event settlement, which now includes a common 'SettlementDate' attribute.
   */
  cashSettlementBusinessDays?: number;
  /**
   * Applicable to CDS on MBS to specify whether payment delays are applicable to the fixed Amount. RMBS typically have a payment delay of 5 days between the coupon date of the reference obligation and the payment date of the synthetic swap. CMBS do not, on the other hand, with both payment dates being on the 25th of each month.
   */
  paymentDelay?: boolean;
  meta?: MetaFields;
}
  
/**
 * Represents a forward settling payout. The underlier attribute captures the underlying payout, which is settled according to the settlementTerms attribute (which is part of PayoutBase). Both FX Spot and FX Forward should use this component.
 */
export interface SettlementPayout extends PayoutBase {
  /**
   * Canonical representation of the payer and receiver parties applicable to each payout leg.
   */
  payerReceiver?: PayerReceiver;
  /**
   * Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
   */
  priceQuantity?: ResolvablePriceQuantity;
  /**
   * The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
   */
  principalPayment?: PrincipalPayments;
  /**
   * Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
   */
  settlementTerms?: SettlementTerms;
  /**
   * The underlying financial product that will be physically or cash settled, which can be of any type, eg an asset such as cash or a security, or the cash settlement of an index rate.
   */
  underlier?: Underlier;
  /**
   * Also called contract month or delivery month. However, it's not always a month. It is usually expressed using a code, e.g. Z23 would be the Dec 2023 contract, (Z = December). For crude oil, the corresponding contract might be called CLZ23.
   */
  deliveryTerm?: string;
  /**
   * Contains the information relative to the delivery of the asset.
   */
  delivery?: AssetDeliveryInformation;
  /**
   * Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
   */
  schedule?: CalculationSchedule;
}
  
/**
 * Defines parameters that regulate a settlement, for instance whether this settlement should be netted with other ones or broken-down into smaller amounts.
 */
export interface SettlementProvision {
  /**
   * Defines the parameters that are necessary to 'shape' a settlement, i.e. break it down into smaller amounts.
   */
  shapingProvisions?: ShapingProvision;
}
  
/**
 * Defines the settlement rate option to use for fixing in case of cash settlement. Currently only applicable to foreign exchange fixing in case of cross-currency settlement.
 */
export interface SettlementRateOption {
  /**
   * The rate source for the conversion to the settlement currency. This source is specified through a scheme that reflects the terms of the Annex A to the 1998 FX and Currency Option Definitions.
   */
  settlementRateOption?: FieldWithMeta<SettlementRateOptionEnum>;
  /**
   * An attribute defining the parameters to get a new quote when a settlement rate option is disrupted.
   */
  priceSourceDisruption?: PriceSourceDisruption;
}
  
/**
 * Specifies the settlement terms, which can either be cash, physical, or fx-based cash-settlement. This class can be used for the settlement of options and forwards, cash transactions (e.g. securities or foreign exchange), or in case of credit event.
 */
export interface SettlementTerms extends SettlementBase {
  /**
   * Whether the settlement will be cash, physical, by election, ...
   */
  settlementType?: SettlementTypeEnum;
  /**
   * The qualification as to how the transfer will settle, e.g. a DvP settlement.
   */
  transferSettlementType?: TransferSettlementEnum;
  /**
   * The settlement currency is to be specified when the Settlement Amount cannot be known in advance. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
   */
  settlementCurrency?: FieldWithMeta<String>;
  /**
   * The date on which the settlement amount will be paid, subject to adjustment in accordance with any applicable business day convention. This component would not be present for a mandatory early termination provision where the cash settlement payment date is the mandatory early termination date.
   */
  settlementDate?: SettlementDate;
  /**
   * Optional settlement centre as an enumerated list: Euroclear, Clearstream.
   */
  settlementCentre?: SettlementCentreEnum;
  /**
   * Optionally defines the parameters that regulate a settlement.
   */
  settlementProvision?: SettlementProvision;
  /**
   * Settlement Style.
   */
  standardSettlementStyle?: StandardSettlementStyleEnum;
  meta?: MetaFields;
  /**
   * Specifies the parameters associated with the cash settlement procedure.
   */
  cashSettlementTerms?: CashSettlementTerms[];
  /**
   * Specifies the physical settlement terms which apply to the transaction.
   */
  physicalSettlementTerms?: PhysicalSettlementTerms;
}
  
/**
 * Defines the applicable settlement limits that may require a settlement to be 'shaped', i.e. broken-down into smaller amounts.
 */
export interface ShapingProvision {
  /**
   * Defines applicable settlement limits in each currency.
   */
  shapeSchedule?: Money[];
}
  
/**
 * A class to specify the number of business days after satisfaction of all conditions to settlement.
 */
export interface SingleValuationDate {
  /**
   * A number of business days. Its precise meaning is dependant on the context in which this element is used. ISDA 2003 Term: Business Day.
   */
  businessDays?: number;
}
  
export interface Sngl {
  isin?: string;
  indx?: Indx;
}
  
export interface SovereignAgencyRating {
  /**
   * Represents an agency rating based on default risk of the country of the issuer.
   */
  sovereignAgencyRating?: AgencyRatingCriteria;
}
  
/**
 * Represents a class to allow specification of different types of special purpose vehicle (SPV) collateral.
 */
export interface SpecialPurposeVehicleIssuerType {
  /**
   * Indicates tranched or untranched credit risk.
   */
  creditRisk?: CreditRiskEnum;
}
  
/**
 * A single, specifically identified Asset chosen from the Asset data type
 */
export interface SpecificAsset extends Asset {
  /**
   * An Asset that consists solely of a monetary holding in a currency.
   */
  cash?: Cash;
  /**
   * An Asset comprised of raw or refined materials or agricultural products, eg gold, oil or wheat.
   */
  commodity?: Commodity;
  /**
   * An Asset that exists only in digital form, eg Bitcoin or Ethereum; excludes the digital representation of other Assets.
   */
  digitalAsset?: DigitalAsset;
  /**
   * An asset that is issued by one party to one or more others; Instrument is also a choice data type.
   */
  instrument?: Instrument;
}
  
export interface SpecifiedCurrency {
  /**
   * Indicates whether the specified currency provision is applicable.
   */
  applicable?: boolean;
  /**
   * The currency in which the specified currency is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
   */
  currency?: FieldWithMeta<String>;
}
  
/**
 * Specifies instructions for a split, consisting of a breakdown of instructions to be applied to each branch of the split. This instruction can be used to duplicate a trade, as in a clearing scenario, or to split a trade into smaller quantities (in which case each breakdown instruction needs to include a quantity change), as in an allocation.
 */
export interface SplitInstruction {
  /**
   * Each split breakdown specifies the set of primitive instructions to be applied to a single branch of that split. N split breakdowns result in N output trades, which include the original trade. Instructions for how to handle the original trade (e.g. if it must be closed) must be specified in one of the breakdowns.
   */
  breakdown?: PrimitiveInstruction[];
}
  
/**
 * Adds an optional spread type element to the Schedule to identify a long or short spread value.
 */
export interface SpreadSchedule extends RateSchedule {
  /**
   * The initial rate. An initial rate of 5% would be represented as 0.05.
   */
  price?: ReferenceWithMeta<PriceSchedule>;
  /**
   * An element which purpose is to identify a long or short spread value.
   */
  spreadScheduleType?: FieldWithMeta<SpreadScheduleTypeEnum>;
}
  
export interface StandardizedSchedule {
  assetClass?: StandardizedScheduleAssetClassEnum;
  productClass?: StandardizedScheduleProductClassEnum;
  notional?: number;
  notionalCurrency?: string;
  durationInYears?: number;
}
  
export interface StandardizedScheduleInitialMargin {
  tradeInfo?: StandardizedScheduleTradeInfo[];
  netInitialMargin?: Money;
}
  
export interface StandardizedScheduleTradeInfo {
  assetClass?: StandardizedScheduleAssetClassEnum;
  productClass?: StandardizedScheduleProductClassEnum;
  grossInitialMargin?: Money;
  markToMarketValue?: Money;
}
  
/**
 * Defines the state of a trade at a point in the Trade's life cycle. Trades have many state dimensions, all of which are represented here. For example, states useful for position keeping are represented alongside those needed for regulatory reporting.
 */
export interface State {
  /**
   * Represents the qualification of what led to the trade's closure alongside the dates on which this closure took effect.
   */
  closedState?: ClosedState;
  /**
   * Identifies the state of the position, to distinguish if just executed, formed, already settled, closed, etc.
   */
  positionState?: PositionStatusEnum;
}
  
/**
 * Data required to perform a stock split business event.
 */
export interface StockSplitInstruction {
  /**
   * The number that denotes the cumulative quantity of post-split shares issued to shareholders versus the quantity of pre-split shares previously issued to shareholders.  This number will be multiplied by existing shares in an equity derivative contract or other positions to determine the post-split number of shares.  With regard to any reference to price, the pre-split reference price will be divided by this number to determine the post-split reference price.
   */
  adjustmentRatio?: number;
  /**
   * The effective date of the stock split, also known as the ex-date. This is the date on which the additional shares are paid to the shareholders, or in the case of a reverse stock split, the number shares held by each shareholder is proportionally reduced.  Equity derivative transactions can be amended in firms' internal systems on such date.   In most markets, the listed stock price is reduced (or increased for a reverse stock split) to account for the split on the same date, but in some markets the price adjustment occurs on a later date.  In either case, equity derivative transactions should be amended on the date that the stocks are paid to the shareholders (or consolidated).
   */
  effectiveDate?: Date;
}
  
/**
 * A class for defining option strategy features.
 */
export interface StrategyFeature {
  /**
   * Definition of the upper strike in a strike spread.
   */
  strikeSpread?: StrikeSpread;
  /**
   * Definition of the later expiration date in a calendar spread.
   */
  calendarSpread?: CalendarSpread;
}
  
/**
 * A class describing a single cap or floor rate.
 */
export interface Strike {
  /**
   * The rate for a cap or floor.
   */
  strikeRate?: number;
  /**
   * The buyer of the option.
   */
  buyer?: PayerReceiverEnum;
  /**
   * The party that has sold.
   */
  seller?: PayerReceiverEnum;
  meta?: MetaFields;
}
  
/**
 * A class describing a schedule of cap or floor rates.
 */
export interface StrikeSchedule extends RateSchedule {
  /**
   * The initial rate. An initial rate of 5% would be represented as 0.05.
   */
  price?: ReferenceWithMeta<PriceSchedule>;
  /**
   * The buyer of the option.
   */
  buyer?: PayerReceiverEnum;
  /**
   * The party that has sold.
   */
  seller?: PayerReceiverEnum;
}
  
/**
 * A class for defining a strike spread feature.
 */
export interface StrikeSpread {
  /**
   * Upper strike in a strike spread.
   */
  upperStrike?: OptionStrike;
  /**
   * Number of options at the upper strike price in a strike spread.
   */
  upperStrikeNumberOfOptions?: number;
}
  
/**
 * A data defining:  how the initial or final stub calculation period amounts is calculated. For example, the rate to be applied to the initial or final stub calculation period may be the linear interpolation of two different tenors for the floating rate index specified in the calculation period amount component, e.g. A two month stub period may used the linear interpolation of a one month and three month floating rate. The different rate tenors would be specified in this component. Note that a maximum of two rate tenors can be specified. If a stub period uses a single index tenor and this is the same as that specified in the calculation period amount component then the initial stub or final stub component, as the case may be, must not be included.
 */
export interface StubCalculationPeriodAmount {
  /**
   * A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
   */
  calculationPeriodDatesReference?: ReferenceWithMeta<CalculationPeriodDates>;
  /**
   * Specifies how the initial stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
   */
  initialStub?: StubValue;
  /**
   * Specifies how the final stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
   */
  finalStub?: StubValue;
}
  
/**
 * A class defining a floating rate.
 */
export interface StubFloatingRate {
  /**
   * The floating rate index.
   */
  floatingRateIndex?: FloatingRateIndexEnum;
  /**
   * The ISDA Designated Maturity, i.e. the tenor of the floating rate.
   */
  indexTenor?: Period;
  /**
   * A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
   */
  floatingRateMultiplierSchedule?: Schedule;
  /**
   * The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
   */
  spreadSchedule?: SpreadSchedule[];
  /**
   * The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
   */
  rateTreatment?: RateTreatmentEnum;
  /**
   * The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
   */
  capRateSchedule?: StrikeSchedule[];
  /**
   * The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
   */
  floorRateSchedule?: StrikeSchedule[];
}
  
/**
 *  A class defining how the initial or final stub calculation period amounts is calculated. For example, the rate to be applied to the initial or final stub calculation period may be the linear interpolation of two different tenors for the floating rate index specified in the calculation period amount component, e.g. A two month stub period may used the linear interpolation of a one month and three month floating rate. The different rate tenors would be specified in this component. Note that a maximum of two rate tenors can be specified. If a stub period uses a single index tenor and this is the same as that specified in the calculation period amount component then the initial stub or final stub component, as the case may be, must not be included.
 */
export interface StubPeriod {
  /**
   * A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
   */
  calculationPeriodDatesReference?: ReferenceWithMeta<CalculationPeriodDates>;
  /**
   * Specifies how the initial stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
   */
  initialStub?: StubValue;
  /**
   * Specifies how the final stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
   */
  finalStub?: StubValue;
}
  
/**
 * A type defining how a stub calculation period amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating rate tenors many be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3 Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
 */
export interface StubValue {
  /**
   * The rates to be applied to the initial or final stub may be the linear interpolation of two different rates. While the majority of the time, the rate indices will be the same as that specified in the stream and only the tenor itself will be different, it is possible to specift two different rates. For example, a 2 month stub period may use the linear interpolation of a 1 month and 3 month rate. The different rates would be specified in this component. Note that a maximum of two rates can be specified. If a stub period uses the same floating rate index, including tenor, as the regular calculation periods then this should not be specified again within this component, i.e. the stub calculation period amount component may not need to be specified even if there is an initial or final stub period. If a stub period uses a different floating rate index compared to the regular calculation periods then this should be specified within this component. If specified here, they are likely to have id attributes, allowing them to be referenced from within the cashflows component.
   */
  floatingRate?: StubFloatingRate[];
  /**
   * An actual rate to apply for the initial or final stub period may have been agreed between the principal parties (in a similar way to how an initial rate may have been agreed for the first regular period). If an actual stub rate has been agreed then it would be included in this component. It will be a per annum rate, expressed as a decimal. A stub rate of 5% would be represented as 0.05.
   */
  stubRate?: number;
  /**
   * An actual amount to apply for the initial or final stub period may have been agreed between the two parties. If an actual stub amount has been agreed then it would be included in this component.
   */
  stubAmount?: Money;
}
  
/**
 * Defines collateral substitution provisions such as how many and with how much notice are substitutions allowed.
 */
export interface SubstitutionProvisions {
  /**
   * Specifies if 1 or more substitutions are allowed.
   */
  numberOfSubstitutionsAllowed?: number;
  /**
   * Defines the min period for notify of a substitution.
   */
  noticeDeadlinePeriod?: Period;
  /**
   * A specific date and time for the notice deadline
   */
  noticeDeadlineDateTime?: Date;
}
  
/**
 * A class to specify a valuation swap curve, which is used as part of the strike construct for the bond and convertible bond options.
 */
export interface SwapCurveValuation {
  floatingRateIndex?: FloatingRateIndexEnum;
  /**
   * The ISDA Designated Maturity, i.e. the tenor of the floating rate.
   */
  indexTenor?: Period;
  /**
   * Spread in basis points over the floating rate index.
   */
  spread?: number;
  /**
   * The side (bid/mid/ask) of the measure.
   */
  side?: QuotationSideEnum;
}
  
export interface Swp {
  swpIn?: SwpIn;
  swpOut?: SwpOut;
}
  
export interface SwpIn {
  sngl?: Sngl;
}
  
export interface SwpOut {
  sngl?: Sngl;
}
  
/**
 * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object).
 */
export interface Taxonomy {
  /**
   * The source of the taxonomy that defines the rules for classifying the object. The taxonomy source is taken from a enumerated list of taxonomy names. Optional as the taxonomy source may not be provided.
   */
  source?: TaxonomySourceEnum;
  /**
   * The value according to that taxonomy. Optional as it may not be possible to classify the object in that taxonomy.
   */
  value?: TaxonomyValue;
}
  
export interface TaxonomyClassification {
  /**
   * The name defined by the classification system for a specific attribute in the taxonomy
   */
  className?: string;
  /**
   * The value set by the taxonomy that is specific to the className attribute.
   */
  value?: string;
  /**
   * A description of the class.
   */
  description?: string;
  /**
   * In the case of multi-layered hierarchical classification systems such as commodity classification, the layer the value and className occupy in the classification hierarchy, where 1 represents the top-layer.
   */
  ordinal?: number;
}
  
/**
 * Defines a taxonomy value as either a simple string or a more granular expression with class names and values for each class.
 */
export interface TaxonomyValue {
  /**
   * Specifies the taxonomy value as a simple string, which may be associated to an external scheme.
   */
  name?: FieldWithMeta<String>;
  /**
   * Specifies the taxonomy value as a set of class names and values for each class.
   */
  classification?: TaxonomyClassification[];
}
  
/**
 * A class to specify a telephone number as a type of phone number (e.g. work, personal, ...) alongside with the actual number.
 */
export interface TelephoneNumber {
  /**
   * The type of telephone number, e.g. work, mobile.
   */
  telephoneNumberType?: TelephoneTypeEnum;
  /**
   * The actual telephone number.
   */
  number?: string;
}
  
export interface Term {
  unit?: string;
  val?: string;
}
  
/**
 * A class for defining option provisions.
 */
export interface TerminationProvision {
  /**
   * A provision that allows the specification of an embedded option within a swap giving the buyer of the option the right to terminate the swap, in whole or in part, on the early termination date.
   */
  cancelableProvision?: CancelableProvision;
  /**
   * Parameters specifying provisions relating to the optional and mandatory early termination of a swap transaction.
   */
  earlyTerminationProvision?: EarlyTerminationProvision;
  /**
   * A data defining: the right of a party to exercise an Evergreen option
   */
  evergreenProvision?: EvergreenProvision;
  /**
   * A provision that allows the specification of an embedded option with a swap giving the buyer of the option the right to extend the swap, in whole or in part, to the extended termination date.
   */
  extendibleProvision?: ExtendibleProvision;
}
  
/**
 * Specifies instructions for terms change consisting of the new transaction terms, and the renegotiation fee.
 */
export interface TermsChangeInstruction {
  /**
   * product to be changed
   */
  product?: NonTransferableProduct;
  /**
   * ancillary party to be changed
   */
  ancillaryParty?: AncillaryParty[];
  adjustment?: NotionalAdjustmentEnum;
}
  
/**
 * The time alongside with the timezone location information. This class makes use of the FpML TimezoneLocation construct.
 */
export interface TimeZone {
  /**
   * The observation time.
   */
  time?: string;
  /**
   * FpML specifies the timezoneLocationScheme by reference to the Time Zone Database (a.k.a. tz database) maintained by IANA, the Internet Assigned Numbers Authority.
   */
  location?: FieldWithMeta<String>;
}
  
/**
 * Definition of a product as ready to be traded, i.e. included in an execution or contract, by associating a specific price and quantity to this product plus an (optional) mechanism for any potential future quantity adjustment.
 */
export interface TradableProduct {
  /**
   * The underlying product to be included in a contract or execution.
   */
  product?: NonTransferableProduct;
  /**
   * Specifies the price, quantity and effective date of each trade lot, when the same product may be traded multiple times in different lots with the same counterparty. In a trade increase, a new trade lot is added to the list, with the corresponding effective date. In a trade decrease, the existing trade lot(s) are decreased of the corresponding quantity (and an unwind fee may have to be settled). The multiple cardinality and the ability to increase existing trades is used for Equity Swaps in particular.
   */
  tradeLot?: TradeLot[];
  /**
   * Specifies the parties which are the two counterparties to the transaction.  The product is agnostic to the actual parties to the transaction, with the party references abstracted away from the product definition and replaced by the counterparty enum (e.g. CounterpartyEnum values Party1 or Party2). The counterparty enum can then be positioned in the product (e.g. to specify which counterparty is the payer, receiver etc) and this counterparties attribute, which is positioned outside of the product definition, allows the counterparty enum to be associated with an actual party reference.
   */
  counterparty?: Counterparty[];
  /**
   * Specifies the parties with ancillary roles in the transaction. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and this AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
   */
  ancillaryParty?: AncillaryParty[];
  /**
   * Specifies the conditions that govern the adjustment to the quantity of a product being traded: e.g. execution, portfolio rebalancing etc. It is typically used in the context of Equity Swaps.
   */
  adjustment?: NotionalAdjustmentEnum;
}
  
/**
 * Defines the output of a financial transaction between parties - a Business Event. A Trade impacts the financial position (i.e. the balance sheet) of involved parties.
 */
export interface Trade extends TradableProduct {
  /**
   * The underlying product to be included in a contract or execution.
   */
  product?: NonTransferableProduct;
  /**
   * Specifies the price, quantity and effective date of each trade lot, when the same product may be traded multiple times in different lots with the same counterparty. In a trade increase, a new trade lot is added to the list, with the corresponding effective date. In a trade decrease, the existing trade lot(s) are decreased of the corresponding quantity (and an unwind fee may have to be settled). The multiple cardinality and the ability to increase existing trades is used for Equity Swaps in particular.
   */
  tradeLot?: TradeLot[];
  /**
   * Specifies the parties which are the two counterparties to the transaction.  The product is agnostic to the actual parties to the transaction, with the party references abstracted away from the product definition and replaced by the counterparty enum (e.g. CounterpartyEnum values Party1 or Party2). The counterparty enum can then be positioned in the product (e.g. to specify which counterparty is the payer, receiver etc) and this counterparties attribute, which is positioned outside of the product definition, allows the counterparty enum to be associated with an actual party reference.
   */
  counterparty?: Counterparty[];
  /**
   * Specifies the parties with ancillary roles in the transaction. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and this AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
   */
  ancillaryParty?: AncillaryParty[];
  /**
   * Specifies the conditions that govern the adjustment to the quantity of a product being traded: e.g. execution, portfolio rebalancing etc. It is typically used in the context of Equity Swaps.
   */
  adjustment?: NotionalAdjustmentEnum;
  /**
   * Represents the identifier(s) that uniquely identify a trade for an identity issuer. A trade can include multiple identifiers, for example a trade that is reportable to both the CFTC and ESMA, and then has an associated USI (Unique Swap Identifier) UTI (Unique Trade Identifier).
   */
  tradeIdentifier?: TradeIdentifier[];
  /**
   * Specifies the date which the trade was agreed.
   */
  tradeDate?: FieldWithMeta<Date>;
  /**
   * Denotes the trade time and timezone as agreed by the parties to the trade.
   */
  tradeTime?: FieldWithMeta<TimeZone>;
  /**
   * Represents the parties to the trade. The cardinality is optional to address the case where the trade is defined within a BusinessEvent data type, in which case the party is specified in BusinessEvent.
   */
  party?: Party[];
  /**
   * Represents the role each specified party takes in the trade. further to the principal roles, payer and receiver.
   */
  partyRole?: PartyRole[];
  /**
   * Represents information specific to trades that arose from executions.
   */
  executionDetails?: ExecutionDetails;
  /**
   * Represents information specific to trades involving contractual products.
   */
  contractDetails?: ContractDetails;
  /**
   * Specifies the date on which a trade is cleared (novated) through a central counterparty clearing service.
   */
  clearedDate?: Date;
  /**
   * Represents the collateral obligations of a party.
   */
  collateral?: Collateral;
  /**
   * Represents a party's granular account information, which may be used in subsequent internal processing.
   */
  account?: Account[];
  meta?: MetaFields;
}
  
/**
 * Defines a trade identifier as a special case of the generic identifier type, that also includes the trade identifier class.
 */
export interface TradeIdentifier extends Identifier {
  /**
   * The identifier issuer, when specified by reference to a party specified as part of the transaction.
   */
  issuerReference?: ReferenceWithMeta<Party>;
  /**
   * The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).
   */
  issuer?: FieldWithMeta<String>;
  /**
   * The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.
   */
  assignedIdentifier?: AssignedIdentifier[];
  meta?: MetaFields;
  /**
   * The enumerated classification of the identifier. Optional as a trade identifier may be party-specific, in which case it may not correspond to any established classification.
   */
  identifierType?: TradeIdentifierTypeEnum;
}
  
/**
 * Specifies the price and quantity of a trade lot, where the same product could be traded multiple times with the same counterparty but in different lots (at a different date, in a different quantity and at a different price). One trade lot combined with a product definition specifies the entire economics of a trade. The lifecycle mechanics of each such trade lot (e.g. cashflow payments) is independent of the other lots.
 */
export interface TradeLot {
  /**
   * Specifies one or more identifiers for the lot, if any.
   */
  lotIdentifier?: Identifier[];
  /**
   * Specifies the settlement characteristics of a trade lot: price, quantity, observable (optionally) and the settlement terms. This attribute has a multiple cardinality to allow to specify the price, quantity and observable of different legs in a single, composite product (e.g. a Swap).
   */
  priceQuantity?: PriceQuantity[];
}
  
/**
 * The attributes that are specific for consensus based pricing reporting.
 */
export interface TradePricingReport {
  /**
   * Represents the cosensus based pricing parameters on a trade basis.
   */
  trade?: Trade;
  /**
   * The regional exchange close time for the underlying contract,including time zone, at which the trades should be priced. This provides an indication for which regional snapshot should be used for pricing primarily for Global markets where there are multiple regional close times.
   */
  pricingTime?: TimeZone;
  /**
   * It specifies the interest payable on collateral delivered under a CSA covering the trade.
   */
  discountingIndex?: FloatingRateIndexEnum;
}
  
/**
 * Defines the fundamental financial information that can be changed by a Primitive Event and by extension any business or life-cycle event. Each TradeState specifies where a Trade is in its life-cycle. TradeState is a root type and as such, can be created independently to any other CDM data type, but can also be used as part of the CDM Event Model.
 */
export interface TradeState {
  /**
   * Represents the Trade that has been effected by a business or life-cycle event.
   */
  trade?: Trade;
  /**
   * Represents the State of the Trade through its life-cycle.
   */
  state?: State;
  /**
   * Represents the updated Trade attributes which can change as the result of a reset event. Only the changed values are captured, leaving the remaining data attributes empty. See Create_Reset function for further details on how TradeState is used in the Reset event. The TradeState data type is used to maintain backwards compatibility with the current Reset mechanism.
   */
  resetHistory?: Reset[];
  /**
   * Represents the updated Trade attributes which can change as the result of a transfer event.
   */
  transferHistory?: TransferState[];
  /**
   * Represents the observed events related to a particular product or process, such as credit events or corporate actions.
   */
  observationHistory?: ObservationEvent[];
  valuationHistory?: Valuation[];
  meta?: MetaFields;
}
  
/**
 * The class to represent a CDS Tranche.
 */
export interface Tranche {
  /**
   * Lower bound percentage of the loss that the Tranche can endure, expressed as a decimal. An attachment point of 5% would be represented as 0.05. The difference between Attachment and Exhaustion points is called the width of the Tranche.
   */
  attachmentPoint?: number;
  /**
   * Upper bound percentage of the loss that the Tranche can endure, expressed as a decimal. An exhaustion point of 5% would be represented as 0.05. The difference between Attachment and Exhaustion points is call the width of the Tranche.
   */
  exhaustionPoint?: number;
  /**
   * Outstanding Swap Notional Amount is defined at any time on any day, as the greater of: (a) Zero; If Incurred Recovery Amount Applicable: (b) The Original Swap Notional Amount minus the sum of all Incurred Loss Amounts and all Incurred Recovery Amounts (if any) determined under this Confirmation at or prior to such time.Incurred Recovery Amount not populated: (b) The Original Swap Notional Amount minus the sum of all Incurred Loss Amounts determined under this Confirmation at or prior to such time.
   */
  incurredRecoveryApplicable?: boolean;
}
  
/**
 *  A class to represent the transacted price attributes that are positioned as part of the FpML FeeLeg.
 */
export interface TransactedPrice {
  /**
   * An optional element that only has meaning in a credit index trade. This element contains the credit spread ('fair value') at which the trade was executed. Unlike the fixedRate of an index, the marketFixedRate varies over the life of the index depending on market conditions. The marketFixedRate is the price of the index as quoted by trading desks.
   */
  marketFixedRate?: number;
  /**
   * An optional element that contains the up-front points expressed as a percentage of the notional. An initialPoints value of 5% would be represented as 0.05. The initialPoints element is an alternative to marketFixedRate in quoting the traded level of a trade. When initialPoints is used, the traded level is the sum of fixedRate and initialPoints. The initialPoints is one of the items that are factored into the initialPayment calculation and is payable by the Buyer to the Seller. Note that initialPoints and marketFixedRate may both be present in the same document when both implied values are desired.
   */
  initialPoints?: number;
  /**
   * An optional element that only has meaning in a credit index trade. This element contains the price at which the trade was executed and is used instead of marketFixedRate on credit trades on certain indicies which are quoted using a price rather than a spread.
   */
  marketPrice?: number;
  /**
   * An optional element that contains the up-front points expressed as a percentage of the notional. An initialPoints value of 5% would be represented as 0.05. The initialPoints element is an alternative to marketFixedRate in quoting the traded level of a trade. When initialPoints is used, the traded level is the sum of fixedRate and initialPoints. The initialPoints is one of the items that are factored into the initialPayment calculation and is payable by the Buyer to the Seller. Note that initialPoints and marketFixedRate may both be present in the same document when both implied values are desired.
   */
  quotationStyle?: QuotationStyleEnum;
}
  
/**
 * Additional specification for the extraordinary events that may affect a trade and the related contractual rights and obligation of the parties when this happens. Such terms are typically required to extend the economics terms, for the purpose of producing the final legal contractual form of the Transaction.
 */
export interface TransactionAdditionalTerms {
  equityAdditionalTerms?: EquityAdditionalTerms;
  foreignExchangeAdditionalTerms?: FxAdditionalTerms;
  commoditiesAdditionalTerms?: string;
  creditAdditionalTerms?: string;
  interestRateAdditionalTerms?: string;
  digitalAssetAdditionalTerms?: string;
}
  
/**
 * Defines the movement of an Asset (eg cash, securities or commodities) between two parties on a date.
 */
export interface Transfer extends AssetFlowBase {
  /**
   * Represents the amount of the asset to be transferred. The cashflow amount is always a positive number, as the cashflow direction is implied by the payer/receiver attribute.
   */
  quantity?: NonNegativeQuantity;
  /**
   * Represents the object that is subject to the transfer, it could be an asset or a reference.
   */
  asset?: Asset;
  /**
   * Represents the date on which the transfer to due.
   */
  settlementDate?: AdjustableOrAdjustedOrRelativeDate;
  /**
   * Represents a unique reference to the transfer.
   */
  identifier?: FieldWithMeta<Identifier>[];
  /**
   * Represents the parties to the transfer and their role.
   */
  payerReceiver?: PartyReferencePayerReceiver;
  /**
   * Represents the origin to the transfer as a reference for lineage purposes, whether it originated from trade level settlement terms or from payment terms on an economic payout.
   */
  settlementOrigin?: ReferenceWithMeta<Payout>;
  /**
   * Represents the reset and observation values that were used to determine the transfer amount.
   */
  resetOrigin?: Reset;
  /**
   * Specifies a transfer expression (cash price, performance amount, scheduled payment amount, etc.) to define the nature of the transfer amount and its source.
   */
  transferExpression?: TransferExpression;
}
  
/**
 * Specifies a transfer expression (cash price, performance amount, scheduled payment amount, etc.) to define the nature of the transfer amount and its source.
 */
export interface TransferExpression {
  /**
   * Specifies a transfer amount exchanged as a price or fee for entering into a Business Event, e.g. Premium, Termination fee, Novation fee.
   */
  priceTransfer?: FeeTypeEnum;
  /**
   * Specifies a transfer created from a scheduled or contingent event on a contract, e.g. Exercise, Performance, Credit Event
   */
  scheduledTransfer?: ScheduledTransfer;
}
  
/**
 * Defines the payout on which to create a Transfer along with all necessary resets.
 */
export interface TransferInstruction {
  /**
   * Specifies the terms and state of a transfers.
   */
  transferState?: TransferState[];
}
  
/**
 * Defines the fundamental financial information associated with a Transfer event. Each TransferState specifies where a Transfer is in its life-cycle. TransferState is a root type and as such, can be created independently to any other CDM data type, but can also be used as part of the CDM Event Model.
 */
export interface TransferState {
  /**
   * Represents the Transfer that has been effected by a business or life-cycle event.
   */
  transfer?: Transfer;
  /**
   * Represents the State of the Transfer through its life-cycle.
   */
  transferStatus?: TransferStatusEnum;
  meta?: MetaFields;
}
  
/**
 * A TransferableProduct is a type of financial product which can be held or transferred, represented as an Asset with the addition of specific EconomicTerms.
 */
export interface TransferableProduct extends Asset {
  /**
   * An Asset that consists solely of a monetary holding in a currency.
   */
  cash?: Cash;
  /**
   * An Asset comprised of raw or refined materials or agricultural products, eg gold, oil or wheat.
   */
  commodity?: Commodity;
  /**
   * An Asset that exists only in digital form, eg Bitcoin or Ethereum; excludes the digital representation of other Assets.
   */
  digitalAsset?: DigitalAsset;
  /**
   * An asset that is issued by one party to one or more others; Instrument is also a choice data type.
   */
  instrument?: Instrument;
  /**
   * The price forming features, including payouts and provisions.
   */
  economicTerms?: EconomicTerms;
}
  
/**
 * Trigger point at which feature is effective.
 */
export interface Trigger {
  /**
   * The trigger level.
   */
  level?: PriceSchedule[];
  creditEvents?: CreditEvents;
  creditEventsReference?: ReferenceWithMeta<CreditEvents>;
  /**
   * The Triggering condition.
   */
  triggerType?: TriggerTypeEnum;
  /**
   * The valuation time type of knock condition.
   */
  triggerTimeType?: TriggerTimeTypeEnum;
}
  
/**
 * Observation point for trigger.
 */
export interface TriggerEvent {
  /**
   * A derivative schedule.
   */
  schedule?: AveragingSchedule[];
  /**
   * The trigger Dates.
   */
  triggerDates?: DateList;
  /**
   * The trigger level
   */
  trigger?: Trigger;
  /**
   * The feature payment, i.e. the payment made following trigger occurrence.
   */
  featurePayment?: FeaturePayment;
}
  
export interface Tx {
  newTx?: New;
  tradDt?: string;
  tradgCpcty?: string;
  qty?: Qty;
  pric?: Pric;
  tradVn?: string;
  ctryOfBrnch?: string;
}
  
/**
 * A class to specify a set of legal entities which are part of a legal agreement beyond the two contracting parties to that agreement. This data representation reflects the ISDA Create representation.
 */
export interface UmbrellaAgreement {
  /**
   * The determination of whether Umbrella Agreement terms are Applicable (True), or Not Applicable (False)
   */
  isApplicable?: boolean;
  /**
   * The language associated with the umbrella agreement, and which applies to all the parties to the umbrella agreement.
   */
  language?: string;
  /**
   * Underlying principals to the umbrella agreement.
   */
  parties?: UmbrellaAgreementEntity[];
}
  
/**
 * A class to specify the legal entities that are part of the umbrella agreement.
 */
export interface UmbrellaAgreementEntity extends LegalEntity {
  /**
   * A legal entity identifier (e.g. RED entity code).
   */
  entityId?: FieldWithMeta<String>[];
  /**
   * The legal entity name.
   */
  name?: FieldWithMeta<String>;
  meta?: MetaFields;
  /**
   * The terms that might be associated with each party to the umbrella agreement.
   */
  terms?: string;
}
  
/**
 * The underlying financial product that will be physically or cash settled, which can be of any type, eg an asset such as cash or a security, a product, or the cash settlement of an index rate.  Conditions are usually applied when used in a data type, such as a payout, to ensure this aligns with the use case.
 */
export interface Underlier {
  /**
   * Specifies the object to be observed for a price, it could be an asset or a reference.
   */
  observable?: ReferenceWithMeta<Observable>;
  /**
   * Enables either a TransferableProduct or a NonTransferableProduct to be used in an underlier.
   */
  product?: Product;
}
  
/**
 * Where parties describe any substitution terms.
 */
export interface UnderlierSubstitutionProvision {
  /**
   * Designates which Counterparty to the transaction who has the right to trigger a substitution or to provide related determination e.g. for instance to qualify the effectiveness of an Event which may be a trigger for substitution, determine the replacement Share to substitute, etc. ; cardinality of this object is 2, in case parties jointly have this role.
   */
  whoMaySubstitute?: CounterpartyRoleEnum[];
  /**
   * Where parties describe any substitution terms e.g. for instance the election criteria for an Asset to be eligible as the Substitute Asset to the prior Affected Asset in terms of sector of activity, currency, market capitalisation, liquidity, volatility, or any additional features that parties would agree to take into considerations, etc.
   */
  substitutionBeSpokeTerms?: Clause[];
  /**
   * Where the parties may optionnally explictly specify the list of Events to be considered as a trigger for a Substitution.
   */
  substitutionTriggerEvents?: ExtraordinaryEvents[];
  /**
   * Where the party who is not granted with the substitution role at least has a right to dispute the determination given by the counterparty with such role. As an example, a given PartyA is the unique Counterparty with the Role of WhoMaySubstitute, yet PartyB could be Disputing Party in regard of such Role.
   */
  disputingParty?: CounterpartyRoleEnum;
}
  
export interface UndrlygInstrm {
  swp?: Swp;
}
  
/**
 * Defines the unit to be used for price, quantity, or other purposes
 */
export interface UnitType {
  /**
   * Provides an enumerated value for a capacity unit, generally used in the context of defining quantities for commodities.
   */
  capacityUnit?: CapacityUnitEnum;
  /**
   * Provides an enumerated values for a weather unit, generally used in the context of defining quantities for commodities.
   */
  weatherUnit?: WeatherUnitEnum;
  /**
   * Provides an enumerated value for financial units, generally used in the context of defining quantities for securities.
   */
  financialUnit?: FinancialUnitEnum;
  /**
   * Defines the currency to be used as a unit for a price, quantity, or other purpose.
   */
  currency?: FieldWithMeta<String>;
}
  
/**
 * Defines the value of an investment, asset, or security
 */
export interface Valuation {
  /**
   * Current value of the outstanding contract
   */
  amount?: Money;
  /**
   * Date and time of the last valuation marked to market, provided by the central counterparty (CCP) or calculated using the current or last available market price of the inputs.
   */
  timestamp?: Date;
  /**
   * Method used for the valuation of the transaction by the valuation party.
   */
  method?: ValuationTypeEnum;
  /**
   * Source of the valuation of the transaction by the valuation party.
   */
  source?: ValuationSourceEnum;
  /**
   * The ratio of the change in the price of a derivative transaction to the change in the price of the underlying. This field is applicable only to options and swaptions.
   */
  delta?: number;
  /**
   * Denotes when the valuation was sourced during a business day.
   */
  valuationTiming?: PriceTimingEnum;
  /**
   * Denotes the price used to compute the valuation.
   */
  priceComponent?: Price;
}
  
/**
 * A single object that represents the different methods to specify a valuation date, as used for cash settlement. The Single / Multiple ValuationDate is used for the determination of recovery in a credit event, the RelativeDateOffset is used for cash-settled option, and FxFixingDate is used for cross-currency settlement.
 */
export interface ValuationDate {
  /**
   * Where single valuation date is specified as being applicable for cash settlement, this element specifies the number of business days after satisfaction of all conditions to settlement when such valuation date occurs. ISDA 2003 Term: Single Valuation Date.
   */
  singleValuationDate?: SingleValuationDate;
  /**
   * Where multiple valuation dates are specified as being applicable for cash settlement, this element specifies (a) the number of applicable valuation dates, and (b) the number of business days after satisfaction of all conditions to settlement when the first such valuation date occurs, and (c) the number of business days thereafter of each successive valuation date. ISDA 2003 Term: Multiple Valuation Dates.
   */
  multipleValuationDates?: MultipleValuationDates;
  /**
   * The date on which the cash settlement amount will be determined according to the cash settlement method if the parties have not otherwise been able to agree the cash settlement amount. This attribute was formerly part of 'OptionCashSettlement', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
   */
  valuationDate?: RelativeDateOffset;
  /**
   * The date on which the currency rate will be determined for the purpose of specifying the amount in deliverable currency. This attribute was formerly part of 'NonDeliverableSettlement', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
   */
  fxFixingDate?: FxFixingDate;
  /**
   * The date, when expressed as a schedule of date(s), on which the currency rate will be determined for the purpose of specifying the amount in deliverable currency. This attribute was formerly part of 'NonDeliverableSettlement', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
   */
  fxFixingSchedule?: AdjustableDates;
}
  
/**
 * Defines how and when a performance type option or performance type swap is to be valued, including initial, interim and final valuation dates.
 */
export interface ValuationDates {
  /**
   * Specifies the initial valuation dates of the underlyer.
   */
  initialValuationDate?: PerformanceValuationDates;
  /**
   * Specifies the interim valuation dates of the underlyer.
   */
  interimValuationDate?: PerformanceValuationDates;
  /**
   * Specifies the final valuation dates of the underlyer.
   */
  finalValuationDate?: PerformanceValuationDates;
}
  
/**
 * Specifies inputs needed to process a valuation.
 */
export interface ValuationInstruction {
  /**
   * Contains all information related to a valuation.
   */
  valuation?: Valuation[];
  /**
   * Specifies whether the previous valuation tracks in the valuation history are removed (True) or kept (False).
   */
  replace?: boolean;
}
  
/**
 * Specifies the parameters required to obtain a valuation, including the source, quotation method (bid, mid etc.) and any applicable quotation amount.
 */
export interface ValuationMethod {
  /**
   * The source for obtaining a valuation. This may come from some information source (e.g. Reuters), from a rate option fixing (e.g. FX fixing for cross-currency settlement), or from a set of reference banks. This is a mandatory attribute as the valuation method relies on one of those sources to be specified.
   */
  valuationSource?: ValuationSource;
  /**
   * The type of price quotations to be requested from dealers when determining the market value of the reference obligation for purposes of cash settlement, or which rate quote is to be observed for a fixing. For example, Bid, Offer, Mid-market or Exercising Party Pays. ISDA 2003 Term: Quotation Method. The meaning of Exercising Party Pays is defined in the 2000 ISDA Definitions, Section 17.2. Certain Definitions Relating to Cash Settlement, paragraph (j).
   */
  quotationMethod?: QuotationRateTypeEnum;
  /**
   * The ISDA defined methodology for determining the final price of the reference obligation for purposes of cash settlement. (ISDA 2003 Term: Valuation Method). For example, Market, Highest etc.
   */
  valuationMethod?: ValuationMethodEnum;
  /**
   * In the determination of a cash settlement amount, if weighted average quotations are to be obtained, the quotation amount specifies an upper limit to the outstanding principal balance of the reference obligation for which the quote should be obtained. If not specified, the ISDA definitions provide for a fallback amount equal to the floating rate payer calculation amount. ISDA 2003 Term: Quotation Amount.
   */
  quotationAmount?: Money;
  /**
   * In the determination of a cash settlement amount, if weighted average quotations are to be obtained, the minimum quotation amount specifies a minimum intended threshold amount of outstanding principal balance of the reference obligation for which the quote should be obtained. If not specified, the ISDA definitions provide for a fallback amount of the lower of either USD 1,000,000 (or its equivalent in the relevant obligation currency) or the quotation amount. ISDA 2003 Term: Minimum Quotation Amount.
   */
  minimumQuotationAmount?: Money;
  /**
   * Specifies the parameters representing several mid-market valuation and replacement value methods.
   */
  cashCollateralValuationMethod?: CashCollateralValuationMethod;
}
  
/**
 * Specifies how long to wait to get a quote from a settlement rate option upon a price source disruption.
 */
export interface ValuationPostponement {
  /**
   * The maximum number of days to wait for a quote from the disrupted settlement rate option before proceeding to the next method.
   */
  maximumDaysOfPostponement?: number;
}
  
/**
 * A class describing the method for obtaining a settlement rate, specified through either an information source (page), a settlement rate option (fixing) or by using quotes from reference banks.
 */
export interface ValuationSource {
  /**
   * Defines the two currencies for an FX trade and the quotation relationship between the two currencies.  This attribute was formerly part of 'fxSettlementTerms', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
   */
  quotedCurrencyPair?: ReferenceWithMeta<QuotedCurrencyPair>;
  /**
   * The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
   */
  informationSource?: FxSpotRateSource;
  /**
   * The rate option to use for the fixing. Currently only applicable to foreign exchange fixing in case of cross-currency settlement.
   */
  settlementRateOption?: SettlementRateOption;
  /**
   * A container for a set of reference institutions that may be called upon to provide rate quotations as part of the method to determine the applicable cash settlement amount. If institutions are not specified, it is assumed that reference institutions will be agreed between the parties on the exercise date, or in the case of swap transaction to which mandatory early termination is applicable, the cash settlement valuation date.
   */
  referenceBanks?: ReferenceBanks;
  /**
   * Holds an identifier for the reference entity that is agreed by both parties as a basis for cash settlement calculations. This could be a dealer from whom quotations are obtained by the calculation agent on the reference obligation for purposes of cash settlement in a credit event. ISDA 2003 Term: Dealer. This could be the clearing organization (CCP, DCO) to which the trade should be cleared, as applicable for cash-settled swaptions.
   */
  dealerOrCCP?: AncillaryEntity;
}
  
export interface ValuationTerms {
  /**
   * The official settlement price as announced by the related exchange is applicable, in accordance with the ISDA 2002 definitions.
   */
  futuresPriceValuation?: boolean;
  /**
   * The official settlement price as announced by the related exchange is applicable, in accordance with the ISDA 2002 definitions
   */
  optionsPriceValuation?: boolean;
  /**
   * The number of valuation dates between valuation start date and valuation end date.
   */
  numberOfValuationDates?: number;
  /**
   * Specifies the dividend valuation dates of the swap.
   */
  dividendValuationDates?: AdjustableRelativeOrPeriodicDates;
  /**
   * Specifies the fallback provisions for Hedging Party in the determination of the Final Price.
   */
  fPVFinalPriceElectionFallback?: FPVFinalPriceElectionFallbackEnum;
  /**
   * For an index option transaction, a flag to indicate whether a relevant Multiple Exchange Index Annex is applicable to the transaction. This annex defines additional provisions which are applicable where an index is comprised of component securities that are traded on multiple exchanges.
   */
  multipleExchangeIndexAnnexFallback?: boolean;
  /**
   * For an index option transaction, a flag to indicate whether a relevant Component Security Index Annex is applicable to the transaction.
   */
  componentSecurityIndexAnnexFallback?: boolean;
}
  
export interface VarianceCapFloor {
  /**
   * If present and true, then variance cap is applicable.
   */
  varianceCap?: boolean;
  /**
   * For use when varianceCap is applicable. Contains the scaling factor of the Variance Cap that can differ on a trade-by-trade basis in the European market. For example, a Variance Cap of 2.5^2 x Variance Strike Price has an unadjustedVarianceCap of 2.5.
   */
  unadjustedVarianceCap?: number;
  /**
   * Conditions which bound variance. The contract specifies one or more boundary levels. These levels are expressed as prices for confirmation purposes Underlyer price must be equal to or higher than Lower Barrier is known as Up Conditional Swap Underlyer price must be equal to or lower than Upper Barrier is known as Down Conditional Swap Underlyer price must be equal to or higher than Lower Barrier and must be equal to or lower than Upper Barrier is known as Barrier Conditional Swap.
   */
  boundedVariance?: BoundedVariance;
}
  
export interface VarianceReturnTerms extends ReturnTermsBase {
  /**
   * Contains all non-date valuation information.
   */
  valuationTerms?: ValuationTerms;
  /**
   * This specifies the numerator of an annualization factor. Frequently this number is equal to the number of observations of prices in a year e.g. 252.
   */
  annualizationFactor?: number;
  /**
   * The parameters which define whether dividends are applicable
   */
  dividendApplicability?: DividendApplicability;
  /**
   * Contains Equity Underlyer provisions regarding jurisdiction and fallbacks.
   */
  equityUnderlierProvisions?: EquityUnderlierProvisions;
  /**
   * Indicates whether the price of shares is adjusted for dividends or not.
   */
  sharePriceDividendAdjustment?: boolean;
  /**
   * Expected number of trading days.
   */
  expectedN?: number;
  /**
   * Contract will strike off this initial level. Providing just the initialLevel without initialLevelSource, infers that this is AgreedInitialPrice - a specified Initial Index Level.
   */
  initialLevel?: number;
  /**
   * In this context, this is AgreedInitialPrice - a specified Initial Index Level.
   */
  initialLevelSource?: DeterminationMethodEnum;
  /**
   * Specifies whether Mean Adjustment is applicable or not in the calculation of the Realized Volatility, Variance or Correlation
   */
  meanAdjustment?: boolean;
  /**
   * Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.
   */
  performance?: string;
  /**
   * Variance Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.
   */
  varianceStrikePrice?: Price;
  /**
   * Volatility Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.
   */
  volatilityStrikePrice?: Price;
  /**
   * Contains possible barriers for variance products, both variance-based and underlier price based
   */
  varianceCapFloor?: VarianceCapFloor;
  /**
   * Contains containing volatility-based barriers
   */
  volatilityCapFloor?: VolatilityCapFloor;
  /**
   * Vega Notional represents the approximate gain/loss at maturity for a 1% difference between RVol (realised vol) and KVol (strike vol). It does not necessarily represent the Vega Risk of the trade.
   */
  vegaNotionalAmount?: NonNegativeQuantitySchedule;
  /**
   * Specification of the exchange traded contract nearest.
   */
  exchangeTradedContractNearest?: ReferenceWithMeta<Observable>;
}
  
export interface Velocity {
  periodMultiplier?: number;
  period?: PeriodTimeEnum;
}
  
/**
 * Contains volatility-based barriers. Volatility Cap needs to be specified in accordance with the ISDA 2011 Equity Derivatives Definitions.
 */
export interface VolatilityCapFloor {
  /**
   * Indicates whether the volatility cap is applicable in accordance with the ISDA 2011 Equity Derivatives Definitions. Setting the element 'applicable' to 'False' - means No Volatility Cap and no 'totalVolatilityCap' or 'volatilityCapFactor' should be provided. Setting the element 'applicable' to 'True' - means Volatility Cap election, then 'totalVolatilityCap' or 'volatilityCapFactor' should be provided, otherwise it defaults to volatilityCapFactor=2.5.
   */
  applicable?: boolean;
  /**
   * Volatility Cap Amount in accordance with the ISDA 2011 Equity Derivatives Definitions. This means the Volatility Cap Amount election is a number.
   */
  totalVolatilityCap?: number;
  /**
   * Volatility Cap Amount in accordance with the ISDA 2011 Equity Derivatives Definitions. The Calculated VolCapAmt can be optionally provided.
   */
  volatilityCapFactor?: number;
}
  
export interface VolatilityReturnTerms extends ReturnTermsBase {
  /**
   * Contains all non-date valuation information.
   */
  valuationTerms?: ValuationTerms;
  /**
   * This specifies the numerator of an annualization factor. Frequently this number is equal to the number of observations of prices in a year e.g. 252.
   */
  annualizationFactor?: number;
  /**
   * The parameters which define whether dividends are applicable
   */
  dividendApplicability?: DividendApplicability;
  /**
   * Contains Equity Underlyer provisions regarding jurisdiction and fallbacks.
   */
  equityUnderlierProvisions?: EquityUnderlierProvisions;
  /**
   * Indicates whether the price of shares is adjusted for dividends or not.
   */
  sharePriceDividendAdjustment?: boolean;
  /**
   * Expected number of trading days.
   */
  expectedN?: number;
  /**
   * Contract will strike off this initial level. Providing just the initialLevel without initialLevelSource, infers that this is AgreedInitialPrice - a specified Initial Index Level.
   */
  initialLevel?: number;
  /**
   * In this context, this is AgreedInitialPrice - a specified Initial Index Level.
   */
  initialLevelSource?: DeterminationMethodEnum;
  /**
   * Specifies whether Mean Adjustment is applicable or not in the calculation of the Realized Volatility, Variance or Correlation
   */
  meanAdjustment?: boolean;
  /**
   * Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.
   */
  performance?: string;
  /**
   * Volatility Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.
   */
  volatilityStrikePrice?: Price;
  /**
   * Contains volatility-based barriers
   */
  volatilityCapFloor?: VolatilityCapFloor;
  /**
   * Specification of the exchange traded contract nearest.
   */
  exchangeTradedContractNearest?: ListedDerivative;
}
  
/**
 * A single weighted averaging observation.
 */
export interface WeightedAveragingObservation {
  /**
   * Observation date time, which should be used when literal observation dates are required. The CDM specifies that the zoned date time is to be expressed in accordance with ISO 8601, either as UTC as an offset to UTC.
   */
  dateTime?: Date;
  /**
   * Observation number, which should be unique, within a series generated by a date schedule.
   */
  observationNumber?: number;
  /**
   * Observation weight, which is used as a multiplier for the observation value.
   */
  weight?: number;
}
  
/**
 * A collection of workflow steps which together makeup an entire workflow sequence.
 */
export interface Workflow {
  steps?: WorkflowStep[];
}
  
/**
 * A class to specify workflow information, which is conceptually applicable to all lifecycle events.
 */
export interface WorkflowState {
  /**
   * The workflow status indicator, e.g. Accepted, Rejected, ...
   */
  workflowStatus?: WorkflowStatusEnum;
  /**
   * A comment field to be associated with the workflow, e.g. to specify why a transaction event was rejected by a party.
   */
  comment?: string;
  /**
   * Workflow data that is specific to certain market participants and is expressed as part of the CDM in a very generic manner, which can be party-specific. The initial use cases have been derived from the CME clearing and the DTCC TIW submissions.
   */
  partyCustomisedWorkflow?: PartyCustomisedWorkflow[];
  /**
   * The identity of the warehouse, if any, that is executing that workflow step.
   */
  warehouseIdentity?: WarehouseIdentityEnum;
}
  
/**
 * A workflow step represents the state of a business event. The workflow step contains a reference to a previous WorkflowStep in order to preserve lineage. A workflow step is accepted if it contains a business event, proposed if proposedEvent is present and is rejected if the rejected flag is set.
 */
export interface WorkflowStep {
  /**
   * Life cycle event for the step. The businessEvent is optional when a proposedEvent or rejection are present.
   */
  businessEvent?: BusinessEvent;
  /**
   * Documents the life cycle event for a position.
   */
  counterpartyPositionBusinessEvent?: CounterpartyPositionBusinessEvent;
  /**
   * The proposed event for a workflow step. The proposedEvent is optional when the businessEvent or rejection are present
   */
  proposedEvent?: EventInstruction;
  /**
   * Flags this step as rejected.
   */
  rejected?: boolean;
  /**
   * Optional party approvals for the current workflow step. A workflow step can have any number of parties associated to it, thus this object is represented as a list. All parties that are expected to provide approval should have an item in this list that references them.
   */
  approval?: WorkflowStepApproval[];
  /**
   * Optional previous workflow step that provides lineage to workflow steps that precedes it.
   */
  previousWorkflowStep?: ReferenceWithMeta<WorkflowStep>;
  /**
   * The intended next event can be specified, even if the instructions are not known yet.
   */
  nextEvent?: EventInstruction;
  /**
   * Contains all information pertaining the FpML messaging header 
   */
  messageInformation?: MessageInformation;
  /**
   * The set of timestamp(s) associated with the event as a collection of [dateTime, qualifier].
   */
  timestamp?: EventTimestamp[];
  /**
   * The identifier(s) that uniquely identify a lifecycle event. The unbounded cardinality is meant to provide the ability to associate identifiers that are issued by distinct parties. As an example, each of the parties to the event may choose to associate their own identifiers to the event.
   */
  eventIdentifier?: Identifier[];
  /**
   * Specifies whether the event is a new, a correction or a cancellation.
   */
  action?: ActionEnum;
  /**
   * The specification of the event parties. This attribute is optional, as not applicable to certain events (e.g. most of the observations).
   */
  party?: Party[];
  /**
   * Optional account information that could be associated to the event.
   */
  account?: Account[];
  /**
   * The lineage attribute provides a linkage among lifecycle events through the globalKey hash value. One example is when a given lifecycle event is being corrected or cancelled. In such case, each subsequent event will have lineage into the prior version of that event. The second broad use case is when an event has a dependency upon either another event (e.g. the regular payment associated with a fix/float swap will have a lineage into the reset event, which will in turn have a lineage into the observation event for the floating rate and the contract) or a contract (e.g. the exercise of an option has a lineage into that option).
   */
  lineage?: Lineage;
  creditLimitInformation?: CreditLimitInformation;
  /**
   * The event workflow information, i.e. the workflow status, the associated comment and the partyCustomisedWorkflow which purpose is to provide the ability to associate custom workflow information to the CDM.
   */
  workflowState?: WorkflowState;
  meta?: MetaFields;
}
  
/**
 * Party approvals associated to the current WorkflowStep. 
 */
export interface WorkflowStepApproval {
  /**
   * Flag denoting whether the workflow step is approved or not
   */
  approved?: boolean;
  /**
   * Reference to the Party who is approving/rejecting this workflow step
   */
  party?: ReferenceWithMeta<Party>;
  /**
   * Optional reason for rejecting the workflow step
   */
  rejectedReason?: string;
  /**
   * Timestamp of the approval
   */
  timestamp?: EventTimestamp;
  meta?: MetaFields;
}
  
