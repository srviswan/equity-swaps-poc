package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.party.LegalEntity;
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
@RosettaDataRule("AssetBaseRelatedExchange")
@ImplementedBy(AssetBaseRelatedExchange.Default.class)
public interface AssetBaseRelatedExchange extends Validator<AssetBase> {
	
	String NAME = "AssetBaseRelatedExchange";
	String DEFINITION = "if exchange is absent then relatedExchange is absent";
	
	ValidationResult<AssetBase> validate(RosettaPath path, AssetBase assetBase);
	
	class Default implements AssetBaseRelatedExchange {
	
		@Override
		public ValidationResult<AssetBase> validate(RosettaPath path, AssetBase assetBase) {
			ComparisonResult result = executeDataRule(assetBase);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetBase", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "AssetBase", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(AssetBase assetBase) {
			try {
				if (notExists(MapperS.of(assetBase).<LegalEntity>map("getExchange", _assetBase -> _assetBase.getExchange())).getOrDefault(false)) {
					return notExists(MapperS.of(assetBase).<LegalEntity>mapC("getRelatedExchange", _assetBase -> _assetBase.getRelatedExchange()));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetBaseRelatedExchange {
	
		@Override
		public ValidationResult<AssetBase> validate(RosettaPath path, AssetBase assetBase) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetBase", path, DEFINITION);
		}
	}
}
