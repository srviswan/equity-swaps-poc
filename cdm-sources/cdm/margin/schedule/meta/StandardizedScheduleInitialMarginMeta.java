package cdm.margin.schedule.meta;

import cdm.margin.schedule.StandardizedScheduleInitialMargin;
import cdm.margin.schedule.validation.StandardizedScheduleInitialMarginTypeFormatValidator;
import cdm.margin.schedule.validation.StandardizedScheduleInitialMarginValidator;
import cdm.margin.schedule.validation.exists.StandardizedScheduleInitialMarginOnlyExistsValidator;
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
@RosettaMeta(model=StandardizedScheduleInitialMargin.class)
public class StandardizedScheduleInitialMarginMeta implements RosettaMetaData<StandardizedScheduleInitialMargin> {

	@Override
	public List<Validator<? super StandardizedScheduleInitialMargin>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.margin.schedule.StandardizedScheduleInitialMargin>create(cdm.margin.schedule.validation.datarule.StandardizedScheduleInitialMarginNonNegativeNetInitialMargin.class)
		);
	}
	
	@Override
	public List<Function<? super StandardizedScheduleInitialMargin, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StandardizedScheduleInitialMargin> validator() {
		return new StandardizedScheduleInitialMarginValidator();
	}

	@Override
	public Validator<? super StandardizedScheduleInitialMargin> typeFormatValidator() {
		return new StandardizedScheduleInitialMarginTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StandardizedScheduleInitialMargin, Set<String>> onlyExistsValidator() {
		return new StandardizedScheduleInitialMarginOnlyExistsValidator();
	}
}
