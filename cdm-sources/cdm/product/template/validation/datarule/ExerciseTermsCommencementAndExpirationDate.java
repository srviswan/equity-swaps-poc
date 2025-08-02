package cdm.product.template.validation.datarule;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.product.template.ExerciseTerms;
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
@RosettaDataRule("ExerciseTermsCommencementAndExpirationDate")
@ImplementedBy(ExerciseTermsCommencementAndExpirationDate.Default.class)
public interface ExerciseTermsCommencementAndExpirationDate extends Validator<ExerciseTerms> {
	
	String NAME = "ExerciseTermsCommencementAndExpirationDate";
	String DEFINITION = "if commencementDate exists then expirationDate exists";
	
	ValidationResult<ExerciseTerms> validate(RosettaPath path, ExerciseTerms exerciseTerms);
	
	class Default implements ExerciseTermsCommencementAndExpirationDate {
	
		@Override
		public ValidationResult<ExerciseTerms> validate(RosettaPath path, ExerciseTerms exerciseTerms) {
			ComparisonResult result = executeDataRule(exerciseTerms);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseTerms", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ExerciseTerms", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ExerciseTerms exerciseTerms) {
			try {
				if (exists(MapperS.of(exerciseTerms).<AdjustableOrRelativeDate>map("getCommencementDate", _exerciseTerms -> _exerciseTerms.getCommencementDate())).getOrDefault(false)) {
					return exists(MapperS.of(exerciseTerms).<AdjustableOrRelativeDate>mapC("getExpirationDate", _exerciseTerms -> _exerciseTerms.getExpirationDate()));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExerciseTermsCommencementAndExpirationDate {
	
		@Override
		public ValidationResult<ExerciseTerms> validate(RosettaPath path, ExerciseTerms exerciseTerms) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseTerms", path, DEFINITION);
		}
	}
}
