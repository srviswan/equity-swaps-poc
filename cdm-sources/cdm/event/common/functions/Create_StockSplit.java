package cdm.event.common.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.DatedValue;
import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.QuantityChangeDirectionEnum;
import cdm.base.math.QuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.functions.FilterQuantityByFinancialUnit;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.identifier.Identifier;
import cdm.event.common.PrimitiveInstruction;
import cdm.event.common.QuantityChangeInstruction;
import cdm.event.common.StockSplitInstruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.TradeState.TradeStateBuilder;
import cdm.observable.asset.CashPrice;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceComposite;
import cdm.observable.asset.PriceExpressionEnum;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_StockSplit.Create_StockSplitDefault.class)
public abstract class Create_StockSplit implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradeState create_TradeState;
	@Inject protected FilterQuantityByFinancialUnit filterQuantityByFinancialUnit;

	/**
	* @param stockSplitInstruction 
	* @param before 
	* @return after 
	*/
	public TradeState evaluate(StockSplitInstruction stockSplitInstruction, TradeState before) {
		TradeState.TradeStateBuilder afterBuilder = doEvaluate(stockSplitInstruction, before);
		
		final TradeState after;
		if (afterBuilder == null) {
			after = null;
		} else {
			after = afterBuilder.build();
			objectValidator.validate(TradeState.class, after);
		}
		
		return after;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(StockSplitInstruction stockSplitInstruction, TradeState before);

	protected abstract MapperS<BigDecimal> preSplitNumberOfShares(StockSplitInstruction stockSplitInstruction, TradeState before);

	protected abstract MapperS<? extends NonNegativeQuantitySchedule> postSplitNumberOfShares(StockSplitInstruction stockSplitInstruction, TradeState before);

	protected abstract MapperS<? extends FieldWithMetaPriceSchedule> preSplitPrice(StockSplitInstruction stockSplitInstruction, TradeState before);

	protected abstract MapperS<? extends Price> postSplitPrice(StockSplitInstruction stockSplitInstruction, TradeState before);

	protected abstract MapperS<? extends PriceQuantity> postSplitPriceQuantity(StockSplitInstruction stockSplitInstruction, TradeState before);

	protected abstract MapperS<? extends QuantityChangeInstruction> quantityChangeInstruction(StockSplitInstruction stockSplitInstruction, TradeState before);

	protected abstract MapperS<? extends PrimitiveInstruction> primitiveInstruction(StockSplitInstruction stockSplitInstruction, TradeState before);

	public static class Create_StockSplitDefault extends Create_StockSplit {
		@Override
		protected TradeState.TradeStateBuilder doEvaluate(StockSplitInstruction stockSplitInstruction, TradeState before) {
			TradeState.TradeStateBuilder after = TradeState.builder();
			return assignOutput(after, stockSplitInstruction, before);
		}
		
		protected TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder after, StockSplitInstruction stockSplitInstruction, TradeState before) {
			after = toBuilder(create_TradeState.evaluate(primitiveInstruction(stockSplitInstruction, before).get(), before));
			
			return Optional.ofNullable(after)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<BigDecimal> preSplitNumberOfShares(StockSplitInstruction stockSplitInstruction, TradeState before) {
			return MapperS.of(MapperC.of(filterQuantityByFinancialUnit.evaluate(MapperS.of(MapperS.of(before).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<QuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).getMulti(), FinancialUnitEnum.SHARE)).get()).<BigDecimal>map("getValue", quantitySchedule -> quantitySchedule.getValue());
		}
		
		@Override
		protected MapperS<? extends NonNegativeQuantitySchedule> postSplitNumberOfShares(StockSplitInstruction stockSplitInstruction, TradeState before) {
			return MapperS.of(NonNegativeQuantitySchedule.builder()
				.setValue(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(preSplitNumberOfShares(stockSplitInstruction, before), MapperS.of(stockSplitInstruction).<BigDecimal>map("getAdjustmentRatio", _stockSplitInstruction -> _stockSplitInstruction.getAdjustmentRatio())).get())
				.setUnit(UnitType.builder()
					.setFinancialUnit(FinancialUnitEnum.SHARE)
					.build())
				.build());
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaPriceSchedule> preSplitPrice(StockSplitInstruction stockSplitInstruction, TradeState before) {
			final MapperC<FieldWithMetaPriceSchedule> thenArg = MapperS.of(before).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice())
				.filterItemNullSafe(item -> areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule == null ? null : fieldWithMetaPriceSchedule.getValue()).<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()), MapperS.of(FinancialUnitEnum.SHARE), CardinalityOperator.All).get());
			return MapperS.of(thenArg.get());
		}
		
		@Override
		protected MapperS<? extends Price> postSplitPrice(StockSplitInstruction stockSplitInstruction, TradeState before) {
			return MapperS.of(Price.builder()
				.setValue(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(preSplitPrice(stockSplitInstruction, before).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule0 -> fieldWithMetaPriceSchedule0 == null ? null : fieldWithMetaPriceSchedule0.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()), MapperS.of(stockSplitInstruction).<BigDecimal>map("getAdjustmentRatio", _stockSplitInstruction -> _stockSplitInstruction.getAdjustmentRatio())).get())
				.setUnit(preSplitPrice(stockSplitInstruction, before).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule1 -> fieldWithMetaPriceSchedule1 == null ? null : fieldWithMetaPriceSchedule1.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).get())
				.setPerUnitOf(preSplitPrice(stockSplitInstruction, before).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule2 -> fieldWithMetaPriceSchedule2 == null ? null : fieldWithMetaPriceSchedule2.getValue()).<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).get())
				.setPriceType(preSplitPrice(stockSplitInstruction, before).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule3 -> fieldWithMetaPriceSchedule3 == null ? null : fieldWithMetaPriceSchedule3.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()).get())
				.setPriceExpression(preSplitPrice(stockSplitInstruction, before).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule4 -> fieldWithMetaPriceSchedule4 == null ? null : fieldWithMetaPriceSchedule4.getValue()).<PriceExpressionEnum>map("getPriceExpression", priceSchedule -> priceSchedule.getPriceExpression()).get())
				.setComposite(preSplitPrice(stockSplitInstruction, before).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule5 -> fieldWithMetaPriceSchedule5 == null ? null : fieldWithMetaPriceSchedule5.getValue()).<PriceComposite>map("getComposite", priceSchedule -> priceSchedule.getComposite()).get())
				.setArithmeticOperator(preSplitPrice(stockSplitInstruction, before).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule6 -> fieldWithMetaPriceSchedule6 == null ? null : fieldWithMetaPriceSchedule6.getValue()).<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator()).get())
				.setCashPrice(preSplitPrice(stockSplitInstruction, before).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule7 -> fieldWithMetaPriceSchedule7 == null ? null : fieldWithMetaPriceSchedule7.getValue()).<CashPrice>map("getCashPrice", priceSchedule -> priceSchedule.getCashPrice()).get())
				.setDatedValue(Collections.<DatedValue>emptyList())
				.build());
		}
		
		@Override
		protected MapperS<? extends PriceQuantity> postSplitPriceQuantity(StockSplitInstruction stockSplitInstruction, TradeState before) {
			return MapperS.of(PriceQuantity.builder()
				.setPriceValue(new ArrayList<>(postSplitPrice(stockSplitInstruction, before).getMulti()))
				.setQuantityValue(new ArrayList<>(postSplitNumberOfShares(stockSplitInstruction, before).getMulti()))
				.build());
		}
		
		@Override
		protected MapperS<? extends QuantityChangeInstruction> quantityChangeInstruction(StockSplitInstruction stockSplitInstruction, TradeState before) {
			return MapperS.of(QuantityChangeInstruction.builder()
				.setChange(new ArrayList<>(postSplitPriceQuantity(stockSplitInstruction, before).getMulti()))
				.setDirection(QuantityChangeDirectionEnum.REPLACE)
				.setLotIdentifier(Collections.<Identifier>emptyList())
				.build());
		}
		
		@Override
		protected MapperS<? extends PrimitiveInstruction> primitiveInstruction(StockSplitInstruction stockSplitInstruction, TradeState before) {
			return MapperS.of(PrimitiveInstruction.builder()
				.setQuantityChange(quantityChangeInstruction(stockSplitInstruction, before).get())
				.build());
		}
	}
}
