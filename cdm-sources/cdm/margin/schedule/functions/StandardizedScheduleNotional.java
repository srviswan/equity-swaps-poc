package cdm.margin.schedule.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.event.common.Trade;
import cdm.margin.schedule.StandardizedScheduleAssetClassEnum;
import cdm.margin.schedule.StandardizedScheduleProductClassEnum;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(StandardizedScheduleNotional.StandardizedScheduleNotionalDefault.class)
public abstract class StandardizedScheduleNotional implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected FXFarLeg fXFarLeg;
	@Inject protected ProductDeepPathUtil productDeepPathUtil;
	@Inject protected StandardizedScheduleCommodityForwardNotionalAmount standardizedScheduleCommodityForwardNotionalAmount;
	@Inject protected StandardizedScheduleCommoditySwapFixedFloatNotionalAmount standardizedScheduleCommoditySwapFixedFloatNotionalAmount;
	@Inject protected StandardizedScheduleEquityForwardNotionalAmount standardizedScheduleEquityForwardNotionalAmount;
	@Inject protected StandardizedScheduleFXSwapNotional standardizedScheduleFXSwapNotional;
	@Inject protected StandardizedScheduleFXVarianceNotionalAmount standardizedScheduleFXVarianceNotionalAmount;
	@Inject protected StandardizedScheduleMonetaryNotionalFromResolvablePQ standardizedScheduleMonetaryNotionalFromResolvablePQ;
	@Inject protected StandardizedScheduleOptionNotionalAmount standardizedScheduleOptionNotionalAmount;
	@Inject protected StandardizedScheduleVarianceSwapNotionalAmount standardizedScheduleVarianceSwapNotionalAmount;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param trade 
	* @param assetClass 
	* @param productClass 
	* @return notional 
	*/
	public BigDecimal evaluate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
		BigDecimal notional = doEvaluate(trade, assetClass, productClass);
		
		// post-conditions
		conditionValidator.validate(() -> greaterThan(MapperS.of(notional), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All),
			"Ensure notional is greater than 0");
		
		return notional;
	}

	protected abstract BigDecimal doEvaluate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<? extends NonTransferableProduct> product(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	public static class StandardizedScheduleNotionalDefault extends StandardizedScheduleNotional {
		@Override
		protected BigDecimal doEvaluate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			BigDecimal notional = null;
			return assignOutput(notional, trade, assetClass, productClass);
		}
		
		protected BigDecimal assignOutput(BigDecimal notional, Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.INTEREST_RATES), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAP), CardinalityOperator.All).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAP_WITH_CALLABLE_BERMUDAN_RIGHT_TO_ENTER_EXIT_SWAPS), CardinalityOperator.All)).getOrDefault(false)) {
					final MapperC<InterestRatePayout> thenArg0 = economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
						.filterItemNullSafe(item -> exists(item.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule())).get());
					final MapperS<InterestRatePayout> thenArg1 = thenArg0
						.first();
					final MapperS<ResolvablePriceQuantity> thenArg2 = thenArg1.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity());
					notional = MapperS.of(standardizedScheduleMonetaryNotionalFromResolvablePQ.evaluate(thenArg2.get())).get();
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.CROSS_CURRENCY_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					final MapperC<InterestRatePayout> thenArg3 = economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
						.filterItemNullSafe(item -> true);
					final MapperS<InterestRatePayout> thenArg4 = thenArg3
						.first();
					final MapperS<ResolvablePriceQuantity> thenArg5 = thenArg4.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity());
					notional = MapperS.of(standardizedScheduleMonetaryNotionalFromResolvablePQ.evaluate(thenArg5.get())).get();
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAPTION), CardinalityOperator.All).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAPTION_STRADDLE), CardinalityOperator.All)).getOrDefault(false)) {
					final MapperC<InterestRatePayout> thenArg6 = MapperS.of(underlierForProduct.evaluate(product(trade, assetClass, productClass).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
						.filterItemNullSafe(item -> exists(item.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule())).get());
					final MapperS<InterestRatePayout> thenArg7 = thenArg6
						.first();
					final MapperS<ResolvablePriceQuantity> thenArg8 = thenArg7.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity());
					notional = MapperS.of(standardizedScheduleMonetaryNotionalFromResolvablePQ.evaluate(thenArg8.get())).get();
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.OPTION), CardinalityOperator.All).getOrDefault(false)) {
					final MapperS<ResolvablePriceQuantity> thenArg9 = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity());
					notional = MapperS.of(standardizedScheduleMonetaryNotionalFromResolvablePQ.evaluate(thenArg9.get())).get();
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.FORWARD_RATE_AGREEMENT), CardinalityOperator.All).getOrDefault(false)) {
					final MapperC<InterestRatePayout> thenArg10 = economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
						.filterItemNullSafe(item -> exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification())).get());
					final MapperS<InterestRatePayout> thenArg11 = MapperS.of(thenArg10.get());
					final MapperS<ResolvablePriceQuantity> thenArg12 = thenArg11.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity());
					notional = MapperS.of(standardizedScheduleMonetaryNotionalFromResolvablePQ.evaluate(thenArg12.get())).get();
				} else {
					notional = null;
				}
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.CREDIT), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SINGLE_NAME_CREDIT_DEFAULT_SWAP), CardinalityOperator.All).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.INDEX_CDS), CardinalityOperator.All)).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.INDEX_TRANCHE), CardinalityOperator.All)).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.CREDIT_NTH_TO_DEFAULT), CardinalityOperator.All)).getOrDefault(false)) {
					final MapperS<ResolvablePriceQuantity> thenArg13 = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", creditDefaultPayout -> creditDefaultPayout.getPriceQuantity());
					notional = MapperS.of(standardizedScheduleMonetaryNotionalFromResolvablePQ.evaluate(thenArg13.get())).get();
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAPTION), CardinalityOperator.All).getOrDefault(false)) {
					final MapperS<ResolvablePriceQuantity> thenArg14 = MapperS.of(MapperS.of(underlierForProduct.evaluate(product(trade, assetClass, productClass).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", creditDefaultPayout -> creditDefaultPayout.getPriceQuantity());
					notional = MapperS.of(standardizedScheduleMonetaryNotionalFromResolvablePQ.evaluate(thenArg14.get())).get();
				} else {
					notional = null;
				}
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.DELIVERABLE_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notional = MapperS.of(standardizedScheduleFXSwapNotional.evaluate(fXFarLeg.evaluate(product(trade, assetClass, productClass).get()), MapperS.of(trade).<TradeLot>mapC("getTradeLot", _trade -> _trade.getTradeLot()).get())).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get();
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.NON_DELIVERABLE_CROSS_CURRENCY_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notional = new BigDecimal("0.0");
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.DELIVERABLE_FORWARD), CardinalityOperator.All).getOrDefault(false)) {
					notional = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get();
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.NON_DELIVERABLE_FORWARD), CardinalityOperator.All).getOrDefault(false)) {
					notional = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get();
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.DELIVERABLE_OPTION), CardinalityOperator.All).getOrDefault(false)) {
					notional = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule2 -> referenceWithMetaNonNegativeQuantitySchedule2 == null ? null : referenceWithMetaNonNegativeQuantitySchedule2.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get();
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.NON_DELIVERABLE_OPTION), CardinalityOperator.All).getOrDefault(false)) {
					notional = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule3 -> referenceWithMetaNonNegativeQuantitySchedule3 == null ? null : referenceWithMetaNonNegativeQuantitySchedule3.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get();
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.VARIANCE_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notional = standardizedScheduleFXVarianceNotionalAmount.evaluate(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get());
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.VOLATILITY_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notional = new BigDecimal("0.0");
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.CORRELATION_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notional = new BigDecimal("0.0");
				} else {
					notional = null;
				}
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.EQUITY), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.OPTION), CardinalityOperator.All).getOrDefault(false)) {
					notional = standardizedScheduleOptionNotionalAmount.evaluate(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get());
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.FORWARD), CardinalityOperator.All).getOrDefault(false)) {
					notional = standardizedScheduleEquityForwardNotionalAmount.evaluate(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get());
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.DIVIDEND_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notional = new BigDecimal("0.0");
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.VARIANCE_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notional = standardizedScheduleVarianceSwapNotionalAmount.evaluate(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get());
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.VOLATILITY_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notional = new BigDecimal("0.0");
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAPS_AND_PORTFOLIO_SWAPS), CardinalityOperator.All).getOrDefault(false)) {
					notional = new BigDecimal("0.0");
				} else {
					notional = null;
				}
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.COMMODITY), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.FORWARD), CardinalityOperator.All).getOrDefault(false)) {
					notional = standardizedScheduleCommodityForwardNotionalAmount.evaluate(economicTerms(trade, assetClass, productClass).get());
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.OPTION), CardinalityOperator.All).getOrDefault(false)) {
					notional = standardizedScheduleOptionNotionalAmount.evaluate(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get());
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.FIXED_FLOAT_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notional = standardizedScheduleCommoditySwapFixedFloatNotionalAmount.evaluate(economicTerms(trade, assetClass, productClass).get());
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.BASIS_SWAP), CardinalityOperator.All).getOrDefault(false)) {
					notional = new BigDecimal("0.0");
				} else if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAPTION), CardinalityOperator.All).getOrDefault(false)) {
					notional = standardizedScheduleCommoditySwapFixedFloatNotionalAmount.evaluate(MapperS.of(underlierForProduct.evaluate(product(trade, assetClass, productClass).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).get());
				} else {
					notional = null;
				}
			} else {
				notional = null;
			}
			
			return notional;
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
