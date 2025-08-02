package cdm.product.asset.validation.datarule;

import cdm.product.asset.RateSpecification;
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
@RosettaDataRule("RateSpecificationChoice")
@ImplementedBy(RateSpecificationChoice.Default.class)
public interface RateSpecificationChoice extends Validator<RateSpecification> {
	
	String NAME = "RateSpecificationChoice";
	String DEFINITION = "";
	
	ValidationResult<RateSpecification> validate(RosettaPath path, RateSpecification rateSpecification);
	
	class Default implements RateSpecificationChoice {
	
		@Override
		public ValidationResult<RateSpecification> validate(RosettaPath path, RateSpecification rateSpecification) {
			ComparisonResult result = executeDataRule(rateSpecification);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RateSpecification", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "RateSpecification", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(RateSpecification rateSpecification) {
			try {
				return choice(MapperS.of(rateSpecification), Arrays.asList("FixedRateSpecification", "FloatingRateSpecification", "InflationRateSpecification"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RateSpecificationChoice {
	
		@Override
		public ValidationResult<RateSpecification> validate(RosettaPath path, RateSpecification rateSpecification) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RateSpecification", path, DEFINITION);
		}
	}
}
