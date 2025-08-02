package cdm.product.qualification.functions;

import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.ReturnTerms;
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

@ImplementedBy(Qualify_EquitySwap_ParameterReturnDividend_Index.Qualify_EquitySwap_ParameterReturnDividend_IndexDefault.class)
public abstract class Qualify_EquitySwap_ParameterReturnDividend_Index implements RosettaFunction,IQualifyFunctionExtension<EconomicTerms> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PerformancePayoutAndFixedPricePayoutOnlyExists performancePayoutAndFixedPricePayoutOnlyExists;
	@Inject protected Qualify_BaseProduct_EquitySwap qualify_BaseProduct_EquitySwap;

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

	protected abstract MapperS<? extends PerformancePayout> performancePayout(EconomicTerms economicTerms);

	public static class Qualify_EquitySwap_ParameterReturnDividend_IndexDefault extends Qualify_EquitySwap_ParameterReturnDividend_Index {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			is_product = areEqual(MapperS.of(qualify_BaseProduct_EquitySwap.evaluate(economicTerms)), MapperS.of(true), CardinalityOperator.All).and(ComparisonResult.of(MapperS.of(performancePayoutAndFixedPricePayoutOnlyExists.evaluate(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).getMulti())))).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).resultCount()), MapperS.of(1), CardinalityOperator.All)).and(onlyExists(performancePayout(economicTerms).<ReturnTerms>map("getReturnTerms", _performancePayout -> _performancePayout.getReturnTerms()), Arrays.asList("priceReturnTerms", "dividendReturnTerms", "varianceReturnTerms", "volatilityReturnTerms", "correlationReturnTerms"), Arrays.asList("dividendReturnTerms"))).and(exists(performancePayout(economicTerms).<Underlier>map("getUnderlier", _performancePayout -> _performancePayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex()))).get();
			
			return is_product;
		}
		
		@Override
		protected MapperS<? extends PerformancePayout> performancePayout(EconomicTerms economicTerms) {
			return MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get());
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
