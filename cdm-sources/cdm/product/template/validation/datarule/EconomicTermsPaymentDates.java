package cdm.product.template.validation.datarule;

import cdm.base.datetime.daycount.metafields.FieldWithMetaDayCountFractionEnum;
import cdm.product.asset.InterestRatePayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
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
@RosettaDataRule("EconomicTermsPaymentDates")
@ImplementedBy(EconomicTermsPaymentDates.Default.class)
public interface EconomicTermsPaymentDates extends Validator<EconomicTerms> {
	
	String NAME = "EconomicTermsPaymentDates";
	String DEFINITION = "if payout -> InterestRatePayout count = 2 then payout -> InterestRatePayout -> dayCountFraction exists";
	
	ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms);
	
	class Default implements EconomicTermsPaymentDates {
	
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
				if (areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).resultCount()), MapperS.of(2), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", interestRatePayout -> interestRatePayout.getDayCountFraction()));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EconomicTermsPaymentDates {
	
		@Override
		public ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION);
		}
	}
}
