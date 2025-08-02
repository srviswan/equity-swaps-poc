package cdm.product.template.validation.datarule;

import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.base.datetime.BusinessCenterTime;
import cdm.product.template.ExerciseFee;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.OptionExerciseStyleEnum;
import cdm.product.template.PartialExercise;
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
@RosettaDataRule("ExerciseTermsBermudaExercise")
@ImplementedBy(ExerciseTermsBermudaExercise.Default.class)
public interface ExerciseTermsBermudaExercise extends Validator<ExerciseTerms> {
	
	String NAME = "ExerciseTermsBermudaExercise";
	String DEFINITION = "if style = OptionExerciseStyleEnum -> Bermuda then exerciseDates exists and earliestExerciseTime exists and partialExercise is absent and exerciseFee is absent";
	
	ValidationResult<ExerciseTerms> validate(RosettaPath path, ExerciseTerms exerciseTerms);
	
	class Default implements ExerciseTermsBermudaExercise {
	
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
				if (areEqual(MapperS.of(exerciseTerms).<OptionExerciseStyleEnum>map("getStyle", _exerciseTerms -> _exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.BERMUDA), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(exerciseTerms).<AdjustableOrRelativeDates>map("getExerciseDates", _exerciseTerms -> _exerciseTerms.getExerciseDates())).and(exists(MapperS.of(exerciseTerms).<BusinessCenterTime>map("getEarliestExerciseTime", _exerciseTerms -> _exerciseTerms.getEarliestExerciseTime()))).and(notExists(MapperS.of(exerciseTerms).<PartialExercise>map("getPartialExercise", _exerciseTerms -> _exerciseTerms.getPartialExercise()))).and(notExists(MapperS.of(exerciseTerms).<ExerciseFee>map("getExerciseFee", _exerciseTerms -> _exerciseTerms.getExerciseFee())));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExerciseTermsBermudaExercise {
	
		@Override
		public ValidationResult<ExerciseTerms> validate(RosettaPath path, ExerciseTerms exerciseTerms) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseTerms", path, DEFINITION);
		}
	}
}
