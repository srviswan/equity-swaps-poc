package cdm.product.collateral.meta;

import cdm.product.collateral.SovereignAgencyRating;
import cdm.product.collateral.validation.SovereignAgencyRatingTypeFormatValidator;
import cdm.product.collateral.validation.SovereignAgencyRatingValidator;
import cdm.product.collateral.validation.exists.SovereignAgencyRatingOnlyExistsValidator;
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
@RosettaMeta(model=SovereignAgencyRating.class)
public class SovereignAgencyRatingMeta implements RosettaMetaData<SovereignAgencyRating> {

	@Override
	public List<Validator<? super SovereignAgencyRating>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SovereignAgencyRating, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SovereignAgencyRating> validator() {
		return new SovereignAgencyRatingValidator();
	}

	@Override
	public Validator<? super SovereignAgencyRating> typeFormatValidator() {
		return new SovereignAgencyRatingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SovereignAgencyRating, Set<String>> onlyExistsValidator() {
		return new SovereignAgencyRatingOnlyExistsValidator();
	}
}
