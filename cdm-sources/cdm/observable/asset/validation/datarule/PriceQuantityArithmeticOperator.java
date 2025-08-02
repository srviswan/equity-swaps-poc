package cdm.observable.asset.validation.datarule;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.FieldWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
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
@RosettaDataRule("PriceQuantityArithmeticOperator")
@ImplementedBy(PriceQuantityArithmeticOperator.Default.class)
public interface PriceQuantityArithmeticOperator extends Validator<PriceQuantity> {
	
	String NAME = "PriceQuantityArithmeticOperator";
	String DEFINITION = "if observable -> Index -> InterestRateIndex exists and price exists then price -> arithmeticOperator exists";
	
	ValidationResult<PriceQuantity> validate(RosettaPath path, PriceQuantity priceQuantity);
	
	class Default implements PriceQuantityArithmeticOperator {
	
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
				if (exists(MapperS.of(priceQuantity).<FieldWithMetaObservable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable -> fieldWithMetaObservable == null ? null : fieldWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", index -> index.getInterestRateIndex())).and(exists(MapperS.of(priceQuantity).<FieldWithMetaPriceSchedule>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()))).getOrDefault(false)) {
					return exists(MapperS.of(priceQuantity).<FieldWithMetaPriceSchedule>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()).<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator()));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PriceQuantityArithmeticOperator {
	
		@Override
		public ValidationResult<PriceQuantity> validate(RosettaPath path, PriceQuantity priceQuantity) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceQuantity", path, DEFINITION);
		}
	}
}
