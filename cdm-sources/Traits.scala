/**
  * This file is auto-generated from the ISDA Common Domain Model, do not edit.
  * Version: 6.0.0
  */
package org.isda.cdm

import org.isda.cdm.metafields._

/**
  * An Asset is defined as something that can be owned and transferred in the financial markets. As a choice data type, one and only one of the attributes must be used.
  */
trait AssetTrait {
  /**
    * An Asset that consists solely of a monetary holding in a currency.
    */
  val cash: Option[Cash]
  /**
    * An Asset comprised of raw or refined materials or agricultural products, eg gold, oil or wheat.
    */
  val commodity: Option[Commodity]
  /**
    * An Asset that exists only in digital form, eg Bitcoin or Ethereum; excludes the digital representation of other Assets.
    */
  val digitalAsset: Option[DigitalAsset]
  /**
    * An asset that is issued by one party to one or more others; Instrument is also a choice data type.
    */
  val instrument: Option[Instrument]
}

/**
  * The base data type to specify common attributes for all Assets.
  */
trait AssetBaseTrait {
  /**
    * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
    */
  val identifier: List[AssetIdentifier]
  /**
    * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
    */
  val taxonomy: List[Taxonomy]
  /**
    * Defines whether the Asset is listed on a public exchange.
    */
  val isExchangeListed: Option[Boolean]
  /**
    * If the Asset is listed, defines the public exchange of the listing.
    */
  val exchange: Option[LegalEntity]
  /**
    * Provides the related Exchanges, if applicable.
    */
  val relatedExchange: List[LegalEntity]
}

/**
  * Defines the periods of delivery, including the delivery profile.
  */
trait AssetDeliveryPeriodsTrait {
  /**
    * Defines the delivery profile of the asset, including the load type and the delivery intervals.
    */
  val profile: List[AssetDeliveryProfile]
  /**
    * Delivery start date
    */
  val startDate: Option[java.time.LocalDate]
  /**
    * Delivery end date
    */
  val endDate: Option[java.time.LocalDate]
}

/**
  * Defines the basic parameters of an asset transfer, e.g. a cashflow: what (the asset), how much (the quantity) and when (the settlement date).
  */
trait AssetFlowBaseTrait {
  /**
    * Represents the amount of the asset to be transferred. The cashflow amount is always a positive number, as the cashflow direction is implied by the payer/receiver attribute.
    */
  val quantity: NonNegativeQuantity
  /**
    * Represents the object that is subject to the transfer, it could be an asset or a reference.
    */
  val asset: Asset
  /**
    * Represents the date on which the transfer to due.
    */
  val settlementDate: AdjustableOrAdjustedOrRelativeDate
}

/**
  * A data type that can be used to describe the inventory of securities that a party holds. The securities are held in the AvailableInventoryRecord, with each item in the array being an individual security and its associated criteria. Criteria can include the quantity available, the rate at which the security is available to borrow at, as well as other details that can affect the decision as to whether a party wants to utilise the securities listed.
  */
trait AvailableInventoryTrait {
  /**
    * Defines the purpose of this inventory.
    */
  val availableInventoryType: AvailableInventoryTypeEnum.Value
  /**
    * Allows details related to the availability messaging use case to be defined
    */
  val messageInformation: Option[MessageInformation]
  /**
    * Defines all parties involved for the list of inventory records in this set of inventory. For example, when used to describe securities lending availability, this could hold the sender of the availability, the intended recipient, the beneficial owner(s), the lender (which may differ from the sender as the lender may have the same piece of availability going through multiple agents), an agent or a venue.
    */
  val party: List[Party]
  /**
    * Defines the role(s) that party(ies) may have in relation to the inventory.
    */
  val partyRole: List[PartyRole]
  /**
    * An array holding the list of inventory being described. Each element in the inventoryRecord array represents an individual piece of inventory i.e. a security.
    */
  val availableInventoryRecord: List[AvailableInventoryRecord]
}

/**
  * This class corresponds to the FpML BuyerSeller.model construct.
  */
trait BuyerSellerTrait {
  /**
    * Buyer party that can be resolved as one of the two principal parties to the transaction. The party that buys this instrument, i.e. pays for this instrument and receives the rights defined by it. ISDA 2002 Equity Definitions section 1.18: `Buyer` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (b)(i) relating to a Swaption: 'Buyer' means the party that will, on each Premium Payment Date, pay to Seller the Premium | ISDA 2006 Definitions article 12.1 (b)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such in the related Confirmation, or the Exercising Party if neither party is specified | ISDA 2006 Definitions article 12.1 (b)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Buyer` means the Fixed Rate Payer.
    */
  val buyer: CounterpartyRoleEnum.Value
  /**
    * Seller party that can be resolved as one of the two principal parties to the transaction. The party that sells ('writes') this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. ISDA 2002 Equity Definitions section 1.19: `Seller` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (a)(i) relating to a Swaption: 'Seller' means the party the party specified as such or as writer in the related Confirmation | ISDA 2006 Definitions article 12.1 (a)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such or as writer in the related Confirmation or, if neither party is specified as such, the Non-exercising Party | ISDA 2006 Definitions article 12.1 (a)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Seller` means the Floating Rate Payer.
    */
  val seller: CounterpartyRoleEnum.Value
}

