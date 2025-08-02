package cdm.product.template.validation.datarule;

import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.VarianceReturnTerms;
import cdm.product.asset.VolatilityReturnTerms;
import cdm.product.template.PerformancePayout;
import cdm.product.template.ReturnTerms;
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
@RosettaDataRule("PerformancePayoutNoSharePriceDividendAdjustmentIndex")
@ImplementedBy(PerformancePayoutNoSharePriceDividendAdjustmentIndex.Default.class)
public interface PerformancePayoutNoSharePriceDividendAdjustmentIndex extends Validator<PerformancePayout> {
	
	String NAME = "PerformancePayoutNoSharePriceDividendAdjustmentIndex";
	String DEFINITION = "if underlier -> Observable -> Index exists then returnTerms -> varianceReturnTerms -> sharePriceDividendAdjustment is absent and returnTerms -> volatilityReturnTerms -> sharePriceDividendAdjustment is absent";
	
	ValidationResult<PerformancePayout> validate(RosettaPath path, PerformancePayout performancePayout);
	
	class Default implements PerformancePayoutNoSharePriceDividendAdjustmentIndex {
	
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
				if (exists(MapperS.of(performancePayout).<Underlier>map("getUnderlier", _performancePayout -> _performancePayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex())).getOrDefault(false)) {
					return notExists(MapperS.of(performancePayout).<ReturnTerms>map("getReturnTerms", _performancePayout -> _performancePayout.getReturnTerms()).<VarianceReturnTerms>map("getVarianceReturnTerms", returnTerms -> returnTerms.getVarianceReturnTerms()).<Boolean>map("getSharePriceDividendAdjustment", varianceReturnTerms -> varianceReturnTerms.getSharePriceDividendAdjustment())).and(notExists(MapperS.of(performancePayout).<ReturnTerms>map("getReturnTerms", _performancePayout -> _performancePayout.getReturnTerms()).<VolatilityReturnTerms>map("getVolatilityReturnTerms", returnTerms -> returnTerms.getVolatilityReturnTerms()).<Boolean>map("getSharePriceDividendAdjustment", volatilityReturnTerms -> volatilityReturnTerms.getSharePriceDividendAdjustment())));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PerformancePayoutNoSharePriceDividendAdjustmentIndex {
	
		@Override
		public ValidationResult<PerformancePayout> validate(RosettaPath path, PerformancePayout performancePayout) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PerformancePayout", path, DEFINITION);
		}
	}
}
