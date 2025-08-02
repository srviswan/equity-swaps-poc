package cdm.product.template.validation.datarule;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Cash;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
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
@RosettaDataRule("SettlementPayoutSettlementTerms")
@ImplementedBy(SettlementPayoutSettlementTerms.Default.class)
public interface SettlementPayoutSettlementTerms extends Validator<SettlementPayout> {
	
	String NAME = "SettlementPayoutSettlementTerms";
	String DEFINITION = "if underlier -> Observable -> Asset -> Cash exists then settlementTerms exists";
	
	ValidationResult<SettlementPayout> validate(RosettaPath path, SettlementPayout settlementPayout);
	
	class Default implements SettlementPayoutSettlementTerms {
	
		@Override
		public ValidationResult<SettlementPayout> validate(RosettaPath path, SettlementPayout settlementPayout) {
			ComparisonResult result = executeDataRule(settlementPayout);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPayout", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "SettlementPayout", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(SettlementPayout settlementPayout) {
			try {
				if (exists(MapperS.of(settlementPayout).<Underlier>map("getUnderlier", _settlementPayout -> _settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Cash>map("getCash", asset -> asset.getCash())).getOrDefault(false)) {
					return exists(MapperS.of(settlementPayout).<SettlementTerms>map("getSettlementTerms", _settlementPayout -> _settlementPayout.getSettlementTerms()));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementPayoutSettlementTerms {
	
		@Override
		public ValidationResult<SettlementPayout> validate(RosettaPath path, SettlementPayout settlementPayout) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPayout", path, DEFINITION);
		}
	}
}
