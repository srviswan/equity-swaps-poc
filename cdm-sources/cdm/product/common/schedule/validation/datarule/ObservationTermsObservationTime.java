package cdm.product.common.schedule.validation.datarule;

import cdm.base.datetime.BusinessCenterTime;
import cdm.observable.common.TimeTypeEnum;
import cdm.product.common.schedule.ObservationTerms;
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
@RosettaDataRule("ObservationTermsObservationTime")
@ImplementedBy(ObservationTermsObservationTime.Default.class)
public interface ObservationTermsObservationTime extends Validator<ObservationTerms> {
	
	String NAME = "ObservationTermsObservationTime";
	String DEFINITION = "if observationTimeType = TimeTypeEnum -> SpecificTime then observationTime exists";
	
	ValidationResult<ObservationTerms> validate(RosettaPath path, ObservationTerms observationTerms);
	
	class Default implements ObservationTermsObservationTime {
	
		@Override
		public ValidationResult<ObservationTerms> validate(RosettaPath path, ObservationTerms observationTerms) {
			ComparisonResult result = executeDataRule(observationTerms);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ObservationTerms", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ObservationTerms", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ObservationTerms observationTerms) {
			try {
				if (areEqual(MapperS.of(observationTerms).<TimeTypeEnum>map("getObservationTimeType", _observationTerms -> _observationTerms.getObservationTimeType()), MapperS.of(TimeTypeEnum.SPECIFIC_TIME), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(observationTerms).<BusinessCenterTime>map("getObservationTime", _observationTerms -> _observationTerms.getObservationTime()));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ObservationTermsObservationTime {
	
		@Override
		public ValidationResult<ObservationTerms> validate(RosettaPath path, ObservationTerms observationTerms) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ObservationTerms", path, DEFINITION);
		}
	}
}
