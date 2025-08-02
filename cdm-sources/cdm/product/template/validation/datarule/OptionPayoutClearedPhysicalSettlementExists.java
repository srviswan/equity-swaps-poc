package cdm.product.template.validation.datarule;

import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("OptionPayoutClearedPhysicalSettlementExists")
@ImplementedBy(OptionPayoutClearedPhysicalSettlementExists.Default.class)
public interface OptionPayoutClearedPhysicalSettlementExists extends Validator<OptionPayout> {
	
	String NAME = "OptionPayoutClearedPhysicalSettlementExists";
	String DEFINITION = "if settlementTerms -> physicalSettlementTerms exists and underlier -> Product ->> economicTerms -> payout -> InterestRatePayout exists and underlier -> Product ->> economicTerms -> payout -> InterestRatePayout count = 2 then settlementTerms -> physicalSettlementTerms -> clearedPhysicalSettlement exists";
	
	ValidationResult<OptionPayout> validate(RosettaPath path, OptionPayout optionPayout);
	
	class Default implements OptionPayoutClearedPhysicalSettlementExists {
	
		@Inject protected ProductDeepPathUtil productDeepPathUtil;
		
		@Override
		public ValidationResult<OptionPayout> validate(RosettaPath path, OptionPayout optionPayout) {
			ComparisonResult result = executeDataRule(optionPayout);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionPayout", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "OptionPayout", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(OptionPayout optionPayout) {
			try {
				if (exists(MapperS.of(optionPayout).<SettlementTerms>map("getSettlementTerms", _optionPayout -> _optionPayout.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", settlementTerms -> settlementTerms.getPhysicalSettlementTerms())).and(exists(MapperS.of(optionPayout).<Underlier>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()))).and(areEqual(MapperS.of(MapperS.of(optionPayout).<Underlier>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).resultCount()), MapperS.of(2), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(optionPayout).<SettlementTerms>map("getSettlementTerms", _optionPayout -> _optionPayout.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", settlementTerms -> settlementTerms.getPhysicalSettlementTerms()).<Boolean>map("getClearedPhysicalSettlement", physicalSettlementTerms -> physicalSettlementTerms.getClearedPhysicalSettlement()));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionPayoutClearedPhysicalSettlementExists {
	
		@Override
		public ValidationResult<OptionPayout> validate(RosettaPath path, OptionPayout optionPayout) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionPayout", path, DEFINITION);
		}
	}
}
