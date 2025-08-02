
/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
package org_isda_cdm_functions  

import "time"
import . "org_isda_cdm"    

//Pointer type args used when the latter are optional
func Abs(arg float64 ) float64 {    
/**
 * Function definition for Abs
 */
return 0
}

func AddBusinessDays(originalDate time.Time, offsetBusinessDays int, businessCenters *BusinessCenterEnum ) time.Time {    
/**
 * Function definition for AddBusinessDays
 */
return time.Time{}
}

func AddDays(inputDate time.Time, numDays int ) time.Time {    
/**
 * Function definition for AddDays
 */
return time.Time{}
}

func AddTradeLot(tradableProduct TradableProduct, newTradeLot TradeLot ) TradableProduct {    
/**
 * Function definition for AddTradeLot
 */
return TradableProduct{}
}

func AdjustableDateResolution(adjustableDate AdjustableDate ) *time.Time {    
/**
 * Function definition for AdjustableDateResolution
 */
return &time.Time{}
}

func AdjustableDatesResolution(adjustableDates AdjustableDates ) *time.Time {    
/**
 * Function definition for AdjustableDatesResolution
 */
return &time.Time{}
}

func AdjustableOrAdjustedOrRelativeDateResolution(adjustableDate AdjustableOrAdjustedOrRelativeDate ) *time.Time {    
/**
 * Function definition for AdjustableOrAdjustedOrRelativeDateResolution
 */
return &time.Time{}
}

func AdjustedValuationDates(valuationDates ValuationDates ) *time.Time {    
/**
 * Function definition for AdjustedValuationDates
 */
return &time.Time{}
}

func AppendDateToList(origDates *time.Time, newDate time.Time ) *time.Time {    
/**
 * Function definition for AppendDateToList
 */
return &time.Time{}
}

func AppendToVector(vector *float64, value float64 ) *float64 {    
/**
 * Function definition for AppendToVector
 */
return 0
}

func ApplyAveragingFormula(observations *float64, weights *float64 ) CalculatedRateDetails {    
/**
 * Function definition for ApplyAveragingFormula
 */
return CalculatedRateDetails{}
}

func ApplyCapsAndFloors(processing FloatingRateProcessingParameters, inputRate float64 ) float64 {    
/**
 * Function definition for ApplyCapsAndFloors
 */
return 0
}

func ApplyCompoundingFormula(observations *float64, weights *float64, yearFrac float64 ) CalculatedRateDetails {    
/**
 * Function definition for ApplyCompoundingFormula
 */
return CalculatedRateDetails{}
}

func ApplyFinalRateRounding(baseRate float64, finalRateRounding *Rounding ) float64 {    
/**
 * Function definition for ApplyFinalRateRounding
 */
return 0
}

func ApplyFloatingRatePostSpreadProcessing(inputRate float64, processing FloatingRateProcessingParameters ) float64 {    
/**
 * Function definition for ApplyFloatingRatePostSpreadProcessing
 */
return 0
}

func ApplyFloatingRateProcessing(processing FloatingRateProcessingParameters, rawRate float64, calculationPeriod CalculationPeriodBase, isInitialPeriod bool ) FloatingRateProcessingDetails {    
/**
 * Function definition for ApplyFloatingRateProcessing
 */
return FloatingRateProcessingDetails{}
}

func ApplyFloatingRateSetting(interestRatePayout InterestRatePayout, calculationPeriod CalculationPeriodBase, isInitialPeriod bool, suppliedNotional *float64, suppliedRate *float64, floatingRateSetting *FloatingRateSettingDetails ) FloatingAmountCalculationDetails {    
/**
 * Function definition for ApplyFloatingRateSetting
 */
return FloatingAmountCalculationDetails{}
}

func ApplyUSRateTreatment(baseRate float64, rateTreatment RateTreatmentEnum, calculationPeriod CalculationPeriodBase ) float64 {    
/**
 * Function definition for ApplyUSRateTreatment
 */
return 0
}

func ArithmeticOperation(n1 float64, op ArithmeticOperationEnum, n2 float64 ) float64 {    
/**
 * Function definition for ArithmeticOperation
 */
return 0
}

func AssetIdentifierByType(identifiers *AssetIdentifier, idType AssetIdTypeEnum ) *AssetIdentifier {    
/**
 * Function definition for AssetIdentifierByType
 */
return &AssetIdentifier{}
}

func AuxiliarEffectiveDate(trade Trade ) *time.Time {    
/**
 * Function definition for AuxiliarEffectiveDate
 */
return &time.Time{}
}

func AuxiliarTerminationDate(trade Trade ) *time.Time {    
/**
 * Function definition for AuxiliarTerminationDate
 */
return &time.Time{}
}

func BuildStandardizedSchedule(trade Trade ) StandardizedSchedule {    
/**
 * Function definition for BuildStandardizedSchedule
 */
return StandardizedSchedule{}
}

func BusinessCenterHolidays(businessCenter BusinessCenterEnum ) *time.Time {    
/**
 * Function definition for BusinessCenterHolidays
 */
return &time.Time{}
}

func BusinessCenterHolidaysMultiple(businessCenters *BusinessCenterEnum ) *time.Time {    
/**
 * Function definition for BusinessCenterHolidaysMultiple
 */
return &time.Time{}
}

func CalculateFloatingCashFlow(interestRatePayout InterestRatePayout, calculationPeriod CalculationPeriodBase, notional *float64, currency *string, floatingRateSetting *FloatingRateSettingDetails, processedRateDetails FloatingRateProcessingDetails ) FloatingAmountCalculationDetails {    
/**
 * Function definition for CalculateFloatingCashFlow
 */
return FloatingAmountCalculationDetails{}
}

func CalculateTransfer(instruction CalculateTransferInstruction ) *Transfer {    
/**
 * Function definition for CalculateTransfer
 */
return &Transfer{}
}

func CalculateYearFraction(interestRatePayout InterestRatePayout, dcf DayCountFractionEnum, calculationPeriod CalculationPeriodBase ) float64 {    
/**
 * Function definition for CalculateYearFraction
 */
return 0
}

func CalculationPeriod(calculationPeriodDates CalculationPeriodDates, date time.Time ) CalculationPeriodData {    
/**
 * Function definition for CalculationPeriod
 */
return CalculationPeriodData{}
}

func CalculationPeriodRange(startDate *time.Time, endDate *time.Time, dateAdjustments *BusinessDayAdjustments ) CalculationPeriodData {    
/**
 * Function definition for CalculationPeriodRange
 */
return CalculationPeriodData{}
}

func CalculationPeriods(calculationPeriodDates CalculationPeriodDates ) *CalculationPeriodData {    
/**
 * Function definition for CalculationPeriods
 */
return &CalculationPeriodData{}
}

func CapRateAmount(interestRatePayout InterestRatePayout, calculationPeriod CalculationPeriodBase ) *float64 {    
/**
 * Function definition for CapRateAmount
 */
return 0
}

func CashPriceQuantityNoOfUnitsTriangulation(quantity *NonNegativeQuantitySchedule, price *PriceSchedule ) bool {    
/**
 * Function definition for CashPriceQuantityNoOfUnitsTriangulation
 */
return false
}

func CheckAgencyRating(agencyRatings *AgencyRatingCriteria, query EligibilityQuery ) bool {    
/**
 * Function definition for CheckAgencyRating
 */
return false
}

func CheckAssetType(collateralAssetTypes *AssetType, query EligibilityQuery ) bool {    
/**
 * Function definition for CheckAssetType
 */
return false
}

func CheckCountryOfOrigin(countryOfOrigin *ISOCountryCodeEnum, query EligibilityQuery ) bool {    
/**
 * Function definition for CheckCountryOfOrigin
 */
return false
}

func CheckCriteria(inputCriteria CollateralCriteria, query EligibilityQuery ) bool {    
/**
 * Function definition for CheckCriteria
 */
return false
}

func CheckDenominatedCurrency(denominatedCurrency *CurrencyCodeEnum, query EligibilityQuery ) bool {    
/**
 * Function definition for CheckDenominatedCurrency
 */
return false
}

func CheckEligibilityByDetails(specification EligibleCollateralSpecification, query EligibilityQuery ) CheckEligibilityResult {    
/**
 * Function definition for CheckEligibilityByDetails
 */
return CheckEligibilityResult{}
}

func CheckEligibilityForProduct(specifications EligibleCollateralSpecification, product *TransferableProduct ) *CheckEligibilityResult {    
/**
 * Function definition for CheckEligibilityForProduct
 */
return &CheckEligibilityResult{}
}

func CheckIssuerName(issuerName *IssuerName, query EligibilityQuery ) bool {    
/**
 * Function definition for CheckIssuerName
 */
return false
}

func CheckIssuerType(issuerType *CollateralIssuerType, query EligibilityQuery ) bool {    
/**
 * Function definition for CheckIssuerType
 */
return false
}

func CheckMaturity(maturityRange *AssetMaturity, query EligibilityQuery ) bool {    
/**
 * Function definition for CheckMaturity
 */
return false
}

