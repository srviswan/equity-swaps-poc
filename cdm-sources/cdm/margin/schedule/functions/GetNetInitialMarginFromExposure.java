package cdm.margin.schedule.functions;

import cdm.base.math.UnitType;
import cdm.event.common.Exposure;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.Valuation;
import cdm.event.common.ValuationTypeEnum;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.position.PortfolioState;
import cdm.event.position.Position;
import cdm.event.position.metafields.ReferenceWithMetaPortfolioState;
import cdm.margin.schedule.StandardizedScheduleAssetClassEnum;
import cdm.margin.schedule.StandardizedScheduleInitialMargin;
import cdm.margin.schedule.StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder;
import cdm.margin.schedule.StandardizedScheduleProductClassEnum;
import cdm.margin.schedule.StandardizedScheduleTradeInfo;
import cdm.observable.asset.Money;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(GetNetInitialMarginFromExposure.GetNetInitialMarginFromExposureDefault.class)
public abstract class GetNetInitialMarginFromExposure implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected BuildStandardizedSchedule buildStandardizedSchedule;
	@Inject protected GetGrossInitialMarginFromStandardizedSchedule getGrossInitialMarginFromStandardizedSchedule;

	/**
	* @param exposure 
	* @return initialMargin 
	*/
	public StandardizedScheduleInitialMargin evaluate(Exposure exposure) {
		StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder initialMarginBuilder = doEvaluate(exposure);
		
		final StandardizedScheduleInitialMargin initialMargin;
		if (initialMarginBuilder == null) {
			initialMargin = null;
		} else {
			initialMargin = initialMarginBuilder.build();
			objectValidator.validate(StandardizedScheduleInitialMargin.class, initialMargin);
		}
		
		// post-conditions
		conditionValidator.validate(() -> greaterThanEquals(MapperS.of(initialMargin).<Money>map("getNetInitialMargin", standardizedScheduleInitialMargin -> standardizedScheduleInitialMargin.getNetInitialMargin()).<BigDecimal>map("getValue", money -> money.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All),
			"Ensure net initial margin is non-negative");
		
		conditionValidator.validate(() -> areEqual(MapperS.of(distinct(tradeInitialMargin(exposure).<Money>map("getGrossInitialMargin", standardizedScheduleTradeInfo -> standardizedScheduleTradeInfo.getGrossInitialMargin()).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).resultCount()), MapperS.of(1), CardinalityOperator.All),
			"Ensure that only a single currency exists");
		
		conditionValidator.validate(() -> areEqual(MapperS.of(distinct(tradeInitialMargin(exposure).<Money>map("getMarkToMarketValue", standardizedScheduleTradeInfo -> standardizedScheduleTradeInfo.getMarkToMarketValue()).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).resultCount()), MapperS.of(1), CardinalityOperator.All),
			"Ensure that only a single currency exists");
		
		return initialMargin;
	}

	protected abstract StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder doEvaluate(Exposure exposure);

	protected abstract MapperS<? extends ReferenceWithMetaPortfolioState> tradePortfolio(Exposure exposure);

	protected abstract MapperC<? extends Position> positions(Exposure exposure);

	protected abstract MapperC<? extends StandardizedScheduleTradeInfo> tradeInitialMargin(Exposure exposure);

	protected abstract MapperS<BigDecimal> totalGIM(Exposure exposure);

	protected abstract MapperS<BigDecimal> netCurrentReplacementCost(Exposure exposure);

	protected abstract MapperS<BigDecimal> grossCurrentReplacementCost(Exposure exposure);

	protected abstract MapperS<BigDecimal> netToGrossRatio(Exposure exposure);

	public static class GetNetInitialMarginFromExposureDefault extends GetNetInitialMarginFromExposure {
		@Override
		protected StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder doEvaluate(Exposure exposure) {
			StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder initialMargin = StandardizedScheduleInitialMargin.builder();
			return assignOutput(initialMargin, exposure);
		}
		
		protected StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder assignOutput(StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder initialMargin, Exposure exposure) {
			initialMargin
				.addTradeInfo(tradeInitialMargin(exposure).getMulti());
			
			initialMargin
				.getOrCreateNetInitialMargin()
				.setValue(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>add(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(new BigDecimal("0.4")), totalGIM(exposure)), MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(new BigDecimal("0.6")), totalGIM(exposure)), netToGrossRatio(exposure))).get());
			
			final FieldWithMetaString fieldWithMetaString = distinct(tradeInitialMargin(exposure).<Money>map("getMarkToMarketValue", standardizedScheduleTradeInfo -> standardizedScheduleTradeInfo.getMarkToMarketValue()).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).get();
			initialMargin
				.getOrCreateNetInitialMargin()
				.getOrCreateUnit()
				.setCurrencyValue((fieldWithMetaString == null ? null : fieldWithMetaString.getValue()));
			
			return Optional.ofNullable(initialMargin)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaPortfolioState> tradePortfolio(Exposure exposure) {
			return MapperS.of(exposure).<ReferenceWithMetaPortfolioState>map("getTradePortfolio", _exposure -> _exposure.getTradePortfolio());
		}
		
		@Override
		protected MapperC<? extends Position> positions(Exposure exposure) {
			return tradePortfolio(exposure).<PortfolioState>map("Type coercion", referenceWithMetaPortfolioState -> referenceWithMetaPortfolioState == null ? null : referenceWithMetaPortfolioState.getValue()).<Position>mapC("getPositions", portfolioState -> portfolioState.getPositions());
		}
		
		@Override
		protected MapperC<? extends StandardizedScheduleTradeInfo> tradeInitialMargin(Exposure exposure) {
			return positions(exposure)
				.mapItem(item -> {
					final MapperC<Valuation> thenArg0 = item.<ReferenceWithMetaTradeState>map("getTradeReference", position -> position.getTradeReference()).<TradeState>map("Type coercion", referenceWithMetaTradeState3 -> referenceWithMetaTradeState3 == null ? null : referenceWithMetaTradeState3.getValue()).<Valuation>mapC("getValuationHistory", tradeState -> tradeState.getValuationHistory())
						.filterItemNullSafe(_item -> areEqual(_item.<ValuationTypeEnum>map("getMethod", valuation -> valuation.getMethod()), MapperS.of(ValuationTypeEnum.MARK_TO_MARKET), CardinalityOperator.All).get());
					final MapperS<Valuation> thenArg1 = MapperS.of(thenArg0.get());
					return MapperS.of(StandardizedScheduleTradeInfo.builder()
						.setAssetClass(MapperS.of(buildStandardizedSchedule.evaluate(item.<ReferenceWithMetaTradeState>map("getTradeReference", position -> position.getTradeReference()).<TradeState>map("Type coercion", referenceWithMetaTradeState0 -> referenceWithMetaTradeState0 == null ? null : referenceWithMetaTradeState0.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).get())).<StandardizedScheduleAssetClassEnum>map("getAssetClass", standardizedSchedule -> standardizedSchedule.getAssetClass()).get())
						.setProductClass(MapperS.of(buildStandardizedSchedule.evaluate(item.<ReferenceWithMetaTradeState>map("getTradeReference", position -> position.getTradeReference()).<TradeState>map("Type coercion", referenceWithMetaTradeState1 -> referenceWithMetaTradeState1 == null ? null : referenceWithMetaTradeState1.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).get())).<StandardizedScheduleProductClassEnum>map("getProductClass", standardizedSchedule -> standardizedSchedule.getProductClass()).get())
						.setGrossInitialMargin(getGrossInitialMarginFromStandardizedSchedule.evaluate(buildStandardizedSchedule.evaluate(item.<ReferenceWithMetaTradeState>map("getTradeReference", position -> position.getTradeReference()).<TradeState>map("Type coercion", referenceWithMetaTradeState2 -> referenceWithMetaTradeState2 == null ? null : referenceWithMetaTradeState2.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).get())))
						.setMarkToMarketValue(thenArg1.<Money>map("getAmount", valuation -> valuation.getAmount()).get())
						.build());
				});
		}
		
		@Override
		protected MapperS<BigDecimal> totalGIM(Exposure exposure) {
			return tradeInitialMargin(exposure).<Money>map("getGrossInitialMargin", standardizedScheduleTradeInfo -> standardizedScheduleTradeInfo.getGrossInitialMargin()).<BigDecimal>map("getValue", money -> money.getValue())
				.sumBigDecimal();
		}
		
		@Override
		protected MapperS<BigDecimal> netCurrentReplacementCost(Exposure exposure) {
			return tradeInitialMargin(exposure).<Money>map("getMarkToMarketValue", standardizedScheduleTradeInfo -> standardizedScheduleTradeInfo.getMarkToMarketValue()).<BigDecimal>map("getValue", money -> money.getValue())
				.sumBigDecimal();
		}
		
		@Override
		protected MapperS<BigDecimal> grossCurrentReplacementCost(Exposure exposure) {
			final MapperC<Money> thenArg = tradeInitialMargin(exposure).<Money>map("getMarkToMarketValue", standardizedScheduleTradeInfo -> standardizedScheduleTradeInfo.getMarkToMarketValue())
				.filterItemNullSafe(item -> greaterThan(item.<BigDecimal>map("getValue", money -> money.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).get());
			return thenArg.<BigDecimal>map("getValue", money -> money.getValue())
				.sumBigDecimal();
		}
		
		@Override
		protected MapperS<BigDecimal> netToGrossRatio(Exposure exposure) {
			return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(netCurrentReplacementCost(exposure), grossCurrentReplacementCost(exposure));
		}
	}
}
