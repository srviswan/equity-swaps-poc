package cdm.product.template.validation.datarule;

import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.template.PerformancePayout;
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
@RosettaDataRule("PerformancePayoutUnderlier")
@ImplementedBy(PerformancePayoutUnderlier.Default.class)
public interface PerformancePayoutUnderlier extends Validator<PerformancePayout> {
	
	String NAME = "PerformancePayoutUnderlier";
	String DEFINITION = "underlier -> Observable exists";
	
	ValidationResult<PerformancePayout> validate(RosettaPath path, PerformancePayout performancePayout);
	
	class Default implements PerformancePayoutUnderlier {
	
		@Override
		public ValidationResult<PerformancePayout> validate(RosettaPath path, PerformancePayout performancePayout) {
			ComparisonResult result = executeDataRule(performancePayout);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PerformancePayout", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PerformancePayout", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PerformancePayout performancePayout) {
			try {
				return exists(MapperS.of(performancePayout).<Underlier>map("getUnderlier", _performancePayout -> _performancePayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PerformancePayoutUnderlier {
	
		@Override
		public ValidationResult<PerformancePayout> validate(RosettaPath path, PerformancePayout performancePayout) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PerformancePayout", path, DEFINITION);
		}
	}
}
