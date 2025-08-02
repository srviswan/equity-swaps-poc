package cdm.margin.schedule.functions;

import cdm.base.datetime.AdjustableDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;
import java.util.ArrayList;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(AdjustableDatesResolution.AdjustableDatesResolutionDefault.class)
public abstract class AdjustableDatesResolution implements RosettaFunction {

	/**
	* @param adjustableDates 
	* @return date 
	*/
	public List<Date> evaluate(AdjustableDates adjustableDates) {
		List<Date> date = doEvaluate(adjustableDates);
		
		return date;
	}

	protected abstract List<Date> doEvaluate(AdjustableDates adjustableDates);

	public static class AdjustableDatesResolutionDefault extends AdjustableDatesResolution {
		@Override
		protected List<Date> doEvaluate(AdjustableDates adjustableDates) {
			List<Date> date = new ArrayList<>();
			return assignOutput(date, adjustableDates);
		}
		
		protected List<Date> assignOutput(List<Date> date, AdjustableDates adjustableDates) {
			if (exists(MapperS.of(adjustableDates).<Date>mapC("getUnadjustedDate", _adjustableDates -> _adjustableDates.getUnadjustedDate())).getOrDefault(false)) {
				date.addAll(MapperS.of(adjustableDates).<Date>mapC("getUnadjustedDate", _adjustableDates -> _adjustableDates.getUnadjustedDate()).getMulti());
			} else {
				date.addAll(MapperS.of(adjustableDates).<FieldWithMetaDate>mapC("getAdjustedDate", _adjustableDates -> _adjustableDates.getAdjustedDate()).<Date>map("Type coercion", fieldWithMetaDate -> fieldWithMetaDate.getValue()).getMulti());
			}
			
			return date;
		}
	}
}
