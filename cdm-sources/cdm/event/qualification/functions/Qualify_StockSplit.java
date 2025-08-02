package cdm.event.qualification.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.QuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.functions.FilterQuantityByCurrencyExists;
import cdm.base.math.functions.FilterQuantityByFinancialUnit;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.event.common.BusinessEvent;
import cdm.event.common.Instruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_StockSplit.Qualify_StockSplitDefault.class)
public abstract class Qualify_StockSplit implements RosettaFunction,IQualifyFunctionExtension<BusinessEvent> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterQuantityByCurrencyExists filterQuantityByCurrencyExists;
	@Inject protected FilterQuantityByFinancialUnit filterQuantityByFinancialUnit;

	/**
	* @param businessEvent 
	* @return is_event 
	*/
	@Override
	public Boolean evaluate(BusinessEvent businessEvent) {
		Boolean is_event = doEvaluate(businessEvent);
		
		return is_event;
	}

	protected abstract Boolean doEvaluate(BusinessEvent businessEvent);

	protected abstract MapperS<? extends ReferenceWithMetaTradeState> beforeTradeState(BusinessEvent businessEvent);

	protected abstract MapperS<? extends TradeState> afterTradeState(BusinessEvent businessEvent);

	protected abstract MapperC<? extends FieldWithMetaNonNegativeQuantitySchedule> beforeQuantities(BusinessEvent businessEvent);

	protected abstract MapperS<BigDecimal> beforeNoOfUnits(BusinessEvent businessEvent);

	protected abstract MapperC<? extends FieldWithMetaNonNegativeQuantitySchedule> afterQuantities(BusinessEvent businessEvent);

	protected abstract MapperS<BigDecimal> afterNoOfUnits(BusinessEvent businessEvent);

	protected abstract MapperS<BigDecimal> beforeCurrencyAmount(BusinessEvent businessEvent);

	protected abstract MapperS<BigDecimal> afterCurrencyAmount(BusinessEvent businessEvent);

	protected abstract MapperS<BigDecimal> beforePrice(BusinessEvent businessEvent);

	protected abstract MapperS<BigDecimal> afterPrice(BusinessEvent businessEvent);

	protected abstract MapperS<Boolean> currencyAmountUnchanged(BusinessEvent businessEvent);

	protected abstract MapperS<Boolean> noOfUnitsChanged(BusinessEvent businessEvent);

	protected abstract MapperS<Boolean> cashPriceChanged(BusinessEvent businessEvent);

	protected abstract MapperS<Boolean> adjustmentRatioMatches(BusinessEvent businessEvent);

	public static class Qualify_StockSplitDefault extends Qualify_StockSplit {
		@Override
		protected Boolean doEvaluate(BusinessEvent businessEvent) {
			Boolean is_event = null;
			return assignOutput(is_event, businessEvent);
		}
		
		protected Boolean assignOutput(Boolean is_event, BusinessEvent businessEvent) {
			is_event = areEqual(currencyAmountUnchanged(businessEvent), MapperS.of(true), CardinalityOperator.All).and(areEqual(noOfUnitsChanged(businessEvent), MapperS.of(true), CardinalityOperator.All)).and(areEqual(cashPriceChanged(businessEvent), MapperS.of(true), CardinalityOperator.All)).and(areEqual(adjustmentRatioMatches(businessEvent), MapperS.of(true), CardinalityOperator.All)).get();
			
			return is_event;
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaTradeState> beforeTradeState(BusinessEvent businessEvent) {
			return MapperS.of(MapperS.of(businessEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).<ReferenceWithMetaTradeState>map("getBefore", instruction -> instruction.getBefore()).get());
		}
		
		@Override
		protected MapperS<? extends TradeState> afterTradeState(BusinessEvent businessEvent) {
			return MapperS.of(MapperS.of(businessEvent).<TradeState>mapC("getAfter", _businessEvent -> _businessEvent.getAfter()).get());
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaNonNegativeQuantitySchedule> beforeQuantities(BusinessEvent businessEvent) {
			return MapperS.of(beforeTradeState(businessEvent).<TradeState>map("Type coercion", referenceWithMetaTradeState -> referenceWithMetaTradeState == null ? null : referenceWithMetaTradeState.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity());
		}
		
		@Override
		protected MapperS<BigDecimal> beforeNoOfUnits(BusinessEvent businessEvent) {
			return MapperS.of(MapperC.of(filterQuantityByFinancialUnit.evaluate(beforeQuantities(businessEvent).<QuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).getMulti(), FinancialUnitEnum.SHARE)).get()).<BigDecimal>map("getValue", quantitySchedule -> quantitySchedule.getValue());
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaNonNegativeQuantitySchedule> afterQuantities(BusinessEvent businessEvent) {
			return afterTradeState(businessEvent).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity());
		}
		
		@Override
		protected MapperS<BigDecimal> afterNoOfUnits(BusinessEvent businessEvent) {
			return MapperS.of(MapperC.of(filterQuantityByFinancialUnit.evaluate(afterQuantities(businessEvent).<QuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).getMulti(), FinancialUnitEnum.SHARE)).get()).<BigDecimal>map("getValue", quantitySchedule -> quantitySchedule.getValue());
		}
		
		@Override
		protected MapperS<BigDecimal> beforeCurrencyAmount(BusinessEvent businessEvent) {
			return MapperS.of(distinct(MapperC.<QuantitySchedule>of(filterQuantityByCurrencyExists.evaluate(beforeQuantities(businessEvent).<QuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).getMulti())).<BigDecimal>map("getValue", quantitySchedule -> quantitySchedule.getValue())).get());
		}
		
		@Override
		protected MapperS<BigDecimal> afterCurrencyAmount(BusinessEvent businessEvent) {
			return MapperS.of(distinct(MapperC.<QuantitySchedule>of(filterQuantityByCurrencyExists.evaluate(afterQuantities(businessEvent).<QuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).getMulti())).<BigDecimal>map("getValue", quantitySchedule -> quantitySchedule.getValue())).get());
		}
		
		@Override
		protected MapperS<BigDecimal> beforePrice(BusinessEvent businessEvent) {
			final MapperC<FieldWithMetaPriceSchedule> thenArg0 = MapperS.of(beforeTradeState(businessEvent).<TradeState>map("Type coercion", referenceWithMetaTradeState -> referenceWithMetaTradeState == null ? null : referenceWithMetaTradeState.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice())
				.filterItemNullSafe(item -> areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule == null ? null : fieldWithMetaPriceSchedule.getValue()).<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()), MapperS.of(FinancialUnitEnum.SHARE), CardinalityOperator.All).get());
			final MapperC<BigDecimal> thenArg1 = thenArg0
				.mapItem(item -> item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule == null ? null : fieldWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()));
			return MapperS.of(thenArg1.get());
		}
		
		@Override
		protected MapperS<BigDecimal> afterPrice(BusinessEvent businessEvent) {
			final MapperC<FieldWithMetaPriceSchedule> thenArg0 = MapperS.of(afterTradeState(businessEvent).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice())
				.filterItemNullSafe(item -> areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule == null ? null : fieldWithMetaPriceSchedule.getValue()).<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()), MapperS.of(FinancialUnitEnum.SHARE), CardinalityOperator.All).get());
			final MapperC<BigDecimal> thenArg1 = thenArg0
				.mapItem(item -> item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule == null ? null : fieldWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()));
			return MapperS.of(thenArg1.get());
		}
		
		@Override
		protected MapperS<Boolean> currencyAmountUnchanged(BusinessEvent businessEvent) {
			if (exists(beforeCurrencyAmount(businessEvent)).and(exists(afterCurrencyAmount(businessEvent))).getOrDefault(false)) {
				return areEqual(beforeCurrencyAmount(businessEvent), afterCurrencyAmount(businessEvent), CardinalityOperator.All).asMapper();
			}
			return MapperS.of(false);
		}
		
		@Override
		protected MapperS<Boolean> noOfUnitsChanged(BusinessEvent businessEvent) {
			if (exists(beforeNoOfUnits(businessEvent)).and(exists(afterNoOfUnits(businessEvent))).getOrDefault(false)) {
				return notEqual(afterNoOfUnits(businessEvent), beforeNoOfUnits(businessEvent), CardinalityOperator.Any).asMapper();
			}
			return MapperS.of(false);
		}
		
		@Override
		protected MapperS<Boolean> cashPriceChanged(BusinessEvent businessEvent) {
			if (exists(beforePrice(businessEvent)).and(exists(afterPrice(businessEvent))).getOrDefault(false)) {
				return notEqual(beforePrice(businessEvent), afterPrice(businessEvent), CardinalityOperator.Any).asMapper();
			}
			return MapperS.of(false);
		}
		
		@Override
		protected MapperS<Boolean> adjustmentRatioMatches(BusinessEvent businessEvent) {
			if (exists(beforeNoOfUnits(businessEvent)).and(greaterThan(beforeNoOfUnits(businessEvent), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).and(exists(afterNoOfUnits(businessEvent))).and(exists(beforePrice(businessEvent))).and(exists(afterPrice(businessEvent))).and(greaterThan(afterPrice(businessEvent), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).getOrDefault(false)) {
				return areEqual(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(afterNoOfUnits(businessEvent), beforeNoOfUnits(businessEvent)), MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(beforePrice(businessEvent), afterPrice(businessEvent)), CardinalityOperator.All).asMapper();
			}
			return MapperS.of(false);
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
