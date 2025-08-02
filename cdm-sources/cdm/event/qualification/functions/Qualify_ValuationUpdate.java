package cdm.event.qualification.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.Instruction;
import cdm.event.common.PrimitiveInstruction;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_ValuationUpdate.Qualify_ValuationUpdateDefault.class)
public abstract class Qualify_ValuationUpdate implements RosettaFunction,IQualifyFunctionExtension<BusinessEvent> {

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

	public static class Qualify_ValuationUpdateDefault extends Qualify_ValuationUpdate {
		@Override
		protected Boolean doEvaluate(BusinessEvent businessEvent) {
			Boolean is_event = null;
			return assignOutput(is_event, businessEvent);
		}
		
		protected Boolean assignOutput(Boolean is_event, BusinessEvent businessEvent) {
			is_event = onlyExists(instruction(businessEvent).<PrimitiveInstruction>map("getPrimitiveInstruction", _instruction -> _instruction.getPrimitiveInstruction()), Arrays.asList("contractFormation", "execution", "exercise", "partyChange", "quantityChange", "reset", "split", "termsChange", "transfer", "indexTransition", "stockSplit", "observation", "valuation"), Arrays.asList("valuation")).get();
			
			return is_event;
		}
		
		@Override
		protected MapperS<? extends Instruction> instruction(BusinessEvent businessEvent) {
			return MapperS.of(MapperS.of(businessEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).get());
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