func CloneEligibleCollateralWithChangedTreatment(inputSpecification EligibleCollateralSpecification, changedCriteria CollateralCriteria, changedTreatment CollateralTreatment ) EligibleCollateralSpecification {    
/**
 * Function definition for CloneEligibleCollateralWithChangedTreatment
 */
return EligibleCollateralSpecification{}
}

func CommodityPayoutOnlyExists(payouts *Payout ) bool {    
/**
 * Function definition for CommodityPayoutOnlyExists
 */
return false
}

func CompareNumbers(n1 float64, op CompareOp, n2 float64 ) bool {    
/**
 * Function definition for CompareNumbers
 */
return false
}

func CompareQuantityByUnitOfAmount(quantity1 *Quantity, op CompareOp, quantity2 *Quantity, unitOfAmount UnitType ) bool {    
/**
 * Function definition for CompareQuantityByUnitOfAmount
 */
return false
}

func CompareTradeLot(tradeLot1 TradeLot, op CompareOp, tradeLot2 TradeLot ) bool {    
/**
 * Function definition for CompareTradeLot
 */
return false
}

func CompareTradeLotToAmount(tradeLot TradeLot, op CompareOp, amount float64 ) bool {    
/**
 * Function definition for CompareTradeLotToAmount
 */
return false
}

func CompareTradeStatesToAmount(tradeStates *TradeState, op CompareOp, amount float64 ) bool {    
/**
 * Function definition for CompareTradeStatesToAmount
 */
return false
}

func ComputeCalculationPeriod(calculationPeriod CalculationPeriodBase, priorCalculationPeriod *CalculationPeriodBase, calculateRelativeTo *ObservationPeriodDatesEnum, resetDates *ResetDates ) CalculationPeriodBase {    
/**
 * Function definition for ComputeCalculationPeriod
 */
return CalculationPeriodBase{}
}

func ConvertToAdjustableOrAdjustedOrRelativeDate(adjustableOrRelativeDate *AdjustableOrRelativeDate ) *AdjustableOrAdjustedOrRelativeDate {    
/**
 * Function definition for ConvertToAdjustableOrAdjustedOrRelativeDate
 */
return &AdjustableOrAdjustedOrRelativeDate{}
}

func ConvertToAdjustableOrRelativeDate(adjustableOrAdjustedOrRelativeDate *AdjustableOrAdjustedOrRelativeDate ) *AdjustableOrRelativeDate {    
/**
 * Function definition for ConvertToAdjustableOrRelativeDate
 */
return &AdjustableOrRelativeDate{}
}

func CreateAndCriteria(inputCriteria CollateralCriteria ) CollateralCriteria {    
/**
 * Function definition for CreateAndCriteria
 */
return CollateralCriteria{}
}

func CreateOrCriteria(inputCriteria CollateralCriteria ) CollateralCriteria {    
/**
 * Function definition for CreateOrCriteria
 */
return CollateralCriteria{}
}

func Create_AcceptedWorkflowStep(messageInformation *MessageInformation, timestamp EventTimestamp, eventIdentifier Identifier, party *Party, account *Account, proposedWorkflowStep WorkflowStep, businessEvent BusinessEvent ) WorkflowStep {    
/**
 * Function definition for Create_AcceptedWorkflowStep
 */
return WorkflowStep{}
}

func Create_AcceptedWorkflowStepFromInstruction(proposedWorkflowStep WorkflowStep ) WorkflowStep {    
/**
 * Function definition for Create_AcceptedWorkflowStepFromInstruction
 */
return WorkflowStep{}
}

func Create_AdjustmentPrimitiveInstruction(tradeState TradeState, newAllinPrice float64, newAssetQuantity float64, effectiveRepriceDate AdjustableOrRelativeDate ) PrimitiveInstruction {    
/**
 * Function definition for Create_AdjustmentPrimitiveInstruction
 */
return PrimitiveInstruction{}
}

func Create_AssetPayoutTradeStateWithObservations(billingInstruction BillingRecordInstruction ) TradeState {    
/**
 * Function definition for Create_AssetPayoutTradeStateWithObservations
 */
return TradeState{}
}

func Create_AssetReset(assetPayout AssetPayout, observation Observation, resetDate time.Time ) Reset {    
/**
 * Function definition for Create_AssetReset
 */
return Reset{}
}

func Create_AssetTransfer(instruction CalculateTransferInstruction ) Transfer {    
/**
 * Function definition for Create_AssetTransfer
 */
return Transfer{}
}

func Create_BillingRecord(billingInstruction BillingRecordInstruction ) BillingRecord {    
/**
 * Function definition for Create_BillingRecord
 */
return BillingRecord{}
}

func Create_BillingRecords(billingInstruction BillingRecordInstruction ) BillingRecord {    
/**
 * Function definition for Create_BillingRecords
 */
return BillingRecord{}
}

func Create_BillingSummary(billingRecord BillingRecord ) BillingSummary {    
/**
 * Function definition for Create_BillingSummary
 */
return BillingSummary{}
}

func Create_BusinessEvent(instruction Instruction, intent *EventIntentEnum, eventDate time.Time, effectiveDate time.Time ) BusinessEvent {    
/**
 * Function definition for Create_BusinessEvent
 */
return BusinessEvent{}
}

func Create_CalculationPeriodBase(calcPeriodData CalculationPeriodData ) CalculationPeriodBase {    
/**
 * Function definition for Create_CalculationPeriodBase
 */
return CalculationPeriodBase{}
}

func Create_CancellationPrimitiveInstruction(tradeState TradeState, newRepurchasePrice *float64, cancellationDate AdjustableOrRelativeDate ) PrimitiveInstruction {    
/**
 * Function definition for Create_CancellationPrimitiveInstruction
 */
return PrimitiveInstruction{}
}

func Create_CancellationTermChangeInstruction(product NonTransferableProduct, cancellationDate AdjustableOrRelativeDate ) TermsChangeInstruction {    
/**
 * Function definition for Create_CancellationTermChangeInstruction
 */
return TermsChangeInstruction{}
}

func Create_CashTransfer(instruction CalculateTransferInstruction ) Transfer {    
/**
 * Function definition for Create_CashTransfer
 */
return Transfer{}
}

func Create_CashflowFromSettlementPayout(payout SettlementPayout ) []Cashflow {    
/**
 * Function definition for Create_CashflowFromSettlementPayout
 */
return []Cashflow{}
}

func Create_ContractFormation(instruction ContractFormationInstruction, execution TradeState ) TradeState {    
/**
 * Function definition for Create_ContractFormation
 */
return TradeState{}
}

func Create_ContractFormationInstruction(legalAgreement *LegalAgreement ) ContractFormationInstruction {    
/**
 * Function definition for Create_ContractFormationInstruction
 */
return ContractFormationInstruction{}
}

func Create_EffectiveOrTerminationDateTermChangeInstruction(product NonTransferableProduct, effectiveRollDate *AdjustableOrRelativeDate, terminationDate *AdjustableOrRelativeDate ) TermsChangeInstruction {    
/**
 * Function definition for Create_EffectiveOrTerminationDateTermChangeInstruction
 */
return TermsChangeInstruction{}
}

func Create_Execution(instruction ExecutionInstruction ) TradeState {    
/**
 * Function definition for Create_Execution
 */
return TradeState{}
}

func Create_Exercise(exerciseInstruction ExerciseInstruction, originalTrade TradeState ) TradeState {    
/**
 * Function definition for Create_Exercise
 */
return TradeState{}
}

func Create_ExposureFromTrades(trades *TradeState ) *Exposure {    
/**
 * Function definition for Create_ExposureFromTrades
 */
return &Exposure{}
}

func Create_IndexTransitionTermsChange(instruction IndexTransitionInstruction, tradeState TradeState ) TradeState {    
/**
 * Function definition for Create_IndexTransitionTermsChange
 */
return TradeState{}
}

func Create_NonTransferableProduct(underlier Underlier, payerReceiver PayerReceiver ) NonTransferableProduct {    
/**
 * Function definition for Create_NonTransferableProduct
 */
return NonTransferableProduct{}
}

func Create_Observation(instruction ObservationInstruction, before TradeState ) TradeState {    
/**
 * Function definition for Create_Observation
 */
return TradeState{}
}

func Create_OnDemandInterestPaymentPrimitiveInstruction(tradeState TradeState, interestAmount Money, settlementDate SettlementDate ) PrimitiveInstruction {    
/**
 * Function definition for Create_OnDemandInterestPaymentPrimitiveInstruction
 */
return PrimitiveInstruction{}
}

func Create_OnDemandRateChangePriceChangeInstruction(priceQuantity PriceQuantity, newRate float64 ) QuantityChangeInstruction {    
/**
 * Function definition for Create_OnDemandRateChangePriceChangeInstruction
 */
return QuantityChangeInstruction{}
}

func Create_OnDemandRateChangePrimitiveInstruction(tradeState TradeState, effectiveDate AdjustableOrRelativeDate, agreedRate float64 ) PrimitiveInstruction {    
/**
 * Function definition for Create_OnDemandRateChangePrimitiveInstruction
 */
return PrimitiveInstruction{}
}

