package cdm.event.common.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.DatedValue;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.QuantityChangeDirectionEnum;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.identifier.Identifier;
import cdm.event.common.PrimitiveInstruction;
import cdm.event.common.PrimitiveInstruction.PrimitiveInstructionBuilder;
import cdm.event.common.QuantityChangeInstruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.observable.asset.CashPrice;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceComposite;
import cdm.observable.asset.PriceExpressionEnum;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_RepricePrimitiveInstruction.Create_RepricePrimitiveInstructionDefault.class)
public abstract class Create_RepricePrimitiveInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_EffectiveOrTerminationDateTermChangeInstruction create_EffectiveOrTerminationDateTermChangeInstruction;
	@Inject protected Create_TerminationInstruction create_TerminationInstruction;

	/**
	* @param tradeState The original trade state and trade to be repriced.
	* @param newAllinPrice The collateral new all-in price.
	* @param newCashValue The new cash amount.
	* @param effectiveRepriceDate The date to reprice the collateral
	* @return instruction 
	*/
	public PrimitiveInstruction evaluate(TradeState tradeState, BigDecimal newAllinPrice, BigDecimal newCashValue, AdjustableOrRelativeDate effectiveRepriceDate) {
		PrimitiveInstruction.PrimitiveInstructionBuilder instructionBuilder = doEvaluate(tradeState, newAllinPrice, newCashValue, effectiveRepriceDate);
		
		final PrimitiveInstruction instruction;
		if (instructionBuilder == null) {
			instruction = null;
		} else {
			instruction = instructionBuilder.build();
			objectValidator.validate(PrimitiveInstruction.class, instruction);
		}
		
		return instruction;
	}

	protected abstract PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(TradeState tradeState, BigDecimal newAllinPrice, BigDecimal newCashValue, AdjustableOrRelativeDate effectiveRepriceDate);

	protected abstract MapperC<? extends PriceQuantity> oldPriceQuantity(TradeState tradeState, BigDecimal newAllinPrice, BigDecimal newCashValue, AdjustableOrRelativeDate effectiveRepriceDate);

	protected abstract MapperS<? extends FieldWithMetaPriceSchedule> currentAssetPrice(TradeState tradeState, BigDecimal newAllinPrice, BigDecimal newCashValue, AdjustableOrRelativeDate effectiveRepriceDate);

	protected abstract MapperS<? extends Price> newPrice(TradeState tradeState, BigDecimal newAllinPrice, BigDecimal newCashValue, AdjustableOrRelativeDate effectiveRepriceDate);

	protected abstract MapperC<? extends NonNegativeQuantitySchedule> changeCashQuantity(TradeState tradeState, BigDecimal newAllinPrice, BigDecimal newCashValue, AdjustableOrRelativeDate effectiveRepriceDate);

	protected abstract MapperS<? extends PriceQuantity> newPriceQuantity(TradeState tradeState, BigDecimal newAllinPrice, BigDecimal newCashValue, AdjustableOrRelativeDate effectiveRepriceDate);

	public static class Create_RepricePrimitiveInstructionDefault extends Create_RepricePrimitiveInstruction {
		@Override
		protected PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(TradeState tradeState, BigDecimal newAllinPrice, BigDecimal newCashValue, AdjustableOrRelativeDate effectiveRepriceDate) {
			PrimitiveInstruction.PrimitiveInstructionBuilder instruction = PrimitiveInstruction.builder();
			return assignOutput(instruction, tradeState, newAllinPrice, newCashValue, effectiveRepriceDate);
		}
		
		protected PrimitiveInstruction.PrimitiveInstructionBuilder assignOutput(PrimitiveInstruction.PrimitiveInstructionBuilder instruction, TradeState tradeState, BigDecimal newAllinPrice, BigDecimal newCashValue, AdjustableOrRelativeDate effectiveRepriceDate) {
			instruction
				.getOrCreateSplit()
				.setBreakdown(MapperC.<PrimitiveInstruction>of(MapperS.of(create_TerminationInstruction.evaluate(tradeState))).getMulti());
			
			instruction
				.getOrCreateSplit()
				.addBreakdown(MapperC.<PrimitiveInstruction>of(MapperS.of(PrimitiveInstruction.builder()
					.setQuantityChange(QuantityChangeInstruction.builder()
						.setChange(MapperC.<PriceQuantity>of(newPriceQuantity(tradeState, newAllinPrice, newCashValue, effectiveRepriceDate)).getMulti())
						.setDirection(QuantityChangeDirectionEnum.REPLACE)
						.setLotIdentifier(Collections.<Identifier>emptyList())
						.build())
					.setTermsChange(create_EffectiveOrTerminationDateTermChangeInstruction.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).get(), effectiveRepriceDate, null))
					.build())).getMulti());
			
			return Optional.ofNullable(instruction)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends PriceQuantity> oldPriceQuantity(TradeState tradeState, BigDecimal newAllinPrice, BigDecimal newCashValue, AdjustableOrRelativeDate effectiveRepriceDate) {
			return MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity());
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaPriceSchedule> currentAssetPrice(TradeState tradeState, BigDecimal newAllinPrice, BigDecimal newCashValue, AdjustableOrRelativeDate effectiveRepriceDate) {
			final MapperListOfLists<FieldWithMetaPriceSchedule> thenArg0 = oldPriceQuantity(tradeState, newAllinPrice, newCashValue, effectiveRepriceDate)
				.mapItemToList(item -> item.<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()));
			final MapperC<FieldWithMetaPriceSchedule> thenArg1 = thenArg0
				.flattenList();
			final MapperC<FieldWithMetaPriceSchedule> thenArg2 = thenArg1
				.filterItemNullSafe(item -> areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule == null ? null : fieldWithMetaPriceSchedule.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.ASSET_PRICE), CardinalityOperator.All).get());
			return MapperS.of(thenArg2.get());
		}
		
		@Override
		protected MapperS<? extends Price> newPrice(TradeState tradeState, BigDecimal newAllinPrice, BigDecimal newCashValue, AdjustableOrRelativeDate effectiveRepriceDate) {
			return MapperS.of(Price.builder()
				.setValue(newAllinPrice)
				.setUnit(currentAssetPrice(tradeState, newAllinPrice, newCashValue, effectiveRepriceDate).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule0 -> fieldWithMetaPriceSchedule0 == null ? null : fieldWithMetaPriceSchedule0.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).get())
				.setPerUnitOf(currentAssetPrice(tradeState, newAllinPrice, newCashValue, effectiveRepriceDate).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule1 -> fieldWithMetaPriceSchedule1 == null ? null : fieldWithMetaPriceSchedule1.getValue()).<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).get())
				.setPriceType(currentAssetPrice(tradeState, newAllinPrice, newCashValue, effectiveRepriceDate).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule2 -> fieldWithMetaPriceSchedule2 == null ? null : fieldWithMetaPriceSchedule2.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()).get())
				.setPriceExpression(currentAssetPrice(tradeState, newAllinPrice, newCashValue, effectiveRepriceDate).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule3 -> fieldWithMetaPriceSchedule3 == null ? null : fieldWithMetaPriceSchedule3.getValue()).<PriceExpressionEnum>map("getPriceExpression", priceSchedule -> priceSchedule.getPriceExpression()).get())
				.setComposite(currentAssetPrice(tradeState, newAllinPrice, newCashValue, effectiveRepriceDate).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule4 -> fieldWithMetaPriceSchedule4 == null ? null : fieldWithMetaPriceSchedule4.getValue()).<PriceComposite>map("getComposite", priceSchedule -> priceSchedule.getComposite()).get())
				.setArithmeticOperator(currentAssetPrice(tradeState, newAllinPrice, newCashValue, effectiveRepriceDate).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule5 -> fieldWithMetaPriceSchedule5 == null ? null : fieldWithMetaPriceSchedule5.getValue()).<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator()).get())
				.setCashPrice(currentAssetPrice(tradeState, newAllinPrice, newCashValue, effectiveRepriceDate).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule6 -> fieldWithMetaPriceSchedule6 == null ? null : fieldWithMetaPriceSchedule6.getValue()).<CashPrice>map("getCashPrice", priceSchedule -> priceSchedule.getCashPrice()).get())
				.setDatedValue(Collections.<DatedValue>emptyList())
				.build());
		}
		
		@Override
		protected MapperC<? extends NonNegativeQuantitySchedule> changeCashQuantity(TradeState tradeState, BigDecimal newAllinPrice, BigDecimal newCashValue, AdjustableOrRelativeDate effectiveRepriceDate) {
			final MapperC<NonNegativeQuantitySchedule> thenArg = MapperS.of(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity())
				.mapItem(item -> MapperS.of(NonNegativeQuantitySchedule.builder()
					.setValue(newCashValue)
					.setUnit(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get())
					.build()));
			return distinct(thenArg);
		}
		
		@Override
		protected MapperS<? extends PriceQuantity> newPriceQuantity(TradeState tradeState, BigDecimal newAllinPrice, BigDecimal newCashValue, AdjustableOrRelativeDate effectiveRepriceDate) {
			return MapperS.of(PriceQuantity.builder()
				.setPriceValue(MapperC.<Price>of(newPrice(tradeState, newAllinPrice, newCashValue, effectiveRepriceDate)).getMulti())
				.setQuantityValue(new ArrayList<>(changeCashQuantity(tradeState, newAllinPrice, newCashValue, effectiveRepriceDate).getMulti()))
				.build());
		}
	}
}
