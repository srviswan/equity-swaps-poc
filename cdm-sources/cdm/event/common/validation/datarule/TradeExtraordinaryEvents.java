package cdm.event.common.validation.datarule;

import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.legaldocumentation.common.AgreementTerms;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.contract.Agreement;
import cdm.legaldocumentation.master.EquityAdditionalTerms;
import cdm.legaldocumentation.master.ExtraordinaryEvents;
import cdm.legaldocumentation.master.TransactionAdditionalTerms;
import cdm.product.asset.PriceReturnTerms;
import cdm.product.qualification.functions.Qualify_AssetClass_Equity;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.ReturnTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0
 */
@RosettaDataRule("TradeExtraordinaryEvents")
@ImplementedBy(TradeExtraordinaryEvents.Default.class)
public interface TradeExtraordinaryEvents extends Validator<Trade> {
	
	String NAME = "TradeExtraordinaryEvents";
	String DEFINITION = "if contractDetails -> documentation -> agreementTerms -> agreement -> transactionAdditionalTerms -> equityAdditionalTerms -> extraordinaryEvents exists then (product -> economicTerms -> payout -> PerformancePayout -> returnTerms -> priceReturnTerms exists or product -> economicTerms -> payout -> OptionPayout exists) and Qualify_AssetClass_Equity(product -> economicTerms)";
	
	ValidationResult<Trade> validate(RosettaPath path, Trade trade);
	
	class Default implements TradeExtraordinaryEvents {
	
		@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;
		
		@Override
		public ValidationResult<Trade> validate(RosettaPath path, Trade trade) {
			ComparisonResult result = executeDataRule(trade);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Trade", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Trade", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Trade trade) {
			try {
				if (exists(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<LegalAgreement>mapC("getDocumentation", contractDetails -> contractDetails.getDocumentation()).<AgreementTerms>map("getAgreementTerms", legalAgreement -> legalAgreement.getAgreementTerms()).<Agreement>map("getAgreement", agreementTerms -> agreementTerms.getAgreement()).<TransactionAdditionalTerms>map("getTransactionAdditionalTerms", agreement -> agreement.getTransactionAdditionalTerms()).<EquityAdditionalTerms>map("getEquityAdditionalTerms", transactionAdditionalTerms -> transactionAdditionalTerms.getEquityAdditionalTerms()).<ExtraordinaryEvents>map("getExtraordinaryEvents", equityAdditionalTerms -> equityAdditionalTerms.getExtraordinaryEvents())).getOrDefault(false)) {
					return exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<ReturnTerms>map("getReturnTerms", performancePayout -> performancePayout.getReturnTerms()).<PriceReturnTerms>map("getPriceReturnTerms", returnTerms -> returnTerms.getPriceReturnTerms())).or(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()))).and(ComparisonResult.of(MapperS.of(qualify_AssetClass_Equity.evaluate(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get()))));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeExtraordinaryEvents {
	
		@Override
		public ValidationResult<Trade> validate(RosettaPath path, Trade trade) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Trade", path, DEFINITION);
		}
	}
}