func Create_OnDemandRateChangeTermsChangeInstruction(product NonTransferableProduct, effectiveDate AdjustableOrRelativeDate ) TermsChangeInstruction {    
/**
 * Function definition for Create_OnDemandRateChangeTermsChangeInstruction
 */
return TermsChangeInstruction{}
}

func Create_PackageExecutionDetails(executionDetails *ExecutionDetails, listId Identifier, componentId Identifier ) ExecutionDetails {    
/**
 * Function definition for Create_PackageExecutionDetails
 */
return ExecutionDetails{}
}

func Create_PairOffInstruction(tradeState TradeState, pairReference Identifier ) Instruction {    
/**
 * Function definition for Create_PairOffInstruction
 */
return Instruction{}
}

func Create_PartialDeliveryPrimitiveInstruction(tradeState TradeState, deliveredPriceQuantity PriceQuantity ) PrimitiveInstruction {    
/**
 * Function definition for Create_PartialDeliveryPrimitiveInstruction
 */
return PrimitiveInstruction{}
}

func Create_PartyChange(counterparty Counterparty, ancillaryParty *AncillaryParty, partyRole *PartyRole, tradeId TradeIdentifier, originalTrade TradeState ) TradeState {    
/**
 * Function definition for Create_PartyChange
 */
return TradeState{}
}

func Create_ProposedWorkflowStep(messageInformation *MessageInformation, timestamp EventTimestamp, eventIdentifier Identifier, party *Party, account *Account, previousWorkflowStep *WorkflowStep, action ActionEnum, proposedEvent EventInstruction, approval *WorkflowStepApproval ) WorkflowStep {    
/**
 * Function definition for Create_ProposedWorkflowStep
 */
return WorkflowStep{}
}

func Create_QuantityChange(instruction QuantityChangeInstruction, tradeState TradeState ) TradeState {    
/**
 * Function definition for Create_QuantityChange
 */
return TradeState{}
}

func Create_RejectedWorkflowStep(messageInformation *MessageInformation, timestamp EventTimestamp, eventIdentifier Identifier, proposedWorkflowStep WorkflowStep ) WorkflowStep {    
/**
 * Function definition for Create_RejectedWorkflowStep
 */
return WorkflowStep{}
}

func Create_RepricePrimitiveInstruction(tradeState TradeState, newAllinPrice float64, newCashValue float64, effectiveRepriceDate AdjustableOrRelativeDate ) PrimitiveInstruction {    
/**
 * Function definition for Create_RepricePrimitiveInstruction
 */
return PrimitiveInstruction{}
}

func Create_Reset(instruction ResetInstruction, tradeState TradeState ) TradeState {    
/**
 * Function definition for Create_Reset
 */
return TradeState{}
}

func Create_Return(tradeState TradeState, returnInstruction ReturnInstruction, returnDate time.Time ) BusinessEvent {    
/**
 * Function definition for Create_Return
 */
return BusinessEvent{}
}

func Create_RollPrimitiveInstruction(tradeState TradeState, effectiveRollDate AdjustableOrRelativeDate, terminationDate AdjustableOrRelativeDate, priceQuantity PriceQuantity ) PrimitiveInstruction {    
/**
 * Function definition for Create_RollPrimitiveInstruction
 */
return PrimitiveInstruction{}
}

func Create_RollTermChangeInstruction(product NonTransferableProduct, effectiveRollDate AdjustableOrRelativeDate, terminationDate AdjustableOrRelativeDate ) TermsChangeInstruction {    
/**
 * Function definition for Create_RollTermChangeInstruction
 */
return TermsChangeInstruction{}
}

func Create_SecurityLendingInvoice(instruction BillingInstruction ) SecurityLendingInvoice {    
/**
 * Function definition for Create_SecurityLendingInvoice
 */
return SecurityLendingInvoice{}
}

func Create_ShapingInstruction(tradeState TradeState, tradeLots TradeLot, shapeIdentifier Identifier ) PrimitiveInstruction {    
/**
 * Function definition for Create_ShapingInstruction
 */
return PrimitiveInstruction{}
}

func Create_Split(breakdown PrimitiveInstruction, originalTrade TradeState ) TradeState {    
/**
 * Function definition for Create_Split
 */
return TradeState{}
}

func Create_StockSplit(stockSplitInstruction StockSplitInstruction, before TradeState ) TradeState {    
/**
 * Function definition for Create_StockSplit
 */
return TradeState{}
}

func Create_SubstitutionInstruction(product NonTransferableProduct, effectiveDate AdjustableOrRelativeDate, newCollateralPortfolio CollateralPortfolio ) TermsChangeInstruction {    
/**
 * Function definition for Create_SubstitutionInstruction
 */
return TermsChangeInstruction{}
}

func Create_SubstitutionPrimitiveInstruction(tradeState TradeState, effectiveDate AdjustableOrRelativeDate, newCollateralPortfolio CollateralPortfolio, priceQuantity PriceQuantity ) PrimitiveInstruction {    
/**
 * Function definition for Create_SubstitutionPrimitiveInstruction
 */
return PrimitiveInstruction{}
}

func Create_TerminationInstruction(tradeState TradeState ) PrimitiveInstruction {    
/**
 * Function definition for Create_TerminationInstruction
 */
return PrimitiveInstruction{}
}

func Create_TermsChange(termsChange TermsChangeInstruction, before TradeState ) TradeState {    
/**
 * Function definition for Create_TermsChange
 */
return TradeState{}
}

func Create_TradeState(primitiveInstruction *PrimitiveInstruction, before *TradeState ) TradeState {    
/**
 * Function definition for Create_TradeState
 */
return TradeState{}
}

func Create_Transfer(instruction TransferInstruction, tradeState TradeState ) TradeState {    
/**
 * Function definition for Create_Transfer
 */
return TradeState{}
}

func Create_Valuation(instruction ValuationInstruction, before TradeState ) TradeState {    
/**
 * Function definition for Create_Valuation
 */
return TradeState{}
}

func Create_Workflow(steps WorkflowStep ) Workflow {    
/**
 * Function definition for Create_Workflow
 */
return Workflow{}
}

func Create_WorkflowStep(messageInformation *MessageInformation, timestamp EventTimestamp, eventIdentifier Identifier, party *Party, account *Account, previousWorkflowStep *WorkflowStep, action ActionEnum, businessEvent *BusinessEvent ) WorkflowStep {    
/**
 * Function definition for Create_WorkflowStep
 */
return WorkflowStep{}
}

func CriteriaMatchesAssetType(inputCriteria *CollateralCriteria, assetType *InstrumentTypeEnum ) bool {    
/**
 * Function definition for CriteriaMatchesAssetType
 */
return false
}

func DateDifference(firstDate time.Time, secondDate time.Time ) int {    
/**
 * Function definition for DateDifference
 */
return 0
}

func DateDifferenceYears(firstDate time.Time, secondDate time.Time ) float64 {    
/**
 * Function definition for DateDifferenceYears
 */
return 0
}

func DayCountBasis(dcf DayCountFractionEnum ) int {    
/**
 * Function definition for DayCountBasis
 */
return 0
}

func DayOfWeek(date time.Time ) DayOfWeekEnum {    
/**
 * Function definition for DayOfWeek
 */
return DayOfWeekEnum{}
}

func DefaultFloatingRate(suppliedRate float64 ) FloatingRateProcessingDetails {    
/**
 * Function definition for DefaultFloatingRate
 */
return FloatingRateProcessingDetails{}
}

func DetermineFixingDate(resetDates ResetDates, resetDate time.Time ) time.Time {    
/**
 * Function definition for DetermineFixingDate
 */
return time.Time{}
}

func DetermineFloatingRateReset(interestRatePayout InterestRatePayout, calcPeriod CalculationPeriodBase ) FloatingRateSettingDetails {    
/**
 * Function definition for DetermineFloatingRateReset
 */
return FloatingRateSettingDetails{}
}

func DetermineObservationPeriod(adjustedCalculationPeriod CalculationPeriodBase, calculationParams FloatingRateCalculationParameters ) CalculationPeriodBase {    
/**
 * Function definition for DetermineObservationPeriod
 */
return CalculationPeriodBase{}
}

func DetermineResetDate(resetDates ResetDates, calculationPeriod CalculationPeriodBase ) time.Time {    
/**
 * Function definition for DetermineResetDate
 */
return time.Time{}
}

func DetermineWeightingDates(calculationParams FloatingRateCalculationParameters, observationDates *time.Time, observationPeriod CalculationPeriodBase, adjustedCalculationPeriod CalculationPeriodBase, lockoutDays int ) *time.Time {    
/**
 * Function definition for DetermineWeightingDates
 */
return &time.Time{}
}

func DifferentOrdinalsCondition(taxonomy Taxonomy ) bool {    
/**
 * Function definition for DifferentOrdinalsCondition
 */
return false
}

func DividendCashSettlementAmount(numberOfSecurities float64, declaredDividend float64 ) float64 {    
/**
 * Function definition for DividendCashSettlementAmount
 */
return 0
}

func EmptyExecutionDetails() *ExecutionDetails {    
/**
 * Function definition for EmptyExecutionDetails
 */
return &ExecutionDetails{}
}

