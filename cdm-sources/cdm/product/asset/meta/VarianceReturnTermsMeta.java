package cdm.product.asset.meta;

import cdm.product.asset.VarianceReturnTerms;
import cdm.product.asset.validation.VarianceReturnTermsTypeFormatValidator;
import cdm.product.asset.validation.VarianceReturnTermsValidator;
import cdm.product.asset.validation.exists.VarianceReturnTermsOnlyExistsValidator;
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
@RosettaMeta(model=VarianceReturnTerms.class)
public class VarianceReturnTermsMeta implements RosettaMetaData<VarianceReturnTerms> {

	@Override
	public List<Validator<? super VarianceReturnTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.product.asset.ReturnTermsBase>create(cdm.product.asset.validation.datarule.ReturnTermsBaseInitialLevelOrInitialLevelSource.class),
			factory.<cdm.product.asset.ReturnTermsBase>create(cdm.product.asset.validation.datarule.ReturnTermsBasePositiveExpectedN.class),
			factory.<cdm.product.asset.VarianceReturnTerms>create(cdm.product.asset.validation.datarule.VarianceReturnTermsPositiveVegaNotionalAmount.class),
			factory.<cdm.product.asset.VarianceReturnTerms>create(cdm.product.asset.validation.datarule.VarianceReturnTermsUnderlierMustBeListedDerivative.class),
			factory.<cdm.product.asset.VarianceReturnTerms>create(cdm.product.asset.validation.datarule.VarianceReturnTermsReferenceContract.class),
			factory.<cdm.product.asset.VarianceReturnTerms>create(cdm.product.asset.validation.datarule.VarianceReturnTermsStrikePriceMustExist.class),
			factory.<cdm.product.asset.VarianceReturnTerms>create(cdm.product.asset.validation.datarule.VarianceReturnTermsNonNegativeStrikePrice.class)
		);
	}
	
	@Override
	public List<Function<? super VarianceReturnTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VarianceReturnTerms> validator() {
		return new VarianceReturnTermsValidator();
	}

	@Override
	public Validator<? super VarianceReturnTerms> typeFormatValidator() {
		return new VarianceReturnTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VarianceReturnTerms, Set<String>> onlyExistsValidator() {
		return new VarianceReturnTermsOnlyExistsValidator();
	}
}
