package cdm.product.asset.calculation.functions;

import cdm.base.math.DatedValue;
import cdm.base.math.NonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(GetQuantityScheduleStepValues.GetQuantityScheduleStepValuesDefault.class)
public abstract class GetQuantityScheduleStepValues implements RosettaFunction {

	/**
	* @param schedule The quantity schedule being looked up from.
	* @param periodStartDate The date for which the quantity is required.
	* @return stepValues 
	*/
	public List<BigDecimal> evaluate(NonNegativeQuantitySchedule schedule, Date periodStartDate) {
		List<BigDecimal> stepValues = doEvaluate(schedule, periodStartDate);
		
		return stepValues;
	}

	protected abstract List<BigDecimal> doEvaluate(NonNegativeQuantitySchedule schedule, Date periodStartDate);

	public static class GetQuantityScheduleStepValuesDefault extends GetQuantityScheduleStepValues {
		@Override
		protected List<BigDecimal> doEvaluate(NonNegativeQuantitySchedule schedule, Date periodStartDate) {
			List<BigDecimal> stepValues = new ArrayList<>();
			return assignOutput(stepValues, schedule, periodStartDate);
		}
		
		protected List<BigDecimal> assignOutput(List<BigDecimal> stepValues, NonNegativeQuantitySchedule schedule, Date periodStartDate) {
			stepValues.addAll(MapperS.of(schedule).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).getMulti());
			
			final MapperC<DatedValue> thenArg = MapperS.of(schedule).<DatedValue>mapC("getDatedValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getDatedValue())
				.filterItemNullSafe(item -> lessThanEquals(item.<Date>map("getDate", datedValue -> datedValue.getDate()), MapperS.of(periodStartDate), CardinalityOperator.All).get());
			stepValues.addAll(thenArg
				.mapItem(item -> item.<BigDecimal>map("getValue", datedValue -> datedValue.getValue())).getMulti());
			
			return stepValues;
		}
	}
}