func EmptyTransferHistory() *TransferState {    
/**
 * Function definition for EmptyTransferHistory
 */
return &TransferState{}
}

func EquityCashSettlementAmount(tradeState TradeState, date time.Time ) Transfer {    
/**
 * Function definition for EquityCashSettlementAmount
 */
return Transfer{}
}

func EquityNotionalAmount(numberOfSecurities float64, price Price ) float64 {    
/**
 * Function definition for EquityNotionalAmount
 */
return 0
}

func EquityPerformance(trade Trade, observation Price, date time.Time ) float64 {    
/**
 * Function definition for EquityPerformance
 */
return 0
}

func EvaluateCalculatedRate(interestRateIndex InterestRateIndex, calculationParameters FloatingRateCalculationParameters, resetDates *ResetDates, calculationPeriod CalculationPeriodBase, priorCalculationPeriod *CalculationPeriodBase, dayCount DayCountFractionEnum ) FloatingRateSettingDetails {    
/**
 * Function definition for EvaluateCalculatedRate
 */
return FloatingRateSettingDetails{}
}

func EvaluatePortfolioState(portfolio Portfolio ) PortfolioState {    
/**
 * Function definition for EvaluatePortfolioState
 */
return PortfolioState{}
}

func EvaluateScreenRate(rateDef FloatingRate, resetDates ResetDates, calculationPeriod CalculationPeriodBase ) FloatingRateSettingDetails {    
/**
 * Function definition for EvaluateScreenRate
 */
return FloatingRateSettingDetails{}
}

func ExtractAfterTrade(businessEvent BusinessEvent ) *Trade {    
/**
 * Function definition for ExtractAfterTrade
 */
return &Trade{}
}

func ExtractAncillaryPartyByRole(ancillaryParties AncillaryParty, roleEnumToExtract AncillaryRoleEnum ) *AncillaryParty {    
/**
 * Function definition for ExtractAncillaryPartyByRole
 */
return &AncillaryParty{}
}

func ExtractBeforeEconomicTerms(businessEvent BusinessEvent ) *EconomicTerms {    
/**
 * Function definition for ExtractBeforeEconomicTerms
 */
return &EconomicTerms{}
}

func ExtractBeforeTrade(businessEvent BusinessEvent ) *Trade {    
/**
 * Function definition for ExtractBeforeTrade
 */
return &Trade{}
}

func ExtractCounterpartyByRole(counterparties Counterparty, roleEnumToExtract CounterpartyRoleEnum ) *Counterparty {    
/**
 * Function definition for ExtractCounterpartyByRole
 */
return &Counterparty{}
}

func ExtractFixedLeg(interestRatePayouts *InterestRatePayout ) *InterestRatePayout {    
/**
 * Function definition for ExtractFixedLeg
 */
return &InterestRatePayout{}
}

func ExtractOpenEconomicTerms(businessEvent BusinessEvent ) *EconomicTerms {    
/**
 * Function definition for ExtractOpenEconomicTerms
 */
return &EconomicTerms{}
}

func ExtractTradeCollateralPrice(tradableProduct TradableProduct ) *float64 {    
/**
 * Function definition for ExtractTradeCollateralPrice
 */
return 0
}

func ExtractTradeCollateralQuantity(tradableProduct TradableProduct ) *float64 {    
/**
 * Function definition for ExtractTradeCollateralQuantity
 */
return 0
}

func ExtractTradePurchasePrice(tradableProduct TradableProduct ) *float64 {    
/**
 * Function definition for ExtractTradePurchasePrice
 */
return 0
}

func FXFarLeg(product NonTransferableProduct ) *SettlementPayout {    
/**
 * Function definition for FXFarLeg
 */
return &SettlementPayout{}
}

func FilterCashTransfers(transfers *Transfer ) *Transfer {    
/**
 * Function definition for FilterCashTransfers
 */
return &Transfer{}
}

func FilterClosedTradeStates(tradeStates *TradeState ) *TradeState {    
/**
 * Function definition for FilterClosedTradeStates
 */
return &TradeState{}
}

func FilterOpenTradeStates(tradeStates *TradeState ) *TradeState {    
/**
 * Function definition for FilterOpenTradeStates
 */
return &TradeState{}
}

func FilterPartyRole(partyRoles *PartyRole, partyRoleEnum PartyRoleEnum ) *PartyRole {    
/**
 * Function definition for FilterPartyRole
 */
return &PartyRole{}
}

func FilterPrice(prices *PriceSchedule, priceType PriceTypeEnum, arithmeticOperators *ArithmeticOperationEnum, priceExpression *PriceExpressionEnum ) *PriceSchedule {    
/**
 * Function definition for FilterPrice
 */
return &PriceSchedule{}
}

func FilterQuantity(quantities *Quantity, unit UnitType ) *Quantity {    
/**
 * Function definition for FilterQuantity
 */
return &Quantity{}
}

func FilterQuantityByCurrency(quantities *QuantitySchedule, currency string ) *QuantitySchedule {    
/**
 * Function definition for FilterQuantityByCurrency
 */
return &QuantitySchedule{}
}

func FilterQuantityByCurrencyExists(quantities *QuantitySchedule ) *QuantitySchedule {    
/**
 * Function definition for FilterQuantityByCurrencyExists
 */
return &QuantitySchedule{}
}

func FilterQuantityByFinancialUnit(quantities *QuantitySchedule, financialUnit FinancialUnitEnum ) *QuantitySchedule {    
/**
 * Function definition for FilterQuantityByFinancialUnit
 */
return &QuantitySchedule{}
}

func FilterRelatedPartyByRole(relatedParties *RelatedParty, partyRoleEnum PartyRoleEnum ) *RelatedParty {    
/**
 * Function definition for FilterRelatedPartyByRole
 */
return &RelatedParty{}
}

func FilterSecurityTransfers(transfers *Transfer ) *Transfer {    
/**
 * Function definition for FilterSecurityTransfers
 */
return &Transfer{}
}

func FilterTradeLot(tradeLots *TradeLot, lotIdentifier *Identifier ) *TradeLot {    
/**
 * Function definition for FilterTradeLot
 */
return &TradeLot{}
}

func FindMatchingIndexTransitionInstruction(instructions PriceQuantity, priceQuantity PriceQuantity ) *PriceQuantity {    
/**
 * Function definition for FindMatchingIndexTransitionInstruction
 */
return &PriceQuantity{}
}

func FixedAmount(interestRatePayout InterestRatePayout, notional *float64, date *time.Time, calculationPeriodData *CalculationPeriodData ) float64 {    
/**
 * Function definition for FixedAmount
 */
return 0
}

func FixedAmountCalculation(interestRatePayout InterestRatePayout, calculationPeriod CalculationPeriodBase, notional *float64 ) FixedAmountCalculationDetails {    
/**
 * Function definition for FixedAmountCalculation
 */
return FixedAmountCalculationDetails{}
}

func FloatingAmount(interestRatePayout InterestRatePayout, rate *float64, notional *float64, date *time.Time, calculationPeriodData *CalculationPeriodData ) float64 {    
/**
 * Function definition for FloatingAmount
 */
return 0
}

func FloatingAmountCalculation(interestRatePayout InterestRatePayout, calculationPeriod CalculationPeriodBase, isInitialPeriod bool, suppliedNotional *float64, suppliedRate *float64 ) FloatingAmountCalculationDetails {    
/**
 * Function definition for FloatingAmountCalculation
 */
return FloatingAmountCalculationDetails{}
}

func FloatingRateIndexMetadata(floatingRateIndexName FloatingRateIndexEnum ) *FloatingRateIndexDefinition {    
/**
 * Function definition for FloatingRateIndexMetadata
 */
return &FloatingRateIndexDefinition{}
}

func FloorRateAmount(interestRatePayout InterestRatePayout, calculationPeriod CalculationPeriodBase ) *float64 {    
/**
 * Function definition for FloorRateAmount
 */
return 0
}

func FpmlIrd8(trade Trade, accounts *Account ) bool {    
/**
 * Function definition for FpmlIrd8
 */
return false
}

func FxMarkToMarket(trade Trade ) float64 {    
/**
 * Function definition for FxMarkToMarket
 */
return 0
}

func GenerateDateList(startDate time.Time, endDate time.Time, businessCenters *BusinessCenterEnum ) *time.Time {    
/**
 * Function definition for GenerateDateList
 */
return &time.Time{}
}

func GenerateObservationDates(observationPeriod CalculationPeriodBase, businessCenters *BusinessCenterEnum, lockoutDays *int ) *time.Time {    
/**
 * Function definition for GenerateObservationDates
 */
return &time.Time{}
}

func GenerateObservationDatesAndWeights(calculationParams FloatingRateCalculationParameters, resetDates *ResetDates, calculationPeriod CalculationPeriodBase, priorCalculationPeriod *CalculationPeriodBase ) CalculatedRateObservationDatesAndWeights {    
/**
 * Function definition for GenerateObservationDatesAndWeights
 */
return CalculatedRateObservationDatesAndWeights{}
}

