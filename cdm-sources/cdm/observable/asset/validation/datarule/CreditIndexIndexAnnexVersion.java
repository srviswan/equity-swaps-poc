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

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0
 */
@RosettaDataRule("CreditIndexIndexAnnexVersion")
@ImplementedBy(CreditIndexIndexAnnexVersion.Default.class)
public interface CreditIndexIndexAnnexVersion extends Validator<CreditIndex> {
	
	String NAME = "CreditIndexIndexAnnexVersion";
	String DEFINITION = "if indexAnnexVersion exists then indexAnnexVersion >= 0";
	
	ValidationResult<CreditIndex> validate(RosettaPath path, CreditIndex creditIndex);
	
	class Default implements CreditIndexIndexAnnexVersion {
	
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
				if (exists(MapperS.of(creditIndex).<Integer>map("getIndexAnnexVersion", _creditIndex -> _creditIndex.getIndexAnnexVersion())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(creditIndex).<Integer>map("getIndexAnnexVersion", _creditIndex -> _creditIndex.getIndexAnnexVersion()), MapperS.of(0), CardinalityOperator.All);
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditIndexIndexAnnexVersion {
	
		@Override
		public ValidationResult<CreditIndex> validate(RosettaPath path, CreditIndex creditIndex) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditIndex", path, DEFINITION);
		}
	}
}
