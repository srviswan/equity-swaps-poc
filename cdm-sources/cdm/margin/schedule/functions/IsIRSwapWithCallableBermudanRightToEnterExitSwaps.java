package cdm.margin.schedule.functions;

import cdm.product.qualification.functions.Qualify_BaseProduct_IRSwap;
import cdm.product.template.EarlyTerminationProvision;
import cdm.product.template.EconomicTerms;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.OptionExerciseStyleEnum;
import cdm.product.template.OptionalEarlyTermination;
import cdm.product.template.TerminationProvision;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(IsIRSwapWithCallableBermudanRightToEnterExitSwaps.IsIRSwapWithCallableBermudanRightToEnterExitSwapsDefault.class)
public abstract class IsIRSwapWithCallableBermudanRightToEnterExitSwaps implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_BaseProduct_IRSwap qualify_BaseProduct_IRSwap;

	/**
	* @param economicTerms 
	* @return is_Product 
	*/
	public Boolean evaluate(EconomicTerms economicTerms) {
		Boolean is_Product = doEvaluate(economicTerms);
		
		return is_Product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);

	public static class IsIRSwapWithCallableBermudanRightToEnterExitSwapsDefault extends IsIRSwapWithCallableBermudanRightToEnterExitSwaps {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_Product = null;
			return assignOutput(is_Product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_Product, EconomicTerms economicTerms) {
			is_Product = ComparisonResult.of(MapperS.of(qualify_BaseProduct_IRSwap.evaluate(economicTerms))).and(areEqual(MapperS.of(economicTerms).<TerminationProvision>map("getTerminationProvision", _economicTerms -> _economicTerms.getTerminationProvision()).<EarlyTerminationProvision>map("getEarlyTerminationProvision", terminationProvision -> terminationProvision.getEarlyTerminationProvision()).<OptionalEarlyTermination>map("getOptionalEarlyTermination", earlyTerminationProvision -> earlyTerminationProvision.getOptionalEarlyTermination()).<ExerciseTerms>map("getExerciseTerms", optionalEarlyTermination -> optionalEarlyTermination.getExerciseTerms()).<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.BERMUDA), CardinalityOperator.All)).get();
			
			return is_Product;
		}
	}
}