/**
  * The calculation period adjusted start and end dates, which are the baseline arguments needed to compute an interest accrual calculation.
  */
trait CalculationPeriodBaseTrait {
  /**
    * The calculation period start date, adjusted according to any relevant business day convention.
    */
  val adjustedStartDate: Option[java.time.LocalDate]
  /**
    * The calculation period end date, adjusted according to any relevant business day convention.
    */
  val adjustedEndDate: Option[java.time.LocalDate]
  val meta: Option[MetaFields]
}

/**
  * Represents a set of criteria used to specify and describe collateral.
  */
trait CollateralCriteriaBaseTrait {
  /**
    * The specific criteria that applies. It can be created using AND, OR and NOT logic, and both asset and issuer characteristics.
    */
  val collateralCriteria: CollateralCriteria
  /**
    * Specifies which of the two counterparties the criteria applies to (either one or both counterparties). This attribute is optional, in case the applicable party is already specified elsewhere within a party election.
    */
  val appliesTo: List[CounterpartyRoleEnum.Value]
  /**
    * Restrict the criteria to only apply to a specific type of margin, ie IM or VM.
    */
  val restrictTo: Option[CollateralMarginTypeEnum.Value]
  /**
    * Denotes which Criteria has priority if more than one agency rating applies.
    */
  val ratingPriorityResolution: Option[RatingPriorityResolutionEnum.Value]
}

/**
  * Encapsulates data features common to trade and position.
  */
trait ContractBaseTrait {
  /**
    * Represents information specific to trades or positions involving contractual products.
    */
  val contractDetails: Option[ReferenceWithMetaContractDetails]
  /**
    * Defines specific attributes that relate to trade or position executions.
    */
  val executionDetails: Option[ReferenceWithMetaExecutionDetails]
  /**
    * Represents the collateral obligations of a party.
    */
  val collateral: Option[ReferenceWithMetaCollateral]
}

/**
  * A class defining a contiguous series of calendar dates. The date range is defined as all the dates between and including the start and the end date. The start date must fall on or before the end date.
  */
trait DateRangeTrait {
  /**
    * The first date of a date range.
    */
  val startDate: java.time.LocalDate
  /**
    * The last date of a date range.
    */
  val endDate: java.time.LocalDate
}

/**
  * Specification for General Terms and Elections of an Equity Master Confirmation that is applicable across multiple Equity confirmations and is referenced by each of these confirmations, an example of which being the 2018 ISDA CDM Equity Confirmation for Security Equity Swap.
  */
trait EquityMasterConfirmationTrait extends MasterConfirmationBaseTrait {
}

/**
  * Specifies instructions to create a BusinessEvent.
  */
trait EventInstructionTrait {
  /**
    * The intent attribute is meant to be specified when the event qualification cannot be programmatically inferred from the event features. As a result it is only associated with those primitives that can give way to such ambiguity, the quantityChange being one of those. An example of such is a reduction in the trade notional, which could be interpreted as either a trade correction (unless a maximum period of time post-event is specified as part of the qualification), a partial termination or a portfolio rebalancing in the case of an equity swap. On the other hand, an event such as the exercise is not expected to have an associated intent as there should not be ambiguity.
    */
  val intent: Option[EventIntentEnum.Value]
  val corporateActionIntent: Option[CorporateActionTypeEnum.Value]
  /**
    * Specifies the date on which the event is taking place. This date is equal to the trade date in the case of a simple execution.  However it can be different from the trade date, for example in the case of a partial termination.
    */
  val eventDate: Option[java.time.LocalDate]
  /**
    * The date on which the event contractually takes effect, when different from the event date.
    */
  val effectiveDate: Option[java.time.LocalDate]
  /**
    * Specifies the package information in case the business event represents several trades executed as a package (hence this attribute is optional). The package information is only instantiated once at the business event level to preserve referential integrity, whereas individual trades make reference to it to identify that they are part of a package.
    */
  val packageInformation: Option[IdentifiedList]
  /**
    * Specifies the instructions to create the Business Event.
    */
  val instruction: List[Instruction]
}

