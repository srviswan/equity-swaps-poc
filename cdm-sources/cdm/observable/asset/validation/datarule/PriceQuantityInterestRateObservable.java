package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.functions.InterestRateObservableCondition;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import javax.inject.Inject;


/**
 * @version 6.0.0
 */
@RosettaDataRule("PriceQuantityInterestRateObservable")
@ImplementedBy(PriceQuantityInterestRateObservable.Default.class)
public interface PriceQuantityInterestRateObservable extends Validator<PriceQuantity> {
	
	String NAME = "PriceQuantityInterestRateObservable";
	String DEFINITION = "InterestRateObservableCondition";
	
	ValidationResult<PriceQuantity> validate(RosettaPath path, PriceQuantity priceQuantity);
	
	class Default implements PriceQuantityInterestRateObservable {
	
		@Inject protected InterestRateObservableCondition interestRateObservableCondition;
		
		@Override
		public ValidationResult<PriceQuantity> validate(RosettaPath path, PriceQuantity priceQuantity) {
			ComparisonResult result = executeDataRule(priceQuantity);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceQuantity", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PriceQuantity", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PriceQuantity priceQuantity) {
			try {
				return ComparisonResult.of(MapperS.of(interestRateObservableCondition.evaluate(priceQuantity)));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PriceQuantityInterestRateObservable {
	
		@Override
		public ValidationResult<PriceQuantity> validate(RosettaPath path, PriceQuantity priceQuantity) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceQuantity", path, DEFINITION);
		}
	}
}
