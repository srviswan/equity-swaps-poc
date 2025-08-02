package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.Instrument;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0
 */
@RosettaDataRule("InstrumentChoice")
@ImplementedBy(InstrumentChoice.Default.class)
public interface InstrumentChoice extends Validator<Instrument> {
	
	String NAME = "InstrumentChoice";
	String DEFINITION = "";
	
	ValidationResult<Instrument> validate(RosettaPath path, Instrument instrument);
	
	class Default implements InstrumentChoice {
	
		@Override
		public ValidationResult<Instrument> validate(RosettaPath path, Instrument instrument) {
			ComparisonResult result = executeDataRule(instrument);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Instrument", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Instrument", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Instrument instrument) {
			try {
				return choice(MapperS.of(instrument), Arrays.asList("ListedDerivative", "Loan", "Security"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InstrumentChoice {
	
		@Override
		public ValidationResult<Instrument> validate(RosettaPath path, Instrument instrument) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Instrument", path, DEFINITION);
		}
	}
}
