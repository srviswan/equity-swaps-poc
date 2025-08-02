package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.Observable;
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
@RosettaDataRule("ObservableChoice")
@ImplementedBy(ObservableChoice.Default.class)
public interface ObservableChoice extends Validator<Observable> {
	
	String NAME = "ObservableChoice";
	String DEFINITION = "";
	
	ValidationResult<Observable> validate(RosettaPath path, Observable observable);
	
	class Default implements ObservableChoice {
	
		@Override
		public ValidationResult<Observable> validate(RosettaPath path, Observable observable) {
			ComparisonResult result = executeDataRule(observable);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Observable", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Observable", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Observable observable) {
			try {
				return choice(MapperS.of(observable), Arrays.asList("Asset", "Basket", "Index"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ObservableChoice {
	
		@Override
		public ValidationResult<Observable> validate(RosettaPath path, Observable observable) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Observable", path, DEFINITION);
		}
	}
}
