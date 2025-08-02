package cdm.margin.schedule.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.event.common.Trade;
import cdm.margin.schedule.StandardizedScheduleAssetClassEnum;
import cdm.margin.schedule.StandardizedScheduleProductClassEnum;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.asset.VarianceReturnTerms;
import cdm.product.common.settlement.FixedPrice;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.EconomicTerms;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionStrike;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Product;
import cdm.product.template.ReturnTerms;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(StandardizedScheduleNotionalCurrency.StandardizedScheduleNotionalCurrencyDefault.class)
public abstract class StandardizedScheduleNotionalCurrency implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected FXFarLeg fXFarLeg;
	@Inject protected ProductDeepPathUtil productDeepPathUtil;
	@Inject protected StandardizedScheduleFXSwapNotional standardizedScheduleFXSwapNotional;
	@Inject protected StandardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ standardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param trade 
	* @param assetClass 
	* @param productClass 
	* @return notionalCurrency 
	*/
	public String evaluate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
		String notionalCurrency = doEvaluate(trade, assetClass, productClass);
		
		// post-conditions
		conditionValidator.validate(() -> exists(MapperS.of(notionalCurrency).checkedMap("to-enum", ISOCurrencyCodeEnum::fromDisplayName, IllegalArgumentException.class)),
			"Ensure Currency is an ISO 3-Letter Currency Code ");
		
		return notionalCurrency;
	}

	protected abstract String doEvaluate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<? extends NonTransferableProduct> product(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	public static class StandardizedScheduleNotionalCurrencyDefault extends StandardizedScheduleNotionalCurrency {
		@Override
		protected String doEvaluate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			String notionalCurrency = null;
			return assignOutput(notionalCurrency, trade, assetClass, productClass);
		}
		
		protected String assignOutput(String notionalCurrency, Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.INTEREST_RATES), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAP), CardinalityOperator.All).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAP_WITH_CALLABLE_BERMUDAN_RIGHT_TO_ENTER_EXIT_SWAPS), CardinalityOperator.All)).getOrDefault(false)) {
					final MapperC<InterestRatePayout> thenArg0 = economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
						.filterItemNullSafe(item -> exists(item.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule())).get());
					final MapperS<InterestRatePayout> thenArg1 = thenArg0
						.first();
					final MapperS<ResolvablePriceQuantity> thenArg2 = thenArg1.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity());
					notionalCurrency = MapperS.of(standardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ.evaluate(thenArg2.get())).get();
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.CROSS_CURRENCY_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					final MapperC<InterestRatePayout> thenArg3 = economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
						.filterItemNullSafe(item -> true);
					final MapperS<InterestRatePayout> thenArg4 = thenArg3
						.first();
					final MapperS<ResolvablePriceQuantity> thenArg5 = thenArg4.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity());
					notionalCurrency = MapperS.of(standardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ.evaluate(thenArg5.get())).get();
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAPTION), CardinalityOperator.All).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAPTION_STRADDLE), CardinalityOperator.All)).getOrDefault(false)) {
					final MapperC<InterestRatePayout> thenArg6 = MapperS.of(underlierForProduct.evaluate(product(trade, assetClass, productClass).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
						.filterItemNullSafe(item -> exists(item.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule())).get());
					final MapperS<InterestRatePayout> thenArg7 = thenArg6
						.first();
					final MapperS<ResolvablePriceQuantity> thenArg8 = thenArg7.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity());
					notionalCurrency = MapperS.of(standardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ.evaluate(thenArg8.get())).get();
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.OPTION), CardinalityOperator.All).getOrDefault(false)) {
					final MapperS<ResolvablePriceQuantity> thenArg9 = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity());
					notionalCurrency = MapperS.of(standardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ.evaluate(thenArg9.get())).get();
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.FORWARD_RATE_AGREEMENT), CardinalityOperator.All).getOrDefault(false)) {
					final MapperC<InterestRatePayout> thenArg10 = economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
						.filterItemNullSafe(item -> exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification())).get());
					final MapperS<InterestRatePayout> thenArg11 = MapperS.of(thenArg10.get());
					final MapperS<ResolvablePriceQuantity> thenArg12 = thenArg11.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity());
					notionalCurrency = MapperS.of(standardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ.evaluate(thenArg12.get())).get();
				} else {
					notionalCurrency = null;
				}
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.CREDIT), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SINGLE_NAME_CREDIT_DEFAULT_SWAP), CardinalityOperator.All).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.INDEX_CDS), CardinalityOperator.All)).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.INDEX_TRANCHE), CardinalityOperator.All)).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.CREDIT_NTH_TO_DEFAULT), CardinalityOperator.All)).getOrDefault(false)) {
					final MapperS<ResolvablePriceQuantity> thenArg13 = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", creditDefaultPayout -> creditDefaultPayout.getPriceQuantity());
					notionalCurrency = MapperS.of(standardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ.evaluate(thenArg13.get())).get();
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAPTION), CardinalityOperator.All).getOrDefault(false)) {
					final MapperS<ResolvablePriceQuantity> thenArg14 = MapperS.of(MapperS.of(underlierForProduct.evaluate(product(trade, assetClass, productClass).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", creditDefaultPayout -> creditDefaultPayout.getPriceQuantity());
					notionalCurrency = MapperS.of(standardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ.evaluate(thenArg14.get())).get();
				} else {
					notionalCurrency = null;
				}
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.DELIVERABLE_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString0 = MapperS.of(standardizedScheduleFXSwapNotional.evaluate(fXFarLeg.evaluate(product(trade, assetClass, productClass).get()), MapperS.of(trade).<TradeLot>mapC("getTradeLot", _trade -> _trade.getTradeLot()).get())).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					if (fieldWithMetaString0 == null) {
						notionalCurrency = null;
					} else {
						notionalCurrency = fieldWithMetaString0.getValue();
					}
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.NON_DELIVERABLE_CROSS_CURRENCY_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notionalCurrency = "AAA";
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.DELIVERABLE_FORWARD), CardinalityOperator.All).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString1 = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					if (fieldWithMetaString1 == null) {
						notionalCurrency = null;
					} else {
						notionalCurrency = fieldWithMetaString1.getValue();
					}
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.NON_DELIVERABLE_FORWARD), CardinalityOperator.All).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString2 = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					if (fieldWithMetaString2 == null) {
						notionalCurrency = null;
					} else {
						notionalCurrency = fieldWithMetaString2.getValue();
					}
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.DELIVERABLE_OPTION), CardinalityOperator.All).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString3 = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule2 -> referenceWithMetaNonNegativeQuantitySchedule2 == null ? null : referenceWithMetaNonNegativeQuantitySchedule2.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					if (fieldWithMetaString3 == null) {
						notionalCurrency = null;
					} else {
						notionalCurrency = fieldWithMetaString3.getValue();
					}
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.NON_DELIVERABLE_OPTION), CardinalityOperator.All).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString4 = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule3 -> referenceWithMetaNonNegativeQuantitySchedule3 == null ? null : referenceWithMetaNonNegativeQuantitySchedule3.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					if (fieldWithMetaString4 == null) {
						notionalCurrency = null;
					} else {
						notionalCurrency = fieldWithMetaString4.getValue();
					}
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.VARIANCE_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString5 = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<ReturnTerms>map("getReturnTerms", performancePayout -> performancePayout.getReturnTerms()).<VarianceReturnTerms>map("getVarianceReturnTerms", returnTerms -> returnTerms.getVarianceReturnTerms()).<Price>map("getVarianceStrikePrice", varianceReturnTerms -> varianceReturnTerms.getVarianceStrikePrice()).<UnitType>map("getUnit", price -> price.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					if (fieldWithMetaString5 == null) {
						notionalCurrency = null;
					} else {
						notionalCurrency = fieldWithMetaString5.getValue();
					}
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.VOLATILITY_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notionalCurrency = "AAA";
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.CORRELATION_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notionalCurrency = "AAA";
				} else {
					notionalCurrency = null;
				}
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.EQUITY), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.OPTION), CardinalityOperator.All).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString6 = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice()).<UnitType>map("getUnit", price -> price.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					if (fieldWithMetaString6 == null) {
						notionalCurrency = null;
					} else {
						notionalCurrency = fieldWithMetaString6.getValue();
					}
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.FORWARD), CardinalityOperator.All).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString7 = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule4 -> referenceWithMetaNonNegativeQuantitySchedule4 == null ? null : referenceWithMetaNonNegativeQuantitySchedule4.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					if (fieldWithMetaString7 == null) {
						notionalCurrency = null;
					} else {
						notionalCurrency = fieldWithMetaString7.getValue();
					}
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.DIVIDEND_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notionalCurrency = "AAA";
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.VARIANCE_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString8 = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<ReturnTerms>map("getReturnTerms", performancePayout -> performancePayout.getReturnTerms()).<VarianceReturnTerms>map("getVarianceReturnTerms", returnTerms -> returnTerms.getVarianceReturnTerms()).<Price>map("getVolatilityStrikePrice", varianceReturnTerms -> varianceReturnTerms.getVolatilityStrikePrice()).<UnitType>map("getUnit", price -> price.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					if (fieldWithMetaString8 == null) {
						notionalCurrency = null;
					} else {
						notionalCurrency = fieldWithMetaString8.getValue();
					}
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.VOLATILITY_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notionalCurrency = "AAA";
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAPS_AND_PORTFOLIO_SWAPS), CardinalityOperator.All).getOrDefault(false)) {
					notionalCurrency = "AAA";
				} else {
					notionalCurrency = null;
				}
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.COMMODITY), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.FORWARD), CardinalityOperator.All).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString9 = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<FixedPricePayout>map("getFixedPricePayout", payout -> payout.getFixedPricePayout()).get()).<FixedPrice>map("getFixedPrice", fixedPricePayout -> fixedPricePayout.getFixedPrice()).<ReferenceWithMetaPriceSchedule>map("getPrice", fixedPrice -> fixedPrice.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule0 -> referenceWithMetaPriceSchedule0 == null ? null : referenceWithMetaPriceSchedule0.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					if (fieldWithMetaString9 == null) {
						notionalCurrency = null;
					} else {
						notionalCurrency = fieldWithMetaString9.getValue();
					}
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.OPTION), CardinalityOperator.All).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString10 = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice()).<UnitType>map("getUnit", price -> price.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					if (fieldWithMetaString10 == null) {
						notionalCurrency = null;
					} else {
						notionalCurrency = fieldWithMetaString10.getValue();
					}
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.FIXED_FLOAT_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString11 = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<FixedPricePayout>map("getFixedPricePayout", payout -> payout.getFixedPricePayout()).get()).<FixedPrice>map("getFixedPrice", fixedPricePayout -> fixedPricePayout.getFixedPrice()).<ReferenceWithMetaPriceSchedule>map("getPrice", fixedPrice -> fixedPrice.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule1 -> referenceWithMetaPriceSchedule1 == null ? null : referenceWithMetaPriceSchedule1.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					if (fieldWithMetaString11 == null) {
						notionalCurrency = null;
					} else {
						notionalCurrency = fieldWithMetaString11.getValue();
					}
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.BASIS_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notionalCurrency = "AAA";
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAPTION), CardinalityOperator.All).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString12 = MapperS.of(MapperS.of(underlierForProduct.evaluate(product(trade, assetClass, productClass).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<FixedPricePayout>map("getFixedPricePayout", payout -> payout.getFixedPricePayout()).get()).<FixedPrice>map("getFixedPrice", fixedPricePayout -> fixedPricePayout.getFixedPrice()).<ReferenceWithMetaPriceSchedule>map("getPrice", fixedPrice -> fixedPrice.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule2 -> referenceWithMetaPriceSchedule2 == null ? null : referenceWithMetaPriceSchedule2.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					if (fieldWithMetaString12 == null) {
						notionalCurrency = null;
					} else {
						notionalCurrency = fieldWithMetaString12.getValue();
					}
				} else {
					notionalCurrency = null;
				}
			} else {
				notionalCurrency = null;
			}
			
			return notionalCurrency;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			return MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct());
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			return product(trade, assetClass, productClass).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
	}
}
