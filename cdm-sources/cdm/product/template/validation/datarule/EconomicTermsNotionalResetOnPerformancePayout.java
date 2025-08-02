package cdm.product.template.validation.datarule;

import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.AssetPayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
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
@RosettaDataRule("EconomicTermsNotionalResetOnPerformancePayout")
@ImplementedBy(EconomicTermsNotionalResetOnPerformancePayout.Default.class)
public interface EconomicTermsNotionalResetOnPerformancePayout extends Validator<EconomicTerms> {
	
	String NAME = "EconomicTermsNotionalResetOnPerformancePayout";
	String DEFINITION = "payout -> CreditDefaultPayout -> priceQuantity -> reset is absent and payout -> AssetPayout -> priceQuantity -> reset is absent and payout -> CommodityPayout -> priceQuantity -> reset is absent and payout -> FixedPricePayout -> priceQuantity -> reset is absent and payout -> SettlementPayout -> priceQuantity -> reset is absent and payout -> OptionPayout -> priceQuantity -> reset is absent";
	
	ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms);
	
	class Default implements EconomicTermsNotionalResetOnPerformancePayout {
	
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
				return notExists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", creditDefaultPayout -> creditDefaultPayout.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset())).and(notExists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<AssetPayout>map("getAssetPayout", payout -> payout.getAssetPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", assetPayout -> assetPayout.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset()))).and(notExists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", commodityPayout -> commodityPayout.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset()))).and(notExists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<FixedPricePayout>map("getFixedPricePayout", payout -> payout.getFixedPricePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", fixedPricePayout -> fixedPricePayout.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset()))).and(notExists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset()))).and(notExists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EconomicTermsNotionalResetOnPerformancePayout {
	
		@Override
		public ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION);
		}
	}
}
