package cdm.event.common.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.Instruction;
import cdm.event.common.PrimitiveInstruction;
import cdm.event.common.ScheduledTransfer;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.TransferExpression;
import cdm.event.common.TransferInstruction;
import cdm.event.common.TransferState;
import cdm.product.common.settlement.ScheduledTransferEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_OnDemandPayment.Qualify_OnDemandPaymentDefault.class)
public abstract class Qualify_OnDemandPayment implements RosettaFunction,IQualifyFunctionExtension<BusinessEvent> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterOpenTradeStates filterOpenTradeStates;

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

	protected abstract MapperS<? extends Instruction> instruction(BusinessEvent businessEvent);

	protected abstract MapperC<? extends TradeState> afterTradeStates(BusinessEvent businessEvent);

	protected abstract MapperC<? extends Transfer> transfer(BusinessEvent businessEvent);

	public static class Qualify_OnDemandPaymentDefault extends Qualify_OnDemandPayment {
		@Override
		protected Boolean doEvaluate(BusinessEvent businessEvent) {
			Boolean is_event = null;
			return assignOutput(is_event, businessEvent);
		}
		
		protected Boolean assignOutput(Boolean is_event, BusinessEvent businessEvent) {
			is_event = areEqual(MapperS.of(MapperS.of(businessEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).resultCount()), MapperS.of(1), CardinalityOperator.All).and(areEqual(MapperS.of(MapperS.of(businessEvent).<TradeState>mapC("getAfter", _businessEvent -> _businessEvent.getAfter()).resultCount()), MapperS.of(1), CardinalityOperator.All)).and(areEqual(MapperS.of(afterTradeStates(businessEvent).resultCount()), MapperS.of(1), CardinalityOperator.All)).and(onlyExists(instruction(businessEvent).<PrimitiveInstruction>map("getPrimitiveInstruction", _instruction -> _instruction.getPrimitiveInstruction()), Arrays.asList("contractFormation", "execution", "exercise", "partyChange", "quantityChange", "reset", "split", "termsChange", "transfer", "indexTransition", "stockSplit", "observation", "valuation"), Arrays.asList("transfer"))).and(areEqual(transfer(businessEvent).<TransferExpression>map("getTransferExpression", _transfer -> _transfer.getTransferExpression()).<ScheduledTransfer>map("getScheduledTransfer", transferExpression -> transferExpression.getScheduledTransfer()).<ScheduledTransferEnum>map("getTransferType", scheduledTransfer -> scheduledTransfer.getTransferType()), MapperS.of(ScheduledTransferEnum.NET_INTEREST), CardinalityOperator.All)).get();
			
			return is_event;
		}
		
		@Override
		protected MapperS<? extends Instruction> instruction(BusinessEvent businessEvent) {
			return MapperS.of(MapperS.of(businessEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).get());
		}
		
		@Override
		protected MapperC<? extends TradeState> afterTradeStates(BusinessEvent businessEvent) {
			return MapperC.<TradeState>of(filterOpenTradeStates.evaluate(MapperS.of(businessEvent).<TradeState>mapC("getAfter", _businessEvent -> _businessEvent.getAfter()).getMulti()));
		}
		
		@Override
		protected MapperC<? extends Transfer> transfer(BusinessEvent businessEvent) {
			return MapperS.of(businessEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).<PrimitiveInstruction>map("getPrimitiveInstruction", _instruction -> _instruction.getPrimitiveInstruction()).<TransferInstruction>map("getTransfer", primitiveInstruction -> primitiveInstruction.getTransfer()).<TransferState>mapC("getTransferState", transferInstruction -> transferInstruction.getTransferState()).<Transfer>map("getTransfer", transferState -> transferState.getTransfer());
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
