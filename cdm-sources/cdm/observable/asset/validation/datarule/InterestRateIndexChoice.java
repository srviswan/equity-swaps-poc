package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.InterestRateIndex;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0
 */
@RosettaDataRule("InterestRateIndexChoice")
@ImplementedBy(InterestRateIndexChoice.Default.class)
public interface InterestRateIndexChoice extends Validator<InterestRateIndex> {
	
	String NAME = "InterestRateIndexChoice";
	String DEFINITION = "";
	
	ValidationResult<InterestRateIndex> validate(RosettaPath path, InterestRateIndex interestRateIndex);
	
	class Default implements InterestRateIndexChoice {
	
		@Override
		public ValidationResult<InterestRateIndex> validate(RosettaPath path, InterestRateIndex interestRateIndex) {
			ComparisonResult result = executeDataRule(interestRateIndex);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRateIndex", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "InterestRateIndex", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(InterestRateIndex interestRateIndex) {
			try {
				return choice(MapperS.of(interestRateIndex), Arrays.asList("FloatingRateIndex", "InflationIndex"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InterestRateIndexChoice {
	
		@Override
		public ValidationResult<InterestRateIndex> validate(RosettaPath path, InterestRateIndex interestRateIndex) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRateIndex", path, DEFINITION);
		}
	}
}
