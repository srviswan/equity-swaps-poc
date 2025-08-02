package cdm.observable.asset.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
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
@RosettaDataRule("CreditIndexCreditAssetClass")
@ImplementedBy(CreditIndexCreditAssetClass.Default.class)
public interface CreditIndexCreditAssetClass extends Validator<CreditIndex> {
	
	String NAME = "CreditIndexCreditAssetClass";
	String DEFINITION = "assetClass = AssetClassEnum -> Credit";
	
	ValidationResult<CreditIndex> validate(RosettaPath path, CreditIndex creditIndex);
	
	class Default implements CreditIndexCreditAssetClass {
	
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
				return areEqual(MapperS.of(creditIndex).<AssetClassEnum>map("getAssetClass", _creditIndex -> _creditIndex.getAssetClass()), MapperS.of(AssetClassEnum.CREDIT), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditIndexCreditAssetClass {
	
		@Override
		public ValidationResult<CreditIndex> validate(RosettaPath path, CreditIndex creditIndex) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditIndex", path, DEFINITION);
		}
	}
}
