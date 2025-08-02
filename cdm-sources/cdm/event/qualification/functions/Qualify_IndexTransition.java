package cdm.event.qualification.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.common.EventIntentEnum;
import cdm.event.common.Instruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.observable.asset.Index;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.functions.FilterPrice;
import cdm.observable.asset.metafields.FieldWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_IndexTransition.Qualify_IndexTransitionDefault.class)
public abstract class Qualify_IndexTransition implements RosettaFunction,IQualifyFunctionExtension<BusinessEvent> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterPrice filterPrice;

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

	protected abstract MapperS<? extends Trade> after(BusinessEvent businessEvent);

	protected abstract MapperC<? extends Trade> before(BusinessEvent businessEvent);

	protected abstract MapperS<Boolean> floatingRateIndexChanged(BusinessEvent businessEvent);

	protected abstract MapperS<? extends PriceSchedule> spread(BusinessEvent businessEvent);

	protected abstract MapperS<Boolean> adjustmentSpreadAdded(BusinessEvent businessEvent);

	public static class Qualify_IndexTransitionDefault extends Qualify_IndexTransition {
		@Override
		protected Boolean doEvaluate(BusinessEvent businessEvent) {
			Boolean is_event = null;
			return assignOutput(is_event, businessEvent);
		}
		
		protected Boolean assignOutput(Boolean is_event, BusinessEvent businessEvent) {
			is_event = areEqual(MapperS.of(businessEvent).<EventIntentEnum>map("getIntent", _businessEvent -> _businessEvent.getIntent()), MapperS.of(EventIntentEnum.INDEX_TRANSITION), CardinalityOperator.All).and(areEqual(floatingRateIndexChanged(businessEvent), MapperS.of(true), CardinalityOperator.All)).and(areEqual(adjustmentSpreadAdded(businessEvent), MapperS.of(true), CardinalityOperator.All)).get();
			
			return is_event;
		}
		
		@Override
		protected MapperS<? extends Trade> after(BusinessEvent businessEvent) {
			return MapperS.of(MapperS.of(businessEvent).<TradeState>mapC("getAfter", _businessEvent -> _businessEvent.getAfter()).get()).<Trade>map("getTrade", tradeState -> tradeState.getTrade());
		}
		
		@Override
		protected MapperC<? extends Trade> before(BusinessEvent businessEvent) {
			return MapperS.of(businessEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).<ReferenceWithMetaTradeState>map("getBefore", instruction -> instruction.getBefore()).<TradeState>map("Type coercion", referenceWithMetaTradeState -> referenceWithMetaTradeState.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade());
		}
		
		@Override
		protected MapperS<Boolean> floatingRateIndexChanged(BusinessEvent businessEvent) {
			return exists(before(businessEvent).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaObservable>map("getObservable", priceQuantity -> priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable -> fieldWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", index -> index.getInterestRateIndex())).and(disjoint(before(businessEvent).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaObservable>map("getObservable", priceQuantity -> priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable -> fieldWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", index -> index.getInterestRateIndex()).<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex -> fieldWithMetaInterestRateIndex.getValue()), after(businessEvent).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaObservable>map("getObservable", priceQuantity -> priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable -> fieldWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", index -> index.getInterestRateIndex()).<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex -> fieldWithMetaInterestRateIndex.getValue()))).asMapper();
		}
		
		@Override
		protected MapperS<? extends PriceSchedule> spread(BusinessEvent businessEvent) {
			return MapperS.of(filterPrice.evaluate(after(businessEvent).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()).getMulti(), PriceTypeEnum.INTEREST_RATE, MapperC.<ArithmeticOperationEnum>of(MapperS.of(ArithmeticOperationEnum.ADD), MapperS.of(ArithmeticOperationEnum.SUBTRACT)).getMulti(), null));
		}
		
		@Override
		protected MapperS<Boolean> adjustmentSpreadAdded(BusinessEvent businessEvent) {
			if (exists(spread(businessEvent)).getOrDefault(false)) {
				return notEqual(spread(businessEvent).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.Any).asMapper();
			}
			return MapperS.of(true);
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
