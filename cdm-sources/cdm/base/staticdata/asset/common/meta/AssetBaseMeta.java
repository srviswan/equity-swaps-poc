package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.validation.AssetBaseTypeFormatValidator;
import cdm.base.staticdata.asset.common.validation.AssetBaseValidator;
import cdm.base.staticdata.asset.common.validation.exists.AssetBaseOnlyExistsValidator;
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
@RosettaMeta(model=AssetBase.class)
public class AssetBaseMeta implements RosettaMetaData<AssetBase> {

	@Override
	public List<Validator<? super AssetBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed.class),
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange.class)
		);
	}
	
	@Override
	public List<Function<? super AssetBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AssetBase> validator() {
		return new AssetBaseValidator();
	}

	@Override
	public Validator<? super AssetBase> typeFormatValidator() {
		return new AssetBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetBase, Set<String>> onlyExistsValidator() {
		return new AssetBaseOnlyExistsValidator();
	}
}
