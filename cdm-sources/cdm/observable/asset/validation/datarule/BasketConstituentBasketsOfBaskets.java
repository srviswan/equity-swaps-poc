package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.Basket;
import cdm.observable.asset.BasketConstituent;
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
@RosettaDataRule("BasketConstituentBasketsOfBaskets")
@ImplementedBy(BasketConstituentBasketsOfBaskets.Default.class)
public interface BasketConstituentBasketsOfBaskets extends Validator<BasketConstituent> {
	
	String NAME = "BasketConstituentBasketsOfBaskets";
	String DEFINITION = "Basket is absent";
	
	ValidationResult<BasketConstituent> validate(RosettaPath path, BasketConstituent basketConstituent);
	
	class Default implements BasketConstituentBasketsOfBaskets {
	
		@Override
		public ValidationResult<BasketConstituent> validate(RosettaPath path, BasketConstituent basketConstituent) {
			ComparisonResult result = executeDataRule(basketConstituent);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BasketConstituent", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "BasketConstituent", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(BasketConstituent basketConstituent) {
			try {
				return notExists(MapperS.of(basketConstituent).<Basket>map("getBasket", _basketConstituent -> _basketConstituent.getBasket()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BasketConstituentBasketsOfBaskets {
	
		@Override
		public ValidationResult<BasketConstituent> validate(RosettaPath path, BasketConstituent basketConstituent) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BasketConstituent", path, DEFINITION);
		}
	}
}
