package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.DigitalAsset;
import cdm.base.staticdata.asset.common.validation.DigitalAssetTypeFormatValidator;
import cdm.base.staticdata.asset.common.validation.DigitalAssetValidator;
import cdm.base.staticdata.asset.common.validation.exists.DigitalAssetOnlyExistsValidator;
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
@RosettaMeta(model=DigitalAsset.class)
public class DigitalAssetMeta implements RosettaMetaData<DigitalAsset> {

	@Override
	public List<Validator<? super DigitalAsset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed.class),
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange.class)
		);
	}
	
	@Override
	public List<Function<? super DigitalAsset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DigitalAsset> validator() {
		return new DigitalAssetValidator();
	}

	@Override
	public Validator<? super DigitalAsset> typeFormatValidator() {
		return new DigitalAssetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DigitalAsset, Set<String>> onlyExistsValidator() {
		return new DigitalAssetOnlyExistsValidator();
	}
}
