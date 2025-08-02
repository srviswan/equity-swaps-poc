package cdm.product.asset.validation.datarule;

import cdm.observable.asset.functions.ObservableIsCommodity;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.CommodityPayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TransferableProduct;
import cdm.product.template.Underlier;
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
@RosettaDataRule("CommodityPayoutCommodityUnderlier")
@ImplementedBy(CommodityPayoutCommodityUnderlier.Default.class)
public interface CommodityPayoutCommodityUnderlier extends Validator<CommodityPayout> {
	
	String NAME = "CommodityPayoutCommodityUnderlier";
	String DEFINITION = "if underlier -> Observable exists then ObservableIsCommodity(underlier -> Observable) else if underlier -> Product -> TransferableProduct -> economicTerms -> payout only-element -> OptionPayout exists then ObservableIsCommodity( underlier -> Product -> TransferableProduct -> economicTerms -> payout only-element -> OptionPayout -> underlier -> Observable ) else if underlier -> Product -> TransferableProduct -> economicTerms -> payout only-element -> SettlementPayout exists then ObservableIsCommodity( underlier -> Product -> TransferableProduct -> economicTerms -> payout only-element -> SettlementPayout -> underlier -> Observable ) else False";
	
	ValidationResult<CommodityPayout> validate(RosettaPath path, CommodityPayout commodityPayout);
	
	class Default implements CommodityPayoutCommodityUnderlier {
	
		@Inject protected ObservableIsCommodity observableIsCommodity;
		
		@Override
		public ValidationResult<CommodityPayout> validate(RosettaPath path, CommodityPayout commodityPayout) {
			ComparisonResult result = executeDataRule(commodityPayout);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPayout", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityPayout", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityPayout commodityPayout) {
			try {
				if (exists(MapperS.of(commodityPayout).<Underlier>map("getUnderlier", _commodityPayout -> _commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable())).getOrDefault(false)) {
					final ReferenceWithMetaObservable referenceWithMetaObservable0 = MapperS.of(commodityPayout).<Underlier>map("getUnderlier", _commodityPayout -> _commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).get();
					return ComparisonResult.of(MapperS.of(observableIsCommodity.evaluate((referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()))));
				}
				if (exists(MapperS.of(MapperS.of(commodityPayout).<Underlier>map("getUnderlier", _commodityPayout -> _commodityPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<TransferableProduct>map("getTransferableProduct", product -> product.getTransferableProduct()).<EconomicTerms>map("getEconomicTerms", transferableProduct -> transferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).get()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout())).getOrDefault(false)) {
					final ReferenceWithMetaObservable referenceWithMetaObservable1 = MapperS.of(MapperS.of(commodityPayout).<Underlier>map("getUnderlier", _commodityPayout -> _commodityPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<TransferableProduct>map("getTransferableProduct", product -> product.getTransferableProduct()).<EconomicTerms>map("getEconomicTerms", transferableProduct -> transferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).get()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).get();
					return ComparisonResult.of(MapperS.of(observableIsCommodity.evaluate((referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()))));
				}
				if (exists(MapperS.of(MapperS.of(commodityPayout).<Underlier>map("getUnderlier", _commodityPayout -> _commodityPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<TransferableProduct>map("getTransferableProduct", product -> product.getTransferableProduct()).<EconomicTerms>map("getEconomicTerms", transferableProduct -> transferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).get()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout())).getOrDefault(false)) {
					final ReferenceWithMetaObservable referenceWithMetaObservable2 = MapperS.of(MapperS.of(commodityPayout).<Underlier>map("getUnderlier", _commodityPayout -> _commodityPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<TransferableProduct>map("getTransferableProduct", product -> product.getTransferableProduct()).<EconomicTerms>map("getEconomicTerms", transferableProduct -> transferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).get()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).get();
					return ComparisonResult.of(MapperS.of(observableIsCommodity.evaluate((referenceWithMetaObservable2 == null ? null : referenceWithMetaObservable2.getValue()))));
				}
				return ComparisonResult.of(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityPayoutCommodityUnderlier {
	
		@Override
		public ValidationResult<CommodityPayout> validate(RosettaPath path, CommodityPayout commodityPayout) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPayout", path, DEFINITION);
		}
	}
}
