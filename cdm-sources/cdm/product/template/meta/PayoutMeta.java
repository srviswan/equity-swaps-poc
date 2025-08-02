package cdm.product.template.meta;

import cdm.product.template.Payout;
import cdm.product.template.validation.PayoutTypeFormatValidator;
import cdm.product.template.validation.PayoutValidator;
import cdm.product.template.validation.exists.PayoutOnlyExistsValidator;
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
@RosettaMeta(model=Payout.class)
public class PayoutMeta implements RosettaMetaData<Payout> {

	@Override
	public List<Validator<? super Payout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.product.template.Payout>create(cdm.product.template.validation.datarule.PayoutChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Payout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Payout> validator() {
		return new PayoutValidator();
	}

	@Override
	public Validator<? super Payout> typeFormatValidator() {
		return new PayoutTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Payout, Set<String>> onlyExistsValidator() {
		return new PayoutOnlyExistsValidator();
	}
}
