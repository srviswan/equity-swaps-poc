package cdm.observable.asset.meta;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.validation.PriceScheduleTypeFormatValidator;
import cdm.observable.asset.validation.PriceScheduleValidator;
import cdm.observable.asset.validation.exists.PriceScheduleOnlyExistsValidator;
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
@RosettaMeta(model=PriceSchedule.class)
public class PriceScheduleMeta implements RosettaMetaData<PriceSchedule> {

	@Override
	public List<Validator<? super PriceSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.math.MeasureSchedule>create(cdm.base.math.validation.datarule.MeasureScheduleValueExists.class),
			factory.<cdm.observable.asset.PriceSchedule>create(cdm.observable.asset.validation.datarule.PriceScheduleUnitOfAmountExists.class),
			factory.<cdm.observable.asset.PriceSchedule>create(cdm.observable.asset.validation.datarule.PriceSchedulePositiveAssetPrice.class),
			factory.<cdm.observable.asset.PriceSchedule>create(cdm.observable.asset.validation.datarule.PriceSchedulePositiveSpotRate.class),
			factory.<cdm.observable.asset.PriceSchedule>create(cdm.observable.asset.validation.datarule.PriceSchedulePositiveCashPrice.class),
			factory.<cdm.observable.asset.PriceSchedule>create(cdm.observable.asset.validation.datarule.PriceScheduleCurrencyUnitForInterestRate.class),
			factory.<cdm.observable.asset.PriceSchedule>create(cdm.observable.asset.validation.datarule.PriceScheduleChoice.class),
			factory.<cdm.observable.asset.PriceSchedule>create(cdm.observable.asset.validation.datarule.PriceScheduleCashPrice.class),
			factory.<cdm.observable.asset.PriceSchedule>create(cdm.observable.asset.validation.datarule.PriceScheduleArithmeticOperator.class),
			factory.<cdm.observable.asset.PriceSchedule>create(cdm.observable.asset.validation.datarule.PriceScheduleSpreadPrice.class),
			factory.<cdm.observable.asset.PriceSchedule>create(cdm.observable.asset.validation.datarule.PriceScheduleForwardPoint.class),
			factory.<cdm.observable.asset.PriceSchedule>create(cdm.observable.asset.validation.datarule.PriceScheduleAccruedInterest.class)
		);
	}
	
	@Override
	public List<Function<? super PriceSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PriceSchedule> validator() {
		return new PriceScheduleValidator();
	}

	@Override
	public Validator<? super PriceSchedule> typeFormatValidator() {
		return new PriceScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PriceSchedule, Set<String>> onlyExistsValidator() {
		return new PriceScheduleOnlyExistsValidator();
	}
}
