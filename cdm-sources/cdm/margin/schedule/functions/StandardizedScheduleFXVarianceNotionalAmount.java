package cdm.margin.schedule.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.observable.asset.Price;
import cdm.product.asset.VarianceReturnTerms;
import cdm.product.template.PerformancePayout;
import cdm.product.template.ReturnTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;


@ImplementedBy(StandardizedScheduleFXVarianceNotionalAmount.StandardizedScheduleFXVarianceNotionalAmountDefault.class)
public abstract class StandardizedScheduleFXVarianceNotionalAmount implements RosettaFunction {

	/**
	* @param performancePayout 
	* @return amount 
	*/
	public BigDecimal evaluate(PerformancePayout performancePayout) {
		BigDecimal amount = doEvaluate(performancePayout);
		
		return amount;
	}

	protected abstract BigDecimal doEvaluate(PerformancePayout performancePayout);

	protected abstract MapperS<? extends VarianceReturnTerms> varianceReturnTerms(PerformancePayout performancePayout);

	protected abstract MapperS<? extends NonNegativeQuantitySchedule> vegaNotionalAmount(PerformancePayout performancePayout);

	protected abstract MapperS<? extends Price> fixedRate(PerformancePayout performancePayout);

	public static class StandardizedScheduleFXVarianceNotionalAmountDefault extends StandardizedScheduleFXVarianceNotionalAmount {
		@Override
		protected BigDecimal doEvaluate(PerformancePayout performancePayout) {
			BigDecimal amount = null;
			return assignOutput(amount, performancePayout);
		}
		
		protected BigDecimal assignOutput(BigDecimal amount, PerformancePayout performancePayout) {
			amount = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(vegaNotionalAmount(performancePayout).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(new BigDecimal("0.02")), fixedRate(performancePayout).<BigDecimal>map("getValue", price -> price.getValue()))).get();
			
			return amount;
		}
		
		@Override
		protected MapperS<? extends VarianceReturnTerms> varianceReturnTerms(PerformancePayout performancePayout) {
			return MapperS.of(performancePayout).<ReturnTerms>map("getReturnTerms", _performancePayout -> _performancePayout.getReturnTerms()).<VarianceReturnTerms>map("getVarianceReturnTerms", returnTerms -> returnTerms.getVarianceReturnTerms());
		}
		
		@Override
		protected MapperS<? extends NonNegativeQuantitySchedule> vegaNotionalAmount(PerformancePayout performancePayout) {
			return varianceReturnTerms(performancePayout).<NonNegativeQuantitySchedule>map("getVegaNotionalAmount", _varianceReturnTerms -> _varianceReturnTerms.getVegaNotionalAmount());
		}
		
		@Override
		protected MapperS<? extends Price> fixedRate(PerformancePayout performancePayout) {
			return varianceReturnTerms(performancePayout).<Price>map("getVarianceStrikePrice", _varianceReturnTerms -> _varianceReturnTerms.getVarianceStrikePrice());
		}
	}
}
