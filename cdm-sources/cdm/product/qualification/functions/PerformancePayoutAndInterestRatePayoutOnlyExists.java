package cdm.product.qualification.functions;

import cdm.product.asset.InterestRatePayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(PerformancePayoutAndInterestRatePayoutOnlyExists.PerformancePayoutAndInterestRatePayoutOnlyExistsDefault.class)
public abstract class PerformancePayoutAndInterestRatePayoutOnlyExists implements RosettaFunction {

	/**
	* @param payouts 
	* @return result 
	*/
	public Boolean evaluate(List<? extends Payout> payouts) {
		Boolean result = doEvaluate(payouts);
		
		return result;
	}

	protected abstract Boolean doEvaluate(List<? extends Payout> payouts);

	public static class PerformancePayoutAndInterestRatePayoutOnlyExistsDefault extends PerformancePayoutAndInterestRatePayoutOnlyExists {
		@Override
		protected Boolean doEvaluate(List<? extends Payout> payouts) {
			if (payouts == null) {
				payouts = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, payouts);
		}
		
		protected Boolean assignOutput(Boolean result, List<? extends Payout> payouts) {
			result = exists(MapperC.<Payout>of(payouts).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout())).and(exists(MapperC.<Payout>of(payouts).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()))).and(areEqual(MapperC.<Payout>of(payouts)
				.mapItem(item -> exists(item.<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout())).or(exists(item.<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()))).asMapper()), MapperS.of(true), CardinalityOperator.All)).get();
			
			return result;
		}
	}
}