func GenerateObservationPeriod(calculationPeriod CalculationPeriodBase, businessCenters *BusinessCenterEnum, shiftDays *int ) CalculationPeriodBase {    
/**
 * Function definition for GenerateObservationPeriod
 */
return CalculationPeriodBase{}
}

func GenerateWeightings(calculationParams FloatingRateCalculationParameters, observationDates *time.Time, observationPeriod CalculationPeriodBase, adjustedCalculationPeriod CalculationPeriodBase, lockoutDays int ) *float64 {    
/**
 * Function definition for GenerateWeightings
 */
return 0
}

func GenerateWeights(weightingDates *time.Time ) *float64 {    
/**
 * Function definition for GenerateWeights
 */
return 0
}

func GetAllBusinessCenters(businessCenters BusinessCenters ) *BusinessCenterEnum {    
/**
 * Function definition for GetAllBusinessCenters
 */
return &BusinessCenterEnum{}
}

func GetCalculatedFROCalculationParameters(resetDates ResetDates, calcMethod CalculationMethodEnum ) FloatingRateCalculationParameters {    
/**
 * Function definition for GetCalculatedFROCalculationParameters
 */
return FloatingRateCalculationParameters{}
}

func GetCashCurrency(cash Cash ) CurrencyCodeEnum {    
/**
 * Function definition for GetCashCurrency
 */
return CurrencyCodeEnum{}
}

func GetFixedRate(interestRatePayout InterestRatePayout, calculationPeriod CalculationPeriodBase ) *float64 {    
/**
 * Function definition for GetFixedRate
 */
return 0
}

func GetFloatingRateProcessingParameters(interestRatePayout InterestRatePayout, calculationPeriod CalculationPeriodBase ) FloatingRateProcessingParameters {    
/**
 * Function definition for GetFloatingRateProcessingParameters
 */
return FloatingRateProcessingParameters{}
}

func GetFloatingRateProcessingType(rateDef FloatingRateSpecification ) FloatingRateIndexProcessingTypeEnum {    
/**
 * Function definition for GetFloatingRateProcessingType
 */
return FloatingRateIndexProcessingTypeEnum{}
}

func GetGrossInitialMarginFromStandardizedSchedule(standardizedSchedule StandardizedSchedule ) *Money {    
/**
 * Function definition for GetGrossInitialMarginFromStandardizedSchedule
 */
return &Money{}
}

func GetNetInitialMarginFromExposure(exposure *Exposure ) *StandardizedScheduleInitialMargin {    
/**
 * Function definition for GetNetInitialMarginFromExposure
 */
return &StandardizedScheduleInitialMargin{}
}

func GetNotionalAmount(interestRatePayout InterestRatePayout, calculationPeriod CalculationPeriodBase ) Money {    
/**
 * Function definition for GetNotionalAmount
 */
return Money{}
}

func GetQuantityScheduleStepValues(schedule NonNegativeQuantitySchedule, periodStartDate time.Time ) *float64 {    
/**
 * Function definition for GetQuantityScheduleStepValues
 */
return 0
}

func GetRateScheduleAmount(schedule RateSchedule, periodStartDate time.Time ) float64 {    
/**
 * Function definition for GetRateScheduleAmount
 */
return 0
}

func GetRateScheduleStepValues(schedule RateSchedule, periodStartDate time.Time ) *float64 {    
/**
 * Function definition for GetRateScheduleStepValues
 */
return 0
}

func GetStandardizedScheduleMarginRate(assetClass StandardizedScheduleAssetClassEnum, durationInYears float64 ) float64 {    
/**
 * Function definition for GetStandardizedScheduleMarginRate
 */
return 0
}

func IndexValueObservation(observationDate time.Time, interestRateIndex InterestRateIndex ) float64 {    
/**
 * Function definition for IndexValueObservation
 */
return 0
}

func IndexValueObservationMultiple(observationDate *time.Time, interestRateIndex InterestRateIndex ) *float64 {    
/**
 * Function definition for IndexValueObservationMultiple
 */
return 0
}

func InterestCashSettlementAmount(tradeState TradeState, payout Payout, resets Reset, date time.Time ) Transfer {    
/**
 * Function definition for InterestCashSettlementAmount
 */
return Transfer{}
}

func InterestRateObservableCondition(pq PriceQuantity ) *bool {    
/**
 * Function definition for InterestRateObservableCondition
 */
return false
}

func InterestRatePayoutCurrency(interestRatePayouts *InterestRatePayout ) *string {    
/**
 * Function definition for InterestRatePayoutCurrency
 */
return &string{}
}

func InterestRatePayoutOnlyExists(payouts *Payout ) bool {    
/**
 * Function definition for InterestRatePayoutOnlyExists
 */
return false
}

func InterpolateForwardRate(settlementPayout SettlementPayout ) float64 {    
/**
 * Function definition for InterpolateForwardRate
 */
return 0
}

func IsBusinessDay(date time.Time, businessCenters *BusinessCenterEnum ) bool {    
/**
 * Function definition for IsBusinessDay
 */
return false
}

func IsCreditNthToDefault(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for IsCreditNthToDefault
 */
return false
}

func IsFXDeliverableOption(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for IsFXDeliverableOption
 */
return false
}

func IsFXNonDeliverableOption(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for IsFXNonDeliverableOption
 */
return false
}

func IsHoliday(checkDate time.Time, businessCenters *BusinessCenterEnum ) bool {    
/**
 * Function definition for IsHoliday
 */
return false
}

func IsIRSwapWithCallableBermudanRightToEnterExitSwaps(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for IsIRSwapWithCallableBermudanRightToEnterExitSwaps
 */
return false
}

func IsIRSwaptionStraddle(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for IsIRSwaptionStraddle
 */
return false
}

func IsValidPartyRole(partyRoles *PartyRole, validRoles PartyRoleEnum ) bool {    
/**
 * Function definition for IsValidPartyRole
 */
return false
}

func IsWeekend(date time.Time, businessCenters *BusinessCenterEnum ) bool {    
/**
 * Function definition for IsWeekend
 */
return false
}

func LeapYearDateDifference(firstDate time.Time, secondDate time.Time ) int {    
/**
 * Function definition for LeapYearDateDifference
 */
return 0
}

func MapGenericProductToForwardPayout(synonymPath string, modelPath string, productType *string ) bool {    
/**
 * Function definition for MapGenericProductToForwardPayout
 */
return false
}

func Max(a float64, b float64 ) float64 {    
/**
 * Function definition for Max
 */
return 0
}

func Min(a float64, b float64 ) float64 {    
/**
 * Function definition for Min
 */
return 0
}

func MultiplierAmount(interestRatePayout InterestRatePayout, calculationPeriod CalculationPeriodBase ) *float64 {    
/**
 * Function definition for MultiplierAmount
 */
return 0
}

func NewEquitySwapProduct(security Security, masterConfirmation *EquitySwapMasterConfirmation2018 ) NonTransferableProduct {    
/**
 * Function definition for NewEquitySwapProduct
 */
return NonTransferableProduct{}
}

func NewFloatingPayout(masterConfirmation *EquitySwapMasterConfirmation2018 ) InterestRatePayout {    
/**
 * Function definition for NewFloatingPayout
 */
return InterestRatePayout{}
}

func NewSingleNameEquityPerformancePayout(security Security, masterConfirmation *EquitySwapMasterConfirmation2018 ) PerformancePayout {    
/**
 * Function definition for NewSingleNameEquityPerformancePayout
 */
return PerformancePayout{}
}

func NewTradeInstructionOnlyExists(primitiveInstruction PrimitiveInstruction ) bool {    
/**
 * Function definition for NewTradeInstructionOnlyExists
 */
return false
}

func Now() time.Time {    
/**
 * Function definition for Now
 */
return time.Time{}
}

func ObservableIsCommodity(observable *Observable ) bool {    
/**
 * Function definition for ObservableIsCommodity
 */
return false
}

func ObservableQualification(observable *Observable, securityType *InstrumentTypeEnum, assetClass *AssetClassEnum ) bool {    
/**
 * Function definition for ObservableQualification
 */
return false
}

func PaymentDate(economicTerms EconomicTerms ) *time.Time {    
/**
 * Function definition for PaymentDate
 */
return &time.Time{}
}

func PerformancePayoutAndFixedPricePayoutOnlyExists(payouts *Payout ) bool {    
/**
 * Function definition for PerformancePayoutAndFixedPricePayoutOnlyExists
 */
return false
}

func PerformancePayoutAndInterestRatePayoutOnlyExists(payouts *Payout ) bool {    
/**
 * Function definition for PerformancePayoutAndInterestRatePayoutOnlyExists
 */
return false
}

func PerformancePayoutOnlyExists(payouts *Payout ) bool {    
/**
 * Function definition for PerformancePayoutOnlyExists
 */
return false
}

func PeriodsInYear(frequency CalculationPeriodFrequency ) int {    
/**
 * Function definition for PeriodsInYear
 */
return 0
}

func PopOffDateList(dates *time.Time ) *time.Time {    
/**
 * Function definition for PopOffDateList
 */
return &time.Time{}
}

func PriceQuantityTriangulation(tradeLots *TradeLot ) bool {    
/**
 * Function definition for PriceQuantityTriangulation
 */
return false
}

