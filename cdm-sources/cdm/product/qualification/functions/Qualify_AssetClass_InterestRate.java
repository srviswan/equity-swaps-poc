package cdm.product.qualification.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.util.InstrumentDeepPathUtil;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TransferableProduct;
import cdm.product.template.Underlier;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_AssetClass_InterestRate.Qualify_AssetClass_InterestRateDefault.class)
public abstract class Qualify_AssetClass_InterestRate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected InstrumentDeepPathUtil instrumentDeepPathUtil;
	@Inject protected InterestRatePayoutOnlyExists interestRatePayoutOnlyExists;
	@Inject protected ObservableQualification observableQualification;
	@Inject protected ProductDeepPathUtil productDeepPathUtil;
	@Inject protected cdm.product.qualification.functions.Qualify_AssetClass_InterestRate qualify_AssetClass_InterestRate;
	@Inject protected UnderlierQualification underlierQualification;

	/**
	* @param economicTerms 
	* @return is_product 
	*/
	public Boolean evaluate(EconomicTerms economicTerms) {
		Boolean is_product = doEvaluate(economicTerms);
		
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);

	protected abstract MapperS<? extends Underlier> optionUnderlier(EconomicTerms economicTerms);

	protected abstract MapperS<? extends Underlier> settlementUnderlier(EconomicTerms economicTerms);

	public static class Qualify_AssetClass_InterestRateDefault extends Qualify_AssetClass_InterestRate {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			final ReferenceWithMetaObservable referenceWithMetaObservable = optionUnderlier(economicTerms).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).get();
			final ComparisonResult ifThenElseResult0;
			if (exists(optionUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct())).getOrDefault(false)) {
				ifThenElseResult0 = areEqual(MapperS.of(qualify_AssetClass_InterestRate.evaluate(optionUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).get())), MapperS.of(true), CardinalityOperator.All);
			} else {
				ifThenElseResult0 = ComparisonResult.of(MapperS.of(false));
			}
			final ComparisonResult ifThenElseResult1;
			if (exists(settlementUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product))).getOrDefault(false)) {
				ifThenElseResult1 = areEqual(MapperS.of(qualify_AssetClass_InterestRate.evaluate(settlementUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).get())), MapperS.of(true), CardinalityOperator.All);
			} else {
				ifThenElseResult1 = ComparisonResult.of(MapperS.of(false));
			}
			is_product = ComparisonResult.of(MapperS.of(interestRatePayoutOnlyExists.evaluate(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).getMulti()))).or(exists(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).get()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout())).and(ComparisonResult.of(MapperS.of(observableQualification.evaluate((referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()), InstrumentTypeEnum.DEBT, AssetClassEnum.INTEREST_RATE))).or(areEqual(optionUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct()).<TransferableProduct>map("getTransferableProduct", product -> product.getTransferableProduct()).<Instrument>map("getInstrument", transferableProduct -> transferableProduct.getInstrument()).<InstrumentTypeEnum>map("chooseInstrumentType", instrument -> instrumentDeepPathUtil.chooseInstrumentType(instrument)), MapperS.of(InstrumentTypeEnum.DEBT), CardinalityOperator.All)).or(ifThenElseResult0))).or(exists(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).get()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout())).and(ComparisonResult.of(MapperS.of(underlierQualification.evaluate(settlementUnderlier(economicTerms).get(), InstrumentTypeEnum.DEBT, AssetClassEnum.INTEREST_RATE))).or(ifThenElseResult1))).get();
			
			return is_product;
		}
		
		@Override
		protected MapperS<? extends Underlier> optionUnderlier(EconomicTerms economicTerms) {
			return MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier());
		}
		
		@Override
		protected MapperS<? extends Underlier> settlementUnderlier(EconomicTerms economicTerms) {
			return MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier());
		}
	}
}
