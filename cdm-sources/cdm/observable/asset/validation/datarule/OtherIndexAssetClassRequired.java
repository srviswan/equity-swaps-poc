package cdm.observable.asset.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.observable.asset.OtherIndex;
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
@RosettaDataRule("OtherIndexAssetClassRequired")
@ImplementedBy(OtherIndexAssetClassRequired.Default.class)
public interface OtherIndexAssetClassRequired extends Validator<OtherIndex> {
	
	String NAME = "OtherIndexAssetClassRequired";
	String DEFINITION = "assetClass exists";
	
	ValidationResult<OtherIndex> validate(RosettaPath path, OtherIndex otherIndex);
	
	class Default implements OtherIndexAssetClassRequired {
	
		@Override
		public ValidationResult<OtherIndex> validate(RosettaPath path, OtherIndex otherIndex) {
			ComparisonResult result = executeDataRule(otherIndex);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OtherIndex", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "OtherIndex", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(OtherIndex otherIndex) {
			try {
				return exists(MapperS.of(otherIndex).<AssetClassEnum>map("getAssetClass", _otherIndex -> _otherIndex.getAssetClass()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OtherIndexAssetClassRequired {
	
		@Override
		public ValidationResult<OtherIndex> validate(RosettaPath path, OtherIndex otherIndex) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OtherIndex", path, DEFINITION);
		}
	}
}
