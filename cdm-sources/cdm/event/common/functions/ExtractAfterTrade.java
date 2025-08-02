package cdm.event.common.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.Trade;
import cdm.event.common.Trade.TradeBuilder;
import cdm.event.common.TradeState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(ExtractAfterTrade.ExtractAfterTradeDefault.class)
public abstract class ExtractAfterTrade implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterOpenTradeStates filterOpenTradeStates;

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

	public static class ExtractAfterTradeDefault extends ExtractAfterTrade {
		@Override
		protected Trade.TradeBuilder doEvaluate(BusinessEvent businessEvent) {
			Trade.TradeBuilder trade = Trade.builder();
			return assignOutput(trade, businessEvent);
		}
		
		protected Trade.TradeBuilder assignOutput(Trade.TradeBuilder trade, BusinessEvent businessEvent) {
			trade = toBuilder(MapperS.of(MapperC.of(filterOpenTradeStates.evaluate(MapperS.of(businessEvent).<TradeState>mapC("getAfter", _businessEvent -> _businessEvent.getAfter()).getMulti())).get()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).get());
			
			return Optional.ofNullable(trade)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
