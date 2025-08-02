package cdm.product.template.validation.datarule;

import cdm.product.template.ExerciseTerms;
import cdm.product.template.OptionExerciseStyleEnum;
import cdm.product.template.OptionPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0
 */
@RosettaDataRule("OptionPayoutOptionStylePresent")
@ImplementedBy(OptionPayoutOptionStylePresent.Default.class)
public interface OptionPayoutOptionStylePresent extends Validator<OptionPayout> {
	
	String NAME = "OptionPayoutOptionStylePresent";
	String DEFINITION = "exerciseTerms -> style exists";
	
	ValidationResult<OptionPayout> validate(RosettaPath path, OptionPayout optionPayout);
	
	class Default implements OptionPayoutOptionStylePresent {
	
		@Override
		public ValidationResult<OptionPayout> validate(RosettaPath path, OptionPayout optionPayout) {
			ComparisonResult result = executeDataRule(optionPayout);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionPayout", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "OptionPayout", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(OptionPayout optionPayout) {
			try {
				return exists(MapperS.of(optionPayout).<ExerciseTerms>map("getExerciseTerms", _optionPayout -> _optionPayout.getExerciseTerms()).<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionPayoutOptionStylePresent {
	
		@Override
		public ValidationResult<OptionPayout> validate(RosettaPath path, OptionPayout optionPayout) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionPayout", path, DEFINITION);
		}
	}
}
