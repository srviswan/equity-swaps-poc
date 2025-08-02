package cdm.event.common.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.QuantityChangeDirectionEnum;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.event.common.QuantityChangeInstruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.TradeState.TradeStateBuilder;
import cdm.event.position.PositionStatusEnum;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.product.common.NotionalAdjustmentEnum;
import cdm.product.common.settlement.functions.UpdateAmountForEachMatchingQuantity;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.TradeLot;
import cdm.product.template.functions.AddTradeLot;
import cdm.product.template.functions.FilterTradeLot;
import cdm.product.template.functions.ReplaceTradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ConditionValidator;
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

@ImplementedBy(Create_QuantityChange.Create_QuantityChangeDefault.class)
public abstract class Create_QuantityChange implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected AddTradeLot addTradeLot;
	@Inject protected FilterTradeLot filterTradeLot;
	@Inject protected ReplaceTradeLot replaceTradeLot;
	@Inject protected UpdateAmountForEachMatchingQuantity updateAmountForEachMatchingQuantity;

	/**
	* @param instruction 
	* @param tradeState 
	* @return quantityChange 
	*/
	public TradeState evaluate(QuantityChangeInstruction instruction, TradeState tradeState) {
		// pre-conditions
		conditionValidator.validate(() -> {
			if (areEqual(MapperS.of(instruction).<QuantityChangeDirectionEnum>map("getDirection", quantityChangeInstruction -> quantityChangeInstruction.getDirection()), MapperS.of(QuantityChangeDirectionEnum.DECREASE), CardinalityOperator.All).and(exists(MapperS.of(instruction).<PriceQuantity>mapC("getChange", quantityChangeInstruction -> quantityChangeInstruction.getChange()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()))).getOrDefault(false)) {
				return areEqual(MapperS.of(instruction).<PriceQuantity>mapC("getChange", quantityChangeInstruction -> quantityChangeInstruction.getChange()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.CASH_PRICE), CardinalityOperator.All);
			}
			return ComparisonResult.successEmptyOperand("");
		},
			"Only termination where the termination price is specified as a cash price is supported for now.");
		
		TradeState.TradeStateBuilder quantityChangeBuilder = doEvaluate(instruction, tradeState);
		
		final TradeState quantityChange;
		if (quantityChangeBuilder == null) {
			quantityChange = null;
		} else {
			quantityChange = quantityChangeBuilder.build();
			objectValidator.validate(TradeState.class, quantityChange);
		}
		
		return quantityChange;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(QuantityChangeInstruction instruction, TradeState tradeState);

	protected abstract MapperS<? extends Trade> trade(QuantityChangeInstruction instruction, TradeState tradeState);

	protected abstract MapperS<Boolean> tradeLotExists(QuantityChangeInstruction instruction, TradeState tradeState);

	protected abstract MapperC<? extends TradeLot> tradeLot(QuantityChangeInstruction instruction, TradeState tradeState);

	protected abstract MapperC<? extends PriceQuantity> newPriceQuantity(QuantityChangeInstruction instruction, TradeState tradeState);

	protected abstract MapperC<? extends TradeLot> newTradeLots(QuantityChangeInstruction instruction, TradeState tradeState);

	public static class Create_QuantityChangeDefault extends Create_QuantityChange {
		@Override
		protected TradeState.TradeStateBuilder doEvaluate(QuantityChangeInstruction instruction, TradeState tradeState) {
			TradeState.TradeStateBuilder quantityChange = TradeState.builder();
			return assignOutput(quantityChange, instruction, tradeState);
		}
		
		protected TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder quantityChange, QuantityChangeInstruction instruction, TradeState tradeState) {
			quantityChange = toBuilder(tradeState);
			
			quantityChange
				.getOrCreateTrade()
				.setProduct(trade(instruction, tradeState).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).get());
			
			quantityChange
				.getOrCreateTrade()
				.setTradeLot(newTradeLots(instruction, tradeState).getMulti());
			
			quantityChange
				.getOrCreateTrade()
				.setCounterparty(trade(instruction, tradeState).<Counterparty>mapC("getCounterparty", _trade -> _trade.getCounterparty()).getMulti());
			
			quantityChange
				.getOrCreateTrade()
				.setAncillaryParty(trade(instruction, tradeState).<AncillaryParty>mapC("getAncillaryParty", _trade -> _trade.getAncillaryParty()).getMulti());
			
			quantityChange
				.getOrCreateTrade()
				.setAdjustment(trade(instruction, tradeState).<NotionalAdjustmentEnum>map("getAdjustment", _trade -> _trade.getAdjustment()).get());
			
			PositionStatusEnum ifThenElseResult = null;
			if (areEqual(newTradeLots(instruction, tradeState).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = PositionStatusEnum.CLOSED;
			}
			quantityChange
				.getOrCreateState()
				.setPositionState(ifThenElseResult);
			
			return Optional.ofNullable(quantityChange)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Trade> trade(QuantityChangeInstruction instruction, TradeState tradeState) {
			return MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade());
		}
		
		@Override
		protected MapperS<Boolean> tradeLotExists(QuantityChangeInstruction instruction, TradeState tradeState) {
			return exists(MapperC.<TradeLot>of(filterTradeLot.evaluate(trade(instruction, tradeState).<TradeLot>mapC("getTradeLot", _trade -> _trade.getTradeLot()).getMulti(), MapperS.of(instruction).<Identifier>mapC("getLotIdentifier", quantityChangeInstruction -> quantityChangeInstruction.getLotIdentifier()).getMulti()))).asMapper();
		}
		
		@Override
		protected MapperC<? extends TradeLot> tradeLot(QuantityChangeInstruction instruction, TradeState tradeState) {
			if (tradeLotExists(instruction, tradeState).getOrDefault(false)) {
				return MapperC.<TradeLot>of(filterTradeLot.evaluate(trade(instruction, tradeState).<TradeLot>mapC("getTradeLot", _trade -> _trade.getTradeLot()).getMulti(), MapperS.of(instruction).<Identifier>mapC("getLotIdentifier", quantityChangeInstruction -> quantityChangeInstruction.getLotIdentifier()).getMulti()));
			}
			return MapperC.of(Collections.singletonList(trade(instruction, tradeState).<TradeLot>mapC("getTradeLot", _trade -> _trade.getTradeLot()).get()));
		}
		
		@Override
		protected MapperC<? extends PriceQuantity> newPriceQuantity(QuantityChangeInstruction instruction, TradeState tradeState) {
			if (areEqual(MapperS.of(instruction).<QuantityChangeDirectionEnum>map("getDirection", quantityChangeInstruction -> quantityChangeInstruction.getDirection()), MapperS.of(QuantityChangeDirectionEnum.INCREASE), CardinalityOperator.All).and(areEqual(tradeLotExists(instruction, tradeState), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				return MapperS.of(instruction).<PriceQuantity>mapC("getChange", quantityChangeInstruction -> quantityChangeInstruction.getChange());
			}
			return MapperC.<PriceQuantity>of(updateAmountForEachMatchingQuantity.evaluate(tradeLot(instruction, tradeState).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).getMulti(), MapperS.of(instruction).<PriceQuantity>mapC("getChange", quantityChangeInstruction -> quantityChangeInstruction.getChange()).getMulti(), MapperS.of(instruction).<QuantityChangeDirectionEnum>map("getDirection", quantityChangeInstruction -> quantityChangeInstruction.getDirection()).get()));
		}
		
		@Override
		protected MapperC<? extends TradeLot> newTradeLots(QuantityChangeInstruction instruction, TradeState tradeState) {
			if (areEqual(MapperS.of(instruction).<QuantityChangeDirectionEnum>map("getDirection", quantityChangeInstruction -> quantityChangeInstruction.getDirection()), MapperS.of(QuantityChangeDirectionEnum.INCREASE), CardinalityOperator.All).and(areEqual(tradeLotExists(instruction, tradeState), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				return MapperS.of(addTradeLot.evaluate(trade(instruction, tradeState).get(), TradeLot.builder()
					.setLotIdentifier(MapperS.of(instruction).<Identifier>mapC("getLotIdentifier", quantityChangeInstruction -> quantityChangeInstruction.getLotIdentifier()).getMulti())
					.setPriceQuantity(new ArrayList<>(newPriceQuantity(instruction, tradeState).getMulti()))
					.build())).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot());
			}
			return MapperC.<TradeLot>of(replaceTradeLot.evaluate(trade(instruction, tradeState).<TradeLot>mapC("getTradeLot", _trade -> _trade.getTradeLot()).getMulti(), TradeLot.builder()
				.setLotIdentifier(MapperS.of(instruction).<Identifier>mapC("getLotIdentifier", quantityChangeInstruction -> quantityChangeInstruction.getLotIdentifier()).getMulti())
				.setPriceQuantity(new ArrayList<>(newPriceQuantity(instruction, tradeState).getMulti()))
				.build()));
		}
	}
}
