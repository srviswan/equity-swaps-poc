package cdm.product.qualification.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.util.InstrumentDeepPathUtil;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_AssetClass_Credit.Qualify_AssetClass_CreditDefault.class)
public abstract class Qualify_AssetClass_Credit implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected InstrumentDeepPathUtil instrumentDeepPathUtil;
	@Inject protected ObservableQualification observableQualification;
	@Inject protected ProductDeepPathUtil productDeepPathUtil;
	@Inject protected cdm.product.qualification.functions.Qualify_AssetClass_Credit qualify_AssetClass_Credit;
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

	protected abstract MapperS<? extends Underlier> performanceUnderlier(EconomicTerms economicTerms);

	public static class Qualify_AssetClass_CreditDefault extends Qualify_AssetClass_Credit {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			final ReferenceWithMetaObservable referenceWithMetaObservable0 = optionUnderlier(economicTerms).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).get();
			final ComparisonResult ifThenElseResult0;
			if (exists(optionUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct())).getOrDefault(false)) {
				ifThenElseResult0 = areEqual(MapperS.of(qualify_AssetClass_Credit.evaluate(optionUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).get())), MapperS.of(true), CardinalityOperator.All);
			} else {
				ifThenElseResult0 = ComparisonResult.of(MapperS.of(false));
			}
			final ComparisonResult ifThenElseResult1;
			if (exists(settlementUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product))).getOrDefault(false)) {
				ifThenElseResult1 = areEqual(MapperS.of(qualify_AssetClass_Credit.evaluate(settlementUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).get())), MapperS.of(true), CardinalityOperator.All);
			} else {
				ifThenElseResult1 = ComparisonResult.of(MapperS.of(false));
			}
			final ComparisonResult ifThenElseResult2;
			if (exists(performanceUnderlier(economicTerms)).getOrDefault(false)) {
				ifThenElseResult2 = areEqual(performanceUnderlier(economicTerms).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<InstrumentTypeEnum>map("chooseInstrumentType", instrument -> instrumentDeepPathUtil.chooseInstrumentType(instrument)), MapperS.of(InstrumentTypeEnum.DEBT), CardinalityOperator.All);
			} else {
				ifThenElseResult2 = ComparisonResult.successEmptyOperand("");
			}
			is_product = exists(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).get()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout())).or(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).resultCount()), MapperS.of(2), CardinalityOperator.All).and(exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()))).and(exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())))).or(exists(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).get()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout())).and(ComparisonResult.of(MapperS.of(observableQualification.evaluate((referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()), null, AssetClassEnum.CREDIT))).or(ifThenElseResult0))).or(exists(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).get()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout())).and(ComparisonResult.of(MapperS.of(underlierQualification.evaluate(settlementUnderlier(economicTerms).get(), null, AssetClassEnum.CREDIT))).or(ifThenElseResult1))).or(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).resultCount()), MapperS.of(2), CardinalityOperator.All).and(exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()))).and(exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()))).and(ifThenElseResult2)).get();
			
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
		
		@Override
		protected MapperS<? extends Underlier> performanceUnderlier(EconomicTerms economicTerms) {
			return MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier());
		}
	}
}
