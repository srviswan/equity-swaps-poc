package cdm.event.qualification.functions;

import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.UnitType;
import cdm.event.common.BusinessEvent;
import cdm.event.common.Instruction;
import cdm.event.common.PrimitiveInstruction;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.TransferInstruction;
import cdm.event.common.TransferState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_CashTransfer.Qualify_CashTransferDefault.class)
public abstract class Qualify_CashTransfer implements RosettaFunction,IQualifyFunctionExtension<BusinessEvent> {

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

	protected abstract MapperC<? extends TransferInstruction> transferInstructions(BusinessEvent businessEvent);

	protected abstract MapperC<? extends TransferState> beforeTransfers(BusinessEvent businessEvent);

	protected abstract MapperC<? extends TransferState> afterTransfers(BusinessEvent businessEvent);

	public static class Qualify_CashTransferDefault extends Qualify_CashTransfer {
		@Override
		protected Boolean doEvaluate(BusinessEvent businessEvent) {
			Boolean is_event = null;
			return assignOutput(is_event, businessEvent);
		}
		
		protected Boolean assignOutput(Boolean is_event, BusinessEvent businessEvent) {
			is_event = areEqual(MapperS.of(businessEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction())
				.mapItem(item -> onlyExists(item.<PrimitiveInstruction>map("getPrimitiveInstruction", instruction -> instruction.getPrimitiveInstruction()), Arrays.asList("contractFormation", "execution", "exercise", "partyChange", "quantityChange", "reset", "split", "termsChange", "transfer", "indexTransition", "stockSplit", "observation", "valuation"), Arrays.asList("transfer")).asMapper()), MapperS.of(true), CardinalityOperator.All).and(areEqual(MapperMaths.<Integer, Integer, Integer>add(MapperS.of(beforeTransfers(businessEvent).resultCount()), MapperS.of(transferInstructions(businessEvent).resultCount())), MapperS.of(afterTransfers(businessEvent).resultCount()), CardinalityOperator.All)).and(exists(transferInstructions(businessEvent).<TransferState>mapC("getTransferState", transferInstruction -> transferInstruction.getTransferState()).<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<NonNegativeQuantity>map("getQuantity", transfer -> transfer.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()))).get();
			
			return is_event;
		}
		
		@Override
		protected MapperC<? extends TransferInstruction> transferInstructions(BusinessEvent businessEvent) {
			return MapperS.of(businessEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).<PrimitiveInstruction>map("getPrimitiveInstruction", instruction -> instruction.getPrimitiveInstruction()).<TransferInstruction>map("getTransfer", primitiveInstruction -> primitiveInstruction.getTransfer());
		}
		
		@Override
		protected MapperC<? extends TransferState> beforeTransfers(BusinessEvent businessEvent) {
			return MapperS.of(businessEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).<ReferenceWithMetaTradeState>map("getBefore", instruction -> instruction.getBefore()).<TradeState>map("Type coercion", referenceWithMetaTradeState -> referenceWithMetaTradeState.getValue()).<TransferState>mapC("getTransferHistory", tradeState -> tradeState.getTransferHistory());
		}
		
		@Override
		protected MapperC<? extends TransferState> afterTransfers(BusinessEvent businessEvent) {
			return MapperS.of(businessEvent).<TradeState>mapC("getAfter", _businessEvent -> _businessEvent.getAfter()).<TransferState>mapC("getTransferHistory", tradeState -> tradeState.getTransferHistory());
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
