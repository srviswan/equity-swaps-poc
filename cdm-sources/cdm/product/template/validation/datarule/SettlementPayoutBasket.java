package cdm.product.template.validation.datarule;

import cdm.base.staticdata.asset.common.Asset;
import cdm.observable.asset.Basket;
import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
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
@RosettaDataRule("SettlementPayoutBasket")
@ImplementedBy(SettlementPayoutBasket.Default.class)
public interface SettlementPayoutBasket extends Validator<SettlementPayout> {
	
	String NAME = "SettlementPayoutBasket";
	String DEFINITION = "if underlier -> Observable -> Basket exists then (underlier -> Observable -> Basket -> basketConstituent extract Asset exists ) all = True";
	
	ValidationResult<SettlementPayout> validate(RosettaPath path, SettlementPayout settlementPayout);
	
	class Default implements SettlementPayoutBasket {
	
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
				if (exists(MapperS.of(settlementPayout).<Underlier>map("getUnderlier", _settlementPayout -> _settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Basket>map("getBasket", observable -> observable.getBasket())).getOrDefault(false)) {
					return areEqual(MapperS.of(settlementPayout).<Underlier>map("getUnderlier", _settlementPayout -> _settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()).<FieldWithMetaBasketConstituent>mapC("getBasketConstituent", basket -> basket.getBasketConstituent())
						.mapItem(item -> exists(item.<BasketConstituent>map("Type coercion", fieldWithMetaBasketConstituent -> fieldWithMetaBasketConstituent == null ? null : fieldWithMetaBasketConstituent.getValue()).<Asset>map("getAsset", basketConstituent -> basketConstituent.getAsset())).asMapper()), MapperS.of(true), CardinalityOperator.All);
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementPayoutBasket {
	
		@Override
		public ValidationResult<SettlementPayout> validate(RosettaPath path, SettlementPayout settlementPayout) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPayout", path, DEFINITION);
		}
	}
}
