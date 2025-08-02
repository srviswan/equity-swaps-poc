package cdm.margin.schedule.functions;

import cdm.base.math.Measure;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.Price;
import cdm.product.asset.VarianceReturnTerms;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.PerformancePayout;
import cdm.product.template.ReturnTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(StandardizedScheduleVarianceSwapNotionalAmount.StandardizedScheduleVarianceSwapNotionalAmountDefault.class)
public abstract class StandardizedScheduleVarianceSwapNotionalAmount implements RosettaFunction {

	/**
	* @param performancePayout 
	* @return amount 
	*/
	public BigDecimal evaluate(PerformancePayout performancePayout) {
		BigDecimal amount = doEvaluate(performancePayout);
		
		return amount;
	}

	protected abstract BigDecimal doEvaluate(PerformancePayout performancePayout);

	protected abstract MapperS<BigDecimal> varianceAmount(PerformancePayout performancePayout);

	protected abstract MapperS<BigDecimal> volatilityStrikePrice(PerformancePayout performancePayout);

	public static class StandardizedScheduleVarianceSwapNotionalAmountDefault extends StandardizedScheduleVarianceSwapNotionalAmount {
		@Override
		protected BigDecimal doEvaluate(PerformancePayout performancePayout) {
			BigDecimal amount = null;
			return assignOutput(amount, performancePayout);
		}
		
		protected BigDecimal assignOutput(BigDecimal amount, PerformancePayout performancePayout) {
			amount = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(BigDecimal.valueOf(200)), varianceAmount(performancePayout)), volatilityStrikePrice(performancePayout)).get();
			
			return amount;
		}
		
		@Override
		protected MapperS<BigDecimal> varianceAmount(PerformancePayout performancePayout) {
			final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg = MapperS.of(performancePayout).<ResolvablePriceQuantity>map("getPriceQuantity", _performancePayout -> _performancePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule());
			final MapperS<BigDecimal> ifThenElseResult0;
			if (exists(thenArg.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier())).getOrDefault(false)) {
				ifThenElseResult0 = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(thenArg.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), thenArg.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule2 -> referenceWithMetaNonNegativeQuantitySchedule2 == null ? null : referenceWithMetaNonNegativeQuantitySchedule2.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier()).<BigDecimal>map("getValue", measure -> measure.getValue()));
			} else {
				ifThenElseResult0 = thenArg.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule3 -> referenceWithMetaNonNegativeQuantitySchedule3 == null ? null : referenceWithMetaNonNegativeQuantitySchedule3.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue());
			}
			final MapperS<BigDecimal> ifThenElseResult1;
			if (greaterThanEquals(ifThenElseResult0, MapperS.of(BigDecimal.valueOf(1)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(new BigDecimal("0.01")), ifThenElseResult0);
			} else {
				ifThenElseResult1 = ifThenElseResult0;
			}
			return ifThenElseResult1;
		}
		
		@Override
		protected MapperS<BigDecimal> volatilityStrikePrice(PerformancePayout performancePayout) {
			return MapperS.of(performancePayout).<ReturnTerms>map("getReturnTerms", _performancePayout -> _performancePayout.getReturnTerms()).<VarianceReturnTerms>map("getVarianceReturnTerms", returnTerms -> returnTerms.getVarianceReturnTerms()).<Price>map("getVolatilityStrikePrice", varianceReturnTerms -> varianceReturnTerms.getVolatilityStrikePrice()).<BigDecimal>map("getValue", price -> price.getValue());
		}
	}
}
