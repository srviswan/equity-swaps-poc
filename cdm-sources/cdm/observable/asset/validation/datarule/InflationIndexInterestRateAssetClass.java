package cdm.observable.asset.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.observable.asset.InflationIndex;
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
@RosettaDataRule("InflationIndexInterestRateAssetClass")
@ImplementedBy(InflationIndexInterestRateAssetClass.Default.class)
public interface InflationIndexInterestRateAssetClass extends Validator<InflationIndex> {
	
	String NAME = "InflationIndexInterestRateAssetClass";
	String DEFINITION = "assetClass = AssetClassEnum -> InterestRate";
	
	ValidationResult<InflationIndex> validate(RosettaPath path, InflationIndex inflationIndex);
	
	class Default implements InflationIndexInterestRateAssetClass {
	
		@Override
		public ValidationResult<InflationIndex> validate(RosettaPath path, InflationIndex inflationIndex) {
			ComparisonResult result = executeDataRule(inflationIndex);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InflationIndex", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "InflationIndex", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(InflationIndex inflationIndex) {
			try {
				return areEqual(MapperS.of(inflationIndex).<AssetClassEnum>map("getAssetClass", _inflationIndex -> _inflationIndex.getAssetClass()), MapperS.of(AssetClassEnum.INTEREST_RATE), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InflationIndexInterestRateAssetClass {
	
		@Override
		public ValidationResult<InflationIndex> validate(RosettaPath path, InflationIndex inflationIndex) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InflationIndex", path, DEFINITION);
		}
	}
}
