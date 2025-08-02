package cdm.margin.schedule.meta;

import cdm.margin.schedule.StandardizedSchedule;
import cdm.margin.schedule.validation.StandardizedScheduleTypeFormatValidator;
import cdm.margin.schedule.validation.StandardizedScheduleValidator;
import cdm.margin.schedule.validation.exists.StandardizedScheduleOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.0.0
 */
@RosettaMeta(model=StandardizedSchedule.class)
public class StandardizedScheduleMeta implements RosettaMetaData<StandardizedSchedule> {

	@Override
	public List<Validator<? super StandardizedSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.margin.schedule.StandardizedSchedule>create(cdm.margin.schedule.validation.datarule.StandardizedSchedulePositiveNotional.class),
			factory.<cdm.margin.schedule.StandardizedSchedule>create(cdm.margin.schedule.validation.datarule.StandardizedScheduleValidCurrency.class),
			factory.<cdm.margin.schedule.StandardizedSchedule>create(cdm.margin.schedule.validation.datarule.StandardizedSchedulePositiveDuration.class)
		);
	}
	
	@Override
	public List<Function<? super StandardizedSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StandardizedSchedule> validator() {
		return new StandardizedScheduleValidator();
	}

	@Override
	public Validator<? super StandardizedSchedule> typeFormatValidator() {
		return new StandardizedScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StandardizedSchedule, Set<String>> onlyExistsValidator() {
		return new StandardizedScheduleOnlyExistsValidator();
	}
}
