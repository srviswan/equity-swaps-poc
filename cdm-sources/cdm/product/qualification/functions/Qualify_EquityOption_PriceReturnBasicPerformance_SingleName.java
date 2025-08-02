package cdm.product.qualification.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.Security;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.template.Composite;
import cdm.product.template.EconomicTerms;
import cdm.product.template.FxFeature;
import cdm.product.template.OptionFeature;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Quanto;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_EquityOption_PriceReturnBasicPerformance_SingleName.Qualify_EquityOption_PriceReturnBasicPerformance_SingleNameDefault.class)
public abstract class Qualify_EquityOption_PriceReturnBasicPerformance_SingleName implements RosettaFunction,IQualifyFunctionExtension<EconomicTerms> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;

	/**
	* @param economicTerms 
	* @return is_product 
	*/
	@Override
	public Boolean evaluate(EconomicTerms economicTerms) {
		Boolean is_product = doEvaluate(economicTerms);
		
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);

	protected abstract MapperS<? extends OptionPayout> optionPayout(EconomicTerms economicTerms);

	protected abstract MapperS<? extends Underlier> optionUnderlier(EconomicTerms economicTerms);

	public static class Qualify_EquityOption_PriceReturnBasicPerformance_SingleNameDefault extends Qualify_EquityOption_PriceReturnBasicPerformance_SingleName {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			final ComparisonResult ifThenElseResult;
			if (exists(MapperS.of(economicTerms).<Boolean>map("getNonStandardisedTerms", _economicTerms -> _economicTerms.getNonStandardisedTerms())).getOrDefault(false)) {
				ifThenElseResult = areEqual(MapperS.of(economicTerms).<Boolean>map("getNonStandardisedTerms", _economicTerms -> _economicTerms.getNonStandardisedTerms()), MapperS.of(false), CardinalityOperator.All);
			} else {
				ifThenElseResult = ComparisonResult.of(MapperS.of(true));
			}
			is_product = ComparisonResult.of(MapperS.of(qualify_AssetClass_Equity.evaluate(economicTerms))).and(exists(optionPayout(economicTerms))).and(exists(optionUnderlier(economicTerms).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()))).and(exists(optionUnderlier(economicTerms).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()))).and(notExists(optionPayout(economicTerms).<OptionFeature>map("getFeature", _optionPayout -> _optionPayout.getFeature())).or(onlyExists(optionPayout(economicTerms).<OptionFeature>map("getFeature", _optionPayout -> _optionPayout.getFeature()), Arrays.asList("fxFeature", "strategyFeature", "averagingFeature", "barrier", "knock", "passThrough"), Arrays.asList("averagingFeature"))).or(exists(MapperS.of(optionPayout(economicTerms).<OptionFeature>map("getFeature", _optionPayout -> _optionPayout.getFeature()).<FxFeature>mapC("getFxFeature", optionFeature -> optionFeature.getFxFeature()).get()).<Quanto>map("getQuanto", fxFeature -> fxFeature.getQuanto()))).or(exists(MapperS.of(optionPayout(economicTerms).<OptionFeature>map("getFeature", _optionPayout -> _optionPayout.getFeature()).<FxFeature>mapC("getFxFeature", optionFeature -> optionFeature.getFxFeature()).get()).<Composite>map("getComposite", fxFeature -> fxFeature.getComposite())))).and(ifThenElseResult).get();
			
			return is_product;
		}
		
		@Override
		protected MapperS<? extends OptionPayout> optionPayout(EconomicTerms economicTerms) {
			return MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).get()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout());
		}
		
		@Override
		protected MapperS<? extends Underlier> optionUnderlier(EconomicTerms economicTerms) {
			return optionPayout(economicTerms).<Underlier>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier());
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