trait FloatingRateTrait extends FloatingRateBaseTrait {
  /**
    * A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
    */
  val floatingRateMultiplierSchedule: Option[RateSchedule]
  /**
    * The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
    */
  val rateTreatment: Option[RateTreatmentEnum.Value]
  /**
    * Support for modular calculated rates, such such as lockout compound calculations.
    */
  val calculationParameters: Option[FloatingRateCalculationParameters]
  /**
    * Definition of any fallback rate that may be applicable.
    */
  val fallbackRate: Option[FallbackRateParameters]
}

/**
  * A class defining a floating interest rate through the specification of the floating rate index, the tenor, the multiplier schedule, the spread, the qualification of whether a specific rate treatment and/or a cap or floor apply.
  */
trait FloatingRateBaseTrait {
  val rateOption: Option[ReferenceWithMetaInterestRateIndex]
  /**
    * The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
    */
  val spreadSchedule: Option[SpreadSchedule]
  /**
    * The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
    */
  val capRateSchedule: Option[StrikeSchedule]
  /**
    * The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
    */
  val floorRateSchedule: Option[StrikeSchedule]
  val meta: Option[MetaFields]
}

/**
  * A class to specify the floating interest rate by extending the floating rate definition with a set of attributes that specify such rate: the initial value specified as part of the trade, the rounding convention, the averaging method and the negative interest rate treatment.
  */
trait FloatingRateSpecificationTrait extends FloatingRateTrait {
  /**
    * The initial floating rate reset agreed between the principal parties involved in the trade. This is assumed to be the first required reset rate for the first regular calculation period. It should only be included when the rate is not equal to the rate published on the source implied by the floating rate index. An initial rate of 5% would be represented as 0.05.
    */
  val initialRate: Option[Price]
  /**
    * The rounding convention to apply to the final rate used in determination of a calculation period amount.
    */
  val finalRateRounding: Option[Rounding]
  /**
    * If averaging is applicable, this component specifies whether a weighted or unweighted average method of calculation is to be used. The component must only be included when averaging applies.
    */
  val averagingMethod: Option[AveragingWeightingMethodEnum.Value]
  /**
    * The specification of any provisions for calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
    */
  val negativeInterestRateTreatment: Option[NegativeInterestRateTreatmentEnum.Value]
}

/**
  * A class for defining a date frequency, e.g. one day, three months, through the combination of an integer value and a standardized period value that is specified as part of an enumeration.
  */
trait FrequencyTrait {
  /**
    * A time period multiplier, e.g. 1, 2, or 3. If the period value is T (Term) then period multiplier must contain the value 1.
    */
  val periodMultiplier: Int
  /**
    * A time period, e.g. a day, week, month, year or term of the stream.
    */
  val period: PeriodExtendedEnum.Value
  val meta: Option[MetaFields]
}

/**
  * A class to specify a generic identifier, applicable to CDM artefacts such as executions, contracts, lifecycle events and legal documents. An issuer can be associated with the actual identifier value as a way to properly qualify it.
  */
trait IdentifierTrait {
  /**
    * The identifier issuer, when specified by reference to a party specified as part of the transaction.
    */
  val issuerReference: Option[ReferenceWithMetaParty]
  /**
    * The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).
    */
  val issuer: Option[FieldWithMetaString]
  /**
    * The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.
    */
  val assignedIdentifier: List[AssignedIdentifier]
  val meta: Option[MetaFields]
}

/**
  * Identifies an index by referencing an identifier.
  */
trait IndexBaseTrait extends AssetBaseTrait {
  /**
    * A description of the Index.
    */
  val name: Option[FieldWithMetaString]
  /**
    * The organisation that creates or maintains the Index.
    */
  val provider: Option[LegalEntity]
  /**
    * The Asset Class of the Index.
    */
  val assetClass: Option[AssetClassEnum.Value]
}

/**
  * A class defining the source for a piece of information (e.g. a rate fix or an FX fixing). The attribute names have been adjusted from FpML to address the fact that the information is not limited to rates.
  */
trait InformationSourceTrait {
  /**
    * An information source for obtaining a market data point. For example Bloomberg, Reuters, Telerate, etc.
    */
  val sourceProvider: FieldWithMetaInformationProviderEnum
  /**
    * A specific page for the source for obtaining a market data point. In FpML, this is specified as a scheme, rateSourcePageScheme, for which no coding Scheme or URI is specified.
    */
  val sourcePage: Option[FieldWithMetaString]
  /**
    * The heading for the source on a given source page.
    */
  val sourcePageHeading: Option[String]
}

/**
  * Defines the common attributes for all Instrument data types.
  */
trait InstrumentBaseTrait extends AssetBaseTrait {
  /**
    * Identifies the type of an instrument using an enumerated list.
    */
  val instrumentType: InstrumentTypeEnum.Value
}

/**
  * An individual piece of inventory. This represents a single security.
  */
trait InventoryRecordTrait {
  /**
    * Unique identifier for this record. This can be used to uniquely identify a specific piece of inventory.
    */
  val identifer: AssignedIdentifier
  /**
    * The security details.
    */
  val security: Security
}

