package cdm.event.qualification.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.EventIntentEnum;
import cdm.event.common.Instruction;
import cdm.event.common.PrimitiveInstruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.TransferState;
import cdm.event.common.functions.QuantityIncreased;
import cdm.event.common.functions.TransfersForDate;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.Arrays;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_Increase.Qualify_IncreaseDefault.class)
public abstract class Qualify_Increase implements RosettaFunction,IQualifyFunctionExtension<BusinessEvent> {
	
	// RosettaFunction dependencies
	//
	@Inject protected QuantityIncreased quantityIncreased;
	@Inject protected TransfersForDate transfersForDate;

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

	protected abstract MapperS<? extends PrimitiveInstruction> primitiveInstruction(BusinessEvent businessEvent);

	protected abstract MapperC<? extends Transfer> transfer(BusinessEvent businessEvent);

	public static class Qualify_IncreaseDefault extends Qualify_Increase {
		@Override
		protected Boolean doEvaluate(BusinessEvent businessEvent) {
			Boolean is_event = null;
			return assignOutput(is_event, businessEvent);
		}
		
		protected Boolean assignOutput(Boolean is_event, BusinessEvent businessEvent) {
			final ReferenceWithMetaTradeState referenceWithMetaTradeState = MapperS.of(businessEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).<ReferenceWithMetaTradeState>map("getBefore", instruction -> instruction.getBefore()).get();
			is_event = notExists(MapperS.of(businessEvent).<EventIntentEnum>map("getIntent", _businessEvent -> _businessEvent.getIntent())).and(onlyExists(primitiveInstruction(businessEvent), Arrays.asList("contractFormation", "execution", "exercise", "partyChange", "quantityChange", "reset", "split", "termsChange", "transfer", "indexTransition", "stockSplit", "observation", "valuation"), Arrays.asList("quantityChange")).or(onlyExists(primitiveInstruction(businessEvent), Arrays.asList("contractFormation", "execution", "exercise", "partyChange", "quantityChange", "reset", "split", "termsChange", "transfer", "indexTransition", "stockSplit", "observation", "valuation"), Arrays.asList("quantityChange", "transfer"))).and(areEqual(MapperS.of(quantityIncreased.evaluate((referenceWithMetaTradeState == null ? null : referenceWithMetaTradeState.getValue()), MapperS.of(businessEvent).<TradeState>mapC("getAfter", _businessEvent -> _businessEvent.getAfter()).getMulti())), MapperS.of(true), CardinalityOperator.All).or(lessThan(MapperS.of(MapperS.of(businessEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).<ReferenceWithMetaTradeState>map("getBefore", instruction -> instruction.getBefore()).<TradeState>map("Type coercion", _referenceWithMetaTradeState -> _referenceWithMetaTradeState.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).resultCount()), MapperS.of(MapperS.of(businessEvent).<TradeState>mapC("getAfter", _businessEvent -> _businessEvent.getAfter()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).resultCount()), CardinalityOperator.All)))).get();
			
			return is_event;
		}
		
		@Override
		protected MapperS<? extends PrimitiveInstruction> primitiveInstruction(BusinessEvent businessEvent) {
			return MapperS.of(MapperS.of(businessEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).<PrimitiveInstruction>map("getPrimitiveInstruction", instruction -> instruction.getPrimitiveInstruction()).get());
		}
		
		@Override
		protected MapperC<? extends Transfer> transfer(BusinessEvent businessEvent) {
			return MapperC.<Transfer>of(transfersForDate.evaluate(MapperS.of(businessEvent).<TradeState>mapC("getAfter", _businessEvent -> _businessEvent.getAfter()).<TransferState>mapC("getTransferHistory", tradeState -> tradeState.getTransferHistory()).<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).getMulti(), MapperS.of(businessEvent).<Date>map("getEventDate", _businessEvent -> _businessEvent.getEventDate()).get()));
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
