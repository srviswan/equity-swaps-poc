package cdm.event.common.validation.datarule;

import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.ContractualMatrix;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreementIdentification;
import cdm.legaldocumentation.master.metafields.FieldWithMetaMasterConfirmationTypeEnum;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ReferenceInformation;
import cdm.product.common.settlement.DeliverableObligations;
import cdm.product.common.settlement.PhysicalSettlementPeriod;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0
 */
@RosettaDataRule("TradeFpML_cd_25")
@ImplementedBy(TradeFpMLCd25.Default.class)
public interface TradeFpMLCd25 extends Validator<Trade> {
	
	String NAME = "TradeFpML_cd_25";
	String DEFINITION = "if contractDetails -> documentation -> legalAgreementIdentification -> agreementName -> masterConfirmationType is absent and contractDetails -> documentation -> legalAgreementIdentification -> agreementName -> contractualMatrix is absent and product -> economicTerms -> payout -> CreditDefaultPayout -> generalTerms -> referenceInformation exists and product -> economicTerms -> payout -> CreditDefaultPayout -> settlementTerms -> physicalSettlementTerms exists then product -> economicTerms -> payout -> CreditDefaultPayout -> settlementTerms -> settlementCurrency exists and product -> economicTerms -> payout -> CreditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> physicalSettlementPeriod exists and product -> economicTerms -> payout -> CreditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> escrow exists and product -> economicTerms -> payout -> CreditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> accruedInterest exists";
	
	ValidationResult<Trade> validate(RosettaPath path, Trade trade);
	
	class Default implements TradeFpMLCd25 {
	
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
				if (notExists(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<LegalAgreement>mapC("getDocumentation", contractDetails -> contractDetails.getDocumentation()).<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<AgreementName>map("getAgreementName", legalAgreementIdentification -> legalAgreementIdentification.getAgreementName()).<FieldWithMetaMasterConfirmationTypeEnum>map("getMasterConfirmationType", agreementName -> agreementName.getMasterConfirmationType())).and(notExists(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<LegalAgreement>mapC("getDocumentation", contractDetails -> contractDetails.getDocumentation()).<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<AgreementName>map("getAgreementName", legalAgreementIdentification -> legalAgreementIdentification.getAgreementName()).<ContractualMatrix>mapC("getContractualMatrix", agreementName -> agreementName.getContractualMatrix()))).and(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()))).and(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", creditDefaultPayout -> creditDefaultPayout.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", settlementTerms -> settlementTerms.getPhysicalSettlementTerms()))).getOrDefault(false)) {
					return exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", creditDefaultPayout -> creditDefaultPayout.getSettlementTerms()).<FieldWithMetaString>map("getSettlementCurrency", settlementTerms -> settlementTerms.getSettlementCurrency())).and(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", creditDefaultPayout -> creditDefaultPayout.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", settlementTerms -> settlementTerms.getPhysicalSettlementTerms()).<PhysicalSettlementPeriod>map("getPhysicalSettlementPeriod", physicalSettlementTerms -> physicalSettlementTerms.getPhysicalSettlementPeriod()))).and(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", creditDefaultPayout -> creditDefaultPayout.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", settlementTerms -> settlementTerms.getPhysicalSettlementTerms()).<Boolean>map("getEscrow", physicalSettlementTerms -> physicalSettlementTerms.getEscrow()))).and(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", creditDefaultPayout -> creditDefaultPayout.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", settlementTerms -> settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", physicalSettlementTerms -> physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getAccruedInterest", deliverableObligations -> deliverableObligations.getAccruedInterest())));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeFpMLCd25 {
	
		@Override
		public ValidationResult<Trade> validate(RosettaPath path, Trade trade) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Trade", path, DEFINITION);
		}
	}
}