func ProcessFloatingRateReset(interestRatePayout InterestRatePayout, calcPeriod CalculationPeriodBase, processingType FloatingRateIndexProcessingTypeEnum ) FloatingRateSettingDetails {    
/**
 * Function definition for ProcessFloatingRateReset
 */
return FloatingRateSettingDetails{}
}

func ProcessObservations(calculationParameters FloatingRateCalculationParameters, rawObservations *float64 ) *float64 {    
/**
 * Function definition for ProcessObservations
 */
return 0
}

func Qualify_Adjustment(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Adjustment
 */
return false
}

func Qualify_Allocation(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Allocation
 */
return false
}

func Qualify_AssetClass_Commodity(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_AssetClass_Commodity
 */
return false
}

func Qualify_AssetClass_Credit(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_AssetClass_Credit
 */
return false
}

func Qualify_AssetClass_Equity(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_AssetClass_Equity
 */
return false
}

func Qualify_AssetClass_ForeignExchange(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_AssetClass_ForeignExchange
 */
return false
}

func Qualify_AssetClass_InterestRate(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_AssetClass_InterestRate
 */
return false
}

func Qualify_BaseProduct_CrossCurrency(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_BaseProduct_CrossCurrency
 */
return false
}

func Qualify_BaseProduct_EquityForward(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_BaseProduct_EquityForward
 */
return false
}

func Qualify_BaseProduct_EquitySwap(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_BaseProduct_EquitySwap
 */
return false
}

func Qualify_BaseProduct_Fra(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_BaseProduct_Fra
 */
return false
}

func Qualify_BaseProduct_IRSwap(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_BaseProduct_IRSwap
 */
return false
}

func Qualify_BaseProduct_Inflation(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_BaseProduct_Inflation
 */
return false
}

func Qualify_BuySellBack(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_BuySellBack
 */
return false
}

func Qualify_Cancellation(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Cancellation
 */
return false
}

func Qualify_CashAndSecurityTransfer(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_CashAndSecurityTransfer
 */
return false
}

func Qualify_CashTransfer(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_CashTransfer
 */
return false
}

func Qualify_ClearedTrade(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_ClearedTrade
 */
return false
}

func Qualify_Commodity_Forward(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_Commodity_Forward
 */
return false
}

func Qualify_Commodity_Option(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_Commodity_Option
 */
return false
}

func Qualify_Commodity_Option_Cash(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_Commodity_Option_Cash
 */
return false
}

func Qualify_Commodity_Option_Physical(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_Commodity_Option_Physical
 */
return false
}

func Qualify_Commodity_Swap_Basis(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_Commodity_Swap_Basis
 */
return false
}

func Qualify_Commodity_Swap_FixedFloat(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_Commodity_Swap_FixedFloat
 */
return false
}

func Qualify_Commodity_Swaption(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_Commodity_Swaption
 */
return false
}

func Qualify_Compression(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Compression
 */
return false
}

func Qualify_ContractFormation(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_ContractFormation
 */
return false
}

func Qualify_CorporateActionDetermined(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_CorporateActionDetermined
 */
return false
}

func Qualify_CreditDefaultSwap_Basket(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_CreditDefaultSwap_Basket
 */
return false
}

func Qualify_CreditDefaultSwap_Index(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_CreditDefaultSwap_Index
 */
return false
}

func Qualify_CreditDefaultSwap_IndexTranche(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_CreditDefaultSwap_IndexTranche
 */
return false
}

func Qualify_CreditDefaultSwap_Loan(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_CreditDefaultSwap_Loan
 */
return false
}

func Qualify_CreditDefaultSwap_SingleName(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_CreditDefaultSwap_SingleName
 */
return false
}

func Qualify_CreditDefaultSwaption(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_CreditDefaultSwaption
 */
return false
}

func Qualify_CreditEventDetermined(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_CreditEventDetermined
 */
return false
}

func Qualify_EquityOption_ParameterReturnCorrelation_Basket(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquityOption_ParameterReturnCorrelation_Basket
 */
return false
}

func Qualify_EquityOption_ParameterReturnDividend_Basket(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquityOption_ParameterReturnDividend_Basket
 */
return false
}

func Qualify_EquityOption_ParameterReturnDividend_Index(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquityOption_ParameterReturnDividend_Index
 */
return false
}

func Qualify_EquityOption_ParameterReturnDividend_SingleName(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquityOption_ParameterReturnDividend_SingleName
 */
return false
}

func Qualify_EquityOption_ParameterReturnVariance_Basket(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquityOption_ParameterReturnVariance_Basket
 */
return false
}

func Qualify_EquityOption_ParameterReturnVariance_Index(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquityOption_ParameterReturnVariance_Index
 */
return false
}

func Qualify_EquityOption_ParameterReturnVariance_SingleName(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquityOption_ParameterReturnVariance_SingleName
 */
return false
}

func Qualify_EquityOption_ParameterReturnVolatility_Basket(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquityOption_ParameterReturnVolatility_Basket
 */
return false
}

func Qualify_EquityOption_ParameterReturnVolatility_Index(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquityOption_ParameterReturnVolatility_Index
 */
return false
}

func Qualify_EquityOption_ParameterReturnVolatility_SingleName(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquityOption_ParameterReturnVolatility_SingleName
 */
return false
}

func Qualify_EquityOption_PriceReturnBasicPerformance_Basket(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquityOption_PriceReturnBasicPerformance_Basket
 */
return false
}

func Qualify_EquityOption_PriceReturnBasicPerformance_Index(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquityOption_PriceReturnBasicPerformance_Index
 */
return false
}

func Qualify_EquityOption_PriceReturnBasicPerformance_SingleName(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquityOption_PriceReturnBasicPerformance_SingleName
 */
return false
}

func Qualify_EquitySwap_ParameterReturnCorrelation_Basket(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_ParameterReturnCorrelation_Basket
 */
return false
}

func Qualify_EquitySwap_ParameterReturnDispersion(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_ParameterReturnDispersion
 */
return false
}

func Qualify_EquitySwap_ParameterReturnDividend_Basket(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_ParameterReturnDividend_Basket
 */
return false
}

func Qualify_EquitySwap_ParameterReturnDividend_Index(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_ParameterReturnDividend_Index
 */
return false
}

func Qualify_EquitySwap_ParameterReturnDividend_SingleName(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_ParameterReturnDividend_SingleName
 */
return false
}

func Qualify_EquitySwap_ParameterReturnVariance_Basket(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_ParameterReturnVariance_Basket
 */
return false
}

func Qualify_EquitySwap_ParameterReturnVariance_Index(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_ParameterReturnVariance_Index
 */
return false
}

func Qualify_EquitySwap_ParameterReturnVariance_SingleName(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_ParameterReturnVariance_SingleName
 */
return false
}

func Qualify_EquitySwap_ParameterReturnVolatility_Basket(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_ParameterReturnVolatility_Basket
 */
return false
}

func Qualify_EquitySwap_ParameterReturnVolatility_Index(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_ParameterReturnVolatility_Index
 */
return false
}

func Qualify_EquitySwap_ParameterReturnVolatility_SingleName(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_ParameterReturnVolatility_SingleName
 */
return false
}

func Qualify_EquitySwap_PriceReturnBasicPerformance_Basket(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_PriceReturnBasicPerformance_Basket
 */
return false
}

func Qualify_EquitySwap_PriceReturnBasicPerformance_Index(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_PriceReturnBasicPerformance_Index
 */
return false
}

func Qualify_EquitySwap_PriceReturnBasicPerformance_SingleName(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_PriceReturnBasicPerformance_SingleName
 */
return false
}

func Qualify_EquitySwap_TotalReturnBasicPerformance_Basket(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_TotalReturnBasicPerformance_Basket
 */
return false
}

func Qualify_EquitySwap_TotalReturnBasicPerformance_Index(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_TotalReturnBasicPerformance_Index
 */
return false
}

func Qualify_EquitySwap_TotalReturnBasicPerformance_SingleName(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_EquitySwap_TotalReturnBasicPerformance_SingleName
 */
return false
}

func Qualify_Equity_OtherOption(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_Equity_OtherOption
 */
return false
}

func Qualify_Execution(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Execution
 */
return false
}

func Qualify_Exercise(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Exercise
 */
return false
}

func Qualify_ForeignExchange_NDF(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_ForeignExchange_NDF
 */
return false
}

func Qualify_ForeignExchange_NDS(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_ForeignExchange_NDS
 */
return false
}

func Qualify_ForeignExchange_ParameterReturnCorrelation(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_ForeignExchange_ParameterReturnCorrelation
 */
return false
}

func Qualify_ForeignExchange_ParameterReturnVariance(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_ForeignExchange_ParameterReturnVariance
 */
return false
}

func Qualify_ForeignExchange_ParameterReturnVolatility(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_ForeignExchange_ParameterReturnVolatility
 */
return false
}

func Qualify_ForeignExchange_Spot_Forward(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_ForeignExchange_Spot_Forward
 */
return false
}

func Qualify_ForeignExchange_Swap(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_ForeignExchange_Swap
 */
return false
}

