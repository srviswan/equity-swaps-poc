package cdm.product.template.validation.datarule;

import cdm.observable.asset.CreditIndex;
import cdm.observable.asset.TransactedPrice;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0
 */
@RosettaDataRule("EconomicTermsMarketPrice")
@ImplementedBy(EconomicTermsMarketPrice.Default.class)
public interface EconomicTermsMarketPrice extends Validator<EconomicTerms> {
	
	String NAME = "EconomicTermsMarketPrice";
	String DEFINITION = "if payout -> CreditDefaultPayout -> generalTerms -> indexReferenceInformation is absent then payout -> CreditDefaultPayout -> transactedPrice -> marketFixedRate is absent and payout -> CreditDefaultPayout -> transactedPrice -> marketPrice is absent";
	
	ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms);
	
	class Default implements EconomicTermsMarketPrice {
	
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
				if (notExists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation())).getOrDefault(false)) {
					return notExists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<TransactedPrice>map("getTransactedPrice", creditDefaultPayout -> creditDefaultPayout.getTransactedPrice()).<BigDecimal>map("getMarketFixedRate", transactedPrice -> transactedPrice.getMarketFixedRate())).and(notExists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<TransactedPrice>map("getTransactedPrice", creditDefaultPayout -> creditDefaultPayout.getTransactedPrice()).<BigDecimal>map("getMarketPrice", transactedPrice -> transactedPrice.getMarketPrice())));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EconomicTermsMarketPrice {
	
		@Override
		public ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION);
		}
	}
}
