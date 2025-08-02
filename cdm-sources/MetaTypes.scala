/**
  * This file is auto-generated from the ISDA Common Domain Model, do not edit.
  * Version: 6.0.0
  */
package org.isda.cdm.metafields

import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.module.scala.JsonScalaEnumeration
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

import org.isda.cdm._

case class Key(
  value: String,
  scope: Option[String]) {}
  
case class Reference(
  value: String,
  scope: Option[String]) {}

case class ReferenceWithMetaParty(value: Option[Party],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaBusinessDayAdjustments(value: Option[BusinessDayAdjustments],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaTrade(value: Option[Trade],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaNonNegativeQuantitySchedule(value: Option[NonNegativeQuantitySchedule],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaPriceSchedule(value: Option[PriceSchedule],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaTradeState(value: Option[TradeState],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaBusinessCenters(value: Option[BusinessCenters],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaPayout(value: Option[Payout],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaCollateralPortfolio(value: Option[CollateralPortfolio],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaLegalAgreement(value: Option[LegalAgreement],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaContractDetails(value: Option[ContractDetails],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaExecutionDetails(value: Option[ExecutionDetails],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaCollateral(value: Option[Collateral],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaCalculationPeriodDates(value: Option[CalculationPeriodDates],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaPaymentDates(value: Option[PaymentDates],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaPerformanceValuationDates(value: Option[PerformanceValuationDates],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class BasicReferenceWithMetaString(value: Option[String],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaAdjustableOrRelativeDate(value: Option[AdjustableOrRelativeDate],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaBasketConstituent(value: Option[BasketConstituent],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaMoney(value: Option[Money],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaOptionPayout(value: Option[OptionPayout],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaPortfolioState(value: Option[PortfolioState],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaAdjustableOrRelativeDates(value: Option[AdjustableOrRelativeDates],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaInterestRatePayout(value: Option[InterestRatePayout],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaInterestRateIndex(value: Option[InterestRateIndex],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaWorkflowStep(value: Option[WorkflowStep],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaNaturalPerson(value: Option[NaturalPerson],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaFixedRateSpecification(value: Option[FixedRateSpecification],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaAccount(value: Option[Account],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaObservable(value: Option[Observable],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaRateObservation(value: Option[RateObservation],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaLegalEntity(value: Option[LegalEntity],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaProtectionTerms(value: Option[ProtectionTerms],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaCashSettlementTerms(value: Option[CashSettlementTerms],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaPhysicalSettlementTerms(value: Option[PhysicalSettlementTerms],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class BasicReferenceWithMetaLocalDate(value: Option[java.time.LocalDate],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaObservation(value: Option[Observation],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaResolvablePriceQuantity(value: Option[ResolvablePriceQuantity],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaCreditEvents(value: Option[CreditEvents],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class ReferenceWithMetaQuotedCurrencyPair(value: Option[QuotedCurrencyPair],
    globalReference: Option[String],
    externalReference: Option[String],
    address: Option[Reference]) {}

case class FieldWithMetaString(value: Option[String],
    meta: Option[MetaFields]) {}

case class FieldWithMetaAccountTypeEnum(@JsonDeserialize(contentAs = classOf[AccountTypeEnum.Value])
    @JsonScalaEnumeration(classOf[AccountTypeEnum.Class])
    value: Option[AccountTypeEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaLocalDate(value: Option[java.time.LocalDate],
    meta: Option[MetaFields]) {}

case class FieldWithMetaCreditSupportAgreementTypeEnum(@JsonDeserialize(contentAs = classOf[CreditSupportAgreementTypeEnum.Value])
    @JsonScalaEnumeration(classOf[CreditSupportAgreementTypeEnum.Class])
    value: Option[CreditSupportAgreementTypeEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaContractualDefinitionsEnum(@JsonDeserialize(contentAs = classOf[ContractualDefinitionsEnum.Value])
    @JsonScalaEnumeration(classOf[ContractualDefinitionsEnum.Class])
    value: Option[ContractualDefinitionsEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaMasterAgreementTypeEnum(@JsonDeserialize(contentAs = classOf[MasterAgreementTypeEnum.Value])
    @JsonScalaEnumeration(classOf[MasterAgreementTypeEnum.Class])
    value: Option[MasterAgreementTypeEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaMasterConfirmationTypeEnum(@JsonDeserialize(contentAs = classOf[MasterConfirmationTypeEnum.Value])
    @JsonScalaEnumeration(classOf[MasterConfirmationTypeEnum.Class])
    value: Option[MasterConfirmationTypeEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaMasterConfirmationAnnexTypeEnum(@JsonDeserialize(contentAs = classOf[MasterConfirmationAnnexTypeEnum.Value])
    @JsonScalaEnumeration(classOf[MasterConfirmationAnnexTypeEnum.Class])
    value: Option[MasterConfirmationAnnexTypeEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaMarketDisruptionEnum(@JsonDeserialize(contentAs = classOf[MarketDisruptionEnum.Value])
    @JsonScalaEnumeration(classOf[MarketDisruptionEnum.Class])
    value: Option[MarketDisruptionEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaBasketConstituent(value: Option[BasketConstituent],
    meta: Option[MetaFields]) {}

case class FieldWithMetaBusinessCenterEnum(@JsonDeserialize(contentAs = classOf[BusinessCenterEnum.Value])
    @JsonScalaEnumeration(classOf[BusinessCenterEnum.Class])
    value: Option[BusinessCenterEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaCommodityBusinessCalendarEnum(@JsonDeserialize(contentAs = classOf[CommodityBusinessCalendarEnum.Value])
    @JsonScalaEnumeration(classOf[CommodityBusinessCalendarEnum.Class])
    value: Option[CommodityBusinessCalendarEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaGoverningLawEnum(@JsonDeserialize(contentAs = classOf[GoverningLawEnum.Value])
    @JsonScalaEnumeration(classOf[GoverningLawEnum.Class])
    value: Option[GoverningLawEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaMatrixTypeEnum(@JsonDeserialize(contentAs = classOf[MatrixTypeEnum.Value])
    @JsonScalaEnumeration(classOf[MatrixTypeEnum.Class])
    value: Option[MatrixTypeEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaMatrixTermEnum(@JsonDeserialize(contentAs = classOf[MatrixTermEnum.Value])
    @JsonScalaEnumeration(classOf[MatrixTermEnum.Class])
    value: Option[MatrixTermEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaContractualSupplementTypeEnum(@JsonDeserialize(contentAs = classOf[ContractualSupplementTypeEnum.Value])
    @JsonScalaEnumeration(classOf[ContractualSupplementTypeEnum.Class])
    value: Option[ContractualSupplementTypeEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaIndexAnnexSourceEnum(@JsonDeserialize(contentAs = classOf[IndexAnnexSourceEnum.Value])
    @JsonScalaEnumeration(classOf[IndexAnnexSourceEnum.Class])
    value: Option[IndexAnnexSourceEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaCommodityReferencePriceEnum(@JsonDeserialize(contentAs = classOf[CommodityReferencePriceEnum.Value])
    @JsonScalaEnumeration(classOf[CommodityReferencePriceEnum.Class])
    value: Option[CommodityReferencePriceEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaDayCountFractionEnum(@JsonDeserialize(contentAs = classOf[DayCountFractionEnum.Value])
    @JsonScalaEnumeration(classOf[DayCountFractionEnum.Class])
    value: Option[DayCountFractionEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaTimeZone(value: Option[TimeZone],
    meta: Option[MetaFields]) {}

case class FieldWithMetaSettlementRateOptionEnum(@JsonDeserialize(contentAs = classOf[SettlementRateOptionEnum.Value])
    @JsonScalaEnumeration(classOf[SettlementRateOptionEnum.Class])
    value: Option[SettlementRateOptionEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaFloatingRateIndexEnum(@JsonDeserialize(contentAs = classOf[FloatingRateIndexEnum.Value])
    @JsonScalaEnumeration(classOf[FloatingRateIndexEnum.Class])
    value: Option[FloatingRateIndexEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaQuotedCurrencyPair(value: Option[QuotedCurrencyPair],
    meta: Option[MetaFields]) {}

case class FieldWithMetaInterestRateIndex(value: Option[InterestRateIndex],
    meta: Option[MetaFields]) {}

case class FieldWithMetaInflationRateIndexEnum(@JsonDeserialize(contentAs = classOf[InflationRateIndexEnum.Value])
    @JsonScalaEnumeration(classOf[InflationRateIndexEnum.Class])
    value: Option[InflationRateIndexEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaInterpolationMethodEnum(@JsonDeserialize(contentAs = classOf[InterpolationMethodEnum.Value])
    @JsonScalaEnumeration(classOf[InterpolationMethodEnum.Class])
    value: Option[InterpolationMethodEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaInformationProviderEnum(@JsonDeserialize(contentAs = classOf[InformationProviderEnum.Value])
    @JsonScalaEnumeration(classOf[InformationProviderEnum.Class])
    value: Option[InformationProviderEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaCreditLimitTypeEnum(@JsonDeserialize(contentAs = classOf[CreditLimitTypeEnum.Value])
    @JsonScalaEnumeration(classOf[CreditLimitTypeEnum.Class])
    value: Option[CreditLimitTypeEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaLimitLevelEnum(@JsonDeserialize(contentAs = classOf[LimitLevelEnum.Value])
    @JsonScalaEnumeration(classOf[LimitLevelEnum.Class])
    value: Option[LimitLevelEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaCreditNotation(value: Option[CreditNotation],
    meta: Option[MetaFields]) {}

case class FieldWithMetaPersonIdentifier(value: Option[PersonIdentifier],
    meta: Option[MetaFields]) {}

case class FieldWithMetaNaturalPersonRoleEnum(@JsonDeserialize(contentAs = classOf[NaturalPersonRoleEnum.Value])
    @JsonScalaEnumeration(classOf[NaturalPersonRoleEnum.Class])
    value: Option[NaturalPersonRoleEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaPriceSchedule(value: Option[PriceSchedule],
    meta: Option[MetaFields]) {}

case class FieldWithMetaNonNegativeQuantitySchedule(value: Option[NonNegativeQuantitySchedule],
    meta: Option[MetaFields]) {}

case class FieldWithMetaObservable(value: Option[Observable],
    meta: Option[MetaFields]) {}

case class FieldWithMetaAssetClassEnum(@JsonDeserialize(contentAs = classOf[AssetClassEnum.Value])
    @JsonScalaEnumeration(classOf[AssetClassEnum.Class])
    value: Option[AssetClassEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaEntityTypeEnum(@JsonDeserialize(contentAs = classOf[EntityTypeEnum.Value])
    @JsonScalaEnumeration(classOf[EntityTypeEnum.Class])
    value: Option[EntityTypeEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaResourceTypeEnum(@JsonDeserialize(contentAs = classOf[ResourceTypeEnum.Value])
    @JsonScalaEnumeration(classOf[ResourceTypeEnum.Class])
    value: Option[ResourceTypeEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaRestructuringEnum(@JsonDeserialize(contentAs = classOf[RestructuringEnum.Value])
    @JsonScalaEnumeration(classOf[RestructuringEnum.Class])
    value: Option[RestructuringEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaSettledEntityMatrixSourceEnum(@JsonDeserialize(contentAs = classOf[SettledEntityMatrixSourceEnum.Value])
    @JsonScalaEnumeration(classOf[SettledEntityMatrixSourceEnum.Class])
    value: Option[SettledEntityMatrixSourceEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaSpreadScheduleTypeEnum(@JsonDeserialize(contentAs = classOf[SpreadScheduleTypeEnum.Value])
    @JsonScalaEnumeration(classOf[SpreadScheduleTypeEnum.Class])
    value: Option[SpreadScheduleTypeEnum.Value],
    meta: Option[MetaFields]) {}

case class FieldWithMetaIdentifier(value: Option[Identifier],
    meta: Option[MetaFields]) {}

case class MetaFields(scheme: Option[String],
    globalKey: Option[String],
    externalKey: Option[String],
    location: List[Key]) {}

case class MetaAndTemplateFields(scheme: Option[String],
    globalKey: Option[String],
    externalKey: Option[String],
    templateGlobalReference: Option[String],
    location: List[Key]) {}