func Qualify_ForeignExchange_VanillaOption(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_ForeignExchange_VanillaOption
 */
return false
}

func Qualify_FullReturn(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_FullReturn
 */
return false
}

func Qualify_Increase(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Increase
 */
return false
}

func Qualify_IndexTransition(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_IndexTransition
 */
return false
}

func Qualify_InstrumentTypeEquity(instrument Instrument ) bool {    
/**
 * Function definition for Qualify_InstrumentTypeEquity
 */
return false
}

func Qualify_InterestRate_CapFloor(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_CapFloor
 */
return false
}

func Qualify_InterestRate_CrossCurrency_Basis(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_CrossCurrency_Basis
 */
return false
}

func Qualify_InterestRate_CrossCurrency_FixedFixed(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_CrossCurrency_FixedFixed
 */
return false
}

func Qualify_InterestRate_CrossCurrency_FixedFloat(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_CrossCurrency_FixedFloat
 */
return false
}

func Qualify_InterestRate_Forward_Debt(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_Forward_Debt
 */
return false
}

func Qualify_InterestRate_Fra(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_Fra
 */
return false
}

func Qualify_InterestRate_IRSwap_Basis(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_IRSwap_Basis
 */
return false
}

func Qualify_InterestRate_IRSwap_Basis_OIS(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_IRSwap_Basis_OIS
 */
return false
}

func Qualify_InterestRate_IRSwap_FixedFixed(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_IRSwap_FixedFixed
 */
return false
}

func Qualify_InterestRate_IRSwap_FixedFloat(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_IRSwap_FixedFloat
 */
return false
}

func Qualify_InterestRate_IRSwap_FixedFloat_OIS(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_IRSwap_FixedFloat_OIS
 */
return false
}

func Qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon
 */
return false
}

func Qualify_InterestRate_InflationSwap_Basis_YearOn_Year(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_InflationSwap_Basis_YearOn_Year
 */
return false
}

func Qualify_InterestRate_InflationSwap_Basis_ZeroCoupon(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_InflationSwap_Basis_ZeroCoupon
 */
return false
}

func Qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year
 */
return false
}

func Qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon
 */
return false
}

func Qualify_InterestRate_Option_DebtOption(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_Option_DebtOption
 */
return false
}

func Qualify_InterestRate_Option_Swaption(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_InterestRate_Option_Swaption
 */
return false
}

func Qualify_Novation(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Novation
 */
return false
}

func Qualify_OnDemandPayment(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_OnDemandPayment
 */
return false
}

func Qualify_OnDemandRateChange(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_OnDemandRateChange
 */
return false
}

func Qualify_OpenOfferClearedTrade(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_OpenOfferClearedTrade
 */
return false
}

func Qualify_PairOff(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_PairOff
 */
return false
}

func Qualify_PartialDelivery(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_PartialDelivery
 */
return false
}

func Qualify_PartialNovation(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_PartialNovation
 */
return false
}

func Qualify_PartialTermination(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_PartialTermination
 */
return false
}

func Qualify_PortfolioRebalancing(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_PortfolioRebalancing
 */
return false
}

func Qualify_Reallocation(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Reallocation
 */
return false
}

func Qualify_Renegotiation(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Renegotiation
 */
return false
}

func Qualify_Reprice(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Reprice
 */
return false
}

func Qualify_Repurchase(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Repurchase
 */
return false
}

func Qualify_RepurchaseAgreement(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_RepurchaseAgreement
 */
return false
}

func Qualify_Reset(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Reset
 */
return false
}

func Qualify_Roll(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Roll
 */
return false
}

func Qualify_SecurityLending(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_SecurityLending
 */
return false
}

func Qualify_SecuritySettlement(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_SecuritySettlement
 */
return false
}

func Qualify_SecurityTransfer(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_SecurityTransfer
 */
return false
}

func Qualify_Shaping(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Shaping
 */
return false
}

func Qualify_StockSplit(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_StockSplit
 */
return false
}

func Qualify_SubProduct_Basis(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_SubProduct_Basis
 */
return false
}

func Qualify_SubProduct_FixedFixed(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_SubProduct_FixedFixed
 */
return false
}

func Qualify_SubProduct_FixedFloat(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_SubProduct_FixedFloat
 */
return false
}

func Qualify_Substitution(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Substitution
 */
return false
}

func Qualify_Termination(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_Termination
 */
return false
}

func Qualify_Transaction_OIS(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_Transaction_OIS
 */
return false
}

func Qualify_Transaction_YoY(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_Transaction_YoY
 */
return false
}

func Qualify_Transaction_ZeroCoupon(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_Transaction_ZeroCoupon
 */
return false
}

func Qualify_Transaction_ZeroCoupon_KnownAmount(economicTerms EconomicTerms ) bool {    
/**
 * Function definition for Qualify_Transaction_ZeroCoupon_KnownAmount
 */
return false
}

func Qualify_UnderlierObservable_Equity(observable Observable ) bool {    
/**
 * Function definition for Qualify_UnderlierObservable_Equity
 */
return false
}

func Qualify_ValuationUpdate(businessEvent BusinessEvent ) bool {    
/**
 * Function definition for Qualify_ValuationUpdate
 */
return false
}

func QuantityDecreased(before TradeState, after *TradeState ) bool {    
/**
 * Function definition for QuantityDecreased
 */
return false
}

func QuantityDecreasedToZero(before *TradeState, after *TradeState ) bool {    
/**
 * Function definition for QuantityDecreasedToZero
 */
return false
}

func QuantityIncreased(before TradeState, after *TradeState ) bool {    
/**
 * Function definition for QuantityIncreased
 */
return false
}

func RateOfReturn(initialPrice PriceSchedule, finalPrice PriceSchedule ) float64 {    
/**
 * Function definition for RateOfReturn
 */
return 0
}

func ReplaceParty(parties *Party, oldParty Party, newParty Party ) *Party {    
/**
 * Function definition for ReplaceParty
 */
return &Party{}
}

func ReplaceTradeLot(tradeLots *TradeLot, newTradeLot TradeLot ) *TradeLot {    
/**
 * Function definition for ReplaceTradeLot
 */
return &TradeLot{}
}

func ResolveAdjustableDate(adjustableOrRelativeDate AdjustableOrRelativeDate ) *time.Time {    
/**
 * Function definition for ResolveAdjustableDate
 */
return &time.Time{}
}

func ResolveAdjustableDates(adjustableRelativeOrPeriodicDates AdjustableRelativeOrPeriodicDates ) *time.Time {    
/**
 * Function definition for ResolveAdjustableDates
 */
return &time.Time{}
}

func ResolveCashSettlementDate(tradeState TradeState ) time.Time {    
/**
 * Function definition for ResolveCashSettlementDate
 */
return time.Time{}
}

func ResolveEquityInitialPrice(price *PriceSchedule ) *PriceSchedule {    
/**
 * Function definition for ResolveEquityInitialPrice
 */
return &PriceSchedule{}
}

func ResolveInterestRateObservationIdentifiers(payout InterestRatePayout, date time.Time ) ObservationIdentifier {    
/**
 * Function definition for ResolveInterestRateObservationIdentifiers
 */
return ObservationIdentifier{}
}

func ResolveInterestRateReset(payouts InterestRatePayout, observation Observation, resetDate time.Time, rateRecordDate *time.Time ) Reset {    
/**
 * Function definition for ResolveInterestRateReset
 */
return Reset{}
}

func ResolveObservation(identifiers ObservationIdentifier, averagingMethod *AveragingCalculationMethod ) Observation {    
/**
 * Function definition for ResolveObservation
 */
return Observation{}
}

func ResolveObservationAverage(observations Observation ) Price {    
/**
 * Function definition for ResolveObservationAverage
 */
return Price{}
}

func ResolvePerformanceObservationIdentifiers(payout PerformancePayout, adjustedDate time.Time ) ObservationIdentifier {    
/**
 * Function definition for ResolvePerformanceObservationIdentifiers
 */
return ObservationIdentifier{}
}

func ResolvePerformancePeriodStartPrice(performancePayout PerformancePayout, price *PriceSchedule, observable *Observable, adjustedDate time.Time ) PriceSchedule {    
/**
 * Function definition for ResolvePerformancePeriodStartPrice
 */
return PriceSchedule{}
}

func ResolvePerformanceReset(performancePayout PerformancePayout, observation Observation, date time.Time ) Reset {    
/**
 * Function definition for ResolvePerformanceReset
 */
return Reset{}
}

func ResolvePerformanceValuationTime(valuationTime *BusinessCenterTime, valuationTimeType *TimeTypeEnum, assetIdentifier AssetIdentifier, determinationMethod DeterminationMethodEnum ) TimeZone {    
/**
 * Function definition for ResolvePerformanceValuationTime
 */
return TimeZone{}
}

func ResolveRateIndex(index FloatingRateIndexEnum ) float64 {    
/**
 * Function definition for ResolveRateIndex
 */
return 0
}

func ResolveRepurchaseTransferInstruction(tradeState TradeState, repurchaseDate time.Time ) EventInstruction {    
/**
 * Function definition for ResolveRepurchaseTransferInstruction
 */
return EventInstruction{}
}

