package cdm.margin.schedule.functions;

import cdm.base.datetime.functions.DateDifference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(DateDifferenceYears.DateDifferenceYearsDefault.class)
public abstract class DateDifferenceYears implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected DateDifference dateDifference;

	/**
	* @param firstDate The earlier date.
	* @param secondDate The later date.
	* @return difference 
	*/
	public BigDecimal evaluate(Date firstDate, Date secondDate) {
		BigDecimal difference = doEvaluate(firstDate, secondDate);
		
		return difference;
	}

	protected abstract BigDecimal doEvaluate(Date firstDate, Date secondDate);

	public static class DateDifferenceYearsDefault extends DateDifferenceYears {
		@Override
		protected BigDecimal doEvaluate(Date firstDate, Date secondDate) {
			BigDecimal difference = null;
			return assignOutput(difference, firstDate, secondDate);
		}
		
		protected BigDecimal assignOutput(BigDecimal difference, Date firstDate, Date secondDate) {
			final Integer integer = dateDifference.evaluate(firstDate, secondDate);
			difference = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide((integer == null ? MapperS.<BigDecimal>ofNull() : MapperS.of(BigDecimal.valueOf(integer))), MapperS.of(new BigDecimal("365.0"))).get();
			
			return difference;
		}
	}
}
