package cdm.observable.asset.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.observable.asset.ForeignExchangeRateIndex;
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
@RosettaDataRule("ForeignExchangeRateIndexFXAssetClass")
@ImplementedBy(ForeignExchangeRateIndexFXAssetClass.Default.class)
public interface ForeignExchangeRateIndexFXAssetClass extends Validator<ForeignExchangeRateIndex> {
	
	String NAME = "ForeignExchangeRateIndexFXAssetClass";
	String DEFINITION = "assetClass = AssetClassEnum -> ForeignExchange";
	
	ValidationResult<ForeignExchangeRateIndex> validate(RosettaPath path, ForeignExchangeRateIndex foreignExchangeRateIndex);
	
	class Default implements ForeignExchangeRateIndexFXAssetClass {
	
		@Override
		public ValidationResult<ForeignExchangeRateIndex> validate(RosettaPath path, ForeignExchangeRateIndex foreignExchangeRateIndex) {
			ComparisonResult result = executeDataRule(foreignExchangeRateIndex);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ForeignExchangeRateIndex", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ForeignExchangeRateIndex", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ForeignExchangeRateIndex foreignExchangeRateIndex) {
			try {
				return areEqual(MapperS.of(foreignExchangeRateIndex).<AssetClassEnum>map("getAssetClass", _foreignExchangeRateIndex -> _foreignExchangeRateIndex.getAssetClass()), MapperS.of(AssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ForeignExchangeRateIndexFXAssetClass {
	
		@Override
		public ValidationResult<ForeignExchangeRateIndex> validate(RosettaPath path, ForeignExchangeRateIndex foreignExchangeRateIndex) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ForeignExchangeRateIndex", path, DEFINITION);
		}
	}
}
