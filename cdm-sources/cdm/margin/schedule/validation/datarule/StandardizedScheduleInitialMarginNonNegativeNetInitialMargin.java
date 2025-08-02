package cdm.margin.schedule.validation.datarule;

import cdm.margin.schedule.StandardizedScheduleInitialMargin;
import cdm.observable.asset.Money;
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
@RosettaDataRule("StandardizedScheduleInitialMarginNonNegativeNetInitialMargin")
@ImplementedBy(StandardizedScheduleInitialMarginNonNegativeNetInitialMargin.Default.class)
public interface StandardizedScheduleInitialMarginNonNegativeNetInitialMargin extends Validator<StandardizedScheduleInitialMargin> {
	
	String NAME = "StandardizedScheduleInitialMarginNonNegativeNetInitialMargin";
	String DEFINITION = "netInitialMargin -> value >= 0";
	
	ValidationResult<StandardizedScheduleInitialMargin> validate(RosettaPath path, StandardizedScheduleInitialMargin standardizedScheduleInitialMargin);
	
	class Default implements StandardizedScheduleInitialMarginNonNegativeNetInitialMargin {
	
		@Override
		public ValidationResult<StandardizedScheduleInitialMargin> validate(RosettaPath path, StandardizedScheduleInitialMargin standardizedScheduleInitialMargin) {
			ComparisonResult result = executeDataRule(standardizedScheduleInitialMargin);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StandardizedScheduleInitialMargin", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "StandardizedScheduleInitialMargin", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(StandardizedScheduleInitialMargin standardizedScheduleInitialMargin) {
			try {
				return greaterThanEquals(MapperS.of(standardizedScheduleInitialMargin).<Money>map("getNetInitialMargin", _standardizedScheduleInitialMargin -> _standardizedScheduleInitialMargin.getNetInitialMargin()).<BigDecimal>map("getValue", money -> money.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StandardizedScheduleInitialMarginNonNegativeNetInitialMargin {
	
		@Override
		public ValidationResult<StandardizedScheduleInitialMargin> validate(RosettaPath path, StandardizedScheduleInitialMargin standardizedScheduleInitialMargin) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StandardizedScheduleInitialMargin", path, DEFINITION);
		}
	}
}
