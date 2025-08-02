package cdm.event.common.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.QuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.functions.FilterQuantityByFinancialUnit;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.functions.ExtractCounterpartyByRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.CollateralPortfolio;
import cdm.event.common.CollateralPosition;
import cdm.event.common.Reset;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.Transfer.TransferBuilder;
import cdm.event.common.metafields.ReferenceWithMetaCollateralPortfolio;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.asset.functions.FixedAmount;
import cdm.product.asset.functions.FloatingAmount;
import cdm.product.collateral.Collateral;
import cdm.product.collateral.CollateralProvisions;
import cdm.product.collateral.CollateralTreatment;
import cdm.product.collateral.CollateralValuationTreatment;
import cdm.product.collateral.EligibleCollateralCriteria;
import cdm.product.common.schedule.CalculationPeriodData;
import cdm.product.common.schedule.functions.CalculationPeriodRange;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.AssetPayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.TradeLot;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(ResolveSecurityFinanceBillingAmount.ResolveSecurityFinanceBillingAmountDefault.class)
public abstract class ResolveSecurityFinanceBillingAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CalculationPeriodRange calculationPeriodRange0;
	@Inject protected ExtractCounterpartyByRole extractCounterpartyByRole;
	@Inject protected FilterQuantityByFinancialUnit filterQuantityByFinancialUnit;
	@Inject protected FixedAmount fixedAmount;
	@Inject protected FloatingAmount floatingAmount;
	@Inject protected ProductDeepPathUtil productDeepPathUtil;

	/**
	* @param tradeState 
	* @param reset 
	* @param recordStartDate 
	* @param recordEndDate 
	* @param transferDate 
	* @return transfer 
	*/
	public Transfer evaluate(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
		Transfer.TransferBuilder transferBuilder = doEvaluate(tradeState, reset, recordStartDate, recordEndDate, transferDate);
		
		final Transfer transfer;
		if (transferBuilder == null) {
			transfer = null;
		} else {
			transfer = transferBuilder.build();
			objectValidator.validate(Transfer.class, transfer);
		}
		
		return transfer;
	}

	protected abstract Transfer.TransferBuilder doEvaluate(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate);

	protected abstract MapperS<? extends QuantitySchedule> securityQuantity(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate);

	protected abstract MapperS<? extends InterestRatePayout> interestRatePayout(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate);

	protected abstract MapperS<? extends AssetPayout> assetPayout(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate);

	protected abstract MapperS<? extends Collateral> collateral(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate);

	protected abstract MapperS<BigDecimal> haircutPercentage(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate);

	protected abstract MapperS<BigDecimal> valuationPercentage(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate);

	protected abstract MapperS<BigDecimal> marginRatio(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate);

	protected abstract MapperS<BigDecimal> billingQuantity(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate);

	protected abstract MapperS<? extends CalculationPeriodData> calculationPeriodRange1(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate);

	protected abstract MapperS<BigDecimal> performance(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate);

	protected abstract MapperS<? extends ReferenceWithMetaParty> payerPartyReference(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate);

	protected abstract MapperS<? extends ReferenceWithMetaParty> receiverPartyReference(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate);

	public static class ResolveSecurityFinanceBillingAmountDefault extends ResolveSecurityFinanceBillingAmount {
		@Override
		protected Transfer.TransferBuilder doEvaluate(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
			Transfer.TransferBuilder transfer = Transfer.builder();
			return assignOutput(transfer, tradeState, reset, recordStartDate, recordEndDate, transferDate);
		}
		
		protected Transfer.TransferBuilder assignOutput(Transfer.TransferBuilder transfer, TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
			transfer
				.getOrCreateQuantity()
				.setValue(performance(tradeState, reset, recordStartDate, recordEndDate, transferDate).get());
			
			final FieldWithMetaString fieldWithMetaString = interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).<ResolvablePriceQuantity>map("getPriceQuantity", _interestRatePayout -> _interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
			transfer
				.getOrCreateQuantity()
				.getOrCreateUnit()
				.setCurrencyValue((fieldWithMetaString == null ? null : fieldWithMetaString.getValue()));
			
			final Party ifThenElseResult0;
			if (greaterThanEquals(performance(tradeState, reset, recordStartDate, recordEndDate, transferDate), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty0 = payerPartyReference(tradeState, reset, recordStartDate, recordEndDate, transferDate).get();
				ifThenElseResult0 = referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue();
			} else {
				final ReferenceWithMetaParty referenceWithMetaParty1 = receiverPartyReference(tradeState, reset, recordStartDate, recordEndDate, transferDate).get();
				ifThenElseResult0 = referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue();
			}
			transfer
				.getOrCreatePayerReceiver()
				.setPayerPartyReferenceValue(ifThenElseResult0);
			
			final Party ifThenElseResult1;
			if (greaterThanEquals(performance(tradeState, reset, recordStartDate, recordEndDate, transferDate), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty2 = receiverPartyReference(tradeState, reset, recordStartDate, recordEndDate, transferDate).get();
				ifThenElseResult1 = referenceWithMetaParty2 == null ? null : referenceWithMetaParty2.getValue();
			} else {
				final ReferenceWithMetaParty referenceWithMetaParty3 = payerPartyReference(tradeState, reset, recordStartDate, recordEndDate, transferDate).get();
				ifThenElseResult1 = referenceWithMetaParty3 == null ? null : referenceWithMetaParty3.getValue();
			}
			transfer
				.getOrCreatePayerReceiver()
				.setReceiverPartyReferenceValue(ifThenElseResult1);
			
			transfer
				.getOrCreateSettlementDate()
				.setAdjustedDateValue(transferDate);
			
			return Optional.ofNullable(transfer)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends QuantitySchedule> securityQuantity(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
			return MapperS.of(MapperC.of(filterQuantityByFinancialUnit.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<QuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).getMulti(), FinancialUnitEnum.SHARE)).get());
		}
		
		@Override
		protected MapperS<? extends InterestRatePayout> interestRatePayout(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
			return MapperS.of(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).get());
		}
		
		@Override
		protected MapperS<? extends AssetPayout> assetPayout(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
			return MapperS.of(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Collateral>map("getCollateral", economicTerms -> economicTerms.getCollateral()).<ReferenceWithMetaCollateralPortfolio>mapC("getCollateralPortfolio", _collateral -> _collateral.getCollateralPortfolio()).<CollateralPortfolio>map("Type coercion", referenceWithMetaCollateralPortfolio -> referenceWithMetaCollateralPortfolio.getValue()).<CollateralPosition>mapC("getCollateralPosition", collateralPortfolio -> collateralPortfolio.getCollateralPosition()).<Product>map("getProduct", collateralPosition -> collateralPosition.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<AssetPayout>map("getAssetPayout", payout -> payout.getAssetPayout()).get());
		}
		
		@Override
		protected MapperS<? extends Collateral> collateral(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
			return MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Collateral>map("getCollateral", economicTerms -> economicTerms.getCollateral());
		}
		
		@Override
		protected MapperS<BigDecimal> haircutPercentage(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
			return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperS.of(new BigDecimal("1.0")), MapperS.of(collateral(tradeState, reset, recordStartDate, recordEndDate, transferDate).<CollateralProvisions>map("getCollateralProvisions", _collateral -> _collateral.getCollateralProvisions()).<EligibleCollateralCriteria>mapC("getEligibleCollateral", collateralProvisions -> collateralProvisions.getEligibleCollateral()).get()).<CollateralTreatment>map("getTreatment", eligibleCollateralCriteria -> eligibleCollateralCriteria.getTreatment()).<CollateralValuationTreatment>map("getValuationTreatment", collateralTreatment -> collateralTreatment.getValuationTreatment()).<BigDecimal>map("getHaircutPercentage", collateralValuationTreatment -> collateralValuationTreatment.getHaircutPercentage()));
		}
		
		@Override
		protected MapperS<BigDecimal> valuationPercentage(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
			return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(BigDecimal.valueOf(1)), haircutPercentage(tradeState, reset, recordStartDate, recordEndDate, transferDate));
		}
		
		@Override
		protected MapperS<BigDecimal> marginRatio(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
			if (exists(MapperS.of(collateral(tradeState, reset, recordStartDate, recordEndDate, transferDate).<CollateralProvisions>map("getCollateralProvisions", _collateral -> _collateral.getCollateralProvisions()).<EligibleCollateralCriteria>mapC("getEligibleCollateral", collateralProvisions -> collateralProvisions.getEligibleCollateral()).get()).<CollateralTreatment>map("getTreatment", eligibleCollateralCriteria -> eligibleCollateralCriteria.getTreatment()).<CollateralValuationTreatment>map("getValuationTreatment", collateralTreatment -> collateralTreatment.getValuationTreatment()).<BigDecimal>map("getHaircutPercentage", collateralValuationTreatment -> collateralValuationTreatment.getHaircutPercentage())).getOrDefault(false)) {
				return valuationPercentage(tradeState, reset, recordStartDate, recordEndDate, transferDate);
			}
			if (exists(MapperS.of(collateral(tradeState, reset, recordStartDate, recordEndDate, transferDate).<CollateralProvisions>map("getCollateralProvisions", _collateral -> _collateral.getCollateralProvisions()).<EligibleCollateralCriteria>mapC("getEligibleCollateral", collateralProvisions -> collateralProvisions.getEligibleCollateral()).get()).<CollateralTreatment>map("getTreatment", eligibleCollateralCriteria -> eligibleCollateralCriteria.getTreatment()).<CollateralValuationTreatment>map("getValuationTreatment", collateralTreatment -> collateralTreatment.getValuationTreatment()).<BigDecimal>map("getMarginPercentage", collateralValuationTreatment -> collateralValuationTreatment.getMarginPercentage())).getOrDefault(false)) {
				return MapperS.of(collateral(tradeState, reset, recordStartDate, recordEndDate, transferDate).<CollateralProvisions>map("getCollateralProvisions", _collateral -> _collateral.getCollateralProvisions()).<EligibleCollateralCriteria>mapC("getEligibleCollateral", collateralProvisions -> collateralProvisions.getEligibleCollateral()).get()).<CollateralTreatment>map("getTreatment", eligibleCollateralCriteria -> eligibleCollateralCriteria.getTreatment()).<CollateralValuationTreatment>map("getValuationTreatment", collateralTreatment -> collateralTreatment.getValuationTreatment()).<BigDecimal>map("getMarginPercentage", collateralValuationTreatment -> collateralValuationTreatment.getMarginPercentage());
			}
			return MapperS.of(new BigDecimal("1.0"));
		}
		
		@Override
		protected MapperS<BigDecimal> billingQuantity(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
			return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(reset).<Price>map("getResetValue", _reset -> _reset.getResetValue()).<BigDecimal>map("getValue", price -> price.getValue()), securityQuantity(tradeState, reset, recordStartDate, recordEndDate, transferDate).<BigDecimal>map("getValue", quantitySchedule -> quantitySchedule.getValue())), marginRatio(tradeState, reset, recordStartDate, recordEndDate, transferDate));
		}
		
		@Override
		protected MapperS<? extends CalculationPeriodData> calculationPeriodRange1(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
			return MapperS.of(calculationPeriodRange0.evaluate(recordStartDate, recordEndDate, null));
		}
		
		@Override
		protected MapperS<BigDecimal> performance(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
			if (exists(interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification())).getOrDefault(false)) {
				return MapperS.of(fixedAmount.evaluate(interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get(), billingQuantity(tradeState, reset, recordStartDate, recordEndDate, transferDate).get(), recordEndDate, calculationPeriodRange1(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()));
			}
			if (exists(interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).getOrDefault(false)) {
				return MapperS.of(floatingAmount.evaluate(interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get(), MapperS.of(reset).<Price>map("getResetValue", _reset -> _reset.getResetValue()).<BigDecimal>map("getValue", price -> price.getValue()).get(), billingQuantity(tradeState, reset, recordStartDate, recordEndDate, transferDate).get(), recordEndDate, calculationPeriodRange1(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()));
			}
			return MapperS.<BigDecimal>ofNull();
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaParty> payerPartyReference(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
			return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).<PayerReceiver>map("getPayerReceiver", _interestRatePayout -> _interestRatePayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference());
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaParty> receiverPartyReference(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
			return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).<PayerReceiver>map("getPayerReceiver", _interestRatePayout -> _interestRatePayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", payerReceiver -> payerReceiver.getReceiver()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference());
		}
	}
}
