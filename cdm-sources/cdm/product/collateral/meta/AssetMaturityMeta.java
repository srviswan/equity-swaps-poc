package cdm.product.collateral.meta;

import cdm.product.collateral.AssetMaturity;
import cdm.product.collateral.validation.AssetMaturityTypeFormatValidator;
import cdm.product.collateral.validation.AssetMaturityValidator;
import cdm.product.collateral.validation.exists.AssetMaturityOnlyExistsValidator;
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
@RosettaMeta(model=AssetMaturity.class)
public class AssetMaturityMeta implements RosettaMetaData<AssetMaturity> {

	@Override
	public List<Validator<? super AssetMaturity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetMaturity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AssetMaturity> validator() {
		return new AssetMaturityValidator();
	}

	@Override
	public Validator<? super AssetMaturity> typeFormatValidator() {
		return new AssetMaturityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetMaturity, Set<String>> onlyExistsValidator() {
		return new AssetMaturityOnlyExistsValidator();
	}
}
