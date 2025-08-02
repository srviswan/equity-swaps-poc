package cdm.margin.schedule.validation.datarule;

import cdm.margin.schedule.StandardizedScheduleTradeInfo;
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
@RosettaDataRule("StandardizedScheduleTradeInfoPositiveGrossInitialMargin")
@ImplementedBy(StandardizedScheduleTradeInfoPositiveGrossInitialMargin.Default.class)
public interface StandardizedScheduleTradeInfoPositiveGrossInitialMargin extends Validator<StandardizedScheduleTradeInfo> {
	
	String NAME = "StandardizedScheduleTradeInfoPositiveGrossInitialMargin";
	String DEFINITION = "grossInitialMargin -> value > 0";
	
	ValidationResult<StandardizedScheduleTradeInfo> validate(RosettaPath path, StandardizedScheduleTradeInfo standardizedScheduleTradeInfo);
	
	class Default implements StandardizedScheduleTradeInfoPositiveGrossInitialMargin {
	
		@Override
		public ValidationResult<StandardizedScheduleTradeInfo> validate(RosettaPath path, StandardizedScheduleTradeInfo standardizedScheduleTradeInfo) {
			ComparisonResult result = executeDataRule(standardizedScheduleTradeInfo);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StandardizedScheduleTradeInfo", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "StandardizedScheduleTradeInfo", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(StandardizedScheduleTradeInfo standardizedScheduleTradeInfo) {
			try {
				return greaterThan(MapperS.of(standardizedScheduleTradeInfo).<Money>map("getGrossInitialMargin", _standardizedScheduleTradeInfo -> _standardizedScheduleTradeInfo.getGrossInitialMargin()).<BigDecimal>map("getValue", money -> money.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StandardizedScheduleTradeInfoPositiveGrossInitialMargin {
	
		@Override
		public ValidationResult<StandardizedScheduleTradeInfo> validate(RosettaPath path, StandardizedScheduleTradeInfo standardizedScheduleTradeInfo) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StandardizedScheduleTradeInfo", path, DEFINITION);
		}
	}
}
