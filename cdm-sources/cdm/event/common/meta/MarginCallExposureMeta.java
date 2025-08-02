package cdm.event.common.meta;

import cdm.event.common.MarginCallExposure;
import cdm.event.common.validation.MarginCallExposureTypeFormatValidator;
import cdm.event.common.validation.MarginCallExposureValidator;
import cdm.event.common.validation.exists.MarginCallExposureOnlyExistsValidator;
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
@RosettaMeta(model=MarginCallExposure.class)
public class MarginCallExposureMeta implements RosettaMetaData<MarginCallExposure> {

	@Override
	public List<Validator<? super MarginCallExposure>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.event.common.MarginCallBase>create(cdm.event.common.validation.datarule.MarginCallBaseRegIMRoleIMOnly.class),
			factory.<cdm.event.common.MarginCallExposure>create(cdm.event.common.validation.datarule.MarginCallExposureOverallExposureSumOfSimmAndScheduleIM.class),
			factory.<cdm.event.common.MarginCallExposure>create(cdm.event.common.validation.datarule.MarginCallExposureExposureSimmAndScheduleIMOnly.class)
		);
	}
	
	@Override
	public List<Function<? super MarginCallExposure, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MarginCallExposure> validator() {
		return new MarginCallExposureValidator();
	}

	@Override
	public Validator<? super MarginCallExposure> typeFormatValidator() {
		return new MarginCallExposureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MarginCallExposure, Set<String>> onlyExistsValidator() {
		return new MarginCallExposureOnlyExistsValidator();
	}
}
