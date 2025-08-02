package cdm.event.common.functions;

import cdm.event.common.PrimitiveInstruction;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(NewTradeInstructionOnlyExists.NewTradeInstructionOnlyExistsDefault.class)
public abstract class NewTradeInstructionOnlyExists implements RosettaFunction {

	/**
	* @param primitiveInstruction 
	* @return result 
	*/
	public Boolean evaluate(PrimitiveInstruction primitiveInstruction) {
		Boolean result = doEvaluate(primitiveInstruction);
		
		return result;
	}

	protected abstract Boolean doEvaluate(PrimitiveInstruction primitiveInstruction);

	public static class NewTradeInstructionOnlyExistsDefault extends NewTradeInstructionOnlyExists {
		@Override
		protected Boolean doEvaluate(PrimitiveInstruction primitiveInstruction) {
			Boolean result = null;
			return assignOutput(result, primitiveInstruction);
		}
		
		protected Boolean assignOutput(Boolean result, PrimitiveInstruction primitiveInstruction) {
			result = onlyExists(MapperS.of(primitiveInstruction), Arrays.asList("contractFormation", "execution", "exercise", "partyChange", "quantityChange", "reset", "split", "termsChange", "transfer", "indexTransition", "stockSplit", "observation", "valuation"), Arrays.asList("execution")).or(onlyExists(MapperS.of(primitiveInstruction), Arrays.asList("contractFormation", "execution", "exercise", "partyChange", "quantityChange", "reset", "split", "termsChange", "transfer", "indexTransition", "stockSplit", "observation", "valuation"), Arrays.asList("execution", "contractFormation"))).get();
			
			return result;
		}
	}
}
