package cdm.product.asset.validation.datarule;

import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.product.asset.InflationRateSpecification;
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
@RosettaDataRule("InflationRateSpecificationInflationIndex")
@ImplementedBy(InflationRateSpecificationInflationIndex.Default.class)
public interface InflationRateSpecificationInflationIndex extends Validator<InflationRateSpecification> {
	
	String NAME = "InflationRateSpecificationInflationIndex";
	String DEFINITION = "rateOption -> InflationIndex exists";
	
	ValidationResult<InflationRateSpecification> validate(RosettaPath path, InflationRateSpecification inflationRateSpecification);
	
	class Default implements InflationRateSpecificationInflationIndex {
	
		@Override
		public ValidationResult<InflationRateSpecification> validate(RosettaPath path, InflationRateSpecification inflationRateSpecification) {
			ComparisonResult result = executeDataRule(inflationRateSpecification);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InflationRateSpecification", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "InflationRateSpecification", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(InflationRateSpecification inflationRateSpecification) {
			try {
				return exists(MapperS.of(inflationRateSpecification).<ReferenceWithMetaInterestRateIndex>map("getRateOption", _inflationRateSpecification -> _inflationRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex == null ? null : referenceWithMetaInterestRateIndex.getValue()).<InflationIndex>map("getInflationIndex", interestRateIndex -> interestRateIndex.getInflationIndex()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InflationRateSpecificationInflationIndex {
	
		@Override
		public ValidationResult<InflationRateSpecification> validate(RosettaPath path, InflationRateSpecification inflationRateSpecification) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InflationRateSpecification", path, DEFINITION);
		}
	}
}
