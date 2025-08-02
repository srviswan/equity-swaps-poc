package cdm.margin.schedule.functions;

import cdm.base.datetime.AdjustableDates;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.base.datetime.functions.ConvertToAdjustableOrAdjustedOrRelativeDate;
import cdm.event.common.Trade;
import cdm.margin.schedule.StandardizedScheduleAssetClassEnum;
import cdm.margin.schedule.StandardizedScheduleProductClassEnum;
import cdm.product.template.EconomicTerms;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionExerciseStyleEnum;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(StandardizedScheduleDuration.StandardizedScheduleDurationDefault.class)
public abstract class StandardizedScheduleDuration implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableDatesResolution adjustableDatesResolution;
	@Inject protected AdjustableOrAdjustedOrRelativeDateResolution adjustableOrAdjustedOrRelativeDateResolution;
	@Inject protected AuxiliarEffectiveDate auxiliarEffectiveDate;
	@Inject protected AuxiliarTerminationDate auxiliarTerminationDate;
	@Inject protected ConvertToAdjustableOrAdjustedOrRelativeDate convertToAdjustableOrAdjustedOrRelativeDate;
	@Inject protected DateDifferenceYears dateDifferenceYears;
	@Inject protected ProductDeepPathUtil productDeepPathUtil;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param trade 
	* @param assetClass 
	* @param productClass 
	* @return durationInYears 
	*/
	public BigDecimal evaluate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
		BigDecimal durationInYears = doEvaluate(trade, assetClass, productClass);
		
		// post-conditions
		conditionValidator.validate(() -> greaterThan(MapperS.of(durationInYears), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All),
			"Ensure duration is greater than 0.");
		
		return durationInYears;
	}

	protected abstract BigDecimal doEvaluate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<? extends NonTransferableProduct> product(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<? extends Underlier> underlier(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<Date> transactionEffectiveDate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<Date> transactionTerminationDate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<BigDecimal> transactionTenorInYears(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<Date> underlyingTransactionEffectiveDate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<Date> underlyingTransactionTerminationDate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<BigDecimal> underlyingTransactionTenorInYears(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<Date> optionExpiry(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<BigDecimal> timeToOptionExpiryInYears(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<BigDecimal> genericDurationInYears(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	protected abstract MapperS<BigDecimal> auxiliarDurationInYears(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass);

	public static class StandardizedScheduleDurationDefault extends StandardizedScheduleDuration {
		@Override
		protected BigDecimal doEvaluate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			BigDecimal durationInYears = null;
			return assignOutput(durationInYears, trade, assetClass, productClass);
		}
		
		protected BigDecimal assignOutput(BigDecimal durationInYears, Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			if (exists(genericDurationInYears(trade, assetClass, productClass)).getOrDefault(false)) {
				durationInYears = genericDurationInYears(trade, assetClass, productClass).get();
			} else {
				durationInYears = auxiliarDurationInYears(trade, assetClass, productClass).get();
			}
			
			return durationInYears;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			return MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct());
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			return product(trade, assetClass, productClass).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
		
		@Override
		protected MapperS<? extends Underlier> underlier(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			return MapperS.of(underlierForProduct.evaluate(product(trade, assetClass, productClass).get()));
		}
		
		@Override
		protected MapperS<Date> transactionEffectiveDate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			return MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(convertToAdjustableOrAdjustedOrRelativeDate.evaluate(economicTerms(trade, assetClass, productClass).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()).get())));
		}
		
		@Override
		protected MapperS<Date> transactionTerminationDate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			return MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(convertToAdjustableOrAdjustedOrRelativeDate.evaluate(economicTerms(trade, assetClass, productClass).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()).get())));
		}
		
		@Override
		protected MapperS<BigDecimal> transactionTenorInYears(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			if (exists(transactionEffectiveDate(trade, assetClass, productClass)).and(exists(transactionTerminationDate(trade, assetClass, productClass))).getOrDefault(false)) {
				return MapperS.of(dateDifferenceYears.evaluate(transactionEffectiveDate(trade, assetClass, productClass).get(), transactionTerminationDate(trade, assetClass, productClass).get()));
			}
			return MapperS.<BigDecimal>ofNull();
		}
		
		@Override
		protected MapperS<Date> underlyingTransactionEffectiveDate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			return MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(convertToAdjustableOrAdjustedOrRelativeDate.evaluate(underlier(trade, assetClass, productClass).<Product>map("getProduct", _underlier -> _underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()).get())));
		}
		
		@Override
		protected MapperS<Date> underlyingTransactionTerminationDate(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			return MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(convertToAdjustableOrAdjustedOrRelativeDate.evaluate(underlier(trade, assetClass, productClass).<Product>map("getProduct", _underlier -> _underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()).get())));
		}
		
		@Override
		protected MapperS<BigDecimal> underlyingTransactionTenorInYears(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			if (exists(underlyingTransactionEffectiveDate(trade, assetClass, productClass)).and(exists(underlyingTransactionTerminationDate(trade, assetClass, productClass))).getOrDefault(false)) {
				return MapperS.of(dateDifferenceYears.evaluate(underlyingTransactionEffectiveDate(trade, assetClass, productClass).get(), underlyingTransactionTerminationDate(trade, assetClass, productClass).get()));
			}
			return MapperS.<BigDecimal>ofNull();
		}
		
		@Override
		protected MapperS<Date> optionExpiry(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			final MapperS<ExerciseTerms> thenArg = MapperS.of(economicTerms(trade, assetClass, productClass).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms());
			return thenArg
				.mapSingleToItem(item -> {
					if (areEqual(item.<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.AMERICAN), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(convertToAdjustableOrAdjustedOrRelativeDate.evaluate(item.<AdjustableOrRelativeDate>mapC("getExpirationDate", exerciseTerms -> exerciseTerms.getExpirationDate()).get())));
					}
					if (areEqual(item.<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.EUROPEAN), CardinalityOperator.All).getOrDefault(false)) {
						return item.<AdjustableOrRelativeDate>mapC("getExpirationDate", exerciseTerms -> exerciseTerms.getExpirationDate())
							.max(_item -> MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(convertToAdjustableOrAdjustedOrRelativeDate.evaluate(_item.get()))))
							.mapSingleToItem(_item -> MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(convertToAdjustableOrAdjustedOrRelativeDate.evaluate(_item.get()))));
					}
					if (areEqual(item.<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.BERMUDA), CardinalityOperator.All).getOrDefault(false)) {
						if (exists(item.<AdjustableOrRelativeDates>map("getExerciseDates", exerciseTerms -> exerciseTerms.getExerciseDates()).<AdjustableDates>map("getAdjustableDates", adjustableOrRelativeDates -> adjustableOrRelativeDates.getAdjustableDates())).getOrDefault(false)) {
							return MapperC.<Date>of(adjustableDatesResolution.evaluate(item.<AdjustableOrRelativeDates>map("getExerciseDates", exerciseTerms -> exerciseTerms.getExerciseDates()).<AdjustableDates>map("getAdjustableDates", adjustableOrRelativeDates -> adjustableOrRelativeDates.getAdjustableDates()).get()))
								.max(_item -> _item)
								.mapSingleToItem(_item -> _item);
						}
						return MapperS.<Date>ofNull();
					}
					return MapperS.<Date>ofNull();
				});
		}
		
		@Override
		protected MapperS<BigDecimal> timeToOptionExpiryInYears(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			if (exists(transactionEffectiveDate(trade, assetClass, productClass)).and(exists(optionExpiry(trade, assetClass, productClass))).getOrDefault(false)) {
				return MapperS.of(dateDifferenceYears.evaluate(transactionEffectiveDate(trade, assetClass, productClass).get(), optionExpiry(trade, assetClass, productClass).get()));
			}
			return MapperS.<BigDecimal>ofNull();
		}
		
		@Override
		protected MapperS<BigDecimal> genericDurationInYears(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.INTEREST_RATES), CardinalityOperator.All).or(areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.CREDIT), CardinalityOperator.All)).getOrDefault(false)) {
				if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAP), CardinalityOperator.All).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAP_WITH_CALLABLE_BERMUDAN_RIGHT_TO_ENTER_EXIT_SWAPS), CardinalityOperator.All)).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.CROSS_CURRENCY_SWAP), CardinalityOperator.All)).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.FORWARD_RATE_AGREEMENT), CardinalityOperator.All)).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SINGLE_NAME_CREDIT_DEFAULT_SWAP), CardinalityOperator.All)).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.INDEX_CDS), CardinalityOperator.All)).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.INDEX_TRANCHE), CardinalityOperator.All)).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.CREDIT_NTH_TO_DEFAULT), CardinalityOperator.All)).getOrDefault(false)) {
					return transactionTenorInYears(trade, assetClass, productClass);
				}
				if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAPTION), CardinalityOperator.All).or(areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.SWAPTION_STRADDLE), CardinalityOperator.All)).getOrDefault(false)) {
					if (exists(timeToOptionExpiryInYears(trade, assetClass, productClass)).and(exists(underlyingTransactionTenorInYears(trade, assetClass, productClass))).getOrDefault(false)) {
						return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>add(timeToOptionExpiryInYears(trade, assetClass, productClass), underlyingTransactionTenorInYears(trade, assetClass, productClass));
					}
					if (exists(timeToOptionExpiryInYears(trade, assetClass, productClass)).getOrDefault(false)) {
						return timeToOptionExpiryInYears(trade, assetClass, productClass);
					}
					if (exists(underlyingTransactionTenorInYears(trade, assetClass, productClass)).getOrDefault(false)) {
						return underlyingTransactionTenorInYears(trade, assetClass, productClass);
					}
					return MapperS.<BigDecimal>ofNull();
				}
				if (areEqual(MapperS.of(productClass), MapperS.of(StandardizedScheduleProductClassEnum.OPTION), CardinalityOperator.All).getOrDefault(false)) {
					return timeToOptionExpiryInYears(trade, assetClass, productClass);
				}
				return MapperS.<BigDecimal>ofNull();
			}
			return MapperS.<BigDecimal>ofNull();
		}
		
		@Override
		protected MapperS<BigDecimal> auxiliarDurationInYears(Trade trade, StandardizedScheduleAssetClassEnum assetClass, StandardizedScheduleProductClassEnum productClass) {
			return MapperS.of(dateDifferenceYears.evaluate(auxiliarEffectiveDate.evaluate(trade), auxiliarTerminationDate.evaluate(trade)));
		}
	}
}
