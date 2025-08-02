package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.validation.CashTypeFormatValidator;
import cdm.base.staticdata.asset.common.validation.CashValidator;
import cdm.base.staticdata.asset.common.validation.exists.CashOnlyExistsValidator;
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
@RosettaMeta(model=Cash.class)
public class CashMeta implements RosettaMetaData<Cash> {

	@Override
	public List<Validator<? super Cash>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed.class),
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange.class),
			factory.<cdm.base.staticdata.asset.common.Cash>create(cdm.base.staticdata.asset.common.validation.datarule.CashCurrencyExists.class),
			factory.<cdm.base.staticdata.asset.common.Cash>create(cdm.base.staticdata.asset.common.validation.datarule.CashNoTaxonomy.class),
			factory.<cdm.base.staticdata.asset.common.Cash>create(cdm.base.staticdata.asset.common.validation.datarule.CashNoExchange.class)
		);
	}
	
	@Override
	public List<Function<? super Cash, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Cash> validator() {
		return new CashValidator();
	}

	@Override
	public Validator<? super Cash> typeFormatValidator() {
		return new CashTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Cash, Set<String>> onlyExistsValidator() {
		return new CashOnlyExistsValidator();
	}
}