func ResolveReset(tradeState TradeState, date time.Time ) Reset {    
/**
 * Function definition for ResolveReset
 */
return Reset{}
}

func ResolveSecurityFinanceBillingAmount(tradeState TradeState, reset Reset, recordStartDate time.Time, recordEndDate time.Time, transferDate time.Time ) Transfer {    
/**
 * Function definition for ResolveSecurityFinanceBillingAmount
 */
return Transfer{}
}

func ResolveTimeZoneFromTimeType(assetIdentifier AssetIdentifier, timeType TimeTypeEnum, determinationMethod DeterminationMethodEnum ) TimeZone {    
/**
 * Function definition for ResolveTimeZoneFromTimeType
 */
return TimeZone{}
}

func ResolveTransfer(instruction CalculateTransferInstruction ) Transfer {    
/**
 * Function definition for ResolveTransfer
 */
return Transfer{}
}

func RoundToNearest(value float64, nearest float64, roundingMode RoundingModeEnum ) float64 {    
/**
 * Function definition for RoundToNearest
 */
return 0
}

func RoundToPrecision(value float64, precision int, roundingMode RoundingDirectionEnum, removeTrailingZeros bool ) float64 {    
/**
 * Function definition for RoundToPrecision
 */
return 0
}

func RoundToSignificantFigures(value float64, significantFigures int, roundingMode RoundingDirectionEnum ) float64 {    
/**
 * Function definition for RoundToSignificantFigures
 */
return 0
}

func SecurityFinanceCashSettlementAmount(tradeState TradeState, date time.Time, quantity *Quantity, payerReceiver *PayerReceiver ) Transfer {    
/**
 * Function definition for SecurityFinanceCashSettlementAmount
 */
return Transfer{}
}

func SetCashCurrency(cash *Cash, currency CurrencyCodeEnum ) Cash {    
/**
 * Function definition for SetCashCurrency
 */
return Cash{}
}

func SettlementPayoutOnlyExists(payouts *Payout ) bool {    
/**
 * Function definition for SettlementPayoutOnlyExists
 */
return false
}

func SpreadAmount(interestRatePayout InterestRatePayout, calculationPeriod CalculationPeriodBase ) *float64 {    
/**
 * Function definition for SpreadAmount
 */
return 0
}

func StandardizedScheduleAssetClass(trade Trade ) *StandardizedScheduleAssetClassEnum {    
/**
 * Function definition for StandardizedScheduleAssetClass
 */
return &StandardizedScheduleAssetClassEnum{}
}

func StandardizedScheduleCommodityForwardNotionalAmount(economicTerms *EconomicTerms ) *float64 {    
/**
 * Function definition for StandardizedScheduleCommodityForwardNotionalAmount
 */
return 0
}

func StandardizedScheduleCommoditySwapFixedFloatNotionalAmount(economicTerms *EconomicTerms ) *float64 {    
/**
 * Function definition for StandardizedScheduleCommoditySwapFixedFloatNotionalAmount
 */
return 0
}

func StandardizedScheduleDuration(trade Trade, assetClass StandardizedScheduleAssetClassEnum, productClass StandardizedScheduleProductClassEnum ) *float64 {    
/**
 * Function definition for StandardizedScheduleDuration
 */
return 0
}

func StandardizedScheduleEquityForwardNotionalAmount(settlementPayout *SettlementPayout ) *float64 {    
/**
 * Function definition for StandardizedScheduleEquityForwardNotionalAmount
 */
return 0
}

func StandardizedScheduleFXSwapNotional(farLeg *SettlementPayout, tradeLot *TradeLot ) *NonNegativeQuantitySchedule {    
/**
 * Function definition for StandardizedScheduleFXSwapNotional
 */
return &NonNegativeQuantitySchedule{}
}

func StandardizedScheduleFXVarianceNotionalAmount(performancePayout *PerformancePayout ) *float64 {    
/**
 * Function definition for StandardizedScheduleFXVarianceNotionalAmount
 */
return 0
}

func StandardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ(priceQuantity *ResolvablePriceQuantity ) *string {    
/**
 * Function definition for StandardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ
 */
return &string{}
}

func StandardizedScheduleMonetaryNotionalFromResolvablePQ(priceQuantity *ResolvablePriceQuantity ) *float64 {    
/**
 * Function definition for StandardizedScheduleMonetaryNotionalFromResolvablePQ
 */
return 0
}

func StandardizedScheduleNotional(trade Trade, assetClass StandardizedScheduleAssetClassEnum, productClass StandardizedScheduleProductClassEnum ) *float64 {    
/**
 * Function definition for StandardizedScheduleNotional
 */
return 0
}

func StandardizedScheduleNotionalCurrency(trade Trade, assetClass StandardizedScheduleAssetClassEnum, productClass StandardizedScheduleProductClassEnum ) *string {    
/**
 * Function definition for StandardizedScheduleNotionalCurrency
 */
return &string{}
}

func StandardizedScheduleOptionNotionalAmount(optionPayout *OptionPayout ) *float64 {    
/**
 * Function definition for StandardizedScheduleOptionNotionalAmount
 */
return 0
}

func StandardizedScheduleProductClass(trade Trade ) *StandardizedScheduleProductClassEnum {    
/**
 * Function definition for StandardizedScheduleProductClass
 */
return &StandardizedScheduleProductClassEnum{}
}

func StandardizedScheduleVarianceSwapNotionalAmount(performancePayout *PerformancePayout ) *float64 {    
/**
 * Function definition for StandardizedScheduleVarianceSwapNotionalAmount
 */
return 0
}

func TimeZoneFromBusinessCenterTime(time BusinessCenterTime ) TimeZone {    
/**
 * Function definition for TimeZoneFromBusinessCenterTime
 */
return TimeZone{}
}

func ToDateTime(date *time.Time ) *time.Time {    
/**
 * Function definition for ToDateTime
 */
return &time.Time{}
}

func ToMoney(quantity Quantity ) Money {    
/**
 * Function definition for ToMoney
 */
return Money{}
}

func ToTime(hours int, minutes int, seconds int ) time.Time {    
/**
 * Function definition for ToTime
 */
return time.Time{}
}

func Today() time.Time {    
/**
 * Function definition for Today
 */
return time.Time{}
}

func TradeNoExecutionDetails(trade Trade ) Trade {    
/**
 * Function definition for TradeNoExecutionDetails
 */
return Trade{}
}

func TransfersForDate(transfers *Transfer, date time.Time ) *Transfer {    
/**
 * Function definition for TransfersForDate
 */
return &Transfer{}
}

func UnderlierForProduct(product NonTransferableProduct ) Underlier {    
/**
 * Function definition for UnderlierForProduct
 */
return Underlier{}
}

func UnderlierQualification(underlier Underlier, securityType *InstrumentTypeEnum, assetClass *AssetClassEnum ) bool {    
/**
 * Function definition for UnderlierQualification
 */
return false
}

func UpdateAmountForEachMatchingQuantity(priceQuantity PriceQuantity, change PriceQuantity, direction QuantityChangeDirectionEnum ) PriceQuantity {    
/**
 * Function definition for UpdateAmountForEachMatchingQuantity
 */
return PriceQuantity{}
}

func UpdateAmountForEachQuantity(priceQuantity *PriceQuantity, amount float64 ) *PriceQuantity {    
/**
 * Function definition for UpdateAmountForEachQuantity
 */
return &PriceQuantity{}
}

func UpdateIndexTransitionPriceAndRateOption(priceQuantity PriceQuantity, instruction *PriceQuantity ) PriceQuantity {    
/**
 * Function definition for UpdateIndexTransitionPriceAndRateOption
 */
return PriceQuantity{}
}

func UpdateSpreadAdjustmentAndRateOptions(tradeState TradeState, instructions PriceQuantity ) TradeState {    
/**
 * Function definition for UpdateSpreadAdjustmentAndRateOptions
 */
return TradeState{}
}

func Update_ProductDirection(before NonTransferableProduct, originalPayer CounterpartyRoleEnum, originalReceiver CounterpartyRoleEnum ) NonTransferableProduct {    
/**
 * Function definition for Update_ProductDirection
 */
return NonTransferableProduct{}
}

func VectorGrowthOperation(baseValue float64, factor *float64 ) *float64 {    
/**
 * Function definition for VectorGrowthOperation
 */
return 0
}

func VectorOperation(arithmeticOp ArithmeticOperationEnum, left *float64, right *float64 ) *float64 {    
/**
 * Function definition for VectorOperation
 */
return 0
}

func VectorScalarOperation(arithmeticOp ArithmeticOperationEnum, left *float64, right *float64 ) *float64 {    
/**
 * Function definition for VectorScalarOperation
 */
return 0
}

func YearFraction(dayCountFractionEnum DayCountFractionEnum, startDate time.Time, endDate time.Time, terminationDate *time.Time, periodsInYear *int ) float64 {    
/**
 * Function definition for YearFraction
 */
return 0
}

func YearFractionForOneDay(dcf DayCountFractionEnum ) float64 {    
/**
 * Function definition for YearFractionForOneDay
 */
return 0
}

