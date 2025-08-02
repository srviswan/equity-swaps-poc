package cdm.event.common.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.Instruction;
import cdm.event.common.Trade;
import cdm.event.common.Trade.TradeBuilder;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(ExtractBeforeTrade.ExtractBeforeTradeDefault.class)
public abstract class ExtractBeforeTrade implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param businessEvent 
	* @return trade 
	*/
	public Trade evaluate(BusinessEvent businessEvent) {
		Trade.TradeBuilder tradeBuilder = doEvaluate(businessEvent);
		
		final Trade trade;
		if (tradeBuilder == null) {
			trade = null;
		} else {
			trade = tradeBuilder.build();
			objectValidator.validate(Trade.class, trade);
		}
		
		return trade;
	}

	protected abstract Trade.TradeBuilder doEvaluate(BusinessEvent businessEvent);

	public static class ExtractBeforeTradeDefault extends ExtractBeforeTrade {
		@Override
		protected Trade.TradeBuilder doEvaluate(BusinessEvent businessEvent) {
			Trade.TradeBuilder trade = Trade.builder();
			return assignOutput(trade, businessEvent);
		}
		
		protected Trade.TradeBuilder assignOutput(Trade.TradeBuilder trade, BusinessEvent businessEvent) {
			trade = toBuilder(MapperS.of(MapperS.of(businessEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).get()).<ReferenceWithMetaTradeState>map("getBefore", instruction -> instruction.getBefore()).<TradeState>map("Type coercion", referenceWithMetaTradeState -> referenceWithMetaTradeState == null ? null : referenceWithMetaTradeState.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).get());
			
			return Optional.ofNullable(trade)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