/**
  * Specifies the legal agreement baseline information, being negotiated or having been executed. It excludes specialized elections
  */
trait LegalAgreementBaseTrait {
  /**
    * The date on which the legal agreement has been agreed between the parties. This corresponds to the Date of Deed in an English Law document.
    */
  val agreementDate: Option[java.time.LocalDate]
  /**
    * The date on which, or as of which, the agreement is effective, if different from the agreement date. It is expected that it will most often correspond to the agreement date, although there could be situations where the parties will explicitly agree on a distinct effective date.
    */
  val effectiveDate: Option[java.time.LocalDate]
  /**
    * The legal agreement identifier. Several identifiers can be specified.
    */
  val identifier: List[Identifier]
  /**
    * The type of legal agreement, identified via a set of composable attributes: agreementName, publisher, governing law and version, e.g. ISDA 2013 Standard Credit Support Annex English Law.
    */
  val legalAgreementIdentification: LegalAgreementIdentification
  /**
    * The two contractual parties to the legal agreement, which reference information is positioned as part of the partyInformation attribute.
    */
  val contractualParty: List[ReferenceWithMetaParty]
  /**
    * The role(s) that other party(ies) may have in relation to the legal agreement, further to the contractual parties.
    */
  val otherParty: List[PartyRole]
  /**
    * A human readable document, for example a confirmation.
    */
  val attachment: List[Resource]
}

/**
  * A class to specify a legal entity, with a required name and an optional entity identifier (such as the LEI).
  */
trait LegalEntityTrait {
  /**
    * A legal entity identifier (e.g. RED entity code).
    */
  val entityId: List[FieldWithMetaString]
  /**
    * The legal entity name.
    */
  val name: FieldWithMetaString
  val meta: Option[MetaFields]
}

trait LimitApplicableTrait {
  /**
    * Standard code to indicate which type of credit line is being referred to - i.e. IM, DV01, PV01, CS01, Notional, Clip Size, Notional, maximumOrderQuantity.
    */
  val limitType: Option[FieldWithMetaCreditLimitTypeEnum]
  /**
    * This element is required in FpML, optional in CDM for the purpose of accommodating the CME data representation while making reference to the FpML one.
    */
  val clipSize: Option[Int]
  /**
    * The limit utilised by all the cleared trades for the limit level and limit type. While the attribute is of type integer in FpML and the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
    */
  val amountUtilized: Option[scala.math.BigDecimal]
  val utilization: Option[CreditLimitUtilisation]
  /**
    * The limit remaining for the limit level and limit type. This does not take into account any pending trades. While the attribute is of type integer in FpML and the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
    */
  val amountRemaining: Option[scala.math.BigDecimal]
  /**
    * The currency in which the applicable limit is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
    */
  val currency: Option[FieldWithMetaString]
  val velocity: Option[Velocity]
}

/**
  * Represents common attributes required for Issuance and Response to a Margin Call action as a result of a demand for delivery or return of collateral determined under a legal agreement such as a credit support document or equivalent.
  */
trait MarginCallBaseTrait {
  /**
    * Identifies the enumeration values to specify the call notification type, direction, specific action type.
    */
  val instructionType: MarginCallInstructionType
  /**
    * Represents the parties to the margin call. The cardinality is optional to address the case where both parties of the event are specified and a third party if applicable.
    */
  val party: List[Party]
  /**
    * Represents the role each specified party takes in the margin call. further to the principal roles, payer and receiver.
    */
  val partyRole: List[PartyRole]
  /**
    * Indicates the name of the Clearing Broker FCM/DCM.
    */
  val clearingBroker: Option[Party]
  /**
    * Represents a unique Identifier for a margin call message, that can be referenced throughout all points of the process.
    */
  val callIdentifier: Option[Identifier]
  /**
    * Specifies the legal agreement type the margin call is generated from and governed by.
    */
  val callAgreementType: AgreementName
  /**
    * Specifies the collateral legal agreement minimum transfer amount in base currency.
    */
  val agreementMinimumTransferAmount: Option[Money]
  /**
    * Specifies the collateral legal agreement threshold amount in base currency.
    */
  val agreementThreshold: Option[Money]
  /**
    * Specifies the collateral legal agreement rounding in base currency.
    */
  val agreementRounding: Option[Money]
  /**
    * Identifies margin type and if related regulatory mandate
    */
  val regMarginType: RegMarginTypeEnum.Value
  /**
    * Indicates the role of the party in an regulatory initial margin call instruction (i.e Pledgor party or Secured party).
    */
  val regIMRole: Option[RegIMRoleEnum.Value]
  /**
    * Represents the current mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency), to be referenced in a margin call.
    */
  val baseCurrencyExposure: Option[MarginCallExposure]
  /**
    * Represents attributes to define the details of collateral assets within a collateral portfolio to be used in margin call messaging and contribute to collateral balances e.g securities in a collateral account recorded by the principal as held or posted.
    */
  val collateralPortfolio: Option[ReferenceWithMetaCollateralPortfolio]
  /**
    * Represents additional credit support amount over and above mark to market value.
    */
  val independentAmountBalance: Option[CollateralBalance]
}

