package cdm.event.position.functions;

import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.math.BigDecimal;


@ImplementedBy(InterpolateForwardRate.InterpolateForwardRateDefault.class)
public abstract class InterpolateForwardRate implements RosettaFunction {

	/**
	* @param settlementPayout 
	* @return result 
	*/
	public BigDecimal evaluate(SettlementPayout settlementPayout) {
		BigDecimal result = doEvaluate(settlementPayout);
		
		return result;
	}

	protected abstract BigDecimal doEvaluate(SettlementPayout settlementPayout);

	public static class InterpolateForwardRateDefault extends InterpolateForwardRate {
		@Override
		protected BigDecimal doEvaluate(SettlementPayout settlementPayout) {
			BigDecimal result = null;
			return assignOutput(result, settlementPayout);
		}
		
		protected BigDecimal assignOutput(BigDecimal result, SettlementPayout settlementPayout) {
			return result;
		}
	}
}
