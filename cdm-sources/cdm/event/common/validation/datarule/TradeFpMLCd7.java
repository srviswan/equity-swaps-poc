package cdm.event.common.validation.datarule;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.BusinessDayAdjustments;
import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.ContractualMatrix;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreementIdentification;
import cdm.legaldocumentation.master.metafields.FieldWithMetaMasterConfirmationTypeEnum;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.ReferenceInformation;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaDate;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0
 */
@RosettaDataRule("TradeFpML_cd_7")
@ImplementedBy(TradeFpMLCd7.Default.class)
public interface TradeFpMLCd7 extends Validator<Trade> {
	
	String NAME = "TradeFpML_cd_7";
	String DEFINITION = "if contractDetails -> documentation -> legalAgreementIdentification -> agreementName -> masterConfirmationType is absent and contractDetails -> documentation -> legalAgreementIdentification -> agreementName -> contractualMatrix is absent and product -> economicTerms -> payout -> CreditDefaultPayout -> generalTerms -> referenceInformation exists then product -> economicTerms -> payout -> InterestRatePayout -> calculationPeriodDates -> effectiveDate -> adjustableDate -> dateAdjustments exists or tradeDate < product -> economicTerms -> effectiveDate -> adjustableDate -> adjustedDate";
	
	ValidationResult<Trade> validate(RosettaPath path, Trade trade);
	
	class Default implements TradeFpMLCd7 {
	
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
				if (notExists(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<LegalAgreement>mapC("getDocumentation", contractDetails -> contractDetails.getDocumentation()).<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<AgreementName>map("getAgreementName", legalAgreementIdentification -> legalAgreementIdentification.getAgreementName()).<FieldWithMetaMasterConfirmationTypeEnum>map("getMasterConfirmationType", agreementName -> agreementName.getMasterConfirmationType())).and(notExists(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<LegalAgreement>mapC("getDocumentation", contractDetails -> contractDetails.getDocumentation()).<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<AgreementName>map("getAgreementName", legalAgreementIdentification -> legalAgreementIdentification.getAgreementName()).<ContractualMatrix>mapC("getContractualMatrix", agreementName -> agreementName.getContractualMatrix()))).and(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()))).getOrDefault(false)) {
					return exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getEffectiveDate", calculationPeriodDates -> calculationPeriodDates.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<BusinessDayAdjustments>map("getDateAdjustments", adjustableDate -> adjustableDate.getDateAdjustments())).or(lessThan(MapperS.of(trade).<FieldWithMetaDate>map("getTradeDate", _trade -> _trade.getTradeDate()).<Date>map("Type coercion", fieldWithMetaDate0 -> fieldWithMetaDate0 == null ? null : fieldWithMetaDate0.getValue()), MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<AdjustableOrRelativeDate>map("getEffectiveDate", economicTerms -> economicTerms.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", adjustableDate -> adjustableDate.getAdjustedDate()).<Date>map("Type coercion", fieldWithMetaDate1 -> fieldWithMetaDate1 == null ? null : fieldWithMetaDate1.getValue()), CardinalityOperator.All));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeFpMLCd7 {
	
		@Override
		public ValidationResult<Trade> validate(RosettaPath path, Trade trade) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Trade", path, DEFINITION);
		}
	}
}