/**
  * Legal agreement specification for General Terms and Elections that are applicable across multiple confirmations and are referenced by these confirmations.
  */
trait MasterConfirmationBaseTrait {
}

/**
  * Provides an abstract type to define a measure as a number associated to a unit. This type is abstract because all its attributes are optional. The types that extend it can specify further existence constraints.
  */
trait MeasureBaseTrait {
  /**
    * Specifies the value of the measure as a number. Optional because in a measure vector or schedule, this single value may be omitted.
    */
  val value: Option[scala.math.BigDecimal]
  /**
    * Qualifies the unit by which the amount is measured. Optional because a measure may be unit-less (e.g. when representing a ratio between amounts in the same unit).
    */
  val unit: Option[UnitType]
}

/**
  * A set of measures, all in the same unit, where the values are defined through a schedule of steps. The initial value may be defined either as part of the steps, or using the single amount attribute.
  */
trait MeasureScheduleTrait extends MeasureBaseTrait {
  /**
    * A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
    */
  val datedValue: List[DatedValue]
}

/**
  * Specifies the object to be observed for a price, it could be an asset or a reference.
  */
trait ObservableTrait {
  /**
    * The object to be observed is an Asset, ie something that can be owned and transferred in the financial markets.
    */
  val asset: Option[Asset]
  /**
    * The object to be observed is a Basket, ie a collection of Observables with an identifier and optional weightings.
    */
  val basket: Option[Basket]
  /**
    * The object to be observed is an Index, ie an observable computed on the prices, rates or valuations of a number of assets.
    */
  val index: Option[Index]
}

/**
  * A class defining an offset used in calculating a new date relative to a reference date, e.g. calendar days, business days, commodity Business days, etc.
  */
trait OffsetTrait extends PeriodTrait {
  /**
    * In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
    */
  val dayType: Option[DayTypeEnum.Value]
}

/**
  * A class to specify the Partial Cash Deliverable Obligation Characteristic.
  */
trait PCDeliverableObligationCharacTrait {
  /**
    * Indicates whether the provision is applicable.
    */
  val applicable: Boolean
  /**
    * Specifies whether either 'Partial Cash Settlement of Assignable Loans', 'Partial Cash Settlement of Consent Required Loans' or 'Partial Cash Settlement of Participations' is applicable. If this element is specified and Assignable Loan is a Deliverable Obligation Characteristic, any Assignable Loan that is deliverable, but where a non-receipt of Consent by the Physical Settlement Date has occurred, the Loan can be cash settled rather than physically delivered. If this element is specified and Consent Required Loan is a Deliverable Obligation Characteristic, any Consent Required Loan that is deliverable, but where a non-receipt of Consent by the Physical Settlement Date has occurred, the Loan can be cash settled rather than physically delivered. If this element is specified and Direct Loan Participation is a Deliverable Obligation Characteristic, any Participation that is deliverable, but where this participation has not been effected (has not come into effect) by the Physical Settlement Date, the participation can be cash settled rather than physically delivered.
    */
  val partialCashSettlement: Option[Boolean]
}

/**
  * A class defining partial exercise. As defined in the 2000 ISDA Definitions, Section 12.3 Partial Exercise, the buyer of the option may exercise all or less than all the notional amount of the underlying swap but may not be less than the minimum notional amount (if specified) and must be an integral multiple of the integral multiple amount if specified.
  */
trait PartialExerciseTrait {
  /**
    * A pointer style reference to the associated notional schedule defined elsewhere in the document. This element has been made optional as part of its integration in the OptionBaseExtended, because not required for the options on securities.
    */
  val notionaReference: ReferenceWithMetaMoney
  /**
    * A notional amount which restricts the amount of notional that can be exercised when partial exercise or multiple exercise is applicable. The integral multiple amount defines a lower limit of notional that can be exercised and also defines a unit multiple of notional that can be exercised, i.e. only integer multiples of this amount can be exercised.
    */
  val integralMultipleAmount: Option[scala.math.BigDecimal]
  /**
    * The minimum notional amount that can be exercised on a given exercise date. See multipleExercise.
    */
  val minimumNotionalAmount: Option[scala.math.BigDecimal]
  /**
    * The minimum number of options that can be exercised on a given exercise date.
    */
  val minimumNumberOfOptions: Option[Int]
}

/**
  * Specifies the parties responsible for making and receiving payments defined by this structure.
  */
