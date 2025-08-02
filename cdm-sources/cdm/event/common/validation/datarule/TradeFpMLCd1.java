package cdm.event.common.validation.datarule;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.event.common.Trade;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ReferenceInformation;
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
@RosettaDataRule("TradeFpML_cd_1")
@ImplementedBy(TradeFpMLCd1.Default.class)
public interface TradeFpMLCd1 extends Validator<Trade> {
	
	String NAME = "TradeFpML_cd_1";
	String DEFINITION = "if product -> economicTerms -> payout -> CreditDefaultPayout -> generalTerms -> referenceInformation exists then tradeDate < product -> economicTerms -> effectiveDate -> adjustableDate -> unadjustedDate or tradeDate < product -> economicTerms -> effectiveDate -> adjustableDate -> adjustedDate";
	
	ValidationResult<Trade> validate(RosettaPath path, Trade trade);
	
	class Default implements TradeFpMLCd1 {
	
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
				if (exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation())).getOrDefault(false)) {
					return lessThan(MapperS.of(trade).<FieldWithMetaDate>map("getTradeDate", _trade -> _trade.getTradeDate()).<Date>map("Type coercion", fieldWithMetaDate0 -> fieldWithMetaDate0 == null ? null : fieldWithMetaDate0.getValue()), MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<AdjustableOrRelativeDate>map("getEffectiveDate", economicTerms -> economicTerms.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()), CardinalityOperator.All).or(lessThan(MapperS.of(trade).<FieldWithMetaDate>map("getTradeDate", _trade -> _trade.getTradeDate()).<Date>map("Type coercion", fieldWithMetaDate1 -> fieldWithMetaDate1 == null ? null : fieldWithMetaDate1.getValue()), MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<AdjustableOrRelativeDate>map("getEffectiveDate", economicTerms -> economicTerms.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", adjustableDate -> adjustableDate.getAdjustedDate()).<Date>map("Type coercion", fieldWithMetaDate2 -> fieldWithMetaDate2 == null ? null : fieldWithMetaDate2.getValue()), CardinalityOperator.All));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeFpMLCd1 {
	
		@Override
		public ValidationResult<Trade> validate(RosettaPath path, Trade trade) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Trade", path, DEFINITION);
		}
	}
}
