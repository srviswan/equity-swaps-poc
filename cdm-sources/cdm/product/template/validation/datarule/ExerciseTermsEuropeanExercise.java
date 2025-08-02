package cdm.product.template.validation.datarule;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.BusinessCenterTime;
import cdm.product.template.ExerciseFeeSchedule;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.MultipleExercise;
import cdm.product.template.OptionExerciseStyleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("ExerciseTermsEuropeanExercise")
@ImplementedBy(ExerciseTermsEuropeanExercise.Default.class)
public interface ExerciseTermsEuropeanExercise extends Validator<ExerciseTerms> {
	
	String NAME = "ExerciseTermsEuropeanExercise";
	String DEFINITION = "if style = OptionExerciseStyleEnum -> European then expirationDate exists and exerciseFeeSchedule is absent and multipleExercise is absent and latestExerciseTime is absent and commencementDate is absent";
	
	ValidationResult<ExerciseTerms> validate(RosettaPath path, ExerciseTerms exerciseTerms);
	
	class Default implements ExerciseTermsEuropeanExercise {
	
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
				if (areEqual(MapperS.of(exerciseTerms).<OptionExerciseStyleEnum>map("getStyle", _exerciseTerms -> _exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.EUROPEAN), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(exerciseTerms).<AdjustableOrRelativeDate>mapC("getExpirationDate", _exerciseTerms -> _exerciseTerms.getExpirationDate())).and(notExists(MapperS.of(exerciseTerms).<ExerciseFeeSchedule>map("getExerciseFeeSchedule", _exerciseTerms -> _exerciseTerms.getExerciseFeeSchedule()))).and(notExists(MapperS.of(exerciseTerms).<MultipleExercise>map("getMultipleExercise", _exerciseTerms -> _exerciseTerms.getMultipleExercise()))).and(notExists(MapperS.of(exerciseTerms).<BusinessCenterTime>map("getLatestExerciseTime", _exerciseTerms -> _exerciseTerms.getLatestExerciseTime()))).and(notExists(MapperS.of(exerciseTerms).<AdjustableOrRelativeDate>map("getCommencementDate", _exerciseTerms -> _exerciseTerms.getCommencementDate())));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExerciseTermsEuropeanExercise {
	
		@Override
		public ValidationResult<ExerciseTerms> validate(RosettaPath path, ExerciseTerms exerciseTerms) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseTerms", path, DEFINITION);
		}
	}
}
