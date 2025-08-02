package cdm.product.collateral.meta;

import cdm.product.collateral.AssetCountryOfOrigin;
import cdm.product.collateral.validation.AssetCountryOfOriginTypeFormatValidator;
import cdm.product.collateral.validation.AssetCountryOfOriginValidator;
import cdm.product.collateral.validation.exists.AssetCountryOfOriginOnlyExistsValidator;
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
@RosettaMeta(model=AssetCountryOfOrigin.class)
public class AssetCountryOfOriginMeta implements RosettaMetaData<AssetCountryOfOrigin> {

	@Override
	public List<Validator<? super AssetCountryOfOrigin>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetCountryOfOrigin, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AssetCountryOfOrigin> validator() {
		return new AssetCountryOfOriginValidator();
	}

	@Override
	public Validator<? super AssetCountryOfOrigin> typeFormatValidator() {
		return new AssetCountryOfOriginTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetCountryOfOrigin, Set<String>> onlyExistsValidator() {
		return new AssetCountryOfOriginOnlyExistsValidator();
	}
}
