package cdm.product.collateral.meta;

import cdm.product.collateral.SpecificAsset;
import cdm.product.collateral.validation.SpecificAssetTypeFormatValidator;
import cdm.product.collateral.validation.SpecificAssetValidator;
import cdm.product.collateral.validation.exists.SpecificAssetOnlyExistsValidator;
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
@RosettaMeta(model=SpecificAsset.class)
public class SpecificAssetMeta implements RosettaMetaData<SpecificAsset> {

	@Override
	public List<Validator<? super SpecificAsset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.Asset>create(cdm.base.staticdata.asset.common.validation.datarule.AssetChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SpecificAsset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SpecificAsset> validator() {
		return new SpecificAssetValidator();
	}

	@Override
	public Validator<? super SpecificAsset> typeFormatValidator() {
		return new SpecificAssetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SpecificAsset, Set<String>> onlyExistsValidator() {
		return new SpecificAssetOnlyExistsValidator();
	}
}
