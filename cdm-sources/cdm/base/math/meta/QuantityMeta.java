package cdm.base.math.meta;

import cdm.base.math.Quantity;
import cdm.base.math.validation.QuantityTypeFormatValidator;
import cdm.base.math.validation.QuantityValidator;
import cdm.base.math.validation.exists.QuantityOnlyExistsValidator;
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
@RosettaMeta(model=Quantity.class)
public class QuantityMeta implements RosettaMetaData<Quantity> {

	@Override
	public List<Validator<? super Quantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.math.MeasureSchedule>create(cdm.base.math.validation.datarule.MeasureScheduleValueExists.class),
			factory.<cdm.base.math.QuantitySchedule>create(cdm.base.math.validation.datarule.QuantityScheduleQuantityMultiplier.class),
			factory.<cdm.base.math.QuantitySchedule>create(cdm.base.math.validation.datarule.QuantityScheduleUnitOfAmountExists.class),
			factory.<cdm.base.math.Quantity>create(cdm.base.math.validation.datarule.QuantityAmountOnlyExists.class)
		);
	}
	
	@Override
	public List<Function<? super Quantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Quantity> validator() {
		return new QuantityValidator();
	}

	@Override
	public Validator<? super Quantity> typeFormatValidator() {
		return new QuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Quantity, Set<String>> onlyExistsValidator() {
		return new QuantityOnlyExistsValidator();
	}
}
