package cdm.observable.asset.calculatedrate.functions;

import cdm.observable.asset.InterestRateIndex;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;


@ImplementedBy(IndexValueObservation.IndexValueObservationDefault.class)
public abstract class IndexValueObservation implements RosettaFunction {

	/**
	* @param observationDate 
	* @param interestRateIndex 
	* @return observedValue 
	*/
	public BigDecimal evaluate(Date observationDate, InterestRateIndex interestRateIndex) {
		BigDecimal observedValue = doEvaluate(observationDate, interestRateIndex);
		
		return observedValue;
	}

	protected abstract BigDecimal doEvaluate(Date observationDate, InterestRateIndex interestRateIndex);

	public static class IndexValueObservationDefault extends IndexValueObservation {
		@Override
		protected BigDecimal doEvaluate(Date observationDate, InterestRateIndex interestRateIndex) {
			BigDecimal observedValue = null;
			return assignOutput(observedValue, observationDate, interestRateIndex);
		}
		
		protected BigDecimal assignOutput(BigDecimal observedValue, Date observationDate, InterestRateIndex interestRateIndex) {
			return observedValue;
		}
	}
}
