package cdm.base.math.functions;

import cdm.base.math.RoundingDirectionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(RoundToSignificantFigures.RoundToSignificantFiguresDefault.class)
public abstract class RoundToSignificantFigures implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;

	/**
	* @param value The original (unrounded) number.
	* @param significantFigures The number of significant figures.
	* @param roundingMode The method of rounding (up/down/nearest).
	* @return roundedValue The value to the desired number of significant figures.
	*/
	public BigDecimal evaluate(BigDecimal value, Integer significantFigures, RoundingDirectionEnum roundingMode) {
		// pre-conditions
		conditionValidator.validate(() -> greaterThan(MapperS.of(significantFigures), MapperS.of(0), CardinalityOperator.All),
			"The number of significant figures should be greater than zero.");
		
		BigDecimal roundedValue = doEvaluate(value, significantFigures, roundingMode);
		
		return roundedValue;
	}

	protected abstract BigDecimal doEvaluate(BigDecimal value, Integer significantFigures, RoundingDirectionEnum roundingMode);

	public static class RoundToSignificantFiguresDefault extends RoundToSignificantFigures {
		@Override
		protected BigDecimal doEvaluate(BigDecimal value, Integer significantFigures, RoundingDirectionEnum roundingMode) {
			BigDecimal roundedValue = null;
			return assignOutput(roundedValue, value, significantFigures, roundingMode);
		}
		
		protected BigDecimal assignOutput(BigDecimal roundedValue, BigDecimal value, Integer significantFigures, RoundingDirectionEnum roundingMode) {
			return roundedValue;
		}
	}
}
