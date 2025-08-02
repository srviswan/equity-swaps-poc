package cdm.observable.asset.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.observable.asset.EquityIndex;
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
@RosettaDataRule("EquityIndexEquityAssetClass")
@ImplementedBy(EquityIndexEquityAssetClass.Default.class)
public interface EquityIndexEquityAssetClass extends Validator<EquityIndex> {
	
	String NAME = "EquityIndexEquityAssetClass";
	String DEFINITION = "assetClass = AssetClassEnum -> Equity";
	
	ValidationResult<EquityIndex> validate(RosettaPath path, EquityIndex equityIndex);
	
	class Default implements EquityIndexEquityAssetClass {
	
		@Override
		public ValidationResult<EquityIndex> validate(RosettaPath path, EquityIndex equityIndex) {
			ComparisonResult result = executeDataRule(equityIndex);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityIndex", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "EquityIndex", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(EquityIndex equityIndex) {
			try {
				return areEqual(MapperS.of(equityIndex).<AssetClassEnum>map("getAssetClass", _equityIndex -> _equityIndex.getAssetClass()), MapperS.of(AssetClassEnum.EQUITY), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityIndexEquityAssetClass {
	
		@Override
		public ValidationResult<EquityIndex> validate(RosettaPath path, EquityIndex equityIndex) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityIndex", path, DEFINITION);
		}
	}
}
