package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.CurrencyCodeEnum;
import cdm.base.staticdata.asset.common.functions.AssetIdentifierByType;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0
 */
@RosettaDataRule("CashCurrencyExists")
@ImplementedBy(CashCurrencyExists.Default.class)
public interface CashCurrencyExists extends Validator<Cash> {
	
	String NAME = "CashCurrencyExists";
	String DEFINITION = "AssetIdentifierByType(identifier, AssetIdTypeEnum -> CurrencyCode) count = 1 and AssetIdentifierByType(identifier, AssetIdTypeEnum -> CurrencyCode) -> identifier first to-enum CurrencyCodeEnum exists";
	
	ValidationResult<Cash> validate(RosettaPath path, Cash cash);
	
	class Default implements CashCurrencyExists {
	
		@Inject protected AssetIdentifierByType assetIdentifierByType;
		
		@Override
		public ValidationResult<Cash> validate(RosettaPath path, Cash cash) {
			ComparisonResult result = executeDataRule(cash);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Cash", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Cash", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Cash cash) {
			try {
				return areEqual(MapperS.of(MapperC.<AssetIdentifier>of(assetIdentifierByType.evaluate(MapperS.of(cash).<AssetIdentifier>mapC("getIdentifier", _cash -> _cash.getIdentifier()).getMulti(), AssetIdTypeEnum.CURRENCY_CODE)).resultCount()), MapperS.of(1), CardinalityOperator.All).and(exists(MapperC.<AssetIdentifier>of(assetIdentifierByType.evaluate(MapperS.of(cash).<AssetIdentifier>mapC("getIdentifier", _cash -> _cash.getIdentifier()).getMulti(), AssetIdTypeEnum.CURRENCY_CODE)).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())
					.first().<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()).checkedMap("to-enum", CurrencyCodeEnum::fromDisplayName, IllegalArgumentException.class)));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CashCurrencyExists {
	
		@Override
		public ValidationResult<Cash> validate(RosettaPath path, Cash cash) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Cash", path, DEFINITION);
		}
	}
}
