package cdm.product.collateral.meta;

import cdm.product.collateral.IssuerName;
import cdm.product.collateral.validation.IssuerNameTypeFormatValidator;
import cdm.product.collateral.validation.IssuerNameValidator;
import cdm.product.collateral.validation.exists.IssuerNameOnlyExistsValidator;
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
@RosettaMeta(model=IssuerName.class)
public class IssuerNameMeta implements RosettaMetaData<IssuerName> {

	@Override
	public List<Validator<? super IssuerName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IssuerName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IssuerName> validator() {
		return new IssuerNameValidator();
	}

	@Override
	public Validator<? super IssuerName> typeFormatValidator() {
		return new IssuerNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IssuerName, Set<String>> onlyExistsValidator() {
		return new IssuerNameOnlyExistsValidator();
	}
}
