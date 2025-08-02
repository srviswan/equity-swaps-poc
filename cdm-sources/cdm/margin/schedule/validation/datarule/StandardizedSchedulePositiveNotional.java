package cdm.margin.schedule.validation.datarule;

import cdm.margin.schedule.StandardizedSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0
 */
@RosettaDataRule("StandardizedSchedulePositiveNotional")
@ImplementedBy(StandardizedSchedulePositiveNotional.Default.class)
public interface StandardizedSchedulePositiveNotional extends Validator<StandardizedSchedule> {
	
	String NAME = "StandardizedSchedulePositiveNotional";
	String DEFINITION = "notional > 0";
	
	ValidationResult<StandardizedSchedule> validate(RosettaPath path, StandardizedSchedule standardizedSchedule);
	
	class Default implements StandardizedSchedulePositiveNotional {
	
		@Override
		public ValidationResult<StandardizedSchedule> validate(RosettaPath path, StandardizedSchedule standardizedSchedule) {
			ComparisonResult result = executeDataRule(standardizedSchedule);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StandardizedSchedule", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "StandardizedSchedule", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(StandardizedSchedule standardizedSchedule) {
			try {
				return greaterThan(MapperS.of(standardizedSchedule).<BigDecimal>map("getNotional", _standardizedSchedule -> _standardizedSchedule.getNotional()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StandardizedSchedulePositiveNotional {
	
		@Override
		public ValidationResult<StandardizedSchedule> validate(RosettaPath path, StandardizedSchedule standardizedSchedule) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StandardizedSchedule", path, DEFINITION);
		}
	}
}
