package cdm.product.collateral.meta;

import cdm.product.collateral.IssuerAgencyRating;
import cdm.product.collateral.validation.IssuerAgencyRatingTypeFormatValidator;
import cdm.product.collateral.validation.IssuerAgencyRatingValidator;
import cdm.product.collateral.validation.exists.IssuerAgencyRatingOnlyExistsValidator;
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
@RosettaMeta(model=IssuerAgencyRating.class)
public class IssuerAgencyRatingMeta implements RosettaMetaData<IssuerAgencyRating> {

	@Override
	public List<Validator<? super IssuerAgencyRating>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IssuerAgencyRating, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IssuerAgencyRating> validator() {
		return new IssuerAgencyRatingValidator();
	}

	@Override
	public Validator<? super IssuerAgencyRating> typeFormatValidator() {
		return new IssuerAgencyRatingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IssuerAgencyRating, Set<String>> onlyExistsValidator() {
		return new IssuerAgencyRatingOnlyExistsValidator();
	}
}
