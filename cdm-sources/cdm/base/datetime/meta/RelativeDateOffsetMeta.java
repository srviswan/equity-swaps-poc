package cdm.base.datetime.meta;

import cdm.base.datetime.RelativeDateOffset;
import cdm.base.datetime.validation.RelativeDateOffsetTypeFormatValidator;
import cdm.base.datetime.validation.RelativeDateOffsetValidator;
import cdm.base.datetime.validation.exists.RelativeDateOffsetOnlyExistsValidator;
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
@RosettaMeta(model=RelativeDateOffset.class)
public class RelativeDateOffsetMeta implements RosettaMetaData<RelativeDateOffset> {

	@Override
	public List<Validator<? super RelativeDateOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.datetime.Period>create(cdm.base.datetime.validation.datarule.PeriodDayPeriod.class),
			factory.<cdm.base.datetime.Offset>create(cdm.base.datetime.validation.datarule.OffsetDayType.class)
		);
	}
	
	@Override
	public List<Function<? super RelativeDateOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RelativeDateOffset> validator() {
		return new RelativeDateOffsetValidator();
	}

	@Override
	public Validator<? super RelativeDateOffset> typeFormatValidator() {
		return new RelativeDateOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelativeDateOffset, Set<String>> onlyExistsValidator() {
		return new RelativeDateOffsetOnlyExistsValidator();
	}
}
