package cdm.product.template.validation.datarule;

import cdm.product.template.PerformancePayout;
import cdm.product.template.PortfolioReturnTerms;
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
@RosettaDataRule("PerformancePayoutPortfolioReturnIsMultipleReturns")
@ImplementedBy(PerformancePayoutPortfolioReturnIsMultipleReturns.Default.class)
public interface PerformancePayoutPortfolioReturnIsMultipleReturns extends Validator<PerformancePayout> {
	
	String NAME = "PerformancePayoutPortfolioReturnIsMultipleReturns";
	String DEFINITION = "if portfolioReturnTerms exists then portfolioReturnTerms count > 1";
	
	ValidationResult<PerformancePayout> validate(RosettaPath path, PerformancePayout performancePayout);
	
	class Default implements PerformancePayoutPortfolioReturnIsMultipleReturns {
	
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
				if (exists(MapperS.of(performancePayout).<PortfolioReturnTerms>mapC("getPortfolioReturnTerms", _performancePayout -> _performancePayout.getPortfolioReturnTerms())).getOrDefault(false)) {
					return greaterThan(MapperS.of(MapperS.of(performancePayout).<PortfolioReturnTerms>mapC("getPortfolioReturnTerms", _performancePayout -> _performancePayout.getPortfolioReturnTerms()).resultCount()), MapperS.of(1), CardinalityOperator.All);
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PerformancePayoutPortfolioReturnIsMultipleReturns {
	
		@Override
		public ValidationResult<PerformancePayout> validate(RosettaPath path, PerformancePayout performancePayout) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PerformancePayout", path, DEFINITION);
		}
	}
}
