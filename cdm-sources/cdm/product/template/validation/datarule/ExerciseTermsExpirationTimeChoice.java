package cdm.product.template.validation.datarule;

import cdm.base.datetime.BusinessCenterTime;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.ExpirationTimeTypeEnum;
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
@RosettaDataRule("ExerciseTermsExpirationTimeChoice")
@ImplementedBy(ExerciseTermsExpirationTimeChoice.Default.class)
public interface ExerciseTermsExpirationTimeChoice extends Validator<ExerciseTerms> {
	
	String NAME = "ExerciseTermsExpirationTimeChoice";
	String DEFINITION = "(if expirationTime exists then expirationTimeType = ExpirationTimeTypeEnum -> SpecificTime and if expirationTimeType = ExpirationTimeTypeEnum -> SpecificTime then expirationTime exists)";
	
	ValidationResult<ExerciseTerms> validate(RosettaPath path, ExerciseTerms exerciseTerms);
	
	class Default implements ExerciseTermsExpirationTimeChoice {
	
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
				if (exists(MapperS.of(exerciseTerms).<BusinessCenterTime>map("getExpirationTime", _exerciseTerms -> _exerciseTerms.getExpirationTime())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (areEqual(MapperS.of(exerciseTerms).<ExpirationTimeTypeEnum>map("getExpirationTimeType", _exerciseTerms -> _exerciseTerms.getExpirationTimeType()), MapperS.of(ExpirationTimeTypeEnum.SPECIFIC_TIME), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult = exists(MapperS.of(exerciseTerms).<BusinessCenterTime>map("getExpirationTime", _exerciseTerms -> _exerciseTerms.getExpirationTime()));
					} else {
						ifThenElseResult = ComparisonResult.successEmptyOperand("");
					}
					return areEqual(MapperS.of(exerciseTerms).<ExpirationTimeTypeEnum>map("getExpirationTimeType", _exerciseTerms -> _exerciseTerms.getExpirationTimeType()), MapperS.of(ExpirationTimeTypeEnum.SPECIFIC_TIME), CardinalityOperator.All).and(ifThenElseResult);
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExerciseTermsExpirationTimeChoice {
	
		@Override
		public ValidationResult<ExerciseTerms> validate(RosettaPath path, ExerciseTerms exerciseTerms) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseTerms", path, DEFINITION);
		}
	}
}
