package cdm.product.qualification.functions;

import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_BaseProduct_EquitySwap.Qualify_BaseProduct_EquitySwapDefault.class)
public abstract class Qualify_BaseProduct_EquitySwap implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected PerformancePayoutAndFixedPricePayoutOnlyExists performancePayoutAndFixedPricePayoutOnlyExists;
	@Inject protected PerformancePayoutAndInterestRatePayoutOnlyExists performancePayoutAndInterestRatePayoutOnlyExists;
	@Inject protected PerformancePayoutOnlyExists performancePayoutOnlyExists;
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;

	/**
	* @param economicTerms 
	* @return is_product 
	*/
	public Boolean evaluate(EconomicTerms economicTerms) {
		Boolean is_product = doEvaluate(economicTerms);
		
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);

	public static class Qualify_BaseProduct_EquitySwapDefault extends Qualify_BaseProduct_EquitySwap {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			is_product = areEqual(MapperS.of(qualify_AssetClass_Equity.evaluate(economicTerms)), MapperS.of(true), CardinalityOperator.All).and(ComparisonResult.of(MapperS.of(performancePayoutAndInterestRatePayoutOnlyExists.evaluate(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).getMulti()))).or(ComparisonResult.of(MapperS.of(performancePayoutAndFixedPricePayoutOnlyExists.evaluate(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).getMulti())))).or(ComparisonResult.of(MapperS.of(performancePayoutOnlyExists.evaluate(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).getMulti()))))).get();
			
			return is_product;
		}
	}
}