trait PartyReferencePayerReceiverTrait {
  /**
    * The party responsible for making the payments defined by this structure.
    */
  val payerPartyReference: ReferenceWithMetaParty
  /**
    * A reference to the account responsible for making the payments defined by this structure.
    */
  val payerAccountReference: Option[ReferenceWithMetaAccount]
  /**
    * The party that receives the payments corresponding to this structure.
    */
  val receiverPartyReference: ReferenceWithMetaParty
  /**
    * A reference to the account that receives the payments corresponding to this structure.
    */
  val receiverAccountReference: Option[ReferenceWithMetaAccount]
}

/**
  * Specifies the parties responsible for making and receiving payments defined by this structure.
  */
trait PayerReceiverTrait {
  /**
    * Specifies the counterparty responsible for making the payments defined by this structure.  The party is one of the two principal parties to the transaction.
    */
  val payer: CounterpartyRoleEnum.Value
  /**
    * Specifies the party that receives the payments corresponding to this structure.  The party is one of the two counterparties to the transaction.
    */
  val receiver: CounterpartyRoleEnum.Value
}

/**
  * A data type that contains the common attributes (e.g. payer and receiver parties) and validation conditions that apply across all payout types
  */
trait PayoutBaseTrait {
  /**
    * Canonical representation of the payer and receiver parties applicable to each payout leg.
    */
  val payerReceiver: PayerReceiver
  /**
    * Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
    */
  val priceQuantity: Option[ResolvablePriceQuantity]
  /**
    * The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
    */
  val principalPayment: Option[PrincipalPayments]
  /**
    * Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
    */
  val settlementTerms: Option[SettlementTerms]
}

/**
  * A class to define recurring periods or time offsets.
  */
trait PeriodTrait {
  /**
    * A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
    */
  val periodMultiplier: Int
  /**
    * A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
    */
  val period: PeriodEnum.Value
  val meta: Option[MetaFields]
}

/**
  * A Position describes how much of a given Product is being held and constitutes the atomic element of a Portfolio.
  */
trait PositionTrait {
  /**
    * Position with many price quantities.
    */
  val priceQuantity: List[PriceQuantity]
  /**
    * The product underlying the position.
    */
  val product: Product
  /**
    * The aggregate cost of proceeds
    */
  val cashBalance: Option[Money]
  /**
    * Reference to the Contract, in case product is contractual and the contract has been formed
    */
  val tradeReference: Option[ReferenceWithMetaTradeState]
}

/**
  * Specifies the price of a financial instrument in a trade as a schedule of measures. A price generically expresses the value of an exchange as a ratio: it measures the amount of one thing needed to be exchanged for 1 unit of another thing (e.g. cash in a specific currency in exchange for a bond or share). This generic representation can be used to support any type of financial price beyond just cash price: e.g. an interest rate, a foreign exchange rate, etc. This data type is generically based on a schedule and can also be used to represent a price as a single value.
  */
trait PriceScheduleTrait extends MeasureScheduleTrait {
  /**
    * Provides an attribute to define the unit of the thing being priced. For example, {amount, unitOfAmount, PerUnitOfAmount} = [10, EUR, Shares] = (10.00 EUR/SHARE) * (300,000 SHARES) = EUR 3,000,000.00 (Shares cancel out in the calculation).
    */
  val perUnitOf: Option[UnitType]
  /**
    * Specifies the price type as an enumeration: interest rate, exchange rate, asset price etc. This attribute is mandatory so that prices can always be clasiffied according to their type. The price type implies some constraints on the price's units.
    */
  val priceType: PriceTypeEnum.Value
  /**
    * (Optionally) Specifies whether the price is expressed in absolute or percentage terms.
    */
  val priceExpression: Option[PriceExpressionEnum.Value]
  /**
    * (Optionally) Specifies the underlying price components if the price can be expressed as a composite: e.g. dirty price = clean price + accrued.
    */
  val composite: Option[PriceComposite]
  /**
    * (Optionally) When the price is to be understood as an operator to apply to an observable, i.e. a spread, multiplier or min/max.
    */
  val arithmeticOperator: Option[ArithmeticOperationEnum.Value]
  /**
    * (Optionally when the price type is cash) Additional attributes that further define a cash price, e.g. what type of fee it is.
    */
  val cashPrice: Option[CashPrice]
}

/**
  * Specifies a quantity as a single value to be associated to a financial product, for example a transfer amount resulting from a trade. This data type extends QuantitySchedule and requires that only the single amount value exists.
  */
trait QuantityTrait extends QuantityScheduleTrait {
}

/**
  * Specifies a quantity schedule to be associated to a financial product to represent a trade amount. This data type extends MeasureSchedule with several unit or multiplier attributes that are used to define financial quantities. This data type is generically based on a schedule and can also be used to represent a quantity as a single value.
  */
