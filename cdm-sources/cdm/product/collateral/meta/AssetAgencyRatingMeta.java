package cdm.product.collateral.meta;

import cdm.product.collateral.AssetAgencyRating;
import cdm.product.collateral.validation.AssetAgencyRatingTypeFormatValidator;
import cdm.product.collateral.validation.AssetAgencyRatingValidator;
import cdm.product.collateral.validation.exists.AssetAgencyRatingOnlyExistsValidator;
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
@RosettaMeta(model=AssetAgencyRating.class)
public class AssetAgencyRatingMeta implements RosettaMetaData<AssetAgencyRating> {

	@Override
	public List<Validator<? super AssetAgencyRating>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetAgencyRating, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AssetAgencyRating> validator() {
		return new AssetAgencyRatingValidator();
	}

	@Override
	public Validator<? super AssetAgencyRating> typeFormatValidator() {
		return new AssetAgencyRatingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetAgencyRating, Set<String>> onlyExistsValidator() {
		return new AssetAgencyRatingOnlyExistsValidator();
	}
}
