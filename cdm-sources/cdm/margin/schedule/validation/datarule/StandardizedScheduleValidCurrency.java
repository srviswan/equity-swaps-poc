package cdm.margin.schedule.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.margin.schedule.StandardizedSchedule;
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
@RosettaDataRule("StandardizedScheduleValidCurrency")
@ImplementedBy(StandardizedScheduleValidCurrency.Default.class)
public interface StandardizedScheduleValidCurrency extends Validator<StandardizedSchedule> {
	
	String NAME = "StandardizedScheduleValidCurrency";
	String DEFINITION = "notionalCurrency to-enum ISOCurrencyCodeEnum exists";
	
	ValidationResult<StandardizedSchedule> validate(RosettaPath path, StandardizedSchedule standardizedSchedule);
	
	class Default implements StandardizedScheduleValidCurrency {
	
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
				return exists(MapperS.of(standardizedSchedule).<String>map("getNotionalCurrency", _standardizedSchedule -> _standardizedSchedule.getNotionalCurrency()).checkedMap("to-enum", ISOCurrencyCodeEnum::fromDisplayName, IllegalArgumentException.class));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StandardizedScheduleValidCurrency {
	
		@Override
		public ValidationResult<StandardizedSchedule> validate(RosettaPath path, StandardizedSchedule standardizedSchedule) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StandardizedSchedule", path, DEFINITION);
		}
	}
}
