package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.CreditIndex;
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
@RosettaDataRule("CreditIndexIndexFactor")
@ImplementedBy(CreditIndexIndexFactor.Default.class)
public interface CreditIndexIndexFactor extends Validator<CreditIndex> {
	
	String NAME = "CreditIndexIndexFactor";
	String DEFINITION = "if indexFactor exists then indexFactor >= 0 and indexFactor <= 1";
	
	ValidationResult<CreditIndex> validate(RosettaPath path, CreditIndex creditIndex);
	
	class Default implements CreditIndexIndexFactor {
	
		@Override
		public ValidationResult<CreditIndex> validate(RosettaPath path, CreditIndex creditIndex) {
			ComparisonResult result = executeDataRule(creditIndex);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditIndex", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CreditIndex", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CreditIndex creditIndex) {
			try {
				if (exists(MapperS.of(creditIndex).<BigDecimal>map("getIndexFactor", _creditIndex -> _creditIndex.getIndexFactor())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(creditIndex).<BigDecimal>map("getIndexFactor", _creditIndex -> _creditIndex.getIndexFactor()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).and(lessThanEquals(MapperS.of(creditIndex).<BigDecimal>map("getIndexFactor", _creditIndex -> _creditIndex.getIndexFactor()), MapperS.of(BigDecimal.valueOf(1)), CardinalityOperator.All));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditIndexIndexFactor {
	
		@Override
		public ValidationResult<CreditIndex> validate(RosettaPath path, CreditIndex creditIndex) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditIndex", path, DEFINITION);
		}
	}
}
