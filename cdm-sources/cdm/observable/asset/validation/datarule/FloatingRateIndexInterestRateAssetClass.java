package cdm.observable.asset.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.observable.asset.FloatingRateIndex;
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
@RosettaDataRule("FloatingRateIndexInterestRateAssetClass")
@ImplementedBy(FloatingRateIndexInterestRateAssetClass.Default.class)
public interface FloatingRateIndexInterestRateAssetClass extends Validator<FloatingRateIndex> {
	
	String NAME = "FloatingRateIndexInterestRateAssetClass";
	String DEFINITION = "assetClass = AssetClassEnum -> InterestRate";
	
	ValidationResult<FloatingRateIndex> validate(RosettaPath path, FloatingRateIndex floatingRateIndex);
	
	class Default implements FloatingRateIndexInterestRateAssetClass {
	
		@Override
		public ValidationResult<FloatingRateIndex> validate(RosettaPath path, FloatingRateIndex floatingRateIndex) {
			ComparisonResult result = executeDataRule(floatingRateIndex);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingRateIndex", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FloatingRateIndex", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FloatingRateIndex floatingRateIndex) {
			try {
				return areEqual(MapperS.of(floatingRateIndex).<AssetClassEnum>map("getAssetClass", _floatingRateIndex -> _floatingRateIndex.getAssetClass()), MapperS.of(AssetClassEnum.INTEREST_RATE), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FloatingRateIndexInterestRateAssetClass {
	
		@Override
		public ValidationResult<FloatingRateIndex> validate(RosettaPath path, FloatingRateIndex floatingRateIndex) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingRateIndex", path, DEFINITION);
		}
	}
}
