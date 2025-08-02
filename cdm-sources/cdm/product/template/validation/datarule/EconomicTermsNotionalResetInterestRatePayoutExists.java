package cdm.product.template.validation.datarule;

import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
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
@RosettaDataRule("EconomicTermsNotionalResetInterestRatePayoutExists")
@ImplementedBy(EconomicTermsNotionalResetInterestRatePayoutExists.Default.class)
public interface EconomicTermsNotionalResetInterestRatePayoutExists extends Validator<EconomicTerms> {
	
	String NAME = "EconomicTermsNotionalResetInterestRatePayoutExists";
	String DEFINITION = "if payout -> PerformancePayout -> priceQuantity -> reset contains True then payout -> InterestRatePayout exists";
	
	ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms);
	
	class Default implements EconomicTermsNotionalResetInterestRatePayoutExists {
	
		@Override
		public ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms) {
			ComparisonResult result = executeDataRule(economicTerms);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(EconomicTerms economicTerms) {
			try {
				if (contains(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", performancePayout -> performancePayout.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset()), MapperS.of(true)).getOrDefault(false)) {
					return exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EconomicTermsNotionalResetInterestRatePayoutExists {
	
		@Override
		public ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION);
		}
	}
}
