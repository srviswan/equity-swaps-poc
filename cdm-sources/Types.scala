/**
  * This file is auto-generated from the ISDA Common Domain Model, do not edit.
  * Version: 6.0.0
  */
package org.isda.cdm

import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.module.scala.JsonScalaEnumeration
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

import org.isda.cdm.metafields._

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
case class Account(partyReference: Option[ReferenceWithMetaParty],
    accountNumber: FieldWithMetaString,
    accountName: Option[FieldWithMetaString],
    accountType: Option[FieldWithMetaAccountTypeEnum],
    accountBeneficiary: Option[ReferenceWithMetaParty],
    servicingParty: Option[ReferenceWithMetaParty],
    meta: Option[MetaFields]) {
}

case class AcctOwnr(id: Id) {
}

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
case class AdditionalDisruptionEvents(changeInLaw: Option[Boolean],
    failureToDeliver: Option[Boolean],
    insolvencyFiling: Option[Boolean],
    hedgingDisruption: Option[Boolean],
    increasedCostOfHedging: Option[Boolean],
    foreignOwnershipEvent: Option[Boolean],
    lossOfStockBorrow: Option[Boolean],
    maximumStockLoanRate: Option[scala.math.BigDecimal],
    increasedCostOfStockBorrow: Option[Boolean],
    initialStockLoanRate: Option[scala.math.BigDecimal],
    @JsonDeserialize(contentAs = classOf[AncillaryRoleEnum.Value])
    @JsonScalaEnumeration(classOf[AncillaryRoleEnum.Class])
    determiningParty: Option[AncillaryRoleEnum.Value],
    additionalBespokeTerms: List[Clause]) {
}

/**
  * A class to specify the events that will give rise to the payment additional fixed payments.
  *
  * @param interestShortfallReimbursement An additional Fixed Payment Event. Corresponds to the payment by or on behalf of the Issuer of an actual interest amount in respect to the reference obligation that is greater than the expected interest amount. ISDA 2003 Term: Interest Shortfall Reimbursement.
  * @param principalShortfallReimbursement An additional Fixed Payment Event. Corresponds to the payment by or on behalf of the Issuer of an actual principal amount in respect to the reference obligation that is greater than the expected principal amount. ISDA 2003 Term: Principal Shortfall Reimbursement.
  * @param writedownReimbursement An Additional Fixed Payment. Corresponds to the payment by or on behalf of the issuer of an amount in respect to the reference obligation in reduction of the prior writedowns. ISDA 2003 Term: Writedown Reimbursement.
  */
case class AdditionalFixedPayments(interestShortfallReimbursement: Option[Boolean],
    principalShortfallReimbursement: Option[Boolean],
    writedownReimbursement: Option[Boolean]) {
}

/**
  * A class to specify a post or street address.
  *
  * @param street The set of street and building number information that identifies a postal address within a city.
  * @param city The city component of the postal address.
  * @param state A country subdivision used in postal addresses in some countries. For example, US states, Canadian provinces, Swiss cantons, ...
  * @param country The ISO 3166 standard code for the country within which the postal address is located.
  * @param postalCode The code, required for computerized mail sorting systems, that is allocated to a physical address by a national postal authority.
  */
case class Address(street: List[String],
    city: Option[String],
    state: Option[String],
    country: Option[FieldWithMetaString],
    postalCode: Option[String]) {
}

/**
  * Specification of the address and other details for notices.
  *
  * @param primaryNotices Specification of primary notice details
  * @param additionalNotices The optional specification of additional information when a party requires notices to be delivered to more than one address.
  */
case class AddressForNotices(primaryNotices: ContactElection,
    additionalNotices: List[PartyContactInformation]) {
}

case class AddtlAttrbts(rskRdcgTx: String,
    sctiesFincgTxInd: String) {
}

/**
  * A class for defining a date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
  *
  * @param unadjustedDate A date subject to adjustment. While in FpML this date is required, this cardinality constraint has been relaxed as part of the CDM in order to support the FRA representation, which effective and termination dates are specified in FpML as adjusted dates.
  * @param dateAdjustments The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
  * @param dateAdjustmentsReference A pointer style reference to date adjustments defined elsewhere in the document.
  * @param adjustedDate The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
  * @param meta 
  */
case class AdjustableDate(unadjustedDate: Option[java.time.LocalDate],
    dateAdjustments: Option[BusinessDayAdjustments],
    dateAdjustmentsReference: Option[ReferenceWithMetaBusinessDayAdjustments],
    adjustedDate: Option[FieldWithMetaLocalDate],
    meta: Option[MetaFields]) {
}

/**
  * A class for defining a series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the dates.
  *
  * @param unadjustedDate A date subject to adjustment.
  * @param dateAdjustments The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
  * @param adjustedDate The date(s) once the adjustment has been performed. (Note that this date may change if the business center holidays change).
  * @param meta 
  */
case class AdjustableDates(unadjustedDate: List[java.time.LocalDate],
    dateAdjustments: Option[BusinessDayAdjustments],
    adjustedDate: List[FieldWithMetaLocalDate],
    meta: Option[MetaFields]) {
}

/**
  * A class for defining a date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
  *
  * @param unadjustedDate A date subject to adjustment.
  * @param dateAdjustments The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
  * @param adjustedDate The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
  * @param meta 
  */
case class AdjustableOrAdjustedDate(unadjustedDate: Option[java.time.LocalDate],
    dateAdjustments: Option[BusinessDayAdjustments],
    adjustedDate: Option[FieldWithMetaLocalDate],
    meta: Option[MetaFields]) {
}

/**
  * This Rosetta class specifies the date as either an unadjusted, adjusted or relative date. It supplements the features of the AdjustableOrAdjustedDate to support the credit default swap option premium, which uses the relative date construct.
  *
  * @param unadjustedDate A date subject to adjustment.
  * @param dateAdjustments The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
  * @param adjustedDate The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
  * @param relativeDate A date specified as some offset to another date (the anchor date).
  */
case class AdjustableOrAdjustedOrRelativeDate(unadjustedDate: Option[java.time.LocalDate],
    dateAdjustments: Option[BusinessDayAdjustments],
    adjustedDate: Option[FieldWithMetaLocalDate],
    relativeDate: Option[RelativeDateOffset]) {
}

/**
  * A class giving the choice between defining a date as an explicit date together with applicable adjustments or as relative to some other (anchor) date.
  *
  * @param adjustableDate A date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
  * @param relativeDate A date specified as some offset to another date (the anchor date).
  * @param meta 
  */
case class AdjustableOrRelativeDate(adjustableDate: Option[AdjustableDate],
    relativeDate: Option[AdjustedRelativeDateOffset],
    meta: Option[MetaFields]) {
}

/**
  * A class giving the choice between defining a series of dates as an explicit list of dates together with applicable adjustments or as relative to some other series of (anchor) dates.
  *
  * @param adjustableDates A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
  * @param relativeDates A series of dates specified as some offset to another series of dates (the anchor dates).
  * @param meta 
  */
case class AdjustableOrRelativeDates(adjustableDates: Option[AdjustableDates],
    relativeDates: Option[RelativeDates],
    meta: Option[MetaFields]) {
}

/**
  * A class giving the choice between defining a series of dates as an explicit list of dates together with applicable adjustments or as relative to some other series of (anchor) dates, or as a calculation period schedule.
  *
  * @param adjustableDates A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
  * @param relativeDates A series of dates specified as some offset to another series of dates (the anchor dates).
  * @param periodicDates A calculation period schedule.
  * @param meta 
  */
case class AdjustableRelativeOrPeriodicDates(adjustableDates: Option[AdjustableDates],
    relativeDates: Option[RelativeDates],
    periodicDates: Option[PeriodicDates],
    meta: Option[MetaFields]) {
}

/**
  * A type defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date) plus optional date adjustments.
  *
  * @param relativeDateAdjustments The business day convention and financial business centers used for adjusting the relative date if it would otherwise fall on a day that is not a business date in the specified business centers.
  * @param businessDayConvention The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
  * @param businessCenters 
  * @param businessCentersReference A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
  * @param dateRelativeTo Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
  * @param adjustedDate The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
  * @param dayType In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
  * @param periodMultiplier A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
  * @param period A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
  * @param meta 
  */
case class AdjustedRelativeDateOffset(relativeDateAdjustments: Option[BusinessDayAdjustments],
    @JsonScalaEnumeration(classOf[BusinessDayConventionEnum.Class])
    businessDayConvention: BusinessDayConventionEnum.Value,
    businessCenters: Option[BusinessCenters],
    businessCentersReference: Option[ReferenceWithMetaBusinessCenters],
    dateRelativeTo: Option[BasicReferenceWithMetaLocalDate],
    adjustedDate: Option[java.time.LocalDate],
    @JsonDeserialize(contentAs = classOf[DayTypeEnum.Value])
    @JsonScalaEnumeration(classOf[DayTypeEnum.Class])
    dayType: Option[DayTypeEnum.Value],
    periodMultiplier: Int,
    @JsonScalaEnumeration(classOf[PeriodEnum.Class])
    period: PeriodEnum.Value,
    meta: Option[MetaFields])
  extends RelativeDateOffsetTrait {
}

/**
  * Represents a class to specify a credit notation.
  *
  * @param creditNotation Indicates the agency rating criteria specified for the asset or issuer.
  * @param mismatchResolution Indicator for options to be used if several agency ratings (>1) are specified and its necessary to identify specific charateristics. i.e (lowest or highest).
  * @param referenceAgency identifies the dominant reference agency if there is a missmatch and several reference agencies exsist.
  * @param boundary Indicates the boundary of a credit agency rating i.e minimum or maximum.
  */
case class AgencyRatingCriteria(creditNotation: CreditNotation,
    @JsonDeserialize(contentAs = classOf[CreditNotationMismatchResolutionEnum.Value])
    @JsonScalaEnumeration(classOf[CreditNotationMismatchResolutionEnum.Class])
    mismatchResolution: Option[CreditNotationMismatchResolutionEnum.Value],
    @JsonDeserialize(contentAs = classOf[CreditRatingAgencyEnum.Value])
    @JsonScalaEnumeration(classOf[CreditRatingAgencyEnum.Class])
    referenceAgency: Option[CreditRatingAgencyEnum.Value],
    @JsonDeserialize(contentAs = classOf[CreditNotationBoundaryEnum.Value])
    @JsonScalaEnumeration(classOf[CreditNotationBoundaryEnum.Class])
    boundary: Option[CreditNotationBoundaryEnum.Value]) {
}

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
case class AggregationParameters(dateTime: java.time.ZonedDateTime,
    totalPosition: Option[Boolean],
    @JsonDeserialize(contentAs = classOf[PositionStatusEnum.Value])
    @JsonScalaEnumeration(classOf[PositionStatusEnum.Class])
    positionStatus: Option[PositionStatusEnum.Value],
    party: List[ReferenceWithMetaParty],
    product: List[NonTransferableProduct],
    productQualifier: List[String],
    tradeReference: List[ReferenceWithMetaTrade]) {
}

/**
  * Specification of the standard set of terms that define a legal agreement.
  *
  * @param creditSupportAgreementElections Elections to specify a Credit Support Annex or Credit Support Deed for Intial or Variation Margin.
  * @param collateralTransferAgreementElections Elections to specify a Collateral Transfer Agreement.
  * @param securityAgreementElections Elections to specify a Security agreement.
  * @param masterAgreementSchedule Elections to specify a Master Agreement Schedule.
  * @param transactionAdditionalTerms Any additional terms which mainly intend to specify the extraordinary events that may affect a trade and the related contractual rights and obligation of the parties when this happens
  */
case class Agreement(creditSupportAgreementElections: Option[CreditSupportAgreementElections],
    collateralTransferAgreementElections: Option[CollateralTransferAgreementElections],
    securityAgreementElections: Option[SecurityAgreementElections],
    masterAgreementSchedule: Option[MasterAgreementSchedule],
    transactionAdditionalTerms: Option[TransactionAdditionalTerms]) {
}

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
case class AgreementName(@JsonScalaEnumeration(classOf[LegalAgreementTypeEnum.Class])
    agreementType: LegalAgreementTypeEnum.Value,
    creditSupportAgreementType: Option[FieldWithMetaCreditSupportAgreementTypeEnum],
    @JsonDeserialize(contentAs = classOf[CollateralMarginTypeEnum.Value])
    @JsonScalaEnumeration(classOf[CollateralMarginTypeEnum.Class])
    creditSupportAgreementMarginType: Option[CollateralMarginTypeEnum.Value],
    contractualDefinitionsType: List[FieldWithMetaContractualDefinitionsEnum],
    contractualTermsSupplement: List[ContractualTermsSupplement],
    contractualMatrix: List[ContractualMatrix],
    masterAgreementType: Option[FieldWithMetaMasterAgreementTypeEnum],
    masterConfirmationType: Option[FieldWithMetaMasterConfirmationTypeEnum],
    masterConfirmationAnnexType: Option[FieldWithMetaMasterConfirmationAnnexTypeEnum],
    otherAgreement: Option[String]) {
}

/**
  * Specification of the content of a legal agreement.
  *
  * @param agreement Specification of the standard set of terms that define a legal agreement.
  * @param clauseLibrary Specification of whether the agreement terms have been negotiated using the clause library methodology.
  * @param counterparty Specification of the roles of the counterparties to the agreement.
  */
case class AgreementTerms(agreement: Agreement,
    clauseLibrary: Option[Boolean],
    counterparty: List[Counterparty]) {
}

/**
  * Used to combine two or more Collateral Criteria using AND logic.
  *
  * @param allCriteria 
  */
case class AllCriteria(allCriteria: List[CollateralCriteria]) {
}

/**
  * A class to specify a currency amount or a currency amount schedule.
  *
  * @param currency The currency in which the amount schedule is denominated. The currency is specified outside of the actual schedule in order to be applied uniformly to it. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
  * @param value The initial rate or amount, as the case may be. An initial rate of 5% would be represented as 0.05.
  * @param datedValue The schedule of step date and value pairs. On each step date the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
  */
case class AmountSchedule(currency: List[FieldWithMetaString],
    value: scala.math.BigDecimal,
    datedValue: List[DatedValue])
  extends ScheduleTrait {
}

/**
  * Holds an identifier for an ancillary entity, either identified directly via its ancillary role or directly as a legal entity.
  *
  * @param ancillaryParty Identifies a party via its ancillary role on a transaction (e.g. CCP or DCO through which the trade should be cleared.)
  * @param legalEntity 
  */
case class AncillaryEntity(@JsonDeserialize(contentAs = classOf[AncillaryRoleEnum.Value])
    @JsonScalaEnumeration(classOf[AncillaryRoleEnum.Class])
    ancillaryParty: Option[AncillaryRoleEnum.Value],
    legalEntity: Option[LegalEntity]) {
}

/**
  * Defines an ancillary role enumerated value with an associated party reference. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and this AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
  *
  * @param role Specifies the AncillaryRoleEnum that is associated to the party reference. An ancillary party is any involved party that is not one of the two principal parties to the transaction.
  * @param partyReference Specifies the party, or parties, associated to the ancillary role.
  * @param onBehalfOf Optionally specifies the counterparty that the ancillary party is acting on behalf of.
  */
case class AncillaryParty(@JsonScalaEnumeration(classOf[AncillaryRoleEnum.Class])
    role: AncillaryRoleEnum.Value,
    partyReference: List[ReferenceWithMetaParty],
    @JsonDeserialize(contentAs = classOf[CounterpartyRoleEnum.Value])
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    onBehalfOf: Option[CounterpartyRoleEnum.Value]) {
}

/**
  * Used to combine two or more Collateral Criteria using OR logic.
  *
  * @param anyCriteria 
  */
case class AnyCriteria(anyCriteria: List[CollateralCriteria]) {
}

/**
  * As per ISDA 2002 Definitions.
  *
  * @param averagingInOut 
  * @param strikeFactor The factor of strike.
  * @param averagingPeriodIn The averaging in period.
  * @param averagingPeriodOut The averaging out period.
  */
case class Asian(@JsonScalaEnumeration(classOf[AveragingInOutEnum.Class])
    averagingInOut: AveragingInOutEnum.Value,
    strikeFactor: Option[scala.math.BigDecimal],
    averagingPeriodIn: Option[AveragingPeriod],
    averagingPeriodOut: Option[AveragingPeriod]) {
}

/**
  * An Asset is defined as something that can be owned and transferred in the financial markets. As a choice data type, one and only one of the attributes must be used.
  *
  * @param Cash An Asset that consists solely of a monetary holding in a currency.
  * @param Commodity An Asset comprised of raw or refined materials or agricultural products, eg gold, oil or wheat.
  * @param DigitalAsset An Asset that exists only in digital form, eg Bitcoin or Ethereum; excludes the digital representation of other Assets.
  * @param Instrument An asset that is issued by one party to one or more others; Instrument is also a choice data type.
  */
case class Asset(cash: Option[Cash],
    commodity: Option[Commodity],
    digitalAsset: Option[DigitalAsset],
    instrument: Option[Instrument])
  extends AssetTrait {
}

case class AssetAgencyRating(assetAgencyRating: AgencyRatingCriteria) {
}

/**
  * The base data type to specify common attributes for all Assets.
  *
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class AssetBase(identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends AssetBaseTrait {
}

case class AssetCountryOfOrigin(@JsonScalaEnumeration(classOf[ISOCountryCodeEnum.Class])
    assetCountryOfOrigin: ISOCountryCodeEnum.Value) {
}

/**
  * Contains the information relative to the delivery of the asset.
  *
  * @param periods Defines the periods of delivery, including the delivery profile.
  * @param location Defines the location of the delivery of the commodity.
  * @param deliveryCapacity The number of units included in the transaction for each delivery interval
  */
case class AssetDeliveryInformation(periods: Option[AssetDeliveryPeriods],
    location: List[LocationIdentifier],
    deliveryCapacity: Option[Quantity]) {
}

/**
  * Defines the periods of delivery, including the delivery profile.
  *
  * @param profile Defines the delivery profile of the asset, including the load type and the delivery intervals.
  * @param startDate Delivery start date
  * @param endDate Delivery end date
  */
case class AssetDeliveryPeriods(profile: List[AssetDeliveryProfile],
    startDate: Option[java.time.LocalDate],
    endDate: Option[java.time.LocalDate])
  extends AssetDeliveryPeriodsTrait {
}

/**
  * Defines the delivery profile of the asset, including the load type and the delivery intervals.
  *
  * @param loadType Identification of the delivery profile.
  * @param block Defines a delivery profile block, including start and end time, days of the week, duration, delivery capacity and price time interval quantity.
  * @param bankHolidaysTreatment Specifies whether the dates defined include holidays or not.
  */
case class AssetDeliveryProfile(@JsonDeserialize(contentAs = classOf[LoadTypeEnum.Value])
    @JsonScalaEnumeration(classOf[LoadTypeEnum.Class])
    loadType: Option[LoadTypeEnum.Value],
    block: List[AssetDeliveryProfileBlock],
    @JsonDeserialize(contentAs = classOf[BankHolidayTreatmentEnum.Value])
    @JsonScalaEnumeration(classOf[BankHolidayTreatmentEnum.Class])
    bankHolidaysTreatment: Option[BankHolidayTreatmentEnum.Value]) {
}

/**
  * Defines a delivery profile block, including start and end time, days of the week, duration, delivery capacity and price time interval quantity.
  *
  * @param startTime The start time of the delivery interval for each block or shape.
  * @param endTime The end time of the delivery interval for each block or shape.
  * @param dayOfWeek The days of the week of the delivery.
  * @param deliveryCapacity The number of units included in the transaction for each delivery interval
  * @param priceTimeIntervalQuantity Price per quantity per delivery time interval.
  */
case class AssetDeliveryProfileBlock(startTime: Option[java.time.LocalTime],
    endTime: Option[java.time.LocalTime],
    @JsonScalaEnumeration(classOf[DayOfWeekEnum.Class])
    dayOfWeek: List[DayOfWeekEnum.Value],
    deliveryCapacity: Option[Quantity],
    priceTimeIntervalQuantity: Option[Price]) {
}

/**
  * Defines the basic parameters of an asset transfer, e.g. a cashflow: what (the asset), how much (the quantity) and when (the settlement date).
  *
  * @param quantity Represents the amount of the asset to be transferred. The cashflow amount is always a positive number, as the cashflow direction is implied by the payer/receiver attribute.
  * @param asset Represents the object that is subject to the transfer, it could be an asset or a reference.
  * @param settlementDate Represents the date on which the transfer to due.
  */
case class AssetFlowBase(quantity: NonNegativeQuantity,
    asset: Asset,
    settlementDate: AdjustableOrAdjustedOrRelativeDate)
  extends AssetFlowBaseTrait {
}

/**
  * The unique identifier for an Asset, specified using an Asset Identifier Type enumerator.
  *
  * @param identifier The identifier value.
  * @param identifierType Defines the symbology source of the Asset Identifier, eg CUSIP, ISIN, etc.
  */
case class AssetIdentifier(identifier: FieldWithMetaString,
    @JsonScalaEnumeration(classOf[AssetIdTypeEnum.Class])
    identifierType: AssetIdTypeEnum.Value) {
}

/**
  * Defines each asset movement of an asset payout.
  *
  * @param settlementDate Specifies the settlement date of securities.  In a repo transaction the purchase date would always be the effective date as specified under Economic Terms, the repurchase date would always be the termination date as specified under Economic Terms.
  * @param deliveryMethod Specifies a delivery method for the security transaction.
  */
case class AssetLeg(settlementDate: AdjustableOrRelativeDate,
    @JsonScalaEnumeration(classOf[DeliveryMethodEnum.Class])
    deliveryMethod: DeliveryMethodEnum.Value) {
}

case class AssetMaturity(@JsonScalaEnumeration(classOf[MaturityTypeEnum.Class])
    maturityType: MaturityTypeEnum.Value,
    maturityRange: PeriodRange) {
}

/**
  * Security finance payout specification in case the product payout involves some form of security collateral, as in a securities financing transaction. Plus additional description for ICMA.
  *
  * @param assetLeg Defines each asset movement as a buy/sell at different dates, typically 1 near leg and 1 far leg in a securities financing transaction.
  * @param underlier Specifies the Purchased Asset, usually a Security.
  * @param minimumFee A contractual minimum amount which the borrower will pay, regardless of the duration of the loan. A mechanism for making sure that a trade generates enough income.
  * @param dividendTerms Specifies the terms under which dividends received by the borrower are passed through to the lender.
  * @param tradeType The trade type, eg repurchase transaction or buy/sell-back.
  * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
  * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
  * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
  * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
  */
case class AssetPayout(assetLeg: List[AssetLeg],
    underlier: Asset,
    minimumFee: Option[Money],
    dividendTerms: Option[DividendTerms],
    @JsonDeserialize(contentAs = classOf[AssetPayoutTradeTypeEnum.Value])
    @JsonScalaEnumeration(classOf[AssetPayoutTradeTypeEnum.Class])
    tradeType: Option[AssetPayoutTradeTypeEnum.Value],
    payerReceiver: PayerReceiver,
    priceQuantity: Option[ResolvablePriceQuantity],
    principalPayment: Option[PrincipalPayments],
    settlementTerms: Option[SettlementTerms])
  extends PayoutBaseTrait {
}

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
case class AssetType(@JsonScalaEnumeration(classOf[AssetTypeEnum.Class])
    assetType: AssetTypeEnum.Value,
    @JsonDeserialize(contentAs = classOf[InstrumentTypeEnum.Value])
    @JsonScalaEnumeration(classOf[InstrumentTypeEnum.Class])
    securityType: Option[InstrumentTypeEnum.Value],
    debtType: Option[DebtType],
    @JsonDeserialize(contentAs = classOf[EquityTypeEnum.Value])
    @JsonScalaEnumeration(classOf[EquityTypeEnum.Class])
    equityType: Option[EquityTypeEnum.Value],
    @JsonDeserialize(contentAs = classOf[FundProductTypeEnum.Value])
    @JsonScalaEnumeration(classOf[FundProductTypeEnum.Class])
    fundType: Option[FundProductTypeEnum.Value],
    otherAssetType: List[String]) {
}

/**
  * A class to specify the identifier value and its associated version.
  *
  * @param identifier The identifier value.
  * @param version The identifier version, which is specified as an integer and is meant to be incremented each time the transaction terms (whether contract or event) change. This version is made option to support the use case where the identifier is referenced without the version. The constraint that a contract and a lifecycle event need to have an associated version is enforced through data rules.
  */
case class AssignedIdentifier(identifier: FieldWithMetaString,
    version: Option[Int]) {
}

/**
  * A type to define automatic exercise of a swaption. With automatic exercise the option is deemed to have exercised if it is in the money by more than the threshold amount on the exercise date.
  *
  * @param thresholdRate A threshold rate. The threshold of 0.10% would be represented as 0.001
  * @param isApplicable Boolean that indicates if it has an automaticExercise
  */
case class AutomaticExercise(thresholdRate: Option[scala.math.BigDecimal],
    isApplicable: Option[Boolean]) {
}

/**
  * A data type that can be used to describe the inventory of securities that a party holds. The securities are held in the AvailableInventoryRecord, with each item in the array being an individual security and its associated criteria. Criteria can include the quantity available, the rate at which the security is available to borrow at, as well as other details that can affect the decision as to whether a party wants to utilise the securities listed.
  *
  * @param availableInventoryType Defines the purpose of this inventory.
  * @param messageInformation Allows details related to the availability messaging use case to be defined
  * @param party Defines all parties involved for the list of inventory records in this set of inventory. For example, when used to describe securities lending availability, this could hold the sender of the availability, the intended recipient, the beneficial owner(s), the lender (which may differ from the sender as the lender may have the same piece of availability going through multiple agents), an agent or a venue.
  * @param partyRole Defines the role(s) that party(ies) may have in relation to the inventory.
  * @param availableInventoryRecord An array holding the list of inventory being described. Each element in the inventoryRecord array represents an individual piece of inventory i.e. a security.
  */
case class AvailableInventory(@JsonScalaEnumeration(classOf[AvailableInventoryTypeEnum.Class])
    availableInventoryType: AvailableInventoryTypeEnum.Value,
    messageInformation: Option[MessageInformation],
    party: List[Party],
    partyRole: List[PartyRole],
    availableInventoryRecord: List[AvailableInventoryRecord])
  extends AvailableInventoryTrait {
}

/**
  * An individual piece of available inventory. This represents a single security and its associated criteria. The criteria are used to describe any restrictions on the securities.
  *
  * @param expirationDateTime There may be a set period/time restriction associated to the security.
  * @param collateral The type of collateral can often be required when determining if the piece of availability being described is suitable for a party.
  * @param partyRole An individual security may be held by several agents. Including the party role at this level allows us to reference the party holding this specific item.
  * @param quantity The quantity of the security
  * @param interestRate An optional element which can be used to hold a rate associated to this piece of availability.
  * @param identifer Unique identifier for this record. This can be used to uniquely identify a specific piece of inventory.
  * @param security The security details.
  */
case class AvailableInventoryRecord(expirationDateTime: Option[java.time.ZonedDateTime],
    collateral: List[CollateralProvisions],
    partyRole: List[PartyRole],
    quantity: Option[Quantity],
    interestRate: Option[Price],
    identifer: AssignedIdentifier,
    security: Security)
  extends InventoryRecordTrait {
}

/**
  * Represents the average trading volume of an Equity product upon an exchange or set of exchanges.
  *
  * @param period Represents the period of the equities average trading volume on the exchange/s.
  * @param methodology Indicates the type of equity average trading volume being stated (single) the highest amount on one exchange, or (consolidated) volumes across multiple exchanges.
  */
case class AverageTradingVolume(period: Period,
    @JsonScalaEnumeration(classOf[AverageTradingVolumeMethodologyEnum.Class])
    methodology: AverageTradingVolumeMethodologyEnum.Value) {
}

/**
  * Defines parameters for use in cases when a valuation or other term is based on an average of market observations.
  *
  * @param averagingMethod Specifies enumerations for the type of averaging calculation.
  * @param precision Rounding applied to the average calculation. 
  */
case class AveragingCalculation(averagingMethod: AveragingCalculationMethod,
    precision: Rounding) {
}

/**
  * Defines the ways in which multiple values can be aggregated into a single value.
  *
  * @param isWeighted Identifies whether the average values will be weighted or unweighted.
  * @param calculationMethod Identifies which of the Pythagorean means is being used to compute an average value.
  */
case class AveragingCalculationMethod(isWeighted: Boolean,
    @JsonScalaEnumeration(classOf[AveragingCalculationMethodEnum.Class])
    calculationMethod: AveragingCalculationMethodEnum.Value) {
}

/**
  * An unordered list of weighted averaging observations.
  *
  * @param averagingObservation A single weighted averaging observation.
  */
case class AveragingObservationList(averagingObservation: List[WeightedAveragingObservation]) {
}

/**
  * Period over which an average value is taken.
  *
  * @param schedule A schedule for generating averaging observation dates.
  * @param averagingDateTimes An unweighted list of averaging observation date and times.
  * @param averagingObservations A weighted list of averaging observation date and times.
  * @param marketDisruption The market disruption event as defined by ISDA 2002 Definitions.
  */
case class AveragingPeriod(schedule: List[AveragingSchedule],
    averagingDateTimes: Option[DateTimeList],
    averagingObservations: Option[AveragingObservationList],
    marketDisruption: Option[FieldWithMetaMarketDisruptionEnum]) {
}

/**
  * Class to representing a method for generating a series of dates.
  *
  * @param startDate Date on which this period begins.
  * @param endDate Date on which this period ends.
  * @param averagingPeriodFrequency The frequency at which averaging period occurs with the regular part of the valuation schedule and their roll date convention.
  */
case class AveragingSchedule(startDate: java.time.LocalDate,
    endDate: java.time.LocalDate,
    averagingPeriodFrequency: CalculationPeriodFrequency) {
}

/**
  * Defines the terms required to calculate the average observations associated with an averaging strike.
  *
  * @param averagingCalculation Defines parameters for use in cases when a valuation or other term is based on an average of market observations.
  * @param observationTerms Class containing terms that are associated with observing a price/benchmark/index across either single or multple observations. 
  */
case class AveragingStrikeFeature(averagingCalculation: AveragingCalculation,
    observationTerms: ObservationTerms) {
}

/**
  * As per ISDA 2002 Definitions.
  *
  * @param barrierCap A trigger level approached from beneath.
  * @param barrierFloor A trigger level approached from above.
  */
case class Barrier(barrierCap: Option[TriggerEvent],
    barrierFloor: Option[TriggerEvent]) {
}

/**
  * Defines a custom basket by referencing an identifier and its constituents.
  *
  * @param basketConstituent Identifies the constituents of the basket
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class Basket(basketConstituent: List[FieldWithMetaBasketConstituent],
    identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends AssetBaseTrait {
}

/**
  * Identifies the constituents of the basket
  *
  * @param quantity Specifies a quantity schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->quantity that this quantity is referencing.
  * @param initialValuationPrice Specifies an initial price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->price that this price is referencing.
  * @param interimValuationPrice Specifies an interim price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->price that this price is referencing.
  * @param finalValuationPrice Specifies a final price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->price that this price is referencing.
  * @param Asset The object to be observed is an Asset, ie something that can be owned and transferred in the financial markets.
  * @param Basket The object to be observed is a Basket, ie a collection of Observables with an identifier and optional weightings.
  * @param Index The object to be observed is an Index, ie an observable computed on the prices, rates or valuations of a number of assets.
  */
case class BasketConstituent(quantity: List[ReferenceWithMetaNonNegativeQuantitySchedule],
    initialValuationPrice: List[ReferenceWithMetaPriceSchedule],
    interimValuationPrice: List[ReferenceWithMetaPriceSchedule],
    finalValuationPrice: List[ReferenceWithMetaPriceSchedule],
    asset: Option[Asset],
    basket: Option[Basket],
    index: Option[Index])
  extends ObservableTrait {
}

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
case class BasketReferenceInformation(basketName: Option[FieldWithMetaString],
    basketId: List[FieldWithMetaString],
    referencePool: ReferencePool,
    nthToDefault: Option[Int],
    mthToDefault: Option[Int],
    tranche: Option[Tranche]) {
}

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
case class BillingInstruction(sendingParty: Party,
    receivingParty: Party,
    billingStartDate: java.time.LocalDate,
    billingEndDate: java.time.LocalDate,
    billingRecordInstruction: List[BillingRecordInstruction],
    billingSummary: List[BillingSummaryInstruction]) {
}

/**
  * Specifies individual records within a billing invoice.
  *
  * @param tradeState The trade for the individual billing record.
  * @param recordTransfer The settlement terms for the billing record
  * @param recordStartDate The starting date of the period described by this record
  * @param recordEndDate The ending date of the period described by this record
  * @param minimumFee Indicates the minimum fee amount applied to the billing record, if any.
  */
case class BillingRecord(tradeState: ReferenceWithMetaTradeState,
    recordTransfer: Transfer,
    recordStartDate: java.time.LocalDate,
    recordEndDate: java.time.LocalDate,
    minimumFee: Option[Money]) {
}

/**
  * Specifies the instructions for creation of a billing record.
  *
  * @param tradeState The trade for the individual billing record.
  * @param observation The observations used to calculate the billing amount.
  * @param recordStartDate The starting date of the period described by this record
  * @param recordEndDate The ending date of the period described by this record
  * @param settlementDate The date for settlement of the transfer.
  */
case class BillingRecordInstruction(tradeState: ReferenceWithMetaTradeState,
    observation: List[Observation],
    recordStartDate: java.time.LocalDate,
    recordEndDate: java.time.LocalDate,
    settlementDate: java.time.LocalDate) {
}

/**
  * Specifies individual summaries within a billing invoice.
  *
  * @param summaryTransfer The settlement terms for the billing summary
  * @param summaryAmountType The account level for the billing summary.
  */
case class BillingSummary(summaryTransfer: Option[Transfer],
    @JsonScalaEnumeration(classOf[RecordAmountTypeEnum.Class])
    summaryAmountType: RecordAmountTypeEnum.Value) {
}

/**
  * Specifies the instructions for creation of a billing summary.
  *
  * @param summaryAmountType The account level for the billing summary.
  */
case class BillingSummaryInstruction(@JsonScalaEnumeration(classOf[RecordAmountTypeEnum.Class])
    summaryAmountType: RecordAmountTypeEnum.Value) {
}

/**
  * Reference to a bond underlier to represent an asset swap or Condition Precedent Bond.
  *
  * @param bond Reference to a bond underlier.
  * @param conditionPrecedentBond To indicate whether the Condition Precedent Bond is applicable. The swap contract is only valid if the bond is issued and if there is any dispute over the terms of fixed stream then the bond terms would be used.
  * @param discrepancyClause To indicate whether the Discrepancy Clause is applicable.
  * @param couponRate Specifies the coupon rate (expressed in percentage) of a fixed income security or convertible bond.
  */
case class BondReference(bond: Security,
    conditionPrecedentBond: Boolean,
    discrepancyClause: Option[Boolean],
    couponRate: Option[FixedRateSpecification]) {
}

/**
  * Describes correlation bounds, which form a cap and a floor on the realized correlation.
  *
  * @param minimumBoundaryPercent Minimum Boundary as a percentage of the Strike Price.
  * @param maximumBoundaryPercent Maximum Boundary as a percentage of the Strike Price.
  */
case class BoundedCorrelation(minimumBoundaryPercent: Option[scala.math.BigDecimal],
    maximumBoundaryPercent: Option[scala.math.BigDecimal]) {
}

case class BoundedVariance(@JsonScalaEnumeration(classOf[RealisedVarianceMethodEnum.Class])
    realisedVarianceMethod: RealisedVarianceMethodEnum.Value,
    daysInRangeAdjustment: Boolean,
    upperBarrier: Option[scala.math.BigDecimal],
    lowerBarrier: Option[scala.math.BigDecimal]) {
}

/**
  * A class for defining a time with respect to a business day calendar location. For example, 11:00:00 GBLO.
  *
  * @param hourMinuteTime A time specified in hh:mm:ss format where the second component must be '00', e.g. 11am would be represented as 11:00:00.
  * @param businessCenter A code identifying a business day calendar location. A business day calendar location is drawn from the list identified by the business day calendar location enumeration.
  */
case class BusinessCenterTime(hourMinuteTime: java.time.LocalTime,
    businessCenter: FieldWithMetaBusinessCenterEnum) {
}

/**
  * A class for specifying the business day calendar location used in determining whether a day is a business day or not, either by specifying this business center by reference to an enumerated list that is maintained by the FpML standard, or by reference to such specification when it exists elsewhere as part of the instance document. This class corresponds to the FpML BusinessCentersOrReference.model.
  *
  * @param businessCenter A code identifying one or several business day calendar location(s). The set of business day calendar locations are specified by the business day calendar location enumeration which is maintained by the FpML standard.
  * @param commodityBusinessCalendar 
  * @param businessCentersReference A reference to a financial business center location specified elsewhere in the instance document.
  * @param meta 
  */
case class BusinessCenters(businessCenter: List[FieldWithMetaBusinessCenterEnum],
    commodityBusinessCalendar: List[FieldWithMetaCommodityBusinessCalendarEnum],
    businessCentersReference: Option[ReferenceWithMetaBusinessCenters],
    meta: Option[MetaFields]) {
}

/**
  * A class defining a range of contiguous business days by defining an unadjusted first date, an unadjusted last date and a business day convention and business centers for adjusting the first and last dates if they would otherwise fall on a non business day in the specified business centers. The days between the first and last date must also be good business days in the specified centers to be counted in the range.
  *
  * @param businessDayConvention The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
  * @param businessCenters The business center(s), specified either explicitly or by reference to those specified somewhere else in the instance document.
  * @param startDate The first date of a date range.
  * @param endDate The last date of a date range.
  */
case class BusinessDateRange(@JsonScalaEnumeration(classOf[BusinessDayConventionEnum.Class])
    businessDayConvention: BusinessDayConventionEnum.Value,
    businessCenters: Option[BusinessCenters],
    startDate: java.time.LocalDate,
    endDate: java.time.LocalDate)
  extends DateRangeTrait {
}

/**
  * A class defining the business day convention and financial business centers used for adjusting any relevant date if it would otherwise fall on a day that is not a business day in the specified business center.
  *
  * @param businessDayConvention The convention for adjusting a date if it would otherwise fall on a day that is not a business day.
  * @param businessCenters The business center(s), specified either explicitly or by reference to those specified somewhere else in the instance document.
  * @param meta 
  */
case class BusinessDayAdjustments(@JsonScalaEnumeration(classOf[BusinessDayConventionEnum.Class])
    businessDayConvention: BusinessDayConventionEnum.Value,
    businessCenters: Option[BusinessCenters],
    meta: Option[MetaFields]) {
}

/**
  * A business event represents a life cycle event of a trade. The combination of the state changes results in a qualifiable life cycle event. An example of a Business Event is a PartialTermination which is a defined by a quantity change primitive event.
  *
  * @param eventQualifier The CDM event qualifier, which corresponds to the outcome of the isEvent qualification logic which qualifies the lifecycle event as a function of its features (e.g. PartialTermination, ClearingSubmission, Novation, ...).
  * @param after Specifies the after trade state(s) created.
  * @param meta 
  * @param intent The intent attribute is meant to be specified when the event qualification cannot be programmatically inferred from the event features. As a result it is only associated with those primitives that can give way to such ambiguity, the quantityChange being one of those. An example of such is a reduction in the trade notional, which could be interpreted as either a trade correction (unless a maximum period of time post-event is specified as part of the qualification), a partial termination or a portfolio rebalancing in the case of an equity swap. On the other hand, an event such as the exercise is not expected to have an associated intent as there should not be ambiguity.
  * @param corporateActionIntent 
  * @param eventDate Specifies the date on which the event is taking place. This date is equal to the trade date in the case of a simple execution.  However it can be different from the trade date, for example in the case of a partial termination.
  * @param effectiveDate The date on which the event contractually takes effect, when different from the event date.
  * @param packageInformation Specifies the package information in case the business event represents several trades executed as a package (hence this attribute is optional). The package information is only instantiated once at the business event level to preserve referential integrity, whereas individual trades make reference to it to identify that they are part of a package.
  * @param instruction Specifies the instructions to create the Business Event.
  */
case class BusinessEvent(eventQualifier: Option[String],
    after: List[TradeState],
    meta: Option[MetaFields],
    @JsonDeserialize(contentAs = classOf[EventIntentEnum.Value])
    @JsonScalaEnumeration(classOf[EventIntentEnum.Class])
    intent: Option[EventIntentEnum.Value],
    @JsonDeserialize(contentAs = classOf[CorporateActionTypeEnum.Value])
    @JsonScalaEnumeration(classOf[CorporateActionTypeEnum.Class])
    corporateActionIntent: Option[CorporateActionTypeEnum.Value],
    eventDate: Option[java.time.LocalDate],
    effectiveDate: Option[java.time.LocalDate],
    packageInformation: Option[IdentifiedList],
    instruction: List[Instruction])
  extends EventInstructionTrait {
}

/**
  * A class to specify an organizational unit.
  *
  * @param name A name used to describe the organizational unit
  * @param identifier An identifier used to uniquely identify the organizational unit
  * @param contactInformation The contact information for such business unit, when different from the contact information associated with the party.
  * @param meta 
  */
case class BusinessUnit(name: String,
    identifier: Option[Identifier],
    contactInformation: Option[ContactInformation],
    meta: Option[MetaFields]) {
}

/**
  * This class corresponds to the FpML BuyerSeller.model construct.
  *
  * @param buyer Buyer party that can be resolved as one of the two principal parties to the transaction. The party that buys this instrument, i.e. pays for this instrument and receives the rights defined by it. ISDA 2002 Equity Definitions section 1.18: `Buyer` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (b)(i) relating to a Swaption: 'Buyer' means the party that will, on each Premium Payment Date, pay to Seller the Premium | ISDA 2006 Definitions article 12.1 (b)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such in the related Confirmation, or the Exercising Party if neither party is specified | ISDA 2006 Definitions article 12.1 (b)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Buyer` means the Fixed Rate Payer.
  * @param seller Seller party that can be resolved as one of the two principal parties to the transaction. The party that sells ('writes') this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. ISDA 2002 Equity Definitions section 1.19: `Seller` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (a)(i) relating to a Swaption: 'Seller' means the party the party specified as such or as writer in the related Confirmation | ISDA 2006 Definitions article 12.1 (a)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such or as writer in the related Confirmation or, if neither party is specified as such, the Non-exercising Party | ISDA 2006 Definitions article 12.1 (a)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Seller` means the Floating Rate Payer.
  */
case class BuyerSeller(@JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    buyer: CounterpartyRoleEnum.Value,
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    seller: CounterpartyRoleEnum.Value)
  extends BuyerSellerTrait {
}

case class Buyr(acctOwnr: AcctOwnr) {
}

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
case class CalculateTransferInstruction(tradeState: TradeState,
    payout: ReferenceWithMetaPayout,
    resets: List[Reset],
    payerReceiver: Option[PayerReceiver],
    quantity: Option[Quantity],
    date: Option[java.time.LocalDate]) {
}

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
case class CalculatedRateDetails(observations: Option[CalculatedRateObservations],
    weightedRates: List[scala.math.BigDecimal],
    growthFactor: List[scala.math.BigDecimal],
    compoundedGrowth: List[scala.math.BigDecimal],
    aggregateValue: Option[scala.math.BigDecimal],
    aggregateWeight: Option[scala.math.BigDecimal],
    calculatedRate: Option[scala.math.BigDecimal]) {
}

/**
  * Type for reporting the observations dates and the corresponding weights going into a daily calculated rate
  *
  * @param observationDates The observation date upon which the rate is observed.
  * @param weights The corresponding weight for each date.
  */
case class CalculatedRateObservationDatesAndWeights(observationDates: List[java.time.LocalDate],
    weights: List[scala.math.BigDecimal]) {
}

/**
  * Type for reporting observations that went into the final reported rate.
  *
  * @param observationDates The observation date upon which the rate is observed.
  * @param weights The corresponding weight for each date.
  * @param observedRates The value observed for that date
  * @param processedRates The value after any processing, such as application of caps or floors.
  */
case class CalculatedRateObservations(observationDates: List[java.time.LocalDate],
    weights: List[scala.math.BigDecimal],
    observedRates: List[scala.math.BigDecimal],
    processedRates: List[scala.math.BigDecimal]) {
}

/**
  * A class defining the ISDA calculation agent responsible for performing duties as defined in the applicable product definitions.
  *
  * @param calculationAgentParty Specifies the party which is the ISDA Calculation Agent for the trade. If more than one party is referenced then the parties are assumed to be co-calculation agents, i.e. they have joint responsibility.
  * @param calculationAgentPartyEnum Specifies the ISDA calculation agent responsible for performing duties as defined in the applicable product definitions. For example, the Calculation Agent may be defined as being the Non-exercising Party.
  * @param calculationAgentBusinessCenter The city in which the office through which ISDA Calculation Agent is acting for purposes of the transaction is located The short-form confirm for a trade that is executed under a Sovereign or Asia Pacific Master Confirmation Agreement ( MCA ), does not need to specify the Calculation Agent. However, the confirm does need to specify the Calculation Agent City. This is due to the fact that the MCA sets the value for Calculation Agent but does not set the value for Calculation Agent City.
  */
case class CalculationAgent(@JsonDeserialize(contentAs = classOf[AncillaryRoleEnum.Value])
    @JsonScalaEnumeration(classOf[AncillaryRoleEnum.Class])
    calculationAgentParty: Option[AncillaryRoleEnum.Value],
    @JsonDeserialize(contentAs = classOf[PartyDeterminationEnum.Value])
    @JsonScalaEnumeration(classOf[PartyDeterminationEnum.Class])
    calculationAgentPartyEnum: Option[PartyDeterminationEnum.Value],
    calculationAgentBusinessCenter: Option[FieldWithMetaBusinessCenterEnum]) {
}

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
case class CalculationFrequency(period: Period,
    monthOfYear: Option[scala.math.BigDecimal],
    dayOfMonth: Option[scala.math.BigDecimal],
    @JsonDeserialize(contentAs = classOf[DayOfWeekEnum.Value])
    @JsonScalaEnumeration(classOf[DayOfWeekEnum.Class])
    dayOfWeek: Option[DayOfWeekEnum.Value],
    weekOfMonth: Option[scala.math.BigDecimal],
    offsetDays: scala.math.BigDecimal,
    dateLocation: BusinessCenterTime,
    @JsonScalaEnumeration(classOf[BusinessCenterEnum.Class])
    businessCenter: List[BusinessCenterEnum.Value]) {
}

/**
  * A data defining:  the parameters used in the calculation of a fixed or floating rate calculation period amount. This data forms:  part of cashflows representation of a swap stream.
  *
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
  * @param adjustedStartDate The calculation period start date, adjusted according to any relevant business day convention.
  * @param adjustedEndDate The calculation period end date, adjusted according to any relevant business day convention.
  * @param meta 
  */
case class CalculationPeriod(unadjustedStartDate: Option[java.time.LocalDate],
    unadjustedEndDate: Option[java.time.LocalDate],
    calculationPeriodNumberOfDays: Option[Int],
    notionalAmount: Option[scala.math.BigDecimal],
    fxLinkedNotionalAmount: Option[FxLinkedNotionalAmount],
    floatingRateDefinition: Option[FloatingRateDefinition],
    fixedRate: Option[scala.math.BigDecimal],
    dayCountYearFraction: Option[scala.math.BigDecimal],
    forecastAmount: Option[Money],
    forecastRate: Option[scala.math.BigDecimal],
    adjustedStartDate: Option[java.time.LocalDate],
    adjustedEndDate: Option[java.time.LocalDate],
    meta: Option[MetaFields])
  extends CalculationPeriodBaseTrait {
}

/**
  * The calculation period adjusted start and end dates, which are the baseline arguments needed to compute an interest accrual calculation.
  *
  * @param adjustedStartDate The calculation period start date, adjusted according to any relevant business day convention.
  * @param adjustedEndDate The calculation period end date, adjusted according to any relevant business day convention.
  * @param meta 
  */
case class CalculationPeriodBase(adjustedStartDate: Option[java.time.LocalDate],
    adjustedEndDate: Option[java.time.LocalDate],
    meta: Option[MetaFields])
  extends CalculationPeriodBaseTrait {
}

case class CalculationPeriodData(startDate: java.time.LocalDate,
    endDate: java.time.LocalDate,
    daysInPeriod: Int,
    daysInLeapYearPeriod: Int,
    isFirstPeriod: Boolean,
    isLastPeriod: Boolean) {
}

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
case class CalculationPeriodDates(effectiveDate: Option[AdjustableOrRelativeDate],
    terminationDate: Option[AdjustableOrRelativeDate],
    calculationPeriodDatesAdjustments: Option[BusinessDayAdjustments],
    firstPeriodStartDate: Option[AdjustableOrRelativeDate],
    firstRegularPeriodStartDate: Option[java.time.LocalDate],
    firstCompoundingPeriodEndDate: Option[java.time.LocalDate],
    lastRegularPeriodEndDate: Option[java.time.LocalDate],
    @JsonDeserialize(contentAs = classOf[StubPeriodTypeEnum.Value])
    @JsonScalaEnumeration(classOf[StubPeriodTypeEnum.Class])
    stubPeriodType: Option[StubPeriodTypeEnum.Value],
    calculationPeriodFrequency: Option[CalculationPeriodFrequency],
    meta: Option[MetaFields]) {
}

/**
  * A class to specify the frequency at which calculation period end dates occur within the regular part of the calculation period schedule and their roll date convention.
  *
  * @param rollConvention The roll convention specifies the period term as part of a periodic schedule, i.e. the calculation period end date within the regular part of the calculation period. The value could be a rule, e.g. IMM Settlement Dates, which is the 3rd Wednesday of the month, or it could be a specific day of the month, such as the first day of the applicable month. It is used in conjunction with a frequency and the regular period start date of a calculation period.
  * @param balanceOfFirstPeriod Indicates, when true, that that the first Calculation Period should run from the Effective Date to the end of the calendar period in which the Effective Date falls, e.g. Jan 15 - Jan 31 if the calculation periods are one month long and Effective Date is Jan 15. If false, the first Calculation Period should run from the Effective Date for one whole period, e.g. Jan 15 to Feb 14 if the calculation periods are one month long and Effective Date is Jan 15. Mostly used in Commmodity Swaps.
  * @param periodMultiplier A time period multiplier, e.g. 1, 2, or 3. If the period value is T (Term) then period multiplier must contain the value 1.
  * @param period A time period, e.g. a day, week, month, year or term of the stream.
  * @param meta 
  */
case class CalculationPeriodFrequency(@JsonScalaEnumeration(classOf[RollConventionEnum.Class])
    rollConvention: RollConventionEnum.Value,
    balanceOfFirstPeriod: Option[Boolean],
    periodMultiplier: Int,
    @JsonScalaEnumeration(classOf[PeriodExtendedEnum.Class])
    period: PeriodExtendedEnum.Value,
    meta: Option[MetaFields])
  extends FrequencyTrait {
}

/**
  * A class that allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
  *
  * @param schedulePeriod Defines a period of a calculation schedule structure.
  */
case class CalculationSchedule(schedulePeriod: List[SchedulePeriod]) {
}

/**
  * Period and time profile over which the delivery takes place.
  *
  * @param deliveryCapacity The number of units included in the transaction for each delivery interval
  * @param priceTimeIntervalQuantity Price per quantity per delivery time interval.
  * @param profile Defines the delivery profile of the asset, including the load type and the delivery intervals.
  * @param startDate Delivery start date
  * @param endDate Delivery end date
  */
case class CalculationScheduleDeliveryPeriods(deliveryCapacity: Option[Quantity],
    priceTimeIntervalQuantity: Option[Price],
    profile: List[AssetDeliveryProfile],
    startDate: Option[java.time.LocalDate],
    endDate: Option[java.time.LocalDate])
  extends AssetDeliveryPeriodsTrait {
}

/**
  * A type for defining a calendar spread feature.
  *
  * @param expirationDateTwo 
  */
case class CalendarSpread(expirationDateTwo: AdjustableOrRelativeDate) {
}

/**
  * A data defining:  the right of a party to cancel a swap transaction on the specified exercise dates. The provision is for 'walk-away' cancellation (i.e. the fair value of the swap is not paid). A fee payable on exercise can be specified. As a difference from the FpML construct, the canonical model extends the BuyerSeller class.
  *
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
  * @param buyer Buyer party that can be resolved as one of the two principal parties to the transaction. The party that buys this instrument, i.e. pays for this instrument and receives the rights defined by it. ISDA 2002 Equity Definitions section 1.18: `Buyer` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (b)(i) relating to a Swaption: 'Buyer' means the party that will, on each Premium Payment Date, pay to Seller the Premium | ISDA 2006 Definitions article 12.1 (b)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such in the related Confirmation, or the Exercising Party if neither party is specified | ISDA 2006 Definitions article 12.1 (b)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Buyer` means the Fixed Rate Payer.
  * @param seller Seller party that can be resolved as one of the two principal parties to the transaction. The party that sells ('writes') this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. ISDA 2002 Equity Definitions section 1.19: `Seller` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (a)(i) relating to a Swaption: 'Seller' means the party the party specified as such or as writer in the related Confirmation | ISDA 2006 Definitions article 12.1 (a)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such or as writer in the related Confirmation or, if neither party is specified as such, the Non-exercising Party | ISDA 2006 Definitions article 12.1 (a)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Seller` means the Floating Rate Payer.
  */
case class CancelableProvision(exerciseNotice: Option[ExerciseNotice],
    followUpConfirmation: Boolean,
    cancelableProvisionAdjustedDates: Option[CancelableProvisionAdjustedDates],
    finalCalculationPeriodDateAdjustment: List[FinalCalculationPeriodDateAdjustment],
    initialFee: Option[Transfer],
    @JsonDeserialize(contentAs = classOf[CallingPartyEnum.Value])
    @JsonScalaEnumeration(classOf[CallingPartyEnum.Class])
    callingParty: Option[CallingPartyEnum.Value],
    earliestDate: Option[AdjustableOrRelativeDate],
    expirationDate: Option[AdjustableOrRelativeDate],
    effectiveDate: Option[AdjustableOrRelativeDates],
    effectivePeriod: Option[Period],
    earliestCancellationTime: Option[BusinessCenterTime],
    latestCancelationTime: Option[BusinessCenterTime],
    exerciseTerms: ExerciseTerms,
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    buyer: CounterpartyRoleEnum.Value,
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    seller: CounterpartyRoleEnum.Value)
  extends BuyerSellerTrait {
}

/**
  * A data to:  define the adjusted dates for a cancelable provision on a swap transaction.
  *
  * @param cancellationEvent The adjusted dates for an individual cancellation date.
  */
case class CancelableProvisionAdjustedDates(cancellationEvent: List[CancellationEvent]) {
}

/**
  * The adjusted dates for a specific cancellation date, including the adjusted exercise date and adjusted termination date.
  *
  * @param adjustedExerciseDate The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
  * @param adjustedEarlyTerminationDate The early termination date that is applicable if an early termination provision is exercised. This date should already be adjusted for any applicable business day convention.
  * @param meta 
  */
case class CancellationEvent(adjustedExerciseDate: java.time.LocalDate,
    adjustedEarlyTerminationDate: java.time.LocalDate,
    meta: Option[MetaFields]) {
}

/**
  * An Asset that consists solely of a monetary holding in a currency. The currency of the Cash asset is held in the string Identifier (from AssetBase) and the AssetIdTypeEnum must be set to define that a CurrencyCode is set.  The function SetCashCurrency can be used to create (or update) a Cash object and the function GetCashCurrency can be used to retrieve the currency of a Cash object.
  *
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class Cash(identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends AssetBaseTrait {
}

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
case class CashCollateralValuationMethod(@JsonDeserialize(contentAs = classOf[CsaTypeEnum.Value])
    @JsonScalaEnumeration(classOf[CsaTypeEnum.Class])
    applicableCsa: Option[CsaTypeEnum.Value],
    cashCollateralCurrency: Option[String],
    cashCollateralInterestRate: Option[FieldWithMetaString],
    agreedDiscountRate: Option[FieldWithMetaString],
    @JsonScalaEnumeration(classOf[PartyDeterminationEnum.Class])
    protectedParty: List[PartyDeterminationEnum.Value],
    prescribedDocumentationAdjustment: Option[Boolean]) {
}

/**
  * Specifies the nature of a cash price either as a fee type, cash price type, or premium expression.
  *
  * @param cashPriceType Specifies the type of Cash Price.
  * @param premiumExpression Specifies a premium when expressed in a way other than an amount, and any required forward starting price definition.
  * @param feeType Specifies the event type associated with a fee.
  */
case class CashPrice(@JsonScalaEnumeration(classOf[CashPriceTypeEnum.Class])
    cashPriceType: CashPriceTypeEnum.Value,
    premiumExpression: Option[PremiumExpression],
    @JsonDeserialize(contentAs = classOf[FeeTypeEnum.Value])
    @JsonScalaEnumeration(classOf[FeeTypeEnum.Class])
    feeType: Option[FeeTypeEnum.Value]) {
}

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
case class CashSettlementTerms(@JsonDeserialize(contentAs = classOf[CashSettlementMethodEnum.Value])
    @JsonScalaEnumeration(classOf[CashSettlementMethodEnum.Class])
    cashSettlementMethod: Option[CashSettlementMethodEnum.Value],
    valuationMethod: Option[ValuationMethod],
    valuationDate: Option[ValuationDate],
    valuationTime: Option[BusinessCenterTime],
    cashSettlementAmount: Option[Money],
    recoveryFactor: Option[scala.math.BigDecimal],
    fixedSettlement: Option[Boolean],
    accruedInterest: Option[Boolean],
    meta: Option[MetaFields]) {
}

/**
  * Class to specify a cashflow, i.e. the outcome of either of computation (e.g. interest accrual) or an assessment of some sort (e.g. a fee). The cashflow can then be turned into a cash transfer, artefact to be used as the input to a payment system or the outcome of it. The associated globalKey denotes the ability to associate a hash value to the Cashflow instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
  *
  * @param payerReceiver Specifies who pays / receives the cashflow, though a normalised Party1 / Party2 enumerator.
  * @param cashflowType The qualification of the type of cashflow, e.g. brokerage fee, premium, upfront fee etc. Particularly relevant when it cannot be inferred directly through lineage.
  * @param paymentDiscounting FpML specifies the FpML PaymentDiscounting.model group for representing the discounting elements that can be associated with a payment.
  * @param quantity Represents the amount of the asset to be transferred. The cashflow amount is always a positive number, as the cashflow direction is implied by the payer/receiver attribute.
  * @param asset Represents the object that is subject to the transfer, it could be an asset or a reference.
  * @param settlementDate Represents the date on which the transfer to due.
  */
case class Cashflow(payerReceiver: PayerReceiver,
    cashflowType: CashflowType,
    paymentDiscounting: Option[PaymentDiscounting],
    quantity: NonNegativeQuantity,
    asset: Asset,
    settlementDate: AdjustableOrAdjustedOrRelativeDate)
  extends AssetFlowBaseTrait {
}

/**
  * A data defining:  the cashflow representation of a swap trade.
  *
  * @param cashflowsMatchParameters A true/false flag to indicate whether the cashflows match the parametric definition of the stream, i.e. whether the cashflows could be regenerated from the parameters without loss of information.
  * @param paymentCalculationPeriod The adjusted payment date and associated calculation period parameters required to calculate the actual or projected payment amount. A list of payment calculation period elements may be ordered in the document by ascending adjusted payment date. An FpML document containing an unordered list of payment calculation periods is still regarded as a conformant document.
  */
case class CashflowRepresentation(cashflowsMatchParameters: Boolean,
    paymentCalculationPeriod: List[PaymentCalculationPeriod]) {
}

/**
  * Characterises the type of cashflow, which can result from either a scheduled or a non-scheduled lifecycle event.
  *
  * @param cashflowType Type of cashflow corresponding to a scheduled event.
  * @param cashPrice Type of cashflow corresponding to a non-scheduled event, where a price must be agreed between the parties.
  * @param priceExpression 
  */
case class CashflowType(@JsonDeserialize(contentAs = classOf[ScheduledTransferEnum.Value])
    @JsonScalaEnumeration(classOf[ScheduledTransferEnum.Class])
    cashflowType: Option[ScheduledTransferEnum.Value],
    cashPrice: Option[CashPrice],
    @JsonDeserialize(contentAs = classOf[PriceExpressionEnum.Value])
    @JsonScalaEnumeration(classOf[PriceExpressionEnum.Class])
    priceExpression: Option[PriceExpressionEnum.Value]) {
}

/**
  * Result for the CheckEligibilityByDetails and CheckEligibilityForProduct functions
  *
  * @param isEligible a simple boolean which is set to true if the asset described in the EligibilityQuery input is eligible
  * @param matchingEligibleCriteria if there was a match, this will be the one or more criteria that were supplied in the EligbilityCollateralSpecification which matched with the query input
  * @param eligibilityQuery a copy of the input query that was checked against the eligible collateral specification
  * @param specification a copy of the input EligbilityCollateralSpecification that was checked against the query
  */
case class CheckEligibilityResult(isEligible: Boolean,
    matchingEligibleCriteria: List[EligibleCollateralCriteria],
    eligibilityQuery: EligibilityQuery,
    specification: EligibleCollateralSpecification) {
}

/**
  * A type for documenting additional clause that cannot yet be represented with the model and yet needed for a digital representation of the agreement
  *
  * @param identifier The  name or identifier associated to this clause 
  * @param terms Content of this bespoke clause
  * @param subcomponents Additional hierarchichal components of the clause if relevant
  */
case class Clause(identifier: Option[String],
    terms: Option[String],
    subcomponents: List[Clause]) {
}

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
case class ClearingInstruction(alphaContract: TradeState,
    clearingParty: Party,
    party1: Party,
    party2: Party,
    clearerParty1: Option[Party],
    clearerParty2: Option[Party],
    isOpenOffer: Option[Boolean]) {
}

/**
  *  A class to qualify the closed state of an execution or a contract through the combination or a state (e.g. terminated, novated) and a set of dates: activity date, effective date and, when relevant, last payment date.
  *
  * @param state The qualification of what gave way to the contract or execution closure, e.g. allocation, termination, ...
  * @param activityDate The activity date on which the closing state took place, i.e. either the event date of the closing event (e.g. option exercise, contract early termination) or the contractual termination date.
  * @param effectiveDate The date on which the closing event contractually takes effect, when different from the activity date. When an explicit event effective date attribute is associated with the closing event, it will be that date. In the case of a cancellation event, it will be the date on which the cancelled event took place.
  * @param lastPaymentDate The date associated with the last payment in relation to the artefact (e.g. contract) to which this closed state applies. As an example, in the case of an early termination event, it would be the settlement date of the associated fee, if applicable.
  */
case class ClosedState(@JsonScalaEnumeration(classOf[ClosedStateEnum.Class])
    state: ClosedStateEnum.Value,
    activityDate: java.time.LocalDate,
    effectiveDate: Option[java.time.LocalDate],
    lastPaymentDate: Option[java.time.LocalDate]) {
}

/**
  * A type for defining the obligations of the counterparty subject to credit support requirements.
  *
  * @param independentAmount Independent Amount is an amount that usually less creditworthy counterparties are asked to provide. It can either be a fixed amount or a percentage of the Transaction's value. The Independent Amount can be: (i) transferred before any trading between the parties occurs (as a deposit at a third party's account or with the counterparty) or (ii) callable after trading has occurred (typically because a downgrade has occurred). In situation (i), the Independent Amount is not included in the calculation of Exposure, but in situation (ii), it is included in the calculation of Exposure. Thus, for situation (ii), the Independent Amount may be transferred along with any collateral call. Independent Amount is a defined term in the ISDA Credit Support Annex. ('with respect to a party, the amount specified as such for that party in Paragraph 13; if no amount is specified, zero').
  * @param portfolioIdentifier A list of identifiers pointing to the collateral portfolios which contain the collateral which covers a trade.
  * @param collateralPortfolio The collateral portfolios which contain the collateral which covers a trade. (NB: this can be provided by reference to a global key for each CollateralPortfolio object)
  * @param collateralProvisions specifies the collateral provisions of the product.
  * @param meta 
  */
case class Collateral(independentAmount: Option[IndependentAmount],
    portfolioIdentifier: List[Identifier],
    collateralPortfolio: List[ReferenceWithMetaCollateralPortfolio],
    collateralProvisions: Option[CollateralProvisions],
    meta: Option[MetaFields]) {
}

/**
  * Represents the parameters needed to calculate the floating rate paid on collateral holdings.
  *
  * @param negativeInterest Specifies how negative rates should be applied.  If rates go negative, should the payment be reversed (true) or zeroed out (false)?
  * @param compressibleSpread Specifies how spreads should be applied in a low/negative rate environment.  If true, spread is applied only if rate is positive.
  * @param rateOption 
  * @param spreadSchedule The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
  * @param capRateSchedule The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
  * @param floorRateSchedule The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
  * @param meta 
  */
case class CollateralAgreementFloatingRate(negativeInterest: Boolean,
    compressibleSpread: Boolean,
    rateOption: Option[ReferenceWithMetaInterestRateIndex],
    spreadSchedule: Option[SpreadSchedule],
    capRateSchedule: Option[StrikeSchedule],
    floorRateSchedule: Option[StrikeSchedule],
    meta: Option[MetaFields])
  extends FloatingRateBaseTrait {
}

/**
  * Represents common attributes to define a collateral balance recorded by the principal as held or posted.
  *
  * @param collateralBalanceStatus Defines the collateral balance breakdown of settlement status.
  * @param haircutIndicator Indicates if the collateral balance amount is based on pre or post haircut, if a haircut is associated with the collateral asset
  * @param amountBaseCurrency Specifies the collateral balance amount in base currency determined within a collateral legal agreement, or defined for reporting purposes.
  * @param payerReceiver Specifies each of the parties in the collateral balance and its perspective with regards to the direction of the collateral balance, posted or received.
  */
case class CollateralBalance(@JsonDeserialize(contentAs = classOf[CollateralStatusEnum.Value])
    @JsonScalaEnumeration(classOf[CollateralStatusEnum.Class])
    collateralBalanceStatus: Option[CollateralStatusEnum.Value],
    @JsonDeserialize(contentAs = classOf[HaircutIndicatorEnum.Value])
    @JsonScalaEnumeration(classOf[HaircutIndicatorEnum.Class])
    haircutIndicator: Option[HaircutIndicatorEnum.Value],
    amountBaseCurrency: Money,
    payerReceiver: PartyReferencePayerReceiver) {
}

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
case class CollateralCriteria(allCriteria: Option[AllCriteria],
    anyCriteria: Option[AnyCriteria],
    negativeCriteria: Option[NegativeCriteria],
    collateralIssuerType: Option[CollateralIssuerType],
    assetType: Option[AssetType],
    issuerCountryOfOrigin: Option[IssuerCountryOfOrigin],
    assetCountryOfOrigin: Option[AssetCountryOfOrigin],
    @JsonDeserialize(contentAs = classOf[CurrencyCodeEnum.Value])
    @JsonScalaEnumeration(classOf[CurrencyCodeEnum.Class])
    currencyCodeEnum: Option[CurrencyCodeEnum.Value],
    issuerName: Option[IssuerName],
    issuerAgencyRating: Option[IssuerAgencyRating],
    sovereignAgencyRating: Option[SovereignAgencyRating],
    assetAgencyRating: Option[AssetAgencyRating],
    assetMaturity: Option[AssetMaturity],
    specificAsset: Option[SpecificAsset],
    collateralTaxonomy: Option[CollateralTaxonomy],
    listingExchange: Option[ListingExchange],
    listingSector: Option[ListingSector],
    index: Option[Index],
    counterpartyOwnIssuePermitted: Option[CounterpartyOwnIssuePermitted],
    domesticCurrencyIssued: Option[DomesticCurrencyIssued]) {
}

/**
  * Represents a set of criteria used to specify and describe collateral.
  *
  * @param collateralCriteria The specific criteria that applies. It can be created using AND, OR and NOT logic, and both asset and issuer characteristics.
  * @param appliesTo Specifies which of the two counterparties the criteria applies to (either one or both counterparties). This attribute is optional, in case the applicable party is already specified elsewhere within a party election.
  * @param restrictTo Restrict the criteria to only apply to a specific type of margin, ie IM or VM.
  * @param ratingPriorityResolution Denotes which Criteria has priority if more than one agency rating applies.
  */
case class CollateralCriteriaBase(collateralCriteria: CollateralCriteria,
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    appliesTo: List[CounterpartyRoleEnum.Value],
    @JsonDeserialize(contentAs = classOf[CollateralMarginTypeEnum.Value])
    @JsonScalaEnumeration(classOf[CollateralMarginTypeEnum.Class])
    restrictTo: Option[CollateralMarginTypeEnum.Value],
    @JsonDeserialize(contentAs = classOf[RatingPriorityResolutionEnum.Value])
    @JsonScalaEnumeration(classOf[RatingPriorityResolutionEnum.Class])
    ratingPriorityResolution: Option[RatingPriorityResolutionEnum.Value])
  extends CollateralCriteriaBaseTrait {
}

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
case class CollateralInterestCalculationParameters(fixedRate: Option[scala.math.BigDecimal],
    floatingRate: Option[CollateralAgreementFloatingRate],
    inBaseCurrency: Boolean,
    @JsonDeserialize(contentAs = classOf[CompoundingTypeEnum.Value])
    @JsonScalaEnumeration(classOf[CompoundingTypeEnum.Class])
    compoundingType: Option[CompoundingTypeEnum.Value],
    @JsonScalaEnumeration(classOf[BusinessCenterEnum.Class])
    compoundingBusinessCenter: List[BusinessCenterEnum.Value],
    @JsonScalaEnumeration(classOf[DayCountFractionEnum.Class])
    dayCountFraction: DayCountFractionEnum.Value,
    rounding: Option[Rounding],
    @JsonDeserialize(contentAs = classOf[RoundingFrequencyEnum.Value])
    @JsonScalaEnumeration(classOf[RoundingFrequencyEnum.Class])
    roundingFrequency: Option[RoundingFrequencyEnum.Value],
    withholdingTaxRate: Option[scala.math.BigDecimal]) {
}

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
case class CollateralInterestHandlingParameters(@JsonScalaEnumeration(classOf[CollateralInterestHandlingEnum.Class])
    interestPaymentHandling: CollateralInterestHandlingEnum.Value,
    @JsonScalaEnumeration(classOf[BusinessCenterEnum.Class])
    paymentBusinessCenter: List[BusinessCenterEnum.Value],
    netPostedAndHeldInterest: Boolean,
    netInterestWithMarginCalls: Boolean,
    includeAccrualInMarginCalc: Boolean,
    accrueInterestOnUnsettledInterest: Option[Boolean],
    onFullReturn: Boolean,
    onPartialReturn: Boolean,
    interestAmountApplication: Option[InterestAmountApplication],
    interestRolloverLimit: Option[NumberBound],
    writeoffLimit: Option[NumberBound],
    @JsonDeserialize(contentAs = classOf[AlternativeToInterestAmountEnum.Value])
    @JsonScalaEnumeration(classOf[AlternativeToInterestAmountEnum.Class])
    alternativeToInterestAmount: Option[AlternativeToInterestAmountEnum.Value],
    alternativeProvision: Option[String],
    cutoffTime: Option[java.time.LocalTime],
    notification: Option[CollateralInterestNotification]) {
}

/**
  * Represents the parameters describing when notifications should be made for required collateral interest transfers.
  *
  * @param trigger Specifies what triggers notification (should be enum) Interest Statement Frequency, Period End Date.
  * @param offset Specifies the number of days before (negative) or after (positive) the trigger event.
  * @param notificationTime Specifies the time of day that the notification should occur.
  * @param notificationDayType The type of days on which notification should occur.
  */
case class CollateralInterestNotification(trigger: String,
    offset: scala.math.BigDecimal,
    notificationTime: java.time.LocalTime,
    @JsonScalaEnumeration(classOf[DayTypeEnum.Class])
    notificationDayType: DayTypeEnum.Value) {
}

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
case class CollateralInterestParameters(@JsonDeserialize(contentAs = classOf[CounterpartyRoleEnum.Value])
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    postingParty: Option[CounterpartyRoleEnum.Value],
    @JsonDeserialize(contentAs = classOf[CollateralMarginTypeEnum.Value])
    @JsonScalaEnumeration(classOf[CollateralMarginTypeEnum.Class])
    marginType: Option[CollateralMarginTypeEnum.Value],
    currency: Option[String],
    interestCalculationParameters: Option[CollateralInterestCalculationParameters],
    interestCalculationFrequency: Option[CalculationFrequency],
    interestHandlingParameters: Option[CollateralInterestHandlingParameters]) {
}

/**
  * Represents a class to allow specification of the type of entity issuing the collateral.
  *
  * @param issuerType Specifies the origin of entity issuing the collateral.
  * @param supraNationalType Specifies debt issued by international organisations and multilateral banks.
  * @param quasiGovernmentType Specifies debt issues by institutions or bodies, typically constituted by statute, with a function mandated by the government and subject to government supervision inclusive of profit- and non-profit making bodies. Includes the US Agencies and GSEs and the EU concept of public sector entities. Excluding any entities which are also Regional Government.
  * @param regionalGovernmentType Specifies Regional government, local authority or municipal.
  * @param specialPurposeVehicleType Specifies a subsidiary company that is formed to undertake a specific business purpose of acquisition and financing of specific assets on a potentially limited recourse basis dependent of how it is designed. E.g. asset backed securities, including securitisations.
  */
case class CollateralIssuerType(@JsonScalaEnumeration(classOf[IssuerTypeEnum.Class])
    issuerType: IssuerTypeEnum.Value,
    @JsonDeserialize(contentAs = classOf[SupraNationalIssuerTypeEnum.Value])
    @JsonScalaEnumeration(classOf[SupraNationalIssuerTypeEnum.Class])
    supraNationalType: Option[SupraNationalIssuerTypeEnum.Value],
    quasiGovernmentType: Option[QuasiGovernmentIssuerType],
    regionalGovernmentType: Option[RegionalGovernmentIssuerType],
    specialPurposeVehicleType: Option[SpecialPurposeVehicleIssuerType]) {
}

/**
  * Represents common attributes to define the details of collateral assets, to be used in margin call messaging and contribute to collateral balances e.g securities in a collateral account.
  *
  * @param portfolioIdentifier Specifies a unique identifier for a set of collateral positions in a portfolio.
  * @param collateralPosition Specifies the individual components of the collateral positions in the collateral portfolio.
  * @param collateralBalance Represents the populated or calculated collateral aggregate balance amount for the collateral portfolio.
  * @param legalAgreement  The specification of a legal agreement between two parties governing the collateral relationship such as Credit Support Agreement or Collateral Transfer Agreement etc. (NB: this can be provided by reference to a global key for each LegalAgreement object).
  * @param meta 
  */
case class CollateralPortfolio(portfolioIdentifier: Option[Identifier],
    collateralPosition: List[CollateralPosition],
    collateralBalance: List[CollateralBalance],
    legalAgreement: Option[ReferenceWithMetaLegalAgreement],
    meta: Option[MetaFields]) {
}

/**
  * Specifies the individual components of collateral positions.
  *
  * @param treatment Specifies if there is any treatment to be applied to collateral, such as percentage discount which will impact collateral value.
  * @param collateralPositionStatus Indicates the collateral positions settlement status.
  * @param priceQuantity Position with many price quantities.
  * @param product The product underlying the position.
  * @param cashBalance The aggregate cost of proceeds
  * @param tradeReference Reference to the Contract, in case product is contractual and the contract has been formed
  */
case class CollateralPosition(treatment: Option[CollateralTreatment],
    @JsonDeserialize(contentAs = classOf[CollateralStatusEnum.Value])
    @JsonScalaEnumeration(classOf[CollateralStatusEnum.Class])
    collateralPositionStatus: Option[CollateralStatusEnum.Value],
    priceQuantity: List[PriceQuantity],
    product: Product,
    cashBalance: Option[Money],
    tradeReference: Option[ReferenceWithMetaTradeState])
  extends PositionTrait {
}

/**
  * Contains collateral attributes which can also inherit information from a GMRA
  *
  * @param collateralType Enumerates the collateral types which are accepted by the Seller.
  * @param eligibleCollateral The eligible collateral as specified in relation to the transaction.
  * @param substitutionProvisions The provisions for collateral substitutions such as how many and when they are allowed.
  */
case class CollateralProvisions(@JsonScalaEnumeration(classOf[CollateralTypeEnum.Class])
    collateralType: CollateralTypeEnum.Value,
    eligibleCollateral: List[EligibleCollateralCriteria],
    substitutionProvisions: Option[SubstitutionProvisions]) {
}

/**
  * Specifies the collateral taxonomy, which is composed of a taxonomy value and a taxonomy source.
  *
  * @param taxonomyValue Specifies the taxonomy value.
  * @param taxonomySource Specifies the taxonomy source.
  */
case class CollateralTaxonomy(taxonomyValue: CollateralTaxonomyValue,
    @JsonScalaEnumeration(classOf[TaxonomySourceEnum.Class])
    taxonomySource: TaxonomySourceEnum.Value) {
}

/**
  * Specifies the collateral taxonomy value, either as a specified enumeration or as a string.
  *
  * @param eu_EMIR_EligibleCollateral Identifies European Union Eligible Collateral Assets classification categories based on EMIR Uncleared Margin Rules. Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM
  * @param uk_EMIR_EligibleCollateral Identifies United Kingdom Eligible Collateral Assets classification categories based on UK Onshored EMIR Uncleared Margin Rules Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: UK EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.
  * @param us_CFTC_PR_EligibleCollateral Identifies US Eligible Collateral Assets classification categories based on Uncleared Margin Rules published by the CFTC and the US Prudential Regulator. Note: While the same basic categories exist in the CFTC and US Prudential Regulators’ margin rules, the precise definitions or application of those rules could differ between the two rules.
  * @param nonEnumeratedTaxonomyValue Identifies the taxonomy value when not specified as an enumeration.
  */
case class CollateralTaxonomyValue(@JsonScalaEnumeration(classOf[EU_EMIR_EligibleCollateralEnum.Class])
    eu_EMIR_EligibleCollateral: List[EU_EMIR_EligibleCollateralEnum.Value],
    @JsonScalaEnumeration(classOf[UK_EMIR_EligibleCollateralEnum.Class])
    uk_EMIR_EligibleCollateral: List[UK_EMIR_EligibleCollateralEnum.Value],
    @JsonScalaEnumeration(classOf[US_CFTC_PR_EligibleCollateralEnum.Class])
    us_CFTC_PR_EligibleCollateral: List[US_CFTC_PR_EligibleCollateralEnum.Value],
    nonEnumeratedTaxonomyValue: List[FieldWithMetaString]) {
}

/**
  * The set of elections which specify a Collateral Transfer Agreement
  *
  */
case class CollateralTransferAgreementElections() {
}

/**
  * Specifies the treatment terms for the eligible collateral criteria specified.
  *
  * @param valuationTreatment Specification of the valuation treatment for the specified collateral.
  * @param concentrationLimit Specification of concentration limits applicable to the collateral criteria.
  * @param isIncluded A boolean attribute to specify whether collateral critieria are inclusion (True) or exclusion (False) criteria.
  */
case class CollateralTreatment(valuationTreatment: Option[CollateralValuationTreatment],
    concentrationLimit: List[ConcentrationLimit],
    isIncluded: Boolean) {
}

/**
  * Specification of the valuation treatment for the specified collateral.
  *
  * @param haircutPercentage Specifies a haircut percentage to be applied to the value of asset and used as a discount factor to the value of the collateral asset,expressed as a percentage in decimal terms. As an example a 0.5% haircut would be represented as a decimal number 0.005.
  * @param marginPercentage Specifies a percentage value of transaction needing to be posted as collateral expressed as a valuation. As an example a 104% requirement would be represented as a decimal number 1.04.
  * @param fxHaircutPercentage Specifies an FX haircut applied to a specific asset which is agreed between the parties (for example, if pledgor eligible collateral is not denominated in the termination currency or under other specified cases in collateral support documents both for initial margin and variation margin).The percentage value is expressed as the discount haircut to the value of the collateral- as an example an 8% FX haircut would be expressed as 0.08.
  * @param additionalHaircutPercentage Specifies a percentage value of any additional haircut to be applied to a collateral asset,the percentage value is expressed as the discount haircut to the value of the collateral- as an example a 5% haircut would be expressed as 0.05. 
  */
case class CollateralValuationTreatment(haircutPercentage: Option[scala.math.BigDecimal],
    marginPercentage: Option[scala.math.BigDecimal],
    fxHaircutPercentage: Option[scala.math.BigDecimal],
    additionalHaircutPercentage: Option[scala.math.BigDecimal]) {
}

/**
  * Identifies a specific commodity by referencing a product identifier or by a product definition.
  *
  * @param commodityProductDefinition Specifies the commodity underlier in the event that no ISDA Commodity Reference Benchmark exists.
  * @param priceQuoteType Describes the required quote type of the underlying price that will be observed. Example values include 'Bid, 'Ask', 'Settlement' (for a futures contract) and 'WeightedAverage' (for some published prices and indices).
  * @param deliveryDateReference Specifies the parameters for identifying the relevant contract date when the commodity reference price is a futures contract.
  * @param description Provides additional information about the commodity underlier.
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class Commodity(commodityProductDefinition: Option[CommodityProductDefinition],
    @JsonScalaEnumeration(classOf[QuotationSideEnum.Class])
    priceQuoteType: QuotationSideEnum.Value,
    deliveryDateReference: Option[DeliveryDateParameters],
    description: Option[String],
    identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends AssetBaseTrait {
}

/**
  * Payout based on the averaged price of a referenced underlier. (e.g. Commodities). Can represent both average (average of many) & bullet (average of 1) pricing
  *
  * @param averagingFeature Indicates if the averaging calculation, when applicable, is weighted or unweighted.
  * @param commodityPriceReturnTerms Defines parameters in which the commodity price is assessed.
  * @param pricingDates Specifies specific dates or parametric rules for the dates on which the price will be determined.
  * @param schedule Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
  * @param calculationPeriodDates Defines the calculation period dates schedule.
  * @param paymentDates Defines the payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the valuation dates).
  * @param underlier Identifies the underlying product that is referenced for pricing of the applicable leg in a swap. Referenced in the '2018 ISDA CDM Equity Confirmation for Security Equity Swap' as Security.
  * @param fxFeature Defines quanto or composite FX features that are included in the swap leg.
  * @param delivery Contains the information relative to the delivery of the asset.
  * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
  * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
  * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
  * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
  */
case class CommodityPayout(averagingFeature: Option[AveragingCalculation],
    commodityPriceReturnTerms: Option[CommodityPriceReturnTerms],
    pricingDates: PricingDates,
    schedule: Option[CalculationSchedule],
    calculationPeriodDates: Option[CalculationPeriodDates],
    paymentDates: PaymentDates,
    underlier: Underlier,
    fxFeature: Option[FxFeature],
    delivery: Option[AssetDeliveryInformation],
    payerReceiver: PayerReceiver,
    priceQuantity: Option[ResolvablePriceQuantity],
    principalPayment: Option[PrincipalPayments],
    settlementTerms: Option[SettlementTerms])
  extends PayoutBaseTrait {
}

/**
  * Defines parameters in which the commodity price is assessed.
  *
  * @param rounding Defines rounding rules and precision to be used in the rounding of a number.
  * @param spread Defines a spread value for one or more defined dates.
  * @param rollFeature Used in conjunction with an exchange-based pricing source. Identifies a way in which the futures contracts referenced will roll between periods. 
  * @param conversionFactor Defines the conversion applied if the quantity unit on contract is different from unit on referenced underlier.
  */
case class CommodityPriceReturnTerms(rounding: Option[Rounding],
    spread: Option[SpreadSchedule],
    rollFeature: Option[RollFeature],
    conversionFactor: Option[scala.math.BigDecimal]) {
}

/**
  * Specifies the commodity underlier in the event that no ISDA Commodity Reference Price exists.
  *
  * @param referenceFramework Specifies the type of commodity.
  * @param priceSource Specifies a publication that provides the commodity price, including, where applicable the details of where in the publication the price is published.  Applicable when the commodity reference price is not a futures contract
  * @param commodityInfoPublisher Specifies the publication where the commodity prices can be found.
  * @param exchangeId  Identifies the exchange from which the reference price should be sourced, using the scheme at the following url: http://www.fpml.org/coding-scheme/external/exchange-id-MIC-1-0
  */
case class CommodityProductDefinition(referenceFramework: CommodityReferenceFramework,
    priceSource: Option[PriceSource],
    @JsonDeserialize(contentAs = classOf[CommodityInformationPublisherEnum.Value])
    @JsonScalaEnumeration(classOf[CommodityInformationPublisherEnum.Class])
    commodityInfoPublisher: Option[CommodityInformationPublisherEnum.Value],
    exchangeId: FieldWithMetaString) {
}

/**
  * Specifies the type of commodity.
  *
  * @param commodityName Identifies the commodity more specifically. Where possible, this should follow the naming convention used in the 2005 ISDA Commodity Definitions SubAnnex A, including the subCommodity and additional qualifiers, but should be limited to 256 characters or less.
  * @param capacityUnit Provides an enumerated value for a capacity unit, generally used in the context of defining quantities for commodities.
  * @param weatherUnit Provides an enumerated values for a weather unit, generally used in the context of defining quantities for commodities.
  * @param currency Defines the currency in which the commodity is priced.
  */
case class CommodityReferenceFramework(commodityName: String,
    @JsonDeserialize(contentAs = classOf[CapacityUnitEnum.Value])
    @JsonScalaEnumeration(classOf[CapacityUnitEnum.Class])
    capacityUnit: Option[CapacityUnitEnum.Value],
    @JsonDeserialize(contentAs = classOf[WeatherUnitEnum.Value])
    @JsonScalaEnumeration(classOf[WeatherUnitEnum.Class])
    weatherUnit: Option[WeatherUnitEnum.Value],
    currency: FieldWithMetaString) {
}

/**
  * Specifies the conditions to be applied for converting into a reference currency when the actual currency rate is not determined upfront.
  *
  * @param determinationMethod Specifies the method according to which an amount or a date is determined.
  * @param relativeDate A date specified as some offset to another date (the anchor date).
  * @param fxSpotRateSource Specifies the methodology (reference source and, optionally, fixing time) to be used for determining a currency conversion rate.
  * @param fixingTime The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
  */
case class Composite(@JsonDeserialize(contentAs = classOf[DeterminationMethodEnum.Value])
    @JsonScalaEnumeration(classOf[DeterminationMethodEnum.Class])
    determinationMethod: Option[DeterminationMethodEnum.Value],
    relativeDate: Option[RelativeDateOffset],
    fxSpotRateSource: Option[FxSpotRateSource],
    fixingTime: Option[BusinessCenterTime]) {
}

/**
  * A class to specify the outcome of a computed amount, for testing purposes.
  *
  * @param callFunction 
  * @param amount 
  * @param currency The currency in which the computed amount is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
  */
case class ComputedAmount(callFunction: String,
    amount: scala.math.BigDecimal,
    currency: Option[FieldWithMetaString]) {
}

/**
  * Represents a class to describe concentration limits that may be applicable to eligible collateral criteria.
  *
  * @param concentrationLimitCriteria Specifies a set of criteria to describe the assets that the concentration limits apply to.
  * @param valueLimit Specifies the value of collateral limit represented as a range.
  * @param percentageLimit Specifies the perecentage of collateral limit represented as a decimal number - example 25% is 0.25.
  */
case class ConcentrationLimit(concentrationLimitCriteria: Option[ConcentrationLimitCriteria],
    valueLimit: Option[MoneyRange],
    percentageLimit: Option[NumberRange]) {
}

/**
  * Respresents a class to describe a set of criteria to describe specific assets that the concentration limits apply to.
  *
  * @param concentrationLimitType Specifies the type of concentration limit to be applied.
  * @param averageTradingVolume Specifies an average trading volume on an exchange in relation to Equity products.
  * @param collateralCriteria The specific criteria that applies. It can be created using AND, OR and NOT logic, and both asset and issuer characteristics.
  * @param appliesTo Specifies which of the two counterparties the criteria applies to (either one or both counterparties). This attribute is optional, in case the applicable party is already specified elsewhere within a party election.
  * @param restrictTo Restrict the criteria to only apply to a specific type of margin, ie IM or VM.
  * @param ratingPriorityResolution Denotes which Criteria has priority if more than one agency rating applies.
  */
case class ConcentrationLimitCriteria(@JsonDeserialize(contentAs = classOf[ConcentrationLimitTypeEnum.Value])
    @JsonScalaEnumeration(classOf[ConcentrationLimitTypeEnum.Class])
    concentrationLimitType: Option[ConcentrationLimitTypeEnum.Value],
    averageTradingVolume: Option[AverageTradingVolume],
    collateralCriteria: CollateralCriteria,
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    appliesTo: List[CounterpartyRoleEnum.Value],
    @JsonDeserialize(contentAs = classOf[CollateralMarginTypeEnum.Value])
    @JsonScalaEnumeration(classOf[CollateralMarginTypeEnum.Class])
    restrictTo: Option[CollateralMarginTypeEnum.Value],
    @JsonDeserialize(contentAs = classOf[RatingPriorityResolutionEnum.Value])
    @JsonScalaEnumeration(classOf[RatingPriorityResolutionEnum.Class])
    ratingPriorityResolution: Option[RatingPriorityResolutionEnum.Value])
  extends CollateralCriteriaBaseTrait {
}

/**
  * A class describing the weight of each of the underlier constituent within the basket, either in absolute or relative terms.
  *
  * @param openUnits The number of units (index or securities) that constitute the underlier of the swap. In the case of a basket swap, this element is used to reference both the number of basket units, and the number of each asset components of the basket when these are expressed in absolute terms.
  * @param basketPercentage The relative weight of each respective basket constituent, expressed in percentage. A basket percentage of 5% would be represented as 0.05.
  */
case class ConstituentWeight(openUnits: Option[scala.math.BigDecimal],
    basketPercentage: Option[scala.math.BigDecimal]) {
}

/**
  * A class to specify the parties' election to specify contact information, in relation to elections such as the Addresses for Transfer or the Demand and Notices as specified in the ISDA Credit Support Annex agreement.
  *
  * @param partyElection The parties' contact information election.
  */
case class ContactElection(partyElection: List[PartyContactInformation]) {
}

/**
  * A class to specify contact information associated with a party: telephone, postal/street address, email and web page.
  *
  * @param telephone The telephone number.
  * @param address The street/postal address.
  * @param email The email address.
  * @param webPage The web page. This attribute is not specified as part of the FpML ContactInformation complex type.
  */
case class ContactInformation(telephone: List[TelephoneNumber],
    address: List[Address],
    email: List[String],
    webPage: List[String]) {
}

/**
  * Encapsulates data features common to trade and position.
  *
  * @param contractDetails Represents information specific to trades or positions involving contractual products.
  * @param executionDetails Defines specific attributes that relate to trade or position executions.
  * @param collateral Represents the collateral obligations of a party.
  */
case class ContractBase(contractDetails: Option[ReferenceWithMetaContractDetails],
    executionDetails: Option[ReferenceWithMetaExecutionDetails],
    collateral: Option[ReferenceWithMetaCollateral])
  extends ContractBaseTrait {
}

/**
  * Defines specific attributes that relate to contractual details of trades.
  *
  * @param documentation Represents the legal document(s) that governs a trade and associated contractual product terms, either as a reference to such documents when specified as part of the CDM, or through identification of some of the key terms of those documents, such as the type of document, the document identifier, the publisher, the document vintage and the agreement date.
  * @param governingLaw Represents the law governing the trade and associated contractual product terms.
  * @param meta 
  */
case class ContractDetails(documentation: List[LegalAgreement],
    governingLaw: Option[FieldWithMetaGoverningLawEnum],
    meta: Option[MetaFields]) {
}

/**
  * Specifies instructions to create a fully formed contract, with optional legal agreements.
  *
  * @param legalAgreement Optional legal agreements associated to the contract being formed, for instance a master agreement.
  */
case class ContractFormationInstruction(legalAgreement: List[LegalAgreement]) {
}

case class ContractualMatrix(matrixType: FieldWithMetaMatrixTypeEnum,
    matrixTerm: Option[FieldWithMetaMatrixTermEnum]) {
}

/**
  * A contractual supplement (such as those published by ISDA) and its publication date that will apply to the trade.
  *
  * @param contractualTermsSupplementType Identifies the form of applicable contractual supplement.
  * @param publicationDate Specifies the publication date of the applicable version of the contractual supplement.
  */
case class ContractualTermsSupplement(contractualTermsSupplementType: FieldWithMetaContractualSupplementTypeEnum,
    publicationDate: Option[java.time.LocalDate]) {
}

/**
  * Specifies the relevant data regarding a corporate action.
  *
  * @param corporateActionType The type of corporate action taking place.
  * @param exDate The date on which the corporate action is known to have taken place.
  * @param payDate The date on which resulting from the corporate action are delivered.
  * @param underlier The underlier impacted by the corporate action.
  */
case class CorporateAction(@JsonScalaEnumeration(classOf[CorporateActionTypeEnum.Class])
    corporateActionType: CorporateActionTypeEnum.Value,
    exDate: java.time.LocalDate,
    payDate: java.time.LocalDate,
    underlier: Underlier) {
}

case class CorrelationReturnTerms(correlationStrikePrice: Price,
    boundedCorrelation: Option[NumberRange],
    numberOfDataSeries: Option[Int],
    valuationTerms: ValuationTerms,
    annualizationFactor: Option[Int],
    dividendApplicability: Option[DividendApplicability],
    equityUnderlierProvisions: Option[EquityUnderlierProvisions],
    sharePriceDividendAdjustment: Option[Boolean],
    expectedN: Int,
    initialLevel: Option[scala.math.BigDecimal],
    @JsonDeserialize(contentAs = classOf[DeterminationMethodEnum.Value])
    @JsonScalaEnumeration(classOf[DeterminationMethodEnum.Class])
    initialLevelSource: Option[DeterminationMethodEnum.Value],
    meanAdjustment: Option[Boolean],
    performance: Option[String])
  extends ReturnTermsBaseTrait {
}

/**
  * Defines a counterparty enumerated value, e.g. Party1 or Party2, with an associated party reference. The product is agnostic to the actual parties to the transaction, with the party references abstracted away from the product definition and replaced by the CounterpartyEnum (e.g. values Party1 or Party2). The CounterpartyEnum can then be positioned in the product (e.g. to specify which counterparty is the payer, receiver etc) and this Counterparty type, which is positioned outside of the product definition, allows the CounterpartyEnum to be associated with an actual party reference.
  *
  * @param role Specifies the CounterpartyEnum, e.g. either Party1 or Party2, that is associated to the partyReference.
  * @param partyReference Specifies the party that is associated to the counterparty.
  */
case class Counterparty(@JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    role: CounterpartyRoleEnum.Value,
    partyReference: ReferenceWithMetaParty) {
}

case class CounterpartyOwnIssuePermitted(counterpartyOwnIssuePermitted: Boolean) {
}

/**
  * A Position describes the accumulated effect of a set of securities or financial transactions.
  *
  * @param positionIdentifier Represents the identifier(s) that uniquely identify a position for an identity issuer. A position can include multiple identifiers, for example an internal position identifer and a UTI (Unique Trade Identifier).
  * @param openDateTime The date and time when the position was opened.
  * @param tradeReference Reference to all the trades that constitute the position.
  * @param party The parties involved in the position, including the Clearing Organization.
  * @param partyRole Represents the role each specified party takes in the position.
  * @param positionBase Encapsulates the core constituents that characterize a position.
  * @param contractDetails Represents information specific to trades or positions involving contractual products.
  * @param executionDetails Defines specific attributes that relate to trade or position executions.
  * @param collateral Represents the collateral obligations of a party.
  */
case class CounterpartyPosition(positionIdentifier: List[PositionIdentifier],
    openDateTime: Option[java.time.LocalDateTime],
    tradeReference: List[ReferenceWithMetaTradeState],
    party: List[Party],
    partyRole: List[PartyRole],
    positionBase: TradableProduct,
    contractDetails: Option[ReferenceWithMetaContractDetails],
    executionDetails: Option[ReferenceWithMetaExecutionDetails],
    collateral: Option[ReferenceWithMetaCollateral])
  extends ContractBaseTrait {
}

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
case class CounterpartyPositionBusinessEvent(@JsonScalaEnumeration(classOf[PositionEventIntentEnum.Class])
    intent: PositionEventIntentEnum.Value,
    @JsonDeserialize(contentAs = classOf[CorporateActionTypeEnum.Value])
    @JsonScalaEnumeration(classOf[CorporateActionTypeEnum.Class])
    corporateActionIntent: Option[CorporateActionTypeEnum.Value],
    eventDate: Option[java.time.LocalDate],
    effectiveDate: Option[java.time.LocalDate],
    packageInformation: Option[IdentifiedList],
    after: List[CounterpartyPositionState]) {
}

/**
  * Defines the fundamental financial information that can be changed by a Primitive Event and by extension any business or life-cycle event. Each PositionState specifies where a Position is in its life-cycle. PositionState is a root type and as such, can be created independently to any other CDM data type, but can also be used as part of the CDM Event Model.
  *
  * @param counterpartyPosition Represents the Position that has been effected by a business or life-cycle event.
  * @param state Represents the State of the Position through its life-cycle.
  * @param observationHistory Represents the observed events related to a particular product or process, such as credit events or corporate actions.
  * @param valuationHistory 
  * @param meta 
  */
case class CounterpartyPositionState(counterpartyPosition: CounterpartyPosition,
    state: Option[State],
    observationHistory: List[ObservationEvent],
    valuationHistory: List[Valuation],
    meta: Option[MetaFields]) {
}

/**
  *  The credit default payout specification provides the details necessary for determining when a credit payout will be triggered as well as the parameters for calculating the payout and the settlement terms. The associated globalKey denotes the ability to associate a hash value to the CreditDefaultPayout instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
  *
  * @param generalTerms The specification of the non-monetary terms for the Credit Derivative Transaction, including the buyer and seller and selected items from the ISDA 2014 Credit Definition article II, such as the reference obligation and related terms.
  * @param protectionTerms Specifies the terms for calculating a payout to protect the buyer of the swap in the case of a qualified credit event. These terms include the applicable credit events, the reference obligation, and in the case of a CDS on mortgage-backed securities, the floatingAmountEvents.
  * @param transactedPrice The qualification of the price at which the contract has been transacted, in terms of market fixed rate, initial points, market price and/or quotation style. In FpML, those attributes are positioned as part of the fee leg.
  * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
  * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
  * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
  * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
  */
case class CreditDefaultPayout(generalTerms: GeneralTerms,
    protectionTerms: List[ProtectionTerms],
    transactedPrice: Option[TransactedPrice],
    payerReceiver: PayerReceiver,
    priceQuantity: Option[ResolvablePriceQuantity],
    principalPayment: Option[PrincipalPayments],
    settlementTerms: Option[SettlementTerms])
  extends PayoutBaseTrait {
}

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
case class CreditEvent(@JsonScalaEnumeration(classOf[CreditEventTypeEnum.Class])
    creditEventType: CreditEventTypeEnum.Value,
    eventDeterminationDate: java.time.LocalDate,
    auctionDate: Option[java.time.LocalDate],
    finalPrice: Option[Price],
    recoveryPercent: Option[scala.math.BigDecimal],
    publiclyAvailableInformation: List[Resource],
    referenceInformation: ReferenceInformation) {
}

case class CreditEventNotice(@JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    notifyingParty: List[CounterpartyRoleEnum.Value],
    @JsonDeserialize(contentAs = classOf[BusinessCenterEnum.Value])
    @JsonScalaEnumeration(classOf[BusinessCenterEnum.Class])
    businessCenter: Option[BusinessCenterEnum.Value],
    publiclyAvailableInformation: Option[PubliclyAvailableInformation]) {
}

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
case class CreditEvents(bankruptcy: Option[Boolean],
    failureToPay: Option[FailureToPay],
    failureToPayPrincipal: Option[Boolean],
    failureToPayInterest: Option[Boolean],
    obligationDefault: Option[Boolean],
    obligationAcceleration: Option[Boolean],
    repudiationMoratorium: Option[Boolean],
    restructuring: Option[Restructuring],
    governmentalIntervention: Option[Boolean],
    distressedRatingsDowngrade: Option[Boolean],
    maturityExtension: Option[Boolean],
    writedown: Option[Boolean],
    impliedWritedown: Option[Boolean],
    defaultRequirement: Option[Money],
    creditEventNotice: Option[CreditEventNotice],
    meta: Option[MetaFields]) {
}

/**
  * Specification of an index based on credit risk, typically composed using corporate debt instruments in a region or industry sector, e.g. the iTraxx indices.
  *
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
  * @param name A description of the Index.
  * @param provider The organisation that creates or maintains the Index.
  * @param assetClass The Asset Class of the Index.
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class CreditIndex(indexSeries: Option[Int],
    indexAnnexVersion: Option[Int],
    indexAnnexDate: Option[java.time.LocalDate],
    indexAnnexSource: Option[FieldWithMetaIndexAnnexSourceEnum],
    excludedReferenceEntity: List[ReferenceInformation],
    tranche: Option[Tranche],
    settledEntityMatrix: Option[SettledEntityMatrix],
    indexFactor: Option[scala.math.BigDecimal],
    @JsonDeserialize(contentAs = classOf[CreditSeniorityEnum.Value])
    @JsonScalaEnumeration(classOf[CreditSeniorityEnum.Class])
    seniority: Option[CreditSeniorityEnum.Value],
    meta: Option[MetaFields],
    name: Option[FieldWithMetaString],
    provider: Option[LegalEntity],
    @JsonDeserialize(contentAs = classOf[AssetClassEnum.Value])
    @JsonScalaEnumeration(classOf[AssetClassEnum.Class])
    assetClass: Option[AssetClassEnum.Value],
    identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends IndexBaseTrait {
}

/**
  * A class to represent the credit limit utilisation information.
  *
  * @param limitApplicable 
  */
case class CreditLimitInformation(limitApplicable: List[LimitApplicableExtended]) {
}

/**
  * Credit limit utilisation breakdown by executed trades and pending orders.
  *
  * @param executed Credit limit utilisation attributable to executed trades.
  * @param pending Credit limit utilisation attributable to pending unexecuted orders.
  */
case class CreditLimitUtilisation(executed: Option[CreditLimitUtilisationPosition],
    pending: Option[CreditLimitUtilisationPosition]) {
}

case class CreditLimitUtilisationPosition(shortPosition: Option[scala.math.BigDecimal],
    longPosition: Option[scala.math.BigDecimal],
    global: Option[scala.math.BigDecimal]) {
}

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
case class CreditNotation(@JsonScalaEnumeration(classOf[CreditRatingAgencyEnum.Class])
    agency: CreditRatingAgencyEnum.Value,
    notation: FieldWithMetaString,
    scale: Option[FieldWithMetaString],
    debt: Option[CreditRatingDebt],
    @JsonDeserialize(contentAs = classOf[CreditRatingOutlookEnum.Value])
    @JsonScalaEnumeration(classOf[CreditRatingOutlookEnum.Class])
    outlook: Option[CreditRatingOutlookEnum.Value],
    @JsonDeserialize(contentAs = classOf[CreditRatingCreditWatchEnum.Value])
    @JsonScalaEnumeration(classOf[CreditRatingCreditWatchEnum.Class])
    creditWatch: Option[CreditRatingCreditWatchEnum.Value]) {
}

/**
  * Represents the credit rating notation higher level construct, which provides the ability to specify multiple rating notations.
  *
  * @param creditNotation Specifies only one credit notation is determined.
  * @param creditNotations Specifies if several credit notations exist, alongside an 'any' or 'all' or all condition.
  */
case class CreditNotations(creditNotation: Option[CreditNotation],
    creditNotations: Option[MultipleCreditNotations]) {
}

/**
  * Specifies the credit rating debt type(s) associated with the credit rating notation and scale. When several debt types are specified, they must be qualified through an 'any' or 'all'.
  *
  * @param debtType Specifies when there is only one debt type. FpML doesn't specify values in relation to the associated scheme, which is hence not specified as an enumeration as part of the CDM.
  * @param debtTypes Specifies if there are several debt types, alongside an 'any' or 'all' or all condition. As an example, Baa1 rating is required for any long term debt and deposit.
  */
case class CreditRatingDebt(debtType: Option[FieldWithMetaString],
    debtTypes: Option[MultipleDebtTypes]) {
}

/**
  * The set of elections which specify a Credit Support Annex or Deed.
  *
  */
case class CreditSupportAgreementElections() {
}

case class Curve(interestRateCurve: Option[InterestRateCurve],
    commodityCurve: Option[FieldWithMetaCommodityReferencePriceEnum]) {
}

/**
  * A class to specify an offset either as a normalized [multiplier, period, dayType] or as a custom provision of type string.
  *
  * @param offset 
  * @param customProvision 
  */
case class CustomisableOffset(offset: Option[Offset],
    customProvision: Option[String]) {
}

/**
  * In its initial iteration, this class is meant to support the DTCC TIW workflow information.
  *
  * @param itemName In this initial iteration, this corresponds to the DTCC TIW element name.
  * @param itemValue In this initial iteration, this corresponds to the DTCC value.
  */
case class CustomisedWorkflow(itemName: String,
    itemValue: String) {
}

/**
  * List of dates.
  *
  * @param date 
  */
case class DateList(date: List[java.time.LocalDate]) {
}

/**
  * A class defining a contiguous series of calendar dates. The date range is defined as all the dates between and including the start and the end date. The start date must fall on or before the end date.
  *
  * @param startDate The first date of a date range.
  * @param endDate The last date of a date range.
  */
case class DateRange(startDate: java.time.LocalDate,
    endDate: java.time.LocalDate)
  extends DateRangeTrait {
}

/**
  * A data to:  provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
  *
  * @param calculationPeriodDatesReference A set of href pointers to calculation period dates defined somewhere else in the document.
  */
case class DateRelativeToCalculationPeriodDates(calculationPeriodDatesReference: List[ReferenceWithMetaCalculationPeriodDates]) {
}

/**
  * A data to:  provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
  *
  * @param paymentDatesReference A set of href pointers to payment dates defined somewhere else in the document.
  */
case class DateRelativeToPaymentDates(paymentDatesReference: List[ReferenceWithMetaPaymentDates]) {
}

/**
  * A data to:  provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
  *
  * @param valuationDatesReference A set of href pointers to valuation period dates defined somewhere else in the document.
  */
case class DateRelativeToValuationDates(valuationDatesReference: List[ReferenceWithMetaPerformanceValuationDates]) {
}

/**
  * List of dateTimes.
  *
  * @param dateTime The CDM specifies that the zoned date time is to be expressed in accordance with ISO 8601, either as UTC as an offset to UTC.
  */
case class DateTimeList(dateTime: List[java.time.ZonedDateTime]) {
}

/**
  * Defines a date and value pair. This definition is used for varying rate or amount schedules, e.g. a notional amortisation or a step-up coupon schedule.
  *
  * @param date The date on which the associated step value becomes effective. This day may be subject to adjustment in accordance with a business day convention.
  * @param value The rate of amount which becomes effective on the associated step date. A rate of 5% would be represented as 0.05.
  * @param meta 
  */
case class DatedValue(date: java.time.LocalDate,
    value: scala.math.BigDecimal,
    meta: Option[MetaFields]) {
}

/**
  * Specifies selected economics of a debt instrument.
  *
  * @param debtSeniority Specifies the order of repayment in the event of a sale or bankruptcy of the issuer or a related party (eg guarantor).
  * @param debtInterest Specifies the general rule for periodic interest rate payment.
  * @param debtPrincipal Specifies the general rule for repayment of principal.
  */
case class DebtEconomics(@JsonDeserialize(contentAs = classOf[DebtSeniorityEnum.Value])
    @JsonScalaEnumeration(classOf[DebtSeniorityEnum.Class])
    debtSeniority: Option[DebtSeniorityEnum.Value],
    @JsonDeserialize(contentAs = classOf[DebtInterestEnum.Value])
    @JsonScalaEnumeration(classOf[DebtInterestEnum.Class])
    debtInterest: Option[DebtInterestEnum.Value],
    @JsonDeserialize(contentAs = classOf[DebtPrincipalEnum.Value])
    @JsonScalaEnumeration(classOf[DebtPrincipalEnum.Class])
    debtPrincipal: Option[DebtPrincipalEnum.Value]) {
}

/**
  * Specifies the type of debt instrument.
  *
  * @param debtClass Specifies the characteristics of a debt instrument.
  * @param debtEconomics Specifies selected financial terms of a debt instrument.
  */
case class DebtType(@JsonDeserialize(contentAs = classOf[DebtClassEnum.Value])
    @JsonScalaEnumeration(classOf[DebtClassEnum.Class])
    debtClass: Option[DebtClassEnum.Value],
    debtEconomics: List[DebtEconomics]) {
}

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
case class DeliverableObligations(accruedInterest: Option[Boolean],
    @JsonDeserialize(contentAs = classOf[ObligationCategoryEnum.Value])
    @JsonScalaEnumeration(classOf[ObligationCategoryEnum.Class])
    category: Option[ObligationCategoryEnum.Value],
    notSubordinated: Option[Boolean],
    specifiedCurrency: Option[SpecifiedCurrency],
    notSovereignLender: Option[Boolean],
    notDomesticCurrency: Option[NotDomesticCurrency],
    notDomesticLaw: Option[Boolean],
    listed: Option[Boolean],
    notContingent: Option[Boolean],
    notDomesticIssuance: Option[Boolean],
    assignableLoan: Option[PCDeliverableObligationCharac],
    consentRequiredLoan: Option[PCDeliverableObligationCharac],
    directLoanParticipation: Option[LoanParticipation],
    transferable: Option[Boolean],
    maximumMaturity: Option[Period],
    acceleratedOrMatured: Option[Boolean],
    notBearer: Option[Boolean],
    fullFaithAndCreditObLiability: Option[Boolean],
    generalFundObligationLiability: Option[Boolean],
    revenueObligationLiability: Option[Boolean],
    indirectLoanParticipation: Option[LoanParticipation],
    excluded: Option[String],
    othReferenceEntityObligations: Option[String]) {
}

/**
  * A class to specify the application of Interest Amount with respect the Delivery Amount.
  *
  * @param standardElection The standard election as specified by an enumeration.
  * @param customElection The custom election that might be specified by the parties to the agreement.
  */
case class DeliveryAmount(@JsonDeserialize(contentAs = classOf[DeliveryAmountElectionEnum.Value])
    @JsonScalaEnumeration(classOf[DeliveryAmountElectionEnum.Class])
    standardElection: Option[DeliveryAmountElectionEnum.Value],
    customElection: Option[String]) {
}

/**
  * Specifies a specific date or the parameters for identifying the relevant contract date when the commodity reference price is a futures contract.
  *
  * @param deliveryNearby Provides a container for the parametric representation that specifies which nearby contract date would be used as a refrence for a price.
  * @param deliveryDate Specifies the specific contract date for the contract that should be referenced for a price.
  * @param deliveryDateRollConvention Specifies, for a Commodity Transaction that references a listed future, the day on which the specified future will roll to the next nearby month prior to the expiration of the referenced future. If the future will not roll at all - i.e. the price will be taken from the expiring contract, 0 days should be specified here. If the future will roll to the next nearby on the last trading day - i.e. the price will be taken from the next nearby on the last trading day, then 1 business day should be specified and so on.
  * @param deliveryDateExpirationConvention Specifies, for a Commodity Transaction that references a listed future, the day on which the specified future will expire ahead of the actual expiration of the referenced future. For example: Z21 Contract expires on 19Nov21, with an adjust of 2D the 'expire' will be 16Nov21. DeliveryDateRollConvention takes precedence. Example: Pricing on the Z21 Contract with NearbyContractDay and a deliveryDateRoll of 10D, Sampling of the F22 Contract will occur on 8Nov21 through the last Date of the Z21 Contract. With an ExpConvention of 5D, the last sampling date on the F22 contract will be 12Nov21.
  */
case class DeliveryDateParameters(deliveryNearby: Option[Offset],
    deliveryDate: Option[AdjustableDate],
    deliveryDateRollConvention: Option[Offset],
    deliveryDateExpirationConvention: Option[Offset]) {
}

case class DerivInstrmAttrbts(xpryDt: String,
    pricMltplr: String,
    undrlygInstrm: UndrlygInstrm,
    dlvryTp: String) {
}

/**
  * Specifies the method according to which an amount or a date is determined.
  *
  * @param determinationMethod Represents a more granular dimention of observation. Typically relevent for resolving a unique equity price, which can be expressed as trade-weighted or volume-weighted averages.
  * @param averagingMethod Specifies enumerations for the type of averaging calculation.
  */
case class DeterminationMethodology(@JsonDeserialize(contentAs = classOf[DeterminationMethodEnum.Value])
    @JsonScalaEnumeration(classOf[DeterminationMethodEnum.Class])
    determinationMethod: Option[DeterminationMethodEnum.Value],
    @JsonDeserialize(contentAs = classOf[AveragingCalculationMethodEnum.Value])
    @JsonScalaEnumeration(classOf[AveragingCalculationMethodEnum.Class])
    averagingMethod: Option[AveragingCalculationMethodEnum.Value]) {
}

/**
  * Defines the roles and related terms which document the agreement of parties about any determination requirements ; mostly about Extraordinary Events, without being necessarily restricted to such scope, as further specified in the particular product at stake e.g. for instance when Calculation Agent is mentioned as the Price Determination Method enumarated value, etc.
  *
  */
case class DeterminationRolesAndTerms() {
}

/**
  * An Asset that exists only in digital form, eg Bitcoin or Ethereum, that is not backed by other Assets; excludes the digital representation of other Assets, eg coins or Tokenised assets.
  *
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class DigitalAsset(identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends AssetBaseTrait {
}

/**
  * A data defining:  discounting information. The 2000 ISDA definitions, section 8.4. discounting (related to the calculation of a discounted fixed amount or floating amount) apply. This type must only be included if discounting applies.
  *
  * @param discountingType The discounting method that is applicable.
  * @param discountRate A discount rate, expressed as a decimal, to be used in the calculation of a discounted amount. A discount amount of 5% would be represented as 0.05.
  * @param discountRateDayCountFraction A discount day count fraction to be used in the calculation of a discounted amount.
  */
case class DiscountingMethod(@JsonScalaEnumeration(classOf[DiscountingTypeEnum.Class])
    discountingType: DiscountingTypeEnum.Value,
    discountRate: Option[scala.math.BigDecimal],
    discountRateDayCountFraction: Option[FieldWithMetaDayCountFractionEnum]) {
}

/**
  * A class to specify the Distributions and Interest Payment provisions applicable to the collateral agreement.
  *
  * @param interestParameters Represents the interest parameters for the various currencies, margin types, posting parties.
  */
case class DistributionAndInterestPayment(interestParameters: List[CollateralInterestParameters]) {
}

/**
  * The parameters which define whether dividends are applicable
  *
  * @param optionsExchangeDividends If present and true, then options exchange dividends are applicable.
  * @param additionalDividends If present and true, then additional dividends are applicable.
  * @param allDividends Represents the European Master Confirmation value of 'All Dividends' which, when applicable, signifies that, for a given Ex-Date, the daily observed Share Price for that day is adjusted (reduced) by the cash dividend and/or the cash value of any non cash dividend per Share (including Extraordinary Dividends) declared by the Issuer. All Dividends in accordance with the ISDA 2002 Equity Derivatives Definitions.
  */
case class DividendApplicability(optionsExchangeDividends: Option[Boolean],
    additionalDividends: Option[Boolean],
    allDividends: Option[Boolean]) {
}

/**
  * A class to specify the currency in which the dividends will be denominated, i.e. either in the dividend currency or in a currency specified as part of the contract.
  *
  * @param currency The currency in which the dividend is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
  * @param determinationMethod Specifies the method according to which the dividend is determined, e.g. the dividend currency.
  * @param currencyReference Reference to a currency specified elsewhere in the document
  */
case class DividendCurrency(currency: Option[FieldWithMetaString],
    @JsonDeserialize(contentAs = classOf[DeterminationMethodEnum.Value])
    @JsonScalaEnumeration(classOf[DeterminationMethodEnum.Class])
    determinationMethod: Option[DeterminationMethodEnum.Value],
    currencyReference: Option[BasicReferenceWithMetaString]) {
}

/**
  * A class to specify the dividend date by reference to another date, with the ability to apply and offset. This class doesn't exist in FpML and is meant to simplify the choice constraint associated with the DividendPaymentDate class.
  *
  * @param dateReference Specification of the dividend date using an enumeration, with values such as the pay date, the ex-date or the record date.
  * @param paymentDateOffset Only to be used when SharePayment has been specified in the dividendDateReference element. The number of Currency Business Days following the day on which the Issuer of the Shares pays the relevant dividend to holders of record of the Shares.
  */
case class DividendDateReference(@JsonScalaEnumeration(classOf[DividendDateReferenceEnum.Class])
    dateReference: DividendDateReferenceEnum.Value,
    paymentDateOffset: Option[Offset]) {
}

/**
  * A class describing the date on which the dividend will be paid/received. This class is also used to specify the date on which the FX rate will be determined, when applicable.
  *
  * @param dividendDateReference 
  * @param dividendDate 
  */
case class DividendPaymentDate(dividendDateReference: Option[DividendDateReference],
    dividendDate: Option[ReferenceWithMetaAdjustableOrRelativeDate]) {
}

/**
  * A class describing the dividend payout ratio associated with an equity underlier. In certain cases the actual ratio is not known on trade inception, and only general conditions are then specified.
  *
  * @param totalRatio Specifies the total actual dividend payout ratio associated with the equity underlier. A ratio of 90% should be expressed at 0.90.
  * @param cashRatio Specifies the cash actual dividend payout ratio associated with the equity underlier. A ratio of 90% should be expressed at 0.90.
  * @param nonCashRatio Specifies the non cash actual dividend payout ratio associated with the equity underlier. A ratio of 90% should be expressed at 0.90.
  * @param basketConstituent In the case of a basket underlier, specifies to which component of the basket this particular set of dividend payout ratios correspond.
  */
case class DividendPayoutRatio(totalRatio: scala.math.BigDecimal,
    cashRatio: Option[scala.math.BigDecimal],
    nonCashRatio: Option[scala.math.BigDecimal],
    basketConstituent: Option[ReferenceWithMetaBasketConstituent]) {
}

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
case class DividendPeriod(startDate: Option[DividendPaymentDate],
    endDate: Option[DividendPaymentDate],
    dateAdjustments: BusinessDayAdjustments,
    basketConstituent: Option[ReferenceWithMetaBasketConstituent],
    dividendPaymentDate: DividendPaymentDate,
    dividendValuationDate: Option[AdjustableOrRelativeDate]) {
}

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
case class DividendReturnTerms(dividendPayoutRatio: List[DividendPayoutRatio],
    dividendReinvestment: Option[Boolean],
    @JsonDeserialize(contentAs = classOf[DividendEntitlementEnum.Value])
    @JsonScalaEnumeration(classOf[DividendEntitlementEnum.Class])
    dividendEntitlement: Option[DividendEntitlementEnum.Value],
    @JsonDeserialize(contentAs = classOf[DividendAmountTypeEnum.Value])
    @JsonScalaEnumeration(classOf[DividendAmountTypeEnum.Class])
    dividendAmountType: Option[DividendAmountTypeEnum.Value],
    performance: Option[String],
    @JsonDeserialize(contentAs = classOf[DividendPeriodEnum.Value])
    @JsonScalaEnumeration(classOf[DividendPeriodEnum.Class])
    firstOrSecondPeriod: Option[DividendPeriodEnum.Value],
    @JsonDeserialize(contentAs = classOf[AncillaryRoleEnum.Value])
    @JsonScalaEnumeration(classOf[AncillaryRoleEnum.Class])
    extraordinaryDividendsParty: Option[AncillaryRoleEnum.Value],
    @JsonDeserialize(contentAs = classOf[DividendAmountTypeEnum.Value])
    @JsonScalaEnumeration(classOf[DividendAmountTypeEnum.Class])
    excessDividendAmount: Option[DividendAmountTypeEnum.Value],
    dividendCurrency: Option[DividendCurrency],
    @JsonDeserialize(contentAs = classOf[NonCashDividendTreatmentEnum.Value])
    @JsonScalaEnumeration(classOf[NonCashDividendTreatmentEnum.Class])
    nonCashDividendTreatment: Option[NonCashDividendTreatmentEnum.Value],
    @JsonDeserialize(contentAs = classOf[DividendCompositionEnum.Value])
    @JsonScalaEnumeration(classOf[DividendCompositionEnum.Class])
    dividendComposition: Option[DividendCompositionEnum.Value],
    specialDividends: Option[Boolean],
    materialDividend: Option[Boolean],
    dividendPeriod: List[DividendPeriod]) {
}

/**
  * Information related to dividends and payments.
  *
  * @param manufacturedIncomeRequirement Specifies the proportion of the value of the dividend on the borrowed shares that the borrower is legally obligated to return to the lender.
  * @param dividendEntitlement Defines the date on which the receiver of the equity return is entitled to the dividend.
  * @param minimumBillingAmount daily fee increments accrue until a threshold is crossed, at which point payment becomes due)
  */
case class DividendTerms(manufacturedIncomeRequirement: DividendPayoutRatio,
    @JsonDeserialize(contentAs = classOf[DividendEntitlementEnum.Value])
    @JsonScalaEnumeration(classOf[DividendEntitlementEnum.Class])
    dividendEntitlement: Option[DividendEntitlementEnum.Value],
    minimumBillingAmount: Option[Money]) {
}

case class Document(finInstrmRptgTxRpt: FinInstrmRptgTxRpt) {
}

case class DomesticCurrencyIssued(domesticCurrencyIssued: Boolean) {
}

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
case class EarlyTerminationEvent(adjustedExerciseDate: java.time.LocalDate,
    adjustedEarlyTerminationDate: java.time.LocalDate,
    adjustedCashSettlementValuationDate: java.time.LocalDate,
    adjustedCashSettlementPaymentDate: java.time.LocalDate,
    adjustedExerciseFeePaymentDate: Option[java.time.LocalDate],
    meta: Option[MetaFields]) {
}

/**
  * A data defining:  an early termination provision for a swap. This early termination is at fair value, i.e. on termination the fair value of the product must be settled between the parties.
  *
  * @param mandatoryEarlyTermination A mandatory early termination provision to terminate the swap at fair value.
  * @param mandatoryEarlyTerminationDateTenor Period after trade date of the mandatory early termination date.
  * @param optionalEarlyTermination An option for either or both parties to terminate the swap at fair value.
  * @param optionalEarlyTerminationParameters Definition of the first early termination date and the frequency of the termination dates subsequent to that. American exercise is defined by having a frequency of one day.
  * @param meta 
  */
case class EarlyTerminationProvision(mandatoryEarlyTermination: Option[MandatoryEarlyTermination],
    mandatoryEarlyTerminationDateTenor: Option[Period],
    optionalEarlyTermination: Option[OptionalEarlyTermination],
    optionalEarlyTerminationParameters: Option[ExercisePeriod],
    meta: Option[MetaFields]) {
}

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
case class EconomicTerms(effectiveDate: Option[AdjustableOrRelativeDate],
    terminationDate: Option[AdjustableOrRelativeDate],
    dateAdjustments: Option[BusinessDayAdjustments],
    payout: List[Payout],
    terminationProvision: Option[TerminationProvision],
    calculationAgent: Option[CalculationAgent],
    nonStandardisedTerms: Option[Boolean],
    collateral: Option[Collateral]) {
}

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
case class EligibilityQuery(maturity: scala.math.BigDecimal,
    collateralAssetType: AssetType,
    @JsonScalaEnumeration(classOf[ISOCountryCodeEnum.Class])
    assetCountryOfOrigin: ISOCountryCodeEnum.Value,
    @JsonScalaEnumeration(classOf[CurrencyCodeEnum.Class])
    denominatedCurrency: CurrencyCodeEnum.Value,
    agencyRating: AgencyRatingCriteria,
    issuerType: CollateralIssuerType,
    issuerName: LegalEntity) {
}

/**
  * Represents a set of criteria used to specify eligible collateral.
  *
  * @param treatment Identifies the treatment of specified collateral, e.g., haircuts,holding limits or exclusions.
  * @param collateralCriteria The specific criteria that applies. It can be created using AND, OR and NOT logic, and both asset and issuer characteristics.
  * @param appliesTo Specifies which of the two counterparties the criteria applies to (either one or both counterparties). This attribute is optional, in case the applicable party is already specified elsewhere within a party election.
  * @param restrictTo Restrict the criteria to only apply to a specific type of margin, ie IM or VM.
  * @param ratingPriorityResolution Denotes which Criteria has priority if more than one agency rating applies.
  */
case class EligibleCollateralCriteria(treatment: CollateralTreatment,
    collateralCriteria: CollateralCriteria,
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    appliesTo: List[CounterpartyRoleEnum.Value],
    @JsonDeserialize(contentAs = classOf[CollateralMarginTypeEnum.Value])
    @JsonScalaEnumeration(classOf[CollateralMarginTypeEnum.Class])
    restrictTo: Option[CollateralMarginTypeEnum.Value],
    @JsonDeserialize(contentAs = classOf[RatingPriorityResolutionEnum.Value])
    @JsonScalaEnumeration(classOf[RatingPriorityResolutionEnum.Class])
    ratingPriorityResolution: Option[RatingPriorityResolutionEnum.Value])
  extends CollateralCriteriaBaseTrait {
}

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
case class EligibleCollateralSpecification(identifier: List[Identifier],
    party: List[Party],
    counterparty: List[Counterparty],
    criteria: List[EligibleCollateralCriteria],
    partyRole: List[PartyRole],
    meta: Option[MetaFields]) {
}

case class EligibleCollateralSpecificationInstruction(common: EligibleCollateralCriteria,
    variable: List[EligibleCollateralCriteria]) {
}

/**
  * Transaction AdditionalTerms that apply to Equity asset class.
  *
  * @param extraordinaryEvents 
  * @param determinationTerms 
  * @param substitutionProvision 
  */
case class EquityAdditionalTerms(extraordinaryEvents: Option[ExtraordinaryEvents],
    determinationTerms: List[DeterminationRolesAndTerms],
    substitutionProvision: Option[UnderlierSubstitutionProvision]) {
}

/**
  * A class for defining the merger events and their treatment.
  *
  */
case class EquityCorporateEvents() {
}

/**
  * Specification of an index based on equity securities, e.g. the S&P 500..
  *
  * @param name A description of the Index.
  * @param provider The organisation that creates or maintains the Index.
  * @param assetClass The Asset Class of the Index.
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class EquityIndex(name: Option[FieldWithMetaString],
    provider: Option[LegalEntity],
    @JsonDeserialize(contentAs = classOf[AssetClassEnum.Value])
    @JsonScalaEnumeration(classOf[AssetClassEnum.Class])
    assetClass: Option[AssetClassEnum.Value],
    identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends IndexBaseTrait {
}

/**
  * Specification for General Terms and Elections of an Equity Master Confirmation that is applicable across multiple Equity confirmations and is referenced by each of these confirmations, an example of which being the 2018 ISDA CDM Equity Confirmation for Security Equity Swap.
  *
  */
case class EquityMasterConfirmation()
  extends EquityMasterConfirmationTrait with MasterConfirmationBaseTrait {
}

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
case class EquitySwapMasterConfirmation2018(@JsonScalaEnumeration(classOf[ReturnTypeEnum.Class])
    typeOfSwapElection: ReturnTypeEnum.Value,
    pricingMethodElection: PriceReturnTerms,
    @JsonScalaEnumeration(classOf[InterpolationMethodEnum.Class])
    linearInterpolationElection: InterpolationMethodEnum.Value,
    settlementTerms: SettlementTerms,
    valuationDates: ValuationDates,
    equityCashSettlementDates: PaymentDates)
  extends EquityMasterConfirmationTrait {
}

case class EquityUnderlierProvisions(multipleExchangeIndexAnnexFallback: Option[Boolean],
    componentSecurityIndexAnnexFallback: Option[Boolean],
    localJurisdiction: Option[FieldWithMetaString],
    relevantJurisdiction: Option[FieldWithMetaString]) {
}

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
case class EventInstruction(@JsonDeserialize(contentAs = classOf[EventIntentEnum.Value])
    @JsonScalaEnumeration(classOf[EventIntentEnum.Class])
    intent: Option[EventIntentEnum.Value],
    @JsonDeserialize(contentAs = classOf[CorporateActionTypeEnum.Value])
    @JsonScalaEnumeration(classOf[CorporateActionTypeEnum.Class])
    corporateActionIntent: Option[CorporateActionTypeEnum.Value],
    eventDate: Option[java.time.LocalDate],
    effectiveDate: Option[java.time.LocalDate],
    packageInformation: Option[IdentifiedList],
    instruction: List[Instruction])
  extends EventInstructionTrait {
}

/**
  * A class to represent the various set of timestamps that can be associated with lifecycle events, as a collection of [dateTime, qualifier].
  *
  * @param dateTime The CDM specifies that the zoned date time is to be expressed in accordance with ISO 8601, either as UTC as an offset to UTC.
  * @param qualification The timestamp qualifier is specified through an enumeration because the experience of integrating the DTCC and CME data representations suggests that a wide set of timestamps are currently utilized among service providers, while there is not at present an objective set of criteria that could help suggest a defined set of timestamps as part of the CDM. At some future point, one possible baseline could be developed from the review of the set of timestamps specified across regulatory regimes and regulations (incl. regulations such as high frequency trading). Also, the integration with a further set of implementations and the specification of business workflows such as clearing as part of the CDM development should help confirm the implementation approach in this respect.
  */
case class EventTimestamp(dateTime: java.time.ZonedDateTime,
    @JsonScalaEnumeration(classOf[EventTimestampQualificationEnum.Class])
    qualification: EventTimestampQualificationEnum.Value) {
}

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
case class EvergreenProvision(singlePartyOption: Option[PartyRole],
    noticePeriod: RelativeDateOffset,
    noticeDeadlinePeriod: Option[RelativeDateOffset],
    noticeDeadlineDateTime: Option[java.time.ZonedDateTime],
    extensionFrequency: AdjustableRelativeOrPeriodicDates,
    finalPeriodFeeAdjustment: Option[Price]) {
}

case class ExctgPrsn(prsn: Prsn) {
}

/**
  * Defines specific attributes that relate to trade executions.
  *
  * @param executionType Identifies the type of execution, e.g. via voice, electronically...
  * @param executionVenue Represents the venue on which a trade was executed.
  * @param packageReference A reference to the package linking the trade with other trades, in case the trade was executed as part of a package (hence this attribute is optional).
  * @param meta 
  */
case class ExecutionDetails(@JsonScalaEnumeration(classOf[ExecutionTypeEnum.Class])
    executionType: ExecutionTypeEnum.Value,
    executionVenue: Option[LegalEntity],
    packageReference: Option[IdentifiedList],
    meta: Option[MetaFields]) {
}

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
case class ExecutionInstruction(product: NonTransferableProduct,
    priceQuantity: List[PriceQuantity],
    counterparty: List[Counterparty],
    ancillaryParty: List[AncillaryParty],
    parties: List[Party],
    partyRoles: List[PartyRole],
    executionDetails: ExecutionDetails,
    tradeDate: FieldWithMetaLocalDate,
    tradeTime: Option[FieldWithMetaTimeZone],
    tradeIdentifier: List[TradeIdentifier],
    collateral: Option[Collateral],
    lotIdentifier: Option[Identifier]) {
}

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
case class ExerciseEvent(adjustedExerciseDate: java.time.LocalDate,
    adjustedRelevantSwapEffectiveDate: java.time.LocalDate,
    adjustedCashSettlementValuationDate: Option[java.time.LocalDate],
    adjustedCashSettlementPaymentDate: Option[java.time.LocalDate],
    adjustedExerciseFeePaymentDate: Option[java.time.LocalDate],
    meta: Option[MetaFields]) {
}

/**
  * A class defining the fee payable on exercise of an option. This fee may be defined as an amount or a percentage of the notional exercised. As a difference with FpML, it extends the BuyerSeller class.
  *
  * @param notionalReference A pointer style reference to the associated notional schedule defined elsewhere in the document.
  * @param feeAmount The amount of fee to be paid on exercise. The fee currency is that of the referenced notional.
  * @param feeRate A fee represented as a percentage of some referenced notional. A percentage of 5% would be represented as 0.05.
  * @param feePaymentDate The date on which exercise fee(s) will be paid. It is specified as a relative date.
  * @param payer Specifies the counterparty responsible for making the payments defined by this structure.  The party is one of the two principal parties to the transaction.
  * @param receiver Specifies the party that receives the payments corresponding to this structure.  The party is one of the two counterparties to the transaction.
  */
case class ExerciseFee(notionalReference: ReferenceWithMetaMoney,
    feeAmount: Option[scala.math.BigDecimal],
    feeRate: Option[scala.math.BigDecimal],
    feePaymentDate: RelativeDateOffset,
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    payer: CounterpartyRoleEnum.Value,
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    receiver: CounterpartyRoleEnum.Value)
  extends PayerReceiverTrait {
}

/**
  * A class to define a fee or schedule of fees to be payable on the exercise of an option. This fee may be defined as an amount or a percentage of the notional exercised. As a difference with FpML, it extends the BuyerSeller class.
  *
  * @param notionalReference A pointer style reference to the associated notional schedule defined elsewhere in the document.
  * @param feeAmountSchedule The exercise fee amount schedule. The fees are expressed as currency amounts. The currency of the fee is assumed to be that of the notional schedule referenced.
  * @param feeRateSchedule The exercise free rate schedule. The fees are expressed as percentage rates of the notional being exercised. The currency of the fee is assumed to be that of the notional schedule referenced.
  * @param feePaymentDate The date on which exercise fee(s) will be paid. It is specified as a relative date.
  * @param payer Specifies the counterparty responsible for making the payments defined by this structure.  The party is one of the two principal parties to the transaction.
  * @param receiver Specifies the party that receives the payments corresponding to this structure.  The party is one of the two counterparties to the transaction.
  */
case class ExerciseFeeSchedule(notionalReference: ReferenceWithMetaMoney,
    feeAmountSchedule: Option[AmountSchedule],
    feeRateSchedule: Option[Schedule],
    feePaymentDate: RelativeDateOffset,
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    payer: CounterpartyRoleEnum.Value,
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    receiver: CounterpartyRoleEnum.Value)
  extends PayerReceiverTrait {
}

/**
  * Specifies the information required to communicate the choices made by the exercising party, in a financial product endowing the party with at least one option.
  *
  * @param exerciseQuantity Contains instructions for exercising the option including a quantity change, and optionally a transfer.
  * @param exerciseOption Specifies the Option Payout being exercised on the trade.
  * @param exerciseDate Specifies the date on which an option contained within the financial product would be exercised. The date may be omitted if the contractual product allows for only a single date of exercise (European exercise).
  * @param exerciseTime Specifies the time at which an option contained within the financial product woulld be exercised. The time may be omitted if the contractual product allows for only a single time of exercise (European exercise). 
  * @param replacementTradeIdentifier Specifies the trade identifier to apply to the replacement trade for physical exercise.
  */
case class ExerciseInstruction(exerciseQuantity: PrimitiveInstruction,
    exerciseOption: Option[ReferenceWithMetaOptionPayout],
    exerciseDate: Option[AdjustableOrAdjustedDate],
    exerciseTime: Option[BusinessCenterTime],
    replacementTradeIdentifier: List[TradeIdentifier]) {
}

/**
  * Defines to whom and where notice of execution should be given. The exerciseNoticeGiver refers to one or both of the principal parties of the trade. If present the exerciseNoticeReceiver refers to a party, other than the principal party, to whom notice should be given.
  *
  * @param exerciseNoticeGiver Specifies the principal party of the trade that has the right to exercise.
  * @param exerciseNoticeReceiver Specifies the party to which notice of exercise should be given, e.g. by the buyer of the option. Although in many cases it is the buyer of the option who sends the exercise notice to the seller of the option, this component is reused, e.g. in case of OptionEarlyTermination, either or both parties have the right to exercise.
  * @param businessCenter Specifies the location where the exercise must be reported, e.g. where the exercise notice receiver is based.
  */
case class ExerciseNotice(@JsonScalaEnumeration(classOf[ExerciseNoticeGiverEnum.Class])
    exerciseNoticeGiver: ExerciseNoticeGiverEnum.Value,
    @JsonDeserialize(contentAs = classOf[AncillaryRoleEnum.Value])
    @JsonScalaEnumeration(classOf[AncillaryRoleEnum.Class])
    exerciseNoticeReceiver: Option[AncillaryRoleEnum.Value],
    businessCenter: FieldWithMetaBusinessCenterEnum) {
}

/**
  * This defines the time interval to the start of the exercise period, i.e. the earliest exercise date, and the frequency of subsequent exercise dates (if any).
  *
  * @param earliestExerciseDateTenor The time interval to the first (and possibly only) exercise date in the exercise period.
  * @param exerciseFrequency The frequency of subsequent exercise dates in the exercise period following the earliest exercise date. An interval of 1 day should be used to indicate an American style exercise period.
  * @param meta 
  */
case class ExercisePeriod(earliestExerciseDateTenor: Period,
    exerciseFrequency: Option[Period],
    meta: Option[MetaFields]) {
}

/**
  * A class describing how notice of exercise should be given. This can be either manual or automatic.
  *
  * @param manualExercise Specifies that the notice of exercise must be given by the buyer to the seller or seller's agent.
  * @param automaticExercise If automatic is specified, then the notional amount of the underlying swap not previously exercised under the swaption will be automatically exercised at the expiration time on the expiration date if at such time the buyer is in-the-money, provided that the difference between the settlement rate and the fixed rate under the relevant underlying swap is not less than the specified threshold rate. The term in-the-money is assumed to have the meaning defining in the 2000 ISDA Definitions, Section 17.4 In-the-money.
  * @param followUpConfirmation A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller's agent.
  * @param limitedRightToConfirm Has the meaning defined as part of the 1997 ISDA Government Bond Option Definitions, section 4.5 Limited Right to Confirm Exercise. If present, (i) the Seller may request the Buyer to confirm its intent if not done on or before the expiration time on the Expiration date (ii) specific rules will apply in relation to the settlement mode.
  * @param splitTicket Typically applicable to the physical settlement of bond and convertible bond options. If present, means that the party required to deliver the bonds will divide those to be delivered as notifying party desires to facilitate delivery obligations.
  */
case class ExerciseProcedure(manualExercise: Option[ManualExercise],
    automaticExercise: Option[AutomaticExercise],
    followUpConfirmation: Boolean,
    limitedRightToConfirm: Option[Boolean],
    splitTicket: Option[Boolean]) {
}

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
case class ExerciseTerms(@JsonDeserialize(contentAs = classOf[OptionExerciseStyleEnum.Value])
    @JsonScalaEnumeration(classOf[OptionExerciseStyleEnum.Class])
    style: Option[OptionExerciseStyleEnum.Value],
    commencementDate: Option[AdjustableOrRelativeDate],
    exerciseDates: Option[AdjustableOrRelativeDates],
    expirationDate: List[AdjustableOrRelativeDate],
    relevantUnderlyingDate: Option[AdjustableOrRelativeDates],
    earliestExerciseTime: Option[BusinessCenterTime],
    latestExerciseTime: Option[BusinessCenterTime],
    expirationTime: Option[BusinessCenterTime],
    @JsonScalaEnumeration(classOf[ExpirationTimeTypeEnum.Class])
    expirationTimeType: ExpirationTimeTypeEnum.Value,
    multipleExercise: Option[MultipleExercise],
    exerciseFeeSchedule: Option[ExerciseFeeSchedule],
    exerciseProcedure: Option[ExerciseProcedure],
    exerciseFee: Option[ExerciseFee],
    partialExercise: Option[PartialExercise],
    meta: Option[MetaFields]) {
}

/**
  * Represents the current mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency).
  *
  * @param tradePortfolio Represents a Portfolio that describes all the positions held at a given time, in various states which can be either traded, settled, etc., with lineage information to the previous state.
  * @param aggregateValue Represents the aggregate value of the portfolio in base currency.
  * @param calculationDateTime Indicates the date when the exposure is calculated if different from valuation date.
  * @param valuationDateTime Indicates the valuation date of the exposure underlying the calculation.
  */
case class Exposure(tradePortfolio: ReferenceWithMetaPortfolioState,
    aggregateValue: Money,
    calculationDateTime: Option[java.time.ZonedDateTime],
    valuationDateTime: java.time.ZonedDateTime) {
}

/**
  * A data defining:  an option to extend an existing swap transaction on the specified exercise dates for a term ending on the specified new termination date. As a difference from FpML, it extends the BuyerSeller class, which represents the BuyerSeller.model.
  *
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
  * @param buyer Buyer party that can be resolved as one of the two principal parties to the transaction. The party that buys this instrument, i.e. pays for this instrument and receives the rights defined by it. ISDA 2002 Equity Definitions section 1.18: `Buyer` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (b)(i) relating to a Swaption: 'Buyer' means the party that will, on each Premium Payment Date, pay to Seller the Premium | ISDA 2006 Definitions article 12.1 (b)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such in the related Confirmation, or the Exercising Party if neither party is specified | ISDA 2006 Definitions article 12.1 (b)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Buyer` means the Fixed Rate Payer.
  * @param seller Seller party that can be resolved as one of the two principal parties to the transaction. The party that sells ('writes') this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. ISDA 2002 Equity Definitions section 1.19: `Seller` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (a)(i) relating to a Swaption: 'Seller' means the party the party specified as such or as writer in the related Confirmation | ISDA 2006 Definitions article 12.1 (a)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such or as writer in the related Confirmation or, if neither party is specified as such, the Non-exercising Party | ISDA 2006 Definitions article 12.1 (a)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Seller` means the Floating Rate Payer.
  */
case class ExtendibleProvision(exerciseNotice: Option[ExerciseNotice],
    followUpConfirmation: Option[Boolean],
    extendibleProvisionAdjustedDates: Option[ExtendibleProvisionAdjustedDates],
    @JsonDeserialize(contentAs = classOf[CallingPartyEnum.Value])
    @JsonScalaEnumeration(classOf[CallingPartyEnum.Class])
    callingParty: Option[CallingPartyEnum.Value],
    singlePartyOption: Option[PartyRole],
    noticeDeadlinePeriod: Option[RelativeDateOffset],
    noticeDeadlineDateTime: Option[java.time.ZonedDateTime],
    extensionTerm: Option[RelativeDateOffset],
    extensionPeriod: Option[AdjustableRelativeOrPeriodicDates],
    exerciseTerms: ExerciseTerms,
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    buyer: CounterpartyRoleEnum.Value,
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    seller: CounterpartyRoleEnum.Value)
  extends BuyerSellerTrait {
}

/**
  * A data defining:  the adjusted dates associated with a provision to extend a swap.
  *
  * @param extensionEvent The adjusted dates associated with a single extendible exercise date.
  */
case class ExtendibleProvisionAdjustedDates(extensionEvent: List[ExtensionEvent]) {
}

/**
  * A data to:  define the adjusted dates associated with an individual extension event.
  *
  * @param adjustedExerciseDate The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
  * @param adjustedExtendedTerminationDate The termination date if an extendible provision is exercised. This date should already be adjusted for any applicable business day convention.
  * @param meta 
  */
case class ExtensionEvent(adjustedExerciseDate: java.time.LocalDate,
    adjustedExtendedTerminationDate: java.time.LocalDate,
    meta: Option[MetaFields]) {
}

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
case class ExtraordinaryEvents(additionalBespokeTerms: List[Clause],
    mergerEvents: Option[EquityCorporateEvents],
    tenderOfferEvents: Option[EquityCorporateEvents],
    compositionOfCombinedConsideration: Option[Boolean],
    indexAdjustmentEvents: Option[IndexAdjustmentEvents],
    additionalDisruptionEvents: Option[AdditionalDisruptionEvents],
    failureToDeliver: Option[Boolean],
    representations: Option[Representations],
    @JsonDeserialize(contentAs = classOf[NationalizationOrInsolvencyOrDelistingEventEnum.Value])
    @JsonScalaEnumeration(classOf[NationalizationOrInsolvencyOrDelistingEventEnum.Class])
    nationalizationOrInsolvency: Option[NationalizationOrInsolvencyOrDelistingEventEnum.Value],
    @JsonDeserialize(contentAs = classOf[NationalizationOrInsolvencyOrDelistingEventEnum.Value])
    @JsonScalaEnumeration(classOf[NationalizationOrInsolvencyOrDelistingEventEnum.Class])
    delisting: Option[NationalizationOrInsolvencyOrDelistingEventEnum.Value]) {
}

case class FailureToPay(applicable: Boolean,
    gracePeriodExtension: Option[GracePeriodExtension],
    paymentRequirement: Option[Money]) {
}

/**
  * Defines the structure needed to represent fallback rate parameters. This type is used to represent modular computed rates in interestRatePayouts.
  *
  * @param floatingRateIndex The floating rate index that is used as the basis of the fallback rate.
  * @param effectiveDate The date the fallback rate takes effect.
  * @param calculationParameters Support for modular calculated rates, such such as lockout compound calculations.
  * @param spreadAdjustment The economic spread applied to the underlying fallback rate to replicate the original risky rate.
  */
case class FallbackRateParameters(@JsonScalaEnumeration(classOf[FloatingRateIndexEnum.Class])
    floatingRateIndex: FloatingRateIndexEnum.Value,
    effectiveDate: Option[java.time.LocalDate],
    calculationParameters: Option[FloatingRateCalculationParameters],
    spreadAdjustment: Option[scala.math.BigDecimal]) {
}

/**
  * The method, prioritised by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
  *
  * @param valuationPostponement Specifies how long to wait to get a quote from a settlement rate option upon a price source disruption.
  * @param fallBackSettlementRateOption This settlement rate option will be used in its place.
  * @param fallbackSurveyValuationPostponement Request rate quotes from the market. This element is set as type Empty in FpML. When present, the FpML synonym is mapped to a value True in the CDM.
  * @param calculationAgentDetermination The calculation agent will decide the rate.
  */
case class FallbackReferencePrice(valuationPostponement: Option[ValuationPostponement],
    fallBackSettlementRateOption: List[FieldWithMetaSettlementRateOptionEnum],
    fallbackSurveyValuationPostponement: Option[Boolean],
    calculationAgentDetermination: Option[CalculationAgent]) {
}

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
case class FeaturePayment(payerReceiver: PartyReferencePayerReceiver,
    levelPercentage: Option[scala.math.BigDecimal],
    amount: Option[scala.math.BigDecimal],
    @JsonDeserialize(contentAs = classOf[TimeTypeEnum.Value])
    @JsonScalaEnumeration(classOf[TimeTypeEnum.Class])
    time: Option[TimeTypeEnum.Value],
    currency: Option[FieldWithMetaString],
    paymentDate: Option[AdjustableOrRelativeDate],
    meta: Option[MetaFields]) {
}

case class FinInstrm(othr: Othr) {
}

case class FinInstrmGnlAttrbts(fullNm: String,
    clssfctnTp: String,
    ntnlCcy: String) {
}

case class FinInstrmRptgTxRpt(tx: Tx) {
}

/**
  * A data to:  define business date convention adjustment to final payment period per leg.
  *
  * @param relevantUnderlyingDateReference Reference to the unadjusted cancellation effective dates.
  * @param swapStreamReference Reference to the leg, where date adjustments may apply.
  * @param businessDayConvention Override business date convention. This takes precedence over leg level information.
  */
case class FinalCalculationPeriodDateAdjustment(relevantUnderlyingDateReference: ReferenceWithMetaAdjustableOrRelativeDates,
    swapStreamReference: ReferenceWithMetaInterestRatePayout,
    @JsonScalaEnumeration(classOf[BusinessDayConventionEnum.Class])
    businessDayConvention: BusinessDayConventionEnum.Value) {
}

/**
  * Type for reporting the detailed results of calculating a cash flow for a calculation period.  This is enhanced relative to the FpML-based cashflows structure to allow more information to be returned about daily compounded rates.
  *
  * @param calculationPeriod The calculation period for which the floating calculation was performed.
  * @param calculationPeriodNotionalAmount The notional in effect during the calculation period.
  * @param fixedRate The value of the fixed rate that was used.
  * @param yearFraction The fraction of a year that this calculation represents, according to the day count fraction method.
  * @param calculatedAmount The amount of the cash flow that was computed, including any spreads and other processing.
  */
case class FixedAmountCalculationDetails(calculationPeriod: CalculationPeriodBase,
    calculationPeriodNotionalAmount: Money,
    fixedRate: scala.math.BigDecimal,
    yearFraction: scala.math.BigDecimal,
    calculatedAmount: scala.math.BigDecimal) {
}

/**
  * A predefined price accorded by the counterparties.
  *
  * @param price Fixed price step schedule, including an initial price specified as an absolute number.
  */
case class FixedPrice(price: Option[ReferenceWithMetaPriceSchedule]) {
}

/**
  * Represents a fixed price payout. There is no underlier associated with this payout type and is based on fixed pricing per a given unit (e.g. in commodities price per barrel)
  *
  * @param paymentDates Specifies the parameters to generate the payment date schedule, either through a parametric representation or by reference to specified dates.
  * @param fixedPrice Specifies the fixed price on which fixed forward payments are based.
  * @param schedule Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
  * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
  * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
  * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
  * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
  */
case class FixedPricePayout(paymentDates: PaymentDates,
    fixedPrice: FixedPrice,
    schedule: Option[CalculationSchedule],
    payerReceiver: PayerReceiver,
    priceQuantity: Option[ResolvablePriceQuantity],
    principalPayment: Option[PrincipalPayments],
    settlementTerms: Option[SettlementTerms])
  extends PayoutBaseTrait {
}

/**
  * Type defining the specification for a fixed rate.
  *
  * @param rateSchedule The fixed rate or fixed rate schedule expressed as explicit fixed rates and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
  * @param meta 
  */
case class FixedRateSpecification(rateSchedule: Option[RateSchedule],
    meta: Option[MetaFields]) {
}

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
case class FloatingAmountCalculationDetails(calculationPeriod: CalculationPeriodBase,
    calculationPeriodNotionalAmount: Money,
    floatingRate: Option[FloatingRateSettingDetails],
    processingDetails: Option[FloatingRateProcessingDetails],
    appliedRate: scala.math.BigDecimal,
    yearFraction: scala.math.BigDecimal,
    calculatedAmount: scala.math.BigDecimal,
    spreadExclusiveCalculatedAMount: scala.math.BigDecimal) {
}

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
case class FloatingAmountEvents(failureToPayPrincipal: Option[Boolean],
    interestShortfall: Option[InterestShortFall],
    writedown: Option[Boolean],
    impliedWritedown: Option[Boolean],
    floatingAmountProvisions: Option[FloatingAmountProvisions],
    additionalFixedPayments: Option[AdditionalFixedPayments]) {
}

case class FloatingAmountProvisions(wacCapInterestProvision: Option[Boolean],
    stepUpProvision: Option[Boolean]) {
}

case class FloatingRate(floatingRateMultiplierSchedule: Option[RateSchedule],
    @JsonDeserialize(contentAs = classOf[RateTreatmentEnum.Value])
    @JsonScalaEnumeration(classOf[RateTreatmentEnum.Class])
    rateTreatment: Option[RateTreatmentEnum.Value],
    calculationParameters: Option[FloatingRateCalculationParameters],
    fallbackRate: Option[FallbackRateParameters],
    rateOption: Option[ReferenceWithMetaInterestRateIndex],
    spreadSchedule: Option[SpreadSchedule],
    capRateSchedule: Option[StrikeSchedule],
    floorRateSchedule: Option[StrikeSchedule],
    meta: Option[MetaFields])
  extends FloatingRateTrait with FloatingRateBaseTrait {
}

/**
  * A class defining a floating interest rate through the specification of the floating rate index, the tenor, the multiplier schedule, the spread, the qualification of whether a specific rate treatment and/or a cap or floor apply.
  *
  * @param rateOption 
  * @param spreadSchedule The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
  * @param capRateSchedule The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
  * @param floorRateSchedule The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
  * @param meta 
  */
case class FloatingRateBase(rateOption: Option[ReferenceWithMetaInterestRateIndex],
    spreadSchedule: Option[SpreadSchedule],
    capRateSchedule: Option[StrikeSchedule],
    floorRateSchedule: Option[StrikeSchedule],
    meta: Option[MetaFields])
  extends FloatingRateBaseTrait {
}

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
case class FloatingRateCalculationParameters(@JsonScalaEnumeration(classOf[CalculationMethodEnum.Class])
    calculationMethod: CalculationMethodEnum.Value,
    observationShiftCalculation: Option[ObservationShiftCalculation],
    lookbackCalculation: Option[OffsetCalculation],
    lockoutCalculation: Option[OffsetCalculation],
    applicableBusinessDays: Option[BusinessCenters],
    observationParameters: Option[ObservationParameters]) {
}

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
case class FloatingRateDefinition(calculatedRate: Option[scala.math.BigDecimal],
    rateObservation: List[RateObservation],
    floatingRateMultiplier: Option[scala.math.BigDecimal],
    spread: Option[scala.math.BigDecimal],
    capRate: List[Strike],
    floorRate: List[Strike]) {
}

/**
  * Specification of an interest rate index which can change over time, e.g. the SONIA (Sterling Overnight Index Average) in the UK.
  *
  * @param floatingRateIndex The reference index that is used to specify the floating interest rate.
  * @param indexTenor The ISDA Designated Maturity, i.e. the floating rate tenor.
  * @param name A description of the Index.
  * @param provider The organisation that creates or maintains the Index.
  * @param assetClass The Asset Class of the Index.
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class FloatingRateIndex(floatingRateIndex: FieldWithMetaFloatingRateIndexEnum,
    indexTenor: Option[Period],
    name: Option[FieldWithMetaString],
    provider: Option[LegalEntity],
    @JsonDeserialize(contentAs = classOf[AssetClassEnum.Value])
    @JsonScalaEnumeration(classOf[AssetClassEnum.Class])
    assetClass: Option[AssetClassEnum.Value],
    identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends IndexBaseTrait {
}

/**
  * This holds the rate calculation defaults applicable for a floating rate index.
  *
  * @param category The ISDA FRO category (e.g. screen rate or calculated rate).
  * @param indexStyle The ISDA FRO style (e.g. term rate, swap rate, etc).
  * @param method The ISDA FRO calculation method (e.g. OIS Compounding).
  */
case class FloatingRateIndexCalculationDefaults(@JsonDeserialize(contentAs = classOf[FloatingRateIndexCategoryEnum.Value])
    @JsonScalaEnumeration(classOf[FloatingRateIndexCategoryEnum.Class])
    category: Option[FloatingRateIndexCategoryEnum.Value],
    @JsonDeserialize(contentAs = classOf[FloatingRateIndexStyleEnum.Value])
    @JsonScalaEnumeration(classOf[FloatingRateIndexStyleEnum.Class])
    indexStyle: Option[FloatingRateIndexStyleEnum.Value],
    @JsonDeserialize(contentAs = classOf[FloatingRateIndexCalculationMethodEnum.Value])
    @JsonScalaEnumeration(classOf[FloatingRateIndexCalculationMethodEnum.Class])
    method: Option[FloatingRateIndexCalculationMethodEnum.Value]) {
}

case class FloatingRateIndexDefinition(fro: FloatingRateIndexIdentification,
    calculationDefaults: Option[FloatingRateIndexCalculationDefaults]) {
}

case class FloatingRateIndexIdentification(floatingRateIndex: Option[FieldWithMetaFloatingRateIndexEnum],
    @JsonDeserialize(contentAs = classOf[ISOCurrencyCodeEnum.Value])
    @JsonScalaEnumeration(classOf[ISOCurrencyCodeEnum.Class])
    currency: Option[ISOCurrencyCodeEnum.Value],
    froType: Option[String]) {
}

/**
  * Type for reporting the details of the rate treatment.  This could potentially be replaced by the existing FloatingRateDefinition type , but this is slightly more detailed.
  *
  * @param rawRate The raw or untreated rate, prior to any of the rate treatments.
  * @param processingParameters 
  * @param processedRate The value of the rate after processing.
  * @param spreadExclusiveRate The value of the processed rate without the spread applied, for subsequent compounding, etc.
  */
case class FloatingRateProcessingDetails(rawRate: scala.math.BigDecimal,
    processingParameters: Option[FloatingRateProcessingParameters],
    processedRate: scala.math.BigDecimal,
    spreadExclusiveRate: scala.math.BigDecimal) {
}

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
case class FloatingRateProcessingParameters(initialRate: Option[Price],
    multiplier: Option[scala.math.BigDecimal],
    spread: Option[scala.math.BigDecimal],
    @JsonDeserialize(contentAs = classOf[RateTreatmentEnum.Value])
    @JsonScalaEnumeration(classOf[RateTreatmentEnum.Class])
    treatment: Option[RateTreatmentEnum.Value],
    capRate: Option[scala.math.BigDecimal],
    floorRate: Option[scala.math.BigDecimal],
    rounding: Option[Rounding],
    @JsonDeserialize(contentAs = classOf[NegativeInterestRateTreatmentEnum.Value])
    @JsonScalaEnumeration(classOf[NegativeInterestRateTreatmentEnum.Class])
    negativeTreatment: Option[NegativeInterestRateTreatmentEnum.Value]) {
}

/**
  * Type for reporting the raw (untreated) observed or calculated rate for a calculation period.  If this is a calculated rate, it allows details of the observations and the resulting rate to be returned.
  *
  * @param calculationDetails Calculated rate details (observation dates, values, and weights).
  * @param observationDate The day upon which the rate was observed (for term rates).
  * @param resetDate The day for which the rate is needed (e.g. period beginning or end date).
  * @param floatingRate The resulting rate that was observed or calculated.
  */
case class FloatingRateSettingDetails(calculationDetails: Option[CalculatedRateDetails],
    observationDate: Option[java.time.LocalDate],
    resetDate: Option[java.time.LocalDate],
    floatingRate: scala.math.BigDecimal) {
}

/**
  * A class to specify the floating interest rate by extending the floating rate definition with a set of attributes that specify such rate: the initial value specified as part of the trade, the rounding convention, the averaging method and the negative interest rate treatment.
  *
  * @param initialRate The initial floating rate reset agreed between the principal parties involved in the trade. This is assumed to be the first required reset rate for the first regular calculation period. It should only be included when the rate is not equal to the rate published on the source implied by the floating rate index. An initial rate of 5% would be represented as 0.05.
  * @param finalRateRounding The rounding convention to apply to the final rate used in determination of a calculation period amount.
  * @param averagingMethod If averaging is applicable, this component specifies whether a weighted or unweighted average method of calculation is to be used. The component must only be included when averaging applies.
  * @param negativeInterestRateTreatment The specification of any provisions for calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
  * @param floatingRateMultiplierSchedule A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
  * @param rateTreatment The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
  * @param calculationParameters Support for modular calculated rates, such such as lockout compound calculations.
  * @param fallbackRate Definition of any fallback rate that may be applicable.
  * @param rateOption 
  * @param spreadSchedule The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
  * @param capRateSchedule The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
  * @param floorRateSchedule The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
  * @param meta 
  */
case class FloatingRateSpecification(initialRate: Option[Price],
    finalRateRounding: Option[Rounding],
    @JsonDeserialize(contentAs = classOf[AveragingWeightingMethodEnum.Value])
    @JsonScalaEnumeration(classOf[AveragingWeightingMethodEnum.Class])
    averagingMethod: Option[AveragingWeightingMethodEnum.Value],
    @JsonDeserialize(contentAs = classOf[NegativeInterestRateTreatmentEnum.Value])
    @JsonScalaEnumeration(classOf[NegativeInterestRateTreatmentEnum.Class])
    negativeInterestRateTreatment: Option[NegativeInterestRateTreatmentEnum.Value],
    floatingRateMultiplierSchedule: Option[RateSchedule],
    @JsonDeserialize(contentAs = classOf[RateTreatmentEnum.Value])
    @JsonScalaEnumeration(classOf[RateTreatmentEnum.Class])
    rateTreatment: Option[RateTreatmentEnum.Value],
    calculationParameters: Option[FloatingRateCalculationParameters],
    fallbackRate: Option[FallbackRateParameters],
    rateOption: Option[ReferenceWithMetaInterestRateIndex],
    spreadSchedule: Option[SpreadSchedule],
    capRateSchedule: Option[StrikeSchedule],
    floorRateSchedule: Option[StrikeSchedule],
    meta: Option[MetaFields])
  extends FloatingRateSpecificationTrait with FloatingRateTrait {
}

/**
  * From FpML: A type defining either a spot or forward FX transactions.
  *
  * @param exchangedCurrency1 This is the first of the two currency flows that define a single leg of a standard foreign exchange transaction.
  * @param exchangedCurrency2 This is the second of the two currency flows that define a single leg of a standard foreign exchange transaction.
  * @param tenorPeriod A tenor expressed as a period type and multiplier (e.g. 1D, 1Y, etc.)
  */
case class ForeignExchange(exchangedCurrency1: Cashflow,
    exchangedCurrency2: Cashflow,
    tenorPeriod: Option[Period]) {
}

/**
  * Specification of a rate based on the exchange of a pair of cash assets in specific currencies, e.g. USD versus GBP.
  *
  * @param quotedCurrencyPair Describes the composition of a rate that has been quoted or is to be quoted.
  * @param primaryFxSpotRateSource Specifies the primary source from which a rate should be observed.
  * @param secondaryFxSpotRateSource Specifies an alternative, or secondary, source from which a rate should be observed.
  * @param name A description of the Index.
  * @param provider The organisation that creates or maintains the Index.
  * @param assetClass The Asset Class of the Index.
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class ForeignExchangeRateIndex(quotedCurrencyPair: FieldWithMetaQuotedCurrencyPair,
    primaryFxSpotRateSource: InformationSource,
    secondaryFxSpotRateSource: Option[InformationSource],
    name: Option[FieldWithMetaString],
    provider: Option[LegalEntity],
    @JsonDeserialize(contentAs = classOf[AssetClassEnum.Value])
    @JsonScalaEnumeration(classOf[AssetClassEnum.Class])
    assetClass: Option[AssetClassEnum.Value],
    identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends IndexBaseTrait {
}

/**
  * A class for defining a date frequency, e.g. one day, three months, through the combination of an integer value and a standardized period value that is specified as part of an enumeration.
  *
  * @param periodMultiplier A time period multiplier, e.g. 1, 2, or 3. If the period value is T (Term) then period multiplier must contain the value 1.
  * @param period A time period, e.g. a day, week, month, year or term of the stream.
  * @param meta 
  */
case class Frequency(periodMultiplier: Int,
    @JsonScalaEnumeration(classOf[PeriodExtendedEnum.Class])
    period: PeriodExtendedEnum.Value,
    meta: Option[MetaFields])
  extends FrequencyTrait {
}

/**
  * A class defining a currency and a future value date.
  *
  * @param quantity 
  * @param currency The currency in which the an amount is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
  * @param calculationPeriodNumberOfDays The number of days from the adjusted calculation period start date to the adjusted value date, calculated in accordance with the applicable day count fraction.
  * @param valueDate Adjusted value date of the future value amount.
  */
case class FutureValueAmount(quantity: Option[ReferenceWithMetaNonNegativeQuantitySchedule],
    currency: FieldWithMetaString,
    calculationPeriodNumberOfDays: Int,
    valueDate: java.time.LocalDate) {
}

/**
  * TransactionAdditionalTerms which apply to the CurrencyPair asset class.
  *
  */
case class FxAdditionalTerms() {
}

/**
  * A type for defining FX Features.
  *
  * @param referenceCurrency Specifies the reference currency of the trade.
  * @param composite If 'Composite' is specified as the Settlement Type in the relevant Transaction Supplement, an amount in the Settlement Currency, determined by the Calculation Agent as being equal to the number of Options exercised or deemed exercised, multiplied by: (Settlement Price – Strike Price) / (Strike Price – Settlement Price) x Multiplier provided that if the above is equal to a negative amount the Option Cash Settlement Amount shall be deemed to be zero.
  * @param quanto If 'Quanto' is specified as the Settlement Type in the relevant Transaction Supplement, an amount, as determined by the Calculation Agent in accordance with the Section 8.2 of the Equity Definitions.
  * @param crossCurrency If 'Cross-Currency' is specified as the Settlement Type in the relevant Transaction Supplement, an amount in the Settlement Currency, determined by the Calculation Agent as being equal to the number of Options exercised or deemed exercised, multiplied by: (Settlement Price – Strike Price) / (Strike Price – Settlement Price) x Multiplier x one unit of the Reference Currency converted into an amount in the Settlement Currency using the rate of exchange of the Settlement Currency as quoted on the Reference Price Source on the Valuation Date, provided that if the above is equal to a negative amount the Option Cash Settlement Amount shall be deemed to be zero.
  */
case class FxFeature(referenceCurrency: FieldWithMetaString,
    composite: Option[Composite],
    quanto: Option[Quanto],
    crossCurrency: Option[Composite]) {
}

/**
  * Extends the Offset structure to specify an FX fixing date as an offset to dates specified somewhere else in the document.
  *
  * @param businessDayConvention The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
  * @param businessCenters 
  * @param businessCentersReference A reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
  * @param dateRelativeToPaymentDates The payment date references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure.
  * @param dateRelativeToCalculationPeriodDates The calculation period references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure. Implemented for Brazilian-CDI swaps where it will refer to the termination date of the appropriate leg.
  * @param dateRelativeToValuationDates The calculation period references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure. Implemented for Brazilian-CDI swaps where it will refer to the termination date of the appropriate leg.
  * @param fxFixingDate Describes the specific date when a non-deliverable forward or cash-settled option will 'fix' against a particular rate, which will be used to compute the ultimate cash settlement. This element should be omitted where a single, discrete fixing date cannot be identified e.g. on an american option, where fixing may occur at any date on a continuous range.  This attribute was formerly part of 'fxSettlementTerms', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
  * @param dayType In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
  * @param periodMultiplier A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
  * @param period A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
  * @param meta 
  */
case class FxFixingDate(@JsonDeserialize(contentAs = classOf[BusinessDayConventionEnum.Value])
    @JsonScalaEnumeration(classOf[BusinessDayConventionEnum.Class])
    businessDayConvention: Option[BusinessDayConventionEnum.Value],
    businessCenters: Option[BusinessCenters],
    businessCentersReference: Option[ReferenceWithMetaBusinessCenters],
    dateRelativeToPaymentDates: Option[DateRelativeToPaymentDates],
    dateRelativeToCalculationPeriodDates: Option[DateRelativeToCalculationPeriodDates],
    dateRelativeToValuationDates: Option[DateRelativeToValuationDates],
    fxFixingDate: Option[AdjustableOrRelativeDate],
    @JsonDeserialize(contentAs = classOf[DayTypeEnum.Value])
    @JsonScalaEnumeration(classOf[DayTypeEnum.Class])
    dayType: Option[DayTypeEnum.Value],
    periodMultiplier: Int,
    @JsonScalaEnumeration(classOf[PeriodEnum.Class])
    period: PeriodEnum.Value,
    meta: Option[MetaFields])
  extends OffsetTrait {
}

/**
  * Information source specific to Foreign Exchange products.
  *
  * @param fixingTime The time that the fixing will be taken along with a business center to define the time zone.
  * @param sourceProvider An information source for obtaining a market data point. For example Bloomberg, Reuters, Telerate, etc.
  * @param sourcePage A specific page for the source for obtaining a market data point. In FpML, this is specified as a scheme, rateSourcePageScheme, for which no coding Scheme or URI is specified.
  * @param sourcePageHeading The heading for the source on a given source page.
  */
case class FxInformationSource(fixingTime: Option[BusinessCenterTime],
    sourceProvider: FieldWithMetaInformationProviderEnum,
    sourcePage: Option[FieldWithMetaString],
    sourcePageHeading: Option[String])
  extends InformationSourceTrait {
}

/**
  * A data to:  describe the cashflow representation for FX linked notionals.
  *
  * @param resetDate The reset date.
  * @param adjustedFxSpotFixingDate The date on which the FX spot rate is observed. This date should already be adjusted for any applicable business day convention.
  * @param observedFxSpotRate The actual observed FX spot rate.
  * @param notionalAmount The calculation period notional amount.
  */
case class FxLinkedNotionalAmount(resetDate: Option[java.time.LocalDate],
    adjustedFxSpotFixingDate: Option[java.time.LocalDate],
    observedFxSpotRate: Option[scala.math.BigDecimal],
    notionalAmount: Option[scala.math.BigDecimal]) {
}

/**
  * A data to:  describe a notional schedule where each notional that applies to a calculation period is calculated with reference to a notional amount or notional amount schedule in a different currency by means of a spot currency exchange rate which is normally observed at the beginning of each period.
  *
  * @param varyingNotionalCurrency The currency of the varying notional amount, i.e. the notional amount being determined periodically based on observation of a spot currency exchange rate. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
  * @param varyingNotionalFixingDates The dates on which spot currency exchange rates are observed for purposes of determining the varying notional currency amount that will apply to a calculation period.
  * @param fxSpotRateSource The information source and time at which the spot currency exchange rate will be observed.
  * @param fixingTime The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
  * @param varyingNotionalInterimExchangePaymentDates The dates on which interim exchanges of notional are paid. Interim exchanges will arise as a result of changes in the spot currency exchange amount or changes in the constant notional schedule (e.g. amortisation).
  */
case class FxLinkedNotionalSchedule(varyingNotionalCurrency: FieldWithMetaString,
    varyingNotionalFixingDates: RelativeDateOffset,
    fxSpotRateSource: FxSpotRateSource,
    fixingTime: Option[BusinessCenterTime],
    varyingNotionalInterimExchangePaymentDates: RelativeDateOffset) {
}

/**
  * A class describing the rate of a currency conversion: pair of currency, quotation mode and exchange rate.
  *
  * @param quotedCurrencyPair Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
  * @param rate The rate of exchange between the two currencies of the leg of a deal. Must be specified with a quote basis.
  */
case class FxRate(quotedCurrencyPair: QuotedCurrencyPair,
    rate: Option[scala.math.BigDecimal]) {
}

/**
  * Describes a rate source to be fixed and the date the fixing occurs
  *
  * @param settlementRateSource 
  * @param fixingDate The date on which the fixing is scheduled to occur.
  */
case class FxRateSourceFixing(settlementRateSource: FxSettlementRateSource,
    fixingDate: AdjustableDate) {
}

/**
  * The source of the Foreign Exchange settlement rate.
  *
  * @param settlementRateOption Indicates that an officially defined rate settlement rate option will be the used for the fixing.
  * @param nonstandardSettlementRate Indicates that a non-standard rate source will be used for the fixing.
  */
case class FxSettlementRateSource(settlementRateOption: Option[FieldWithMetaString],
    nonstandardSettlementRate: Option[FxInformationSource]) {
}

/**
  * A class defining the rate source and fixing time for an FX rate.
  *
  * @param primarySource The primary source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
  * @param secondarySource An alternative, or secondary, source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
  */
case class FxSpotRateSource(primarySource: InformationSource,
    secondarySource: Option[InformationSource]) {
}

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
case class GeneralTerms(referenceInformation: Option[ReferenceInformation],
    indexReferenceInformation: Option[CreditIndex],
    basketReferenceInformation: Option[BasketReferenceInformation],
    additionalTerm: List[FieldWithMetaString],
    substitution: Option[Boolean],
    modifiedEquityDelivery: Option[Boolean]) {
}

case class GracePeriodExtension(applicable: Boolean,
    gracePeriod: Option[Offset]) {
}

case class Id(lei: String) {
}

/**
  * Attaches an identifier to a collection of objects, when those objects themselves can each be represented by an identifier. One use case is the representation of package transactions, where each component is a separate trade with its own identifier, and those trades are linked together as a package with its own identifier. The data type has been named generically rather than referring to 'packages' as it may have a number of other uses.
  *
  * @param listId The identifier for the list. In the case of a package transaction, this would be the package identifier. This attribute is mandatory to allow the list itself to be identified.
  * @param componentId Identifiers for each component of the list. Since the data type is used to link multiple identified objects together, at least 2 components are required in the list. Creating an identified list with only 1 identified component has been deemed unnecessary, because it would just create a redundant identifier.
  * @param price The price of the package.
  * @param meta 
  */
case class IdentifiedList(listId: Identifier,
    componentId: List[Identifier],
    price: Option[Price],
    meta: Option[MetaFields]) {
}

/**
  * A class to specify a generic identifier, applicable to CDM artefacts such as executions, contracts, lifecycle events and legal documents. An issuer can be associated with the actual identifier value as a way to properly qualify it.
  *
  * @param issuerReference The identifier issuer, when specified by reference to a party specified as part of the transaction.
  * @param issuer The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).
  * @param assignedIdentifier The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.
  * @param meta 
  */
case class Identifier(issuerReference: Option[ReferenceWithMetaParty],
    issuer: Option[FieldWithMetaString],
    assignedIdentifier: List[AssignedIdentifier],
    meta: Option[MetaFields])
  extends IdentifierTrait {
}

/**
  * A class specifying the Independent Amount as the combination of a payer/receiver, a payment amount, a payment date and an associated payment calculation rule.
  *
  * @param paymentDetail An attribute that specifies a payment as the combination of a payment amount, a payment date and an associated payment calculation rule.
  * @param payerPartyReference The party responsible for making the payments defined by this structure.
  * @param payerAccountReference A reference to the account responsible for making the payments defined by this structure.
  * @param receiverPartyReference The party that receives the payments corresponding to this structure.
  * @param receiverAccountReference A reference to the account that receives the payments corresponding to this structure.
  */
case class IndependentAmount(paymentDetail: List[PaymentDetail],
    payerPartyReference: ReferenceWithMetaParty,
    payerAccountReference: Option[ReferenceWithMetaAccount],
    receiverPartyReference: ReferenceWithMetaParty,
    receiverAccountReference: Option[ReferenceWithMetaAccount])
  extends PartyReferencePayerReceiverTrait {
}

/**
  * An Index is an Observable which is computed based on the prices, rates or valuations of a number of assets that are tracked in a standardized way.  Examples include equity market indices as well as indices on interest rates, inflation and credit instruments.
  *
  * @param CreditIndex An index based on credit risk, typically composed using corporate debt instruments in a region or industry sector, e.g. the iTraxx indices.
  * @param EquityIndex An index based on equity securities, e.g. the S&P 500.
  * @param InterestRateIndex An index based in interest rates or inflation rates in a certain market.
  * @param ForeignExchangeRateIndex A rate based on the exchange of a pair of cash assets in specific currencies, e.g. USD versus GBP.
  * @param OtherIndex An index created by a market participant which doesn't align with the other index types.
  */
case class Index(creditIndex: Option[CreditIndex],
    equityIndex: Option[EquityIndex],
    interestRateIndex: Option[FieldWithMetaInterestRateIndex],
    foreignExchangeRateIndex: Option[ForeignExchangeRateIndex],
    otherIndex: Option[OtherIndex]) {
}

/**
  * Defines the specification of the consequences of Index Events as defined by the 2002 ISDA Equity Derivatives Definitions.
  *
  */
case class IndexAdjustmentEvents() {
}

/**
  * Identifies an index by referencing an identifier.
  *
  * @param name A description of the Index.
  * @param provider The organisation that creates or maintains the Index.
  * @param assetClass The Asset Class of the Index.
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class IndexBase(name: Option[FieldWithMetaString],
    provider: Option[LegalEntity],
    @JsonDeserialize(contentAs = classOf[AssetClassEnum.Value])
    @JsonScalaEnumeration(classOf[AssetClassEnum.Class])
    assetClass: Option[AssetClassEnum.Value],
    identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends IndexBaseTrait with AssetBaseTrait {
}

/**
  * Defines the information needed to create a Index Transition Business Event.
  *
  * @param priceQuantity Specifies both new floating rate index and spread adjustment for each leg to be updated.  The spread adjustment accounts for the difference between the old floating rate index relative to the new one. This spread amount is added to the existing spread to determine the new spread, which is applied from the specified effective date forward. In the case of the IBOR Fallback Rate Adjustments, the adjustment spread (also known as the Fallback Adjustment) accounts for two distinctions: i) the fact that the replacement Risk-Free Rate is an overnight rate while IBORs have term structures (e.g., 1, 3, 6-month LIBOR); and (ii) the historical spread differential between IBORs and their term equivalent Overnight Risk-Free Rate compounded rates.
  * @param effectiveDate Specifies the effective date of the index transition event. This is first date on which the floating rate calculation will use the new floating rate index and adjusted spread in the floating rate calculation.
  * @param cashTransfer Specifies the cash transfer that can optionally be tied to an index transition event.
  */
case class IndexTransitionInstruction(priceQuantity: List[PriceQuantity],
    effectiveDate: java.time.LocalDate,
    cashTransfer: Option[Transfer]) {
}

case class Indx(nm: Nm) {
}

/**
  * Specification of an index that measures inflation in a specific market, e.g. the US Consumer Price Index.
  *
  * @param inflationRateIndex The reference index that is used to specify the inflation interest rate.
  * @param indexTenor The ISDA Designated Maturity, i.e. the floating rate tenor.
  * @param name A description of the Index.
  * @param provider The organisation that creates or maintains the Index.
  * @param assetClass The Asset Class of the Index.
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class InflationIndex(inflationRateIndex: FieldWithMetaInflationRateIndexEnum,
    indexTenor: Option[Period],
    name: Option[FieldWithMetaString],
    provider: Option[LegalEntity],
    @JsonDeserialize(contentAs = classOf[AssetClassEnum.Value])
    @JsonScalaEnumeration(classOf[AssetClassEnum.Class])
    assetClass: Option[AssetClassEnum.Value],
    identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends IndexBaseTrait {
}

/**
  * A data to:  specify the inflation rate.
  *
  * @param inflationLag An off-setting period from the payment date which determines the reference period for which the inflation index is observed.
  * @param indexSource The reference source such as Reuters or Bloomberg. FpML specifies indexSource to be of type rateSourcePageScheme, but without specifying actual values.
  * @param mainPublication The current main publication source such as relevant web site or a government body. FpML specifies mainPublication to be of type mainPublicationSource, but without specifying actual values.
  * @param interpolationMethod The method used when calculating the Inflation Index Level from multiple points. The most common is Linear.
  * @param initialIndexLevel Initial known index level for the first calculation period.
  * @param fallbackBondApplicable The applicability of a fallback bond as defined in the 2006 ISDA Inflation Derivatives Definitions, sections 1.3 and 1.8.
  * @param calculationMethod Indicates how to use the inflation index to calculate the payment (e.g. Ratio, Return, Spread). Added for Inflation Asset Swap
  * @param calculationStyle Indicates the style of how the inflation index calculates the payment (e.g. YearOnYear, ZeroCoupon).
  * @param finalPrincipalExchangeCalculation To be specified only for products that embed a redemption payment.
  * @param initialRate The initial floating rate reset agreed between the principal parties involved in the trade. This is assumed to be the first required reset rate for the first regular calculation period. It should only be included when the rate is not equal to the rate published on the source implied by the floating rate index. An initial rate of 5% would be represented as 0.05.
  * @param finalRateRounding The rounding convention to apply to the final rate used in determination of a calculation period amount.
  * @param averagingMethod If averaging is applicable, this component specifies whether a weighted or unweighted average method of calculation is to be used. The component must only be included when averaging applies.
  * @param negativeInterestRateTreatment The specification of any provisions for calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
  * @param floatingRateMultiplierSchedule A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
  * @param rateTreatment The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
  * @param calculationParameters Support for modular calculated rates, such such as lockout compound calculations.
  * @param fallbackRate Definition of any fallback rate that may be applicable.
  * @param rateOption 
  * @param spreadSchedule The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
  * @param capRateSchedule The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
  * @param floorRateSchedule The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
  * @param meta 
  */
case class InflationRateSpecification(inflationLag: Offset,
    indexSource: FieldWithMetaString,
    mainPublication: FieldWithMetaString,
    interpolationMethod: FieldWithMetaInterpolationMethodEnum,
    initialIndexLevel: Option[scala.math.BigDecimal],
    fallbackBondApplicable: Boolean,
    @JsonDeserialize(contentAs = classOf[InflationCalculationMethodEnum.Value])
    @JsonScalaEnumeration(classOf[InflationCalculationMethodEnum.Class])
    calculationMethod: Option[InflationCalculationMethodEnum.Value],
    @JsonDeserialize(contentAs = classOf[InflationCalculationStyleEnum.Value])
    @JsonScalaEnumeration(classOf[InflationCalculationStyleEnum.Class])
    calculationStyle: Option[InflationCalculationStyleEnum.Value],
    @JsonDeserialize(contentAs = classOf[FinalPrincipalExchangeCalculationEnum.Value])
    @JsonScalaEnumeration(classOf[FinalPrincipalExchangeCalculationEnum.Class])
    finalPrincipalExchangeCalculation: Option[FinalPrincipalExchangeCalculationEnum.Value],
    initialRate: Option[Price],
    finalRateRounding: Option[Rounding],
    @JsonDeserialize(contentAs = classOf[AveragingWeightingMethodEnum.Value])
    @JsonScalaEnumeration(classOf[AveragingWeightingMethodEnum.Class])
    averagingMethod: Option[AveragingWeightingMethodEnum.Value],
    @JsonDeserialize(contentAs = classOf[NegativeInterestRateTreatmentEnum.Value])
    @JsonScalaEnumeration(classOf[NegativeInterestRateTreatmentEnum.Class])
    negativeInterestRateTreatment: Option[NegativeInterestRateTreatmentEnum.Value],
    floatingRateMultiplierSchedule: Option[RateSchedule],
    @JsonDeserialize(contentAs = classOf[RateTreatmentEnum.Value])
    @JsonScalaEnumeration(classOf[RateTreatmentEnum.Class])
    rateTreatment: Option[RateTreatmentEnum.Value],
    calculationParameters: Option[FloatingRateCalculationParameters],
    fallbackRate: Option[FallbackRateParameters],
    rateOption: Option[ReferenceWithMetaInterestRateIndex],
    spreadSchedule: Option[SpreadSchedule],
    capRateSchedule: Option[StrikeSchedule],
    floorRateSchedule: Option[StrikeSchedule],
    meta: Option[MetaFields])
  extends FloatingRateSpecificationTrait {
}

/**
  * A class defining the source for a piece of information (e.g. a rate fix or an FX fixing). The attribute names have been adjusted from FpML to address the fact that the information is not limited to rates.
  *
  * @param sourceProvider An information source for obtaining a market data point. For example Bloomberg, Reuters, Telerate, etc.
  * @param sourcePage A specific page for the source for obtaining a market data point. In FpML, this is specified as a scheme, rateSourcePageScheme, for which no coding Scheme or URI is specified.
  * @param sourcePageHeading The heading for the source on a given source page.
  */
case class InformationSource(sourceProvider: FieldWithMetaInformationProviderEnum,
    sourcePage: Option[FieldWithMetaString],
    sourcePageHeading: Option[String])
  extends InformationSourceTrait {
}

/**
  * A CDM class which purpose is to specify the initial fixing date either alongside the FpML interest rate specification as an offset of another date, or alongside the credit derivative specification as an unadjusted date.
  *
  * @param relativeDateOffset 
  * @param initialFixingDate 
  */
case class InitialFixingDate(relativeDateOffset: Option[RelativeDateOffset],
    initialFixingDate: Option[java.time.LocalDate]) {
}

/**
  * Instruction to a function that will be used to perform a business event
  *
  * @param primitiveInstruction Specifies the primitive instructions that will be used to call primitive event functions.
  * @param before Specifies the trade state that will be acted on by the primitive event functions.
  */
case class Instruction(primitiveInstruction: Option[PrimitiveInstruction],
    before: Option[ReferenceWithMetaTradeState]) {
}

/**
  * A type of Asset that is issued by one party to one or more others.
  *
  * @param ListedDerivative A securitized derivative on another asset that is created by an exchange.
  * @param Loan An Asset that represents a loan or borrow obligation.
  * @param Security An Asset that is issued by a party to be held by or transferred to others.
  */
case class Instrument(listedDerivative: Option[ListedDerivative],
    loan: Option[Loan],
    security: Option[Security]) {
}

/**
  * Defines the common attributes for all Instrument data types.
  *
  * @param instrumentType Identifies the type of an instrument using an enumerated list.
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class InstrumentBase(@JsonScalaEnumeration(classOf[InstrumentTypeEnum.Class])
    instrumentType: InstrumentTypeEnum.Value,
    identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends InstrumentBaseTrait with AssetBaseTrait {
}

/**
  * A class to specify the application of Interest Amount with respect to the Delivery Amount and the Return Amount.
  *
  * @param returnAmount The application of Interest Amount with respect the Return Amount.
  * @param deliveryAmount The application of Interest Amount with respect the Delivery Amount.
  */
case class InterestAmountApplication(returnAmount: ReturnAmount,
    deliveryAmount: DeliveryAmount) {
}

case class InterestRateCurve(floatingRateIndex: FieldWithMetaFloatingRateIndexEnum,
    tenor: Period) {
}

/**
  * An index based in interest rates or inflation rates in a certain market.
  *
  * @param FloatingRateIndex An interest rate index which can change over time, e.g. the SONIA (Sterling Overnight Index Average) in the UK.
  * @param InflationIndex An index that measures inflation in a specific market, e.g. the US Consumer Price Index.
  */
case class InterestRateIndex(floatingRateIndex: Option[FloatingRateIndex],
    inflationIndex: Option[InflationIndex]) {
}

/**
  *  A class to specify all of the terms necessary to define and calculate a cash flow based on a fixed, a floating or an inflation index rate. The interest rate payout can be applied to interest rate swaps and FRA (which both have two associated interest rate payouts), credit default swaps (to represent the fee leg when subject to periodic payments) and equity swaps (to represent the funding leg). The associated globalKey denotes the ability to associate a hash value to the InterestRatePayout instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
  *
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
  * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
  * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
  * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
  * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
  */
case class InterestRatePayout(rateSpecification: Option[RateSpecification],
    dayCountFraction: Option[FieldWithMetaDayCountFractionEnum],
    calculationPeriodDates: Option[CalculationPeriodDates],
    paymentDates: Option[PaymentDates],
    paymentDate: Option[AdjustableDate],
    paymentDelay: Option[Boolean],
    resetDates: Option[ResetDates],
    discountingMethod: Option[DiscountingMethod],
    @JsonDeserialize(contentAs = classOf[CompoundingMethodEnum.Value])
    @JsonScalaEnumeration(classOf[CompoundingMethodEnum.Class])
    compoundingMethod: Option[CompoundingMethodEnum.Value],
    cashflowRepresentation: Option[CashflowRepresentation],
    stubPeriod: Option[StubPeriod],
    bondReference: Option[BondReference],
    fixedAmount: Option[String],
    floatingAmount: Option[String],
    @JsonDeserialize(contentAs = classOf[SpreadCalculationMethodEnum.Value])
    @JsonScalaEnumeration(classOf[SpreadCalculationMethodEnum.Class])
    spreadCalculationMethod: Option[SpreadCalculationMethodEnum.Value],
    payerReceiver: PayerReceiver,
    priceQuantity: Option[ResolvablePriceQuantity],
    principalPayment: Option[PrincipalPayments],
    settlementTerms: Option[SettlementTerms])
  extends PayoutBaseTrait {
}

/**
  * A class to specify the interest shortfall floating rate payment event.
  *
  * @param interestShortfallCap Specifies the nature of the interest Shortfall cap (i.e. Fixed Cap or Variable Cap) in the case where it is applicable. ISDA 2003 Term: Interest Shortfall Cap.
  * @param compounding 
  * @param rateSource The rate source in the case of a variable cap.
  */
case class InterestShortFall(@JsonScalaEnumeration(classOf[InterestShortfallCapEnum.Class])
    interestShortfallCap: InterestShortfallCapEnum.Value,
    compounding: Boolean,
    rateSource: Option[FieldWithMetaFloatingRateIndexEnum]) {
}

/**
  * A data type that can be used to describe an inventory of securities.
  *
  * @param inventoryRecord An array holding the list of inventory being described. Each element in the inventoryRecord array represents an individual piece of inventory i.e. a security.
  */
case class Inventory(inventoryRecord: List[InventoryRecord]) {
}

/**
  * An individual piece of inventory. This represents a single security.
  *
  * @param identifer Unique identifier for this record. This can be used to uniquely identify a specific piece of inventory.
  * @param security The security details.
  */
case class InventoryRecord(identifer: AssignedIdentifier,
    security: Security)
  extends InventoryRecordTrait {
}

case class InvstmtDcsnPrsn(prsn: Prsn) {
}

case class IssuerAgencyRating(issuerAgencyRating: AgencyRatingCriteria) {
}

case class IssuerCountryOfOrigin(@JsonScalaEnumeration(classOf[ISOCountryCodeEnum.Class])
    issuerCountryOfOrigin: ISOCountryCodeEnum.Value) {
}

case class IssuerName(issuerName: LegalEntity) {
}

/**
  * Knock In means option to exercise comes into existence. Knock Out means option to exercise goes out of existence.
  *
  * @param knockIn The knock in.
  * @param knockOut The knock out.
  */
case class Knock(knockIn: Option[TriggerEvent],
    knockOut: Option[TriggerEvent]) {
}

/**
  * The pricing period per calculation period if the pricing days do not wholly fall within the respective calculation period.
  *
  * @param lagDuration Defines the offset of the series of pricing dates relative to the calculation period.
  * @param firstObservationDateOffset Defines the offset of the series of pricing dates relative to the calculation period.
  */
case class Lag(lagDuration: Offset,
    firstObservationDateOffset: Option[Offset]) {
}

/**
  * The specification of a legal agreement between two parties, being negotiated or having been executed. This includes the baseline information and the optional specialised elections
  *
  * @param agreementTerms Specification of the content of the legal agreement.
  * @param relatedAgreements Specifies the agreement(s) that govern the agreement, either as a reference to such agreements when specified as part of the CDM, or through identification of some of the key terms of those agreements, such as the type of agreement, the publisher, the vintage, the agreement identifier and the agreement date.
  * @param umbrellaAgreement The determination of whether Umbrella Agreement terms are applicable (True) or Not Applicable (False).
  * @param meta 
  * @param agreementDate The date on which the legal agreement has been agreed between the parties. This corresponds to the Date of Deed in an English Law document.
  * @param effectiveDate The date on which, or as of which, the agreement is effective, if different from the agreement date. It is expected that it will most often correspond to the agreement date, although there could be situations where the parties will explicitly agree on a distinct effective date.
  * @param identifier The legal agreement identifier. Several identifiers can be specified.
  * @param legalAgreementIdentification The type of legal agreement, identified via a set of composable attributes: agreementName, publisher, governing law and version, e.g. ISDA 2013 Standard Credit Support Annex English Law.
  * @param contractualParty The two contractual parties to the legal agreement, which reference information is positioned as part of the partyInformation attribute.
  * @param otherParty The role(s) that other party(ies) may have in relation to the legal agreement, further to the contractual parties.
  * @param attachment A human readable document, for example a confirmation.
  */
case class LegalAgreement(agreementTerms: Option[AgreementTerms],
    relatedAgreements: List[LegalAgreement],
    umbrellaAgreement: Option[UmbrellaAgreement],
    meta: Option[MetaFields],
    agreementDate: Option[java.time.LocalDate],
    effectiveDate: Option[java.time.LocalDate],
    identifier: List[Identifier],
    legalAgreementIdentification: LegalAgreementIdentification,
    contractualParty: List[ReferenceWithMetaParty],
    otherParty: List[PartyRole],
    attachment: List[Resource])
  extends LegalAgreementBaseTrait {
}

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
case class LegalAgreementBase(agreementDate: Option[java.time.LocalDate],
    effectiveDate: Option[java.time.LocalDate],
    identifier: List[Identifier],
    legalAgreementIdentification: LegalAgreementIdentification,
    contractualParty: List[ReferenceWithMetaParty],
    otherParty: List[PartyRole],
    attachment: List[Resource])
  extends LegalAgreementBaseTrait {
}

/**
  * Specifies the type of legal agreement, identified via a set of composable attributes: agreementName, publisher, governing law and version, e.g. ISDA 2013 Standard Credit Support Annex English Law.
  *
  * @param governingLaw The law governing the legal agreement, e.g. English Law, New York Law or Japanese Law.
  * @param agreementName The legal agreement name, e.g. Credit Support Annex for Variation Margin.
  * @param publisher The legal agreement publisher, e.g. ISDA.
  * @param vintage In the case where successive definitions of the legal agreement have been developed, the vintage identification. This is typically (but not necessarily) done by referencing the year, e.g. 2013 in the case of the ISDA 2013 Standard Credit Support Annex.
  */
case class LegalAgreementIdentification(@JsonDeserialize(contentAs = classOf[GoverningLawEnum.Value])
    @JsonScalaEnumeration(classOf[GoverningLawEnum.Class])
    governingLaw: Option[GoverningLawEnum.Value],
    agreementName: AgreementName,
    @JsonDeserialize(contentAs = classOf[LegalAgreementPublisherEnum.Value])
    @JsonScalaEnumeration(classOf[LegalAgreementPublisherEnum.Class])
    publisher: Option[LegalAgreementPublisherEnum.Value],
    vintage: Option[Int]) {
}

/**
  * A class to specify a legal entity, with a required name and an optional entity identifier (such as the LEI).
  *
  * @param entityId A legal entity identifier (e.g. RED entity code).
  * @param name The legal entity name.
  * @param meta 
  */
case class LegalEntity(entityId: List[FieldWithMetaString],
    name: FieldWithMetaString,
    meta: Option[MetaFields])
  extends LegalEntityTrait {
}

case class LimitApplicable(limitType: Option[FieldWithMetaCreditLimitTypeEnum],
    clipSize: Option[Int],
    amountUtilized: Option[scala.math.BigDecimal],
    utilization: Option[CreditLimitUtilisation],
    amountRemaining: Option[scala.math.BigDecimal],
    currency: Option[FieldWithMetaString],
    velocity: Option[Velocity])
  extends LimitApplicableTrait {
}

/**
  * A class to represent the CDM attributes that are not part of the FpML standard. Once broader usage is confirmed, it is expected that those two classes can be collapsed.
  *
  * @param limitLevel The level at which the limit is set: customer business, proprietary business or account level. This attribute is specified as a string as part of the CME clearing confirmation specification.
  * @param limitAmount The total limit available for the limit level and limit type. While the attribute is of type integer in the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
  * @param limitImpactDueToTrade The limit utilized by this specific trade. While the attribute is of type integer in the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
  * @param limitType Standard code to indicate which type of credit line is being referred to - i.e. IM, DV01, PV01, CS01, Notional, Clip Size, Notional, maximumOrderQuantity.
  * @param clipSize This element is required in FpML, optional in CDM for the purpose of accommodating the CME data representation while making reference to the FpML one.
  * @param amountUtilized The limit utilised by all the cleared trades for the limit level and limit type. While the attribute is of type integer in FpML and the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
  * @param utilization 
  * @param amountRemaining The limit remaining for the limit level and limit type. This does not take into account any pending trades. While the attribute is of type integer in FpML and the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
  * @param currency The currency in which the applicable limit is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
  * @param velocity 
  */
case class LimitApplicableExtended(limitLevel: Option[FieldWithMetaLimitLevelEnum],
    limitAmount: Option[scala.math.BigDecimal],
    limitImpactDueToTrade: Option[scala.math.BigDecimal],
    limitType: Option[FieldWithMetaCreditLimitTypeEnum],
    clipSize: Option[Int],
    amountUtilized: Option[scala.math.BigDecimal],
    utilization: Option[CreditLimitUtilisation],
    amountRemaining: Option[scala.math.BigDecimal],
    currency: Option[FieldWithMetaString],
    velocity: Option[Velocity])
  extends LimitApplicableTrait {
}

/**
  * A class to provide lineage information across lifecycle events through a pointer or set of pointers into the event(s), contract(s) and, possibly, payout components that the event is dependent on or relates to. As an example, if an contractFormation event is corrected, the correction event will have a lineage into the initial event, which takes the form of a globalKey into that initial contract formation event. Two referencing mechanisms are provided as part of the CDM: either the globalKey, which corresponds to the hash value of the CDM class which is referred to, or a reference qualifier which is meant to provide support for the ingestion of xml documents with id/href mechanisms. The CDM recommends the use of the globalKey and provides a default implementation which is accessible in the generated code through org.isda.cdm.globalKey.GlobalKeyHashCalculator. If implementers want to use an alternative hashing mechanism, the API in which they need to plug it is com.rosetta.model.lib.HashFunction.
  *
  * @param tradeReference 
  * @param eventReference The reference to the instantiation of an Event object, either through a globalKey or an xml-derived id/href mechanism. The definition associated to the Lineage class provides more details with respect to those referencing approaches, their expected usage and available implementation.
  * @param portfolioStateReference The reference to the previous state of a Portfolio, in a chain of Events leading up to a build of that Portfolio as the holding of Product(s) in specific Quantity(ies). As part of the PortfolioState object, a pointer to the previous PortfolioState is provided through a Lineage object, together with pointer(s) to the Event or set of Events leading up to the current (new) state.
  */
case class Lineage(tradeReference: List[ReferenceWithMetaTrade],
    eventReference: List[ReferenceWithMetaWorkflowStep],
    portfolioStateReference: List[ReferenceWithMetaPortfolioState]) {
}

/**
  * A securitized derivative on another asset.
  *
  * @param deliveryTerm Also called contract month or delivery month. However, it's not always a month. It is usually expressed using a code, e.g. Z23 would be the Dec 2023 contract, (Z = December). For crude oil, the corresponding contract might be called CLZ23. Optional as this can be uniquely identified in the identifier.
  * @param optionType The type of option, ie Put or Call. Left empty if it is a Future.
  * @param strike Specifies the strike of the option.
  * @param instrumentType Identifies the type of an instrument using an enumerated list.
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class ListedDerivative(deliveryTerm: Option[String],
    @JsonDeserialize(contentAs = classOf[PutCallEnum.Value])
    @JsonScalaEnumeration(classOf[PutCallEnum.Class])
    optionType: Option[PutCallEnum.Value],
    strike: Option[scala.math.BigDecimal],
    @JsonScalaEnumeration(classOf[InstrumentTypeEnum.Class])
    instrumentType: InstrumentTypeEnum.Value,
    identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends InstrumentBaseTrait {
}

/**
  * Specifies a filter based on a stock exchange.
  *
  * @param exchange Represents a filter based on the Primary Stock Exchange facilitating the listing of companies, exchange of Stocks, Exchange traded Derivatives, Bonds, and other Securities expressed in ISO standard 10383.
  */
case class ListingExchange(exchange: List[FieldWithMetaString]) {
}

/**
  * Specifies a filter based on an industry sector.
  *
  * @param sector Represents a filter based on an industry sector defined under a system for classifying industry types such as Global Industry Classification Standard (GICS) and North American Industry Classification System (NAICS)
  */
case class ListingSector(sector: List[FieldWithMetaString]) {
}

/**
  * Identifies a loan by referencing an asset identifier and through an optional set of attributes.
  *
  * @param borrower Specifies the borrower. There can be more than one borrower. It is meant to be used in the event that there is no Bloomberg Id or the Secured List isn't applicable.
  * @param lien Specifies the seniority level of the lien.
  * @param facilityType Specifies the type of loan facility (letter of credit, revolving, ...).
  * @param creditAgreementDate Specifies the credit agreement date is the closing date (the date where the agreement has been signed) for the loans in the credit agreement. Funding of the facilities occurs on (or sometimes a little after) the Credit Agreement date. This underlier attribute is used to help identify which of the company's outstanding loans are being referenced by knowing to which credit agreement it belongs. ISDA Standards Terms Supplement term: Date of Original Credit Agreement.
  * @param tranche Denotes the loan tranche that is subject to the derivative transaction. It will typically be referenced as the Bloomberg tranche number. ISDA Standards Terms Supplement term: Bloomberg Tranche Number.
  * @param instrumentType Identifies the type of an instrument using an enumerated list.
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class Loan(borrower: List[LegalEntity],
    lien: Option[FieldWithMetaString],
    facilityType: Option[FieldWithMetaString],
    creditAgreementDate: Option[java.time.LocalDate],
    tranche: Option[FieldWithMetaString],
    @JsonScalaEnumeration(classOf[InstrumentTypeEnum.Class])
    instrumentType: InstrumentTypeEnum.Value,
    identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends InstrumentBaseTrait {
}

/**
  * A class to specify loan with a participation agreement whereby the buyer is capable of creating, or procuring the creation of, a contractual right in favour of the seller that provides the seller with recourse to the participation seller for a specified share in any payments due under the relevant loan which are received by the participation seller. ISDA 2003 Term: Direct Loan Participation.
  *
  * @param qualifyingParticipationSeller If Direct Loan Participation is specified as a deliverable obligation characteristic, this specifies any requirements for the Qualifying Participation Seller. The requirements may be listed free-form. ISDA 2003 Term: Qualifying Participation Seller.
  * @param applicable Indicates whether the provision is applicable.
  * @param partialCashSettlement Specifies whether either 'Partial Cash Settlement of Assignable Loans', 'Partial Cash Settlement of Consent Required Loans' or 'Partial Cash Settlement of Participations' is applicable. If this element is specified and Assignable Loan is a Deliverable Obligation Characteristic, any Assignable Loan that is deliverable, but where a non-receipt of Consent by the Physical Settlement Date has occurred, the Loan can be cash settled rather than physically delivered. If this element is specified and Consent Required Loan is a Deliverable Obligation Characteristic, any Consent Required Loan that is deliverable, but where a non-receipt of Consent by the Physical Settlement Date has occurred, the Loan can be cash settled rather than physically delivered. If this element is specified and Direct Loan Participation is a Deliverable Obligation Characteristic, any Participation that is deliverable, but where this participation has not been effected (has not come into effect) by the Physical Settlement Date, the participation can be cash settled rather than physically delivered.
  */
case class LoanParticipation(qualifyingParticipationSeller: Option[String],
    applicable: Boolean,
    partialCashSettlement: Option[Boolean])
  extends PCDeliverableObligationCharacTrait {
}

/**
  * Specifies a location identifier. An issuer and an identifier type can be associated with the actual identifier value as a way to properly qualify it.
  *
  * @param locationIdentifierType Specifies the nature of a location identifier.
  * @param issuerReference The identifier issuer, when specified by reference to a party specified as part of the transaction.
  * @param issuer The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).
  * @param assignedIdentifier The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.
  * @param meta 
  */
case class LocationIdentifier(@JsonDeserialize(contentAs = classOf[CommodityLocationIdentifierTypeEnum.Value])
    @JsonScalaEnumeration(classOf[CommodityLocationIdentifierTypeEnum.Class])
    locationIdentifierType: Option[CommodityLocationIdentifierTypeEnum.Value],
    issuerReference: Option[ReferenceWithMetaParty],
    issuer: Option[FieldWithMetaString],
    assignedIdentifier: List[AssignedIdentifier],
    meta: Option[MetaFields])
  extends IdentifierTrait {
}

/**
  * A class to specify the amount to be paid by the buyer of the option if the option is exercised prior to the Early Call Date (typically applicable to the convertible bond options).
  *
  * @param interpolationMethod The type of interpolation method that the calculation agent reserves the right to use.
  * @param earlyCallDate Date prior to which the option buyer will have to pay a Make Whole Amount to the option seller if he/she exercises the option.
  * @param floatingRateIndex 
  * @param indexTenor The ISDA Designated Maturity, i.e. the tenor of the floating rate.
  * @param spread Spread in basis points over the floating rate index.
  * @param side The side (bid/mid/ask) of the measure.
  */
case class MakeWholeAmount(@JsonDeserialize(contentAs = classOf[InterpolationMethodEnum.Value])
    @JsonScalaEnumeration(classOf[InterpolationMethodEnum.Class])
    interpolationMethod: Option[InterpolationMethodEnum.Value],
    earlyCallDate: FieldWithMetaLocalDate,
    @JsonScalaEnumeration(classOf[FloatingRateIndexEnum.Class])
    floatingRateIndex: FloatingRateIndexEnum.Value,
    indexTenor: Option[Period],
    spread: scala.math.BigDecimal,
    @JsonDeserialize(contentAs = classOf[QuotationSideEnum.Value])
    @JsonScalaEnumeration(classOf[QuotationSideEnum.Class])
    side: Option[QuotationSideEnum.Value])
  extends SwapCurveValuationTrait {
}

/**
  * A data to:  define an early termination provision for which exercise is mandatory.
  *
  * @param mandatoryEarlyTerminationDate The early termination date associated with a mandatory early termination of a swap.
  * @param calculationAgent The ISDA Calculation Agent responsible for performing duties associated with an optional early termination.
  * @param cashSettlement If specified, this means that cash settlement is applicable to the transaction and defines the parameters associated with the cash settlement procedure. If not specified, then physical settlement is applicable.
  * @param mandatoryEarlyTerminationAdjustedDates The adjusted dates associated with a mandatory early termination provision. These dates have been adjusted for any applicable business day convention.
  * @param meta 
  */
case class MandatoryEarlyTermination(mandatoryEarlyTerminationDate: AdjustableDate,
    calculationAgent: CalculationAgent,
    cashSettlement: SettlementTerms,
    mandatoryEarlyTerminationAdjustedDates: Option[MandatoryEarlyTerminationAdjustedDates],
    meta: Option[MetaFields]) {
}

/**
  * A data defining:  the adjusted dates associated with a mandatory early termination provision.
  *
  * @param adjustedEarlyTerminationDate The early termination date that is applicable if an early termination provision is exercised. This date should already be adjusted for any applicable business day convention.
  * @param adjustedCashSettlementValuationDate The date by which the cash settlement amount must be agreed. This date should already be adjusted for any applicable business day convention.
  * @param adjustedCashSettlementPaymentDate The date on which the cash settlement amount is paid. This date should already be adjusted for any applicable business date convention.
  */
case class MandatoryEarlyTerminationAdjustedDates(adjustedEarlyTerminationDate: java.time.LocalDate,
    adjustedCashSettlementValuationDate: java.time.LocalDate,
    adjustedCashSettlementPaymentDate: java.time.LocalDate) {
}

/**
  * A class defining manual exercise, i.e. that the option buyer counterparty must give notice to the option seller of exercise.
  *
  * @param exerciseNotice Definition of the party to whom notice of exercise should be given.
  * @param fallbackExercise If fallback exercise is specified then the notional amount of the underlying swap, not previously exercised under the swaption, will be automatically exercised at the expiration time on the expiration date if at such time the buyer is in-the-money, provided that the difference between the settlement rate and the fixed rate under the relevant underlying swap is not less than one tenth of a percentage point (0.10% or 0.001). The term in-the-money is assumed to have the meaning defined in the 2000 ISDA Definitions, Section 17.4. In-the-money.
  */
case class ManualExercise(exerciseNotice: Option[ExerciseNotice],
    fallbackExercise: Option[Boolean]) {
}

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
case class MarginCallBase(instructionType: MarginCallInstructionType,
    party: List[Party],
    partyRole: List[PartyRole],
    clearingBroker: Option[Party],
    callIdentifier: Option[Identifier],
    callAgreementType: AgreementName,
    agreementMinimumTransferAmount: Option[Money],
    agreementThreshold: Option[Money],
    agreementRounding: Option[Money],
    @JsonScalaEnumeration(classOf[RegMarginTypeEnum.Class])
    regMarginType: RegMarginTypeEnum.Value,
    @JsonDeserialize(contentAs = classOf[RegIMRoleEnum.Value])
    @JsonScalaEnumeration(classOf[RegIMRoleEnum.Class])
    regIMRole: Option[RegIMRoleEnum.Value],
    baseCurrencyExposure: Option[MarginCallExposure],
    collateralPortfolio: Option[ReferenceWithMetaCollateralPortfolio],
    independentAmountBalance: Option[CollateralBalance])
  extends MarginCallBaseTrait {
}

/**
  * Represents attributes required for mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency).
  *
  * @param overallExposure Represents the whole overall mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency).
  * @param simmIMExposure Represents Initial Margin (IM) exposure derived from ISDA SIMM calculation.
  * @param scheduleGridIMExposure Represents Initial Margin (IM) exposure derived from schedule or Grid calculation.
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
case class MarginCallExposure(overallExposure: Exposure,
    simmIMExposure: Option[Exposure],
    scheduleGridIMExposure: Option[Exposure],
    instructionType: MarginCallInstructionType,
    party: List[Party],
    partyRole: List[PartyRole],
    clearingBroker: Option[Party],
    callIdentifier: Option[Identifier],
    callAgreementType: AgreementName,
    agreementMinimumTransferAmount: Option[Money],
    agreementThreshold: Option[Money],
    agreementRounding: Option[Money],
    @JsonScalaEnumeration(classOf[RegMarginTypeEnum.Class])
    regMarginType: RegMarginTypeEnum.Value,
    @JsonDeserialize(contentAs = classOf[RegIMRoleEnum.Value])
    @JsonScalaEnumeration(classOf[RegIMRoleEnum.Class])
    regIMRole: Option[RegIMRoleEnum.Value],
    baseCurrencyExposure: Option[MarginCallExposure],
    collateralPortfolio: Option[ReferenceWithMetaCollateralPortfolio],
    independentAmountBalance: Option[CollateralBalance])
  extends MarginCallBaseTrait {
}

/**
  * Represents enumeration values to specify the call notification type, direction, specific action type.
  *
  * @param callType Indicates the status of the call message type, such as expected call, notification of a call or an actionable margin call.
  * @param visibilityIndicator Indicates the choice if the call instruction is visible or not to the other party.
  */
case class MarginCallInstructionType(@JsonScalaEnumeration(classOf[CallTypeEnum.Class])
    callType: CallTypeEnum.Value,
    visibilityIndicator: Option[Boolean]) {
}

/**
  * Represents common attributes required for a Margin Call Issuance under a legal agreement such as a credit support document or equivalent.
  *
  * @param callAmountInBaseCurrency Specifies the amount of margin being called for which accounts for margin calculation inclusive of exposure, independent amount,threshold,collateral balance, MTA, rounding increments (in base currency detailed in supporting collateral agreement).
  * @param recallNonCashCollateralDescription Specifies the details to describe or identify non-cash collateral eligible assets for recall purposes.
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
case class MarginCallIssuance(callAmountInBaseCurrency: Money,
    recallNonCashCollateralDescription: List[EligibleCollateralCriteria],
    instructionType: MarginCallInstructionType,
    party: List[Party],
    partyRole: List[PartyRole],
    clearingBroker: Option[Party],
    callIdentifier: Option[Identifier],
    callAgreementType: AgreementName,
    agreementMinimumTransferAmount: Option[Money],
    agreementThreshold: Option[Money],
    agreementRounding: Option[Money],
    @JsonScalaEnumeration(classOf[RegMarginTypeEnum.Class])
    regMarginType: RegMarginTypeEnum.Value,
    @JsonDeserialize(contentAs = classOf[RegIMRoleEnum.Value])
    @JsonScalaEnumeration(classOf[RegIMRoleEnum.Class])
    regIMRole: Option[RegIMRoleEnum.Value],
    baseCurrencyExposure: Option[MarginCallExposure],
    collateralPortfolio: Option[ReferenceWithMetaCollateralPortfolio],
    independentAmountBalance: Option[CollateralBalance])
  extends MarginCallBaseTrait {
}

/**
  * Represents common attributes required for a Margin Call Response under a legal agreement such as a credit support document or equivalent.
  *
  * @param marginCallResponseAction Specifies the margin call action details, including collateral to be moved and direction.
  * @param marginResponseType Indicates the response type, such as, is the margin call response a 'full' 'part' agreement or 'dispute'.
  * @param agreedAmountBaseCurrency Indicates the amount that posting entity agrees to remit in response to margin call (in base currency).
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
case class MarginCallResponse(marginCallResponseAction: List[MarginCallResponseAction],
    @JsonScalaEnumeration(classOf[MarginCallResponseTypeEnum.Class])
    marginResponseType: MarginCallResponseTypeEnum.Value,
    agreedAmountBaseCurrency: Money,
    instructionType: MarginCallInstructionType,
    party: List[Party],
    partyRole: List[PartyRole],
    clearingBroker: Option[Party],
    callIdentifier: Option[Identifier],
    callAgreementType: AgreementName,
    agreementMinimumTransferAmount: Option[Money],
    agreementThreshold: Option[Money],
    agreementRounding: Option[Money],
    @JsonScalaEnumeration(classOf[RegMarginTypeEnum.Class])
    regMarginType: RegMarginTypeEnum.Value,
    @JsonDeserialize(contentAs = classOf[RegIMRoleEnum.Value])
    @JsonScalaEnumeration(classOf[RegIMRoleEnum.Class])
    regIMRole: Option[RegIMRoleEnum.Value],
    baseCurrencyExposure: Option[MarginCallExposure],
    collateralPortfolio: Option[ReferenceWithMetaCollateralPortfolio],
    independentAmountBalance: Option[CollateralBalance])
  extends MarginCallBaseTrait {
}

/**
  * Specifies the margin call action details, including collateral to be moved and its direction.
  *
  * @param collateralPositionComponent Specifies the collateral to be moved and its direction.
  * @param marginCallAction Specifies the margin call action details, specified as either Delivery or Return.
  */
case class MarginCallResponseAction(collateralPositionComponent: List[CollateralPosition],
    @JsonScalaEnumeration(classOf[MarginCallActionEnum.Class])
    marginCallAction: MarginCallActionEnum.Value) {
}

/**
  * Defines clauses that make up a Master Agreement
  *
  * @param identifer Unique identifier for the clause
  * @param name Optional textual description of the clause.
  * @param counterparty Optional counterparty role. This can be used where a clause needs to be assigned to a specific party on the agreement based upon their role i.e. Party A or Party B.
  * @param otherParty Optional party. This can be required for umbrella agreements where a clause may need to be assigned to a specific party who may or may not be on the agreement.
  * @param variant Allows multiple variants to be defined for a clause. This needs to be an array as some clauses can specify different variants for different parties. At least one variant must be specified for a clause.
  */
case class MasterAgreementClause(@JsonScalaEnumeration(classOf[MasterAgreementClauseIdentifierEnum.Class])
    identifer: MasterAgreementClauseIdentifierEnum.Value,
    name: Option[String],
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    counterparty: List[CounterpartyRoleEnum.Value],
    @JsonScalaEnumeration(classOf[PartyRoleEnum.Class])
    otherParty: List[PartyRoleEnum.Value],
    variant: List[MasterAgreementClauseVariant]) {
}

/**
  * Sets the details for a specific variant associated to a clause in a Master Agreement
  *
  * @param identifier Unique identifier for this variant
  * @param name Optional textual description of the variant.
  * @param counterparty Optional counterparty role. This can be used where a clause needs to assign a different variant to the different parties on the agreement based upon their role i.e. Party A or Party B.
  * @param otherParty Optional party. This can be used where a clause needs to assign different variants to different parties who may or may not be on the agreement.
  * @param variableSet For some variants of some clauses additional details are required to work out what has been elected. This array can be used to define the name and value of these variables. Please refer to the agreement documentation for more details of the variables that are available for any clause.
  */
case class MasterAgreementClauseVariant(@JsonScalaEnumeration(classOf[MasterAgreementVariantIdentifierEnum.Class])
    identifier: MasterAgreementVariantIdentifierEnum.Value,
    name: Option[String],
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    counterparty: List[CounterpartyRoleEnum.Value],
    @JsonScalaEnumeration(classOf[PartyRoleEnum.Class])
    otherParty: List[PartyRoleEnum.Value],
    variableSet: List[MasterAgreementVariableSet]) {
}

/**
  * The set of elections which specify a Master Agreement.
  *
  * @param clause Clauses that have had elections made against them in this Master Agreement. There must be at least one clause defined in the agreement.
  */
case class MasterAgreementSchedule(clause: List[MasterAgreementClause]) {
}

/**
  * Defines a type where additional variables associated to clauses and their variants can be described.
  *
  * @param variableSet For some variants a table of variables is required. To support this use case we need to be able to specify variables within variables. Including a variable set here gives us infinite nesting opportunities - realistically we are only ever expecting that a table would need to be defined for any particular clause, so we would expect two levels of nesting as a maximum i.e. variableSet->variableSet->name/value.
  * @param name The name of the variable
  * @param value The value for this variable
  */
case class MasterAgreementVariableSet(variableSet: List[MasterAgreementVariableSet],
    name: Option[String],
    value: Option[String]) {
}

/**
  * Legal agreement specification for General Terms and Elections that are applicable across multiple confirmations and are referenced by these confirmations.
  *
  */
case class MasterConfirmationBase()
  extends MasterConfirmationBaseTrait {
}

/**
  * Defines a concrete measure as a number associated to a unit. It extends MeasureBase by requiring the value attribute to be present. A measure may be unit-less so the unit attribute is still optional.
  *
  * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
  * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
  */
case class Measure(value: Option[scala.math.BigDecimal],
    unit: Option[UnitType])
  extends MeasureBaseTrait {
}

/**
  * Provides an abstract type to define a measure as a number associated to a unit. This type is abstract because all its attributes are optional. The types that extend it can specify further existence constraints.
  *
  * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
  * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
  */
case class MeasureBase(value: Option[scala.math.BigDecimal],
    unit: Option[UnitType])
  extends MeasureBaseTrait {
}

/**
  * A set of measures, all in the same unit, where the values are defined through a schedule of steps. The initial value may be defined either as part of the steps, or using the single amount attribute.
  *
  * @param datedValue A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
  * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
  * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
  */
case class MeasureSchedule(datedValue: List[DatedValue],
    value: Option[scala.math.BigDecimal],
    unit: Option[UnitType])
  extends MeasureScheduleTrait with MeasureBaseTrait {
}

/**
  * This class corresponds to the components of the FpML MessageHeader.model.
  *
  * @param messageId A unique identifier assigned to the message.
  * @param sentBy The identifier for the originator of a message instance.
  * @param sentTo The identifier(s) for the recipient(s) of a message instance.
  * @param copyTo A unique identifier (within the specified coding scheme) giving the details of some party to whom a copy of this message will be sent for reference.
  */
case class MessageInformation(messageId: FieldWithMetaString,
    sentBy: Option[FieldWithMetaString],
    sentTo: List[FieldWithMetaString],
    copyTo: List[FieldWithMetaString]) {
}

/**
  * Defines a monetary amount in a specified currency.
  *
  * @param meta 
  * @param multiplier Defines an optional number that the quantity should be multiplied by to derive a total quantity. This number is associated to a unit. For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unit would be contracts, the multiplier value would 1,000 and the mulitiplier unit would be 1,000 MT (Metric Tons).
  * @param frequency Defines the frequency to be used when defining a quantity. For example a quantity may be specified as a number of barrels of oil per day, which needs multiplying by the number of days in the relevant period to get the total quantity as a number of barrels.
  * @param datedValue A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
  * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
  * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
  */
case class Money(meta: Option[MetaFields],
    multiplier: Option[Measure],
    frequency: Option[Frequency],
    datedValue: List[DatedValue],
    value: Option[scala.math.BigDecimal],
    unit: Option[UnitType])
  extends QuantityTrait {
}

/**
  * The money bound is defined as a money amount and whether the bound is inclusive.
  *
  * @param money The money amount to be used as the bound, e.g. 1,000 USD.
  * @param inclusive Whether the money amount bound is inclusive, e.g. for a lower bound, false would indicate greater than, whereas true would indicate greater than or equal to.
  */
case class MoneyBound(money: Money,
    inclusive: Boolean) {
}

/**
  * The money range defined as either a lower and upper money bound, or both.
  *
  * @param lowerBound The lower bound of a money range, e.g. greater than or equal to 1,000 USD.
  * @param upperBound The upper bound of a money range, e.g. less than 10,000 USD.
  */
case class MoneyRange(lowerBound: Option[MoneyBound],
    upperBound: Option[MoneyBound]) {
}

/**
  * Represetns a class to specify multiple credit notations alongside a conditional 'any' or 'all' qualifier.
  *
  * @param condition An enumerated element, to qualify whether All or Any credit notation applies.
  * @param creditNotation At least two credit notations much be specified.
  * @param mismatchResolution 
  * @param referenceAgency 
  */
case class MultipleCreditNotations(@JsonScalaEnumeration(classOf[QuantifierEnum.Class])
    condition: QuantifierEnum.Value,
    creditNotation: List[FieldWithMetaCreditNotation],
    @JsonDeserialize(contentAs = classOf[CreditNotationMismatchResolutionEnum.Value])
    @JsonScalaEnumeration(classOf[CreditNotationMismatchResolutionEnum.Class])
    mismatchResolution: Option[CreditNotationMismatchResolutionEnum.Value],
    @JsonDeserialize(contentAs = classOf[CreditRatingAgencyEnum.Value])
    @JsonScalaEnumeration(classOf[CreditRatingAgencyEnum.Class])
    referenceAgency: Option[CreditRatingAgencyEnum.Value]) {
}

/**
  * Represents a class to specify multiple credit debt types alongside a conditional 'any' or 'all' qualifier.
  *
  * @param condition An enumerated attribute, to qualify whether All or Any debt type applies.
  * @param debtType The type of debt, e.g. long term debt, deposit, ... FpML doesn't specific a scheme value, hence no enumeration is specified as part of the CDM. At least two debt types much be specified.
  */
case class MultipleDebtTypes(@JsonScalaEnumeration(classOf[QuantifierEnum.Class])
    condition: QuantifierEnum.Value,
    debtType: List[FieldWithMetaString]) {
}

/**
  * A class defining multiple exercises. As defined in the 2000 ISDA Definitions, Section 12.4. Multiple Exercise, the buyer of the option has the right to exercise all or less than all the unexercised notional amount of the underlying swap on one or more days in the exercise period, but on any such day may not exercise less than the minimum notional amount or more than the maximum notional amount, and if an integral multiple amount is specified, the notional exercised must be equal to or, be an integral multiple of, the integral multiple amount. In FpML, MultipleExercise is built upon the PartialExercise.model.
  *
  * @param maximumNotionalAmount The maximum notional amount that can be exercised on a given exercise date.
  * @param maximumNumberOfOptions The maximum number of options that can be exercised on a given exercise date. If the number is not specified, it means that the maximum number of options corresponds to the remaining unexercised options.
  * @param notionaReference A pointer style reference to the associated notional schedule defined elsewhere in the document. This element has been made optional as part of its integration in the OptionBaseExtended, because not required for the options on securities.
  * @param integralMultipleAmount A notional amount which restricts the amount of notional that can be exercised when partial exercise or multiple exercise is applicable. The integral multiple amount defines a lower limit of notional that can be exercised and also defines a unit multiple of notional that can be exercised, i.e. only integer multiples of this amount can be exercised.
  * @param minimumNotionalAmount The minimum notional amount that can be exercised on a given exercise date. See multipleExercise.
  * @param minimumNumberOfOptions The minimum number of options that can be exercised on a given exercise date.
  */
case class MultipleExercise(maximumNotionalAmount: Option[scala.math.BigDecimal],
    maximumNumberOfOptions: Option[Int],
    notionaReference: ReferenceWithMetaMoney,
    integralMultipleAmount: Option[scala.math.BigDecimal],
    minimumNotionalAmount: Option[scala.math.BigDecimal],
    minimumNumberOfOptions: Option[Int])
  extends PartialExerciseTrait {
}

case class MultipleValuationDates(businessDaysThereafter: Option[Int],
    numberValuationDates: Option[Int],
    businessDays: Option[Int])
  extends SingleValuationDateTrait {
}

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
case class NaturalPerson(personId: List[FieldWithMetaPersonIdentifier],
    honorific: Option[String],
    firstName: Option[String],
    middleName: List[String],
    initial: List[String],
    surname: Option[String],
    suffix: Option[String],
    dateOfBirth: Option[java.time.LocalDate],
    contactInformation: Option[ContactInformation],
    meta: Option[MetaFields]) {
}

/**
  * A class to specify the role(s) that natural person(s) may have in relation to the contract.
  *
  * @param personReference A reference to the natural person to whom the role refers to.
  * @param role FpML specifies a person role that is distinct from the party role.
  */
case class NaturalPersonRole(personReference: ReferenceWithMetaNaturalPerson,
    role: List[FieldWithMetaNaturalPersonRoleEnum]) {
}

/**
  * Used to apply a NOT logic condition to a single Collateral Criteria.
  *
  * @param negativeCriteria 
  */
case class NegativeCriteria(negativeCriteria: CollateralCriteria) {
}

case class New(txId: String,
    exctgPty: String,
    invstmtPtyInd: String,
    submitgPty: String,
    buyr: Buyr,
    sellr: Sellr,
    ordrTrnsmssn: OrdrTrnsmssn,
    tx: Tx,
    finInstrm: FinInstrm,
    invstmtDcsnPrsn: InvstmtDcsnPrsn,
    exctgPrsn: ExctgPrsn,
    addtlAttrbts: AddtlAttrbts) {
}

case class Nm(refRate: RefRate,
    term: Term) {
}

/**
  * Specifies a quantity as a non-negative number, which condition is enforced through a data rule that only applies to the extending class.
  *
  * @param multiplier Defines an optional number that the quantity should be multiplied by to derive a total quantity. This number is associated to a unit. For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unit would be contracts, the multiplier value would 1,000 and the mulitiplier unit would be 1,000 MT (Metric Tons).
  * @param frequency Defines the frequency to be used when defining a quantity. For example a quantity may be specified as a number of barrels of oil per day, which needs multiplying by the number of days in the relevant period to get the total quantity as a number of barrels.
  * @param datedValue A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
  * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
  * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
  */
case class NonNegativeQuantity(multiplier: Option[Measure],
    frequency: Option[Frequency],
    datedValue: List[DatedValue],
    value: Option[scala.math.BigDecimal],
    unit: Option[UnitType])
  extends QuantityTrait {
}

case class NonNegativeQuantitySchedule(multiplier: Option[Measure],
    frequency: Option[Frequency],
    datedValue: List[DatedValue],
    value: Option[scala.math.BigDecimal],
    unit: Option[UnitType])
  extends QuantityScheduleTrait {
}

/**
  * A class defining a step date and non-negative step value pair. This step definitions are used to define varying rate or amount schedules, e.g. a notional amortisation or a step-up coupon schedule.
  *
  * @param stepDate The date on which the associated stepValue becomes effective. This day may be subject to adjustment in accordance with a business day convention.
  * @param stepValue The non-negative rate or amount which becomes effective on the associated stepDate. A rate of 5% would be represented as 0.05.
  * @param meta 
  */
case class NonNegativeStep(stepDate: java.time.LocalDate,
    stepValue: scala.math.BigDecimal,
    meta: Option[MetaFields]) {
}

/**
  * A data type to specify the financial product's economic terms, alongside the product identification and product taxonomy. The non-transferable product data type represents a product that can be traded (as part of a TradableProduct) but cannot be transferred to others.  It is meant to be used across the pre-execution, execution and (as part of the Contract) post-execution lifecycle contexts.
  *
  * @param identifier Comprises a identifier and a source to uniquely identify the nonTransferableProduct. 
  * @param taxonomy Specifies the product taxonomy, which is composed of a taxonomy value and a taxonomy source.
  * @param economicTerms The price forming features, including payouts and provisions.
  * @param meta 
  */
case class NonTransferableProduct(identifier: List[ProductIdentifier],
    taxonomy: List[ProductTaxonomy],
    economicTerms: EconomicTerms,
    meta: Option[MetaFields]) {
}

/**
  * A class to specify the ISDA 2003 Term: Not Domestic Currency.
  *
  * @param applicable Indicates whether the Not Domestic Currency provision is applicable.
  * @param currency An explicit specification of the domestic currency. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
  */
case class NotDomesticCurrency(applicable: Boolean,
    currency: Option[FieldWithMetaString]) {
}

/**
  * The number bound is defined as a number and whether the bound is inclusive.
  *
  * @param number The number to be used as the bound, e.g. 5.
  * @param inclusive Whether the number bound is inclusive, e.g. for a lower bound, false would indicate greater than, whereas true would indicate greater than or equal to.
  */
case class NumberBound(number: scala.math.BigDecimal,
    inclusive: Boolean) {
}

/**
  * The number range defined as either a lower and upper number bound, or both.
  *
  * @param lowerBound The lower bound of a number range, e.g. greater than or equal to 5.
  * @param upperBound The upper bound of a number range, e.g. less than 10.
  */
case class NumberRange(lowerBound: Option[NumberBound],
    upperBound: Option[NumberBound]) {
}

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
case class Obligations(@JsonScalaEnumeration(classOf[ObligationCategoryEnum.Class])
    category: ObligationCategoryEnum.Value,
    notSubordinated: Option[Boolean],
    specifiedCurrency: Option[SpecifiedCurrency],
    notSovereignLender: Option[Boolean],
    notDomesticCurrency: Option[NotDomesticCurrency],
    notDomesticLaw: Option[Boolean],
    listed: Option[Boolean],
    notDomesticIssuance: Option[Boolean],
    fullFaithAndCreditObLiability: Option[Boolean],
    generalFundObligationLiability: Option[Boolean],
    revenueObligationLiability: Option[Boolean],
    notContingent: Option[Boolean],
    excluded: Option[String],
    othReferenceEntityObligations: Option[String],
    designatedPriority: Option[FieldWithMetaString],
    cashSettlementOnly: Option[Boolean],
    deliveryOfCommitments: Option[Boolean],
    continuity: Option[Boolean]) {
}

/**
  * Specifies the object to be observed for a price, it could be an asset or a reference.
  *
  * @param Asset The object to be observed is an Asset, ie something that can be owned and transferred in the financial markets.
  * @param Basket The object to be observed is a Basket, ie a collection of Observables with an identifier and optional weightings.
  * @param Index The object to be observed is an Index, ie an observable computed on the prices, rates or valuations of a number of assets.
  */
case class Observable(asset: Option[Asset],
    basket: Option[Basket],
    index: Option[Index])
  extends ObservableTrait {
}

/**
  * Defines a single, numerical value that was observed in the marketplace. Observations of market data are made independently to business events or trade life-cycle events, so data instances of Observation can be created independently of any other model type, hence it is annotated as a root type. Observations will be broadly reused in many situations, so references to Observation are supported via the 'key' annotation.
  *
  * @param observedValue Specifies the observed value as a number.
  * @param observationIdentifier Represents the observation was made i.e. how to uniquely identify the observed value among the population of all available market data.
  * @param meta 
  */
case class Observation(observedValue: Price,
    observationIdentifier: ObservationIdentifier,
    meta: Option[MetaFields]) {
}

/**
  * Specifies a single date on which market observations take place and specifies optional associated weighting.
  *
  * @param unadjustedDate A date subject to adjustment.
  * @param adjustedDate The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
  * @param weight Specifies the degree of importance of the observation.
  * @param observationReference Specifies an identification key for the market observation. This attribute can be used as a reference to assign weights to a series of dates defined in a parametricSchedule.
  * @param meta 
  */
case class ObservationDate(unadjustedDate: Option[java.time.LocalDate],
    adjustedDate: Option[java.time.LocalDate],
    weight: Option[scala.math.BigDecimal],
    observationReference: Option[String],
    meta: Option[MetaFields]) {
}

/**
  * Describes date details for a set of observation dates in parametric or non-parametric form.
  *
  * @param observationSchedule Specifies a schedule of dates (non-parametric) on which market observations take place, and allows for the optional definition of weights where applicable.  When no weight is specified, then weight of each date is assumed to be 1.0
  * @param periodicSchedule Specifies the date range and frequency on which market observations take place.  Weights can be assigned to dates in the schedule by assigning the weight and corresponding observationReference in the observationSchedule.
  * @param parametricDates Specifies parametric terms to determine which days within a given calculation period the price would be observed. Typically associated with Commodities. 
  */
case class ObservationDates(observationSchedule: Option[ObservationSchedule],
    periodicSchedule: Option[PeriodicDates],
    parametricDates: Option[ParametricDates]) {
}

/**
  * Specifies the necessary information to create any observation event.
  *
  * @param creditEvent Specifies the necessary information to create a credit event.
  * @param corporateAction Specifies the necessary information to create a corporate action.
  */
case class ObservationEvent(creditEvent: Option[CreditEvent],
    corporateAction: Option[CorporateAction]) {
}

/**
  * Defines the parameters needed to uniquely identify a piece of data among the population of all available market data.
  *
  * @param observable Represents the asset or rate to which the observation relates.
  * @param observationDate Specifies the date value to use when resolving the market data.
  * @param observationTime Represents the time and time-zone.
  * @param informationSource Represents where the market data published and should be observed.
  * @param determinationMethodology Specifies the method according to which an amount or a date is determined.
  */
case class ObservationIdentifier(observable: Observable,
    observationDate: java.time.LocalDate,
    observationTime: Option[TimeZone],
    informationSource: Option[InformationSource],
    determinationMethodology: Option[DeterminationMethodology]) {
}

/**
  * Specifies inputs needed to process an observation.
  *
  * @param observationEvent Contains all information related to an observation.
  */
case class ObservationInstruction(observationEvent: ObservationEvent) {
}

/**
  * Parameters on daily observed computed rates, specifically daily caps and floors. This type is used to represent modular computed rates in interestRatePayouts.
  *
  * @param observationCapRate A daily observation cap rate.
  * @param observationFloorRate A daily observation floor rate.
  */
case class ObservationParameters(observationCapRate: Option[scala.math.BigDecimal],
    observationFloorRate: Option[scala.math.BigDecimal]) {
}

/**
  * Specifies a single date on which market observations take place and specifies optional associated weighting.
  *
  * @param observationDate Specifies an adjusted or unadjusted date for a market observation.
  * @param dateAdjustments The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
  */
case class ObservationSchedule(observationDate: List[ObservationDate],
    dateAdjustments: Option[BusinessDayAdjustments]) {
}

/**
  * Parameters to describe the observation shift for a daily compounded or averaged floating rate. This type is used to represent modular computed rates in interestRatePayouts.
  *
  * @param offsetDays The number of days of observation shift.
  * @param calculationBase Whether the rate is calculated in advance, in arrears, or relative to a reset date.
  * @param additionalBusinessDays Any additional business days that be applicable.
  */
case class ObservationShiftCalculation(offsetDays: Option[Int],
    @JsonDeserialize(contentAs = classOf[ObservationPeriodDatesEnum.Value])
    @JsonScalaEnumeration(classOf[ObservationPeriodDatesEnum.Class])
    calculationBase: Option[ObservationPeriodDatesEnum.Value],
    additionalBusinessDays: Option[BusinessCenters]) {
}

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
case class ObservationTerms(observationTime: Option[BusinessCenterTime],
    @JsonDeserialize(contentAs = classOf[TimeTypeEnum.Value])
    @JsonScalaEnumeration(classOf[TimeTypeEnum.Class])
    observationTimeType: Option[TimeTypeEnum.Value],
    informationSource: Option[FxSpotRateSource],
    precision: Option[Rounding],
    calculationPeriodDates: Option[CalculationPeriodDates],
    observationDates: ObservationDates,
    numberOfObservationDates: Option[Int]) {
}

/**
  * A class defining an offset used in calculating a new date relative to a reference date, e.g. calendar days, business days, commodity Business days, etc.
  *
  * @param dayType In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
  * @param periodMultiplier A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
  * @param period A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
  * @param meta 
  */
case class Offset(@JsonDeserialize(contentAs = classOf[DayTypeEnum.Value])
    @JsonScalaEnumeration(classOf[DayTypeEnum.Class])
    dayType: Option[DayTypeEnum.Value],
    periodMultiplier: Int,
    @JsonScalaEnumeration(classOf[PeriodEnum.Class])
    period: PeriodEnum.Value,
    meta: Option[MetaFields])
  extends OffsetTrait with PeriodTrait {
}

/**
  * Defines business day shifts for daily componded or averaged rates.  This type is used for lookback and lockout rates. This type is used to represent modular computed rates in interestRatePayouts.
  *
  * @param offsetDays The number of business days offset.
  */
case class OffsetCalculation(offsetDays: Option[Int]) {
}

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
case class OptionFeature(fxFeature: List[FxFeature],
    strategyFeature: Option[StrategyFeature],
    averagingFeature: Option[AveragingCalculation],
    barrier: Option[Barrier],
    knock: Option[Knock],
    passThrough: Option[PassThrough]) {
}

/**
  *  The option payout specification terms. The associated globalKey denotes the ability to associate a hash value to the respective OptionPayout instantiation for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
  *
  * @param buyerSeller 
  * @param feature The option feature, such as quanto, Asian, barrier, knock.
  * @param observationTerms Class containing terms that are associated with observing a price/benchmark/index across either single or multple observations. To be used for option contracts that reference a benchmark price.
  * @param schedule Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
  * @param delivery Contains the information relative to the delivery of the asset.
  * @param underlier The financial product underlying the option, which can be of any type including an Asset, Basket, Index or a NonTransferableProduct.
  * @param optionType The type of option transaction. From a usage standpoint, put/call is the default option type, while payer/receiver indicator is used for options on index credit default swaps, consistently with the industry practice. Straddle is used for the case of straddle strategy, that combine a call and a put with the same strike.
  * @param exerciseTerms The terms for exercising the option, which include the option style (e.g. American style option), the exercise procedure (e.g. manual exercise) and the settlement terms (e.g. physical vs. cash).
  * @param strike Specifies the strike of the option
  * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
  * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
  * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
  * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
  */
case class OptionPayout(buyerSeller: BuyerSeller,
    feature: Option[OptionFeature],
    observationTerms: Option[ObservationTerms],
    schedule: Option[CalculationSchedule],
    delivery: Option[AssetDeliveryInformation],
    underlier: Underlier,
    @JsonDeserialize(contentAs = classOf[OptionTypeEnum.Value])
    @JsonScalaEnumeration(classOf[OptionTypeEnum.Class])
    optionType: Option[OptionTypeEnum.Value],
    exerciseTerms: ExerciseTerms,
    strike: Option[OptionStrike],
    payerReceiver: PayerReceiver,
    priceQuantity: Option[ResolvablePriceQuantity],
    principalPayment: Option[PrincipalPayments],
    settlementTerms: Option[SettlementTerms])
  extends PayoutBaseTrait {
}

/**
  * Defines the strike price of an option.
  *
  * @param strikePrice Defines the strike of an option in the form of a price that could be a cash price, interestRate, or other types.
  * @param strikeReference Defines the strike of an option in reference to the spread of the underlying swap (typical practice in the case of an option on a credit single name swaps).
  * @param referenceSwapCurve Defines the strike of an option when expressed by reference to a swap curve (Typically the case for a convertible bond option).
  * @param averagingStrikeFeature Defines an  option strike that is calculated from an average of observed market prices.
  */
case class OptionStrike(strikePrice: Option[Price],
    strikeReference: Option[ReferenceWithMetaFixedRateSpecification],
    referenceSwapCurve: Option[ReferenceSwapCurve],
    averagingStrikeFeature: Option[AveragingStrikeFeature]) {
}

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
case class OptionalEarlyTermination(singlePartyOption: Option[BuyerSeller],
    mutualEarlyTermination: Option[Boolean],
    exerciseNotice: List[ExerciseNotice],
    followUpConfirmation: Option[Boolean],
    calculationAgent: Option[CalculationAgent],
    cashSettlement: Option[SettlementTerms],
    optionalEarlyTerminationAdjustedDates: Option[OptionalEarlyTerminationAdjustedDates],
    exerciseTerms: ExerciseTerms) {
}

/**
  * A data defining:  the adjusted dates associated with an optional early termination provision.
  *
  * @param earlyTerminationEvent The adjusted dates associated with an individual early termination date.
  */
case class OptionalEarlyTerminationAdjustedDates(earlyTerminationEvent: List[EarlyTerminationEvent]) {
}

case class OrdrTrnsmssn(trnsmssnInd: String) {
}

/**
  * A class for defining an agreement executed between parties.
  *
  * @param identifier An identifier that has been created to identify the agreement.
  * @param otherAgreementType The agreement executed between the parties and intended to govern product-specific derivatives transactions between those parties.
  * @param version The version of the agreement.
  * @param date The date on which the agreement was signed.
  */
case class OtherAgreement(identifier: Option[FieldWithMetaString],
    otherAgreementType: FieldWithMetaString,
    version: Option[FieldWithMetaString],
    date: Option[java.time.LocalDate]) {
}

/**
  * A class to specify a related legal agreement. For example, ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (s): Other CSA and Japanese Law CSA (VM). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (o): Other CSA.
  *
  * @param isSpecified The qualification of whether some other related agreement is specified (True) or not (False).
  * @param legalDocument The specification of this other agreement, when the qualification is True.
  */
case class OtherAgreementTerms(isSpecified: Boolean,
    legalDocument: Option[String]) {
}

/**
  * Specification of a user-defined index that does not meet the criteria of other Index data types.
  *
  * @param description A description that defines the OtherIndex.
  * @param name A description of the Index.
  * @param provider The organisation that creates or maintains the Index.
  * @param assetClass The Asset Class of the Index.
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class OtherIndex(description: Option[String],
    name: Option[FieldWithMetaString],
    provider: Option[LegalEntity],
    @JsonDeserialize(contentAs = classOf[AssetClassEnum.Value])
    @JsonScalaEnumeration(classOf[AssetClassEnum.Class])
    assetClass: Option[AssetClassEnum.Value],
    identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends IndexBaseTrait {
}

case class Othr(finInstrmGnlAttrbts: FinInstrmGnlAttrbts,
    derivInstrmAttrbts: DerivInstrmAttrbts,
    id: String,
    schmeNm: SchmeNm) {
}

/**
  * A class to specify the Partial Cash Deliverable Obligation Characteristic.
  *
  * @param applicable Indicates whether the provision is applicable.
  * @param partialCashSettlement Specifies whether either 'Partial Cash Settlement of Assignable Loans', 'Partial Cash Settlement of Consent Required Loans' or 'Partial Cash Settlement of Participations' is applicable. If this element is specified and Assignable Loan is a Deliverable Obligation Characteristic, any Assignable Loan that is deliverable, but where a non-receipt of Consent by the Physical Settlement Date has occurred, the Loan can be cash settled rather than physically delivered. If this element is specified and Consent Required Loan is a Deliverable Obligation Characteristic, any Consent Required Loan that is deliverable, but where a non-receipt of Consent by the Physical Settlement Date has occurred, the Loan can be cash settled rather than physically delivered. If this element is specified and Direct Loan Participation is a Deliverable Obligation Characteristic, any Participation that is deliverable, but where this participation has not been effected (has not come into effect) by the Physical Settlement Date, the participation can be cash settled rather than physically delivered.
  */
case class PCDeliverableObligationCharac(applicable: Boolean,
    partialCashSettlement: Option[Boolean])
  extends PCDeliverableObligationCharacTrait {
}

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
case class ParametricDates(@JsonScalaEnumeration(classOf[DayTypeEnum.Class])
    dayType: DayTypeEnum.Value,
    @JsonDeserialize(contentAs = classOf[DayDistributionEnum.Value])
    @JsonScalaEnumeration(classOf[DayDistributionEnum.Class])
    dayDistribution: Option[DayDistributionEnum.Value],
    @JsonScalaEnumeration(classOf[DayOfWeekEnum.Class])
    dayOfWeek: List[DayOfWeekEnum.Value],
    dayFrequency: Option[scala.math.BigDecimal],
    lag: Option[Lag],
    businessCenters: BusinessCenters) {
}

/**
  * A class defining partial exercise. As defined in the 2000 ISDA Definitions, Section 12.3 Partial Exercise, the buyer of the option may exercise all or less than all the notional amount of the underlying swap but may not be less than the minimum notional amount (if specified) and must be an integral multiple of the integral multiple amount if specified.
  *
  * @param notionaReference A pointer style reference to the associated notional schedule defined elsewhere in the document. This element has been made optional as part of its integration in the OptionBaseExtended, because not required for the options on securities.
  * @param integralMultipleAmount A notional amount which restricts the amount of notional that can be exercised when partial exercise or multiple exercise is applicable. The integral multiple amount defines a lower limit of notional that can be exercised and also defines a unit multiple of notional that can be exercised, i.e. only integer multiples of this amount can be exercised.
  * @param minimumNotionalAmount The minimum notional amount that can be exercised on a given exercise date. See multipleExercise.
  * @param minimumNumberOfOptions The minimum number of options that can be exercised on a given exercise date.
  */
case class PartialExercise(notionaReference: ReferenceWithMetaMoney,
    integralMultipleAmount: Option[scala.math.BigDecimal],
    minimumNotionalAmount: Option[scala.math.BigDecimal],
    minimumNumberOfOptions: Option[Int])
  extends PartialExerciseTrait {
}

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
case class Party(partyId: List[PartyIdentifier],
    name: Option[FieldWithMetaString],
    businessUnit: List[BusinessUnit],
    person: List[NaturalPerson],
    personRole: List[NaturalPersonRole],
    account: Option[Account],
    contactInformation: Option[ContactInformation],
    meta: Option[MetaFields]) {
}

/**
  * Specifies instruction to change the party on a trade. This primitive instruction is used in a number of scenarios including: clearing, allocation and novation. The instrution must include a trade identifier, because a change of party effectively results in a different trade.
  *
  * @param counterparty The new counterparty who is stepping into the trade. The stepping out counterparty is inferred based on the counterparty role that is being updated.
  * @param ancillaryParty Specifies an ancillary party to be added onto the new transaction, e.g. the original executing party in an allocation.
  * @param partyRole Specifies an additional party roles to be added on to the new transaction.
  * @param tradeId The identifier to be assigned to the new trade post change of party.
  */
case class PartyChangeInstruction(counterparty: Counterparty,
    ancillaryParty: Option[AncillaryParty],
    partyRole: Option[PartyRole],
    tradeId: List[TradeIdentifier]) {
}

/**
  * A class to specify contact information within a party: address and, optionally, associated business unit and person. This class also supports the ISDA CSA representation as a single string, through the address attribute.
  *
  * @param partyReference The reference to the party to which the contact information refers to.
  * @param contactInformation The postal/street address, telephone number, email address and/or web page. If the contact information is specific to the associated business unit(s), it should be associated with those.
  * @param businessUnit Optional organization unit information used to describe the organization units (e.g. trading desks) involved in a transaction or business process, incl. the contact information (when relevant).
  * @param person Optional information about people involved in a transaction or business process. (These are employees of the party.)
  * @param additionalInformation Specification of special instructions of the relevant party.
  */
case class PartyContactInformation(partyReference: Option[ReferenceWithMetaParty],
    contactInformation: Option[ContactInformation],
    businessUnit: List[BusinessUnit],
    person: List[NaturalPerson],
    additionalInformation: Option[String]) {
}

/**
  * A class to specify a party-related, non-standardized data in a generic form.
  *
  * @param partyReference Reference to the party to which the workflow pertains to.
  * @param partyName The party name to which the workflow pertains to.
  * @param customisedWorkflow Non-standardized data in a generic form.
  */
case class PartyCustomisedWorkflow(partyReference: Option[ReferenceWithMetaParty],
    partyName: Option[String],
    customisedWorkflow: List[CustomisedWorkflow]) {
}

/**
  * Comprises an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the PartyIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
  *
  * @param identifier Provides an identifier associated with a party. The identifier is unique within the public source specified in the source attribute.
  * @param identifierType Defines the source of the identifier.
  * @param meta 
  */
case class PartyIdentifier(identifier: FieldWithMetaString,
    @JsonDeserialize(contentAs = classOf[PartyIdentifierTypeEnum.Value])
    @JsonScalaEnumeration(classOf[PartyIdentifierTypeEnum.Class])
    identifierType: Option[PartyIdentifierTypeEnum.Value],
    meta: Option[MetaFields]) {
}

/**
  * Specifies the parties responsible for making and receiving payments defined by this structure.
  *
  * @param payerPartyReference The party responsible for making the payments defined by this structure.
  * @param payerAccountReference A reference to the account responsible for making the payments defined by this structure.
  * @param receiverPartyReference The party that receives the payments corresponding to this structure.
  * @param receiverAccountReference A reference to the account that receives the payments corresponding to this structure.
  */
case class PartyReferencePayerReceiver(payerPartyReference: ReferenceWithMetaParty,
    payerAccountReference: Option[ReferenceWithMetaAccount],
    receiverPartyReference: ReferenceWithMetaParty,
    receiverAccountReference: Option[ReferenceWithMetaAccount])
  extends PartyReferencePayerReceiverTrait {
}

/**
  * A class to specify the role(s) that party(ies) may have in relation to the execution, contract or other legal agreement.
  *
  * @param partyReference A reference to the party to which the role refers to.
  * @param role The party role.
  * @param ownershipPartyReference A reference to the party that has ownership of this party role information. FpML specifies that For shared trade information, this attribute will reference the originator of the data (for example, an execution facility or clearing house).
  */
case class PartyRole(partyReference: ReferenceWithMetaParty,
    @JsonScalaEnumeration(classOf[PartyRoleEnum.Class])
    role: PartyRoleEnum.Value,
    ownershipPartyReference: Option[ReferenceWithMetaParty]) {
}

/**
  * Type which contains pass through payments.
  *
  * @param passThroughItem One to many pass through payment items.
  */
case class PassThrough(passThroughItem: List[PassThroughItem]) {
}

/**
  * Class to represent a single pass through payment.
  *
  * @param payerReceiver This attribute doesn't exists in the FpML construct, which makes use of the PayerReceiver.model group.
  * @param passThroughPercentage Percentage of payments from the underlier which are passed through.
  */
case class PassThroughItem(payerReceiver: PayerReceiver,
    passThroughPercentage: scala.math.BigDecimal) {
}

/**
  * Specifies the parties responsible for making and receiving payments defined by this structure.
  *
  * @param payer Specifies the counterparty responsible for making the payments defined by this structure.  The party is one of the two principal parties to the transaction.
  * @param receiver Specifies the party that receives the payments corresponding to this structure.  The party is one of the two counterparties to the transaction.
  */
case class PayerReceiver(@JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    payer: CounterpartyRoleEnum.Value,
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    receiver: CounterpartyRoleEnum.Value)
  extends PayerReceiverTrait {
}

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
case class PaymentCalculationPeriod(unadjustedPaymentDate: Option[java.time.LocalDate],
    adjustedPaymentDate: Option[java.time.LocalDate],
    calculationPeriod: List[CalculationPeriod],
    fixedPaymentAmount: Option[Money],
    discountFactor: Option[scala.math.BigDecimal],
    forecastPaymentAmount: Option[Money],
    presentValueAmount: Option[Money],
    meta: Option[MetaFields]) {
}

/**
  * The payment dates when specified as relative to a set of dates specified somewhere else in the instance document/transaction, e.g. the valuation dates as typically the case for equity swaps, or when specified as a calculation period schedule.
  *
  * @param interimPaymentDates 
  * @param finalPaymentDate The last payment when specified as an adjustable or relative date, as in the FpML total return construct.
  */
case class PaymentDateSchedule(interimPaymentDates: List[AdjustableRelativeOrPeriodicDates],
    finalPaymentDate: Option[AdjustableOrRelativeDate]) {
}

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
case class PaymentDates(paymentFrequency: Option[Frequency],
    firstPaymentDate: Option[java.time.LocalDate],
    lastRegularPaymentDate: Option[java.time.LocalDate],
    paymentDateSchedule: Option[PaymentDateSchedule],
    @JsonDeserialize(contentAs = classOf[PayRelativeToEnum.Value])
    @JsonScalaEnumeration(classOf[PayRelativeToEnum.Class])
    payRelativeTo: Option[PayRelativeToEnum.Value],
    paymentDaysOffset: Option[Offset],
    paymentDatesAdjustments: Option[BusinessDayAdjustments],
    meta: Option[MetaFields]) {
}

case class PaymentDetail(paymentDate: Option[AdjustableOrRelativeDate],
    paymentRule: PaymentRule,
    paymentAmount: Option[Money],
    meta: Option[MetaFields]) {
}

/**
  * This class corresponds to the FpML PaymentDiscounting.model group for representing the discounting elements that can be associated with a payment.
  *
  * @param discountFactor The value representing the discount factor used to calculate the present value of the cash flow.
  * @param presentValueAmount The amount representing the present value of the forecast payment.
  */
case class PaymentDiscounting(discountFactor: Option[scala.math.BigDecimal],
    presentValueAmount: Option[Money]) {
}

/**
  * A class defining the payment calculation rule. As of FpML 5.10, percentage rule is the only calculation rule that has been specified as part of the standard.
  *
  * @param percentageRule This attribute is not present as part of the FpML construct, as the payment rule is specialised by means of runtime type extension through the xsi:type.
  */
case class PaymentRule(percentageRule: Option[PercentageRule]) {
}

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
case class Payout(assetPayout: Option[AssetPayout],
    commodityPayout: Option[CommodityPayout],
    creditDefaultPayout: Option[CreditDefaultPayout],
    fixedPricePayout: Option[FixedPricePayout],
    interestRatePayout: Option[InterestRatePayout],
    optionPayout: Option[OptionPayout],
    performancePayout: Option[PerformancePayout],
    settlementPayout: Option[SettlementPayout],
    meta: Option[MetaFields]) {
}

/**
  * A data type that contains the common attributes (e.g. payer and receiver parties) and validation conditions that apply across all payout types
  *
  * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
  * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
  * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
  * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
  */
case class PayoutBase(payerReceiver: PayerReceiver,
    priceQuantity: Option[ResolvablePriceQuantity],
    principalPayment: Option[PrincipalPayments],
    settlementTerms: Option[SettlementTerms])
  extends PayoutBaseTrait {
}

/**
  * A class defining a content model for a calculation rule defined as percentage of the notional amount.
  *
  * @param paymentPercent A percentage of the notional amount.
  * @param notionalAmountReference A reference to the notional amount.
  */
case class PercentageRule(paymentPercent: scala.math.BigDecimal,
    notionalAmountReference: ReferenceWithMetaMoney) {
}

/**
  * Contains the necessary specifications for all performance payouts, encompassing equity return, dividend, variance, volatility and correlation products.
  *
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
  * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
  * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
  * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
  * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
  */
case class PerformancePayout(observationTerms: Option[ObservationTerms],
    valuationDates: ValuationDates,
    paymentDates: PaymentDates,
    underlier: Option[Underlier],
    fxFeature: List[FxFeature],
    returnTerms: Option[ReturnTerms],
    portfolioReturnTerms: List[PortfolioReturnTerms],
    initialValuationPrice: List[ReferenceWithMetaPriceSchedule],
    interimValuationPrice: List[ReferenceWithMetaPriceSchedule],
    finalValuationPrice: List[ReferenceWithMetaPriceSchedule],
    payerReceiver: PayerReceiver,
    priceQuantity: Option[ResolvablePriceQuantity],
    principalPayment: Option[PrincipalPayments],
    settlementTerms: Option[SettlementTerms])
  extends PayoutBaseTrait {
}

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
case class PerformanceValuationDates(@JsonScalaEnumeration(classOf[DeterminationMethodEnum.Class])
    determinationMethod: DeterminationMethodEnum.Value,
    valuationDates: Option[AdjustableRelativeOrPeriodicDates],
    valuationDate: Option[AdjustableOrRelativeDate],
    valuationTime: Option[BusinessCenterTime],
    @JsonDeserialize(contentAs = classOf[TimeTypeEnum.Value])
    @JsonScalaEnumeration(classOf[TimeTypeEnum.Class])
    valuationTimeType: Option[TimeTypeEnum.Value],
    meta: Option[MetaFields]) {
}

/**
  * A class to define recurring periods or time offsets.
  *
  * @param periodMultiplier A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
  * @param period A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
  * @param meta 
  */
case class Period(periodMultiplier: Int,
    @JsonScalaEnumeration(classOf[PeriodEnum.Class])
    period: PeriodEnum.Value,
    meta: Option[MetaFields])
  extends PeriodTrait {
}

/**
  * Indicator to specify if the period bound is defined as a period and whether the bound is inclusive.
  *
  * @param period Specifies the period is to be used as the bound, e.g. 5Y.
  * @param inclusive Specifies whether the period bound is inclusive, e.g. for a lower bound, false would indicate greater than, whereas true would indicate greater than or equal to.
  */
case class PeriodBound(period: Period,
    inclusive: Boolean) {
}

/**
  * Indicates The period range defined as either a lower and upper period bound, or both.
  *
  * @param lowerBound Specifies the lower bound of a period range, e.g. greater than or equal to 5Y.
  * @param upperBound Specifies the upper bound of a period range, e.g. less than to 10Y.
  */
case class PeriodRange(lowerBound: Option[PeriodBound],
    upperBound: Option[PeriodBound]) {
}

/**
  * A class for specifying a calculation period schedule.
  *
  * @param startDate The start date of the calculation period. FpML specifies that for interest rate swaps this date must only be specified if it is not equal to the effective date. It is always specified in the case of equity swaps and credit default swaps with periodic payments. This date may be subject to adjustment in accordance with a business day convention.
  * @param endDate The end date of the calculation period. FpML specifies that for interest rate swaps this date must only be specified if it is not equal to the termination date. It is always specified in the case of equity swaps with periodic payments. This date may be subject to adjustment in accordance with a business day convention.
  * @param periodFrequency The frequency at which calculation period end dates occur with the regular part of the calculation period schedule and their roll date convention.
  * @param periodDatesAdjustments The specification of the business day convention and financial business centers used for adjusting any calculation period date if it would otherwise fall on a day that is not a business day in the specified business center.
  * @param dayType Denotes the enumerated values to specify the day type classification used in counting the number of days between two dates.
  */
case class PeriodicDates(startDate: Option[AdjustableOrRelativeDate],
    endDate: Option[AdjustableOrRelativeDate],
    periodFrequency: Option[CalculationPeriodFrequency],
    periodDatesAdjustments: Option[BusinessDayAdjustments],
    @JsonDeserialize(contentAs = classOf[DayTypeEnum.Value])
    @JsonScalaEnumeration(classOf[DayTypeEnum.Class])
    dayType: Option[DayTypeEnum.Value]) {
}

/**
  * Comprises an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the PersonIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
  *
  * @param identifier Provides an identifier associated with a person. The identifier is unique within the public source specified in the source attribute.
  * @param identifierType Defines the source of the identifier.
  * @param country The ISO 3166 standard code for the country issuing the identifier.
  * @param meta 
  */
case class PersonIdentifier(identifier: FieldWithMetaString,
    @JsonDeserialize(contentAs = classOf[PersonIdentifierTypeEnum.Value])
    @JsonScalaEnumeration(classOf[PersonIdentifierTypeEnum.Class])
    identifierType: Option[PersonIdentifierTypeEnum.Value],
    country: Option[FieldWithMetaString],
    meta: Option[MetaFields]) {
}

case class PhysicalSettlementPeriod(businessDaysNotSpecified: Option[Boolean],
    businessDays: Option[Int],
    maximumBusinessDays: Option[Int]) {
}

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
case class PhysicalSettlementTerms(clearedPhysicalSettlement: Option[Boolean],
    @JsonDeserialize(contentAs = classOf[AncillaryRoleEnum.Value])
    @JsonScalaEnumeration(classOf[AncillaryRoleEnum.Class])
    predeterminedClearingOrganizationParty: Option[AncillaryRoleEnum.Value],
    physicalSettlementPeriod: Option[PhysicalSettlementPeriod],
    deliverableObligations: Option[DeliverableObligations],
    escrow: Option[Boolean],
    sixtyBusinessDaySettlementCap: Option[Boolean],
    meta: Option[MetaFields]) {
}

/**
  *  A Portfolio represents an aggregation of multiple Positions, by describing the parameters that this Portfolio should be aggregated based on. The resulting PortfolioState is calculated using these aggregation parameters as inputs, by aggregating all the Events that are relevant to this Portfolio. The concept of Portfolio works at all levels in the model: from the highest for a given LegalEntity for instance, to the lowest to account for security substitutions in a secutity financing transaction. As such, Portfolio can be used either above or below the Contract level.
  *
  * @param aggregationParameters Describes the portfolio by describing how to aggregate all its relevant Events.
  * @param portfolioState Describes the state of the Portfolio as a list of Positions resulting from the aggregation.
  */
case class Portfolio(aggregationParameters: AggregationParameters,
    portfolioState: PortfolioState) {
}

/**
  * Specifies an individual type of return of a Performance Payout, when such individual return is part of an aggregation of multiple similar returns, at Performance Payout level.
  *
  * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each individual return leg.
  * @param underlier Defines the product that is the subject of a tradable product definition, an underlying product definition, a physical exercise, a position, or other purposes.
  * @param quantity Specifies a quantity schedule for the underlier, which applies to each individual return leg.
  * @param initialValuationPrice Specifies the initial valuation price(s) of the underlier. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
  * @param interimValuationPrice Specifies the initial valuation price(s) of the underlier. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
  * @param finalValuationPrice 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Final Price | Specifies the final valuation price of the underlier. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
  * @param meta 
  * @param priceReturnTerms Return terms based upon the underlier's observed price.
  * @param dividendReturnTerms Return terms based upon dividend payments associated to the underlier.
  * @param varianceReturnTerms Return terms based upon the observed variance of the underlier's price.
  * @param volatilityReturnTerms Return terms based upon the observed volatility of the underlier's price.
  * @param correlationReturnTerms Return terms based upon the observed correlation between the components of the underlying basket.
  */
case class PortfolioReturnTerms(payerReceiver: PayerReceiver,
    underlier: ReferenceWithMetaObservable,
    quantity: Option[ReferenceWithMetaNonNegativeQuantitySchedule],
    initialValuationPrice: List[ReferenceWithMetaPriceSchedule],
    interimValuationPrice: List[ReferenceWithMetaPriceSchedule],
    finalValuationPrice: List[ReferenceWithMetaPriceSchedule],
    meta: Option[MetaFields],
    priceReturnTerms: Option[PriceReturnTerms],
    dividendReturnTerms: Option[DividendReturnTerms],
    varianceReturnTerms: Option[VarianceReturnTerms],
    volatilityReturnTerms: Option[VolatilityReturnTerms],
    correlationReturnTerms: Option[CorrelationReturnTerms])
  extends ReturnTermsTrait {
}

/**
  * State-full representation of a Portfolio that describes all the positions held at a given time, in various states which can be either traded, settled, etc., with lineage information to the previous state
  *
  * @param positions The list of positions, each containing a Quantity and a Product.
  * @param lineage Pointer to the previous PortfolioState and new Event(s) leading to the current (new) state. Previous PortfolioState in the Lineage can be Null in case this is the start of the chain of Events.
  * @param meta 
  */
case class PortfolioState(positions: List[Position],
    lineage: Lineage,
    meta: Option[MetaFields]) {
}

/**
  * A Position describes how much of a given Product is being held and constitutes the atomic element of a Portfolio.
  *
  * @param priceQuantity Position with many price quantities.
  * @param product The product underlying the position.
  * @param cashBalance The aggregate cost of proceeds
  * @param tradeReference Reference to the Contract, in case product is contractual and the contract has been formed
  */
case class Position(priceQuantity: List[PriceQuantity],
    product: Product,
    cashBalance: Option[Money],
    tradeReference: Option[ReferenceWithMetaTradeState])
  extends PositionTrait {
}

/**
  * Defines a position identifier as a special case of the generic identifier type, that also includes the position identifier class.
  *
  * @param identifierType The enumerated classification of the identifier. Optional as a position identifier may be party-specific, in which case it may not correspond to any established classification.
  * @param issuerReference The identifier issuer, when specified by reference to a party specified as part of the transaction.
  * @param issuer The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).
  * @param assignedIdentifier The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.
  * @param meta 
  */
case class PositionIdentifier(@JsonDeserialize(contentAs = classOf[TradeIdentifierTypeEnum.Value])
    @JsonScalaEnumeration(classOf[TradeIdentifierTypeEnum.Class])
    identifierType: Option[TradeIdentifierTypeEnum.Value],
    issuerReference: Option[ReferenceWithMetaParty],
    issuer: Option[FieldWithMetaString],
    assignedIdentifier: List[AssignedIdentifier],
    meta: Option[MetaFields])
  extends IdentifierTrait {
}

/**
  * This class corresponds to the FpML Premium.model group for representing the option premium when expressed in a way other than an amount.
  *
  * @param premiumType Forward start premium type
  * @param pricePerOption The amount of premium to be paid expressed as a function of the number of options.
  * @param percentageOfNotional The amount of premium to be paid expressed as a percentage of the notional value of the transaction. A percentage of 5% would be expressed as 0.05.
  */
case class PremiumExpression(@JsonDeserialize(contentAs = classOf[PremiumTypeEnum.Value])
    @JsonScalaEnumeration(classOf[PremiumTypeEnum.Class])
    premiumType: Option[PremiumTypeEnum.Value],
    pricePerOption: Option[Money],
    percentageOfNotional: Option[scala.math.BigDecimal]) {
}

case class Pric(pric: Pric,
    bsisPts: String) {
}

/**
  * Specifies a price as a single value to be associated to a financial product. This data type extends PriceSchedule and requires that only the amount value exists.
  *
  * @param perUnitOf Provides an attribute to define the unit of the thing being priced. For example, {amount, unitOfAmount, PerUnitOfAmount} = [10, EUR, Shares] = (10.00 EUR/SHARE) * (300,000 SHARES) = EUR 3,000,000.00 (Shares cancel out in the calculation).
  * @param priceType Specifies the price type as an enumeration: interest rate, exchange rate, asset price etc. This attribute is mandatory so that prices can always be clasiffied according to their type. The price type implies some constraints on the price's units.
  * @param priceExpression (Optionally) Specifies whether the price is expressed in absolute or percentage terms.
  * @param composite (Optionally) Specifies the underlying price components if the price can be expressed as a composite: e.g. dirty price = clean price + accrued.
  * @param arithmeticOperator (Optionally) When the price is to be understood as an operator to apply to an observable, i.e. a spread, multiplier or min/max.
  * @param cashPrice (Optionally when the price type is cash) Additional attributes that further define a cash price, e.g. what type of fee it is.
  * @param datedValue A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
  * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
  * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
  */
case class Price(perUnitOf: Option[UnitType],
    @JsonScalaEnumeration(classOf[PriceTypeEnum.Class])
    priceType: PriceTypeEnum.Value,
    @JsonDeserialize(contentAs = classOf[PriceExpressionEnum.Value])
    @JsonScalaEnumeration(classOf[PriceExpressionEnum.Class])
    priceExpression: Option[PriceExpressionEnum.Value],
    composite: Option[PriceComposite],
    @JsonDeserialize(contentAs = classOf[ArithmeticOperationEnum.Value])
    @JsonScalaEnumeration(classOf[ArithmeticOperationEnum.Class])
    arithmeticOperator: Option[ArithmeticOperationEnum.Value],
    cashPrice: Option[CashPrice],
    datedValue: List[DatedValue],
    value: Option[scala.math.BigDecimal],
    unit: Option[UnitType])
  extends PriceScheduleTrait {
}

/**
  * Defines the inputs required to calculate a price as a simple composite of 2 other values. The inputs consist of 2 numbers and a simple arithmetic operator. This generic data type applies to a variety of use cases where a price is obtained by simple composition, e.g. dirty = clean + accrued (Bond), forward rate = spot rate + forward point (FX) etc.
  *
  * @param baseValue The 1st value in the arithmetic operation, which may be non-commutative in some cases: Subtract, Divide). This 1st operand is called 'baseValue' as it refers to the price anchor in the arithmetic operation: e.g. the clean price (Bond) or the spot rate (FX).
  * @param operand The 2nd value in the arithmetic operation, which may be non-commutative in some cases: Subtract, Divide). The 2nd operand is called 'operand' to distinguish it from the 1st one which is the price anchor.
  * @param arithmeticOperator Specifies the arithmetic operator via an enumeration.
  * @param operandType Optionally qualifies the type of operand: e.g. accrued or forward point.
  */
case class PriceComposite(baseValue: scala.math.BigDecimal,
    operand: scala.math.BigDecimal,
    @JsonScalaEnumeration(classOf[ArithmeticOperationEnum.Class])
    arithmeticOperator: ArithmeticOperationEnum.Value,
    @JsonDeserialize(contentAs = classOf[PriceOperandEnum.Value])
    @JsonScalaEnumeration(classOf[PriceOperandEnum.Class])
    operandType: Option[PriceOperandEnum.Value]) {
}

/**
  * Defines a settlement as an exchange between two parties of a specified quantity of an asset (the quantity) against a specified quantity of another asset (the price). The settlement is optional and can be either cash or physical. The quantity can additionally be specified in terms of one or more currency amounts. In the case of non-cash products, the settlement of the price/quantity would not be specified here and instead would be delegated to the product mechanics, as parameterised by the price/quantity values.
  *
  * @param price Specifies a price to be used for trade amounts and other purposes.
  * @param quantity Specifies a quantity to be associated with an event, for example a trade amount.
  * @param observable Specifies the object to be observed for a price, it could be an asset or an index. The cardinality is optional as some quantity / price cases have no observable (e.g. a fixed rate in a given currency).
  * @param effectiveDate Specifies the date at which the price and quantity become effective. This day may be subject to adjustment in accordance with a business day convention, or could be specified as relative to a trade date, for instance. Optional cardinality, as the effective date is usually specified in the product definition, so it may only need to be specified as part of the PriceQuantity in an increase/decrease scenario for an existing trade.
  * @param meta 
  */
case class PriceQuantity(price: List[FieldWithMetaPriceSchedule],
    quantity: List[FieldWithMetaNonNegativeQuantitySchedule],
    observable: Option[FieldWithMetaObservable],
    effectiveDate: Option[AdjustableOrRelativeDate],
    meta: Option[MetaFields]) {
}

case class PriceReturnTerms(@JsonScalaEnumeration(classOf[ReturnTypeEnum.Class])
    returnType: ReturnTypeEnum.Value,
    conversionFactor: Option[scala.math.BigDecimal],
    performance: Option[String]) {
}

/**
  * Specifies the price of a financial instrument in a trade as a schedule of measures. A price generically expresses the value of an exchange as a ratio: it measures the amount of one thing needed to be exchanged for 1 unit of another thing (e.g. cash in a specific currency in exchange for a bond or share). This generic representation can be used to support any type of financial price beyond just cash price: e.g. an interest rate, a foreign exchange rate, etc. This data type is generically based on a schedule and can also be used to represent a price as a single value.
  *
  * @param perUnitOf Provides an attribute to define the unit of the thing being priced. For example, {amount, unitOfAmount, PerUnitOfAmount} = [10, EUR, Shares] = (10.00 EUR/SHARE) * (300,000 SHARES) = EUR 3,000,000.00 (Shares cancel out in the calculation).
  * @param priceType Specifies the price type as an enumeration: interest rate, exchange rate, asset price etc. This attribute is mandatory so that prices can always be clasiffied according to their type. The price type implies some constraints on the price's units.
  * @param priceExpression (Optionally) Specifies whether the price is expressed in absolute or percentage terms.
  * @param composite (Optionally) Specifies the underlying price components if the price can be expressed as a composite: e.g. dirty price = clean price + accrued.
  * @param arithmeticOperator (Optionally) When the price is to be understood as an operator to apply to an observable, i.e. a spread, multiplier or min/max.
  * @param cashPrice (Optionally when the price type is cash) Additional attributes that further define a cash price, e.g. what type of fee it is.
  * @param datedValue A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
  * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
  * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
  */
case class PriceSchedule(perUnitOf: Option[UnitType],
    @JsonScalaEnumeration(classOf[PriceTypeEnum.Class])
    priceType: PriceTypeEnum.Value,
    @JsonDeserialize(contentAs = classOf[PriceExpressionEnum.Value])
    @JsonScalaEnumeration(classOf[PriceExpressionEnum.Class])
    priceExpression: Option[PriceExpressionEnum.Value],
    composite: Option[PriceComposite],
    @JsonDeserialize(contentAs = classOf[ArithmeticOperationEnum.Value])
    @JsonScalaEnumeration(classOf[ArithmeticOperationEnum.Class])
    arithmeticOperator: Option[ArithmeticOperationEnum.Value],
    cashPrice: Option[CashPrice],
    datedValue: List[DatedValue],
    value: Option[scala.math.BigDecimal],
    unit: Option[UnitType])
  extends PriceScheduleTrait with MeasureScheduleTrait {
}

/**
  * Specifies a publication that provides the commodity price, including, where applicable, the details of where in the publication the price is published.
  *
  * @param pricePublisher Defines a publication in which the price can be found. (e.g Gas Daily, Platts Bloomberg. Commodity publishers can be found at this URL:  http://www.fpml.org/coding-scheme/commodity-information-provider>
  * @param priceSourceLocation Specifies the location of the price which may be a specific page, electornic screen name, or a code (e.g. a RIC code) where the price can be found.
  * @param priceSourceHeading Specifies the heading or field name for the price  on a given page or screen, where applicable.
  * @param priceSourceTime Specifies the time at which the price should be observed.
  */
case class PriceSource(pricePublisher: FieldWithMetaString,
    priceSourceLocation: Option[String],
    priceSourceHeading: Option[String],
    priceSourceTime: Option[java.time.LocalTime]) {
}

/**
  * A data defining:  the parameters used to get a price quote to replace the settlement rate option that is disrupted.
  *
  * @param fallbackReferencePrice The method, prioritised by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
  */
case class PriceSourceDisruption(fallbackReferencePrice: FallbackReferencePrice) {
}

/**
  * Specifies specific dates or parametric rules for the dates on which the price will be determined
  *
  * @param specifiedDates Defines specified dates on which the price will be determined.
  * @param parametricDates Defines rules for the dates on which the price will be determined.
  */
case class PricingDates(specifiedDates: List[AdjustableDates],
    parametricDates: Option[ParametricDates]) {
}

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
case class PrimitiveInstruction(contractFormation: Option[ContractFormationInstruction],
    execution: Option[ExecutionInstruction],
    exercise: Option[ExerciseInstruction],
    partyChange: Option[PartyChangeInstruction],
    quantityChange: Option[QuantityChangeInstruction],
    reset: Option[ResetInstruction],
    split: Option[SplitInstruction],
    termsChange: Option[TermsChangeInstruction],
    transfer: Option[TransferInstruction],
    indexTransition: Option[IndexTransitionInstruction],
    stockSplit: Option[StockSplitInstruction],
    observation: Option[ObservationInstruction],
    valuation: Option[ValuationInstruction]) {
}

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
case class PrincipalPayment(principalPaymentDate: Option[AdjustableDate],
    payerReceiver: Option[PayerReceiver],
    principalAmount: Option[Money],
    discountFactor: Option[scala.math.BigDecimal],
    presentValuePrincipalAmount: Option[Money],
    meta: Option[MetaFields]) {
}

/**
  * Describe dates schedules for Principal Exchanges and related role of the parties when known.
  *
  * @param initialPrincipalPayment Principal Payment made at Trade inception.
  * @param intermediatePrincipalPayment Principal Payment as part of the Trade lifecycle e.g. as part of notional reset adjustements in a Cross Currency Swap with a varying notional leg.
  * @param finalPrincipalPayment Principal Payment at Trade maturity
  */
case class PrincipalPaymentSchedule(initialPrincipalPayment: Option[PrincipalPayment],
    intermediatePrincipalPayment: Option[AdjustableRelativeOrPeriodicDates],
    finalPrincipalPayment: Option[PrincipalPayment]) {
}

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
case class PrincipalPayments(initialPayment: Boolean,
    finalPayment: Boolean,
    intermediatePayment: Boolean,
    varyingLegNotionalCurrency: List[String],
    principalPaymentSchedule: Option[PrincipalPaymentSchedule],
    meta: Option[MetaFields]) {
}

/**
  * Enables either a TransferableProduct or a NonTransferableProduct to be used in an underlier.
  *
  * @param TransferableProduct A TransferableProduct is a type of financial product which can be held or transferred, represented as an Asset with the addition of specific EconomicTerms.
  * @param NonTransferableProduct The non-transferable product data type represents a product that can be traded (as part of a TradableProduct) but cannot be transferred to others.
  */
case class Product(transferableProduct: Option[TransferableProduct],
    nonTransferableProduct: Option[NonTransferableProduct]) {
}

/**
  * Comprises an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the ProductIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
  *
  * @param identifier Provides an identifier associated with a specific product.  The identifier is unique within the public source specified in the source attribute.
  * @param source Defines the source of the identifier.
  * @param meta 
  */
case class ProductIdentifier(identifier: FieldWithMetaString,
    @JsonScalaEnumeration(classOf[ProductIdTypeEnum.Class])
    source: ProductIdTypeEnum.Value,
    meta: Option[MetaFields]) {
}

/**
  * Specifies the product taxonomy, which is composed of a taxonomy value and a taxonomy source.
  *
  * @param primaryAssetClass Classifies the most important risk class of the trade.
  * @param secondaryAssetClass  Classifies additional risk classes of the trade, if any.
  * @param productQualifier Derived from the product payout features using a CDM product qualification function that determines the product type based on the product payout features.
  * @param source The source of the taxonomy that defines the rules for classifying the object. The taxonomy source is taken from a enumerated list of taxonomy names. Optional as the taxonomy source may not be provided.
  * @param value The value according to that taxonomy. Optional as it may not be possible to classify the object in that taxonomy.
  */
case class ProductTaxonomy(primaryAssetClass: Option[FieldWithMetaAssetClassEnum],
    secondaryAssetClass: List[FieldWithMetaAssetClassEnum],
    productQualifier: Option[String],
    @JsonDeserialize(contentAs = classOf[TaxonomySourceEnum.Value])
    @JsonScalaEnumeration(classOf[TaxonomySourceEnum.Class])
    source: Option[TaxonomySourceEnum.Value],
    value: Option[TaxonomyValue])
  extends TaxonomyTrait {
}

/**
  * A class to specify the terms for calculating a payout to protect the buyer of the swap in the case of a qualified credit event. These terms include the applicable credit events, the reference obligation, and in the case of a CDS on mortgage-backed securities, the floatingAmountEvents.
  *
  * @param creditEvents Specifies the applicable Credit Events that would trigger a settlement, as specified in the related Confirmation and defined in the ISDA 2014 Credit Definition article IV section 4.1.
  * @param obligations The underlying obligations of the reference entity on which you are buying or selling protection. The credit events Failure to Pay, Obligation Acceleration, Obligation Default, Restructuring, Repudiation/Moratorium are defined with respect to these obligations.
  * @param floatingAmountEvents This element contains the ISDA terms relating to the floating rate payment events and the implied additional fixed payments, applicable to the credit derivatives transactions on mortgage-backed securities with pay-as-you-go or physical settlement.
  * @param meta 
  */
case class ProtectionTerms(creditEvents: Option[CreditEvents],
    obligations: Option[Obligations],
    floatingAmountEvents: Option[FloatingAmountEvents],
    meta: Option[MetaFields]) {
}

case class Prsn(ctryOfBrnch: String,
    othr: Othr) {
}

case class PubliclyAvailableInformation(standardPublicSources: Option[Boolean],
    publicSource: List[String],
    specifiedNumber: Option[Int]) {
}

case class Qty(unit: String) {
}

/**
  * Specifies a quantity as a single value to be associated to a financial product, for example a transfer amount resulting from a trade. This data type extends QuantitySchedule and requires that only the single amount value exists.
  *
  * @param multiplier Defines an optional number that the quantity should be multiplied by to derive a total quantity. This number is associated to a unit. For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unit would be contracts, the multiplier value would 1,000 and the mulitiplier unit would be 1,000 MT (Metric Tons).
  * @param frequency Defines the frequency to be used when defining a quantity. For example a quantity may be specified as a number of barrels of oil per day, which needs multiplying by the number of days in the relevant period to get the total quantity as a number of barrels.
  * @param datedValue A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
  * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
  * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
  */
case class Quantity(multiplier: Option[Measure],
    frequency: Option[Frequency],
    datedValue: List[DatedValue],
    value: Option[scala.math.BigDecimal],
    unit: Option[UnitType])
  extends QuantityTrait with QuantityScheduleTrait {
}

/**
  * Instructions required to create a Quantity Change Primitive Event, which can be either an increase, a decrease or a replacement. An increase adds a new trade lot to the original trade, whereas a decrease subtracts from an existing trade lot's quantity. A replacement updates the quantity of an existing trade lot to the new value.
  *
  * @param change Quantity by which the trade is being increased, decreased or replaced, and the price at which such quantity change is agreed. The quantity change should always be specified as a positive number, with the direction (increase/decrease/replacement) being specified by the direction enumeration. A fee can also be associated to the quantity change by specifying a Price component of type CashPrice, including the corresponding settlement date and direction.
  * @param direction Direction of the quantity change specified as either an increase, decrease or replacement.
  * @param lotIdentifier Identifier for the new lot (in case of increase) or for the existing lot to be changed(in case of decrease or replacement). This optional attribute is mandatory in case of a decrease or replacement if the initial trade state contains multiple trade lots.
  */
case class QuantityChangeInstruction(change: List[PriceQuantity],
    @JsonScalaEnumeration(classOf[QuantityChangeDirectionEnum.Class])
    direction: QuantityChangeDirectionEnum.Value,
    lotIdentifier: List[Identifier]) {
}

/**
  *  Class to specify a mechanism for a quantity to be set as a multiplier to another (reference) quantity, based on a price observation. At the moment this class only supports FX or Equity-linked notional and re-uses existing building blocks for those 2 cases, until such time when component can be made more generic. This captures the case of resetting cross-currency swaps and resetting equity swaps.
  *
  * @param fxLinkedNotionalSchedule Multiplier specified as an FX-linked schedule, e.g. for a resetting cross-currency swap..
  * @param multiplierValue 
  */
case class QuantityMultiplier(fxLinkedNotionalSchedule: Option[FxLinkedNotionalSchedule],
    multiplierValue: Option[scala.math.BigDecimal]) {
}

/**
  * Specifies a quantity schedule to be associated to a financial product to represent a trade amount. This data type extends MeasureSchedule with several unit or multiplier attributes that are used to define financial quantities. This data type is generically based on a schedule and can also be used to represent a quantity as a single value.
  *
  * @param multiplier Defines an optional number that the quantity should be multiplied by to derive a total quantity. This number is associated to a unit. For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unit would be contracts, the multiplier value would 1,000 and the mulitiplier unit would be 1,000 MT (Metric Tons).
  * @param frequency Defines the frequency to be used when defining a quantity. For example a quantity may be specified as a number of barrels of oil per day, which needs multiplying by the number of days in the relevant period to get the total quantity as a number of barrels.
  * @param datedValue A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
  * @param value Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
  * @param unit Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
  */
case class QuantitySchedule(multiplier: Option[Measure],
    frequency: Option[Frequency],
    datedValue: List[DatedValue],
    value: Option[scala.math.BigDecimal],
    unit: Option[UnitType])
  extends QuantityScheduleTrait with MeasureScheduleTrait {
}

/**
  * Determines the currency rate that the seller of the equity amounts will apply at each valuation date for converting the respective amounts into a currency that is different from the currency denomination of the underlier.
  *
  * @param fxRate Specifies a currency conversion rate.
  * @param fxSpotRateSource Specifies the methodology (reference source and, optionally, fixing time) to be used for determining a currency conversion rate.
  * @param fixingTime The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
  */
case class Quanto(fxRate: List[FxRate],
    fxSpotRateSource: Option[FxSpotRateSource],
    fixingTime: Option[BusinessCenterTime]) {
}

/**
  * Represents a class to allow specification of different types of Quasi Government collateral.
  *
  * @param sovereignEntity True if sovereign entity (e.g. not separate legal personality from sovereign) or false if non-sovereign entity (e.g. separate legal personality from sovereign).
  * @param sovereignRecourse Applies to non-sovereign entity (e.g. separate legal personality from sovereign).  True if entity has recourse to sovereign (e.g. debt guaranteed by government).  False if entity does not have recourse to sovereign.
  */
case class QuasiGovernmentIssuerType(sovereignEntity: Boolean,
    sovereignRecourse: Option[Boolean]) {
}

/**
  * A class that describes the composition of a rate that has been quoted or is to be quoted. This includes the two currencies and the quotation relationship between the two currencies and is used as a building block throughout the FX specification.
  *
  * @param currency1 The first currency specified when a pair of currencies is to be evaluated.
  * @param currency2 The second currency specified when a pair of currencies is to be evaluated.
  * @param quoteBasis The method by which the exchange rate is quoted.
  */
case class QuotedCurrencyPair(currency1: FieldWithMetaString,
    currency2: FieldWithMetaString,
    @JsonScalaEnumeration(classOf[QuoteBasisEnum.Class])
    quoteBasis: QuoteBasisEnum.Value) {
}

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
case class RateObservation(resetDate: Option[java.time.LocalDate],
    adjustedFixingDate: Option[java.time.LocalDate],
    observedRate: Option[scala.math.BigDecimal],
    treatedRate: Option[scala.math.BigDecimal],
    observationWeight: Option[Int],
    rateReference: Option[ReferenceWithMetaRateObservation],
    forecastRate: Option[scala.math.BigDecimal],
    treatedForecastRate: Option[scala.math.BigDecimal],
    meta: Option[MetaFields]) {
}

/**
  * A class defining a schedule of rates or amounts in terms of an initial value and then a series of step date and value pairs. On each step date the rate or amount changes to the new step value. The series of step date and value pairs are optional. If not specified, this implies that the initial value remains unchanged over time.
  *
  * @param price The initial rate. An initial rate of 5% would be represented as 0.05.
  */
case class RateSchedule(price: ReferenceWithMetaPriceSchedule)
  extends RateScheduleTrait {
}

/**
  *  A data type to specify the fixed interest rate, floating interest rate or inflation rate.
  *
  * @param FixedRateSpecification The fixed rate or fixed rate specification expressed as explicit fixed rates and dates.
  * @param FloatingRateSpecification The floating interest rate specification, which includes the definition of the floating rate index. the tenor, the initial value, and, when applicable, the spread, the rounding convention, the averaging method and the negative interest rate treatment.
  * @param InflationRateSpecification An inflation rate calculation definition.
  */
case class RateSpecification(fixedRateSpecification: Option[FixedRateSpecification],
    floatingRateSpecification: Option[FloatingRateSpecification],
    inflationRateSpecification: Option[InflationRateSpecification]) {
}

case class RefRate(indx: String,
    nm: String) {
}

/**
  * A class to describe an institution (party) identified by means of a coding scheme and an optional name.
  *
  * @param referenceBankId An institution (party) identifier, e.g. a bank identifier code (BIC). FpML specifies a referenceBankIdScheme.
  * @param referenceBankName The name of the institution (party). A free format string. FpML does not define usage rules for the element.
  */
case class ReferenceBank(referenceBankId: FieldWithMetaString,
    referenceBankName: Option[String]) {
}

/**
  * A class defining the list of reference institutions polled for relevant rates or prices when determining the cash settlement amount for a product where cash settlement is applicable.
  *
  * @param referenceBank An institution (party) identified by means of a coding scheme and an optional name.
  */
case class ReferenceBanks(referenceBank: List[ReferenceBank]) {
}

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
case class ReferenceInformation(referenceEntity: LegalEntity,
    referenceObligation: List[ReferenceObligation],
    noReferenceObligation: Option[Boolean],
    unknownReferenceObligation: Option[Boolean],
    allGuarantees: Option[Boolean],
    referencePrice: Option[Price],
    referencePolicy: Option[Boolean],
    securedList: Option[Boolean]) {
}

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
case class ReferenceObligation(security: Option[Security],
    loan: Option[Loan],
    primaryObligor: Option[LegalEntity],
    primaryObligorReference: Option[ReferenceWithMetaLegalEntity],
    guarantor: Option[LegalEntity],
    guarantorReference: Option[String],
    standardReferenceObligation: Option[Boolean]) {
}

case class ReferencePair(referenceEntity: LegalEntity,
    referenceObligation: Option[ReferenceObligation],
    noReferenceObligation: Option[Boolean],
    entityType: FieldWithMetaEntityTypeEnum) {
}

/**
  * This type contains all the reference pool items to define the reference entity and reference obligation(s) in the basket.
  *
  * @param referencePoolItem This type contains all the constituent weight and reference information.
  */
case class ReferencePool(referencePoolItem: List[ReferencePoolItem]) {
}

/**
  * This type contains all the constituent weight and reference information.
  *
  * @param constituentWeight Describes the weight of each of the constituents within the basket. If not provided, it is assumed to be equal weighted.
  * @param referencePair 
  * @param protectionTermsReference Reference to the documentation terms applicable to this item.
  * @param cashSettlementTermsReference Reference to the cash settlement terms applicable to this item.
  * @param physicalSettlementTermsReference Reference to the physical settlement terms applicable to this item.
  */
case class ReferencePoolItem(constituentWeight: Option[ConstituentWeight],
    referencePair: ReferencePair,
    protectionTermsReference: Option[ReferenceWithMetaProtectionTerms],
    cashSettlementTermsReference: Option[ReferenceWithMetaCashSettlementTerms],
    physicalSettlementTermsReference: Option[ReferenceWithMetaPhysicalSettlementTerms]) {
}

/**
  * A complex type used to specify the option and convertible bond option strike when expressed in reference to a swap curve.
  *
  * @param swapUnwindValue 
  * @param makeWholeAmount Amount to be paid by the buyer of the option if the option is exercised prior to the Early Call Date. (The market practice in the convertible bond option space being that the buyer should be penalised if he/she exercises the option early on.)
  */
case class ReferenceSwapCurve(swapUnwindValue: SwapCurveValuation,
    makeWholeAmount: Option[MakeWholeAmount]) {
}

/**
  * Represents a class to allow specification of different type of Regional government collateral.
  *
  * @param sovereignRecourse Applies to regional governments, local authorities or municipals.  True if entity has recourse to sovereign (e.g. debt guaranteed by government).  False if entity does not have recourse to sovereign.
  */
case class RegionalGovernmentIssuerType(sovereignRecourse: Boolean) {
}

case class RelatedParty(partyReference: ReferenceWithMetaParty,
    accountReference: Option[ReferenceWithMetaAccount],
    @JsonScalaEnumeration(classOf[PartyRoleEnum.Class])
    role: PartyRoleEnum.Value) {
}

/**
  * A class defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date). If the anchor date is itself an adjustable date then the offset is assumed to be calculated from the adjusted anchor date. A number of different scenarios can be supported, namely; 1) the derived date may simply be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date; 2) the unadjusted derived date may be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date with the resulting unadjusted derived date subject to adjustment in accordance with a specified business day convention, i.e. the derived date must fall on a good business day; 3) the derived date may be a number of business days preceding or following the anchor date. Note that the businessDayConvention specifies any required adjustment to the unadjusted derived date. A negative or positive value in the periodMultiplier indicates whether the unadjusted derived precedes or follows the anchor date. The businessDayConvention should contain a value NONE if the day type element contains a value of Business (since specifying a negative or positive business days offset would already guarantee that the derived date would fall on a good business day in the specified business centers).
  *
  * @param businessDayConvention The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
  * @param businessCenters 
  * @param businessCentersReference A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
  * @param dateRelativeTo Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
  * @param adjustedDate The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
  * @param dayType In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
  * @param periodMultiplier A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
  * @param period A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
  * @param meta 
  */
case class RelativeDateOffset(@JsonScalaEnumeration(classOf[BusinessDayConventionEnum.Class])
    businessDayConvention: BusinessDayConventionEnum.Value,
    businessCenters: Option[BusinessCenters],
    businessCentersReference: Option[ReferenceWithMetaBusinessCenters],
    dateRelativeTo: Option[BasicReferenceWithMetaLocalDate],
    adjustedDate: Option[java.time.LocalDate],
    @JsonDeserialize(contentAs = classOf[DayTypeEnum.Value])
    @JsonScalaEnumeration(classOf[DayTypeEnum.Class])
    dayType: Option[DayTypeEnum.Value],
    periodMultiplier: Int,
    @JsonScalaEnumeration(classOf[PeriodEnum.Class])
    period: PeriodEnum.Value,
    meta: Option[MetaFields])
  extends RelativeDateOffsetTrait with OffsetTrait {
}

/**
  * A class describing a set of dates defined as relative to another set of dates.
  *
  * @param periodSkip The number of periods in the referenced date schedule that are between each date in the relative date schedule. Thus a skip of 2 would mean that dates are relative to every second date in the referenced schedule. If present this should have a value greater than 1.
  * @param scheduleBounds The first and last dates of a schedule. This can be used to restrict the range of values in a reference series of dates.
  * @param businessDayConvention The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
  * @param businessCenters 
  * @param businessCentersReference A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
  * @param dateRelativeTo Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
  * @param adjustedDate The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
  * @param dayType In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
  * @param periodMultiplier A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
  * @param period A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
  * @param meta 
  */
case class RelativeDates(periodSkip: Option[Int],
    scheduleBounds: Option[DateRange],
    @JsonScalaEnumeration(classOf[BusinessDayConventionEnum.Class])
    businessDayConvention: BusinessDayConventionEnum.Value,
    businessCenters: Option[BusinessCenters],
    businessCentersReference: Option[ReferenceWithMetaBusinessCenters],
    dateRelativeTo: Option[BasicReferenceWithMetaLocalDate],
    adjustedDate: Option[java.time.LocalDate],
    @JsonDeserialize(contentAs = classOf[DayTypeEnum.Value])
    @JsonScalaEnumeration(classOf[DayTypeEnum.Class])
    dayType: Option[DayTypeEnum.Value],
    periodMultiplier: Int,
    @JsonScalaEnumeration(classOf[PeriodEnum.Class])
    period: PeriodEnum.Value,
    meta: Option[MetaFields])
  extends RelativeDateOffsetTrait {
}

case class Representations() {
}

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
case class Reset(resetValue: Price,
    resetDate: java.time.LocalDate,
    rateRecordDate: Option[java.time.LocalDate],
    observations: List[ReferenceWithMetaObservation],
    averagingMethodology: Option[AveragingCalculation],
    meta: Option[MetaFields]) {
}

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
case class ResetDates(calculationPeriodDatesReference: Option[ReferenceWithMetaCalculationPeriodDates],
    @JsonDeserialize(contentAs = classOf[ResetRelativeToEnum.Value])
    @JsonScalaEnumeration(classOf[ResetRelativeToEnum.Class])
    resetRelativeTo: Option[ResetRelativeToEnum.Value],
    initialFixingDate: Option[InitialFixingDate],
    fixingDates: Option[RelativeDateOffset],
    finalFixingDate: Option[AdjustableDate],
    rateCutOffDaysOffset: Option[Offset],
    resetFrequency: Option[ResetFrequency],
    resetDatesAdjustments: Option[BusinessDayAdjustments],
    meta: Option[MetaFields]) {
}

/**
  * A class defining the reset frequency. In the case of a weekly reset, also specifies the day of the week that the reset occurs. If the reset frequency is greater than the calculation period frequency the this implies that more or more reset dates is established for each calculation period and some form of rate averaging is applicable. The specific averaging method of calculation is specified in FloatingRateCalculation. In case the reset frequency is of value T (term), the period is defined by the swap/swapStream/calculationPerioDates/effectiveDate and the swap/swapStream/calculationPerioDates/terminationDate.
  *
  * @param weeklyRollConvention The day of the week on which a weekly reset date occurs. This element must be included if the reset frequency is defined as weekly and not otherwise.
  * @param periodMultiplier A time period multiplier, e.g. 1, 2, or 3. If the period value is T (Term) then period multiplier must contain the value 1.
  * @param period A time period, e.g. a day, week, month, year or term of the stream.
  * @param meta 
  */
case class ResetFrequency(@JsonDeserialize(contentAs = classOf[WeeklyRollConventionEnum.Value])
    @JsonScalaEnumeration(classOf[WeeklyRollConventionEnum.Class])
    weeklyRollConvention: Option[WeeklyRollConventionEnum.Value],
    periodMultiplier: Int,
    @JsonScalaEnumeration(classOf[PeriodExtendedEnum.Class])
    period: PeriodExtendedEnum.Value,
    meta: Option[MetaFields])
  extends FrequencyTrait {
}

/**
  * Defines the information needed to create a Reset Business Event. 
  *
  * @param payout 
  * @param rateRecordDate Specifies the 'Rate Record Day' for a Fallback rate.  Fallback rate fixing processes typically set the fixing rate in arrears, i.e., the Fallback Rate corresponding to a Rate Record Date is set at the end of the interest accural period.  When this applies, Reset->resetDate occurs at the end of the interest period, and the Reset->rateRecordDate occurs near the start of the interest period.  The Reset->rateRecordDate and Reset->observations->observationIdentifier->observationDate will differ if a Fallback rate is unavailable on the Rate Record Date, and the latest previous available rate is used as the observation.
  * @param resetDate Specifies the date on which the reset is occuring.
  */
case class ResetInstruction(payout: List[ReferenceWithMetaPayout],
    rateRecordDate: Option[java.time.LocalDate],
    resetDate: java.time.LocalDate) {
}

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
case class ResolvablePriceQuantity(resolvedQuantity: Option[Quantity],
    quantitySchedule: Option[ReferenceWithMetaNonNegativeQuantitySchedule],
    quantityReference: Option[ReferenceWithMetaResolvablePriceQuantity],
    quantityMultiplier: Option[QuantityMultiplier],
    reset: Option[Boolean],
    futureValueNotional: Option[FutureValueAmount],
    priceSchedule: List[ReferenceWithMetaPriceSchedule],
    meta: Option[MetaFields]) {
}

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
case class Resource(resourceId: FieldWithMetaString,
    resourceType: Option[FieldWithMetaResourceTypeEnum],
    language: Option[FieldWithMetaString],
    sizeInBytes: Option[scala.math.BigDecimal],
    length: Option[ResourceLength],
    mimeType: Option[FieldWithMetaString],
    name: Option[String],
    comments: Option[String],
    string: Option[String],
    url: Option[String]) {
}

/**
  * A class to indicate the length of the resource.
  *
  * @param lengthUnit The length unit of the resource. For example, pages (pdf, text documents) or time (audio, video files).
  * @param lengthValue The length value of the resource.
  */
case class ResourceLength(@JsonScalaEnumeration(classOf[LengthUnitEnum.Class])
    lengthUnit: LengthUnitEnum.Value,
    lengthValue: scala.math.BigDecimal) {
}

case class Restructuring(applicable: Boolean,
    restructuringType: Option[FieldWithMetaRestructuringEnum],
    multipleHolderObligation: Option[Boolean],
    multipleCreditEventNotices: Option[Boolean]) {
}

/**
  * A class to specify the application of Interest Amount with respect the Return Amount.
  *
  * @param includesDefaultLanguage Default language is included when True, and excluded when False.
  * @param customElection Custom election that might be specified by the parties to the agreement.
  */
case class ReturnAmount(includesDefaultLanguage: Option[Boolean],
    customElection: Option[String]) {
}

/**
  * Specifies the information required to create the return of a Security Finance Transaction.
  *
  * @param quantity Specifies the quantity of shares and cash to be returned in a partial return event.
  */
case class ReturnInstruction(quantity: List[Quantity]) {
}

/**
  * Specifies the type of return of a performance payout.
  *
  * @param priceReturnTerms Return terms based upon the underlier's observed price.
  * @param dividendReturnTerms Return terms based upon dividend payments associated to the underlier.
  * @param varianceReturnTerms Return terms based upon the observed variance of the underlier's price.
  * @param volatilityReturnTerms Return terms based upon the observed volatility of the underlier's price.
  * @param correlationReturnTerms Return terms based upon the observed correlation between the components of the underlying basket.
  */
case class ReturnTerms(priceReturnTerms: Option[PriceReturnTerms],
    dividendReturnTerms: Option[DividendReturnTerms],
    varianceReturnTerms: Option[VarianceReturnTerms],
    volatilityReturnTerms: Option[VolatilityReturnTerms],
    correlationReturnTerms: Option[CorrelationReturnTerms])
  extends ReturnTermsTrait {
}

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
case class ReturnTermsBase(valuationTerms: ValuationTerms,
    annualizationFactor: Option[Int],
    dividendApplicability: Option[DividendApplicability],
    equityUnderlierProvisions: Option[EquityUnderlierProvisions],
    sharePriceDividendAdjustment: Option[Boolean],
    expectedN: Int,
    initialLevel: Option[scala.math.BigDecimal],
    @JsonDeserialize(contentAs = classOf[DeterminationMethodEnum.Value])
    @JsonScalaEnumeration(classOf[DeterminationMethodEnum.Class])
    initialLevelSource: Option[DeterminationMethodEnum.Value],
    meanAdjustment: Option[Boolean],
    performance: Option[String])
  extends ReturnTermsBaseTrait {
}

/**
  * Used in conjunction with an exchange-based pricing source. Identifies a way in which the futures contracts referenced will roll between periods. 
  *
  * @param rollSourceCalendar Used in conjunction with an exchange-based pricing source. Identifies a date source calendar from which the pricing dates and thus roll to the next contract will be based off (e.g. pricing is based on the NYMEX WTI First Nearby Futures Contract, if Future is chosen, the pricing will roll to the next futures contract on expiration, if ListedOption is chosen, the pricing will roll to the next futures contract on the Option expiration date which is three business days before the expiration of the NYMEX WTI futures contract.) Omitting this element will result in the default behavior expected with the pricing source described within the commodity element.
  * @param deliveryDateRollConvention Specifies, for a Commodity Transaction that references a delivery date for a listed future, the day on which the specified future will roll to the next nearby month prior to the expiration of the referenced future. If the future will not roll at all - i.e. the price will be taken from the expiring contract, 0 should be specified here. If the future will roll to the next nearby on the last trading day - i.e. the price will be taken from the next nearby on the last trading day, then 1 should be specified and so on.
  */
case class RollFeature(@JsonDeserialize(contentAs = classOf[RollSourceCalendarEnum.Value])
    @JsonScalaEnumeration(classOf[RollSourceCalendarEnum.Class])
    rollSourceCalendar: Option[RollSourceCalendarEnum.Value],
    deliveryDateRollConvention: Option[Offset]) {
}

/**
  * Defines rounding rules and precision to be used in the rounding of a number.
  *
  * @param roundingDirection Specifies the rounding rounding rule as up, down, or nearest.
  * @param precision Specifies the rounding precision in terms of a number of decimal places when the number is evaluated in decimal form (not percentage), e.g. 0.09876543 rounded to the nearest 5 decimal places is  0.0987654.
  */
case class Rounding(@JsonScalaEnumeration(classOf[RoundingDirectionEnum.Class])
    roundingDirection: RoundingDirectionEnum.Value,
    precision: Option[Int]) {
}

/**
  * A class defining a schedule of rates or amounts in terms of an initial value and then a series of step date and value pairs. On each step date the rate or amount changes to the new step value. The series of step date and value pairs are optional. If not specified, this implies that the initial value remains unchanged over time.
  *
  * @param value The initial rate or amount, as the case may be. An initial rate of 5% would be represented as 0.05.
  * @param datedValue The schedule of step date and value pairs. On each step date the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
  */
case class Schedule(value: scala.math.BigDecimal,
    datedValue: List[DatedValue])
  extends ScheduleTrait {
}

/**
  * A class that defines the period of a schedule. The period contains a set of start and end dates, quantities, fixing, and pricing data.
  *
  * @param calculationPeriod Period for which the payment is generated.
  * @param paymentDate Adjusted payment date.
  * @param fixingPeriod Period over which the underlying price is observed.
  * @param deliveryPeriod Period and time profile over which the delivery takes place.
  */
case class SchedulePeriod(calculationPeriod: DateRange,
    paymentDate: java.time.LocalDate,
    fixingPeriod: DateRange,
    deliveryPeriod: Option[CalculationScheduleDeliveryPeriods]) {
}

case class ScheduledTransfer(@JsonScalaEnumeration(classOf[ScheduledTransferEnum.Class])
    transferType: ScheduledTransferEnum.Value,
    @JsonDeserialize(contentAs = classOf[CorporateActionTypeEnum.Value])
    @JsonScalaEnumeration(classOf[CorporateActionTypeEnum.Class])
    corporateActionTransferType: Option[CorporateActionTypeEnum.Value]) {
}

case class SchmeNm(prtry: String) {
}

/**
  * Identifies a security by referencing an identifier and by specifying the sector.
  *
  * @param debtType Identifies the type of debt and selected debt economics.
  * @param equityType Identifies the type of equity.
  * @param fundType Identifies the type of fund.
  * @param instrumentType Identifies the type of an instrument using an enumerated list.
  * @param identifier Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
  * @param taxonomy Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
  * @param isExchangeListed Defines whether the Asset is listed on a public exchange.
  * @param exchange If the Asset is listed, defines the public exchange of the listing.
  * @param relatedExchange Provides the related Exchanges, if applicable.
  */
case class Security(debtType: Option[DebtType],
    @JsonDeserialize(contentAs = classOf[EquityTypeEnum.Value])
    @JsonScalaEnumeration(classOf[EquityTypeEnum.Class])
    equityType: Option[EquityTypeEnum.Value],
    @JsonDeserialize(contentAs = classOf[FundProductTypeEnum.Value])
    @JsonScalaEnumeration(classOf[FundProductTypeEnum.Class])
    fundType: Option[FundProductTypeEnum.Value],
    @JsonScalaEnumeration(classOf[InstrumentTypeEnum.Class])
    instrumentType: InstrumentTypeEnum.Value,
    identifier: List[AssetIdentifier],
    taxonomy: List[Taxonomy],
    isExchangeListed: Option[Boolean],
    exchange: Option[LegalEntity],
    relatedExchange: List[LegalEntity])
  extends InstrumentBaseTrait {
}

/**
  * The set of elections which specify a Security Agremeent
  *
  */
case class SecurityAgreementElections() {
}

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
case class SecurityLendingInvoice(sendingParty: Party,
    receivingParty: Party,
    billingStartDate: java.time.LocalDate,
    billingEndDate: java.time.LocalDate,
    billingRecord: List[BillingRecord],
    billingSummary: List[BillingSummary],
    meta: Option[MetaFields]) {
}

/**
  * A locate is an approval from a broker that needs to be obtained prior to effecting a short sale in an equity security. Similar to security availability, a borrower can request a single or multiple securities, but at least one must be requested.
  *
  * @param availableInventoryType Defines the purpose of this inventory.
  * @param messageInformation Allows details related to the availability messaging use case to be defined
  * @param party Defines all parties involved for the list of inventory records in this set of inventory. For example, when used to describe securities lending availability, this could hold the sender of the availability, the intended recipient, the beneficial owner(s), the lender (which may differ from the sender as the lender may have the same piece of availability going through multiple agents), an agent or a venue.
  * @param partyRole Defines the role(s) that party(ies) may have in relation to the inventory.
  * @param availableInventoryRecord An array holding the list of inventory being described. Each element in the inventoryRecord array represents an individual piece of inventory i.e. a security.
  */
case class SecurityLocate(@JsonScalaEnumeration(classOf[AvailableInventoryTypeEnum.Class])
    availableInventoryType: AvailableInventoryTypeEnum.Value,
    messageInformation: Option[MessageInformation],
    party: List[Party],
    partyRole: List[PartyRole],
    availableInventoryRecord: List[AvailableInventoryRecord])
  extends AvailableInventoryTrait {
}

case class Sellr(acctOwnr: AcctOwnr) {
}

/**
  * A class to specify the Relevant Settled Entity Matrix.
  *
  * @param matrixSource Relevant settled entity matrix source.
  * @param publicationDate Specifies the publication date of the applicable version of the matrix. When this element is omitted, the Standard Terms Supplement defines rules for which version of the matrix is applicable.
  */
case class SettledEntityMatrix(matrixSource: FieldWithMetaSettledEntityMatrixSourceEnum,
    publicationDate: Option[java.time.LocalDate]) {
}

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
case class SettlementBase(@JsonScalaEnumeration(classOf[SettlementTypeEnum.Class])
    settlementType: SettlementTypeEnum.Value,
    @JsonDeserialize(contentAs = classOf[TransferSettlementEnum.Value])
    @JsonScalaEnumeration(classOf[TransferSettlementEnum.Class])
    transferSettlementType: Option[TransferSettlementEnum.Value],
    settlementCurrency: Option[FieldWithMetaString],
    settlementDate: Option[SettlementDate],
    @JsonDeserialize(contentAs = classOf[SettlementCentreEnum.Value])
    @JsonScalaEnumeration(classOf[SettlementCentreEnum.Class])
    settlementCentre: Option[SettlementCentreEnum.Value],
    settlementProvision: Option[SettlementProvision],
    @JsonDeserialize(contentAs = classOf[StandardSettlementStyleEnum.Value])
    @JsonScalaEnumeration(classOf[StandardSettlementStyleEnum.Class])
    standardSettlementStyle: Option[StandardSettlementStyleEnum.Value],
    meta: Option[MetaFields])
  extends SettlementBaseTrait {
}

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
case class SettlementDate(adjustableOrRelativeDate: Option[AdjustableOrAdjustedOrRelativeDate],
    valueDate: Option[java.time.LocalDate],
    adjustableDates: Option[AdjustableDates],
    businessDateRange: Option[BusinessDateRange],
    cashSettlementBusinessDays: Option[Int],
    paymentDelay: Option[Boolean],
    meta: Option[MetaFields]) {
}

/**
  * Represents a forward settling payout. The underlier attribute captures the underlying payout, which is settled according to the settlementTerms attribute (which is part of PayoutBase). Both FX Spot and FX Forward should use this component.
  *
  * @param underlier The underlying financial product that will be physically or cash settled, which can be of any type, eg an asset such as cash or a security, or the cash settlement of an index rate.
  * @param deliveryTerm Also called contract month or delivery month. However, it's not always a month. It is usually expressed using a code, e.g. Z23 would be the Dec 2023 contract, (Z = December). For crude oil, the corresponding contract might be called CLZ23.
  * @param delivery Contains the information relative to the delivery of the asset.
  * @param schedule Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
  * @param payerReceiver Canonical representation of the payer and receiver parties applicable to each payout leg.
  * @param priceQuantity Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
  * @param principalPayment The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
  * @param settlementTerms Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
  */
case class SettlementPayout(underlier: Underlier,
    deliveryTerm: Option[String],
    delivery: Option[AssetDeliveryInformation],
    schedule: Option[CalculationSchedule],
    payerReceiver: PayerReceiver,
    priceQuantity: Option[ResolvablePriceQuantity],
    principalPayment: Option[PrincipalPayments],
    settlementTerms: Option[SettlementTerms])
  extends PayoutBaseTrait {
}

/**
  * Defines parameters that regulate a settlement, for instance whether this settlement should be netted with other ones or broken-down into smaller amounts.
  *
  * @param shapingProvisions Defines the parameters that are necessary to 'shape' a settlement, i.e. break it down into smaller amounts.
  */
case class SettlementProvision(shapingProvisions: Option[ShapingProvision]) {
}

/**
  * Defines the settlement rate option to use for fixing in case of cash settlement. Currently only applicable to foreign exchange fixing in case of cross-currency settlement.
  *
  * @param settlementRateOption The rate source for the conversion to the settlement currency. This source is specified through a scheme that reflects the terms of the Annex A to the 1998 FX and Currency Option Definitions.
  * @param priceSourceDisruption An attribute defining the parameters to get a new quote when a settlement rate option is disrupted.
  */
case class SettlementRateOption(settlementRateOption: FieldWithMetaSettlementRateOptionEnum,
    priceSourceDisruption: Option[PriceSourceDisruption]) {
}

/**
  * Specifies the settlement terms, which can either be cash, physical, or fx-based cash-settlement. This class can be used for the settlement of options and forwards, cash transactions (e.g. securities or foreign exchange), or in case of credit event.
  *
  * @param cashSettlementTerms Specifies the parameters associated with the cash settlement procedure.
  * @param physicalSettlementTerms Specifies the physical settlement terms which apply to the transaction.
  * @param settlementType Whether the settlement will be cash, physical, by election, ...
  * @param transferSettlementType The qualification as to how the transfer will settle, e.g. a DvP settlement.
  * @param settlementCurrency The settlement currency is to be specified when the Settlement Amount cannot be known in advance. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
  * @param settlementDate The date on which the settlement amount will be paid, subject to adjustment in accordance with any applicable business day convention. This component would not be present for a mandatory early termination provision where the cash settlement payment date is the mandatory early termination date.
  * @param settlementCentre Optional settlement centre as an enumerated list: Euroclear, Clearstream.
  * @param settlementProvision Optionally defines the parameters that regulate a settlement.
  * @param standardSettlementStyle Settlement Style.
  * @param meta 
  */
case class SettlementTerms(cashSettlementTerms: List[CashSettlementTerms],
    physicalSettlementTerms: Option[PhysicalSettlementTerms],
    @JsonScalaEnumeration(classOf[SettlementTypeEnum.Class])
    settlementType: SettlementTypeEnum.Value,
    @JsonDeserialize(contentAs = classOf[TransferSettlementEnum.Value])
    @JsonScalaEnumeration(classOf[TransferSettlementEnum.Class])
    transferSettlementType: Option[TransferSettlementEnum.Value],
    settlementCurrency: Option[FieldWithMetaString],
    settlementDate: Option[SettlementDate],
    @JsonDeserialize(contentAs = classOf[SettlementCentreEnum.Value])
    @JsonScalaEnumeration(classOf[SettlementCentreEnum.Class])
    settlementCentre: Option[SettlementCentreEnum.Value],
    settlementProvision: Option[SettlementProvision],
    @JsonDeserialize(contentAs = classOf[StandardSettlementStyleEnum.Value])
    @JsonScalaEnumeration(classOf[StandardSettlementStyleEnum.Class])
    standardSettlementStyle: Option[StandardSettlementStyleEnum.Value],
    meta: Option[MetaFields])
  extends SettlementBaseTrait {
}

/**
  * Defines the applicable settlement limits that may require a settlement to be 'shaped', i.e. broken-down into smaller amounts.
  *
  * @param shapeSchedule Defines applicable settlement limits in each currency.
  */
case class ShapingProvision(shapeSchedule: List[Money]) {
}

/**
  * A class to specify the number of business days after satisfaction of all conditions to settlement.
  *
  * @param businessDays A number of business days. Its precise meaning is dependant on the context in which this element is used. ISDA 2003 Term: Business Day.
  */
case class SingleValuationDate(businessDays: Option[Int])
  extends SingleValuationDateTrait {
}

case class Sngl(isin: String,
    indx: Indx) {
}

case class SovereignAgencyRating(sovereignAgencyRating: AgencyRatingCriteria) {
}

/**
  * Represents a class to allow specification of different types of special purpose vehicle (SPV) collateral.
  *
  * @param creditRisk Indicates tranched or untranched credit risk.
  */
case class SpecialPurposeVehicleIssuerType(@JsonDeserialize(contentAs = classOf[CreditRiskEnum.Value])
    @JsonScalaEnumeration(classOf[CreditRiskEnum.Class])
    creditRisk: Option[CreditRiskEnum.Value]) {
}

/**
  * A single, specifically identified Asset chosen from the Asset data type
  *
  * @param Cash An Asset that consists solely of a monetary holding in a currency.
  * @param Commodity An Asset comprised of raw or refined materials or agricultural products, eg gold, oil or wheat.
  * @param DigitalAsset An Asset that exists only in digital form, eg Bitcoin or Ethereum; excludes the digital representation of other Assets.
  * @param Instrument An asset that is issued by one party to one or more others; Instrument is also a choice data type.
  */
case class SpecificAsset(cash: Option[Cash],
    commodity: Option[Commodity],
    digitalAsset: Option[DigitalAsset],
    instrument: Option[Instrument])
  extends AssetTrait {
}

case class SpecifiedCurrency(applicable: Boolean,
    currency: Option[FieldWithMetaString]) {
}

/**
  * Specifies instructions for a split, consisting of a breakdown of instructions to be applied to each branch of the split. This instruction can be used to duplicate a trade, as in a clearing scenario, or to split a trade into smaller quantities (in which case each breakdown instruction needs to include a quantity change), as in an allocation.
  *
  * @param breakdown Each split breakdown specifies the set of primitive instructions to be applied to a single branch of that split. N split breakdowns result in N output trades, which include the original trade. Instructions for how to handle the original trade (e.g. if it must be closed) must be specified in one of the breakdowns.
  */
case class SplitInstruction(breakdown: List[PrimitiveInstruction]) {
}

/**
  * Adds an optional spread type element to the Schedule to identify a long or short spread value.
  *
  * @param spreadScheduleType An element which purpose is to identify a long or short spread value.
  * @param price The initial rate. An initial rate of 5% would be represented as 0.05.
  */
case class SpreadSchedule(spreadScheduleType: Option[FieldWithMetaSpreadScheduleTypeEnum],
    price: ReferenceWithMetaPriceSchedule)
  extends RateScheduleTrait {
}

case class StandardizedSchedule(@JsonScalaEnumeration(classOf[StandardizedScheduleAssetClassEnum.Class])
    assetClass: StandardizedScheduleAssetClassEnum.Value,
    @JsonScalaEnumeration(classOf[StandardizedScheduleProductClassEnum.Class])
    productClass: StandardizedScheduleProductClassEnum.Value,
    notional: scala.math.BigDecimal,
    notionalCurrency: String,
    durationInYears: Option[scala.math.BigDecimal]) {
}

case class StandardizedScheduleInitialMargin(tradeInfo: List[StandardizedScheduleTradeInfo],
    netInitialMargin: Money) {
}

case class StandardizedScheduleTradeInfo(@JsonDeserialize(contentAs = classOf[StandardizedScheduleAssetClassEnum.Value])
    @JsonScalaEnumeration(classOf[StandardizedScheduleAssetClassEnum.Class])
    assetClass: Option[StandardizedScheduleAssetClassEnum.Value],
    @JsonDeserialize(contentAs = classOf[StandardizedScheduleProductClassEnum.Value])
    @JsonScalaEnumeration(classOf[StandardizedScheduleProductClassEnum.Class])
    productClass: Option[StandardizedScheduleProductClassEnum.Value],
    grossInitialMargin: Option[Money],
    markToMarketValue: Option[Money]) {
}

/**
  * Defines the state of a trade at a point in the Trade's life cycle. Trades have many state dimensions, all of which are represented here. For example, states useful for position keeping are represented alongside those needed for regulatory reporting.
  *
  * @param closedState Represents the qualification of what led to the trade's closure alongside the dates on which this closure took effect.
  * @param positionState Identifies the state of the position, to distinguish if just executed, formed, already settled, closed, etc.
  */
case class State(closedState: Option[ClosedState],
    @JsonDeserialize(contentAs = classOf[PositionStatusEnum.Value])
    @JsonScalaEnumeration(classOf[PositionStatusEnum.Class])
    positionState: Option[PositionStatusEnum.Value]) {
}

/**
  * Data required to perform a stock split business event.
  *
  * @param adjustmentRatio The number that denotes the cumulative quantity of post-split shares issued to shareholders versus the quantity of pre-split shares previously issued to shareholders.  This number will be multiplied by existing shares in an equity derivative contract or other positions to determine the post-split number of shares.  With regard to any reference to price, the pre-split reference price will be divided by this number to determine the post-split reference price.
  * @param effectiveDate The effective date of the stock split, also known as the ex-date. This is the date on which the additional shares are paid to the shareholders, or in the case of a reverse stock split, the number shares held by each shareholder is proportionally reduced.  Equity derivative transactions can be amended in firms' internal systems on such date.   In most markets, the listed stock price is reduced (or increased for a reverse stock split) to account for the split on the same date, but in some markets the price adjustment occurs on a later date.  In either case, equity derivative transactions should be amended on the date that the stocks are paid to the shareholders (or consolidated).
  */
case class StockSplitInstruction(adjustmentRatio: scala.math.BigDecimal,
    effectiveDate: java.time.LocalDate) {
}

/**
  * A class for defining option strategy features.
  *
  * @param strikeSpread Definition of the upper strike in a strike spread.
  * @param calendarSpread Definition of the later expiration date in a calendar spread.
  */
case class StrategyFeature(strikeSpread: Option[StrikeSpread],
    calendarSpread: Option[CalendarSpread]) {
}

/**
  * A class describing a single cap or floor rate.
  *
  * @param strikeRate The rate for a cap or floor.
  * @param buyer The buyer of the option.
  * @param seller The party that has sold.
  * @param meta 
  */
case class Strike(strikeRate: scala.math.BigDecimal,
    @JsonDeserialize(contentAs = classOf[PayerReceiverEnum.Value])
    @JsonScalaEnumeration(classOf[PayerReceiverEnum.Class])
    buyer: Option[PayerReceiverEnum.Value],
    @JsonDeserialize(contentAs = classOf[PayerReceiverEnum.Value])
    @JsonScalaEnumeration(classOf[PayerReceiverEnum.Class])
    seller: Option[PayerReceiverEnum.Value],
    meta: Option[MetaFields]) {
}

/**
  * A class describing a schedule of cap or floor rates.
  *
  * @param buyer The buyer of the option.
  * @param seller The party that has sold.
  * @param price The initial rate. An initial rate of 5% would be represented as 0.05.
  */
case class StrikeSchedule(@JsonDeserialize(contentAs = classOf[PayerReceiverEnum.Value])
    @JsonScalaEnumeration(classOf[PayerReceiverEnum.Class])
    buyer: Option[PayerReceiverEnum.Value],
    @JsonDeserialize(contentAs = classOf[PayerReceiverEnum.Value])
    @JsonScalaEnumeration(classOf[PayerReceiverEnum.Class])
    seller: Option[PayerReceiverEnum.Value],
    price: ReferenceWithMetaPriceSchedule)
  extends RateScheduleTrait {
}

/**
  * A class for defining a strike spread feature.
  *
  * @param upperStrike Upper strike in a strike spread.
  * @param upperStrikeNumberOfOptions Number of options at the upper strike price in a strike spread.
  */
case class StrikeSpread(upperStrike: OptionStrike,
    upperStrikeNumberOfOptions: scala.math.BigDecimal) {
}

/**
  * A data defining:  how the initial or final stub calculation period amounts is calculated. For example, the rate to be applied to the initial or final stub calculation period may be the linear interpolation of two different tenors for the floating rate index specified in the calculation period amount component, e.g. A two month stub period may used the linear interpolation of a one month and three month floating rate. The different rate tenors would be specified in this component. Note that a maximum of two rate tenors can be specified. If a stub period uses a single index tenor and this is the same as that specified in the calculation period amount component then the initial stub or final stub component, as the case may be, must not be included.
  *
  * @param calculationPeriodDatesReference A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
  * @param initialStub Specifies how the initial stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
  * @param finalStub Specifies how the final stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
  */
case class StubCalculationPeriodAmount(calculationPeriodDatesReference: ReferenceWithMetaCalculationPeriodDates,
    initialStub: Option[StubValue],
    finalStub: Option[StubValue]) {
}

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
case class StubFloatingRate(@JsonScalaEnumeration(classOf[FloatingRateIndexEnum.Class])
    floatingRateIndex: FloatingRateIndexEnum.Value,
    indexTenor: Option[Period],
    floatingRateMultiplierSchedule: Option[Schedule],
    spreadSchedule: List[SpreadSchedule],
    @JsonDeserialize(contentAs = classOf[RateTreatmentEnum.Value])
    @JsonScalaEnumeration(classOf[RateTreatmentEnum.Class])
    rateTreatment: Option[RateTreatmentEnum.Value],
    capRateSchedule: List[StrikeSchedule],
    floorRateSchedule: List[StrikeSchedule]) {
}

/**
  *  A class defining how the initial or final stub calculation period amounts is calculated. For example, the rate to be applied to the initial or final stub calculation period may be the linear interpolation of two different tenors for the floating rate index specified in the calculation period amount component, e.g. A two month stub period may used the linear interpolation of a one month and three month floating rate. The different rate tenors would be specified in this component. Note that a maximum of two rate tenors can be specified. If a stub period uses a single index tenor and this is the same as that specified in the calculation period amount component then the initial stub or final stub component, as the case may be, must not be included.
  *
  * @param calculationPeriodDatesReference A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
  * @param initialStub Specifies how the initial stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
  * @param finalStub Specifies how the final stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
  */
case class StubPeriod(calculationPeriodDatesReference: ReferenceWithMetaCalculationPeriodDates,
    initialStub: Option[StubValue],
    finalStub: Option[StubValue]) {
}

/**
  * A type defining how a stub calculation period amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating rate tenors many be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3 Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
  *
  * @param floatingRate The rates to be applied to the initial or final stub may be the linear interpolation of two different rates. While the majority of the time, the rate indices will be the same as that specified in the stream and only the tenor itself will be different, it is possible to specift two different rates. For example, a 2 month stub period may use the linear interpolation of a 1 month and 3 month rate. The different rates would be specified in this component. Note that a maximum of two rates can be specified. If a stub period uses the same floating rate index, including tenor, as the regular calculation periods then this should not be specified again within this component, i.e. the stub calculation period amount component may not need to be specified even if there is an initial or final stub period. If a stub period uses a different floating rate index compared to the regular calculation periods then this should be specified within this component. If specified here, they are likely to have id attributes, allowing them to be referenced from within the cashflows component.
  * @param stubRate An actual rate to apply for the initial or final stub period may have been agreed between the principal parties (in a similar way to how an initial rate may have been agreed for the first regular period). If an actual stub rate has been agreed then it would be included in this component. It will be a per annum rate, expressed as a decimal. A stub rate of 5% would be represented as 0.05.
  * @param stubAmount An actual amount to apply for the initial or final stub period may have been agreed between the two parties. If an actual stub amount has been agreed then it would be included in this component.
  */
case class StubValue(floatingRate: List[StubFloatingRate],
    stubRate: Option[scala.math.BigDecimal],
    stubAmount: Option[Money]) {
}

/**
  * Defines collateral substitution provisions such as how many and with how much notice are substitutions allowed.
  *
  * @param numberOfSubstitutionsAllowed Specifies if 1 or more substitutions are allowed.
  * @param noticeDeadlinePeriod Defines the min period for notify of a substitution.
  * @param noticeDeadlineDateTime A specific date and time for the notice deadline
  */
case class SubstitutionProvisions(numberOfSubstitutionsAllowed: Option[Int],
    noticeDeadlinePeriod: Option[Period],
    noticeDeadlineDateTime: Option[java.time.ZonedDateTime]) {
}

/**
  * A class to specify a valuation swap curve, which is used as part of the strike construct for the bond and convertible bond options.
  *
  * @param floatingRateIndex 
  * @param indexTenor The ISDA Designated Maturity, i.e. the tenor of the floating rate.
  * @param spread Spread in basis points over the floating rate index.
  * @param side The side (bid/mid/ask) of the measure.
  */
case class SwapCurveValuation(@JsonScalaEnumeration(classOf[FloatingRateIndexEnum.Class])
    floatingRateIndex: FloatingRateIndexEnum.Value,
    indexTenor: Option[Period],
    spread: scala.math.BigDecimal,
    @JsonDeserialize(contentAs = classOf[QuotationSideEnum.Value])
    @JsonScalaEnumeration(classOf[QuotationSideEnum.Class])
    side: Option[QuotationSideEnum.Value])
  extends SwapCurveValuationTrait {
}

case class Swp(swpIn: SwpIn,
    swpOut: SwpOut) {
}

case class SwpIn(sngl: Sngl) {
}

case class SwpOut(sngl: Sngl) {
}

/**
  * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object).
  *
  * @param source The source of the taxonomy that defines the rules for classifying the object. The taxonomy source is taken from a enumerated list of taxonomy names. Optional as the taxonomy source may not be provided.
  * @param value The value according to that taxonomy. Optional as it may not be possible to classify the object in that taxonomy.
  */
case class Taxonomy(@JsonDeserialize(contentAs = classOf[TaxonomySourceEnum.Value])
    @JsonScalaEnumeration(classOf[TaxonomySourceEnum.Class])
    source: Option[TaxonomySourceEnum.Value],
    value: Option[TaxonomyValue])
  extends TaxonomyTrait {
}

case class TaxonomyClassification(className: Option[String],
    value: String,
    description: Option[String],
    ordinal: Option[Int]) {
}

/**
  * Defines a taxonomy value as either a simple string or a more granular expression with class names and values for each class.
  *
  * @param name Specifies the taxonomy value as a simple string, which may be associated to an external scheme.
  * @param classification Specifies the taxonomy value as a set of class names and values for each class.
  */
case class TaxonomyValue(name: Option[FieldWithMetaString],
    classification: List[TaxonomyClassification]) {
}

/**
  * A class to specify a telephone number as a type of phone number (e.g. work, personal, ...) alongside with the actual number.
  *
  * @param telephoneNumberType The type of telephone number, e.g. work, mobile.
  * @param number The actual telephone number.
  */
case class TelephoneNumber(@JsonDeserialize(contentAs = classOf[TelephoneTypeEnum.Value])
    @JsonScalaEnumeration(classOf[TelephoneTypeEnum.Class])
    telephoneNumberType: Option[TelephoneTypeEnum.Value],
    number: String) {
}

case class Term(unit: String,
    _val: String) {
}

/**
  * A class for defining option provisions.
  *
  * @param cancelableProvision A provision that allows the specification of an embedded option within a swap giving the buyer of the option the right to terminate the swap, in whole or in part, on the early termination date.
  * @param earlyTerminationProvision Parameters specifying provisions relating to the optional and mandatory early termination of a swap transaction.
  * @param evergreenProvision A data defining: the right of a party to exercise an Evergreen option
  * @param extendibleProvision A provision that allows the specification of an embedded option with a swap giving the buyer of the option the right to extend the swap, in whole or in part, to the extended termination date.
  */
case class TerminationProvision(cancelableProvision: Option[CancelableProvision],
    earlyTerminationProvision: Option[EarlyTerminationProvision],
    evergreenProvision: Option[EvergreenProvision],
    extendibleProvision: Option[ExtendibleProvision]) {
}

/**
  * Specifies instructions for terms change consisting of the new transaction terms, and the renegotiation fee.
  *
  * @param product product to be changed
  * @param ancillaryParty ancillary party to be changed
  * @param adjustment 
  */
case class TermsChangeInstruction(product: Option[NonTransferableProduct],
    ancillaryParty: List[AncillaryParty],
    @JsonDeserialize(contentAs = classOf[NotionalAdjustmentEnum.Value])
    @JsonScalaEnumeration(classOf[NotionalAdjustmentEnum.Class])
    adjustment: Option[NotionalAdjustmentEnum.Value]) {
}

/**
  * The time alongside with the timezone location information. This class makes use of the FpML TimezoneLocation construct.
  *
  * @param time The observation time.
  * @param location FpML specifies the timezoneLocationScheme by reference to the Time Zone Database (a.k.a. tz database) maintained by IANA, the Internet Assigned Numbers Authority.
  */
case class TimeZone(time: java.time.LocalTime,
    location: Option[FieldWithMetaString]) {
}

/**
  * Definition of a product as ready to be traded, i.e. included in an execution or contract, by associating a specific price and quantity to this product plus an (optional) mechanism for any potential future quantity adjustment.
  *
  * @param product The underlying product to be included in a contract or execution.
  * @param tradeLot Specifies the price, quantity and effective date of each trade lot, when the same product may be traded multiple times in different lots with the same counterparty. In a trade increase, a new trade lot is added to the list, with the corresponding effective date. In a trade decrease, the existing trade lot(s) are decreased of the corresponding quantity (and an unwind fee may have to be settled). The multiple cardinality and the ability to increase existing trades is used for Equity Swaps in particular.
  * @param counterparty Specifies the parties which are the two counterparties to the transaction.  The product is agnostic to the actual parties to the transaction, with the party references abstracted away from the product definition and replaced by the counterparty enum (e.g. CounterpartyEnum values Party1 or Party2). The counterparty enum can then be positioned in the product (e.g. to specify which counterparty is the payer, receiver etc) and this counterparties attribute, which is positioned outside of the product definition, allows the counterparty enum to be associated with an actual party reference.
  * @param ancillaryParty Specifies the parties with ancillary roles in the transaction. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and this AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
  * @param adjustment Specifies the conditions that govern the adjustment to the quantity of a product being traded: e.g. execution, portfolio rebalancing etc. It is typically used in the context of Equity Swaps.
  */
case class TradableProduct(product: NonTransferableProduct,
    tradeLot: List[TradeLot],
    counterparty: List[Counterparty],
    ancillaryParty: List[AncillaryParty],
    @JsonDeserialize(contentAs = classOf[NotionalAdjustmentEnum.Value])
    @JsonScalaEnumeration(classOf[NotionalAdjustmentEnum.Class])
    adjustment: Option[NotionalAdjustmentEnum.Value])
  extends TradableProductTrait {
}

/**
  * Defines the output of a financial transaction between parties - a Business Event. A Trade impacts the financial position (i.e. the balance sheet) of involved parties.
  *
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
  * @param product The underlying product to be included in a contract or execution.
  * @param tradeLot Specifies the price, quantity and effective date of each trade lot, when the same product may be traded multiple times in different lots with the same counterparty. In a trade increase, a new trade lot is added to the list, with the corresponding effective date. In a trade decrease, the existing trade lot(s) are decreased of the corresponding quantity (and an unwind fee may have to be settled). The multiple cardinality and the ability to increase existing trades is used for Equity Swaps in particular.
  * @param counterparty Specifies the parties which are the two counterparties to the transaction.  The product is agnostic to the actual parties to the transaction, with the party references abstracted away from the product definition and replaced by the counterparty enum (e.g. CounterpartyEnum values Party1 or Party2). The counterparty enum can then be positioned in the product (e.g. to specify which counterparty is the payer, receiver etc) and this counterparties attribute, which is positioned outside of the product definition, allows the counterparty enum to be associated with an actual party reference.
  * @param ancillaryParty Specifies the parties with ancillary roles in the transaction. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and this AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
  * @param adjustment Specifies the conditions that govern the adjustment to the quantity of a product being traded: e.g. execution, portfolio rebalancing etc. It is typically used in the context of Equity Swaps.
  */
case class Trade(tradeIdentifier: List[TradeIdentifier],
    tradeDate: FieldWithMetaLocalDate,
    tradeTime: Option[FieldWithMetaTimeZone],
    party: List[Party],
    partyRole: List[PartyRole],
    executionDetails: Option[ExecutionDetails],
    contractDetails: Option[ContractDetails],
    clearedDate: Option[java.time.LocalDate],
    collateral: Option[Collateral],
    account: List[Account],
    meta: Option[MetaFields],
    product: NonTransferableProduct,
    tradeLot: List[TradeLot],
    counterparty: List[Counterparty],
    ancillaryParty: List[AncillaryParty],
    @JsonDeserialize(contentAs = classOf[NotionalAdjustmentEnum.Value])
    @JsonScalaEnumeration(classOf[NotionalAdjustmentEnum.Class])
    adjustment: Option[NotionalAdjustmentEnum.Value])
  extends TradableProductTrait {
}

/**
  * Defines a trade identifier as a special case of the generic identifier type, that also includes the trade identifier class.
  *
  * @param identifierType The enumerated classification of the identifier. Optional as a trade identifier may be party-specific, in which case it may not correspond to any established classification.
  * @param issuerReference The identifier issuer, when specified by reference to a party specified as part of the transaction.
  * @param issuer The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).
  * @param assignedIdentifier The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.
  * @param meta 
  */
case class TradeIdentifier(@JsonDeserialize(contentAs = classOf[TradeIdentifierTypeEnum.Value])
    @JsonScalaEnumeration(classOf[TradeIdentifierTypeEnum.Class])
    identifierType: Option[TradeIdentifierTypeEnum.Value],
    issuerReference: Option[ReferenceWithMetaParty],
    issuer: Option[FieldWithMetaString],
    assignedIdentifier: List[AssignedIdentifier],
    meta: Option[MetaFields])
  extends IdentifierTrait {
}

/**
  * Specifies the price and quantity of a trade lot, where the same product could be traded multiple times with the same counterparty but in different lots (at a different date, in a different quantity and at a different price). One trade lot combined with a product definition specifies the entire economics of a trade. The lifecycle mechanics of each such trade lot (e.g. cashflow payments) is independent of the other lots.
  *
  * @param lotIdentifier Specifies one or more identifiers for the lot, if any.
  * @param priceQuantity Specifies the settlement characteristics of a trade lot: price, quantity, observable (optionally) and the settlement terms. This attribute has a multiple cardinality to allow to specify the price, quantity and observable of different legs in a single, composite product (e.g. a Swap).
  */
case class TradeLot(lotIdentifier: List[Identifier],
    priceQuantity: List[PriceQuantity]) {
}

/**
  * The attributes that are specific for consensus based pricing reporting.
  *
  * @param trade Represents the cosensus based pricing parameters on a trade basis.
  * @param pricingTime The regional exchange close time for the underlying contract,including time zone, at which the trades should be priced. This provides an indication for which regional snapshot should be used for pricing primarily for Global markets where there are multiple regional close times.
  * @param discountingIndex It specifies the interest payable on collateral delivered under a CSA covering the trade.
  */
case class TradePricingReport(trade: Trade,
    pricingTime: TimeZone,
    @JsonDeserialize(contentAs = classOf[FloatingRateIndexEnum.Value])
    @JsonScalaEnumeration(classOf[FloatingRateIndexEnum.Class])
    discountingIndex: Option[FloatingRateIndexEnum.Value]) {
}

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
case class TradeState(trade: Trade,
    state: Option[State],
    resetHistory: List[Reset],
    transferHistory: List[TransferState],
    observationHistory: List[ObservationEvent],
    valuationHistory: List[Valuation],
    meta: Option[MetaFields]) {
}

/**
  * The class to represent a CDS Tranche.
  *
  * @param attachmentPoint Lower bound percentage of the loss that the Tranche can endure, expressed as a decimal. An attachment point of 5% would be represented as 0.05. The difference between Attachment and Exhaustion points is called the width of the Tranche.
  * @param exhaustionPoint Upper bound percentage of the loss that the Tranche can endure, expressed as a decimal. An exhaustion point of 5% would be represented as 0.05. The difference between Attachment and Exhaustion points is call the width of the Tranche.
  * @param incurredRecoveryApplicable Outstanding Swap Notional Amount is defined at any time on any day, as the greater of: (a) Zero; If Incurred Recovery Amount Applicable: (b) The Original Swap Notional Amount minus the sum of all Incurred Loss Amounts and all Incurred Recovery Amounts (if any) determined under this Confirmation at or prior to such time.Incurred Recovery Amount not populated: (b) The Original Swap Notional Amount minus the sum of all Incurred Loss Amounts determined under this Confirmation at or prior to such time.
  */
case class Tranche(attachmentPoint: scala.math.BigDecimal,
    exhaustionPoint: scala.math.BigDecimal,
    incurredRecoveryApplicable: Option[Boolean]) {
}

/**
  *  A class to represent the transacted price attributes that are positioned as part of the FpML FeeLeg.
  *
  * @param marketFixedRate An optional element that only has meaning in a credit index trade. This element contains the credit spread ('fair value') at which the trade was executed. Unlike the fixedRate of an index, the marketFixedRate varies over the life of the index depending on market conditions. The marketFixedRate is the price of the index as quoted by trading desks.
  * @param initialPoints An optional element that contains the up-front points expressed as a percentage of the notional. An initialPoints value of 5% would be represented as 0.05. The initialPoints element is an alternative to marketFixedRate in quoting the traded level of a trade. When initialPoints is used, the traded level is the sum of fixedRate and initialPoints. The initialPoints is one of the items that are factored into the initialPayment calculation and is payable by the Buyer to the Seller. Note that initialPoints and marketFixedRate may both be present in the same document when both implied values are desired.
  * @param marketPrice An optional element that only has meaning in a credit index trade. This element contains the price at which the trade was executed and is used instead of marketFixedRate on credit trades on certain indicies which are quoted using a price rather than a spread.
  * @param quotationStyle An optional element that contains the up-front points expressed as a percentage of the notional. An initialPoints value of 5% would be represented as 0.05. The initialPoints element is an alternative to marketFixedRate in quoting the traded level of a trade. When initialPoints is used, the traded level is the sum of fixedRate and initialPoints. The initialPoints is one of the items that are factored into the initialPayment calculation and is payable by the Buyer to the Seller. Note that initialPoints and marketFixedRate may both be present in the same document when both implied values are desired.
  */
case class TransactedPrice(marketFixedRate: Option[scala.math.BigDecimal],
    initialPoints: Option[scala.math.BigDecimal],
    marketPrice: Option[scala.math.BigDecimal],
    @JsonDeserialize(contentAs = classOf[QuotationStyleEnum.Value])
    @JsonScalaEnumeration(classOf[QuotationStyleEnum.Class])
    quotationStyle: Option[QuotationStyleEnum.Value]) {
}

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
case class TransactionAdditionalTerms(equityAdditionalTerms: Option[EquityAdditionalTerms],
    foreignExchangeAdditionalTerms: Option[FxAdditionalTerms],
    commoditiesAdditionalTerms: Option[String],
    creditAdditionalTerms: Option[String],
    interestRateAdditionalTerms: Option[String],
    digitalAssetAdditionalTerms: Option[String]) {
}

/**
  * Defines the movement of an Asset (eg cash, securities or commodities) between two parties on a date.
  *
  * @param identifier Represents a unique reference to the transfer.
  * @param payerReceiver Represents the parties to the transfer and their role.
  * @param settlementOrigin Represents the origin to the transfer as a reference for lineage purposes, whether it originated from trade level settlement terms or from payment terms on an economic payout.
  * @param resetOrigin Represents the reset and observation values that were used to determine the transfer amount.
  * @param transferExpression Specifies a transfer expression (cash price, performance amount, scheduled payment amount, etc.) to define the nature of the transfer amount and its source.
  * @param quantity Represents the amount of the asset to be transferred. The cashflow amount is always a positive number, as the cashflow direction is implied by the payer/receiver attribute.
  * @param asset Represents the object that is subject to the transfer, it could be an asset or a reference.
  * @param settlementDate Represents the date on which the transfer to due.
  */
case class Transfer(identifier: List[FieldWithMetaIdentifier],
    payerReceiver: PartyReferencePayerReceiver,
    settlementOrigin: Option[ReferenceWithMetaPayout],
    resetOrigin: Option[Reset],
    transferExpression: TransferExpression,
    quantity: NonNegativeQuantity,
    asset: Asset,
    settlementDate: AdjustableOrAdjustedOrRelativeDate)
  extends AssetFlowBaseTrait {
}

/**
  * Specifies a transfer expression (cash price, performance amount, scheduled payment amount, etc.) to define the nature of the transfer amount and its source.
  *
  * @param priceTransfer Specifies a transfer amount exchanged as a price or fee for entering into a Business Event, e.g. Premium, Termination fee, Novation fee.
  * @param scheduledTransfer Specifies a transfer created from a scheduled or contingent event on a contract, e.g. Exercise, Performance, Credit Event
  */
case class TransferExpression(@JsonDeserialize(contentAs = classOf[FeeTypeEnum.Value])
    @JsonScalaEnumeration(classOf[FeeTypeEnum.Class])
    priceTransfer: Option[FeeTypeEnum.Value],
    scheduledTransfer: Option[ScheduledTransfer]) {
}

/**
  * Defines the payout on which to create a Transfer along with all necessary resets.
  *
  * @param transferState Specifies the terms and state of a transfers.
  */
case class TransferInstruction(transferState: List[TransferState]) {
}

/**
  * Defines the fundamental financial information associated with a Transfer event. Each TransferState specifies where a Transfer is in its life-cycle. TransferState is a root type and as such, can be created independently to any other CDM data type, but can also be used as part of the CDM Event Model.
  *
  * @param transfer Represents the Transfer that has been effected by a business or life-cycle event.
  * @param transferStatus Represents the State of the Transfer through its life-cycle.
  * @param meta 
  */
case class TransferState(transfer: Transfer,
    @JsonDeserialize(contentAs = classOf[TransferStatusEnum.Value])
    @JsonScalaEnumeration(classOf[TransferStatusEnum.Class])
    transferStatus: Option[TransferStatusEnum.Value],
    meta: Option[MetaFields]) {
}

/**
  * A TransferableProduct is a type of financial product which can be held or transferred, represented as an Asset with the addition of specific EconomicTerms.
  *
  * @param economicTerms The price forming features, including payouts and provisions.
  * @param Cash An Asset that consists solely of a monetary holding in a currency.
  * @param Commodity An Asset comprised of raw or refined materials or agricultural products, eg gold, oil or wheat.
  * @param DigitalAsset An Asset that exists only in digital form, eg Bitcoin or Ethereum; excludes the digital representation of other Assets.
  * @param Instrument An asset that is issued by one party to one or more others; Instrument is also a choice data type.
  */
case class TransferableProduct(economicTerms: EconomicTerms,
    cash: Option[Cash],
    commodity: Option[Commodity],
    digitalAsset: Option[DigitalAsset],
    instrument: Option[Instrument])
  extends AssetTrait {
}

/**
  * Trigger point at which feature is effective.
  *
  * @param level The trigger level.
  * @param creditEvents 
  * @param creditEventsReference 
  * @param triggerType The Triggering condition.
  * @param triggerTimeType The valuation time type of knock condition.
  */
case class Trigger(level: List[PriceSchedule],
    creditEvents: Option[CreditEvents],
    creditEventsReference: Option[ReferenceWithMetaCreditEvents],
    @JsonDeserialize(contentAs = classOf[TriggerTypeEnum.Value])
    @JsonScalaEnumeration(classOf[TriggerTypeEnum.Class])
    triggerType: Option[TriggerTypeEnum.Value],
    @JsonDeserialize(contentAs = classOf[TriggerTimeTypeEnum.Value])
    @JsonScalaEnumeration(classOf[TriggerTimeTypeEnum.Class])
    triggerTimeType: Option[TriggerTimeTypeEnum.Value]) {
}

/**
  * Observation point for trigger.
  *
  * @param schedule A derivative schedule.
  * @param triggerDates The trigger Dates.
  * @param trigger The trigger level
  * @param featurePayment The feature payment, i.e. the payment made following trigger occurrence.
  */
case class TriggerEvent(schedule: List[AveragingSchedule],
    triggerDates: Option[DateList],
    trigger: Trigger,
    featurePayment: Option[FeaturePayment]) {
}

case class Tx(newTx: New,
    tradDt: String,
    tradgCpcty: String,
    qty: Qty,
    pric: Pric,
    tradVn: String,
    ctryOfBrnch: String) {
}

/**
  * A class to specify a set of legal entities which are part of a legal agreement beyond the two contracting parties to that agreement. This data representation reflects the ISDA Create representation.
  *
  * @param isApplicable The determination of whether Umbrella Agreement terms are Applicable (True), or Not Applicable (False)
  * @param language The language associated with the umbrella agreement, and which applies to all the parties to the umbrella agreement.
  * @param parties Underlying principals to the umbrella agreement.
  */
case class UmbrellaAgreement(isApplicable: Boolean,
    language: Option[String],
    parties: List[UmbrellaAgreementEntity]) {
}

/**
  * A class to specify the legal entities that are part of the umbrella agreement.
  *
  * @param terms The terms that might be associated with each party to the umbrella agreement.
  * @param entityId A legal entity identifier (e.g. RED entity code).
  * @param name The legal entity name.
  * @param meta 
  */
case class UmbrellaAgreementEntity(terms: Option[String],
    entityId: List[FieldWithMetaString],
    name: FieldWithMetaString,
    meta: Option[MetaFields])
  extends LegalEntityTrait {
}

/**
  * The underlying financial product that will be physically or cash settled, which can be of any type, eg an asset such as cash or a security, a product, or the cash settlement of an index rate.  Conditions are usually applied when used in a data type, such as a payout, to ensure this aligns with the use case.
  *
  * @param Observable Specifies the object to be observed for a price, it could be an asset or a reference.
  * @param Product Enables either a TransferableProduct or a NonTransferableProduct to be used in an underlier.
  */
case class Underlier(observable: Option[ReferenceWithMetaObservable],
    product: Option[Product]) {
}

/**
  * Where parties describe any substitution terms.
  *
  * @param whoMaySubstitute Designates which Counterparty to the transaction who has the right to trigger a substitution or to provide related determination e.g. for instance to qualify the effectiveness of an Event which may be a trigger for substitution, determine the replacement Share to substitute, etc. ; cardinality of this object is 2, in case parties jointly have this role.
  * @param substitutionBeSpokeTerms Where parties describe any substitution terms e.g. for instance the election criteria for an Asset to be eligible as the Substitute Asset to the prior Affected Asset in terms of sector of activity, currency, market capitalisation, liquidity, volatility, or any additional features that parties would agree to take into considerations, etc.
  * @param substitutionTriggerEvents Where the parties may optionnally explictly specify the list of Events to be considered as a trigger for a Substitution.
  * @param disputingParty Where the party who is not granted with the substitution role at least has a right to dispute the determination given by the counterparty with such role. As an example, a given PartyA is the unique Counterparty with the Role of WhoMaySubstitute, yet PartyB could be Disputing Party in regard of such Role.
  */
case class UnderlierSubstitutionProvision(@JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    whoMaySubstitute: List[CounterpartyRoleEnum.Value],
    substitutionBeSpokeTerms: List[Clause],
    substitutionTriggerEvents: List[ExtraordinaryEvents],
    @JsonDeserialize(contentAs = classOf[CounterpartyRoleEnum.Value])
    @JsonScalaEnumeration(classOf[CounterpartyRoleEnum.Class])
    disputingParty: Option[CounterpartyRoleEnum.Value]) {
}

case class UndrlygInstrm(swp: Swp) {
}

/**
  * Defines the unit to be used for price, quantity, or other purposes
  *
  * @param capacityUnit Provides an enumerated value for a capacity unit, generally used in the context of defining quantities for commodities.
  * @param weatherUnit Provides an enumerated values for a weather unit, generally used in the context of defining quantities for commodities.
  * @param financialUnit Provides an enumerated value for financial units, generally used in the context of defining quantities for securities.
  * @param currency Defines the currency to be used as a unit for a price, quantity, or other purpose.
  */
case class UnitType(@JsonDeserialize(contentAs = classOf[CapacityUnitEnum.Value])
    @JsonScalaEnumeration(classOf[CapacityUnitEnum.Class])
    capacityUnit: Option[CapacityUnitEnum.Value],
    @JsonDeserialize(contentAs = classOf[WeatherUnitEnum.Value])
    @JsonScalaEnumeration(classOf[WeatherUnitEnum.Class])
    weatherUnit: Option[WeatherUnitEnum.Value],
    @JsonDeserialize(contentAs = classOf[FinancialUnitEnum.Value])
    @JsonScalaEnumeration(classOf[FinancialUnitEnum.Class])
    financialUnit: Option[FinancialUnitEnum.Value],
    currency: Option[FieldWithMetaString]) {
}

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
case class Valuation(amount: Money,
    timestamp: java.time.ZonedDateTime,
    @JsonDeserialize(contentAs = classOf[ValuationTypeEnum.Value])
    @JsonScalaEnumeration(classOf[ValuationTypeEnum.Class])
    method: Option[ValuationTypeEnum.Value],
    @JsonDeserialize(contentAs = classOf[ValuationSourceEnum.Value])
    @JsonScalaEnumeration(classOf[ValuationSourceEnum.Class])
    source: Option[ValuationSourceEnum.Value],
    delta: Option[scala.math.BigDecimal],
    @JsonDeserialize(contentAs = classOf[PriceTimingEnum.Value])
    @JsonScalaEnumeration(classOf[PriceTimingEnum.Class])
    valuationTiming: Option[PriceTimingEnum.Value],
    priceComponent: Option[Price]) {
}

/**
  * A single object that represents the different methods to specify a valuation date, as used for cash settlement. The Single / Multiple ValuationDate is used for the determination of recovery in a credit event, the RelativeDateOffset is used for cash-settled option, and FxFixingDate is used for cross-currency settlement.
  *
  * @param singleValuationDate Where single valuation date is specified as being applicable for cash settlement, this element specifies the number of business days after satisfaction of all conditions to settlement when such valuation date occurs. ISDA 2003 Term: Single Valuation Date.
  * @param multipleValuationDates Where multiple valuation dates are specified as being applicable for cash settlement, this element specifies (a) the number of applicable valuation dates, and (b) the number of business days after satisfaction of all conditions to settlement when the first such valuation date occurs, and (c) the number of business days thereafter of each successive valuation date. ISDA 2003 Term: Multiple Valuation Dates.
  * @param valuationDate The date on which the cash settlement amount will be determined according to the cash settlement method if the parties have not otherwise been able to agree the cash settlement amount. This attribute was formerly part of 'OptionCashSettlement', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
  * @param fxFixingDate The date on which the currency rate will be determined for the purpose of specifying the amount in deliverable currency. This attribute was formerly part of 'NonDeliverableSettlement', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
  * @param fxFixingSchedule The date, when expressed as a schedule of date(s), on which the currency rate will be determined for the purpose of specifying the amount in deliverable currency. This attribute was formerly part of 'NonDeliverableSettlement', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
  */
case class ValuationDate(singleValuationDate: Option[SingleValuationDate],
    multipleValuationDates: Option[MultipleValuationDates],
    valuationDate: Option[RelativeDateOffset],
    fxFixingDate: Option[FxFixingDate],
    fxFixingSchedule: Option[AdjustableDates]) {
}

/**
  * Defines how and when a performance type option or performance type swap is to be valued, including initial, interim and final valuation dates.
  *
  * @param initialValuationDate Specifies the initial valuation dates of the underlyer.
  * @param interimValuationDate Specifies the interim valuation dates of the underlyer.
  * @param finalValuationDate Specifies the final valuation dates of the underlyer.
  */
case class ValuationDates(initialValuationDate: Option[PerformanceValuationDates],
    interimValuationDate: Option[PerformanceValuationDates],
    finalValuationDate: PerformanceValuationDates) {
}

/**
  * Specifies inputs needed to process a valuation.
  *
  * @param valuation Contains all information related to a valuation.
  * @param replace Specifies whether the previous valuation tracks in the valuation history are removed (True) or kept (False).
  */
case class ValuationInstruction(valuation: List[Valuation],
    replace: Boolean) {
}

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
case class ValuationMethod(valuationSource: ValuationSource,
    @JsonDeserialize(contentAs = classOf[QuotationRateTypeEnum.Value])
    @JsonScalaEnumeration(classOf[QuotationRateTypeEnum.Class])
    quotationMethod: Option[QuotationRateTypeEnum.Value],
    @JsonDeserialize(contentAs = classOf[ValuationMethodEnum.Value])
    @JsonScalaEnumeration(classOf[ValuationMethodEnum.Class])
    valuationMethod: Option[ValuationMethodEnum.Value],
    quotationAmount: Option[Money],
    minimumQuotationAmount: Option[Money],
    cashCollateralValuationMethod: Option[CashCollateralValuationMethod]) {
}

/**
  * Specifies how long to wait to get a quote from a settlement rate option upon a price source disruption.
  *
  * @param maximumDaysOfPostponement The maximum number of days to wait for a quote from the disrupted settlement rate option before proceeding to the next method.
  */
case class ValuationPostponement(maximumDaysOfPostponement: Int) {
}

/**
  * A class describing the method for obtaining a settlement rate, specified through either an information source (page), a settlement rate option (fixing) or by using quotes from reference banks.
  *
  * @param quotedCurrencyPair Defines the two currencies for an FX trade and the quotation relationship between the two currencies.  This attribute was formerly part of 'fxSettlementTerms', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
  * @param informationSource The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
  * @param settlementRateOption The rate option to use for the fixing. Currently only applicable to foreign exchange fixing in case of cross-currency settlement.
  * @param referenceBanks A container for a set of reference institutions that may be called upon to provide rate quotations as part of the method to determine the applicable cash settlement amount. If institutions are not specified, it is assumed that reference institutions will be agreed between the parties on the exercise date, or in the case of swap transaction to which mandatory early termination is applicable, the cash settlement valuation date.
  * @param dealerOrCCP Holds an identifier for the reference entity that is agreed by both parties as a basis for cash settlement calculations. This could be a dealer from whom quotations are obtained by the calculation agent on the reference obligation for purposes of cash settlement in a credit event. ISDA 2003 Term: Dealer. This could be the clearing organization (CCP, DCO) to which the trade should be cleared, as applicable for cash-settled swaptions.
  */
case class ValuationSource(quotedCurrencyPair: Option[ReferenceWithMetaQuotedCurrencyPair],
    informationSource: Option[FxSpotRateSource],
    settlementRateOption: Option[SettlementRateOption],
    referenceBanks: Option[ReferenceBanks],
    dealerOrCCP: Option[AncillaryEntity]) {
}

case class ValuationTerms(futuresPriceValuation: Option[Boolean],
    optionsPriceValuation: Option[Boolean],
    numberOfValuationDates: Option[Int],
    dividendValuationDates: Option[AdjustableRelativeOrPeriodicDates],
    @JsonDeserialize(contentAs = classOf[FPVFinalPriceElectionFallbackEnum.Value])
    @JsonScalaEnumeration(classOf[FPVFinalPriceElectionFallbackEnum.Class])
    fPVFinalPriceElectionFallback: Option[FPVFinalPriceElectionFallbackEnum.Value],
    multipleExchangeIndexAnnexFallback: Option[Boolean],
    componentSecurityIndexAnnexFallback: Option[Boolean]) {
}

case class VarianceCapFloor(varianceCap: Boolean,
    unadjustedVarianceCap: Option[scala.math.BigDecimal],
    boundedVariance: Option[BoundedVariance]) {
}

case class VarianceReturnTerms(varianceStrikePrice: Option[Price],
    volatilityStrikePrice: Option[Price],
    varianceCapFloor: Option[VarianceCapFloor],
    volatilityCapFloor: Option[VolatilityCapFloor],
    vegaNotionalAmount: Option[NonNegativeQuantitySchedule],
    exchangeTradedContractNearest: Option[ReferenceWithMetaObservable],
    valuationTerms: ValuationTerms,
    annualizationFactor: Option[Int],
    dividendApplicability: Option[DividendApplicability],
    equityUnderlierProvisions: Option[EquityUnderlierProvisions],
    sharePriceDividendAdjustment: Option[Boolean],
    expectedN: Int,
    initialLevel: Option[scala.math.BigDecimal],
    @JsonDeserialize(contentAs = classOf[DeterminationMethodEnum.Value])
    @JsonScalaEnumeration(classOf[DeterminationMethodEnum.Class])
    initialLevelSource: Option[DeterminationMethodEnum.Value],
    meanAdjustment: Option[Boolean],
    performance: Option[String])
  extends ReturnTermsBaseTrait {
}

case class Velocity(periodMultiplier: Option[Int],
    @JsonDeserialize(contentAs = classOf[PeriodTimeEnum.Value])
    @JsonScalaEnumeration(classOf[PeriodTimeEnum.Class])
    period: Option[PeriodTimeEnum.Value]) {
}

/**
  * Contains volatility-based barriers. Volatility Cap needs to be specified in accordance with the ISDA 2011 Equity Derivatives Definitions.
  *
  * @param applicable Indicates whether the volatility cap is applicable in accordance with the ISDA 2011 Equity Derivatives Definitions. Setting the element 'applicable' to 'False' - means No Volatility Cap and no 'totalVolatilityCap' or 'volatilityCapFactor' should be provided. Setting the element 'applicable' to 'True' - means Volatility Cap election, then 'totalVolatilityCap' or 'volatilityCapFactor' should be provided, otherwise it defaults to volatilityCapFactor=2.5.
  * @param totalVolatilityCap Volatility Cap Amount in accordance with the ISDA 2011 Equity Derivatives Definitions. This means the Volatility Cap Amount election is a number.
  * @param volatilityCapFactor Volatility Cap Amount in accordance with the ISDA 2011 Equity Derivatives Definitions. The Calculated VolCapAmt can be optionally provided.
  */
case class VolatilityCapFloor(applicable: Boolean,
    totalVolatilityCap: Option[scala.math.BigDecimal],
    volatilityCapFactor: Option[scala.math.BigDecimal]) {
}

case class VolatilityReturnTerms(volatilityStrikePrice: Price,
    volatilityCapFloor: Option[VolatilityCapFloor],
    exchangeTradedContractNearest: Option[ListedDerivative],
    valuationTerms: ValuationTerms,
    annualizationFactor: Option[Int],
    dividendApplicability: Option[DividendApplicability],
    equityUnderlierProvisions: Option[EquityUnderlierProvisions],
    sharePriceDividendAdjustment: Option[Boolean],
    expectedN: Int,
    initialLevel: Option[scala.math.BigDecimal],
    @JsonDeserialize(contentAs = classOf[DeterminationMethodEnum.Value])
    @JsonScalaEnumeration(classOf[DeterminationMethodEnum.Class])
    initialLevelSource: Option[DeterminationMethodEnum.Value],
    meanAdjustment: Option[Boolean],
    performance: Option[String])
  extends ReturnTermsBaseTrait {
}

/**
  * A single weighted averaging observation.
  *
  * @param dateTime Observation date time, which should be used when literal observation dates are required. The CDM specifies that the zoned date time is to be expressed in accordance with ISO 8601, either as UTC as an offset to UTC.
  * @param observationNumber Observation number, which should be unique, within a series generated by a date schedule.
  * @param weight Observation weight, which is used as a multiplier for the observation value.
  */
case class WeightedAveragingObservation(dateTime: Option[java.time.ZonedDateTime],
    observationNumber: Option[Int],
    weight: scala.math.BigDecimal) {
}

/**
  * A collection of workflow steps which together makeup an entire workflow sequence.
  *
  * @param steps 
  */
case class Workflow(steps: List[WorkflowStep]) {
}

/**
  * A class to specify workflow information, which is conceptually applicable to all lifecycle events.
  *
  * @param workflowStatus The workflow status indicator, e.g. Accepted, Rejected, ...
  * @param comment A comment field to be associated with the workflow, e.g. to specify why a transaction event was rejected by a party.
  * @param partyCustomisedWorkflow Workflow data that is specific to certain market participants and is expressed as part of the CDM in a very generic manner, which can be party-specific. The initial use cases have been derived from the CME clearing and the DTCC TIW submissions.
  * @param warehouseIdentity The identity of the warehouse, if any, that is executing that workflow step.
  */
case class WorkflowState(@JsonScalaEnumeration(classOf[WorkflowStatusEnum.Class])
    workflowStatus: WorkflowStatusEnum.Value,
    comment: Option[String],
    partyCustomisedWorkflow: List[PartyCustomisedWorkflow],
    @JsonDeserialize(contentAs = classOf[WarehouseIdentityEnum.Value])
    @JsonScalaEnumeration(classOf[WarehouseIdentityEnum.Class])
    warehouseIdentity: Option[WarehouseIdentityEnum.Value]) {
}

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
case class WorkflowStep(businessEvent: Option[BusinessEvent],
    counterpartyPositionBusinessEvent: Option[CounterpartyPositionBusinessEvent],
    proposedEvent: Option[EventInstruction],
    rejected: Option[Boolean],
    approval: List[WorkflowStepApproval],
    previousWorkflowStep: Option[ReferenceWithMetaWorkflowStep],
    nextEvent: Option[EventInstruction],
    messageInformation: Option[MessageInformation],
    timestamp: List[EventTimestamp],
    eventIdentifier: List[Identifier],
    @JsonDeserialize(contentAs = classOf[ActionEnum.Value])
    @JsonScalaEnumeration(classOf[ActionEnum.Class])
    action: Option[ActionEnum.Value],
    party: List[Party],
    account: List[Account],
    lineage: Option[Lineage],
    creditLimitInformation: Option[CreditLimitInformation],
    workflowState: Option[WorkflowState],
    meta: Option[MetaFields]) {
}

/**
  * Party approvals associated to the current WorkflowStep. 
  *
  * @param approved Flag denoting whether the workflow step is approved or not
  * @param party Reference to the Party who is approving/rejecting this workflow step
  * @param rejectedReason Optional reason for rejecting the workflow step
  * @param timestamp Timestamp of the approval
  * @param meta 
  */
case class WorkflowStepApproval(approved: Boolean,
    party: ReferenceWithMetaParty,
    rejectedReason: Option[String],
    timestamp: EventTimestamp,
    meta: Option[MetaFields]) {
}

