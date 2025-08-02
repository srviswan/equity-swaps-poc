package cdm.margin.schedule.functions;

import cdm.base.datetime.AdjustableDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(AdjustableDateResolution.AdjustableDateResolutionDefault.class)
public abstract class AdjustableDateResolution implements RosettaFunction {

	/**
	* @param adjustableDate 
	* @return date 
	*/
	public Date evaluate(AdjustableDate adjustableDate) {
		Date date = doEvaluate(adjustableDate);
		
		return date;
	}

	protected abstract Date doEvaluate(AdjustableDate adjustableDate);

	public static class AdjustableDateResolutionDefault extends AdjustableDateResolution {
		@Override
		protected Date doEvaluate(AdjustableDate adjustableDate) {
			Date date = null;
			return assignOutput(date, adjustableDate);
		}
		
		protected Date assignOutput(Date date, AdjustableDate adjustableDate) {
			if (exists(MapperS.of(adjustableDate).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate())).getOrDefault(false)) {
				date = MapperS.of(adjustableDate).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()).get();
			} else {
				final FieldWithMetaDate fieldWithMetaDate = MapperS.of(adjustableDate).<FieldWithMetaDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).get();
				if (fieldWithMetaDate == null) {
					date = null;
				} else {
					date = fieldWithMetaDate.getValue();
				}
			}
			
			return date;
		}
	}
}
