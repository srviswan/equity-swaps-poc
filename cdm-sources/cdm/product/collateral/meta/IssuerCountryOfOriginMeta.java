package cdm.product.collateral.meta;

import cdm.product.collateral.IssuerCountryOfOrigin;
import cdm.product.collateral.validation.IssuerCountryOfOriginTypeFormatValidator;
import cdm.product.collateral.validation.IssuerCountryOfOriginValidator;
import cdm.product.collateral.validation.exists.IssuerCountryOfOriginOnlyExistsValidator;
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
@RosettaMeta(model=IssuerCountryOfOrigin.class)
public class IssuerCountryOfOriginMeta implements RosettaMetaData<IssuerCountryOfOrigin> {

	@Override
	public List<Validator<? super IssuerCountryOfOrigin>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IssuerCountryOfOrigin, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IssuerCountryOfOrigin> validator() {
		return new IssuerCountryOfOriginValidator();
	}

	@Override
	public Validator<? super IssuerCountryOfOrigin> typeFormatValidator() {
		return new IssuerCountryOfOriginTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IssuerCountryOfOrigin, Set<String>> onlyExistsValidator() {
		return new IssuerCountryOfOriginOnlyExistsValidator();
	}
}
