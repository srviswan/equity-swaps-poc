package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.FxFixingDate;
import cdm.product.common.settlement.validation.FxFixingDateTypeFormatValidator;
import cdm.product.common.settlement.validation.FxFixingDateValidator;
import cdm.product.common.settlement.validation.exists.FxFixingDateOnlyExistsValidator;
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
@RosettaMeta(model=FxFixingDate.class)
public class FxFixingDateMeta implements RosettaMetaData<FxFixingDate> {

	@Override
	public List<Validator<? super FxFixingDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.datetime.Period>create(cdm.base.datetime.validation.datarule.PeriodDayPeriod.class),
			factory.<cdm.base.datetime.Offset>create(cdm.base.datetime.validation.datarule.OffsetDayType.class),
			factory.<cdm.product.common.settlement.FxFixingDate>create(cdm.product.common.settlement.validation.datarule.FxFixingDateBusinessCentersChoice.class),
			factory.<cdm.product.common.settlement.FxFixingDate>create(cdm.product.common.settlement.validation.datarule.FxFixingDateDateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxFixingDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxFixingDate> validator() {
		return new FxFixingDateValidator();
	}

	@Override
	public Validator<? super FxFixingDate> typeFormatValidator() {
		return new FxFixingDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFixingDate, Set<String>> onlyExistsValidator() {
		return new FxFixingDateOnlyExistsValidator();
	}
}
