package cdm.observable.asset.meta;

import cdm.observable.asset.Basket;
import cdm.observable.asset.validation.BasketTypeFormatValidator;
import cdm.observable.asset.validation.BasketValidator;
import cdm.observable.asset.validation.exists.BasketOnlyExistsValidator;
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
@RosettaMeta(model=Basket.class)
public class BasketMeta implements RosettaMetaData<Basket> {

	@Override
	public List<Validator<? super Basket>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed.class),
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange.class)
		);
	}
	
	@Override
	public List<Function<? super Basket, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Basket> validator() {
		return new BasketValidator();
	}

	@Override
	public Validator<? super Basket> typeFormatValidator() {
		return new BasketTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Basket, Set<String>> onlyExistsValidator() {
		return new BasketOnlyExistsValidator();
	}
}
