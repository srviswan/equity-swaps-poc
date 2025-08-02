package cdm.observable.asset.meta;

import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.validation.BasketConstituentTypeFormatValidator;
import cdm.observable.asset.validation.BasketConstituentValidator;
import cdm.observable.asset.validation.exists.BasketConstituentOnlyExistsValidator;
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
@RosettaMeta(model=BasketConstituent.class)
public class BasketConstituentMeta implements RosettaMetaData<BasketConstituent> {

	@Override
	public List<Validator<? super BasketConstituent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.observable.asset.Observable>create(cdm.observable.asset.validation.datarule.ObservableChoice.class),
			factory.<cdm.observable.asset.BasketConstituent>create(cdm.observable.asset.validation.datarule.BasketConstituentBasketsOfBaskets.class)
		);
	}
	
	@Override
	public List<Function<? super BasketConstituent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BasketConstituent> validator() {
		return new BasketConstituentValidator();
	}

	@Override
	public Validator<? super BasketConstituent> typeFormatValidator() {
		return new BasketConstituentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasketConstituent, Set<String>> onlyExistsValidator() {
		return new BasketConstituentOnlyExistsValidator();
	}
}
