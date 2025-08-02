/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
package org.isda.cdm.kotlin

import kotlinx.serialization.*

/**
* Basic Date implementation
*/
@Serializable
class Date (
  val year: Int,
  val month: Int,
  val day: Int
)

/**
 * A class to specify an account as an account number alongside, optionally. an account name, an account type, an account beneficiary and a servicing party.
 *
 * @param partyReference A reference to the party to which the account refers to.
 * @param accountNumber The account number.
 * @param accountName The name by which the account is known.
 * @param accountType The type of account, e.g. client, house.
 * @param accountBeneficiary A reference to the party beneficiary of the account.
 * @param servicingParty The reference to the legal entity that services the account, i.e. in the books of which the account is held.
 * @param meta 
 */
@Serializable
open class Account (
  var partyReference: ReferenceWithMetaParty? = null,
  var accountNumber: FieldWithMetaString? = null,
  var accountName: FieldWithMetaString? = null,
  var accountType: FieldWithMetaAccountTypeEnum? = null,
  var accountBeneficiary: ReferenceWithMetaParty? = null,
  var servicingParty: ReferenceWithMetaParty? = null,
  var meta: MetaFields? = null
)

@Serializable
open class AcctOwnr (
  var id: Id? = null
)

/**
 * A type for defining the Additional Disruption Events.
 *
 * @param changeInLaw Per 2002 ISDA Equity Derivatives Definitions: 
 * @param failureToDeliver Per 2002 ISDA Equity Derivatives Definitions
 * @param insolvencyFiling Per 2002 ISDA Equity Derivatives Definitions
 * @param hedgingDisruption Per 2002 ISDA Equity Derivatives Definitions
 * @param increasedCostOfHedging Per 2002 ISDA Equity Derivatives Definitions
 * @param foreignOwnershipEvent Per ISDA Def 
 * @param lossOfStockBorrow Per 2002 ISDA Equity Derivatives Definitions:
 * @param maximumStockLoanRate Specifies the maximum stock loan rate for Loss of Stock Borrow. A percentage of 5% is represented as 0.05.
 * @param increasedCostOfStockBorrow Per 2002 ISDA Equity Derivatives Definitions
 * @param initialStockLoanRate Specifies the initial stock loan per ISDA Def. A percentage of 5% is represented as 0.05.
 * @param determiningParty Specifies the party which determines additional disruption events.
 * @param additionalBespokeTerms Where parties may optionnaly describe any extra bespoke agreements, in regards of the standardized Extraordinary Events.
 */
@Serializable
open class AdditionalDisruptionEvents (
  var changeInLaw: Boolean? = null,
  var failureToDeliver: Boolean? = null,
  var insolvencyFiling: Boolean? = null,
  var hedgingDisruption: Boolean? = null,
  var increasedCostOfHedging: Boolean? = null,
  var foreignOwnershipEvent: Boolean? = null,
  var lossOfStockBorrow: Boolean? = null,
  var maximumStockLoanRate: Float? = null,
  var increasedCostOfStockBorrow: Boolean? = null,
  var initialStockLoanRate: Float? = null,
  var determiningParty: AncillaryRoleEnum? = null,
  var additionalBespokeTerms: MutableList<Clause>? = null
)

/**
 * A class to specify the events that will give rise to the payment additional fixed payments.
 *
 * @param interestShortfallReimbursement An additional Fixed Payment Event. Corresponds to the payment by or on behalf of the Issuer of an actual interest amount in respect to the reference obligation that is greater than the expected interest amount. ISDA 2003 Term: Interest Shortfall Reimbursement.
 * @param principalShortfallReimbursement An additional Fixed Payment Event. Corresponds to the payment by or on behalf of the Issuer of an actual principal amount in respect to the reference obligation that is greater than the expected principal amount. ISDA 2003 Term: Principal Shortfall Reimbursement.
 * @param writedownReimbursement An Additional Fixed Payment. Corresponds to the payment by or on behalf of the issuer of an amount in respect to the reference obligation in reduction of the prior writedowns. ISDA 2003 Term: Writedown Reimbursement.
 */
@Serializable
open class AdditionalFixedPayments (
  var interestShortfallReimbursement: Boolean? = null,
  var principalShortfallReimbursement: Boolean? = null,
  var writedownReimbursement: Boolean? = null
)

/**
 * A class to specify a post or street address.
 *
 * @param street The set of street and building number information that identifies a postal address within a city.
 * @param city The city component of the postal address.
 * @param state A country subdivision used in postal addresses in some countries. For example, US states, Canadian provinces, Swiss cantons, ...
 * @param country The ISO 3166 standard code for the country within which the postal address is located.
 * @param postalCode The code, required for computerized mail sorting systems, that is allocated to a physical address by a national postal authority.
 */
@Serializable
open class Address (
  var street: MutableList<String>? = null,
  var city: String? = null,
  var state: String? = null,
  var country: FieldWithMetaString? = null,
  var postalCode: String? = null
)

/**
 * Specification of the address and other details for notices.
 *
 * @param primaryNotices Specification of primary notice details
 * @param additionalNotices The optional specification of additional information when a party requires notices to be delivered to more than one address.
 */
@Serializable
open class AddressForNotices (
  var primaryNotices: ContactElection? = null,
  var additionalNotices: MutableList<PartyContactInformation>? = null
)

@Serializable
open class AddtlAttrbts (
  var rskRdcgTx: String? = null,
  var sctiesFincgTxInd: String? = null
)

/**
 * A class for defining a date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
 *
 * @param unadjustedDate A date subject to adjustment. While in FpML this date is required, this cardinality constraint has been relaxed as part of the CDM in order to support the FRA representation, which effective and termination dates are specified in FpML as adjusted dates.
 * @param dateAdjustments The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
 * @param dateAdjustmentsReference A pointer style reference to date adjustments defined elsewhere in the document.
 * @param adjustedDate The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
 * @param meta 
 */
@Serializable
open class AdjustableDate (
  var unadjustedDate: Date? = null,
  var dateAdjustments: BusinessDayAdjustments? = null,
  var dateAdjustmentsReference: ReferenceWithMetaBusinessDayAdjustments? = null,
  var adjustedDate: FieldWithMetaDate? = null,
  var meta: MetaFields? = null
)

/**
 * A class for defining a series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the dates.
 *
 * @param unadjustedDate A date subject to adjustment.
 * @param dateAdjustments The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
 * @param adjustedDate The date(s) once the adjustment has been performed. (Note that this date may change if the business center holidays change).
 * @param meta 
 */
@Serializable
open class AdjustableDates (
  var unadjustedDate: MutableList<Date>? = null,
  var dateAdjustments: BusinessDayAdjustments? = null,
  var adjustedDate: MutableList<FieldWithMetaDate>? = null,
  var meta: MetaFields? = null
)

/**
 * A class for defining a date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
 *
 * @param unadjustedDate A date subject to adjustment.
 * @param dateAdjustments The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
 * @param adjustedDate The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
 * @param meta 
 */
@Serializable
open class AdjustableOrAdjustedDate (
  var unadjustedDate: Date? = null,
  var dateAdjustments: BusinessDayAdjustments? = null,
  var adjustedDate: FieldWithMetaDate? = null,
  var meta: MetaFields? = null
)

/**
 * This Rosetta class specifies the date as either an unadjusted, adjusted or relative date. It supplements the features of the AdjustableOrAdjustedDate to support the credit default swap option premium, which uses the relative date construct.
 *
 * @param unadjustedDate A date subject to adjustment.
 * @param dateAdjustments The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
 * @param adjustedDate The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
 * @param relativeDate A date specified as some offset to another date (the anchor date).
 */
@Serializable
open class AdjustableOrAdjustedOrRelativeDate (
  var unadjustedDate: Date? = null,
  var dateAdjustments: BusinessDayAdjustments? = null,
  var adjustedDate: FieldWithMetaDate? = null,
  var relativeDate: RelativeDateOffset? = null
)

/**
 * A class giving the choice between defining a date as an explicit date together with applicable adjustments or as relative to some other (anchor) date.
 *
 * @param adjustableDate A date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
 * @param relativeDate A date specified as some offset to another date (the anchor date).
 * @param meta 
 */
@Serializable
open class AdjustableOrRelativeDate (
  var adjustableDate: AdjustableDate? = null,
  var relativeDate: AdjustedRelativeDateOffset? = null,
  var meta: MetaFields? = null
)

/**
 * A class giving the choice between defining a series of dates as an explicit list of dates together with applicable adjustments or as relative to some other series of (anchor) dates.
 *
 * @param adjustableDates A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
 * @param relativeDates A series of dates specified as some offset to another series of dates (the anchor dates).
 * @param meta 
 */
@Serializable
open class AdjustableOrRelativeDates (
  var adjustableDates: AdjustableDates? = null,
  var relativeDates: RelativeDates? = null,
  var meta: MetaFields? = null
)

/**
 * A class giving the choice between defining a series of dates as an explicit list of dates together with applicable adjustments or as relative to some other series of (anchor) dates, or as a calculation period schedule.
 *
 * @param adjustableDates A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
 * @param relativeDates A series of dates specified as some offset to another series of dates (the anchor dates).
 * @param periodicDates A calculation period schedule.
 * @param meta 
 */
@Serializable
open class AdjustableRelativeOrPeriodicDates (
  var adjustableDates: AdjustableDates? = null,
  var relativeDates: RelativeDates? = null,
  var periodicDates: PeriodicDates? = null,
  var meta: MetaFields? = null
)

/**
 * A type defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date) plus optional date adjustments.
 *
 * @param periodMultiplier A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
 * @param period A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
 * @param meta 
 * @param dayType In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
 * @param businessDayConvention The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
 * @param businessCenters 
 * @param businessCentersReference A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
 * @param dateRelativeTo Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
 * @param adjustedDate The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
 * @param relativeDateAdjustments The business day convention and financial business centers used for adjusting the relative date if it would otherwise fall on a day that is not a business date in the specified business centers.
 */
@Serializable
open class AdjustedRelativeDateOffset (
  var relativeDateAdjustments: BusinessDayAdjustments? = null
)
: RelativeDateOffset()

/**
 * Represents a class to specify a credit notation.
 *
 * @param creditNotation Indicates the agency rating criteria specified for the asset or issuer.
 * @param mismatchResolution Indicator for options to be used if several agency ratings (>1) are specified and its necessary to identify specific charateristics. i.e (lowest or highest).
 * @param referenceAgency identifies the dominant reference agency if there is a missmatch and several reference agencies exsist.
 * @param boundary Indicates the boundary of a credit agency rating i.e minimum or maximum.
 */
@Serializable
open class AgencyRatingCriteria (
  var creditNotation: CreditNotation? = null,
  var mismatchResolution: CreditNotationMismatchResolutionEnum? = null,
  var referenceAgency: CreditRatingAgencyEnum? = null,
  var boundary: CreditNotationBoundaryEnum? = null
)

/**
 *  Parameters to be used to filter events that are relevant to a given portfolio in order to calculate the state of this portfolio. The attributes correspond to all the possible aggregation criteria that can be used and these criteria can be combined. All the attributes are optional.
 *
 * @param dateTime To aggregate as of a particular date
 * @param totalPosition Specifies whether to calculate total position to given date, or only daily position for the given date.
 * @param positionStatus To aggregate based on position status (EXECUTED, SETTLED etc)
 * @param party To aggregate based on a selection of party(ies) / legal entity(ies).
 * @param product To aggregate based on a selection of products.
 * @param productQualifier To aggregate based on a selection of product type(s).
 * @param tradeReference 
 */
@Serializable
open class AggregationParameters (
  var dateTime: Date? = null,
  var totalPosition: Boolean? = null,
  var positionStatus: PositionStatusEnum? = null,
  var party: MutableList<ReferenceWithMetaParty>? = null,
  var product: MutableList<NonTransferableProduct>? = null,
  var productQualifier: MutableList<String>? = null,
  var tradeReference: MutableList<ReferenceWithMetaTrade>? = null
)

/**
 * Specification of the standard set of terms that define a legal agreement.
 *
 * @param creditSupportAgreementElections Elections to specify a Credit Support Annex or Credit Support Deed for Intial or Variation Margin.
 * @param collateralTransferAgreementElections Elections to specify a Collateral Transfer Agreement.
 * @param securityAgreementElections Elections to specify a Security agreement.
 * @param masterAgreementSchedule Elections to specify a Master Agreement Schedule.
 * @param transactionAdditionalTerms Any additional terms which mainly intend to specify the extraordinary events that may affect a trade and the related contractual rights and obligation of the parties when this happens
 */
@Serializable
open class Agreement (
  var creditSupportAgreementElections: CreditSupportAgreementElections? = null,
  var collateralTransferAgreementElections: CollateralTransferAgreementElections? = null,
  var securityAgreementElections: SecurityAgreementElections? = null,
  var masterAgreementSchedule: MasterAgreementSchedule? = null,
  var transactionAdditionalTerms: TransactionAdditionalTerms? = null
)

/**
 * Specifies the agreement name through an agreement type and optional detailed sub agreement type.
 *
 * @param agreementType Specification of the legal agreement type.
 * @param creditSupportAgreementType Specification of the credit support agreement type.
 * @param creditSupportAgreementMarginType specifies the type of margin for which a legal agreement is named.
 * @param contractualDefinitionsType The definitions such as those published by ISDA that will define the terms of the trade.
 * @param contractualTermsSupplement A contractual supplement (such as those published by ISDA) that will apply to the trade.
 * @param contractualMatrix A reference to a contractual matrix of elected terms/values (such as those published by ISDA) that shall be deemed to apply to the trade. The applicable matrix is identified by reference to a name and optionally a publication date. Depending on the structure of the matrix, an additional term (specified in the matrixTerm element) may be required to further identify a subset of applicable terms/values within the matrix.
 * @param masterAgreementType Specification of the master agreement type.
 * @param masterConfirmationType The type of master confirmation executed between the parties.
 * @param masterConfirmationAnnexType The type of master confirmation annex executed between the parties.
 * @param otherAgreement Definition of an agreement that is not enumerated in the CDM.
 */
@Serializable
open class AgreementName (
  var agreementType: LegalAgreementTypeEnum? = null,
  var creditSupportAgreementType: FieldWithMetaCreditSupportAgreementTypeEnum? = null,
  var creditSupportAgreementMarginType: CollateralMarginTypeEnum? = null,
  var contractualDefinitionsType: MutableList<FieldWithMetaContractualDefinitionsEnum>? = null,
  var contractualTermsSupplement: MutableList<ContractualTermsSupplement>? = null,
  var contractualMatrix: MutableList<ContractualMatrix>? = null,
  var masterAgreementType: FieldWithMetaMasterAgreementTypeEnum? = null,
  var masterConfirmationType: FieldWithMetaMasterConfirmationTypeEnum? = null,
  var masterConfirmationAnnexType: FieldWithMetaMasterConfirmationAnnexTypeEnum? = null,
  var otherAgreement: String? = null
)

/**
 * Specification of the content of a legal agreement.
 *
 * @param agreement Specification of the standard set of terms that define a legal agreement.
 * @param clauseLibrary Specification of whether the agreement terms have been negotiated using the clause library methodology.
 * @param counterparty Specification of the roles of the counterparties to the agreement.
 */
@Serializable
open class AgreementTerms (
  var agreement: Agreement? = null,
  var clauseLibrary: Boolean? = null,
  var counterparty: MutableList<Counterparty>? = null
)

/**
 * Used to combine two or more Collateral Criteria using AND logic.
 *
 * @param allCriteria 
 */
@Serializable
open class AllCriteria (
  var allCriteria: MutableList<CollateralCriteria>? = null
)

/**
 * A class to specify a currency amount or a currency amount schedule.
 *
 * @param value The initial rate or amount, as the case may be. An initial rate of 5% would be represented as 0.05.
 * @param datedValue The schedule of step date and value pairs. On each step date the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
 * @param currency The currency in which the amount schedule is denominated. The currency is specified outside of the actual schedule in order to be applied uniformly to it. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
 */
@Serializable
open class AmountSchedule (
  var currency: MutableList<FieldWithMetaString>? = null
)
: Schedule()

/**
 * Holds an identifier for an ancillary entity, either identified directly via its ancillary role or directly as a legal entity.
 *
 * @param ancillaryParty Identifies a party via its ancillary role on a transaction (e.g. CCP or DCO through which the trade should be cleared.)
 * @param legalEntity 
 */
@Serializable
open class AncillaryEntity (
  var ancillaryParty: AncillaryRoleEnum? = null,
  var legalEntity: LegalEntity? = null
)

/**
 * Defines an ancillary role enumerated value with an associated party reference. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and this AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
 *
 * @param role Specifies the AncillaryRoleEnum that is associated to the party reference. An ancillary party is any involved party that is not one of the two principal parties to the transaction.
 * @param partyReference Specifies the party, or parties, associated to the ancillary role.
 * @param onBehalfOf Optionally specifies the counterparty that the ancillary party is acting on behalf of.
 */
@Serializable
open class AncillaryParty (
  var role: AncillaryRoleEnum? = null,
  var partyReference: MutableList<ReferenceWithMetaParty>? = null,
  var onBehalfOf: CounterpartyRoleEnum? = null
)

/**
 * Used to combine two or more Collateral Criteria using OR logic.
 *
 * @param anyCriteria 
 */
@Serializable
open class AnyCriteria (
  var anyCriteria: MutableList<CollateralCriteria>? = null
)

/**
 * As per ISDA 2002 Definitions.
 *
 * @param averagingInOut 
 * @param strikeFactor The factor of strike.
 * @param averagingPeriodIn The averaging in period.
 * @param averagingPeriodOut The averaging out period.
 */
@Serializable
open class Asian (
  var averagingInOut: AveragingInOutEnum? = null,
  var strikeFactor: Float? = null,
  var averagingPeriodIn: AveragingPeriod? = null,
  var averagingPeriodOut: AveragingPeriod? = null
)

/**
 * An Asset is defined as something that can be owned and transferred in the financial markets. As a choice data type, one and only one of the attributes must be used.
 *
 * @param Cash An Asset that consists solely of a monetary holding in a currency.
 * @param Commodity An Asset comprised of raw or refined materials or agricultural products, eg gold, oil or wheat.
 * @param DigitalAsset An Asset that exists only in digital form, eg Bitcoin or Ethereum; excludes the digital representation of other Assets.
 * @param Instrument An asset that is issued by one party to one or more others; Instrument is also a choice data type.
 */
@Serializable
open class Asset (
  var cash: Cash? = null,
  var commodity: Commodity? = null,
  var digitalAsset: DigitalAsset? = null,
  var instrument: Instrument? = null
)

@Serializable
open class AssetAgencyRating (
  var assetAgencyRating: AgencyRatingCriteria? = null
)

/**
 * The base data type to specify common attributes for all Assets.
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 */
@Serializable
open class AssetBase (
  var identifier: MutableList<AssetIdentifier>? = null,
  var taxonomy: MutableList<Taxonomy>? = null,
  var isExchangeListed: Boolean? = null,
  var exchange: LegalEntity? = null,
  var relatedExchange: MutableList<LegalEntity>? = null
)

@Serializable
open class AssetCountryOfOrigin (
  var assetCountryOfOrigin: ISOCountryCodeEnum? = null
)

/**
 * Contains the information relative to the delivery of the asset.
 *
 * @param periods Defines the periods of delivery, including the delivery profile.
 * @param location Defines the location of the delivery of the commodity.
 * @param deliveryCapacity The number of units included in the transaction for each delivery interval
 */
@Serializable
open class AssetDeliveryInformation (
  var periods: AssetDeliveryPeriods? = null,
  var location: MutableList<LocationIdentifier>? = null,
  var deliveryCapacity: Quantity? = null
)

/**
 * Defines the periods of delivery, including the delivery profile.
 *
 * @param profile Defines the delivery profile of the asset, including the load type and the delivery intervals.
 * @param startDate Delivery start date
 * @param endDate Delivery end date
 */
@Serializable
open class AssetDeliveryPeriods (
  var profile: MutableList<AssetDeliveryProfile>? = null,
  var startDate: Date? = null,
  var endDate: Date? = null
)

/**
 * Defines the delivery profile of the asset, including the load type and the delivery intervals.
 *
 * @param loadType Identification of the delivery profile.
 * @param block Defines a delivery profile block, including start and end time, days of the week, duration, delivery capacity and price time interval quantity.
 * @param bankHolidaysTreatment Specifies whether the dates defined include holidays or not.
 */
@Serializable
open class AssetDeliveryProfile (
  var loadType: LoadTypeEnum? = null,
  var block: MutableList<AssetDeliveryProfileBlock>? = null,
  var bankHolidaysTreatment: BankHolidayTreatmentEnum? = null
)

/**
 * Defines a delivery profile block, including start and end time, days of the week, duration, delivery capacity and price time interval quantity.
 *
 * @param startTime The start time of the delivery interval for each block or shape.
 * @param endTime The end time of the delivery interval for each block or shape.
 * @param dayOfWeek The days of the week of the delivery.
 * @param deliveryCapacity The number of units included in the transaction for each delivery interval
 * @param priceTimeIntervalQuantity Price per quantity per delivery time interval.
 */
@Serializable
open class AssetDeliveryProfileBlock (
  var startTime: String? = null,
  var endTime: String? = null,
  var dayOfWeek: MutableList<DayOfWeekEnum>? = null,
  var deliveryCapacity: Quantity? = null,
  var priceTimeIntervalQuantity: Price? = null
)

/**
 * Defines the basic parameters of an asset transfer, e.g. a cashflow: what (the asset), how much (the quantity) and when (the settlement date).
 *
 * @param quantity Represents the amount of the asset to be transferred. The cashflow amount is always a positive number, as the cashflow direction is implied by the payer/receiver attribute.
 * @param asset Represents the object that is subject to the transfer, it could be an asset or a reference.
 * @param settlementDate Represents the date on which the transfer to due.
 */
@Serializable
open class AssetFlowBase (
  var quantity: NonNegativeQuantity? = null,
  var asset: Asset? = null,
  var settlementDate: AdjustableOrAdjustedOrRelativeDate? = null
)

/**
 * The unique identifier for an Asset, specified using an Asset Identifier Type enumerator.
 *
 * @param identifier The identifier value.
 * @param identifierType Defines the symbology source of the Asset Identifier, eg CUSIP, ISIN, etc.
 */
@Serializable
open class AssetIdentifier (
  var identifier: FieldWithMetaString? = null,
  var identifierType: AssetIdTypeEnum? = null
)

/**
 * Defines each asset movement of an asset payout.
 *
 * @param settlementDate Specifies the settlement date of securities.  In a repo transaction the purchase date would always be the effective date as specified under Economic Terms, the repurchase date would always be the termination date as specified under Economic Terms.
 * @param deliveryMethod Specifies a delivery method for the security transaction.
 */
@Serializable
open class AssetLeg (
  var settlementDate: AdjustableOrRelativeDate? = null,
  var deliveryMethod: DeliveryMethodEnum? = null
)

@Serializable
open class AssetMaturity (
  var maturityType: MaturityTypeEnum? = null,
  var maturityRange: PeriodRange? = null
)

/**
 * Security finance payout specification in case the product payout involves some form of security collateral, as in a securities financing transaction. Plus additional description for ICMA.
 *
 * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
 * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
 * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
 * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
 * @param assetLeg Defines each asset movement as a buy/sell at different dates, typically 1 near leg and 1 far leg in a securities financing transaction.
 * @param underlier Specifies the Purchased Asset, usually a Security.
 * @param minimumFee A contractual minimum amount which the borrower will pay, regardless of the duration of the loan. A mechanism for making sure that a trade generates enough income.
 * @param dividendTerms Specifies the terms under which dividends received by the borrower are passed through to the lender.
 * @param tradeType The trade type, eg repurchase transaction or buy/sell-back.
 */
@Serializable
open class AssetPayout (
  var assetLeg: MutableList<AssetLeg>? = null,
  var underlier: Asset? = null,
  var minimumFee: Money? = null,
  var dividendTerms: DividendTerms? = null,
  var tradeType: AssetPayoutTradeTypeEnum? = null
)
: PayoutBase()

/**
 * Represents a class to allow specification of the asset product type.
 *
 * @param assetType Represents a filter based on the type of collateral asset.
 * @param securityType Represents a filter based on the type of security.
 * @param debtType Represents a filter based on the type of bond.
 * @param equityType Represents a filter based on the type of equity.
 * @param fundType Represents a filter based on the type of fund.
 * @param otherAssetType Specifies the eligible asset type when not enumerated.
 */
@Serializable
open class AssetType (
  var assetType: AssetTypeEnum? = null,
  var securityType: InstrumentTypeEnum? = null,
  var debtType: DebtType? = null,
  var equityType: EquityTypeEnum? = null,
  var fundType: FundProductTypeEnum? = null,
  var otherAssetType: MutableList<String>? = null
)

/**
 * A class to specify the identifier value and its associated version.
 *
 * @param identifier The identifier value.
 * @param version The identifier version, which is specified as an integer and is meant to be incremented each time the transaction terms (whether contract or event) change. This version is made option to support the use case where the identifier is referenced without the version. The constraint that a contract and a lifecycle event need to have an associated version is enforced through data rules.
 */
@Serializable
open class AssignedIdentifier (
  var identifier: FieldWithMetaString? = null,
  var version: Int? = null
)

/**
 * A type to define automatic exercise of a swaption. With automatic exercise the option is deemed to have exercised if it is in the money by more than the threshold amount on the exercise date.
 *
 * @param thresholdRate A threshold rate. The threshold of 0.10% would be represented as 0.001
 * @param isApplicable Boolean that indicates if it has an automaticExercise
 */
@Serializable
open class AutomaticExercise (
  var thresholdRate: Float? = null,
  var isApplicable: Boolean? = null
)

/**
 * A data type that can be used to describe the inventory of securities that a party holds. The securities are held in the AvailableInventoryRecord, with each item in the array being an individual security and its associated criteria. Criteria can include the quantity available, the rate at which the security is available to borrow at, as well as other details that can affect the decision as to whether a party wants to utilise the securities listed.
 *
 * @param availableInventoryType Defines the purpose of this inventory.
 * @param messageInformation Allows details related to the availability messaging use case to be defined
 * @param party Defines all parties involved for the list of inventory records in this set of inventory. For example, when used to describe securities lending availability, this could hold the sender of the availability, the intended recipient, the beneficial owner(s), the lender (which may differ from the sender as the lender may have the same piece of availability going through multiple agents), an agent or a venue.
 * @param partyRole Defines the role(s) that party(ies) may have in relation to the inventory.
 * @param availableInventoryRecord An array holding the list of inventory being described. Each element in the inventoryRecord array represents an individual piece of inventory i.e. a security.
 */
@Serializable
open class AvailableInventory (
  var availableInventoryType: AvailableInventoryTypeEnum? = null,
  var messageInformation: MessageInformation? = null,
  var party: MutableList<Party>? = null,
  var partyRole: MutableList<PartyRole>? = null,
  var availableInventoryRecord: MutableList<AvailableInventoryRecord>? = null
)

/**
 * An individual piece of available inventory. This represents a single security and its associated criteria. The criteria are used to describe any restrictions on the securities.
 *
 * @param identifer Unique identifier for this record. This can be used to uniquely identify a specific piece of inventory.
 * @param security The security details.
 * @param expirationDateTime There may be a set period/time restriction associated to the security.
 * @param collateral The type of collateral can often be required when determining if the piece of availability being described is suitable for a party.
 * @param partyRole An individual security may be held by several agents. Including the party role at this level allows us to reference the party holding this specific item.
 * @param quantity The quantity of the security
 * @param interestRate An optional element which can be used to hold a rate associated to this piece of availability.
 */
@Serializable
open class AvailableInventoryRecord (
  var expirationDateTime: Date? = null,
  var collateral: MutableList<CollateralProvisions>? = null,
  var partyRole: MutableList<PartyRole>? = null,
  var quantity: Quantity? = null,
  var interestRate: Price? = null
)
: InventoryRecord()

/**
 * Represents the average trading volume of an Equity product upon an exchange or set of exchanges.
 *
 * @param period Represents the period of the equities average trading volume on the exchange/s.
 * @param methodology Indicates the type of equity average trading volume being stated (single) the highest amount on one exchange, or (consolidated) volumes across multiple exchanges.
 */
@Serializable
open class AverageTradingVolume (
  var period: Period? = null,
  var methodology: AverageTradingVolumeMethodologyEnum? = null
)

/**
 * Defines parameters for use in cases when a valuation or other term is based on an average of market observations.
 *
 * @param averagingMethod Specifies enumerations for the type of averaging calculation.
 * @param precision Rounding applied to the average calculation. 
 */
@Serializable
open class AveragingCalculation (
  var averagingMethod: AveragingCalculationMethod? = null,
  var precision: Rounding? = null
)

/**
 * Defines the ways in which multiple values can be aggregated into a single value.
 *
 * @param isWeighted Identifies whether the average values will be weighted or unweighted.
 * @param calculationMethod Identifies which of the Pythagorean means is being used to compute an average value.
 */
@Serializable
open class AveragingCalculationMethod (
  var isWeighted: Boolean? = null,
  var calculationMethod: AveragingCalculationMethodEnum? = null
)

/**
 * An unordered list of weighted averaging observations.
 *
 * @param averagingObservation A single weighted averaging observation.
 */
@Serializable
open class AveragingObservationList (
  var averagingObservation: MutableList<WeightedAveragingObservation>? = null
)

/**
 * Period over which an average value is taken.
 *
 * @param schedule A schedule for generating averaging observation dates.
 * @param averagingDateTimes An unweighted list of averaging observation date and times.
 * @param averagingObservations A weighted list of averaging observation date and times.
 * @param marketDisruption The market disruption event as defined by ISDA 2002 Definitions.
 */
@Serializable
open class AveragingPeriod (
  var schedule: MutableList<AveragingSchedule>? = null,
  var averagingDateTimes: DateTimeList? = null,
  var averagingObservations: AveragingObservationList? = null,
  var marketDisruption: FieldWithMetaMarketDisruptionEnum? = null
)

/**
 * Class to representing a method for generating a series of dates.
 *
 * @param startDate Date on which this period begins.
 * @param endDate Date on which this period ends.
 * @param averagingPeriodFrequency The frequency at which averaging period occurs with the regular part of the valuation schedule and their roll date convention.
 */
@Serializable
open class AveragingSchedule (
  var startDate: Date? = null,
  var endDate: Date? = null,
  var averagingPeriodFrequency: CalculationPeriodFrequency? = null
)

/**
 * Defines the terms required to calculate the average observations associated with an averaging strike.
 *
 * @param averagingCalculation Defines parameters for use in cases when a valuation or other term is based on an average of market observations.
 * @param observationTerms Class containing terms that are associated with observing a price/benchmark/index across either single or multple observations. 
 */
@Serializable
open class AveragingStrikeFeature (
  var averagingCalculation: AveragingCalculation? = null,
  var observationTerms: ObservationTerms? = null
)

/**
 * As per ISDA 2002 Definitions.
 *
 * @param barrierCap A trigger level approached from beneath.
 * @param barrierFloor A trigger level approached from above.
 */
@Serializable
open class Barrier (
  var barrierCap: TriggerEvent? = null,
  var barrierFloor: TriggerEvent? = null
)

/**
 * Defines a custom basket by referencing an identifier and its constituents.
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 * @param basketConstituent Identifies the constituents of the basket
 */
@Serializable
open class Basket (
  var basketConstituent: MutableList<FieldWithMetaBasketConstituent>? = null
)
: AssetBase()

/**
 * Identifies the constituents of the basket
 *
 * @param Asset The object to be observed is an Asset, ie something that can be owned and transferred in the financial markets.
 * @param Basket The object to be observed is a Basket, ie a collection of Observables with an identifier and optional weightings.
 * @param Index The object to be observed is an Index, ie an observable computed on the prices, rates or valuations of a number of assets.
 * @param quantity Specifies a quantity schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->quantity that this quantity is referencing.
 * @param initialValuationPrice Specifies an initial price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->price that this price is referencing.
 * @param interimValuationPrice Specifies an interim price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->price that this price is referencing.
 * @param finalValuationPrice Specifies a final price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->price that this price is referencing.
 */
@Serializable
open class BasketConstituent (
  var quantity: MutableList<ReferenceWithMetaNonNegativeQuantitySchedule>? = null,
  var initialValuationPrice: MutableList<ReferenceWithMetaPriceSchedule>? = null,
  var interimValuationPrice: MutableList<ReferenceWithMetaPriceSchedule>? = null,
  var finalValuationPrice: MutableList<ReferenceWithMetaPriceSchedule>? = null
)
: Observable()

/**
 * CDS Basket Reference Information.
 *
 * @param basketName The name of the basket expressed as a free format string. FpML does not define usage rules for this element.
 * @param basketId A CDS basket identifier.
 * @param referencePool This element contains all the reference pool items to define the reference entity and reference obligation(s) in the basket.
 * @param nthToDefault N th reference obligation to default triggers payout.
 * @param mthToDefault M th reference obligation to default to allow representation of N th to M th defaults.
 * @param tranche This element contains CDS tranche terms.
 */
@Serializable
open class BasketReferenceInformation (
  var basketName: FieldWithMetaString? = null,
  var basketId: MutableList<FieldWithMetaString>? = null,
  var referencePool: ReferencePool? = null,
  var nthToDefault: Int? = null,
  var mthToDefault: Int? = null,
  var tranche: Tranche? = null
)

/**
 * Specifies the instructions for creation of a Security Lending billing invoice.
 *
 * @param sendingParty The party issuing the invoice
 * @param receivingParty The party receiving the invoice
 * @param billingStartDate The starting date of the period described by this invoice
 * @param billingEndDate The ending date of the period described by this invoice
 * @param billingRecordInstruction Instructions for creating the billing records contained within the invoice
 * @param billingSummary The billing summaries contained within the invoice
 */
@Serializable
open class BillingInstruction (
  var sendingParty: Party? = null,
  var receivingParty: Party? = null,
  var billingStartDate: Date? = null,
  var billingEndDate: Date? = null,
  var billingRecordInstruction: MutableList<BillingRecordInstruction>? = null,
  var billingSummary: MutableList<BillingSummaryInstruction>? = null
)

/**
 * Specifies individual records within a billing invoice.
 *
 * @param tradeState The trade for the individual billing record.
 * @param recordTransfer The settlement terms for the billing record
 * @param recordStartDate The starting date of the period described by this record
 * @param recordEndDate The ending date of the period described by this record
 * @param minimumFee Indicates the minimum fee amount applied to the billing record, if any.
 */
@Serializable
open class BillingRecord (
  var tradeState: ReferenceWithMetaTradeState? = null,
  var recordTransfer: Transfer? = null,
  var recordStartDate: Date? = null,
  var recordEndDate: Date? = null,
  var minimumFee: Money? = null
)

/**
 * Specifies the instructions for creation of a billing record.
 *
 * @param tradeState The trade for the individual billing record.
 * @param observation The observations used to calculate the billing amount.
 * @param recordStartDate The starting date of the period described by this record
 * @param recordEndDate The ending date of the period described by this record
 * @param settlementDate The date for settlement of the transfer.
 */
@Serializable
open class BillingRecordInstruction (
  var tradeState: ReferenceWithMetaTradeState? = null,
  var observation: MutableList<Observation>? = null,
  var recordStartDate: Date? = null,
  var recordEndDate: Date? = null,
  var settlementDate: Date? = null
)

/**
 * Specifies individual summaries within a billing invoice.
 *
 * @param summaryTransfer The settlement terms for the billing summary
 * @param summaryAmountType The account level for the billing summary.
 */
@Serializable
open class BillingSummary (
  var summaryTransfer: Transfer? = null,
  var summaryAmountType: RecordAmountTypeEnum? = null
)

/**
 * Specifies the instructions for creation of a billing summary.
 *
 * @param summaryAmountType The account level for the billing summary.
 */
@Serializable
open class BillingSummaryInstruction (
  var summaryAmountType: RecordAmountTypeEnum? = null
)

/**
 * Reference to a bond underlier to represent an asset swap or Condition Precedent Bond.
 *
 * @param bond Reference to a bond underlier.
 * @param conditionPrecedentBond To indicate whether the Condition Precedent Bond is applicable. The swap contract is only valid if the bond is issued and if there is any dispute over the terms of fixed stream then the bond terms would be used.
 * @param discrepancyClause To indicate whether the Discrepancy Clause is applicable.
 * @param couponRate Specifies the coupon rate (expressed in percentage) of a fixed income security or convertible bond.
 */
@Serializable
open class BondReference (
  var bond: Security? = null,
  var conditionPrecedentBond: Boolean? = null,
  var discrepancyClause: Boolean? = null,
  var couponRate: FixedRateSpecification? = null
)

/**
 * Describes correlation bounds, which form a cap and a floor on the realized correlation.
 *
 * @param minimumBoundaryPercent Minimum Boundary as a percentage of the Strike Price.
 * @param maximumBoundaryPercent Maximum Boundary as a percentage of the Strike Price.
 */
@Serializable
open class BoundedCorrelation (
  var minimumBoundaryPercent: Float? = null,
  var maximumBoundaryPercent: Float? = null
)

@Serializable
open class BoundedVariance (
  var realisedVarianceMethod: RealisedVarianceMethodEnum? = null,
  var daysInRangeAdjustment: Boolean? = null,
  var upperBarrier: Float? = null,
  var lowerBarrier: Float? = null
)

/**
 * A class for defining a time with respect to a business day calendar location. For example, 11:00:00 GBLO.
 *
 * @param hourMinuteTime A time specified in hh:mm:ss format where the second component must be '00', e.g. 11am would be represented as 11:00:00.
 * @param businessCenter A code identifying a business day calendar location. A business day calendar location is drawn from the list identified by the business day calendar location enumeration.
 */
@Serializable
open class BusinessCenterTime (
  var hourMinuteTime: String? = null,
  var businessCenter: FieldWithMetaBusinessCenterEnum? = null
)

/**
 * A class for specifying the business day calendar location used in determining whether a day is a business day or not, either by specifying this business center by reference to an enumerated list that is maintained by the FpML standard, or by reference to such specification when it exists elsewhere as part of the instance document. This class corresponds to the FpML BusinessCentersOrReference.model.
 *
 * @param businessCenter A code identifying one or several business day calendar location(s). The set of business day calendar locations are specified by the business day calendar location enumeration which is maintained by the FpML standard.
 * @param commodityBusinessCalendar 
 * @param businessCentersReference A reference to a financial business center location specified elsewhere in the instance document.
 * @param meta 
 */
@Serializable
open class BusinessCenters (
  var businessCenter: MutableList<FieldWithMetaBusinessCenterEnum>? = null,
  var commodityBusinessCalendar: MutableList<FieldWithMetaCommodityBusinessCalendarEnum>? = null,
  var businessCentersReference: ReferenceWithMetaBusinessCenters? = null,
  var meta: MetaFields? = null
)

/**
 * A class defining a range of contiguous business days by defining an unadjusted first date, an unadjusted last date and a business day convention and business centers for adjusting the first and last dates if they would otherwise fall on a non business day in the specified business centers. The days between the first and last date must also be good business days in the specified centers to be counted in the range.
 *
 * @param startDate The first date of a date range.
 * @param endDate The last date of a date range.
 * @param businessDayConvention The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
 * @param businessCenters The business center(s), specified either explicitly or by reference to those specified somewhere else in the instance document.
 */
@Serializable
open class BusinessDateRange (
  var businessDayConvention: BusinessDayConventionEnum? = null,
  var businessCenters: BusinessCenters? = null
)
: DateRange()

/**
 * A class defining the business day convention and financial business centers used for adjusting any relevant date if it would otherwise fall on a day that is not a business day in the specified business center.
 *
 * @param businessDayConvention The convention for adjusting a date if it would otherwise fall on a day that is not a business day.
 * @param businessCenters The business center(s), specified either explicitly or by reference to those specified somewhere else in the instance document.
 * @param meta 
 */
@Serializable
open class BusinessDayAdjustments (
  var businessDayConvention: BusinessDayConventionEnum? = null,
  var businessCenters: BusinessCenters? = null,
  var meta: MetaFields? = null
)

/**
 * A business event represents a life cycle event of a trade. The combination of the state changes results in a qualifiable life cycle event. An example of a Business Event is a PartialTermination which is a defined by a quantity change primitive event.
 *
 * @param intent The intent attribute is meant to be specified when the event qualification cannot be programmatically inferred from the event features. As a result it is only associated with those primitives that can give way to such ambiguity, the quantityChange being one of those. An example of such is a reduction in the trade notional, which could be interpreted as either a trade correction (unless a maximum period of time post-event is specified as part of the qualification), a partial termination or a portfolio rebalancing in the case of an equity swap. On the other hand, an event such as the exercise is not expected to have an associated intent as there should not be ambiguity.
 * @param corporateActionIntent 
 * @param eventDate Specifies the date on which the event is taking place. This date is equal to the trade date in the case of a simple execution.  However it can be different from the trade date, for example in the case of a partial termination.
 * @param effectiveDate The date on which the event contractually takes effect, when different from the event date.
 * @param packageInformation Specifies the package information in case the business event represents several trades executed as a package (hence this attribute is optional). The package information is only instantiated once at the business event level to preserve referential integrity, whereas individual trades make reference to it to identify that they are part of a package.
 * @param instruction Specifies the instructions to create the Business Event.
 * @param eventQualifier The CDM event qualifier, which corresponds to the outcome of the isEvent qualification logic which qualifies the lifecycle event as a function of its features (e.g. PartialTermination, ClearingSubmission, Novation, ...).
 * @param after Specifies the after trade state(s) created.
 * @param meta 
 */
@Serializable
open class BusinessEvent (
  var eventQualifier: String? = null,
  var after: MutableList<TradeState>? = null,
  var meta: MetaFields? = null
)
: EventInstruction()

/**
 * A class to specify an organizational unit.
 *
 * @param name A name used to describe the organizational unit
 * @param identifier An identifier used to uniquely identify the organizational unit
 * @param contactInformation The contact information for such business unit, when different from the contact information associated with the party.
 * @param meta 
 */
@Serializable
open class BusinessUnit (
  var name: String? = null,
  var identifier: Identifier? = null,
  var contactInformation: ContactInformation? = null,
  var meta: MetaFields? = null
)

/**
 * This class corresponds to the FpML BuyerSeller.model construct.
 *
 * @param buyer Buyer party that can be resolved as one of the two principal parties to the transaction. The party that buys this instrument, i.e. pays for this instrument and receives the rights defined by it. ISDA 2002 Equity Definitions section 1.18: `Buyer` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (b)(i) relating to a Swaption: 'Buyer' means the party that will, on each Premium Payment Date, pay to Seller the Premium | ISDA 2006 Definitions article 12.1 (b)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such in the related Confirmation, or the Exercising Party if neither party is specified | ISDA 2006 Definitions article 12.1 (b)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Buyer` means the Fixed Rate Payer.
 * @param seller Seller party that can be resolved as one of the two principal parties to the transaction. The party that sells ('writes') this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. ISDA 2002 Equity Definitions section 1.19: `Seller` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (a)(i) relating to a Swaption: 'Seller' means the party the party specified as such or as writer in the related Confirmation | ISDA 2006 Definitions article 12.1 (a)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such or as writer in the related Confirmation or, if neither party is specified as such, the Non-exercising Party | ISDA 2006 Definitions article 12.1 (a)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Seller` means the Floating Rate Payer.
 */
@Serializable
open class BuyerSeller (
  var buyer: CounterpartyRoleEnum? = null,
  var seller: CounterpartyRoleEnum? = null
)

@Serializable
open class Buyr (
  var acctOwnr: AcctOwnr? = null
)

/**
 * Defines the tradeState or payout on which to create a Transfer along with all necessary resets.
 *
 * @param tradeState 
 * @param payout 
 * @param resets 
 * @param payerReceiver 
 * @param quantity Specifies quantity amount returned if not the full amount from the TradeState, e.g. partial return
 * @param date 
 */
@Serializable
open class CalculateTransferInstruction (
  var tradeState: TradeState? = null,
  var payout: ReferenceWithMetaPayout? = null,
  var resets: MutableList<Reset>? = null,
  var payerReceiver: PayerReceiver? = null,
  var quantity: Quantity? = null,
  var date: Date? = null
)

/**
 * Type for reporting details of calculated rates, including the observations that went into the final reported rate.
 *
 * @param observations The observation dates and weights for each observation date.
 * @param weightedRates The weighted value of each observation.
 * @param growthFactor The daily growth factors, showing the weighted rates divided by the day count basis plus one, giving how much the value grows for each step in the calculation.
 * @param compoundedGrowth The compounding curve, showing how the initial value grew during the calculation period.
 * @param aggregateValue The total sum or product of all the individual terms that went into the calculated rate.
 * @param aggregateWeight The total weight of all the terms that went into the calculated rate.
 * @param calculatedRate The resulting calculated weight.
 */
@Serializable
open class CalculatedRateDetails (
  var observations: CalculatedRateObservations? = null,
  var weightedRates: MutableList<Float>? = null,
  var growthFactor: MutableList<Float>? = null,
  var compoundedGrowth: MutableList<Float>? = null,
  var aggregateValue: Float? = null,
  var aggregateWeight: Float? = null,
  var calculatedRate: Float? = null
)

/**
 * Type for reporting the observations dates and the corresponding weights going into a daily calculated rate
 *
 * @param observationDates The observation date upon which the rate is observed.
 * @param weights The corresponding weight for each date.
 */
@Serializable
open class CalculatedRateObservationDatesAndWeights (
  var observationDates: MutableList<Date>? = null,
  var weights: MutableList<Float>? = null
)

/**
 * Type for reporting observations that went into the final reported rate.
 *
 * @param observationDates The observation date upon which the rate is observed.
 * @param weights The corresponding weight for each date.
 * @param observedRates The value observed for that date
 * @param processedRates The value after any processing, such as application of caps or floors.
 */
@Serializable
open class CalculatedRateObservations (
  var observationDates: MutableList<Date>? = null,
  var weights: MutableList<Float>? = null,
  var observedRates: MutableList<Float>? = null,
  var processedRates: MutableList<Float>? = null
)

/**
 * A class defining the ISDA calculation agent responsible for performing duties as defined in the applicable product definitions.
 *
 * @param calculationAgentParty Specifies the party which is the ISDA Calculation Agent for the trade. If more than one party is referenced then the parties are assumed to be co-calculation agents, i.e. they have joint responsibility.
 * @param calculationAgentPartyEnum Specifies the ISDA calculation agent responsible for performing duties as defined in the applicable product definitions. For example, the Calculation Agent may be defined as being the Non-exercising Party.
 * @param calculationAgentBusinessCenter The city in which the office through which ISDA Calculation Agent is acting for purposes of the transaction is located The short-form confirm for a trade that is executed under a Sovereign or Asia Pacific Master Confirmation Agreement ( MCA ), does not need to specify the Calculation Agent. However, the confirm does need to specify the Calculation Agent City. This is due to the fact that the MCA sets the value for Calculation Agent but does not set the value for Calculation Agent City.
 */
@Serializable
open class CalculationAgent (
  var calculationAgentParty: AncillaryRoleEnum? = null,
  var calculationAgentPartyEnum: PartyDeterminationEnum? = null,
  var calculationAgentBusinessCenter: FieldWithMetaBusinessCenterEnum? = null
)

/**
 * Represents the parameters for describing how often something (such as collateral interest) is to be calculated.
 *
 * @param period Specifies the time period at which calculation is performed, e.g. 1 month.
 * @param monthOfYear Specifies the month of the year if used.
 * @param dayOfMonth Specifies the day of the month if used.
 * @param dayOfWeek Specifies the day of the week if used.
 * @param weekOfMonth Specifies the week of the month if used.
 * @param offsetDays Specifies how many days from the trigger event should the payment occur.
 * @param dateLocation Specifies where is the time measured.
 * @param businessCenter Specifies the business center for adjustment of calculation period.
 */
@Serializable
open class CalculationFrequency (
  var period: Period? = null,
  var monthOfYear: Float? = null,
  var dayOfMonth: Float? = null,
  var dayOfWeek: DayOfWeekEnum? = null,
  var weekOfMonth: Float? = null,
  var offsetDays: Float? = null,
  var dateLocation: BusinessCenterTime? = null,
  var businessCenter: MutableList<BusinessCenterEnum>? = null
)

/**
 * A data defining:  the parameters used in the calculation of a fixed or floating rate calculation period amount. This data forms:  part of cashflows representation of a swap stream.
 *
 * @param adjustedStartDate The calculation period start date, adjusted according to any relevant business day convention.
 * @param adjustedEndDate The calculation period end date, adjusted according to any relevant business day convention.
 * @param meta 
 * @param unadjustedStartDate The calculation start date, unadjusted.
 * @param unadjustedEndDate The calculation end date, unadjusted.
 * @param calculationPeriodNumberOfDays The number of days from the adjusted effective / start date to the adjusted termination / end date calculated in accordance with the applicable day count fraction.
 * @param notionalAmount The amount that a cashflow will accrue interest on.
 * @param fxLinkedNotionalAmount The amount that a cashflow will accrue interest on. This is the calculated amount of the FX linked - i.e. the other currency notional amount multiplied by the appropriate FX spot rate.
 * @param floatingRateDefinition The floating rate reset information for the calculation period.
 * @param fixedRate The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
 * @param dayCountYearFraction The year fraction value of the calculation period, result of applying the ISDA rules for day count fraction defined in the ISDA Annex.
 * @param forecastAmount The amount representing the forecast of the accrued value of the calculation period. An intermediate value used to generate the forecastPaymentAmount in the PaymentCalculationPeriod.
 * @param forecastRate A value representing the forecast rate used to calculate the forecast future value of the accrual period. This is a calculated rate determined based on averaging the rates in the rateObservation elements, and incorporates all of the rate treatment and averaging rules. A value of 1% should be represented as 0.01.
 */
@Serializable
open class CalculationPeriod (
  var unadjustedStartDate: Date? = null,
  var unadjustedEndDate: Date? = null,
  var calculationPeriodNumberOfDays: Int? = null,
  var notionalAmount: Float? = null,
  var fxLinkedNotionalAmount: FxLinkedNotionalAmount? = null,
  var floatingRateDefinition: FloatingRateDefinition? = null,
  var fixedRate: Float? = null,
  var dayCountYearFraction: Float? = null,
  var forecastAmount: Money? = null,
  var forecastRate: Float? = null
)
: CalculationPeriodBase()

/**
 * The calculation period adjusted start and end dates, which are the baseline arguments needed to compute an interest accrual calculation.
 *
 * @param adjustedStartDate The calculation period start date, adjusted according to any relevant business day convention.
 * @param adjustedEndDate The calculation period end date, adjusted according to any relevant business day convention.
 * @param meta 
 */
@Serializable
open class CalculationPeriodBase (
  var adjustedStartDate: Date? = null,
  var adjustedEndDate: Date? = null,
  var meta: MetaFields? = null
)

@Serializable
open class CalculationPeriodData (
  var startDate: Date? = null,
  var endDate: Date? = null,
  var daysInPeriod: Int? = null,
  var daysInLeapYearPeriod: Int? = null,
  var isFirstPeriod: Boolean? = null,
  var isLastPeriod: Boolean? = null
)

/**
 * A data for:  defining the parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods. A calculation period schedule consists of an optional initial stub calculation period, one or more regular calculation periods and an optional final stub calculation period. In the absence of any initial or final stub calculation periods, the regular part of the calculation period schedule is assumed to be between the effective date and the termination date. No implicit stubs are allowed, i.e. stubs must be explicitly specified using an appropriate combination of firstPeriodStartDate, firstRegularPeriodStartDate and lastRegularPeriodEndDate.
 *
 * @param effectiveDate The first day of the terms of the trade. This day may be subject to adjustment in accordance with a business day convention.
 * @param terminationDate The last day of the terms of the trade. This date may be subject to adjustments in accordance with the business day convention. It can also be specified in relation to another scheduled date (e.g. the last payment date).
 * @param calculationPeriodDatesAdjustments The specification of the business day convention and financial business centers used for adjusting any calculation period date if it would otherwise fall on a day that is not a business day in the specified business center.
 * @param firstPeriodStartDate The start date of the calculation period. FpML specifies that for interest rate swaps this date must only be specified if it is not equal to the effective date. It is always specified in the case of equity swaps and credit default swaps with periodic payments. This date may be subject to adjustment in accordance with a business day convention.
 * @param firstRegularPeriodStartDate The start date of the regular part of the calculation period schedule. It must only be specified if there is an initial stub calculation period. This day may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
 * @param firstCompoundingPeriodEndDate The end date of the initial compounding period when compounding is applicable. It must only be specified when the compoundingMethod element is present and not equal to a value of None. This date may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
 * @param lastRegularPeriodEndDate The end date of the regular part of the calculation period schedule. It must only be specified if there is a final stub calculation period. This day may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
 * @param stubPeriodType Method to allocate any irregular period remaining after regular periods have been allocated between the effective and termination date.
 * @param calculationPeriodFrequency The frequency at which calculation period end dates occur with the regular part of the calculation period schedule and their roll date convention.
 * @param meta 
 */
@Serializable
open class CalculationPeriodDates (
  var effectiveDate: AdjustableOrRelativeDate? = null,
  var terminationDate: AdjustableOrRelativeDate? = null,
  var calculationPeriodDatesAdjustments: BusinessDayAdjustments? = null,
  var firstPeriodStartDate: AdjustableOrRelativeDate? = null,
  var firstRegularPeriodStartDate: Date? = null,
  var firstCompoundingPeriodEndDate: Date? = null,
  var lastRegularPeriodEndDate: Date? = null,
  var stubPeriodType: StubPeriodTypeEnum? = null,
  var calculationPeriodFrequency: CalculationPeriodFrequency? = null,
  var meta: MetaFields? = null
)

/**
 * A class to specify the frequency at which calculation period end dates occur within the regular part of the calculation period schedule and their roll date convention.
 *
 * @param periodMultiplier A time period multiplier, e.g. 1, 2, or 3. If the period value is T (Term) then period multiplier must contain the value 1.
 * @param period A time period, e.g. a day, week, month, year or term of the stream.
 * @param meta 
 * @param rollConvention The roll convention specifies the period term as part of a periodic schedule, i.e. the calculation period end date within the regular part of the calculation period. The value could be a rule, e.g. IMM Settlement Dates, which is the 3rd Wednesday of the month, or it could be a specific day of the month, such as the first day of the applicable month. It is used in conjunction with a frequency and the regular period start date of a calculation period.
 * @param balanceOfFirstPeriod Indicates, when true, that that the first Calculation Period should run from the Effective Date to the end of the calendar period in which the Effective Date falls, e.g. Jan 15 - Jan 31 if the calculation periods are one month long and Effective Date is Jan 15. If false, the first Calculation Period should run from the Effective Date for one whole period, e.g. Jan 15 to Feb 14 if the calculation periods are one month long and Effective Date is Jan 15. Mostly used in Commmodity Swaps.
 */
@Serializable
open class CalculationPeriodFrequency (
  var rollConvention: RollConventionEnum? = null,
  var balanceOfFirstPeriod: Boolean? = null
)
: Frequency()

/**
 * A class that allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
 *
 * @param schedulePeriod Defines a period of a calculation schedule structure.
 */
@Serializable
open class CalculationSchedule (
  var schedulePeriod: MutableList<SchedulePeriod>? = null
)

/**
 * Period and time profile over which the delivery takes place.
 *
 * @param profile Defines the delivery profile of the asset, including the load type and the delivery intervals.
 * @param startDate Delivery start date
 * @param endDate Delivery end date
 * @param deliveryCapacity The number of units included in the transaction for each delivery interval
 * @param priceTimeIntervalQuantity Price per quantity per delivery time interval.
 */
@Serializable
open class CalculationScheduleDeliveryPeriods (
  var deliveryCapacity: Quantity? = null,
  var priceTimeIntervalQuantity: Price? = null
)
: AssetDeliveryPeriods()

/**
 * A type for defining a calendar spread feature.
 *
 * @param expirationDateTwo 
 */
@Serializable
open class CalendarSpread (
  var expirationDateTwo: AdjustableOrRelativeDate? = null
)

/**
 * A data defining:  the right of a party to cancel a swap transaction on the specified exercise dates. The provision is for 'walk-away' cancellation (i.e. the fair value of the swap is not paid). A fee payable on exercise can be specified. As a difference from the FpML construct, the canonical model extends the BuyerSeller class.
 *
 * @param buyer Buyer party that can be resolved as one of the two principal parties to the transaction. The party that buys this instrument, i.e. pays for this instrument and receives the rights defined by it. ISDA 2002 Equity Definitions section 1.18: `Buyer` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (b)(i) relating to a Swaption: 'Buyer' means the party that will, on each Premium Payment Date, pay to Seller the Premium | ISDA 2006 Definitions article 12.1 (b)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such in the related Confirmation, or the Exercising Party if neither party is specified | ISDA 2006 Definitions article 12.1 (b)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Buyer` means the Fixed Rate Payer.
 * @param seller Seller party that can be resolved as one of the two principal parties to the transaction. The party that sells ('writes') this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. ISDA 2002 Equity Definitions section 1.19: `Seller` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (a)(i) relating to a Swaption: 'Seller' means the party the party specified as such or as writer in the related Confirmation | ISDA 2006 Definitions article 12.1 (a)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such or as writer in the related Confirmation or, if neither party is specified as such, the Non-exercising Party | ISDA 2006 Definitions article 12.1 (a)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Seller` means the Floating Rate Payer.
 * @param exerciseNotice Definition of the party to whom notice of exercise should be given.
 * @param followUpConfirmation A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller's agent.
 * @param cancelableProvisionAdjustedDates The adjusted dates associated with a cancelable provision. These dates have been adjusted for any applicable business day convention.
 * @param finalCalculationPeriodDateAdjustment Business date convention adjustment to final payment period per leg (swapStream) upon exercise event. The adjustments can be made in-line with leg level BDC's or they can be specified separately.
 * @param initialFee An initial fee for the cancelable option.
 * @param callingParty The party with right to exercise a cancellation. Allows for buyer, seller or either.
 * @param earliestDate The first day when cancelation is permitted to take effect. A party may give notice prior to this date and taken together with the effective period would be necessary to cancel on this date.
 * @param expirationDate The last day within the term of the contract that cancelation is allowed.
 * @param effectiveDate The effective date if cancelation is invoked otherwise the cancellation period defines the cancellation date.
 * @param effectivePeriod Effective period for cancelation when notice is given. This is the period after notice is given that cancellation becomes effecticve.
 * @param earliestCancellationTime The earliest time in a business day that notice of cancelation can be given.
 * @param latestCancelationTime The latest time at which notice of cancelation can be given.
 * @param exerciseTerms The exercise terms associated with the cancelable provision, including details such as exercise style, exercise fees, and any other relevant conditions or terms governing the cancellation of the swap transaction.
 */
@Serializable
open class CancelableProvision (
  var exerciseNotice: ExerciseNotice? = null,
  var followUpConfirmation: Boolean? = null,
  var cancelableProvisionAdjustedDates: CancelableProvisionAdjustedDates? = null,
  var finalCalculationPeriodDateAdjustment: MutableList<FinalCalculationPeriodDateAdjustment>? = null,
  var initialFee: Transfer? = null,
  var callingParty: CallingPartyEnum? = null,
  var earliestDate: AdjustableOrRelativeDate? = null,
  var expirationDate: AdjustableOrRelativeDate? = null,
  var effectiveDate: AdjustableOrRelativeDates? = null,
  var effectivePeriod: Period? = null,
  var earliestCancellationTime: BusinessCenterTime? = null,
  var latestCancelationTime: BusinessCenterTime? = null,
  var exerciseTerms: ExerciseTerms? = null
)
: BuyerSeller()

/**
 * A data to:  define the adjusted dates for a cancelable provision on a swap transaction.
 *
 * @param cancellationEvent The adjusted dates for an individual cancellation date.
 */
@Serializable
open class CancelableProvisionAdjustedDates (
  var cancellationEvent: MutableList<CancellationEvent>? = null
)

/**
 * The adjusted dates for a specific cancellation date, including the adjusted exercise date and adjusted termination date.
 *
 * @param adjustedExerciseDate The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
 * @param adjustedEarlyTerminationDate The early termination date that is applicable if an early termination provision is exercised. This date should already be adjusted for any applicable business day convention.
 * @param meta 
 */
@Serializable
open class CancellationEvent (
  var adjustedExerciseDate: Date? = null,
  var adjustedEarlyTerminationDate: Date? = null,
  var meta: MetaFields? = null
)

/**
 * An Asset that consists solely of a monetary holding in a currency. The currency of the Cash asset is held in the string Identifier (from AssetBase) and the AssetIdTypeEnum must be set to define that a CurrencyCode is set.  The function SetCashCurrency can be used to create (or update) a Cash object and the function GetCashCurrency can be used to retrieve the currency of a Cash object.
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 */
@Serializable
open class Cash (
)
: AssetBase()

/**
 * This type is a generic structure that can represent the parameters of several mid-market valuation and replacement value methods described in the 2021 ISDA Definitions.
 *
 * @param applicableCsa This may be used to specify what type of CSA (credit support annex/agreement) is to be used for cash settlement purposes.
 * @param cashCollateralCurrency This may be used to indicate the currency of cash collateral for cash settlement purposes.
 * @param cashCollateralInterestRate This may be used to indicate the interest rate to be used for cash collateral for cash settlement purposes.
 * @param agreedDiscountRate This may be used to indicate the discount rate to be used for cash collateral for cash settlement purposes.
 * @param protectedParty This may be used to specify which party is protected (e.g. under Replacement Value cash settlement methods).
 * @param prescribedDocumentationAdjustment This may be used to indicate that 'prescribed documentation adjustment' is applicable.
 */
@Serializable
open class CashCollateralValuationMethod (
  var applicableCsa: CsaTypeEnum? = null,
  var cashCollateralCurrency: String? = null,
  var cashCollateralInterestRate: FieldWithMetaString? = null,
  var agreedDiscountRate: FieldWithMetaString? = null,
  var protectedParty: MutableList<PartyDeterminationEnum>? = null,
  var prescribedDocumentationAdjustment: Boolean? = null
)

/**
 * Specifies the nature of a cash price either as a fee type, cash price type, or premium expression.
 *
 * @param cashPriceType Specifies the type of Cash Price.
 * @param premiumExpression Specifies a premium when expressed in a way other than an amount, and any required forward starting price definition.
 * @param feeType Specifies the event type associated with a fee.
 */
@Serializable
open class CashPrice (
  var cashPriceType: CashPriceTypeEnum? = null,
  var premiumExpression: PremiumExpression? = null,
  var feeType: FeeTypeEnum? = null
)

/**
 * Defines the terms required to compute and settle a cash settlement amount according to a fixing value, including the fixing source, fixing method and fixing date. In FpML, PhysicalSettlementTerms and CashSettlementTerms extend SettlementTerms. In the CDM, this extension paradigm has not been used because SettlementTerms class has been used for purposes related to securities transactions, while it is not used as such in the FpML standard (i.e. only as an abstract construct.
 *
 * @param cashSettlementMethod Specifies the type of cash settlement method: cash price, yield curve etc.
 * @param valuationMethod Specifies the parameters required to obtain a valuation, including the source, quotation method (bid, mid etc.) and any applicable quotation amount.
 * @param valuationDate Defines the different methods to specify a valuation date, as used for cash settlement. The Single / Multiple ValuationDate is used for the determination of recovery in a credit event, the RelativeDateOffset is used for cash-settled option, and FxFixingDate is used for cross-currency settlement.
 * @param valuationTime The time of the cash settlement valuation date when the cash settlement amount will be determined according to the cash settlement method, if the parties have not otherwise been able to agree the cash settlement amount. When using quations, this is the time of day in the specified business center when the calculation agent seeks quotations for an amount of the reference obligation for purposes of cash settlement. ISDA 2003 Term: Valuation Time.
 * @param cashSettlementAmount The amount paid by the seller to the buyer for cash settlement on the cash settlement date. If not otherwise specified, would typically be calculated as 100 (or the Reference Price) minus the price of the Reference Obligation (all expressed as a percentage) times Floating Rate Payer Calculation Amount. ISDA 2003 Term: Cash Settlement Amount.
 * @param recoveryFactor Used for fixed recovery, specifies the recovery level, determined at contract formation, to be applied on a default. Used to calculate the amount paid by the seller to the buyer for cash settlement on the cash settlement date. Amount calculation is (1 minus the Recovery Factor) multiplied by the Floating Rate Payer Calculation Amount. The currency will be derived from the Floating Rate Payer Calculation Amount.
 * @param fixedSettlement Used for Recovery Lock, to indicate whether fixed Settlement is Applicable or Not Applicable. If Buyer fails to deliver an effective Notice of Physical Settlement on or before the Buyer NOPS Cut-off Date, and if Seller fails to deliver an effective Seller NOPS on or before the Seller NOPS Cut-off Date, then either: (a) if Fixed Settlement is specified in the related Confirmation as not applicable, then the Seller NOPS Cut-off Date shall be the Termination Date; or (b) if Fixed Settlement is specified in the related Confirmation as applicable, then: (i) if the Fixed Settlement Amount is a positive number, Seller shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the Fixed Settlement Amount to Buyer on the Fixed Settlement Payment Date; and (ii) if the Fixed Settlement Amount is a negative number, Buyer shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the absolute value of the Fixed Settlement Amount to Seller on the Fixed Settlement Payment Date.
 * @param accruedInterest Indicates whether accrued interest is included (true) or not (false). For cash settlement this specifies whether quotations should be obtained inclusive or not of accrued interest. For physical settlement this specifies whether the buyer should deliver the obligation with an outstanding principal balance that includes or excludes accrued interest. ISDA 2003 Term: Include/Exclude Accrued Interest.
 * @param meta 
 */
@Serializable
open class CashSettlementTerms (
  var cashSettlementMethod: CashSettlementMethodEnum? = null,
  var valuationMethod: ValuationMethod? = null,
  var valuationDate: ValuationDate? = null,
  var valuationTime: BusinessCenterTime? = null,
  var cashSettlementAmount: Money? = null,
  var recoveryFactor: Float? = null,
  var fixedSettlement: Boolean? = null,
  var accruedInterest: Boolean? = null,
  var meta: MetaFields? = null
)

/**
 * Class to specify a cashflow, i.e. the outcome of either of computation (e.g. interest accrual) or an assessment of some sort (e.g. a fee). The cashflow can then be turned into a cash transfer, artefact to be used as the input to a payment system or the outcome of it. The associated globalKey denotes the ability to associate a hash value to the Cashflow instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 *
 * @param quantity Represents the amount of the asset to be transferred. The cashflow amount is always a positive number, as the cashflow direction is implied by the payer/receiver attribute.
 * @param asset Represents the object that is subject to the transfer, it could be an asset or a reference.
 * @param settlementDate Represents the date on which the transfer to due.
 * @param payerReceiver Specifies who pays / receives the cashflow, though a normalised Party1 / Party2 enumerator.
 * @param cashflowType The qualification of the type of cashflow, e.g. brokerage fee, premium, upfront fee etc. Particularly relevant when it cannot be inferred directly through lineage.
 * @param paymentDiscounting FpML specifies the FpML PaymentDiscounting.model group for representing the discounting elements that can be associated with a payment.
 */
@Serializable
open class Cashflow (
  var payerReceiver: PayerReceiver? = null,
  var cashflowType: CashflowType? = null,
  var paymentDiscounting: PaymentDiscounting? = null
)
: AssetFlowBase()

/**
 * A data defining:  the cashflow representation of a swap trade.
 *
 * @param cashflowsMatchParameters A true/false flag to indicate whether the cashflows match the parametric definition of the stream, i.e. whether the cashflows could be regenerated from the parameters without loss of information.
 * @param paymentCalculationPeriod The adjusted payment date and associated calculation period parameters required to calculate the actual or projected payment amount. A list of payment calculation period elements may be ordered in the document by ascending adjusted payment date. An FpML document containing an unordered list of payment calculation periods is still regarded as a conformant document.
 */
@Serializable
open class CashflowRepresentation (
  var cashflowsMatchParameters: Boolean? = null,
  var paymentCalculationPeriod: MutableList<PaymentCalculationPeriod>? = null
)

/**
 * Characterises the type of cashflow, which can result from either a scheduled or a non-scheduled lifecycle event.
 *
 * @param cashflowType Type of cashflow corresponding to a scheduled event.
 * @param cashPrice Type of cashflow corresponding to a non-scheduled event, where a price must be agreed between the parties.
 * @param priceExpression 
 */
@Serializable
open class CashflowType (
  var cashflowType: ScheduledTransferEnum? = null,
  var cashPrice: CashPrice? = null,
  var priceExpression: PriceExpressionEnum? = null
)

/**
 * Result for the CheckEligibilityByDetails and CheckEligibilityForProduct functions
 *
 * @param isEligible a simple boolean which is set to true if the asset described in the EligibilityQuery input is eligible
 * @param matchingEligibleCriteria if there was a match, this will be the one or more criteria that were supplied in the EligbilityCollateralSpecification which matched with the query input
 * @param eligibilityQuery a copy of the input query that was checked against the eligible collateral specification
 * @param specification a copy of the input EligbilityCollateralSpecification that was checked against the query
 */
@Serializable
open class CheckEligibilityResult (
  var isEligible: Boolean? = null,
  var matchingEligibleCriteria: MutableList<EligibleCollateralCriteria>? = null,
  var eligibilityQuery: EligibilityQuery? = null,
  var specification: EligibleCollateralSpecification? = null
)

/**
 * A type for documenting additional clause that cannot yet be represented with the model and yet needed for a digital representation of the agreement
 *
 * @param identifier The  name or identifier associated to this clause 
 * @param terms Content of this bespoke clause
 * @param subcomponents Additional hierarchichal components of the clause if relevant
 */
@Serializable
open class Clause (
  var identifier: String? = null,
  var terms: String? = null,
  var subcomponents: MutableList<Clause>? = null
)

/**
 * All information required to perform the clear life cycle event; the clearing party (CCP), the two parties facing each other on the alpha contract, and optionally the parties acting as clearing members.
 *
 * @param alphaContract The contract that will be submitted to the clearing house for clearing. The contract should indicate that it should be cleared by assigning a clearing organisation as a party role.
 * @param clearingParty The Central Counter party (CCP) that the contract will be submitted to for clearing.
 * @param party1 First party facing the CCP if it is clearing for its own account.
 * @param party2 Second party facing the CCP if it is clearing for its own account.
 * @param clearerParty1 Optional party facing the CCP, acting as clearing member for party1.
 * @param clearerParty2 Optional party facing the CCP, acting as clearing member for party2.
 * @param isOpenOffer Open Offer
 */
@Serializable
open class ClearingInstruction (
  var alphaContract: TradeState? = null,
  var clearingParty: Party? = null,
  var party1: Party? = null,
  var party2: Party? = null,
  var clearerParty1: Party? = null,
  var clearerParty2: Party? = null,
  var isOpenOffer: Boolean? = null
)

/**
 *  A class to qualify the closed state of an execution or a contract through the combination or a state (e.g. terminated, novated) and a set of dates: activity date, effective date and, when relevant, last payment date.
 *
 * @param state The qualification of what gave way to the contract or execution closure, e.g. allocation, termination, ...
 * @param activityDate The activity date on which the closing state took place, i.e. either the event date of the closing event (e.g. option exercise, contract early termination) or the contractual termination date.
 * @param effectiveDate The date on which the closing event contractually takes effect, when different from the activity date. When an explicit event effective date attribute is associated with the closing event, it will be that date. In the case of a cancellation event, it will be the date on which the cancelled event took place.
 * @param lastPaymentDate The date associated with the last payment in relation to the artefact (e.g. contract) to which this closed state applies. As an example, in the case of an early termination event, it would be the settlement date of the associated fee, if applicable.
 */
@Serializable
open class ClosedState (
  var state: ClosedStateEnum? = null,
  var activityDate: Date? = null,
  var effectiveDate: Date? = null,
  var lastPaymentDate: Date? = null
)

/**
 * A type for defining the obligations of the counterparty subject to credit support requirements.
 *
 * @param independentAmount Independent Amount is an amount that usually less creditworthy counterparties are asked to provide. It can either be a fixed amount or a percentage of the Transaction's value. The Independent Amount can be: (i) transferred before any trading between the parties occurs (as a deposit at a third party's account or with the counterparty) or (ii) callable after trading has occurred (typically because a downgrade has occurred). In situation (i), the Independent Amount is not included in the calculation of Exposure, but in situation (ii), it is included in the calculation of Exposure. Thus, for situation (ii), the Independent Amount may be transferred along with any collateral call. Independent Amount is a defined term in the ISDA Credit Support Annex. ('with respect to a party, the amount specified as such for that party in Paragraph 13; if no amount is specified, zero').
 * @param portfolioIdentifier A list of identifiers pointing to the collateral portfolios which contain the collateral which covers a trade.
 * @param collateralPortfolio The collateral portfolios which contain the collateral which covers a trade. (NB: this can be provided by reference to a global key for each CollateralPortfolio object)
 * @param collateralProvisions specifies the collateral provisions of the product.
 * @param meta 
 */
@Serializable
open class Collateral (
  var independentAmount: IndependentAmount? = null,
  var portfolioIdentifier: MutableList<Identifier>? = null,
  var collateralPortfolio: MutableList<ReferenceWithMetaCollateralPortfolio>? = null,
  var collateralProvisions: CollateralProvisions? = null,
  var meta: MetaFields? = null
)

/**
 * Represents the parameters needed to calculate the floating rate paid on collateral holdings.
 *
 * @param rateOption 
 * @param spreadSchedule The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
 * @param capRateSchedule The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
 * @param floorRateSchedule The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
 * @param meta 
 * @param negativeInterest Specifies how negative rates should be applied.  If rates go negative, should the payment be reversed (true) or zeroed out (false)?
 * @param compressibleSpread Specifies how spreads should be applied in a low/negative rate environment.  If true, spread is applied only if rate is positive.
 */
@Serializable
open class CollateralAgreementFloatingRate (
  var negativeInterest: Boolean? = null,
  var compressibleSpread: Boolean? = null
)
: FloatingRateBase()

/**
 * Represents common attributes to define a collateral balance recorded by the principal as held or posted.
 *
 * @param collateralBalanceStatus Defines the collateral balance breakdown of settlement status.
 * @param haircutIndicator Indicates if the collateral balance amount is based on pre or post haircut, if a haircut is associated with the collateral asset
 * @param amountBaseCurrency Specifies the collateral balance amount in base currency determined within a collateral legal agreement, or defined for reporting purposes.
 * @param payerReceiver Specifies each of the parties in the collateral balance and its perspective with regards to the direction of the collateral balance, posted or received.
 */
@Serializable
open class CollateralBalance (
  var collateralBalanceStatus: CollateralStatusEnum? = null,
  var haircutIndicator: HaircutIndicatorEnum? = null,
  var amountBaseCurrency: Money? = null,
  var payerReceiver: PartyReferencePayerReceiver? = null
)

/**
 * The possible different terms that can be combined, using AND, OR and NOT logic, to define the issuers and/or assets that meet a given criteria for collateral.
 *
 * @param AllCriteria Enables two or more Collateral Criteria to be combined using AND logic.
 * @param AnyCriteria Enables two or more Collateral Criteria to be combined using OR logic.
 * @param NegativeCriteria Enables a single Collateral Criteria to be excluded using NOT logic.
 * @param CollateralIssuerType Criteria is the type of entity issuing the asset.
 * @param AssetType Criteria is the asset type of the collateral.
 * @param IssuerCountryOfOrigin Criteria is the issuing entity country of origin.
 * @param AssetCountryOfOrigin Criteria is the collateral asset country of origin.
 * @param CurrencyCodeEnum Criteria is the denominated currency of the collateral.
 * @param IssuerName Criteria is a specific named issuer entity.
 * @param IssuerAgencyRating Criteria is the agency rating(s) of the issuer.
 * @param SovereignAgencyRating Criteria is the agency rating(s) of the country of the issuer.
 * @param AssetAgencyRating Criteria is the agency rating(s) of the collateral asset.
 * @param AssetMaturity Criteria is the maturity characteristics of the collateral asset.
 * @param SpecificAsset Criteria is a specifically identified asset
 * @param CollateralTaxonomy Criteria is the taxonomy characteristics of an collateral.
 * @param ListingExchange Criteria is that the collateral is listed on a specific exchange.
 * @param ListingSector Criteria is the industry sector of the collateral asset.
 * @param Index Criteria is that the collateral is a constituent of a specific index.
 * @param CounterpartyOwnIssuePermitted Criteria includes collateral issued by the counterparty.
 * @param DomesticCurrencyIssued Criteria is that collateral must be denominated in the domestic currency of the issuer.
 */
@Serializable
open class CollateralCriteria (
  var allCriteria: AllCriteria? = null,
  var anyCriteria: AnyCriteria? = null,
  var negativeCriteria: NegativeCriteria? = null,
  var collateralIssuerType: CollateralIssuerType? = null,
  var assetType: AssetType? = null,
  var issuerCountryOfOrigin: IssuerCountryOfOrigin? = null,
  var assetCountryOfOrigin: AssetCountryOfOrigin? = null,
  var currencyCodeEnum: CurrencyCodeEnum? = null,
  var issuerName: IssuerName? = null,
  var issuerAgencyRating: IssuerAgencyRating? = null,
  var sovereignAgencyRating: SovereignAgencyRating? = null,
  var assetAgencyRating: AssetAgencyRating? = null,
  var assetMaturity: AssetMaturity? = null,
  var specificAsset: SpecificAsset? = null,
  var collateralTaxonomy: CollateralTaxonomy? = null,
  var listingExchange: ListingExchange? = null,
  var listingSector: ListingSector? = null,
  var index: Index? = null,
  var counterpartyOwnIssuePermitted: CounterpartyOwnIssuePermitted? = null,
  var domesticCurrencyIssued: DomesticCurrencyIssued? = null
)

/**
 * Represents a set of criteria used to specify and describe collateral.
 *
 * @param collateralCriteria The specific criteria that applies. It can be created using AND, OR and NOT logic, and both asset and issuer characteristics.
 * @param appliesTo Specifies which of the two counterparties the criteria applies to (either one or both counterparties). This attribute is optional, in case the applicable party is already specified elsewhere within a party election.
 * @param restrictTo Restrict the criteria to only apply to a specific type of margin, ie IM or VM.
 * @param ratingPriorityResolution Denotes which Criteria has priority if more than one agency rating applies.
 */
@Serializable
open class CollateralCriteriaBase (
  var collateralCriteria: CollateralCriteria? = null,
  var appliesTo: MutableList<CounterpartyRoleEnum>? = null,
  var restrictTo: CollateralMarginTypeEnum? = null,
  var ratingPriorityResolution: RatingPriorityResolutionEnum? = null
)

/**
 * Represents parameters for calculating the amount the floating interest calculation, e.g.  for a single currency or defaults for all currencies.
 *
 * @param fixedRate Specifies the applicable fixed rate  if used.
 * @param floatingRate Specifies the floating interest rate to be used.
 * @param inBaseCurrency If True, specifies that the interest transfers should be converted to base currency equivalent, or if False specifies that the transfer should be in the currency of the collateral.
 * @param compoundingType Specifies the type of compounding to be applied (None, Business, Calendar).
 * @param compoundingBusinessCenter Specifies the applicable business centers for compounding.
 * @param dayCountFraction Specifies the day count fraction to use for that currency.
 * @param rounding Specifies the rounding rules for settling in that currency.
 * @param roundingFrequency Specifies when/how often is rounding applied?
 * @param withholdingTaxRate Specifies the withholding tax rate if a withholding tax is applicable.
 */
@Serializable
open class CollateralInterestCalculationParameters (
  var fixedRate: Float? = null,
  var floatingRate: CollateralAgreementFloatingRate? = null,
  var inBaseCurrency: Boolean? = null,
  var compoundingType: CompoundingTypeEnum? = null,
  var compoundingBusinessCenter: MutableList<BusinessCenterEnum>? = null,
  var dayCountFraction: DayCountFractionEnum? = null,
  var rounding: Rounding? = null,
  var roundingFrequency: RoundingFrequencyEnum? = null,
  var withholdingTaxRate: Float? = null
)

/**
 * Represents parameters that describe how calculated interest amounts are handled, i.e. are they transferred/distributed, or is the collateral balance adjusted, is netting done, and any other special handling.
 *
 * @param interestPaymentHandling Specifies how the collateral interest is to be handled.
 * @param paymentBusinessCenter Specifies applicable business centers for payments.
 * @param netPostedAndHeldInterest Indicates whether to net Held and Posted Interest Payments (i.e. whether interest payable for a period can be netted with interest receivable).
 * @param netInterestWithMarginCalls Indicates whether the interest amount may be offset against any margin call deliver or return amounts?   (aka 'net payments' indicator).
 * @param includeAccrualInMarginCalc Indicates whether or not to include the open interest accrual in the margin calculation.
 * @param accrueInterestOnUnsettledInterest Indicates whether interest accruing on unsettled interest amount is included (continues to be accrued) in the following period.
 * @param onFullReturn Indicates the option that accrued interest should be calculated and distributed when a full return of collateral occurs.
 * @param onPartialReturn Indicates the option that accrued interest should be calculated and distributed when a partial return collateral occurs.
 * @param interestAmountApplication The application of Interest Amount with respect to the Delivery Amount and the Return Amount.
 * @param interestRolloverLimit Specifies the level below which the interest will be rolled over.
 * @param writeoffLimit Specifies the level below which the interest will be written off; if omitted write-off is not applicable.
 * @param alternativeToInterestAmount Specifies the alternative to interest amounts.
 * @param alternativeProvision Specifies an alternative to interest amount, when the alternative provision clause is specified.
 * @param cutoffTime Specifies the time of day that interest needs to be confirmed by.
 * @param notification Specifies the terms describing notification requirements.
 */
@Serializable
open class CollateralInterestHandlingParameters (
  var interestPaymentHandling: CollateralInterestHandlingEnum? = null,
  var paymentBusinessCenter: MutableList<BusinessCenterEnum>? = null,
  var netPostedAndHeldInterest: Boolean? = null,
  var netInterestWithMarginCalls: Boolean? = null,
  var includeAccrualInMarginCalc: Boolean? = null,
  var accrueInterestOnUnsettledInterest: Boolean? = null,
  var onFullReturn: Boolean? = null,
  var onPartialReturn: Boolean? = null,
  var interestAmountApplication: InterestAmountApplication? = null,
  var interestRolloverLimit: NumberBound? = null,
  var writeoffLimit: NumberBound? = null,
  var alternativeToInterestAmount: AlternativeToInterestAmountEnum? = null,
  var alternativeProvision: String? = null,
  var cutoffTime: String? = null,
  var notification: CollateralInterestNotification? = null
)

/**
 * Represents the parameters describing when notifications should be made for required collateral interest transfers.
 *
 * @param trigger Specifies what triggers notification (should be enum) Interest Statement Frequency, Period End Date.
 * @param offset Specifies the number of days before (negative) or after (positive) the trigger event.
 * @param notificationTime Specifies the time of day that the notification should occur.
 * @param notificationDayType The type of days on which notification should occur.
 */
@Serializable
open class CollateralInterestNotification (
  var trigger: String? = null,
  var offset: Float? = null,
  var notificationTime: String? = null,
  var notificationDayType: DayTypeEnum? = null
)

/**
 * Represents the floating interest calculation and distribution parameters for a single currency.
 *
 * @param postingParty Represents the party to which these parameters apply (the applicable party).  In other words, if the parameters are different depending on which party is posting/holding the collateral, for which party to the Collateral Agreement (Party 1 or Party 2) that is posting the collateral do these parameters apply?
 * @param marginType Specifies the type of margin for which interest is being calculated, if the parameters are different depending on type of margin (initial or variation).
 * @param currency Specifies the currency for which the parameters are captured.
 * @param interestCalculationParameters Represents the basic interest calculation parameters.
 * @param interestCalculationFrequency Represents how often and when interest is calculated.
 * @param interestHandlingParameters Represents the parameters describing how and when interest transfer occurs.
 */
@Serializable
open class CollateralInterestParameters (
  var postingParty: CounterpartyRoleEnum? = null,
  var marginType: CollateralMarginTypeEnum? = null,
  var currency: String? = null,
  var interestCalculationParameters: CollateralInterestCalculationParameters? = null,
  var interestCalculationFrequency: CalculationFrequency? = null,
  var interestHandlingParameters: CollateralInterestHandlingParameters? = null
)

/**
 * Represents a class to allow specification of the type of entity issuing the collateral.
 *
 * @param issuerType Specifies the origin of entity issuing the collateral.
 * @param supraNationalType Specifies debt issued by international organisations and multilateral banks.
 * @param quasiGovernmentType Specifies debt issues by institutions or bodies, typically constituted by statute, with a function mandated by the government and subject to government supervision inclusive of profit- and non-profit making bodies. Includes the US Agencies and GSEs and the EU concept of public sector entities. Excluding any entities which are also Regional Government.
 * @param regionalGovernmentType Specifies Regional government, local authority or municipal.
 * @param specialPurposeVehicleType Specifies a subsidiary company that is formed to undertake a specific business purpose of acquisition and financing of specific assets on a potentially limited recourse basis dependent of how it is designed. E.g. asset backed securities, including securitisations.
 */
@Serializable
open class CollateralIssuerType (
  var issuerType: IssuerTypeEnum? = null,
  var supraNationalType: SupraNationalIssuerTypeEnum? = null,
  var quasiGovernmentType: QuasiGovernmentIssuerType? = null,
  var regionalGovernmentType: RegionalGovernmentIssuerType? = null,
  var specialPurposeVehicleType: SpecialPurposeVehicleIssuerType? = null
)

/**
 * Represents common attributes to define the details of collateral assets, to be used in margin call messaging and contribute to collateral balances e.g securities in a collateral account.
 *
 * @param portfolioIdentifier Specifies a unique identifier for a set of collateral positions in a portfolio.
 * @param collateralPosition Specifies the individual components of the collateral positions in the collateral portfolio.
 * @param collateralBalance Represents the populated or calculated collateral aggregate balance amount for the collateral portfolio.
 * @param legalAgreement  The specification of a legal agreement between two parties governing the collateral relationship such as Credit Support Agreement or Collateral Transfer Agreement etc. (NB: this can be provided by reference to a global key for each LegalAgreement object).
 * @param meta 
 */
@Serializable
open class CollateralPortfolio (
  var portfolioIdentifier: Identifier? = null,
  var collateralPosition: MutableList<CollateralPosition>? = null,
  var collateralBalance: MutableList<CollateralBalance>? = null,
  var legalAgreement: ReferenceWithMetaLegalAgreement? = null,
  var meta: MetaFields? = null
)

/**
 * Specifies the individual components of collateral positions.
 *
 * @param priceQuantity Position with many price quantities.
 * @param product The product underlying the position.
 * @param cashBalance The aggregate cost of proceeds
 * @param tradeReference Reference to the Contract, in case product is contractual and the contract has been formed
 * @param treatment Specifies if there is any treatment to be applied to collateral, such as percentage discount which will impact collateral value.
 * @param collateralPositionStatus Indicates the collateral positions settlement status.
 */
@Serializable
open class CollateralPosition (
  var treatment: CollateralTreatment? = null,
  var collateralPositionStatus: CollateralStatusEnum? = null
)
: Position()

/**
 * Contains collateral attributes which can also inherit information from a GMRA
 *
 * @param collateralType Enumerates the collateral types which are accepted by the Seller.
 * @param eligibleCollateral The eligible collateral as specified in relation to the transaction.
 * @param substitutionProvisions The provisions for collateral substitutions such as how many and when they are allowed.
 */
@Serializable
open class CollateralProvisions (
  var collateralType: CollateralTypeEnum? = null,
  var eligibleCollateral: MutableList<EligibleCollateralCriteria>? = null,
  var substitutionProvisions: SubstitutionProvisions? = null
)

/**
 * Specifies the collateral taxonomy, which is composed of a taxonomy value and a taxonomy source.
 *
 * @param taxonomyValue Specifies the taxonomy value.
 * @param taxonomySource Specifies the taxonomy source.
 */
@Serializable
open class CollateralTaxonomy (
  var taxonomyValue: CollateralTaxonomyValue? = null,
  var taxonomySource: TaxonomySourceEnum? = null
)

/**
 * Specifies the collateral taxonomy value, either as a specified enumeration or as a string.
 *
 * @param eu_EMIR_EligibleCollateral Identifies European Union Eligible Collateral Assets classification categories based on EMIR Uncleared Margin Rules. Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM
 * @param uk_EMIR_EligibleCollateral Identifies United Kingdom Eligible Collateral Assets classification categories based on UK Onshored EMIR Uncleared Margin Rules Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: UK EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.
 * @param us_CFTC_PR_EligibleCollateral Identifies US Eligible Collateral Assets classification categories based on Uncleared Margin Rules published by the CFTC and the US Prudential Regulator. Note: While the same basic categories exist in the CFTC and US Prudential Regulators’ margin rules, the precise definitions or application of those rules could differ between the two rules.
 * @param nonEnumeratedTaxonomyValue Identifies the taxonomy value when not specified as an enumeration.
 */
@Serializable
open class CollateralTaxonomyValue (
  var eu_EMIR_EligibleCollateral: MutableList<EU_EMIR_EligibleCollateralEnum>? = null,
  var uk_EMIR_EligibleCollateral: MutableList<UK_EMIR_EligibleCollateralEnum>? = null,
  var us_CFTC_PR_EligibleCollateral: MutableList<US_CFTC_PR_EligibleCollateralEnum>? = null,
  var nonEnumeratedTaxonomyValue: MutableList<FieldWithMetaString>? = null
)

/**
 * The set of elections which specify a Collateral Transfer Agreement
 *
 */
@Serializable
open class CollateralTransferAgreementElections (
)

/**
 * Specifies the treatment terms for the eligible collateral criteria specified.
 *
 * @param valuationTreatment Specification of the valuation treatment for the specified collateral.
 * @param concentrationLimit Specification of concentration limits applicable to the collateral criteria.
 * @param isIncluded A boolean attribute to specify whether collateral critieria are inclusion (True) or exclusion (False) criteria.
 */
@Serializable
open class CollateralTreatment (
  var valuationTreatment: CollateralValuationTreatment? = null,
  var concentrationLimit: MutableList<ConcentrationLimit>? = null,
  var isIncluded: Boolean? = null
)

/**
 * Specification of the valuation treatment for the specified collateral.
 *
 * @param haircutPercentage Specifies a haircut percentage to be applied to the value of asset and used as a discount factor to the value of the collateral asset,expressed as a percentage in decimal terms. As an example a 0.5% haircut would be represented as a decimal number 0.005.
 * @param marginPercentage Specifies a percentage value of transaction needing to be posted as collateral expressed as a valuation. As an example a 104% requirement would be represented as a decimal number 1.04.
 * @param fxHaircutPercentage Specifies an FX haircut applied to a specific asset which is agreed between the parties (for example, if pledgor eligible collateral is not denominated in the termination currency or under other specified cases in collateral support documents both for initial margin and variation margin).The percentage value is expressed as the discount haircut to the value of the collateral- as an example an 8% FX haircut would be expressed as 0.08.
 * @param additionalHaircutPercentage Specifies a percentage value of any additional haircut to be applied to a collateral asset,the percentage value is expressed as the discount haircut to the value of the collateral- as an example a 5% haircut would be expressed as 0.05. 
 */
@Serializable
open class CollateralValuationTreatment (
  var haircutPercentage: Float? = null,
  var marginPercentage: Float? = null,
  var fxHaircutPercentage: Float? = null,
  var additionalHaircutPercentage: Float? = null
)

/**
 * Identifies a specific commodity by referencing a product identifier or by a product definition.
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 * @param commodityProductDefinition Specifies the commodity underlier in the event that no ISDA Commodity Reference Benchmark exists.
 * @param priceQuoteType Describes the required quote type of the underlying price that will be observed. Example values include 'Bid, 'Ask', 'Settlement' (for a futures contract) and 'WeightedAverage' (for some published prices and indices).
 * @param deliveryDateReference Specifies the parameters for identifying the relevant contract date when the commodity reference price is a futures contract.
 * @param description Provides additional information about the commodity underlier.
 */
@Serializable
open class Commodity (
  var commodityProductDefinition: CommodityProductDefinition? = null,
  var priceQuoteType: QuotationSideEnum? = null,
  var deliveryDateReference: DeliveryDateParameters? = null,
  var description: String? = null
)
: AssetBase()

/**
 * Payout based on the averaged price of a referenced underlier. (e.g. Commodities). Can represent both average (average of many) & bullet (average of 1) pricing
 *
 * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
 * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
 * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
 * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
 * @param averagingFeature Indicates if the averaging calculation, when applicable, is weighted or unweighted.
 * @param commodityPriceReturnTerms Defines parameters in which the commodity price is assessed.
 * @param pricingDates Specifies specific dates or parametric rules for the dates on which the price will be determined.
 * @param schedule Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
 * @param calculationPeriodDates Defines the calculation period dates schedule.
 * @param paymentDates Defines the payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the valuation dates).
 * @param underlier Identifies the underlying product that is referenced for pricing of the applicable leg in a swap. Referenced in the '2018 ISDA CDM Equity Confirmation for Security Equity Swap' as Security.
 * @param fxFeature Defines quanto or composite FX features that are included in the swap leg.
 * @param delivery Contains the information relative to the delivery of the asset.
 */
@Serializable
open class CommodityPayout (
  var averagingFeature: AveragingCalculation? = null,
  var commodityPriceReturnTerms: CommodityPriceReturnTerms? = null,
  var pricingDates: PricingDates? = null,
  var schedule: CalculationSchedule? = null,
  var calculationPeriodDates: CalculationPeriodDates? = null,
  var paymentDates: PaymentDates? = null,
  var underlier: Underlier? = null,
  var fxFeature: FxFeature? = null,
  var delivery: AssetDeliveryInformation? = null
)
: PayoutBase()

/**
 * Defines parameters in which the commodity price is assessed.
 *
 * @param rounding Defines rounding rules and precision to be used in the rounding of a number.
 * @param spread Defines a spread value for one or more defined dates.
 * @param rollFeature Used in conjunction with an exchange-based pricing source. Identifies a way in which the futures contracts referenced will roll between periods. 
 * @param conversionFactor Defines the conversion applied if the quantity unit on contract is different from unit on referenced underlier.
 */
@Serializable
open class CommodityPriceReturnTerms (
  var rounding: Rounding? = null,
  var spread: SpreadSchedule? = null,
  var rollFeature: RollFeature? = null,
  var conversionFactor: Float? = null
)

/**
 * Specifies the commodity underlier in the event that no ISDA Commodity Reference Price exists.
 *
 * @param referenceFramework Specifies the type of commodity.
 * @param priceSource Specifies a publication that provides the commodity price, including, where applicable the details of where in the publication the price is published.  Applicable when the commodity reference price is not a futures contract
 * @param commodityInfoPublisher Specifies the publication where the commodity prices can be found.
 * @param exchangeId  Identifies the exchange from which the reference price should be sourced, using the scheme at the following url: http://www.fpml.org/coding-scheme/external/exchange-id-MIC-1-0
 */
@Serializable
open class CommodityProductDefinition (
  var referenceFramework: CommodityReferenceFramework? = null,
  var priceSource: PriceSource? = null,
  var commodityInfoPublisher: CommodityInformationPublisherEnum? = null,
  var exchangeId: FieldWithMetaString? = null
)

/**
 * Specifies the type of commodity.
 *
 * @param commodityName Identifies the commodity more specifically. Where possible, this should follow the naming convention used in the 2005 ISDA Commodity Definitions SubAnnex A, including the subCommodity and additional qualifiers, but should be limited to 256 characters or less.
 * @param capacityUnit Provides an enumerated value for a capacity unit, generally used in the context of defining quantities for commodities.
 * @param weatherUnit Provides an enumerated values for a weather unit, generally used in the context of defining quantities for commodities.
 * @param currency Defines the currency in which the commodity is priced.
 */
@Serializable
open class CommodityReferenceFramework (
  var commodityName: String? = null,
  var capacityUnit: CapacityUnitEnum? = null,
  var weatherUnit: WeatherUnitEnum? = null,
  var currency: FieldWithMetaString? = null
)

/**
 * Specifies the conditions to be applied for converting into a reference currency when the actual currency rate is not determined upfront.
 *
 * @param determinationMethod Specifies the method according to which an amount or a date is determined.
 * @param relativeDate A date specified as some offset to another date (the anchor date).
 * @param fxSpotRateSource Specifies the methodology (reference source and, optionally, fixing time) to be used for determining a currency conversion rate.
 * @param fixingTime The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
 */
@Serializable
open class Composite (
  var determinationMethod: DeterminationMethodEnum? = null,
  var relativeDate: RelativeDateOffset? = null,
  var fxSpotRateSource: FxSpotRateSource? = null,
  var fixingTime: BusinessCenterTime? = null
)

/**
 * A class to specify the outcome of a computed amount, for testing purposes.
 *
 * @param callFunction 
 * @param amount 
 * @param currency The currency in which the computed amount is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
 */
@Serializable
open class ComputedAmount (
  var callFunction: String? = null,
  var amount: Float? = null,
  var currency: FieldWithMetaString? = null
)

/**
 * Represents a class to describe concentration limits that may be applicable to eligible collateral criteria.
 *
 * @param concentrationLimitCriteria Specifies a set of criteria to describe the assets that the concentration limits apply to.
 * @param valueLimit Specifies the value of collateral limit represented as a range.
 * @param percentageLimit Specifies the perecentage of collateral limit represented as a decimal number - example 25% is 0.25.
 */
@Serializable
open class ConcentrationLimit (
  var concentrationLimitCriteria: ConcentrationLimitCriteria? = null,
  var valueLimit: MoneyRange? = null,
  var percentageLimit: NumberRange? = null
)

/**
 * Respresents a class to describe a set of criteria to describe specific assets that the concentration limits apply to.
 *
 * @param collateralCriteria The specific criteria that applies. It can be created using AND, OR and NOT logic, and both asset and issuer characteristics.
 * @param appliesTo Specifies which of the two counterparties the criteria applies to (either one or both counterparties). This attribute is optional, in case the applicable party is already specified elsewhere within a party election.
 * @param restrictTo Restrict the criteria to only apply to a specific type of margin, ie IM or VM.
 * @param ratingPriorityResolution Denotes which Criteria has priority if more than one agency rating applies.
 * @param concentrationLimitType Specifies the type of concentration limit to be applied.
 * @param averageTradingVolume Specifies an average trading volume on an exchange in relation to Equity products.
 */
@Serializable
open class ConcentrationLimitCriteria (
  var concentrationLimitType: ConcentrationLimitTypeEnum? = null,
  var averageTradingVolume: AverageTradingVolume? = null
)
: CollateralCriteriaBase()

/**
 * A class describing the weight of each of the underlier constituent within the basket, either in absolute or relative terms.
 *
 * @param openUnits The number of units (index or securities) that constitute the underlier of the swap. In the case of a basket swap, this element is used to reference both the number of basket units, and the number of each asset components of the basket when these are expressed in absolute terms.
 * @param basketPercentage The relative weight of each respective basket constituent, expressed in percentage. A basket percentage of 5% would be represented as 0.05.
 */
@Serializable
open class ConstituentWeight (
  var openUnits: Float? = null,
  var basketPercentage: Float? = null
)

/**
 * A class to specify the parties' election to specify contact information, in relation to elections such as the Addresses for Transfer or the Demand and Notices as specified in the ISDA Credit Support Annex agreement.
 *
 * @param partyElection The parties' contact information election.
 */
@Serializable
open class ContactElection (
  var partyElection: MutableList<PartyContactInformation>? = null
)

/**
 * A class to specify contact information associated with a party: telephone, postal/street address, email and web page.
 *
 * @param telephone The telephone number.
 * @param address The street/postal address.
 * @param email The email address.
 * @param webPage The web page. This attribute is not specified as part of the FpML ContactInformation complex type.
 */
@Serializable
open class ContactInformation (
  var telephone: MutableList<TelephoneNumber>? = null,
  var address: MutableList<Address>? = null,
  var email: MutableList<String>? = null,
  var webPage: MutableList<String>? = null
)

/**
 * Encapsulates data features common to trade and position.
 *
 * @param contractDetails Represents information specific to trades or positions involving contractual products.
 * @param executionDetails Defines specific attributes that relate to trade or position executions.
 * @param collateral Represents the collateral obligations of a party.
 */
@Serializable
open class ContractBase (
  var contractDetails: ReferenceWithMetaContractDetails? = null,
  var executionDetails: ReferenceWithMetaExecutionDetails? = null,
  var collateral: ReferenceWithMetaCollateral? = null
)

/**
 * Defines specific attributes that relate to contractual details of trades.
 *
 * @param documentation Represents the legal document(s) that governs a trade and associated contractual product terms, either as a reference to such documents when specified as part of the CDM, or through identification of some of the key terms of those documents, such as the type of document, the document identifier, the publisher, the document vintage and the agreement date.
 * @param governingLaw Represents the law governing the trade and associated contractual product terms.
 * @param meta 
 */
@Serializable
open class ContractDetails (
  var documentation: MutableList<LegalAgreement>? = null,
  var governingLaw: FieldWithMetaGoverningLawEnum? = null,
  var meta: MetaFields? = null
)

/**
 * Specifies instructions to create a fully formed contract, with optional legal agreements.
 *
 * @param legalAgreement Optional legal agreements associated to the contract being formed, for instance a master agreement.
 */
@Serializable
open class ContractFormationInstruction (
  var legalAgreement: MutableList<LegalAgreement>? = null
)

@Serializable
open class ContractualMatrix (
  var matrixType: FieldWithMetaMatrixTypeEnum? = null,
  var matrixTerm: FieldWithMetaMatrixTermEnum? = null
)

/**
 * A contractual supplement (such as those published by ISDA) and its publication date that will apply to the trade.
 *
 * @param contractualTermsSupplementType Identifies the form of applicable contractual supplement.
 * @param publicationDate Specifies the publication date of the applicable version of the contractual supplement.
 */
@Serializable
open class ContractualTermsSupplement (
  var contractualTermsSupplementType: FieldWithMetaContractualSupplementTypeEnum? = null,
  var publicationDate: Date? = null
)

/**
 * Specifies the relevant data regarding a corporate action.
 *
 * @param corporateActionType The type of corporate action taking place.
 * @param exDate The date on which the corporate action is known to have taken place.
 * @param payDate The date on which resulting from the corporate action are delivered.
 * @param underlier The underlier impacted by the corporate action.
 */
@Serializable
open class CorporateAction (
  var corporateActionType: CorporateActionTypeEnum? = null,
  var exDate: Date? = null,
  var payDate: Date? = null,
  var underlier: Underlier? = null
)

@Serializable
open class CorrelationReturnTerms (
  var correlationStrikePrice: Price? = null,
  var boundedCorrelation: NumberRange? = null,
  var numberOfDataSeries: Int? = null
)
: ReturnTermsBase()

/**
 * Defines a counterparty enumerated value, e.g. Party1 or Party2, with an associated party reference. The product is agnostic to the actual parties to the transaction, with the party references abstracted away from the product definition and replaced by the CounterpartyEnum (e.g. values Party1 or Party2). The CounterpartyEnum can then be positioned in the product (e.g. to specify which counterparty is the payer, receiver etc) and this Counterparty type, which is positioned outside of the product definition, allows the CounterpartyEnum to be associated with an actual party reference.
 *
 * @param role Specifies the CounterpartyEnum, e.g. either Party1 or Party2, that is associated to the partyReference.
 * @param partyReference Specifies the party that is associated to the counterparty.
 */
@Serializable
open class Counterparty (
  var role: CounterpartyRoleEnum? = null,
  var partyReference: ReferenceWithMetaParty? = null
)

@Serializable
open class CounterpartyOwnIssuePermitted (
  var counterpartyOwnIssuePermitted: Boolean? = null
)

/**
 * A Position describes the accumulated effect of a set of securities or financial transactions.
 *
 * @param contractDetails Represents information specific to trades or positions involving contractual products.
 * @param executionDetails Defines specific attributes that relate to trade or position executions.
 * @param collateral Represents the collateral obligations of a party.
 * @param positionIdentifier Represents the identifier(s) that uniquely identify a position for an identity issuer. A position can include multiple identifiers, for example an internal position identifer and a UTI (Unique Trade Identifier).
 * @param openDateTime The date and time when the position was opened.
 * @param tradeReference Reference to all the trades that constitute the position.
 * @param party The parties involved in the position, including the Clearing Organization.
 * @param partyRole Represents the role each specified party takes in the position.
 * @param positionBase Encapsulates the core constituents that characterize a position.
 */
@Serializable
open class CounterpartyPosition (
  var positionIdentifier: MutableList<PositionIdentifier>? = null,
  var openDateTime: Date? = null,
  var tradeReference: MutableList<ReferenceWithMetaTradeState>? = null,
  var party: MutableList<Party>? = null,
  var partyRole: MutableList<PartyRole>? = null,
  var positionBase: TradableProduct? = null
)
: ContractBase()

/**
 * A business event represents a life cycle event of a position. The combination of the state changes results in a qualifiable life cycle event.
 *
 * @param intent The intent attribute is meant to be specified when the event qualification cannot be programmatically inferred from the event features. As a result it is only associated with those primitives that can give way to such ambiguity, the quantityChange being one of those.
 * @param corporateActionIntent The intent of a corporate action on the position.
 * @param eventDate Specifies the date on which the event is taking place. This date is equal to the trade date in the case of a simple execution.  However it can be different from the trade date, for example in the case of a partial termination.
 * @param effectiveDate The date on which the event contractually takes effect, when different from the event date.
 * @param packageInformation Specifies the package information in case the business event represents several trades executed as a package (hence this attribute is optional). The package information is only instantiated once at the business event level to preserve referential integrity, whereas individual trades make reference to it to identify that they are part of a package.
 * @param after Specifies the after position state(s) created.
 */
@Serializable
open class CounterpartyPositionBusinessEvent (
  var intent: PositionEventIntentEnum? = null,
  var corporateActionIntent: CorporateActionTypeEnum? = null,
  var eventDate: Date? = null,
  var effectiveDate: Date? = null,
  var packageInformation: IdentifiedList? = null,
  var after: MutableList<CounterpartyPositionState>? = null
)

/**
 * Defines the fundamental financial information that can be changed by a Primitive Event and by extension any business or life-cycle event. Each PositionState specifies where a Position is in its life-cycle. PositionState is a root type and as such, can be created independently to any other CDM data type, but can also be used as part of the CDM Event Model.
 *
 * @param counterpartyPosition Represents the Position that has been effected by a business or life-cycle event.
 * @param state Represents the State of the Position through its life-cycle.
 * @param observationHistory Represents the observed events related to a particular product or process, such as credit events or corporate actions.
 * @param valuationHistory 
 * @param meta 
 */
@Serializable
open class CounterpartyPositionState (
  var counterpartyPosition: CounterpartyPosition? = null,
  var state: State? = null,
  var observationHistory: MutableList<ObservationEvent>? = null,
  var valuationHistory: MutableList<Valuation>? = null,
  var meta: MetaFields? = null
)

/**
 *  The credit default payout specification provides the details necessary for determining when a credit payout will be triggered as well as the parameters for calculating the payout and the settlement terms. The associated globalKey denotes the ability to associate a hash value to the CreditDefaultPayout instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 *
 * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
 * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
 * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
 * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
 * @param generalTerms The specification of the non-monetary terms for the Credit Derivative Transaction, including the buyer and seller and selected items from the ISDA 2014 Credit Definition article II, such as the reference obligation and related terms.
 * @param protectionTerms Specifies the terms for calculating a payout to protect the buyer of the swap in the case of a qualified credit event. These terms include the applicable credit events, the reference obligation, and in the case of a CDS on mortgage-backed securities, the floatingAmountEvents.
 * @param transactedPrice The qualification of the price at which the contract has been transacted, in terms of market fixed rate, initial points, market price and/or quotation style. In FpML, those attributes are positioned as part of the fee leg.
 */
@Serializable
open class CreditDefaultPayout (
  var generalTerms: GeneralTerms? = null,
  var protectionTerms: MutableList<ProtectionTerms>? = null,
  var transactedPrice: TransactedPrice? = null
)
: PayoutBase()

/**
 * Specifies the relevant data regarding a credit event.
 *
 * @param creditEventType The type of credit event taking place.
 * @param eventDeterminationDate The date in which the credit event is determined by the Credit Derivatives Determinations Comitee.
 * @param auctionDate The date on which the auction is scheduled to occur.
 * @param finalPrice The final price resulting from the auction.
 * @param recoveryPercent The percentage of the original value of the asset affected by the credit event that can be recovered.
 * @param publiclyAvailableInformation A public information source, e.g. a particular newspaper or electronic news service, that may publish relevant information used in the determination of whether or not a credit event has occurred.
 * @param referenceInformation The reference entity, part of a credit basket, impacted by the credit event.
 */
@Serializable
open class CreditEvent (
  var creditEventType: CreditEventTypeEnum? = null,
  var eventDeterminationDate: Date? = null,
  var auctionDate: Date? = null,
  var finalPrice: Price? = null,
  var recoveryPercent: Float? = null,
  var publiclyAvailableInformation: MutableList<Resource>? = null,
  var referenceInformation: ReferenceInformation? = null
)

@Serializable
open class CreditEventNotice (
  var notifyingParty: MutableList<CounterpartyRoleEnum>? = null,
  var businessCenter: BusinessCenterEnum? = null,
  var publiclyAvailableInformation: PubliclyAvailableInformation? = null
)

/**
 * A class to specify the applicable Credit Events that would trigger a settlement, as specified in the related Confirmation and defined in the ISDA 2014 Credit Definition article IV section 4.1.
 *
 * @param bankruptcy A credit event. The reference entity has been dissolved or has become insolvent. It also covers events that may be a precursor to insolvency such as instigation of bankruptcy or insolvency proceedings. Sovereign trades are not subject to Bankruptcy as 'technically' a Sovereign cannot become bankrupt. ISDA 2003 Term: Bankruptcy.
 * @param failureToPay A credit event. This credit event triggers, after the expiration of any applicable grace period, if the reference entity fails to make due payments in an aggregate amount of not less than the payment requirement on one or more obligations (e.g. a missed coupon payment). ISDA 2003 Term: Failure to Pay.
 * @param failureToPayPrincipal A credit event. Corresponds to the failure by the Reference Entity to pay an expected principal amount or the payment of an actual principal amount that is less than the expected principal amount. ISDA 2003 Term: Failure to Pay Principal.
 * @param failureToPayInterest A credit event. Corresponds to the failure by the Reference Entity to pay an expected interest amount or the payment of an actual interest amount that is less than the expected interest amount. ISDA 2003 Term: Failure to Pay Interest.
 * @param obligationDefault A credit event. One or more of the obligations have become capable of being declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay. ISDA 2003 Term: Obligation Default.
 * @param obligationAcceleration A credit event. One or more of the obligations have been declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay (preferred by the market over Obligation Default, because more definitive and encompasses the definition of Obligation Default - this is more favorable to the Seller). Subject to the default requirement amount. ISDA 2003 Term: Obligation Acceleration.
 * @param repudiationMoratorium A credit event. The reference entity, or a governmental authority, either refuses to recognise or challenges the validity of one or more obligations of the reference entity, or imposes a moratorium thereby postponing payments on one or more of the obligations of the reference entity. Subject to the default requirement amount. ISDA 2003 Term: Repudiation/Moratorium.
 * @param restructuring A credit event. A restructuring is an event that materially impacts the reference entity's obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2003 Term: Restructuring.
 * @param governmentalIntervention A credit event. A governmental intervention is an event resulting from an action by a governmental authority that materially impacts the reference entity's obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2014 Term: Governmental Intervention.
 * @param distressedRatingsDowngrade A credit event. Results from the fact that the rating of the reference obligation is down-graded to a distressed rating level. From a usage standpoint, this credit event is typically not applicable in case of RMBS trades.
 * @param maturityExtension A credit event. Results from the fact that the underlier fails to make principal payments as expected.
 * @param writedown A credit event. Results from the fact that the underlier writes down its outstanding principal amount.
 * @param impliedWritedown A credit event. Results from the fact that losses occur to the underlying instruments that do not result in reductions of the outstanding principal of the reference obligation.
 * @param defaultRequirement In relation to certain credit events, serves as a threshold for Obligation Acceleration, Obligation Default, Repudiation/Moratorium and Restructuring. Market standard is USD 10,000,000 (JPY 1,000,000,000 for all Japanese Yen trades). This is applied on an aggregate or total basis across all Obligations of the Reference Entity. Used to prevent technical/operational errors from triggering credit events. ISDA 2003 Term: Default Requirement.
 * @param creditEventNotice A specified condition to settlement. An irrevocable written or verbal notice that describes a credit event that has occurred. The notice is sent from the notifying party (either the buyer or the seller) to the counterparty. It provides information relevant to determining that a credit event has occurred. This is typically accompanied by Publicly Available Information. ISDA 2003 Term: Credit Event Notice.
 * @param meta 
 */
@Serializable
open class CreditEvents (
  var bankruptcy: Boolean? = null,
  var failureToPay: FailureToPay? = null,
  var failureToPayPrincipal: Boolean? = null,
  var failureToPayInterest: Boolean? = null,
  var obligationDefault: Boolean? = null,
  var obligationAcceleration: Boolean? = null,
  var repudiationMoratorium: Boolean? = null,
  var restructuring: Restructuring? = null,
  var governmentalIntervention: Boolean? = null,
  var distressedRatingsDowngrade: Boolean? = null,
  var maturityExtension: Boolean? = null,
  var writedown: Boolean? = null,
  var impliedWritedown: Boolean? = null,
  var defaultRequirement: Money? = null,
  var creditEventNotice: CreditEventNotice? = null,
  var meta: MetaFields? = null
)

/**
 * Specification of an index based on credit risk, typically composed using corporate debt instruments in a region or industry sector, e.g. the iTraxx indices.
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 * @param name A description of the Index.
 * @param provider The organisation that creates or maintains the Index.
 * @param assetClass The Asset Class of the Index.
 * @param indexSeries A CDS index series identifier, e.g. 1, 2, 3 etc.
 * @param indexAnnexVersion A CDS index series version identifier, e.g. 1, 2, 3 etc.
 * @param indexAnnexDate A CDS index series annex date.
 * @param indexAnnexSource A CDS index series annex source.
 * @param excludedReferenceEntity Excluded reference entity.
 * @param tranche This element contains CDS tranche terms.
 * @param settledEntityMatrix Used to specify the Relevant Settled Entity Matrix when there are settled entities at the time of the trade.
 * @param indexFactor Index Factor is the index version factor or percent, expressed as an absolute decimal value between 0 and 1, that multiplied by the original notional amount yields the notional amount covered by the seller of protection.
 * @param seniority Seniority of debt instruments comprising the index.
 * @param meta 
 */
@Serializable
open class CreditIndex (
  var indexSeries: Int? = null,
  var indexAnnexVersion: Int? = null,
  var indexAnnexDate: Date? = null,
  var indexAnnexSource: FieldWithMetaIndexAnnexSourceEnum? = null,
  var excludedReferenceEntity: MutableList<ReferenceInformation>? = null,
  var tranche: Tranche? = null,
  var settledEntityMatrix: SettledEntityMatrix? = null,
  var indexFactor: Float? = null,
  var seniority: CreditSeniorityEnum? = null,
  var meta: MetaFields? = null
)
: IndexBase()

/**
 * A class to represent the credit limit utilisation information.
 *
 * @param limitApplicable 
 */
@Serializable
open class CreditLimitInformation (
  var limitApplicable: MutableList<LimitApplicableExtended>? = null
)

/**
 * Credit limit utilisation breakdown by executed trades and pending orders.
 *
 * @param executed Credit limit utilisation attributable to executed trades.
 * @param pending Credit limit utilisation attributable to pending unexecuted orders.
 */
@Serializable
open class CreditLimitUtilisation (
  var executed: CreditLimitUtilisationPosition? = null,
  var pending: CreditLimitUtilisationPosition? = null
)

@Serializable
open class CreditLimitUtilisationPosition (
  var shortPosition: Float? = null,
  var longPosition: Float? = null,
  var global: Float? = null
)

/**
 * Represents a class to specify the credit notation as the combination of agency, notation, scale and debt type qualifications.
 *
 * @param agency Specifies The credit agency to which the other variables (notation, scale, debt type) refer to.
 * @param notation Specifies The credit rating notation. As it varies among credit rating agencies, FpML doesn't specify a default scheme.
 * @param scale Specifies the credit rating scale, with a typical distinction between short term, long term. FpML doesn't specify a default scheme, which is hence not specified as an enumeration as part of the CDM.
 * @param debt Specifies the credit rating debt type (e.g. long term, high yield, deposits, ...) associated with the credit rating notation and scale.
 * @param outlook Assesses the potential direction of a long-term credit rating over the intermediate term, which is generally up to two years for investment grade and generally up to one year for speculative grade.
 * @param creditWatch Indicates the potential direction of a short-term or long-term rating. It focuses on identifiable events and short-term trends that cause ratings to be placed under special surveillance.
 */
@Serializable
open class CreditNotation (
  var agency: CreditRatingAgencyEnum? = null,
  var notation: FieldWithMetaString? = null,
  var scale: FieldWithMetaString? = null,
  var debt: CreditRatingDebt? = null,
  var outlook: CreditRatingOutlookEnum? = null,
  var creditWatch: CreditRatingCreditWatchEnum? = null
)

/**
 * Represents the credit rating notation higher level construct, which provides the ability to specify multiple rating notations.
 *
 * @param creditNotation Specifies only one credit notation is determined.
 * @param creditNotations Specifies if several credit notations exist, alongside an 'any' or 'all' or all condition.
 */
@Serializable
open class CreditNotations (
  var creditNotation: CreditNotation? = null,
  var creditNotations: MultipleCreditNotations? = null
)

/**
 * Specifies the credit rating debt type(s) associated with the credit rating notation and scale. When several debt types are specified, they must be qualified through an 'any' or 'all'.
 *
 * @param debtType Specifies when there is only one debt type. FpML doesn't specify values in relation to the associated scheme, which is hence not specified as an enumeration as part of the CDM.
 * @param debtTypes Specifies if there are several debt types, alongside an 'any' or 'all' or all condition. As an example, Baa1 rating is required for any long term debt and deposit.
 */
@Serializable
open class CreditRatingDebt (
  var debtType: FieldWithMetaString? = null,
  var debtTypes: MultipleDebtTypes? = null
)

/**
 * The set of elections which specify a Credit Support Annex or Deed.
 *
 */
@Serializable
open class CreditSupportAgreementElections (
)

@Serializable
open class Curve (
  var interestRateCurve: InterestRateCurve? = null,
  var commodityCurve: FieldWithMetaCommodityReferencePriceEnum? = null
)

/**
 * A class to specify an offset either as a normalized [multiplier, period, dayType] or as a custom provision of type string.
 *
 * @param offset 
 * @param customProvision 
 */
@Serializable
open class CustomisableOffset (
  var offset: Offset? = null,
  var customProvision: String? = null
)

/**
 * In its initial iteration, this class is meant to support the DTCC TIW workflow information.
 *
 * @param itemName In this initial iteration, this corresponds to the DTCC TIW element name.
 * @param itemValue In this initial iteration, this corresponds to the DTCC value.
 */
@Serializable
open class CustomisedWorkflow (
  var itemName: String? = null,
  var itemValue: String? = null
)

/**
 * List of dates.
 *
 * @param date 
 */
@Serializable
open class DateList (
  var date: MutableList<Date>? = null
)

/**
 * A class defining a contiguous series of calendar dates. The date range is defined as all the dates between and including the start and the end date. The start date must fall on or before the end date.
 *
 * @param startDate The first date of a date range.
 * @param endDate The last date of a date range.
 */
@Serializable
open class DateRange (
  var startDate: Date? = null,
  var endDate: Date? = null
)

/**
 * A data to:  provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
 *
 * @param calculationPeriodDatesReference A set of href pointers to calculation period dates defined somewhere else in the document.
 */
@Serializable
open class DateRelativeToCalculationPeriodDates (
  var calculationPeriodDatesReference: MutableList<ReferenceWithMetaCalculationPeriodDates>? = null
)

/**
 * A data to:  provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
 *
 * @param paymentDatesReference A set of href pointers to payment dates defined somewhere else in the document.
 */
@Serializable
open class DateRelativeToPaymentDates (
  var paymentDatesReference: MutableList<ReferenceWithMetaPaymentDates>? = null
)

/**
 * A data to:  provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
 *
 * @param valuationDatesReference A set of href pointers to valuation period dates defined somewhere else in the document.
 */
@Serializable
open class DateRelativeToValuationDates (
  var valuationDatesReference: MutableList<ReferenceWithMetaPerformanceValuationDates>? = null
)

/**
 * List of dateTimes.
 *
 * @param dateTime The CDM specifies that the zoned date time is to be expressed in accordance with ISO 8601, either as UTC as an offset to UTC.
 */
@Serializable
open class DateTimeList (
  var dateTime: MutableList<Date>? = null
)

/**
 * Defines a date and value pair. This definition is used for varying rate or amount schedules, e.g. a notional amortisation or a step-up coupon schedule.
 *
 * @param date The date on which the associated step value becomes effective. This day may be subject to adjustment in accordance with a business day convention.
 * @param value The rate of amount which becomes effective on the associated step date. A rate of 5% would be represented as 0.05.
 * @param meta 
 */
@Serializable
open class DatedValue (
  var date: Date? = null,
  var value: Float? = null,
  var meta: MetaFields? = null
)

/**
 * Specifies selected economics of a debt instrument.
 *
 * @param debtSeniority Specifies the order of repayment in the event of a sale or bankruptcy of the issuer or a related party (eg guarantor).
 * @param debtInterest Specifies the general rule for periodic interest rate payment.
 * @param debtPrincipal Specifies the general rule for repayment of principal.
 */
@Serializable
open class DebtEconomics (
  var debtSeniority: DebtSeniorityEnum? = null,
  var debtInterest: DebtInterestEnum? = null,
  var debtPrincipal: DebtPrincipalEnum? = null
)

/**
 * Specifies the type of debt instrument.
 *
 * @param debtClass Specifies the characteristics of a debt instrument.
 * @param debtEconomics Specifies selected financial terms of a debt instrument.
 */
@Serializable
open class DebtType (
  var debtClass: DebtClassEnum? = null,
  var debtEconomics: MutableList<DebtEconomics>? = null
)

/**
 * A class to specify all the ISDA terms relevant to defining the deliverable obligations.
 *
 * @param accruedInterest Indicates whether accrued interest is included (true) or not (false). For cash settlement this specifies whether quotations should be obtained inclusive or not of accrued interest. For physical settlement this specifies whether the buyer should deliver the obligation with an outstanding principal balance that includes or excludes accrued interest. ISDA 2003 Term: Include/Exclude Accrued Interest.
 * @param category Used in both obligations and deliverable obligations to represent a class or type of securities which apply. ISDA 2003 Term: Obligation Category/Deliverable Obligation Category.
 * @param notSubordinated An obligation and deliverable obligation characteristic. An obligation that ranks at least equal with the most senior Reference Obligation in priority of payment or, if no Reference Obligation is specified in the related Confirmation, the obligations of the Reference Entity that are senior. ISDA 2003 Term: Not Subordinated.
 * @param specifiedCurrency An obligation and deliverable obligation characteristic. The currency or currencies in which an obligation or deliverable obligation must be payable. ISDA 2003 Term: Specified Currency.
 * @param notSovereignLender An obligation and deliverable obligation characteristic. Any obligation that is not primarily (majority) owed to a Sovereign or Supranational Organisation. ISDA 2003 Term: Not Sovereign Lender.
 * @param notDomesticCurrency An obligation and deliverable obligation characteristic. Any obligation that is payable in any currency other than the domestic currency. Domestic currency is either the currency so specified or, if no currency is specified, the currency of (a) the reference entity, if the reference entity is a sovereign, or (b) the jurisdiction in which the relevant reference entity is organised, if the reference entity is not a sovereign. ISDA 2003 Term: Not Domestic Currency.
 * @param notDomesticLaw An obligation and deliverable obligation characteristic. If the reference entity is a Sovereign, this means any obligation that is not subject to the laws of the reference entity. If the reference entity is not a sovereign, this means any obligation that is not subject to the laws of the jurisdiction of the reference entity. ISDA 2003 Term: Not Domestic Law.
 * @param listed An obligation and deliverable obligation characteristic. Indicates whether or not the obligation is quoted, listed or ordinarily purchased and sold on an exchange. ISDA 2003 Term: Listed.
 * @param notContingent A deliverable obligation characteristic. In essence Not Contingent means the repayment of principal cannot be dependant on a formula/index, i.e. to prevent the risk of being delivered an instrument that may never pay any element of principal, and to ensure that the obligation is interest bearing (on a regular schedule). ISDA 2003 Term: Not Contingent.
 * @param notDomesticIssuance An obligation and deliverable obligation characteristic. Any obligation other than an obligation that was intended to be offered for sale primarily in the domestic market of the relevant Reference Entity. This specifies that the obligation must be an internationally recognised bond. ISDA 2003 Term: Not Domestic Issuance.
 * @param assignableLoan A deliverable obligation characteristic. A loan that is freely assignable to a bank or financial institution without the consent of the Reference Entity or the guarantor, if any, of the loan (or the consent of the applicable borrower if a Reference Entity is guaranteeing the loan) or any agent. ISDA 2003 Term: Assignable Loan.
 * @param consentRequiredLoan A deliverable obligation characteristic. A loan that is capable of being assigned with the consent of the Reference Entity or the guarantor, if any, of the loan or any agent. ISDA 2003 Term: Consent Required Loan.
 * @param directLoanParticipation A deliverable obligation characteristic. A loan with a participation agreement whereby the buyer is capable of creating, or procuring the creation of, a contractual right in favour of the seller that provides the seller with recourse to the participation seller for a specified share in any payments due under the relevant loan which are received by the participation seller. ISDA 2003 Term: Direct Loan Participation.
 * @param transferable A deliverable obligation characteristic. An obligation that is transferable to institutional investors without any contractual, statutory or regulatory restrictions. ISDA 2003 Term: Transferable.
 * @param maximumMaturity A deliverable obligation characteristic. An obligation that has a remaining maturity from the Physical Settlement Date of not greater than the period specified. ISDA 2003 Term: Maximum Maturity.
 * @param acceleratedOrMatured A deliverable obligation characteristic. An obligation at time of default is due to mature and due to be repaid, or as a result of downgrade/bankruptcy is due to be repaid as a result of an acceleration clause. ISDA 2003 Term: Accelerated or Matured.
 * @param notBearer A deliverable obligation characteristic. Any obligation that is not a bearer instrument. This applies to Bonds only and is meant to avoid tax, fraud and security/delivery provisions that can potentially be associated with Bearer Bonds. ISDA 2003 Term: Not Bearer.
 * @param fullFaithAndCreditObLiability An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: Full Faith and Credit Obligation Liability.
 * @param generalFundObligationLiability An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: General Fund Obligation Liability.
 * @param revenueObligationLiability An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: Revenue Obligation Liability.
 * @param indirectLoanParticipation ISDA 1999 Term: Indirect Loan Participation. NOTE: Only applicable as a deliverable obligation under ISDA Credit 1999.
 * @param excluded A free format string to specify any excluded obligations or deliverable obligations, as the case may be, of the reference entity or excluded types of obligations or deliverable obligations. ISDA 2003 Term: Excluded Obligations/Excluded Deliverable Obligations.
 * @param othReferenceEntityObligations This element is used to specify any other obligations of a reference entity in both obligations and deliverable obligations. The obligations can be specified free-form. ISDA 2003 Term: Other Obligations of a Reference Entity.
 */
@Serializable
open class DeliverableObligations (
  var accruedInterest: Boolean? = null,
  var category: ObligationCategoryEnum? = null,
  var notSubordinated: Boolean? = null,
  var specifiedCurrency: SpecifiedCurrency? = null,
  var notSovereignLender: Boolean? = null,
  var notDomesticCurrency: NotDomesticCurrency? = null,
  var notDomesticLaw: Boolean? = null,
  var listed: Boolean? = null,
  var notContingent: Boolean? = null,
  var notDomesticIssuance: Boolean? = null,
  var assignableLoan: PCDeliverableObligationCharac? = null,
  var consentRequiredLoan: PCDeliverableObligationCharac? = null,
  var directLoanParticipation: LoanParticipation? = null,
  var transferable: Boolean? = null,
  var maximumMaturity: Period? = null,
  var acceleratedOrMatured: Boolean? = null,
  var notBearer: Boolean? = null,
  var fullFaithAndCreditObLiability: Boolean? = null,
  var generalFundObligationLiability: Boolean? = null,
  var revenueObligationLiability: Boolean? = null,
  var indirectLoanParticipation: LoanParticipation? = null,
  var excluded: String? = null,
  var othReferenceEntityObligations: String? = null
)

/**
 * A class to specify the application of Interest Amount with respect the Delivery Amount.
 *
 * @param standardElection The standard election as specified by an enumeration.
 * @param customElection The custom election that might be specified by the parties to the agreement.
 */
@Serializable
open class DeliveryAmount (
  var standardElection: DeliveryAmountElectionEnum? = null,
  var customElection: String? = null
)

/**
 * Specifies a specific date or the parameters for identifying the relevant contract date when the commodity reference price is a futures contract.
 *
 * @param deliveryNearby Provides a container for the parametric representation that specifies which nearby contract date would be used as a refrence for a price.
 * @param deliveryDate Specifies the specific contract date for the contract that should be referenced for a price.
 * @param deliveryDateRollConvention Specifies, for a Commodity Transaction that references a listed future, the day on which the specified future will roll to the next nearby month prior to the expiration of the referenced future. If the future will not roll at all - i.e. the price will be taken from the expiring contract, 0 days should be specified here. If the future will roll to the next nearby on the last trading day - i.e. the price will be taken from the next nearby on the last trading day, then 1 business day should be specified and so on.
 * @param deliveryDateExpirationConvention Specifies, for a Commodity Transaction that references a listed future, the day on which the specified future will expire ahead of the actual expiration of the referenced future. For example: Z21 Contract expires on 19Nov21, with an adjust of 2D the 'expire' will be 16Nov21. DeliveryDateRollConvention takes precedence. Example: Pricing on the Z21 Contract with NearbyContractDay and a deliveryDateRoll of 10D, Sampling of the F22 Contract will occur on 8Nov21 through the last Date of the Z21 Contract. With an ExpConvention of 5D, the last sampling date on the F22 contract will be 12Nov21.
 */
@Serializable
open class DeliveryDateParameters (
  var deliveryNearby: Offset? = null,
  var deliveryDate: AdjustableDate? = null,
  var deliveryDateRollConvention: Offset? = null,
  var deliveryDateExpirationConvention: Offset? = null
)

@Serializable
open class DerivInstrmAttrbts (
  var xpryDt: String? = null,
  var pricMltplr: String? = null,
  var undrlygInstrm: UndrlygInstrm? = null,
  var dlvryTp: String? = null
)

/**
 * Specifies the method according to which an amount or a date is determined.
 *
 * @param determinationMethod Represents a more granular dimention of observation. Typically relevent for resolving a unique equity price, which can be expressed as trade-weighted or volume-weighted averages.
 * @param averagingMethod Specifies enumerations for the type of averaging calculation.
 */
@Serializable
open class DeterminationMethodology (
  var determinationMethod: DeterminationMethodEnum? = null,
  var averagingMethod: AveragingCalculationMethodEnum? = null
)

/**
 * Defines the roles and related terms which document the agreement of parties about any determination requirements ; mostly about Extraordinary Events, without being necessarily restricted to such scope, as further specified in the particular product at stake e.g. for instance when Calculation Agent is mentioned as the Price Determination Method enumarated value, etc.
 *
 */
@Serializable
open class DeterminationRolesAndTerms (
)

/**
 * An Asset that exists only in digital form, eg Bitcoin or Ethereum, that is not backed by other Assets; excludes the digital representation of other Assets, eg coins or Tokenised assets.
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 */
@Serializable
open class DigitalAsset (
)
: AssetBase()

/**
 * A data defining:  discounting information. The 2000 ISDA definitions, section 8.4. discounting (related to the calculation of a discounted fixed amount or floating amount) apply. This type must only be included if discounting applies.
 *
 * @param discountingType The discounting method that is applicable.
 * @param discountRate A discount rate, expressed as a decimal, to be used in the calculation of a discounted amount. A discount amount of 5% would be represented as 0.05.
 * @param discountRateDayCountFraction A discount day count fraction to be used in the calculation of a discounted amount.
 */
@Serializable
open class DiscountingMethod (
  var discountingType: DiscountingTypeEnum? = null,
  var discountRate: Float? = null,
  var discountRateDayCountFraction: FieldWithMetaDayCountFractionEnum? = null
)

/**
 * A class to specify the Distributions and Interest Payment provisions applicable to the collateral agreement.
 *
 * @param interestParameters Represents the interest parameters for the various currencies, margin types, posting parties.
 */
@Serializable
open class DistributionAndInterestPayment (
  var interestParameters: MutableList<CollateralInterestParameters>? = null
)

/**
 * The parameters which define whether dividends are applicable
 *
 * @param optionsExchangeDividends If present and true, then options exchange dividends are applicable.
 * @param additionalDividends If present and true, then additional dividends are applicable.
 * @param allDividends Represents the European Master Confirmation value of 'All Dividends' which, when applicable, signifies that, for a given Ex-Date, the daily observed Share Price for that day is adjusted (reduced) by the cash dividend and/or the cash value of any non cash dividend per Share (including Extraordinary Dividends) declared by the Issuer. All Dividends in accordance with the ISDA 2002 Equity Derivatives Definitions.
 */
@Serializable
open class DividendApplicability (
  var optionsExchangeDividends: Boolean? = null,
  var additionalDividends: Boolean? = null,
  var allDividends: Boolean? = null
)

/**
 * A class to specify the currency in which the dividends will be denominated, i.e. either in the dividend currency or in a currency specified as part of the contract.
 *
 * @param currency The currency in which the dividend is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
 * @param determinationMethod Specifies the method according to which the dividend is determined, e.g. the dividend currency.
 * @param currencyReference Reference to a currency specified elsewhere in the document
 */
@Serializable
open class DividendCurrency (
  var currency: FieldWithMetaString? = null,
  var determinationMethod: DeterminationMethodEnum? = null,
  var currencyReference: BasicReferenceWithMetaString? = null
)

/**
 * A class to specify the dividend date by reference to another date, with the ability to apply and offset. This class doesn't exist in FpML and is meant to simplify the choice constraint associated with the DividendPaymentDate class.
 *
 * @param dateReference Specification of the dividend date using an enumeration, with values such as the pay date, the ex-date or the record date.
 * @param paymentDateOffset Only to be used when SharePayment has been specified in the dividendDateReference element. The number of Currency Business Days following the day on which the Issuer of the Shares pays the relevant dividend to holders of record of the Shares.
 */
@Serializable
open class DividendDateReference (
  var dateReference: DividendDateReferenceEnum? = null,
  var paymentDateOffset: Offset? = null
)

/**
 * A class describing the date on which the dividend will be paid/received. This class is also used to specify the date on which the FX rate will be determined, when applicable.
 *
 * @param dividendDateReference 
 * @param dividendDate 
 */
@Serializable
open class DividendPaymentDate (
  var dividendDateReference: DividendDateReference? = null,
  var dividendDate: ReferenceWithMetaAdjustableOrRelativeDate? = null
)

/**
 * A class describing the dividend payout ratio associated with an equity underlier. In certain cases the actual ratio is not known on trade inception, and only general conditions are then specified.
 *
 * @param totalRatio Specifies the total actual dividend payout ratio associated with the equity underlier. A ratio of 90% should be expressed at 0.90.
 * @param cashRatio Specifies the cash actual dividend payout ratio associated with the equity underlier. A ratio of 90% should be expressed at 0.90.
 * @param nonCashRatio Specifies the non cash actual dividend payout ratio associated with the equity underlier. A ratio of 90% should be expressed at 0.90.
 * @param basketConstituent In the case of a basket underlier, specifies to which component of the basket this particular set of dividend payout ratios correspond.
 */
@Serializable
open class DividendPayoutRatio (
  var totalRatio: Float? = null,
  var cashRatio: Float? = null,
  var nonCashRatio: Float? = null,
  var basketConstituent: ReferenceWithMetaBasketConstituent? = null
)

/**
 * Time bounded dividend payment periods, each with a dividend payment date per period.
 *
 * @param startDate Dividend period start date.
 * @param endDate Dividend period end date.
 * @param dateAdjustments Date adjustments for all unadjusted dates in this dividend period.
 * @param basketConstituent For basket underliers, reference to the basket component which is paying dividends in the specified period.
 * @param dividendPaymentDate Specifies when the dividend will be paid to the receiver of the equity return. Has the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. Is not applicable in the case of a dividend reinvestment election.
 * @param dividendValuationDate Specifies the dividend valuation dates of the swap.
 */
@Serializable
open class DividendPeriod (
  var startDate: DividendPaymentDate? = null,
  var endDate: DividendPaymentDate? = null,
  var dateAdjustments: BusinessDayAdjustments? = null,
  var basketConstituent: ReferenceWithMetaBasketConstituent? = null,
  var dividendPaymentDate: DividendPaymentDate? = null,
  var dividendValuationDate: AdjustableOrRelativeDate? = null
)

/**
 * A class describing the conditions governing the payment of dividends to the receiver of the equity return, with the exception of the dividend payout ratio, which is defined for each of the underlying components.
 *
 * @param dividendPayoutRatio Specifies the dividend payout ratio associated with each underlier. In FpML 5.10 the payout is positioned at the underlier level, although there is an intent to reconsider this approach and position it at the leg level. This is approach adopted by the CDM.
 * @param dividendReinvestment Boolean element that defines whether the dividend will be reinvested or not.
 * @param dividendEntitlement Defines the date on which the receiver of the equity return is entitled to the dividend.
 * @param dividendAmountType Specifies whether the dividend is paid with respect to the Dividend Period.
 * @param performance Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.
 * @param firstOrSecondPeriod 2002 ISDA Equity Derivatives Definitions: Dividend Period as either the First Period or the Second Period. | 
 * @param extraordinaryDividendsParty Specifies the party which determines if dividends are extraordinary in relation to normal levels.
 * @param excessDividendAmount Determination of Gross Cash Dividend per Share.
 * @param dividendCurrency Specifies the currency in which the dividend will be denominated, e.g. the dividend currency, or a specified currency. This class is not specified as such in FpML, which makes use of the CurrencyAndDeterminationMethod.model to specify such terms.
 * @param nonCashDividendTreatment Specifies the treatment of Non-Cash Dividends.
 * @param dividendComposition Specifies how the composition of Dividends is to be determined.
 * @param specialDividends Specifies the method according to which special dividends are determined.
 * @param materialDividend If present and true, then material non cash dividends are applicable.
 * @param dividendPeriod One to many time bounded dividend payment periods, each with a dividend payment date per period.
 */
@Serializable
open class DividendReturnTerms (
  var dividendPayoutRatio: MutableList<DividendPayoutRatio>? = null,
  var dividendReinvestment: Boolean? = null,
  var dividendEntitlement: DividendEntitlementEnum? = null,
  var dividendAmountType: DividendAmountTypeEnum? = null,
  var performance: String? = null,
  var firstOrSecondPeriod: DividendPeriodEnum? = null,
  var extraordinaryDividendsParty: AncillaryRoleEnum? = null,
  var excessDividendAmount: DividendAmountTypeEnum? = null,
  var dividendCurrency: DividendCurrency? = null,
  var nonCashDividendTreatment: NonCashDividendTreatmentEnum? = null,
  var dividendComposition: DividendCompositionEnum? = null,
  var specialDividends: Boolean? = null,
  var materialDividend: Boolean? = null,
  var dividendPeriod: MutableList<DividendPeriod>? = null
)

/**
 * Information related to dividends and payments.
 *
 * @param manufacturedIncomeRequirement Specifies the proportion of the value of the dividend on the borrowed shares that the borrower is legally obligated to return to the lender.
 * @param dividendEntitlement Defines the date on which the receiver of the equity return is entitled to the dividend.
 * @param minimumBillingAmount daily fee increments accrue until a threshold is crossed, at which point payment becomes due)
 */
@Serializable
open class DividendTerms (
  var manufacturedIncomeRequirement: DividendPayoutRatio? = null,
  var dividendEntitlement: DividendEntitlementEnum? = null,
  var minimumBillingAmount: Money? = null
)

@Serializable
open class Document (
  var finInstrmRptgTxRpt: FinInstrmRptgTxRpt? = null
)

@Serializable
open class DomesticCurrencyIssued (
  var domesticCurrencyIssued: Boolean? = null
)

/**
 * A data to:  define the adjusted dates associated with an early termination provision.
 *
 * @param adjustedExerciseDate The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
 * @param adjustedEarlyTerminationDate The early termination date that is applicable if an early termination provision is exercised. This date should already be adjusted for any applicable business day convention.
 * @param adjustedCashSettlementValuationDate The date by which the cash settlement amount must be agreed. This date should already be adjusted for any applicable business day convention.
 * @param adjustedCashSettlementPaymentDate The date on which the cash settlement amount is paid. This date should already be adjusted for any applicable business date convention.
 * @param adjustedExerciseFeePaymentDate The date on which the exercise fee amount is paid. This date should already be adjusted for any applicable business day convention.
 * @param meta 
 */
@Serializable
open class EarlyTerminationEvent (
  var adjustedExerciseDate: Date? = null,
  var adjustedEarlyTerminationDate: Date? = null,
  var adjustedCashSettlementValuationDate: Date? = null,
  var adjustedCashSettlementPaymentDate: Date? = null,
  var adjustedExerciseFeePaymentDate: Date? = null,
  var meta: MetaFields? = null
)

/**
 * A data defining:  an early termination provision for a swap. This early termination is at fair value, i.e. on termination the fair value of the product must be settled between the parties.
 *
 * @param mandatoryEarlyTermination A mandatory early termination provision to terminate the swap at fair value.
 * @param mandatoryEarlyTerminationDateTenor Period after trade date of the mandatory early termination date.
 * @param optionalEarlyTermination An option for either or both parties to terminate the swap at fair value.
 * @param optionalEarlyTerminationParameters Definition of the first early termination date and the frequency of the termination dates subsequent to that. American exercise is defined by having a frequency of one day.
 * @param meta 
 */
@Serializable
open class EarlyTerminationProvision (
  var mandatoryEarlyTermination: MandatoryEarlyTermination? = null,
  var mandatoryEarlyTerminationDateTenor: Period? = null,
  var optionalEarlyTermination: OptionalEarlyTermination? = null,
  var optionalEarlyTerminationParameters: ExercisePeriod? = null,
  var meta: MetaFields? = null
)

/**
 *  This class represents the full set of price-forming features associated with a contractual product: the payout component, the notional/quantity, the effective and termination date and the date adjustment provisions when applying uniformily across the payout components. This class also includes the legal provisions which have valuation implications: cancelable provision, extendible provision, early termination provision and extraordinary events specification.
 *
 * @param effectiveDate The first day of the terms of the trade. This day may be subject to adjustment in accordance with a business day convention.
 * @param terminationDate The last day of the terms of the trade. This date may be subject to adjustments in accordance with the business day convention. It can also be specified in relation to another scheduled date (e.g. the last payment date).
 * @param dateAdjustments The business day adjustment convention when it applies across all the payout components. This specification of the business day convention and financial business centers is used for adjusting any calculation period date if it would otherwise fall on a day that is not a business day in the specified business center.
 * @param payout The payout specifies the future cashflow computation methodology which characterizes a financial product.
 * @param terminationProvision Contains optional provisions pertaining to the termination characteristics of a contract.
 * @param calculationAgent The ISDA calculation agent responsible for performing duties as defined in the applicable product definitions.
 * @param nonStandardisedTerms Specifies, when boolean value is True, that additional economic terms exist that have not been included in the product representation.
 * @param collateral Represents the collateral obligations of a party.
 */
@Serializable
open class EconomicTerms (
  var effectiveDate: AdjustableOrRelativeDate? = null,
  var terminationDate: AdjustableOrRelativeDate? = null,
  var dateAdjustments: BusinessDayAdjustments? = null,
  var payout: MutableList<Payout>? = null,
  var terminationProvision: TerminationProvision? = null,
  var calculationAgent: CalculationAgent? = null,
  var nonStandardisedTerms: Boolean? = null,
  var collateral: Collateral? = null
)

/**
 * Query to check against an EligibleCollateralSpecification
 *
 * @param maturity Maturity in years
 * @param collateralAssetType The asset product type.
 * @param assetCountryOfOrigin The asset country of origin.
 * @param denominatedCurrency The underlying asset denominated currency.
 * @param agencyRating The agency rating based on default risk and creditors claim in event of default associated with specific instrument.
 * @param issuerType Represents a filter based on the type of entity issuing the asset.
 * @param issuerName Specifies the issuing entity name or LEI.
 */
@Serializable
open class EligibilityQuery (
  var maturity: Float? = null,
  var collateralAssetType: AssetType? = null,
  var assetCountryOfOrigin: ISOCountryCodeEnum? = null,
  var denominatedCurrency: CurrencyCodeEnum? = null,
  var agencyRating: AgencyRatingCriteria? = null,
  var issuerType: CollateralIssuerType? = null,
  var issuerName: LegalEntity? = null
)

/**
 * Represents a set of criteria used to specify eligible collateral.
 *
 * @param collateralCriteria The specific criteria that applies. It can be created using AND, OR and NOT logic, and both asset and issuer characteristics.
 * @param appliesTo Specifies which of the two counterparties the criteria applies to (either one or both counterparties). This attribute is optional, in case the applicable party is already specified elsewhere within a party election.
 * @param restrictTo Restrict the criteria to only apply to a specific type of margin, ie IM or VM.
 * @param ratingPriorityResolution Denotes which Criteria has priority if more than one agency rating applies.
 * @param treatment Identifies the treatment of specified collateral, e.g., haircuts,holding limits or exclusions.
 */
@Serializable
open class EligibleCollateralCriteria (
  var treatment: CollateralTreatment? = null
)
: CollateralCriteriaBase()

/**
 * Represents a set of criteria used to specify eligible collateral.
 *
 * @param identifier Specifies the identifier(s) to uniquely identify eligible collateral or a set of eligible collateral, such as a schedule or equivalant for an identity issuer.
 * @param party The parties associated with the specification.
 * @param counterparty Specification of the roles of the counterparties to the specification.
 * @param criteria Represents a set of criteria used to specify eligible collateral.
 * @param partyRole Specifies the role(s) that each of the party(s) is playing in the context of the specification, eg Payor or Receiver.
 * @param meta 
 */
@Serializable
open class EligibleCollateralSpecification (
  var identifier: MutableList<Identifier>? = null,
  var party: MutableList<Party>? = null,
  var counterparty: MutableList<Counterparty>? = null,
  var criteria: MutableList<EligibleCollateralCriteria>? = null,
  var partyRole: MutableList<PartyRole>? = null,
  var meta: MetaFields? = null
)

@Serializable
open class EligibleCollateralSpecificationInstruction (
  var common: EligibleCollateralCriteria? = null,
  var variable: MutableList<EligibleCollateralCriteria>? = null
)

/**
 * Transaction AdditionalTerms that apply to Equity asset class.
 *
 * @param extraordinaryEvents 
 * @param determinationTerms 
 * @param substitutionProvision 
 */
@Serializable
open class EquityAdditionalTerms (
  var extraordinaryEvents: ExtraordinaryEvents? = null,
  var determinationTerms: MutableList<DeterminationRolesAndTerms>? = null,
  var substitutionProvision: UnderlierSubstitutionProvision? = null
)

/**
 * A class for defining the merger events and their treatment.
 *
 */
@Serializable
open class EquityCorporateEvents (
)

/**
 * Specification of an index based on equity securities, e.g. the S&P 500..
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 * @param name A description of the Index.
 * @param provider The organisation that creates or maintains the Index.
 * @param assetClass The Asset Class of the Index.
 */
@Serializable
open class EquityIndex (
)
: IndexBase()

/**
 * Specification for General Terms and Elections of an Equity Master Confirmation that is applicable across multiple Equity confirmations and is referenced by each of these confirmations, an example of which being the 2018 ISDA CDM Equity Confirmation for Security Equity Swap.
 *
 */
@Serializable
open class EquityMasterConfirmation (
)
: MasterConfirmationBase()

/**
 * Specification for the General Terms and Relationship Supplement Elections as provided in the 2018 ISDA CDM Equity Confirmation for Security Equity Swap.
 *
 * @param typeOfSwapElection Per Part 1 Section 4, 'Dividend Obligations', of the 2018 ISDA CDM Equity Confirmation, Para 4.2 'Dividend Returns'
 * @param pricingMethodElection Per Part 1 Section 5, 'Pricing', of the 2018 ISDA CDM Equity Confirmation, Para 5.1
 * @param linearInterpolationElection Per Part 1 Section 3, 'Floating Obligations', of the 2018 ISDA CDM Equity Confirmation. Para 3.3
 * @param settlementTerms Per Part 1 Section 8, 'Settlement', of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap
 * @param valuationDates The parameters used to generate the 'Equity Valuation Dates' schedule, including the Effective Date and Termination Date for the Swap.
 * @param equityCashSettlementDates The parameters used to generate the payment date schedule, relative to the equityCalculationPeriod. Per Part 1 Section 12, 'Definitions', of the 2018 ISDA CDM Equity Confirmation. Para 73
 */
@Serializable
open class EquitySwapMasterConfirmation2018 (
  var typeOfSwapElection: ReturnTypeEnum? = null,
  var pricingMethodElection: PriceReturnTerms? = null,
  var linearInterpolationElection: InterpolationMethodEnum? = null,
  var settlementTerms: SettlementTerms? = null,
  var valuationDates: ValuationDates? = null,
  var equityCashSettlementDates: PaymentDates? = null
)
: EquityMasterConfirmation()

@Serializable
open class EquityUnderlierProvisions (
  var multipleExchangeIndexAnnexFallback: Boolean? = null,
  var componentSecurityIndexAnnexFallback: Boolean? = null,
  var localJurisdiction: FieldWithMetaString? = null,
  var relevantJurisdiction: FieldWithMetaString? = null
)

/**
 * Specifies instructions to create a BusinessEvent.
 *
 * @param intent The intent attribute is meant to be specified when the event qualification cannot be programmatically inferred from the event features. As a result it is only associated with those primitives that can give way to such ambiguity, the quantityChange being one of those. An example of such is a reduction in the trade notional, which could be interpreted as either a trade correction (unless a maximum period of time post-event is specified as part of the qualification), a partial termination or a portfolio rebalancing in the case of an equity swap. On the other hand, an event such as the exercise is not expected to have an associated intent as there should not be ambiguity.
 * @param corporateActionIntent 
 * @param eventDate Specifies the date on which the event is taking place. This date is equal to the trade date in the case of a simple execution.  However it can be different from the trade date, for example in the case of a partial termination.
 * @param effectiveDate The date on which the event contractually takes effect, when different from the event date.
 * @param packageInformation Specifies the package information in case the business event represents several trades executed as a package (hence this attribute is optional). The package information is only instantiated once at the business event level to preserve referential integrity, whereas individual trades make reference to it to identify that they are part of a package.
 * @param instruction Specifies the instructions to create the Business Event.
 */
@Serializable
open class EventInstruction (
  var intent: EventIntentEnum? = null,
  var corporateActionIntent: CorporateActionTypeEnum? = null,
  var eventDate: Date? = null,
  var effectiveDate: Date? = null,
  var packageInformation: IdentifiedList? = null,
  var instruction: MutableList<Instruction>? = null
)

/**
 * A class to represent the various set of timestamps that can be associated with lifecycle events, as a collection of [dateTime, qualifier].
 *
 * @param dateTime The CDM specifies that the zoned date time is to be expressed in accordance with ISO 8601, either as UTC as an offset to UTC.
 * @param qualification The timestamp qualifier is specified through an enumeration because the experience of integrating the DTCC and CME data representations suggests that a wide set of timestamps are currently utilized among service providers, while there is not at present an objective set of criteria that could help suggest a defined set of timestamps as part of the CDM. At some future point, one possible baseline could be developed from the review of the set of timestamps specified across regulatory regimes and regulations (incl. regulations such as high frequency trading). Also, the integration with a further set of implementations and the specification of business workflows such as clearing as part of the CDM development should help confirm the implementation approach in this respect.
 */
@Serializable
open class EventTimestamp (
  var dateTime: Date? = null,
  var qualification: EventTimestampQualificationEnum? = null
)

/**
 * Specifies a transaction which automatically extends for a specified timeframe until the exercise of an embedded option.
 *
 * @param singlePartyOption If evergreen termination is not available to both parties then this component specifies the buyer and seller of the option.
 * @param noticePeriod The length of each evergreen extension period relative to the effective date of the preceding contract.
 * @param noticeDeadlinePeriod Defines the minimum period before an evergreen is scheduled to terminate that notice can be given that it will terminate beyond the scheduled termination date.
 * @param noticeDeadlineDateTime A specific date and time for the notice deadline
 * @param extensionFrequency The frequency with which the evergreen contract will be extended if notice is not given.
 * @param finalPeriodFeeAdjustment An optional adjustment to the rate for the last period of the evergreen i.e. the period from when notice is given to stop rolling the contract through to the termination date.
 */
@Serializable
open class EvergreenProvision (
  var singlePartyOption: PartyRole? = null,
  var noticePeriod: RelativeDateOffset? = null,
  var noticeDeadlinePeriod: RelativeDateOffset? = null,
  var noticeDeadlineDateTime: Date? = null,
  var extensionFrequency: AdjustableRelativeOrPeriodicDates? = null,
  var finalPeriodFeeAdjustment: Price? = null
)

@Serializable
open class ExctgPrsn (
  var prsn: Prsn? = null
)

/**
 * Defines specific attributes that relate to trade executions.
 *
 * @param executionType Identifies the type of execution, e.g. via voice, electronically...
 * @param executionVenue Represents the venue on which a trade was executed.
 * @param packageReference A reference to the package linking the trade with other trades, in case the trade was executed as part of a package (hence this attribute is optional).
 * @param meta 
 */
@Serializable
open class ExecutionDetails (
  var executionType: ExecutionTypeEnum? = null,
  var executionVenue: LegalEntity? = null,
  var packageReference: IdentifiedList? = null,
  var meta: MetaFields? = null
)

/**
 * Specifies instructions for execution of a transaction, consisting of a product, price, quantity, parties, trade identifier, execution details, and settlement terms.
 *
 * @param product Defines the financial product to be executed and contract formed.
 * @param priceQuantity Defines the prices (e.g. spread, equity price, FX rate), quantities (e.g. currency amount, no. shares) and settlement terms (e.g. initial fee, broker fee, up-front cds payment or option premium settlement) associated with the constituents of the transacted product.
 * @param counterparty Maps two defined parties to counterparty enums for the transacted product.
 * @param ancillaryParty Maps any ancillary parties, e.g. parties involved in the transaction that are not one of the two principal parties.
 * @param parties Defines all parties to that execution, including agents and brokers.
 * @param partyRoles Defines the role(s) that party(ies) may have in relation to the execution.
 * @param executionDetails Specifies the type and venue of execution, e.g. via voice, or electronically.
 * @param tradeDate Denotes the trade/execution date.
 * @param tradeTime Denotes the trade time and timezone as agreed by the parties to the trade.
 * @param tradeIdentifier Denotes one or more identifiers associated with the transaction.
 * @param collateral Detail the collateral requirement anticipated with the transaction.
 * @param lotIdentifier Lot Identifier associated with the transaction.
 */
@Serializable
open class ExecutionInstruction (
  var product: NonTransferableProduct? = null,
  var priceQuantity: MutableList<PriceQuantity>? = null,
  var counterparty: MutableList<Counterparty>? = null,
  var ancillaryParty: MutableList<AncillaryParty>? = null,
  var parties: MutableList<Party>? = null,
  var partyRoles: MutableList<PartyRole>? = null,
  var executionDetails: ExecutionDetails? = null,
  var tradeDate: FieldWithMetaDate? = null,
  var tradeTime: FieldWithMetaTimeZone? = null,
  var tradeIdentifier: MutableList<TradeIdentifier>? = null,
  var collateral: Collateral? = null,
  var lotIdentifier: Identifier? = null
)

/**
 * A data defining:  the adjusted dates associated with a particular exercise event.
 *
 * @param adjustedExerciseDate The date on which the option exercise takes place. This date should already be adjusted for any applicable business day convention.
 * @param adjustedRelevantSwapEffectiveDate The effective date of the underlying swap associated with a given exercise date. This date should already be adjusted for any applicable business day convention.
 * @param adjustedCashSettlementValuationDate The date by which the cash settlement amount must be agreed. This date should already be adjusted for any applicable business day convention.
 * @param adjustedCashSettlementPaymentDate The date on which the cash settlement amount is paid. This date should already be adjusted for any applicable business day convention.
 * @param adjustedExerciseFeePaymentDate The date on which the exercise fee amount is paid. This date should already be adjusted for any applicable business day convention.
 * @param meta 
 */
@Serializable
open class ExerciseEvent (
  var adjustedExerciseDate: Date? = null,
  var adjustedRelevantSwapEffectiveDate: Date? = null,
  var adjustedCashSettlementValuationDate: Date? = null,
  var adjustedCashSettlementPaymentDate: Date? = null,
  var adjustedExerciseFeePaymentDate: Date? = null,
  var meta: MetaFields? = null
)

/**
 * A class defining the fee payable on exercise of an option. This fee may be defined as an amount or a percentage of the notional exercised. As a difference with FpML, it extends the BuyerSeller class.
 *
 * @param payer Specifies the counterparty responsible for making the payments defined by this structure.  The party is one of the two principal parties to the transaction.
 * @param receiver Specifies the party that receives the payments corresponding to this structure.  The party is one of the two counterparties to the transaction.
 * @param notionalReference A pointer style reference to the associated notional schedule defined elsewhere in the document.
 * @param feeAmount The amount of fee to be paid on exercise. The fee currency is that of the referenced notional.
 * @param feeRate A fee represented as a percentage of some referenced notional. A percentage of 5% would be represented as 0.05.
 * @param feePaymentDate The date on which exercise fee(s) will be paid. It is specified as a relative date.
 */
@Serializable
open class ExerciseFee (
  var notionalReference: ReferenceWithMetaMoney? = null,
  var feeAmount: Float? = null,
  var feeRate: Float? = null,
  var feePaymentDate: RelativeDateOffset? = null
)
: PayerReceiver()

/**
 * A class to define a fee or schedule of fees to be payable on the exercise of an option. This fee may be defined as an amount or a percentage of the notional exercised. As a difference with FpML, it extends the BuyerSeller class.
 *
 * @param payer Specifies the counterparty responsible for making the payments defined by this structure.  The party is one of the two principal parties to the transaction.
 * @param receiver Specifies the party that receives the payments corresponding to this structure.  The party is one of the two counterparties to the transaction.
 * @param notionalReference A pointer style reference to the associated notional schedule defined elsewhere in the document.
 * @param feeAmountSchedule The exercise fee amount schedule. The fees are expressed as currency amounts. The currency of the fee is assumed to be that of the notional schedule referenced.
 * @param feeRateSchedule The exercise free rate schedule. The fees are expressed as percentage rates of the notional being exercised. The currency of the fee is assumed to be that of the notional schedule referenced.
 * @param feePaymentDate The date on which exercise fee(s) will be paid. It is specified as a relative date.
 */
@Serializable
open class ExerciseFeeSchedule (
  var notionalReference: ReferenceWithMetaMoney? = null,
  var feeAmountSchedule: AmountSchedule? = null,
  var feeRateSchedule: Schedule? = null,
  var feePaymentDate: RelativeDateOffset? = null
)
: PayerReceiver()

/**
 * Specifies the information required to communicate the choices made by the exercising party, in a financial product endowing the party with at least one option.
 *
 * @param exerciseQuantity Contains instructions for exercising the option including a quantity change, and optionally a transfer.
 * @param exerciseOption Specifies the Option Payout being exercised on the trade.
 * @param exerciseDate Specifies the date on which an option contained within the financial product would be exercised. The date may be omitted if the contractual product allows for only a single date of exercise (European exercise).
 * @param exerciseTime Specifies the time at which an option contained within the financial product woulld be exercised. The time may be omitted if the contractual product allows for only a single time of exercise (European exercise). 
 * @param replacementTradeIdentifier Specifies the trade identifier to apply to the replacement trade for physical exercise.
 */
@Serializable
open class ExerciseInstruction (
  var exerciseQuantity: PrimitiveInstruction? = null,
  var exerciseOption: ReferenceWithMetaOptionPayout? = null,
  var exerciseDate: AdjustableOrAdjustedDate? = null,
  var exerciseTime: BusinessCenterTime? = null,
  var replacementTradeIdentifier: MutableList<TradeIdentifier>? = null
)

/**
 * Defines to whom and where notice of execution should be given. The exerciseNoticeGiver refers to one or both of the principal parties of the trade. If present the exerciseNoticeReceiver refers to a party, other than the principal party, to whom notice should be given.
 *
 * @param exerciseNoticeGiver Specifies the principal party of the trade that has the right to exercise.
 * @param exerciseNoticeReceiver Specifies the party to which notice of exercise should be given, e.g. by the buyer of the option. Although in many cases it is the buyer of the option who sends the exercise notice to the seller of the option, this component is reused, e.g. in case of OptionEarlyTermination, either or both parties have the right to exercise.
 * @param businessCenter Specifies the location where the exercise must be reported, e.g. where the exercise notice receiver is based.
 */
@Serializable
open class ExerciseNotice (
  var exerciseNoticeGiver: ExerciseNoticeGiverEnum? = null,
  var exerciseNoticeReceiver: AncillaryRoleEnum? = null,
  var businessCenter: FieldWithMetaBusinessCenterEnum? = null
)

/**
 * This defines the time interval to the start of the exercise period, i.e. the earliest exercise date, and the frequency of subsequent exercise dates (if any).
 *
 * @param earliestExerciseDateTenor The time interval to the first (and possibly only) exercise date in the exercise period.
 * @param exerciseFrequency The frequency of subsequent exercise dates in the exercise period following the earliest exercise date. An interval of 1 day should be used to indicate an American style exercise period.
 * @param meta 
 */
@Serializable
open class ExercisePeriod (
  var earliestExerciseDateTenor: Period? = null,
  var exerciseFrequency: Period? = null,
  var meta: MetaFields? = null
)

/**
 * A class describing how notice of exercise should be given. This can be either manual or automatic.
 *
 * @param manualExercise Specifies that the notice of exercise must be given by the buyer to the seller or seller's agent.
 * @param automaticExercise If automatic is specified, then the notional amount of the underlying swap not previously exercised under the swaption will be automatically exercised at the expiration time on the expiration date if at such time the buyer is in-the-money, provided that the difference between the settlement rate and the fixed rate under the relevant underlying swap is not less than the specified threshold rate. The term in-the-money is assumed to have the meaning defining in the 2000 ISDA Definitions, Section 17.4 In-the-money.
 * @param followUpConfirmation A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller's agent.
 * @param limitedRightToConfirm Has the meaning defined as part of the 1997 ISDA Government Bond Option Definitions, section 4.5 Limited Right to Confirm Exercise. If present, (i) the Seller may request the Buyer to confirm its intent if not done on or before the expiration time on the Expiration date (ii) specific rules will apply in relation to the settlement mode.
 * @param splitTicket Typically applicable to the physical settlement of bond and convertible bond options. If present, means that the party required to deliver the bonds will divide those to be delivered as notifying party desires to facilitate delivery obligations.
 */
@Serializable
open class ExerciseProcedure (
  var manualExercise: ManualExercise? = null,
  var automaticExercise: AutomaticExercise? = null,
  var followUpConfirmation: Boolean? = null,
  var limitedRightToConfirm: Boolean? = null,
  var splitTicket: Boolean? = null
)

/**
 * A class defining the exercise period for an option together with any rules governing the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fees.
 *
 * @param style Whether the option has a single exercise (european), multiple exercise dates (bermuda), or a continuous range of exercise (american).
 * @param commencementDate The first day of the exercise period for an American style option.
 * @param exerciseDates The dates that define the Bermuda option exercise dates and the expiration date. The last specified date is assumed to be the expiration date. The dates can either be specified as a series of explicit dates and associated adjustments or as a series of dates defined relative to another schedule of dates, for example, the calculation period start dates. Where a relative series of dates are defined the first and last possible exercise dates can be separately specified.
 * @param expirationDate The last day within an exercise period for an American style option. For a European style option it is the only day within the exercise period.
 * @param relevantUnderlyingDate The effective date on the underlying product if the option is exercised.  For example, for a swaption it is the swap effective date, for an option on an FX spot or forward it is the value date for settlement, and in an extendible/cancelable provision it is the swap termination date, which is the date on which the termination is effective.'
 * @param earliestExerciseTime The earliest time at which notice of exercise can be given by the buyer to the seller (or seller's agent) to, and including, the expiration date.
 * @param latestExerciseTime For a Bermuda or American style option, the latest time on an exercise business day (excluding the expiration date) within the exercise period that notice can be given by the buyer to the seller or seller's agent. Notice of exercise given after this time will be deemed to have been given on the next exercise business day.
 * @param expirationTime The latest time for exercise on expirationDate. It is made mandatory given that for all option styles, this field is required.
 * @param expirationTimeType The time of day at which the equity option expires, for example the official closing time of the exchange.
 * @param multipleExercise As defined in the 2000 ISDA Definitions, Section 12.4. Multiple Exercise, the buyer of the option has the right to exercise all or less than all the unexercised notional amount of the underlying swap on one or more days in the exercise period, but on any such day may not exercise less than the minimum notional amount or more that the maximum notional amount, and if an integral multiple amount is specified, the notional amount exercised must be equal to, or be an integral multiple of, the integral multiple amount.
 * @param exerciseFeeSchedule The fees associated with an exercise date. The fees are conditional on the exercise occurring. The fees can be specified as actual currency amounts or as percentages of the notional amount being exercised.
 * @param exerciseProcedure The set of parameters defining the procedure associated with the exercise, e.g. manual exercise.
 * @param exerciseFee A fee to be paid on exercise. This could be represented as an amount or a rate and notional reference on which to apply the rate.
 * @param partialExercise As defined in the 2000 ISDA Definitions, Section 12.3. Partial Exercise, the buyer of the option has the right to exercise all or less than all the notional amount of the underlying swap on the expiration date, but may not exercise less than the minimum notional amount, and if an integral multiple amount is specified, the notional amount exercised must be equal to, or be an integral multiple of, the integral multiple amount.
 * @param meta 
 */
@Serializable
open class ExerciseTerms (
  var style: OptionExerciseStyleEnum? = null,
  var commencementDate: AdjustableOrRelativeDate? = null,
  var exerciseDates: AdjustableOrRelativeDates? = null,
  var expirationDate: MutableList<AdjustableOrRelativeDate>? = null,
  var relevantUnderlyingDate: AdjustableOrRelativeDates? = null,
  var earliestExerciseTime: BusinessCenterTime? = null,
  var latestExerciseTime: BusinessCenterTime? = null,
  var expirationTime: BusinessCenterTime? = null,
  var expirationTimeType: ExpirationTimeTypeEnum? = null,
  var multipleExercise: MultipleExercise? = null,
  var exerciseFeeSchedule: ExerciseFeeSchedule? = null,
  var exerciseProcedure: ExerciseProcedure? = null,
  var exerciseFee: ExerciseFee? = null,
  var partialExercise: PartialExercise? = null,
  var meta: MetaFields? = null
)

/**
 * Represents the current mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency).
 *
 * @param tradePortfolio Represents a Portfolio that describes all the positions held at a given time, in various states which can be either traded, settled, etc., with lineage information to the previous state.
 * @param aggregateValue Represents the aggregate value of the portfolio in base currency.
 * @param calculationDateTime Indicates the date when the exposure is calculated if different from valuation date.
 * @param valuationDateTime Indicates the valuation date of the exposure underlying the calculation.
 */
@Serializable
open class Exposure (
  var tradePortfolio: ReferenceWithMetaPortfolioState? = null,
  var aggregateValue: Money? = null,
  var calculationDateTime: Date? = null,
  var valuationDateTime: Date? = null
)

/**
 * A data defining:  an option to extend an existing swap transaction on the specified exercise dates for a term ending on the specified new termination date. As a difference from FpML, it extends the BuyerSeller class, which represents the BuyerSeller.model.
 *
 * @param buyer Buyer party that can be resolved as one of the two principal parties to the transaction. The party that buys this instrument, i.e. pays for this instrument and receives the rights defined by it. ISDA 2002 Equity Definitions section 1.18: `Buyer` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (b)(i) relating to a Swaption: 'Buyer' means the party that will, on each Premium Payment Date, pay to Seller the Premium | ISDA 2006 Definitions article 12.1 (b)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such in the related Confirmation, or the Exercising Party if neither party is specified | ISDA 2006 Definitions article 12.1 (b)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Buyer` means the Fixed Rate Payer.
 * @param seller Seller party that can be resolved as one of the two principal parties to the transaction. The party that sells ('writes') this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. ISDA 2002 Equity Definitions section 1.19: `Seller` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (a)(i) relating to a Swaption: 'Seller' means the party the party specified as such or as writer in the related Confirmation | ISDA 2006 Definitions article 12.1 (a)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such or as writer in the related Confirmation or, if neither party is specified as such, the Non-exercising Party | ISDA 2006 Definitions article 12.1 (a)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Seller` means the Floating Rate Payer.
 * @param exerciseNotice Definition of the party to whom notice of exercise should be given.
 * @param followUpConfirmation A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller's agent.
 * @param extendibleProvisionAdjustedDates The adjusted dates associated with an extendible provision. These dates have been adjusted for any applicable business day convention.
 * @param callingParty 
 * @param singlePartyOption If the ability to extend the contract is not available to both parties then this component specifies the buyer and seller of the option.
 * @param noticeDeadlinePeriod Defines the minimum period before a contract is scheduled to terminate that notice can be given that it will terminate beyond the scheduled termination date.
 * @param noticeDeadlineDateTime A specific date and time for the notice deadline
 * @param extensionTerm The length of each extension period relative to the effective date of the preceding contract.
 * @param extensionPeriod The period within which notice can be given that the contract will be extended.
 * @param exerciseTerms The exercise terms associated with the extendible provision, including details such as exercise style, exercise fees, and any other relevant conditions or terms governing the extension of the swap transaction.
 */
@Serializable
open class ExtendibleProvision (
  var exerciseNotice: ExerciseNotice? = null,
  var followUpConfirmation: Boolean? = null,
  var extendibleProvisionAdjustedDates: ExtendibleProvisionAdjustedDates? = null,
  var callingParty: CallingPartyEnum? = null,
  var singlePartyOption: PartyRole? = null,
  var noticeDeadlinePeriod: RelativeDateOffset? = null,
  var noticeDeadlineDateTime: Date? = null,
  var extensionTerm: RelativeDateOffset? = null,
  var extensionPeriod: AdjustableRelativeOrPeriodicDates? = null,
  var exerciseTerms: ExerciseTerms? = null
)
: BuyerSeller()

/**
 * A data defining:  the adjusted dates associated with a provision to extend a swap.
 *
 * @param extensionEvent The adjusted dates associated with a single extendible exercise date.
 */
@Serializable
open class ExtendibleProvisionAdjustedDates (
  var extensionEvent: MutableList<ExtensionEvent>? = null
)

/**
 * A data to:  define the adjusted dates associated with an individual extension event.
 *
 * @param adjustedExerciseDate The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
 * @param adjustedExtendedTerminationDate The termination date if an extendible provision is exercised. This date should already be adjusted for any applicable business day convention.
 * @param meta 
 */
@Serializable
open class ExtensionEvent (
  var adjustedExerciseDate: Date? = null,
  var adjustedExtendedTerminationDate: Date? = null,
  var meta: MetaFields? = null
)

/**
 * Where the underlying is shares, defines market events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
 *
 * @param additionalBespokeTerms Where parties may optionnaly describe any extra bespoke agreements, in regards of the standardized Extraordinary Events.
 * @param mergerEvents Per the 2018 ISDA CDM Equity Confirmation for Security Equity Swap
 * @param tenderOfferEvents Per the 2002 ISDA Equity Derivatives Definitions: 
 * @param compositionOfCombinedConsideration Per the 2002 ISDA Equity Derivatives Definitions: 
 * @param indexAdjustmentEvents Per the 2002 ISDA Equity Derivatives Definitions: Adjustments to Indices 
 * @param additionalDisruptionEvents Per the 2002 ISDA Equity Derivatives Definitions | 2018 ISDA CDM Equity Confirmation for Security Equity Swaps
 * @param failureToDeliver If true, failure to deliver is applicable.
 * @param representations 
 * @param nationalizationOrInsolvency Per the 2002 ISDA Equity Derivatives Definitions | 2018 ISDA CDM Equity Confirmation for Security Equity Swap
 * @param delisting Per the 2002 ISDA Equity Derivatives Definitions | 2018 ISDA CDM Equity Confirmation for Security Equity Swap:
 */
@Serializable
open class ExtraordinaryEvents (
  var additionalBespokeTerms: MutableList<Clause>? = null,
  var mergerEvents: EquityCorporateEvents? = null,
  var tenderOfferEvents: EquityCorporateEvents? = null,
  var compositionOfCombinedConsideration: Boolean? = null,
  var indexAdjustmentEvents: IndexAdjustmentEvents? = null,
  var additionalDisruptionEvents: AdditionalDisruptionEvents? = null,
  var failureToDeliver: Boolean? = null,
  var representations: Representations? = null,
  var nationalizationOrInsolvency: NationalizationOrInsolvencyOrDelistingEventEnum? = null,
  var delisting: NationalizationOrInsolvencyOrDelistingEventEnum? = null
)

@Serializable
open class FailureToPay (
  var applicable: Boolean? = null,
  var gracePeriodExtension: GracePeriodExtension? = null,
  var paymentRequirement: Money? = null
)

/**
 * Defines the structure needed to represent fallback rate parameters. This type is used to represent modular computed rates in interestRatePayouts.
 *
 * @param floatingRateIndex The floating rate index that is used as the basis of the fallback rate.
 * @param effectiveDate The date the fallback rate takes effect.
 * @param calculationParameters Support for modular calculated rates, such such as lockout compound calculations.
 * @param spreadAdjustment The economic spread applied to the underlying fallback rate to replicate the original risky rate.
 */
@Serializable
open class FallbackRateParameters (
  var floatingRateIndex: FloatingRateIndexEnum? = null,
  var effectiveDate: Date? = null,
  var calculationParameters: FloatingRateCalculationParameters? = null,
  var spreadAdjustment: Float? = null
)

/**
 * The method, prioritised by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
 *
 * @param valuationPostponement Specifies how long to wait to get a quote from a settlement rate option upon a price source disruption.
 * @param fallBackSettlementRateOption This settlement rate option will be used in its place.
 * @param fallbackSurveyValuationPostponement Request rate quotes from the market. This element is set as type Empty in FpML. When present, the FpML synonym is mapped to a value True in the CDM.
 * @param calculationAgentDetermination The calculation agent will decide the rate.
 */
@Serializable
open class FallbackReferencePrice (
  var valuationPostponement: ValuationPostponement? = null,
  var fallBackSettlementRateOption: MutableList<FieldWithMetaSettlementRateOptionEnum>? = null,
  var fallbackSurveyValuationPostponement: Boolean? = null,
  var calculationAgentDetermination: CalculationAgent? = null
)

/**
 * Payment made following trigger occurrence.
 *
 * @param payerReceiver This attribute doesn't exist as part of the FpML construct, which makes use of the PayerReceiver.model group.
 * @param levelPercentage The trigger level percentage.
 * @param amount The monetary quantity in currency units.
 * @param time The feature payment time.
 * @param currency The currency in which an amount is denominated.
 * @param paymentDate The feature payment date.
 * @param meta 
 */
@Serializable
open class FeaturePayment (
  var payerReceiver: PartyReferencePayerReceiver? = null,
  var levelPercentage: Float? = null,
  var amount: Float? = null,
  var time: TimeTypeEnum? = null,
  var currency: FieldWithMetaString? = null,
  var paymentDate: AdjustableOrRelativeDate? = null,
  var meta: MetaFields? = null
)

@Serializable
open class FinInstrm (
  var othr: Othr? = null
)

@Serializable
open class FinInstrmGnlAttrbts (
  var fullNm: String? = null,
  var clssfctnTp: String? = null,
  var ntnlCcy: String? = null
)

@Serializable
open class FinInstrmRptgTxRpt (
  var tx: Tx? = null
)

/**
 * A data to:  define business date convention adjustment to final payment period per leg.
 *
 * @param relevantUnderlyingDateReference Reference to the unadjusted cancellation effective dates.
 * @param swapStreamReference Reference to the leg, where date adjustments may apply.
 * @param businessDayConvention Override business date convention. This takes precedence over leg level information.
 */
@Serializable
open class FinalCalculationPeriodDateAdjustment (
  var relevantUnderlyingDateReference: ReferenceWithMetaAdjustableOrRelativeDates? = null,
  var swapStreamReference: ReferenceWithMetaInterestRatePayout? = null,
  var businessDayConvention: BusinessDayConventionEnum? = null
)

/**
 * Type for reporting the detailed results of calculating a cash flow for a calculation period.  This is enhanced relative to the FpML-based cashflows structure to allow more information to be returned about daily compounded rates.
 *
 * @param calculationPeriod The calculation period for which the floating calculation was performed.
 * @param calculationPeriodNotionalAmount The notional in effect during the calculation period.
 * @param fixedRate The value of the fixed rate that was used.
 * @param yearFraction The fraction of a year that this calculation represents, according to the day count fraction method.
 * @param calculatedAmount The amount of the cash flow that was computed, including any spreads and other processing.
 */
@Serializable
open class FixedAmountCalculationDetails (
  var calculationPeriod: CalculationPeriodBase? = null,
  var calculationPeriodNotionalAmount: Money? = null,
  var fixedRate: Float? = null,
  var yearFraction: Float? = null,
  var calculatedAmount: Float? = null
)

/**
 * A predefined price accorded by the counterparties.
 *
 * @param price Fixed price step schedule, including an initial price specified as an absolute number.
 */
@Serializable
open class FixedPrice (
  var price: ReferenceWithMetaPriceSchedule? = null
)

/**
 * Represents a fixed price payout. There is no underlier associated with this payout type and is based on fixed pricing per a given unit (e.g. in commodities price per barrel)
 *
 * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
 * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
 * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
 * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
 * @param paymentDates Specifies the parameters to generate the payment date schedule, either through a parametric representation or by reference to specified dates.
 * @param fixedPrice Specifies the fixed price on which fixed forward payments are based.
 * @param schedule Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
 */
@Serializable
open class FixedPricePayout (
  var paymentDates: PaymentDates? = null,
  var fixedPrice: FixedPrice? = null,
  var schedule: CalculationSchedule? = null
)
: PayoutBase()

/**
 * Type defining the specification for a fixed rate.
 *
 * @param rateSchedule The fixed rate or fixed rate schedule expressed as explicit fixed rates and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
 * @param meta 
 */
@Serializable
open class FixedRateSpecification (
  var rateSchedule: RateSchedule? = null,
  var meta: MetaFields? = null
)

/**
 * Type for reporting the detailed results of calculating a cash flow for a calculation period.  This is enhanced relative to the FpML-based cashflows structure to allow more information to be returned about daily compounded rates.
 *
 * @param calculationPeriod The calculation period for which the floating calculation was performed.
 * @param calculationPeriodNotionalAmount The notional in effect during the calculation period.
 * @param floatingRate The details of the floating rate setting.  (If it is a calculated rate, details of that calculation will be inside that.
 * @param processingDetails Details fo the floating rate treatment after the rate is observed or calculated.  This will include details of things like multipliers, spreads, caps and floors, and the raw and treated rates.
 * @param appliedRate The rate that was actually applied, after all calculations and treatments.
 * @param yearFraction The fraction of a year that this calculation represents, according to the day count fraction method.
 * @param calculatedAmount The amount of the cash flow that was computed, including any spreads and other processing.
 * @param spreadExclusiveCalculatedAMount The amount of the cash flow excluding any spread, for subsequent processing.
 */
@Serializable
open class FloatingAmountCalculationDetails (
  var calculationPeriod: CalculationPeriodBase? = null,
  var calculationPeriodNotionalAmount: Money? = null,
  var floatingRate: FloatingRateSettingDetails? = null,
  var processingDetails: FloatingRateProcessingDetails? = null,
  var appliedRate: Float? = null,
  var yearFraction: Float? = null,
  var calculatedAmount: Float? = null,
  var spreadExclusiveCalculatedAMount: Float? = null
)

/**
 * A class to specify the ISDA terms relating to the floating rate payment events and the implied additional fixed payments, applicable to the credit derivatives transactions on mortgage-backed securities with pay-as-you-go or physical settlement.
 *
 * @param failureToPayPrincipal A floating rate payment event. Corresponds to the failure by the Reference Entity to pay an expected principal amount or the payment of an actual principal amount that is less than the expected principal amount. ISDA 2003 Term: Failure to Pay Principal.
 * @param interestShortfall A floating rate payment event. With respect to any Reference Obligation Payment Date, either (a) the non-payment of an Expected Interest Amount or (b) the payment of an Actual Interest Amount that is less than the Expected Interest Amount. ISDA 2003 Term: Interest Shortfall.
 * @param writedown A floating rate payment event. Results from the fact that the underlier writes down its outstanding principal amount. ISDA 2003 Term: Writedown.
 * @param impliedWritedown A floating rate payment event. Results from the fact that losses occur to the underlying instruments that do not result in reductions of the outstanding principal of the reference obligation.
 * @param floatingAmountProvisions Specifies the floating amount provisions associated with the floatingAmountEvents.
 * @param additionalFixedPayments Specifies the events that will give rise to the payment additional fixed payments.
 */
@Serializable
open class FloatingAmountEvents (
  var failureToPayPrincipal: Boolean? = null,
  var interestShortfall: InterestShortFall? = null,
  var writedown: Boolean? = null,
  var impliedWritedown: Boolean? = null,
  var floatingAmountProvisions: FloatingAmountProvisions? = null,
  var additionalFixedPayments: AdditionalFixedPayments? = null
)

@Serializable
open class FloatingAmountProvisions (
  var wacCapInterestProvision: Boolean? = null,
  var stepUpProvision: Boolean? = null
)

@Serializable
open class FloatingRate (
  var floatingRateMultiplierSchedule: RateSchedule? = null,
  var rateTreatment: RateTreatmentEnum? = null,
  var calculationParameters: FloatingRateCalculationParameters? = null,
  var fallbackRate: FallbackRateParameters? = null
)
: FloatingRateBase()

/**
 * A class defining a floating interest rate through the specification of the floating rate index, the tenor, the multiplier schedule, the spread, the qualification of whether a specific rate treatment and/or a cap or floor apply.
 *
 * @param rateOption 
 * @param spreadSchedule The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
 * @param capRateSchedule The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
 * @param floorRateSchedule The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
 * @param meta 
 */
@Serializable
open class FloatingRateBase (
  var rateOption: ReferenceWithMetaInterestRateIndex? = null,
  var spreadSchedule: SpreadSchedule? = null,
  var capRateSchedule: StrikeSchedule? = null,
  var floorRateSchedule: StrikeSchedule? = null,
  var meta: MetaFields? = null
)

/**
 * Defines the structures needed to represent the calculation parameters for daily averaged and compounded modular rates as defined in the 2021 ISDA Definitions in Section 7. This type is used to represent modular computed rates in interestRatePayouts.
 *
 * @param calculationMethod calculation type (averaging or compounding).
 * @param observationShiftCalculation any obervation shift parameters if applicable.
 * @param lookbackCalculation any lookback  parameters if applicable.
 * @param lockoutCalculation any lockout  parameters if applicable.
 * @param applicableBusinessDays the business days that are applicable for the calculation.
 * @param observationParameters  any applicable observation parameters, such as daily caps or floors.
 */
@Serializable
open class FloatingRateCalculationParameters (
  var calculationMethod: CalculationMethodEnum? = null,
  var observationShiftCalculation: ObservationShiftCalculation? = null,
  var lookbackCalculation: OffsetCalculation? = null,
  var lockoutCalculation: OffsetCalculation? = null,
  var applicableBusinessDays: BusinessCenters? = null,
  var observationParameters: ObservationParameters? = null
)

/**
 * A data defining:  parameters associated with a floating rate reset. This data forms:  part of the cashflows representation of a stream.
 *
 * @param calculatedRate The final calculated rate for a calculation period after any required averaging of rates A calculated rate of 5% would be represented as 0.05.
 * @param rateObservation The details of a particular rate observation, including the fixing date and observed rate. A list of rate observation elements may be ordered in the document by ascending adjusted fixing date. An FpML document containing an unordered list of rate observations is still regarded as a conformant document.
 * @param floatingRateMultiplier A rate multiplier to apply to the floating rate. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one).
 * @param spread The ISDA Spread, if any, which applies for the calculation period. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
 * @param capRate The cap rate, if any, which applies to the floating rate for the calculation period. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain strike level. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
 * @param floorRate The floor rate, if any, which applies to the floating rate for the calculation period. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. The floor rate of 5% would be represented as 0.05.
 */
@Serializable
open class FloatingRateDefinition (
  var calculatedRate: Float? = null,
  var rateObservation: MutableList<RateObservation>? = null,
  var floatingRateMultiplier: Float? = null,
  var spread: Float? = null,
  var capRate: MutableList<Strike>? = null,
  var floorRate: MutableList<Strike>? = null
)

/**
 * Specification of an interest rate index which can change over time, e.g. the SONIA (Sterling Overnight Index Average) in the UK.
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 * @param name A description of the Index.
 * @param provider The organisation that creates or maintains the Index.
 * @param assetClass The Asset Class of the Index.
 * @param floatingRateIndex The reference index that is used to specify the floating interest rate.
 * @param indexTenor The ISDA Designated Maturity, i.e. the floating rate tenor.
 */
@Serializable
open class FloatingRateIndex (
  var floatingRateIndex: FieldWithMetaFloatingRateIndexEnum? = null,
  var indexTenor: Period? = null
)
: IndexBase()

/**
 * This holds the rate calculation defaults applicable for a floating rate index.
 *
 * @param category The ISDA FRO category (e.g. screen rate or calculated rate).
 * @param indexStyle The ISDA FRO style (e.g. term rate, swap rate, etc).
 * @param method The ISDA FRO calculation method (e.g. OIS Compounding).
 */
@Serializable
open class FloatingRateIndexCalculationDefaults (
  var category: FloatingRateIndexCategoryEnum? = null,
  var indexStyle: FloatingRateIndexStyleEnum? = null,
  var method: FloatingRateIndexCalculationMethodEnum? = null
)

@Serializable
open class FloatingRateIndexDefinition (
  var fro: FloatingRateIndexIdentification? = null,
  var calculationDefaults: FloatingRateIndexCalculationDefaults? = null
)

@Serializable
open class FloatingRateIndexIdentification (
  var floatingRateIndex: FieldWithMetaFloatingRateIndexEnum? = null,
  var currency: ISOCurrencyCodeEnum? = null,
  var froType: String? = null
)

/**
 * Type for reporting the details of the rate treatment.  This could potentially be replaced by the existing FloatingRateDefinition type , but this is slightly more detailed.
 *
 * @param rawRate The raw or untreated rate, prior to any of the rate treatments.
 * @param processingParameters 
 * @param processedRate The value of the rate after processing.
 * @param spreadExclusiveRate The value of the processed rate without the spread applied, for subsequent compounding, etc.
 */
@Serializable
open class FloatingRateProcessingDetails (
  var rawRate: Float? = null,
  var processingParameters: FloatingRateProcessingParameters? = null,
  var processedRate: Float? = null,
  var spreadExclusiveRate: Float? = null
)

/**
 * Type to hold the processing parameters that should be or were used to calculate a floating amount.  These parameters can vary over a schedule so this type holds the acutal values applicable to this calculation.
 *
 * @param initialRate The rate to be applied for the initial period.
 * @param multiplier floating rate multiplier.
 * @param spread spread to be added to the floating rate.
 * @param treatment US rate treatment (Bond Equivalent Yield or Money Market Yield, if applicable.
 * @param capRate capt to be applied to the floating rate.
 * @param floorRate floor to be applied to the floating rate.
 * @param rounding THe final rate rounding to be applied.
 * @param negativeTreatment How to handle negative interest rates.
 */
@Serializable
open class FloatingRateProcessingParameters (
  var initialRate: Price? = null,
  var multiplier: Float? = null,
  var spread: Float? = null,
  var treatment: RateTreatmentEnum? = null,
  var capRate: Float? = null,
  var floorRate: Float? = null,
  var rounding: Rounding? = null,
  var negativeTreatment: NegativeInterestRateTreatmentEnum? = null
)

/**
 * Type for reporting the raw (untreated) observed or calculated rate for a calculation period.  If this is a calculated rate, it allows details of the observations and the resulting rate to be returned.
 *
 * @param calculationDetails Calculated rate details (observation dates, values, and weights).
 * @param observationDate The day upon which the rate was observed (for term rates).
 * @param resetDate The day for which the rate is needed (e.g. period beginning or end date).
 * @param floatingRate The resulting rate that was observed or calculated.
 */
@Serializable
open class FloatingRateSettingDetails (
  var calculationDetails: CalculatedRateDetails? = null,
  var observationDate: Date? = null,
  var resetDate: Date? = null,
  var floatingRate: Float? = null
)

/**
 * A class to specify the floating interest rate by extending the floating rate definition with a set of attributes that specify such rate: the initial value specified as part of the trade, the rounding convention, the averaging method and the negative interest rate treatment.
 *
 * @param rateOption 
 * @param spreadSchedule The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
 * @param capRateSchedule The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
 * @param floorRateSchedule The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
 * @param meta 
 * @param floatingRateMultiplierSchedule A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
 * @param rateTreatment The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
 * @param calculationParameters Support for modular calculated rates, such such as lockout compound calculations.
 * @param fallbackRate Definition of any fallback rate that may be applicable.
 * @param initialRate The initial floating rate reset agreed between the principal parties involved in the trade. This is assumed to be the first required reset rate for the first regular calculation period. It should only be included when the rate is not equal to the rate published on the source implied by the floating rate index. An initial rate of 5% would be represented as 0.05.
 * @param finalRateRounding The rounding convention to apply to the final rate used in determination of a calculation period amount.
 * @param averagingMethod If averaging is applicable, this component specifies whether a weighted or unweighted average method of calculation is to be used. The component must only be included when averaging applies.
 * @param negativeInterestRateTreatment The specification of any provisions for calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
 */
@Serializable
open class FloatingRateSpecification (
  var initialRate: Price? = null,
  var finalRateRounding: Rounding? = null,
  var averagingMethod: AveragingWeightingMethodEnum? = null,
  var negativeInterestRateTreatment: NegativeInterestRateTreatmentEnum? = null
)
: FloatingRate()

/**
 * From FpML: A type defining either a spot or forward FX transactions.
 *
 * @param exchangedCurrency1 This is the first of the two currency flows that define a single leg of a standard foreign exchange transaction.
 * @param exchangedCurrency2 This is the second of the two currency flows that define a single leg of a standard foreign exchange transaction.
 * @param tenorPeriod A tenor expressed as a period type and multiplier (e.g. 1D, 1Y, etc.)
 */
@Serializable
open class ForeignExchange (
  var exchangedCurrency1: Cashflow? = null,
  var exchangedCurrency2: Cashflow? = null,
  var tenorPeriod: Period? = null
)

/**
 * Specification of a rate based on the exchange of a pair of cash assets in specific currencies, e.g. USD versus GBP.
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 * @param name A description of the Index.
 * @param provider The organisation that creates or maintains the Index.
 * @param assetClass The Asset Class of the Index.
 * @param quotedCurrencyPair Describes the composition of a rate that has been quoted or is to be quoted.
 * @param primaryFxSpotRateSource Specifies the primary source from which a rate should be observed.
 * @param secondaryFxSpotRateSource Specifies an alternative, or secondary, source from which a rate should be observed.
 */
@Serializable
open class ForeignExchangeRateIndex (
  var quotedCurrencyPair: FieldWithMetaQuotedCurrencyPair? = null,
  var primaryFxSpotRateSource: InformationSource? = null,
  var secondaryFxSpotRateSource: InformationSource? = null
)
: IndexBase()

/**
 * A class for defining a date frequency, e.g. one day, three months, through the combination of an integer value and a standardized period value that is specified as part of an enumeration.
 *
 * @param periodMultiplier A time period multiplier, e.g. 1, 2, or 3. If the period value is T (Term) then period multiplier must contain the value 1.
 * @param period A time period, e.g. a day, week, month, year or term of the stream.
 * @param meta 
 */
@Serializable
open class Frequency (
  var periodMultiplier: Int? = null,
  var period: PeriodExtendedEnum? = null,
  var meta: MetaFields? = null
)

/**
 * A class defining a currency and a future value date.
 *
 * @param quantity 
 * @param currency The currency in which the an amount is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
 * @param calculationPeriodNumberOfDays The number of days from the adjusted calculation period start date to the adjusted value date, calculated in accordance with the applicable day count fraction.
 * @param valueDate Adjusted value date of the future value amount.
 */
@Serializable
open class FutureValueAmount (
  var quantity: ReferenceWithMetaNonNegativeQuantitySchedule? = null,
  var currency: FieldWithMetaString? = null,
  var calculationPeriodNumberOfDays: Int? = null,
  var valueDate: Date? = null
)

/**
 * TransactionAdditionalTerms which apply to the CurrencyPair asset class.
 *
 */
@Serializable
open class FxAdditionalTerms (
)

/**
 * A type for defining FX Features.
 *
 * @param referenceCurrency Specifies the reference currency of the trade.
 * @param composite If 'Composite' is specified as the Settlement Type in the relevant Transaction Supplement, an amount in the Settlement Currency, determined by the Calculation Agent as being equal to the number of Options exercised or deemed exercised, multiplied by: (Settlement Price – Strike Price) / (Strike Price – Settlement Price) x Multiplier provided that if the above is equal to a negative amount the Option Cash Settlement Amount shall be deemed to be zero.
 * @param quanto If 'Quanto' is specified as the Settlement Type in the relevant Transaction Supplement, an amount, as determined by the Calculation Agent in accordance with the Section 8.2 of the Equity Definitions.
 * @param crossCurrency If 'Cross-Currency' is specified as the Settlement Type in the relevant Transaction Supplement, an amount in the Settlement Currency, determined by the Calculation Agent as being equal to the number of Options exercised or deemed exercised, multiplied by: (Settlement Price – Strike Price) / (Strike Price – Settlement Price) x Multiplier x one unit of the Reference Currency converted into an amount in the Settlement Currency using the rate of exchange of the Settlement Currency as quoted on the Reference Price Source on the Valuation Date, provided that if the above is equal to a negative amount the Option Cash Settlement Amount shall be deemed to be zero.
 */
@Serializable
open class FxFeature (
  var referenceCurrency: FieldWithMetaString? = null,
  var composite: Composite? = null,
  var quanto: Quanto? = null,
  var crossCurrency: Composite? = null
)

/**
 * Extends the Offset structure to specify an FX fixing date as an offset to dates specified somewhere else in the document.
 *
 * @param periodMultiplier A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
 * @param period A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
 * @param meta 
 * @param dayType In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
 * @param businessDayConvention The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
 * @param businessCenters 
 * @param businessCentersReference A reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
 * @param dateRelativeToPaymentDates The payment date references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure.
 * @param dateRelativeToCalculationPeriodDates The calculation period references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure. Implemented for Brazilian-CDI swaps where it will refer to the termination date of the appropriate leg.
 * @param dateRelativeToValuationDates The calculation period references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure. Implemented for Brazilian-CDI swaps where it will refer to the termination date of the appropriate leg.
 * @param fxFixingDate Describes the specific date when a non-deliverable forward or cash-settled option will 'fix' against a particular rate, which will be used to compute the ultimate cash settlement. This element should be omitted where a single, discrete fixing date cannot be identified e.g. on an american option, where fixing may occur at any date on a continuous range.  This attribute was formerly part of 'fxSettlementTerms', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
 */
@Serializable
open class FxFixingDate (
  var businessDayConvention: BusinessDayConventionEnum? = null,
  var businessCenters: BusinessCenters? = null,
  var businessCentersReference: ReferenceWithMetaBusinessCenters? = null,
  var dateRelativeToPaymentDates: DateRelativeToPaymentDates? = null,
  var dateRelativeToCalculationPeriodDates: DateRelativeToCalculationPeriodDates? = null,
  var dateRelativeToValuationDates: DateRelativeToValuationDates? = null,
  var fxFixingDate: AdjustableOrRelativeDate? = null
)
: Offset()

/**
 * Information source specific to Foreign Exchange products.
 *
 * @param sourceProvider An information source for obtaining a market data point. For example Bloomberg, Reuters, Telerate, etc.
 * @param sourcePage A specific page for the source for obtaining a market data point. In FpML, this is specified as a scheme, rateSourcePageScheme, for which no coding Scheme or URI is specified.
 * @param sourcePageHeading The heading for the source on a given source page.
 * @param fixingTime The time that the fixing will be taken along with a business center to define the time zone.
 */
@Serializable
open class FxInformationSource (
  var fixingTime: BusinessCenterTime? = null
)
: InformationSource()

/**
 * A data to:  describe the cashflow representation for FX linked notionals.
 *
 * @param resetDate The reset date.
 * @param adjustedFxSpotFixingDate The date on which the FX spot rate is observed. This date should already be adjusted for any applicable business day convention.
 * @param observedFxSpotRate The actual observed FX spot rate.
 * @param notionalAmount The calculation period notional amount.
 */
@Serializable
open class FxLinkedNotionalAmount (
  var resetDate: Date? = null,
  var adjustedFxSpotFixingDate: Date? = null,
  var observedFxSpotRate: Float? = null,
  var notionalAmount: Float? = null
)

/**
 * A data to:  describe a notional schedule where each notional that applies to a calculation period is calculated with reference to a notional amount or notional amount schedule in a different currency by means of a spot currency exchange rate which is normally observed at the beginning of each period.
 *
 * @param varyingNotionalCurrency The currency of the varying notional amount, i.e. the notional amount being determined periodically based on observation of a spot currency exchange rate. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
 * @param varyingNotionalFixingDates The dates on which spot currency exchange rates are observed for purposes of determining the varying notional currency amount that will apply to a calculation period.
 * @param fxSpotRateSource The information source and time at which the spot currency exchange rate will be observed.
 * @param fixingTime The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
 * @param varyingNotionalInterimExchangePaymentDates The dates on which interim exchanges of notional are paid. Interim exchanges will arise as a result of changes in the spot currency exchange amount or changes in the constant notional schedule (e.g. amortisation).
 */
@Serializable
open class FxLinkedNotionalSchedule (
  var varyingNotionalCurrency: FieldWithMetaString? = null,
  var varyingNotionalFixingDates: RelativeDateOffset? = null,
  var fxSpotRateSource: FxSpotRateSource? = null,
  var fixingTime: BusinessCenterTime? = null,
  var varyingNotionalInterimExchangePaymentDates: RelativeDateOffset? = null
)

/**
 * A class describing the rate of a currency conversion: pair of currency, quotation mode and exchange rate.
 *
 * @param quotedCurrencyPair Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
 * @param rate The rate of exchange between the two currencies of the leg of a deal. Must be specified with a quote basis.
 */
@Serializable
open class FxRate (
  var quotedCurrencyPair: QuotedCurrencyPair? = null,
  var rate: Float? = null
)

/**
 * Describes a rate source to be fixed and the date the fixing occurs
 *
 * @param settlementRateSource 
 * @param fixingDate The date on which the fixing is scheduled to occur.
 */
@Serializable
open class FxRateSourceFixing (
  var settlementRateSource: FxSettlementRateSource? = null,
  var fixingDate: AdjustableDate? = null
)

/**
 * The source of the Foreign Exchange settlement rate.
 *
 * @param settlementRateOption Indicates that an officially defined rate settlement rate option will be the used for the fixing.
 * @param nonstandardSettlementRate Indicates that a non-standard rate source will be used for the fixing.
 */
@Serializable
open class FxSettlementRateSource (
  var settlementRateOption: FieldWithMetaString? = null,
  var nonstandardSettlementRate: FxInformationSource? = null
)

/**
 * A class defining the rate source and fixing time for an FX rate.
 *
 * @param primarySource The primary source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
 * @param secondarySource An alternative, or secondary, source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
 */
@Serializable
open class FxSpotRateSource (
  var primarySource: InformationSource? = null,
  var secondarySource: InformationSource? = null
)

/**
 *  A class specifying a set of non-monetary terms for the Credit Derivative Transaction, including the buyer and seller and selected items from the ISDA 2014 Credit Definition article II, such as the reference obligation and related terms. The CDM GeneralTerms class corresponds to the FpML GeneralTerms complex type, except that the effectiveDate and scheduledTerminationDate have been positioned as part of the InterestRatePayout class in the CDM instead of in GeneralTerms.
 *
 * @param referenceInformation This attribute contains all the terms relevant to defining the reference entity and reference obligation(s).
 * @param indexReferenceInformation This attribute contains all the terms relevant to the underlying Index.
 * @param basketReferenceInformation This attribute contains all the terms relevant to defining the Credit Default Swap Basket.
 * @param additionalTerm This attribute is used for representing information contained in the Additional Terms field of the 2003 Master Credit Derivatives confirm.
 * @param substitution Value of this attribute set to 'true' indicates that substitution is applicable.
 * @param modifiedEquityDelivery Value of this attribute set to 'true' indicates that modified equity delivery is applicable.
 */
@Serializable
open class GeneralTerms (
  var referenceInformation: ReferenceInformation? = null,
  var indexReferenceInformation: CreditIndex? = null,
  var basketReferenceInformation: BasketReferenceInformation? = null,
  var additionalTerm: MutableList<FieldWithMetaString>? = null,
  var substitution: Boolean? = null,
  var modifiedEquityDelivery: Boolean? = null
)

@Serializable
open class GracePeriodExtension (
  var applicable: Boolean? = null,
  var gracePeriod: Offset? = null
)

@Serializable
open class Id (
  var lei: String? = null
)

/**
 * Attaches an identifier to a collection of objects, when those objects themselves can each be represented by an identifier. One use case is the representation of package transactions, where each component is a separate trade with its own identifier, and those trades are linked together as a package with its own identifier. The data type has been named generically rather than referring to 'packages' as it may have a number of other uses.
 *
 * @param listId The identifier for the list. In the case of a package transaction, this would be the package identifier. This attribute is mandatory to allow the list itself to be identified.
 * @param componentId Identifiers for each component of the list. Since the data type is used to link multiple identified objects together, at least 2 components are required in the list. Creating an identified list with only 1 identified component has been deemed unnecessary, because it would just create a redundant identifier.
 * @param price The price of the package.
 * @param meta 
 */
@Serializable
open class IdentifiedList (
  var listId: Identifier? = null,
  var componentId: MutableList<Identifier>? = null,
  var price: Price? = null,
  var meta: MetaFields? = null
)

/**
 * A class to specify a generic identifier, applicable to CDM artefacts such as executions, contracts, lifecycle events and legal documents. An issuer can be associated with the actual identifier value as a way to properly qualify it.
 *
 * @param issuerReference The identifier issuer, when specified by reference to a party specified as part of the transaction.
 * @param issuer The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).
 * @param assignedIdentifier The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.
 * @param meta 
 */
@Serializable
open class Identifier (
  var issuerReference: ReferenceWithMetaParty? = null,
  var issuer: FieldWithMetaString? = null,
  var assignedIdentifier: MutableList<AssignedIdentifier>? = null,
  var meta: MetaFields? = null
)

/**
 * A class specifying the Independent Amount as the combination of a payer/receiver, a payment amount, a payment date and an associated payment calculation rule.
 *
 * @param payerPartyReference The party responsible for making the payments defined by this structure.
 * @param payerAccountReference A reference to the account responsible for making the payments defined by this structure.
 * @param receiverPartyReference The party that receives the payments corresponding to this structure.
 * @param receiverAccountReference A reference to the account that receives the payments corresponding to this structure.
 * @param paymentDetail An attribute that specifies a payment as the combination of a payment amount, a payment date and an associated payment calculation rule.
 */
@Serializable
open class IndependentAmount (
  var paymentDetail: MutableList<PaymentDetail>? = null
)
: PartyReferencePayerReceiver()

/**
 * An Index is an Observable which is computed based on the prices, rates or valuations of a number of assets that are tracked in a standardized way.  Examples include equity market indices as well as indices on interest rates, inflation and credit instruments.
 *
 * @param CreditIndex An index based on credit risk, typically composed using corporate debt instruments in a region or industry sector, e.g. the iTraxx indices.
 * @param EquityIndex An index based on equity securities, e.g. the S&P 500.
 * @param InterestRateIndex An index based in interest rates or inflation rates in a certain market.
 * @param ForeignExchangeRateIndex A rate based on the exchange of a pair of cash assets in specific currencies, e.g. USD versus GBP.
 * @param OtherIndex An index created by a market participant which doesn't align with the other index types.
 */
@Serializable
open class Index (
  var creditIndex: CreditIndex? = null,
  var equityIndex: EquityIndex? = null,
  var interestRateIndex: FieldWithMetaInterestRateIndex? = null,
  var foreignExchangeRateIndex: ForeignExchangeRateIndex? = null,
  var otherIndex: OtherIndex? = null
)

/**
 * Defines the specification of the consequences of Index Events as defined by the 2002 ISDA Equity Derivatives Definitions.
 *
 */
@Serializable
open class IndexAdjustmentEvents (
)

/**
 * Identifies an index by referencing an identifier.
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 * @param name A description of the Index.
 * @param provider The organisation that creates or maintains the Index.
 * @param assetClass The Asset Class of the Index.
 */
@Serializable
open class IndexBase (
  var name: FieldWithMetaString? = null,
  var provider: LegalEntity? = null,
  var assetClass: AssetClassEnum? = null
)
: AssetBase()

/**
 * Defines the information needed to create a Index Transition Business Event.
 *
 * @param priceQuantity Specifies both new floating rate index and spread adjustment for each leg to be updated.  The spread adjustment accounts for the difference between the old floating rate index relative to the new one. This spread amount is added to the existing spread to determine the new spread, which is applied from the specified effective date forward. In the case of the IBOR Fallback Rate Adjustments, the adjustment spread (also known as the Fallback Adjustment) accounts for two distinctions: i) the fact that the replacement Risk-Free Rate is an overnight rate while IBORs have term structures (e.g., 1, 3, 6-month LIBOR); and (ii) the historical spread differential between IBORs and their term equivalent Overnight Risk-Free Rate compounded rates.
 * @param effectiveDate Specifies the effective date of the index transition event. This is first date on which the floating rate calculation will use the new floating rate index and adjusted spread in the floating rate calculation.
 * @param cashTransfer Specifies the cash transfer that can optionally be tied to an index transition event.
 */
@Serializable
open class IndexTransitionInstruction (
  var priceQuantity: MutableList<PriceQuantity>? = null,
  var effectiveDate: Date? = null,
  var cashTransfer: Transfer? = null
)

@Serializable
open class Indx (
  var nm: Nm? = null
)

/**
 * Specification of an index that measures inflation in a specific market, e.g. the US Consumer Price Index.
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 * @param name A description of the Index.
 * @param provider The organisation that creates or maintains the Index.
 * @param assetClass The Asset Class of the Index.
 * @param inflationRateIndex The reference index that is used to specify the inflation interest rate.
 * @param indexTenor The ISDA Designated Maturity, i.e. the floating rate tenor.
 */
@Serializable
open class InflationIndex (
  var inflationRateIndex: FieldWithMetaInflationRateIndexEnum? = null,
  var indexTenor: Period? = null
)
: IndexBase()

/**
 * A data to:  specify the inflation rate.
 *
 * @param rateOption 
 * @param spreadSchedule The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
 * @param capRateSchedule The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
 * @param floorRateSchedule The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
 * @param meta 
 * @param floatingRateMultiplierSchedule A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
 * @param rateTreatment The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
 * @param calculationParameters Support for modular calculated rates, such such as lockout compound calculations.
 * @param fallbackRate Definition of any fallback rate that may be applicable.
 * @param initialRate The initial floating rate reset agreed between the principal parties involved in the trade. This is assumed to be the first required reset rate for the first regular calculation period. It should only be included when the rate is not equal to the rate published on the source implied by the floating rate index. An initial rate of 5% would be represented as 0.05.
 * @param finalRateRounding The rounding convention to apply to the final rate used in determination of a calculation period amount.
 * @param averagingMethod If averaging is applicable, this component specifies whether a weighted or unweighted average method of calculation is to be used. The component must only be included when averaging applies.
 * @param negativeInterestRateTreatment The specification of any provisions for calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
 * @param inflationLag An off-setting period from the payment date which determines the reference period for which the inflation index is observed.
 * @param indexSource The reference source such as Reuters or Bloomberg. FpML specifies indexSource to be of type rateSourcePageScheme, but without specifying actual values.
 * @param mainPublication The current main publication source such as relevant web site or a government body. FpML specifies mainPublication to be of type mainPublicationSource, but without specifying actual values.
 * @param interpolationMethod The method used when calculating the Inflation Index Level from multiple points. The most common is Linear.
 * @param initialIndexLevel Initial known index level for the first calculation period.
 * @param fallbackBondApplicable The applicability of a fallback bond as defined in the 2006 ISDA Inflation Derivatives Definitions, sections 1.3 and 1.8.
 * @param calculationMethod Indicates how to use the inflation index to calculate the payment (e.g. Ratio, Return, Spread). Added for Inflation Asset Swap
 * @param calculationStyle Indicates the style of how the inflation index calculates the payment (e.g. YearOnYear, ZeroCoupon).
 * @param finalPrincipalExchangeCalculation To be specified only for products that embed a redemption payment.
 */
@Serializable
open class InflationRateSpecification (
  var inflationLag: Offset? = null,
  var indexSource: FieldWithMetaString? = null,
  var mainPublication: FieldWithMetaString? = null,
  var interpolationMethod: FieldWithMetaInterpolationMethodEnum? = null,
  var initialIndexLevel: Float? = null,
  var fallbackBondApplicable: Boolean? = null,
  var calculationMethod: InflationCalculationMethodEnum? = null,
  var calculationStyle: InflationCalculationStyleEnum? = null,
  var finalPrincipalExchangeCalculation: FinalPrincipalExchangeCalculationEnum? = null
)
: FloatingRateSpecification()

/**
 * A class defining the source for a piece of information (e.g. a rate fix or an FX fixing). The attribute names have been adjusted from FpML to address the fact that the information is not limited to rates.
 *
 * @param sourceProvider An information source for obtaining a market data point. For example Bloomberg, Reuters, Telerate, etc.
 * @param sourcePage A specific page for the source for obtaining a market data point. In FpML, this is specified as a scheme, rateSourcePageScheme, for which no coding Scheme or URI is specified.
 * @param sourcePageHeading The heading for the source on a given source page.
 */
@Serializable
open class InformationSource (
  var sourceProvider: FieldWithMetaInformationProviderEnum? = null,
  var sourcePage: FieldWithMetaString? = null,
  var sourcePageHeading: String? = null
)

/**
 * A CDM class which purpose is to specify the initial fixing date either alongside the FpML interest rate specification as an offset of another date, or alongside the credit derivative specification as an unadjusted date.
 *
 * @param relativeDateOffset 
 * @param initialFixingDate 
 */
@Serializable
open class InitialFixingDate (
  var relativeDateOffset: RelativeDateOffset? = null,
  var initialFixingDate: Date? = null
)

/**
 * Instruction to a function that will be used to perform a business event
 *
 * @param primitiveInstruction Specifies the primitive instructions that will be used to call primitive event functions.
 * @param before Specifies the trade state that will be acted on by the primitive event functions.
 */
@Serializable
open class Instruction (
  var primitiveInstruction: PrimitiveInstruction? = null,
  var before: ReferenceWithMetaTradeState? = null
)

/**
 * A type of Asset that is issued by one party to one or more others.
 *
 * @param ListedDerivative A securitized derivative on another asset that is created by an exchange.
 * @param Loan An Asset that represents a loan or borrow obligation.
 * @param Security An Asset that is issued by a party to be held by or transferred to others.
 */
@Serializable
open class Instrument (
  var listedDerivative: ListedDerivative? = null,
  var loan: Loan? = null,
  var security: Security? = null
)

/**
 * Defines the common attributes for all Instrument data types.
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 * @param instrumentType Identifies the type of an instrument using an enumerated list.
 */
@Serializable
open class InstrumentBase (
  var instrumentType: InstrumentTypeEnum? = null
)
: AssetBase()

/**
 * A class to specify the application of Interest Amount with respect to the Delivery Amount and the Return Amount.
 *
 * @param returnAmount The application of Interest Amount with respect the Return Amount.
 * @param deliveryAmount The application of Interest Amount with respect the Delivery Amount.
 */
@Serializable
open class InterestAmountApplication (
  var returnAmount: ReturnAmount? = null,
  var deliveryAmount: DeliveryAmount? = null
)

@Serializable
open class InterestRateCurve (
  var floatingRateIndex: FieldWithMetaFloatingRateIndexEnum? = null,
  var tenor: Period? = null
)

/**
 * An index based in interest rates or inflation rates in a certain market.
 *
 * @param FloatingRateIndex An interest rate index which can change over time, e.g. the SONIA (Sterling Overnight Index Average) in the UK.
 * @param InflationIndex An index that measures inflation in a specific market, e.g. the US Consumer Price Index.
 */
@Serializable
open class InterestRateIndex (
  var floatingRateIndex: FloatingRateIndex? = null,
  var inflationIndex: InflationIndex? = null
)

/**
 *  A class to specify all of the terms necessary to define and calculate a cash flow based on a fixed, a floating or an inflation index rate. The interest rate payout can be applied to interest rate swaps and FRA (which both have two associated interest rate payouts), credit default swaps (to represent the fee leg when subject to periodic payments) and equity swaps (to represent the funding leg). The associated globalKey denotes the ability to associate a hash value to the InterestRatePayout instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 *
 * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
 * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
 * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
 * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
 * @param rateSpecification The specification of the rate value(s) applicable to the contract using either a floating rate calculation, a single fixed rate, a fixed rate schedule, or an inflation rate calculation.
 * @param dayCountFraction The day count fraction. The cardinality has been relaxed when compared with the FpML interest rate swap for the purpose of accommodating standardized credit default swaps which DCF is not explicitly stated as part of the economic terms. The data rule InterestRatePayout_dayCountFraction requires that the DCF be stated for interest rate products.
 * @param calculationPeriodDates The parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods.
 * @param paymentDates The payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the reset dates).
 * @param paymentDate The payment date, where only one date is specified, as for the FRA product.
 * @param paymentDelay Applicable to CDS on MBS to specify whether payment delays are applicable to the fixed Amount. RMBS typically have a payment delay of 5 days between the coupon date of the reference obligation and the payment date of the synthetic swap. CMBS do not, on the other hand, with both payment dates being on the 25th of each month.
 * @param resetDates The reset dates schedule, i.e. the dates on which the new observed index value is applied for each period and the interest rate hence begins to accrue.
 * @param discountingMethod The parameters specifying any discounting conventions that may apply. This element must only be included if discounting applies.
 * @param compoundingMethod If one or more calculation period contributes to a single payment amount this element specifies whether compounding is applicable and, if so, what compounding method is to be used. This element must only be included when more than one calculation period contributes to a single payment amount.
 * @param cashflowRepresentation The cashflow representation of the swap stream.
 * @param stubPeriod The stub calculation period amount parameters. This element must only be included if there is an initial or final stub calculation period. Even then, it must only be included if either the stub references a different floating rate tenor to the regular calculation periods, or if the stub is calculated as a linear interpolation of two different floating rate tenors, or if a specific stub rate or stub amount has been negotiated.
 * @param bondReference Reference to a bond underlier to represent an asset swap or Condition Precedent Bond.
 * @param fixedAmount Fixed Amount Calculation
 * @param floatingAmount Floating Amount Calculation
 * @param spreadCalculationMethod Method by which spread is calculated. For example on an asset swap: 'ParPar' or 'Proceeds' may be the method indicated.
 */
@Serializable
open class InterestRatePayout (
  var rateSpecification: RateSpecification? = null,
  var dayCountFraction: FieldWithMetaDayCountFractionEnum? = null,
  var calculationPeriodDates: CalculationPeriodDates? = null,
  var paymentDates: PaymentDates? = null,
  var paymentDate: AdjustableDate? = null,
  var paymentDelay: Boolean? = null,
  var resetDates: ResetDates? = null,
  var discountingMethod: DiscountingMethod? = null,
  var compoundingMethod: CompoundingMethodEnum? = null,
  var cashflowRepresentation: CashflowRepresentation? = null,
  var stubPeriod: StubPeriod? = null,
  var bondReference: BondReference? = null,
  var fixedAmount: String? = null,
  var floatingAmount: String? = null,
  var spreadCalculationMethod: SpreadCalculationMethodEnum? = null
)
: PayoutBase()

/**
 * A class to specify the interest shortfall floating rate payment event.
 *
 * @param interestShortfallCap Specifies the nature of the interest Shortfall cap (i.e. Fixed Cap or Variable Cap) in the case where it is applicable. ISDA 2003 Term: Interest Shortfall Cap.
 * @param compounding 
 * @param rateSource The rate source in the case of a variable cap.
 */
@Serializable
open class InterestShortFall (
  var interestShortfallCap: InterestShortfallCapEnum? = null,
  var compounding: Boolean? = null,
  var rateSource: FieldWithMetaFloatingRateIndexEnum? = null
)

/**
 * A data type that can be used to describe an inventory of securities.
 *
 * @param inventoryRecord An array holding the list of inventory being described. Each element in the inventoryRecord array represents an individual piece of inventory i.e. a security.
 */
@Serializable
open class Inventory (
  var inventoryRecord: MutableList<InventoryRecord>? = null
)

/**
 * An individual piece of inventory. This represents a single security.
 *
 * @param identifer Unique identifier for this record. This can be used to uniquely identify a specific piece of inventory.
 * @param security The security details.
 */
@Serializable
open class InventoryRecord (
  var identifer: AssignedIdentifier? = null,
  var security: Security? = null
)

@Serializable
open class InvstmtDcsnPrsn (
  var prsn: Prsn? = null
)

@Serializable
open class IssuerAgencyRating (
  var issuerAgencyRating: AgencyRatingCriteria? = null
)

@Serializable
open class IssuerCountryOfOrigin (
  var issuerCountryOfOrigin: ISOCountryCodeEnum? = null
)

@Serializable
open class IssuerName (
  var issuerName: LegalEntity? = null
)

/**
 * Knock In means option to exercise comes into existence. Knock Out means option to exercise goes out of existence.
 *
 * @param knockIn The knock in.
 * @param knockOut The knock out.
 */
@Serializable
open class Knock (
  var knockIn: TriggerEvent? = null,
  var knockOut: TriggerEvent? = null
)

/**
 * The pricing period per calculation period if the pricing days do not wholly fall within the respective calculation period.
 *
 * @param lagDuration Defines the offset of the series of pricing dates relative to the calculation period.
 * @param firstObservationDateOffset Defines the offset of the series of pricing dates relative to the calculation period.
 */
@Serializable
open class Lag (
  var lagDuration: Offset? = null,
  var firstObservationDateOffset: Offset? = null
)

/**
 * The specification of a legal agreement between two parties, being negotiated or having been executed. This includes the baseline information and the optional specialised elections
 *
 * @param agreementDate The date on which the legal agreement has been agreed between the parties. This corresponds to the Date of Deed in an English Law document.
 * @param effectiveDate The date on which, or as of which, the agreement is effective, if different from the agreement date. It is expected that it will most often correspond to the agreement date, although there could be situations where the parties will explicitly agree on a distinct effective date.
 * @param identifier The legal agreement identifier. Several identifiers can be specified.
 * @param legalAgreementIdentification The type of legal agreement, identified via a set of composable attributes: agreementName, publisher, governing law and version, e.g. ISDA 2013 Standard Credit Support Annex English Law.
 * @param contractualParty The two contractual parties to the legal agreement, which reference information is positioned as part of the partyInformation attribute.
 * @param otherParty The role(s) that other party(ies) may have in relation to the legal agreement, further to the contractual parties.
 * @param attachment A human readable document, for example a confirmation.
 * @param agreementTerms Specification of the content of the legal agreement.
 * @param relatedAgreements Specifies the agreement(s) that govern the agreement, either as a reference to such agreements when specified as part of the CDM, or through identification of some of the key terms of those agreements, such as the type of agreement, the publisher, the vintage, the agreement identifier and the agreement date.
 * @param umbrellaAgreement The determination of whether Umbrella Agreement terms are applicable (True) or Not Applicable (False).
 * @param meta 
 */
@Serializable
open class LegalAgreement (
  var agreementTerms: AgreementTerms? = null,
  var relatedAgreements: MutableList<LegalAgreement>? = null,
  var umbrellaAgreement: UmbrellaAgreement? = null,
  var meta: MetaFields? = null
)
: LegalAgreementBase()

/**
 * Specifies the legal agreement baseline information, being negotiated or having been executed. It excludes specialized elections
 *
 * @param agreementDate The date on which the legal agreement has been agreed between the parties. This corresponds to the Date of Deed in an English Law document.
 * @param effectiveDate The date on which, or as of which, the agreement is effective, if different from the agreement date. It is expected that it will most often correspond to the agreement date, although there could be situations where the parties will explicitly agree on a distinct effective date.
 * @param identifier The legal agreement identifier. Several identifiers can be specified.
 * @param legalAgreementIdentification The type of legal agreement, identified via a set of composable attributes: agreementName, publisher, governing law and version, e.g. ISDA 2013 Standard Credit Support Annex English Law.
 * @param contractualParty The two contractual parties to the legal agreement, which reference information is positioned as part of the partyInformation attribute.
 * @param otherParty The role(s) that other party(ies) may have in relation to the legal agreement, further to the contractual parties.
 * @param attachment A human readable document, for example a confirmation.
 */
@Serializable
open class LegalAgreementBase (
  var agreementDate: Date? = null,
  var effectiveDate: Date? = null,
  var identifier: MutableList<Identifier>? = null,
  var legalAgreementIdentification: LegalAgreementIdentification? = null,
  var contractualParty: MutableList<ReferenceWithMetaParty>? = null,
  var otherParty: MutableList<PartyRole>? = null,
  var attachment: MutableList<Resource>? = null
)

/**
 * Specifies the type of legal agreement, identified via a set of composable attributes: agreementName, publisher, governing law and version, e.g. ISDA 2013 Standard Credit Support Annex English Law.
 *
 * @param governingLaw The law governing the legal agreement, e.g. English Law, New York Law or Japanese Law.
 * @param agreementName The legal agreement name, e.g. Credit Support Annex for Variation Margin.
 * @param publisher The legal agreement publisher, e.g. ISDA.
 * @param vintage In the case where successive definitions of the legal agreement have been developed, the vintage identification. This is typically (but not necessarily) done by referencing the year, e.g. 2013 in the case of the ISDA 2013 Standard Credit Support Annex.
 */
@Serializable
open class LegalAgreementIdentification (
  var governingLaw: GoverningLawEnum? = null,
  var agreementName: AgreementName? = null,
  var publisher: LegalAgreementPublisherEnum? = null,
  var vintage: Int? = null
)

/**
 * A class to specify a legal entity, with a required name and an optional entity identifier (such as the LEI).
 *
 * @param entityId A legal entity identifier (e.g. RED entity code).
 * @param name The legal entity name.
 * @param meta 
 */
@Serializable
open class LegalEntity (
  var entityId: MutableList<FieldWithMetaString>? = null,
  var name: FieldWithMetaString? = null,
  var meta: MetaFields? = null
)

@Serializable
open class LimitApplicable (
  var limitType: FieldWithMetaCreditLimitTypeEnum? = null,
  var clipSize: Int? = null,
  var amountUtilized: Float? = null,
  var utilization: CreditLimitUtilisation? = null,
  var amountRemaining: Float? = null,
  var currency: FieldWithMetaString? = null,
  var velocity: Velocity? = null
)

/**
 * A class to represent the CDM attributes that are not part of the FpML standard. Once broader usage is confirmed, it is expected that those two classes can be collapsed.
 *
 * @param limitType Standard code to indicate which type of credit line is being referred to - i.e. IM, DV01, PV01, CS01, Notional, Clip Size, Notional, maximumOrderQuantity.
 * @param clipSize This element is required in FpML, optional in CDM for the purpose of accommodating the CME data representation while making reference to the FpML one.
 * @param amountUtilized The limit utilised by all the cleared trades for the limit level and limit type. While the attribute is of type integer in FpML and the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
 * @param utilization 
 * @param amountRemaining The limit remaining for the limit level and limit type. This does not take into account any pending trades. While the attribute is of type integer in FpML and the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
 * @param currency The currency in which the applicable limit is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
 * @param velocity 
 * @param limitLevel The level at which the limit is set: customer business, proprietary business or account level. This attribute is specified as a string as part of the CME clearing confirmation specification.
 * @param limitAmount The total limit available for the limit level and limit type. While the attribute is of type integer in the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
 * @param limitImpactDueToTrade The limit utilized by this specific trade. While the attribute is of type integer in the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
 */
@Serializable
open class LimitApplicableExtended (
  var limitLevel: FieldWithMetaLimitLevelEnum? = null,
  var limitAmount: Float? = null,
  var limitImpactDueToTrade: Float? = null
)
: LimitApplicable()

/**
 * A class to provide lineage information across lifecycle events through a pointer or set of pointers into the event(s), contract(s) and, possibly, payout components that the event is dependent on or relates to. As an example, if an contractFormation event is corrected, the correction event will have a lineage into the initial event, which takes the form of a globalKey into that initial contract formation event. Two referencing mechanisms are provided as part of the CDM: either the globalKey, which corresponds to the hash value of the CDM class which is referred to, or a reference qualifier which is meant to provide support for the ingestion of xml documents with id/href mechanisms. The CDM recommends the use of the globalKey and provides a default implementation which is accessible in the generated code through org.isda.cdm.globalKey.GlobalKeyHashCalculator. If implementers want to use an alternative hashing mechanism, the API in which they need to plug it is com.rosetta.model.lib.HashFunction.
 *
 * @param tradeReference 
 * @param eventReference The reference to the instantiation of an Event object, either through a globalKey or an xml-derived id/href mechanism. The definition associated to the Lineage class provides more details with respect to those referencing approaches, their expected usage and available implementation.
 * @param portfolioStateReference The reference to the previous state of a Portfolio, in a chain of Events leading up to a build of that Portfolio as the holding of Product(s) in specific Quantity(ies). As part of the PortfolioState object, a pointer to the previous PortfolioState is provided through a Lineage object, together with pointer(s) to the Event or set of Events leading up to the current (new) state.
 */
@Serializable
open class Lineage (
  var tradeReference: MutableList<ReferenceWithMetaTrade>? = null,
  var eventReference: MutableList<ReferenceWithMetaWorkflowStep>? = null,
  var portfolioStateReference: MutableList<ReferenceWithMetaPortfolioState>? = null
)

/**
 * A securitized derivative on another asset.
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 * @param instrumentType Identifies the type of an instrument using an enumerated list.
 * @param deliveryTerm Also called contract month or delivery month. However, it's not always a month. It is usually expressed using a code, e.g. Z23 would be the Dec 2023 contract, (Z = December). For crude oil, the corresponding contract might be called CLZ23. Optional as this can be uniquely identified in the identifier.
 * @param optionType The type of option, ie Put or Call. Left empty if it is a Future.
 * @param strike Specifies the strike of the option.
 */
@Serializable
open class ListedDerivative (
  var deliveryTerm: String? = null,
  var optionType: PutCallEnum? = null,
  var strike: Float? = null
)
: InstrumentBase()

/**
 * Specifies a filter based on a stock exchange.
 *
 * @param exchange Represents a filter based on the Primary Stock Exchange facilitating the listing of companies, exchange of Stocks, Exchange traded Derivatives, Bonds, and other Securities expressed in ISO standard 10383.
 */
@Serializable
open class ListingExchange (
  var exchange: MutableList<FieldWithMetaString>? = null
)

/**
 * Specifies a filter based on an industry sector.
 *
 * @param sector Represents a filter based on an industry sector defined under a system for classifying industry types such as Global Industry Classification Standard (GICS) and North American Industry Classification System (NAICS)
 */
@Serializable
open class ListingSector (
  var sector: MutableList<FieldWithMetaString>? = null
)

/**
 * Identifies a loan by referencing an asset identifier and through an optional set of attributes.
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 * @param instrumentType Identifies the type of an instrument using an enumerated list.
 * @param borrower Specifies the borrower. There can be more than one borrower. It is meant to be used in the event that there is no Bloomberg Id or the Secured List isn't applicable.
 * @param lien Specifies the seniority level of the lien.
 * @param facilityType Specifies the type of loan facility (letter of credit, revolving, ...).
 * @param creditAgreementDate Specifies the credit agreement date is the closing date (the date where the agreement has been signed) for the loans in the credit agreement. Funding of the facilities occurs on (or sometimes a little after) the Credit Agreement date. This underlier attribute is used to help identify which of the company's outstanding loans are being referenced by knowing to which credit agreement it belongs. ISDA Standards Terms Supplement term: Date of Original Credit Agreement.
 * @param tranche Denotes the loan tranche that is subject to the derivative transaction. It will typically be referenced as the Bloomberg tranche number. ISDA Standards Terms Supplement term: Bloomberg Tranche Number.
 */
@Serializable
open class Loan (
  var borrower: MutableList<LegalEntity>? = null,
  var lien: FieldWithMetaString? = null,
  var facilityType: FieldWithMetaString? = null,
  var creditAgreementDate: Date? = null,
  var tranche: FieldWithMetaString? = null
)
: InstrumentBase()

/**
 * A class to specify loan with a participation agreement whereby the buyer is capable of creating, or procuring the creation of, a contractual right in favour of the seller that provides the seller with recourse to the participation seller for a specified share in any payments due under the relevant loan which are received by the participation seller. ISDA 2003 Term: Direct Loan Participation.
 *
 * @param applicable Indicates whether the provision is applicable.
 * @param partialCashSettlement Specifies whether either 'Partial Cash Settlement of Assignable Loans', 'Partial Cash Settlement of Consent Required Loans' or 'Partial Cash Settlement of Participations' is applicable. If this element is specified and Assignable Loan is a Deliverable Obligation Characteristic, any Assignable Loan that is deliverable, but where a non-receipt of Consent by the Physical Settlement Date has occurred, the Loan can be cash settled rather than physically delivered. If this element is specified and Consent Required Loan is a Deliverable Obligation Characteristic, any Consent Required Loan that is deliverable, but where a non-receipt of Consent by the Physical Settlement Date has occurred, the Loan can be cash settled rather than physically delivered. If this element is specified and Direct Loan Participation is a Deliverable Obligation Characteristic, any Participation that is deliverable, but where this participation has not been effected (has not come into effect) by the Physical Settlement Date, the participation can be cash settled rather than physically delivered.
 * @param qualifyingParticipationSeller If Direct Loan Participation is specified as a deliverable obligation characteristic, this specifies any requirements for the Qualifying Participation Seller. The requirements may be listed free-form. ISDA 2003 Term: Qualifying Participation Seller.
 */
@Serializable
open class LoanParticipation (
  var qualifyingParticipationSeller: String? = null
)
: PCDeliverableObligationCharac()

/**
 * Specifies a location identifier. An issuer and an identifier type can be associated with the actual identifier value as a way to properly qualify it.
 *
 * @param issuerReference The identifier issuer, when specified by reference to a party specified as part of the transaction.
 * @param issuer The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).
 * @param assignedIdentifier The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.
 * @param meta 
 * @param locationIdentifierType Specifies the nature of a location identifier.
 */
@Serializable
open class LocationIdentifier (
  var locationIdentifierType: CommodityLocationIdentifierTypeEnum? = null
)
: Identifier()

/**
 * A class to specify the amount to be paid by the buyer of the option if the option is exercised prior to the Early Call Date (typically applicable to the convertible bond options).
 *
 * @param floatingRateIndex 
 * @param indexTenor The ISDA Designated Maturity, i.e. the tenor of the floating rate.
 * @param spread Spread in basis points over the floating rate index.
 * @param side The side (bid/mid/ask) of the measure.
 * @param interpolationMethod The type of interpolation method that the calculation agent reserves the right to use.
 * @param earlyCallDate Date prior to which the option buyer will have to pay a Make Whole Amount to the option seller if he/she exercises the option.
 */
@Serializable
open class MakeWholeAmount (
  var interpolationMethod: InterpolationMethodEnum? = null,
  var earlyCallDate: FieldWithMetaDate? = null
)
: SwapCurveValuation()

/**
 * A data to:  define an early termination provision for which exercise is mandatory.
 *
 * @param mandatoryEarlyTerminationDate The early termination date associated with a mandatory early termination of a swap.
 * @param calculationAgent The ISDA Calculation Agent responsible for performing duties associated with an optional early termination.
 * @param cashSettlement If specified, this means that cash settlement is applicable to the transaction and defines the parameters associated with the cash settlement procedure. If not specified, then physical settlement is applicable.
 * @param mandatoryEarlyTerminationAdjustedDates The adjusted dates associated with a mandatory early termination provision. These dates have been adjusted for any applicable business day convention.
 * @param meta 
 */
@Serializable
open class MandatoryEarlyTermination (
  var mandatoryEarlyTerminationDate: AdjustableDate? = null,
  var calculationAgent: CalculationAgent? = null,
  var cashSettlement: SettlementTerms? = null,
  var mandatoryEarlyTerminationAdjustedDates: MandatoryEarlyTerminationAdjustedDates? = null,
  var meta: MetaFields? = null
)

/**
 * A data defining:  the adjusted dates associated with a mandatory early termination provision.
 *
 * @param adjustedEarlyTerminationDate The early termination date that is applicable if an early termination provision is exercised. This date should already be adjusted for any applicable business day convention.
 * @param adjustedCashSettlementValuationDate The date by which the cash settlement amount must be agreed. This date should already be adjusted for any applicable business day convention.
 * @param adjustedCashSettlementPaymentDate The date on which the cash settlement amount is paid. This date should already be adjusted for any applicable business date convention.
 */
@Serializable
open class MandatoryEarlyTerminationAdjustedDates (
  var adjustedEarlyTerminationDate: Date? = null,
  var adjustedCashSettlementValuationDate: Date? = null,
  var adjustedCashSettlementPaymentDate: Date? = null
)

/**
 * A class defining manual exercise, i.e. that the option buyer counterparty must give notice to the option seller of exercise.
 *
 * @param exerciseNotice Definition of the party to whom notice of exercise should be given.
 * @param fallbackExercise If fallback exercise is specified then the notional amount of the underlying swap, not previously exercised under the swaption, will be automatically exercised at the expiration time on the expiration date if at such time the buyer is in-the-money, provided that the difference between the settlement rate and the fixed rate under the relevant underlying swap is not less than one tenth of a percentage point (0.10% or 0.001). The term in-the-money is assumed to have the meaning defined in the 2000 ISDA Definitions, Section 17.4. In-the-money.
 */
@Serializable
open class ManualExercise (
  var exerciseNotice: ExerciseNotice? = null,
  var fallbackExercise: Boolean? = null
)

/**
 * Represents common attributes required for Issuance and Response to a Margin Call action as a result of a demand for delivery or return of collateral determined under a legal agreement such as a credit support document or equivalent.
 *
 * @param instructionType Identifies the enumeration values to specify the call notification type, direction, specific action type.
 * @param party Represents the parties to the margin call. The cardinality is optional to address the case where both parties of the event are specified and a third party if applicable.
 * @param partyRole Represents the role each specified party takes in the margin call. further to the principal roles, payer and receiver.
 * @param clearingBroker Indicates the name of the Clearing Broker FCM/DCM.
 * @param callIdentifier Represents a unique Identifier for a margin call message, that can be referenced throughout all points of the process.
 * @param callAgreementType Specifies the legal agreement type the margin call is generated from and governed by.
 * @param agreementMinimumTransferAmount Specifies the collateral legal agreement minimum transfer amount in base currency.
 * @param agreementThreshold Specifies the collateral legal agreement threshold amount in base currency.
 * @param agreementRounding Specifies the collateral legal agreement rounding in base currency.
 * @param regMarginType Identifies margin type and if related regulatory mandate
 * @param regIMRole Indicates the role of the party in an regulatory initial margin call instruction (i.e Pledgor party or Secured party).
 * @param baseCurrencyExposure Represents the current mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency), to be referenced in a margin call.
 * @param collateralPortfolio Represents attributes to define the details of collateral assets within a collateral portfolio to be used in margin call messaging and contribute to collateral balances e.g securities in a collateral account recorded by the principal as held or posted.
 * @param independentAmountBalance Represents additional credit support amount over and above mark to market value.
 */
@Serializable
open class MarginCallBase (
  var instructionType: MarginCallInstructionType? = null,
  var party: MutableList<Party>? = null,
  var partyRole: MutableList<PartyRole>? = null,
  var clearingBroker: Party? = null,
  var callIdentifier: Identifier? = null,
  var callAgreementType: AgreementName? = null,
  var agreementMinimumTransferAmount: Money? = null,
  var agreementThreshold: Money? = null,
  var agreementRounding: Money? = null,
  var regMarginType: RegMarginTypeEnum? = null,
  var regIMRole: RegIMRoleEnum? = null,
  var baseCurrencyExposure: MarginCallExposure? = null,
  var collateralPortfolio: ReferenceWithMetaCollateralPortfolio? = null,
  var independentAmountBalance: CollateralBalance? = null
)

/**
 * Represents attributes required for mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency).
 *
 * @param instructionType Identifies the enumeration values to specify the call notification type, direction, specific action type.
 * @param party Represents the parties to the margin call. The cardinality is optional to address the case where both parties of the event are specified and a third party if applicable.
 * @param partyRole Represents the role each specified party takes in the margin call. further to the principal roles, payer and receiver.
 * @param clearingBroker Indicates the name of the Clearing Broker FCM/DCM.
 * @param callIdentifier Represents a unique Identifier for a margin call message, that can be referenced throughout all points of the process.
 * @param callAgreementType Specifies the legal agreement type the margin call is generated from and governed by.
 * @param agreementMinimumTransferAmount Specifies the collateral legal agreement minimum transfer amount in base currency.
 * @param agreementThreshold Specifies the collateral legal agreement threshold amount in base currency.
 * @param agreementRounding Specifies the collateral legal agreement rounding in base currency.
 * @param regMarginType Identifies margin type and if related regulatory mandate
 * @param regIMRole Indicates the role of the party in an regulatory initial margin call instruction (i.e Pledgor party or Secured party).
 * @param baseCurrencyExposure Represents the current mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency), to be referenced in a margin call.
 * @param collateralPortfolio Represents attributes to define the details of collateral assets within a collateral portfolio to be used in margin call messaging and contribute to collateral balances e.g securities in a collateral account recorded by the principal as held or posted.
 * @param independentAmountBalance Represents additional credit support amount over and above mark to market value.
 * @param overallExposure Represents the whole overall mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency).
 * @param simmIMExposure Represents Initial Margin (IM) exposure derived from ISDA SIMM calculation.
 * @param scheduleGridIMExposure Represents Initial Margin (IM) exposure derived from schedule or Grid calculation.
 */
@Serializable
open class MarginCallExposure (
  var overallExposure: Exposure? = null,
  var simmIMExposure: Exposure? = null,
  var scheduleGridIMExposure: Exposure? = null
)
: MarginCallBase()

/**
 * Represents enumeration values to specify the call notification type, direction, specific action type.
 *
 * @param callType Indicates the status of the call message type, such as expected call, notification of a call or an actionable margin call.
 * @param visibilityIndicator Indicates the choice if the call instruction is visible or not to the other party.
 */
@Serializable
open class MarginCallInstructionType (
  var callType: CallTypeEnum? = null,
  var visibilityIndicator: Boolean? = null
)

/**
 * Represents common attributes required for a Margin Call Issuance under a legal agreement such as a credit support document or equivalent.
 *
 * @param instructionType Identifies the enumeration values to specify the call notification type, direction, specific action type.
 * @param party Represents the parties to the margin call. The cardinality is optional to address the case where both parties of the event are specified and a third party if applicable.
 * @param partyRole Represents the role each specified party takes in the margin call. further to the principal roles, payer and receiver.
 * @param clearingBroker Indicates the name of the Clearing Broker FCM/DCM.
 * @param callIdentifier Represents a unique Identifier for a margin call message, that can be referenced throughout all points of the process.
 * @param callAgreementType Specifies the legal agreement type the margin call is generated from and governed by.
 * @param agreementMinimumTransferAmount Specifies the collateral legal agreement minimum transfer amount in base currency.
 * @param agreementThreshold Specifies the collateral legal agreement threshold amount in base currency.
 * @param agreementRounding Specifies the collateral legal agreement rounding in base currency.
 * @param regMarginType Identifies margin type and if related regulatory mandate
 * @param regIMRole Indicates the role of the party in an regulatory initial margin call instruction (i.e Pledgor party or Secured party).
 * @param baseCurrencyExposure Represents the current mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency), to be referenced in a margin call.
 * @param collateralPortfolio Represents attributes to define the details of collateral assets within a collateral portfolio to be used in margin call messaging and contribute to collateral balances e.g securities in a collateral account recorded by the principal as held or posted.
 * @param independentAmountBalance Represents additional credit support amount over and above mark to market value.
 * @param callAmountInBaseCurrency Specifies the amount of margin being called for which accounts for margin calculation inclusive of exposure, independent amount,threshold,collateral balance, MTA, rounding increments (in base currency detailed in supporting collateral agreement).
 * @param recallNonCashCollateralDescription Specifies the details to describe or identify non-cash collateral eligible assets for recall purposes.
 */
@Serializable
open class MarginCallIssuance (
  var callAmountInBaseCurrency: Money? = null,
  var recallNonCashCollateralDescription: MutableList<EligibleCollateralCriteria>? = null
)
: MarginCallBase()

/**
 * Represents common attributes required for a Margin Call Response under a legal agreement such as a credit support document or equivalent.
 *
 * @param instructionType Identifies the enumeration values to specify the call notification type, direction, specific action type.
 * @param party Represents the parties to the margin call. The cardinality is optional to address the case where both parties of the event are specified and a third party if applicable.
 * @param partyRole Represents the role each specified party takes in the margin call. further to the principal roles, payer and receiver.
 * @param clearingBroker Indicates the name of the Clearing Broker FCM/DCM.
 * @param callIdentifier Represents a unique Identifier for a margin call message, that can be referenced throughout all points of the process.
 * @param callAgreementType Specifies the legal agreement type the margin call is generated from and governed by.
 * @param agreementMinimumTransferAmount Specifies the collateral legal agreement minimum transfer amount in base currency.
 * @param agreementThreshold Specifies the collateral legal agreement threshold amount in base currency.
 * @param agreementRounding Specifies the collateral legal agreement rounding in base currency.
 * @param regMarginType Identifies margin type and if related regulatory mandate
 * @param regIMRole Indicates the role of the party in an regulatory initial margin call instruction (i.e Pledgor party or Secured party).
 * @param baseCurrencyExposure Represents the current mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency), to be referenced in a margin call.
 * @param collateralPortfolio Represents attributes to define the details of collateral assets within a collateral portfolio to be used in margin call messaging and contribute to collateral balances e.g securities in a collateral account recorded by the principal as held or posted.
 * @param independentAmountBalance Represents additional credit support amount over and above mark to market value.
 * @param marginCallResponseAction Specifies the margin call action details, including collateral to be moved and direction.
 * @param marginResponseType Indicates the response type, such as, is the margin call response a 'full' 'part' agreement or 'dispute'.
 * @param agreedAmountBaseCurrency Indicates the amount that posting entity agrees to remit in response to margin call (in base currency).
 */
@Serializable
open class MarginCallResponse (
  var marginCallResponseAction: MutableList<MarginCallResponseAction>? = null,
  var marginResponseType: MarginCallResponseTypeEnum? = null,
  var agreedAmountBaseCurrency: Money? = null
)
: MarginCallBase()

/**
 * Specifies the margin call action details, including collateral to be moved and its direction.
 *
 * @param collateralPositionComponent Specifies the collateral to be moved and its direction.
 * @param marginCallAction Specifies the margin call action details, specified as either Delivery or Return.
 */
@Serializable
open class MarginCallResponseAction (
  var collateralPositionComponent: MutableList<CollateralPosition>? = null,
  var marginCallAction: MarginCallActionEnum? = null
)

/**
 * Defines clauses that make up a Master Agreement
 *
 * @param identifer Unique identifier for the clause
 * @param name Optional textual description of the clause.
 * @param counterparty Optional counterparty role. This can be used where a clause needs to be assigned to a specific party on the agreement based upon their role i.e. Party A or Party B.
 * @param otherParty Optional party. This can be required for umbrella agreements where a clause may need to be assigned to a specific party who may or may not be on the agreement.
 * @param variant Allows multiple variants to be defined for a clause. This needs to be an array as some clauses can specify different variants for different parties. At least one variant must be specified for a clause.
 */
@Serializable
open class MasterAgreementClause (
  var identifer: MasterAgreementClauseIdentifierEnum? = null,
  var name: String? = null,
  var counterparty: MutableList<CounterpartyRoleEnum>? = null,
  var otherParty: MutableList<PartyRoleEnum>? = null,
  var variant: MutableList<MasterAgreementClauseVariant>? = null
)

/**
 * Sets the details for a specific variant associated to a clause in a Master Agreement
 *
 * @param identifier Unique identifier for this variant
 * @param name Optional textual description of the variant.
 * @param counterparty Optional counterparty role. This can be used where a clause needs to assign a different variant to the different parties on the agreement based upon their role i.e. Party A or Party B.
 * @param otherParty Optional party. This can be used where a clause needs to assign different variants to different parties who may or may not be on the agreement.
 * @param variableSet For some variants of some clauses additional details are required to work out what has been elected. This array can be used to define the name and value of these variables. Please refer to the agreement documentation for more details of the variables that are available for any clause.
 */
@Serializable
open class MasterAgreementClauseVariant (
  var identifier: MasterAgreementVariantIdentifierEnum? = null,
  var name: String? = null,
  var counterparty: MutableList<CounterpartyRoleEnum>? = null,
  var otherParty: MutableList<PartyRoleEnum>? = null,
  var variableSet: MutableList<MasterAgreementVariableSet>? = null
)

/**
 * The set of elections which specify a Master Agreement.
 *
 * @param clause Clauses that have had elections made against them in this Master Agreement. There must be at least one clause defined in the agreement.
 */
@Serializable
open class MasterAgreementSchedule (
  var clause: MutableList<MasterAgreementClause>? = null
)

/**
 * Defines a type where additional variables associated to clauses and their variants can be described.
 *
 * @param variableSet For some variants a table of variables is required. To support this use case we need to be able to specify variables within variables. Including a variable set here gives us infinite nesting opportunities - realistically we are only ever expecting that a table would need to be defined for any particular clause, so we would expect two levels of nesting as a maximum i.e. variableSet->variableSet->name/value.
 * @param name The name of the variable
 * @param value The value for this variable
 */
@Serializable
open class MasterAgreementVariableSet (
  var variableSet: MutableList<MasterAgreementVariableSet>? = null,
  var name: String? = null,
  var value: String? = null
)

/**
 * Legal agreement specification for General Terms and Elections that are applicable across multiple confirmations and are referenced by these confirmations.
 *
 */
@Serializable
open class MasterConfirmationBase (
)

/**
 * Defines a concrete measure as a number associated to a unit. It extends MeasureBase by requiring the value attribute to be present. A measure may be unit-less so the unit attribute is still optional.
 *
 * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
 * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
 */
@Serializable
open class Measure (
)
: MeasureBase()

/**
 * Provides an abstract type to define a measure as a number associated to a unit. This type is abstract because all its attributes are optional. The types that extend it can specify further existence constraints.
 *
 * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
 * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
 */
@Serializable
open class MeasureBase (
  var value: Float? = null,
  var unit: UnitType? = null
)

/**
 * A set of measures, all in the same unit, where the values are defined through a schedule of steps. The initial value may be defined either as part of the steps, or using the single amount attribute.
 *
 * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
 * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
 * @param datedValue A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
 */
@Serializable
open class MeasureSchedule (
  var datedValue: MutableList<DatedValue>? = null
)
: MeasureBase()

/**
 * This class corresponds to the components of the FpML MessageHeader.model.
 *
 * @param messageId A unique identifier assigned to the message.
 * @param sentBy The identifier for the originator of a message instance.
 * @param sentTo The identifier(s) for the recipient(s) of a message instance.
 * @param copyTo A unique identifier (within the specified coding scheme) giving the details of some party to whom a copy of this message will be sent for reference.
 */
@Serializable
open class MessageInformation (
  var messageId: FieldWithMetaString? = null,
  var sentBy: FieldWithMetaString? = null,
  var sentTo: MutableList<FieldWithMetaString>? = null,
  var copyTo: MutableList<FieldWithMetaString>? = null
)

/**
 * Defines a monetary amount in a specified currency.
 *
 * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
 * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
 * @param datedValue A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
 * @param multiplier Defines an optional number that the quantity should be multiplied by to derive a total quantity. This number is associated to a unit. For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unit would be contracts, the multiplier value would 1,000 and the mulitiplier unit would be 1,000 MT (Metric Tons).
 * @param frequency Defines the frequency to be used when defining a quantity. For example a quantity may be specified as a number of barrels of oil per day, which needs multiplying by the number of days in the relevant period to get the total quantity as a number of barrels.
 * @param meta 
 */
@Serializable
open class Money (
  var meta: MetaFields? = null
)
: Quantity()

/**
 * The money bound is defined as a money amount and whether the bound is inclusive.
 *
 * @param money The money amount to be used as the bound, e.g. 1,000 USD.
 * @param inclusive Whether the money amount bound is inclusive, e.g. for a lower bound, false would indicate greater than, whereas true would indicate greater than or equal to.
 */
@Serializable
open class MoneyBound (
  var money: Money? = null,
  var inclusive: Boolean? = null
)

/**
 * The money range defined as either a lower and upper money bound, or both.
 *
 * @param lowerBound The lower bound of a money range, e.g. greater than or equal to 1,000 USD.
 * @param upperBound The upper bound of a money range, e.g. less than 10,000 USD.
 */
@Serializable
open class MoneyRange (
  var lowerBound: MoneyBound? = null,
  var upperBound: MoneyBound? = null
)

/**
 * Represetns a class to specify multiple credit notations alongside a conditional 'any' or 'all' qualifier.
 *
 * @param condition An enumerated element, to qualify whether All or Any credit notation applies.
 * @param creditNotation At least two credit notations much be specified.
 * @param mismatchResolution 
 * @param referenceAgency 
 */
@Serializable
open class MultipleCreditNotations (
  var condition: QuantifierEnum? = null,
  var creditNotation: MutableList<FieldWithMetaCreditNotation>? = null,
  var mismatchResolution: CreditNotationMismatchResolutionEnum? = null,
  var referenceAgency: CreditRatingAgencyEnum? = null
)

/**
 * Represents a class to specify multiple credit debt types alongside a conditional 'any' or 'all' qualifier.
 *
 * @param condition An enumerated attribute, to qualify whether All or Any debt type applies.
 * @param debtType The type of debt, e.g. long term debt, deposit, ... FpML doesn't specific a scheme value, hence no enumeration is specified as part of the CDM. At least two debt types much be specified.
 */
@Serializable
open class MultipleDebtTypes (
  var condition: QuantifierEnum? = null,
  var debtType: MutableList<FieldWithMetaString>? = null
)

/**
 * A class defining multiple exercises. As defined in the 2000 ISDA Definitions, Section 12.4. Multiple Exercise, the buyer of the option has the right to exercise all or less than all the unexercised notional amount of the underlying swap on one or more days in the exercise period, but on any such day may not exercise less than the minimum notional amount or more than the maximum notional amount, and if an integral multiple amount is specified, the notional exercised must be equal to or, be an integral multiple of, the integral multiple amount. In FpML, MultipleExercise is built upon the PartialExercise.model.
 *
 * @param notionaReference A pointer style reference to the associated notional schedule defined elsewhere in the document. This element has been made optional as part of its integration in the OptionBaseExtended, because not required for the options on securities.
 * @param integralMultipleAmount A notional amount which restricts the amount of notional that can be exercised when partial exercise or multiple exercise is applicable. The integral multiple amount defines a lower limit of notional that can be exercised and also defines a unit multiple of notional that can be exercised, i.e. only integer multiples of this amount can be exercised.
 * @param minimumNotionalAmount The minimum notional amount that can be exercised on a given exercise date. See multipleExercise.
 * @param minimumNumberOfOptions The minimum number of options that can be exercised on a given exercise date.
 * @param maximumNotionalAmount The maximum notional amount that can be exercised on a given exercise date.
 * @param maximumNumberOfOptions The maximum number of options that can be exercised on a given exercise date. If the number is not specified, it means that the maximum number of options corresponds to the remaining unexercised options.
 */
@Serializable
open class MultipleExercise (
  var maximumNotionalAmount: Float? = null,
  var maximumNumberOfOptions: Int? = null
)
: PartialExercise()

@Serializable
open class MultipleValuationDates (
  var businessDaysThereafter: Int? = null,
  var numberValuationDates: Int? = null
)
: SingleValuationDate()

/**
 * A class to represent the attributes that are specific to a natural person.
 *
 * @param personId The identifier associated with a person, e.g. the internal identification code.
 * @param honorific An honorific title, such as Mr., Ms., Dr. etc.
 * @param firstName The natural person's first name. It is optional in FpML.
 * @param middleName The natural person's middle name(s). If a middle name is provided then an initial should be absent.
 * @param initial The natural person's middle initial(s). If a middle initial is provided then a name should be absent.
 * @param surname The natural person's surname.
 * @param suffix Name suffix, such as Jr., III, etc.
 * @param dateOfBirth The natural person's date of birth.
 * @param contactInformation The contact information for such person, when different from the contact information associated with the party.
 * @param meta 
 */
@Serializable
open class NaturalPerson (
  var personId: MutableList<FieldWithMetaPersonIdentifier>? = null,
  var honorific: String? = null,
  var firstName: String? = null,
  var middleName: MutableList<String>? = null,
  var initial: MutableList<String>? = null,
  var surname: String? = null,
  var suffix: String? = null,
  var dateOfBirth: Date? = null,
  var contactInformation: ContactInformation? = null,
  var meta: MetaFields? = null
)

/**
 * A class to specify the role(s) that natural person(s) may have in relation to the contract.
 *
 * @param personReference A reference to the natural person to whom the role refers to.
 * @param role FpML specifies a person role that is distinct from the party role.
 */
@Serializable
open class NaturalPersonRole (
  var personReference: ReferenceWithMetaNaturalPerson? = null,
  var role: MutableList<FieldWithMetaNaturalPersonRoleEnum>? = null
)

/**
 * Used to apply a NOT logic condition to a single Collateral Criteria.
 *
 * @param negativeCriteria 
 */
@Serializable
open class NegativeCriteria (
  var negativeCriteria: CollateralCriteria? = null
)

@Serializable
open class New (
  var txId: String? = null,
  var exctgPty: String? = null,
  var invstmtPtyInd: String? = null,
  var submitgPty: String? = null,
  var buyr: Buyr? = null,
  var sellr: Sellr? = null,
  var ordrTrnsmssn: OrdrTrnsmssn? = null,
  var tx: Tx? = null,
  var finInstrm: FinInstrm? = null,
  var invstmtDcsnPrsn: InvstmtDcsnPrsn? = null,
  var exctgPrsn: ExctgPrsn? = null,
  var addtlAttrbts: AddtlAttrbts? = null
)

@Serializable
open class Nm (
  var refRate: RefRate? = null,
  var term: Term? = null
)

/**
 * Specifies a quantity as a non-negative number, which condition is enforced through a data rule that only applies to the extending class.
 *
 * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
 * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
 * @param datedValue A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
 * @param multiplier Defines an optional number that the quantity should be multiplied by to derive a total quantity. This number is associated to a unit. For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unit would be contracts, the multiplier value would 1,000 and the mulitiplier unit would be 1,000 MT (Metric Tons).
 * @param frequency Defines the frequency to be used when defining a quantity. For example a quantity may be specified as a number of barrels of oil per day, which needs multiplying by the number of days in the relevant period to get the total quantity as a number of barrels.
 */
@Serializable
open class NonNegativeQuantity (
)
: Quantity()

@Serializable
open class NonNegativeQuantitySchedule (
)
: QuantitySchedule()

/**
 * A class defining a step date and non-negative step value pair. This step definitions are used to define varying rate or amount schedules, e.g. a notional amortisation or a step-up coupon schedule.
 *
 * @param stepDate The date on which the associated stepValue becomes effective. This day may be subject to adjustment in accordance with a business day convention.
 * @param stepValue The non-negative rate or amount which becomes effective on the associated stepDate. A rate of 5% would be represented as 0.05.
 * @param meta 
 */
@Serializable
open class NonNegativeStep (
  var stepDate: Date? = null,
  var stepValue: Float? = null,
  var meta: MetaFields? = null
)

/**
 * A data type to specify the financial product's economic terms, alongside the product identification and product taxonomy. The non-transferable product data type represents a product that can be traded (as part of a TradableProduct) but cannot be transferred to others.  It is meant to be used across the pre-execution, execution and (as part of the Contract) post-execution lifecycle contexts.
 *
 * @param identifier Comprises a identifier and a source to uniquely identify the nonTransferableProduct. 
 * @param taxonomy Specifies the product taxonomy, which is composed of a taxonomy value and a taxonomy source.
 * @param economicTerms The price forming features, including payouts and provisions.
 * @param meta 
 */
@Serializable
open class NonTransferableProduct (
  var identifier: MutableList<ProductIdentifier>? = null,
  var taxonomy: MutableList<ProductTaxonomy>? = null,
  var economicTerms: EconomicTerms? = null,
  var meta: MetaFields? = null
)

/**
 * A class to specify the ISDA 2003 Term: Not Domestic Currency.
 *
 * @param applicable Indicates whether the Not Domestic Currency provision is applicable.
 * @param currency An explicit specification of the domestic currency. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
 */
@Serializable
open class NotDomesticCurrency (
  var applicable: Boolean? = null,
  var currency: FieldWithMetaString? = null
)

/**
 * The number bound is defined as a number and whether the bound is inclusive.
 *
 * @param number The number to be used as the bound, e.g. 5.
 * @param inclusive Whether the number bound is inclusive, e.g. for a lower bound, false would indicate greater than, whereas true would indicate greater than or equal to.
 */
@Serializable
open class NumberBound (
  var number: Float? = null,
  var inclusive: Boolean? = null
)

/**
 * The number range defined as either a lower and upper number bound, or both.
 *
 * @param lowerBound The lower bound of a number range, e.g. greater than or equal to 5.
 * @param upperBound The upper bound of a number range, e.g. less than 10.
 */
@Serializable
open class NumberRange (
  var lowerBound: NumberBound? = null,
  var upperBound: NumberBound? = null
)

/**
 * A class to specify the underlying obligations of the reference entity on which protection is purchased or sold through the Credit Default Swap.
 *
 * @param category Used in both obligations and deliverable obligations to represent a class or type of securities which apply. ISDA 2003 Term: Obligation Category/Deliverable Obligation Category.
 * @param notSubordinated An obligation and deliverable obligation characteristic. An obligation that ranks at least equal with the most senior Reference Obligation in priority of payment or, if no Reference Obligation is specified in the related Confirmation, the obligations of the Reference Entity that are senior. ISDA 2003 Term: Not Subordinated.
 * @param specifiedCurrency An obligation and deliverable obligation characteristic. The currency or currencies in which an obligation or deliverable obligation must be payable. ISDA 2003 Term: Specified Currency.
 * @param notSovereignLender An obligation and deliverable obligation characteristic. Any obligation that is not primarily (majority) owed to a Sovereign or Supranational Organisation. ISDA 2003 Term: Not Sovereign Lender.
 * @param notDomesticCurrency An obligation and deliverable obligation characteristic. Any obligation that is payable in any currency other than the domestic currency. Domestic currency is either the currency so specified or, if no currency is specified, the currency of (a) the reference entity, if the reference entity is a sovereign, or (b) the jurisdiction in which the relevant reference entity is organised, if the reference entity is not a sovereign. ISDA 2003 Term: Not Domestic Currency.
 * @param notDomesticLaw An obligation and deliverable obligation characteristic. If the reference entity is a Sovereign, this means any obligation that is not subject to the laws of the reference entity. If the reference entity is not a sovereign, this means any obligation that is not subject to the laws of the jurisdiction of the reference entity. ISDA 2003 Term: Not Domestic Law.
 * @param listed An obligation and deliverable obligation characteristic. Indicates whether or not the obligation is quoted, listed or ordinarily purchased and sold on an exchange. ISDA 2003 Term: Listed.
 * @param notDomesticIssuance An obligation and deliverable obligation characteristic. Any obligation other than an obligation that was intended to be offered for sale primarily in the domestic market of the relevant Reference Entity. This specifies that the obligation must be an internationally recognised bond. ISDA 2003 Term: Not Domestic Issuance.
 * @param fullFaithAndCreditObLiability An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: Full Faith and Credit Obligation Liability.
 * @param generalFundObligationLiability An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: General Fund Obligation Liability.
 * @param revenueObligationLiability An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: Revenue Obligation Liability.
 * @param notContingent OTE: Only allowed as an obligation characteristic under ISDA Credit 1999. In essence Not Contingent means the repayment of principal cannot be dependent on a formula/index, i.e. to prevent the risk of being delivered an instrument that may never pay any element of principal, and to ensure that the obligation is interest bearing (on a regular schedule). ISDA 2003 Term: Not Contingent.
 * @param excluded A free format string to specify any excluded obligations or deliverable obligations, as the case may be, of the reference entity or excluded types of obligations or deliverable obligations. ISDA 2003 Term: Excluded Obligations/Excluded Deliverable Obligations.
 * @param othReferenceEntityObligations This element is used to specify any other obligations of a reference entity in both obligations and deliverable obligations. The obligations can be specified free-form. ISDA 2003 Term: Other Obligations of a Reference Entity.
 * @param designatedPriority Applies to Loan CDS, to indicate what lien level is appropriate for a deliverable obligation. Applies to European Loan CDS, to indicate the Ranking of the obligation. Example: a 2nd lien Loan CDS would imply that the deliverable obligations are 1st or 2nd lien loans.
 * @param cashSettlementOnly An obligation and deliverable obligation characteristic. Defined in the ISDA published Standard Terms Supplement for use with CDS Transactions on Leveraged Loans. ISDA 2003 Term: Cash Settlement Only.
 * @param deliveryOfCommitments An obligation and deliverable obligation characteristic. Defined in the ISDA published Standard Terms Supplement for use with CDS Transactions on Leveraged Loans. ISDA 2003 Term: Delivery of Commitments.
 * @param continuity An obligation and deliverable obligation characteristic. Defined in the ISDA published Standard Terms Supplement for use with CDS Transactions on Leveraged Loans. ISDA 2003 Term: Continuity.
 */
@Serializable
open class Obligations (
  var category: ObligationCategoryEnum? = null,
  var notSubordinated: Boolean? = null,
  var specifiedCurrency: SpecifiedCurrency? = null,
  var notSovereignLender: Boolean? = null,
  var notDomesticCurrency: NotDomesticCurrency? = null,
  var notDomesticLaw: Boolean? = null,
  var listed: Boolean? = null,
  var notDomesticIssuance: Boolean? = null,
  var fullFaithAndCreditObLiability: Boolean? = null,
  var generalFundObligationLiability: Boolean? = null,
  var revenueObligationLiability: Boolean? = null,
  var notContingent: Boolean? = null,
  var excluded: String? = null,
  var othReferenceEntityObligations: String? = null,
  var designatedPriority: FieldWithMetaString? = null,
  var cashSettlementOnly: Boolean? = null,
  var deliveryOfCommitments: Boolean? = null,
  var continuity: Boolean? = null
)

/**
 * Specifies the object to be observed for a price, it could be an asset or a reference.
 *
 * @param Asset The object to be observed is an Asset, ie something that can be owned and transferred in the financial markets.
 * @param Basket The object to be observed is a Basket, ie a collection of Observables with an identifier and optional weightings.
 * @param Index The object to be observed is an Index, ie an observable computed on the prices, rates or valuations of a number of assets.
 */
@Serializable
open class Observable (
  var asset: Asset? = null,
  var basket: Basket? = null,
  var index: Index? = null
)

/**
 * Defines a single, numerical value that was observed in the marketplace. Observations of market data are made independently to business events or trade life-cycle events, so data instances of Observation can be created independently of any other model type, hence it is annotated as a root type. Observations will be broadly reused in many situations, so references to Observation are supported via the 'key' annotation.
 *
 * @param observedValue Specifies the observed value as a number.
 * @param observationIdentifier Represents the observation was made i.e. how to uniquely identify the observed value among the population of all available market data.
 * @param meta 
 */
@Serializable
open class Observation (
  var observedValue: Price? = null,
  var observationIdentifier: ObservationIdentifier? = null,
  var meta: MetaFields? = null
)

/**
 * Specifies a single date on which market observations take place and specifies optional associated weighting.
 *
 * @param unadjustedDate A date subject to adjustment.
 * @param adjustedDate The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
 * @param weight Specifies the degree of importance of the observation.
 * @param observationReference Specifies an identification key for the market observation. This attribute can be used as a reference to assign weights to a series of dates defined in a parametricSchedule.
 * @param meta 
 */
@Serializable
open class ObservationDate (
  var unadjustedDate: Date? = null,
  var adjustedDate: Date? = null,
  var weight: Float? = null,
  var observationReference: String? = null,
  var meta: MetaFields? = null
)

/**
 * Describes date details for a set of observation dates in parametric or non-parametric form.
 *
 * @param observationSchedule Specifies a schedule of dates (non-parametric) on which market observations take place, and allows for the optional definition of weights where applicable.  When no weight is specified, then weight of each date is assumed to be 1.0
 * @param periodicSchedule Specifies the date range and frequency on which market observations take place.  Weights can be assigned to dates in the schedule by assigning the weight and corresponding observationReference in the observationSchedule.
 * @param parametricDates Specifies parametric terms to determine which days within a given calculation period the price would be observed. Typically associated with Commodities. 
 */
@Serializable
open class ObservationDates (
  var observationSchedule: ObservationSchedule? = null,
  var periodicSchedule: PeriodicDates? = null,
  var parametricDates: ParametricDates? = null
)

/**
 * Specifies the necessary information to create any observation event.
 *
 * @param creditEvent Specifies the necessary information to create a credit event.
 * @param corporateAction Specifies the necessary information to create a corporate action.
 */
@Serializable
open class ObservationEvent (
  var creditEvent: CreditEvent? = null,
  var corporateAction: CorporateAction? = null
)

/**
 * Defines the parameters needed to uniquely identify a piece of data among the population of all available market data.
 *
 * @param observable Represents the asset or rate to which the observation relates.
 * @param observationDate Specifies the date value to use when resolving the market data.
 * @param observationTime Represents the time and time-zone.
 * @param informationSource Represents where the market data published and should be observed.
 * @param determinationMethodology Specifies the method according to which an amount or a date is determined.
 */
@Serializable
open class ObservationIdentifier (
  var observable: Observable? = null,
  var observationDate: Date? = null,
  var observationTime: TimeZone? = null,
  var informationSource: InformationSource? = null,
  var determinationMethodology: DeterminationMethodology? = null
)

/**
 * Specifies inputs needed to process an observation.
 *
 * @param observationEvent Contains all information related to an observation.
 */
@Serializable
open class ObservationInstruction (
  var observationEvent: ObservationEvent? = null
)

/**
 * Parameters on daily observed computed rates, specifically daily caps and floors. This type is used to represent modular computed rates in interestRatePayouts.
 *
 * @param observationCapRate A daily observation cap rate.
 * @param observationFloorRate A daily observation floor rate.
 */
@Serializable
open class ObservationParameters (
  var observationCapRate: Float? = null,
  var observationFloorRate: Float? = null
)

/**
 * Specifies a single date on which market observations take place and specifies optional associated weighting.
 *
 * @param observationDate Specifies an adjusted or unadjusted date for a market observation.
 * @param dateAdjustments The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
 */
@Serializable
open class ObservationSchedule (
  var observationDate: MutableList<ObservationDate>? = null,
  var dateAdjustments: BusinessDayAdjustments? = null
)

/**
 * Parameters to describe the observation shift for a daily compounded or averaged floating rate. This type is used to represent modular computed rates in interestRatePayouts.
 *
 * @param offsetDays The number of days of observation shift.
 * @param calculationBase Whether the rate is calculated in advance, in arrears, or relative to a reset date.
 * @param additionalBusinessDays Any additional business days that be applicable.
 */
@Serializable
open class ObservationShiftCalculation (
  var offsetDays: Int? = null,
  var calculationBase: ObservationPeriodDatesEnum? = null,
  var additionalBusinessDays: BusinessCenters? = null
)

/**
 * Class containing terms that are associated with observing a price/benchmark/index across either single or multiple observations. 
 *
 * @param observationTime Defines time in respect to a business calendar location that the price/benchmark/index is observed
 * @param observationTimeType The enumerated values to specify points in the day when option exercise and valuation can occur.
 * @param informationSource The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
 * @param precision Defines rounding rules and precision to be used in the rounding of observations.
 * @param calculationPeriodDates Defines parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods. A calculation period schedule consists of an optional initial stub calculation period, one or more regular calculation periods and an optional final stub calculation period. In the absence of any initial or final stub calculation periods, the regular part of the calculation period schedule is assumed to be between the effective date and the termination date. No implicit stubs are allowed, i.e. stubs must be explicitly specified using an appropriate combination of firstPeriodStartDate, firstRegularPeriodStartDate and lastRegularPeriodEndDate.
 * @param observationDates Describes date details for a set of observation dates in parametric or non-parametric form.
 * @param numberOfObservationDates The number of observation dates between observation start date and observation end date.
 */
@Serializable
open class ObservationTerms (
  var observationTime: BusinessCenterTime? = null,
  var observationTimeType: TimeTypeEnum? = null,
  var informationSource: FxSpotRateSource? = null,
  var precision: Rounding? = null,
  var calculationPeriodDates: CalculationPeriodDates? = null,
  var observationDates: ObservationDates? = null,
  var numberOfObservationDates: Int? = null
)

/**
 * A class defining an offset used in calculating a new date relative to a reference date, e.g. calendar days, business days, commodity Business days, etc.
 *
 * @param periodMultiplier A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
 * @param period A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
 * @param meta 
 * @param dayType In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
 */
@Serializable
open class Offset (
  var dayType: DayTypeEnum? = null
)
: Period()

/**
 * Defines business day shifts for daily componded or averaged rates.  This type is used for lookback and lockout rates. This type is used to represent modular computed rates in interestRatePayouts.
 *
 * @param offsetDays The number of business days offset.
 */
@Serializable
open class OffsetCalculation (
  var offsetDays: Int? = null
)

/**
 * Defines additional optional features that can be included in an option contract.
 *
 * @param fxFeature Describes a quanto or composite FX feature.
 * @param strategyFeature Defines a simple strategy feature.
 * @param averagingFeature Defines an option feature in which an average market observation price is determined on valuation and compared to the strike to determine a settlement amount.
 * @param barrier Specifies a barrier feature.
 * @param knock Specifies a knock in or knock out feature.
 * @param passThrough Specifies the rules for pass-through payments from the underlier, such as dividends.
 */
@Serializable
open class OptionFeature (
  var fxFeature: MutableList<FxFeature>? = null,
  var strategyFeature: StrategyFeature? = null,
  var averagingFeature: AveragingCalculation? = null,
  var barrier: Barrier? = null,
  var knock: Knock? = null,
  var passThrough: PassThrough? = null
)

/**
 *  The option payout specification terms. The associated globalKey denotes the ability to associate a hash value to the respective OptionPayout instantiation for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 *
 * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
 * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
 * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
 * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
 * @param buyerSeller 
 * @param feature The option feature, such as quanto, Asian, barrier, knock.
 * @param observationTerms Class containing terms that are associated with observing a price/benchmark/index across either single or multple observations. To be used for option contracts that reference a benchmark price.
 * @param schedule Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
 * @param delivery Contains the information relative to the delivery of the asset.
 * @param underlier The financial product underlying the option, which can be of any type including an Asset, Basket, Index or a NonTransferableProduct.
 * @param optionType The type of option transaction. From a usage standpoint, put/call is the default option type, while payer/receiver indicator is used for options on index credit default swaps, consistently with the industry practice. Straddle is used for the case of straddle strategy, that combine a call and a put with the same strike.
 * @param exerciseTerms The terms for exercising the option, which include the option style (e.g. American style option), the exercise procedure (e.g. manual exercise) and the settlement terms (e.g. physical vs. cash).
 * @param strike Specifies the strike of the option
 */
@Serializable
open class OptionPayout (
  var buyerSeller: BuyerSeller? = null,
  var feature: OptionFeature? = null,
  var observationTerms: ObservationTerms? = null,
  var schedule: CalculationSchedule? = null,
  var delivery: AssetDeliveryInformation? = null,
  var underlier: Underlier? = null,
  var optionType: OptionTypeEnum? = null,
  var exerciseTerms: ExerciseTerms? = null,
  var strike: OptionStrike? = null
)
: PayoutBase()

/**
 * Defines the strike price of an option.
 *
 * @param strikePrice Defines the strike of an option in the form of a price that could be a cash price, interestRate, or other types.
 * @param strikeReference Defines the strike of an option in reference to the spread of the underlying swap (typical practice in the case of an option on a credit single name swaps).
 * @param referenceSwapCurve Defines the strike of an option when expressed by reference to a swap curve (Typically the case for a convertible bond option).
 * @param averagingStrikeFeature Defines an  option strike that is calculated from an average of observed market prices.
 */
@Serializable
open class OptionStrike (
  var strikePrice: Price? = null,
  var strikeReference: ReferenceWithMetaFixedRateSpecification? = null,
  var referenceSwapCurve: ReferenceSwapCurve? = null,
  var averagingStrikeFeature: AveragingStrikeFeature? = null
)

/**
 * A data defining:  an early termination provision where either or both parties have the right to exercise.
 *
 * @param singlePartyOption If optional early termination is not available to both parties then this component specifies the buyer and seller of the option. In FpML, this attribute is of type SinglePsrtyOption, which actually consists of the BuyerSeller.model.
 * @param mutualEarlyTermination Used for specifying whether the Mutual Early Termination Right that is detailed in the Master Confirmation will apply.
 * @param exerciseNotice Definition of the party to whom notice of exercise should be given.
 * @param followUpConfirmation A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller's agent.
 * @param calculationAgent The ISDA Calculation Agent responsible for performing duties associated with an optional early termination.
 * @param cashSettlement If specified, this means that cash settlement is applicable to the transaction and defines the parameters associated with the cash settlement procedure. If not specified, then physical settlement is applicable.
 * @param optionalEarlyTerminationAdjustedDates An early termination provision to terminate the trade at fair value where one or both parties have the right to decide on termination.
 * @param exerciseTerms The exercise terms associated with the optional early termination, including details such as exercise style, exercise fees, and any other relevant conditions or terms.
 */
@Serializable
open class OptionalEarlyTermination (
  var singlePartyOption: BuyerSeller? = null,
  var mutualEarlyTermination: Boolean? = null,
  var exerciseNotice: MutableList<ExerciseNotice>? = null,
  var followUpConfirmation: Boolean? = null,
  var calculationAgent: CalculationAgent? = null,
  var cashSettlement: SettlementTerms? = null,
  var optionalEarlyTerminationAdjustedDates: OptionalEarlyTerminationAdjustedDates? = null,
  var exerciseTerms: ExerciseTerms? = null
)

/**
 * A data defining:  the adjusted dates associated with an optional early termination provision.
 *
 * @param earlyTerminationEvent The adjusted dates associated with an individual early termination date.
 */
@Serializable
open class OptionalEarlyTerminationAdjustedDates (
  var earlyTerminationEvent: MutableList<EarlyTerminationEvent>? = null
)

@Serializable
open class OrdrTrnsmssn (
  var trnsmssnInd: String? = null
)

/**
 * A class for defining an agreement executed between parties.
 *
 * @param identifier An identifier that has been created to identify the agreement.
 * @param otherAgreementType The agreement executed between the parties and intended to govern product-specific derivatives transactions between those parties.
 * @param version The version of the agreement.
 * @param date The date on which the agreement was signed.
 */
@Serializable
open class OtherAgreement (
  var identifier: FieldWithMetaString? = null,
  var otherAgreementType: FieldWithMetaString? = null,
  var version: FieldWithMetaString? = null,
  var date: Date? = null
)

/**
 * A class to specify a related legal agreement. For example, ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (s): Other CSA and Japanese Law CSA (VM). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (o): Other CSA.
 *
 * @param isSpecified The qualification of whether some other related agreement is specified (True) or not (False).
 * @param legalDocument The specification of this other agreement, when the qualification is True.
 */
@Serializable
open class OtherAgreementTerms (
  var isSpecified: Boolean? = null,
  var legalDocument: String? = null
)

/**
 * Specification of a user-defined index that does not meet the criteria of other Index data types.
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 * @param name A description of the Index.
 * @param provider The organisation that creates or maintains the Index.
 * @param assetClass The Asset Class of the Index.
 * @param description A description that defines the OtherIndex.
 */
@Serializable
open class OtherIndex (
  var description: String? = null
)
: IndexBase()

@Serializable
open class Othr (
  var finInstrmGnlAttrbts: FinInstrmGnlAttrbts? = null,
  var derivInstrmAttrbts: DerivInstrmAttrbts? = null,
  var id: String? = null,
  var schmeNm: SchmeNm? = null
)

/**
 * A class to specify the Partial Cash Deliverable Obligation Characteristic.
 *
 * @param applicable Indicates whether the provision is applicable.
 * @param partialCashSettlement Specifies whether either 'Partial Cash Settlement of Assignable Loans', 'Partial Cash Settlement of Consent Required Loans' or 'Partial Cash Settlement of Participations' is applicable. If this element is specified and Assignable Loan is a Deliverable Obligation Characteristic, any Assignable Loan that is deliverable, but where a non-receipt of Consent by the Physical Settlement Date has occurred, the Loan can be cash settled rather than physically delivered. If this element is specified and Consent Required Loan is a Deliverable Obligation Characteristic, any Consent Required Loan that is deliverable, but where a non-receipt of Consent by the Physical Settlement Date has occurred, the Loan can be cash settled rather than physically delivered. If this element is specified and Direct Loan Participation is a Deliverable Obligation Characteristic, any Participation that is deliverable, but where this participation has not been effected (has not come into effect) by the Physical Settlement Date, the participation can be cash settled rather than physically delivered.
 */
@Serializable
open class PCDeliverableObligationCharac (
  var applicable: Boolean? = null,
  var partialCashSettlement: Boolean? = null
)

/**
 * Defines rules for the dates on which the price will be determined.
 *
 * @param dayType Denotes the enumerated values to specify the day type classification used in counting the number of days between two dates.
 * @param dayDistribution Denotes the method by which the pricing days are distributed across the pricing period.
 * @param dayOfWeek Indicates the days of the week on which the price will be determined.
 * @param dayFrequency Defines the occurrence of the dayOfWeek within the pricing period on which pricing will take place, e.g. the 3rd Friday within each Calculation Period. If omitted, every dayOfWeek will be a pricing day.
 * @param lag The pricing period per calculation period if the pricing days do not wholly fall within the respective calculation period.
 * @param businessCenters The enumerated values to specify the business centers.
 */
@Serializable
open class ParametricDates (
  var dayType: DayTypeEnum? = null,
  var dayDistribution: DayDistributionEnum? = null,
  var dayOfWeek: MutableList<DayOfWeekEnum>? = null,
  var dayFrequency: Float? = null,
  var lag: Lag? = null,
  var businessCenters: BusinessCenters? = null
)

/**
 * A class defining partial exercise. As defined in the 2000 ISDA Definitions, Section 12.3 Partial Exercise, the buyer of the option may exercise all or less than all the notional amount of the underlying swap but may not be less than the minimum notional amount (if specified) and must be an integral multiple of the integral multiple amount if specified.
 *
 * @param notionaReference A pointer style reference to the associated notional schedule defined elsewhere in the document. This element has been made optional as part of its integration in the OptionBaseExtended, because not required for the options on securities.
 * @param integralMultipleAmount A notional amount which restricts the amount of notional that can be exercised when partial exercise or multiple exercise is applicable. The integral multiple amount defines a lower limit of notional that can be exercised and also defines a unit multiple of notional that can be exercised, i.e. only integer multiples of this amount can be exercised.
 * @param minimumNotionalAmount The minimum notional amount that can be exercised on a given exercise date. See multipleExercise.
 * @param minimumNumberOfOptions The minimum number of options that can be exercised on a given exercise date.
 */
@Serializable
open class PartialExercise (
  var notionaReference: ReferenceWithMetaMoney? = null,
  var integralMultipleAmount: Float? = null,
  var minimumNotionalAmount: Float? = null,
  var minimumNumberOfOptions: Int? = null
)

/**
 * A class to specify a party, without a qualification as to whether this party is a legal entity or a natural person, although the model provides the ability to associate a person (or set of persons) to a party, which use case would imply that such party would be a legal entity (even if not formally specified as such). 
 *
 * @param partyId The identifier associated with a party, e.g. the 20 digits LEI code.
 * @param name The party name.
 * @param businessUnit Optional organization unit information used to describe the organization units (e.g. trading desks) involved in a transaction or business process, incl. the contact information (when relevant).
 * @param person The person(s) who might be associated with the party as part of the execution, contract or legal document.
 * @param personRole The role of the person(s) 
 * @param account The account that might be associated with the party. At most one account can be specified, as it is expected that this information is used in the context of a contract or legal document where only one account per party can be associated with such object.
 * @param contactInformation The postal/street address, telephone number, email address and/or web page. If the contact information is specific to the associated business unit(s) or person (s), it should be associated with those.
 * @param meta 
 */
@Serializable
open class Party (
  var partyId: MutableList<PartyIdentifier>? = null,
  var name: FieldWithMetaString? = null,
  var businessUnit: MutableList<BusinessUnit>? = null,
  var person: MutableList<NaturalPerson>? = null,
  var personRole: MutableList<NaturalPersonRole>? = null,
  var account: Account? = null,
  var contactInformation: ContactInformation? = null,
  var meta: MetaFields? = null
)

/**
 * Specifies instruction to change the party on a trade. This primitive instruction is used in a number of scenarios including: clearing, allocation and novation. The instrution must include a trade identifier, because a change of party effectively results in a different trade.
 *
 * @param counterparty The new counterparty who is stepping into the trade. The stepping out counterparty is inferred based on the counterparty role that is being updated.
 * @param ancillaryParty Specifies an ancillary party to be added onto the new transaction, e.g. the original executing party in an allocation.
 * @param partyRole Specifies an additional party roles to be added on to the new transaction.
 * @param tradeId The identifier to be assigned to the new trade post change of party.
 */
@Serializable
open class PartyChangeInstruction (
  var counterparty: Counterparty? = null,
  var ancillaryParty: AncillaryParty? = null,
  var partyRole: PartyRole? = null,
  var tradeId: MutableList<TradeIdentifier>? = null
)

/**
 * A class to specify contact information within a party: address and, optionally, associated business unit and person. This class also supports the ISDA CSA representation as a single string, through the address attribute.
 *
 * @param partyReference The reference to the party to which the contact information refers to.
 * @param contactInformation The postal/street address, telephone number, email address and/or web page. If the contact information is specific to the associated business unit(s), it should be associated with those.
 * @param businessUnit Optional organization unit information used to describe the organization units (e.g. trading desks) involved in a transaction or business process, incl. the contact information (when relevant).
 * @param person Optional information about people involved in a transaction or business process. (These are employees of the party.)
 * @param additionalInformation Specification of special instructions of the relevant party.
 */
@Serializable
open class PartyContactInformation (
  var partyReference: ReferenceWithMetaParty? = null,
  var contactInformation: ContactInformation? = null,
  var businessUnit: MutableList<BusinessUnit>? = null,
  var person: MutableList<NaturalPerson>? = null,
  var additionalInformation: String? = null
)

/**
 * A class to specify a party-related, non-standardized data in a generic form.
 *
 * @param partyReference Reference to the party to which the workflow pertains to.
 * @param partyName The party name to which the workflow pertains to.
 * @param customisedWorkflow Non-standardized data in a generic form.
 */
@Serializable
open class PartyCustomisedWorkflow (
  var partyReference: ReferenceWithMetaParty? = null,
  var partyName: String? = null,
  var customisedWorkflow: MutableList<CustomisedWorkflow>? = null
)

/**
 * Comprises an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the PartyIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 *
 * @param identifier Provides an identifier associated with a party. The identifier is unique within the public source specified in the source attribute.
 * @param identifierType Defines the source of the identifier.
 * @param meta 
 */
@Serializable
open class PartyIdentifier (
  var identifier: FieldWithMetaString? = null,
  var identifierType: PartyIdentifierTypeEnum? = null,
  var meta: MetaFields? = null
)

/**
 * Specifies the parties responsible for making and receiving payments defined by this structure.
 *
 * @param payerPartyReference The party responsible for making the payments defined by this structure.
 * @param payerAccountReference A reference to the account responsible for making the payments defined by this structure.
 * @param receiverPartyReference The party that receives the payments corresponding to this structure.
 * @param receiverAccountReference A reference to the account that receives the payments corresponding to this structure.
 */
@Serializable
open class PartyReferencePayerReceiver (
  var payerPartyReference: ReferenceWithMetaParty? = null,
  var payerAccountReference: ReferenceWithMetaAccount? = null,
  var receiverPartyReference: ReferenceWithMetaParty? = null,
  var receiverAccountReference: ReferenceWithMetaAccount? = null
)

/**
 * A class to specify the role(s) that party(ies) may have in relation to the execution, contract or other legal agreement.
 *
 * @param partyReference A reference to the party to which the role refers to.
 * @param role The party role.
 * @param ownershipPartyReference A reference to the party that has ownership of this party role information. FpML specifies that For shared trade information, this attribute will reference the originator of the data (for example, an execution facility or clearing house).
 */
@Serializable
open class PartyRole (
  var partyReference: ReferenceWithMetaParty? = null,
  var role: PartyRoleEnum? = null,
  var ownershipPartyReference: ReferenceWithMetaParty? = null
)

/**
 * Type which contains pass through payments.
 *
 * @param passThroughItem One to many pass through payment items.
 */
@Serializable
open class PassThrough (
  var passThroughItem: MutableList<PassThroughItem>? = null
)

/**
 * Class to represent a single pass through payment.
 *
 * @param payerReceiver This attribute doesn't exists in the FpML construct, which makes use of the PayerReceiver.model group.
 * @param passThroughPercentage Percentage of payments from the underlier which are passed through.
 */
@Serializable
open class PassThroughItem (
  var payerReceiver: PayerReceiver? = null,
  var passThroughPercentage: Float? = null
)

/**
 * Specifies the parties responsible for making and receiving payments defined by this structure.
 *
 * @param payer Specifies the counterparty responsible for making the payments defined by this structure.  The party is one of the two principal parties to the transaction.
 * @param receiver Specifies the party that receives the payments corresponding to this structure.  The party is one of the two counterparties to the transaction.
 */
@Serializable
open class PayerReceiver (
  var payer: CounterpartyRoleEnum? = null,
  var receiver: CounterpartyRoleEnum? = null
)

/**
 * A data defining:  the adjusted payment date and associated calculation period parameters required to calculate the actual or projected payment amount. This data forms:  part of the cashflow representation of a swap stream.
 *
 * @param unadjustedPaymentDate The unadjusted payment date.
 * @param adjustedPaymentDate The adjusted payment date. This date should already be adjusted for any applicable business day convention. This component is not intended for use in trade confirmation but may be specified to allow the fee structure to also serve as a cashflow type component.
 * @param calculationPeriod The parameters used in the calculation of a fixed or floating rate calculation period amount. A list of calculation period elements may be ordered in the document by ascending start date. An FpML document which contains an unordered list of calculation periods is still regarded as a conformant document.
 * @param fixedPaymentAmount A known fixed payment amount.
 * @param discountFactor A decimal value representing the discount factor used to calculate the present value of cash flow.
 * @param forecastPaymentAmount A monetary amount representing the forecast of the future value of the payment.
 * @param presentValueAmount A monetary amount representing the present value of the forecast payment.
 * @param meta 
 */
@Serializable
open class PaymentCalculationPeriod (
  var unadjustedPaymentDate: Date? = null,
  var adjustedPaymentDate: Date? = null,
  var calculationPeriod: MutableList<CalculationPeriod>? = null,
  var fixedPaymentAmount: Money? = null,
  var discountFactor: Float? = null,
  var forecastPaymentAmount: Money? = null,
  var presentValueAmount: Money? = null,
  var meta: MetaFields? = null
)

/**
 * The payment dates when specified as relative to a set of dates specified somewhere else in the instance document/transaction, e.g. the valuation dates as typically the case for equity swaps, or when specified as a calculation period schedule.
 *
 * @param interimPaymentDates 
 * @param finalPaymentDate The last payment when specified as an adjustable or relative date, as in the FpML total return construct.
 */
@Serializable
open class PaymentDateSchedule (
  var interimPaymentDates: MutableList<AdjustableRelativeOrPeriodicDates>? = null,
  var finalPaymentDate: AdjustableOrRelativeDate? = null
)

/**
 * Specifies the parameters to generate the payment date schedule, either through a parametric representation or by reference to specified dates.
 *
 * @param paymentFrequency The frequency at which regular payment dates occur. If the payment frequency is equal to the frequency defined in the calculation period dates component then one calculation period contributes to each payment amount. If the payment frequency is less frequent than the frequency defined in the calculation period dates component then more than one calculation period will contribute to the payment amount. A payment frequency more frequent than the calculation period frequency or one that is not a multiple of the calculation period frequency is invalid. If the payment frequency is of value T (term), the period is defined by the effectiveDate and the terminationDate.
 * @param firstPaymentDate The first unadjusted payment date. This day may be subject to adjustment in accordance with any business day convention specified in paymentDatesAdjustments. This element must only be included if there is an initial stub. This date will normally correspond to an unadjusted calculation period start or end date. This is true even if early or delayed payment is specified to be applicable since the actual first payment date will be the specified number of days before or after the applicable adjusted calculation period start or end date with the resulting payment date then being adjusted in accordance with any business day convention specified in paymentDatesAdjustments.
 * @param lastRegularPaymentDate The last regular payment date when specified as a date, as in the FpML interest rate construct. FpML specifies that this date may be subject to adjustment in accordance with any business day convention specified in the paymentDatesAdjustments attribute.
 * @param paymentDateSchedule The payment dates when specified as relative to a set of dates specified somewhere else in the instance document/transaction, e.g. the valuation dates as typically the case for equity swaps, or when specified as a calculation period schedule.
 * @param payRelativeTo Specifies whether the payments occur relative to each adjusted calculation period start date or end date, each reset date, valuation date or the last pricing date. Calculation period start date means relative to the start of the first calculation period contributing to a given payment. Similarly, calculation period end date means the end of the last calculation period contributing to a given payment. The valuation date is applicable for Brazilian-CDI and equity swaps.
 * @param paymentDaysOffset If early payment or delayed payment is required, specifies the number of days offset that the payment occurs relative to what would otherwise be the unadjusted payment date. The offset can be specified in terms of either calendar or business days. Even in the case of a calendar days offset, the resulting payment date, adjusted for the specified calendar days offset, will still be adjusted in accordance with the specified payment dates adjustments. This element should only be included if early or delayed payment is applicable, i.e. if the periodMultiplier element value is not equal to zero. An early payment would be indicated by a negative periodMultiplier element value and a delayed payment (or payment lag) would be indicated by a positive periodMultiplier element value.
 * @param paymentDatesAdjustments The definition of the business day convention and financial business centers used for adjusting the payment date if it would otherwise fall on a day that is not a business day in the specified business center.
 * @param meta 
 */
@Serializable
open class PaymentDates (
  var paymentFrequency: Frequency? = null,
  var firstPaymentDate: Date? = null,
  var lastRegularPaymentDate: Date? = null,
  var paymentDateSchedule: PaymentDateSchedule? = null,
  var payRelativeTo: PayRelativeToEnum? = null,
  var paymentDaysOffset: Offset? = null,
  var paymentDatesAdjustments: BusinessDayAdjustments? = null,
  var meta: MetaFields? = null
)

@Serializable
open class PaymentDetail (
  var paymentDate: AdjustableOrRelativeDate? = null,
  var paymentRule: PaymentRule? = null,
  var paymentAmount: Money? = null,
  var meta: MetaFields? = null
)

/**
 * This class corresponds to the FpML PaymentDiscounting.model group for representing the discounting elements that can be associated with a payment.
 *
 * @param discountFactor The value representing the discount factor used to calculate the present value of the cash flow.
 * @param presentValueAmount The amount representing the present value of the forecast payment.
 */
@Serializable
open class PaymentDiscounting (
  var discountFactor: Float? = null,
  var presentValueAmount: Money? = null
)

/**
 * A class defining the payment calculation rule. As of FpML 5.10, percentage rule is the only calculation rule that has been specified as part of the standard.
 *
 * @param percentageRule This attribute is not present as part of the FpML construct, as the payment rule is specialised by means of runtime type extension through the xsi:type.
 */
@Serializable
open class PaymentRule (
  var percentageRule: PercentageRule? = null
)

/**
 * Represents the set of future cashflow methodologies in the form of specific payout data type(s) which result from the financial product.  Examples: a trade in a cash asset will use only a settlement payout; for derivatives, two interest rate payouts can be combined to specify an interest rate swap; one interest rate payout can be combined with a credit default payout to specify a credit default swap.
 *
 * @param AssetPayout Defines the assets and movements in a security financing transaction.
 * @param CommodityPayout Defines the payout for the floating leg of a Commodity Swap.
 * @param CreditDefaultPayout The credit default payout, which provides the details necessary for determining when a credit payout will be triggered as well as the parameters for calculating the payout and the settlement terms.
 * @param FixedPricePayout Defines a payout in which one or more payouts are defined as a fixed price.
 * @param InterestRatePayout All of the terms necessary to define and calculate a cash flow based on a fixed, a floating or an inflation index rate. The interest rate payout can be applied to interest rate swaps and FRA (which both have two associated interest rate payouts), credit default swaps (to represent the fee leg when subject to periodic payments) and equity swaps (to represent the funding leg).
 * @param OptionPayout The option payout.
 * @param PerformancePayout The performance payout, which encompasses the equity price returns, dividend returns, volatility return, variance return and correlation provisions.
 * @param SettlementPayout Represents a forward settling payout. The 'Underlier' attribute captures the underlying payout, which is settled according to the 'SettlementTerms' attribute. Both FX Spot and FX Forward should use this component.
 * @param meta 
 */
@Serializable
open class Payout (
  var assetPayout: AssetPayout? = null,
  var commodityPayout: CommodityPayout? = null,
  var creditDefaultPayout: CreditDefaultPayout? = null,
  var fixedPricePayout: FixedPricePayout? = null,
  var interestRatePayout: InterestRatePayout? = null,
  var optionPayout: OptionPayout? = null,
  var performancePayout: PerformancePayout? = null,
  var settlementPayout: SettlementPayout? = null,
  var meta: MetaFields? = null
)

/**
 * A data type that contains the common attributes (e.g. payer and receiver parties) and validation conditions that apply across all payout types
 *
 * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
 * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
 * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
 * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
 */
@Serializable
open class PayoutBase (
  var payerReceiver: PayerReceiver? = null,
  var priceQuantity: ResolvablePriceQuantity? = null,
  var principalPayment: PrincipalPayments? = null,
  var settlementTerms: SettlementTerms? = null
)

/**
 * A class defining a content model for a calculation rule defined as percentage of the notional amount.
 *
 * @param paymentPercent A percentage of the notional amount.
 * @param notionalAmountReference A reference to the notional amount.
 */
@Serializable
open class PercentageRule (
  var paymentPercent: Float? = null,
  var notionalAmountReference: ReferenceWithMetaMoney? = null
)

/**
 * Contains the necessary specifications for all performance payouts, encompassing equity return, dividend, variance, volatility and correlation products.
 *
 * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
 * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
 * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
 * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
 * @param observationTerms Defines how and when a performance type option or performance type swap is to be observed.
 * @param valuationDates Defines how and when a performance type option or performance type swap is to be valued, including both interim and final valuation.
 * @param paymentDates Defines the payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the valuation dates).
 * @param underlier Identifies the underlying product that is referenced for pricing of the applicable leg in a swap.  Referenced in the '2018 ISDA CDM Equity Confirmation for Security Equity Swap' as Security.
 * @param fxFeature Defines quanto or composite FX features that are included in the swap leg.
 * @param returnTerms Specifies the type of return of a performance payout.
 * @param portfolioReturnTerms Specifies an individual type of return of a Performance Payout, when such individual return is part of an aggregation of multiple similar returns, at Performance Payout level
 * @param initialValuationPrice Specifies the net initial valuation price(s) of the underlier at Performance Payout level. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
 * @param interimValuationPrice Specifies the net initial valuation price(s) of the underlier at Performance Payout level. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
 * @param finalValuationPrice Specifies the net final valuation price(s) of the underlier at Performance Payout level. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
 */
@Serializable
open class PerformancePayout (
  var observationTerms: ObservationTerms? = null,
  var valuationDates: ValuationDates? = null,
  var paymentDates: PaymentDates? = null,
  var underlier: Underlier? = null,
  var fxFeature: MutableList<FxFeature>? = null,
  var returnTerms: ReturnTerms? = null,
  var portfolioReturnTerms: MutableList<PortfolioReturnTerms>? = null,
  var initialValuationPrice: MutableList<ReferenceWithMetaPriceSchedule>? = null,
  var interimValuationPrice: MutableList<ReferenceWithMetaPriceSchedule>? = null,
  var finalValuationPrice: MutableList<ReferenceWithMetaPriceSchedule>? = null
)
: PayoutBase()

/**
 * Defines how and when a performance type option or performance type swap is to be valued.
 *
 * @param determinationMethod Specifies the method according to which an amount or a date is determined.
 * @param valuationDates 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Pricing Date
 * @param valuationDate 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Pricing Date
 * @param valuationTime The specific time of day at which the calculation agent values the underlying. The SpecificTime is the only case when the valuationTime (time + business center location  e.g. 10:00:00 USNY) should be provided. You should be able to provide just the valuationTime without valuationTimeType, which infer that this is a specific time.
 * @param valuationTimeType The time of day at which the calculation agent values the underlying, for example the official closing time of the exchange.
 * @param meta 
 */
@Serializable
open class PerformanceValuationDates (
  var determinationMethod: DeterminationMethodEnum? = null,
  var valuationDates: AdjustableRelativeOrPeriodicDates? = null,
  var valuationDate: AdjustableOrRelativeDate? = null,
  var valuationTime: BusinessCenterTime? = null,
  var valuationTimeType: TimeTypeEnum? = null,
  var meta: MetaFields? = null
)

/**
 * A class to define recurring periods or time offsets.
 *
 * @param periodMultiplier A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
 * @param period A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
 * @param meta 
 */
@Serializable
open class Period (
  var periodMultiplier: Int? = null,
  var period: PeriodEnum? = null,
  var meta: MetaFields? = null
)

/**
 * Indicator to specify if the period bound is defined as a period and whether the bound is inclusive.
 *
 * @param period Specifies the period is to be used as the bound, e.g. 5Y.
 * @param inclusive Specifies whether the period bound is inclusive, e.g. for a lower bound, false would indicate greater than, whereas true would indicate greater than or equal to.
 */
@Serializable
open class PeriodBound (
  var period: Period? = null,
  var inclusive: Boolean? = null
)

/**
 * Indicates The period range defined as either a lower and upper period bound, or both.
 *
 * @param lowerBound Specifies the lower bound of a period range, e.g. greater than or equal to 5Y.
 * @param upperBound Specifies the upper bound of a period range, e.g. less than to 10Y.
 */
@Serializable
open class PeriodRange (
  var lowerBound: PeriodBound? = null,
  var upperBound: PeriodBound? = null
)

/**
 * A class for specifying a calculation period schedule.
 *
 * @param startDate The start date of the calculation period. FpML specifies that for interest rate swaps this date must only be specified if it is not equal to the effective date. It is always specified in the case of equity swaps and credit default swaps with periodic payments. This date may be subject to adjustment in accordance with a business day convention.
 * @param endDate The end date of the calculation period. FpML specifies that for interest rate swaps this date must only be specified if it is not equal to the termination date. It is always specified in the case of equity swaps with periodic payments. This date may be subject to adjustment in accordance with a business day convention.
 * @param periodFrequency The frequency at which calculation period end dates occur with the regular part of the calculation period schedule and their roll date convention.
 * @param periodDatesAdjustments The specification of the business day convention and financial business centers used for adjusting any calculation period date if it would otherwise fall on a day that is not a business day in the specified business center.
 * @param dayType Denotes the enumerated values to specify the day type classification used in counting the number of days between two dates.
 */
@Serializable
open class PeriodicDates (
  var startDate: AdjustableOrRelativeDate? = null,
  var endDate: AdjustableOrRelativeDate? = null,
  var periodFrequency: CalculationPeriodFrequency? = null,
  var periodDatesAdjustments: BusinessDayAdjustments? = null,
  var dayType: DayTypeEnum? = null
)

/**
 * Comprises an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the PersonIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 *
 * @param identifier Provides an identifier associated with a person. The identifier is unique within the public source specified in the source attribute.
 * @param identifierType Defines the source of the identifier.
 * @param country The ISO 3166 standard code for the country issuing the identifier.
 * @param meta 
 */
@Serializable
open class PersonIdentifier (
  var identifier: FieldWithMetaString? = null,
  var identifierType: PersonIdentifierTypeEnum? = null,
  var country: FieldWithMetaString? = null,
  var meta: MetaFields? = null
)

@Serializable
open class PhysicalSettlementPeriod (
  var businessDaysNotSpecified: Boolean? = null,
  var businessDays: Int? = null,
  var maximumBusinessDays: Int? = null
)

/**
 * Specifies Physical Settlement Terms characteristics for the settlement of a Credit Default Swap or Option.
 *
 * @param clearedPhysicalSettlement Specifies whether the swap resulting from physical settlement of the swaption transaction will clear through a clearing house. The meaning of Cleared Physical Settlement is defined in the 2006 ISDA Definitions, Section 15.2 (published in Supplement number 28).
 * @param predeterminedClearingOrganizationParty Specifies the clearing organization (CCP, DCO) to which the trade should be cleared.
 * @param physicalSettlementPeriod The number of business days used in the determination of the physical settlement date. The physical settlement date is this number of business days after all applicable conditions to settlement are satisfied. If a number of business days is not specified fallback provisions apply for determining the number of business days. If Section 8.5/8.6 of the 1999/2003 ISDA Definitions are to apply the businessDaysNotSpecified element should be included. If a specified number of business days are to apply these should be specified in the businessDays element. If Section 8.5/8.6 of the 1999/2003 ISDA Definitions are to apply but capped at a maximum number of business days then the maximum number should be specified in the maximumBusinessDays element. ISDA 2003 Term: Physical Settlement Period.
 * @param deliverableObligations This element contains all the ISDA terms relevant to defining the deliverable obligations.
 * @param escrow If this element is specified and set to 'true', indicates that physical settlement must take place through the use of an escrow agent. (For Canadian counterparties this is always 'Not Applicable'. ISDA 2003 Term: Escrow.
 * @param sixtyBusinessDaySettlementCap If this element is specified and set to 'true', for a transaction documented under the 2003 ISDA Credit Derivatives Definitions, has the effect of incorporating the language set forth below into the confirmation. The section references are to the 2003 ISDA Credit Derivatives Definitions. Notwithstanding Section 1.7 or any provisions of Sections 9.9 or 9.10 to the contrary, but without prejudice to Section 9.3 and (where applicable) Sections 9.4, 9.5 and 9.6, if the Termination Date has not occurred on or prior to the date that is 60 Business Days following the Physical Settlement Date, such 60th Business Day shall be deemed to be the Termination Date with respect to this Transaction except in relation to any portion of the Transaction (an 'Affected Portion') in respect of which: (1) a valid notice of Buy-in Price has been delivered that is effective fewer than three Business Days prior to such 60th Business Day, in which case the Termination Date for that Affected Portion shall be the third Business Day following the date on which such notice is effective; or (2) Buyer has purchased but not Delivered Deliverable Obligations validly specified by Seller pursuant to Section 9.10(b), in which case the Termination Date for that Affected Portion shall be the tenth Business Day following the date on which Seller validly specified such Deliverable Obligations to Buyer.
 * @param meta 
 */
@Serializable
open class PhysicalSettlementTerms (
  var clearedPhysicalSettlement: Boolean? = null,
  var predeterminedClearingOrganizationParty: AncillaryRoleEnum? = null,
  var physicalSettlementPeriod: PhysicalSettlementPeriod? = null,
  var deliverableObligations: DeliverableObligations? = null,
  var escrow: Boolean? = null,
  var sixtyBusinessDaySettlementCap: Boolean? = null,
  var meta: MetaFields? = null
)

/**
 *  A Portfolio represents an aggregation of multiple Positions, by describing the parameters that this Portfolio should be aggregated based on. The resulting PortfolioState is calculated using these aggregation parameters as inputs, by aggregating all the Events that are relevant to this Portfolio. The concept of Portfolio works at all levels in the model: from the highest for a given LegalEntity for instance, to the lowest to account for security substitutions in a secutity financing transaction. As such, Portfolio can be used either above or below the Contract level.
 *
 * @param aggregationParameters Describes the portfolio by describing how to aggregate all its relevant Events.
 * @param portfolioState Describes the state of the Portfolio as a list of Positions resulting from the aggregation.
 */
@Serializable
open class Portfolio (
  var aggregationParameters: AggregationParameters? = null,
  var portfolioState: PortfolioState? = null
)

/**
 * Specifies an individual type of return of a Performance Payout, when such individual return is part of an aggregation of multiple similar returns, at Performance Payout level.
 *
 * @param priceReturnTerms Return terms based upon the underlier's observed price.
 * @param dividendReturnTerms Return terms based upon dividend payments associated to the underlier.
 * @param varianceReturnTerms Return terms based upon the observed variance of the underlier's price.
 * @param volatilityReturnTerms Return terms based upon the observed volatility of the underlier's price.
 * @param correlationReturnTerms Return terms based upon the observed correlation between the components of the underlying basket.
 * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each individual return leg.
 * @param underlier Defines the product that is the subject of a tradable product definition, an underlying product definition, a physical exercise, a position, or other purposes.
 * @param quantity Specifies a quantity schedule for the underlier, which applies to each individual return leg.
 * @param initialValuationPrice Specifies the initial valuation price(s) of the underlier. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
 * @param interimValuationPrice Specifies the initial valuation price(s) of the underlier. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
 * @param finalValuationPrice 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Final Price | Specifies the final valuation price of the underlier. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
 * @param meta 
 */
@Serializable
open class PortfolioReturnTerms (
  var payerReceiver: PayerReceiver? = null,
  var underlier: ReferenceWithMetaObservable? = null,
  var quantity: ReferenceWithMetaNonNegativeQuantitySchedule? = null,
  var initialValuationPrice: MutableList<ReferenceWithMetaPriceSchedule>? = null,
  var interimValuationPrice: MutableList<ReferenceWithMetaPriceSchedule>? = null,
  var finalValuationPrice: MutableList<ReferenceWithMetaPriceSchedule>? = null,
  var meta: MetaFields? = null
)
: ReturnTerms()

/**
 * State-full representation of a Portfolio that describes all the positions held at a given time, in various states which can be either traded, settled, etc., with lineage information to the previous state
 *
 * @param positions The list of positions, each containing a Quantity and a Product.
 * @param lineage Pointer to the previous PortfolioState and new Event(s) leading to the current (new) state. Previous PortfolioState in the Lineage can be Null in case this is the start of the chain of Events.
 * @param meta 
 */
@Serializable
open class PortfolioState (
  var positions: MutableList<Position>? = null,
  var lineage: Lineage? = null,
  var meta: MetaFields? = null
)

/**
 * A Position describes how much of a given Product is being held and constitutes the atomic element of a Portfolio.
 *
 * @param priceQuantity Position with many price quantities.
 * @param product The product underlying the position.
 * @param cashBalance The aggregate cost of proceeds
 * @param tradeReference Reference to the Contract, in case product is contractual and the contract has been formed
 */
@Serializable
open class Position (
  var priceQuantity: MutableList<PriceQuantity>? = null,
  var product: Product? = null,
  var cashBalance: Money? = null,
  var tradeReference: ReferenceWithMetaTradeState? = null
)

/**
 * Defines a position identifier as a special case of the generic identifier type, that also includes the position identifier class.
 *
 * @param issuerReference The identifier issuer, when specified by reference to a party specified as part of the transaction.
 * @param issuer The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).
 * @param assignedIdentifier The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.
 * @param meta 
 * @param identifierType The enumerated classification of the identifier. Optional as a position identifier may be party-specific, in which case it may not correspond to any established classification.
 */
@Serializable
open class PositionIdentifier (
  var identifierType: TradeIdentifierTypeEnum? = null
)
: Identifier()

/**
 * This class corresponds to the FpML Premium.model group for representing the option premium when expressed in a way other than an amount.
 *
 * @param premiumType Forward start premium type
 * @param pricePerOption The amount of premium to be paid expressed as a function of the number of options.
 * @param percentageOfNotional The amount of premium to be paid expressed as a percentage of the notional value of the transaction. A percentage of 5% would be expressed as 0.05.
 */
@Serializable
open class PremiumExpression (
  var premiumType: PremiumTypeEnum? = null,
  var pricePerOption: Money? = null,
  var percentageOfNotional: Float? = null
)

@Serializable
open class Pric (
  var pric: Pric? = null,
  var bsisPts: String? = null
)

/**
 * Specifies a price as a single value to be associated to a financial product. This data type extends PriceSchedule and requires that only the amount value exists.
 *
 * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
 * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
 * @param datedValue A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
 * @param perUnitOf Provides an attribute to define the unit of the thing being priced. For example, {amount, unitOfAmount, PerUnitOfAmount} = [10, EUR, Shares] = (10.00 EUR/SHARE) * (300,000 SHARES) = EUR 3,000,000.00 (Shares cancel out in the calculation).
 * @param priceType Specifies the price type as an enumeration: interest rate, exchange rate, asset price etc. This attribute is mandatory so that prices can always be clasiffied according to their type. The price type implies some constraints on the price's units.
 * @param priceExpression (Optionally) Specifies whether the price is expressed in absolute or percentage terms.
 * @param composite (Optionally) Specifies the underlying price components if the price can be expressed as a composite: e.g. dirty price = clean price + accrued.
 * @param arithmeticOperator (Optionally) When the price is to be understood as an operator to apply to an observable, i.e. a spread, multiplier or min/max.
 * @param cashPrice (Optionally when the price type is cash) Additional attributes that further define a cash price, e.g. what type of fee it is.
 */
@Serializable
open class Price (
)
: PriceSchedule()

/**
 * Defines the inputs required to calculate a price as a simple composite of 2 other values. The inputs consist of 2 numbers and a simple arithmetic operator. This generic data type applies to a variety of use cases where a price is obtained by simple composition, e.g. dirty = clean + accrued (Bond), forward rate = spot rate + forward point (FX) etc.
 *
 * @param baseValue The 1st value in the arithmetic operation, which may be non-commutative in some cases: Subtract, Divide). This 1st operand is called 'baseValue' as it refers to the price anchor in the arithmetic operation: e.g. the clean price (Bond) or the spot rate (FX).
 * @param operand The 2nd value in the arithmetic operation, which may be non-commutative in some cases: Subtract, Divide). The 2nd operand is called 'operand' to distinguish it from the 1st one which is the price anchor.
 * @param arithmeticOperator Specifies the arithmetic operator via an enumeration.
 * @param operandType Optionally qualifies the type of operand: e.g. accrued or forward point.
 */
@Serializable
open class PriceComposite (
  var baseValue: Float? = null,
  var operand: Float? = null,
  var arithmeticOperator: ArithmeticOperationEnum? = null,
  var operandType: PriceOperandEnum? = null
)

/**
 * Defines a settlement as an exchange between two parties of a specified quantity of an asset (the quantity) against a specified quantity of another asset (the price). The settlement is optional and can be either cash or physical. The quantity can additionally be specified in terms of one or more currency amounts. In the case of non-cash products, the settlement of the price/quantity would not be specified here and instead would be delegated to the product mechanics, as parameterised by the price/quantity values.
 *
 * @param price Specifies a price to be used for trade amounts and other purposes.
 * @param quantity Specifies a quantity to be associated with an event, for example a trade amount.
 * @param observable Specifies the object to be observed for a price, it could be an asset or an index. The cardinality is optional as some quantity / price cases have no observable (e.g. a fixed rate in a given currency).
 * @param effectiveDate Specifies the date at which the price and quantity become effective. This day may be subject to adjustment in accordance with a business day convention, or could be specified as relative to a trade date, for instance. Optional cardinality, as the effective date is usually specified in the product definition, so it may only need to be specified as part of the PriceQuantity in an increase/decrease scenario for an existing trade.
 * @param meta 
 */
@Serializable
open class PriceQuantity (
  var price: MutableList<FieldWithMetaPriceSchedule>? = null,
  var quantity: MutableList<FieldWithMetaNonNegativeQuantitySchedule>? = null,
  var observable: FieldWithMetaObservable? = null,
  var effectiveDate: AdjustableOrRelativeDate? = null,
  var meta: MetaFields? = null
)

@Serializable
open class PriceReturnTerms (
  var returnType: ReturnTypeEnum? = null,
  var conversionFactor: Float? = null,
  var performance: String? = null
)

/**
 * Specifies the price of a financial instrument in a trade as a schedule of measures. A price generically expresses the value of an exchange as a ratio: it measures the amount of one thing needed to be exchanged for 1 unit of another thing (e.g. cash in a specific currency in exchange for a bond or share). This generic representation can be used to support any type of financial price beyond just cash price: e.g. an interest rate, a foreign exchange rate, etc. This data type is generically based on a schedule and can also be used to represent a price as a single value.
 *
 * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
 * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
 * @param datedValue A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
 * @param perUnitOf Provides an attribute to define the unit of the thing being priced. For example, {amount, unitOfAmount, PerUnitOfAmount} = [10, EUR, Shares] = (10.00 EUR/SHARE) * (300,000 SHARES) = EUR 3,000,000.00 (Shares cancel out in the calculation).
 * @param priceType Specifies the price type as an enumeration: interest rate, exchange rate, asset price etc. This attribute is mandatory so that prices can always be clasiffied according to their type. The price type implies some constraints on the price's units.
 * @param priceExpression (Optionally) Specifies whether the price is expressed in absolute or percentage terms.
 * @param composite (Optionally) Specifies the underlying price components if the price can be expressed as a composite: e.g. dirty price = clean price + accrued.
 * @param arithmeticOperator (Optionally) When the price is to be understood as an operator to apply to an observable, i.e. a spread, multiplier or min/max.
 * @param cashPrice (Optionally when the price type is cash) Additional attributes that further define a cash price, e.g. what type of fee it is.
 */
@Serializable
open class PriceSchedule (
  var perUnitOf: UnitType? = null,
  var priceType: PriceTypeEnum? = null,
  var priceExpression: PriceExpressionEnum? = null,
  var composite: PriceComposite? = null,
  var arithmeticOperator: ArithmeticOperationEnum? = null,
  var cashPrice: CashPrice? = null
)
: MeasureSchedule()

/**
 * Specifies a publication that provides the commodity price, including, where applicable, the details of where in the publication the price is published.
 *
 * @param pricePublisher Defines a publication in which the price can be found. (e.g Gas Daily, Platts Bloomberg. Commodity publishers can be found at this URL:  http://www.fpml.org/coding-scheme/commodity-information-provider>
 * @param priceSourceLocation Specifies the location of the price which may be a specific page, electornic screen name, or a code (e.g. a RIC code) where the price can be found.
 * @param priceSourceHeading Specifies the heading or field name for the price  on a given page or screen, where applicable.
 * @param priceSourceTime Specifies the time at which the price should be observed.
 */
@Serializable
open class PriceSource (
  var pricePublisher: FieldWithMetaString? = null,
  var priceSourceLocation: String? = null,
  var priceSourceHeading: String? = null,
  var priceSourceTime: String? = null
)

/**
 * A data defining:  the parameters used to get a price quote to replace the settlement rate option that is disrupted.
 *
 * @param fallbackReferencePrice The method, prioritised by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
 */
@Serializable
open class PriceSourceDisruption (
  var fallbackReferencePrice: FallbackReferencePrice? = null
)

/**
 * Specifies specific dates or parametric rules for the dates on which the price will be determined
 *
 * @param specifiedDates Defines specified dates on which the price will be determined.
 * @param parametricDates Defines rules for the dates on which the price will be determined.
 */
@Serializable
open class PricingDates (
  var specifiedDates: MutableList<AdjustableDates>? = null,
  var parametricDates: ParametricDates? = null
)

/**
 * A Primitive Instruction describes the inputs required to pass into the corresponding PrimitiveEvent function.
 *
 * @param contractFormation Specifies instructions describing an contract formation primitive event.
 * @param execution Specifies instructions describing an execution primitive event.
 * @param exercise Specifies instructions describing an exercise primitive event.
 * @param partyChange Specifies instructions describing a party change primitive event.
 * @param quantityChange Specifies instructions describing an quantity change primitive event.
 * @param reset Specifies instructions describing a reset event.
 * @param split Specifies instructions to split a trade into multiple branches.
 * @param termsChange Specifies instructions describing a terms change primitive event.
 * @param transfer Specifies instructions describing a transfer primitive event.
 * @param indexTransition Specifies inputs needed to process a Index Transition business event.
 * @param stockSplit Specifies inputs needed to process a Stock Split business event.
 * @param observation Specifies inputs needed to process an observation.
 * @param valuation Specifies inputs needed to process an update of a valuation.
 */
@Serializable
open class PrimitiveInstruction (
  var contractFormation: ContractFormationInstruction? = null,
  var execution: ExecutionInstruction? = null,
  var exercise: ExerciseInstruction? = null,
  var partyChange: PartyChangeInstruction? = null,
  var quantityChange: QuantityChangeInstruction? = null,
  var reset: ResetInstruction? = null,
  var split: SplitInstruction? = null,
  var termsChange: TermsChangeInstruction? = null,
  var transfer: TransferInstruction? = null,
  var indexTransition: IndexTransitionInstruction? = null,
  var stockSplit: StockSplitInstruction? = null,
  var observation: ObservationInstruction? = null,
  var valuation: ValuationInstruction? = null
)

/**
 * Any kind of principal payments when the amount is known and thus fixed.
 *
 * @param principalPaymentDate The date where the PrincipalPayment shall be settled.
 * @param payerReceiver Specifies the parties responsible for making and receiving payments defined by this structure.
 * @param principalAmount When known at the time the transaction is made, the cash amount to be paid.
 * @param discountFactor The value representing the discount factor used to calculate the present value of the principal payment amount.
 * @param presentValuePrincipalAmount The amount representing the present value of the principal payment.
 * @param meta 
 */
@Serializable
open class PrincipalPayment (
  var principalPaymentDate: AdjustableDate? = null,
  var payerReceiver: PayerReceiver? = null,
  var principalAmount: Money? = null,
  var discountFactor: Float? = null,
  var presentValuePrincipalAmount: Money? = null,
  var meta: MetaFields? = null
)

/**
 * Describe dates schedules for Principal Exchanges and related role of the parties when known.
 *
 * @param initialPrincipalPayment Principal Payment made at Trade inception.
 * @param intermediatePrincipalPayment Principal Payment as part of the Trade lifecycle e.g. as part of notional reset adjustements in a Cross Currency Swap with a varying notional leg.
 * @param finalPrincipalPayment Principal Payment at Trade maturity
 */
@Serializable
open class PrincipalPaymentSchedule (
  var initialPrincipalPayment: PrincipalPayment? = null,
  var intermediatePrincipalPayment: AdjustableRelativeOrPeriodicDates? = null,
  var finalPrincipalPayment: PrincipalPayment? = null
)

/**
 * A class defining which principal exchanges occur for the stream.
 *
 * @param initialPayment A true/false flag to indicate whether there is an initial exchange of principal on the effective date.
 * @param finalPayment A true/false flag to indicate whether there is a final exchange of principal on the termination date.
 * @param intermediatePayment A true/false flag to indicate whether there are intermediate or interim exchanges of principal during the term of the swap.
 * @param varyingLegNotionalCurrency Indicate the Payout legs which nominal amount may vary in regards of FX Fixing dates as determined in the product terms.
 * @param principalPaymentSchedule Describe dates schedules for Principal Exchanges and related role of the parties when known.
 * @param meta 
 */
@Serializable
open class PrincipalPayments (
  var initialPayment: Boolean? = null,
  var finalPayment: Boolean? = null,
  var intermediatePayment: Boolean? = null,
  var varyingLegNotionalCurrency: MutableList<String>? = null,
  var principalPaymentSchedule: PrincipalPaymentSchedule? = null,
  var meta: MetaFields? = null
)

/**
 * Enables either a TransferableProduct or a NonTransferableProduct to be used in an underlier.
 *
 * @param TransferableProduct A TransferableProduct is a type of financial product which can be held or transferred, represented as an Asset with the addition of specific EconomicTerms.
 * @param NonTransferableProduct The non-transferable product data type represents a product that can be traded (as part of a TradableProduct) but cannot be transferred to others.
 */
@Serializable
open class Product (
  var transferableProduct: TransferableProduct? = null,
  var nonTransferableProduct: NonTransferableProduct? = null
)

/**
 * Comprises an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the ProductIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 *
 * @param identifier Provides an identifier associated with a specific product.  The identifier is unique within the public source specified in the source attribute.
 * @param source Defines the source of the identifier.
 * @param meta 
 */
@Serializable
open class ProductIdentifier (
  var identifier: FieldWithMetaString? = null,
  var source: ProductIdTypeEnum? = null,
  var meta: MetaFields? = null
)

/**
 * Specifies the product taxonomy, which is composed of a taxonomy value and a taxonomy source.
 *
 * @param source The source of the taxonomy that defines the rules for classifying the object. The taxonomy source is taken from a enumerated list of taxonomy names. Optional as the taxonomy source may not be provided.
 * @param value The value according to that taxonomy. Optional as it may not be possible to classify the object in that taxonomy.
 * @param primaryAssetClass Classifies the most important risk class of the trade.
 * @param secondaryAssetClass  Classifies additional risk classes of the trade, if any.
 * @param productQualifier Derived from the product payout features using a CDM product qualification function that determines the product type based on the product payout features.
 */
@Serializable
open class ProductTaxonomy (
  var primaryAssetClass: FieldWithMetaAssetClassEnum? = null,
  var secondaryAssetClass: MutableList<FieldWithMetaAssetClassEnum>? = null,
  var productQualifier: String? = null
)
: Taxonomy()

/**
 * A class to specify the terms for calculating a payout to protect the buyer of the swap in the case of a qualified credit event. These terms include the applicable credit events, the reference obligation, and in the case of a CDS on mortgage-backed securities, the floatingAmountEvents.
 *
 * @param creditEvents Specifies the applicable Credit Events that would trigger a settlement, as specified in the related Confirmation and defined in the ISDA 2014 Credit Definition article IV section 4.1.
 * @param obligations The underlying obligations of the reference entity on which you are buying or selling protection. The credit events Failure to Pay, Obligation Acceleration, Obligation Default, Restructuring, Repudiation/Moratorium are defined with respect to these obligations.
 * @param floatingAmountEvents This element contains the ISDA terms relating to the floating rate payment events and the implied additional fixed payments, applicable to the credit derivatives transactions on mortgage-backed securities with pay-as-you-go or physical settlement.
 * @param meta 
 */
@Serializable
open class ProtectionTerms (
  var creditEvents: CreditEvents? = null,
  var obligations: Obligations? = null,
  var floatingAmountEvents: FloatingAmountEvents? = null,
  var meta: MetaFields? = null
)

@Serializable
open class Prsn (
  var ctryOfBrnch: String? = null,
  var othr: Othr? = null
)

@Serializable
open class PubliclyAvailableInformation (
  var standardPublicSources: Boolean? = null,
  var publicSource: MutableList<String>? = null,
  var specifiedNumber: Int? = null
)

@Serializable
open class Qty (
  var unit: String? = null
)

/**
 * Specifies a quantity as a single value to be associated to a financial product, for example a transfer amount resulting from a trade. This data type extends QuantitySchedule and requires that only the single amount value exists.
 *
 * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
 * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
 * @param datedValue A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
 * @param multiplier Defines an optional number that the quantity should be multiplied by to derive a total quantity. This number is associated to a unit. For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unit would be contracts, the multiplier value would 1,000 and the mulitiplier unit would be 1,000 MT (Metric Tons).
 * @param frequency Defines the frequency to be used when defining a quantity. For example a quantity may be specified as a number of barrels of oil per day, which needs multiplying by the number of days in the relevant period to get the total quantity as a number of barrels.
 */
@Serializable
open class Quantity (
)
: QuantitySchedule()

/**
 * Instructions required to create a Quantity Change Primitive Event, which can be either an increase, a decrease or a replacement. An increase adds a new trade lot to the original trade, whereas a decrease subtracts from an existing trade lot's quantity. A replacement updates the quantity of an existing trade lot to the new value.
 *
 * @param change Quantity by which the trade is being increased, decreased or replaced, and the price at which such quantity change is agreed. The quantity change should always be specified as a positive number, with the direction (increase/decrease/replacement) being specified by the direction enumeration. A fee can also be associated to the quantity change by specifying a Price component of type CashPrice, including the corresponding settlement date and direction.
 * @param direction Direction of the quantity change specified as either an increase, decrease or replacement.
 * @param lotIdentifier Identifier for the new lot (in case of increase) or for the existing lot to be changed(in case of decrease or replacement). This optional attribute is mandatory in case of a decrease or replacement if the initial trade state contains multiple trade lots.
 */
@Serializable
open class QuantityChangeInstruction (
  var change: MutableList<PriceQuantity>? = null,
  var direction: QuantityChangeDirectionEnum? = null,
  var lotIdentifier: MutableList<Identifier>? = null
)

/**
 *  Class to specify a mechanism for a quantity to be set as a multiplier to another (reference) quantity, based on a price observation. At the moment this class only supports FX or Equity-linked notional and re-uses existing building blocks for those 2 cases, until such time when component can be made more generic. This captures the case of resetting cross-currency swaps and resetting equity swaps.
 *
 * @param fxLinkedNotionalSchedule Multiplier specified as an FX-linked schedule, e.g. for a resetting cross-currency swap..
 * @param multiplierValue 
 */
@Serializable
open class QuantityMultiplier (
  var fxLinkedNotionalSchedule: FxLinkedNotionalSchedule? = null,
  var multiplierValue: Float? = null
)

/**
 * Specifies a quantity schedule to be associated to a financial product to represent a trade amount. This data type extends MeasureSchedule with several unit or multiplier attributes that are used to define financial quantities. This data type is generically based on a schedule and can also be used to represent a quantity as a single value.
 *
 * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
 * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
 * @param datedValue A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
 * @param multiplier Defines an optional number that the quantity should be multiplied by to derive a total quantity. This number is associated to a unit. For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unit would be contracts, the multiplier value would 1,000 and the mulitiplier unit would be 1,000 MT (Metric Tons).
 * @param frequency Defines the frequency to be used when defining a quantity. For example a quantity may be specified as a number of barrels of oil per day, which needs multiplying by the number of days in the relevant period to get the total quantity as a number of barrels.
 */
@Serializable
open class QuantitySchedule (
  var multiplier: Measure? = null,
  var frequency: Frequency? = null
)
: MeasureSchedule()

/**
 * Determines the currency rate that the seller of the equity amounts will apply at each valuation date for converting the respective amounts into a currency that is different from the currency denomination of the underlier.
 *
 * @param fxRate Specifies a currency conversion rate.
 * @param fxSpotRateSource Specifies the methodology (reference source and, optionally, fixing time) to be used for determining a currency conversion rate.
 * @param fixingTime The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
 */
@Serializable
open class Quanto (
  var fxRate: MutableList<FxRate>? = null,
  var fxSpotRateSource: FxSpotRateSource? = null,
  var fixingTime: BusinessCenterTime? = null
)

/**
 * Represents a class to allow specification of different types of Quasi Government collateral.
 *
 * @param sovereignEntity True if sovereign entity (e.g. not separate legal personality from sovereign) or false if non-sovereign entity (e.g. separate legal personality from sovereign).
 * @param sovereignRecourse Applies to non-sovereign entity (e.g. separate legal personality from sovereign).  True if entity has recourse to sovereign (e.g. debt guaranteed by government).  False if entity does not have recourse to sovereign.
 */
@Serializable
open class QuasiGovernmentIssuerType (
  var sovereignEntity: Boolean? = null,
  var sovereignRecourse: Boolean? = null
)

/**
 * A class that describes the composition of a rate that has been quoted or is to be quoted. This includes the two currencies and the quotation relationship between the two currencies and is used as a building block throughout the FX specification.
 *
 * @param currency1 The first currency specified when a pair of currencies is to be evaluated.
 * @param currency2 The second currency specified when a pair of currencies is to be evaluated.
 * @param quoteBasis The method by which the exchange rate is quoted.
 */
@Serializable
open class QuotedCurrencyPair (
  var currency1: FieldWithMetaString? = null,
  var currency2: FieldWithMetaString? = null,
  var quoteBasis: QuoteBasisEnum? = null
)

/**
 * A class defining parameters associated with an individual observation or fixing. This class forms part of the cashflow representation of a stream.
 *
 * @param resetDate The reset date.
 * @param adjustedFixingDate The adjusted fixing date, i.e. the actual date the rate is observed. The date should already be adjusted for any applicable business day convention.
 * @param observedRate The actual observed rate before any required rate treatment is applied, e.g. before converting a rate quoted on a discount basis to an equivalent yield. An observed rate of 5% would be represented as 0.05.
 * @param treatedRate The observed rate after any required rate treatment is applied. A treated rate of 5% would be represented as 0.05.
 * @param observationWeight The number of days weighting to be associated with the rate observation, i.e. the number of days such rate is in effect. This is applicable in the case of a weighted average method of calculation where more than one reset date is established for a single calculation period.
 * @param rateReference A pointer style reference to a floating rate component defined as part of a stub calculation period amount component. It is only required when it is necessary to distinguish two rate observations for the same fixing date which could occur when linear interpolation of two different rates occurs for a stub calculation period.
 * @param forecastRate The value representing the forecast rate used to calculate the forecast future value of the accrual period.A value of 1% should be represented as 0.01.
 * @param treatedForecastRate The value representing the forecast rate after applying rate treatment rules. A value of 1% should be represented as 0.01.
 * @param meta 
 */
@Serializable
open class RateObservation (
  var resetDate: Date? = null,
  var adjustedFixingDate: Date? = null,
  var observedRate: Float? = null,
  var treatedRate: Float? = null,
  var observationWeight: Int? = null,
  var rateReference: ReferenceWithMetaRateObservation? = null,
  var forecastRate: Float? = null,
  var treatedForecastRate: Float? = null,
  var meta: MetaFields? = null
)

/**
 * A class defining a schedule of rates or amounts in terms of an initial value and then a series of step date and value pairs. On each step date the rate or amount changes to the new step value. The series of step date and value pairs are optional. If not specified, this implies that the initial value remains unchanged over time.
 *
 * @param price The initial rate. An initial rate of 5% would be represented as 0.05.
 */
@Serializable
open class RateSchedule (
  var price: ReferenceWithMetaPriceSchedule? = null
)

/**
 *  A data type to specify the fixed interest rate, floating interest rate or inflation rate.
 *
 * @param FixedRateSpecification The fixed rate or fixed rate specification expressed as explicit fixed rates and dates.
 * @param FloatingRateSpecification The floating interest rate specification, which includes the definition of the floating rate index. the tenor, the initial value, and, when applicable, the spread, the rounding convention, the averaging method and the negative interest rate treatment.
 * @param InflationRateSpecification An inflation rate calculation definition.
 */
@Serializable
open class RateSpecification (
  var fixedRateSpecification: FixedRateSpecification? = null,
  var floatingRateSpecification: FloatingRateSpecification? = null,
  var inflationRateSpecification: InflationRateSpecification? = null
)

@Serializable
open class RefRate (
  var indx: String? = null,
  var nm: String? = null
)

/**
 * A class to describe an institution (party) identified by means of a coding scheme and an optional name.
 *
 * @param referenceBankId An institution (party) identifier, e.g. a bank identifier code (BIC). FpML specifies a referenceBankIdScheme.
 * @param referenceBankName The name of the institution (party). A free format string. FpML does not define usage rules for the element.
 */
@Serializable
open class ReferenceBank (
  var referenceBankId: FieldWithMetaString? = null,
  var referenceBankName: String? = null
)

/**
 * A class defining the list of reference institutions polled for relevant rates or prices when determining the cash settlement amount for a product where cash settlement is applicable.
 *
 * @param referenceBank An institution (party) identified by means of a coding scheme and an optional name.
 */
@Serializable
open class ReferenceBanks (
  var referenceBank: MutableList<ReferenceBank>? = null
)

/**
 * A class specifying the Credit Default Swap Reference Information.
 *
 * @param referenceEntity The corporate or sovereign entity which is subject to the swap transaction and any successor that assumes all or substantially all of its contractual and other obligations. Reference Entities cannot be senior or subordinated. It is the obligations of the Reference Entities that can be senior or subordinated. ISDA 2014 Credit definitions article II section 2.1: `Reference Entity` means the entity specified as such in the related Confirmation.
 * @param referenceObligation The Reference Obligation is a financial instrument that is either issued or guaranteed by the reference entity. It serves to clarify the precise reference entity protection is being offered upon, and its legal position with regard to other related firms (parents/subsidiaries). Furthermore the Reference Obligation is ALWAYS deliverable and establishes the Pari Passu ranking (as the deliverable bonds must rank equal to the reference obligation). ISDA 2003 Term: Reference Obligation.
 * @param noReferenceObligation Used to indicate that there is no Reference Obligation associated with this Credit Default Swap and that there will never be one.
 * @param unknownReferenceObligation Used to indicate that the Reference obligation associated with the Credit Default Swap is currently not known. This is not valid for Legal Confirmation purposes, but is valid for earlier stages in the trade life cycle (e.g. Broker Confirmation).
 * @param allGuarantees Indicates whether an obligation of the Reference Entity, guaranteed by the Reference Entity on behalf of a non-Affiliate, is to be considered an Obligation for the purpose of the transaction. It will be considered an obligation if allGuarantees is applicable (true) and not if allGuarantees is inapplicable (false). ISDA 2003 Term: All Guarantees.
 * @param referencePrice Used to determine (a) for physically settled trades, the Physical Settlement Amount, which equals the Floating Rate Payer Calculation Amount times the Reference Price and (b) for cash settled trades, the Cash Settlement Amount, which equals the greater of (i) the difference between the Reference Price and the Final Price and (ii) zero. ISDA 2003 Term: Reference Price.
 * @param referencePolicy Applicable to the transactions on mortgage-backed security, which can make use of a reference policy. Presence of the element with value set to 'true' indicates that the reference policy is applicable; absence implies that it is not.
 * @param securedList With respect to any day, the list of Syndicated Secured Obligations of the Designated Priority of the Reference Entity published by Markit Group Limited or any successor thereto appointed by the Specified Dealers (the 'Secured List Publisher') on or most recently before such day, which list is currently available at [http://www.markit.com]. ISDA 2003 Term: Relevant Secured List.
 */
@Serializable
open class ReferenceInformation (
  var referenceEntity: LegalEntity? = null,
  var referenceObligation: MutableList<ReferenceObligation>? = null,
  var noReferenceObligation: Boolean? = null,
  var unknownReferenceObligation: Boolean? = null,
  var allGuarantees: Boolean? = null,
  var referencePrice: Price? = null,
  var referencePolicy: Boolean? = null,
  var securedList: Boolean? = null
)

/**
 * A class to specify the reference obligation that is associated with a credit derivative instrument.
 *
 * @param security Identifies the underlying asset when it is a security, such as a bond or convertible bond. The security data type requires one or more productIdentifiers, specificaiton of the security type (e.g. debt), and includes optional attributes to specify a debt class, such as asset-backed, as well as seniority.
 * @param loan Identifies the underlying asset when it is a loan.
 * @param primaryObligor The entity primarily responsible for repaying debt to a creditor as a result of borrowing or issuing bonds. ISDA 2003 Term: Primary Obligor.
 * @param primaryObligorReference A pointer style reference to a reference entity defined elsewhere in the document. Used when the reference entity is the primary obligor.
 * @param guarantor The party that guarantees by way of a contractual arrangement to pay the debts of an obligor if the obligor is unable to make the required payments itself. ISDA 2003 Term: Guarantor.
 * @param guarantorReference A pointer style reference to a reference entity defined elsewhere in the document. Used when the reference entity is the guarantor.
 * @param standardReferenceObligation Indicates if the reference obligation is a Standard Reference Obligation. ISDA 2014 Term: Standard Reference Obligation.
 */
@Serializable
open class ReferenceObligation (
  var security: Security? = null,
  var loan: Loan? = null,
  var primaryObligor: LegalEntity? = null,
  var primaryObligorReference: ReferenceWithMetaLegalEntity? = null,
  var guarantor: LegalEntity? = null,
  var guarantorReference: String? = null,
  var standardReferenceObligation: Boolean? = null
)

@Serializable
open class ReferencePair (
  var referenceEntity: LegalEntity? = null,
  var referenceObligation: ReferenceObligation? = null,
  var noReferenceObligation: Boolean? = null,
  var entityType: FieldWithMetaEntityTypeEnum? = null
)

/**
 * This type contains all the reference pool items to define the reference entity and reference obligation(s) in the basket.
 *
 * @param referencePoolItem This type contains all the constituent weight and reference information.
 */
@Serializable
open class ReferencePool (
  var referencePoolItem: MutableList<ReferencePoolItem>? = null
)

/**
 * This type contains all the constituent weight and reference information.
 *
 * @param constituentWeight Describes the weight of each of the constituents within the basket. If not provided, it is assumed to be equal weighted.
 * @param referencePair 
 * @param protectionTermsReference Reference to the documentation terms applicable to this item.
 * @param cashSettlementTermsReference Reference to the cash settlement terms applicable to this item.
 * @param physicalSettlementTermsReference Reference to the physical settlement terms applicable to this item.
 */
@Serializable
open class ReferencePoolItem (
  var constituentWeight: ConstituentWeight? = null,
  var referencePair: ReferencePair? = null,
  var protectionTermsReference: ReferenceWithMetaProtectionTerms? = null,
  var cashSettlementTermsReference: ReferenceWithMetaCashSettlementTerms? = null,
  var physicalSettlementTermsReference: ReferenceWithMetaPhysicalSettlementTerms? = null
)

/**
 * A complex type used to specify the option and convertible bond option strike when expressed in reference to a swap curve.
 *
 * @param swapUnwindValue 
 * @param makeWholeAmount Amount to be paid by the buyer of the option if the option is exercised prior to the Early Call Date. (The market practice in the convertible bond option space being that the buyer should be penalised if he/she exercises the option early on.)
 */
@Serializable
open class ReferenceSwapCurve (
  var swapUnwindValue: SwapCurveValuation? = null,
  var makeWholeAmount: MakeWholeAmount? = null
)

/**
 * Represents a class to allow specification of different type of Regional government collateral.
 *
 * @param sovereignRecourse Applies to regional governments, local authorities or municipals.  True if entity has recourse to sovereign (e.g. debt guaranteed by government).  False if entity does not have recourse to sovereign.
 */
@Serializable
open class RegionalGovernmentIssuerType (
  var sovereignRecourse: Boolean? = null
)

@Serializable
open class RelatedParty (
  var partyReference: ReferenceWithMetaParty? = null,
  var accountReference: ReferenceWithMetaAccount? = null,
  var role: PartyRoleEnum? = null
)

/**
 * A class defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date). If the anchor date is itself an adjustable date then the offset is assumed to be calculated from the adjusted anchor date. A number of different scenarios can be supported, namely; 1) the derived date may simply be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date; 2) the unadjusted derived date may be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date with the resulting unadjusted derived date subject to adjustment in accordance with a specified business day convention, i.e. the derived date must fall on a good business day; 3) the derived date may be a number of business days preceding or following the anchor date. Note that the businessDayConvention specifies any required adjustment to the unadjusted derived date. A negative or positive value in the periodMultiplier indicates whether the unadjusted derived precedes or follows the anchor date. The businessDayConvention should contain a value NONE if the day type element contains a value of Business (since specifying a negative or positive business days offset would already guarantee that the derived date would fall on a good business day in the specified business centers).
 *
 * @param periodMultiplier A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
 * @param period A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
 * @param meta 
 * @param dayType In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
 * @param businessDayConvention The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
 * @param businessCenters 
 * @param businessCentersReference A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
 * @param dateRelativeTo Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
 * @param adjustedDate The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
 */
@Serializable
open class RelativeDateOffset (
  var businessDayConvention: BusinessDayConventionEnum? = null,
  var businessCenters: BusinessCenters? = null,
  var businessCentersReference: ReferenceWithMetaBusinessCenters? = null,
  var dateRelativeTo: BasicReferenceWithMetaDate? = null,
  var adjustedDate: Date? = null
)
: Offset()

/**
 * A class describing a set of dates defined as relative to another set of dates.
 *
 * @param periodMultiplier A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
 * @param period A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
 * @param meta 
 * @param dayType In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
 * @param businessDayConvention The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
 * @param businessCenters 
 * @param businessCentersReference A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
 * @param dateRelativeTo Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
 * @param adjustedDate The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
 * @param periodSkip The number of periods in the referenced date schedule that are between each date in the relative date schedule. Thus a skip of 2 would mean that dates are relative to every second date in the referenced schedule. If present this should have a value greater than 1.
 * @param scheduleBounds The first and last dates of a schedule. This can be used to restrict the range of values in a reference series of dates.
 */
@Serializable
open class RelativeDates (
  var periodSkip: Int? = null,
  var scheduleBounds: DateRange? = null
)
: RelativeDateOffset()

@Serializable
open class Representations (
)

/**
 * Defines the reset value or fixing value produced in cashflow calculations, during the life-cycle of a financial instrument. The reset process defined in Create_Reset function joins product definition details with observations to compute the reset value.
 *
 * @param resetValue Specifies the reset or fixing value. The fixing value could be a cash price, interest rate, or other value.
 * @param resetDate Specifies the date on which the reset occurred.
 * @param rateRecordDate Specifies the 'Rate Record Day' for a Fallback rate.  Fallback rate fixing processes typically set the fixing rate in arrears, i.e., the Fallback Rate corresponding to a Rate Record Date is set at the end of the interest accural period.  When this applies, Reset->resetDate occurs at the end of the interest period, and the Reset->rateRecordDate occurs near the start of the interest period.  The Reset->rateRecordDate and Reset->observations->observationIdentifier->observationDate will differ if a Fallback rate is unavailable on the Rate Record Date, and the latest previous available rate is used as the observation.
 * @param observations Represents an audit of the observations used to produce the reset value. If multiple observations were necessary to produce the reset value, the aggregation method should be defined on the payout.
 * @param averagingMethodology Identifies the aggregation method to use in the case where multiple observations are used to compute the reset value and the method is not defined in a payout.
 * @param meta 
 */
@Serializable
open class Reset (
  var resetValue: Price? = null,
  var resetDate: Date? = null,
  var rateRecordDate: Date? = null,
  var observations: MutableList<ReferenceWithMetaObservation>? = null,
  var averagingMethodology: AveragingCalculation? = null,
  var meta: MetaFields? = null
)

/**
 * A data defining:  the parameters used to generate the reset dates schedule and associated fixing dates. The reset dates are the dates on which the new index value (which is observed on the fixing date) is applied for each period and on which the interest rate hence begins to accrue.
 *
 * @param calculationPeriodDatesReference A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
 * @param resetRelativeTo Specifies whether the reset dates are determined with respect to each adjusted calculation period start date or adjusted calculation period end date. If the reset frequency is specified as daily this element must not be included.
 * @param initialFixingDate The initial fixing date.
 * @param fixingDates The fixing dates are the dates on which the index values are observed. The fixing dates are specified by reference to the reset date through business days offset and an associated set of financial business centers. Normally these offset calculation rules will be those specified in the ISDA definition for the relevant floating rate index (ISDA's Floating Rate Option). However, non-standard offset calculation rules may apply for a trade if mutually agreed by the principal parties to the transaction.
 * @param finalFixingDate This attribute is not part of the FpML ResetDate, and has been added as part of the CDM to support the credit derivatives final fixing date.
 * @param rateCutOffDaysOffset Specifies the number of business days before the period end date when the rate cut-off date is assumed to apply. The financial business centers associated with determining the rate cut-off date are those specified in the reset dates adjustments. The rate cut-off number of days must be a negative integer (a value of zero would imply no rate cut off applies in which case the rateCutOffDaysOffset element should not be included). The relevant rate for each reset date in the period from, and including, a rate cut-off date to, but excluding, the next applicable period end date (or, in the case of the last calculation period, the termination date) will (solely for purposes of calculating the floating amount payable on the next applicable payment date) be deemed to be the relevant rate in effect on that rate cut-off date. For example, if rate cut-off days for a daily averaging deal is -2 business days, then the refix rate applied on (period end date - 2 days) will also be applied as the reset on (period end date - 1 day), i.e. the actual number of reset dates remains the same but from the rate cut-off date until the period end date, the same refix rate is applied. Note that in the case of several calculation periods contributing to a single payment, the rate cut-off is assumed only to apply to the final calculation period contributing to that payment. The day type associated with the offset must imply a business days offset.
 * @param resetFrequency The frequency at which the reset dates occur. In the case of a weekly reset frequency, also specifies the day of the week that the reset occurs. If the reset frequency is greater than the calculation period frequency then this implies that more than one reset is established for each calculation period and some form of rate averaging is applicable.
 * @param resetDatesAdjustments The definition of the business day convention and financial business centers used for adjusting the reset date if it would otherwise fall on a day that is not a business day in the specified business center.
 * @param meta 
 */
@Serializable
open class ResetDates (
  var calculationPeriodDatesReference: ReferenceWithMetaCalculationPeriodDates? = null,
  var resetRelativeTo: ResetRelativeToEnum? = null,
  var initialFixingDate: InitialFixingDate? = null,
  var fixingDates: RelativeDateOffset? = null,
  var finalFixingDate: AdjustableDate? = null,
  var rateCutOffDaysOffset: Offset? = null,
  var resetFrequency: ResetFrequency? = null,
  var resetDatesAdjustments: BusinessDayAdjustments? = null,
  var meta: MetaFields? = null
)

/**
 * A class defining the reset frequency. In the case of a weekly reset, also specifies the day of the week that the reset occurs. If the reset frequency is greater than the calculation period frequency the this implies that more or more reset dates is established for each calculation period and some form of rate averaging is applicable. The specific averaging method of calculation is specified in FloatingRateCalculation. In case the reset frequency is of value T (term), the period is defined by the swap/swapStream/calculationPerioDates/effectiveDate and the swap/swapStream/calculationPerioDates/terminationDate.
 *
 * @param periodMultiplier A time period multiplier, e.g. 1, 2, or 3. If the period value is T (Term) then period multiplier must contain the value 1.
 * @param period A time period, e.g. a day, week, month, year or term of the stream.
 * @param meta 
 * @param weeklyRollConvention The day of the week on which a weekly reset date occurs. This element must be included if the reset frequency is defined as weekly and not otherwise.
 */
@Serializable
open class ResetFrequency (
  var weeklyRollConvention: WeeklyRollConventionEnum? = null
)
: Frequency()

/**
 * Defines the information needed to create a Reset Business Event. 
 *
 * @param payout 
 * @param rateRecordDate Specifies the 'Rate Record Day' for a Fallback rate.  Fallback rate fixing processes typically set the fixing rate in arrears, i.e., the Fallback Rate corresponding to a Rate Record Date is set at the end of the interest accural period.  When this applies, Reset->resetDate occurs at the end of the interest period, and the Reset->rateRecordDate occurs near the start of the interest period.  The Reset->rateRecordDate and Reset->observations->observationIdentifier->observationDate will differ if a Fallback rate is unavailable on the Rate Record Date, and the latest previous available rate is used as the observation.
 * @param resetDate Specifies the date on which the reset is occuring.
 */
@Serializable
open class ResetInstruction (
  var payout: MutableList<ReferenceWithMetaPayout>? = null,
  var rateRecordDate: Date? = null,
  var resetDate: Date? = null
)

/**
 * Generic class to specify the quantity for different payout legs in a contractual product, when that quantity can vary across payout legs or across time. A resolvable quantity can always be resolved into a single quantity from the quantity notation which has a corresponding asset identifier. In addition to the base case, where quantity is directly specified as a number as part of the quantity notation, the other use cases are: (i) quantity based on some pre-defined schedule (eg amortising notional), (ii) quantity based on some pre-defined events (eg resetting cross-currency notional), or quantity set as reference to another quantity (eg equity notional as no. securities x price).
 *
 * @param resolvedQuantity A product's quantity as a single, non-negative amount.  When specified as part of a product definition, this quantity attribute would not be set.  Instead it is specified on the quantity notation along with an asset identifier matching this payout's asset identifier.  This allows the quantity to be resolved for a payout leg, which can then be specified here for convenience during data processing.  There needs to be at least one resolvable quantity across payout legs of a product to define an anchor that other payout quantities can refer to.  This attribute is ignored when mapping existing FpML messages.
 * @param quantitySchedule A payout's quantity specified as a schedule, which may also contain a single value if that quantity is constant. There can only be a single quantity schedule applicable to a payout: e.g. the notional for an interest rate leg. The quantity must be specified outside of the payout in a PriceQuantity object and only referenced inside the payout using an address.
 * @param quantityReference Reference quantity when resolvable quantity is defined as relative to another (resolvable) quantity. A resolvable quantity needs to contain either an absolute quantity or a reference to another (resolvable) quantity. This requirement is captured by a choice rule on the class.
 * @param quantityMultiplier Quantity multiplier is specified on top of a reference quantity and is used as a multiplying factor when resolving the quantity. A quantity multiplier can only exist when the resolvable quantity specifies a reference quantity.
 * @param reset Whether the quantity is resettable
 * @param futureValueNotional The future value notional is specific to BRL CDI swaps, and is specified alongside the notional amount. The value is calculated as follows: Future Value Notional = Notional Amount * (1 + Fixed Rate) ^ (Fixed Rate Day Count Fraction). The currency should always match that expressed in the notional schedule. The value date should match the adjusted termination date.
 * @param priceSchedule A payout's price specified as a schedule, which may also contain a single value if that price is constant. There may be multiple prices specified for a single payout: e.g. a floating interest rate leg may specify a spread, a cap and/or floor and a multiplier. The price must be specified outside of the payout in a PriceQuantity object and only referenced inside the payout using an address.
 * @param meta 
 */
@Serializable
open class ResolvablePriceQuantity (
  var resolvedQuantity: Quantity? = null,
  var quantitySchedule: ReferenceWithMetaNonNegativeQuantitySchedule? = null,
  var quantityReference: ReferenceWithMetaResolvablePriceQuantity? = null,
  var quantityMultiplier: QuantityMultiplier? = null,
  var reset: Boolean? = null,
  var futureValueNotional: FutureValueAmount? = null,
  var priceSchedule: MutableList<ReferenceWithMetaPriceSchedule>? = null,
  var meta: MetaFields? = null
)

/**
 * Describes the resource that contains the media representation of a business event (i.e used for stating the Publicly Available Information). For example, can describe a file or a URL that represents the event. This type is an extended version of a type defined by RIXML (www.rixml.org).  Rosetta restricts the FpML implementation by not providing the ability to associated a document in hexadecimalBinary or base64Binary until such time that actual use cases will come up.
 *
 * @param resourceId The unique identifier of the resource within the event. FpML specifies this element of type resourceIdScheme but with no specified value.
 * @param resourceType A description of the type of the resource, e.g. a confirmation.
 * @param language Indicates the language of the resource, described using the ISO 639-2/T Code.
 * @param sizeInBytes Indicates the size of the resource in bytes. It could be used by the end user to estimate the download time and storage needs.
 * @param length Indicates the length of the resource. For example, if the resource were a PDF file, the length would be in pages.
 * @param mimeType Indicates the type of media used to store the content. mimeType is used to determine the software product(s) that can read the content. MIME Types are described in RFC 2046.
 * @param name The name of the resource.  It is specified as a NormalizedString in FpML.
 * @param comments Any additional comments that are deemed necessary. For example, which software version is required to open the document? Or, how does this resource relate to the others for this event?
 * @param string Provides extra information as string. In case the extra information is in XML format, a CDATA section must be placed around the source message to prevent its interpretation as XML content.
 * @param url Indicates where the resource can be found, as a URL that references the information on a web server accessible to the message recipient.
 */
@Serializable
open class Resource (
  var resourceId: FieldWithMetaString? = null,
  var resourceType: FieldWithMetaResourceTypeEnum? = null,
  var language: FieldWithMetaString? = null,
  var sizeInBytes: Float? = null,
  var length: ResourceLength? = null,
  var mimeType: FieldWithMetaString? = null,
  var name: String? = null,
  var comments: String? = null,
  var string: String? = null,
  var url: String? = null
)

/**
 * A class to indicate the length of the resource.
 *
 * @param lengthUnit The length unit of the resource. For example, pages (pdf, text documents) or time (audio, video files).
 * @param lengthValue The length value of the resource.
 */
@Serializable
open class ResourceLength (
  var lengthUnit: LengthUnitEnum? = null,
  var lengthValue: Float? = null
)

@Serializable
open class Restructuring (
  var applicable: Boolean? = null,
  var restructuringType: FieldWithMetaRestructuringEnum? = null,
  var multipleHolderObligation: Boolean? = null,
  var multipleCreditEventNotices: Boolean? = null
)

/**
 * A class to specify the application of Interest Amount with respect the Return Amount.
 *
 * @param includesDefaultLanguage Default language is included when True, and excluded when False.
 * @param customElection Custom election that might be specified by the parties to the agreement.
 */
@Serializable
open class ReturnAmount (
  var includesDefaultLanguage: Boolean? = null,
  var customElection: String? = null
)

/**
 * Specifies the information required to create the return of a Security Finance Transaction.
 *
 * @param quantity Specifies the quantity of shares and cash to be returned in a partial return event.
 */
@Serializable
open class ReturnInstruction (
  var quantity: MutableList<Quantity>? = null
)

/**
 * Specifies the type of return of a performance payout.
 *
 * @param priceReturnTerms Return terms based upon the underlier's observed price.
 * @param dividendReturnTerms Return terms based upon dividend payments associated to the underlier.
 * @param varianceReturnTerms Return terms based upon the observed variance of the underlier's price.
 * @param volatilityReturnTerms Return terms based upon the observed volatility of the underlier's price.
 * @param correlationReturnTerms Return terms based upon the observed correlation between the components of the underlying basket.
 */
@Serializable
open class ReturnTerms (
  var priceReturnTerms: PriceReturnTerms? = null,
  var dividendReturnTerms: DividendReturnTerms? = null,
  var varianceReturnTerms: VarianceReturnTerms? = null,
  var volatilityReturnTerms: VolatilityReturnTerms? = null,
  var correlationReturnTerms: CorrelationReturnTerms? = null
)

/**
 * Contains all common elements in variance, volatility and correlation return Terms.
 *
 * @param valuationTerms Contains all non-date valuation information.
 * @param annualizationFactor This specifies the numerator of an annualization factor. Frequently this number is equal to the number of observations of prices in a year e.g. 252.
 * @param dividendApplicability The parameters which define whether dividends are applicable
 * @param equityUnderlierProvisions Contains Equity Underlyer provisions regarding jurisdiction and fallbacks.
 * @param sharePriceDividendAdjustment Indicates whether the price of shares is adjusted for dividends or not.
 * @param expectedN Expected number of trading days.
 * @param initialLevel Contract will strike off this initial level. Providing just the initialLevel without initialLevelSource, infers that this is AgreedInitialPrice - a specified Initial Index Level.
 * @param initialLevelSource In this context, this is AgreedInitialPrice - a specified Initial Index Level.
 * @param meanAdjustment Specifies whether Mean Adjustment is applicable or not in the calculation of the Realized Volatility, Variance or Correlation
 * @param performance Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.
 */
@Serializable
open class ReturnTermsBase (
  var valuationTerms: ValuationTerms? = null,
  var annualizationFactor: Int? = null,
  var dividendApplicability: DividendApplicability? = null,
  var equityUnderlierProvisions: EquityUnderlierProvisions? = null,
  var sharePriceDividendAdjustment: Boolean? = null,
  var expectedN: Int? = null,
  var initialLevel: Float? = null,
  var initialLevelSource: DeterminationMethodEnum? = null,
  var meanAdjustment: Boolean? = null,
  var performance: String? = null
)

/**
 * Used in conjunction with an exchange-based pricing source. Identifies a way in which the futures contracts referenced will roll between periods. 
 *
 * @param rollSourceCalendar Used in conjunction with an exchange-based pricing source. Identifies a date source calendar from which the pricing dates and thus roll to the next contract will be based off (e.g. pricing is based on the NYMEX WTI First Nearby Futures Contract, if Future is chosen, the pricing will roll to the next futures contract on expiration, if ListedOption is chosen, the pricing will roll to the next futures contract on the Option expiration date which is three business days before the expiration of the NYMEX WTI futures contract.) Omitting this element will result in the default behavior expected with the pricing source described within the commodity element.
 * @param deliveryDateRollConvention Specifies, for a Commodity Transaction that references a delivery date for a listed future, the day on which the specified future will roll to the next nearby month prior to the expiration of the referenced future. If the future will not roll at all - i.e. the price will be taken from the expiring contract, 0 should be specified here. If the future will roll to the next nearby on the last trading day - i.e. the price will be taken from the next nearby on the last trading day, then 1 should be specified and so on.
 */
@Serializable
open class RollFeature (
  var rollSourceCalendar: RollSourceCalendarEnum? = null,
  var deliveryDateRollConvention: Offset? = null
)

/**
 * Defines rounding rules and precision to be used in the rounding of a number.
 *
 * @param roundingDirection Specifies the rounding rounding rule as up, down, or nearest.
 * @param precision Specifies the rounding precision in terms of a number of decimal places when the number is evaluated in decimal form (not percentage), e.g. 0.09876543 rounded to the nearest 5 decimal places is  0.0987654.
 */
@Serializable
open class Rounding (
  var roundingDirection: RoundingDirectionEnum? = null,
  var precision: Int? = null
)

/**
 * A class defining a schedule of rates or amounts in terms of an initial value and then a series of step date and value pairs. On each step date the rate or amount changes to the new step value. The series of step date and value pairs are optional. If not specified, this implies that the initial value remains unchanged over time.
 *
 * @param value The initial rate or amount, as the case may be. An initial rate of 5% would be represented as 0.05.
 * @param datedValue The schedule of step date and value pairs. On each step date the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
 */
@Serializable
open class Schedule (
  var value: Float? = null,
  var datedValue: MutableList<DatedValue>? = null
)

/**
 * A class that defines the period of a schedule. The period contains a set of start and end dates, quantities, fixing, and pricing data.
 *
 * @param calculationPeriod Period for which the payment is generated.
 * @param paymentDate Adjusted payment date.
 * @param fixingPeriod Period over which the underlying price is observed.
 * @param deliveryPeriod Period and time profile over which the delivery takes place.
 */
@Serializable
open class SchedulePeriod (
  var calculationPeriod: DateRange? = null,
  var paymentDate: Date? = null,
  var fixingPeriod: DateRange? = null,
  var deliveryPeriod: CalculationScheduleDeliveryPeriods? = null
)

@Serializable
open class ScheduledTransfer (
  var transferType: ScheduledTransferEnum? = null,
  var corporateActionTransferType: CorporateActionTypeEnum? = null
)

@Serializable
open class SchmeNm (
  var prtry: String? = null
)

/**
 * Identifies a security by referencing an identifier and by specifying the sector.
 *
 * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
 * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
 * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
 * @param exchange If the Asset is listed, defines the public exchange of the listing.
 * @param relatedExchange Provides the related Exchanges, if applicable.
 * @param instrumentType Identifies the type of an instrument using an enumerated list.
 * @param debtType Identifies the type of debt and selected debt economics.
 * @param equityType Identifies the type of equity.
 * @param fundType Identifies the type of fund.
 */
@Serializable
open class Security (
  var debtType: DebtType? = null,
  var equityType: EquityTypeEnum? = null,
  var fundType: FundProductTypeEnum? = null
)
: InstrumentBase()

/**
 * The set of elections which specify a Security Agremeent
 *
 */
@Serializable
open class SecurityAgreementElections (
)

/**
 * Specifies the information required for inclusion in a securities lending billing invoice.
 *
 * @param sendingParty The party issuing the invoice
 * @param receivingParty The party receiving the invoice
 * @param billingStartDate The starting date of the period described by this invoice
 * @param billingEndDate The ending date of the period described by this invoice
 * @param billingRecord The billing records contained within the invoice
 * @param billingSummary The billing summaries contained within the invoice
 * @param meta 
 */
@Serializable
open class SecurityLendingInvoice (
  var sendingParty: Party? = null,
  var receivingParty: Party? = null,
  var billingStartDate: Date? = null,
  var billingEndDate: Date? = null,
  var billingRecord: MutableList<BillingRecord>? = null,
  var billingSummary: MutableList<BillingSummary>? = null,
  var meta: MetaFields? = null
)

/**
 * A locate is an approval from a broker that needs to be obtained prior to effecting a short sale in an equity security. Similar to security availability, a borrower can request a single or multiple securities, but at least one must be requested.
 *
 * @param availableInventoryType Defines the purpose of this inventory.
 * @param messageInformation Allows details related to the availability messaging use case to be defined
 * @param party Defines all parties involved for the list of inventory records in this set of inventory. For example, when used to describe securities lending availability, this could hold the sender of the availability, the intended recipient, the beneficial owner(s), the lender (which may differ from the sender as the lender may have the same piece of availability going through multiple agents), an agent or a venue.
 * @param partyRole Defines the role(s) that party(ies) may have in relation to the inventory.
 * @param availableInventoryRecord An array holding the list of inventory being described. Each element in the inventoryRecord array represents an individual piece of inventory i.e. a security.
 */
@Serializable
open class SecurityLocate (
)
: AvailableInventory()

@Serializable
open class Sellr (
  var acctOwnr: AcctOwnr? = null
)

/**
 * A class to specify the Relevant Settled Entity Matrix.
 *
 * @param matrixSource Relevant settled entity matrix source.
 * @param publicationDate Specifies the publication date of the applicable version of the matrix. When this element is omitted, the Standard Terms Supplement defines rules for which version of the matrix is applicable.
 */
@Serializable
open class SettledEntityMatrix (
  var matrixSource: FieldWithMetaSettledEntityMatrixSourceEnum? = null,
  var publicationDate: Date? = null
)

/**
 * A base class to be extended by the SettlementTerms class.
 *
 * @param settlementType Whether the settlement will be cash, physical, by election, ...
 * @param transferSettlementType The qualification as to how the transfer will settle, e.g. a DvP settlement.
 * @param settlementCurrency The settlement currency is to be specified when the Settlement Amount cannot be known in advance. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
 * @param settlementDate The date on which the settlement amount will be paid, subject to adjustment in accordance with any applicable business day convention. This component would not be present for a mandatory early termination provision where the cash settlement payment date is the mandatory early termination date.
 * @param settlementCentre Optional settlement centre as an enumerated list: Euroclear, Clearstream.
 * @param settlementProvision Optionally defines the parameters that regulate a settlement.
 * @param standardSettlementStyle Settlement Style.
 * @param meta 
 */
@Serializable
open class SettlementBase (
  var settlementType: SettlementTypeEnum? = null,
  var transferSettlementType: TransferSettlementEnum? = null,
  var settlementCurrency: FieldWithMetaString? = null,
  var settlementDate: SettlementDate? = null,
  var settlementCentre: SettlementCentreEnum? = null,
  var settlementProvision: SettlementProvision? = null,
  var standardSettlementStyle: StandardSettlementStyleEnum? = null,
  var meta: MetaFields? = null
)

/**
 * A data defining the settlement date(s) for cash or physical settlement as either a set of explicit dates, together with applicable adjustments, or as a date relative to some other (anchor) date, or as any date in a range of contiguous business days. This data type provides a level of abstraction on top of the different legacy methods used to specify a settlement / payment date, which vary across product types, asset classes and delivery types.
 *
 * @param adjustableOrRelativeDate A single settlement date subject to adjustment or specified as relative to another date (e.g. the trade date). This attribute was formerly part of 'SettlementTerms', which is now being harmonised to include a common 'SettlementDate', as inherited from 'SettlementBase'.
 * @param valueDate The settlement date for a forward settling product. For Foreign Exchange contracts, this represents a common settlement date between both currency legs. To specify different settlement dates for each currency leg, see the ForeignExchange class. This attribute was formerly part of 'SettlementTerms', which is now being harmonised to include a common 'SettlementDate', as inherited from 'SettlementBase'.
 * @param adjustableDates A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date. This attributes was formerly part of 'CashSettlementPaymentDate' as included into 'OptionCashSettlement' (which is now merged into a unique 'CashSettlementTerms' data type.
 * @param businessDateRange A range of contiguous business days. This attribute is meant to be merged with the 'settlementDate' at some future point once we refactor 'Date' to use a single complex type across the model. This attributes was formerly part of 'CashSettlementPaymentDate', as included into 'OptionCashSettlement' (which is now merged into a unique 'CashSettlementTerms' data type.
 * @param cashSettlementBusinessDays The number of business days used in the determination of the cash settlement payment date. If a cash settlement amount is specified, the cash settlement payment date will be this number of business days following the calculation of the final price. If a cash settlement amount is not specified, the cash settlement payment date will be this number of business days after all conditions to settlement are satisfied. ISDA 2003 Term: Cash Settlement Date. This attribute was formerly part of 'CashSettlementTerms' as used for credit event settlement, which now includes a common 'SettlementDate' attribute.
 * @param paymentDelay Applicable to CDS on MBS to specify whether payment delays are applicable to the fixed Amount. RMBS typically have a payment delay of 5 days between the coupon date of the reference obligation and the payment date of the synthetic swap. CMBS do not, on the other hand, with both payment dates being on the 25th of each month.
 * @param meta 
 */
@Serializable
open class SettlementDate (
  var adjustableOrRelativeDate: AdjustableOrAdjustedOrRelativeDate? = null,
  var valueDate: Date? = null,
  var adjustableDates: AdjustableDates? = null,
  var businessDateRange: BusinessDateRange? = null,
  var cashSettlementBusinessDays: Int? = null,
  var paymentDelay: Boolean? = null,
  var meta: MetaFields? = null
)

/**
 * Represents a forward settling payout. The underlier attribute captures the underlying payout, which is settled according to the settlementTerms attribute (which is part of PayoutBase). Both FX Spot and FX Forward should use this component.
 *
 * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
 * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
 * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
 * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
 * @param underlier The underlying financial product that will be physically or cash settled, which can be of any type, eg an asset such as cash or a security, or the cash settlement of an index rate.
 * @param deliveryTerm Also called contract month or delivery month. However, it's not always a month. It is usually expressed using a code, e.g. Z23 would be the Dec 2023 contract, (Z = December). For crude oil, the corresponding contract might be called CLZ23.
 * @param delivery Contains the information relative to the delivery of the asset.
 * @param schedule Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
 */
@Serializable
open class SettlementPayout (
  var underlier: Underlier? = null,
  var deliveryTerm: String? = null,
  var delivery: AssetDeliveryInformation? = null,
  var schedule: CalculationSchedule? = null
)
: PayoutBase()

/**
 * Defines parameters that regulate a settlement, for instance whether this settlement should be netted with other ones or broken-down into smaller amounts.
 *
 * @param shapingProvisions Defines the parameters that are necessary to 'shape' a settlement, i.e. break it down into smaller amounts.
 */
@Serializable
open class SettlementProvision (
  var shapingProvisions: ShapingProvision? = null
)

/**
 * Defines the settlement rate option to use for fixing in case of cash settlement. Currently only applicable to foreign exchange fixing in case of cross-currency settlement.
 *
 * @param settlementRateOption The rate source for the conversion to the settlement currency. This source is specified through a scheme that reflects the terms of the Annex A to the 1998 FX and Currency Option Definitions.
 * @param priceSourceDisruption An attribute defining the parameters to get a new quote when a settlement rate option is disrupted.
 */
@Serializable
open class SettlementRateOption (
  var settlementRateOption: FieldWithMetaSettlementRateOptionEnum? = null,
  var priceSourceDisruption: PriceSourceDisruption? = null
)

/**
 * Specifies the settlement terms, which can either be cash, physical, or fx-based cash-settlement. This class can be used for the settlement of options and forwards, cash transactions (e.g. securities or foreign exchange), or in case of credit event.
 *
 * @param settlementType Whether the settlement will be cash, physical, by election, ...
 * @param transferSettlementType The qualification as to how the transfer will settle, e.g. a DvP settlement.
 * @param settlementCurrency The settlement currency is to be specified when the Settlement Amount cannot be known in advance. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
 * @param settlementDate The date on which the settlement amount will be paid, subject to adjustment in accordance with any applicable business day convention. This component would not be present for a mandatory early termination provision where the cash settlement payment date is the mandatory early termination date.
 * @param settlementCentre Optional settlement centre as an enumerated list: Euroclear, Clearstream.
 * @param settlementProvision Optionally defines the parameters that regulate a settlement.
 * @param standardSettlementStyle Settlement Style.
 * @param meta 
 * @param cashSettlementTerms Specifies the parameters associated with the cash settlement procedure.
 * @param physicalSettlementTerms Specifies the physical settlement terms which apply to the transaction.
 */
@Serializable
open class SettlementTerms (
  var cashSettlementTerms: MutableList<CashSettlementTerms>? = null,
  var physicalSettlementTerms: PhysicalSettlementTerms? = null
)
: SettlementBase()

/**
 * Defines the applicable settlement limits that may require a settlement to be 'shaped', i.e. broken-down into smaller amounts.
 *
 * @param shapeSchedule Defines applicable settlement limits in each currency.
 */
@Serializable
open class ShapingProvision (
  var shapeSchedule: MutableList<Money>? = null
)

/**
 * A class to specify the number of business days after satisfaction of all conditions to settlement.
 *
 * @param businessDays A number of business days. Its precise meaning is dependant on the context in which this element is used. ISDA 2003 Term: Business Day.
 */
@Serializable
open class SingleValuationDate (
  var businessDays: Int? = null
)

@Serializable
open class Sngl (
  var isin: String? = null,
  var indx: Indx? = null
)

@Serializable
open class SovereignAgencyRating (
  var sovereignAgencyRating: AgencyRatingCriteria? = null
)

/**
 * Represents a class to allow specification of different types of special purpose vehicle (SPV) collateral.
 *
 * @param creditRisk Indicates tranched or untranched credit risk.
 */
@Serializable
open class SpecialPurposeVehicleIssuerType (
  var creditRisk: CreditRiskEnum? = null
)

/**
 * A single, specifically identified Asset chosen from the Asset data type
 *
 * @param Cash An Asset that consists solely of a monetary holding in a currency.
 * @param Commodity An Asset comprised of raw or refined materials or agricultural products, eg gold, oil or wheat.
 * @param DigitalAsset An Asset that exists only in digital form, eg Bitcoin or Ethereum; excludes the digital representation of other Assets.
 * @param Instrument An asset that is issued by one party to one or more others; Instrument is also a choice data type.
 */
@Serializable
open class SpecificAsset (
)
: Asset()

@Serializable
open class SpecifiedCurrency (
  var applicable: Boolean? = null,
  var currency: FieldWithMetaString? = null
)

/**
 * Specifies instructions for a split, consisting of a breakdown of instructions to be applied to each branch of the split. This instruction can be used to duplicate a trade, as in a clearing scenario, or to split a trade into smaller quantities (in which case each breakdown instruction needs to include a quantity change), as in an allocation.
 *
 * @param breakdown Each split breakdown specifies the set of primitive instructions to be applied to a single branch of that split. N split breakdowns result in N output trades, which include the original trade. Instructions for how to handle the original trade (e.g. if it must be closed) must be specified in one of the breakdowns.
 */
@Serializable
open class SplitInstruction (
  var breakdown: MutableList<PrimitiveInstruction>? = null
)

/**
 * Adds an optional spread type element to the Schedule to identify a long or short spread value.
 *
 * @param price The initial rate. An initial rate of 5% would be represented as 0.05.
 * @param spreadScheduleType An element which purpose is to identify a long or short spread value.
 */
@Serializable
open class SpreadSchedule (
  var spreadScheduleType: FieldWithMetaSpreadScheduleTypeEnum? = null
)
: RateSchedule()

@Serializable
open class StandardizedSchedule (
  var assetClass: StandardizedScheduleAssetClassEnum? = null,
  var productClass: StandardizedScheduleProductClassEnum? = null,
  var notional: Float? = null,
  var notionalCurrency: String? = null,
  var durationInYears: Float? = null
)

@Serializable
open class StandardizedScheduleInitialMargin (
  var tradeInfo: MutableList<StandardizedScheduleTradeInfo>? = null,
  var netInitialMargin: Money? = null
)

@Serializable
open class StandardizedScheduleTradeInfo (
  var assetClass: StandardizedScheduleAssetClassEnum? = null,
  var productClass: StandardizedScheduleProductClassEnum? = null,
  var grossInitialMargin: Money? = null,
  var markToMarketValue: Money? = null
)

/**
 * Defines the state of a trade at a point in the Trade's life cycle. Trades have many state dimensions, all of which are represented here. For example, states useful for position keeping are represented alongside those needed for regulatory reporting.
 *
 * @param closedState Represents the qualification of what led to the trade's closure alongside the dates on which this closure took effect.
 * @param positionState Identifies the state of the position, to distinguish if just executed, formed, already settled, closed, etc.
 */
@Serializable
open class State (
  var closedState: ClosedState? = null,
  var positionState: PositionStatusEnum? = null
)

/**
 * Data required to perform a stock split business event.
 *
 * @param adjustmentRatio The number that denotes the cumulative quantity of post-split shares issued to shareholders versus the quantity of pre-split shares previously issued to shareholders.  This number will be multiplied by existing shares in an equity derivative contract or other positions to determine the post-split number of shares.  With regard to any reference to price, the pre-split reference price will be divided by this number to determine the post-split reference price.
 * @param effectiveDate The effective date of the stock split, also known as the ex-date. This is the date on which the additional shares are paid to the shareholders, or in the case of a reverse stock split, the number shares held by each shareholder is proportionally reduced.  Equity derivative transactions can be amended in firms' internal systems on such date.   In most markets, the listed stock price is reduced (or increased for a reverse stock split) to account for the split on the same date, but in some markets the price adjustment occurs on a later date.  In either case, equity derivative transactions should be amended on the date that the stocks are paid to the shareholders (or consolidated).
 */
@Serializable
open class StockSplitInstruction (
  var adjustmentRatio: Float? = null,
  var effectiveDate: Date? = null
)

/**
 * A class for defining option strategy features.
 *
 * @param strikeSpread Definition of the upper strike in a strike spread.
 * @param calendarSpread Definition of the later expiration date in a calendar spread.
 */
@Serializable
open class StrategyFeature (
  var strikeSpread: StrikeSpread? = null,
  var calendarSpread: CalendarSpread? = null
)

/**
 * A class describing a single cap or floor rate.
 *
 * @param strikeRate The rate for a cap or floor.
 * @param buyer The buyer of the option.
 * @param seller The party that has sold.
 * @param meta 
 */
@Serializable
open class Strike (
  var strikeRate: Float? = null,
  var buyer: PayerReceiverEnum? = null,
  var seller: PayerReceiverEnum? = null,
  var meta: MetaFields? = null
)

/**
 * A class describing a schedule of cap or floor rates.
 *
 * @param price The initial rate. An initial rate of 5% would be represented as 0.05.
 * @param buyer The buyer of the option.
 * @param seller The party that has sold.
 */
@Serializable
open class StrikeSchedule (
  var buyer: PayerReceiverEnum? = null,
  var seller: PayerReceiverEnum? = null
)
: RateSchedule()

/**
 * A class for defining a strike spread feature.
 *
 * @param upperStrike Upper strike in a strike spread.
 * @param upperStrikeNumberOfOptions Number of options at the upper strike price in a strike spread.
 */
@Serializable
open class StrikeSpread (
  var upperStrike: OptionStrike? = null,
  var upperStrikeNumberOfOptions: Float? = null
)

/**
 * A data defining:  how the initial or final stub calculation period amounts is calculated. For example, the rate to be applied to the initial or final stub calculation period may be the linear interpolation of two different tenors for the floating rate index specified in the calculation period amount component, e.g. A two month stub period may used the linear interpolation of a one month and three month floating rate. The different rate tenors would be specified in this component. Note that a maximum of two rate tenors can be specified. If a stub period uses a single index tenor and this is the same as that specified in the calculation period amount component then the initial stub or final stub component, as the case may be, must not be included.
 *
 * @param calculationPeriodDatesReference A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
 * @param initialStub Specifies how the initial stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
 * @param finalStub Specifies how the final stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
 */
@Serializable
open class StubCalculationPeriodAmount (
  var calculationPeriodDatesReference: ReferenceWithMetaCalculationPeriodDates? = null,
  var initialStub: StubValue? = null,
  var finalStub: StubValue? = null
)

/**
 * A class defining a floating rate.
 *
 * @param floatingRateIndex The floating rate index.
 * @param indexTenor The ISDA Designated Maturity, i.e. the tenor of the floating rate.
 * @param floatingRateMultiplierSchedule A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
 * @param spreadSchedule The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
 * @param rateTreatment The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
 * @param capRateSchedule The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
 * @param floorRateSchedule The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
 */
@Serializable
open class StubFloatingRate (
  var floatingRateIndex: FloatingRateIndexEnum? = null,
  var indexTenor: Period? = null,
  var floatingRateMultiplierSchedule: Schedule? = null,
  var spreadSchedule: MutableList<SpreadSchedule>? = null,
  var rateTreatment: RateTreatmentEnum? = null,
  var capRateSchedule: MutableList<StrikeSchedule>? = null,
  var floorRateSchedule: MutableList<StrikeSchedule>? = null
)

/**
 *  A class defining how the initial or final stub calculation period amounts is calculated. For example, the rate to be applied to the initial or final stub calculation period may be the linear interpolation of two different tenors for the floating rate index specified in the calculation period amount component, e.g. A two month stub period may used the linear interpolation of a one month and three month floating rate. The different rate tenors would be specified in this component. Note that a maximum of two rate tenors can be specified. If a stub period uses a single index tenor and this is the same as that specified in the calculation period amount component then the initial stub or final stub component, as the case may be, must not be included.
 *
 * @param calculationPeriodDatesReference A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
 * @param initialStub Specifies how the initial stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
 * @param finalStub Specifies how the final stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
 */
@Serializable
open class StubPeriod (
  var calculationPeriodDatesReference: ReferenceWithMetaCalculationPeriodDates? = null,
  var initialStub: StubValue? = null,
  var finalStub: StubValue? = null
)

/**
 * A type defining how a stub calculation period amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating rate tenors many be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3 Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
 *
 * @param floatingRate The rates to be applied to the initial or final stub may be the linear interpolation of two different rates. While the majority of the time, the rate indices will be the same as that specified in the stream and only the tenor itself will be different, it is possible to specift two different rates. For example, a 2 month stub period may use the linear interpolation of a 1 month and 3 month rate. The different rates would be specified in this component. Note that a maximum of two rates can be specified. If a stub period uses the same floating rate index, including tenor, as the regular calculation periods then this should not be specified again within this component, i.e. the stub calculation period amount component may not need to be specified even if there is an initial or final stub period. If a stub period uses a different floating rate index compared to the regular calculation periods then this should be specified within this component. If specified here, they are likely to have id attributes, allowing them to be referenced from within the cashflows component.
 * @param stubRate An actual rate to apply for the initial or final stub period may have been agreed between the principal parties (in a similar way to how an initial rate may have been agreed for the first regular period). If an actual stub rate has been agreed then it would be included in this component. It will be a per annum rate, expressed as a decimal. A stub rate of 5% would be represented as 0.05.
 * @param stubAmount An actual amount to apply for the initial or final stub period may have been agreed between the two parties. If an actual stub amount has been agreed then it would be included in this component.
 */
@Serializable
open class StubValue (
  var floatingRate: MutableList<StubFloatingRate>? = null,
  var stubRate: Float? = null,
  var stubAmount: Money? = null
)

/**
 * Defines collateral substitution provisions such as how many and with how much notice are substitutions allowed.
 *
 * @param numberOfSubstitutionsAllowed Specifies if 1 or more substitutions are allowed.
 * @param noticeDeadlinePeriod Defines the min period for notify of a substitution.
 * @param noticeDeadlineDateTime A specific date and time for the notice deadline
 */
@Serializable
open class SubstitutionProvisions (
  var numberOfSubstitutionsAllowed: Int? = null,
  var noticeDeadlinePeriod: Period? = null,
  var noticeDeadlineDateTime: Date? = null
)

/**
 * A class to specify a valuation swap curve, which is used as part of the strike construct for the bond and convertible bond options.
 *
 * @param floatingRateIndex 
 * @param indexTenor The ISDA Designated Maturity, i.e. the tenor of the floating rate.
 * @param spread Spread in basis points over the floating rate index.
 * @param side The side (bid/mid/ask) of the measure.
 */
@Serializable
open class SwapCurveValuation (
  var floatingRateIndex: FloatingRateIndexEnum? = null,
  var indexTenor: Period? = null,
  var spread: Float? = null,
  var side: QuotationSideEnum? = null
)

@Serializable
open class Swp (
  var swpIn: SwpIn? = null,
  var swpOut: SwpOut? = null
)

@Serializable
open class SwpIn (
  var sngl: Sngl? = null
)

@Serializable
open class SwpOut (
  var sngl: Sngl? = null
)

/**
 * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object).
 *
 * @param source The source of the taxonomy that defines the rules for classifying the object. The taxonomy source is taken from a enumerated list of taxonomy names. Optional as the taxonomy source may not be provided.
 * @param value The value according to that taxonomy. Optional as it may not be possible to classify the object in that taxonomy.
 */
@Serializable
open class Taxonomy (
  var source: TaxonomySourceEnum? = null,
  var value: TaxonomyValue? = null
)

@Serializable
open class TaxonomyClassification (
  var className: String? = null,
  var value: String? = null,
  var description: String? = null,
  var ordinal: Int? = null
)

/**
 * Defines a taxonomy value as either a simple string or a more granular expression with class names and values for each class.
 *
 * @param name Specifies the taxonomy value as a simple string, which may be associated to an external scheme.
 * @param classification Specifies the taxonomy value as a set of class names and values for each class.
 */
@Serializable
open class TaxonomyValue (
  var name: FieldWithMetaString? = null,
  var classification: MutableList<TaxonomyClassification>? = null
)

/**
 * A class to specify a telephone number as a type of phone number (e.g. work, personal, ...) alongside with the actual number.
 *
 * @param telephoneNumberType The type of telephone number, e.g. work, mobile.
 * @param number The actual telephone number.
 */
@Serializable
open class TelephoneNumber (
  var telephoneNumberType: TelephoneTypeEnum? = null,
  var number: String? = null
)

@Serializable
open class Term (
  var unit: String? = null,
  var `val`: String? = null
)

/**
 * A class for defining option provisions.
 *
 * @param cancelableProvision A provision that allows the specification of an embedded option within a swap giving the buyer of the option the right to terminate the swap, in whole or in part, on the early termination date.
 * @param earlyTerminationProvision Parameters specifying provisions relating to the optional and mandatory early termination of a swap transaction.
 * @param evergreenProvision A data defining: the right of a party to exercise an Evergreen option
 * @param extendibleProvision A provision that allows the specification of an embedded option with a swap giving the buyer of the option the right to extend the swap, in whole or in part, to the extended termination date.
 */
@Serializable
open class TerminationProvision (
  var cancelableProvision: CancelableProvision? = null,
  var earlyTerminationProvision: EarlyTerminationProvision? = null,
  var evergreenProvision: EvergreenProvision? = null,
  var extendibleProvision: ExtendibleProvision? = null
)

/**
 * Specifies instructions for terms change consisting of the new transaction terms, and the renegotiation fee.
 *
 * @param product product to be changed
 * @param ancillaryParty ancillary party to be changed
 * @param adjustment 
 */
@Serializable
open class TermsChangeInstruction (
  var product: NonTransferableProduct? = null,
  var ancillaryParty: MutableList<AncillaryParty>? = null,
  var adjustment: NotionalAdjustmentEnum? = null
)

/**
 * The time alongside with the timezone location information. This class makes use of the FpML TimezoneLocation construct.
 *
 * @param time The observation time.
 * @param location FpML specifies the timezoneLocationScheme by reference to the Time Zone Database (a.k.a. tz database) maintained by IANA, the Internet Assigned Numbers Authority.
 */
@Serializable
open class TimeZone (
  var time: String? = null,
  var location: FieldWithMetaString? = null
)

/**
 * Definition of a product as ready to be traded, i.e. included in an execution or contract, by associating a specific price and quantity to this product plus an (optional) mechanism for any potential future quantity adjustment.
 *
 * @param product The underlying product to be included in a contract or execution.
 * @param tradeLot Specifies the price, quantity and effective date of each trade lot, when the same product may be traded multiple times in different lots with the same counterparty. In a trade increase, a new trade lot is added to the list, with the corresponding effective date. In a trade decrease, the existing trade lot(s) are decreased of the corresponding quantity (and an unwind fee may have to be settled). The multiple cardinality and the ability to increase existing trades is used for Equity Swaps in particular.
 * @param counterparty Specifies the parties which are the two counterparties to the transaction.  The product is agnostic to the actual parties to the transaction, with the party references abstracted away from the product definition and replaced by the counterparty enum (e.g. CounterpartyEnum values Party1 or Party2). The counterparty enum can then be positioned in the product (e.g. to specify which counterparty is the payer, receiver etc) and this counterparties attribute, which is positioned outside of the product definition, allows the counterparty enum to be associated with an actual party reference.
 * @param ancillaryParty Specifies the parties with ancillary roles in the transaction. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and this AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
 * @param adjustment Specifies the conditions that govern the adjustment to the quantity of a product being traded: e.g. execution, portfolio rebalancing etc. It is typically used in the context of Equity Swaps.
 */
@Serializable
open class TradableProduct (
  var product: NonTransferableProduct? = null,
  var tradeLot: MutableList<TradeLot>? = null,
  var counterparty: MutableList<Counterparty>? = null,
  var ancillaryParty: MutableList<AncillaryParty>? = null,
  var adjustment: NotionalAdjustmentEnum? = null
)

/**
 * Defines the output of a financial transaction between parties - a Business Event. A Trade impacts the financial position (i.e. the balance sheet) of involved parties.
 *
 * @param product The underlying product to be included in a contract or execution.
 * @param tradeLot Specifies the price, quantity and effective date of each trade lot, when the same product may be traded multiple times in different lots with the same counterparty. In a trade increase, a new trade lot is added to the list, with the corresponding effective date. In a trade decrease, the existing trade lot(s) are decreased of the corresponding quantity (and an unwind fee may have to be settled). The multiple cardinality and the ability to increase existing trades is used for Equity Swaps in particular.
 * @param counterparty Specifies the parties which are the two counterparties to the transaction.  The product is agnostic to the actual parties to the transaction, with the party references abstracted away from the product definition and replaced by the counterparty enum (e.g. CounterpartyEnum values Party1 or Party2). The counterparty enum can then be positioned in the product (e.g. to specify which counterparty is the payer, receiver etc) and this counterparties attribute, which is positioned outside of the product definition, allows the counterparty enum to be associated with an actual party reference.
 * @param ancillaryParty Specifies the parties with ancillary roles in the transaction. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and this AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
 * @param adjustment Specifies the conditions that govern the adjustment to the quantity of a product being traded: e.g. execution, portfolio rebalancing etc. It is typically used in the context of Equity Swaps.
 * @param tradeIdentifier Represents the identifier(s) that uniquely identify a trade for an identity issuer. A trade can include multiple identifiers, for example a trade that is reportable to both the CFTC and ESMA, and then has an associated USI (Unique Swap Identifier) UTI (Unique Trade Identifier).
 * @param tradeDate Specifies the date which the trade was agreed.
 * @param tradeTime Denotes the trade time and timezone as agreed by the parties to the trade.
 * @param party Represents the parties to the trade. The cardinality is optional to address the case where the trade is defined within a BusinessEvent data type, in which case the party is specified in BusinessEvent.
 * @param partyRole Represents the role each specified party takes in the trade. further to the principal roles, payer and receiver.
 * @param executionDetails Represents information specific to trades that arose from executions.
 * @param contractDetails Represents information specific to trades involving contractual products.
 * @param clearedDate Specifies the date on which a trade is cleared (novated) through a central counterparty clearing service.
 * @param collateral Represents the collateral obligations of a party.
 * @param account Represents a party's granular account information, which may be used in subsequent internal processing.
 * @param meta 
 */
@Serializable
open class Trade (
  var tradeIdentifier: MutableList<TradeIdentifier>? = null,
  var tradeDate: FieldWithMetaDate? = null,
  var tradeTime: FieldWithMetaTimeZone? = null,
  var party: MutableList<Party>? = null,
  var partyRole: MutableList<PartyRole>? = null,
  var executionDetails: ExecutionDetails? = null,
  var contractDetails: ContractDetails? = null,
  var clearedDate: Date? = null,
  var collateral: Collateral? = null,
  var account: MutableList<Account>? = null,
  var meta: MetaFields? = null
)
: TradableProduct()

/**
 * Defines a trade identifier as a special case of the generic identifier type, that also includes the trade identifier class.
 *
 * @param issuerReference The identifier issuer, when specified by reference to a party specified as part of the transaction.
 * @param issuer The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).
 * @param assignedIdentifier The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.
 * @param meta 
 * @param identifierType The enumerated classification of the identifier. Optional as a trade identifier may be party-specific, in which case it may not correspond to any established classification.
 */
@Serializable
open class TradeIdentifier (
  var identifierType: TradeIdentifierTypeEnum? = null
)
: Identifier()

/**
 * Specifies the price and quantity of a trade lot, where the same product could be traded multiple times with the same counterparty but in different lots (at a different date, in a different quantity and at a different price). One trade lot combined with a product definition specifies the entire economics of a trade. The lifecycle mechanics of each such trade lot (e.g. cashflow payments) is independent of the other lots.
 *
 * @param lotIdentifier Specifies one or more identifiers for the lot, if any.
 * @param priceQuantity Specifies the settlement characteristics of a trade lot: price, quantity, observable (optionally) and the settlement terms. This attribute has a multiple cardinality to allow to specify the price, quantity and observable of different legs in a single, composite product (e.g. a Swap).
 */
@Serializable
open class TradeLot (
  var lotIdentifier: MutableList<Identifier>? = null,
  var priceQuantity: MutableList<PriceQuantity>? = null
)

/**
 * The attributes that are specific for consensus based pricing reporting.
 *
 * @param trade Represents the cosensus based pricing parameters on a trade basis.
 * @param pricingTime The regional exchange close time for the underlying contract,including time zone, at which the trades should be priced. This provides an indication for which regional snapshot should be used for pricing primarily for Global markets where there are multiple regional close times.
 * @param discountingIndex It specifies the interest payable on collateral delivered under a CSA covering the trade.
 */
@Serializable
open class TradePricingReport (
  var trade: Trade? = null,
  var pricingTime: TimeZone? = null,
  var discountingIndex: FloatingRateIndexEnum? = null
)

/**
 * Defines the fundamental financial information that can be changed by a Primitive Event and by extension any business or life-cycle event. Each TradeState specifies where a Trade is in its life-cycle. TradeState is a root type and as such, can be created independently to any other CDM data type, but can also be used as part of the CDM Event Model.
 *
 * @param trade Represents the Trade that has been effected by a business or life-cycle event.
 * @param state Represents the State of the Trade through its life-cycle.
 * @param resetHistory Represents the updated Trade attributes which can change as the result of a reset event. Only the changed values are captured, leaving the remaining data attributes empty. See Create_Reset function for further details on how TradeState is used in the Reset event. The TradeState data type is used to maintain backwards compatibility with the current Reset mechanism.
 * @param transferHistory Represents the updated Trade attributes which can change as the result of a transfer event.
 * @param observationHistory Represents the observed events related to a particular product or process, such as credit events or corporate actions.
 * @param valuationHistory 
 * @param meta 
 */
@Serializable
open class TradeState (
  var trade: Trade? = null,
  var state: State? = null,
  var resetHistory: MutableList<Reset>? = null,
  var transferHistory: MutableList<TransferState>? = null,
  var observationHistory: MutableList<ObservationEvent>? = null,
  var valuationHistory: MutableList<Valuation>? = null,
  var meta: MetaFields? = null
)

/**
 * The class to represent a CDS Tranche.
 *
 * @param attachmentPoint Lower bound percentage of the loss that the Tranche can endure, expressed as a decimal. An attachment point of 5% would be represented as 0.05. The difference between Attachment and Exhaustion points is called the width of the Tranche.
 * @param exhaustionPoint Upper bound percentage of the loss that the Tranche can endure, expressed as a decimal. An exhaustion point of 5% would be represented as 0.05. The difference between Attachment and Exhaustion points is call the width of the Tranche.
 * @param incurredRecoveryApplicable Outstanding Swap Notional Amount is defined at any time on any day, as the greater of: (a) Zero; If Incurred Recovery Amount Applicable: (b) The Original Swap Notional Amount minus the sum of all Incurred Loss Amounts and all Incurred Recovery Amounts (if any) determined under this Confirmation at or prior to such time.Incurred Recovery Amount not populated: (b) The Original Swap Notional Amount minus the sum of all Incurred Loss Amounts determined under this Confirmation at or prior to such time.
 */
@Serializable
open class Tranche (
  var attachmentPoint: Float? = null,
  var exhaustionPoint: Float? = null,
  var incurredRecoveryApplicable: Boolean? = null
)

/**
 *  A class to represent the transacted price attributes that are positioned as part of the FpML FeeLeg.
 *
 * @param marketFixedRate An optional element that only has meaning in a credit index trade. This element contains the credit spread ('fair value') at which the trade was executed. Unlike the fixedRate of an index, the marketFixedRate varies over the life of the index depending on market conditions. The marketFixedRate is the price of the index as quoted by trading desks.
 * @param initialPoints An optional element that contains the up-front points expressed as a percentage of the notional. An initialPoints value of 5% would be represented as 0.05. The initialPoints element is an alternative to marketFixedRate in quoting the traded level of a trade. When initialPoints is used, the traded level is the sum of fixedRate and initialPoints. The initialPoints is one of the items that are factored into the initialPayment calculation and is payable by the Buyer to the Seller. Note that initialPoints and marketFixedRate may both be present in the same document when both implied values are desired.
 * @param marketPrice An optional element that only has meaning in a credit index trade. This element contains the price at which the trade was executed and is used instead of marketFixedRate on credit trades on certain indicies which are quoted using a price rather than a spread.
 * @param quotationStyle An optional element that contains the up-front points expressed as a percentage of the notional. An initialPoints value of 5% would be represented as 0.05. The initialPoints element is an alternative to marketFixedRate in quoting the traded level of a trade. When initialPoints is used, the traded level is the sum of fixedRate and initialPoints. The initialPoints is one of the items that are factored into the initialPayment calculation and is payable by the Buyer to the Seller. Note that initialPoints and marketFixedRate may both be present in the same document when both implied values are desired.
 */
@Serializable
open class TransactedPrice (
  var marketFixedRate: Float? = null,
  var initialPoints: Float? = null,
  var marketPrice: Float? = null,
  var quotationStyle: QuotationStyleEnum? = null
)

/**
 * Additional specification for the extraordinary events that may affect a trade and the related contractual rights and obligation of the parties when this happens. Such terms are typically required to extend the economics terms, for the purpose of producing the final legal contractual form of the Transaction.
 *
 * @param equityAdditionalTerms 
 * @param foreignExchangeAdditionalTerms 
 * @param commoditiesAdditionalTerms 
 * @param creditAdditionalTerms 
 * @param interestRateAdditionalTerms 
 * @param digitalAssetAdditionalTerms 
 */
@Serializable
open class TransactionAdditionalTerms (
  var equityAdditionalTerms: EquityAdditionalTerms? = null,
  var foreignExchangeAdditionalTerms: FxAdditionalTerms? = null,
  var commoditiesAdditionalTerms: String? = null,
  var creditAdditionalTerms: String? = null,
  var interestRateAdditionalTerms: String? = null,
  var digitalAssetAdditionalTerms: String? = null
)

/**
 * Defines the movement of an Asset (eg cash, securities or commodities) between two parties on a date.
 *
 * @param quantity Represents the amount of the asset to be transferred. The cashflow amount is always a positive number, as the cashflow direction is implied by the payer/receiver attribute.
 * @param asset Represents the object that is subject to the transfer, it could be an asset or a reference.
 * @param settlementDate Represents the date on which the transfer to due.
 * @param identifier Represents a unique reference to the transfer.
 * @param payerReceiver Represents the parties to the transfer and their role.
 * @param settlementOrigin Represents the origin to the transfer as a reference for lineage purposes, whether it originated from trade level settlement terms or from payment terms on an economic payout.
 * @param resetOrigin Represents the reset and observation values that were used to determine the transfer amount.
 * @param transferExpression Specifies a transfer expression (cash price, performance amount, scheduled payment amount, etc.) to define the nature of the transfer amount and its source.
 */
@Serializable
open class Transfer (
  var identifier: MutableList<FieldWithMetaIdentifier>? = null,
  var payerReceiver: PartyReferencePayerReceiver? = null,
  var settlementOrigin: ReferenceWithMetaPayout? = null,
  var resetOrigin: Reset? = null,
  var transferExpression: TransferExpression? = null
)
: AssetFlowBase()

/**
 * Specifies a transfer expression (cash price, performance amount, scheduled payment amount, etc.) to define the nature of the transfer amount and its source.
 *
 * @param priceTransfer Specifies a transfer amount exchanged as a price or fee for entering into a Business Event, e.g. Premium, Termination fee, Novation fee.
 * @param scheduledTransfer Specifies a transfer created from a scheduled or contingent event on a contract, e.g. Exercise, Performance, Credit Event
 */
@Serializable
open class TransferExpression (
  var priceTransfer: FeeTypeEnum? = null,
  var scheduledTransfer: ScheduledTransfer? = null
)

/**
 * Defines the payout on which to create a Transfer along with all necessary resets.
 *
 * @param transferState Specifies the terms and state of a transfers.
 */
@Serializable
open class TransferInstruction (
  var transferState: MutableList<TransferState>? = null
)

/**
 * Defines the fundamental financial information associated with a Transfer event. Each TransferState specifies where a Transfer is in its life-cycle. TransferState is a root type and as such, can be created independently to any other CDM data type, but can also be used as part of the CDM Event Model.
 *
 * @param transfer Represents the Transfer that has been effected by a business or life-cycle event.
 * @param transferStatus Represents the State of the Transfer through its life-cycle.
 * @param meta 
 */
@Serializable
open class TransferState (
  var transfer: Transfer? = null,
  var transferStatus: TransferStatusEnum? = null,
  var meta: MetaFields? = null
)

/**
 * A TransferableProduct is a type of financial product which can be held or transferred, represented as an Asset with the addition of specific EconomicTerms.
 *
 * @param Cash An Asset that consists solely of a monetary holding in a currency.
 * @param Commodity An Asset comprised of raw or refined materials or agricultural products, eg gold, oil or wheat.
 * @param DigitalAsset An Asset that exists only in digital form, eg Bitcoin or Ethereum; excludes the digital representation of other Assets.
 * @param Instrument An asset that is issued by one party to one or more others; Instrument is also a choice data type.
 * @param economicTerms The price forming features, including payouts and provisions.
 */
@Serializable
open class TransferableProduct (
  var economicTerms: EconomicTerms? = null
)
: Asset()

/**
 * Trigger point at which feature is effective.
 *
 * @param level The trigger level.
 * @param creditEvents 
 * @param creditEventsReference 
 * @param triggerType The Triggering condition.
 * @param triggerTimeType The valuation time type of knock condition.
 */
@Serializable
open class Trigger (
  var level: MutableList<PriceSchedule>? = null,
  var creditEvents: CreditEvents? = null,
  var creditEventsReference: ReferenceWithMetaCreditEvents? = null,
  var triggerType: TriggerTypeEnum? = null,
  var triggerTimeType: TriggerTimeTypeEnum? = null
)

/**
 * Observation point for trigger.
 *
 * @param schedule A derivative schedule.
 * @param triggerDates The trigger Dates.
 * @param trigger The trigger level
 * @param featurePayment The feature payment, i.e. the payment made following trigger occurrence.
 */
@Serializable
open class TriggerEvent (
  var schedule: MutableList<AveragingSchedule>? = null,
  var triggerDates: DateList? = null,
  var trigger: Trigger? = null,
  var featurePayment: FeaturePayment? = null
)

@Serializable
open class Tx (
  var newTx: New? = null,
  var tradDt: String? = null,
  var tradgCpcty: String? = null,
  var qty: Qty? = null,
  var pric: Pric? = null,
  var tradVn: String? = null,
  var ctryOfBrnch: String? = null
)

/**
 * A class to specify a set of legal entities which are part of a legal agreement beyond the two contracting parties to that agreement. This data representation reflects the ISDA Create representation.
 *
 * @param isApplicable The determination of whether Umbrella Agreement terms are Applicable (True), or Not Applicable (False)
 * @param language The language associated with the umbrella agreement, and which applies to all the parties to the umbrella agreement.
 * @param parties Underlying principals to the umbrella agreement.
 */
@Serializable
open class UmbrellaAgreement (
  var isApplicable: Boolean? = null,
  var language: String? = null,
  var parties: MutableList<UmbrellaAgreementEntity>? = null
)

/**
 * A class to specify the legal entities that are part of the umbrella agreement.
 *
 * @param entityId A legal entity identifier (e.g. RED entity code).
 * @param name The legal entity name.
 * @param meta 
 * @param terms The terms that might be associated with each party to the umbrella agreement.
 */
@Serializable
open class UmbrellaAgreementEntity (
  var terms: String? = null
)
: LegalEntity()

/**
 * The underlying financial product that will be physically or cash settled, which can be of any type, eg an asset such as cash or a security, a product, or the cash settlement of an index rate.  Conditions are usually applied when used in a data type, such as a payout, to ensure this aligns with the use case.
 *
 * @param Observable Specifies the object to be observed for a price, it could be an asset or a reference.
 * @param Product Enables either a TransferableProduct or a NonTransferableProduct to be used in an underlier.
 */
@Serializable
open class Underlier (
  var observable: ReferenceWithMetaObservable? = null,
  var product: Product? = null
)

/**
 * Where parties describe any substitution terms.
 *
 * @param whoMaySubstitute Designates which Counterparty to the transaction who has the right to trigger a substitution or to provide related determination e.g. for instance to qualify the effectiveness of an Event which may be a trigger for substitution, determine the replacement Share to substitute, etc. ; cardinality of this object is 2, in case parties jointly have this role.
 * @param substitutionBeSpokeTerms Where parties describe any substitution terms e.g. for instance the election criteria for an Asset to be eligible as the Substitute Asset to the prior Affected Asset in terms of sector of activity, currency, market capitalisation, liquidity, volatility, or any additional features that parties would agree to take into considerations, etc.
 * @param substitutionTriggerEvents Where the parties may optionnally explictly specify the list of Events to be considered as a trigger for a Substitution.
 * @param disputingParty Where the party who is not granted with the substitution role at least has a right to dispute the determination given by the counterparty with such role. As an example, a given PartyA is the unique Counterparty with the Role of WhoMaySubstitute, yet PartyB could be Disputing Party in regard of such Role.
 */
@Serializable
open class UnderlierSubstitutionProvision (
  var whoMaySubstitute: MutableList<CounterpartyRoleEnum>? = null,
  var substitutionBeSpokeTerms: MutableList<Clause>? = null,
  var substitutionTriggerEvents: MutableList<ExtraordinaryEvents>? = null,
  var disputingParty: CounterpartyRoleEnum? = null
)

@Serializable
open class UndrlygInstrm (
  var swp: Swp? = null
)

/**
 * Defines the unit to be used for price, quantity, or other purposes
 *
 * @param capacityUnit Provides an enumerated value for a capacity unit, generally used in the context of defining quantities for commodities.
 * @param weatherUnit Provides an enumerated values for a weather unit, generally used in the context of defining quantities for commodities.
 * @param financialUnit Provides an enumerated value for financial units, generally used in the context of defining quantities for securities.
 * @param currency Defines the currency to be used as a unit for a price, quantity, or other purpose.
 */
@Serializable
open class UnitType (
  var capacityUnit: CapacityUnitEnum? = null,
  var weatherUnit: WeatherUnitEnum? = null,
  var financialUnit: FinancialUnitEnum? = null,
  var currency: FieldWithMetaString? = null
)

/**
 * Defines the value of an investment, asset, or security
 *
 * @param amount Current value of the outstanding contract
 * @param timestamp Date and time of the last valuation marked to market, provided by the central counterparty (CCP) or calculated using the current or last available market price of the inputs.
 * @param method Method used for the valuation of the transaction by the valuation party.
 * @param source Source of the valuation of the transaction by the valuation party.
 * @param delta The ratio of the change in the price of a derivative transaction to the change in the price of the underlying. This field is applicable only to options and swaptions.
 * @param valuationTiming Denotes when the valuation was sourced during a business day.
 * @param priceComponent Denotes the price used to compute the valuation.
 */
@Serializable
open class Valuation (
  var amount: Money? = null,
  var timestamp: Date? = null,
  var method: ValuationTypeEnum? = null,
  var source: ValuationSourceEnum? = null,
  var delta: Float? = null,
  var valuationTiming: PriceTimingEnum? = null,
  var priceComponent: Price? = null
)

/**
 * A single object that represents the different methods to specify a valuation date, as used for cash settlement. The Single / Multiple ValuationDate is used for the determination of recovery in a credit event, the RelativeDateOffset is used for cash-settled option, and FxFixingDate is used for cross-currency settlement.
 *
 * @param singleValuationDate Where single valuation date is specified as being applicable for cash settlement, this element specifies the number of business days after satisfaction of all conditions to settlement when such valuation date occurs. ISDA 2003 Term: Single Valuation Date.
 * @param multipleValuationDates Where multiple valuation dates are specified as being applicable for cash settlement, this element specifies (a) the number of applicable valuation dates, and (b) the number of business days after satisfaction of all conditions to settlement when the first such valuation date occurs, and (c) the number of business days thereafter of each successive valuation date. ISDA 2003 Term: Multiple Valuation Dates.
 * @param valuationDate The date on which the cash settlement amount will be determined according to the cash settlement method if the parties have not otherwise been able to agree the cash settlement amount. This attribute was formerly part of 'OptionCashSettlement', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
 * @param fxFixingDate The date on which the currency rate will be determined for the purpose of specifying the amount in deliverable currency. This attribute was formerly part of 'NonDeliverableSettlement', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
 * @param fxFixingSchedule The date, when expressed as a schedule of date(s), on which the currency rate will be determined for the purpose of specifying the amount in deliverable currency. This attribute was formerly part of 'NonDeliverableSettlement', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
 */
@Serializable
open class ValuationDate (
  var singleValuationDate: SingleValuationDate? = null,
  var multipleValuationDates: MultipleValuationDates? = null,
  var valuationDate: RelativeDateOffset? = null,
  var fxFixingDate: FxFixingDate? = null,
  var fxFixingSchedule: AdjustableDates? = null
)

/**
 * Defines how and when a performance type option or performance type swap is to be valued, including initial, interim and final valuation dates.
 *
 * @param initialValuationDate Specifies the initial valuation dates of the underlyer.
 * @param interimValuationDate Specifies the interim valuation dates of the underlyer.
 * @param finalValuationDate Specifies the final valuation dates of the underlyer.
 */
@Serializable
open class ValuationDates (
  var initialValuationDate: PerformanceValuationDates? = null,
  var interimValuationDate: PerformanceValuationDates? = null,
  var finalValuationDate: PerformanceValuationDates? = null
)

/**
 * Specifies inputs needed to process a valuation.
 *
 * @param valuation Contains all information related to a valuation.
 * @param replace Specifies whether the previous valuation tracks in the valuation history are removed (True) or kept (False).
 */
@Serializable
open class ValuationInstruction (
  var valuation: MutableList<Valuation>? = null,
  var replace: Boolean? = null
)

/**
 * Specifies the parameters required to obtain a valuation, including the source, quotation method (bid, mid etc.) and any applicable quotation amount.
 *
 * @param valuationSource The source for obtaining a valuation. This may come from some information source (e.g. Reuters), from a rate option fixing (e.g. FX fixing for cross-currency settlement), or from a set of reference banks. This is a mandatory attribute as the valuation method relies on one of those sources to be specified.
 * @param quotationMethod The type of price quotations to be requested from dealers when determining the market value of the reference obligation for purposes of cash settlement, or which rate quote is to be observed for a fixing. For example, Bid, Offer, Mid-market or Exercising Party Pays. ISDA 2003 Term: Quotation Method. The meaning of Exercising Party Pays is defined in the 2000 ISDA Definitions, Section 17.2. Certain Definitions Relating to Cash Settlement, paragraph (j).
 * @param valuationMethod The ISDA defined methodology for determining the final price of the reference obligation for purposes of cash settlement. (ISDA 2003 Term: Valuation Method). For example, Market, Highest etc.
 * @param quotationAmount In the determination of a cash settlement amount, if weighted average quotations are to be obtained, the quotation amount specifies an upper limit to the outstanding principal balance of the reference obligation for which the quote should be obtained. If not specified, the ISDA definitions provide for a fallback amount equal to the floating rate payer calculation amount. ISDA 2003 Term: Quotation Amount.
 * @param minimumQuotationAmount In the determination of a cash settlement amount, if weighted average quotations are to be obtained, the minimum quotation amount specifies a minimum intended threshold amount of outstanding principal balance of the reference obligation for which the quote should be obtained. If not specified, the ISDA definitions provide for a fallback amount of the lower of either USD 1,000,000 (or its equivalent in the relevant obligation currency) or the quotation amount. ISDA 2003 Term: Minimum Quotation Amount.
 * @param cashCollateralValuationMethod Specifies the parameters representing several mid-market valuation and replacement value methods.
 */
@Serializable
open class ValuationMethod (
  var valuationSource: ValuationSource? = null,
  var quotationMethod: QuotationRateTypeEnum? = null,
  var valuationMethod: ValuationMethodEnum? = null,
  var quotationAmount: Money? = null,
  var minimumQuotationAmount: Money? = null,
  var cashCollateralValuationMethod: CashCollateralValuationMethod? = null
)

/**
 * Specifies how long to wait to get a quote from a settlement rate option upon a price source disruption.
 *
 * @param maximumDaysOfPostponement The maximum number of days to wait for a quote from the disrupted settlement rate option before proceeding to the next method.
 */
@Serializable
open class ValuationPostponement (
  var maximumDaysOfPostponement: Int? = null
)

/**
 * A class describing the method for obtaining a settlement rate, specified through either an information source (page), a settlement rate option (fixing) or by using quotes from reference banks.
 *
 * @param quotedCurrencyPair Defines the two currencies for an FX trade and the quotation relationship between the two currencies.  This attribute was formerly part of 'fxSettlementTerms', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
 * @param informationSource The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
 * @param settlementRateOption The rate option to use for the fixing. Currently only applicable to foreign exchange fixing in case of cross-currency settlement.
 * @param referenceBanks A container for a set of reference institutions that may be called upon to provide rate quotations as part of the method to determine the applicable cash settlement amount. If institutions are not specified, it is assumed that reference institutions will be agreed between the parties on the exercise date, or in the case of swap transaction to which mandatory early termination is applicable, the cash settlement valuation date.
 * @param dealerOrCCP Holds an identifier for the reference entity that is agreed by both parties as a basis for cash settlement calculations. This could be a dealer from whom quotations are obtained by the calculation agent on the reference obligation for purposes of cash settlement in a credit event. ISDA 2003 Term: Dealer. This could be the clearing organization (CCP, DCO) to which the trade should be cleared, as applicable for cash-settled swaptions.
 */
@Serializable
open class ValuationSource (
  var quotedCurrencyPair: ReferenceWithMetaQuotedCurrencyPair? = null,
  var informationSource: FxSpotRateSource? = null,
  var settlementRateOption: SettlementRateOption? = null,
  var referenceBanks: ReferenceBanks? = null,
  var dealerOrCCP: AncillaryEntity? = null
)

@Serializable
open class ValuationTerms (
  var futuresPriceValuation: Boolean? = null,
  var optionsPriceValuation: Boolean? = null,
  var numberOfValuationDates: Int? = null,
  var dividendValuationDates: AdjustableRelativeOrPeriodicDates? = null,
  var fPVFinalPriceElectionFallback: FPVFinalPriceElectionFallbackEnum? = null,
  var multipleExchangeIndexAnnexFallback: Boolean? = null,
  var componentSecurityIndexAnnexFallback: Boolean? = null
)

@Serializable
open class VarianceCapFloor (
  var varianceCap: Boolean? = null,
  var unadjustedVarianceCap: Float? = null,
  var boundedVariance: BoundedVariance? = null
)

@Serializable
open class VarianceReturnTerms (
  var varianceStrikePrice: Price? = null,
  var volatilityStrikePrice: Price? = null,
  var varianceCapFloor: VarianceCapFloor? = null,
  var volatilityCapFloor: VolatilityCapFloor? = null,
  var vegaNotionalAmount: NonNegativeQuantitySchedule? = null,
  var exchangeTradedContractNearest: ReferenceWithMetaObservable? = null
)
: ReturnTermsBase()

@Serializable
open class Velocity (
  var periodMultiplier: Int? = null,
  var period: PeriodTimeEnum? = null
)

/**
 * Contains volatility-based barriers. Volatility Cap needs to be specified in accordance with the ISDA 2011 Equity Derivatives Definitions.
 *
 * @param applicable Indicates whether the volatility cap is applicable in accordance with the ISDA 2011 Equity Derivatives Definitions. Setting the element 'applicable' to 'False' - means No Volatility Cap and no 'totalVolatilityCap' or 'volatilityCapFactor' should be provided. Setting the element 'applicable' to 'True' - means Volatility Cap election, then 'totalVolatilityCap' or 'volatilityCapFactor' should be provided, otherwise it defaults to volatilityCapFactor=2.5.
 * @param totalVolatilityCap Volatility Cap Amount in accordance with the ISDA 2011 Equity Derivatives Definitions. This means the Volatility Cap Amount election is a number.
 * @param volatilityCapFactor Volatility Cap Amount in accordance with the ISDA 2011 Equity Derivatives Definitions. The Calculated VolCapAmt can be optionally provided.
 */
@Serializable
open class VolatilityCapFloor (
  var applicable: Boolean? = null,
  var totalVolatilityCap: Float? = null,
  var volatilityCapFactor: Float? = null
)

@Serializable
open class VolatilityReturnTerms (
  var volatilityStrikePrice: Price? = null,
  var volatilityCapFloor: VolatilityCapFloor? = null,
  var exchangeTradedContractNearest: ListedDerivative? = null
)
: ReturnTermsBase()

/**
 * A single weighted averaging observation.
 *
 * @param dateTime Observation date time, which should be used when literal observation dates are required. The CDM specifies that the zoned date time is to be expressed in accordance with ISO 8601, either as UTC as an offset to UTC.
 * @param observationNumber Observation number, which should be unique, within a series generated by a date schedule.
 * @param weight Observation weight, which is used as a multiplier for the observation value.
 */
@Serializable
open class WeightedAveragingObservation (
  var dateTime: Date? = null,
  var observationNumber: Int? = null,
  var weight: Float? = null
)

/**
 * A collection of workflow steps which together makeup an entire workflow sequence.
 *
 * @param steps 
 */
@Serializable
open class Workflow (
  var steps: MutableList<WorkflowStep>? = null
)

/**
 * A class to specify workflow information, which is conceptually applicable to all lifecycle events.
 *
 * @param workflowStatus The workflow status indicator, e.g. Accepted, Rejected, ...
 * @param comment A comment field to be associated with the workflow, e.g. to specify why a transaction event was rejected by a party.
 * @param partyCustomisedWorkflow Workflow data that is specific to certain market participants and is expressed as part of the CDM in a very generic manner, which can be party-specific. The initial use cases have been derived from the CME clearing and the DTCC TIW submissions.
 * @param warehouseIdentity The identity of the warehouse, if any, that is executing that workflow step.
 */
@Serializable
open class WorkflowState (
  var workflowStatus: WorkflowStatusEnum? = null,
  var comment: String? = null,
  var partyCustomisedWorkflow: MutableList<PartyCustomisedWorkflow>? = null,
  var warehouseIdentity: WarehouseIdentityEnum? = null
)

/**
 * A workflow step represents the state of a business event. The workflow step contains a reference to a previous WorkflowStep in order to preserve lineage. A workflow step is accepted if it contains a business event, proposed if proposedEvent is present and is rejected if the rejected flag is set.
 *
 * @param businessEvent Life cycle event for the step. The businessEvent is optional when a proposedEvent or rejection are present.
 * @param counterpartyPositionBusinessEvent Documents the life cycle event for a position.
 * @param proposedEvent The proposed event for a workflow step. The proposedEvent is optional when the businessEvent or rejection are present
 * @param rejected Flags this step as rejected.
 * @param approval Optional party approvals for the current workflow step. A workflow step can have any number of parties associated to it, thus this object is represented as a list. All parties that are expected to provide approval should have an item in this list that references them.
 * @param previousWorkflowStep Optional previous workflow step that provides lineage to workflow steps that precedes it.
 * @param nextEvent The intended next event can be specified, even if the instructions are not known yet.
 * @param messageInformation Contains all information pertaining the FpML messaging header 
 * @param timestamp The set of timestamp(s) associated with the event as a collection of [dateTime, qualifier].
 * @param eventIdentifier The identifier(s) that uniquely identify a lifecycle event. The unbounded cardinality is meant to provide the ability to associate identifiers that are issued by distinct parties. As an example, each of the parties to the event may choose to associate their own identifiers to the event.
 * @param action Specifies whether the event is a new, a correction or a cancellation.
 * @param party The specification of the event parties. This attribute is optional, as not applicable to certain events (e.g. most of the observations).
 * @param account Optional account information that could be associated to the event.
 * @param lineage The lineage attribute provides a linkage among lifecycle events through the globalKey hash value. One example is when a given lifecycle event is being corrected or cancelled. In such case, each subsequent event will have lineage into the prior version of that event. The second broad use case is when an event has a dependency upon either another event (e.g. the regular payment associated with a fix/float swap will have a lineage into the reset event, which will in turn have a lineage into the observation event for the floating rate and the contract) or a contract (e.g. the exercise of an option has a lineage into that option).
 * @param creditLimitInformation 
 * @param workflowState The event workflow information, i.e. the workflow status, the associated comment and the partyCustomisedWorkflow which purpose is to provide the ability to associate custom workflow information to the CDM.
 * @param meta 
 */
@Serializable
open class WorkflowStep (
  var businessEvent: BusinessEvent? = null,
  var counterpartyPositionBusinessEvent: CounterpartyPositionBusinessEvent? = null,
  var proposedEvent: EventInstruction? = null,
  var rejected: Boolean? = null,
  var approval: MutableList<WorkflowStepApproval>? = null,
  var previousWorkflowStep: ReferenceWithMetaWorkflowStep? = null,
  var nextEvent: EventInstruction? = null,
  var messageInformation: MessageInformation? = null,
  var timestamp: MutableList<EventTimestamp>? = null,
  var eventIdentifier: MutableList<Identifier>? = null,
  var action: ActionEnum? = null,
  var party: MutableList<Party>? = null,
  var account: MutableList<Account>? = null,
  var lineage: Lineage? = null,
  var creditLimitInformation: CreditLimitInformation? = null,
  var workflowState: WorkflowState? = null,
  var meta: MetaFields? = null
)

/**
 * Party approvals associated to the current WorkflowStep. 
 *
 * @param approved Flag denoting whether the workflow step is approved or not
 * @param party Reference to the Party who is approving/rejecting this workflow step
 * @param rejectedReason Optional reason for rejecting the workflow step
 * @param timestamp Timestamp of the approval
 * @param meta 
 */
@Serializable
open class WorkflowStepApproval (
  var approved: Boolean? = null,
  var party: ReferenceWithMetaParty? = null,
  var rejectedReason: String? = null,
  var timestamp: EventTimestamp? = null,
  var meta: MetaFields? = null
)
