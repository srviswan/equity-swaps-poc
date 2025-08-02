package cdm.product.qualification.functions;

import cdm.observable.asset.Basket;
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

@ImplementedBy(Qualify_EquityOption_PriceReturnBasicPerformance_Basket.Qualify_EquityOption_PriceReturnBasicPerformance_BasketDefault.class)
public abstract class Qualify_EquityOption_PriceReturnBasicPerformance_Basket implements RosettaFunction,IQualifyFunctionExtension<EconomicTerms> {
	
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

	public static class Qualify_EquityOption_PriceReturnBasicPerformance_BasketDefault extends Qualify_EquityOption_PriceReturnBasicPerformance_Basket {
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
			is_product = areEqual(MapperS.of(qualify_AssetClass_Equity.evaluate(economicTerms)), MapperS.of(true), CardinalityOperator.All).and(exists(optionPayout(economicTerms))).and(exists(optionPayout(economicTerms).<Underlier>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()))).and(notExists(optionPayout(economicTerms).<OptionFeature>map("getFeature", _optionPayout -> _optionPayout.getFeature())).or(onlyExists(optionPayout(economicTerms).<OptionFeature>map("getFeature", _optionPayout -> _optionPayout.getFeature()), Arrays.asList("fxFeature", "strategyFeature", "averagingFeature", "barrier", "knock", "passThrough"), Arrays.asList("averagingFeature"))).or(exists(MapperS.of(optionPayout(economicTerms).<OptionFeature>map("getFeature", _optionPayout -> _optionPayout.getFeature()).<FxFeature>mapC("getFxFeature", optionFeature -> optionFeature.getFxFeature()).get()).<Quanto>map("getQuanto", fxFeature -> fxFeature.getQuanto()))).or(exists(MapperS.of(optionPayout(economicTerms).<OptionFeature>map("getFeature", _optionPayout -> _optionPayout.getFeature()).<FxFeature>mapC("getFxFeature", optionFeature -> optionFeature.getFxFeature()).get()).<Composite>map("getComposite", fxFeature -> fxFeature.getComposite())))).and(ifThenElseResult).get();
			
			return is_product;
		}
		
		@Override
		protected MapperS<? extends OptionPayout> optionPayout(EconomicTerms economicTerms) {
			return MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).get()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout());
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
