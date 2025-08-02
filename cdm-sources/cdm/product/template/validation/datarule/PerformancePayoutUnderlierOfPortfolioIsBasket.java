package cdm.product.template.validation.datarule;

import cdm.observable.asset.Basket;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.PriceReturnTerms;
import cdm.product.template.PerformancePayout;
import cdm.product.template.PortfolioReturnTerms;
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
@RosettaDataRule("PerformancePayoutUnderlierOfPortfolioIsBasket")
@ImplementedBy(PerformancePayoutUnderlierOfPortfolioIsBasket.Default.class)
public interface PerformancePayoutUnderlierOfPortfolioIsBasket extends Validator<PerformancePayout> {
	
	String NAME = "PerformancePayoutUnderlierOfPortfolioIsBasket";
	String DEFINITION = "if portfolioReturnTerms -> priceReturnTerms exists then underlier -> Observable -> Basket exists";
	
	ValidationResult<PerformancePayout> validate(RosettaPath path, PerformancePayout performancePayout);
	
	class Default implements PerformancePayoutUnderlierOfPortfolioIsBasket {
	
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
				if (exists(MapperS.of(performancePayout).<PortfolioReturnTerms>mapC("getPortfolioReturnTerms", _performancePayout -> _performancePayout.getPortfolioReturnTerms()).<PriceReturnTerms>map("getPriceReturnTerms", portfolioReturnTerms -> portfolioReturnTerms.getPriceReturnTerms())).getOrDefault(false)) {
					return exists(MapperS.of(performancePayout).<Underlier>map("getUnderlier", _performancePayout -> _performancePayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PerformancePayoutUnderlierOfPortfolioIsBasket {
	
		@Override
		public ValidationResult<PerformancePayout> validate(RosettaPath path, PerformancePayout performancePayout) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PerformancePayout", path, DEFINITION);
		}
	}
}