trait QuantityScheduleTrait extends MeasureScheduleTrait {
  /**
    * Defines an optional number that the quantity should be multiplied by to derive a total quantity. This number is associated to a unit. For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unit would be contracts, the multiplier value would 1,000 and the mulitiplier unit would be 1,000 MT (Metric Tons).
    */
  val multiplier: Option[Measure]
  /**
    * Defines the frequency to be used when defining a quantity. For example a quantity may be specified as a number of barrels of oil per day, which needs multiplying by the number of days in the relevant period to get the total quantity as a number of barrels.
    */
  val frequency: Option[Frequency]
}

/**
  * A class defining a schedule of rates or amounts in terms of an initial value and then a series of step date and value pairs. On each step date the rate or amount changes to the new step value. The series of step date and value pairs are optional. If not specified, this implies that the initial value remains unchanged over time.
  */
trait RateScheduleTrait {
  /**
    * The initial rate. An initial rate of 5% would be represented as 0.05.
    */
  val price: ReferenceWithMetaPriceSchedule
}

/**
  * A class defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date). If the anchor date is itself an adjustable date then the offset is assumed to be calculated from the adjusted anchor date. A number of different scenarios can be supported, namely; 1) the derived date may simply be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date; 2) the unadjusted derived date may be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date with the resulting unadjusted derived date subject to adjustment in accordance with a specified business day convention, i.e. the derived date must fall on a good business day; 3) the derived date may be a number of business days preceding or following the anchor date. Note that the businessDayConvention specifies any required adjustment to the unadjusted derived date. A negative or positive value in the periodMultiplier indicates whether the unadjusted derived precedes or follows the anchor date. The businessDayConvention should contain a value NONE if the day type element contains a value of Business (since specifying a negative or positive business days offset would already guarantee that the derived date would fall on a good business day in the specified business centers).
  */
trait RelativeDateOffsetTrait extends OffsetTrait {
  /**
    * The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
    */
  val businessDayConvention: BusinessDayConventionEnum.Value
  val businessCenters: Option[BusinessCenters]
  /**
    * A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
    */
  val businessCentersReference: Option[ReferenceWithMetaBusinessCenters]
  /**
    * Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
    */
  val dateRelativeTo: Option[BasicReferenceWithMetaLocalDate]
  /**
    * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
    */
  val adjustedDate: Option[java.time.LocalDate]
}

/**
  * Specifies the type of return of a performance payout.
  */
trait ReturnTermsTrait {
  /**
    * Return terms based upon the underlier's observed price.
    */
  val priceReturnTerms: Option[PriceReturnTerms]
  /**
    * Return terms based upon dividend payments associated to the underlier.
    */
  val dividendReturnTerms: Option[DividendReturnTerms]
  /**
    * Return terms based upon the observed variance of the underlier's price.
    */
  val varianceReturnTerms: Option[VarianceReturnTerms]
  /**
    * Return terms based upon the observed volatility of the underlier's price.
    */
  val volatilityReturnTerms: Option[VolatilityReturnTerms]
  /**
    * Return terms based upon the observed correlation between the components of the underlying basket.
    */
  val correlationReturnTerms: Option[CorrelationReturnTerms]
}

/**
  * Contains all common elements in variance, volatility and correlation return Terms.
  */
trait ReturnTermsBaseTrait {
  /**
    * Contains all non-date valuation information.
    */
  val valuationTerms: ValuationTerms
  /**
    * This specifies the numerator of an annualization factor. Frequently this number is equal to the number of observations of prices in a year e.g. 252.
    */
  val annualizationFactor: Option[Int]
  /**
    * The parameters which define whether dividends are applicable
    */
  val dividendApplicability: Option[DividendApplicability]
  /**
    * Contains Equity Underlyer provisions regarding jurisdiction and fallbacks.
    */
  val equityUnderlierProvisions: Option[EquityUnderlierProvisions]
  /**
    * Indicates whether the price of shares is adjusted for dividends or not.
    */
  val sharePriceDividendAdjustment: Option[Boolean]
  /**
    * Expected number of trading days.
    */
  val expectedN: Int
  /**
    * Contract will strike off this initial level. Providing just the initialLevel without initialLevelSource, infers that this is AgreedInitialPrice - a specified Initial Index Level.
    */
  val initialLevel: Option[scala.math.BigDecimal]
  /**
    * In this context, this is AgreedInitialPrice - a specified Initial Index Level.
    */
  val initialLevelSource: Option[DeterminationMethodEnum.Value]
  /**
    * Specifies whether Mean Adjustment is applicable or not in the calculation of the Realized Volatility, Variance or Correlation
    */
  val meanAdjustment: Option[Boolean]
  /**
    * Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.
    */
  val performance: Option[String]
}

