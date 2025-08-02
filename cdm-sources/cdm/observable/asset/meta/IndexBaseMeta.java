package cdm.observable.asset.meta;

import cdm.observable.asset.IndexBase;
import cdm.observable.asset.validation.IndexBaseTypeFormatValidator;
import cdm.observable.asset.validation.IndexBaseValidator;
import cdm.observable.asset.validation.exists.IndexBaseOnlyExistsValidator;
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
@RosettaMeta(model=IndexBase.class)
public class IndexBaseMeta implements RosettaMetaData<IndexBase> {

	@Override
	public List<Validator<? super IndexBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed.class),
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange.class)
		);
	}
	
	@Override
	public List<Function<? super IndexBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IndexBase> validator() {
		return new IndexBaseValidator();
	}

	@Override
	public Validator<? super IndexBase> typeFormatValidator() {
		return new IndexBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndexBase, Set<String>> onlyExistsValidator() {
		return new IndexBaseOnlyExistsValidator();
	}
}
