package cdm.product.qualification.functions;

import cdm.product.asset.InterestRatePayout;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(InterestRatePayoutOnlyExists.InterestRatePayoutOnlyExistsDefault.class)
public abstract class InterestRatePayoutOnlyExists implements RosettaFunction {

	/**
	* @param payouts 
	* @return result 
	*/
	public Boolean evaluate(List<? extends Payout> payouts) {
		Boolean result = doEvaluate(payouts);
		
		return result;
	}

	protected abstract Boolean doEvaluate(List<? extends Payout> payouts);

	public static class InterestRatePayoutOnlyExistsDefault extends InterestRatePayoutOnlyExists {
		@Override
		protected Boolean doEvaluate(List<? extends Payout> payouts) {
			if (payouts == null) {
				payouts = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, payouts);
		}
		
		protected Boolean assignOutput(Boolean result, List<? extends Payout> payouts) {
			final MapperC<Boolean> thenArg0 = MapperC.<Payout>of(payouts)
				.mapItem(item -> exists(item.<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())).asMapper());
			final MapperS<Boolean> thenArg1 = areEqual(thenArg0, MapperS.of(true), CardinalityOperator.All).asMapper();
			result = MapperS.of(thenArg1.getOrDefault(false)).get();
			
			return result;
		}
	}
}