/**
  * A class defining a schedule of rates or amounts in terms of an initial value and then a series of step date and value pairs. On each step date the rate or amount changes to the new step value. The series of step date and value pairs are optional. If not specified, this implies that the initial value remains unchanged over time.
  */
trait ScheduleTrait {
  /**
    * The initial rate or amount, as the case may be. An initial rate of 5% would be represented as 0.05.
    */
  val value: scala.math.BigDecimal
  /**
    * The schedule of step date and value pairs. On each step date the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
    */
  val datedValue: List[DatedValue]
}

/**
  * A base class to be extended by the SettlementTerms class.
  */
trait SettlementBaseTrait {
  /**
    * Whether the settlement will be cash, physical, by election, ...
    */
  val settlementType: SettlementTypeEnum.Value
  /**
    * The qualification as to how the transfer will settle, e.g. a DvP settlement.
    */
  val transferSettlementType: Option[TransferSettlementEnum.Value]
  /**
    * The settlement currency is to be specified when the Settlement Amount cannot be known in advance. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
    */
  val settlementCurrency: Option[FieldWithMetaString]
  /**
    * The date on which the settlement amount will be paid, subject to adjustment in accordance with any applicable business day convention. This component would not be present for a mandatory early termination provision where the cash settlement payment date is the mandatory early termination date.
    */
  val settlementDate: Option[SettlementDate]
  /**
    * Optional settlement centre as an enumerated list: Euroclear, Clearstream.
    */
  val settlementCentre: Option[SettlementCentreEnum.Value]
  /**
    * Optionally defines the parameters that regulate a settlement.
    */
  val settlementProvision: Option[SettlementProvision]
  /**
    * Settlement Style.
    */
  val standardSettlementStyle: Option[StandardSettlementStyleEnum.Value]
  val meta: Option[MetaFields]
}

/**
  * A class to specify the number of business days after satisfaction of all conditions to settlement.
  */
trait SingleValuationDateTrait {
  /**
    * A number of business days. Its precise meaning is dependant on the context in which this element is used. ISDA 2003 Term: Business Day.
    */
  val businessDays: Option[Int]
}

/**
  * A class to specify a valuation swap curve, which is used as part of the strike construct for the bond and convertible bond options.
  */
trait SwapCurveValuationTrait {
  val floatingRateIndex: FloatingRateIndexEnum.Value
  /**
    * The ISDA Designated Maturity, i.e. the tenor of the floating rate.
    */
  val indexTenor: Option[Period]
  /**
    * Spread in basis points over the floating rate index.
    */
  val spread: scala.math.BigDecimal
  /**
    * The side (bid/mid/ask) of the measure.
    */
  val side: Option[QuotationSideEnum.Value]
}

/**
  * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object).
  */
trait TaxonomyTrait {
  /**
    * The source of the taxonomy that defines the rules for classifying the object. The taxonomy source is taken from a enumerated list of taxonomy names. Optional as the taxonomy source may not be provided.
    */
  val source: Option[TaxonomySourceEnum.Value]
  /**
    * The value according to that taxonomy. Optional as it may not be possible to classify the object in that taxonomy.
    */
  val value: Option[TaxonomyValue]
}

/**
  * Definition of a product as ready to be traded, i.e. included in an execution or contract, by associating a specific price and quantity to this product plus an (optional) mechanism for any potential future quantity adjustment.
  */
trait TradableProductTrait {
  /**
    * The underlying product to be included in a contract or execution.
    */
  val product: NonTransferableProduct
  /**
    * Specifies the price, quantity and effective date of each trade lot, when the same product may be traded multiple times in different lots with the same counterparty. In a trade increase, a new trade lot is added to the list, with the corresponding effective date. In a trade decrease, the existing trade lot(s) are decreased of the corresponding quantity (and an unwind fee may have to be settled). The multiple cardinality and the ability to increase existing trades is used for Equity Swaps in particular.
    */
  val tradeLot: List[TradeLot]
  /**
    * Specifies the parties which are the two counterparties to the transaction.  The product is agnostic to the actual parties to the transaction, with the party references abstracted away from the product definition and replaced by the counterparty enum (e.g. CounterpartyEnum values Party1 or Party2). The counterparty enum can then be positioned in the product (e.g. to specify which counterparty is the payer, receiver etc) and this counterparties attribute, which is positioned outside of the product definition, allows the counterparty enum to be associated with an actual party reference.
    */
  val counterparty: List[Counterparty]
  /**
    * Specifies the parties with ancillary roles in the transaction. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and this AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
    */
  val ancillaryParty: List[AncillaryParty]
  /**
    * Specifies the conditions that govern the adjustment to the quantity of a product being traded: e.g. execution, portfolio rebalancing etc. It is typically used in the context of Equity Swaps.
    */
  val adjustment: Option[NotionalAdjustmentEnum.Value]
}

