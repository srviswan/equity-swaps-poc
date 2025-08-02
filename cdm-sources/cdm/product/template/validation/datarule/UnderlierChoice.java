package cdm.product.template.validation.datarule;

import cdm.product.template.Underlier;
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
@RosettaDataRule("UnderlierChoice")
@ImplementedBy(UnderlierChoice.Default.class)
public interface UnderlierChoice extends Validator<Underlier> {
	
	String NAME = "UnderlierChoice";
	String DEFINITION = "";
	
	ValidationResult<Underlier> validate(RosettaPath path, Underlier underlier);
	
	class Default implements UnderlierChoice {
	
		@Override
		public ValidationResult<Underlier> validate(RosettaPath path, Underlier underlier) {
			ComparisonResult result = executeDataRule(underlier);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Underlier", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Underlier", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Underlier underlier) {
			try {
				return choice(MapperS.of(underlier), Arrays.asList("Observable", "Product"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements UnderlierChoice {
	
		@Override
		public ValidationResult<Underlier> validate(RosettaPath path, Underlier underlier) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Underlier", path, DEFINITION);
		}
	}
}
